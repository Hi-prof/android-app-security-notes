package io.dcloud.common.adapter.util;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class ByteUtil {
    public static float bytesToFloat(byte[] bArr) {
        return java.lang.Float.parseFloat(new java.lang.String(bArr));
    }

    public static long bytesToLong(byte[] bArr) {
        return java.lang.Long.parseLong(new java.lang.String(bArr));
    }

    public static byte[] floatToBytes(float f) {
        return java.lang.String.valueOf(f).getBytes();
    }

    public static byte[] longToBytes(long j) {
        return java.lang.String.valueOf(j).getBytes();
    }

    public static byte[] toBytes(int i) {
        return new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    public static int toInt(byte[] bArr) {
        return ((bArr[0] & 255) << 24) | (bArr[3] & 255) | ((bArr[2] & 255) << 8) | ((bArr[1] & 255) << 16);
    }
}
