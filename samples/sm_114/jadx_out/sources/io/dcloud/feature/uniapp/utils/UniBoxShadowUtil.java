package io.dcloud.feature.uniapp.utils;

/* JADX INFO: loaded from: classes2.dex */
public class UniBoxShadowUtil {
    private static final java.lang.String TAG = "UniBoxShadowUtil";
    private static boolean sBoxShadowEnabled = true;
    private static java.util.regex.Pattern sColorPattern;

    public static void setBoxShadowEnabled(boolean z) {
        sBoxShadowEnabled = z;
        com.taobao.weex.utils.WXLogUtils.w(TAG, "Switch box-shadow status: " + z);
    }

    public static boolean isBoxShadowEnabled() {
        return sBoxShadowEnabled;
    }

    public static io.dcloud.feature.uniapp.ui.shadow.UniBoxShadowData parseBoxShadow(int i, int i2, java.lang.String str, float[] fArr, float f, float f2) {
        if (!sBoxShadowEnabled) {
            com.taobao.weex.utils.WXLogUtils.w(TAG, "box-shadow was disabled by config");
            return null;
        }
        io.dcloud.feature.uniapp.ui.shadow.UniBoxShadowOptions[] boxShadows = parseBoxShadows(str, f);
        if (boxShadows == null || boxShadows.length == 0) {
            com.taobao.weex.utils.WXLogUtils.w(TAG, "Failed to parse box-shadow: " + str);
            return null;
        }
        java.util.ArrayList<io.dcloud.feature.uniapp.ui.shadow.UniBoxShadowOptions> arrayList = new java.util.ArrayList();
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        int iWidth = 0;
        for (io.dcloud.feature.uniapp.ui.shadow.UniBoxShadowOptions uniBoxShadowOptions : boxShadows) {
            if (uniBoxShadowOptions != null) {
                if (uniBoxShadowOptions.isInset) {
                    arrayList2.add(0, uniBoxShadowOptions);
                } else {
                    arrayList.add(0, uniBoxShadowOptions);
                }
            }
        }
        if (fArr != null && fArr.length != 8) {
            com.taobao.weex.utils.WXLogUtils.w(TAG, "Length of radii must be 8");
        }
        io.dcloud.feature.uniapp.ui.shadow.UniBoxShadowData uniBoxShadowData = new io.dcloud.feature.uniapp.ui.shadow.UniBoxShadowData(arrayList, arrayList2, fArr, f2);
        uniBoxShadowData.setStyle(str);
        if (arrayList.size() > 0) {
            int iHeight = 0;
            for (io.dcloud.feature.uniapp.ui.shadow.UniBoxShadowOptions uniBoxShadowOptions2 : arrayList) {
                uniBoxShadowOptions2.viewWidth = i;
                uniBoxShadowOptions2.viewHeight = i2;
                uniBoxShadowOptions2.radii = fArr;
                android.graphics.Rect targetCanvasRect = uniBoxShadowOptions2.getTargetCanvasRect();
                if (iWidth < targetCanvasRect.width()) {
                    iWidth = targetCanvasRect.width();
                }
                if (iHeight < targetCanvasRect.height()) {
                    iHeight = targetCanvasRect.height();
                }
            }
            uniBoxShadowData.setNormalMaxWidth(iWidth);
            uniBoxShadowData.setNormalMaxHeight(iHeight);
            uniBoxShadowData.setNormalLeft(iWidth - i);
            uniBoxShadowData.setNormalTop(iHeight - i2);
        }
        uniBoxShadowData.setContentHeight(i2);
        uniBoxShadowData.setContentWidth(i);
        return uniBoxShadowData;
    }

    public static io.dcloud.feature.uniapp.ui.shadow.UniBoxShadowOptions[] parseBoxShadows(java.lang.String str, float f) {
        int i;
        if (sColorPattern == null) {
            sColorPattern = java.util.regex.Pattern.compile("([rR][gG][bB][aA]?)\\((\\d+\\s*),\\s*(\\d+\\s*),\\s*(\\d+\\s*)(?:,\\s*(\\d+(?:\\.\\d+)?))?\\)");
        }
        java.util.regex.Matcher matcher = sColorPattern.matcher(str);
        while (true) {
            if (!matcher.find()) {
                break;
            }
            java.lang.String strGroup = matcher.group();
            str = str.replace(strGroup, "#" + io.dcloud.common.util.StringUtil.format("%8s", java.lang.Integer.toHexString(com.taobao.weex.utils.WXResourceUtils.getColor(strGroup, -16777216))).replaceAll("\\s", com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT));
        }
        java.lang.String[] strArrSplit = str.split(",");
        if (strArrSplit == null || strArrSplit.length <= 0) {
            return null;
        }
        io.dcloud.feature.uniapp.ui.shadow.UniBoxShadowOptions[] uniBoxShadowOptionsArr = new io.dcloud.feature.uniapp.ui.shadow.UniBoxShadowOptions[strArrSplit.length];
        for (i = 0; i < strArrSplit.length; i++) {
            uniBoxShadowOptionsArr[i] = parseBoxShadow(strArrSplit[i], f);
        }
        return uniBoxShadowOptionsArr;
    }

    private static io.dcloud.feature.uniapp.ui.shadow.UniBoxShadowOptions parseBoxShadow(java.lang.String str, float f) {
        io.dcloud.feature.uniapp.ui.shadow.UniBoxShadowOptions uniBoxShadowOptions = new io.dcloud.feature.uniapp.ui.shadow.UniBoxShadowOptions(f);
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        java.lang.String strReplaceAll = str.replaceAll("\\s*,\\s+", ",");
        if (strReplaceAll.contains("inset")) {
            uniBoxShadowOptions.isInset = true;
            strReplaceAll = strReplaceAll.replace("inset", "");
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(java.util.Arrays.asList(strReplaceAll.trim().split("\\s+")));
        java.lang.String str2 = (java.lang.String) arrayList.get(arrayList.size() - 1);
        if (!android.text.TextUtils.isEmpty(str2) && (str2.startsWith("#") || str2.startsWith("rgb") || com.taobao.weex.utils.WXResourceUtils.isNamedColor(str2))) {
            uniBoxShadowOptions.color = com.taobao.weex.utils.WXResourceUtils.getColor(str2, -16777216);
            arrayList.remove(arrayList.size() - 1);
        }
        try {
            if (arrayList.size() < 2) {
                return null;
            }
            if (!android.text.TextUtils.isEmpty((java.lang.CharSequence) arrayList.get(0))) {
                uniBoxShadowOptions.hShadow = com.taobao.weex.utils.WXViewUtils.getRealSubPxByWidth(com.taobao.weex.utils.WXUtils.getFloat(((java.lang.String) arrayList.get(0)).trim(), java.lang.Float.valueOf(0.0f)).floatValue(), f);
            }
            if (!android.text.TextUtils.isEmpty((java.lang.CharSequence) arrayList.get(1))) {
                uniBoxShadowOptions.vShadow = com.taobao.weex.utils.WXViewUtils.getRealPxByWidth(com.taobao.weex.utils.WXUtils.getFloat(((java.lang.String) arrayList.get(1)).trim(), java.lang.Float.valueOf(0.0f)).floatValue(), f);
            }
            for (int i = 2; i < arrayList.size(); i++) {
                uniBoxShadowOptions.optionParamParsers.get(i - 2).parse((java.lang.String) arrayList.get(i));
            }
            return uniBoxShadowOptions;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return uniBoxShadowOptions;
        }
    }

    public static io.dcloud.feature.uniapp.ui.shadow.UniNormalBoxShadowDrawable getNormalBoxShadowDrawable(io.dcloud.feature.uniapp.ui.shadow.UniBoxShadowData uniBoxShadowData, android.content.res.Resources resources) {
        if (uniBoxShadowData.getNormalShadows().size() <= 0) {
            return null;
        }
        android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(uniBoxShadowData.getCanvasWidth(), uniBoxShadowData.getCanvasHeight(), android.graphics.Bitmap.Config.ARGB_4444);
        io.dcloud.common.adapter.util.Logger.e(TAG, "Allocation memory for box-shadow: " + (bitmapCreateBitmap.getAllocationByteCount() / 1024) + " KB");
        android.graphics.Canvas canvas = new android.graphics.Canvas(bitmapCreateBitmap);
        canvas.setDrawFilter(new android.graphics.PaintFlagsDrawFilter(0, 3));
        java.util.Iterator<io.dcloud.feature.uniapp.ui.shadow.UniBoxShadowOptions> it = uniBoxShadowData.getNormalShadows().iterator();
        while (it.hasNext()) {
            drawShadow(canvas, it.next().scale(uniBoxShadowData.getQuality()), uniBoxShadowData.getNormalTop(), uniBoxShadowData.getNormalLeft(), uniBoxShadowData.getQuality());
        }
        return new io.dcloud.feature.uniapp.ui.shadow.UniNormalBoxShadowDrawable(resources, bitmapCreateBitmap);
    }

    private static void drawShadow(android.graphics.Canvas canvas, io.dcloud.feature.uniapp.ui.shadow.UniBoxShadowOptions uniBoxShadowOptions, float f, float f2, float f3) {
        android.graphics.RectF rectF = new android.graphics.RectF(0.0f, 0.0f, uniBoxShadowOptions.viewWidth + (uniBoxShadowOptions.spread * 2.0f), uniBoxShadowOptions.viewHeight + (uniBoxShadowOptions.spread * 2.0f));
        rectF.offset(uniBoxShadowOptions.hShadow >= 0.0f ? uniBoxShadowOptions.blur + (uniBoxShadowOptions.hShadow * 2.0f) : 0.0f, uniBoxShadowOptions.vShadow >= 0.0f ? uniBoxShadowOptions.blur + (uniBoxShadowOptions.vShadow * 2.0f) : 0.0f);
        android.graphics.Path path = new android.graphics.Path();
        android.graphics.RectF rectF2 = new android.graphics.RectF(0.0f, 0.0f, uniBoxShadowOptions.viewWidth, uniBoxShadowOptions.viewHeight);
        rectF2.offset(f2 > 0.0f ? (f2 * f3) / 2.0f : 0.0f, f > 0.0f ? (f * f3) / 2.0f : 0.0f);
        rectF2.inset(1.0f, 1.0f);
        path.addRoundRect(rectF2, uniBoxShadowOptions.radii, android.graphics.Path.Direction.CCW);
        canvas.clipPath(path, android.graphics.Region.Op.DIFFERENCE);
        android.graphics.Paint paint = new android.graphics.Paint();
        paint.setAntiAlias(true);
        paint.setColor(uniBoxShadowOptions.color);
        paint.setStyle(android.graphics.Paint.Style.FILL);
        if (uniBoxShadowOptions.blur > 0.0f) {
            paint.setMaskFilter(new android.graphics.BlurMaskFilter(uniBoxShadowOptions.blur, android.graphics.BlurMaskFilter.Blur.NORMAL));
        }
        float f4 = uniBoxShadowOptions.radii[0];
        if (f4 == uniBoxShadowOptions.radii[2] && f4 == uniBoxShadowOptions.radii[4] && f4 == uniBoxShadowOptions.radii[6]) {
            canvas.drawRoundRect(rectF, f4, f4, paint);
            return;
        }
        android.graphics.Path path2 = new android.graphics.Path();
        float[] fArr = new float[8];
        for (int i = 0; i < uniBoxShadowOptions.radii.length; i++) {
            if (uniBoxShadowOptions.radii[i] == 0.0f) {
                fArr[i] = 0.0f;
            } else {
                fArr[i] = uniBoxShadowOptions.radii[i] + uniBoxShadowOptions.spread;
            }
        }
        path2.addRoundRect(rectF, fArr, android.graphics.Path.Direction.CW);
        canvas.drawPath(path2, paint);
    }

    public static io.dcloud.feature.uniapp.ui.shadow.UniInsetBoxShadowLayer getInsetBoxShadowDrawable(io.dcloud.feature.uniapp.ui.shadow.UniBoxShadowData uniBoxShadowData) {
        if (uniBoxShadowData.getInsetShadows().size() <= 0) {
            return null;
        }
        android.graphics.drawable.Drawable[] drawableArr = new android.graphics.drawable.Drawable[uniBoxShadowData.getInsetShadows().size()];
        for (int i = 0; i < uniBoxShadowData.getInsetShadows().size(); i++) {
            io.dcloud.feature.uniapp.ui.shadow.UniBoxShadowOptions uniBoxShadowOptions = uniBoxShadowData.getInsetShadows().get(i);
            drawableArr[i] = new io.dcloud.feature.uniapp.ui.shadow.UniInsetBoxShadowDrawable(uniBoxShadowData.getContentWidth(), uniBoxShadowData.getContentHeight(), uniBoxShadowOptions.hShadow, uniBoxShadowOptions.vShadow, uniBoxShadowOptions.blur, uniBoxShadowOptions.spread, uniBoxShadowOptions.color, uniBoxShadowData.getRadii());
        }
        return new io.dcloud.feature.uniapp.ui.shadow.UniInsetBoxShadowLayer(drawableArr);
    }
}
