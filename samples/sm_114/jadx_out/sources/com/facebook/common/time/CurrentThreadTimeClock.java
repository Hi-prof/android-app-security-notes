package com.facebook.common.time;

/* JADX INFO: loaded from: classes.dex */
public class CurrentThreadTimeClock implements com.facebook.common.time.Clock {
    @Override // com.facebook.common.time.Clock
    public long now() {
        return android.os.SystemClock.currentThreadTimeMillis();
    }
}
