package kotlin.reflect.jvm.internal;

/* JADX INFO: compiled from: CacheByClass.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001f\u0012\u0016\u0010\u0003\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u00028\u00002\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0016¢\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u000eH\u0016R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lkotlin/reflect/jvm/internal/ClassValueCache;", "V", "Lkotlin/reflect/jvm/internal/CacheByClass;", "compute", "Lkotlin/Function1;", "Ljava/lang/Class;", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "classValue", "Lkotlin/reflect/jvm/internal/ComputableClassValue;", "get", io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_KEY, "(Ljava/lang/Class;)Ljava/lang/Object;", "clear", "", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
final class ClassValueCache<V> extends kotlin.reflect.jvm.internal.CacheByClass<V> {
    private volatile kotlin.reflect.jvm.internal.ComputableClassValue<V> classValue;

    public ClassValueCache(kotlin.jvm.functions.Function1<? super java.lang.Class<?>, ? extends V> compute) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(compute, "compute");
        this.classValue = new kotlin.reflect.jvm.internal.ComputableClassValue<>(compute);
    }

    @Override // kotlin.reflect.jvm.internal.CacheByClass
    public V get(java.lang.Class<?> key) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(key, "key");
        kotlin.reflect.jvm.internal.ComputableClassValue<V> computableClassValue = this.classValue;
        V v = (V) ((java.lang.ref.SoftReference) computableClassValue.get(key)).get();
        if (v != null) {
            return v;
        }
        computableClassValue.remove(key);
        V v2 = (V) ((java.lang.ref.SoftReference) computableClassValue.get(key)).get();
        return v2 != null ? v2 : computableClassValue.compute.invoke(key);
    }

    @Override // kotlin.reflect.jvm.internal.CacheByClass
    public void clear() {
        this.classValue = this.classValue.createNewCopy();
    }
}
