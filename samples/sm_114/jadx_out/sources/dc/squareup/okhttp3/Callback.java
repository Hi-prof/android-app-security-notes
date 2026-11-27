package dc.squareup.okhttp3;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public interface Callback {
    void onFailure(dc.squareup.okhttp3.Call call, java.io.IOException iOException);

    void onResponse(dc.squareup.okhttp3.Call call, dc.squareup.okhttp3.Response response) throws java.io.IOException;
}
