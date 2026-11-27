package com.facebook.soloader.recovery;

/* JADX INFO: loaded from: classes.dex */
public interface RecoveryStrategy {
    boolean recover(java.lang.UnsatisfiedLinkError unsatisfiedLinkError, com.facebook.soloader.SoSource[] soSourceArr);
}
