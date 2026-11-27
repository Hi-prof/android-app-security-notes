package com.facebook.soloader.recovery;

/* JADX INFO: loaded from: classes.dex */
public class ReunpackNonBackupSoSources implements com.facebook.soloader.recovery.RecoveryStrategy {
    @Override // com.facebook.soloader.recovery.RecoveryStrategy
    public boolean recover(java.lang.UnsatisfiedLinkError unsatisfiedLinkError, com.facebook.soloader.SoSource[] soSourceArr) {
        if (!(unsatisfiedLinkError instanceof com.facebook.soloader.SoLoaderULError) || (unsatisfiedLinkError instanceof com.facebook.soloader.SoLoaderDSONotFoundError)) {
            return false;
        }
        java.lang.String soName = ((com.facebook.soloader.SoLoaderULError) unsatisfiedLinkError).getSoName();
        java.lang.StringBuilder sb = new java.lang.StringBuilder("Reunpacking NonApk UnpackingSoSources due to ");
        sb.append(unsatisfiedLinkError);
        sb.append(soName == null ? "" : ", retrying for specific library " + soName);
        com.facebook.soloader.LogUtil.e(com.facebook.soloader.SoLoader.TAG, sb.toString());
        for (com.facebook.soloader.SoSource soSource : soSourceArr) {
            if (soSource instanceof com.facebook.soloader.UnpackingSoSource) {
                com.facebook.soloader.UnpackingSoSource unpackingSoSource = (com.facebook.soloader.UnpackingSoSource) soSource;
                if (unpackingSoSource instanceof com.facebook.soloader.BackupSoSource) {
                    continue;
                } else {
                    try {
                        com.facebook.soloader.LogUtil.e(com.facebook.soloader.SoLoader.TAG, "Runpacking " + unpackingSoSource.getName());
                        unpackingSoSource.prepareForceRefresh();
                    } catch (java.lang.Exception e) {
                        com.facebook.soloader.LogUtil.e(com.facebook.soloader.SoLoader.TAG, "Encountered an exception while reunpacking " + unpackingSoSource.getName() + " for library " + soName + ": ", e);
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
