package io.dcloud.nineoldandroids.animation;

/* JADX INFO: loaded from: classes2.dex */
public class AnimatorInflater {
    private static final int AnimatorSet_ordering = 0;
    private static final int Animator_duration = 1;
    private static final int Animator_interpolator = 0;
    private static final int Animator_repeatCount = 3;
    private static final int Animator_repeatMode = 4;
    private static final int Animator_startOffset = 2;
    private static final int Animator_valueFrom = 5;
    private static final int Animator_valueTo = 6;
    private static final int Animator_valueType = 7;
    private static final int PropertyAnimator_propertyName = 0;
    private static final int TOGETHER = 0;
    private static final int VALUE_TYPE_FLOAT = 0;
    private static final int[] AnimatorSet = {android.R.attr.ordering};
    private static final int[] PropertyAnimator = {android.R.attr.propertyName};
    private static final int[] Animator = {android.R.attr.interpolator, android.R.attr.duration, android.R.attr.startOffset, android.R.attr.repeatCount, android.R.attr.repeatMode, android.R.attr.valueFrom, android.R.attr.valueTo, android.R.attr.valueType};

    public static io.dcloud.nineoldandroids.animation.Animator loadAnimator(android.content.Context context, int i) throws android.content.res.Resources.NotFoundException {
        android.content.res.XmlResourceParser animation = null;
        try {
            try {
                animation = context.getResources().getAnimation(i);
                io.dcloud.nineoldandroids.animation.Animator animatorCreateAnimatorFromXml = createAnimatorFromXml(context, animation);
                if (animation != null) {
                    animation.close();
                }
                return animatorCreateAnimatorFromXml;
            } catch (java.io.IOException e) {
                android.content.res.Resources.NotFoundException notFoundException = new android.content.res.Resources.NotFoundException("Can't load animation resource ID #0x" + java.lang.Integer.toHexString(i));
                notFoundException.initCause(e);
                throw notFoundException;
            } catch (org.xmlpull.v1.XmlPullParserException e2) {
                android.content.res.Resources.NotFoundException notFoundException2 = new android.content.res.Resources.NotFoundException("Can't load animation resource ID #0x" + java.lang.Integer.toHexString(i));
                notFoundException2.initCause(e2);
                throw notFoundException2;
            }
        } catch (java.lang.Throwable th) {
            if (animation != null) {
                animation.close();
            }
            throw th;
        }
    }

    private static io.dcloud.nineoldandroids.animation.Animator createAnimatorFromXml(android.content.Context context, org.xmlpull.v1.XmlPullParser xmlPullParser) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        return createAnimatorFromXml(context, xmlPullParser, android.util.Xml.asAttributeSet(xmlPullParser), null, 0);
    }

    private static io.dcloud.nineoldandroids.animation.Animator createAnimatorFromXml(android.content.Context context, org.xmlpull.v1.XmlPullParser xmlPullParser, android.util.AttributeSet attributeSet, io.dcloud.nineoldandroids.animation.AnimatorSet animatorSet, int i) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        int i2;
        io.dcloud.nineoldandroids.animation.ValueAnimator valueAnimatorLoadAnimator;
        io.dcloud.nineoldandroids.animation.ObjectAnimator objectAnimatorLoadObjectAnimator;
        int depth = xmlPullParser.getDepth();
        java.util.ArrayList arrayList = null;
        io.dcloud.nineoldandroids.animation.Animator animator = null;
        while (true) {
            int next = xmlPullParser.next();
            i2 = 0;
            if ((next == 3 && xmlPullParser.getDepth() <= depth) || next == 1) {
                break;
            }
            if (next == 2) {
                java.lang.String name = xmlPullParser.getName();
                if (name.equals("objectAnimator")) {
                    objectAnimatorLoadObjectAnimator = loadObjectAnimator(context, attributeSet);
                } else if (name.equals("animator")) {
                    valueAnimatorLoadAnimator = loadAnimator(context, attributeSet, null);
                } else if (name.equals("set")) {
                    io.dcloud.nineoldandroids.animation.AnimatorSet animatorSet2 = new io.dcloud.nineoldandroids.animation.AnimatorSet();
                    android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AnimatorSet);
                    android.util.TypedValue typedValue = new android.util.TypedValue();
                    typedArrayObtainStyledAttributes.getValue(0, typedValue);
                    createAnimatorFromXml(context, xmlPullParser, attributeSet, animatorSet2, typedValue.type == 16 ? typedValue.data : 0);
                    typedArrayObtainStyledAttributes.recycle();
                    animator = animatorSet2;
                } else {
                    throw new java.lang.RuntimeException("Unknown animator name: " + xmlPullParser.getName());
                }
                if (animatorSet != null) {
                    animator = valueAnimatorLoadAnimator;
                    if (arrayList == null) {
                        animator = objectAnimatorLoadObjectAnimator;
                        arrayList = new java.util.ArrayList();
                    }
                    animator = objectAnimatorLoadObjectAnimator;
                    arrayList.add(animator);
                } else {
                    animator = valueAnimatorLoadAnimator;
                    animator = objectAnimatorLoadObjectAnimator;
                }
            }
        }
        if (animatorSet == null || arrayList == null) {
            return animator;
        }
        io.dcloud.nineoldandroids.animation.Animator[] animatorArr = new io.dcloud.nineoldandroids.animation.Animator[arrayList.size()];
        java.util.Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            animatorArr[i2] = (io.dcloud.nineoldandroids.animation.Animator) it.next();
            i2++;
        }
        if (i == 0) {
            animatorSet.playTogether(animatorArr);
            return animator;
        }
        animatorSet.playSequentially(animatorArr);
        return animator;
    }

    private static io.dcloud.nineoldandroids.animation.ObjectAnimator loadObjectAnimator(android.content.Context context, android.util.AttributeSet attributeSet) throws android.content.res.Resources.NotFoundException {
        io.dcloud.nineoldandroids.animation.ObjectAnimator objectAnimator = new io.dcloud.nineoldandroids.animation.ObjectAnimator();
        loadAnimator(context, attributeSet, objectAnimator);
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, PropertyAnimator);
        objectAnimator.setPropertyName(typedArrayObtainStyledAttributes.getString(0));
        typedArrayObtainStyledAttributes.recycle();
        return objectAnimator;
    }

    /* JADX WARN: Code duplicated, block: B:78:0x0129  */
    /* JADX WARN: Code duplicated, block: B:81:0x0137  */
    /* JADX WARN: Code duplicated, block: B:84:0x0145  */
    private static io.dcloud.nineoldandroids.animation.ValueAnimator loadAnimator(android.content.Context context, android.util.AttributeSet attributeSet, io.dcloud.nineoldandroids.animation.ValueAnimator valueAnimator) throws android.content.res.Resources.NotFoundException {
        int i;
        int color;
        int i2;
        int color2;
        int color3;
        int resourceId;
        float dimension;
        float dimension2;
        float dimension3;
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Animator);
        long j = typedArrayObtainStyledAttributes.getInt(1, 0);
        long j2 = typedArrayObtainStyledAttributes.getInt(2, 0);
        int i3 = typedArrayObtainStyledAttributes.getInt(7, 0);
        io.dcloud.nineoldandroids.animation.ValueAnimator valueAnimator2 = valueAnimator == null ? new io.dcloud.nineoldandroids.animation.ValueAnimator() : valueAnimator;
        boolean z = i3 == 0;
        android.util.TypedValue typedValuePeekValue = typedArrayObtainStyledAttributes.peekValue(5);
        boolean z2 = typedValuePeekValue != null;
        int i4 = z2 ? typedValuePeekValue.type : 0;
        android.util.TypedValue typedValuePeekValue2 = typedArrayObtainStyledAttributes.peekValue(6);
        boolean z3 = typedValuePeekValue2 != null;
        int i5 = z3 ? typedValuePeekValue2.type : 0;
        if ((z2 && i4 >= 28 && i4 <= 31) || (z3 && i5 >= 28 && i5 <= 31)) {
            valueAnimator2.setEvaluator(new io.dcloud.nineoldandroids.animation.ArgbEvaluator());
            z = false;
        }
        if (z) {
            if (z2) {
                if (i4 == 5) {
                    dimension2 = typedArrayObtainStyledAttributes.getDimension(5, 0.0f);
                } else {
                    dimension2 = typedArrayObtainStyledAttributes.getFloat(5, 0.0f);
                }
                if (z3) {
                    if (i5 == 5) {
                        dimension3 = typedArrayObtainStyledAttributes.getDimension(6, 0.0f);
                    } else {
                        dimension3 = typedArrayObtainStyledAttributes.getFloat(6, 0.0f);
                    }
                    valueAnimator2.setFloatValues(dimension2, dimension3);
                } else {
                    valueAnimator2.setFloatValues(dimension2);
                }
            } else {
                if (i5 == 5) {
                    dimension = typedArrayObtainStyledAttributes.getDimension(6, 0.0f);
                } else {
                    dimension = typedArrayObtainStyledAttributes.getFloat(6, 0.0f);
                }
                valueAnimator2.setFloatValues(dimension);
            }
        } else {
            if (!z2) {
                if (z3) {
                    if (i5 == 5) {
                        color = (int) typedArrayObtainStyledAttributes.getDimension(6, 0.0f);
                        i = 0;
                    } else if (i5 >= 28 && i5 <= 31) {
                        i = 0;
                        color = typedArrayObtainStyledAttributes.getColor(6, 0);
                    } else {
                        i = 0;
                        color = typedArrayObtainStyledAttributes.getInt(6, 0);
                    }
                    valueAnimator2.setIntValues(color);
                }
                valueAnimator2.setDuration(j);
                valueAnimator2.setStartDelay(j2);
                if (typedArrayObtainStyledAttributes.hasValue(3)) {
                    valueAnimator2.setRepeatCount(typedArrayObtainStyledAttributes.getInt(3, i));
                }
                if (typedArrayObtainStyledAttributes.hasValue(4)) {
                    valueAnimator2.setRepeatMode(typedArrayObtainStyledAttributes.getInt(4, 1));
                }
                resourceId = typedArrayObtainStyledAttributes.getResourceId(i, i);
                if (resourceId > 0) {
                    valueAnimator2.setInterpolator(android.view.animation.AnimationUtils.loadInterpolator(context, resourceId));
                }
                typedArrayObtainStyledAttributes.recycle();
                return valueAnimator2;
            }
            if (i4 == 5) {
                color2 = (int) typedArrayObtainStyledAttributes.getDimension(5, 0.0f);
                i2 = 0;
            } else if (i4 >= 28 && i4 <= 31) {
                i2 = 0;
                color2 = typedArrayObtainStyledAttributes.getColor(5, 0);
            } else {
                i2 = 0;
                color2 = typedArrayObtainStyledAttributes.getInt(5, 0);
            }
            if (z3) {
                if (i5 == 5) {
                    color3 = (int) typedArrayObtainStyledAttributes.getDimension(6, 0.0f);
                } else if (i5 >= 28 && i5 <= 31) {
                    color3 = typedArrayObtainStyledAttributes.getColor(6, i2);
                } else {
                    color3 = typedArrayObtainStyledAttributes.getInt(6, i2);
                }
                valueAnimator2.setIntValues(color2, color3);
            } else {
                valueAnimator2.setIntValues(color2);
            }
        }
        i = 0;
        valueAnimator2.setDuration(j);
        valueAnimator2.setStartDelay(j2);
        if (typedArrayObtainStyledAttributes.hasValue(3)) {
            valueAnimator2.setRepeatCount(typedArrayObtainStyledAttributes.getInt(3, i));
        }
        if (typedArrayObtainStyledAttributes.hasValue(4)) {
            valueAnimator2.setRepeatMode(typedArrayObtainStyledAttributes.getInt(4, 1));
        }
        resourceId = typedArrayObtainStyledAttributes.getResourceId(i, i);
        if (resourceId > 0) {
            valueAnimator2.setInterpolator(android.view.animation.AnimationUtils.loadInterpolator(context, resourceId));
        }
        typedArrayObtainStyledAttributes.recycle();
        return valueAnimator2;
    }
}
