package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

/* JADX INFO: compiled from: ReflectJavaRecordComponent.kt */
/* JADX INFO: loaded from: classes2.dex */
final class Java16RecordComponentsLoader {
    public static final kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.Java16RecordComponentsLoader INSTANCE = new kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.Java16RecordComponentsLoader();
    private static kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.Java16RecordComponentsLoader.Cache _cache;

    /* JADX INFO: compiled from: ReflectJavaRecordComponent.kt */
    public static final class Cache {
        private final java.lang.reflect.Method getAccessor;
        private final java.lang.reflect.Method getType;

        public Cache(java.lang.reflect.Method method, java.lang.reflect.Method method2) {
            this.getType = method;
            this.getAccessor = method2;
        }

        public final java.lang.reflect.Method getGetType() {
            return this.getType;
        }

        public final java.lang.reflect.Method getGetAccessor() {
            return this.getAccessor;
        }
    }

    private Java16RecordComponentsLoader() {
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.Java16RecordComponentsLoader.Cache buildCache(java.lang.Object obj) {
        java.lang.Class<?> cls = obj.getClass();
        try {
            return new kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.Java16RecordComponentsLoader.Cache(cls.getMethod("getType", null), cls.getMethod("getAccessor", null));
        } catch (java.lang.NoSuchMethodException unused) {
            return new kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.Java16RecordComponentsLoader.Cache(null, null);
        }
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.Java16RecordComponentsLoader.Cache initCache(java.lang.Object obj) {
        kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.Java16RecordComponentsLoader.Cache cache = _cache;
        if (cache != null) {
            return cache;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.Java16RecordComponentsLoader.Cache cacheBuildCache = buildCache(obj);
        _cache = cacheBuildCache;
        return cacheBuildCache;
    }

    public final java.lang.Class<?> loadGetType(java.lang.Object recordComponent) throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(recordComponent, "recordComponent");
        java.lang.reflect.Method getType = initCache(recordComponent).getGetType();
        if (getType == null) {
            return null;
        }
        java.lang.Object objInvoke = getType.invoke(recordComponent, null);
        kotlin.jvm.internal.Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type java.lang.Class<*>");
        return (java.lang.Class) objInvoke;
    }

    public final java.lang.reflect.Method loadGetAccessor(java.lang.Object recordComponent) throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(recordComponent, "recordComponent");
        java.lang.reflect.Method getAccessor = initCache(recordComponent).getGetAccessor();
        if (getAccessor == null) {
            return null;
        }
        java.lang.Object objInvoke = getAccessor.invoke(recordComponent, null);
        kotlin.jvm.internal.Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type java.lang.reflect.Method");
        return (java.lang.reflect.Method) objInvoke;
    }
}
