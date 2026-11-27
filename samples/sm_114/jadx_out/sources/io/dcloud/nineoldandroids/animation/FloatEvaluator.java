package io.dcloud.nineoldandroids.animation;

/* JADX INFO: loaded from: classes2.dex */
public class FloatEvaluator implements io.dcloud.nineoldandroids.animation.TypeEvaluator<java.lang.Number> {
    @Override // io.dcloud.nineoldandroids.animation.TypeEvaluator
    public java.lang.Float evaluate(float f, java.lang.Number number, java.lang.Number number2) {
        float fFloatValue = number.floatValue();
        return java.lang.Float.valueOf(fFloatValue + (f * (number2.floatValue() - fFloatValue)));
    }
}
