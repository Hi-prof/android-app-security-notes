package uts.sdk.modules.DCloudUniExit;

/* JADX INFO: compiled from: index.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u00002\u00020\u0001B¡\u0001\u0012+\b\u0002\u0010\u0002\u001a%\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003j\u0004\u0018\u0001`\t\u0012>\b\u0002\u0010\n\u001a8\u0012&\u0012$0\u000bj\u0011`\f¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003j\u0004\u0018\u0001`\r\u0012+\b\u0002\u0010\u000e\u001a%\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003j\u0004\u0018\u0001`\u0010¢\u0006\u0004\b\u0011\u0010\u0012R=\u0010\u0002\u001a%\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003j\u0004\u0018\u0001`\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016RP\u0010\n\u001a8\u0012&\u0012$0\u000bj\u0011`\f¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003j\u0004\u0018\u0001`\rX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R=\u0010\u000e\u001a%\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003j\u0004\u0018\u0001`\u0010X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016¨\u0006\u001b"}, d2 = {"Luts/sdk/modules/DCloudUniExit/ExitOptions;", "Lio/dcloud/uts/UTSObject;", com.taobao.weex.ui.component.WXImage.SUCCEED, "Lkotlin/Function1;", "Luts/sdk/modules/DCloudUniExit/ExitSuccess;", "Lkotlin/ParameterName;", "name", com.facebook.common.util.UriUtil.LOCAL_RESOURCE_SCHEME, "", "Luts/sdk/modules/DCloudUniExit/ExitSuccessCallback;", com.taobao.weex.common.Constants.Event.FAIL, "Luts/sdk/modules/DCloudUniExit/IExitError;", "Luts/sdk/modules/DCloudUniExit/ExitFail;", "Luts/sdk/modules/DCloudUniExit/ExitFailCallback;", "complete", "", "Luts/sdk/modules/DCloudUniExit/ExitCompleteCallback;", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getSuccess", "()Lkotlin/jvm/functions/Function1;", "setSuccess", "(Lkotlin/jvm/functions/Function1;)V", "getFail", "setFail", "getComplete", "setComplete", "uni-exit_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class ExitOptions extends io.dcloud.uts.UTSObject {
    private kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> complete;
    private kotlin.jvm.functions.Function1<? super uts.sdk.modules.DCloudUniExit.IExitError, kotlin.Unit> fail;
    private kotlin.jvm.functions.Function1<? super uts.sdk.modules.DCloudUniExit.ExitSuccess, kotlin.Unit> success;

    public ExitOptions() {
        this(null, null, null, 7, null);
    }

    public /* synthetic */ ExitOptions(kotlin.jvm.functions.Function1 function1, kotlin.jvm.functions.Function1 function2, kotlin.jvm.functions.Function1 function3, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : function1, (i & 2) != 0 ? null : function2, (i & 4) != 0 ? null : function3);
    }

    public kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniExit.ExitSuccess, kotlin.Unit> getSuccess() {
        return this.success;
    }

    public void setSuccess(kotlin.jvm.functions.Function1<? super uts.sdk.modules.DCloudUniExit.ExitSuccess, kotlin.Unit> function1) {
        this.success = function1;
    }

    public kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniExit.IExitError, kotlin.Unit> getFail() {
        return this.fail;
    }

    public void setFail(kotlin.jvm.functions.Function1<? super uts.sdk.modules.DCloudUniExit.IExitError, kotlin.Unit> function1) {
        this.fail = function1;
    }

    public kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> getComplete() {
        return this.complete;
    }

    public void setComplete(kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> function1) {
        this.complete = function1;
    }

    public ExitOptions(kotlin.jvm.functions.Function1<? super uts.sdk.modules.DCloudUniExit.ExitSuccess, kotlin.Unit> function1, kotlin.jvm.functions.Function1<? super uts.sdk.modules.DCloudUniExit.IExitError, kotlin.Unit> function2, kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> function3) {
        this.success = function1;
        this.fail = function2;
        this.complete = function3;
    }
}
