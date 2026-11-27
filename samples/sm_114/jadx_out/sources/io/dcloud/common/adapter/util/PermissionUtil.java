package io.dcloud.common.adapter.util;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class PermissionUtil implements io.dcloud.common.DHInterface.IReflectAble {
    public static final java.lang.String PMS_CAMERA = "CAMERA";
    public static final java.lang.String PMS_CONTACTS = "CONTACTS";
    public static final java.lang.String PMS_GALLERY = "GALLERY";
    public static final java.lang.String PMS_LOCATION = "LOCATION";
    public static final java.lang.String PMS_NATIVEJS = "NATIVE.JS";
    public static final java.lang.String PMS_PHONE = "PHONE";
    public static final java.lang.String PMS_PUSH = "PUSH";
    public static final java.lang.String PMS_RECORD = "RECORD";
    public static final java.lang.String PMS_SHORTCUT = "SHORTCUT";
    public static final java.lang.String PMS_SMS = "SMS";
    public static final java.lang.String PMS_STORAGE = "STORAGE";
    public static final java.lang.String PMS_STORAGE_IMAGE = "STORAGE_IMAGE";
    private static java.util.List<java.lang.String> alwaysDeniedPer = null;
    public static boolean isCheckPermissionDisabled = false;
    private static int sDefQequestCode;
    private static java.util.HashMap<java.lang.String, io.dcloud.common.adapter.util.PermissionUtil.PermissionData> sPermissionData;
    private static int sRequestCodeCounter;
    private static java.util.HashMap<java.lang.String, java.util.HashMap<java.lang.String, java.lang.Integer>> useRejectedCache = new java.util.HashMap<>();
    private static java.util.HashMap<java.lang.Integer, java.lang.Object[]> sActivityResultCallBacks = new java.util.HashMap<>();
    private static java.util.LinkedList<io.dcloud.common.adapter.util.PermissionUtil.ShowDialogData> sUseStreamAppPermissionDialogs = new java.util.LinkedList<>();
    public static int sUseStreamAppPermissionDialogCount = 0;
    private static java.util.HashMap<java.lang.Integer, java.util.HashMap<io.dcloud.common.adapter.util.PermissionUtil.Request, java.lang.String[]>> sRequestCallBacks = new java.util.HashMap<>();

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static class PermissionData {
        static final int CB_NOSHOW = -1;
        static final int CB_SELECTED = 1;
        static final int CB_SHOW = 0;
        static final int GT_DENIED = -1;
        static final int GT_GRANTED = 1;
        static final int GT_ONCE = 0;
        int checkbox;
        int grantType;
        int messageId;
        java.lang.String name;

        PermissionData(java.lang.String str, int i, int i2, int i3) {
            this.name = str;
            this.messageId = i;
            this.checkbox = i2;
            this.grantType = i3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public static abstract class Request {
        public static final int PERMISSION_ASK = 1;
        public static final int PERMISSION_DENIED = -1;
        public static final int PERMISSION_GRANTED = 0;
        private int mRequestCode = io.dcloud.common.adapter.util.PermissionUtil.sDefQequestCode;
        private boolean isTriggerRequestEvent = false;

        public java.lang.String getAppName() {
            return null;
        }

        public int getRequestCode() {
            return this.mRequestCode;
        }

        public abstract void onDenied(java.lang.String str);

        public abstract void onGranted(java.lang.String str);

        public void setRequestCode(int i) {
            this.mRequestCode = i;
        }

        public void setTriggerRequestEvent(boolean z) {
            this.isTriggerRequestEvent = z;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public static abstract class StreamPermissionRequest extends io.dcloud.common.adapter.util.PermissionUtil.Request {
        io.dcloud.common.DHInterface.IApp mApp;
        public java.lang.Object mTag = null;
        public java.lang.String mAppid = null;
        private java.lang.String mAppName = null;
        private java.lang.String[] mPermission = null;
        private java.lang.String[] mOriginalPermisson = null;

        public StreamPermissionRequest(io.dcloud.common.DHInterface.IApp iApp) {
            setApp(iApp);
        }

        @Override // io.dcloud.common.adapter.util.PermissionUtil.Request
        public java.lang.String getAppName() {
            return this.mAppName;
        }

        java.lang.String[] getStreamRequestPermission() {
            return this.mOriginalPermisson;
        }

        protected java.lang.String[] getSystemRequestPermission() {
            return this.mPermission;
        }

        public void setApp(io.dcloud.common.DHInterface.IApp iApp) {
            this.mApp = iApp;
            this.mAppid = iApp.obtainAppId();
            this.mAppName = iApp.obtainAppName();
        }

        public io.dcloud.common.adapter.util.PermissionUtil.StreamPermissionRequest setRequestPermission(java.lang.String... strArr) {
            this.mOriginalPermisson = strArr;
            this.mPermission = new java.lang.String[strArr.length];
            int i = 0;
            while (true) {
                java.lang.String[] strArr2 = this.mPermission;
                if (i >= strArr2.length) {
                    return this;
                }
                strArr2[i] = io.dcloud.common.adapter.util.PermissionUtil.convert2SystemPermission(strArr[i]);
                i++;
            }
        }
    }

    static {
        java.util.HashMap<java.lang.String, io.dcloud.common.adapter.util.PermissionUtil.PermissionData> map = new java.util.HashMap<>();
        sPermissionData = map;
        map.put(PMS_LOCATION, new io.dcloud.common.adapter.util.PermissionUtil.PermissionData(PMS_LOCATION, io.dcloud.base.R.string.dcloud_permissions_whether_allow, -1, 1));
        sPermissionData.put(PMS_RECORD, new io.dcloud.common.adapter.util.PermissionUtil.PermissionData(PMS_RECORD, io.dcloud.base.R.string.dcloud_permissions_record_whether_allow, -1, 1));
        sPermissionData.put(PMS_CAMERA, new io.dcloud.common.adapter.util.PermissionUtil.PermissionData(PMS_CAMERA, io.dcloud.base.R.string.dcloud_permissions_camera_whether_allow, -1, 1));
        sPermissionData.put(PMS_GALLERY, new io.dcloud.common.adapter.util.PermissionUtil.PermissionData(PMS_GALLERY, io.dcloud.base.R.string.dcloud_permissions_album_whether_allow, -1, 1));
        sPermissionData.put(PMS_PUSH, new io.dcloud.common.adapter.util.PermissionUtil.PermissionData(PMS_PUSH, io.dcloud.base.R.string.dcloud_permissions_informs_whether_allow, -1, 1));
        sPermissionData.put("SHORTCUT", new io.dcloud.common.adapter.util.PermissionUtil.PermissionData("SHORTCUT", io.dcloud.base.R.string.dcloud_permissions_short_cut_close_tips, 1, 0));
        sPermissionData.put(PMS_SMS, new io.dcloud.common.adapter.util.PermissionUtil.PermissionData(PMS_SMS, io.dcloud.base.R.string.dcloud_permissions_sms_whether_allow, -1, 1));
        sPermissionData.put(PMS_PHONE, new io.dcloud.common.adapter.util.PermissionUtil.PermissionData(PMS_PHONE, io.dcloud.base.R.string.dcloud_permissions_phone_call_whether_allow, -1, 1));
        sPermissionData.put(PMS_NATIVEJS, new io.dcloud.common.adapter.util.PermissionUtil.PermissionData(PMS_NATIVEJS, io.dcloud.base.R.string.dcloud_permissions_njs_whether_allow, 1, 0));
        sDefQequestCode = 60505;
        sRequestCodeCounter = 60505;
    }

    private PermissionUtil() {
    }

    private static boolean caseVersion(android.app.Activity activity) {
        if (android.os.Build.VERSION.SDK_INT < 23 || activity == null || activity.getApplicationInfo().targetSdkVersion < 23) {
            return false;
        }
        java.lang.String str = android.os.Build.BRAND;
        return (str.equalsIgnoreCase(io.dcloud.common.adapter.util.MobilePhoneModel.GIONEE) || str.equalsIgnoreCase(io.dcloud.common.adapter.util.MobilePhoneModel.QIHU360)) ? false : true;
    }

    public static boolean checkLocationPermission(android.app.Activity activity) {
        if (isEMUIRom(activity)) {
            return checkPermission_EMUI(activity);
        }
        if (isMiuiRom(activity)) {
            int iIsMiui = isMiui(activity, com.hjq.permissions.Permission.ACCESS_COARSE_LOCATION, (java.lang.String) null);
            return iIsMiui == -100 || iIsMiui == 0;
        }
        if (isFlymeRom(activity)) {
            return checkPermission_Flyme(activity);
        }
        return true;
    }

    public static boolean checkLocationService(android.app.Activity activity) {
        try {
            android.location.LocationManager locationManager = (android.location.LocationManager) activity.getSystemService("location");
            return locationManager.isProviderEnabled("gps") || locationManager.isProviderEnabled("network");
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public static java.lang.String checkPermission(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String[] strArr) {
        if (strArr[0].equals("SHORTCUT")) {
            return io.dcloud.common.core.permission.PermissionControler.checkPermission(iWebview, strArr);
        }
        if (caseVersion(iWebview.getActivity())) {
            return io.dcloud.common.core.permission.PermissionControler.checkPermission(iWebview, strArr);
        }
        return checkSelfPermission(iWebview.getActivity(), convert2SystemPermission(strArr[0]), iWebview.obtainApp().obtainAppName()) == -1 ? io.dcloud.common.DHInterface.IApp.AUTHORITY_DENIED : "notdeny";
    }

    public static boolean checkPermissionDenied(android.app.Activity activity, java.lang.String str) {
        initAlwaysDenied(activity);
        if (alwaysDeniedPer.contains(str)) {
            return isCheckPermissionDisabled || !androidx.core.app.ActivityCompat.shouldShowRequestPermissionRationale(activity, str);
        }
        return false;
    }

    private static boolean checkPermission_EMUI(android.app.Activity activity) {
        try {
            return ((java.lang.Integer) io.dcloud.common.adapter.util.PlatformUtil.invokeMethod("com.huawei.android.app.AppOpsManagerEx", "getMode", null, new java.lang.Class[]{java.lang.Integer.TYPE, java.lang.String.class}, new java.lang.Object[]{8, activity.getPackageName()})).intValue() == 1;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    private static boolean checkPermission_Flyme(android.app.Activity activity) {
        try {
            return ((java.lang.Boolean) io.dcloud.common.adapter.util.PlatformUtil.invokeMethod("meizu.security.FlymePermissionManager", "isFlymePermissionGranted", null, new java.lang.Class[]{java.lang.Integer.TYPE}, new java.lang.Object[]{75})).booleanValue();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    public static boolean checkPermissions(android.content.Context context, java.lang.String[] strArr) {
        if (strArr == null || strArr.length <= 0) {
            return true;
        }
        for (java.lang.String str : strArr) {
            if (checkSelfPermission((android.app.Activity) context, str, "") == -1) {
                return false;
            }
        }
        return true;
    }

    public static int checkSelfPermission(android.app.Activity activity, java.lang.String str, java.lang.String str2) {
        if ("android.permission.INSTALL_SHORTCUT".equals(str)) {
            return 1 != io.dcloud.common.util.AppPermissionUtil.checkPermission(activity, str2) ? 0 : -1;
        }
        return (!caseVersion(activity) || str == null) ? trycatchGetPermission(activity, str, str2) : androidx.core.app.ActivityCompat.checkSelfPermission(activity, str);
    }

    public static int checkStreamAppPermission(android.content.Context context, java.lang.String str, java.lang.String str2) {
        return context.getSharedPreferences("stream_permission", 0).getInt(str + "_" + str2, 1);
    }

    public static void clearPermission(android.content.Context context, java.lang.String str) {
        android.content.SharedPreferences sharedPreferences = context.getSharedPreferences("stream_permission", 0);
        java.util.Iterator<java.lang.String> it = sPermissionData.keySet().iterator();
        android.content.SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        while (it.hasNext()) {
            editorEdit.remove(str + "_" + it.next());
        }
        editorEdit.commit();
    }

    public static void clearUseRejectedCache() {
        useRejectedCache.clear();
    }

    private static synchronized boolean continueShowStreamAppPermissionDialog(io.dcloud.common.adapter.util.PermissionUtil.ShowDialogData showDialogData) {
        if (showDialogData.force) {
            return true;
        }
        if (sUseStreamAppPermissionDialogCount != 0) {
            sUseStreamAppPermissionDialogs.add(showDialogData);
        }
        sUseStreamAppPermissionDialogCount++;
        return sUseStreamAppPermissionDialogs.isEmpty();
    }

    public static java.lang.String convert2StreamPermission(java.lang.String str) {
        if (com.hjq.permissions.Permission.CAMERA.equals(str)) {
            return PMS_CAMERA;
        }
        if (com.hjq.permissions.Permission.RECORD_AUDIO.equals(str)) {
            return PMS_RECORD;
        }
        if (com.hjq.permissions.Permission.ACCESS_COARSE_LOCATION.equals(str)) {
            return PMS_LOCATION;
        }
        if (com.hjq.permissions.Permission.WRITE_CONTACTS.equals(str)) {
            return PMS_CONTACTS;
        }
        if (com.hjq.permissions.Permission.SEND_SMS.equals(str)) {
            return PMS_SMS;
        }
        if (com.hjq.permissions.Permission.CALL_PHONE.equals(str)) {
            return PMS_PHONE;
        }
        if (com.hjq.permissions.Permission.WRITE_EXTERNAL_STORAGE.equals(str)) {
            return PMS_STORAGE;
        }
        if ("android.permission.INSTALL_SHORTCUT".equals(str)) {
            return "SHORTCUT";
        }
        if (PMS_GALLERY.equals(str) || PMS_NATIVEJS.equals(str)) {
            return str;
        }
        PMS_PUSH.equals(str);
        return str;
    }

    public static java.lang.String convert2SystemPermission(java.lang.String str) {
        if (PMS_CAMERA.equalsIgnoreCase(str)) {
            return com.hjq.permissions.Permission.CAMERA;
        }
        if (PMS_RECORD.equalsIgnoreCase(str)) {
            return com.hjq.permissions.Permission.RECORD_AUDIO;
        }
        if (PMS_LOCATION.equalsIgnoreCase(str)) {
            return com.hjq.permissions.Permission.ACCESS_COARSE_LOCATION;
        }
        if (PMS_CONTACTS.equalsIgnoreCase(str)) {
            return com.hjq.permissions.Permission.WRITE_CONTACTS;
        }
        if (PMS_STORAGE.equalsIgnoreCase(str)) {
            return com.hjq.permissions.Permission.WRITE_EXTERNAL_STORAGE;
        }
        if (PMS_STORAGE_IMAGE.equalsIgnoreCase(str)) {
            return android.os.Build.VERSION.SDK_INT < 33 ? com.hjq.permissions.Permission.WRITE_EXTERNAL_STORAGE : com.hjq.permissions.Permission.READ_MEDIA_IMAGES;
        }
        if (PMS_SMS.equalsIgnoreCase(str)) {
            return com.hjq.permissions.Permission.SEND_SMS;
        }
        if (PMS_PHONE.equalsIgnoreCase(str)) {
            return com.hjq.permissions.Permission.CALL_PHONE;
        }
        return "SHORTCUT".equalsIgnoreCase(str) ? "android.permission.INSTALL_SHORTCUT" : str;
    }

    public static java.lang.String convert5PlusValue(int i) {
        return io.dcloud.common.core.permission.PermissionControler.convert5PlusValue(i);
    }

    public static java.lang.String convertNativePermission(java.lang.String str) {
        return io.dcloud.common.core.permission.PermissionControler.convertNativePermission(str);
    }

    private static int getDeivceSuitablePixel(android.app.Activity activity, int i) {
        android.util.DisplayMetrics displayMetrics = new android.util.DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return (int) (i * displayMetrics.density);
    }

    public static int getRequestCode() {
        if (sRequestCodeCounter >= 65535) {
            restRequstCode();
        }
        int i = sRequestCodeCounter;
        sRequestCodeCounter = i + 1;
        return i;
    }

    public static void goPermissionCenter(android.app.Activity activity, java.lang.String str, java.lang.String str2, io.dcloud.common.adapter.util.PermissionUtil.Request request) {
        if (io.dcloud.common.adapter.util.PermissionUtil.SafeCenter.goSafeCenter(activity, str2, request)) {
            return;
        }
        request.onDenied(str2);
    }

    public static void goSafeCenter(android.app.Activity activity) {
        io.dcloud.common.adapter.util.PermissionUtil.SafeCenter.goSafeCenter(activity);
    }

    public static boolean hasDefinedInManifest(android.content.Context context, java.lang.String str) {
        try {
            android.content.pm.PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getApplicationInfo().packageName, 4096);
            if (packageInfo != null) {
                int i = 0;
                while (true) {
                    java.lang.String[] strArr = packageInfo.requestedPermissions;
                    if (i >= strArr.length) {
                        break;
                    }
                    if (str.equals(strArr[i])) {
                        return true;
                    }
                    i++;
                }
            }
            return false;
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void initAlwaysDenied(android.app.Activity activity) {
        if (alwaysDeniedPer == null) {
            java.lang.String bundleData = io.dcloud.common.adapter.util.SP.getBundleData(activity, "ALWAYS_DENIED_PERMISSION", "permissions");
            if (android.text.TextUtils.isEmpty(bundleData)) {
                alwaysDeniedPer = new java.util.ArrayList();
            } else {
                alwaysDeniedPer = new java.util.ArrayList(java.util.Arrays.asList(bundleData.split(",")));
            }
        }
    }

    private static boolean isAndroid(android.app.Activity activity, java.lang.String str, io.dcloud.common.adapter.util.PermissionUtil.Request request) {
        android.content.Intent intent = new android.content.Intent();
        intent.setClassName("com.android.Setting", "com.android.SubSetting");
        intent.putExtra("package", activity.getPackageName());
        int requestCode = getRequestCode();
        activity.startActivityForResult(intent, requestCode);
        saveCallabckData(activity, str, request, requestCode);
        return true;
    }

    public static boolean isEMUIRom(android.app.Activity activity) {
        return android.os.Build.MANUFACTURER.toLowerCase(java.util.Locale.ENGLISH).contains("huawei");
    }

    private static boolean isFlyme(android.app.Activity activity, java.lang.String str, io.dcloud.common.adapter.util.PermissionUtil.Request request) {
        if (!android.os.Build.BRAND.contains("Meizu")) {
            return false;
        }
        android.content.Intent intent = new android.content.Intent();
        intent.setClassName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity");
        intent.putExtra("packageName", activity.getPackageName());
        int requestCode = getRequestCode();
        activity.startActivityForResult(intent, requestCode);
        saveCallabckData(activity, str, request, requestCode);
        return true;
    }

    private static boolean isFlymeRom(android.app.Activity activity) {
        return android.os.Build.BRAND.toLowerCase(java.util.Locale.ENGLISH).contains("meizu");
    }

    public static boolean isMainStreamPermission(java.lang.String str) {
        return PMS_LOCATION.equalsIgnoreCase(str) || "SHORTCUT".equalsIgnoreCase(str) || PMS_RECORD.equalsIgnoreCase(str);
    }

    private static int isMiui(android.app.Activity activity, java.lang.String str, java.lang.String str2) {
        java.lang.Object systemService;
        try {
            if (!isMiuiRom(activity) || (systemService = activity.getSystemService("appops")) == null) {
                return -100;
            }
            int i = systemService.getClass().getField("OP_GPS").getInt(null);
            java.lang.Class<?> cls = systemService.getClass();
            java.lang.Class<?> cls2 = java.lang.Integer.TYPE;
            int iIntValue = ((java.lang.Integer) cls.getMethod("checkOp", cls2, cls2, java.lang.String.class).invoke(systemService, java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(android.os.Binder.getCallingUid()), activity.getPackageName())).intValue();
            if (iIntValue == systemService.getClass().getField("MODE_IGNORED").getInt(null)) {
                return -1;
            }
            return iIntValue == systemService.getClass().getField("MODE_ALLOWED").getInt(null) ? 0 : -100;
        } catch (java.lang.IllegalAccessException e) {
            e.printStackTrace();
            return -100;
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return -100;
        }
    }

    public static void onActivityResult(android.app.Activity activity, int i, int i2, android.content.Intent intent) {
        java.util.HashMap<java.lang.Integer, java.lang.Object[]> map = sActivityResultCallBacks;
        int i3 = i % io.dcloud.feature.gg.dcloud.ADSim.INTISPLSH;
        java.lang.Object[] objArr = map.get(java.lang.Integer.valueOf(i3));
        if (objArr != null) {
            long longExtra = activity.getIntent().getLongExtra(io.dcloud.common.constant.IntentConst.PER_GO_CENTER_TIME, java.lang.System.currentTimeMillis());
            java.lang.String str = (java.lang.String) objArr[0];
            if (java.lang.System.currentTimeMillis() - longExtra > 1000) {
                sActivityResultCallBacks.remove(java.lang.Integer.valueOf(i3));
                java.lang.String strConvert2SystemPermission = convert2SystemPermission(str);
                io.dcloud.common.adapter.util.PermissionUtil.Request request = (io.dcloud.common.adapter.util.PermissionUtil.Request) objArr[1];
                activity.getIntent().removeExtra(io.dcloud.common.constant.IntentConst.PER_GO_CENTER_TIME);
                if (checkSelfPermission(activity, strConvert2SystemPermission, request.getAppName()) == 0) {
                    request.onGranted(str);
                } else {
                    request.onDenied(str);
                }
            }
            io.dcloud.common.core.permission.PermissionControler.invokeUTSAndroidPermissionRequest(io.dcloud.common.DHInterface.message.action.PermissionRequestAction.TYPE_COMPLETE, new java.lang.String[]{str});
        }
    }

    public static void onRequestSysPermissionResume(android.app.Activity activity) {
        int intExtra = activity.getIntent().getIntExtra(io.dcloud.common.constant.IntentConst.PER_GO_CENTER_REQUESTCODE, 0);
        if (intExtra != 0) {
            onActivityResult(activity, intExtra, 0, null);
        }
    }

    public static void onSystemPermissionsResult(android.app.Activity activity, int i, java.lang.String[] strArr, int[] iArr) {
        java.lang.String[] strArr2;
        java.util.HashMap<io.dcloud.common.adapter.util.PermissionUtil.Request, java.lang.String[]> mapRemove = sRequestCallBacks.remove(java.lang.Integer.valueOf(i));
        if (mapRemove != null && mapRemove.size() > 0) {
            io.dcloud.common.adapter.util.PermissionUtil.Request[] requestArr = (io.dcloud.common.adapter.util.PermissionUtil.Request[]) mapRemove.keySet().toArray(new io.dcloud.common.adapter.util.PermissionUtil.Request[0]);
            io.dcloud.common.adapter.util.PermissionUtil.Request request = requestArr.length > 0 ? requestArr[0] : null;
            initAlwaysDenied(activity);
            for (int i2 = 0; i2 < strArr.length; i2++) {
                int i3 = iArr[i2];
                java.lang.String strConvert2StreamPermission = convert2StreamPermission(strArr[i2]);
                if (i3 == -1) {
                    try {
                        if (androidx.core.app.ActivityCompat.shouldShowRequestPermissionRationale(activity, strArr[i2])) {
                            alwaysDeniedPer.add(strArr[i2]);
                        }
                    } catch (java.lang.RuntimeException unused) {
                    }
                    if (request != null) {
                        request.onDenied(strConvert2StreamPermission);
                    }
                } else if (i3 == 0) {
                    if (alwaysDeniedPer.contains(strArr[i2])) {
                        alwaysDeniedPer.remove(strArr[i2]);
                    }
                    if (request != null) {
                        request.onGranted(strConvert2StreamPermission);
                    }
                }
            }
            if (alwaysDeniedPer.size() > 0) {
                io.dcloud.common.adapter.util.SP.setBundleData(activity, "ALWAYS_DENIED_PERMISSION", "permissions", android.text.TextUtils.join(",", (java.lang.String[]) alwaysDeniedPer.toArray(new java.lang.String[0])));
            }
            if (strArr.length == 0 && iArr.length == 0 && request != null && (strArr2 = mapRemove.get(request)) != null) {
                for (java.lang.String str : strArr2) {
                    request.onDenied(convert2StreamPermission(str));
                }
            }
        }
        io.dcloud.common.core.permission.PermissionControler.invokeUTSAndroidPermissionRequest(io.dcloud.common.DHInterface.message.action.PermissionRequestAction.TYPE_COMPLETE, strArr);
    }

    public static void putStreamAppPermission(android.content.Context context, java.lang.String str, java.lang.String str2, int i) {
        context.getSharedPreferences("stream_permission", 0).edit().putInt(str + "_" + str2, i).commit();
    }

    public static void removeStreamAppPermission(android.content.Context context, java.lang.String str, java.lang.String str2) {
        context.getSharedPreferences("stream_permission", 0).edit().remove(str + "_" + str2).commit();
    }

    public static void removeTempPermission(android.content.Context context, java.lang.String str) {
        android.content.SharedPreferences sharedPreferences = context.getSharedPreferences("stream_permission", 0);
        android.content.SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        for (java.lang.String str2 : sPermissionData.keySet()) {
            java.lang.String str3 = str + "_" + str2;
            if (sharedPreferences.contains(str3) && (sharedPreferences.getInt(str3, 1) != 0 || "SHORTCUT".equals(str2) || PMS_NATIVEJS.equals(str2))) {
                editorEdit.remove(str3);
            }
        }
        editorEdit.commit();
    }

    public static void requestPermissions(android.app.Activity activity, java.lang.String[] strArr, int i) {
        io.dcloud.common.core.permission.PermissionControler.invokeUTSAndroidPermissionRequest(io.dcloud.common.DHInterface.message.action.PermissionRequestAction.TYPE_REQUEST, strArr);
        io.dcloud.common.core.permission.PermissionControler.requestPermissions(activity, strArr, i);
    }

    public static void requestSystemPermissions(android.app.Activity activity, java.lang.String[] strArr, int i, io.dcloud.common.adapter.util.PermissionUtil.Request request) {
        requestSystemPermissions(activity, strArr, i, request, true);
    }

    public static void restRequstCode() {
        sRequestCodeCounter = sDefQequestCode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void saveCallabckData(android.app.Activity activity, java.lang.String str, io.dcloud.common.adapter.util.PermissionUtil.Request request, int i) {
        sActivityResultCallBacks.put(java.lang.Integer.valueOf(i), new java.lang.Object[]{str, request});
        activity.getIntent().putExtra(io.dcloud.common.constant.IntentConst.PER_GO_CENTER_REQUESTCODE, i);
        activity.getIntent().putExtra(io.dcloud.common.constant.IntentConst.PER_GO_CENTER_TIME, java.lang.System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void showStreamAppPermissionDialog() {
        int i = sUseStreamAppPermissionDialogCount;
        if (i > 0) {
            sUseStreamAppPermissionDialogCount = i - 1;
        }
        if (!sUseStreamAppPermissionDialogs.isEmpty()) {
            io.dcloud.common.adapter.util.PermissionUtil.ShowDialogData showDialogDataPop = sUseStreamAppPermissionDialogs.pop();
            showDialogDataPop.force = true;
            if (1 != useStreamPermission(showDialogDataPop)) {
                showStreamAppPermissionDialog();
            }
        }
    }

    private static int trycatchGetPermission(android.app.Activity activity, java.lang.String str, java.lang.String str2) {
        android.hardware.Camera cameraOpen;
        int i = -1;
        try {
            try {
                if (com.hjq.permissions.Permission.CAMERA.equals(str)) {
                    int i2 = 0;
                    while (true) {
                        try {
                            if (i2 >= android.hardware.Camera.getNumberOfCameras()) {
                                cameraOpen = null;
                                break;
                            }
                            android.hardware.Camera.CameraInfo cameraInfo = new android.hardware.Camera.CameraInfo();
                            android.hardware.Camera.getCameraInfo(i2, cameraInfo);
                            if (cameraInfo.facing == 1) {
                                cameraOpen = android.hardware.Camera.open(i2);
                                break;
                            }
                            i2++;
                        } catch (java.lang.Exception e) {
                            e.printStackTrace();
                        }
                    }
                    if (cameraOpen == null) {
                        cameraOpen = android.hardware.Camera.open();
                    }
                    if (cameraOpen != null) {
                        android.hardware.Camera.Parameters parameters = cameraOpen.getParameters();
                        if (parameters != null) {
                            parameters.getSupportedVideoSizes();
                        }
                        cameraOpen.release();
                        return 0;
                    }
                } else {
                    try {
                        if (com.hjq.permissions.Permission.RECORD_AUDIO.equals(str)) {
                            try {
                                android.media.MediaRecorder mediaRecorder = new android.media.MediaRecorder();
                                mediaRecorder.reset();
                                mediaRecorder.setAudioSource(0);
                                mediaRecorder.setOutputFile(activity.getExternalFilesDir(android.os.Environment.DIRECTORY_DOWNLOADS) + "/temp.3gp");
                                mediaRecorder.setAudioSamplingRate(96000);
                                mediaRecorder.setOutputFormat(1);
                                mediaRecorder.setAudioEncoder(3);
                                mediaRecorder.prepare();
                                mediaRecorder.start();
                                mediaRecorder.stop();
                                mediaRecorder.release();
                                if (new java.io.File(activity.getExternalFilesDir(android.os.Environment.DIRECTORY_DOWNLOADS) + "/temp.3gp").length() > 0) {
                                    try {
                                        new java.io.File(activity.getExternalFilesDir(android.os.Environment.DIRECTORY_DOWNLOADS) + "/temp.3gp").delete();
                                        return 0;
                                    } catch (java.io.IOException e2) {
                                        e = e2;
                                        i = 0;
                                        if ((e.getMessage() == null || (!e.getMessage().contains("Permission deny") && !e.getMessage().contains("Permission denied"))) && !android.os.Build.BRAND.equalsIgnoreCase(io.dcloud.common.adapter.util.MobilePhoneModel.GIONEE)) {
                                            return 0;
                                        }
                                        return i;
                                    } catch (java.lang.Exception e3) {
                                        e = e3;
                                        i = 0;
                                        java.lang.String message = e.getMessage();
                                        if (message == null) {
                                            return 0;
                                        }
                                        if (!message.contains("start failed") && !message.contains("setAudioSource failed")) {
                                            return 0;
                                        }
                                        return i;
                                    }
                                }
                            } catch (java.io.IOException e4) {
                                e = e4;
                            } catch (java.lang.Exception e5) {
                                e = e5;
                            }
                        } else {
                            if (com.hjq.permissions.Permission.ACCESS_COARSE_LOCATION.equals(str)) {
                                android.location.LocationManager locationManager = (android.location.LocationManager) activity.getSystemService("location");
                                boolean zIsProviderEnabled = locationManager.isProviderEnabled("gps");
                                boolean zIsProviderEnabled2 = locationManager.isProviderEnabled("network");
                                boolean zEquals = android.text.TextUtils.equals("ZTE B880", android.os.Build.MODEL);
                                if (!zIsProviderEnabled && !zIsProviderEnabled2) {
                                    if (zEquals) {
                                        return 0;
                                    }
                                }
                                int iIsMiui = isMiui(activity, str, str2);
                                if (iIsMiui != -100) {
                                    return iIsMiui;
                                }
                                return 0;
                            }
                            if (!com.hjq.permissions.Permission.WRITE_CONTACTS.equals(str) && !com.hjq.permissions.Permission.SEND_SMS.equals(str) && !com.hjq.permissions.Permission.CALL_PHONE.equals(str)) {
                                if (com.hjq.permissions.Permission.WRITE_EXTERNAL_STORAGE.equals(str)) {
                                    try {
                                        java.io.File file = new java.io.File(activity.getExternalFilesDir(android.os.Environment.DIRECTORY_DOWNLOADS) + "/temp.arm");
                                        if (!file.getParentFile().exists()) {
                                            file.getParentFile().mkdirs();
                                        }
                                        if (file.exists()) {
                                            return 0;
                                        }
                                        file.createNewFile();
                                        return 0;
                                    } catch (java.lang.Exception e6) {
                                        e6.printStackTrace();
                                    }
                                } else if ("android.permission.INSTALL_SHORTCUT".equals(str)) {
                                    if (1 != io.dcloud.common.util.AppPermissionUtil.checkPermission(activity, str2)) {
                                        return 0;
                                    }
                                } else if (!PMS_GALLERY.equals(str) && !PMS_NATIVEJS.equals(str)) {
                                    PMS_PUSH.equals(str);
                                    return -1;
                                }
                            }
                        }
                    } catch (java.lang.SecurityException unused) {
                    }
                }
            } catch (java.lang.IllegalArgumentException | java.lang.SecurityException unused2) {
            }
            return -1;
        } catch (java.lang.Throwable unused3) {
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void unregisterWebAppReStartEvent(io.dcloud.common.DHInterface.IApp iApp, io.dcloud.common.DHInterface.ISysEventListener iSysEventListener) {
        iApp.unregisterSysEventListener(iSysEventListener, io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onWebAppReStart);
    }

    public static synchronized void usePermission(android.app.Activity activity, final java.lang.String str, java.lang.String str2, int i, final io.dcloud.common.adapter.util.PermissionUtil.Request request) {
        java.util.HashMap<java.lang.String, java.lang.Integer> map;
        if (!request.isTriggerRequestEvent) {
            io.dcloud.common.core.permission.PermissionControler.invokeUTSAndroidPermissionRequest(io.dcloud.common.DHInterface.message.action.PermissionRequestAction.TYPE_REQUEST, new java.lang.String[]{str2});
        }
        if (str2.equals(PMS_STORAGE) && activity.getApplicationInfo().targetSdkVersion >= 33 && android.os.Build.VERSION.SDK_INT >= 33) {
            request.onGranted(str2);
            io.dcloud.common.core.permission.PermissionControler.invokeUTSAndroidPermissionRequest(io.dcloud.common.DHInterface.message.action.PermissionRequestAction.TYPE_COMPLETE, new java.lang.String[]{str2});
            return;
        }
        java.lang.String strConvert2SystemPermission = convert2SystemPermission(str2);
        if (checkSelfPermission(activity, strConvert2SystemPermission, request.getAppName()) == 0) {
            request.onGranted(str2);
            io.dcloud.common.core.permission.PermissionControler.invokeUTSAndroidPermissionRequest(io.dcloud.common.DHInterface.message.action.PermissionRequestAction.TYPE_COMPLETE, new java.lang.String[]{str2});
            return;
        }
        if (useRejectedCache.containsKey(str) && i > 0 && (map = useRejectedCache.get(str)) != null && map.containsKey(str2) && map.get(str2).intValue() >= i) {
            request.onDenied(str2);
            io.dcloud.common.core.permission.PermissionControler.invokeUTSAndroidPermissionRequest(io.dcloud.common.DHInterface.message.action.PermissionRequestAction.TYPE_COMPLETE, new java.lang.String[]{str2});
        } else {
            io.dcloud.common.adapter.util.PermissionUtil.Request request2 = new io.dcloud.common.adapter.util.PermissionUtil.Request() { // from class: io.dcloud.common.adapter.util.PermissionUtil.1
                @Override // io.dcloud.common.adapter.util.PermissionUtil.Request
                public void onDenied(java.lang.String str3) {
                    try {
                        if (io.dcloud.common.adapter.util.PermissionUtil.useRejectedCache.containsKey(str)) {
                            java.util.HashMap map2 = (java.util.HashMap) io.dcloud.common.adapter.util.PermissionUtil.useRejectedCache.get(str);
                            if (map2 == null) {
                                map2 = new java.util.HashMap();
                            }
                            if (map2.containsKey(str3)) {
                                map2.put(str3, java.lang.Integer.valueOf(((java.lang.Integer) map2.get(str3)).intValue() + 1));
                            } else {
                                map2.put(str3, 1);
                            }
                            io.dcloud.common.adapter.util.PermissionUtil.useRejectedCache.put(str3, map2);
                        } else {
                            java.util.HashMap map3 = new java.util.HashMap();
                            map3.put(str3, 1);
                            io.dcloud.common.adapter.util.PermissionUtil.useRejectedCache.put(str, map3);
                        }
                    } catch (java.lang.Exception unused) {
                    }
                    request.onDenied(str3);
                }

                @Override // io.dcloud.common.adapter.util.PermissionUtil.Request
                public void onGranted(java.lang.String str3) {
                    try {
                        if (io.dcloud.common.adapter.util.PermissionUtil.useRejectedCache.containsKey(str)) {
                            ((java.util.HashMap) io.dcloud.common.adapter.util.PermissionUtil.useRejectedCache.get(str)).remove(str3);
                        }
                    } catch (java.lang.Exception unused) {
                    }
                    request.onGranted(str3);
                }
            };
            request2.isTriggerRequestEvent = true;
            useSystemPermission(activity, strConvert2SystemPermission, request2);
        }
    }

    private static int useStreamPermission(io.dcloud.common.adapter.util.PermissionUtil.ShowDialogData showDialogData) {
        android.app.Activity activity = showDialogData.activity;
        java.lang.String str = showDialogData.appid;
        java.lang.String str2 = showDialogData.streamPerName;
        io.dcloud.common.adapter.util.PermissionUtil.Request request = showDialogData.request;
        int iCheckStreamAppPermission = checkStreamAppPermission(activity, str, str2);
        if (iCheckStreamAppPermission == -1) {
            request.onDenied(str2);
            return iCheckStreamAppPermission;
        }
        if (iCheckStreamAppPermission == 0) {
            request.onGranted(str2);
            return iCheckStreamAppPermission;
        }
        if (iCheckStreamAppPermission != 1) {
            return iCheckStreamAppPermission;
        }
        showStreamAppPermissionDialog(showDialogData);
        return iCheckStreamAppPermission;
    }

    public static boolean useSystemPermission(android.app.Activity activity, java.lang.String str, io.dcloud.common.adapter.util.PermissionUtil.Request request) {
        boolean z = activity.getApplicationInfo().targetSdkVersion >= 23 && str != null && str.contains("android.permission") && android.os.Build.VERSION.SDK_INT >= 23;
        java.lang.String strConvert2StreamPermission = convert2StreamPermission(str);
        if (!request.isTriggerRequestEvent) {
            io.dcloud.common.core.permission.PermissionControler.invokeUTSAndroidPermissionRequest(io.dcloud.common.DHInterface.message.action.PermissionRequestAction.TYPE_REQUEST, new java.lang.String[]{str});
        }
        request.isTriggerRequestEvent = true;
        if (!z) {
            request.onGranted(strConvert2StreamPermission);
            io.dcloud.common.core.permission.PermissionControler.invokeUTSAndroidPermissionRequest(io.dcloud.common.DHInterface.message.action.PermissionRequestAction.TYPE_COMPLETE, new java.lang.String[]{str});
            return true;
        }
        request.setRequestCode(getRequestCode());
        int iCheckSelfPermission = checkSelfPermission(activity, str, request.getAppName());
        if (iCheckSelfPermission != -1) {
            if (iCheckSelfPermission != 0) {
                return false;
            }
            request.onGranted(strConvert2StreamPermission);
            io.dcloud.common.core.permission.PermissionControler.invokeUTSAndroidPermissionRequest(io.dcloud.common.DHInterface.message.action.PermissionRequestAction.TYPE_COMPLETE, new java.lang.String[]{str});
            return true;
        }
        if (checkPermissionDenied(activity, str)) {
            request.onDenied(strConvert2StreamPermission);
            io.dcloud.common.core.permission.PermissionControler.invokeUTSAndroidPermissionRequest(io.dcloud.common.DHInterface.message.action.PermissionRequestAction.TYPE_COMPLETE, new java.lang.String[]{str});
            return true;
        }
        if (str.equals(com.hjq.permissions.Permission.ACCESS_COARSE_LOCATION)) {
            requestSystemPermissions(activity, new java.lang.String[]{str, com.hjq.permissions.Permission.ACCESS_FINE_LOCATION}, request.getRequestCode(), request);
            return false;
        }
        if (str.equalsIgnoreCase(com.hjq.permissions.Permission.READ_MEDIA_IMAGES)) {
            requestSystemPermissions(activity, new java.lang.String[]{str, com.hjq.permissions.Permission.READ_MEDIA_VIDEO, com.hjq.permissions.Permission.WRITE_EXTERNAL_STORAGE}, request.getRequestCode(), request);
            return false;
        }
        requestSystemPermissions(activity, new java.lang.String[]{str}, request.getRequestCode(), request);
        return false;
    }

    public static void useSystemPermissions(android.app.Activity activity, java.lang.String[] strArr, io.dcloud.common.adapter.util.PermissionUtil.Request request) {
        boolean z = activity.getApplicationInfo().targetSdkVersion >= 23 && strArr != null && strArr.length > 0 && android.os.Build.VERSION.SDK_INT >= 23;
        java.util.ArrayList arrayList = new java.util.ArrayList(java.util.Arrays.asList(strArr));
        if (!request.isTriggerRequestEvent) {
            io.dcloud.common.core.permission.PermissionControler.invokeUTSAndroidPermissionRequest(io.dcloud.common.DHInterface.message.action.PermissionRequestAction.TYPE_REQUEST, strArr);
        }
        if (!z) {
            for (int i = 0; i < arrayList.size(); i++) {
                request.onGranted(convert2StreamPermission((java.lang.String) arrayList.get(i)));
            }
            io.dcloud.common.core.permission.PermissionControler.invokeUTSAndroidPermissionRequest(io.dcloud.common.DHInterface.message.action.PermissionRequestAction.TYPE_COMPLETE, strArr);
            return;
        }
        request.setRequestCode(getRequestCode());
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        boolean z2 = alwaysDeniedPer == null;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            java.lang.String strConvert2SystemPermission = convert2SystemPermission((java.lang.String) arrayList.get(i2));
            if (checkSelfPermission(activity, strConvert2SystemPermission, request.getAppName()) == 0) {
                arrayList2.add(strConvert2SystemPermission);
                request.onGranted(convert2StreamPermission(strConvert2SystemPermission));
            } else if (checkPermissionDenied(activity, strConvert2SystemPermission) && !z2) {
                arrayList2.add(strConvert2SystemPermission);
                request.onDenied(convert2StreamPermission(strConvert2SystemPermission));
            }
        }
        io.dcloud.common.core.permission.PermissionControler.invokeUTSAndroidPermissionRequest(io.dcloud.common.DHInterface.message.action.PermissionRequestAction.TYPE_COMPLETE, (java.lang.String[]) arrayList2.toArray(new java.lang.String[0]));
        if (arrayList2.size() > 0) {
            arrayList.removeAll(arrayList2);
        }
        if (arrayList.size() > 0) {
            requestSystemPermissions(activity, (java.lang.String[]) arrayList.toArray(new java.lang.String[0]), request.getRequestCode(), request);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    private static class ShowDialogData {
        android.app.Activity activity;
        java.lang.String appName;
        java.lang.String appid;
        boolean force;
        io.dcloud.common.DHInterface.IApp mApp;
        io.dcloud.common.adapter.util.PermissionUtil.Request request;
        java.lang.String streamPerName;
        int tryTimes;

        ShowDialogData(android.app.Activity activity, io.dcloud.common.DHInterface.IApp iApp, java.lang.String str, java.lang.String str2, java.lang.String str3, io.dcloud.common.adapter.util.PermissionUtil.Request request) {
            this(activity, iApp, str, str2, str3);
            setRequestHandler(request);
        }

        void setRequestHandler(io.dcloud.common.adapter.util.PermissionUtil.Request request) {
            this.request = request;
        }

        ShowDialogData(android.app.Activity activity, io.dcloud.common.DHInterface.IApp iApp, java.lang.String str, java.lang.String str2, java.lang.String str3) {
            this.tryTimes = 0;
            this.activity = activity;
            this.mApp = iApp;
            this.streamPerName = str;
            this.appid = str2;
            this.appName = str3;
        }
    }

    private static boolean isMiuiRom(android.app.Activity activity) {
        java.lang.String property = java.lang.System.getProperty("http.agent");
        return !android.text.TextUtils.isEmpty(property) && property.toLowerCase(java.util.Locale.ENGLISH).contains("miui");
    }

    public static void requestSystemPermissions(android.app.Activity activity, java.lang.String[] strArr, int i, io.dcloud.common.adapter.util.PermissionUtil.Request request, boolean z) {
        if (!request.isTriggerRequestEvent) {
            io.dcloud.common.core.permission.PermissionControler.invokeUTSAndroidPermissionRequest(io.dcloud.common.DHInterface.message.action.PermissionRequestAction.TYPE_REQUEST, strArr);
        }
        request.isTriggerRequestEvent = true;
        if (!caseVersion(activity) || strArr == null) {
            if (strArr != null) {
                try {
                    for (java.lang.String str : strArr) {
                        request.onGranted(convert2StreamPermission(str));
                    }
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            io.dcloud.common.core.permission.PermissionControler.invokeUTSAndroidPermissionRequest(io.dcloud.common.DHInterface.message.action.PermissionRequestAction.TYPE_COMPLETE, strArr);
            return;
        }
        java.util.HashMap<io.dcloud.common.adapter.util.PermissionUtil.Request, java.lang.String[]> map = new java.util.HashMap<>();
        map.put(request, strArr);
        sRequestCallBacks.put(java.lang.Integer.valueOf(i), map);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (z) {
            for (java.lang.String str2 : strArr) {
                if (checkPermissionDenied(activity, str2)) {
                    if (request != null) {
                        request.onDenied(str2);
                        io.dcloud.common.core.permission.PermissionControler.invokeUTSAndroidPermissionRequest(io.dcloud.common.DHInterface.message.action.PermissionRequestAction.TYPE_COMPLETE, new java.lang.String[]{str2});
                        return;
                    }
                    return;
                }
                arrayList.add(str2);
            }
            if (arrayList.size() > 0) {
                strArr = (java.lang.String[]) arrayList.toArray(new java.lang.String[0]);
            }
        }
        requestPermissions(activity, strArr, i, false);
    }

    public static void requestPermissions(android.app.Activity activity, java.lang.String[] strArr, int i, boolean z) {
        io.dcloud.common.core.permission.PermissionControler.requestPermissions(activity, strArr, i);
    }

    private static void showStreamAppPermissionDialog(final io.dcloud.common.adapter.util.PermissionUtil.ShowDialogData showDialogData) {
        int i;
        android.widget.CheckBox checkBox;
        java.lang.String string;
        final android.app.Activity activity = showDialogData.activity;
        final java.lang.String str = showDialogData.appid;
        java.lang.String str2 = showDialogData.appName;
        final java.lang.String str3 = showDialogData.streamPerName;
        final io.dcloud.common.adapter.util.PermissionUtil.Request request = showDialogData.request;
        io.dcloud.common.adapter.util.Logger.e("Permission", "showStreamAppPermissionDialog streamPerName=" + str3 + ";count=" + sUseStreamAppPermissionDialogCount);
        io.dcloud.common.adapter.util.PermissionUtil.PermissionData permissionData = sPermissionData.get(str3);
        if (permissionData == null) {
            request.onGranted(str3);
            return;
        }
        if (continueShowStreamAppPermissionDialog(showDialogData)) {
            int i2 = showDialogData.tryTimes + 1;
            showDialogData.tryTimes = i2;
            boolean z = i2 == 1;
            final com.dcloud.android.widget.dialog.DCloudAlertDialog dCloudAlertDialogInitDialogTheme = io.dcloud.common.util.DialogUtil.initDialogTheme(activity, true);
            if (activity != null && (activity instanceof io.dcloud.WebAppActivity)) {
                ((io.dcloud.WebAppActivity) activity).recordDialog(dCloudAlertDialogInitDialogTheme);
            }
            dCloudAlertDialogInitDialogTheme.setCanceledOnTouchOutside(false);
            if (z) {
                if (android.os.Build.BRAND.equalsIgnoreCase(io.dcloud.common.adapter.util.MobilePhoneModel.QiKU)) {
                    dCloudAlertDialogInitDialogTheme.setMessage(activity.getString(io.dcloud.base.R.string.dcloud_permissions_short_cut_tips));
                } else if (android.text.TextUtils.isEmpty(str2)) {
                    dCloudAlertDialogInitDialogTheme.setMessage(io.dcloud.common.util.StringUtil.format(activity.getString(permissionData.messageId), "App"));
                } else {
                    dCloudAlertDialogInitDialogTheme.setMessage(io.dcloud.common.util.StringUtil.format(activity.getString(permissionData.messageId), str2));
                }
            } else {
                if (android.os.Build.BRAND.equalsIgnoreCase(io.dcloud.common.adapter.util.MobilePhoneModel.QiKU)) {
                    dCloudAlertDialogInitDialogTheme.setMessage(activity.getString(io.dcloud.base.R.string.dcloud_permissions_short_cut_tips2));
                }
                if (PMS_LOCATION.equalsIgnoreCase(str3)) {
                    dCloudAlertDialogInitDialogTheme.setMessage(activity.getString(io.dcloud.base.R.string.dcloud_permissions_geo_retry_tips));
                } else {
                    dCloudAlertDialogInitDialogTheme.setMessage(io.dcloud.common.util.StringUtil.format(activity.getString(io.dcloud.base.R.string.dcloud_permissions_retry_tips), activity.getPackageManager().getApplicationLabel(activity.getApplicationInfo())));
                }
            }
            if (permissionData.checkbox == -1 || !z) {
                i = -1;
                checkBox = null;
            } else {
                checkBox = new android.widget.CheckBox(activity);
                checkBox.setText(io.dcloud.base.R.string.dcloud_permissions_checkbox_close_tips);
                checkBox.setTextColor(-65536);
                checkBox.setChecked(permissionData.checkbox == 1);
                int deivceSuitablePixel = getDeivceSuitablePixel(activity, 20);
                i = -1;
                dCloudAlertDialogInitDialogTheme.setView(checkBox, deivceSuitablePixel, deivceSuitablePixel, 0, 0);
            }
            final io.dcloud.common.DHInterface.ISysEventListener iSysEventListener = new io.dcloud.common.DHInterface.ISysEventListener() { // from class: io.dcloud.common.adapter.util.PermissionUtil.3
                @Override // io.dcloud.common.DHInterface.ISysEventListener
                public boolean onExecute(io.dcloud.common.DHInterface.ISysEventListener.SysEventType sysEventType, java.lang.Object obj) {
                    io.dcloud.common.adapter.util.Logger.e("Permission", "unregisterSysEventListener registerSysEventListener pEventType=" + sysEventType);
                    if (sysEventType != io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onWebAppReStart) {
                        return false;
                    }
                    dCloudAlertDialogInitDialogTheme.dismiss();
                    io.dcloud.common.adapter.util.PermissionUtil.unregisterWebAppReStartEvent(showDialogData.mApp, this);
                    try {
                        request.onDenied(str3);
                        io.dcloud.common.adapter.util.PermissionUtil.showStreamAppPermissionDialog();
                        return false;
                    } catch (java.lang.Exception e) {
                        e.printStackTrace();
                        return false;
                    }
                }
            };
            if (showDialogData.mApp != null) {
                io.dcloud.common.adapter.util.Logger.e("Permission", "showStreamAppPermissionDialog registerSysEventListener");
                showDialogData.mApp.registerSysEventListener(iSysEventListener, io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onWebAppReStart);
            }
            final android.widget.CheckBox checkBox2 = checkBox;
            android.content.DialogInterface.OnClickListener onClickListener = new android.content.DialogInterface.OnClickListener() { // from class: io.dcloud.common.adapter.util.PermissionUtil.4
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(android.content.DialogInterface dialogInterface, int i3) {
                    dCloudAlertDialogInitDialogTheme.dismiss();
                    io.dcloud.common.DHInterface.IApp iApp = showDialogData.mApp;
                    if (iApp != null) {
                        io.dcloud.common.adapter.util.PermissionUtil.unregisterWebAppReStartEvent(iApp, iSysEventListener);
                    }
                    if (i3 == -1) {
                        android.widget.CheckBox checkBox3 = checkBox2;
                        io.dcloud.common.adapter.util.PermissionUtil.putStreamAppPermission(activity, str, str3, !(checkBox3 == null ? 1 : checkBox3.isChecked()));
                        request.onGranted(str3);
                    } else if (i3 == -2) {
                        android.widget.CheckBox checkBox4 = checkBox2;
                        if (checkBox4 != null && checkBox4.isChecked()) {
                            io.dcloud.common.adapter.util.PermissionUtil.putStreamAppPermission(activity, str, str3, -1);
                        }
                        request.onDenied(str3);
                    }
                    io.dcloud.common.adapter.util.PermissionUtil.showStreamAppPermissionDialog();
                }
            };
            java.lang.String string2 = activity.getString(z ? io.dcloud.base.R.string.dcloud_common_no_allow : io.dcloud.base.R.string.dcloud_common_cancel);
            if (z) {
                string = activity.getString(io.dcloud.base.R.string.dcloud_common_allow);
            } else if (!android.os.Build.BRAND.equalsIgnoreCase(io.dcloud.common.adapter.util.MobilePhoneModel.QiKU) && !PMS_LOCATION.equalsIgnoreCase(str3)) {
                string = activity.getString(io.dcloud.base.R.string.dcloud_permissions_reauthorization);
            } else {
                string = activity.getString(io.dcloud.base.R.string.dcloud_permissions_reopened);
            }
            dCloudAlertDialogInitDialogTheme.setButton(-2, string2, onClickListener);
            dCloudAlertDialogInitDialogTheme.setButton(i, string, onClickListener);
            dCloudAlertDialogInitDialogTheme.setOnKeyListener(new android.content.DialogInterface.OnKeyListener() { // from class: io.dcloud.common.adapter.util.PermissionUtil.5
                @Override // android.content.DialogInterface.OnKeyListener
                public boolean onKey(android.content.DialogInterface dialogInterface, int i3, android.view.KeyEvent keyEvent) {
                    if (keyEvent.getAction() != 1 || i3 != 4) {
                        return false;
                    }
                    dCloudAlertDialogInitDialogTheme.dismiss();
                    io.dcloud.common.DHInterface.IApp iApp = showDialogData.mApp;
                    if (iApp != null) {
                        io.dcloud.common.adapter.util.PermissionUtil.unregisterWebAppReStartEvent(iApp, iSysEventListener);
                    }
                    request.onDenied(str3);
                    io.dcloud.common.adapter.util.PermissionUtil.showStreamAppPermissionDialog();
                    return true;
                }
            });
            try {
                dCloudAlertDialogInitDialogTheme.show();
                dCloudAlertDialogInitDialogTheme.setOnDismissListener(new android.content.DialogInterface.OnDismissListener() { // from class: io.dcloud.common.adapter.util.PermissionUtil.6
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(android.content.DialogInterface dialogInterface) {
                        android.app.Activity activity2 = activity;
                        if (activity2 == null || !(activity2 instanceof io.dcloud.WebAppActivity)) {
                            return;
                        }
                        ((io.dcloud.WebAppActivity) activity2).removeFromRecord(dCloudAlertDialogInitDialogTheme);
                    }
                });
            } catch (java.lang.Exception e) {
                io.dcloud.common.adapter.util.Logger.e("ian", "try dialog");
                e.printStackTrace();
            }
        }
    }

    public static int checkSelfPermission(android.app.Activity activity, java.lang.String str) {
        if (activity != null && str != null) {
            java.lang.Object objInvokeMethod = io.dcloud.common.adapter.util.PlatformUtil.invokeMethod(activity.getClass().getName(), "checkSelfPermission", activity, new java.lang.Class[]{str.getClass()}, new java.lang.Object[]{str});
            if (objInvokeMethod instanceof java.lang.Integer) {
                return ((java.lang.Integer) objInvokeMethod).intValue();
            }
        }
        return 0;
    }

    private static boolean isMiui(android.app.Activity activity, java.lang.String str, io.dcloud.common.adapter.util.PermissionUtil.Request request) {
        java.lang.String property = java.lang.System.getProperty("http.agent");
        if (android.text.TextUtils.isEmpty(property)) {
            if (!android.os.Build.BRAND.contains("Xiaomi")) {
                return false;
            }
        } else if (!property.toLowerCase(java.util.Locale.ENGLISH).contains("miui")) {
            return false;
        }
        int requestCode = getRequestCode();
        android.content.Intent intent = new android.content.Intent();
        intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
        intent.putExtra("extra_pkgname", activity.getPackageName());
        try {
            activity.startActivityForResult(intent, requestCode);
            saveCallabckData(activity, str, request, requestCode);
            return true;
        } catch (android.content.ActivityNotFoundException unused) {
            intent.setComponent(null);
            intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
            try {
                activity.startActivityForResult(intent, requestCode);
                saveCallabckData(activity, str, request, requestCode);
            } catch (android.content.ActivityNotFoundException unused2) {
                intent.setComponent(null);
                intent.setPackage("com.android.Setting");
                activity.startActivityForResult(intent, requestCode);
                saveCallabckData(activity, str, request, requestCode);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
            return true;
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static class SafeCenter {
        private static java.util.ArrayList<io.dcloud.common.adapter.util.PermissionUtil.SafeCenter.Item> datas = new java.util.ArrayList<>();

        /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
        static class Item {
            java.lang.String action;
            java.lang.String clsName;
            java.lang.String extParamName;
            java.lang.String pname;

            Item(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
                this.pname = str;
                this.clsName = str2;
                this.extParamName = str3;
                this.action = str4;
            }
        }

        SafeCenter() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void goSafeCenter(android.app.Activity activity) {
            init(activity);
            android.content.pm.PackageManager packageManager = activity.getPackageManager();
            for (int i = 0; i < datas.size(); i++) {
                android.content.Intent intent = new android.content.Intent();
                io.dcloud.common.adapter.util.PermissionUtil.SafeCenter.Item item = datas.get(i);
                try {
                    if (packageManager.getPackageInfo(item.pname, 0) != null) {
                        if (!android.text.TextUtils.isEmpty(item.clsName)) {
                            intent.setClassName(item.pname, item.clsName);
                        } else if (!android.text.TextUtils.isEmpty(item.pname)) {
                            intent.setPackage(item.pname);
                        }
                        if (!android.text.TextUtils.isEmpty(item.action)) {
                            intent.setAction(item.action);
                        }
                        if (!android.text.TextUtils.isEmpty(item.extParamName)) {
                            intent.putExtra(item.extParamName, activity.getPackageName());
                        }
                        try {
                            intent.setFlags(268435456);
                            activity.startActivity(intent);
                            io.dcloud.common.adapter.util.Logger.i("Permission", "successful " + android.os.Build.MODEL + "intent=" + intent);
                        } catch (android.content.ActivityNotFoundException e) {
                            io.dcloud.common.adapter.util.Logger.e("Permission", "ActivityNotFoundException =" + e);
                            e.printStackTrace();
                        } catch (java.lang.Exception e2) {
                            io.dcloud.common.adapter.util.Logger.e("Permission", "Exception =" + e2);
                        }
                    }
                } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
                }
            }
        }

        static void init(android.content.Context context) {
            if (datas.isEmpty()) {
                try {
                    org.json.JSONArray jSONArray = new org.json.JSONArray(new java.lang.String(io.dcloud.common.util.IOUtil.toString(new java.io.FileInputStream(new java.io.File(context.getExternalFilesDir(android.os.Environment.DIRECTORY_DOWNLOADS) + "/temp.j")))));
                    for (int i = 0; i < jSONArray.length(); i++) {
                        org.json.JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                        java.lang.String strOptString = jSONObjectOptJSONObject.optString(com.facebook.common.callercontext.ContextChain.TAG_PRODUCT);
                        if (!android.text.TextUtils.isEmpty(strOptString)) {
                            datas.add(new io.dcloud.common.adapter.util.PermissionUtil.SafeCenter.Item(strOptString, jSONObjectOptJSONObject.optString("c"), jSONObjectOptJSONObject.optString("e"), jSONObjectOptJSONObject.optString("a")));
                        }
                    }
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
                if (datas.isEmpty()) {
                    datas.add(new io.dcloud.common.adapter.util.PermissionUtil.SafeCenter.Item("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity", "extra_pkgname", null));
                    datas.add(new io.dcloud.common.adapter.util.PermissionUtil.SafeCenter.Item("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity", "extra_pkgname", null));
                    datas.add(new io.dcloud.common.adapter.util.PermissionUtil.SafeCenter.Item("com.meizu.safe", "com.meizu.safe.security.AppSecActivity", "packageName", null));
                    datas.add(new io.dcloud.common.adapter.util.PermissionUtil.SafeCenter.Item("com.aliyun.mobile.permission", "com.aliyun.mobile.permission.ExternalAppDetailActivity", "packageName", null));
                    datas.add(new io.dcloud.common.adapter.util.PermissionUtil.SafeCenter.Item("com.iqoo.secure", "com.iqoo.secure.MainActivity", "packageName", null));
                    datas.add(new io.dcloud.common.adapter.util.PermissionUtil.SafeCenter.Item("com.sonymobile.cta", "com.sonymobile.cta.SomcCTAMainActivity", "package", null));
                    datas.add(new io.dcloud.common.adapter.util.PermissionUtil.SafeCenter.Item("com.mediatek.security", "com.mediatek.security.ui.PermissionControlPageActivity", "package", null));
                    datas.add(new io.dcloud.common.adapter.util.PermissionUtil.SafeCenter.Item("com.yulong.android.launcher3", "com.yulong.android.launcher3.LauncherSettingsActivity", "package", null));
                    datas.add(new io.dcloud.common.adapter.util.PermissionUtil.SafeCenter.Item("com.android.settings", "com.android.settings.Settings$ManageApplicationsActivity", "package", null));
                    datas.add(new io.dcloud.common.adapter.util.PermissionUtil.SafeCenter.Item(null, null, "package", "android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean goSafeCenter(android.app.Activity activity, java.lang.String str, io.dcloud.common.adapter.util.PermissionUtil.Request request) {
            boolean z;
            int requestCode = io.dcloud.common.adapter.util.PermissionUtil.getRequestCode();
            if (io.dcloud.common.adapter.util.PermissionUtil.PMS_LOCATION.equalsIgnoreCase(str)) {
                android.location.LocationManager locationManager = (android.location.LocationManager) activity.getSystemService("location");
                boolean zIsProviderEnabled = locationManager.isProviderEnabled("gps");
                boolean zIsProviderEnabled2 = locationManager.isProviderEnabled("network");
                if (!zIsProviderEnabled && !zIsProviderEnabled2) {
                    android.content.Intent intent = new android.content.Intent("android.settings.LOCATION_SOURCE_SETTINGS");
                    try {
                        activity.startActivity(intent);
                        io.dcloud.common.adapter.util.PermissionUtil.saveCallabckData(activity, str, request, requestCode);
                        io.dcloud.common.adapter.util.Logger.i("Permission", "successful " + android.os.Build.MODEL + "intent=" + intent);
                        return true;
                    } catch (android.content.ActivityNotFoundException e) {
                        io.dcloud.common.adapter.util.Logger.e("Permission", "ActivityNotFoundException =" + e);
                        e.printStackTrace();
                    } catch (java.lang.Exception e2) {
                        io.dcloud.common.adapter.util.Logger.e("Permission", "Exception =" + e2);
                    }
                }
            }
            init(activity);
            android.content.pm.PackageManager packageManager = activity.getPackageManager();
            for (int i = 0; i < datas.size(); i++) {
                android.content.Intent intent2 = new android.content.Intent();
                io.dcloud.common.adapter.util.PermissionUtil.SafeCenter.Item item = datas.get(i);
                try {
                    if (packageManager.getPackageInfo(item.pname, 0) != null) {
                        if (!android.text.TextUtils.isEmpty(item.clsName)) {
                            z = true;
                            intent2.setClassName(item.pname, item.clsName);
                        } else {
                            z = true;
                            if (!android.text.TextUtils.isEmpty(item.pname)) {
                                intent2.setPackage(item.pname);
                            }
                        }
                        if (!android.text.TextUtils.isEmpty(item.action)) {
                            intent2.setAction(item.action);
                        }
                        if (!android.text.TextUtils.isEmpty(item.extParamName)) {
                            intent2.putExtra(item.extParamName, activity.getPackageName());
                        }
                        try {
                            activity.startActivityForResult(intent2, requestCode);
                            io.dcloud.common.adapter.util.PermissionUtil.saveCallabckData(activity, str, request, requestCode);
                            io.dcloud.common.adapter.util.Logger.i("Permission", "successful " + android.os.Build.MODEL + "intent=" + intent2);
                            return z;
                        } catch (android.content.ActivityNotFoundException e3) {
                            io.dcloud.common.adapter.util.Logger.e("Permission", "ActivityNotFoundException =" + e3);
                            e3.printStackTrace();
                        } catch (java.lang.Exception e4) {
                            io.dcloud.common.adapter.util.Logger.e("Permission", "Exception =" + e4);
                        }
                    }
                } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
                }
            }
            return true;
        }
    }

    public static void usePermission(android.app.Activity activity, java.lang.String str, final io.dcloud.common.adapter.util.PermissionUtil.Request request) {
        useSystemPermission(activity, convert2SystemPermission(str), new io.dcloud.common.adapter.util.PermissionUtil.Request() { // from class: io.dcloud.common.adapter.util.PermissionUtil.2
            @Override // io.dcloud.common.adapter.util.PermissionUtil.Request
            public void onDenied(java.lang.String str2) {
                request.onDenied(str2);
            }

            @Override // io.dcloud.common.adapter.util.PermissionUtil.Request
            public void onGranted(java.lang.String str2) {
                request.onGranted(str2);
            }
        });
    }
}
