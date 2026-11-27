package net.lingala.zip4j.model;

/* JADX INFO: loaded from: classes2.dex */
public class AESExtraDataRecord extends net.lingala.zip4j.model.ZipHeader {
    private net.lingala.zip4j.model.enums.AesKeyStrength aesKeyStrength;
    private net.lingala.zip4j.model.enums.AesVersion aesVersion;
    private net.lingala.zip4j.model.enums.CompressionMethod compressionMethod;
    private int dataSize;
    private java.lang.String vendorID;

    public AESExtraDataRecord() {
        setSignature(net.lingala.zip4j.headers.HeaderSignature.AES_EXTRA_DATA_RECORD);
        this.dataSize = 7;
        this.aesVersion = net.lingala.zip4j.model.enums.AesVersion.TWO;
        this.vendorID = "AE";
        this.aesKeyStrength = net.lingala.zip4j.model.enums.AesKeyStrength.KEY_STRENGTH_256;
        this.compressionMethod = net.lingala.zip4j.model.enums.CompressionMethod.DEFLATE;
    }

    public int getDataSize() {
        return this.dataSize;
    }

    public void setDataSize(int i) {
        this.dataSize = i;
    }

    public net.lingala.zip4j.model.enums.AesVersion getAesVersion() {
        return this.aesVersion;
    }

    public void setAesVersion(net.lingala.zip4j.model.enums.AesVersion aesVersion) {
        this.aesVersion = aesVersion;
    }

    public java.lang.String getVendorID() {
        return this.vendorID;
    }

    public void setVendorID(java.lang.String str) {
        this.vendorID = str;
    }

    public net.lingala.zip4j.model.enums.AesKeyStrength getAesKeyStrength() {
        return this.aesKeyStrength;
    }

    public void setAesKeyStrength(net.lingala.zip4j.model.enums.AesKeyStrength aesKeyStrength) {
        this.aesKeyStrength = aesKeyStrength;
    }

    public net.lingala.zip4j.model.enums.CompressionMethod getCompressionMethod() {
        return this.compressionMethod;
    }

    public void setCompressionMethod(net.lingala.zip4j.model.enums.CompressionMethod compressionMethod) {
        this.compressionMethod = compressionMethod;
    }
}
