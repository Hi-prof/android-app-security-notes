package kotlin.reflect.jvm.internal.impl.km;

/* JADX INFO: compiled from: Attributes.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Attributes {
    static final /* synthetic */ kotlin.reflect.KProperty<java.lang.Object>[] $$delegatedProperties = {kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.km.Attributes.class, "hasAnnotations", "getHasAnnotations(Lkotlin/metadata/KmClass;)Z", 1)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.km.Attributes.class, "hasAnnotations", "getHasAnnotations(Lkotlin/metadata/KmConstructor;)Z", 1)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.km.Attributes.class, "hasAnnotations", "getHasAnnotations(Lkotlin/metadata/KmFunction;)Z", 1)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.km.Attributes.class, "hasAnnotations", "getHasAnnotations(Lkotlin/metadata/KmProperty;)Z", 1)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.km.Attributes.class, "hasAnnotations", "getHasAnnotations(Lkotlin/metadata/KmPropertyAccessorAttributes;)Z", 1)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.km.Attributes.class, "hasAnnotations", "getHasAnnotations(Lkotlin/metadata/KmValueParameter;)Z", 1)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.km.Attributes.class, "hasAnnotations", "getHasAnnotations(Lkotlin/metadata/KmTypeAlias;)Z", 1)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.km.Attributes.class, "modality", "getModality(Lkotlin/metadata/KmClass;)Lkotlin/metadata/Modality;", 1)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.km.Attributes.class, com.taobao.weex.common.Constants.Name.VISIBILITY, "getVisibility(Lkotlin/metadata/KmClass;)Lkotlin/metadata/Visibility;", 1)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.km.Attributes.class, "kind", "getKind(Lkotlin/metadata/KmClass;)Lkotlin/metadata/ClassKind;", 1)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.km.Attributes.class, "isInner", "isInner(Lkotlin/metadata/KmClass;)Z", 1)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.km.Attributes.class, "isData", "isData(Lkotlin/metadata/KmClass;)Z", 1)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.km.Attributes.class, "isExternal", "isExternal(Lkotlin/metadata/KmClass;)Z", 1)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.km.Attributes.class, "isExpect", "isExpect(Lkotlin/metadata/KmClass;)Z", 1)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.km.Attributes.class, "isValue", "isValue(Lkotlin/metadata/KmClass;)Z", 1)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.km.Attributes.class, "isFunInterface", "isFunInterface(Lkotlin/metadata/KmClass;)Z", 1)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.km.Attributes.class, "hasEnumEntries", "getHasEnumEntries(Lkotlin/metadata/KmClass;)Z", 1)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.km.Attributes.class, com.taobao.weex.common.Constants.Name.VISIBILITY, "getVisibility(Lkotlin/metadata/KmConstructor;)Lkotlin/metadata/Visibility;", 1)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.km.Attributes.class, "isSecondary", "isSecondary(Lkotlin/metadata/KmConstructor;)Z", 1)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.km.Attributes.class, "hasNonStableParameterNames", "getHasNonStableParameterNames(Lkotlin/metadata/KmConstructor;)Z", 1)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.km.Attributes.class, "kind", "getKind(Lkotlin/metadata/KmFunction;)Lkotlin/metadata/MemberKind;", 1)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.km.Attributes.class, com.taobao.weex.common.Constants.Name.VISIBILITY, "getVisibility(Lkotlin/metadata/KmFunction;)Lkotlin/metadata/Visibility;", 1)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.km.Attributes.class, "modality", "getModality(Lkotlin/metadata/KmFunction;)Lkotlin/metadata/Modality;", 1)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.km.Attributes.class, "isOperator", "isOperator(Lkotlin/metadata/KmFunction;)Z", 1)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.km.Attributes.class, "isInfix", "isInfix(Lkotlin/metadata/KmFunction;)Z", 1)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.km.Attributes.class, "isInline", "isInline(Lkotlin/metadata/KmFunction;)Z", 1)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.km.Attributes.class, "isTailrec", "isTailrec(Lkotlin/metadata/KmFunction;)Z", 1)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.km.Attributes.class, "isExternal", "isExternal(Lkotlin/metadata/KmFunction;)Z", 1)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.km.Attributes.class, "isSuspend", "isSuspend(Lkotlin/metadata/KmFunction;)Z", 1)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.km.Attributes.class, "isExpect", "isExpect(Lkotlin/metadata/KmFunction;)Z", 1)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.km.Attributes.class, "hasNonStableParameterNames", "getHasNonStableParameterNames(Lkotlin/metadata/KmFunction;)Z", 1)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.km.Attributes.class, com.taobao.weex.common.Constants.Name.VISIBILITY, "getVisibility(Lkotlin/metadata/KmProperty;)Lkotlin/metadata/Visibility;", 1)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.km.Attributes.class, "modality", "getModality(Lkotlin/metadata/KmProperty;)Lkotlin/metadata/Modality;", 1)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.km.Attributes.class, "kind", "getKind(Lkotlin/metadata/KmProperty;)Lkotlin/metadata/MemberKind;", 1)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.km.Attributes.class, "isVar", "isVar(Lkotlin/metadata/KmProperty;)Z", 1)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.km.Attributes.class, "isConst", "isConst(Lkotlin/metadata/KmProperty;)Z", 1)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.km.Attributes.class, "isLateinit", "isLateinit(Lkotlin/metadata/KmProperty;)Z", 1)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.km.Attributes.class, "hasConstant", "getHasConstant(Lkotlin/metadata/KmProperty;)Z", 1)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.km.Attributes.class, "isExternal", "isExternal(Lkotlin/metadata/KmProperty;)Z", 1)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.km.Attributes.class, "isDelegated", "isDelegated(Lkotlin/metadata/KmProperty;)Z", 1)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.km.Attributes.class, "isExpect", "isExpect(Lkotlin/metadata/KmProperty;)Z", 1)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.km.Attributes.class, com.taobao.weex.common.Constants.Name.VISIBILITY, "getVisibility(Lkotlin/metadata/KmPropertyAccessorAttributes;)Lkotlin/metadata/Visibility;", 1)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.km.Attributes.class, "modality", "getModality(Lkotlin/metadata/KmPropertyAccessorAttributes;)Lkotlin/metadata/Modality;", 1)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.km.Attributes.class, "isNotDefault", "isNotDefault(Lkotlin/metadata/KmPropertyAccessorAttributes;)Z", 1)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.km.Attributes.class, "isExternal", "isExternal(Lkotlin/metadata/KmPropertyAccessorAttributes;)Z", 1)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.km.Attributes.class, "isInline", "isInline(Lkotlin/metadata/KmPropertyAccessorAttributes;)Z", 1)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.km.Attributes.class, "isNullable", "isNullable(Lkotlin/metadata/KmType;)Z", 1)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.km.Attributes.class, "isSuspend", "isSuspend(Lkotlin/metadata/KmType;)Z", 1)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.km.Attributes.class, "isDefinitelyNonNull", "isDefinitelyNonNull(Lkotlin/metadata/KmType;)Z", 1)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.km.Attributes.class, "isReified", "isReified(Lkotlin/metadata/KmTypeParameter;)Z", 1)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.km.Attributes.class, com.taobao.weex.common.Constants.Name.VISIBILITY, "getVisibility(Lkotlin/metadata/KmTypeAlias;)Lkotlin/metadata/Visibility;", 1)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.km.Attributes.class, "declaresDefaultValue", "getDeclaresDefaultValue(Lkotlin/metadata/KmValueParameter;)Z", 1)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.km.Attributes.class, "isCrossinline", "isCrossinline(Lkotlin/metadata/KmValueParameter;)Z", 1)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.km.Attributes.class, "isNoinline", "isNoinline(Lkotlin/metadata/KmValueParameter;)Z", 1)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.km.Attributes.class, "isNegated", "isNegated(Lkotlin/metadata/KmEffectExpression;)Z", 1)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.km.Attributes.class, "isNullCheckPredicate", "isNullCheckPredicate(Lkotlin/metadata/KmEffectExpression;)Z", 1))};
    private static final kotlin.reflect.jvm.internal.impl.km.internal.BooleanFlagDelegate declaresDefaultValue$delegate;
    private static final kotlin.reflect.jvm.internal.impl.km.internal.BooleanFlagDelegate hasAnnotations$delegate;
    private static final kotlin.reflect.jvm.internal.impl.km.internal.BooleanFlagDelegate hasAnnotations$delegate$1;
    private static final kotlin.reflect.jvm.internal.impl.km.internal.BooleanFlagDelegate hasAnnotations$delegate$2;
    private static final kotlin.reflect.jvm.internal.impl.km.internal.BooleanFlagDelegate hasAnnotations$delegate$3;
    private static final kotlin.reflect.jvm.internal.impl.km.internal.BooleanFlagDelegate hasAnnotations$delegate$4;
    private static final kotlin.reflect.jvm.internal.impl.km.internal.BooleanFlagDelegate hasAnnotations$delegate$5;
    private static final kotlin.reflect.jvm.internal.impl.km.internal.BooleanFlagDelegate hasAnnotations$delegate$6;
    private static final kotlin.reflect.jvm.internal.impl.km.internal.BooleanFlagDelegate hasConstant$delegate;
    private static final kotlin.reflect.jvm.internal.impl.km.internal.BooleanFlagDelegate hasEnumEntries$delegate;
    private static final kotlin.reflect.jvm.internal.impl.km.internal.BooleanFlagDelegate hasNonStableParameterNames$delegate;
    private static final kotlin.reflect.jvm.internal.impl.km.internal.BooleanFlagDelegate hasNonStableParameterNames$delegate$1;
    private static final kotlin.reflect.jvm.internal.impl.km.internal.BooleanFlagDelegate isConst$delegate;
    private static final kotlin.reflect.jvm.internal.impl.km.internal.BooleanFlagDelegate isCrossinline$delegate;
    private static final kotlin.reflect.jvm.internal.impl.km.internal.BooleanFlagDelegate isData$delegate;
    private static final kotlin.reflect.jvm.internal.impl.km.internal.BooleanFlagDelegate isDefinitelyNonNull$delegate;
    private static final kotlin.reflect.jvm.internal.impl.km.internal.BooleanFlagDelegate isDelegated$delegate;
    private static final kotlin.reflect.jvm.internal.impl.km.internal.BooleanFlagDelegate isExpect$delegate;
    private static final kotlin.reflect.jvm.internal.impl.km.internal.BooleanFlagDelegate isExpect$delegate$1;
    private static final kotlin.reflect.jvm.internal.impl.km.internal.BooleanFlagDelegate isExpect$delegate$2;
    private static final kotlin.reflect.jvm.internal.impl.km.internal.BooleanFlagDelegate isExternal$delegate;
    private static final kotlin.reflect.jvm.internal.impl.km.internal.BooleanFlagDelegate isExternal$delegate$1;
    private static final kotlin.reflect.jvm.internal.impl.km.internal.BooleanFlagDelegate isExternal$delegate$2;
    private static final kotlin.reflect.jvm.internal.impl.km.internal.BooleanFlagDelegate isExternal$delegate$3;
    private static final kotlin.reflect.jvm.internal.impl.km.internal.BooleanFlagDelegate isFunInterface$delegate;
    private static final kotlin.reflect.jvm.internal.impl.km.internal.BooleanFlagDelegate isInfix$delegate;
    private static final kotlin.reflect.jvm.internal.impl.km.internal.BooleanFlagDelegate isInline$delegate;
    private static final kotlin.reflect.jvm.internal.impl.km.internal.BooleanFlagDelegate isInline$delegate$1;
    private static final kotlin.reflect.jvm.internal.impl.km.internal.BooleanFlagDelegate isInner$delegate;
    private static final kotlin.reflect.jvm.internal.impl.km.internal.BooleanFlagDelegate isLateinit$delegate;
    private static final kotlin.reflect.jvm.internal.impl.km.internal.BooleanFlagDelegate isNegated$delegate;
    private static final kotlin.reflect.jvm.internal.impl.km.internal.BooleanFlagDelegate isNoinline$delegate;
    private static final kotlin.reflect.jvm.internal.impl.km.internal.BooleanFlagDelegate isNotDefault$delegate;
    private static final kotlin.reflect.jvm.internal.impl.km.internal.BooleanFlagDelegate isNullCheckPredicate$delegate;
    private static final kotlin.reflect.jvm.internal.impl.km.internal.BooleanFlagDelegate isNullable$delegate;
    private static final kotlin.reflect.jvm.internal.impl.km.internal.BooleanFlagDelegate isOperator$delegate;
    private static final kotlin.reflect.jvm.internal.impl.km.internal.BooleanFlagDelegate isReified$delegate;
    private static final kotlin.reflect.jvm.internal.impl.km.internal.BooleanFlagDelegate isSecondary$delegate;
    private static final kotlin.reflect.jvm.internal.impl.km.internal.BooleanFlagDelegate isSuspend$delegate;
    private static final kotlin.reflect.jvm.internal.impl.km.internal.BooleanFlagDelegate isSuspend$delegate$1;
    private static final kotlin.reflect.jvm.internal.impl.km.internal.BooleanFlagDelegate isTailrec$delegate;
    private static final kotlin.reflect.jvm.internal.impl.km.internal.BooleanFlagDelegate isValue$delegate;
    private static final kotlin.reflect.jvm.internal.impl.km.internal.BooleanFlagDelegate isVar$delegate;
    private static final kotlin.reflect.jvm.internal.impl.km.internal.EnumFlagDelegate kind$delegate;
    private static final kotlin.reflect.jvm.internal.impl.km.internal.EnumFlagDelegate kind$delegate$1;
    private static final kotlin.reflect.jvm.internal.impl.km.internal.EnumFlagDelegate kind$delegate$2;
    private static final kotlin.reflect.jvm.internal.impl.km.internal.EnumFlagDelegate modality$delegate;
    private static final kotlin.reflect.jvm.internal.impl.km.internal.EnumFlagDelegate modality$delegate$1;
    private static final kotlin.reflect.jvm.internal.impl.km.internal.EnumFlagDelegate modality$delegate$2;
    private static final kotlin.reflect.jvm.internal.impl.km.internal.EnumFlagDelegate modality$delegate$3;
    private static final kotlin.reflect.jvm.internal.impl.km.internal.EnumFlagDelegate visibility$delegate;
    private static final kotlin.reflect.jvm.internal.impl.km.internal.EnumFlagDelegate visibility$delegate$1;
    private static final kotlin.reflect.jvm.internal.impl.km.internal.EnumFlagDelegate visibility$delegate$2;
    private static final kotlin.reflect.jvm.internal.impl.km.internal.EnumFlagDelegate visibility$delegate$3;
    private static final kotlin.reflect.jvm.internal.impl.km.internal.EnumFlagDelegate visibility$delegate$4;
    private static final kotlin.reflect.jvm.internal.impl.km.internal.EnumFlagDelegate visibility$delegate$5;

    public static final kotlin.reflect.jvm.internal.impl.km.Modality getModality(kotlin.reflect.jvm.internal.impl.km.KmClass kmClass) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kmClass, "<this>");
        return (kotlin.reflect.jvm.internal.impl.km.Modality) modality$delegate.getValue(kmClass, $$delegatedProperties[7]);
    }

    public static final kotlin.reflect.jvm.internal.impl.km.ClassKind getKind(kotlin.reflect.jvm.internal.impl.km.KmClass kmClass) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kmClass, "<this>");
        return (kotlin.reflect.jvm.internal.impl.km.ClassKind) kind$delegate.getValue(kmClass, $$delegatedProperties[9]);
    }

    public static final boolean isInner(kotlin.reflect.jvm.internal.impl.km.KmClass kmClass) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kmClass, "<this>");
        return isInner$delegate.getValue(kmClass, $$delegatedProperties[10]);
    }

    public static final boolean isData(kotlin.reflect.jvm.internal.impl.km.KmClass kmClass) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kmClass, "<this>");
        return isData$delegate.getValue(kmClass, $$delegatedProperties[11]);
    }

    public static final boolean isValue(kotlin.reflect.jvm.internal.impl.km.KmClass kmClass) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kmClass, "<this>");
        return isValue$delegate.getValue(kmClass, $$delegatedProperties[14]);
    }

    public static final boolean isFunInterface(kotlin.reflect.jvm.internal.impl.km.KmClass kmClass) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kmClass, "<this>");
        return isFunInterface$delegate.getValue(kmClass, $$delegatedProperties[15]);
    }

    public static final boolean isNullable(kotlin.reflect.jvm.internal.impl.km.KmType kmType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kmType, "<this>");
        return isNullable$delegate.getValue(kmType, $$delegatedProperties[46]);
    }

    public static final boolean isReified(kotlin.reflect.jvm.internal.impl.km.KmTypeParameter kmTypeParameter) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kmTypeParameter, "<this>");
        return isReified$delegate.getValue(kmTypeParameter, $$delegatedProperties[49]);
    }

    static {
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.BooleanFlagField HAS_ANNOTATIONS = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.HAS_ANNOTATIONS;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(HAS_ANNOTATIONS, "HAS_ANNOTATIONS");
        hasAnnotations$delegate = kotlin.reflect.jvm.internal.impl.km.internal.FlagDelegatesImplKt.classBooleanFlag(new kotlin.reflect.jvm.internal.impl.km.internal.FlagImpl(HAS_ANNOTATIONS));
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.BooleanFlagField HAS_ANNOTATIONS2 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.HAS_ANNOTATIONS;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(HAS_ANNOTATIONS2, "HAS_ANNOTATIONS");
        hasAnnotations$delegate$1 = kotlin.reflect.jvm.internal.impl.km.internal.FlagDelegatesImplKt.constructorBooleanFlag(new kotlin.reflect.jvm.internal.impl.km.internal.FlagImpl(HAS_ANNOTATIONS2));
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.BooleanFlagField HAS_ANNOTATIONS3 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.HAS_ANNOTATIONS;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(HAS_ANNOTATIONS3, "HAS_ANNOTATIONS");
        hasAnnotations$delegate$2 = kotlin.reflect.jvm.internal.impl.km.internal.FlagDelegatesImplKt.functionBooleanFlag(new kotlin.reflect.jvm.internal.impl.km.internal.FlagImpl(HAS_ANNOTATIONS3));
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.BooleanFlagField HAS_ANNOTATIONS4 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.HAS_ANNOTATIONS;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(HAS_ANNOTATIONS4, "HAS_ANNOTATIONS");
        hasAnnotations$delegate$3 = kotlin.reflect.jvm.internal.impl.km.internal.FlagDelegatesImplKt.propertyBooleanFlag(new kotlin.reflect.jvm.internal.impl.km.internal.FlagImpl(HAS_ANNOTATIONS4));
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.BooleanFlagField HAS_ANNOTATIONS5 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.HAS_ANNOTATIONS;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(HAS_ANNOTATIONS5, "HAS_ANNOTATIONS");
        hasAnnotations$delegate$4 = kotlin.reflect.jvm.internal.impl.km.internal.FlagDelegatesImplKt.propertyAccessorBooleanFlag(new kotlin.reflect.jvm.internal.impl.km.internal.FlagImpl(HAS_ANNOTATIONS5));
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.BooleanFlagField HAS_ANNOTATIONS6 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.HAS_ANNOTATIONS;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(HAS_ANNOTATIONS6, "HAS_ANNOTATIONS");
        hasAnnotations$delegate$5 = kotlin.reflect.jvm.internal.impl.km.internal.FlagDelegatesImplKt.valueParameterBooleanFlag(new kotlin.reflect.jvm.internal.impl.km.internal.FlagImpl(HAS_ANNOTATIONS6));
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.BooleanFlagField HAS_ANNOTATIONS7 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.HAS_ANNOTATIONS;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(HAS_ANNOTATIONS7, "HAS_ANNOTATIONS");
        hasAnnotations$delegate$6 = kotlin.reflect.jvm.internal.impl.km.internal.FlagDelegatesImplKt.typeAliasBooleanFlag(new kotlin.reflect.jvm.internal.impl.km.internal.FlagImpl(HAS_ANNOTATIONS7));
        modality$delegate = kotlin.reflect.jvm.internal.impl.km.internal.FlagDelegatesImplKt.modalityDelegate(new kotlin.jvm.internal.MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.Attributes$modality$2
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public java.lang.Object get(java.lang.Object obj) {
                return java.lang.Integer.valueOf(((kotlin.reflect.jvm.internal.impl.km.KmClass) obj).getFlags$kotlin_metadata());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(java.lang.Object obj, java.lang.Object obj2) {
                ((kotlin.reflect.jvm.internal.impl.km.KmClass) obj).setFlags$kotlin_metadata(((java.lang.Number) obj2).intValue());
            }
        });
        visibility$delegate = kotlin.reflect.jvm.internal.impl.km.internal.FlagDelegatesImplKt.visibilityDelegate(new kotlin.jvm.internal.MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.Attributes$visibility$2
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public java.lang.Object get(java.lang.Object obj) {
                return java.lang.Integer.valueOf(((kotlin.reflect.jvm.internal.impl.km.KmClass) obj).getFlags$kotlin_metadata());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(java.lang.Object obj, java.lang.Object obj2) {
                ((kotlin.reflect.jvm.internal.impl.km.KmClass) obj).setFlags$kotlin_metadata(((java.lang.Number) obj2).intValue());
            }
        });
        kotlin.reflect.jvm.internal.impl.km.Attributes$kind$2 attributes$kind$2 = new kotlin.jvm.internal.MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.Attributes$kind$2
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public java.lang.Object get(java.lang.Object obj) {
                return java.lang.Integer.valueOf(((kotlin.reflect.jvm.internal.impl.km.KmClass) obj).getFlags$kotlin_metadata());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(java.lang.Object obj, java.lang.Object obj2) {
                ((kotlin.reflect.jvm.internal.impl.km.KmClass) obj).setFlags$kotlin_metadata(((java.lang.Number) obj2).intValue());
            }
        };
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.FlagField<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class.Kind> CLASS_KIND = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.CLASS_KIND;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(CLASS_KIND, "CLASS_KIND");
        kotlin.enums.EnumEntries<kotlin.reflect.jvm.internal.impl.km.ClassKind> entries = kotlin.reflect.jvm.internal.impl.km.ClassKind.getEntries();
        kotlin.enums.EnumEntries<kotlin.reflect.jvm.internal.impl.km.ClassKind> entries2 = kotlin.reflect.jvm.internal.impl.km.ClassKind.getEntries();
        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(entries2, 10));
        java.util.Iterator<kotlin.reflect.jvm.internal.impl.km.ClassKind> it = entries2.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getFlag$kotlin_metadata());
        }
        kind$delegate = new kotlin.reflect.jvm.internal.impl.km.internal.EnumFlagDelegate(attributes$kind$2, CLASS_KIND, entries, arrayList);
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.BooleanFlagField IS_INNER = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_INNER;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(IS_INNER, "IS_INNER");
        isInner$delegate = kotlin.reflect.jvm.internal.impl.km.internal.FlagDelegatesImplKt.classBooleanFlag(new kotlin.reflect.jvm.internal.impl.km.internal.FlagImpl(IS_INNER));
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.BooleanFlagField IS_DATA = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_DATA;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(IS_DATA, "IS_DATA");
        isData$delegate = kotlin.reflect.jvm.internal.impl.km.internal.FlagDelegatesImplKt.classBooleanFlag(new kotlin.reflect.jvm.internal.impl.km.internal.FlagImpl(IS_DATA));
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.BooleanFlagField IS_EXTERNAL_CLASS = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_EXTERNAL_CLASS;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(IS_EXTERNAL_CLASS, "IS_EXTERNAL_CLASS");
        isExternal$delegate = kotlin.reflect.jvm.internal.impl.km.internal.FlagDelegatesImplKt.classBooleanFlag(new kotlin.reflect.jvm.internal.impl.km.internal.FlagImpl(IS_EXTERNAL_CLASS));
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.BooleanFlagField IS_EXPECT_CLASS = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_EXPECT_CLASS;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(IS_EXPECT_CLASS, "IS_EXPECT_CLASS");
        isExpect$delegate = kotlin.reflect.jvm.internal.impl.km.internal.FlagDelegatesImplKt.classBooleanFlag(new kotlin.reflect.jvm.internal.impl.km.internal.FlagImpl(IS_EXPECT_CLASS));
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.BooleanFlagField IS_VALUE_CLASS = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_VALUE_CLASS;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(IS_VALUE_CLASS, "IS_VALUE_CLASS");
        isValue$delegate = kotlin.reflect.jvm.internal.impl.km.internal.FlagDelegatesImplKt.classBooleanFlag(new kotlin.reflect.jvm.internal.impl.km.internal.FlagImpl(IS_VALUE_CLASS));
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.BooleanFlagField IS_FUN_INTERFACE = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_FUN_INTERFACE;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(IS_FUN_INTERFACE, "IS_FUN_INTERFACE");
        isFunInterface$delegate = kotlin.reflect.jvm.internal.impl.km.internal.FlagDelegatesImplKt.classBooleanFlag(new kotlin.reflect.jvm.internal.impl.km.internal.FlagImpl(IS_FUN_INTERFACE));
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.BooleanFlagField HAS_ENUM_ENTRIES = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.HAS_ENUM_ENTRIES;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(HAS_ENUM_ENTRIES, "HAS_ENUM_ENTRIES");
        hasEnumEntries$delegate = kotlin.reflect.jvm.internal.impl.km.internal.FlagDelegatesImplKt.classBooleanFlag(new kotlin.reflect.jvm.internal.impl.km.internal.FlagImpl(HAS_ENUM_ENTRIES));
        visibility$delegate$1 = kotlin.reflect.jvm.internal.impl.km.internal.FlagDelegatesImplKt.visibilityDelegate(new kotlin.jvm.internal.MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.Attributes$visibility$6
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public java.lang.Object get(java.lang.Object obj) {
                return java.lang.Integer.valueOf(((kotlin.reflect.jvm.internal.impl.km.KmConstructor) obj).getFlags$kotlin_metadata());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(java.lang.Object obj, java.lang.Object obj2) {
                ((kotlin.reflect.jvm.internal.impl.km.KmConstructor) obj).setFlags$kotlin_metadata(((java.lang.Number) obj2).intValue());
            }
        });
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.BooleanFlagField IS_SECONDARY = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_SECONDARY;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(IS_SECONDARY, "IS_SECONDARY");
        isSecondary$delegate = kotlin.reflect.jvm.internal.impl.km.internal.FlagDelegatesImplKt.constructorBooleanFlag(new kotlin.reflect.jvm.internal.impl.km.internal.FlagImpl(IS_SECONDARY));
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.BooleanFlagField IS_CONSTRUCTOR_WITH_NON_STABLE_PARAMETER_NAMES = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_CONSTRUCTOR_WITH_NON_STABLE_PARAMETER_NAMES;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(IS_CONSTRUCTOR_WITH_NON_STABLE_PARAMETER_NAMES, "IS_CONSTRUCTOR_WITH_NON_STABLE_PARAMETER_NAMES");
        hasNonStableParameterNames$delegate = kotlin.reflect.jvm.internal.impl.km.internal.FlagDelegatesImplKt.constructorBooleanFlag(new kotlin.reflect.jvm.internal.impl.km.internal.FlagImpl(IS_CONSTRUCTOR_WITH_NON_STABLE_PARAMETER_NAMES));
        kind$delegate$1 = kotlin.reflect.jvm.internal.impl.km.internal.FlagDelegatesImplKt.memberKindDelegate(new kotlin.jvm.internal.MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.Attributes$kind$7
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public java.lang.Object get(java.lang.Object obj) {
                return java.lang.Integer.valueOf(((kotlin.reflect.jvm.internal.impl.km.KmFunction) obj).getFlags$kotlin_metadata());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(java.lang.Object obj, java.lang.Object obj2) {
                ((kotlin.reflect.jvm.internal.impl.km.KmFunction) obj).setFlags$kotlin_metadata(((java.lang.Number) obj2).intValue());
            }
        });
        visibility$delegate$2 = kotlin.reflect.jvm.internal.impl.km.internal.FlagDelegatesImplKt.visibilityDelegate(new kotlin.jvm.internal.MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.Attributes$visibility$10
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public java.lang.Object get(java.lang.Object obj) {
                return java.lang.Integer.valueOf(((kotlin.reflect.jvm.internal.impl.km.KmFunction) obj).getFlags$kotlin_metadata());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(java.lang.Object obj, java.lang.Object obj2) {
                ((kotlin.reflect.jvm.internal.impl.km.KmFunction) obj).setFlags$kotlin_metadata(((java.lang.Number) obj2).intValue());
            }
        });
        modality$delegate$1 = kotlin.reflect.jvm.internal.impl.km.internal.FlagDelegatesImplKt.modalityDelegate(new kotlin.jvm.internal.MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.Attributes$modality$6
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public java.lang.Object get(java.lang.Object obj) {
                return java.lang.Integer.valueOf(((kotlin.reflect.jvm.internal.impl.km.KmFunction) obj).getFlags$kotlin_metadata());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(java.lang.Object obj, java.lang.Object obj2) {
                ((kotlin.reflect.jvm.internal.impl.km.KmFunction) obj).setFlags$kotlin_metadata(((java.lang.Number) obj2).intValue());
            }
        });
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.BooleanFlagField IS_OPERATOR = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_OPERATOR;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(IS_OPERATOR, "IS_OPERATOR");
        isOperator$delegate = kotlin.reflect.jvm.internal.impl.km.internal.FlagDelegatesImplKt.functionBooleanFlag(new kotlin.reflect.jvm.internal.impl.km.internal.FlagImpl(IS_OPERATOR));
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.BooleanFlagField IS_INFIX = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_INFIX;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(IS_INFIX, "IS_INFIX");
        isInfix$delegate = kotlin.reflect.jvm.internal.impl.km.internal.FlagDelegatesImplKt.functionBooleanFlag(new kotlin.reflect.jvm.internal.impl.km.internal.FlagImpl(IS_INFIX));
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.BooleanFlagField IS_INLINE = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_INLINE;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(IS_INLINE, "IS_INLINE");
        isInline$delegate = kotlin.reflect.jvm.internal.impl.km.internal.FlagDelegatesImplKt.functionBooleanFlag(new kotlin.reflect.jvm.internal.impl.km.internal.FlagImpl(IS_INLINE));
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.BooleanFlagField IS_TAILREC = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_TAILREC;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(IS_TAILREC, "IS_TAILREC");
        isTailrec$delegate = kotlin.reflect.jvm.internal.impl.km.internal.FlagDelegatesImplKt.functionBooleanFlag(new kotlin.reflect.jvm.internal.impl.km.internal.FlagImpl(IS_TAILREC));
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.BooleanFlagField IS_EXTERNAL_FUNCTION = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_EXTERNAL_FUNCTION;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(IS_EXTERNAL_FUNCTION, "IS_EXTERNAL_FUNCTION");
        isExternal$delegate$1 = kotlin.reflect.jvm.internal.impl.km.internal.FlagDelegatesImplKt.functionBooleanFlag(new kotlin.reflect.jvm.internal.impl.km.internal.FlagImpl(IS_EXTERNAL_FUNCTION));
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.BooleanFlagField IS_SUSPEND = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_SUSPEND;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(IS_SUSPEND, "IS_SUSPEND");
        isSuspend$delegate = kotlin.reflect.jvm.internal.impl.km.internal.FlagDelegatesImplKt.functionBooleanFlag(new kotlin.reflect.jvm.internal.impl.km.internal.FlagImpl(IS_SUSPEND));
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.BooleanFlagField IS_EXPECT_FUNCTION = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_EXPECT_FUNCTION;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(IS_EXPECT_FUNCTION, "IS_EXPECT_FUNCTION");
        isExpect$delegate$1 = kotlin.reflect.jvm.internal.impl.km.internal.FlagDelegatesImplKt.functionBooleanFlag(new kotlin.reflect.jvm.internal.impl.km.internal.FlagImpl(IS_EXPECT_FUNCTION));
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.BooleanFlagField IS_FUNCTION_WITH_NON_STABLE_PARAMETER_NAMES = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_FUNCTION_WITH_NON_STABLE_PARAMETER_NAMES;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(IS_FUNCTION_WITH_NON_STABLE_PARAMETER_NAMES, "IS_FUNCTION_WITH_NON_STABLE_PARAMETER_NAMES");
        hasNonStableParameterNames$delegate$1 = kotlin.reflect.jvm.internal.impl.km.internal.FlagDelegatesImplKt.functionBooleanFlag(new kotlin.reflect.jvm.internal.impl.km.internal.FlagImpl(IS_FUNCTION_WITH_NON_STABLE_PARAMETER_NAMES));
        visibility$delegate$3 = kotlin.reflect.jvm.internal.impl.km.internal.FlagDelegatesImplKt.visibilityDelegate(new kotlin.jvm.internal.MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.Attributes$visibility$14
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public java.lang.Object get(java.lang.Object obj) {
                return java.lang.Integer.valueOf(((kotlin.reflect.jvm.internal.impl.km.KmProperty) obj).getFlags$kotlin_metadata());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(java.lang.Object obj, java.lang.Object obj2) {
                ((kotlin.reflect.jvm.internal.impl.km.KmProperty) obj).setFlags$kotlin_metadata(((java.lang.Number) obj2).intValue());
            }
        });
        modality$delegate$2 = kotlin.reflect.jvm.internal.impl.km.internal.FlagDelegatesImplKt.modalityDelegate(new kotlin.jvm.internal.MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.Attributes$modality$10
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public java.lang.Object get(java.lang.Object obj) {
                return java.lang.Integer.valueOf(((kotlin.reflect.jvm.internal.impl.km.KmProperty) obj).getFlags$kotlin_metadata());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(java.lang.Object obj, java.lang.Object obj2) {
                ((kotlin.reflect.jvm.internal.impl.km.KmProperty) obj).setFlags$kotlin_metadata(((java.lang.Number) obj2).intValue());
            }
        });
        kind$delegate$2 = kotlin.reflect.jvm.internal.impl.km.internal.FlagDelegatesImplKt.memberKindDelegate(new kotlin.jvm.internal.MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.Attributes$kind$11
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public java.lang.Object get(java.lang.Object obj) {
                return java.lang.Integer.valueOf(((kotlin.reflect.jvm.internal.impl.km.KmProperty) obj).getFlags$kotlin_metadata());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(java.lang.Object obj, java.lang.Object obj2) {
                ((kotlin.reflect.jvm.internal.impl.km.KmProperty) obj).setFlags$kotlin_metadata(((java.lang.Number) obj2).intValue());
            }
        });
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.BooleanFlagField IS_VAR = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_VAR;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(IS_VAR, "IS_VAR");
        isVar$delegate = kotlin.reflect.jvm.internal.impl.km.internal.FlagDelegatesImplKt.propertyBooleanFlag(new kotlin.reflect.jvm.internal.impl.km.internal.FlagImpl(IS_VAR));
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.BooleanFlagField IS_CONST = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_CONST;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(IS_CONST, "IS_CONST");
        isConst$delegate = kotlin.reflect.jvm.internal.impl.km.internal.FlagDelegatesImplKt.propertyBooleanFlag(new kotlin.reflect.jvm.internal.impl.km.internal.FlagImpl(IS_CONST));
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.BooleanFlagField IS_LATEINIT = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_LATEINIT;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(IS_LATEINIT, "IS_LATEINIT");
        isLateinit$delegate = kotlin.reflect.jvm.internal.impl.km.internal.FlagDelegatesImplKt.propertyBooleanFlag(new kotlin.reflect.jvm.internal.impl.km.internal.FlagImpl(IS_LATEINIT));
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.BooleanFlagField HAS_CONSTANT = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.HAS_CONSTANT;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(HAS_CONSTANT, "HAS_CONSTANT");
        hasConstant$delegate = kotlin.reflect.jvm.internal.impl.km.internal.FlagDelegatesImplKt.propertyBooleanFlag(new kotlin.reflect.jvm.internal.impl.km.internal.FlagImpl(HAS_CONSTANT));
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.BooleanFlagField IS_EXTERNAL_PROPERTY = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_EXTERNAL_PROPERTY;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(IS_EXTERNAL_PROPERTY, "IS_EXTERNAL_PROPERTY");
        isExternal$delegate$2 = kotlin.reflect.jvm.internal.impl.km.internal.FlagDelegatesImplKt.propertyBooleanFlag(new kotlin.reflect.jvm.internal.impl.km.internal.FlagImpl(IS_EXTERNAL_PROPERTY));
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.BooleanFlagField IS_DELEGATED = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_DELEGATED;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(IS_DELEGATED, "IS_DELEGATED");
        isDelegated$delegate = kotlin.reflect.jvm.internal.impl.km.internal.FlagDelegatesImplKt.propertyBooleanFlag(new kotlin.reflect.jvm.internal.impl.km.internal.FlagImpl(IS_DELEGATED));
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.BooleanFlagField IS_EXPECT_PROPERTY = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_EXPECT_PROPERTY;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(IS_EXPECT_PROPERTY, "IS_EXPECT_PROPERTY");
        isExpect$delegate$2 = kotlin.reflect.jvm.internal.impl.km.internal.FlagDelegatesImplKt.propertyBooleanFlag(new kotlin.reflect.jvm.internal.impl.km.internal.FlagImpl(IS_EXPECT_PROPERTY));
        visibility$delegate$4 = kotlin.reflect.jvm.internal.impl.km.internal.FlagDelegatesImplKt.visibilityDelegate(new kotlin.jvm.internal.MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.Attributes$visibility$18
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public java.lang.Object get(java.lang.Object obj) {
                return java.lang.Integer.valueOf(((kotlin.reflect.jvm.internal.impl.km.KmPropertyAccessorAttributes) obj).getFlags$kotlin_metadata());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(java.lang.Object obj, java.lang.Object obj2) {
                ((kotlin.reflect.jvm.internal.impl.km.KmPropertyAccessorAttributes) obj).setFlags$kotlin_metadata(((java.lang.Number) obj2).intValue());
            }
        });
        modality$delegate$3 = kotlin.reflect.jvm.internal.impl.km.internal.FlagDelegatesImplKt.modalityDelegate(new kotlin.jvm.internal.MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.Attributes$modality$14
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public java.lang.Object get(java.lang.Object obj) {
                return java.lang.Integer.valueOf(((kotlin.reflect.jvm.internal.impl.km.KmPropertyAccessorAttributes) obj).getFlags$kotlin_metadata());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(java.lang.Object obj, java.lang.Object obj2) {
                ((kotlin.reflect.jvm.internal.impl.km.KmPropertyAccessorAttributes) obj).setFlags$kotlin_metadata(((java.lang.Number) obj2).intValue());
            }
        });
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.BooleanFlagField IS_NOT_DEFAULT = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_NOT_DEFAULT;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(IS_NOT_DEFAULT, "IS_NOT_DEFAULT");
        isNotDefault$delegate = kotlin.reflect.jvm.internal.impl.km.internal.FlagDelegatesImplKt.propertyAccessorBooleanFlag(new kotlin.reflect.jvm.internal.impl.km.internal.FlagImpl(IS_NOT_DEFAULT));
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.BooleanFlagField IS_EXTERNAL_ACCESSOR = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_EXTERNAL_ACCESSOR;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(IS_EXTERNAL_ACCESSOR, "IS_EXTERNAL_ACCESSOR");
        isExternal$delegate$3 = kotlin.reflect.jvm.internal.impl.km.internal.FlagDelegatesImplKt.propertyAccessorBooleanFlag(new kotlin.reflect.jvm.internal.impl.km.internal.FlagImpl(IS_EXTERNAL_ACCESSOR));
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.BooleanFlagField IS_INLINE_ACCESSOR = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_INLINE_ACCESSOR;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(IS_INLINE_ACCESSOR, "IS_INLINE_ACCESSOR");
        isInline$delegate$1 = kotlin.reflect.jvm.internal.impl.km.internal.FlagDelegatesImplKt.propertyAccessorBooleanFlag(new kotlin.reflect.jvm.internal.impl.km.internal.FlagImpl(IS_INLINE_ACCESSOR));
        isNullable$delegate = kotlin.reflect.jvm.internal.impl.km.internal.FlagDelegatesImplKt.typeBooleanFlag(new kotlin.reflect.jvm.internal.impl.km.internal.FlagImpl(0, 1, 1));
        isSuspend$delegate$1 = kotlin.reflect.jvm.internal.impl.km.internal.FlagDelegatesImplKt.typeBooleanFlag(new kotlin.reflect.jvm.internal.impl.km.internal.FlagImpl(kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.SUSPEND_TYPE.offset + 1, kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.SUSPEND_TYPE.bitWidth, 1));
        isDefinitelyNonNull$delegate = kotlin.reflect.jvm.internal.impl.km.internal.FlagDelegatesImplKt.typeBooleanFlag(new kotlin.reflect.jvm.internal.impl.km.internal.FlagImpl(kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.DEFINITELY_NOT_NULL_TYPE.offset + 1, kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.DEFINITELY_NOT_NULL_TYPE.bitWidth, 1));
        isReified$delegate = new kotlin.reflect.jvm.internal.impl.km.internal.BooleanFlagDelegate(new kotlin.jvm.internal.MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.Attributes.isReified.2
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public java.lang.Object get(java.lang.Object obj) {
                return java.lang.Integer.valueOf(((kotlin.reflect.jvm.internal.impl.km.KmTypeParameter) obj).getFlags$kotlin_metadata());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(java.lang.Object obj, java.lang.Object obj2) {
                ((kotlin.reflect.jvm.internal.impl.km.KmTypeParameter) obj).setFlags$kotlin_metadata(((java.lang.Number) obj2).intValue());
            }
        }, new kotlin.reflect.jvm.internal.impl.km.internal.FlagImpl(0, 1, 1));
        visibility$delegate$5 = kotlin.reflect.jvm.internal.impl.km.internal.FlagDelegatesImplKt.visibilityDelegate(new kotlin.jvm.internal.MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.Attributes$visibility$22
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public java.lang.Object get(java.lang.Object obj) {
                return java.lang.Integer.valueOf(((kotlin.reflect.jvm.internal.impl.km.KmTypeAlias) obj).getFlags$kotlin_metadata());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(java.lang.Object obj, java.lang.Object obj2) {
                ((kotlin.reflect.jvm.internal.impl.km.KmTypeAlias) obj).setFlags$kotlin_metadata(((java.lang.Number) obj2).intValue());
            }
        });
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.BooleanFlagField DECLARES_DEFAULT_VALUE = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.DECLARES_DEFAULT_VALUE;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(DECLARES_DEFAULT_VALUE, "DECLARES_DEFAULT_VALUE");
        declaresDefaultValue$delegate = kotlin.reflect.jvm.internal.impl.km.internal.FlagDelegatesImplKt.valueParameterBooleanFlag(new kotlin.reflect.jvm.internal.impl.km.internal.FlagImpl(DECLARES_DEFAULT_VALUE));
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.BooleanFlagField IS_CROSSINLINE = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_CROSSINLINE;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(IS_CROSSINLINE, "IS_CROSSINLINE");
        isCrossinline$delegate = kotlin.reflect.jvm.internal.impl.km.internal.FlagDelegatesImplKt.valueParameterBooleanFlag(new kotlin.reflect.jvm.internal.impl.km.internal.FlagImpl(IS_CROSSINLINE));
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.BooleanFlagField IS_NOINLINE = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_NOINLINE;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(IS_NOINLINE, "IS_NOINLINE");
        isNoinline$delegate = kotlin.reflect.jvm.internal.impl.km.internal.FlagDelegatesImplKt.valueParameterBooleanFlag(new kotlin.reflect.jvm.internal.impl.km.internal.FlagImpl(IS_NOINLINE));
        kotlin.reflect.jvm.internal.impl.km.Attributes$isNegated$2 attributes$isNegated$2 = new kotlin.jvm.internal.MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.Attributes$isNegated$2
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public java.lang.Object get(java.lang.Object obj) {
                return java.lang.Integer.valueOf(((kotlin.reflect.jvm.internal.impl.km.KmEffectExpression) obj).getFlags$kotlin_metadata());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(java.lang.Object obj, java.lang.Object obj2) {
                ((kotlin.reflect.jvm.internal.impl.km.KmEffectExpression) obj).setFlags$kotlin_metadata(((java.lang.Number) obj2).intValue());
            }
        };
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.BooleanFlagField IS_NEGATED = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_NEGATED;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(IS_NEGATED, "IS_NEGATED");
        isNegated$delegate = new kotlin.reflect.jvm.internal.impl.km.internal.BooleanFlagDelegate(attributes$isNegated$2, new kotlin.reflect.jvm.internal.impl.km.internal.FlagImpl(IS_NEGATED));
        kotlin.reflect.jvm.internal.impl.km.Attributes$isNullCheckPredicate$2 attributes$isNullCheckPredicate$2 = new kotlin.jvm.internal.MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.Attributes$isNullCheckPredicate$2
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public java.lang.Object get(java.lang.Object obj) {
                return java.lang.Integer.valueOf(((kotlin.reflect.jvm.internal.impl.km.KmEffectExpression) obj).getFlags$kotlin_metadata());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(java.lang.Object obj, java.lang.Object obj2) {
                ((kotlin.reflect.jvm.internal.impl.km.KmEffectExpression) obj).setFlags$kotlin_metadata(((java.lang.Number) obj2).intValue());
            }
        };
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.BooleanFlagField IS_NULL_CHECK_PREDICATE = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_NULL_CHECK_PREDICATE;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(IS_NULL_CHECK_PREDICATE, "IS_NULL_CHECK_PREDICATE");
        isNullCheckPredicate$delegate = new kotlin.reflect.jvm.internal.impl.km.internal.BooleanFlagDelegate(attributes$isNullCheckPredicate$2, new kotlin.reflect.jvm.internal.impl.km.internal.FlagImpl(IS_NULL_CHECK_PREDICATE));
    }
}
