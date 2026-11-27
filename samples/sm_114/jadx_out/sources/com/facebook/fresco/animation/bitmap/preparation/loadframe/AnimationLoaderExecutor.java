package com.facebook.fresco.animation.bitmap.preparation.loadframe;

/* JADX INFO: compiled from: AnimationLoaderExecutor.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/facebook/fresco/animation/bitmap/preparation/loadframe/AnimationLoaderExecutor;", "", "<init>", "()V", "frameThreadFactory", "Ljava/util/concurrent/ThreadFactory;", "executor", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "Ljava/util/concurrent/ExecutorService;", "execute", "", "task", "Ljava/lang/Runnable;", "animated-drawable_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AnimationLoaderExecutor {
    public static final com.facebook.fresco.animation.bitmap.preparation.loadframe.AnimationLoaderExecutor INSTANCE = new com.facebook.fresco.animation.bitmap.preparation.loadframe.AnimationLoaderExecutor();
    private static final java.util.concurrent.ExecutorService executor;
    private static final java.util.concurrent.ThreadFactory frameThreadFactory;

    private AnimationLoaderExecutor() {
    }

    static {
        java.util.concurrent.ThreadFactory threadFactory = new java.util.concurrent.ThreadFactory() { // from class: com.facebook.fresco.animation.bitmap.preparation.loadframe.AnimationLoaderExecutor$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.ThreadFactory
            public final java.lang.Thread newThread(java.lang.Runnable runnable) {
                return com.facebook.fresco.animation.bitmap.preparation.loadframe.AnimationLoaderExecutor.frameThreadFactory$lambda$0(runnable);
            }
        };
        frameThreadFactory = threadFactory;
        executor = java.util.concurrent.Executors.newCachedThreadPool(threadFactory);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.lang.Thread frameThreadFactory$lambda$0(java.lang.Runnable runnable) {
        java.lang.Thread thread = new java.lang.Thread(runnable);
        thread.setPriority(1);
        return thread;
    }

    public final void execute(java.lang.Runnable task) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(task, "task");
        executor.execute(task);
    }
}
