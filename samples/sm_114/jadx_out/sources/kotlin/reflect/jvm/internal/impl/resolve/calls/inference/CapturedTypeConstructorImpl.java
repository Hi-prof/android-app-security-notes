package kotlin.reflect.jvm.internal.impl.resolve.calls.inference;

/* JADX INFO: compiled from: CapturedTypeConstructor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CapturedTypeConstructorImpl implements kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructor {
    private kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor newTypeConstructor;
    private final kotlin.reflect.jvm.internal.impl.types.TypeProjection projection;

    public java.lang.Void getDeclarationDescriptor() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public boolean isDenotable() {
        return false;
    }

    public CapturedTypeConstructorImpl(kotlin.reflect.jvm.internal.impl.types.TypeProjection projection) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(projection, "projection");
        this.projection = projection;
        getProjection().getProjectionKind();
        kotlin.reflect.jvm.internal.impl.types.Variance variance = kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    /* JADX INFO: renamed from: getDeclarationDescriptor, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor mo1835getDeclarationDescriptor() {
        return (kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor) getDeclarationDescriptor();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructor
    public kotlin.reflect.jvm.internal.impl.types.TypeProjection getProjection() {
        return this.projection;
    }

    public final kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor getNewTypeConstructor() {
        return this.newTypeConstructor;
    }

    public final void setNewTypeConstructor(kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor newCapturedTypeConstructor) {
        this.newTypeConstructor = newCapturedTypeConstructor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> getParameters() {
        return kotlin.collections.CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    /* JADX INFO: renamed from: getSupertypes */
    public java.util.Collection<kotlin.reflect.jvm.internal.impl.types.KotlinType> mo1836getSupertypes() {
        kotlin.reflect.jvm.internal.impl.types.SimpleType nullableAnyType;
        if (getProjection().getProjectionKind() == kotlin.reflect.jvm.internal.impl.types.Variance.OUT_VARIANCE) {
            nullableAnyType = getProjection().getType();
        } else {
            nullableAnyType = getBuiltIns().getNullableAnyType();
        }
        kotlin.jvm.internal.Intrinsics.checkNotNull(nullableAnyType);
        return kotlin.collections.CollectionsKt.listOf(nullableAnyType);
    }

    public java.lang.String toString() {
        return "CapturedTypeConstructor(" + getProjection() + com.taobao.weex.el.parse.Operators.BRACKET_END;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns getBuiltIns() {
        kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns builtIns = getProjection().getType().getConstructor().getBuiltIns();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(builtIns, "getBuiltIns(...)");
        return builtIns;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorImpl refine(kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner kotlinTypeRefiner) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        kotlin.reflect.jvm.internal.impl.types.TypeProjection typeProjectionRefine = getProjection().refine(kotlinTypeRefiner);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(typeProjectionRefine, "refine(...)");
        return new kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorImpl(typeProjectionRefine);
    }
}
