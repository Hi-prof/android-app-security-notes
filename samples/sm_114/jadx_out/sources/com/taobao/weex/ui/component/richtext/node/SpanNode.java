package com.taobao.weex.ui.component.richtext.node;

/* JADX INFO: loaded from: classes.dex */
class SpanNode extends com.taobao.weex.ui.component.richtext.node.RichTextNode {
    public static final java.lang.String NODE_TYPE = "span";

    @Override // com.taobao.weex.ui.component.richtext.node.RichTextNode
    protected boolean isInternalNode() {
        return true;
    }

    static class SpanNodeCreator implements com.taobao.weex.ui.component.richtext.node.RichTextNodeCreator<com.taobao.weex.ui.component.richtext.node.SpanNode> {
        SpanNodeCreator() {
        }

        @Override // com.taobao.weex.ui.component.richtext.node.RichTextNodeCreator
        public /* bridge */ /* synthetic */ com.taobao.weex.ui.component.richtext.node.RichTextNode createRichTextNode(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, java.util.Map map, java.util.Map map2) {
            return createRichTextNode(context, str, str2, str3, (java.util.Map<java.lang.String, java.lang.Object>) map, (java.util.Map<java.lang.String, java.lang.Object>) map2);
        }

        @Override // com.taobao.weex.ui.component.richtext.node.RichTextNodeCreator
        public com.taobao.weex.ui.component.richtext.node.SpanNode createRichTextNode(android.content.Context context, java.lang.String str, java.lang.String str2) {
            return new com.taobao.weex.ui.component.richtext.node.SpanNode(context, str, str2);
        }

        @Override // com.taobao.weex.ui.component.richtext.node.RichTextNodeCreator
        public com.taobao.weex.ui.component.richtext.node.SpanNode createRichTextNode(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2) {
            return new com.taobao.weex.ui.component.richtext.node.SpanNode(context, str, str2, str3, map, map2);
        }
    }

    private SpanNode(android.content.Context context, java.lang.String str, java.lang.String str2) {
        super(context, str, str2);
    }

    private SpanNode(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2) {
        super(context, str, str2, str3, map, map2);
    }

    @Override // com.taobao.weex.ui.component.richtext.node.RichTextNode
    public java.lang.String toString() {
        if (this.attr == null || !this.attr.containsKey("value")) {
            return "";
        }
        return this.attr.get("value").toString();
    }

    @Override // com.taobao.weex.ui.component.richtext.node.RichTextNode
    protected void updateSpans(android.text.SpannableStringBuilder spannableStringBuilder, int i) {
        super.updateSpans(spannableStringBuilder, i);
        spannableStringBuilder.setSpan(new com.taobao.weex.dom.TextDecorationSpan(com.taobao.weex.dom.WXStyle.getTextDecoration(this.style)), 0, spannableStringBuilder.length(), createSpanFlag(i));
    }
}
