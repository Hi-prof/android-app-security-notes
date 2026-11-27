package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public abstract class v2 {
    protected io.dcloud.p.v2.c a;
    private android.content.Context b;
    protected java.lang.String c;
    protected io.dcloud.sdk.base.entry.AdData d;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class a implements java.lang.Runnable {
        final /* synthetic */ int a;
        final /* synthetic */ java.lang.String b;

        a(int i, java.lang.String str) {
            this.a = i;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            io.dcloud.p.v2.this.a.onError(this.a, this.b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class b implements java.lang.Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            io.dcloud.p.v2.this.a.l();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public interface c {
        void a(int i, java.lang.String str);

        void j();

        void k();

        void l();

        void onAdClicked();

        void onAdShow();

        void onError(int i, java.lang.String str);
    }

    public v2(io.dcloud.p.v2.c cVar, android.content.Context context, java.lang.String str) {
        this.a = cVar;
        this.b = context;
        this.c = str;
    }

    public void a(android.view.ViewGroup viewGroup) {
        if (viewGroup == null) {
            a(60010, "广告容器不可见");
        } else if (this.d == null) {
            a(60005, "数据解析失败");
        } else {
            new io.dcloud.p.o4(viewGroup.getContext(), this.a, this.d).a(viewGroup);
        }
    }

    public android.content.Context b() {
        return this.b;
    }

    protected void a(int i, java.lang.String str) {
        if (this.a != null) {
            new android.os.Handler(android.os.Looper.getMainLooper()).post(new io.dcloud.p.v2.a(i, str));
        }
    }

    protected void a() {
        if (this.a != null) {
            new android.os.Handler(android.os.Looper.getMainLooper()).post(new io.dcloud.p.v2.b());
        }
    }
}
