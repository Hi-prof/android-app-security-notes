package kotlin.concurrent.internal;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class AtomicIntrinsicsKt$$ExternalSyntheticBackportWithForwarding0 {
    public static /* synthetic */ boolean m(java.util.concurrent.atomic.AtomicReferenceArray atomicReferenceArray, int i, java.lang.Object obj, java.lang.Object obj2) {
        while (!atomicReferenceArray.compareAndSet(i, obj, obj2)) {
            if (atomicReferenceArray.get(i) != obj) {
                return false;
            }
        }
        return true;
    }
}
