package com.facebook.soloader.recovery;

/* JADX INFO: loaded from: classes.dex */
public class ReunpackBackupSoSources implements com.facebook.soloader.recovery.RecoveryStrategy {
    @Override // com.facebook.soloader.recovery.RecoveryStrategy
    public boolean recover(java.lang.UnsatisfiedLinkError unsatisfiedLinkError, com.facebook.soloader.SoSource[] soSourceArr) {
        com.facebook.soloader.SoLoaderULError soLoaderULError;
        java.lang.String message;
        if (!(unsatisfiedLinkError instanceof com.facebook.soloader.SoLoaderULError) || (unsatisfiedLinkError instanceof com.facebook.soloader.SoLoaderDSONotFoundError) || (message = (soLoaderULError = (com.facebook.soloader.SoLoaderULError) unsatisfiedLinkError).getMessage()) == null || (!message.contains("/app/") && !message.contains("/mnt/"))) {
            return false;
        }
        java.lang.String soName = soLoaderULError.getSoName();
        java.lang.StringBuilder sb = new java.lang.StringBuilder("Reunpacking BackupSoSources due to ");
        sb.append(unsatisfiedLinkError);
        sb.append(soName == null ? "" : ", retrying for specific library " + soName);
        com.facebook.soloader.LogUtil.e(com.facebook.soloader.SoLoader.TAG, sb.toString());
        for (com.facebook.soloader.SoSource soSource : soSourceArr) {
            if (soSource instanceof com.facebook.soloader.BackupSoSource) {
                com.facebook.soloader.BackupSoSource backupSoSource = (com.facebook.soloader.BackupSoSource) soSource;
                try {
                    com.facebook.soloader.LogUtil.e(com.facebook.soloader.SoLoader.TAG, "Runpacking BackupSoSource " + backupSoSource.getName());
                    backupSoSource.prepareForceRefresh();
                } catch (java.lang.Exception e) {
                    com.facebook.soloader.LogUtil.e(com.facebook.soloader.SoLoader.TAG, "Encountered an exception while reunpacking BackupSoSource " + backupSoSource.getName() + " for library " + soName + ": ", e);
                    return false;
                }
            }
        }
        return true;
    }
}
