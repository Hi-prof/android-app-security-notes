package com.taobao.weex.dom;

/* JADX INFO: loaded from: classes.dex */
public class WXEvent extends io.dcloud.feature.uniapp.dom.AbsEvent {
    @Override // io.dcloud.feature.uniapp.dom.AbsEvent, java.util.ArrayList
    public com.taobao.weex.dom.WXEvent clone() {
        com.taobao.weex.dom.WXEvent wXEvent = new com.taobao.weex.dom.WXEvent();
        wXEvent.addAll(this);
        if (getEventBindingArgs() != null) {
            wXEvent.setEventBindingArgs(getEventBindingArgs());
        }
        wXEvent.setEventBindingArgsValues(null);
        return wXEvent;
    }
}
