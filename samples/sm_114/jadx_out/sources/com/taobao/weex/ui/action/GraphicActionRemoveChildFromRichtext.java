package com.taobao.weex.ui.action;

/* JADX INFO: loaded from: classes.dex */
public class GraphicActionRemoveChildFromRichtext extends com.taobao.weex.ui.action.BasicGraphicAction {
    private java.lang.String parentRef;
    private java.lang.String ref;
    private com.taobao.weex.ui.component.richtext.WXRichText richText;

    @Override // com.taobao.weex.ui.action.IExecutable
    public void executeAction() {
    }

    public GraphicActionRemoveChildFromRichtext(com.taobao.weex.WXSDKInstance wXSDKInstance, java.lang.String str, java.lang.String str2, java.lang.String str3) throws java.lang.Throwable {
        super(wXSDKInstance, str3);
        this.ref = str;
        this.parentRef = str2;
        com.taobao.weex.ui.component.richtext.WXRichText wXRichText = (com.taobao.weex.ui.component.richtext.WXRichText) com.taobao.weex.WXSDKManager.getInstance().getWXRenderManager().getWXComponent(wXSDKInstance.getInstanceId(), str3);
        this.richText = wXRichText;
        if (wXRichText != null) {
            wXRichText.removeChildNode(str2, str);
        }
    }
}
