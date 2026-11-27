package com.taobao.weex.ui.view;

/* JADX INFO: loaded from: classes.dex */
public class WXEditText extends io.dcloud.common.core.ui.keyboard.DCEditText implements com.taobao.weex.ui.view.gesture.WXGestureObservable {
    private boolean mAllowCopyPaste;
    private boolean mAllowDisableMovement;
    private int mLines;
    private com.taobao.weex.ui.view.gesture.WXGesture wxGesture;

    public WXEditText(android.content.Context context, java.lang.String str) {
        super(context, str);
        this.mLines = 1;
        this.mAllowDisableMovement = true;
        this.mAllowCopyPaste = true;
        setBackground(null);
    }

    @Override // com.taobao.weex.ui.view.gesture.WXGestureObservable
    public void registerGestureListener(com.taobao.weex.ui.view.gesture.WXGesture wXGesture) {
        this.wxGesture = wXGesture;
    }

    @Override // com.taobao.weex.ui.view.gesture.WXGestureObservable
    public com.taobao.weex.ui.view.gesture.WXGesture getGestureListener() {
        return this.wxGesture;
    }

    @Override // android.widget.TextView
    public void setLines(int i) {
        super.setLines(i);
        this.mLines = i;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
        com.taobao.weex.ui.view.gesture.WXGesture wXGesture = this.wxGesture;
        if (wXGesture != null) {
            zOnTouchEvent |= wXGesture.onTouch(this, motionEvent);
        }
        android.view.ViewParent parent = getParent();
        if (parent != null) {
            int action = motionEvent.getAction() & 255;
            if (action != 0) {
                if (action == 1 || action == 3) {
                    parent.requestDisallowInterceptTouchEvent(false);
                    return zOnTouchEvent;
                }
            } else if (this.mLines < getLineCount()) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
        return zOnTouchEvent;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (getLayout() != null) {
            int height = getLayout().getHeight();
            if (this.mAllowDisableMovement && i2 < height) {
                setMovementMethod(new android.text.method.BaseMovementMethod());
            } else {
                setMovementMethod(getDefaultMovementMethod());
            }
        }
    }

    public void setAllowDisableMovement(boolean z) {
        this.mAllowDisableMovement = z;
    }

    public void setAllowCopyPaste(boolean z) {
        this.mAllowCopyPaste = z;
        if (z) {
            setLongClickable(true);
            setCustomSelectionActionModeCallback(null);
            if (android.os.Build.VERSION.SDK_INT >= 23) {
                setCustomInsertionActionModeCallback(null);
                return;
            }
            return;
        }
        setLongClickable(false);
        android.view.ActionMode.Callback callback = new android.view.ActionMode.Callback() { // from class: com.taobao.weex.ui.view.WXEditText.1
            @Override // android.view.ActionMode.Callback
            public boolean onActionItemClicked(android.view.ActionMode actionMode, android.view.MenuItem menuItem) {
                return false;
            }

            @Override // android.view.ActionMode.Callback
            public boolean onCreateActionMode(android.view.ActionMode actionMode, android.view.Menu menu) {
                return false;
            }

            @Override // android.view.ActionMode.Callback
            public void onDestroyActionMode(android.view.ActionMode actionMode) {
            }

            @Override // android.view.ActionMode.Callback
            public boolean onPrepareActionMode(android.view.ActionMode actionMode, android.view.Menu menu) {
                return false;
            }
        };
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            setCustomInsertionActionModeCallback(callback);
        }
        setCustomSelectionActionModeCallback(callback);
    }

    @Override // android.widget.EditText, android.widget.TextView
    public boolean onTextContextMenuItem(int i) {
        return !this.mAllowCopyPaste || super.onTextContextMenuItem(i);
    }
}
