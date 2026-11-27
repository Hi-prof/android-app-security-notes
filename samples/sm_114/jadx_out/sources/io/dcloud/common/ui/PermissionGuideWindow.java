package io.dcloud.common.ui;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class PermissionGuideWindow implements io.dcloud.common.DHInterface.IReflectAble {
    private static java.lang.ref.WeakReference f;
    private android.content.Context a;
    private final android.os.Handler b = new android.os.Handler(android.os.Looper.getMainLooper());
    private android.view.WindowManager c;
    private android.view.WindowManager.LayoutParams d;
    private android.view.ViewGroup e;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class a implements java.lang.Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            io.dcloud.common.ui.PermissionGuideWindow.this.dismissWindow();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class b implements android.view.View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(android.view.View view) {
            io.dcloud.common.ui.PermissionGuideWindow.this.dismissWindow();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class c implements io.dcloud.common.ui.GifImageView.a {
        final /* synthetic */ android.widget.ImageView a;

        c(android.widget.ImageView imageView) {
            this.a = imageView;
        }

        @Override // io.dcloud.common.ui.GifImageView.a
        public void a() {
        }

        @Override // io.dcloud.common.ui.GifImageView.a
        public void a(float f) {
        }

        @Override // io.dcloud.common.ui.GifImageView.a
        public void a(boolean z) {
        }

        @Override // io.dcloud.common.ui.GifImageView.a
        public void onPlayEnd() {
            android.widget.ImageView imageView = this.a;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
        }

        @Override // io.dcloud.common.ui.GifImageView.a
        public void onPlayStart() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class d implements android.view.View.OnClickListener {
        final /* synthetic */ io.dcloud.common.ui.GifImageView a;
        final /* synthetic */ android.widget.ImageView b;

        d(io.dcloud.common.ui.GifImageView gifImageView, android.widget.ImageView imageView) {
            this.a = gifImageView;
            this.b = imageView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(android.view.View view) {
            io.dcloud.common.ui.GifImageView gifImageView = this.a;
            if (gifImageView != null) {
                gifImageView.pause();
            }
            android.widget.ImageView imageView = this.b;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class e implements android.view.View.OnClickListener {
        final /* synthetic */ io.dcloud.common.ui.GifImageView a;
        final /* synthetic */ android.widget.ImageView b;

        e(io.dcloud.common.ui.GifImageView gifImageView, android.widget.ImageView imageView) {
            this.a = gifImageView;
            this.b = imageView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(android.view.View view) {
            io.dcloud.common.ui.GifImageView gifImageView = this.a;
            if (gifImageView != null) {
                gifImageView.play();
            }
            android.widget.ImageView imageView = this.b;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
        }
    }

    public PermissionGuideWindow(android.content.Context context) {
        this.a = context.getApplicationContext();
    }

    public static io.dcloud.common.ui.PermissionGuideWindow getInstance(android.content.Context context) {
        java.lang.ref.WeakReference weakReference = f;
        if (weakReference == null || weakReference.get() == null) {
            f = new java.lang.ref.WeakReference(new io.dcloud.common.ui.PermissionGuideWindow(context));
        }
        return (io.dcloud.common.ui.PermissionGuideWindow) f.get();
    }

    public void dismissWindow() {
        try {
            android.view.WindowManager windowManager = this.c;
            if (windowManager != null) {
                windowManager.removeView(this.e);
                this.e.removeAllViews();
                this.e = null;
                this.c = null;
            }
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
    }

    public void dismissWindowDelayed(long j) {
        this.b.postDelayed(new io.dcloud.common.ui.PermissionGuideWindow.a(), j);
    }

    public void showWindow(java.lang.String str, int i) {
        if (i == 0) {
            return;
        }
        try {
            if (this.c == null) {
                this.c = (android.view.WindowManager) this.a.getSystemService("window");
                android.view.WindowManager.LayoutParams layoutParams = new android.view.WindowManager.LayoutParams();
                this.d = layoutParams;
                layoutParams.gravity = 21;
                layoutParams.type = 2005;
                if (android.os.Build.BRAND.equalsIgnoreCase(io.dcloud.common.adapter.util.MobilePhoneModel.XIAOMI) && android.os.Build.VERSION.SDK_INT >= 25) {
                    this.d.type = 2002;
                }
                android.view.WindowManager.LayoutParams layoutParams2 = this.d;
                layoutParams2.format = -3;
                layoutParams2.flags = 40;
                layoutParams2.width = io.dcloud.common.util.DensityUtils.dip2px(this.a, 220.0f);
                this.d.height = -2;
            }
            if (this.e == null) {
                this.e = (android.view.ViewGroup) android.view.LayoutInflater.from(this.a).inflate(io.dcloud.PdrR.DCLOUD_SHORTCUT_PERMISSION_GUIDE_LAYOUT, (android.view.ViewGroup) null);
            }
            if (this.e.getParent() != null) {
                this.c.removeViewImmediate(this.e);
            }
            this.c.addView(this.e, this.d);
            this.e.findViewById(io.dcloud.PdrR.DCLOUD_GUIDE_CLOSE).setOnClickListener(new io.dcloud.common.ui.PermissionGuideWindow.b());
            android.widget.ImageView imageView = (android.widget.ImageView) this.e.findViewById(io.dcloud.PdrR.DCLOUD_GUIDE_PLAY);
            io.dcloud.common.ui.GifImageView gifImageView = (io.dcloud.common.ui.GifImageView) this.e.findViewById(io.dcloud.PdrR.DCLOUD_GUIDE_GIFVIEW);
            android.widget.RelativeLayout relativeLayout = (android.widget.RelativeLayout) this.e.findViewById(io.dcloud.PdrR.DCLOUD_GUIDE_PLAY_LAYOUT);
            android.widget.TextView textView = (android.widget.TextView) this.e.findViewById(io.dcloud.PdrR.DCLOUD_GUIDE_TIP);
            if (!io.dcloud.common.util.PdrUtil.isEmpty(str)) {
                textView.setText(str);
            }
            if (1 == i) {
                relativeLayout.setVisibility(8);
                gifImageView.setVisibility(8);
            } else {
                gifImageView.setGifResource(i);
            }
            gifImageView.setOnPlayListener(new io.dcloud.common.ui.PermissionGuideWindow.c(imageView));
            gifImageView.setOnClickListener(new io.dcloud.common.ui.PermissionGuideWindow.d(gifImageView, imageView));
            imageView.setOnClickListener(new io.dcloud.common.ui.PermissionGuideWindow.e(gifImageView, imageView));
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
    }
}
