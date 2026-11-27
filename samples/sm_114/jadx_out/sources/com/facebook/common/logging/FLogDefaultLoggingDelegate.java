package com.facebook.common.logging;

/* JADX INFO: loaded from: classes.dex */
public class FLogDefaultLoggingDelegate implements com.facebook.common.logging.LoggingDelegate {
    public static final com.facebook.common.logging.FLogDefaultLoggingDelegate sInstance = new com.facebook.common.logging.FLogDefaultLoggingDelegate();
    private java.lang.String mApplicationTag = "unknown";
    private int mMinimumLoggingLevel = 5;

    public static com.facebook.common.logging.FLogDefaultLoggingDelegate getInstance() {
        return sInstance;
    }

    private FLogDefaultLoggingDelegate() {
    }

    public void setApplicationTag(java.lang.String str) {
        this.mApplicationTag = str;
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public void setMinimumLoggingLevel(int i) {
        this.mMinimumLoggingLevel = i;
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public int getMinimumLoggingLevel() {
        return this.mMinimumLoggingLevel;
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public boolean isLoggable(int i) {
        return this.mMinimumLoggingLevel <= i;
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public void v(java.lang.String str, java.lang.String str2) {
        println(2, str, str2);
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public void v(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        println(2, str, str2, th);
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public void d(java.lang.String str, java.lang.String str2) {
        println(3, str, str2);
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public void d(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        println(3, str, str2, th);
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public void i(java.lang.String str, java.lang.String str2) {
        println(4, str, str2);
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public void i(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        println(4, str, str2, th);
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public void w(java.lang.String str, java.lang.String str2) {
        println(5, str, str2);
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public void w(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        println(5, str, str2, th);
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public void e(java.lang.String str, java.lang.String str2) {
        println(6, str, str2);
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public void e(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        println(6, str, str2, th);
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public void wtf(java.lang.String str, java.lang.String str2) {
        println(6, str, str2);
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public void wtf(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        println(6, str, str2, th);
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public void log(int i, java.lang.String str, java.lang.String str2) {
        println(i, str, str2);
    }

    private void println(int i, java.lang.String str, java.lang.String str2) {
        android.util.Log.println(i, prefixTag(str), str2);
    }

    private void println(int i, java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        android.util.Log.println(i, prefixTag(str), getMsg(str2, th));
    }

    private java.lang.String prefixTag(java.lang.String str) {
        if (this.mApplicationTag == null) {
            return str;
        }
        return this.mApplicationTag + ":" + str;
    }

    private static java.lang.String getMsg(java.lang.String str, java.lang.Throwable th) {
        return str + '\n' + getStackTraceString(th);
    }

    private static java.lang.String getStackTraceString(java.lang.Throwable th) {
        if (th == null) {
            return "";
        }
        return android.util.Log.getStackTraceString(th);
    }
}
