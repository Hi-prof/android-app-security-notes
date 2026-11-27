package com.bun.miitmdid.core;

/* JADX INFO: loaded from: classes.dex */
public class ZipUtils {
    private static final int BUFFER_SIZE = 16384;
    private static final int ENDHDR = 22;
    private static final int ENDSIG = 101010256;

    static class CentralDirectory {
        long offset;
        long size;

        CentralDirectory() {
        }
    }

    static long computeCrcOfCentralDir(java.io.RandomAccessFile randomAccessFile, com.bun.miitmdid.core.ZipUtils.CentralDirectory centralDirectory) throws java.io.IOException {
        java.util.zip.CRC32 crc32 = new java.util.zip.CRC32();
        long j = centralDirectory.size;
        randomAccessFile.seek(centralDirectory.offset);
        int iMin = (int) java.lang.Math.min(tv.danmaku.ijk.media.player.IjkMediaMeta.AV_CH_TOP_FRONT_RIGHT, j);
        byte[] bArr = new byte[16384];
        while (true) {
            int i = randomAccessFile.read(bArr, 0, iMin);
            if (i != -1) {
                crc32.update(bArr, 0, i);
                j -= (long) i;
                if (j == 0) {
                    break;
                }
                iMin = (int) java.lang.Math.min(tv.danmaku.ijk.media.player.IjkMediaMeta.AV_CH_TOP_FRONT_RIGHT, j);
            } else {
                break;
            }
        }
        return crc32.getValue();
    }

    static com.bun.miitmdid.core.ZipUtils.CentralDirectory findCentralDirectory(java.io.RandomAccessFile randomAccessFile) throws java.io.IOException {
        long length = randomAccessFile.length();
        long j = length - 22;
        if (j < 0) {
            throw new java.util.zip.ZipException("File too short to be a zip file: " + randomAccessFile.length());
        }
        long j2 = length - 65558;
        long j3 = j2 >= 0 ? j2 : 0L;
        int iReverseBytes = java.lang.Integer.reverseBytes(ENDSIG);
        do {
            randomAccessFile.seek(j);
            if (randomAccessFile.readInt() == iReverseBytes) {
                randomAccessFile.skipBytes(2);
                randomAccessFile.skipBytes(2);
                randomAccessFile.skipBytes(2);
                randomAccessFile.skipBytes(2);
                com.bun.miitmdid.core.ZipUtils.CentralDirectory centralDirectory = new com.bun.miitmdid.core.ZipUtils.CentralDirectory();
                centralDirectory.size = ((long) java.lang.Integer.reverseBytes(randomAccessFile.readInt())) & net.lingala.zip4j.util.InternalZipConstants.ZIP_64_SIZE_LIMIT;
                centralDirectory.offset = ((long) java.lang.Integer.reverseBytes(randomAccessFile.readInt())) & net.lingala.zip4j.util.InternalZipConstants.ZIP_64_SIZE_LIMIT;
                return centralDirectory;
            }
            j--;
        } while (j >= j3);
        throw new java.util.zip.ZipException("End Of Central Directory signature not found");
    }

    public static long getZipCrc(java.io.File file) throws java.io.IOException {
        java.io.RandomAccessFile randomAccessFile = new java.io.RandomAccessFile(file, "r");
        try {
            return computeCrcOfCentralDir(randomAccessFile, findCentralDirectory(randomAccessFile));
        } finally {
            randomAccessFile.close();
        }
    }
}
