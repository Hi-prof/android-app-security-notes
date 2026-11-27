package io.dcloud.uts.android;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class ClassLogWrapper$$ExternalSyntheticBackportWithForwarding0 {
    public static /* synthetic */ java.math.BigDecimal m(java.math.BigDecimal bigDecimal) {
        return bigDecimal.signum() == 0 ? new java.math.BigDecimal(java.math.BigInteger.ZERO, 0) : bigDecimal.stripTrailingZeros();
    }
}
