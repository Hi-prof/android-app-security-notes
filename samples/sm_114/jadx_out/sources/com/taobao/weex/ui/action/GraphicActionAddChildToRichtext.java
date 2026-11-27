package com.taobao.weex.ui.action;

/* JADX INFO: loaded from: classes.dex */
public class GraphicActionAddChildToRichtext extends com.taobao.weex.ui.action.BasicGraphicAction {
    @Override // com.taobao.weex.ui.action.IExecutable
    public void executeAction() {
    }

    public GraphicActionAddChildToRichtext(com.taobao.weex.WXSDKInstance wXSDKInstance, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.util.HashMap<java.lang.String, java.lang.String> map, java.util.HashMap<java.lang.String, java.lang.String> map2) {
        com.taobao.weex.ui.component.richtext.WXRichText wXRichText;
        super(wXSDKInstance, str4);
        if (com.taobao.weex.WXSDKManager.getInstance() == null || com.taobao.weex.WXSDKManager.getInstance().getWXRenderManager() == null || (wXRichText = (com.taobao.weex.ui.component.richtext.WXRichText) com.taobao.weex.WXSDKManager.getInstance().getWXRenderManager().getWXComponent(getPageId(), str4)) == null) {
            return;
        }
        wXRichText.AddChildNode(str2, str, str3, map, map2);
    }
}
