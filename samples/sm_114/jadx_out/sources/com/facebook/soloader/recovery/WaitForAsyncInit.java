package com.facebook.soloader.recovery;

/* JADX INFO: loaded from: classes.dex */
public class WaitForAsyncInit implements com.facebook.soloader.recovery.RecoveryStrategy {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.facebook.soloader.recovery.RecoveryStrategy
    public boolean recover(java.lang.UnsatisfiedLinkError unsatisfiedLinkError, com.facebook.soloader.SoSource[] soSourceArr) {
        java.lang.String soName = unsatisfiedLinkError instanceof com.facebook.soloader.SoLoaderULError ? ((com.facebook.soloader.SoLoaderULError) unsatisfiedLinkError).getSoName() : null;
        java.lang.StringBuilder sb = new java.lang.StringBuilder("Waiting on SoSources due to ");
        sb.append(unsatisfiedLinkError);
        sb.append(soName == null ? "" : ", retrying for specific library " + soName);
        com.facebook.soloader.LogUtil.e(com.facebook.soloader.SoLoader.TAG, sb.toString());
        for (com.facebook.soloader.UnpackingSoSource unpackingSoSource : soSourceArr) {
            if (unpackingSoSource instanceof com.facebook.soloader.AsyncInitSoSource) {
                com.facebook.soloader.LogUtil.e(com.facebook.soloader.SoLoader.TAG, "Waiting on SoSource " + unpackingSoSource.getName());
                unpackingSoSource.waitUntilInitCompleted();
            }
        }
        return true;
    }
}
