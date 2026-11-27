package uts.sdk.modules.DCloudUniPrompt;

/* JADX INFO: compiled from: index.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016R\u001a\u0010\b\u001a\u00020\u0003X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u0005X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0016"}, d2 = {"Luts/sdk/modules/DCloudUniPrompt/CancelClickListener;", "Landroid/view/View$OnClickListener;", "dialog", "Landroid/app/Dialog;", "style", "Luts/sdk/modules/DCloudUniPrompt/ShowActionSheetOptions;", "<init>", "(Landroid/app/Dialog;Luts/sdk/modules/DCloudUniPrompt/ShowActionSheetOptions;)V", "host", "getHost", "()Landroid/app/Dialog;", "setHost", "(Landroid/app/Dialog;)V", "hostStyle", "getHostStyle", "()Luts/sdk/modules/DCloudUniPrompt/ShowActionSheetOptions;", "setHostStyle", "(Luts/sdk/modules/DCloudUniPrompt/ShowActionSheetOptions;)V", "onClick", "", io.dcloud.common.util.CreateShortResultReceiver.KEY_VERSIONNAME, "Landroid/view/View;", "uni-prompt_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class CancelClickListener implements android.view.View.OnClickListener {
    public android.app.Dialog host;
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

    public CancelClickListener(android.app.Dialog dialog, uts.sdk.modules.DCloudUniPrompt.ShowActionSheetOptions style) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(dialog, "dialog");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(style, "style");
        setHost(dialog);
        setHostStyle(style);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(android.view.View v) {
        uts.sdk.modules.DCloudUniPrompt.PromptErrorImpl promptErrorImpl = new uts.sdk.modules.DCloudUniPrompt.PromptErrorImpl((java.lang.Number) 1, "showActionSheet:fail cancel");
        kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniPrompt.IPromptError, kotlin.Unit> fail = getHostStyle().getFail();
        if (fail != null) {
            fail.invoke(promptErrorImpl);
        }
        getHostStyle().setFail(null);
        kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> complete = getHostStyle().getComplete();
        if (complete != null) {
            complete.invoke(promptErrorImpl);
        }
        getHostStyle().setComplete(null);
        getHost().dismiss();
    }
}
