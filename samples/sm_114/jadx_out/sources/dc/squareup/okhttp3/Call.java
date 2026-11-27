package dc.squareup.okhttp3;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public interface Call extends java.lang.Cloneable {

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public interface Factory {
        dc.squareup.okhttp3.Call newCall(dc.squareup.okhttp3.Request request);
    }

    void cancel();

    dc.squareup.okhttp3.Call clone();

    void enqueue(dc.squareup.okhttp3.Callback callback);

    dc.squareup.okhttp3.Response execute() throws java.io.IOException;

    boolean isCanceled();

    boolean isExecuted();

    dc.squareup.okhttp3.Request request();

    dc.squareup.okio.Timeout timeout();
}
