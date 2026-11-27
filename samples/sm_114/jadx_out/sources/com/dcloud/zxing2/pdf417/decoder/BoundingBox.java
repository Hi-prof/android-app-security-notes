package com.dcloud.zxing2.pdf417.decoder;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
final class BoundingBox {
    private com.dcloud.zxing2.ResultPoint bottomLeft;
    private com.dcloud.zxing2.ResultPoint bottomRight;
    private com.dcloud.zxing2.common.BitMatrix image;
    private int maxX;
    private int maxY;
    private int minX;
    private int minY;
    private com.dcloud.zxing2.ResultPoint topLeft;
    private com.dcloud.zxing2.ResultPoint topRight;

    BoundingBox(com.dcloud.zxing2.common.BitMatrix bitMatrix, com.dcloud.zxing2.ResultPoint resultPoint, com.dcloud.zxing2.ResultPoint resultPoint2, com.dcloud.zxing2.ResultPoint resultPoint3, com.dcloud.zxing2.ResultPoint resultPoint4) throws com.dcloud.zxing2.NotFoundException {
        if ((resultPoint == null && resultPoint3 == null) || ((resultPoint2 == null && resultPoint4 == null) || ((resultPoint != null && resultPoint2 == null) || (resultPoint3 != null && resultPoint4 == null)))) {
            throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
        }
        init(bitMatrix, resultPoint, resultPoint2, resultPoint3, resultPoint4);
    }

    private void calculateMinMaxValues() {
        if (this.topLeft == null) {
            this.topLeft = new com.dcloud.zxing2.ResultPoint(0.0f, this.topRight.getY());
            this.bottomLeft = new com.dcloud.zxing2.ResultPoint(0.0f, this.bottomRight.getY());
        } else if (this.topRight == null) {
            this.topRight = new com.dcloud.zxing2.ResultPoint(this.image.getWidth() - 1, this.topLeft.getY());
            this.bottomRight = new com.dcloud.zxing2.ResultPoint(this.image.getWidth() - 1, this.bottomLeft.getY());
        }
        this.minX = (int) java.lang.Math.min(this.topLeft.getX(), this.bottomLeft.getX());
        this.maxX = (int) java.lang.Math.max(this.topRight.getX(), this.bottomRight.getX());
        this.minY = (int) java.lang.Math.min(this.topLeft.getY(), this.topRight.getY());
        this.maxY = (int) java.lang.Math.max(this.bottomLeft.getY(), this.bottomRight.getY());
    }

    private void init(com.dcloud.zxing2.common.BitMatrix bitMatrix, com.dcloud.zxing2.ResultPoint resultPoint, com.dcloud.zxing2.ResultPoint resultPoint2, com.dcloud.zxing2.ResultPoint resultPoint3, com.dcloud.zxing2.ResultPoint resultPoint4) {
        this.image = bitMatrix;
        this.topLeft = resultPoint;
        this.bottomLeft = resultPoint2;
        this.topRight = resultPoint3;
        this.bottomRight = resultPoint4;
        calculateMinMaxValues();
    }

    static com.dcloud.zxing2.pdf417.decoder.BoundingBox merge(com.dcloud.zxing2.pdf417.decoder.BoundingBox boundingBox, com.dcloud.zxing2.pdf417.decoder.BoundingBox boundingBox2) throws com.dcloud.zxing2.NotFoundException {
        if (boundingBox == null) {
            return boundingBox2;
        }
        return boundingBox2 == null ? boundingBox : new com.dcloud.zxing2.pdf417.decoder.BoundingBox(boundingBox.image, boundingBox.topLeft, boundingBox.bottomLeft, boundingBox2.topRight, boundingBox2.bottomRight);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x002d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:18:0x002f  */
    /* JADX WARN: Code duplicated, block: B:19:0x0032  */
    /* JADX WARN: Code duplicated, block: B:22:0x0042  */
    /* JADX WARN: Code duplicated, block: B:25:0x0056  */
    /* JADX WARN: Code duplicated, block: B:26:0x0058  */
    /* JADX WARN: Code duplicated, block: B:27:0x005b  */
    com.dcloud.zxing2.pdf417.decoder.BoundingBox addMissingRows(int i, int i2, boolean z) throws com.dcloud.zxing2.NotFoundException {
        com.dcloud.zxing2.ResultPoint resultPoint;
        com.dcloud.zxing2.ResultPoint resultPoint2;
        com.dcloud.zxing2.ResultPoint resultPoint3;
        com.dcloud.zxing2.ResultPoint resultPoint4;
        com.dcloud.zxing2.ResultPoint resultPoint5;
        int y;
        com.dcloud.zxing2.ResultPoint resultPoint6;
        com.dcloud.zxing2.ResultPoint resultPoint7 = this.topLeft;
        com.dcloud.zxing2.ResultPoint resultPoint8 = this.bottomLeft;
        com.dcloud.zxing2.ResultPoint resultPoint9 = this.topRight;
        com.dcloud.zxing2.ResultPoint resultPoint10 = this.bottomRight;
        if (i > 0) {
            com.dcloud.zxing2.ResultPoint resultPoint11 = z ? resultPoint7 : resultPoint9;
            int y2 = ((int) resultPoint11.getY()) - i;
            if (y2 < 0) {
                y2 = 0;
            }
            com.dcloud.zxing2.ResultPoint resultPoint12 = new com.dcloud.zxing2.ResultPoint(resultPoint11.getX(), y2);
            if (z) {
                resultPoint = resultPoint12;
            } else {
                resultPoint2 = resultPoint12;
                resultPoint = resultPoint7;
            }
            if (i2 > 0) {
                if (z) {
                    resultPoint5 = this.bottomLeft;
                } else {
                    resultPoint5 = this.bottomRight;
                }
                y = ((int) resultPoint5.getY()) + i2;
                if (y >= this.image.getHeight()) {
                    y = this.image.getHeight() - 1;
                }
                resultPoint6 = new com.dcloud.zxing2.ResultPoint(resultPoint5.getX(), y);
                if (z) {
                    resultPoint3 = resultPoint6;
                } else {
                    resultPoint4 = resultPoint6;
                    resultPoint3 = resultPoint8;
                }
                calculateMinMaxValues();
                return new com.dcloud.zxing2.pdf417.decoder.BoundingBox(this.image, resultPoint, resultPoint3, resultPoint2, resultPoint4);
            }
            resultPoint3 = resultPoint8;
            resultPoint4 = resultPoint10;
            calculateMinMaxValues();
            return new com.dcloud.zxing2.pdf417.decoder.BoundingBox(this.image, resultPoint, resultPoint3, resultPoint2, resultPoint4);
        }
        resultPoint = resultPoint7;
        resultPoint2 = resultPoint9;
        if (i2 > 0) {
            if (z) {
                resultPoint5 = this.bottomLeft;
            } else {
                resultPoint5 = this.bottomRight;
            }
            y = ((int) resultPoint5.getY()) + i2;
            if (y >= this.image.getHeight()) {
                y = this.image.getHeight() - 1;
            }
            resultPoint6 = new com.dcloud.zxing2.ResultPoint(resultPoint5.getX(), y);
            if (z) {
                resultPoint3 = resultPoint6;
            } else {
                resultPoint4 = resultPoint6;
                resultPoint3 = resultPoint8;
            }
            calculateMinMaxValues();
            return new com.dcloud.zxing2.pdf417.decoder.BoundingBox(this.image, resultPoint, resultPoint3, resultPoint2, resultPoint4);
        }
        resultPoint3 = resultPoint8;
        resultPoint4 = resultPoint10;
        calculateMinMaxValues();
        return new com.dcloud.zxing2.pdf417.decoder.BoundingBox(this.image, resultPoint, resultPoint3, resultPoint2, resultPoint4);
    }

    com.dcloud.zxing2.ResultPoint getBottomLeft() {
        return this.bottomLeft;
    }

    com.dcloud.zxing2.ResultPoint getBottomRight() {
        return this.bottomRight;
    }

    int getMaxX() {
        return this.maxX;
    }

    int getMaxY() {
        return this.maxY;
    }

    int getMinX() {
        return this.minX;
    }

    int getMinY() {
        return this.minY;
    }

    com.dcloud.zxing2.ResultPoint getTopLeft() {
        return this.topLeft;
    }

    com.dcloud.zxing2.ResultPoint getTopRight() {
        return this.topRight;
    }

    BoundingBox(com.dcloud.zxing2.pdf417.decoder.BoundingBox boundingBox) {
        init(boundingBox.image, boundingBox.topLeft, boundingBox.bottomLeft, boundingBox.topRight, boundingBox.bottomRight);
    }
}
