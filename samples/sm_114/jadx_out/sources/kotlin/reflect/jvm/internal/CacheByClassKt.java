package kotlin.reflect.jvm.internal;

/* JADX INFO: compiled from: CacheByClass.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a0\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\b\b\u0000\u0010\u0004*\u00020\u00052\u0016\u0010\u0006\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b\u0012\u0004\u0012\u0002H\u00040\u0007H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"useClassValue", "", "createCache", "Lkotlin/reflect/jvm/internal/CacheByClass;", "V", "", "compute", "Lkotlin/Function1;", "Ljava/lang/Class;", "kotlin-reflection"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class CacheByClassKt {
    private static final boolean useClassValue;

    static {
        java.lang.Object objM541constructorimpl;
        try {
            kotlin.Result.Companion companion = kotlin.Result.INSTANCE;
            objM541constructorimpl = kotlin.Result.m541constructorimpl(java.lang.Class.forName("java.lang.ClassValue"));
        } catch (java.lang.Throwable th) {
            kotlin.Result.Companion companion2 = kotlin.Result.INSTANCE;
            objM541constructorimpl = kotlin.Result.m541constructorimpl(kotlin.ResultKt.createFailure(th));
        }
        if (kotlin.Result.m548isSuccessimpl(objM541constructorimpl)) {
            kotlin.Result.Companion companion3 = kotlin.Result.INSTANCE;
            objM541constructorimpl = true;
        }
        java.lang.Object objM541constructorimpl2 = kotlin.Result.m541constructorimpl(objM541constructorimpl);
        if (kotlin.Result.m547isFailureimpl(objM541constructorimpl2)) {
            objM541constructorimpl2 = false;
        }
        useClassValue = ((java.lang.Boolean) objM541constructorimpl2).booleanValue();
    }

    public static final <V> kotlin.reflect.jvm.internal.CacheByClass<V> createCache(kotlin.jvm.functions.Function1<? super java.lang.Class<?>, ? extends V> compute) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(compute, "compute");
        return useClassValue ? new kotlin.reflect.jvm.internal.ClassValueCache<>(compute) : new kotlin.reflect.jvm.internal.ConcurrentHashMapCache<>(compute);
    }
}
