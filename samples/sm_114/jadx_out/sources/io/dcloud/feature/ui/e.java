package io.dcloud.feature.ui;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class e {
    private static java.util.HashMap e;
    io.dcloud.common.DHInterface.AbsMgr a;
    java.util.HashMap b = new java.util.HashMap(1);
    final boolean c = false;
    java.lang.String d;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class a implements io.dcloud.common.adapter.util.MessageHandler.IMessages {
        final /* synthetic */ io.dcloud.feature.ui.a a;
        final /* synthetic */ io.dcloud.feature.ui.c b;

        a(io.dcloud.feature.ui.a aVar, io.dcloud.feature.ui.c cVar) {
            this.a = aVar;
            this.b = cVar;
        }

        @Override // io.dcloud.common.adapter.util.MessageHandler.IMessages
        public void execute(java.lang.Object obj) {
            this.a.g(this.b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class b implements io.dcloud.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ android.view.View a;

        b(android.view.View view) {
            this.a = view;
        }

        @Override // io.dcloud.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(io.dcloud.nineoldandroids.animation.ValueAnimator valueAnimator) {
            if (!(this.a.getLayoutParams() instanceof android.widget.AbsoluteLayout.LayoutParams)) {
                if (this.a.getLayoutParams() instanceof android.widget.FrameLayout.LayoutParams) {
                    io.dcloud.nineoldandroids.view.ViewHelper.setX(this.a, ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue());
                    return;
                }
                return;
            }
            android.widget.AbsoluteLayout.LayoutParams layoutParams = (android.widget.AbsoluteLayout.LayoutParams) this.a.getLayoutParams();
            layoutParams.height = this.a.getHeight();
            layoutParams.width = this.a.getWidth();
            try {
                io.dcloud.nineoldandroids.view.ViewHelper.setX(this.a, ((java.lang.Integer) valueAnimator.getAnimatedValue()).intValue());
            } catch (java.lang.Exception unused) {
                io.dcloud.nineoldandroids.view.ViewHelper.setX(this.a, ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue());
            }
            this.a.requestLayout();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class c implements io.dcloud.nineoldandroids.animation.Animator.AnimatorListener {
        final /* synthetic */ android.view.View a;
        final /* synthetic */ io.dcloud.feature.ui.c b;
        final /* synthetic */ io.dcloud.common.DHInterface.IWebview c;
        final /* synthetic */ java.lang.String d;
        final /* synthetic */ java.lang.String e;

        c(android.view.View view, io.dcloud.feature.ui.c cVar, io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.String str2) {
            this.a = view;
            this.b = cVar;
            this.c = iWebview;
            this.d = str;
            this.e = str2;
        }

        @Override // io.dcloud.nineoldandroids.animation.Animator.AnimatorListener
        public void onAnimationCancel(io.dcloud.nineoldandroids.animation.Animator animator) {
        }

        @Override // io.dcloud.nineoldandroids.animation.Animator.AnimatorListener
        public void onAnimationEnd(io.dcloud.nineoldandroids.animation.Animator animator) {
            io.dcloud.feature.ui.c cVar;
            if (this.a == null || (cVar = this.b) == null || cVar.r() == null) {
                return;
            }
            int iA = io.dcloud.feature.ui.e.this.a(this.a);
            int width = this.a.getWidth();
            if (iA >= io.dcloud.common.adapter.util.PlatformUtil.SCREEN_WIDTH(this.a.getContext()) || iA <= (-width)) {
                this.b.y.popFromViewStack();
            }
            if (this.c != null && !android.text.TextUtils.isEmpty(this.d)) {
                java.lang.String strM = this.b.m();
                if (android.text.TextUtils.isEmpty(strM)) {
                    strM = "";
                }
                io.dcloud.common.util.Deprecated_JSUtil.execCallback(this.c, this.d, io.dcloud.common.util.StringUtil.format("{\"id\":\"%s\",\"target\":%s}", strM, this.b.h()), io.dcloud.common.util.JSUtil.OK, true, true);
            }
            if (android.text.TextUtils.isEmpty(this.e)) {
                return;
            }
            if ("hide".equals(this.e)) {
                io.dcloud.feature.ui.c cVar2 = this.b;
                cVar2.a(cVar2.r(), "hide", io.dcloud.common.util.JSONUtil.createJSONArray("[null,null,null]"));
            } else if (io.dcloud.common.constant.AbsoluteConst.EVENTS_CLOSE.equals(this.e)) {
                io.dcloud.feature.ui.c cVar3 = this.b;
                cVar3.a(cVar3.r(), io.dcloud.common.constant.AbsoluteConst.EVENTS_CLOSE, io.dcloud.common.util.JSONUtil.createJSONArray("[null,null,null]"));
            }
        }

        @Override // io.dcloud.nineoldandroids.animation.Animator.AnimatorListener
        public void onAnimationRepeat(io.dcloud.nineoldandroids.animation.Animator animator) {
        }

        @Override // io.dcloud.nineoldandroids.animation.Animator.AnimatorListener
        public void onAnimationStart(io.dcloud.nineoldandroids.animation.Animator animator) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static /* synthetic */ class d {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[io.dcloud.feature.ui.e.EnumC0047e.values().length];
            a = iArr;
            try {
                iArr[io.dcloud.feature.ui.e.EnumC0047e.findWindowByName.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                a[io.dcloud.feature.ui.e.EnumC0047e.getTopWebview.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                a[io.dcloud.feature.ui.e.EnumC0047e.prefetchURL.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                a[io.dcloud.feature.ui.e.EnumC0047e.prefetchURLs.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                a[io.dcloud.feature.ui.e.EnumC0047e.enumWindow.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            try {
                a[io.dcloud.feature.ui.e.EnumC0047e.getWapLaunchWebview.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
            try {
                a[io.dcloud.feature.ui.e.EnumC0047e.getLaunchWebview.ordinal()] = 7;
            } catch (java.lang.NoSuchFieldError unused7) {
            }
            try {
                a[io.dcloud.feature.ui.e.EnumC0047e.getSecondWebview.ordinal()] = 8;
            } catch (java.lang.NoSuchFieldError unused8) {
            }
            try {
                a[io.dcloud.feature.ui.e.EnumC0047e.currentWebview.ordinal()] = 9;
            } catch (java.lang.NoSuchFieldError unused9) {
            }
            try {
                a[io.dcloud.feature.ui.e.EnumC0047e.createView.ordinal()] = 10;
            } catch (java.lang.NoSuchFieldError unused10) {
            }
            try {
                a[io.dcloud.feature.ui.e.EnumC0047e.setcallbackid.ordinal()] = 11;
            } catch (java.lang.NoSuchFieldError unused11) {
            }
            try {
                a[io.dcloud.feature.ui.e.EnumC0047e.debug.ordinal()] = 12;
            } catch (java.lang.NoSuchFieldError unused12) {
            }
            try {
                a[io.dcloud.feature.ui.e.EnumC0047e.defaultHardwareAccelerated.ordinal()] = 13;
            } catch (java.lang.NoSuchFieldError unused13) {
            }
            try {
                a[io.dcloud.feature.ui.e.EnumC0047e.startAnimation.ordinal()] = 14;
            } catch (java.lang.NoSuchFieldError unused14) {
            }
            try {
                a[io.dcloud.feature.ui.e.EnumC0047e.getDisplayWebview.ordinal()] = 15;
            } catch (java.lang.NoSuchFieldError unused15) {
            }
            try {
                a[io.dcloud.feature.ui.e.EnumC0047e.__callNativeModuleSync.ordinal()] = 16;
            } catch (java.lang.NoSuchFieldError unused16) {
            }
            try {
                a[io.dcloud.feature.ui.e.EnumC0047e.postMessageToUniNView.ordinal()] = 17;
            } catch (java.lang.NoSuchFieldError unused17) {
            }
        }
    }

    /* JADX INFO: renamed from: io.dcloud.feature.ui.e$e, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    private enum EnumC0047e {
        findWindowByName,
        enumWindow,
        getLaunchWebview,
        getWapLaunchWebview,
        currentWebview,
        getTopWebview,
        createView,
        setcallbackid,
        debug,
        setLogs,
        isLogs,
        defaultHardwareAccelerated,
        startAnimation,
        getSecondWebview,
        getDisplayWebview,
        updateAppFrameViews,
        prefetchURL,
        prefetchURLs,
        postMessageToUniNView,
        __callNativeModuleSync
    }

    e(io.dcloud.common.DHInterface.AbsMgr absMgr, java.lang.String str) {
        this.a = null;
        this.a = absMgr;
        this.d = str;
        a();
    }

    public static java.lang.String c(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.startsWith("./")) {
            return str.substring(2);
        }
        if (str.startsWith("../")) {
            return str.substring(3);
        }
        return str.startsWith(".../") ? str.substring(4) : str;
    }

    public synchronized java.lang.String b(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, org.json.JSONArray jSONArray) {
        return a(iWebview, str, jSONArray);
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 24341. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    public java.lang.String a(io.dcloud.common.DHInterface.IWebview r29, java.lang.String r30, org.json.JSONArray r31) {
        /*
            Method dump skipped, instruction units count: 2434
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.dcloud.feature.ui.e.a(io.dcloud.common.DHInterface.IWebview, java.lang.String, org.json.JSONArray):java.lang.String");
    }

    public void b(java.lang.String str, io.dcloud.feature.ui.a aVar, io.dcloud.common.DHInterface.IFrameView iFrameView) {
        java.lang.String str2;
        java.lang.String strValueOf = java.lang.String.valueOf(iFrameView.hashCode());
        io.dcloud.common.DHInterface.IWebview iWebviewObtainWebView = iFrameView.obtainWebView();
        java.lang.String strObtainUrl = iWebviewObtainWebView.obtainUrl();
        io.dcloud.common.adapter.ui.AdaFrameView adaFrameView = (io.dcloud.common.adapter.ui.AdaFrameView) iFrameView;
        org.json.JSONObject jSONObject = adaFrameView.obtainFrameOptions() != null ? adaFrameView.obtainFrameOptions().mJsonViewOption : null;
        java.lang.String strObtainFrameId = iWebviewObtainWebView.obtainFrameId();
        if (io.dcloud.common.util.PdrUtil.isEmpty(strObtainFrameId)) {
            str2 = iFrameView.getFrameType() == 2 ? str : strObtainUrl;
        } else {
            str2 = strObtainFrameId;
        }
        io.dcloud.feature.ui.c cVar = new io.dcloud.feature.ui.c(aVar, strObtainUrl, str2, strValueOf, jSONObject);
        java.lang.String str3 = str2;
        cVar.a(iFrameView.getContext(), aVar, iFrameView.obtainWebView(), strValueOf, jSONObject);
        cVar.F = iFrameView.getFrameType() != 2 || adaFrameView.obtainMainView().getVisibility() == 0;
        cVar.I = true;
        adaFrameView.addFrameViewListener(cVar);
        cVar.a(iFrameView, str3);
        aVar.e(cVar);
        aVar.a(str, cVar, 0);
        io.dcloud.common.adapter.util.MessageHandler.sendMessage(new io.dcloud.feature.ui.e.a(aVar, cVar), null);
    }

    public void b(java.lang.String str) {
        if (io.dcloud.common.util.PdrUtil.isEmpty(str)) {
            java.util.Iterator it = this.b.values().iterator();
            while (it.hasNext()) {
                ((io.dcloud.feature.ui.a) it.next()).a();
            }
            this.b.clear();
            return;
        }
        io.dcloud.feature.ui.a aVar = (io.dcloud.feature.ui.a) this.b.get(str);
        if (aVar != null) {
            io.dcloud.common.adapter.util.Logger.d(io.dcloud.common.adapter.util.Logger.MAIN_TAG, "UIWidgetMgr.dispose pAppid=" + str);
            aVar.a();
        }
        this.b.remove(str);
    }

    private void a(java.lang.String str, io.dcloud.feature.ui.a aVar, io.dcloud.common.DHInterface.IFrameView iFrameView) {
        io.dcloud.common.DHInterface.IWebview iWebviewObtainWebView = iFrameView.obtainWebView();
        java.lang.String strValueOf = java.lang.String.valueOf(iWebviewObtainWebView.obtainFrameId());
        java.lang.String strObtainUrl = iWebviewObtainWebView.obtainUrl();
        java.lang.String strObtainFrameId = iWebviewObtainWebView.obtainFrameId();
        java.lang.String str2 = !io.dcloud.common.util.PdrUtil.isEmpty(strObtainFrameId) ? strObtainFrameId : strObtainUrl;
        io.dcloud.feature.ui.c cVar = new io.dcloud.feature.ui.c(aVar, strObtainUrl, str2, strValueOf, null);
        cVar.a(iFrameView.getContext(), aVar, iWebviewObtainWebView, strValueOf, null);
        cVar.F = false;
        cVar.I = false;
        cVar.a(true);
        iFrameView.addFrameViewListener(cVar);
        cVar.a(iFrameView, str2);
        aVar.e(cVar);
        aVar.a(str, cVar, 0);
    }

    private io.dcloud.feature.ui.c a(io.dcloud.feature.ui.a aVar, io.dcloud.common.DHInterface.IWebview iWebview, org.json.JSONArray jSONArray, io.dcloud.common.DHInterface.IApp iApp, java.lang.String str, boolean z) {
        java.lang.String string;
        io.dcloud.feature.ui.c cVarA = aVar.a(iWebview.obtainFrameView());
        java.lang.String strOptString = jSONArray.optString(0);
        android.util.Log.e("UIWidgetMgr", "new -- JSNWindow=" + strOptString);
        org.json.JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(1);
        java.lang.String strOptString2 = jSONArray.optString(2);
        org.json.JSONObject jSONObjectOptJSONObject2 = jSONArray.optJSONObject(4);
        org.json.JSONArray jSONArrayOptJSONArray = jSONArray.optJSONArray(5);
        if (jSONObjectOptJSONObject == null) {
            jSONObjectOptJSONObject = new org.json.JSONObject("{}");
            string = "";
        } else {
            string = io.dcloud.common.util.JSONUtil.getString(jSONObjectOptJSONObject, "name");
            if (android.text.TextUtils.isEmpty(string)) {
                string = io.dcloud.common.util.JSONUtil.getString(jSONObjectOptJSONObject, "webviewid");
            }
        }
        io.dcloud.feature.ui.c cVarA2 = a(aVar, iWebview, iApp, strOptString, string, str, jSONObjectOptJSONObject, jSONObjectOptJSONObject2, jSONArrayOptJSONArray, z);
        if (cVarA != null) {
            cVarA.b(cVarA2);
        }
        if (strOptString2 != null) {
            cVarA2.b.put(iWebview.getWebviewANID(), strOptString2);
        }
        io.dcloud.common.adapter.util.AnimOptions animOptions = ((io.dcloud.common.adapter.ui.AdaFrameItem) cVarA2.y).getAnimOptions();
        io.dcloud.common.adapter.util.ViewOptions viewOptionsObtainFrameOptions = ((io.dcloud.common.adapter.ui.AdaFrameItem) cVarA2.y).obtainFrameOptions();
        cVarA2.K = viewOptionsObtainFrameOptions.hasBackground();
        animOptions.parseTransition(viewOptionsObtainFrameOptions.transition);
        animOptions.parseTransform(viewOptionsObtainFrameOptions.transform);
        return cVarA2;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private io.dcloud.feature.ui.c a(io.dcloud.feature.ui.a aVar, io.dcloud.common.DHInterface.IWebview iWebview, io.dcloud.common.DHInterface.IApp iApp, java.lang.String str, java.lang.String str2, java.lang.String str3, org.json.JSONObject jSONObject, org.json.JSONObject jSONObject2, org.json.JSONArray jSONArray, boolean z) {
        java.lang.String str4;
        java.lang.String str5;
        io.dcloud.feature.ui.c cVarA;
        java.lang.String str6;
        java.lang.String str7;
        char c2;
        io.dcloud.feature.ui.c cVar;
        java.lang.String strOptString;
        java.lang.String str8;
        java.lang.String strConvert2LocalFullPath;
        java.lang.String str9;
        io.dcloud.common.adapter.util.Logger.e("createNWindow pUrl=" + str);
        boolean zOptBoolean = jSONObject.optBoolean("directPage", false);
        int iOptInt = jSONObject.optInt("winType", 0);
        java.lang.String strConvert2WebviewFullPath = iApp.convert2WebviewFullPath(iOptInt == 0 ? iWebview.obtainFullUrl() : null, str);
        int i = zOptBoolean ? 5 : iOptInt;
        if (z) {
            str5 = strConvert2WebviewFullPath;
            str4 = null;
        } else {
            str4 = strConvert2WebviewFullPath;
            str5 = null;
        }
        iApp.obtainWebviewBaseUrl();
        a(iWebview, iApp, str4);
        java.lang.String strObtainAppId = iApp.obtainAppId();
        boolean zIsEmpty = io.dcloud.common.util.PdrUtil.isEmpty(str);
        if (i == 4) {
            cVarA = aVar.a(4);
        } else {
            cVarA = i == 5 ? aVar.a(5) : null;
        }
        if (cVarA == null) {
            str7 = strObtainAppId;
            c2 = 0;
            cVar = new io.dcloud.feature.ui.c(aVar, str4, str2, str3, jSONObject);
            str6 = str2;
        } else {
            str6 = str2;
            str7 = strObtainAppId;
            c2 = 0;
            cVar = cVarA;
        }
        cVar.x = jSONObject2;
        io.dcloud.common.DHInterface.AbsMgr absMgr = this.a;
        io.dcloud.common.DHInterface.IMgr.MgrType mgrType = io.dcloud.common.DHInterface.IMgr.MgrType.WindowMgr;
        java.lang.Integer numValueOf = java.lang.Integer.valueOf(i);
        java.lang.Object[] objArr = new java.lang.Object[3];
        objArr[c2] = str;
        objArr[1] = jSONObject;
        objArr[2] = str3;
        io.dcloud.common.DHInterface.IFrameView iFrameViewObtainFrameView = iWebview.obtainFrameView();
        java.lang.Object[] objArr2 = new java.lang.Object[5];
        objArr2[c2] = numValueOf;
        objArr2[1] = iApp;
        objArr2[2] = objArr;
        objArr2[3] = iFrameViewObtainFrameView;
        objArr2[4] = cVar;
        io.dcloud.common.DHInterface.IFrameView iFrameView = (io.dcloud.common.DHInterface.IFrameView) absMgr.processEvent(mgrType, 3, objArr2);
        if (z) {
            iFrameView.obtainWebView().setOriginalUrl(str5);
        }
        if (jSONArray != null) {
            cVar.v = jSONArray;
            cVar.w = iWebview;
        }
        cVar.a(iFrameView, str6);
        io.dcloud.common.DHInterface.IWebview iWebviewObtainWebView = cVar.y.obtainWebView();
        if (jSONObject.has("plusrequire")) {
            iWebviewObtainWebView.setWebviewProperty("plusrequire", jSONObject.optString("plusrequire"));
        }
        if (jSONObject.has("replacewebapi")) {
            org.json.JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("replacewebapi");
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.has("geolocation")) {
                iWebviewObtainWebView.setWebviewProperty("geolocation", jSONObjectOptJSONObject.optString("geolocation"));
            }
        } else if (jSONObject.has("geolocation")) {
            iWebviewObtainWebView.setWebviewProperty("geolocation", jSONObject.optString("geolocation"));
        }
        if (jSONObject.has("injection")) {
            iWebviewObtainWebView.setWebviewProperty("injection", java.lang.String.valueOf(jSONObject.optBoolean("injection")));
        }
        if (jSONObject.has(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_OVERRIDE_RESOURCE)) {
            iWebviewObtainWebView.setOverrideResourceRequest(jSONObject.optJSONArray(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_OVERRIDE_RESOURCE));
        }
        if (jSONObject.has(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_OVERRIDEURL)) {
            iWebviewObtainWebView.setOverrideUrlLoadingData(jSONObject.optJSONObject(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_OVERRIDEURL));
        }
        if (io.dcloud.common.util.BaseInfo.isWap2AppAppid(str7) && (iWebviewObtainWebView.obtainFrameView().getFrameType() == 4 || iWebviewObtainWebView.obtainFrameView().getFrameType() == 5)) {
            if (iWebviewObtainWebView.getWebviewProperty("plusrequire").equals("none")) {
                str9 = null;
            } else {
                str9 = null;
                iWebviewObtainWebView.appendPreloadJsFile(iApp.convert2AbsFullPath(null, "_www/__wap2app.js"));
                iWebviewObtainWebView.appendPreloadJsFile(iApp.convert2AbsFullPath(null, "_www/__wap2appconfig.js"));
            }
            iWebviewObtainWebView.setPreloadJsFile(iApp.convert2AbsFullPath(iWebview.obtainFullUrl(), "_www/server_index_append.js"), true);
            java.lang.String strConvert2AbsFullPath = iApp.convert2AbsFullPath(str9, "_www/server_index_append.css");
            if (new java.io.File(strConvert2AbsFullPath).exists()) {
                iWebviewObtainWebView.setCssFile(strConvert2AbsFullPath, str9);
            } else {
                java.lang.String strConvert2AbsFullPath2 = iApp.convert2AbsFullPath(str9, "_www/__wap2app.css");
                if (new java.io.File(strConvert2AbsFullPath2).exists()) {
                    iWebviewObtainWebView.setCssFile(strConvert2AbsFullPath2, str9);
                }
            }
        }
        if (jSONObject.has("appendCss")) {
            strOptString = jSONObject.optString("appendCss");
        } else {
            strOptString = jSONObject.has("preloadcss") ? jSONObject.optString("preloadcss") : null;
        }
        if (android.text.TextUtils.isEmpty(strOptString)) {
            str8 = null;
        } else {
            str8 = null;
            iWebviewObtainWebView.setCssFile(null, strOptString);
        }
        if (jSONObject.has("appendJs")) {
            strConvert2LocalFullPath = iApp.convert2LocalFullPath(str8, jSONObject.optString("appendJs"));
        } else {
            strConvert2LocalFullPath = jSONObject.has("preloadjs") ? iApp.convert2LocalFullPath(str8, jSONObject.optString("preloadjs")) : str8;
        }
        if (!android.text.TextUtils.isEmpty(strConvert2LocalFullPath)) {
            iWebviewObtainWebView.appendPreloadJsFile(strConvert2LocalFullPath);
        }
        if (!zIsEmpty) {
            if (i == 6 && jSONObject.has(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_ADDITIONAL_HTTPHEADERS)) {
                cVar.y.obtainWebView().setLoadURLHeads(str4, io.dcloud.common.util.JSONUtil.toMap(jSONObject.optJSONObject(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_ADDITIONAL_HTTPHEADERS)));
            }
            cVar.y.obtainWebView().loadUrl(str4);
        }
        java.lang.String str10 = str6;
        cVar.a(iWebview.getContext(), aVar, iFrameView.obtainWebView(), str3, jSONObject);
        iFrameView.obtainMainView().setVisibility(4);
        if (io.dcloud.common.adapter.util.DeviceInfo.sDeviceSdkVer >= 11) {
            aVar.b(iFrameView);
        }
        aVar.e(cVar);
        cVar.a(jSONObject, false);
        io.dcloud.common.adapter.util.Logger.d(io.dcloud.common.adapter.util.Logger.VIEW_VISIBLE_TAG, str7 + " createNWindow webview_name=" + str10);
        return cVar;
    }

    private void a(io.dcloud.common.DHInterface.IWebview iWebview, io.dcloud.common.DHInterface.IApp iApp, java.lang.String str) {
        if (!io.dcloud.common.util.BaseInfo.isBase(iWebview.getContext()) || android.text.TextUtils.isEmpty(str)) {
            return;
        }
        java.lang.String strObtainUrl = iWebview.obtainUrl();
        if (str.startsWith(io.dcloud.common.adapter.util.DeviceInfo.HTTP_PROTOCOL) || strObtainUrl.startsWith(io.dcloud.common.adapter.util.DeviceInfo.HTTP_PROTOCOL) || str.startsWith(io.dcloud.common.adapter.util.DeviceInfo.HTTPS_PROTOCOL) || strObtainUrl.startsWith(io.dcloud.common.adapter.util.DeviceInfo.HTTPS_PROTOCOL)) {
            return;
        }
        java.lang.String originalUrl = io.dcloud.common.adapter.ui.webview.WebResUtil.getOriginalUrl(strObtainUrl);
        java.lang.String originalUrl2 = io.dcloud.common.adapter.ui.webview.WebResUtil.getOriginalUrl(str);
        android.util.Log.i(io.dcloud.common.constant.AbsoluteConst.HBUILDER_TAG, io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.AbsoluteConst.OPENLOG, c(io.dcloud.common.adapter.ui.webview.WebResUtil.getHBuilderPrintUrl(iApp.convert2RelPath(originalUrl))), c(io.dcloud.common.adapter.ui.webview.WebResUtil.getHBuilderPrintUrl(iApp.convert2RelPath(originalUrl2)))));
    }

    public static io.dcloud.feature.ui.b a(java.lang.String str) {
        if (io.dcloud.common.util.PdrUtil.isEmpty(str)) {
            return null;
        }
        try {
            java.lang.Object objNewInstance = java.lang.Class.forName((java.lang.String) e.get(str.toLowerCase(java.util.Locale.ENGLISH))).newInstance();
            if (objNewInstance instanceof io.dcloud.feature.ui.b) {
                return (io.dcloud.feature.ui.b) objNewInstance;
            }
            return null;
        } catch (java.lang.ClassNotFoundException e2) {
            e2.printStackTrace();
            return null;
        } catch (java.lang.IllegalAccessException e3) {
            e3.printStackTrace();
            return null;
        } catch (java.lang.InstantiationException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    private void a() {
        e = (java.util.HashMap) this.a.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.FeatureMgr, 4, this.d);
    }

    private io.dcloud.nineoldandroids.animation.ValueAnimator a(android.view.View view, int i, int i2, java.lang.String str, io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str2, io.dcloud.feature.ui.c cVar) {
        io.dcloud.nineoldandroids.animation.ValueAnimator valueAnimatorOfFloat;
        if (view.getLayoutParams() instanceof android.widget.AbsoluteLayout.LayoutParams) {
            valueAnimatorOfFloat = io.dcloud.nineoldandroids.animation.ValueAnimator.ofInt(i, i2);
        } else {
            valueAnimatorOfFloat = view.getLayoutParams() instanceof android.widget.FrameLayout.LayoutParams ? io.dcloud.nineoldandroids.animation.ValueAnimator.ofFloat(i, i2) : null;
        }
        valueAnimatorOfFloat.setDuration(200L);
        valueAnimatorOfFloat.addUpdateListener(new io.dcloud.feature.ui.e.b(view));
        valueAnimatorOfFloat.addListener(new io.dcloud.feature.ui.e.c(view, cVar, iWebview, str2, str));
        return valueAnimatorOfFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(android.view.View view) {
        if (view == null) {
            return 0;
        }
        if (!(view.getLayoutParams() instanceof android.widget.AbsoluteLayout.LayoutParams) && !(view.getLayoutParams() instanceof android.widget.FrameLayout.LayoutParams)) {
            return 0;
        }
        float x = io.dcloud.nineoldandroids.view.ViewHelper.getX(view);
        return (int) x;
    }
}
