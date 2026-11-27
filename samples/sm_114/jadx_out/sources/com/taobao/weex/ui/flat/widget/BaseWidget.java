package com.taobao.weex.ui.flat.widget;

/* JADX INFO: loaded from: classes.dex */
abstract class BaseWidget implements com.taobao.weex.ui.flat.widget.Widget {
    private com.taobao.weex.ui.view.border.BorderDrawable backgroundBorder;
    private int bottomOffset;
    private final com.taobao.weex.ui.flat.FlatGUIContext context;
    private int leftOffset;
    private int rightOffset;
    private int topOffset;
    private android.graphics.Rect borderBox = new android.graphics.Rect();
    private android.graphics.Point offsetOfContainer = new android.graphics.Point();

    BaseWidget(com.taobao.weex.ui.flat.FlatGUIContext flatGUIContext) {
        this.context = flatGUIContext;
    }

    @Override // com.taobao.weex.ui.flat.widget.Widget
    public void setLayout(int i, int i2, int i3, int i4, int i5, int i6, android.graphics.Point point) {
        this.offsetOfContainer = point;
        this.borderBox.set(i3, i5, i + i3, i2 + i5);
        com.taobao.weex.ui.view.border.BorderDrawable borderDrawable = this.backgroundBorder;
        if (borderDrawable != null) {
            setBackgroundAndBorder(borderDrawable);
        }
        invalidate();
    }

    @Override // com.taobao.weex.ui.flat.widget.Widget
    public void setContentBox(int i, int i2, int i3, int i4) {
        this.leftOffset = i;
        this.topOffset = i2;
        this.rightOffset = i3;
        this.bottomOffset = i4;
        invalidate();
    }

    @Override // com.taobao.weex.ui.flat.widget.Widget
    public void setBackgroundAndBorder(com.taobao.weex.ui.view.border.BorderDrawable borderDrawable) {
        this.backgroundBorder = borderDrawable;
        android.graphics.Rect rect = new android.graphics.Rect(this.borderBox);
        rect.offset(-this.borderBox.left, -this.borderBox.top);
        borderDrawable.setBounds(rect);
        setCallback(borderDrawable);
        invalidate();
    }

    @Override // com.taobao.weex.ui.flat.widget.Widget
    public final android.graphics.Point getLocInFlatContainer() {
        return this.offsetOfContainer;
    }

    @Override // com.taobao.weex.ui.flat.widget.Widget
    public final com.taobao.weex.ui.view.border.BorderDrawable getBackgroundAndBorder() {
        return this.backgroundBorder;
    }

    @Override // com.taobao.weex.ui.flat.widget.Widget
    public final android.graphics.Rect getBorderBox() {
        return this.borderBox;
    }

    @Override // com.taobao.weex.ui.flat.widget.Widget
    public final void draw(android.graphics.Canvas canvas) {
        canvas.save();
        com.taobao.weex.utils.WXViewUtils.clipCanvasWithinBorderBox(this, canvas);
        canvas.translate(this.borderBox.left, this.borderBox.top);
        com.taobao.weex.ui.view.border.BorderDrawable borderDrawable = this.backgroundBorder;
        if (borderDrawable != null) {
            borderDrawable.draw(canvas);
        }
        canvas.clipRect(this.leftOffset, this.topOffset, this.borderBox.width() - this.rightOffset, this.borderBox.height() - this.bottomOffset);
        canvas.translate(this.leftOffset, this.topOffset);
        onDraw(canvas);
        canvas.restore();
    }

    protected void invalidate() {
        android.view.View widgetContainerView;
        android.graphics.Rect rect = new android.graphics.Rect(this.borderBox);
        rect.offset(this.offsetOfContainer.x, this.offsetOfContainer.y);
        com.taobao.weex.ui.flat.FlatGUIContext flatGUIContext = this.context;
        if (flatGUIContext == null || (widgetContainerView = flatGUIContext.getWidgetContainerView(this)) == null) {
            return;
        }
        widgetContainerView.invalidate(rect);
    }

    protected void setCallback(android.graphics.drawable.Drawable drawable) {
        android.view.View widgetContainerView;
        com.taobao.weex.ui.flat.FlatGUIContext flatGUIContext = this.context;
        if (flatGUIContext == null || (widgetContainerView = flatGUIContext.getWidgetContainerView(this)) == null) {
            return;
        }
        drawable.setCallback(widgetContainerView);
    }
}
