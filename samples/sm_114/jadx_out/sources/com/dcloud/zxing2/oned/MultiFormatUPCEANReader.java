package com.dcloud.zxing2.oned;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class MultiFormatUPCEANReader extends com.dcloud.zxing2.oned.OneDReader {
    private final com.dcloud.zxing2.oned.UPCEANReader[] readers;

    public MultiFormatUPCEANReader(java.util.Map<com.dcloud.zxing2.DecodeHintType, ?> map) {
        java.util.Collection collection = map == null ? null : (java.util.Collection) map.get(com.dcloud.zxing2.DecodeHintType.POSSIBLE_FORMATS);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (collection != null) {
            if (collection.contains(com.dcloud.zxing2.BarcodeFormat.EAN_13)) {
                arrayList.add(new com.dcloud.zxing2.oned.EAN13Reader());
            } else if (collection.contains(com.dcloud.zxing2.BarcodeFormat.UPC_A)) {
                arrayList.add(new com.dcloud.zxing2.oned.UPCAReader());
            }
            if (collection.contains(com.dcloud.zxing2.BarcodeFormat.EAN_8)) {
                arrayList.add(new com.dcloud.zxing2.oned.EAN8Reader());
            }
            if (collection.contains(com.dcloud.zxing2.BarcodeFormat.UPC_E)) {
                arrayList.add(new com.dcloud.zxing2.oned.UPCEReader());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new com.dcloud.zxing2.oned.EAN13Reader());
            arrayList.add(new com.dcloud.zxing2.oned.EAN8Reader());
            arrayList.add(new com.dcloud.zxing2.oned.UPCEReader());
        }
        this.readers = (com.dcloud.zxing2.oned.UPCEANReader[]) arrayList.toArray(new com.dcloud.zxing2.oned.UPCEANReader[arrayList.size()]);
    }

    @Override // com.dcloud.zxing2.oned.OneDReader
    public com.dcloud.zxing2.Result decodeRow(int i, com.dcloud.zxing2.common.BitArray bitArray, java.util.Map<com.dcloud.zxing2.DecodeHintType, ?> map) throws com.dcloud.zxing2.NotFoundException {
        int[] iArrFindStartGuardPattern = com.dcloud.zxing2.oned.UPCEANReader.findStartGuardPattern(bitArray);
        for (com.dcloud.zxing2.oned.UPCEANReader uPCEANReader : this.readers) {
            try {
                com.dcloud.zxing2.Result resultDecodeRow = uPCEANReader.decodeRow(i, bitArray, iArrFindStartGuardPattern, map);
                boolean z = resultDecodeRow.getBarcodeFormat() == com.dcloud.zxing2.BarcodeFormat.EAN_13 && resultDecodeRow.getText().charAt(0) == '0';
                java.util.Collection collection = map == null ? null : (java.util.Collection) map.get(com.dcloud.zxing2.DecodeHintType.POSSIBLE_FORMATS);
                boolean z2 = collection == null || collection.contains(com.dcloud.zxing2.BarcodeFormat.UPC_A);
                if (!z || !z2) {
                    return resultDecodeRow;
                }
                com.dcloud.zxing2.Result result = new com.dcloud.zxing2.Result(resultDecodeRow.getText().substring(1), resultDecodeRow.getRawBytes(), resultDecodeRow.getResultPoints(), com.dcloud.zxing2.BarcodeFormat.UPC_A);
                result.putAllMetadata(resultDecodeRow.getResultMetadata());
                return result;
            } catch (com.dcloud.zxing2.ReaderException unused) {
            }
        }
        throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
    }

    @Override // com.dcloud.zxing2.oned.OneDReader, com.dcloud.zxing2.Reader
    public void reset() {
        for (com.dcloud.zxing2.oned.UPCEANReader uPCEANReader : this.readers) {
            uPCEANReader.reset();
        }
    }
}
