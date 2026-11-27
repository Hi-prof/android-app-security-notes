package kotlin.reflect.jvm.internal.impl.types;

/* JADX INFO: compiled from: KotlinTypeFactory.kt */
/* JADX INFO: loaded from: classes2.dex */
final class SimpleTypeImpl extends kotlin.reflect.jvm.internal.impl.types.SimpleType {
    private final java.util.List<kotlin.reflect.jvm.internal.impl.types.TypeProjection> arguments;
    private final kotlin.reflect.jvm.internal.impl.types.TypeConstructor constructor;
    private final boolean isMarkedNullable;
    private final kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope memberScope;
    private final kotlin.jvm.functions.Function1<kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner, kotlin.reflect.jvm.internal.impl.types.SimpleType> refinedTypeFactory;

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public kotlin.reflect.jvm.internal.impl.types.TypeConstructor getConstructor() {
        return this.constructor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public java.util.List<kotlin.reflect.jvm.internal.impl.types.TypeProjection> getArguments() {
        return this.arguments;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public boolean isMarkedNullable() {
        return this.isMarkedNullable;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope getMemberScope() {
        return this.memberScope;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SimpleTypeImpl(kotlin.reflect.jvm.internal.impl.types.TypeConstructor constructor, java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.TypeProjection> arguments, boolean z, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope memberScope, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner, ? extends kotlin.reflect.jvm.internal.impl.types.SimpleType> refinedTypeFactory) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(constructor, "constructor");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(arguments, "arguments");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(memberScope, "memberScope");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(refinedTypeFactory, "refinedTypeFactory");
        this.constructor = constructor;
        this.arguments = arguments;
        this.isMarkedNullable = z;
        this.memberScope = memberScope;
        this.refinedTypeFactory = refinedTypeFactory;
        if (!(getMemberScope() instanceof kotlin.reflect.jvm.internal.impl.types.error.ErrorScope) || (getMemberScope() instanceof kotlin.reflect.jvm.internal.impl.types.error.ThrowingScope)) {
            return;
        }
        throw new java.lang.IllegalStateException("SimpleTypeImpl should not be created for error type: " + getMemberScope() + '\n' + getConstructor());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public kotlin.reflect.jvm.internal.impl.types.TypeAttributes getAttributes() {
        return kotlin.reflect.jvm.internal.impl.types.TypeAttributes.Companion.getEmpty();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public kotlin.reflect.jvm.internal.impl.types.SimpleType replaceAttributes(kotlin.reflect.jvm.internal.impl.types.TypeAttributes newAttributes) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(newAttributes, "newAttributes");
        if (newAttributes.isEmpty()) {
            return this;
        }
        return new kotlin.reflect.jvm.internal.impl.types.SimpleTypeWithAttributes(this, newAttributes);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public kotlin.reflect.jvm.internal.impl.types.SimpleType makeNullableAsSpecified(boolean z) {
        if (z == isMarkedNullable()) {
            return this;
        }
        if (z) {
            return new kotlin.reflect.jvm.internal.impl.types.NullableSimpleType(this);
        }
        return new kotlin.reflect.jvm.internal.impl.types.NotNullSimpleType(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public kotlin.reflect.jvm.internal.impl.types.SimpleType refine(kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner kotlinTypeRefiner) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        kotlin.reflect.jvm.internal.impl.types.SimpleType simpleTypeInvoke2 = this.refinedTypeFactory.invoke2(kotlinTypeRefiner);
        return simpleTypeInvoke2 == null ? this : simpleTypeInvoke2;
    }
}
