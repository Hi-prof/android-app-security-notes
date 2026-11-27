package com.dcloud.zxing2.qrcode.decoder;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
abstract class DataMask {
    private static final com.dcloud.zxing2.qrcode.decoder.DataMask[] DATA_MASKS;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    private static final class DataMask000 extends com.dcloud.zxing2.qrcode.decoder.DataMask {
        private DataMask000() {
            super();
        }

        @Override // com.dcloud.zxing2.qrcode.decoder.DataMask
        boolean isMasked(int i, int i2) {
            return ((i + i2) & 1) == 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    private static final class DataMask001 extends com.dcloud.zxing2.qrcode.decoder.DataMask {
        private DataMask001() {
            super();
        }

        @Override // com.dcloud.zxing2.qrcode.decoder.DataMask
        boolean isMasked(int i, int i2) {
            return (i & 1) == 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    private static final class DataMask010 extends com.dcloud.zxing2.qrcode.decoder.DataMask {
        private DataMask010() {
            super();
        }

        @Override // com.dcloud.zxing2.qrcode.decoder.DataMask
        boolean isMasked(int i, int i2) {
            return i2 % 3 == 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    private static final class DataMask011 extends com.dcloud.zxing2.qrcode.decoder.DataMask {
        private DataMask011() {
            super();
        }

        @Override // com.dcloud.zxing2.qrcode.decoder.DataMask
        boolean isMasked(int i, int i2) {
            return (i + i2) % 3 == 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    private static final class DataMask100 extends com.dcloud.zxing2.qrcode.decoder.DataMask {
        private DataMask100() {
            super();
        }

        @Override // com.dcloud.zxing2.qrcode.decoder.DataMask
        boolean isMasked(int i, int i2) {
            return (((i / 2) + (i2 / 3)) & 1) == 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    private static final class DataMask101 extends com.dcloud.zxing2.qrcode.decoder.DataMask {
        private DataMask101() {
            super();
        }

        @Override // com.dcloud.zxing2.qrcode.decoder.DataMask
        boolean isMasked(int i, int i2) {
            int i3 = i * i2;
            return (i3 & 1) + (i3 % 3) == 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    private static final class DataMask110 extends com.dcloud.zxing2.qrcode.decoder.DataMask {
        private DataMask110() {
            super();
        }

        @Override // com.dcloud.zxing2.qrcode.decoder.DataMask
        boolean isMasked(int i, int i2) {
            int i3 = i * i2;
            return (((i3 & 1) + (i3 % 3)) & 1) == 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    private static final class DataMask111 extends com.dcloud.zxing2.qrcode.decoder.DataMask {
        private DataMask111() {
            super();
        }

        @Override // com.dcloud.zxing2.qrcode.decoder.DataMask
        boolean isMasked(int i, int i2) {
            return ((((i + i2) & 1) + ((i * i2) % 3)) & 1) == 0;
        }
    }

    static {
        DATA_MASKS = new com.dcloud.zxing2.qrcode.decoder.DataMask[]{new com.dcloud.zxing2.qrcode.decoder.DataMask.DataMask000(), new com.dcloud.zxing2.qrcode.decoder.DataMask.DataMask001(), new com.dcloud.zxing2.qrcode.decoder.DataMask.DataMask010(), new com.dcloud.zxing2.qrcode.decoder.DataMask.DataMask011(), new com.dcloud.zxing2.qrcode.decoder.DataMask.DataMask100(), new com.dcloud.zxing2.qrcode.decoder.DataMask.DataMask101(), new com.dcloud.zxing2.qrcode.decoder.DataMask.DataMask110(), new com.dcloud.zxing2.qrcode.decoder.DataMask.DataMask111()};
    }

    static com.dcloud.zxing2.qrcode.decoder.DataMask forReference(int i) {
        if (i < 0 || i > 7) {
            throw new java.lang.IllegalArgumentException();
        }
        return DATA_MASKS[i];
    }

    abstract boolean isMasked(int i, int i2);

    final void unmaskBitMatrix(com.dcloud.zxing2.common.BitMatrix bitMatrix, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            for (int i3 = 0; i3 < i; i3++) {
                if (isMasked(i2, i3)) {
                    bitMatrix.flip(i3, i2);
                }
            }
        }
    }

    private DataMask() {
    }
}
