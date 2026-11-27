package uts.sdk.modules.DCloudUniNetwork;

/* JADX INFO: compiled from: index.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b.\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B¬\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0010\b\u0002\u0010\t\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000e\u00127\b\u0002\u0010\u0015\u001a1\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0017¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0016j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u001c\u0012+\b\u0002\u0010\u001d\u001a%\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0016j\u0004\u0018\u0001`\u001f\u0012+\b\u0002\u0010 \u001a%\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0016j\u0004\u0018\u0001`!¢\u0006\u0004\b\"\u0010#R\u001e\u0010\u0003\u001a\u00020\u00048\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u0010\t\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010%\"\u0004\b1\u0010'R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001e\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0096\u000e¢\u0006\u0010\n\u0002\u0010:\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010%\"\u0004\b<\u0010'R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010%\"\u0004\b>\u0010'R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u000eX\u0096\u000e¢\u0006\u0010\n\u0002\u0010:\u001a\u0004\b?\u00107\"\u0004\b@\u00109R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u000eX\u0096\u000e¢\u0006\u0010\n\u0002\u0010:\u001a\u0004\bA\u00107\"\u0004\bB\u00109R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u000eX\u0096\u000e¢\u0006\u0010\n\u0002\u0010:\u001a\u0004\bC\u00107\"\u0004\bD\u00109R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u000eX\u0096\u000e¢\u0006\u0010\n\u0002\u0010:\u001a\u0004\bE\u00107\"\u0004\bF\u00109RI\u0010\u0015\u001a1\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0017¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0016j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u001cX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR=\u0010\u001d\u001a%\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0016j\u0004\u0018\u0001`\u001fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010H\"\u0004\bL\u0010JR=\u0010 \u001a%\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0016j\u0004\u0018\u0001`!X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010H\"\u0004\bN\u0010J¨\u0006O"}, d2 = {"Luts/sdk/modules/DCloudUniNetwork/RequestOptions;", "T", "Lio/dcloud/uts/UTSObject;", "url", "", "data", "", com.taobao.weex.ui.component.WXBasicComponentType.HEADER, "Lio/dcloud/uts/UTSJSONObject;", "method", "Luts/sdk/modules/DCloudUniNetwork/RequestMethod;", "timeout", "", "enableQuic", "", "dataType", "responseType", "sslVerify", "withCredentials", "firstIpv4", "enableChunked", com.taobao.weex.ui.component.WXImage.SUCCEED, "Lkotlin/Function1;", "Luts/sdk/modules/DCloudUniNetwork/RequestSuccess;", "Lkotlin/ParameterName;", "name", io.dcloud.common.constant.AbsoluteConst.JSON_KEY_OPTION, "", "Luts/sdk/modules/DCloudUniNetwork/RequestSuccessCallback;", com.taobao.weex.common.Constants.Event.FAIL, "Luts/sdk/modules/DCloudUniNetwork/RequestFail;", "Luts/sdk/modules/DCloudUniNetwork/RequestFailCallback;", "complete", "Luts/sdk/modules/DCloudUniNetwork/RequestCompleteCallback;", "<init>", "(Ljava/lang/String;Ljava/lang/Object;Lio/dcloud/uts/UTSJSONObject;Ljava/lang/String;Ljava/lang/Number;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "getData", "()Ljava/lang/Object;", "setData", "(Ljava/lang/Object;)V", "getHeader", "()Lio/dcloud/uts/UTSJSONObject;", "setHeader", "(Lio/dcloud/uts/UTSJSONObject;)V", "getMethod", "setMethod", "getTimeout", "()Ljava/lang/Number;", "setTimeout", "(Ljava/lang/Number;)V", "getEnableQuic", "()Ljava/lang/Boolean;", "setEnableQuic", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getDataType", "setDataType", "getResponseType", "setResponseType", "getSslVerify", "setSslVerify", "getWithCredentials", "setWithCredentials", "getFirstIpv4", "setFirstIpv4", "getEnableChunked", "setEnableChunked", "getSuccess", "()Lkotlin/jvm/functions/Function1;", "setSuccess", "(Lkotlin/jvm/functions/Function1;)V", "getFail", "setFail", "getComplete", "setComplete", "uni-network_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class RequestOptions<T> extends io.dcloud.uts.UTSObject {
    private kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> complete;
    private java.lang.Object data;
    private java.lang.String dataType;
    private java.lang.Boolean enableChunked;
    private java.lang.Boolean enableQuic;
    private kotlin.jvm.functions.Function1<? super uts.sdk.modules.DCloudUniNetwork.RequestFail, kotlin.Unit> fail;
    private java.lang.Boolean firstIpv4;
    private io.dcloud.uts.UTSJSONObject header;
    private java.lang.String method;
    private java.lang.String responseType;
    private java.lang.Boolean sslVerify;
    private kotlin.jvm.functions.Function1<? super uts.sdk.modules.DCloudUniNetwork.RequestSuccess<T>, kotlin.Unit> success;
    private java.lang.Number timeout;

    @io.dcloud.uts.JsonNotNull
    private java.lang.String url;
    private java.lang.Boolean withCredentials;

    public /* synthetic */ RequestOptions(java.lang.String str, java.lang.Object obj, io.dcloud.uts.UTSJSONObject uTSJSONObject, java.lang.String str2, java.lang.Number number, java.lang.Boolean bool, java.lang.String str3, java.lang.String str4, java.lang.Boolean bool2, java.lang.Boolean bool3, java.lang.Boolean bool4, java.lang.Boolean bool5, kotlin.jvm.functions.Function1 function1, kotlin.jvm.functions.Function1 function2, kotlin.jvm.functions.Function1 function3, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : obj, (i & 4) != 0 ? null : uTSJSONObject, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : number, (i & 32) != 0 ? null : bool, (i & 64) != 0 ? null : str3, (i & 128) != 0 ? null : str4, (i & 256) != 0 ? null : bool2, (i & 512) != 0 ? null : bool3, (i & 1024) != 0 ? null : bool4, (i & 2048) != 0 ? null : bool5, (i & 4096) != 0 ? null : function1, (i & 8192) != 0 ? null : function2, (i & 16384) != 0 ? null : function3);
    }

    public java.lang.String getUrl() {
        return this.url;
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

    public kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniNetwork.RequestSuccess<T>, kotlin.Unit> getSuccess() {
        return this.success;
    }

    public void setSuccess(kotlin.jvm.functions.Function1<? super uts.sdk.modules.DCloudUniNetwork.RequestSuccess<T>, kotlin.Unit> function1) {
        this.success = function1;
    }

    public kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniNetwork.RequestFail, kotlin.Unit> getFail() {
        return this.fail;
    }

    public void setFail(kotlin.jvm.functions.Function1<? super uts.sdk.modules.DCloudUniNetwork.RequestFail, kotlin.Unit> function1) {
        this.fail = function1;
    }

    public kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> getComplete() {
        return this.complete;
    }

    public void setComplete(kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> function1) {
        this.complete = function1;
    }

    public RequestOptions(java.lang.String url, java.lang.Object obj, io.dcloud.uts.UTSJSONObject uTSJSONObject, java.lang.String str, java.lang.Number number, java.lang.Boolean bool, java.lang.String str2, java.lang.String str3, java.lang.Boolean bool2, java.lang.Boolean bool3, java.lang.Boolean bool4, java.lang.Boolean bool5, kotlin.jvm.functions.Function1<? super uts.sdk.modules.DCloudUniNetwork.RequestSuccess<T>, kotlin.Unit> function1, kotlin.jvm.functions.Function1<? super uts.sdk.modules.DCloudUniNetwork.RequestFail, kotlin.Unit> function2, kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> function3) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(url, "url");
        this.url = url;
        this.data = obj;
        this.header = uTSJSONObject;
        this.method = str;
        this.timeout = number;
        this.enableQuic = bool;
        this.dataType = str2;
        this.responseType = str3;
        this.sslVerify = bool2;
        this.withCredentials = bool3;
        this.firstIpv4 = bool4;
        this.enableChunked = bool5;
        this.success = function1;
        this.fail = function2;
        this.complete = function3;
    }
}
