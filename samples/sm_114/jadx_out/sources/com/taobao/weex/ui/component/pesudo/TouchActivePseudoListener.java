package com.taobao.weex.ui.component.pesudo;

/* JADX INFO: loaded from: classes.dex */
public class TouchActivePseudoListener implements android.view.View.OnTouchListener {
    private boolean mIsConsumeOnTouch;
    private com.taobao.weex.ui.component.pesudo.OnActivePseudoListner mOnActivePseudoListner;

    public TouchActivePseudoListener(com.taobao.weex.ui.component.pesudo.OnActivePseudoListner onActivePseudoListner, boolean z) {
        this.mOnActivePseudoListner = onActivePseudoListner;
        this.mIsConsumeOnTouch = z;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        com.taobao.weex.ui.component.pesudo.OnActivePseudoListner onActivePseudoListner = this.mOnActivePseudoListner;
        if (onActivePseudoListner != null) {
            if (action == 0 || action == 5) {
                onActivePseudoListner.updateActivePseudo(true);
            } else if (action == 3 || action == 1 || action == 6) {
                onActivePseudoListner.updateActivePseudo(false);
            }
        }
        return this.mIsConsumeOnTouch;
    }
}
