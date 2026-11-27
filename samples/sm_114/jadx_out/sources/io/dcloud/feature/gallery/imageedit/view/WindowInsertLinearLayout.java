package io.dcloud.feature.gallery.imageedit.view;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class WindowInsertLinearLayout extends android.widget.LinearLayout {

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class a implements android.view.ViewGroup.OnHierarchyChangeListener {
        a() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(android.view.View view, android.view.View view2) {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(android.view.View view, android.view.View view2) {
            io.dcloud.feature.gallery.imageedit.view.WindowInsertLinearLayout.this.requestApplyInsets();
        }
    }

    public WindowInsertLinearLayout(android.content.Context context) {
        super(context);
    }

    public WindowInsertLinearLayout(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        setOnHierarchyChangeListener(new io.dcloud.feature.gallery.imageedit.view.WindowInsertLinearLayout.a());
    }

    @Override // android.view.ViewGroup, android.view.View
    public android.view.WindowInsets dispatchApplyWindowInsets(android.view.WindowInsets windowInsets) {
        for (int i = 0; i < getChildCount(); i++) {
            getChildAt(i).dispatchApplyWindowInsets(windowInsets);
        }
        return windowInsets;
    }
}
