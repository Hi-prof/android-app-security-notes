package io.dcloud.feature.weex_scroller.view;

/* JADX INFO: loaded from: classes2.dex */
public class WXStickyHelper {
    private com.taobao.weex.ui.component.Scrollable scrollable;

    public WXStickyHelper(com.taobao.weex.ui.component.Scrollable scrollable) {
        this.scrollable = scrollable;
    }

    public void bindStickStyle(com.taobao.weex.ui.component.WXComponent wXComponent, java.util.Map<java.lang.String, java.util.Map<java.lang.String, com.taobao.weex.ui.component.WXComponent>> map) {
        com.taobao.weex.ui.component.Scrollable parentScroller = wXComponent.getParentScroller();
        if (parentScroller == null) {
            return;
        }
        java.util.Map<java.lang.String, com.taobao.weex.ui.component.WXComponent> concurrentHashMap = map.get(parentScroller.getRef());
        if (concurrentHashMap == null) {
            concurrentHashMap = new java.util.concurrent.ConcurrentHashMap<>();
        }
        if (concurrentHashMap.containsKey(wXComponent.getRef())) {
            return;
        }
        concurrentHashMap.put(wXComponent.getRef(), wXComponent);
        map.put(parentScroller.getRef(), concurrentHashMap);
    }

    public void unbindStickStyle(com.taobao.weex.ui.component.WXComponent wXComponent, java.util.Map<java.lang.String, java.util.Map<java.lang.String, com.taobao.weex.ui.component.WXComponent>> map) {
        java.util.Map<java.lang.String, com.taobao.weex.ui.component.WXComponent> map2;
        com.taobao.weex.ui.component.Scrollable parentScroller = wXComponent.getParentScroller();
        if (parentScroller == null || (map2 = map.get(parentScroller.getRef())) == null) {
            return;
        }
        map2.remove(wXComponent.getRef());
    }
}
