package kotlin.reflect.jvm.internal.impl.types;

/* JADX INFO: compiled from: TypeWithEnhancement.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SimpleTypeWithEnhancement extends kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType implements kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancement {
    private final kotlin.reflect.jvm.internal.impl.types.SimpleType delegate;
    private final kotlin.reflect.jvm.internal.impl.types.KotlinType enhancement;

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType
    protected kotlin.reflect.jvm.internal.impl.types.SimpleType getDelegate() {
        return this.delegate;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancement
    public kotlin.reflect.jvm.internal.impl.types.KotlinType getEnhancement() {
        return this.enhancement;
    }

    public SimpleTypeWithEnhancement(kotlin.reflect.jvm.internal.impl.types.SimpleType delegate, kotlin.reflect.jvm.internal.impl.types.KotlinType enhancement) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(delegate, "delegate");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(enhancement, "enhancement");
        this.delegate = delegate;
        this.enhancement = enhancement;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancement
    public kotlin.reflect.jvm.internal.impl.types.SimpleType getOrigin() {
        return getDelegate();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public kotlin.reflect.jvm.internal.impl.types.SimpleType replaceAttributes(kotlin.reflect.jvm.internal.impl.types.TypeAttributes newAttributes) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(newAttributes, "newAttributes");
        kotlin.reflect.jvm.internal.impl.types.UnwrappedType unwrappedTypeWrapEnhancement = kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt.wrapEnhancement(getOrigin().replaceAttributes(newAttributes), getEnhancement());
        kotlin.jvm.internal.Intrinsics.checkNotNull(unwrappedTypeWrapEnhancement, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return (kotlin.reflect.jvm.internal.impl.types.SimpleType) unwrappedTypeWrapEnhancement;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public kotlin.reflect.jvm.internal.impl.types.SimpleType makeNullableAsSpecified(boolean z) {
        kotlin.reflect.jvm.internal.impl.types.UnwrappedType unwrappedTypeWrapEnhancement = kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt.wrapEnhancement(getOrigin().makeNullableAsSpecified(z), getEnhancement().unwrap().makeNullableAsSpecified(z));
        kotlin.jvm.internal.Intrinsics.checkNotNull(unwrappedTypeWrapEnhancement, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return (kotlin.reflect.jvm.internal.impl.types.SimpleType) unwrappedTypeWrapEnhancement;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType
    public kotlin.reflect.jvm.internal.impl.types.SimpleTypeWithEnhancement replaceDelegate(kotlin.reflect.jvm.internal.impl.types.SimpleType delegate) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(delegate, "delegate");
        return new kotlin.reflect.jvm.internal.impl.types.SimpleTypeWithEnhancement(delegate, getEnhancement());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType, kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public kotlin.reflect.jvm.internal.impl.types.SimpleTypeWithEnhancement refine(kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner kotlinTypeRefiner) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinTypeRefineType = kotlinTypeRefiner.refineType((kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) getDelegate());
        kotlin.jvm.internal.Intrinsics.checkNotNull(kotlinTypeRefineType, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return new kotlin.reflect.jvm.internal.impl.types.SimpleTypeWithEnhancement((kotlin.reflect.jvm.internal.impl.types.SimpleType) kotlinTypeRefineType, kotlinTypeRefiner.refineType((kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) getEnhancement()));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.SimpleType
    public java.lang.String toString() {
        return "[@EnhancedForWarnings(" + getEnhancement() + ")] " + getOrigin();
    }
}
