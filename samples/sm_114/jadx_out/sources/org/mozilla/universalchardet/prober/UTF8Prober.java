package org.mozilla.universalchardet.prober;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class UTF8Prober extends org.mozilla.universalchardet.prober.CharsetProber {
    public static final float ONE_CHAR_PROB = 0.5f;
    private static final org.mozilla.universalchardet.prober.statemachine.SMModel smModel = new org.mozilla.universalchardet.prober.statemachine.UTF8SMModel();
    private org.mozilla.universalchardet.prober.CharsetProber.ProbingState state;
    private int numOfMBChar = 0;
    private org.mozilla.universalchardet.prober.statemachine.CodingStateMachine codingSM = new org.mozilla.universalchardet.prober.statemachine.CodingStateMachine(smModel);

    public UTF8Prober() {
        reset();
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public java.lang.String getCharSetName() {
        return org.mozilla.universalchardet.Constants.CHARSET_UTF_8;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public float getConfidence() {
        float f = 0.99f;
        if (this.numOfMBChar >= 6) {
            return 0.99f;
        }
        for (int i = 0; i < this.numOfMBChar; i++) {
            f *= 0.5f;
        }
        return 1.0f - f;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public org.mozilla.universalchardet.prober.CharsetProber.ProbingState getState() {
        return this.state;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public org.mozilla.universalchardet.prober.CharsetProber.ProbingState handleData(byte[] bArr, int i, int i2) {
        int i3 = i2 + i;
        while (i < i3) {
            int iNextState = this.codingSM.nextState(bArr[i]);
            if (iNextState == 1) {
                this.state = org.mozilla.universalchardet.prober.CharsetProber.ProbingState.NOT_ME;
                break;
            }
            if (iNextState == 2) {
                this.state = org.mozilla.universalchardet.prober.CharsetProber.ProbingState.FOUND_IT;
                break;
            }
            if (iNextState == 0 && this.codingSM.getCurrentCharLen() >= 2) {
                this.numOfMBChar++;
            }
            i++;
        }
        if (this.state == org.mozilla.universalchardet.prober.CharsetProber.ProbingState.DETECTING && getConfidence() > 0.95f) {
            this.state = org.mozilla.universalchardet.prober.CharsetProber.ProbingState.FOUND_IT;
        }
        return this.state;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public void reset() {
        this.codingSM.reset();
        this.numOfMBChar = 0;
        this.state = org.mozilla.universalchardet.prober.CharsetProber.ProbingState.DETECTING;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public void setOption() {
    }
}
