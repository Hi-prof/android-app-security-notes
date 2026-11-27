package kotlin.reflect.jvm.internal.impl.km.jvm.internal;

/* JADX INFO: compiled from: JvmExtensionNodes.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class JvmClassExtension implements kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmClassExtension {
    public static final kotlin.reflect.jvm.internal.impl.km.jvm.internal.JvmClassExtension.Companion Companion = new kotlin.reflect.jvm.internal.impl.km.jvm.internal.JvmClassExtension.Companion(null);
    private static final kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmExtensionType TYPE = new kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmExtensionType(kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(kotlin.reflect.jvm.internal.impl.km.jvm.internal.JvmClassExtension.class));
    private java.lang.String anonymousObjectOriginName;
    private int jvmFlags;
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

    public final java.lang.String getAnonymousObjectOriginName() {
        return this.anonymousObjectOriginName;
    }

    public final void setAnonymousObjectOriginName(java.lang.String str) {
        this.anonymousObjectOriginName = str;
    }

    public final int getJvmFlags() {
        return this.jvmFlags;
    }

    public final void setJvmFlags(int i) {
        this.jvmFlags = i;
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

        public final kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmExtensionType getTYPE() {
            return kotlin.reflect.jvm.internal.impl.km.jvm.internal.JvmClassExtension.TYPE;
        }
    }
}
