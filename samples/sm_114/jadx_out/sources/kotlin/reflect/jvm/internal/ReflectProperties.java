package kotlin.reflect.jvm.internal;

/* JADX INFO: loaded from: classes2.dex */
public class ReflectProperties {
    private static /* synthetic */ void $$$reportNull$$$0(int i) {
        throw new java.lang.IllegalArgumentException(java.lang.String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "initializer", "kotlin/reflect/jvm/internal/ReflectProperties", "lazySoft"));
    }

    public static abstract class Val<T> {
        private static final java.lang.Object NULL_VALUE = new java.lang.Object() { // from class: kotlin.reflect.jvm.internal.ReflectProperties.Val.1
        };

        public abstract T invoke();

        public final T getValue(java.lang.Object obj, java.lang.Object obj2) {
            return invoke();
        }

        protected java.lang.Object escape(T t) {
            return t == null ? NULL_VALUE : t;
        }

        /* JADX WARN: Multi-variable type inference failed */
        protected T unescape(java.lang.Object obj) {
            if (obj == NULL_VALUE) {
                return null;
            }
            return obj;
        }
    }

    public static class LazySoftVal<T> extends kotlin.reflect.jvm.internal.ReflectProperties.Val<T> implements kotlin.jvm.functions.Function0<T> {
        private final kotlin.jvm.functions.Function0<T> initializer;
        private volatile java.lang.ref.SoftReference<java.lang.Object> value;

        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            throw new java.lang.IllegalArgumentException(java.lang.String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "initializer", "kotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal", "<init>"));
        }

        public LazySoftVal(T t, kotlin.jvm.functions.Function0<T> function0) {
            if (function0 == null) {
                $$$reportNull$$$0(0);
            }
            this.value = null;
            this.initializer = function0;
            if (t != null) {
                this.value = new java.lang.ref.SoftReference<>(escape(t));
            }
        }

        @Override // kotlin.reflect.jvm.internal.ReflectProperties.Val, kotlin.jvm.functions.Function0
        public T invoke() {
            java.lang.Object obj;
            java.lang.ref.SoftReference<java.lang.Object> softReference = this.value;
            if (softReference != null && (obj = softReference.get()) != null) {
                return unescape(obj);
            }
            T tInvoke = this.initializer.invoke();
            this.value = new java.lang.ref.SoftReference<>(escape(tInvoke));
            return tInvoke;
        }
    }

    public static <T> kotlin.reflect.jvm.internal.ReflectProperties.LazySoftVal<T> lazySoft(T t, kotlin.jvm.functions.Function0<T> function0) {
        if (function0 == null) {
            $$$reportNull$$$0(0);
        }
        return new kotlin.reflect.jvm.internal.ReflectProperties.LazySoftVal<>(t, function0);
    }

    public static <T> kotlin.reflect.jvm.internal.ReflectProperties.LazySoftVal<T> lazySoft(kotlin.jvm.functions.Function0<T> function0) {
        if (function0 == null) {
            $$$reportNull$$$0(1);
        }
        return lazySoft(null, function0);
    }
}
