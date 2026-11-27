package com.alibaba.fastjson.util;

/* JADX INFO: loaded from: classes.dex */
public class UTF8Decoder extends java.nio.charset.CharsetDecoder {
    private static final java.nio.charset.Charset charset = java.nio.charset.Charset.forName("UTF-8");

    private static boolean isMalformed2(int i, int i2) {
        return (i & 30) == 0 || (i2 & 192) != 128;
    }

    private static boolean isMalformed3(int i, int i2, int i3) {
        return ((i != -32 || (i2 & 224) != 128) && (i2 & 192) == 128 && (i3 & 192) == 128) ? false : true;
    }

    private static boolean isMalformed4(int i, int i2, int i3) {
        return ((i & 192) == 128 && (i2 & 192) == 128 && (i3 & 192) == 128) ? false : true;
    }

    private static boolean isNotContinuation(int i) {
        return (i & 192) != 128;
    }

    public UTF8Decoder() {
        super(charset, 1.0f, 1.0f);
    }

    private static java.nio.charset.CoderResult lookupN(java.nio.ByteBuffer byteBuffer, int i) {
        for (int i2 = 1; i2 < i; i2++) {
            if (isNotContinuation(byteBuffer.get())) {
                return java.nio.charset.CoderResult.malformedForLength(i2);
            }
        }
        return java.nio.charset.CoderResult.malformedForLength(i);
    }

    public static java.nio.charset.CoderResult malformedN(java.nio.ByteBuffer byteBuffer, int i) {
        int i2 = 1;
        if (i == 1) {
            byte b = byteBuffer.get();
            if ((b >> 2) == -2) {
                return byteBuffer.remaining() < 4 ? java.nio.charset.CoderResult.UNDERFLOW : lookupN(byteBuffer, 5);
            }
            if ((b >> 1) == -2) {
                if (byteBuffer.remaining() < 5) {
                    return java.nio.charset.CoderResult.UNDERFLOW;
                }
                return lookupN(byteBuffer, 6);
            }
            return java.nio.charset.CoderResult.malformedForLength(1);
        }
        if (i == 2) {
            return java.nio.charset.CoderResult.malformedForLength(1);
        }
        if (i == 3) {
            byte b2 = byteBuffer.get();
            byte b3 = byteBuffer.get();
            if ((b2 != -32 || (b3 & 224) != 128) && !isNotContinuation(b3)) {
                i2 = 2;
            }
            return java.nio.charset.CoderResult.malformedForLength(i2);
        }
        if (i == 4) {
            int i3 = byteBuffer.get() & 255;
            byte b4 = byteBuffer.get();
            int i4 = b4 & 255;
            if (i3 > 244 || ((i3 == 240 && (i4 < 144 || i4 > 191)) || ((i3 == 244 && (b4 & 240) != 128) || isNotContinuation(i4)))) {
                return java.nio.charset.CoderResult.malformedForLength(1);
            }
            return isNotContinuation(byteBuffer.get()) ? java.nio.charset.CoderResult.malformedForLength(2) : java.nio.charset.CoderResult.malformedForLength(3);
        }
        throw new java.lang.IllegalStateException();
    }

    private static java.nio.charset.CoderResult malformed(java.nio.ByteBuffer byteBuffer, int i, java.nio.CharBuffer charBuffer, int i2, int i3) {
        byteBuffer.position(i - byteBuffer.arrayOffset());
        java.nio.charset.CoderResult coderResultMalformedN = malformedN(byteBuffer, i3);
        byteBuffer.position(i);
        charBuffer.position(i2);
        return coderResultMalformedN;
    }

    private static java.nio.charset.CoderResult xflow(java.nio.Buffer buffer, int i, int i2, java.nio.Buffer buffer2, int i3, int i4) {
        buffer.position(i);
        buffer2.position(i3);
        return (i4 == 0 || i2 - i < i4) ? java.nio.charset.CoderResult.UNDERFLOW : java.nio.charset.CoderResult.OVERFLOW;
    }

    private java.nio.charset.CoderResult decodeArrayLoop(java.nio.ByteBuffer byteBuffer, java.nio.CharBuffer charBuffer) {
        java.nio.ByteBuffer byteBuffer2;
        int i;
        java.nio.CharBuffer charBuffer2;
        int i2;
        byte[] bArrArray = byteBuffer.array();
        int iArrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
        int iArrayOffset2 = byteBuffer.arrayOffset() + byteBuffer.limit();
        char[] cArrArray = charBuffer.array();
        int iArrayOffset3 = charBuffer.arrayOffset() + charBuffer.position();
        int iArrayOffset4 = charBuffer.arrayOffset() + charBuffer.limit();
        int iMin = java.lang.Math.min(iArrayOffset2 - iArrayOffset, iArrayOffset4 - iArrayOffset3) + iArrayOffset3;
        while (iArrayOffset3 < iMin) {
            byte b = bArrArray[iArrayOffset];
            if (b < 0) {
                break;
            }
            iArrayOffset++;
            cArrArray[iArrayOffset3] = (char) b;
            iArrayOffset3++;
        }
        int i3 = iArrayOffset;
        int i4 = iArrayOffset3;
        while (i3 < iArrayOffset2) {
            byte b2 = bArrArray[i3];
            if (b2 < 0) {
                int i5 = iArrayOffset4;
                byteBuffer2 = byteBuffer;
                i = i5;
                charBuffer2 = charBuffer;
                if ((b2 >> 5) == -2) {
                    if (iArrayOffset2 - i3 < 2 || i4 >= i) {
                        return xflow(byteBuffer2, i3, iArrayOffset2, charBuffer2, i4, 2);
                    }
                    byte b3 = bArrArray[i3 + 1];
                    if (isMalformed2(b2, b3)) {
                        return malformed(byteBuffer2, i3, charBuffer2, i4, 2);
                    }
                    i2 = i4 + 1;
                    cArrArray[i4] = (char) ((b3 ^ (b2 << 6)) ^ 3968);
                    i3 += 2;
                } else if ((b2 >> 4) == -2) {
                    if (iArrayOffset2 - i3 < 3 || i4 >= i) {
                        return xflow(byteBuffer2, i3, iArrayOffset2, charBuffer2, i4, 3);
                    }
                    byte b4 = bArrArray[i3 + 1];
                    byte b5 = bArrArray[i3 + 2];
                    if (isMalformed3(b2, b4, b5)) {
                        return malformed(byteBuffer2, i3, charBuffer2, i4, 3);
                    }
                    i2 = i4 + 1;
                    cArrArray[i4] = (char) ((((b4 << 6) ^ (b2 << 12)) ^ b5) ^ 8064);
                    i3 += 3;
                } else {
                    if ((b2 >> 3) != -2) {
                        return malformed(byteBuffer2, i3, charBuffer2, i4, 1);
                    }
                    if (iArrayOffset2 - i3 < 4 || i - i4 < 2) {
                        return xflow(byteBuffer2, i3, iArrayOffset2, charBuffer2, i4, 4);
                    }
                    byte b6 = bArrArray[i3 + 1];
                    byte b7 = bArrArray[i3 + 2];
                    byte b8 = bArrArray[i3 + 3];
                    int i6 = ((b2 & 7) << 18) | ((b6 & 63) << 12) | ((b7 & 63) << 6) | (b8 & 63);
                    if (isMalformed4(b6, b7, b8) || i6 < 65536 || i6 > 1114111) {
                        return malformed(byteBuffer2, i3, charBuffer2, i4, 4);
                    }
                    int i7 = i4 + 1;
                    int i8 = i6 - 65536;
                    cArrArray[i4] = (char) (((i8 >> 10) & 1023) | 55296);
                    i4 += 2;
                    cArrArray[i7] = (char) (56320 | (i8 & 1023));
                    i3 += 4;
                }
                i4 = i2;
            } else {
                if (i4 >= iArrayOffset4) {
                    return xflow(byteBuffer, i3, iArrayOffset2, charBuffer, i4, 1);
                }
                int i9 = iArrayOffset4;
                byteBuffer2 = byteBuffer;
                i = i9;
                charBuffer2 = charBuffer;
                cArrArray[i4] = (char) b2;
                i3++;
                i4++;
            }
            java.nio.ByteBuffer byteBuffer3 = byteBuffer2;
            iArrayOffset4 = i;
            byteBuffer = byteBuffer3;
            charBuffer = charBuffer2;
        }
        return xflow(byteBuffer, i3, iArrayOffset2, charBuffer, i4, 0);
    }

    @Override // java.nio.charset.CharsetDecoder
    protected java.nio.charset.CoderResult decodeLoop(java.nio.ByteBuffer byteBuffer, java.nio.CharBuffer charBuffer) {
        return decodeArrayLoop(byteBuffer, charBuffer);
    }
}
