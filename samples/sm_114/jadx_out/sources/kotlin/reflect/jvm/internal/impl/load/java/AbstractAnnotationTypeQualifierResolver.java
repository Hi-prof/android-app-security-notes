package kotlin.reflect.jvm.internal.impl.load.java;

/* JADX INFO: compiled from: AbstractAnnotationTypeQualifierResolver.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractAnnotationTypeQualifierResolver<TAnnotation> {
    private static final kotlin.reflect.jvm.internal.impl.load.java.AbstractAnnotationTypeQualifierResolver.Companion Companion = new kotlin.reflect.jvm.internal.impl.load.java.AbstractAnnotationTypeQualifierResolver.Companion(null);
    private static final java.util.Map<java.lang.String, kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType> JAVA_APPLICABILITY_TYPES;
    private final kotlin.reflect.jvm.internal.impl.load.java.JavaTypeEnhancementState javaTypeEnhancementState;
    private final java.util.concurrent.ConcurrentHashMap<java.lang.Object, TAnnotation> resolvedNicknames;

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean extractDefaultQualifiers$lambda$16(java.lang.Object extractNullability) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(extractNullability, "$this$extractNullability");
        return false;
    }

    protected abstract java.lang.Iterable<java.lang.String> enumArguments(TAnnotation tannotation, boolean z);

    protected abstract kotlin.reflect.jvm.internal.impl.name.FqName getFqName(TAnnotation tannotation);

    protected abstract java.lang.Object getKey(TAnnotation tannotation);

    protected abstract java.lang.Iterable<TAnnotation> getMetaAnnotations(TAnnotation tannotation);

    public abstract boolean isK2();

    public AbstractAnnotationTypeQualifierResolver(kotlin.reflect.jvm.internal.impl.load.java.JavaTypeEnhancementState javaTypeEnhancementState) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(javaTypeEnhancementState, "javaTypeEnhancementState");
        this.javaTypeEnhancementState = javaTypeEnhancementState;
        this.resolvedNicknames = new java.util.concurrent.ConcurrentHashMap<>();
    }

    private final TAnnotation findAnnotation(TAnnotation tannotation, kotlin.reflect.jvm.internal.impl.name.FqName fqName) {
        for (TAnnotation tannotation2 : getMetaAnnotations(tannotation)) {
            if (kotlin.jvm.internal.Intrinsics.areEqual(getFqName(tannotation2), fqName)) {
                return tannotation2;
            }
        }
        return null;
    }

    private final boolean hasAnnotation(TAnnotation tannotation, kotlin.reflect.jvm.internal.impl.name.FqName fqName) {
        java.lang.Iterable<TAnnotation> metaAnnotations = getMetaAnnotations(tannotation);
        if ((metaAnnotations instanceof java.util.Collection) && ((java.util.Collection) metaAnnotations).isEmpty()) {
            return false;
        }
        java.util.Iterator<TAnnotation> it = metaAnnotations.iterator();
        while (it.hasNext()) {
            if (kotlin.jvm.internal.Intrinsics.areEqual(getFqName(it.next()), fqName)) {
                return true;
            }
        }
        return false;
    }

    public final TAnnotation resolveTypeQualifierAnnotation(TAnnotation annotation) {
        TAnnotation tannotationResolveTypeQualifierAnnotation;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(annotation, "annotation");
        if (this.javaTypeEnhancementState.getJsr305().isDisabled()) {
            return null;
        }
        if (kotlin.collections.CollectionsKt.contains(kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNamesKt.getBUILT_IN_TYPE_QUALIFIER_ANNOTATIONS(), getFqName(annotation)) || hasAnnotation(annotation, kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNamesKt.getJAVAX_TYPE_QUALIFIER_ANNOTATION_FQ_NAME())) {
            return annotation;
        }
        if (!hasAnnotation(annotation, kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNamesKt.getJAVAX_TYPE_QUALIFIER_NICKNAME_ANNOTATION_FQ_NAME())) {
            return null;
        }
        java.util.concurrent.ConcurrentHashMap<java.lang.Object, TAnnotation> concurrentHashMap = this.resolvedNicknames;
        java.lang.Object key = getKey(annotation);
        TAnnotation tannotation = concurrentHashMap.get(key);
        if (tannotation != null) {
            return tannotation;
        }
        java.util.Iterator<TAnnotation> it = getMetaAnnotations(annotation).iterator();
        do {
            if (!it.hasNext()) {
                tannotationResolveTypeQualifierAnnotation = null;
                break;
            }
            tannotationResolveTypeQualifierAnnotation = resolveTypeQualifierAnnotation(it.next());
        } while (tannotationResolveTypeQualifierAnnotation == null);
        if (tannotationResolveTypeQualifierAnnotation == null) {
            return null;
        }
        TAnnotation tannotationPutIfAbsent = concurrentHashMap.putIfAbsent(key, tannotationResolveTypeQualifierAnnotation);
        return tannotationPutIfAbsent == null ? tannotationResolveTypeQualifierAnnotation : tannotationPutIfAbsent;
    }

    private final kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers resolveQualifierBuiltInDefaultAnnotation(TAnnotation tannotation) {
        kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers javaDefaultQualifiers;
        if (this.javaTypeEnhancementState.getDisabledDefaultAnnotations() || (javaDefaultQualifiers = kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiersKt.getBUILT_IN_TYPE_QUALIFIER_DEFAULT_ANNOTATIONS().get(getFqName(tannotation))) == null) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.load.java.ReportLevel reportLevelResolveDefaultAnnotationState = resolveDefaultAnnotationState(tannotation);
        if (reportLevelResolveDefaultAnnotationState == kotlin.reflect.jvm.internal.impl.load.java.ReportLevel.IGNORE) {
            reportLevelResolveDefaultAnnotationState = null;
        }
        if (reportLevelResolveDefaultAnnotationState == null) {
            return null;
        }
        return kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers.copy$default(javaDefaultQualifiers, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus.copy$default(javaDefaultQualifiers.getNullabilityQualifier(), null, reportLevelResolveDefaultAnnotationState.isWarning(), 1, null), null, false, 6, null);
    }

    private final kotlin.reflect.jvm.internal.impl.load.java.ReportLevel resolveDefaultAnnotationState(TAnnotation tannotation) {
        kotlin.reflect.jvm.internal.impl.name.FqName fqName = getFqName(tannotation);
        if (fqName != null && kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiersKt.getJSPECIFY_DEFAULT_ANNOTATIONS().containsKey(fqName)) {
            return this.javaTypeEnhancementState.getGetReportLevelForAnnotation().invoke2(fqName);
        }
        return resolveJsr305AnnotationState(tannotation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final java.util.Set<kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType> allIfTypeUse(java.util.Set<? extends kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType> set) {
        return set.contains(kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType.TYPE_USE) ? kotlin.collections.SetsKt.plus(kotlin.collections.SetsKt.minus((java.util.Set<? extends kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType>) kotlin.collections.ArraysKt.toSet(kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType.values()), kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS), (java.lang.Iterable) set) : set;
    }

    private final kotlin.Pair<TAnnotation, java.util.Set<kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType>> resolveTypeQualifierDefaultAnnotation(TAnnotation tannotation) {
        TAnnotation tannotationFindAnnotation;
        TAnnotation next;
        if (this.javaTypeEnhancementState.getJsr305().isDisabled() || (tannotationFindAnnotation = findAnnotation(tannotation, kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNamesKt.getJAVAX_TYPE_QUALIFIER_DEFAULT_ANNOTATION_FQ_NAME())) == null) {
            return null;
        }
        java.util.Iterator<TAnnotation> it = getMetaAnnotations(tannotation).iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (resolveTypeQualifierAnnotation(next) == null);
        if (next == null) {
            return null;
        }
        java.lang.Iterable<java.lang.String> iterableEnumArguments = enumArguments(tannotationFindAnnotation, true);
        java.util.LinkedHashSet linkedHashSet = new java.util.LinkedHashSet();
        java.util.Iterator<java.lang.String> it2 = iterableEnumArguments.iterator();
        while (it2.hasNext()) {
            kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType = JAVA_APPLICABILITY_TYPES.get(it2.next());
            if (annotationQualifierApplicabilityType != null) {
                linkedHashSet.add(annotationQualifierApplicabilityType);
            }
        }
        return new kotlin.Pair<>(next, allIfTypeUse(linkedHashSet));
    }

    public final boolean isTypeUseAnnotation(TAnnotation annotation) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(annotation, "annotation");
        TAnnotation tannotationFindAnnotation = findAnnotation(annotation, kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.target);
        if (tannotationFindAnnotation == null) {
            return false;
        }
        java.lang.Iterable<java.lang.String> iterableEnumArguments = enumArguments(tannotationFindAnnotation, false);
        if ((iterableEnumArguments instanceof java.util.Collection) && ((java.util.Collection) iterableEnumArguments).isEmpty()) {
            return false;
        }
        java.util.Iterator<java.lang.String> it = iterableEnumArguments.iterator();
        while (it.hasNext()) {
            if (kotlin.jvm.internal.Intrinsics.areEqual(it.next(), io.dcloud.feature.barcode2.decoding.Intents.WifiConnect.TYPE)) {
                return true;
            }
        }
        return false;
    }

    private final kotlin.reflect.jvm.internal.impl.load.java.ReportLevel resolveJsr305AnnotationState(TAnnotation tannotation) {
        kotlin.reflect.jvm.internal.impl.load.java.ReportLevel reportLevelResolveJsr305CustomState = resolveJsr305CustomState(tannotation);
        return reportLevelResolveJsr305CustomState != null ? reportLevelResolveJsr305CustomState : this.javaTypeEnhancementState.getJsr305().getGlobalLevel();
    }

    private final kotlin.reflect.jvm.internal.impl.load.java.ReportLevel resolveJsr305CustomState(TAnnotation tannotation) {
        java.lang.Iterable<java.lang.String> iterableEnumArguments;
        java.lang.String str;
        kotlin.reflect.jvm.internal.impl.load.java.ReportLevel reportLevel = this.javaTypeEnhancementState.getJsr305().getUserDefinedLevelForSpecificAnnotation().get(getFqName(tannotation));
        if (reportLevel != null) {
            return reportLevel;
        }
        TAnnotation tannotationFindAnnotation = findAnnotation(tannotation, kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNamesKt.getUNDER_MIGRATION_ANNOTATION_FQ_NAME());
        if (tannotationFindAnnotation == null || (iterableEnumArguments = enumArguments(tannotationFindAnnotation, false)) == null || (str = (java.lang.String) kotlin.collections.CollectionsKt.firstOrNull(iterableEnumArguments)) == null) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.load.java.ReportLevel migrationLevel = this.javaTypeEnhancementState.getJsr305().getMigrationLevel();
        if (migrationLevel != null) {
            return migrationLevel;
        }
        int iHashCode = str.hashCode();
        if (iHashCode != -2137067054) {
            if (iHashCode != -1838656823) {
                if (iHashCode == 2656902 && str.equals("WARN")) {
                    return kotlin.reflect.jvm.internal.impl.load.java.ReportLevel.WARN;
                }
            } else if (str.equals("STRICT")) {
                return kotlin.reflect.jvm.internal.impl.load.java.ReportLevel.STRICT;
            }
        } else if (str.equals("IGNORE")) {
            return kotlin.reflect.jvm.internal.impl.load.java.ReportLevel.IGNORE;
        }
        return null;
    }

    private final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus extractNullability(TAnnotation tannotation, kotlin.jvm.functions.Function1<? super TAnnotation, java.lang.Boolean> function1) {
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatusKnownNullability;
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatusKnownNullability2 = knownNullability(tannotation, function1.invoke2(tannotation).booleanValue());
        if (nullabilityQualifierWithMigrationStatusKnownNullability2 != null) {
            return nullabilityQualifierWithMigrationStatusKnownNullability2;
        }
        TAnnotation tannotationResolveTypeQualifierAnnotation = resolveTypeQualifierAnnotation(tannotation);
        if (tannotationResolveTypeQualifierAnnotation == null) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.load.java.ReportLevel reportLevelResolveJsr305AnnotationState = resolveJsr305AnnotationState(tannotation);
        if (reportLevelResolveJsr305AnnotationState.isIgnore() || (nullabilityQualifierWithMigrationStatusKnownNullability = knownNullability(tannotationResolveTypeQualifierAnnotation, function1.invoke2(tannotationResolveTypeQualifierAnnotation).booleanValue())) == null) {
            return null;
        }
        return kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus.copy$default(nullabilityQualifierWithMigrationStatusKnownNullability, null, reportLevelResolveJsr305AnnotationState.isWarning(), 1, null);
    }

    private final kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers extractDefaultQualifiers(TAnnotation tannotation) {
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatusExtractNullability;
        kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers javaDefaultQualifiersResolveQualifierBuiltInDefaultAnnotation = resolveQualifierBuiltInDefaultAnnotation(tannotation);
        if (javaDefaultQualifiersResolveQualifierBuiltInDefaultAnnotation != null) {
            return javaDefaultQualifiersResolveQualifierBuiltInDefaultAnnotation;
        }
        kotlin.Pair<TAnnotation, java.util.Set<kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType>> pairResolveTypeQualifierDefaultAnnotation = resolveTypeQualifierDefaultAnnotation(tannotation);
        if (pairResolveTypeQualifierDefaultAnnotation == null) {
            return null;
        }
        TAnnotation tannotationComponent1 = pairResolveTypeQualifierDefaultAnnotation.component1();
        java.util.Set<kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType> setComponent2 = pairResolveTypeQualifierDefaultAnnotation.component2();
        kotlin.reflect.jvm.internal.impl.load.java.ReportLevel reportLevelResolveJsr305CustomState = resolveJsr305CustomState(tannotation);
        if (reportLevelResolveJsr305CustomState == null) {
            reportLevelResolveJsr305CustomState = resolveJsr305AnnotationState(tannotationComponent1);
        }
        if (reportLevelResolveJsr305CustomState.isIgnore() || (nullabilityQualifierWithMigrationStatusExtractNullability = extractNullability(tannotationComponent1, new kotlin.jvm.functions.Function1() { // from class: kotlin.reflect.jvm.internal.impl.load.java.AbstractAnnotationTypeQualifierResolver$$Lambda$1
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return java.lang.Boolean.valueOf(kotlin.reflect.jvm.internal.impl.load.java.AbstractAnnotationTypeQualifierResolver.extractDefaultQualifiers$lambda$16(obj));
            }
        })) == null) {
            return null;
        }
        return new kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers(kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus.copy$default(nullabilityQualifierWithMigrationStatusExtractNullability, null, reportLevelResolveJsr305CustomState.isWarning(), 1, null), setComponent2, false, 4, null);
    }

    public final kotlin.reflect.jvm.internal.impl.load.java.JavaTypeQualifiersByElementType extractAndMergeDefaultQualifiers(kotlin.reflect.jvm.internal.impl.load.java.JavaTypeQualifiersByElementType javaTypeQualifiersByElementType, java.lang.Iterable<? extends TAnnotation> annotations) {
        java.util.EnumMap<kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType, kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers> defaultQualifiers;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(annotations, "annotations");
        if (!this.javaTypeEnhancementState.getDisabledDefaultAnnotations()) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            java.util.Iterator<? extends TAnnotation> it = annotations.iterator();
            while (it.hasNext()) {
                kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers javaDefaultQualifiersExtractDefaultQualifiers = extractDefaultQualifiers(it.next());
                if (javaDefaultQualifiersExtractDefaultQualifiers != null) {
                    arrayList.add(javaDefaultQualifiersExtractDefaultQualifiers);
                }
            }
            java.util.ArrayList<kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers> arrayList2 = arrayList;
            if (!arrayList2.isEmpty()) {
                java.util.EnumMap enumMap = new java.util.EnumMap(kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType.class);
                for (kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers javaDefaultQualifiers : arrayList2) {
                    for (kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType : javaDefaultQualifiers.getQualifierApplicabilityTypes()) {
                        java.util.EnumMap enumMap2 = enumMap;
                        if (!enumMap2.containsKey(annotationQualifierApplicabilityType) || !isK2()) {
                            enumMap2.put(annotationQualifierApplicabilityType, javaDefaultQualifiers);
                        } else {
                            kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers javaDefaultQualifiers2 = (kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers) enumMap.get(annotationQualifierApplicabilityType);
                            if (javaDefaultQualifiers2 != null) {
                                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus nullabilityQualifier = javaDefaultQualifiers2.getNullabilityQualifier();
                                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus nullabilityQualifier2 = javaDefaultQualifiers.getNullabilityQualifier();
                                if (!kotlin.jvm.internal.Intrinsics.areEqual(nullabilityQualifier2, nullabilityQualifier) && (!nullabilityQualifier2.isForWarningOnly() || nullabilityQualifier.isForWarningOnly())) {
                                    javaDefaultQualifiers2 = (nullabilityQualifier2.isForWarningOnly() || !nullabilityQualifier.isForWarningOnly()) ? null : javaDefaultQualifiers;
                                }
                                enumMap2.put(annotationQualifierApplicabilityType, javaDefaultQualifiers2);
                            }
                        }
                    }
                }
                java.util.EnumMap enumMap3 = (javaTypeQualifiersByElementType == null || (defaultQualifiers = javaTypeQualifiersByElementType.getDefaultQualifiers()) == null) ? new java.util.EnumMap(kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType.class) : new java.util.EnumMap((java.util.EnumMap) defaultQualifiers);
                boolean z = false;
                for (java.util.Map.Entry entry : enumMap.entrySet()) {
                    kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType2 = (kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType) entry.getKey();
                    kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers javaDefaultQualifiers3 = (kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers) entry.getValue();
                    if (javaDefaultQualifiers3 != null) {
                        enumMap3.put(annotationQualifierApplicabilityType2, javaDefaultQualifiers3);
                        z = true;
                    }
                }
                if (z) {
                    return new kotlin.reflect.jvm.internal.impl.load.java.JavaTypeQualifiersByElementType(enumMap3);
                }
            }
        }
        return javaTypeQualifiersByElementType;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0068, code lost:
    
        if (r6.equals("ALWAYS") != false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007d, code lost:
    
        if (r6.equals("NEVER") == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0086, code lost:
    
        if (r6.equals("MAYBE") == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0089, code lost:
    
        r6 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NULLABLE;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus knownNullability(TAnnotation r6, boolean r7) {
        /*
            r5 = this;
            kotlin.reflect.jvm.internal.impl.name.FqName r0 = r5.getFqName(r6)
            r1 = 0
            if (r0 != 0) goto L8
            return r1
        L8:
            kotlin.reflect.jvm.internal.impl.load.java.JavaTypeEnhancementState r2 = r5.javaTypeEnhancementState
            kotlin.jvm.functions.Function1 r2 = r2.getGetReportLevelForAnnotation()
            java.lang.Object r2 = r2.invoke2(r0)
            kotlin.reflect.jvm.internal.impl.load.java.ReportLevel r2 = (kotlin.reflect.jvm.internal.impl.load.java.ReportLevel) r2
            boolean r3 = r2.isIgnore()
            if (r3 == 0) goto L1b
            return r1
        L1b:
            java.util.Set r3 = kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNamesKt.getNOT_NULL_ANNOTATIONS()
            boolean r3 = r3.contains(r0)
            r4 = 0
            if (r3 == 0) goto L2a
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r6 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NOT_NULL
            goto L8f
        L2a:
            java.util.Set r3 = kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNamesKt.getNULLABLE_ANNOTATIONS()
            boolean r3 = r3.contains(r0)
            if (r3 == 0) goto L37
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r6 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NULLABLE
            goto L8f
        L37:
            java.util.Set r3 = kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNamesKt.getFORCE_FLEXIBILITY_ANNOTATIONS()
            boolean r3 = r3.contains(r0)
            if (r3 == 0) goto L44
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r6 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.FORCE_FLEXIBILITY
            goto L8f
        L44:
            kotlin.reflect.jvm.internal.impl.name.FqName r3 = kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNamesKt.getJAVAX_NONNULL_ANNOTATION_FQ_NAME()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r3)
            if (r0 == 0) goto L9e
            java.lang.Iterable r6 = r5.enumArguments(r6, r4)
            java.lang.Object r6 = kotlin.collections.CollectionsKt.firstOrNull(r6)
            java.lang.String r6 = (java.lang.String) r6
            if (r6 == 0) goto L8d
            int r0 = r6.hashCode()
            switch(r0) {
                case 73135176: goto L80;
                case 74175084: goto L77;
                case 433141802: goto L6b;
                case 1933739535: goto L62;
                default: goto L61;
            }
        L61:
            goto L8c
        L62:
            java.lang.String r0 = "ALWAYS"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L8c
            goto L8d
        L6b:
            java.lang.String r0 = "UNKNOWN"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L74
            goto L8c
        L74:
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r6 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.FORCE_FLEXIBILITY
            goto L8f
        L77:
            java.lang.String r0 = "NEVER"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L89
            goto L8c
        L80:
            java.lang.String r0 = "MAYBE"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L89
            goto L8c
        L89:
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r6 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NULLABLE
            goto L8f
        L8c:
            return r1
        L8d:
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r6 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NOT_NULL
        L8f:
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus r0 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus
            boolean r1 = r2.isWarning()
            if (r1 != 0) goto L99
            if (r7 == 0) goto L9a
        L99:
            r4 = 1
        L9a:
            r0.<init>(r6, r4)
            return r0
        L9e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.AbstractAnnotationTypeQualifierResolver.knownNullability(java.lang.Object, boolean):kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus");
    }

    /* JADX INFO: compiled from: AbstractAnnotationTypeQualifierResolver.kt */
    private static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
        for (kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType : kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType.values()) {
            java.lang.String javaTarget = annotationQualifierApplicabilityType.getJavaTarget();
            if (linkedHashMap.get(javaTarget) == null) {
                linkedHashMap.put(javaTarget, annotationQualifierApplicabilityType);
            }
        }
        JAVA_APPLICABILITY_TYPES = linkedHashMap;
    }

    public final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus extractNullability(java.lang.Iterable<? extends TAnnotation> annotations, kotlin.jvm.functions.Function1<? super TAnnotation, java.lang.Boolean> forceWarning) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(annotations, "annotations");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(forceWarning, "forceWarning");
        java.util.Iterator<? extends TAnnotation> it = annotations.iterator();
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus = null;
        while (it.hasNext()) {
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatusExtractNullability = extractNullability(it.next(), forceWarning);
            if (nullabilityQualifierWithMigrationStatus != null) {
                if (nullabilityQualifierWithMigrationStatusExtractNullability != null && !kotlin.jvm.internal.Intrinsics.areEqual(nullabilityQualifierWithMigrationStatusExtractNullability, nullabilityQualifierWithMigrationStatus) && (!nullabilityQualifierWithMigrationStatusExtractNullability.isForWarningOnly() || nullabilityQualifierWithMigrationStatus.isForWarningOnly())) {
                    if (nullabilityQualifierWithMigrationStatusExtractNullability.isForWarningOnly() || !nullabilityQualifierWithMigrationStatus.isForWarningOnly()) {
                        return null;
                    }
                }
            }
            nullabilityQualifierWithMigrationStatus = nullabilityQualifierWithMigrationStatusExtractNullability;
        }
        return nullabilityQualifierWithMigrationStatus;
    }

    public final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier extractMutability(java.lang.Iterable<? extends TAnnotation> annotations) {
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier mutabilityQualifier;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(annotations, "annotations");
        java.util.Iterator<? extends TAnnotation> it = annotations.iterator();
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier mutabilityQualifier2 = null;
        while (it.hasNext()) {
            kotlin.reflect.jvm.internal.impl.name.FqName fqName = getFqName(it.next());
            if (kotlin.collections.CollectionsKt.contains(kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNamesKt.getREAD_ONLY_ANNOTATIONS(), fqName)) {
                mutabilityQualifier = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier.READ_ONLY;
            } else if (kotlin.collections.CollectionsKt.contains(kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNamesKt.getMUTABLE_ANNOTATIONS(), fqName)) {
                mutabilityQualifier = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier.MUTABLE;
            } else {
                continue;
            }
            if (mutabilityQualifier2 != null && mutabilityQualifier2 != mutabilityQualifier) {
                return null;
            }
            mutabilityQualifier2 = mutabilityQualifier;
        }
        return mutabilityQualifier2;
    }
}
