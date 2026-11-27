package com.taobao.weex.ui.component.list.template;

/* JADX INFO: loaded from: classes.dex */
public class CellRenderState {
    private java.util.Map<java.lang.String, com.taobao.weex.el.parse.ArrayStack> onceComponentStates;
    int position;
    private java.util.Map<java.lang.String, java.lang.Object> virtualComponentDatas;
    private java.util.Map<java.lang.String, java.lang.String> virtualComponentIds;
    boolean hasVirtualCompoentUpdate = false;
    boolean hasDataUpdate = false;
    boolean hasPositionChange = false;
    long itemId = -1;

    public java.util.Map<java.lang.String, java.lang.String> getVirtualComponentIds() {
        if (this.virtualComponentIds == null) {
            this.virtualComponentIds = new java.util.HashMap(8);
        }
        return this.virtualComponentIds;
    }

    public boolean hasVirtualComponents() {
        java.util.Map<java.lang.String, java.lang.String> map = this.virtualComponentIds;
        return map != null && map.size() > 0;
    }

    public java.util.Map<java.lang.String, java.lang.Object> getVirtualComponentDatas() {
        if (this.virtualComponentDatas == null) {
            this.virtualComponentDatas = new java.util.HashMap(4);
        }
        return this.virtualComponentDatas;
    }

    public java.util.Map<java.lang.String, com.taobao.weex.el.parse.ArrayStack> getOnceComponentStates() {
        if (this.onceComponentStates == null) {
            this.onceComponentStates = new java.util.HashMap();
        }
        return this.onceComponentStates;
    }

    public boolean isDirty() {
        return this.hasDataUpdate || this.hasVirtualCompoentUpdate || this.hasPositionChange;
    }

    public boolean isHasDataUpdate() {
        return this.hasDataUpdate;
    }

    public void resetDirty() {
        this.hasDataUpdate = false;
        this.hasVirtualCompoentUpdate = false;
        this.hasPositionChange = false;
    }
}
