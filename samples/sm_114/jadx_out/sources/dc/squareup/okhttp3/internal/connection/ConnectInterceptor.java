package dc.squareup.okhttp3.internal.connection;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class ConnectInterceptor implements dc.squareup.okhttp3.Interceptor {
    public final dc.squareup.okhttp3.OkHttpClient client;

    public ConnectInterceptor(dc.squareup.okhttp3.OkHttpClient okHttpClient) {
        this.client = okHttpClient;
    }

    @Override // dc.squareup.okhttp3.Interceptor
    public dc.squareup.okhttp3.Response intercept(dc.squareup.okhttp3.Interceptor.Chain chain) throws java.io.IOException {
        dc.squareup.okhttp3.internal.http.RealInterceptorChain realInterceptorChain = (dc.squareup.okhttp3.internal.http.RealInterceptorChain) chain;
        dc.squareup.okhttp3.Request request = realInterceptorChain.request();
        dc.squareup.okhttp3.internal.connection.StreamAllocation streamAllocation = realInterceptorChain.streamAllocation();
        return realInterceptorChain.proceed(request, streamAllocation, streamAllocation.newStream(this.client, chain, !request.method().equals("GET")), streamAllocation.connection());
    }
}
