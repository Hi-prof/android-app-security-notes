package com.facebook.soloader.recovery;

/* JADX INFO: loaded from: classes.dex */
public class CompositeRecoveryStrategy implements com.facebook.soloader.recovery.RecoveryStrategy {
    private int mCurrentStrategy = 0;
    private final com.facebook.soloader.recovery.RecoveryStrategy[] mStrategies;

    public CompositeRecoveryStrategy(com.facebook.soloader.recovery.RecoveryStrategy... recoveryStrategyArr) {
        this.mStrategies = recoveryStrategyArr;
    }

    @Override // com.facebook.soloader.recovery.RecoveryStrategy
    public boolean recover(java.lang.UnsatisfiedLinkError unsatisfiedLinkError, com.facebook.soloader.SoSource[] soSourceArr) {
        int i;
        com.facebook.soloader.recovery.RecoveryStrategy[] recoveryStrategyArr;
        do {
            i = this.mCurrentStrategy;
            recoveryStrategyArr = this.mStrategies;
            if (i >= recoveryStrategyArr.length) {
                return false;
            }
            this.mCurrentStrategy = i + 1;
        } while (!recoveryStrategyArr[i].recover(unsatisfiedLinkError, soSourceArr));
        return true;
    }
}
