package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public abstract class t3 extends io.dcloud.sdk.core.DCloudAOLManager {
    public static void a(android.content.Context context, io.dcloud.sdk.core.DCloudAOLManager.InitConfig initConfig, io.dcloud.p.t1 t1Var) {
        if (context == null || initConfig == null) {
            throw new java.lang.NullPointerException("context or config is null");
        }
        if (((context instanceof android.app.Activity) || (context instanceof android.app.Application)) && !io.dcloud.sdk.core.DCloudAOLManager.c.get()) {
            io.dcloud.sdk.core.DCloudAOLManager.c.set(true);
            if (io.dcloud.sdk.core.DCloudAOLManager.b == null) {
                io.dcloud.p.r0 r0VarD = io.dcloud.p.r0.d();
                r0VarD.b(context);
                r0VarD.a(initConfig);
                r0VarD.a(t1Var);
                io.dcloud.sdk.core.DCloudAOLManager.b = r0VarD;
                r0VarD.e();
                r0VarD.a(context);
            }
        }
    }

    public static boolean a() {
        return io.dcloud.p.e.b().c().size() > 1;
    }
}
