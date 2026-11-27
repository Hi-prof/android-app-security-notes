package io.dcloud.common.util.net;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class NetMgr extends io.dcloud.common.DHInterface.AbsMgr implements io.dcloud.common.DHInterface.IMgr.NetEvent {
    io.dcloud.common.util.net.DownloadMgr mDownloadMgr;
    io.dcloud.common.util.net.http.IServer mLocalServer;
    io.dcloud.common.util.net.NetCheckReceiver mNetCheckReceiver;
    io.dcloud.common.util.net.UploadMgr mUploadMgr;

    public NetMgr(io.dcloud.common.DHInterface.ICore iCore) throws java.lang.Throwable {
        super(iCore, "netmgr", io.dcloud.common.DHInterface.IMgr.MgrType.NetMgr);
        this.mNetCheckReceiver = null;
        this.mLocalServer = null;
        startMiniServer();
        this.mUploadMgr = io.dcloud.common.util.net.UploadMgr.getUploadMgr();
        this.mDownloadMgr = io.dcloud.common.util.net.DownloadMgr.getDownloadMgr();
        this.mNetCheckReceiver = new io.dcloud.common.util.net.NetCheckReceiver(this);
        android.content.IntentFilter intentFilter = new android.content.IntentFilter(io.dcloud.common.util.net.NetCheckReceiver.netACTION);
        intentFilter.addAction(io.dcloud.common.util.net.NetCheckReceiver.simACTION);
        getContext().registerReceiver(this.mNetCheckReceiver, intentFilter);
    }

    private io.dcloud.common.util.net.http.IServer initLocalServer() throws java.lang.Throwable {
        java.lang.Object objNewInstance;
        java.lang.Object objNewInstance2;
        final java.util.ArrayList arrayList = new java.util.ArrayList();
        if (io.dcloud.common.util.BaseInfo.SyncDebug && (objNewInstance2 = io.dcloud.common.adapter.util.PlatformUtil.newInstance("io.dcloud.common.util.net.http.LocalServer", new java.lang.Class[]{io.dcloud.common.DHInterface.AbsMgr.class, java.lang.Integer.TYPE}, new java.lang.Object[]{this, 13131})) != null && (objNewInstance2 instanceof io.dcloud.common.util.net.http.IServer)) {
            arrayList.add((io.dcloud.common.util.net.http.IServer) objNewInstance2);
        }
        if (io.dcloud.common.util.BaseInfo.SyncDebug) {
            android.app.Activity activity = (android.app.Activity) this.mCore.obtainActivityContext();
            android.content.Intent intent = activity.getIntent();
            java.lang.String stringExtra = intent.getStringExtra(tv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener.ARG_IP);
            java.lang.String stringExtra2 = intent.getStringExtra(tv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener.ARG_PORT);
            if (io.dcloud.common.util.PdrUtil.isEmpty(stringExtra) || io.dcloud.common.util.PdrUtil.isEmpty(stringExtra2)) {
                byte[] all = io.dcloud.common.adapter.io.DHFile.readAll(activity.getExternalCacheDir().getPath() + java.io.File.separator + "debug_info");
                if (all != null) {
                    com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(new java.lang.String(all));
                    stringExtra = (java.lang.String) object.get(tv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener.ARG_IP);
                    stringExtra2 = (java.lang.String) object.get(tv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener.ARG_PORT);
                }
            }
            if (!io.dcloud.common.util.PdrUtil.isEmpty(stringExtra) && !io.dcloud.common.util.PdrUtil.isEmpty(stringExtra2) && (objNewInstance = io.dcloud.common.adapter.util.PlatformUtil.newInstance("io.dcloud.common.util.net.http.LocalServer2", new java.lang.Class[]{io.dcloud.common.DHInterface.AbsMgr.class, android.app.Activity.class, java.lang.String.class, java.lang.String.class}, new java.lang.Object[]{this, activity, stringExtra, stringExtra2})) != null && (objNewInstance instanceof io.dcloud.common.util.net.http.IServer)) {
                arrayList.add((io.dcloud.common.util.net.http.IServer) objNewInstance);
            }
        }
        return new io.dcloud.common.util.net.http.IServer() { // from class: io.dcloud.common.util.net.NetMgr.1
            @Override // io.dcloud.common.util.net.http.IServer
            public void start() {
                java.util.Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((io.dcloud.common.util.net.http.IServer) it.next()).start();
                }
            }

            @Override // io.dcloud.common.util.net.http.IServer
            public void stop() {
                java.util.Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((io.dcloud.common.util.net.http.IServer) it.next()).stop();
                }
            }
        };
    }

    @Override // io.dcloud.common.DHInterface.AbsMgr
    public void dispose() {
        io.dcloud.common.util.net.http.IServer iServer = this.mLocalServer;
        if (iServer != null) {
            iServer.stop();
        }
        io.dcloud.common.util.net.UploadMgr uploadMgr = this.mUploadMgr;
        if (uploadMgr != null) {
            uploadMgr.dispose();
        }
        getContext().unregisterReceiver(this.mNetCheckReceiver);
    }

    @Override // io.dcloud.common.DHInterface.AbsMgr
    public void onExecute(io.dcloud.common.DHInterface.ISysEventListener.SysEventType sysEventType, java.lang.Object obj) throws java.lang.Throwable {
        if (sysEventType == io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onStop) {
            io.dcloud.common.util.net.http.IServer iServer = this.mLocalServer;
            if (iServer != null) {
                iServer.stop();
                this.mLocalServer = null;
                return;
            }
            return;
        }
        if ((sysEventType == io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onResume || sysEventType == io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onNewIntent) && this.mLocalServer == null) {
            startMiniServer();
        }
    }

    @Override // io.dcloud.common.DHInterface.IMgr
    public java.lang.Object processEvent(io.dcloud.common.DHInterface.IMgr.MgrType mgrType, int i, java.lang.Object obj) {
        try {
            if (checkMgrId(mgrType)) {
                return null;
            }
            return this.mCore.dispatchEvent(mgrType, i, obj);
        } catch (java.lang.Throwable th) {
            io.dcloud.common.adapter.util.Logger.w("NetMgr.processEvent", th);
            return null;
        }
    }

    protected void startMiniServer() throws java.lang.Throwable {
        if (!io.dcloud.common.util.BaseInfo.ISDEBUG || io.dcloud.feature.internal.sdk.SDK.isUniMPSDK()) {
            return;
        }
        io.dcloud.common.util.net.http.IServer iServerInitLocalServer = initLocalServer();
        this.mLocalServer = iServerInitLocalServer;
        iServerInitLocalServer.start();
    }
}
