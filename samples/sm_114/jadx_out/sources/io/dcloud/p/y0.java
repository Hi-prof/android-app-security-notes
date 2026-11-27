package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class y0 implements java.lang.Runnable {
    private io.dcloud.p.y0.a a;
    private android.content.Context b;
    private java.lang.String c;
    private java.lang.String d;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public interface a {
        void a(io.dcloud.p.y0 y0Var);

        void b(io.dcloud.p.y0 y0Var);
    }

    public void a(android.content.Context context, java.lang.String str, java.lang.String str2) {
        this.b = context;
        this.c = str;
        this.d = str2;
    }

    public java.lang.String b() {
        return this.d;
    }

    public java.lang.String c() {
        return this.c;
    }

    @Override // java.lang.Runnable
    public void run() {
        java.io.InputStream inputStreamA = io.dcloud.p.l3.a(this.c, com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher.HTTP_DEFAULT_TIMEOUT, true, new java.lang.String[1]);
        io.dcloud.p.y0.a aVar = this.a;
        if (aVar != null) {
            if (inputStreamA == null) {
                aVar.b(this);
            } else {
                io.dcloud.p.v0.a(inputStreamA, this.d);
                this.a.a(this);
            }
        }
    }

    public void a(io.dcloud.p.y0.a aVar) {
        this.a = aVar;
    }

    public android.content.Context a() {
        return this.b;
    }
}
