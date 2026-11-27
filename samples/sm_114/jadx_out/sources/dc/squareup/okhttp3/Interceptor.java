package dc.squareup.okhttp3;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public interface Interceptor {

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public interface Chain {
        dc.squareup.okhttp3.Call call();

        int connectTimeoutMillis();

        dc.squareup.okhttp3.Connection connection();

        dc.squareup.okhttp3.Response proceed(dc.squareup.okhttp3.Request request) throws java.io.IOException;

        int readTimeoutMillis();

        dc.squareup.okhttp3.Request request();

        dc.squareup.okhttp3.Interceptor.Chain withConnectTimeout(int i, java.util.concurrent.TimeUnit timeUnit);

        dc.squareup.okhttp3.Interceptor.Chain withReadTimeout(int i, java.util.concurrent.TimeUnit timeUnit);

        dc.squareup.okhttp3.Interceptor.Chain withWriteTimeout(int i, java.util.concurrent.TimeUnit timeUnit);

        int writeTimeoutMillis();
    }

    dc.squareup.okhttp3.Response intercept(dc.squareup.okhttp3.Interceptor.Chain chain) throws java.io.IOException;
}
