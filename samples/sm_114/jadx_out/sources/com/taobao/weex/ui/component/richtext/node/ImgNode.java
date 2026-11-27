package com.taobao.weex.ui.component.richtext.node;

/* JADX INFO: loaded from: classes.dex */
class ImgNode extends com.taobao.weex.ui.component.richtext.node.RichTextNode {
    public static final java.lang.String NODE_TYPE = "image";

    @Override // com.taobao.weex.ui.component.richtext.node.RichTextNode
    protected boolean isInternalNode() {
        return false;
    }

    static class ImgNodeCreator implements com.taobao.weex.ui.component.richtext.node.RichTextNodeCreator<com.taobao.weex.ui.component.richtext.node.ImgNode> {
        ImgNodeCreator() {
        }

        @Override // com.taobao.weex.ui.component.richtext.node.RichTextNodeCreator
        public /* bridge */ /* synthetic */ com.taobao.weex.ui.component.richtext.node.RichTextNode createRichTextNode(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, java.util.Map map, java.util.Map map2) {
            return createRichTextNode(context, str, str2, str3, (java.util.Map<java.lang.String, java.lang.Object>) map, (java.util.Map<java.lang.String, java.lang.Object>) map2);
        }

        @Override // com.taobao.weex.ui.component.richtext.node.RichTextNodeCreator
        public com.taobao.weex.ui.component.richtext.node.ImgNode createRichTextNode(android.content.Context context, java.lang.String str, java.lang.String str2) {
            return new com.taobao.weex.ui.component.richtext.node.ImgNode(context, str, str2);
        }

        @Override // com.taobao.weex.ui.component.richtext.node.RichTextNodeCreator
        public com.taobao.weex.ui.component.richtext.node.ImgNode createRichTextNode(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2) {
            return new com.taobao.weex.ui.component.richtext.node.ImgNode(context, str, str2, str3, map, map2);
        }
    }

    private ImgNode(android.content.Context context, java.lang.String str, java.lang.String str2) {
        super(context, str, str2);
    }

    private ImgNode(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2) {
        super(context, str, str2, str3, map, map2);
    }

    @Override // com.taobao.weex.ui.component.richtext.node.RichTextNode
    public java.lang.String toString() {
        return "\ufeff";
    }

    @Override // com.taobao.weex.ui.component.richtext.node.RichTextNode
    protected void updateSpans(android.text.SpannableStringBuilder spannableStringBuilder, int i) {
        com.taobao.weex.WXSDKInstance sDKInstance = com.taobao.weex.WXSDKManager.getInstance().getSDKInstance(this.mInstanceId);
        if (com.taobao.weex.WXSDKEngine.getDrawableLoader() != null) {
            if (((this.style.containsKey("width") && this.style.containsKey("height")) || (this.attr.containsKey("width") && this.attr.containsKey("height"))) && this.attr.containsKey("src") && sDKInstance != null) {
                java.util.LinkedList linkedList = new java.util.LinkedList();
                linkedList.add(createImgSpan(sDKInstance));
                if (this.attr.containsKey(com.taobao.weex.ui.component.richtext.node.RichTextNode.PSEUDO_REF)) {
                    linkedList.add(new com.taobao.weex.ui.component.richtext.span.ItemClickSpan(this.mInstanceId, this.mComponentRef, this.attr.get(com.taobao.weex.ui.component.richtext.node.RichTextNode.PSEUDO_REF).toString()));
                }
                java.util.Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    spannableStringBuilder.setSpan(it.next(), 0, spannableStringBuilder.length(), createSpanFlag(i));
                }
            }
        }
    }

    private com.taobao.weex.ui.component.richtext.span.ImgSpan createImgSpan(com.taobao.weex.WXSDKInstance wXSDKInstance) {
        java.lang.Object obj = (this.style.containsKey("width") ? this.style : this.attr).get("width");
        java.lang.Object obj2 = (this.style.containsKey("height") ? this.style : this.attr).get("height");
        int realPxByWidth = (int) com.taobao.weex.utils.WXViewUtils.getRealPxByWidth(com.taobao.weex.utils.WXUtils.getFloat(obj), wXSDKInstance.getInstanceViewPortWidthWithFloat());
        int realPxByWidth2 = (int) com.taobao.weex.utils.WXViewUtils.getRealPxByWidth(com.taobao.weex.utils.WXUtils.getFloat(obj2), wXSDKInstance.getInstanceViewPortWidthWithFloat());
        com.taobao.weex.ui.component.richtext.span.ImgSpan imgSpan = new com.taobao.weex.ui.component.richtext.span.ImgSpan(realPxByWidth, realPxByWidth2, this.mInstanceId, this.mComponentRef);
        android.net.Uri uriRewriteUri = wXSDKInstance.rewriteUri(android.net.Uri.parse(this.attr.get("src").toString()), "image");
        if (com.taobao.weex.common.Constants.Scheme.LOCAL.equals(uriRewriteUri.getScheme())) {
            imgSpan.setDrawable(com.taobao.weex.utils.ImgURIUtil.getDrawableFromLoaclSrc(this.mContext, uriRewriteUri), false);
            return imgSpan;
        }
        com.taobao.weex.adapter.DrawableStrategy drawableStrategy = new com.taobao.weex.adapter.DrawableStrategy();
        drawableStrategy.width = realPxByWidth;
        drawableStrategy.height = realPxByWidth2;
        com.taobao.weex.WXSDKEngine.getDrawableLoader().setDrawable(uriRewriteUri.toString(), imgSpan, drawableStrategy);
        return imgSpan;
    }
}
