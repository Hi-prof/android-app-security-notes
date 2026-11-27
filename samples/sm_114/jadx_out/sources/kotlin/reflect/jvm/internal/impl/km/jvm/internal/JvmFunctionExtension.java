package kotlin.reflect.jvm.internal.impl.km.jvm.internal;

/* JADX INFO: compiled from: JvmExtensionNodes.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class JvmFunctionExtension implements kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmFunctionExtension {
    public static final kotlin.reflect.jvm.internal.impl.km.jvm.internal.JvmFunctionExtension.Companion Companion = new kotlin.reflect.jvm.internal.impl.km.jvm.internal.JvmFunctionExtension.Companion(null);
    public static final kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmExtensionType TYPE = new kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmExtensionType(kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(kotlin.reflect.jvm.internal.impl.km.jvm.internal.JvmFunctionExtension.class));
    private java.lang.String lambdaClassOriginName;
    private kotlin.reflect.jvm.internal.impl.km.jvm.JvmMethodSignature signature;

    public final kotlin.reflect.jvm.internal.impl.km.jvm.JvmMethodSignature getSignature() {
        return this.signature;
    }

    public final void setSignature(kotlin.reflect.jvm.internal.impl.km.jvm.JvmMethodSignature jvmMethodSignature) {
        this.signature = jvmMethodSignature;
    }

    public final java.lang.String getLambdaClassOriginName() {
        return this.lambdaClassOriginName;
    }

    public final void setLambdaClassOriginName(java.lang.String str) {
        this.lambdaClassOriginName = str;
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
