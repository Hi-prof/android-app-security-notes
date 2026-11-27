package com.taobao.weex.utils;

/* JADX INFO: loaded from: classes.dex */
public enum LogLevel implements io.dcloud.feature.uniapp.utils.AbsLogLevel {
    OFF(kotlinx.coroutines.DebugKt.DEBUG_PROPERTY_VALUE_OFF, 8, 7),
    WTF("wtf", 7, 7),
    TLOG("tlog", 6, 6),
    ERROR("error", 5, 6),
    WARN("warn", 4, 5),
    INFO("info", 3, 4),
    DEBUG("debug", 2, 3),
    VERBOSE("verbose", 1, 2),
    ALL("all", 0, 2);

    java.lang.String name;
    int priority;
    int value;

    LogLevel(java.lang.String str, int i, int i2) {
        this.name = str;
        this.value = i;
        this.priority = i2;
    }

    @Override // io.dcloud.feature.uniapp.utils.AbsLogLevel
    public java.lang.String getName() {
        return this.name;
    }

    @Override // io.dcloud.feature.uniapp.utils.AbsLogLevel
    public int getValue() {
        return this.value;
    }

    @Override // io.dcloud.feature.uniapp.utils.AbsLogLevel
    public int getPriority() {
        return this.priority;
    }

    @Override // io.dcloud.feature.uniapp.utils.AbsLogLevel
    public int compare(io.dcloud.feature.uniapp.utils.AbsLogLevel absLogLevel) {
        return this.value - absLogLevel.getValue();
    }
}
