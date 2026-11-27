package kotlin.reflect.jvm.internal.impl.km.jvm.internal;

/* JADX INFO: compiled from: JvmExtensionNodes.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class JvmConstructorExtension implements kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmConstructorExtension {
    public static final kotlin.reflect.jvm.internal.impl.km.jvm.internal.JvmConstructorExtension.Companion Companion = new kotlin.reflect.jvm.internal.impl.km.jvm.internal.JvmConstructorExtension.Companion(null);
    public static final kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmExtensionType TYPE = new kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmExtensionType(kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(kotlin.reflect.jvm.internal.impl.km.jvm.internal.JvmConstructorExtension.class));
    private kotlin.reflect.jvm.internal.impl.km.jvm.JvmMethodSignature signature;

    public final kotlin.reflect.jvm.internal.impl.km.jvm.JvmMethodSignature getSignature() {
        return this.signature;
    }

    public final void setSignature(kotlin.reflect.jvm.internal.impl.km.jvm.JvmMethodSignature jvmMethodSignature) {
        this.signature = jvmMethodSignature;
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
