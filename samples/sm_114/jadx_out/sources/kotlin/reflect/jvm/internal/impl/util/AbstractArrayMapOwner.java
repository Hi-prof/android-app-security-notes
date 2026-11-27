package kotlin.reflect.jvm.internal.impl.util;

/* JADX INFO: compiled from: ArrayMapOwner.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractArrayMapOwner<K, V> implements java.lang.Iterable<V>, kotlin.jvm.internal.markers.KMappedMarker {
    protected abstract kotlin.reflect.jvm.internal.impl.util.ArrayMap<V> getArrayMap();

    protected abstract kotlin.reflect.jvm.internal.impl.util.TypeRegistry<K, V> getTypeRegistry();

    protected abstract void registerComponent(java.lang.String str, V v);

    /* JADX INFO: compiled from: ArrayMapOwner.kt */
    public static abstract class AbstractArrayMapAccessor<K, V, T extends V> {
        private final int id;

        public AbstractArrayMapAccessor(int i) {
            this.id = i;
        }

        protected final T extractValue(kotlin.reflect.jvm.internal.impl.util.AbstractArrayMapOwner<K, V> thisRef) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(thisRef, "thisRef");
            return thisRef.getArrayMap().get(this.id);
        }
    }

    protected final void registerComponent(kotlin.reflect.KClass<? extends K> tClass, V value) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(tClass, "tClass");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(value, "value");
        java.lang.String qualifiedName = tClass.getQualifiedName();
        kotlin.jvm.internal.Intrinsics.checkNotNull(qualifiedName);
        registerComponent(qualifiedName, value);
    }

    @Override // java.lang.Iterable
    public final java.util.Iterator<V> iterator() {
        return getArrayMap().iterator();
    }

    public final boolean isEmpty() {
        return getArrayMap().getSize() == 0;
    }
}
