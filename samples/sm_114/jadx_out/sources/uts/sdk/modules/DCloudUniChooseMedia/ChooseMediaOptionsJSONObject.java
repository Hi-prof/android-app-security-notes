package uts.sdk.modules.DCloudUniChooseMedia;

/* JADX INFO: compiled from: index.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0004\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0004\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0012X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0012X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\b\"\u0004\b\u001f\u0010\nR\u001c\u0010 \u001a\u0004\u0018\u00010!X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010&\u001a\u0004\u0018\u00010!X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010#\"\u0004\b(\u0010%R\u001c\u0010)\u001a\u0004\u0018\u00010!X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010#\"\u0004\b+\u0010%¨\u0006,"}, d2 = {"Luts/sdk/modules/DCloudUniChooseMedia/ChooseMediaOptionsJSONObject;", "Lio/dcloud/uts/UTSJSONObject;", "<init>", "()V", "pageOrientation", "", "Luts/sdk/modules/DCloudUniChooseMedia/ChooseMediaPageOrientation;", "getPageOrientation", "()Ljava/lang/String;", "setPageOrientation", "(Ljava/lang/String;)V", "count", "", "getCount", "()Ljava/lang/Number;", "setCount", "(Ljava/lang/Number;)V", "mediaType", "Lio/dcloud/uts/UTSArray;", "getMediaType", "()Lio/dcloud/uts/UTSArray;", "setMediaType", "(Lio/dcloud/uts/UTSArray;)V", "sourceType", "getSourceType", "setSourceType", "maxDuration", "getMaxDuration", "setMaxDuration", "camera", "getCamera", "setCamera", com.taobao.weex.ui.component.WXImage.SUCCEED, "Lio/dcloud/uts/UTSCallback;", "getSuccess", "()Lio/dcloud/uts/UTSCallback;", "setSuccess", "(Lio/dcloud/uts/UTSCallback;)V", com.taobao.weex.common.Constants.Event.FAIL, "getFail", "setFail", "complete", "getComplete", "setComplete", "uni-chooseMedia_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class ChooseMediaOptionsJSONObject extends io.dcloud.uts.UTSJSONObject {
    private java.lang.String camera;
    private io.dcloud.uts.UTSCallback complete;
    private java.lang.Number count;
    private io.dcloud.uts.UTSCallback fail;
    private java.lang.Number maxDuration;
    private io.dcloud.uts.UTSArray<java.lang.String> mediaType;
    private java.lang.String pageOrientation;
    private io.dcloud.uts.UTSArray<java.lang.String> sourceType;
    private io.dcloud.uts.UTSCallback success;

    public java.lang.String getPageOrientation() {
        return this.pageOrientation;
    }

    public void setPageOrientation(java.lang.String str) {
        this.pageOrientation = str;
    }

    public java.lang.Number getCount() {
        return this.count;
    }

    public void setCount(java.lang.Number number) {
        this.count = number;
    }

    public io.dcloud.uts.UTSArray<java.lang.String> getMediaType() {
        return this.mediaType;
    }

    public void setMediaType(io.dcloud.uts.UTSArray<java.lang.String> uTSArray) {
        this.mediaType = uTSArray;
    }

    public io.dcloud.uts.UTSArray<java.lang.String> getSourceType() {
        return this.sourceType;
    }

    public void setSourceType(io.dcloud.uts.UTSArray<java.lang.String> uTSArray) {
        this.sourceType = uTSArray;
    }

    public java.lang.Number getMaxDuration() {
        return this.maxDuration;
    }

    public void setMaxDuration(java.lang.Number number) {
        this.maxDuration = number;
    }

    public java.lang.String getCamera() {
        return this.camera;
    }

    public void setCamera(java.lang.String str) {
        this.camera = str;
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
