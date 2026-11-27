package io.dcloud.common.util.net;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class UploadMgr {
    private static io.dcloud.common.util.net.UploadMgr mUploadMgr;
    private io.dcloud.common.util.net.NetWorkLoop mUploadLoop;

    private UploadMgr() {
        io.dcloud.common.util.net.NetWorkLoop netWorkLoop = new io.dcloud.common.util.net.NetWorkLoop();
        this.mUploadLoop = netWorkLoop;
        netWorkLoop.startThreadPool();
    }

    public static io.dcloud.common.util.net.UploadMgr getUploadMgr() {
        if (mUploadMgr == null) {
            mUploadMgr = new io.dcloud.common.util.net.UploadMgr();
        }
        return mUploadMgr;
    }

    public void abort(io.dcloud.common.util.net.NetWork netWork) {
        removeNetWork(netWork);
    }

    public void dispose() {
    }

    public void removeNetWork(io.dcloud.common.util.net.NetWork netWork) {
        this.mUploadLoop.removeNetWork(netWork);
    }

    public void start(io.dcloud.common.util.net.NetWork netWork) {
        this.mUploadLoop.addNetWork(netWork);
    }
}
