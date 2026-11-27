package com.taobao.weex.ui.component.richtext.node;

/* JADX INFO: loaded from: classes.dex */
public class RichTextNodeManager {
    private static final java.util.Map<java.lang.String, com.taobao.weex.ui.component.richtext.node.RichTextNodeCreator> registeredTextNodes;

    static {
        androidx.collection.ArrayMap arrayMap = new androidx.collection.ArrayMap();
        registeredTextNodes = arrayMap;
        arrayMap.put(com.taobao.weex.ui.component.richtext.node.SpanNode.NODE_TYPE, new com.taobao.weex.ui.component.richtext.node.SpanNode.SpanNodeCreator());
        arrayMap.put("image", new com.taobao.weex.ui.component.richtext.node.ImgNode.ImgNodeCreator());
        arrayMap.put("a", new com.taobao.weex.ui.component.richtext.node.ANode.ANodeCreator());
    }

    public static void registerTextNode(java.lang.String str, com.taobao.weex.ui.component.richtext.node.RichTextNodeCreator richTextNodeCreator) {
        registeredTextNodes.put(str, richTextNodeCreator);
    }

    static com.taobao.weex.ui.component.richtext.node.RichTextNode createRichTextNode(android.content.Context context, java.lang.String str, java.lang.String str2, com.alibaba.fastjson.JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                com.taobao.weex.ui.component.richtext.node.RichTextNode richTextNodeCreateRichTextNode = registeredTextNodes.get(jSONObject.getString("type")).createRichTextNode(context, str, str2);
                richTextNodeCreateRichTextNode.parse(context, str, str2, jSONObject);
                return richTextNodeCreateRichTextNode;
            } catch (java.lang.Exception e) {
                com.taobao.weex.utils.WXLogUtils.e("Richtext", com.taobao.weex.utils.WXLogUtils.getStackTrace(e));
            }
        }
        return null;
    }

    public static com.taobao.weex.ui.component.richtext.node.RichTextNode createRichTextNode(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.util.Map<java.lang.String, java.lang.String> map, java.util.Map<java.lang.String, java.lang.String> map2) {
        try {
            return registeredTextNodes.get(str4).createRichTextNode(context, str, str2, str3, map, map2);
        } catch (java.lang.Exception e) {
            com.taobao.weex.utils.WXLogUtils.e("Richtext", com.taobao.weex.utils.WXLogUtils.getStackTrace(e));
            return null;
        }
    }
}
