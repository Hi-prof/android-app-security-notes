package io.dcloud.common.adapter.ui;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class CustomeizedInputConnection extends android.view.inputmethod.InputConnectionWrapper {
    java.lang.String composingText;
    int mCursorPos;
    java.lang.StringBuffer mInputString;
    int mInputType;
    io.dcloud.common.adapter.ui.CustomeizedInputConnection mLastCustomeizedInputConnection;
    android.view.inputmethod.InputConnection mTarget;
    io.dcloud.common.DHInterface.IWebview mWebview;
    static java.util.regex.Pattern patternPhone = java.util.regex.Pattern.compile("^1[0-9]{10}$");
    static java.util.regex.Pattern patternID18 = java.util.regex.Pattern.compile("^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9]|X)$");
    static java.util.regex.Pattern patternID15 = java.util.regex.Pattern.compile("^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$");
    static java.util.regex.Pattern patternEmail = java.util.regex.Pattern.compile("^([a-zA-Z0-9_\\.\\-])+\\@(([a-zA-Z0-9\\-])+\\.)+([a-zA-Z0-9]{2,4})+$");
    public static int sDefaultInputType = -1;

    public CustomeizedInputConnection(io.dcloud.common.DHInterface.IWebview iWebview, android.view.inputmethod.InputConnection inputConnection, android.view.inputmethod.EditorInfo editorInfo, io.dcloud.common.adapter.ui.CustomeizedInputConnection customeizedInputConnection) {
        super(inputConnection, false);
        this.mInputType = -1;
        this.mWebview = null;
        this.mInputString = new java.lang.StringBuffer();
        this.mCursorPos = -1;
        this.composingText = null;
        this.mTarget = inputConnection;
        this.mWebview = iWebview;
        this.mLastCustomeizedInputConnection = customeizedInputConnection;
        checkLastInputConnection();
        recordInputType(editorInfo);
        recordText();
        clearComposingText();
    }

    private void clearComposingText() {
        this.composingText = null;
    }

    private void log(java.lang.String str, java.lang.String str2) {
    }

    private boolean needRecord(int i, java.lang.String str) {
        if (i == 1) {
            return patternPhone.matcher(str).find();
        }
        if (i == 2) {
            return patternEmail.matcher(str).find();
        }
        if (i != 7) {
            return io.dcloud.common.adapter.ui.RecordView.Utils.needRecord(i);
        }
        return (str.length() == 18 && patternID18.matcher(str).find()) || (str.length() == 15 && patternID15.matcher(str).find());
    }

    private void recordInputType(android.view.inputmethod.EditorInfo editorInfo) {
        int i = sDefaultInputType;
        this.mInputType = i;
        int i2 = editorInfo.inputType;
        int i3 = i2 & 15;
        if (i3 == 1) {
            int i4 = i2 & 4080;
            if (i4 == 32 || i4 == 208) {
                this.mInputType = 2;
            }
        } else if (i3 != 3) {
            this.mInputType = i;
        } else {
            this.mInputType = 1;
        }
        log("AssistantInput", "recordInputType mInputType =" + this.mInputType + ";typeClass=" + i3);
        io.dcloud.common.adapter.ui.RecordView recordView = io.dcloud.common.adapter.ui.AdaWebview.mRecordView;
        if (recordView == null || !recordView.mShowed) {
            return;
        }
        showRecordView(recordView.mAnchorY, this.mInputType);
    }

    private void recordText() {
        java.lang.CharSequence textBeforeCursor = super.getTextBeforeCursor(255, 0);
        if (textBeforeCursor == null || textBeforeCursor.length() <= 0) {
            return;
        }
        java.lang.StringBuffer stringBuffer = this.mInputString;
        stringBuffer.delete(0, stringBuffer.length());
        java.lang.CharSequence textAfterCursor = super.getTextAfterCursor(255, 0);
        this.mCursorPos = textBeforeCursor.length();
        this.mInputString.append(textBeforeCursor).append(textAfterCursor);
        log("AssistantInput", "recordText mCursorPos=" + this.mCursorPos + ";mInputString=" + ((java.lang.Object) this.mInputString));
    }

    void checkLastInputConnection() {
        io.dcloud.common.adapter.ui.CustomeizedInputConnection customeizedInputConnection = this.mLastCustomeizedInputConnection;
        if (customeizedInputConnection == null || android.os.Build.VERSION.SDK_INT < 24) {
            return;
        }
        customeizedInputConnection.finishComposingText();
    }

    public void closeRecordView() {
        io.dcloud.common.adapter.ui.RecordView recordView = io.dcloud.common.adapter.ui.AdaWebview.mRecordView;
        if (recordView != null) {
            recordView.update(recordView.mAnchorY, -1);
            io.dcloud.common.adapter.ui.AdaWebview.mRecordView.conceal();
            io.dcloud.common.adapter.ui.AdaWebview.mRecordView.mShowed = false;
        }
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean commitText(java.lang.CharSequence charSequence, int i) {
        recordText();
        int i2 = this.mCursorPos;
        if (i2 < 0 || i2 >= this.mInputString.length()) {
            this.mInputString.append(charSequence);
        } else {
            this.mInputString.insert(this.mCursorPos, charSequence);
        }
        log("AssistantInput", "commitText mCursorPos=" + this.mCursorPos + ";msg=" + ((java.lang.Object) this.mInputString));
        return super.commitText(charSequence, i);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean finishComposingText() {
        java.lang.String string = this.mInputString.toString();
        if (!android.text.TextUtils.isEmpty(string)) {
            if (!android.text.TextUtils.isEmpty(this.composingText) && string.contains(this.composingText)) {
                int iIndexOf = string.indexOf(this.composingText);
                string = string.substring(0, iIndexOf) + string.substring(iIndexOf + this.composingText.length());
            }
            java.lang.String strTrim = string.trim();
            log("AssistantInput", "finishComposingText mInputType=" + this.mInputType + ";msg=" + strTrim);
            if (io.dcloud.common.adapter.ui.AdaWebview.mRecordView != null && needRecord(this.mInputType, strTrim)) {
                io.dcloud.common.adapter.ui.AdaWebview.mRecordView.record(strTrim, this.mInputType);
                int i = this.mInputType;
                if (i != -1 && i == io.dcloud.common.adapter.ui.AdaWebview.sCustomeizedInputConnection.mInputType) {
                    io.dcloud.common.adapter.ui.RecordView recordView = io.dcloud.common.adapter.ui.AdaWebview.mRecordView;
                    recordView.update(recordView.mAnchorY, i);
                }
                java.lang.StringBuffer stringBuffer = this.mInputString;
                stringBuffer.delete(0, stringBuffer.length());
            }
        }
        android.view.inputmethod.InputConnection inputConnection = this.mTarget;
        if (inputConnection != null) {
            return inputConnection.finishComposingText();
        }
        return true;
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public java.lang.CharSequence getTextBeforeCursor(int i, int i2) {
        log("AssistantInput", "getTextBeforeCursor mCursorPos=" + this.mCursorPos + ";n=" + i);
        recordText();
        clearComposingText();
        return super.getTextBeforeCursor(i, i2);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean setComposingText(java.lang.CharSequence charSequence, int i) {
        this.composingText = charSequence.toString();
        log("AssistantInput", "setComposingText mCursorPos=" + this.mCursorPos + ";msg=" + ((java.lang.Object) charSequence));
        return super.setComposingText(charSequence, i);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean setSelection(int i, int i2) {
        if (i == i2) {
            this.mCursorPos = i;
        }
        return super.setSelection(i, i2);
    }

    public void setText(java.lang.String str) {
        clearComposingText();
        if (!android.text.TextUtils.equals(android.os.Build.MODEL, "ZTE B880")) {
            recordText();
            deleteSurroundingText(-2147483647, Integer.MAX_VALUE);
            super.setSelection(0, Integer.MAX_VALUE);
            super.commitText(str, str.length());
            return;
        }
        java.lang.StringBuffer stringBuffer = this.mInputString;
        stringBuffer.delete(0, stringBuffer.length());
        this.mCursorPos = str.length();
        this.mInputString.append(str);
        deleteSurroundingText(-2147483647, Integer.MAX_VALUE);
        super.setSelection(0, Integer.MAX_VALUE);
        super.commitText(str, str.length());
    }

    public void showRecordView(int i, boolean z) {
        showRecordView(i, !z ? -1 : this.mInputType);
    }

    public void update(int i) {
        super.sendKeyEvent(new android.view.KeyEvent(0, i > 0 ? 22 : 21));
    }

    void updateInputType(int i) {
        this.mInputType = i;
    }

    public void showRecordView(int i, int i2) {
        if (this.mWebview.obtainApp() == null) {
            return;
        }
        if (io.dcloud.common.adapter.ui.AdaWebview.mRecordView == null) {
            io.dcloud.common.adapter.ui.AdaWebview.mRecordView = new io.dcloud.common.adapter.ui.RecordView(this.mWebview.getContext(), (android.view.ViewGroup) this.mWebview.obtainApp().obtainWebAppRootView().obtainMainView(), this.mWebview.obtainApp().obtainAppId());
        }
        io.dcloud.common.adapter.ui.AdaWebview.mRecordView.update(i, i2);
        io.dcloud.common.adapter.ui.AdaWebview.mRecordView.mShowed = true;
    }
}
