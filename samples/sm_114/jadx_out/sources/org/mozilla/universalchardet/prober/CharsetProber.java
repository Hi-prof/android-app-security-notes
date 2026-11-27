package org.mozilla.universalchardet.prober;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public abstract class CharsetProber {
    public static final int ASCII_A = 97;
    public static final int ASCII_A_CAPITAL = 65;
    public static final int ASCII_GT = 62;
    public static final int ASCII_LT = 60;
    public static final int ASCII_SP = 32;
    public static final int ASCII_Z = 122;
    public static final int ASCII_Z_CAPITAL = 90;
    public static final float SHORTCUT_THRESHOLD = 0.95f;
    private boolean active = true;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public enum ProbingState {
        DETECTING,
        FOUND_IT,
        NOT_ME
    }

    private boolean isAscii(byte b) {
        return (b & kotlin.jvm.internal.ByteCompanionObject.MIN_VALUE) == 0;
    }

    private boolean isAsciiSymbol(byte b) {
        int i = b & 255;
        if (i >= 65) {
            return (i > 90 && i < 97) || i > 122;
        }
        return true;
    }

    public java.nio.ByteBuffer filterWithEnglishLetters(byte[] bArr, int i, int i2) {
        java.nio.ByteBuffer byteBufferAllocate = java.nio.ByteBuffer.allocate(i2);
        int i3 = i2 + i;
        int i4 = i;
        boolean z = false;
        while (i < i3) {
            byte b = bArr[i];
            if (b == 62) {
                z = false;
            } else if (b == 60) {
                z = true;
            }
            if (isAscii(b) && isAsciiSymbol(b)) {
                if (i > i4 && !z) {
                    byteBufferAllocate.put(bArr, i4, i - i4);
                    byteBufferAllocate.put(org.mozilla.universalchardet.prober.HebrewProber.SPACE);
                }
                i4 = i + 1;
            }
            i++;
        }
        if (!z && i > i4) {
            byteBufferAllocate.put(bArr, i4, i - i4);
        }
        return byteBufferAllocate;
    }

    public java.nio.ByteBuffer filterWithoutEnglishLetters(byte[] bArr, int i, int i2) {
        java.nio.ByteBuffer byteBufferAllocate = java.nio.ByteBuffer.allocate(i2);
        int i3 = i2 + i;
        int i4 = i;
        boolean z = false;
        while (i < i3) {
            byte b = bArr[i];
            if (!isAscii(b)) {
                z = true;
            } else if (isAsciiSymbol(b)) {
                if (!z || i <= i4) {
                    i4 = i + 1;
                } else {
                    byteBufferAllocate.put(bArr, i4, i - i4);
                    byteBufferAllocate.put(org.mozilla.universalchardet.prober.HebrewProber.SPACE);
                    i4 = i + 1;
                    z = false;
                }
            }
            i++;
        }
        if (z && i > i4) {
            byteBufferAllocate.put(bArr, i4, i - i4);
        }
        return byteBufferAllocate;
    }

    public abstract java.lang.String getCharSetName();

    public abstract float getConfidence();

    public abstract org.mozilla.universalchardet.prober.CharsetProber.ProbingState getState();

    public abstract org.mozilla.universalchardet.prober.CharsetProber.ProbingState handleData(byte[] bArr, int i, int i2);

    public boolean isActive() {
        return this.active;
    }

    public abstract void reset();

    public void setActive(boolean z) {
        this.active = z;
    }

    public abstract void setOption();
}
