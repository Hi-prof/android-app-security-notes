package dc.squareup.okhttp3.internal.cache;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public interface InternalCache {
    dc.squareup.okhttp3.Response get(dc.squareup.okhttp3.Request request) throws java.io.IOException;

    dc.squareup.okhttp3.internal.cache.CacheRequest put(dc.squareup.okhttp3.Response response) throws java.io.IOException;

    void remove(dc.squareup.okhttp3.Request request) throws java.io.IOException;

    void trackConditionalCacheHit();

    void trackResponse(dc.squareup.okhttp3.internal.cache.CacheStrategy cacheStrategy);

    void update(dc.squareup.okhttp3.Response response, dc.squareup.okhttp3.Response response2);
}
