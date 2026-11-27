package uts.sdk.modules.DCloudUniNetwork;

/* JADX INFO: compiled from: index.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u000f\b\u0016\u0018\u00002\u00020\u0001B%\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nR$\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u0005\u001a\u00020\u00068\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0007\u001a\u00020\b8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Luts/sdk/modules/DCloudUniNetwork/RequestTaskOnHeadersReceivedListenerResult;", "Lio/dcloud/uts/UTSObject;", "cookies", "Lio/dcloud/uts/UTSArray;", "", com.taobao.weex.ui.component.WXBasicComponentType.HEADER, "Lio/dcloud/uts/UTSJSONObject;", "statusCode", "", "<init>", "(Lio/dcloud/uts/UTSArray;Lio/dcloud/uts/UTSJSONObject;Ljava/lang/Number;)V", "getCookies", "()Lio/dcloud/uts/UTSArray;", "setCookies", "(Lio/dcloud/uts/UTSArray;)V", "getHeader", "()Lio/dcloud/uts/UTSJSONObject;", "setHeader", "(Lio/dcloud/uts/UTSJSONObject;)V", "getStatusCode", "()Ljava/lang/Number;", "setStatusCode", "(Ljava/lang/Number;)V", "uni-network_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class RequestTaskOnHeadersReceivedListenerResult extends io.dcloud.uts.UTSObject {

    @io.dcloud.uts.JsonNotNull
    private io.dcloud.uts.UTSArray<java.lang.String> cookies;

    @io.dcloud.uts.JsonNotNull
    private io.dcloud.uts.UTSJSONObject header;

    @io.dcloud.uts.JsonNotNull
    private java.lang.Number statusCode;

    public io.dcloud.uts.UTSArray<java.lang.String> getCookies() {
        return this.cookies;
    }

    public void setCookies(io.dcloud.uts.UTSArray<java.lang.String> uTSArray) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(uTSArray, "<set-?>");
        this.cookies = uTSArray;
    }

    public io.dcloud.uts.UTSJSONObject getHeader() {
        return this.header;
    }

    public void setHeader(io.dcloud.uts.UTSJSONObject uTSJSONObject) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(uTSJSONObject, "<set-?>");
        this.header = uTSJSONObject;
    }

    public java.lang.Number getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(java.lang.Number number) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(number, "<set-?>");
        this.statusCode = number;
    }

    public RequestTaskOnHeadersReceivedListenerResult(io.dcloud.uts.UTSArray<java.lang.String> cookies, io.dcloud.uts.UTSJSONObject header, java.lang.Number statusCode) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(cookies, "cookies");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(header, "header");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(statusCode, "statusCode");
        this.cookies = cookies;
        this.header = header;
        this.statusCode = statusCode;
    }
}
