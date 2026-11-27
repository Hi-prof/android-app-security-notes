package io.dcloud.common.adapter.util;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class PlatformUtil extends io.dcloud.common.adapter.util.SP {
    private static final java.lang.String ACTION_INSTALL_SHORTCUT = "com.android.launcher.action.INSTALL_SHORTCUT";
    public static boolean APS_COVER = false;
    public static final byte ASSETS_RESOUCE = 0;
    private static final java.lang.String EXTRA_SHORTCUT_DUPLICATE = "duplicate";
    public static final byte FILE_RESOUCE = 2;
    public static final byte SRC_RESOUCE = 1;
    private static final java.lang.String URI_HTC_LAUNCER = "content://com.htc.launcher.settings/favorites?notify=true";
    private static final java.lang.String URI_SAMSUNG_LAUNCER = "content://com.sec.android.app.twlauncher.settings/favorites?notify=true";
    private static int _SCREEN_CONTENT_HEIGHT;
    private static int _SCREEN_HEIGHT;
    private static int _SCREEN_STATUSBAR_HEIGHT;
    private static int _SCREEN_WIDTH;
    private static int[] _blackpixels;
    private static int[] _pixels;
    private static final java.lang.String[] PROJECTION = {"_id", io.dcloud.common.constant.AbsoluteConst.JSON_KEY_TITLE, "iconResource"};
    private static int MAX_SPAN_IN_ONE_SCREEN = 16;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public static class APKInfo {
        public java.lang.String mAppName;
        public android.graphics.drawable.Drawable mIcon;
    }

    private static int[] GET_BLACK_LINE(int i) {
        int[] iArr = _blackpixels;
        if (iArr == null || iArr.length != i) {
            _blackpixels = new int[i];
            int i2 = 0;
            while (true) {
                int[] iArr2 = _blackpixels;
                if (i2 >= iArr2.length) {
                    break;
                }
                iArr2[i2] = -16777216;
                i2++;
            }
        }
        return _blackpixels;
    }

    private static int[] GET_WIHTE_LINE(int i) {
        int[] iArr = _pixels;
        if (iArr == null || iArr.length != i) {
            _pixels = new int[i];
            int i2 = 0;
            while (true) {
                int[] iArr2 = _pixels;
                if (i2 >= iArr2.length) {
                    break;
                }
                iArr2[i2] = -1;
                i2++;
            }
        }
        return _pixels;
    }

    public static int MESURE_SCREEN_CONTENT_HEIGHT(android.app.Activity activity) {
        if (_SCREEN_CONTENT_HEIGHT == 0) {
            android.graphics.Rect rect = new android.graphics.Rect();
            activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            _SCREEN_STATUSBAR_HEIGHT = rect.top;
            int iHeight = rect.height();
            _SCREEN_CONTENT_HEIGHT = iHeight;
            if (_SCREEN_STATUSBAR_HEIGHT < 0 || iHeight > SCREEN_HEIGHT(activity)) {
                _SCREEN_STATUSBAR_HEIGHT = 0;
                _SCREEN_CONTENT_HEIGHT = SCREEN_HEIGHT(activity);
            }
        }
        return _SCREEN_CONTENT_HEIGHT;
    }

    public static int MESURE_SCREEN_STATUSBAR_HEIGHT(android.app.Activity activity) {
        if (_SCREEN_STATUSBAR_HEIGHT == 0) {
            android.graphics.Rect rect = new android.graphics.Rect();
            activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            _SCREEN_STATUSBAR_HEIGHT = rect.top;
            int iHeight = rect.height();
            _SCREEN_CONTENT_HEIGHT = iHeight;
            if (_SCREEN_STATUSBAR_HEIGHT < 0 || iHeight > SCREEN_HEIGHT(activity)) {
                _SCREEN_STATUSBAR_HEIGHT = 0;
                _SCREEN_CONTENT_HEIGHT = SCREEN_HEIGHT(activity);
            }
        }
        return _SCREEN_STATUSBAR_HEIGHT;
    }

    public static void RESET_H_W() {
        _SCREEN_WIDTH = 0;
        _SCREEN_HEIGHT = 0;
        _SCREEN_STATUSBAR_HEIGHT = 0;
        _SCREEN_CONTENT_HEIGHT = 0;
        _pixels = null;
    }

    public static int SCREEN_HEIGHT(android.content.Context context) {
        if (_SCREEN_HEIGHT == 0) {
            _SCREEN_HEIGHT = context.getResources().getDisplayMetrics().heightPixels;
        }
        return _SCREEN_HEIGHT;
    }

    public static int SCREEN_WIDTH(android.content.Context context) {
        if (_SCREEN_WIDTH == 0) {
            _SCREEN_WIDTH = context.getResources().getDisplayMetrics().widthPixels;
        }
        return _SCREEN_WIDTH;
    }

    public static android.graphics.Bitmap captureView(android.view.View view) {
        return captureView(view, true, true, null, "ARGB");
    }

    public static android.graphics.Bitmap captureWebViewContent(android.view.View view, boolean z, boolean z2, android.graphics.Rect rect, java.lang.String str) {
        android.webkit.WebView webView;
        try {
            webView = (android.webkit.WebView) ((io.dcloud.common.adapter.ui.AdaFrameView) ((com.dcloud.android.widget.AbsoluteLayout) view).getFrameView().mWindowMgr.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.WindowMgr, 18, null)).obtainWebView().obtainWindowView();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            webView = null;
        }
        if (webView == null) {
            return null;
        }
        if (z2 && io.dcloud.common.adapter.util.AndroidResources.sIMEAlive) {
            return null;
        }
        int iWidth = rect != null ? rect.width() : view.getMeasuredWidth();
        int iHeight = rect != null ? rect.height() : java.lang.Math.round(webView.getContentHeight() * webView.getScale());
        if (iWidth == 0) {
            return null;
        }
        android.graphics.Bitmap.Config config = android.graphics.Bitmap.Config.RGB_565;
        if (str.equals("ARGB")) {
            config = android.graphics.Bitmap.Config.ARGB_4444;
        }
        android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(iWidth, iHeight, config);
        android.graphics.Canvas canvas = new android.graphics.Canvas(bitmapCreateBitmap);
        if (rect != null) {
            canvas.translate(-rect.left, -rect.top);
        }
        webView.draw(canvas);
        if (!z || !isWhiteBitmap(bitmapCreateBitmap)) {
            return bitmapCreateBitmap;
        }
        bitmapCreateBitmap.recycle();
        return null;
    }

    public static boolean checkClass(java.lang.String str) {
        try {
            java.lang.Class.forName(str);
            return true;
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    public static boolean checkGTAndYoumeng() {
        return checkClass("io.dcloud.feature.apsGt.GTPushService") || checkClass("io.dcloud.feature.statistics.UmengStatisticsMgr");
    }

    public static boolean checkLauncherScreenSpace(android.content.Context context) {
        android.database.Cursor cursorQuery = context.getContentResolver().query(android.net.Uri.parse(URI_SAMSUNG_LAUNCER), new java.lang.String[]{"screen", "spanX", "spanY"}, null, null, null);
        if (cursorQuery == null) {
            return true;
        }
        int iQueryMaxLauncherScreenCount = queryMaxLauncherScreenCount(context);
        io.dcloud.common.adapter.util.Logger.e("PlatformUtil", "Samsung Launcher: max screen num = " + iQueryMaxLauncherScreenCount);
        int columnIndexOrThrow = cursorQuery.getColumnIndexOrThrow("spanX");
        int columnIndexOrThrow2 = cursorQuery.getColumnIndexOrThrow("spanY");
        int i = iQueryMaxLauncherScreenCount * MAX_SPAN_IN_ONE_SCREEN;
        while (cursorQuery.moveToNext()) {
            try {
                try {
                    i -= cursorQuery.getInt(columnIndexOrThrow) * cursorQuery.getInt(columnIndexOrThrow2);
                } catch (java.lang.Exception e) {
                    io.dcloud.common.adapter.util.Logger.e("PlatformUtil", "Check Launcher space" + e);
                    cursorQuery.close();
                    i = 0;
                }
            } catch (java.lang.Throwable th) {
                cursorQuery.close();
                throw th;
            }
        }
        cursorQuery.close();
        return i > 0;
    }

    public static void createShortut(android.content.Context context, java.lang.String str, java.lang.String str2, int i, boolean z) {
        android.content.Intent intent = new android.content.Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setClassName(context, str2);
        android.content.Intent intent2 = new android.content.Intent(ACTION_INSTALL_SHORTCUT);
        intent2.putExtra("android.intent.extra.shortcut.INTENT", intent);
        intent2.putExtra("android.intent.extra.shortcut.NAME", str);
        intent2.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", android.content.Intent.ShortcutIconResource.fromContext(context, i));
        intent2.putExtra(EXTRA_SHORTCUT_DUPLICATE, z);
        context.sendBroadcast(intent2);
    }

    public static void destroyDrawingCache(android.view.View view) {
        view.destroyDrawingCache();
    }

    public static void disableWebViewMultiProcess(android.content.Context context) {
        java.lang.Object objInvokeFieldValue;
        java.lang.Object objInvokeFieldValue2;
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            try {
                if (android.provider.Settings.Global.getInt(context.getContentResolver(), "webview_multiprocess", 0) != 1 || (objInvokeFieldValue = invokeFieldValue(android.provider.Settings.Global.class.getName(), "sNameValueCache", android.provider.Settings.Global.class.newInstance())) == null || (objInvokeFieldValue2 = invokeFieldValue(objInvokeFieldValue.getClass().getName(), "mValues", objInvokeFieldValue)) == null || !(objInvokeFieldValue2 instanceof java.util.HashMap)) {
                    return;
                }
                ((java.util.HashMap) objInvokeFieldValue2).put("webview_multiprocess", com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static io.dcloud.common.adapter.util.PlatformUtil.APKInfo getApkFileInfo(android.content.Context context, java.lang.String str) {
        java.lang.String str2;
        android.content.pm.ApplicationInfo applicationInfo;
        io.dcloud.common.adapter.util.PlatformUtil.APKInfo aPKInfo = new io.dcloud.common.adapter.util.PlatformUtil.APKInfo();
        android.graphics.drawable.Drawable drawable = null;
        try {
            android.content.pm.PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 1);
            if (packageArchiveInfo != null && (applicationInfo = packageArchiveInfo.applicationInfo) != null) {
                java.lang.Class<?> cls = java.lang.Class.forName("android.content.res.AssetManager");
                android.content.res.AssetManager assetManager = (android.content.res.AssetManager) cls.getConstructor(null).newInstance(null);
                cls.getDeclaredMethod("addAssetPath", java.lang.String.class).invoke(assetManager, str);
                android.util.DisplayMetrics displayMetrics = new android.util.DisplayMetrics();
                displayMetrics.setToDefaults();
                android.content.res.Resources resources = new android.content.res.Resources(assetManager, displayMetrics, context.getResources().getConfiguration());
                int i = applicationInfo.icon;
                if (i == 0) {
                    str2 = null;
                } else {
                    str2 = (java.lang.String) resources.getText(applicationInfo.labelRes);
                    try {
                        drawable = resources.getDrawable(i);
                    } catch (java.lang.Throwable th) {
                        th = th;
                        th.printStackTrace();
                    }
                }
                aPKInfo.mIcon = drawable;
                aPKInfo.mAppName = str2;
                return aPKInfo;
            }
            return aPKInfo;
        } catch (java.lang.Throwable th2) {
            th = th2;
            str2 = null;
        }
    }

    private static android.content.pm.ActivityInfo getBestActivityInfo(java.util.List<android.content.pm.ResolveInfo> list, java.util.LinkedList<java.lang.String> linkedList) {
        java.util.LinkedList linkedList2 = new java.util.LinkedList();
        for (int i = 0; i < list.size(); i++) {
            android.content.pm.ResolveInfo resolveInfo = list.get(i);
            if (linkedList.contains(resolveInfo.activityInfo.packageName)) {
                linkedList2.add(resolveInfo.activityInfo);
            }
        }
        int i2 = Integer.MAX_VALUE;
        android.content.pm.ActivityInfo activityInfo = null;
        for (int i3 = 0; i3 < linkedList2.size(); i3++) {
            android.content.pm.ActivityInfo activityInfo2 = (android.content.pm.ActivityInfo) linkedList2.get(i3);
            int iIndexOf = linkedList.indexOf(activityInfo2.packageName);
            if (iIndexOf < i2) {
                activityInfo = activityInfo2;
                i2 = iIndexOf;
            }
        }
        return activityInfo;
    }

    public static byte[] getFileContent(java.lang.String str, int i) {
        java.io.InputStream inputStream = getInputStream(str, i);
        try {
            return inputStream != null ? io.dcloud.common.util.IOUtil.getBytes(inputStream) : null;
        } catch (java.io.IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            io.dcloud.common.util.IOUtil.close(inputStream);
        }
    }

    public static java.lang.String getFileContent4S(java.lang.String str) {
        return new java.lang.String(getFileContent(str, 0)).replace(com.facebook.common.callercontext.ContextChain.TAG_PRODUCT, "");
    }

    public static java.lang.String getFilePathFromContentUri(android.net.Uri uri, android.content.ContentResolver contentResolver) {
        java.lang.String[] strArr = {"_data"};
        android.database.Cursor cursorQuery = contentResolver.query(uri, strArr, null, null, null);
        cursorQuery.moveToFirst();
        java.lang.String string = cursorQuery.getString(cursorQuery.getColumnIndex(strArr[0]));
        cursorQuery.close();
        return string;
    }

    public static java.io.InputStream getInputStream(java.lang.String str, int i) {
        try {
            java.lang.String str2 = io.dcloud.common.adapter.util.DeviceInfo.sDeviceRootDir;
            if (str2 != null && str.startsWith(str2)) {
                i = 2;
            }
            if (i == 0) {
                return getResInputStream(str);
            }
            if (i == 1) {
                return io.dcloud.common.adapter.util.PlatformUtil.class.getClassLoader().getResourceAsStream(str);
            }
            if (i == 2) {
                java.io.File file = new java.io.File(str);
                if (file.exists()) {
                    return io.dcloud.common.util.FileUtil.getFileInputStream(io.dcloud.application.DCLoudApplicationImpl.self().getContext(), file);
                }
            }
            return null;
        } catch (java.lang.Exception e) {
            io.dcloud.common.adapter.util.Logger.e(com.taobao.weex.common.RenderTypes.RENDER_TYPE_NATIVE, e.toString());
            return null;
        }
    }

    public static java.io.InputStream getResInputStream(java.lang.String str) {
        try {
            java.lang.String strUseAndroidPath = useAndroidPath(str);
            if (!android.text.TextUtils.isEmpty(strUseAndroidPath)) {
                if (strUseAndroidPath.startsWith("assets://")) {
                    strUseAndroidPath = strUseAndroidPath.replace("assets://", "");
                } else if (strUseAndroidPath.startsWith("android_asset/")) {
                    strUseAndroidPath = strUseAndroidPath.replace("android_asset/", "");
                } else if (strUseAndroidPath.startsWith(io.dcloud.feature.internal.sdk.SDK.ANDROID_ASSET)) {
                    strUseAndroidPath = strUseAndroidPath.replace(io.dcloud.feature.internal.sdk.SDK.ANDROID_ASSET, "");
                }
            }
            return io.dcloud.common.adapter.util.AndroidResources.sAssetMgr.open(strUseAndroidPath, 2);
        } catch (java.io.FileNotFoundException unused) {
            io.dcloud.common.adapter.util.Logger.e("PlatformUtil.getResInputStream FileNotFoundException pFilePath=" + str);
            return null;
        } catch (java.io.IOException unused2) {
            io.dcloud.common.adapter.util.Logger.e("PlatformUtil.getResInputStream IOException pFilePath=" + str);
            return null;
        } catch (java.lang.RuntimeException unused3) {
            io.dcloud.common.adapter.util.Logger.e("PlatformUtil.getResInputStream RuntimeException pFilePath=" + str);
            return null;
        } catch (java.lang.Exception unused4) {
            io.dcloud.common.adapter.util.Logger.e("PlatformUtil.getResInputStream Exception pFilePath=" + str);
            return null;
        }
    }

    public static boolean hasAppInstalled(android.content.Context context, java.lang.String str) {
        try {
            context.getPackageManager().getPackageInfo(str, 1);
            return true;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return new java.io.File("/sdcard/Android/data/" + str).exists();
        }
    }

    public static void init(android.content.Context context) {
        io.dcloud.common.adapter.util.DeviceInfo.sApplicationContext = context;
    }

    public static java.lang.Object invokeFieldValue(java.lang.String str, java.lang.String str2, java.lang.Object obj) {
        java.lang.Class<?> superclass;
        if (obj != null) {
            try {
                try {
                    superclass = obj.getClass();
                } catch (java.lang.Throwable th) {
                    io.dcloud.common.adapter.util.Logger.i(com.taobao.weex.common.RenderTypes.RENDER_TYPE_NATIVE, th.toString());
                }
            } catch (java.lang.ClassNotFoundException e) {
                io.dcloud.common.adapter.util.Logger.i(com.taobao.weex.common.RenderTypes.RENDER_TYPE_NATIVE, e.toString());
            }
        } else {
            superclass = null;
        }
        if (superclass == null) {
            superclass = java.lang.Class.forName(str);
        }
        java.lang.reflect.Field declaredField = null;
        while (superclass != null) {
            try {
                declaredField = superclass.getField(str2);
                if (declaredField != null) {
                    break;
                }
                if (declaredField == null) {
                    try {
                        declaredField = superclass.getDeclaredField(str2);
                        if (declaredField != null) {
                            break;
                        }
                    } catch (java.lang.Exception unused) {
                        continue;
                    }
                }
                superclass = superclass.getSuperclass();
            } catch (java.lang.Exception unused2) {
            }
        }
        if (declaredField != null) {
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        }
        return null;
    }

    public static java.lang.Object invokeMethod(java.lang.String str, java.lang.String str2) {
        return invokeMethod(str, str2, null, new java.lang.Class[0], new java.lang.Object[0]);
    }

    public static boolean invokeSetFieldValue(java.lang.Object obj, java.lang.String str, java.lang.Object obj2) {
        if (obj == null) {
            return false;
        }
        try {
            java.lang.reflect.Field declaredField = null;
            for (java.lang.Class<?> superclass = obj.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
                try {
                    declaredField = superclass.getField(str);
                    if (declaredField != null) {
                        break;
                    }
                    if (declaredField == null) {
                        try {
                            declaredField = superclass.getDeclaredField(str);
                            if (declaredField != null) {
                                break;
                            }
                        } catch (java.lang.Exception unused) {
                            continue;
                        }
                    }
                } catch (java.lang.Exception unused2) {
                }
            }
            if (declaredField != null) {
                declaredField.setAccessible(true);
                declaredField.set(obj, obj2);
                return true;
            }
        } catch (java.lang.Throwable th) {
            io.dcloud.common.adapter.util.Logger.i(com.taobao.weex.common.RenderTypes.RENDER_TYPE_NATIVE, th.toString());
        }
        return false;
    }

    public static boolean isAppInstalled(android.content.Context context, java.lang.String str) {
        return io.dcloud.common.util.LoadAppUtils.isAppLoad(context, str);
    }

    public static boolean isEmulator() {
        java.lang.String str = android.os.Build.MODEL;
        return str.equals("sdk") || str.equals("google_sdk");
    }

    public static boolean isLineWhiteBitmap(android.graphics.Bitmap bitmap, boolean z) {
        int width = bitmap.getWidth();
        int[] iArr = new int[width];
        bitmap.getPixels(iArr, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), 1);
        boolean zEquals = java.util.Arrays.equals(iArr, GET_WIHTE_LINE(width));
        return z ? zEquals | java.util.Arrays.equals(iArr, GET_BLACK_LINE(width)) : zEquals;
    }

    private static boolean isPureColor(int[] iArr) {
        int i = iArr[0];
        boolean z = true;
        for (int i2 : iArr) {
            if (i != i2) {
                z = false;
            }
        }
        return z;
    }

    public static boolean isResFileExists(java.lang.String str) {
        try {
            java.io.InputStream inputStreamOpen = io.dcloud.common.adapter.util.AndroidResources.sAssetMgr.open(str);
            if (inputStreamOpen != null) {
                inputStreamOpen.close();
                return true;
            }
        } catch (java.io.IOException unused) {
        }
        return false;
    }

    public static boolean isWhiteBitmap(android.graphics.Bitmap bitmap) {
        return isWhiteBitmap(bitmap, false, false);
    }

    public static void launchApplication(android.content.Context context, java.lang.String str, java.lang.String str2, java.util.HashMap map, boolean z) throws java.lang.Exception {
        android.content.Intent intent = io.dcloud.common.util.PdrUtil.isEmpty(str2) ? new android.content.Intent("android.intent.action.MAIN") : new android.content.Intent(str2);
        if (!io.dcloud.common.util.PdrUtil.isEmpty(str) && !setPackageName(context, intent, str)) {
            throw new java.lang.RuntimeException();
        }
        if (z) {
            intent.setFlags(268435456);
        }
        if (map != null && !map.isEmpty()) {
            for (java.lang.String str3 : map.keySet()) {
                java.lang.Object obj = map.get(str3);
                if (obj instanceof java.lang.Integer) {
                    intent.putExtra(str3, ((java.lang.Integer) obj).intValue());
                } else if (obj instanceof java.lang.String) {
                    intent.putExtra(str3, (java.lang.String) obj);
                } else if (obj instanceof java.lang.Boolean) {
                    intent.putExtra(str3, ((java.lang.Boolean) obj).booleanValue());
                }
            }
        }
        context.startActivity(intent);
    }

    public static java.lang.String[] listFsAppsFiles(java.lang.String str) {
        try {
            return new java.io.File(str).list();
        } catch (java.lang.Exception e) {
            io.dcloud.common.adapter.util.Logger.w("PlatformUtil.listResFiles pPath=" + str, e);
            return null;
        }
    }

    public static java.lang.String[] listResFiles(java.lang.String str) {
        try {
            return io.dcloud.common.adapter.util.AndroidResources.sAssetMgr.list(useAndroidPath(str));
        } catch (java.io.IOException e) {
            io.dcloud.common.adapter.util.Logger.w("PlatformUtil.listResFiles pPath=" + str, e);
            return null;
        }
    }

    public static java.lang.Object newInstance(java.lang.String str, java.lang.Class[] clsArr, java.lang.Object[] objArr) {
        try {
            return java.lang.Class.forName(str).getConstructor(clsArr).newInstance(objArr);
        } catch (java.lang.Exception e) {
            io.dcloud.common.adapter.util.Logger.i(com.taobao.weex.common.RenderTypes.RENDER_TYPE_NATIVE, e.toString());
            return null;
        } catch (java.lang.Throwable th) {
            io.dcloud.common.adapter.util.Logger.i(com.taobao.weex.common.RenderTypes.RENDER_TYPE_NATIVE, th.toString());
            return null;
        }
    }

    public static void openFileBySystem(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, io.dcloud.common.DHInterface.ICallBack iCallBack) {
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            android.os.StrictMode.setVmPolicy(new android.os.StrictMode.VmPolicy.Builder().build());
        }
        boolean zHasAppInstalled = !android.text.TextUtils.isEmpty(str2) ? hasAppInstalled(context, str2) : false;
        try {
            java.lang.String mimeType = io.dcloud.common.util.PdrUtil.getMimeType(str);
            if (str.startsWith(io.dcloud.common.adapter.util.DeviceInfo.FILE_PROTOCOL)) {
                str = str.substring(7);
            }
            if (str.startsWith("content://")) {
                str = getFilePathFromContentUri(android.net.Uri.parse(str), context.getContentResolver());
                mimeType = io.dcloud.common.util.PdrUtil.getMimeType(str);
            }
            if (io.dcloud.common.util.PdrUtil.isEmpty(str3)) {
                str3 = mimeType;
            }
            android.content.Intent dataAndTypeIntent = io.dcloud.common.util.LoadAppUtils.getDataAndTypeIntent(context, str, str3);
            if (zHasAppInstalled) {
                dataAndTypeIntent.setPackage(str2);
            }
            if (!new java.io.File(str).exists()) {
                if (iCallBack != null) {
                    iCallBack.onCallBack(-1, io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.DOMException.JSON_ERROR_INFO, 0, io.dcloud.common.constant.DOMException.MSG_NOT_FOUND_FILE));
                }
            } else {
                context.startActivity(dataAndTypeIntent);
                if (iCallBack != null) {
                    iCallBack.onCallBack(1, "{}");
                }
            }
        } catch (android.content.ActivityNotFoundException e) {
            io.dcloud.common.adapter.util.Logger.w(e);
            if (iCallBack != null) {
                iCallBack.onCallBack(-1, io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.DOMException.JSON_ERROR_INFO, 1, io.dcloud.common.constant.DOMException.MSG_NOT_FOUND_3TH));
            }
        }
    }

    public static void openURL(android.content.Context context, java.lang.String str, java.lang.String str2) throws java.lang.Exception {
        android.content.Intent uri = android.content.Intent.parseUri(str, 0);
        if (!io.dcloud.common.util.PdrUtil.isEmpty(str2)) {
            uri.setPackage(str2);
        }
        uri.setSelector(null);
        if (io.dcloud.common.util.BaseInfo.isDefense) {
            uri.setComponent(null);
            uri.addCategory("android.intent.category.BROWSABLE");
        }
        uri.setFlags(268435456);
        context.startActivity(uri);
    }

    public static android.content.pm.PackageInfo parseApkInfo(android.content.Context context, java.lang.String str) throws java.lang.Exception {
        return context.getPackageManager().getPackageArchiveInfo(str, 1);
    }

    private static boolean queryDefaultShortcut(java.lang.String str) {
        android.database.Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = io.dcloud.common.adapter.util.DeviceInfo.sApplicationContext.getContentResolver().query(android.net.Uri.parse("content://com.android.launcher2.settings/favorites?notify=false"), PROJECTION, "title=?", new java.lang.String[]{str}, null);
                if (cursorQuery != null && cursorQuery.moveToFirst()) {
                    cursorQuery.close();
                    cursorQuery.close();
                    return true;
                }
                if (cursorQuery == null) {
                    return false;
                }
            } catch (java.lang.Exception e) {
                io.dcloud.common.adapter.util.Logger.e("PlatformUtil", "queryHTCShortCut error:" + e.getMessage());
                if (cursorQuery == null) {
                    return false;
                }
            }
            cursorQuery.close();
            return false;
        } catch (java.lang.Throwable th) {
            if (cursorQuery == null) {
                throw th;
            }
            cursorQuery.close();
            throw th;
        }
    }

    private static boolean queryHTCShortCut(java.lang.String str) {
        android.database.Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = io.dcloud.common.adapter.util.DeviceInfo.sApplicationContext.getContentResolver().query(android.net.Uri.parse(URI_HTC_LAUNCER), PROJECTION, "title=?", new java.lang.String[]{str}, null);
                if (cursorQuery != null && cursorQuery.moveToFirst()) {
                    cursorQuery.close();
                    cursorQuery.close();
                    return true;
                }
                if (cursorQuery == null) {
                    return false;
                }
            } catch (java.lang.Exception e) {
                io.dcloud.common.adapter.util.Logger.e("PlatformUtil", "queryHTCShortCut error:" + e.getMessage());
                if (cursorQuery == null) {
                    return false;
                }
            }
            cursorQuery.close();
            return false;
        } catch (java.lang.Throwable th) {
            if (cursorQuery == null) {
                throw th;
            }
            cursorQuery.close();
            throw th;
        }
    }

    private static int queryMaxLauncherScreenCount(android.content.Context context) {
        android.database.Cursor cursorQuery = context.getContentResolver().query(android.net.Uri.parse(URI_SAMSUNG_LAUNCER), new java.lang.String[]{"MAX(screen)"}, null, null, null);
        if (cursorQuery == null) {
            return -1;
        }
        try {
            cursorQuery.moveToNext();
            return cursorQuery.getInt(0) + 1;
        } catch (java.lang.Exception e) {
            io.dcloud.common.adapter.util.Logger.e("PlatformUtil", "Samsung Launcher" + e);
            return -1;
        } finally {
            cursorQuery.close();
        }
    }

    public static boolean setPackageName(android.content.Context context, android.content.Intent intent, java.lang.String str) {
        android.content.Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
        if (launchIntentForPackage == null) {
            return false;
        }
        intent.setClassName(str, launchIntentForPackage.getComponent().getClassName());
        return true;
    }

    private static java.lang.String useAndroidPath(java.lang.String str) {
        return io.dcloud.common.util.StringUtil.trimString(io.dcloud.common.util.StringUtil.trimString(str, '/'), '\\');
    }

    public void delShortcut(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        android.content.Intent intent = new android.content.Intent("com.android.launcher.action.UNINSTALL_SHORTCUT");
        intent.putExtra("android.intent.extra.shortcut.NAME", str);
        android.content.Intent intent2 = new android.content.Intent("android.intent.action.MAIN");
        intent2.addCategory("android.intent.category.DEFAULT");
        intent2.setComponent(new android.content.ComponentName(str2, str3));
        intent.putExtra("android.intent.extra.shortcut.INTENT", intent2);
        io.dcloud.common.adapter.util.DeviceInfo.sApplicationContext.sendBroadcast(intent);
    }

    public static android.graphics.Bitmap captureView(android.view.View view, boolean z, boolean z2, android.graphics.Rect rect, java.lang.String str) {
        if (z2 && io.dcloud.common.adapter.util.AndroidResources.sIMEAlive) {
            return null;
        }
        int iWidth = rect != null ? rect.width() : view.getMeasuredWidth();
        int iHeight = rect != null ? rect.height() : view.getMeasuredHeight();
        if (iWidth == 0) {
            return null;
        }
        android.graphics.Bitmap.Config config = android.graphics.Bitmap.Config.RGB_565;
        if (str.equals("ARGB")) {
            config = android.graphics.Bitmap.Config.ARGB_4444;
        }
        android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(iWidth, iHeight, config);
        android.graphics.Canvas canvas = new android.graphics.Canvas(bitmapCreateBitmap);
        if (rect != null) {
            canvas.translate(-rect.left, -rect.top);
        }
        view.draw(canvas);
        if (!z || !isWhiteBitmap(bitmapCreateBitmap)) {
            return bitmapCreateBitmap;
        }
        bitmapCreateBitmap.recycle();
        return null;
    }

    public static java.lang.Object invokeMethod(java.lang.String str, java.lang.String str2, java.lang.Object obj) {
        return invokeMethod(str, str2, obj, new java.lang.Class[0], new java.lang.Object[0]);
    }

    public static boolean isWhiteBitmap(android.graphics.Bitmap bitmap, boolean z, boolean z2) {
        int height = bitmap.getHeight();
        int[] iArr = new int[height];
        bitmap.getPixels(iArr, 0, 1, bitmap.getWidth() / 4, 0, 1, height);
        boolean zEquals = java.util.Arrays.equals(iArr, GET_WIHTE_LINE(height));
        if (z2) {
            zEquals = isPureColor(iArr);
        }
        bitmap.getPixels(iArr, 0, 1, bitmap.getWidth() / 2, 0, 1, height);
        boolean zEquals2 = zEquals & java.util.Arrays.equals(iArr, GET_WIHTE_LINE(height));
        if (z2) {
            zEquals2 = isPureColor(iArr);
        }
        bitmap.getPixels(iArr, 0, 1, (bitmap.getWidth() * 3) / 4, 0, 1, height);
        boolean zEquals3 = zEquals2 & java.util.Arrays.equals(iArr, GET_WIHTE_LINE(height));
        if (z2) {
            zEquals3 = isPureColor(iArr);
        }
        return z ? zEquals3 | java.util.Arrays.equals(iArr, GET_BLACK_LINE(height)) : zEquals3;
    }

    public static java.lang.Object invokeMethod(java.lang.String str, java.lang.String str2, java.lang.Object obj, java.lang.Class[] clsArr, java.lang.Object[] objArr) {
        java.lang.String message;
        java.lang.Object objInvoke;
        java.lang.String str3 = null;
        try {
            java.lang.reflect.Method method = java.lang.Class.forName(str).getMethod(str2, clsArr);
            if (method != null) {
                method.setAccessible(true);
                objInvoke = method.invoke(obj, objArr);
            } else {
                objInvoke = null;
            }
        } catch (java.lang.ClassNotFoundException unused) {
            message = "ClassNotFoundException";
            str3 = message;
            objInvoke = null;
        } catch (java.lang.NoSuchMethodException unused2) {
            message = "NoSuchMethodException";
            str3 = message;
            objInvoke = null;
        } catch (java.lang.Exception e) {
            message = e.getMessage();
            str3 = message;
            objInvoke = null;
        }
        if (str3 != null && !"getJsContent".equals(str2)) {
            io.dcloud.common.adapter.util.Logger.i(com.taobao.weex.common.RenderTypes.RENDER_TYPE_NATIVE, str3 + com.taobao.weex.el.parse.Operators.SPACE_STR + str + com.taobao.weex.el.parse.Operators.SPACE_STR + str2);
        }
        return objInvoke;
    }

    public static void createShortut(android.content.Context context, java.lang.String str, java.lang.String str2, android.graphics.Bitmap bitmap, boolean z) {
        android.content.Intent intent = new android.content.Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setClassName(context, str2);
        android.content.Intent intent2 = new android.content.Intent(ACTION_INSTALL_SHORTCUT);
        intent2.putExtra("android.intent.extra.shortcut.INTENT", intent);
        intent2.putExtra("android.intent.extra.shortcut.NAME", str);
        intent2.putExtra("android.intent.extra.shortcut.ICON", bitmap);
        intent2.putExtra(EXTRA_SHORTCUT_DUPLICATE, z);
        context.sendBroadcast(intent2);
    }

    public static java.io.InputStream getInputStream(java.lang.String str) {
        if (str == null) {
            return null;
        }
        return getInputStream(str, io.dcloud.common.util.PdrUtil.isDeviceRootDir(str) ? 2 : 0);
    }

    public static android.graphics.Bitmap captureView(android.view.View view, java.lang.String str) {
        return captureView(view, null, str);
    }

    public static android.graphics.Bitmap captureView(android.view.View view, android.graphics.Rect rect, java.lang.String str) {
        try {
            int width = view.getWidth();
            int height = view.getHeight();
            boolean z = rect != null;
            if (z) {
                int i = rect.left;
                int i2 = rect.top;
                view.layout(i, i2, rect.right - i, rect.bottom - i2);
            } else {
                view.layout(0, 0, width, height);
            }
            view.setDrawingCacheEnabled(true);
            android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(view.getDrawingCache());
            bitmapCreateBitmap.setDensity(view.getContext().getResources().getDisplayMetrics().densityDpi);
            if (!io.dcloud.common.util.PdrUtil.isEmpty(str)) {
                io.dcloud.common.util.PdrUtil.saveBitmapToFile(bitmapCreateBitmap, str);
            }
            view.setDrawingCacheEnabled(false);
            if (z) {
                view.layout(0, 0, width, height);
            }
            return bitmapCreateBitmap;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static java.lang.Object invokeMethod(java.lang.Object obj, java.lang.String str, java.lang.Class<?>[] clsArr, java.lang.Object... objArr) {
        if (obj == null) {
            return null;
        }
        try {
            java.lang.reflect.Method method = obj.getClass().getMethod(str, clsArr);
            method.setAccessible(true);
            if (objArr.length == 0) {
                objArr = null;
            }
            return method.invoke(obj, objArr);
        } catch (java.lang.Throwable th) {
            io.dcloud.common.adapter.util.Logger.i(com.taobao.weex.common.RenderTypes.RENDER_TYPE_NATIVE, th.toString());
            return null;
        }
    }
}
