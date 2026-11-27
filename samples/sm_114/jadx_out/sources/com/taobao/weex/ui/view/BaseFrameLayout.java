package com.taobao.weex.ui.view;

/* JADX INFO: loaded from: classes.dex */
public class BaseFrameLayout extends android.widget.FrameLayout {
    private java.util.List<com.taobao.weex.ui.flat.widget.Widget> mWidgets;

    public BaseFrameLayout(android.content.Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(android.graphics.Canvas canvas) {
        try {
            dispatchDrawInterval(canvas);
        } catch (java.lang.Throwable th) {
            com.taobao.weex.utils.WXLogUtils.e(com.taobao.weex.utils.WXLogUtils.getStackTrace(th));
        }
    }

    protected void dispatchDrawInterval(android.graphics.Canvas canvas) {
        if (this.mWidgets != null) {
            canvas.save();
            canvas.translate(getPaddingLeft(), getPaddingTop());
            java.util.Iterator<com.taobao.weex.ui.flat.widget.Widget> it = this.mWidgets.iterator();
            while (it.hasNext()) {
                it.next().draw(canvas);
            }
            canvas.restore();
            return;
        }
        com.taobao.weex.utils.WXViewUtils.clipCanvasWithinBorderBox(this, canvas);
        super.dispatchDraw(canvas);
    }

    public void mountFlatGUI(java.util.List<com.taobao.weex.ui.flat.widget.Widget> list) {
        this.mWidgets = list;
        if (list != null) {
            setWillNotDraw(true);
        }
        invalidate();
    }

    public void unmountFlatGUI() {
        this.mWidgets = null;
        setWillNotDraw(false);
        invalidate();
    }

    @Override // android.view.View
    protected boolean verifyDrawable(android.graphics.drawable.Drawable drawable) {
        return this.mWidgets != null || super.verifyDrawable(drawable);
    }
}
