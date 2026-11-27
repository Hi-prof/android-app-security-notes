package uts.sdk.modules.DCloudUniPrompt;

/* JADX INFO: compiled from: index.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\b\u0016\u0018\u00002\u00020\u0001Bñ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\f\u0012+\b\u0002\u0010\r\u001a%\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000ej\u0004\u0018\u0001`\u0014\u0012>\b\u0002\u0010\u0015\u001a8\u0012&\u0012$0\u0016j\u0011`\u0017¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000ej\u0004\u0018\u0001`\u0018\u0012+\b\u0002\u0010\u0019\u001a%\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000ej\u0004\u0018\u0001`\u001b¢\u0006\u0004\b\u001c\u0010\u001dR\u001e\u0010\u0002\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010\u0004\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001f\"\u0004\b#\u0010!R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001f\"\u0004\b%\u0010!R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0096\u000e¢\u0006\u0010\n\u0002\u0010*\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u0010\u000b\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u001f\"\u0004\b0\u0010!R=\u0010\r\u001a%\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000ej\u0004\u0018\u0001`\u0014X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104RP\u0010\u0015\u001a8\u0012&\u0012$0\u0016j\u0011`\u0017¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000ej\u0004\u0018\u0001`\u0018X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00102\"\u0004\b6\u00104R=\u0010\u0019\u001a%\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000ej\u0004\u0018\u0001`\u001bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00102\"\u0004\b8\u00104¨\u00069"}, d2 = {"Luts/sdk/modules/DCloudUniPrompt/ShowToastOptions;", "Lio/dcloud/uts/UTSObject;", io.dcloud.common.constant.AbsoluteConst.JSON_KEY_TITLE, "", io.dcloud.common.constant.AbsoluteConst.JSON_KEY_ICON, "Luts/sdk/modules/DCloudUniPrompt/Icon;", "image", io.dcloud.common.constant.AbsoluteConst.JSON_KEY_MASK, "", "duration", "", "position", "Luts/sdk/modules/DCloudUniPrompt/ShowToastPosition;", com.taobao.weex.ui.component.WXImage.SUCCEED, "Lkotlin/Function1;", "Luts/sdk/modules/DCloudUniPrompt/ShowToastSuccess;", "Lkotlin/ParameterName;", "name", com.facebook.common.util.UriUtil.LOCAL_RESOURCE_SCHEME, "", "Luts/sdk/modules/DCloudUniPrompt/ShowToastSuccessCallback;", com.taobao.weex.common.Constants.Event.FAIL, "Luts/sdk/modules/DCloudUniPrompt/IPromptError;", "Luts/sdk/modules/DCloudUniPrompt/ShowToastFail;", "Luts/sdk/modules/DCloudUniPrompt/ShowToastFailCallback;", "complete", "", "Luts/sdk/modules/DCloudUniPrompt/ShowToastCompleteCallback;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Number;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "getIcon", "setIcon", "getImage", "setImage", "getMask", "()Ljava/lang/Boolean;", "setMask", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getDuration", "()Ljava/lang/Number;", "setDuration", "(Ljava/lang/Number;)V", "getPosition", "setPosition", "getSuccess", "()Lkotlin/jvm/functions/Function1;", "setSuccess", "(Lkotlin/jvm/functions/Function1;)V", "getFail", "setFail", "getComplete", "setComplete", "uni-prompt_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class ShowToastOptions extends io.dcloud.uts.UTSObject {
    private kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> complete;
    private java.lang.Number duration;
    private kotlin.jvm.functions.Function1<? super uts.sdk.modules.DCloudUniPrompt.IPromptError, kotlin.Unit> fail;
    private java.lang.String icon;
    private java.lang.String image;
    private java.lang.Boolean mask;
    private java.lang.String position;
    private kotlin.jvm.functions.Function1<? super uts.sdk.modules.DCloudUniPrompt.ShowToastSuccess, kotlin.Unit> success;

    @io.dcloud.uts.JsonNotNull
    private java.lang.String title;

    public /* synthetic */ ShowToastOptions(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.Boolean bool, java.lang.Number number, java.lang.String str4, kotlin.jvm.functions.Function1 function1, kotlin.jvm.functions.Function1 function2, kotlin.jvm.functions.Function1 function3, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : bool, (i & 16) != 0 ? null : number, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : function1, (i & 128) != 0 ? null : function2, (i & 256) != 0 ? null : function3);
    }

    public java.lang.String getTitle() {
        return this.title;
    }

    public void setTitle(java.lang.String str) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    public java.lang.String getIcon() {
        return this.icon;
    }

    public void setIcon(java.lang.String str) {
        this.icon = str;
    }

    public java.lang.String getImage() {
        return this.image;
    }

    public void setImage(java.lang.String str) {
        this.image = str;
    }

    public java.lang.Boolean getMask() {
        return this.mask;
    }

    public void setMask(java.lang.Boolean bool) {
        this.mask = bool;
    }

    public java.lang.Number getDuration() {
        return this.duration;
    }

    public void setDuration(java.lang.Number number) {
        this.duration = number;
    }

    public java.lang.String getPosition() {
        return this.position;
    }

    public void setPosition(java.lang.String str) {
        this.position = str;
    }

    public kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniPrompt.ShowToastSuccess, kotlin.Unit> getSuccess() {
        return this.success;
    }

    public void setSuccess(kotlin.jvm.functions.Function1<? super uts.sdk.modules.DCloudUniPrompt.ShowToastSuccess, kotlin.Unit> function1) {
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

    public ShowToastOptions(java.lang.String title, java.lang.String str, java.lang.String str2, java.lang.Boolean bool, java.lang.Number number, java.lang.String str3, kotlin.jvm.functions.Function1<? super uts.sdk.modules.DCloudUniPrompt.ShowToastSuccess, kotlin.Unit> function1, kotlin.jvm.functions.Function1<? super uts.sdk.modules.DCloudUniPrompt.IPromptError, kotlin.Unit> function2, kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> function3) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(title, "title");
        this.title = title;
        this.icon = str;
        this.image = str2;
        this.mask = bool;
        this.duration = number;
        this.position = str3;
        this.success = function1;
        this.fail = function2;
        this.complete = function3;
    }
}
