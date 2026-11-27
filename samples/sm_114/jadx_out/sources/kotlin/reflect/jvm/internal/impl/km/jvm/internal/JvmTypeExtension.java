package kotlin.reflect.jvm.internal.impl.km.jvm.internal;

/* JADX INFO: compiled from: JvmExtensionNodes.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class JvmTypeExtension implements kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmTypeExtension {
    public static final kotlin.reflect.jvm.internal.impl.km.jvm.internal.JvmTypeExtension.Companion Companion = new kotlin.reflect.jvm.internal.impl.km.jvm.internal.JvmTypeExtension.Companion(null);
    public static final kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmExtensionType TYPE = new kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmExtensionType(kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(kotlin.reflect.jvm.internal.impl.km.jvm.internal.JvmTypeExtension.class));
    private final java.util.List<kotlin.reflect.jvm.internal.impl.km.KmAnnotation> annotations = new java.util.ArrayList();
    private boolean isRaw;

    public final boolean isRaw() {
        return this.isRaw;
    }

    public final void setRaw(boolean z) {
        this.isRaw = z;
    }

    public final java.util.List<kotlin.reflect.jvm.internal.impl.km.KmAnnotation> getAnnotations() {
        return this.annotations;
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmExtension
    public kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmExtensionType getType() {
        return TYPE;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (!kotlin.jvm.internal.Intrinsics.areEqual(getClass(), obj != null ? obj.getClass() : null)) {
            return false;
        }
        kotlin.jvm.internal.Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.metadata.jvm.internal.JvmTypeExtension");
        kotlin.reflect.jvm.internal.impl.km.jvm.internal.JvmTypeExtension jvmTypeExtension = (kotlin.reflect.jvm.internal.impl.km.jvm.internal.JvmTypeExtension) obj;
        return this.isRaw == jvmTypeExtension.isRaw && kotlin.jvm.internal.Intrinsics.areEqual(this.annotations, jvmTypeExtension.annotations);
    }

    public int hashCode() {
        return (kotlin.UByte$$ExternalSyntheticBackport0.m(this.isRaw) * 31) + this.annotations.hashCode();
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
