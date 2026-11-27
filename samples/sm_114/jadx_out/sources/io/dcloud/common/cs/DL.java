package io.dcloud.common.cs;

/* JADX INFO: loaded from: classes.dex */
public class DL implements io.dcloud.common.DHInterface.DCI {
    private static io.dcloud.common.DHInterface.DCI mInstance;

    private native boolean cfn(java.lang.String str, java.lang.String str2);

    private native boolean dtn(java.lang.String str, byte[] bArr);

    private native byte[] lfn(java.lang.String str, java.lang.String str2, byte[] bArr);

    public static io.dcloud.common.DHInterface.DCI getInstance() {
        if (mInstance == null) {
            mInstance = new io.dcloud.common.cs.DL();
        }
        return mInstance;
    }

    @Override // io.dcloud.common.DHInterface.DCI
    public boolean dt(java.lang.String str, byte[] bArr) {
        return dtn(str, bArr);
    }

    @Override // io.dcloud.common.DHInterface.DCI
    public byte[] lf(java.lang.String str, java.lang.String str2, byte[] bArr) {
        return lfn(str, str2, bArr);
    }

    @Override // io.dcloud.common.DHInterface.DCI
    public boolean cf(java.lang.String str, java.lang.String str2) {
        return cfn(str, str2);
    }
}
