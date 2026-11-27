package com.taobao.weex.ui.component.list.template;

/* JADX INFO: loaded from: classes.dex */
@com.taobao.weex.annotation.Component(lazyload = false)
public class WXRecyclerTemplateList extends com.taobao.weex.ui.component.WXVContainer<com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView> implements com.taobao.weex.ui.view.listview.adapter.IRecyclerAdapterListener<com.taobao.weex.ui.component.list.template.TemplateViewHolder>, com.taobao.weex.ui.view.listview.adapter.IOnLoadMoreListener, com.taobao.weex.ui.component.Scrollable {
    private static final long APPEAR_CHANGE_RUNNABLE_DELAY = 50;
    private static final java.lang.String EMPTY_HOLDER_TEMPLATE_KEY = "";
    public static final boolean ENABLE_TRACE_LOG = false;
    private static final java.lang.String NAME_HAS_FIXED_SIZE = "hasFixedSize";
    private static final java.lang.String NAME_ITEM_VIEW_CACHE_SIZE = "itemViewCacheSize";
    private static final java.lang.String NAME_TEMPLATE_CACHE_SIZE = "templateCacheSize";
    public static final java.lang.String TAG = "WXRecyclerTemplateList";
    private com.taobao.weex.ui.component.list.template.CellDataManager cellDataManager;
    private com.taobao.weex.ui.component.list.template.CellRenderContext cellRenderContext;
    private com.taobao.weex.ui.component.list.WXCell defaultTemplateCell;
    private java.lang.String defaultTemplateKey;
    private boolean hasAppendTreeDone;
    private boolean hasLayoutDone;
    private boolean isScrollable;
    private java.lang.String listDataIndexKey;
    private java.lang.String listDataItemKey;
    private java.lang.String listDataKey;
    private java.lang.String listDataTemplateKey;
    private java.lang.Runnable listUpdateRunnable;
    private java.lang.Runnable mAppearChangeRunnable;
    private androidx.collection.ArrayMap<java.lang.Integer, java.util.List<com.taobao.weex.ui.component.AppearanceHelper>> mAppearHelpers;
    protected int mColumnCount;
    protected float mColumnGap;
    protected float mColumnWidth;
    private androidx.collection.ArrayMap<java.lang.Integer, java.util.Map<java.lang.String, java.util.Map<java.lang.Integer, java.util.List<java.lang.Object>>>> mDisAppearWatchList;
    private boolean mForceLoadmoreNextTime;
    private boolean mHasAddScrollEvent;
    private androidx.recyclerview.widget.RecyclerView.ItemAnimator mItemAnimator;
    private android.graphics.Point mLastReport;
    protected int mLayoutType;
    private int mListCellCount;
    private int mOffsetAccuracy;
    private float mPaddingLeft;
    private float mPaddingRight;
    private com.taobao.weex.ui.component.helper.ScrollStartEndHelper mScrollStartEndHelper;
    private com.taobao.weex.ui.component.list.template.TemplateStickyHelper mStickyHelper;
    private java.util.Map<java.lang.String, com.taobao.weex.ui.component.list.WXCell> mTemplateSources;
    private androidx.collection.ArrayMap<java.lang.String, java.lang.Integer> mTemplateViewTypes;
    private java.util.concurrent.ConcurrentHashMap<java.lang.String, com.taobao.weex.ui.component.list.template.TemplateCache> mTemplatesCache;
    private com.taobao.weex.ui.view.listview.adapter.WXRecyclerViewOnScrollListener mViewOnScrollListener;
    private int orientation;
    private int templateCacheSize;

    @Override // io.dcloud.feature.uniapp.ui.component.AbsVContainer
    public void addSubView(android.view.View view, int i) {
    }

    @Override // com.taobao.weex.ui.component.WXVContainer, io.dcloud.feature.uniapp.ui.component.AbsVContainer
    protected int getChildrenLayoutTopOffset() {
        return 0;
    }

    @Override // com.taobao.weex.ui.view.listview.adapter.IRecyclerAdapterListener
    public boolean onFailedToRecycleView(com.taobao.weex.ui.component.list.template.TemplateViewHolder templateViewHolder) {
        return false;
    }

    @Override // com.taobao.weex.ui.view.listview.adapter.IRecyclerAdapterListener
    public void onViewRecycled(com.taobao.weex.ui.component.list.template.TemplateViewHolder templateViewHolder) {
    }

    public WXRecyclerTemplateList(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.ui.component.WXVContainer wXVContainer, com.taobao.weex.ui.action.BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, basicComponentData);
        this.mLayoutType = 1;
        this.mColumnCount = 1;
        this.mColumnGap = 0.0f;
        this.mColumnWidth = 0.0f;
        this.mViewOnScrollListener = new com.taobao.weex.ui.view.listview.adapter.WXRecyclerViewOnScrollListener(this);
        this.mListCellCount = 0;
        this.mForceLoadmoreNextTime = false;
        this.orientation = 1;
        this.isScrollable = true;
        this.mOffsetAccuracy = 10;
        this.mLastReport = new android.graphics.Point(-1, -1);
        this.mHasAddScrollEvent = false;
        this.listDataKey = com.taobao.weex.common.Constants.Name.Recycler.LIST_DATA;
        this.listDataItemKey = null;
        this.listDataIndexKey = null;
        this.listDataTemplateKey = com.taobao.weex.common.Constants.Name.Recycler.SLOT_TEMPLATE_CASE;
        this.templateCacheSize = 2;
        this.defaultTemplateKey = "@default_template_cell";
        this.mAppearHelpers = new androidx.collection.ArrayMap<>();
        this.mDisAppearWatchList = new androidx.collection.ArrayMap<>();
        this.cellRenderContext = new com.taobao.weex.ui.component.list.template.CellRenderContext();
        this.mAppearChangeRunnable = null;
        this.hasAppendTreeDone = false;
        this.hasLayoutDone = false;
        initRecyclerTemplateList(wXSDKInstance, basicComponentData, wXVContainer);
    }

    private void initRecyclerTemplateList(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.ui.action.BasicComponentData basicComponentData, com.taobao.weex.ui.component.WXVContainer wXVContainer) {
        updateRecyclerAttr();
        androidx.collection.ArrayMap<java.lang.String, java.lang.Integer> arrayMap = new androidx.collection.ArrayMap<>();
        this.mTemplateViewTypes = arrayMap;
        arrayMap.put("", 0);
        this.mTemplateSources = new java.util.HashMap();
        this.mTemplatesCache = new java.util.concurrent.ConcurrentHashMap<>();
        this.mStickyHelper = new com.taobao.weex.ui.component.list.template.TemplateStickyHelper(this);
        this.orientation = basicComponentData.getAttrs().getOrientation();
        this.listDataTemplateKey = com.taobao.weex.utils.WXUtils.getString(getAttrs().get(com.taobao.weex.common.Constants.Name.Recycler.LIST_DATA_TEMPLATE_SWITCH_KEY), com.taobao.weex.common.Constants.Name.Recycler.SLOT_TEMPLATE_CASE);
        this.listDataItemKey = com.taobao.weex.utils.WXUtils.getString(getAttrs().get(com.taobao.weex.common.Constants.Name.Recycler.LIST_DATA_ITEM), this.listDataItemKey);
        this.listDataIndexKey = com.taobao.weex.utils.WXUtils.getString(getAttrs().get("index"), this.listDataIndexKey);
        com.taobao.weex.ui.component.list.template.CellDataManager cellDataManager = new com.taobao.weex.ui.component.list.template.CellDataManager(this);
        this.cellDataManager = cellDataManager;
        cellDataManager.listData = parseListDataToJSONArray(getAttrs().get(com.taobao.weex.common.Constants.Name.Recycler.LIST_DATA));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXComponent
    public com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView initComponentHostView(android.content.Context context) {
        com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView bounceRecyclerView = new com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView(context, this.mLayoutType, this.mColumnCount, this.mColumnGap, getOrientation());
        com.taobao.weex.dom.WXAttr attrs = getAttrs();
        java.lang.String str = (java.lang.String) attrs.get("transform");
        if (str != null) {
            ((com.taobao.weex.ui.view.listview.WXRecyclerView) bounceRecyclerView.getInnerView()).addItemDecoration(com.taobao.weex.ui.component.list.RecyclerTransform.parseTransforms(getOrientation(), str));
        }
        this.mItemAnimator = ((com.taobao.weex.ui.view.listview.WXRecyclerView) bounceRecyclerView.getInnerView()).getItemAnimator();
        if (attrs.get(NAME_TEMPLATE_CACHE_SIZE) != null) {
            this.templateCacheSize = com.taobao.weex.utils.WXUtils.getInteger(attrs.get(NAME_TEMPLATE_CACHE_SIZE), java.lang.Integer.valueOf(this.templateCacheSize)).intValue();
        }
        int numberInt = attrs.get(NAME_ITEM_VIEW_CACHE_SIZE) != null ? com.taobao.weex.utils.WXUtils.getNumberInt(getAttrs().get(NAME_ITEM_VIEW_CACHE_SIZE), 2) : 2;
        boolean zBooleanValue = attrs.get("hasFixedSize") != null ? com.taobao.weex.utils.WXUtils.getBoolean(attrs.get("hasFixedSize"), false).booleanValue() : false;
        com.taobao.weex.ui.view.listview.adapter.RecyclerViewBaseAdapter recyclerViewBaseAdapter = new com.taobao.weex.ui.view.listview.adapter.RecyclerViewBaseAdapter(this);
        recyclerViewBaseAdapter.setHasStableIds(true);
        ((com.taobao.weex.ui.view.listview.WXRecyclerView) bounceRecyclerView.getInnerView()).setItemAnimator(null);
        if (numberInt != 2) {
            ((com.taobao.weex.ui.view.listview.WXRecyclerView) bounceRecyclerView.getInnerView()).setItemViewCacheSize(numberInt);
        }
        if (bounceRecyclerView.getSwipeLayout() != null && com.taobao.weex.utils.WXUtils.getBoolean(getAttrs().get(com.taobao.weex.common.Constants.Name.NEST_SCROLLING_ENABLED), false).booleanValue()) {
            bounceRecyclerView.getSwipeLayout().setNestedScrollingEnabled(true);
        }
        ((com.taobao.weex.ui.view.listview.WXRecyclerView) bounceRecyclerView.getInnerView()).setHasFixedSize(zBooleanValue);
        bounceRecyclerView.setRecyclerViewBaseAdapter(recyclerViewBaseAdapter);
        bounceRecyclerView.setOverScrollMode(2);
        ((com.taobao.weex.ui.view.listview.WXRecyclerView) bounceRecyclerView.getInnerView()).clearOnScrollListeners();
        ((com.taobao.weex.ui.view.listview.WXRecyclerView) bounceRecyclerView.getInnerView()).addOnScrollListener(this.mViewOnScrollListener);
        ((com.taobao.weex.ui.view.listview.WXRecyclerView) bounceRecyclerView.getInnerView()).addOnScrollListener(new androidx.recyclerview.widget.RecyclerView.OnScrollListener() { // from class: com.taobao.weex.ui.component.list.template.WXRecyclerTemplateList.1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(androidx.recyclerview.widget.RecyclerView recyclerView, int i) {
                android.view.View childAt;
                super.onScrollStateChanged(recyclerView, i);
                com.taobao.weex.ui.component.list.template.WXRecyclerTemplateList.this.getScrollStartEndHelper().onScrollStateChanged(i);
                java.util.List<com.taobao.weex.common.OnWXScrollListener> wXScrollListeners = com.taobao.weex.ui.component.list.template.WXRecyclerTemplateList.this.getInstance().getWXScrollListeners();
                if (wXScrollListeners == null || wXScrollListeners.size() <= 0) {
                    return;
                }
                for (com.taobao.weex.common.OnWXScrollListener onWXScrollListener : wXScrollListeners) {
                    if (onWXScrollListener != null && (childAt = recyclerView.getChildAt(0)) != null) {
                        onWXScrollListener.onScrollStateChanged(recyclerView, 0, childAt.getTop(), i);
                    }
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(androidx.recyclerview.widget.RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                java.util.List<com.taobao.weex.common.OnWXScrollListener> wXScrollListeners = com.taobao.weex.ui.component.list.template.WXRecyclerTemplateList.this.getInstance().getWXScrollListeners();
                if (wXScrollListeners == null || wXScrollListeners.size() <= 0) {
                    return;
                }
                try {
                    for (com.taobao.weex.common.OnWXScrollListener onWXScrollListener : wXScrollListeners) {
                        if (onWXScrollListener != null) {
                            if (onWXScrollListener instanceof com.taobao.weex.common.ICheckBindingScroller) {
                                if (((com.taobao.weex.common.ICheckBindingScroller) onWXScrollListener).isNeedScroller(com.taobao.weex.ui.component.list.template.WXRecyclerTemplateList.this.getRef(), null)) {
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
        bounceRecyclerView.getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.taobao.weex.ui.component.list.template.WXRecyclerTemplateList.2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView bounceRecyclerView2 = (com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView) com.taobao.weex.ui.component.list.template.WXRecyclerTemplateList.this.getHostView();
                if (bounceRecyclerView2 == null) {
                    return;
                }
                com.taobao.weex.ui.component.list.template.WXRecyclerTemplateList.this.mViewOnScrollListener.onScrolled((androidx.recyclerview.widget.RecyclerView) bounceRecyclerView2.getInnerView(), 0, 0);
                bounceRecyclerView2.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
        this.listUpdateRunnable = new java.lang.Runnable() { // from class: com.taobao.weex.ui.component.list.template.WXRecyclerTemplateList.3
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                if (com.taobao.weex.ui.component.list.template.WXRecyclerTemplateList.this.mStickyHelper != null && com.taobao.weex.ui.component.list.template.WXRecyclerTemplateList.this.mStickyHelper.getStickyTypes().size() > 0) {
                    com.taobao.weex.ui.component.list.template.WXRecyclerTemplateList.this.mStickyHelper.getStickyPositions().clear();
                    if (com.taobao.weex.ui.component.list.template.WXRecyclerTemplateList.this.cellDataManager.listData != null) {
                        for (int i = 0; i < com.taobao.weex.ui.component.list.template.WXRecyclerTemplateList.this.cellDataManager.listData.size(); i++) {
                            com.taobao.weex.ui.component.list.WXCell sourceTemplate = com.taobao.weex.ui.component.list.template.WXRecyclerTemplateList.this.getSourceTemplate(i);
                            if (sourceTemplate != null && sourceTemplate.isSticky()) {
                                com.taobao.weex.ui.component.list.template.WXRecyclerTemplateList.this.mStickyHelper.getStickyPositions().add(java.lang.Integer.valueOf(i));
                            }
                        }
                    }
                }
                if (com.taobao.weex.ui.component.list.template.WXRecyclerTemplateList.this.getHostView() != 0 && ((com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView) com.taobao.weex.ui.component.list.template.WXRecyclerTemplateList.this.getHostView()).getRecyclerViewBaseAdapter() != null) {
                    ((com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView) com.taobao.weex.ui.component.list.template.WXRecyclerTemplateList.this.getHostView()).getRecyclerViewBaseAdapter().notifyDataSetChanged();
                }
                com.taobao.weex.WXEnvironment.isOpenDebugLog();
            }
        };
        return bounceRecyclerView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXComponent
    public void onHostViewInitialized(com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView bounceRecyclerView) {
        super.onHostViewInitialized(bounceRecyclerView);
        com.taobao.weex.ui.view.listview.WXRecyclerView wXRecyclerView = (com.taobao.weex.ui.view.listview.WXRecyclerView) bounceRecyclerView.getInnerView();
        if (wXRecyclerView == null || wXRecyclerView.getAdapter() == null) {
            com.taobao.weex.utils.WXLogUtils.e(TAG, "RecyclerView is not found or Adapter is not bound");
        }
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    protected com.taobao.weex.ui.component.WXComponent.MeasureOutput measure(int i, int i2) {
        int screenHeight = com.taobao.weex.utils.WXViewUtils.getScreenHeight(com.taobao.weex.WXEnvironment.sApplication);
        int weexHeight = com.taobao.weex.utils.WXViewUtils.getWeexHeight(getInstanceId());
        if (weexHeight < screenHeight) {
            screenHeight = weexHeight;
        }
        if (i2 > screenHeight) {
            i2 = weexHeight - getAbsoluteY();
        }
        return super.measure(i, i2);
    }

    @Override // com.taobao.weex.ui.component.Scrollable
    public void bindStickStyle(com.taobao.weex.ui.component.WXComponent wXComponent) {
        com.taobao.weex.ui.component.list.template.TemplateStickyHelper templateStickyHelper;
        com.taobao.weex.ui.component.WXComponent wXComponentFindParentType = findParentType(wXComponent, com.taobao.weex.ui.component.list.WXCell.class);
        if (wXComponentFindParentType == null || (templateStickyHelper = this.mStickyHelper) == null || templateStickyHelper.getStickyTypes().contains(wXComponentFindParentType.getRef())) {
            return;
        }
        this.mStickyHelper.getStickyTypes().add(wXComponentFindParentType.getRef());
        notifyUpdateList();
    }

    @Override // com.taobao.weex.ui.component.Scrollable
    public void unbindStickStyle(com.taobao.weex.ui.component.WXComponent wXComponent) {
        com.taobao.weex.ui.component.list.template.TemplateStickyHelper templateStickyHelper;
        com.taobao.weex.ui.component.WXComponent wXComponentFindParentType = findParentType(wXComponent, com.taobao.weex.ui.component.list.WXCell.class);
        if (wXComponentFindParentType == null || (templateStickyHelper = this.mStickyHelper) == null || !templateStickyHelper.getStickyTypes().contains(wXComponentFindParentType.getRef())) {
            return;
        }
        this.mStickyHelper.getStickyTypes().remove(wXComponentFindParentType.getRef());
        notifyUpdateList();
    }

    private com.taobao.weex.ui.component.list.WXCell findCell(com.taobao.weex.ui.component.WXComponent wXComponent) {
        com.taobao.weex.ui.component.WXVContainer parent;
        if (wXComponent instanceof com.taobao.weex.ui.component.list.WXCell) {
            return (com.taobao.weex.ui.component.list.WXCell) wXComponent;
        }
        if (wXComponent == null || (parent = wXComponent.getParent()) == null) {
            return null;
        }
        return findCell(parent);
    }

    private void setAppearanceWatch(com.taobao.weex.ui.component.WXComponent wXComponent, int i, boolean z) {
        int cellTemplateItemType;
        com.taobao.weex.ui.component.AppearanceHelper next;
        if (this.cellDataManager.listData == null || this.mAppearHelpers == null || android.text.TextUtils.isEmpty(wXComponent.getRef()) || (cellTemplateItemType = getCellTemplateItemType(findCell(wXComponent))) < 0) {
            return;
        }
        java.util.List<com.taobao.weex.ui.component.AppearanceHelper> arrayList = this.mAppearHelpers.get(java.lang.Integer.valueOf(cellTemplateItemType));
        if (arrayList == null) {
            arrayList = new java.util.ArrayList<>();
            this.mAppearHelpers.put(java.lang.Integer.valueOf(cellTemplateItemType), arrayList);
        }
        java.util.Iterator<com.taobao.weex.ui.component.AppearanceHelper> it = arrayList.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!wXComponent.getRef().equals(next.getAwareChild().getRef()));
        if (next != null) {
            next.setWatchEvent(i, z);
            return;
        }
        com.taobao.weex.ui.component.AppearanceHelper appearanceHelper = new com.taobao.weex.ui.component.AppearanceHelper(wXComponent, cellTemplateItemType);
        appearanceHelper.setWatchEvent(i, z);
        arrayList.add(appearanceHelper);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.taobao.weex.ui.component.Scrollable
    public void bindAppearEvent(com.taobao.weex.ui.component.WXComponent wXComponent) {
        setAppearanceWatch(wXComponent, 0, true);
        if (this.mAppearChangeRunnable == null) {
            this.mAppearChangeRunnable = new java.lang.Runnable() { // from class: com.taobao.weex.ui.component.list.template.WXRecyclerTemplateList.4
                @Override // java.lang.Runnable
                public void run() {
                    if (com.taobao.weex.ui.component.list.template.WXRecyclerTemplateList.this.mAppearChangeRunnable != null) {
                        com.taobao.weex.ui.component.list.template.WXRecyclerTemplateList.this.notifyAppearStateChange(0, 0, 0, 0);
                    }
                }
            };
        }
        if (getHostView() != 0) {
            ((com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView) getHostView()).removeCallbacks(this.mAppearChangeRunnable);
            ((com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView) getHostView()).postDelayed(this.mAppearChangeRunnable, APPEAR_CHANGE_RUNNABLE_DELAY);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.taobao.weex.ui.component.Scrollable
    public void bindDisappearEvent(com.taobao.weex.ui.component.WXComponent wXComponent) {
        setAppearanceWatch(wXComponent, 1, true);
        if (this.mAppearChangeRunnable == null) {
            this.mAppearChangeRunnable = new java.lang.Runnable() { // from class: com.taobao.weex.ui.component.list.template.WXRecyclerTemplateList.5
                @Override // java.lang.Runnable
                public void run() {
                    if (com.taobao.weex.ui.component.list.template.WXRecyclerTemplateList.this.mAppearChangeRunnable != null) {
                        com.taobao.weex.ui.component.list.template.WXRecyclerTemplateList.this.notifyAppearStateChange(0, 0, 0, 0);
                    }
                }
            };
        }
        if (getHostView() != 0) {
            ((com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView) getHostView()).removeCallbacks(this.mAppearChangeRunnable);
            ((com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView) getHostView()).postDelayed(this.mAppearChangeRunnable, APPEAR_CHANGE_RUNNABLE_DELAY);
        }
    }

    @Override // com.taobao.weex.ui.component.Scrollable
    public void unbindAppearEvent(com.taobao.weex.ui.component.WXComponent wXComponent) {
        setAppearanceWatch(wXComponent, 0, false);
    }

    @Override // com.taobao.weex.ui.component.Scrollable
    public void unbindDisappearEvent(com.taobao.weex.ui.component.WXComponent wXComponent) {
        setAppearanceWatch(wXComponent, 1, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @com.taobao.weex.annotation.JSMethod(uiThread = true)
    public void queryElement(java.lang.String str, java.lang.String str2, com.taobao.weex.bridge.JSCallback jSCallback) {
        try {
            java.lang.String[] strArrSplit = str.split("@");
            java.lang.String str3 = strArrSplit[0];
            int i = java.lang.Integer.parseInt(strArrSplit[1]);
            com.taobao.weex.ui.component.WXComponent wXComponentFindVirtualComponentByVRef = com.taobao.weex.ui.component.list.template.TemplateDom.findVirtualComponentByVRef(getInstanceId(), str);
            if (wXComponentFindVirtualComponentByVRef != null && getHostView() != 0 && ((com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView) getHostView()).getInnerView() != null) {
                java.util.ArrayList arrayList = new java.util.ArrayList(4);
                com.taobao.weex.ui.component.list.template.Selector.queryElementAll(wXComponentFindVirtualComponentByVRef, str2, arrayList);
                if (arrayList.size() > 0) {
                    jSCallback.invoke(com.taobao.weex.ui.component.list.template.TemplateDom.toMap(str3, i, (com.taobao.weex.ui.component.WXComponent) arrayList.get(0)));
                } else {
                    jSCallback.invoke(new java.util.HashMap(4));
                }
            }
        } catch (java.lang.Exception e) {
            jSCallback.invoke(new java.util.HashMap(4));
            com.taobao.weex.utils.WXLogUtils.e(TAG, e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @com.taobao.weex.annotation.JSMethod(uiThread = true)
    public void queryElementAll(java.lang.String str, java.lang.String str2, com.taobao.weex.bridge.JSCallback jSCallback) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        try {
            java.lang.String[] strArrSplit = str.split("@");
            java.lang.String str3 = strArrSplit[0];
            int i = java.lang.Integer.parseInt(strArrSplit[1]);
            com.taobao.weex.ui.component.WXComponent wXComponentFindVirtualComponentByVRef = com.taobao.weex.ui.component.list.template.TemplateDom.findVirtualComponentByVRef(getInstanceId(), str);
            if (wXComponentFindVirtualComponentByVRef != null && getHostView() != 0 && ((com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView) getHostView()).getInnerView() != null) {
                java.util.ArrayList arrayList2 = new java.util.ArrayList(4);
                com.taobao.weex.ui.component.list.template.Selector.queryElementAll(wXComponentFindVirtualComponentByVRef, str2, arrayList2);
                java.util.Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    arrayList.add(com.taobao.weex.ui.component.list.template.TemplateDom.toMap(str3, i, (com.taobao.weex.ui.component.WXComponent) it.next()));
                }
                jSCallback.invoke(arrayList);
            }
        } catch (java.lang.Exception e) {
            jSCallback.invoke(arrayList);
            com.taobao.weex.utils.WXLogUtils.e(TAG, e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @com.taobao.weex.annotation.JSMethod(uiThread = true)
    public void closest(java.lang.String str, java.lang.String str2, com.taobao.weex.bridge.JSCallback jSCallback) {
        try {
            java.lang.String[] strArrSplit = str.split("@");
            java.lang.String str3 = strArrSplit[0];
            int i = java.lang.Integer.parseInt(strArrSplit[1]);
            com.taobao.weex.ui.component.WXComponent wXComponentFindVirtualComponentByVRef = com.taobao.weex.ui.component.list.template.TemplateDom.findVirtualComponentByVRef(getInstanceId(), str);
            if (wXComponentFindVirtualComponentByVRef != null && getHostView() != 0 && ((com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView) getHostView()).getInnerView() != null) {
                java.util.ArrayList arrayList = new java.util.ArrayList(4);
                com.taobao.weex.ui.component.list.template.Selector.closest(wXComponentFindVirtualComponentByVRef, str2, arrayList);
                if (arrayList.size() > 0) {
                    jSCallback.invoke(com.taobao.weex.ui.component.list.template.TemplateDom.toMap(str3, i, (com.taobao.weex.ui.component.WXComponent) arrayList.get(0)));
                } else {
                    jSCallback.invoke(new java.util.HashMap(4));
                }
            }
        } catch (java.lang.Exception e) {
            jSCallback.invoke(new java.util.HashMap(4));
            com.taobao.weex.utils.WXLogUtils.e(TAG, e);
        }
    }

    @com.taobao.weex.annotation.JSMethod(uiThread = true)
    public void scrollToElement(java.lang.String str, java.util.Map<java.lang.String, java.lang.Object> map) {
        scrollTo(str, map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @com.taobao.weex.annotation.JSMethod(uiThread = true)
    public void scrollTo(java.lang.String str, java.util.Map<java.lang.String, java.lang.Object> map) {
        try {
            int i = str.indexOf(64) > 0 ? java.lang.Integer.parseInt(str.split("@")[0]) : (int) java.lang.Float.parseFloat(str);
            if (i >= 0) {
                boolean zBooleanValue = true;
                float realPxByWidth = 0.0f;
                if (map != null) {
                    com.taobao.weex.utils.WXUtils.getBoolean(map.get(com.taobao.weex.common.Constants.Name.ANIMATED), true).booleanValue();
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
                int i2 = (int) realPxByWidth;
                com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView bounceRecyclerView = (com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView) getHostView();
                if (bounceRecyclerView == null) {
                    return;
                }
                ((com.taobao.weex.ui.view.listview.WXRecyclerView) bounceRecyclerView.getInnerView()).scrollTo(zBooleanValue, i, i2, getOrientation());
            }
        } catch (java.lang.Exception e2) {
            com.taobao.weex.utils.WXLogUtils.e(TAG, e2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.taobao.weex.ui.component.Scrollable
    public void scrollTo(com.taobao.weex.ui.component.WXComponent wXComponent, java.util.Map<java.lang.String, java.lang.Object> map) {
        int size;
        boolean zBooleanValue;
        float realPxByWidth = 0.0f;
        int numberInt = -1;
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
            size = com.taobao.weex.utils.WXUtils.getNumberInt(map.get(com.taobao.weex.common.Constants.Name.Recycler.CELL_INDEX), -1);
            numberInt = com.taobao.weex.utils.WXUtils.getNumberInt(map.get(com.taobao.weex.common.Constants.Name.Recycler.TYPE_INDEX), -1);
        } else {
            size = -1;
            zBooleanValue = true;
        }
        com.taobao.weex.ui.component.list.WXCell wXCellFindCell = findCell(wXComponent);
        if (numberInt >= 0 && this.cellDataManager.listData != null && wXComponent.getRef() != null) {
            int i = 0;
            for (int i2 = 0; i2 < this.cellDataManager.listData.size(); i2++) {
                com.taobao.weex.ui.component.list.WXCell sourceTemplate = getSourceTemplate(i2);
                if (sourceTemplate != null) {
                    if (wXCellFindCell.getRef().equals(sourceTemplate.getRef())) {
                        i++;
                    }
                    if (i > numberInt) {
                        size = i2;
                        break;
                    }
                }
            }
            if (size < 0) {
                size = this.cellDataManager.listData.size() - 1;
            }
        }
        int i3 = (int) realPxByWidth;
        com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView bounceRecyclerView = (com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView) getHostView();
        if (bounceRecyclerView != null && size >= 0) {
            ((com.taobao.weex.ui.view.listview.WXRecyclerView) bounceRecyclerView.getInnerView()).scrollTo(zBooleanValue, size, i3, getOrientation());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.taobao.weex.ui.component.Scrollable
    public int getScrollY() {
        com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView bounceRecyclerView = (com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView) getHostView();
        if (bounceRecyclerView == null) {
            return 0;
        }
        return ((com.taobao.weex.ui.view.listview.WXRecyclerView) bounceRecyclerView.getInnerView()).getScrollY();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.taobao.weex.ui.component.Scrollable
    public int getScrollX() {
        com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView bounceRecyclerView = (com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView) getHostView();
        if (bounceRecyclerView == null) {
            return 0;
        }
        return ((com.taobao.weex.ui.view.listview.WXRecyclerView) bounceRecyclerView.getInnerView()).getScrollX();
    }

    @Override // com.taobao.weex.ui.component.Scrollable
    public int getOrientation() {
        return this.orientation;
    }

    @Override // com.taobao.weex.ui.component.Scrollable
    public boolean isScrollable() {
        return this.isScrollable;
    }

    @Override // io.dcloud.feature.uniapp.ui.component.AbsVContainer
    public void addChild(com.taobao.weex.ui.component.WXComponent wXComponent) {
        addChild(wXComponent, -1);
    }

    @Override // io.dcloud.feature.uniapp.ui.component.AbsVContainer
    public void addChild(com.taobao.weex.ui.component.WXComponent wXComponent, int i) {
        boolean z = wXComponent instanceof com.taobao.weex.ui.component.list.WXCell;
        if (!z) {
            super.addChild(wXComponent, i);
        }
        if (!(wXComponent instanceof com.taobao.weex.ui.component.WXBaseRefresh) && z) {
            if (wXComponent.getAttrs() != null) {
                java.lang.String string = com.taobao.weex.utils.WXUtils.getString(wXComponent.getAttrs().get(com.taobao.weex.common.Constants.Name.Recycler.SLOT_TEMPLATE_CASE), null);
                if (getAttrs().containsKey(com.taobao.weex.common.Constants.Name.Recycler.LIST_DATA_TEMPLATE_SWITCH_KEY)) {
                    if (this.defaultTemplateCell == null) {
                        this.defaultTemplateCell = (com.taobao.weex.ui.component.list.WXCell) wXComponent;
                        if (!android.text.TextUtils.isEmpty(string)) {
                            this.defaultTemplateKey = string;
                        } else {
                            string = this.defaultTemplateKey;
                            wXComponent.getAttrs().put(com.taobao.weex.common.Constants.Name.Recycler.SLOT_TEMPLATE_CASE, (java.lang.Object) string);
                        }
                    }
                } else if (this.defaultTemplateCell == null || wXComponent.getAttrs().containsKey("default")) {
                    this.defaultTemplateCell = (com.taobao.weex.ui.component.list.WXCell) wXComponent;
                    if (!android.text.TextUtils.isEmpty(string)) {
                        this.defaultTemplateKey = string;
                    } else {
                        string = this.defaultTemplateKey;
                        wXComponent.getAttrs().put(com.taobao.weex.common.Constants.Name.Recycler.SLOT_TEMPLATE_CASE, (java.lang.Object) string);
                    }
                }
                if (string != null) {
                    this.mTemplateSources.put(string, (com.taobao.weex.ui.component.list.WXCell) wXComponent);
                    if (this.mTemplateViewTypes.get(string) == null) {
                        androidx.collection.ArrayMap<java.lang.String, java.lang.Integer> arrayMap = this.mTemplateViewTypes;
                        arrayMap.put(string, java.lang.Integer.valueOf(arrayMap.size()));
                    }
                }
            }
            ((com.taobao.weex.ui.component.list.WXCell) wXComponent).setCellAppendTreeListener(new com.taobao.weex.ui.component.list.WXCell.CellAppendTreeListener() { // from class: com.taobao.weex.ui.component.list.template.WXRecyclerTemplateList.6
                @Override // com.taobao.weex.ui.component.list.WXCell.CellAppendTreeListener
                public void onAppendTreeDone() {
                    com.taobao.weex.ui.component.list.template.WXRecyclerTemplateList.this.checkAppendDone(false);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkAppendDone(boolean z) {
        if (this.mTemplateSources.size() == 0) {
            return;
        }
        java.util.Iterator<java.util.Map.Entry<java.lang.String, com.taobao.weex.ui.component.list.WXCell>> it = this.mTemplateSources.entrySet().iterator();
        while (it.hasNext()) {
            if (!it.next().getValue().isAppendTreeDone()) {
                return;
            }
        }
        this.hasAppendTreeDone = true;
        if (this.hasLayoutDone) {
            notifyUpdateList();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXComponent
    public void setHostLayoutParams(com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView bounceRecyclerView, int i, int i2, int i3, int i4, int i5, int i6) {
        super.setHostLayoutParams(bounceRecyclerView, i, i2, i3, i4, i5, i6);
        if (this.hasLayoutDone) {
            return;
        }
        this.hasLayoutDone = true;
        this.hasAppendTreeDone = true;
        notifyUpdateList();
    }

    @Override // io.dcloud.feature.uniapp.ui.component.AbsVContainer
    public void createChildViewAt(int i) {
        if (i >= 0 || (i = childCount() - 1) >= 0) {
            com.taobao.weex.ui.component.WXComponent child = getChild(i);
            if (child instanceof com.taobao.weex.ui.component.WXBaseRefresh) {
                child.createView();
                setRefreshOrLoading(child);
            }
        }
    }

    @Override // io.dcloud.feature.uniapp.ui.component.AbsVContainer
    public void remove(com.taobao.weex.ui.component.WXComponent wXComponent, boolean z) {
        removeFooterOrHeader(wXComponent);
        super.remove(wXComponent, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.taobao.weex.ui.component.WXComponent
    public void computeVisiblePointInViewCoordinate(android.graphics.PointF pointF) {
        androidx.recyclerview.widget.RecyclerView recyclerView = (androidx.recyclerview.widget.RecyclerView) ((com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView) getHostView()).getInnerView();
        pointF.set(recyclerView.computeHorizontalScrollOffset(), recyclerView.computeVerticalScrollOffset());
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    protected boolean setProperty(java.lang.String str, java.lang.Object obj) {
        str.hashCode();
        switch (str) {
            case "switch":
            case "case":
                this.listDataTemplateKey = com.taobao.weex.utils.WXUtils.getString(obj, com.taobao.weex.common.Constants.Name.Recycler.SLOT_TEMPLATE_CASE);
                return true;
            case "showScrollbar":
                java.lang.Boolean bool = com.taobao.weex.utils.WXUtils.getBoolean(obj, null);
                if (bool != null) {
                    setShowScrollbar(bool.booleanValue());
                    break;
                }
            case "itemViewCacheSize":
            case "hasFixedSize":
                return true;
            case "offsetAccuracy":
                setOffsetAccuracy(com.taobao.weex.utils.WXUtils.getInteger(obj, 10).intValue());
            case "loadmoreoffset":
                return true;
            case "scrollable":
                setScrollable(com.taobao.weex.utils.WXUtils.getBoolean(obj, true).booleanValue());
                return true;
            case "alias":
                this.listDataItemKey = com.taobao.weex.utils.WXUtils.getString(obj, this.listDataItemKey);
                return true;
            case "index":
                this.listDataIndexKey = com.taobao.weex.utils.WXUtils.getString(obj, this.listDataIndexKey);
                return true;
            case "listData":
                setListData(obj);
                return true;
            case "scrollDirection":
                if (obj != null) {
                    setScrollDirection(obj.toString());
                }
                return true;
            default:
                return super.setProperty(str, obj);
        }
    }

    @com.taobao.weex.ui.component.WXComponentProp(name = com.taobao.weex.common.Constants.Name.OFFSET_ACCURACY)
    public void setOffsetAccuracy(int i) {
        this.mOffsetAccuracy = (int) com.taobao.weex.utils.WXViewUtils.getRealPxByWidth(i, getInstance().getInstanceViewPortWidthWithFloat());
    }

    private void updateRecyclerAttr() {
        this.mLayoutType = getAttrs().getLayoutType();
        int columnCount = getAttrs().getColumnCount();
        this.mColumnCount = columnCount;
        if (columnCount <= 0 && this.mLayoutType != 1) {
            androidx.collection.ArrayMap arrayMap = new androidx.collection.ArrayMap();
            arrayMap.put("componentType", getComponentType());
            arrayMap.put("attribute", getAttrs().toString());
            arrayMap.put("stackTrace", java.util.Arrays.toString(java.lang.Thread.currentThread().getStackTrace()));
            com.taobao.weex.utils.WXExceptionUtils.commitCriticalExceptionRT(getInstanceId(), com.taobao.weex.common.WXErrorCode.WX_RENDER_ERR_LIST_INVALID_COLUMN_COUNT, com.taobao.weex.common.Constants.Name.COLUMN_COUNT, java.lang.String.format(java.util.Locale.ENGLISH, "You are trying to set the list/recycler/vlist/waterfall's column to %d, which is illegal. The column count should be a positive integer", java.lang.Integer.valueOf(this.mColumnCount)), arrayMap);
            this.mColumnCount = 1;
        }
        this.mColumnGap = getAttrs().getColumnGap();
        this.mColumnWidth = getAttrs().getColumnWidth();
        this.mPaddingLeft = getPadding().get(com.taobao.weex.dom.CSSShorthand.EDGE.LEFT);
        this.mPaddingRight = getPadding().get(com.taobao.weex.dom.CSSShorthand.EDGE.RIGHT);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @com.taobao.weex.ui.component.WXComponentProp(name = com.taobao.weex.common.Constants.Name.SCROLL_DIRECTION)
    public void setScrollDirection(java.lang.String str) {
        if (this.orientation != getAttrs().getOrientation()) {
            this.orientation = getAttrs().getOrientation();
            updateRecyclerAttr();
            com.taobao.weex.ui.view.listview.WXRecyclerView wXRecyclerView = (com.taobao.weex.ui.view.listview.WXRecyclerView) ((com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView) getHostView()).getInnerView();
            if (this.orientation == 0) {
                wXRecyclerView.setHorizontalScrollBarEnabled(true);
            } else {
                wXRecyclerView.setHorizontalScrollBarEnabled(false);
            }
            wXRecyclerView.initView(getContext(), this.mLayoutType, this.mColumnCount, this.mColumnGap, getOrientation());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @com.taobao.weex.ui.component.WXComponentProp(name = com.taobao.weex.common.Constants.Name.COLUMN_WIDTH)
    public void setColumnWidth(int i) {
        if (getAttrs().getColumnWidth() != this.mColumnWidth) {
            updateRecyclerAttr();
            ((com.taobao.weex.ui.view.listview.WXRecyclerView) ((com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView) getHostView()).getInnerView()).initView(getContext(), this.mLayoutType, this.mColumnCount, this.mColumnGap, getOrientation());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @com.taobao.weex.ui.component.WXComponentProp(name = com.taobao.weex.common.Constants.Name.SHOW_SCROLLBAR)
    public void setShowScrollbar(boolean z) {
        if (getHostView() == 0 || ((com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView) getHostView()).getInnerView() == null) {
            return;
        }
        if (getOrientation() == 1) {
            ((com.taobao.weex.ui.view.listview.WXRecyclerView) ((com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView) getHostView()).getInnerView()).setVerticalScrollBarEnabled(z);
        } else {
            ((com.taobao.weex.ui.view.listview.WXRecyclerView) ((com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView) getHostView()).getInnerView()).setHorizontalScrollBarEnabled(z);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @com.taobao.weex.ui.component.WXComponentProp(name = com.taobao.weex.common.Constants.Name.COLUMN_COUNT)
    public void setColumnCount(int i) {
        if (getAttrs().getColumnCount() != this.mColumnCount) {
            updateRecyclerAttr();
            ((com.taobao.weex.ui.view.listview.WXRecyclerView) ((com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView) getHostView()).getInnerView()).initView(getContext(), this.mLayoutType, this.mColumnCount, this.mColumnGap, getOrientation());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @com.taobao.weex.ui.component.WXComponentProp(name = com.taobao.weex.common.Constants.Name.COLUMN_GAP)
    public void setColumnGap(float f) throws java.lang.InterruptedException {
        if (getAttrs().getColumnGap() != this.mColumnGap) {
            updateRecyclerAttr();
            ((com.taobao.weex.ui.view.listview.WXRecyclerView) ((com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView) getHostView()).getInnerView()).initView(getContext(), this.mLayoutType, this.mColumnCount, this.mColumnGap, getOrientation());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @com.taobao.weex.ui.component.WXComponentProp(name = com.taobao.weex.common.Constants.Name.SCROLLABLE)
    public void setScrollable(boolean z) {
        ((com.taobao.weex.ui.view.listview.WXRecyclerView) ((com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView) getHostView()).getInnerView()).setScrollable(z);
    }

    @com.taobao.weex.annotation.JSMethod
    public void setListData(java.lang.Object obj) {
        com.alibaba.fastjson.JSONArray listDataToJSONArray = parseListDataToJSONArray(obj);
        boolean z = this.cellDataManager.listData != listDataToJSONArray;
        if ((listDataToJSONArray instanceof com.alibaba.fastjson.JSONArray) && z) {
            this.cellDataManager.setListData(listDataToJSONArray);
            notifyUpdateList();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @com.taobao.weex.annotation.JSMethod
    public void appendData(com.alibaba.fastjson.JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.size() == 0) {
            return;
        }
        if (this.cellDataManager.listData == null) {
            this.cellDataManager.listData = new com.alibaba.fastjson.JSONArray();
        }
        int size = this.cellDataManager.listData.size();
        if (size < 0) {
            size = 0;
        }
        if (jSONArray instanceof com.alibaba.fastjson.JSONArray) {
            this.cellDataManager.listData.addAll(jSONArray);
        }
        ((com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView) getHostView()).getRecyclerViewBaseAdapter().notifyItemRangeInserted(size, jSONArray.size());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @com.taobao.weex.annotation.JSMethod
    public void insertData(int i, java.lang.Object obj) {
        if (obj == null || this.cellDataManager.listData == null || i > this.cellDataManager.listData.size()) {
            return;
        }
        if (this.cellDataManager.insertData(i, obj)) {
            notifyUpdateList();
        } else {
            ((com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView) getHostView()).getRecyclerViewBaseAdapter().notifyItemInserted(i);
        }
    }

    @com.taobao.weex.annotation.JSMethod
    public void appendRange(int i, com.alibaba.fastjson.JSONArray jSONArray) {
        insertRange(i, jSONArray);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @com.taobao.weex.annotation.JSMethod
    public void insertRange(int i, com.alibaba.fastjson.JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.size() == 0 || this.cellDataManager.listData == null || i > this.cellDataManager.listData.size()) {
            return;
        }
        if (this.cellDataManager.insertRange(i, jSONArray)) {
            notifyUpdateList();
        } else {
            ((com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView) getHostView()).getRecyclerViewBaseAdapter().notifyItemRangeInserted(i, jSONArray.size());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @com.taobao.weex.annotation.JSMethod
    public void updateData(int i, java.lang.Object obj) {
        if (obj == null || this.cellDataManager.listData == null || i >= this.cellDataManager.listData.size()) {
            return;
        }
        if (this.cellDataManager.updateData(obj, i)) {
            ((com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView) getHostView()).getRecyclerViewBaseAdapter().notifyItemChanged(i, obj);
        } else {
            notifyUpdateList();
        }
    }

    @com.taobao.weex.annotation.JSMethod
    public void removeData(int i, int i2) {
        if (this.cellDataManager.listData == null || i >= this.cellDataManager.listData.size()) {
            return;
        }
        if (i2 <= 0) {
            i2 = 1;
        }
        int i3 = 0;
        while (i2 > 0 && i < this.cellDataManager.listData.size()) {
            this.cellDataManager.removeData(java.lang.Integer.valueOf(i));
            i2--;
            i3++;
        }
        if (i3 > 0) {
            notifyUpdateList();
        }
    }

    @com.taobao.weex.annotation.JSMethod
    public void resetLoadmore() {
        this.mForceLoadmoreNextTime = true;
        this.mListCellCount = 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.taobao.weex.ui.component.WXComponent
    public void updateProperties(java.util.Map<java.lang.String, java.lang.Object> map) {
        super.updateProperties(map);
        if (map.containsKey("padding") || map.containsKey(com.taobao.weex.common.Constants.Name.PADDING_LEFT) || map.containsKey(com.taobao.weex.common.Constants.Name.PADDING_RIGHT)) {
            if (this.mPaddingLeft == getPadding().get(com.taobao.weex.dom.CSSShorthand.EDGE.LEFT) && this.mPaddingRight == getPadding().get(com.taobao.weex.dom.CSSShorthand.EDGE.RIGHT)) {
                return;
            }
            updateRecyclerAttr();
            ((com.taobao.weex.ui.view.listview.WXRecyclerView) ((com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView) getHostView()).getInnerView()).initView(getContext(), this.mLayoutType, this.mColumnCount, this.mColumnGap, getOrientation());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.taobao.weex.ui.component.WXComponent
    public void addEvent(java.lang.String str) {
        super.addEvent(str);
        if (!com.taobao.weex.ui.component.helper.ScrollStartEndHelper.isScrollEvent(str) || getHostView() == 0 || ((com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView) getHostView()).getInnerView() == null || this.mHasAddScrollEvent) {
            return;
        }
        this.mHasAddScrollEvent = true;
        ((com.taobao.weex.ui.view.listview.WXRecyclerView) ((com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView) getHostView()).getInnerView()).addOnScrollListener(new androidx.recyclerview.widget.RecyclerView.OnScrollListener() { // from class: com.taobao.weex.ui.component.list.template.WXRecyclerTemplateList.7
            private boolean mFirstEvent = true;
            private int offsetXCorrection;
            private int offsetYCorrection;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(androidx.recyclerview.widget.RecyclerView recyclerView, int i, int i2) {
                int i3;
                int i4;
                super.onScrolled(recyclerView, i, i2);
                if (recyclerView.getLayoutManager().canScrollVertically()) {
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
                    com.taobao.weex.ui.component.list.template.WXRecyclerTemplateList.this.getScrollStartEndHelper().onScrolled(i3, i4);
                    if (com.taobao.weex.ui.component.list.template.WXRecyclerTemplateList.this.getEvents().contains("scroll")) {
                        if (!this.mFirstEvent) {
                            if (com.taobao.weex.ui.component.list.template.WXRecyclerTemplateList.this.shouldReport(i3, i4)) {
                                com.taobao.weex.ui.component.list.template.WXRecyclerTemplateList.this.fireScrollEvent(recyclerView, i3, i4);
                                return;
                            }
                            return;
                        }
                        this.mFirstEvent = false;
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fireScrollEvent(androidx.recyclerview.widget.RecyclerView recyclerView, int i, int i2) {
        fireEvent("scroll", getScrollEvent(recyclerView, i, i2));
    }

    public java.util.Map<java.lang.String, java.lang.Object> getScrollEvent(androidx.recyclerview.widget.RecyclerView recyclerView, int i, int i2) {
        int i3 = -calcContentOffset(recyclerView);
        int measuredWidth = recyclerView.getMeasuredWidth() + recyclerView.computeHorizontalScrollRange();
        int iCalcContentSize = calcContentSize();
        java.util.HashMap map = new java.util.HashMap(3);
        java.util.HashMap map2 = new java.util.HashMap(3);
        java.util.HashMap map3 = new java.util.HashMap(3);
        map2.put("width", java.lang.Float.valueOf(com.taobao.weex.utils.WXViewUtils.getWebPxByWidth(measuredWidth, getInstance().getInstanceViewPortWidthWithFloat())));
        map2.put("height", java.lang.Float.valueOf(com.taobao.weex.utils.WXViewUtils.getWebPxByWidth(iCalcContentSize, getInstance().getInstanceViewPortWidthWithFloat())));
        map3.put(com.taobao.weex.common.Constants.Name.X, java.lang.Float.valueOf(-com.taobao.weex.utils.WXViewUtils.getWebPxByWidth(i, getInstance().getInstanceViewPortWidthWithFloat())));
        map3.put(com.taobao.weex.common.Constants.Name.Y, java.lang.Float.valueOf(-com.taobao.weex.utils.WXViewUtils.getWebPxByWidth(i3, getInstance().getInstanceViewPortWidthWithFloat())));
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

    /* JADX WARN: Multi-variable type inference failed */
    private boolean setRefreshOrLoading(final com.taobao.weex.ui.component.WXComponent wXComponent) {
        if ((wXComponent instanceof com.taobao.weex.ui.component.WXRefresh) && getHostView() != 0) {
            ((com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView) getHostView()).setOnRefreshListener((com.taobao.weex.ui.component.WXRefresh) wXComponent);
            ((com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView) getHostView()).postDelayed(com.taobao.weex.common.WXThread.secure(new java.lang.Runnable() { // from class: com.taobao.weex.ui.component.list.template.WXRecyclerTemplateList.8
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    ((com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView) com.taobao.weex.ui.component.list.template.WXRecyclerTemplateList.this.getHostView()).setHeaderView(wXComponent);
                }
            }), 100L);
            return true;
        }
        if (!(wXComponent instanceof com.taobao.weex.ui.component.WXLoading) || getHostView() == 0) {
            return false;
        }
        ((com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView) getHostView()).setOnLoadingListener((com.taobao.weex.ui.component.WXLoading) wXComponent);
        ((com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView) getHostView()).postDelayed(com.taobao.weex.common.WXThread.secure(new java.lang.Runnable() { // from class: com.taobao.weex.ui.component.list.template.WXRecyclerTemplateList.9
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                ((com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView) com.taobao.weex.ui.component.list.template.WXRecyclerTemplateList.this.getHostView()).setFooterView(wXComponent);
            }
        }), 100L);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void removeFooterOrHeader(com.taobao.weex.ui.component.WXComponent wXComponent) {
        if (wXComponent instanceof com.taobao.weex.ui.component.WXLoading) {
            ((com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView) getHostView()).removeFooterView(wXComponent);
        } else if (wXComponent instanceof com.taobao.weex.ui.component.WXRefresh) {
            ((com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView) getHostView()).removeHeaderView(wXComponent);
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

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.dcloud.feature.uniapp.ui.component.AbsVContainer, com.taobao.weex.ui.component.WXComponent
    public void destroy() {
        synchronized (this) {
            if (getHostView() != 0) {
                if (this.mAppearChangeRunnable != null) {
                    ((com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView) getHostView()).removeCallbacks(this.mAppearChangeRunnable);
                    this.mAppearChangeRunnable = null;
                }
                ((com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView) getHostView()).removeCallbacks(this.listUpdateRunnable);
                if (((com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView) getHostView()).getInnerView() != null) {
                    ((com.taobao.weex.ui.view.listview.WXRecyclerView) ((com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView) getHostView()).getInnerView()).setAdapter(null);
                }
            }
            if (this.cellDataManager.listData != null) {
                this.cellDataManager.setListData(null);
            }
            if (this.mStickyHelper != null) {
                this.mStickyHelper = null;
            }
            androidx.collection.ArrayMap<java.lang.String, java.lang.Integer> arrayMap = this.mTemplateViewTypes;
            if (arrayMap != null) {
                arrayMap.clear();
            }
            java.util.Map<java.lang.String, com.taobao.weex.ui.component.list.WXCell> map = this.mTemplateSources;
            if (map != null) {
                map.clear();
            }
            androidx.collection.ArrayMap<java.lang.Integer, java.util.List<com.taobao.weex.ui.component.AppearanceHelper>> arrayMap2 = this.mAppearHelpers;
            if (arrayMap2 != null) {
                arrayMap2.clear();
            }
            androidx.collection.ArrayMap<java.lang.Integer, java.util.Map<java.lang.String, java.util.Map<java.lang.Integer, java.util.List<java.lang.Object>>>> arrayMap3 = this.mDisAppearWatchList;
            if (arrayMap3 != null) {
                arrayMap3.clear();
            }
            super.destroy();
        }
    }

    @Override // com.taobao.weex.ui.view.listview.adapter.IRecyclerAdapterListener
    public void onBindViewHolder(com.taobao.weex.ui.component.list.template.TemplateViewHolder templateViewHolder, int i) {
        com.taobao.weex.ui.component.list.WXCell template;
        if (templateViewHolder == null || (template = templateViewHolder.getTemplate()) == null) {
            return;
        }
        if (templateViewHolder.getHolderPosition() >= 0) {
            fireEvent(com.taobao.weex.ui.component.list.template.TemplateDom.DETACH_CELL_SLOT, com.taobao.weex.ui.component.list.template.TemplateDom.findAllComponentRefs(getRef(), i, template));
        }
        java.lang.System.currentTimeMillis();
        templateViewHolder.setHolderPosition(i);
        java.lang.Object obj = this.cellDataManager.listData.get(i);
        com.taobao.weex.ui.component.list.template.CellRenderState renderState = this.cellDataManager.getRenderState(i);
        if (template.getRenderData() == obj && (renderState == null || !renderState.isDirty())) {
            com.taobao.weex.WXEnvironment.isOpenDebugLog();
            fireEvent(com.taobao.weex.ui.component.list.template.TemplateDom.ATTACH_CELL_SLOT, com.taobao.weex.ui.component.list.template.TemplateDom.findAllComponentRefs(getRef(), i, template));
        } else {
            com.taobao.weex.ui.component.binding.Statements.doInitCompontent(doRenderTemplate(template, i));
            template.setRenderData(obj);
            com.taobao.weex.ui.component.binding.Layouts.doLayoutAsync(templateViewHolder, true);
            com.taobao.weex.WXEnvironment.isOpenDebugLog();
        }
    }

    @Override // com.taobao.weex.ui.view.listview.adapter.IRecyclerAdapterListener
    public com.taobao.weex.ui.component.list.template.TemplateViewHolder onCreateViewHolder(android.view.ViewGroup viewGroup, int i) {
        java.lang.String strKeyAt = this.mTemplateViewTypes.keyAt(i);
        com.taobao.weex.ui.component.list.WXCell wXCell = this.mTemplateSources.get(strKeyAt);
        if (wXCell == null) {
            android.widget.FrameLayout frameLayout = new android.widget.FrameLayout(getContext());
            frameLayout.setLayoutParams(new android.widget.FrameLayout.LayoutParams(0, 0));
            return new com.taobao.weex.ui.component.list.template.TemplateViewHolder(this, frameLayout, i);
        }
        com.taobao.weex.ui.component.list.WXCell cellTemplateFromCache = getCellTemplateFromCache(strKeyAt);
        if (cellTemplateFromCache == null && !wXCell.isSourceUsed()) {
            wXCell.setSourceUsed(true);
            renderTemplateCellWithData(wXCell);
            com.taobao.weex.WXEnvironment.isOpenDebugLog();
            cellTemplateFromCache = wXCell;
        }
        if (cellTemplateFromCache == null) {
            java.lang.System.currentTimeMillis();
            cellTemplateFromCache = (com.taobao.weex.ui.component.list.WXCell) copyComponentFromSourceCell(wXCell);
            com.taobao.weex.WXEnvironment.isOpenDebugLog();
        }
        if (cellTemplateFromCache.isLazy() || cellTemplateFromCache.getHostView() == 0) {
            doCreateCellViewBindData(cellTemplateFromCache, strKeyAt, false);
            com.taobao.weex.WXEnvironment.isOpenDebugLog();
        } else {
            com.taobao.weex.WXEnvironment.isOpenDebugLog();
        }
        return new com.taobao.weex.ui.component.list.template.TemplateViewHolder(this, cellTemplateFromCache, i);
    }

    @Override // com.taobao.weex.ui.view.listview.adapter.IRecyclerAdapterListener
    public int getItemViewType(int i) {
        int iIndexOfKey = this.mTemplateViewTypes.indexOfKey(getTemplateKey(i));
        return iIndexOfKey < 0 ? this.mTemplateViewTypes.indexOfKey("") : iIndexOfKey;
    }

    private java.util.List<com.taobao.weex.ui.component.WXComponent> doRenderTemplate(com.taobao.weex.ui.component.list.WXCell wXCell, int i) {
        this.cellRenderContext.clear();
        java.lang.Object obj = this.cellDataManager.listData.get(i);
        com.taobao.weex.ui.component.list.template.CellRenderState renderState = this.cellDataManager.getRenderState(i);
        this.cellRenderContext.renderState = renderState;
        this.cellRenderContext.templateList = this;
        this.cellRenderContext.position = i;
        com.taobao.weex.el.parse.ArrayStack arrayStack = this.cellRenderContext.stack;
        java.util.Map map = this.cellRenderContext.map;
        if (this.cellDataManager.listData != null) {
            arrayStack.push(map);
            map.put(this.listDataKey, this.cellDataManager.listData);
            if (!android.text.TextUtils.isEmpty(this.listDataIndexKey)) {
                map.put(this.listDataIndexKey, new com.taobao.weex.ui.component.list.template.PositionRef(renderState));
            }
            if (!android.text.TextUtils.isEmpty(this.listDataItemKey)) {
                map.put(this.listDataItemKey, obj);
            } else {
                arrayStack.push(obj);
            }
        }
        if (renderState.itemId <= 0) {
            getItemId(i);
        }
        java.util.List<com.taobao.weex.ui.component.WXComponent> listDoRender = com.taobao.weex.ui.component.binding.Statements.doRender(wXCell, this.cellRenderContext);
        if (renderState.isDirty()) {
            renderState.resetDirty();
        }
        return listDoRender;
    }

    public com.taobao.weex.el.parse.ArrayStack copyStack(com.taobao.weex.ui.component.list.template.CellRenderContext cellRenderContext, com.taobao.weex.el.parse.ArrayStack arrayStack) {
        com.taobao.weex.el.parse.ArrayStack arrayStack2 = new com.taobao.weex.el.parse.ArrayStack();
        for (int i = 0; i < arrayStack.size(); i++) {
            java.lang.Object map = arrayStack.get(i);
            if (map instanceof java.util.Map) {
                map = new java.util.HashMap((java.util.Map) map);
            }
            arrayStack2.push(map);
        }
        return arrayStack2;
    }

    public java.lang.String getTemplateKey(int i) {
        return getTemplateKey(safeGetListData(i));
    }

    public java.lang.String getTemplateKey(java.lang.Object obj) {
        java.lang.String string = obj instanceof com.alibaba.fastjson.JSONObject ? ((com.alibaba.fastjson.JSONObject) obj).getString(this.listDataTemplateKey) : null;
        if (!android.text.TextUtils.isEmpty(string)) {
            return string;
        }
        if (this.defaultTemplateCell != null) {
            return this.defaultTemplateKey;
        }
        return "";
    }

    public com.taobao.weex.ui.component.list.WXCell getSourceTemplate(int i) {
        return this.mTemplateSources.get(getTemplateKey(i));
    }

    private int getCellTemplateItemType(com.taobao.weex.ui.component.list.WXCell wXCell) {
        if (wXCell == null) {
            return -1;
        }
        if (wXCell.getAttrs() == null) {
            return 0;
        }
        java.lang.String string = com.taobao.weex.utils.WXUtils.getString(wXCell.getAttrs().get(com.taobao.weex.common.Constants.Name.Recycler.SLOT_TEMPLATE_CASE), null);
        if (wXCell == this.defaultTemplateCell) {
            string = this.defaultTemplateKey;
        }
        int iIndexOfKey = this.mTemplateViewTypes.indexOfKey(string);
        if (iIndexOfKey < 0) {
            return -1;
        }
        return iIndexOfKey;
    }

    @Override // com.taobao.weex.ui.view.listview.adapter.IRecyclerAdapterListener
    public int getItemCount() {
        androidx.collection.ArrayMap<java.lang.String, java.lang.Integer> arrayMap;
        java.util.Map<java.lang.String, com.taobao.weex.ui.component.list.WXCell> map;
        if (!this.hasLayoutDone || !this.hasAppendTreeDone || this.cellDataManager.listData == null || (arrayMap = this.mTemplateViewTypes) == null || arrayMap.size() <= 1 || (map = this.mTemplateSources) == null || map.size() == 0) {
            return 0;
        }
        return this.cellDataManager.listData.size();
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0035  */
    @Override // com.taobao.weex.ui.view.listview.adapter.IRecyclerAdapterListener
    public long getItemId(int i) {
        com.taobao.weex.ui.component.list.template.CellRenderState renderState = this.cellDataManager.getRenderState(i);
        if (renderState.itemId <= 0) {
            if (android.text.TextUtils.isEmpty(getTemplateKey(i))) {
                return -1L;
            }
            java.lang.Object objSafeGetListData = safeGetListData(i);
            if (objSafeGetListData instanceof com.alibaba.fastjson.JSONObject) {
                com.alibaba.fastjson.JSONObject jSONObject = (com.alibaba.fastjson.JSONObject) objSafeGetListData;
                if (jSONObject.containsKey("keyItemId")) {
                    renderState.itemId = jSONObject.getLongValue("keyItemId");
                } else {
                    renderState.itemId = (((long) java.lang.Math.abs(objSafeGetListData.hashCode())) << 24) + ((long) i);
                }
            } else {
                renderState.itemId = (((long) java.lang.Math.abs(objSafeGetListData.hashCode())) << 24) + ((long) i);
            }
        }
        return renderState.itemId;
    }

    @Override // com.taobao.weex.ui.view.listview.adapter.IOnLoadMoreListener
    public void onBeforeScroll(int i, int i2) {
        com.taobao.weex.ui.component.list.template.TemplateStickyHelper templateStickyHelper = this.mStickyHelper;
        if (templateStickyHelper != null) {
            templateStickyHelper.onBeforeScroll(i, i2);
        }
    }

    @Override // com.taobao.weex.ui.view.listview.adapter.IOnLoadMoreListener
    public void onLoadMore(int i) {
        try {
            java.lang.String loadMoreOffset = getAttrs().getLoadMoreOffset();
            if (android.text.TextUtils.isEmpty(loadMoreOffset)) {
                loadMoreOffset = com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT;
            }
            if (i > com.taobao.weex.utils.WXViewUtils.getRealPxByWidth(java.lang.Integer.parseInt(loadMoreOffset), getInstance().getInstanceViewPortWidthWithFloat()) || this.cellDataManager.listData == null) {
                return;
            }
            if (this.mListCellCount != this.cellDataManager.listData.size() || this.mForceLoadmoreNextTime) {
                fireEvent(com.taobao.weex.common.Constants.Event.LOADMORE);
                this.mListCellCount = this.cellDataManager.listData.size();
                this.mForceLoadmoreNextTime = false;
            }
        } catch (java.lang.Exception e) {
            if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
                com.taobao.weex.utils.WXLogUtils.d("WXRecyclerTemplateList onLoadMore : ", e);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.taobao.weex.ui.view.listview.adapter.IOnLoadMoreListener
    public void notifyAppearStateChange(int i, int i2, int i3, int i4) {
        java.lang.String str;
        int i5;
        java.util.Map<java.lang.Integer, java.util.List<java.lang.Object>> value;
        java.util.List<com.taobao.weex.ui.component.WXComponent> listFindChildListByRef;
        androidx.collection.ArrayMap<java.lang.Integer, java.util.List<com.taobao.weex.ui.component.AppearanceHelper>> arrayMap = this.mAppearHelpers;
        if (arrayMap == null || arrayMap.size() <= 0) {
            return;
        }
        if (this.mAppearChangeRunnable != null) {
            ((com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView) getHostView()).removeCallbacks(this.mAppearChangeRunnable);
            this.mAppearChangeRunnable = null;
        }
        if (i4 > 0) {
            str = "up";
        } else {
            str = i4 < 0 ? "down" : null;
        }
        if (getOrientation() == 0 && i3 != 0) {
            str = i3 > 0 ? "left" : "right";
        }
        androidx.recyclerview.widget.RecyclerView recyclerView = (androidx.recyclerview.widget.RecyclerView) ((com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView) getHostView()).getInnerView();
        int i6 = i;
        while (true) {
            i5 = 0;
            if (i6 > i2) {
                break;
            }
            java.util.List<com.taobao.weex.ui.component.AppearanceHelper> list = this.mAppearHelpers.get(java.lang.Integer.valueOf(getItemViewType(i6)));
            if (list != null) {
                for (com.taobao.weex.ui.component.AppearanceHelper appearanceHelper : list) {
                    if (appearanceHelper.isWatch()) {
                        com.taobao.weex.ui.component.list.template.TemplateViewHolder templateViewHolder = (com.taobao.weex.ui.component.list.template.TemplateViewHolder) recyclerView.findViewHolderForAdapterPosition(i6);
                        if (templateViewHolder == null || templateViewHolder.getComponent() == null || (listFindChildListByRef = findChildListByRef(templateViewHolder.getComponent(), appearanceHelper.getAwareChild().getRef())) == null || listFindChildListByRef.size() == 0) {
                            break;
                        }
                        java.util.Map<java.lang.String, java.util.Map<java.lang.Integer, java.util.List<java.lang.Object>>> arrayMap2 = this.mDisAppearWatchList.get(java.lang.Integer.valueOf(i6));
                        if (arrayMap2 == null) {
                            arrayMap2 = new androidx.collection.ArrayMap<>();
                            this.mDisAppearWatchList.put(java.lang.Integer.valueOf(i6), arrayMap2);
                        }
                        java.util.Map<java.lang.Integer, java.util.List<java.lang.Object>> arrayMap3 = arrayMap2.get(appearanceHelper.getAwareChild().getRef());
                        if (arrayMap3 == null) {
                            arrayMap3 = new androidx.collection.ArrayMap<>();
                            arrayMap2.put(appearanceHelper.getAwareChild().getRef(), arrayMap3);
                        }
                        for (int i7 = 0; i7 < listFindChildListByRef.size(); i7++) {
                            com.taobao.weex.ui.component.WXComponent wXComponent = listFindChildListByRef.get(i7);
                            if (wXComponent.getHostView() != null) {
                                boolean zIsViewVisible = appearanceHelper.isViewVisible(wXComponent.getHostView());
                                int iHashCode = wXComponent.getHostView().hashCode();
                                if (zIsViewVisible) {
                                    if (!arrayMap3.containsKey(java.lang.Integer.valueOf(iHashCode))) {
                                        wXComponent.notifyAppearStateChange(com.taobao.weex.common.Constants.Event.APPEAR, str);
                                        arrayMap3.put(java.lang.Integer.valueOf(iHashCode), (wXComponent.getEvents() == null || wXComponent.getEvents().getEventBindingArgsValues() == null || wXComponent.getEvents().getEventBindingArgsValues().get(com.taobao.weex.common.Constants.Event.DISAPPEAR) == null) ? null : wXComponent.getEvents().getEventBindingArgsValues().get(com.taobao.weex.common.Constants.Event.DISAPPEAR));
                                    }
                                } else if (arrayMap3.containsKey(java.lang.Integer.valueOf(iHashCode))) {
                                    wXComponent.notifyAppearStateChange(com.taobao.weex.common.Constants.Event.DISAPPEAR, str);
                                    arrayMap3.remove(java.lang.Integer.valueOf(iHashCode));
                                }
                            }
                        }
                    }
                }
            }
            i6++;
        }
        int itemCount = getItemCount();
        while (i5 < itemCount) {
            if (i5 < i || i5 > i2) {
                java.util.Map<java.lang.String, java.util.Map<java.lang.Integer, java.util.List<java.lang.Object>>> map = this.mDisAppearWatchList.get(java.lang.Integer.valueOf(i5));
                if (map != null) {
                    com.taobao.weex.ui.component.list.WXCell wXCell = this.mTemplateSources.get(getTemplateKey(i5));
                    if (wXCell == null) {
                        return;
                    }
                    for (java.util.Map.Entry<java.lang.String, java.util.Map<java.lang.Integer, java.util.List<java.lang.Object>>> entry : map.entrySet()) {
                        com.taobao.weex.ui.component.WXComponent wXComponentFindChildByRef = findChildByRef(wXCell, entry.getKey());
                        if (wXComponentFindChildByRef != null && (value = entry.getValue()) != null && value.size() != 0) {
                            com.taobao.weex.dom.WXEvent events = wXComponentFindChildByRef.getEvents();
                            java.util.Iterator<java.util.Map.Entry<java.lang.Integer, java.util.List<java.lang.Object>>> it = value.entrySet().iterator();
                            while (it.hasNext()) {
                                events.putEventBindingArgsValue(com.taobao.weex.common.Constants.Event.DISAPPEAR, it.next().getValue());
                                wXComponentFindChildByRef.notifyAppearStateChange(com.taobao.weex.common.Constants.Event.DISAPPEAR, str);
                            }
                            value.clear();
                        }
                    }
                    this.mDisAppearWatchList.remove(java.lang.Integer.valueOf(i5));
                } else {
                    continue;
                }
            } else {
                i5 = i2 + 1;
            }
            i5++;
        }
    }

    private java.lang.Object safeGetListData(int i) {
        try {
            return this.cellDataManager.listData.get(i);
        } catch (java.lang.Exception unused) {
            return com.alibaba.fastjson.JSONObject.parseObject("{}");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void notifyUpdateList() {
        if (getHostView() == 0 || ((com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView) getHostView()).getInnerView() == null || this.listUpdateRunnable == null) {
            return;
        }
        if (android.os.Looper.getMainLooper().getThread().getId() != java.lang.Thread.currentThread().getId()) {
            ((com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView) getHostView()).removeCallbacks(this.listUpdateRunnable);
            ((com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView) getHostView()).post(this.listUpdateRunnable);
        } else {
            this.listUpdateRunnable.run();
        }
    }

    private int calcContentSize() {
        if (this.cellDataManager.listData == null) {
            return 0;
        }
        int layoutHeight = 0;
        for (int i = 0; i < this.cellDataManager.listData.size(); i++) {
            com.taobao.weex.ui.component.list.WXCell sourceTemplate = getSourceTemplate(i);
            if (sourceTemplate != null) {
                layoutHeight = (int) (layoutHeight + sourceTemplate.getLayoutHeight());
            }
        }
        return layoutHeight;
    }

    public int calcContentOffset(androidx.recyclerview.widget.RecyclerView recyclerView) {
        androidx.recyclerview.widget.RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        int i = 0;
        if (layoutManager instanceof androidx.recyclerview.widget.LinearLayoutManager) {
            int iFindFirstVisibleItemPosition = ((androidx.recyclerview.widget.LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
            int spanCount = 0;
            while (i < iFindFirstVisibleItemPosition) {
                com.taobao.weex.ui.component.list.WXCell sourceTemplate = getSourceTemplate(i);
                if (sourceTemplate != null) {
                    spanCount = (int) (spanCount - sourceTemplate.getLayoutHeight());
                }
                i++;
            }
            if (layoutManager instanceof androidx.recyclerview.widget.GridLayoutManager) {
                spanCount /= ((androidx.recyclerview.widget.GridLayoutManager) layoutManager).getSpanCount();
            }
            android.view.View viewFindViewByPosition = layoutManager.findViewByPosition(iFindFirstVisibleItemPosition);
            return viewFindViewByPosition != null ? spanCount + viewFindViewByPosition.getTop() : spanCount;
        }
        if (!(layoutManager instanceof androidx.recyclerview.widget.StaggeredGridLayoutManager)) {
            return -1;
        }
        androidx.recyclerview.widget.StaggeredGridLayoutManager staggeredGridLayoutManager = (androidx.recyclerview.widget.StaggeredGridLayoutManager) layoutManager;
        int spanCount2 = staggeredGridLayoutManager.getSpanCount();
        int i2 = staggeredGridLayoutManager.findFirstVisibleItemPositions(null)[0];
        int layoutHeight = 0;
        while (i < i2) {
            com.taobao.weex.ui.component.list.WXCell sourceTemplate2 = getSourceTemplate(i);
            if (sourceTemplate2 != null) {
                layoutHeight = (int) (layoutHeight - sourceTemplate2.getLayoutHeight());
            }
            i++;
        }
        int i3 = layoutHeight / spanCount2;
        android.view.View viewFindViewByPosition2 = layoutManager.findViewByPosition(i2);
        return viewFindViewByPosition2 != null ? i3 + viewFindViewByPosition2.getTop() : i3;
    }

    public com.taobao.weex.ui.component.WXComponent findParentType(com.taobao.weex.ui.component.WXComponent wXComponent, java.lang.Class cls) {
        if (cls.isAssignableFrom(wXComponent.getClass())) {
            return wXComponent;
        }
        if (wXComponent.getParent() == null) {
            return null;
        }
        findTypeParent(wXComponent.getParent(), cls);
        return null;
    }

    public com.taobao.weex.ui.component.WXComponent findChildByRef(com.taobao.weex.ui.component.WXComponent wXComponent, java.lang.String str) {
        if (str.equals(wXComponent.getRef())) {
            return wXComponent;
        }
        if (!(wXComponent instanceof com.taobao.weex.ui.component.WXVContainer)) {
            return null;
        }
        com.taobao.weex.ui.component.WXVContainer wXVContainer = (com.taobao.weex.ui.component.WXVContainer) wXComponent;
        for (int i = 0; i < wXVContainer.getChildCount(); i++) {
            com.taobao.weex.ui.component.WXComponent wXComponentFindChildByRef = findChildByRef(wXVContainer.getChild(i), str);
            if (wXComponentFindChildByRef != null) {
                return wXComponentFindChildByRef;
            }
        }
        return null;
    }

    public java.util.List<com.taobao.weex.ui.component.WXComponent> findChildListByRef(com.taobao.weex.ui.component.WXComponent wXComponent, java.lang.String str) {
        com.taobao.weex.ui.component.WXComponent wXComponentFindChildByRef = findChildByRef(wXComponent, str);
        if (wXComponentFindChildByRef == null) {
            return null;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        com.taobao.weex.ui.component.WXVContainer parent = wXComponentFindChildByRef.getParent();
        if (parent != null && !(parent instanceof com.taobao.weex.ui.component.list.template.WXRecyclerTemplateList)) {
            for (int i = 0; i < parent.getChildCount(); i++) {
                com.taobao.weex.ui.component.WXComponent child = parent.getChild(i);
                if (str.equals(child.getRef())) {
                    arrayList.add(child);
                }
            }
            return arrayList;
        }
        arrayList.add(wXComponentFindChildByRef);
        return arrayList;
    }

    public com.taobao.weex.ui.component.WXComponent findChildByAttrsRef(com.taobao.weex.ui.component.WXComponent wXComponent, java.lang.String str) {
        if (wXComponent.getAttrs() != null && str.equals(wXComponent.getAttrs().get("ref"))) {
            return wXComponent;
        }
        if (!(wXComponent instanceof com.taobao.weex.ui.component.WXVContainer)) {
            return null;
        }
        com.taobao.weex.ui.component.WXVContainer wXVContainer = (com.taobao.weex.ui.component.WXVContainer) wXComponent;
        for (int i = 0; i < wXVContainer.getChildCount(); i++) {
            com.taobao.weex.ui.component.WXComponent wXComponentFindChildByAttrsRef = findChildByAttrsRef(wXVContainer.getChild(i), str);
            if (wXComponentFindChildByAttrsRef != null) {
                return wXComponentFindChildByAttrsRef;
            }
        }
        return null;
    }

    private com.taobao.weex.ui.component.list.WXCell getCellTemplateFromCache(java.lang.String str) {
        com.taobao.weex.ui.component.list.template.TemplateCache templateCache = this.mTemplatesCache.get(str);
        com.taobao.weex.ui.component.list.WXCell wXCellPoll = (templateCache == null || templateCache.cells == null || templateCache.cells.size() <= 0) ? null : templateCache.cells.poll();
        if (templateCache == null || !templateCache.isLoadIng) {
            if (templateCache == null) {
                templateCache = new com.taobao.weex.ui.component.list.template.TemplateCache();
                this.mTemplatesCache.put(str, templateCache);
            }
            templateCache.isLoadIng = true;
            com.taobao.weex.ui.component.list.WXCell wXCell = this.mTemplateSources.get(str);
            if (wXCell != null && com.taobao.weex.utils.WXUtils.getBoolean(wXCell.getAttrs().get("preload"), true).booleanValue()) {
                new com.taobao.weex.ui.component.list.template.AsyncCellLoadTask(str, wXCell, this).startTask();
            }
        }
        return wXCellPoll;
    }

    public com.taobao.weex.ui.component.WXComponent copyComponentFromSourceCell(com.taobao.weex.ui.component.list.WXCell wXCell) {
        renderTemplateCellWithData(wXCell);
        return (com.taobao.weex.ui.component.list.WXCell) com.taobao.weex.ui.component.binding.Statements.copyComponentTree(wXCell);
    }

    private synchronized void renderTemplateCellWithData(com.taobao.weex.ui.component.list.WXCell wXCell) {
        if (wXCell.getRenderData() == null && this.cellDataManager.listData != null && this.cellDataManager.listData.size() > 0) {
            synchronized (this) {
                if (wXCell.getRenderData() == null) {
                    com.taobao.weex.ui.component.binding.Statements.parseStatementsToken(wXCell);
                    for (int i = 0; i < this.cellDataManager.listData.size(); i++) {
                        if (wXCell == getSourceTemplate(i)) {
                            java.lang.Object obj = this.cellDataManager.listData.get(i);
                            doRenderTemplate(wXCell, i);
                            com.taobao.weex.ui.component.binding.Layouts.doLayoutSync(wXCell, getLayoutWidth(), getLayoutHeight());
                            wXCell.setRenderData(obj);
                            break;
                        }
                    }
                }
            }
        }
    }

    public static void doCreateCellViewBindData(com.taobao.weex.ui.component.list.WXCell wXCell, java.lang.String str, boolean z) {
        if (wXCell.isLazy() || wXCell.getHostView() == 0) {
            java.lang.System.currentTimeMillis();
            com.taobao.weex.ui.component.binding.Statements.initLazyComponent(wXCell, null);
            com.taobao.weex.WXEnvironment.isOpenDebugLog();
        }
    }

    public com.taobao.weex.ui.component.helper.ScrollStartEndHelper getScrollStartEndHelper() {
        if (this.mScrollStartEndHelper == null) {
            this.mScrollStartEndHelper = new com.taobao.weex.ui.component.helper.ScrollStartEndHelper(this);
        }
        return this.mScrollStartEndHelper;
    }

    public int getTemplateCacheSize() {
        return this.templateCacheSize;
    }

    public java.util.concurrent.ConcurrentHashMap<java.lang.String, com.taobao.weex.ui.component.list.template.TemplateCache> getTemplatesCache() {
        if (this.mTemplatesCache == null) {
            this.mTemplatesCache = new java.util.concurrent.ConcurrentHashMap<>();
        }
        return this.mTemplatesCache;
    }

    public com.taobao.weex.ui.component.list.template.CellDataManager getCellDataManager() {
        return this.cellDataManager;
    }

    private com.alibaba.fastjson.JSONArray parseListDataToJSONArray(java.lang.Object obj) {
        try {
            if (obj instanceof com.alibaba.fastjson.JSONArray) {
                return (com.alibaba.fastjson.JSONArray) obj;
            }
            if (obj instanceof java.lang.String) {
                return com.alibaba.fastjson.JSONArray.parseArray(getAttrs().get(com.taobao.weex.common.Constants.Name.Recycler.LIST_DATA).toString());
            }
            return new com.alibaba.fastjson.JSONArray();
        } catch (java.lang.Exception e) {
            com.taobao.weex.utils.WXLogUtils.e(TAG, "parseListDataException" + e.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @com.taobao.weex.ui.component.WXComponentProp(name = com.taobao.weex.common.Constants.Name.SCROLL_TOP)
    public void setScrollTop(java.lang.String str) {
        com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView bounceRecyclerView = (com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView) getHostView();
        if (bounceRecyclerView == null) {
            return;
        }
        ((com.taobao.weex.ui.view.listview.WXRecyclerView) bounceRecyclerView.getInnerView()).scrollTo(0, (int) com.taobao.weex.utils.WXViewUtils.getRealPxByWidth(com.taobao.weex.utils.WXUtils.getFloat(str), getInstance().getInstanceViewPortWidthWithFloat()), getAttrs().getOrientation());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @com.taobao.weex.ui.component.WXComponentProp(name = com.taobao.weex.common.Constants.Name.SCROLL_LEFT)
    public void setScrollLeft(java.lang.String str) {
        com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView bounceRecyclerView = (com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView) getHostView();
        if (bounceRecyclerView == null) {
            return;
        }
        ((com.taobao.weex.ui.view.listview.WXRecyclerView) bounceRecyclerView.getInnerView()).scrollTo((int) com.taobao.weex.utils.WXViewUtils.getRealPxByWidth(com.taobao.weex.utils.WXUtils.getFloat(str), getInstance().getInstanceViewPortWidthWithFloat()), 0, getAttrs().getOrientation());
    }

    @Override // io.dcloud.feature.uniapp.ui.component.AbsBasicComponent
    public void setIsLayoutRTL(boolean z) {
        super.setIsLayoutRTL(z);
        this.mViewOnScrollListener.setLayoutRTL(isLayoutRTL());
    }
}
