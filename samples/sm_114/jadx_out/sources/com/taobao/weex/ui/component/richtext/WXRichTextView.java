package com.taobao.weex.ui.component.richtext;

/* JADX INFO: loaded from: classes.dex */
public class WXRichTextView extends com.taobao.weex.ui.view.WXTextView {
    public WXRichTextView(android.content.Context context) {
        super(context);
    }

    @Override // com.taobao.weex.ui.view.WXTextView, android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        return ((!isEnabled() || getTextLayout() == null || !(getText() instanceof android.text.Spannable)) ? false : updateSelection(motionEvent, (android.text.Spannable) getText())) || super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected boolean verifyDrawable(android.graphics.drawable.Drawable drawable) {
        super.verifyDrawable(drawable);
        return true;
    }

    @Override // com.taobao.weex.ui.view.WXTextView
    public void setTextLayout(android.text.Layout layout) {
        super.setTextLayout(layout);
        if (layout.getText() instanceof android.text.Spanned) {
            android.text.Spanned spanned = (android.text.Spanned) layout.getText();
            com.taobao.weex.ui.component.richtext.span.ImgSpan[] imgSpanArr = (com.taobao.weex.ui.component.richtext.span.ImgSpan[]) spanned.getSpans(0, spanned.length(), com.taobao.weex.ui.component.richtext.span.ImgSpan.class);
            if (imgSpanArr != null) {
                for (com.taobao.weex.ui.component.richtext.span.ImgSpan imgSpan : imgSpanArr) {
                    imgSpan.setView(this);
                }
            }
        }
    }

    private boolean updateSelection(android.view.MotionEvent motionEvent, android.text.Spannable spannable) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1 || actionMasked == 0) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int paddingLeft = x - getPaddingLeft();
            int paddingTop = y - getPaddingTop();
            int scrollX = paddingLeft + getScrollX();
            int scrollY = paddingTop + getScrollY();
            android.text.Layout textLayout = getTextLayout();
            int offsetForHorizontal = textLayout.getOffsetForHorizontal(textLayout.getLineForVertical(scrollY), scrollX);
            android.text.style.ClickableSpan[] clickableSpanArr = (android.text.style.ClickableSpan[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, android.text.style.ClickableSpan.class);
            if (clickableSpanArr.length != 0) {
                if (actionMasked == 1) {
                    clickableSpanArr[0].onClick(this);
                } else {
                    android.text.Selection.setSelection(spannable, spannable.getSpanStart(clickableSpanArr[0]), spannable.getSpanEnd(clickableSpanArr[0]));
                }
                return true;
            }
            android.text.Selection.removeSelection(spannable);
        }
        return false;
    }
}
