package com.alibaba.android.bindingx.core.internal;

/* JADX INFO: loaded from: classes.dex */
class TimingFunctions {
    private static java.lang.Object linear = new com.alibaba.android.bindingx.core.internal.JSFunctionInterface() { // from class: com.alibaba.android.bindingx.core.internal.TimingFunctions.1
        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public java.lang.Object execute(java.util.ArrayList<java.lang.Object> arrayList) throws org.json.JSONException, java.lang.NumberFormatException {
            double dDoubleValue = ((java.lang.Double) arrayList.get(0)).doubleValue();
            double dDoubleValue2 = ((java.lang.Double) arrayList.get(1)).doubleValue();
            double dDoubleValue3 = ((java.lang.Double) arrayList.get(2)).doubleValue();
            double dDoubleValue4 = ((java.lang.Double) arrayList.get(3)).doubleValue();
            return java.lang.Double.valueOf((dDoubleValue3 * (java.lang.Math.min(dDoubleValue, dDoubleValue4) / dDoubleValue4)) + dDoubleValue2);
        }
    };
    private static java.lang.Object cubicBezier = new com.alibaba.android.bindingx.core.internal.JSFunctionInterface() { // from class: com.alibaba.android.bindingx.core.internal.TimingFunctions.2
        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public java.lang.Object execute(java.util.ArrayList<java.lang.Object> arrayList) throws org.json.JSONException, java.lang.NumberFormatException {
            double dDoubleValue = ((java.lang.Double) arrayList.get(0)).doubleValue();
            double dDoubleValue2 = ((java.lang.Double) arrayList.get(1)).doubleValue();
            double dDoubleValue3 = ((java.lang.Double) arrayList.get(2)).doubleValue();
            double dDoubleValue4 = ((java.lang.Double) arrayList.get(3)).doubleValue();
            double dDoubleValue5 = ((java.lang.Double) arrayList.get(4)).doubleValue();
            double dDoubleValue6 = ((java.lang.Double) arrayList.get(5)).doubleValue();
            double dDoubleValue7 = ((java.lang.Double) arrayList.get(6)).doubleValue();
            double dDoubleValue8 = ((java.lang.Double) arrayList.get(7)).doubleValue();
            double dMin = java.lang.Math.min(dDoubleValue, dDoubleValue4);
            if (dMin != dDoubleValue4) {
                float f = (float) dDoubleValue5;
                float f2 = (float) dDoubleValue6;
                float f3 = (float) dDoubleValue7;
                float f4 = (float) dDoubleValue8;
                com.alibaba.android.bindingx.core.internal.TimingFunctions.BezierInterpolatorWrapper bezierInterpolatorWrapperIsCacheHit = com.alibaba.android.bindingx.core.internal.TimingFunctions.isCacheHit(f, f2, f3, f4);
                if (bezierInterpolatorWrapperIsCacheHit == null) {
                    bezierInterpolatorWrapperIsCacheHit = new com.alibaba.android.bindingx.core.internal.TimingFunctions.BezierInterpolatorWrapper(f, f2, f3, f4);
                    com.alibaba.android.bindingx.core.internal.TimingFunctions.cache.add(bezierInterpolatorWrapperIsCacheHit);
                }
                return java.lang.Double.valueOf((dDoubleValue3 * ((double) bezierInterpolatorWrapperIsCacheHit.getInterpolation((float) (dMin / dDoubleValue4)))) + dDoubleValue2);
            }
            return java.lang.Double.valueOf(dDoubleValue2 + dDoubleValue3);
        }
    };
    private static final com.alibaba.android.bindingx.core.internal.TimingFunctions.InnerCache<com.alibaba.android.bindingx.core.internal.TimingFunctions.BezierInterpolatorWrapper> cache = new com.alibaba.android.bindingx.core.internal.TimingFunctions.InnerCache<>(4);
    private static java.lang.Object easeInQuad = new com.alibaba.android.bindingx.core.internal.JSFunctionInterface() { // from class: com.alibaba.android.bindingx.core.internal.TimingFunctions.3
        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public java.lang.Object execute(java.util.ArrayList<java.lang.Object> arrayList) throws org.json.JSONException, java.lang.NumberFormatException {
            double dDoubleValue = ((java.lang.Double) arrayList.get(0)).doubleValue();
            double dDoubleValue2 = ((java.lang.Double) arrayList.get(1)).doubleValue();
            double dDoubleValue3 = ((java.lang.Double) arrayList.get(2)).doubleValue();
            double dDoubleValue4 = ((java.lang.Double) arrayList.get(3)).doubleValue();
            double dMin = java.lang.Math.min(dDoubleValue, dDoubleValue4) / dDoubleValue4;
            return java.lang.Double.valueOf((dDoubleValue3 * dMin * dMin) + dDoubleValue2);
        }
    };
    private static java.lang.Object easeOutQuad = new com.alibaba.android.bindingx.core.internal.JSFunctionInterface() { // from class: com.alibaba.android.bindingx.core.internal.TimingFunctions.4
        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public java.lang.Object execute(java.util.ArrayList<java.lang.Object> arrayList) throws org.json.JSONException, java.lang.NumberFormatException {
            double dDoubleValue = ((java.lang.Double) arrayList.get(0)).doubleValue();
            double dDoubleValue2 = ((java.lang.Double) arrayList.get(1)).doubleValue();
            double dDoubleValue3 = ((java.lang.Double) arrayList.get(2)).doubleValue();
            double dDoubleValue4 = ((java.lang.Double) arrayList.get(3)).doubleValue();
            double dMin = java.lang.Math.min(dDoubleValue, dDoubleValue4) / dDoubleValue4;
            return java.lang.Double.valueOf(((-dDoubleValue3) * dMin * (dMin - 2.0d)) + dDoubleValue2);
        }
    };
    private static java.lang.Object easeInOutQuad = new com.alibaba.android.bindingx.core.internal.JSFunctionInterface() { // from class: com.alibaba.android.bindingx.core.internal.TimingFunctions.5
        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public java.lang.Object execute(java.util.ArrayList<java.lang.Object> arrayList) throws org.json.JSONException, java.lang.NumberFormatException {
            double dDoubleValue = ((java.lang.Double) arrayList.get(0)).doubleValue();
            double dDoubleValue2 = ((java.lang.Double) arrayList.get(1)).doubleValue();
            double dDoubleValue3 = ((java.lang.Double) arrayList.get(2)).doubleValue();
            double dDoubleValue4 = ((java.lang.Double) arrayList.get(3)).doubleValue();
            double dMin = java.lang.Math.min(dDoubleValue, dDoubleValue4) / (dDoubleValue4 / 2.0d);
            if (dMin < 1.0d) {
                return java.lang.Double.valueOf(((dDoubleValue3 / 2.0d) * dMin * dMin) + dDoubleValue2);
            }
            double d = dMin - 1.0d;
            return java.lang.Double.valueOf((((-dDoubleValue3) / 2.0d) * ((d * (d - 2.0d)) - 1.0d)) + dDoubleValue2);
        }
    };
    private static java.lang.Object easeInCubic = new com.alibaba.android.bindingx.core.internal.JSFunctionInterface() { // from class: com.alibaba.android.bindingx.core.internal.TimingFunctions.6
        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public java.lang.Object execute(java.util.ArrayList<java.lang.Object> arrayList) throws org.json.JSONException, java.lang.NumberFormatException {
            double dDoubleValue = ((java.lang.Double) arrayList.get(0)).doubleValue();
            double dDoubleValue2 = ((java.lang.Double) arrayList.get(1)).doubleValue();
            double dDoubleValue3 = ((java.lang.Double) arrayList.get(2)).doubleValue();
            double dDoubleValue4 = ((java.lang.Double) arrayList.get(3)).doubleValue();
            double dMin = java.lang.Math.min(dDoubleValue, dDoubleValue4) / dDoubleValue4;
            return java.lang.Double.valueOf((dDoubleValue3 * dMin * dMin * dMin) + dDoubleValue2);
        }
    };
    private static java.lang.Object easeOutCubic = new com.alibaba.android.bindingx.core.internal.JSFunctionInterface() { // from class: com.alibaba.android.bindingx.core.internal.TimingFunctions.7
        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public java.lang.Object execute(java.util.ArrayList<java.lang.Object> arrayList) throws org.json.JSONException, java.lang.NumberFormatException {
            double dDoubleValue = ((java.lang.Double) arrayList.get(0)).doubleValue();
            double dDoubleValue2 = ((java.lang.Double) arrayList.get(1)).doubleValue();
            double dDoubleValue3 = ((java.lang.Double) arrayList.get(2)).doubleValue();
            double dDoubleValue4 = ((java.lang.Double) arrayList.get(3)).doubleValue();
            double dMin = (java.lang.Math.min(dDoubleValue, dDoubleValue4) / dDoubleValue4) - 1.0d;
            return java.lang.Double.valueOf((dDoubleValue3 * ((dMin * dMin * dMin) + 1.0d)) + dDoubleValue2);
        }
    };
    private static java.lang.Object easeInOutCubic = new com.alibaba.android.bindingx.core.internal.JSFunctionInterface() { // from class: com.alibaba.android.bindingx.core.internal.TimingFunctions.8
        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public java.lang.Object execute(java.util.ArrayList<java.lang.Object> arrayList) throws org.json.JSONException, java.lang.NumberFormatException {
            double dDoubleValue = ((java.lang.Double) arrayList.get(0)).doubleValue();
            double dDoubleValue2 = ((java.lang.Double) arrayList.get(1)).doubleValue();
            double dDoubleValue3 = ((java.lang.Double) arrayList.get(2)).doubleValue();
            double dDoubleValue4 = ((java.lang.Double) arrayList.get(3)).doubleValue();
            double dMin = java.lang.Math.min(dDoubleValue, dDoubleValue4) / (dDoubleValue4 / 2.0d);
            if (dMin < 1.0d) {
                return java.lang.Double.valueOf(((dDoubleValue3 / 2.0d) * dMin * dMin * dMin) + dDoubleValue2);
            }
            double d = dMin - 2.0d;
            return java.lang.Double.valueOf(((dDoubleValue3 / 2.0d) * ((d * d * d) + 2.0d)) + dDoubleValue2);
        }
    };
    private static java.lang.Object easeInQuart = new com.alibaba.android.bindingx.core.internal.JSFunctionInterface() { // from class: com.alibaba.android.bindingx.core.internal.TimingFunctions.9
        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public java.lang.Object execute(java.util.ArrayList<java.lang.Object> arrayList) throws org.json.JSONException, java.lang.NumberFormatException {
            double dDoubleValue = ((java.lang.Double) arrayList.get(0)).doubleValue();
            double dDoubleValue2 = ((java.lang.Double) arrayList.get(1)).doubleValue();
            double dDoubleValue3 = ((java.lang.Double) arrayList.get(2)).doubleValue();
            double dDoubleValue4 = ((java.lang.Double) arrayList.get(3)).doubleValue();
            double dMin = java.lang.Math.min(dDoubleValue, dDoubleValue4) / dDoubleValue4;
            return java.lang.Double.valueOf((dDoubleValue3 * dMin * dMin * dMin * dMin) + dDoubleValue2);
        }
    };
    private static java.lang.Object easeOutQuart = new com.alibaba.android.bindingx.core.internal.JSFunctionInterface() { // from class: com.alibaba.android.bindingx.core.internal.TimingFunctions.10
        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public java.lang.Object execute(java.util.ArrayList<java.lang.Object> arrayList) throws org.json.JSONException, java.lang.NumberFormatException {
            double dDoubleValue = ((java.lang.Double) arrayList.get(0)).doubleValue();
            double dDoubleValue2 = ((java.lang.Double) arrayList.get(1)).doubleValue();
            double dDoubleValue3 = ((java.lang.Double) arrayList.get(2)).doubleValue();
            double dDoubleValue4 = ((java.lang.Double) arrayList.get(3)).doubleValue();
            double dMin = (java.lang.Math.min(dDoubleValue, dDoubleValue4) / dDoubleValue4) - 1.0d;
            return java.lang.Double.valueOf(((-dDoubleValue3) * ((((dMin * dMin) * dMin) * dMin) - 1.0d)) + dDoubleValue2);
        }
    };
    private static java.lang.Object easeInOutQuart = new com.alibaba.android.bindingx.core.internal.JSFunctionInterface() { // from class: com.alibaba.android.bindingx.core.internal.TimingFunctions.11
        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public java.lang.Object execute(java.util.ArrayList<java.lang.Object> arrayList) throws org.json.JSONException, java.lang.NumberFormatException {
            double dDoubleValue = ((java.lang.Double) arrayList.get(0)).doubleValue();
            double dDoubleValue2 = ((java.lang.Double) arrayList.get(1)).doubleValue();
            double dDoubleValue3 = ((java.lang.Double) arrayList.get(2)).doubleValue();
            double dDoubleValue4 = ((java.lang.Double) arrayList.get(3)).doubleValue();
            double dMin = java.lang.Math.min(dDoubleValue, dDoubleValue4) / (dDoubleValue4 / 2.0d);
            if (dMin < 1.0d) {
                return java.lang.Double.valueOf(((dDoubleValue3 / 2.0d) * dMin * dMin * dMin * dMin) + dDoubleValue2);
            }
            double d = dMin - 2.0d;
            return java.lang.Double.valueOf((((-dDoubleValue3) / 2.0d) * ((((d * d) * d) * d) - 2.0d)) + dDoubleValue2);
        }
    };
    private static java.lang.Object easeInQuint = new com.alibaba.android.bindingx.core.internal.JSFunctionInterface() { // from class: com.alibaba.android.bindingx.core.internal.TimingFunctions.12
        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public java.lang.Object execute(java.util.ArrayList<java.lang.Object> arrayList) throws org.json.JSONException, java.lang.NumberFormatException {
            double dDoubleValue = ((java.lang.Double) arrayList.get(0)).doubleValue();
            double dDoubleValue2 = ((java.lang.Double) arrayList.get(1)).doubleValue();
            double dDoubleValue3 = ((java.lang.Double) arrayList.get(2)).doubleValue();
            double dDoubleValue4 = ((java.lang.Double) arrayList.get(3)).doubleValue();
            double dMin = java.lang.Math.min(dDoubleValue, dDoubleValue4) / dDoubleValue4;
            return java.lang.Double.valueOf((dDoubleValue3 * dMin * dMin * dMin * dMin * dMin) + dDoubleValue2);
        }
    };
    private static java.lang.Object easeOutQuint = new com.alibaba.android.bindingx.core.internal.JSFunctionInterface() { // from class: com.alibaba.android.bindingx.core.internal.TimingFunctions.13
        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public java.lang.Object execute(java.util.ArrayList<java.lang.Object> arrayList) throws org.json.JSONException, java.lang.NumberFormatException {
            double dDoubleValue = ((java.lang.Double) arrayList.get(0)).doubleValue();
            double dDoubleValue2 = ((java.lang.Double) arrayList.get(1)).doubleValue();
            double dDoubleValue3 = ((java.lang.Double) arrayList.get(2)).doubleValue();
            double dDoubleValue4 = ((java.lang.Double) arrayList.get(3)).doubleValue();
            double dMin = (java.lang.Math.min(dDoubleValue, dDoubleValue4) / dDoubleValue4) - 1.0d;
            return java.lang.Double.valueOf((dDoubleValue3 * ((dMin * dMin * dMin * dMin * dMin) + 1.0d)) + dDoubleValue2);
        }
    };
    private static java.lang.Object easeInOutQuint = new com.alibaba.android.bindingx.core.internal.JSFunctionInterface() { // from class: com.alibaba.android.bindingx.core.internal.TimingFunctions.14
        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public java.lang.Object execute(java.util.ArrayList<java.lang.Object> arrayList) throws org.json.JSONException, java.lang.NumberFormatException {
            double dDoubleValue = ((java.lang.Double) arrayList.get(0)).doubleValue();
            double dDoubleValue2 = ((java.lang.Double) arrayList.get(1)).doubleValue();
            double dDoubleValue3 = ((java.lang.Double) arrayList.get(2)).doubleValue();
            double dDoubleValue4 = ((java.lang.Double) arrayList.get(3)).doubleValue();
            double dMin = java.lang.Math.min(dDoubleValue, dDoubleValue4) / (dDoubleValue4 / 2.0d);
            if (dMin < 1.0d) {
                return java.lang.Double.valueOf(((dDoubleValue3 / 2.0d) * dMin * dMin * dMin * dMin * dMin) + dDoubleValue2);
            }
            double d = dMin - 2.0d;
            return java.lang.Double.valueOf(((dDoubleValue3 / 2.0d) * ((d * d * d * d * d) + 2.0d)) + dDoubleValue2);
        }
    };
    private static java.lang.Object easeInSine = new com.alibaba.android.bindingx.core.internal.JSFunctionInterface() { // from class: com.alibaba.android.bindingx.core.internal.TimingFunctions.15
        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public java.lang.Object execute(java.util.ArrayList<java.lang.Object> arrayList) throws org.json.JSONException, java.lang.NumberFormatException {
            double dDoubleValue = ((java.lang.Double) arrayList.get(0)).doubleValue();
            double dDoubleValue2 = ((java.lang.Double) arrayList.get(1)).doubleValue();
            double dDoubleValue3 = ((java.lang.Double) arrayList.get(2)).doubleValue();
            double dDoubleValue4 = ((java.lang.Double) arrayList.get(3)).doubleValue();
            return java.lang.Double.valueOf(((-dDoubleValue3) * java.lang.Math.cos((java.lang.Math.min(dDoubleValue, dDoubleValue4) / dDoubleValue4) * 1.5707963267948966d)) + dDoubleValue3 + dDoubleValue2);
        }
    };
    private static java.lang.Object easeOutSine = new com.alibaba.android.bindingx.core.internal.JSFunctionInterface() { // from class: com.alibaba.android.bindingx.core.internal.TimingFunctions.16
        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public java.lang.Object execute(java.util.ArrayList<java.lang.Object> arrayList) throws org.json.JSONException, java.lang.NumberFormatException {
            double dDoubleValue = ((java.lang.Double) arrayList.get(0)).doubleValue();
            double dDoubleValue2 = ((java.lang.Double) arrayList.get(1)).doubleValue();
            double dDoubleValue3 = ((java.lang.Double) arrayList.get(2)).doubleValue();
            double dDoubleValue4 = ((java.lang.Double) arrayList.get(3)).doubleValue();
            return java.lang.Double.valueOf((dDoubleValue3 * java.lang.Math.sin((java.lang.Math.min(dDoubleValue, dDoubleValue4) / dDoubleValue4) * 1.5707963267948966d)) + dDoubleValue2);
        }
    };
    private static java.lang.Object easeInOutSine = new com.alibaba.android.bindingx.core.internal.JSFunctionInterface() { // from class: com.alibaba.android.bindingx.core.internal.TimingFunctions.17
        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public java.lang.Object execute(java.util.ArrayList<java.lang.Object> arrayList) throws org.json.JSONException, java.lang.NumberFormatException {
            double dDoubleValue = ((java.lang.Double) arrayList.get(0)).doubleValue();
            double dDoubleValue2 = ((java.lang.Double) arrayList.get(1)).doubleValue();
            double dDoubleValue3 = ((java.lang.Double) arrayList.get(2)).doubleValue();
            double dDoubleValue4 = ((java.lang.Double) arrayList.get(3)).doubleValue();
            return java.lang.Double.valueOf((((-dDoubleValue3) / 2.0d) * (java.lang.Math.cos((java.lang.Math.min(dDoubleValue, dDoubleValue4) * 3.141592653589793d) / dDoubleValue4) - 1.0d)) + dDoubleValue2);
        }
    };
    private static java.lang.Object easeInExpo = new com.alibaba.android.bindingx.core.internal.JSFunctionInterface() { // from class: com.alibaba.android.bindingx.core.internal.TimingFunctions.18
        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public java.lang.Object execute(java.util.ArrayList<java.lang.Object> arrayList) throws org.json.JSONException, java.lang.NumberFormatException {
            double dDoubleValue = ((java.lang.Double) arrayList.get(0)).doubleValue();
            double dDoubleValue2 = ((java.lang.Double) arrayList.get(1)).doubleValue();
            double dDoubleValue3 = ((java.lang.Double) arrayList.get(2)).doubleValue();
            double dDoubleValue4 = ((java.lang.Double) arrayList.get(3)).doubleValue();
            double dMin = java.lang.Math.min(dDoubleValue, dDoubleValue4);
            if (dMin != 0.0d) {
                dDoubleValue2 += dDoubleValue3 * java.lang.Math.pow(2.0d, ((dMin / dDoubleValue4) - 1.0d) * 10.0d);
            }
            return java.lang.Double.valueOf(dDoubleValue2);
        }
    };
    private static java.lang.Object easeOutExpo = new com.alibaba.android.bindingx.core.internal.JSFunctionInterface() { // from class: com.alibaba.android.bindingx.core.internal.TimingFunctions.19
        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public java.lang.Object execute(java.util.ArrayList<java.lang.Object> arrayList) throws org.json.JSONException, java.lang.NumberFormatException {
            double dDoubleValue = ((java.lang.Double) arrayList.get(0)).doubleValue();
            double dDoubleValue2 = ((java.lang.Double) arrayList.get(1)).doubleValue();
            double dDoubleValue3 = ((java.lang.Double) arrayList.get(2)).doubleValue();
            double dDoubleValue4 = ((java.lang.Double) arrayList.get(3)).doubleValue();
            double dMin = java.lang.Math.min(dDoubleValue, dDoubleValue4);
            return java.lang.Double.valueOf(dMin == dDoubleValue4 ? dDoubleValue2 + dDoubleValue3 : dDoubleValue2 + (dDoubleValue3 * ((-java.lang.Math.pow(2.0d, (dMin * (-10.0d)) / dDoubleValue4)) + 1.0d)));
        }
    };
    private static java.lang.Object easeInOutExpo = new com.alibaba.android.bindingx.core.internal.JSFunctionInterface() { // from class: com.alibaba.android.bindingx.core.internal.TimingFunctions.20
        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public java.lang.Object execute(java.util.ArrayList<java.lang.Object> arrayList) throws org.json.JSONException, java.lang.NumberFormatException {
            double dDoubleValue = ((java.lang.Double) arrayList.get(0)).doubleValue();
            java.lang.Double d = (java.lang.Double) arrayList.get(1);
            double dDoubleValue2 = d.doubleValue();
            double dDoubleValue3 = ((java.lang.Double) arrayList.get(2)).doubleValue();
            double dDoubleValue4 = ((java.lang.Double) arrayList.get(3)).doubleValue();
            double dMin = java.lang.Math.min(dDoubleValue, dDoubleValue4);
            if (dMin == 0.0d) {
                return d;
            }
            if (dMin == dDoubleValue4) {
                return java.lang.Double.valueOf(dDoubleValue2 + dDoubleValue3);
            }
            double d2 = dMin / (dDoubleValue4 / 2.0d);
            if (d2 < 1.0d) {
                return java.lang.Double.valueOf(((dDoubleValue3 / 2.0d) * java.lang.Math.pow(2.0d, (d2 - 1.0d) * 10.0d)) + dDoubleValue2);
            }
            return java.lang.Double.valueOf(((dDoubleValue3 / 2.0d) * ((-java.lang.Math.pow(2.0d, (d2 - 1.0d) * (-10.0d))) + 2.0d)) + dDoubleValue2);
        }
    };
    private static java.lang.Object easeInCirc = new com.alibaba.android.bindingx.core.internal.JSFunctionInterface() { // from class: com.alibaba.android.bindingx.core.internal.TimingFunctions.21
        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public java.lang.Object execute(java.util.ArrayList<java.lang.Object> arrayList) throws org.json.JSONException, java.lang.NumberFormatException {
            double dDoubleValue = ((java.lang.Double) arrayList.get(0)).doubleValue();
            double dDoubleValue2 = ((java.lang.Double) arrayList.get(1)).doubleValue();
            double dDoubleValue3 = ((java.lang.Double) arrayList.get(2)).doubleValue();
            double dDoubleValue4 = ((java.lang.Double) arrayList.get(3)).doubleValue();
            double dMin = java.lang.Math.min(dDoubleValue, dDoubleValue4) / dDoubleValue4;
            return java.lang.Double.valueOf(((-dDoubleValue3) * (java.lang.Math.sqrt(1.0d - (dMin * dMin)) - 1.0d)) + dDoubleValue2);
        }
    };
    private static java.lang.Object easeOutCirc = new com.alibaba.android.bindingx.core.internal.JSFunctionInterface() { // from class: com.alibaba.android.bindingx.core.internal.TimingFunctions.22
        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public java.lang.Object execute(java.util.ArrayList<java.lang.Object> arrayList) throws org.json.JSONException, java.lang.NumberFormatException {
            double dDoubleValue = ((java.lang.Double) arrayList.get(0)).doubleValue();
            double dDoubleValue2 = ((java.lang.Double) arrayList.get(1)).doubleValue();
            double dDoubleValue3 = ((java.lang.Double) arrayList.get(2)).doubleValue();
            double dDoubleValue4 = ((java.lang.Double) arrayList.get(3)).doubleValue();
            double dMin = (java.lang.Math.min(dDoubleValue, dDoubleValue4) / dDoubleValue4) - 1.0d;
            return java.lang.Double.valueOf((dDoubleValue3 * java.lang.Math.sqrt(1.0d - (dMin * dMin))) + dDoubleValue2);
        }
    };
    private static java.lang.Object easeInOutCirc = new com.alibaba.android.bindingx.core.internal.JSFunctionInterface() { // from class: com.alibaba.android.bindingx.core.internal.TimingFunctions.23
        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public java.lang.Object execute(java.util.ArrayList<java.lang.Object> arrayList) throws org.json.JSONException, java.lang.NumberFormatException {
            double dDoubleValue = ((java.lang.Double) arrayList.get(0)).doubleValue();
            double dDoubleValue2 = ((java.lang.Double) arrayList.get(1)).doubleValue();
            double dDoubleValue3 = ((java.lang.Double) arrayList.get(2)).doubleValue();
            double dDoubleValue4 = ((java.lang.Double) arrayList.get(3)).doubleValue();
            double dMin = java.lang.Math.min(dDoubleValue, dDoubleValue4) / (dDoubleValue4 / 2.0d);
            if (dMin < 1.0d) {
                return java.lang.Double.valueOf((((-dDoubleValue3) / 2.0d) * (java.lang.Math.sqrt(1.0d - (dMin * dMin)) - 1.0d)) + dDoubleValue2);
            }
            double d = dMin - 2.0d;
            return java.lang.Double.valueOf(((dDoubleValue3 / 2.0d) * (java.lang.Math.sqrt(1.0d - (d * d)) + 1.0d)) + dDoubleValue2);
        }
    };
    private static java.lang.Object easeInElastic = new com.alibaba.android.bindingx.core.internal.JSFunctionInterface() { // from class: com.alibaba.android.bindingx.core.internal.TimingFunctions.24
        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public java.lang.Object execute(java.util.ArrayList<java.lang.Object> arrayList) throws org.json.JSONException, java.lang.NumberFormatException {
            double dDoubleValue = ((java.lang.Double) arrayList.get(0)).doubleValue();
            java.lang.Double d = (java.lang.Double) arrayList.get(1);
            double dDoubleValue2 = d.doubleValue();
            double dDoubleValue3 = ((java.lang.Double) arrayList.get(2)).doubleValue();
            double dDoubleValue4 = ((java.lang.Double) arrayList.get(3)).doubleValue();
            double dMin = java.lang.Math.min(dDoubleValue, dDoubleValue4);
            if (dMin == 0.0d) {
                return d;
            }
            double d2 = dMin / dDoubleValue4;
            if (d2 == 1.0d) {
                return java.lang.Double.valueOf(dDoubleValue2 + dDoubleValue3);
            }
            double d3 = 0.3d * dDoubleValue4;
            double d4 = d2 - 1.0d;
            return java.lang.Double.valueOf((-(dDoubleValue3 * java.lang.Math.pow(2.0d, 10.0d * d4) * java.lang.Math.sin((((d4 * dDoubleValue4) - (dDoubleValue3 < java.lang.Math.abs(dDoubleValue3) ? d3 / 4.0d : (d3 / 6.283185307179586d) * java.lang.Math.asin(dDoubleValue3 / dDoubleValue3))) * 6.283185307179586d) / d3))) + dDoubleValue2);
        }
    };
    private static java.lang.Object easeOutElastic = new com.alibaba.android.bindingx.core.internal.JSFunctionInterface() { // from class: com.alibaba.android.bindingx.core.internal.TimingFunctions.25
        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public java.lang.Object execute(java.util.ArrayList<java.lang.Object> arrayList) {
            double dDoubleValue = ((java.lang.Double) arrayList.get(0)).doubleValue();
            java.lang.Double d = (java.lang.Double) arrayList.get(1);
            double dDoubleValue2 = d.doubleValue();
            double dDoubleValue3 = ((java.lang.Double) arrayList.get(2)).doubleValue();
            double dDoubleValue4 = ((java.lang.Double) arrayList.get(3)).doubleValue();
            double dMin = java.lang.Math.min(dDoubleValue, dDoubleValue4);
            if (dMin == 0.0d) {
                return d;
            }
            double d2 = dMin / dDoubleValue4;
            if (d2 == 1.0d) {
                return java.lang.Double.valueOf(dDoubleValue2 + dDoubleValue3);
            }
            double d3 = 0.3d * dDoubleValue4;
            return java.lang.Double.valueOf((java.lang.Math.pow(2.0d, (-10.0d) * d2) * dDoubleValue3 * java.lang.Math.sin((((d2 * dDoubleValue4) - (dDoubleValue3 < java.lang.Math.abs(dDoubleValue3) ? d3 / 4.0d : (d3 / 6.283185307179586d) * java.lang.Math.asin(dDoubleValue3 / dDoubleValue3))) * 6.283185307179586d) / d3)) + dDoubleValue3 + dDoubleValue2);
        }
    };
    private static java.lang.Object easeInOutElastic = new com.alibaba.android.bindingx.core.internal.JSFunctionInterface() { // from class: com.alibaba.android.bindingx.core.internal.TimingFunctions.26
        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public java.lang.Object execute(java.util.ArrayList<java.lang.Object> arrayList) {
            double dDoubleValue = ((java.lang.Double) arrayList.get(0)).doubleValue();
            java.lang.Double d = (java.lang.Double) arrayList.get(1);
            double dDoubleValue2 = d.doubleValue();
            double dDoubleValue3 = ((java.lang.Double) arrayList.get(2)).doubleValue();
            double dDoubleValue4 = ((java.lang.Double) arrayList.get(3)).doubleValue();
            double dMin = java.lang.Math.min(dDoubleValue, dDoubleValue4);
            if (dMin == 0.0d) {
                return d;
            }
            double d2 = dMin / (dDoubleValue4 / 2.0d);
            if (d2 == 2.0d) {
                return java.lang.Double.valueOf(dDoubleValue2 + dDoubleValue3);
            }
            double d3 = 0.44999999999999996d * dDoubleValue4;
            double dAsin = dDoubleValue3 < java.lang.Math.abs(dDoubleValue3) ? d3 / 4.0d : (d3 / 6.283185307179586d) * java.lang.Math.asin(dDoubleValue3 / dDoubleValue3);
            if (d2 < 1.0d) {
                double d4 = d2 - 1.0d;
                return java.lang.Double.valueOf((dDoubleValue3 * java.lang.Math.pow(2.0d, d4 * 10.0d) * java.lang.Math.sin((((d4 * dDoubleValue4) - dAsin) * 6.283185307179586d) / d3) * (-0.5d)) + dDoubleValue2);
            }
            double d5 = d2 - 1.0d;
            return java.lang.Double.valueOf((java.lang.Math.pow(2.0d, (-10.0d) * d5) * dDoubleValue3 * java.lang.Math.sin((((d5 * dDoubleValue4) - dAsin) * 6.283185307179586d) / d3) * 0.5d) + dDoubleValue3 + dDoubleValue2);
        }
    };
    private static java.lang.Object easeInBack = new com.alibaba.android.bindingx.core.internal.JSFunctionInterface() { // from class: com.alibaba.android.bindingx.core.internal.TimingFunctions.27
        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public java.lang.Object execute(java.util.ArrayList<java.lang.Object> arrayList) throws org.json.JSONException, java.lang.NumberFormatException {
            double dDoubleValue = ((java.lang.Double) arrayList.get(0)).doubleValue();
            double dDoubleValue2 = ((java.lang.Double) arrayList.get(1)).doubleValue();
            double dDoubleValue3 = ((java.lang.Double) arrayList.get(2)).doubleValue();
            double dDoubleValue4 = ((java.lang.Double) arrayList.get(3)).doubleValue();
            double dMin = java.lang.Math.min(dDoubleValue, dDoubleValue4) / dDoubleValue4;
            return java.lang.Double.valueOf((dDoubleValue3 * dMin * dMin * ((2.70158d * dMin) - 1.70158d)) + dDoubleValue2);
        }
    };
    private static java.lang.Object easeOutBack = new com.alibaba.android.bindingx.core.internal.JSFunctionInterface() { // from class: com.alibaba.android.bindingx.core.internal.TimingFunctions.28
        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public java.lang.Object execute(java.util.ArrayList<java.lang.Object> arrayList) throws org.json.JSONException, java.lang.NumberFormatException {
            double dDoubleValue = ((java.lang.Double) arrayList.get(0)).doubleValue();
            double dDoubleValue2 = ((java.lang.Double) arrayList.get(1)).doubleValue();
            double dDoubleValue3 = ((java.lang.Double) arrayList.get(2)).doubleValue();
            double dDoubleValue4 = ((java.lang.Double) arrayList.get(3)).doubleValue();
            double dMin = (java.lang.Math.min(dDoubleValue, dDoubleValue4) / dDoubleValue4) - 1.0d;
            return java.lang.Double.valueOf((dDoubleValue3 * ((dMin * dMin * ((2.70158d * dMin) + 1.70158d)) + 1.0d)) + dDoubleValue2);
        }
    };
    private static java.lang.Object easeInOutBack = new com.alibaba.android.bindingx.core.internal.JSFunctionInterface() { // from class: com.alibaba.android.bindingx.core.internal.TimingFunctions.29
        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public java.lang.Object execute(java.util.ArrayList<java.lang.Object> arrayList) throws org.json.JSONException, java.lang.NumberFormatException {
            double dDoubleValue = ((java.lang.Double) arrayList.get(0)).doubleValue();
            double dDoubleValue2 = ((java.lang.Double) arrayList.get(1)).doubleValue();
            double dDoubleValue3 = ((java.lang.Double) arrayList.get(2)).doubleValue();
            double dDoubleValue4 = ((java.lang.Double) arrayList.get(3)).doubleValue();
            double dMin = java.lang.Math.min(dDoubleValue, dDoubleValue4) / (dDoubleValue4 / 2.0d);
            if (dMin < 1.0d) {
                return java.lang.Double.valueOf(((dDoubleValue3 / 2.0d) * dMin * dMin * ((3.5949095d * dMin) - 2.5949095d)) + dDoubleValue2);
            }
            double d = dMin - 2.0d;
            return java.lang.Double.valueOf(((dDoubleValue3 / 2.0d) * ((d * d * ((3.5949095d * d) + 2.5949095d)) + 2.0d)) + dDoubleValue2);
        }
    };
    private static java.lang.Object easeInBounce = new com.alibaba.android.bindingx.core.internal.JSFunctionInterface() { // from class: com.alibaba.android.bindingx.core.internal.TimingFunctions.30
        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public java.lang.Object execute(java.util.ArrayList<java.lang.Object> arrayList) throws org.json.JSONException, java.lang.NumberFormatException {
            double dDoubleValue = ((java.lang.Double) arrayList.get(0)).doubleValue();
            double dDoubleValue2 = ((java.lang.Double) arrayList.get(1)).doubleValue();
            double dDoubleValue3 = ((java.lang.Double) arrayList.get(2)).doubleValue();
            double dDoubleValue4 = ((java.lang.Double) arrayList.get(3)).doubleValue();
            return java.lang.Double.valueOf(com.alibaba.android.bindingx.core.internal.TimingFunctions.easeInBounce(java.lang.Math.min(dDoubleValue, dDoubleValue4), dDoubleValue2, dDoubleValue3, dDoubleValue4));
        }
    };
    private static java.lang.Object easeOutBounce = new com.alibaba.android.bindingx.core.internal.JSFunctionInterface() { // from class: com.alibaba.android.bindingx.core.internal.TimingFunctions.31
        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public java.lang.Object execute(java.util.ArrayList<java.lang.Object> arrayList) throws org.json.JSONException, java.lang.NumberFormatException {
            double dDoubleValue = ((java.lang.Double) arrayList.get(0)).doubleValue();
            double dDoubleValue2 = ((java.lang.Double) arrayList.get(1)).doubleValue();
            double dDoubleValue3 = ((java.lang.Double) arrayList.get(2)).doubleValue();
            double dDoubleValue4 = ((java.lang.Double) arrayList.get(3)).doubleValue();
            return java.lang.Double.valueOf(com.alibaba.android.bindingx.core.internal.TimingFunctions.easeOutBounce(java.lang.Math.min(dDoubleValue, dDoubleValue4), dDoubleValue2, dDoubleValue3, dDoubleValue4));
        }
    };
    private static java.lang.Object easeInOutBounce = new com.alibaba.android.bindingx.core.internal.JSFunctionInterface() { // from class: com.alibaba.android.bindingx.core.internal.TimingFunctions.32
        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public java.lang.Object execute(java.util.ArrayList<java.lang.Object> arrayList) throws org.json.JSONException, java.lang.NumberFormatException {
            double dDoubleValue = ((java.lang.Double) arrayList.get(0)).doubleValue();
            double dDoubleValue2 = ((java.lang.Double) arrayList.get(1)).doubleValue();
            double dDoubleValue3 = ((java.lang.Double) arrayList.get(2)).doubleValue();
            double dDoubleValue4 = ((java.lang.Double) arrayList.get(3)).doubleValue();
            double dMin = java.lang.Math.min(dDoubleValue, dDoubleValue4);
            return dMin < dDoubleValue4 / 2.0d ? java.lang.Double.valueOf((com.alibaba.android.bindingx.core.internal.TimingFunctions.easeInBounce(dMin * 2.0d, 0.0d, dDoubleValue3, dDoubleValue4) * 0.5d) + dDoubleValue2) : java.lang.Double.valueOf((com.alibaba.android.bindingx.core.internal.TimingFunctions.easeOutBounce((dMin * 2.0d) - dDoubleValue4, 0.0d, dDoubleValue3, dDoubleValue4) * 0.5d) + (dDoubleValue3 * 0.5d) + dDoubleValue2);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static double easeOutBounce(double d, double d2, double d3, double d4) {
        double d5;
        double d6;
        double d7;
        double d8 = d / d4;
        if (d8 < 0.36363636363636365d) {
            d7 = 7.5625d * d8 * d8;
        } else {
            if (d8 < 0.7272727272727273d) {
                double d9 = d8 - 0.5454545454545454d;
                d5 = 7.5625d * d9 * d9;
                d6 = 0.75d;
            } else if (d8 < 0.9090909090909091d) {
                double d10 = d8 - 0.8181818181818182d;
                d5 = 7.5625d * d10 * d10;
                d6 = 0.9375d;
            } else {
                double d11 = d8 - 0.9545454545454546d;
                d5 = 7.5625d * d11 * d11;
                d6 = 0.984375d;
            }
            d7 = d5 + d6;
        }
        return (d3 * d7) + d2;
    }

    private TimingFunctions() {
    }

    static void applyToScope(java.util.Map<java.lang.String, java.lang.Object> map) {
        map.put("linear", linear);
        map.put("easeInQuad", easeInQuad);
        map.put("easeOutQuad", easeOutQuad);
        map.put("easeInOutQuad", easeInOutQuad);
        map.put("easeInCubic", easeInCubic);
        map.put("easeOutCubic", easeOutCubic);
        map.put("easeInOutCubic", easeInOutCubic);
        map.put("easeInQuart", easeInQuart);
        map.put("easeOutQuart", easeOutQuart);
        map.put("easeInOutQuart", easeInOutQuart);
        map.put("easeInQuint", easeInQuint);
        map.put("easeOutQuint", easeOutQuint);
        map.put("easeInOutQuint", easeInOutQuint);
        map.put("easeInSine", easeInSine);
        map.put("easeOutSine", easeOutSine);
        map.put("easeInOutSine", easeInOutSine);
        map.put("easeInExpo", easeInExpo);
        map.put("easeOutExpo", easeOutExpo);
        map.put("easeInOutExpo", easeInOutExpo);
        map.put("easeInCirc", easeInCirc);
        map.put("easeOutCirc", easeOutCirc);
        map.put("easeInOutCirc", easeInOutCirc);
        map.put("easeInElastic", easeInElastic);
        map.put("easeOutElastic", easeOutElastic);
        map.put("easeInOutElastic", easeInOutElastic);
        map.put("easeInBack", easeInBack);
        map.put("easeOutBack", easeOutBack);
        map.put("easeInOutBack", easeInOutBack);
        map.put("easeInBounce", easeInBounce);
        map.put("easeOutBounce", easeOutBounce);
        map.put("easeInOutBounce", easeInOutBounce);
        map.put("cubicBezier", cubicBezier);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.alibaba.android.bindingx.core.internal.TimingFunctions.BezierInterpolatorWrapper isCacheHit(float f, float f2, float f3, float f4) {
        for (com.alibaba.android.bindingx.core.internal.TimingFunctions.BezierInterpolatorWrapper bezierInterpolatorWrapper : cache.getAll()) {
            if (java.lang.Float.compare(bezierInterpolatorWrapper.x1, f) == 0 && java.lang.Float.compare(bezierInterpolatorWrapper.x2, f3) == 0 && java.lang.Float.compare(bezierInterpolatorWrapper.y1, f2) == 0 && java.lang.Float.compare(bezierInterpolatorWrapper.y2, f4) == 0) {
                return bezierInterpolatorWrapper;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static double easeInBounce(double d, double d2, double d3, double d4) {
        return (d3 - easeOutBounce(d4 - d, 0.0d, d3, d4)) + d2;
    }

    private static class InnerCache<T> {
        private final java.util.ArrayDeque<T> deque;

        InnerCache(int i) {
            this.deque = new java.util.ArrayDeque<>(i);
        }

        void add(T t) {
            if (this.deque.size() >= 4) {
                this.deque.removeFirst();
                this.deque.addLast(t);
            } else {
                this.deque.addLast(t);
            }
        }

        java.util.Deque<T> getAll() {
            return this.deque;
        }
    }

    private static class BezierInterpolatorWrapper implements android.view.animation.Interpolator {
        private android.view.animation.Interpolator mInnerInterpolator;
        float x1;
        float x2;
        float y1;
        float y2;

        BezierInterpolatorWrapper(float f, float f2, float f3, float f4) {
            this.x1 = f;
            this.y1 = f2;
            this.x2 = f3;
            this.y2 = f4;
            this.mInnerInterpolator = androidx.core.view.animation.PathInterpolatorCompat.create(f, f2, f3, f4);
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return this.mInnerInterpolator.getInterpolation(f);
        }
    }
}
