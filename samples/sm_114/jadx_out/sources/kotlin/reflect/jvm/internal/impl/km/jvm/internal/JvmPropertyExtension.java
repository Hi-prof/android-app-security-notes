package kotlin.reflect.jvm.internal.impl.km.jvm.internal;

/* JADX INFO: compiled from: JvmExtensionNodes.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class JvmPropertyExtension implements kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmPropertyExtension {
    public static final kotlin.reflect.jvm.internal.impl.km.jvm.internal.JvmPropertyExtension.Companion Companion = new kotlin.reflect.jvm.internal.impl.km.jvm.internal.JvmPropertyExtension.Companion(null);
    public static final kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmExtensionType TYPE = new kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmExtensionType(kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(kotlin.reflect.jvm.internal.impl.km.jvm.internal.JvmPropertyExtension.class));
    private kotlin.reflect.jvm.internal.impl.km.jvm.JvmFieldSignature fieldSignature;
    private kotlin.reflect.jvm.internal.impl.km.jvm.JvmMethodSignature getterSignature;
    private int jvmFlags;
    private kotlin.reflect.jvm.internal.impl.km.jvm.JvmMethodSignature setterSignature;
    private kotlin.reflect.jvm.internal.impl.km.jvm.JvmMethodSignature syntheticMethodForAnnotations;
    private kotlin.reflect.jvm.internal.impl.km.jvm.JvmMethodSignature syntheticMethodForDelegate;

    public final int getJvmFlags() {
        return this.jvmFlags;
    }

    public final void setJvmFlags(int i) {
        this.jvmFlags = i;
    }

    public final kotlin.reflect.jvm.internal.impl.km.jvm.JvmFieldSignature getFieldSignature() {
        return this.fieldSignature;
    }

    public final void setFieldSignature(kotlin.reflect.jvm.internal.impl.km.jvm.JvmFieldSignature jvmFieldSignature) {
        this.fieldSignature = jvmFieldSignature;
    }

    public final kotlin.reflect.jvm.internal.impl.km.jvm.JvmMethodSignature getGetterSignature() {
        return this.getterSignature;
    }

    public final void setGetterSignature(kotlin.reflect.jvm.internal.impl.km.jvm.JvmMethodSignature jvmMethodSignature) {
        this.getterSignature = jvmMethodSignature;
    }

    public final kotlin.reflect.jvm.internal.impl.km.jvm.JvmMethodSignature getSetterSignature() {
        return this.setterSignature;
    }

    public final void setSetterSignature(kotlin.reflect.jvm.internal.impl.km.jvm.JvmMethodSignature jvmMethodSignature) {
        this.setterSignature = jvmMethodSignature;
    }

    public final kotlin.reflect.jvm.internal.impl.km.jvm.JvmMethodSignature getSyntheticMethodForAnnotations() {
        return this.syntheticMethodForAnnotations;
    }

    public final void setSyntheticMethodForAnnotations(kotlin.reflect.jvm.internal.impl.km.jvm.JvmMethodSignature jvmMethodSignature) {
        this.syntheticMethodForAnnotations = jvmMethodSignature;
    }

    public final kotlin.reflect.jvm.internal.impl.km.jvm.JvmMethodSignature getSyntheticMethodForDelegate() {
        return this.syntheticMethodForDelegate;
    }

    public final void setSyntheticMethodForDelegate(kotlin.reflect.jvm.internal.impl.km.jvm.JvmMethodSignature jvmMethodSignature) {
        this.syntheticMethodForDelegate = jvmMethodSignature;
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
