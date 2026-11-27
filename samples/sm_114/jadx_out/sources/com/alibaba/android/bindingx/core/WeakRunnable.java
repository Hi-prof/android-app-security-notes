package com.alibaba.android.bindingx.core;

/* JADX INFO: loaded from: classes.dex */
public class WeakRunnable implements java.lang.Runnable {
    private final java.lang.ref.WeakReference<java.lang.Runnable> mDelegateRunnable;

    public WeakRunnable(java.lang.Runnable runnable) {
        this.mDelegateRunnable = new java.lang.ref.WeakReference<>(runnable);
    }

    @Override // java.lang.Runnable
    public void run() {
        java.lang.Runnable runnable = this.mDelegateRunnable.get();
        if (runnable != null) {
            runnable.run();
        }
    }
}
