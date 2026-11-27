package kotlin.reflect.jvm.internal.impl.types;

/* JADX INFO: compiled from: StubTypes.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StubTypeForBuilderInference extends kotlin.reflect.jvm.internal.impl.types.AbstractStubType implements kotlin.reflect.jvm.internal.impl.types.model.StubTypeMarker {
    private final kotlin.reflect.jvm.internal.impl.types.TypeConstructor constructor;
    private final kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope memberScope;

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public kotlin.reflect.jvm.internal.impl.types.TypeConstructor getConstructor() {
        return this.constructor;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StubTypeForBuilderInference(kotlin.reflect.jvm.internal.impl.types.checker.NewTypeVariableConstructor originalTypeVariable, boolean z, kotlin.reflect.jvm.internal.impl.types.TypeConstructor constructor) {
        super(originalTypeVariable, z);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(originalTypeVariable, "originalTypeVariable");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(constructor, "constructor");
        this.constructor = constructor;
        this.memberScope = originalTypeVariable.getBuiltIns().getAnyType().getMemberScope();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.AbstractStubType
    public kotlin.reflect.jvm.internal.impl.types.AbstractStubType materialize(boolean z) {
        return new kotlin.reflect.jvm.internal.impl.types.StubTypeForBuilderInference(getOriginalTypeVariable(), z, getConstructor());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.AbstractStubType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope getMemberScope() {
        return this.memberScope;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.SimpleType
    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("Stub (BI): ");
        sb.append(getOriginalTypeVariable());
        sb.append(isMarkedNullable() ? com.taobao.weex.el.parse.Operators.CONDITION_IF_STRING : "");
        return sb.toString();
    }
}
