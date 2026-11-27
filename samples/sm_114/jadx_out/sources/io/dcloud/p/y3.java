package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public abstract class y3 {
    private boolean a = false;

    protected abstract android.app.Activity a();

    protected void a(int i, final java.lang.String str, java.lang.String str2, java.lang.String str3, org.json.JSONArray jSONArray, long j) {
        java.lang.String str4;
        if (jSONArray == null || jSONArray.length() == 0 || i == 14) {
            return;
        }
        this.a = true;
        if (b()) {
            final java.util.HashMap map = new java.util.HashMap();
            if (i == 1) {
                str4 = "splash";
            } else if (i == 7) {
                str4 = "full_screen_video";
            } else if (i == 15) {
                str4 = "interstitial";
            } else if (i == 4) {
                str4 = "template";
            } else if (i != 5) {
                switch (i) {
                    case 9:
                        str4 = "rewarded";
                        break;
                    case 10:
                        str4 = "draw_flow";
                        break;
                    case 11:
                        str4 = "drama";
                        break;
                    default:
                        str4 = "";
                        break;
                }
            } else {
                str4 = "video_paste";
            }
            map.put("type", str4);
            map.put("adpid", str);
            map.put("ord", str2);
            if (!android.text.TextUtils.isEmpty(str3)) {
                map.put("ext", str3);
            }
            map.put("rsp", jSONArray);
            map.put("tid", 60);
            map.put("lt", java.lang.Long.valueOf(j));
            io.dcloud.p.x4.a().a(new java.lang.Runnable() { // from class: io.dcloud.p.y3$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a(str, map);
                }
            });
        }
    }

    protected void b(android.app.Activity activity, io.dcloud.sdk.core.module.DCBaseAOL dCBaseAOL) {
        io.dcloud.p.c3.a("on ad show");
        if (dCBaseAOL == null) {
            return;
        }
        if (dCBaseAOL.getSubAd() != null) {
            dCBaseAOL = dCBaseAOL.getSubAd();
        }
        io.dcloud.sdk.core.module.DCBaseAOL dCBaseAOL2 = dCBaseAOL;
        a(activity, 40, dCBaseAOL2, dCBaseAOL2.getLoadId(), java.lang.String.valueOf(dCBaseAOL2.getBiddingECPM()), io.dcloud.p.n.b(dCBaseAOL2), io.dcloud.p.n.a(dCBaseAOL2));
    }

    protected abstract boolean b();

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(java.lang.String str, java.util.HashMap map) {
        io.dcloud.p.d0.a(a(), io.dcloud.p.r0.d().b().getAppId(), io.dcloud.p.r0.d().b().getAdId(), 60, str, map);
    }

    private void a(final android.content.Context context, final int i, final io.dcloud.sdk.core.module.DCBaseAOL dCBaseAOL, final java.lang.String str, final java.lang.String str2, final java.lang.String str3, final java.lang.String str4) {
        if (i == 40) {
            io.dcloud.p.n.a(context, dCBaseAOL.getDCloudId(), dCBaseAOL.getType());
        }
        final java.util.HashMap map = new java.util.HashMap();
        if (!android.text.TextUtils.isEmpty(dCBaseAOL.getEI())) {
            map.put("ext", dCBaseAOL.getEI());
        }
        io.dcloud.p.x4.a().a(new java.lang.Runnable() { // from class: io.dcloud.p.y3$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                io.dcloud.p.y3.a(context, dCBaseAOL, i, map, str, str2, str3, str4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(android.content.Context context, io.dcloud.sdk.core.module.DCBaseAOL dCBaseAOL, int i, java.util.HashMap map, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        io.dcloud.p.d0.a(context, dCBaseAOL.getAppId(), dCBaseAOL.getSlotId(), dCBaseAOL.getTid(), io.dcloud.p.r0.d().b().getAppId(), io.dcloud.p.r0.d().b().getAdId(), i, dCBaseAOL.getDCloudId(), map, str, str2, str3, str4);
    }

    protected void a(android.app.Activity activity, io.dcloud.sdk.core.module.DCBaseAOL dCBaseAOL) {
        io.dcloud.p.c3.a("on ad click");
        if (dCBaseAOL == null) {
            return;
        }
        if (dCBaseAOL.getSubAd() != null) {
            dCBaseAOL = dCBaseAOL.getSubAd();
        }
        io.dcloud.sdk.core.module.DCBaseAOL dCBaseAOL2 = dCBaseAOL;
        a(activity, 41, dCBaseAOL2, null, null, io.dcloud.p.n.b(dCBaseAOL2), io.dcloud.p.n.a(dCBaseAOL2));
    }

    protected void a(final android.app.Activity activity, final io.dcloud.sdk.core.module.DCBaseAOL dCBaseAOL, long j, final java.lang.String str, final int i) {
        if (dCBaseAOL != null && io.dcloud.sdk.core.util.Const.TYPE_GG.equals(dCBaseAOL.getType())) {
            final float f = j / 1000000.0f;
            io.dcloud.p.c3.a("on ad paid");
            io.dcloud.p.x4.a().a(new java.lang.Runnable() { // from class: io.dcloud.p.y3$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    io.dcloud.p.y3.a(activity, dCBaseAOL, f, str, i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(android.app.Activity activity, io.dcloud.sdk.core.module.DCBaseAOL dCBaseAOL, float f, java.lang.String str, int i) {
        io.dcloud.p.d0.a(activity, io.dcloud.p.r0.d().b().getAppId(), dCBaseAOL.getDCloudId(), io.dcloud.p.r0.d().b().getAdId(), dCBaseAOL.getAppId(), dCBaseAOL.getSlotId(), java.lang.String.format(java.util.Locale.ENGLISH, "%f", java.lang.Float.valueOf(f)), str, i, dCBaseAOL.getLoadId());
    }
}
