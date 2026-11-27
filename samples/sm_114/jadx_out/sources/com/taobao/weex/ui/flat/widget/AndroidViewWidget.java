package com.taobao.weex.ui.flat.widget;

/* JADX INFO: loaded from: classes.dex */
public class AndroidViewWidget extends com.taobao.weex.ui.flat.widget.BaseWidget implements com.taobao.weex.common.Destroyable {
    private android.view.View mView;

    @Override // com.taobao.weex.ui.flat.widget.BaseWidget, com.taobao.weex.ui.flat.widget.Widget
    public /* bridge */ /* synthetic */ void setBackgroundAndBorder(com.taobao.weex.ui.view.border.BorderDrawable borderDrawable) {
        super.setBackgroundAndBorder(borderDrawable);
    }

    @Override // com.taobao.weex.ui.flat.widget.BaseWidget, com.taobao.weex.ui.flat.widget.Widget
    public /* bridge */ /* synthetic */ void setLayout(int i, int i2, int i3, int i4, int i5, int i6, android.graphics.Point point) {
        super.setLayout(i, i2, i3, i4, i5, i6, point);
    }

    public AndroidViewWidget(com.taobao.weex.ui.flat.FlatGUIContext flatGUIContext) {
        super(flatGUIContext);
    }

    public void setContentView(android.view.View view) {
        this.mView = view;
    }

    @Override // com.taobao.weex.ui.flat.widget.BaseWidget, com.taobao.weex.ui.flat.widget.Widget
    public void setContentBox(int i, int i2, int i3, int i4) {
        android.view.View view = this.mView;
        if (view != null) {
            view.setPadding(i, i2, i3, i4);
            invalidate();
        }
    }

    @Override // com.taobao.weex.ui.flat.widget.Widget
    public void onDraw(android.graphics.Canvas canvas) {
        android.view.View view = this.mView;
        if (view != null) {
            view.draw(canvas);
        }
    }

    @Override // com.taobao.weex.ui.flat.widget.BaseWidget
    public void invalidate() {
        super.invalidate();
        android.view.View view = this.mView;
        if (view != null) {
            view.invalidate();
        }
    }

    public android.view.View getView() {
        return this.mView;
    }

    @Override // com.taobao.weex.common.Destroyable
    public void destroy() {
        if (this.mView != null) {
            this.mView = null;
        }
    }
}
