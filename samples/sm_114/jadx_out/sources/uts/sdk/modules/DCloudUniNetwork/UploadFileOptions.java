package uts.sdk.modules.DCloudUniNetwork;

/* JADX INFO: compiled from: index.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b!\b\u0016\u0018\u00002\u00020\u0001Bä\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012+\b\u0002\u0010\u000e\u001a%\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0005\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000fj\u0004\u0018\u0001`\u0014\u0012+\b\u0002\u0010\u0015\u001a%\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0011\u0012\b\b\u0005\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000fj\u0004\u0018\u0001`\u0017\u0012+\b\u0002\u0010\u0018\u001a%\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0011\u0012\b\b\u0005\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000fj\u0004\u0018\u0001`\u001a¢\u0006\u0004\b\u001b\u0010\u001cR\u001e\u0010\u0002\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001e\"\u0004\b\"\u0010 R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001e\"\u0004\b$\u0010 R\"\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010*\"\u0004\b.\u0010,R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R=\u0010\u000e\u001a%\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0005\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000fj\u0004\u0018\u0001`\u0014X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R=\u0010\u0015\u001a%\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0011\u0012\b\b\u0005\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000fj\u0004\u0018\u0001`\u0017X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00104\"\u0004\b8\u00106R=\u0010\u0018\u001a%\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0011\u0012\b\b\u0005\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000fj\u0004\u0018\u0001`\u001aX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u00104\"\u0004\b:\u00106¨\u0006;"}, d2 = {"Luts/sdk/modules/DCloudUniNetwork/UploadFileOptions;", "Lio/dcloud/uts/UTSObject;", "url", "", "filePath", "name", "files", "Lio/dcloud/uts/UTSArray;", "Luts/sdk/modules/DCloudUniNetwork/UploadFileOptionFiles;", com.taobao.weex.ui.component.WXBasicComponentType.HEADER, "Lio/dcloud/uts/UTSJSONObject;", "formData", "timeout", "", com.taobao.weex.ui.component.WXImage.SUCCEED, "Lkotlin/Function1;", "Luts/sdk/modules/DCloudUniNetwork/UploadFileSuccess;", "Lkotlin/ParameterName;", "result", "", "Luts/sdk/modules/DCloudUniNetwork/UploadFileSuccessCallback;", com.taobao.weex.common.Constants.Event.FAIL, "Luts/sdk/modules/DCloudUniNetwork/UploadFileFail;", "Luts/sdk/modules/DCloudUniNetwork/UploadFileFailCallback;", "complete", "", "Luts/sdk/modules/DCloudUniNetwork/UploadFileCompleteCallback;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lio/dcloud/uts/UTSArray;Lio/dcloud/uts/UTSJSONObject;Lio/dcloud/uts/UTSJSONObject;Ljava/lang/Number;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "getFilePath", "setFilePath", "getName", "setName", "getFiles", "()Lio/dcloud/uts/UTSArray;", "setFiles", "(Lio/dcloud/uts/UTSArray;)V", "getHeader", "()Lio/dcloud/uts/UTSJSONObject;", "setHeader", "(Lio/dcloud/uts/UTSJSONObject;)V", "getFormData", "setFormData", "getTimeout", "()Ljava/lang/Number;", "setTimeout", "(Ljava/lang/Number;)V", "getSuccess", "()Lkotlin/jvm/functions/Function1;", "setSuccess", "(Lkotlin/jvm/functions/Function1;)V", "getFail", "setFail", "getComplete", "setComplete", "uni-network_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class UploadFileOptions extends io.dcloud.uts.UTSObject {
    private kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> complete;
    private kotlin.jvm.functions.Function1<? super uts.sdk.modules.DCloudUniNetwork.UploadFileFail, kotlin.Unit> fail;
    private java.lang.String filePath;
    private io.dcloud.uts.UTSArray<uts.sdk.modules.DCloudUniNetwork.UploadFileOptionFiles> files;
    private io.dcloud.uts.UTSJSONObject formData;
    private io.dcloud.uts.UTSJSONObject header;
    private java.lang.String name;
    private kotlin.jvm.functions.Function1<? super uts.sdk.modules.DCloudUniNetwork.UploadFileSuccess, kotlin.Unit> success;
    private java.lang.Number timeout;

    @io.dcloud.uts.JsonNotNull
    private java.lang.String url;

    public /* synthetic */ UploadFileOptions(java.lang.String str, java.lang.String str2, java.lang.String str3, io.dcloud.uts.UTSArray uTSArray, io.dcloud.uts.UTSJSONObject uTSJSONObject, io.dcloud.uts.UTSJSONObject uTSJSONObject2, java.lang.Number number, kotlin.jvm.functions.Function1 function1, kotlin.jvm.functions.Function1 function2, kotlin.jvm.functions.Function1 function3, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : uTSArray, (i & 16) != 0 ? null : uTSJSONObject, (i & 32) != 0 ? null : uTSJSONObject2, (i & 64) != 0 ? null : number, (i & 128) != 0 ? null : function1, (i & 256) != 0 ? null : function2, (i & 512) != 0 ? null : function3);
    }

    public java.lang.String getUrl() {
        return this.url;
    }

    public void setUrl(java.lang.String str) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.url = str;
    }

    public java.lang.String getFilePath() {
        return this.filePath;
    }

    public void setFilePath(java.lang.String str) {
        this.filePath = str;
    }

    public java.lang.String getName() {
        return this.name;
    }

    public void setName(java.lang.String str) {
        this.name = str;
    }

    public io.dcloud.uts.UTSArray<uts.sdk.modules.DCloudUniNetwork.UploadFileOptionFiles> getFiles() {
        return this.files;
    }

    public void setFiles(io.dcloud.uts.UTSArray<uts.sdk.modules.DCloudUniNetwork.UploadFileOptionFiles> uTSArray) {
        this.files = uTSArray;
    }

    public io.dcloud.uts.UTSJSONObject getHeader() {
        return this.header;
    }

    public void setHeader(io.dcloud.uts.UTSJSONObject uTSJSONObject) {
        this.header = uTSJSONObject;
    }

    public io.dcloud.uts.UTSJSONObject getFormData() {
        return this.formData;
    }

    public void setFormData(io.dcloud.uts.UTSJSONObject uTSJSONObject) {
        this.formData = uTSJSONObject;
    }

    public java.lang.Number getTimeout() {
        return this.timeout;
    }

    public void setTimeout(java.lang.Number number) {
        this.timeout = number;
    }

    public kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniNetwork.UploadFileSuccess, kotlin.Unit> getSuccess() {
        return this.success;
    }

    public void setSuccess(kotlin.jvm.functions.Function1<? super uts.sdk.modules.DCloudUniNetwork.UploadFileSuccess, kotlin.Unit> function1) {
        this.success = function1;
    }

    public kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniNetwork.UploadFileFail, kotlin.Unit> getFail() {
        return this.fail;
    }

    public void setFail(kotlin.jvm.functions.Function1<? super uts.sdk.modules.DCloudUniNetwork.UploadFileFail, kotlin.Unit> function1) {
        this.fail = function1;
    }

    public kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> getComplete() {
        return this.complete;
    }

    public void setComplete(kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> function1) {
        this.complete = function1;
    }

    public UploadFileOptions(java.lang.String url, java.lang.String str, java.lang.String str2, io.dcloud.uts.UTSArray<uts.sdk.modules.DCloudUniNetwork.UploadFileOptionFiles> uTSArray, io.dcloud.uts.UTSJSONObject uTSJSONObject, io.dcloud.uts.UTSJSONObject uTSJSONObject2, java.lang.Number number, kotlin.jvm.functions.Function1<? super uts.sdk.modules.DCloudUniNetwork.UploadFileSuccess, kotlin.Unit> function1, kotlin.jvm.functions.Function1<? super uts.sdk.modules.DCloudUniNetwork.UploadFileFail, kotlin.Unit> function2, kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> function3) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(url, "url");
        this.url = url;
        this.filePath = str;
        this.name = str2;
        this.files = uTSArray;
        this.header = uTSJSONObject;
        this.formData = uTSJSONObject2;
        this.timeout = number;
        this.success = function1;
        this.fail = function2;
        this.complete = function3;
    }
}
