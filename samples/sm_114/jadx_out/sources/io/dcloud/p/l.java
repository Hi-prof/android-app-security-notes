package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public abstract class l {
    private static java.lang.Class a;

    public static void a(android.app.Application application) {
        io.dcloud.common.DHInterface.IWaiter iWaiterB = b();
        if (iWaiterB != null) {
            iWaiterB.doForFeature("onAppCreate", application);
        }
    }

    private static io.dcloud.common.DHInterface.IWaiter b() {
        if (c()) {
            try {
                java.lang.Object objInvoke = a.getMethod("self", null).invoke(null, null);
                if (objInvoke instanceof io.dcloud.common.DHInterface.IWaiter) {
                    return (io.dcloud.common.DHInterface.IWaiter) objInvoke;
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static boolean c() {
        if (a != null) {
            return true;
        }
        try {
            int i = io.dcloud.feature.gg.AolFeatureImplMgr.a;
            a = io.dcloud.feature.gg.AolFeatureImplMgr.class;
        } catch (java.lang.Exception unused) {
        }
        return a != null;
    }

    public static void a(android.content.Context context) {
        io.dcloud.common.DHInterface.IWaiter iWaiterB = b();
        io.dcloud.common.adapter.util.DeviceInfo.sApplicationContext = context;
        if (iWaiterB != null) {
            iWaiterB.doForFeature("onAppAttachBaseContext", context);
        }
    }

    public static java.lang.Object a(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.Object obj) {
        io.dcloud.common.DHInterface.IWaiter iWaiterB;
        if (io.dcloud.feature.internal.sdk.SDK.isUniMPSDK()) {
            return null;
        }
        if ((!io.dcloud.common.util.PdrUtil.checkIntl() || ((io.dcloud.common.util.PdrUtil.checkIntl() && io.dcloud.common.util.language.LanguageUtil.getDeviceDefCountry().equalsIgnoreCase(io.dcloud.p.i0.c().decryptStr("GJ", (byte) 4))) || (io.dcloud.common.util.PdrUtil.checkIntl() && a()))) && (iWaiterB = b()) != null) {
            return iWaiterB.doForFeature(str2, new java.lang.Object[]{context, str, obj});
        }
        return null;
    }

    private static boolean a() {
        io.dcloud.common.DHInterface.IWaiter iWaiterB = b();
        if (iWaiterB != null) {
            return ((java.lang.Boolean) iWaiterB.doForFeature("adc", null)).booleanValue();
        }
        return false;
    }

    public static android.view.View a(android.app.Activity activity, io.dcloud.common.DHInterface.ICallBack iCallBack, java.lang.String str) {
        io.dcloud.common.DHInterface.IWaiter iWaiterB = b();
        if (iWaiterB != null) {
            return (android.view.View) iWaiterB.doForFeature("onCreateAdSplash", new java.lang.Object[]{activity, iCallBack, str});
        }
        return null;
    }
}
