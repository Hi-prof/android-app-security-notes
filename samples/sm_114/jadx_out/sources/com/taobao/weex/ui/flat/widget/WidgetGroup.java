package com.taobao.weex.ui.flat.widget;

/* JADX INFO: loaded from: classes.dex */
public class WidgetGroup extends com.taobao.weex.ui.flat.widget.BaseWidget {
    private java.util.List<com.taobao.weex.ui.flat.widget.Widget> mChildren;

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

    public WidgetGroup(com.taobao.weex.ui.flat.FlatGUIContext flatGUIContext) {
        super(flatGUIContext);
        this.mChildren = new java.util.LinkedList();
    }

    public void replaceAll(java.util.List<com.taobao.weex.ui.flat.widget.Widget> list) {
        this.mChildren = list;
        invalidate();
    }

    public java.util.List<com.taobao.weex.ui.flat.widget.Widget> getChildren() {
        return this.mChildren;
    }

    @Override // com.taobao.weex.ui.flat.widget.Widget
    public void onDraw(android.graphics.Canvas canvas) {
        java.util.Iterator<com.taobao.weex.ui.flat.widget.Widget> it = this.mChildren.iterator();
        while (it.hasNext()) {
            it.next().draw(canvas);
        }
    }
}
