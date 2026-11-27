package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public abstract class i4 extends io.dcloud.p.y3 implements java.lang.Runnable {
    protected io.dcloud.sdk.core.entry.DCloudAOLSlot b;
    protected final android.app.Activity c;
    protected int d;
    private io.dcloud.p.c0.c e;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class a extends io.dcloud.p.c0.c {
        a(java.lang.String str) {
            super(str);
        }

        @Override // io.dcloud.p.c0.c
        public void a(org.json.JSONObject jSONObject) {
            io.dcloud.p.i4.this.a(jSONObject);
        }

        @Override // io.dcloud.p.c0.c
        public void a(int i, java.lang.String str) {
            io.dcloud.p.i4.this.b(i, str);
        }
    }

    public i4(android.app.Activity activity) {
        this.c = activity;
    }

    private void d() {
        if (this.e == null) {
            this.e = new io.dcloud.p.i4.a(this.b.getAdpid());
        }
        io.dcloud.p.c0.a().a(this.c, c(), this.e);
    }

    protected abstract void a(int i, java.lang.String str);

    protected abstract void a(io.dcloud.p.t0 t0Var);

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(io.dcloud.sdk.core.entry.DCloudAOLSlot dCloudAOLSlot) {
        this.b = dCloudAOLSlot;
        dCloudAOLSlot.setType(this.d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(int i, java.lang.String str) {
        a(i, str);
    }

    protected int c() {
        return 2;
    }

    @Override // java.lang.Runnable
    public void run() {
        io.dcloud.p.r0.d().f();
        d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(org.json.JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.length() > 0) {
            a(new io.dcloud.p.t0().a(jSONObject, c()));
        } else {
            a(-5001, io.dcloud.sdk.core.util.AOLErrorUtil.getErrorMsg(-5001));
        }
    }

    protected void a(io.dcloud.p.c0.c cVar) {
        this.e = cVar;
    }
}
