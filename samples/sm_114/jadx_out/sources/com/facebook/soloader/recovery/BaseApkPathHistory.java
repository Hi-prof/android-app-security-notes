package com.facebook.soloader.recovery;

/* JADX INFO: loaded from: classes.dex */
public class BaseApkPathHistory {
    private int mCounter;
    private final java.lang.String[] mPaths;

    public BaseApkPathHistory(int i) {
        if (i <= 0) {
            throw new java.lang.IllegalArgumentException();
        }
        this.mPaths = new java.lang.String[i];
        this.mCounter = 0;
    }

    public synchronized boolean recordPathIfNew(java.lang.String str) {
        for (java.lang.String str2 : this.mPaths) {
            if (str.equals(str2)) {
                return false;
            }
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder("Recording new base apk path: ");
        sb.append(str);
        sb.append("\n");
        report(sb);
        com.facebook.soloader.LogUtil.w(com.facebook.soloader.SoLoader.TAG, sb.toString());
        java.lang.String[] strArr = this.mPaths;
        int i = this.mCounter;
        strArr[i % strArr.length] = str;
        this.mCounter = i + 1;
        return true;
    }

    public synchronized void report(java.lang.StringBuilder sb) {
        sb.append("Previously recorded ");
        sb.append(this.mCounter);
        sb.append(" base apk paths.");
        if (this.mCounter > 0) {
            sb.append(" Most recent ones:");
        }
        int i = 0;
        while (true) {
            java.lang.String[] strArr = this.mPaths;
            if (i < strArr.length) {
                int i2 = (this.mCounter - i) - 1;
                if (i2 >= 0) {
                    java.lang.String str = strArr[i2 % strArr.length];
                    sb.append("\n");
                    sb.append(str);
                    sb.append(" (");
                    sb.append(new java.io.File(str).exists() ? "exists" : "does not exist");
                    sb.append(com.taobao.weex.el.parse.Operators.BRACKET_END_STR);
                }
                i++;
            }
        }
    }

    public java.lang.String report() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        report(sb);
        return sb.toString();
    }

    public synchronized int size() {
        return this.mCounter;
    }
}
