package uts.sdk.modules.DCloudUniNetwork;

/* JADX INFO: compiled from: index.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u0004\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0001X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0007\"\u0004\b\u0011\u0010\tR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0019X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR\u001c\u0010!\u001a\u0004\u0018\u00010\u0019X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001b\"\u0004\b#\u0010\u001d¨\u0006$"}, d2 = {"Luts/sdk/modules/DCloudUniNetwork/DownloadFileOptionsJSONObject;", "Lio/dcloud/uts/UTSJSONObject;", "<init>", "()V", "url", "", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", com.taobao.weex.ui.component.WXBasicComponentType.HEADER, "getHeader", "()Lio/dcloud/uts/UTSJSONObject;", "setHeader", "(Lio/dcloud/uts/UTSJSONObject;)V", "filePath", "getFilePath", "setFilePath", "timeout", "", "getTimeout", "()Ljava/lang/Number;", "setTimeout", "(Ljava/lang/Number;)V", com.taobao.weex.ui.component.WXImage.SUCCEED, "Lio/dcloud/uts/UTSCallback;", "getSuccess", "()Lio/dcloud/uts/UTSCallback;", "setSuccess", "(Lio/dcloud/uts/UTSCallback;)V", com.taobao.weex.common.Constants.Event.FAIL, "getFail", "setFail", "complete", "getComplete", "setComplete", "uni-network_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class DownloadFileOptionsJSONObject extends io.dcloud.uts.UTSJSONObject {
    private io.dcloud.uts.UTSCallback complete;
    private io.dcloud.uts.UTSCallback fail;
    private java.lang.String filePath;
    private io.dcloud.uts.UTSJSONObject header;
    private io.dcloud.uts.UTSCallback success;
    private java.lang.Number timeout;
    public java.lang.String url;

    public java.lang.String getUrl() {
        java.lang.String str = this.url;
        if (str != null) {
            return str;
        }
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("url");
        return null;
    }

    public void setUrl(java.lang.String str) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.url = str;
    }

    public io.dcloud.uts.UTSJSONObject getHeader() {
        return this.header;
    }

    public void setHeader(io.dcloud.uts.UTSJSONObject uTSJSONObject) {
        this.header = uTSJSONObject;
    }

    public java.lang.String getFilePath() {
        return this.filePath;
    }

    public void setFilePath(java.lang.String str) {
        this.filePath = str;
    }

    public java.lang.Number getTimeout() {
        return this.timeout;
    }

    public void setTimeout(java.lang.Number number) {
        this.timeout = number;
    }

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
