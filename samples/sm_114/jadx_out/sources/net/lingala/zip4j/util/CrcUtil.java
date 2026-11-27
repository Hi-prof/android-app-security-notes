package net.lingala.zip4j.util;

/* JADX INFO: loaded from: classes2.dex */
public class CrcUtil {
    private static final int BUF_SIZE = 16384;

    public static long computeFileCrc(java.io.File file, net.lingala.zip4j.progress.ProgressMonitor progressMonitor) throws java.io.IOException {
        if (file == null || !file.exists() || !file.canRead()) {
            throw new net.lingala.zip4j.exception.ZipException("input file is null or does not exist or cannot read. Cannot calculate CRC for the file");
        }
        byte[] bArr = new byte[16384];
        java.util.zip.CRC32 crc32 = new java.util.zip.CRC32();
        java.io.FileInputStream fileInputStream = new java.io.FileInputStream(file);
        while (true) {
            try {
                int i = fileInputStream.read(bArr);
                if (i != -1) {
                    crc32.update(bArr, 0, i);
                    if (progressMonitor != null) {
                        progressMonitor.updateWorkCompleted(i);
                        if (progressMonitor.isCancelAllTasks()) {
                            progressMonitor.setResult(net.lingala.zip4j.progress.ProgressMonitor.Result.CANCELLED);
                            progressMonitor.setState(net.lingala.zip4j.progress.ProgressMonitor.State.READY);
                            fileInputStream.close();
                            return 0L;
                        }
                    }
                } else {
                    long value = crc32.getValue();
                    fileInputStream.close();
                    return value;
                }
            } catch (java.lang.Throwable th) {
                try {
                    fileInputStream.close();
                } catch (java.lang.Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
    }
}
