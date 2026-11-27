package uts.sdk.modules.DCloudUniPrompt;

/* JADX INFO: compiled from: index.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001e\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0096\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0007\"\u0004\b\u0016\u0010\tR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0007\"\u0004\b\u0019\u0010\tR\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0007\"\u0004\b\u001c\u0010\tR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0007\"\u0004\b\u001f\u0010\tR\u001e\u0010 \u001a\u0004\u0018\u00010\u000eX\u0096\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b!\u0010\u0010\"\u0004\b\"\u0010\u0012R\u001c\u0010#\u001a\u0004\u0018\u00010\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0007\"\u0004\b%\u0010\tR\u001c\u0010&\u001a\u0004\u0018\u00010'X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010,\u001a\u0004\u0018\u00010'X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010)\"\u0004\b.\u0010+R\u001c\u0010/\u001a\u0004\u0018\u00010'X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010)\"\u0004\b1\u0010+¨\u00062"}, d2 = {"Luts/sdk/modules/DCloudUniPrompt/ShowModalOptionsJSONObject;", "Lio/dcloud/uts/UTSJSONObject;", "<init>", "()V", io.dcloud.common.constant.AbsoluteConst.JSON_KEY_TITLE, "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", com.facebook.common.util.UriUtil.LOCAL_CONTENT_SCHEME, "getContent", "setContent", "showCancel", "", "getShowCancel", "()Ljava/lang/Boolean;", "setShowCancel", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "cancelText", "getCancelText", "setCancelText", "cancelColor", "getCancelColor", "setCancelColor", "confirmText", "getConfirmText", "setConfirmText", "confirmColor", "getConfirmColor", "setConfirmColor", "editable", "getEditable", "setEditable", "placeholderText", "getPlaceholderText", "setPlaceholderText", com.taobao.weex.ui.component.WXImage.SUCCEED, "Lio/dcloud/uts/UTSCallback;", "getSuccess", "()Lio/dcloud/uts/UTSCallback;", "setSuccess", "(Lio/dcloud/uts/UTSCallback;)V", com.taobao.weex.common.Constants.Event.FAIL, "getFail", "setFail", "complete", "getComplete", "setComplete", "uni-prompt_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class ShowModalOptionsJSONObject extends io.dcloud.uts.UTSJSONObject {
    private java.lang.String cancelColor;
    private java.lang.String cancelText;
    private io.dcloud.uts.UTSCallback complete;
    private java.lang.String confirmColor;
    private java.lang.String confirmText;
    private java.lang.String content;
    private io.dcloud.uts.UTSCallback fail;
    private java.lang.String placeholderText;
    private io.dcloud.uts.UTSCallback success;
    private java.lang.String title;
    private java.lang.Boolean showCancel = true;
    private java.lang.Boolean editable = false;

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
