package com.nostra13.dcloudimageloader.core.assist;

/* JADX INFO: loaded from: classes.dex */
public class ImageSize {
    private static final java.lang.String SEPARATOR = "x";
    private static final int TO_STRING_MAX_LENGHT = 9;
    private final int height;
    private final int width;

    public ImageSize(int i, int i2) {
        this.width = i;
        this.height = i2;
    }

    public ImageSize(int i, int i2, int i3) {
        if (i3 % 180 == 0) {
            this.width = i;
            this.height = i2;
        } else {
            this.width = i2;
            this.height = i;
        }
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public com.nostra13.dcloudimageloader.core.assist.ImageSize scaleDown(int i) {
        return new com.nostra13.dcloudimageloader.core.assist.ImageSize(this.width / i, this.height / i);
    }

    public com.nostra13.dcloudimageloader.core.assist.ImageSize scale(float f) {
        return new com.nostra13.dcloudimageloader.core.assist.ImageSize((int) (this.width * f), (int) (this.height * f));
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(9);
        sb.append(this.width);
        sb.append("x");
        sb.append(this.height);
        return sb.toString();
    }
}
