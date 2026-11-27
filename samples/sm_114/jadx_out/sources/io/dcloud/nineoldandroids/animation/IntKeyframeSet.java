package io.dcloud.nineoldandroids.animation;

/* JADX INFO: loaded from: classes2.dex */
class IntKeyframeSet extends io.dcloud.nineoldandroids.animation.KeyframeSet {
    private int deltaValue;
    private boolean firstTime;
    private int firstValue;
    private int lastValue;

    public IntKeyframeSet(io.dcloud.nineoldandroids.animation.Keyframe.IntKeyframe... intKeyframeArr) {
        super(intKeyframeArr);
        this.firstTime = true;
    }

    @Override // io.dcloud.nineoldandroids.animation.KeyframeSet
    public java.lang.Object getValue(float f) {
        return java.lang.Integer.valueOf(getIntValue(f));
    }

    @Override // io.dcloud.nineoldandroids.animation.KeyframeSet
    /* JADX INFO: renamed from: clone */
    public io.dcloud.nineoldandroids.animation.IntKeyframeSet m438clone() {
        java.util.ArrayList<io.dcloud.nineoldandroids.animation.Keyframe> arrayList = this.mKeyframes;
        int size = this.mKeyframes.size();
        io.dcloud.nineoldandroids.animation.Keyframe.IntKeyframe[] intKeyframeArr = new io.dcloud.nineoldandroids.animation.Keyframe.IntKeyframe[size];
        for (int i = 0; i < size; i++) {
            intKeyframeArr[i] = (io.dcloud.nineoldandroids.animation.Keyframe.IntKeyframe) arrayList.get(i).m437clone();
        }
        return new io.dcloud.nineoldandroids.animation.IntKeyframeSet(intKeyframeArr);
    }

    public int getIntValue(float f) {
        int intValue;
        int i;
        int intValue2;
        int intValue3;
        float f2;
        if (this.mNumKeyframes != 2) {
            if (f <= 0.0f) {
                io.dcloud.nineoldandroids.animation.Keyframe.IntKeyframe intKeyframe = (io.dcloud.nineoldandroids.animation.Keyframe.IntKeyframe) this.mKeyframes.get(0);
                io.dcloud.nineoldandroids.animation.Keyframe.IntKeyframe intKeyframe2 = (io.dcloud.nineoldandroids.animation.Keyframe.IntKeyframe) this.mKeyframes.get(1);
                intValue2 = intKeyframe.getIntValue();
                intValue3 = intKeyframe2.getIntValue();
                float fraction = intKeyframe.getFraction();
                float fraction2 = intKeyframe2.getFraction();
                android.view.animation.Interpolator interpolator = intKeyframe2.getInterpolator();
                if (interpolator != null) {
                    f = interpolator.getInterpolation(f);
                }
                f2 = (f - fraction) / (fraction2 - fraction);
                if (this.mEvaluator != null) {
                    return ((java.lang.Number) this.mEvaluator.evaluate(f2, java.lang.Integer.valueOf(intValue2), java.lang.Integer.valueOf(intValue3))).intValue();
                }
            } else if (f >= 1.0f) {
                io.dcloud.nineoldandroids.animation.Keyframe.IntKeyframe intKeyframe3 = (io.dcloud.nineoldandroids.animation.Keyframe.IntKeyframe) this.mKeyframes.get(this.mNumKeyframes - 2);
                io.dcloud.nineoldandroids.animation.Keyframe.IntKeyframe intKeyframe4 = (io.dcloud.nineoldandroids.animation.Keyframe.IntKeyframe) this.mKeyframes.get(this.mNumKeyframes - 1);
                intValue2 = intKeyframe3.getIntValue();
                intValue3 = intKeyframe4.getIntValue();
                float fraction3 = intKeyframe3.getFraction();
                float fraction4 = intKeyframe4.getFraction();
                android.view.animation.Interpolator interpolator2 = intKeyframe4.getInterpolator();
                if (interpolator2 != null) {
                    f = interpolator2.getInterpolation(f);
                }
                f2 = (f - fraction3) / (fraction4 - fraction3);
                if (this.mEvaluator != null) {
                    return ((java.lang.Number) this.mEvaluator.evaluate(f2, java.lang.Integer.valueOf(intValue2), java.lang.Integer.valueOf(intValue3))).intValue();
                }
            } else {
                io.dcloud.nineoldandroids.animation.Keyframe.IntKeyframe intKeyframe5 = (io.dcloud.nineoldandroids.animation.Keyframe.IntKeyframe) this.mKeyframes.get(0);
                int i2 = 1;
                while (i2 < this.mNumKeyframes) {
                    io.dcloud.nineoldandroids.animation.Keyframe.IntKeyframe intKeyframe6 = (io.dcloud.nineoldandroids.animation.Keyframe.IntKeyframe) this.mKeyframes.get(i2);
                    if (f < intKeyframe6.getFraction()) {
                        android.view.animation.Interpolator interpolator3 = intKeyframe6.getInterpolator();
                        if (interpolator3 != null) {
                            f = interpolator3.getInterpolation(f);
                        }
                        f = (f - intKeyframe5.getFraction()) / (intKeyframe6.getFraction() - intKeyframe5.getFraction());
                        intValue = intKeyframe5.getIntValue();
                        int intValue4 = intKeyframe6.getIntValue();
                        if (this.mEvaluator != null) {
                            return ((java.lang.Number) this.mEvaluator.evaluate(f, java.lang.Integer.valueOf(intValue), java.lang.Integer.valueOf(intValue4))).intValue();
                        }
                        i = intValue4 - intValue;
                    } else {
                        i2++;
                        intKeyframe5 = intKeyframe6;
                    }
                }
                return ((java.lang.Number) this.mKeyframes.get(this.mNumKeyframes - 1).getValue()).intValue();
            }
            return intValue2 + ((int) (f2 * (intValue3 - intValue2)));
        }
        if (this.firstTime) {
            this.firstTime = false;
            this.firstValue = ((io.dcloud.nineoldandroids.animation.Keyframe.IntKeyframe) this.mKeyframes.get(0)).getIntValue();
            int intValue5 = ((io.dcloud.nineoldandroids.animation.Keyframe.IntKeyframe) this.mKeyframes.get(1)).getIntValue();
            this.lastValue = intValue5;
            this.deltaValue = intValue5 - this.firstValue;
        }
        if (this.mInterpolator != null) {
            f = this.mInterpolator.getInterpolation(f);
        }
        if (this.mEvaluator == null) {
            intValue = this.firstValue;
            i = this.deltaValue;
        } else {
            return ((java.lang.Number) this.mEvaluator.evaluate(f, java.lang.Integer.valueOf(this.firstValue), java.lang.Integer.valueOf(this.lastValue))).intValue();
        }
        return intValue + ((int) (f * i));
    }
}
