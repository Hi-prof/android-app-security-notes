package kotlin.reflect.jvm.internal.impl.descriptors;

/* JADX INFO: compiled from: typeParameterUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TypeParameterUtilsKt {
    public static final java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> computeConstructorTypeParameters(kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters) {
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> listEmptyList;
        kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor next;
        kotlin.reflect.jvm.internal.impl.types.TypeConstructor typeConstructor;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(classifierDescriptorWithTypeParameters, "<this>");
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> declaredTypeParameters = classifierDescriptorWithTypeParameters.getDeclaredTypeParameters();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(declaredTypeParameters, "getDeclaredTypeParameters(...)");
        if (!classifierDescriptorWithTypeParameters.isInner() && !(classifierDescriptorWithTypeParameters.getContainingDeclaration() instanceof kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor)) {
            return declaredTypeParameters;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters2 = classifierDescriptorWithTypeParameters;
        java.util.List list = kotlin.sequences.SequencesKt.toList(kotlin.sequences.SequencesKt.flatMap(kotlin.sequences.SequencesKt.filter(kotlin.sequences.SequencesKt.takeWhile(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getParents(classifierDescriptorWithTypeParameters2), new kotlin.jvm.functions.Function1() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt$$Lambda$0
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return java.lang.Boolean.valueOf(kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt.computeConstructorTypeParameters$lambda$0((kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor) obj));
            }
        }), new kotlin.jvm.functions.Function1() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt$$Lambda$1
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return java.lang.Boolean.valueOf(kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt.computeConstructorTypeParameters$lambda$1((kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor) obj));
            }
        }), new kotlin.jvm.functions.Function1() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt$$Lambda$2
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt.computeConstructorTypeParameters$lambda$2((kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor) obj);
            }
        }));
        java.util.Iterator<kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor> it = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getParents(classifierDescriptorWithTypeParameters2).iterator();
        do {
            listEmptyList = null;
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!(next instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor));
        kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) next;
        if (classDescriptor != null && (typeConstructor = classDescriptor.getTypeConstructor()) != null) {
            listEmptyList = typeConstructor.getParameters();
        }
        if (listEmptyList == null) {
            listEmptyList = kotlin.collections.CollectionsKt.emptyList();
        }
        if (list.isEmpty() && listEmptyList.isEmpty()) {
            java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> declaredTypeParameters2 = classifierDescriptorWithTypeParameters.getDeclaredTypeParameters();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(declaredTypeParameters2, "getDeclaredTypeParameters(...)");
            return declaredTypeParameters2;
        }
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> listPlus = kotlin.collections.CollectionsKt.plus((java.util.Collection) list, (java.lang.Iterable) listEmptyList);
        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(listPlus, 10));
        for (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor typeParameterDescriptor : listPlus) {
            kotlin.jvm.internal.Intrinsics.checkNotNull(typeParameterDescriptor);
            arrayList.add(capturedCopyForInnerDeclaration(typeParameterDescriptor, classifierDescriptorWithTypeParameters2, declaredTypeParameters.size()));
        }
        return kotlin.collections.CollectionsKt.plus((java.util.Collection) declaredTypeParameters, (java.lang.Iterable) arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean computeConstructorTypeParameters$lambda$0(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor it) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(it, "it");
        return it instanceof kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean computeConstructorTypeParameters$lambda$1(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor it) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(it, "it");
        return !(it instanceof kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.sequences.Sequence computeConstructorTypeParameters$lambda$2(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor it) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(it, "it");
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> typeParameters = ((kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor) it).getTypeParameters();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(typeParameters, "getTypeParameters(...)");
        return kotlin.collections.CollectionsKt.asSequence(typeParameters);
    }

    private static final kotlin.reflect.jvm.internal.impl.descriptors.CapturedTypeParameterDescriptor capturedCopyForInnerDeclaration(kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor typeParameterDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor, int i) {
        return new kotlin.reflect.jvm.internal.impl.descriptors.CapturedTypeParameterDescriptor(typeParameterDescriptor, declarationDescriptor, i);
    }

    public static final kotlin.reflect.jvm.internal.impl.descriptors.PossiblyInnerType buildPossiblyInnerType(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptorMo1835getDeclarationDescriptor = kotlinType.getConstructor().mo1835getDeclarationDescriptor();
        return buildPossiblyInnerType(kotlinType, classifierDescriptorMo1835getDeclarationDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters ? (kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters) classifierDescriptorMo1835getDeclarationDescriptor : null, 0);
    }

    private static final kotlin.reflect.jvm.internal.impl.descriptors.PossiblyInnerType buildPossiblyInnerType(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType, kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters, int i) {
        if (classifierDescriptorWithTypeParameters != null) {
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters2 = classifierDescriptorWithTypeParameters;
            if (!kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils.isError(classifierDescriptorWithTypeParameters2)) {
                int size = classifierDescriptorWithTypeParameters.getDeclaredTypeParameters().size() + i;
                if (!classifierDescriptorWithTypeParameters.isInner()) {
                    if (size != kotlinType.getArguments().size()) {
                        kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.isLocal(classifierDescriptorWithTypeParameters2);
                    }
                    return new kotlin.reflect.jvm.internal.impl.descriptors.PossiblyInnerType(classifierDescriptorWithTypeParameters, kotlinType.getArguments().subList(i, kotlinType.getArguments().size()), null);
                }
                java.util.List<kotlin.reflect.jvm.internal.impl.types.TypeProjection> listSubList = kotlinType.getArguments().subList(i, size);
                kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor containingDeclaration = classifierDescriptorWithTypeParameters.getContainingDeclaration();
                return new kotlin.reflect.jvm.internal.impl.descriptors.PossiblyInnerType(classifierDescriptorWithTypeParameters, listSubList, buildPossiblyInnerType(kotlinType, containingDeclaration instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters ? (kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters) containingDeclaration : null, size));
            }
        }
        return null;
    }
}
