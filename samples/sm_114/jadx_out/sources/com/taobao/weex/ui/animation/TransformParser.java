package com.taobao.weex.ui.animation;

/* JADX INFO: loaded from: classes.dex */
public class TransformParser {
    public static final java.lang.String BACKGROUND_COLOR = "backgroundColor";
    public static final java.lang.String BOTTOM = "bottom";
    public static final java.lang.String CENTER = "center";
    private static final java.lang.String DEG = "deg";
    private static final java.lang.String FULL = "100%";
    private static final java.lang.String HALF = "50%";
    public static final java.lang.String HEIGHT = "height";
    public static final java.lang.String LEFT = "left";
    private static final java.lang.String PX = "px";
    public static final java.lang.String RIGHT = "right";
    public static final java.lang.String TOP = "top";
    public static final java.lang.String WIDTH = "width";
    public static final java.lang.String WX_ROTATE = "rotate";
    public static final java.lang.String WX_ROTATE_X = "rotateX";
    public static final java.lang.String WX_ROTATE_Y = "rotateY";
    public static final java.lang.String WX_ROTATE_Z = "rotateZ";
    public static final java.lang.String WX_SCALE = "scale";
    public static final java.lang.String WX_SCALE_X = "scaleX";
    public static final java.lang.String WX_SCALE_Y = "scaleY";
    public static final java.lang.String WX_TRANSLATE = "translate";
    public static final java.lang.String WX_TRANSLATE_X = "translateX";
    public static final java.lang.String WX_TRANSLATE_Y = "translateY";
    private static final java.lang.String ZERO = "0%";
    public static java.util.Map<java.lang.String, java.util.List<android.util.Property<android.view.View, java.lang.Float>>> wxToAndroidMap;

    static {
        androidx.collection.ArrayMap arrayMap = new androidx.collection.ArrayMap();
        wxToAndroidMap = arrayMap;
        arrayMap.put("translate", java.util.Arrays.asList(android.view.View.TRANSLATION_X, android.view.View.TRANSLATION_Y));
        wxToAndroidMap.put("translateX", java.util.Collections.singletonList(android.view.View.TRANSLATION_X));
        wxToAndroidMap.put("translateY", java.util.Collections.singletonList(android.view.View.TRANSLATION_Y));
        wxToAndroidMap.put("rotate", java.util.Collections.singletonList(android.view.View.ROTATION));
        wxToAndroidMap.put(WX_ROTATE_Z, java.util.Collections.singletonList(android.view.View.ROTATION));
        wxToAndroidMap.put("rotateX", java.util.Collections.singletonList(android.view.View.ROTATION_X));
        wxToAndroidMap.put("rotateY", java.util.Collections.singletonList(android.view.View.ROTATION_Y));
        wxToAndroidMap.put("scale", java.util.Arrays.asList(android.view.View.SCALE_X, android.view.View.SCALE_Y));
        wxToAndroidMap.put("scaleX", java.util.Collections.singletonList(android.view.View.SCALE_X));
        wxToAndroidMap.put("scaleY", java.util.Collections.singletonList(android.view.View.SCALE_Y));
        wxToAndroidMap.put(com.taobao.weex.common.Constants.Name.PERSPECTIVE, java.util.Collections.singletonList(com.taobao.weex.ui.animation.CameraDistanceProperty.getInstance()));
        wxToAndroidMap = java.util.Collections.unmodifiableMap(wxToAndroidMap);
    }

    public static android.animation.PropertyValuesHolder[] toHolders(java.util.Map<android.util.Property<android.view.View, java.lang.Float>, java.lang.Float> map) {
        android.animation.PropertyValuesHolder[] propertyValuesHolderArr = new android.animation.PropertyValuesHolder[map.size()];
        int i = 0;
        for (java.util.Map.Entry<android.util.Property<android.view.View, java.lang.Float>, java.lang.Float> entry : map.entrySet()) {
            propertyValuesHolderArr[i] = android.animation.PropertyValuesHolder.ofFloat(entry.getKey(), entry.getValue().floatValue());
            i++;
        }
        return propertyValuesHolderArr;
    }

    public static java.util.Map<android.util.Property<android.view.View, java.lang.Float>, java.lang.Float> parseTransForm(java.lang.String str, java.lang.String str2, final int i, final int i2, final float f) {
        try {
            if (!android.text.TextUtils.isEmpty(str2)) {
                return new com.taobao.weex.utils.FunctionParser(str2, new com.taobao.weex.utils.FunctionParser.Mapper<android.util.Property<android.view.View, java.lang.Float>, java.lang.Float>() { // from class: com.taobao.weex.ui.animation.TransformParser.1
                    @Override // com.taobao.weex.utils.FunctionParser.Mapper
                    public java.util.Map<android.util.Property<android.view.View, java.lang.Float>, java.lang.Float> map(java.lang.String str3, java.util.List<java.lang.String> list) {
                        if (list != null && !list.isEmpty() && com.taobao.weex.ui.animation.TransformParser.wxToAndroidMap.containsKey(str3)) {
                            return convertParam(i, i2, f, com.taobao.weex.ui.animation.TransformParser.wxToAndroidMap.get(str3), list);
                        }
                        return new java.util.HashMap();
                    }

                    private java.util.Map<android.util.Property<android.view.View, java.lang.Float>, java.lang.Float> convertParam(int i3, int i4, float f2, java.util.List<android.util.Property<android.view.View, java.lang.Float>> list, java.util.List<java.lang.String> list2) {
                        java.util.List<android.util.Property<android.view.View, java.lang.Float>> list3;
                        java.util.HashMap mapNewHashMapWithExpectedSize = com.taobao.weex.utils.WXDataStructureUtil.newHashMapWithExpectedSize(list.size());
                        java.util.ArrayList arrayList = new java.util.ArrayList(list.size());
                        if (list.contains(android.view.View.ROTATION) || list.contains(android.view.View.ROTATION_X) || list.contains(android.view.View.ROTATION_Y)) {
                            list3 = list;
                            arrayList.addAll(parseRotationZ(list2));
                        } else if (list.contains(android.view.View.TRANSLATION_X) || list.contains(android.view.View.TRANSLATION_Y)) {
                            list3 = list;
                            arrayList.addAll(parseTranslation(list3, i3, i4, list2, f2));
                        } else {
                            if (list.contains(android.view.View.SCALE_X) || list.contains(android.view.View.SCALE_Y)) {
                                arrayList.addAll(parseScale(list.size(), list2));
                            } else if (list.contains(com.taobao.weex.ui.animation.CameraDistanceProperty.getInstance())) {
                                arrayList.add(parseCameraDistance(list2));
                            }
                            list3 = list;
                        }
                        if (list3.size() == arrayList.size()) {
                            for (int i5 = 0; i5 < list3.size(); i5++) {
                                mapNewHashMapWithExpectedSize.put(list3.get(i5), (java.lang.Float) arrayList.get(i5));
                            }
                        }
                        return mapNewHashMapWithExpectedSize;
                    }

                    private java.util.List<java.lang.Float> parseScale(int i3, java.util.List<java.lang.String> list) {
                        java.util.ArrayList arrayList = new java.util.ArrayList(list.size() * 2);
                        java.util.ArrayList arrayList2 = new java.util.ArrayList(list.size());
                        java.util.Iterator<java.lang.String> it = list.iterator();
                        while (it.hasNext()) {
                            arrayList2.add(java.lang.Float.valueOf(com.taobao.weex.utils.WXUtils.fastGetFloat(it.next())));
                        }
                        arrayList.addAll(arrayList2);
                        if (i3 != 1 && list.size() == 1) {
                            arrayList.addAll(arrayList2);
                        }
                        return arrayList;
                    }

                    private java.util.List<java.lang.Float> parseRotationZ(java.util.List<java.lang.String> list) {
                        java.util.ArrayList arrayList = new java.util.ArrayList(1);
                        for (java.lang.String str3 : list) {
                            int iLastIndexOf = str3.lastIndexOf(com.taobao.weex.ui.animation.TransformParser.DEG);
                            if (iLastIndexOf != -1) {
                                arrayList.add(java.lang.Float.valueOf(com.taobao.weex.utils.WXUtils.fastGetFloat(str3.substring(0, iLastIndexOf))));
                            } else {
                                arrayList.add(java.lang.Float.valueOf((float) java.lang.Math.toDegrees(com.taobao.weex.utils.WXUtils.fastGetFloat(str3))));
                            }
                        }
                        return arrayList;
                    }

                    private java.util.List<java.lang.Float> parseTranslation(java.util.List<android.util.Property<android.view.View, java.lang.Float>> list, int i3, int i4, java.util.List<java.lang.String> list2, float f2) {
                        java.util.ArrayList arrayList = new java.util.ArrayList(2);
                        java.lang.String str3 = list2.get(0);
                        if (list.size() == 1) {
                            parseSingleTranslation(list, i3, i4, arrayList, str3, f2);
                            return arrayList;
                        }
                        parseDoubleTranslation(i3, i4, list2, arrayList, str3, f2);
                        return arrayList;
                    }

                    private void parseSingleTranslation(java.util.List<android.util.Property<android.view.View, java.lang.Float>> list, int i3, int i4, java.util.List<java.lang.Float> list2, java.lang.String str3, float f2) {
                        if (list.contains(android.view.View.TRANSLATION_X)) {
                            list2.add(java.lang.Float.valueOf(com.taobao.weex.ui.animation.TransformParser.parsePercentOrPx(str3, i3, f2)));
                        } else if (list.contains(android.view.View.TRANSLATION_Y)) {
                            list2.add(java.lang.Float.valueOf(com.taobao.weex.ui.animation.TransformParser.parsePercentOrPx(str3, i4, f2)));
                        }
                    }

                    private void parseDoubleTranslation(int i3, int i4, java.util.List<java.lang.String> list, java.util.List<java.lang.Float> list2, java.lang.String str3, float f2) {
                        java.lang.String str4 = list.size() == 1 ? str3 : list.get(1);
                        list2.add(java.lang.Float.valueOf(com.taobao.weex.ui.animation.TransformParser.parsePercentOrPx(str3, i3, f2)));
                        list2.add(java.lang.Float.valueOf(com.taobao.weex.ui.animation.TransformParser.parsePercentOrPx(str4, i4, f2)));
                    }

                    /* JADX WARN: Code duplicated, block: B:9:0x0032  */
                    private java.lang.Float parseCameraDistance(java.util.List<java.lang.String> list) {
                        float f2;
                        if (list.size() == 1) {
                            float realPxByWidth = com.taobao.weex.utils.WXViewUtils.getRealPxByWidth(com.taobao.weex.utils.WXUtils.getFloat(list.get(0)), f);
                            float f3 = com.taobao.weex.WXEnvironment.getApplication().getResources().getDisplayMetrics().density;
                            if (java.lang.Float.isNaN(realPxByWidth) || realPxByWidth <= 0.0f) {
                                f2 = Float.MAX_VALUE;
                            } else {
                                f2 = realPxByWidth * f3;
                            }
                        } else {
                            f2 = Float.MAX_VALUE;
                        }
                        return java.lang.Float.valueOf(f2);
                    }
                }).parse();
            }
        } catch (java.lang.Exception e) {
            com.taobao.weex.utils.WXLogUtils.e("TransformParser", e);
            com.taobao.weex.utils.WXExceptionUtils.commitCriticalExceptionRT(str, com.taobao.weex.common.WXErrorCode.WX_RENDER_ERR_TRANSITION, "parse animation transition", com.taobao.weex.common.WXErrorCode.WX_RENDER_ERR_TRANSITION.getErrorMsg() + "parse transition error: " + e.getMessage(), null);
        }
        return new java.util.LinkedHashMap();
    }

    private static android.util.Pair<java.lang.Float, java.lang.Float> parsePivot(java.lang.String str, int i, int i2, float f) {
        int iIndexOf;
        if (android.text.TextUtils.isEmpty(str) || (iIndexOf = str.indexOf(32)) == -1) {
            return null;
        }
        int i3 = iIndexOf;
        while (i3 < str.length() && str.charAt(i3) == ' ') {
            i3++;
        }
        if (i3 >= str.length() || str.charAt(i3) == ' ') {
            return null;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(2);
        arrayList.add(str.substring(0, iIndexOf).trim());
        arrayList.add(str.substring(i3, str.length()).trim());
        return parsePivot(arrayList, i, i2, f);
    }

    private static android.util.Pair<java.lang.Float, java.lang.Float> parsePivot(java.util.List<java.lang.String> list, int i, int i2, float f) {
        return new android.util.Pair<>(java.lang.Float.valueOf(parsePivotX(list.get(0), i, f)), java.lang.Float.valueOf(parsePivotY(list.get(1), i2, f)));
    }

    private static float parsePivotX(java.lang.String str, int i, float f) {
        if ("left".equals(str)) {
            str = ZERO;
        } else if ("right".equals(str)) {
            str = FULL;
        } else if ("center".equals(str)) {
            str = HALF;
        }
        return parsePercentOrPx(str, i, f);
    }

    private static float parsePivotY(java.lang.String str, int i, float f) {
        if ("top".equals(str)) {
            str = ZERO;
        } else if ("bottom".equals(str)) {
            str = FULL;
        } else if ("center".equals(str)) {
            str = HALF;
        }
        return parsePercentOrPx(str, i, f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static float parsePercentOrPx(java.lang.String str, int i, float f) {
        int iLastIndexOf = str.lastIndexOf(37);
        if (iLastIndexOf != -1) {
            return parsePercent(str.substring(0, iLastIndexOf), i, 1);
        }
        int iLastIndexOf2 = str.lastIndexOf(PX);
        if (iLastIndexOf2 != -1) {
            return com.taobao.weex.utils.WXViewUtils.getRealPxByWidth(com.taobao.weex.utils.WXUtils.fastGetFloat(str.substring(0, iLastIndexOf2), 1.0f), f);
        }
        return com.taobao.weex.utils.WXViewUtils.getRealPxByWidth(com.taobao.weex.utils.WXUtils.fastGetFloat(str, 1.0f), f);
    }

    private static float parsePercent(java.lang.String str, int i, int i2) {
        return (com.taobao.weex.utils.WXUtils.fastGetFloat(str, i2) / 100.0f) * i;
    }
}
