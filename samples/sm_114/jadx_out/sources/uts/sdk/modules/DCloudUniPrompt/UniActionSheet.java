package uts.sdk.modules.DCloudUniPrompt;

/* JADX INFO: compiled from: index.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010-\u001a\u00020.H\u0016R\u001a\u0010\b\u001a\u00020\u0003X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u0005X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0013X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\u001a\u0010\u001b\u001a\u00020\u001cX\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\"X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010'\u001a\u00020\"X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010$\"\u0004\b)\u0010&R\u001a\u0010*\u001a\u00020\"X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010$\"\u0004\b,\u0010&¨\u0006/"}, d2 = {"Luts/sdk/modules/DCloudUniPrompt/UniActionSheet;", "Landroid/app/Dialog;", "activity", "Landroid/app/Activity;", "style", "Luts/sdk/modules/DCloudUniPrompt/ShowActionSheetOptions;", "<init>", "(Landroid/app/Activity;Luts/sdk/modules/DCloudUniPrompt/ShowActionSheetOptions;)V", "hostActivity", "getHostActivity", "()Landroid/app/Activity;", "setHostActivity", "(Landroid/app/Activity;)V", "hostStyle", "getHostStyle", "()Luts/sdk/modules/DCloudUniPrompt/ShowActionSheetOptions;", "setHostStyle", "(Luts/sdk/modules/DCloudUniPrompt/ShowActionSheetOptions;)V", io.dcloud.common.constant.AbsoluteConst.JSON_KEY_TITLE, "Landroidx/appcompat/widget/AppCompatTextView;", "getTitle", "()Landroidx/appcompat/widget/AppCompatTextView;", "setTitle", "(Landroidx/appcompat/widget/AppCompatTextView;)V", com.alibaba.android.bindingx.core.internal.BindingXConstants.STATE_CANCEL, "getCancel", "setCancel", "myRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getMyRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setMyRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "lineTitle", "Landroidx/appcompat/widget/LinearLayoutCompat;", "getLineTitle", "()Landroidx/appcompat/widget/LinearLayoutCompat;", "setLineTitle", "(Landroidx/appcompat/widget/LinearLayoutCompat;)V", "lineContent", "getLineContent", "setLineContent", "lineCancel", "getLineCancel", "setLineCancel", "dismiss", "", "uni-prompt_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class UniActionSheet extends android.app.Dialog {
    public androidx.appcompat.widget.AppCompatTextView cancel;
    public android.app.Activity hostActivity;
    public uts.sdk.modules.DCloudUniPrompt.ShowActionSheetOptions hostStyle;
    public androidx.appcompat.widget.LinearLayoutCompat lineCancel;
    public androidx.appcompat.widget.LinearLayoutCompat lineContent;
    public androidx.appcompat.widget.LinearLayoutCompat lineTitle;
    public androidx.recyclerview.widget.RecyclerView myRecyclerView;
    public androidx.appcompat.widget.AppCompatTextView title;

    public android.app.Activity getHostActivity() {
        android.app.Activity activity = this.hostActivity;
        if (activity != null) {
            return activity;
        }
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("hostActivity");
        return null;
    }

    public void setHostActivity(android.app.Activity activity) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(activity, "<set-?>");
        this.hostActivity = activity;
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

    public androidx.appcompat.widget.AppCompatTextView getTitle() {
        androidx.appcompat.widget.AppCompatTextView appCompatTextView = this.title;
        if (appCompatTextView != null) {
            return appCompatTextView;
        }
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_TITLE);
        return null;
    }

    public void setTitle(androidx.appcompat.widget.AppCompatTextView appCompatTextView) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(appCompatTextView, "<set-?>");
        this.title = appCompatTextView;
    }

    public androidx.appcompat.widget.AppCompatTextView getCancel() {
        androidx.appcompat.widget.AppCompatTextView appCompatTextView = this.cancel;
        if (appCompatTextView != null) {
            return appCompatTextView;
        }
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(com.alibaba.android.bindingx.core.internal.BindingXConstants.STATE_CANCEL);
        return null;
    }

    public void setCancel(androidx.appcompat.widget.AppCompatTextView appCompatTextView) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(appCompatTextView, "<set-?>");
        this.cancel = appCompatTextView;
    }

    public androidx.recyclerview.widget.RecyclerView getMyRecyclerView() {
        androidx.recyclerview.widget.RecyclerView recyclerView = this.myRecyclerView;
        if (recyclerView != null) {
            return recyclerView;
        }
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("myRecyclerView");
        return null;
    }

    public void setMyRecyclerView(androidx.recyclerview.widget.RecyclerView recyclerView) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(recyclerView, "<set-?>");
        this.myRecyclerView = recyclerView;
    }

    public androidx.appcompat.widget.LinearLayoutCompat getLineTitle() {
        androidx.appcompat.widget.LinearLayoutCompat linearLayoutCompat = this.lineTitle;
        if (linearLayoutCompat != null) {
            return linearLayoutCompat;
        }
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("lineTitle");
        return null;
    }

    public void setLineTitle(androidx.appcompat.widget.LinearLayoutCompat linearLayoutCompat) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(linearLayoutCompat, "<set-?>");
        this.lineTitle = linearLayoutCompat;
    }

    public androidx.appcompat.widget.LinearLayoutCompat getLineContent() {
        androidx.appcompat.widget.LinearLayoutCompat linearLayoutCompat = this.lineContent;
        if (linearLayoutCompat != null) {
            return linearLayoutCompat;
        }
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("lineContent");
        return null;
    }

    public void setLineContent(androidx.appcompat.widget.LinearLayoutCompat linearLayoutCompat) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(linearLayoutCompat, "<set-?>");
        this.lineContent = linearLayoutCompat;
    }

    public androidx.appcompat.widget.LinearLayoutCompat getLineCancel() {
        androidx.appcompat.widget.LinearLayoutCompat linearLayoutCompat = this.lineCancel;
        if (linearLayoutCompat != null) {
            return linearLayoutCompat;
        }
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("lineCancel");
        return null;
    }

    public void setLineCancel(androidx.appcompat.widget.LinearLayoutCompat linearLayoutCompat) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(linearLayoutCompat, "<set-?>");
        this.lineCancel = linearLayoutCompat;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        uts.sdk.modules.DCloudUniPrompt.PromptErrorImpl promptErrorImpl = new uts.sdk.modules.DCloudUniPrompt.PromptErrorImpl((java.lang.Number) 1, "showActionSheet:fail cancel");
        kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniPrompt.IPromptError, kotlin.Unit> fail = getHostStyle().getFail();
        if (fail != null) {
            fail.invoke2(promptErrorImpl);
        }
        getHostStyle().setFail(null);
        kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> complete = getHostStyle().getComplete();
        if (complete != null) {
            complete.invoke2(promptErrorImpl);
        }
        getHostStyle().setComplete(null);
        super.dismiss();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UniActionSheet(android.app.Activity activity, uts.sdk.modules.DCloudUniPrompt.ShowActionSheetOptions style) {
        super(activity, io.dcloud.uts.prompt.R.style.uni_app_uni_prompt_ActionsheetDialog);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(activity, "activity");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(style, "style");
        setHostActivity(activity);
        setHostStyle(style);
        if (io.dcloud.uts.UTSAndroid.INSTANCE.getAppDarkMode()) {
            setContentView(io.dcloud.uts.prompt.R.layout.uni_app_uni_prompt_uts_action_sheet_night);
        } else {
            setContentView(io.dcloud.uts.prompt.R.layout.uni_app_uni_prompt_uts_action_sheet);
        }
        android.view.View viewFindViewById = findViewById(io.dcloud.uts.prompt.R.id.tvTitle);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        setTitle((androidx.appcompat.widget.AppCompatTextView) viewFindViewById);
        android.view.View viewFindViewById2 = findViewById(io.dcloud.uts.prompt.R.id.tvCancelAction);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        setCancel((androidx.appcompat.widget.AppCompatTextView) viewFindViewById2);
        android.view.View viewFindViewById3 = findViewById(io.dcloud.uts.prompt.R.id.line_title);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        setLineTitle((androidx.appcompat.widget.LinearLayoutCompat) viewFindViewById3);
        android.view.View viewFindViewById4 = findViewById(io.dcloud.uts.prompt.R.id.line_content);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        setLineContent((androidx.appcompat.widget.LinearLayoutCompat) viewFindViewById4);
        android.view.View viewFindViewById5 = findViewById(io.dcloud.uts.prompt.R.id.line_cancel);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        setLineCancel((androidx.appcompat.widget.LinearLayoutCompat) viewFindViewById5);
        android.view.View viewFindViewById6 = findViewById(io.dcloud.uts.prompt.R.id.myRecyclerview);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        setMyRecyclerView((androidx.recyclerview.widget.RecyclerView) viewFindViewById6);
        getMyRecyclerView().setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(getHostActivity()));
        uts.sdk.modules.DCloudUniPrompt.UniActionSheet uniActionSheet = this;
        getCancel().setOnClickListener(new uts.sdk.modules.DCloudUniPrompt.CancelClickListener(uniActionSheet, getHostStyle()));
        getMyRecyclerView().setAdapter(new uts.sdk.modules.DCloudUniPrompt.ItemAdapter(uniActionSheet, getHostStyle()));
        java.lang.String title = style.getTitle();
        if (title != null && !kotlin.text.StringsKt.isBlank(title)) {
            getLineTitle().setVisibility(0);
            getTitle().setText(style.getTitle());
        }
        if (getWindow() != null) {
            android.view.Window window = getWindow();
            kotlin.jvm.internal.Intrinsics.checkNotNull(window);
            window.setLayout(-1, -2);
            android.view.Window window2 = getWindow();
            kotlin.jvm.internal.Intrinsics.checkNotNull(window2);
            window2.setGravity(81);
            android.view.Window window3 = getWindow();
            kotlin.jvm.internal.Intrinsics.checkNotNull(window3);
            if (window3.getAttributes() != null) {
                android.view.Window window4 = getWindow();
                kotlin.jvm.internal.Intrinsics.checkNotNull(window4);
                android.view.WindowManager.LayoutParams attributes = window4.getAttributes();
                kotlin.jvm.internal.Intrinsics.checkNotNull(attributes);
                attributes.windowAnimations = io.dcloud.uts.prompt.R.style.uni_app_uni_prompt_DialogAnimations_slideWindow;
            }
        }
    }
}
