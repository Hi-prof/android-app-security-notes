package com.taobao.weex.ui.animation;

/* JADX INFO: loaded from: classes.dex */
public class WXAnimationBean {
    public static final java.lang.String CUBIC_BEZIER = "cubic-bezier";
    public static final java.lang.String EASE_IN = "ease-in";
    public static final java.lang.String EASE_IN_OUT = "ease-in-out";
    public static final java.lang.String EASE_OUT = "ease-out";
    public static final java.lang.String LINEAR = "linear";
    public static final int NUM_CUBIC_PARAM = 4;
    public long delay;
    public long duration;
    public boolean needLayout;
    public com.taobao.weex.ui.animation.WXAnimationBean.Style styles;
    public java.lang.String timingFunction;

    public static class Style {
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
        public static final java.lang.String WX_SCALE = "scale";
        public static final java.lang.String WX_SCALE_X = "scaleX";
        public static final java.lang.String WX_SCALE_Y = "scaleY";
        public static final java.lang.String WX_TRANSLATE = "translate";
        public static final java.lang.String WX_TRANSLATE_X = "translateX";
        public static final java.lang.String WX_TRANSLATE_Y = "translateY";
        private static final java.lang.String ZERO = "0%";
        private static java.util.Map<android.util.Property<android.view.View, java.lang.Float>, java.lang.Float> defaultMap = new androidx.collection.ArrayMap();
        public static java.util.Map<java.lang.String, java.util.List<android.util.Property<android.view.View, java.lang.Float>>> wxToAndroidMap;
        public java.lang.String backgroundColor;
        public java.lang.String height;
        public java.lang.String opacity;
        private android.util.Pair<java.lang.Float, java.lang.Float> pivot;
        public java.lang.String transform;
        public java.lang.String transformOrigin;
        public java.lang.String width;
        private java.util.Map<android.util.Property<android.view.View, java.lang.Float>, java.lang.Float> transformMap = new java.util.LinkedHashMap();
        private java.util.List<android.animation.PropertyValuesHolder> holders = new java.util.LinkedList();
        private float cameraDistance = Float.MAX_VALUE;

        static {
            wxToAndroidMap = new androidx.collection.ArrayMap();
            wxToAndroidMap.put("translate", java.util.Arrays.asList(android.view.View.TRANSLATION_X, android.view.View.TRANSLATION_Y));
            wxToAndroidMap.put("translateX", java.util.Collections.singletonList(android.view.View.TRANSLATION_X));
            wxToAndroidMap.put("translateY", java.util.Collections.singletonList(android.view.View.TRANSLATION_Y));
            wxToAndroidMap.put("rotate", java.util.Collections.singletonList(android.view.View.ROTATION));
            wxToAndroidMap.put("rotateX", java.util.Collections.singletonList(android.view.View.ROTATION_X));
            wxToAndroidMap.put("rotateY", java.util.Collections.singletonList(android.view.View.ROTATION_Y));
            wxToAndroidMap.put("scale", java.util.Arrays.asList(android.view.View.SCALE_X, android.view.View.SCALE_Y));
            wxToAndroidMap.put("scaleX", java.util.Collections.singletonList(android.view.View.SCALE_X));
            wxToAndroidMap.put("scaleY", java.util.Collections.singletonList(android.view.View.SCALE_Y));
            wxToAndroidMap.put(com.taobao.weex.common.Constants.Name.PERSPECTIVE, java.util.Collections.singletonList(com.taobao.weex.ui.animation.CameraDistanceProperty.getInstance()));
            wxToAndroidMap = java.util.Collections.unmodifiableMap(wxToAndroidMap);
            java.util.Map<android.util.Property<android.view.View, java.lang.Float>, java.lang.Float> map = defaultMap;
            android.util.Property<android.view.View, java.lang.Float> property = android.view.View.TRANSLATION_X;
            java.lang.Float fValueOf = java.lang.Float.valueOf(0.0f);
            map.put(property, fValueOf);
            defaultMap.put(android.view.View.TRANSLATION_Y, fValueOf);
            java.util.Map<android.util.Property<android.view.View, java.lang.Float>, java.lang.Float> map2 = defaultMap;
            android.util.Property<android.view.View, java.lang.Float> property2 = android.view.View.SCALE_X;
            java.lang.Float fValueOf2 = java.lang.Float.valueOf(1.0f);
            map2.put(property2, fValueOf2);
            defaultMap.put(android.view.View.SCALE_Y, fValueOf2);
            defaultMap.put(android.view.View.ROTATION, fValueOf);
            defaultMap.put(android.view.View.ROTATION_X, fValueOf);
            defaultMap.put(android.view.View.ROTATION_Y, fValueOf);
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

        private static float parsePercentOrPx(java.lang.String str, int i, float f) {
            int iLastIndexOf = str.lastIndexOf(37);
            if (iLastIndexOf != -1) {
                return parsePercent(str.substring(0, iLastIndexOf), i, 1.0f);
            }
            int iLastIndexOf2 = str.lastIndexOf(PX);
            if (iLastIndexOf2 != -1) {
                return com.taobao.weex.utils.WXViewUtils.getRealPxByWidth(com.taobao.weex.utils.WXUtils.fastGetFloat(str.substring(0, iLastIndexOf2), 1.0f), f);
            }
            return com.taobao.weex.utils.WXViewUtils.getRealPxByWidth(com.taobao.weex.utils.WXUtils.fastGetFloat(str, 1.0f), f);
        }

        private static float parsePercent(java.lang.String str, int i, float f) {
            return (com.taobao.weex.utils.WXUtils.fastGetFloat(str, f) / 100.0f) * i;
        }

        private void resetToDefaultIfAbsent() {
            for (java.util.Map.Entry<android.util.Property<android.view.View, java.lang.Float>, java.lang.Float> entry : defaultMap.entrySet()) {
                if (!this.transformMap.containsKey(entry.getKey())) {
                    this.transformMap.put(entry.getKey(), entry.getValue());
                }
            }
        }

        public android.util.Pair<java.lang.Float, java.lang.Float> getPivot() {
            return this.pivot;
        }

        public void init(java.lang.String str, java.lang.String str2, int i, int i2, float f, com.taobao.weex.WXSDKInstance wXSDKInstance) {
            this.pivot = parsePivot(str, i, i2, f);
            this.transformMap.putAll(com.taobao.weex.ui.animation.TransformParser.parseTransForm(wXSDKInstance.getInstanceId(), str2, i, i2, f));
            resetToDefaultIfAbsent();
            if (this.transformMap.containsKey(com.taobao.weex.ui.animation.CameraDistanceProperty.getInstance())) {
                this.cameraDistance = this.transformMap.remove(com.taobao.weex.ui.animation.CameraDistanceProperty.getInstance()).floatValue();
            }
            initHolders();
        }

        public void init(java.util.Map<android.util.Property<android.view.View, java.lang.Float>, android.util.Pair<java.lang.Float, java.lang.Float>> map) {
            for (java.util.Map.Entry<android.util.Property<android.view.View, java.lang.Float>, android.util.Pair<java.lang.Float, java.lang.Float>> entry : map.entrySet()) {
                this.holders.add(android.animation.PropertyValuesHolder.ofFloat(entry.getKey(), ((java.lang.Float) entry.getValue().first).floatValue(), ((java.lang.Float) entry.getValue().second).floatValue()));
            }
        }

        private void initHolders() {
            for (java.util.Map.Entry<android.util.Property<android.view.View, java.lang.Float>, java.lang.Float> entry : this.transformMap.entrySet()) {
                this.holders.add(android.animation.PropertyValuesHolder.ofFloat(entry.getKey(), entry.getValue().floatValue()));
            }
            if (android.text.TextUtils.isEmpty(this.opacity)) {
                return;
            }
            this.holders.add(android.animation.PropertyValuesHolder.ofFloat((android.util.Property<?, java.lang.Float>) android.view.View.ALPHA, com.taobao.weex.utils.WXUtils.fastGetFloat(this.opacity, 3.0f)));
        }

        public java.util.List<android.animation.PropertyValuesHolder> getHolders() {
            return this.holders;
        }

        public float getCameraDistance() {
            return this.cameraDistance;
        }
    }
}
