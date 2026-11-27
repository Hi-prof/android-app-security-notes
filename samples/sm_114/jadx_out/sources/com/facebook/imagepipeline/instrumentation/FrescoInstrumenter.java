package com.facebook.imagepipeline.instrumentation;

/* JADX INFO: compiled from: FrescoInstrumenter.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0018B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0007J\u0014\u0010\f\u001a\u0004\u0018\u00010\u00012\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007J\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00012\b\u0010\u0010\u001a\u0004\u0018\u00010\u00012\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007J\u0012\u0010\u0011\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0007J\u001a\u0010\u0012\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J \u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0001\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n8G¢\u0006\u0006\u001a\u0004\b\t\u0010\u000b¨\u0006\u0019"}, d2 = {"Lcom/facebook/imagepipeline/instrumentation/FrescoInstrumenter;", "", "<init>", "()V", "instance", "Lcom/facebook/imagepipeline/instrumentation/FrescoInstrumenter$Instrumenter;", "provide", "", "instrumenter", "isTracing", "", "()Z", "onBeforeSubmitWork", "tag", "", "onBeginWork", com.alibaba.android.bindingx.core.internal.BindingXConstants.KEY_TOKEN, "onEndWork", "markFailure", "th", "", "decorateRunnable", "Ljava/lang/Runnable;", "runnable", "Instrumenter", "imagepipeline-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FrescoInstrumenter {
    public static final com.facebook.imagepipeline.instrumentation.FrescoInstrumenter INSTANCE = new com.facebook.imagepipeline.instrumentation.FrescoInstrumenter();
    private static volatile com.facebook.imagepipeline.instrumentation.FrescoInstrumenter.Instrumenter instance;

    /* JADX INFO: compiled from: FrescoInstrumenter.kt */
    @kotlin.Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001c\u0010\b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\t\u001a\u00020\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u0001H&J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000eH&J\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u0007H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004¨\u0006\u0012"}, d2 = {"Lcom/facebook/imagepipeline/instrumentation/FrescoInstrumenter$Instrumenter;", "", "isTracing", "", "()Z", "onBeforeSubmitWork", "tag", "", "onBeginWork", com.alibaba.android.bindingx.core.internal.BindingXConstants.KEY_TOKEN, "onEndWork", "", "markFailure", "th", "", "decorateRunnable", "Ljava/lang/Runnable;", "runnable", "imagepipeline-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface Instrumenter {
        java.lang.Runnable decorateRunnable(java.lang.Runnable runnable, java.lang.String tag);

        boolean isTracing();

        void markFailure(java.lang.Object token, java.lang.Throwable th);

        java.lang.Object onBeforeSubmitWork(java.lang.String tag);

        java.lang.Object onBeginWork(java.lang.Object token, java.lang.String tag);

        void onEndWork(java.lang.Object token);
    }

    private FrescoInstrumenter() {
    }

    @kotlin.jvm.JvmStatic
    public static final void provide(com.facebook.imagepipeline.instrumentation.FrescoInstrumenter.Instrumenter instrumenter) {
        instance = instrumenter;
    }

    @kotlin.jvm.JvmStatic
    public static final boolean isTracing() {
        com.facebook.imagepipeline.instrumentation.FrescoInstrumenter.Instrumenter instrumenter = instance;
        if (instrumenter == null) {
            return false;
        }
        return instrumenter.isTracing();
    }

    @kotlin.jvm.JvmStatic
    public static final java.lang.Object onBeforeSubmitWork(java.lang.String tag) {
        com.facebook.imagepipeline.instrumentation.FrescoInstrumenter.Instrumenter instrumenter = instance;
        if (instrumenter == null || tag == null) {
            return null;
        }
        return instrumenter.onBeforeSubmitWork(tag);
    }

    @kotlin.jvm.JvmStatic
    public static final java.lang.Object onBeginWork(java.lang.Object token, java.lang.String tag) {
        com.facebook.imagepipeline.instrumentation.FrescoInstrumenter.Instrumenter instrumenter = instance;
        if (instrumenter == null || token == null) {
            return null;
        }
        return instrumenter.onBeginWork(token, tag);
    }

    @kotlin.jvm.JvmStatic
    public static final void onEndWork(java.lang.Object token) {
        com.facebook.imagepipeline.instrumentation.FrescoInstrumenter.Instrumenter instrumenter = instance;
        if (instrumenter == null || token == null) {
            return;
        }
        instrumenter.onEndWork(token);
    }

    @kotlin.jvm.JvmStatic
    public static final void markFailure(java.lang.Object token, java.lang.Throwable th) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(th, "th");
        com.facebook.imagepipeline.instrumentation.FrescoInstrumenter.Instrumenter instrumenter = instance;
        if (instrumenter == null || token == null) {
            return;
        }
        instrumenter.markFailure(token, th);
    }

    @kotlin.jvm.JvmStatic
    public static final java.lang.Runnable decorateRunnable(java.lang.Runnable runnable, java.lang.String tag) {
        com.facebook.imagepipeline.instrumentation.FrescoInstrumenter.Instrumenter instrumenter = instance;
        if (instrumenter == null || runnable == null) {
            return runnable;
        }
        if (tag == null) {
            tag = "";
        }
        return instrumenter.decorateRunnable(runnable, tag);
    }
}
