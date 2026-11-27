package kotlin.reflect.jvm.internal.impl.util;

/* JADX INFO: compiled from: ArrayMapOwner.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class TypeRegistry<K, V> {
    private final java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Integer> idPerType = new java.util.concurrent.ConcurrentHashMap<>();
    private final java.util.concurrent.atomic.AtomicInteger idCounter = new java.util.concurrent.atomic.AtomicInteger(0);

    public abstract int customComputeIfAbsent(java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Integer> concurrentHashMap, java.lang.String str, kotlin.jvm.functions.Function1<? super java.lang.String, java.lang.Integer> function1);

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends V, KK extends K> kotlin.reflect.jvm.internal.impl.util.NullableArrayMapAccessor<K, V, T> generateNullableAccessor(kotlin.reflect.KClass<KK> kClass) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kClass, "kClass");
        return new kotlin.reflect.jvm.internal.impl.util.NullableArrayMapAccessor<>(getId(kClass));
    }

    public final <T extends K> int getId(kotlin.reflect.KClass<T> kClass) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kClass, "kClass");
        java.lang.String qualifiedName = kClass.getQualifiedName();
        kotlin.jvm.internal.Intrinsics.checkNotNull(qualifiedName);
        return getId(qualifiedName);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int getId$lambda$0(kotlin.reflect.jvm.internal.impl.util.TypeRegistry typeRegistry, java.lang.String it) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(it, "it");
        return typeRegistry.idCounter.getAndIncrement();
    }

    public final int getId(java.lang.String keyQualifiedName) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(keyQualifiedName, "keyQualifiedName");
        return customComputeIfAbsent(this.idPerType, keyQualifiedName, new kotlin.jvm.functions.Function1(this) { // from class: kotlin.reflect.jvm.internal.impl.util.TypeRegistry$$Lambda$0
            private final kotlin.reflect.jvm.internal.impl.util.TypeRegistry arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public java.lang.Object invoke(java.lang.Object obj) {
                return java.lang.Integer.valueOf(kotlin.reflect.jvm.internal.impl.util.TypeRegistry.getId$lambda$0(this.arg$0, (java.lang.String) obj));
            }
        });
    }

    public final java.util.Map<java.lang.String, java.lang.Integer> allValuesThreadUnsafeForRendering() {
        return this.idPerType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final java.util.Collection<java.lang.Integer> getIndices() {
        java.util.Collection<java.lang.Integer> collectionValues = this.idPerType.values();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(collectionValues, "<get-values>(...)");
        return collectionValues;
    }
}
