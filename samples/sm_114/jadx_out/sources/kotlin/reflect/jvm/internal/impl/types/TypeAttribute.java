package kotlin.reflect.jvm.internal.impl.types;

/* JADX INFO: compiled from: TypeAttributes.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class TypeAttribute<T extends kotlin.reflect.jvm.internal.impl.types.TypeAttribute<? extends T>> {
    public abstract T add(T t);

    public abstract kotlin.reflect.KClass<? extends T> getKey();

    public abstract T intersect(T t);
}
