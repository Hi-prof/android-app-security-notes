package io.dcloud.feature.barcode2.decoding;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
final class DecodeFormatManager {
    private static final java.util.regex.Pattern COMMA_PATTERN = java.util.regex.Pattern.compile(",");
    static final java.util.Vector<com.dcloud.zxing2.BarcodeFormat> DATA_MATRIX_FORMATS;
    static final java.util.Vector<com.dcloud.zxing2.BarcodeFormat> ONE_D_FORMATS;
    static final java.util.Vector<com.dcloud.zxing2.BarcodeFormat> PRODUCT_FORMATS;
    static final java.util.Vector<com.dcloud.zxing2.BarcodeFormat> QR_CODE_FORMATS;

    static {
        java.util.Vector<com.dcloud.zxing2.BarcodeFormat> vector = new java.util.Vector<>(5);
        PRODUCT_FORMATS = vector;
        vector.add(com.dcloud.zxing2.BarcodeFormat.UPC_A);
        vector.add(com.dcloud.zxing2.BarcodeFormat.UPC_E);
        vector.add(com.dcloud.zxing2.BarcodeFormat.EAN_13);
        vector.add(com.dcloud.zxing2.BarcodeFormat.EAN_8);
        vector.add(com.dcloud.zxing2.BarcodeFormat.RSS_14);
        java.util.Vector<com.dcloud.zxing2.BarcodeFormat> vector2 = new java.util.Vector<>(vector.size() + 4);
        ONE_D_FORMATS = vector2;
        vector2.addAll(vector);
        vector2.add(com.dcloud.zxing2.BarcodeFormat.CODE_39);
        vector2.add(com.dcloud.zxing2.BarcodeFormat.CODE_93);
        vector2.add(com.dcloud.zxing2.BarcodeFormat.CODE_128);
        vector2.add(com.dcloud.zxing2.BarcodeFormat.ITF);
        java.util.Vector<com.dcloud.zxing2.BarcodeFormat> vector3 = new java.util.Vector<>(1);
        QR_CODE_FORMATS = vector3;
        vector3.add(com.dcloud.zxing2.BarcodeFormat.QR_CODE);
        java.util.Vector<com.dcloud.zxing2.BarcodeFormat> vector4 = new java.util.Vector<>(1);
        DATA_MATRIX_FORMATS = vector4;
        vector4.add(com.dcloud.zxing2.BarcodeFormat.DATA_MATRIX);
    }

    private DecodeFormatManager() {
    }

    static java.util.Vector<com.dcloud.zxing2.BarcodeFormat> parseDecodeFormats(android.content.Intent intent) {
        java.lang.String stringExtra = intent.getStringExtra(io.dcloud.feature.barcode2.decoding.Intents.Scan.SCAN_FORMATS);
        return parseDecodeFormats(stringExtra != null ? java.util.Arrays.asList(COMMA_PATTERN.split(stringExtra)) : null, intent.getStringExtra(io.dcloud.feature.barcode2.decoding.Intents.Scan.MODE));
    }

    static java.util.Vector<com.dcloud.zxing2.BarcodeFormat> parseDecodeFormats(android.net.Uri uri) {
        java.util.List<java.lang.String> queryParameters = uri.getQueryParameters(io.dcloud.feature.barcode2.decoding.Intents.Scan.SCAN_FORMATS);
        if (queryParameters != null && queryParameters.size() == 1 && queryParameters.get(0) != null) {
            queryParameters = java.util.Arrays.asList(COMMA_PATTERN.split(queryParameters.get(0)));
        }
        return parseDecodeFormats(queryParameters, uri.getQueryParameter(io.dcloud.feature.barcode2.decoding.Intents.Scan.MODE));
    }

    private static java.util.Vector<com.dcloud.zxing2.BarcodeFormat> parseDecodeFormats(java.lang.Iterable<java.lang.String> iterable, java.lang.String str) {
        if (iterable != null) {
            java.util.Vector<com.dcloud.zxing2.BarcodeFormat> vector = new java.util.Vector<>();
            try {
                java.util.Iterator<java.lang.String> it = iterable.iterator();
                while (it.hasNext()) {
                    vector.add(com.dcloud.zxing2.BarcodeFormat.valueOf(it.next()));
                }
                return vector;
            } catch (java.lang.IllegalArgumentException unused) {
            }
        }
        if (str == null) {
            return null;
        }
        if (io.dcloud.feature.barcode2.decoding.Intents.Scan.PRODUCT_MODE.equals(str)) {
            return PRODUCT_FORMATS;
        }
        if (io.dcloud.feature.barcode2.decoding.Intents.Scan.QR_CODE_MODE.equals(str)) {
            return QR_CODE_FORMATS;
        }
        if (io.dcloud.feature.barcode2.decoding.Intents.Scan.DATA_MATRIX_MODE.equals(str)) {
            return DATA_MATRIX_FORMATS;
        }
        if (io.dcloud.feature.barcode2.decoding.Intents.Scan.ONE_D_MODE.equals(str)) {
            return ONE_D_FORMATS;
        }
        return null;
    }
}
