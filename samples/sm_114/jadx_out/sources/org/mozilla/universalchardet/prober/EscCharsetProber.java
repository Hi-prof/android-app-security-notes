package org.mozilla.universalchardet.prober;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class EscCharsetProber extends org.mozilla.universalchardet.prober.CharsetProber {
    private static final org.mozilla.universalchardet.prober.statemachine.HZSMModel hzsModel = new org.mozilla.universalchardet.prober.statemachine.HZSMModel();
    private static final org.mozilla.universalchardet.prober.statemachine.ISO2022CNSMModel iso2022cnModel = new org.mozilla.universalchardet.prober.statemachine.ISO2022CNSMModel();
    private static final org.mozilla.universalchardet.prober.statemachine.ISO2022JPSMModel iso2022jpModel = new org.mozilla.universalchardet.prober.statemachine.ISO2022JPSMModel();
    private static final org.mozilla.universalchardet.prober.statemachine.ISO2022KRSMModel iso2022krModel = new org.mozilla.universalchardet.prober.statemachine.ISO2022KRSMModel();
    private int activeSM;
    private org.mozilla.universalchardet.prober.statemachine.CodingStateMachine[] codingSM;
    private java.lang.String detectedCharset;
    private org.mozilla.universalchardet.prober.CharsetProber.ProbingState state;

    public EscCharsetProber() {
        org.mozilla.universalchardet.prober.statemachine.CodingStateMachine[] codingStateMachineArr = new org.mozilla.universalchardet.prober.statemachine.CodingStateMachine[4];
        this.codingSM = codingStateMachineArr;
        codingStateMachineArr[0] = new org.mozilla.universalchardet.prober.statemachine.CodingStateMachine(hzsModel);
        this.codingSM[1] = new org.mozilla.universalchardet.prober.statemachine.CodingStateMachine(iso2022cnModel);
        this.codingSM[2] = new org.mozilla.universalchardet.prober.statemachine.CodingStateMachine(iso2022jpModel);
        this.codingSM[3] = new org.mozilla.universalchardet.prober.statemachine.CodingStateMachine(iso2022krModel);
        reset();
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public java.lang.String getCharSetName() {
        return this.detectedCharset;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public float getConfidence() {
        return 0.99f;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public org.mozilla.universalchardet.prober.CharsetProber.ProbingState getState() {
        return this.state;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public org.mozilla.universalchardet.prober.CharsetProber.ProbingState handleData(byte[] bArr, int i, int i2) {
        int i3 = i2 + i;
        while (i < i3 && this.state == org.mozilla.universalchardet.prober.CharsetProber.ProbingState.DETECTING) {
            for (int i4 = this.activeSM - 1; i4 >= 0; i4--) {
                int iNextState = this.codingSM[i4].nextState(bArr[i]);
                if (iNextState == 1) {
                    int i5 = this.activeSM - 1;
                    this.activeSM = i5;
                    if (i5 <= 0) {
                        org.mozilla.universalchardet.prober.CharsetProber.ProbingState probingState = org.mozilla.universalchardet.prober.CharsetProber.ProbingState.NOT_ME;
                        this.state = probingState;
                        return probingState;
                    }
                    if (i4 != i5) {
                        org.mozilla.universalchardet.prober.statemachine.CodingStateMachine[] codingStateMachineArr = this.codingSM;
                        org.mozilla.universalchardet.prober.statemachine.CodingStateMachine codingStateMachine = codingStateMachineArr[i5];
                        codingStateMachineArr[i5] = codingStateMachineArr[i4];
                        codingStateMachineArr[i4] = codingStateMachine;
                    }
                } else if (iNextState == 2) {
                    this.state = org.mozilla.universalchardet.prober.CharsetProber.ProbingState.FOUND_IT;
                    this.detectedCharset = this.codingSM[i4].getCodingStateMachine();
                    return this.state;
                }
            }
            i++;
        }
        return this.state;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public void reset() {
        this.state = org.mozilla.universalchardet.prober.CharsetProber.ProbingState.DETECTING;
        int i = 0;
        while (true) {
            org.mozilla.universalchardet.prober.statemachine.CodingStateMachine[] codingStateMachineArr = this.codingSM;
            if (i >= codingStateMachineArr.length) {
                this.activeSM = codingStateMachineArr.length;
                this.detectedCharset = null;
                return;
            } else {
                codingStateMachineArr[i].reset();
                i++;
            }
        }
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public void setOption() {
    }
}
