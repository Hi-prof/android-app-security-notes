package com.taobao.weex.ui.component.list;

/* JADX INFO: loaded from: classes.dex */
@com.taobao.weex.annotation.Component(lazyload = false)
public class WXListComponent extends com.taobao.weex.ui.component.list.BasicListComponent<com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView> {
    private java.lang.String TAG;
    private boolean hasSetGapItemDecoration;
    private float mPaddingLeft;
    private float mPaddingRight;
    private java.lang.Float[] mSpanOffsets;
    private java.lang.String mSpanOffsetsStr;
    private boolean renderReverse;

    public static class Creator implements com.taobao.weex.ui.ComponentCreator {
        @Override // com.taobao.weex.ui.ComponentCreator
        public com.taobao.weex.ui.component.WXComponent createInstance(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.ui.component.WXVContainer wXVContainer, com.taobao.weex.ui.action.BasicComponentData basicComponentData) throws java.lang.IllegalAccessException, java.lang.InstantiationException, java.lang.reflect.InvocationTargetException {
            return new com.taobao.weex.ui.component.list.WXListComponent(wXSDKInstance, wXVContainer, true, basicComponentData);
        }
    }

    @java.lang.Deprecated
    public WXListComponent(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.ui.component.WXVContainer wXVContainer, java.lang.String str, boolean z, com.taobao.weex.ui.action.BasicComponentData basicComponentData) {
        this(wXSDKInstance, wXVContainer, z, basicComponentData);
    }

    public WXListComponent(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.ui.component.WXVContainer wXVContainer, boolean z, com.taobao.weex.ui.action.BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, basicComponentData);
        this.TAG = "WXListComponent";
        this.hasSetGapItemDecoration = false;
        this.renderReverse = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.list.BasicListComponent
    public com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView generateListView(android.content.Context context, int i) {
        androidx.recyclerview.widget.SnapHelper wXPagerSnapHelper;
        com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView bounceRecyclerView = new com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView(context, this.mLayoutType, this.mColumnCount, this.mColumnGap, i);
        if (bounceRecyclerView.getSwipeLayout() != null && com.taobao.weex.utils.WXUtils.getBoolean(getAttrs().get(com.taobao.weex.common.Constants.Name.NEST_SCROLLING_ENABLED), false).booleanValue()) {
            bounceRecyclerView.getSwipeLayout().setNestedScrollingEnabled(true);
        }
        if (com.taobao.weex.utils.WXUtils.getBoolean(getAttrs().get(com.taobao.weex.common.Constants.Name.PAGE_ENABLED), false).booleanValue()) {
            if (android.text.TextUtils.isEmpty(com.taobao.weex.utils.WXUtils.getString(getAttrs().get(com.taobao.weex.common.Constants.Name.PAGE_SIZE), null))) {
                wXPagerSnapHelper = new androidx.recyclerview.widget.PagerSnapHelper();
            } else {
                wXPagerSnapHelper = new com.taobao.weex.ui.component.list.WXPagerSnapHelper();
            }
            wXPagerSnapHelper.attachToRecyclerView((androidx.recyclerview.widget.RecyclerView) bounceRecyclerView.getInnerView());
        }
        return bounceRecyclerView;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.taobao.weex.ui.component.list.BasicListComponent, io.dcloud.feature.uniapp.ui.component.AbsVContainer
    public void addChild(com.taobao.weex.ui.component.WXComponent wXComponent, int i) {
        super.addChild(wXComponent, i);
        if (wXComponent == null || i < -1) {
            return;
        }
        setRefreshOrLoading(wXComponent);
        if (getHostView() == 0 || !hasColumnPros()) {
            return;
        }
        updateRecyclerAttr();
        ((com.taobao.weex.ui.view.listview.WXRecyclerView) ((com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView) getHostView()).getInnerView()).initView(getContext(), this.mLayoutType, this.mColumnCount, this.mColumnGap, getOrientation());
    }

    private boolean hasColumnPros() {
        if (getAttrs().containsKey(com.taobao.weex.common.Constants.Name.COLUMN_WIDTH) && this.mColumnWidth != com.taobao.weex.utils.WXUtils.parseFloat(getAttrs().get(com.taobao.weex.common.Constants.Name.COLUMN_WIDTH))) {
            return true;
        }
        if (!getAttrs().containsKey(com.taobao.weex.common.Constants.Name.COLUMN_COUNT) || this.mColumnCount == com.taobao.weex.utils.WXUtils.parseInt(getAttrs().get(com.taobao.weex.common.Constants.Name.COLUMN_COUNT))) {
            return getAttrs().containsKey(com.taobao.weex.common.Constants.Name.COLUMN_GAP) && this.mColumnGap != com.taobao.weex.utils.WXUtils.parseFloat(getAttrs().get(com.taobao.weex.common.Constants.Name.COLUMN_GAP));
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean setRefreshOrLoading(final com.taobao.weex.ui.component.WXComponent wXComponent) {
        if (getHostView() == 0) {
            com.taobao.weex.utils.WXLogUtils.e(this.TAG, "setRefreshOrLoading: HostView == null !!!!!! check list attr has append =tree");
            return true;
        }
        if (wXComponent instanceof com.taobao.weex.ui.component.WXRefresh) {
            ((com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView) getHostView()).setOnRefreshListener((com.taobao.weex.ui.component.WXRefresh) wXComponent);
            ((com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView) getHostView()).postDelayed(com.taobao.weex.common.WXThread.secure(new java.lang.Runnable() { // from class: com.taobao.weex.ui.component.list.WXListComponent.1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    ((com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView) com.taobao.weex.ui.component.list.WXListComponent.this.getHostView()).setHeaderView(wXComponent);
                }
            }), 100L);
            return true;
        }
        if (!(wXComponent instanceof com.taobao.weex.ui.component.WXLoading)) {
            return false;
        }
        ((com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView) getHostView()).setOnLoadingListener((com.taobao.weex.ui.component.WXLoading) wXComponent);
        ((com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView) getHostView()).postDelayed(com.taobao.weex.common.WXThread.secure(new java.lang.Runnable() { // from class: com.taobao.weex.ui.component.list.WXListComponent.2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                ((com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView) com.taobao.weex.ui.component.list.WXListComponent.this.getHostView()).setFooterView(wXComponent);
            }
        }), 100L);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void updateRecyclerAttr() {
        this.mColumnCount = com.taobao.weex.utils.WXUtils.parseInt(getAttrs().get(com.taobao.weex.common.Constants.Name.COLUMN_COUNT));
        if (this.mColumnCount <= 0 && this.mLayoutType != 1) {
            androidx.collection.ArrayMap arrayMap = new androidx.collection.ArrayMap();
            arrayMap.put("componentType", getComponentType());
            arrayMap.put("attribute", getAttrs().toString());
            arrayMap.put("stackTrace", java.util.Arrays.toString(java.lang.Thread.currentThread().getStackTrace()));
            com.taobao.weex.utils.WXExceptionUtils.commitCriticalExceptionRT(getInstanceId(), com.taobao.weex.common.WXErrorCode.WX_RENDER_ERR_LIST_INVALID_COLUMN_COUNT, com.taobao.weex.common.Constants.Name.COLUMN_COUNT, java.lang.String.format(java.util.Locale.ENGLISH, "You are trying to set the list/recycler/vlist/waterfall's column to %d, which is illegal. The column count should be a positive integer", java.lang.Integer.valueOf(this.mColumnCount)), arrayMap);
            this.mColumnCount = 1;
        }
        this.mColumnGap = com.taobao.weex.utils.WXUtils.parseFloat(getAttrs().get(com.taobao.weex.common.Constants.Name.COLUMN_GAP));
        this.mColumnWidth = com.taobao.weex.utils.WXUtils.parseFloat(getAttrs().get(com.taobao.weex.common.Constants.Name.COLUMN_WIDTH));
        this.mPaddingLeft = com.taobao.weex.utils.WXUtils.parseFloat(getAttrs().get(com.taobao.weex.common.Constants.Name.PADDING_LEFT));
        this.mPaddingRight = com.taobao.weex.utils.WXUtils.parseFloat(getAttrs().get(com.taobao.weex.common.Constants.Name.PADDING_RIGHT));
        java.lang.String str = (java.lang.String) getAttrs().get(com.taobao.weex.common.Constants.Name.SPAN_OFFSETS);
        this.mSpanOffsetsStr = str;
        try {
            if (!android.text.TextUtils.isEmpty(str)) {
                java.util.List array = com.alibaba.fastjson.JSON.parseArray(this.mSpanOffsetsStr, java.lang.Float.class);
                int size = array.size();
                java.lang.Float[] fArr = this.mSpanOffsets;
                if (fArr == null || fArr.length != size) {
                    this.mSpanOffsets = new java.lang.Float[size];
                }
                array.toArray(this.mSpanOffsets);
            } else {
                this.mSpanOffsets = null;
            }
        } catch (java.lang.Throwable th) {
            com.taobao.weex.utils.WXLogUtils.w("Parser SpanOffsets error ", th);
        }
        if (this.hasSetGapItemDecoration || getSpanOffsets() == null || getHostView() == 0 || ((com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView) getHostView()).getInnerView() == null) {
            return;
        }
        this.hasSetGapItemDecoration = true;
        ((com.taobao.weex.ui.view.listview.WXRecyclerView) ((com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView) getHostView()).getInnerView()).addItemDecoration(new com.taobao.weex.ui.component.list.GapItemDecoration(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @com.taobao.weex.ui.component.WXComponentProp(name = com.taobao.weex.common.Constants.Name.SPAN_OFFSETS)
    public void setSpanOffsets(java.lang.String str) {
        if (android.text.TextUtils.equals(str, this.mSpanOffsetsStr)) {
            return;
        }
        markComponentUsable();
        updateRecyclerAttr();
        ((com.taobao.weex.ui.view.listview.WXRecyclerView) ((com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView) getHostView()).getInnerView()).initView(getContext(), this.mLayoutType, this.mColumnCount, this.mColumnGap, getOrientation());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @com.taobao.weex.ui.component.WXComponentProp(name = com.taobao.weex.common.Constants.Name.COLUMN_WIDTH)
    public void setColumnWidth(float f) {
        if (f != this.mColumnWidth) {
            markComponentUsable();
            updateRecyclerAttr();
            com.taobao.weex.ui.view.listview.WXRecyclerView wXRecyclerView = (com.taobao.weex.ui.view.listview.WXRecyclerView) ((com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView) getHostView()).getInnerView();
            if (wXRecyclerView.getLayoutManager() != null) {
                wXRecyclerView.getAdapter().notifyDataSetChanged();
            } else {
                wXRecyclerView.initView(getContext(), this.mLayoutType, this.mColumnCount, this.mColumnGap, getOrientation());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @com.taobao.weex.ui.component.WXComponentProp(name = com.taobao.weex.common.Constants.Name.COLUMN_COUNT)
    public void setColumnCount(int i) {
        if (i != this.mColumnCount) {
            markComponentUsable();
            updateRecyclerAttr();
            ((com.taobao.weex.ui.view.listview.WXRecyclerView) ((com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView) getHostView()).getInnerView()).initView(getContext(), this.mLayoutType, this.mColumnCount, this.mColumnGap, getOrientation());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @com.taobao.weex.ui.component.WXComponentProp(name = com.taobao.weex.common.Constants.Name.COLUMN_GAP)
    public void setColumnGap(float f) throws java.lang.InterruptedException {
        if (f != this.mColumnGap) {
            markComponentUsable();
            updateRecyclerAttr();
            ((com.taobao.weex.ui.view.listview.WXRecyclerView) ((com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView) getHostView()).getInnerView()).initView(getContext(), this.mLayoutType, this.mColumnCount, this.mColumnGap, getOrientation());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.taobao.weex.ui.component.list.BasicListComponent
    @com.taobao.weex.ui.component.WXComponentProp(name = com.taobao.weex.common.Constants.Name.SCROLLABLE)
    public void setScrollable(boolean z) {
        ((com.taobao.weex.ui.view.listview.WXRecyclerView) ((com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView) getHostView()).getInnerView()).setScrollable(z);
    }

    @com.taobao.weex.ui.component.WXComponentProp(name = "renderReverse")
    public void setRenderReverse(boolean z) {
        this.renderReverse = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.taobao.weex.ui.component.WXComponent
    public void updateProperties(java.util.Map<java.lang.String, java.lang.Object> map) {
        super.updateProperties(map);
        if (isRecycler(this)) {
            if (com.taobao.weex.ui.component.WXBasicComponentType.WATERFALL.equals(getComponentType())) {
                this.mLayoutType = 3;
            } else {
                this.mLayoutType = getAttrs().getLayoutType();
            }
        }
        if (map.containsKey("padding") || map.containsKey(com.taobao.weex.common.Constants.Name.PADDING_LEFT) || map.containsKey(com.taobao.weex.common.Constants.Name.PADDING_RIGHT)) {
            if (this.mPaddingLeft == com.taobao.weex.utils.WXUtils.parseFloat(map.get(com.taobao.weex.common.Constants.Name.PADDING_LEFT)) && this.mPaddingRight == com.taobao.weex.utils.WXUtils.parseFloat(map.get(com.taobao.weex.common.Constants.Name.PADDING_RIGHT))) {
                return;
            }
            markComponentUsable();
            updateRecyclerAttr();
            ((com.taobao.weex.ui.view.listview.WXRecyclerView) ((com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView) getHostView()).getInnerView()).initView(getContext(), this.mLayoutType, this.mColumnCount, this.mColumnGap, getOrientation());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.dcloud.feature.uniapp.ui.component.AbsVContainer
    public void createChildViewAt(int i) {
        if (i >= 0 || (i = childCount() - 1) >= 0) {
            com.taobao.weex.common.IWXObject listChild = getListChild(i);
            if (listChild instanceof com.taobao.weex.ui.component.WXBaseRefresh) {
                final com.taobao.weex.ui.component.WXComponent wXComponent = (com.taobao.weex.ui.component.WXComponent) listChild;
                wXComponent.createView();
                if (listChild instanceof com.taobao.weex.ui.component.WXRefresh) {
                    ((com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView) getHostView()).setOnRefreshListener((com.taobao.weex.ui.component.WXRefresh) listChild);
                    ((com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView) getHostView()).postDelayed(new java.lang.Runnable() { // from class: com.taobao.weex.ui.component.list.WXListComponent.3
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.lang.Runnable
                        public void run() {
                            ((com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView) com.taobao.weex.ui.component.list.WXListComponent.this.getHostView()).setHeaderView(wXComponent);
                        }
                    }, 100L);
                    return;
                } else {
                    if (listChild instanceof com.taobao.weex.ui.component.WXLoading) {
                        ((com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView) getHostView()).setOnLoadingListener((com.taobao.weex.ui.component.WXLoading) listChild);
                        ((com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView) getHostView()).postDelayed(new java.lang.Runnable() { // from class: com.taobao.weex.ui.component.list.WXListComponent.4
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // java.lang.Runnable
                            public void run() {
                                ((com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView) com.taobao.weex.ui.component.list.WXListComponent.this.getHostView()).setFooterView(wXComponent);
                            }
                        }, 100L);
                        return;
                    }
                    return;
                }
            }
            super.createChildViewAt(i);
        }
    }

    @Override // com.taobao.weex.ui.component.list.BasicListComponent, io.dcloud.feature.uniapp.ui.component.AbsVContainer
    public void remove(com.taobao.weex.ui.component.WXComponent wXComponent, boolean z) {
        super.remove(wXComponent, z);
        removeFooterOrHeader(wXComponent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void removeFooterOrHeader(com.taobao.weex.ui.component.WXComponent wXComponent) {
        if (wXComponent instanceof com.taobao.weex.ui.component.WXLoading) {
            ((com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView) getHostView()).removeFooterView(wXComponent);
        } else if (wXComponent instanceof com.taobao.weex.ui.component.WXRefresh) {
            ((com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView) getHostView()).removeHeaderView(wXComponent);
        }
    }

    private boolean isRecycler(com.taobao.weex.ui.component.WXComponent wXComponent) {
        return com.taobao.weex.ui.component.WXBasicComponentType.WATERFALL.equals(wXComponent.getComponentType()) || com.taobao.weex.ui.component.WXBasicComponentType.RECYCLE_LIST.equals(wXComponent.getComponentType()) || com.taobao.weex.ui.component.WXBasicComponentType.RECYCLER.equals(wXComponent.getComponentType());
    }

    public java.lang.Float[] getSpanOffsets() {
        return this.mSpanOffsets;
    }

    @Override // com.taobao.weex.ui.component.list.BasicListComponent
    public boolean isRenderFromBottom() {
        return this.renderReverse;
    }
}
