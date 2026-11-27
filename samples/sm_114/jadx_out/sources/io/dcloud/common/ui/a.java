package io.dcloud.common.ui;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class a {
    android.content.Context a;
    io.dcloud.common.ui.a.c b;
    private io.dcloud.common.ui.PrivacyManager.b d;
    private boolean e;
    private io.dcloud.common.ui.a.d h;
    private io.dcloud.common.ui.Info.AndroidPrivacyResponse c = null;
    private int f = io.dcloud.PdrR.UNI_CUSTOM_PRIVACY_DIALOG_LAYOUT;
    private boolean g = true;

    /* JADX INFO: renamed from: io.dcloud.common.ui.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class C0038a extends io.dcloud.common.ui.a.b {
        final /* synthetic */ android.text.style.URLSpan c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0038a(io.dcloud.common.ui.a.e eVar, android.text.style.URLSpan uRLSpan) {
            super(eVar);
            this.c = uRLSpan;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(android.view.View view) {
            java.lang.String string;
            try {
                if ("system".equalsIgnoreCase(io.dcloud.common.ui.a.this.c.hrefLoader)) {
                    android.content.Intent intent = new android.content.Intent();
                    intent.setAction("android.intent.action.VIEW");
                    intent.setData(android.net.Uri.parse(this.c.getURL()));
                    io.dcloud.common.ui.a.this.a.startActivity(intent);
                    return;
                }
                android.content.Intent intent2 = new android.content.Intent();
                intent2.setClass(io.dcloud.common.ui.a.this.a, io.dcloud.WebviewActivity.class);
                java.lang.String url = this.c.getURL();
                if (!android.text.TextUtils.isEmpty(url) && !url.startsWith(io.dcloud.common.adapter.util.DeviceInfo.HTTP_PROTOCOL) && !url.startsWith(io.dcloud.common.adapter.util.DeviceInfo.HTTPS_PROTOCOL) && !url.startsWith("HTTP://") && !url.startsWith("HTTPS://")) {
                    if (url.startsWith("./")) {
                        url = url.substring(2);
                    }
                    java.lang.String str = io.dcloud.common.util.BaseInfo.sDefaultBootApp + "/www/" + url;
                    if (io.dcloud.common.ui.PrivacyManager.getInstance().getIsAppAsset()) {
                        string = "file:///android_asset/apps/" + str;
                    } else {
                        java.io.File file = new java.io.File(io.dcloud.common.util.BaseInfo.sCacheFsAppsPath + str);
                        java.lang.StringBuilder sb = new java.lang.StringBuilder(io.dcloud.common.adapter.util.DeviceInfo.FILE_PROTOCOL);
                        sb.append(file.getPath());
                        string = sb.toString();
                    }
                    url = string;
                    intent2.putExtra(io.dcloud.WebviewActivity.isLocalHtmlParam, true);
                    intent2.putExtra(io.dcloud.WebviewActivity.noPermissionAllowParam, true);
                }
                intent2.putExtra("url", url);
                intent2.setData(android.net.Uri.parse(url));
                intent2.setAction("android.intent.action.VIEW");
                intent2.setFlags(268435456);
                intent2.putExtra("ANIM", "POP");
                io.dcloud.common.ui.a.this.a.startActivity(intent2, androidx.core.app.ActivityOptionsCompat.makeCustomAnimation(io.dcloud.common.ui.a.this.a, io.dcloud.base.R.anim.dcloud_pop_in, io.dcloud.base.R.anim.dcloud_pop_in_out).toBundle());
            } catch (java.lang.Exception unused) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public abstract class b extends android.text.style.ClickableSpan {
        io.dcloud.common.ui.a.e a;

        b(io.dcloud.common.ui.a.e eVar) {
            this.a = eVar;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(android.text.TextPaint textPaint) {
            super.updateDrawState(textPaint);
            io.dcloud.common.ui.a.e eVar = this.a;
            if (eVar != null) {
                textPaint.setUnderlineText(eVar.b);
                textPaint.setColor(this.a.a);
            } else {
                textPaint.setUnderlineText(false);
                textPaint.setColor(-16776961);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class c extends android.app.Dialog {
        android.content.Context a;
        private android.widget.TextView b;
        private android.widget.TextView c;
        private android.widget.Button d;
        private android.widget.Button e;
        private android.widget.Button f;
        private android.widget.LinearLayout g;

        /* JADX INFO: renamed from: io.dcloud.common.ui.a$c$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
        class ViewOnClickListenerC0039a implements android.view.View.OnClickListener {
            ViewOnClickListenerC0039a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view) {
                io.dcloud.common.ui.a.c.this.dismiss();
                io.dcloud.common.ui.a.this.h.a(io.dcloud.common.ui.a.this.c.version);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
        class b implements android.view.View.OnClickListener {
            b() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view) {
                io.dcloud.common.ui.a.c.this.dismiss();
                io.dcloud.common.ui.a.this.h.a();
            }
        }

        /* JADX INFO: renamed from: io.dcloud.common.ui.a$c$c, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
        class ViewOnClickListenerC0040c implements android.view.View.OnClickListener {
            ViewOnClickListenerC0040c() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view) {
                io.dcloud.common.ui.a.c.this.dismiss();
                io.dcloud.common.ui.a.this.h.onCancel();
            }
        }

        /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
        class d implements android.view.View.OnClickListener {
            d() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view) {
                io.dcloud.common.ui.a.c.this.dismiss();
                io.dcloud.common.ui.a.this.h.onCancel();
            }
        }

        /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
        class e implements android.content.DialogInterface.OnKeyListener {
            e() {
            }

            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(android.content.DialogInterface dialogInterface, int i, android.view.KeyEvent keyEvent) {
                if (keyEvent.getKeyCode() != 4) {
                    return false;
                }
                io.dcloud.common.ui.a.c.this.dismiss();
                android.content.Context context = io.dcloud.common.ui.a.c.this.a;
                if (context instanceof android.app.Activity) {
                    ((android.app.Activity) context).finish();
                }
                android.os.Process.killProcess(android.os.Process.myPid());
                return true;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
        class f implements android.view.View.OnClickListener {
            f() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view) {
                io.dcloud.common.ui.a.c.this.cancel();
            }
        }

        /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
        class g implements android.view.View.OnClickListener {
            g() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view) {
                io.dcloud.common.ui.a.c.this.cancel();
            }
        }

        /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
        class h implements android.view.View.OnClickListener {
            h() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view) {
                io.dcloud.common.ui.a.c.this.cancel();
            }
        }

        public c(android.content.Context context) {
            super(context);
            requestWindowFeature(1);
            this.a = context;
            c();
            a();
            if (io.dcloud.common.ui.a.f.a(this.g.getTag() != null ? this.g.getTag().toString() : "").a) {
                getWindow().setLayout(-1, -1);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            int color;
            int color2;
            int color3;
            int color4;
            int color5;
            this.d.setOnClickListener(new io.dcloud.common.ui.a.c.ViewOnClickListenerC0039a());
            android.widget.Button button = this.f;
            if (button != null) {
                button.setOnClickListener(new io.dcloud.common.ui.a.c.b());
            }
            if (io.dcloud.common.ui.a.this.g) {
                if (!android.text.TextUtils.isEmpty(io.dcloud.common.ui.a.this.c.second.title)) {
                    this.b.setText(io.dcloud.common.ui.a.this.c.second.title);
                }
                if (!android.text.TextUtils.isEmpty(io.dcloud.common.ui.a.this.c.second.message)) {
                    io.dcloud.common.ui.a.e eVarA = io.dcloud.common.ui.a.e.a(this.c.getTag() != null ? this.c.getTag().toString() : "");
                    this.c.setMovementMethod(android.text.method.LinkMovementMethod.getInstance());
                    this.c.setAutoLinkMask(1);
                    android.widget.TextView textView = this.c;
                    io.dcloud.common.ui.a aVar = io.dcloud.common.ui.a.this;
                    textView.setText(aVar.a(aVar.c.second.message, eVarA));
                    this.c.setGravity(io.dcloud.common.ui.a.this.a("left"));
                }
                if (!android.text.TextUtils.isEmpty(io.dcloud.common.ui.a.this.c.second.buttonAccept)) {
                    this.d.setVisibility(0);
                    this.d.setText(io.dcloud.common.ui.a.this.c.second.buttonAccept);
                }
                if (android.text.TextUtils.isEmpty(io.dcloud.common.ui.a.this.c.second.buttonRefuse)) {
                    this.e.setVisibility(8);
                } else {
                    this.e.setText(io.dcloud.common.ui.a.this.c.second.buttonRefuse);
                    this.e.setVisibility(0);
                    this.e.setOnClickListener(new io.dcloud.common.ui.a.c.ViewOnClickListenerC0040c());
                }
            } else {
                if (!android.text.TextUtils.isEmpty(io.dcloud.common.ui.a.this.c.title)) {
                    this.b.setText(io.dcloud.common.ui.a.this.c.title);
                }
                if (!android.text.TextUtils.isEmpty(io.dcloud.common.ui.a.this.c.message)) {
                    io.dcloud.common.ui.a.e eVarA2 = io.dcloud.common.ui.a.e.a(this.c.getTag() != null ? this.c.getTag().toString() : "");
                    this.c.setMovementMethod(android.text.method.LinkMovementMethod.getInstance());
                    this.c.setAutoLinkMask(1);
                    android.widget.TextView textView2 = this.c;
                    io.dcloud.common.ui.a aVar2 = io.dcloud.common.ui.a.this;
                    textView2.setText(aVar2.a(aVar2.c.message, eVarA2));
                    this.c.setGravity(io.dcloud.common.ui.a.this.a("left"));
                }
                if (!android.text.TextUtils.isEmpty(io.dcloud.common.ui.a.this.c.buttonAccept)) {
                    this.d.setVisibility(0);
                    this.d.setText(io.dcloud.common.ui.a.this.c.buttonAccept);
                }
                if (android.text.TextUtils.isEmpty(io.dcloud.common.ui.a.this.c.buttonRefuse)) {
                    this.e.setVisibility(8);
                } else {
                    this.e.setText(io.dcloud.common.ui.a.this.c.buttonRefuse);
                    this.e.setVisibility(0);
                    this.e.setOnClickListener(new io.dcloud.common.ui.a.c.d());
                }
            }
            if (io.dcloud.common.ui.a.this.c.styles != null) {
                if (!android.text.TextUtils.isEmpty(io.dcloud.common.ui.a.this.c.styles.backgroundColor)) {
                    java.lang.String str = !android.text.TextUtils.isEmpty(io.dcloud.common.ui.a.this.c.styles.borderRadius) ? io.dcloud.common.ui.a.this.c.styles.borderRadius : "10px";
                    try {
                        color5 = android.graphics.Color.parseColor(io.dcloud.common.ui.a.this.c.styles.backgroundColor);
                    } catch (java.lang.Exception unused) {
                        color5 = -1;
                    }
                    android.graphics.drawable.GradientDrawable gradientDrawable = new android.graphics.drawable.GradientDrawable();
                    gradientDrawable.setColor(color5);
                    gradientDrawable.setCornerRadius(io.dcloud.common.ui.a.this.a(this.a, io.dcloud.common.util.PdrUtil.parseInt(str, 1, 10)));
                    this.g.setBackground(gradientDrawable);
                }
                int color6 = -16777216;
                if (io.dcloud.common.ui.a.this.c.styles.title != null) {
                    try {
                        color = android.graphics.Color.parseColor(io.dcloud.common.ui.a.this.c.styles.title.color);
                    } catch (java.lang.Exception unused2) {
                        color = -16777216;
                    }
                    this.b.setTextColor(color);
                }
                if (io.dcloud.common.ui.a.this.c.styles.content != null) {
                    try {
                        color2 = android.graphics.Color.parseColor(io.dcloud.common.ui.a.this.c.styles.content.color);
                    } catch (java.lang.Exception unused3) {
                        color2 = -16777216;
                    }
                    this.c.setTextColor(color2);
                }
                if (io.dcloud.common.ui.a.this.c.styles.buttonAccept != null && !android.text.TextUtils.isEmpty(io.dcloud.common.ui.a.this.c.styles.buttonAccept.color)) {
                    try {
                        color4 = android.graphics.Color.parseColor(io.dcloud.common.ui.a.this.c.styles.buttonAccept.color);
                    } catch (java.lang.Exception unused4) {
                        color4 = -16777216;
                    }
                    this.d.setTextColor(color4);
                }
                if (io.dcloud.common.ui.a.this.c.styles.buttonRefuse != null && !android.text.TextUtils.isEmpty(io.dcloud.common.ui.a.this.c.styles.buttonRefuse.color)) {
                    try {
                        color3 = android.graphics.Color.parseColor(io.dcloud.common.ui.a.this.c.styles.buttonRefuse.color);
                    } catch (java.lang.Exception unused5) {
                        color3 = -16777216;
                    }
                    this.e.setTextColor(color3);
                }
                if (io.dcloud.common.ui.a.this.c.styles.buttonVisitor != null && !android.text.TextUtils.isEmpty(io.dcloud.common.ui.a.this.c.styles.buttonVisitor.color)) {
                    try {
                        color6 = android.graphics.Color.parseColor(io.dcloud.common.ui.a.this.c.styles.buttonVisitor.color);
                    } catch (java.lang.Exception unused6) {
                    }
                    this.f.setTextColor(color6);
                }
            }
            if (io.dcloud.common.ui.a.this.c.backToExit) {
                setOnKeyListener(new io.dcloud.common.ui.a.c.e());
            }
        }

        private void c() {
            android.view.View viewInflate = android.view.LayoutInflater.from(this.a).inflate(io.dcloud.common.ui.a.this.f, (android.view.ViewGroup) null);
            setContentView(viewInflate);
            this.e = (android.widget.Button) viewInflate.findViewById(io.dcloud.base.R.id.btn_custom_privacy_cancel);
            this.d = (android.widget.Button) viewInflate.findViewById(io.dcloud.base.R.id.btn_custom_privacy_sure);
            this.f = (android.widget.Button) viewInflate.findViewById(io.dcloud.base.R.id.btn_custom_privacy_visitor);
            this.c = (android.widget.TextView) viewInflate.findViewById(io.dcloud.base.R.id.tv_privacy_content);
            this.b = (android.widget.TextView) viewInflate.findViewById(io.dcloud.base.R.id.tv_custom_privacy_title);
            this.g = (android.widget.LinearLayout) viewInflate.findViewById(io.dcloud.base.R.id.ll_content_layout);
            getWindow().setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(0));
            d();
            if (this.f != null) {
                if (io.dcloud.common.ui.a.this.c.disagreeMode.visitorEntry) {
                    this.f.setVisibility(0);
                } else {
                    this.f.setVisibility(8);
                }
            }
        }

        public void d() {
            android.view.Display defaultDisplay = ((android.app.Activity) this.a).getWindowManager().getDefaultDisplay();
            if (this.a.getResources().getConfiguration().orientation == 1) {
                this.c.setMaxHeight((int) (((double) defaultDisplay.getHeight()) * 0.6d));
            } else {
                this.c.setMaxHeight((int) (((double) defaultDisplay.getHeight()) * 0.2d));
            }
        }

        private void a() {
            this.e.setOnClickListener(new io.dcloud.common.ui.a.c.f());
            this.d.setOnClickListener(new io.dcloud.common.ui.a.c.g());
            android.widget.Button button = this.f;
            if (button != null) {
                button.setOnClickListener(new io.dcloud.common.ui.a.c.h());
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public interface d {
        void a();

        void a(java.lang.String str);

        void onCancel();
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public static class e {
        public int a;
        public boolean b;

        public static io.dcloud.common.ui.a.e a(java.lang.String str) {
            io.dcloud.common.ui.a.e eVar = new io.dcloud.common.ui.a.e();
            if (android.text.TextUtils.isEmpty(str)) {
                return eVar;
            }
            com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(str);
            eVar.b = object.getBoolean("linkLine").booleanValue();
            eVar.a = android.graphics.Color.parseColor(object.getString("linkColor"));
            return eVar;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public static class f {
        public boolean a = false;

        public static io.dcloud.common.ui.a.f a(java.lang.String str) {
            io.dcloud.common.ui.a.f fVar = new io.dcloud.common.ui.a.f();
            if (!android.text.TextUtils.isEmpty(str)) {
                com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(str);
                if (object.containsKey(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_FULLSCREEN)) {
                    fVar.a = object.getBoolean(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_FULLSCREEN).booleanValue();
                }
            }
            return fVar;
        }
    }

    public a(android.content.Context context) {
        this.a = context;
    }

    public void e() {
        io.dcloud.common.ui.a.c cVar = new io.dcloud.common.ui.a.c(this.a);
        this.b = cVar;
        cVar.setCanceledOnTouchOutside(false);
        this.b.setCancelable(false);
        this.b.b();
        this.b.show();
    }

    public io.dcloud.common.ui.PrivacyManager.b b() {
        return this.d;
    }

    public boolean c() {
        return this.e;
    }

    public boolean d() {
        io.dcloud.common.ui.a.c cVar = this.b;
        return cVar != null && cVar.isShowing();
    }

    public void a(io.dcloud.common.ui.PrivacyManager.b bVar) {
        this.d = bVar;
    }

    public void a(boolean z) {
        this.e = z;
    }

    public void a(int i) {
        if (i != 0) {
            this.f = i;
        }
    }

    public void a(io.dcloud.common.ui.Info.AndroidPrivacyResponse androidPrivacyResponse, boolean z, io.dcloud.common.ui.a.d dVar) {
        this.c = androidPrivacyResponse;
        this.g = z;
        this.h = dVar;
    }

    public java.lang.CharSequence a(java.lang.String str, io.dcloud.common.ui.a.e eVar) {
        android.text.Spanned spannedFromHtml = android.text.Html.fromHtml(str);
        android.text.SpannableStringBuilder spannableStringBuilder = new android.text.SpannableStringBuilder(spannedFromHtml);
        for (android.text.style.URLSpan uRLSpan : (android.text.style.URLSpan[]) spannableStringBuilder.getSpans(0, spannedFromHtml.length(), android.text.style.URLSpan.class)) {
            a(spannableStringBuilder, uRLSpan, eVar);
        }
        return spannableStringBuilder;
    }

    private void a(android.text.SpannableStringBuilder spannableStringBuilder, android.text.style.URLSpan uRLSpan, io.dcloud.common.ui.a.e eVar) {
        spannableStringBuilder.setSpan(new io.dcloud.common.ui.a.C0038a(eVar, uRLSpan), spannableStringBuilder.getSpanStart(uRLSpan), spannableStringBuilder.getSpanEnd(uRLSpan), spannableStringBuilder.getSpanFlags(uRLSpan));
    }

    public void a() {
        io.dcloud.common.ui.a.c cVar = this.b;
        if (cVar != null) {
            cVar.dismiss();
            this.b = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(android.content.Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return 17;
        }
        str.getClass();
        str.hashCode();
        switch (str) {
            case "bottom":
                return 80;
            case "left":
                return 3;
            case "right":
                return 5;
            default:
                return 17;
        }
    }
}
