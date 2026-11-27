package io.dcloud.api.custom.type.reward;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public abstract class UniAdCustomRewardLoader extends io.dcloud.api.custom.type.UniAdCustomBaseLoader {
    public void onReward() {
        io.dcloud.p.w1 w1Var = this.a;
        if (w1Var instanceof io.dcloud.p.w1.a) {
            ((io.dcloud.p.w1.a) w1Var).f();
        }
    }

    public abstract void show(android.app.Activity activity);

    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public final void show(java.lang.Object obj) {
        show((android.app.Activity) obj);
    }
}
