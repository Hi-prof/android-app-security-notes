package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class f4 extends android.app.Dialog {
    private final android.content.Context a;
    private android.widget.TextView b;
    private android.widget.TextView c;
    private android.widget.Button d;
    private android.widget.Button e;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class a implements android.view.View.OnClickListener {
        final /* synthetic */ android.view.View.OnClickListener a;

        a(android.view.View.OnClickListener onClickListener) {
            this.a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(android.view.View view) {
            android.view.View.OnClickListener onClickListener = this.a;
            if (onClickListener != null) {
                onClickListener.onClick(view);
                io.dcloud.p.f4.this.dismiss();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class b implements android.view.View.OnClickListener {
        final /* synthetic */ android.view.View.OnClickListener a;

        b(android.view.View.OnClickListener onClickListener) {
            this.a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(android.view.View view) {
            android.view.View.OnClickListener onClickListener = this.a;
            if (onClickListener != null) {
                onClickListener.onClick(view);
                io.dcloud.p.f4.this.cancel();
            }
        }
    }

    public f4(android.content.Context context) {
        super(context);
        this.a = context;
        a();
    }

    private void a() {
        requestWindowFeature(1);
        setContentView(io.dcloud.base.R.layout.dcloud_sample_dialog);
        b();
        getWindow().setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(0));
        c();
        setCanceledOnTouchOutside(false);
        setCancelable(false);
    }

    private void b() {
        this.b = (android.widget.TextView) findViewById(io.dcloud.base.R.id.tv_sample_dialog_title);
        this.c = (android.widget.TextView) findViewById(io.dcloud.base.R.id.tv_sample_dialog_content);
        this.d = (android.widget.Button) findViewById(io.dcloud.base.R.id.btn_sample_dialog_sure);
        this.e = (android.widget.Button) findViewById(io.dcloud.base.R.id.btn_sample_dialog_cancel);
    }

    private void c() {
        android.view.Display defaultDisplay = ((android.app.Activity) this.a).getWindowManager().getDefaultDisplay();
        if (this.a.getResources().getConfiguration().orientation == 1) {
            this.c.setMaxHeight((int) (((double) defaultDisplay.getHeight()) * 0.6d));
        } else {
            this.c.setMaxHeight((int) (((double) defaultDisplay.getHeight()) * 0.5d));
        }
    }

    public void b(int i) {
        android.view.Window window = getWindow();
        android.view.WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.x = 0;
        attributes.y = 0;
        window.setLayout(i, attributes.height);
    }

    public void a(int i) {
        this.c.setGravity(i);
    }

    public void a(java.lang.String str) {
        this.c.setText(str);
    }

    public void a(java.lang.String str, android.view.View.OnClickListener onClickListener) {
        this.e.setVisibility(0);
        this.e.setText(str);
        this.e.setOnClickListener(new io.dcloud.p.f4.b(onClickListener));
    }

    public void b(java.lang.String str) {
        this.b.setText(str);
    }

    public void b(java.lang.String str, android.view.View.OnClickListener onClickListener) {
        this.d.setVisibility(0);
        this.d.setText(str);
        this.d.setOnClickListener(new io.dcloud.p.f4.a(onClickListener));
    }
}
