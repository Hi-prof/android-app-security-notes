package com.facebook.common.time;

/* JADX INFO: loaded from: classes.dex */
public class SystemClock implements com.facebook.common.time.Clock {
    private static final com.facebook.common.time.SystemClock INSTANCE = new com.facebook.common.time.SystemClock();

    private SystemClock() {
    }

    public static com.facebook.common.time.SystemClock get() {
        return INSTANCE;
    }

    @Override // com.facebook.common.time.Clock
    public long now() {
        return java.lang.System.currentTimeMillis();
    }
}
