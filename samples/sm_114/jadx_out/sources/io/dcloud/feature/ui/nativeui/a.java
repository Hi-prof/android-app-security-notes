package io.dcloud.feature.ui.nativeui;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class a extends android.app.AlertDialog implements android.view.View.OnClickListener {
    private android.content.Context a;
    public io.dcloud.feature.ui.nativeui.a.b b;
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

    /* JADX INFO: renamed from: io.dcloud.feature.ui.nativeui.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class DialogInterfaceOnCancelListenerC0048a implements android.content.DialogInterface.OnCancelListener {
        DialogInterfaceOnCancelListenerC0048a() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(android.content.DialogInterface dialogInterface) {
            io.dcloud.feature.ui.nativeui.a.this.a(-1);
            io.dcloud.feature.ui.nativeui.a.b bVar = io.dcloud.feature.ui.nativeui.a.this.b;
            if (bVar != null) {
                bVar.onItemClick(-1);
            }
            io.dcloud.feature.ui.nativeui.a.this.l = false;
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

    public a(android.content.Context context) {
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

    private void d() {
        int intrinsicHeight = h().getIntrinsicHeight();
        boolean zIsEmpty = android.text.TextUtils.isEmpty(this.g);
        boolean z = !zIsEmpty;
        boolean z2 = !android.text.TextUtils.isEmpty(this.h);
        java.lang.String str = this.h;
        if (str != null && android.text.TextUtils.isEmpty(str)) {
            this.h = getContext().getResources().getString(io.dcloud.base.R.string.dcloud_common_cancel);
            z2 = true;
        }
        if (z2) {
            android.widget.TextView textView = new android.widget.TextView(this.a);
            textView.setGravity(17);
            textView.getPaint().setFakeBoldText(true);
            textView.setTextSize(2, this.m);
            textView.setId(100);
            android.graphics.drawable.Drawable drawable = this.o ? this.a.getResources().getDrawable(io.dcloud.feature.ui.nativeui.NativeUIR.SLT_AS_IOS7_CANCEL_BT) : this.a.getResources().getDrawable(io.dcloud.feature.ui.nativeui.NativeUIR.SLT_AS_IOS7_OTHER_BT_MIDDLE);
            if (io.dcloud.common.util.AppRuntime.getAppDarkMode(this.a)) {
                drawable.setColorFilter(this.a.getResources().getColor(io.dcloud.base.R.color.nightBG), android.graphics.PorterDuff.Mode.SRC_IN);
            }
            textView.setBackgroundDrawable(drawable);
            textView.setText(this.h);
            if (io.dcloud.common.util.AppRuntime.getAppDarkMode(this.a)) {
                textView.setTextColor(this.a.getResources().getColor(io.dcloud.base.R.color.nightBlueBtnTitle));
            } else {
                textView.setTextColor(this.i);
            }
            textView.setOnClickListener(this);
            android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            layoutParams.topMargin = b(this.n);
            this.d.addView(textView, layoutParams);
            io.dcloud.feature.ui.nativeui.a.b bVar = this.b;
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
            textView2.setBackgroundDrawable(h());
            textView2.setText(this.g);
            if (io.dcloud.common.util.AppRuntime.getAppDarkMode(this.a)) {
                textView2.setTextColor(this.a.getResources().getColor(io.dcloud.base.R.color.nightLightBtnTitle));
            } else {
                textView2.setTextColor(android.graphics.Color.parseColor("#8C8C8C"));
            }
            textView2.setTextSize(2, this.m);
            android.widget.RelativeLayout.LayoutParams layoutParams4 = new android.widget.RelativeLayout.LayoutParams(-1, -2);
            layoutParams4.topMargin = 0;
            layoutParams4.addRule(6, 300);
            this.d.addView(textView2, layoutParams4);
        }
        java.util.List list = this.f;
        if (list != null && list.size() > 0) {
            int i = 0;
            while (i < this.f.size()) {
                android.widget.TextView textView3 = new android.widget.TextView(this.a);
                textView3.setGravity(17);
                textView3.setId(i + 101);
                textView3.setOnClickListener(this);
                textView3.setBackgroundDrawable(a(this.f.size(), i, z));
                textView3.setText(((io.dcloud.feature.ui.nativeui.a.c) this.f.get(i)).a);
                if (((io.dcloud.feature.ui.nativeui.a.c) this.f.get(i)).b.equals("destructive")) {
                    textView3.setTextColor(android.graphics.Color.parseColor("#E8484A"));
                } else {
                    int iStringToColor = io.dcloud.common.util.PdrUtil.stringToColor(((io.dcloud.feature.ui.nativeui.a.c) this.f.get(i)).c);
                    if (-1 != iStringToColor) {
                        textView3.setTextColor(iStringToColor);
                    } else if (io.dcloud.common.util.AppRuntime.getAppDarkMode(this.a)) {
                        textView3.setTextColor(this.a.getResources().getColor(io.dcloud.base.R.color.nightText));
                    } else {
                        textView3.setTextColor(android.graphics.Color.parseColor("#000000"));
                    }
                }
                textView3.setTextSize(2, this.m);
                android.widget.FrameLayout frameLayout = new android.widget.FrameLayout(this.a);
                frameLayout.addView(textView3, c());
                boolean z3 = (zIsEmpty && i == 0) ? false : true;
                if (io.dcloud.common.util.AppRuntime.getAppDarkMode(this.a) && z3) {
                    android.view.View view = new android.view.View(this.a);
                    view.setBackgroundColor(this.a.getResources().getColor(io.dcloud.base.R.color.nightLine));
                    frameLayout.addView(view, new android.widget.FrameLayout.LayoutParams(-1, b(1)));
                }
                if (i > 0) {
                    android.widget.LinearLayout.LayoutParams layoutParamsC = c();
                    layoutParamsC.topMargin = 0;
                    linearLayout.addView(frameLayout, layoutParamsC);
                } else {
                    linearLayout.addView(frameLayout);
                }
                io.dcloud.feature.ui.nativeui.a.b bVar2 = this.b;
                if (bVar2 != null) {
                    bVar2.initTextItem(i, textView3, ((io.dcloud.feature.ui.nativeui.a.c) this.f.get(i)).a);
                }
                i++;
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

    private android.view.animation.Animation e() {
        android.view.animation.TranslateAnimation translateAnimation = new android.view.animation.TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        translateAnimation.setDuration(300L);
        return translateAnimation;
    }

    private android.view.animation.Animation f() {
        android.view.animation.TranslateAnimation translateAnimation = new android.view.animation.TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f);
        translateAnimation.setDuration(300L);
        translateAnimation.setFillAfter(true);
        return translateAnimation;
    }

    private android.view.View g() {
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

    private android.graphics.drawable.Drawable h() {
        int i = io.dcloud.feature.ui.nativeui.NativeUIR.SLT_AS_IOS7_TITLE;
        if (!this.o) {
            i = io.dcloud.feature.ui.nativeui.NativeUIR.SLT_AS_IOS7_OTHER_BT_MIDDLE;
        }
        android.graphics.drawable.Drawable drawable = this.a.getResources().getDrawable(i);
        if (io.dcloud.common.util.AppRuntime.getAppDarkMode(this.a)) {
            drawable.setColorFilter(this.a.getResources().getColor(io.dcloud.base.R.color.nightBG), android.graphics.PorterDuff.Mode.SRC_IN);
        }
        return drawable;
    }

    public android.widget.LinearLayout.LayoutParams c() {
        return new android.widget.LinearLayout.LayoutParams(-1, -2);
    }

    public void i() {
        android.view.View currentFocus;
        android.view.inputmethod.InputMethodManager inputMethodManager = (android.view.inputmethod.InputMethodManager) this.a.getSystemService("input_method");
        if (inputMethodManager.isActive() && (currentFocus = ((android.app.Activity) this.a).getCurrentFocus()) != null) {
            inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
        this.c = g();
        this.e.startAnimation(a());
        this.d.startAnimation(e());
    }

    public void j() {
        if (this.k) {
            d();
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
                io.dcloud.feature.ui.nativeui.a.b bVar = this.b;
                if (bVar != null) {
                    bVar.onItemClick(-1);
                }
                this.l = false;
                return;
            }
            int id = view.getId() - 100;
            a(id);
            io.dcloud.feature.ui.nativeui.a.b bVar2 = this.b;
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

    private boolean c(int i) {
        io.dcloud.feature.ui.nativeui.a.b bVar = this.b;
        if (bVar == null) {
            return false;
        }
        boolean zOnDismiss = bVar.onDismiss(i);
        if (!zOnDismiss) {
            this.d.startAnimation(f());
            this.e.startAnimation(b());
        }
        return zOnDismiss;
    }

    public void a(android.content.Context context) {
        this.a = context;
        this.n = 10;
        i();
        getWindow().setGravity(80);
        android.graphics.drawable.ColorDrawable colorDrawable = new android.graphics.drawable.ColorDrawable(0);
        colorDrawable.setAlpha(0);
        getWindow().setBackgroundDrawable(colorDrawable);
        setOnCancelListener(new io.dcloud.feature.ui.nativeui.a.DialogInterfaceOnCancelListenerC0048a());
    }

    public io.dcloud.feature.ui.nativeui.a e(int i) {
        this.n = b(i);
        return this;
    }

    private int b(int i) {
        return (int) android.util.TypedValue.applyDimension(1, i, this.a.getResources().getDisplayMetrics());
    }

    public io.dcloud.feature.ui.nativeui.a b(java.lang.String str) {
        this.h = str;
        return this;
    }

    public io.dcloud.feature.ui.nativeui.a b(boolean z) {
        this.o = z;
        return this;
    }

    private android.view.animation.Animation a() {
        android.view.animation.AlphaAnimation alphaAnimation = new android.view.animation.AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(300L);
        return alphaAnimation;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x00a1  */
    private android.graphics.drawable.Drawable a(int i, int i2, boolean z) {
        android.graphics.drawable.Drawable drawable;
        if (!this.o) {
            drawable = this.a.getResources().getDrawable(io.dcloud.feature.ui.nativeui.NativeUIR.SLT_AS_IOS7_OTHER_BT_MIDDLE);
        } else if (i == 1) {
            if (z) {
                drawable = this.a.getResources().getDrawable(io.dcloud.feature.ui.nativeui.NativeUIR.SLT_AS_IOS7_OTHER_BT_BOTTOM);
            } else {
                drawable = this.a.getResources().getDrawable(io.dcloud.feature.ui.nativeui.NativeUIR.SLT_AS_IOS7_OTHER_BT_SINGLE);
            }
        } else if (i == 2) {
            if (i2 != 0) {
                if (i2 != 1) {
                    drawable = null;
                } else {
                    drawable = this.a.getResources().getDrawable(io.dcloud.feature.ui.nativeui.NativeUIR.SLT_AS_IOS7_OTHER_BT_BOTTOM);
                }
            } else if (z) {
                drawable = this.a.getResources().getDrawable(io.dcloud.feature.ui.nativeui.NativeUIR.SLT_AS_IOS7_OTHER_BT_MIDDLE);
            } else {
                drawable = this.a.getResources().getDrawable(io.dcloud.feature.ui.nativeui.NativeUIR.SLT_AS_IOS7_OTHER_BT_TOP);
            }
        } else if (i <= 2) {
            drawable = null;
        } else if (i2 == 0) {
            if (z) {
                drawable = this.a.getResources().getDrawable(io.dcloud.feature.ui.nativeui.NativeUIR.SLT_AS_IOS7_OTHER_BT_MIDDLE);
            } else {
                drawable = this.a.getResources().getDrawable(io.dcloud.feature.ui.nativeui.NativeUIR.SLT_AS_IOS7_OTHER_BT_TOP);
            }
        } else if (i2 == i - 1) {
            drawable = this.a.getResources().getDrawable(io.dcloud.feature.ui.nativeui.NativeUIR.SLT_AS_IOS7_OTHER_BT_BOTTOM);
        } else {
            drawable = this.a.getResources().getDrawable(io.dcloud.feature.ui.nativeui.NativeUIR.SLT_AS_IOS7_OTHER_BT_MIDDLE);
        }
        if (io.dcloud.common.util.AppRuntime.getAppDarkMode(this.a) && drawable != null) {
            drawable.setColorFilter(this.a.getResources().getColor(io.dcloud.base.R.color.nightBG), android.graphics.PorterDuff.Mode.SRC_IN);
        }
        return drawable;
    }

    public a(android.content.Context context, int i) {
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

    public io.dcloud.feature.ui.nativeui.a a(float f) {
        this.m = f;
        return this;
    }

    public io.dcloud.feature.ui.nativeui.a a(java.lang.String str) {
        this.g = str;
        return this;
    }

    public io.dcloud.feature.ui.nativeui.a a(boolean z) {
        this.j = z;
        return this;
    }

    public io.dcloud.feature.ui.nativeui.a a(org.json.JSONArray jSONArray) {
        this.f = new java.util.ArrayList();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            try {
                org.json.JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject != null) {
                    this.f.add(new io.dcloud.feature.ui.nativeui.a.c(jSONObject.optString(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_TITLE), jSONObject.optString("style"), jSONObject.optString("color")));
                }
            } catch (org.json.JSONException e) {
                e.printStackTrace();
            }
        }
        return this;
    }

    public io.dcloud.feature.ui.nativeui.a a(io.dcloud.feature.ui.nativeui.a.b bVar) {
        this.b = bVar;
        return this;
    }

    public io.dcloud.feature.ui.nativeui.a d(int i) {
        this.i = i;
        return this;
    }
}
