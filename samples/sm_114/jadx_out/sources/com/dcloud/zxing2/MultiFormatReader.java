package com.dcloud.zxing2;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class MultiFormatReader implements com.dcloud.zxing2.Reader {
    private java.util.Map<com.dcloud.zxing2.DecodeHintType, ?> hints;
    private android.os.Handler hostHandler;
    private com.dcloud.zxing2.Reader[] readers;

    public MultiFormatReader(android.os.Handler handler) {
        this.hostHandler = handler;
    }

    private com.dcloud.zxing2.Result decodeInternal(com.dcloud.zxing2.BinaryBitmap binaryBitmap) throws com.dcloud.zxing2.NotFoundException {
        com.dcloud.zxing2.Reader[] readerArr = this.readers;
        if (readerArr != null) {
            for (com.dcloud.zxing2.Reader reader : readerArr) {
                try {
                    return reader.decode(binaryBitmap, this.hints);
                } catch (com.dcloud.zxing2.ReaderException unused) {
                }
            }
        }
        throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
    }

    @Override // com.dcloud.zxing2.Reader
    public com.dcloud.zxing2.Result decode(com.dcloud.zxing2.BinaryBitmap binaryBitmap) throws com.dcloud.zxing2.NotFoundException {
        setHints(null);
        return decodeInternal(binaryBitmap);
    }

    public com.dcloud.zxing2.Result decodeWithState(com.dcloud.zxing2.BinaryBitmap binaryBitmap) throws com.dcloud.zxing2.NotFoundException {
        if (this.readers == null) {
            setHints(null);
        }
        return decodeInternal(binaryBitmap);
    }

    @Override // com.dcloud.zxing2.Reader
    public void reset() {
        com.dcloud.zxing2.Reader[] readerArr = this.readers;
        if (readerArr != null) {
            for (com.dcloud.zxing2.Reader reader : readerArr) {
                reader.reset();
            }
        }
    }

    public void setHints(java.util.Map<com.dcloud.zxing2.DecodeHintType, ?> map) {
        this.hints = map;
        boolean z = true;
        boolean z2 = map != null && map.containsKey(com.dcloud.zxing2.DecodeHintType.TRY_HARDER);
        java.util.Collection collection = map == null ? null : (java.util.Collection) map.get(com.dcloud.zxing2.DecodeHintType.POSSIBLE_FORMATS);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (collection != null) {
            if (!collection.contains(com.dcloud.zxing2.BarcodeFormat.UPC_A) && !collection.contains(com.dcloud.zxing2.BarcodeFormat.UPC_E) && !collection.contains(com.dcloud.zxing2.BarcodeFormat.EAN_13) && !collection.contains(com.dcloud.zxing2.BarcodeFormat.EAN_8) && !collection.contains(com.dcloud.zxing2.BarcodeFormat.CODABAR) && !collection.contains(com.dcloud.zxing2.BarcodeFormat.CODE_39) && !collection.contains(com.dcloud.zxing2.BarcodeFormat.CODE_93) && !collection.contains(com.dcloud.zxing2.BarcodeFormat.CODE_128) && !collection.contains(com.dcloud.zxing2.BarcodeFormat.ITF) && !collection.contains(com.dcloud.zxing2.BarcodeFormat.RSS_14) && !collection.contains(com.dcloud.zxing2.BarcodeFormat.RSS_EXPANDED)) {
                z = false;
            }
            if (z && !z2) {
                arrayList.add(new com.dcloud.zxing2.oned.MultiFormatOneDReader(map));
            }
            if (collection.contains(com.dcloud.zxing2.BarcodeFormat.QR_CODE)) {
                com.dcloud.zxing2.qrcode.QRCodeReader qRCodeReader = new com.dcloud.zxing2.qrcode.QRCodeReader();
                qRCodeReader.updateHandler(this.hostHandler);
                arrayList.add(qRCodeReader);
            }
            if (collection.contains(com.dcloud.zxing2.BarcodeFormat.DATA_MATRIX)) {
                arrayList.add(new com.dcloud.zxing2.datamatrix.DataMatrixReader());
            }
            if (collection.contains(com.dcloud.zxing2.BarcodeFormat.AZTEC)) {
                arrayList.add(new com.dcloud.zxing2.aztec.AztecReader());
            }
            if (collection.contains(com.dcloud.zxing2.BarcodeFormat.PDF_417)) {
                arrayList.add(new com.dcloud.zxing2.pdf417.PDF417Reader());
            }
            if (collection.contains(com.dcloud.zxing2.BarcodeFormat.MAXICODE)) {
                arrayList.add(new com.dcloud.zxing2.maxicode.MaxiCodeReader());
            }
            if (z && z2) {
                arrayList.add(new com.dcloud.zxing2.oned.MultiFormatOneDReader(map));
            }
        }
        if (arrayList.isEmpty()) {
            if (!z2) {
                arrayList.add(new com.dcloud.zxing2.oned.MultiFormatOneDReader(map));
            }
            com.dcloud.zxing2.qrcode.QRCodeReader qRCodeReader2 = new com.dcloud.zxing2.qrcode.QRCodeReader();
            qRCodeReader2.updateHandler(this.hostHandler);
            arrayList.add(qRCodeReader2);
            arrayList.add(new com.dcloud.zxing2.datamatrix.DataMatrixReader());
            arrayList.add(new com.dcloud.zxing2.aztec.AztecReader());
            arrayList.add(new com.dcloud.zxing2.pdf417.PDF417Reader());
            arrayList.add(new com.dcloud.zxing2.maxicode.MaxiCodeReader());
            if (z2) {
                arrayList.add(new com.dcloud.zxing2.oned.MultiFormatOneDReader(map));
            }
        }
        this.readers = (com.dcloud.zxing2.Reader[]) arrayList.toArray(new com.dcloud.zxing2.Reader[arrayList.size()]);
    }

    @Override // com.dcloud.zxing2.Reader
    public com.dcloud.zxing2.Result decode(com.dcloud.zxing2.BinaryBitmap binaryBitmap, java.util.Map<com.dcloud.zxing2.DecodeHintType, ?> map) throws com.dcloud.zxing2.NotFoundException {
        setHints(map);
        return decodeInternal(binaryBitmap);
    }
}
