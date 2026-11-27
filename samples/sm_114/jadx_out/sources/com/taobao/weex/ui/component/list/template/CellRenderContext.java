package com.taobao.weex.ui.component.list.template;

/* JADX INFO: loaded from: classes.dex */
public class CellRenderContext {
    public int position;
    public com.taobao.weex.ui.component.list.template.CellRenderState renderState;
    public com.taobao.weex.ui.component.list.template.WXRecyclerTemplateList templateList;
    public com.taobao.weex.el.parse.ArrayStack stack = new com.taobao.weex.el.parse.ArrayStack();
    public java.util.Map map = new java.util.HashMap(8);

    public com.taobao.weex.ui.component.list.template.CellRenderState getRenderState() {
        if (this.renderState != null) {
            this.renderState = this.templateList.getCellDataManager().getRenderState(this.position);
        }
        return this.renderState;
    }

    public void clear() {
        if (this.stack.getList().size() > 0) {
            this.stack.getList().clear();
        }
        if (this.map.size() > 0) {
            this.map.clear();
        }
        this.renderState = null;
        this.position = 0;
        this.templateList = null;
    }
}
