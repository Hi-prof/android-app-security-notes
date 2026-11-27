package com.dcloud.zxing2.oned;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class UPCAReader extends com.dcloud.zxing2.oned.UPCEANReader {
    private final com.dcloud.zxing2.oned.UPCEANReader ean13Reader = new com.dcloud.zxing2.oned.EAN13Reader();

    private static com.dcloud.zxing2.Result maybeReturnResult(com.dcloud.zxing2.Result result) throws com.dcloud.zxing2.FormatException {
        java.lang.String text = result.getText();
        if (text.charAt(0) == '0') {
            return new com.dcloud.zxing2.Result(text.substring(1), null, result.getResultPoints(), com.dcloud.zxing2.BarcodeFormat.UPC_A);
        }
        throw com.dcloud.zxing2.FormatException.getFormatInstance();
    }

    @Override // com.dcloud.zxing2.oned.OneDReader, com.dcloud.zxing2.Reader
    public com.dcloud.zxing2.Result decode(com.dcloud.zxing2.BinaryBitmap binaryBitmap) throws com.dcloud.zxing2.FormatException, com.dcloud.zxing2.NotFoundException {
        return maybeReturnResult(this.ean13Reader.decode(binaryBitmap));
    }

    @Override // com.dcloud.zxing2.oned.UPCEANReader
    protected int decodeMiddle(com.dcloud.zxing2.common.BitArray bitArray, int[] iArr, java.lang.StringBuilder sb) throws com.dcloud.zxing2.NotFoundException {
        return this.ean13Reader.decodeMiddle(bitArray, iArr, sb);
    }

    @Override // com.dcloud.zxing2.oned.UPCEANReader
    public com.dcloud.zxing2.Result decodeRow(int i, com.dcloud.zxing2.common.BitArray bitArray, int[] iArr, java.util.Map<com.dcloud.zxing2.DecodeHintType, ?> map) throws com.dcloud.zxing2.ChecksumException, com.dcloud.zxing2.FormatException, com.dcloud.zxing2.NotFoundException {
        return maybeReturnResult(this.ean13Reader.decodeRow(i, bitArray, iArr, map));
    }

    @Override // com.dcloud.zxing2.oned.UPCEANReader
    com.dcloud.zxing2.BarcodeFormat getBarcodeFormat() {
        return com.dcloud.zxing2.BarcodeFormat.UPC_A;
    }

    @Override // com.dcloud.zxing2.oned.OneDReader, com.dcloud.zxing2.Reader
    public com.dcloud.zxing2.Result decode(com.dcloud.zxing2.BinaryBitmap binaryBitmap, java.util.Map<com.dcloud.zxing2.DecodeHintType, ?> map) throws com.dcloud.zxing2.FormatException, com.dcloud.zxing2.NotFoundException {
        return maybeReturnResult(this.ean13Reader.decode(binaryBitmap, map));
    }

    @Override // com.dcloud.zxing2.oned.UPCEANReader, com.dcloud.zxing2.oned.OneDReader
    public com.dcloud.zxing2.Result decodeRow(int i, com.dcloud.zxing2.common.BitArray bitArray, java.util.Map<com.dcloud.zxing2.DecodeHintType, ?> map) throws com.dcloud.zxing2.ChecksumException, com.dcloud.zxing2.FormatException, com.dcloud.zxing2.NotFoundException {
        return maybeReturnResult(this.ean13Reader.decodeRow(i, bitArray, map));
    }
}
