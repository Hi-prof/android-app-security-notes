package com.facebook.fresco.animation.bitmap.preparation.ondemandanimation;

/* JADX INFO: compiled from: AnimationCoordinator.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u001cH\u0002J\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u0011H\u0002J\u0016\u0010\"\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00102\u0006\u0010#\u001a\u00020$R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/facebook/fresco/animation/bitmap/preparation/ondemandanimation/AnimationCoordinator;", "", "<init>", "()V", "FREQUENCY_PERFORMANCE_MS", "", "FREQUENCY_LOADERS_MS", "FPS_STEP_PERCENTAGE", "", "MIN_RENDERING_FPS_PERCENTAGE", "successCounter", "Ljava/util/concurrent/atomic/AtomicInteger;", "failuresCounter", "criticalCounter", "runningAnimations", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/facebook/fresco/animation/bitmap/preparation/ondemandanimation/DynamicRenderingFps;", "", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "handler$delegate", "Lkotlin/Lazy;", "calculatePerformance", "Ljava/lang/Runnable;", "clearUnusedFrameLoaders", "schedulePerformance", "", "scheduleLoaders", "updateRenderingFps", "", "animation", "delta", "onRenderFrame", "frameResult", "Lcom/facebook/fresco/animation/bitmap/preparation/ondemandanimation/FrameResult;", "animated-drawable_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AnimationCoordinator {
    private static final float FPS_STEP_PERCENTAGE = 0.2f;
    private static final long FREQUENCY_LOADERS_MS = 10000;
    private static final long FREQUENCY_PERFORMANCE_MS = 2000;
    public static final com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.AnimationCoordinator INSTANCE;
    private static final float MIN_RENDERING_FPS_PERCENTAGE = 0.5f;
    private static final java.lang.Runnable calculatePerformance;
    private static final java.lang.Runnable clearUnusedFrameLoaders;
    private static final java.util.concurrent.atomic.AtomicInteger criticalCounter;
    private static final java.util.concurrent.atomic.AtomicInteger failuresCounter;

    /* JADX INFO: renamed from: handler$delegate, reason: from kotlin metadata */
    private static final kotlin.Lazy handler;
    private static final java.util.concurrent.ConcurrentHashMap<com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.DynamicRenderingFps, java.lang.Integer> runningAnimations;
    private static final java.util.concurrent.atomic.AtomicInteger successCounter;

    /* JADX INFO: compiled from: AnimationCoordinator.kt */
    @kotlin.Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.FrameResult.FrameType.values().length];
            try {
                iArr[com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.FrameResult.FrameType.SUCCESS.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                iArr[com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.FrameResult.FrameType.NEAREST.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                iArr[com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.FrameResult.FrameType.MISSING.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private AnimationCoordinator() {
    }

    static {
        com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.AnimationCoordinator animationCoordinator = new com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.AnimationCoordinator();
        INSTANCE = animationCoordinator;
        successCounter = new java.util.concurrent.atomic.AtomicInteger(0);
        failuresCounter = new java.util.concurrent.atomic.AtomicInteger(0);
        criticalCounter = new java.util.concurrent.atomic.AtomicInteger(0);
        runningAnimations = new java.util.concurrent.ConcurrentHashMap<>();
        handler = kotlin.LazyKt.lazy(new kotlin.jvm.functions.Function0() { // from class: com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.AnimationCoordinator$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final java.lang.Object invoke() {
                return com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.AnimationCoordinator.handler_delegate$lambda$0();
            }
        });
        java.lang.Runnable runnable = new java.lang.Runnable() { // from class: com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.AnimationCoordinator$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.AnimationCoordinator.calculatePerformance$lambda$3();
            }
        };
        calculatePerformance = runnable;
        java.lang.Runnable runnable2 = new java.lang.Runnable() { // from class: com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.AnimationCoordinator$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.AnimationCoordinator.clearUnusedFrameLoaders$lambda$4();
            }
        };
        clearUnusedFrameLoaders = runnable2;
        animationCoordinator.getHandler().post(runnable);
        animationCoordinator.getHandler().post(runnable2);
    }

    private final android.os.Handler getHandler() {
        return (android.os.Handler) handler.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final android.os.Handler handler_delegate$lambda$0() {
        android.os.HandlerThread handlerThread = new android.os.HandlerThread("FrescoAnimationWorker");
        handlerThread.start();
        return new android.os.Handler(handlerThread.getLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void calculatePerformance$lambda$3() {
        float andSet = successCounter.getAndSet(0);
        float andSet2 = failuresCounter.getAndSet(0);
        float andSet3 = criticalCounter.getAndSet(0);
        float f = andSet + andSet2 + andSet3;
        if (f > 0.0f) {
            float f2 = andSet / f;
            float f3 = andSet3 / f;
            if (andSet2 / f > 0.25f || f3 > 0.1f) {
                for (java.util.Map.Entry<com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.DynamicRenderingFps, java.lang.Integer> entry : runningAnimations.entrySet()) {
                    INSTANCE.updateRenderingFps(entry.getKey(), -entry.getValue().intValue());
                }
            } else if (f2 > 0.98f) {
                for (java.util.Map.Entry<com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.DynamicRenderingFps, java.lang.Integer> entry2 : runningAnimations.entrySet()) {
                    INSTANCE.updateRenderingFps(entry2.getKey(), entry2.getValue().intValue());
                }
            }
            runningAnimations.clear();
        }
        INSTANCE.schedulePerformance();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void clearUnusedFrameLoaders$lambda$4() {
        com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.FrameLoaderFactory.INSTANCE.clearUnusedUntil(new java.util.Date(java.lang.System.currentTimeMillis() - FREQUENCY_LOADERS_MS));
        INSTANCE.scheduleLoaders();
    }

    private final boolean schedulePerformance() {
        return getHandler().postDelayed(calculatePerformance, FREQUENCY_PERFORMANCE_MS);
    }

    private final boolean scheduleLoaders() {
        return getHandler().postDelayed(clearUnusedFrameLoaders, FREQUENCY_LOADERS_MS);
    }

    private final void updateRenderingFps(com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.DynamicRenderingFps animation, int delta) {
        int iCoerceIn = kotlin.ranges.RangesKt.coerceIn(animation.getRenderingFps() + delta, (int) kotlin.ranges.RangesKt.coerceAtLeast(animation.getAnimationFps() * 0.5f, 1.0f), animation.getAnimationFps());
        if (iCoerceIn != animation.getRenderingFps()) {
            animation.setRenderingFps(iCoerceIn);
        }
    }

    public final void onRenderFrame(com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.DynamicRenderingFps animation, com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.FrameResult frameResult) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(animation, "animation");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(frameResult, "frameResult");
        java.util.concurrent.ConcurrentHashMap<com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.DynamicRenderingFps, java.lang.Integer> concurrentHashMap = runningAnimations;
        if (!concurrentHashMap.contains(animation)) {
            concurrentHashMap.put(animation, java.lang.Integer.valueOf((int) (animation.getAnimationFps() * 0.2f)));
        }
        int i = com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.AnimationCoordinator.WhenMappings.$EnumSwitchMapping$0[frameResult.getType().ordinal()];
        if (i == 1) {
            successCounter.incrementAndGet();
        } else if (i == 2) {
            failuresCounter.incrementAndGet();
        } else {
            if (i != 3) {
                throw new kotlin.NoWhenBranchMatchedException();
            }
            criticalCounter.incrementAndGet();
        }
    }
}
