package dc.squareup.okio;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public abstract class ForwardingSink implements dc.squareup.okio.Sink {
    private final dc.squareup.okio.Sink delegate;

    public ForwardingSink(dc.squareup.okio.Sink sink) {
        if (sink == null) {
            throw new java.lang.IllegalArgumentException("delegate == null");
        }
        this.delegate = sink;
    }

    @Override // dc.squareup.okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        this.delegate.close();
    }

    public final dc.squareup.okio.Sink delegate() {
        return this.delegate;
    }

    @Override // dc.squareup.okio.Sink, java.io.Flushable
    public void flush() throws java.io.IOException {
        this.delegate.flush();
    }

    @Override // dc.squareup.okio.Sink
    public dc.squareup.okio.Timeout timeout() {
        return this.delegate.timeout();
    }

    public java.lang.String toString() {
        return getClass().getSimpleName() + com.taobao.weex.el.parse.Operators.BRACKET_START_STR + this.delegate.toString() + com.taobao.weex.el.parse.Operators.BRACKET_END_STR;
    }

    @Override // dc.squareup.okio.Sink
    public void write(dc.squareup.okio.Buffer buffer, long j) throws java.io.IOException {
        this.delegate.write(buffer, j);
    }
}
