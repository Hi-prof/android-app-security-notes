package kotlin.reflect.jvm.internal.impl.km.jvm.internal;

/* JADX INFO: compiled from: JvmExtensionNodes.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class JvmTypeParameterExtension implements kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmTypeParameterExtension {
    public static final kotlin.reflect.jvm.internal.impl.km.jvm.internal.JvmTypeParameterExtension.Companion Companion = new kotlin.reflect.jvm.internal.impl.km.jvm.internal.JvmTypeParameterExtension.Companion(null);
    public static final kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmExtensionType TYPE = new kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmExtensionType(kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(kotlin.reflect.jvm.internal.impl.km.jvm.internal.JvmTypeParameterExtension.class));
    private final java.util.List<kotlin.reflect.jvm.internal.impl.km.KmAnnotation> annotations = new java.util.ArrayList();

    public final java.util.List<kotlin.reflect.jvm.internal.impl.km.KmAnnotation> getAnnotations() {
        return this.annotations;
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmExtension
    public kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmExtensionType getType() {
        return TYPE;
    }

    /* JADX INFO: compiled from: JvmExtensionNodes.kt */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
