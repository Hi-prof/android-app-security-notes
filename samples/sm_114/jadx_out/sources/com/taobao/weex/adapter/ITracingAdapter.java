package com.taobao.weex.adapter;

/* JADX INFO: loaded from: classes.dex */
public interface ITracingAdapter {
    void disable();

    void enable();

    void submitTracingEvent(com.taobao.weex.tracing.WXTracing.TraceEvent traceEvent);
}
