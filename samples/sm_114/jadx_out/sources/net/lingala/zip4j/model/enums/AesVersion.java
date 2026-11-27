package net.lingala.zip4j.model.enums;

/* JADX INFO: loaded from: classes2.dex */
public enum AesVersion {
    ONE(1),
    TWO(2);

    private int versionNumber;

    AesVersion(int i) {
        this.versionNumber = i;
    }

    public int getVersionNumber() {
        return this.versionNumber;
    }

    public static net.lingala.zip4j.model.enums.AesVersion getFromVersionNumber(int i) throws net.lingala.zip4j.exception.ZipException {
        for (net.lingala.zip4j.model.enums.AesVersion aesVersion : values()) {
            if (aesVersion.versionNumber == i) {
                return aesVersion;
            }
        }
        throw new net.lingala.zip4j.exception.ZipException("Unsupported Aes version");
    }
}
