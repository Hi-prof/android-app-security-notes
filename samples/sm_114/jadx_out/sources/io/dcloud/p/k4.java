package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class k4 extends io.dcloud.p.y4 {
    private io.dcloud.sdk.core.entry.SplashAOLConfig C;
    private final java.util.Queue D;

    public k4(android.app.Activity activity, int i) {
        super(activity, i);
        this.D = new java.util.concurrent.ConcurrentLinkedQueue();
        a(new io.dcloud.p.k4.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public io.dcloud.sdk.core.module.DCBaseAOLLoader s() {
        io.dcloud.sdk.core.adapter.IAdAdapter iAdAdapterB = io.dcloud.p.e.b().b("dcloud");
        if (iAdAdapterB == null) {
            return null;
        }
        io.dcloud.sdk.core.module.DCBaseAOLLoader ad = iAdAdapterB.getAd(a(), this.b);
        this.D.add(ad);
        return ad;
    }

    @Override // io.dcloud.p.i4
    protected int c() {
        return 1;
    }

    public io.dcloud.sdk.core.entry.SplashAOLConfig t() {
        return this.C;
    }

    protected void b(org.json.JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        java.lang.String strOptString = jSONObject.optString("src");
        if (android.text.TextUtils.isEmpty(strOptString)) {
            return;
        }
        com.bumptech.glide.Glide.with(a()).asBitmap().load(strOptString).into(new io.dcloud.p.k4.a(jSONObject));
    }

    @Override // io.dcloud.p.x, io.dcloud.p.k
    public io.dcloud.sdk.core.module.DCBaseAOLLoader i() {
        return this.D.isEmpty() ? s() : (io.dcloud.sdk.core.module.DCBaseAOLLoader) this.D.remove();
    }

    public void a(android.view.ViewGroup viewGroup) {
        io.dcloud.sdk.core.module.DCBaseAOL dCBaseAOL = this.t;
        if (dCBaseAOL instanceof io.dcloud.sdk.core.module.DCBaseAOLLoader) {
            ((io.dcloud.sdk.core.module.DCBaseAOLLoader) dCBaseAOL).showIn(viewGroup);
        }
    }

    protected void b(final android.widget.RelativeLayout relativeLayout, final android.widget.FrameLayout.LayoutParams layoutParams) {
        io.dcloud.sdk.core.util.MainHandlerUtil.getMainHandler().post(new java.lang.Runnable() { // from class: io.dcloud.p.k4$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(relativeLayout, layoutParams);
            }
        });
    }

    public void a(io.dcloud.sdk.core.entry.SplashAOLConfig splashAOLConfig, io.dcloud.p.w2 w2Var) {
        this.C = splashAOLConfig;
        super.a(new io.dcloud.sdk.core.entry.DCloudAOLSlot.Builder().height(splashAOLConfig.getHeight()).width(splashAOLConfig.getWidth()).build(), w2Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(android.widget.RelativeLayout relativeLayout, android.widget.FrameLayout.LayoutParams layoutParams) {
        io.dcloud.p.w2 w2Var = this.s;
        if (w2Var instanceof io.dcloud.sdk.core.interfaces.AOLLoader.SplashAOLLoadListener) {
            ((io.dcloud.sdk.core.interfaces.AOLLoader.SplashAOLLoadListener) w2Var).redBag(relativeLayout, layoutParams);
        }
    }

    @Override // io.dcloud.p.y4, io.dcloud.p.x, io.dcloud.p.i4
    protected void a(io.dcloud.p.t0 t0Var) {
        super.a(t0Var);
    }

    @Override // io.dcloud.p.x, io.dcloud.p.i4
    protected void a(int i, java.lang.String str) {
        super.a(i, str);
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    protected class b extends io.dcloud.p.c0.d {
        public b() {
            super("");
        }

        @Override // io.dcloud.p.c0.d
        public void a(org.json.JSONArray jSONArray) {
        }

        @Override // io.dcloud.p.c0.d
        public void a(org.json.JSONArray jSONArray, boolean z) {
            if (jSONArray == null || jSONArray.length() == 0) {
                java.util.Iterator it = io.dcloud.p.k4.this.D.iterator();
                while (it.hasNext()) {
                    ((io.dcloud.p.u0) ((io.dcloud.sdk.core.module.DCBaseAOL) it.next())).a((org.json.JSONArray) null, true);
                }
                return;
            }
            int i = 0;
            if (io.dcloud.p.k4.this.D.size() <= 0) {
                while (i < jSONArray.length()) {
                    io.dcloud.p.u0 u0Var = (io.dcloud.p.u0) io.dcloud.p.k4.this.s();
                    if (u0Var != null) {
                        org.json.JSONArray jSONArray2 = new org.json.JSONArray();
                        jSONArray2.put(jSONArray.opt(i));
                        u0Var.a(jSONArray2, true);
                        io.dcloud.p.k4.this.D.add(u0Var);
                    }
                    i++;
                }
                return;
            }
            for (io.dcloud.sdk.core.module.DCBaseAOL dCBaseAOL : io.dcloud.p.k4.this.D) {
                if (jSONArray.length() > i) {
                    org.json.JSONArray jSONArray3 = new org.json.JSONArray();
                    jSONArray3.put(jSONArray.opt(i));
                    ((io.dcloud.p.u0) dCBaseAOL).a(jSONArray3, true);
                } else {
                    ((io.dcloud.p.u0) dCBaseAOL).a((org.json.JSONArray) null, true);
                }
                i++;
            }
            if (jSONArray.length() > i) {
                for (int i2 = i; i2 < jSONArray.length(); i2++) {
                    io.dcloud.p.u0 u0Var2 = (io.dcloud.p.u0) io.dcloud.p.k4.this.s();
                    if (u0Var2 != null) {
                        org.json.JSONArray jSONArray4 = new org.json.JSONArray();
                        jSONArray4.put(jSONArray.opt(i));
                        u0Var2.a(jSONArray4, true);
                        io.dcloud.p.k4.this.D.add(u0Var2);
                    }
                }
            }
        }

        @Override // io.dcloud.p.c0.d, io.dcloud.p.c0.c
        public void a(org.json.JSONObject jSONObject) {
            super.a(jSONObject);
            try {
                org.json.JSONObject jSONObject2 = new org.json.JSONObject(jSONObject.toString());
                jSONObject2.remove("cfgs");
                io.dcloud.p.k4.this.s.getClass().getDeclaredMethod("getConfig", org.json.JSONObject.class).invoke(io.dcloud.p.k4.this.s, jSONObject2);
            } catch (java.lang.Exception unused) {
            }
            io.dcloud.p.k4.this.a(jSONObject);
        }

        @Override // io.dcloud.p.c0.d, io.dcloud.p.c0.c
        public void a(int i, java.lang.String str) {
            super.a(i, str);
            io.dcloud.p.k4.this.b(i, str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class a extends com.bumptech.glide.request.target.CustomTarget {
        final /* synthetic */ org.json.JSONObject a;

        a(org.json.JSONObject jSONObject) {
            this.a = jSONObject;
        }

        @Override // com.bumptech.glide.request.target.Target
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResourceReady(android.graphics.Bitmap bitmap, com.bumptech.glide.request.transition.Transition transition) {
            org.json.JSONObject jSONObjectOptJSONObject = this.a.optJSONObject("pos");
            if (jSONObjectOptJSONObject == null) {
                return;
            }
            final android.widget.RelativeLayout relativeLayout = new android.widget.RelativeLayout(io.dcloud.p.k4.this.a());
            android.widget.ImageView imageView = new android.widget.ImageView(io.dcloud.p.k4.this.a());
            int iPxFromDp = io.dcloud.sdk.core.util.AdSizeUtil.pxFromDp(jSONObjectOptJSONObject.optInt("width", -2), io.dcloud.p.k4.this.a().getResources().getDisplayMetrics());
            int iPxFromDp2 = io.dcloud.sdk.core.util.AdSizeUtil.pxFromDp(jSONObjectOptJSONObject.optInt("height", -2), io.dcloud.p.k4.this.a().getResources().getDisplayMetrics());
            int iPxFromDp3 = io.dcloud.sdk.core.util.AdSizeUtil.pxFromDp(jSONObjectOptJSONObject.optInt("left", -1), io.dcloud.p.k4.this.a().getResources().getDisplayMetrics());
            int iPxFromDp4 = io.dcloud.sdk.core.util.AdSizeUtil.pxFromDp(jSONObjectOptJSONObject.optInt("right", -1), io.dcloud.p.k4.this.a().getResources().getDisplayMetrics());
            int iPxFromDp5 = io.dcloud.sdk.core.util.AdSizeUtil.pxFromDp(jSONObjectOptJSONObject.optInt("top", -1), io.dcloud.p.k4.this.a().getResources().getDisplayMetrics());
            int iPxFromDp6 = io.dcloud.sdk.core.util.AdSizeUtil.pxFromDp(jSONObjectOptJSONObject.optInt("bottom", -1), io.dcloud.p.k4.this.a().getResources().getDisplayMetrics());
            imageView.setImageBitmap(bitmap);
            imageView.setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
            relativeLayout.addView(imageView, new android.view.ViewGroup.LayoutParams(iPxFromDp, iPxFromDp2));
            android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(-2, -2);
            if (iPxFromDp4 >= 0) {
                layoutParams.rightMargin = iPxFromDp4;
            } else if (iPxFromDp3 >= 0) {
                layoutParams.leftMargin = iPxFromDp3;
            }
            if (iPxFromDp6 >= 0) {
                layoutParams.bottomMargin = iPxFromDp6;
            } else if (iPxFromDp5 >= 0) {
                layoutParams.topMargin = iPxFromDp5;
            }
            if (iPxFromDp3 >= 0) {
                if (iPxFromDp5 >= 0) {
                    layoutParams.gravity = 8388659;
                }
                if (iPxFromDp6 >= 0) {
                    layoutParams.gravity = 8388691;
                }
            }
            if (iPxFromDp4 >= 0) {
                if (iPxFromDp5 >= 0) {
                    layoutParams.gravity = 8388661;
                }
                if (iPxFromDp6 >= 0) {
                    layoutParams.gravity = 8388693;
                }
            }
            final org.json.JSONObject jSONObject = this.a;
            imageView.setOnClickListener(new android.view.View.OnClickListener() { // from class: io.dcloud.p.k4$a$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    this.f$0.a(relativeLayout, jSONObject, view);
                }
            });
            io.dcloud.p.k4.this.b(relativeLayout, layoutParams);
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadCleared(android.graphics.drawable.Drawable drawable) {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(android.widget.RelativeLayout relativeLayout, final org.json.JSONObject jSONObject, android.view.View view) {
            if (relativeLayout.getParent() != null) {
                ((android.view.ViewGroup) relativeLayout.getParent()).removeView(relativeLayout);
            }
            java.lang.String strOptString = jSONObject.optString("click_action", "");
            if (strOptString.equals("browser")) {
                io.dcloud.p.c.c(io.dcloud.p.k4.this.a(), jSONObject.optString("url"));
            } else if (strOptString.equals("url")) {
                io.dcloud.p.c.e(io.dcloud.p.k4.this.a(), jSONObject.optString("url"));
            }
            final java.lang.String appId = io.dcloud.p.r0.d().b().getAppId();
            final java.lang.String adId = io.dcloud.p.r0.d().b().getAdId();
            io.dcloud.p.x4.a().a(new java.lang.Runnable() { // from class: io.dcloud.p.k4$a$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a(appId, jSONObject, adId);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(java.lang.String str, org.json.JSONObject jSONObject, java.lang.String str2) {
            io.dcloud.p.d0.a(io.dcloud.p.k4.this.a(), str, jSONObject.optString("tid"), str2, 10, "");
        }
    }
}
