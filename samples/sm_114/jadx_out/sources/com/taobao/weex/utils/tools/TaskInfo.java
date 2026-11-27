package com.taobao.weex.utils.tools;

/* JADX INFO: loaded from: classes.dex */
public class TaskInfo {

    @com.alibaba.fastjson.annotation.JSONField(name = "args")
    public java.lang.String args;

    @com.alibaba.fastjson.annotation.JSONField(name = "relateTaskId")
    public int relateTaskId;

    public java.lang.String toString() {
        return "TaskInfo{args = '" + this.args + "',relateTaskId = '" + this.relateTaskId + "'}";
    }
}
