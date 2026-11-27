package com.taobao.weex;

/* JADX INFO: loaded from: classes.dex */
public class Script {
    private byte[] mBinary;
    private java.lang.String mContent;

    public Script(java.lang.String str) {
        this.mContent = str;
    }

    public Script(byte[] bArr) {
        this.mBinary = bArr;
    }

    public java.lang.String getContent() {
        return this.mContent;
    }

    public byte[] getBinary() {
        return this.mBinary;
    }

    public int length() {
        java.lang.String str = this.mContent;
        if (str != null) {
            return str.length();
        }
        byte[] bArr = this.mBinary;
        if (bArr != null) {
            return bArr.length;
        }
        return 0;
    }

    public boolean isEmpty() {
        if (!android.text.TextUtils.isEmpty(this.mContent)) {
            return false;
        }
        byte[] bArr = this.mBinary;
        return bArr == null || bArr.length == 0;
    }
}
