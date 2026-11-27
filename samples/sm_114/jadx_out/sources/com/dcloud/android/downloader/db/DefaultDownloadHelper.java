package com.dcloud.android.downloader.db;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class DefaultDownloadHelper extends android.database.sqlite.SQLiteOpenHelper {
    private static final int DB_VERSION = 1;
    public static final java.lang.String TABLE_NAME_DOWNLOAD_INFO = "download_info";
    private static final java.lang.String SQL_CREATE_DOWNLOAD_TABLE = io.dcloud.common.util.StringUtil.format("CREATE TABLE %s (_id integer PRIMARY KEY NOT NULL,supportRanges integer NOT NULL,createAt long NOT NULL,uri varchar(255) NOT NULL,location varchar(255),path varchar(255) NOT NULL,size long NOT NULL, progress long NOT NULL,status integer NOT NULL, value1 varchar(255), value2 varchar(255));", TABLE_NAME_DOWNLOAD_INFO);
    public static final java.lang.String TABLE_NAME_DOWNLOAD_THREAD_INFO = "download_thread_info";
    private static final java.lang.String SQL_CREATE_DOWNLOAD_THREAD_TABLE = io.dcloud.common.util.StringUtil.format("CREATE TABLE %s (_id integer PRIMARY KEY NOT NULL,threadId integer NOT NULL,downloadInfoId integer NOT NULL,uri varchar(255) NOT NULL,start long NOT NULL,end long NOT NULL,progress long NOT NULL);", TABLE_NAME_DOWNLOAD_THREAD_INFO);

    public DefaultDownloadHelper(android.content.Context context, com.dcloud.android.downloader.config.Config config) {
        super(context, config.getDatabaseName(), (android.database.sqlite.SQLiteDatabase.CursorFactory) null, config.getDatabaseVersion());
    }

    private void createTable(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(SQL_CREATE_DOWNLOAD_TABLE);
        sQLiteDatabase.execSQL(SQL_CREATE_DOWNLOAD_THREAD_TABLE);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        createTable(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
