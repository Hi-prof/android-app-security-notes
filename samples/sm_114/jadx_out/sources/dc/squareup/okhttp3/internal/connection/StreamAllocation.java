package dc.squareup.okhttp3.internal.connection;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class StreamAllocation {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public final dc.squareup.okhttp3.Address address;
    public final dc.squareup.okhttp3.Call call;
    private final java.lang.Object callStackTrace;
    private boolean canceled;
    private dc.squareup.okhttp3.internal.http.HttpCodec codec;
    private dc.squareup.okhttp3.internal.connection.RealConnection connection;
    private final dc.squareup.okhttp3.ConnectionPool connectionPool;
    public final dc.squareup.okhttp3.EventListener eventListener;
    private int refusedStreamCount;
    private boolean released;
    private boolean reportedAcquired;
    private dc.squareup.okhttp3.Route route;
    private dc.squareup.okhttp3.internal.connection.RouteSelector.Selection routeSelection;
    private final dc.squareup.okhttp3.internal.connection.RouteSelector routeSelector;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public static final class StreamAllocationReference extends java.lang.ref.WeakReference<dc.squareup.okhttp3.internal.connection.StreamAllocation> {
        public final java.lang.Object callStackTrace;

        StreamAllocationReference(dc.squareup.okhttp3.internal.connection.StreamAllocation streamAllocation, java.lang.Object obj) {
            super(streamAllocation);
            this.callStackTrace = obj;
        }
    }

    public StreamAllocation(dc.squareup.okhttp3.ConnectionPool connectionPool, dc.squareup.okhttp3.Address address, dc.squareup.okhttp3.Call call, dc.squareup.okhttp3.EventListener eventListener, java.lang.Object obj) {
        this.connectionPool = connectionPool;
        this.address = address;
        this.call = call;
        this.eventListener = eventListener;
        this.routeSelector = new dc.squareup.okhttp3.internal.connection.RouteSelector(address, routeDatabase(), call, eventListener);
        this.callStackTrace = obj;
    }

    private dc.squareup.okhttp3.internal.connection.RealConnection findConnection(int i, int i2, int i3, int i4, boolean z) throws java.lang.Throwable {
        dc.squareup.okhttp3.internal.connection.RealConnection realConnection;
        java.net.Socket socketReleaseIfNoNewStreams;
        dc.squareup.okhttp3.internal.connection.RealConnection realConnection2;
        java.net.Socket socketDeduplicate;
        dc.squareup.okhttp3.Route next;
        boolean z2;
        boolean z3;
        dc.squareup.okhttp3.internal.connection.RealConnection realConnection3;
        dc.squareup.okhttp3.internal.connection.RouteSelector.Selection selection;
        synchronized (this.connectionPool) {
            if (this.released) {
                throw new java.lang.IllegalStateException("released");
            }
            if (this.codec != null) {
                throw new java.lang.IllegalStateException("codec != null");
            }
            if (this.canceled) {
                throw new java.io.IOException("Canceled");
            }
            realConnection = this.connection;
            socketReleaseIfNoNewStreams = releaseIfNoNewStreams();
            realConnection2 = this.connection;
            socketDeduplicate = null;
            if (realConnection2 != null) {
                realConnection = null;
            } else {
                realConnection2 = null;
            }
            if (!this.reportedAcquired) {
                realConnection = null;
            }
            if (realConnection2 == null) {
                dc.squareup.okhttp3.internal.Internal.instance.get(this.connectionPool, this.address, this, null);
                dc.squareup.okhttp3.internal.connection.RealConnection realConnection4 = this.connection;
                if (realConnection4 != null) {
                    realConnection2 = realConnection4;
                    z2 = true;
                    next = null;
                } else {
                    next = this.route;
                }
            } else {
                next = null;
            }
            z2 = false;
        }
        dc.squareup.okhttp3.internal.Util.closeQuietly(socketReleaseIfNoNewStreams);
        if (realConnection != null) {
            this.eventListener.connectionReleased(this.call, realConnection);
        }
        if (z2) {
            this.eventListener.connectionAcquired(this.call, realConnection2);
        }
        if (realConnection2 != null) {
            this.route = this.connection.route();
            return realConnection2;
        }
        if (next != null || ((selection = this.routeSelection) != null && selection.hasNext())) {
            z3 = false;
        } else {
            this.routeSelection = this.routeSelector.next();
            z3 = true;
        }
        synchronized (this.connectionPool) {
            if (this.canceled) {
                throw new java.io.IOException("Canceled");
            }
            if (z3) {
                java.util.List<dc.squareup.okhttp3.Route> all = this.routeSelection.getAll();
                int size = all.size();
                for (int i5 = 0; i5 < size; i5++) {
                    dc.squareup.okhttp3.Route route = all.get(i5);
                    dc.squareup.okhttp3.internal.Internal.instance.get(this.connectionPool, this.address, this, route);
                    dc.squareup.okhttp3.internal.connection.RealConnection realConnection5 = this.connection;
                    if (realConnection5 != null) {
                        this.route = route;
                        realConnection2 = realConnection5;
                        z2 = true;
                        break;
                    }
                }
            }
            if (!z2) {
                if (next == null) {
                    next = this.routeSelection.next();
                }
                this.route = next;
                this.refusedStreamCount = 0;
                realConnection2 = new dc.squareup.okhttp3.internal.connection.RealConnection(this.connectionPool, next);
                acquire(realConnection2, false);
            }
            realConnection3 = realConnection2;
        }
        if (z2) {
            this.eventListener.connectionAcquired(this.call, realConnection3);
            return realConnection3;
        }
        realConnection3.connect(i, i2, i3, i4, z, this.call, this.eventListener);
        routeDatabase().connected(realConnection3.route());
        synchronized (this.connectionPool) {
            this.reportedAcquired = true;
            dc.squareup.okhttp3.internal.Internal.instance.put(this.connectionPool, realConnection3);
            if (realConnection3.isMultiplexed()) {
                socketDeduplicate = dc.squareup.okhttp3.internal.Internal.instance.deduplicate(this.connectionPool, this.address, this);
                realConnection3 = this.connection;
            }
        }
        dc.squareup.okhttp3.internal.Util.closeQuietly(socketDeduplicate);
        this.eventListener.connectionAcquired(this.call, realConnection3);
        return realConnection3;
    }

    private dc.squareup.okhttp3.internal.connection.RealConnection findHealthyConnection(int i, int i2, int i3, int i4, boolean z, boolean z2) throws java.lang.Throwable {
        while (true) {
            dc.squareup.okhttp3.internal.connection.RealConnection realConnectionFindConnection = findConnection(i, i2, i3, i4, z);
            boolean z3 = z;
            int i5 = i4;
            int i6 = i3;
            int i7 = i2;
            int i8 = i;
            synchronized (this.connectionPool) {
                if (realConnectionFindConnection.successCount == 0 && !realConnectionFindConnection.isMultiplexed()) {
                    return realConnectionFindConnection;
                }
                if (realConnectionFindConnection.isHealthy(z2)) {
                    return realConnectionFindConnection;
                }
                noNewStreams();
                i = i8;
                i2 = i7;
                i3 = i6;
                i4 = i5;
                z = z3;
            }
        }
    }

    private dc.squareup.okhttp3.internal.connection.RouteDatabase routeDatabase() {
        return dc.squareup.okhttp3.internal.Internal.instance.routeDatabase(this.connectionPool);
    }

    public void cancel() {
        dc.squareup.okhttp3.internal.http.HttpCodec httpCodec;
        dc.squareup.okhttp3.internal.connection.RealConnection realConnection;
        synchronized (this.connectionPool) {
            this.canceled = true;
            httpCodec = this.codec;
            realConnection = this.connection;
        }
        if (httpCodec != null) {
            httpCodec.cancel();
        } else if (realConnection != null) {
            realConnection.cancel();
        }
    }

    public dc.squareup.okhttp3.internal.http.HttpCodec codec() {
        dc.squareup.okhttp3.internal.http.HttpCodec httpCodec;
        synchronized (this.connectionPool) {
            httpCodec = this.codec;
        }
        return httpCodec;
    }

    public synchronized dc.squareup.okhttp3.internal.connection.RealConnection connection() {
        return this.connection;
    }

    public boolean hasMoreRoutes() {
        if (this.route != null) {
            return true;
        }
        dc.squareup.okhttp3.internal.connection.RouteSelector.Selection selection = this.routeSelection;
        return (selection != null && selection.hasNext()) || this.routeSelector.hasNext();
    }

    public dc.squareup.okhttp3.internal.http.HttpCodec newStream(dc.squareup.okhttp3.OkHttpClient okHttpClient, dc.squareup.okhttp3.Interceptor.Chain chain, boolean z) {
        try {
            dc.squareup.okhttp3.internal.http.HttpCodec httpCodecNewCodec = findHealthyConnection(chain.connectTimeoutMillis(), chain.readTimeoutMillis(), chain.writeTimeoutMillis(), okHttpClient.pingIntervalMillis(), okHttpClient.retryOnConnectionFailure(), z).newCodec(okHttpClient, chain, this);
            synchronized (this.connectionPool) {
                this.codec = httpCodecNewCodec;
            }
            return httpCodecNewCodec;
        } catch (java.io.IOException e) {
            throw new dc.squareup.okhttp3.internal.connection.RouteException(e);
        }
    }

    public void noNewStreams() {
        dc.squareup.okhttp3.internal.connection.RealConnection realConnection;
        java.net.Socket socketDeallocate;
        synchronized (this.connectionPool) {
            realConnection = this.connection;
            socketDeallocate = deallocate(true, false, false);
            if (this.connection != null) {
                realConnection = null;
            }
        }
        dc.squareup.okhttp3.internal.Util.closeQuietly(socketDeallocate);
        if (realConnection != null) {
            this.eventListener.connectionReleased(this.call, realConnection);
        }
    }

    public void release() {
        dc.squareup.okhttp3.internal.connection.RealConnection realConnection;
        java.net.Socket socketDeallocate;
        synchronized (this.connectionPool) {
            realConnection = this.connection;
            socketDeallocate = deallocate(false, true, false);
            if (this.connection != null) {
                realConnection = null;
            }
        }
        dc.squareup.okhttp3.internal.Util.closeQuietly(socketDeallocate);
        if (realConnection != null) {
            dc.squareup.okhttp3.internal.Internal.instance.timeoutExit(this.call, null);
            this.eventListener.connectionReleased(this.call, realConnection);
            this.eventListener.callEnd(this.call);
        }
    }

    public dc.squareup.okhttp3.Route route() {
        return this.route;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0046  */
    public void streamFailed(java.io.IOException iOException) {
        dc.squareup.okhttp3.internal.connection.RealConnection realConnection;
        boolean z;
        java.net.Socket socketDeallocate;
        synchronized (this.connectionPool) {
            realConnection = null;
            if (iOException instanceof dc.squareup.okhttp3.internal.http2.StreamResetException) {
                dc.squareup.okhttp3.internal.http2.ErrorCode errorCode = ((dc.squareup.okhttp3.internal.http2.StreamResetException) iOException).errorCode;
                if (errorCode == dc.squareup.okhttp3.internal.http2.ErrorCode.REFUSED_STREAM) {
                    int i = this.refusedStreamCount + 1;
                    this.refusedStreamCount = i;
                    if (i > 1) {
                        this.route = null;
                        z = true;
                    } else {
                        z = false;
                    }
                } else if (errorCode != dc.squareup.okhttp3.internal.http2.ErrorCode.CANCEL) {
                    this.route = null;
                    z = true;
                } else {
                    z = false;
                }
            } else {
                dc.squareup.okhttp3.internal.connection.RealConnection realConnection2 = this.connection;
                if (realConnection2 == null || (realConnection2.isMultiplexed() && !(iOException instanceof dc.squareup.okhttp3.internal.http2.ConnectionShutdownException))) {
                    z = false;
                } else {
                    if (this.connection.successCount == 0) {
                        dc.squareup.okhttp3.Route route = this.route;
                        if (route != null && iOException != null) {
                            this.routeSelector.connectFailed(route, iOException);
                        }
                        this.route = null;
                    }
                    z = true;
                }
            }
            dc.squareup.okhttp3.internal.connection.RealConnection realConnection3 = this.connection;
            socketDeallocate = deallocate(z, false, true);
            if (this.connection == null && this.reportedAcquired) {
                realConnection = realConnection3;
            }
        }
        dc.squareup.okhttp3.internal.Util.closeQuietly(socketDeallocate);
        if (realConnection != null) {
            this.eventListener.connectionReleased(this.call, realConnection);
        }
    }

    public void streamFinished(boolean z, dc.squareup.okhttp3.internal.http.HttpCodec httpCodec, long j, java.io.IOException iOException) {
        dc.squareup.okhttp3.internal.connection.RealConnection realConnection;
        java.net.Socket socketDeallocate;
        boolean z2;
        this.eventListener.responseBodyEnd(this.call, j);
        synchronized (this.connectionPool) {
            if (httpCodec != null) {
                if (httpCodec == this.codec) {
                    if (!z) {
                        this.connection.successCount++;
                    }
                    realConnection = this.connection;
                    socketDeallocate = deallocate(z, false, true);
                    if (this.connection != null) {
                        realConnection = null;
                    }
                    z2 = this.released;
                }
            }
            throw new java.lang.IllegalStateException("expected " + this.codec + " but was " + httpCodec);
        }
        dc.squareup.okhttp3.internal.Util.closeQuietly(socketDeallocate);
        if (realConnection != null) {
            this.eventListener.connectionReleased(this.call, realConnection);
        }
        if (iOException != null) {
            this.eventListener.callFailed(this.call, dc.squareup.okhttp3.internal.Internal.instance.timeoutExit(this.call, iOException));
        } else if (z2) {
            dc.squareup.okhttp3.internal.Internal.instance.timeoutExit(this.call, null);
            this.eventListener.callEnd(this.call);
        }
    }

    public java.lang.String toString() {
        dc.squareup.okhttp3.internal.connection.RealConnection realConnectionConnection = connection();
        return realConnectionConnection != null ? realConnectionConnection.toString() : this.address.toString();
    }

    private java.net.Socket releaseIfNoNewStreams() {
        dc.squareup.okhttp3.internal.connection.RealConnection realConnection = this.connection;
        if (realConnection == null || !realConnection.noNewStreams) {
            return null;
        }
        return deallocate(false, false, true);
    }

    public void acquire(dc.squareup.okhttp3.internal.connection.RealConnection realConnection, boolean z) {
        if (this.connection != null) {
            throw new java.lang.IllegalStateException();
        }
        this.connection = realConnection;
        this.reportedAcquired = z;
        realConnection.allocations.add(new dc.squareup.okhttp3.internal.connection.StreamAllocation.StreamAllocationReference(this, this.callStackTrace));
    }

    public java.net.Socket releaseAndAcquire(dc.squareup.okhttp3.internal.connection.RealConnection realConnection) {
        if (this.codec != null || this.connection.allocations.size() != 1) {
            throw new java.lang.IllegalStateException();
        }
        java.lang.ref.Reference<dc.squareup.okhttp3.internal.connection.StreamAllocation> reference = this.connection.allocations.get(0);
        java.net.Socket socketDeallocate = deallocate(true, false, false);
        this.connection = realConnection;
        realConnection.allocations.add(reference);
        return socketDeallocate;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0046  */
    private java.net.Socket deallocate(boolean z, boolean z2, boolean z3) {
        java.net.Socket socket;
        if (z3) {
            this.codec = null;
        }
        if (z2) {
            this.released = true;
        }
        dc.squareup.okhttp3.internal.connection.RealConnection realConnection = this.connection;
        if (realConnection != null) {
            if (z) {
                realConnection.noNewStreams = true;
            }
            if (this.codec == null && (this.released || realConnection.noNewStreams)) {
                release(realConnection);
                if (this.connection.allocations.isEmpty()) {
                    this.connection.idleAtNanos = java.lang.System.nanoTime();
                    if (dc.squareup.okhttp3.internal.Internal.instance.connectionBecameIdle(this.connectionPool, this.connection)) {
                        socket = this.connection.socket();
                    } else {
                        socket = null;
                    }
                } else {
                    socket = null;
                }
                this.connection = null;
                return socket;
            }
        }
        return null;
    }

    private void release(dc.squareup.okhttp3.internal.connection.RealConnection realConnection) {
        int size = realConnection.allocations.size();
        for (int i = 0; i < size; i++) {
            if (realConnection.allocations.get(i).get() == this) {
                realConnection.allocations.remove(i);
                return;
            }
        }
        throw new java.lang.IllegalStateException();
    }
}
