package uts.sdk.modules.DCloudUniPrompt;

/* JADX INFO: compiled from: index.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\b\u0016\u0018\u00002\u00020\u0001Bß\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012+\b\u0002\u0010\n\u001a%\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000bj\u0004\u0018\u0001`\u0011\u0012>\b\u0002\u0010\u0012\u001a8\u0012&\u0012$0\u0013j\u0011`\u0014¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000bj\u0004\u0018\u0001`\u0015\u0012+\b\u0002\u0010\u0016\u001a%\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000bj\u0004\u0018\u0001`\u0018¢\u0006\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001c\"\u0004\b \u0010\u001eR$\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001c\"\u0004\b&\u0010\u001eR\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R=\u0010\n\u001a%\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000bj\u0004\u0018\u0001`\u0011X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.RP\u0010\u0012\u001a8\u0012&\u0012$0\u0013j\u0011`\u0014¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000bj\u0004\u0018\u0001`\u0015X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010,\"\u0004\b0\u0010.R=\u0010\u0016\u001a%\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000bj\u0004\u0018\u0001`\u0018X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010,\"\u0004\b2\u0010.¨\u00063"}, d2 = {"Luts/sdk/modules/DCloudUniPrompt/ShowActionSheetOptions;", "Lio/dcloud/uts/UTSObject;", io.dcloud.common.constant.AbsoluteConst.JSON_KEY_TITLE, "", "alertText", "itemList", "Lio/dcloud/uts/UTSArray;", com.taobao.weex.common.Constants.Name.ITEM_COLOR, io.dcloud.common.constant.AbsoluteConst.JSON_KEY_POPOVER, "Luts/sdk/modules/DCloudUniPrompt/Popover;", com.taobao.weex.ui.component.WXImage.SUCCEED, "Lkotlin/Function1;", "Luts/sdk/modules/DCloudUniPrompt/ShowActionSheetSuccess;", "Lkotlin/ParameterName;", "name", com.facebook.common.util.UriUtil.LOCAL_RESOURCE_SCHEME, "", "Luts/sdk/modules/DCloudUniPrompt/ShowActionSheetSuccessCallback;", com.taobao.weex.common.Constants.Event.FAIL, "Luts/sdk/modules/DCloudUniPrompt/IPromptError;", "Luts/sdk/modules/DCloudUniPrompt/ShowActionSheetFail;", "Luts/sdk/modules/DCloudUniPrompt/ShowActionSheetFailCallback;", "complete", "", "Luts/sdk/modules/DCloudUniPrompt/ShowActionSheetCompleteCallback;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lio/dcloud/uts/UTSArray;Ljava/lang/String;Luts/sdk/modules/DCloudUniPrompt/Popover;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "getAlertText", "setAlertText", "getItemList", "()Lio/dcloud/uts/UTSArray;", "setItemList", "(Lio/dcloud/uts/UTSArray;)V", "getItemColor", "setItemColor", "getPopover", "()Luts/sdk/modules/DCloudUniPrompt/Popover;", "setPopover", "(Luts/sdk/modules/DCloudUniPrompt/Popover;)V", "getSuccess", "()Lkotlin/jvm/functions/Function1;", "setSuccess", "(Lkotlin/jvm/functions/Function1;)V", "getFail", "setFail", "getComplete", "setComplete", "uni-prompt_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class ShowActionSheetOptions extends io.dcloud.uts.UTSObject {
    private java.lang.String alertText;
    private kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> complete;
    private kotlin.jvm.functions.Function1<? super uts.sdk.modules.DCloudUniPrompt.IPromptError, kotlin.Unit> fail;
    private java.lang.String itemColor;

    @io.dcloud.uts.JsonNotNull
    private io.dcloud.uts.UTSArray<java.lang.String> itemList;
    private uts.sdk.modules.DCloudUniPrompt.Popover popover;
    private kotlin.jvm.functions.Function1<? super uts.sdk.modules.DCloudUniPrompt.ShowActionSheetSuccess, kotlin.Unit> success;
    private java.lang.String title;

    public /* synthetic */ ShowActionSheetOptions(java.lang.String str, java.lang.String str2, io.dcloud.uts.UTSArray uTSArray, java.lang.String str3, uts.sdk.modules.DCloudUniPrompt.Popover popover, kotlin.jvm.functions.Function1 function1, kotlin.jvm.functions.Function1 function2, kotlin.jvm.functions.Function1 function3, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, uTSArray, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : popover, (i & 32) != 0 ? null : function1, (i & 64) != 0 ? null : function2, (i & 128) != 0 ? null : function3);
    }

    public java.lang.String getTitle() {
        return this.title;
    }

    public void setTitle(java.lang.String str) {
        this.title = str;
    }

    public java.lang.String getAlertText() {
        return this.alertText;
    }

    public void setAlertText(java.lang.String str) {
        this.alertText = str;
    }

    public io.dcloud.uts.UTSArray<java.lang.String> getItemList() {
        return this.itemList;
    }

    public void setItemList(io.dcloud.uts.UTSArray<java.lang.String> uTSArray) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(uTSArray, "<set-?>");
        this.itemList = uTSArray;
    }

    public java.lang.String getItemColor() {
        return this.itemColor;
    }

    public void setItemColor(java.lang.String str) {
        this.itemColor = str;
    }

    public uts.sdk.modules.DCloudUniPrompt.Popover getPopover() {
        return this.popover;
    }

    public void setPopover(uts.sdk.modules.DCloudUniPrompt.Popover popover) {
        this.popover = popover;
    }

    public kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniPrompt.ShowActionSheetSuccess, kotlin.Unit> getSuccess() {
        return this.success;
    }

    public void setSuccess(kotlin.jvm.functions.Function1<? super uts.sdk.modules.DCloudUniPrompt.ShowActionSheetSuccess, kotlin.Unit> function1) {
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

    public ShowActionSheetOptions(java.lang.String str, java.lang.String str2, io.dcloud.uts.UTSArray<java.lang.String> itemList, java.lang.String str3, uts.sdk.modules.DCloudUniPrompt.Popover popover, kotlin.jvm.functions.Function1<? super uts.sdk.modules.DCloudUniPrompt.ShowActionSheetSuccess, kotlin.Unit> function1, kotlin.jvm.functions.Function1<? super uts.sdk.modules.DCloudUniPrompt.IPromptError, kotlin.Unit> function2, kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> function3) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(itemList, "itemList");
        this.title = str;
        this.alertText = str2;
        this.itemList = itemList;
        this.itemColor = str3;
        this.popover = popover;
        this.success = function1;
        this.fail = function2;
        this.complete = function3;
    }
}
