package io.dcloud.weex;

/* JADX INFO: loaded from: classes2.dex */
public class FlingHelper {
    private static float DECELERATION_RATE = (float) (java.lang.Math.log(0.78d) / java.lang.Math.log(0.9d));
    private static float mFlingFriction = android.view.ViewConfiguration.getScrollFriction();
    private static float mPhysicalCoeff;

    public FlingHelper(android.content.Context context) {
        mPhysicalCoeff = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
    }

    private double getSplineDeceleration(int i) {
        return java.lang.Math.log((java.lang.Math.abs(i) * 0.35f) / (mFlingFriction * mPhysicalCoeff));
    }

    private double getSplineDecelerationByDistance(double d) {
        return ((((double) DECELERATION_RATE) - 1.0d) * java.lang.Math.log(d / ((double) (mFlingFriction * mPhysicalCoeff)))) / ((double) DECELERATION_RATE);
    }

    public double getSplineFlingDistance(int i) {
        double splineDeceleration = getSplineDeceleration(i);
        float f = DECELERATION_RATE;
        return java.lang.Math.exp(splineDeceleration * (((double) f) / (((double) f) - 1.0d))) * ((double) (mFlingFriction * mPhysicalCoeff));
    }

    public int getVelocityByDistance(double d) {
        return java.lang.Math.abs((int) (((java.lang.Math.exp(getSplineDecelerationByDistance(d)) * ((double) mFlingFriction)) * ((double) mPhysicalCoeff)) / 0.3499999940395355d));
    }
}
