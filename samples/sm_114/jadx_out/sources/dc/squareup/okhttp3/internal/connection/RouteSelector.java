package dc.squareup.okhttp3.internal.connection;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class RouteSelector {
    private final dc.squareup.okhttp3.Address address;
    private final dc.squareup.okhttp3.Call call;
    private final dc.squareup.okhttp3.EventListener eventListener;
    private java.util.List<java.net.InetSocketAddress> inetSocketAddresses;
    private int nextProxyIndex;
    private final java.util.List<dc.squareup.okhttp3.Route> postponedRoutes;
    private java.util.List<java.net.Proxy> proxies;
    private final dc.squareup.okhttp3.internal.connection.RouteDatabase routeDatabase;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public static final class Selection {
        private int nextRouteIndex = 0;
        private final java.util.List<dc.squareup.okhttp3.Route> routes;

        Selection(java.util.List<dc.squareup.okhttp3.Route> list) {
            this.routes = list;
        }

        public java.util.List<dc.squareup.okhttp3.Route> getAll() {
            return new java.util.ArrayList(this.routes);
        }

        public boolean hasNext() {
            return this.nextRouteIndex < this.routes.size();
        }

        public dc.squareup.okhttp3.Route next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            java.util.List<dc.squareup.okhttp3.Route> list = this.routes;
            int i = this.nextRouteIndex;
            this.nextRouteIndex = i + 1;
            return list.get(i);
        }
    }

    public RouteSelector(dc.squareup.okhttp3.Address address, dc.squareup.okhttp3.internal.connection.RouteDatabase routeDatabase, dc.squareup.okhttp3.Call call, dc.squareup.okhttp3.EventListener eventListener) {
        java.util.List list = java.util.Collections.EMPTY_LIST;
        this.proxies = list;
        this.inetSocketAddresses = list;
        this.postponedRoutes = new java.util.ArrayList();
        this.address = address;
        this.routeDatabase = routeDatabase;
        this.call = call;
        this.eventListener = eventListener;
        resetNextProxy(address.url(), address.proxy());
    }

    static java.lang.String getHostString(java.net.InetSocketAddress inetSocketAddress) {
        java.net.InetAddress address = inetSocketAddress.getAddress();
        return address == null ? inetSocketAddress.getHostName() : address.getHostAddress();
    }

    private boolean hasNextProxy() {
        return this.nextProxyIndex < this.proxies.size();
    }

    private java.net.Proxy nextProxy() throws java.io.IOException {
        if (!hasNextProxy()) {
            throw new java.net.SocketException("No route to " + this.address.url().host() + "; exhausted proxy configurations: " + this.proxies);
        }
        java.util.List<java.net.Proxy> list = this.proxies;
        int i = this.nextProxyIndex;
        this.nextProxyIndex = i + 1;
        java.net.Proxy proxy = list.get(i);
        resetNextInetSocketAddress(proxy);
        return proxy;
    }

    private void resetNextInetSocketAddress(java.net.Proxy proxy) throws java.io.IOException {
        java.lang.String strHost;
        int iPort;
        this.inetSocketAddresses = new java.util.ArrayList();
        if (proxy.type() == java.net.Proxy.Type.DIRECT || proxy.type() == java.net.Proxy.Type.SOCKS) {
            strHost = this.address.url().host();
            iPort = this.address.url().port();
        } else {
            java.net.SocketAddress socketAddressAddress = proxy.address();
            if (!(socketAddressAddress instanceof java.net.InetSocketAddress)) {
                throw new java.lang.IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + socketAddressAddress.getClass());
            }
            java.net.InetSocketAddress inetSocketAddress = (java.net.InetSocketAddress) socketAddressAddress;
            strHost = getHostString(inetSocketAddress);
            iPort = inetSocketAddress.getPort();
        }
        if (iPort < 1 || iPort > 65535) {
            throw new java.net.SocketException("No route to " + strHost + ":" + iPort + "; port is out of range");
        }
        if (proxy.type() == java.net.Proxy.Type.SOCKS) {
            this.inetSocketAddresses.add(java.net.InetSocketAddress.createUnresolved(strHost, iPort));
            return;
        }
        this.eventListener.dnsStart(this.call, strHost);
        java.util.List<java.net.InetAddress> listLookup = this.address.dns().lookup(strHost);
        if (listLookup.isEmpty()) {
            throw new java.net.UnknownHostException(this.address.dns() + " returned no addresses for " + strHost);
        }
        this.eventListener.dnsEnd(this.call, strHost, listLookup);
        int size = listLookup.size();
        for (int i = 0; i < size; i++) {
            this.inetSocketAddresses.add(new java.net.InetSocketAddress(listLookup.get(i), iPort));
        }
    }

    private void resetNextProxy(dc.squareup.okhttp3.HttpUrl httpUrl, java.net.Proxy proxy) {
        if (proxy != null) {
            this.proxies = java.util.Collections.singletonList(proxy);
        } else {
            java.util.List<java.net.Proxy> listSelect = this.address.proxySelector().select(httpUrl.uri());
            this.proxies = (listSelect == null || listSelect.isEmpty()) ? dc.squareup.okhttp3.internal.Util.immutableList(java.net.Proxy.NO_PROXY) : dc.squareup.okhttp3.internal.Util.immutableList(listSelect);
        }
        this.nextProxyIndex = 0;
    }

    public void connectFailed(dc.squareup.okhttp3.Route route, java.io.IOException iOException) {
        if (route.proxy().type() != java.net.Proxy.Type.DIRECT && this.address.proxySelector() != null) {
            this.address.proxySelector().connectFailed(this.address.url().uri(), route.proxy().address(), iOException);
        }
        this.routeDatabase.failed(route);
    }

    public boolean hasNext() {
        return hasNextProxy() || !this.postponedRoutes.isEmpty();
    }

    public dc.squareup.okhttp3.internal.connection.RouteSelector.Selection next() throws java.io.IOException {
        if (!hasNext()) {
            throw new java.util.NoSuchElementException();
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        while (hasNextProxy()) {
            java.net.Proxy proxyNextProxy = nextProxy();
            int size = this.inetSocketAddresses.size();
            for (int i = 0; i < size; i++) {
                dc.squareup.okhttp3.Route route = new dc.squareup.okhttp3.Route(this.address, proxyNextProxy, this.inetSocketAddresses.get(i));
                if (this.routeDatabase.shouldPostpone(route)) {
                    this.postponedRoutes.add(route);
                } else {
                    arrayList.add(route);
                }
            }
            if (!arrayList.isEmpty()) {
                break;
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.addAll(this.postponedRoutes);
            this.postponedRoutes.clear();
        }
        return new dc.squareup.okhttp3.internal.connection.RouteSelector.Selection(arrayList);
    }
}
