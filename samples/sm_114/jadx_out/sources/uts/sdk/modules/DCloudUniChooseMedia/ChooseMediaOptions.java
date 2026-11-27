package uts.sdk.modules.DCloudUniChooseMedia;

/* JADX INFO: compiled from: index.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\b\u0016\u0018\u00002\u00020\u0001Bû\u0001\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012+\b\u0002\u0010\f\u001a%\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\rj\u0004\u0018\u0001`\u0013\u0012>\b\u0002\u0010\u0014\u001a8\u0012&\u0012$0\u0015j\u0011`\u0016¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\rj\u0004\u0018\u0001`\u0017\u0012+\b\u0002\u0010\u0018\u001a%\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\rj\u0004\u0018\u0001`\u001a¢\u0006\u0004\b\u001b\u0010\u001cR\"\u0010\u0002\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010&\"\u0004\b*\u0010(R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\"\"\u0004\b,\u0010$R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001e\"\u0004\b.\u0010 R=\u0010\f\u001a%\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\rj\u0004\u0018\u0001`\u0013X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102RP\u0010\u0014\u001a8\u0012&\u0012$0\u0015j\u0011`\u0016¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\rj\u0004\u0018\u0001`\u0017X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00100\"\u0004\b4\u00102R=\u0010\u0018\u001a%\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\rj\u0004\u0018\u0001`\u001aX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00100\"\u0004\b6\u00102¨\u00067"}, d2 = {"Luts/sdk/modules/DCloudUniChooseMedia/ChooseMediaOptions;", "Lio/dcloud/uts/UTSObject;", "pageOrientation", "", "Luts/sdk/modules/DCloudUniChooseMedia/ChooseMediaPageOrientation;", "count", "", "mediaType", "Lio/dcloud/uts/UTSArray;", "sourceType", "maxDuration", "camera", com.taobao.weex.ui.component.WXImage.SUCCEED, "Lkotlin/Function1;", "Luts/sdk/modules/DCloudUniChooseMedia/ChooseMediaSuccess;", "Lkotlin/ParameterName;", "name", com.taobao.weex.bridge.WXBridgeManager.METHOD_CALLBACK, "", "Luts/sdk/modules/DCloudUniChooseMedia/ChooseMediaSuccessCallback;", com.taobao.weex.common.Constants.Event.FAIL, "Luts/sdk/modules/DCloudUniChooseMedia/IChooseMediaError;", "Luts/sdk/modules/DCloudUniChooseMedia/ChooseMediaFail;", "Luts/sdk/modules/DCloudUniChooseMedia/ChooseMediaFailCallback;", "complete", "", "Luts/sdk/modules/DCloudUniChooseMedia/ChooseMediaCompleteCallback;", "<init>", "(Ljava/lang/String;Ljava/lang/Number;Lio/dcloud/uts/UTSArray;Lio/dcloud/uts/UTSArray;Ljava/lang/Number;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getPageOrientation", "()Ljava/lang/String;", "setPageOrientation", "(Ljava/lang/String;)V", "getCount", "()Ljava/lang/Number;", "setCount", "(Ljava/lang/Number;)V", "getMediaType", "()Lio/dcloud/uts/UTSArray;", "setMediaType", "(Lio/dcloud/uts/UTSArray;)V", "getSourceType", "setSourceType", "getMaxDuration", "setMaxDuration", "getCamera", "setCamera", "getSuccess", "()Lkotlin/jvm/functions/Function1;", "setSuccess", "(Lkotlin/jvm/functions/Function1;)V", "getFail", "setFail", "getComplete", "setComplete", "uni-chooseMedia_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class ChooseMediaOptions extends io.dcloud.uts.UTSObject {
    private java.lang.String camera;
    private kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> complete;
    private java.lang.Number count;
    private kotlin.jvm.functions.Function1<? super uts.sdk.modules.DCloudUniChooseMedia.IChooseMediaError, kotlin.Unit> fail;
    private java.lang.Number maxDuration;
    private io.dcloud.uts.UTSArray<java.lang.String> mediaType;
    private java.lang.String pageOrientation;
    private io.dcloud.uts.UTSArray<java.lang.String> sourceType;
    private kotlin.jvm.functions.Function1<? super uts.sdk.modules.DCloudUniChooseMedia.ChooseMediaSuccess, kotlin.Unit> success;

    public ChooseMediaOptions() {
        this(null, null, null, null, null, null, null, null, null, androidx.core.app.FrameMetricsAggregator.EVERY_DURATION, null);
    }

    public /* synthetic */ ChooseMediaOptions(java.lang.String str, java.lang.Number number, io.dcloud.uts.UTSArray uTSArray, io.dcloud.uts.UTSArray uTSArray2, java.lang.Number number2, java.lang.String str2, kotlin.jvm.functions.Function1 function1, kotlin.jvm.functions.Function1 function2, kotlin.jvm.functions.Function1 function3, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : number, (i & 4) != 0 ? null : uTSArray, (i & 8) != 0 ? null : uTSArray2, (i & 16) != 0 ? null : number2, (i & 32) != 0 ? null : str2, (i & 64) != 0 ? null : function1, (i & 128) != 0 ? null : function2, (i & 256) != 0 ? null : function3);
    }

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

    public kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniChooseMedia.ChooseMediaSuccess, kotlin.Unit> getSuccess() {
        return this.success;
    }

    public void setSuccess(kotlin.jvm.functions.Function1<? super uts.sdk.modules.DCloudUniChooseMedia.ChooseMediaSuccess, kotlin.Unit> function1) {
        this.success = function1;
    }

    public kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniChooseMedia.IChooseMediaError, kotlin.Unit> getFail() {
        return this.fail;
    }

    public void setFail(kotlin.jvm.functions.Function1<? super uts.sdk.modules.DCloudUniChooseMedia.IChooseMediaError, kotlin.Unit> function1) {
        this.fail = function1;
    }

    public kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> getComplete() {
        return this.complete;
    }

    public void setComplete(kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> function1) {
        this.complete = function1;
    }

    public ChooseMediaOptions(java.lang.String str, java.lang.Number number, io.dcloud.uts.UTSArray<java.lang.String> uTSArray, io.dcloud.uts.UTSArray<java.lang.String> uTSArray2, java.lang.Number number2, java.lang.String str2, kotlin.jvm.functions.Function1<? super uts.sdk.modules.DCloudUniChooseMedia.ChooseMediaSuccess, kotlin.Unit> function1, kotlin.jvm.functions.Function1<? super uts.sdk.modules.DCloudUniChooseMedia.IChooseMediaError, kotlin.Unit> function2, kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> function3) {
        this.pageOrientation = str;
        this.count = number;
        this.mediaType = uTSArray;
        this.sourceType = uTSArray2;
        this.maxDuration = number2;
        this.camera = str2;
        this.success = function1;
        this.fail = function2;
        this.complete = function3;
    }
}
