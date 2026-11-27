package dc.squareup.okhttp3;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class Dispatcher {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private java.util.concurrent.ExecutorService executorService;
    private java.lang.Runnable idleCallback;
    private int maxRequests = 64;
    private int maxRequestsPerHost = 5;
    private final java.util.Deque<dc.squareup.okhttp3.RealCall.AsyncCall> readyAsyncCalls = new java.util.ArrayDeque();
    private final java.util.Deque<dc.squareup.okhttp3.RealCall.AsyncCall> runningAsyncCalls = new java.util.ArrayDeque();
    private final java.util.Deque<dc.squareup.okhttp3.RealCall> runningSyncCalls = new java.util.ArrayDeque();

    public Dispatcher(java.util.concurrent.ExecutorService executorService) {
        this.executorService = executorService;
    }

    private int runningCallsForHost(dc.squareup.okhttp3.RealCall.AsyncCall asyncCall) {
        int i = 0;
        for (dc.squareup.okhttp3.RealCall.AsyncCall asyncCall2 : this.runningAsyncCalls) {
            if (!asyncCall2.get().forWebSocket && asyncCall2.host().equals(asyncCall.host())) {
                i++;
            }
        }
        return i;
    }

    public synchronized void cancelAll() {
        java.util.Iterator<dc.squareup.okhttp3.RealCall.AsyncCall> it = this.readyAsyncCalls.iterator();
        while (it.hasNext()) {
            it.next().get().cancel();
        }
        java.util.Iterator<dc.squareup.okhttp3.RealCall.AsyncCall> it2 = this.runningAsyncCalls.iterator();
        while (it2.hasNext()) {
            it2.next().get().cancel();
        }
        java.util.Iterator<dc.squareup.okhttp3.RealCall> it3 = this.runningSyncCalls.iterator();
        while (it3.hasNext()) {
            it3.next().cancel();
        }
    }

    void enqueue(dc.squareup.okhttp3.RealCall.AsyncCall asyncCall) {
        synchronized (this) {
            this.readyAsyncCalls.add(asyncCall);
        }
        promoteAndExecute();
    }

    synchronized void executed(dc.squareup.okhttp3.RealCall realCall) {
        this.runningSyncCalls.add(realCall);
    }

    public synchronized java.util.concurrent.ExecutorService executorService() {
        if (this.executorService == null) {
            this.executorService = new java.util.concurrent.ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.SynchronousQueue(), dc.squareup.okhttp3.internal.Util.threadFactory("OkHttp Dispatcher", false));
        }
        return this.executorService;
    }

    void finished(dc.squareup.okhttp3.RealCall.AsyncCall asyncCall) {
        finished(this.runningAsyncCalls, asyncCall);
    }

    public synchronized int getMaxRequests() {
        return this.maxRequests;
    }

    public synchronized int getMaxRequestsPerHost() {
        return this.maxRequestsPerHost;
    }

    public synchronized java.util.List<dc.squareup.okhttp3.Call> queuedCalls() {
        java.util.ArrayList arrayList;
        arrayList = new java.util.ArrayList();
        java.util.Iterator<dc.squareup.okhttp3.RealCall.AsyncCall> it = this.readyAsyncCalls.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().get());
        }
        return java.util.Collections.unmodifiableList(arrayList);
    }

    public synchronized int queuedCallsCount() {
        return this.readyAsyncCalls.size();
    }

    public synchronized java.util.List<dc.squareup.okhttp3.Call> runningCalls() {
        java.util.ArrayList arrayList;
        arrayList = new java.util.ArrayList();
        arrayList.addAll(this.runningSyncCalls);
        java.util.Iterator<dc.squareup.okhttp3.RealCall.AsyncCall> it = this.runningAsyncCalls.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().get());
        }
        return java.util.Collections.unmodifiableList(arrayList);
    }

    public synchronized int runningCallsCount() {
        return this.runningAsyncCalls.size() + this.runningSyncCalls.size();
    }

    public synchronized void setIdleCallback(java.lang.Runnable runnable) {
        this.idleCallback = runnable;
    }

    public void setMaxRequests(int i) {
        if (i < 1) {
            throw new java.lang.IllegalArgumentException("max < 1: " + i);
        }
        synchronized (this) {
            this.maxRequests = i;
        }
        promoteAndExecute();
    }

    public void setMaxRequestsPerHost(int i) {
        if (i < 1) {
            throw new java.lang.IllegalArgumentException("max < 1: " + i);
        }
        synchronized (this) {
            this.maxRequestsPerHost = i;
        }
        promoteAndExecute();
    }

    void finished(dc.squareup.okhttp3.RealCall realCall) {
        finished(this.runningSyncCalls, realCall);
    }

    private <T> void finished(java.util.Deque<T> deque, T t) {
        java.lang.Runnable runnable;
        synchronized (this) {
            if (deque.remove(t)) {
                runnable = this.idleCallback;
            } else {
                throw new java.lang.AssertionError("Call wasn't in-flight!");
            }
        }
        if (promoteAndExecute() || runnable == null) {
            return;
        }
        runnable.run();
    }

    private boolean promoteAndExecute() {
        int i;
        boolean z;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        synchronized (this) {
            java.util.Iterator<dc.squareup.okhttp3.RealCall.AsyncCall> it = this.readyAsyncCalls.iterator();
            while (it.hasNext()) {
                dc.squareup.okhttp3.RealCall.AsyncCall next = it.next();
                if (this.runningAsyncCalls.size() >= this.maxRequests) {
                    break;
                }
                if (runningCallsForHost(next) < this.maxRequestsPerHost) {
                    it.remove();
                    arrayList.add(next);
                    this.runningAsyncCalls.add(next);
                }
            }
            z = runningCallsCount() > 0;
        }
        int size = arrayList.size();
        for (i = 0; i < size; i++) {
            ((dc.squareup.okhttp3.RealCall.AsyncCall) arrayList.get(i)).executeOn(executorService());
        }
        return z;
    }

    public Dispatcher() {
    }
}
