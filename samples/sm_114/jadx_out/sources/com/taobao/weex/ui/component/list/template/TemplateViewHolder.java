package com.taobao.weex.ui.component.list.template;

/* JADX INFO: loaded from: classes.dex */
public class TemplateViewHolder extends com.taobao.weex.ui.view.listview.adapter.ListBaseViewHolder {
    public android.os.AsyncTask<java.lang.Void, java.lang.Void, java.lang.Void> asyncTask;
    public java.lang.Object data;
    private int holderPosition;
    private com.taobao.weex.ui.component.list.WXCell template;
    private com.taobao.weex.ui.component.list.template.WXRecyclerTemplateList templateList;

    public TemplateViewHolder(com.taobao.weex.ui.component.list.template.WXRecyclerTemplateList wXRecyclerTemplateList, com.taobao.weex.ui.component.list.WXCell wXCell, int i) {
        super(wXCell, i);
        this.holderPosition = -1;
        this.template = wXCell;
        this.templateList = wXRecyclerTemplateList;
    }

    public TemplateViewHolder(com.taobao.weex.ui.component.list.template.WXRecyclerTemplateList wXRecyclerTemplateList, android.view.View view, int i) {
        super(view, i);
        this.holderPosition = -1;
        this.templateList = wXRecyclerTemplateList;
    }

    public int getHolderPosition() {
        return this.holderPosition;
    }

    public void setHolderPosition(int i) {
        this.holderPosition = i;
    }

    public com.taobao.weex.ui.component.list.WXCell getTemplate() {
        return this.template;
    }

    public com.taobao.weex.ui.component.list.template.WXRecyclerTemplateList getTemplateList() {
        return this.templateList;
    }
}
