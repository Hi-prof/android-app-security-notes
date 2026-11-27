package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class g extends android.app.AlertDialog implements android.view.View.OnClickListener {
    private android.content.Context a;
    public io.dcloud.p.g.b b;
    private android.view.View c;
    private android.view.ViewGroup d;
    private android.view.View e;
    private java.util.List f;
    private java.lang.String g;
    private java.lang.String h;
    private int i;
    private boolean j;
    private boolean k;
    private boolean l;
    private float m;
    private int n;
    private boolean o;
    private boolean p;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class a implements android.content.DialogInterface.OnCancelListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(android.content.DialogInterface dialogInterface) {
            io.dcloud.p.g.this.a(-1);
            io.dcloud.p.g.b bVar = io.dcloud.p.g.this.b;
            if (bVar != null) {
                bVar.onItemClick(-1);
            }
            io.dcloud.p.g.this.l = false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public interface b {
        void initCancelText(android.widget.TextView textView);

        void initTextItem(int i, android.widget.TextView textView, java.lang.String str);

        boolean onDismiss(int i);

        void onItemClick(int i);
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public class c {
        public java.lang.String a;
        public java.lang.String b;
        public java.lang.String c;

        public c(java.lang.String str, java.lang.String str2, java.lang.String str3) {
            if (str2 == null) {
                this.b = "normal";
            } else {
                this.b = str2;
            }
            this.a = str;
            this.c = str3;
        }
    }

    public g(android.content.Context context) {
        super(context);
        this.g = "";
        this.h = "";
        this.i = -16777216;
        this.k = true;
        this.l = true;
        this.m = 16.0f;
        this.n = 0;
        this.o = true;
        this.p = false;
        a(context);
    }

    private android.view.animation.Animation b() {
        android.view.animation.AlphaAnimation alphaAnimation = new android.view.animation.AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setFillAfter(true);
        return alphaAnimation;
    }

    private void c() {
        int intrinsicHeight = g().getIntrinsicHeight();
        boolean zIsEmpty = android.text.TextUtils.isEmpty(this.g);
        boolean z = !zIsEmpty;
        boolean z2 = !android.text.TextUtils.isEmpty(this.h);
        java.lang.String str = this.h;
        if (str != null && android.text.TextUtils.isEmpty(str)) {
            this.h = getContext().getResources().getString(android.R.string.cancel);
            z2 = true;
        }
        if (z2) {
            android.widget.TextView textView = new android.widget.TextView(this.a);
            textView.setGravity(17);
            textView.getPaint().setFakeBoldText(true);
            textView.setTextSize(2, this.m);
            textView.setId(100);
            textView.setBackground(this.a.getResources().getDrawable(io.dcloud.base.R.drawable.dcloud_ad_slt_as_ios7_other_bt_middle));
            textView.setText(this.h);
            textView.setTextColor(this.i);
            textView.setOnClickListener(this);
            android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-1, b(50));
            layoutParams.addRule(12);
            layoutParams.topMargin = b(this.n);
            this.d.addView(textView, layoutParams);
            io.dcloud.p.g.b bVar = this.b;
            if (bVar != null) {
                bVar.initCancelText(textView);
            }
        }
        android.widget.LinearLayout linearLayout = new android.widget.LinearLayout(this.a);
        android.widget.ScrollView scrollView = new android.widget.ScrollView(this.a);
        linearLayout.setOrientation(1);
        scrollView.setId(300);
        android.widget.FrameLayout.LayoutParams layoutParams2 = new android.widget.FrameLayout.LayoutParams(-1, -2);
        if (zIsEmpty) {
            intrinsicHeight = 0;
        }
        linearLayout.setPadding(0, intrinsicHeight, 0, 0);
        scrollView.addView(linearLayout, layoutParams2);
        android.widget.RelativeLayout.LayoutParams layoutParams3 = new android.widget.RelativeLayout.LayoutParams(-1, -2);
        if (z2) {
            layoutParams3.addRule(2, 100);
        } else {
            layoutParams3.addRule(12);
        }
        this.d.addView(scrollView, layoutParams3);
        if (!zIsEmpty) {
            android.widget.TextView textView2 = new android.widget.TextView(this.a);
            textView2.setGravity(17);
            textView2.setId(200);
            textView2.setOnClickListener(this);
            textView2.setBackgroundDrawable(g());
            textView2.setText(this.g);
            textView2.setTextColor(android.graphics.Color.parseColor("#8C8C8C"));
            textView2.setTextSize(2, this.m);
            android.widget.RelativeLayout.LayoutParams layoutParams4 = new android.widget.RelativeLayout.LayoutParams(-1, -2);
            layoutParams4.topMargin = 0;
            layoutParams4.addRule(6, 300);
            this.d.addView(textView2, layoutParams4);
        }
        java.util.List list = this.f;
        if (list != null && list.size() > 0) {
            for (int i = 0; i < this.f.size(); i++) {
                android.widget.TextView textView3 = new android.widget.TextView(this.a);
                textView3.setGravity(17);
                textView3.setId(i + 101);
                textView3.setOnClickListener(this);
                textView3.setBackgroundDrawable(a(this.f.size(), i, z));
                textView3.setText(((io.dcloud.p.g.c) this.f.get(i)).a);
                textView3.setTextColor(android.graphics.Color.parseColor("#000000"));
                textView3.setTextSize(2, this.m);
                if (i > 0) {
                    android.widget.LinearLayout.LayoutParams layoutParams5 = new android.widget.LinearLayout.LayoutParams(-1, b(50));
                    layoutParams5.topMargin = 0;
                    linearLayout.addView(textView3, layoutParams5);
                } else {
                    linearLayout.addView(textView3, new android.widget.LinearLayout.LayoutParams(-1, b(50)));
                }
                io.dcloud.p.g.b bVar2 = this.b;
                if (bVar2 != null) {
                    bVar2.initTextItem(i, textView3, ((io.dcloud.p.g.c) this.f.get(i)).a);
                }
            }
        }
        int iB = b(this.n);
        this.d.setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(0));
        if (this.p) {
            this.d.setPadding(iB, iB, iB, iB);
        } else {
            this.d.setPadding(0, iB, 0, iB);
        }
    }

    private android.view.animation.Animation d() {
        android.view.animation.TranslateAnimation translateAnimation = new android.view.animation.TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        translateAnimation.setDuration(300L);
        return translateAnimation;
    }

    private android.view.animation.Animation e() {
        android.view.animation.TranslateAnimation translateAnimation = new android.view.animation.TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f);
        translateAnimation.setDuration(300L);
        translateAnimation.setFillAfter(true);
        return translateAnimation;
    }

    private android.view.View f() {
        android.widget.FrameLayout frameLayout = new android.widget.FrameLayout(this.a);
        android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 80;
        frameLayout.setLayoutParams(layoutParams);
        android.view.View view = new android.view.View(this.a);
        this.e = view;
        view.setLayoutParams(new android.view.ViewGroup.LayoutParams(-1, -1));
        if (this.p) {
            this.e.setBackgroundColor(android.graphics.Color.argb(136, 0, 0, 0));
        }
        this.e.setId(10);
        this.e.setOnClickListener(this);
        this.d = new android.widget.RelativeLayout(this.a);
        android.widget.FrameLayout.LayoutParams layoutParams2 = new android.widget.FrameLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 80;
        this.d.setLayoutParams(layoutParams2);
        frameLayout.addView(this.e);
        frameLayout.addView(this.d);
        return frameLayout;
    }

    private android.graphics.drawable.Drawable g() {
        return this.a.getResources().getDrawable(io.dcloud.base.R.drawable.dcloud_ad_slt_as_ios7_other_bt_middle);
    }

    public void h() {
        android.view.View currentFocus;
        android.view.inputmethod.InputMethodManager inputMethodManager = (android.view.inputmethod.InputMethodManager) this.a.getSystemService("input_method");
        if (inputMethodManager.isActive() && (currentFocus = ((android.app.Activity) this.a).getCurrentFocus()) != null) {
            inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
        this.c = f();
        this.e.startAnimation(a());
        this.d.startAnimation(d());
    }

    public void i() {
        if (this.k) {
            c();
            show();
            getWindow().setContentView(this.c);
            this.k = false;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(android.view.View view) {
        if ((view.getId() != 10 || this.j) && view.getId() != 200) {
            if (view.getId() == 10) {
                a(-1);
                io.dcloud.p.g.b bVar = this.b;
                if (bVar != null) {
                    bVar.onItemClick(-1);
                }
                this.l = false;
                return;
            }
            int id = view.getId() - 100;
            a(id);
            io.dcloud.p.g.b bVar2 = this.b;
            if (bVar2 != null) {
                bVar2.onItemClick(id);
            }
            this.l = false;
        }
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        android.view.WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.gravity = 80;
        attributes.width = -1;
        attributes.height = -2;
        android.view.View decorView = getWindow().getDecorView();
        int i = this.n;
        decorView.setPadding(i, 0, i, 0);
        getWindow().setAttributes(attributes);
    }

    public void a(android.content.Context context) {
        this.a = context;
        this.n = 10;
        h();
        getWindow().setGravity(80);
        android.graphics.drawable.ColorDrawable colorDrawable = new android.graphics.drawable.ColorDrawable(0);
        colorDrawable.setAlpha(0);
        getWindow().setBackgroundDrawable(colorDrawable);
        setOnCancelListener(new io.dcloud.p.g.a());
    }

    private int b(int i) {
        return (int) android.util.TypedValue.applyDimension(1, i, this.a.getResources().getDisplayMetrics());
    }

    private android.view.animation.Animation a() {
        android.view.animation.AlphaAnimation alphaAnimation = new android.view.animation.AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(300L);
        return alphaAnimation;
    }

    private android.graphics.drawable.Drawable a(int i, int i2, boolean z) {
        return this.a.getResources().getDrawable(io.dcloud.base.R.drawable.dcloud_ad_slt_as_ios7_other_bt_middle);
    }

    public void a(int i) {
        if (this.k || c(i)) {
            return;
        }
        dismiss();
        this.k = true;
        java.util.List list = this.f;
        if (list != null) {
            list.clear();
        }
    }

    public g(android.content.Context context, int i) {
        super(context, i);
        this.g = "";
        this.h = "";
        this.i = -16777216;
        this.k = true;
        this.l = true;
        this.m = 16.0f;
        this.n = 0;
        this.o = true;
        this.p = true;
        a(context);
    }

    public io.dcloud.p.g a(java.lang.String str) {
        this.h = str;
        return this;
    }

    public io.dcloud.p.g a(boolean z) {
        this.j = z;
        return this;
    }

    public io.dcloud.p.g a(org.json.JSONArray jSONArray) {
        this.f = new java.util.ArrayList();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            try {
                org.json.JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject != null) {
                    this.f.add(new io.dcloud.p.g.c(jSONObject.optString(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_TITLE), jSONObject.optString("style"), jSONObject.optString("color")));
                }
            } catch (org.json.JSONException e) {
                e.printStackTrace();
            }
        }
        return this;
    }

    public io.dcloud.p.g a(io.dcloud.p.g.b bVar) {
        this.b = bVar;
        return this;
    }

    private boolean c(int i) {
        io.dcloud.p.g.b bVar = this.b;
        if (bVar == null) {
            return false;
        }
        boolean zOnDismiss = bVar.onDismiss(i);
        if (!zOnDismiss) {
            this.d.startAnimation(e());
            this.e.startAnimation(b());
        }
        return zOnDismiss;
    }
}
