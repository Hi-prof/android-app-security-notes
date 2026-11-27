package uts.sdk.modules.DCloudUniExit;

/* JADX INFO: compiled from: index.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001e\u0010\u0002\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\t"}, d2 = {"Luts/sdk/modules/DCloudUniExit/ExitSuccess;", "Lio/dcloud/uts/UTSObject;", com.taobao.weex.adapter.IWXUserTrackAdapter.MONITOR_ERROR_MSG, "", "<init>", "(Ljava/lang/String;)V", "getErrMsg", "()Ljava/lang/String;", "setErrMsg", "uni-exit_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class ExitSuccess extends io.dcloud.uts.UTSObject {

    @io.dcloud.uts.JsonNotNull
    private java.lang.String errMsg;

    public java.lang.String getErrMsg() {
        return this.errMsg;
    }

    public void setErrMsg(java.lang.String str) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.errMsg = str;
    }

    public ExitSuccess(java.lang.String errMsg) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        this.errMsg = errMsg;
    }
}
