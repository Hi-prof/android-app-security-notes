package io.dcloud.common.util.db;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class DCStorage {
    public static final int ERROR_DEF = -1;
    public static final int ERROR_FULL = -2;
    public static final int ERROR_NO_KEY = -3;
    public static final int SUCCESS = 1;
    private static io.dcloud.common.util.db.DCStorage mInstance;
    private io.dcloud.common.util.db.DCSQLiteOpenHelper mDatabaseSupplier;
    private java.util.concurrent.ExecutorService mExecutorService;
    private java.lang.String TABLET_TAG = "_storage";
    private java.lang.String DBFILE_NAME = "_dbfile";
    private java.lang.String DCDBFILE_START = "DCDBFile_";
    private java.lang.String ERROR_TAG = "__ERROR__";

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public class StorageInfo {
        public int code;
        public java.lang.String meg;
        public java.lang.Object v;

        public StorageInfo() {
        }
    }

    private DCStorage(android.content.Context context) {
        this.mDatabaseSupplier = io.dcloud.common.util.db.DCSQLiteOpenHelper.getSQLiteOpenHelper(context);
    }

    private void clearDBFile(android.content.Context context, java.lang.String str) {
        java.io.File file = new java.io.File(getBaseDBFilePath(context, str));
        if (file.exists()) {
            file.delete();
        }
    }

    private java.lang.String getBaseDBFilePath(android.content.Context context, java.lang.String str) {
        return context.getFilesDir().getAbsolutePath() + "/apps/" + str + "/dbfile/";
    }

    private java.lang.String getCurrentTableName(java.lang.String str) {
        return "DC_" + java.lang.Math.abs(str.hashCode()) + this.TABLET_TAG;
    }

    public static io.dcloud.common.util.db.DCStorage getDCStorage(android.content.Context context) {
        if (mInstance == null && context != null) {
            mInstance = new io.dcloud.common.util.db.DCStorage(context);
        }
        return mInstance;
    }

    private java.lang.String getMsgForCode(android.content.Context context, int i) {
        if (i == -3) {
            return context.getString(io.dcloud.base.R.string.dcloud_storage_not_find_error);
        }
        if (i != -2) {
            return i != 1 ? "" : context.getString(io.dcloud.base.R.string.dcloud_storage_success);
        }
        return context.getString(io.dcloud.base.R.string.dcloud_storage_ceiling_error);
    }

    private void removeDBFile(android.content.Context context, java.lang.String str, java.lang.String str2) {
        removeDBFile(getBaseDBFilePath(context, str) + str2 + this.DBFILE_NAME);
    }

    private java.lang.String saveDBFileValue(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        java.lang.String baseDBFilePath = getBaseDBFilePath(context, str);
        java.io.File file = new java.io.File(baseDBFilePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (file.isFile()) {
            file.delete();
            file.mkdirs();
        }
        java.lang.String str4 = baseDBFilePath + str2.hashCode() + this.DBFILE_NAME;
        java.io.File file2 = new java.io.File(str4);
        if (file2.exists()) {
            file2.delete();
        }
        try {
            file2.createNewFile();
            java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(str4);
            fileOutputStream.write(str3.getBytes());
            fileOutputStream.close();
            return this.DCDBFILE_START + str4;
        } catch (java.io.IOException e) {
            e.printStackTrace();
            return this.ERROR_TAG + e.getMessage() + str4;
        }
    }

    public synchronized void checkSPstorageToDB(android.content.Context context, java.lang.String str) {
        android.content.SharedPreferences orCreateBundle = io.dcloud.common.adapter.util.SP.getOrCreateBundle(context, str + "_storages");
        android.content.SharedPreferences.Editor editorEdit = orCreateBundle.edit();
        java.util.Map<java.lang.String, ?> all = orCreateBundle.getAll();
        if (all != null && all.size() > 0) {
            for (java.lang.String str2 : all.keySet()) {
                if (performSetItem(context, str, str2, (java.lang.String) all.get(str2)).code == 1) {
                    editorEdit.remove(str2);
                }
            }
        }
        editorEdit.commit();
    }

    public void close() {
        execute(new java.lang.Runnable() { // from class: io.dcloud.common.util.db.DCStorage.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (io.dcloud.common.util.db.DCStorage.this.mDatabaseSupplier != null) {
                        io.dcloud.common.util.db.DCStorage.this.mDatabaseSupplier.closeDatabase();
                    }
                    if (io.dcloud.common.util.db.DCStorage.this.mExecutorService != null) {
                        io.dcloud.common.util.db.DCStorage.this.mExecutorService.shutdown();
                    }
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
                io.dcloud.common.util.db.DCStorage.this.mExecutorService = null;
            }
        });
    }

    public void execute(java.lang.Runnable runnable) {
        if (this.mExecutorService == null) {
            this.mExecutorService = java.util.concurrent.Executors.newSingleThreadExecutor();
        }
        if (runnable == null || this.mExecutorService.isShutdown() || this.mExecutorService.isTerminated()) {
            return;
        }
        this.mExecutorService.execute(runnable);
    }

    public synchronized java.lang.Long getDBCurrentLength(java.lang.String str) {
        android.database.sqlite.SQLiteDatabase database = this.mDatabaseSupplier.getDatabase(getCurrentTableName(str));
        if (database == null) {
            return 0L;
        }
        java.io.File file = new java.io.File(database.getPath());
        if (!file.exists()) {
            return 0L;
        }
        return java.lang.Long.valueOf(file.length());
    }

    public synchronized java.lang.Long getDBMaxLength(java.lang.String str) {
        android.database.sqlite.SQLiteDatabase database = this.mDatabaseSupplier.getDatabase(getCurrentTableName(str));
        if (database == null) {
            return 0L;
        }
        return java.lang.Long.valueOf(database.getMaximumSize());
    }

    public synchronized io.dcloud.common.util.db.DCStorage.StorageInfo performClear(android.content.Context context, java.lang.String str) {
        android.database.sqlite.SQLiteDatabase database = this.mDatabaseSupplier.getDatabase(getCurrentTableName(str));
        io.dcloud.common.util.db.DCStorage.StorageInfo storageInfo = new io.dcloud.common.util.db.DCStorage.StorageInfo();
        if (database == null) {
            storageInfo.code = -1;
            storageInfo.meg = context.getString(io.dcloud.base.R.string.dcloud_storage_no_db_error);
            return storageInfo;
        }
        storageInfo.code = 1;
        try {
            database.execSQL("delete from " + getCurrentTableName(str));
            if (!io.dcloud.feature.internal.sdk.SDK.isUniMPSDK()) {
                this.mDatabaseSupplier.ensureDatabase(getCurrentTableName(str));
            }
            clearDBFile(context, str);
            return storageInfo;
        } catch (java.lang.Exception e) {
            storageInfo.code = -1;
            storageInfo.meg = context.getString(io.dcloud.base.R.string.dcloud_storage_native_error) + e.getMessage();
            return storageInfo;
        }
    }

    public synchronized io.dcloud.common.util.db.DCStorage.StorageInfo performGetAllKeys(java.lang.String str) {
        android.database.sqlite.SQLiteDatabase database = this.mDatabaseSupplier.getDatabase(getCurrentTableName(str));
        io.dcloud.common.util.db.DCStorage.StorageInfo storageInfo = new io.dcloud.common.util.db.DCStorage.StorageInfo();
        android.content.Context context = io.dcloud.application.DCLoudApplicationImpl.self().getContext();
        if (database == null) {
            storageInfo.code = -1;
            storageInfo.meg = context.getString(io.dcloud.base.R.string.dcloud_storage_no_db_error);
            return storageInfo;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        android.database.Cursor cursorQuery = database.query(getCurrentTableName(str), new java.lang.String[]{io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_KEY}, null, null, null, null, null);
        while (cursorQuery.moveToNext()) {
            try {
                try {
                    arrayList.add(cursorQuery.getString(cursorQuery.getColumnIndex(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_KEY)));
                } catch (java.lang.Exception e) {
                    storageInfo.code = -1;
                    storageInfo.meg = context.getString(io.dcloud.base.R.string.dcloud_storage_native_error) + e.getMessage();
                    cursorQuery.close();
                    return storageInfo;
                }
            } catch (java.lang.Throwable th) {
                cursorQuery.close();
                throw th;
            }
        }
        storageInfo.code = 1;
        storageInfo.v = arrayList;
        cursorQuery.close();
        return storageInfo;
    }

    public synchronized io.dcloud.common.util.db.DCStorage.StorageInfo performGetItem(java.lang.String str, java.lang.String str2) {
        android.database.sqlite.SQLiteDatabase database = this.mDatabaseSupplier.getDatabase(getCurrentTableName(str));
        io.dcloud.common.util.db.DCStorage.StorageInfo storageInfo = new io.dcloud.common.util.db.DCStorage.StorageInfo();
        android.content.Context context = io.dcloud.application.DCLoudApplicationImpl.self().getContext();
        if (database == null) {
            storageInfo.code = -1;
            storageInfo.meg = context.getString(io.dcloud.base.R.string.dcloud_storage_no_db_error);
            return storageInfo;
        }
        android.database.Cursor cursorQuery = database.query(getCurrentTableName(str), new java.lang.String[]{"value"}, "key=?", new java.lang.String[]{str2}, null, null, null);
        try {
            try {
                if (!cursorQuery.moveToNext()) {
                    storageInfo.code = -3;
                    storageInfo.meg = getMsgForCode(context, -3);
                    cursorQuery.close();
                    return storageInfo;
                }
                android.content.ContentValues contentValues = new android.content.ContentValues();
                contentValues.put("timestamp", io.dcloud.common.util.db.DCSQLiteOpenHelper.sDateFormatter.format(new java.util.Date()));
                this.mDatabaseSupplier.getDatabase(getCurrentTableName(str)).update(getCurrentTableName(str), contentValues, "key= ?", new java.lang.String[]{str2});
                java.lang.String string = cursorQuery.getString(cursorQuery.getColumnIndex("value"));
                if (android.text.TextUtils.isEmpty(string) || !string.startsWith(this.DCDBFILE_START)) {
                    storageInfo.v = string;
                } else {
                    java.lang.String dBFileValue = getDBFileValue(string);
                    if (io.dcloud.common.util.PdrUtil.isEmpty(dBFileValue)) {
                        storageInfo.v = string;
                    } else {
                        storageInfo.v = dBFileValue;
                    }
                }
                storageInfo.code = 1;
                cursorQuery.close();
                return storageInfo;
            } catch (java.lang.Exception e) {
                storageInfo.code = -1;
                storageInfo.meg = context.getString(io.dcloud.base.R.string.dcloud_storage_native_error) + e.getMessage();
                cursorQuery.close();
                return storageInfo;
            }
        } catch (java.lang.Throwable th) {
            cursorQuery.close();
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0075 A[Catch: all -> 0x007a, PHI: r0
  0x0075: PHI (r0v3 android.database.sqlite.SQLiteStatement) = (r0v2 android.database.sqlite.SQLiteStatement), (r0v4 android.database.sqlite.SQLiteStatement) binds: [B:18:0x0070, B:20:0x0073] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TRY_LEAVE, TryCatch #1 {, blocks: (B:4:0x0003, B:6:0x001d, B:9:0x0029, B:12:0x004b, B:21:0x0075), top: B:28:0x0003 }] */
    public synchronized io.dcloud.common.util.db.DCStorage.StorageInfo performGetLength(java.lang.String str) {
        android.database.sqlite.SQLiteDatabase database = this.mDatabaseSupplier.getDatabase(getCurrentTableName(str));
        io.dcloud.common.util.db.DCStorage.StorageInfo storageInfo = new io.dcloud.common.util.db.DCStorage.StorageInfo();
        android.content.Context context = io.dcloud.application.DCLoudApplicationImpl.self().getContext();
        if (database == null) {
            storageInfo.code = -1;
            storageInfo.meg = context.getString(io.dcloud.base.R.string.dcloud_storage_no_db_error);
            return storageInfo;
        }
        android.database.sqlite.SQLiteStatement sQLiteStatementCompileStatement = null;
        try {
            try {
                sQLiteStatementCompileStatement = database.compileStatement("SELECT count(key) FROM " + getCurrentTableName(str));
                storageInfo.v = java.lang.Long.valueOf(sQLiteStatementCompileStatement.simpleQueryForLong());
                storageInfo.code = 1;
                sQLiteStatementCompileStatement.close();
                return storageInfo;
            } catch (java.lang.Exception e) {
                storageInfo.code = -1;
                storageInfo.meg = context.getString(io.dcloud.base.R.string.dcloud_storage_native_error) + e.getMessage();
                if (sQLiteStatementCompileStatement != null) {
                    sQLiteStatementCompileStatement.close();
                }
                return storageInfo;
            }
        } catch (java.lang.Throwable unused) {
            if (sQLiteStatementCompileStatement != null) {
                sQLiteStatementCompileStatement.close();
            }
            return storageInfo;
        }
    }

    public synchronized io.dcloud.common.util.db.DCStorage.StorageInfo performRemoveItem(android.content.Context context, java.lang.String str, java.lang.String str2) {
        android.database.sqlite.SQLiteDatabase database = this.mDatabaseSupplier.getDatabase(getCurrentTableName(str));
        io.dcloud.common.util.db.DCStorage.StorageInfo storageInfo = new io.dcloud.common.util.db.DCStorage.StorageInfo();
        if (database == null) {
            storageInfo.code = -1;
            storageInfo.meg = context.getString(io.dcloud.base.R.string.dcloud_storage_no_db_error);
            return storageInfo;
        }
        try {
            int iDelete = database.delete(getCurrentTableName(str), "key=?", new java.lang.String[]{str2});
            if (iDelete > 0) {
                removeDBFile(context, str, str2);
            }
            if (iDelete == 1) {
                storageInfo.code = 1;
                return storageInfo;
            }
            storageInfo.code = -3;
            storageInfo.meg = getMsgForCode(context, -3);
            return storageInfo;
        } catch (java.lang.Exception e) {
            storageInfo.code = -1;
            storageInfo.meg = context.getString(io.dcloud.base.R.string.dcloud_storage_native_error) + e.getMessage();
            return storageInfo;
        }
    }

    public synchronized io.dcloud.common.util.db.DCStorage.StorageInfo performSetItem(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        try {
            android.database.sqlite.SQLiteDatabase database = this.mDatabaseSupplier.getDatabase(getCurrentTableName(str));
            io.dcloud.common.util.db.DCStorage.StorageInfo storageInfo = new io.dcloud.common.util.db.DCStorage.StorageInfo();
            if (database == null) {
                storageInfo.code = -1;
                storageInfo.meg = context.getString(io.dcloud.base.R.string.dcloud_storage_no_db_error);
                return storageInfo;
            }
            if (io.dcloud.common.util.PdrUtil.isEmpty(str2)) {
                storageInfo.code = -1;
                storageInfo.meg = context.getString(io.dcloud.base.R.string.dcloud_storage_key_error);
                return storageInfo;
            }
            java.lang.String str4 = "INSERT OR REPLACE INTO " + getCurrentTableName(str) + " VALUES (?,?,?);";
            java.lang.String str5 = io.dcloud.common.util.db.DCSQLiteOpenHelper.sDateFormatter.format(new java.util.Date());
            android.database.sqlite.SQLiteStatement sQLiteStatement = null;
            try {
                try {
                    if (str3.getBytes().length >= 1800000) {
                        str3 = saveDBFileValue(context, str, str2, str3);
                        if (android.text.TextUtils.isEmpty(str3) || str3.startsWith(this.ERROR_TAG)) {
                            storageInfo.code = -1;
                            storageInfo.meg = context.getString(io.dcloud.base.R.string.dcloud_storage_write_big_error);
                            if (!android.text.TextUtils.isEmpty(str3) && str3.startsWith(this.ERROR_TAG)) {
                                storageInfo.meg += " error " + str3.replace(this.ERROR_TAG, "");
                                return storageInfo;
                            }
                            return storageInfo;
                        }
                    }
                    android.database.sqlite.SQLiteStatement sQLiteStatementCompileStatement = database.compileStatement(str4);
                    sQLiteStatementCompileStatement.clearBindings();
                    sQLiteStatementCompileStatement.bindString(1, str2);
                    sQLiteStatementCompileStatement.bindString(2, str3);
                    sQLiteStatementCompileStatement.bindString(3, str5);
                    sQLiteStatementCompileStatement.execute();
                    storageInfo.code = 1;
                    sQLiteStatementCompileStatement.close();
                    return storageInfo;
                } catch (java.lang.Exception e) {
                    if (e instanceof android.database.sqlite.SQLiteFullException) {
                        storageInfo.code = -2;
                        storageInfo.meg = getMsgForCode(context, -2);
                        if (0 != 0) {
                            sQLiteStatement.close();
                        }
                    } else {
                        storageInfo.code = -1;
                        storageInfo.meg = context.getString(io.dcloud.base.R.string.dcloud_storage_native_error) + e.getMessage();
                        if (0 != 0) {
                            sQLiteStatement.close();
                        }
                    }
                }
            } catch (java.lang.Throwable th) {
                if (0 != 0) {
                    sQLiteStatement.close();
                }
                throw th;
            }
        } catch (java.lang.Throwable th2) {
            throw th2;
        }
    }

    private java.lang.String getDBFileValue(java.lang.String str) throws java.lang.Throwable {
        java.io.BufferedReader bufferedReader;
        if (!io.dcloud.common.util.PdrUtil.isEmpty(str)) {
            if (str.startsWith(this.DCDBFILE_START)) {
                str = str.substring(9);
            }
            if (new java.io.File(str).exists()) {
                java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
                java.io.BufferedReader bufferedReader2 = null;
                try {
                    try {
                        try {
                            bufferedReader = new java.io.BufferedReader(new java.io.FileReader(str));
                            while (true) {
                                try {
                                    java.lang.String line = bufferedReader.readLine();
                                    if (line == null) {
                                        java.lang.String string = stringBuffer.toString();
                                        bufferedReader.close();
                                        return string;
                                    }
                                    stringBuffer.append(line);
                                } catch (java.io.FileNotFoundException e) {
                                    e = e;
                                    bufferedReader2 = bufferedReader;
                                    e.printStackTrace();
                                    if (bufferedReader2 != null) {
                                        bufferedReader2.close();
                                    }
                                    return "";
                                } catch (java.io.IOException e2) {
                                    e = e2;
                                    bufferedReader2 = bufferedReader;
                                    e.printStackTrace();
                                    if (bufferedReader2 != null) {
                                        bufferedReader2.close();
                                    }
                                    return "";
                                } catch (java.lang.Throwable th) {
                                    th = th;
                                    if (bufferedReader != null) {
                                        try {
                                            bufferedReader.close();
                                        } catch (java.io.IOException unused) {
                                        }
                                    }
                                    throw th;
                                }
                            }
                        } catch (java.io.IOException unused2) {
                        }
                    } catch (java.io.FileNotFoundException e3) {
                        e = e3;
                    } catch (java.io.IOException e4) {
                        e = e4;
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    bufferedReader = bufferedReader2;
                }
            }
        }
        return "";
    }

    private void removeDBFile(java.lang.String str) {
        if (io.dcloud.common.util.PdrUtil.isEmpty(str)) {
            return;
        }
        if (str.startsWith(this.DCDBFILE_START)) {
            str = str.substring(9);
        }
        java.io.File file = new java.io.File(str);
        if (file.exists()) {
            file.delete();
        }
    }
}
