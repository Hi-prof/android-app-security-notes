package com.taobao.weex.ui.component.richtext.node;

/* JADX INFO: loaded from: classes.dex */
public interface RichTextNodeCreator<T extends com.taobao.weex.ui.component.richtext.node.RichTextNode> {
    T createRichTextNode(android.content.Context context, java.lang.String str, java.lang.String str2);

    T createRichTextNode(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2);
}
