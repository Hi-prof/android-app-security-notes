package com.facebook.common.util;

/* JADX INFO: loaded from: classes.dex */
public class ExceptionWithNoStacktrace extends java.lang.Exception {
    @Override // java.lang.Throwable
    public synchronized java.lang.Throwable fillInStackTrace() {
        return this;
    }

    public ExceptionWithNoStacktrace(java.lang.String str) {
        super(str);
    }
}
