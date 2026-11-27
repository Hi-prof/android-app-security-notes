package com.taobao.weex.utils;

/* JADX INFO: loaded from: classes.dex */
public class WXUtils {
    private static final int HUNDRED = 100;
    public static final char PERCENT = '%';
    static final androidx.collection.LruCache<java.lang.String, java.lang.Integer> sCache = new androidx.collection.LruCache<>(64);
    private static final long sInterval = java.lang.System.currentTimeMillis() - android.os.SystemClock.uptimeMillis();

    public static androidx.collection.LruCache getCache() {
        return sCache;
    }

    public static boolean isUiThread() {
        return java.lang.Thread.currentThread().getId() == android.os.Looper.getMainLooper().getThread().getId();
    }

    public static boolean isUndefined(float f) {
        return java.lang.Float.isNaN(f);
    }

    public static float getFloatByViewport(java.lang.Object obj, float f) {
        return floatByViewport(obj, f);
    }

    public static float getFloatByViewport(java.lang.Object obj, int i) {
        return floatByViewport(obj, i);
    }

    private static float floatByViewport(java.lang.Object obj, float f) {
        if (obj == null) {
            return Float.NaN;
        }
        java.lang.String strTrim = obj.toString().trim();
        if ("auto".equals(strTrim) || com.taobao.weex.common.Constants.Name.UNDEFINED.equals(strTrim) || android.text.TextUtils.isEmpty(strTrim)) {
            com.taobao.weex.utils.WXLogUtils.e("Argument Warning ! value is " + strTrim + "And default Value:NaN");
            return Float.NaN;
        }
        if (strTrim.endsWith("wx")) {
            try {
                return transferWx(strTrim, f);
            } catch (java.lang.NumberFormatException e) {
                com.taobao.weex.utils.WXLogUtils.e("Argument format error! value is " + obj, e);
            } catch (java.lang.Exception e2) {
                com.taobao.weex.utils.WXLogUtils.e("Argument error! value is " + obj, e2);
            }
        } else if (strTrim.endsWith("px")) {
            if (strTrim.length() > 3 && (strTrim.endsWith("rpx") || strTrim.endsWith("upx"))) {
                try {
                    return transferRpxAndUpx(strTrim.substring(0, strTrim.length() - 3), 750.0f);
                } catch (java.lang.NumberFormatException e3) {
                    com.taobao.weex.utils.WXLogUtils.e("Argument format error! value is " + obj, e3);
                } catch (java.lang.Exception e4) {
                    com.taobao.weex.utils.WXLogUtils.e("Argument error! value is " + obj, e4);
                }
            } else {
                try {
                    return java.lang.Float.parseFloat(strTrim.substring(0, strTrim.indexOf("px")));
                } catch (java.lang.NumberFormatException e5) {
                    com.taobao.weex.utils.WXLogUtils.e("Argument format error! value is " + obj, e5);
                } catch (java.lang.Exception e6) {
                    com.taobao.weex.utils.WXLogUtils.e("Argument error! value is " + obj, e6);
                }
            }
        } else {
            try {
                return java.lang.Float.parseFloat(strTrim);
            } catch (java.lang.NumberFormatException e7) {
                com.taobao.weex.utils.WXLogUtils.e("Argument format error! value is " + obj, e7);
            } catch (java.lang.Exception e8) {
                com.taobao.weex.utils.WXLogUtils.e("Argument error! value is " + obj, e8);
            }
        }
        return Float.NaN;
    }

    public static float getFloat(java.lang.Object obj) {
        return getFloat(obj, java.lang.Float.valueOf(Float.NaN)).floatValue();
    }

    public static java.lang.Float getFloat(java.lang.Object obj, java.lang.Float f) {
        if (obj != null) {
            java.lang.String strTrim = obj.toString().trim();
            if ("auto".equals(strTrim) || com.taobao.weex.common.Constants.Name.UNDEFINED.equals(strTrim) || android.text.TextUtils.isEmpty(strTrim)) {
                com.taobao.weex.utils.WXLogUtils.e("Argument Warning ! value is " + strTrim + "And default Value:NaN");
                return f;
            }
            if (strTrim.endsWith("wx")) {
                try {
                    return java.lang.Float.valueOf(transferWx(strTrim, 750.0f));
                } catch (java.lang.NumberFormatException e) {
                    com.taobao.weex.utils.WXLogUtils.e("Argument format error! value is " + obj, e);
                } catch (java.lang.Exception e2) {
                    com.taobao.weex.utils.WXLogUtils.e("Argument error! value is " + obj, e2);
                }
            } else if (strTrim.endsWith("px")) {
                if (strTrim.length() > 3 && (strTrim.endsWith("rpx") || strTrim.endsWith("upx"))) {
                    try {
                        return java.lang.Float.valueOf(transferRpxAndUpx(strTrim.substring(0, strTrim.length() - 3), 750.0f));
                    } catch (java.lang.NumberFormatException e3) {
                        com.taobao.weex.utils.WXLogUtils.e("Argument format error! value is " + obj, e3);
                    } catch (java.lang.Exception e4) {
                        com.taobao.weex.utils.WXLogUtils.e("Argument error! value is " + obj, e4);
                    }
                } else {
                    try {
                        return java.lang.Float.valueOf(java.lang.Float.parseFloat(strTrim.substring(0, strTrim.indexOf("px"))));
                    } catch (java.lang.NumberFormatException e5) {
                        com.taobao.weex.utils.WXLogUtils.e("Argument format error! value is " + obj, e5);
                    } catch (java.lang.Exception e6) {
                        com.taobao.weex.utils.WXLogUtils.e("Argument error! value is " + obj, e6);
                    }
                }
            } else {
                try {
                    return java.lang.Float.valueOf(java.lang.Float.parseFloat(strTrim));
                } catch (java.lang.NumberFormatException e7) {
                    com.taobao.weex.utils.WXLogUtils.e("Argument format error! value is " + obj, e7);
                } catch (java.lang.Exception e8) {
                    com.taobao.weex.utils.WXLogUtils.e("Argument error! value is " + obj, e8);
                }
            }
        }
        return f;
    }

    private static float transferWx(java.lang.String str, float f) {
        if (str == null) {
            return 0.0f;
        }
        if (str.endsWith("wx")) {
            str = str.substring(0, str.indexOf("wx"));
        }
        float f2 = java.lang.Float.parseFloat(str);
        java.lang.Float fValueOf = java.lang.Float.valueOf(f2);
        float f3 = com.taobao.weex.WXEnvironment.sApplication.getResources().getDisplayMetrics().density;
        fValueOf.getClass();
        return ((f3 * f2) * f) / com.taobao.weex.utils.WXViewUtils.getScreenWidth();
    }

    private static float transferRpxAndUpx(java.lang.String str, float f) {
        if (str == null) {
            return 0.0f;
        }
        if (str.endsWith("rpx")) {
            str = str.substring(0, str.indexOf("rpx"));
        } else if (str.endsWith("upx")) {
            str = str.substring(0, str.indexOf("upx"));
        }
        float f2 = java.lang.Float.parseFloat(str);
        java.lang.Float fValueOf = java.lang.Float.valueOf(f2);
        float viewProt = com.taobao.weex.WXEnvironment.getViewProt() / f;
        fValueOf.getClass();
        return viewProt * f2;
    }

    public static float fastGetFloat(java.lang.String str, float f) {
        int i;
        boolean z;
        char cCharAt;
        char cCharAt2;
        float f2 = 0.0f;
        if (android.text.TextUtils.isEmpty(str)) {
            return 0.0f;
        }
        if (str.charAt(0) == '-') {
            i = 1;
            z = false;
        } else {
            i = str.charAt(0) == '+' ? 1 : 0;
            z = true;
        }
        while (i < str.length() && (cCharAt2 = str.charAt(i)) >= '0' && cCharAt2 <= '9') {
            f2 = ((f2 * 10.0f) + cCharAt2) - 48.0f;
            i++;
        }
        if (i < str.length() && str.charAt(i) == '.') {
            int i2 = i + 1;
            int i3 = 10;
            for (int i4 = 0; i2 < str.length() && i4 < f && (cCharAt = str.charAt(i2)) >= '0' && cCharAt <= '9'; i4++) {
                f2 += (cCharAt - '0') / i3;
                i3 *= 10;
                i2++;
            }
        }
        return !z ? f2 * (-1.0f) : f2;
    }

    public static float fastGetFloat(java.lang.String str) {
        return fastGetFloat(str, 2.1474836E9f);
    }

    public static int parseInt(java.lang.String str) {
        try {
            if (android.text.TextUtils.isEmpty(str) || str.contains(com.taobao.weex.el.parse.Operators.DOT_STR)) {
                return 0;
            }
            return java.lang.Integer.parseInt(str);
        } catch (java.lang.NumberFormatException e) {
            if (!com.taobao.weex.WXEnvironment.isApkDebugable()) {
                return 0;
            }
            com.taobao.weex.utils.WXLogUtils.e(com.taobao.weex.utils.WXLogUtils.getStackTrace(e));
            return 0;
        }
    }

    public static int parseInt(java.lang.Object obj) {
        return parseInt(java.lang.String.valueOf(obj));
    }

    public static float parseFloat(java.lang.Object obj) {
        return parseFloat(java.lang.String.valueOf(obj));
    }

    public static float parseFloat(java.lang.String str) {
        try {
            if (!android.text.TextUtils.isEmpty(str) && !android.text.TextUtils.equals(str, "null")) {
                return java.lang.Float.parseFloat(str);
            }
            if (!com.taobao.weex.WXEnvironment.isApkDebugable()) {
                return 0.0f;
            }
            com.taobao.weex.utils.WXLogUtils.e("WXUtils parseFloat illegal value is " + str);
            return 0.0f;
        } catch (java.lang.NumberFormatException e) {
            if (!com.taobao.weex.WXEnvironment.isApkDebugable()) {
                return 0.0f;
            }
            com.taobao.weex.utils.WXLogUtils.e(com.taobao.weex.utils.WXLogUtils.getStackTrace(e));
            return 0.0f;
        }
    }

    public static int getInt(java.lang.Object obj) {
        return getInteger(obj, 0).intValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v16, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v23, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r9v24 */
    /* JADX WARN: Type inference failed for: r9v25 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static java.lang.Integer getInteger(java.lang.Object obj, java.lang.Integer num) {
        java.lang.String strSubstring;
        if (obj == 0) {
            return num;
        }
        java.lang.String strTrim = obj.toString().trim();
        java.lang.Integer num2 = sCache.get(strTrim);
        if (num2 != null) {
            return num2;
        }
        if (strTrim.length() < 2) {
            strSubstring = "";
        } else {
            strSubstring = strTrim.substring(strTrim.length() - 2, strTrim.length());
        }
        if (android.text.TextUtils.equals("wx", strSubstring)) {
            if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
                com.taobao.weex.utils.WXLogUtils.w("the value of " + obj + " use wx unit, which will be not supported soon after.");
            }
            try {
                obj = java.lang.Integer.valueOf((int) transferWx(strTrim, 750.0f));
            } catch (java.lang.NumberFormatException e) {
                com.taobao.weex.utils.WXLogUtils.e("Argument format error! value is " + obj, e);
                obj = num;
            } catch (java.lang.Exception e2) {
                com.taobao.weex.utils.WXLogUtils.e("Argument error! value is " + obj, e2);
                obj = num;
            }
        } else if (android.text.TextUtils.equals("px", strSubstring)) {
            if (strTrim.length() > 3 && (strTrim.endsWith("rpx") || strTrim.endsWith("upx"))) {
                try {
                    obj = java.lang.Integer.valueOf((int) transferRpxAndUpx(strTrim.substring(0, strTrim.length() - 3), 750.0f));
                } catch (java.lang.NumberFormatException e3) {
                    com.taobao.weex.utils.WXLogUtils.e("Argument format error! value is " + obj, e3);
                    obj = num;
                } catch (java.lang.Exception e4) {
                    com.taobao.weex.utils.WXLogUtils.e("Argument error! value is " + obj, e4);
                    obj = num;
                }
            } else {
                try {
                    java.lang.String strSubstring2 = strTrim.substring(0, strTrim.length() - 2);
                    if (!android.text.TextUtils.isEmpty(strSubstring2) && strSubstring2.contains(com.taobao.weex.el.parse.Operators.DOT_STR)) {
                        obj = java.lang.Integer.valueOf((int) parseFloat(strSubstring2));
                    } else {
                        obj = java.lang.Integer.valueOf(java.lang.Integer.parseInt(strSubstring2));
                    }
                } catch (java.lang.NumberFormatException e5) {
                    com.taobao.weex.utils.WXLogUtils.e("Argument format error! value is " + obj, e5);
                    obj = num;
                } catch (java.lang.Exception e6) {
                    com.taobao.weex.utils.WXLogUtils.e("Argument error! value is " + obj, e6);
                    obj = num;
                }
            }
        } else {
            try {
                if (!android.text.TextUtils.isEmpty(strTrim)) {
                    if (strTrim.contains(com.taobao.weex.el.parse.Operators.DOT_STR)) {
                        obj = java.lang.Integer.valueOf((int) parseFloat(strTrim));
                    } else {
                        obj = java.lang.Integer.valueOf(java.lang.Integer.parseInt(strTrim));
                    }
                } else {
                    if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
                        com.taobao.weex.utils.WXLogUtils.e("Argument value is null, df is" + num);
                    }
                    obj = num;
                }
            } catch (java.lang.NumberFormatException e7) {
                com.taobao.weex.utils.WXLogUtils.e("Argument format error! value is " + obj, e7);
            } catch (java.lang.Exception e8) {
                com.taobao.weex.utils.WXLogUtils.e("Argument error! value is " + obj, e8);
            }
        }
        if (obj != 0 && !obj.equals(num)) {
            sCache.put(strTrim, obj);
        }
        return obj;
    }

    @java.lang.Deprecated
    public static long getLong(java.lang.Object obj) {
        if (obj == null) {
            return 0L;
        }
        java.lang.String strTrim = obj.toString().trim();
        if (strTrim.endsWith("wx")) {
            if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
                com.taobao.weex.utils.WXLogUtils.w("the value of " + obj + " use wx unit, which will be not supported soon after.");
            }
            try {
                return (long) transferWx(strTrim, 750.0f);
            } catch (java.lang.NumberFormatException e) {
                com.taobao.weex.utils.WXLogUtils.e("Argument format error! value is " + obj, e);
            } catch (java.lang.Exception e2) {
                com.taobao.weex.utils.WXLogUtils.e("Argument error! value is " + obj, e2);
            }
        } else if (strTrim.endsWith("px")) {
            if (strTrim.length() > 3 && (strTrim.endsWith("rpx") || strTrim.endsWith("upx"))) {
                try {
                    return (long) transferRpxAndUpx(strTrim.substring(0, strTrim.length() - 3), 750.0f);
                } catch (java.lang.NumberFormatException e3) {
                    com.taobao.weex.utils.WXLogUtils.e("Argument format error! value is " + obj, e3);
                } catch (java.lang.Exception e4) {
                    com.taobao.weex.utils.WXLogUtils.e("Argument error! value is " + obj, e4);
                }
            } else {
                try {
                    return java.lang.Long.parseLong(strTrim.substring(0, strTrim.indexOf("px")));
                } catch (java.lang.NumberFormatException e5) {
                    com.taobao.weex.utils.WXLogUtils.e("Argument format error! value is " + obj, e5);
                } catch (java.lang.Exception e6) {
                    com.taobao.weex.utils.WXLogUtils.e("Argument error! value is " + obj, e6);
                }
            }
        } else {
            try {
                return java.lang.Long.parseLong(strTrim);
            } catch (java.lang.NumberFormatException e7) {
                com.taobao.weex.utils.WXLogUtils.e("Argument format error! value is " + obj, e7);
            } catch (java.lang.Exception e8) {
                com.taobao.weex.utils.WXLogUtils.e("Argument error! value is " + obj, e8);
            }
        }
        return 0L;
    }

    @java.lang.Deprecated
    public static double getDouble(java.lang.Object obj) {
        if (obj == null) {
            return 0.0d;
        }
        java.lang.String strTrim = obj.toString().trim();
        if (strTrim.endsWith("wx")) {
            if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
                com.taobao.weex.utils.WXLogUtils.w("the value of " + obj + " use wx unit, which will be not supported soon after.");
            }
            try {
                return transferWx(strTrim, 750.0f);
            } catch (java.lang.NumberFormatException e) {
                com.taobao.weex.utils.WXLogUtils.e("Argument format error! value is " + obj, e);
            } catch (java.lang.Exception e2) {
                com.taobao.weex.utils.WXLogUtils.e("Argument error! value is " + obj, e2);
            }
        } else if (strTrim.endsWith("px")) {
            if (strTrim.length() > 3 && (strTrim.endsWith("rpx") || strTrim.endsWith("upx"))) {
                try {
                    return transferRpxAndUpx(strTrim.substring(0, strTrim.length() - 3), 750.0f);
                } catch (java.lang.NumberFormatException e3) {
                    com.taobao.weex.utils.WXLogUtils.e("Argument format error! value is " + obj, e3);
                } catch (java.lang.Exception e4) {
                    com.taobao.weex.utils.WXLogUtils.e("Argument error! value is " + obj, e4);
                }
            } else {
                try {
                    return java.lang.Double.parseDouble(strTrim.substring(0, strTrim.indexOf("px")));
                } catch (java.lang.NumberFormatException e5) {
                    com.taobao.weex.utils.WXLogUtils.e("Argument format error! value is " + obj, e5);
                } catch (java.lang.Exception e6) {
                    com.taobao.weex.utils.WXLogUtils.e("Argument error! value is " + obj, e6);
                }
            }
        } else {
            try {
                return java.lang.Double.parseDouble(strTrim);
            } catch (java.lang.NumberFormatException e7) {
                com.taobao.weex.utils.WXLogUtils.e("Argument format error! value is " + obj, e7);
            } catch (java.lang.Exception e8) {
                com.taobao.weex.utils.WXLogUtils.e("Argument error! value is " + obj, e8);
            }
        }
        return 0.0d;
    }

    @java.lang.Deprecated
    public static boolean isTabletDevice() {
        try {
            return (com.taobao.weex.WXEnvironment.getApplication().getResources().getConfiguration().screenLayout & 15) >= 3;
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    public static java.lang.Boolean getBoolean(java.lang.Object obj, java.lang.Boolean bool) {
        if (obj != null) {
            if (android.text.TextUtils.equals(io.dcloud.common.constant.AbsoluteConst.FALSE, obj.toString())) {
                return false;
            }
            if (android.text.TextUtils.equals(io.dcloud.common.constant.AbsoluteConst.TRUE, obj.toString())) {
                return true;
            }
        }
        return bool;
    }

    public static long getAvailMemory(android.content.Context context) {
        android.app.ActivityManager activityManager = (android.app.ActivityManager) context.getSystemService("activity");
        android.app.ActivityManager.MemoryInfo memoryInfo = new android.app.ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        com.taobao.weex.utils.WXLogUtils.w("app AvailMemory ---->>>" + (memoryInfo.availMem / 1048576));
        return memoryInfo.availMem / 1048576;
    }

    public static java.lang.String getString(java.lang.Object obj, java.lang.String str) {
        if (obj == null) {
            return str;
        }
        if (obj instanceof java.lang.String) {
            return (java.lang.String) obj;
        }
        return obj.toString();
    }

    public static int parseUnitOrPercent(java.lang.String str, int i) {
        int iLastIndexOf = str.lastIndexOf(37);
        if (iLastIndexOf != -1) {
            return parsePercent(str.substring(0, iLastIndexOf), i);
        }
        return parseInt(str);
    }

    private static int parsePercent(java.lang.String str, int i) {
        return (int) ((java.lang.Float.parseFloat(str) / 100.0f) * i);
    }

    public static java.lang.String getBundleBanner(java.lang.String str) {
        int i;
        int iIndexLineBreak;
        int iIndexOf = str.indexOf("/*!");
        if (iIndexOf == -1 || (iIndexLineBreak = indexLineBreak(str, (i = iIndexOf + 3))) == -1) {
            return null;
        }
        int i2 = java.lang.Integer.parseInt(str.substring(i, iIndexLineBreak));
        int i3 = iIndexLineBreak + 1;
        java.lang.String strSubstring = str.substring(i3, i2 + i3);
        int iLastIndexOf = strSubstring.lastIndexOf("!*/");
        if (iLastIndexOf == -1) {
            return null;
        }
        java.lang.String strSubstring2 = strSubstring.substring(0, iLastIndexOf);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (java.lang.String str2 : splitLineBreak(strSubstring2)) {
            sb.append(str2.replaceFirst("\\*", ""));
        }
        return sb.toString();
    }

    private static int indexLineBreak(java.lang.String str, int i) {
        int iIndexOf = str.indexOf("\r", i);
        if (iIndexOf == -1) {
            iIndexOf = str.indexOf("\n", i);
        }
        return iIndexOf == -1 ? str.indexOf("\r\n", i) : iIndexOf;
    }

    private static java.lang.String[] splitLineBreak(java.lang.String str) {
        java.lang.String[] strArrSplit = str.split("\r");
        if (strArrSplit.length == 1) {
            strArrSplit = str.split("\n");
        }
        return strArrSplit.length == 1 ? str.split("\r\n") : strArrSplit;
    }

    public static int getNumberInt(java.lang.Object obj, int i) {
        if (obj != null) {
            if (obj instanceof java.lang.Number) {
                return ((java.lang.Number) obj).intValue();
            }
            try {
                java.lang.String string = obj.toString();
                if (string.indexOf(46) >= 0) {
                    return (int) java.lang.Float.parseFloat(obj.toString());
                }
                return java.lang.Integer.parseInt(string);
            } catch (java.lang.Exception unused) {
            }
        }
        return i;
    }

    public static boolean checkGreyConfig(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        com.taobao.weex.adapter.IWXConfigAdapter wxConfigAdapter = com.taobao.weex.WXSDKManager.getInstance().getWxConfigAdapter();
        if (wxConfigAdapter == null) {
            return false;
        }
        double dDoubleValue = 100.0d;
        double dRandom = java.lang.Math.random() * 100.0d;
        try {
            dDoubleValue = java.lang.Double.valueOf(wxConfigAdapter.getConfig(str, str2, str3)).doubleValue();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return dRandom < dDoubleValue;
    }

    public static long getFixUnixTime() {
        return sInterval + android.os.SystemClock.uptimeMillis();
    }
}
