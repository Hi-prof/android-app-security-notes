package dc.squareup.okio;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public interface Source extends java.io.Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws java.io.IOException;

    long read(dc.squareup.okio.Buffer buffer, long j) throws java.io.IOException;

    dc.squareup.okio.Timeout timeout();
}
