package com.dcloud.zxing2.multi.qrcode.detector;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class MultiDetector extends com.dcloud.zxing2.qrcode.detector.Detector {
    private static final com.dcloud.zxing2.common.DetectorResult[] EMPTY_DETECTOR_RESULTS = new com.dcloud.zxing2.common.DetectorResult[0];

    public MultiDetector(com.dcloud.zxing2.common.BitMatrix bitMatrix) {
        super(bitMatrix);
    }

    public com.dcloud.zxing2.common.DetectorResult[] detectMulti(java.util.Map<com.dcloud.zxing2.DecodeHintType, ?> map) throws com.dcloud.zxing2.NotFoundException {
        com.dcloud.zxing2.qrcode.detector.FinderPatternInfo[] finderPatternInfoArrFindMulti = new com.dcloud.zxing2.multi.qrcode.detector.MultiFinderPatternFinder(getImage(), map == null ? null : (com.dcloud.zxing2.ResultPointCallback) map.get(com.dcloud.zxing2.DecodeHintType.NEED_RESULT_POINT_CALLBACK)).findMulti(map);
        if (finderPatternInfoArrFindMulti.length == 0) {
            throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (com.dcloud.zxing2.qrcode.detector.FinderPatternInfo finderPatternInfo : finderPatternInfoArrFindMulti) {
            try {
                arrayList.add(processFinderPatternInfo(finderPatternInfo));
            } catch (com.dcloud.zxing2.ReaderException unused) {
            }
        }
        return arrayList.isEmpty() ? EMPTY_DETECTOR_RESULTS : (com.dcloud.zxing2.common.DetectorResult[]) arrayList.toArray(new com.dcloud.zxing2.common.DetectorResult[arrayList.size()]);
    }
}
