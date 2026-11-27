package com.taobao.weex.ui.component.richtext.node;

/* JADX INFO: loaded from: classes.dex */
public abstract class RichTextNode {
    public static final java.lang.String ATTR = "attr";
    public static final java.lang.String CHILDREN = "children";
    public static final java.lang.String ITEM_CLICK = "itemclick";
    private static final int MAX_LEVEL = 255;
    public static final java.lang.String PSEUDO_REF = "pseudoRef";
    public static final java.lang.String STYLE = "style";
    public static final java.lang.String TYPE = "type";
    public static final java.lang.String VALUE = "value";
    protected java.util.Map<java.lang.String, java.lang.Object> attr;
    protected java.util.List<com.taobao.weex.ui.component.richtext.node.RichTextNode> children;
    protected final java.lang.String mComponentRef;
    protected final android.content.Context mContext;
    protected final java.lang.String mInstanceId;
    protected final java.lang.String mRef;
    protected java.util.Map<java.lang.String, java.lang.Object> style;

    private static int createPriorityFlag(int i) {
        if (i <= 255) {
            return (255 - i) << 16;
        }
        return 16711680;
    }

    protected abstract boolean isInternalNode();

    public abstract java.lang.String toString();

    protected RichTextNode(android.content.Context context, java.lang.String str, java.lang.String str2) {
        this.mContext = context;
        this.mInstanceId = str;
        this.mComponentRef = str2;
        this.mRef = null;
    }

    protected RichTextNode(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2) {
        this.mContext = context;
        this.mInstanceId = str;
        this.mComponentRef = str2;
        this.mRef = str3;
        if (map != null) {
            this.style = map;
        } else {
            this.style = new androidx.collection.ArrayMap(0);
        }
        if (map2 != null) {
            this.attr = map2;
        } else {
            this.attr = new androidx.collection.ArrayMap(0);
        }
        this.children = new java.util.LinkedList();
    }

    public static android.text.Spannable parse(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        com.taobao.weex.ui.component.richtext.node.RichTextNode richTextNodeCreateRichTextNode;
        com.alibaba.fastjson.JSONArray array = com.alibaba.fastjson.JSON.parseArray(str3);
        if (array != null && !array.isEmpty()) {
            java.util.ArrayList arrayList = new java.util.ArrayList(array.size());
            for (int i = 0; i < array.size(); i++) {
                com.alibaba.fastjson.JSONObject jSONObject = array.getJSONObject(i);
                if (jSONObject != null && (richTextNodeCreateRichTextNode = com.taobao.weex.ui.component.richtext.node.RichTextNodeManager.createRichTextNode(context, str, str2, jSONObject)) != null) {
                    arrayList.add(richTextNodeCreateRichTextNode);
                }
            }
            return parse(arrayList);
        }
        return new android.text.SpannableString("");
    }

    public static int createSpanFlag(int i) {
        return createPriorityFlag(i) | 17;
    }

    public java.lang.String getRef() {
        return this.mRef;
    }

    final void parse(android.content.Context context, java.lang.String str, java.lang.String str2, com.alibaba.fastjson.JSONObject jSONObject) {
        com.alibaba.fastjson.JSONObject jSONObject2 = jSONObject.getJSONObject("style");
        if (jSONObject2 != null) {
            androidx.collection.ArrayMap arrayMap = new androidx.collection.ArrayMap();
            this.style = arrayMap;
            arrayMap.putAll(jSONObject2);
        } else {
            this.style = new androidx.collection.ArrayMap(0);
        }
        com.alibaba.fastjson.JSONObject jSONObject3 = jSONObject.getJSONObject(ATTR);
        if (jSONObject3 != null) {
            androidx.collection.ArrayMap arrayMap2 = new androidx.collection.ArrayMap(jSONObject3.size());
            this.attr = arrayMap2;
            arrayMap2.putAll(jSONObject3);
        } else {
            this.attr = new androidx.collection.ArrayMap(0);
        }
        com.alibaba.fastjson.JSONArray jSONArray = jSONObject.getJSONArray(CHILDREN);
        if (jSONArray != null) {
            this.children = new java.util.ArrayList(jSONArray.size());
            for (int i = 0; i < jSONArray.size(); i++) {
                com.taobao.weex.ui.component.richtext.node.RichTextNode richTextNodeCreateRichTextNode = com.taobao.weex.ui.component.richtext.node.RichTextNodeManager.createRichTextNode(context, str, str2, jSONArray.getJSONObject(i));
                if (richTextNodeCreateRichTextNode != null) {
                    this.children.add(richTextNodeCreateRichTextNode);
                }
            }
            return;
        }
        this.children = new java.util.ArrayList(0);
    }

    public void addChildNode(com.taobao.weex.ui.component.richtext.node.RichTextNode richTextNode) {
        if (this.children == null) {
            this.children = new java.util.LinkedList();
        }
        if (richTextNode == null || !isInternalNode()) {
            return;
        }
        this.children.add(richTextNode);
    }

    public void removeChildNode(java.lang.String str) throws java.lang.Throwable {
        java.util.List<com.taobao.weex.ui.component.richtext.node.RichTextNode> list = this.children;
        if (list == null || list.isEmpty() || android.text.TextUtils.isEmpty(str)) {
            return;
        }
        try {
            for (com.taobao.weex.ui.component.richtext.node.RichTextNode richTextNode : this.children) {
                if (android.text.TextUtils.equals(richTextNode.mRef, str)) {
                    this.children.remove(richTextNode);
                }
            }
        } catch (java.lang.Exception e) {
            com.taobao.weex.utils.WXLogUtils.getStackTrace(e);
        }
    }

    public void updateStyles(java.util.Map<java.lang.String, java.lang.Object> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        this.style.putAll(map);
    }

    public void updateAttrs(java.util.Map<java.lang.String, java.lang.Object> map) {
        if (this.attr == null || map.isEmpty()) {
            return;
        }
        this.attr.putAll(map);
    }

    protected void updateSpans(android.text.SpannableStringBuilder spannableStringBuilder, int i) {
        int color;
        com.taobao.weex.WXSDKInstance sDKInstance = com.taobao.weex.WXSDKManager.getInstance().getSDKInstance(this.mInstanceId);
        if (this.style == null || sDKInstance == null) {
            return;
        }
        java.util.LinkedList linkedList = new java.util.LinkedList();
        com.taobao.weex.dom.WXCustomStyleSpan wXCustomStyleSpanCreateCustomStyleSpan = createCustomStyleSpan();
        if (wXCustomStyleSpanCreateCustomStyleSpan != null) {
            linkedList.add(wXCustomStyleSpanCreateCustomStyleSpan);
        }
        if (this.style.containsKey(com.taobao.weex.common.Constants.Name.FONT_SIZE)) {
            linkedList.add(new android.text.style.AbsoluteSizeSpan(com.taobao.weex.dom.WXStyle.getFontSize(this.style, sDKInstance.getDefaultFontSize(), sDKInstance.getInstanceViewPortWidthWithFloat())));
        }
        if (this.style.containsKey("backgroundColor") && (color = com.taobao.weex.utils.WXResourceUtils.getColor(this.style.get("backgroundColor").toString(), 0)) != 0) {
            linkedList.add(new android.text.style.BackgroundColorSpan(color));
        }
        if (this.style.containsKey("color")) {
            linkedList.add(new android.text.style.ForegroundColorSpan(com.taobao.weex.utils.WXResourceUtils.getColor(com.taobao.weex.dom.WXStyle.getTextColor(this.style))));
        }
        int iCreateSpanFlag = createSpanFlag(i);
        java.util.Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            spannableStringBuilder.setSpan(it.next(), 0, spannableStringBuilder.length(), iCreateSpanFlag);
        }
    }

    private static android.text.Spannable parse(java.util.List<com.taobao.weex.ui.component.richtext.node.RichTextNode> list) {
        android.text.SpannableStringBuilder spannableStringBuilder = new android.text.SpannableStringBuilder();
        java.util.Iterator<com.taobao.weex.ui.component.richtext.node.RichTextNode> it = list.iterator();
        while (it.hasNext()) {
            spannableStringBuilder.append((java.lang.CharSequence) it.next().toSpan(1));
        }
        return spannableStringBuilder;
    }

    public android.text.Spannable toSpan(int i) {
        java.util.List<com.taobao.weex.ui.component.richtext.node.RichTextNode> list;
        android.text.SpannableStringBuilder spannableStringBuilder = new android.text.SpannableStringBuilder();
        spannableStringBuilder.append((java.lang.CharSequence) toString());
        if (isInternalNode() && (list = this.children) != null) {
            java.util.Iterator<com.taobao.weex.ui.component.richtext.node.RichTextNode> it = list.iterator();
            while (it.hasNext()) {
                spannableStringBuilder.append((java.lang.CharSequence) it.next().toSpan(i + 1));
            }
        }
        updateSpans(spannableStringBuilder, i);
        return spannableStringBuilder;
    }

    private com.taobao.weex.dom.WXCustomStyleSpan createCustomStyleSpan() {
        int fontWeight = this.style.containsKey(com.taobao.weex.common.Constants.Name.FONT_WEIGHT) ? com.taobao.weex.dom.WXStyle.getFontWeight(this.style) : -1;
        int fontStyle = this.style.containsKey(com.taobao.weex.common.Constants.Name.FONT_STYLE) ? com.taobao.weex.dom.WXStyle.getFontStyle(this.style) : -1;
        java.lang.String fontFamily = this.style.containsKey(com.taobao.weex.common.Constants.Name.FONT_FAMILY) ? com.taobao.weex.dom.WXStyle.getFontFamily(this.style) : null;
        if (fontWeight == -1 && fontStyle == -1 && fontFamily == null) {
            return null;
        }
        return new com.taobao.weex.dom.WXCustomStyleSpan(fontStyle, fontWeight, fontFamily);
    }

    public com.taobao.weex.ui.component.richtext.node.RichTextNode findRichNode(java.lang.String str) {
        java.lang.String str2 = this.mRef;
        if (str2 != null && android.text.TextUtils.equals(str2, str)) {
            return this;
        }
        java.util.List<com.taobao.weex.ui.component.richtext.node.RichTextNode> list = this.children;
        if (list == null || list.isEmpty()) {
            return null;
        }
        java.util.Iterator<com.taobao.weex.ui.component.richtext.node.RichTextNode> it = this.children.iterator();
        while (it.hasNext()) {
            com.taobao.weex.ui.component.richtext.node.RichTextNode richTextNodeFindRichNode = it.next().findRichNode(str);
            if (richTextNodeFindRichNode != null) {
                return richTextNodeFindRichNode;
            }
        }
        return null;
    }
}
