package com.facebook.soloader.recovery;

/* JADX INFO: loaded from: classes.dex */
public class DetectDataAppMove implements com.facebook.soloader.recovery.RecoveryStrategy {
    private static final java.lang.String TAG = "soloader.recovery.DetectDataAppMove";
    private final com.facebook.soloader.recovery.BaseApkPathHistory mBaseApkPathHistory;
    private final android.content.Context mContext;
    private final int mInitialHistorySize;

    public DetectDataAppMove(android.content.Context context, com.facebook.soloader.recovery.BaseApkPathHistory baseApkPathHistory) {
        this.mContext = context;
        this.mBaseApkPathHistory = baseApkPathHistory;
        this.mInitialHistorySize = baseApkPathHistory.size();
    }

    @Override // com.facebook.soloader.recovery.RecoveryStrategy
    public boolean recover(java.lang.UnsatisfiedLinkError unsatisfiedLinkError, com.facebook.soloader.SoSource[] soSourceArr) {
        if (detectMove()) {
            recoverSoSources(soSourceArr);
            return true;
        }
        if (this.mInitialHistorySize == this.mBaseApkPathHistory.size()) {
            return false;
        }
        com.facebook.soloader.LogUtil.w(TAG, "Context was updated (perhaps by another thread)");
        return true;
    }

    private boolean detectMove() {
        java.lang.String baseApkPath = getBaseApkPath();
        return new java.io.File(baseApkPath).exists() && this.mBaseApkPathHistory.recordPathIfNew(baseApkPath);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void recoverSoSources(com.facebook.soloader.SoSource[] soSourceArr) {
        for (int i = 0; i < soSourceArr.length; i++) {
            java.lang.Object[] objArr = soSourceArr[i];
            if (objArr instanceof com.facebook.soloader.RecoverableSoSource) {
                soSourceArr[i] = ((com.facebook.soloader.RecoverableSoSource) objArr).recover(this.mContext);
            }
        }
    }

    private java.lang.String getBaseApkPath() {
        return this.mContext.getApplicationInfo().sourceDir;
    }
}
