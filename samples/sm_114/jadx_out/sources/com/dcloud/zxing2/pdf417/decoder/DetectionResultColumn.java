package com.dcloud.zxing2.pdf417.decoder;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
class DetectionResultColumn {
    private static final int MAX_NEARBY_DISTANCE = 5;
    private final com.dcloud.zxing2.pdf417.decoder.BoundingBox boundingBox;
    private final com.dcloud.zxing2.pdf417.decoder.Codeword[] codewords;

    DetectionResultColumn(com.dcloud.zxing2.pdf417.decoder.BoundingBox boundingBox) {
        this.boundingBox = new com.dcloud.zxing2.pdf417.decoder.BoundingBox(boundingBox);
        this.codewords = new com.dcloud.zxing2.pdf417.decoder.Codeword[(boundingBox.getMaxY() - boundingBox.getMinY()) + 1];
    }

    final com.dcloud.zxing2.pdf417.decoder.BoundingBox getBoundingBox() {
        return this.boundingBox;
    }

    final com.dcloud.zxing2.pdf417.decoder.Codeword getCodeword(int i) {
        return this.codewords[imageRowToCodewordIndex(i)];
    }

    final com.dcloud.zxing2.pdf417.decoder.Codeword getCodewordNearby(int i) {
        com.dcloud.zxing2.pdf417.decoder.Codeword codeword;
        com.dcloud.zxing2.pdf417.decoder.Codeword codeword2;
        com.dcloud.zxing2.pdf417.decoder.Codeword codeword3 = getCodeword(i);
        if (codeword3 != null) {
            return codeword3;
        }
        for (int i2 = 1; i2 < 5; i2++) {
            int iImageRowToCodewordIndex = imageRowToCodewordIndex(i) - i2;
            if (iImageRowToCodewordIndex >= 0 && (codeword2 = this.codewords[iImageRowToCodewordIndex]) != null) {
                return codeword2;
            }
            int iImageRowToCodewordIndex2 = imageRowToCodewordIndex(i) + i2;
            com.dcloud.zxing2.pdf417.decoder.Codeword[] codewordArr = this.codewords;
            if (iImageRowToCodewordIndex2 < codewordArr.length && (codeword = codewordArr[iImageRowToCodewordIndex2]) != null) {
                return codeword;
            }
        }
        return null;
    }

    final com.dcloud.zxing2.pdf417.decoder.Codeword[] getCodewords() {
        return this.codewords;
    }

    final int imageRowToCodewordIndex(int i) {
        return i - this.boundingBox.getMinY();
    }

    final void setCodeword(int i, com.dcloud.zxing2.pdf417.decoder.Codeword codeword) {
        this.codewords[imageRowToCodewordIndex(i)] = codeword;
    }

    public java.lang.String toString() {
        java.util.Formatter formatter = new java.util.Formatter();
        int i = 0;
        for (com.dcloud.zxing2.pdf417.decoder.Codeword codeword : this.codewords) {
            if (codeword == null) {
                formatter.format("%3d:    |   %n", java.lang.Integer.valueOf(i));
                i++;
            } else {
                formatter.format("%3d: %3d|%3d%n", java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(codeword.getRowNumber()), java.lang.Integer.valueOf(codeword.getValue()));
                i++;
            }
        }
        java.lang.String string = formatter.toString();
        formatter.close();
        return string;
    }
}
