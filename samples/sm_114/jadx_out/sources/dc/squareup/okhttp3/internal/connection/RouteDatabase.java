package dc.squareup.okhttp3.internal.connection;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class RouteDatabase {
    private final java.util.Set<dc.squareup.okhttp3.Route> failedRoutes = new java.util.LinkedHashSet();

    public synchronized void connected(dc.squareup.okhttp3.Route route) {
        this.failedRoutes.remove(route);
    }

    public synchronized void failed(dc.squareup.okhttp3.Route route) {
        this.failedRoutes.add(route);
    }

    public synchronized boolean shouldPostpone(dc.squareup.okhttp3.Route route) {
        return this.failedRoutes.contains(route);
    }
}
