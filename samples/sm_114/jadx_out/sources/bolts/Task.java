package bolts;

/* JADX INFO: loaded from: classes.dex */
public class Task<TResult> {
    private static volatile bolts.Task.UnobservedExceptionHandler unobservedExceptionHandler;
    private boolean cancelled;
    private boolean complete;
    private java.lang.Exception error;
    private boolean errorHasBeenObserved;
    private TResult result;
    private bolts.UnobservedErrorNotifier unobservedErrorNotifier;
    public static final java.util.concurrent.ExecutorService BACKGROUND_EXECUTOR = bolts.BoltsExecutors.background();
    private static final java.util.concurrent.Executor IMMEDIATE_EXECUTOR = bolts.BoltsExecutors.immediate();
    public static final java.util.concurrent.Executor UI_THREAD_EXECUTOR = bolts.AndroidExecutors.uiThread();
    private static bolts.Task<?> TASK_NULL = new bolts.Task<>((java.lang.Object) null);
    private static bolts.Task<java.lang.Boolean> TASK_TRUE = new bolts.Task<>(true);
    private static bolts.Task<java.lang.Boolean> TASK_FALSE = new bolts.Task<>(false);
    private static bolts.Task<?> TASK_CANCELLED = new bolts.Task<>(true);
    private final java.lang.Object lock = new java.lang.Object();
    private java.util.List<bolts.Continuation<TResult, java.lang.Void>> continuations = new java.util.ArrayList();

    public interface UnobservedExceptionHandler {
        void unobservedException(bolts.Task<?> task, bolts.UnobservedTaskException unobservedTaskException);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <TOut> bolts.Task<TOut> cast() {
        return this;
    }

    public static bolts.Task.UnobservedExceptionHandler getUnobservedExceptionHandler() {
        return unobservedExceptionHandler;
    }

    public static void setUnobservedExceptionHandler(bolts.Task.UnobservedExceptionHandler unobservedExceptionHandler2) {
        unobservedExceptionHandler = unobservedExceptionHandler2;
    }

    Task() {
    }

    private Task(TResult tresult) {
        trySetResult(tresult);
    }

    private Task(boolean z) {
        if (z) {
            trySetCancelled();
        } else {
            trySetResult(null);
        }
    }

    public static <TResult> bolts.Task<TResult>.TaskCompletionSource create() {
        return new bolts.Task.TaskCompletionSource();
    }

    public boolean isCompleted() {
        boolean z;
        synchronized (this.lock) {
            z = this.complete;
        }
        return z;
    }

    public boolean isCancelled() {
        boolean z;
        synchronized (this.lock) {
            z = this.cancelled;
        }
        return z;
    }

    public boolean isFaulted() {
        boolean z;
        synchronized (this.lock) {
            z = getError() != null;
        }
        return z;
    }

    public TResult getResult() {
        TResult tresult;
        synchronized (this.lock) {
            tresult = this.result;
        }
        return tresult;
    }

    public java.lang.Exception getError() {
        java.lang.Exception exc;
        synchronized (this.lock) {
            if (this.error != null) {
                this.errorHasBeenObserved = true;
                bolts.UnobservedErrorNotifier unobservedErrorNotifier = this.unobservedErrorNotifier;
                if (unobservedErrorNotifier != null) {
                    unobservedErrorNotifier.setObserved();
                    this.unobservedErrorNotifier = null;
                }
            }
            exc = this.error;
        }
        return exc;
    }

    public void waitForCompletion() throws java.lang.InterruptedException {
        synchronized (this.lock) {
            if (!isCompleted()) {
                this.lock.wait();
            }
        }
    }

    public boolean waitForCompletion(long j, java.util.concurrent.TimeUnit timeUnit) throws java.lang.InterruptedException {
        boolean zIsCompleted;
        synchronized (this.lock) {
            if (!isCompleted()) {
                this.lock.wait(timeUnit.toMillis(j));
            }
            zIsCompleted = isCompleted();
        }
        return zIsCompleted;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <TResult> bolts.Task<TResult> forResult(TResult tresult) {
        if (tresult == 0) {
            return (bolts.Task<TResult>) TASK_NULL;
        }
        if (tresult instanceof java.lang.Boolean) {
            return ((java.lang.Boolean) tresult).booleanValue() ? (bolts.Task<TResult>) TASK_TRUE : (bolts.Task<TResult>) TASK_FALSE;
        }
        bolts.TaskCompletionSource taskCompletionSource = new bolts.TaskCompletionSource();
        taskCompletionSource.setResult(tresult);
        return taskCompletionSource.getTask();
    }

    public static <TResult> bolts.Task<TResult> forError(java.lang.Exception exc) {
        bolts.TaskCompletionSource taskCompletionSource = new bolts.TaskCompletionSource();
        taskCompletionSource.setError(exc);
        return taskCompletionSource.getTask();
    }

    public static <TResult> bolts.Task<TResult> cancelled() {
        return (bolts.Task<TResult>) TASK_CANCELLED;
    }

    public static bolts.Task<java.lang.Void> delay(long j) {
        return delay(j, bolts.BoltsExecutors.scheduled(), null);
    }

    public static bolts.Task<java.lang.Void> delay(long j, bolts.CancellationToken cancellationToken) {
        return delay(j, bolts.BoltsExecutors.scheduled(), cancellationToken);
    }

    static bolts.Task<java.lang.Void> delay(long j, java.util.concurrent.ScheduledExecutorService scheduledExecutorService, bolts.CancellationToken cancellationToken) {
        if (cancellationToken != null && cancellationToken.isCancellationRequested()) {
            return cancelled();
        }
        if (j <= 0) {
            return forResult(null);
        }
        final bolts.TaskCompletionSource taskCompletionSource = new bolts.TaskCompletionSource();
        final java.util.concurrent.ScheduledFuture<?> scheduledFutureSchedule = scheduledExecutorService.schedule(new java.lang.Runnable() { // from class: bolts.Task.1
            @Override // java.lang.Runnable
            public void run() {
                taskCompletionSource.trySetResult(null);
            }
        }, j, java.util.concurrent.TimeUnit.MILLISECONDS);
        if (cancellationToken != null) {
            cancellationToken.register(new java.lang.Runnable() { // from class: bolts.Task.2
                @Override // java.lang.Runnable
                public void run() {
                    scheduledFutureSchedule.cancel(true);
                    taskCompletionSource.trySetCancelled();
                }
            });
        }
        return taskCompletionSource.getTask();
    }

    public bolts.Task<java.lang.Void> makeVoid() {
        return continueWithTask(new bolts.Continuation<TResult, bolts.Task<java.lang.Void>>() { // from class: bolts.Task.3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // bolts.Continuation
            public bolts.Task<java.lang.Void> then(bolts.Task<TResult> task) throws java.lang.Exception {
                if (task.isCancelled()) {
                    return bolts.Task.cancelled();
                }
                if (task.isFaulted()) {
                    return bolts.Task.forError(task.getError());
                }
                return bolts.Task.forResult(null);
            }
        });
    }

    public static <TResult> bolts.Task<TResult> callInBackground(java.util.concurrent.Callable<TResult> callable) {
        return call(callable, BACKGROUND_EXECUTOR, null);
    }

    public static <TResult> bolts.Task<TResult> callInBackground(java.util.concurrent.Callable<TResult> callable, bolts.CancellationToken cancellationToken) {
        return call(callable, BACKGROUND_EXECUTOR, cancellationToken);
    }

    public static <TResult> bolts.Task<TResult> call(java.util.concurrent.Callable<TResult> callable, java.util.concurrent.Executor executor) {
        return call(callable, executor, null);
    }

    public static <TResult> bolts.Task<TResult> call(final java.util.concurrent.Callable<TResult> callable, java.util.concurrent.Executor executor, final bolts.CancellationToken cancellationToken) {
        final bolts.TaskCompletionSource taskCompletionSource = new bolts.TaskCompletionSource();
        try {
            executor.execute(new java.lang.Runnable() { // from class: bolts.Task.4
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    bolts.CancellationToken cancellationToken2 = cancellationToken;
                    if (cancellationToken2 != null && cancellationToken2.isCancellationRequested()) {
                        taskCompletionSource.setCancelled();
                        return;
                    }
                    try {
                        taskCompletionSource.setResult(callable.call());
                    } catch (java.util.concurrent.CancellationException unused) {
                        taskCompletionSource.setCancelled();
                    } catch (java.lang.Exception e) {
                        taskCompletionSource.setError(e);
                    }
                }
            });
        } catch (java.lang.Exception e) {
            taskCompletionSource.setError(new bolts.ExecutorException(e));
        }
        return taskCompletionSource.getTask();
    }

    public static <TResult> bolts.Task<TResult> call(java.util.concurrent.Callable<TResult> callable) {
        return call(callable, IMMEDIATE_EXECUTOR, null);
    }

    public static <TResult> bolts.Task<TResult> call(java.util.concurrent.Callable<TResult> callable, bolts.CancellationToken cancellationToken) {
        return call(callable, IMMEDIATE_EXECUTOR, cancellationToken);
    }

    public static <TResult> bolts.Task<bolts.Task<TResult>> whenAnyResult(java.util.Collection<? extends bolts.Task<TResult>> collection) {
        if (collection.size() == 0) {
            return forResult(null);
        }
        final bolts.TaskCompletionSource taskCompletionSource = new bolts.TaskCompletionSource();
        final java.util.concurrent.atomic.AtomicBoolean atomicBoolean = new java.util.concurrent.atomic.AtomicBoolean(false);
        java.util.Iterator<? extends bolts.Task<TResult>> it = collection.iterator();
        while (it.hasNext()) {
            it.next().continueWith(new bolts.Continuation<TResult, java.lang.Void>() { // from class: bolts.Task.5
                @Override // bolts.Continuation
                public java.lang.Void then(bolts.Task<TResult> task) {
                    if (atomicBoolean.compareAndSet(false, true)) {
                        taskCompletionSource.setResult(task);
                        return null;
                    }
                    task.getError();
                    return null;
                }
            });
        }
        return taskCompletionSource.getTask();
    }

    public static bolts.Task<bolts.Task<?>> whenAny(java.util.Collection<? extends bolts.Task<?>> collection) {
        if (collection.size() == 0) {
            return forResult(null);
        }
        final bolts.TaskCompletionSource taskCompletionSource = new bolts.TaskCompletionSource();
        final java.util.concurrent.atomic.AtomicBoolean atomicBoolean = new java.util.concurrent.atomic.AtomicBoolean(false);
        java.util.Iterator<? extends bolts.Task<?>> it = collection.iterator();
        while (it.hasNext()) {
            it.next().continueWith(new bolts.Continuation<java.lang.Object, java.lang.Void>() { // from class: bolts.Task.6
                @Override // bolts.Continuation
                public java.lang.Void then(bolts.Task<java.lang.Object> task) {
                    if (atomicBoolean.compareAndSet(false, true)) {
                        taskCompletionSource.setResult(task);
                        return null;
                    }
                    task.getError();
                    return null;
                }
            });
        }
        return taskCompletionSource.getTask();
    }

    public static <TResult> bolts.Task<java.util.List<TResult>> whenAllResult(final java.util.Collection<? extends bolts.Task<TResult>> collection) {
        return (bolts.Task<java.util.List<TResult>>) whenAll(collection).onSuccess(new bolts.Continuation<java.lang.Void, java.util.List<TResult>>() { // from class: bolts.Task.7
            @Override // bolts.Continuation
            public java.util.List<TResult> then(bolts.Task<java.lang.Void> task) throws java.lang.Exception {
                if (collection.size() == 0) {
                    return java.util.Collections.EMPTY_LIST;
                }
                java.util.ArrayList arrayList = new java.util.ArrayList();
                java.util.Iterator it = collection.iterator();
                while (it.hasNext()) {
                    arrayList.add(((bolts.Task) it.next()).getResult());
                }
                return arrayList;
            }
        });
    }

    public static bolts.Task<java.lang.Void> whenAll(java.util.Collection<? extends bolts.Task<?>> collection) {
        if (collection.size() == 0) {
            return forResult(null);
        }
        final bolts.TaskCompletionSource taskCompletionSource = new bolts.TaskCompletionSource();
        final java.util.ArrayList arrayList = new java.util.ArrayList();
        final java.lang.Object obj = new java.lang.Object();
        final java.util.concurrent.atomic.AtomicInteger atomicInteger = new java.util.concurrent.atomic.AtomicInteger(collection.size());
        final java.util.concurrent.atomic.AtomicBoolean atomicBoolean = new java.util.concurrent.atomic.AtomicBoolean(false);
        java.util.Iterator<? extends bolts.Task<?>> it = collection.iterator();
        while (it.hasNext()) {
            it.next().continueWith(new bolts.Continuation<java.lang.Object, java.lang.Void>() { // from class: bolts.Task.8
                @Override // bolts.Continuation
                public java.lang.Void then(bolts.Task<java.lang.Object> task) {
                    if (task.isFaulted()) {
                        synchronized (obj) {
                            arrayList.add(task.getError());
                        }
                    }
                    if (task.isCancelled()) {
                        atomicBoolean.set(true);
                    }
                    if (atomicInteger.decrementAndGet() == 0) {
                        if (arrayList.size() != 0) {
                            if (arrayList.size() == 1) {
                                taskCompletionSource.setError((java.lang.Exception) arrayList.get(0));
                            } else {
                                taskCompletionSource.setError(new bolts.AggregateException(java.lang.String.format("There were %d exceptions.", java.lang.Integer.valueOf(arrayList.size())), arrayList));
                            }
                        } else if (atomicBoolean.get()) {
                            taskCompletionSource.setCancelled();
                        } else {
                            taskCompletionSource.setResult(null);
                        }
                    }
                    return null;
                }
            });
        }
        return taskCompletionSource.getTask();
    }

    public bolts.Task<java.lang.Void> continueWhile(java.util.concurrent.Callable<java.lang.Boolean> callable, bolts.Continuation<java.lang.Void, bolts.Task<java.lang.Void>> continuation) {
        return continueWhile(callable, continuation, IMMEDIATE_EXECUTOR, null);
    }

    public bolts.Task<java.lang.Void> continueWhile(java.util.concurrent.Callable<java.lang.Boolean> callable, bolts.Continuation<java.lang.Void, bolts.Task<java.lang.Void>> continuation, bolts.CancellationToken cancellationToken) {
        return continueWhile(callable, continuation, IMMEDIATE_EXECUTOR, cancellationToken);
    }

    public bolts.Task<java.lang.Void> continueWhile(java.util.concurrent.Callable<java.lang.Boolean> callable, bolts.Continuation<java.lang.Void, bolts.Task<java.lang.Void>> continuation, java.util.concurrent.Executor executor) {
        return continueWhile(callable, continuation, executor, null);
    }

    public bolts.Task<java.lang.Void> continueWhile(final java.util.concurrent.Callable<java.lang.Boolean> callable, final bolts.Continuation<java.lang.Void, bolts.Task<java.lang.Void>> continuation, final java.util.concurrent.Executor executor, final bolts.CancellationToken cancellationToken) {
        final bolts.Capture capture = new bolts.Capture();
        capture.set(new bolts.Continuation<java.lang.Void, bolts.Task<java.lang.Void>>() { // from class: bolts.Task.9
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // bolts.Continuation
            public bolts.Task<java.lang.Void> then(bolts.Task<java.lang.Void> task) throws java.lang.Exception {
                bolts.CancellationToken cancellationToken2 = cancellationToken;
                if (cancellationToken2 != null && cancellationToken2.isCancellationRequested()) {
                    return bolts.Task.cancelled();
                }
                if (((java.lang.Boolean) callable.call()).booleanValue()) {
                    return bolts.Task.forResult(null).onSuccessTask(continuation, executor).onSuccessTask((bolts.Continuation) capture.get(), executor);
                }
                return bolts.Task.forResult(null);
            }
        });
        return makeVoid().continueWithTask((bolts.Continuation<java.lang.Void, bolts.Task<TContinuationResult>>) capture.get(), executor);
    }

    public <TContinuationResult> bolts.Task<TContinuationResult> continueWith(bolts.Continuation<TResult, TContinuationResult> continuation, java.util.concurrent.Executor executor) {
        return continueWith(continuation, executor, null);
    }

    public <TContinuationResult> bolts.Task<TContinuationResult> continueWith(bolts.Continuation<TResult, TContinuationResult> continuation, java.util.concurrent.Executor executor, bolts.CancellationToken cancellationToken) throws java.lang.Throwable {
        final bolts.Continuation<TResult, TContinuationResult> continuation2;
        final java.util.concurrent.Executor executor2;
        final bolts.CancellationToken cancellationToken2;
        final bolts.TaskCompletionSource taskCompletionSource = new bolts.TaskCompletionSource();
        synchronized (this.lock) {
            try {
                try {
                    boolean zIsCompleted = isCompleted();
                    if (zIsCompleted) {
                        continuation2 = continuation;
                        executor2 = executor;
                        cancellationToken2 = cancellationToken;
                    } else {
                        continuation2 = continuation;
                        executor2 = executor;
                        cancellationToken2 = cancellationToken;
                        this.continuations.add(new bolts.Continuation<TResult, java.lang.Void>() { // from class: bolts.Task.10
                            @Override // bolts.Continuation
                            public java.lang.Void then(bolts.Task<TResult> task) {
                                bolts.Task.completeImmediately(taskCompletionSource, continuation2, task, executor2, cancellationToken2);
                                return null;
                            }
                        });
                    }
                    if (zIsCompleted) {
                        completeImmediately(taskCompletionSource, continuation2, this, executor2, cancellationToken2);
                    }
                    return taskCompletionSource.getTask();
                } catch (java.lang.Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                throw th;
            }
        }
    }

    public <TContinuationResult> bolts.Task<TContinuationResult> continueWith(bolts.Continuation<TResult, TContinuationResult> continuation) {
        return continueWith(continuation, IMMEDIATE_EXECUTOR, null);
    }

    public <TContinuationResult> bolts.Task<TContinuationResult> continueWith(bolts.Continuation<TResult, TContinuationResult> continuation, bolts.CancellationToken cancellationToken) {
        return continueWith(continuation, IMMEDIATE_EXECUTOR, cancellationToken);
    }

    public <TContinuationResult> bolts.Task<TContinuationResult> continueWithTask(bolts.Continuation<TResult, bolts.Task<TContinuationResult>> continuation, java.util.concurrent.Executor executor) {
        return continueWithTask(continuation, executor, null);
    }

    public <TContinuationResult> bolts.Task<TContinuationResult> continueWithTask(bolts.Continuation<TResult, bolts.Task<TContinuationResult>> continuation, java.util.concurrent.Executor executor, bolts.CancellationToken cancellationToken) throws java.lang.Throwable {
        final bolts.Continuation<TResult, bolts.Task<TContinuationResult>> continuation2;
        final java.util.concurrent.Executor executor2;
        final bolts.CancellationToken cancellationToken2;
        final bolts.TaskCompletionSource taskCompletionSource = new bolts.TaskCompletionSource();
        synchronized (this.lock) {
            try {
                try {
                    boolean zIsCompleted = isCompleted();
                    if (zIsCompleted) {
                        continuation2 = continuation;
                        executor2 = executor;
                        cancellationToken2 = cancellationToken;
                    } else {
                        continuation2 = continuation;
                        executor2 = executor;
                        cancellationToken2 = cancellationToken;
                        this.continuations.add(new bolts.Continuation<TResult, java.lang.Void>() { // from class: bolts.Task.11
                            @Override // bolts.Continuation
                            public java.lang.Void then(bolts.Task<TResult> task) {
                                bolts.Task.completeAfterTask(taskCompletionSource, continuation2, task, executor2, cancellationToken2);
                                return null;
                            }
                        });
                    }
                    if (zIsCompleted) {
                        completeAfterTask(taskCompletionSource, continuation2, this, executor2, cancellationToken2);
                    }
                    return taskCompletionSource.getTask();
                } catch (java.lang.Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                throw th;
            }
        }
    }

    public <TContinuationResult> bolts.Task<TContinuationResult> continueWithTask(bolts.Continuation<TResult, bolts.Task<TContinuationResult>> continuation) {
        return continueWithTask(continuation, IMMEDIATE_EXECUTOR, null);
    }

    public <TContinuationResult> bolts.Task<TContinuationResult> continueWithTask(bolts.Continuation<TResult, bolts.Task<TContinuationResult>> continuation, bolts.CancellationToken cancellationToken) {
        return continueWithTask(continuation, IMMEDIATE_EXECUTOR, cancellationToken);
    }

    public <TContinuationResult> bolts.Task<TContinuationResult> onSuccess(bolts.Continuation<TResult, TContinuationResult> continuation, java.util.concurrent.Executor executor) {
        return onSuccess(continuation, executor, null);
    }

    public <TContinuationResult> bolts.Task<TContinuationResult> onSuccess(final bolts.Continuation<TResult, TContinuationResult> continuation, java.util.concurrent.Executor executor, final bolts.CancellationToken cancellationToken) {
        return continueWithTask(new bolts.Continuation<TResult, bolts.Task<TContinuationResult>>() { // from class: bolts.Task.12
            @Override // bolts.Continuation
            public bolts.Task<TContinuationResult> then(bolts.Task<TResult> task) {
                bolts.CancellationToken cancellationToken2 = cancellationToken;
                if (cancellationToken2 != null && cancellationToken2.isCancellationRequested()) {
                    return bolts.Task.cancelled();
                }
                if (task.isFaulted()) {
                    return bolts.Task.forError(task.getError());
                }
                if (task.isCancelled()) {
                    return bolts.Task.cancelled();
                }
                return task.continueWith(continuation);
            }
        }, executor);
    }

    public <TContinuationResult> bolts.Task<TContinuationResult> onSuccess(bolts.Continuation<TResult, TContinuationResult> continuation) {
        return onSuccess(continuation, IMMEDIATE_EXECUTOR, null);
    }

    public <TContinuationResult> bolts.Task<TContinuationResult> onSuccess(bolts.Continuation<TResult, TContinuationResult> continuation, bolts.CancellationToken cancellationToken) {
        return onSuccess(continuation, IMMEDIATE_EXECUTOR, cancellationToken);
    }

    public <TContinuationResult> bolts.Task<TContinuationResult> onSuccessTask(bolts.Continuation<TResult, bolts.Task<TContinuationResult>> continuation, java.util.concurrent.Executor executor) {
        return onSuccessTask(continuation, executor, null);
    }

    public <TContinuationResult> bolts.Task<TContinuationResult> onSuccessTask(final bolts.Continuation<TResult, bolts.Task<TContinuationResult>> continuation, java.util.concurrent.Executor executor, final bolts.CancellationToken cancellationToken) {
        return continueWithTask(new bolts.Continuation<TResult, bolts.Task<TContinuationResult>>() { // from class: bolts.Task.13
            @Override // bolts.Continuation
            public bolts.Task<TContinuationResult> then(bolts.Task<TResult> task) {
                bolts.CancellationToken cancellationToken2 = cancellationToken;
                if (cancellationToken2 != null && cancellationToken2.isCancellationRequested()) {
                    return bolts.Task.cancelled();
                }
                if (task.isFaulted()) {
                    return bolts.Task.forError(task.getError());
                }
                if (task.isCancelled()) {
                    return bolts.Task.cancelled();
                }
                return task.continueWithTask(continuation);
            }
        }, executor);
    }

    public <TContinuationResult> bolts.Task<TContinuationResult> onSuccessTask(bolts.Continuation<TResult, bolts.Task<TContinuationResult>> continuation) {
        return onSuccessTask(continuation, IMMEDIATE_EXECUTOR);
    }

    public <TContinuationResult> bolts.Task<TContinuationResult> onSuccessTask(bolts.Continuation<TResult, bolts.Task<TContinuationResult>> continuation, bolts.CancellationToken cancellationToken) {
        return onSuccessTask(continuation, IMMEDIATE_EXECUTOR, cancellationToken);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <TContinuationResult, TResult> void completeImmediately(final bolts.TaskCompletionSource<TContinuationResult> taskCompletionSource, final bolts.Continuation<TResult, TContinuationResult> continuation, final bolts.Task<TResult> task, java.util.concurrent.Executor executor, final bolts.CancellationToken cancellationToken) {
        try {
            executor.execute(new java.lang.Runnable() { // from class: bolts.Task.14
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    bolts.CancellationToken cancellationToken2 = cancellationToken;
                    if (cancellationToken2 != null && cancellationToken2.isCancellationRequested()) {
                        taskCompletionSource.setCancelled();
                        return;
                    }
                    try {
                        taskCompletionSource.setResult(continuation.then(task));
                    } catch (java.util.concurrent.CancellationException unused) {
                        taskCompletionSource.setCancelled();
                    } catch (java.lang.Exception e) {
                        taskCompletionSource.setError(e);
                    }
                }
            });
        } catch (java.lang.Exception e) {
            taskCompletionSource.setError(new bolts.ExecutorException(e));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <TContinuationResult, TResult> void completeAfterTask(final bolts.TaskCompletionSource<TContinuationResult> taskCompletionSource, final bolts.Continuation<TResult, bolts.Task<TContinuationResult>> continuation, final bolts.Task<TResult> task, java.util.concurrent.Executor executor, final bolts.CancellationToken cancellationToken) {
        try {
            executor.execute(new java.lang.Runnable() { // from class: bolts.Task.15
                @Override // java.lang.Runnable
                public void run() {
                    bolts.CancellationToken cancellationToken2 = cancellationToken;
                    if (cancellationToken2 != null && cancellationToken2.isCancellationRequested()) {
                        taskCompletionSource.setCancelled();
                        return;
                    }
                    try {
                        bolts.Task task2 = (bolts.Task) continuation.then(task);
                        if (task2 == null) {
                            taskCompletionSource.setResult(null);
                        } else {
                            task2.continueWith(new bolts.Continuation<TContinuationResult, java.lang.Void>() { // from class: bolts.Task.15.1
                                @Override // bolts.Continuation
                                public java.lang.Void then(bolts.Task<TContinuationResult> task3) {
                                    if (cancellationToken != null && cancellationToken.isCancellationRequested()) {
                                        taskCompletionSource.setCancelled();
                                        return null;
                                    }
                                    if (task3.isCancelled()) {
                                        taskCompletionSource.setCancelled();
                                    } else if (task3.isFaulted()) {
                                        taskCompletionSource.setError(task3.getError());
                                    } else {
                                        taskCompletionSource.setResult(task3.getResult());
                                    }
                                    return null;
                                }
                            });
                        }
                    } catch (java.util.concurrent.CancellationException unused) {
                        taskCompletionSource.setCancelled();
                    } catch (java.lang.Exception e) {
                        taskCompletionSource.setError(e);
                    }
                }
            });
        } catch (java.lang.Exception e) {
            taskCompletionSource.setError(new bolts.ExecutorException(e));
        }
    }

    private void runContinuations() {
        synchronized (this.lock) {
            java.util.Iterator<bolts.Continuation<TResult, java.lang.Void>> it = this.continuations.iterator();
            while (it.hasNext()) {
                try {
                    it.next().then(this);
                } catch (java.lang.RuntimeException e) {
                    throw e;
                } catch (java.lang.Exception e2) {
                    throw new java.lang.RuntimeException(e2);
                }
            }
            this.continuations = null;
        }
    }

    boolean trySetCancelled() {
        synchronized (this.lock) {
            if (this.complete) {
                return false;
            }
            this.complete = true;
            this.cancelled = true;
            this.lock.notifyAll();
            runContinuations();
            return true;
        }
    }

    boolean trySetResult(TResult tresult) {
        synchronized (this.lock) {
            if (this.complete) {
                return false;
            }
            this.complete = true;
            this.result = tresult;
            this.lock.notifyAll();
            runContinuations();
            return true;
        }
    }

    boolean trySetError(java.lang.Exception exc) {
        synchronized (this.lock) {
            if (this.complete) {
                return false;
            }
            this.complete = true;
            this.error = exc;
            this.errorHasBeenObserved = false;
            this.lock.notifyAll();
            runContinuations();
            if (!this.errorHasBeenObserved && getUnobservedExceptionHandler() != null) {
                this.unobservedErrorNotifier = new bolts.UnobservedErrorNotifier(this);
            }
            return true;
        }
    }

    public class TaskCompletionSource extends bolts.TaskCompletionSource<TResult> {
        TaskCompletionSource() {
        }
    }
}
