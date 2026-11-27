package com.dmcbig.mediapicker.adapter;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class SpacingDecoration extends androidx.recyclerview.widget.RecyclerView.ItemDecoration {
    private int space;
    private int spanCount;

    public SpacingDecoration(int i, int i2) {
        this.spanCount = i;
        this.space = i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(android.graphics.Rect rect, android.view.View view, androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.State state) {
        int i = this.space;
        rect.left = i;
        rect.bottom = i;
        if (recyclerView.getChildLayoutPosition(view) % this.spanCount == 0) {
            rect.left = 0;
        }
    }
}
