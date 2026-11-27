package com.alibaba.android.bindingx.core.internal;

/* JADX INFO: loaded from: classes.dex */
class OrientationEvaluator {
    private java.lang.Double constraintAlpha;
    private java.lang.Double constraintBeta;
    private java.lang.Double constraintGamma;
    private com.alibaba.android.bindingx.core.internal.Quaternion quaternion = new com.alibaba.android.bindingx.core.internal.Quaternion(0.0d, 0.0d, 0.0d, 1.0d);
    private double constraintAlphaOffset = 0.0d;
    private double constraintBetaOffset = 0.0d;
    private double constraintGammaOffset = 0.0d;
    private final com.alibaba.android.bindingx.core.internal.Vector3 ZEE = new com.alibaba.android.bindingx.core.internal.Vector3(0.0d, 0.0d, 1.0d);
    private final com.alibaba.android.bindingx.core.internal.Euler EULER = new com.alibaba.android.bindingx.core.internal.Euler();
    private final com.alibaba.android.bindingx.core.internal.Quaternion Q0 = new com.alibaba.android.bindingx.core.internal.Quaternion();
    private final com.alibaba.android.bindingx.core.internal.Quaternion Q1 = new com.alibaba.android.bindingx.core.internal.Quaternion(-java.lang.Math.sqrt(0.5d), 0.0d, 0.0d, java.lang.Math.sqrt(0.5d));

    OrientationEvaluator(java.lang.Double d, java.lang.Double d2, java.lang.Double d3) {
        this.constraintAlpha = null;
        this.constraintBeta = null;
        this.constraintGamma = null;
        this.constraintAlpha = d;
        this.constraintBeta = d2;
        this.constraintGamma = d3;
    }

    com.alibaba.android.bindingx.core.internal.Quaternion calculate(double d, double d2, double d3, double d4) {
        java.lang.Double d5 = this.constraintAlpha;
        double radians = java.lang.Math.toRadians(d5 != null ? d5.doubleValue() : d4 + this.constraintAlphaOffset);
        java.lang.Double d6 = this.constraintBeta;
        double radians2 = java.lang.Math.toRadians(d6 != null ? d6.doubleValue() : this.constraintBetaOffset + d2);
        java.lang.Double d7 = this.constraintGamma;
        setObjectQuaternion(this.quaternion, radians, radians2, java.lang.Math.toRadians(d7 != null ? d7.doubleValue() : this.constraintGammaOffset + d3), 0.0d);
        return this.quaternion;
    }

    private void setObjectQuaternion(com.alibaba.android.bindingx.core.internal.Quaternion quaternion, double d, double d2, double d3, double d4) {
        this.EULER.setValue(d2, d, -d3, "YXZ");
        quaternion.setFromEuler(this.EULER);
        quaternion.multiply(this.Q1);
        quaternion.multiply(this.Q0.setFromAxisAngle(this.ZEE, -d4));
    }
}
