package com.taobao.weex.ui.view;

/* JADX INFO: loaded from: classes.dex */
public class WXTextView extends android.view.View implements com.taobao.weex.ui.view.gesture.WXGestureObservable, com.taobao.weex.ui.view.IWXTextView, com.taobao.weex.ui.view.IRenderStatus<com.taobao.weex.ui.component.WXText>, com.taobao.weex.ui.view.IRenderResult<com.taobao.weex.ui.component.WXText> {
    private boolean mIsLabelSet;
    private java.lang.ref.WeakReference<com.taobao.weex.ui.component.WXText> mWeakReference;
    private android.text.Layout textLayout;
    private com.taobao.weex.ui.view.gesture.WXGesture wxGesture;

    public WXTextView(android.content.Context context) {
        super(context);
        this.mIsLabelSet = false;
    }

    @Override // android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        android.text.Layout textLayout = getTextLayout();
        if (textLayout != null) {
            canvas.translate(getPaddingLeft(), getPaddingTop());
            textLayout.draw(canvas);
        }
        canvas.restore();
    }

    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
        com.taobao.weex.ui.view.gesture.WXGesture wXGesture = this.wxGesture;
        return wXGesture != null ? wXGesture.onTouch(this, motionEvent) | zOnTouchEvent : zOnTouchEvent;
    }

    @Override // com.taobao.weex.ui.view.gesture.WXGestureObservable
    public void registerGestureListener(com.taobao.weex.ui.view.gesture.WXGesture wXGesture) {
        this.wxGesture = wXGesture;
    }

    @Override // com.taobao.weex.ui.view.gesture.WXGestureObservable
    public com.taobao.weex.ui.view.gesture.WXGesture getGestureListener() {
        return this.wxGesture;
    }

    @Override // com.taobao.weex.ui.view.IWXTextView
    public java.lang.CharSequence getText() {
        android.text.Layout layout = this.textLayout;
        if (layout != null) {
            return layout.getText();
        }
        return null;
    }

    public android.text.Layout getTextLayout() {
        return this.textLayout;
    }

    public void setTextLayout(android.text.Layout layout) {
        com.taobao.weex.ui.component.WXText wXText;
        this.textLayout = layout;
        if (layout != null && !this.mIsLabelSet) {
            setContentDescription(layout.getText());
        }
        java.lang.ref.WeakReference<com.taobao.weex.ui.component.WXText> weakReference = this.mWeakReference;
        if (weakReference == null || (wXText = weakReference.get()) == null) {
            return;
        }
        wXText.readyToRender();
    }

    public void setAriaLabel(java.lang.String str) {
        if (!android.text.TextUtils.isEmpty(str)) {
            this.mIsLabelSet = true;
            setContentDescription(str);
            return;
        }
        this.mIsLabelSet = false;
        android.text.Layout layout = this.textLayout;
        if (layout != null) {
            setContentDescription(layout.getText());
        }
    }

    public void setTextColor(int i) {
        android.text.Layout textLayout = getTextLayout();
        if (textLayout != null) {
            textLayout.getPaint().setColor(i);
        }
    }

    @Override // com.taobao.weex.ui.view.IRenderStatus
    public void holdComponent(com.taobao.weex.ui.component.WXText wXText) {
        this.mWeakReference = new java.lang.ref.WeakReference<>(wXText);
    }

    @Override // com.taobao.weex.ui.view.IRenderResult
    public com.taobao.weex.ui.component.WXText getComponent() {
        java.lang.ref.WeakReference<com.taobao.weex.ui.component.WXText> weakReference = this.mWeakReference;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public void enableCopy(boolean z) {
        if (z) {
            setOnLongClickListener(new android.view.View.OnLongClickListener() { // from class: com.taobao.weex.ui.view.WXTextView.1
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(android.view.View view) {
                    final java.lang.String string;
                    androidx.appcompat.widget.PopupMenu popupMenu = new androidx.appcompat.widget.PopupMenu(com.taobao.weex.ui.view.WXTextView.this.getContext(), com.taobao.weex.ui.view.WXTextView.this);
                    try {
                        string = com.taobao.weex.ui.view.WXTextView.this.getContext().getResources().getString(android.R.string.copy);
                    } catch (java.lang.Throwable unused) {
                        string = "Copy";
                    }
                    popupMenu.getMenu().add(string);
                    popupMenu.setOnMenuItemClickListener(new androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener() { // from class: com.taobao.weex.ui.view.WXTextView.1.1
                        @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
                        public boolean onMenuItemClick(android.view.MenuItem menuItem) {
                            if (!string.equals(menuItem.getTitle())) {
                                return false;
                            }
                            java.lang.String string2 = com.taobao.weex.ui.view.WXTextView.this.getText().toString();
                            android.content.ClipboardManager clipboardManager = (android.content.ClipboardManager) com.taobao.weex.ui.view.WXTextView.this.getContext().getSystemService("clipboard");
                            if (clipboardManager == null) {
                                return true;
                            }
                            clipboardManager.setPrimaryClip(android.content.ClipData.newPlainText(string2, string2));
                            return true;
                        }
                    });
                    popupMenu.show();
                    return true;
                }
            });
        } else {
            setOnLongClickListener(null);
        }
    }
}
