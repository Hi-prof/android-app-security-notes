package com.facebook.imagepipeline.core;

/* JADX INFO: compiled from: ImagePipeline.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000ê\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 u2\u00020\u0001:\u0001uB±\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r\u0012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00110\r\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\n\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\u0006\u0010\u001c\u001a\u00020\u001d¢\u0006\u0004\b\u001e\u0010\u001fJ\u0006\u0010.\u001a\u00020/J4\u00100\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f02010\n2\u0006\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010\u00012\b\u00106\u001a\u0004\u0018\u000107J>\u00100\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f02010\n2\u0006\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010\u00012\b\u00106\u001a\u0004\u0018\u0001072\b\u0010\"\u001a\u0004\u0018\u00010\u0006JH\u00100\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f02010\n2\u0006\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010\u00012\b\u00106\u001a\u0004\u0018\u0001072\b\u0010\"\u001a\u0004\u0018\u00010\u00062\b\u00108\u001a\u0004\u0018\u00010/J*\u00109\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001102010\n2\u0006\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010\u0001J$\u0010:\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f02012\u0006\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010\u0001JJ\u0010;\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f02012\b\u00103\u001a\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010<\u001a\u0004\u0018\u0001072\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u00108\u001a\u0004\u0018\u00010/J&\u0010;\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f02012\b\u00103\u001a\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u00010\u0001J.\u0010;\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f02012\b\u00103\u001a\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u00010\u00012\u0006\u0010\"\u001a\u00020\u0006J.\u0010;\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f02012\b\u00103\u001a\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u00010\u00012\u0006\u0010<\u001a\u000207JV\u0010;\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f02012\b\u00103\u001a\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u00010\u00012\u0006\u0010<\u001a\u0002072\b\u0010\"\u001a\u0004\u0018\u00010\u00062\b\u00108\u001a\u0004\u0018\u00010/2\u0012\u0010=\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0002\b\u0003\u0018\u00010>J$\u0010?\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001102012\u0006\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010\u0001J.\u0010?\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001102012\u0006\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010\u00012\b\u0010\"\u001a\u0004\u0018\u00010\u0006J$\u0010@\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010A012\b\u00103\u001a\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u00010\u0001H\u0007J.\u0010@\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010A012\b\u00103\u001a\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u00010\u00012\b\u0010\"\u001a\u0004\u0018\u00010\u0006H\u0007J,\u0010B\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010A012\b\u00103\u001a\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u00010\u00012\b\u0010\"\u001a\u0004\u0018\u00010\u0006J\"\u0010B\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010A012\b\u00103\u001a\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u00010\u0001J*\u0010B\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010A012\b\u00103\u001a\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u00010\u00012\u0006\u0010C\u001a\u00020DJ6\u0010B\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010A012\b\u00103\u001a\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u00010\u00012\u0006\u0010C\u001a\u00020D2\b\u0010\"\u001a\u0004\u0018\u00010\u0006H\u0007J,\u0010E\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010A012\b\u00103\u001a\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u00010\u00012\b\u0010\"\u001a\u0004\u0018\u00010\u0006J:\u0010E\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010A012\b\u00103\u001a\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010C\u001a\u00020D2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0006H\u0007J\u000e\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020IJ\u0010\u0010J\u001a\u00020G2\b\u0010H\u001a\u0004\u0018\u00010IJ\u0010\u0010J\u001a\u00020G2\b\u00103\u001a\u0004\u0018\u000104J\u000e\u0010K\u001a\u00020G2\u0006\u0010H\u001a\u00020IJ\u0006\u0010L\u001a\u00020GJ\u0006\u0010M\u001a\u00020GJ\u0006\u0010R\u001a\u00020GJ\u0010\u0010S\u001a\u00020\u000b2\b\u0010H\u001a\u0004\u0018\u00010IJ\u0010\u0010S\u001a\u00020\u000b2\b\u00103\u001a\u0004\u0018\u000104J\u0010\u0010T\u001a\u00020\u000b2\b\u0010H\u001a\u0004\u0018\u00010IJ\u0010\u0010T\u001a\u00020\u000b2\b\u00103\u001a\u0004\u0018\u000104J\u0010\u0010U\u001a\u00020\u000b2\b\u0010H\u001a\u0004\u0018\u00010IJ\u001a\u0010U\u001a\u00020\u000b2\b\u0010H\u001a\u0004\u0018\u00010I2\b\u0010V\u001a\u0004\u0018\u00010WJ\u0010\u0010X\u001a\u00020\u000b2\u0006\u00103\u001a\u000204H\u0002J\u000e\u0010U\u001a\u00020\u000b2\u0006\u00103\u001a\u000204J\u0016\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u000b012\b\u0010H\u001a\u0004\u0018\u00010IJ<\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u000b0[2\b\u00103\u001a\u0004\u0018\u0001042\u0006\u0010\\\u001a\u00020\u000e2\u0012\u0010]\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020A0^2\u0006\u0010_\u001a\u00020`H\u0002J\u0016\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u000b012\b\u00103\u001a\u0004\u0018\u000104J\u001c\u0010a\u001a\u0004\u0018\u00010\u000e2\b\u00103\u001a\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u00010\u0001J\u0018\u0010b\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u0001022\b\u0010\\\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010c\u001a\u00020\u000b2\b\u0010\\\u001a\u0004\u0018\u00010\u000eJ\\\u0010d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002He0201\"\u0004\b\u0000\u0010e2\u0012\u0010f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002He020g2\u0006\u00103\u001a\u0002042\u0006\u0010<\u001a\u0002072\b\u00105\u001a\u0004\u0018\u00010\u00012\b\u0010\"\u001a\u0004\u0018\u00010\u00062\b\u00108\u001a\u0004\u0018\u00010/H\u0002Jp\u0010d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002He0201\"\u0004\b\u0000\u0010e2\u0012\u0010f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002He020g2\u0006\u00103\u001a\u0002042\u0006\u0010<\u001a\u0002072\b\u00105\u001a\u0004\u0018\u00010\u00012\b\u0010\"\u001a\u0004\u0018\u00010\u00062\b\u00108\u001a\u0004\u0018\u00010/2\u0012\u0010=\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0002\b\u0003\u0018\u00010>H\u0002Jf\u0010d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002He0201\"\u0004\b\u0000\u0010e2\u0012\u0010f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002He020g2\u0006\u00103\u001a\u0002042\u0006\u0010<\u001a\u0002072\b\u00105\u001a\u0004\u0018\u00010\u00012\b\u0010\"\u001a\u0004\u0018\u00010\u00062\u0012\u0010=\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0002\b\u0003\u0018\u00010>H\u0002J@\u0010d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002He0201\"\u0004\b\u0000\u0010e2\u0014\u0010f\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u0002He\u0018\u0001020g2\u0006\u0010h\u001a\u00020i2\b\u0010\"\u001a\u0004\u0018\u00010\u0006JL\u0010j\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010A012\u000e\u0010f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010A0g2\u0006\u00103\u001a\u0002042\u0006\u0010<\u001a\u0002072\b\u00105\u001a\u0004\u0018\u00010\u00012\u0006\u0010C\u001a\u00020D2\b\u0010\"\u001a\u0004\u0018\u00010\u0006H\u0002J\u001a\u0010k\u001a\u00020\u00062\b\u00103\u001a\u0004\u0018\u0001042\b\u0010\"\u001a\u0004\u0018\u00010\u0006J\u0010\u0010l\u001a\u00020\u00062\b\u0010m\u001a\u0004\u0018\u00010\u0006J\u0016\u0010n\u001a\b\u0012\u0004\u0012\u00020\u000e0o2\u0006\u0010H\u001a\u00020IH\u0002J\u0006\u0010p\u001a\u00020GJ\u0006\u0010q\u001a\u00020GJ\u0006\u0010t\u001a\u00020GR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00110\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010*\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001c\u001a\u00020\u001d¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010N\u001a\u00020O8F¢\u0006\u0006\u001a\u0004\bP\u0010QR\u0011\u0010r\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\br\u0010s¨\u0006v"}, d2 = {"Lcom/facebook/imagepipeline/core/ImagePipeline;", "", "producerSequenceFactory", "Lcom/facebook/imagepipeline/core/ProducerSequenceFactory;", "requestListeners", "", "Lcom/facebook/imagepipeline/listener/RequestListener;", "requestListener2s", "Lcom/facebook/imagepipeline/listener/RequestListener2;", "isPrefetchEnabledSupplier", "Lcom/facebook/common/internal/Supplier;", "", "bitmapMemoryCache", "Lcom/facebook/imagepipeline/cache/MemoryCache;", "Lcom/facebook/cache/common/CacheKey;", "Lcom/facebook/imagepipeline/image/CloseableImage;", "encodedMemoryCache", "Lcom/facebook/common/memory/PooledByteBuffer;", "diskCachesStoreSupplier", "Lcom/facebook/imagepipeline/core/DiskCachesStore;", "cacheKeyFactory", "Lcom/facebook/imagepipeline/cache/CacheKeyFactory;", "threadHandoffProducerQueue", "Lcom/facebook/imagepipeline/producers/ThreadHandoffProducerQueue;", "suppressBitmapPrefetchingSupplier", "lazyDataSource", "callerContextVerifier", "Lcom/facebook/callercontext/CallerContextVerifier;", com.alibaba.android.bindingx.core.internal.BindingXConstants.KEY_CONFIG, "Lcom/facebook/imagepipeline/core/ImagePipelineConfigInterface;", "<init>", "(Lcom/facebook/imagepipeline/core/ProducerSequenceFactory;Ljava/util/Set;Ljava/util/Set;Lcom/facebook/common/internal/Supplier;Lcom/facebook/imagepipeline/cache/MemoryCache;Lcom/facebook/imagepipeline/cache/MemoryCache;Lcom/facebook/common/internal/Supplier;Lcom/facebook/imagepipeline/cache/CacheKeyFactory;Lcom/facebook/imagepipeline/producers/ThreadHandoffProducerQueue;Lcom/facebook/common/internal/Supplier;Lcom/facebook/common/internal/Supplier;Lcom/facebook/callercontext/CallerContextVerifier;Lcom/facebook/imagepipeline/core/ImagePipelineConfigInterface;)V", "getProducerSequenceFactory", "()Lcom/facebook/imagepipeline/core/ProducerSequenceFactory;", "requestListener", "requestListener2", "getBitmapMemoryCache", "()Lcom/facebook/imagepipeline/cache/MemoryCache;", "getCacheKeyFactory", "()Lcom/facebook/imagepipeline/cache/CacheKeyFactory;", "idCounter", "Ljava/util/concurrent/atomic/AtomicLong;", "isLazyDataSource", "()Lcom/facebook/common/internal/Supplier;", "getConfig", "()Lcom/facebook/imagepipeline/core/ImagePipelineConfigInterface;", "generateUniqueFutureId", "", "getDataSourceSupplier", "Lcom/facebook/datasource/DataSource;", "Lcom/facebook/common/references/CloseableReference;", "imageRequest", "Lcom/facebook/imagepipeline/request/ImageRequest;", "callerContext", "requestLevel", "Lcom/facebook/imagepipeline/request/ImageRequest$RequestLevel;", "uiComponentId", "getEncodedImageDataSourceSupplier", "fetchImageFromBitmapCache", "fetchDecodedImage", "lowestPermittedRequestLevelOnSubmit", "extras", "", "fetchEncodedImage", "prefetchToBitmapCache", "Ljava/lang/Void;", "prefetchToDiskCache", "priority", "Lcom/facebook/imagepipeline/common/Priority;", "prefetchToEncodedCache", "evictFromMemoryCache", "", "uri", "Landroid/net/Uri;", "evictFromDiskCache", "evictFromCache", "clearMemoryCaches", "clearDiskCaches", "usedDiskCacheSize", "", "getUsedDiskCacheSize", "()J", "clearCaches", "isInBitmapMemoryCache", "isInEncodedMemoryCache", "isInDiskCacheSync", "cacheChoice", "Lcom/facebook/imagepipeline/request/ImageRequest$CacheChoice;", "isInDynamicDiskCachesSync", "isInDiskCache", "isInDynamicDiskCaches", "Lbolts/Task;", "cacheKey", "intermediateContinuation", "Lbolts/Continuation;", "cts", "Lbolts/CancellationTokenSource;", "getCacheKey", "getCachedImage", "hasCachedImage", "submitFetchRequest", "T", "producerSequence", "Lcom/facebook/imagepipeline/producers/Producer;", "settableProducerContext", "Lcom/facebook/imagepipeline/producers/SettableProducerContext;", "submitPrefetchRequest", "getRequestListenerForRequest", "getCombinedRequestListener", "listener", "predicateForUri", "Lcom/facebook/common/internal/Predicate;", "pause", io.dcloud.common.constant.AbsoluteConst.EVENTS_RESUME, "isPaused", "()Z", "init", "Companion", "imagepipeline_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ImagePipeline {
    private final com.facebook.imagepipeline.cache.MemoryCache<com.facebook.cache.common.CacheKey, com.facebook.imagepipeline.image.CloseableImage> bitmapMemoryCache;
    private final com.facebook.imagepipeline.cache.CacheKeyFactory cacheKeyFactory;
    private final com.facebook.callercontext.CallerContextVerifier callerContextVerifier;
    private final com.facebook.imagepipeline.core.ImagePipelineConfigInterface config;
    private final com.facebook.common.internal.Supplier<com.facebook.imagepipeline.core.DiskCachesStore> diskCachesStoreSupplier;
    private final com.facebook.imagepipeline.cache.MemoryCache<com.facebook.cache.common.CacheKey, com.facebook.common.memory.PooledByteBuffer> encodedMemoryCache;
    private final java.util.concurrent.atomic.AtomicLong idCounter;
    private final com.facebook.common.internal.Supplier<java.lang.Boolean> isLazyDataSource;
    private final com.facebook.common.internal.Supplier<java.lang.Boolean> isPrefetchEnabledSupplier;
    private final com.facebook.imagepipeline.core.ProducerSequenceFactory producerSequenceFactory;
    private final com.facebook.imagepipeline.listener.RequestListener requestListener;
    private final com.facebook.imagepipeline.listener.RequestListener2 requestListener2;
    private final com.facebook.common.internal.Supplier<java.lang.Boolean> suppressBitmapPrefetchingSupplier;
    private final com.facebook.imagepipeline.producers.ThreadHandoffProducerQueue threadHandoffProducerQueue;
    private static final java.util.concurrent.CancellationException PREFETCH_EXCEPTION = new java.util.concurrent.CancellationException("Prefetching is not enabled");
    private static final java.util.concurrent.CancellationException NULL_IMAGEREQUEST_EXCEPTION = new java.util.concurrent.CancellationException("ImageRequest is null");
    private static final java.util.concurrent.CancellationException MODIFIED_URL_IS_NULL = new java.util.concurrent.CancellationException("Modified URL is null");

    /* JADX INFO: compiled from: ImagePipeline.kt */
    @kotlin.Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[com.facebook.imagepipeline.request.ImageRequest.CacheChoice.values().length];
            try {
                iArr[com.facebook.imagepipeline.request.ImageRequest.CacheChoice.DEFAULT.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                iArr[com.facebook.imagepipeline.request.ImageRequest.CacheChoice.SMALL.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                iArr[com.facebook.imagepipeline.request.ImageRequest.CacheChoice.DYNAMIC.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean clearMemoryCaches$lambda$3(com.facebook.cache.common.CacheKey it) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(it, "it");
        return true;
    }

    public final void init() {
    }

    public final com.facebook.datasource.DataSource<java.lang.Void> prefetchToEncodedCache(com.facebook.imagepipeline.request.ImageRequest imageRequest, java.lang.Object obj) {
        return prefetchToEncodedCache$default(this, imageRequest, obj, null, null, 12, null);
    }

    public final com.facebook.datasource.DataSource<java.lang.Void> prefetchToEncodedCache(com.facebook.imagepipeline.request.ImageRequest imageRequest, java.lang.Object obj, com.facebook.imagepipeline.common.Priority priority) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(priority, "priority");
        return prefetchToEncodedCache$default(this, imageRequest, obj, priority, null, 8, null);
    }

    public ImagePipeline(com.facebook.imagepipeline.core.ProducerSequenceFactory producerSequenceFactory, java.util.Set<? extends com.facebook.imagepipeline.listener.RequestListener> requestListeners, java.util.Set<? extends com.facebook.imagepipeline.listener.RequestListener2> requestListener2s, com.facebook.common.internal.Supplier<java.lang.Boolean> isPrefetchEnabledSupplier, com.facebook.imagepipeline.cache.MemoryCache<com.facebook.cache.common.CacheKey, com.facebook.imagepipeline.image.CloseableImage> bitmapMemoryCache, com.facebook.imagepipeline.cache.MemoryCache<com.facebook.cache.common.CacheKey, com.facebook.common.memory.PooledByteBuffer> encodedMemoryCache, com.facebook.common.internal.Supplier<com.facebook.imagepipeline.core.DiskCachesStore> diskCachesStoreSupplier, com.facebook.imagepipeline.cache.CacheKeyFactory cacheKeyFactory, com.facebook.imagepipeline.producers.ThreadHandoffProducerQueue threadHandoffProducerQueue, com.facebook.common.internal.Supplier<java.lang.Boolean> suppressBitmapPrefetchingSupplier, com.facebook.common.internal.Supplier<java.lang.Boolean> lazyDataSource, com.facebook.callercontext.CallerContextVerifier callerContextVerifier, com.facebook.imagepipeline.core.ImagePipelineConfigInterface config) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(producerSequenceFactory, "producerSequenceFactory");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(requestListeners, "requestListeners");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(requestListener2s, "requestListener2s");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(isPrefetchEnabledSupplier, "isPrefetchEnabledSupplier");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(bitmapMemoryCache, "bitmapMemoryCache");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(encodedMemoryCache, "encodedMemoryCache");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(diskCachesStoreSupplier, "diskCachesStoreSupplier");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(cacheKeyFactory, "cacheKeyFactory");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(threadHandoffProducerQueue, "threadHandoffProducerQueue");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(suppressBitmapPrefetchingSupplier, "suppressBitmapPrefetchingSupplier");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(lazyDataSource, "lazyDataSource");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(config, "config");
        this.producerSequenceFactory = producerSequenceFactory;
        this.isPrefetchEnabledSupplier = isPrefetchEnabledSupplier;
        this.diskCachesStoreSupplier = diskCachesStoreSupplier;
        this.requestListener = new com.facebook.imagepipeline.listener.ForwardingRequestListener((java.util.Set<com.facebook.imagepipeline.listener.RequestListener>) requestListeners);
        this.requestListener2 = new com.facebook.imagepipeline.listener.ForwardingRequestListener2(requestListener2s);
        this.idCounter = new java.util.concurrent.atomic.AtomicLong();
        this.bitmapMemoryCache = bitmapMemoryCache;
        this.encodedMemoryCache = encodedMemoryCache;
        this.cacheKeyFactory = cacheKeyFactory;
        this.threadHandoffProducerQueue = threadHandoffProducerQueue;
        this.suppressBitmapPrefetchingSupplier = suppressBitmapPrefetchingSupplier;
        this.isLazyDataSource = lazyDataSource;
        this.callerContextVerifier = callerContextVerifier;
        this.config = config;
    }

    public final com.facebook.imagepipeline.core.ProducerSequenceFactory getProducerSequenceFactory() {
        return this.producerSequenceFactory;
    }

    public final com.facebook.imagepipeline.cache.MemoryCache<com.facebook.cache.common.CacheKey, com.facebook.imagepipeline.image.CloseableImage> getBitmapMemoryCache() {
        return this.bitmapMemoryCache;
    }

    public final com.facebook.imagepipeline.cache.CacheKeyFactory getCacheKeyFactory() {
        return this.cacheKeyFactory;
    }

    public final com.facebook.common.internal.Supplier<java.lang.Boolean> isLazyDataSource() {
        return this.isLazyDataSource;
    }

    public final com.facebook.imagepipeline.core.ImagePipelineConfigInterface getConfig() {
        return this.config;
    }

    public final java.lang.String generateUniqueFutureId() {
        return java.lang.String.valueOf(this.idCounter.getAndIncrement());
    }

    public final com.facebook.common.internal.Supplier<com.facebook.datasource.DataSource<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>>> getDataSourceSupplier(final com.facebook.imagepipeline.request.ImageRequest imageRequest, final java.lang.Object callerContext, final com.facebook.imagepipeline.request.ImageRequest.RequestLevel requestLevel) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        return new com.facebook.common.internal.Supplier<com.facebook.datasource.DataSource<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>>>() { // from class: com.facebook.imagepipeline.core.ImagePipeline.getDataSourceSupplier.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.facebook.common.internal.Supplier
            public com.facebook.datasource.DataSource<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> get() {
                return com.facebook.imagepipeline.core.ImagePipeline.fetchDecodedImage$default(com.facebook.imagepipeline.core.ImagePipeline.this, imageRequest, callerContext, requestLevel, null, null, 24, null);
            }

            public java.lang.String toString() {
                java.lang.String string = com.facebook.common.internal.Objects.toStringHelper(this).add("uri", imageRequest.getSourceUri()).toString();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                return string;
            }
        };
    }

    public final com.facebook.common.internal.Supplier<com.facebook.datasource.DataSource<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>>> getDataSourceSupplier(final com.facebook.imagepipeline.request.ImageRequest imageRequest, final java.lang.Object callerContext, final com.facebook.imagepipeline.request.ImageRequest.RequestLevel requestLevel, final com.facebook.imagepipeline.listener.RequestListener requestListener) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        return new com.facebook.common.internal.Supplier<com.facebook.datasource.DataSource<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>>>() { // from class: com.facebook.imagepipeline.core.ImagePipeline.getDataSourceSupplier.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.facebook.common.internal.Supplier
            public com.facebook.datasource.DataSource<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> get() {
                return com.facebook.imagepipeline.core.ImagePipeline.fetchDecodedImage$default(com.facebook.imagepipeline.core.ImagePipeline.this, imageRequest, callerContext, requestLevel, requestListener, null, 16, null);
            }

            public java.lang.String toString() {
                java.lang.String string = com.facebook.common.internal.Objects.toStringHelper(this).add("uri", imageRequest.getSourceUri()).toString();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                return string;
            }
        };
    }

    public final com.facebook.common.internal.Supplier<com.facebook.datasource.DataSource<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>>> getDataSourceSupplier(final com.facebook.imagepipeline.request.ImageRequest imageRequest, final java.lang.Object callerContext, final com.facebook.imagepipeline.request.ImageRequest.RequestLevel requestLevel, final com.facebook.imagepipeline.listener.RequestListener requestListener, final java.lang.String uiComponentId) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        return new com.facebook.common.internal.Supplier<com.facebook.datasource.DataSource<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>>>() { // from class: com.facebook.imagepipeline.core.ImagePipeline.getDataSourceSupplier.3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.facebook.common.internal.Supplier
            public com.facebook.datasource.DataSource<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> get() {
                return com.facebook.imagepipeline.core.ImagePipeline.this.fetchDecodedImage(imageRequest, callerContext, requestLevel, requestListener, uiComponentId);
            }

            public java.lang.String toString() {
                java.lang.String string = com.facebook.common.internal.Objects.toStringHelper(this).add("uri", imageRequest.getSourceUri()).toString();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                return string;
            }
        };
    }

    public final com.facebook.common.internal.Supplier<com.facebook.datasource.DataSource<com.facebook.common.references.CloseableReference<com.facebook.common.memory.PooledByteBuffer>>> getEncodedImageDataSourceSupplier(final com.facebook.imagepipeline.request.ImageRequest imageRequest, final java.lang.Object callerContext) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        return new com.facebook.common.internal.Supplier<com.facebook.datasource.DataSource<com.facebook.common.references.CloseableReference<com.facebook.common.memory.PooledByteBuffer>>>() { // from class: com.facebook.imagepipeline.core.ImagePipeline.getEncodedImageDataSourceSupplier.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.facebook.common.internal.Supplier
            public com.facebook.datasource.DataSource<com.facebook.common.references.CloseableReference<com.facebook.common.memory.PooledByteBuffer>> get() {
                return com.facebook.imagepipeline.core.ImagePipeline.this.fetchEncodedImage(imageRequest, callerContext);
            }

            public java.lang.String toString() {
                java.lang.String string = com.facebook.common.internal.Objects.toStringHelper(this).add("uri", imageRequest.getSourceUri()).toString();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                return string;
            }
        };
    }

    public final com.facebook.datasource.DataSource<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> fetchImageFromBitmapCache(com.facebook.imagepipeline.request.ImageRequest imageRequest, java.lang.Object callerContext) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        return fetchDecodedImage(imageRequest, callerContext, com.facebook.imagepipeline.request.ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE);
    }

    public static /* synthetic */ com.facebook.datasource.DataSource fetchDecodedImage$default(com.facebook.imagepipeline.core.ImagePipeline imagePipeline, com.facebook.imagepipeline.request.ImageRequest imageRequest, java.lang.Object obj, com.facebook.imagepipeline.request.ImageRequest.RequestLevel requestLevel, com.facebook.imagepipeline.listener.RequestListener requestListener, java.lang.String str, int i, java.lang.Object obj2) {
        if ((i & 4) != 0) {
            requestLevel = null;
        }
        if ((i & 8) != 0) {
            requestListener = null;
        }
        if ((i & 16) != 0) {
            str = null;
        }
        return imagePipeline.fetchDecodedImage(imageRequest, obj, requestLevel, requestListener, str);
    }

    public final com.facebook.datasource.DataSource<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> fetchDecodedImage(com.facebook.imagepipeline.request.ImageRequest imageRequest, java.lang.Object callerContext, com.facebook.imagepipeline.request.ImageRequest.RequestLevel lowestPermittedRequestLevelOnSubmit, com.facebook.imagepipeline.listener.RequestListener requestListener, java.lang.String uiComponentId) {
        if (imageRequest == null) {
            com.facebook.datasource.DataSource<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> dataSourceImmediateFailedDataSource = com.facebook.datasource.DataSources.immediateFailedDataSource(new java.lang.NullPointerException());
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(dataSourceImmediateFailedDataSource, "immediateFailedDataSource(...)");
            return dataSourceImmediateFailedDataSource;
        }
        try {
            com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> decodedImageProducerSequence = this.producerSequenceFactory.getDecodedImageProducerSequence(imageRequest);
            if (lowestPermittedRequestLevelOnSubmit == null) {
                lowestPermittedRequestLevelOnSubmit = com.facebook.imagepipeline.request.ImageRequest.RequestLevel.FULL_FETCH;
            }
            return submitFetchRequest(decodedImageProducerSequence, imageRequest, lowestPermittedRequestLevelOnSubmit, callerContext, requestListener, uiComponentId);
        } catch (java.lang.Exception e) {
            return com.facebook.datasource.DataSources.immediateFailedDataSource(e);
        }
    }

    public final com.facebook.datasource.DataSource<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> fetchDecodedImage(com.facebook.imagepipeline.request.ImageRequest imageRequest, java.lang.Object callerContext) {
        return fetchDecodedImage$default(this, imageRequest, callerContext, null, null, null, 24, null);
    }

    public final com.facebook.datasource.DataSource<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> fetchDecodedImage(com.facebook.imagepipeline.request.ImageRequest imageRequest, java.lang.Object callerContext, com.facebook.imagepipeline.listener.RequestListener requestListener) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(requestListener, "requestListener");
        return fetchDecodedImage$default(this, imageRequest, callerContext, null, requestListener, null, 16, null);
    }

    public final com.facebook.datasource.DataSource<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> fetchDecodedImage(com.facebook.imagepipeline.request.ImageRequest imageRequest, java.lang.Object callerContext, com.facebook.imagepipeline.request.ImageRequest.RequestLevel lowestPermittedRequestLevelOnSubmit) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(lowestPermittedRequestLevelOnSubmit, "lowestPermittedRequestLevelOnSubmit");
        return fetchDecodedImage$default(this, imageRequest, callerContext, lowestPermittedRequestLevelOnSubmit, null, null, 16, null);
    }

    public final com.facebook.datasource.DataSource<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> fetchDecodedImage(com.facebook.imagepipeline.request.ImageRequest imageRequest, java.lang.Object callerContext, com.facebook.imagepipeline.request.ImageRequest.RequestLevel lowestPermittedRequestLevelOnSubmit, com.facebook.imagepipeline.listener.RequestListener requestListener, java.lang.String uiComponentId, java.util.Map<java.lang.String, ?> extras) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(lowestPermittedRequestLevelOnSubmit, "lowestPermittedRequestLevelOnSubmit");
        if (imageRequest == null) {
            com.facebook.datasource.DataSource<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> dataSourceImmediateFailedDataSource = com.facebook.datasource.DataSources.immediateFailedDataSource(new java.lang.NullPointerException());
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(dataSourceImmediateFailedDataSource, "immediateFailedDataSource(...)");
            return dataSourceImmediateFailedDataSource;
        }
        try {
            return submitFetchRequest(this.producerSequenceFactory.getDecodedImageProducerSequence(imageRequest), imageRequest, lowestPermittedRequestLevelOnSubmit, callerContext, requestListener, uiComponentId, extras);
        } catch (java.lang.Exception e) {
            return com.facebook.datasource.DataSources.immediateFailedDataSource(e);
        }
    }

    public final com.facebook.datasource.DataSource<com.facebook.common.references.CloseableReference<com.facebook.common.memory.PooledByteBuffer>> fetchEncodedImage(com.facebook.imagepipeline.request.ImageRequest imageRequest, java.lang.Object callerContext) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        return fetchEncodedImage(imageRequest, callerContext, null);
    }

    public final com.facebook.datasource.DataSource<com.facebook.common.references.CloseableReference<com.facebook.common.memory.PooledByteBuffer>> fetchEncodedImage(com.facebook.imagepipeline.request.ImageRequest imageRequest, java.lang.Object callerContext, com.facebook.imagepipeline.listener.RequestListener requestListener) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        if (imageRequest.getSourceUri() == null) {
            throw new java.lang.IllegalStateException("Required value was null.".toString());
        }
        try {
            com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.common.memory.PooledByteBuffer>> encodedImageProducerSequence = this.producerSequenceFactory.getEncodedImageProducerSequence(imageRequest);
            if (imageRequest.getResizeOptions() != null) {
                imageRequest = com.facebook.imagepipeline.request.ImageRequestBuilder.fromRequest(imageRequest).setResizeOptions(null).build();
            }
            return submitFetchRequest(encodedImageProducerSequence, imageRequest, com.facebook.imagepipeline.request.ImageRequest.RequestLevel.FULL_FETCH, callerContext, requestListener, null, null);
        } catch (java.lang.Exception e) {
            return com.facebook.datasource.DataSources.immediateFailedDataSource(e);
        }
    }

    public final com.facebook.datasource.DataSource<java.lang.Void> prefetchToBitmapCache(com.facebook.imagepipeline.request.ImageRequest imageRequest, java.lang.Object callerContext) {
        return prefetchToBitmapCache(imageRequest, callerContext, null);
    }

    public final com.facebook.datasource.DataSource<java.lang.Void> prefetchToBitmapCache(com.facebook.imagepipeline.request.ImageRequest imageRequest, java.lang.Object callerContext, com.facebook.imagepipeline.listener.RequestListener requestListener) {
        com.facebook.datasource.DataSource<java.lang.Void> dataSourceImmediateFailedDataSource;
        com.facebook.imagepipeline.producers.Producer<java.lang.Void> decodedImagePrefetchProducerSequence;
        java.lang.Exception exc;
        com.facebook.imagepipeline.producers.Producer<java.lang.Void> decodedImagePrefetchProducerSequence2;
        com.facebook.imagepipeline.systrace.FrescoSystrace frescoSystrace = com.facebook.imagepipeline.systrace.FrescoSystrace.INSTANCE;
        boolean zBooleanValue = true;
        if (!com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
            if (!this.isPrefetchEnabledSupplier.get().booleanValue()) {
                com.facebook.datasource.DataSource<java.lang.Void> dataSourceImmediateFailedDataSource2 = com.facebook.datasource.DataSources.immediateFailedDataSource(PREFETCH_EXCEPTION);
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(dataSourceImmediateFailedDataSource2, "immediateFailedDataSource(...)");
                return dataSourceImmediateFailedDataSource2;
            }
            try {
                if (this.config.getExperiments().getPrefetchShortcutEnabled()) {
                    try {
                        if (isInBitmapMemoryCache(imageRequest)) {
                            com.facebook.datasource.DataSource<java.lang.Void> dataSourceImmediateSuccessfulDataSource = com.facebook.datasource.DataSources.immediateSuccessfulDataSource();
                            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(dataSourceImmediateSuccessfulDataSource, "immediateSuccessfulDataSource(...)");
                            return dataSourceImmediateSuccessfulDataSource;
                        }
                    } catch (java.lang.Exception e) {
                        exc = e;
                    }
                }
                if (imageRequest == null) {
                    try {
                        throw new java.lang.IllegalStateException("Required value was null.".toString());
                    } catch (java.lang.Exception e2) {
                        e = e2;
                    }
                } else {
                    java.lang.Boolean boolShouldDecodePrefetches = imageRequest.shouldDecodePrefetches();
                    if (boolShouldDecodePrefetches != null) {
                        if (boolShouldDecodePrefetches.booleanValue()) {
                            zBooleanValue = false;
                        }
                    } else {
                        java.lang.Boolean bool = this.suppressBitmapPrefetchingSupplier.get();
                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bool, "get(...)");
                        zBooleanValue = bool.booleanValue();
                    }
                    if (zBooleanValue) {
                        decodedImagePrefetchProducerSequence2 = this.producerSequenceFactory.getEncodedImagePrefetchProducerSequence(imageRequest);
                    } else {
                        decodedImagePrefetchProducerSequence2 = this.producerSequenceFactory.getDecodedImagePrefetchProducerSequence(imageRequest);
                    }
                    try {
                        return submitPrefetchRequest(decodedImagePrefetchProducerSequence2, imageRequest, com.facebook.imagepipeline.request.ImageRequest.RequestLevel.FULL_FETCH, callerContext, com.facebook.imagepipeline.common.Priority.MEDIUM, requestListener);
                    } catch (java.lang.Exception e3) {
                        e = e3;
                    }
                }
            } catch (java.lang.Exception e4) {
                e = e4;
            }
            exc = e;
            return com.facebook.datasource.DataSources.immediateFailedDataSource(exc);
        }
        com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection("ImagePipeline#prefetchToBitmapCache");
        try {
            if (!this.isPrefetchEnabledSupplier.get().booleanValue()) {
                com.facebook.datasource.DataSource<java.lang.Void> dataSourceImmediateFailedDataSource3 = com.facebook.datasource.DataSources.immediateFailedDataSource(PREFETCH_EXCEPTION);
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(dataSourceImmediateFailedDataSource3, "immediateFailedDataSource(...)");
                com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
                return dataSourceImmediateFailedDataSource3;
            }
            try {
                if (this.config.getExperiments().getPrefetchShortcutEnabled() && isInBitmapMemoryCache(imageRequest)) {
                    com.facebook.datasource.DataSource<java.lang.Void> dataSourceImmediateSuccessfulDataSource2 = com.facebook.datasource.DataSources.immediateSuccessfulDataSource();
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(dataSourceImmediateSuccessfulDataSource2, "immediateSuccessfulDataSource(...)");
                    com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
                    return dataSourceImmediateSuccessfulDataSource2;
                }
                if (imageRequest == null) {
                    throw new java.lang.IllegalStateException("Required value was null.".toString());
                }
                java.lang.Boolean boolShouldDecodePrefetches2 = imageRequest.shouldDecodePrefetches();
                if (boolShouldDecodePrefetches2 != null) {
                    if (boolShouldDecodePrefetches2.booleanValue()) {
                        zBooleanValue = false;
                    }
                } else {
                    java.lang.Boolean bool2 = this.suppressBitmapPrefetchingSupplier.get();
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bool2, "get(...)");
                    zBooleanValue = bool2.booleanValue();
                }
                if (zBooleanValue) {
                    decodedImagePrefetchProducerSequence = this.producerSequenceFactory.getEncodedImagePrefetchProducerSequence(imageRequest);
                } else {
                    decodedImagePrefetchProducerSequence = this.producerSequenceFactory.getDecodedImagePrefetchProducerSequence(imageRequest);
                }
                dataSourceImmediateFailedDataSource = submitPrefetchRequest(decodedImagePrefetchProducerSequence, imageRequest, com.facebook.imagepipeline.request.ImageRequest.RequestLevel.FULL_FETCH, callerContext, com.facebook.imagepipeline.common.Priority.MEDIUM, requestListener);
                com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
                return dataSourceImmediateFailedDataSource;
            } catch (java.lang.Exception e5) {
                dataSourceImmediateFailedDataSource = com.facebook.datasource.DataSources.immediateFailedDataSource(e5);
            }
        } catch (java.lang.Throwable th) {
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
            throw th;
        }
    }

    public final com.facebook.datasource.DataSource<java.lang.Void> prefetchToDiskCache(com.facebook.imagepipeline.request.ImageRequest imageRequest, java.lang.Object callerContext, com.facebook.imagepipeline.listener.RequestListener requestListener) {
        return prefetchToDiskCache(imageRequest, callerContext, com.facebook.imagepipeline.common.Priority.MEDIUM, requestListener);
    }

    public final com.facebook.datasource.DataSource<java.lang.Void> prefetchToDiskCache(com.facebook.imagepipeline.request.ImageRequest imageRequest, java.lang.Object callerContext) {
        return prefetchToDiskCache(imageRequest, callerContext, com.facebook.imagepipeline.common.Priority.MEDIUM, null);
    }

    public final com.facebook.datasource.DataSource<java.lang.Void> prefetchToDiskCache(com.facebook.imagepipeline.request.ImageRequest imageRequest, java.lang.Object callerContext, com.facebook.imagepipeline.common.Priority priority) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(priority, "priority");
        return prefetchToDiskCache(imageRequest, callerContext, priority, null);
    }

    public final com.facebook.datasource.DataSource<java.lang.Void> prefetchToDiskCache(com.facebook.imagepipeline.request.ImageRequest imageRequest, java.lang.Object callerContext, com.facebook.imagepipeline.common.Priority priority, com.facebook.imagepipeline.listener.RequestListener requestListener) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(priority, "priority");
        if (!this.isPrefetchEnabledSupplier.get().booleanValue()) {
            com.facebook.datasource.DataSource<java.lang.Void> dataSourceImmediateFailedDataSource = com.facebook.datasource.DataSources.immediateFailedDataSource(PREFETCH_EXCEPTION);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(dataSourceImmediateFailedDataSource, "immediateFailedDataSource(...)");
            return dataSourceImmediateFailedDataSource;
        }
        if (imageRequest == null) {
            com.facebook.datasource.DataSource<java.lang.Void> dataSourceImmediateFailedDataSource2 = com.facebook.datasource.DataSources.immediateFailedDataSource(new java.lang.NullPointerException("imageRequest is null"));
            kotlin.jvm.internal.Intrinsics.checkNotNull(dataSourceImmediateFailedDataSource2);
            return dataSourceImmediateFailedDataSource2;
        }
        try {
            return submitPrefetchRequest(this.producerSequenceFactory.getEncodedImagePrefetchProducerSequence(imageRequest), imageRequest, com.facebook.imagepipeline.request.ImageRequest.RequestLevel.FULL_FETCH, callerContext, priority, requestListener);
        } catch (java.lang.Exception e) {
            return com.facebook.datasource.DataSources.immediateFailedDataSource(e);
        }
    }

    public final com.facebook.datasource.DataSource<java.lang.Void> prefetchToEncodedCache(com.facebook.imagepipeline.request.ImageRequest imageRequest, java.lang.Object callerContext, com.facebook.imagepipeline.listener.RequestListener requestListener) {
        return prefetchToEncodedCache(imageRequest, callerContext, com.facebook.imagepipeline.common.Priority.MEDIUM, requestListener);
    }

    public static /* synthetic */ com.facebook.datasource.DataSource prefetchToEncodedCache$default(com.facebook.imagepipeline.core.ImagePipeline imagePipeline, com.facebook.imagepipeline.request.ImageRequest imageRequest, java.lang.Object obj, com.facebook.imagepipeline.common.Priority priority, com.facebook.imagepipeline.listener.RequestListener requestListener, int i, java.lang.Object obj2) {
        if ((i & 4) != 0) {
            priority = com.facebook.imagepipeline.common.Priority.MEDIUM;
        }
        if ((i & 8) != 0) {
            requestListener = null;
        }
        return imagePipeline.prefetchToEncodedCache(imageRequest, obj, priority, requestListener);
    }

    public final com.facebook.datasource.DataSource<java.lang.Void> prefetchToEncodedCache(com.facebook.imagepipeline.request.ImageRequest imageRequest, java.lang.Object callerContext, com.facebook.imagepipeline.common.Priority priority, com.facebook.imagepipeline.listener.RequestListener requestListener) {
        com.facebook.datasource.DataSource<java.lang.Void> dataSourceImmediateFailedDataSource;
        java.lang.Exception exc;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(priority, "priority");
        com.facebook.imagepipeline.systrace.FrescoSystrace frescoSystrace = com.facebook.imagepipeline.systrace.FrescoSystrace.INSTANCE;
        if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
            com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection("ImagePipeline#prefetchToEncodedCache");
            try {
                if (!this.isPrefetchEnabledSupplier.get().booleanValue()) {
                    com.facebook.datasource.DataSource<java.lang.Void> dataSourceImmediateFailedDataSource2 = com.facebook.datasource.DataSources.immediateFailedDataSource(PREFETCH_EXCEPTION);
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(dataSourceImmediateFailedDataSource2, "immediateFailedDataSource(...)");
                    com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
                    return dataSourceImmediateFailedDataSource2;
                }
                if (imageRequest == null) {
                    com.facebook.datasource.DataSource<java.lang.Void> dataSourceImmediateFailedDataSource3 = com.facebook.datasource.DataSources.immediateFailedDataSource(NULL_IMAGEREQUEST_EXCEPTION);
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(dataSourceImmediateFailedDataSource3, "immediateFailedDataSource(...)");
                    com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
                    return dataSourceImmediateFailedDataSource3;
                }
                try {
                    if (!this.config.getExperiments().getPrefetchShortcutEnabled() || !isInEncodedMemoryCache(imageRequest)) {
                        dataSourceImmediateFailedDataSource = submitPrefetchRequest(this.producerSequenceFactory.getEncodedImagePrefetchProducerSequence(imageRequest), imageRequest, com.facebook.imagepipeline.request.ImageRequest.RequestLevel.FULL_FETCH, callerContext, priority, requestListener);
                        com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
                        return dataSourceImmediateFailedDataSource;
                    }
                    com.facebook.datasource.DataSource<java.lang.Void> dataSourceImmediateSuccessfulDataSource = com.facebook.datasource.DataSources.immediateSuccessfulDataSource();
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(dataSourceImmediateSuccessfulDataSource, "immediateSuccessfulDataSource(...)");
                    com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
                    return dataSourceImmediateSuccessfulDataSource;
                } catch (java.lang.Exception e) {
                    dataSourceImmediateFailedDataSource = com.facebook.datasource.DataSources.immediateFailedDataSource(e);
                }
            } catch (java.lang.Throwable th) {
                com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
                throw th;
            }
        } else {
            if (!this.isPrefetchEnabledSupplier.get().booleanValue()) {
                com.facebook.datasource.DataSource<java.lang.Void> dataSourceImmediateFailedDataSource4 = com.facebook.datasource.DataSources.immediateFailedDataSource(PREFETCH_EXCEPTION);
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(dataSourceImmediateFailedDataSource4, "immediateFailedDataSource(...)");
                return dataSourceImmediateFailedDataSource4;
            }
            if (imageRequest == null) {
                com.facebook.datasource.DataSource<java.lang.Void> dataSourceImmediateFailedDataSource5 = com.facebook.datasource.DataSources.immediateFailedDataSource(NULL_IMAGEREQUEST_EXCEPTION);
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(dataSourceImmediateFailedDataSource5, "immediateFailedDataSource(...)");
                return dataSourceImmediateFailedDataSource5;
            }
            try {
                if (this.config.getExperiments().getPrefetchShortcutEnabled()) {
                    try {
                        if (isInEncodedMemoryCache(imageRequest)) {
                            com.facebook.datasource.DataSource<java.lang.Void> dataSourceImmediateSuccessfulDataSource2 = com.facebook.datasource.DataSources.immediateSuccessfulDataSource();
                            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(dataSourceImmediateSuccessfulDataSource2, "immediateSuccessfulDataSource(...)");
                            return dataSourceImmediateSuccessfulDataSource2;
                        }
                    } catch (java.lang.Exception e2) {
                        exc = e2;
                        return com.facebook.datasource.DataSources.immediateFailedDataSource(exc);
                    }
                }
                try {
                    return submitPrefetchRequest(this.producerSequenceFactory.getEncodedImagePrefetchProducerSequence(imageRequest), imageRequest, com.facebook.imagepipeline.request.ImageRequest.RequestLevel.FULL_FETCH, callerContext, priority, requestListener);
                } catch (java.lang.Exception e3) {
                    e = e3;
                    exc = e;
                    return com.facebook.datasource.DataSources.immediateFailedDataSource(exc);
                }
            } catch (java.lang.Exception e4) {
                e = e4;
            }
        }
    }

    public final void evictFromMemoryCache(android.net.Uri uri) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(uri, "uri");
        com.facebook.common.internal.Predicate<com.facebook.cache.common.CacheKey> predicatePredicateForUri = predicateForUri(uri);
        this.bitmapMemoryCache.removeAll(predicatePredicateForUri);
        this.encodedMemoryCache.removeAll(predicatePredicateForUri);
    }

    public final void evictFromDiskCache(android.net.Uri uri) {
        com.facebook.imagepipeline.request.ImageRequest imageRequestFromUri = com.facebook.imagepipeline.request.ImageRequest.fromUri(uri);
        if (imageRequestFromUri == null) {
            throw new java.lang.IllegalStateException("Required value was null.".toString());
        }
        evictFromDiskCache(imageRequestFromUri);
    }

    public final void evictFromDiskCache(com.facebook.imagepipeline.request.ImageRequest imageRequest) {
        if (imageRequest == null) {
            return;
        }
        com.facebook.cache.common.CacheKey encodedCacheKey = this.cacheKeyFactory.getEncodedCacheKey(imageRequest, null);
        com.facebook.imagepipeline.core.DiskCachesStore diskCachesStore = this.diskCachesStoreSupplier.get();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(diskCachesStore, "get(...)");
        com.facebook.imagepipeline.core.DiskCachesStore diskCachesStore2 = diskCachesStore;
        com.facebook.imagepipeline.cache.BufferedDiskCache mainBufferedDiskCache = diskCachesStore2.getMainBufferedDiskCache();
        kotlin.jvm.internal.Intrinsics.checkNotNull(encodedCacheKey);
        mainBufferedDiskCache.remove(encodedCacheKey);
        diskCachesStore2.getSmallImageBufferedDiskCache().remove(encodedCacheKey);
        java.util.Iterator<java.util.Map.Entry<java.lang.String, com.facebook.imagepipeline.cache.BufferedDiskCache>> it = diskCachesStore2.getDynamicBufferedDiskCaches().entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().remove(encodedCacheKey);
        }
    }

    public final void evictFromCache(android.net.Uri uri) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(uri, "uri");
        evictFromMemoryCache(uri);
        evictFromDiskCache(uri);
    }

    public final void clearMemoryCaches() {
        com.facebook.common.internal.Predicate<com.facebook.cache.common.CacheKey> predicate = new com.facebook.common.internal.Predicate() { // from class: com.facebook.imagepipeline.core.ImagePipeline$$ExternalSyntheticLambda5
            @Override // com.facebook.common.internal.Predicate
            public final boolean apply(java.lang.Object obj) {
                return com.facebook.imagepipeline.core.ImagePipeline.clearMemoryCaches$lambda$3((com.facebook.cache.common.CacheKey) obj);
            }
        };
        this.bitmapMemoryCache.removeAll(predicate);
        this.encodedMemoryCache.removeAll(predicate);
    }

    public final void clearDiskCaches() {
        com.facebook.imagepipeline.core.DiskCachesStore diskCachesStore = this.diskCachesStoreSupplier.get();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(diskCachesStore, "get(...)");
        com.facebook.imagepipeline.core.DiskCachesStore diskCachesStore2 = diskCachesStore;
        diskCachesStore2.getMainBufferedDiskCache().clearAll();
        diskCachesStore2.getSmallImageBufferedDiskCache().clearAll();
        java.util.Iterator<java.util.Map.Entry<java.lang.String, com.facebook.imagepipeline.cache.BufferedDiskCache>> it = diskCachesStore2.getDynamicBufferedDiskCaches().entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().clearAll();
        }
    }

    public final long getUsedDiskCacheSize() {
        com.facebook.imagepipeline.core.DiskCachesStore diskCachesStore = this.diskCachesStoreSupplier.get();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(diskCachesStore, "get(...)");
        com.facebook.imagepipeline.core.DiskCachesStore diskCachesStore2 = diskCachesStore;
        long size = diskCachesStore2.getMainBufferedDiskCache().getSize() + diskCachesStore2.getSmallImageBufferedDiskCache().getSize();
        java.util.Collection<com.facebook.imagepipeline.cache.BufferedDiskCache> collectionValues = diskCachesStore2.getDynamicBufferedDiskCaches().values();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(collectionValues, "<get-values>(...)");
        java.util.Iterator<T> it = collectionValues.iterator();
        long size2 = 0;
        while (it.hasNext()) {
            size2 += ((com.facebook.imagepipeline.cache.BufferedDiskCache) it.next()).getSize();
        }
        return size + size2;
    }

    public final void clearCaches() {
        clearMemoryCaches();
        clearDiskCaches();
    }

    public final boolean isInBitmapMemoryCache(android.net.Uri uri) {
        if (uri == null) {
            return false;
        }
        return this.bitmapMemoryCache.contains(predicateForUri(uri));
    }

    public final boolean isInBitmapMemoryCache(com.facebook.imagepipeline.request.ImageRequest imageRequest) {
        if (imageRequest == null) {
            return false;
        }
        com.facebook.cache.common.CacheKey bitmapCacheKey = this.cacheKeyFactory.getBitmapCacheKey(imageRequest, null);
        com.facebook.imagepipeline.cache.MemoryCache<com.facebook.cache.common.CacheKey, com.facebook.imagepipeline.image.CloseableImage> memoryCache = this.bitmapMemoryCache;
        kotlin.jvm.internal.Intrinsics.checkNotNull(bitmapCacheKey);
        com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage> closeableReference = memoryCache.get(bitmapCacheKey);
        try {
            return com.facebook.common.references.CloseableReference.isValid(closeableReference);
        } finally {
            com.facebook.common.references.CloseableReference.closeSafely(closeableReference);
        }
    }

    public final boolean isInEncodedMemoryCache(android.net.Uri uri) {
        if (uri == null) {
            return false;
        }
        return this.encodedMemoryCache.contains(predicateForUri(uri));
    }

    public final boolean isInEncodedMemoryCache(com.facebook.imagepipeline.request.ImageRequest imageRequest) {
        if (imageRequest == null) {
            return false;
        }
        com.facebook.cache.common.CacheKey encodedCacheKey = this.cacheKeyFactory.getEncodedCacheKey(imageRequest, null);
        com.facebook.imagepipeline.cache.MemoryCache<com.facebook.cache.common.CacheKey, com.facebook.common.memory.PooledByteBuffer> memoryCache = this.encodedMemoryCache;
        kotlin.jvm.internal.Intrinsics.checkNotNull(encodedCacheKey);
        com.facebook.common.references.CloseableReference<com.facebook.common.memory.PooledByteBuffer> closeableReference = memoryCache.get(encodedCacheKey);
        try {
            return com.facebook.common.references.CloseableReference.isValid(closeableReference);
        } finally {
            com.facebook.common.references.CloseableReference.closeSafely(closeableReference);
        }
    }

    public final boolean isInDiskCacheSync(android.net.Uri uri) {
        return isInDiskCacheSync(uri, com.facebook.imagepipeline.request.ImageRequest.CacheChoice.SMALL) || isInDiskCacheSync(uri, com.facebook.imagepipeline.request.ImageRequest.CacheChoice.DEFAULT) || isInDiskCacheSync(uri, com.facebook.imagepipeline.request.ImageRequest.CacheChoice.DYNAMIC);
    }

    public final boolean isInDiskCacheSync(android.net.Uri uri, com.facebook.imagepipeline.request.ImageRequest.CacheChoice cacheChoice) {
        com.facebook.imagepipeline.request.ImageRequest imageRequestBuild = com.facebook.imagepipeline.request.ImageRequestBuilder.newBuilderWithSource(uri).setCacheChoice(cacheChoice).build();
        kotlin.jvm.internal.Intrinsics.checkNotNull(imageRequestBuild);
        return isInDiskCacheSync(imageRequestBuild);
    }

    private final boolean isInDynamicDiskCachesSync(com.facebook.imagepipeline.request.ImageRequest imageRequest) {
        com.facebook.imagepipeline.core.DiskCachesStore diskCachesStore = this.diskCachesStoreSupplier.get();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(diskCachesStore, "get(...)");
        com.facebook.imagepipeline.core.DiskCachesStore diskCachesStore2 = diskCachesStore;
        com.facebook.cache.common.CacheKey encodedCacheKey = this.cacheKeyFactory.getEncodedCacheKey(imageRequest, null);
        java.lang.String diskCacheId = imageRequest.getDiskCacheId();
        if (diskCacheId != null) {
            com.facebook.imagepipeline.cache.BufferedDiskCache bufferedDiskCache = diskCachesStore2.getDynamicBufferedDiskCaches().get(diskCacheId);
            if (bufferedDiskCache == null) {
                return false;
            }
            kotlin.jvm.internal.Intrinsics.checkNotNull(encodedCacheKey);
            return bufferedDiskCache.diskCheckSync(encodedCacheKey);
        }
        java.util.Iterator<java.util.Map.Entry<java.lang.String, com.facebook.imagepipeline.cache.BufferedDiskCache>> it = diskCachesStore2.getDynamicBufferedDiskCaches().entrySet().iterator();
        while (it.hasNext()) {
            com.facebook.imagepipeline.cache.BufferedDiskCache value = it.next().getValue();
            kotlin.jvm.internal.Intrinsics.checkNotNull(encodedCacheKey);
            if (value.diskCheckSync(encodedCacheKey)) {
                return true;
            }
        }
        return false;
    }

    public final boolean isInDiskCacheSync(com.facebook.imagepipeline.request.ImageRequest imageRequest) {
        boolean zDiskCheckSync;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        com.facebook.imagepipeline.core.DiskCachesStore diskCachesStore = this.diskCachesStoreSupplier.get();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(diskCachesStore, "get(...)");
        com.facebook.imagepipeline.core.DiskCachesStore diskCachesStore2 = diskCachesStore;
        com.facebook.cache.common.CacheKey encodedCacheKey = this.cacheKeyFactory.getEncodedCacheKey(imageRequest, null);
        com.facebook.imagepipeline.request.ImageRequest.CacheChoice cacheChoice = imageRequest.getCacheChoice();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(cacheChoice, "getCacheChoice(...)");
        android.os.StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = android.os.StrictMode.allowThreadDiskReads();
        try {
            int i = com.facebook.imagepipeline.core.ImagePipeline.WhenMappings.$EnumSwitchMapping$0[cacheChoice.ordinal()];
            if (i == 1) {
                com.facebook.imagepipeline.cache.BufferedDiskCache mainBufferedDiskCache = diskCachesStore2.getMainBufferedDiskCache();
                kotlin.jvm.internal.Intrinsics.checkNotNull(encodedCacheKey);
                zDiskCheckSync = mainBufferedDiskCache.diskCheckSync(encodedCacheKey);
            } else if (i == 2) {
                com.facebook.imagepipeline.cache.BufferedDiskCache smallImageBufferedDiskCache = diskCachesStore2.getSmallImageBufferedDiskCache();
                kotlin.jvm.internal.Intrinsics.checkNotNull(encodedCacheKey);
                zDiskCheckSync = smallImageBufferedDiskCache.diskCheckSync(encodedCacheKey);
            } else {
                if (i != 3) {
                    throw new kotlin.NoWhenBranchMatchedException();
                }
                zDiskCheckSync = isInDynamicDiskCachesSync(imageRequest);
            }
            android.os.StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
            return zDiskCheckSync;
        } catch (java.lang.Throwable th) {
            android.os.StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
            throw th;
        }
    }

    public final com.facebook.datasource.DataSource<java.lang.Boolean> isInDiskCache(android.net.Uri uri) {
        com.facebook.imagepipeline.request.ImageRequest imageRequestFromUri = com.facebook.imagepipeline.request.ImageRequest.fromUri(uri);
        if (imageRequestFromUri != null) {
            return isInDiskCache(imageRequestFromUri);
        }
        throw new java.lang.IllegalStateException("Required value was null.".toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [T, bolts.Task, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v5, types: [bolts.Task, bolts.Task<java.lang.Boolean>] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r2v6, types: [T, bolts.Task] */
    private final bolts.Task<java.lang.Boolean> isInDynamicDiskCaches(com.facebook.imagepipeline.request.ImageRequest imageRequest, com.facebook.cache.common.CacheKey cacheKey, final bolts.Continuation<java.lang.Boolean, java.lang.Void> intermediateContinuation, final bolts.CancellationTokenSource cts) {
        bolts.Task<java.lang.Boolean> taskContains;
        com.facebook.imagepipeline.core.DiskCachesStore diskCachesStore = this.diskCachesStoreSupplier.get();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(diskCachesStore, "get(...)");
        com.facebook.imagepipeline.core.DiskCachesStore diskCachesStore2 = diskCachesStore;
        java.lang.String diskCacheId = imageRequest != null ? imageRequest.getDiskCacheId() : null;
        if (diskCacheId != null) {
            com.facebook.imagepipeline.cache.BufferedDiskCache bufferedDiskCache = diskCachesStore2.getDynamicBufferedDiskCaches().get(diskCacheId);
            if (bufferedDiskCache != null && (taskContains = bufferedDiskCache.contains(cacheKey)) != null) {
                return taskContains;
            }
            bolts.Task<java.lang.Boolean> taskForResult = bolts.Task.forResult(false);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(taskForResult, "forResult(...)");
            return taskForResult;
        }
        if (diskCachesStore2.getDynamicBufferedDiskCaches().size() == 0) {
            bolts.Task<java.lang.Boolean> taskForResult2 = bolts.Task.forResult(false);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(taskForResult2, "forResult(...)");
            return taskForResult2;
        }
        java.util.Iterator<java.util.Map.Entry<java.lang.String, com.facebook.imagepipeline.cache.BufferedDiskCache>> it = diskCachesStore2.getDynamicBufferedDiskCaches().entrySet().iterator();
        ?? ForResult = bolts.Task.forResult(false);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(ForResult, "forResult(...)");
        final kotlin.jvm.internal.Ref.ObjectRef objectRef = new kotlin.jvm.internal.Ref.ObjectRef();
        objectRef.element = ForResult;
        ?? r0 = ForResult;
        while (it.hasNext()) {
            objectRef.element = it.next().getValue().contains(cacheKey);
            r0.continueWithTask(new bolts.Continuation() { // from class: com.facebook.imagepipeline.core.ImagePipeline.isInDynamicDiskCaches.1
                @Override // bolts.Continuation
                public /* bridge */ /* synthetic */ java.lang.Object then(bolts.Task task) {
                    return then((bolts.Task<java.lang.Boolean>) task);
                }

                @Override // bolts.Continuation
                public final bolts.Task<? extends java.lang.Object> then(bolts.Task<java.lang.Boolean> task) {
                    if (!task.isCancelled() && !task.isFaulted() && task.getResult().booleanValue()) {
                        cts.cancel();
                        return bolts.Task.forResult(true).continueWith(intermediateContinuation);
                    }
                    if (task.isCancelled()) {
                        return bolts.Task.forResult(false);
                    }
                    return objectRef.element;
                }
            }, cts.getToken());
            r0 = (bolts.Task) objectRef.element;
        }
        return r0;
    }

    public final com.facebook.datasource.DataSource<java.lang.Boolean> isInDiskCache(final com.facebook.imagepipeline.request.ImageRequest imageRequest) {
        com.facebook.imagepipeline.core.DiskCachesStore diskCachesStore = this.diskCachesStoreSupplier.get();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(diskCachesStore, "get(...)");
        final com.facebook.imagepipeline.core.DiskCachesStore diskCachesStore2 = diskCachesStore;
        final com.facebook.cache.common.CacheKey encodedCacheKey = this.cacheKeyFactory.getEncodedCacheKey(imageRequest, null);
        final com.facebook.datasource.SimpleDataSource simpleDataSourceCreate = com.facebook.datasource.SimpleDataSource.create();
        final bolts.CancellationTokenSource cancellationTokenSource = new bolts.CancellationTokenSource();
        bolts.Continuation continuation = new bolts.Continuation() { // from class: com.facebook.imagepipeline.core.ImagePipeline$$ExternalSyntheticLambda0
            @Override // bolts.Continuation
            public final java.lang.Object then(bolts.Task task) {
                return com.facebook.imagepipeline.core.ImagePipeline.isInDiskCache$lambda$7(simpleDataSourceCreate, task);
            }
        };
        final bolts.Continuation continuation2 = new bolts.Continuation() { // from class: com.facebook.imagepipeline.core.ImagePipeline$$ExternalSyntheticLambda1
            @Override // bolts.Continuation
            public final java.lang.Object then(bolts.Task task) {
                return com.facebook.imagepipeline.core.ImagePipeline.isInDiskCache$lambda$8(simpleDataSourceCreate, task);
            }
        };
        com.facebook.imagepipeline.cache.BufferedDiskCache mainBufferedDiskCache = diskCachesStore2.getMainBufferedDiskCache();
        kotlin.jvm.internal.Intrinsics.checkNotNull(encodedCacheKey);
        mainBufferedDiskCache.contains(encodedCacheKey).continueWithTask(new bolts.Continuation() { // from class: com.facebook.imagepipeline.core.ImagePipeline$$ExternalSyntheticLambda2
            @Override // bolts.Continuation
            public final java.lang.Object then(bolts.Task task) {
                return com.facebook.imagepipeline.core.ImagePipeline.isInDiskCache$lambda$9(diskCachesStore2, encodedCacheKey, task);
            }
        }).continueWithTask((bolts.Continuation<TContinuationResult, bolts.Task<TContinuationResult>>) new bolts.Continuation() { // from class: com.facebook.imagepipeline.core.ImagePipeline$$ExternalSyntheticLambda3
            @Override // bolts.Continuation
            public final java.lang.Object then(bolts.Task task) {
                return com.facebook.imagepipeline.core.ImagePipeline.isInDiskCache$lambda$10(this.f$0, imageRequest, encodedCacheKey, continuation2, cancellationTokenSource, task);
            }
        }, cancellationTokenSource.getToken()).continueWith(continuation);
        kotlin.jvm.internal.Intrinsics.checkNotNull(simpleDataSourceCreate);
        return simpleDataSourceCreate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final java.lang.Void isInDiskCache$lambda$7(com.facebook.datasource.SimpleDataSource simpleDataSource, bolts.Task task) {
        java.lang.Boolean bool = (java.lang.Boolean) simpleDataSource.getResult();
        boolean z = false;
        if ((bool != null ? bool.booleanValue() : false) || (!task.isCancelled() && !task.isFaulted() && ((java.lang.Boolean) task.getResult()).booleanValue())) {
            z = true;
        }
        simpleDataSource.setResult(java.lang.Boolean.valueOf(z));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final java.lang.Void isInDiskCache$lambda$8(com.facebook.datasource.SimpleDataSource simpleDataSource, bolts.Task task) {
        java.lang.Boolean bool = (java.lang.Boolean) simpleDataSource.getResult();
        simpleDataSource.setResult(java.lang.Boolean.valueOf((bool != null ? bool.booleanValue() : false) || !(task.isCancelled() || task.isFaulted() || !((java.lang.Boolean) task.getResult()).booleanValue())), false);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final bolts.Task isInDiskCache$lambda$9(com.facebook.imagepipeline.core.DiskCachesStore diskCachesStore, com.facebook.cache.common.CacheKey cacheKey, bolts.Task task) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(diskCachesStore, "$diskCachesStore");
        if (!task.isCancelled() && !task.isFaulted() && ((java.lang.Boolean) task.getResult()).booleanValue()) {
            return bolts.Task.forResult(true);
        }
        com.facebook.imagepipeline.cache.BufferedDiskCache smallImageBufferedDiskCache = diskCachesStore.getSmallImageBufferedDiskCache();
        kotlin.jvm.internal.Intrinsics.checkNotNull(cacheKey);
        return smallImageBufferedDiskCache.contains(cacheKey);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final bolts.Task isInDiskCache$lambda$10(com.facebook.imagepipeline.core.ImagePipeline this$0, com.facebook.imagepipeline.request.ImageRequest imageRequest, com.facebook.cache.common.CacheKey cacheKey, bolts.Continuation intermediateContinuation, bolts.CancellationTokenSource cts, bolts.Task task) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(intermediateContinuation, "$intermediateContinuation");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(cts, "$cts");
        if (!task.isCancelled() && !task.isFaulted() && ((java.lang.Boolean) task.getResult()).booleanValue()) {
            return bolts.Task.forResult(true);
        }
        kotlin.jvm.internal.Intrinsics.checkNotNull(cacheKey);
        return this$0.isInDynamicDiskCaches(imageRequest, cacheKey, intermediateContinuation, cts);
    }

    public final com.facebook.cache.common.CacheKey getCacheKey(com.facebook.imagepipeline.request.ImageRequest imageRequest, java.lang.Object callerContext) {
        com.facebook.cache.common.CacheKey bitmapCacheKey;
        com.facebook.imagepipeline.systrace.FrescoSystrace frescoSystrace = com.facebook.imagepipeline.systrace.FrescoSystrace.INSTANCE;
        com.facebook.cache.common.CacheKey cacheKey = null;
        if (!com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
            if (imageRequest == null) {
                return null;
            }
            if (imageRequest.getPostprocessor() != null) {
                return this.cacheKeyFactory.getPostprocessedBitmapCacheKey(imageRequest, callerContext);
            }
            return this.cacheKeyFactory.getBitmapCacheKey(imageRequest, callerContext);
        }
        com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection("ImagePipeline#getCacheKey");
        if (imageRequest != null) {
            try {
                if (imageRequest.getPostprocessor() != null) {
                    bitmapCacheKey = this.cacheKeyFactory.getPostprocessedBitmapCacheKey(imageRequest, callerContext);
                } else {
                    bitmapCacheKey = this.cacheKeyFactory.getBitmapCacheKey(imageRequest, callerContext);
                }
                cacheKey = bitmapCacheKey;
            } finally {
                com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
            }
        }
        return cacheKey;
    }

    public final com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage> getCachedImage(com.facebook.cache.common.CacheKey cacheKey) {
        if (cacheKey == null) {
            return null;
        }
        com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage> closeableReference = this.bitmapMemoryCache.get(cacheKey);
        if (closeableReference == null || closeableReference.get().getQualityInfo().isOfFullQuality()) {
            return closeableReference;
        }
        closeableReference.close();
        return null;
    }

    public final boolean hasCachedImage(com.facebook.cache.common.CacheKey cacheKey) {
        if (cacheKey == null) {
            return false;
        }
        return this.bitmapMemoryCache.contains(cacheKey);
    }

    private final <T> com.facebook.datasource.DataSource<com.facebook.common.references.CloseableReference<T>> submitFetchRequest(com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<T>> producerSequence, com.facebook.imagepipeline.request.ImageRequest imageRequest, com.facebook.imagepipeline.request.ImageRequest.RequestLevel lowestPermittedRequestLevelOnSubmit, java.lang.Object callerContext, com.facebook.imagepipeline.listener.RequestListener requestListener, java.lang.String uiComponentId) {
        return submitFetchRequest(producerSequence, imageRequest, lowestPermittedRequestLevelOnSubmit, callerContext, requestListener, uiComponentId, null);
    }

    private final <T> com.facebook.datasource.DataSource<com.facebook.common.references.CloseableReference<T>> submitFetchRequest(com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<T>> producerSequence, com.facebook.imagepipeline.request.ImageRequest imageRequest, com.facebook.imagepipeline.request.ImageRequest.RequestLevel lowestPermittedRequestLevelOnSubmit, java.lang.Object callerContext, com.facebook.imagepipeline.listener.RequestListener requestListener, java.lang.String uiComponentId, java.util.Map<java.lang.String, ?> extras) {
        com.facebook.datasource.DataSource<com.facebook.common.references.CloseableReference<T>> dataSourceImmediateFailedDataSource;
        com.facebook.imagepipeline.systrace.FrescoSystrace frescoSystrace = com.facebook.imagepipeline.systrace.FrescoSystrace.INSTANCE;
        if (!com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
            com.facebook.imagepipeline.producers.InternalRequestListener internalRequestListener = new com.facebook.imagepipeline.producers.InternalRequestListener(getRequestListenerForRequest(imageRequest, requestListener), this.requestListener2);
            com.facebook.callercontext.CallerContextVerifier callerContextVerifier = this.callerContextVerifier;
            if (callerContextVerifier != null) {
                callerContextVerifier.verifyCallerContext(callerContext, false);
            }
            try {
                com.facebook.imagepipeline.request.ImageRequest.RequestLevel max = com.facebook.imagepipeline.request.ImageRequest.RequestLevel.getMax(imageRequest.getLowestPermittedRequestLevel(), lowestPermittedRequestLevelOnSubmit);
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(max, "getMax(...)");
                com.facebook.imagepipeline.producers.SettableProducerContext settableProducerContext = new com.facebook.imagepipeline.producers.SettableProducerContext(imageRequest, generateUniqueFutureId(), uiComponentId, internalRequestListener, callerContext, max, false, imageRequest.getProgressiveRenderingEnabled() || !com.facebook.common.util.UriUtil.isNetworkUri(imageRequest.getSourceUri()), imageRequest.getPriority(), this.config);
                settableProducerContext.putExtras(extras);
                return com.facebook.imagepipeline.datasource.CloseableProducerToDataSourceAdapter.create(producerSequence, settableProducerContext, internalRequestListener);
            } catch (java.lang.Exception e) {
                return com.facebook.datasource.DataSources.immediateFailedDataSource(e);
            }
        }
        com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection("ImagePipeline#submitFetchRequest");
        try {
            com.facebook.imagepipeline.producers.InternalRequestListener internalRequestListener2 = new com.facebook.imagepipeline.producers.InternalRequestListener(getRequestListenerForRequest(imageRequest, requestListener), this.requestListener2);
            com.facebook.callercontext.CallerContextVerifier callerContextVerifier2 = this.callerContextVerifier;
            if (callerContextVerifier2 != null) {
                callerContextVerifier2.verifyCallerContext(callerContext, false);
            }
            try {
                com.facebook.imagepipeline.request.ImageRequest.RequestLevel max2 = com.facebook.imagepipeline.request.ImageRequest.RequestLevel.getMax(imageRequest.getLowestPermittedRequestLevel(), lowestPermittedRequestLevelOnSubmit);
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(max2, "getMax(...)");
                com.facebook.imagepipeline.producers.SettableProducerContext settableProducerContext2 = new com.facebook.imagepipeline.producers.SettableProducerContext(imageRequest, generateUniqueFutureId(), uiComponentId, internalRequestListener2, callerContext, max2, false, imageRequest.getProgressiveRenderingEnabled() || !com.facebook.common.util.UriUtil.isNetworkUri(imageRequest.getSourceUri()), imageRequest.getPriority(), this.config);
                settableProducerContext2.putExtras(extras);
                dataSourceImmediateFailedDataSource = com.facebook.imagepipeline.datasource.CloseableProducerToDataSourceAdapter.create(producerSequence, settableProducerContext2, internalRequestListener2);
            } catch (java.lang.Exception e2) {
                dataSourceImmediateFailedDataSource = com.facebook.datasource.DataSources.immediateFailedDataSource(e2);
            }
            return dataSourceImmediateFailedDataSource;
        } finally {
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
        }
    }

    private final <T> com.facebook.datasource.DataSource<com.facebook.common.references.CloseableReference<T>> submitFetchRequest(com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<T>> producerSequence, com.facebook.imagepipeline.request.ImageRequest imageRequest, com.facebook.imagepipeline.request.ImageRequest.RequestLevel lowestPermittedRequestLevelOnSubmit, java.lang.Object callerContext, com.facebook.imagepipeline.listener.RequestListener requestListener, java.util.Map<java.lang.String, ?> extras) {
        com.facebook.datasource.DataSource<com.facebook.common.references.CloseableReference<T>> dataSourceImmediateFailedDataSource;
        com.facebook.imagepipeline.systrace.FrescoSystrace frescoSystrace = com.facebook.imagepipeline.systrace.FrescoSystrace.INSTANCE;
        if (!com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
            com.facebook.imagepipeline.producers.InternalRequestListener internalRequestListener = new com.facebook.imagepipeline.producers.InternalRequestListener(getRequestListenerForRequest(imageRequest, requestListener), this.requestListener2);
            com.facebook.callercontext.CallerContextVerifier callerContextVerifier = this.callerContextVerifier;
            if (callerContextVerifier != null) {
                callerContextVerifier.verifyCallerContext(callerContext, false);
            }
            try {
                com.facebook.imagepipeline.request.ImageRequest.RequestLevel max = com.facebook.imagepipeline.request.ImageRequest.RequestLevel.getMax(imageRequest.getLowestPermittedRequestLevel(), lowestPermittedRequestLevelOnSubmit);
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(max, "getMax(...)");
                return com.facebook.imagepipeline.datasource.CloseableProducerToDataSourceAdapter.create(producerSequence, new com.facebook.imagepipeline.producers.SettableProducerContext(imageRequest, generateUniqueFutureId(), null, internalRequestListener, callerContext, max, false, imageRequest.getProgressiveRenderingEnabled() || !com.facebook.common.util.UriUtil.isNetworkUri(imageRequest.getSourceUri()), imageRequest.getPriority(), this.config), internalRequestListener);
            } catch (java.lang.Exception e) {
                return com.facebook.datasource.DataSources.immediateFailedDataSource(e);
            }
        }
        com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection("ImagePipeline#submitFetchRequest");
        try {
            com.facebook.imagepipeline.producers.InternalRequestListener internalRequestListener2 = new com.facebook.imagepipeline.producers.InternalRequestListener(getRequestListenerForRequest(imageRequest, requestListener), this.requestListener2);
            com.facebook.callercontext.CallerContextVerifier callerContextVerifier2 = this.callerContextVerifier;
            if (callerContextVerifier2 != null) {
                callerContextVerifier2.verifyCallerContext(callerContext, false);
            }
            try {
                com.facebook.imagepipeline.request.ImageRequest.RequestLevel max2 = com.facebook.imagepipeline.request.ImageRequest.RequestLevel.getMax(imageRequest.getLowestPermittedRequestLevel(), lowestPermittedRequestLevelOnSubmit);
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(max2, "getMax(...)");
                dataSourceImmediateFailedDataSource = com.facebook.imagepipeline.datasource.CloseableProducerToDataSourceAdapter.create(producerSequence, new com.facebook.imagepipeline.producers.SettableProducerContext(imageRequest, generateUniqueFutureId(), null, internalRequestListener2, callerContext, max2, false, imageRequest.getProgressiveRenderingEnabled() || !com.facebook.common.util.UriUtil.isNetworkUri(imageRequest.getSourceUri()), imageRequest.getPriority(), this.config), internalRequestListener2);
            } catch (java.lang.Exception e2) {
                dataSourceImmediateFailedDataSource = com.facebook.datasource.DataSources.immediateFailedDataSource(e2);
            }
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
            return dataSourceImmediateFailedDataSource;
        } catch (java.lang.Throwable th) {
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
            throw th;
        }
    }

    public final <T> com.facebook.datasource.DataSource<com.facebook.common.references.CloseableReference<T>> submitFetchRequest(com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<T>> producerSequence, com.facebook.imagepipeline.producers.SettableProducerContext settableProducerContext, com.facebook.imagepipeline.listener.RequestListener requestListener) {
        com.facebook.datasource.DataSource<com.facebook.common.references.CloseableReference<T>> dataSourceImmediateFailedDataSource;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(producerSequence, "producerSequence");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(settableProducerContext, "settableProducerContext");
        com.facebook.imagepipeline.systrace.FrescoSystrace frescoSystrace = com.facebook.imagepipeline.systrace.FrescoSystrace.INSTANCE;
        if (!com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
            try {
                return com.facebook.imagepipeline.datasource.CloseableProducerToDataSourceAdapter.create(producerSequence, settableProducerContext, new com.facebook.imagepipeline.producers.InternalRequestListener(requestListener, this.requestListener2));
            } catch (java.lang.Exception e) {
                return com.facebook.datasource.DataSources.immediateFailedDataSource(e);
            }
        }
        com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection("ImagePipeline#submitFetchRequest");
        try {
            try {
                dataSourceImmediateFailedDataSource = com.facebook.imagepipeline.datasource.CloseableProducerToDataSourceAdapter.create(producerSequence, settableProducerContext, new com.facebook.imagepipeline.producers.InternalRequestListener(requestListener, this.requestListener2));
            } catch (java.lang.Exception e2) {
                dataSourceImmediateFailedDataSource = com.facebook.datasource.DataSources.immediateFailedDataSource(e2);
            }
            return dataSourceImmediateFailedDataSource;
        } finally {
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
        }
    }

    private final com.facebook.datasource.DataSource<java.lang.Void> submitPrefetchRequest(com.facebook.imagepipeline.producers.Producer<java.lang.Void> producerSequence, com.facebook.imagepipeline.request.ImageRequest imageRequest, com.facebook.imagepipeline.request.ImageRequest.RequestLevel lowestPermittedRequestLevelOnSubmit, java.lang.Object callerContext, com.facebook.imagepipeline.common.Priority priority, com.facebook.imagepipeline.listener.RequestListener requestListener) {
        com.facebook.imagepipeline.producers.InternalRequestListener internalRequestListener = new com.facebook.imagepipeline.producers.InternalRequestListener(getRequestListenerForRequest(imageRequest, requestListener), this.requestListener2);
        com.facebook.callercontext.CallerContextVerifier callerContextVerifier = this.callerContextVerifier;
        if (callerContextVerifier != null) {
            callerContextVerifier.verifyCallerContext(callerContext, true);
        }
        android.net.Uri sourceUri = imageRequest.getSourceUri();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(sourceUri, "getSourceUri(...)");
        android.net.Uri uriModifyPrefetchUri = com.facebook.fresco.urimod.UriModifier.INSTANCE.modifyPrefetchUri(sourceUri, callerContext);
        if (uriModifyPrefetchUri == null) {
            com.facebook.datasource.DataSource<java.lang.Void> dataSourceImmediateFailedDataSource = com.facebook.datasource.DataSources.immediateFailedDataSource(MODIFIED_URL_IS_NULL);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(dataSourceImmediateFailedDataSource, "immediateFailedDataSource(...)");
            return dataSourceImmediateFailedDataSource;
        }
        com.facebook.imagepipeline.request.ImageRequest imageRequestBuild = kotlin.jvm.internal.Intrinsics.areEqual(sourceUri, uriModifyPrefetchUri) ? imageRequest : com.facebook.imagepipeline.request.ImageRequestBuilder.fromRequest(imageRequest).setSource(uriModifyPrefetchUri).build();
        try {
            com.facebook.imagepipeline.request.ImageRequest.RequestLevel max = com.facebook.imagepipeline.request.ImageRequest.RequestLevel.getMax(imageRequestBuild.getLowestPermittedRequestLevel(), lowestPermittedRequestLevelOnSubmit);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(max, "getMax(...)");
            java.lang.String strGenerateUniqueFutureId = generateUniqueFutureId();
            com.facebook.imagepipeline.producers.InternalRequestListener internalRequestListener2 = internalRequestListener;
            com.facebook.imagepipeline.core.ImagePipelineExperiments experiments = this.config.getExperiments();
            return com.facebook.imagepipeline.datasource.ProducerToDataSourceAdapter.INSTANCE.create(producerSequence, new com.facebook.imagepipeline.producers.SettableProducerContext(imageRequestBuild, strGenerateUniqueFutureId, internalRequestListener2, callerContext, max, true, experiments != null && experiments.getAllowProgressiveOnPrefetch() && imageRequestBuild.getProgressiveRenderingEnabled(), priority, this.config), internalRequestListener);
        } catch (java.lang.Exception e) {
            return com.facebook.datasource.DataSources.immediateFailedDataSource(e);
        }
    }

    public final com.facebook.imagepipeline.listener.RequestListener getRequestListenerForRequest(com.facebook.imagepipeline.request.ImageRequest imageRequest, com.facebook.imagepipeline.listener.RequestListener requestListener) {
        com.facebook.imagepipeline.listener.ForwardingRequestListener forwardingRequestListener;
        if (imageRequest == null) {
            throw new java.lang.IllegalStateException("Required value was null.".toString());
        }
        if (requestListener == null) {
            if (imageRequest.getRequestListener() == null) {
                return this.requestListener;
            }
            return new com.facebook.imagepipeline.listener.ForwardingRequestListener(this.requestListener, imageRequest.getRequestListener());
        }
        if (imageRequest.getRequestListener() == null) {
            forwardingRequestListener = new com.facebook.imagepipeline.listener.ForwardingRequestListener(this.requestListener, requestListener);
        } else {
            forwardingRequestListener = new com.facebook.imagepipeline.listener.ForwardingRequestListener(this.requestListener, requestListener, imageRequest.getRequestListener());
        }
        return forwardingRequestListener;
    }

    public final com.facebook.imagepipeline.listener.RequestListener getCombinedRequestListener(com.facebook.imagepipeline.listener.RequestListener listener) {
        return listener != null ? new com.facebook.imagepipeline.listener.ForwardingRequestListener(this.requestListener, listener) : this.requestListener;
    }

    private final com.facebook.common.internal.Predicate<com.facebook.cache.common.CacheKey> predicateForUri(final android.net.Uri uri) {
        return new com.facebook.common.internal.Predicate() { // from class: com.facebook.imagepipeline.core.ImagePipeline$$ExternalSyntheticLambda4
            @Override // com.facebook.common.internal.Predicate
            public final boolean apply(java.lang.Object obj) {
                return com.facebook.imagepipeline.core.ImagePipeline.predicateForUri$lambda$16(uri, (com.facebook.cache.common.CacheKey) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean predicateForUri$lambda$16(android.net.Uri uri, com.facebook.cache.common.CacheKey key) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(uri, "$uri");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(key, "key");
        return key.containsUri(uri);
    }

    public final void pause() {
        this.threadHandoffProducerQueue.startQueueing();
    }

    public final void resume() {
        this.threadHandoffProducerQueue.stopQueuing();
    }

    public final boolean isPaused() {
        return this.threadHandoffProducerQueue.isQueueing();
    }
}
