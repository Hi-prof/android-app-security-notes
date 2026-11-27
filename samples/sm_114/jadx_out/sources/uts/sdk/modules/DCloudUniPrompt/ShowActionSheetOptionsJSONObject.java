package uts.sdk.modules.DCloudUniPrompt;

/* JADX INFO: compiled from: index.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eX\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010\u001dX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R\u001c\u0010%\u001a\u0004\u0018\u00010\u001dX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001f\"\u0004\b'\u0010!¨\u0006("}, d2 = {"Luts/sdk/modules/DCloudUniPrompt/ShowActionSheetOptionsJSONObject;", "Lio/dcloud/uts/UTSJSONObject;", "<init>", "()V", io.dcloud.common.constant.AbsoluteConst.JSON_KEY_TITLE, "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "alertText", "getAlertText", "setAlertText", "itemList", "Lio/dcloud/uts/UTSArray;", "getItemList", "()Lio/dcloud/uts/UTSArray;", "setItemList", "(Lio/dcloud/uts/UTSArray;)V", com.taobao.weex.common.Constants.Name.ITEM_COLOR, "getItemColor", "setItemColor", io.dcloud.common.constant.AbsoluteConst.JSON_KEY_POPOVER, "Luts/sdk/modules/DCloudUniPrompt/Popover;", "getPopover", "()Luts/sdk/modules/DCloudUniPrompt/Popover;", "setPopover", "(Luts/sdk/modules/DCloudUniPrompt/Popover;)V", com.taobao.weex.ui.component.WXImage.SUCCEED, "Lio/dcloud/uts/UTSCallback;", "getSuccess", "()Lio/dcloud/uts/UTSCallback;", "setSuccess", "(Lio/dcloud/uts/UTSCallback;)V", com.taobao.weex.common.Constants.Event.FAIL, "getFail", "setFail", "complete", "getComplete", "setComplete", "uni-prompt_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class ShowActionSheetOptionsJSONObject extends io.dcloud.uts.UTSJSONObject {
    private java.lang.String alertText;
    private io.dcloud.uts.UTSCallback complete;
    private io.dcloud.uts.UTSCallback fail;
    private java.lang.String itemColor;
    public io.dcloud.uts.UTSArray<java.lang.String> itemList;
    private uts.sdk.modules.DCloudUniPrompt.Popover popover;
    private io.dcloud.uts.UTSCallback success;
    private java.lang.String title;

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
        io.dcloud.uts.UTSArray<java.lang.String> uTSArray = this.itemList;
        if (uTSArray != null) {
            return uTSArray;
        }
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("itemList");
        return null;
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
