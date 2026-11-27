package io.dcloud.feature.gallery.imageedit;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
abstract class a extends android.app.Activity implements android.view.View.OnClickListener, io.dcloud.feature.gallery.imageedit.b.a, android.widget.RadioGroup.OnCheckedChangeListener, android.content.DialogInterface.OnShowListener, android.content.DialogInterface.OnDismissListener, io.dcloud.p.j2.b {
    protected io.dcloud.feature.gallery.imageedit.view.IMGView a;
    private android.widget.RadioGroup b;
    private io.dcloud.feature.gallery.imageedit.view.IMGColorGroup c;
    private io.dcloud.feature.gallery.imageedit.b d;
    private android.view.View e;
    private android.view.View f;
    private android.view.View g;
    private android.widget.ViewSwitcher h;
    private android.widget.ViewSwitcher i;

    /* JADX INFO: renamed from: io.dcloud.feature.gallery.imageedit.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static /* synthetic */ class C0042a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[io.dcloud.p.k2.values().length];
            a = iArr;
            try {
                iArr[io.dcloud.p.k2.DOODLE.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                a[io.dcloud.p.k2.MOSAIC.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                a[io.dcloud.p.k2.NONE.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
        }
    }

    a() {
    }

    private void d() {
        this.a = (io.dcloud.feature.gallery.imageedit.view.IMGView) findViewById(io.dcloud.base.R.id.image_canvas);
        this.b = (android.widget.RadioGroup) findViewById(io.dcloud.base.R.id.rg_modes);
        this.a.setDoodleTouchListener(this);
        this.h = (android.widget.ViewSwitcher) findViewById(io.dcloud.base.R.id.vs_op);
        this.i = (android.widget.ViewSwitcher) findViewById(io.dcloud.base.R.id.vs_op_sub);
        io.dcloud.feature.gallery.imageedit.view.IMGColorGroup iMGColorGroup = (io.dcloud.feature.gallery.imageedit.view.IMGColorGroup) findViewById(io.dcloud.base.R.id.cg_colors);
        this.c = iMGColorGroup;
        iMGColorGroup.setOnCheckedChangeListener(this);
        this.e = findViewById(io.dcloud.base.R.id.layout_op_sub);
        this.f = findViewById(io.dcloud.base.R.id.dcloud_image_edit_head);
        this.g = findViewById(io.dcloud.base.R.id.dcloud_image_edit_foot);
    }

    public void a() {
        this.f.setVisibility(0);
        this.g.setVisibility(0);
    }

    public abstract void a(int i);

    public abstract void a(io.dcloud.p.k2 k2Var);

    public void b(int i) {
        if (i >= 0) {
            this.h.setDisplayedChild(i);
        }
    }

    public abstract android.graphics.Bitmap c();

    public void c(int i) {
        if (i < 0) {
            this.e.setVisibility(8);
        } else {
            this.i.setDisplayedChild(i);
            this.e.setVisibility(0);
        }
    }

    public abstract void e();

    public abstract void f();

    public abstract void g();

    public abstract void h();

    public abstract void i();

    public abstract void j();

    public abstract void k();

    public void l() {
        if (this.d == null) {
            io.dcloud.feature.gallery.imageedit.b bVar = new io.dcloud.feature.gallery.imageedit.b(this, this);
            this.d = bVar;
            bVar.setOnShowListener(this);
            this.d.setOnDismissListener(this);
        }
        this.d.show();
    }

    public abstract void m();

    public void n() {
        int i = io.dcloud.feature.gallery.imageedit.a.C0042a.a[this.a.getMode().ordinal()];
        if (i == 1) {
            this.b.check(io.dcloud.base.R.id.rb_doodle);
            c(0);
        } else if (i == 2) {
            this.b.check(io.dcloud.base.R.id.rb_mosaic);
            c(1);
        } else {
            if (i != 3) {
                return;
            }
            this.b.clearCheck();
            c(-1);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.a.getMode() == io.dcloud.p.k2.CLIP) {
            f();
        } else {
            super.onBackPressed();
        }
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public final void onCheckedChanged(android.widget.RadioGroup radioGroup, int i) {
        a(this.c.getCheckColor());
    }

    public void onClick(android.view.View view) {
        int id = view.getId();
        if (id == io.dcloud.base.R.id.rb_doodle) {
            a(io.dcloud.p.k2.DOODLE);
            return;
        }
        if (id == io.dcloud.base.R.id.btn_text) {
            l();
            return;
        }
        if (id == io.dcloud.base.R.id.rb_mosaic) {
            a(io.dcloud.p.k2.MOSAIC);
            return;
        }
        if (id == io.dcloud.base.R.id.btn_clip) {
            a(io.dcloud.p.k2.CLIP);
            return;
        }
        if (id == io.dcloud.base.R.id.btn_undo) {
            m();
            return;
        }
        if (id == io.dcloud.base.R.id.tv_done) {
            h();
            return;
        }
        if (id == io.dcloud.base.R.id.tv_cancel) {
            e();
            return;
        }
        if (id == io.dcloud.base.R.id.ib_clip_cancel) {
            f();
            return;
        }
        if (id == io.dcloud.base.R.id.ib_clip_done) {
            i();
        } else if (id == io.dcloud.base.R.id.tv_clip_reset) {
            j();
        } else if (id == io.dcloud.base.R.id.ib_clip_rotate) {
            k();
        }
    }

    @Override // android.app.Activity
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        android.graphics.Bitmap bitmapC = c();
        if (bitmapC != null) {
            setContentView(io.dcloud.base.R.layout.image_edit_activity);
            d();
            this.a.setImageBitmap(bitmapC);
            g();
        } else {
            finish();
        }
        int i = android.os.Build.VERSION.SDK_INT;
        android.view.Window window = getWindow();
        window.getDecorView().setSystemUiVisibility(512);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(0);
        window.setNavigationBarColor(0);
        if (i >= 28) {
            android.view.WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.layoutInDisplayCutoutMode = 1;
            getWindow().setAttributes(attributes);
        }
    }

    public void onDismiss(android.content.DialogInterface dialogInterface) {
        this.h.setVisibility(0);
    }

    public void onShow(android.content.DialogInterface dialogInterface) {
        this.h.setVisibility(8);
    }

    public void b() {
        this.f.setVisibility(4);
        this.g.setVisibility(4);
    }
}
