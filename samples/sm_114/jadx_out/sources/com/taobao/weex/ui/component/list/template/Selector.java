package com.taobao.weex.ui.component.list.template;

/* JADX INFO: loaded from: classes.dex */
public class Selector {
    public static void queryElementAll(com.taobao.weex.ui.component.WXComponent wXComponent, java.lang.String str, java.util.List<com.taobao.weex.ui.component.WXComponent> list) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        java.lang.String[] strArrSplit = str.replaceAll("\\[|]", "").split("=");
        if (strArrSplit.length <= 0) {
            return;
        }
        java.lang.String str2 = strArrSplit[0];
        java.lang.String strTrim = strArrSplit.length > 1 ? strArrSplit[1].trim() : null;
        if (wXComponent instanceof com.taobao.weex.ui.component.WXVContainer) {
            com.taobao.weex.ui.component.WXVContainer wXVContainer = (com.taobao.weex.ui.component.WXVContainer) wXComponent;
            for (int i = 0; i < wXVContainer.getChildCount(); i++) {
                queryElementAllByAttrs(wXVContainer.getChild(i), str2, strTrim, list);
            }
        }
    }

    public static void closest(com.taobao.weex.ui.component.WXComponent wXComponent, java.lang.String str, java.util.List<com.taobao.weex.ui.component.WXComponent> list) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        java.lang.String[] strArrSplit = str.replaceAll("\\[|]", "").split("=");
        if (strArrSplit.length <= 0) {
            return;
        }
        closestByAttrs(wXComponent, strArrSplit[0], strArrSplit.length > 1 ? strArrSplit[1].trim() : null, list);
    }

    private static void closestByAttrs(com.taobao.weex.ui.component.WXComponent wXComponent, java.lang.String str, java.lang.String str2, java.util.List<com.taobao.weex.ui.component.WXComponent> list) {
        if (matchAttrs(wXComponent, str, str2)) {
            list.add(wXComponent);
        }
        if ((wXComponent instanceof com.taobao.weex.ui.component.list.WXCell) || (wXComponent instanceof com.taobao.weex.ui.component.list.template.WXRecyclerTemplateList)) {
            return;
        }
        queryElementAllByAttrs(wXComponent.getParent(), str, str2, list);
    }

    private static void queryElementAllByAttrs(com.taobao.weex.ui.component.WXComponent wXComponent, java.lang.String str, java.lang.String str2, java.util.List<com.taobao.weex.ui.component.WXComponent> list) {
        if (matchAttrs(wXComponent, str, str2)) {
            list.add(wXComponent);
        }
        if (wXComponent instanceof com.taobao.weex.ui.component.WXVContainer) {
            com.taobao.weex.ui.component.WXVContainer wXVContainer = (com.taobao.weex.ui.component.WXVContainer) wXComponent;
            for (int i = 0; i < wXVContainer.getChildCount(); i++) {
                queryElementAllByAttrs(wXVContainer.getChild(i), str, str2, list);
            }
        }
    }

    private static boolean matchAttrs(com.taobao.weex.ui.component.WXComponent wXComponent, java.lang.String str, java.lang.String str2) {
        if (wXComponent.isWaste() || !wXComponent.getAttrs().containsKey(str)) {
            return false;
        }
        if (android.text.TextUtils.isEmpty(str2)) {
            return true;
        }
        java.lang.Object obj = wXComponent.getAttrs().get(str);
        if (obj == null) {
            return false;
        }
        return str2.equals(obj.toString());
    }
}
