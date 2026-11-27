package kotlin.reflect.jvm.internal.impl.load.java.lazy;

/* JADX INFO: compiled from: context.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface JavaResolverSettings {
    public static final kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverSettings.Companion Companion = kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverSettings.Companion.$$INSTANCE;

    boolean getCorrectNullabilityForNotNullTypeParameter();

    boolean getEnhancePrimitiveArrays();

    boolean getIgnoreNullabilityForErasedValueParameters();

    boolean getTypeEnhancementImprovementsInStrictMode();

    /* JADX INFO: compiled from: context.kt */
    public static final class Default implements kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverSettings {
        public static final kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverSettings.Default INSTANCE = new kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverSettings.Default();

        @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverSettings
        public boolean getCorrectNullabilityForNotNullTypeParameter() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverSettings
        public boolean getEnhancePrimitiveArrays() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverSettings
        public boolean getIgnoreNullabilityForErasedValueParameters() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverSettings
        public boolean getTypeEnhancementImprovementsInStrictMode() {
            return false;
        }

        private Default() {
        }
    }

    /* JADX INFO: compiled from: context.kt */
    public static final class Companion {
        static final /* synthetic */ kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverSettings.Companion $$INSTANCE = new kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverSettings.Companion();

        private Companion() {
        }
    }
}
