package com.taobao.weex.ui.component.binding;

/* JADX INFO: loaded from: classes.dex */
class AsynLayoutTask extends android.os.AsyncTask<java.lang.Void, java.lang.Void, java.lang.Void> {
    private final com.taobao.weex.ui.component.WXComponent component;
    private final int position;
    private final com.taobao.weex.ui.component.list.template.TemplateViewHolder templateViewHolder;

    AsynLayoutTask(com.taobao.weex.ui.component.list.template.TemplateViewHolder templateViewHolder, int i, com.taobao.weex.ui.component.WXComponent wXComponent) {
        this.templateViewHolder = templateViewHolder;
        this.position = i;
        this.component = wXComponent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public java.lang.Void doInBackground(java.lang.Void... voidArr) {
        if (this.templateViewHolder.getHolderPosition() == this.position && this.component.getInstance() != null && !this.component.getInstance().isDestroy()) {
            synchronized (this.templateViewHolder.getTemplateList()) {
                if (this.templateViewHolder.getTemplateList().isDestoryed()) {
                    return null;
                }
                com.taobao.weex.ui.component.binding.Layouts.doLayoutOnly(this.component, this.templateViewHolder);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onPostExecute(java.lang.Void r4) {
        if (this.position != this.templateViewHolder.getHolderPosition() || this.component.getInstance() == null || this.component.getInstance().isDestroy()) {
            return;
        }
        com.taobao.weex.ui.component.binding.Layouts.setLayout(this.component, false);
        if (this.templateViewHolder.getHolderPosition() >= 0) {
            this.templateViewHolder.getTemplateList().fireEvent(com.taobao.weex.ui.component.list.template.TemplateDom.ATTACH_CELL_SLOT, com.taobao.weex.ui.component.list.template.TemplateDom.findAllComponentRefs(this.templateViewHolder.getTemplateList().getRef(), this.position, this.component));
        }
    }
}
