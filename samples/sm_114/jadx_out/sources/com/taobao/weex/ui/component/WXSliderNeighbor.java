package com.taobao.weex.ui.component;

/* JADX INFO: loaded from: classes.dex */
public class WXSliderNeighbor extends com.taobao.weex.ui.component.WXSlider {
    public static final java.lang.String CURRENT_ITEM_SCALE = "currentItemScale";
    private static final float DEFAULT_CURRENT_ITEM_SCALE = 0.9f;
    private static final float DEFAULT_NEIGHBOR_ALPHA = 0.6f;
    private static final float DEFAULT_NEIGHBOR_SCALE = 0.8f;
    private static final int DEFAULT_NEIGHBOR_SPACE = 25;
    public static final java.lang.String NEIGHBOR_ALPHA = "neighborAlpha";
    public static final java.lang.String NEIGHBOR_SCALE = "neighborScale";
    public static final java.lang.String NEIGHBOR_SPACE = "neighborSpace";
    private com.taobao.weex.ui.component.WXSliderNeighbor.ZoomTransformer mCachedTransformer;
    private float mCurrentItemScale;
    private float mNeighborAlpha;
    private float mNeighborScale;
    private float mNeighborSpace;

    public WXSliderNeighbor(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.ui.component.WXVContainer wXVContainer, com.taobao.weex.ui.action.BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, basicComponentData);
        this.mNeighborScale = DEFAULT_NEIGHBOR_SCALE;
        this.mNeighborAlpha = DEFAULT_NEIGHBOR_ALPHA;
        this.mNeighborSpace = 25.0f;
        this.mCurrentItemScale = DEFAULT_CURRENT_ITEM_SCALE;
    }

    public static class Creator implements com.taobao.weex.ui.ComponentCreator {
        @Override // com.taobao.weex.ui.ComponentCreator
        public com.taobao.weex.ui.component.WXComponent createInstance(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.ui.component.WXVContainer wXVContainer, com.taobao.weex.ui.action.BasicComponentData basicComponentData) throws java.lang.IllegalAccessException, java.lang.InstantiationException, java.lang.reflect.InvocationTargetException {
            return new com.taobao.weex.ui.component.WXSliderNeighbor(wXSDKInstance, wXVContainer, basicComponentData);
        }
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void bindData(com.taobao.weex.ui.component.WXComponent wXComponent) {
        super.bindData(wXComponent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXSlider, com.taobao.weex.ui.component.WXComponent
    public com.taobao.weex.ui.view.BaseFrameLayout initComponentHostView(android.content.Context context) {
        com.taobao.weex.ui.view.BaseFrameLayout baseFrameLayout = new com.taobao.weex.ui.view.BaseFrameLayout(context);
        android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.mViewPager = new com.taobao.weex.ui.view.WXCircleViewPager(getContext());
        this.mViewPager.setLayoutParams(layoutParams);
        this.mAdapter = new com.taobao.weex.ui.view.WXCirclePageAdapter();
        this.mViewPager.setAdapter(this.mAdapter);
        baseFrameLayout.addView(this.mViewPager);
        this.mViewPager.addOnPageChangeListener(this.mPageChangeListener);
        this.mViewPager.setOverScrollMode(2);
        registerActivityStateListener();
        this.mViewPager.setPageTransformer(false, createTransformer());
        return baseFrameLayout;
    }

    com.taobao.weex.ui.component.WXSliderNeighbor.ZoomTransformer createTransformer() {
        if (this.mCachedTransformer == null) {
            this.mCachedTransformer = new com.taobao.weex.ui.component.WXSliderNeighbor.ZoomTransformer();
        }
        return this.mCachedTransformer;
    }

    @Override // com.taobao.weex.ui.component.WXSlider, io.dcloud.feature.uniapp.ui.component.AbsVContainer
    public void addSubView(android.view.View view, final int i) {
        if (view == null || this.mAdapter == null || (view instanceof com.taobao.weex.ui.view.WXCircleIndicator)) {
            return;
        }
        android.widget.FrameLayout frameLayout = new android.widget.FrameLayout(getContext());
        android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        view.setLayoutParams(layoutParams);
        frameLayout.addView(view);
        super.addSubView(frameLayout, i);
        updateAdapterScaleAndAlpha(this.mNeighborAlpha, this.mNeighborScale);
        this.mViewPager.postDelayed(com.taobao.weex.common.WXThread.secure(new java.lang.Runnable() { // from class: com.taobao.weex.ui.component.WXSliderNeighbor.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    try {
                        if (com.taobao.weex.ui.component.WXSliderNeighbor.this.mViewPager.getRealCount() > 0 && i > 2) {
                            com.taobao.weex.ui.component.WXSliderNeighbor.this.mViewPager.beginFakeDrag();
                            com.taobao.weex.ui.component.WXSliderNeighbor.this.mViewPager.fakeDragBy(1.0f);
                        }
                        com.taobao.weex.ui.component.WXSliderNeighbor.this.mViewPager.endFakeDrag();
                    } catch (java.lang.IndexOutOfBoundsException unused) {
                        com.taobao.weex.ui.component.WXSliderNeighbor.this.mViewPager.endFakeDrag();
                    } catch (java.lang.Throwable th) {
                        try {
                            com.taobao.weex.ui.component.WXSliderNeighbor.this.mViewPager.endFakeDrag();
                        } catch (java.lang.Exception unused2) {
                        }
                        throw th;
                    }
                } catch (java.lang.Exception unused3) {
                }
            }
        }), 50L);
    }

    private void updateScaleAndAlpha(android.view.View view, float f, float f2) {
        if (view == null) {
            return;
        }
        if (f >= 0.0f && view.getAlpha() != f) {
            view.setAlpha(f);
        }
        if (f2 < 0.0f || view.getScaleX() == f2) {
            return;
        }
        view.setScaleX(f2);
        view.setScaleY(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAdapterScaleAndAlpha(final float f, final float f2) {
        java.util.List<android.view.View> views = this.mAdapter.getViews();
        int currentItem = this.mViewPager.getCurrentItem();
        if (views.size() > 0) {
            final android.view.View view = views.get(currentItem);
            updateScaleAndAlpha(((android.view.ViewGroup) view).getChildAt(0), 1.0f, this.mCurrentItemScale);
            if (views.size() < 2) {
                return;
            }
            view.postDelayed(com.taobao.weex.common.WXThread.secure(new java.lang.Runnable() { // from class: com.taobao.weex.ui.component.WXSliderNeighbor.2
                @Override // java.lang.Runnable
                public void run() {
                    com.taobao.weex.ui.component.WXSliderNeighbor.this.updateNeighbor(view, f, f2);
                }
            }), 17L);
            int size = currentItem == 0 ? views.size() - 1 : currentItem - 1;
            int i = currentItem == views.size() + (-1) ? 0 : currentItem + 1;
            for (int i2 = 0; i2 < this.mAdapter.getRealCount(); i2++) {
                if (i2 != size && i2 != currentItem && i2 != i) {
                    ((android.view.ViewGroup) views.get(i2)).getChildAt(0).setAlpha(0.0f);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateNeighbor(android.view.View view, float f, float f2) {
        java.util.List<android.view.View> views = this.mAdapter.getViews();
        int currentItem = this.mViewPager.getCurrentItem();
        float fCalculateTranslation = calculateTranslation(view);
        android.view.View view2 = views.get(currentItem == 0 ? views.size() - 1 : currentItem - 1);
        android.view.View view3 = views.get(currentItem == views.size() - 1 ? 0 : currentItem + 1);
        if (views.size() != 2) {
            moveLeft(view2, fCalculateTranslation, f, f2);
            moveRight(view3, fCalculateTranslation, f, f2);
        } else if (currentItem == 0) {
            moveRight(view3, fCalculateTranslation, f, f2);
        } else if (currentItem == 1) {
            moveLeft(view2, fCalculateTranslation, f, f2);
        }
    }

    private void moveLeft(android.view.View view, float f, float f2, float f3) {
        android.view.ViewGroup viewGroup = (android.view.ViewGroup) view;
        updateScaleAndAlpha(viewGroup.getChildAt(0), f2, f3);
        view.setTranslationX(f);
        viewGroup.getChildAt(0).setTranslationX(f);
    }

    private void moveRight(android.view.View view, float f, float f2, float f3) {
        moveLeft(view, -f, f2, f3);
    }

    @com.taobao.weex.ui.component.WXComponentProp(name = NEIGHBOR_SCALE)
    public void setNeighborScale(java.lang.String str) {
        float f;
        if (android.text.TextUtils.isEmpty(str)) {
            f = DEFAULT_NEIGHBOR_SCALE;
        } else {
            try {
                f = java.lang.Float.parseFloat(str);
            } catch (java.lang.NumberFormatException unused) {
                f = DEFAULT_NEIGHBOR_SCALE;
            }
        }
        if (this.mNeighborScale != f) {
            this.mNeighborScale = f;
            updateAdapterScaleAndAlpha(-1.0f, f);
        }
    }

    @com.taobao.weex.ui.component.WXComponentProp(name = NEIGHBOR_ALPHA)
    public void setNeighborAlpha(java.lang.String str) {
        float f;
        if (android.text.TextUtils.isEmpty(str)) {
            f = DEFAULT_NEIGHBOR_ALPHA;
        } else {
            try {
                f = java.lang.Float.parseFloat(str);
            } catch (java.lang.NumberFormatException unused) {
                f = DEFAULT_NEIGHBOR_ALPHA;
            }
        }
        if (this.mNeighborAlpha != f) {
            this.mNeighborAlpha = f;
            updateAdapterScaleAndAlpha(f, -1.0f);
        }
    }

    @com.taobao.weex.ui.component.WXComponentProp(name = NEIGHBOR_SPACE)
    public void setNeighborSpace(java.lang.String str) {
        float f;
        if (android.text.TextUtils.isEmpty(str)) {
            f = 25.0f;
        } else {
            try {
                f = java.lang.Float.parseFloat(str);
            } catch (java.lang.NumberFormatException unused) {
                f = 25.0f;
            }
        }
        if (this.mNeighborSpace != f) {
            this.mNeighborSpace = f;
        }
    }

    @com.taobao.weex.ui.component.WXComponentProp(name = CURRENT_ITEM_SCALE)
    public void setCurrentItemScale(java.lang.String str) {
        float f;
        if (android.text.TextUtils.isEmpty(str)) {
            f = DEFAULT_CURRENT_ITEM_SCALE;
        } else {
            try {
                f = java.lang.Float.parseFloat(str);
            } catch (java.lang.NumberFormatException unused) {
                f = DEFAULT_CURRENT_ITEM_SCALE;
            }
        }
        if (this.mCurrentItemScale != f) {
            this.mCurrentItemScale = f;
            updateAdapterScaleAndAlpha(-1.0f, -1.0f);
        }
    }

    @Override // com.taobao.weex.ui.component.WXSlider, com.taobao.weex.ui.component.WXComponent
    protected boolean setProperty(java.lang.String str, java.lang.Object obj) {
        str.hashCode();
        switch (str) {
            case "neighborAlpha":
                java.lang.String string = com.taobao.weex.utils.WXUtils.getString(obj, null);
                if (string != null) {
                    setNeighborAlpha(string);
                }
                return true;
            case "neighborScale":
                java.lang.String string2 = com.taobao.weex.utils.WXUtils.getString(obj, null);
                if (string2 != null) {
                    setNeighborScale(string2);
                }
                return true;
            case "neighborSpace":
                java.lang.String string3 = com.taobao.weex.utils.WXUtils.getString(obj, null);
                if (string3 != null) {
                    setNeighborSpace(string3);
                }
                return true;
            case "currentItemScale":
                java.lang.String string4 = com.taobao.weex.utils.WXUtils.getString(obj, null);
                if (string4 != null) {
                    setCurrentItemScale(string4);
                }
                return true;
            default:
                return super.setProperty(str, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float calculateTranslation(android.view.View view) {
        if (!(view instanceof android.view.ViewGroup)) {
            return 0.0f;
        }
        android.view.View childAt = ((android.view.ViewGroup) view).getChildAt(0);
        return ((view.getMeasuredWidth() - (childAt.getMeasuredWidth() * this.mNeighborScale)) / 4.0f) + ((((view.getMeasuredWidth() - (childAt.getMeasuredWidth() * this.mCurrentItemScale)) / 2.0f) - com.taobao.weex.utils.WXViewUtils.getRealPxByWidth(this.mNeighborSpace, getInstance().getInstanceViewPortWidthWithFloat())) / 2.0f);
    }

    class ZoomTransformer implements androidx.viewpager.widget.ViewPager.PageTransformer {
        ZoomTransformer() {
        }

        @Override // androidx.viewpager.widget.ViewPager.PageTransformer
        public void transformPage(android.view.View view, float f) {
            android.view.View childAt;
            int pagePosition = com.taobao.weex.ui.component.WXSliderNeighbor.this.mAdapter.getPagePosition(view);
            int currentItem = com.taobao.weex.ui.component.WXSliderNeighbor.this.mViewPager.getCurrentItem();
            int realCount = com.taobao.weex.ui.component.WXSliderNeighbor.this.mAdapter.getRealCount();
            boolean z = (currentItem == 0 || currentItem == realCount + (-1) || java.lang.Math.abs(pagePosition - currentItem) <= 1) ? false : true;
            if (currentItem == 0 && pagePosition < realCount - 1 && pagePosition > 1) {
                z = true;
            }
            int i = realCount - 1;
            if (currentItem == i && pagePosition < realCount - 2 && pagePosition > 0) {
                z = true;
            }
            if (z || (childAt = ((android.view.ViewGroup) view).getChildAt(0)) == null) {
                return;
            }
            if (f <= (-realCount) + 1) {
                f += realCount;
            }
            if (f >= i) {
                f -= realCount;
            }
            if (f < -1.0f || f > 1.0f) {
                return;
            }
            float fAbs = java.lang.Math.abs(java.lang.Math.abs(f) - 1.0f);
            float f2 = com.taobao.weex.ui.component.WXSliderNeighbor.this.mNeighborScale + ((com.taobao.weex.ui.component.WXSliderNeighbor.this.mCurrentItemScale - com.taobao.weex.ui.component.WXSliderNeighbor.this.mNeighborScale) * fAbs);
            float f3 = ((1.0f - com.taobao.weex.ui.component.WXSliderNeighbor.this.mNeighborAlpha) * fAbs) + com.taobao.weex.ui.component.WXSliderNeighbor.this.mNeighborAlpha;
            float fCalculateTranslation = com.taobao.weex.ui.component.WXSliderNeighbor.this.calculateTranslation(view);
            if (f > 0.0f) {
                float f4 = -(f * fCalculateTranslation);
                childAt.setTranslationX(f4);
                view.setTranslationX(f4);
            } else if (f == 0.0f) {
                view.setTranslationX(0.0f);
                childAt.setTranslationX(0.0f);
                com.taobao.weex.ui.component.WXSliderNeighbor wXSliderNeighbor = com.taobao.weex.ui.component.WXSliderNeighbor.this;
                wXSliderNeighbor.updateAdapterScaleAndAlpha(wXSliderNeighbor.mNeighborAlpha, com.taobao.weex.ui.component.WXSliderNeighbor.this.mNeighborScale);
            } else {
                if (realCount == 2 && java.lang.Math.abs(f) == 1.0f) {
                    return;
                }
                float f5 = (-f) * fCalculateTranslation;
                childAt.setTranslationX(f5);
                view.setTranslationX(f5);
            }
            childAt.setScaleX(f2);
            childAt.setScaleY(f2);
            childAt.setAlpha(f3);
        }
    }
}
