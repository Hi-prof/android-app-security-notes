package uts.sdk.modules.DCloudUniPrompt;

/* JADX INFO: compiled from: index.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0016\u0018\u00002\u00020\u0001Bµ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012+\b\u0002\u0010\u0006\u001a%\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007j\u0004\u0018\u0001`\r\u0012>\b\u0002\u0010\u000e\u001a8\u0012&\u0012$0\u000fj\u0011`\u0010¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007j\u0004\u0018\u0001`\u0011\u0012+\b\u0002\u0010\u0012\u001a%\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007j\u0004\u0018\u0001`\u0014¢\u0006\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0002\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR=\u0010\u0006\u001a%\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007j\u0004\u0018\u0001`\rX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#RP\u0010\u000e\u001a8\u0012&\u0012$0\u000fj\u0011`\u0010¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007j\u0004\u0018\u0001`\u0011X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010!\"\u0004\b%\u0010#R=\u0010\u0012\u001a%\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007j\u0004\u0018\u0001`\u0014X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010!\"\u0004\b'\u0010#¨\u0006("}, d2 = {"Luts/sdk/modules/DCloudUniPrompt/ShowLoadingOptions;", "Lio/dcloud/uts/UTSObject;", io.dcloud.common.constant.AbsoluteConst.JSON_KEY_TITLE, "", io.dcloud.common.constant.AbsoluteConst.JSON_KEY_MASK, "", com.taobao.weex.ui.component.WXImage.SUCCEED, "Lkotlin/Function1;", "Luts/sdk/modules/DCloudUniPrompt/ShowLoadingSuccess;", "Lkotlin/ParameterName;", "name", com.facebook.common.util.UriUtil.LOCAL_RESOURCE_SCHEME, "", "Luts/sdk/modules/DCloudUniPrompt/ShowLoadingSuccessCallback;", com.taobao.weex.common.Constants.Event.FAIL, "Luts/sdk/modules/DCloudUniPrompt/IPromptError;", "Luts/sdk/modules/DCloudUniPrompt/ShowLoadingFail;", "Luts/sdk/modules/DCloudUniPrompt/ShowLoadingFailCallback;", "complete", "", "Luts/sdk/modules/DCloudUniPrompt/ShowLoadingCompleteCallback;", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "getMask", "()Ljava/lang/Boolean;", "setMask", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getSuccess", "()Lkotlin/jvm/functions/Function1;", "setSuccess", "(Lkotlin/jvm/functions/Function1;)V", "getFail", "setFail", "getComplete", "setComplete", "uni-prompt_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class ShowLoadingOptions extends io.dcloud.uts.UTSObject {
    private kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> complete;
    private kotlin.jvm.functions.Function1<? super uts.sdk.modules.DCloudUniPrompt.IPromptError, kotlin.Unit> fail;
    private java.lang.Boolean mask;
    private kotlin.jvm.functions.Function1<? super uts.sdk.modules.DCloudUniPrompt.ShowLoadingSuccess, kotlin.Unit> success;

    @io.dcloud.uts.JsonNotNull
    private java.lang.String title;

    public /* synthetic */ ShowLoadingOptions(java.lang.String str, java.lang.Boolean bool, kotlin.jvm.functions.Function1 function1, kotlin.jvm.functions.Function1 function2, kotlin.jvm.functions.Function1 function3, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : bool, (i & 4) != 0 ? null : function1, (i & 8) != 0 ? null : function2, (i & 16) != 0 ? null : function3);
    }

    public java.lang.String getTitle() {
        return this.title;
    }

    public void setTitle(java.lang.String str) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    public java.lang.Boolean getMask() {
        return this.mask;
    }

    public void setMask(java.lang.Boolean bool) {
        this.mask = bool;
    }

    public kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniPrompt.ShowLoadingSuccess, kotlin.Unit> getSuccess() {
        return this.success;
    }

    public void setSuccess(kotlin.jvm.functions.Function1<? super uts.sdk.modules.DCloudUniPrompt.ShowLoadingSuccess, kotlin.Unit> function1) {
        this.success = function1;
    }

    public kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniPrompt.IPromptError, kotlin.Unit> getFail() {
        return this.fail;
    }

    public void setFail(kotlin.jvm.functions.Function1<? super uts.sdk.modules.DCloudUniPrompt.IPromptError, kotlin.Unit> function1) {
        this.fail = function1;
    }

    public kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> getComplete() {
        return this.complete;
    }

    public void setComplete(kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> function1) {
        this.complete = function1;
    }

    public ShowLoadingOptions(java.lang.String title, java.lang.Boolean bool, kotlin.jvm.functions.Function1<? super uts.sdk.modules.DCloudUniPrompt.ShowLoadingSuccess, kotlin.Unit> function1, kotlin.jvm.functions.Function1<? super uts.sdk.modules.DCloudUniPrompt.IPromptError, kotlin.Unit> function2, kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> function3) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(title, "title");
        this.title = title;
        this.mask = bool;
        this.success = function1;
        this.fail = function2;
        this.complete = function3;
    }
}
