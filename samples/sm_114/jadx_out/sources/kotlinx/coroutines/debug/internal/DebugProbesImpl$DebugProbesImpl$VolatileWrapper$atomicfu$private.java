package kotlinx.coroutines.debug.internal;

/* JADX INFO: Access modifiers changed from: private */
/* JADX INFO: compiled from: DebugProbesImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
public /* synthetic */ class DebugProbesImpl$DebugProbesImpl$VolatileWrapper$atomicfu$private {
    private static final /* synthetic */ java.util.concurrent.atomic.AtomicIntegerFieldUpdater installations$volatile$FU = java.util.concurrent.atomic.AtomicIntegerFieldUpdater.newUpdater(kotlinx.coroutines.debug.internal.DebugProbesImpl$DebugProbesImpl$VolatileWrapper$atomicfu$private.class, "installations$volatile");
    private static final /* synthetic */ java.util.concurrent.atomic.AtomicLongFieldUpdater sequenceNumber$volatile$FU = java.util.concurrent.atomic.AtomicLongFieldUpdater.newUpdater(kotlinx.coroutines.debug.internal.DebugProbesImpl$DebugProbesImpl$VolatileWrapper$atomicfu$private.class, "sequenceNumber$volatile");
    private volatile /* synthetic */ int installations$volatile;
    private volatile /* synthetic */ long sequenceNumber$volatile;

    private DebugProbesImpl$DebugProbesImpl$VolatileWrapper$atomicfu$private() {
    }

    public /* synthetic */ DebugProbesImpl$DebugProbesImpl$VolatileWrapper$atomicfu$private(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private final /* synthetic */ int getInstallations$volatile() {
        return this.installations$volatile;
    }

    private final /* synthetic */ long getSequenceNumber$volatile() {
        return this.sequenceNumber$volatile;
    }

    private final /* synthetic */ void setInstallations$volatile(int i) {
        this.installations$volatile = i;
    }

    private final /* synthetic */ void setSequenceNumber$volatile(long j) {
        this.sequenceNumber$volatile = j;
    }
}
