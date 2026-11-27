package com.dcloud.android.downloader.db;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class DefaultDownloadDBController implements com.dcloud.android.downloader.db.DownloadDBController {
    private final android.content.Context context;
    private final com.dcloud.android.downloader.db.DefaultDownloadHelper dbHelper;
    private final android.database.sqlite.SQLiteDatabase readableDatabase;
    private final android.database.sqlite.SQLiteDatabase writableDatabase;
    public static final java.lang.String[] DOWNLOAD_INFO_COLUMNS = {"_id", "supportRanges", "createAt", "uri", "location", io.dcloud.common.constant.AbsoluteConst.XML_PATH, io.dcloud.common.constant.AbsoluteConst.JSON_KEY_SIZE, "progress", "status"};
    public static final java.lang.String[] DOWNLOAD_THREAD_INFO_COLUMNS = {"_id", "threadId", "downloadInfoId", "uri", "start", "end", "progress"};
    public static final java.lang.String SQL_UPDATE_DOWNLOAD_THREAD_INFO = io.dcloud.common.util.StringUtil.format("REPLACE INTO %s (_id,threadId,downloadInfoId,uri,start,end,progress) VALUES(?,?,?,?,?,?,?);", com.dcloud.android.downloader.db.DefaultDownloadHelper.TABLE_NAME_DOWNLOAD_THREAD_INFO);
    public static final java.lang.String SQL_UPDATE_DOWNLOAD_INFO = io.dcloud.common.util.StringUtil.format("REPLACE INTO %s (_id,supportRanges,createAt,uri,location,path,size,progress,status) VALUES(?,?,?,?,?,?,?,?,?);", com.dcloud.android.downloader.db.DefaultDownloadHelper.TABLE_NAME_DOWNLOAD_INFO);
    public static final java.lang.String SQL_UPDATE_DOWNLOADING_INFO_STATUS = io.dcloud.common.util.StringUtil.format("UPDATE %s SET status=? WHERE status!=?;", com.dcloud.android.downloader.db.DefaultDownloadHelper.TABLE_NAME_DOWNLOAD_INFO);

    public DefaultDownloadDBController(android.content.Context context, com.dcloud.android.downloader.config.Config config) {
        this.context = context;
        com.dcloud.android.downloader.db.DefaultDownloadHelper defaultDownloadHelper = new com.dcloud.android.downloader.db.DefaultDownloadHelper(context, config);
        this.dbHelper = defaultDownloadHelper;
        this.writableDatabase = defaultDownloadHelper.getWritableDatabase();
        this.readableDatabase = defaultDownloadHelper.getReadableDatabase();
    }

    private void inflateDownloadInfo(android.database.Cursor cursor, com.dcloud.android.downloader.domain.DownloadInfo downloadInfo) {
        downloadInfo.setId(cursor.getInt(0));
        downloadInfo.setSupportRanges(cursor.getInt(1));
        downloadInfo.setCreateAt(cursor.getLong(2));
        downloadInfo.setUri(cursor.getString(3));
        downloadInfo.setLocation(cursor.getString(4));
        downloadInfo.setPath(cursor.getString(5));
        downloadInfo.setSize(cursor.getLong(6));
        downloadInfo.setProgress(cursor.getLong(7));
        downloadInfo.setStatus(cursor.getInt(8));
    }

    private void inflateDownloadThreadInfo(android.database.Cursor cursor, com.dcloud.android.downloader.domain.DownloadThreadInfo downloadThreadInfo) {
        downloadThreadInfo.setId(cursor.getInt(0));
        downloadThreadInfo.setThreadId(cursor.getInt(1));
        downloadThreadInfo.setDownloadInfoId(cursor.getInt(2));
        downloadThreadInfo.setUri(cursor.getString(3));
        downloadThreadInfo.setStart(cursor.getLong(4));
        downloadThreadInfo.setEnd(cursor.getLong(5));
        downloadThreadInfo.setProgress(cursor.getLong(6));
    }

    @Override // com.dcloud.android.downloader.db.DownloadDBController
    public void createOrUpdate(com.dcloud.android.downloader.domain.DownloadInfo downloadInfo) {
        this.writableDatabase.execSQL(SQL_UPDATE_DOWNLOAD_INFO, new java.lang.Object[]{java.lang.Integer.valueOf(downloadInfo.getId()), java.lang.Integer.valueOf(downloadInfo.getSupportRanges()), java.lang.Long.valueOf(downloadInfo.getCreateAt()), downloadInfo.getUri(), downloadInfo.getLocation(), downloadInfo.getPath(), java.lang.Long.valueOf(downloadInfo.getSize()), java.lang.Long.valueOf(downloadInfo.getProgress()), java.lang.Integer.valueOf(downloadInfo.getStatus())});
    }

    @Override // com.dcloud.android.downloader.db.DownloadDBController
    public void delete(com.dcloud.android.downloader.domain.DownloadInfo downloadInfo) {
        this.writableDatabase.delete(com.dcloud.android.downloader.db.DefaultDownloadHelper.TABLE_NAME_DOWNLOAD_INFO, "_id=?", new java.lang.String[]{java.lang.String.valueOf(downloadInfo.getId())});
        this.writableDatabase.delete(com.dcloud.android.downloader.db.DefaultDownloadHelper.TABLE_NAME_DOWNLOAD_THREAD_INFO, "downloadInfoId=?", new java.lang.String[]{java.lang.String.valueOf(downloadInfo.getId())});
    }

    @Override // com.dcloud.android.downloader.db.DownloadDBController
    public java.util.List<com.dcloud.android.downloader.domain.DownloadInfo> findAllDownloaded() {
        android.database.Cursor cursorQuery = this.readableDatabase.query(com.dcloud.android.downloader.db.DefaultDownloadHelper.TABLE_NAME_DOWNLOAD_INFO, DOWNLOAD_INFO_COLUMNS, "status=?", new java.lang.String[]{java.lang.String.valueOf(5)}, null, null, "createAt desc");
        java.util.ArrayList arrayList = new java.util.ArrayList();
        while (cursorQuery.moveToNext()) {
            com.dcloud.android.downloader.domain.DownloadInfo downloadInfo = new com.dcloud.android.downloader.domain.DownloadInfo(this.context);
            arrayList.add(downloadInfo);
            inflateDownloadInfo(cursorQuery, downloadInfo);
        }
        return arrayList;
    }

    @Override // com.dcloud.android.downloader.db.DownloadDBController
    public java.util.List<com.dcloud.android.downloader.domain.DownloadInfo> findAllDownloading() {
        android.database.Cursor cursorQuery = this.readableDatabase.query(com.dcloud.android.downloader.db.DefaultDownloadHelper.TABLE_NAME_DOWNLOAD_INFO, DOWNLOAD_INFO_COLUMNS, "status!=?", new java.lang.String[]{java.lang.String.valueOf(5)}, null, null, "createAt desc");
        java.util.ArrayList arrayList = new java.util.ArrayList();
        while (cursorQuery.moveToNext()) {
            com.dcloud.android.downloader.domain.DownloadInfo downloadInfo = new com.dcloud.android.downloader.domain.DownloadInfo(this.context);
            arrayList.add(downloadInfo);
            inflateDownloadInfo(cursorQuery, downloadInfo);
            android.database.Cursor cursorQuery2 = this.readableDatabase.query(com.dcloud.android.downloader.db.DefaultDownloadHelper.TABLE_NAME_DOWNLOAD_THREAD_INFO, DOWNLOAD_THREAD_INFO_COLUMNS, "downloadInfoId=?", new java.lang.String[]{java.lang.String.valueOf(downloadInfo.getId())}, null, null, null);
            java.util.ArrayList arrayList2 = new java.util.ArrayList();
            while (cursorQuery2.moveToNext()) {
                com.dcloud.android.downloader.domain.DownloadThreadInfo downloadThreadInfo = new com.dcloud.android.downloader.domain.DownloadThreadInfo();
                arrayList2.add(downloadThreadInfo);
                inflateDownloadThreadInfo(cursorQuery2, downloadThreadInfo);
            }
            downloadInfo.setDownloadThreadInfos(arrayList2);
        }
        return arrayList;
    }

    @Override // com.dcloud.android.downloader.db.DownloadDBController
    public com.dcloud.android.downloader.domain.DownloadInfo findDownloadedInfoById(int i) {
        android.database.Cursor cursorQuery = this.readableDatabase.query(com.dcloud.android.downloader.db.DefaultDownloadHelper.TABLE_NAME_DOWNLOAD_INFO, DOWNLOAD_INFO_COLUMNS, "_id=?", new java.lang.String[]{java.lang.String.valueOf(i)}, null, null, "createAt desc");
        if (!cursorQuery.moveToNext()) {
            return null;
        }
        com.dcloud.android.downloader.domain.DownloadInfo downloadInfo = new com.dcloud.android.downloader.domain.DownloadInfo(this.context);
        inflateDownloadInfo(cursorQuery, downloadInfo);
        return downloadInfo;
    }

    @Override // com.dcloud.android.downloader.db.DownloadDBController
    public void pauseAllDownloading() {
        this.writableDatabase.execSQL(SQL_UPDATE_DOWNLOADING_INFO_STATUS, new java.lang.Object[]{4, 5});
    }

    @Override // com.dcloud.android.downloader.db.DownloadDBController
    public void createOrUpdate(com.dcloud.android.downloader.domain.DownloadThreadInfo downloadThreadInfo) {
        this.writableDatabase.execSQL(SQL_UPDATE_DOWNLOAD_THREAD_INFO, new java.lang.Object[]{java.lang.Integer.valueOf(downloadThreadInfo.getId()), java.lang.Integer.valueOf(downloadThreadInfo.getThreadId()), java.lang.Integer.valueOf(downloadThreadInfo.getDownloadInfoId()), downloadThreadInfo.getUri(), java.lang.Long.valueOf(downloadThreadInfo.getStart()), java.lang.Long.valueOf(downloadThreadInfo.getEnd()), java.lang.Long.valueOf(downloadThreadInfo.getProgress())});
    }

    @Override // com.dcloud.android.downloader.db.DownloadDBController
    public void delete(com.dcloud.android.downloader.domain.DownloadThreadInfo downloadThreadInfo) {
        this.writableDatabase.delete(com.dcloud.android.downloader.db.DefaultDownloadHelper.TABLE_NAME_DOWNLOAD_THREAD_INFO, "id=?", new java.lang.String[]{java.lang.String.valueOf(downloadThreadInfo.getId())});
    }
}
