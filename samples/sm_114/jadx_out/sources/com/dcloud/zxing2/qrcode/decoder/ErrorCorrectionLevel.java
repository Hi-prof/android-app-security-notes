package com.dcloud.zxing2.qrcode.decoder;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v0 com.dcloud.zxing2.qrcode.decoder.ErrorCorrectionLevel, still in use, count: 1, list:
  (r0v0 com.dcloud.zxing2.qrcode.decoder.ErrorCorrectionLevel) from 0x002f: FILLED_NEW_ARRAY 
  (r1v1 com.dcloud.zxing2.qrcode.decoder.ErrorCorrectionLevel)
  (r0v0 com.dcloud.zxing2.qrcode.decoder.ErrorCorrectionLevel)
  (r5v1 com.dcloud.zxing2.qrcode.decoder.ErrorCorrectionLevel)
  (r4v1 com.dcloud.zxing2.qrcode.decoder.ErrorCorrectionLevel)
 A[WRAPPED] (LINE:19) elemType: com.dcloud.zxing2.qrcode.decoder.ErrorCorrectionLevel
	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1604)
	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
	at jadx.core.utils.InsnRemover.removeAllAndUnbind(InsnRemover.java:257)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:187)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class ErrorCorrectionLevel {
    L(1),
    M(0),
    Q(3),
    H(2);

    private static final com.dcloud.zxing2.qrcode.decoder.ErrorCorrectionLevel[] FOR_BITS;
    private final int bits;

    static {
        FOR_BITS = new com.dcloud.zxing2.qrcode.decoder.ErrorCorrectionLevel[]{errorCorrectionLevel, new com.dcloud.zxing2.qrcode.decoder.ErrorCorrectionLevel(1), errorCorrectionLevel, new com.dcloud.zxing2.qrcode.decoder.ErrorCorrectionLevel(3)};
    }

    private ErrorCorrectionLevel(int i) {
        super(str, i);
        this.bits = i;
    }

    public static com.dcloud.zxing2.qrcode.decoder.ErrorCorrectionLevel forBits(int i) {
        if (i >= 0) {
            com.dcloud.zxing2.qrcode.decoder.ErrorCorrectionLevel[] errorCorrectionLevelArr = FOR_BITS;
            if (i < errorCorrectionLevelArr.length) {
                return errorCorrectionLevelArr[i];
            }
        }
        throw new java.lang.IllegalArgumentException();
    }

    public static com.dcloud.zxing2.qrcode.decoder.ErrorCorrectionLevel valueOf(java.lang.String str) {
        return (com.dcloud.zxing2.qrcode.decoder.ErrorCorrectionLevel) java.lang.Enum.valueOf(com.dcloud.zxing2.qrcode.decoder.ErrorCorrectionLevel.class, str);
    }

    public static com.dcloud.zxing2.qrcode.decoder.ErrorCorrectionLevel[] values() {
        return (com.dcloud.zxing2.qrcode.decoder.ErrorCorrectionLevel[]) $VALUES.clone();
    }

    public int getBits() {
        return this.bits;
    }
}
