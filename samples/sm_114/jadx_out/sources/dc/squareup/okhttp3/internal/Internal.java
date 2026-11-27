package dc.squareup.okhttp3.internal;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public abstract class Internal {
    public static dc.squareup.okhttp3.internal.Internal instance;

    public static void initializeInstanceForTests() {
        new dc.squareup.okhttp3.OkHttpClient();
    }

    public abstract void addLenient(dc.squareup.okhttp3.Headers.Builder builder, java.lang.String str);

    public abstract void addLenient(dc.squareup.okhttp3.Headers.Builder builder, java.lang.String str, java.lang.String str2);

    public abstract void apply(dc.squareup.okhttp3.ConnectionSpec connectionSpec, javax.net.ssl.SSLSocket sSLSocket, boolean z);

    public abstract int code(dc.squareup.okhttp3.Response.Builder builder);

    public abstract boolean connectionBecameIdle(dc.squareup.okhttp3.ConnectionPool connectionPool, dc.squareup.okhttp3.internal.connection.RealConnection realConnection);

    public abstract java.net.Socket deduplicate(dc.squareup.okhttp3.ConnectionPool connectionPool, dc.squareup.okhttp3.Address address, dc.squareup.okhttp3.internal.connection.StreamAllocation streamAllocation);

    public abstract boolean equalsNonHost(dc.squareup.okhttp3.Address address, dc.squareup.okhttp3.Address address2);

    public abstract dc.squareup.okhttp3.internal.connection.RealConnection get(dc.squareup.okhttp3.ConnectionPool connectionPool, dc.squareup.okhttp3.Address address, dc.squareup.okhttp3.internal.connection.StreamAllocation streamAllocation, dc.squareup.okhttp3.Route route);

    public abstract boolean isInvalidHttpUrlHost(java.lang.IllegalArgumentException illegalArgumentException);

    public abstract dc.squareup.okhttp3.Call newWebSocketCall(dc.squareup.okhttp3.OkHttpClient okHttpClient, dc.squareup.okhttp3.Request request);

    public abstract void put(dc.squareup.okhttp3.ConnectionPool connectionPool, dc.squareup.okhttp3.internal.connection.RealConnection realConnection);

    public abstract dc.squareup.okhttp3.internal.connection.RouteDatabase routeDatabase(dc.squareup.okhttp3.ConnectionPool connectionPool);

    public abstract void setCache(dc.squareup.okhttp3.OkHttpClient.Builder builder, dc.squareup.okhttp3.internal.cache.InternalCache internalCache);

    public abstract dc.squareup.okhttp3.internal.connection.StreamAllocation streamAllocation(dc.squareup.okhttp3.Call call);

    public abstract java.io.IOException timeoutExit(dc.squareup.okhttp3.Call call, java.io.IOException iOException);
}
