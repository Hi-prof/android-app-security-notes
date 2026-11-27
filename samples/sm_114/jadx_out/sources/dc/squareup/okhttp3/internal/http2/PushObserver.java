package dc.squareup.okhttp3.internal.http2;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public interface PushObserver {
    public static final dc.squareup.okhttp3.internal.http2.PushObserver CANCEL = new dc.squareup.okhttp3.internal.http2.PushObserver() { // from class: dc.squareup.okhttp3.internal.http2.PushObserver.1
        @Override // dc.squareup.okhttp3.internal.http2.PushObserver
        public boolean onData(int i, dc.squareup.okio.BufferedSource bufferedSource, int i2, boolean z) throws java.io.IOException {
            bufferedSource.skip(i2);
            return true;
        }

        @Override // dc.squareup.okhttp3.internal.http2.PushObserver
        public boolean onHeaders(int i, java.util.List<dc.squareup.okhttp3.internal.http2.Header> list, boolean z) {
            return true;
        }

        @Override // dc.squareup.okhttp3.internal.http2.PushObserver
        public boolean onRequest(int i, java.util.List<dc.squareup.okhttp3.internal.http2.Header> list) {
            return true;
        }

        @Override // dc.squareup.okhttp3.internal.http2.PushObserver
        public void onReset(int i, dc.squareup.okhttp3.internal.http2.ErrorCode errorCode) {
        }
    };

    boolean onData(int i, dc.squareup.okio.BufferedSource bufferedSource, int i2, boolean z) throws java.io.IOException;

    boolean onHeaders(int i, java.util.List<dc.squareup.okhttp3.internal.http2.Header> list, boolean z);

    boolean onRequest(int i, java.util.List<dc.squareup.okhttp3.internal.http2.Header> list);

    void onReset(int i, dc.squareup.okhttp3.internal.http2.ErrorCode errorCode);
}
