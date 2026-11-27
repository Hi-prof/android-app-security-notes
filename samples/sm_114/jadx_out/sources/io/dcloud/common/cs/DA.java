package io.dcloud.common.cs;

/* JADX INFO: loaded from: classes.dex */
public class DA implements io.dcloud.common.DHInterface.DAI {
    private static io.dcloud.common.DHInterface.DAI mInstance;

    private native void arn(java.lang.String str, java.lang.Object obj);

    private native void atcn(java.lang.String str, java.lang.Object obj);

    private native void scn();

    public static io.dcloud.common.DHInterface.DAI getInstance() {
        if (mInstance == null) {
            mInstance = new io.dcloud.common.cs.DA();
        }
        return mInstance;
    }

    @Override // io.dcloud.common.DHInterface.DAI
    public void sc() {
        scn();
    }

    @Override // io.dcloud.common.DHInterface.DAI
    public void ar(java.lang.String str, java.lang.Object obj) {
        arn(str, obj);
    }

    @Override // io.dcloud.common.DHInterface.DAI
    public void act(java.lang.String str, java.lang.Object obj) {
        atcn(str, obj);
    }
}
