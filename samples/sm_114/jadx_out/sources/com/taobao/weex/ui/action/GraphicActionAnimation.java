package com.taobao.weex.ui.action;

/* JADX INFO: loaded from: classes.dex */
public class GraphicActionAnimation extends com.taobao.weex.ui.action.BasicGraphicAction {
    private static final java.lang.String TAG = "GraphicActionAnimation";
    private final java.lang.String callback;
    private com.taobao.weex.ui.animation.WXAnimationBean mAnimationBean;
    private final boolean styleNeedInit;

    public GraphicActionAnimation(com.taobao.weex.WXSDKInstance wXSDKInstance, java.lang.String str, com.taobao.weex.ui.animation.WXAnimationBean wXAnimationBean) {
        super(wXSDKInstance, str);
        this.styleNeedInit = false;
        this.callback = null;
        this.mAnimationBean = wXAnimationBean;
    }

    public GraphicActionAnimation(com.taobao.weex.WXSDKInstance wXSDKInstance, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        super(wXSDKInstance, str);
        this.styleNeedInit = true;
        this.callback = str3;
        if (android.text.TextUtils.isEmpty(str2)) {
            return;
        }
        this.mAnimationBean = (com.taobao.weex.ui.animation.WXAnimationBean) com.alibaba.fastjson.JSONObject.parseObject(str2, com.taobao.weex.ui.animation.WXAnimationBean.class);
    }

    public GraphicActionAnimation(com.taobao.weex.WXSDKInstance wXSDKInstance, java.lang.String str, com.taobao.weex.ui.animation.WXAnimationBean wXAnimationBean, java.lang.String str2) {
        super(wXSDKInstance, str);
        this.styleNeedInit = false;
        this.mAnimationBean = wXAnimationBean;
        this.callback = str2;
    }

    @Override // com.taobao.weex.ui.action.IExecutable
    public void executeAction() {
        com.taobao.weex.WXSDKInstance wXSDKInstance;
        if (this.mAnimationBean == null) {
            return;
        }
        com.taobao.weex.ui.component.WXComponent wXComponent = com.taobao.weex.WXSDKManager.getInstance().getWXRenderManager().getWXComponent(getPageId(), getRef());
        if ((wXComponent == null && (!com.taobao.weex.ui.component.list.template.TemplateDom.isVirtualDomRef(getRef()) || (wXComponent = com.taobao.weex.ui.component.list.template.TemplateDom.findVirtualComponentByVRef(getPageId(), getRef())) == null)) || (wXSDKInstance = com.taobao.weex.WXSDKManager.getInstance().getWXRenderManager().getWXSDKInstance(getPageId())) == null || this.mAnimationBean.styles == null) {
            return;
        }
        if (this.styleNeedInit) {
            java.lang.String str = (java.lang.String) wXComponent.getStyles().get(com.taobao.weex.common.Constants.Name.TRANSFORM_ORIGIN);
            if (android.text.TextUtils.isEmpty(this.mAnimationBean.styles.transformOrigin)) {
                this.mAnimationBean.styles.transformOrigin = str;
            }
            this.mAnimationBean.styles.init(this.mAnimationBean.styles.transformOrigin, this.mAnimationBean.styles.transform, (int) wXComponent.getLayoutWidth(), (int) wXComponent.getLayoutHeight(), wXSDKInstance.getInstanceViewPortWidthWithFloat(), wXSDKInstance);
        }
        startAnimation(wXSDKInstance, wXComponent);
    }

    private void startAnimation(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.ui.component.WXComponent wXComponent) {
        if (wXComponent != null) {
            com.taobao.weex.ui.animation.WXAnimationBean wXAnimationBean = this.mAnimationBean;
            if (wXAnimationBean != null) {
                wXComponent.setNeedLayoutOnAnimation(wXAnimationBean.needLayout);
            }
            if (wXComponent.getHostView() == null) {
                wXComponent.postAnimation(new com.taobao.weex.ui.animation.WXAnimationModule.AnimationHolder(this.mAnimationBean, this.callback));
                return;
            }
            try {
                android.animation.ObjectAnimator objectAnimatorCreateAnimator = createAnimator(wXComponent.getHostView(), wXSDKInstance.getInstanceViewPortWidthWithFloat());
                if (objectAnimatorCreateAnimator != null) {
                    android.animation.Animator.AnimatorListener animatorListenerCreateAnimatorListener = createAnimatorListener(wXSDKInstance, this.callback);
                    android.view.animation.Interpolator interpolatorCreateTimeInterpolator = createTimeInterpolator();
                    if (animatorListenerCreateAnimatorListener != null) {
                        objectAnimatorCreateAnimator.addListener(animatorListenerCreateAnimatorListener);
                    }
                    if (interpolatorCreateTimeInterpolator != null) {
                        objectAnimatorCreateAnimator.setInterpolator(interpolatorCreateTimeInterpolator);
                    }
                    wXComponent.getHostView().setCameraDistance(this.mAnimationBean.styles.getCameraDistance());
                    objectAnimatorCreateAnimator.setDuration(this.mAnimationBean.duration);
                    objectAnimatorCreateAnimator.start();
                }
            } catch (java.lang.RuntimeException e) {
                com.taobao.weex.utils.WXLogUtils.e(TAG, com.taobao.weex.utils.WXLogUtils.getStackTrace(e));
            }
        }
    }

    private android.animation.ObjectAnimator createAnimator(android.view.View view, float f) {
        com.taobao.weex.ui.animation.WXAnimationBean.Style style;
        if (view == null || (style = this.mAnimationBean.styles) == null) {
            return null;
        }
        java.util.List<android.animation.PropertyValuesHolder> holders = style.getHolders();
        if (!android.text.TextUtils.isEmpty(style.backgroundColor)) {
            com.taobao.weex.ui.view.border.BorderDrawable borderDrawable = com.taobao.weex.utils.WXViewUtils.getBorderDrawable(view);
            if (borderDrawable != null) {
                holders.add(android.animation.PropertyValuesHolder.ofObject(new com.taobao.weex.ui.animation.BackgroundColorProperty(), new android.animation.ArgbEvaluator(), java.lang.Integer.valueOf(borderDrawable.getColor()), java.lang.Integer.valueOf(com.taobao.weex.utils.WXResourceUtils.getColor(style.backgroundColor))));
            } else if (view.getBackground() instanceof android.graphics.drawable.ColorDrawable) {
                holders.add(android.animation.PropertyValuesHolder.ofObject(new com.taobao.weex.ui.animation.BackgroundColorProperty(), new android.animation.ArgbEvaluator(), java.lang.Integer.valueOf(((android.graphics.drawable.ColorDrawable) view.getBackground()).getColor()), java.lang.Integer.valueOf(com.taobao.weex.utils.WXResourceUtils.getColor(style.backgroundColor))));
            }
        }
        if (view.getLayoutParams() != null && (!android.text.TextUtils.isEmpty(style.width) || !android.text.TextUtils.isEmpty(style.height))) {
            android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (!android.text.TextUtils.isEmpty(style.width)) {
                holders.add(android.animation.PropertyValuesHolder.ofInt(new com.taobao.weex.ui.animation.WidthProperty(), layoutParams.width, (int) com.taobao.weex.utils.WXViewUtils.getRealPxByWidth(com.taobao.weex.utils.WXUtils.getFloat(style.width), f)));
            }
            if (!android.text.TextUtils.isEmpty(style.height)) {
                holders.add(android.animation.PropertyValuesHolder.ofInt(new com.taobao.weex.ui.animation.HeightProperty(), layoutParams.height, (int) com.taobao.weex.utils.WXViewUtils.getRealPxByWidth(com.taobao.weex.utils.WXUtils.getFloat(style.height), f)));
            }
        }
        if (style.getPivot() != null) {
            android.util.Pair<java.lang.Float, java.lang.Float> pivot = style.getPivot();
            view.setPivotX(((java.lang.Float) pivot.first).floatValue());
            view.setPivotY(((java.lang.Float) pivot.second).floatValue());
        }
        android.animation.ObjectAnimator objectAnimatorOfPropertyValuesHolder = android.animation.ObjectAnimator.ofPropertyValuesHolder(view, (android.animation.PropertyValuesHolder[]) holders.toArray(new android.animation.PropertyValuesHolder[holders.size()]));
        objectAnimatorOfPropertyValuesHolder.setStartDelay(this.mAnimationBean.delay);
        return objectAnimatorOfPropertyValuesHolder;
    }

    private android.animation.Animator.AnimatorListener createAnimatorListener(final com.taobao.weex.WXSDKInstance wXSDKInstance, final java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        return new android.animation.AnimatorListenerAdapter() { // from class: com.taobao.weex.ui.action.GraphicActionAnimation.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                com.taobao.weex.WXSDKInstance wXSDKInstance2 = wXSDKInstance;
                if (wXSDKInstance2 == null || wXSDKInstance2.isDestroy()) {
                    com.taobao.weex.utils.WXLogUtils.e("RenderContextImpl-onAnimationEnd WXSDKInstance == null NPE or instance is destroyed");
                } else {
                    com.taobao.weex.WXSDKManager.getInstance().callback(wXSDKInstance.getInstanceId(), str, new java.util.HashMap());
                }
            }
        };
    }

    private android.view.animation.Interpolator createTimeInterpolator() {
        java.lang.String str = this.mAnimationBean.timingFunction;
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        str.hashCode();
        switch (str) {
            case "ease-in":
                return new android.view.animation.AccelerateInterpolator();
            case "linear":
                return new android.view.animation.LinearInterpolator();
            case "ease-out":
                return new android.view.animation.DecelerateInterpolator();
            case "ease-in-out":
                return new android.view.animation.AccelerateDecelerateInterpolator();
            default:
                try {
                    java.util.List list = new com.taobao.weex.utils.SingleFunctionParser(this.mAnimationBean.timingFunction, new com.taobao.weex.utils.SingleFunctionParser.FlatMapper<java.lang.Float>() { // from class: com.taobao.weex.ui.action.GraphicActionAnimation.2
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // com.taobao.weex.utils.SingleFunctionParser.FlatMapper
                        public java.lang.Float map(java.lang.String str2) {
                            return java.lang.Float.valueOf(java.lang.Float.parseFloat(str2));
                        }
                    }).parse("cubic-bezier");
                    if (list != null && list.size() == 4) {
                        return androidx.core.view.animation.PathInterpolatorCompat.create(((java.lang.Float) list.get(0)).floatValue(), ((java.lang.Float) list.get(1)).floatValue(), ((java.lang.Float) list.get(2)).floatValue(), ((java.lang.Float) list.get(3)).floatValue());
                    }
                } catch (java.lang.RuntimeException unused) {
                }
                return null;
        }
    }
}
