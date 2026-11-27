package com.dcloud.zxing2;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public abstract class ReaderException extends java.lang.Exception {
    protected static final java.lang.StackTraceElement[] NO_TRACE;
    protected static final boolean isStackTrace;

    static {
        isStackTrace = java.lang.System.getProperty("surefire.test.class.path") != null;
        NO_TRACE = new java.lang.StackTraceElement[0];
    }

    ReaderException() {
    }

    @Override // java.lang.Throwable
    public final java.lang.Throwable fillInStackTrace() {
        return null;
    }

    ReaderException(java.lang.Throwable th) {
        super(th);
    }
}
