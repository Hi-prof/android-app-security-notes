package com.taobao.weex.utils;

/* JADX INFO: loaded from: classes.dex */
public class TypefaceUtil {
    public static final java.lang.String ACTION_TYPE_FACE_AVAILABLE = "type_face_available";
    public static final java.lang.String FONT_CACHE_DIR_NAME = "font-family";
    private static final java.lang.String TAG = "TypefaceUtil";
    private static final java.util.Map<java.lang.String, com.taobao.weex.utils.FontDO> sCacheMap = new java.util.HashMap();

    public static void putFontDO(com.taobao.weex.utils.FontDO fontDO) {
        if (fontDO == null || android.text.TextUtils.isEmpty(fontDO.getFontFamilyName())) {
            return;
        }
        sCacheMap.put(fontDO.getFontFamilyName(), fontDO);
    }

    public static void registerNativeFont(java.util.Map<java.lang.String, android.graphics.Typeface> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        for (java.util.Map.Entry<java.lang.String, android.graphics.Typeface> entry : map.entrySet()) {
            putFontDO(new com.taobao.weex.utils.FontDO(entry.getKey(), entry.getValue()));
            if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
                com.taobao.weex.utils.WXLogUtils.d(TAG, "register new typeface: " + entry.getKey());
            }
        }
    }

    public static com.taobao.weex.utils.FontDO getFontDO(java.lang.String str) {
        return sCacheMap.get(str);
    }

    public static void removeFontDO(java.lang.String str) {
        sCacheMap.remove(str);
    }

    public static void applyFontStyle(android.graphics.Paint paint, int i, int i2, java.lang.String str) {
        android.graphics.Typeface typeface = paint.getTypeface();
        int style = typeface == null ? 0 : typeface.getStyle();
        int i3 = 1;
        if (i2 != 1 && ((style & 1) == 0 || i2 != -1)) {
            i3 = 0;
        }
        if (i == 2 || ((style & 2) != 0 && i == -1)) {
            i3 |= 2;
        }
        if (str != null) {
            typeface = getOrCreateTypeface(str, i3);
        }
        if (typeface != null) {
            paint.setTypeface(android.graphics.Typeface.create(typeface, i3));
        } else {
            paint.setTypeface(android.graphics.Typeface.defaultFromStyle(i3));
        }
        if (i >= 0) {
            paint.setTextSkewX(((i & (~(paint.getTypeface() != null ? paint.getTypeface().getStyle() : 0))) & 2) != 0 ? -0.2f : 0.0f);
        }
    }

    public static android.graphics.Typeface getOrCreateTypeface(java.lang.String str, int i) {
        com.taobao.weex.utils.FontDO fontDO = sCacheMap.get(str);
        if (fontDO != null && fontDO.getTypeface() != null) {
            return fontDO.getTypeface();
        }
        return android.graphics.Typeface.create(str, i);
    }

    private static void loadFromAsset(com.taobao.weex.utils.FontDO fontDO, java.lang.String str) {
        try {
            android.graphics.Typeface typefaceCreateFromAsset = android.graphics.Typeface.createFromAsset(com.taobao.weex.WXEnvironment.getApplication().getAssets(), str);
            if (typefaceCreateFromAsset == null) {
                com.taobao.weex.utils.WXLogUtils.e(TAG, "Font asset file not found " + fontDO.getUrl());
            } else {
                if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
                    com.taobao.weex.utils.WXLogUtils.d(TAG, "load asset file success");
                }
                fontDO.setState(2);
                fontDO.setTypeface(typefaceCreateFromAsset);
            }
        } catch (java.lang.Exception e) {
            com.taobao.weex.utils.WXLogUtils.e(TAG, e.toString());
        }
    }

    public static void loadTypeface(com.taobao.weex.utils.FontDO fontDO, boolean z) {
        if (fontDO == null || fontDO.getTypeface() != null || (fontDO.getState() != 3 && fontDO.getState() != 0)) {
            if (z) {
                notifyFontAvailable(false, fontDO);
                return;
            }
            return;
        }
        fontDO.setState(1);
        if (fontDO.getType() == 3) {
            loadFromAsset(fontDO, android.net.Uri.parse(fontDO.getUrl()).getPath().substring(1));
            return;
        }
        if (fontDO.getType() == 1) {
            java.lang.String url = fontDO.getUrl();
            java.lang.String fontFamilyName = fontDO.getFontFamilyName();
            java.lang.String strMd5 = com.taobao.weex.utils.WXFileUtils.md5(url);
            java.io.File file = new java.io.File(getFontCacheDir());
            if (!file.exists()) {
                file.mkdirs();
            }
            java.lang.String str = file.getAbsolutePath() + java.io.File.separator + strMd5;
            if (loadLocalFontFile(str, fontFamilyName, false)) {
                return;
            }
            downloadFontByNetwork(url, str, fontFamilyName);
            return;
        }
        if ((fontDO.getType() == 2 || fontDO.getType() == 5) && !loadLocalFontFile(fontDO.getUrl(), fontDO.getFontFamilyName(), false)) {
            fontDO.setState(3);
        }
    }

    private static void downloadFontByNetwork(final java.lang.String str, final java.lang.String str2, final java.lang.String str3) {
        com.taobao.weex.adapter.IWXHttpAdapter iWXHttpAdapter = com.taobao.weex.WXSDKManager.getInstance().getIWXHttpAdapter();
        if (iWXHttpAdapter == null) {
            com.taobao.weex.utils.WXLogUtils.e(TAG, "downloadFontByNetwork() IWXHttpAdapter == null");
            return;
        }
        com.taobao.weex.common.WXRequest wXRequest = new com.taobao.weex.common.WXRequest();
        wXRequest.url = str;
        wXRequest.method = "GET";
        iWXHttpAdapter.sendRequest(wXRequest, new com.taobao.weex.adapter.IWXHttpAdapter.OnHttpListener() { // from class: com.taobao.weex.utils.TypefaceUtil.1
            @Override // com.taobao.weex.adapter.IWXHttpAdapter.OnHttpListener
            public void onHeadersReceived(int i, java.util.Map<java.lang.String, java.util.List<java.lang.String>> map) {
            }

            @Override // com.taobao.weex.adapter.IWXHttpAdapter.OnHttpListener
            public void onHttpResponseProgress(int i) {
            }

            @Override // com.taobao.weex.adapter.IWXHttpAdapter.OnHttpListener
            public void onHttpUploadProgress(int i) {
            }

            @Override // com.taobao.weex.adapter.IWXHttpAdapter.OnHttpListener
            public void onHttpStart() {
                if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
                    com.taobao.weex.utils.WXLogUtils.d(com.taobao.weex.utils.TypefaceUtil.TAG, "downloadFontByNetwork begin url:" + str);
                }
            }

            @Override // com.taobao.weex.adapter.IWXHttpAdapter.OnHttpListener
            public void onHttpFinish(com.taobao.weex.common.WXResponse wXResponse) {
                int i;
                com.taobao.weex.utils.FontDO fontDO;
                boolean zSaveFile = false;
                if (android.text.TextUtils.isEmpty(wXResponse.statusCode)) {
                    i = 0;
                } else {
                    try {
                        i = java.lang.Integer.parseInt(wXResponse.statusCode);
                    } catch (java.lang.NumberFormatException unused) {
                        com.taobao.weex.utils.WXLogUtils.e(com.taobao.weex.utils.TypefaceUtil.TAG, "IWXHttpAdapter onHttpFinish statusCode:" + wXResponse.statusCode);
                        i = 0;
                    }
                }
                if (i >= 200 && i <= 299 && wXResponse.originalData != null) {
                    zSaveFile = com.taobao.weex.utils.WXFileUtils.saveFile(str2, wXResponse.originalData, com.taobao.weex.WXEnvironment.getApplication());
                    if (zSaveFile) {
                        zSaveFile = com.taobao.weex.utils.TypefaceUtil.loadLocalFontFile(str2, str3, true);
                    } else if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
                        com.taobao.weex.utils.WXLogUtils.d(com.taobao.weex.utils.TypefaceUtil.TAG, "downloadFontByNetwork() onHttpFinish success, but save file failed.");
                    }
                }
                if (zSaveFile || (fontDO = (com.taobao.weex.utils.FontDO) com.taobao.weex.utils.TypefaceUtil.sCacheMap.get(str3)) == null) {
                    return;
                }
                fontDO.setState(3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean loadLocalFontFile(java.lang.String str, java.lang.String str2, boolean z) {
        if (!android.text.TextUtils.isEmpty(str) && !android.text.TextUtils.isEmpty(str2)) {
            try {
                if (!new java.io.File(str).exists()) {
                    return false;
                }
                android.graphics.Typeface typefaceCreateFromFile = android.graphics.Typeface.createFromFile(str);
                if (typefaceCreateFromFile == null) {
                    com.taobao.weex.utils.WXLogUtils.e(TAG, "load local font file failed, can't create font.");
                } else {
                    final com.taobao.weex.utils.FontDO fontDO = sCacheMap.get(str2);
                    if (fontDO != null) {
                        fontDO.setState(2);
                        fontDO.setTypeface(typefaceCreateFromFile);
                        fontDO.setFilePath(str);
                        if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
                            com.taobao.weex.utils.WXLogUtils.d(TAG, "load local font file success");
                        }
                        if (z) {
                            com.taobao.weex.WXSDKManager.getInstance().getWXRenderManager().postOnUiThread(new java.lang.Runnable() { // from class: com.taobao.weex.utils.TypefaceUtil.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    com.taobao.weex.utils.TypefaceUtil.notifyFontAvailable(true, fontDO);
                                }
                            }, 100L);
                        } else {
                            notifyFontAvailable(true, fontDO);
                        }
                        return true;
                    }
                }
            } catch (java.lang.Exception e) {
                com.taobao.weex.utils.WXLogUtils.e(TAG, e.toString());
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void notifyFontAvailable(boolean z, com.taobao.weex.utils.FontDO fontDO) {
        if (z) {
            android.content.Intent intent = new android.content.Intent(ACTION_TYPE_FACE_AVAILABLE);
            intent.putExtra(com.taobao.weex.common.Constants.Name.FONT_FAMILY, fontDO.getFontFamilyName());
            intent.putExtra("filePath", fontDO.getFilePath());
            intent.putExtra("fontUrl", fontDO.getUrl());
            androidx.localbroadcastmanager.content.LocalBroadcastManager.getInstance(com.taobao.weex.WXEnvironment.getApplication()).sendBroadcast(intent);
        }
        com.taobao.weex.font.FontAdapter fontAdapter = com.taobao.weex.WXSDKManager.getInstance().getFontAdapter();
        if (fontAdapter != null) {
            fontAdapter.onFontLoad(fontDO.getFontFamilyName(), fontDO.getUrl(), fontDO.getFilePath());
        }
    }

    private static java.lang.String getFontCacheDir() {
        return com.taobao.weex.WXEnvironment.getApplication().getCacheDir() + "/font-family";
    }
}
