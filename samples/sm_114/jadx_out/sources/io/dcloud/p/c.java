package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public abstract class c {

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class a implements java.lang.Runnable {
        final /* synthetic */ android.content.Context a;
        final /* synthetic */ java.lang.String b;

        a(android.content.Context context, java.lang.String str) {
            this.a = context;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            android.widget.Toast.makeText(this.a, this.b, 0).show();
        }
    }

    public static boolean a(android.content.Context context, java.lang.String str) {
        if (str == null) {
            return false;
        }
        if (str.equals(context.getPackageName())) {
            return true;
        }
        try {
            return context.getPackageManager().getPackageInfo(str, 256) != null;
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void b(android.content.Context context, java.lang.String str) {
        io.dcloud.sdk.core.util.MainHandlerUtil.getMainHandler().post(new io.dcloud.p.c.a(context, str));
    }

    public static void c(android.content.Context context, java.lang.String str) {
        try {
            android.content.Intent intent = new android.content.Intent();
            if (!android.os.Build.BRAND.equalsIgnoreCase("vivo") && a(context, "com.android.browser")) {
                intent.setPackage("com.android.browser");
            }
            intent.setData(android.net.Uri.parse(str));
            intent.setAction("android.intent.action.VIEW");
            intent.setFlags(268435456);
            context.startActivity(intent);
        } catch (java.lang.Exception e) {
            android.util.Log.e("ADUtils", "openBrowser exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static boolean d(android.content.Context context, java.lang.String str) {
        try {
            android.content.Intent uri = android.content.Intent.parseUri(str, 1);
            uri.setSelector(null);
            uri.setComponent(null);
            uri.addCategory("android.intent.category.BROWSABLE");
            java.util.List<android.content.pm.ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(uri, 65536);
            if (listQueryIntentActivities == null || listQueryIntentActivities.isEmpty()) {
                return false;
            }
            uri.setFlags(268435456);
            context.startActivity(uri);
            return true;
        } catch (java.lang.Exception e) {
            android.util.Log.e("ADUtils", "openDeepLink exception: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public static void e(android.content.Context context, java.lang.String str) {
        try {
            android.content.Intent intent = new android.content.Intent();
            int i = io.dcloud.sdk.activity.WebViewActivity.o;
            intent.setClass(context, io.dcloud.sdk.activity.WebViewActivity.class);
            intent.putExtra("url", str);
            intent.setData(android.net.Uri.parse(str));
            intent.setAction("android.intent.action.VIEW");
            intent.setFlags(268435456);
            context.startActivity(intent);
        } catch (java.lang.Exception e) {
            android.util.Log.e("ADUtils", "openUrl exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static android.content.pm.PackageInfo f(android.content.Context context, java.lang.String str) {
        return context.getPackageManager().getPackageArchiveInfo(str, 1);
    }

    public static void a(android.content.Context context) {
        b(context, "已开始下载，完成后自动打开安装界面");
    }
}
