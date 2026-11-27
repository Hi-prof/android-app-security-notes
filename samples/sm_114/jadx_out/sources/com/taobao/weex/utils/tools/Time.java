package com.taobao.weex.utils.tools;

/* JADX INFO: loaded from: classes.dex */
public class Time {

    @com.alibaba.fastjson.annotation.JSONField(name = "constructor")
    public long constructor;

    @com.alibaba.fastjson.annotation.JSONField(name = "destructor")
    public long destructor;

    @com.alibaba.fastjson.annotation.JSONField(name = "execTime")
    public long execTime;

    @com.alibaba.fastjson.annotation.JSONField(name = "taskEnd")
    public long taskEnd;

    @com.alibaba.fastjson.annotation.JSONField(name = "taskStart")
    public long taskStart;

    @com.alibaba.fastjson.annotation.JSONField(name = "waitTime")
    public long waitTime;

    public java.lang.String toString() {
        return "time : {constructor = '" + this.constructor + "',taskStart = '" + this.taskStart + "',execTime = '" + this.execTime + "',waitTime = '" + this.waitTime + "',destructor = '" + this.destructor + "',taskEnd = '" + this.taskEnd + "'}";
    }

    protected void constructor() {
        this.constructor = java.lang.System.currentTimeMillis();
    }

    public void execTime() {
        this.execTime = this.taskEnd - this.taskStart;
    }

    public void taskStart() {
        this.taskStart = java.lang.System.currentTimeMillis();
    }

    public void taskEnd() {
        this.taskEnd = java.lang.System.currentTimeMillis();
        execTime();
        destructor();
    }

    private void destructor() {
        waitTime();
        this.destructor = java.lang.System.currentTimeMillis();
    }

    public void waitTime() {
        this.waitTime = this.taskStart - this.constructor;
    }
}
