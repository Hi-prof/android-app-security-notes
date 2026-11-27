package org.mozilla.universalchardet.prober;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class EUCKRProber extends org.mozilla.universalchardet.prober.CharsetProber {
    private static final org.mozilla.universalchardet.prober.statemachine.SMModel smModel = new org.mozilla.universalchardet.prober.statemachine.EUCKRSMModel();
    private org.mozilla.universalchardet.prober.statemachine.CodingStateMachine codingSM = new org.mozilla.universalchardet.prober.statemachine.CodingStateMachine(smModel);
    private org.mozilla.universalchardet.prober.distributionanalysis.EUCKRDistributionAnalysis distributionAnalyzer = new org.mozilla.universalchardet.prober.distributionanalysis.EUCKRDistributionAnalysis();
    private byte[] lastChar = new byte[2];
    private org.mozilla.universalchardet.prober.CharsetProber.ProbingState state;

    public EUCKRProber() {
        reset();
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public java.lang.String getCharSetName() {
        return org.mozilla.universalchardet.Constants.CHARSET_EUC_KR;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public float getConfidence() {
        return this.distributionAnalyzer.getConfidence();
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public org.mozilla.universalchardet.prober.CharsetProber.ProbingState getState() {
        return this.state;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public org.mozilla.universalchardet.prober.CharsetProber.ProbingState handleData(byte[] bArr, int i, int i2) {
        int i3 = i2 + i;
        for (int i4 = i; i4 < i3; i4++) {
            int iNextState = this.codingSM.nextState(bArr[i4]);
            if (iNextState == 1) {
                this.state = org.mozilla.universalchardet.prober.CharsetProber.ProbingState.NOT_ME;
                break;
            }
            if (iNextState == 2) {
                this.state = org.mozilla.universalchardet.prober.CharsetProber.ProbingState.FOUND_IT;
                break;
            }
            if (iNextState == 0) {
                int currentCharLen = this.codingSM.getCurrentCharLen();
                if (i4 == i) {
                    byte[] bArr2 = this.lastChar;
                    bArr2[1] = bArr[i];
                    this.distributionAnalyzer.handleOneChar(bArr2, 0, currentCharLen);
                } else {
                    this.distributionAnalyzer.handleOneChar(bArr, i4 - 1, currentCharLen);
                }
            }
        }
        this.lastChar[0] = bArr[i3 - 1];
        if (this.state == org.mozilla.universalchardet.prober.CharsetProber.ProbingState.DETECTING && this.distributionAnalyzer.gotEnoughData() && getConfidence() > 0.95f) {
            this.state = org.mozilla.universalchardet.prober.CharsetProber.ProbingState.FOUND_IT;
        }
        return this.state;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public void reset() {
        this.codingSM.reset();
        this.state = org.mozilla.universalchardet.prober.CharsetProber.ProbingState.DETECTING;
        this.distributionAnalyzer.reset();
        java.util.Arrays.fill(this.lastChar, (byte) 0);
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public void setOption() {
    }
}
