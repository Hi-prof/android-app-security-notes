package uts.sdk.modules.DCloudUniPrompt;

/* JADX INFO: compiled from: index.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\"\b\u0016\u0018\u00002\u00020\u0001B\u008d\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012+\b\u0002\u0010\r\u001a%\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000ej\u0004\u0018\u0001`\u0014\u0012>\b\u0002\u0010\u0015\u001a8\u0012&\u0012$0\u0016j\u0011`\u0017¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000ej\u0004\u0018\u0001`\u0018\u0012+\b\u0002\u0010\u0019\u001a%\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000ej\u0004\u0018\u0001`\u001b¢\u0006\u0004\b\u001c\u0010\u001dR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001f\"\u0004\b#\u0010!R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0096\u000e¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001f\"\u0004\b*\u0010!R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001f\"\u0004\b,\u0010!R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001f\"\u0004\b.\u0010!R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u001f\"\u0004\b0\u0010!R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u0096\u000e¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\b1\u0010%\"\u0004\b2\u0010'R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u001f\"\u0004\b4\u0010!R=\u0010\r\u001a%\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000ej\u0004\u0018\u0001`\u0014X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108RP\u0010\u0015\u001a8\u0012&\u0012$0\u0016j\u0011`\u0017¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000ej\u0004\u0018\u0001`\u0018X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u00106\"\u0004\b:\u00108R=\u0010\u0019\u001a%\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000ej\u0004\u0018\u0001`\u001bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u00106\"\u0004\b<\u00108¨\u0006="}, d2 = {"Luts/sdk/modules/DCloudUniPrompt/ShowModalOptions;", "Lio/dcloud/uts/UTSObject;", io.dcloud.common.constant.AbsoluteConst.JSON_KEY_TITLE, "", com.facebook.common.util.UriUtil.LOCAL_CONTENT_SCHEME, "showCancel", "", "cancelText", "cancelColor", "confirmText", "confirmColor", "editable", "placeholderText", com.taobao.weex.ui.component.WXImage.SUCCEED, "Lkotlin/Function1;", "Luts/sdk/modules/DCloudUniPrompt/ShowModalSuccess;", "Lkotlin/ParameterName;", "name", com.facebook.common.util.UriUtil.LOCAL_RESOURCE_SCHEME, "", "Luts/sdk/modules/DCloudUniPrompt/ShowModalSuccessCallback;", com.taobao.weex.common.Constants.Event.FAIL, "Luts/sdk/modules/DCloudUniPrompt/IPromptError;", "Luts/sdk/modules/DCloudUniPrompt/ShowModalFail;", "Luts/sdk/modules/DCloudUniPrompt/ShowModalFailCallback;", "complete", "", "Luts/sdk/modules/DCloudUniPrompt/ShowModalCompleteCallback;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "getContent", "setContent", "getShowCancel", "()Ljava/lang/Boolean;", "setShowCancel", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getCancelText", "setCancelText", "getCancelColor", "setCancelColor", "getConfirmText", "setConfirmText", "getConfirmColor", "setConfirmColor", "getEditable", "setEditable", "getPlaceholderText", "setPlaceholderText", "getSuccess", "()Lkotlin/jvm/functions/Function1;", "setSuccess", "(Lkotlin/jvm/functions/Function1;)V", "getFail", "setFail", "getComplete", "setComplete", "uni-prompt_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class ShowModalOptions extends io.dcloud.uts.UTSObject {
    private java.lang.String cancelColor;
    private java.lang.String cancelText;
    private kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> complete;
    private java.lang.String confirmColor;
    private java.lang.String confirmText;
    private java.lang.String content;
    private java.lang.Boolean editable;
    private kotlin.jvm.functions.Function1<? super uts.sdk.modules.DCloudUniPrompt.IPromptError, kotlin.Unit> fail;
    private java.lang.String placeholderText;
    private java.lang.Boolean showCancel;
    private kotlin.jvm.functions.Function1<? super uts.sdk.modules.DCloudUniPrompt.ShowModalSuccess, kotlin.Unit> success;
    private java.lang.String title;

    public ShowModalOptions() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, 4095, null);
    }

    public java.lang.String getTitle() {
        return this.title;
    }

    public void setTitle(java.lang.String str) {
        this.title = str;
    }

    public java.lang.String getContent() {
        return this.content;
    }

    public void setContent(java.lang.String str) {
        this.content = str;
    }

    public /* synthetic */ ShowModalOptions(java.lang.String str, java.lang.String str2, java.lang.Boolean bool, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.lang.Boolean bool2, java.lang.String str7, kotlin.jvm.functions.Function1 function1, kotlin.jvm.functions.Function1 function2, kotlin.jvm.functions.Function1 function3, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? true : bool, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : str6, (i & 128) != 0 ? false : bool2, (i & 256) != 0 ? null : str7, (i & 512) != 0 ? null : function1, (i & 1024) != 0 ? null : function2, (i & 2048) != 0 ? null : function3);
    }

    public java.lang.Boolean getShowCancel() {
        return this.showCancel;
    }

    public void setShowCancel(java.lang.Boolean bool) {
        this.showCancel = bool;
    }

    public java.lang.String getCancelText() {
        return this.cancelText;
    }

    public void setCancelText(java.lang.String str) {
        this.cancelText = str;
    }

    public java.lang.String getCancelColor() {
        return this.cancelColor;
    }

    public void setCancelColor(java.lang.String str) {
        this.cancelColor = str;
    }

    public java.lang.String getConfirmText() {
        return this.confirmText;
    }

    public void setConfirmText(java.lang.String str) {
        this.confirmText = str;
    }

    public java.lang.String getConfirmColor() {
        return this.confirmColor;
    }

    public void setConfirmColor(java.lang.String str) {
        this.confirmColor = str;
    }

    public java.lang.Boolean getEditable() {
        return this.editable;
    }

    public void setEditable(java.lang.Boolean bool) {
        this.editable = bool;
    }

    public java.lang.String getPlaceholderText() {
        return this.placeholderText;
    }

    public void setPlaceholderText(java.lang.String str) {
        this.placeholderText = str;
    }

    public kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniPrompt.ShowModalSuccess, kotlin.Unit> getSuccess() {
        return this.success;
    }

    public void setSuccess(kotlin.jvm.functions.Function1<? super uts.sdk.modules.DCloudUniPrompt.ShowModalSuccess, kotlin.Unit> function1) {
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

    public ShowModalOptions(java.lang.String str, java.lang.String str2, java.lang.Boolean bool, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.lang.Boolean bool2, java.lang.String str7, kotlin.jvm.functions.Function1<? super uts.sdk.modules.DCloudUniPrompt.ShowModalSuccess, kotlin.Unit> function1, kotlin.jvm.functions.Function1<? super uts.sdk.modules.DCloudUniPrompt.IPromptError, kotlin.Unit> function2, kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> function3) {
        this.title = str;
        this.content = str2;
        this.showCancel = bool;
        this.cancelText = str3;
        this.cancelColor = str4;
        this.confirmText = str5;
        this.confirmColor = str6;
        this.editable = bool2;
        this.placeholderText = str7;
        this.success = function1;
        this.fail = function2;
        this.complete = function3;
    }
}
