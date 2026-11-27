package org.mozilla.universalchardet.prober;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class SBCSGroupProber extends org.mozilla.universalchardet.prober.CharsetProber {
    private int activeNum;
    private org.mozilla.universalchardet.prober.CharsetProber bestGuess;
    private java.util.List<org.mozilla.universalchardet.prober.CharsetProber> probers;
    private org.mozilla.universalchardet.prober.CharsetProber.ProbingState state;

    public SBCSGroupProber() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        this.probers = arrayList;
        arrayList.add(new org.mozilla.universalchardet.prober.SingleByteCharsetProber(new org.mozilla.universalchardet.prober.sequence.Win1251Model()));
        this.probers.add(new org.mozilla.universalchardet.prober.SingleByteCharsetProber(new org.mozilla.universalchardet.prober.sequence.Koi8rModel()));
        this.probers.add(new org.mozilla.universalchardet.prober.SingleByteCharsetProber(new org.mozilla.universalchardet.prober.sequence.Latin5Model()));
        this.probers.add(new org.mozilla.universalchardet.prober.SingleByteCharsetProber(new org.mozilla.universalchardet.prober.sequence.MacCyrillicModel()));
        this.probers.add(new org.mozilla.universalchardet.prober.SingleByteCharsetProber(new org.mozilla.universalchardet.prober.sequence.Ibm866Model()));
        this.probers.add(new org.mozilla.universalchardet.prober.SingleByteCharsetProber(new org.mozilla.universalchardet.prober.sequence.Ibm855Model()));
        this.probers.add(new org.mozilla.universalchardet.prober.SingleByteCharsetProber(new org.mozilla.universalchardet.prober.sequence.Latin7Model()));
        this.probers.add(new org.mozilla.universalchardet.prober.SingleByteCharsetProber(new org.mozilla.universalchardet.prober.sequence.Win1253Model()));
        this.probers.add(new org.mozilla.universalchardet.prober.SingleByteCharsetProber(new org.mozilla.universalchardet.prober.sequence.Latin5BulgarianModel()));
        this.probers.add(new org.mozilla.universalchardet.prober.SingleByteCharsetProber(new org.mozilla.universalchardet.prober.sequence.Win1251BulgarianModel()));
        this.probers.add(new org.mozilla.universalchardet.prober.SingleByteCharsetProber(new org.mozilla.universalchardet.prober.sequence.ThaiModel()));
        org.mozilla.universalchardet.prober.sequence.HebrewModel hebrewModel = new org.mozilla.universalchardet.prober.sequence.HebrewModel();
        org.mozilla.universalchardet.prober.HebrewProber hebrewProber = new org.mozilla.universalchardet.prober.HebrewProber();
        org.mozilla.universalchardet.prober.SingleByteCharsetProber singleByteCharsetProber = new org.mozilla.universalchardet.prober.SingleByteCharsetProber(hebrewModel, false, hebrewProber);
        org.mozilla.universalchardet.prober.SingleByteCharsetProber singleByteCharsetProber2 = new org.mozilla.universalchardet.prober.SingleByteCharsetProber(hebrewModel, true, hebrewProber);
        hebrewProber.setModalProbers(singleByteCharsetProber, singleByteCharsetProber2);
        this.probers.add(hebrewProber);
        this.probers.add(singleByteCharsetProber);
        this.probers.add(singleByteCharsetProber2);
        reset();
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public java.lang.String getCharSetName() {
        if (this.bestGuess == null) {
            getConfidence();
            if (this.bestGuess == null) {
                this.bestGuess = this.probers.get(0);
            }
        }
        return this.bestGuess.getCharSetName();
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public float getConfidence() {
        org.mozilla.universalchardet.prober.CharsetProber.ProbingState probingState = this.state;
        if (probingState == org.mozilla.universalchardet.prober.CharsetProber.ProbingState.FOUND_IT) {
            return 0.99f;
        }
        if (probingState == org.mozilla.universalchardet.prober.CharsetProber.ProbingState.NOT_ME) {
            return 0.01f;
        }
        float f = 0.0f;
        for (org.mozilla.universalchardet.prober.CharsetProber charsetProber : this.probers) {
            if (charsetProber.isActive()) {
                float confidence = charsetProber.getConfidence();
                if (f < confidence) {
                    this.bestGuess = charsetProber;
                    f = confidence;
                }
            }
        }
        return f;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public org.mozilla.universalchardet.prober.CharsetProber.ProbingState getState() {
        return this.state;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public org.mozilla.universalchardet.prober.CharsetProber.ProbingState handleData(byte[] bArr, int i, int i2) {
        java.nio.ByteBuffer byteBufferFilterWithoutEnglishLetters = filterWithoutEnglishLetters(bArr, i, i2);
        if (byteBufferFilterWithoutEnglishLetters.position() != 0) {
            for (org.mozilla.universalchardet.prober.CharsetProber charsetProber : this.probers) {
                if (charsetProber.isActive()) {
                    org.mozilla.universalchardet.prober.CharsetProber.ProbingState probingStateHandleData = charsetProber.handleData(byteBufferFilterWithoutEnglishLetters.array(), 0, byteBufferFilterWithoutEnglishLetters.position());
                    org.mozilla.universalchardet.prober.CharsetProber.ProbingState probingState = org.mozilla.universalchardet.prober.CharsetProber.ProbingState.FOUND_IT;
                    if (probingStateHandleData == probingState) {
                        this.bestGuess = charsetProber;
                        this.state = probingState;
                        break;
                    }
                    org.mozilla.universalchardet.prober.CharsetProber.ProbingState probingState2 = org.mozilla.universalchardet.prober.CharsetProber.ProbingState.NOT_ME;
                    if (probingStateHandleData == probingState2) {
                        charsetProber.setActive(false);
                        int i3 = this.activeNum - 1;
                        this.activeNum = i3;
                        if (i3 <= 0) {
                            this.state = probingState2;
                            break;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        return this.state;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public void reset() {
        this.activeNum = 0;
        for (org.mozilla.universalchardet.prober.CharsetProber charsetProber : this.probers) {
            charsetProber.reset();
            charsetProber.setActive(true);
            this.activeNum++;
        }
        this.bestGuess = null;
        this.state = org.mozilla.universalchardet.prober.CharsetProber.ProbingState.DETECTING;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public void setOption() {
    }
}
