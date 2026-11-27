package dc.squareup.okio;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class AsyncTimeout extends dc.squareup.okio.Timeout {
    private static final long IDLE_TIMEOUT_MILLIS;
    private static final long IDLE_TIMEOUT_NANOS;
    private static final int TIMEOUT_WRITE_SIZE = 65536;
    static dc.squareup.okio.AsyncTimeout head;
    private boolean inQueue;
    private dc.squareup.okio.AsyncTimeout next;
    private long timeoutAt;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    private static final class Watchdog extends java.lang.Thread {
        Watchdog() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0015, code lost:
        
            r1.timedOut();
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                r3 = this;
            L0:
                java.lang.Class<dc.squareup.okio.AsyncTimeout> r0 = dc.squareup.okio.AsyncTimeout.class
                monitor-enter(r0)     // Catch: java.lang.InterruptedException -> L0
                dc.squareup.okio.AsyncTimeout r1 = dc.squareup.okio.AsyncTimeout.awaitTimeout()     // Catch: java.lang.Throwable -> L19
                if (r1 != 0) goto Lb
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                goto L0
            Lb:
                dc.squareup.okio.AsyncTimeout r2 = dc.squareup.okio.AsyncTimeout.head     // Catch: java.lang.Throwable -> L19
                if (r1 != r2) goto L14
                r1 = 0
                dc.squareup.okio.AsyncTimeout.head = r1     // Catch: java.lang.Throwable -> L19
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                return
            L14:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                r1.timedOut()     // Catch: java.lang.InterruptedException -> L0
                goto L0
            L19:
                r1 = move-exception
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: dc.squareup.okio.AsyncTimeout.Watchdog.run():void");
        }
    }

    static {
        long millis = java.util.concurrent.TimeUnit.SECONDS.toMillis(60L);
        IDLE_TIMEOUT_MILLIS = millis;
        IDLE_TIMEOUT_NANOS = java.util.concurrent.TimeUnit.MILLISECONDS.toNanos(millis);
    }

    static dc.squareup.okio.AsyncTimeout awaitTimeout() throws java.lang.InterruptedException {
        dc.squareup.okio.AsyncTimeout asyncTimeout = head.next;
        if (asyncTimeout == null) {
            long jNanoTime = java.lang.System.nanoTime();
            dc.squareup.okio.AsyncTimeout.class.wait(IDLE_TIMEOUT_MILLIS);
            if (head.next != null || java.lang.System.nanoTime() - jNanoTime < IDLE_TIMEOUT_NANOS) {
                return null;
            }
            return head;
        }
        long jRemainingNanos = asyncTimeout.remainingNanos(java.lang.System.nanoTime());
        if (jRemainingNanos > 0) {
            long j = jRemainingNanos / 1000000;
            dc.squareup.okio.AsyncTimeout.class.wait(j, (int) (jRemainingNanos - (1000000 * j)));
            return null;
        }
        head.next = asyncTimeout.next;
        asyncTimeout.next = null;
        return asyncTimeout;
    }

    private static synchronized boolean cancelScheduledTimeout(dc.squareup.okio.AsyncTimeout asyncTimeout) {
        dc.squareup.okio.AsyncTimeout asyncTimeout2 = head;
        while (asyncTimeout2 != null) {
            dc.squareup.okio.AsyncTimeout asyncTimeout3 = asyncTimeout2.next;
            if (asyncTimeout3 == asyncTimeout) {
                asyncTimeout2.next = asyncTimeout.next;
                asyncTimeout.next = null;
                return false;
            }
            asyncTimeout2 = asyncTimeout3;
        }
        return true;
    }

    private long remainingNanos(long j) {
        return this.timeoutAt - j;
    }

    private static synchronized void scheduleTimeout(dc.squareup.okio.AsyncTimeout asyncTimeout, long j, boolean z) {
        if (head == null) {
            head = new dc.squareup.okio.AsyncTimeout();
            new dc.squareup.okio.AsyncTimeout.Watchdog().start();
        }
        long jNanoTime = java.lang.System.nanoTime();
        if (j != 0 && z) {
            asyncTimeout.timeoutAt = java.lang.Math.min(j, asyncTimeout.deadlineNanoTime() - jNanoTime) + jNanoTime;
        } else if (j != 0) {
            asyncTimeout.timeoutAt = j + jNanoTime;
        } else {
            if (!z) {
                throw new java.lang.AssertionError();
            }
            asyncTimeout.timeoutAt = asyncTimeout.deadlineNanoTime();
        }
        long jRemainingNanos = asyncTimeout.remainingNanos(jNanoTime);
        dc.squareup.okio.AsyncTimeout asyncTimeout2 = head;
        while (true) {
            dc.squareup.okio.AsyncTimeout asyncTimeout3 = asyncTimeout2.next;
            if (asyncTimeout3 == null || jRemainingNanos < asyncTimeout3.remainingNanos(jNanoTime)) {
                break;
                break;
            }
            asyncTimeout2 = asyncTimeout2.next;
        }
        asyncTimeout.next = asyncTimeout2.next;
        asyncTimeout2.next = asyncTimeout;
        if (asyncTimeout2 == head) {
            dc.squareup.okio.AsyncTimeout.class.notify();
        }
    }

    public final void enter() {
        if (this.inQueue) {
            throw new java.lang.IllegalStateException("Unbalanced enter/exit");
        }
        long jTimeoutNanos = timeoutNanos();
        boolean zHasDeadline = hasDeadline();
        if (jTimeoutNanos != 0 || zHasDeadline) {
            this.inQueue = true;
            scheduleTimeout(this, jTimeoutNanos, zHasDeadline);
        }
    }

    public final boolean exit() {
        if (!this.inQueue) {
            return false;
        }
        this.inQueue = false;
        return cancelScheduledTimeout(this);
    }

    protected java.io.IOException newTimeoutException(java.io.IOException iOException) {
        java.io.InterruptedIOException interruptedIOException = new java.io.InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public final dc.squareup.okio.Sink sink(final dc.squareup.okio.Sink sink) {
        return new dc.squareup.okio.Sink() { // from class: dc.squareup.okio.AsyncTimeout.1
            @Override // dc.squareup.okio.Sink, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws java.io.IOException {
                dc.squareup.okio.AsyncTimeout.this.enter();
                try {
                    try {
                        sink.close();
                        dc.squareup.okio.AsyncTimeout.this.exit(true);
                    } catch (java.io.IOException e) {
                        throw dc.squareup.okio.AsyncTimeout.this.exit(e);
                    }
                } catch (java.lang.Throwable th) {
                    dc.squareup.okio.AsyncTimeout.this.exit(false);
                    throw th;
                }
            }

            @Override // dc.squareup.okio.Sink, java.io.Flushable
            public void flush() throws java.io.IOException {
                dc.squareup.okio.AsyncTimeout.this.enter();
                try {
                    try {
                        sink.flush();
                        dc.squareup.okio.AsyncTimeout.this.exit(true);
                    } catch (java.io.IOException e) {
                        throw dc.squareup.okio.AsyncTimeout.this.exit(e);
                    }
                } catch (java.lang.Throwable th) {
                    dc.squareup.okio.AsyncTimeout.this.exit(false);
                    throw th;
                }
            }

            @Override // dc.squareup.okio.Sink
            public dc.squareup.okio.Timeout timeout() {
                return dc.squareup.okio.AsyncTimeout.this;
            }

            public java.lang.String toString() {
                return "AsyncTimeout.sink(" + sink + com.taobao.weex.el.parse.Operators.BRACKET_END_STR;
            }

            @Override // dc.squareup.okio.Sink
            public void write(dc.squareup.okio.Buffer buffer, long j) throws java.io.IOException {
                dc.squareup.okio.Util.checkOffsetAndCount(buffer.size, 0L, j);
                while (true) {
                    long j2 = 0;
                    if (j <= 0) {
                        return;
                    }
                    dc.squareup.okio.Segment segment = buffer.head;
                    while (j2 < tv.danmaku.ijk.media.player.IjkMediaMeta.AV_CH_TOP_BACK_CENTER) {
                        j2 += (long) (segment.limit - segment.pos);
                        if (j2 >= j) {
                            j2 = j;
                            break;
                        }
                        segment = segment.next;
                    }
                    dc.squareup.okio.AsyncTimeout.this.enter();
                    try {
                        try {
                            sink.write(buffer, j2);
                            j -= j2;
                            dc.squareup.okio.AsyncTimeout.this.exit(true);
                        } catch (java.io.IOException e) {
                            throw dc.squareup.okio.AsyncTimeout.this.exit(e);
                        }
                    } catch (java.lang.Throwable th) {
                        dc.squareup.okio.AsyncTimeout.this.exit(false);
                        throw th;
                    }
                }
            }
        };
    }

    public final dc.squareup.okio.Source source(final dc.squareup.okio.Source source) {
        return new dc.squareup.okio.Source() { // from class: dc.squareup.okio.AsyncTimeout.2
            @Override // dc.squareup.okio.Source, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws java.io.IOException {
                dc.squareup.okio.AsyncTimeout.this.enter();
                try {
                    try {
                        source.close();
                        dc.squareup.okio.AsyncTimeout.this.exit(true);
                    } catch (java.io.IOException e) {
                        throw dc.squareup.okio.AsyncTimeout.this.exit(e);
                    }
                } catch (java.lang.Throwable th) {
                    dc.squareup.okio.AsyncTimeout.this.exit(false);
                    throw th;
                }
            }

            @Override // dc.squareup.okio.Source
            public long read(dc.squareup.okio.Buffer buffer, long j) throws java.io.IOException {
                dc.squareup.okio.AsyncTimeout.this.enter();
                try {
                    try {
                        long j2 = source.read(buffer, j);
                        dc.squareup.okio.AsyncTimeout.this.exit(true);
                        return j2;
                    } catch (java.io.IOException e) {
                        throw dc.squareup.okio.AsyncTimeout.this.exit(e);
                    }
                } catch (java.lang.Throwable th) {
                    dc.squareup.okio.AsyncTimeout.this.exit(false);
                    throw th;
                }
            }

            @Override // dc.squareup.okio.Source
            public dc.squareup.okio.Timeout timeout() {
                return dc.squareup.okio.AsyncTimeout.this;
            }

            public java.lang.String toString() {
                return "AsyncTimeout.source(" + source + com.taobao.weex.el.parse.Operators.BRACKET_END_STR;
            }
        };
    }

    protected void timedOut() {
    }

    final void exit(boolean z) throws java.io.IOException {
        if (exit() && z) {
            throw newTimeoutException(null);
        }
    }

    final java.io.IOException exit(java.io.IOException iOException) throws java.io.IOException {
        return !exit() ? iOException : newTimeoutException(iOException);
    }
}
