package kotlin.reflect.jvm.internal.impl.types.error;

/* JADX INFO: compiled from: ErrorUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ErrorUtils {
    private static final kotlin.reflect.jvm.internal.impl.types.error.ErrorClassDescriptor errorClass;
    private static final kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor errorProperty;
    private static final java.util.Set<kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor> errorPropertyGroup;
    private static final kotlin.reflect.jvm.internal.impl.types.KotlinType errorPropertyType;
    private static final kotlin.reflect.jvm.internal.impl.types.KotlinType errorTypeForLoopInSupertypes;
    public static final kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils INSTANCE = new kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils();
    private static final kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor errorModule = kotlin.reflect.jvm.internal.impl.types.error.ErrorModuleDescriptor.INSTANCE;

    private ErrorUtils() {
    }

    static {
        java.lang.String str = java.lang.String.format(kotlin.reflect.jvm.internal.impl.types.error.ErrorEntity.ERROR_CLASS.getDebugText(), java.util.Arrays.copyOf(new java.lang.Object[]{"unknown class"}, 1));
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        kotlin.reflect.jvm.internal.impl.name.Name nameSpecial = kotlin.reflect.jvm.internal.impl.name.Name.special(str);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameSpecial, "special(...)");
        errorClass = new kotlin.reflect.jvm.internal.impl.types.error.ErrorClassDescriptor(nameSpecial);
        errorTypeForLoopInSupertypes = createErrorType(kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind.CYCLIC_SUPERTYPES, new java.lang.String[0]);
        errorPropertyType = createErrorType(kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind.ERROR_PROPERTY_TYPE, new java.lang.String[0]);
        kotlin.reflect.jvm.internal.impl.types.error.ErrorPropertyDescriptor errorPropertyDescriptor = new kotlin.reflect.jvm.internal.impl.types.error.ErrorPropertyDescriptor();
        errorProperty = errorPropertyDescriptor;
        errorPropertyGroup = kotlin.collections.SetsKt.setOf(errorPropertyDescriptor);
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor getErrorModule() {
        return errorModule;
    }

    public final kotlin.reflect.jvm.internal.impl.types.error.ErrorClassDescriptor getErrorClass() {
        return errorClass;
    }

    public final kotlin.reflect.jvm.internal.impl.types.KotlinType getErrorTypeForLoopInSupertypes() {
        return errorTypeForLoopInSupertypes;
    }

    public final kotlin.reflect.jvm.internal.impl.types.KotlinType getErrorPropertyType() {
        return errorPropertyType;
    }

    public final java.util.Set<kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor> getErrorPropertyGroup() {
        return errorPropertyGroup;
    }

    @kotlin.jvm.JvmStatic
    public static final kotlin.reflect.jvm.internal.impl.types.error.ErrorScope createErrorScope(kotlin.reflect.jvm.internal.impl.types.error.ErrorScopeKind kind, java.lang.String... formatParams) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kind, "kind");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(formatParams, "formatParams");
        return createErrorScope(kind, false, (java.lang.String[]) java.util.Arrays.copyOf(formatParams, formatParams.length));
    }

    @kotlin.jvm.JvmStatic
    public static final kotlin.reflect.jvm.internal.impl.types.error.ErrorScope createErrorScope(kotlin.reflect.jvm.internal.impl.types.error.ErrorScopeKind kind, boolean z, java.lang.String... formatParams) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kind, "kind");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(formatParams, "formatParams");
        return z ? new kotlin.reflect.jvm.internal.impl.types.error.ThrowingScope(kind, (java.lang.String[]) java.util.Arrays.copyOf(formatParams, formatParams.length)) : new kotlin.reflect.jvm.internal.impl.types.error.ErrorScope(kind, (java.lang.String[]) java.util.Arrays.copyOf(formatParams, formatParams.length));
    }

    @kotlin.jvm.JvmStatic
    public static final kotlin.reflect.jvm.internal.impl.types.error.ErrorType createErrorType(kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind kind, java.lang.String... formatParams) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kind, "kind");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(formatParams, "formatParams");
        return INSTANCE.createErrorTypeWithArguments(kind, kotlin.collections.CollectionsKt.emptyList(), (java.lang.String[]) java.util.Arrays.copyOf(formatParams, formatParams.length));
    }

    public final kotlin.reflect.jvm.internal.impl.types.error.ErrorType createErrorType(kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind kind, kotlin.reflect.jvm.internal.impl.types.TypeConstructor typeConstructor, java.lang.String... formatParams) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kind, "kind");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeConstructor, "typeConstructor");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(formatParams, "formatParams");
        return createErrorTypeWithArguments(kind, kotlin.collections.CollectionsKt.emptyList(), typeConstructor, (java.lang.String[]) java.util.Arrays.copyOf(formatParams, formatParams.length));
    }

    public final kotlin.reflect.jvm.internal.impl.types.error.ErrorType createErrorTypeWithArguments(kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind kind, java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.TypeProjection> arguments, java.lang.String... formatParams) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kind, "kind");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(arguments, "arguments");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(formatParams, "formatParams");
        return createErrorTypeWithArguments(kind, arguments, createErrorTypeConstructor(kind, (java.lang.String[]) java.util.Arrays.copyOf(formatParams, formatParams.length)), (java.lang.String[]) java.util.Arrays.copyOf(formatParams, formatParams.length));
    }

    public final kotlin.reflect.jvm.internal.impl.types.error.ErrorType createErrorTypeWithArguments(kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind kind, java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.TypeProjection> arguments, kotlin.reflect.jvm.internal.impl.types.TypeConstructor typeConstructor, java.lang.String... formatParams) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kind, "kind");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(arguments, "arguments");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeConstructor, "typeConstructor");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(formatParams, "formatParams");
        return new kotlin.reflect.jvm.internal.impl.types.error.ErrorType(typeConstructor, createErrorScope(kotlin.reflect.jvm.internal.impl.types.error.ErrorScopeKind.ERROR_TYPE_SCOPE, typeConstructor.toString()), kind, arguments, false, (java.lang.String[]) java.util.Arrays.copyOf(formatParams, formatParams.length));
    }

    public final kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeConstructor createErrorTypeConstructor(kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind kind, java.lang.String... formatParams) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kind, "kind");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(formatParams, "formatParams");
        return new kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeConstructor(kind, (java.lang.String[]) java.util.Arrays.copyOf(formatParams, formatParams.length));
    }

    @kotlin.jvm.JvmStatic
    public static final boolean isError(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor == null) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils errorUtils = INSTANCE;
        return errorUtils.isErrorClass(declarationDescriptor) || errorUtils.isErrorClass(declarationDescriptor.getContainingDeclaration()) || declarationDescriptor == errorModule;
    }

    private final boolean isErrorClass(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor) {
        return declarationDescriptor instanceof kotlin.reflect.jvm.internal.impl.types.error.ErrorClassDescriptor;
    }

    @kotlin.jvm.JvmStatic
    public static final boolean isUninferredTypeVariable(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        if (kotlinType == null) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.types.TypeConstructor constructor = kotlinType.getConstructor();
        return (constructor instanceof kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeConstructor) && ((kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeConstructor) constructor).getKind() == kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind.UNINFERRED_TYPE_VARIABLE;
    }

    public final java.lang.String unresolvedTypeAsItIs(kotlin.reflect.jvm.internal.impl.types.KotlinType type) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(type, "type");
        kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.isUnresolvedType(type);
        kotlin.reflect.jvm.internal.impl.types.TypeConstructor constructor = type.getConstructor();
        kotlin.jvm.internal.Intrinsics.checkNotNull(constructor, "null cannot be cast to non-null type org.jetbrains.kotlin.types.error.ErrorTypeConstructor");
        return ((kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeConstructor) constructor).getParam(0);
    }
}
