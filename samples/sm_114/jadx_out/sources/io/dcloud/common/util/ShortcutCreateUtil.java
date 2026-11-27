package io.dcloud.common.util;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class ShortcutCreateUtil {
    private static final boolean DEFALT_VALUE = true;
    public static final java.lang.String TAG = "ShortcutCreateUtil";
    private static java.util.List<java.lang.String> hasToastTipPackages = new java.util.ArrayList();
    private static java.util.List<java.lang.String> noToastTipPackages = new java.util.ArrayList();
    private static java.util.List<java.lang.String> disablePackages = new java.util.ArrayList();
    private static java.util.List<java.lang.String> selfDisablePackages = new java.util.ArrayList();
    private static java.util.List<java.lang.String> thirdDisablePackages = new java.util.ArrayList();
    private static java.util.List<java.lang.String> deletePackages = new java.util.ArrayList();
    private static java.util.List<java.lang.String> systemLauncher = new java.util.ArrayList();
    private static java.util.List<java.lang.String> duplicatePackages = new java.util.ArrayList();

    static {
        noToastTipPackages.add("com.miui.home");
        noToastTipPackages.add("com.miui.mihome2");
        noToastTipPackages.add("com.htc.launcher");
        noToastTipPackages.add("com.huawei.launcher2");
        noToastTipPackages.add("com.zte.mifavor.launcher");
        noToastTipPackages.add("com.cyanogenmod.trebuchet");
        noToastTipPackages.add("com.lenovo.launcher");
        noToastTipPackages.add("com.you.launcher");
        noToastTipPackages.add("com.android.launcher3");
        noToastTipPackages.add("com.meizu.flyme.easylauncher");
        noToastTipPackages.add("com.meizu.flyme.launcher");
        noToastTipPackages.add("com.ztemt.launcher");
        noToastTipPackages.add("cn.nubia.launcher");
        noToastTipPackages.add("com.zte.lqsoft.launcher");
        noToastTipPackages.add("com.yulong.android.launcher3");
        noToastTipPackages.add("com.google.android.googlequicksearchbox");
        hasToastTipPackages.add("com.android.launcher");
        hasToastTipPackages.add("com.android.launcher2");
        hasToastTipPackages.add("com.oppo.launcher");
        hasToastTipPackages.add("com.dianxinos.dxhome");
        hasToastTipPackages.add("com.xsg.launcher");
        hasToastTipPackages.add("com.sec.android.app.launcher");
        hasToastTipPackages.add("com.sec.android.app.twlauncher");
        hasToastTipPackages.add("com.qihoo360.launcher");
        hasToastTipPackages.add("com.huawei.android.launcher");
        hasToastTipPackages.add("com.sonyericsson.home");
        thirdDisablePackages.add("com.nd.android.pandahome2");
        thirdDisablePackages.add("com.gau.go.launcherex");
        thirdDisablePackages.add("com.Dean.launcher");
        thirdDisablePackages.add("com.moxiu.launcher");
        thirdDisablePackages.add("com.tencent.launcher");
        thirdDisablePackages.add("com.apusapps.launcher");
        thirdDisablePackages.add("com.baoruan.launcher2");
        thirdDisablePackages.add("com.lx.launcher");
        thirdDisablePackages.add("com.ltp.launcherpad");
        thirdDisablePackages.add("com.zui.launcher");
        thirdDisablePackages.add("com.lewa.launcher5");
        thirdDisablePackages.add("com.mycheering.launcher");
        thirdDisablePackages.add("com.jeejen.family");
        selfDisablePackages.add("com.smartisanos.launcher");
        selfDisablePackages.add("com.zte.mifavor.launcher");
        selfDisablePackages.add("com.bbk.launcher2");
        selfDisablePackages.add("com.oneplus.hydrogen.launcher");
        selfDisablePackages.add("com.sonyericsson.setupwizard");
        selfDisablePackages.add("com.gionee.navil");
        selfDisablePackages.add("com.sec.android.app.easylauncher");
        selfDisablePackages.add("com.nbbsw.launcherdoov");
        selfDisablePackages.add("com.huaqin.launcherEx");
        selfDisablePackages.add("com.ibingo.launcher");
        deletePackages.add("com.sec.android.app.launcher");
        deletePackages.add("com.sec.android.app.twlauncher");
        deletePackages.add("com.huawei.android.launcher");
        deletePackages.add("com.htc.launcher");
        deletePackages.add("com.android.launcher");
        deletePackages.add("com.android.launcher2");
        systemLauncher.add("com.huawei.android.launcher");
        systemLauncher.add("com.huawei.launcher2");
        systemLauncher.add("com.miui.home");
        systemLauncher.add("com.miui.mihome2");
        systemLauncher.add("com.android.launcher2");
        systemLauncher.add("com.sec.android.app.launcher");
        systemLauncher.add("com.sec.android.app.twlauncher");
        systemLauncher.add("com.cyanogenmod.trebuchet");
        systemLauncher.add("com.lenovo.launcher");
        systemLauncher.add("com.zte.mifavor.launcher");
        systemLauncher.add("com.android.launcher");
        systemLauncher.add("com.oppo.launcher");
        systemLauncher.add("com.htc.launcher");
        systemLauncher.add("com.sonyericsson.home");
        systemLauncher.add("com.android.launcher3");
        systemLauncher.add("com.yulong.android.launcher3");
        systemLauncher.add("com.oneplus.hydrogen.launcher");
        systemLauncher.add("com.smartisanos.launcher");
        duplicatePackages.add("com.huawei.launcher2");
        duplicatePackages.add("com.miui.home");
        duplicatePackages.add("com.miui.mihome2");
        duplicatePackages.add("com.lenovo.launcher");
        duplicatePackages.add("com.huawei.android.launcher");
        duplicatePackages.add("com.sec.android.app.twlauncher");
        duplicatePackages.add("com.yulong.android.launcher3");
    }

    public static boolean canCreateShortcut(android.content.Context context) {
        java.lang.String launcherPackageName = io.dcloud.common.util.LauncherUtil.getLauncherPackageName(context);
        if (android.text.TextUtils.isEmpty(launcherPackageName)) {
            return true;
        }
        if ("com.android.launcher3".equalsIgnoreCase(launcherPackageName) && "vivo".equalsIgnoreCase(getBrand())) {
            return false;
        }
        if (launcherPackageName.equals("com.android.launcher3") && android.os.Build.BRAND.equalsIgnoreCase(io.dcloud.common.adapter.util.MobilePhoneModel.SMARTISAN)) {
            return true;
        }
        if (android.os.Build.BRAND.equalsIgnoreCase(io.dcloud.common.adapter.util.MobilePhoneModel.COOLPAD) && launcherPackageName.equals("com.yulong.android.launcher3")) {
            return false;
        }
        return getHasTipPackageList().contains(launcherPackageName) || getNoTipPackageList().contains(launcherPackageName) || !getDisablePackageList().contains(launcherPackageName);
    }

    public static java.lang.String getBrand() {
        return android.os.Build.BRAND;
    }

    private static java.util.List<java.lang.String> getDisablePackageList() {
        if (disablePackages.size() == 0) {
            disablePackages.addAll(selfDisablePackages);
            disablePackages.addAll(thirdDisablePackages);
        }
        return disablePackages;
    }

    private static java.util.List<java.lang.String> getDuplicatePackages() {
        return duplicatePackages;
    }

    private static java.util.List<java.lang.String> getHasTipPackageList() {
        return hasToastTipPackages;
    }

    private static java.util.List<java.lang.String> getNoTipPackageList() {
        return noToastTipPackages;
    }

    private static java.util.List<java.lang.String> getSystemLauncherList() {
        return systemLauncher;
    }

    public static boolean isDeleteLaucher(android.content.Context context) {
        return deletePackages.contains(io.dcloud.common.util.LauncherUtil.getLauncherPackageName(context));
    }

    public static boolean isDisableShort(android.content.Context context) {
        java.lang.String launcherPackageName = io.dcloud.common.util.LauncherUtil.getLauncherPackageName(context);
        if (launcherPackageName.equals("com.bbk.launcher2")) {
            return false;
        }
        if ("com.oppo.launcher".equals(launcherPackageName)) {
            return true;
        }
        if (launcherPackageName.equals("com.android.launcher3") && android.os.Build.BRAND.equalsIgnoreCase(io.dcloud.common.adapter.util.MobilePhoneModel.SMARTISAN)) {
            return false;
        }
        java.lang.String str = android.os.Build.BRAND;
        if (str.equalsIgnoreCase(io.dcloud.common.adapter.util.MobilePhoneModel.MEIZU)) {
            return false;
        }
        if (str.equalsIgnoreCase(io.dcloud.common.adapter.util.MobilePhoneModel.COOLPAD) && launcherPackageName.equals("com.yulong.android.launcher3")) {
            return true;
        }
        if (io.dcloud.common.adapter.util.MobilePhoneModel.isSpecialPhone(context)) {
            return false;
        }
        return getDisablePackageList().contains(launcherPackageName);
    }

    public static boolean isDuplicateLauncher(android.content.Context context) {
        if (io.dcloud.common.util.LauncherUtil.getLauncherPackageName(context).equals("com.android.launcher3") && android.os.Build.BRAND.equalsIgnoreCase(io.dcloud.common.adapter.util.MobilePhoneModel.SMARTISAN)) {
            return true;
        }
        return duplicatePackages.contains(io.dcloud.common.util.LauncherUtil.getLauncherPackageName(context));
    }

    public static boolean isSystemLauncher(android.content.Context context) {
        return getSystemLauncherList().contains(io.dcloud.common.util.LauncherUtil.getLauncherPackageName(context));
    }

    public static boolean needToast(android.content.Context context) {
        return getNoTipPackageList().contains(io.dcloud.common.util.LauncherUtil.getLauncherPackageName(context));
    }
}
