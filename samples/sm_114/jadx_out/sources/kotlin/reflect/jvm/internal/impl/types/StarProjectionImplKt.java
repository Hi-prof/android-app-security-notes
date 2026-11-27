package kotlin.reflect.jvm.internal.impl.types;

/* JADX INFO: compiled from: StarProjectionImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StarProjectionImplKt {
    private static final kotlin.reflect.jvm.internal.impl.types.KotlinType buildStarProjectionTypeByTypeParameters(final java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.TypeConstructor> list, java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.KotlinType> list2, kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns kotlinBuiltIns) {
        kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinTypeSubstitute = kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor.create(new kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution() { // from class: kotlin.reflect.jvm.internal.impl.types.StarProjectionImplKt.buildStarProjectionTypeByTypeParameters.1
            @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution
            public kotlin.reflect.jvm.internal.impl.types.TypeProjection get(kotlin.reflect.jvm.internal.impl.types.TypeConstructor key) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(key, "key");
                if (!list.contains(key)) {
                    return null;
                }
                kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptorMo1835getDeclarationDescriptor = key.mo1835getDeclarationDescriptor();
                kotlin.jvm.internal.Intrinsics.checkNotNull(classifierDescriptorMo1835getDeclarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
                return kotlin.reflect.jvm.internal.impl.types.TypeUtils.makeStarProjection((kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) classifierDescriptorMo1835getDeclarationDescriptor);
            }
        }).substitute((kotlin.reflect.jvm.internal.impl.types.KotlinType) kotlin.collections.CollectionsKt.first((java.util.List) list2), kotlin.reflect.jvm.internal.impl.types.Variance.OUT_VARIANCE);
        if (kotlinTypeSubstitute != null) {
            return kotlinTypeSubstitute;
        }
        kotlin.reflect.jvm.internal.impl.types.SimpleType defaultBound = kotlinBuiltIns.getDefaultBound();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(defaultBound, "getDefaultBound(...)");
        return defaultBound;
    }

    public static final kotlin.reflect.jvm.internal.impl.types.KotlinType starProjectionType(kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor typeParameterDescriptor) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeParameterDescriptor, "<this>");
        kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor containingDeclaration = typeParameterDescriptor.getContainingDeclaration();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(containingDeclaration, "getContainingDeclaration(...)");
        if (containingDeclaration instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters) {
            java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> parameters = ((kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters) containingDeclaration).getTypeConstructor().getParameters();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(parameters, "getParameters(...)");
            java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> list = parameters;
            java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(list, 10));
            java.util.Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                kotlin.reflect.jvm.internal.impl.types.TypeConstructor typeConstructor = ((kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) it.next()).getTypeConstructor();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(typeConstructor, "getTypeConstructor(...)");
                arrayList.add(typeConstructor);
            }
            java.util.List<kotlin.reflect.jvm.internal.impl.types.KotlinType> upperBounds = typeParameterDescriptor.getUpperBounds();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(upperBounds, "getUpperBounds(...)");
            return buildStarProjectionTypeByTypeParameters(arrayList, upperBounds, kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getBuiltIns(typeParameterDescriptor));
        }
        if (containingDeclaration instanceof kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) {
            java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> typeParameters = ((kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) containingDeclaration).getTypeParameters();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(typeParameters, "getTypeParameters(...)");
            java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> list2 = typeParameters;
            java.util.ArrayList arrayList2 = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(list2, 10));
            java.util.Iterator<T> it2 = list2.iterator();
            while (it2.hasNext()) {
                kotlin.reflect.jvm.internal.impl.types.TypeConstructor typeConstructor2 = ((kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) it2.next()).getTypeConstructor();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(typeConstructor2, "getTypeConstructor(...)");
                arrayList2.add(typeConstructor2);
            }
            java.util.List<kotlin.reflect.jvm.internal.impl.types.KotlinType> upperBounds2 = typeParameterDescriptor.getUpperBounds();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(upperBounds2, "getUpperBounds(...)");
            return buildStarProjectionTypeByTypeParameters(arrayList2, upperBounds2, kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getBuiltIns(typeParameterDescriptor));
        }
        throw new java.lang.IllegalArgumentException("Unsupported descriptor type to build star projection type based on type parameters of it");
    }
}
