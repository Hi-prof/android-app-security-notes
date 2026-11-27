package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

/* JADX INFO: compiled from: ReflectJavaClass.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Java16SealedRecordLoader {
    public static final kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.Java16SealedRecordLoader INSTANCE = new kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.Java16SealedRecordLoader();
    private static kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.Java16SealedRecordLoader.Cache _cache;

    /* JADX INFO: compiled from: ReflectJavaClass.kt */
    public static final class Cache {
        private final java.lang.reflect.Method getPermittedSubclasses;
        private final java.lang.reflect.Method getRecordComponents;
        private final java.lang.reflect.Method isRecord;
        private final java.lang.reflect.Method isSealed;

        public Cache(java.lang.reflect.Method method, java.lang.reflect.Method method2, java.lang.reflect.Method method3, java.lang.reflect.Method method4) {
            this.isSealed = method;
            this.getPermittedSubclasses = method2;
            this.isRecord = method3;
            this.getRecordComponents = method4;
        }

        public final java.lang.reflect.Method isSealed() {
            return this.isSealed;
        }

        public final java.lang.reflect.Method getGetPermittedSubclasses() {
            return this.getPermittedSubclasses;
        }

        public final java.lang.reflect.Method isRecord() {
            return this.isRecord;
        }

        public final java.lang.reflect.Method getGetRecordComponents() {
            return this.getRecordComponents;
        }
    }

    private Java16SealedRecordLoader() {
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.Java16SealedRecordLoader.Cache buildCache() {
        try {
            return new kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.Java16SealedRecordLoader.Cache(java.lang.Class.class.getMethod("isSealed", null), java.lang.Class.class.getMethod("getPermittedSubclasses", null), java.lang.Class.class.getMethod("isRecord", null), java.lang.Class.class.getMethod("getRecordComponents", null));
        } catch (java.lang.NoSuchMethodException unused) {
            return new kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.Java16SealedRecordLoader.Cache(null, null, null, null);
        }
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.Java16SealedRecordLoader.Cache initCache() {
        kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.Java16SealedRecordLoader.Cache cache = _cache;
        if (cache != null) {
            return cache;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.Java16SealedRecordLoader.Cache cacheBuildCache = buildCache();
        _cache = cacheBuildCache;
        return cacheBuildCache;
    }

    public final java.lang.Boolean loadIsSealed(java.lang.Class<?> clazz) throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(clazz, "clazz");
        java.lang.reflect.Method methodIsSealed = initCache().isSealed();
        if (methodIsSealed == null) {
            return null;
        }
        java.lang.Object objInvoke = methodIsSealed.invoke(clazz, null);
        kotlin.jvm.internal.Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.Boolean");
        return (java.lang.Boolean) objInvoke;
    }

    public final java.lang.Class<?>[] loadGetPermittedSubclasses(java.lang.Class<?> clazz) throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(clazz, "clazz");
        java.lang.reflect.Method getPermittedSubclasses = initCache().getGetPermittedSubclasses();
        if (getPermittedSubclasses == null) {
            return null;
        }
        java.lang.Object objInvoke = getPermittedSubclasses.invoke(clazz, null);
        kotlin.jvm.internal.Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.Array<java.lang.Class<*>>");
        return (java.lang.Class[]) objInvoke;
    }

    public final java.lang.Boolean loadIsRecord(java.lang.Class<?> clazz) throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(clazz, "clazz");
        java.lang.reflect.Method methodIsRecord = initCache().isRecord();
        if (methodIsRecord == null) {
            return null;
        }
        java.lang.Object objInvoke = methodIsRecord.invoke(clazz, null);
        kotlin.jvm.internal.Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.Boolean");
        return (java.lang.Boolean) objInvoke;
    }

    public final java.lang.Object[] loadGetRecordComponents(java.lang.Class<?> clazz) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(clazz, "clazz");
        java.lang.reflect.Method getRecordComponents = initCache().getGetRecordComponents();
        if (getRecordComponents == null) {
            return null;
        }
        return (java.lang.Object[]) getRecordComponents.invoke(clazz, null);
    }
}
