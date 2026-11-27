package uts.sdk.modules.DCloudUniPrompt;

/* JADX INFO: compiled from: index.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016R\u001a\u0010\n\u001a\u00020\u0003X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0005X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0007X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001d"}, d2 = {"Luts/sdk/modules/DCloudUniPrompt/ItemClickListener;", "Landroid/view/View$OnClickListener;", "dialog", "Landroid/app/Dialog;", "style", "Luts/sdk/modules/DCloudUniPrompt/ShowActionSheetOptions;", "index", "", "<init>", "(Landroid/app/Dialog;Luts/sdk/modules/DCloudUniPrompt/ShowActionSheetOptions;Ljava/lang/Number;)V", "host", "getHost", "()Landroid/app/Dialog;", "setHost", "(Landroid/app/Dialog;)V", "hostStyle", "getHostStyle", "()Luts/sdk/modules/DCloudUniPrompt/ShowActionSheetOptions;", "setHostStyle", "(Luts/sdk/modules/DCloudUniPrompt/ShowActionSheetOptions;)V", "hostIndex", "getHostIndex", "()Ljava/lang/Number;", "setHostIndex", "(Ljava/lang/Number;)V", "onClick", "", io.dcloud.common.util.CreateShortResultReceiver.KEY_VERSIONNAME, "Landroid/view/View;", "uni-prompt_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class ItemClickListener implements android.view.View.OnClickListener {
    public android.app.Dialog host;
    public java.lang.Number hostIndex;
    public uts.sdk.modules.DCloudUniPrompt.ShowActionSheetOptions hostStyle;

    public android.app.Dialog getHost() {
        android.app.Dialog dialog = this.host;
        if (dialog != null) {
            return dialog;
        }
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("host");
        return null;
    }

    public void setHost(android.app.Dialog dialog) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(dialog, "<set-?>");
        this.host = dialog;
    }

    public uts.sdk.modules.DCloudUniPrompt.ShowActionSheetOptions getHostStyle() {
        uts.sdk.modules.DCloudUniPrompt.ShowActionSheetOptions showActionSheetOptions = this.hostStyle;
        if (showActionSheetOptions != null) {
            return showActionSheetOptions;
        }
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("hostStyle");
        return null;
    }

    public void setHostStyle(uts.sdk.modules.DCloudUniPrompt.ShowActionSheetOptions showActionSheetOptions) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(showActionSheetOptions, "<set-?>");
        this.hostStyle = showActionSheetOptions;
    }

    public java.lang.Number getHostIndex() {
        java.lang.Number number = this.hostIndex;
        if (number != null) {
            return number;
        }
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("hostIndex");
        return null;
    }

    public void setHostIndex(java.lang.Number number) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(number, "<set-?>");
        this.hostIndex = number;
    }

    public ItemClickListener(android.app.Dialog dialog, uts.sdk.modules.DCloudUniPrompt.ShowActionSheetOptions style, java.lang.Number index) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(dialog, "dialog");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(style, "style");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(index, "index");
        setHost(dialog);
        setHostStyle(style);
        setHostIndex(index);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(android.view.View v) {
        uts.sdk.modules.DCloudUniPrompt.ShowActionSheetSuccess showActionSheetSuccess = new uts.sdk.modules.DCloudUniPrompt.ShowActionSheetSuccess(getHostIndex());
        kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniPrompt.ShowActionSheetSuccess, kotlin.Unit> success = getHostStyle().getSuccess();
        if (success != null) {
            success.invoke(showActionSheetSuccess);
        }
        getHostStyle().setSuccess(null);
        kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> complete = getHostStyle().getComplete();
        if (complete != null) {
            complete.invoke(showActionSheetSuccess);
        }
        getHostStyle().setComplete(null);
        getHostStyle().setFail(null);
        getHost().dismiss();
    }
}
