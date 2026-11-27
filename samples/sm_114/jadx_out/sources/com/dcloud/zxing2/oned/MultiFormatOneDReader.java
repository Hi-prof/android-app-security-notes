package com.dcloud.zxing2.oned;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class MultiFormatOneDReader extends com.dcloud.zxing2.oned.OneDReader {
    private final com.dcloud.zxing2.oned.OneDReader[] readers;

    public MultiFormatOneDReader(java.util.Map<com.dcloud.zxing2.DecodeHintType, ?> map) {
        java.util.Collection collection = map == null ? null : (java.util.Collection) map.get(com.dcloud.zxing2.DecodeHintType.POSSIBLE_FORMATS);
        boolean z = (map == null || map.get(com.dcloud.zxing2.DecodeHintType.ASSUME_CODE_39_CHECK_DIGIT) == null) ? false : true;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (collection != null) {
            if (collection.contains(com.dcloud.zxing2.BarcodeFormat.EAN_13) || collection.contains(com.dcloud.zxing2.BarcodeFormat.UPC_A) || collection.contains(com.dcloud.zxing2.BarcodeFormat.EAN_8) || collection.contains(com.dcloud.zxing2.BarcodeFormat.UPC_E)) {
                arrayList.add(new com.dcloud.zxing2.oned.MultiFormatUPCEANReader(map));
            }
            if (collection.contains(com.dcloud.zxing2.BarcodeFormat.CODE_39)) {
                arrayList.add(new com.dcloud.zxing2.oned.Code39Reader(z));
            }
            if (collection.contains(com.dcloud.zxing2.BarcodeFormat.CODE_93)) {
                arrayList.add(new com.dcloud.zxing2.oned.Code93Reader());
            }
            if (collection.contains(com.dcloud.zxing2.BarcodeFormat.CODE_128)) {
                arrayList.add(new com.dcloud.zxing2.oned.Code128Reader());
            }
            if (collection.contains(com.dcloud.zxing2.BarcodeFormat.ITF)) {
                arrayList.add(new com.dcloud.zxing2.oned.ITFReader());
            }
            if (collection.contains(com.dcloud.zxing2.BarcodeFormat.CODABAR)) {
                arrayList.add(new com.dcloud.zxing2.oned.CodaBarReader());
            }
            if (collection.contains(com.dcloud.zxing2.BarcodeFormat.RSS_14)) {
                arrayList.add(new com.dcloud.zxing2.oned.rss.RSS14Reader());
            }
            if (collection.contains(com.dcloud.zxing2.BarcodeFormat.RSS_EXPANDED)) {
                arrayList.add(new com.dcloud.zxing2.oned.rss.expanded.RSSExpandedReader());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new com.dcloud.zxing2.oned.MultiFormatUPCEANReader(map));
            arrayList.add(new com.dcloud.zxing2.oned.Code39Reader());
            arrayList.add(new com.dcloud.zxing2.oned.CodaBarReader());
            arrayList.add(new com.dcloud.zxing2.oned.Code93Reader());
            arrayList.add(new com.dcloud.zxing2.oned.Code128Reader());
            arrayList.add(new com.dcloud.zxing2.oned.ITFReader());
            arrayList.add(new com.dcloud.zxing2.oned.rss.RSS14Reader());
            arrayList.add(new com.dcloud.zxing2.oned.rss.expanded.RSSExpandedReader());
        }
        this.readers = (com.dcloud.zxing2.oned.OneDReader[]) arrayList.toArray(new com.dcloud.zxing2.oned.OneDReader[arrayList.size()]);
    }

    @Override // com.dcloud.zxing2.oned.OneDReader
    public com.dcloud.zxing2.Result decodeRow(int i, com.dcloud.zxing2.common.BitArray bitArray, java.util.Map<com.dcloud.zxing2.DecodeHintType, ?> map) throws com.dcloud.zxing2.NotFoundException {
        for (com.dcloud.zxing2.oned.OneDReader oneDReader : this.readers) {
            try {
                return oneDReader.decodeRow(i, bitArray, map);
            } catch (com.dcloud.zxing2.ReaderException unused) {
            }
        }
        throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
    }

    @Override // com.dcloud.zxing2.oned.OneDReader, com.dcloud.zxing2.Reader
    public void reset() {
        for (com.dcloud.zxing2.oned.OneDReader oneDReader : this.readers) {
            oneDReader.reset();
        }
    }
}
