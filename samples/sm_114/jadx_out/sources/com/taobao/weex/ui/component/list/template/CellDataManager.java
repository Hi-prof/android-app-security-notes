package com.taobao.weex.ui.component.list.template;

/* JADX INFO: loaded from: classes.dex */
public class CellDataManager {
    public static final java.lang.String SUB_COMPONENT_TEMPLATE_ID = "@templateId";
    public static final java.lang.String VIRTUAL_COMPONENT_ID = "@virtualComponentId";
    private static final java.lang.String VIRTUAL_COMPONENT_SEPRATOR = "@";
    com.alibaba.fastjson.JSONArray listData;
    private java.util.Map<java.lang.Integer, com.taobao.weex.ui.component.list.template.CellRenderState> renderStates = new androidx.collection.ArrayMap();
    public final com.taobao.weex.ui.component.list.template.WXRecyclerTemplateList templateList;
    private java.util.Map<java.lang.String, com.taobao.weex.ui.component.list.template.CellRenderState> virtualComponentRenderStates;

    public CellDataManager(com.taobao.weex.ui.component.list.template.WXRecyclerTemplateList wXRecyclerTemplateList) {
        this.templateList = wXRecyclerTemplateList;
    }

    public com.taobao.weex.ui.component.list.template.CellRenderState getRenderState(int i) {
        com.taobao.weex.ui.component.list.template.CellRenderState cellRenderState = this.renderStates.get(java.lang.Integer.valueOf(i));
        if (cellRenderState == null) {
            cellRenderState = new com.taobao.weex.ui.component.list.template.CellRenderState();
            cellRenderState.position = i;
            this.renderStates.put(java.lang.Integer.valueOf(i), cellRenderState);
        }
        if (i != cellRenderState.position) {
            cellRenderState.position = i;
            cellRenderState.hasPositionChange = true;
        }
        return cellRenderState;
    }

    public void updateVirtualComponentData(java.lang.String str, java.lang.Object obj) {
        java.util.Map<java.lang.String, com.taobao.weex.ui.component.list.template.CellRenderState> map = this.virtualComponentRenderStates;
        if (map != null) {
            com.taobao.weex.ui.component.list.template.CellRenderState cellRenderState = map.get(str);
            if (cellRenderState != null) {
                cellRenderState.getVirtualComponentDatas().put(str, obj);
                cellRenderState.hasVirtualCompoentUpdate = true;
                return;
            } else {
                if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
                    throw new java.lang.IllegalArgumentException("virtualComponentDatas illegal state empty render state" + str);
                }
                return;
            }
        }
        if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
            throw new java.lang.IllegalArgumentException("virtualComponentDatas illegal state " + str);
        }
    }

    public void createVirtualComponentData(int i, java.lang.String str, java.lang.Object obj) {
        if (this.virtualComponentRenderStates == null) {
            this.virtualComponentRenderStates = new java.util.HashMap(8);
        }
        com.taobao.weex.ui.component.list.template.CellRenderState cellRenderState = this.renderStates.get(java.lang.Integer.valueOf(i));
        cellRenderState.getVirtualComponentDatas().put(str, obj);
        this.virtualComponentRenderStates.put(str, cellRenderState);
    }

    public void setListData(com.alibaba.fastjson.JSONArray jSONArray) {
        com.alibaba.fastjson.JSONArray jSONArray2 = this.listData;
        if (jSONArray2 != jSONArray) {
            if (jSONArray2 != null && com.taobao.weex.utils.WXUtils.getBoolean(this.templateList.getAttrs().get("exitDetach"), true).booleanValue()) {
                for (int i = 0; i < this.listData.size(); i++) {
                    cleanRenderState(this.renderStates.remove(java.lang.Integer.valueOf(i)));
                }
            }
            this.listData = jSONArray;
            this.renderStates.clear();
            java.util.Map<java.lang.String, com.taobao.weex.ui.component.list.template.CellRenderState> map = this.virtualComponentRenderStates;
            if (map != null) {
                map.clear();
            }
        }
    }

    public boolean insertData(int i, java.lang.Object obj) {
        this.listData.add(i, obj);
        boolean z = false;
        for (int size = this.listData.size(); size >= i; size--) {
            com.taobao.weex.ui.component.list.template.CellRenderState cellRenderStateRemove = this.renderStates.remove(java.lang.Integer.valueOf(size));
            if (cellRenderStateRemove != null) {
                this.renderStates.put(java.lang.Integer.valueOf(size + 1), cellRenderStateRemove);
                z = true;
            }
        }
        return z;
    }

    public boolean insertRange(int i, com.alibaba.fastjson.JSONArray jSONArray) {
        this.listData.addAll(i, jSONArray);
        boolean z = false;
        for (int size = this.listData.size() - 1; size >= i; size--) {
            com.taobao.weex.ui.component.list.template.CellRenderState cellRenderStateRemove = this.renderStates.remove(java.lang.Integer.valueOf(size));
            if (cellRenderStateRemove != null) {
                this.renderStates.put(java.lang.Integer.valueOf(size + 1), cellRenderStateRemove);
                z = true;
            }
        }
        return z;
    }

    public boolean updateData(java.lang.Object obj, int i) {
        boolean zEquals = android.text.TextUtils.equals(this.templateList.getTemplateKey(i), this.templateList.getTemplateKey(obj));
        this.listData.set(i, obj);
        if (!zEquals) {
            cleanRenderState(this.renderStates.remove(java.lang.Integer.valueOf(i)));
            return zEquals;
        }
        com.taobao.weex.ui.component.list.template.CellRenderState cellRenderState = this.renderStates.get(java.lang.Integer.valueOf(i));
        if (cellRenderState != null) {
            cellRenderState.hasDataUpdate = true;
        }
        return zEquals;
    }

    public void removeData(java.lang.Integer num) {
        this.listData.remove(num.intValue());
        cleanRenderState(this.renderStates.remove(num));
        int size = this.listData.size() + 1;
        int iIntValue = num.intValue();
        while (true) {
            iIntValue++;
            if (iIntValue >= size) {
                return;
            }
            com.taobao.weex.ui.component.list.template.CellRenderState cellRenderStateRemove = this.renderStates.remove(java.lang.Integer.valueOf(iIntValue));
            if (cellRenderStateRemove != null) {
                this.renderStates.put(java.lang.Integer.valueOf(iIntValue - 1), cellRenderStateRemove);
            }
        }
    }

    private void cleanRenderState(com.taobao.weex.ui.component.list.template.CellRenderState cellRenderState) {
        if (cellRenderState != null && cellRenderState.hasVirtualComponents()) {
            for (java.lang.String str : cellRenderState.getVirtualComponentIds().values()) {
                java.util.Map<java.lang.String, com.taobao.weex.ui.component.list.template.CellRenderState> map = this.virtualComponentRenderStates;
                if (map != null) {
                    map.remove(str);
                }
                com.taobao.weex.bridge.WXBridgeManager.getInstance().asyncCallJSEventVoidResult(com.taobao.weex.bridge.WXBridgeManager.METHD_COMPONENT_HOOK_SYNC, this.templateList.getInstanceId(), null, str, com.taobao.weex.ui.component.list.template.VirtualComponentLifecycle.LIFECYCLE, "detach", null);
            }
        }
    }

    public static java.lang.String createVirtualComponentId(java.lang.String str, java.lang.String str2, long j) {
        return str + VIRTUAL_COMPONENT_SEPRATOR + str2 + VIRTUAL_COMPONENT_SEPRATOR + j;
    }

    public static java.lang.String getListRef(java.lang.String str) {
        if (str == null) {
            return null;
        }
        return str.split(VIRTUAL_COMPONENT_SEPRATOR)[0];
    }
}
