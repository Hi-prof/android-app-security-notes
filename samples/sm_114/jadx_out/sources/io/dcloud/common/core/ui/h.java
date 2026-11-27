package io.dcloud.common.core.ui;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
class h implements io.dcloud.common.DHInterface.IJsInterface, io.dcloud.common.DHInterface.IReflectAble {
    static boolean e = false;
    static final java.lang.Class[] f = {java.lang.String.class, java.lang.String.class};
    io.dcloud.common.DHInterface.AbsMgr a;
    io.dcloud.common.DHInterface.IWebview b;
    java.lang.String c;
    io.dcloud.common.adapter.util.MessageHandler.IMessages d = new io.dcloud.common.core.ui.h.a();

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class a implements io.dcloud.common.adapter.util.MessageHandler.IMessages {
        a() {
        }

        @Override // io.dcloud.common.adapter.util.MessageHandler.IMessages
        public void execute(java.lang.Object obj) {
            java.lang.Object[] objArr = (java.lang.Object[]) obj;
            io.dcloud.common.core.ui.h.this.exec(java.lang.String.valueOf(objArr[0]), java.lang.String.valueOf(objArr[1]), (org.json.JSONArray) objArr[2]);
        }
    }

    h(io.dcloud.common.DHInterface.IWebview iWebview) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.b = iWebview;
        this.c = iWebview.obtainFrameView().obtainApp().obtainAppId();
        this.a = this.b.obtainFrameView().obtainWindowMgr();
    }

    @Override // io.dcloud.common.DHInterface.IJsInterface
    public java.lang.String exec(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        return exec(str, str2, io.dcloud.common.util.JSONUtil.createJSONArray(str3));
    }

    @Override // io.dcloud.common.DHInterface.IJsInterface
    public void forceStop(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        this.a.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.WindowMgr, 20, str);
    }

    @Override // io.dcloud.common.DHInterface.IJsInterface
    public java.lang.String prompt(java.lang.String str, java.lang.String str2) {
        if (!e) {
            io.dcloud.common.util.TestUtil.record("JsInterfaceImpl", java.lang.Thread.currentThread());
            e = true;
        }
        if (str2 != null && str2.length() > 3 && str2.substring(0, 4).equals("pdr:")) {
            try {
                org.json.JSONArray jSONArray = new org.json.JSONArray(str2.substring(4));
                java.lang.String string = jSONArray.getString(0);
                java.lang.String string2 = jSONArray.getString(1);
                boolean z = jSONArray.getBoolean(2);
                org.json.JSONArray jSONArrayCreateJSONArray = io.dcloud.common.util.JSONUtil.createJSONArray(str);
                if (!z) {
                    return exec(string, string2, jSONArrayCreateJSONArray);
                }
                io.dcloud.common.adapter.util.MessageHandler.sendMessage(this.d, new java.lang.Object[]{string, string2, jSONArrayCreateJSONArray});
                return null;
            } catch (org.json.JSONException e2) {
                e2.printStackTrace();
            }
        }
        return null;
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
    @Override // io.dcloud.common.DHInterface.IJsInterface
    public java.lang.String exec(java.lang.String str, java.lang.String str2, org.json.JSONArray jSONArray) {
        if (this.b.getContext() == null) {
            return "";
        }
        try {
            java.lang.String lowerCase = str.toLowerCase(java.util.Locale.ENGLISH);
            "io.dcloud.HBuilder".equals(this.b.getContext().getPackageName());
            return java.lang.String.valueOf(this.a.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.FeatureMgr, 1, new java.lang.Object[]{this.b, lowerCase, str2, jSONArray}));
        } catch (java.lang.Exception e2) {
            io.dcloud.common.adapter.util.Logger.w("JsInterfaceImpl.exec pApiFeatureName=" + str + ";pActionName=" + str2 + ";pArgs=" + java.lang.String.valueOf(jSONArray), e2);
            return null;
        }
    }
}
