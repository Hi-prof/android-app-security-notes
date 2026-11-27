package com.taobao.weex.ui.view.refresh.wrapper;

/* JADX INFO: loaded from: classes.dex */
public class BounceRecyclerView extends com.taobao.weex.ui.view.refresh.wrapper.BaseBounceView<com.taobao.weex.ui.view.listview.WXRecyclerView> implements com.taobao.weex.ui.component.list.ListComponentView, com.taobao.weex.ui.view.gesture.WXGestureObservable {
    public static final int DEFAULT_COLUMN_COUNT = 1;
    public static final int DEFAULT_COLUMN_GAP = 1;
    private com.taobao.weex.ui.view.listview.adapter.RecyclerViewBaseAdapter adapter;
    private int mColumnCount;
    private float mColumnGap;
    private int mLayoutType;
    private int mOrientation;
    private com.taobao.weex.ui.component.list.StickyHeaderHelper mStickyHeaderHelper;

    @Override // com.taobao.weex.ui.view.refresh.wrapper.BaseBounceView, com.taobao.weex.ui.component.list.ListComponentView
    public /* bridge */ /* synthetic */ com.taobao.weex.ui.view.listview.WXRecyclerView getInnerView() {
        return (com.taobao.weex.ui.view.listview.WXRecyclerView) super.getInnerView();
    }

    public BounceRecyclerView(android.content.Context context, int i, int i2, float f, int i3) {
        super(context, i3);
        this.adapter = null;
        this.mLayoutType = i;
        this.mColumnCount = i2;
        this.mColumnGap = f;
        this.mOrientation = i3;
        init(context);
        this.mStickyHeaderHelper = new com.taobao.weex.ui.component.list.StickyHeaderHelper(this);
    }

    public BounceRecyclerView(android.content.Context context, int i, int i2) {
        this(context, i, 1, 1.0f, i2);
    }

    @Override // com.taobao.weex.ui.component.list.ListComponentView
    public void setRecyclerViewBaseAdapter(com.taobao.weex.ui.view.listview.adapter.RecyclerViewBaseAdapter recyclerViewBaseAdapter) {
        this.adapter = recyclerViewBaseAdapter;
        if (getInnerView() != null) {
            ((com.taobao.weex.ui.view.listview.WXRecyclerView) getInnerView()).setAdapter(recyclerViewBaseAdapter);
        }
    }

    @Override // com.taobao.weex.ui.component.list.ListComponentView
    public com.taobao.weex.ui.view.listview.adapter.RecyclerViewBaseAdapter getRecyclerViewBaseAdapter() {
        return this.adapter;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.taobao.weex.ui.view.refresh.wrapper.BaseBounceView
    public com.taobao.weex.ui.view.listview.WXRecyclerView setInnerView(android.content.Context context) {
        com.taobao.weex.ui.view.listview.WXRecyclerView wXRecyclerView;
        int next;
        if (com.taobao.weex.R.layout.weex_recycler_layout != 0) {
            android.content.res.XmlResourceParser xml = getResources().getXml(com.taobao.weex.R.layout.weex_recycler_layout);
            android.util.AttributeSet attributeSetAsAttributeSet = android.util.Xml.asAttributeSet(xml);
            do {
                try {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
            } while (next != 1);
            wXRecyclerView = new com.taobao.weex.ui.view.listview.WXRecyclerView(context, attributeSetAsAttributeSet);
            wXRecyclerView.setScrollBarStyle(33554432);
            try {
                java.lang.reflect.Method declaredMethod = android.view.View.class.getDeclaredMethod("initializeScrollbars", android.content.res.TypedArray.class);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(wXRecyclerView, null);
            } catch (java.lang.Exception e2) {
                e2.printStackTrace();
            }
            if (this.mOrientation == 1) {
                wXRecyclerView.setVerticalScrollBarEnabled(true);
            } else {
                wXRecyclerView.setHorizontalScrollBarEnabled(true);
            }
        } else {
            wXRecyclerView = new com.taobao.weex.ui.view.listview.WXRecyclerView(context);
        }
        com.taobao.weex.ui.view.listview.WXRecyclerView wXRecyclerView2 = wXRecyclerView;
        wXRecyclerView2.setOverScrollMode(0);
        wXRecyclerView2.initView(context, this.mLayoutType, this.mColumnCount, this.mColumnGap, getOrientation());
        return wXRecyclerView2;
    }

    @Override // com.taobao.weex.ui.view.refresh.wrapper.BaseBounceView
    public void onRefreshingComplete() {
        com.taobao.weex.ui.view.listview.adapter.RecyclerViewBaseAdapter recyclerViewBaseAdapter = this.adapter;
        if (recyclerViewBaseAdapter != null) {
            recyclerViewBaseAdapter.notifyDataSetChanged();
        }
    }

    @Override // com.taobao.weex.ui.view.refresh.wrapper.BaseBounceView
    public void onLoadmoreComplete() {
        com.taobao.weex.ui.view.listview.adapter.RecyclerViewBaseAdapter recyclerViewBaseAdapter = this.adapter;
        if (recyclerViewBaseAdapter != null) {
            recyclerViewBaseAdapter.notifyDataSetChanged();
        }
    }

    @Override // com.taobao.weex.ui.component.list.ListComponentView
    public void notifyStickyShow(com.taobao.weex.ui.component.list.WXCell wXCell) {
        this.mStickyHeaderHelper.notifyStickyShow(wXCell);
    }

    @Override // com.taobao.weex.ui.component.list.ListComponentView
    public void updateStickyView(int i) {
        this.mStickyHeaderHelper.updateStickyView(i);
    }

    @Override // com.taobao.weex.ui.component.list.ListComponentView
    public void notifyStickyRemove(com.taobao.weex.ui.component.list.WXCell wXCell) {
        this.mStickyHeaderHelper.notifyStickyRemove(wXCell);
    }

    public com.taobao.weex.ui.component.list.StickyHeaderHelper getStickyHeaderHelper() {
        return this.mStickyHeaderHelper;
    }

    @Override // com.taobao.weex.ui.view.gesture.WXGestureObservable
    public void registerGestureListener(com.taobao.weex.ui.view.gesture.WXGesture wXGesture) {
        ((com.taobao.weex.ui.view.listview.WXRecyclerView) getInnerView()).registerGestureListener(wXGesture);
    }

    @Override // com.taobao.weex.ui.view.gesture.WXGestureObservable
    public com.taobao.weex.ui.view.gesture.WXGesture getGestureListener() {
        return ((com.taobao.weex.ui.view.listview.WXRecyclerView) getInnerView()).getGestureListener();
    }
}
