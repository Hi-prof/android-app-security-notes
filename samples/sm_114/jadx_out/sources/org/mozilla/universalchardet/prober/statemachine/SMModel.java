package org.mozilla.universalchardet.prober.statemachine;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public abstract class SMModel {
    public static final int ERROR = 1;
    public static final int ITSME = 2;
    public static final int START = 0;
    protected int[] charLenTable;
    protected int classFactor;
    protected org.mozilla.universalchardet.prober.statemachine.PkgInt classTable;
    protected java.lang.String name;
    protected org.mozilla.universalchardet.prober.statemachine.PkgInt stateTable;

    public SMModel(org.mozilla.universalchardet.prober.statemachine.PkgInt pkgInt, int i, org.mozilla.universalchardet.prober.statemachine.PkgInt pkgInt2, int[] iArr, java.lang.String str) {
        this.classTable = pkgInt;
        this.classFactor = i;
        this.stateTable = pkgInt2;
        this.charLenTable = (int[]) iArr.clone();
        this.name = str;
    }

    public int getCharLen(int i) {
        return this.charLenTable[i];
    }

    public int getClass(byte b) {
        return this.classTable.unpack(b & 255);
    }

    public java.lang.String getName() {
        return this.name;
    }

    public int getNextState(int i, int i2) {
        return this.stateTable.unpack((i2 * this.classFactor) + i);
    }
}
