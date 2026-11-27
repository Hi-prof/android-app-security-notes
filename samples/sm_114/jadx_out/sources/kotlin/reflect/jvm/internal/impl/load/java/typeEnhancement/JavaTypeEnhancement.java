package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

/* JADX INFO: compiled from: typeEnhancement.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class JavaTypeEnhancement {
    private final kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverSettings javaResolverSettings;

    /* JADX INFO: compiled from: typeEnhancement.kt */
    private static final class Result {
        private final int subtreeSize;
        private final kotlin.reflect.jvm.internal.impl.types.KotlinType type;

        public Result(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType, int i) {
            this.type = kotlinType;
            this.subtreeSize = i;
        }

        public final int getSubtreeSize() {
            return this.subtreeSize;
        }

        public final kotlin.reflect.jvm.internal.impl.types.KotlinType getType() {
            return this.type;
        }
    }

    public JavaTypeEnhancement(kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverSettings javaResolverSettings) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(javaResolverSettings, "javaResolverSettings");
        this.javaResolverSettings = javaResolverSettings;
    }

    /* JADX INFO: compiled from: typeEnhancement.kt */
    private static final class SimpleResult {
        private final boolean forWarnings;
        private final int subtreeSize;
        private final kotlin.reflect.jvm.internal.impl.types.SimpleType type;

        public SimpleResult(kotlin.reflect.jvm.internal.impl.types.SimpleType simpleType, int i, boolean z) {
            this.type = simpleType;
            this.subtreeSize = i;
            this.forWarnings = z;
        }

        public final boolean getForWarnings() {
            return this.forWarnings;
        }

        public final int getSubtreeSize() {
            return this.subtreeSize;
        }

        public final kotlin.reflect.jvm.internal.impl.types.SimpleType getType() {
            return this.type;
        }
    }

    public final kotlin.reflect.jvm.internal.impl.types.KotlinType enhance(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType, kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers> qualifiers, boolean z) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(qualifiers, "qualifiers");
        return enhancePossiblyFlexible(kotlinType.unwrap(), qualifiers, 0, z).getType();
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00a3  */
    private final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement.Result enhancePossiblyFlexible(kotlin.reflect.jvm.internal.impl.types.UnwrappedType unwrappedType, kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers> function1, int i, boolean z) {
        kotlin.reflect.jvm.internal.impl.types.SimpleType simpleTypeFlexibleType;
        kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl rawTypeImplWrapEnhancement = null;
        if (kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt.isError(unwrappedType)) {
            return new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement.Result(null, 1);
        }
        if (unwrappedType instanceof kotlin.reflect.jvm.internal.impl.types.FlexibleType) {
            boolean z2 = unwrappedType instanceof kotlin.reflect.jvm.internal.impl.types.RawType;
            kotlin.reflect.jvm.internal.impl.types.FlexibleType flexibleType = (kotlin.reflect.jvm.internal.impl.types.FlexibleType) unwrappedType;
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement.SimpleResult simpleResultEnhanceInflexible = enhanceInflexible(flexibleType.getLowerBound(), function1, i, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition.FLEXIBLE_LOWER, z2, z);
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement.SimpleResult simpleResultEnhanceInflexible2 = enhanceInflexible(flexibleType.getUpperBound(), function1, i, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition.FLEXIBLE_UPPER, z2, z);
            simpleResultEnhanceInflexible.getSubtreeSize();
            simpleResultEnhanceInflexible2.getSubtreeSize();
            if (simpleResultEnhanceInflexible.getType() != null || simpleResultEnhanceInflexible2.getType() != null) {
                if (simpleResultEnhanceInflexible.getForWarnings() || simpleResultEnhanceInflexible2.getForWarnings()) {
                    kotlin.reflect.jvm.internal.impl.types.SimpleType type = simpleResultEnhanceInflexible2.getType();
                    if (type == null) {
                        kotlin.reflect.jvm.internal.impl.types.SimpleType type2 = simpleResultEnhanceInflexible.getType();
                        kotlin.jvm.internal.Intrinsics.checkNotNull(type2);
                        simpleTypeFlexibleType = type2;
                    } else {
                        kotlin.reflect.jvm.internal.impl.types.SimpleType type3 = simpleResultEnhanceInflexible.getType();
                        if (type3 == null) {
                            type3 = type;
                        }
                        simpleTypeFlexibleType = kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.flexibleType(type3, type);
                        if (simpleTypeFlexibleType == null) {
                            kotlin.reflect.jvm.internal.impl.types.SimpleType type4 = simpleResultEnhanceInflexible.getType();
                            kotlin.jvm.internal.Intrinsics.checkNotNull(type4);
                            simpleTypeFlexibleType = type4;
                        }
                    }
                    rawTypeImplWrapEnhancement = kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt.wrapEnhancement(unwrappedType, simpleTypeFlexibleType);
                } else if (z2) {
                    kotlin.reflect.jvm.internal.impl.types.SimpleType type5 = simpleResultEnhanceInflexible.getType();
                    if (type5 == null) {
                        type5 = flexibleType.getLowerBound();
                    }
                    kotlin.reflect.jvm.internal.impl.types.SimpleType type6 = simpleResultEnhanceInflexible2.getType();
                    if (type6 == null) {
                        type6 = flexibleType.getUpperBound();
                    }
                    rawTypeImplWrapEnhancement = new kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl(type5, type6);
                } else {
                    kotlin.reflect.jvm.internal.impl.types.SimpleType type7 = simpleResultEnhanceInflexible.getType();
                    if (type7 == null) {
                        type7 = flexibleType.getLowerBound();
                    }
                    kotlin.reflect.jvm.internal.impl.types.SimpleType type8 = simpleResultEnhanceInflexible2.getType();
                    if (type8 == null) {
                        type8 = flexibleType.getUpperBound();
                    }
                    rawTypeImplWrapEnhancement = kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.flexibleType(type7, type8);
                }
            }
            return new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement.Result(rawTypeImplWrapEnhancement, simpleResultEnhanceInflexible.getSubtreeSize());
        }
        if (!(unwrappedType instanceof kotlin.reflect.jvm.internal.impl.types.SimpleType)) {
            throw new kotlin.NoWhenBranchMatchedException();
        }
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement.SimpleResult simpleResultEnhanceInflexible$default = enhanceInflexible$default(this, (kotlin.reflect.jvm.internal.impl.types.SimpleType) unwrappedType, function1, i, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition.INFLEXIBLE, false, z, 8, null);
        return new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement.Result(simpleResultEnhanceInflexible$default.getForWarnings() ? kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt.wrapEnhancement(unwrappedType, simpleResultEnhanceInflexible$default.getType()) : simpleResultEnhanceInflexible$default.getType(), simpleResultEnhanceInflexible$default.getSubtreeSize());
    }

    static /* synthetic */ kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement.SimpleResult enhanceInflexible$default(kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement javaTypeEnhancement, kotlin.reflect.jvm.internal.impl.types.SimpleType simpleType, kotlin.jvm.functions.Function1 function1, int i, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition typeComponentPosition, boolean z, boolean z2, int i2, java.lang.Object obj) {
        if ((i2 & 8) != 0) {
            z = false;
        }
        if ((i2 & 16) != 0) {
            z2 = false;
        }
        return javaTypeEnhancement.enhanceInflexible(simpleType, function1, i, typeComponentPosition, z, z2);
    }

    private final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement.SimpleResult enhanceInflexible(kotlin.reflect.jvm.internal.impl.types.SimpleType simpleType, kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers> function1, int i, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition typeComponentPosition, boolean z, boolean z2) {
        kotlin.reflect.jvm.internal.impl.types.TypeConstructor constructor;
        java.lang.Boolean bool;
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement.Result result;
        kotlin.reflect.jvm.internal.impl.types.TypeProjection typeProjectionMakeStarProjection;
        kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers> function2 = function1;
        boolean zShouldEnhance = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPositionKt.shouldEnhance(typeComponentPosition);
        boolean z3 = (z2 && z) ? false : true;
        kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType = null;
        if (!zShouldEnhance && simpleType.getArguments().isEmpty()) {
            return new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement.SimpleResult(null, 1, false);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptorMo1835getDeclarationDescriptor = simpleType.getConstructor().mo1835getDeclarationDescriptor();
        if (classifierDescriptorMo1835getDeclarationDescriptor == null) {
            return new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement.SimpleResult(null, 1, false);
        }
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers javaTypeQualifiersInvoke2 = function2.invoke2(java.lang.Integer.valueOf(i));
        kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptorEnhanceMutability = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementKt.enhanceMutability(classifierDescriptorMo1835getDeclarationDescriptor, javaTypeQualifiersInvoke2, typeComponentPosition);
        java.lang.Boolean enhancedNullability = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementKt.getEnhancedNullability(javaTypeQualifiersInvoke2, typeComponentPosition);
        if (classifierDescriptorEnhanceMutability == null || (constructor = classifierDescriptorEnhanceMutability.getTypeConstructor()) == null) {
            constructor = simpleType.getConstructor();
        }
        kotlin.reflect.jvm.internal.impl.types.TypeConstructor typeConstructor = constructor;
        int subtreeSize = i + 1;
        java.util.List<kotlin.reflect.jvm.internal.impl.types.TypeProjection> arguments = simpleType.getArguments();
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> parameters = typeConstructor.getParameters();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(parameters, "getParameters(...)");
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> list = parameters;
        java.util.Iterator<T> it = arguments.iterator();
        java.util.Iterator<T> it2 = list.iterator();
        java.util.ArrayList arrayList = new java.util.ArrayList(java.lang.Math.min(kotlin.collections.CollectionsKt.collectionSizeOrDefault(arguments, 10), kotlin.collections.CollectionsKt.collectionSizeOrDefault(list, 10)));
        while (it.hasNext() && it2.hasNext()) {
            java.lang.Object next = it.next();
            kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor typeParameterDescriptor = (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) it2.next();
            kotlin.reflect.jvm.internal.impl.types.TypeProjection typeProjection = (kotlin.reflect.jvm.internal.impl.types.TypeProjection) next;
            if (!z3) {
                bool = enhancedNullability;
                result = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement.Result(kotlinType, 0);
            } else {
                bool = enhancedNullability;
                if (!typeProjection.isStarProjection()) {
                    result = enhancePossiblyFlexible(typeProjection.getType().unwrap(), function2, subtreeSize, z2);
                } else if (function2.invoke2(java.lang.Integer.valueOf(subtreeSize)).getNullability() == kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.FORCE_FLEXIBILITY) {
                    kotlin.reflect.jvm.internal.impl.types.UnwrappedType unwrappedTypeUnwrap = typeProjection.getType().unwrap();
                    result = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement.Result(kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.flexibleType(kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt.lowerIfFlexible(unwrappedTypeUnwrap).makeNullableAsSpecified(false), kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt.upperIfFlexible(unwrappedTypeUnwrap).makeNullableAsSpecified(true)), 1);
                } else {
                    result = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement.Result(null, 1);
                }
            }
            subtreeSize += result.getSubtreeSize();
            if (result.getType() != null) {
                kotlin.reflect.jvm.internal.impl.types.KotlinType type = result.getType();
                kotlin.reflect.jvm.internal.impl.types.Variance projectionKind = typeProjection.getProjectionKind();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(projectionKind, "getProjectionKind(...)");
                typeProjectionMakeStarProjection = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.createProjection(type, projectionKind, typeParameterDescriptor);
            } else if (classifierDescriptorEnhanceMutability == null || typeProjection.isStarProjection()) {
                typeProjectionMakeStarProjection = classifierDescriptorEnhanceMutability != null ? kotlin.reflect.jvm.internal.impl.types.TypeUtils.makeStarProjection(typeParameterDescriptor) : null;
            } else {
                kotlin.reflect.jvm.internal.impl.types.KotlinType type2 = typeProjection.getType();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(type2, "getType(...)");
                kotlin.reflect.jvm.internal.impl.types.Variance projectionKind2 = typeProjection.getProjectionKind();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(projectionKind2, "getProjectionKind(...)");
                typeProjectionMakeStarProjection = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.createProjection(type2, projectionKind2, typeParameterDescriptor);
            }
            arrayList.add(typeProjectionMakeStarProjection);
            function2 = function1;
            enhancedNullability = bool;
            kotlinType = null;
        }
        java.lang.Boolean bool2 = enhancedNullability;
        java.util.ArrayList arrayList2 = arrayList;
        int i2 = subtreeSize - i;
        if (classifierDescriptorEnhanceMutability == null && bool2 == null) {
            java.util.ArrayList arrayList3 = arrayList2;
            if (!(arrayList3 instanceof java.util.Collection) || !arrayList3.isEmpty()) {
                java.util.Iterator it3 = arrayList3.iterator();
                do {
                    if (it3.hasNext()) {
                    }
                } while (((kotlin.reflect.jvm.internal.impl.types.TypeProjection) it3.next()) == null);
            }
            return new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement.SimpleResult(null, i2, false);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations[] annotationsArr = new kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations[3];
        annotationsArr[0] = simpleType.getAnnotations();
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.EnhancedTypeAnnotations enhancedTypeAnnotations = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementKt.ENHANCED_MUTABILITY_ANNOTATIONS;
        if (classifierDescriptorEnhanceMutability == null) {
            enhancedTypeAnnotations = null;
        }
        annotationsArr[1] = enhancedTypeAnnotations;
        annotationsArr[2] = bool2 != null ? kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementKt.getENHANCED_NULLABILITY_ANNOTATIONS() : null;
        kotlin.reflect.jvm.internal.impl.types.TypeAttributes defaultAttributes = kotlin.reflect.jvm.internal.impl.types.TypeAttributesKt.toDefaultAttributes(kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementKt.compositeAnnotationsOrSingle(kotlin.collections.CollectionsKt.listOfNotNull((java.lang.Object[]) annotationsArr)));
        java.util.ArrayList arrayList4 = arrayList2;
        java.util.List<kotlin.reflect.jvm.internal.impl.types.TypeProjection> arguments2 = simpleType.getArguments();
        java.util.Iterator it4 = arrayList4.iterator();
        java.util.Iterator<T> it5 = arguments2.iterator();
        java.util.ArrayList arrayList5 = new java.util.ArrayList(java.lang.Math.min(kotlin.collections.CollectionsKt.collectionSizeOrDefault(arrayList4, 10), kotlin.collections.CollectionsKt.collectionSizeOrDefault(arguments2, 10)));
        while (it4.hasNext() && it5.hasNext()) {
            java.lang.Object next2 = it4.next();
            kotlin.reflect.jvm.internal.impl.types.TypeProjection typeProjection2 = (kotlin.reflect.jvm.internal.impl.types.TypeProjection) it5.next();
            kotlin.reflect.jvm.internal.impl.types.TypeProjection typeProjection3 = (kotlin.reflect.jvm.internal.impl.types.TypeProjection) next2;
            if (typeProjection3 != null) {
                typeProjection2 = typeProjection3;
            }
            arrayList5.add(typeProjection2);
        }
        kotlin.reflect.jvm.internal.impl.types.SimpleType simpleTypeSimpleType$default = kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.simpleType$default(defaultAttributes, typeConstructor, arrayList5, bool2 != null ? bool2.booleanValue() : simpleType.isMarkedNullable(), (kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner) null, 16, (java.lang.Object) null);
        if (javaTypeQualifiersInvoke2.getDefinitelyNotNull()) {
            simpleTypeSimpleType$default = notNullTypeParameter(simpleTypeSimpleType$default);
        }
        return new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement.SimpleResult(simpleTypeSimpleType$default, i2, bool2 != null && javaTypeQualifiersInvoke2.isNullabilityQualifierForWarning());
    }

    private final kotlin.reflect.jvm.internal.impl.types.SimpleType notNullTypeParameter(kotlin.reflect.jvm.internal.impl.types.SimpleType simpleType) {
        if (this.javaResolverSettings.getCorrectNullabilityForNotNullTypeParameter()) {
            return kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt.makeSimpleTypeDefinitelyNotNullOrNotNull(simpleType, true);
        }
        return new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NotNullTypeParameterImpl(simpleType);
    }
}
