package org.mozilla.universalchardet.prober;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class HebrewProber extends org.mozilla.universalchardet.prober.CharsetProber {
    public static final int FINAL_KAF = 234;
    public static final int FINAL_MEM = 237;
    public static final int FINAL_NUN = 239;
    public static final int FINAL_PE = 243;
    public static final int FINAL_TSADI = 245;
    public static final int MIN_FINAL_CHAR_DISTANCE = 5;
    public static final float MIN_MODEL_DISTANCE = 0.01f;
    public static final int NORMAL_KAF = 235;
    public static final int NORMAL_MEM = 238;
    public static final int NORMAL_NUN = 240;
    public static final int NORMAL_PE = 244;
    public static final int NORMAL_TSADI = 246;
    public static final byte SPACE = 32;
    private byte beforePrev;
    private int finalCharLogicalScore;
    private int finalCharVisualScore;
    private byte prev;
    private org.mozilla.universalchardet.prober.CharsetProber logicalProber = null;
    private org.mozilla.universalchardet.prober.CharsetProber visualProber = null;

    public HebrewProber() {
        reset();
    }

    protected static boolean isFinal(byte b) {
        int i = b & 255;
        return i == 234 || i == 237 || i == 239 || i == 243 || i == 245;
    }

    protected static boolean isNonFinal(byte b) {
        int i = b & 255;
        return i == 235 || i == 238 || i == 240 || i == 244;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public java.lang.String getCharSetName() {
        int i = this.finalCharLogicalScore - this.finalCharVisualScore;
        if (i >= 5) {
            return org.mozilla.universalchardet.Constants.CHARSET_WINDOWS_1255;
        }
        if (i <= -5) {
            return org.mozilla.universalchardet.Constants.CHARSET_ISO_8859_8;
        }
        float confidence = this.logicalProber.getConfidence() - this.visualProber.getConfidence();
        if (confidence > 0.01f) {
            return org.mozilla.universalchardet.Constants.CHARSET_WINDOWS_1255;
        }
        if (confidence < -0.01f) {
            return org.mozilla.universalchardet.Constants.CHARSET_ISO_8859_8;
        }
        return i < 0 ? org.mozilla.universalchardet.Constants.CHARSET_ISO_8859_8 : org.mozilla.universalchardet.Constants.CHARSET_WINDOWS_1255;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public float getConfidence() {
        return 0.0f;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public org.mozilla.universalchardet.prober.CharsetProber.ProbingState getState() {
        org.mozilla.universalchardet.prober.CharsetProber.ProbingState state = this.logicalProber.getState();
        org.mozilla.universalchardet.prober.CharsetProber.ProbingState probingState = org.mozilla.universalchardet.prober.CharsetProber.ProbingState.NOT_ME;
        return (state == probingState && this.visualProber.getState() == probingState) ? probingState : org.mozilla.universalchardet.prober.CharsetProber.ProbingState.DETECTING;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public org.mozilla.universalchardet.prober.CharsetProber.ProbingState handleData(byte[] bArr, int i, int i2) {
        org.mozilla.universalchardet.prober.CharsetProber.ProbingState state = getState();
        org.mozilla.universalchardet.prober.CharsetProber.ProbingState probingState = org.mozilla.universalchardet.prober.CharsetProber.ProbingState.NOT_ME;
        if (state == probingState) {
            return probingState;
        }
        int i3 = i2 + i;
        while (i < i3) {
            byte b = bArr[i];
            if (b == 32) {
                if (this.beforePrev != 32) {
                    if (isFinal(this.prev)) {
                        this.finalCharLogicalScore++;
                    } else if (isNonFinal(this.prev)) {
                        this.finalCharVisualScore++;
                    }
                }
            } else if (this.beforePrev == 32 && isFinal(this.prev) && b != 32) {
                this.finalCharVisualScore++;
            }
            this.beforePrev = this.prev;
            this.prev = b;
            i++;
        }
        return org.mozilla.universalchardet.prober.CharsetProber.ProbingState.DETECTING;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public void reset() {
        this.finalCharLogicalScore = 0;
        this.finalCharVisualScore = 0;
        this.prev = SPACE;
        this.beforePrev = SPACE;
    }

    public void setModalProbers(org.mozilla.universalchardet.prober.CharsetProber charsetProber, org.mozilla.universalchardet.prober.CharsetProber charsetProber2) {
        this.logicalProber = charsetProber;
        this.visualProber = charsetProber2;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public void setOption() {
    }
}
