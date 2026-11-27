package uts.sdk.modules.DCloudUniNetwork;

/* JADX INFO: compiled from: index.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\b\u0016\u0018\u00002\u00020\u0001BÍ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012+\b\u0002\u0010\t\u001a%\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\nj\u0004\u0018\u0001`\u0010\u0012+\b\u0002\u0010\u0011\u001a%\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\nj\u0004\u0018\u0001`\u0013\u0012>\b\u0002\u0010\u0014\u001a8\u0012&\u0012$0\u0015j\u0011`\u0016¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\nj\u0004\u0018\u0001`\u0017¢\u0006\u0004\b\u0018\u0010\u0019R\u001e\u0010\u0002\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001b\"\u0004\b#\u0010\u001dR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R=\u0010\t\u001a%\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\nj\u0004\u0018\u0001`\u0010X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R=\u0010\u0011\u001a%\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\nj\u0004\u0018\u0001`\u0013X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010)\"\u0004\b-\u0010+RP\u0010\u0014\u001a8\u0012&\u0012$0\u0015j\u0011`\u0016¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\nj\u0004\u0018\u0001`\u0017X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010)\"\u0004\b/\u0010+¨\u00060"}, d2 = {"Luts/sdk/modules/DCloudUniNetwork/DownloadFileOptions;", "Lio/dcloud/uts/UTSObject;", "url", "", com.taobao.weex.ui.component.WXBasicComponentType.HEADER, "Lio/dcloud/uts/UTSJSONObject;", "filePath", "timeout", "", com.taobao.weex.ui.component.WXImage.SUCCEED, "Lkotlin/Function1;", "Luts/sdk/modules/DCloudUniNetwork/DownloadFileSuccess;", "Lkotlin/ParameterName;", "name", "result", "", "Luts/sdk/modules/DCloudUniNetwork/DownloadFileSuccessCallback;", com.taobao.weex.common.Constants.Event.FAIL, "Luts/sdk/modules/DCloudUniNetwork/DownloadFileFail;", "Luts/sdk/modules/DCloudUniNetwork/DownloadFileFailCallback;", "complete", "", "Luts/sdk/modules/DCloudUniNetwork/DownloadFileComplete;", "Luts/sdk/modules/DCloudUniNetwork/DownloadFileCompleteCallback;", "<init>", "(Ljava/lang/String;Lio/dcloud/uts/UTSJSONObject;Ljava/lang/String;Ljava/lang/Number;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "getHeader", "()Lio/dcloud/uts/UTSJSONObject;", "setHeader", "(Lio/dcloud/uts/UTSJSONObject;)V", "getFilePath", "setFilePath", "getTimeout", "()Ljava/lang/Number;", "setTimeout", "(Ljava/lang/Number;)V", "getSuccess", "()Lkotlin/jvm/functions/Function1;", "setSuccess", "(Lkotlin/jvm/functions/Function1;)V", "getFail", "setFail", "getComplete", "setComplete", "uni-network_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class DownloadFileOptions extends io.dcloud.uts.UTSObject {
    private kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> complete;
    private kotlin.jvm.functions.Function1<? super uts.sdk.modules.DCloudUniNetwork.DownloadFileFail, kotlin.Unit> fail;
    private java.lang.String filePath;
    private io.dcloud.uts.UTSJSONObject header;
    private kotlin.jvm.functions.Function1<? super uts.sdk.modules.DCloudUniNetwork.DownloadFileSuccess, kotlin.Unit> success;
    private java.lang.Number timeout;

    @io.dcloud.uts.JsonNotNull
    private java.lang.String url;

    public /* synthetic */ DownloadFileOptions(java.lang.String str, io.dcloud.uts.UTSJSONObject uTSJSONObject, java.lang.String str2, java.lang.Number number, kotlin.jvm.functions.Function1 function1, kotlin.jvm.functions.Function1 function2, kotlin.jvm.functions.Function1 function3, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : uTSJSONObject, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : number, (i & 16) != 0 ? null : function1, (i & 32) != 0 ? null : function2, (i & 64) != 0 ? null : function3);
    }

    public java.lang.String getUrl() {
        return this.url;
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

    public kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniNetwork.DownloadFileSuccess, kotlin.Unit> getSuccess() {
        return this.success;
    }

    public void setSuccess(kotlin.jvm.functions.Function1<? super uts.sdk.modules.DCloudUniNetwork.DownloadFileSuccess, kotlin.Unit> function1) {
        this.success = function1;
    }

    public kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniNetwork.DownloadFileFail, kotlin.Unit> getFail() {
        return this.fail;
    }

    public void setFail(kotlin.jvm.functions.Function1<? super uts.sdk.modules.DCloudUniNetwork.DownloadFileFail, kotlin.Unit> function1) {
        this.fail = function1;
    }

    public kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> getComplete() {
        return this.complete;
    }

    public void setComplete(kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> function1) {
        this.complete = function1;
    }

    public DownloadFileOptions(java.lang.String url, io.dcloud.uts.UTSJSONObject uTSJSONObject, java.lang.String str, java.lang.Number number, kotlin.jvm.functions.Function1<? super uts.sdk.modules.DCloudUniNetwork.DownloadFileSuccess, kotlin.Unit> function1, kotlin.jvm.functions.Function1<? super uts.sdk.modules.DCloudUniNetwork.DownloadFileFail, kotlin.Unit> function2, kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> function3) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(url, "url");
        this.url = url;
        this.header = uTSJSONObject;
        this.filePath = str;
        this.timeout = number;
        this.success = function1;
        this.fail = function2;
        this.complete = function3;
    }
}
