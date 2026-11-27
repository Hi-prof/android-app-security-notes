package com.dcloud.zxing2.multi.qrcode;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class QRCodeMultiReader extends com.dcloud.zxing2.qrcode.QRCodeReader implements com.dcloud.zxing2.multi.MultipleBarcodeReader {
    private static final com.dcloud.zxing2.Result[] EMPTY_RESULT_ARRAY = new com.dcloud.zxing2.Result[0];
    private static final com.dcloud.zxing2.ResultPoint[] NO_POINTS = new com.dcloud.zxing2.ResultPoint[0];

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    private static final class SAComparator implements java.util.Comparator<com.dcloud.zxing2.Result>, java.io.Serializable {
        private SAComparator() {
        }

        @Override // java.util.Comparator
        public int compare(com.dcloud.zxing2.Result result, com.dcloud.zxing2.Result result2) {
            java.util.Map<com.dcloud.zxing2.ResultMetadataType, java.lang.Object> resultMetadata = result.getResultMetadata();
            com.dcloud.zxing2.ResultMetadataType resultMetadataType = com.dcloud.zxing2.ResultMetadataType.STRUCTURED_APPEND_SEQUENCE;
            int iIntValue = ((java.lang.Integer) resultMetadata.get(resultMetadataType)).intValue();
            int iIntValue2 = ((java.lang.Integer) result2.getResultMetadata().get(resultMetadataType)).intValue();
            if (iIntValue < iIntValue2) {
                return -1;
            }
            return iIntValue > iIntValue2 ? 1 : 0;
        }
    }

    private static java.util.List<com.dcloud.zxing2.Result> processStructuredAppend(java.util.List<com.dcloud.zxing2.Result> list) {
        java.util.Iterator<com.dcloud.zxing2.Result> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().getResultMetadata().containsKey(com.dcloud.zxing2.ResultMetadataType.STRUCTURED_APPEND_SEQUENCE)) {
                java.util.ArrayList arrayList = new java.util.ArrayList();
                java.util.ArrayList arrayList2 = new java.util.ArrayList();
                for (com.dcloud.zxing2.Result result : list) {
                    arrayList.add(result);
                    if (result.getResultMetadata().containsKey(com.dcloud.zxing2.ResultMetadataType.STRUCTURED_APPEND_SEQUENCE)) {
                        arrayList2.add(result);
                    }
                }
                java.util.Collections.sort(arrayList2, new com.dcloud.zxing2.multi.qrcode.QRCodeMultiReader.SAComparator());
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                int size = arrayList2.size();
                int i = 0;
                int length = 0;
                int length2 = 0;
                while (i < size) {
                    java.lang.Object obj = arrayList2.get(i);
                    i++;
                    com.dcloud.zxing2.Result result2 = (com.dcloud.zxing2.Result) obj;
                    sb.append(result2.getText());
                    length2 += result2.getRawBytes().length;
                    java.util.Map<com.dcloud.zxing2.ResultMetadataType, java.lang.Object> resultMetadata = result2.getResultMetadata();
                    com.dcloud.zxing2.ResultMetadataType resultMetadataType = com.dcloud.zxing2.ResultMetadataType.BYTE_SEGMENTS;
                    if (resultMetadata.containsKey(resultMetadataType)) {
                        java.util.Iterator it2 = ((java.lang.Iterable) result2.getResultMetadata().get(resultMetadataType)).iterator();
                        while (it2.hasNext()) {
                            length += ((byte[]) it2.next()).length;
                        }
                    }
                }
                byte[] bArr = new byte[length2];
                byte[] bArr2 = new byte[length];
                int size2 = arrayList2.size();
                int i2 = 0;
                int length3 = 0;
                int length4 = 0;
                while (i2 < size2) {
                    java.lang.Object obj2 = arrayList2.get(i2);
                    i2++;
                    com.dcloud.zxing2.Result result3 = (com.dcloud.zxing2.Result) obj2;
                    java.lang.System.arraycopy(result3.getRawBytes(), 0, bArr, length3, result3.getRawBytes().length);
                    length3 += result3.getRawBytes().length;
                    java.util.Map<com.dcloud.zxing2.ResultMetadataType, java.lang.Object> resultMetadata2 = result3.getResultMetadata();
                    com.dcloud.zxing2.ResultMetadataType resultMetadataType2 = com.dcloud.zxing2.ResultMetadataType.BYTE_SEGMENTS;
                    if (resultMetadata2.containsKey(resultMetadataType2)) {
                        for (byte[] bArr3 : (java.lang.Iterable) result3.getResultMetadata().get(resultMetadataType2)) {
                            java.lang.System.arraycopy(bArr3, 0, bArr2, length4, bArr3.length);
                            length4 += bArr3.length;
                        }
                    }
                }
                com.dcloud.zxing2.Result result4 = new com.dcloud.zxing2.Result(sb.toString(), bArr, NO_POINTS, com.dcloud.zxing2.BarcodeFormat.QR_CODE);
                if (length > 0) {
                    java.util.ArrayList arrayList3 = new java.util.ArrayList();
                    arrayList3.add(bArr2);
                    result4.putMetadata(com.dcloud.zxing2.ResultMetadataType.BYTE_SEGMENTS, arrayList3);
                }
                arrayList.add(result4);
                return arrayList;
            }
        }
        return list;
    }

    @Override // com.dcloud.zxing2.multi.MultipleBarcodeReader
    public com.dcloud.zxing2.Result[] decodeMultiple(com.dcloud.zxing2.BinaryBitmap binaryBitmap) throws com.dcloud.zxing2.NotFoundException {
        return decodeMultiple(binaryBitmap, null);
    }

    @Override // com.dcloud.zxing2.multi.MultipleBarcodeReader
    public com.dcloud.zxing2.Result[] decodeMultiple(com.dcloud.zxing2.BinaryBitmap binaryBitmap, java.util.Map<com.dcloud.zxing2.DecodeHintType, ?> map) throws com.dcloud.zxing2.NotFoundException {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (com.dcloud.zxing2.common.DetectorResult detectorResult : new com.dcloud.zxing2.multi.qrcode.detector.MultiDetector(binaryBitmap.getBlackMatrix()).detectMulti(map)) {
            try {
                com.dcloud.zxing2.common.DecoderResult decoderResultDecode = getDecoder().decode(detectorResult.getBits(), map);
                com.dcloud.zxing2.ResultPoint[] points = detectorResult.getPoints();
                if (decoderResultDecode.getOther() instanceof com.dcloud.zxing2.qrcode.decoder.QRCodeDecoderMetaData) {
                    ((com.dcloud.zxing2.qrcode.decoder.QRCodeDecoderMetaData) decoderResultDecode.getOther()).applyMirroredCorrection(points);
                }
                com.dcloud.zxing2.Result result = new com.dcloud.zxing2.Result(decoderResultDecode.getText(), decoderResultDecode.getRawBytes(), points, com.dcloud.zxing2.BarcodeFormat.QR_CODE);
                java.util.List<byte[]> byteSegments = decoderResultDecode.getByteSegments();
                if (byteSegments != null) {
                    result.putMetadata(com.dcloud.zxing2.ResultMetadataType.BYTE_SEGMENTS, byteSegments);
                }
                java.lang.String eCLevel = decoderResultDecode.getECLevel();
                if (eCLevel != null) {
                    result.putMetadata(com.dcloud.zxing2.ResultMetadataType.ERROR_CORRECTION_LEVEL, eCLevel);
                }
                if (decoderResultDecode.hasStructuredAppend()) {
                    result.putMetadata(com.dcloud.zxing2.ResultMetadataType.STRUCTURED_APPEND_SEQUENCE, java.lang.Integer.valueOf(decoderResultDecode.getStructuredAppendSequenceNumber()));
                    result.putMetadata(com.dcloud.zxing2.ResultMetadataType.STRUCTURED_APPEND_PARITY, java.lang.Integer.valueOf(decoderResultDecode.getStructuredAppendParity()));
                }
                arrayList.add(result);
            } catch (com.dcloud.zxing2.ReaderException unused) {
            }
        }
        if (arrayList.isEmpty()) {
            return EMPTY_RESULT_ARRAY;
        }
        java.util.List<com.dcloud.zxing2.Result> listProcessStructuredAppend = processStructuredAppend(arrayList);
        return (com.dcloud.zxing2.Result[]) listProcessStructuredAppend.toArray(new com.dcloud.zxing2.Result[listProcessStructuredAppend.size()]);
    }
}
