package com.dcloud.zxing2.common;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class BitMatrix implements java.lang.Cloneable {
    private final int[] bits;
    private final int height;
    private final int rowSize;
    private final int width;

    public BitMatrix(int i) {
        this(i, i);
    }

    public static com.dcloud.zxing2.common.BitMatrix parse(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (str == null) {
            throw new java.lang.IllegalArgumentException();
        }
        boolean[] zArr = new boolean[str.length()];
        int length = 0;
        int i = 0;
        int i2 = 0;
        int i3 = -1;
        int i4 = 0;
        while (length < str.length()) {
            if (str.charAt(length) == '\n' || str.charAt(length) == '\r') {
                if (i > i2) {
                    if (i3 == -1) {
                        i3 = i - i2;
                    } else if (i - i2 != i3) {
                        throw new java.lang.IllegalArgumentException("row lengths do not match");
                    }
                    i4++;
                    i2 = i;
                }
                length++;
            } else {
                if (str.substring(length, str2.length() + length).equals(str2)) {
                    length += str2.length();
                    zArr[i] = true;
                } else {
                    if (!str.substring(length, str3.length() + length).equals(str3)) {
                        throw new java.lang.IllegalArgumentException("illegal character encountered: " + str.substring(length));
                    }
                    length += str3.length();
                    zArr[i] = false;
                }
                i++;
            }
        }
        if (i > i2) {
            int i5 = i - i2;
            if (i3 == -1) {
                i3 = i5;
            } else if (i5 != i3) {
                throw new java.lang.IllegalArgumentException("row lengths do not match");
            }
            i4++;
        }
        com.dcloud.zxing2.common.BitMatrix bitMatrix = new com.dcloud.zxing2.common.BitMatrix(i3, i4);
        for (int i6 = 0; i6 < i; i6++) {
            if (zArr[i6]) {
                bitMatrix.set(i6 % i3, i6 / i3);
            }
        }
        return bitMatrix;
    }

    public void clear() {
        int length = this.bits.length;
        for (int i = 0; i < length; i++) {
            this.bits[i] = 0;
        }
    }

    public boolean equals(java.lang.Object obj) {
        if (!(obj instanceof com.dcloud.zxing2.common.BitMatrix)) {
            return false;
        }
        com.dcloud.zxing2.common.BitMatrix bitMatrix = (com.dcloud.zxing2.common.BitMatrix) obj;
        return this.width == bitMatrix.width && this.height == bitMatrix.height && this.rowSize == bitMatrix.rowSize && java.util.Arrays.equals(this.bits, bitMatrix.bits);
    }

    public void flip(int i, int i2) {
        int i3 = (i2 * this.rowSize) + (i / 32);
        int[] iArr = this.bits;
        iArr[i3] = (1 << (i & 31)) ^ iArr[i3];
    }

    public boolean get(int i, int i2) {
        return ((this.bits[(i2 * this.rowSize) + (i / 32)] >>> (i & 31)) & 1) != 0;
    }

    public int[] getBottomRightOnBit() {
        int length = this.bits.length - 1;
        while (length >= 0 && this.bits[length] == 0) {
            length--;
        }
        if (length < 0) {
            return null;
        }
        int i = this.rowSize;
        int i2 = length / i;
        int i3 = (length % i) * 32;
        int i4 = 31;
        while ((this.bits[length] >>> i4) == 0) {
            i4--;
        }
        return new int[]{i3 + i4, i2};
    }

    public int[] getEnclosingRectangle() {
        int i = this.width;
        int i2 = this.height;
        int i3 = -1;
        int i4 = -1;
        for (int i5 = 0; i5 < this.height; i5++) {
            int i6 = 0;
            while (true) {
                int i7 = this.rowSize;
                if (i6 < i7) {
                    int i8 = this.bits[(i7 * i5) + i6];
                    if (i8 != 0) {
                        if (i5 < i2) {
                            i2 = i5;
                        }
                        if (i5 > i4) {
                            i4 = i5;
                        }
                        int i9 = i6 * 32;
                        if (i9 < i) {
                            int i10 = 0;
                            while ((i8 << (31 - i10)) == 0) {
                                i10++;
                            }
                            int i11 = i10 + i9;
                            if (i11 < i) {
                                i = i11;
                            }
                        }
                        if (i9 + 31 > i3) {
                            int i12 = 31;
                            while ((i8 >>> i12) == 0) {
                                i12--;
                            }
                            int i13 = i9 + i12;
                            if (i13 > i3) {
                                i3 = i13;
                            }
                        }
                    }
                    i6++;
                }
            }
        }
        int i14 = i3 - i;
        int i15 = i4 - i2;
        if (i14 < 0 || i15 < 0) {
            return null;
        }
        return new int[]{i, i2, i14, i15};
    }

    public int getHeight() {
        return this.height;
    }

    public com.dcloud.zxing2.common.BitArray getRow(int i, com.dcloud.zxing2.common.BitArray bitArray) {
        if (bitArray == null || bitArray.getSize() < this.width) {
            bitArray = new com.dcloud.zxing2.common.BitArray(this.width);
        } else {
            bitArray.clear();
        }
        int i2 = i * this.rowSize;
        for (int i3 = 0; i3 < this.rowSize; i3++) {
            bitArray.setBulk(i3 * 32, this.bits[i2 + i3]);
        }
        return bitArray;
    }

    public int getRowSize() {
        return this.rowSize;
    }

    public int[] getTopLeftOnBit() {
        int[] iArr;
        int i = 0;
        int i2 = 0;
        while (true) {
            iArr = this.bits;
            if (i2 >= iArr.length || iArr[i2] != 0) {
                break;
            }
            i2++;
        }
        if (i2 == iArr.length) {
            return null;
        }
        int i3 = this.rowSize;
        int i4 = i2 / i3;
        int i5 = (i2 % i3) * 32;
        while ((iArr[i2] << (31 - i)) == 0) {
            i++;
        }
        return new int[]{i5 + i, i4};
    }

    public int getWidth() {
        return this.width;
    }

    public int hashCode() {
        int i = this.width;
        return (((((((i * 31) + i) * 31) + this.height) * 31) + this.rowSize) * 31) + java.util.Arrays.hashCode(this.bits);
    }

    public void rotate180() {
        int width = getWidth();
        int height = getHeight();
        com.dcloud.zxing2.common.BitArray bitArray = new com.dcloud.zxing2.common.BitArray(width);
        com.dcloud.zxing2.common.BitArray bitArray2 = new com.dcloud.zxing2.common.BitArray(width);
        for (int i = 0; i < (height + 1) / 2; i++) {
            bitArray = getRow(i, bitArray);
            int i2 = (height - 1) - i;
            bitArray2 = getRow(i2, bitArray2);
            bitArray.reverse();
            bitArray2.reverse();
            setRow(i, bitArray2);
            setRow(i2, bitArray);
        }
    }

    public com.dcloud.zxing2.common.BitMatrix rotate90() {
        com.dcloud.zxing2.common.BitMatrix bitMatrix = new com.dcloud.zxing2.common.BitMatrix(getHeight(), getWidth());
        if (this.width <= 0 || this.height <= 0) {
            return this;
        }
        for (int i = 0; i < this.width; i++) {
            com.dcloud.zxing2.common.BitArray bitArray = new com.dcloud.zxing2.common.BitArray(this.height);
            for (int i2 = 0; i2 < this.height; i2++) {
                if (get(i, i2)) {
                    bitArray.set(i2);
                }
            }
            bitMatrix.setRow((this.width - i) - 1, bitArray);
        }
        return bitMatrix;
    }

    public void set(int i, int i2) {
        int i3 = (i2 * this.rowSize) + (i / 32);
        int[] iArr = this.bits;
        iArr[i3] = (1 << (i & 31)) | iArr[i3];
    }

    public void setRegion(int i, int i2, int i3, int i4) {
        if (i2 < 0 || i < 0) {
            throw new java.lang.IllegalArgumentException("Left and top must be nonnegative");
        }
        if (i4 < 1 || i3 < 1) {
            throw new java.lang.IllegalArgumentException("Height and width must be at least 1");
        }
        int i5 = i3 + i;
        int i6 = i4 + i2;
        if (i6 > this.height || i5 > this.width) {
            throw new java.lang.IllegalArgumentException("The region must fit inside the matrix");
        }
        while (i2 < i6) {
            int i7 = this.rowSize * i2;
            for (int i8 = i; i8 < i5; i8++) {
                int[] iArr = this.bits;
                int i9 = (i8 / 32) + i7;
                iArr[i9] = iArr[i9] | (1 << (i8 & 31));
            }
            i2++;
        }
    }

    public void setRow(int i, com.dcloud.zxing2.common.BitArray bitArray) {
        int[] bitArray2 = bitArray.getBitArray();
        int[] iArr = this.bits;
        int i2 = this.rowSize;
        java.lang.System.arraycopy(bitArray2, 0, iArr, i * i2, i2);
    }

    public java.lang.String toString() {
        return toString("X ", "  ");
    }

    public void unset(int i, int i2) {
        int i3 = (i2 * this.rowSize) + (i / 32);
        int[] iArr = this.bits;
        iArr[i3] = (~(1 << (i & 31))) & iArr[i3];
    }

    public void xor(com.dcloud.zxing2.common.BitMatrix bitMatrix) {
        if (this.width != bitMatrix.getWidth() || this.height != bitMatrix.getHeight() || this.rowSize != bitMatrix.getRowSize()) {
            throw new java.lang.IllegalArgumentException("input matrix dimensions do not match");
        }
        com.dcloud.zxing2.common.BitArray bitArray = new com.dcloud.zxing2.common.BitArray((this.width / 32) + 1);
        for (int i = 0; i < this.height; i++) {
            int i2 = this.rowSize * i;
            int[] bitArray2 = bitMatrix.getRow(i, bitArray).getBitArray();
            for (int i3 = 0; i3 < this.rowSize; i3++) {
                int[] iArr = this.bits;
                int i4 = i2 + i3;
                iArr[i4] = iArr[i4] ^ bitArray2[i3];
            }
        }
    }

    public BitMatrix(int i, int i2) {
        if (i < 1 || i2 < 1) {
            throw new java.lang.IllegalArgumentException("Both dimensions must be greater than 0");
        }
        this.width = i;
        this.height = i2;
        int i3 = (i + 31) / 32;
        this.rowSize = i3;
        this.bits = new int[i3 * i2];
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public com.dcloud.zxing2.common.BitMatrix m209clone() {
        return new com.dcloud.zxing2.common.BitMatrix(this.width, this.height, this.rowSize, (int[]) this.bits.clone());
    }

    public java.lang.String toString(java.lang.String str, java.lang.String str2) {
        return toString(str, str2, "\n");
    }

    @java.lang.Deprecated
    public java.lang.String toString(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(this.height * (this.width + 1));
        for (int i = 0; i < this.height; i++) {
            for (int i2 = 0; i2 < this.width; i2++) {
                sb.append(get(i2, i) ? str : str2);
            }
            sb.append(str3);
        }
        return sb.toString();
    }

    private BitMatrix(int i, int i2, int i3, int[] iArr) {
        this.width = i;
        this.height = i2;
        this.rowSize = i3;
        this.bits = iArr;
    }
}
