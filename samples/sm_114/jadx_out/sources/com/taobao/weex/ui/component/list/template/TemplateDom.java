package com.taobao.weex.ui.component.list.template;

/* JADX INFO: loaded from: classes.dex */
public class TemplateDom {
    public static final java.lang.String ATTACH_CELL_SLOT = "_attach_slot";
    public static final java.lang.String ATTRS_KEY_REF = "ref";
    public static final java.lang.String DETACH_CELL_SLOT = "_detach_slot";
    public static final java.lang.String KEY_ATTRS = "attrs";
    public static final java.lang.String KEY_RESET_ANIMATION = "resetAnimation";
    public static final java.lang.String KEY_TYPE = "type";
    public static final java.lang.String KEY_VIRTUAL_DOM_REF = "ref";
    public static final char SEPARATOR = '@';
    public static final java.lang.String VIRTUAL_DOM_IDENTIFY = "[[VirtualElement]]";

    public static java.lang.String genKeyVirtualDomRef(java.lang.String str, int i, java.lang.String str2) {
        return str + SEPARATOR + i + SEPARATOR + str2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static com.taobao.weex.ui.component.WXComponent findVirtualComponentByVRef(java.lang.String str, java.lang.String str2) {
        try {
            java.lang.String[] strArrSplit = str2.split("@");
            com.taobao.weex.ui.component.WXComponent wXComponent = com.taobao.weex.WXSDKManager.getInstance().getWXRenderManager().getWXComponent(str, strArrSplit[0]);
            if (!(wXComponent instanceof com.taobao.weex.ui.component.list.template.WXRecyclerTemplateList)) {
                return null;
            }
            com.taobao.weex.ui.component.list.template.WXRecyclerTemplateList wXRecyclerTemplateList = (com.taobao.weex.ui.component.list.template.WXRecyclerTemplateList) wXComponent;
            if (wXRecyclerTemplateList.getHostView() != 0 && ((com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView) wXRecyclerTemplateList.getHostView()).getInnerView() != null) {
                com.taobao.weex.ui.component.list.template.TemplateViewHolder templateViewHolder = (com.taobao.weex.ui.component.list.template.TemplateViewHolder) ((com.taobao.weex.ui.view.listview.WXRecyclerView) ((com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView) wXRecyclerTemplateList.getHostView()).getInnerView()).findViewHolderForAdapterPosition(java.lang.Integer.parseInt(strArrSplit[1]));
                if (templateViewHolder == null) {
                    return null;
                }
                return findComponentByViewTreeKey(templateViewHolder.getTemplate(), strArrSplit[2]);
            }
        } catch (java.lang.Exception unused) {
        }
        return null;
    }

    public static java.util.Map<java.lang.String, java.lang.Object> findAllComponentRefs(java.lang.String str, int i, com.taobao.weex.ui.component.WXComponent wXComponent) {
        java.util.HashMap map = new java.util.HashMap();
        findAllComponentRefs(str, i, wXComponent, map);
        java.util.HashMap map2 = new java.util.HashMap();
        map2.put("refs", map);
        map2.put("position", java.lang.Integer.valueOf(i));
        map2.put("listRef", str);
        return map2;
    }

    private static void findAllComponentRefs(java.lang.String str, int i, com.taobao.weex.ui.component.WXComponent wXComponent, java.util.Map<java.lang.String, java.lang.Object> map) {
        if (wXComponent.isWaste()) {
            return;
        }
        if (wXComponent instanceof com.taobao.weex.ui.component.WXVContainer) {
            com.taobao.weex.ui.component.WXVContainer wXVContainer = (com.taobao.weex.ui.component.WXVContainer) wXComponent;
            for (int i2 = 0; i2 < wXVContainer.getChildCount(); i2++) {
                findAllComponentRefs(str, i, wXVContainer.getChild(i2), map);
            }
        }
        com.taobao.weex.dom.WXAttr attrs = wXComponent.getAttrs();
        if (attrs == null || attrs.get("ref") != null) {
            java.lang.String string = attrs.get("ref").toString();
            java.util.List arrayList = (java.util.List) map.get(string);
            if (arrayList == null) {
                arrayList = new java.util.ArrayList();
                map.put(string, arrayList);
            }
            arrayList.add(toMap(str, i, wXComponent));
        }
    }

    public static java.util.Map toMap(java.lang.String str, int i, com.taobao.weex.ui.component.WXComponent wXComponent) {
        java.util.HashMap map = new java.util.HashMap();
        map.put(KEY_ATTRS, wXComponent.getAttrs());
        map.put("type", wXComponent.getComponentType());
        map.put("ref", genKeyVirtualDomRef(str, i, wXComponent.getViewTreeKey()));
        map.put(VIRTUAL_DOM_IDENTIFY, true);
        return map;
    }

    public static boolean isVirtualDomRef(java.lang.String str) {
        return str != null && str.indexOf(64) > 0;
    }

    public static void resetAnimaiton(android.view.View view) {
        if (view == null) {
            return;
        }
        if (androidx.core.view.ViewCompat.getTranslationX(view) != 0.0f) {
            androidx.core.view.ViewCompat.setTranslationX(view, 0.0f);
        }
        if (androidx.core.view.ViewCompat.getTranslationY(view) != 0.0f) {
            androidx.core.view.ViewCompat.setTranslationY(view, 0.0f);
        }
        if (androidx.core.view.ViewCompat.getTranslationZ(view) != 0.0f) {
            androidx.core.view.ViewCompat.setTranslationZ(view, 0.0f);
        }
        if (androidx.core.view.ViewCompat.getScaleX(view) != 1.0f) {
            androidx.core.view.ViewCompat.setScaleX(view, 1.0f);
        }
        if (androidx.core.view.ViewCompat.getScaleY(view) != 1.0f) {
            androidx.core.view.ViewCompat.setScaleY(view, 1.0f);
        }
        if (androidx.core.view.ViewCompat.getRotationX(view) != 0.0f) {
            androidx.core.view.ViewCompat.setRotationX(view, 0.0f);
        }
        if (androidx.core.view.ViewCompat.getRotationY(view) != 0.0f) {
            androidx.core.view.ViewCompat.setRotationY(view, 0.0f);
        }
        if (androidx.core.view.ViewCompat.getElevation(view) != 0.0f) {
            androidx.core.view.ViewCompat.setElevation(view, 0.0f);
        }
    }

    public static final com.taobao.weex.ui.component.WXComponent findComponentByViewTreeKey(com.taobao.weex.ui.component.WXComponent wXComponent, java.lang.String str) {
        if (wXComponent.getViewTreeKey().equals(str)) {
            return wXComponent;
        }
        if (!(wXComponent instanceof com.taobao.weex.ui.component.WXVContainer)) {
            return null;
        }
        com.taobao.weex.ui.component.WXVContainer wXVContainer = (com.taobao.weex.ui.component.WXVContainer) wXComponent;
        for (int i = 0; i < wXVContainer.getChildCount(); i++) {
            com.taobao.weex.ui.component.WXComponent child = wXVContainer.getChild(i);
            if (findComponentByViewTreeKey(child, str) != null) {
                return child;
            }
        }
        return null;
    }

    private static com.taobao.weex.ui.component.WXComponent findChildByAttrsRef(com.taobao.weex.ui.component.WXComponent wXComponent, java.lang.String str) {
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
}
