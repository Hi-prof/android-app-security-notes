package kotlin.reflect.jvm.internal.impl.types.error;

/* JADX INFO: compiled from: ErrorType.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ErrorType extends kotlin.reflect.jvm.internal.impl.types.SimpleType {
    private final java.util.List<kotlin.reflect.jvm.internal.impl.types.TypeProjection> arguments;
    private final kotlin.reflect.jvm.internal.impl.types.TypeConstructor constructor;
    private final java.lang.String debugMessage;
    private final java.lang.String[] formatParams;
    private final boolean isMarkedNullable;
    private final kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind kind;
    private final kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope memberScope;

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public kotlin.reflect.jvm.internal.impl.types.error.ErrorType refine(kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner kotlinTypeRefiner) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public kotlin.reflect.jvm.internal.impl.types.TypeConstructor getConstructor() {
        return this.constructor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope getMemberScope() {
        return this.memberScope;
    }

    public final kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind getKind() {
        return this.kind;
    }

    public /* synthetic */ ErrorType(kotlin.reflect.jvm.internal.impl.types.TypeConstructor typeConstructor, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope memberScope, kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind errorTypeKind, java.util.List list, boolean z, java.lang.String[] strArr, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(typeConstructor, memberScope, errorTypeKind, (i & 8) != 0 ? kotlin.collections.CollectionsKt.emptyList() : list, (i & 16) != 0 ? false : z, strArr);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public java.util.List<kotlin.reflect.jvm.internal.impl.types.TypeProjection> getArguments() {
        return this.arguments;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public boolean isMarkedNullable() {
        return this.isMarkedNullable;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ErrorType(kotlin.reflect.jvm.internal.impl.types.TypeConstructor constructor, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope memberScope, kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind kind, java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.TypeProjection> arguments, boolean z, java.lang.String... formatParams) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(constructor, "constructor");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(memberScope, "memberScope");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kind, "kind");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(arguments, "arguments");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(formatParams, "formatParams");
        this.constructor = constructor;
        this.memberScope = memberScope;
        this.kind = kind;
        this.arguments = arguments;
        this.isMarkedNullable = z;
        this.formatParams = formatParams;
        kotlin.jvm.internal.StringCompanionObject stringCompanionObject = kotlin.jvm.internal.StringCompanionObject.INSTANCE;
        java.lang.String debugMessage = kind.getDebugMessage();
        java.lang.Object[] objArrCopyOf = java.util.Arrays.copyOf(formatParams, formatParams.length);
        java.lang.String str = java.lang.String.format(debugMessage, java.util.Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        this.debugMessage = str;
    }

    public final java.lang.String getDebugMessage() {
        return this.debugMessage;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public kotlin.reflect.jvm.internal.impl.types.TypeAttributes getAttributes() {
        return kotlin.reflect.jvm.internal.impl.types.TypeAttributes.Companion.getEmpty();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public kotlin.reflect.jvm.internal.impl.types.SimpleType replaceAttributes(kotlin.reflect.jvm.internal.impl.types.TypeAttributes newAttributes) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(newAttributes, "newAttributes");
        return this;
    }

    public final kotlin.reflect.jvm.internal.impl.types.error.ErrorType replaceArguments(java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.TypeProjection> newArguments) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(newArguments, "newArguments");
        kotlin.reflect.jvm.internal.impl.types.TypeConstructor constructor = getConstructor();
        kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope memberScope = getMemberScope();
        kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind errorTypeKind = this.kind;
        boolean zIsMarkedNullable = isMarkedNullable();
        java.lang.String[] strArr = this.formatParams;
        return new kotlin.reflect.jvm.internal.impl.types.error.ErrorType(constructor, memberScope, errorTypeKind, newArguments, zIsMarkedNullable, (java.lang.String[]) java.util.Arrays.copyOf(strArr, strArr.length));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public kotlin.reflect.jvm.internal.impl.types.SimpleType makeNullableAsSpecified(boolean z) {
        kotlin.reflect.jvm.internal.impl.types.TypeConstructor constructor = getConstructor();
        kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope memberScope = getMemberScope();
        kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind errorTypeKind = this.kind;
        java.util.List<kotlin.reflect.jvm.internal.impl.types.TypeProjection> arguments = getArguments();
        java.lang.String[] strArr = this.formatParams;
        return new kotlin.reflect.jvm.internal.impl.types.error.ErrorType(constructor, memberScope, errorTypeKind, arguments, z, (java.lang.String[]) java.util.Arrays.copyOf(strArr, strArr.length));
    }
}
