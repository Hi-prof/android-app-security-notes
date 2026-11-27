package com.taobao.weex.utils;

/* JADX INFO: loaded from: classes.dex */
public class FontDO {
    public static final int STATE_FAILED = 3;
    public static final int STATE_INIT = 0;
    public static final int STATE_INVALID = -1;
    public static final int STATE_LOADING = 1;
    public static final int STATE_SUCCESS = 2;
    public static final int TYPE_BASE64 = 5;
    public static final int TYPE_FILE = 2;
    public static final int TYPE_LOCAL = 3;
    public static final int TYPE_NATIVE = 4;
    public static final int TYPE_NETWORK = 1;
    public static final int TYPE_UNKNOWN = 0;
    private java.lang.String mFilePath;
    private final java.lang.String mFontFamilyName;
    private android.graphics.Typeface mTypeface;
    private java.lang.String mUrl = "";
    private int mType = 4;
    private int mState = 2;

    public FontDO(java.lang.String str, java.lang.String str2, com.taobao.weex.WXSDKInstance wXSDKInstance) {
        this.mFontFamilyName = str;
        parseSrc(str2, wXSDKInstance);
    }

    public FontDO(java.lang.String str, android.graphics.Typeface typeface) {
        this.mFontFamilyName = str;
        this.mTypeface = typeface;
    }

    public java.lang.String getFontFamilyName() {
        return this.mFontFamilyName;
    }

    private void parseSrc(java.lang.String str, com.taobao.weex.WXSDKInstance wXSDKInstance) {
        java.lang.String strTrim = str != null ? str.trim() : "";
        if (wXSDKInstance != null && wXSDKInstance.getCustomFontNetworkHandler() != null) {
            java.lang.String strFetchLocal = wXSDKInstance.getCustomFontNetworkHandler().fetchLocal(strTrim);
            if (!android.text.TextUtils.isEmpty(strFetchLocal)) {
                strTrim = strFetchLocal;
            }
        }
        if (strTrim.isEmpty()) {
            this.mState = -1;
            com.taobao.weex.utils.WXLogUtils.e("TypefaceUtil", "font src is empty.");
            return;
        }
        if (strTrim.matches("^url\\((('.*')|(\".*\"))\\)$")) {
            android.net.Uri uriRewriteUri = android.net.Uri.parse(strTrim.substring(5, strTrim.length() - 2));
            if (wXSDKInstance != null) {
                uriRewriteUri = wXSDKInstance.rewriteUri(uriRewriteUri, io.dcloud.feature.uniapp.adapter.AbsURIAdapter.FONT);
            }
            this.mUrl = uriRewriteUri.toString();
            try {
                java.lang.String scheme = uriRewriteUri.getScheme();
                if ("http".equals(scheme) || "https".equals(scheme)) {
                    this.mType = 1;
                } else if ("file".equals(scheme)) {
                    this.mType = 2;
                    this.mUrl = uriRewriteUri.getEncodedSchemeSpecificPart();
                } else if (com.taobao.weex.common.Constants.Scheme.LOCAL.equals(scheme)) {
                    this.mType = 3;
                } else if ("data".equals(scheme)) {
                    long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
                    java.lang.String[] strArrSplit = this.mUrl.split(",");
                    if (strArrSplit != null && strArrSplit.length == 2) {
                        java.lang.String str2 = strArrSplit[0];
                        if (!android.text.TextUtils.isEmpty(str2) && str2.endsWith("base64")) {
                            java.lang.String str3 = strArrSplit[1];
                            if (!android.text.TextUtils.isEmpty(str3)) {
                                java.lang.String strMd5 = com.taobao.weex.utils.WXFileUtils.md5(str3);
                                java.io.File file = new java.io.File(com.taobao.weex.WXEnvironment.getApplication().getCacheDir(), com.taobao.weex.utils.TypefaceUtil.FONT_CACHE_DIR_NAME);
                                if (!file.exists()) {
                                    file.mkdirs();
                                }
                                java.io.File file2 = new java.io.File(file, strMd5);
                                if (!file2.exists()) {
                                    file2.createNewFile();
                                    com.taobao.weex.utils.WXFileUtils.saveFile(file2.getPath(), android.util.Base64.decode(str3, 0), com.taobao.weex.WXEnvironment.getApplication());
                                }
                                this.mUrl = file2.getPath();
                                this.mType = 5;
                                com.taobao.weex.utils.WXLogUtils.d("TypefaceUtil", "Parse base64 font cost " + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
                            }
                        }
                    }
                } else {
                    com.taobao.weex.utils.WXLogUtils.e("TypefaceUtil", "Unknown scheme for font url: " + this.mUrl);
                    this.mType = 0;
                }
                this.mState = 0;
            } catch (java.lang.Exception e) {
                this.mType = -1;
                com.taobao.weex.utils.WXLogUtils.e("TypefaceUtil", "URI.create(mUrl) failed mUrl: " + this.mUrl + "\n" + com.taobao.weex.utils.WXLogUtils.getStackTrace(e));
            }
        } else {
            this.mUrl = strTrim;
            this.mState = -1;
        }
        if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
            com.taobao.weex.utils.WXLogUtils.d("TypefaceUtil", "src:" + strTrim + ", mUrl:" + this.mUrl + ", mType:" + this.mType);
        }
    }

    public java.lang.String getUrl() {
        return this.mUrl;
    }

    public int getType() {
        return this.mType;
    }

    public android.graphics.Typeface getTypeface() {
        return this.mTypeface;
    }

    public void setTypeface(android.graphics.Typeface typeface) {
        this.mTypeface = typeface;
    }

    public int getState() {
        return this.mState;
    }

    public void setState(int i) {
        this.mState = i;
    }

    public java.lang.String getFilePath() {
        return this.mFilePath;
    }

    public void setFilePath(java.lang.String str) {
        this.mFilePath = str;
    }
}
