package io.dcloud.feature.barcode2;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class BarcodeProxyMgr {
    private static io.dcloud.feature.barcode2.BarcodeProxyMgr mInstance;
    private java.util.LinkedHashMap<java.lang.String, io.dcloud.feature.barcode2.BarcodeProxy> mBProxyCaches = new java.util.LinkedHashMap<>();
    private io.dcloud.common.DHInterface.AbsMgr mFeatureMgr;

    public static io.dcloud.feature.barcode2.BarcodeProxyMgr getBarcodeProxyMgr() {
        if (mInstance == null) {
            mInstance = new io.dcloud.feature.barcode2.BarcodeProxyMgr();
        }
        return mInstance;
    }

    public java.lang.Object doForFeature(java.lang.String str, java.lang.Object obj) {
        if (!str.equals("appendToFrameView")) {
            return null;
        }
        java.lang.Object[] objArr = (java.lang.Object[]) obj;
        io.dcloud.common.adapter.ui.AdaFrameView adaFrameView = (io.dcloud.common.adapter.ui.AdaFrameView) objArr[0];
        java.lang.String str2 = (java.lang.String) objArr[1];
        adaFrameView.obtainApp().obtainAppId();
        io.dcloud.feature.barcode2.BarcodeProxy barcodeProxyByUuid = getBarcodeProxyByUuid(str2);
        if (barcodeProxyByUuid == null) {
            return null;
        }
        barcodeProxyByUuid.appendToFrameView(adaFrameView);
        return null;
    }

    public java.lang.String execute(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.String[] strArr) {
        io.dcloud.feature.barcode2.BarcodeProxy barcodeProxy;
        if (!str.equals("getBarcodeById")) {
            java.lang.String str2 = strArr[0];
            if (this.mBProxyCaches.containsKey(str2)) {
                barcodeProxy = this.mBProxyCaches.get(str2);
            } else {
                barcodeProxy = new io.dcloud.feature.barcode2.BarcodeProxy();
                this.mBProxyCaches.put(str2, barcodeProxy);
            }
            barcodeProxy.execute(iWebview, str, strArr);
            return null;
        }
        io.dcloud.common.util.AppRuntime.checkPrivacyComplianceAndPrompt(iWebview.getContext(), "Barcode-" + str);
        io.dcloud.feature.barcode2.BarcodeProxy barcodeProxyById = getBarcodeProxyById(strArr[0]);
        if (barcodeProxyById != null) {
            return io.dcloud.common.util.JSUtil.wrapJsVar(barcodeProxyById.getJsBarcode());
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
    public io.dcloud.common.DHInterface.IWebview findWebviewByUuid(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str) {
        java.lang.Object objProcessEvent;
        io.dcloud.common.DHInterface.AbsMgr absMgr = this.mFeatureMgr;
        if (absMgr == null || (objProcessEvent = absMgr.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.FeatureMgr, 10, new java.lang.Object[]{iWebview, io.dcloud.common.constant.AbsoluteConst.F_UI, "findWebview", new java.lang.String[]{iWebview.obtainApp().obtainAppId(), str}})) == null) {
            return null;
        }
        return (io.dcloud.common.DHInterface.IWebview) objProcessEvent;
    }

    public io.dcloud.feature.barcode2.BarcodeProxy getBarcodeProxyById(java.lang.String str) {
        java.util.Iterator<java.lang.String> it = this.mBProxyCaches.keySet().iterator();
        while (it.hasNext()) {
            io.dcloud.feature.barcode2.BarcodeProxy barcodeProxy = this.mBProxyCaches.get(it.next());
            if (!android.text.TextUtils.isEmpty(barcodeProxy.mId) && barcodeProxy.mId.equals(str)) {
                return barcodeProxy;
            }
        }
        return null;
    }

    public io.dcloud.feature.barcode2.BarcodeProxy getBarcodeProxyByUuid(java.lang.String str) {
        if (this.mBProxyCaches.containsKey(str)) {
            return this.mBProxyCaches.get(str);
        }
        return null;
    }

    public void onDestroy() {
        java.util.Iterator<java.lang.String> it = this.mBProxyCaches.keySet().iterator();
        while (it.hasNext()) {
            io.dcloud.feature.barcode2.BarcodeProxy barcodeProxyRemove = this.mBProxyCaches.remove(it.next());
            if (barcodeProxyRemove != null) {
                barcodeProxyRemove.onDestroy();
            }
        }
        this.mBProxyCaches.clear();
    }

    public void removeBarcodeProxy(java.lang.String str) {
        io.dcloud.feature.barcode2.BarcodeProxy barcodeProxyRemove = this.mBProxyCaches.remove(str);
        if (barcodeProxyRemove != null) {
            barcodeProxyRemove.onDestroy();
        }
    }

    public void setFeatureMgr(io.dcloud.common.DHInterface.AbsMgr absMgr) {
        this.mFeatureMgr = absMgr;
    }
}
