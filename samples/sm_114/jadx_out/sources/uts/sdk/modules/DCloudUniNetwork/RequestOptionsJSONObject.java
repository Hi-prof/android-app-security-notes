package uts.sdk.modules.DCloudUniNetwork;

/* JADX INFO: compiled from: index.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0004\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0001X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0015\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0016X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\u001f\u001a\u0004\u0018\u00010 X\u0096\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010&\u001a\u0004\u0018\u00010\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0007\"\u0004\b(\u0010\tR\u001c\u0010)\u001a\u0004\u0018\u00010\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0007\"\u0004\b+\u0010\tR\u001e\u0010,\u001a\u0004\u0018\u00010 X\u0096\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\b-\u0010\"\"\u0004\b.\u0010$R\u001e\u0010/\u001a\u0004\u0018\u00010 X\u0096\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\b0\u0010\"\"\u0004\b1\u0010$R\u001e\u00102\u001a\u0004\u0018\u00010 X\u0096\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\b3\u0010\"\"\u0004\b4\u0010$R\u001e\u00105\u001a\u0004\u0018\u00010 X\u0096\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\b6\u0010\"\"\u0004\b7\u0010$R\u001c\u00108\u001a\u0004\u0018\u000109X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001c\u0010>\u001a\u0004\u0018\u000109X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010;\"\u0004\b@\u0010=R\u001c\u0010A\u001a\u0004\u0018\u000109X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010;\"\u0004\bC\u0010=¨\u0006D"}, d2 = {"Luts/sdk/modules/DCloudUniNetwork/RequestOptionsJSONObject;", "Lio/dcloud/uts/UTSJSONObject;", "<init>", "()V", "url", "", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "data", "", "getData", "()Ljava/lang/Object;", "setData", "(Ljava/lang/Object;)V", com.taobao.weex.ui.component.WXBasicComponentType.HEADER, "getHeader", "()Lio/dcloud/uts/UTSJSONObject;", "setHeader", "(Lio/dcloud/uts/UTSJSONObject;)V", "method", "Luts/sdk/modules/DCloudUniNetwork/RequestMethod;", "getMethod", "setMethod", "timeout", "", "getTimeout", "()Ljava/lang/Number;", "setTimeout", "(Ljava/lang/Number;)V", "enableQuic", "", "getEnableQuic", "()Ljava/lang/Boolean;", "setEnableQuic", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "dataType", "getDataType", "setDataType", "responseType", "getResponseType", "setResponseType", "sslVerify", "getSslVerify", "setSslVerify", "withCredentials", "getWithCredentials", "setWithCredentials", "firstIpv4", "getFirstIpv4", "setFirstIpv4", "enableChunked", "getEnableChunked", "setEnableChunked", com.taobao.weex.ui.component.WXImage.SUCCEED, "Lio/dcloud/uts/UTSCallback;", "getSuccess", "()Lio/dcloud/uts/UTSCallback;", "setSuccess", "(Lio/dcloud/uts/UTSCallback;)V", com.taobao.weex.common.Constants.Event.FAIL, "getFail", "setFail", "complete", "getComplete", "setComplete", "uni-network_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class RequestOptionsJSONObject extends io.dcloud.uts.UTSJSONObject {
    private io.dcloud.uts.UTSCallback complete;
    private java.lang.Object data;
    private java.lang.String dataType;
    private java.lang.Boolean enableChunked;
    private java.lang.Boolean enableQuic;
    private io.dcloud.uts.UTSCallback fail;
    private java.lang.Boolean firstIpv4;
    private io.dcloud.uts.UTSJSONObject header;
    private java.lang.String method;
    private java.lang.String responseType;
    private java.lang.Boolean sslVerify;
    private io.dcloud.uts.UTSCallback success;
    private java.lang.Number timeout;
    public java.lang.String url;
    private java.lang.Boolean withCredentials;

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

    public java.lang.Object getData() {
        return this.data;
    }

    public void setData(java.lang.Object obj) {
        this.data = obj;
    }

    public io.dcloud.uts.UTSJSONObject getHeader() {
        return this.header;
    }

    public void setHeader(io.dcloud.uts.UTSJSONObject uTSJSONObject) {
        this.header = uTSJSONObject;
    }

    public java.lang.String getMethod() {
        return this.method;
    }

    public void setMethod(java.lang.String str) {
        this.method = str;
    }

    public java.lang.Number getTimeout() {
        return this.timeout;
    }

    public void setTimeout(java.lang.Number number) {
        this.timeout = number;
    }

    public java.lang.Boolean getEnableQuic() {
        return this.enableQuic;
    }

    public void setEnableQuic(java.lang.Boolean bool) {
        this.enableQuic = bool;
    }

    public java.lang.String getDataType() {
        return this.dataType;
    }

    public void setDataType(java.lang.String str) {
        this.dataType = str;
    }

    public java.lang.String getResponseType() {
        return this.responseType;
    }

    public void setResponseType(java.lang.String str) {
        this.responseType = str;
    }

    public java.lang.Boolean getSslVerify() {
        return this.sslVerify;
    }

    public void setSslVerify(java.lang.Boolean bool) {
        this.sslVerify = bool;
    }

    public java.lang.Boolean getWithCredentials() {
        return this.withCredentials;
    }

    public void setWithCredentials(java.lang.Boolean bool) {
        this.withCredentials = bool;
    }

    public java.lang.Boolean getFirstIpv4() {
        return this.firstIpv4;
    }

    public void setFirstIpv4(java.lang.Boolean bool) {
        this.firstIpv4 = bool;
    }

    public java.lang.Boolean getEnableChunked() {
        return this.enableChunked;
    }

    public void setEnableChunked(java.lang.Boolean bool) {
        this.enableChunked = bool;
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
