package io.dcloud.sdk.base.dcloud;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class g {
    io.dcloud.p.o a;
    io.dcloud.sdk.base.dcloud.ADHandler.e b;
    android.view.View c;
    android.view.View d;
    android.content.Context h;
    boolean e = false;
    boolean f = false;
    boolean g = false;
    android.content.BroadcastReceiver i = new io.dcloud.sdk.base.dcloud.g.b();
    private final java.lang.Runnable j = new java.lang.Runnable() { // from class: io.dcloud.sdk.base.dcloud.g$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            this.f$0.a();
        }
    };

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class a implements io.dcloud.p.s1 {
        final /* synthetic */ android.content.Context a;

        a(android.content.Context context) {
            this.a = context;
        }

        @Override // io.dcloud.p.s1
        public void onReceiver(org.json.JSONObject jSONObject) {
            io.dcloud.sdk.base.dcloud.ADHandler.a("adh", "listenADReceive----------------onReceiver-");
            io.dcloud.sdk.base.dcloud.g gVar = io.dcloud.sdk.base.dcloud.g.this;
            if (gVar.f) {
                return;
            }
            android.content.Context context = gVar.h;
            io.dcloud.sdk.base.dcloud.ADHandler.e eVar = gVar.b;
            io.dcloud.sdk.base.dcloud.ADHandler.a(context, eVar.h, eVar);
            if (io.dcloud.sdk.base.dcloud.g.this.b.a()) {
                io.dcloud.sdk.base.dcloud.g.this.c();
            } else {
                io.dcloud.sdk.base.dcloud.g.this.a(this.a);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class b extends android.content.BroadcastReceiver {
        b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(android.content.Context context, android.content.Intent intent) {
            if (io.dcloud.sdk.base.dcloud.g.this.f) {
                return;
            }
            java.lang.String stringExtra = intent.getStringExtra("src");
            if (android.text.TextUtils.isEmpty(stringExtra) || io.dcloud.sdk.base.dcloud.g.this.b.c() == null || !io.dcloud.sdk.base.dcloud.g.this.b.b().optString("src").equalsIgnoreCase(stringExtra)) {
                return;
            }
            if (!intent.getBooleanExtra("downloadImage", false)) {
                io.dcloud.sdk.base.dcloud.g.this.a();
                return;
            }
            io.dcloud.sdk.base.dcloud.ADHandler.e eVar = io.dcloud.sdk.base.dcloud.g.this.b;
            io.dcloud.sdk.base.dcloud.ADHandler.a(context, eVar.h, eVar);
            if (io.dcloud.sdk.base.dcloud.g.this.b.a()) {
                io.dcloud.sdk.base.dcloud.g.this.c();
            } else {
                io.dcloud.sdk.base.dcloud.g.this.a();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class c implements android.view.View.OnClickListener {
        final /* synthetic */ android.content.Context a;

        c(android.content.Context context) {
            this.a = context;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(android.view.View view) {
            try {
                io.dcloud.sdk.base.dcloud.g.this.b.c().put("down_x", java.lang.Math.round(io.dcloud.sdk.base.dcloud.g.this.b.a.getX()));
                io.dcloud.sdk.base.dcloud.g.this.b.c().put("down_y", java.lang.Math.round(io.dcloud.sdk.base.dcloud.g.this.b.a.getY()));
                io.dcloud.sdk.base.dcloud.g.this.b.c().put("up_x", java.lang.Math.round(io.dcloud.sdk.base.dcloud.g.this.b.b.getX()));
                io.dcloud.sdk.base.dcloud.g.this.b.c().put("up_y", io.dcloud.sdk.base.dcloud.g.this.b.b.getY());
                io.dcloud.sdk.base.dcloud.g.this.b.c().put("relative_down_x", java.lang.Math.round(io.dcloud.sdk.base.dcloud.g.this.b.a.getX() - view.getX()));
                io.dcloud.sdk.base.dcloud.g.this.b.c().put("relative_down_y", java.lang.Math.round(io.dcloud.sdk.base.dcloud.g.this.b.a.getY() - view.getY()));
                io.dcloud.sdk.base.dcloud.g.this.b.c().put("relative_up_x", java.lang.Math.round(io.dcloud.sdk.base.dcloud.g.this.b.b.getX() - view.getX()));
                io.dcloud.sdk.base.dcloud.g.this.b.c().put("relative_up_y", java.lang.Math.round(io.dcloud.sdk.base.dcloud.g.this.b.b.getY() - view.getY()));
                io.dcloud.sdk.base.dcloud.g.this.b.c().put("dw", io.dcloud.p.m.b(this.a));
                io.dcloud.sdk.base.dcloud.g.this.b.c().put("dh", io.dcloud.p.m.a(this.a));
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
            android.content.Context context = this.a;
            io.dcloud.sdk.base.dcloud.ADHandler.a(context, io.dcloud.sdk.base.dcloud.g.this.b, io.dcloud.sdk.base.dcloud.ADHandler.a(context, "adid"));
            view.setOnClickListener(null);
            io.dcloud.sdk.base.dcloud.g gVar = io.dcloud.sdk.base.dcloud.g.this;
            io.dcloud.sdk.base.dcloud.ADHandler.e eVar = gVar.b;
            eVar.a = null;
            eVar.b = null;
            gVar.a.onClicked();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class d implements android.view.View.OnTouchListener {
        d() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                io.dcloud.sdk.base.dcloud.g.this.b.a = motionEvent;
                return false;
            }
            if (motionEvent.getAction() != 1) {
                return false;
            }
            io.dcloud.sdk.base.dcloud.g.this.b.b = motionEvent;
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class e implements android.view.View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(android.view.View view) {
            io.dcloud.sdk.base.dcloud.g gVar = io.dcloud.sdk.base.dcloud.g.this;
            gVar.d.removeCallbacks(gVar.j);
            io.dcloud.sdk.base.dcloud.g.this.a();
        }
    }

    public g(android.content.Context context, io.dcloud.sdk.base.dcloud.ADHandler.e eVar, android.view.ViewGroup viewGroup, io.dcloud.p.o oVar) {
        this.a = null;
        this.c = null;
        this.d = null;
        this.a = oVar;
        this.b = eVar;
        this.h = context;
        android.view.View viewInflate = android.view.LayoutInflater.from(context).inflate(io.dcloud.base.R.layout.dcloud_ad_main_container, (android.view.ViewGroup) null);
        this.d = viewInflate;
        viewGroup.addView(viewInflate);
        this.c = (android.widget.TextView) this.d.findViewById(io.dcloud.base.R.id.ad_dcloud_main_skip);
        if (this.b.a()) {
            io.dcloud.sdk.base.dcloud.ADHandler.a("SplashADViewWrapper", "use cache AdData");
            a(context, this.d);
        } else {
            io.dcloud.sdk.base.dcloud.ADHandler.a("adh", "listenADReceive-----------------");
            this.b.a(context, new io.dcloud.sdk.base.dcloud.g.a(context));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.e) {
            this.d.removeCallbacks(this.j);
            this.d.postDelayed(this.j, 2000L);
        }
        a(this.h, this.d);
    }

    public void a(android.content.Context context) {
        android.content.IntentFilter intentFilter = new android.content.IntentFilter();
        intentFilter.addAction("ad_img_downlaod_receive");
        androidx.localbroadcastmanager.content.LocalBroadcastManager.getInstance(context).registerReceiver(this.i, intentFilter);
        this.g = true;
    }

    public void b() {
        io.dcloud.sdk.base.dcloud.ADHandler.a("ADReceive", "onWillCloseSplash ");
        this.e = true;
        if (this.c != null && this.b.a()) {
            this.c.setVisibility(0);
        }
        this.d.postDelayed(this.j, io.dcloud.WebAppActivity.SPLASH_SECOND);
    }

    private void a(android.content.Context context, android.view.View view) {
        io.dcloud.sdk.base.dcloud.ADHandler.a("ADReceive", "initAdMainView ");
        android.widget.FrameLayout frameLayout = (android.widget.FrameLayout) view.findViewById(io.dcloud.base.R.id.ad_dcloud_main_img);
        frameLayout.setOnClickListener(new io.dcloud.sdk.base.dcloud.g.c(context));
        frameLayout.setOnTouchListener(new io.dcloud.sdk.base.dcloud.g.d());
        java.lang.Object obj = this.b.e;
        if (obj instanceof android.graphics.Bitmap) {
            io.dcloud.sdk.base.dcloud.ADHandler.e eVar = this.b;
            frameLayout.addView(new io.dcloud.sdk.base.dcloud.f(context, (android.graphics.Bitmap) eVar.e, eVar), -1, -1);
        } else if (obj instanceof android.graphics.drawable.Drawable) {
            android.widget.ImageView imageView = (android.widget.ImageView) io.dcloud.sdk.core.util.ReflectUtil.newInstance("pl.droidsonroids.gif.GifImageView", new java.lang.Class[]{android.content.Context.class}, new java.lang.Object[]{context});
            imageView.setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
            imageView.setImageDrawable((android.graphics.drawable.Drawable) this.b.e);
            frameLayout.addView(imageView, -1, -1);
        }
        if (this.e) {
            this.c.setVisibility(0);
        }
        this.c.setOnClickListener(new io.dcloud.sdk.base.dcloud.g.e());
        io.dcloud.sdk.base.dcloud.ADHandler.c(context, this.b, io.dcloud.sdk.base.dcloud.ADHandler.a(context, "adid"));
        this.a.onShow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        this.a.onFinishShow();
        android.view.View view = this.d;
        if (view != null && view.getParent() != null) {
            ((android.view.ViewGroup) this.d.getParent()).removeView(this.d);
        }
        this.f = true;
        java.lang.Object obj = this.b.e;
        if (obj instanceof android.graphics.Bitmap) {
            android.graphics.Bitmap bitmap = (android.graphics.Bitmap) obj;
            if (!bitmap.isRecycled()) {
                bitmap.recycle();
            }
        }
        this.e = false;
        if (this.g) {
            androidx.localbroadcastmanager.content.LocalBroadcastManager.getInstance(this.h).unregisterReceiver(this.i);
        }
    }
}
