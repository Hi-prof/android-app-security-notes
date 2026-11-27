package net.lingala.zip4j.crypto.PBKDF2;

/* JADX INFO: loaded from: classes2.dex */
class PBKDF2HexFormatter {
    PBKDF2HexFormatter() {
    }

    public boolean fromString(net.lingala.zip4j.crypto.PBKDF2.PBKDF2Parameters pBKDF2Parameters, java.lang.String str) {
        if (pBKDF2Parameters == null || str == null) {
            return true;
        }
        java.lang.String[] strArrSplit = str.split(":");
        if (strArrSplit.length != 3) {
            return true;
        }
        byte[] bArrHex2bin = net.lingala.zip4j.crypto.PBKDF2.BinTools.hex2bin(strArrSplit[0]);
        int i = java.lang.Integer.parseInt(strArrSplit[1]);
        byte[] bArrHex2bin2 = net.lingala.zip4j.crypto.PBKDF2.BinTools.hex2bin(strArrSplit[2]);
        pBKDF2Parameters.setSalt(bArrHex2bin);
        pBKDF2Parameters.setIterationCount(i);
        pBKDF2Parameters.setDerivedKey(bArrHex2bin2);
        return false;
    }

    public java.lang.String toString(net.lingala.zip4j.crypto.PBKDF2.PBKDF2Parameters pBKDF2Parameters) {
        return net.lingala.zip4j.crypto.PBKDF2.BinTools.bin2hex(pBKDF2Parameters.getSalt()) + ":" + java.lang.String.valueOf(pBKDF2Parameters.getIterationCount()) + ":" + net.lingala.zip4j.crypto.PBKDF2.BinTools.bin2hex(pBKDF2Parameters.getDerivedKey());
    }
}
