package kotlin.reflect.jvm.internal.impl.storage;

/* JADX INFO: loaded from: classes2.dex */
public class LockBasedStorageManager implements kotlin.reflect.jvm.internal.impl.storage.StorageManager {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final java.lang.String debugText;
    private final kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.ExceptionHandlingStrategy exceptionHandlingStrategy;
    protected final kotlin.reflect.jvm.internal.impl.storage.SimpleLock lock;
    private static final java.lang.String PACKAGE_NAME = kotlin.text.StringsKt.substringBeforeLast(kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.class.getCanonicalName(), com.taobao.weex.el.parse.Operators.DOT_STR, "");
    public static final kotlin.reflect.jvm.internal.impl.storage.StorageManager NO_LOCKS = new kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager("NO_LOCKS", kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.ExceptionHandlingStrategy.THROW, kotlin.reflect.jvm.internal.impl.storage.EmptySimpleLock.INSTANCE) { // from class: kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.1
        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            java.lang.String str = i != 1 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            java.lang.Object[] objArr = new java.lang.Object[i != 1 ? 3 : 2];
            if (i != 1) {
                objArr[0] = "source";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$1";
            }
            if (i != 1) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$1";
            } else {
                objArr[1] = "recursionDetectedDefault";
            }
            if (i != 1) {
                objArr[2] = "recursionDetectedDefault";
            }
            java.lang.String str2 = java.lang.String.format(str, objArr);
            if (i == 1) {
                throw new java.lang.IllegalStateException(str2);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager
        protected <K, V> kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.RecursionDetectedResult<V> recursionDetectedDefault(java.lang.String str, K k) {
            if (str == null) {
                $$$reportNull$$$0(0);
            }
            kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.RecursionDetectedResult<V> recursionDetectedResultFallThrough = kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.RecursionDetectedResult.fallThrough();
            if (recursionDetectedResultFallThrough == null) {
                $$$reportNull$$$0(1);
            }
            return recursionDetectedResultFallThrough;
        }
    };

    public interface ExceptionHandlingStrategy {
        public static final kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.ExceptionHandlingStrategy THROW = new kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.ExceptionHandlingStrategy() { // from class: kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.ExceptionHandlingStrategy.1
            private static /* synthetic */ void $$$reportNull$$$0(int i) {
                throw new java.lang.IllegalArgumentException(java.lang.String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "throwable", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$ExceptionHandlingStrategy$1", "handleException"));
            }

            @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.ExceptionHandlingStrategy
            public java.lang.RuntimeException handleException(java.lang.Throwable th) {
                if (th == null) {
                    $$$reportNull$$$0(0);
                }
                throw kotlin.reflect.jvm.internal.impl.utils.ExceptionUtilsKt.rethrow(th);
            }
        };

        java.lang.RuntimeException handleException(java.lang.Throwable th);
    }

    private enum NotValue {
        NOT_COMPUTED,
        COMPUTING,
        RECURSION_WAS_DETECTED
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0065  */
    private static /* synthetic */ void $$$reportNull$$$0(int i) {
        java.lang.String str = (i == 10 || i == 13 || i == 20 || i == 37) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        java.lang.Object[] objArr = new java.lang.Object[(i == 10 || i == 13 || i == 20 || i == 37) ? 2 : 3];
        if (i == 1 || i == 3 || i == 5) {
            objArr[0] = "exceptionHandlingStrategy";
        } else if (i != 6) {
            switch (i) {
                case 8:
                    objArr[0] = "exceptionHandlingStrategy";
                    break;
                case 9:
                case 11:
                case 14:
                case 16:
                case 19:
                case 21:
                    objArr[0] = "compute";
                    break;
                case 10:
                case 13:
                case 20:
                case 37:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager";
                    break;
                case 12:
                case 17:
                case 25:
                case 27:
                    objArr[0] = "onRecursiveCall";
                    break;
                case 15:
                case 18:
                case 22:
                    objArr[0] = "map";
                    break;
                case 23:
                case 24:
                case 26:
                case 28:
                case 30:
                case 31:
                case 32:
                case 34:
                    objArr[0] = "computable";
                    break;
                case 29:
                case 33:
                    objArr[0] = "postCompute";
                    break;
                case 35:
                    objArr[0] = "source";
                    break;
                case 36:
                    objArr[0] = "throwable";
                    break;
                default:
                    objArr[0] = "debugText";
                    break;
            }
        } else {
            objArr[0] = "lock";
        }
        if (i == 10 || i == 13) {
            objArr[1] = "createMemoizedFunction";
        } else if (i == 20) {
            objArr[1] = "createMemoizedFunctionWithNullableValues";
        } else if (i != 37) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager";
        } else {
            objArr[1] = "sanitizeStackTrace";
        }
        switch (i) {
            case 4:
            case 5:
            case 6:
                objArr[2] = "<init>";
                break;
            case 7:
            case 8:
                objArr[2] = "replaceExceptionHandling";
                break;
            case 9:
            case 11:
            case 12:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
                objArr[2] = "createMemoizedFunction";
                break;
            case 10:
            case 13:
            case 20:
            case 37:
                break;
            case 19:
            case 21:
            case 22:
                objArr[2] = "createMemoizedFunctionWithNullableValues";
                break;
            case 23:
            case 24:
            case 25:
                objArr[2] = "createLazyValue";
                break;
            case 26:
            case 27:
                objArr[2] = "createRecursionTolerantLazyValue";
                break;
            case 28:
            case 29:
                objArr[2] = "createLazyValueWithPostCompute";
                break;
            case 30:
                objArr[2] = "createNullableLazyValue";
                break;
            case 31:
                objArr[2] = "createRecursionTolerantNullableLazyValue";
                break;
            case 32:
            case 33:
                objArr[2] = "createNullableLazyValueWithPostCompute";
                break;
            case 34:
                objArr[2] = "compute";
                break;
            case 35:
                objArr[2] = "recursionDetectedDefault";
                break;
            case 36:
                objArr[2] = "sanitizeStackTrace";
                break;
            default:
                objArr[2] = "createWithExceptionHandling";
                break;
        }
        java.lang.String str2 = java.lang.String.format(str, objArr);
        if (i != 10 && i != 13 && i != 20 && i != 37) {
            throw new java.lang.IllegalArgumentException(str2);
        }
        throw new java.lang.IllegalStateException(str2);
    }

    private LockBasedStorageManager(java.lang.String str, kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.ExceptionHandlingStrategy exceptionHandlingStrategy, kotlin.reflect.jvm.internal.impl.storage.SimpleLock simpleLock) {
        if (str == null) {
            $$$reportNull$$$0(4);
        }
        if (exceptionHandlingStrategy == null) {
            $$$reportNull$$$0(5);
        }
        if (simpleLock == null) {
            $$$reportNull$$$0(6);
        }
        this.lock = simpleLock;
        this.exceptionHandlingStrategy = exceptionHandlingStrategy;
        this.debugText = str;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LockBasedStorageManager(java.lang.String str) {
        this(str, (java.lang.Runnable) null, (kotlin.jvm.functions.Function1<java.lang.InterruptedException, kotlin.Unit>) null);
    }

    public LockBasedStorageManager(java.lang.String str, java.lang.Runnable runnable, kotlin.jvm.functions.Function1<java.lang.InterruptedException, kotlin.Unit> function1) {
        this(str, kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.ExceptionHandlingStrategy.THROW, kotlin.reflect.jvm.internal.impl.storage.SimpleLock.Companion.simpleLock(runnable, function1));
    }

    public java.lang.String toString() {
        return getClass().getSimpleName() + "@" + java.lang.Integer.toHexString(hashCode()) + " (" + this.debugText + com.taobao.weex.el.parse.Operators.BRACKET_END_STR;
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    public <K, V> kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull<K, V> createMemoizedFunction(kotlin.jvm.functions.Function1<? super K, ? extends V> function1) {
        if (function1 == null) {
            $$$reportNull$$$0(9);
        }
        kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull<K, V> memoizedFunctionToNotNullCreateMemoizedFunction = createMemoizedFunction(function1, createConcurrentHashMap());
        if (memoizedFunctionToNotNullCreateMemoizedFunction == null) {
            $$$reportNull$$$0(10);
        }
        return memoizedFunctionToNotNullCreateMemoizedFunction;
    }

    public <K, V> kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull<K, V> createMemoizedFunction(kotlin.jvm.functions.Function1<? super K, ? extends V> function1, java.util.concurrent.ConcurrentMap<K, java.lang.Object> concurrentMap) {
        if (function1 == null) {
            $$$reportNull$$$0(14);
        }
        if (concurrentMap == null) {
            $$$reportNull$$$0(15);
        }
        return new kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.MapBasedMemoizedFunctionToNotNull(this, concurrentMap, function1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    public <K, V> kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable<K, V> createMemoizedFunctionWithNullableValues(kotlin.jvm.functions.Function1<? super K, ? extends V> function1) {
        if (function1 == null) {
            $$$reportNull$$$0(19);
        }
        kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable<K, V> memoizedFunctionToNullableCreateMemoizedFunctionWithNullableValues = createMemoizedFunctionWithNullableValues(function1, createConcurrentHashMap());
        if (memoizedFunctionToNullableCreateMemoizedFunctionWithNullableValues == null) {
            $$$reportNull$$$0(20);
        }
        return memoizedFunctionToNullableCreateMemoizedFunctionWithNullableValues;
    }

    public <K, V> kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable<K, V> createMemoizedFunctionWithNullableValues(kotlin.jvm.functions.Function1<? super K, ? extends V> function1, java.util.concurrent.ConcurrentMap<K, java.lang.Object> concurrentMap) {
        if (function1 == null) {
            $$$reportNull$$$0(21);
        }
        if (concurrentMap == null) {
            $$$reportNull$$$0(22);
        }
        return new kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.MapBasedMemoizedFunction(this, concurrentMap, function1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    public <T> kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue<T> createLazyValue(kotlin.jvm.functions.Function0<? extends T> function0) {
        if (function0 == null) {
            $$$reportNull$$$0(23);
        }
        return new kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.LockBasedNotNullLazyValue(this, function0);
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    public <T> kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue<T> createRecursionTolerantLazyValue(kotlin.jvm.functions.Function0<? extends T> function0, final T t) {
        if (function0 == null) {
            $$$reportNull$$$0(26);
        }
        if (t == null) {
            $$$reportNull$$$0(27);
        }
        return new kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.LockBasedNotNullLazyValue<T>(this, function0) { // from class: kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.4
            private static /* synthetic */ void $$$reportNull$$$0(int i) {
                throw new java.lang.IllegalStateException(java.lang.String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$4", "recursionDetected"));
            }

            @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.LockBasedLazyValue
            protected kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.RecursionDetectedResult<T> recursionDetected(boolean z) {
                kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.RecursionDetectedResult<T> recursionDetectedResultValue = kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.RecursionDetectedResult.value(t);
                if (recursionDetectedResultValue == null) {
                    $$$reportNull$$$0(0);
                }
                return recursionDetectedResultValue;
            }
        };
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    public <T> kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue<T> createLazyValueWithPostCompute(kotlin.jvm.functions.Function0<? extends T> function0, final kotlin.jvm.functions.Function1<? super java.lang.Boolean, ? extends T> function1, final kotlin.jvm.functions.Function1<? super T, kotlin.Unit> function2) {
        if (function0 == null) {
            $$$reportNull$$$0(28);
        }
        if (function2 == null) {
            $$$reportNull$$$0(29);
        }
        return new kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.LockBasedNotNullLazyValueWithPostCompute<T>(this, function0) { // from class: kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.5
            private static /* synthetic */ void $$$reportNull$$$0(int i) {
                java.lang.String str = i != 2 ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                java.lang.Object[] objArr = new java.lang.Object[i != 2 ? 2 : 3];
                if (i != 2) {
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$5";
                } else {
                    objArr[0] = "value";
                }
                if (i != 2) {
                    objArr[1] = "recursionDetected";
                } else {
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$5";
                }
                if (i == 2) {
                    objArr[2] = "doPostCompute";
                }
                java.lang.String str2 = java.lang.String.format(str, objArr);
                if (i == 2) {
                    throw new java.lang.IllegalArgumentException(str2);
                }
            }

            @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.LockBasedLazyValue
            protected kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.RecursionDetectedResult<T> recursionDetected(boolean z) {
                kotlin.jvm.functions.Function1 function3 = function1;
                if (function3 == null) {
                    kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.RecursionDetectedResult<T> recursionDetectedResultRecursionDetected = super.recursionDetected(z);
                    if (recursionDetectedResultRecursionDetected == null) {
                        $$$reportNull$$$0(0);
                    }
                    return recursionDetectedResultRecursionDetected;
                }
                kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.RecursionDetectedResult<T> recursionDetectedResultValue = kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.RecursionDetectedResult.value(function3.invoke(java.lang.Boolean.valueOf(z)));
                if (recursionDetectedResultValue == null) {
                    $$$reportNull$$$0(1);
                }
                return recursionDetectedResultValue;
            }

            @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.LockBasedLazyValueWithPostCompute
            protected void doPostCompute(T t) {
                if (t == null) {
                    $$$reportNull$$$0(2);
                }
                function2.invoke(t);
            }
        };
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    public <T> kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue<T> createNullableLazyValue(kotlin.jvm.functions.Function0<? extends T> function0) {
        if (function0 == null) {
            $$$reportNull$$$0(30);
        }
        return new kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.LockBasedLazyValue(this, function0);
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    public <T> T compute(kotlin.jvm.functions.Function0<? extends T> function0) {
        if (function0 == null) {
            $$$reportNull$$$0(34);
        }
        this.lock.lock();
        try {
            T tInvoke = function0.invoke();
            this.lock.unlock();
            return tInvoke;
        } catch (java.lang.Throwable th) {
            try {
                throw this.exceptionHandlingStrategy.handleException(th);
            } catch (java.lang.Throwable th2) {
                this.lock.unlock();
                throw th2;
            }
        }
    }

    private static <K> java.util.concurrent.ConcurrentMap<K, java.lang.Object> createConcurrentHashMap() {
        return new java.util.concurrent.ConcurrentHashMap(3, 1.0f, 2);
    }

    protected <K, V> kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.RecursionDetectedResult<V> recursionDetectedDefault(java.lang.String str, K k) {
        java.lang.String str2;
        if (str == null) {
            $$$reportNull$$$0(35);
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder("Recursion detected ");
        sb.append(str);
        if (k == null) {
            str2 = "";
        } else {
            str2 = "on input: " + k;
        }
        sb.append(str2);
        sb.append(" under ");
        sb.append(this);
        throw ((java.lang.AssertionError) sanitizeStackTrace(new java.lang.AssertionError(sb.toString())));
    }

    private static class RecursionDetectedResult<T> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final boolean fallThrough;
        private final T value;

        public static <T> kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.RecursionDetectedResult<T> value(T t) {
            return new kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.RecursionDetectedResult<>(t, false);
        }

        public static <T> kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.RecursionDetectedResult<T> fallThrough() {
            return new kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.RecursionDetectedResult<>(null, true);
        }

        private RecursionDetectedResult(T t, boolean z) {
            this.value = t;
            this.fallThrough = z;
        }

        public T getValue() {
            return this.value;
        }

        public boolean isFallThrough() {
            return this.fallThrough;
        }

        public java.lang.String toString() {
            return isFallThrough() ? "FALL_THROUGH" : java.lang.String.valueOf(this.value);
        }
    }

    private static class LockBasedLazyValue<T> implements kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue<T> {
        private final kotlin.jvm.functions.Function0<? extends T> computable;
        private final kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager storageManager;
        private volatile java.lang.Object value;

        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            java.lang.String str = (i == 2 || i == 3) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            java.lang.Object[] objArr = new java.lang.Object[(i == 2 || i == 3) ? 2 : 3];
            if (i == 1) {
                objArr[0] = "computable";
            } else if (i == 2 || i == 3) {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValue";
            } else {
                objArr[0] = "storageManager";
            }
            if (i == 2) {
                objArr[1] = "recursionDetected";
            } else if (i != 3) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValue";
            } else {
                objArr[1] = "renderDebugInformation";
            }
            if (i != 2 && i != 3) {
                objArr[2] = "<init>";
            }
            java.lang.String str2 = java.lang.String.format(str, objArr);
            if (i != 2 && i != 3) {
                throw new java.lang.IllegalArgumentException(str2);
            }
            throw new java.lang.IllegalStateException(str2);
        }

        protected void postCompute(T t) {
        }

        public LockBasedLazyValue(kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager lockBasedStorageManager, kotlin.jvm.functions.Function0<? extends T> function0) {
            if (lockBasedStorageManager == null) {
                $$$reportNull$$$0(0);
            }
            if (function0 == null) {
                $$$reportNull$$$0(1);
            }
            this.value = kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.NotValue.NOT_COMPUTED;
            this.storageManager = lockBasedStorageManager;
            this.computable = function0;
        }

        public boolean isComputed() {
            return (this.value == kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.NotValue.NOT_COMPUTED || this.value == kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.NotValue.COMPUTING) ? false : true;
        }

        /* JADX WARN: Code duplicated, block: B:17:0x003c A[Catch: all -> 0x0085, TryCatch #1 {all -> 0x0085, blocks: (B:7:0x0012, B:9:0x0018, B:12:0x0024, B:14:0x0028, B:16:0x0037, B:17:0x003c, B:19:0x0040, B:21:0x004b, B:22:0x0050, B:26:0x0061, B:28:0x0067, B:30:0x006d, B:31:0x0073, B:32:0x007d, B:33:0x007e, B:34:0x0084, B:23:0x0054), top: B:40:0x0012, inners: #0 }] */
        /* JADX WARN: Code duplicated, block: B:19:0x0040 A[Catch: all -> 0x0085, TryCatch #1 {all -> 0x0085, blocks: (B:7:0x0012, B:9:0x0018, B:12:0x0024, B:14:0x0028, B:16:0x0037, B:17:0x003c, B:19:0x0040, B:21:0x004b, B:22:0x0050, B:26:0x0061, B:28:0x0067, B:30:0x006d, B:31:0x0073, B:32:0x007d, B:33:0x007e, B:34:0x0084, B:23:0x0054), top: B:40:0x0012, inners: #0 }] */
        /* JADX WARN: Code duplicated, block: B:21:0x004b A[Catch: all -> 0x0085, TryCatch #1 {all -> 0x0085, blocks: (B:7:0x0012, B:9:0x0018, B:12:0x0024, B:14:0x0028, B:16:0x0037, B:17:0x003c, B:19:0x0040, B:21:0x004b, B:22:0x0050, B:26:0x0061, B:28:0x0067, B:30:0x006d, B:31:0x0073, B:32:0x007d, B:33:0x007e, B:34:0x0084, B:23:0x0054), top: B:40:0x0012, inners: #0 }] */
        /* JADX WARN: Code duplicated, block: B:22:0x0050 A[Catch: all -> 0x0085, TRY_LEAVE, TryCatch #1 {all -> 0x0085, blocks: (B:7:0x0012, B:9:0x0018, B:12:0x0024, B:14:0x0028, B:16:0x0037, B:17:0x003c, B:19:0x0040, B:21:0x004b, B:22:0x0050, B:26:0x0061, B:28:0x0067, B:30:0x006d, B:31:0x0073, B:32:0x007d, B:33:0x007e, B:34:0x0084, B:23:0x0054), top: B:40:0x0012, inners: #0 }] */
        @Override // kotlin.jvm.functions.Function0
        public T invoke() {
            T tInvoke;
            kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.RecursionDetectedResult<T> recursionDetectedResultRecursionDetected;
            java.lang.Object obj = this.value;
            if (!(obj instanceof kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.NotValue)) {
                return (T) kotlin.reflect.jvm.internal.impl.utils.WrappedValues.unescapeThrowable(obj);
            }
            this.storageManager.lock.lock();
            try {
                java.lang.Object obj2 = this.value;
                if (!(obj2 instanceof kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.NotValue)) {
                    tInvoke = (T) kotlin.reflect.jvm.internal.impl.utils.WrappedValues.unescapeThrowable(obj2);
                } else if (obj2 == kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.NotValue.COMPUTING) {
                    this.value = kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.NotValue.RECURSION_WAS_DETECTED;
                    kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.RecursionDetectedResult<T> recursionDetectedResultRecursionDetected2 = recursionDetected(true);
                    if (!recursionDetectedResultRecursionDetected2.isFallThrough()) {
                        tInvoke = recursionDetectedResultRecursionDetected2.getValue();
                    } else if (obj2 == kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.NotValue.RECURSION_WAS_DETECTED) {
                        recursionDetectedResultRecursionDetected = recursionDetected(false);
                        if (!recursionDetectedResultRecursionDetected.isFallThrough()) {
                            tInvoke = recursionDetectedResultRecursionDetected.getValue();
                        } else {
                            this.value = kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.NotValue.COMPUTING;
                            try {
                                tInvoke = this.computable.invoke();
                                postCompute(tInvoke);
                                this.value = tInvoke;
                            } catch (java.lang.Throwable th) {
                                if (kotlin.reflect.jvm.internal.impl.utils.ExceptionUtilsKt.isProcessCanceledException(th)) {
                                    this.value = kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.NotValue.NOT_COMPUTED;
                                    throw th;
                                }
                                if (this.value == kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.NotValue.COMPUTING) {
                                    this.value = kotlin.reflect.jvm.internal.impl.utils.WrappedValues.escapeThrowable(th);
                                }
                                throw this.storageManager.exceptionHandlingStrategy.handleException(th);
                            }
                        }
                    } else {
                        this.value = kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.NotValue.COMPUTING;
                        tInvoke = this.computable.invoke();
                        postCompute(tInvoke);
                        this.value = tInvoke;
                    }
                } else if (obj2 == kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.NotValue.RECURSION_WAS_DETECTED) {
                    recursionDetectedResultRecursionDetected = recursionDetected(false);
                    if (!recursionDetectedResultRecursionDetected.isFallThrough()) {
                        tInvoke = recursionDetectedResultRecursionDetected.getValue();
                    } else {
                        this.value = kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.NotValue.COMPUTING;
                        tInvoke = this.computable.invoke();
                        postCompute(tInvoke);
                        this.value = tInvoke;
                    }
                } else {
                    this.value = kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.NotValue.COMPUTING;
                    tInvoke = this.computable.invoke();
                    postCompute(tInvoke);
                    this.value = tInvoke;
                }
                this.storageManager.lock.unlock();
                return tInvoke;
            } catch (java.lang.Throwable th2) {
                this.storageManager.lock.unlock();
                throw th2;
            }
        }

        protected kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.RecursionDetectedResult<T> recursionDetected(boolean z) {
            kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.RecursionDetectedResult<T> recursionDetectedResultRecursionDetectedDefault = this.storageManager.recursionDetectedDefault("in a lazy value", null);
            if (recursionDetectedResultRecursionDetectedDefault == null) {
                $$$reportNull$$$0(2);
            }
            return recursionDetectedResultRecursionDetectedDefault;
        }
    }

    private static abstract class LockBasedLazyValueWithPostCompute<T> extends kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.LockBasedLazyValue<T> {
        private volatile kotlin.reflect.jvm.internal.impl.storage.SingleThreadValue<T> valuePostCompute;

        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            java.lang.Object[] objArr = new java.lang.Object[3];
            if (i != 1) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "computable";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValueWithPostCompute";
            objArr[2] = "<init>";
            throw new java.lang.IllegalArgumentException(java.lang.String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        protected abstract void doPostCompute(T t);

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LockBasedLazyValueWithPostCompute(kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager lockBasedStorageManager, kotlin.jvm.functions.Function0<? extends T> function0) {
            super(lockBasedStorageManager, function0);
            if (lockBasedStorageManager == null) {
                $$$reportNull$$$0(0);
            }
            if (function0 == null) {
                $$$reportNull$$$0(1);
            }
            this.valuePostCompute = null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.LockBasedLazyValue, kotlin.jvm.functions.Function0
        public T invoke() {
            kotlin.reflect.jvm.internal.impl.storage.SingleThreadValue<T> singleThreadValue = this.valuePostCompute;
            if (singleThreadValue != null && singleThreadValue.hasValue()) {
                return singleThreadValue.getValue();
            }
            return (T) super.invoke();
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.LockBasedLazyValue
        protected final void postCompute(T t) {
            this.valuePostCompute = new kotlin.reflect.jvm.internal.impl.storage.SingleThreadValue<>(t);
            try {
                doPostCompute(t);
            } finally {
                this.valuePostCompute = null;
            }
        }
    }

    private static abstract class LockBasedNotNullLazyValueWithPostCompute<T> extends kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.LockBasedLazyValueWithPostCompute<T> implements kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue<T> {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            java.lang.String str = i != 2 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            java.lang.Object[] objArr = new java.lang.Object[i != 2 ? 3 : 2];
            if (i == 1) {
                objArr[0] = "computable";
            } else if (i != 2) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValueWithPostCompute";
            }
            if (i != 2) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValueWithPostCompute";
            } else {
                objArr[1] = "invoke";
            }
            if (i != 2) {
                objArr[2] = "<init>";
            }
            java.lang.String str2 = java.lang.String.format(str, objArr);
            if (i == 2) {
                throw new java.lang.IllegalStateException(str2);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LockBasedNotNullLazyValueWithPostCompute(kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager lockBasedStorageManager, kotlin.jvm.functions.Function0<? extends T> function0) {
            super(lockBasedStorageManager, function0);
            if (lockBasedStorageManager == null) {
                $$$reportNull$$$0(0);
            }
            if (function0 == null) {
                $$$reportNull$$$0(1);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.LockBasedLazyValueWithPostCompute, kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.LockBasedLazyValue, kotlin.jvm.functions.Function0
        public T invoke() {
            T t = (T) super.invoke();
            if (t == null) {
                $$$reportNull$$$0(2);
            }
            return t;
        }
    }

    private static class LockBasedNotNullLazyValue<T> extends kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.LockBasedLazyValue<T> implements kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue<T> {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            java.lang.String str = i != 2 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            java.lang.Object[] objArr = new java.lang.Object[i != 2 ? 3 : 2];
            if (i == 1) {
                objArr[0] = "computable";
            } else if (i != 2) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValue";
            }
            if (i != 2) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValue";
            } else {
                objArr[1] = "invoke";
            }
            if (i != 2) {
                objArr[2] = "<init>";
            }
            java.lang.String str2 = java.lang.String.format(str, objArr);
            if (i == 2) {
                throw new java.lang.IllegalStateException(str2);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LockBasedNotNullLazyValue(kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager lockBasedStorageManager, kotlin.jvm.functions.Function0<? extends T> function0) {
            super(lockBasedStorageManager, function0);
            if (lockBasedStorageManager == null) {
                $$$reportNull$$$0(0);
            }
            if (function0 == null) {
                $$$reportNull$$$0(1);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.LockBasedLazyValue, kotlin.jvm.functions.Function0
        public T invoke() {
            T t = (T) super.invoke();
            if (t == null) {
                $$$reportNull$$$0(2);
            }
            return t;
        }
    }

    private static class MapBasedMemoizedFunction<K, V> implements kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable<K, V> {
        private final java.util.concurrent.ConcurrentMap<K, java.lang.Object> cache;
        private final kotlin.jvm.functions.Function1<? super K, ? extends V> compute;
        private final kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager storageManager;

        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            java.lang.String str = (i == 3 || i == 4) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            java.lang.Object[] objArr = new java.lang.Object[(i == 3 || i == 4) ? 2 : 3];
            if (i == 1) {
                objArr[0] = "map";
            } else if (i == 2) {
                objArr[0] = "compute";
            } else if (i == 3 || i == 4) {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunction";
            } else {
                objArr[0] = "storageManager";
            }
            if (i == 3) {
                objArr[1] = "recursionDetected";
            } else if (i != 4) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunction";
            } else {
                objArr[1] = "raceCondition";
            }
            if (i != 3 && i != 4) {
                objArr[2] = "<init>";
            }
            java.lang.String str2 = java.lang.String.format(str, objArr);
            if (i != 3 && i != 4) {
                throw new java.lang.IllegalArgumentException(str2);
            }
            throw new java.lang.IllegalStateException(str2);
        }

        public MapBasedMemoizedFunction(kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager lockBasedStorageManager, java.util.concurrent.ConcurrentMap<K, java.lang.Object> concurrentMap, kotlin.jvm.functions.Function1<? super K, ? extends V> function1) {
            if (lockBasedStorageManager == null) {
                $$$reportNull$$$0(0);
            }
            if (concurrentMap == null) {
                $$$reportNull$$$0(1);
            }
            if (function1 == null) {
                $$$reportNull$$$0(2);
            }
            this.storageManager = lockBasedStorageManager;
            this.cache = concurrentMap;
            this.compute = function1;
        }

        /* JADX WARN: Code duplicated, block: B:16:0x003b A[Catch: all -> 0x00d4, PHI: r0
  0x003b: PHI (r0v8 java.lang.Object) = (r0v7 java.lang.Object), (r0v21 java.lang.Object) binds: [B:10:0x0020, B:12:0x002d] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TryCatch #0 {all -> 0x00d4, blocks: (B:9:0x0018, B:11:0x0022, B:13:0x002f, B:16:0x003b, B:18:0x003f, B:20:0x004a, B:22:0x0051, B:32:0x0080, B:35:0x008c, B:37:0x0090, B:38:0x0094, B:39:0x0095, B:40:0x0097, B:45:0x00a0, B:47:0x00ae, B:48:0x00b2, B:49:0x00b3, B:50:0x00bd, B:52:0x00c3, B:53:0x00cd, B:55:0x00cf, B:56:0x00d3, B:42:0x0099, B:43:0x009d, B:34:0x0086, B:51:0x00be, B:25:0x0057, B:29:0x007a, B:30:0x007e), top: B:60:0x0018, inners: #1, #2, #3 }] */
        /* JADX WARN: Code duplicated, block: B:18:0x003f A[Catch: all -> 0x00d4, TryCatch #0 {all -> 0x00d4, blocks: (B:9:0x0018, B:11:0x0022, B:13:0x002f, B:16:0x003b, B:18:0x003f, B:20:0x004a, B:22:0x0051, B:32:0x0080, B:35:0x008c, B:37:0x0090, B:38:0x0094, B:39:0x0095, B:40:0x0097, B:45:0x00a0, B:47:0x00ae, B:48:0x00b2, B:49:0x00b3, B:50:0x00bd, B:52:0x00c3, B:53:0x00cd, B:55:0x00cf, B:56:0x00d3, B:42:0x0099, B:43:0x009d, B:34:0x0086, B:51:0x00be, B:25:0x0057, B:29:0x007a, B:30:0x007e), top: B:60:0x0018, inners: #1, #2, #3 }] */
        /* JADX WARN: Code duplicated, block: B:20:0x004a A[Catch: all -> 0x00d4, TryCatch #0 {all -> 0x00d4, blocks: (B:9:0x0018, B:11:0x0022, B:13:0x002f, B:16:0x003b, B:18:0x003f, B:20:0x004a, B:22:0x0051, B:32:0x0080, B:35:0x008c, B:37:0x0090, B:38:0x0094, B:39:0x0095, B:40:0x0097, B:45:0x00a0, B:47:0x00ae, B:48:0x00b2, B:49:0x00b3, B:50:0x00bd, B:52:0x00c3, B:53:0x00cd, B:55:0x00cf, B:56:0x00d3, B:42:0x0099, B:43:0x009d, B:34:0x0086, B:51:0x00be, B:25:0x0057, B:29:0x007a, B:30:0x007e), top: B:60:0x0018, inners: #1, #2, #3 }] */
        /* JADX WARN: Code duplicated, block: B:21:0x004f A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:22:0x0051 A[Catch: all -> 0x00d4, TRY_LEAVE, TryCatch #0 {all -> 0x00d4, blocks: (B:9:0x0018, B:11:0x0022, B:13:0x002f, B:16:0x003b, B:18:0x003f, B:20:0x004a, B:22:0x0051, B:32:0x0080, B:35:0x008c, B:37:0x0090, B:38:0x0094, B:39:0x0095, B:40:0x0097, B:45:0x00a0, B:47:0x00ae, B:48:0x00b2, B:49:0x00b3, B:50:0x00bd, B:52:0x00c3, B:53:0x00cd, B:55:0x00cf, B:56:0x00d3, B:42:0x0099, B:43:0x009d, B:34:0x0086, B:51:0x00be, B:25:0x0057, B:29:0x007a, B:30:0x007e), top: B:60:0x0018, inners: #1, #2, #3 }] */
        /* JADX WARN: Code duplicated, block: B:24:0x0056  */
        /* JADX WARN: Code duplicated, block: B:27:0x0072  */
        /* JADX WARN: Code duplicated, block: B:29:0x007a A[Catch: all -> 0x007f, TRY_ENTER, TryCatch #3 {all -> 0x007f, blocks: (B:25:0x0057, B:29:0x007a, B:30:0x007e), top: B:65:0x0057, outer: #0 }] */
        @Override // kotlin.jvm.functions.Function1
        public V invoke(K k) {
            java.lang.AssertionError assertionErrorRaceCondition;
            V vInvoke;
            java.lang.Object objPut;
            V value;
            kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.RecursionDetectedResult<V> recursionDetectedResultRecursionDetected;
            java.lang.Object obj = this.cache.get(k);
            if (obj != null && obj != kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.NotValue.COMPUTING) {
                return (V) kotlin.reflect.jvm.internal.impl.utils.WrappedValues.unescapeExceptionOrNull(obj);
            }
            this.storageManager.lock.lock();
            try {
                java.lang.Object obj2 = this.cache.get(k);
                if (obj2 == kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.NotValue.COMPUTING) {
                    obj2 = kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.NotValue.RECURSION_WAS_DETECTED;
                    kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.RecursionDetectedResult<V> recursionDetectedResultRecursionDetected2 = recursionDetected(k, true);
                    if (!recursionDetectedResultRecursionDetected2.isFallThrough()) {
                        value = recursionDetectedResultRecursionDetected2.getValue();
                    } else if (obj2 == kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.NotValue.RECURSION_WAS_DETECTED) {
                        recursionDetectedResultRecursionDetected = recursionDetected(k, false);
                        if (!recursionDetectedResultRecursionDetected.isFallThrough()) {
                            value = recursionDetectedResultRecursionDetected.getValue();
                        } else if (obj2 != null) {
                            value = (V) kotlin.reflect.jvm.internal.impl.utils.WrappedValues.unescapeExceptionOrNull(obj2);
                        } else {
                            assertionErrorRaceCondition = null;
                            try {
                                this.cache.put(k, kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.NotValue.COMPUTING);
                                vInvoke = this.compute.invoke(k);
                                objPut = this.cache.put(k, kotlin.reflect.jvm.internal.impl.utils.WrappedValues.escapeNull(vInvoke));
                                if (objPut == kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.NotValue.COMPUTING) {
                                    assertionErrorRaceCondition = raceCondition(k, objPut);
                                    throw assertionErrorRaceCondition;
                                }
                                this.storageManager.lock.unlock();
                                return vInvoke;
                            } catch (java.lang.Throwable th) {
                                if (kotlin.reflect.jvm.internal.impl.utils.ExceptionUtilsKt.isProcessCanceledException(th)) {
                                    try {
                                        java.lang.Object objRemove = this.cache.remove(k);
                                        if (objRemove != kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.NotValue.COMPUTING) {
                                            throw inconsistentComputingKey(k, objRemove);
                                        }
                                        throw th;
                                    } catch (java.lang.Throwable th2) {
                                        throw unableToRemoveKey(k, th2);
                                    }
                                }
                                if (th == assertionErrorRaceCondition) {
                                    try {
                                        this.cache.remove(k);
                                        throw this.storageManager.exceptionHandlingStrategy.handleException(th);
                                    } catch (java.lang.Throwable th3) {
                                        throw unableToRemoveKey(k, th3);
                                    }
                                }
                                java.lang.Object objPut2 = this.cache.put(k, kotlin.reflect.jvm.internal.impl.utils.WrappedValues.escapeThrowable(th));
                                if (objPut2 == kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.NotValue.COMPUTING) {
                                    throw this.storageManager.exceptionHandlingStrategy.handleException(th);
                                }
                                throw raceCondition(k, objPut2);
                            }
                            this.storageManager.lock.unlock();
                            throw th;
                        }
                    } else if (obj2 != null) {
                        value = (V) kotlin.reflect.jvm.internal.impl.utils.WrappedValues.unescapeExceptionOrNull(obj2);
                    } else {
                        assertionErrorRaceCondition = null;
                        this.cache.put(k, kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.NotValue.COMPUTING);
                        vInvoke = this.compute.invoke(k);
                        objPut = this.cache.put(k, kotlin.reflect.jvm.internal.impl.utils.WrappedValues.escapeNull(vInvoke));
                        if (objPut == kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.NotValue.COMPUTING) {
                            assertionErrorRaceCondition = raceCondition(k, objPut);
                            throw assertionErrorRaceCondition;
                        }
                        this.storageManager.lock.unlock();
                        return vInvoke;
                        this.storageManager.lock.unlock();
                        throw th;
                    }
                } else if (obj2 == kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.NotValue.RECURSION_WAS_DETECTED) {
                    recursionDetectedResultRecursionDetected = recursionDetected(k, false);
                    if (!recursionDetectedResultRecursionDetected.isFallThrough()) {
                        value = recursionDetectedResultRecursionDetected.getValue();
                    } else if (obj2 != null) {
                        value = (V) kotlin.reflect.jvm.internal.impl.utils.WrappedValues.unescapeExceptionOrNull(obj2);
                    } else {
                        assertionErrorRaceCondition = null;
                        this.cache.put(k, kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.NotValue.COMPUTING);
                        vInvoke = this.compute.invoke(k);
                        objPut = this.cache.put(k, kotlin.reflect.jvm.internal.impl.utils.WrappedValues.escapeNull(vInvoke));
                        if (objPut == kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.NotValue.COMPUTING) {
                            assertionErrorRaceCondition = raceCondition(k, objPut);
                            throw assertionErrorRaceCondition;
                        }
                        this.storageManager.lock.unlock();
                        return vInvoke;
                        this.storageManager.lock.unlock();
                        throw th;
                    }
                } else if (obj2 != null) {
                    value = (V) kotlin.reflect.jvm.internal.impl.utils.WrappedValues.unescapeExceptionOrNull(obj2);
                } else {
                    assertionErrorRaceCondition = null;
                    this.cache.put(k, kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.NotValue.COMPUTING);
                    vInvoke = this.compute.invoke(k);
                    objPut = this.cache.put(k, kotlin.reflect.jvm.internal.impl.utils.WrappedValues.escapeNull(vInvoke));
                    if (objPut == kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.NotValue.COMPUTING) {
                        assertionErrorRaceCondition = raceCondition(k, objPut);
                        throw assertionErrorRaceCondition;
                    }
                    this.storageManager.lock.unlock();
                    return vInvoke;
                    this.storageManager.lock.unlock();
                    throw th;
                }
                this.storageManager.lock.unlock();
                return value;
            } catch (java.lang.Throwable th4) {
                this.storageManager.lock.unlock();
                throw th4;
            }
        }

        protected kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.RecursionDetectedResult<V> recursionDetected(K k, boolean z) {
            kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.RecursionDetectedResult<V> recursionDetectedResultRecursionDetectedDefault = this.storageManager.recursionDetectedDefault("", k);
            if (recursionDetectedResultRecursionDetectedDefault == null) {
                $$$reportNull$$$0(3);
            }
            return recursionDetectedResultRecursionDetectedDefault;
        }

        private java.lang.AssertionError raceCondition(K k, java.lang.Object obj) {
            java.lang.AssertionError assertionError = (java.lang.AssertionError) kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.sanitizeStackTrace(new java.lang.AssertionError("Race condition detected on input " + k + ". Old value is " + obj + " under " + this.storageManager));
            if (assertionError == null) {
                $$$reportNull$$$0(4);
            }
            return assertionError;
        }

        private java.lang.AssertionError inconsistentComputingKey(K k, java.lang.Object obj) {
            return (java.lang.AssertionError) kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.sanitizeStackTrace(new java.lang.AssertionError("Inconsistent key detected. " + kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.NotValue.COMPUTING + " is expected, was: " + obj + ", most probably race condition detected on input " + k + " under " + this.storageManager));
        }

        private java.lang.AssertionError unableToRemoveKey(K k, java.lang.Throwable th) {
            return (java.lang.AssertionError) kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.sanitizeStackTrace(new java.lang.AssertionError("Unable to remove " + k + " under " + this.storageManager, th));
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable
        public boolean isComputed(K k) {
            java.lang.Object obj = this.cache.get(k);
            return (obj == null || obj == kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.NotValue.COMPUTING) ? false : true;
        }

        protected kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager getStorageManager() {
            return this.storageManager;
        }
    }

    private static class MapBasedMemoizedFunctionToNotNull<K, V> extends kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.MapBasedMemoizedFunction<K, V> implements kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull<K, V> {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            java.lang.String str = i != 3 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            java.lang.Object[] objArr = new java.lang.Object[i != 3 ? 3 : 2];
            if (i == 1) {
                objArr[0] = "map";
            } else if (i == 2) {
                objArr[0] = "compute";
            } else if (i != 3) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull";
            }
            if (i != 3) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull";
            } else {
                objArr[1] = "invoke";
            }
            if (i != 3) {
                objArr[2] = "<init>";
            }
            java.lang.String str2 = java.lang.String.format(str, objArr);
            if (i == 3) {
                throw new java.lang.IllegalStateException(str2);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MapBasedMemoizedFunctionToNotNull(kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager lockBasedStorageManager, java.util.concurrent.ConcurrentMap<K, java.lang.Object> concurrentMap, kotlin.jvm.functions.Function1<? super K, ? extends V> function1) {
            super(lockBasedStorageManager, concurrentMap, function1);
            if (lockBasedStorageManager == null) {
                $$$reportNull$$$0(0);
            }
            if (concurrentMap == null) {
                $$$reportNull$$$0(1);
            }
            if (function1 == null) {
                $$$reportNull$$$0(2);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.MapBasedMemoizedFunction, kotlin.jvm.functions.Function1
        public V invoke(K k) {
            V v = (V) super.invoke(k);
            if (v == null) {
                $$$reportNull$$$0(3);
            }
            return v;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T extends java.lang.Throwable> T sanitizeStackTrace(T t) {
        if (t == null) {
            $$$reportNull$$$0(36);
        }
        java.lang.StackTraceElement[] stackTrace = t.getStackTrace();
        int length = stackTrace.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                i = -1;
                break;
            }
            if (!stackTrace[i].getClassName().startsWith(PACKAGE_NAME)) {
                break;
            }
            i++;
        }
        java.util.List listSubList = java.util.Arrays.asList(stackTrace).subList(i, length);
        t.setStackTrace((java.lang.StackTraceElement[]) listSubList.toArray(new java.lang.StackTraceElement[listSubList.size()]));
        if (t == null) {
            $$$reportNull$$$0(37);
        }
        return t;
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    public <K, V> kotlin.reflect.jvm.internal.impl.storage.CacheWithNullableValues<K, V> createCacheWithNullableValues() {
        return new kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.CacheWithNullableValuesBasedOnMemoizedFunction(createConcurrentHashMap());
    }

    private static class CacheWithNullableValuesBasedOnMemoizedFunction<K, V> extends kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.MapBasedMemoizedFunction<kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.KeyWithComputation<K, V>, V> implements kotlin.reflect.jvm.internal.impl.storage.CacheWithNullableValues<K, V> {
        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            java.lang.Object[] objArr = new java.lang.Object[3];
            if (i == 1) {
                objArr[0] = "map";
            } else if (i != 2) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "computation";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNullableValuesBasedOnMemoizedFunction";
            if (i != 2) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = "computeIfAbsent";
            }
            throw new java.lang.IllegalArgumentException(java.lang.String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private CacheWithNullableValuesBasedOnMemoizedFunction(kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager lockBasedStorageManager, java.util.concurrent.ConcurrentMap<kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.KeyWithComputation<K, V>, java.lang.Object> concurrentMap) {
            super(lockBasedStorageManager, concurrentMap, new kotlin.jvm.functions.Function1<kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.KeyWithComputation<K, V>, V>() { // from class: kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.CacheWithNullableValuesBasedOnMemoizedFunction.1
                @Override // kotlin.jvm.functions.Function1
                public V invoke(kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.KeyWithComputation<K, V> keyWithComputation) {
                    return (V) ((kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.KeyWithComputation) keyWithComputation).computation.invoke();
                }
            });
            if (lockBasedStorageManager == null) {
                $$$reportNull$$$0(0);
            }
            if (concurrentMap == null) {
                $$$reportNull$$$0(1);
            }
        }

        public V computeIfAbsent(K k, kotlin.jvm.functions.Function0<? extends V> function0) {
            if (function0 == null) {
                $$$reportNull$$$0(2);
            }
            return invoke(new kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.KeyWithComputation(k, function0));
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    public <K, V> kotlin.reflect.jvm.internal.impl.storage.CacheWithNotNullValues<K, V> createCacheWithNotNullValues() {
        return new kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.CacheWithNotNullValuesBasedOnMemoizedFunction(createConcurrentHashMap());
    }

    private static class CacheWithNotNullValuesBasedOnMemoizedFunction<K, V> extends kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.CacheWithNullableValuesBasedOnMemoizedFunction<K, V> implements kotlin.reflect.jvm.internal.impl.storage.CacheWithNotNullValues<K, V> {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            java.lang.String str = i != 3 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            java.lang.Object[] objArr = new java.lang.Object[i != 3 ? 3 : 2];
            if (i == 1) {
                objArr[0] = "map";
            } else if (i == 2) {
                objArr[0] = "computation";
            } else if (i != 3) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNotNullValuesBasedOnMemoizedFunction";
            }
            if (i != 3) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNotNullValuesBasedOnMemoizedFunction";
            } else {
                objArr[1] = "computeIfAbsent";
            }
            if (i == 2) {
                objArr[2] = "computeIfAbsent";
            } else if (i != 3) {
                objArr[2] = "<init>";
            }
            java.lang.String str2 = java.lang.String.format(str, objArr);
            if (i == 3) {
                throw new java.lang.IllegalStateException(str2);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private CacheWithNotNullValuesBasedOnMemoizedFunction(kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager lockBasedStorageManager, java.util.concurrent.ConcurrentMap<kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.KeyWithComputation<K, V>, java.lang.Object> concurrentMap) {
            super(concurrentMap);
            if (lockBasedStorageManager == null) {
                $$$reportNull$$$0(0);
            }
            if (concurrentMap == null) {
                $$$reportNull$$$0(1);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.CacheWithNullableValuesBasedOnMemoizedFunction, kotlin.reflect.jvm.internal.impl.storage.CacheWithNotNullValues
        public V computeIfAbsent(K k, kotlin.jvm.functions.Function0<? extends V> function0) {
            if (function0 == null) {
                $$$reportNull$$$0(2);
            }
            V v = (V) super.computeIfAbsent(k, function0);
            if (v == null) {
                $$$reportNull$$$0(3);
            }
            return v;
        }
    }

    private static class KeyWithComputation<K, V> {
        private final kotlin.jvm.functions.Function0<? extends V> computation;
        private final K key;

        public KeyWithComputation(K k, kotlin.jvm.functions.Function0<? extends V> function0) {
            this.key = k;
            this.computation = function0;
        }

        public boolean equals(java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.key.equals(((kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.KeyWithComputation) obj).key);
        }

        public int hashCode() {
            return this.key.hashCode();
        }
    }
}
