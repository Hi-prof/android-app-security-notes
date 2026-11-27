package kotlin.reflect.jvm.internal.impl.types;

/* JADX INFO: compiled from: dynamicTypes.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DynamicType extends kotlin.reflect.jvm.internal.impl.types.FlexibleType implements kotlin.reflect.jvm.internal.impl.types.model.DynamicTypeMarker {
    private final kotlin.reflect.jvm.internal.impl.types.TypeAttributes attributes;

    @Override // kotlin.reflect.jvm.internal.impl.types.FlexibleType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public boolean isMarkedNullable() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public kotlin.reflect.jvm.internal.impl.types.DynamicType makeNullableAsSpecified(boolean z) {
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public kotlin.reflect.jvm.internal.impl.types.DynamicType refine(kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner kotlinTypeRefiner) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.FlexibleType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public kotlin.reflect.jvm.internal.impl.types.TypeAttributes getAttributes() {
        return this.attributes;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public DynamicType(kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns builtIns, kotlin.reflect.jvm.internal.impl.types.TypeAttributes attributes) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(builtIns, "builtIns");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(attributes, "attributes");
        kotlin.reflect.jvm.internal.impl.types.SimpleType nothingType = builtIns.getNothingType();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nothingType, "getNothingType(...)");
        kotlin.reflect.jvm.internal.impl.types.SimpleType nullableAnyType = builtIns.getNullableAnyType();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nullableAnyType, "getNullableAnyType(...)");
        super(nothingType, nullableAnyType);
        this.attributes = attributes;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.FlexibleType
    public kotlin.reflect.jvm.internal.impl.types.SimpleType getDelegate() {
        return getUpperBound();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public kotlin.reflect.jvm.internal.impl.types.DynamicType replaceAttributes(kotlin.reflect.jvm.internal.impl.types.TypeAttributes newAttributes) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(newAttributes, "newAttributes");
        return new kotlin.reflect.jvm.internal.impl.types.DynamicType(kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.getBuiltIns(getDelegate()), newAttributes);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.FlexibleType
    public java.lang.String render(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer renderer, kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions options) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(renderer, "renderer");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(options, "options");
        return "dynamic";
    }
}
