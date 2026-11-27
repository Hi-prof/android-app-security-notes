package io.dcloud.nineoldandroids.animation;

/* JADX INFO: loaded from: classes2.dex */
class KeyframeSet {
    io.dcloud.nineoldandroids.animation.TypeEvaluator mEvaluator;
    io.dcloud.nineoldandroids.animation.Keyframe mFirstKeyframe;
    android.view.animation.Interpolator mInterpolator;
    java.util.ArrayList<io.dcloud.nineoldandroids.animation.Keyframe> mKeyframes;
    io.dcloud.nineoldandroids.animation.Keyframe mLastKeyframe;
    int mNumKeyframes;

    public KeyframeSet(io.dcloud.nineoldandroids.animation.Keyframe... keyframeArr) {
        this.mNumKeyframes = keyframeArr.length;
        java.util.ArrayList<io.dcloud.nineoldandroids.animation.Keyframe> arrayList = new java.util.ArrayList<>();
        this.mKeyframes = arrayList;
        arrayList.addAll(java.util.Arrays.asList(keyframeArr));
        this.mFirstKeyframe = this.mKeyframes.get(0);
        io.dcloud.nineoldandroids.animation.Keyframe keyframe = this.mKeyframes.get(this.mNumKeyframes - 1);
        this.mLastKeyframe = keyframe;
        this.mInterpolator = keyframe.getInterpolator();
    }

    public static io.dcloud.nineoldandroids.animation.KeyframeSet ofInt(int... iArr) {
        int length = iArr.length;
        io.dcloud.nineoldandroids.animation.Keyframe.IntKeyframe[] intKeyframeArr = new io.dcloud.nineoldandroids.animation.Keyframe.IntKeyframe[java.lang.Math.max(length, 2)];
        if (length == 1) {
            intKeyframeArr[0] = (io.dcloud.nineoldandroids.animation.Keyframe.IntKeyframe) io.dcloud.nineoldandroids.animation.Keyframe.ofInt(0.0f);
            intKeyframeArr[1] = (io.dcloud.nineoldandroids.animation.Keyframe.IntKeyframe) io.dcloud.nineoldandroids.animation.Keyframe.ofInt(1.0f, iArr[0]);
        } else {
            intKeyframeArr[0] = (io.dcloud.nineoldandroids.animation.Keyframe.IntKeyframe) io.dcloud.nineoldandroids.animation.Keyframe.ofInt(0.0f, iArr[0]);
            for (int i = 1; i < length; i++) {
                intKeyframeArr[i] = (io.dcloud.nineoldandroids.animation.Keyframe.IntKeyframe) io.dcloud.nineoldandroids.animation.Keyframe.ofInt(i / (length - 1), iArr[i]);
            }
        }
        return new io.dcloud.nineoldandroids.animation.IntKeyframeSet(intKeyframeArr);
    }

    public static io.dcloud.nineoldandroids.animation.KeyframeSet ofFloat(float... fArr) {
        int length = fArr.length;
        io.dcloud.nineoldandroids.animation.Keyframe.FloatKeyframe[] floatKeyframeArr = new io.dcloud.nineoldandroids.animation.Keyframe.FloatKeyframe[java.lang.Math.max(length, 2)];
        if (length == 1) {
            floatKeyframeArr[0] = (io.dcloud.nineoldandroids.animation.Keyframe.FloatKeyframe) io.dcloud.nineoldandroids.animation.Keyframe.ofFloat(0.0f);
            floatKeyframeArr[1] = (io.dcloud.nineoldandroids.animation.Keyframe.FloatKeyframe) io.dcloud.nineoldandroids.animation.Keyframe.ofFloat(1.0f, fArr[0]);
        } else {
            floatKeyframeArr[0] = (io.dcloud.nineoldandroids.animation.Keyframe.FloatKeyframe) io.dcloud.nineoldandroids.animation.Keyframe.ofFloat(0.0f, fArr[0]);
            for (int i = 1; i < length; i++) {
                floatKeyframeArr[i] = (io.dcloud.nineoldandroids.animation.Keyframe.FloatKeyframe) io.dcloud.nineoldandroids.animation.Keyframe.ofFloat(i / (length - 1), fArr[i]);
            }
        }
        return new io.dcloud.nineoldandroids.animation.FloatKeyframeSet(floatKeyframeArr);
    }

    public static io.dcloud.nineoldandroids.animation.KeyframeSet ofKeyframe(io.dcloud.nineoldandroids.animation.Keyframe... keyframeArr) {
        int length = keyframeArr.length;
        int i = 0;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        for (io.dcloud.nineoldandroids.animation.Keyframe keyframe : keyframeArr) {
            if (keyframe instanceof io.dcloud.nineoldandroids.animation.Keyframe.FloatKeyframe) {
                z = true;
            } else if (keyframe instanceof io.dcloud.nineoldandroids.animation.Keyframe.IntKeyframe) {
                z2 = true;
            } else {
                z3 = true;
            }
        }
        if (z && !z2 && !z3) {
            io.dcloud.nineoldandroids.animation.Keyframe.FloatKeyframe[] floatKeyframeArr = new io.dcloud.nineoldandroids.animation.Keyframe.FloatKeyframe[length];
            while (i < length) {
                floatKeyframeArr[i] = (io.dcloud.nineoldandroids.animation.Keyframe.FloatKeyframe) keyframeArr[i];
                i++;
            }
            return new io.dcloud.nineoldandroids.animation.FloatKeyframeSet(floatKeyframeArr);
        }
        if (z2 && !z && !z3) {
            io.dcloud.nineoldandroids.animation.Keyframe.IntKeyframe[] intKeyframeArr = new io.dcloud.nineoldandroids.animation.Keyframe.IntKeyframe[length];
            while (i < length) {
                intKeyframeArr[i] = (io.dcloud.nineoldandroids.animation.Keyframe.IntKeyframe) keyframeArr[i];
                i++;
            }
            return new io.dcloud.nineoldandroids.animation.IntKeyframeSet(intKeyframeArr);
        }
        return new io.dcloud.nineoldandroids.animation.KeyframeSet(keyframeArr);
    }

    public static io.dcloud.nineoldandroids.animation.KeyframeSet ofObject(java.lang.Object... objArr) {
        int length = objArr.length;
        io.dcloud.nineoldandroids.animation.Keyframe.ObjectKeyframe[] objectKeyframeArr = new io.dcloud.nineoldandroids.animation.Keyframe.ObjectKeyframe[java.lang.Math.max(length, 2)];
        if (length == 1) {
            objectKeyframeArr[0] = (io.dcloud.nineoldandroids.animation.Keyframe.ObjectKeyframe) io.dcloud.nineoldandroids.animation.Keyframe.ofObject(0.0f);
            objectKeyframeArr[1] = (io.dcloud.nineoldandroids.animation.Keyframe.ObjectKeyframe) io.dcloud.nineoldandroids.animation.Keyframe.ofObject(1.0f, objArr[0]);
        } else {
            objectKeyframeArr[0] = (io.dcloud.nineoldandroids.animation.Keyframe.ObjectKeyframe) io.dcloud.nineoldandroids.animation.Keyframe.ofObject(0.0f, objArr[0]);
            for (int i = 1; i < length; i++) {
                objectKeyframeArr[i] = (io.dcloud.nineoldandroids.animation.Keyframe.ObjectKeyframe) io.dcloud.nineoldandroids.animation.Keyframe.ofObject(i / (length - 1), objArr[i]);
            }
        }
        return new io.dcloud.nineoldandroids.animation.KeyframeSet(objectKeyframeArr);
    }

    public void setEvaluator(io.dcloud.nineoldandroids.animation.TypeEvaluator typeEvaluator) {
        this.mEvaluator = typeEvaluator;
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public io.dcloud.nineoldandroids.animation.KeyframeSet m438clone() {
        java.util.ArrayList<io.dcloud.nineoldandroids.animation.Keyframe> arrayList = this.mKeyframes;
        int size = arrayList.size();
        io.dcloud.nineoldandroids.animation.Keyframe[] keyframeArr = new io.dcloud.nineoldandroids.animation.Keyframe[size];
        for (int i = 0; i < size; i++) {
            keyframeArr[i] = arrayList.get(i).m437clone();
        }
        return new io.dcloud.nineoldandroids.animation.KeyframeSet(keyframeArr);
    }

    public java.lang.Object getValue(float f) {
        int i = this.mNumKeyframes;
        if (i == 2) {
            android.view.animation.Interpolator interpolator = this.mInterpolator;
            if (interpolator != null) {
                f = interpolator.getInterpolation(f);
            }
            return this.mEvaluator.evaluate(f, this.mFirstKeyframe.getValue(), this.mLastKeyframe.getValue());
        }
        int i2 = 1;
        if (f <= 0.0f) {
            io.dcloud.nineoldandroids.animation.Keyframe keyframe = this.mKeyframes.get(1);
            android.view.animation.Interpolator interpolator2 = keyframe.getInterpolator();
            if (interpolator2 != null) {
                f = interpolator2.getInterpolation(f);
            }
            float fraction = this.mFirstKeyframe.getFraction();
            return this.mEvaluator.evaluate((f - fraction) / (keyframe.getFraction() - fraction), this.mFirstKeyframe.getValue(), keyframe.getValue());
        }
        if (f >= 1.0f) {
            io.dcloud.nineoldandroids.animation.Keyframe keyframe2 = this.mKeyframes.get(i - 2);
            android.view.animation.Interpolator interpolator3 = this.mLastKeyframe.getInterpolator();
            if (interpolator3 != null) {
                f = interpolator3.getInterpolation(f);
            }
            float fraction2 = keyframe2.getFraction();
            return this.mEvaluator.evaluate((f - fraction2) / (this.mLastKeyframe.getFraction() - fraction2), keyframe2.getValue(), this.mLastKeyframe.getValue());
        }
        io.dcloud.nineoldandroids.animation.Keyframe keyframe3 = this.mFirstKeyframe;
        while (i2 < this.mNumKeyframes) {
            io.dcloud.nineoldandroids.animation.Keyframe keyframe4 = this.mKeyframes.get(i2);
            if (f < keyframe4.getFraction()) {
                android.view.animation.Interpolator interpolator4 = keyframe4.getInterpolator();
                if (interpolator4 != null) {
                    f = interpolator4.getInterpolation(f);
                }
                float fraction3 = keyframe3.getFraction();
                return this.mEvaluator.evaluate((f - fraction3) / (keyframe4.getFraction() - fraction3), keyframe3.getValue(), keyframe4.getValue());
            }
            i2++;
            keyframe3 = keyframe4;
        }
        return this.mLastKeyframe.getValue();
    }

    public java.lang.String toString() {
        java.lang.String str = com.taobao.weex.el.parse.Operators.SPACE_STR;
        for (int i = 0; i < this.mNumKeyframes; i++) {
            str = java.lang.String.valueOf(str) + this.mKeyframes.get(i).getValue() + "  ";
        }
        return str;
    }
}
