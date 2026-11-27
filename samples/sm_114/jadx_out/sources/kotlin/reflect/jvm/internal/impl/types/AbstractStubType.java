package kotlin.reflect.jvm.internal.impl.types;

/* JADX INFO: compiled from: StubTypes.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractStubType extends kotlin.reflect.jvm.internal.impl.types.SimpleType {
    public static final kotlin.reflect.jvm.internal.impl.types.AbstractStubType.Companion Companion = new kotlin.reflect.jvm.internal.impl.types.AbstractStubType.Companion(null);
    private final boolean isMarkedNullable;
    private final kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope memberScope;
    private final kotlin.reflect.jvm.internal.impl.types.checker.NewTypeVariableConstructor originalTypeVariable;

    public abstract kotlin.reflect.jvm.internal.impl.types.AbstractStubType materialize(boolean z);

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public kotlin.reflect.jvm.internal.impl.types.AbstractStubType refine(kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner kotlinTypeRefiner) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }

    public AbstractStubType(kotlin.reflect.jvm.internal.impl.types.checker.NewTypeVariableConstructor originalTypeVariable, boolean z) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(originalTypeVariable, "originalTypeVariable");
        this.originalTypeVariable = originalTypeVariable;
        this.isMarkedNullable = z;
        this.memberScope = kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils.createErrorScope(kotlin.reflect.jvm.internal.impl.types.error.ErrorScopeKind.STUB_TYPE_SCOPE, originalTypeVariable.toString());
    }

    public final kotlin.reflect.jvm.internal.impl.types.checker.NewTypeVariableConstructor getOriginalTypeVariable() {
        return this.originalTypeVariable;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public boolean isMarkedNullable() {
        return this.isMarkedNullable;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope getMemberScope() {
        return this.memberScope;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public java.util.List<kotlin.reflect.jvm.internal.impl.types.TypeProjection> getArguments() {
        return kotlin.collections.CollectionsKt.emptyList();
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

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public kotlin.reflect.jvm.internal.impl.types.SimpleType makeNullableAsSpecified(boolean z) {
        return z == isMarkedNullable() ? this : materialize(z);
    }

    /* JADX INFO: compiled from: StubTypes.kt */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
