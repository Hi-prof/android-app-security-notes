package com.alibaba.fastjson.asm;

/* JADX INFO: loaded from: classes.dex */
public class MethodCollector {
    protected boolean debugInfoPresent;
    private final int ignoreCount;
    private final int paramCount;
    private final java.lang.StringBuilder result = new java.lang.StringBuilder();
    private int currentParameter = 0;

    protected MethodCollector(int i, int i2) {
        this.ignoreCount = i;
        this.paramCount = i2;
        this.debugInfoPresent = i2 == 0;
    }

    protected void visitLocalVariable(java.lang.String str, int i) {
        int i2 = this.ignoreCount;
        if (i < i2 || i >= i2 + this.paramCount) {
            return;
        }
        if (!str.equals(com.taobao.weex.adapter.IWXUserTrackAdapter.MONITOR_ARG + this.currentParameter)) {
            this.debugInfoPresent = true;
        }
        this.result.append(com.taobao.weex.el.parse.Operators.ARRAY_SEPRATOR);
        this.result.append(str);
        this.currentParameter++;
    }

    protected java.lang.String getResult() {
        return this.result.length() != 0 ? this.result.substring(1) : "";
    }
}
