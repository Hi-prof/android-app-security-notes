package kotlin.reflect.jvm.internal.impl.km.jvm.internal;

/* JADX INFO: compiled from: JvmExtensionNodes.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class JvmPackageExtension implements kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmPackageExtension {
    public static final kotlin.reflect.jvm.internal.impl.km.jvm.internal.JvmPackageExtension.Companion Companion = new kotlin.reflect.jvm.internal.impl.km.jvm.internal.JvmPackageExtension.Companion(null);
    public static final kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmExtensionType TYPE = new kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmExtensionType(kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(kotlin.reflect.jvm.internal.impl.km.jvm.internal.JvmPackageExtension.class));
    private final java.util.List<kotlin.reflect.jvm.internal.impl.km.KmProperty> localDelegatedProperties = new java.util.ArrayList(0);
    private java.lang.String moduleName;

    public final java.util.List<kotlin.reflect.jvm.internal.impl.km.KmProperty> getLocalDelegatedProperties() {
        return this.localDelegatedProperties;
    }

    public final java.lang.String getModuleName() {
        return this.moduleName;
    }

    public final void setModuleName(java.lang.String str) {
        this.moduleName = str;
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
