package io.dcloud.common.core.permission;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class PermissionControler {
    public static final int PERMISSION_DENIED = -1;
    public static final int PERMISSION_GRANTED = 0;
    static java.util.HashMap<java.lang.String, java.util.ArrayList<java.lang.String>> mAppPermissions = new java.util.HashMap<>(2);
    static java.util.ArrayList<java.lang.String> mRootAppList = new java.util.ArrayList<>();
    private static java.util.LinkedList<io.dcloud.common.core.permission.a> mRtPnInfos = new java.util.LinkedList<>();

    public static boolean checkPermission(java.lang.String str, java.lang.String str2) {
        return true;
    }

    public static boolean checkSafePermission(java.lang.String str, java.lang.String str2) {
        if ("console".equals(str2)) {
            return true;
        }
        java.util.Locale locale = java.util.Locale.ENGLISH;
        return "events".equals(str2.toLowerCase(locale)) || "uninview".equals(str2.toLowerCase(locale)) || "webview-x5".equals(str2.toLowerCase(locale)) || "uiwebview".equals(str2.toLowerCase(locale)) || "faceid".equals(str2.toLowerCase(locale)) || "canvas".equals(str2.toLowerCase(locale)) || "record".equals(str2.toLowerCase(locale));
    }

    public static void clearCRequestPermissionsCache() {
        mRtPnInfos.clear();
    }

    public static java.lang.String convert5PlusValue(int i) {
        if (i != -1) {
            return i != 0 ? "unknown" : io.dcloud.common.DHInterface.IApp.AUTHORITY_AUTHORIZED;
        }
        return io.dcloud.common.DHInterface.IApp.AUTHORITY_UNDETERMINED;
    }

    public static java.lang.String convertNativePermission(java.lang.String str) {
        return io.dcloud.common.adapter.util.PermissionUtil.convert2SystemPermission(str);
    }

    public static void destroy() {
        mAppPermissions.clear();
        mAppPermissions = null;
    }

    public static java.util.ArrayList<java.lang.String> getPermissionList(java.lang.String str) {
        return mAppPermissions.get(str);
    }

    public static java.lang.String getPermissionsErrorDesp(java.lang.String str) {
        str.getClass();
        if (str.equals("invocation")) {
            return io.dcloud.application.DCLoudApplicationImpl.self().getContext().getString(io.dcloud.base.R.string.dcloud_permissions_njs_tips1);
        }
        return null;
    }

    public static void invokeUTSAndroidPermissionRequest(java.lang.String str, java.lang.String[] strArr) {
        java.util.ArrayList arrayList = new java.util.ArrayList(strArr.length);
        for (java.lang.String str2 : strArr) {
            arrayList.add(io.dcloud.common.adapter.util.PermissionUtil.convert2SystemPermission(str2));
        }
        io.dcloud.common.DHInterface.message.ActionBus.getInstance().sendToBus(io.dcloud.common.DHInterface.message.action.PermissionRequestAction.obtain(str, (java.lang.String[]) arrayList.toArray(new java.lang.String[0])));
    }

    public static void registerPermission(java.lang.String str, java.util.ArrayList<java.lang.String> arrayList) {
        mAppPermissions.remove(str);
        mAppPermissions.put(str, arrayList);
    }

    public static void registerRootPermission(java.lang.String str) {
        mRootAppList.add(str);
    }

    private static void removeRequestPermissionForCode(int i) {
        for (io.dcloud.common.core.permission.a aVar : mRtPnInfos) {
            if (aVar.b == i) {
                mRtPnInfos.remove(aVar);
                return;
            }
        }
    }

    public static void requestPermissions(android.app.Activity activity, java.lang.String[] strArr, int i) {
        if (activity == null || strArr == null || strArr.length <= 0) {
            return;
        }
        if (!(activity instanceof io.src.dcloud.adapter.DCloudBaseActivity)) {
            runRequestPermissions(activity, strArr, i);
            return;
        }
        mRtPnInfos.offer(new io.dcloud.common.core.permission.a(strArr, i));
        if (mRtPnInfos.size() == 1) {
            runRequestPermissions(activity, strArr, i);
        }
    }

    public static void runNextRequestPermission(android.app.Activity activity, int i) {
        io.dcloud.common.core.permission.a first;
        removeRequestPermissionForCode(i);
        if (mRtPnInfos.size() <= 0 || (first = mRtPnInfos.getFirst()) == null) {
            return;
        }
        runRequestPermissions(activity, first.a, first.b);
    }

    private static void runRequestPermissions(android.app.Activity activity, java.lang.String[] strArr, int i) {
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        if (io.dcloud.feature.internal.sdk.SDK.isUniMPSDK()) {
            io.dcloud.common.adapter.util.PlatformUtil.invokeMethod(activity.getClass().getName(), "requestUniMPPermissions", activity, new java.lang.Class[]{strArr.getClass(), java.lang.Integer.TYPE}, new java.lang.Object[]{strArr, java.lang.Integer.valueOf(i)});
            return;
        }
        for (java.lang.String str : strArr) {
            if (!io.dcloud.common.adapter.util.PermissionUtil.checkPermissionDenied(activity, str)) {
                invokeUTSAndroidPermissionRequest(io.dcloud.common.DHInterface.message.action.PermissionRequestAction.TYPE_CONFIRM, strArr);
                break;
            }
        }
        androidx.core.app.ActivityCompat.requestPermissions(activity, strArr, i);
    }

    public static void unregisterRootPermission(java.lang.String str) {
        mRootAppList.remove(str);
    }

    public static java.lang.String checkPermission(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String[] strArr) {
        java.lang.String str = strArr[0];
        iWebview.obtainApp().obtainAppId();
        java.lang.String strObtainAppName = iWebview.obtainApp().obtainAppName();
        android.content.Context context = iWebview.getContext();
        if (!str.equals("SHORTCUT")) {
            return java.lang.String.valueOf(convert5PlusValue(iWebview.obtainApp().checkSelfPermission(convertNativePermission(str), iWebview.obtainApp().obtainAppName())));
        }
        java.lang.String str2 = android.os.Build.BRAND;
        if (str2.equalsIgnoreCase(io.dcloud.common.adapter.util.MobilePhoneModel.MEIZU)) {
            return !io.dcloud.common.util.AppPermissionUtil.isFlymeShortcutallowAllow(context, io.dcloud.common.util.ShortCutUtil.getHeadShortCutIntent(strObtainAppName)) ? io.dcloud.common.DHInterface.IApp.AUTHORITY_DENIED : "notdeny";
        }
        java.lang.String str3 = android.os.Build.MANUFACTURER;
        if (str3.equalsIgnoreCase(io.dcloud.common.adapter.util.MobilePhoneModel.SMARTISAN)) {
            return io.dcloud.common.adapter.util.MobilePhoneModel.isSmartisanLauncherPhone(context) ? io.dcloud.common.DHInterface.IApp.AUTHORITY_DENIED : "notdeny";
        }
        if (io.dcloud.common.util.AppPermissionUtil.getShotCutOpId() == -1) {
            return "unknown";
        }
        io.dcloud.common.util.AppPermissionUtil.getShotCutOpId();
        if (!str2.equalsIgnoreCase(io.dcloud.common.adapter.util.MobilePhoneModel.XIAOMI)) {
            if (str3.equalsIgnoreCase(io.dcloud.common.adapter.util.MobilePhoneModel.HUAWEI)) {
                return !io.dcloud.common.util.AppPermissionUtil.isEmuiShortcutallowAllow() ? io.dcloud.common.DHInterface.IApp.AUTHORITY_DENIED : "notdeny";
            }
            return "unknown";
        }
        int iCheckOp = io.dcloud.common.util.AppPermissionUtil.checkOp(context);
        if (iCheckOp == -1) {
            return "unsupported";
        }
        if (iCheckOp == 0) {
            return io.dcloud.common.DHInterface.IApp.AUTHORITY_AUTHORIZED;
        }
        if (iCheckOp != 1) {
            return (iCheckOp == 3 || iCheckOp == 4) ? io.dcloud.common.DHInterface.IApp.AUTHORITY_UNDETERMINED : "unknown";
        }
        return io.dcloud.common.DHInterface.IApp.AUTHORITY_DENIED;
    }
}
