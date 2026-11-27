package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class e {
    private static volatile io.dcloud.p.e d;
    private final java.util.Map a = new java.util.HashMap();
    private final java.util.Map b = new io.dcloud.p.e.a();
    private final java.util.Map c;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class a extends java.util.HashMap {
        a() {
            put(io.dcloud.sdk.core.util.Const.TYPE_GG, "io.dcloud.sdk.poly.adapter.google.AdMobAdAdapter");
            put(io.dcloud.sdk.core.util.Const.TYPE_PG, "io.dcloud.sdk.poly.adapter.pg.PGADAdapter");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class b extends java.util.HashMap {
        b() {
            put(io.dcloud.sdk.core.util.Const.TYPE_BD, "io.dcloud.sdk.poly.adapter.bd.BDAdAdapter");
            put(io.dcloud.sdk.core.util.Const.TYPE_CSJ, "io.dcloud.sdk.poly.adapter.csj.CSJAdAdapter");
            put(io.dcloud.sdk.core.util.Const.TYPE_GDT, "io.dcloud.sdk.poly.adapter.gdt.GDTADAdapter");
            put(io.dcloud.sdk.core.util.Const.TYPE_SGM, "io.dcloud.sdk.poly.adapter.sgm.SGMADAdapter");
            put(io.dcloud.sdk.core.util.Const.TYPE_KS, "io.dcloud.sdk.poly.adapter.ks.KSADAdapter");
            put(io.dcloud.sdk.core.util.Const.TYPE_HW, "io.dcloud.sdk.poly.adapter.hw.HWAdAdapter");
            put(io.dcloud.sdk.core.util.Const.TYPE_GM, "io.dcloud.sdk.poly.adapter.gm.DGMAdAdapter");
            putAll(io.dcloud.p.e.this.b);
            put(io.dcloud.sdk.core.util.Const.TYPE_WM, io.dcloud.p.c5.class.getName());
        }
    }

    private e() {
        io.dcloud.p.e.b bVar = new io.dcloud.p.e.b();
        this.c = bVar;
        for (K k : bVar.keySet()) {
            io.dcloud.sdk.core.adapter.IAdAdapter iAdAdapterA = a((java.lang.String) this.c.get(k), k);
            if (iAdAdapterA != null) {
                this.a.put(k, iAdAdapterA);
            }
        }
    }

    public static io.dcloud.p.e b() {
        if (d == null) {
            synchronized (io.dcloud.p.e.class) {
                if (d == null) {
                    d = new io.dcloud.p.e();
                }
            }
        }
        return d;
    }

    public java.lang.String c(java.lang.String str) {
        return this.b.containsKey(str) ? io.dcloud.sdk.core.util.Const.PROVIDER_TYPE_GLOBAL : io.dcloud.sdk.core.util.Const.PROVIDER_TYPE_CHINA;
    }

    public java.util.Map a() {
        return this.a;
    }

    public java.util.List c() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        try {
            arrayList.addAll(this.a.keySet());
        } catch (java.lang.Exception unused) {
        }
        if (!arrayList.contains("dcloud")) {
            arrayList.add("dcloud");
        }
        return arrayList;
    }

    private io.dcloud.sdk.core.adapter.IAdAdapter a(java.lang.String str, java.lang.String str2) {
        try {
            io.dcloud.sdk.core.adapter.IAdAdapter iAdAdapter = (io.dcloud.sdk.core.adapter.IAdAdapter) java.lang.Class.forName(str).newInstance();
            if (!iAdAdapter.getAdapterSDKVersion().equalsIgnoreCase("1.9.9.82680")) {
                android.util.Log.e("uni-AD", str2 + " adapter version not match");
            }
            if (iAdAdapter.getSDKVersion() != null) {
                io.dcloud.p.c3.a("uniAD", "SDKVersion:" + str2 + ":" + iAdAdapter.getSDKVersion());
            }
            return iAdAdapter;
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public io.dcloud.sdk.core.adapter.IAdAdapter b(java.lang.String str) {
        return (io.dcloud.sdk.core.adapter.IAdAdapter) this.a.get(str);
    }

    public boolean a(java.lang.String str) {
        return this.c.containsKey(str);
    }

    public void a(java.lang.String str, io.dcloud.sdk.core.adapter.IAdAdapter iAdAdapter) {
        this.a.put(str, iAdAdapter);
    }
}
