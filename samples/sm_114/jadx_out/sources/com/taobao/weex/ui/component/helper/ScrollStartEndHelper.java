package com.taobao.weex.ui.component.helper;

/* JADX INFO: loaded from: classes.dex */
public class ScrollStartEndHelper implements java.lang.Runnable {
    private com.taobao.weex.ui.component.WXComponent component;
    private boolean hasScrollEnd;
    private boolean hasStart;
    private long minInterval;
    private int x;
    private int y;
    private boolean canStart = false;
    private int oldState = 0;
    private android.os.Handler handler = new android.os.Handler(android.os.Looper.getMainLooper());

    public ScrollStartEndHelper(com.taobao.weex.ui.component.WXComponent wXComponent) {
        this.component = wXComponent;
        this.minInterval = com.taobao.weex.utils.WXUtils.getNumberInt(wXComponent.getAttrs().get("minscrolldelayinterval"), 32);
    }

    public void onScrolled(int i, int i2) {
        java.util.Map<java.lang.String, java.lang.Object> scrollEvent;
        if (this.component.getEvents().contains(com.taobao.weex.common.Constants.Event.SCROLL_START) || this.component.getEvents().contains(com.taobao.weex.common.Constants.Event.SCROLL_END)) {
            this.x = i;
            this.y = i2;
            if (!this.hasStart && this.canStart) {
                if (this.component.getEvents().contains(com.taobao.weex.common.Constants.Event.SCROLL_START) && (scrollEvent = getScrollEvent(i, i2)) != null && !scrollEvent.isEmpty()) {
                    this.component.fireEvent(com.taobao.weex.common.Constants.Event.SCROLL_START, scrollEvent);
                }
                this.hasStart = true;
                this.canStart = false;
            }
            this.handler.removeCallbacks(this);
            this.handler.postDelayed(this, this.minInterval);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!this.component.isDestoryed() && this.hasScrollEnd) {
            if (this.canStart) {
                this.component.fireEvent(com.taobao.weex.common.Constants.Event.SCROLL_START, getScrollEvent(this.x, this.y));
                this.canStart = false;
            }
            if (this.component.getEvents().contains(com.taobao.weex.common.Constants.Event.SCROLL_END)) {
                this.component.fireEvent(com.taobao.weex.common.Constants.Event.SCROLL_END, getScrollEvent(this.x, this.y));
            }
            this.hasStart = false;
            this.hasScrollEnd = false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private java.util.Map<java.lang.String, java.lang.Object> getScrollEvent(int i, int i2) {
        com.taobao.weex.ui.component.list.ListComponentView listComponentView;
        com.taobao.weex.ui.component.WXComponent wXComponent = this.component;
        if (wXComponent instanceof com.taobao.weex.ui.component.list.BasicListComponent) {
            com.taobao.weex.ui.component.list.BasicListComponent basicListComponent = (com.taobao.weex.ui.component.list.BasicListComponent) wXComponent;
            if (!(basicListComponent.getHostView() instanceof com.taobao.weex.ui.component.list.ListComponentView) || (listComponentView = (com.taobao.weex.ui.component.list.ListComponentView) basicListComponent.getHostView()) == null) {
                return null;
            }
            return basicListComponent.getScrollEvent(listComponentView.getInnerView(), i, i2);
        }
        if (wXComponent instanceof com.taobao.weex.ui.component.list.template.WXRecyclerTemplateList) {
            com.taobao.weex.ui.component.list.template.WXRecyclerTemplateList wXRecyclerTemplateList = (com.taobao.weex.ui.component.list.template.WXRecyclerTemplateList) wXComponent;
            return wXRecyclerTemplateList.getScrollEvent((androidx.recyclerview.widget.RecyclerView) ((com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView) wXRecyclerTemplateList.getHostView()).getInnerView(), i, i2);
        }
        if (wXComponent instanceof com.taobao.weex.ui.component.DCWXScroller) {
            return ((com.taobao.weex.ui.component.DCWXScroller) wXComponent).getScrollEvent(i, i2);
        }
        if (wXComponent instanceof com.taobao.weex.ui.component.WXBaseScroller) {
            return ((com.taobao.weex.ui.component.WXBaseScroller) wXComponent).getScrollEvent(i, i2);
        }
        return null;
    }

    public void onScrollStateChanged(int i) {
        if (this.oldState == 0) {
            this.canStart = true;
        }
        if (i == 0) {
            this.hasScrollEnd = true;
            this.handler.removeCallbacks(this);
            this.handler.postDelayed(this, this.minInterval);
        }
        this.oldState = i;
    }

    public static boolean isScrollEvent(java.lang.String str) {
        return "scroll".equals(str) || com.taobao.weex.common.Constants.Event.SCROLL_START.equals(str) || com.taobao.weex.common.Constants.Event.SCROLL_END.equals(str);
    }
}
