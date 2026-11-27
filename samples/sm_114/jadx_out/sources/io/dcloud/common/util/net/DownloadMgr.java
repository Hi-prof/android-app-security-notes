package io.dcloud.common.util.net;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class DownloadMgr {
    private static io.dcloud.common.util.net.DownloadMgr mDownloadMgr;
    private io.dcloud.common.util.net.NetWorkLoop mDownloadLoop;

    private DownloadMgr() {
        io.dcloud.common.util.net.NetWorkLoop netWorkLoop = new io.dcloud.common.util.net.NetWorkLoop();
        this.mDownloadLoop = netWorkLoop;
        netWorkLoop.startThreadPool();
    }

    public static io.dcloud.common.util.net.DownloadMgr getDownloadMgr() {
        if (mDownloadMgr == null) {
            mDownloadMgr = new io.dcloud.common.util.net.DownloadMgr();
        }
        return mDownloadMgr;
    }

    public void addQuestTask(io.dcloud.common.util.net.NetWork netWork) {
        this.mDownloadLoop.addNetWork(netWork);
    }

    public void dispose() {
        io.dcloud.common.adapter.util.Logger.d("DownloadMgr: dispose");
        this.mDownloadLoop.dispose();
        this.mDownloadLoop = null;
        mDownloadMgr = null;
    }

    public void removeTask(io.dcloud.common.util.net.NetWork netWork) {
        this.mDownloadLoop.removeNetWork(netWork);
    }
}
