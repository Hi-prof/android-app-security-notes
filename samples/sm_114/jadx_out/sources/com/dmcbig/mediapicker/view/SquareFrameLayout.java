package com.dmcbig.mediapicker.view;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class SquareFrameLayout extends android.widget.FrameLayout {
    public SquareFrameLayout(android.content.Context context) {
        super(context);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), getMeasuredWidth());
    }

    public SquareFrameLayout(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SquareFrameLayout(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public SquareFrameLayout(android.content.Context context, android.util.AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
