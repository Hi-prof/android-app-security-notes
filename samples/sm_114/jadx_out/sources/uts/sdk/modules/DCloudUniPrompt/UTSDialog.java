package uts.sdk.modules.DCloudUniPrompt;

/* JADX INFO: compiled from: index.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010(\u001a\u00020)H\u0016J\u0010\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020#H\u0016J\u0010\u0010,\u001a\u00020)2\u0006\u0010-\u001a\u00020\u001dH\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\bX\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\bX\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\n\"\u0004\b\u0018\u0010\fR\u001a\u0010\u0019\u001a\u00020\bX\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\n\"\u0004\b\u001b\u0010\fR\u001a\u0010\u001c\u001a\u00020\u001dX\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006."}, d2 = {"Luts/sdk/modules/DCloudUniPrompt/UTSDialog;", "Landroid/app/Dialog;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "tv_title", "Landroid/widget/TextView;", "getTv_title", "()Landroid/widget/TextView;", "setTv_title", "(Landroid/widget/TextView;)V", "tv_content", "getTv_content", "setTv_content", "et_content", "Landroid/widget/EditText;", "getEt_content", "()Landroid/widget/EditText;", "setEt_content", "(Landroid/widget/EditText;)V", "tvCancelAction", "getTvCancelAction", "setTvCancelAction", "tvSureAction", "getTvSureAction", "setTvSureAction", "view_split_line_v", "Landroid/view/View;", "getView_split_line_v", "()Landroid/view/View;", "setView_split_line_v", "(Landroid/view/View;)V", "hostStyle", "Luts/sdk/modules/DCloudUniPrompt/ShowModalOptions;", "getHostStyle", "()Luts/sdk/modules/DCloudUniPrompt/ShowModalOptions;", "setHostStyle", "(Luts/sdk/modules/DCloudUniPrompt/ShowModalOptions;)V", "dismiss", "", "initStyle", "style", "onClick", com.taobao.weex.ui.component.WXBasicComponentType.VIEW, "uni-prompt_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class UTSDialog extends android.app.Dialog implements android.view.View.OnClickListener {
    public android.widget.EditText et_content;
    private uts.sdk.modules.DCloudUniPrompt.ShowModalOptions hostStyle;
    public android.widget.TextView tvCancelAction;
    public android.widget.TextView tvSureAction;
    public android.widget.TextView tv_content;
    public android.widget.TextView tv_title;
    public android.view.View view_split_line_v;

    public android.widget.TextView getTv_title() {
        android.widget.TextView textView = this.tv_title;
        if (textView != null) {
            return textView;
        }
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("tv_title");
        return null;
    }

    public void setTv_title(android.widget.TextView textView) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.tv_title = textView;
    }

    public android.widget.TextView getTv_content() {
        android.widget.TextView textView = this.tv_content;
        if (textView != null) {
            return textView;
        }
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("tv_content");
        return null;
    }

    public void setTv_content(android.widget.TextView textView) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.tv_content = textView;
    }

    public android.widget.EditText getEt_content() {
        android.widget.EditText editText = this.et_content;
        if (editText != null) {
            return editText;
        }
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("et_content");
        return null;
    }

    public void setEt_content(android.widget.EditText editText) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(editText, "<set-?>");
        this.et_content = editText;
    }

    public android.widget.TextView getTvCancelAction() {
        android.widget.TextView textView = this.tvCancelAction;
        if (textView != null) {
            return textView;
        }
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("tvCancelAction");
        return null;
    }

    public void setTvCancelAction(android.widget.TextView textView) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.tvCancelAction = textView;
    }

    public android.widget.TextView getTvSureAction() {
        android.widget.TextView textView = this.tvSureAction;
        if (textView != null) {
            return textView;
        }
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("tvSureAction");
        return null;
    }

    public void setTvSureAction(android.widget.TextView textView) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.tvSureAction = textView;
    }

    public android.view.View getView_split_line_v() {
        android.view.View view = this.view_split_line_v;
        if (view != null) {
            return view;
        }
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("view_split_line_v");
        return null;
    }

    public void setView_split_line_v(android.view.View view) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.view_split_line_v = view;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UTSDialog(android.content.Context context) {
        super(context);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
        if (io.dcloud.uts.UTSAndroid.INSTANCE.getAppDarkMode()) {
            setContentView(io.dcloud.uts.prompt.R.layout.uni_app_uni_prompt_modal_dialog_night);
        } else {
            setContentView(io.dcloud.uts.prompt.R.layout.uni_app_uni_prompt_modal_dialog);
        }
        android.view.Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(android.R.color.transparent);
        }
        android.view.View viewFindViewById = findViewById(io.dcloud.uts.prompt.R.id.tv_title);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        setTv_title((android.widget.TextView) viewFindViewById);
        android.view.View viewFindViewById2 = findViewById(io.dcloud.uts.prompt.R.id.tv_content);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        setTv_content((android.widget.TextView) viewFindViewById2);
        android.view.View viewFindViewById3 = findViewById(io.dcloud.uts.prompt.R.id.et_content);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        setEt_content((android.widget.EditText) viewFindViewById3);
        android.view.View viewFindViewById4 = findViewById(io.dcloud.uts.prompt.R.id.tvCancelAction);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        setTvCancelAction((android.widget.TextView) viewFindViewById4);
        android.view.View viewFindViewById5 = findViewById(io.dcloud.uts.prompt.R.id.tvSureAction);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        setTvSureAction((android.widget.TextView) viewFindViewById5);
        android.view.View viewFindViewById6 = findViewById(io.dcloud.uts.prompt.R.id.view_split_line_v);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        setView_split_line_v(viewFindViewById6);
    }

    public uts.sdk.modules.DCloudUniPrompt.ShowModalOptions getHostStyle() {
        return this.hostStyle;
    }

    public void setHostStyle(uts.sdk.modules.DCloudUniPrompt.ShowModalOptions showModalOptions) {
        this.hostStyle = showModalOptions;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> complete;
        uts.sdk.modules.DCloudUniPrompt.ShowModalSuccess showModalSuccess = new uts.sdk.modules.DCloudUniPrompt.ShowModalSuccess(false, true, null, 4, null);
        uts.sdk.modules.DCloudUniPrompt.ShowModalOptions hostStyle = getHostStyle();
        if (hostStyle != null && (complete = hostStyle.getComplete()) != null) {
            complete.invoke2(showModalSuccess);
        }
        if (getHostStyle() != null) {
            uts.sdk.modules.DCloudUniPrompt.ShowModalOptions hostStyle2 = getHostStyle();
            kotlin.jvm.internal.Intrinsics.checkNotNull(hostStyle2);
            hostStyle2.setComplete(null);
        }
        super.dismiss();
    }

    public void initStyle(uts.sdk.modules.DCloudUniPrompt.ShowModalOptions style) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(style, "style");
        setHostStyle(style);
        setCanceledOnTouchOutside(false);
        if (style.getShowCancel() != null && kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) style.getShowCancel(), (java.lang.Object) true)) {
            getTvCancelAction().setVisibility(0);
            getView_split_line_v().setVisibility(0);
            getTvSureAction().setVisibility(0);
            if (io.dcloud.uts.UTSAndroid.INSTANCE.getAppDarkMode()) {
                getTvSureAction().setBackgroundResource(io.dcloud.uts.prompt.R.drawable.uni_app_uni_prompt_dialog_button_select_right_night);
            } else {
                getTvSureAction().setBackgroundResource(io.dcloud.uts.prompt.R.drawable.uni_app_uni_prompt_dialog_button_select_right);
            }
        } else {
            getTvCancelAction().setVisibility(8);
            getView_split_line_v().setVisibility(8);
            getTvSureAction().setVisibility(0);
            if (io.dcloud.uts.UTSAndroid.INSTANCE.getAppDarkMode()) {
                getTvSureAction().setBackgroundResource(io.dcloud.uts.prompt.R.drawable.uni_app_uni_prompt_dialog_button_select_total_night);
            } else {
                getTvSureAction().setBackgroundResource(io.dcloud.uts.prompt.R.drawable.uni_app_uni_prompt_dialog_button_select_total);
            }
        }
        if (style.getEditable() != null && kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) style.getEditable(), (java.lang.Object) true)) {
            getEt_content().setVisibility(0);
            getTv_content().setVisibility(8);
            if (!android.text.TextUtils.isEmpty(style.getContent())) {
                getEt_content().setFocusable(true);
                getEt_content().setFocusableInTouchMode(true);
                getEt_content().requestFocus();
                getEt_content().setText(style.getContent());
                getEt_content().setSelection(getEt_content().getText().length());
            }
            if (style.getPlaceholderText() != null) {
                getEt_content().setHint(style.getPlaceholderText());
            }
            if (!android.text.TextUtils.isEmpty(style.getTitle())) {
                getTv_title().setVisibility(0);
                getTv_title().setText(style.getTitle());
            } else {
                getTv_title().setVisibility(8);
            }
        } else {
            getEt_content().setVisibility(8);
            if (!android.text.TextUtils.isEmpty(style.getTitle())) {
                getTv_title().setVisibility(0);
                getTv_title().setText(style.getTitle());
            } else {
                getTv_title().setVisibility(8);
            }
            if (!android.text.TextUtils.isEmpty(style.getContent())) {
                getTv_content().setVisibility(0);
                getTv_content().setText(style.getContent());
                if (android.text.TextUtils.isEmpty(style.getTitle())) {
                    if (io.dcloud.uts.UTSAndroid.INSTANCE.getAppDarkMode()) {
                        android.widget.TextView tv_content = getTv_content();
                        android.content.Context appContext = io.dcloud.uts.UTSAndroid.INSTANCE.getAppContext();
                        kotlin.jvm.internal.Intrinsics.checkNotNull(appContext);
                        tv_content.setTextColor(appContext.getResources().getColor(io.dcloud.uts.prompt.R.color.uni_app_uni_prompt_dialog_title_text_night));
                    } else {
                        android.widget.TextView tv_content2 = getTv_content();
                        android.content.Context appContext2 = io.dcloud.uts.UTSAndroid.INSTANCE.getAppContext();
                        kotlin.jvm.internal.Intrinsics.checkNotNull(appContext2);
                        tv_content2.setTextColor(appContext2.getResources().getColor(io.dcloud.uts.prompt.R.color.uni_app_uni_prompt_dialog_title_text));
                    }
                }
            } else if (!android.text.TextUtils.isEmpty(style.getTitle())) {
                getTv_title().setVisibility(8);
                getTv_content().setVisibility(0);
                getTv_content().setText(style.getTitle());
                if (io.dcloud.uts.UTSAndroid.INSTANCE.getAppDarkMode()) {
                    android.widget.TextView tv_content3 = getTv_content();
                    android.content.Context appContext3 = io.dcloud.uts.UTSAndroid.INSTANCE.getAppContext();
                    kotlin.jvm.internal.Intrinsics.checkNotNull(appContext3);
                    tv_content3.setTextColor(appContext3.getResources().getColor(io.dcloud.uts.prompt.R.color.uni_app_uni_prompt_dialog_title_text_night));
                } else {
                    android.widget.TextView tv_content4 = getTv_content();
                    android.content.Context appContext4 = io.dcloud.uts.UTSAndroid.INSTANCE.getAppContext();
                    kotlin.jvm.internal.Intrinsics.checkNotNull(appContext4);
                    tv_content4.setTextColor(appContext4.getResources().getColor(io.dcloud.uts.prompt.R.color.uni_app_uni_prompt_dialog_title_text));
                }
            } else {
                getTv_content().setVisibility(8);
            }
        }
        if (style.getCancelText() != null) {
            getTvCancelAction().setText(style.getCancelText());
        }
        if (style.getCancelColor() != null) {
            try {
                getTvCancelAction().setTextColor(android.graphics.Color.parseColor(style.getCancelColor()));
            } catch (java.lang.Throwable unused) {
            }
        }
        if (style.getConfirmText() != null) {
            getTvSureAction().setText(style.getConfirmText());
        }
        if (style.getConfirmColor() != null) {
            try {
                getTvSureAction().setTextColor(android.graphics.Color.parseColor(style.getConfirmColor()));
            } catch (java.lang.Throwable unused2) {
            }
        }
        uts.sdk.modules.DCloudUniPrompt.UTSDialog uTSDialog = this;
        getTvCancelAction().setOnClickListener(uTSDialog);
        getTvSureAction().setOnClickListener(uTSDialog);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(android.view.View view) {
        kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> complete;
        kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniPrompt.ShowModalSuccess, kotlin.Unit> success;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(view, "view");
        uts.sdk.modules.DCloudUniPrompt.ShowModalSuccess showModalSuccess = new uts.sdk.modules.DCloudUniPrompt.ShowModalSuccess(true, false, null, 4, null);
        if (view.getId() == io.dcloud.uts.prompt.R.id.tvCancelAction) {
            showModalSuccess.setConfirm(false);
            showModalSuccess.setCancel(true);
        } else if (view.getId() == io.dcloud.uts.prompt.R.id.tvSureAction) {
            java.lang.String string = io.dcloud.uts.NumberKt.toString(getEt_content().getEditableText(), (java.lang.Number) 10);
            if (android.text.TextUtils.isEmpty(string)) {
                showModalSuccess.setContent(null);
            }
            showModalSuccess.setContent(string);
        }
        uts.sdk.modules.DCloudUniPrompt.ShowModalOptions hostStyle = getHostStyle();
        if (hostStyle != null && (success = hostStyle.getSuccess()) != null) {
            success.invoke2(showModalSuccess);
        }
        uts.sdk.modules.DCloudUniPrompt.ShowModalOptions hostStyle2 = getHostStyle();
        if (hostStyle2 != null && (complete = hostStyle2.getComplete()) != null) {
            complete.invoke2(showModalSuccess);
        }
        if (getHostStyle() != null) {
            uts.sdk.modules.DCloudUniPrompt.ShowModalOptions hostStyle3 = getHostStyle();
            kotlin.jvm.internal.Intrinsics.checkNotNull(hostStyle3);
            hostStyle3.setComplete(null);
        }
        dismiss();
    }
}
