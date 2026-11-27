package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class o4 extends android.widget.RelativeLayout implements android.view.View.OnClickListener {
    android.graphics.drawable.Drawable a;
    private android.view.ViewGroup b;
    private android.view.View c;
    private android.widget.ImageView d;
    private android.widget.TextView e;
    private io.dcloud.p.v2.c f;
    private io.dcloud.sdk.base.entry.AdData g;
    private int h;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class a implements java.lang.Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (io.dcloud.p.o4.this.f != null) {
                io.dcloud.p.o4.this.f.j();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class b implements java.lang.Runnable {
        final /* synthetic */ android.view.ViewGroup a;

        b(android.view.ViewGroup viewGroup) {
            this.a = viewGroup;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!io.dcloud.p.a.a(this.a)) {
                if (io.dcloud.p.o4.this.f != null) {
                    io.dcloud.p.o4.this.f.a(60010, "广告容器不可见");
                    return;
                }
                return;
            }
            io.dcloud.p.o4 o4Var = io.dcloud.p.o4.this;
            if (o4Var.a == null) {
                if (o4Var.f != null) {
                    io.dcloud.p.o4.this.f.a(60004, "图片资源加载失败");
                    return;
                }
                return;
            }
            this.a.removeAllViews();
            this.a.getGlobalVisibleRect(new android.graphics.Rect());
            this.a.getRootView().getGlobalVisibleRect(new android.graphics.Rect());
            this.a.addView(io.dcloud.p.o4.this, new android.view.ViewGroup.LayoutParams(-1, -1));
            io.dcloud.p.o4.this.g.a(new android.graphics.RectF(this.a.getX(), this.a.getY(), 0.0f, 0.0f));
            io.dcloud.p.o4.this.d.setImageDrawable(io.dcloud.p.o4.this.a);
            if (io.dcloud.p.o4.this.f != null) {
                io.dcloud.p.o4.this.f.onAdShow();
            }
            io.dcloud.p.o4.this.g.a();
            io.dcloud.p.l4.a().b(io.dcloud.p.o4.this.getContext(), io.dcloud.p.o4.this.g.k());
        }
    }

    public o4(android.content.Context context, io.dcloud.p.v2.c cVar, io.dcloud.sdk.base.entry.AdData adData) {
        super(context);
        this.h = com.nostra13.dcloudimageloader.core.download.BaseImageDownloader.DEFAULT_HTTP_CONNECT_TIMEOUT;
        this.f = cVar;
        this.g = adData;
        this.h = adData.i();
        android.view.ViewGroup viewGroup = (android.view.ViewGroup) android.view.LayoutInflater.from(getContext()).inflate(io.dcloud.base.R.layout.dcloud_ad_splash_container, (android.view.ViewGroup) null);
        this.b = viewGroup;
        this.c = viewGroup.findViewById(io.dcloud.base.R.id.ad_dcloud_main_skip);
        this.d = (android.widget.ImageView) this.b.findViewById(io.dcloud.base.R.id.ad_dcloud_main_img);
        this.e = (android.widget.TextView) this.b.findViewById(io.dcloud.base.R.id.ad_dcloud_main_click);
        this.d.setOnClickListener(this);
        this.c.setOnClickListener(this);
        addView(this.b, -1);
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        if (adData.g() == null) {
            android.graphics.BitmapFactory.decodeFile(adData.f(), options);
            java.lang.String str = options.outMimeType;
            if (android.text.TextUtils.isEmpty(str) || !str.toLowerCase(java.util.Locale.ENGLISH).contains("gif")) {
                this.a = new io.dcloud.p.m4(android.graphics.BitmapFactory.decodeFile(adData.f()), getContext());
                return;
            }
            try {
                this.a = new pl.droidsonroids.gif.GifDrawable(adData.f());
                return;
            } catch (java.io.IOException unused) {
                this.a = new io.dcloud.p.m4(android.graphics.BitmapFactory.decodeFile(adData.f()), getContext());
                return;
            }
        }
        android.graphics.BitmapFactory.decodeByteArray(adData.g(), 0, adData.g().length, options);
        java.lang.String str2 = options.outMimeType;
        if (android.text.TextUtils.isEmpty(str2) || !str2.toLowerCase(java.util.Locale.ENGLISH).contains("gif")) {
            this.a = new io.dcloud.p.m4(android.graphics.BitmapFactory.decodeByteArray(adData.g(), 0, adData.g().length), getContext());
            return;
        }
        try {
            this.a = new pl.droidsonroids.gif.GifDrawable(adData.g());
        } catch (java.io.IOException unused2) {
            this.a = new io.dcloud.p.m4(android.graphics.BitmapFactory.decodeByteArray(adData.g(), 0, adData.g().length), getContext());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.g.a(motionEvent);
        } else if (motionEvent.getAction() == 1) {
            this.g.b(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(android.view.View view) {
        if (view.getId() == io.dcloud.base.R.id.ad_dcloud_main_skip) {
            io.dcloud.p.v2.c cVar = this.f;
            if (cVar != null) {
                cVar.k();
                return;
            }
            return;
        }
        if (view.getId() == io.dcloud.base.R.id.ad_dcloud_main_img) {
            io.dcloud.p.v2.c cVar2 = this.f;
            if (cVar2 != null) {
                cVar2.onAdClicked();
            }
            this.g.a(getContext());
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(android.view.View view, int i) {
        super.onVisibilityChanged(view, i);
    }

    public void a(android.view.ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        viewGroup.postDelayed(new io.dcloud.p.o4.a(), this.h);
        viewGroup.postDelayed(new io.dcloud.p.o4.b(viewGroup), 50L);
    }
}
