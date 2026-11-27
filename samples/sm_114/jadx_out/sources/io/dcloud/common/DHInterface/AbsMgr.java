package io.dcloud.common.DHInterface;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbsMgr implements io.dcloud.common.DHInterface.IMgr {
    protected android.content.Context mContextWrapper;
    protected io.dcloud.common.DHInterface.ICore mCore;
    protected boolean mIsStreamAppMode = false;
    protected java.lang.String mMgrName;
    protected io.dcloud.common.DHInterface.IMgr.MgrType mMgrType;

    protected AbsMgr(io.dcloud.common.DHInterface.ICore iCore, java.lang.String str, io.dcloud.common.DHInterface.IMgr.MgrType mgrType) {
        this.mContextWrapper = null;
        this.mCore = iCore;
        this.mMgrName = str;
        this.mMgrType = mgrType;
        this.mContextWrapper = iCore.obtainContext();
    }

    public final boolean checkMgrId(io.dcloud.common.DHInterface.IMgr.MgrType mgrType) {
        return this.mMgrType == mgrType;
    }

    public void dispose() {
    }

    public final android.content.Context getContext() {
        return this.mContextWrapper;
    }

    public final boolean isStreamAppMode() {
        return this.mIsStreamAppMode;
    }

    public void onExecute(io.dcloud.common.DHInterface.ISysEventListener.SysEventType sysEventType, java.lang.Object obj) {
    }
}
