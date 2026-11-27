package com.taobao.weex.ui.component.richtext;

/* JADX INFO: loaded from: classes.dex */
public class WXRichText extends com.taobao.weex.ui.component.WXText {
    private java.util.List<com.taobao.weex.ui.component.richtext.node.RichTextNode> nodes;

    static class RichTextContentBoxMeasurement extends com.taobao.weex.layout.measurefunc.TextContentBoxMeasurement {
        public RichTextContentBoxMeasurement(com.taobao.weex.ui.component.WXComponent wXComponent) {
            super(wXComponent);
        }

        @Override // com.taobao.weex.layout.measurefunc.TextContentBoxMeasurement
        protected android.text.Spanned createSpanned(java.lang.String str) {
            if (android.text.TextUtils.isEmpty(str)) {
                android.text.Spannable span = ((com.taobao.weex.ui.component.richtext.WXRichText) this.mComponent).toSpan();
                updateSpannable(span, com.taobao.weex.ui.component.richtext.node.RichTextNode.createSpanFlag(0));
                return span;
            }
            if (((this.mComponent.getInstance() != null) & (this.mComponent.getInstance().getUIContext() != null)) && !android.text.TextUtils.isEmpty(this.mComponent.getInstanceId())) {
                android.text.Spannable spannable = com.taobao.weex.ui.component.richtext.node.RichTextNode.parse(this.mComponent.getInstance().getUIContext(), this.mComponent.getInstanceId(), this.mComponent.getRef(), str);
                updateSpannable(spannable, com.taobao.weex.ui.component.richtext.node.RichTextNode.createSpanFlag(0));
                return spannable;
            }
            return new android.text.SpannedString("");
        }
    }

    public static class Creator implements com.taobao.weex.ui.ComponentCreator {
        @Override // com.taobao.weex.ui.ComponentCreator
        public com.taobao.weex.ui.component.WXComponent createInstance(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.ui.component.WXVContainer wXVContainer, com.taobao.weex.ui.action.BasicComponentData basicComponentData) throws java.lang.IllegalAccessException, java.lang.InstantiationException, java.lang.reflect.InvocationTargetException {
            return new com.taobao.weex.ui.component.richtext.WXRichText(wXSDKInstance, wXVContainer, basicComponentData);
        }
    }

    public WXRichText(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.ui.component.WXVContainer wXVContainer, com.taobao.weex.ui.action.BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, basicComponentData);
        this.nodes = new java.util.LinkedList();
        setContentBoxMeasurement(new com.taobao.weex.ui.component.richtext.WXRichText.RichTextContentBoxMeasurement(this));
    }

    public void AddChildNode(java.lang.String str, java.lang.String str2, java.lang.String str3, java.util.Map<java.lang.String, java.lang.String> map, java.util.Map<java.lang.String, java.lang.String> map2) {
        if (getInstance() == null || getInstance().getUIContext() == null || android.text.TextUtils.isEmpty(getInstanceId()) || android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
            return;
        }
        com.taobao.weex.ui.component.richtext.node.RichTextNode richTextNodeCreateRichTextNode = com.taobao.weex.ui.component.richtext.node.RichTextNodeManager.createRichTextNode(getInstance().getUIContext(), getInstanceId(), getRef(), str, str2, map, map2);
        if (android.text.TextUtils.isEmpty(str3)) {
            this.nodes.add(richTextNodeCreateRichTextNode);
            return;
        }
        com.taobao.weex.ui.component.richtext.node.RichTextNode richTextNodeFindRichNode = findRichNode(str3);
        if (richTextNodeFindRichNode != null) {
            richTextNodeFindRichNode.addChildNode(richTextNodeCreateRichTextNode);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public android.text.Spannable toSpan() {
        android.text.SpannableStringBuilder spannableStringBuilder = new android.text.SpannableStringBuilder();
        java.util.List<com.taobao.weex.ui.component.richtext.node.RichTextNode> list = this.nodes;
        if (list != null && !list.isEmpty()) {
            java.util.Iterator<com.taobao.weex.ui.component.richtext.node.RichTextNode> it = this.nodes.iterator();
            while (it.hasNext()) {
                spannableStringBuilder.append((java.lang.CharSequence) it.next().toSpan(1));
            }
        }
        return spannableStringBuilder;
    }

    public void removeChildNode(java.lang.String str, java.lang.String str2) throws java.lang.Throwable {
        java.util.List<com.taobao.weex.ui.component.richtext.node.RichTextNode> list = this.nodes;
        if (list == null || list.isEmpty()) {
            return;
        }
        if (str.equals("")) {
            for (com.taobao.weex.ui.component.richtext.node.RichTextNode richTextNode : this.nodes) {
                if (android.text.TextUtils.equals(richTextNode.getRef(), str2)) {
                    this.nodes.remove(richTextNode);
                }
            }
            return;
        }
        com.taobao.weex.ui.component.richtext.node.RichTextNode richTextNodeFindRichNode = findRichNode(str);
        if (richTextNodeFindRichNode != null) {
            richTextNodeFindRichNode.removeChildNode(str2);
        }
    }

    public void updateChildNodeStyles(java.lang.String str, java.util.Map<java.lang.String, java.lang.Object> map) {
        com.taobao.weex.ui.component.richtext.node.RichTextNode richTextNodeFindRichNode = findRichNode(str);
        if (richTextNodeFindRichNode != null) {
            richTextNodeFindRichNode.updateStyles(map);
        }
    }

    public void updateChildNodeAttrs(java.lang.String str, java.util.Map<java.lang.String, java.lang.Object> map) {
        com.taobao.weex.ui.component.richtext.node.RichTextNode richTextNodeFindRichNode = findRichNode(str);
        if (richTextNodeFindRichNode != null) {
            richTextNodeFindRichNode.updateAttrs(map);
        }
    }

    private com.taobao.weex.ui.component.richtext.node.RichTextNode findRichNode(java.lang.String str) {
        java.util.List<com.taobao.weex.ui.component.richtext.node.RichTextNode> list;
        if (android.text.TextUtils.isEmpty(str) || (list = this.nodes) == null || list.isEmpty()) {
            return null;
        }
        java.util.Iterator<com.taobao.weex.ui.component.richtext.node.RichTextNode> it = this.nodes.iterator();
        while (it.hasNext()) {
            com.taobao.weex.ui.component.richtext.node.RichTextNode richTextNodeFindRichNode = it.next().findRichNode(str);
            if (richTextNodeFindRichNode != null) {
                return richTextNodeFindRichNode;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXText, com.taobao.weex.ui.component.WXComponent
    public com.taobao.weex.ui.component.richtext.WXRichTextView initComponentHostView(android.content.Context context) {
        return new com.taobao.weex.ui.component.richtext.WXRichTextView(context);
    }
}
