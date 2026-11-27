package com.taobao.weex.ui.component.list.template;

/* JADX INFO: loaded from: classes.dex */
public class PositionRef extends java.lang.Number implements com.alibaba.fastjson.JSONAware {
    private com.taobao.weex.ui.component.list.template.CellRenderState renderState;

    public PositionRef(com.taobao.weex.ui.component.list.template.CellRenderState cellRenderState) {
        this.renderState = cellRenderState;
    }

    @Override // java.lang.Number
    public int intValue() {
        return getPosition();
    }

    @Override // java.lang.Number
    public long longValue() {
        return getPosition();
    }

    @Override // java.lang.Number
    public float floatValue() {
        return getPosition();
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return getPosition();
    }

    private int getPosition() {
        com.taobao.weex.ui.component.list.template.CellRenderState cellRenderState = this.renderState;
        if (cellRenderState == null) {
            return -1;
        }
        return cellRenderState.position;
    }

    public java.lang.String toString() {
        return java.lang.String.valueOf(getPosition());
    }

    @Override // com.alibaba.fastjson.JSONAware
    public java.lang.String toJSONString() {
        return java.lang.String.valueOf(getPosition());
    }
}
