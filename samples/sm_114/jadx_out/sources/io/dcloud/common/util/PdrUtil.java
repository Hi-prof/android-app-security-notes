package io.dcloud.common.util;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class PdrUtil {
    public static final java.lang.String FILE_PATH_ENTRY_BACK = "..";
    public static final java.lang.String FILE_PATH_ENTRY_SEPARATOR2 = "%";
    private static final java.lang.String NAVIGATION = "navigationBarBackground";
    private static volatile boolean mHasCheckAllScreen;
    private static volatile boolean mIsAllScreenDevice;

    public static void alert(android.app.Activity activity, java.lang.String str, android.graphics.Bitmap bitmap) {
        final android.app.AlertDialog alertDialogCreate = new android.app.AlertDialog.Builder(activity).create();
        android.widget.LinearLayout linearLayout = new android.widget.LinearLayout(activity);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(17);
        android.widget.TextView textView = new android.widget.TextView(activity);
        textView.setText(str);
        linearLayout.addView(textView);
        android.widget.ImageView imageView = new android.widget.ImageView(activity);
        imageView.setBackgroundDrawable(new android.graphics.drawable.BitmapDrawable(bitmap));
        linearLayout.addView(imageView, new android.view.ViewGroup.LayoutParams(-2, -2));
        alertDialogCreate.setView(linearLayout);
        alertDialogCreate.setCanceledOnTouchOutside(false);
        alertDialogCreate.setButton(activity.getString(io.dcloud.base.R.string.dcloud_common_ok), new android.content.DialogInterface.OnClickListener() { // from class: io.dcloud.common.util.PdrUtil.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(android.content.DialogInterface dialogInterface, int i) {
                alertDialogCreate.dismiss();
            }
        });
        alertDialogCreate.show();
    }

    public static java.lang.String appendByDeviceRootDir(java.lang.String str) {
        if (str == null || str.startsWith(io.dcloud.common.adapter.util.DeviceInfo.sDeviceRootDir)) {
            return str;
        }
        if (str.startsWith(io.dcloud.common.adapter.util.DeviceInfo.FILE_PROTOCOL)) {
            str = str.substring(7);
        }
        if (str.indexOf("sdcard/") > -1) {
            str = str.substring(str.indexOf("sdcard/") + 7);
        }
        if (!str.endsWith("/")) {
            str = str + "/";
        }
        return io.dcloud.common.adapter.util.DeviceInfo.sDeviceRootDir + "/" + str;
    }

    public static boolean checkAlphaTransparent(int i) {
        return (i == -1 || (i >>> 24) == 255) ? false : true;
    }

    public static boolean checkIntl() {
        return io.dcloud.common.adapter.util.PlatformUtil.checkClass("io.dcloud.common.DHInterface.IntlCallback");
    }

    public static boolean checkStatusbarColor(int i) {
        java.lang.String str = android.os.Build.BRAND;
        if (str.equals(io.dcloud.common.adapter.util.MobilePhoneModel.GOOGLE)) {
            str = android.os.Build.MANUFACTURER;
        }
        if ((android.os.Build.VERSION.SDK_INT >= 23 || str.equalsIgnoreCase(io.dcloud.common.adapter.util.MobilePhoneModel.XIAOMI) || str.equalsIgnoreCase(io.dcloud.common.adapter.util.MobilePhoneModel.MEIZU)) && !str.equalsIgnoreCase(io.dcloud.common.adapter.util.MobilePhoneModel.DUOWEI)) {
            return true;
        }
        int i2 = (i >> 16) & 255;
        int i3 = (i >> 8) & 255;
        int i4 = i & 255;
        if (i2 >= 30 || i3 >= 30 || i4 >= 30) {
            return i2 <= 235 || i3 <= 235 || i4 <= 235;
        }
        return false;
    }

    public static void closeAndroidPDialog() {
        if (android.os.Build.VERSION.SDK_INT < 28) {
            return;
        }
        try {
            io.dcloud.common.adapter.util.PlatformUtil.invokeSetFieldValue(io.dcloud.common.adapter.util.PlatformUtil.invokeMethod(io.dcloud.common.util.Base64.decode2String("YW5kcm9pZC5hcHAuQWN0aXZpdHlUaHJlYWQ="), "currentActivityThread"), "mHiddenApiWarningShown", java.lang.Boolean.TRUE);
        } catch (java.lang.Exception e) {
            io.dcloud.common.adapter.util.Logger.e("PdrUtil", "closeAndroidPDialog--" + e.getMessage());
        }
    }

    public static java.lang.String convertAppPath(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str) {
        io.dcloud.common.DHInterface.IApp iAppObtainApp = iWebview.obtainApp();
        if (isNetPath(str) || str.startsWith("file:") || str.contains("/storage") || iAppObtainApp.obtainRunningAppMode() != 1) {
            return iAppObtainApp.convert2WebviewFullPath(iWebview.obtainFullUrl(), str);
        }
        java.lang.String strConvert2AbsFullPath = iWebview.obtainApp().convert2AbsFullPath(iWebview.obtainFullUrl(), str);
        if (strConvert2AbsFullPath.startsWith("/")) {
            strConvert2AbsFullPath = strConvert2AbsFullPath.substring(1, strConvert2AbsFullPath.length());
        }
        if (strConvert2AbsFullPath.contains("android_asset/")) {
            strConvert2AbsFullPath = strConvert2AbsFullPath.replace("android_asset/", "");
        }
        return com.nostra13.dcloudimageloader.core.download.ImageDownloader.Scheme.ASSETS.wrap(strConvert2AbsFullPath);
    }

    public static int convertToScreenInt(java.lang.String str, int i, int i2, float f) {
        return convertToScreenInt(str, i, i2, f, false);
    }

    public static java.lang.String dealString(java.lang.String str) throws java.io.UnsupportedEncodingException {
        byte[] bytes = str.getBytes("GBK");
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) (bytes[i] ^ 8);
        }
        return new java.lang.String(bytes, "GBK");
    }

    public static float dpiFromPx(int i, android.util.DisplayMetrics displayMetrics) {
        return i / (displayMetrics.densityDpi / 160.0f);
    }

    public static java.lang.String encodeURL(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return java.net.URLEncoder.encode(str, "utf-8");
        } catch (java.io.UnsupportedEncodingException unused) {
            io.dcloud.common.adapter.util.Logger.e("URLEncode error str=" + str);
            return java.net.URLEncoder.encode(str);
        }
    }

    public static boolean getAdEnv(android.content.Context context) {
        return !io.dcloud.common.util.language.LanguageUtil.getDeviceDefCountry().equalsIgnoreCase(io.dcloud.p.i0.c().decryptStr("GJ", (byte) 4));
    }

    public static org.json.JSONObject getConfigData(android.content.Context context, java.lang.String str, java.lang.String str2, boolean z) {
        try {
            java.io.InputStream resInputStream = z ? io.dcloud.common.adapter.util.PlatformUtil.getResInputStream(str2) : io.dcloud.common.adapter.io.DHFile.getInputStream(io.dcloud.common.adapter.io.DHFile.createFileHandler(str2));
            if (resInputStream == null) {
                return null;
            }
            byte[] bytes = io.dcloud.common.util.IOUtil.getBytes(resInputStream);
            java.lang.String strA = io.dcloud.p.e1.a(context, bytes);
            if (android.text.TextUtils.isEmpty(strA)) {
                strA = new java.lang.String(bytes);
            }
            return new org.json.JSONObject(strA);
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public static int getConfigOrientation(org.json.JSONObject jSONObject) throws org.json.JSONException {
        if (jSONObject != null && jSONObject.has("screenOrientation")) {
            org.json.JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("screenOrientation");
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            boolean z4 = false;
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                java.lang.String string = jSONArrayOptJSONArray.getString(i);
                string.getClass();
                string.hashCode();
                switch (string) {
                    case "portrait-primary":
                        z3 = true;
                        break;
                    case "landscape-secondary":
                        z2 = true;
                        break;
                    case "landscape-primary":
                        z = true;
                        break;
                    case "portrait-secondary":
                        z4 = true;
                        break;
                }
            }
            if ((!z && !z2) || (!z3 && !z4)) {
                if (z && z2) {
                    return 6;
                }
                if (z3 && z4) {
                    return 7;
                }
                if (z) {
                    return 0;
                }
                if (z2) {
                    return 8;
                }
                if (z3) {
                    return 1;
                }
                if (z4) {
                    return 9;
                }
            }
        }
        return 2;
    }

    public static java.lang.String getDefaultPrivateDocPath(java.lang.String str, java.lang.String str2) {
        if (isEmpty(str)) {
            str = io.dcloud.common.constant.AbsoluteConst.MINI_SERVER_APP_DOC + java.lang.System.currentTimeMillis();
        } else if (str.endsWith("/")) {
            str = str + java.lang.System.currentTimeMillis();
        }
        if (str.endsWith(com.taobao.weex.el.parse.Operators.DOT_STR + str2)) {
            return str;
        }
        return str + com.taobao.weex.el.parse.Operators.DOT_STR + str2;
    }

    public static java.lang.String getDownloadFilename(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        java.lang.String[] strArrStringSplit;
        java.lang.String[] strArrStringSplit2;
        java.lang.String strValueOf = null;
        try {
            str3 = java.net.URLDecoder.decode(str3, "utf-8");
            android.net.Uri uri = android.net.Uri.parse(str3);
            if (uri != null) {
                java.lang.String path = uri.getPath();
                if (!isEmpty(path)) {
                    str3 = path;
                }
            }
            if (!isEmpty(str) && (strArrStringSplit = stringSplit(str, ";")) != null) {
                for (int i = 0; i < strArrStringSplit.length; i++) {
                    java.lang.String str4 = strArrStringSplit[i];
                    if (str4 != null && str4.contains(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_FILENAME) && (strArrStringSplit2 = stringSplit(strArrStringSplit[i].trim(), "=")) != null) {
                        java.lang.String strReplace = strArrStringSplit2[0].replace(io.dcloud.common.util.JSUtil.QUOTE, "");
                        java.lang.String strReplace2 = strArrStringSplit2[1].replace(io.dcloud.common.util.JSUtil.QUOTE, "");
                        if (!isEmpty(strArrStringSplit2[1]) && isEquals(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_FILENAME, strReplace) && !isEmpty(strReplace2)) {
                            strValueOf = strReplace2;
                            break;
                        }
                    }
                }
            }
        } catch (java.lang.Exception unused) {
            io.dcloud.common.adapter.util.Logger.d("PdrUtil.getDownloadFilename " + str + " not found filename");
        }
        if (isEmpty(strValueOf)) {
            int iLastIndexOf = str3.lastIndexOf(47);
            if (iLastIndexOf == -1 || iLastIndexOf >= str3.length() - 1) {
                strValueOf = java.lang.String.valueOf(java.lang.System.currentTimeMillis());
            } else {
                strValueOf = str3.substring(iLastIndexOf + 1);
                int iIndexOf = strValueOf.indexOf(com.taobao.weex.el.parse.Operators.CONDITION_IF_STRING);
                if (iIndexOf != -1) {
                    strValueOf = iIndexOf < strValueOf.length() - 1 ? strValueOf.substring(0, iIndexOf) : java.lang.String.valueOf(java.lang.System.currentTimeMillis());
                }
            }
        }
        if (!strValueOf.contains(com.taobao.weex.el.parse.Operators.DOT_STR)) {
            java.lang.String extensionFromMimeType = getExtensionFromMimeType(str2);
            if (!isEmpty(extensionFromMimeType)) {
                strValueOf = strValueOf + com.taobao.weex.el.parse.Operators.DOT_STR + extensionFromMimeType;
            }
        }
        try {
            java.lang.String strReplaceAll = java.net.URLDecoder.decode(strValueOf, "UTF-8").replaceAll(java.io.File.separator, "");
            if (strReplaceAll.contains(com.taobao.weex.el.parse.Operators.CONDITION_IF_STRING)) {
                strReplaceAll = strReplaceAll.replaceAll("\\?", com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT);
            }
            if (strReplaceAll.length() <= 80) {
                return strReplaceAll;
            }
            return strReplaceAll.substring(0, 80) + java.lang.System.currentTimeMillis();
        } catch (java.io.UnsupportedEncodingException e) {
            e.printStackTrace();
            return strValueOf;
        }
    }

    public static java.lang.String getExtensionFromMimeType(java.lang.String str) {
        return android.webkit.MimeTypeMap.getSingleton().getExtensionFromMimeType(str);
    }

    public static java.lang.String getFileNameByUrl(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (android.text.TextUtils.isEmpty(str2)) {
            java.util.regex.Matcher matcher = java.util.regex.Pattern.compile("[\\w\\.]+[\\.](avi|mpeg|3gp|mp3|mp4|wav|jpeg|gif|jpg|png|apk|exe|pdf|rar|zip|docx|doc)").matcher(str);
            if (matcher.find()) {
                return matcher.group();
            }
            if (android.text.TextUtils.isEmpty(str3)) {
                return java.lang.String.valueOf(java.lang.System.currentTimeMillis()) + ".dat";
            }
        } else {
            java.lang.String lastPathSegment = android.net.Uri.parse(str).getLastPathSegment();
            if (lastPathSegment != null && lastPathSegment.contains(str2)) {
                return lastPathSegment;
            }
            if (android.text.TextUtils.isEmpty(str3)) {
                return java.lang.String.valueOf(java.lang.System.currentTimeMillis()) + str2;
            }
        }
        return str3;
    }

    public static java.lang.Object getKeyByIndex(java.util.HashMap map, int i) {
        if (i < 0) {
            return null;
        }
        int i2 = 0;
        for (java.lang.Object obj : map.keySet()) {
            if (i == i2) {
                return obj;
            }
            i2++;
        }
        return null;
    }

    public static java.lang.Object getKeyByValue(java.util.HashMap map, java.lang.Object obj, boolean z) {
        if (z && !map.containsValue(obj)) {
            return null;
        }
        for (java.lang.Object obj2 : map.keySet()) {
            java.lang.Object obj3 = map.get(obj2);
            if (obj3 != null && obj3.equals(obj)) {
                return obj2;
            }
        }
        return null;
    }

    public static java.lang.String getMimeType(java.lang.String str) {
        android.webkit.MimeTypeMap singleton = android.webkit.MimeTypeMap.getSingleton();
        java.lang.String fileExtensionFromUrl = android.webkit.MimeTypeMap.getFileExtensionFromUrl(str);
        if (isEmpty(fileExtensionFromUrl) && str.lastIndexOf(com.taobao.weex.el.parse.Operators.DOT_STR) >= 0) {
            fileExtensionFromUrl = str.substring(str.lastIndexOf(com.taobao.weex.el.parse.Operators.DOT_STR) + 1);
        }
        java.lang.String mimeTypeFromExtension = singleton.getMimeTypeFromExtension(fileExtensionFromUrl);
        if (!android.text.TextUtils.isEmpty(mimeTypeFromExtension)) {
            return mimeTypeFromExtension;
        }
        if (android.text.TextUtils.isEmpty(fileExtensionFromUrl)) {
            return "*/*";
        }
        return "application/" + fileExtensionFromUrl;
    }

    public static int getNavigationBarHeight(android.app.Activity activity) {
        int dimensionPixelSize = 0;
        if (isNavigationBarExist(activity)) {
            android.content.res.Resources resources = activity.getResources();
            int identifier = resources.getIdentifier("navigation_bar_height", "dimen", com.taobao.weex.WXEnvironment.OS);
            dimensionPixelSize = identifier > 0 ? resources.getDimensionPixelSize(identifier) : 0;
            if (dimensionPixelSize == 0 && android.os.Build.VERSION.SDK_INT >= 30) {
                android.graphics.Insets insets = activity.getWindowManager().getCurrentWindowMetrics().getWindowInsets().getInsets(android.view.WindowInsets.Type.navigationBars());
                return insets.bottom - insets.top;
            }
        }
        return dimensionPixelSize;
    }

    public static java.lang.String getNonString(java.lang.String str, java.lang.String str2) {
        return isEmpty(str) ? str2 : str;
    }

    public static java.lang.Object getObject(java.lang.Object[] objArr, int i) {
        try {
            return objArr[i];
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0216 A[LOOP:1: B:17:0x0073->B:101:0x0216, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:110:0x0172 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:66:0x017a A[Catch: Exception -> 0x0239, TRY_ENTER, TryCatch #0 {Exception -> 0x0239, blocks: (B:3:0x0020, B:4:0x0031, B:6:0x0037, B:9:0x0045, B:12:0x0053, B:14:0x0059, B:17:0x0073, B:19:0x0079, B:21:0x0083, B:63:0x0172, B:66:0x017a, B:69:0x0185, B:70:0x018a, B:99:0x0212, B:67:0x017f, B:22:0x008b, B:24:0x008f, B:25:0x009a, B:27:0x00a0, B:29:0x00ae, B:57:0x0161, B:31:0x00ba, B:33:0x00c0, B:34:0x00c9, B:36:0x00cf, B:38:0x00f3, B:40:0x00fb, B:41:0x011e, B:43:0x0124, B:44:0x012d, B:46:0x0133, B:47:0x013c, B:49:0x0142, B:51:0x014d, B:53:0x0153, B:15:0x0064, B:11:0x004e, B:72:0x01a0, B:75:0x01a8, B:77:0x01ae, B:79:0x01b4, B:82:0x01bf, B:83:0x01cc, B:85:0x01d2, B:87:0x01d8, B:89:0x01de, B:80:0x01b9, B:90:0x01ee, B:92:0x01f4, B:94:0x01fa, B:96:0x0200), top: B:106:0x0020, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:67:0x017f A[Catch: Exception -> 0x0239, TryCatch #0 {Exception -> 0x0239, blocks: (B:3:0x0020, B:4:0x0031, B:6:0x0037, B:9:0x0045, B:12:0x0053, B:14:0x0059, B:17:0x0073, B:19:0x0079, B:21:0x0083, B:63:0x0172, B:66:0x017a, B:69:0x0185, B:70:0x018a, B:99:0x0212, B:67:0x017f, B:22:0x008b, B:24:0x008f, B:25:0x009a, B:27:0x00a0, B:29:0x00ae, B:57:0x0161, B:31:0x00ba, B:33:0x00c0, B:34:0x00c9, B:36:0x00cf, B:38:0x00f3, B:40:0x00fb, B:41:0x011e, B:43:0x0124, B:44:0x012d, B:46:0x0133, B:47:0x013c, B:49:0x0142, B:51:0x014d, B:53:0x0153, B:15:0x0064, B:11:0x004e, B:72:0x01a0, B:75:0x01a8, B:77:0x01ae, B:79:0x01b4, B:82:0x01bf, B:83:0x01cc, B:85:0x01d2, B:87:0x01d8, B:89:0x01de, B:80:0x01b9, B:90:0x01ee, B:92:0x01f4, B:94:0x01fa, B:96:0x0200), top: B:106:0x0020, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:69:0x0185 A[Catch: Exception -> 0x0239, TryCatch #0 {Exception -> 0x0239, blocks: (B:3:0x0020, B:4:0x0031, B:6:0x0037, B:9:0x0045, B:12:0x0053, B:14:0x0059, B:17:0x0073, B:19:0x0079, B:21:0x0083, B:63:0x0172, B:66:0x017a, B:69:0x0185, B:70:0x018a, B:99:0x0212, B:67:0x017f, B:22:0x008b, B:24:0x008f, B:25:0x009a, B:27:0x00a0, B:29:0x00ae, B:57:0x0161, B:31:0x00ba, B:33:0x00c0, B:34:0x00c9, B:36:0x00cf, B:38:0x00f3, B:40:0x00fb, B:41:0x011e, B:43:0x0124, B:44:0x012d, B:46:0x0133, B:47:0x013c, B:49:0x0142, B:51:0x014d, B:53:0x0153, B:15:0x0064, B:11:0x004e, B:72:0x01a0, B:75:0x01a8, B:77:0x01ae, B:79:0x01b4, B:82:0x01bf, B:83:0x01cc, B:85:0x01d2, B:87:0x01d8, B:89:0x01de, B:80:0x01b9, B:90:0x01ee, B:92:0x01f4, B:94:0x01fa, B:96:0x0200), top: B:106:0x0020, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:79:0x01b4 A[Catch: Exception -> 0x0211, TryCatch #1 {Exception -> 0x0211, blocks: (B:72:0x01a0, B:75:0x01a8, B:77:0x01ae, B:79:0x01b4, B:82:0x01bf, B:83:0x01cc, B:85:0x01d2, B:87:0x01d8, B:89:0x01de, B:80:0x01b9, B:90:0x01ee, B:92:0x01f4, B:94:0x01fa, B:96:0x0200), top: B:107:0x01a0, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:80:0x01b9 A[Catch: Exception -> 0x0211, TryCatch #1 {Exception -> 0x0211, blocks: (B:72:0x01a0, B:75:0x01a8, B:77:0x01ae, B:79:0x01b4, B:82:0x01bf, B:83:0x01cc, B:85:0x01d2, B:87:0x01d8, B:89:0x01de, B:80:0x01b9, B:90:0x01ee, B:92:0x01f4, B:94:0x01fa, B:96:0x0200), top: B:107:0x01a0, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:82:0x01bf A[Catch: Exception -> 0x0211, TryCatch #1 {Exception -> 0x0211, blocks: (B:72:0x01a0, B:75:0x01a8, B:77:0x01ae, B:79:0x01b4, B:82:0x01bf, B:83:0x01cc, B:85:0x01d2, B:87:0x01d8, B:89:0x01de, B:80:0x01b9, B:90:0x01ee, B:92:0x01f4, B:94:0x01fa, B:96:0x0200), top: B:107:0x01a0, outer: #0 }] */
    public static org.json.JSONObject getSitemapParameters(org.json.JSONObject jSONObject, java.lang.String str, java.lang.String str2) {
        java.lang.String str3;
        org.json.JSONArray jSONArrayOptJSONArray;
        java.lang.String str4;
        java.lang.String ref;
        org.json.JSONArray jSONArrayOptJSONArray2;
        java.lang.String string;
        org.json.JSONObject jSONObjectOptJSONObject;
        org.json.JSONObject jSONObjectCombinSitemapHtmlJSONObject;
        org.json.JSONObject jSONObjectOptJSONObject2;
        org.json.JSONObject jSONObjectOptJSONObject3;
        java.lang.String str5 = tv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener.ARG_PORT;
        java.lang.String str6 = "matchUrls";
        java.lang.String str7 = "webviewId";
        try {
            org.json.JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("pages");
            java.lang.String strOptString = jSONObject.optString(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_LAUNCH_PATH);
            int i = 0;
            while (i < jSONArrayOptJSONArray3.length()) {
                org.json.JSONObject jSONObjectOptJSONObject4 = jSONArrayOptJSONArray3.optJSONObject(i);
                int i2 = i;
                java.lang.String str8 = str7;
                java.lang.String strOptString2 = jSONObjectOptJSONObject4.has(str7) ? jSONObjectOptJSONObject4.optString(str7) : jSONObjectOptJSONObject4.optString("webviewid");
                org.json.JSONArray jSONArrayOptJSONArray4 = jSONObjectOptJSONObject4.has(str6) ? jSONObjectOptJSONObject4.optJSONArray(str6) : jSONObjectOptJSONObject4.optJSONArray("matchurls");
                org.json.JSONArray jSONArray = jSONArrayOptJSONArray3;
                int i3 = 0;
                boolean zMatchArray = false;
                while (i3 < jSONArrayOptJSONArray4.length()) {
                    java.lang.Object objOpt = jSONArrayOptJSONArray4.opt(i3);
                    org.json.JSONArray jSONArray2 = jSONArrayOptJSONArray4;
                    if (objOpt instanceof java.lang.String) {
                        zMatchArray = match((java.lang.String) objOpt, str2);
                    } else {
                        if (objOpt instanceof org.json.JSONObject) {
                            org.json.JSONObject jSONObject2 = (org.json.JSONObject) objOpt;
                            java.net.URL url = new java.net.URL(str2);
                            java.util.Iterator<java.lang.String> itKeys = jSONObject2.keys();
                            while (true) {
                                if (itKeys.hasNext()) {
                                    java.lang.String next = itKeys.next();
                                    if (!"protocol".equals(next)) {
                                        if ("hostname".equals(next)) {
                                            jSONArrayOptJSONArray = jSONObject2.optJSONArray("hostname");
                                            ref = url.getHost();
                                        } else {
                                            if (str5.equals(next)) {
                                                jSONArrayOptJSONArray2 = jSONObject2.optJSONArray(str5);
                                                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                                                str3 = str5;
                                                sb.append("");
                                                sb.append(url.getPort());
                                                string = sb.toString();
                                            } else {
                                                str3 = str5;
                                                if ("host".equals(next)) {
                                                    org.json.JSONArray jSONArrayOptJSONArray5 = jSONObject2.optJSONArray("host");
                                                    java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                                                    jSONArrayOptJSONArray2 = jSONArrayOptJSONArray5;
                                                    sb2.append(url.getHost());
                                                    sb2.append(":");
                                                    sb2.append(url.getPort());
                                                    string = sb2.toString();
                                                } else {
                                                    if ("pathname".equals(next)) {
                                                        jSONArrayOptJSONArray = jSONObject2.optJSONArray("pathname");
                                                        ref = url.getPath();
                                                    } else if ("search".equals(next)) {
                                                        jSONArrayOptJSONArray = jSONObject2.optJSONArray("search");
                                                        ref = url.getQuery();
                                                    } else if ("hash".equals(next)) {
                                                        jSONArrayOptJSONArray = jSONObject2.optJSONArray("hash");
                                                        ref = url.getRef();
                                                    } else if ("href".equals(next)) {
                                                        jSONArrayOptJSONArray = jSONObject2.optJSONArray("href");
                                                        str4 = str2;
                                                    } else {
                                                        jSONArrayOptJSONArray = null;
                                                        str4 = null;
                                                    }
                                                    str4 = ref;
                                                }
                                            }
                                            org.json.JSONArray jSONArray3 = jSONArrayOptJSONArray2;
                                            ref = string;
                                            jSONArrayOptJSONArray = jSONArray3;
                                            str4 = ref;
                                        }
                                        if (jSONArrayOptJSONArray == null && str4 != null && !(zMatchArray = matchArray(jSONArrayOptJSONArray, str4))) {
                                            break;
                                        }
                                        str5 = str3;
                                    } else {
                                        jSONArrayOptJSONArray = jSONObject2.optJSONArray("protocol");
                                        ref = url.getProtocol();
                                    }
                                    str3 = str5;
                                    str4 = ref;
                                    if (jSONArrayOptJSONArray == null) {
                                    }
                                    str5 = str3;
                                }
                            }
                        }
                        if (zMatchArray) {
                            if (jSONObjectOptJSONObject4.has("webviewParameter")) {
                                jSONObjectOptJSONObject = jSONObjectOptJSONObject4.optJSONObject("webviewParameter");
                            } else {
                                jSONObjectOptJSONObject = jSONObjectOptJSONObject4.optJSONObject("__html5plusWebviewParameter ");
                            }
                            if (jSONObjectOptJSONObject == null) {
                                jSONObjectOptJSONObject = new org.json.JSONObject();
                            }
                            jSONObjectCombinSitemapHtmlJSONObject = jSONObjectOptJSONObject;
                            jSONObjectCombinSitemapHtmlJSONObject.put(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_LAUNCH_PATH, strOptString);
                            jSONObjectCombinSitemapHtmlJSONObject.put("webviewid", strOptString2);
                            jSONObjectCombinSitemapHtmlJSONObject.put("appid", str);
                            try {
                                if (jSONObject.has(io.dcloud.sdk.core.util.Const.PROVIDER_TYPE_GLOBAL) && (jSONObjectOptJSONObject2 = jSONObject.optJSONObject(io.dcloud.sdk.core.util.Const.PROVIDER_TYPE_GLOBAL)) != null) {
                                    if (jSONObjectOptJSONObject2.has("webviewParameter")) {
                                        jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject("webviewParameter");
                                    } else {
                                        jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject("__html5plusWebviewParameter ");
                                    }
                                    if (jSONObjectOptJSONObject3 != null) {
                                        jSONObjectCombinSitemapHtmlJSONObject = io.dcloud.common.util.JSONUtil.combinSitemapHtmlJSONObject(new org.json.JSONObject(jSONObjectOptJSONObject3.toString()), jSONObjectCombinSitemapHtmlJSONObject);
                                    }
                                    if (!jSONObjectCombinSitemapHtmlJSONObject.has(io.dcloud.common.constant.AbsoluteConst.JSONKEY_STATUSBAR) && jSONObjectOptJSONObject2.has(io.dcloud.common.constant.AbsoluteConst.JSONKEY_STATUSBAR) && !jSONObjectOptJSONObject2.isNull(io.dcloud.common.constant.AbsoluteConst.JSONKEY_STATUSBAR)) {
                                        jSONObjectCombinSitemapHtmlJSONObject.put(io.dcloud.common.constant.AbsoluteConst.JSONKEY_STATUSBAR, new org.json.JSONObject(jSONObjectOptJSONObject2.optJSONObject(io.dcloud.common.constant.AbsoluteConst.JSONKEY_STATUSBAR).toString()));
                                    }
                                }
                                if (!jSONObjectCombinSitemapHtmlJSONObject.has(io.dcloud.common.constant.AbsoluteConst.JSONKEY_STATUSBAR) && jSONObject.has(io.dcloud.common.constant.AbsoluteConst.JSONKEY_STATUSBAR) && !jSONObject.isNull(io.dcloud.common.constant.AbsoluteConst.JSONKEY_STATUSBAR)) {
                                    jSONObjectCombinSitemapHtmlJSONObject.put(io.dcloud.common.constant.AbsoluteConst.JSONKEY_STATUSBAR, new org.json.JSONObject(jSONObject.optJSONObject(io.dcloud.common.constant.AbsoluteConst.JSONKEY_STATUSBAR).toString()));
                                }
                                return jSONObjectCombinSitemapHtmlJSONObject;
                            } catch (java.lang.Exception e) {
                                e.printStackTrace();
                                return jSONObjectCombinSitemapHtmlJSONObject;
                            }
                        }
                        i3++;
                        str2 = str2;
                        jSONArrayOptJSONArray4 = jSONArray2;
                        str5 = str3;
                    }
                    str3 = str5;
                    if (zMatchArray) {
                        if (jSONObjectOptJSONObject4.has("webviewParameter")) {
                            jSONObjectOptJSONObject = jSONObjectOptJSONObject4.optJSONObject("webviewParameter");
                        } else {
                            jSONObjectOptJSONObject = jSONObjectOptJSONObject4.optJSONObject("__html5plusWebviewParameter ");
                        }
                        if (jSONObjectOptJSONObject == null) {
                            jSONObjectOptJSONObject = new org.json.JSONObject();
                        }
                        jSONObjectCombinSitemapHtmlJSONObject = jSONObjectOptJSONObject;
                        jSONObjectCombinSitemapHtmlJSONObject.put(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_LAUNCH_PATH, strOptString);
                        jSONObjectCombinSitemapHtmlJSONObject.put("webviewid", strOptString2);
                        jSONObjectCombinSitemapHtmlJSONObject.put("appid", str);
                        if (jSONObject.has(io.dcloud.sdk.core.util.Const.PROVIDER_TYPE_GLOBAL)) {
                            if (jSONObjectOptJSONObject2.has("webviewParameter")) {
                                jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject("webviewParameter");
                            } else {
                                jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject("__html5plusWebviewParameter ");
                            }
                            if (jSONObjectOptJSONObject3 != null) {
                                jSONObjectCombinSitemapHtmlJSONObject = io.dcloud.common.util.JSONUtil.combinSitemapHtmlJSONObject(new org.json.JSONObject(jSONObjectOptJSONObject3.toString()), jSONObjectCombinSitemapHtmlJSONObject);
                            }
                            if (!jSONObjectCombinSitemapHtmlJSONObject.has(io.dcloud.common.constant.AbsoluteConst.JSONKEY_STATUSBAR)) {
                                jSONObjectCombinSitemapHtmlJSONObject.put(io.dcloud.common.constant.AbsoluteConst.JSONKEY_STATUSBAR, new org.json.JSONObject(jSONObjectOptJSONObject2.optJSONObject(io.dcloud.common.constant.AbsoluteConst.JSONKEY_STATUSBAR).toString()));
                            }
                        }
                        if (!jSONObjectCombinSitemapHtmlJSONObject.has(io.dcloud.common.constant.AbsoluteConst.JSONKEY_STATUSBAR)) {
                            jSONObjectCombinSitemapHtmlJSONObject.put(io.dcloud.common.constant.AbsoluteConst.JSONKEY_STATUSBAR, new org.json.JSONObject(jSONObject.optJSONObject(io.dcloud.common.constant.AbsoluteConst.JSONKEY_STATUSBAR).toString()));
                        }
                        return jSONObjectCombinSitemapHtmlJSONObject;
                    }
                    i3++;
                    str2 = str2;
                    jSONArrayOptJSONArray4 = jSONArray2;
                    str5 = str3;
                }
                i = i2 + 1;
                str6 = str6;
                str7 = str8;
                jSONArrayOptJSONArray3 = jSONArray;
            }
        } catch (java.lang.Exception e2) {
            io.dcloud.common.adapter.util.Logger.e("PdrUtil", "getSitemapParameters e==" + e2.getMessage());
        }
        return null;
    }

    public static java.lang.String getUrlPathName(java.lang.String str) {
        return str != null ? android.webkit.URLUtil.stripAnchor(stripQuery(str)) : str;
    }

    public static boolean hasNavBar(android.content.Context context) {
        android.content.res.Resources resources = context.getResources();
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", com.taobao.weex.WXEnvironment.OS);
        if (identifier == 0) {
            return !android.view.ViewConfiguration.get(context).hasPermanentMenuKey();
        }
        boolean z = resources.getBoolean(identifier);
        java.lang.String navBarOverride = getNavBarOverride();
        if ("1".equals(navBarOverride)) {
            return false;
        }
        if (com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT.equals(navBarOverride)) {
            return true;
        }
        return z;
    }

    public static java.lang.String int2DecimalStr(int i, int i2) {
        return java.lang.String.valueOf(java.math.BigDecimal.valueOf(i).divide(java.math.BigDecimal.valueOf(i2)));
    }

    public static boolean isAllScreenDevice(android.app.Activity activity) {
        float f;
        float f2;
        if (mHasCheckAllScreen) {
            return mIsAllScreenDevice;
        }
        mHasCheckAllScreen = true;
        mIsAllScreenDevice = false;
        if (android.os.Build.VERSION.SDK_INT >= 28 && activity.getWindow().getDecorView().getRootWindowInsets() != null && activity.getWindow().getDecorView().getRootWindowInsets().getDisplayCutout() != null) {
            mIsAllScreenDevice = true;
            return mIsAllScreenDevice;
        }
        android.view.WindowManager windowManager = (android.view.WindowManager) activity.getSystemService("window");
        if (windowManager != null) {
            android.view.Display defaultDisplay = windowManager.getDefaultDisplay();
            android.graphics.Point point = new android.graphics.Point();
            defaultDisplay.getRealSize(point);
            int i = point.x;
            int i2 = point.y;
            if (i < i2) {
                f2 = i;
                f = i2;
            } else {
                float f3 = i2;
                f = i;
                f2 = f3;
            }
            if (f / f2 >= 1.97f) {
                mIsAllScreenDevice = true;
            }
        }
        return mIsAllScreenDevice;
    }

    public static boolean isBase64ImagePath(java.lang.String str) {
        return !android.text.TextUtils.isEmpty(str) && str.startsWith("data:image");
    }

    public static boolean isContains(java.lang.String str, java.lang.String str2) {
        if (isEmpty(str) || isEmpty(str2)) {
            return false;
        }
        return str.contains(str2);
    }

    public static boolean isDeviceRootDir(java.lang.String str) {
        try {
            return str.startsWith(io.dcloud.common.adapter.util.DeviceInfo.sDeviceRootDir) || str.startsWith(io.dcloud.common.adapter.util.DeviceInfo.sCacheRootDir) || str.startsWith("/sdcard/") || str.startsWith(io.dcloud.common.adapter.util.DeviceInfo.sDeviceRootDir.substring(1)) || str.startsWith("sdcard/");
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    public static boolean isEmpty(java.lang.Object obj) {
        if (obj == null || obj.equals("")) {
            return true;
        }
        return obj.toString().length() == 4 && obj.toString().toLowerCase(java.util.Locale.ENGLISH).equals("null");
    }

    public static boolean isEquals(java.lang.String str, java.lang.String str2) {
        if (str == null || str2 == null) {
            return false;
        }
        return str.equalsIgnoreCase(str2);
    }

    public static boolean isFilePath(java.lang.String str) {
        return !android.text.TextUtils.isEmpty(str) && str.startsWith("file:/");
    }

    public static boolean isFullScreen(android.app.Activity activity) {
        return (activity.getWindow().getAttributes().flags & 1024) == 1024;
    }

    public static boolean isLightColor(int i) {
        return ((int) (((((double) android.graphics.Color.red(i)) * 0.299d) + (((double) android.graphics.Color.green(i)) * 0.587d)) + (((double) android.graphics.Color.blue(i)) * 0.114d))) >= 192;
    }

    public static boolean isNavigationBarExist(android.app.Activity activity) {
        android.view.ViewGroup viewGroup = (android.view.ViewGroup) activity.getWindow().getDecorView();
        if (android.os.Build.VERSION.SDK_INT >= 36 && io.dcloud.common.adapter.util.AndroidResources.sAppTargetSdkVersion >= 36) {
            android.graphics.Insets insets = activity.getWindowManager().getCurrentWindowMetrics().getWindowInsets().getInsets(android.view.WindowInsets.Type.navigationBars());
            return insets.bottom - insets.top > 0;
        }
        if (viewGroup != null) {
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                viewGroup.getChildAt(i).getContext().getPackageName();
                try {
                    if (viewGroup.getChildAt(i).getId() != -1 && NAVIGATION.equals(activity.getResources().getResourceEntryName(viewGroup.getChildAt(i).getId())) && viewGroup.getChildAt(i).getVisibility() == 0) {
                        return true;
                    }
                } catch (java.lang.Exception unused) {
                }
            }
        }
        return false;
    }

    public static boolean isNavigationBarShowing(android.content.Context context) {
        if (hasNavBar(context)) {
            java.lang.String str = android.os.Build.BRAND;
            java.lang.String str2 = "navigationbar_is_min";
            if (!str.equalsIgnoreCase("HUAWEI")) {
                if (str.equalsIgnoreCase("XIAOMI")) {
                    str2 = "force_fsg_nav_bar";
                } else if (str.equalsIgnoreCase("VIVO") || str.equalsIgnoreCase("OPPO")) {
                    str2 = "navigation_gesture_on";
                }
            }
            if (android.provider.Settings.Global.getInt(context.getContentResolver(), str2, 0) == 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean isNetPath(java.lang.String str) {
        if (str == null) {
            return false;
        }
        if (str.startsWith(io.dcloud.common.adapter.util.DeviceInfo.HTTP_PROTOCOL) && !str.startsWith("http://localhost")) {
            return true;
        }
        if (str.startsWith(io.dcloud.common.adapter.util.DeviceInfo.HTTPS_PROTOCOL) && !str.startsWith("https://localhost")) {
            return true;
        }
        if (!str.startsWith("rtmp://") || str.startsWith("rtmp://localhost")) {
            return str.startsWith("rtsp://") && !str.startsWith("rtsp://localhost");
        }
        return true;
    }

    public static boolean isSafeEntryName(java.lang.String str) {
        return (str.contains(FILE_PATH_ENTRY_BACK) || str.contains("%")) ? false : true;
    }

    public static boolean isSameDay(long j, long j2) {
        java.util.GregorianCalendar gregorianCalendar = new java.util.GregorianCalendar();
        gregorianCalendar.setTimeInMillis(j);
        java.util.GregorianCalendar gregorianCalendar2 = new java.util.GregorianCalendar();
        gregorianCalendar2.setTimeInMillis(j2);
        return gregorianCalendar.get(1) == gregorianCalendar2.get(1) && gregorianCalendar.get(2) == gregorianCalendar2.get(2) && gregorianCalendar.get(5) == gregorianCalendar2.get(5);
    }

    public static boolean isSupportOaid() {
        java.lang.String str = android.os.Build.BRAND;
        int i = android.os.Build.VERSION.SDK_INT;
        if ((str.equalsIgnoreCase("honor") || str.equalsIgnoreCase("huawei")) && i >= 23) {
            return true;
        }
        if (!str.equalsIgnoreCase("vivo") || i < 28) {
            return (str.equalsIgnoreCase("xiaomi") && i >= 28) || i >= 29;
        }
        return true;
    }

    public static boolean isUniMPHostForUniApp() {
        return io.dcloud.common.adapter.util.PlatformUtil.checkClass("io.dcloud.feature.sdk.Interface.DCUniAppHost");
    }

    private static void loadProperties2HashMap(java.util.HashMap<java.lang.String, java.lang.String> map, java.lang.String str) {
        java.io.InputStream resInputStream = io.dcloud.common.adapter.util.PlatformUtil.getResInputStream(str);
        java.util.Properties properties = new java.util.Properties();
        try {
            try {
                properties.load(resInputStream);
                java.util.Enumeration<?> enumerationPropertyNames = properties.propertyNames();
                if (enumerationPropertyNames != null) {
                    while (enumerationPropertyNames.hasMoreElements()) {
                        java.lang.String str2 = (java.lang.String) enumerationPropertyNames.nextElement();
                        map.put(str2.toLowerCase(java.util.Locale.ENGLISH), (java.lang.String) properties.get(str2));
                    }
                }
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
        } finally {
            io.dcloud.common.util.IOUtil.close(resInputStream);
        }
    }

    public static java.lang.String makeQueryStringAllRegExp(java.lang.String str) {
        return android.text.TextUtils.isEmpty(str) ? str : str.replace("\\", "\\\\").replace("*", "\\*").replace(com.taobao.weex.el.parse.Operators.PLUS, "\\+").replace("|", "\\|").replace(com.taobao.weex.el.parse.Operators.BLOCK_START_STR, "\\{").replace(com.taobao.weex.el.parse.Operators.BLOCK_END_STR, "\\}").replace(com.taobao.weex.el.parse.Operators.BRACKET_START_STR, "\\(").replace(com.taobao.weex.el.parse.Operators.BRACKET_END_STR, "\\)").replace("^", "\\^").replace(com.taobao.weex.el.parse.Operators.DOLLAR_STR, "\\$").replace(com.taobao.weex.el.parse.Operators.ARRAY_START_STR, "\\[").replace(com.taobao.weex.el.parse.Operators.ARRAY_END_STR, "\\]").replace(com.taobao.weex.el.parse.Operators.CONDITION_IF_STRING, "\\?").replace(",", "\\,").replace(com.taobao.weex.el.parse.Operators.DOT_STR, "\\.").replace("&", "\\&").replace("'", "\\'");
    }

    private static boolean match(java.lang.String str, java.lang.String str2) {
        return java.util.regex.Pattern.compile(str).matcher(str2).find();
    }

    private static boolean matchArray(org.json.JSONArray jSONArray, java.lang.String str) {
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                if (match(jSONArray.optString(i), str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean navigationGestureEnabled(android.content.Context context) {
        int i;
        if (io.dcloud.common.adapter.util.DeviceInfo.sBrand.toLowerCase(java.util.Locale.ENGLISH).equals("xiaomi")) {
            i = android.os.Build.VERSION.SDK_INT >= 26 ? android.provider.Settings.Global.getInt(context.getContentResolver(), "force_fsg_nav_bar", 0) : 0;
        } else {
            i = android.provider.Settings.Secure.getInt(context.getContentResolver(), "navigation_gesture_on", 0);
        }
        return i != 0;
    }

    public static boolean parseBoolean(java.lang.String str, boolean z, boolean z2) {
        if (!isEmpty(str)) {
            if (str.equalsIgnoreCase(io.dcloud.common.constant.AbsoluteConst.TRUE)) {
                return !z2;
            }
            if (str.equalsIgnoreCase(io.dcloud.common.constant.AbsoluteConst.FALSE)) {
                return z2;
            }
        }
        return z;
    }

    public static float parseFloat(java.lang.String str, float f) {
        if (str == null) {
            return f;
        }
        try {
            return java.lang.Float.parseFloat(str);
        } catch (java.lang.Exception unused) {
            return f;
        }
    }

    public static int parseInt(java.lang.String str, int i) {
        if (str == null) {
            return i;
        }
        try {
            return java.lang.Integer.parseInt(str);
        } catch (java.lang.Exception unused) {
            return i;
        }
    }

    public static long parseLong(java.lang.String str, long j) {
        try {
            return java.lang.Long.parseLong(str);
        } catch (java.lang.Exception unused) {
            return j;
        }
    }

    public static int pxFromDp(float f, android.util.DisplayMetrics displayMetrics) {
        return java.lang.Math.round(android.util.TypedValue.applyDimension(1, f, displayMetrics));
    }

    public static int pxFromSp(float f, android.util.DisplayMetrics displayMetrics) {
        return java.lang.Math.round(android.util.TypedValue.applyDimension(2, f, displayMetrics));
    }

    public static android.graphics.Bitmap renderCroppedGreyscaleBitmap(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6) {
        int[] iArr = new int[i5 * i6];
        int i7 = (i4 * i) + i3;
        for (int i8 = 0; i8 < i6; i8++) {
            int i9 = i8 * i5;
            for (int i10 = 0; i10 < i5; i10++) {
                iArr[i9 + i10] = ((bArr[i7 + i10] & 255) * 65793) | (-16777216);
            }
            i7 += i;
        }
        android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(i5, i6, android.graphics.Bitmap.Config.ARGB_8888);
        bitmapCreateBitmap.setPixels(iArr, 0, i5, 0, 0, i5, i6);
        return bitmapCreateBitmap;
    }

    public static boolean saveBitmapToFile(android.graphics.Bitmap bitmap, java.lang.String str) {
        try {
            java.io.File file = new java.io.File(str);
            java.io.File parentFile = file.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            bitmap.compress(android.graphics.Bitmap.CompressFormat.PNG, 100, new java.io.FileOutputStream(file));
            return true;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static java.lang.String standardizedURL(java.lang.String str, java.lang.String str2) {
        java.lang.String strStripQuery = stripQuery(stripAnchor(str));
        if (str2.startsWith("./")) {
            str2 = str2.substring(2);
            int iLastIndexOf = strStripQuery.lastIndexOf(47);
            if (iLastIndexOf >= 0) {
                return strStripQuery.substring(0, iLastIndexOf + 1) + str2;
            }
        }
        int iIndexOf = str2.indexOf("../");
        int iLastIndexOf2 = strStripQuery.lastIndexOf(47);
        if (iLastIndexOf2 <= -1) {
            return str2;
        }
        java.lang.String strSubstring = strStripQuery.substring(0, iLastIndexOf2);
        while (iIndexOf > -1) {
            str2 = str2.substring(3);
            strSubstring = strSubstring.substring(0, strSubstring.lastIndexOf(47));
            iIndexOf = str2.indexOf("../");
        }
        return strSubstring + '/' + str2;
    }

    public static java.lang.String[] stringSplit(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
            return null;
        }
        int i = 0;
        java.util.StringTokenizer stringTokenizer = new java.util.StringTokenizer(str, str2, false);
        java.lang.String[] strArr = new java.lang.String[stringTokenizer.countTokens()];
        while (stringTokenizer.hasMoreElements()) {
            strArr[i] = stringTokenizer.nextToken().trim();
            i++;
        }
        return strArr;
    }

    /* JADX INFO: Removed unreachable split cross block B:67:0x00a6 */
    public static int stringToColor(java.lang.String str) {
        java.lang.String[] strArrStringSplit;
        int i;
        int i2;
        try {
            if (!isEmpty(str)) {
                str = str.trim();
            }
            int length = str.length();
            int i3 = 0;
            if (length != 4 && length != 7 && length != 3 && length != 6) {
                if (str.startsWith("#") && length > 1 && length < 10) {
                    return android.graphics.Color.parseColor(str);
                }
                if (str.startsWith("rgba")) {
                    strArrStringSplit = stringSplit(str.substring(5, str.length() - 1), ",");
                    i = 1;
                } else {
                    strArrStringSplit = str.startsWith("rgb") ? stringSplit(str.substring(4, str.length() - 1), ",") : null;
                    i = 0;
                }
                int i4 = 255;
                if (strArrStringSplit != null) {
                    try {
                        try {
                            try {
                                if (i == 0) {
                                    i = java.lang.Integer.parseInt(strArrStringSplit[0]);
                                    i3 = java.lang.Integer.parseInt(strArrStringSplit[1]);
                                    i2 = java.lang.Integer.parseInt(strArrStringSplit[2]);
                                } else {
                                    i = java.lang.Integer.parseInt(strArrStringSplit[0]);
                                    i3 = java.lang.Integer.parseInt(strArrStringSplit[1]);
                                    i2 = java.lang.Integer.parseInt(strArrStringSplit[2]);
                                    try {
                                        i4 = (int) (255 * java.lang.Float.parseFloat(strArrStringSplit[3]));
                                    } catch (java.lang.Exception unused) {
                                    }
                                }
                            } catch (java.lang.Exception unused2) {
                                i = 255;
                                i2 = 255;
                                i3 = 255;
                            }
                        } catch (java.lang.Exception unused3) {
                            i2 = 255;
                        }
                    } catch (java.lang.Exception unused4) {
                        i2 = 255;
                        i3 = 255;
                    }
                } else {
                    i = 255;
                    i2 = 255;
                    i3 = 255;
                }
                return (i4 << 24) + (i << 16) + (i3 << 8) + i2;
            }
            if (length == 4 || length == 7) {
                str = str.substring(1);
            }
            if (str.length() == 3) {
                java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
                while (i3 < 3) {
                    stringBuffer.append(str.charAt(i3)).append(str.charAt(i3));
                    i3++;
                }
                str = stringBuffer.toString();
            }
            return java.lang.Integer.parseInt(str, 16) - 16777216;
        } catch (java.lang.Exception unused5) {
            return -1;
        }
    }

    public static java.lang.String stripAnchor(java.lang.String str) {
        return android.webkit.URLUtil.stripAnchor(str);
    }

    public static java.lang.String stripQuery(java.lang.String str) {
        int iIndexOf = str.indexOf(63);
        return iIndexOf != -1 ? str.substring(0, iIndexOf) : str;
    }

    public static java.lang.String toHexFromColor(int i) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("#");
        java.lang.String hexString = java.lang.Integer.toHexString(android.graphics.Color.red(i));
        java.lang.String hexString2 = java.lang.Integer.toHexString(android.graphics.Color.green(i));
        java.lang.String hexString3 = java.lang.Integer.toHexString(android.graphics.Color.blue(i));
        if (hexString.length() == 1) {
            hexString = com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT + hexString;
        }
        if (hexString2.length() == 1) {
            hexString2 = com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT + hexString2;
        }
        if (hexString3.length() == 1) {
            hexString3 = com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT + hexString3;
        }
        java.lang.String upperCase = hexString.toUpperCase();
        java.lang.String upperCase2 = hexString2.toUpperCase();
        java.lang.String upperCase3 = hexString3.toUpperCase();
        sb.append(upperCase);
        sb.append(upperCase2);
        sb.append(upperCase3);
        return sb.toString();
    }

    public static void toast(android.content.Context context, java.lang.String str, android.graphics.Bitmap bitmap) {
        com.dcloud.android.widget.toast.ToastCompat toastCompatMakeText = com.dcloud.android.widget.toast.ToastCompat.makeText(context, (java.lang.CharSequence) str, 1);
        if (bitmap != null) {
            int height = bitmap.getHeight();
            int width = bitmap.getWidth();
            android.view.View view = toastCompatMakeText.getView();
            android.widget.ImageView imageView = new android.widget.ImageView(context);
            imageView.setImageBitmap(bitmap);
            ((android.view.ViewGroup) view).addView(imageView, 0);
            toastCompatMakeText.setText(str + " w=" + width + ";h=" + height);
        }
        toastCompatMakeText.setDuration(1);
        toastCompatMakeText.show();
    }

    public static int convertToScreenInt(java.lang.String str, int i, int i2, float f, boolean z) {
        if (str != null) {
            try {
                if (str.endsWith("px")) {
                    java.lang.String strSubstring = str.substring(0, str.length() - 2);
                    float f2 = ((strSubstring == null || !strSubstring.contains(com.taobao.weex.el.parse.Operators.DOT_STR)) ? java.lang.Integer.parseInt(strSubstring) : java.lang.Float.parseFloat(strSubstring)) * f;
                    return z ? java.lang.Math.round(f2) : (int) f2;
                }
                if (!str.endsWith("%")) {
                    double d = java.lang.Double.parseDouble(str) * ((double) f);
                    return z ? (int) java.lang.Math.round(d) : (int) d;
                }
                java.lang.String strSubstring2 = str.substring(0, str.length() - 1);
                if (!strSubstring2.contains(com.taobao.weex.el.parse.Operators.DOT_STR)) {
                    return (i * java.lang.Integer.parseInt(strSubstring2)) / 100;
                }
                float f3 = (i * java.lang.Float.parseFloat(strSubstring2)) / 100.0f;
                return z ? java.lang.Math.round(f3) : (int) f3;
            } catch (java.lang.NumberFormatException | java.lang.Exception unused) {
            }
        }
        return i2;
    }

    public static boolean isNavigationBarShow(android.app.Activity activity) {
        android.view.Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        android.graphics.Point point = new android.graphics.Point();
        android.graphics.Point point2 = new android.graphics.Point();
        defaultDisplay.getSize(point);
        defaultDisplay.getRealSize(point2);
        return point2.y != point.y;
    }

    public static float parseFloat(java.lang.String str, float f, float f2) {
        return parseFloat(str, f, f2, 1.0f);
    }

    public static int parseInt(java.lang.String str, int i, int i2) {
        if (str != null) {
            try {
                java.lang.String lowerCase = str.toLowerCase(java.util.Locale.ENGLISH);
                if (lowerCase.endsWith("px")) {
                    return java.lang.Integer.parseInt(lowerCase.substring(0, lowerCase.length() - 2));
                }
                if (lowerCase.endsWith("%")) {
                    java.lang.String strSubstring = lowerCase.substring(0, lowerCase.length() - 1);
                    return strSubstring.contains(com.taobao.weex.el.parse.Operators.DOT_STR) ? (int) ((i * java.lang.Float.parseFloat(strSubstring)) / 100.0f) : (i * java.lang.Integer.parseInt(strSubstring)) / 100;
                }
                if (lowerCase.startsWith("#")) {
                    lowerCase = "0x" + lowerCase.substring(1);
                }
                return lowerCase.startsWith("0x") ? java.lang.Integer.valueOf(lowerCase.substring(2), 16).intValue() : java.lang.Integer.parseInt(lowerCase);
            } catch (java.lang.NumberFormatException | java.lang.Exception unused) {
            }
        }
        return i2;
    }

    private static java.lang.String getNavBarOverride() {
        try {
            java.lang.reflect.Method declaredMethod = java.lang.Class.forName("android.os.SystemProperties").getDeclaredMethod("get", java.lang.String.class);
            declaredMethod.setAccessible(true);
            return (java.lang.String) declaredMethod.invoke(null, "qemu.hw.mainkeys");
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    public static float parseFloat(java.lang.String str, float f, float f2, float f3) {
        if (str != null) {
            java.lang.String lowerCase = str.toLowerCase(java.util.Locale.ENGLISH);
            if (lowerCase.endsWith("px")) {
                lowerCase = lowerCase.substring(0, lowerCase.length() - 2);
            }
            try {
                return java.lang.Float.parseFloat(lowerCase) * f3;
            } catch (java.lang.NumberFormatException unused) {
                if (lowerCase.endsWith("%")) {
                    try {
                        return (f * java.lang.Float.parseFloat(lowerCase.substring(0, lowerCase.length() - 1))) / 100.0f;
                    } catch (java.lang.Exception unused2) {
                    }
                }
            }
        }
        return f2;
    }

    public static boolean parseBoolean(java.lang.String str, boolean z) {
        return isEmpty(str) ? z : str.equalsIgnoreCase(io.dcloud.common.constant.AbsoluteConst.TRUE);
    }

    public static java.lang.Object getKeyByValue(java.util.HashMap map, java.lang.Object obj) {
        return getKeyByValue(map, obj, false);
    }

    public static void loadProperties2HashMap(java.util.HashMap<java.lang.String, java.lang.String> map, java.util.HashMap<java.lang.String, java.lang.String> map2, java.util.HashMap<java.lang.String, java.util.HashMap<java.lang.String, java.lang.String>> map3, java.lang.String str) {
        io.dcloud.common.util.XmlUtil.DHNode dHNodeXML_Parser;
        java.io.InputStream resInputStream = io.dcloud.common.adapter.util.PlatformUtil.getResInputStream(str);
        if (resInputStream == null || (dHNodeXML_Parser = io.dcloud.common.util.XmlUtil.XML_Parser(resInputStream)) == null) {
            return;
        }
        java.util.ArrayList<io.dcloud.common.util.XmlUtil.DHNode> elements = io.dcloud.common.util.XmlUtil.getElements(io.dcloud.common.util.XmlUtil.getElement(dHNodeXML_Parser, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_FEATURES), io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_FEATURE);
        int i = 0;
        if (elements != null && !elements.isEmpty()) {
            int size = elements.size();
            int i2 = 0;
            while (i2 < size) {
                io.dcloud.common.util.XmlUtil.DHNode dHNode = elements.get(i2);
                i2++;
                io.dcloud.common.util.XmlUtil.DHNode dHNode2 = dHNode;
                java.lang.String lowerCase = io.dcloud.common.util.XmlUtil.getAttributeValue(dHNode2, "name").toLowerCase(java.util.Locale.ENGLISH);
                java.lang.String attributeValue = io.dcloud.common.util.XmlUtil.getAttributeValue(dHNode2, "value");
                if (io.dcloud.common.constant.AbsoluteConst.F_UI.equals(lowerCase)) {
                    map2.put("webview", attributeValue);
                }
                map2.put(lowerCase, attributeValue);
                java.util.ArrayList<io.dcloud.common.util.XmlUtil.DHNode> elements2 = io.dcloud.common.util.XmlUtil.getElements(dHNode2, "module");
                if (elements2 != null && !elements2.isEmpty()) {
                    java.util.HashMap<java.lang.String, java.lang.String> linkedHashMap = map3.get(lowerCase);
                    if (linkedHashMap == null) {
                        linkedHashMap = new java.util.LinkedHashMap<>(2);
                        map3.put(lowerCase, linkedHashMap);
                    }
                    int size2 = elements2.size();
                    int i3 = 0;
                    while (i3 < size2) {
                        io.dcloud.common.util.XmlUtil.DHNode dHNode3 = elements2.get(i3);
                        i3++;
                        io.dcloud.common.util.XmlUtil.DHNode dHNode4 = dHNode3;
                        linkedHashMap.put(io.dcloud.common.util.XmlUtil.getAttributeValue(dHNode4, "name").toLowerCase(java.util.Locale.ENGLISH), io.dcloud.common.util.XmlUtil.getAttributeValue(dHNode4, "value"));
                    }
                }
            }
        }
        java.util.ArrayList<io.dcloud.common.util.XmlUtil.DHNode> elements3 = io.dcloud.common.util.XmlUtil.getElements(io.dcloud.common.util.XmlUtil.getElement(dHNodeXML_Parser, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_SERVICES), "service");
        if (elements3 == null || elements3.isEmpty()) {
            return;
        }
        int size3 = elements3.size();
        while (i < size3) {
            io.dcloud.common.util.XmlUtil.DHNode dHNode5 = elements3.get(i);
            i++;
            io.dcloud.common.util.XmlUtil.DHNode dHNode6 = dHNode5;
            map.put(io.dcloud.common.util.XmlUtil.getAttributeValue(dHNode6, "name").toLowerCase(java.util.Locale.ENGLISH), io.dcloud.common.util.XmlUtil.getAttributeValue(dHNode6, "value"));
        }
    }
}
