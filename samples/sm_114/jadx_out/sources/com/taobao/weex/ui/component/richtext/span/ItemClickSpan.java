package com.taobao.weex.ui.component.richtext.span;

/* JADX INFO: loaded from: classes.dex */
public class ItemClickSpan extends android.text.style.ClickableSpan {
    private final java.lang.String mComponentRef;
    private final java.lang.String mInstanceId;
    private final java.lang.String mPseudoRef;

    public ItemClickSpan(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        this.mPseudoRef = str3;
        this.mInstanceId = str;
        this.mComponentRef = str2;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(android.view.View view) {
        com.taobao.weex.WXSDKInstance sDKInstance = com.taobao.weex.WXSDKManager.getInstance().getSDKInstance(this.mInstanceId);
        if (sDKInstance == null || sDKInstance.isDestroy()) {
            return;
        }
        java.util.HashMap mapNewHashMapWithExpectedSize = com.taobao.weex.utils.WXDataStructureUtil.newHashMapWithExpectedSize(1);
        mapNewHashMapWithExpectedSize.put(com.taobao.weex.ui.component.richtext.node.RichTextNode.PSEUDO_REF, this.mPseudoRef);
        sDKInstance.fireEvent(this.mComponentRef, com.taobao.weex.ui.component.richtext.node.RichTextNode.ITEM_CLICK, mapNewHashMapWithExpectedSize);
    }
}
