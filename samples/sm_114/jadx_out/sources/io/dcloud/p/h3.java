package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class h3 implements io.dcloud.p.t1 {

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class a extends java.util.ArrayList {
        final /* synthetic */ int a;

        a(int i) {
            this.a = i;
            addAll(i != 1 ? io.dcloud.p.r1.e : io.dcloud.p.r1.d);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class b implements io.dcloud.p.q1.b {
        java.lang.String[] a = new java.lang.String[1];
        final /* synthetic */ io.dcloud.p.t1.a[] b;
        final /* synthetic */ java.lang.String c;
        final /* synthetic */ java.util.HashMap d;
        final /* synthetic */ android.content.Context e;

        b(io.dcloud.p.t1.a[] aVarArr, java.lang.String str, java.util.HashMap map, android.content.Context context) {
            this.b = aVarArr;
            this.c = str;
            this.d = map;
            this.e = context;
        }

        @Override // io.dcloud.p.q1.b
        public void a(io.dcloud.p.q1.a aVar) {
        }

        @Override // io.dcloud.p.q1.b
        public boolean b(io.dcloud.p.q1.a aVar) {
            byte[] bArrA = io.dcloud.p.l3.a(aVar.a(), this.c, this.d, this.a);
            if (bArrA == null) {
                return false;
            }
            try {
                io.dcloud.p.p0 p0Var = new io.dcloud.p.p0(new java.lang.String(bArrA));
                if (p0Var.has("7C61656D")) {
                    io.dcloud.p.h3.this.a(p0Var, this.e);
                }
                if (!p0Var.has("6C697C69")) {
                    for (io.dcloud.p.t1.a aVar2 : this.b) {
                        aVar2.a(-1, io.dcloud.sdk.core.util.AOLErrorUtil.getErrorMsg(-5007));
                    }
                    return true;
                }
                p0Var.put("6C697C69", new io.dcloud.p.p0(new java.lang.String(io.dcloud.p.d.a(android.util.Base64.decode(p0Var.getString("6C697C69"), 2), io.dcloud.p.f1.b(), io.dcloud.p.f1.a()))));
                for (io.dcloud.p.t1.a aVar3 : this.b) {
                    aVar3.a(p0Var);
                }
                return true;
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                for (io.dcloud.p.t1.a aVar4 : this.b) {
                    aVar4.a(-1, io.dcloud.sdk.core.util.AOLErrorUtil.getErrorMsg(-5007));
                }
                return true;
            }
        }

        @Override // io.dcloud.p.q1.b
        public void onNoOnePicked() {
            for (io.dcloud.p.t1.a aVar : this.b) {
                aVar.a(-1, this.a[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(android.content.Context context, int i, io.dcloud.p.t1.a[] aVarArr) {
        java.lang.String strEncode;
        java.lang.String strEncodeToString = android.util.Base64.encodeToString(io.dcloud.p.d.b(io.dcloud.p.g5.a(new io.dcloud.p.p0(io.dcloud.p.x3.a(context)).toString()), io.dcloud.p.f1.b(), io.dcloud.p.f1.a()), 2);
        io.dcloud.p.c3.c("uniAd-msg", strEncodeToString);
        try {
            strEncode = java.net.URLEncoder.encode(strEncodeToString, "utf-8");
        } catch (java.io.UnsupportedEncodingException unused) {
            strEncode = null;
        }
        java.lang.String str = "edata=" + strEncode;
        java.util.HashMap map = new java.util.HashMap();
        map.put(io.dcloud.common.util.net.NetWork.CONTENT_TYPE, "application/x-www-form-urlencoded;charset=utf-8");
        io.dcloud.p.q1.a().a(context, new io.dcloud.p.h3.a(i), i != 1 ? "ThirdConfig" : "Splash", new io.dcloud.p.h3.b(aVarArr, str, map, context));
    }

    @Override // io.dcloud.p.t1
    public void a(final android.content.Context context, final int i, final io.dcloud.p.t1.a... aVarArr) {
        if (io.dcloud.p.r0.d().b() != null && !android.text.TextUtils.isEmpty(io.dcloud.p.r0.d().b().getAdId()) && !android.text.TextUtils.isEmpty(io.dcloud.p.r0.d().b().getAppId())) {
            io.dcloud.p.x4.a().a(new java.lang.Runnable() { // from class: io.dcloud.p.h3$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.b(context, i, aVarArr);
                }
            });
            return;
        }
        for (io.dcloud.p.t1.a aVar : aVarArr) {
            aVar.a(-5016, io.dcloud.sdk.core.util.AOLErrorUtil.getErrorMsg(-5016));
        }
    }

    protected void a(io.dcloud.p.p0 p0Var, android.content.Context context) {
        long j;
        try {
            j = java.lang.Long.parseLong(io.dcloud.p.n.c(context));
        } catch (java.lang.Exception unused) {
            j = 0;
        }
        long jOptLong = p0Var.optLong("7C61656D");
        if (j > 0 && jOptLong > 0 && !io.dcloud.p.n.a(j * 1000, 1000 * jOptLong)) {
            io.dcloud.p.n.a(context);
        }
        io.dcloud.p.n.a(context, java.lang.String.valueOf(jOptLong));
    }
}
