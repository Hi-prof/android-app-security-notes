package kotlin.reflect.jvm.internal.impl.types.extensions;

/* JADX INFO: compiled from: TypeAttributeTranslators.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TypeAttributeTranslators {
    private final java.util.List<kotlin.reflect.jvm.internal.impl.types.TypeAttributeTranslator> translators;

    /* JADX WARN: Multi-variable type inference failed */
    public TypeAttributeTranslators(java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.TypeAttributeTranslator> translators) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(translators, "translators");
        this.translators = translators;
    }

    public final java.util.List<kotlin.reflect.jvm.internal.impl.types.TypeAttributeTranslator> getTranslators() {
        return this.translators;
    }
}
