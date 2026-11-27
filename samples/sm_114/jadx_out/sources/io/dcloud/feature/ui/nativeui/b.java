package io.dcloud.feature.ui.nativeui;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
class b implements android.widget.PopupWindow.OnDismissListener, io.dcloud.common.DHInterface.ISysEventListener, io.dcloud.common.util.EventDispatchManager.ActivityEventDispatchListener {
    private int A;
    private long C;
    private java.lang.String D;
    private java.lang.String F;
    private android.graphics.drawable.AnimationDrawable G;
    private android.graphics.Bitmap H;
    private int I;
    android.widget.LinearLayout L;
    private android.app.Activity a;
    private io.dcloud.feature.ui.nativeui.NativeUIFeatureImpl b;
    private io.dcloud.common.DHInterface.IWebview c;
    private io.dcloud.common.DHInterface.IApp d;
    private java.lang.String e;
    public java.lang.String f;
    private android.widget.PopupWindow h;
    private android.widget.TextView i;
    private android.view.View j;
    private android.widget.ProgressBar k;
    private android.widget.ImageView l;
    private java.lang.String m;
    private java.lang.String n;
    private android.widget.LinearLayout o;
    private java.lang.String p;
    private java.lang.String q;
    private java.lang.String s;
    private java.lang.String t;
    private int u;
    private int v;
    private android.view.View x;
    private int y;
    private int z;
    private java.lang.String g = io.dcloud.common.constant.AbsoluteConst.EVENTS_CLOSE;
    private boolean r = true;
    private int w = -1308622848;
    private boolean B = false;
    private int E = -1;
    private int J = -2;
    private int K = -2;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class a implements android.view.View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
            return io.dcloud.feature.ui.nativeui.b.this.r;
        }
    }

    /* JADX INFO: renamed from: io.dcloud.feature.ui.nativeui.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class ViewOnKeyListenerC0049b implements android.view.View.OnKeyListener {
        ViewOnKeyListenerC0049b() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(android.view.View view, int i, android.view.KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0 && i == 4) {
                if (io.dcloud.common.constant.AbsoluteConst.EVENTS_CLOSE.equalsIgnoreCase(io.dcloud.feature.ui.nativeui.b.this.g)) {
                    io.dcloud.feature.ui.nativeui.b.this.a();
                    io.dcloud.feature.ui.nativeui.b.this.c();
                    return true;
                }
                if ("transmit".equalsIgnoreCase(io.dcloud.feature.ui.nativeui.b.this.g)) {
                    if (!(io.dcloud.feature.ui.nativeui.b.this.a instanceof io.dcloud.PandoraEntryActivity)) {
                        io.dcloud.feature.ui.nativeui.b.this.a.onBackPressed();
                    } else if (io.dcloud.feature.ui.nativeui.b.this.c.canGoBack()) {
                        io.dcloud.feature.ui.nativeui.b.this.c.goBackOrForward(-1);
                    } else {
                        io.dcloud.feature.ui.nativeui.b.this.c.getActivity().onBackPressed();
                    }
                    return false;
                }
                if ("none".equalsIgnoreCase(io.dcloud.feature.ui.nativeui.b.this.g)) {
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class c implements android.view.View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(android.view.View view) {
            io.dcloud.feature.ui.nativeui.b.this.a();
            io.dcloud.feature.ui.nativeui.b.this.c();
        }
    }

    b(io.dcloud.feature.ui.nativeui.NativeUIFeatureImpl nativeUIFeatureImpl, io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, org.json.JSONObject jSONObject, java.lang.String str2, android.app.Activity activity) {
        this.b = nativeUIFeatureImpl;
        this.c = iWebview;
        this.d = iWebview.obtainApp();
        this.e = str2;
        this.a = activity;
        if (activity instanceof io.dcloud.PandoraEntryActivity) {
            this.x = ((io.dcloud.common.adapter.ui.AdaFrameItem) iWebview.obtainFrameView()).obtainMainView();
        } else {
            this.x = ((android.view.ViewGroup) activity.findViewById(android.R.id.content)).getChildAt(0);
        }
        this.y = this.d.getInt(0);
        this.z = this.d.getInt(1);
        a(iWebview, jSONObject);
        b();
        a(this.o);
        a(str);
        d();
    }

    private void e() {
        this.o.setFocusable(true);
        this.o.setFocusableInTouchMode(true);
        this.o.setOnKeyListener(new io.dcloud.feature.ui.nativeui.b.ViewOnKeyListenerC0049b());
    }

    private void f() {
        if (io.dcloud.common.constant.AbsoluteConst.JSON_VALUE_BLOCK.equalsIgnoreCase(this.q)) {
            this.o.setOrientation(1);
            return;
        }
        if (io.dcloud.common.constant.AbsoluteConst.JSON_VALUE_INLINE.equalsIgnoreCase(this.q)) {
            this.o.setOrientation(0);
        } else if ("none".equalsIgnoreCase(this.q)) {
            this.j.setVisibility(8);
            this.k.setVisibility(8);
        }
    }

    private void g() {
        if (android.text.TextUtils.isEmpty(this.F)) {
            return;
        }
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        byte[] bArrA = new byte[0];
        try {
            bArrA = a(this.d.obtainResInStream(this.c.obtainFullUrl(), this.F));
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        android.graphics.BitmapFactory.decodeByteArray(bArrA, 0, bArrA.length, options);
        int i = options.outWidth;
        int i2 = options.outHeight;
        if (i == 0 || i2 == 0) {
            return;
        }
        options.inSampleSize = a(i2);
        options.inJustDecodeBounds = false;
        android.graphics.Bitmap bitmapDecodeByteArray = android.graphics.BitmapFactory.decodeByteArray(bArrA, 0, bArrA.length, options);
        this.H = bitmapDecodeByteArray;
        if (i % i2 != 0) {
            if (bitmapDecodeByteArray != null) {
                this.k.setVisibility(8);
                this.l.setVisibility(0);
                this.l.setImageBitmap(this.H);
                return;
            }
            return;
        }
        if (bitmapDecodeByteArray != null) {
            int width = bitmapDecodeByteArray.getWidth();
            int height = this.H.getHeight();
            int i3 = width / height;
            if (this.C <= 0) {
                this.C = 100L;
            }
            android.graphics.drawable.AnimationDrawable animationDrawable = new android.graphics.drawable.AnimationDrawable();
            for (int i4 = 0; i4 < i3; i4++) {
                animationDrawable.addFrame(new android.graphics.drawable.BitmapDrawable(android.graphics.Bitmap.createBitmap(this.H, i4 * height, 0, height, height)), (int) this.C);
            }
            animationDrawable.setOneShot(false);
            android.view.ViewGroup.LayoutParams layoutParams = this.l.getLayoutParams();
            if (layoutParams != null) {
                int i5 = this.E;
                if (i5 > 0) {
                    height = i5;
                }
                layoutParams.width = height;
                layoutParams.height = height;
                this.l.setLayoutParams(layoutParams);
            }
            this.k.setVisibility(8);
            this.l.setVisibility(0);
            this.l.setBackground(animationDrawable);
            this.G = (android.graphics.drawable.AnimationDrawable) this.l.getBackground();
        }
    }

    private void h() {
        android.graphics.drawable.Drawable drawable;
        if (io.dcloud.common.util.PdrUtil.isEquals(this.t, "snow")) {
            drawable = io.dcloud.common.util.PdrUtil.isEquals(this.s, "black") ? this.a.getResources().getDrawable(io.dcloud.PdrR.DRAWBLE_PROGRESSBAR_BLACK_SNOW) : this.a.getResources().getDrawable(io.dcloud.PdrR.DRAWBLE_PROGRESSBAR_WHITE_SNOW);
        } else {
            drawable = io.dcloud.common.util.PdrUtil.isEquals(this.s, "black") ? this.a.getResources().getDrawable(io.dcloud.PdrR.DRAWBLE_PROGRESSBAR_BLACK_CIRCLE) : this.a.getResources().getDrawable(io.dcloud.PdrR.DRAWBLE_PROGRESSBAR_WHITE_CIRCLE);
        }
        if (this.E > 0) {
            android.widget.ProgressBar progressBar = this.k;
            int i = this.E;
            progressBar.setLayoutParams(new android.widget.LinearLayout.LayoutParams(i, i));
        } else {
            int intrinsicHeight = (int) (((double) drawable.getIntrinsicHeight()) * 0.3d);
            this.k.setLayoutParams(new android.widget.LinearLayout.LayoutParams(intrinsicHeight, intrinsicHeight));
        }
        this.k.setIndeterminateDrawable(drawable);
    }

    private void i() {
        android.widget.LinearLayout linearLayout = this.o;
        int i = this.u;
        int i2 = this.v;
        linearLayout.setPadding(i, i2, i, i2);
        android.graphics.drawable.GradientDrawable gradientDrawable = (android.graphics.drawable.GradientDrawable) this.o.getBackground();
        int i3 = this.A;
        if (i3 > 0) {
            gradientDrawable.setCornerRadius(i3);
        }
        gradientDrawable.setColor(this.w);
        if (this.B) {
            this.o.setOnClickListener(new io.dcloud.feature.ui.nativeui.b.c());
        }
    }

    private void j() {
        this.i.setTextColor(!io.dcloud.common.util.PdrUtil.isEmpty(this.m) ? io.dcloud.common.util.PdrUtil.stringToColor(this.m) : -1);
        if (io.dcloud.common.util.PdrUtil.isEmpty(this.n)) {
            this.i.setGravity(17);
        } else if ("left".equals(this.n)) {
            this.i.setGravity(3);
        } else if ("right".equals(this.n)) {
            this.i.setGravity(5);
        } else {
            this.i.setGravity(17);
        }
        int i = this.I;
        if (i > 0) {
            this.i.setTextSize(0, i);
        }
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        io.dcloud.common.util.Deprecated_JSUtil.execCallback(this.c, this.e, null, io.dcloud.common.util.JSUtil.OK, false, false);
        this.h = null;
        if (!this.r || (!android.text.TextUtils.isEmpty(this.g) && !io.dcloud.common.constant.AbsoluteConst.EVENTS_CLOSE.equalsIgnoreCase(this.g))) {
            this.d.unregisterSysEventListener(this, io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onKeyUp);
            io.dcloud.common.util.EventDispatchManager.getInstance().removeListener(this);
        }
        android.graphics.Bitmap bitmap = this.H;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        this.H.recycle();
        java.lang.System.gc();
    }

    @Override // io.dcloud.common.DHInterface.ISysEventListener
    public boolean onExecute(io.dcloud.common.DHInterface.ISysEventListener.SysEventType sysEventType, java.lang.Object obj) {
        if (sysEventType != io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onKeyUp || ((java.lang.Integer) ((java.lang.Object[]) obj)[0]).intValue() != 4) {
            return false;
        }
        if ("none".equalsIgnoreCase(this.g)) {
            return true;
        }
        if ("transmit".equalsIgnoreCase(this.g)) {
            return false;
        }
        a();
        c();
        return true;
    }

    private void a(io.dcloud.common.DHInterface.IWebview iWebview, org.json.JSONObject jSONObject) {
        if (!io.dcloud.common.util.JSONUtil.isNull(jSONObject, "background")) {
            this.w = io.dcloud.common.util.PdrUtil.stringToColor(io.dcloud.common.util.JSONUtil.getString(jSONObject, "background"));
        }
        java.lang.String string = io.dcloud.common.util.JSONUtil.getString(jSONObject, io.dcloud.common.constant.AbsoluteConst.JSON_KEY_MODAL);
        if (!io.dcloud.common.util.PdrUtil.isEmpty(string)) {
            this.r = !io.dcloud.common.util.PdrUtil.isEquals(io.dcloud.common.constant.AbsoluteConst.FALSE, string);
        }
        float scale = iWebview.getScale();
        this.A = (int) (io.dcloud.common.util.PdrUtil.parseInt(io.dcloud.common.util.JSONUtil.getString(jSONObject, io.dcloud.common.constant.AbsoluteConst.JSON_KEY_ROUND), 10) * scale);
        java.lang.String string2 = io.dcloud.common.util.JSONUtil.getString(jSONObject, io.dcloud.common.constant.AbsoluteConst.JSON_KEY_PADLOCK);
        if (!io.dcloud.common.util.PdrUtil.isEmpty(string2)) {
            this.B = java.lang.Boolean.valueOf(string2).booleanValue() | this.B;
        }
        this.J = io.dcloud.common.util.PdrUtil.convertToScreenInt(io.dcloud.common.util.JSONUtil.getString(jSONObject, "width"), this.y, this.J, scale);
        this.K = io.dcloud.common.util.PdrUtil.convertToScreenInt(io.dcloud.common.util.JSONUtil.getString(jSONObject, "height"), this.z, this.K, scale);
        java.lang.String string3 = io.dcloud.common.util.JSONUtil.getString(jSONObject, "back");
        if (!android.text.TextUtils.isEmpty(string3)) {
            this.g = string3;
        }
        this.s = io.dcloud.common.util.JSONUtil.getString(jSONObject, "style");
        if (!io.dcloud.common.util.JSONUtil.isNull(jSONObject, "color")) {
            this.m = io.dcloud.common.util.JSONUtil.getString(jSONObject, "color");
        }
        this.p = io.dcloud.common.util.JSONUtil.getString(jSONObject, io.dcloud.common.constant.AbsoluteConst.JSON_KEY_PADDIN);
        if (io.dcloud.common.util.JSONUtil.isNull(jSONObject, "padding")) {
            int i = io.dcloud.common.util.PdrUtil.parseInt(this.p, this.y, io.dcloud.common.util.PdrUtil.parseInt("3%", this.y, 0));
            this.v = i;
            this.u = i;
        } else {
            java.lang.String string4 = io.dcloud.common.util.JSONUtil.getString(jSONObject, "padding");
            if (string4.indexOf(37) >= 0) {
                this.u = io.dcloud.common.util.PdrUtil.convertToScreenInt(string4, this.y, this.u, scale);
                this.v = io.dcloud.common.util.PdrUtil.convertToScreenInt(string4, this.z, this.v, scale);
            } else {
                int iConvertToScreenInt = io.dcloud.common.util.PdrUtil.convertToScreenInt(string4, this.y, this.v, scale);
                this.v = iConvertToScreenInt;
                this.u = iConvertToScreenInt;
            }
        }
        if (!io.dcloud.common.util.JSONUtil.isNull(jSONObject, io.dcloud.common.constant.AbsoluteConst.JSON_KEY_TEXTALIGN)) {
            this.n = io.dcloud.common.util.JSONUtil.getString(jSONObject, io.dcloud.common.constant.AbsoluteConst.JSON_KEY_TEXTALIGN);
        }
        org.json.JSONObject jSONObject2 = io.dcloud.common.util.JSONUtil.getJSONObject(jSONObject, "loading");
        if (jSONObject2 != null) {
            this.q = io.dcloud.common.util.JSONUtil.getString(jSONObject2, "display");
            this.C = io.dcloud.common.util.JSONUtil.getLong(jSONObject2, "interval");
            this.D = io.dcloud.common.util.JSONUtil.getString(jSONObject2, io.dcloud.common.constant.AbsoluteConst.JSON_KEY_ICON);
            this.E = io.dcloud.common.util.PdrUtil.convertToScreenInt(io.dcloud.common.util.JSONUtil.getString(jSONObject2, "height"), this.y, -1, scale);
            this.t = io.dcloud.common.util.JSONUtil.getString(jSONObject2, "type");
        }
        if (!android.text.TextUtils.isEmpty(this.D)) {
            this.F = this.D;
        }
        this.I = io.dcloud.common.util.PdrUtil.convertToScreenInt(io.dcloud.common.util.JSONUtil.getString(jSONObject, io.dcloud.common.constant.AbsoluteConst.JSON_KEY_SIZE), this.y, 0, scale);
    }

    private void b() {
        android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) ((android.view.LayoutInflater) this.a.getSystemService("layout_inflater")).inflate(io.dcloud.feature.ui.nativeui.NativeUIR.LAYOUT_DIALOG_LAYOUT_LOADING_DCLOUD, (android.view.ViewGroup) null, false);
        this.L = linearLayout;
        android.widget.LinearLayout linearLayout2 = (android.widget.LinearLayout) linearLayout.findViewById(io.dcloud.feature.ui.nativeui.NativeUIR.DCLOUD_LOADING_LAYOUT_ROOT);
        this.o = linearLayout2;
        android.widget.LinearLayout.LayoutParams layoutParams = (android.widget.LinearLayout.LayoutParams) linearLayout2.getLayoutParams();
        layoutParams.width = this.J;
        layoutParams.height = this.K;
        this.o.setLayoutParams(layoutParams);
    }

    private void d() {
        int i;
        int i2;
        if (android.os.Build.VERSION.SDK_INT < 23 || !this.r) {
            i = -2;
            i2 = -2;
        } else {
            this.r = false;
            i = -1;
            i2 = -1;
        }
        if (!this.r || (!android.text.TextUtils.isEmpty(this.g) && !io.dcloud.common.constant.AbsoluteConst.EVENTS_CLOSE.equalsIgnoreCase(this.g))) {
            if (this.a instanceof io.dcloud.PandoraEntryActivity) {
                this.d.registerSysEventListener(this, io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onKeyUp);
            } else {
                io.dcloud.common.util.EventDispatchManager.getInstance().addListener(this);
            }
        }
        android.widget.PopupWindow popupWindow = new android.widget.PopupWindow(this.L, i, i2, this.r);
        this.h = popupWindow;
        popupWindow.showAtLocation(this.x, 17, 0, 0);
        this.h.setOnDismissListener(this);
        this.h.setBackgroundDrawable(new android.graphics.drawable.BitmapDrawable());
        this.h.setOutsideTouchable(true);
        this.h.setTouchInterceptor(new io.dcloud.feature.ui.nativeui.b.a());
        android.graphics.drawable.AnimationDrawable animationDrawable = this.G;
        if (animationDrawable == null || animationDrawable.isRunning()) {
            return;
        }
        this.G.start();
    }

    public void c() {
        this.b.a(this.f);
        this.d.unregisterSysEventListener(this, io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onKeyUp);
        io.dcloud.common.util.EventDispatchManager.getInstance().removeListener(this);
    }

    void b(java.lang.String str) {
        java.lang.String strTrim = this.i.getText().toString().trim();
        if (!android.text.TextUtils.isEmpty(strTrim)) {
            if (strTrim.length() == str.length()) {
                if (this.i.getLayoutParams() != null) {
                    this.i.setLayoutParams(new android.widget.LinearLayout.LayoutParams(this.i.getWidth(), this.i.getHeight()));
                }
            } else {
                this.i.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-2, -2));
            }
        }
        if (android.text.TextUtils.isEmpty(str)) {
            this.j.setVisibility(8);
            this.i.setVisibility(8);
        } else {
            this.i.setText(str);
        }
    }

    private void a(android.view.View view) {
        this.i = (android.widget.TextView) view.findViewById(io.dcloud.feature.ui.nativeui.NativeUIR.ID_TEXT_LOADING_DCLOUD);
        this.k = (android.widget.ProgressBar) view.findViewById(io.dcloud.feature.ui.nativeui.NativeUIR.ID_PROGRESSBAR_LOADING_DCLOUD);
        this.l = (android.widget.ImageView) view.findViewById(io.dcloud.feature.ui.nativeui.NativeUIR.ID_IMAGE_LOADING_DCLOUD);
        this.j = view.findViewById(io.dcloud.feature.ui.nativeui.NativeUIR.ID_WAITING_SEPARATOR_DCLOUD);
    }

    private void a(java.lang.String str) {
        f();
        j();
        h();
        g();
        b(str);
        e();
        i();
    }

    private int a(int i) {
        int iMin = java.lang.Math.min(this.y, this.z);
        int i2 = this.u;
        int i3 = (iMin - i2) - i2;
        if (i3 <= 0 || i <= i3) {
            return 1;
        }
        return i / i3;
    }

    private byte[] a(java.io.InputStream inputStream) throws java.io.IOException {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int i = inputStream.read(bArr);
            if (i != -1) {
                byteArrayOutputStream.write(bArr, 0, i);
            } else {
                inputStream.close();
                byteArrayOutputStream.close();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    void a() {
        android.widget.PopupWindow popupWindow = this.h;
        if (popupWindow == null || !popupWindow.isShowing()) {
            return;
        }
        try {
            this.h.dismiss();
        } catch (java.lang.Exception unused) {
            onDismiss();
        }
    }
}
