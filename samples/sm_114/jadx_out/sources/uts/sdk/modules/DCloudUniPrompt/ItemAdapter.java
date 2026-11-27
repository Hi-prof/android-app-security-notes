package uts.sdk.modules.DCloudUniPrompt;

/* JADX INFO: compiled from: index.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001%B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u001c\u0010\u001d\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001bH\u0016J\u001c\u0010!\u001a\u00020\"2\n\u0010#\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\b\u0010$\u001a\u00020\u001bH\u0016R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0006X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0004X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006&"}, d2 = {"Luts/sdk/modules/DCloudUniPrompt/ItemAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Luts/sdk/modules/DCloudUniPrompt/ItemAdapter$ViewHolder;", "dialog", "Landroid/app/Dialog;", "style", "Luts/sdk/modules/DCloudUniPrompt/ShowActionSheetOptions;", "<init>", "(Landroid/app/Dialog;Luts/sdk/modules/DCloudUniPrompt/ShowActionSheetOptions;)V", "mItemList", "Lio/dcloud/uts/UTSArray;", "", "getMItemList", "()Lio/dcloud/uts/UTSArray;", "setMItemList", "(Lio/dcloud/uts/UTSArray;)V", "hostStyle", "getHostStyle", "()Luts/sdk/modules/DCloudUniPrompt/ShowActionSheetOptions;", "setHostStyle", "(Luts/sdk/modules/DCloudUniPrompt/ShowActionSheetOptions;)V", "hostDialog", "getHostDialog", "()Landroid/app/Dialog;", "setHostDialog", "(Landroid/app/Dialog;)V", "getItemViewType", "", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "getItemCount", "ViewHolder", "uni-prompt_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class ItemAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<uts.sdk.modules.DCloudUniPrompt.ItemAdapter.ViewHolder> {
    public android.app.Dialog hostDialog;
    public uts.sdk.modules.DCloudUniPrompt.ShowActionSheetOptions hostStyle;
    public io.dcloud.uts.UTSArray<java.lang.String> mItemList;

    public io.dcloud.uts.UTSArray<java.lang.String> getMItemList() {
        io.dcloud.uts.UTSArray<java.lang.String> uTSArray = this.mItemList;
        if (uTSArray != null) {
            return uTSArray;
        }
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("mItemList");
        return null;
    }

    public void setMItemList(io.dcloud.uts.UTSArray<java.lang.String> uTSArray) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(uTSArray, "<set-?>");
        this.mItemList = uTSArray;
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

    public android.app.Dialog getHostDialog() {
        android.app.Dialog dialog = this.hostDialog;
        if (dialog != null) {
            return dialog;
        }
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("hostDialog");
        return null;
    }

    public void setHostDialog(android.app.Dialog dialog) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(dialog, "<set-?>");
        this.hostDialog = dialog;
    }

    public ItemAdapter(android.app.Dialog dialog, uts.sdk.modules.DCloudUniPrompt.ShowActionSheetOptions style) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(dialog, "dialog");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(style, "style");
        setHostDialog(dialog);
        setMItemList(style.getItemList());
        setHostStyle(style);
    }

    /* JADX INFO: compiled from: index.kt */
    @kotlin.Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0096\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Luts/sdk/modules/DCloudUniPrompt/ItemAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", com.taobao.weex.ui.component.WXBasicComponentType.VIEW, "Landroid/view/View;", "<init>", "(Luts/sdk/modules/DCloudUniPrompt/ItemAdapter;Landroid/view/View;)V", "itemName", "Landroid/widget/TextView;", "getItemName", "()Landroid/widget/TextView;", "setItemName", "(Landroid/widget/TextView;)V", "uni-prompt_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        public android.widget.TextView itemName;
        final /* synthetic */ uts.sdk.modules.DCloudUniPrompt.ItemAdapter this$0;

        public android.widget.TextView getItemName() {
            android.widget.TextView textView = this.itemName;
            if (textView != null) {
                return textView;
            }
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("itemName");
            return null;
        }

        public void setItemName(android.widget.TextView textView) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.itemName = textView;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(uts.sdk.modules.DCloudUniPrompt.ItemAdapter itemAdapter, android.view.View view) {
            super(view);
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(view, "view");
            this.this$0 = itemAdapter;
            android.view.View viewFindViewById = view.findViewById(io.dcloud.uts.prompt.R.id.tvName);
            kotlin.jvm.internal.Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.TextView");
            setItemName((android.widget.TextView) viewFindViewById);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        java.lang.String title = getHostStyle().getTitle();
        return ((title == null || kotlin.text.StringsKt.isBlank(title)) && position == 0) ? 1001 : 1002;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public uts.sdk.modules.DCloudUniPrompt.ItemAdapter.ViewHolder onCreateViewHolder(android.view.ViewGroup parent, int viewType) {
        android.view.View viewInflate;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 1002) {
            if (io.dcloud.uts.UTSAndroid.INSTANCE.getAppDarkMode()) {
                viewInflate = android.view.LayoutInflater.from(parent.getContext()).inflate(io.dcloud.uts.prompt.R.layout.uni_app_uni_prompt_ac_recyclerview_layout_night, parent, false);
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(viewInflate, "inflate(...)");
            } else {
                viewInflate = android.view.LayoutInflater.from(parent.getContext()).inflate(io.dcloud.uts.prompt.R.layout.uni_app_uni_prompt_ac_recyclerview_layout, parent, false);
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(viewInflate, "inflate(...)");
            }
        } else if (io.dcloud.uts.UTSAndroid.INSTANCE.getAppDarkMode()) {
            viewInflate = android.view.LayoutInflater.from(parent.getContext()).inflate(io.dcloud.uts.prompt.R.layout.uni_app_uni_prompt_ac_recyclerview_layout_top_night, parent, false);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(viewInflate, "inflate(...)");
        } else {
            viewInflate = android.view.LayoutInflater.from(parent.getContext()).inflate(io.dcloud.uts.prompt.R.layout.uni_app_uni_prompt_ac_recyclerview_layout_top, parent, false);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(viewInflate, "inflate(...)");
        }
        return new uts.sdk.modules.DCloudUniPrompt.ItemAdapter.ViewHolder(this, viewInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(uts.sdk.modules.DCloudUniPrompt.ItemAdapter.ViewHolder holder, int position) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(holder, "holder");
        java.lang.String str = getMItemList().get(position);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(str, "get(...)");
        holder.getItemName().setText(str);
        if (getHostStyle().getItemColor() != null && uts.sdk.modules.DCloudUniPrompt.IndexKt.isValidColor(getHostStyle().getItemColor())) {
            holder.getItemName().setTextColor(android.graphics.Color.parseColor(getHostStyle().getItemColor()));
        }
        holder.getItemName().setOnClickListener(new uts.sdk.modules.DCloudUniPrompt.ItemClickListener(getHostDialog(), getHostStyle(), java.lang.Integer.valueOf(position)));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return getMItemList().size();
    }
}
