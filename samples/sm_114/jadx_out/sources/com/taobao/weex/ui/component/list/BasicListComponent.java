package com.taobao.weex.ui.component.list;

/* JADX INFO: loaded from: classes.dex */
public abstract class BasicListComponent<T extends android.view.ViewGroup & com.taobao.weex.ui.component.list.ListComponentView> extends com.taobao.weex.ui.component.WXVContainer<T> implements com.taobao.weex.ui.view.listview.adapter.IRecyclerAdapterListener<com.taobao.weex.ui.view.listview.adapter.ListBaseViewHolder>, com.taobao.weex.ui.view.listview.adapter.IOnLoadMoreListener, com.taobao.weex.ui.component.Scrollable {
    private static final boolean DEFAULT_EXCLUDED = false;
    private static final java.lang.String DEFAULT_TRIGGER_TYPE = "longpress";
    private static final java.lang.String DRAG_ANCHOR = "dragAnchor";
    private static final java.lang.String DRAG_TRIGGER_TYPE = "dragTriggerType";
    private static final java.lang.String EXCLUDED = "dragExcluded";
    public static final java.lang.String LOADMOREOFFSET = "loadmoreoffset";
    private static final int MAX_VIEWTYPE_ALLOW_CACHE = 9;
    public static final java.lang.String TRANSFORM = "transform";
    private java.lang.String TAG;
    private boolean isScrollable;
    boolean isThisGroupFinished;
    private com.taobao.weex.ui.component.WXComponent keepPositionCell;
    private java.lang.Runnable keepPositionCellRunnable;
    private long keepPositionLayoutDelay;
    com.taobao.weex.ui.component.list.ListStanceCell listStanceObject;
    private java.lang.Runnable mAppearChangeRunnable;
    private long mAppearChangeRunnableDelay;
    private java.util.Map<java.lang.String, com.taobao.weex.ui.component.AppearanceHelper> mAppearComponents;
    protected int mColumnCount;
    protected float mColumnGap;
    protected float mColumnWidth;
    private com.taobao.weex.ui.component.list.DragHelper mDragHelper;
    private boolean mForceLoadmoreNextTime;
    private boolean mHasAddScrollEvent;
    private androidx.recyclerview.widget.RecyclerView.ItemAnimator mItemAnimator;
    private android.graphics.Point mLastReport;
    protected int mLayoutType;
    protected float mLeftGap;
    private int mListCellCount;
    private int mOffsetAccuracy;
    private androidx.collection.ArrayMap<java.lang.String, java.lang.Long> mRefToViewType;
    protected float mRightGap;
    private com.taobao.weex.ui.component.helper.ScrollStartEndHelper mScrollStartEndHelper;
    private java.util.Map<java.lang.String, java.util.Map<java.lang.String, com.taobao.weex.ui.component.WXComponent>> mStickyMap;
    private java.lang.String mTriggerType;
    private com.taobao.weex.ui.view.listview.adapter.WXRecyclerViewOnScrollListener mViewOnScrollListener;
    private android.util.SparseArray<java.util.ArrayList<com.taobao.weex.ui.component.WXComponent>> mViewTypes;
    private com.taobao.weex.ui.component.helper.WXStickyHelper stickyHelper;
    private static final java.util.regex.Pattern transformPattern = java.util.regex.Pattern.compile("([a-z]+)\\(([0-9\\.]+),?([0-9\\.]+)?\\)");
    private static boolean mAllowCacheViewHolder = true;
    private static boolean mDownForBidCacheViewHolder = false;

    interface DragTriggerType {
        public static final java.lang.String LONG_PRESS = "longpress";
        public static final java.lang.String PAN = "pan";
    }

    @Override // io.dcloud.feature.uniapp.ui.component.AbsVContainer
    public void addSubView(android.view.View view, int i) {
    }

    abstract T generateListView(android.content.Context context, int i);

    @Override // com.taobao.weex.ui.component.WXVContainer, io.dcloud.feature.uniapp.ui.component.AbsVContainer
    protected int getChildrenLayoutTopOffset() {
        return 0;
    }

    @Override // com.taobao.weex.ui.component.Scrollable
    public int getOrientation() {
        return 1;
    }

    protected boolean isRenderFromBottom() {
        return false;
    }

    public BasicListComponent(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.ui.component.WXVContainer wXVContainer, com.taobao.weex.ui.action.BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, basicComponentData);
        this.TAG = "BasicListComponent";
        this.mListCellCount = 0;
        this.mForceLoadmoreNextTime = false;
        this.mAppearComponents = new java.util.HashMap();
        this.mAppearChangeRunnable = null;
        this.mAppearChangeRunnableDelay = 50L;
        this.isScrollable = true;
        this.mViewOnScrollListener = new com.taobao.weex.ui.view.listview.adapter.WXRecyclerViewOnScrollListener(this);
        this.mLayoutType = 1;
        this.mColumnCount = 1;
        this.mColumnGap = 0.0f;
        this.mColumnWidth = 0.0f;
        this.mLeftGap = 0.0f;
        this.mRightGap = 0.0f;
        this.mOffsetAccuracy = 10;
        this.mLastReport = new android.graphics.Point(-1, -1);
        this.mHasAddScrollEvent = false;
        this.mStickyMap = new java.util.HashMap();
        this.keepPositionCell = null;
        this.keepPositionCellRunnable = null;
        this.keepPositionLayoutDelay = 150L;
        this.isThisGroupFinished = false;
        this.stickyHelper = new com.taobao.weex.ui.component.helper.WXStickyHelper(this);
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void setMarginsSupportRTL(android.view.ViewGroup.MarginLayoutParams marginLayoutParams, int i, int i2, int i3, int i4) {
        marginLayoutParams.setMargins(i, i2, i3, i4);
        marginLayoutParams.setMarginStart(i);
        marginLayoutParams.setMarginEnd(i3);
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void setLayout(com.taobao.weex.ui.component.WXComponent wXComponent) {
        if (wXComponent.getHostView() != null) {
            androidx.core.view.ViewCompat.setLayoutDirection(wXComponent.getHostView(), wXComponent.isLayoutRTL() ? 1 : 0);
        }
        super.setLayout(wXComponent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXComponent
    public void onHostViewInitialized(T t) {
        super.onHostViewInitialized(t);
        com.taobao.weex.ui.view.listview.WXRecyclerView innerView = t.getInnerView();
        if (innerView == null || innerView.getAdapter() == null) {
            com.taobao.weex.utils.WXLogUtils.e(this.TAG, "RecyclerView is not found or Adapter is not bound");
            return;
        }
        if (com.taobao.weex.utils.WXUtils.getBoolean(getAttrs().get("prefetchGapDisable"), false).booleanValue() && innerView.getLayoutManager() != null) {
            innerView.getLayoutManager().setItemPrefetchEnabled(false);
        }
        if (this.mChildren == null) {
            com.taobao.weex.utils.WXLogUtils.e(this.TAG, "children is null");
        } else {
            this.mDragHelper = new com.taobao.weex.ui.component.list.DefaultDragHelper(this.mChildren, innerView, new com.taobao.weex.ui.component.list.EventTrigger() { // from class: com.taobao.weex.ui.component.list.BasicListComponent.1
                @Override // com.taobao.weex.ui.component.list.EventTrigger
                public void triggerEvent(java.lang.String str, java.util.Map<java.lang.String, java.lang.Object> map) {
                    com.taobao.weex.ui.component.list.BasicListComponent.this.fireEvent(str, map);
                }
            });
            this.mTriggerType = getTriggerType(this);
        }
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    protected com.taobao.weex.ui.component.WXComponent.MeasureOutput measure(int i, int i2) {
        return super.measure(i, i2);
    }

    @Override // io.dcloud.feature.uniapp.ui.component.AbsVContainer, com.taobao.weex.ui.component.WXComponent
    public void destroy() {
        if (this.mAppearChangeRunnable != null && getHostView() != null) {
            getHostView().removeCallbacks(this.mAppearChangeRunnable);
            this.mAppearChangeRunnable = null;
        }
        if (getHostView() != null && getHostView().getInnerView() != null) {
            getHostView().getInnerView().clearOnScrollListeners();
        }
        super.destroy();
        java.util.Map<java.lang.String, java.util.Map<java.lang.String, com.taobao.weex.ui.component.WXComponent>> map = this.mStickyMap;
        if (map != null) {
            map.clear();
        }
        android.util.SparseArray<java.util.ArrayList<com.taobao.weex.ui.component.WXComponent>> sparseArray = this.mViewTypes;
        if (sparseArray != null) {
            sparseArray.clear();
        }
        androidx.collection.ArrayMap<java.lang.String, java.lang.Long> arrayMap = this.mRefToViewType;
        if (arrayMap != null) {
            arrayMap.clear();
        }
    }

    @Override // io.dcloud.feature.uniapp.ui.component.AbsVContainer
    public android.view.ViewGroup.LayoutParams getChildLayoutParams(com.taobao.weex.ui.component.WXComponent wXComponent, android.view.View view, int i, int i2, int i3, int i4, int i5, int i6) {
        android.view.ViewGroup.MarginLayoutParams marginLayoutParams = (android.view.ViewGroup.MarginLayoutParams) view.getLayoutParams();
        if ((wXComponent instanceof com.taobao.weex.ui.component.WXBaseRefresh) && marginLayoutParams == null) {
            return new android.widget.LinearLayout.LayoutParams(i, i2);
        }
        if (marginLayoutParams == null) {
            return new androidx.recyclerview.widget.RecyclerView.LayoutParams(i, i2);
        }
        marginLayoutParams.width = i;
        marginLayoutParams.height = i2;
        setMarginsSupportRTL(marginLayoutParams, i3, 0, i4, 0);
        return marginLayoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXComponent
    public T initComponentHostView(android.content.Context context) {
        T t = (T) generateListView(context, getOrientation());
        java.lang.String attrByKey = getAttrByKey("transform");
        if (attrByKey != null) {
            t.getInnerView().addItemDecoration(com.taobao.weex.ui.component.list.RecyclerTransform.parseTransforms(getOrientation(), attrByKey));
        }
        if (getAttrs().get(com.taobao.weex.common.Constants.Name.KEEP_POSITION_LAYOUT_DELAY) != null) {
            this.keepPositionLayoutDelay = com.taobao.weex.utils.WXUtils.getNumberInt(getAttrs().get(com.taobao.weex.common.Constants.Name.KEEP_POSITION_LAYOUT_DELAY), (int) this.keepPositionLayoutDelay);
        }
        if (getAttrs().get("appearActionDelay") != null) {
            this.mAppearChangeRunnableDelay = com.taobao.weex.utils.WXUtils.getNumberInt(getAttrs().get("appearActionDelay"), (int) this.mAppearChangeRunnableDelay);
        }
        T t2 = t;
        this.mItemAnimator = t2.getInnerView().getItemAnimator();
        com.taobao.weex.ui.view.listview.adapter.RecyclerViewBaseAdapter recyclerViewBaseAdapter = new com.taobao.weex.ui.view.listview.adapter.RecyclerViewBaseAdapter(this);
        recyclerViewBaseAdapter.setHasStableIds(true);
        t2.setRecyclerViewBaseAdapter(recyclerViewBaseAdapter);
        t2.getInnerView().addOnScrollListener(this.mViewOnScrollListener);
        if (getAttrs().get(com.taobao.weex.common.Constants.Name.HAS_FIXED_SIZE) != null) {
            t2.getInnerView().setHasFixedSize(com.taobao.weex.utils.WXUtils.getBoolean(getAttrs().get(com.taobao.weex.common.Constants.Name.HAS_FIXED_SIZE), false).booleanValue());
        }
        t2.getInnerView().addOnScrollListener(new androidx.recyclerview.widget.RecyclerView.OnScrollListener() { // from class: com.taobao.weex.ui.component.list.BasicListComponent.2
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(androidx.recyclerview.widget.RecyclerView recyclerView, int i) {
                int size;
                android.view.View childAt;
                super.onScrollStateChanged(recyclerView, i);
                com.taobao.weex.ui.component.list.BasicListComponent.this.getScrollStartEndHelper().onScrollStateChanged(i);
                java.util.List<com.taobao.weex.common.OnWXScrollListener> wXScrollListeners = com.taobao.weex.ui.component.list.BasicListComponent.this.getInstance().getWXScrollListeners();
                if (wXScrollListeners == null || (size = wXScrollListeners.size()) <= 0) {
                    return;
                }
                for (int i2 = 0; i2 < size && i2 < wXScrollListeners.size(); i2++) {
                    com.taobao.weex.common.OnWXScrollListener onWXScrollListener = wXScrollListeners.get(i2);
                    if (onWXScrollListener != null && (childAt = recyclerView.getChildAt(0)) != null) {
                        onWXScrollListener.onScrollStateChanged(recyclerView, 0, childAt.getTop(), i);
                    }
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(androidx.recyclerview.widget.RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                java.util.List<com.taobao.weex.common.OnWXScrollListener> wXScrollListeners = com.taobao.weex.ui.component.list.BasicListComponent.this.getInstance().getWXScrollListeners();
                if (wXScrollListeners == null || wXScrollListeners.size() <= 0) {
                    return;
                }
                try {
                    for (com.taobao.weex.common.OnWXScrollListener onWXScrollListener : wXScrollListeners) {
                        if (onWXScrollListener != null) {
                            if (onWXScrollListener instanceof com.taobao.weex.common.ICheckBindingScroller) {
                                if (((com.taobao.weex.common.ICheckBindingScroller) onWXScrollListener).isNeedScroller(com.taobao.weex.ui.component.list.BasicListComponent.this.getRef(), null)) {
                                    onWXScrollListener.onScrolled(recyclerView, i, i2);
                                }
                            } else {
                                onWXScrollListener.onScrolled(recyclerView, i, i2);
                            }
                        }
                    }
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
            }
        });
        t.getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.taobao.weex.ui.component.list.BasicListComponent.3
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                android.view.ViewGroup viewGroup = (android.view.ViewGroup) com.taobao.weex.ui.component.list.BasicListComponent.this.getHostView();
                if (viewGroup == 0) {
                    return;
                }
                com.taobao.weex.ui.component.list.BasicListComponent.this.mViewOnScrollListener.onScrolled(((com.taobao.weex.ui.component.list.ListComponentView) viewGroup).getInnerView(), 0, 0);
                viewGroup.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
        return t;
    }

    @Override // com.taobao.weex.ui.component.Scrollable
    public void bindStickStyle(com.taobao.weex.ui.component.WXComponent wXComponent) {
        this.stickyHelper.bindStickStyle(wXComponent, this.mStickyMap);
    }

    @Override // com.taobao.weex.ui.component.Scrollable
    public void unbindStickStyle(com.taobao.weex.ui.component.WXComponent wXComponent) {
        this.stickyHelper.unbindStickStyle(wXComponent, this.mStickyMap);
        com.taobao.weex.ui.component.WXHeader wXHeader = (com.taobao.weex.ui.component.WXHeader) findTypeParent(wXComponent, com.taobao.weex.ui.component.WXHeader.class);
        if (wXHeader == null || getHostView() == null) {
            return;
        }
        getHostView().notifyStickyRemove(wXHeader);
    }

    private com.taobao.weex.ui.component.WXComponent findDirectListChild(com.taobao.weex.ui.component.WXComponent wXComponent) {
        com.taobao.weex.ui.component.WXVContainer parent;
        if (wXComponent == null || (parent = wXComponent.getParent()) == null) {
            return null;
        }
        return parent instanceof com.taobao.weex.ui.component.list.BasicListComponent ? wXComponent : findDirectListChild(parent);
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    protected boolean setProperty(java.lang.String str, java.lang.Object obj) {
        str.hashCode();
        switch (str) {
            case "draggable":
                setDraggable(com.taobao.weex.utils.WXUtils.getBoolean(obj, false).booleanValue());
                return true;
            case "showScrollbar":
                java.lang.Boolean bool = com.taobao.weex.utils.WXUtils.getBoolean(obj, null);
                if (bool != null) {
                    setShowScrollbar(bool.booleanValue());
                }
                return true;
            case "offsetAccuracy":
                setOffsetAccuracy(com.taobao.weex.utils.WXUtils.getInteger(obj, 10).intValue());
            case "loadmoreoffset":
                return true;
            case "scrollable":
                setScrollable(com.taobao.weex.utils.WXUtils.getBoolean(obj, true).booleanValue());
                return true;
            default:
                return super.setProperty(str, obj);
        }
    }

    @com.taobao.weex.ui.component.WXComponentProp(name = com.taobao.weex.common.Constants.Name.SCROLLABLE)
    public void setScrollable(boolean z) {
        this.isScrollable = z;
        com.taobao.weex.ui.view.listview.WXRecyclerView innerView = getHostView().getInnerView();
        if (innerView != null) {
            innerView.setScrollable(z);
        }
    }

    @com.taobao.weex.ui.component.WXComponentProp(name = com.taobao.weex.common.Constants.Name.OFFSET_ACCURACY)
    public void setOffsetAccuracy(int i) {
        this.mOffsetAccuracy = (int) com.taobao.weex.utils.WXViewUtils.getRealPxByWidth(i, getInstance().getInstanceViewPortWidthWithFloat());
    }

    @com.taobao.weex.ui.component.WXComponentProp(name = com.taobao.weex.common.Constants.Name.DRAGGABLE)
    public void setDraggable(boolean z) {
        com.taobao.weex.ui.component.list.DragHelper dragHelper = this.mDragHelper;
        if (dragHelper != null) {
            dragHelper.setDraggable(z);
        }
        if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
            com.taobao.weex.utils.WXLogUtils.d("set draggable : " + z);
        }
    }

    @com.taobao.weex.ui.component.WXComponentProp(name = com.taobao.weex.common.Constants.Name.SHOW_SCROLLBAR)
    public void setShowScrollbar(boolean z) {
        if (getHostView() == null || getHostView().getInnerView() == null) {
            return;
        }
        if (getOrientation() == 1) {
            getHostView().getInnerView().setVerticalScrollBarEnabled(z);
        } else {
            getHostView().getInnerView().setHorizontalScrollBarEnabled(z);
        }
    }

    @Override // com.taobao.weex.ui.component.Scrollable
    public boolean isScrollable() {
        return this.isScrollable;
    }

    private void setAppearanceWatch(com.taobao.weex.ui.component.WXComponent wXComponent, int i, boolean z) {
        com.taobao.weex.ui.component.AppearanceHelper appearanceHelper = this.mAppearComponents.get(wXComponent.getRef());
        if (appearanceHelper != null) {
            appearanceHelper.setWatchEvent(i, z);
            return;
        }
        if (z) {
            int iIndexOf = this.mChildren.indexOf(findDirectListChild(wXComponent));
            if (iIndexOf != -1) {
                com.taobao.weex.ui.component.AppearanceHelper appearanceHelper2 = new com.taobao.weex.ui.component.AppearanceHelper(wXComponent, iIndexOf);
                appearanceHelper2.setWatchEvent(i, true);
                this.mAppearComponents.put(wXComponent.getRef(), appearanceHelper2);
            }
        }
    }

    @Override // com.taobao.weex.ui.component.Scrollable
    public void bindAppearEvent(com.taobao.weex.ui.component.WXComponent wXComponent) {
        setAppearanceWatch(wXComponent, 0, true);
        if (this.mAppearChangeRunnable == null) {
            this.mAppearChangeRunnable = new java.lang.Runnable() { // from class: com.taobao.weex.ui.component.list.BasicListComponent.4
                @Override // java.lang.Runnable
                public void run() {
                    if (com.taobao.weex.ui.component.list.BasicListComponent.this.mAppearChangeRunnable != null) {
                        com.taobao.weex.ui.component.list.BasicListComponent.this.notifyAppearStateChange(0, 0, 0, 0);
                    }
                }
            };
        }
        if (getHostView() != null) {
            getHostView().removeCallbacks(this.mAppearChangeRunnable);
            getHostView().postDelayed(this.mAppearChangeRunnable, this.mAppearChangeRunnableDelay);
        }
    }

    @Override // com.taobao.weex.ui.component.Scrollable
    public void bindDisappearEvent(com.taobao.weex.ui.component.WXComponent wXComponent) {
        setAppearanceWatch(wXComponent, 1, true);
    }

    @Override // com.taobao.weex.ui.component.Scrollable
    public void unbindAppearEvent(com.taobao.weex.ui.component.WXComponent wXComponent) {
        setAppearanceWatch(wXComponent, 0, false);
    }

    @Override // com.taobao.weex.ui.component.Scrollable
    public void unbindDisappearEvent(com.taobao.weex.ui.component.WXComponent wXComponent) {
        setAppearanceWatch(wXComponent, 1, false);
    }

    @Override // com.taobao.weex.ui.component.Scrollable
    public void scrollTo(com.taobao.weex.ui.component.WXComponent wXComponent, java.util.Map<java.lang.String, java.lang.Object> map) {
        com.taobao.weex.ui.component.list.WXCell wXCell;
        int iIndexOf;
        float realPxByWidth = 0.0f;
        boolean zBooleanValue = true;
        if (map != null) {
            java.lang.String string = map.get("offset") == null ? com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT : map.get("offset").toString();
            zBooleanValue = com.taobao.weex.utils.WXUtils.getBoolean(map.get(com.taobao.weex.common.Constants.Name.ANIMATED), true).booleanValue();
            if (string != null) {
                try {
                    realPxByWidth = com.taobao.weex.utils.WXViewUtils.getRealPxByWidth(java.lang.Float.parseFloat(string), getInstance().getInstanceViewPortWidthWithFloat());
                } catch (java.lang.Exception e) {
                    com.taobao.weex.utils.WXLogUtils.e("Float parseFloat error :" + e.getMessage());
                }
            }
        }
        int i = (int) realPxByWidth;
        T hostView = getHostView();
        if (hostView == null) {
            return;
        }
        while (true) {
            if (wXComponent == null) {
                wXCell = null;
                break;
            } else {
                if (wXComponent instanceof com.taobao.weex.ui.component.list.WXCell) {
                    wXCell = (com.taobao.weex.ui.component.list.WXCell) wXComponent;
                    break;
                }
                wXComponent = wXComponent.getParent();
            }
        }
        if (wXCell == null || (iIndexOf = this.mChildren.indexOf(wXCell)) == -1) {
            return;
        }
        hostView.getInnerView().scrollTo(zBooleanValue, iIndexOf, i, getOrientation());
    }

    /* JADX WARN: Code duplicated, block: B:35:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:52:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:58:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:61:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:65:0x0107  */
    /* JADX WARN: Code duplicated, block: B:67:0x010a  */
    /* JADX WARN: Code duplicated, block: B:68:0x0111  */
    /* JADX WARN: Code duplicated, block: B:69:0x0113 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:70:0x0115  */
    @Override // com.taobao.weex.ui.view.listview.adapter.IOnLoadMoreListener
    public void onBeforeScroll(int i, int i2) {
        java.util.Map<java.lang.String, com.taobao.weex.ui.component.WXComponent> map;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        T hostView = getHostView();
        java.util.Map<java.lang.String, java.util.Map<java.lang.String, com.taobao.weex.ui.component.WXComponent>> map2 = this.mStickyMap;
        if (map2 == null || hostView == null || (map = map2.get(getRef())) == null) {
            return;
        }
        java.util.Iterator<java.util.Map.Entry<java.lang.String, com.taobao.weex.ui.component.WXComponent>> it = map.entrySet().iterator();
        int i3 = -1;
        while (it.hasNext()) {
            com.taobao.weex.ui.component.WXComponent value = it.next().getValue();
            if (value != null && (value instanceof com.taobao.weex.ui.component.list.WXCell)) {
                com.taobao.weex.ui.component.list.WXCell wXCell = (com.taobao.weex.ui.component.list.WXCell) value;
                if (wXCell.getHostView() == 0) {
                    return;
                }
                int[] iArr = new int[2];
                value.getHostView().getLocationOnScreen(iArr);
                int[] iArr2 = new int[2];
                value.getParentScroller().getView().getLocationOnScreen(iArr2);
                int i4 = iArr[1] - iArr2[1];
                androidx.recyclerview.widget.RecyclerView.LayoutManager layoutManager = getHostView().getInnerView().getLayoutManager();
                if ((layoutManager instanceof androidx.recyclerview.widget.LinearLayoutManager) || (layoutManager instanceof androidx.recyclerview.widget.GridLayoutManager)) {
                    androidx.recyclerview.widget.LinearLayoutManager linearLayoutManager = (androidx.recyclerview.widget.LinearLayoutManager) layoutManager;
                    int iFindFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
                    int iFindLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
                    int iIndexOf = this.mChildren.indexOf(wXCell);
                    wXCell.setScrollPositon(iIndexOf);
                    if (iIndexOf <= iFindFirstVisibleItemPosition || (wXCell.getStickyOffset() > 0 && iFindFirstVisibleItemPosition < iIndexOf && iIndexOf <= iFindLastVisibleItemPosition && i4 <= wXCell.getStickyOffset())) {
                        if (iIndexOf > i3) {
                            i3 = iIndexOf;
                        }
                        z = true;
                        z2 = false;
                    } else {
                        z = false;
                        z2 = true;
                    }
                    if (z || wXCell.getLocationFromStart() < 0 || i4 > wXCell.getStickyOffset() || i2 < 0) {
                        z3 = false;
                    } else {
                        z3 = true;
                    }
                    z4 = wXCell.getLocationFromStart() > wXCell.getStickyOffset() && i4 > wXCell.getStickyOffset() && i2 <= 0;
                    if (z3) {
                        hostView.notifyStickyShow(wXCell);
                    } else if (!z4 || z2) {
                        hostView.notifyStickyRemove(wXCell);
                    }
                    wXCell.setLocationFromStart(i4);
                } else {
                    if (layoutManager instanceof androidx.recyclerview.widget.StaggeredGridLayoutManager) {
                        int[] iArr3 = new int[3];
                        androidx.recyclerview.widget.StaggeredGridLayoutManager staggeredGridLayoutManager = (androidx.recyclerview.widget.StaggeredGridLayoutManager) layoutManager;
                        int i5 = staggeredGridLayoutManager.findFirstVisibleItemPositions(iArr3)[0];
                        int i6 = staggeredGridLayoutManager.findLastVisibleItemPositions(iArr3)[0];
                        int iIndexOf2 = this.mChildren.indexOf(wXCell);
                        if (iIndexOf2 <= i5 || (wXCell.getStickyOffset() > 0 && i5 < iIndexOf2 && iIndexOf2 <= i6 && i4 <= wXCell.getStickyOffset())) {
                            if (iIndexOf2 > i3) {
                                i3 = iIndexOf2;
                            }
                            z = true;
                        } else {
                            z = false;
                            z2 = true;
                        }
                        if (z) {
                            z3 = false;
                        } else {
                            z3 = false;
                        }
                        if (wXCell.getLocationFromStart() > wXCell.getStickyOffset()) {
                        }
                        if (z3) {
                            hostView.notifyStickyShow(wXCell);
                        } else if (!z4) {
                            hostView.notifyStickyRemove(wXCell);
                        } else {
                            hostView.notifyStickyRemove(wXCell);
                        }
                        wXCell.setLocationFromStart(i4);
                    } else {
                        z = false;
                    }
                    z2 = false;
                    if (z) {
                        z3 = false;
                    } else {
                        z3 = false;
                    }
                    if (wXCell.getLocationFromStart() > wXCell.getStickyOffset()) {
                    }
                    if (z3) {
                        hostView.notifyStickyShow(wXCell);
                    } else if (!z4) {
                        hostView.notifyStickyRemove(wXCell);
                    } else {
                        hostView.notifyStickyRemove(wXCell);
                    }
                    wXCell.setLocationFromStart(i4);
                }
            }
        }
        if (i3 >= 0) {
            hostView.updateStickyView(i3);
        } else if (hostView instanceof com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView) {
            ((com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView) hostView).getStickyHeaderHelper().clearStickyHeaders();
        }
    }

    @Override // com.taobao.weex.ui.component.Scrollable
    public int getScrollY() {
        T hostView = getHostView();
        if (hostView == null) {
            return 0;
        }
        return hostView.getInnerView().getScrollY();
    }

    @Override // com.taobao.weex.ui.component.Scrollable
    public int getScrollX() {
        T hostView = getHostView();
        if (hostView == null) {
            return 0;
        }
        return hostView.getInnerView().getScrollX();
    }

    @Override // io.dcloud.feature.uniapp.ui.component.AbsVContainer
    public void addChild(com.taobao.weex.ui.component.WXComponent wXComponent) {
        addChild(wXComponent, -1);
    }

    @Override // io.dcloud.feature.uniapp.ui.component.AbsVContainer
    public void addChild(com.taobao.weex.ui.component.WXComponent wXComponent, int i) {
        boolean z;
        super.addChild(wXComponent, i);
        if (wXComponent == null || i < -1) {
            return;
        }
        if (i >= this.mChildren.size()) {
            i = -1;
        }
        bindViewType(wXComponent);
        boolean z2 = false;
        if (this.isThisGroupFinished || !isRenderFromBottom()) {
            z = false;
        } else if (!wXComponent.getAttrs().containsKey("renderReversePosition")) {
            return;
        } else {
            z = true;
        }
        this.isThisGroupFinished = true;
        int size = i == -1 ? this.mChildren.size() - 1 : i;
        final T hostView = getHostView();
        if (hostView != null) {
            if (getBasicComponentData() != null && "default".equals(getAttrs().get(com.taobao.weex.common.Constants.Name.INSERT_CELL_ANIMATION))) {
                hostView.getInnerView().setItemAnimator(this.mItemAnimator);
            } else {
                hostView.getInnerView().setItemAnimator(null);
            }
            if (wXComponent.getBasicComponentData() != null && com.taobao.weex.utils.WXUtils.getBoolean(wXComponent.getAttrs().get(com.taobao.weex.common.Constants.Name.KEEP_SCROLL_POSITION), false).booleanValue() && i <= getChildCount() && i > -1) {
                z2 = true;
            }
            if (!z2 && z) {
                z2 = true;
            }
            if (z2) {
                T t = hostView;
                if (t.getInnerView().getLayoutManager() instanceof androidx.recyclerview.widget.LinearLayoutManager) {
                    if (this.keepPositionCell == null) {
                        com.taobao.weex.ui.view.listview.adapter.ListBaseViewHolder listBaseViewHolder = (com.taobao.weex.ui.view.listview.adapter.ListBaseViewHolder) t.getInnerView().findViewHolderForAdapterPosition(((androidx.recyclerview.widget.LinearLayoutManager) t.getInnerView().getLayoutManager()).findLastCompletelyVisibleItemPosition());
                        if (listBaseViewHolder != null) {
                            this.keepPositionCell = listBaseViewHolder.getComponent();
                        }
                        if (this.keepPositionCell != null) {
                            if (!t.getInnerView().isLayoutFrozen()) {
                                t.getInnerView().setLayoutFrozen(true);
                            }
                            java.lang.Runnable runnable = this.keepPositionCellRunnable;
                            if (runnable != null) {
                                hostView.removeCallbacks(runnable);
                            }
                            this.keepPositionCellRunnable = new java.lang.Runnable() { // from class: com.taobao.weex.ui.component.list.BasicListComponent.5
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (com.taobao.weex.ui.component.list.BasicListComponent.this.keepPositionCell != null) {
                                        com.taobao.weex.ui.component.list.BasicListComponent basicListComponent = com.taobao.weex.ui.component.list.BasicListComponent.this;
                                        int iIndexOf = basicListComponent.indexOf(basicListComponent.keepPositionCell);
                                        int top = com.taobao.weex.ui.component.list.BasicListComponent.this.keepPositionCell.getHostView() != null ? com.taobao.weex.ui.component.list.BasicListComponent.this.keepPositionCell.getHostView().getTop() : 0;
                                        if (top > 0) {
                                            ((androidx.recyclerview.widget.LinearLayoutManager) ((com.taobao.weex.ui.component.list.ListComponentView) hostView).getInnerView().getLayoutManager()).scrollToPositionWithOffset(iIndexOf, top);
                                        } else {
                                            ((com.taobao.weex.ui.component.list.ListComponentView) hostView).getInnerView().getLayoutManager().scrollToPosition(iIndexOf);
                                        }
                                        ((com.taobao.weex.ui.component.list.ListComponentView) hostView).getInnerView().setLayoutFrozen(false);
                                        com.taobao.weex.ui.component.list.BasicListComponent.this.keepPositionCell = null;
                                        com.taobao.weex.ui.component.list.BasicListComponent.this.keepPositionCellRunnable = null;
                                    }
                                }
                            };
                        }
                    }
                    if (this.keepPositionCellRunnable == null) {
                        int iFindLastVisibleItemPosition = ((androidx.recyclerview.widget.LinearLayoutManager) t.getInnerView().getLayoutManager()).findLastVisibleItemPosition();
                        if (!z) {
                            i = iFindLastVisibleItemPosition;
                        }
                        t.getInnerView().scrollToPosition(i);
                    }
                }
                t.getRecyclerViewBaseAdapter().notifyItemRangeInserted(size, 20);
                java.lang.Runnable runnable2 = this.keepPositionCellRunnable;
                if (runnable2 != null) {
                    hostView.removeCallbacks(runnable2);
                    hostView.postDelayed(this.keepPositionCellRunnable, this.keepPositionLayoutDelay);
                }
            } else {
                hostView.getRecyclerViewBaseAdapter().notifyDataSetChanged();
            }
        }
        relocateAppearanceHelper();
    }

    private void relocateAppearanceHelper() {
        java.util.Iterator<java.util.Map.Entry<java.lang.String, com.taobao.weex.ui.component.AppearanceHelper>> it = this.mAppearComponents.entrySet().iterator();
        while (it.hasNext()) {
            com.taobao.weex.ui.component.AppearanceHelper value = it.next().getValue();
            value.setCellPosition(this.mChildren.indexOf(findDirectListChild(value.getAwareChild())));
        }
    }

    @Override // io.dcloud.feature.uniapp.ui.component.AbsVContainer
    public void remove(com.taobao.weex.ui.component.WXComponent wXComponent, boolean z) {
        int iIndexOf = this.mChildren.indexOf(wXComponent);
        if (z) {
            wXComponent.detachViewAndClearPreInfo();
        }
        unBindViewType(wXComponent);
        T hostView = getHostView();
        if (hostView == null) {
            return;
        }
        if ("default".equals(wXComponent.getAttrs().get(com.taobao.weex.common.Constants.Name.DELETE_CELL_ANIMATION))) {
            hostView.getInnerView().setItemAnimator(this.mItemAnimator);
        } else {
            hostView.getInnerView().setItemAnimator(null);
        }
        hostView.getRecyclerViewBaseAdapter().notifyItemRemoved(iIndexOf);
        if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
            com.taobao.weex.utils.WXLogUtils.d(this.TAG, "removeChild child at " + iIndexOf);
        }
        super.remove(wXComponent, z);
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void computeVisiblePointInViewCoordinate(android.graphics.PointF pointF) {
        com.taobao.weex.ui.view.listview.WXRecyclerView innerView = getHostView().getInnerView();
        pointF.set(innerView.computeHorizontalScrollOffset(), innerView.computeVerticalScrollOffset());
    }

    @Override // com.taobao.weex.ui.view.listview.adapter.IRecyclerAdapterListener
    public void onViewRecycled(com.taobao.weex.ui.view.listview.adapter.ListBaseViewHolder listBaseViewHolder) {
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        listBaseViewHolder.setComponentUsing(false);
        if (listBaseViewHolder != null && listBaseViewHolder.canRecycled() && listBaseViewHolder.getComponent() != null && !listBaseViewHolder.getComponent().isUsing()) {
            listBaseViewHolder.recycled();
        } else {
            com.taobao.weex.utils.WXLogUtils.w(this.TAG, "this holder can not be allowed to  recycled");
        }
        if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
            com.taobao.weex.utils.WXLogUtils.d(this.TAG, "Recycle holder " + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis) + "  Thread:" + java.lang.Thread.currentThread().getName());
        }
    }

    @Override // com.taobao.weex.ui.view.listview.adapter.IRecyclerAdapterListener
    public void onBindViewHolder(final com.taobao.weex.ui.view.listview.adapter.ListBaseViewHolder listBaseViewHolder, int i) {
        int color;
        if (listBaseViewHolder == null) {
            return;
        }
        listBaseViewHolder.setComponentUsing(true);
        com.taobao.weex.common.IWXObject listChild = getListChild(i);
        if (listChild instanceof com.taobao.weex.ui.component.list.ListStanceCell) {
            listBaseViewHolder.getView().setBackgroundColor(com.taobao.weex.utils.WXResourceUtils.getColor(((com.taobao.weex.ui.component.list.ListStanceCell) listChild).getBackgroundColor(), -1));
            listBaseViewHolder.getView().setVisibility(0);
            listBaseViewHolder.getView().postInvalidate();
            return;
        }
        if (listChild instanceof com.taobao.weex.ui.component.WXComponent) {
            com.taobao.weex.ui.component.WXComponent wXComponent = (com.taobao.weex.ui.component.WXComponent) listChild;
            if (wXComponent == null || (wXComponent instanceof com.taobao.weex.ui.component.WXRefresh) || (wXComponent instanceof com.taobao.weex.ui.component.WXLoading) || wXComponent.isFixed()) {
                if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
                    com.taobao.weex.utils.WXLogUtils.d(this.TAG, "Bind WXRefresh & WXLoading " + listBaseViewHolder);
                }
                if (!(wXComponent instanceof com.taobao.weex.ui.component.WXBaseRefresh) || listBaseViewHolder.getView() == null) {
                    return;
                }
                if (wXComponent.getAttrs().get("holderBackground") != null || wXComponent.getStyles().containsKey("backgroundColor")) {
                    java.lang.Object obj = wXComponent.getAttrs().get("holderBackground");
                    if (obj != null) {
                        color = com.taobao.weex.utils.WXResourceUtils.getColor(obj.toString(), -1);
                    } else {
                        color = com.taobao.weex.utils.WXResourceUtils.getColor(wXComponent.getStyles().getBackgroundColor(), -1);
                    }
                    listBaseViewHolder.getView().setBackgroundColor(color);
                    listBaseViewHolder.getView().setVisibility(0);
                    listBaseViewHolder.getView().postInvalidate();
                    return;
                }
                return;
            }
            if (listBaseViewHolder.getComponent() == null || !(listBaseViewHolder.getComponent() instanceof com.taobao.weex.ui.component.list.WXCell)) {
                return;
            }
            if (listBaseViewHolder.isRecycled()) {
                listBaseViewHolder.bindData(wXComponent);
                wXComponent.onRenderFinish(1);
            }
            com.taobao.weex.ui.component.list.DragHelper dragHelper = this.mDragHelper;
            if (dragHelper == null || !dragHelper.isDraggable()) {
                return;
            }
            java.lang.String str = this.mTriggerType;
            if (str == null) {
                str = "longpress";
            }
            this.mTriggerType = str;
            com.taobao.weex.ui.component.list.WXCell wXCell = (com.taobao.weex.ui.component.list.WXCell) listBaseViewHolder.getComponent();
            boolean zBooleanValue = com.taobao.weex.utils.WXUtils.getBoolean(wXCell.getAttrs().get(EXCLUDED), false).booleanValue();
            this.mDragHelper.setDragExcluded(listBaseViewHolder, zBooleanValue);
            if ("pan".equals(this.mTriggerType)) {
                this.mDragHelper.setLongPressDragEnabled(false);
                com.taobao.weex.ui.component.WXComponent wXComponentFindComponentByAnchorName = findComponentByAnchorName(wXCell, DRAG_ANCHOR);
                if (wXComponentFindComponentByAnchorName != null && wXComponentFindComponentByAnchorName.getHostView() != null && !zBooleanValue) {
                    wXComponentFindComponentByAnchorName.getHostView().setOnTouchListener(new android.view.View.OnTouchListener() { // from class: com.taobao.weex.ui.component.list.BasicListComponent.6
                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
                            if (androidx.core.view.MotionEventCompat.getActionMasked(motionEvent) != 0) {
                                return true;
                            }
                            com.taobao.weex.ui.component.list.BasicListComponent.this.mDragHelper.startDrag(listBaseViewHolder);
                            return true;
                        }
                    });
                    return;
                }
                if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
                    if (!zBooleanValue) {
                        com.taobao.weex.utils.WXLogUtils.e(this.TAG, "[error] onBindViewHolder: the anchor component or view is not found");
                        return;
                    }
                    com.taobao.weex.utils.WXLogUtils.d(this.TAG, "onBindViewHolder: position " + i + " is drag excluded");
                    return;
                }
                return;
            }
            if ("longpress".equals(this.mTriggerType)) {
                this.mDragHelper.setLongPressDragEnabled(true);
            }
        }
    }

    protected void markComponentUsable() {
        java.util.Iterator<com.taobao.weex.ui.component.WXComponent> it = this.mChildren.iterator();
        while (it.hasNext()) {
            it.next().setUsing(false);
        }
    }

    @Override // com.taobao.weex.ui.view.listview.adapter.IRecyclerAdapterListener
    public com.taobao.weex.ui.view.listview.adapter.ListBaseViewHolder onCreateViewHolder(android.view.ViewGroup viewGroup, int i) {
        if (i == -1) {
            return createVHForRefreshComponent(i);
        }
        if (this.mChildren != null) {
            android.util.SparseArray<java.util.ArrayList<com.taobao.weex.ui.component.WXComponent>> sparseArray = this.mViewTypes;
            if (sparseArray == null) {
                return createVHForFakeComponent(i);
            }
            java.util.ArrayList<com.taobao.weex.ui.component.WXComponent> arrayList = sparseArray.get(i);
            checkRecycledViewPool(i);
            if (arrayList == null) {
                return createVHForFakeComponent(i);
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                com.taobao.weex.ui.component.WXComponent wXComponent = arrayList.get(i2);
                if (wXComponent != null && !wXComponent.isUsing()) {
                    if (wXComponent.isFixed()) {
                        return createVHForFakeComponent(i);
                    }
                    if (wXComponent instanceof com.taobao.weex.ui.component.list.WXCell) {
                        if (wXComponent.getRealView() != null) {
                            return new com.taobao.weex.ui.view.listview.adapter.ListBaseViewHolder(wXComponent, i);
                        }
                        wXComponent.lazy(false);
                        wXComponent.createView();
                        wXComponent.applyLayoutAndEvent(wXComponent);
                        return new com.taobao.weex.ui.view.listview.adapter.ListBaseViewHolder(wXComponent, i, true);
                    }
                    if (wXComponent instanceof com.taobao.weex.ui.component.WXBaseRefresh) {
                        return createVHForRefreshComponent(i);
                    }
                    com.taobao.weex.utils.WXLogUtils.e(this.TAG, "List cannot include element except cell、header、fixed、refresh and loading");
                    return createVHForFakeComponent(i);
                }
            }
        }
        if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
            com.taobao.weex.utils.WXLogUtils.e(this.TAG, "Cannot find request viewType: " + i);
        }
        return createVHForFakeComponent(i);
    }

    private void checkRecycledViewPool(int i) {
        try {
            if (this.mViewTypes.size() > 9) {
                mAllowCacheViewHolder = false;
            }
            if (mDownForBidCacheViewHolder && getHostView() != null && getHostView().getInnerView() != null) {
                getHostView().getInnerView().getRecycledViewPool().setMaxRecycledViews(i, 0);
            }
            if (mDownForBidCacheViewHolder || mAllowCacheViewHolder || getHostView() == null || getHostView().getInnerView() == null) {
                return;
            }
            for (int i2 = 0; i2 < this.mViewTypes.size(); i2++) {
                getHostView().getInnerView().getRecycledViewPool().setMaxRecycledViews(this.mViewTypes.keyAt(i2), 0);
            }
            mDownForBidCacheViewHolder = true;
        } catch (java.lang.Exception unused) {
            com.taobao.weex.utils.WXLogUtils.e(this.TAG, "Clear recycledViewPool error!");
        }
    }

    @Override // com.taobao.weex.ui.view.listview.adapter.IRecyclerAdapterListener
    public int getItemViewType(int i) {
        return generateViewType(getListChild(i));
    }

    private com.taobao.weex.ui.component.WXComponent findComponentByAnchorName(com.taobao.weex.ui.component.WXComponent wXComponent, java.lang.String str) {
        java.lang.String string;
        long jCurrentTimeMillis = com.taobao.weex.WXEnvironment.isApkDebugable() ? java.lang.System.currentTimeMillis() : 0L;
        java.util.ArrayDeque arrayDeque = new java.util.ArrayDeque();
        arrayDeque.add(wXComponent);
        while (!arrayDeque.isEmpty()) {
            com.taobao.weex.ui.component.WXComponent wXComponent2 = (com.taobao.weex.ui.component.WXComponent) arrayDeque.removeFirst();
            if (wXComponent2 != null && (string = com.taobao.weex.utils.WXUtils.getString(wXComponent2.getAttrs().get(str), null)) != null && string.equals(io.dcloud.common.constant.AbsoluteConst.TRUE)) {
                if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
                    com.taobao.weex.utils.WXLogUtils.d("dragPerf", "findComponentByAnchorName time: " + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis) + "ms");
                }
                return wXComponent2;
            }
            if (wXComponent2 instanceof com.taobao.weex.ui.component.WXVContainer) {
                com.taobao.weex.ui.component.WXVContainer wXVContainer = (com.taobao.weex.ui.component.WXVContainer) wXComponent2;
                int iChildCount = wXVContainer.childCount();
                for (int i = 0; i < iChildCount; i++) {
                    arrayDeque.add(wXVContainer.getChild(i));
                }
            }
        }
        if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
            com.taobao.weex.utils.WXLogUtils.d("dragPerf", "findComponentByAnchorName elapsed time: " + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis) + "ms");
        }
        return null;
    }

    private java.lang.String getTriggerType(com.taobao.weex.ui.component.WXComponent wXComponent) {
        if (wXComponent == null) {
            return "longpress";
        }
        java.lang.String string = com.taobao.weex.utils.WXUtils.getString(wXComponent.getAttrs().get(DRAG_TRIGGER_TYPE), "longpress");
        java.lang.String str = ("longpress".equals(string) || "pan".equals(string)) ? string : "longpress";
        if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
            com.taobao.weex.utils.WXLogUtils.d(this.TAG, "trigger type is " + str);
        }
        return str;
    }

    private void bindViewType(com.taobao.weex.ui.component.WXComponent wXComponent) {
        int iGenerateViewType = generateViewType(wXComponent);
        if (this.mViewTypes == null) {
            this.mViewTypes = new android.util.SparseArray<>();
        }
        java.util.ArrayList<com.taobao.weex.ui.component.WXComponent> arrayList = this.mViewTypes.get(iGenerateViewType);
        if (arrayList == null) {
            arrayList = new java.util.ArrayList<>();
            this.mViewTypes.put(iGenerateViewType, arrayList);
        }
        arrayList.add(wXComponent);
    }

    private void unBindViewType(com.taobao.weex.ui.component.WXComponent wXComponent) {
        java.util.ArrayList<com.taobao.weex.ui.component.WXComponent> arrayList;
        int iGenerateViewType = generateViewType(wXComponent);
        android.util.SparseArray<java.util.ArrayList<com.taobao.weex.ui.component.WXComponent>> sparseArray = this.mViewTypes;
        if (sparseArray == null || (arrayList = sparseArray.get(iGenerateViewType)) == null) {
            return;
        }
        arrayList.remove(wXComponent);
    }

    private int generateViewType(com.taobao.weex.common.IWXObject iWXObject) {
        long jLongValue = -1;
        try {
            if (!(iWXObject instanceof com.taobao.weex.ui.component.list.ListStanceCell) && (iWXObject instanceof com.taobao.weex.ui.component.WXComponent)) {
                com.taobao.weex.ui.component.WXComponent wXComponent = (com.taobao.weex.ui.component.WXComponent) iWXObject;
                long j = java.lang.Integer.parseInt(wXComponent.getRef());
                java.lang.String scope = wXComponent.getAttrs().getScope();
                if (android.text.TextUtils.isEmpty(scope)) {
                    jLongValue = j;
                } else {
                    if (this.mRefToViewType == null) {
                        this.mRefToViewType = new androidx.collection.ArrayMap<>();
                    }
                    if (!this.mRefToViewType.containsKey(scope)) {
                        this.mRefToViewType.put(scope, java.lang.Long.valueOf(j));
                    }
                    jLongValue = this.mRefToViewType.get(scope).longValue();
                }
            }
        } catch (java.lang.RuntimeException e) {
            com.taobao.weex.utils.WXLogUtils.eTag(this.TAG, e);
            com.taobao.weex.utils.WXLogUtils.e(this.TAG, "getItemViewType: NO ID, this will crash the whole render system of WXListRecyclerView");
        }
        return (int) jLongValue;
    }

    @Override // com.taobao.weex.ui.view.listview.adapter.IRecyclerAdapterListener
    public int getItemCount() {
        if (this.isThisGroupFinished) {
            return getChildCount();
        }
        return 0;
    }

    @Override // com.taobao.weex.ui.view.listview.adapter.IRecyclerAdapterListener
    public boolean onFailedToRecycleView(com.taobao.weex.ui.view.listview.adapter.ListBaseViewHolder listBaseViewHolder) {
        if (!com.taobao.weex.WXEnvironment.isApkDebugable()) {
            return false;
        }
        com.taobao.weex.utils.WXLogUtils.d(this.TAG, "Failed to recycle " + listBaseViewHolder);
        return false;
    }

    @Override // com.taobao.weex.ui.view.listview.adapter.IRecyclerAdapterListener
    public long getItemId(int i) {
        try {
            com.taobao.weex.common.IWXObject listChild = getListChild(i);
            if (!(listChild instanceof com.taobao.weex.ui.component.list.ListStanceCell) && (listChild instanceof com.taobao.weex.ui.component.WXComponent)) {
                return java.lang.Long.parseLong(((com.taobao.weex.ui.component.WXComponent) listChild).getRef());
            }
            return -1L;
        } catch (java.lang.RuntimeException e) {
            com.taobao.weex.utils.WXLogUtils.e(this.TAG, com.taobao.weex.utils.WXLogUtils.getStackTrace(e));
            return -1L;
        }
    }

    @Override // com.taobao.weex.ui.view.listview.adapter.IOnLoadMoreListener
    public void onLoadMore(int i) {
        try {
            java.lang.String loadMoreOffset = getAttrs().getLoadMoreOffset();
            if (android.text.TextUtils.isEmpty(loadMoreOffset)) {
                loadMoreOffset = com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT;
            }
            if (i > com.taobao.weex.utils.WXViewUtils.getRealPxByWidth(com.taobao.weex.utils.WXUtils.getInt(loadMoreOffset), getInstance().getInstanceViewPortWidthWithFloat()) || !getEvents().contains(com.taobao.weex.common.Constants.Event.LOADMORE)) {
                return;
            }
            if (this.mListCellCount != this.mChildren.size() || this.mForceLoadmoreNextTime) {
                fireEvent(com.taobao.weex.common.Constants.Event.LOADMORE);
                this.mListCellCount = this.mChildren.size();
                this.mForceLoadmoreNextTime = false;
            }
        } catch (java.lang.Exception e) {
            com.taobao.weex.utils.WXLogUtils.d(this.TAG + "onLoadMore :", e);
        }
    }

    @Override // com.taobao.weex.ui.view.listview.adapter.IOnLoadMoreListener
    public void notifyAppearStateChange(int i, int i2, int i3, int i4) {
        android.view.View hostView;
        java.lang.String str = null;
        if (this.mAppearChangeRunnable != null) {
            getHostView().removeCallbacks(this.mAppearChangeRunnable);
            this.mAppearChangeRunnable = null;
        }
        if (i4 > 0) {
            str = "up";
        } else if (i4 < 0) {
            str = "down";
        }
        if (getOrientation() == 0 && i3 != 0) {
            str = i3 > 0 ? "left" : "right";
        }
        for (com.taobao.weex.ui.component.AppearanceHelper appearanceHelper : this.mAppearComponents.values()) {
            com.taobao.weex.ui.component.WXComponent awareChild = appearanceHelper.getAwareChild();
            if (appearanceHelper.isWatch() && (hostView = awareChild.getHostView()) != null) {
                int appearStatus = appearanceHelper.setAppearStatus(androidx.core.view.ViewCompat.isAttachedToWindow(hostView) && appearanceHelper.isViewVisible(true));
                if (appearStatus != 0) {
                    boolean zIsApkDebugable = com.taobao.weex.WXEnvironment.isApkDebugable();
                    java.lang.String str2 = com.taobao.weex.common.Constants.Event.APPEAR;
                    if (zIsApkDebugable) {
                        com.taobao.weex.utils.WXLogUtils.d(com.taobao.weex.common.Constants.Event.APPEAR, "item " + appearanceHelper.getCellPositionINScollable() + " result " + appearStatus);
                    }
                    if (appearStatus != 1) {
                        str2 = com.taobao.weex.common.Constants.Event.DISAPPEAR;
                    }
                    awareChild.notifyAppearStateChange(str2, str);
                }
            }
        }
    }

    private com.taobao.weex.ui.view.listview.adapter.ListBaseViewHolder createVHForFakeComponent(int i) {
        android.widget.FrameLayout frameLayout = new android.widget.FrameLayout(getContext());
        frameLayout.setBackgroundColor(-1);
        frameLayout.setLayoutParams(new android.widget.FrameLayout.LayoutParams(0, 0));
        return new com.taobao.weex.ui.view.listview.adapter.ListBaseViewHolder(frameLayout, i);
    }

    private com.taobao.weex.ui.view.listview.adapter.ListBaseViewHolder createVHForRefreshComponent(int i) {
        android.widget.FrameLayout frameLayout = new android.widget.FrameLayout(getContext());
        frameLayout.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, 1));
        return new com.taobao.weex.ui.view.listview.adapter.ListBaseViewHolder(frameLayout, i);
    }

    @com.taobao.weex.annotation.JSMethod
    public void resetLoadmore() {
        this.mForceLoadmoreNextTime = true;
        this.mListCellCount = 0;
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void addEvent(java.lang.String str) {
        super.addEvent(str);
        if (!com.taobao.weex.ui.component.helper.ScrollStartEndHelper.isScrollEvent(str) || getHostView() == null || getHostView().getInnerView() == null || this.mHasAddScrollEvent) {
            return;
        }
        this.mHasAddScrollEvent = true;
        getHostView().getInnerView().addOnScrollListener(new androidx.recyclerview.widget.RecyclerView.OnScrollListener() { // from class: com.taobao.weex.ui.component.list.BasicListComponent.7
            private boolean mFirstEvent = true;
            private int offsetXCorrection;
            private int offsetYCorrection;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(androidx.recyclerview.widget.RecyclerView recyclerView, int i, int i2) {
                int i3;
                int i4;
                super.onScrolled(recyclerView, i, i2);
                int iComputeHorizontalScrollOffset = recyclerView.computeHorizontalScrollOffset();
                int iComputeVerticalScrollOffset = recyclerView.computeVerticalScrollOffset();
                if (i == 0 && i2 == 0) {
                    this.offsetXCorrection = iComputeHorizontalScrollOffset;
                    this.offsetYCorrection = iComputeVerticalScrollOffset;
                    i3 = 0;
                    i4 = 0;
                } else {
                    i3 = iComputeHorizontalScrollOffset - this.offsetXCorrection;
                    i4 = iComputeVerticalScrollOffset - this.offsetYCorrection;
                }
                com.taobao.weex.ui.component.list.BasicListComponent.this.getScrollStartEndHelper().onScrolled(i3, i4);
                if (com.taobao.weex.ui.component.list.BasicListComponent.this.getEvents().contains("scroll")) {
                    if (this.mFirstEvent) {
                        this.mFirstEvent = false;
                        return;
                    }
                    androidx.recyclerview.widget.RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                    if (com.taobao.weex.ui.component.list.BasicListComponent.this.getOrientation() == 1) {
                        if (!layoutManager.canScrollVertically()) {
                            return;
                        }
                    } else if (com.taobao.weex.ui.component.list.BasicListComponent.this.getOrientation() == 0 && !layoutManager.canScrollHorizontally()) {
                        return;
                    }
                    if (com.taobao.weex.ui.component.list.BasicListComponent.this.shouldReport(i3, i4)) {
                        com.taobao.weex.ui.component.list.BasicListComponent.this.fireScrollEvent(recyclerView, i3, i4);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fireScrollEvent(androidx.recyclerview.widget.RecyclerView recyclerView, int i, int i2) {
        if (getInstance() != null) {
            fireEvent("scroll", getScrollEvent(recyclerView, i, i2));
        }
    }

    public java.util.Map<java.lang.String, java.lang.Object> getScrollEvent(androidx.recyclerview.widget.RecyclerView recyclerView, int i, int i2) {
        if (getOrientation() == 1) {
            i2 = -calcContentOffset(recyclerView);
        }
        int measuredWidth = recyclerView.getMeasuredWidth() + recyclerView.computeHorizontalScrollRange();
        int listChildLayoutHeight = 0;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            listChildLayoutHeight = (int) (listChildLayoutHeight + getListChildLayoutHeight(i3));
        }
        java.util.HashMap map = new java.util.HashMap(3);
        java.util.HashMap map2 = new java.util.HashMap(3);
        java.util.HashMap map3 = new java.util.HashMap(3);
        map2.put("width", java.lang.Float.valueOf(com.taobao.weex.utils.WXViewUtils.getWebPxByWidth(measuredWidth, getInstance().getInstanceViewPortWidthWithFloat())));
        map2.put("height", java.lang.Float.valueOf(com.taobao.weex.utils.WXViewUtils.getWebPxByWidth(listChildLayoutHeight, getInstance().getInstanceViewPortWidthWithFloat())));
        map3.put(com.taobao.weex.common.Constants.Name.X, java.lang.Float.valueOf(-com.taobao.weex.utils.WXViewUtils.getWebPxByWidth(i, getInstance().getInstanceViewPortWidthWithFloat())));
        map3.put(com.taobao.weex.common.Constants.Name.Y, java.lang.Float.valueOf(-com.taobao.weex.utils.WXViewUtils.getWebPxByWidth(i2, getInstance().getInstanceViewPortWidthWithFloat())));
        map.put(com.taobao.weex.common.Constants.Name.CONTENT_SIZE, map2);
        map.put(com.taobao.weex.common.Constants.Name.CONTENT_OFFSET, map3);
        map.put(com.taobao.weex.common.Constants.Name.ISDRAGGING, java.lang.Boolean.valueOf(recyclerView.getScrollState() == 1));
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean shouldReport(int i, int i2) {
        if (this.mLastReport.x == -1 && this.mLastReport.y == -1) {
            this.mLastReport.x = i;
            this.mLastReport.y = i2;
            return true;
        }
        int iAbs = java.lang.Math.abs(this.mLastReport.x - i);
        int iAbs2 = java.lang.Math.abs(this.mLastReport.y - i2);
        int i3 = this.mOffsetAccuracy;
        if (iAbs < i3 && iAbs2 < i3) {
            return false;
        }
        this.mLastReport.x = i;
        this.mLastReport.y = i2;
        return true;
    }

    public int calcContentOffset(androidx.recyclerview.widget.RecyclerView recyclerView) {
        androidx.recyclerview.widget.RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        int i = 0;
        if (layoutManager instanceof androidx.recyclerview.widget.LinearLayoutManager) {
            int iFindFirstVisibleItemPosition = ((androidx.recyclerview.widget.LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
            if (iFindFirstVisibleItemPosition == -1) {
                return 0;
            }
            android.view.View viewFindViewByPosition = layoutManager.findViewByPosition(iFindFirstVisibleItemPosition);
            int top = viewFindViewByPosition != null ? viewFindViewByPosition.getTop() : 0;
            int spanCount = 0;
            while (i < iFindFirstVisibleItemPosition) {
                spanCount = (int) (spanCount - getListChildLayoutHeight(i));
                i++;
            }
            if (layoutManager instanceof androidx.recyclerview.widget.GridLayoutManager) {
                spanCount /= ((androidx.recyclerview.widget.GridLayoutManager) layoutManager).getSpanCount();
            }
            return spanCount + top;
        }
        if (!(layoutManager instanceof androidx.recyclerview.widget.StaggeredGridLayoutManager)) {
            return -1;
        }
        androidx.recyclerview.widget.StaggeredGridLayoutManager staggeredGridLayoutManager = (androidx.recyclerview.widget.StaggeredGridLayoutManager) layoutManager;
        int spanCount2 = staggeredGridLayoutManager.getSpanCount();
        int i2 = staggeredGridLayoutManager.findFirstVisibleItemPositions(null)[0];
        if (i2 == -1) {
            return 0;
        }
        android.view.View viewFindViewByPosition2 = layoutManager.findViewByPosition(i2);
        int top2 = viewFindViewByPosition2 != null ? viewFindViewByPosition2.getTop() : 0;
        int listChildLayoutHeight = 0;
        while (i < i2) {
            listChildLayoutHeight = (int) (listChildLayoutHeight - getListChildLayoutHeight(i));
            i++;
        }
        return (listChildLayoutHeight / spanCount2) + top2;
    }

    public com.taobao.weex.ui.component.helper.ScrollStartEndHelper getScrollStartEndHelper() {
        if (this.mScrollStartEndHelper == null) {
            this.mScrollStartEndHelper = new com.taobao.weex.ui.component.helper.ScrollStartEndHelper(this);
        }
        return this.mScrollStartEndHelper;
    }

    @com.taobao.weex.annotation.JSMethod
    public void setSpecialEffects(com.alibaba.fastjson.JSONObject jSONObject) {
        if (getHostView() == null || !(getHostView() instanceof com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView)) {
            return;
        }
        if (jSONObject != null && jSONObject.containsKey("id")) {
            java.lang.String string = jSONObject.getString("id");
            com.alibaba.fastjson.JSONObject jSONObject2 = new com.alibaba.fastjson.JSONObject();
            jSONObject2.put("isNestParent", (java.lang.Object) false);
            jSONObject2.put("instanceId", (java.lang.Object) getInstance().getInstanceId());
            jSONObject2.put("listParentId", (java.lang.Object) string);
            getHostView().getInnerView().setNestInfo(jSONObject2);
            getHostView().getInnerView().callBackNestParent(getRef(), getInstance().getInstanceId(), com.taobao.weex.utils.WXViewUtils.getRealPxByWidth(com.taobao.weex.utils.WXUtils.getFloat(jSONObject.getString("headerHeight")), getInstance().getInstanceViewPortWidthWithFloat()));
            return;
        }
        getHostView().getInnerView().setNestInfo(null);
    }

    @Override // io.dcloud.feature.uniapp.ui.component.AbsVContainer
    public int getChildCount() {
        com.taobao.weex.ui.component.WXComponent child = super.getChild(0);
        if (child != null && (child instanceof com.taobao.weex.ui.component.WXRefresh) && this.mColumnCount > 1) {
            return super.getChildCount() + (this.mColumnCount - 1);
        }
        return super.getChildCount();
    }

    public com.taobao.weex.common.IWXObject getListChild(int i) {
        int i2;
        com.taobao.weex.ui.component.WXComponent child = super.getChild(0);
        if (i == 0) {
            return child;
        }
        if (child == null || !(child instanceof com.taobao.weex.ui.component.WXRefresh) || (i2 = this.mColumnCount) <= 1) {
            return super.getChild(i);
        }
        if (i - i2 < 0) {
            return getListStanceCell(child.getStyles().getBackgroundColor());
        }
        return super.getChild(i - (i2 - 1));
    }

    private com.taobao.weex.common.IWXObject getListStanceCell(java.lang.String str) {
        if (this.listStanceObject == null) {
            this.listStanceObject = new com.taobao.weex.ui.component.list.ListStanceCell(str);
        }
        return this.listStanceObject;
    }

    private float getListChildLayoutHeight(int i) {
        com.taobao.weex.ui.component.WXComponent wXComponent;
        com.taobao.weex.common.IWXObject listChild = getListChild(i);
        if (listChild == null) {
            return 0.0f;
        }
        if (listChild instanceof com.taobao.weex.ui.component.list.ListStanceCell) {
            return 1.0f;
        }
        if (!(listChild instanceof com.taobao.weex.ui.component.WXComponent) || (wXComponent = (com.taobao.weex.ui.component.WXComponent) listChild) == null) {
            return 0.0f;
        }
        return wXComponent.getLayoutHeight();
    }

    @com.taobao.weex.ui.component.WXComponentProp(name = "bounce")
    public void setBounce(java.lang.String str) {
        com.taobao.weex.ui.view.listview.WXRecyclerView innerView = getHostView().getInnerView();
        if (java.lang.Boolean.valueOf(str).booleanValue()) {
            innerView.setOverScrollMode(0);
        } else {
            innerView.setOverScrollMode(2);
        }
    }

    @com.taobao.weex.annotation.JSMethod
    public void scrollTo(java.lang.String str, com.taobao.weex.bridge.JSCallback jSCallback) {
        float realPxByWidth = com.taobao.weex.utils.WXViewUtils.getRealPxByWidth(com.taobao.weex.utils.WXUtils.getFloat(com.alibaba.fastjson.JSON.parseObject(str).getString(com.taobao.weex.common.Constants.Name.SCROLL_TOP)), getInstance().getInstanceViewPortWidthWithFloat());
        T hostView = getHostView();
        if (hostView == null) {
            return;
        }
        com.taobao.weex.ui.view.listview.WXRecyclerView innerView = hostView.getInnerView();
        if (getOrientation() == 1) {
            innerView.scrollTo(0, (int) realPxByWidth, getOrientation());
        } else {
            innerView.scrollTo((int) realPxByWidth, 0, getOrientation());
        }
        if (jSCallback != null) {
            java.util.HashMap map = new java.util.HashMap();
            map.put("type", com.taobao.weex.ui.component.WXImage.SUCCEED);
            jSCallback.invoke(map);
        }
    }

    @com.taobao.weex.ui.component.WXComponentProp(name = com.taobao.weex.common.Constants.Name.SCROLL_TOP)
    public void setScrollTop(java.lang.String str) {
        T hostView = getHostView();
        if (hostView == null) {
            return;
        }
        hostView.getInnerView().scrollTo(0, (int) com.taobao.weex.utils.WXViewUtils.getRealPxByWidth(com.taobao.weex.utils.WXUtils.getFloat(str), getInstance().getInstanceViewPortWidthWithFloat()), getOrientation());
    }

    @com.taobao.weex.ui.component.WXComponentProp(name = com.taobao.weex.common.Constants.Name.SCROLL_LEFT)
    public void setScrollLeft(java.lang.String str) {
        T hostView = getHostView();
        if (hostView == null) {
            return;
        }
        hostView.getInnerView().scrollTo((int) com.taobao.weex.utils.WXViewUtils.getRealPxByWidth(com.taobao.weex.utils.WXUtils.getFloat(str), getInstance().getInstanceViewPortWidthWithFloat()), 0, getOrientation());
    }

    @Override // io.dcloud.feature.uniapp.ui.component.AbsBasicComponent
    public void setIsLayoutRTL(boolean z) {
        super.setIsLayoutRTL(z);
        this.mViewOnScrollListener.setLayoutRTL(z);
    }
}
