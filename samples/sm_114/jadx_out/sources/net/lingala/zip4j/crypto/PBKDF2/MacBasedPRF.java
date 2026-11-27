package net.lingala.zip4j.crypto.PBKDF2;

/* JADX INFO: loaded from: classes2.dex */
public class MacBasedPRF implements net.lingala.zip4j.crypto.PBKDF2.PRF {
    private int hLen;
    private javax.crypto.Mac mac;
    private java.lang.String macAlgorithm;
    private java.io.ByteArrayOutputStream macCache = new java.io.ByteArrayOutputStream(4096);

    public MacBasedPRF(java.lang.String str) {
        this.macAlgorithm = str;
        try {
            javax.crypto.Mac mac = javax.crypto.Mac.getInstance(str);
            this.mac = mac;
            this.hLen = mac.getMacLength();
        } catch (java.security.NoSuchAlgorithmException e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    @Override // net.lingala.zip4j.crypto.PBKDF2.PRF
    public byte[] doFinal(byte[] bArr) {
        if (this.macCache.size() > 0) {
            doMacUpdate(0);
        }
        return this.mac.doFinal(bArr);
    }

    public byte[] doFinal() {
        return doFinal(0);
    }

    public byte[] doFinal(int i) {
        if (this.macCache.size() > 0) {
            doMacUpdate(i);
        }
        return this.mac.doFinal();
    }

    @Override // net.lingala.zip4j.crypto.PBKDF2.PRF
    public int getHLen() {
        return this.hLen;
    }

    @Override // net.lingala.zip4j.crypto.PBKDF2.PRF
    public void init(byte[] bArr) {
        try {
            this.mac.init(new javax.crypto.spec.SecretKeySpec(bArr, this.macAlgorithm));
        } catch (java.security.InvalidKeyException e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    public void update(byte[] bArr) {
        update(bArr, 0, bArr.length);
    }

    public void update(byte[] bArr, int i, int i2) {
        try {
            if (this.macCache.size() + i2 > 4096) {
                doMacUpdate(0);
            }
            this.macCache.write(bArr, i, i2);
        } catch (java.lang.IllegalStateException e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    private void doMacUpdate(int i) {
        byte[] byteArray = this.macCache.toByteArray();
        int length = byteArray.length - i;
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 + 16;
            this.mac.update(byteArray, i2, i3 <= length ? 16 : length - i2);
            i2 = i3;
        }
        this.macCache.reset();
    }
}
