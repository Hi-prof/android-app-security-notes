package org.mozilla.universalchardet.prober.sequence;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public abstract class SequenceModel {
    protected short[] charToOrderMap;
    protected java.lang.String charsetName;
    protected boolean keepEnglishLetter;
    protected byte[] precedenceMatrix;
    protected float typicalPositiveRatio;

    public SequenceModel(short[] sArr, byte[] bArr, float f, boolean z, java.lang.String str) {
        this.charToOrderMap = (short[]) sArr.clone();
        this.precedenceMatrix = (byte[]) bArr.clone();
        this.typicalPositiveRatio = f;
        this.keepEnglishLetter = z;
        this.charsetName = str;
    }

    public java.lang.String getCharsetName() {
        return this.charsetName;
    }

    public boolean getKeepEnglishLetter() {
        return this.keepEnglishLetter;
    }

    public short getOrder(byte b) {
        return this.charToOrderMap[b & 255];
    }

    public byte getPrecedence(int i) {
        return this.precedenceMatrix[i];
    }

    public float getTypicalPositiveRatio() {
        return this.typicalPositiveRatio;
    }
}
