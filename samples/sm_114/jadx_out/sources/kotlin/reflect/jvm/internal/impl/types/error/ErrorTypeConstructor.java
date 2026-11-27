package kotlin.reflect.jvm.internal.impl.types.error;

/* JADX INFO: compiled from: ErrorTypeConstructor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ErrorTypeConstructor implements kotlin.reflect.jvm.internal.impl.types.TypeConstructor {
    private final java.lang.String debugText;
    private final java.lang.String[] formatParams;
    private final kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind kind;

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public boolean isDenotable() {
        return false;
    }

    public ErrorTypeConstructor(kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind kind, java.lang.String... formatParams) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kind, "kind");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(formatParams, "formatParams");
        this.kind = kind;
        this.formatParams = formatParams;
        java.lang.String debugText = kotlin.reflect.jvm.internal.impl.types.error.ErrorEntity.ERROR_TYPE.getDebugText();
        java.lang.String debugMessage = kind.getDebugMessage();
        java.lang.Object[] objArrCopyOf = java.util.Arrays.copyOf(formatParams, formatParams.length);
        java.lang.String str = java.lang.String.format(debugMessage, java.util.Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        java.lang.String str2 = java.lang.String.format(debugText, java.util.Arrays.copyOf(new java.lang.Object[]{str}, 1));
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
        this.debugText = str2;
    }

    public final kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind getKind() {
        return this.kind;
    }

    public final java.lang.String getParam(int i) {
        return this.formatParams[i];
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> getParameters() {
        return kotlin.collections.CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    /* JADX INFO: renamed from: getSupertypes */
    public java.util.Collection<kotlin.reflect.jvm.internal.impl.types.KotlinType> mo1836getSupertypes() {
        return kotlin.collections.CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    /* JADX INFO: renamed from: getDeclarationDescriptor */
    public kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor mo1835getDeclarationDescriptor() {
        return kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils.INSTANCE.getErrorClass();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns getBuiltIns() {
        return kotlin.reflect.jvm.internal.impl.builtins.DefaultBuiltIns.Companion.getInstance();
    }

    public java.lang.String toString() {
        return this.debugText;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public kotlin.reflect.jvm.internal.impl.types.TypeConstructor refine(kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner kotlinTypeRefiner) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }
}
