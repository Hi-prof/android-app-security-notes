package com.taobao.weex.ui.action;

/* JADX INFO: loaded from: classes.dex */
public class GraphicActionUpdateRichtextAttr extends com.taobao.weex.ui.action.BasicGraphicAction {
    @Override // com.taobao.weex.ui.action.IExecutable
    public void executeAction() {
    }

    public GraphicActionUpdateRichtextAttr(com.taobao.weex.WXSDKInstance wXSDKInstance, java.lang.String str, java.util.HashMap<java.lang.String, java.lang.String> map, java.lang.String str2, java.lang.String str3) {
        super(wXSDKInstance, str3);
        com.taobao.weex.ui.component.richtext.WXRichText wXRichText = (com.taobao.weex.ui.component.richtext.WXRichText) com.taobao.weex.WXSDKManager.getInstance().getWXRenderManager().getWXComponent(getPageId(), str3);
        if (wXRichText != null) {
            java.util.HashMap map2 = new java.util.HashMap();
            map2.putAll(map);
            wXRichText.updateChildNodeAttrs(str, map2);
        }
    }
}
