package com.taobao.weex.ui.component.list;

/* JADX INFO: loaded from: classes.dex */
@com.taobao.weex.annotation.Component(lazyload = false)
public class WXCell extends com.taobao.weex.ui.flat.WidgetContainer<com.taobao.weex.ui.view.WXFrameLayout> {
    private com.taobao.weex.ui.component.list.WXCell.CellAppendTreeListener cellAppendTreeListener;
    private boolean isAppendTreeDone;
    private boolean isSourceUsed;
    private boolean mFlatUIEnabled;
    private android.view.View mHeadView;
    private int mLastLocationY;
    private android.view.ViewGroup mRealView;
    private int mScrollPosition;
    private android.view.View mTempStickyView;
    private java.lang.Object renderData;

    public interface CellAppendTreeListener {
        void onAppendTreeDone();
    }

    public static class Creator implements com.taobao.weex.ui.ComponentCreator {
        @Override // com.taobao.weex.ui.ComponentCreator
        public com.taobao.weex.ui.component.WXComponent createInstance(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.ui.component.WXVContainer wXVContainer, com.taobao.weex.ui.action.BasicComponentData basicComponentData) throws java.lang.IllegalAccessException, java.lang.InstantiationException, java.lang.reflect.InvocationTargetException {
            return new com.taobao.weex.ui.component.list.WXCell(wXSDKInstance, wXVContainer, true, basicComponentData);
        }
    }

    @java.lang.Deprecated
    public WXCell(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.ui.component.WXVContainer wXVContainer, java.lang.String str, boolean z, com.taobao.weex.ui.action.BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, basicComponentData);
        this.mLastLocationY = 0;
        this.mScrollPosition = -1;
        this.mFlatUIEnabled = false;
        this.isSourceUsed = false;
    }

    public WXCell(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.ui.component.WXVContainer wXVContainer, boolean z, com.taobao.weex.ui.action.BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, basicComponentData);
        this.mLastLocationY = 0;
        this.mScrollPosition = -1;
        this.mFlatUIEnabled = false;
        this.isSourceUsed = false;
        lazy(true);
        setContentBoxMeasurement(new com.taobao.weex.layout.ContentBoxMeasurement() { // from class: com.taobao.weex.ui.component.list.WXCell.1
            @Override // com.taobao.weex.layout.ContentBoxMeasurement
            public void layoutAfter(float f, float f2) {
            }

            @Override // com.taobao.weex.layout.ContentBoxMeasurement
            public void layoutBefore() {
            }

            @Override // com.taobao.weex.layout.ContentBoxMeasurement
            public void measureInternal(float f, float f2, int i, int i2) {
                if (i2 == 0) {
                    this.mMeasureHeight = 1.0f;
                }
            }
        });
        if (!canRecycled()) {
            wXSDKInstance.getApmForInstance().updateDiffStats(com.taobao.weex.performance.WXInstanceApm.KEY_PAGE_STATS_CELL_DATA_UN_RECYCLE_NUM, 1.0d);
        }
        if (android.text.TextUtils.isEmpty(getAttrs().getScope())) {
            wXSDKInstance.getApmForInstance().updateDiffStats(com.taobao.weex.performance.WXInstanceApm.KEY_PAGE_STATS_CELL_UN_RE_USE_NUM, 1.0d);
        }
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public boolean isLazy() {
        return super.isLazy() && !isFixed();
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public boolean isFlatUIEnabled() {
        return this.mFlatUIEnabled;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXComponent
    public com.taobao.weex.ui.view.WXFrameLayout initComponentHostView(android.content.Context context) {
        if (isSticky() || (this instanceof com.taobao.weex.ui.component.WXHeader)) {
            com.taobao.weex.ui.view.WXFrameLayout wXFrameLayout = new com.taobao.weex.ui.view.WXFrameLayout(context);
            com.taobao.weex.ui.view.WXFrameLayout wXFrameLayout2 = new com.taobao.weex.ui.view.WXFrameLayout(context);
            this.mRealView = wXFrameLayout2;
            wXFrameLayout.addView(wXFrameLayout2);
            if (isFlatUIEnabled()) {
                wXFrameLayout.setLayerType(2, null);
            }
            return wXFrameLayout;
        }
        com.taobao.weex.ui.view.WXFrameLayout wXFrameLayout3 = new com.taobao.weex.ui.view.WXFrameLayout(context);
        this.mRealView = wXFrameLayout3;
        if (isFlatUIEnabled()) {
            wXFrameLayout3.setLayerType(2, null);
        }
        return wXFrameLayout3;
    }

    public int getLocationFromStart() {
        return this.mLastLocationY;
    }

    public void setLocationFromStart(int i) {
        this.mLastLocationY = i;
    }

    void setScrollPositon(int i) {
        this.mScrollPosition = i;
    }

    public int getScrollPositon() {
        return this.mScrollPosition;
    }

    @Override // io.dcloud.feature.uniapp.ui.component.AbsVContainer, com.taobao.weex.ui.component.WXComponent
    public android.view.ViewGroup getRealView() {
        return this.mRealView;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [android.view.View] */
    public void removeSticky() {
        if (((com.taobao.weex.ui.view.WXFrameLayout) getHostView()).getChildCount() > 0) {
            this.mHeadView = ((com.taobao.weex.ui.view.WXFrameLayout) getHostView()).getChildAt(0);
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            ((com.taobao.weex.ui.view.WXFrameLayout) getHostView()).getLocationOnScreen(iArr);
            getParentScroller().getView().getLocationOnScreen(iArr2);
            int i = iArr[0] - iArr2[0];
            int top = getParent().getHostView().getTop();
            ((com.taobao.weex.ui.view.WXFrameLayout) getHostView()).removeView(this.mHeadView);
            this.mRealView = (android.view.ViewGroup) this.mHeadView;
            this.mTempStickyView = new android.widget.FrameLayout(getContext());
            ((com.taobao.weex.ui.view.WXFrameLayout) getHostView()).addView(this.mTempStickyView, new android.widget.FrameLayout.LayoutParams((int) getLayoutWidth(), (int) getLayoutHeight()));
            this.mHeadView.setTranslationX(i);
            this.mHeadView.setTranslationY(top);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void recoverySticky() {
        android.view.View view = this.mHeadView;
        if (view != null) {
            if (view.getLayoutParams() != null) {
                android.view.ViewGroup.MarginLayoutParams marginLayoutParams = (android.view.ViewGroup.MarginLayoutParams) this.mHeadView.getLayoutParams();
                if (marginLayoutParams.topMargin > 0) {
                    marginLayoutParams.topMargin = 0;
                }
            }
            if (this.mHeadView.getVisibility() != 0) {
                this.mHeadView.setVisibility(0);
            }
            if (this.mHeadView.getParent() != null) {
                ((android.view.ViewGroup) this.mHeadView.getParent()).removeView(this.mHeadView);
            }
            ((com.taobao.weex.ui.view.WXFrameLayout) getHostView()).removeView(this.mTempStickyView);
            ((com.taobao.weex.ui.view.WXFrameLayout) getHostView()).addView(this.mHeadView);
            this.mHeadView.setTranslationX(0.0f);
            this.mHeadView.setTranslationY(0.0f);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.taobao.weex.ui.flat.WidgetContainer
    protected void mountFlatGUI() {
        if (getHostView() != 0) {
            if (this.widgets == null) {
                this.widgets = new java.util.LinkedList();
            }
            ((com.taobao.weex.ui.view.WXFrameLayout) getHostView()).mountFlatGUI(this.widgets);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.taobao.weex.ui.flat.WidgetContainer
    public void unmountFlatGUI() {
        if (getHostView() != 0) {
            ((com.taobao.weex.ui.view.WXFrameLayout) getHostView()).unmountFlatGUI();
        }
    }

    @Override // com.taobao.weex.ui.flat.WidgetContainer
    public boolean intendToBeFlatContainer() {
        return getInstance().getFlatUIContext().isFlatUIEnabled(this) && com.taobao.weex.ui.component.list.WXCell.class.equals(getClass()) && !isSticky();
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public int getStickyOffset() {
        if (getAttrs().get(com.taobao.weex.common.Constants.Name.STICKY_OFFSET) == null) {
            return 0;
        }
        return (int) com.taobao.weex.utils.WXViewUtils.getRealPxByWidth(com.taobao.weex.utils.WXUtils.getFloat(getAttrs().get(com.taobao.weex.common.Constants.Name.STICKY_OFFSET)), getViewPortWidthForFloat());
    }

    public java.lang.Object getRenderData() {
        return this.renderData;
    }

    public void setRenderData(java.lang.Object obj) {
        this.renderData = obj;
    }

    public boolean isSourceUsed() {
        return this.isSourceUsed;
    }

    public void setSourceUsed(boolean z) {
        this.isSourceUsed = z;
    }

    public boolean isAppendTreeDone() {
        return this.isAppendTreeDone;
    }

    @Override // io.dcloud.feature.uniapp.ui.component.AbsVContainer
    public void appendTreeCreateFinish() {
        super.appendTreeCreateFinish();
        this.isAppendTreeDone = true;
        com.taobao.weex.ui.component.list.WXCell.CellAppendTreeListener cellAppendTreeListener = this.cellAppendTreeListener;
        if (cellAppendTreeListener != null) {
            cellAppendTreeListener.onAppendTreeDone();
        }
    }

    public void setCellAppendTreeListener(com.taobao.weex.ui.component.list.WXCell.CellAppendTreeListener cellAppendTreeListener) {
        this.cellAppendTreeListener = cellAppendTreeListener;
        if (this.isAppendTreeDone) {
            cellAppendTreeListener.onAppendTreeDone();
        }
    }

    @Override // io.dcloud.feature.uniapp.ui.component.AbsVContainer, com.taobao.weex.ui.component.WXComponent
    public void createViewImpl() {
        if (getRealView() == null || getRealView().getParent() == null) {
            super.createViewImpl();
        }
    }
}
