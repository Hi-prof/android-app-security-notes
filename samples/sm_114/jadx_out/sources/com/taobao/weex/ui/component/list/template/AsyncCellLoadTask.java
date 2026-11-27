package com.taobao.weex.ui.component.list.template;

/* JADX INFO: loaded from: classes.dex */
class AsyncCellLoadTask extends android.os.AsyncTask<java.lang.Void, java.lang.Void, java.lang.Void> {
    private com.taobao.weex.ui.component.list.WXCell source;
    private java.lang.String template;
    private com.taobao.weex.ui.component.list.template.WXRecyclerTemplateList templateList;

    public AsyncCellLoadTask(java.lang.String str, com.taobao.weex.ui.component.list.WXCell wXCell, com.taobao.weex.ui.component.list.template.WXRecyclerTemplateList wXRecyclerTemplateList) {
        this.template = str;
        this.source = wXCell;
        this.templateList = wXRecyclerTemplateList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public java.lang.Void doInBackground(java.lang.Void... voidArr) {
        com.taobao.weex.ui.component.list.template.TemplateCache templateCache = this.templateList.getTemplatesCache().get(this.template);
        if (templateCache != null && templateCache.cells != null) {
            while (templateCache.cells.size() < this.templateList.getTemplateCacheSize()) {
                java.lang.System.currentTimeMillis();
                com.taobao.weex.ui.component.list.WXCell wXCell = (com.taobao.weex.ui.component.list.WXCell) this.templateList.copyComponentFromSourceCell(this.source);
                com.taobao.weex.WXEnvironment.isOpenDebugLog();
                if (wXCell == null || isDestory()) {
                    return null;
                }
                templateCache.cells.add(wXCell);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onPostExecute(java.lang.Void r4) {
        final com.taobao.weex.ui.component.list.template.TemplateCache templateCache;
        if (isDestory() || (templateCache = this.templateList.getTemplatesCache().get(this.template)) == null) {
            return;
        }
        if (templateCache.cells == null || templateCache.cells.size() == 0) {
            templateCache.isLoadIng = false;
        } else {
            android.os.Looper.myQueue().addIdleHandler(new android.os.MessageQueue.IdleHandler() { // from class: com.taobao.weex.ui.component.list.template.AsyncCellLoadTask.1
                @Override // android.os.MessageQueue.IdleHandler
                public boolean queueIdle() {
                    if (com.taobao.weex.ui.component.list.template.AsyncCellLoadTask.this.isDestory()) {
                        return false;
                    }
                    java.util.Iterator<com.taobao.weex.ui.component.list.WXCell> it = templateCache.cells.iterator();
                    while (it.hasNext()) {
                        com.taobao.weex.ui.component.list.WXCell next = it.next();
                        if (next.isLazy()) {
                            com.taobao.weex.ui.component.list.template.WXRecyclerTemplateList unused = com.taobao.weex.ui.component.list.template.AsyncCellLoadTask.this.templateList;
                            com.taobao.weex.ui.component.list.template.WXRecyclerTemplateList.doCreateCellViewBindData(next, com.taobao.weex.ui.component.list.template.AsyncCellLoadTask.this.template, true);
                            return it.hasNext();
                        }
                    }
                    return false;
                }
            });
            templateCache.isLoadIng = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDestory() {
        if (this.source.getInstance() == null || this.source.getInstance().isDestroy()) {
            return true;
        }
        return this.templateList.isDestoryed();
    }

    public void startTask() {
        executeOnExecutor(android.os.AsyncTask.THREAD_POOL_EXECUTOR, new java.lang.Void[0]);
    }
}
