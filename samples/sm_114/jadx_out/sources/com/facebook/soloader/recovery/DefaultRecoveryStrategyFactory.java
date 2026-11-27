package com.facebook.soloader.recovery;

/* JADX INFO: loaded from: classes.dex */
public class DefaultRecoveryStrategyFactory implements com.facebook.soloader.recovery.RecoveryStrategyFactory {
    private final com.facebook.soloader.recovery.BaseApkPathHistory mBaseApkPathHistory;
    private final android.content.Context mContext;

    public DefaultRecoveryStrategyFactory(android.content.Context context) {
        this.mContext = context;
        com.facebook.soloader.recovery.BaseApkPathHistory baseApkPathHistory = new com.facebook.soloader.recovery.BaseApkPathHistory(5);
        this.mBaseApkPathHistory = baseApkPathHistory;
        baseApkPathHistory.recordPathIfNew(context.getApplicationInfo().sourceDir);
    }

    @Override // com.facebook.soloader.recovery.RecoveryStrategyFactory
    public com.facebook.soloader.recovery.RecoveryStrategy get() {
        return new com.facebook.soloader.recovery.CompositeRecoveryStrategy(new com.facebook.soloader.recovery.WaitForAsyncInit(), new com.facebook.soloader.recovery.DetectDataAppMove(this.mContext, this.mBaseApkPathHistory), new com.facebook.soloader.recovery.ReunpackBackupSoSources(), new com.facebook.soloader.recovery.ReunpackNonBackupSoSources(), new com.facebook.soloader.recovery.WaitForAsyncInit(), new com.facebook.soloader.recovery.CheckBaseApkExists(this.mContext, this.mBaseApkPathHistory));
    }
}
