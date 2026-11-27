package dc.squareup.okhttp3.internal.cache;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
class FaultHidingSink extends dc.squareup.okio.ForwardingSink {
    private boolean hasErrors;

    FaultHidingSink(dc.squareup.okio.Sink sink) {
        super(sink);
    }

    @Override // dc.squareup.okio.ForwardingSink, dc.squareup.okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        if (this.hasErrors) {
            return;
        }
        try {
            super.close();
        } catch (java.io.IOException e) {
            this.hasErrors = true;
            onException(e);
        }
    }

    @Override // dc.squareup.okio.ForwardingSink, dc.squareup.okio.Sink, java.io.Flushable
    public void flush() throws java.io.IOException {
        if (this.hasErrors) {
            return;
        }
        try {
            super.flush();
        } catch (java.io.IOException e) {
            this.hasErrors = true;
            onException(e);
        }
    }

    protected void onException(java.io.IOException iOException) {
    }

    @Override // dc.squareup.okio.ForwardingSink, dc.squareup.okio.Sink
    public void write(dc.squareup.okio.Buffer buffer, long j) throws java.io.IOException {
        if (this.hasErrors) {
            buffer.skip(j);
            return;
        }
        try {
            super.write(buffer, j);
        } catch (java.io.IOException e) {
            this.hasErrors = true;
            onException(e);
        }
    }
}
