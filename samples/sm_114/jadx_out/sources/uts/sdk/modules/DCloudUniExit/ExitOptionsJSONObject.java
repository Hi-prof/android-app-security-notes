package uts.sdk.modules.DCloudUniExit;

/* JADX INFO: compiled from: index.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\t¨\u0006\u0010"}, d2 = {"Luts/sdk/modules/DCloudUniExit/ExitOptionsJSONObject;", "Lio/dcloud/uts/UTSJSONObject;", "<init>", "()V", com.taobao.weex.ui.component.WXImage.SUCCEED, "Lio/dcloud/uts/UTSCallback;", "getSuccess", "()Lio/dcloud/uts/UTSCallback;", "setSuccess", "(Lio/dcloud/uts/UTSCallback;)V", com.taobao.weex.common.Constants.Event.FAIL, "getFail", "setFail", "complete", "getComplete", "setComplete", "uni-exit_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class ExitOptionsJSONObject extends io.dcloud.uts.UTSJSONObject {
    private io.dcloud.uts.UTSCallback complete;
    private io.dcloud.uts.UTSCallback fail;
    private io.dcloud.uts.UTSCallback success;

    public io.dcloud.uts.UTSCallback getSuccess() {
        return this.success;
    }

    public void setSuccess(io.dcloud.uts.UTSCallback uTSCallback) {
        this.success = uTSCallback;
    }

    public io.dcloud.uts.UTSCallback getFail() {
        return this.fail;
    }

    public void setFail(io.dcloud.uts.UTSCallback uTSCallback) {
        this.fail = uTSCallback;
    }

    public io.dcloud.uts.UTSCallback getComplete() {
        return this.complete;
    }

    public void setComplete(io.dcloud.uts.UTSCallback uTSCallback) {
        this.complete = uTSCallback;
    }
}
