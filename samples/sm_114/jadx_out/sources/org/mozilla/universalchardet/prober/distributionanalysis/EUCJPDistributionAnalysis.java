package org.mozilla.universalchardet.prober.distributionanalysis;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class EUCJPDistributionAnalysis extends org.mozilla.universalchardet.prober.distributionanalysis.JISDistributionAnalysis {
    public static final int HIGHBYTE_BEGIN = 161;
    public static final int HIGHBYTE_END = 254;
    public static final int LOWBYTE_BEGIN = 161;
    public static final int LOWBYTE_END = 254;

    @Override // org.mozilla.universalchardet.prober.distributionanalysis.CharDistributionAnalysis
    protected int getOrder(byte[] bArr, int i) {
        int i2 = bArr[i] & 255;
        if (i2 < 161) {
            return -1;
        }
        return (((i2 - 161) * 94) + (bArr[i + 1] & 255)) - 161;
    }
}
