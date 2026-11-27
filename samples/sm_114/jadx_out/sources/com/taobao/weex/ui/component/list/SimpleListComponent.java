package com.taobao.weex.ui.component.list;

/* JADX INFO: loaded from: classes.dex */
public class SimpleListComponent extends com.taobao.weex.ui.component.list.BasicListComponent<com.taobao.weex.ui.component.list.SimpleRecyclerView> {
    public SimpleListComponent(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.ui.component.WXVContainer wXVContainer, com.taobao.weex.ui.action.BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, basicComponentData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.list.BasicListComponent
    public com.taobao.weex.ui.component.list.SimpleRecyclerView generateListView(android.content.Context context, int i) {
        com.taobao.weex.ui.component.list.SimpleRecyclerView simpleRecyclerView = new com.taobao.weex.ui.component.list.SimpleRecyclerView(context);
        simpleRecyclerView.initView(context, 1, i);
        return simpleRecyclerView;
    }
}
