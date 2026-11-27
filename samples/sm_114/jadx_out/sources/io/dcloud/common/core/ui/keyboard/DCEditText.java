package io.dcloud.common.core.ui.keyboard;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class DCEditText extends android.widget.EditText {
    float mCursorSpacing;
    java.lang.String mInputMode;
    java.lang.String mInstanceId;
    io.dcloud.common.core.ui.keyboard.DCEditText.OnKeyboardHeightChangeListener mKeyboardHeightChangeListener;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public interface OnKeyboardHeightChangeListener {
        void onChange(boolean z, int i);
    }

    public DCEditText(android.content.Context context, java.lang.String str) {
        super(context);
        this.mCursorSpacing = 0.0f;
        this.mInputMode = io.dcloud.common.core.ui.DCKeyboardManager.SOFT_INPUT_MODE_ADJUST_PAN;
        this.mInstanceId = str;
    }

    public void destroy() {
        clearFocus();
        if (io.dcloud.common.core.ui.DCKeyboardManager.getInstance().getNativeInput() == this) {
            io.dcloud.common.core.ui.DCKeyboardManager.getInstance().setNativeInput(null, 0.0f);
        }
    }

    public io.dcloud.common.core.ui.keyboard.DCEditText.OnKeyboardHeightChangeListener getKeyboardHeightChangeListener() {
        return this.mKeyboardHeightChangeListener;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onFocusChanged(boolean z, int i, android.graphics.Rect rect) {
        super.onFocusChanged(z, i, rect);
        io.dcloud.common.core.ui.DCKeyboardManager.getInstance().nativeEditTextFocus(this.mInstanceId, this, z, this.mInputMode, this.mCursorSpacing);
    }

    public void setCursorSpacing(float f) {
        this.mCursorSpacing = f;
    }

    public void setInputSoftMode(java.lang.String str) {
        this.mInputMode = str;
    }

    public void setkeyBoardHeightChangeListener(io.dcloud.common.core.ui.keyboard.DCEditText.OnKeyboardHeightChangeListener onKeyboardHeightChangeListener) {
        this.mKeyboardHeightChangeListener = onKeyboardHeightChangeListener;
    }
}
