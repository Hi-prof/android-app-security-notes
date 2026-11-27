package com.alibaba.android.bindingx.core.internal;

/* JADX INFO: loaded from: classes.dex */
class JSMath {
    private static java.lang.Object sin = new com.alibaba.android.bindingx.core.internal.JSFunctionInterface() { // from class: com.alibaba.android.bindingx.core.internal.JSMath.1
        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public java.lang.Object execute(java.util.ArrayList<java.lang.Object> arrayList) {
            return java.lang.Double.valueOf(java.lang.Math.sin(((java.lang.Double) arrayList.get(0)).doubleValue()));
        }
    };
    private static java.lang.Object cos = new com.alibaba.android.bindingx.core.internal.JSFunctionInterface() { // from class: com.alibaba.android.bindingx.core.internal.JSMath.2
        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public java.lang.Object execute(java.util.ArrayList<java.lang.Object> arrayList) {
            return java.lang.Double.valueOf(java.lang.Math.cos(((java.lang.Double) arrayList.get(0)).doubleValue()));
        }
    };
    private static java.lang.Object tan = new com.alibaba.android.bindingx.core.internal.JSFunctionInterface() { // from class: com.alibaba.android.bindingx.core.internal.JSMath.3
        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public java.lang.Object execute(java.util.ArrayList<java.lang.Object> arrayList) {
            return java.lang.Double.valueOf(java.lang.Math.tan(((java.lang.Double) arrayList.get(0)).doubleValue()));
        }
    };
    private static java.lang.Object asin = new com.alibaba.android.bindingx.core.internal.JSFunctionInterface() { // from class: com.alibaba.android.bindingx.core.internal.JSMath.4
        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public java.lang.Object execute(java.util.ArrayList<java.lang.Object> arrayList) {
            return java.lang.Double.valueOf(java.lang.Math.asin(((java.lang.Double) arrayList.get(0)).doubleValue()));
        }
    };
    private static java.lang.Object acos = new com.alibaba.android.bindingx.core.internal.JSFunctionInterface() { // from class: com.alibaba.android.bindingx.core.internal.JSMath.5
        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public java.lang.Object execute(java.util.ArrayList<java.lang.Object> arrayList) {
            return java.lang.Double.valueOf(java.lang.Math.acos(((java.lang.Double) arrayList.get(0)).doubleValue()));
        }
    };
    private static java.lang.Object atan = new com.alibaba.android.bindingx.core.internal.JSFunctionInterface() { // from class: com.alibaba.android.bindingx.core.internal.JSMath.6
        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public java.lang.Object execute(java.util.ArrayList<java.lang.Object> arrayList) {
            return java.lang.Double.valueOf(java.lang.Math.atan(((java.lang.Double) arrayList.get(0)).doubleValue()));
        }
    };
    private static java.lang.Object atan2 = new com.alibaba.android.bindingx.core.internal.JSFunctionInterface() { // from class: com.alibaba.android.bindingx.core.internal.JSMath.7
        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public java.lang.Object execute(java.util.ArrayList<java.lang.Object> arrayList) {
            return java.lang.Double.valueOf(java.lang.Math.atan2(((java.lang.Double) arrayList.get(0)).doubleValue(), ((java.lang.Double) arrayList.get(1)).doubleValue()));
        }
    };
    private static java.lang.Object pow = new com.alibaba.android.bindingx.core.internal.JSFunctionInterface() { // from class: com.alibaba.android.bindingx.core.internal.JSMath.8
        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public java.lang.Object execute(java.util.ArrayList<java.lang.Object> arrayList) {
            return java.lang.Double.valueOf(java.lang.Math.pow(((java.lang.Double) arrayList.get(0)).doubleValue(), ((java.lang.Double) arrayList.get(1)).doubleValue()));
        }
    };
    private static java.lang.Object exp = new com.alibaba.android.bindingx.core.internal.JSFunctionInterface() { // from class: com.alibaba.android.bindingx.core.internal.JSMath.9
        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public java.lang.Object execute(java.util.ArrayList<java.lang.Object> arrayList) {
            return java.lang.Double.valueOf(java.lang.Math.exp(((java.lang.Double) arrayList.get(0)).doubleValue()));
        }
    };
    private static java.lang.Object sqrt = new com.alibaba.android.bindingx.core.internal.JSFunctionInterface() { // from class: com.alibaba.android.bindingx.core.internal.JSMath.10
        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public java.lang.Object execute(java.util.ArrayList<java.lang.Object> arrayList) {
            return java.lang.Double.valueOf(java.lang.Math.sqrt(((java.lang.Double) arrayList.get(0)).doubleValue()));
        }
    };
    private static java.lang.Object cbrt = new com.alibaba.android.bindingx.core.internal.JSFunctionInterface() { // from class: com.alibaba.android.bindingx.core.internal.JSMath.11
        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public java.lang.Object execute(java.util.ArrayList<java.lang.Object> arrayList) {
            return java.lang.Double.valueOf(java.lang.Math.cbrt(((java.lang.Double) arrayList.get(0)).doubleValue()));
        }
    };
    private static java.lang.Object log = new com.alibaba.android.bindingx.core.internal.JSFunctionInterface() { // from class: com.alibaba.android.bindingx.core.internal.JSMath.12
        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public java.lang.Object execute(java.util.ArrayList<java.lang.Object> arrayList) {
            return java.lang.Double.valueOf(java.lang.Math.log(((java.lang.Double) arrayList.get(0)).doubleValue()));
        }
    };
    private static java.lang.Object abs = new com.alibaba.android.bindingx.core.internal.JSFunctionInterface() { // from class: com.alibaba.android.bindingx.core.internal.JSMath.13
        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public java.lang.Object execute(java.util.ArrayList<java.lang.Object> arrayList) {
            return java.lang.Double.valueOf(java.lang.Math.abs(((java.lang.Double) arrayList.get(0)).doubleValue()));
        }
    };
    private static java.lang.Object sign = new com.alibaba.android.bindingx.core.internal.JSFunctionInterface() { // from class: com.alibaba.android.bindingx.core.internal.JSMath.14
        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public java.lang.Object execute(java.util.ArrayList<java.lang.Object> arrayList) {
            double dDoubleValue = ((java.lang.Double) arrayList.get(0)).doubleValue();
            if (dDoubleValue > 0.0d) {
                return 1;
            }
            if (dDoubleValue == 0.0d) {
                return 0;
            }
            if (dDoubleValue < 0.0d) {
                return -1;
            }
            return java.lang.Double.valueOf(Double.NaN);
        }
    };
    private static java.lang.Object ceil = new com.alibaba.android.bindingx.core.internal.JSFunctionInterface() { // from class: com.alibaba.android.bindingx.core.internal.JSMath.15
        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public java.lang.Object execute(java.util.ArrayList<java.lang.Object> arrayList) {
            return java.lang.Double.valueOf(java.lang.Math.ceil(((java.lang.Double) arrayList.get(0)).doubleValue()));
        }
    };
    private static java.lang.Object floor = new com.alibaba.android.bindingx.core.internal.JSFunctionInterface() { // from class: com.alibaba.android.bindingx.core.internal.JSMath.16
        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public java.lang.Object execute(java.util.ArrayList<java.lang.Object> arrayList) {
            return java.lang.Double.valueOf(java.lang.Math.floor(((java.lang.Double) arrayList.get(0)).doubleValue()));
        }
    };
    private static java.lang.Object round = new com.alibaba.android.bindingx.core.internal.JSFunctionInterface() { // from class: com.alibaba.android.bindingx.core.internal.JSMath.17
        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public java.lang.Object execute(java.util.ArrayList<java.lang.Object> arrayList) {
            return java.lang.Long.valueOf(java.lang.Math.round(((java.lang.Double) arrayList.get(0)).doubleValue()));
        }
    };
    private static java.lang.Object max = new com.alibaba.android.bindingx.core.internal.JSFunctionInterface() { // from class: com.alibaba.android.bindingx.core.internal.JSMath.18
        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public java.lang.Object execute(java.util.ArrayList<java.lang.Object> arrayList) {
            if (arrayList == null) {
                return null;
            }
            if (arrayList.size() < 1) {
                return null;
            }
            double dDoubleValue = ((java.lang.Double) arrayList.get(0)).doubleValue();
            int size = arrayList.size();
            for (int i = 1; i < size; i++) {
                double dDoubleValue2 = ((java.lang.Double) arrayList.get(i)).doubleValue();
                if (dDoubleValue2 > dDoubleValue) {
                    dDoubleValue = dDoubleValue2;
                }
            }
            return java.lang.Double.valueOf(dDoubleValue);
        }
    };
    private static java.lang.Object min = new com.alibaba.android.bindingx.core.internal.JSFunctionInterface() { // from class: com.alibaba.android.bindingx.core.internal.JSMath.19
        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public java.lang.Object execute(java.util.ArrayList<java.lang.Object> arrayList) {
            if (arrayList == null) {
                return null;
            }
            if (arrayList.size() < 1) {
                return null;
            }
            double dDoubleValue = ((java.lang.Double) arrayList.get(0)).doubleValue();
            int size = arrayList.size();
            for (int i = 1; i < size; i++) {
                double dDoubleValue2 = ((java.lang.Double) arrayList.get(i)).doubleValue();
                if (dDoubleValue2 < dDoubleValue) {
                    dDoubleValue = dDoubleValue2;
                }
            }
            return java.lang.Double.valueOf(dDoubleValue);
        }
    };
    private static java.lang.Object PI = java.lang.Double.valueOf(3.141592653589793d);
    public static java.lang.Object E = java.lang.Double.valueOf(2.718281828459045d);
    private static java.lang.Object translate = new com.alibaba.android.bindingx.core.internal.JSFunctionInterface() { // from class: com.alibaba.android.bindingx.core.internal.JSMath.20
        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public java.lang.Object execute(java.util.ArrayList<java.lang.Object> arrayList) throws org.json.JSONException, java.lang.NumberFormatException {
            if (arrayList == null || arrayList.size() < 2) {
                return null;
            }
            return arrayList;
        }
    };
    private static java.lang.Object scale = new com.alibaba.android.bindingx.core.internal.JSFunctionInterface() { // from class: com.alibaba.android.bindingx.core.internal.JSMath.21
        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public java.lang.Object execute(java.util.ArrayList<java.lang.Object> arrayList) throws org.json.JSONException, java.lang.NumberFormatException {
            if (arrayList == null || arrayList.size() < 2) {
                return null;
            }
            return arrayList;
        }
    };
    private static java.lang.Object matrix = new com.alibaba.android.bindingx.core.internal.JSFunctionInterface() { // from class: com.alibaba.android.bindingx.core.internal.JSMath.22
        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public java.lang.Object execute(java.util.ArrayList<java.lang.Object> arrayList) throws org.json.JSONException, java.lang.NumberFormatException {
            if (arrayList == null || arrayList.size() < 6) {
                return null;
            }
            return arrayList;
        }
    };
    private static java.lang.Object rgb = new com.alibaba.android.bindingx.core.internal.JSFunctionInterface() { // from class: com.alibaba.android.bindingx.core.internal.JSMath.23
        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public java.lang.Object execute(java.util.ArrayList<java.lang.Object> arrayList) throws org.json.JSONException, java.lang.NumberFormatException {
            if (arrayList == null || arrayList.size() < 3) {
                return null;
            }
            return java.lang.Integer.valueOf(android.graphics.Color.rgb((int) ((java.lang.Double) arrayList.get(0)).doubleValue(), (int) ((java.lang.Double) arrayList.get(1)).doubleValue(), (int) ((java.lang.Double) arrayList.get(2)).doubleValue()));
        }
    };
    private static java.lang.Object rgba = new com.alibaba.android.bindingx.core.internal.JSFunctionInterface() { // from class: com.alibaba.android.bindingx.core.internal.JSMath.24
        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public java.lang.Object execute(java.util.ArrayList<java.lang.Object> arrayList) throws org.json.JSONException, java.lang.NumberFormatException {
            if (arrayList == null || arrayList.size() < 4) {
                return null;
            }
            return java.lang.Integer.valueOf(android.graphics.Color.argb((int) (((java.lang.Double) arrayList.get(3)).doubleValue() * 255.0d), (int) ((java.lang.Double) arrayList.get(0)).doubleValue(), (int) ((java.lang.Double) arrayList.get(1)).doubleValue(), (int) ((java.lang.Double) arrayList.get(2)).doubleValue()));
        }
    };
    private static android.animation.ArgbEvaluator sArgbEvaluator = new android.animation.ArgbEvaluator();
    private static java.lang.Object evaluateColor = new com.alibaba.android.bindingx.core.internal.JSFunctionInterface() { // from class: com.alibaba.android.bindingx.core.internal.JSMath.25
        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public java.lang.Object execute(java.util.ArrayList<java.lang.Object> arrayList) throws org.json.JSONException, java.lang.NumberFormatException {
            int color = com.alibaba.android.bindingx.core.internal.JSMath.parseColor((java.lang.String) arrayList.get(0));
            int color2 = com.alibaba.android.bindingx.core.internal.JSMath.parseColor((java.lang.String) arrayList.get(1));
            return com.alibaba.android.bindingx.core.internal.JSMath.sArgbEvaluator.evaluate((float) java.lang.Math.min(1.0d, java.lang.Math.max(0.0d, ((java.lang.Double) arrayList.get(2)).doubleValue())), java.lang.Integer.valueOf(color), java.lang.Integer.valueOf(color2));
        }
    };
    private static java.lang.Object asArray = new com.alibaba.android.bindingx.core.internal.JSFunctionInterface() { // from class: com.alibaba.android.bindingx.core.internal.JSMath.26
        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public java.lang.Object execute(java.util.ArrayList<java.lang.Object> arrayList) throws org.json.JSONException, java.lang.NumberFormatException {
            return arrayList;
        }
    };

    private JSMath() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int parseColor(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            throw new java.lang.IllegalArgumentException("Unknown color");
        }
        if (str.startsWith("'") || str.startsWith(io.dcloud.common.util.JSUtil.QUOTE)) {
            str = str.substring(1, str.length() - 1);
        }
        int color = android.graphics.Color.parseColor(str);
        return android.graphics.Color.argb(255, android.graphics.Color.red(color), android.graphics.Color.green(color), android.graphics.Color.blue(color));
    }

    static void applyXYToScope(java.util.Map<java.lang.String, java.lang.Object> map, double d, double d2, com.alibaba.android.bindingx.core.PlatformManager.IDeviceResolutionTranslator iDeviceResolutionTranslator) {
        map.put(com.taobao.weex.common.Constants.Name.X, java.lang.Double.valueOf(iDeviceResolutionTranslator.nativeToWeb(d, new java.lang.Object[0])));
        map.put(com.taobao.weex.common.Constants.Name.Y, java.lang.Double.valueOf(iDeviceResolutionTranslator.nativeToWeb(d2, new java.lang.Object[0])));
        map.put("internal_x", java.lang.Double.valueOf(d));
        map.put("internal_y", java.lang.Double.valueOf(d2));
    }

    static void applyOrientationValuesToScope(java.util.Map<java.lang.String, java.lang.Object> map, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        map.put("alpha", java.lang.Double.valueOf(d));
        map.put("beta", java.lang.Double.valueOf(d2));
        map.put("gamma", java.lang.Double.valueOf(d3));
        map.put("dalpha", java.lang.Double.valueOf(d - d4));
        map.put("dbeta", java.lang.Double.valueOf(d2 - d5));
        map.put("dgamma", java.lang.Double.valueOf(d3 - d6));
        map.put(com.taobao.weex.common.Constants.Name.X, java.lang.Double.valueOf(d7));
        map.put(com.taobao.weex.common.Constants.Name.Y, java.lang.Double.valueOf(d8));
        map.put("z", java.lang.Double.valueOf(d9));
    }

    static void applyTimingValuesToScope(java.util.Map<java.lang.String, java.lang.Object> map, double d) {
        map.put("t", java.lang.Double.valueOf(d));
    }

    static void applyScrollValuesToScope(java.util.Map<java.lang.String, java.lang.Object> map, double d, double d2, double d3, double d4, double d5, double d6, com.alibaba.android.bindingx.core.PlatformManager.IDeviceResolutionTranslator iDeviceResolutionTranslator) {
        map.put(com.taobao.weex.common.Constants.Name.X, java.lang.Double.valueOf(iDeviceResolutionTranslator.nativeToWeb(d, new java.lang.Object[0])));
        map.put(com.taobao.weex.common.Constants.Name.Y, java.lang.Double.valueOf(iDeviceResolutionTranslator.nativeToWeb(d2, new java.lang.Object[0])));
        map.put("dx", java.lang.Double.valueOf(iDeviceResolutionTranslator.nativeToWeb(d3, new java.lang.Object[0])));
        map.put(com.taobao.weex.common.Constants.Name.DISTANCE_Y, java.lang.Double.valueOf(iDeviceResolutionTranslator.nativeToWeb(d4, new java.lang.Object[0])));
        map.put("tdx", java.lang.Double.valueOf(iDeviceResolutionTranslator.nativeToWeb(d5, new java.lang.Object[0])));
        map.put("tdy", java.lang.Double.valueOf(iDeviceResolutionTranslator.nativeToWeb(d6, new java.lang.Object[0])));
        map.put("internal_x", java.lang.Double.valueOf(d));
        map.put("internal_y", java.lang.Double.valueOf(d2));
    }

    static void applyToScope(java.util.Map<java.lang.String, java.lang.Object> map) {
        map.put("sin", sin);
        map.put("cos", cos);
        map.put("tan", tan);
        map.put("asin", asin);
        map.put("acos", acos);
        map.put("atan", atan);
        map.put("atan2", atan2);
        map.put("pow", pow);
        map.put("exp", exp);
        map.put("sqrt", sqrt);
        map.put("cbrt", cbrt);
        map.put("log", log);
        map.put("abs", abs);
        map.put("sign", sign);
        map.put("ceil", ceil);
        map.put("floor", floor);
        map.put(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_ROUND, round);
        map.put("max", max);
        map.put(com.taobao.weex.common.Constants.Name.MIN, min);
        map.put("PI", PI);
        map.put("E", E);
        map.put("translate", translate);
        map.put("scale", scale);
        map.put("matrix", matrix);
        map.put("rgb", rgb);
        map.put("rgba", rgba);
        map.put("evaluateColor", evaluateColor);
        map.put("asArray", asArray);
    }
}
