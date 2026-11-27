package com.dcloud.zxing2.multi;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class ByQuadrantReader implements com.dcloud.zxing2.Reader {
    private final com.dcloud.zxing2.Reader delegate;

    public ByQuadrantReader(com.dcloud.zxing2.Reader reader) {
        this.delegate = reader;
    }

    private static void makeAbsolute(com.dcloud.zxing2.ResultPoint[] resultPointArr, int i, int i2) {
        if (resultPointArr != null) {
            for (int i3 = 0; i3 < resultPointArr.length; i3++) {
                com.dcloud.zxing2.ResultPoint resultPoint = resultPointArr[i3];
                resultPointArr[i3] = new com.dcloud.zxing2.ResultPoint(resultPoint.getX() + i, resultPoint.getY() + i2);
            }
        }
    }

    @Override // com.dcloud.zxing2.Reader
    public com.dcloud.zxing2.Result decode(com.dcloud.zxing2.BinaryBitmap binaryBitmap) throws com.dcloud.zxing2.ChecksumException, com.dcloud.zxing2.FormatException, com.dcloud.zxing2.NotFoundException {
        return decode(binaryBitmap, null);
    }

    @Override // com.dcloud.zxing2.Reader
    public void reset() {
        this.delegate.reset();
    }

    @Override // com.dcloud.zxing2.Reader
    public com.dcloud.zxing2.Result decode(com.dcloud.zxing2.BinaryBitmap binaryBitmap, java.util.Map<com.dcloud.zxing2.DecodeHintType, ?> map) throws com.dcloud.zxing2.ChecksumException, com.dcloud.zxing2.FormatException, com.dcloud.zxing2.NotFoundException {
        int width = binaryBitmap.getWidth() / 2;
        int height = binaryBitmap.getHeight() / 2;
        try {
            try {
                try {
                    try {
                        return this.delegate.decode(binaryBitmap.crop(0, 0, width, height), map);
                    } catch (com.dcloud.zxing2.NotFoundException unused) {
                        com.dcloud.zxing2.Result resultDecode = this.delegate.decode(binaryBitmap.crop(width, 0, width, height), map);
                        makeAbsolute(resultDecode.getResultPoints(), width, 0);
                        return resultDecode;
                    }
                } catch (com.dcloud.zxing2.NotFoundException unused2) {
                    com.dcloud.zxing2.Result resultDecode2 = this.delegate.decode(binaryBitmap.crop(width, height, width, height), map);
                    makeAbsolute(resultDecode2.getResultPoints(), width, height);
                    return resultDecode2;
                }
            } catch (com.dcloud.zxing2.NotFoundException unused3) {
                com.dcloud.zxing2.Result resultDecode3 = this.delegate.decode(binaryBitmap.crop(0, height, width, height), map);
                makeAbsolute(resultDecode3.getResultPoints(), 0, height);
                return resultDecode3;
            }
        } catch (com.dcloud.zxing2.NotFoundException unused4) {
            int i = width / 2;
            int i2 = height / 2;
            com.dcloud.zxing2.Result resultDecode4 = this.delegate.decode(binaryBitmap.crop(i, i2, width, height), map);
            makeAbsolute(resultDecode4.getResultPoints(), i, i2);
            return resultDecode4;
        }
    }
}
