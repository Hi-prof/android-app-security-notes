package kotlin.reflect.jvm.internal.impl.util;

/* JADX INFO: compiled from: ArrayMapOwner.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NullableArrayMapAccessor<K, V, T extends V> extends kotlin.reflect.jvm.internal.impl.util.AbstractArrayMapOwner.AbstractArrayMapAccessor<K, V, T> implements kotlin.properties.ReadOnlyProperty<kotlin.reflect.jvm.internal.impl.util.AbstractArrayMapOwner<K, V>, V> {
    @Override // kotlin.properties.ReadOnlyProperty
    public /* bridge */ /* synthetic */ java.lang.Object getValue(java.lang.Object obj, kotlin.reflect.KProperty kProperty) {
        return getValue((kotlin.reflect.jvm.internal.impl.util.AbstractArrayMapOwner) obj, (kotlin.reflect.KProperty<?>) kProperty);
    }

    public NullableArrayMapAccessor(int i) {
        super(i);
    }

    public T getValue(kotlin.reflect.jvm.internal.impl.util.AbstractArrayMapOwner<K, V> thisRef, kotlin.reflect.KProperty<?> property) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(thisRef, "thisRef");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(property, "property");
        return extractValue(thisRef);
    }
}
