package io.dcloud.common.adapter.util;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class DownloadUtil {
    private static io.dcloud.common.adapter.util.DownloadUtil mInstance;
    android.content.BroadcastReceiver download_receiver = new android.content.BroadcastReceiver() { // from class: io.dcloud.common.adapter.util.DownloadUtil.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(android.content.Context context, android.content.Intent intent) {
            android.util.Log.v("intent", "" + intent.getLongExtra("extra_download_id", 0L));
            try {
                io.dcloud.common.adapter.util.DownloadUtil.this.queryDownloadStatus(context);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    };
    android.content.Context mContext;
    private android.app.DownloadManager mDownloader;
    java.util.HashMap<java.lang.Long, io.dcloud.common.adapter.util.DownloadUtil.MyRequest> rs;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class MyRequest {
        io.dcloud.common.DHInterface.ILoadCallBack callback;
        long id;
        android.app.DownloadManager.Request request;

        MyRequest(java.lang.String str, java.lang.String str2, io.dcloud.common.DHInterface.ILoadCallBack iLoadCallBack) {
            this.request = null;
            this.callback = null;
            android.app.DownloadManager.Request request = new android.app.DownloadManager.Request(android.net.Uri.parse(str));
            this.request = request;
            request.setMimeType(str2);
            this.callback = iLoadCallBack;
        }
    }

    private DownloadUtil(android.content.Context context) {
        this.rs = null;
        this.mDownloader = (android.app.DownloadManager) context.getSystemService(io.dcloud.common.constant.AbsoluteConst.SPNAME_DOWNLOAD);
        this.rs = new java.util.HashMap<>(2);
        this.mContext = context;
        try {
            if (android.os.Build.VERSION.SDK_INT >= 33) {
                context.getApplicationContext().registerReceiver(this.download_receiver, new android.content.IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"), 2);
            } else {
                context.getApplicationContext().registerReceiver(this.download_receiver, new android.content.IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
            }
        } catch (java.lang.Exception unused) {
        }
    }

    public static android.content.Intent getAPKInstallIntent(android.content.Context context, java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        java.lang.String mimeType = io.dcloud.common.util.PdrUtil.getMimeType(str);
        if (str.startsWith(io.dcloud.common.adapter.util.DeviceInfo.FILE_PROTOCOL)) {
            str = str.substring(7);
        }
        if (str.startsWith("content://")) {
            str = io.dcloud.common.adapter.util.PlatformUtil.getFilePathFromContentUri(android.net.Uri.parse(str), context.getContentResolver());
            mimeType = io.dcloud.common.util.PdrUtil.getMimeType(str);
        }
        return io.dcloud.common.util.LoadAppUtils.getDataAndTypeIntent(context, str, mimeType);
    }

    public static io.dcloud.common.adapter.util.DownloadUtil getInstance(android.content.Context context) {
        if (mInstance == null) {
            mInstance = new io.dcloud.common.adapter.util.DownloadUtil(context);
        }
        return mInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void queryDownloadStatus(android.content.Context context) {
        java.lang.String string;
        java.util.Set<java.lang.Long> setKeySet = this.rs.keySet();
        int size = setKeySet.size();
        java.lang.Long[] lArr = new java.lang.Long[size];
        setKeySet.toArray(lArr);
        for (int i = size - 1; i >= 0; i--) {
            java.lang.Long l = lArr[i];
            long jLongValue = l.longValue();
            android.app.DownloadManager.Query query = new android.app.DownloadManager.Query();
            query.setFilterById(jLongValue);
            android.database.Cursor cursorQuery = this.mDownloader.query(query);
            if (cursorQuery.moveToFirst()) {
                int i2 = cursorQuery.getInt(cursorQuery.getColumnIndex("status"));
                if (i2 == 1) {
                    android.util.Log.v("down", "STATUS_PENDING");
                    android.util.Log.v("down", "STATUS_RUNNING");
                } else if (i2 == 2) {
                    android.util.Log.v("down", "STATUS_RUNNING");
                } else if (i2 == 4) {
                    android.util.Log.v("down", "STATUS_PAUSED");
                    android.util.Log.v("down", "STATUS_PENDING");
                    android.util.Log.v("down", "STATUS_RUNNING");
                } else if (i2 == 8) {
                    android.util.Log.e("down", "下载完成");
                    try {
                        android.net.Uri uriForDownloadedFile = this.mDownloader.getUriForDownloadedFile(jLongValue);
                        string = uriForDownloadedFile.toString().startsWith("content://") ? uriForDownloadedFile.toString() : uriForDownloadedFile.getPath();
                    } catch (java.lang.Exception e) {
                        e.printStackTrace();
                        string = null;
                    }
                    io.dcloud.common.DHInterface.ILoadCallBack iLoadCallBack = this.rs.remove(l).callback;
                    if (iLoadCallBack != null) {
                        iLoadCallBack.onCallBack(0, context, string);
                    }
                } else if (i2 == 16) {
                    android.util.Log.v("down", "STATUS_FAILED");
                    this.mDownloader.remove(jLongValue);
                    this.rs.remove(l);
                }
            }
        }
    }

    private void runCallBack(final android.app.Activity activity, final io.dcloud.common.DHInterface.ILoadCallBack iLoadCallBack, final int i, final java.lang.Object obj) {
        activity.runOnUiThread(new java.lang.Runnable() { // from class: io.dcloud.common.adapter.util.DownloadUtil.2
            @Override // java.lang.Runnable
            public void run() {
                iLoadCallBack.onCallBack(i, activity, obj);
            }
        });
    }

    public void addDownlaodCallBack(long j, java.lang.String str, java.lang.String str2, io.dcloud.common.DHInterface.ILoadCallBack iLoadCallBack) {
        if (this.rs.size() <= 0 || !this.rs.containsKey(java.lang.Long.valueOf(j))) {
            this.rs.put(java.lang.Long.valueOf(j), new io.dcloud.common.adapter.util.DownloadUtil.MyRequest(str, str2, iLoadCallBack));
        }
    }

    public void checkDownloadStatus(android.app.Activity activity, long j, io.dcloud.common.DHInterface.ILoadCallBack iLoadCallBack) {
        android.app.DownloadManager.Query query = new android.app.DownloadManager.Query();
        query.setFilterById(j);
        android.database.Cursor cursorQuery = this.mDownloader.query(query);
        if (cursorQuery.moveToFirst()) {
            int i = cursorQuery.getInt(cursorQuery.getColumnIndex("status"));
            java.lang.String string = null;
            if (i != 1 && i != 2) {
                if (i == 4) {
                    this.mDownloader.remove(j);
                } else {
                    if (i == 8) {
                        try {
                            android.net.Uri uriForDownloadedFile = this.mDownloader.getUriForDownloadedFile(j);
                            string = uriForDownloadedFile.toString().startsWith("content://") ? uriForDownloadedFile.toString() : uriForDownloadedFile.getPath();
                        } catch (java.lang.Exception e) {
                            e.printStackTrace();
                        }
                        runCallBack(activity, iLoadCallBack, i, getAPKInstallIntent(activity, string));
                        return;
                    }
                    if (i == 16) {
                        this.mDownloader.remove(j);
                    }
                }
            }
            if (iLoadCallBack != null) {
                runCallBack(activity, iLoadCallBack, i, null);
            }
        }
    }

    public void onReceive(android.content.Context context, android.content.Intent intent) {
    }

    public long startRequest(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, io.dcloud.common.DHInterface.ILoadCallBack iLoadCallBack) {
        try {
            io.dcloud.common.adapter.util.DownloadUtil.MyRequest myRequest = new io.dcloud.common.adapter.util.DownloadUtil.MyRequest(str, str2, iLoadCallBack);
            try {
                if (!io.dcloud.common.adapter.io.DHFile.isExist(str3)) {
                    new java.io.File(str3).mkdirs();
                }
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
            if (str3.endsWith("/")) {
                str3 = str3.substring(0, str3.length() - 1);
            }
            if (str3.startsWith(io.dcloud.common.adapter.util.DeviceInfo.sDeviceRootDir)) {
                str3 = str3.substring(io.dcloud.common.adapter.util.DeviceInfo.sDeviceRootDir.length() + 1);
            }
            myRequest.request.setTitle(str4);
            myRequest.request.setDestinationInExternalPublicDir(str3, str4);
            long jEnqueue = this.mDownloader.enqueue(myRequest.request);
            myRequest.id = jEnqueue;
            this.rs.put(java.lang.Long.valueOf(jEnqueue), myRequest);
            return jEnqueue;
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            iLoadCallBack.onCallBack(-1, null, null);
            return -1L;
        }
    }

    public void stop() {
        android.content.Context context = this.mContext;
        if (context != null) {
            try {
                context.getApplicationContext().unregisterReceiver(this.download_receiver);
                mInstance = null;
                this.mContext = null;
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }
}
