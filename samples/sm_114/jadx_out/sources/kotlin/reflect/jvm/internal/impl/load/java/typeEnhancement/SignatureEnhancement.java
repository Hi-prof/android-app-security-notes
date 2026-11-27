package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

/* JADX INFO: compiled from: signatureEnhancement.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SignatureEnhancement {
    private final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement typeEnhancement;

    public SignatureEnhancement(kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement typeEnhancement) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeEnhancement, "typeEnhancement");
        this.typeEnhancement = typeEnhancement;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <D extends kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor> java.util.Collection<D> enhanceSignatures(kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext c, java.util.Collection<? extends D> platformSignatures) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(c, "c");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(platformSignatures, "platformSignatures");
        java.util.Collection<? extends D> collection = platformSignatures;
        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(collection, 10));
        java.util.Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(enhanceSignature((kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) it.next(), c));
        }
        return arrayList;
    }

    private final <D extends kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor> kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations getDefaultAnnotations(D d, kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext lazyJavaResolverContext) {
        kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor topLevelContainingClassifier = kotlin.reflect.jvm.internal.impl.descriptors.DescriptorUtilKt.getTopLevelContainingClassifier(d);
        if (topLevelContainingClassifier == null) {
            return d.getAnnotations();
        }
        kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor lazyJavaClassDescriptor = topLevelContainingClassifier instanceof kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor ? (kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor) topLevelContainingClassifier : null;
        java.util.List<kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation> moduleAnnotations = lazyJavaClassDescriptor != null ? lazyJavaClassDescriptor.getModuleAnnotations() : null;
        java.util.List<kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation> list = moduleAnnotations;
        if (list == null || list.isEmpty()) {
            return d.getAnnotations();
        }
        java.util.List<kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation> list2 = moduleAnnotations;
        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(list2, 10));
        java.util.Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(new kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaAnnotationDescriptor(lazyJavaResolverContext, (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation) it.next(), true));
        }
        return kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion.create(kotlin.collections.CollectionsKt.plus((java.lang.Iterable) d.getAnnotations(), (java.lang.Iterable) arrayList));
    }

    /* JADX WARN: Code duplicated, block: B:111:0x01f8  */
    /* JADX WARN: Code duplicated, block: B:54:0x00d7  */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x023c, code lost:
    
        if (r1 == null) goto L131;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final <D extends kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor> D enhanceSignature(D r19, kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r20) {
        /*
            Method dump skipped, instruction units count: 681
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement.enhanceSignature(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext):kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.types.KotlinType enhanceSignature$lambda$2(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor it) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(it, "it");
        kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor extensionReceiverParameter = it.getExtensionReceiverParameter();
        kotlin.jvm.internal.Intrinsics.checkNotNull(extensionReceiverParameter);
        kotlin.reflect.jvm.internal.impl.types.KotlinType type = extensionReceiverParameter.getType();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
        return type;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.types.KotlinType enhanceSignature$lambda$9$lambda$8(kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor valueParameterDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor it) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(it, "it");
        kotlin.reflect.jvm.internal.impl.types.KotlinType type = it.getValueParameters().get(valueParameterDescriptor.getIndex()).getType();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
        return type;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.types.KotlinType enhanceSignature$lambda$10(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor it) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(it, "it");
        kotlin.reflect.jvm.internal.impl.types.KotlinType returnType = it.getReturnType();
        kotlin.jvm.internal.Intrinsics.checkNotNull(returnType);
        return returnType;
    }

    public final java.util.List<kotlin.reflect.jvm.internal.impl.types.KotlinType> enhanceTypeParameterBounds(kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor typeParameter, java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.KotlinType> bounds, kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext context) {
        kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType;
        kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinTypeEnhance$default;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeParameter, "typeParameter");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(bounds, "bounds");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
        java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.KotlinType> list = bounds;
        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(list, 10));
        for (kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType2 : list) {
            if (kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.contains(kotlinType2, new kotlin.jvm.functions.Function1() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$$Lambda$3
                @Override // kotlin.jvm.functions.Function1
                /* JADX INFO: renamed from: invoke */
                public java.lang.Object invoke2(java.lang.Object obj) {
                    return java.lang.Boolean.valueOf(kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement.enhanceTypeParameterBounds$lambda$15$lambda$14((kotlin.reflect.jvm.internal.impl.types.UnwrappedType) obj));
                }
            })) {
                kotlinType = kotlinType2;
            } else {
                kotlinType = kotlinType2;
                kotlinTypeEnhance$default = enhance$default(this, new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureParts(typeParameter, false, context, kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS, false, 16, null), kotlinType, kotlin.collections.CollectionsKt.emptyList(), null, false, 12, null);
                if (kotlinTypeEnhance$default == null) {
                }
                arrayList.add(kotlinTypeEnhance$default);
            }
            kotlinTypeEnhance$default = kotlinType;
            arrayList.add(kotlinTypeEnhance$default);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean enhanceTypeParameterBounds$lambda$15$lambda$14(kotlin.reflect.jvm.internal.impl.types.UnwrappedType it) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(it, "it");
        return it instanceof kotlin.reflect.jvm.internal.impl.types.RawType;
    }

    public final kotlin.reflect.jvm.internal.impl.types.KotlinType enhanceSuperType(kotlin.reflect.jvm.internal.impl.types.KotlinType type, kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext context) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(type, "type");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
        kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinTypeEnhance$default = enhance$default(this, new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureParts(null, false, context, kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType.TYPE_USE, true), type, kotlin.collections.CollectionsKt.emptyList(), null, false, 12, null);
        return kotlinTypeEnhance$default == null ? type : kotlinTypeEnhance$default;
    }

    private final boolean containsFunctionN(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        return kotlin.reflect.jvm.internal.impl.types.TypeUtils.contains(kotlinType, new kotlin.jvm.functions.Function1() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$$Lambda$4
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement.containsFunctionN$lambda$16((kotlin.reflect.jvm.internal.impl.types.UnwrappedType) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.lang.Boolean containsFunctionN$lambda$16(kotlin.reflect.jvm.internal.impl.types.UnwrappedType unwrappedType) {
        kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptorMo1835getDeclarationDescriptor = unwrappedType.getConstructor().mo1835getDeclarationDescriptor();
        boolean z = false;
        if (classifierDescriptorMo1835getDeclarationDescriptor == null) {
            return false;
        }
        if (kotlin.jvm.internal.Intrinsics.areEqual(classifierDescriptorMo1835getDeclarationDescriptor.getName(), kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap.INSTANCE.getFUNCTION_N_FQ_NAME().shortName()) && kotlin.jvm.internal.Intrinsics.areEqual(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.fqNameOrNull(classifierDescriptorMo1835getDeclarationDescriptor), kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap.INSTANCE.getFUNCTION_N_FQ_NAME())) {
            z = true;
        }
        return java.lang.Boolean.valueOf(z);
    }

    private final kotlin.reflect.jvm.internal.impl.types.KotlinType enhanceValueParameter(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor callableMemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor valueParameterDescriptor, kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext lazyJavaResolverContext, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementInfo typeEnhancementInfo, boolean z, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, ? extends kotlin.reflect.jvm.internal.impl.types.KotlinType> function1) {
        kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext lazyJavaResolverContextCopyWithNewDefaultTypeQualifiers;
        return enhance(callableMemberDescriptor, valueParameterDescriptor, false, (valueParameterDescriptor == null || (lazyJavaResolverContextCopyWithNewDefaultTypeQualifiers = kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt.copyWithNewDefaultTypeQualifiers(lazyJavaResolverContext, valueParameterDescriptor.getAnnotations())) == null) ? lazyJavaResolverContext : lazyJavaResolverContextCopyWithNewDefaultTypeQualifiers, kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType.VALUE_PARAMETER, typeEnhancementInfo, z, function1);
    }

    static /* synthetic */ kotlin.reflect.jvm.internal.impl.types.KotlinType enhance$default(kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement signatureEnhancement, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor callableMemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated annotated, boolean z, kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext lazyJavaResolverContext, kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementInfo typeEnhancementInfo, boolean z2, kotlin.jvm.functions.Function1 function1, int i, java.lang.Object obj) {
        return signatureEnhancement.enhance(callableMemberDescriptor, annotated, z, lazyJavaResolverContext, annotationQualifierApplicabilityType, typeEnhancementInfo, (i & 32) != 0 ? false : z2, function1);
    }

    private final kotlin.reflect.jvm.internal.impl.types.KotlinType enhance(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor callableMemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated annotated, boolean z, kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext lazyJavaResolverContext, kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementInfo typeEnhancementInfo, boolean z2, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, ? extends kotlin.reflect.jvm.internal.impl.types.KotlinType> function1) {
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureParts signatureParts = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureParts(annotated, z, lazyJavaResolverContext, annotationQualifierApplicabilityType, false, 16, null);
        kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinTypeInvoke2 = function1.invoke2(callableMemberDescriptor);
        java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor> overriddenDescriptors = callableMemberDescriptor.getOverriddenDescriptors();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(overriddenDescriptors, "getOverriddenDescriptors(...)");
        java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor> collection = overriddenDescriptors;
        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(collection, 10));
        for (kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor callableMemberDescriptor2 : collection) {
            kotlin.jvm.internal.Intrinsics.checkNotNull(callableMemberDescriptor2);
            arrayList.add(function1.invoke2(callableMemberDescriptor2));
        }
        return enhance(signatureParts, kotlinTypeInvoke2, arrayList, typeEnhancementInfo, z2);
    }

    static /* synthetic */ kotlin.reflect.jvm.internal.impl.types.KotlinType enhance$default(kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement signatureEnhancement, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureParts signatureParts, kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType, java.util.List list, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementInfo typeEnhancementInfo, boolean z, int i, java.lang.Object obj) {
        if ((i & 4) != 0) {
            typeEnhancementInfo = null;
        }
        return signatureEnhancement.enhance(signatureParts, kotlinType, list, typeEnhancementInfo, (i & 8) != 0 ? false : z);
    }

    private final kotlin.reflect.jvm.internal.impl.types.KotlinType enhance(kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureParts signatureParts, kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType, java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.KotlinType> list, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementInfo typeEnhancementInfo, boolean z) {
        return this.typeEnhancement.enhance(kotlinType, signatureParts.computeIndexedQualifiers(kotlinType, list, typeEnhancementInfo, z), signatureParts.getSkipRawTypeArguments());
    }
}
