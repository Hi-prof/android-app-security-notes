package pl.droidsonroids.gif;

/* JADX INFO: loaded from: classes2.dex */
final class GifRenderingExecutor extends java.util.concurrent.ScheduledThreadPoolExecutor implements java.lang.AutoCloseable {
    @Override // java.lang.AutoCloseable
    public /* synthetic */ void close() {
        kotlin.UByte$$ExternalSyntheticBackport0.m((java.util.concurrent.ExecutorService) this);
    }

    private static final class InstanceHolder {
        private static final pl.droidsonroids.gif.GifRenderingExecutor INSTANCE = new pl.droidsonroids.gif.GifRenderingExecutor();

        private InstanceHolder() {
        }
    }

    static pl.droidsonroids.gif.GifRenderingExecutor getInstance() {
        return pl.droidsonroids.gif.GifRenderingExecutor.InstanceHolder.INSTANCE;
    }

    private GifRenderingExecutor() {
        super(1, new java.util.concurrent.ThreadPoolExecutor.DiscardPolicy());
    }
}
