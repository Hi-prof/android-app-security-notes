package kotlin.reflect.jvm.internal.impl.types;

/* JADX INFO: compiled from: TypeWithEnhancement.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FlexibleTypeWithEnhancement extends kotlin.reflect.jvm.internal.impl.types.FlexibleType implements kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancement {
    private final kotlin.reflect.jvm.internal.impl.types.KotlinType enhancement;
    private final kotlin.reflect.jvm.internal.impl.types.FlexibleType origin;

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancement
    public kotlin.reflect.jvm.internal.impl.types.FlexibleType getOrigin() {
        return this.origin;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancement
    public kotlin.reflect.jvm.internal.impl.types.KotlinType getEnhancement() {
        return this.enhancement;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlexibleTypeWithEnhancement(kotlin.reflect.jvm.internal.impl.types.FlexibleType origin, kotlin.reflect.jvm.internal.impl.types.KotlinType enhancement) {
        super(origin.getLowerBound(), origin.getUpperBound());
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(origin, "origin");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(enhancement, "enhancement");
        this.origin = origin;
        this.enhancement = enhancement;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public kotlin.reflect.jvm.internal.impl.types.UnwrappedType replaceAttributes(kotlin.reflect.jvm.internal.impl.types.TypeAttributes newAttributes) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(newAttributes, "newAttributes");
        return kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt.wrapEnhancement(getOrigin().replaceAttributes(newAttributes), getEnhancement());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public kotlin.reflect.jvm.internal.impl.types.UnwrappedType makeNullableAsSpecified(boolean z) {
        return kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt.wrapEnhancement(getOrigin().makeNullableAsSpecified(z), getEnhancement().unwrap().makeNullableAsSpecified(z));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.FlexibleType
    public java.lang.String render(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer renderer, kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions options) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(renderer, "renderer");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(options, "options");
        if (options.getEnhancedTypes()) {
            return renderer.renderType(getEnhancement());
        }
        return getOrigin().render(renderer, options);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.FlexibleType
    public kotlin.reflect.jvm.internal.impl.types.SimpleType getDelegate() {
        return getOrigin().getDelegate();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public kotlin.reflect.jvm.internal.impl.types.FlexibleTypeWithEnhancement refine(kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner kotlinTypeRefiner) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinTypeRefineType = kotlinTypeRefiner.refineType((kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) getOrigin());
        kotlin.jvm.internal.Intrinsics.checkNotNull(kotlinTypeRefineType, "null cannot be cast to non-null type org.jetbrains.kotlin.types.FlexibleType");
        return new kotlin.reflect.jvm.internal.impl.types.FlexibleTypeWithEnhancement((kotlin.reflect.jvm.internal.impl.types.FlexibleType) kotlinTypeRefineType, kotlinTypeRefiner.refineType((kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) getEnhancement()));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.FlexibleType
    public java.lang.String toString() {
        return "[@EnhancedForWarnings(" + getEnhancement() + ")] " + getOrigin();
    }
}
