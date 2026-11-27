package io.dcloud.common.util.db;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class DCSQLiteOpenHelper extends android.database.sqlite.SQLiteOpenHelper {
    static final java.lang.String COLUMN_KEY = "key";
    static final java.lang.String COLUMN_TIMESTAMP = "timestamp";
    static final java.lang.String COLUMN_VALUE = "value";
    private static final java.lang.String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS default_wx_storage (key TEXT PRIMARY KEY,value TEXT NOT NULL,timestamp TEXT NOT NULL)";
    private static final java.lang.String DATABASE_NAME = "DCStorage";
    private static final int DATABASE_VERSION = 1;
    private static final int SLEEP_TIME_MS = 30;
    static final java.lang.String TABLE_STORAGE = "default_wx_storage";
    static final java.lang.String TAG_STORAGE = "dc_storage";
    private static io.dcloud.common.util.db.DCSQLiteOpenHelper mInstance;
    static java.text.SimpleDateFormat sDateFormatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss", java.util.Locale.getDefault());
    private android.content.Context mContext;
    private android.database.sqlite.SQLiteDatabase mDb;

    private DCSQLiteOpenHelper(android.content.Context context) {
        super(context, DATABASE_NAME, (android.database.sqlite.SQLiteDatabase.CursorFactory) null, 1);
        this.mContext = context;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x002c  */
    private void createTableIfNotExists(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        android.database.Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = sQLiteDatabase.rawQuery("SELECT DISTINCT tbl_name FROM sqlite_master WHERE tbl_name = 'default_wx_storage'", null);
                if (cursorRawQuery != null && cursorRawQuery.getCount() > 0) {
                    cursorRawQuery.close();
                    return;
                }
                sQLiteDatabase.execSQL(CREATE_TABLE);
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                    return;
                }
                return;
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                    return;
                }
                return;
            }
        } catch (java.lang.Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
        if (cursorRawQuery != null) {
            cursorRawQuery.close();
        }
        throw th;
    }

    private boolean deleteDB() {
        closeDatabase();
        return this.mContext.deleteDatabase(DATABASE_NAME);
    }

    public static io.dcloud.common.util.db.DCSQLiteOpenHelper getSQLiteOpenHelper(android.content.Context context) {
        if (mInstance == null) {
            mInstance = new io.dcloud.common.util.db.DCSQLiteOpenHelper(context);
        }
        return mInstance;
    }

    public synchronized void closeDatabase() {
        android.database.sqlite.SQLiteDatabase sQLiteDatabase = this.mDb;
        if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
            this.mDb.close();
            this.mDb = null;
        }
        mInstance = null;
    }

    synchronized void ensureDatabase(java.lang.String str) {
        android.database.sqlite.SQLiteDatabase sQLiteDatabase = this.mDb;
        if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
            createTableIfNotExists(this.mDb, str);
            return;
        }
        for (int i = 0; i < 2; i++) {
            if (i > 0) {
                try {
                    try {
                        deleteDB();
                    } catch (android.database.sqlite.SQLiteException e) {
                        e.printStackTrace();
                        try {
                            java.lang.Thread.sleep(30L);
                        } catch (java.lang.InterruptedException unused) {
                            java.lang.Thread.currentThread().interrupt();
                        }
                    }
                } catch (java.lang.Throwable th) {
                    this.mDb = null;
                    io.dcloud.common.adapter.util.Logger.d(TAG_STORAGE, "ensureDatabase failed, throwable = " + th.getMessage());
                }
            }
            this.mDb = getWritableDatabase();
        }
        if (this.mDb != null) {
            if (android.text.TextUtils.isEmpty(str)) {
                createTableIfNotExists(this.mDb);
            } else {
                createTableIfNotExists(this.mDb, str);
            }
        }
    }

    public android.database.sqlite.SQLiteDatabase getDatabase() {
        ensureDatabase(null);
        return this.mDb;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public android.database.sqlite.SQLiteDatabase getDatabase(java.lang.String str) {
        ensureDatabase(str);
        return this.mDb;
    }

    private void createTableIfNotExists(android.database.sqlite.SQLiteDatabase sQLiteDatabase, java.lang.String str) {
        android.database.Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = sQLiteDatabase.rawQuery("SELECT DISTINCT tbl_name FROM sqlite_master WHERE tbl_name = ?", new java.lang.String[]{str});
                if (cursorRawQuery != null && cursorRawQuery.getCount() > 0) {
                    cursorRawQuery.close();
                    return;
                }
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS " + str + " (key TEXT PRIMARY KEY,value TEXT NOT NULL,timestamp TEXT NOT NULL)");
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
            }
        } catch (java.lang.Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }
}
