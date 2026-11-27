package io.dcloud.feature.weex_switch;

/* JADX INFO: loaded from: classes2.dex */
public class SwitchGroup extends android.widget.LinearLayout {
    int i;
    private static final int DEFAULT_WIDTH = dp2pxInt(58.0f);
    private static final int DEFAULT_HEIGHT = dp2pxInt(36.0f);

    public SwitchGroup(android.content.Context context) {
        super(context);
        this.i = 0;
        addView(new io.dcloud.feature.weex_switch.SwitchButton(context), new android.widget.LinearLayout.LayoutParams(-1, -1));
    }

    public SwitchGroup(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.i = 0;
    }

    public SwitchGroup(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.i = 0;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            io.dcloud.feature.weex_switch.SwitchButton switchButton = (io.dcloud.feature.weex_switch.SwitchButton) getChildAt(i5);
            switchButton.layout(0, 0, switchButton.getMeasuredWidth(), (int) (switchButton.getMeasuredHeight() + switchButton.getShadowBottomSize()));
        }
        disableClipOnParents(this);
    }

    public void disableClipOnParents(android.view.View view) {
        int i;
        if (view.getParent() == null) {
            return;
        }
        if (view instanceof android.view.ViewGroup) {
            ((android.view.ViewGroup) view).setClipChildren(false);
        }
        if (!(view.getParent() instanceof android.view.View) || (i = this.i) >= 2) {
            return;
        }
        this.i = i + 1;
        disableClipOnParents((android.view.View) view.getParent());
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = android.view.View.MeasureSpec.getMode(i);
        int mode2 = android.view.View.MeasureSpec.getMode(i2);
        if (mode == 0 || mode == Integer.MIN_VALUE) {
            i = android.view.View.MeasureSpec.makeMeasureSpec(DEFAULT_WIDTH, 1073741824);
        }
        if (mode2 == 0 || mode2 == Integer.MIN_VALUE) {
            i2 = android.view.View.MeasureSpec.makeMeasureSpec(DEFAULT_HEIGHT, 1073741824);
        }
        super.onMeasure(i, i2);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }

    private static int dp2pxInt(float f) {
        return (int) dp2px(f);
    }

    private static float dp2px(float f) {
        return android.util.TypedValue.applyDimension(1, f, android.content.res.Resources.getSystem().getDisplayMetrics());
    }
}
