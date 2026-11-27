package kotlin.reflect.jvm.internal.impl.load.java;

/* JADX INFO: compiled from: JavaNullabilityAnnotationSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NullabilityAnnotationStatesImpl<T> implements kotlin.reflect.jvm.internal.impl.load.java.NullabilityAnnotationStates<T> {
    private final kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable<kotlin.reflect.jvm.internal.impl.name.FqName, T> cache;
    private final java.util.Map<kotlin.reflect.jvm.internal.impl.name.FqName, T> states;
    private final kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager storageManager;

    /* JADX WARN: Multi-variable type inference failed */
    public NullabilityAnnotationStatesImpl(java.util.Map<kotlin.reflect.jvm.internal.impl.name.FqName, ? extends T> states) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(states, "states");
        this.states = states;
        kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager lockBasedStorageManager = new kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager("Java nullability annotation states");
        this.storageManager = lockBasedStorageManager;
        kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable<kotlin.reflect.jvm.internal.impl.name.FqName, T> memoizedFunctionToNullableCreateMemoizedFunctionWithNullableValues = lockBasedStorageManager.createMemoizedFunctionWithNullableValues(new kotlin.jvm.functions.Function1(this) { // from class: kotlin.reflect.jvm.internal.impl.load.java.NullabilityAnnotationStatesImpl$$Lambda$0
            private final kotlin.reflect.jvm.internal.impl.load.java.NullabilityAnnotationStatesImpl arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public java.lang.Object invoke(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.load.java.NullabilityAnnotationStatesImpl.cache$lambda$0(this.arg$0, (kotlin.reflect.jvm.internal.impl.name.FqName) obj);
            }
        });
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(memoizedFunctionToNullableCreateMemoizedFunctionWithNullableValues, "createMemoizedFunctionWithNullableValues(...)");
        this.cache = memoizedFunctionToNullableCreateMemoizedFunctionWithNullableValues;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.lang.Object cache$lambda$0(kotlin.reflect.jvm.internal.impl.load.java.NullabilityAnnotationStatesImpl nullabilityAnnotationStatesImpl, kotlin.reflect.jvm.internal.impl.name.FqName fqName) {
        kotlin.jvm.internal.Intrinsics.checkNotNull(fqName);
        return kotlin.reflect.jvm.internal.impl.name.FqNamesUtilKt.findValueForMostSpecificFqname(fqName, nullabilityAnnotationStatesImpl.states);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.NullabilityAnnotationStates
    public T get(kotlin.reflect.jvm.internal.impl.name.FqName fqName) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fqName, "fqName");
        return this.cache.invoke(fqName);
    }
}
