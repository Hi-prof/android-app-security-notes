package com.alibaba.android.bindingx.core.internal;

/* JADX INFO: loaded from: classes.dex */
public class BindingXOrientationHandler extends com.alibaba.android.bindingx.core.internal.AbstractEventHandler implements com.alibaba.android.bindingx.core.internal.OrientationDetector.OnOrientationChangedListener {
    private boolean isStarted;
    private com.alibaba.android.bindingx.core.internal.OrientationEvaluator mEvaluator3D;
    private com.alibaba.android.bindingx.core.internal.OrientationEvaluator mEvaluatorX;
    private com.alibaba.android.bindingx.core.internal.OrientationEvaluator mEvaluatorY;
    private double mLastAlpha;
    private double mLastBeta;
    private double mLastGamma;
    private com.alibaba.android.bindingx.core.internal.OrientationDetector mOrientationDetector;
    private java.util.LinkedList<java.lang.Double> mRecordsAlpha;
    private java.lang.String mSceneType;
    private double mStartAlpha;
    private double mStartBeta;
    private double mStartGamma;
    private com.alibaba.android.bindingx.core.internal.BindingXOrientationHandler.ValueHolder mValueHolder;
    private com.alibaba.android.bindingx.core.internal.Vector3 mVectorX;
    private com.alibaba.android.bindingx.core.internal.Vector3 mVectorY;

    @Override // com.alibaba.android.bindingx.core.IEventHandler
    public void onStart(java.lang.String str, java.lang.String str2) {
    }

    public BindingXOrientationHandler(android.content.Context context, com.alibaba.android.bindingx.core.PlatformManager platformManager, java.lang.Object... objArr) {
        super(context, platformManager, objArr);
        this.isStarted = false;
        this.mRecordsAlpha = new java.util.LinkedList<>();
        this.mVectorX = new com.alibaba.android.bindingx.core.internal.Vector3(0.0d, 0.0d, 1.0d);
        this.mVectorY = new com.alibaba.android.bindingx.core.internal.Vector3(0.0d, 1.0d, 1.0d);
        this.mValueHolder = new com.alibaba.android.bindingx.core.internal.BindingXOrientationHandler.ValueHolder(0.0d, 0.0d, 0.0d);
        if (context != null) {
            this.mOrientationDetector = com.alibaba.android.bindingx.core.internal.OrientationDetector.getInstance(context);
        }
    }

    BindingXOrientationHandler(android.content.Context context, com.alibaba.android.bindingx.core.PlatformManager platformManager, com.alibaba.android.bindingx.core.internal.OrientationDetector orientationDetector, java.lang.Object... objArr) {
        super(context, platformManager, objArr);
        this.isStarted = false;
        this.mRecordsAlpha = new java.util.LinkedList<>();
        this.mVectorX = new com.alibaba.android.bindingx.core.internal.Vector3(0.0d, 0.0d, 1.0d);
        this.mVectorY = new com.alibaba.android.bindingx.core.internal.Vector3(0.0d, 1.0d, 1.0d);
        this.mValueHolder = new com.alibaba.android.bindingx.core.internal.BindingXOrientationHandler.ValueHolder(0.0d, 0.0d, 0.0d);
        this.mOrientationDetector = orientationDetector;
    }

    @Override // com.alibaba.android.bindingx.core.IEventHandler
    public boolean onCreate(java.lang.String str, java.lang.String str2) {
        com.alibaba.android.bindingx.core.internal.OrientationDetector orientationDetector = this.mOrientationDetector;
        if (orientationDetector == null) {
            return false;
        }
        orientationDetector.addOrientationChangedListener(this);
        return this.mOrientationDetector.start(1);
    }

    @Override // com.alibaba.android.bindingx.core.internal.AbstractEventHandler, com.alibaba.android.bindingx.core.IEventHandler
    public void onBindExpression(java.lang.String str, java.util.Map<java.lang.String, java.lang.Object> map, com.alibaba.android.bindingx.core.internal.ExpressionPair expressionPair, java.util.List<java.util.Map<java.lang.String, java.lang.Object>> list, com.alibaba.android.bindingx.core.BindingXCore.JavaScriptCallback javaScriptCallback) {
        java.lang.String lowerCase;
        super.onBindExpression(str, map, expressionPair, list, javaScriptCallback);
        if (map != null) {
            java.lang.String str2 = (java.lang.String) map.get(com.alibaba.android.bindingx.core.internal.BindingXConstants.KEY_SCENE_TYPE);
            if (android.text.TextUtils.isEmpty(str2)) {
                lowerCase = "2d";
            } else {
                lowerCase = str2.toLowerCase();
            }
        } else {
            lowerCase = null;
        }
        if (android.text.TextUtils.isEmpty(lowerCase) || (!"2d".equals(lowerCase) && !"3d".equals(lowerCase))) {
            lowerCase = "2d";
        }
        this.mSceneType = lowerCase;
        com.alibaba.android.bindingx.core.LogProxy.d("[ExpressionOrientationHandler] sceneType is " + lowerCase);
        if ("2d".equals(lowerCase)) {
            this.mEvaluatorX = new com.alibaba.android.bindingx.core.internal.OrientationEvaluator(null, java.lang.Double.valueOf(90.0d), null);
            this.mEvaluatorY = new com.alibaba.android.bindingx.core.internal.OrientationEvaluator(java.lang.Double.valueOf(0.0d), null, java.lang.Double.valueOf(90.0d));
        } else if ("3d".equals(lowerCase)) {
            this.mEvaluator3D = new com.alibaba.android.bindingx.core.internal.OrientationEvaluator(null, null, null);
        }
    }

    @Override // com.alibaba.android.bindingx.core.IEventHandler
    public boolean onDisable(java.lang.String str, java.lang.String str2) {
        clearExpressions();
        if (this.mOrientationDetector == null) {
            return false;
        }
        fireEventByState("end", this.mLastAlpha, this.mLastBeta, this.mLastGamma, new java.lang.Object[0]);
        return this.mOrientationDetector.removeOrientationChangedListener(this);
    }

    @Override // com.alibaba.android.bindingx.core.internal.AbstractEventHandler, com.alibaba.android.bindingx.core.IEventHandler
    public void onDestroy() {
        super.onDestroy();
        com.alibaba.android.bindingx.core.internal.OrientationDetector orientationDetector = this.mOrientationDetector;
        if (orientationDetector != null) {
            orientationDetector.removeOrientationChangedListener(this);
            this.mOrientationDetector.stop();
        }
        if (this.mExpressionHoldersMap != null) {
            this.mExpressionHoldersMap.clear();
            this.mExpressionHoldersMap = null;
        }
    }

    @Override // com.alibaba.android.bindingx.core.internal.OrientationDetector.OnOrientationChangedListener
    public void onOrientationChanged(double d, double d2, double d3) {
        boolean zCalculate3D;
        double dRound = java.lang.Math.round(d);
        double dRound2 = java.lang.Math.round(d2);
        double dRound3 = java.lang.Math.round(d3);
        if (dRound == this.mLastAlpha && dRound2 == this.mLastBeta && dRound3 == this.mLastGamma) {
            return;
        }
        if (!this.isStarted) {
            this.isStarted = true;
            fireEventByState("start", dRound, dRound2, dRound3, new java.lang.Object[0]);
            dRound = dRound;
            dRound2 = dRound2;
            dRound3 = dRound3;
            this.mStartAlpha = dRound;
            this.mStartBeta = dRound2;
            this.mStartGamma = dRound3;
        }
        if ("2d".equals(this.mSceneType)) {
            zCalculate3D = calculate2D(dRound, dRound2, dRound3);
        } else {
            zCalculate3D = "3d".equals(this.mSceneType) ? calculate3D(dRound, dRound2, dRound3) : false;
        }
        if (zCalculate3D) {
            double d4 = this.mValueHolder.x;
            double d5 = this.mValueHolder.y;
            double d6 = this.mValueHolder.z;
            this.mLastAlpha = dRound;
            this.mLastBeta = dRound2;
            this.mLastGamma = dRound3;
            try {
                if (com.alibaba.android.bindingx.core.LogProxy.sEnableLog) {
                    com.alibaba.android.bindingx.core.LogProxy.d(java.lang.String.format(java.util.Locale.getDefault(), "[OrientationHandler] orientation changed. (alpha:%f,beta:%f,gamma:%f,x:%f,y:%f,z:%f)", java.lang.Double.valueOf(dRound), java.lang.Double.valueOf(dRound2), java.lang.Double.valueOf(dRound3), java.lang.Double.valueOf(d4), java.lang.Double.valueOf(d5), java.lang.Double.valueOf(d6)));
                }
                com.alibaba.android.bindingx.core.internal.JSMath.applyOrientationValuesToScope(this.mScope, dRound, dRound2, dRound3, this.mStartAlpha, this.mStartBeta, this.mStartGamma, d4, d5, d6);
                if (evaluateExitExpression(this.mExitExpressionPair, this.mScope)) {
                    return;
                }
                consumeExpression(this.mExpressionHoldersMap, this.mScope, "orientation");
            } catch (java.lang.Exception e) {
                com.alibaba.android.bindingx.core.LogProxy.e("runtime error", e);
            }
        }
    }

    private boolean calculate2D(double d, double d2, double d3) {
        if (this.mEvaluatorX != null && this.mEvaluatorY != null) {
            this.mRecordsAlpha.add(java.lang.Double.valueOf(d));
            if (this.mRecordsAlpha.size() > 5) {
                this.mRecordsAlpha.removeFirst();
            }
            formatRecords(this.mRecordsAlpha, 360);
            java.util.LinkedList<java.lang.Double> linkedList = this.mRecordsAlpha;
            double dDoubleValue = (linkedList.get(linkedList.size() - 1).doubleValue() - this.mStartAlpha) % 360.0d;
            com.alibaba.android.bindingx.core.internal.Quaternion quaternionCalculate = this.mEvaluatorX.calculate(d, d2, d3, dDoubleValue);
            com.alibaba.android.bindingx.core.internal.Quaternion quaternionCalculate2 = this.mEvaluatorY.calculate(d, d2, d3, dDoubleValue);
            this.mVectorX.set(0.0d, 0.0d, 1.0d);
            this.mVectorX.applyQuaternion(quaternionCalculate);
            this.mVectorY.set(0.0d, 1.0d, 1.0d);
            this.mVectorY.applyQuaternion(quaternionCalculate2);
            double degrees = java.lang.Math.toDegrees(java.lang.Math.acos(this.mVectorX.x)) - 90.0d;
            double degrees2 = java.lang.Math.toDegrees(java.lang.Math.acos(this.mVectorY.y)) - 90.0d;
            if (java.lang.Double.isNaN(degrees) || java.lang.Double.isNaN(degrees2) || java.lang.Double.isInfinite(degrees) || java.lang.Double.isInfinite(degrees2)) {
                return false;
            }
            double dRound = java.lang.Math.round(degrees);
            double dRound2 = java.lang.Math.round(degrees2);
            this.mValueHolder.x = dRound;
            this.mValueHolder.y = dRound2;
        }
        return true;
    }

    private boolean calculate3D(double d, double d2, double d3) {
        if (this.mEvaluator3D != null) {
            this.mRecordsAlpha.add(java.lang.Double.valueOf(d));
            if (this.mRecordsAlpha.size() > 5) {
                this.mRecordsAlpha.removeFirst();
            }
            formatRecords(this.mRecordsAlpha, 360);
            java.util.LinkedList<java.lang.Double> linkedList = this.mRecordsAlpha;
            com.alibaba.android.bindingx.core.internal.Quaternion quaternionCalculate = this.mEvaluator3D.calculate(d, d2, d3, (linkedList.get(linkedList.size() - 1).doubleValue() - this.mStartAlpha) % 360.0d);
            if (java.lang.Double.isNaN(quaternionCalculate.x) || java.lang.Double.isNaN(quaternionCalculate.y) || java.lang.Double.isNaN(quaternionCalculate.z) || java.lang.Double.isInfinite(quaternionCalculate.x) || java.lang.Double.isInfinite(quaternionCalculate.y) || java.lang.Double.isInfinite(quaternionCalculate.z)) {
                return false;
            }
            this.mValueHolder.x = quaternionCalculate.x;
            this.mValueHolder.y = quaternionCalculate.y;
            this.mValueHolder.z = quaternionCalculate.z;
        }
        return true;
    }

    private void formatRecords(java.util.List<java.lang.Double> list, int i) {
        int size = list.size();
        if (size > 1) {
            for (int i2 = 1; i2 < size; i2++) {
                int i3 = i2 - 1;
                if (list.get(i3) != null && list.get(i2) != null) {
                    if (list.get(i2).doubleValue() - list.get(i3).doubleValue() < (-i) / 2) {
                        double d = i;
                        list.set(i2, java.lang.Double.valueOf(list.get(i2).doubleValue() + ((java.lang.Math.floor(list.get(i3).doubleValue() / d) + 1.0d) * d)));
                    }
                    if (list.get(i2).doubleValue() - list.get(i3).doubleValue() > i / 2) {
                        list.set(i2, java.lang.Double.valueOf(list.get(i2).doubleValue() - ((double) i)));
                    }
                }
            }
        }
    }

    @Override // com.alibaba.android.bindingx.core.internal.AbstractEventHandler
    protected void onExit(java.util.Map<java.lang.String, java.lang.Object> map) {
        fireEventByState(com.alibaba.android.bindingx.core.internal.BindingXConstants.STATE_EXIT, ((java.lang.Double) map.get("alpha")).doubleValue(), ((java.lang.Double) map.get("beta")).doubleValue(), ((java.lang.Double) map.get("gamma")).doubleValue(), new java.lang.Object[0]);
    }

    @Override // com.alibaba.android.bindingx.core.internal.AbstractEventHandler
    protected void onUserIntercept(java.lang.String str, java.util.Map<java.lang.String, java.lang.Object> map) {
        fireEventByState(com.alibaba.android.bindingx.core.internal.BindingXConstants.STATE_INTERCEPTOR, ((java.lang.Double) map.get("alpha")).doubleValue(), ((java.lang.Double) map.get("beta")).doubleValue(), ((java.lang.Double) map.get("gamma")).doubleValue(), java.util.Collections.singletonMap(com.alibaba.android.bindingx.core.internal.BindingXConstants.STATE_INTERCEPTOR, str));
    }

    private void fireEventByState(java.lang.String str, double d, double d2, double d3, java.lang.Object... objArr) {
        if (this.mCallback != null) {
            java.util.HashMap map = new java.util.HashMap();
            map.put("state", str);
            map.put("alpha", java.lang.Double.valueOf(d));
            map.put("beta", java.lang.Double.valueOf(d2));
            map.put("gamma", java.lang.Double.valueOf(d3));
            map.put(com.alibaba.android.bindingx.core.internal.BindingXConstants.KEY_TOKEN, this.mToken);
            if (objArr != null && objArr.length > 0) {
                java.lang.Object obj = objArr[0];
                if (obj instanceof java.util.Map) {
                    map.putAll((java.util.Map) obj);
                }
            }
            this.mCallback.callback(map);
            com.alibaba.android.bindingx.core.LogProxy.d(">>>>>>>>>>>fire event:(" + str + "," + d + "," + d2 + "," + d3 + com.taobao.weex.el.parse.Operators.BRACKET_END_STR);
        }
    }

    @Override // com.alibaba.android.bindingx.core.IEventHandler
    public void onActivityPause() {
        com.alibaba.android.bindingx.core.internal.OrientationDetector orientationDetector = this.mOrientationDetector;
        if (orientationDetector != null) {
            orientationDetector.stop();
        }
    }

    @Override // com.alibaba.android.bindingx.core.IEventHandler
    public void onActivityResume() {
        com.alibaba.android.bindingx.core.internal.OrientationDetector orientationDetector = this.mOrientationDetector;
        if (orientationDetector != null) {
            orientationDetector.start(1);
        }
    }

    static class ValueHolder {
        double x;
        double y;
        double z;

        ValueHolder() {
        }

        ValueHolder(double d, double d2, double d3) {
            this.x = d;
            this.y = d2;
            this.z = d3;
        }
    }
}
