package io.dcloud.nineoldandroids.animation;

/* JADX INFO: loaded from: classes2.dex */
public class IntEvaluator implements io.dcloud.nineoldandroids.animation.TypeEvaluator<java.lang.Integer> {
    @Override // io.dcloud.nineoldandroids.animation.TypeEvaluator
    public java.lang.Integer evaluate(float f, java.lang.Integer num, java.lang.Integer num2) {
        int iIntValue = num.intValue();
        return java.lang.Integer.valueOf((int) (iIntValue + (f * (num2.intValue() - iIntValue))));
    }
}
