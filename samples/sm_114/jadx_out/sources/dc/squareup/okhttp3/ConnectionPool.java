package dc.squareup.okhttp3;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class ConnectionPool {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final java.util.concurrent.Executor executor = new java.util.concurrent.ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.SynchronousQueue(), dc.squareup.okhttp3.internal.Util.threadFactory("OkHttp ConnectionPool", true));
    private final java.lang.Runnable cleanupRunnable;
    boolean cleanupRunning;
    private final java.util.Deque<dc.squareup.okhttp3.internal.connection.RealConnection> connections;
    private final long keepAliveDurationNs;
    private final int maxIdleConnections;
    final dc.squareup.okhttp3.internal.connection.RouteDatabase routeDatabase;

    public ConnectionPool() {
        this(5, 5L, java.util.concurrent.TimeUnit.MINUTES);
    }

    private int pruneAndGetAllocationCount(dc.squareup.okhttp3.internal.connection.RealConnection realConnection, long j) {
        java.util.List<java.lang.ref.Reference<dc.squareup.okhttp3.internal.connection.StreamAllocation>> list = realConnection.allocations;
        int i = 0;
        while (i < list.size()) {
            java.lang.ref.Reference<dc.squareup.okhttp3.internal.connection.StreamAllocation> reference = list.get(i);
            if (reference.get() != null) {
                i++;
            } else {
                dc.squareup.okhttp3.internal.platform.Platform.get().logCloseableLeak("A connection to " + realConnection.route().address().url() + " was leaked. Did you forget to close a response body?", ((dc.squareup.okhttp3.internal.connection.StreamAllocation.StreamAllocationReference) reference).callStackTrace);
                list.remove(i);
                realConnection.noNewStreams = true;
                if (list.isEmpty()) {
                    realConnection.idleAtNanos = j - this.keepAliveDurationNs;
                    return 0;
                }
            }
        }
        return list.size();
    }

    long cleanup(long j) {
        synchronized (this) {
            dc.squareup.okhttp3.internal.connection.RealConnection realConnection = null;
            long j2 = Long.MIN_VALUE;
            int i = 0;
            int i2 = 0;
            for (dc.squareup.okhttp3.internal.connection.RealConnection realConnection2 : this.connections) {
                if (pruneAndGetAllocationCount(realConnection2, j) > 0) {
                    i2++;
                } else {
                    i++;
                    long j3 = j - realConnection2.idleAtNanos;
                    if (j3 > j2) {
                        realConnection = realConnection2;
                        j2 = j3;
                    }
                }
            }
            long j4 = this.keepAliveDurationNs;
            if (j2 < j4 && i <= this.maxIdleConnections) {
                if (i > 0) {
                    return j4 - j2;
                }
                if (i2 > 0) {
                    return j4;
                }
                this.cleanupRunning = false;
                return -1L;
            }
            this.connections.remove(realConnection);
            dc.squareup.okhttp3.internal.Util.closeQuietly(realConnection.socket());
            return 0L;
        }
    }

    public synchronized int connectionCount() {
        return this.connections.size();
    }

    public void evictAll() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        synchronized (this) {
            java.util.Iterator<dc.squareup.okhttp3.internal.connection.RealConnection> it = this.connections.iterator();
            while (it.hasNext()) {
                dc.squareup.okhttp3.internal.connection.RealConnection next = it.next();
                if (next.allocations.isEmpty()) {
                    next.noNewStreams = true;
                    arrayList.add(next);
                    it.remove();
                }
            }
        }
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            java.lang.Object obj = arrayList.get(i);
            i++;
            dc.squareup.okhttp3.internal.Util.closeQuietly(((dc.squareup.okhttp3.internal.connection.RealConnection) obj).socket());
        }
    }

    public synchronized int idleConnectionCount() {
        int i;
        java.util.Iterator<dc.squareup.okhttp3.internal.connection.RealConnection> it = this.connections.iterator();
        i = 0;
        while (it.hasNext()) {
            if (it.next().allocations.isEmpty()) {
                i++;
            }
        }
        return i;
    }

    public ConnectionPool(int i, long j, java.util.concurrent.TimeUnit timeUnit) {
        this.cleanupRunnable = new java.lang.Runnable() { // from class: dc.squareup.okhttp3.ConnectionPool.1
            @Override // java.lang.Runnable
            public void run() {
                while (true) {
                    long jCleanup = dc.squareup.okhttp3.ConnectionPool.this.cleanup(java.lang.System.nanoTime());
                    if (jCleanup == -1) {
                        return;
                    }
                    if (jCleanup > 0) {
                        long j2 = jCleanup / 1000000;
                        long j3 = jCleanup - (1000000 * j2);
                        synchronized (dc.squareup.okhttp3.ConnectionPool.this) {
                            try {
                                dc.squareup.okhttp3.ConnectionPool.this.wait(j2, (int) j3);
                            } catch (java.lang.InterruptedException unused) {
                            }
                        }
                    }
                }
            }
        };
        this.connections = new java.util.ArrayDeque();
        this.routeDatabase = new dc.squareup.okhttp3.internal.connection.RouteDatabase();
        this.maxIdleConnections = i;
        this.keepAliveDurationNs = timeUnit.toNanos(j);
        if (j > 0) {
            return;
        }
        throw new java.lang.IllegalArgumentException("keepAliveDuration <= 0: " + j);
    }

    boolean connectionBecameIdle(dc.squareup.okhttp3.internal.connection.RealConnection realConnection) {
        if (realConnection.noNewStreams || this.maxIdleConnections == 0) {
            this.connections.remove(realConnection);
            return true;
        }
        notifyAll();
        return false;
    }

    java.net.Socket deduplicate(dc.squareup.okhttp3.Address address, dc.squareup.okhttp3.internal.connection.StreamAllocation streamAllocation) {
        for (dc.squareup.okhttp3.internal.connection.RealConnection realConnection : this.connections) {
            if (realConnection.isEligible(address, null) && realConnection.isMultiplexed() && realConnection != streamAllocation.connection()) {
                return streamAllocation.releaseAndAcquire(realConnection);
            }
        }
        return null;
    }

    dc.squareup.okhttp3.internal.connection.RealConnection get(dc.squareup.okhttp3.Address address, dc.squareup.okhttp3.internal.connection.StreamAllocation streamAllocation, dc.squareup.okhttp3.Route route) {
        for (dc.squareup.okhttp3.internal.connection.RealConnection realConnection : this.connections) {
            if (realConnection.isEligible(address, route)) {
                streamAllocation.acquire(realConnection, true);
                return realConnection;
            }
        }
        return null;
    }

    void put(dc.squareup.okhttp3.internal.connection.RealConnection realConnection) {
        if (!this.cleanupRunning) {
            this.cleanupRunning = true;
            executor.execute(this.cleanupRunnable);
        }
        this.connections.add(realConnection);
    }
}
