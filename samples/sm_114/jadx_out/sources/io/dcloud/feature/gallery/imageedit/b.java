package io.dcloud.feature.gallery.imageedit;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class b extends android.app.Dialog implements android.view.View.OnClickListener, android.widget.RadioGroup.OnCheckedChangeListener {
    private android.widget.EditText a;
    private io.dcloud.feature.gallery.imageedit.b.a b;
    private io.dcloud.p.r2 c;
    private io.dcloud.feature.gallery.imageedit.view.IMGColorGroup d;
    private int e;
    private android.widget.TextView f;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public interface a {
        void a(io.dcloud.p.r2 r2Var);
    }

    public b(android.content.Context context, io.dcloud.feature.gallery.imageedit.b.a aVar) {
        super(context, io.dcloud.base.R.style.ImageTextDialog);
        this.e = -1;
        setContentView(io.dcloud.base.R.layout.image_text_dialog);
        this.b = aVar;
        android.view.Window window = getWindow();
        if (window != null) {
            window.setLayout(-1, -1);
        }
    }

    private void b() {
        try {
            java.lang.reflect.Field declaredField = android.widget.TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            declaredField.set(this.a, java.lang.Integer.valueOf(io.dcloud.base.R.drawable.image_edit_cursor));
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public void a(io.dcloud.p.r2 r2Var) {
        this.c = r2Var;
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(android.widget.RadioGroup radioGroup, int i) {
        this.e = this.d.getCheckColor();
        if (!this.f.isSelected()) {
            this.a.setTextColor(this.e);
            this.a.setBackgroundColor(0);
        } else {
            if (this.e == -1) {
                this.a.setTextColor(-16777216);
            } else {
                this.a.setTextColor(-1);
            }
            this.a.setBackgroundColor(this.e);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(android.view.View view) {
        int id = view.getId();
        if (id == io.dcloud.base.R.id.tv_done) {
            a();
            this.e = -1;
            this.a.setBackgroundColor(0);
            return;
        }
        if (id == io.dcloud.base.R.id.tv_cancel) {
            dismiss();
            this.e = -1;
            this.a.setBackgroundColor(0);
        } else if (id == io.dcloud.base.R.id.textview_1) {
            view.setSelected(!view.isSelected());
            if (!view.isSelected()) {
                this.a.setTextColor(this.e);
                this.a.setBackgroundColor(0);
            } else {
                if (this.e == -1) {
                    this.a.setTextColor(-16777216);
                } else {
                    this.a.setTextColor(-1);
                }
                this.a.setBackgroundColor(this.e);
            }
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        io.dcloud.feature.gallery.imageedit.view.IMGColorGroup iMGColorGroup = (io.dcloud.feature.gallery.imageedit.view.IMGColorGroup) findViewById(io.dcloud.base.R.id.cg_colors);
        this.d = iMGColorGroup;
        iMGColorGroup.setOnCheckedChangeListener(this);
        this.a = (android.widget.EditText) findViewById(io.dcloud.base.R.id.et_text);
        findViewById(io.dcloud.base.R.id.tv_cancel).setOnClickListener(this);
        findViewById(io.dcloud.base.R.id.tv_done).setOnClickListener(this);
        android.widget.TextView textView = (android.widget.TextView) findViewById(io.dcloud.base.R.id.textview_1);
        this.f = textView;
        textView.setOnClickListener(this);
        this.f.setSelected(false);
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
        this.a.setPadding(30, 30, 30, 30);
        io.dcloud.p.r2 r2Var = this.c;
        if (r2Var != null) {
            this.a.setText(r2Var.c());
            int iB = this.c.b();
            this.e = iB;
            this.a.setTextColor(iB);
            b();
            int iA = this.c.a();
            if (iA == 0) {
                this.f.setSelected(false);
                this.a.setBackgroundColor(0);
            } else {
                this.e = iA;
                this.a.setBackgroundColor(iA);
                this.f.setSelected(true);
            }
            if (!this.c.d()) {
                android.widget.EditText editText = this.a;
                editText.setSelection(editText.length());
            }
            this.c = null;
        } else {
            this.a.setText("");
            this.f.setSelected(false);
        }
        getCurrentFocus();
        this.d.setCheckColor(this.e);
        this.a.requestFocus();
    }

    private void a() {
        int i;
        int i2;
        java.lang.String string = this.a.getText().toString();
        if (!android.text.TextUtils.isEmpty(string) && this.b != null) {
            if (this.f.isSelected()) {
                i2 = this.e;
                i = -1;
                if (i2 == -1) {
                    i = -16777216;
                }
            } else {
                i = this.e;
                i2 = 0;
            }
            this.b.a(new io.dcloud.p.r2(string, i, i2));
        }
        dismiss();
    }
}
