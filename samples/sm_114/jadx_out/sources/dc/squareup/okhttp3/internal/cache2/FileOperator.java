package dc.squareup.okhttp3.internal.cache2;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
final class FileOperator {
    private final java.nio.channels.FileChannel fileChannel;

    FileOperator(java.nio.channels.FileChannel fileChannel) {
        this.fileChannel = fileChannel;
    }

    public void read(long j, dc.squareup.okio.Buffer buffer, long j2) throws java.io.IOException {
        if (j2 < 0) {
            throw new java.lang.IndexOutOfBoundsException();
        }
        long j3 = j;
        long j4 = j2;
        while (j4 > 0) {
            long jTransferTo = this.fileChannel.transferTo(j3, j4, buffer);
            j3 += jTransferTo;
            j4 -= jTransferTo;
        }
    }

    public void write(long j, dc.squareup.okio.Buffer buffer, long j2) throws java.io.IOException {
        if (j2 < 0 || j2 > buffer.size()) {
            throw new java.lang.IndexOutOfBoundsException();
        }
        long j3 = j;
        long j4 = j2;
        while (j4 > 0) {
            long jTransferFrom = this.fileChannel.transferFrom(buffer, j3, j4);
            j3 += jTransferFrom;
            j4 -= jTransferFrom;
        }
    }
}
