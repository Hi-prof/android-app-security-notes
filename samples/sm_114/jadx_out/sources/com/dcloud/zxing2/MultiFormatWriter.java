package com.dcloud.zxing2;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class MultiFormatWriter implements com.dcloud.zxing2.Writer {

    /* JADX INFO: renamed from: com.dcloud.zxing2.MultiFormatWriter$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$dcloud$zxing2$BarcodeFormat;

        static {
            int[] iArr = new int[com.dcloud.zxing2.BarcodeFormat.values().length];
            $SwitchMap$com$dcloud$zxing2$BarcodeFormat = iArr;
            try {
                iArr[com.dcloud.zxing2.BarcodeFormat.EAN_8.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dcloud$zxing2$BarcodeFormat[com.dcloud.zxing2.BarcodeFormat.UPC_E.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dcloud$zxing2$BarcodeFormat[com.dcloud.zxing2.BarcodeFormat.EAN_13.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dcloud$zxing2$BarcodeFormat[com.dcloud.zxing2.BarcodeFormat.UPC_A.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$dcloud$zxing2$BarcodeFormat[com.dcloud.zxing2.BarcodeFormat.QR_CODE.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$dcloud$zxing2$BarcodeFormat[com.dcloud.zxing2.BarcodeFormat.CODE_39.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$dcloud$zxing2$BarcodeFormat[com.dcloud.zxing2.BarcodeFormat.CODE_93.ordinal()] = 7;
            } catch (java.lang.NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$dcloud$zxing2$BarcodeFormat[com.dcloud.zxing2.BarcodeFormat.CODE_128.ordinal()] = 8;
            } catch (java.lang.NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$dcloud$zxing2$BarcodeFormat[com.dcloud.zxing2.BarcodeFormat.ITF.ordinal()] = 9;
            } catch (java.lang.NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$dcloud$zxing2$BarcodeFormat[com.dcloud.zxing2.BarcodeFormat.PDF_417.ordinal()] = 10;
            } catch (java.lang.NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$dcloud$zxing2$BarcodeFormat[com.dcloud.zxing2.BarcodeFormat.CODABAR.ordinal()] = 11;
            } catch (java.lang.NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$dcloud$zxing2$BarcodeFormat[com.dcloud.zxing2.BarcodeFormat.DATA_MATRIX.ordinal()] = 12;
            } catch (java.lang.NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$dcloud$zxing2$BarcodeFormat[com.dcloud.zxing2.BarcodeFormat.AZTEC.ordinal()] = 13;
            } catch (java.lang.NoSuchFieldError unused13) {
            }
        }
    }

    @Override // com.dcloud.zxing2.Writer
    public com.dcloud.zxing2.common.BitMatrix encode(java.lang.String str, com.dcloud.zxing2.BarcodeFormat barcodeFormat, int i, int i2) throws com.dcloud.zxing2.WriterException {
        return encode(str, barcodeFormat, i, i2, null);
    }

    @Override // com.dcloud.zxing2.Writer
    public com.dcloud.zxing2.common.BitMatrix encode(java.lang.String str, com.dcloud.zxing2.BarcodeFormat barcodeFormat, int i, int i2, java.util.Map<com.dcloud.zxing2.EncodeHintType, ?> map) throws com.dcloud.zxing2.WriterException {
        com.dcloud.zxing2.Writer eAN8Writer;
        switch (com.dcloud.zxing2.MultiFormatWriter.AnonymousClass1.$SwitchMap$com$dcloud$zxing2$BarcodeFormat[barcodeFormat.ordinal()]) {
            case 1:
                eAN8Writer = new com.dcloud.zxing2.oned.EAN8Writer();
                break;
            case 2:
                eAN8Writer = new com.dcloud.zxing2.oned.UPCEWriter();
                break;
            case 3:
                eAN8Writer = new com.dcloud.zxing2.oned.EAN13Writer();
                break;
            case 4:
                eAN8Writer = new com.dcloud.zxing2.oned.UPCAWriter();
                break;
            case 5:
                eAN8Writer = new com.dcloud.zxing2.qrcode.QRCodeWriter();
                break;
            case 6:
                eAN8Writer = new com.dcloud.zxing2.oned.Code39Writer();
                break;
            case 7:
                eAN8Writer = new com.dcloud.zxing2.oned.Code93Writer();
                break;
            case 8:
                eAN8Writer = new com.dcloud.zxing2.oned.Code128Writer();
                break;
            case 9:
                eAN8Writer = new com.dcloud.zxing2.oned.ITFWriter();
                break;
            case 10:
                eAN8Writer = new com.dcloud.zxing2.pdf417.PDF417Writer();
                break;
            case 11:
                eAN8Writer = new com.dcloud.zxing2.oned.CodaBarWriter();
                break;
            case 12:
                eAN8Writer = new com.dcloud.zxing2.datamatrix.DataMatrixWriter();
                break;
            case 13:
                eAN8Writer = new com.dcloud.zxing2.aztec.AztecWriter();
                break;
            default:
                throw new java.lang.IllegalArgumentException("No encoder available for format " + barcodeFormat);
        }
        return eAN8Writer.encode(str, barcodeFormat, i, i2, map);
    }
}
