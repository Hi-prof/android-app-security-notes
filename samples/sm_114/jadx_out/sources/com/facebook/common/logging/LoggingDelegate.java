package com.facebook.common.logging;

/* JADX INFO: loaded from: classes.dex */
public interface LoggingDelegate {
    void d(java.lang.String str, java.lang.String str2);

    void d(java.lang.String str, java.lang.String str2, java.lang.Throwable th);

    void e(java.lang.String str, java.lang.String str2);

    void e(java.lang.String str, java.lang.String str2, java.lang.Throwable th);

    int getMinimumLoggingLevel();

    void i(java.lang.String str, java.lang.String str2);

    void i(java.lang.String str, java.lang.String str2, java.lang.Throwable th);

    boolean isLoggable(int i);

    void log(int i, java.lang.String str, java.lang.String str2);

    void setMinimumLoggingLevel(int i);

    void v(java.lang.String str, java.lang.String str2);

    void v(java.lang.String str, java.lang.String str2, java.lang.Throwable th);

    void w(java.lang.String str, java.lang.String str2);

    void w(java.lang.String str, java.lang.String str2, java.lang.Throwable th);

    void wtf(java.lang.String str, java.lang.String str2);

    void wtf(java.lang.String str, java.lang.String str2, java.lang.Throwable th);
}
