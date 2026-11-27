package uts.sdk.modules.DCloudUniNetwork;

/* JADX INFO: compiled from: index.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0004\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0001X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0001X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010%\u001a\u0004\u0018\u00010&X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001c\u0010+\u001a\u0004\u0018\u00010&X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010(\"\u0004\b-\u0010*R\u001c\u0010.\u001a\u0004\u0018\u00010&X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010(\"\u0004\b0\u0010*¨\u00061"}, d2 = {"Luts/sdk/modules/DCloudUniNetwork/UploadFileOptionsJSONObject;", "Lio/dcloud/uts/UTSJSONObject;", "<init>", "()V", "url", "", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "filePath", "getFilePath", "setFilePath", "name", "getName", "setName", "files", "Lio/dcloud/uts/UTSArray;", "Luts/sdk/modules/DCloudUniNetwork/UploadFileOptionFiles;", "getFiles", "()Lio/dcloud/uts/UTSArray;", "setFiles", "(Lio/dcloud/uts/UTSArray;)V", com.taobao.weex.ui.component.WXBasicComponentType.HEADER, "getHeader", "()Lio/dcloud/uts/UTSJSONObject;", "setHeader", "(Lio/dcloud/uts/UTSJSONObject;)V", "formData", "getFormData", "setFormData", "timeout", "", "getTimeout", "()Ljava/lang/Number;", "setTimeout", "(Ljava/lang/Number;)V", com.taobao.weex.ui.component.WXImage.SUCCEED, "Lio/dcloud/uts/UTSCallback;", "getSuccess", "()Lio/dcloud/uts/UTSCallback;", "setSuccess", "(Lio/dcloud/uts/UTSCallback;)V", com.taobao.weex.common.Constants.Event.FAIL, "getFail", "setFail", "complete", "getComplete", "setComplete", "uni-network_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class UploadFileOptionsJSONObject extends io.dcloud.uts.UTSJSONObject {
    private io.dcloud.uts.UTSCallback complete;
    private io.dcloud.uts.UTSCallback fail;
    private java.lang.String filePath;
    private io.dcloud.uts.UTSArray<uts.sdk.modules.DCloudUniNetwork.UploadFileOptionFiles> files;
    private io.dcloud.uts.UTSJSONObject formData;
    private io.dcloud.uts.UTSJSONObject header;
    private java.lang.String name;
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
