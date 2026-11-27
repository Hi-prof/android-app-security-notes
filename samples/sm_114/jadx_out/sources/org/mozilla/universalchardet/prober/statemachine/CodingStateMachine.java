package org.mozilla.universalchardet.prober.statemachine;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class CodingStateMachine {
    protected int currentBytePos;
    protected int currentCharLen;
    protected int currentState = 0;
    protected org.mozilla.universalchardet.prober.statemachine.SMModel model;

    public CodingStateMachine(org.mozilla.universalchardet.prober.statemachine.SMModel sMModel) {
        this.model = sMModel;
    }

    public java.lang.String getCodingStateMachine() {
        return this.model.getName();
    }

    public int getCurrentCharLen() {
        return this.currentCharLen;
    }

    public int nextState(byte b) {
        int i = this.model.getClass(b);
        if (this.currentState == 0) {
            this.currentBytePos = 0;
            this.currentCharLen = this.model.getCharLen(i);
        }
        int nextState = this.model.getNextState(i, this.currentState);
        this.currentState = nextState;
        this.currentBytePos++;
        return nextState;
    }

    public void reset() {
        this.currentState = 0;
    }
}
