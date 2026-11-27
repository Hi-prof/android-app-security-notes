package com.dcloud.zxing2;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class Dimension {
    private final int height;
    private final int width;

    public Dimension(int i, int i2) {
        if (i < 0 || i2 < 0) {
            throw new java.lang.IllegalArgumentException();
        }
        this.width = i;
        this.height = i2;
    }

    public boolean equals(java.lang.Object obj) {
        if (obj instanceof com.dcloud.zxing2.Dimension) {
            com.dcloud.zxing2.Dimension dimension = (com.dcloud.zxing2.Dimension) obj;
            if (this.width == dimension.width && this.height == dimension.height) {
                return true;
            }
        }
        return false;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public int hashCode() {
        return (this.width * 32713) + this.height;
    }

    public java.lang.String toString() {
        return this.width + com.taobao.weex.common.Constants.Name.X + this.height;
    }
}
