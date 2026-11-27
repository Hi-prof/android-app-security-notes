package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class i3 implements io.dcloud.common.DHInterface.INativeAppInfo {
    private io.dcloud.common.DHInterface.IConfusionMgr a;
    private java.lang.ref.SoftReference b;

    public i3(android.app.Application application) {
        a(application);
        a(this.a);
    }

    private void a(android.app.Application application) {
        this.b = new java.lang.ref.SoftReference(application);
    }

    @Override // io.dcloud.common.DHInterface.INativeAppInfo
    public android.app.Application getApplication() {
        java.lang.ref.SoftReference softReference = this.b;
        if (softReference != null) {
            return (android.app.Application) softReference.get();
        }
        return null;
    }

    @Override // io.dcloud.common.DHInterface.INativeAppInfo
    public io.dcloud.common.DHInterface.IConfusionMgr getCofusionMgr() {
        return this.a;
    }

    private void a(io.dcloud.common.DHInterface.IConfusionMgr iConfusionMgr) {
        if (iConfusionMgr == null) {
            iConfusionMgr = io.dcloud.p.i0.c();
        }
        this.a = iConfusionMgr;
    }
}
