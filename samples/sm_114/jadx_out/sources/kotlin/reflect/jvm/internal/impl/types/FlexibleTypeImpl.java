package kotlin.reflect.jvm.internal.impl.types;

/* JADX INFO: compiled from: flexibleTypes.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FlexibleTypeImpl extends kotlin.reflect.jvm.internal.impl.types.FlexibleType implements kotlin.reflect.jvm.internal.impl.types.CustomTypeParameter {
    public static final kotlin.reflect.jvm.internal.impl.types.FlexibleTypeImpl.Companion Companion = new kotlin.reflect.jvm.internal.impl.types.FlexibleTypeImpl.Companion(null);
    public static boolean RUN_SLOW_ASSERTIONS;
    private boolean assertionsDone;

    /* JADX INFO: compiled from: flexibleTypes.kt */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlexibleTypeImpl(kotlin.reflect.jvm.internal.impl.types.SimpleType lowerBound, kotlin.reflect.jvm.internal.impl.types.SimpleType upperBound) {
        super(lowerBound, upperBound);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(lowerBound, "lowerBound");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(upperBound, "upperBound");
    }

    private final void runAssertions() {
        if (!RUN_SLOW_ASSERTIONS || this.assertionsDone) {
            return;
        }
        this.assertionsDone = true;
        kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt.isFlexible(getLowerBound());
        kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt.isFlexible(getUpperBound());
        kotlin.jvm.internal.Intrinsics.areEqual(getLowerBound(), getUpperBound());
        kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker.DEFAULT.isSubtypeOf(getLowerBound(), getUpperBound());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.FlexibleType
    public kotlin.reflect.jvm.internal.impl.types.SimpleType getDelegate() {
        runAssertions();
        return getLowerBound();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.CustomTypeParameter
    public boolean isTypeParameter() {
        return (getLowerBound().getConstructor().mo1835getDeclarationDescriptor() instanceof kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) && kotlin.jvm.internal.Intrinsics.areEqual(getLowerBound().getConstructor(), getUpperBound().getConstructor());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.CustomTypeParameter
    public kotlin.reflect.jvm.internal.impl.types.KotlinType substitutionResult(kotlin.reflect.jvm.internal.impl.types.KotlinType replacement) {
        kotlin.reflect.jvm.internal.impl.types.UnwrappedType unwrappedTypeFlexibleType;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(replacement, "replacement");
        kotlin.reflect.jvm.internal.impl.types.UnwrappedType unwrappedTypeUnwrap = replacement.unwrap();
        if (unwrappedTypeUnwrap instanceof kotlin.reflect.jvm.internal.impl.types.FlexibleType) {
            unwrappedTypeFlexibleType = unwrappedTypeUnwrap;
        } else {
            if (!(unwrappedTypeUnwrap instanceof kotlin.reflect.jvm.internal.impl.types.SimpleType)) {
                throw new kotlin.NoWhenBranchMatchedException();
            }
            kotlin.reflect.jvm.internal.impl.types.SimpleType simpleType = (kotlin.reflect.jvm.internal.impl.types.SimpleType) unwrappedTypeUnwrap;
            unwrappedTypeFlexibleType = kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.flexibleType(simpleType, simpleType.makeNullableAsSpecified(true));
        }
        return kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt.inheritEnhancement(unwrappedTypeFlexibleType, unwrappedTypeUnwrap);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public kotlin.reflect.jvm.internal.impl.types.UnwrappedType replaceAttributes(kotlin.reflect.jvm.internal.impl.types.TypeAttributes newAttributes) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(newAttributes, "newAttributes");
        return kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.flexibleType(getLowerBound().replaceAttributes(newAttributes), getUpperBound().replaceAttributes(newAttributes));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.FlexibleType
    public java.lang.String render(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer renderer, kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions options) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(renderer, "renderer");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(options, "options");
        if (options.getDebugMode()) {
            return com.taobao.weex.el.parse.Operators.BRACKET_START_STR + renderer.renderType(getLowerBound()) + io.dcloud.common.util.PdrUtil.FILE_PATH_ENTRY_BACK + renderer.renderType(getUpperBound()) + com.taobao.weex.el.parse.Operators.BRACKET_END;
        }
        return renderer.renderFlexibleType(renderer.renderType(getLowerBound()), renderer.renderType(getUpperBound()), kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.getBuiltIns(this));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.FlexibleType
    public java.lang.String toString() {
        return com.taobao.weex.el.parse.Operators.BRACKET_START_STR + getLowerBound() + io.dcloud.common.util.PdrUtil.FILE_PATH_ENTRY_BACK + getUpperBound() + com.taobao.weex.el.parse.Operators.BRACKET_END;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public kotlin.reflect.jvm.internal.impl.types.UnwrappedType makeNullableAsSpecified(boolean z) {
        return kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.flexibleType(getLowerBound().makeNullableAsSpecified(z), getUpperBound().makeNullableAsSpecified(z));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public kotlin.reflect.jvm.internal.impl.types.FlexibleType refine(kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner kotlinTypeRefiner) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinTypeRefineType = kotlinTypeRefiner.refineType((kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) getLowerBound());
        kotlin.jvm.internal.Intrinsics.checkNotNull(kotlinTypeRefineType, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinTypeRefineType2 = kotlinTypeRefiner.refineType((kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) getUpperBound());
        kotlin.jvm.internal.Intrinsics.checkNotNull(kotlinTypeRefineType2, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return new kotlin.reflect.jvm.internal.impl.types.FlexibleTypeImpl((kotlin.reflect.jvm.internal.impl.types.SimpleType) kotlinTypeRefineType, (kotlin.reflect.jvm.internal.impl.types.SimpleType) kotlinTypeRefineType2);
    }
}
