package kotlin.reflect.jvm.internal.impl.resolve.calls.inference;

/* JADX INFO: compiled from: CapturedTypeConstructor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CapturedType extends kotlin.reflect.jvm.internal.impl.types.SimpleType implements kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker {
    private final kotlin.reflect.jvm.internal.impl.types.TypeAttributes attributes;
    private final kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructor constructor;
    private final boolean isMarkedNullable;
    private final kotlin.reflect.jvm.internal.impl.types.TypeProjection typeProjection;

    public /* synthetic */ CapturedType(kotlin.reflect.jvm.internal.impl.types.TypeProjection typeProjection, kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorImpl capturedTypeConstructorImpl, boolean z, kotlin.reflect.jvm.internal.impl.types.TypeAttributes typeAttributes, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(typeProjection, (i & 2) != 0 ? new kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorImpl(typeProjection) : capturedTypeConstructorImpl, (i & 4) != 0 ? false : z, (i & 8) != 0 ? kotlin.reflect.jvm.internal.impl.types.TypeAttributes.Companion.getEmpty() : typeAttributes);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructor getConstructor() {
        return this.constructor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public boolean isMarkedNullable() {
        return this.isMarkedNullable;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public kotlin.reflect.jvm.internal.impl.types.TypeAttributes getAttributes() {
        return this.attributes;
    }

    public CapturedType(kotlin.reflect.jvm.internal.impl.types.TypeProjection typeProjection, kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructor constructor, boolean z, kotlin.reflect.jvm.internal.impl.types.TypeAttributes attributes) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeProjection, "typeProjection");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(constructor, "constructor");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(attributes, "attributes");
        this.typeProjection = typeProjection;
        this.constructor = constructor;
        this.isMarkedNullable = z;
        this.attributes = attributes;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public java.util.List<kotlin.reflect.jvm.internal.impl.types.TypeProjection> getArguments() {
        return kotlin.collections.CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope getMemberScope() {
        return kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils.createErrorScope(kotlin.reflect.jvm.internal.impl.types.error.ErrorScopeKind.CAPTURED_TYPE_SCOPE, true, new java.lang.String[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.SimpleType
    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("Captured(");
        sb.append(this.typeProjection);
        sb.append(com.taobao.weex.el.parse.Operators.BRACKET_END);
        sb.append(isMarkedNullable() ? com.taobao.weex.el.parse.Operators.CONDITION_IF_STRING : "");
        return sb.toString();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedType makeNullableAsSpecified(boolean z) {
        return z == isMarkedNullable() ? this : new kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedType(this.typeProjection, getConstructor(), z, getAttributes());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public kotlin.reflect.jvm.internal.impl.types.SimpleType replaceAttributes(kotlin.reflect.jvm.internal.impl.types.TypeAttributes newAttributes) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(newAttributes, "newAttributes");
        return new kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedType(this.typeProjection, getConstructor(), isMarkedNullable(), newAttributes);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedType refine(kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner kotlinTypeRefiner) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        kotlin.reflect.jvm.internal.impl.types.TypeProjection typeProjectionRefine = this.typeProjection.refine(kotlinTypeRefiner);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(typeProjectionRefine, "refine(...)");
        return new kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedType(typeProjectionRefine, getConstructor(), isMarkedNullable(), getAttributes());
    }
}
