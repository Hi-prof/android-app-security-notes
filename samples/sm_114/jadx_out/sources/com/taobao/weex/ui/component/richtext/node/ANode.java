package com.taobao.weex.ui.component.richtext.node;

/* JADX INFO: loaded from: classes.dex */
class ANode extends com.taobao.weex.ui.component.richtext.node.RichTextNode {
    public static final java.lang.String HREF = "href";
    public static final java.lang.String NODE_TYPE = "a";

    @Override // com.taobao.weex.ui.component.richtext.node.RichTextNode
    protected boolean isInternalNode() {
        return true;
    }

    static class ANodeCreator implements com.taobao.weex.ui.component.richtext.node.RichTextNodeCreator<com.taobao.weex.ui.component.richtext.node.ANode> {
        ANodeCreator() {
        }

        @Override // com.taobao.weex.ui.component.richtext.node.RichTextNodeCreator
        public /* bridge */ /* synthetic */ com.taobao.weex.ui.component.richtext.node.RichTextNode createRichTextNode(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, java.util.Map map, java.util.Map map2) {
            return createRichTextNode(context, str, str2, str3, (java.util.Map<java.lang.String, java.lang.Object>) map, (java.util.Map<java.lang.String, java.lang.Object>) map2);
        }

        @Override // com.taobao.weex.ui.component.richtext.node.RichTextNodeCreator
        public com.taobao.weex.ui.component.richtext.node.ANode createRichTextNode(android.content.Context context, java.lang.String str, java.lang.String str2) {
            return new com.taobao.weex.ui.component.richtext.node.ANode(context, str, str2);
        }

        @Override // com.taobao.weex.ui.component.richtext.node.RichTextNodeCreator
        public com.taobao.weex.ui.component.richtext.node.ANode createRichTextNode(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2) {
            return new com.taobao.weex.ui.component.richtext.node.ANode(context, str, str2, str3, map, map2);
        }
    }

    private ANode(android.content.Context context, java.lang.String str, java.lang.String str2) {
        super(context, str, str2);
    }

    private ANode(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2) {
        super(context, str, str2, str3, map, map2);
    }

    @Override // com.taobao.weex.ui.component.richtext.node.RichTextNode
    public java.lang.String toString() {
        return "";
    }

    @Override // com.taobao.weex.ui.component.richtext.node.RichTextNode
    protected void updateSpans(android.text.SpannableStringBuilder spannableStringBuilder, int i) {
        super.updateSpans(spannableStringBuilder, i);
        if (this.attr != null && this.attr.containsKey(com.taobao.weex.ui.component.richtext.node.RichTextNode.PSEUDO_REF)) {
            spannableStringBuilder.setSpan(new com.taobao.weex.ui.component.richtext.span.ItemClickSpan(this.mInstanceId, this.mComponentRef, this.attr.get(com.taobao.weex.ui.component.richtext.node.RichTextNode.PSEUDO_REF).toString()), 0, spannableStringBuilder.length(), createSpanFlag(i));
        } else {
            if (this.attr == null || !this.attr.containsKey("href")) {
                return;
            }
            spannableStringBuilder.setSpan(new com.taobao.weex.ui.component.richtext.span.ASpan(this.mInstanceId, this.attr.get("href").toString()), 0, spannableStringBuilder.length(), createSpanFlag(i));
        }
    }
}
