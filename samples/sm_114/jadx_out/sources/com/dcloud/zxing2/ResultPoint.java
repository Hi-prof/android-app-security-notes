package com.dcloud.zxing2;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class ResultPoint {
    private final float x;
    private final float y;

    public ResultPoint(float f, float f2) {
        this.x = f;
        this.y = f2;
    }

    private static float crossProductZ(com.dcloud.zxing2.ResultPoint resultPoint, com.dcloud.zxing2.ResultPoint resultPoint2, com.dcloud.zxing2.ResultPoint resultPoint3) {
        float f = resultPoint2.x;
        float f2 = resultPoint2.y;
        return ((resultPoint3.x - f) * (resultPoint.y - f2)) - ((resultPoint3.y - f2) * (resultPoint.x - f));
    }

    public static float distance(com.dcloud.zxing2.ResultPoint resultPoint, com.dcloud.zxing2.ResultPoint resultPoint2) {
        return com.dcloud.zxing2.common.detector.MathUtils.distance(resultPoint.x, resultPoint.y, resultPoint2.x, resultPoint2.y);
    }

    public static void orderBestPatterns(com.dcloud.zxing2.ResultPoint[] resultPointArr) {
        com.dcloud.zxing2.ResultPoint resultPoint;
        com.dcloud.zxing2.ResultPoint resultPoint2;
        com.dcloud.zxing2.ResultPoint resultPoint3;
        float fDistance = distance(resultPointArr[0], resultPointArr[1]);
        float fDistance2 = distance(resultPointArr[1], resultPointArr[2]);
        float fDistance3 = distance(resultPointArr[0], resultPointArr[2]);
        if (fDistance2 >= fDistance && fDistance2 >= fDistance3) {
            resultPoint = resultPointArr[0];
            resultPoint2 = resultPointArr[1];
            resultPoint3 = resultPointArr[2];
        } else if (fDistance3 < fDistance2 || fDistance3 < fDistance) {
            resultPoint = resultPointArr[2];
            resultPoint2 = resultPointArr[0];
            resultPoint3 = resultPointArr[1];
        } else {
            resultPoint = resultPointArr[1];
            resultPoint2 = resultPointArr[0];
            resultPoint3 = resultPointArr[2];
        }
        if (crossProductZ(resultPoint2, resultPoint, resultPoint3) < 0.0f) {
            com.dcloud.zxing2.ResultPoint resultPoint4 = resultPoint3;
            resultPoint3 = resultPoint2;
            resultPoint2 = resultPoint4;
        }
        resultPointArr[0] = resultPoint2;
        resultPointArr[1] = resultPoint;
        resultPointArr[2] = resultPoint3;
    }

    public final boolean equals(java.lang.Object obj) {
        if (obj instanceof com.dcloud.zxing2.ResultPoint) {
            com.dcloud.zxing2.ResultPoint resultPoint = (com.dcloud.zxing2.ResultPoint) obj;
            if (this.x == resultPoint.x && this.y == resultPoint.y) {
                return true;
            }
        }
        return false;
    }

    public final float getX() {
        return this.x;
    }

    public final float getY() {
        return this.y;
    }

    public final int hashCode() {
        return (java.lang.Float.floatToIntBits(this.x) * 31) + java.lang.Float.floatToIntBits(this.y);
    }

    public final java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(25);
        sb.append(com.taobao.weex.el.parse.Operators.BRACKET_START);
        sb.append(this.x);
        sb.append(com.taobao.weex.el.parse.Operators.ARRAY_SEPRATOR);
        sb.append(this.y);
        sb.append(com.taobao.weex.el.parse.Operators.BRACKET_END);
        return sb.toString();
    }
}
