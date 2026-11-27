package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

/* JADX INFO: compiled from: AbstractSignatureParts.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractSignatureParts<TAnnotation> {
    public abstract boolean forceWarning(TAnnotation tannotation, kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker kotlinTypeMarker);

    public abstract kotlin.reflect.jvm.internal.impl.load.java.AbstractAnnotationTypeQualifierResolver<TAnnotation> getAnnotationTypeQualifierResolver();

    public abstract java.lang.Iterable<TAnnotation> getAnnotations(kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker kotlinTypeMarker);

    public abstract java.lang.Iterable<TAnnotation> getContainerAnnotations();

    public abstract kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType getContainerApplicabilityType();

    public abstract kotlin.reflect.jvm.internal.impl.load.java.JavaTypeQualifiersByElementType getContainerDefaultTypeQualifiers();

    public abstract boolean getContainerIsVarargParameter();

    protected abstract kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus getDefaultNullability(kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus, kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers javaDefaultQualifiers);

    public abstract boolean getEnableImprovementsInStrictMode();

    public abstract kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker getEnhancedForWarnings(kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker kotlinTypeMarker);

    public boolean getForceOnlyHeadTypeConstructor() {
        return false;
    }

    public abstract kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe getFqNameUnsafe(kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker kotlinTypeMarker);

    public abstract boolean getSkipRawTypeArguments();

    public abstract kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext getTypeSystem();

    public abstract boolean isArrayOrPrimitiveArray(kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker kotlinTypeMarker);

    public abstract boolean isCovariant();

    public abstract boolean isEqual(kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker kotlinTypeMarker, kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker kotlinTypeMarker2);

    public abstract boolean isFromJava(kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker typeParameterMarker);

    public boolean isNotNullTypeParameterCompat(kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker kotlinTypeMarker) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinTypeMarker, "<this>");
        return false;
    }

    private final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier getNullabilityQualifier(kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker kotlinTypeMarker) {
        kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext typeSystem = getTypeSystem();
        if (typeSystem.isMarkedNullable(typeSystem.lowerBoundIfFlexible(kotlinTypeMarker))) {
            return kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NULLABLE;
        }
        if (typeSystem.isMarkedNullable(typeSystem.upperBoundIfFlexible(kotlinTypeMarker))) {
            return null;
        }
        return kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NOT_NULL;
    }

    private final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers extractQualifiers(kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker kotlinTypeMarker) {
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier nullabilityQualifier;
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier nullabilityQualifier2 = getNullabilityQualifier(kotlinTypeMarker);
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier mutabilityQualifier = null;
        if (nullabilityQualifier2 == null) {
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker enhancedForWarnings = getEnhancedForWarnings(kotlinTypeMarker);
            nullabilityQualifier = enhancedForWarnings != null ? getNullabilityQualifier(enhancedForWarnings) : null;
        } else {
            nullabilityQualifier = nullabilityQualifier2;
        }
        kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext typeSystem = getTypeSystem();
        if (kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap.INSTANCE.isReadOnly(getFqNameUnsafe(typeSystem.lowerBoundIfFlexible(kotlinTypeMarker)))) {
            mutabilityQualifier = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier.READ_ONLY;
        } else if (kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap.INSTANCE.isMutable(getFqNameUnsafe(typeSystem.upperBoundIfFlexible(kotlinTypeMarker)))) {
            mutabilityQualifier = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier.MUTABLE;
        }
        return new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers(nullabilityQualifier, mutabilityQualifier, getTypeSystem().isDefinitelyNotNullType(kotlinTypeMarker) || isNotNullTypeParameterCompat(kotlinTypeMarker), nullabilityQualifier != nullabilityQualifier2);
    }

    private final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers extractQualifiersFromAnnotations(final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts.TypeAndDefaultQualifiers typeAndDefaultQualifiers) {
        java.util.List listEmptyList;
        kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType containerApplicabilityType;
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus boundsNullability;
        kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker type;
        kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker typeConstructorMarkerTypeConstructor;
        if (typeAndDefaultQualifiers.getType() == null) {
            kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext typeSystem = getTypeSystem();
            kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker typeParameterForArgument = typeAndDefaultQualifiers.getTypeParameterForArgument();
            if ((typeParameterForArgument != null ? typeSystem.getVariance(typeParameterForArgument) : null) == kotlin.reflect.jvm.internal.impl.types.model.TypeVariance.IN) {
                return kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers.Companion.getNONE();
            }
        }
        boolean z = false;
        boolean z2 = typeAndDefaultQualifiers.getTypeParameterForArgument() == null;
        kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker type2 = typeAndDefaultQualifiers.getType();
        if (type2 == null || (listEmptyList = getAnnotations(type2)) == null) {
            listEmptyList = kotlin.collections.CollectionsKt.emptyList();
        }
        kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext typeSystem2 = getTypeSystem();
        kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker type3 = typeAndDefaultQualifiers.getType();
        kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker typeParameterClassifier = (type3 == null || (typeConstructorMarkerTypeConstructor = typeSystem2.typeConstructor(type3)) == null) ? null : typeSystem2.getTypeParameterClassifier(typeConstructorMarkerTypeConstructor);
        boolean z3 = getContainerApplicabilityType() == kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS;
        if (z2) {
            if (!z3 && getEnableImprovementsInStrictMode() && (type = typeAndDefaultQualifiers.getType()) != null && isArrayOrPrimitiveArray(type)) {
                java.lang.Iterable<TAnnotation> containerAnnotations = getContainerAnnotations();
                java.util.ArrayList arrayList = new java.util.ArrayList();
                for (TAnnotation tannotation : containerAnnotations) {
                    if (!getAnnotationTypeQualifierResolver().isTypeUseAnnotation(tannotation)) {
                        arrayList.add(tannotation);
                    }
                }
                listEmptyList = kotlin.collections.CollectionsKt.plus((java.util.Collection) arrayList, (java.lang.Iterable) listEmptyList);
            } else {
                listEmptyList = kotlin.collections.CollectionsKt.plus((java.lang.Iterable) getContainerAnnotations(), (java.lang.Iterable) listEmptyList);
            }
        }
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier mutabilityQualifierExtractMutability = getAnnotationTypeQualifierResolver().extractMutability(listEmptyList);
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatusExtractNullability = getAnnotationTypeQualifierResolver().extractNullability((java.lang.Iterable) listEmptyList, (kotlin.jvm.functions.Function1) new kotlin.jvm.functions.Function1(this, typeAndDefaultQualifiers) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts$$Lambda$0
            private final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts arg$0;
            private final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts.TypeAndDefaultQualifiers arg$1;

            {
                this.arg$0 = this;
                this.arg$1 = typeAndDefaultQualifiers;
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return java.lang.Boolean.valueOf(kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts.extractQualifiersFromAnnotations$lambda$6(this.arg$0, this.arg$1, obj));
            }
        });
        if (nullabilityQualifierWithMigrationStatusExtractNullability != null) {
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier qualifier = nullabilityQualifierWithMigrationStatusExtractNullability.getQualifier();
            if (nullabilityQualifierWithMigrationStatusExtractNullability.getQualifier() == kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NOT_NULL && typeParameterClassifier != null) {
                z = true;
            }
            return new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers(qualifier, mutabilityQualifierExtractMutability, z, nullabilityQualifierWithMigrationStatusExtractNullability.isForWarningOnly());
        }
        if (z2 || z3) {
            containerApplicabilityType = getContainerApplicabilityType();
        } else {
            containerApplicabilityType = kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType.TYPE_USE;
        }
        kotlin.reflect.jvm.internal.impl.load.java.JavaTypeQualifiersByElementType defaultQualifiers = typeAndDefaultQualifiers.getDefaultQualifiers();
        kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers javaDefaultQualifiers = defaultQualifiers != null ? defaultQualifiers.get(containerApplicabilityType) : null;
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus boundsNullability2 = typeParameterClassifier != null ? getBoundsNullability(typeParameterClassifier) : null;
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus defaultNullability = getDefaultNullability(boundsNullability2, javaDefaultQualifiers);
        boolean z4 = (boundsNullability2 != null ? boundsNullability2.getQualifier() : null) == kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NOT_NULL || !(typeParameterClassifier == null || javaDefaultQualifiers == null || !javaDefaultQualifiers.getDefinitelyNotNull());
        kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker typeParameterForArgument2 = typeAndDefaultQualifiers.getTypeParameterForArgument();
        if (typeParameterForArgument2 == null || (boundsNullability = getBoundsNullability(typeParameterForArgument2)) == null) {
            boundsNullability = null;
        } else if (boundsNullability.getQualifier() == kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NULLABLE) {
            boundsNullability = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus.copy$default(boundsNullability, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.FORCE_FLEXIBILITY, false, 2, null);
        }
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatusMostSpecific = mostSpecific(boundsNullability, defaultNullability);
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier qualifier2 = nullabilityQualifierWithMigrationStatusMostSpecific != null ? nullabilityQualifierWithMigrationStatusMostSpecific.getQualifier() : null;
        if (nullabilityQualifierWithMigrationStatusMostSpecific != null && nullabilityQualifierWithMigrationStatusMostSpecific.isForWarningOnly()) {
            z = true;
        }
        return new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers(qualifier2, mutabilityQualifierExtractMutability, z4, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean extractQualifiersFromAnnotations$lambda$6(kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts abstractSignatureParts, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts.TypeAndDefaultQualifiers typeAndDefaultQualifiers, java.lang.Object extractNullability) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(extractNullability, "$this$extractNullability");
        return abstractSignatureParts.forceWarning(extractNullability, typeAndDefaultQualifiers.getType());
    }

    private final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus mostSpecific(kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus2) {
        return (nullabilityQualifierWithMigrationStatus != null && (nullabilityQualifierWithMigrationStatus2 == null || ((!nullabilityQualifierWithMigrationStatus.isForWarningOnly() || nullabilityQualifierWithMigrationStatus2.isForWarningOnly()) && ((!nullabilityQualifierWithMigrationStatus.isForWarningOnly() && nullabilityQualifierWithMigrationStatus2.isForWarningOnly()) || (nullabilityQualifierWithMigrationStatus.getQualifier().compareTo(nullabilityQualifierWithMigrationStatus2.getQualifier()) >= 0 && nullabilityQualifierWithMigrationStatus.getQualifier().compareTo(nullabilityQualifierWithMigrationStatus2.getQualifier()) > 0))))) ? nullabilityQualifierWithMigrationStatus : nullabilityQualifierWithMigrationStatus2;
    }

    /* JADX WARN: Code duplicated, block: B:46:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:49:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:55:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:56:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:71:0x00cc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:72:0x00c9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:73:? A[LOOP:3: B:47:0x00b7->B:73:?, LOOP_END, SYNTHETIC] */
    private final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus getBoundsNullability(kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker typeParameterMarker) {
        java.util.ArrayList arrayList;
        java.util.List<kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker> list;
        java.util.Iterator<T> it;
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier nullabilityQualifier;
        boolean z;
        kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext typeSystem = getTypeSystem();
        if (!isFromJava(typeParameterMarker)) {
            return null;
        }
        java.util.List<kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker> upperBounds = typeSystem.getUpperBounds(typeParameterMarker);
        java.util.List<kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker> list2 = upperBounds;
        boolean z2 = list2 instanceof java.util.Collection;
        if (!z2 || !list2.isEmpty()) {
            java.util.Iterator<T> it2 = list2.iterator();
            while (it2.hasNext()) {
                if (!typeSystem.isError((kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) it2.next())) {
                    if (!z2 || !list2.isEmpty()) {
                        java.util.Iterator<T> it3 = list2.iterator();
                        while (true) {
                            if (it3.hasNext()) {
                                if (getNullabilityQualifier((kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) it3.next()) != null) {
                                    arrayList = upperBounds;
                                }
                            }
                            list = arrayList;
                            if (!(list instanceof java.util.Collection) && list.isEmpty()) {
                                nullabilityQualifier = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NULLABLE;
                                break;
                            }
                            it = list.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    nullabilityQualifier = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NULLABLE;
                                    break;
                                }
                                if (!typeSystem.isNullableType((kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) it.next())) {
                                    nullabilityQualifier = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NOT_NULL;
                                    break;
                                }
                            }
                            if (arrayList != upperBounds) {
                                z = true;
                            } else {
                                z = false;
                            }
                            return new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus(nullabilityQualifier, z);
                        }
                    }
                    if (!z2 || !list2.isEmpty()) {
                        java.util.Iterator<T> it4 = list2.iterator();
                        while (it4.hasNext()) {
                            if (getEnhancedForWarnings((kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) it4.next()) != null) {
                                java.util.ArrayList arrayList2 = new java.util.ArrayList();
                                java.util.Iterator<T> it5 = list2.iterator();
                                while (it5.hasNext()) {
                                    kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker enhancedForWarnings = getEnhancedForWarnings((kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) it5.next());
                                    if (enhancedForWarnings != null) {
                                        arrayList2.add(enhancedForWarnings);
                                    }
                                }
                                arrayList = arrayList2;
                                list = arrayList;
                                if (!(list instanceof java.util.Collection)) {
                                    it = list.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            nullabilityQualifier = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NULLABLE;
                                            break;
                                        }
                                        if (!typeSystem.isNullableType((kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) it.next())) {
                                            nullabilityQualifier = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NOT_NULL;
                                            break;
                                        }
                                    }
                                } else {
                                    it = list.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            nullabilityQualifier = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NULLABLE;
                                            break;
                                        }
                                        if (!typeSystem.isNullableType((kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) it.next())) {
                                            nullabilityQualifier = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NOT_NULL;
                                            break;
                                        }
                                    }
                                }
                                if (arrayList != upperBounds) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                return new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus(nullabilityQualifier, z);
                            }
                        }
                        break;
                    }
                    break;
                }
            }
        }
        return null;
    }

    public final kotlin.jvm.functions.Function1<java.lang.Integer, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers> computeIndexedQualifiers(kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker kotlinTypeMarker, java.lang.Iterable<? extends kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker> overrides, final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementInfo typeEnhancementInfo, boolean z) {
        int size;
        kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker type;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinTypeMarker, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(overrides, "overrides");
        java.util.List<kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts.TypeAndDefaultQualifiers> indexed = toIndexed(kotlinTypeMarker);
        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(overrides, 10));
        java.util.Iterator<? extends kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker> it = overrides.iterator();
        while (it.hasNext()) {
            arrayList.add(toIndexed(it.next()));
        }
        java.util.ArrayList arrayList2 = arrayList;
        if (getForceOnlyHeadTypeConstructor()) {
            size = 1;
        } else {
            if (isCovariant() && (!(overrides instanceof java.util.Collection) || !((java.util.Collection) overrides).isEmpty())) {
                java.util.Iterator<? extends kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker> it2 = overrides.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (!isEqual(kotlinTypeMarker, it2.next())) {
                            size = 1;
                        }
                    }
                }
            }
            size = indexed.size();
        }
        final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers[] javaTypeQualifiersArr = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers[size];
        int i = 0;
        while (i < size) {
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers javaTypeQualifiersExtractQualifiersFromAnnotations = extractQualifiersFromAnnotations(indexed.get(i));
            java.util.ArrayList arrayList3 = new java.util.ArrayList();
            java.util.Iterator it3 = arrayList2.iterator();
            while (it3.hasNext()) {
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts.TypeAndDefaultQualifiers typeAndDefaultQualifiers = (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts.TypeAndDefaultQualifiers) kotlin.collections.CollectionsKt.getOrNull((java.util.List) it3.next(), i);
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers javaTypeQualifiersExtractQualifiers = (typeAndDefaultQualifiers == null || (type = typeAndDefaultQualifiers.getType()) == null) ? null : extractQualifiers(type);
                if (javaTypeQualifiersExtractQualifiers != null) {
                    arrayList3.add(javaTypeQualifiersExtractQualifiers);
                }
            }
            javaTypeQualifiersArr[i] = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementUtilsKt.computeQualifiersForOverride(javaTypeQualifiersExtractQualifiersFromAnnotations, arrayList3, i == 0 && isCovariant(), i == 0 && getContainerIsVarargParameter(), z);
            i++;
        }
        return new kotlin.jvm.functions.Function1(typeEnhancementInfo, javaTypeQualifiersArr) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts$$Lambda$1
            private final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementInfo arg$0;
            private final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers[] arg$1;

            {
                this.arg$0 = typeEnhancementInfo;
                this.arg$1 = javaTypeQualifiersArr;
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts.computeIndexedQualifiers$lambda$18(this.arg$0, this.arg$1, ((java.lang.Number) obj).intValue());
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers computeIndexedQualifiers$lambda$18(kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementInfo typeEnhancementInfo, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers[] javaTypeQualifiersArr, int i) {
        java.util.Map<java.lang.Integer, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers> map;
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers javaTypeQualifiers;
        if (typeEnhancementInfo == null || (map = typeEnhancementInfo.getMap()) == null || (javaTypeQualifiers = map.get(java.lang.Integer.valueOf(i))) == null) {
            return (i < 0 || i >= javaTypeQualifiersArr.length) ? kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers.Companion.getNONE() : javaTypeQualifiersArr[i];
        }
        return javaTypeQualifiers;
    }

    private final <T> void flattenTree(T t, java.util.List<T> list, kotlin.jvm.functions.Function1<? super T, ? extends java.lang.Iterable<? extends T>> function1) {
        list.add(t);
        java.lang.Iterable<? extends T> iterableInvoke2 = function1.invoke2(t);
        if (iterableInvoke2 != null) {
            java.util.Iterator<? extends T> it = iterableInvoke2.iterator();
            while (it.hasNext()) {
                flattenTree(it.next(), list, function1);
            }
        }
    }

    private final <T> java.util.List<T> flattenTree(T t, kotlin.jvm.functions.Function1<? super T, ? extends java.lang.Iterable<? extends T>> function1) {
        java.util.ArrayList arrayList = new java.util.ArrayList(1);
        flattenTree(t, arrayList, function1);
        return arrayList;
    }

    private final kotlin.reflect.jvm.internal.impl.load.java.JavaTypeQualifiersByElementType extractAndMergeDefaultQualifiers(kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker kotlinTypeMarker, kotlin.reflect.jvm.internal.impl.load.java.JavaTypeQualifiersByElementType javaTypeQualifiersByElementType) {
        return getAnnotationTypeQualifierResolver().extractAndMergeDefaultQualifiers(javaTypeQualifiersByElementType, getAnnotations(kotlinTypeMarker));
    }

    private final java.util.List<kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts.TypeAndDefaultQualifiers> toIndexed(kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker kotlinTypeMarker) {
        final kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext typeSystem = getTypeSystem();
        return flattenTree(new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts.TypeAndDefaultQualifiers(kotlinTypeMarker, extractAndMergeDefaultQualifiers(kotlinTypeMarker, getContainerDefaultTypeQualifiers()), null), new kotlin.jvm.functions.Function1(this, typeSystem) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts$$Lambda$2
            private final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts arg$0;
            private final kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext arg$1;

            {
                this.arg$0 = this;
                this.arg$1 = typeSystem;
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts.toIndexed$lambda$23$lambda$22(this.arg$0, this.arg$1, (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts.TypeAndDefaultQualifiers) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.lang.Iterable toIndexed$lambda$23$lambda$22(kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts abstractSignatureParts, kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext typeSystemContext, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts.TypeAndDefaultQualifiers it) {
        kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker typeConstructorMarkerTypeConstructor;
        java.util.List<kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker> parameters;
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts.TypeAndDefaultQualifiers typeAndDefaultQualifiers;
        kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker type;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(it, "it");
        java.util.ArrayList arrayList = null;
        if (abstractSignatureParts.getSkipRawTypeArguments() && (type = it.getType()) != null && typeSystemContext.isRawType(type)) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker type2 = it.getType();
        if (type2 != null && (typeConstructorMarkerTypeConstructor = typeSystemContext.typeConstructor(type2)) != null && (parameters = typeSystemContext.getParameters(typeConstructorMarkerTypeConstructor)) != null) {
            java.util.List<kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker> list = parameters;
            java.util.List<kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker> arguments = typeSystemContext.getArguments(it.getType());
            java.util.Iterator<T> it2 = list.iterator();
            java.util.Iterator<T> it3 = arguments.iterator();
            java.util.ArrayList arrayList2 = new java.util.ArrayList(java.lang.Math.min(kotlin.collections.CollectionsKt.collectionSizeOrDefault(list, 10), kotlin.collections.CollectionsKt.collectionSizeOrDefault(arguments, 10)));
            while (it2.hasNext() && it3.hasNext()) {
                kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker typeParameterMarker = (kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker) it2.next();
                kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker type3 = typeSystemContext.getType((kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker) it3.next());
                if (type3 == null) {
                    typeAndDefaultQualifiers = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts.TypeAndDefaultQualifiers(null, it.getDefaultQualifiers(), typeParameterMarker);
                } else {
                    typeAndDefaultQualifiers = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts.TypeAndDefaultQualifiers(type3, abstractSignatureParts.extractAndMergeDefaultQualifiers(type3, it.getDefaultQualifiers()), typeParameterMarker);
                }
                arrayList2.add(typeAndDefaultQualifiers);
            }
            arrayList = arrayList2;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: AbstractSignatureParts.kt */
    static final class TypeAndDefaultQualifiers {
        private final kotlin.reflect.jvm.internal.impl.load.java.JavaTypeQualifiersByElementType defaultQualifiers;
        private final kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker type;
        private final kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker typeParameterForArgument;

        public TypeAndDefaultQualifiers(kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker kotlinTypeMarker, kotlin.reflect.jvm.internal.impl.load.java.JavaTypeQualifiersByElementType javaTypeQualifiersByElementType, kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker typeParameterMarker) {
            this.type = kotlinTypeMarker;
            this.defaultQualifiers = javaTypeQualifiersByElementType;
            this.typeParameterForArgument = typeParameterMarker;
        }

        public final kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker getType() {
            return this.type;
        }

        public final kotlin.reflect.jvm.internal.impl.load.java.JavaTypeQualifiersByElementType getDefaultQualifiers() {
            return this.defaultQualifiers;
        }

        public final kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker getTypeParameterForArgument() {
            return this.typeParameterForArgument;
        }
    }
}
