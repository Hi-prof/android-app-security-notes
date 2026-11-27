package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

/* JADX INFO: compiled from: ReflectJavaMember.kt */
/* JADX INFO: loaded from: classes2.dex */
final class Java8ParameterNamesLoader {
    public static final kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.Java8ParameterNamesLoader INSTANCE = new kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.Java8ParameterNamesLoader();
    private static kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.Java8ParameterNamesLoader.Cache cache;

    /* JADX INFO: compiled from: ReflectJavaMember.kt */
    public static final class Cache {
        private final java.lang.reflect.Method getName;
        private final java.lang.reflect.Method getParameters;

        public Cache(java.lang.reflect.Method method, java.lang.reflect.Method method2) {
            this.getParameters = method;
            this.getName = method2;
        }

        public final java.lang.reflect.Method getGetName() {
            return this.getName;
        }

        public final java.lang.reflect.Method getGetParameters() {
            return this.getParameters;
        }
    }

    private Java8ParameterNamesLoader() {
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.Java8ParameterNamesLoader.Cache buildCache(java.lang.reflect.Member member) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(member, "member");
        java.lang.Class<?> cls = member.getClass();
        try {
            return new kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.Java8ParameterNamesLoader.Cache(cls.getMethod("getParameters", null), kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt.getSafeClassLoader(cls).loadClass("java.lang.reflect.Parameter").getMethod("getName", null));
        } catch (java.lang.NoSuchMethodException unused) {
            return new kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.Java8ParameterNamesLoader.Cache(null, null);
        }
    }

    public final java.util.List<java.lang.String> loadParameterNames(java.lang.reflect.Member member) {
        java.lang.reflect.Method getName;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(member, "member");
        kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.Java8ParameterNamesLoader.Cache cacheBuildCache = cache;
        if (cacheBuildCache == null) {
            synchronized (this) {
                kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.Java8ParameterNamesLoader java8ParameterNamesLoader = INSTANCE;
                kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.Java8ParameterNamesLoader.Cache cache2 = cache;
                if (cache2 == null) {
                    cacheBuildCache = java8ParameterNamesLoader.buildCache(member);
                    cache = cacheBuildCache;
                } else {
                    cacheBuildCache = cache2;
                }
            }
        }
        java.lang.reflect.Method getParameters = cacheBuildCache.getGetParameters();
        if (getParameters == null || (getName = cacheBuildCache.getGetName()) == null) {
            return null;
        }
        java.lang.Object objInvoke = getParameters.invoke(member, null);
        kotlin.jvm.internal.Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.Array<*>");
        java.lang.Object[] objArr = (java.lang.Object[]) objInvoke;
        java.util.ArrayList arrayList = new java.util.ArrayList(objArr.length);
        for (java.lang.Object obj : objArr) {
            java.lang.Object objInvoke2 = getName.invoke(obj, null);
            kotlin.jvm.internal.Intrinsics.checkNotNull(objInvoke2, "null cannot be cast to non-null type kotlin.String");
            arrayList.add((java.lang.String) objInvoke2);
        }
        return arrayList;
    }
}
