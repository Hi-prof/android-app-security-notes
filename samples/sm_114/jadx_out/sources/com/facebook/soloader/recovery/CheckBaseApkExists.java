package com.facebook.soloader.recovery;

/* JADX INFO: loaded from: classes.dex */
public class CheckBaseApkExists implements com.facebook.soloader.recovery.RecoveryStrategy {
    private static final java.lang.String TAG = "soloader.recovery.CheckBaseApkExists";
    private final com.facebook.soloader.recovery.BaseApkPathHistory mBaseApkPathHistory;
    private final android.content.Context mContext;

    public CheckBaseApkExists(android.content.Context context, com.facebook.soloader.recovery.BaseApkPathHistory baseApkPathHistory) {
        this.mContext = context;
        this.mBaseApkPathHistory = baseApkPathHistory;
    }

    @Override // com.facebook.soloader.recovery.RecoveryStrategy
    public boolean recover(java.lang.UnsatisfiedLinkError unsatisfiedLinkError, com.facebook.soloader.SoSource[] soSourceArr) {
        java.lang.String str = this.mContext.getApplicationInfo().sourceDir;
        if (!new java.io.File(str).exists()) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder("Base apk does not exist: ");
            sb.append(str);
            sb.append(". ");
            this.mBaseApkPathHistory.report(sb);
            throw new com.facebook.soloader.NoBaseApkException(sb.toString(), unsatisfiedLinkError);
        }
        com.facebook.soloader.LogUtil.w(TAG, "Base apk exists: " + str);
        return false;
    }
}
