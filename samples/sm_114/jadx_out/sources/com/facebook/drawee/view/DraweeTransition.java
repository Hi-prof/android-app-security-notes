package com.facebook.drawee.view;

/* JADX INFO: loaded from: classes.dex */
public class DraweeTransition extends android.transition.Transition {
    private static final java.lang.String PROPNAME_BOUNDS = "draweeTransition:bounds";

    @javax.annotation.Nullable
    private final android.graphics.PointF mFromFocusPoint;
    private final com.facebook.drawee.drawable.ScalingUtils.ScaleType mFromScale;

    @javax.annotation.Nullable
    private final android.graphics.PointF mToFocusPoint;
    private final com.facebook.drawee.drawable.ScalingUtils.ScaleType mToScale;

    public static android.transition.TransitionSet createTransitionSet(com.facebook.drawee.drawable.ScalingUtils.ScaleType scaleType, com.facebook.drawee.drawable.ScalingUtils.ScaleType scaleType2) {
        return createTransitionSet(scaleType, scaleType2, null, null);
    }

    public static android.transition.TransitionSet createTransitionSet(com.facebook.drawee.drawable.ScalingUtils.ScaleType scaleType, com.facebook.drawee.drawable.ScalingUtils.ScaleType scaleType2, @javax.annotation.Nullable android.graphics.PointF pointF, @javax.annotation.Nullable android.graphics.PointF pointF2) {
        android.transition.TransitionSet transitionSet = new android.transition.TransitionSet();
        transitionSet.addTransition(new android.transition.ChangeBounds());
        transitionSet.addTransition(new com.facebook.drawee.view.DraweeTransition(scaleType, scaleType2, pointF, pointF2));
        return transitionSet;
    }

    public DraweeTransition(com.facebook.drawee.drawable.ScalingUtils.ScaleType scaleType, com.facebook.drawee.drawable.ScalingUtils.ScaleType scaleType2, @javax.annotation.Nullable android.graphics.PointF pointF, @javax.annotation.Nullable android.graphics.PointF pointF2) {
        this.mFromScale = scaleType;
        this.mToScale = scaleType2;
        this.mFromFocusPoint = pointF;
        this.mToFocusPoint = pointF2;
    }

    public DraweeTransition(com.facebook.drawee.drawable.ScalingUtils.ScaleType scaleType, com.facebook.drawee.drawable.ScalingUtils.ScaleType scaleType2) {
        this(scaleType, scaleType2, null, null);
    }

    @Override // android.transition.Transition
    public void captureStartValues(android.transition.TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    @Override // android.transition.Transition
    public void captureEndValues(android.transition.TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    @Override // android.transition.Transition
    @javax.annotation.Nullable
    public android.animation.Animator createAnimator(android.view.ViewGroup viewGroup, android.transition.TransitionValues transitionValues, android.transition.TransitionValues transitionValues2) {
        if (transitionValues != null && transitionValues2 != null) {
            android.graphics.Rect rect = (android.graphics.Rect) transitionValues.values.get(PROPNAME_BOUNDS);
            android.graphics.Rect rect2 = (android.graphics.Rect) transitionValues2.values.get(PROPNAME_BOUNDS);
            if (rect != null && rect2 != null) {
                if (this.mFromScale == this.mToScale && this.mFromFocusPoint == this.mToFocusPoint) {
                    return null;
                }
                final com.facebook.drawee.view.GenericDraweeView genericDraweeView = (com.facebook.drawee.view.GenericDraweeView) transitionValues.view;
                final com.facebook.drawee.drawable.ScalingUtils.InterpolatingScaleType interpolatingScaleType = new com.facebook.drawee.drawable.ScalingUtils.InterpolatingScaleType(this.mFromScale, this.mToScale, rect, rect2, this.mFromFocusPoint, this.mToFocusPoint);
                genericDraweeView.getHierarchy().setActualImageScaleType(interpolatingScaleType);
                android.animation.ValueAnimator valueAnimatorOfFloat = android.animation.ValueAnimator.ofFloat(0.0f, 1.0f);
                valueAnimatorOfFloat.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.facebook.drawee.view.DraweeTransition.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                        interpolatingScaleType.setValue(((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                });
                valueAnimatorOfFloat.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.facebook.drawee.view.DraweeTransition.2
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(android.animation.Animator animator) {
                        genericDraweeView.getHierarchy().setActualImageScaleType(com.facebook.drawee.view.DraweeTransition.this.mToScale);
                        if (com.facebook.drawee.view.DraweeTransition.this.mToFocusPoint != null) {
                            genericDraweeView.getHierarchy().setActualImageFocusPoint(com.facebook.drawee.view.DraweeTransition.this.mToFocusPoint);
                        }
                    }
                });
                return valueAnimatorOfFloat;
            }
        }
        return null;
    }

    private void captureValues(android.transition.TransitionValues transitionValues) {
        if (transitionValues.view instanceof com.facebook.drawee.view.GenericDraweeView) {
            transitionValues.values.put(PROPNAME_BOUNDS, new android.graphics.Rect(0, 0, transitionValues.view.getWidth(), transitionValues.view.getHeight()));
        }
    }
}
