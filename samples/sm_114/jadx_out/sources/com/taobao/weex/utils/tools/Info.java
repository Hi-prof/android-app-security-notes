package com.taobao.weex.utils.tools;

/* JADX INFO: loaded from: classes.dex */
public class Info {

    @com.alibaba.fastjson.annotation.JSONField(name = "instanceId")
    public java.lang.String instanceId;

    @com.alibaba.fastjson.annotation.JSONField(name = com.taobao.weex.common.RenderTypes.RENDER_TYPE_NATIVE)
    public java.lang.String platform;

    @com.alibaba.fastjson.annotation.JSONField(name = "taskId")
    public int taskId;

    @com.alibaba.fastjson.annotation.JSONField(name = "taskInfo")
    public com.taobao.weex.utils.tools.TaskInfo taskInfo = new com.taobao.weex.utils.tools.TaskInfo();

    @com.alibaba.fastjson.annotation.JSONField(name = "taskName")
    public java.lang.String taskName;

    public java.lang.String toString() {
        return "Info : {instanceId = '" + this.instanceId + "',taskName = '" + this.taskName + "',taskInfo = '" + this.taskInfo + "',platform = '" + this.platform + "',taskId = '" + this.taskId + "'}";
    }
}
