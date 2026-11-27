package dc.squareup.okio;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public abstract class ForwardingSource implements dc.squareup.okio.Source {
    private final dc.squareup.okio.Source delegate;

    public ForwardingSource(dc.squareup.okio.Source source) {
        if (source == null) {
            throw new java.lang.IllegalArgumentException("delegate == null");
        }
        this.delegate = source;
    }

    @Override // dc.squareup.okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        this.delegate.close();
    }

    public final dc.squareup.okio.Source delegate() {
        return this.delegate;
    }

    @Override // dc.squareup.okio.Source
    public long read(dc.squareup.okio.Buffer buffer, long j) throws java.io.IOException {
        return this.delegate.read(buffer, j);
    }

    @Override // dc.squareup.okio.Source
    public dc.squareup.okio.Timeout timeout() {
        return this.delegate.timeout();
    }

    public java.lang.String toString() {
        return getClass().getSimpleName() + com.taobao.weex.el.parse.Operators.BRACKET_START_STR + this.delegate.toString() + com.taobao.weex.el.parse.Operators.BRACKET_END_STR;
    }
}
