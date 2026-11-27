package com.taobao.weex.ui.flat.widget;

/* JADX INFO: loaded from: classes.dex */
public class TextWidget extends com.taobao.weex.ui.flat.widget.BaseWidget {
    private android.text.Layout mLayout;

    @Override // com.taobao.weex.ui.flat.widget.BaseWidget, com.taobao.weex.ui.flat.widget.Widget
    public /* bridge */ /* synthetic */ void setBackgroundAndBorder(com.taobao.weex.ui.view.border.BorderDrawable borderDrawable) {
        super.setBackgroundAndBorder(borderDrawable);
    }

    @Override // com.taobao.weex.ui.flat.widget.BaseWidget, com.taobao.weex.ui.flat.widget.Widget
    public /* bridge */ /* synthetic */ void setContentBox(int i, int i2, int i3, int i4) {
        super.setContentBox(i, i2, i3, i4);
    }

    @Override // com.taobao.weex.ui.flat.widget.BaseWidget, com.taobao.weex.ui.flat.widget.Widget
    public /* bridge */ /* synthetic */ void setLayout(int i, int i2, int i3, int i4, int i5, int i6, android.graphics.Point point) {
        super.setLayout(i, i2, i3, i4, i5, i6, point);
    }

    public TextWidget(com.taobao.weex.ui.flat.FlatGUIContext flatGUIContext) {
        super(flatGUIContext);
    }

    @Override // com.taobao.weex.ui.flat.widget.Widget
    public void onDraw(android.graphics.Canvas canvas) {
        android.text.Layout layout = this.mLayout;
        if (layout != null) {
            layout.draw(canvas);
        }
    }

    public void updateTextDrawable(android.text.Layout layout) {
        this.mLayout = layout;
        invalidate();
    }
}
