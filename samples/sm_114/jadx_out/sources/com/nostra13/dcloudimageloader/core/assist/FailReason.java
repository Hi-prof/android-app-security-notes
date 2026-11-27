package com.nostra13.dcloudimageloader.core.assist;

/* JADX INFO: loaded from: classes.dex */
public class FailReason {
    private final java.lang.Throwable cause;
    private final com.nostra13.dcloudimageloader.core.assist.FailReason.FailType type;

    public enum FailType {
        IO_ERROR,
        DECODING_ERROR,
        NETWORK_DENIED,
        OUT_OF_MEMORY,
        UNKNOWN
    }

    public FailReason(com.nostra13.dcloudimageloader.core.assist.FailReason.FailType failType, java.lang.Throwable th) {
        this.type = failType;
        this.cause = th;
    }

    public com.nostra13.dcloudimageloader.core.assist.FailReason.FailType getType() {
        return this.type;
    }

    public java.lang.Throwable getCause() {
        return this.cause;
    }
}
