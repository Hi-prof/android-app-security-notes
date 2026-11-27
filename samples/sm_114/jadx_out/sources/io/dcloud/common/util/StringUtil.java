package io.dcloud.common.util;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class StringUtil {
    public static java.lang.String convert(java.lang.String str) {
        if (str == null) {
            str = "";
        }
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer(1000);
        stringBuffer.setLength(0);
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            stringBuffer.append("\\u");
            java.lang.String hexString = java.lang.Integer.toHexString(cCharAt >>> '\b');
            if (hexString.length() == 1) {
                stringBuffer.append(com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT);
            }
            stringBuffer.append(hexString);
            java.lang.String hexString2 = java.lang.Integer.toHexString(cCharAt & 255);
            if (hexString2.length() == 1) {
                stringBuffer.append(com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT);
            }
            stringBuffer.append(hexString2);
        }
        return new java.lang.String(stringBuffer);
    }

    public static java.lang.String format(java.lang.String str, java.lang.Object... objArr) {
        return java.lang.String.format(java.util.Locale.US, str, objArr);
    }

    public static java.lang.Double getDouble(java.lang.String str) {
        try {
            return java.lang.Double.valueOf(java.lang.Double.parseDouble(str));
        } catch (java.lang.NumberFormatException unused) {
            return null;
        }
    }

    public static java.lang.Integer getInt(java.lang.String str) {
        try {
            return java.lang.Integer.valueOf(java.lang.Integer.parseInt(str));
        } catch (java.lang.NumberFormatException unused) {
            return null;
        }
    }

    public static java.lang.String getSCString(java.lang.String str, java.lang.String str2) {
        if (str != null) {
            try {
                return new org.json.JSONObject(str).optString(str2);
            } catch (org.json.JSONException unused) {
            }
        }
        return null;
    }

    public static java.lang.String revert(java.lang.String str) {
        int i;
        int i2;
        if (str == null) {
            str = "";
        }
        if (str.indexOf("\\u") == -1) {
            return str;
        }
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer(1000);
        int i3 = 0;
        while (i3 < str.length()) {
            if (str.substring(i3).startsWith("\\u")) {
                i = i3 + 6;
                java.lang.String strSubstring = str.substring(i3, i).substring(2);
                int iPow = 0;
                for (int i4 = 0; i4 < strSubstring.length(); i4++) {
                    char cCharAt = strSubstring.charAt(i4);
                    switch (cCharAt) {
                        case org.mozilla.universalchardet.prober.CharsetProber.ASCII_A /* 97 */:
                            i2 = 10;
                            break;
                        case 'b':
                            i2 = 11;
                            break;
                        case 'c':
                            i2 = 12;
                            break;
                        case 'd':
                            i2 = 13;
                            break;
                        case 'e':
                            i2 = 14;
                            break;
                        case 'f':
                            i2 = 15;
                            break;
                        default:
                            i2 = cCharAt - '0';
                            break;
                    }
                    iPow += i2 * ((int) java.lang.Math.pow(16.0d, (strSubstring.length() - i4) - 1));
                }
                stringBuffer.append((char) iPow);
            } else {
                i = i3 + 1;
                stringBuffer.append(str.charAt(i3));
            }
            i3 = i;
        }
        return stringBuffer.toString();
    }

    public static android.graphics.Bitmap textToBitmap(android.app.Activity activity, java.lang.String str) {
        if (activity == null) {
            return null;
        }
        try {
            if (android.text.TextUtils.isEmpty(str)) {
                return null;
            }
            int iPxFromDp = io.dcloud.common.util.PdrUtil.pxFromDp(10.0f, activity.getResources().getDisplayMetrics());
            int iPxFromDp2 = io.dcloud.common.util.PdrUtil.pxFromDp(5.0f, activity.getResources().getDisplayMetrics());
            android.text.TextPaint textPaint = new android.text.TextPaint();
            textPaint.setColor(-16777216);
            textPaint.setAntiAlias(true);
            textPaint.setTextSize(io.dcloud.common.util.PdrUtil.pxFromDp(12.0f, activity.getResources().getDisplayMetrics()));
            android.text.StaticLayout staticLayout = new android.text.StaticLayout(str, textPaint, 450, android.text.Layout.Alignment.ALIGN_NORMAL, 1.3f, 0.0f, true);
            android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(staticLayout.getWidth() + iPxFromDp, staticLayout.getHeight() + iPxFromDp, android.graphics.Bitmap.Config.ARGB_8888);
            android.graphics.Canvas canvas = new android.graphics.Canvas(bitmapCreateBitmap);
            float f = iPxFromDp2;
            canvas.translate(f, f);
            canvas.drawColor(-1);
            staticLayout.draw(canvas);
            return bitmapCreateBitmap;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static java.lang.String trimString(java.lang.String str, char c) {
        if (str == null || str.equals("")) {
            return str;
        }
        int i = str.charAt(0) == c ? 1 : 0;
        int length = str.length();
        int i2 = length - 1;
        if (str.charAt(i2) == c) {
            length = i2;
        }
        return str.substring(i, length);
    }

    public static java.lang.String[] trimString(java.lang.String[] strArr, char c) {
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = trimString(strArr[i], c);
        }
        return strArr;
    }
}
