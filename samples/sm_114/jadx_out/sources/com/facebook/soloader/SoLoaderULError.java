package com.facebook.soloader;

/* JADX INFO: loaded from: classes.dex */
public class SoLoaderULError extends java.lang.UnsatisfiedLinkError {
    private java.lang.String mSoName;

    public SoLoaderULError(java.lang.String str, java.lang.String str2) {
        super(str2);
        this.mSoName = str;
    }

    public SoLoaderULError(java.lang.String str) {
        this.mSoName = str;
    }

    public java.lang.String getSoName() {
        return this.mSoName;
    }
}
