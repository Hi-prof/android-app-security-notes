package com.taobao.weex.dom.transition;

/* JADX INFO: loaded from: classes.dex */
public class WXTransition {
    private static final java.util.Set<java.lang.String> LAYOUT_PROPERTIES;
    public static final java.util.regex.Pattern PROPERTY_SPLIT_PATTERN = java.util.regex.Pattern.compile("\\||,");
    private static final java.util.Set<java.lang.String> TRANSFORM_PROPERTIES;
    public static final java.lang.String TRANSITION_DELAY = "transitionDelay";
    public static final java.lang.String TRANSITION_DURATION = "transitionDuration";
    public static final java.lang.String TRANSITION_PROPERTY = "transitionProperty";
    public static final java.lang.String TRANSITION_TIMING_FUNCTION = "transitionTimingFunction";
    private java.lang.Runnable animationRunnable;
    private long delay;
    private long duration;
    private android.view.animation.Interpolator interpolator;
    private android.animation.ValueAnimator layoutValueAnimator;
    private com.taobao.weex.ui.component.WXComponent mWXComponent;
    private java.lang.Runnable transformAnimationRunnable;
    private android.animation.ObjectAnimator transformAnimator;
    private java.lang.Runnable transitionEndEvent;
    private volatile java.util.concurrent.atomic.AtomicInteger lockToken = new java.util.concurrent.atomic.AtomicInteger(0);
    private java.util.List<java.lang.String> properties = new java.util.ArrayList(4);
    private android.os.Handler handler = new android.os.Handler();
    private java.util.Map<java.lang.String, java.lang.Object> layoutPendingUpdates = new androidx.collection.ArrayMap();
    private java.util.Map<java.lang.String, java.lang.Object> transformPendingUpdates = new androidx.collection.ArrayMap();
    private java.util.Map<java.lang.String, java.lang.Object> targetStyles = new androidx.collection.ArrayMap();

    static {
        java.util.HashSet hashSet = new java.util.HashSet();
        LAYOUT_PROPERTIES = hashSet;
        hashSet.add("width");
        hashSet.add("height");
        hashSet.add(com.taobao.weex.common.Constants.Name.MARGIN_TOP);
        hashSet.add(com.taobao.weex.common.Constants.Name.MARGIN_BOTTOM);
        hashSet.add(com.taobao.weex.common.Constants.Name.MARGIN_LEFT);
        hashSet.add(com.taobao.weex.common.Constants.Name.MARGIN_RIGHT);
        hashSet.add("left");
        hashSet.add("right");
        hashSet.add("top");
        hashSet.add("bottom");
        hashSet.add(com.taobao.weex.common.Constants.Name.PADDING_LEFT);
        hashSet.add(com.taobao.weex.common.Constants.Name.PADDING_RIGHT);
        hashSet.add(com.taobao.weex.common.Constants.Name.PADDING_TOP);
        hashSet.add(com.taobao.weex.common.Constants.Name.PADDING_BOTTOM);
        java.util.HashSet hashSet2 = new java.util.HashSet();
        TRANSFORM_PROPERTIES = hashSet2;
        hashSet2.add("opacity");
        hashSet2.add("backgroundColor");
        hashSet2.add("transform");
    }

    public static com.taobao.weex.dom.transition.WXTransition fromMap(java.util.Map<java.lang.String, java.lang.Object> map, com.taobao.weex.ui.component.WXComponent wXComponent) {
        java.lang.String string;
        if (map.get(TRANSITION_PROPERTY) == null || (string = com.taobao.weex.utils.WXUtils.getString(map.get(TRANSITION_PROPERTY), null)) == null) {
            return null;
        }
        com.taobao.weex.dom.transition.WXTransition wXTransition = new com.taobao.weex.dom.transition.WXTransition();
        updateTransitionProperties(wXTransition, string);
        if (wXTransition.properties.isEmpty()) {
            return null;
        }
        wXTransition.duration = parseTimeMillis(map, TRANSITION_DURATION, 0L);
        wXTransition.delay = parseTimeMillis(map, TRANSITION_DELAY, 0L);
        wXTransition.interpolator = createTimeInterpolator(com.taobao.weex.utils.WXUtils.getString(map.get(TRANSITION_TIMING_FUNCTION), null));
        wXTransition.mWXComponent = wXComponent;
        return wXTransition;
    }

    public boolean hasTransitionProperty(java.util.Map<java.lang.String, java.lang.Object> map) {
        java.util.Iterator<java.lang.String> it = this.properties.iterator();
        while (it.hasNext()) {
            if (map.containsKey(it.next())) {
                return true;
            }
        }
        return false;
    }

    public void updateTranstionParams(java.util.Map<java.lang.String, java.lang.Object> map) {
        if (map.containsKey(TRANSITION_DELAY)) {
            this.mWXComponent.getStyles().put(TRANSITION_DELAY, map.remove(TRANSITION_DELAY));
            this.delay = parseTimeMillis(this.mWXComponent.getStyles(), TRANSITION_DELAY, 0L);
        }
        if (map.containsKey(TRANSITION_TIMING_FUNCTION) && map.get(TRANSITION_TIMING_FUNCTION) != null) {
            this.mWXComponent.getStyles().put(TRANSITION_TIMING_FUNCTION, map.remove(TRANSITION_TIMING_FUNCTION));
            this.interpolator = createTimeInterpolator(this.mWXComponent.getStyles().get(TRANSITION_TIMING_FUNCTION).toString());
        }
        if (map.containsKey(TRANSITION_DURATION)) {
            this.mWXComponent.getStyles().put(TRANSITION_DURATION, map.remove(TRANSITION_DURATION));
            this.duration = parseTimeMillis(this.mWXComponent.getStyles(), TRANSITION_DURATION, 0L);
        }
        if (map.containsKey(TRANSITION_PROPERTY)) {
            this.mWXComponent.getStyles().put(TRANSITION_PROPERTY, map.remove(TRANSITION_PROPERTY));
            updateTransitionProperties(this, com.taobao.weex.utils.WXUtils.getString(this.mWXComponent.getStyles().get(TRANSITION_PROPERTY), null));
        }
    }

    public void startTransition(java.util.Map<java.lang.String, java.lang.Object> map) {
        synchronized (this.lockToken) {
            if (getTargetView() == null) {
                return;
            }
            final int iIncrementAndGet = this.lockToken.incrementAndGet();
            for (java.lang.String str : this.properties) {
                if (map.containsKey(str)) {
                    java.lang.Object objRemove = map.remove(str);
                    if (LAYOUT_PROPERTIES.contains(str)) {
                        this.layoutPendingUpdates.put(str, objRemove);
                    } else if (TRANSFORM_PROPERTIES.contains(str)) {
                        this.transformPendingUpdates.put(str, objRemove);
                    }
                }
            }
            int numberInt = com.taobao.weex.utils.WXUtils.getNumberInt(this.mWXComponent.getAttrs().get("actionDelay"), 16);
            long j = numberInt;
            long j2 = this.duration;
            if (j > j2) {
                numberInt = (int) j2;
            }
            java.lang.Runnable runnable = this.animationRunnable;
            if (runnable != null) {
                this.handler.removeCallbacks(runnable);
            }
            java.lang.Runnable runnable2 = new java.lang.Runnable() { // from class: com.taobao.weex.dom.transition.WXTransition.1
                @Override // java.lang.Runnable
                public void run() {
                    if (iIncrementAndGet == com.taobao.weex.dom.transition.WXTransition.this.lockToken.get()) {
                        com.taobao.weex.dom.transition.WXTransition.this.doTransitionAnimation(iIncrementAndGet);
                    }
                    com.taobao.weex.dom.transition.WXTransition.this.animationRunnable = null;
                }
            };
            this.animationRunnable = runnable2;
            if (numberInt > 0) {
                this.handler.postDelayed(runnable2, numberInt);
            } else {
                runnable2.run();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doTransitionAnimation(final int i) {
        android.view.View targetView = getTargetView();
        if (targetView == null) {
            return;
        }
        if (this.targetStyles.size() > 0) {
            for (java.lang.String str : this.properties) {
                if (LAYOUT_PROPERTIES.contains(str) || TRANSFORM_PROPERTIES.contains(str)) {
                    if (!this.layoutPendingUpdates.containsKey(str) && !this.transformPendingUpdates.containsKey(str)) {
                        synchronized (this.targetStyles) {
                            if (this.targetStyles.containsKey(str)) {
                                this.mWXComponent.getStyles().put(str, this.targetStyles.remove(str));
                            }
                        }
                    }
                }
            }
        }
        java.lang.Runnable runnable = this.transitionEndEvent;
        if (runnable != null) {
            targetView.removeCallbacks(runnable);
        }
        if (this.transitionEndEvent == null && this.duration > Float.MIN_NORMAL) {
            this.transitionEndEvent = new java.lang.Runnable() { // from class: com.taobao.weex.dom.transition.WXTransition.2
                @Override // java.lang.Runnable
                public void run() {
                    com.taobao.weex.dom.transition.WXTransition.this.transitionEndEvent = null;
                    if (com.taobao.weex.dom.transition.WXTransition.this.duration >= Float.MIN_NORMAL && com.taobao.weex.dom.transition.WXTransition.this.mWXComponent != null && com.taobao.weex.dom.transition.WXTransition.this.mWXComponent.getEvents().contains(com.taobao.weex.common.Constants.Event.ON_TRANSITION_END)) {
                        com.taobao.weex.dom.transition.WXTransition.this.mWXComponent.fireEvent(com.taobao.weex.common.Constants.Event.ON_TRANSITION_END);
                    }
                }
            };
        }
        java.lang.Runnable runnable2 = this.transformAnimationRunnable;
        if (runnable2 != null) {
            targetView.removeCallbacks(runnable2);
        }
        java.lang.Runnable runnable3 = new java.lang.Runnable() { // from class: com.taobao.weex.dom.transition.WXTransition.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (com.taobao.weex.dom.transition.WXTransition.this.lockToken) {
                    if (i == com.taobao.weex.dom.transition.WXTransition.this.lockToken.get()) {
                        com.taobao.weex.dom.transition.WXTransition.this.doPendingTransformAnimation(i);
                    }
                }
            }
        };
        this.transformAnimationRunnable = runnable3;
        targetView.post(runnable3);
        doPendingLayoutAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doPendingTransformAnimation(int i) {
        android.view.View targetView;
        android.animation.ObjectAnimator objectAnimator = this.transformAnimator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            this.transformAnimator = null;
        }
        if (this.transformPendingUpdates.size() == 0 || (targetView = getTargetView()) == null || this.mWXComponent.getInstance() == null) {
            return;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(8);
        java.lang.String string = com.taobao.weex.utils.WXUtils.getString(this.transformPendingUpdates.remove("transform"), null);
        if (!android.text.TextUtils.isEmpty(string)) {
            for (android.animation.PropertyValuesHolder propertyValuesHolder : com.taobao.weex.ui.animation.TransformParser.toHolders(com.taobao.weex.ui.animation.TransformParser.parseTransForm(this.mWXComponent.getInstanceId(), string, (int) this.mWXComponent.getLayoutWidth(), (int) this.mWXComponent.getLayoutHeight(), this.mWXComponent.getViewPortWidthForFloat()))) {
                arrayList.add(propertyValuesHolder);
            }
            synchronized (this.targetStyles) {
                this.targetStyles.put("transform", string);
            }
        }
        for (java.lang.String str : this.properties) {
            if (TRANSFORM_PROPERTIES.contains(str) && this.transformPendingUpdates.containsKey(str)) {
                java.lang.Object objRemove = this.transformPendingUpdates.remove(str);
                synchronized (this.targetStyles) {
                    this.targetStyles.put(str, objRemove);
                }
                str.hashCode();
                if (str.equals("opacity")) {
                    arrayList.add(android.animation.PropertyValuesHolder.ofFloat((android.util.Property<?, java.lang.Float>) android.view.View.ALPHA, targetView.getAlpha(), com.taobao.weex.utils.WXUtils.getFloat(objRemove, java.lang.Float.valueOf(1.0f)).floatValue()));
                    targetView.setLayerType(1, null);
                } else if (str.equals("backgroundColor")) {
                    int color = com.taobao.weex.utils.WXResourceUtils.getColor(com.taobao.weex.utils.WXUtils.getString(this.mWXComponent.getStyles().getBackgroundColor(), null), 0);
                    int color2 = com.taobao.weex.utils.WXResourceUtils.getColor(com.taobao.weex.utils.WXUtils.getString(objRemove, null), 0);
                    if (com.taobao.weex.utils.WXViewUtils.getBorderDrawable(targetView) != null) {
                        color = com.taobao.weex.utils.WXViewUtils.getBorderDrawable(targetView).getColor();
                    } else if (targetView.getBackground() instanceof android.graphics.drawable.ColorDrawable) {
                        color = ((android.graphics.drawable.ColorDrawable) targetView.getBackground()).getColor();
                    }
                    arrayList.add(android.animation.PropertyValuesHolder.ofObject(new com.taobao.weex.ui.animation.BackgroundColorProperty(), new android.animation.ArgbEvaluator(), java.lang.Integer.valueOf(color), java.lang.Integer.valueOf(color2)));
                }
            }
        }
        if (i == this.lockToken.get()) {
            this.transformPendingUpdates.clear();
        }
        android.animation.ObjectAnimator objectAnimatorOfPropertyValuesHolder = android.animation.ObjectAnimator.ofPropertyValuesHolder(targetView, (android.animation.PropertyValuesHolder[]) arrayList.toArray(new android.animation.PropertyValuesHolder[arrayList.size()]));
        this.transformAnimator = objectAnimatorOfPropertyValuesHolder;
        objectAnimatorOfPropertyValuesHolder.setDuration(this.duration);
        long j = this.delay;
        if (j > 0) {
            this.transformAnimator.setStartDelay(j);
        }
        android.view.animation.Interpolator interpolator = this.interpolator;
        if (interpolator != null) {
            this.transformAnimator.setInterpolator(interpolator);
        }
        this.transformAnimator.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.taobao.weex.dom.transition.WXTransition.4
            boolean hasCancel = false;

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(android.animation.Animator animator) {
                super.onAnimationCancel(animator);
                this.hasCancel = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                if (this.hasCancel) {
                    return;
                }
                super.onAnimationEnd(animator);
                com.taobao.weex.dom.transition.WXTransition.this.onTransitionAnimationEnd();
            }
        });
        this.transformAnimator.start();
    }

    public void doPendingLayoutAnimation() {
        android.animation.ValueAnimator valueAnimator = this.layoutValueAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.layoutValueAnimator = null;
        }
        if (this.layoutPendingUpdates.size() == 0) {
            return;
        }
        android.animation.PropertyValuesHolder[] propertyValuesHolderArr = new android.animation.PropertyValuesHolder[this.layoutPendingUpdates.size()];
        if (this.properties.size() == 0) {
            return;
        }
        int i = 0;
        for (java.lang.String str : this.properties) {
            if (LAYOUT_PROPERTIES.contains(str) && this.layoutPendingUpdates.containsKey(str)) {
                java.lang.Object objRemove = this.layoutPendingUpdates.remove(str);
                synchronized (this.targetStyles) {
                    this.targetStyles.put(str, objRemove);
                }
                propertyValuesHolderArr[i] = createLayoutPropertyValueHolder(str, objRemove);
                i++;
            }
        }
        this.layoutPendingUpdates.clear();
        doLayoutPropertyValuesHolderAnimation(propertyValuesHolderArr);
    }

    private android.animation.PropertyValuesHolder createLayoutPropertyValueHolder(java.lang.String str, java.lang.Object obj) {
        android.animation.PropertyValuesHolder propertyValuesHolderOfFloat;
        com.taobao.weex.dom.transition.WXTransition wXTransition;
        android.animation.PropertyValuesHolder propertyValuesHolderOfFloat2;
        str.hashCode();
        switch (str) {
            case "paddingLeft":
                propertyValuesHolderOfFloat = android.animation.PropertyValuesHolder.ofFloat(com.taobao.weex.common.Constants.Name.PADDING_LEFT, this.mWXComponent.getPadding().get(com.taobao.weex.dom.CSSShorthand.EDGE.LEFT), com.taobao.weex.utils.WXViewUtils.getRealPxByWidth(com.taobao.weex.utils.WXUtils.getFloatByViewport(obj, this.mWXComponent.getViewPortWidthForFloat()), this.mWXComponent.getViewPortWidthForFloat()));
                break;
            case "bottom":
                wXTransition = this;
                propertyValuesHolderOfFloat2 = android.animation.PropertyValuesHolder.ofFloat("bottom", wXTransition.mWXComponent.getLayoutPosition().getBottom(), com.taobao.weex.utils.WXViewUtils.getRealPxByWidth(com.taobao.weex.utils.WXUtils.getFloatByViewport(obj, wXTransition.mWXComponent.getViewPortWidthForFloat()), wXTransition.mWXComponent.getViewPortWidthForFloat()));
                propertyValuesHolderOfFloat = propertyValuesHolderOfFloat2;
                break;
            case "height":
                wXTransition = this;
                propertyValuesHolderOfFloat2 = android.animation.PropertyValuesHolder.ofFloat("height", wXTransition.mWXComponent.getLayoutHeight(), com.taobao.weex.utils.WXViewUtils.getRealPxByWidth(com.taobao.weex.utils.WXUtils.getFloat(obj, java.lang.Float.valueOf(0.0f)).floatValue(), wXTransition.mWXComponent.getViewPortWidthForFloat()));
                propertyValuesHolderOfFloat = propertyValuesHolderOfFloat2;
                break;
            case "marginTop":
                wXTransition = this;
                propertyValuesHolderOfFloat2 = android.animation.PropertyValuesHolder.ofFloat(com.taobao.weex.common.Constants.Name.MARGIN_TOP, wXTransition.mWXComponent.getMargin().get(com.taobao.weex.dom.CSSShorthand.EDGE.TOP), com.taobao.weex.utils.WXViewUtils.getRealPxByWidth(com.taobao.weex.utils.WXUtils.getFloatByViewport(obj, wXTransition.mWXComponent.getViewPortWidthForFloat()), wXTransition.mWXComponent.getViewPortWidthForFloat()));
                propertyValuesHolderOfFloat = propertyValuesHolderOfFloat2;
                break;
            case "marginBottom":
                wXTransition = this;
                propertyValuesHolderOfFloat2 = android.animation.PropertyValuesHolder.ofFloat(com.taobao.weex.common.Constants.Name.MARGIN_BOTTOM, wXTransition.mWXComponent.getMargin().get(com.taobao.weex.dom.CSSShorthand.EDGE.BOTTOM), com.taobao.weex.utils.WXViewUtils.getRealPxByWidth(com.taobao.weex.utils.WXUtils.getFloatByViewport(obj, wXTransition.mWXComponent.getViewPortWidthForFloat()), wXTransition.mWXComponent.getViewPortWidthForFloat()));
                propertyValuesHolderOfFloat = propertyValuesHolderOfFloat2;
                break;
            case "top":
                wXTransition = this;
                propertyValuesHolderOfFloat2 = android.animation.PropertyValuesHolder.ofFloat("top", wXTransition.mWXComponent.getLayoutPosition().getTop(), com.taobao.weex.utils.WXViewUtils.getRealPxByWidth(com.taobao.weex.utils.WXUtils.getFloatByViewport(obj, wXTransition.mWXComponent.getViewPortWidthForFloat()), wXTransition.mWXComponent.getViewPortWidthForFloat()));
                propertyValuesHolderOfFloat = propertyValuesHolderOfFloat2;
                break;
            case "left":
                wXTransition = this;
                propertyValuesHolderOfFloat2 = android.animation.PropertyValuesHolder.ofFloat("left", wXTransition.mWXComponent.getLayoutPosition().getLeft(), com.taobao.weex.utils.WXViewUtils.getRealPxByWidth(com.taobao.weex.utils.WXUtils.getFloatByViewport(obj, wXTransition.mWXComponent.getViewPortWidthForFloat()), wXTransition.mWXComponent.getViewPortWidthForFloat()));
                propertyValuesHolderOfFloat = propertyValuesHolderOfFloat2;
                break;
            case "paddingTop":
                wXTransition = this;
                propertyValuesHolderOfFloat2 = android.animation.PropertyValuesHolder.ofFloat(com.taobao.weex.common.Constants.Name.PADDING_TOP, wXTransition.mWXComponent.getPadding().get(com.taobao.weex.dom.CSSShorthand.EDGE.TOP), com.taobao.weex.utils.WXViewUtils.getRealPxByWidth(com.taobao.weex.utils.WXUtils.getFloatByViewport(obj, wXTransition.mWXComponent.getViewPortWidthForFloat()), wXTransition.mWXComponent.getViewPortWidthForFloat()));
                propertyValuesHolderOfFloat = propertyValuesHolderOfFloat2;
                break;
            case "right":
                wXTransition = this;
                propertyValuesHolderOfFloat2 = android.animation.PropertyValuesHolder.ofFloat("right", wXTransition.mWXComponent.getLayoutPosition().getRight(), com.taobao.weex.utils.WXViewUtils.getRealPxByWidth(com.taobao.weex.utils.WXUtils.getFloatByViewport(obj, wXTransition.mWXComponent.getViewPortWidthForFloat()), wXTransition.mWXComponent.getViewPortWidthForFloat()));
                propertyValuesHolderOfFloat = propertyValuesHolderOfFloat2;
                break;
            case "width":
                wXTransition = this;
                propertyValuesHolderOfFloat2 = android.animation.PropertyValuesHolder.ofFloat("width", wXTransition.mWXComponent.getLayoutWidth(), com.taobao.weex.utils.WXViewUtils.getRealPxByWidth(com.taobao.weex.utils.WXUtils.getFloat(obj, java.lang.Float.valueOf(0.0f)).floatValue(), wXTransition.mWXComponent.getViewPortWidthForFloat()));
                propertyValuesHolderOfFloat = propertyValuesHolderOfFloat2;
                break;
            case "paddingBottom":
                wXTransition = this;
                propertyValuesHolderOfFloat2 = android.animation.PropertyValuesHolder.ofFloat(com.taobao.weex.common.Constants.Name.PADDING_BOTTOM, wXTransition.mWXComponent.getPadding().get(com.taobao.weex.dom.CSSShorthand.EDGE.BOTTOM), com.taobao.weex.utils.WXViewUtils.getRealPxByWidth(com.taobao.weex.utils.WXUtils.getFloatByViewport(obj, wXTransition.mWXComponent.getViewPortWidthForFloat()), wXTransition.mWXComponent.getViewPortWidthForFloat()));
                propertyValuesHolderOfFloat = propertyValuesHolderOfFloat2;
                break;
            case "paddingRight":
                wXTransition = this;
                propertyValuesHolderOfFloat2 = android.animation.PropertyValuesHolder.ofFloat(com.taobao.weex.common.Constants.Name.PADDING_RIGHT, wXTransition.mWXComponent.getPadding().get(com.taobao.weex.dom.CSSShorthand.EDGE.RIGHT), com.taobao.weex.utils.WXViewUtils.getRealPxByWidth(com.taobao.weex.utils.WXUtils.getFloatByViewport(obj, wXTransition.mWXComponent.getViewPortWidthForFloat()), wXTransition.mWXComponent.getViewPortWidthForFloat()));
                propertyValuesHolderOfFloat = propertyValuesHolderOfFloat2;
                break;
            case "marginRight":
                wXTransition = this;
                propertyValuesHolderOfFloat2 = android.animation.PropertyValuesHolder.ofFloat(com.taobao.weex.common.Constants.Name.MARGIN_RIGHT, wXTransition.mWXComponent.getMargin().get(com.taobao.weex.dom.CSSShorthand.EDGE.RIGHT), com.taobao.weex.utils.WXViewUtils.getRealPxByWidth(com.taobao.weex.utils.WXUtils.getFloatByViewport(obj, wXTransition.mWXComponent.getViewPortWidthForFloat()), wXTransition.mWXComponent.getViewPortWidthForFloat()));
                propertyValuesHolderOfFloat = propertyValuesHolderOfFloat2;
                break;
            case "marginLeft":
                wXTransition = this;
                propertyValuesHolderOfFloat2 = android.animation.PropertyValuesHolder.ofFloat(com.taobao.weex.common.Constants.Name.MARGIN_LEFT, wXTransition.mWXComponent.getMargin().get(com.taobao.weex.dom.CSSShorthand.EDGE.LEFT), com.taobao.weex.utils.WXViewUtils.getRealPxByWidth(com.taobao.weex.utils.WXUtils.getFloatByViewport(obj, wXTransition.mWXComponent.getViewPortWidthForFloat()), wXTransition.mWXComponent.getViewPortWidthForFloat()));
                propertyValuesHolderOfFloat = propertyValuesHolderOfFloat2;
                break;
            default:
                propertyValuesHolderOfFloat = null;
                break;
        }
        return propertyValuesHolderOfFloat == null ? android.animation.PropertyValuesHolder.ofFloat(str, 1.0f, 1.0f) : propertyValuesHolderOfFloat;
    }

    private void doLayoutPropertyValuesHolderAnimation(android.animation.PropertyValuesHolder[] propertyValuesHolderArr) {
        android.animation.ValueAnimator valueAnimatorOfPropertyValuesHolder = android.animation.ValueAnimator.ofPropertyValuesHolder(propertyValuesHolderArr);
        this.layoutValueAnimator = valueAnimatorOfPropertyValuesHolder;
        valueAnimatorOfPropertyValuesHolder.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.taobao.weex.dom.transition.WXTransition.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                for (android.animation.PropertyValuesHolder propertyValuesHolder : valueAnimator.getValues()) {
                    java.lang.String propertyName = propertyValuesHolder.getPropertyName();
                    com.taobao.weex.dom.transition.WXTransition.asynchronouslyUpdateLayout(com.taobao.weex.dom.transition.WXTransition.this.mWXComponent, propertyName, ((java.lang.Float) valueAnimator.getAnimatedValue(propertyName)).floatValue());
                }
            }
        });
        this.layoutValueAnimator.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.taobao.weex.dom.transition.WXTransition.6
            boolean hasCancel = false;

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(android.animation.Animator animator) {
                super.onAnimationCancel(animator);
                this.hasCancel = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                if (this.hasCancel) {
                    return;
                }
                super.onAnimationEnd(animator);
                com.taobao.weex.dom.transition.WXTransition.this.onTransitionAnimationEnd();
            }
        });
        android.view.animation.Interpolator interpolator = this.interpolator;
        if (interpolator != null) {
            this.layoutValueAnimator.setInterpolator(interpolator);
        }
        this.layoutValueAnimator.setStartDelay(this.delay);
        this.layoutValueAnimator.setDuration(this.duration);
        this.layoutValueAnimator.start();
    }

    public static void asynchronouslyUpdateLayout(com.taobao.weex.ui.component.WXComponent wXComponent, final java.lang.String str, final float f) {
        if (wXComponent == null || wXComponent.getInstance() == null) {
            return;
        }
        final java.lang.String ref = wXComponent.getRef();
        final java.lang.String instanceId = wXComponent.getInstanceId();
        if (android.text.TextUtils.isEmpty(ref) || android.text.TextUtils.isEmpty(instanceId)) {
            return;
        }
        com.taobao.weex.WXSDKManager.getInstance().getWXBridgeManager().post(new java.lang.Runnable() { // from class: com.taobao.weex.dom.transition.WXTransition.7
            @Override // java.lang.Runnable
            public void run() {
                java.lang.String str2 = str;
                str2.hashCode();
                switch (str2) {
                    case "paddingLeft":
                        com.taobao.weex.bridge.WXBridgeManager.getInstance().setPadding(instanceId, ref, com.taobao.weex.dom.CSSShorthand.EDGE.LEFT, f);
                        break;
                    case "bottom":
                        com.taobao.weex.bridge.WXBridgeManager.getInstance().setPosition(instanceId, ref, com.taobao.weex.dom.CSSShorthand.EDGE.BOTTOM, f);
                        break;
                    case "height":
                        com.taobao.weex.bridge.WXBridgeManager.getInstance().setStyleHeight(instanceId, ref, f);
                        break;
                    case "marginTop":
                        com.taobao.weex.bridge.WXBridgeManager.getInstance().setMargin(instanceId, ref, com.taobao.weex.dom.CSSShorthand.EDGE.TOP, f);
                        break;
                    case "marginBottom":
                        com.taobao.weex.bridge.WXBridgeManager.getInstance().setMargin(instanceId, ref, com.taobao.weex.dom.CSSShorthand.EDGE.BOTTOM, f);
                        break;
                    case "top":
                        com.taobao.weex.bridge.WXBridgeManager.getInstance().setPosition(instanceId, ref, com.taobao.weex.dom.CSSShorthand.EDGE.TOP, f);
                        break;
                    case "left":
                        com.taobao.weex.bridge.WXBridgeManager.getInstance().setPosition(instanceId, ref, com.taobao.weex.dom.CSSShorthand.EDGE.LEFT, f);
                        break;
                    case "paddingTop":
                        com.taobao.weex.bridge.WXBridgeManager.getInstance().setPadding(instanceId, ref, com.taobao.weex.dom.CSSShorthand.EDGE.TOP, f);
                        break;
                    case "right":
                        com.taobao.weex.bridge.WXBridgeManager.getInstance().setPosition(instanceId, ref, com.taobao.weex.dom.CSSShorthand.EDGE.RIGHT, f);
                        break;
                    case "width":
                        com.taobao.weex.bridge.WXBridgeManager.getInstance().setStyleWidth(instanceId, ref, f);
                        break;
                    case "paddingBottom":
                        com.taobao.weex.bridge.WXBridgeManager.getInstance().setPadding(instanceId, ref, com.taobao.weex.dom.CSSShorthand.EDGE.BOTTOM, f);
                        break;
                    case "paddingRight":
                        com.taobao.weex.bridge.WXBridgeManager.getInstance().setPadding(instanceId, ref, com.taobao.weex.dom.CSSShorthand.EDGE.RIGHT, f);
                        break;
                    case "marginRight":
                        com.taobao.weex.bridge.WXBridgeManager.getInstance().setMargin(instanceId, ref, com.taobao.weex.dom.CSSShorthand.EDGE.RIGHT, f);
                        break;
                    case "marginLeft":
                        com.taobao.weex.bridge.WXBridgeManager.getInstance().setMargin(instanceId, ref, com.taobao.weex.dom.CSSShorthand.EDGE.LEFT, f);
                        break;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void onTransitionAnimationEnd() {
        java.lang.Runnable runnable;
        if (this.duration > 0 && this.transitionEndEvent != null) {
            android.view.View targetView = getTargetView();
            if (targetView != null && (runnable = this.transitionEndEvent) != null) {
                targetView.post(runnable);
            }
            this.transitionEndEvent = null;
        }
        synchronized (this.targetStyles) {
            if (this.targetStyles.size() > 0) {
                for (java.lang.String str : this.properties) {
                    if (this.targetStyles.containsKey(str)) {
                        this.mWXComponent.getStyles().put(str, this.targetStyles.remove(str));
                    }
                }
                this.targetStyles.clear();
            }
        }
    }

    private android.view.View getTargetView() {
        com.taobao.weex.ui.component.WXComponent wXComponent = this.mWXComponent;
        if (wXComponent != null) {
            return wXComponent.getHostView();
        }
        return null;
    }

    private static long parseTimeMillis(java.util.Map<java.lang.String, java.lang.Object> map, java.lang.String str, long j) {
        java.lang.String string = com.taobao.weex.utils.WXUtils.getString(map.get(str), null);
        if (string != null) {
            string = string.replaceAll("ms", "");
        }
        if (string != null) {
            if (com.taobao.weex.WXEnvironment.isApkDebugable() && string.contains("px")) {
                com.taobao.weex.utils.WXLogUtils.w("Transition Duration Unit Only Support ms, " + string + " is not ms Unit");
            }
            string = string.replaceAll("px", "");
        }
        if (android.text.TextUtils.isEmpty(string)) {
            return j;
        }
        try {
            return (long) java.lang.Float.parseFloat(string);
        } catch (java.lang.NumberFormatException unused) {
            return j;
        }
    }

    private static android.view.animation.Interpolator createTimeInterpolator(java.lang.String str) {
        if (!android.text.TextUtils.isEmpty(str)) {
            str.hashCode();
            switch (str) {
                case "ease-in":
                    return androidx.core.view.animation.PathInterpolatorCompat.create(0.42f, 0.0f, 1.0f, 1.0f);
                case "linear":
                    return androidx.core.view.animation.PathInterpolatorCompat.create(0.0f, 0.0f, 1.0f, 1.0f);
                case "ease-out":
                    return androidx.core.view.animation.PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
                case "ease-in-out":
                    return androidx.core.view.animation.PathInterpolatorCompat.create(0.42f, 0.0f, 0.58f, 1.0f);
                case "ease":
                    return androidx.core.view.animation.PathInterpolatorCompat.create(0.25f, 0.1f, 0.25f, 1.0f);
                default:
                    try {
                        java.util.List list = new com.taobao.weex.utils.SingleFunctionParser(str, new com.taobao.weex.utils.SingleFunctionParser.FlatMapper<java.lang.Float>() { // from class: com.taobao.weex.dom.transition.WXTransition.8
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // com.taobao.weex.utils.SingleFunctionParser.FlatMapper
                            public java.lang.Float map(java.lang.String str2) {
                                return java.lang.Float.valueOf(java.lang.Float.parseFloat(str2));
                            }
                        }).parse("cubic-bezier");
                        if (list != null && list.size() == 4) {
                            return androidx.core.view.animation.PathInterpolatorCompat.create(((java.lang.Float) list.get(0)).floatValue(), ((java.lang.Float) list.get(1)).floatValue(), ((java.lang.Float) list.get(2)).floatValue(), ((java.lang.Float) list.get(3)).floatValue());
                        }
                    } catch (java.lang.RuntimeException e) {
                        if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
                            com.taobao.weex.utils.WXLogUtils.e("WXTransition", e);
                        }
                        break;
                    }
                    break;
            }
        }
        return androidx.core.view.animation.PathInterpolatorCompat.create(0.25f, 0.1f, 0.25f, 1.0f);
    }

    private static void updateTransitionProperties(com.taobao.weex.dom.transition.WXTransition wXTransition, java.lang.String str) {
        if (str == null) {
            return;
        }
        wXTransition.properties.clear();
        for (java.lang.String str2 : PROPERTY_SPLIT_PATTERN.split(str)) {
            java.lang.String strTrim = str2.trim();
            if (!android.text.TextUtils.isEmpty(strTrim)) {
                if (!LAYOUT_PROPERTIES.contains(strTrim) && !TRANSFORM_PROPERTIES.contains(strTrim)) {
                    if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
                        com.taobao.weex.utils.WXLogUtils.e("WXTransition Property Not Supported" + strTrim + " in " + str);
                    }
                } else {
                    wXTransition.properties.add(strTrim);
                }
            }
        }
    }

    public java.util.List<java.lang.String> getProperties() {
        return this.properties;
    }
}
