package kotlin.reflect.jvm.internal.impl.load.java;

/* JADX INFO: compiled from: JavaNullabilityAnnotationSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface NullabilityAnnotationStates<T> {
    public static final kotlin.reflect.jvm.internal.impl.load.java.NullabilityAnnotationStates.Companion Companion = kotlin.reflect.jvm.internal.impl.load.java.NullabilityAnnotationStates.Companion.$$INSTANCE;

    T get(kotlin.reflect.jvm.internal.impl.name.FqName fqName);

    /* JADX INFO: compiled from: JavaNullabilityAnnotationSettings.kt */
    public static final class Companion {
        static final /* synthetic */ kotlin.reflect.jvm.internal.impl.load.java.NullabilityAnnotationStates.Companion $$INSTANCE = new kotlin.reflect.jvm.internal.impl.load.java.NullabilityAnnotationStates.Companion();
        private static final kotlin.reflect.jvm.internal.impl.load.java.NullabilityAnnotationStates EMPTY = new kotlin.reflect.jvm.internal.impl.load.java.NullabilityAnnotationStatesImpl(kotlin.collections.MapsKt.emptyMap());

        private Companion() {
        }

        public final kotlin.reflect.jvm.internal.impl.load.java.NullabilityAnnotationStates getEMPTY() {
            return EMPTY;
        }
    }
}
