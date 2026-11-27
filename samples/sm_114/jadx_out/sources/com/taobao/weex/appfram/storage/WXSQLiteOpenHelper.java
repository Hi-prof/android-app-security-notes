package com.taobao.weex.appfram.storage;

/* JADX INFO: loaded from: classes.dex */
public class WXSQLiteOpenHelper extends android.database.sqlite.SQLiteOpenHelper {
    static final java.lang.String COLUMN_KEY = "key";
    static final java.lang.String COLUMN_PERSISTENT = "persistent";
    static final java.lang.String COLUMN_TIMESTAMP = "timestamp";
    static final java.lang.String COLUMN_VALUE = "value";
    private static final java.lang.String DATABASE_NAME = "WXStorage";
    private static final int DATABASE_VERSION = 2;
    private static final int SLEEP_TIME_MS = 30;
    private static final java.lang.String STATEMENT_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS default_wx_storage (key TEXT PRIMARY KEY,value TEXT NOT NULL,timestamp TEXT NOT NULL,persistent INTEGER DEFAULT 0)";
    static final java.lang.String TABLE_STORAGE = "default_wx_storage";
    static final java.lang.String TAG_STORAGE = "weex_storage";
    static java.text.SimpleDateFormat sDateFormatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss", java.util.Locale.getDefault());
    private android.content.Context mContext;
    private android.database.sqlite.SQLiteDatabase mDb;
    private long mMaximumDatabaseSize;

    public WXSQLiteOpenHelper(android.content.Context context) {
        super(context, DATABASE_NAME, (android.database.sqlite.SQLiteDatabase.CursorFactory) null, 2);
        this.mMaximumDatabaseSize = 52428800L;
        this.mContext = context;
    }

    public android.database.sqlite.SQLiteDatabase getDatabase() {
        ensureDatabase();
        return this.mDb;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(STATEMENT_CREATE_TABLE);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i != i2) {
            if (i2 == 2 && i == 1) {
                com.taobao.weex.utils.WXLogUtils.d(TAG_STORAGE, "storage is updating from version " + i + " to version " + i2);
                try {
                    try {
                        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
                        sQLiteDatabase.beginTransaction();
                        com.taobao.weex.utils.WXLogUtils.d(TAG_STORAGE, "exec sql : ALTER TABLE default_wx_storage ADD COLUMN timestamp TEXT;");
                        sQLiteDatabase.execSQL("ALTER TABLE default_wx_storage ADD COLUMN timestamp TEXT;");
                        com.taobao.weex.utils.WXLogUtils.d(TAG_STORAGE, "exec sql : ALTER TABLE default_wx_storage ADD COLUMN persistent INTEGER;");
                        sQLiteDatabase.execSQL("ALTER TABLE default_wx_storage ADD COLUMN persistent INTEGER;");
                        java.lang.String str = "UPDATE default_wx_storage SET timestamp = '" + sDateFormatter.format(new java.util.Date()) + "' , persistent = 0";
                        com.taobao.weex.utils.WXLogUtils.d(TAG_STORAGE, "exec sql : " + str);
                        sQLiteDatabase.execSQL(str);
                        sQLiteDatabase.setTransactionSuccessful();
                        com.taobao.weex.utils.WXLogUtils.d(TAG_STORAGE, "storage updated success (" + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis) + "ms)");
                        sQLiteDatabase.endTransaction();
                    } catch (java.lang.Exception e) {
                        com.taobao.weex.utils.WXLogUtils.d(TAG_STORAGE, "storage updated failed from version " + i + " to version " + i2 + "," + e.getMessage());
                        sQLiteDatabase.endTransaction();
                        com.taobao.weex.utils.WXLogUtils.d(TAG_STORAGE, "storage is rollback,all data will be removed");
                        deleteDB();
                        onCreate(sQLiteDatabase);
                    }
                    return;
                } catch (java.lang.Throwable th) {
                    sQLiteDatabase.endTransaction();
                    throw th;
                }
            }
            deleteDB();
            onCreate(sQLiteDatabase);
        }
    }

    synchronized void ensureDatabase() {
        android.database.sqlite.SQLiteDatabase sQLiteDatabase = this.mDb;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
            for (int i = 0; i < 2; i++) {
                if (i > 0) {
                    try {
                        deleteDB();
                    } catch (android.database.sqlite.SQLiteException e) {
                        try {
                            e.printStackTrace();
                            try {
                                java.lang.Thread.sleep(30L);
                            } catch (java.lang.InterruptedException unused) {
                                java.lang.Thread.currentThread().interrupt();
                            }
                        } catch (java.lang.Throwable th) {
                            this.mDb = null;
                            com.taobao.weex.utils.WXLogUtils.d(TAG_STORAGE, "ensureDatabase failed, throwable = " + th.getMessage());
                        }
                    }
                }
                this.mDb = getWritableDatabase();
            }
            android.database.sqlite.SQLiteDatabase sQLiteDatabase2 = this.mDb;
            if (sQLiteDatabase2 == null) {
                return;
            }
            createTableIfNotExists(sQLiteDatabase2);
            this.mDb.setMaximumSize(this.mMaximumDatabaseSize);
        }
    }

    public synchronized void setMaximumSize(long j) {
        this.mMaximumDatabaseSize = j;
        android.database.sqlite.SQLiteDatabase sQLiteDatabase = this.mDb;
        if (sQLiteDatabase != null) {
            sQLiteDatabase.setMaximumSize(j);
        }
    }

    private boolean deleteDB() {
        closeDatabase();
        return this.mContext.deleteDatabase(DATABASE_NAME);
    }

    public synchronized void closeDatabase() {
        android.database.sqlite.SQLiteDatabase sQLiteDatabase = this.mDb;
        if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
            this.mDb.close();
            this.mDb = null;
        }
    }

    private void createTableIfNotExists(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        android.database.Cursor cursorRawQuery = null;
        try {
            cursorRawQuery = sQLiteDatabase.rawQuery("SELECT DISTINCT tbl_name FROM sqlite_master WHERE tbl_name = 'default_wx_storage'", null);
            if (cursorRawQuery == null || cursorRawQuery.getCount() <= 0) {
                sQLiteDatabase.execSQL(STATEMENT_CREATE_TABLE);
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        } finally {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        }
    }
}
