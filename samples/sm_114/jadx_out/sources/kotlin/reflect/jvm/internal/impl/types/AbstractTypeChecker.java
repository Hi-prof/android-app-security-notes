package kotlin.reflect.jvm.internal.impl.types;

/* JADX INFO: compiled from: AbstractTypeChecker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AbstractTypeChecker {
    public static final kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker INSTANCE = new kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker();
    public static boolean RUN_SLOW_ASSERTIONS;

    /* JADX INFO: compiled from: AbstractTypeChecker.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[kotlin.reflect.jvm.internal.impl.types.model.TypeVariance.values().length];
            try {
                iArr[kotlin.reflect.jvm.internal.impl.types.model.TypeVariance.INV.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                iArr[kotlin.reflect.jvm.internal.impl.types.model.TypeVariance.OUT.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                iArr[kotlin.reflect.jvm.internal.impl.types.model.TypeVariance.IN.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.LowerCapturedTypePolicy.values().length];
            try {
                iArr2[kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.LowerCapturedTypePolicy.CHECK_ONLY_LOWER.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                iArr2[kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.LowerCapturedTypePolicy.CHECK_SUBTYPE_AND_LOWER.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            try {
                iArr2[kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.LowerCapturedTypePolicy.SKIP_LOWER.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public final boolean isSubtypeOf(kotlin.reflect.jvm.internal.impl.types.TypeCheckerState state, kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker subType, kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker superType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(state, "state");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(subType, "subType");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(superType, "superType");
        return isSubtypeOf$default(this, state, subType, superType, false, 8, null);
    }

    private AbstractTypeChecker() {
    }

    public static /* synthetic */ boolean isSubtypeOf$default(kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker abstractTypeChecker, kotlin.reflect.jvm.internal.impl.types.TypeCheckerState typeCheckerState, kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker kotlinTypeMarker, kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker kotlinTypeMarker2, boolean z, int i, java.lang.Object obj) {
        if ((i & 8) != 0) {
            z = false;
        }
        return abstractTypeChecker.isSubtypeOf(typeCheckerState, kotlinTypeMarker, kotlinTypeMarker2, z);
    }

    public final boolean isSubtypeOf(kotlin.reflect.jvm.internal.impl.types.TypeCheckerState state, kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker subType, kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker superType, boolean z) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(state, "state");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(subType, "subType");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(superType, "superType");
        if (subType == superType) {
            return true;
        }
        if (state.customIsSubtypeOf(subType, superType)) {
            return completeIsSubTypeOf(state, subType, superType, z);
        }
        return false;
    }

    public final boolean equalTypes(kotlin.reflect.jvm.internal.impl.types.TypeCheckerState state, kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker a, kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker b) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(state, "state");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(a, "a");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(b, "b");
        kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext typeSystemContext = state.getTypeSystemContext();
        if (a == b) {
            return true;
        }
        kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker abstractTypeChecker = INSTANCE;
        if (abstractTypeChecker.isCommonDenotableType(typeSystemContext, a) && abstractTypeChecker.isCommonDenotableType(typeSystemContext, b)) {
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker kotlinTypeMarkerPrepareType = state.prepareType(state.refineType(a));
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker kotlinTypeMarkerPrepareType2 = state.prepareType(state.refineType(b));
            kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarkerLowerBoundIfFlexible = typeSystemContext.lowerBoundIfFlexible(kotlinTypeMarkerPrepareType);
            if (!typeSystemContext.areEqualTypeConstructors(typeSystemContext.typeConstructor(kotlinTypeMarkerPrepareType), typeSystemContext.typeConstructor(kotlinTypeMarkerPrepareType2))) {
                return false;
            }
            kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarker = rigidTypeMarkerLowerBoundIfFlexible;
            if (typeSystemContext.argumentsCount(rigidTypeMarker) == 0) {
                return typeSystemContext.hasFlexibleNullability(kotlinTypeMarkerPrepareType) || typeSystemContext.hasFlexibleNullability(kotlinTypeMarkerPrepareType2) || typeSystemContext.isMarkedNullable(rigidTypeMarker) == typeSystemContext.isMarkedNullable(typeSystemContext.lowerBoundIfFlexible(kotlinTypeMarkerPrepareType2));
            }
        }
        return isSubtypeOf$default(abstractTypeChecker, state, a, b, false, 8, null) && isSubtypeOf$default(abstractTypeChecker, state, b, a, false, 8, null);
    }

    private final boolean completeIsSubTypeOf(kotlin.reflect.jvm.internal.impl.types.TypeCheckerState typeCheckerState, kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker kotlinTypeMarker, kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker kotlinTypeMarker2, boolean z) {
        kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext typeSystemContext = typeCheckerState.getTypeSystemContext();
        kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker kotlinTypeMarkerPrepareType = typeCheckerState.prepareType(typeCheckerState.refineType(kotlinTypeMarker));
        kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker kotlinTypeMarkerPrepareType2 = typeCheckerState.prepareType(typeCheckerState.refineType(kotlinTypeMarker2));
        if (typeCheckerState.isDnnTypesEqualToFlexible() && typeSystemContext.isFlexible(kotlinTypeMarkerPrepareType) && typeSystemContext.isDefinitelyNotNullType(kotlinTypeMarkerPrepareType2)) {
            kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker abstractTypeChecker = INSTANCE;
            kotlin.reflect.jvm.internal.impl.types.model.FlexibleTypeMarker flexibleTypeMarkerAsFlexibleType = typeSystemContext.asFlexibleType(kotlinTypeMarkerPrepareType);
            kotlin.jvm.internal.Intrinsics.checkNotNull(flexibleTypeMarkerAsFlexibleType);
            kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarkerLowerBound = typeSystemContext.lowerBound(flexibleTypeMarkerAsFlexibleType);
            kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarkerAsRigidType = typeSystemContext.asRigidType(kotlinTypeMarkerPrepareType2);
            kotlin.jvm.internal.Intrinsics.checkNotNull(rigidTypeMarkerAsRigidType);
            return abstractTypeChecker.completeIsSubTypeOf(typeCheckerState, rigidTypeMarkerLowerBound, typeSystemContext.originalIfDefinitelyNotNullable(rigidTypeMarkerAsRigidType), z);
        }
        kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker abstractTypeChecker2 = INSTANCE;
        java.lang.Boolean boolCheckSubtypeForSpecialCases = abstractTypeChecker2.checkSubtypeForSpecialCases(typeCheckerState, typeSystemContext.lowerBoundIfFlexible(kotlinTypeMarkerPrepareType), typeSystemContext.upperBoundIfFlexible(kotlinTypeMarkerPrepareType2));
        if (boolCheckSubtypeForSpecialCases != null) {
            boolean zBooleanValue = boolCheckSubtypeForSpecialCases.booleanValue();
            typeCheckerState.addSubtypeConstraint(kotlinTypeMarkerPrepareType, kotlinTypeMarkerPrepareType2, z);
            return zBooleanValue;
        }
        java.lang.Boolean boolAddSubtypeConstraint = typeCheckerState.addSubtypeConstraint(kotlinTypeMarkerPrepareType, kotlinTypeMarkerPrepareType2, z);
        return boolAddSubtypeConstraint != null ? boolAddSubtypeConstraint.booleanValue() : abstractTypeChecker2.isSubtypeOfForSingleClassifierType(typeCheckerState, typeSystemContext.lowerBoundIfFlexible(kotlinTypeMarkerPrepareType), typeSystemContext.upperBoundIfFlexible(kotlinTypeMarkerPrepareType2));
    }

    private final java.lang.Boolean checkSubtypeForIntegerLiteralType(kotlin.reflect.jvm.internal.impl.types.TypeCheckerState typeCheckerState, kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarker, kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarker2) {
        kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext typeSystemContext = typeCheckerState.getTypeSystemContext();
        if (!typeSystemContext.isIntegerLiteralType(rigidTypeMarker) && !typeSystemContext.isIntegerLiteralType(rigidTypeMarker2)) {
            return null;
        }
        if (checkSubtypeForIntegerLiteralType$lambda$7$isIntegerLiteralTypeOrCapturedOne(typeSystemContext, rigidTypeMarker) && checkSubtypeForIntegerLiteralType$lambda$7$isIntegerLiteralTypeOrCapturedOne(typeSystemContext, rigidTypeMarker2)) {
            return true;
        }
        if (typeSystemContext.isIntegerLiteralType(rigidTypeMarker)) {
            if (checkSubtypeForIntegerLiteralType$lambda$7$isTypeInIntegerLiteralType(typeSystemContext, typeCheckerState, rigidTypeMarker, rigidTypeMarker2, false)) {
                return true;
            }
        } else if (typeSystemContext.isIntegerLiteralType(rigidTypeMarker2) && (checkSubtypeForIntegerLiteralType$lambda$7$isIntegerLiteralTypeInIntersectionComponents(typeSystemContext, rigidTypeMarker) || checkSubtypeForIntegerLiteralType$lambda$7$isTypeInIntegerLiteralType(typeSystemContext, typeCheckerState, rigidTypeMarker2, rigidTypeMarker, true))) {
            return true;
        }
        return null;
    }

    private static final boolean checkSubtypeForIntegerLiteralType$lambda$7$isTypeInIntegerLiteralType(kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext typeSystemContext, kotlin.reflect.jvm.internal.impl.types.TypeCheckerState typeCheckerState, kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarker, kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarker2, boolean z) {
        kotlin.reflect.jvm.internal.impl.types.TypeCheckerState typeCheckerState2;
        java.util.Collection<kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker> collectionPossibleIntegerTypes = typeSystemContext.possibleIntegerTypes(rigidTypeMarker);
        if ((collectionPossibleIntegerTypes instanceof java.util.Collection) && collectionPossibleIntegerTypes.isEmpty()) {
            return false;
        }
        for (kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker kotlinTypeMarker : collectionPossibleIntegerTypes) {
            if (kotlin.jvm.internal.Intrinsics.areEqual(typeSystemContext.typeConstructor(kotlinTypeMarker), typeSystemContext.typeConstructor(rigidTypeMarker2))) {
                return true;
            }
            if (z) {
                typeCheckerState2 = typeCheckerState;
                if (isSubtypeOf$default(INSTANCE, typeCheckerState2, rigidTypeMarker2, kotlinTypeMarker, false, 8, null)) {
                    return true;
                }
            } else {
                typeCheckerState2 = typeCheckerState;
            }
            typeCheckerState = typeCheckerState2;
        }
        return false;
    }

    private static final boolean checkSubtypeForIntegerLiteralType$lambda$7$isIntegerLiteralTypeInIntersectionComponents(kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext typeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarker) {
        kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker typeConstructorMarkerTypeConstructor = typeSystemContext.typeConstructor(rigidTypeMarker);
        if (!(typeConstructorMarkerTypeConstructor instanceof kotlin.reflect.jvm.internal.impl.types.model.IntersectionTypeConstructorMarker)) {
            return false;
        }
        java.util.Collection<kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker> collectionSupertypes = typeSystemContext.supertypes(typeConstructorMarkerTypeConstructor);
        if ((collectionSupertypes instanceof java.util.Collection) && collectionSupertypes.isEmpty()) {
            return false;
        }
        java.util.Iterator<T> it = collectionSupertypes.iterator();
        while (it.hasNext()) {
            kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarkerAsRigidType = typeSystemContext.asRigidType((kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) it.next());
            if (rigidTypeMarkerAsRigidType != null && typeSystemContext.isIntegerLiteralType(rigidTypeMarkerAsRigidType)) {
                return true;
            }
        }
        return false;
    }

    private static final boolean checkSubtypeForIntegerLiteralType$lambda$7$isCapturedIntegerLiteralType(kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext typeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarker) {
        kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker type;
        kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarkerUpperBoundIfFlexible;
        return (rigidTypeMarker instanceof kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker) && (type = typeSystemContext.getType(typeSystemContext.projection(typeSystemContext.typeConstructor((kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker) rigidTypeMarker)))) != null && (rigidTypeMarkerUpperBoundIfFlexible = typeSystemContext.upperBoundIfFlexible(type)) != null && typeSystemContext.isIntegerLiteralType(rigidTypeMarkerUpperBoundIfFlexible);
    }

    private static final boolean checkSubtypeForIntegerLiteralType$lambda$7$isIntegerLiteralTypeOrCapturedOne(kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext typeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarker) {
        return typeSystemContext.isIntegerLiteralType(rigidTypeMarker) || checkSubtypeForIntegerLiteralType$lambda$7$isCapturedIntegerLiteralType(typeSystemContext, rigidTypeMarker);
    }

    private final boolean hasNothingSupertype(kotlin.reflect.jvm.internal.impl.types.TypeCheckerState typeCheckerState, kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarker) {
        kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.SupertypesPolicy.LowerIfFlexible lowerIfFlexible;
        kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext typeSystemContext = typeCheckerState.getTypeSystemContext();
        kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker typeConstructorMarkerTypeConstructor = typeSystemContext.typeConstructor(rigidTypeMarker);
        if (typeSystemContext.isClassTypeConstructor(typeConstructorMarkerTypeConstructor)) {
            return typeSystemContext.isNothingConstructor(typeConstructorMarkerTypeConstructor);
        }
        if (typeSystemContext.isNothingConstructor(typeSystemContext.typeConstructor(rigidTypeMarker))) {
            return true;
        }
        typeCheckerState.initialize();
        java.util.ArrayDeque<kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker> supertypesDeque = typeCheckerState.getSupertypesDeque();
        kotlin.jvm.internal.Intrinsics.checkNotNull(supertypesDeque);
        java.util.Set<kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker> supertypesSet = typeCheckerState.getSupertypesSet();
        kotlin.jvm.internal.Intrinsics.checkNotNull(supertypesSet);
        supertypesDeque.push(rigidTypeMarker);
        while (!supertypesDeque.isEmpty()) {
            kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarkerPop = supertypesDeque.pop();
            kotlin.jvm.internal.Intrinsics.checkNotNull(rigidTypeMarkerPop);
            if (supertypesSet.add(rigidTypeMarkerPop)) {
                if (typeSystemContext.isClassType(rigidTypeMarkerPop)) {
                    lowerIfFlexible = kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.SupertypesPolicy.None.INSTANCE;
                } else {
                    lowerIfFlexible = kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.SupertypesPolicy.LowerIfFlexible.INSTANCE;
                }
                if (kotlin.jvm.internal.Intrinsics.areEqual(lowerIfFlexible, kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.SupertypesPolicy.None.INSTANCE)) {
                    lowerIfFlexible = null;
                }
                if (lowerIfFlexible == null) {
                    continue;
                } else {
                    kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext typeSystemContext2 = typeCheckerState.getTypeSystemContext();
                    java.util.Iterator<kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker> it = typeSystemContext2.supertypes(typeSystemContext2.typeConstructor(rigidTypeMarkerPop)).iterator();
                    while (it.hasNext()) {
                        kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarkerMo1839transformType = lowerIfFlexible.mo1839transformType(typeCheckerState, it.next());
                        if (typeSystemContext.isNothingConstructor(typeSystemContext.typeConstructor(rigidTypeMarkerMo1839transformType))) {
                            typeCheckerState.clear();
                            return true;
                        }
                        supertypesDeque.add(rigidTypeMarkerMo1839transformType);
                    }
                }
            }
        }
        typeCheckerState.clear();
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:106:0x00ee A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:44:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:47:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:50:0x00ed  */
    private final boolean isSubtypeOfForSingleClassifierType(final kotlin.reflect.jvm.internal.impl.types.TypeCheckerState typeCheckerState, kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarker, final kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarker2) {
        java.util.ArrayList arrayList;
        final java.util.ArrayList linkedHashSet;
        kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarkerAsRigidType;
        kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker type;
        final kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext typeSystemContext = typeCheckerState.getTypeSystemContext();
        if (RUN_SLOW_ASSERTIONS) {
            if (!typeSystemContext.isSingleClassifierType(rigidTypeMarker) && !typeSystemContext.isIntersection(typeSystemContext.typeConstructor(rigidTypeMarker))) {
                typeCheckerState.isAllowedTypeVariable(rigidTypeMarker);
            }
            if (!typeSystemContext.isSingleClassifierType(rigidTypeMarker2)) {
                typeCheckerState.isAllowedTypeVariable(rigidTypeMarker2);
            }
        }
        if (!kotlin.reflect.jvm.internal.impl.types.AbstractNullabilityChecker.INSTANCE.isPossibleSubtype(typeCheckerState, rigidTypeMarker, rigidTypeMarker2)) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker abstractTypeChecker = INSTANCE;
        java.lang.Boolean boolCheckSubtypeForIntegerLiteralType = abstractTypeChecker.checkSubtypeForIntegerLiteralType(typeCheckerState, rigidTypeMarker, rigidTypeMarker2);
        if (boolCheckSubtypeForIntegerLiteralType != null) {
            boolean zBooleanValue = boolCheckSubtypeForIntegerLiteralType.booleanValue();
            kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.addSubtypeConstraint$default(typeCheckerState, rigidTypeMarker, rigidTypeMarker2, false, 4, null);
            return zBooleanValue;
        }
        kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker typeConstructorMarkerTypeConstructor = typeSystemContext.typeConstructor(rigidTypeMarker2);
        if ((typeSystemContext.areEqualTypeConstructors(typeSystemContext.typeConstructor(rigidTypeMarker), typeConstructorMarkerTypeConstructor) && typeSystemContext.parametersCount(typeConstructorMarkerTypeConstructor) == 0) || typeSystemContext.isAnyConstructor(typeSystemContext.typeConstructor(rigidTypeMarker2))) {
            return true;
        }
        java.util.List<kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker> listFindCorrespondingSupertypes = abstractTypeChecker.findCorrespondingSupertypes(typeCheckerState, rigidTypeMarker, typeConstructorMarkerTypeConstructor);
        int i = 10;
        if (listFindCorrespondingSupertypes.size() > 1) {
            kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext typeSystemContext2 = typeCheckerState.getTypeSystemContext();
            kotlin.reflect.jvm.internal.impl.types.model.TypeSystemInferenceExtensionContext typeSystemInferenceExtensionContext = typeSystemContext2 instanceof kotlin.reflect.jvm.internal.impl.types.model.TypeSystemInferenceExtensionContext ? (kotlin.reflect.jvm.internal.impl.types.model.TypeSystemInferenceExtensionContext) typeSystemContext2 : null;
            if (typeSystemInferenceExtensionContext == null || !typeSystemInferenceExtensionContext.isK2()) {
                java.util.List<kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker> list = listFindCorrespondingSupertypes;
                arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(list, 10));
                for (kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarker3 : list) {
                    rigidTypeMarkerAsRigidType = typeSystemContext.asRigidType(typeCheckerState.prepareType(rigidTypeMarker3));
                    if (rigidTypeMarkerAsRigidType == null) {
                        rigidTypeMarker3 = rigidTypeMarkerAsRigidType;
                    }
                    arrayList.add(rigidTypeMarker3);
                }
                linkedHashSet = arrayList;
            } else {
                linkedHashSet = new java.util.LinkedHashSet();
                for (kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarker4 : listFindCorrespondingSupertypes) {
                    kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarkerAsRigidType2 = typeSystemContext.asRigidType(typeCheckerState.prepareType(rigidTypeMarker4));
                    if (rigidTypeMarkerAsRigidType2 != null) {
                        rigidTypeMarker4 = rigidTypeMarkerAsRigidType2;
                    }
                    linkedHashSet.add(rigidTypeMarker4);
                }
            }
        } else {
            java.util.List<kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker> list2 = listFindCorrespondingSupertypes;
            arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(list2, 10));
            while (r4.hasNext()) {
                rigidTypeMarkerAsRigidType = typeSystemContext.asRigidType(typeCheckerState.prepareType(rigidTypeMarker3));
                if (rigidTypeMarkerAsRigidType == null) {
                    rigidTypeMarker3 = rigidTypeMarkerAsRigidType;
                }
                arrayList.add(rigidTypeMarker3);
            }
            linkedHashSet = arrayList;
        }
        int size = linkedHashSet.size();
        if (size == 0) {
            return INSTANCE.hasNothingSupertype(typeCheckerState, rigidTypeMarker);
        }
        if (size == 1) {
            return INSTANCE.isSubtypeForSameConstructor(typeCheckerState, typeSystemContext.asArgumentList((kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker) kotlin.collections.CollectionsKt.first(linkedHashSet)), rigidTypeMarker2);
        }
        kotlin.reflect.jvm.internal.impl.types.model.ArgumentList argumentList = new kotlin.reflect.jvm.internal.impl.types.model.ArgumentList(typeSystemContext.parametersCount(typeConstructorMarkerTypeConstructor));
        int iParametersCount = typeSystemContext.parametersCount(typeConstructorMarkerTypeConstructor);
        int i2 = 0;
        boolean z = false;
        while (i2 < iParametersCount) {
            z = z || typeSystemContext.getVariance(typeSystemContext.getParameter(typeConstructorMarkerTypeConstructor, i2)) != kotlin.reflect.jvm.internal.impl.types.model.TypeVariance.OUT;
            if (!z) {
                java.util.Collection<kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker> collection = linkedHashSet;
                java.util.ArrayList arrayList2 = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(collection, i));
                for (kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarker5 : collection) {
                    kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker argumentOrNull = typeSystemContext.getArgumentOrNull(rigidTypeMarker5, i2);
                    if (argumentOrNull != null) {
                        if (typeSystemContext.getVariance(argumentOrNull) != kotlin.reflect.jvm.internal.impl.types.model.TypeVariance.INV) {
                            argumentOrNull = null;
                        }
                        if (argumentOrNull != null && (type = typeSystemContext.getType(argumentOrNull)) != null) {
                            arrayList2.add(type);
                        }
                    }
                    throw new java.lang.IllegalStateException(("Incorrect type: " + rigidTypeMarker5 + ", subType: " + rigidTypeMarker + ", superType: " + rigidTypeMarker2).toString());
                }
                argumentList.add(typeSystemContext.asTypeArgument(typeSystemContext.intersectTypes(arrayList2)));
            }
            i2++;
            i = 10;
        }
        if (z || !INSTANCE.isSubtypeForSameConstructor(typeCheckerState, argumentList, rigidTypeMarker2)) {
            return typeCheckerState.runForkingPoint(new kotlin.jvm.functions.Function1(linkedHashSet, typeCheckerState, typeSystemContext, rigidTypeMarker2) { // from class: kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker$$Lambda$0
                private final java.util.Collection arg$0;
                private final kotlin.reflect.jvm.internal.impl.types.TypeCheckerState arg$1;
                private final kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext arg$2;
                private final kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker arg$3;

                {
                    this.arg$0 = linkedHashSet;
                    this.arg$1 = typeCheckerState;
                    this.arg$2 = typeSystemContext;
                    this.arg$3 = rigidTypeMarker2;
                }

                @Override // kotlin.jvm.functions.Function1
                /* JADX INFO: renamed from: invoke */
                public java.lang.Object invoke2(java.lang.Object obj) {
                    return kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker.isSubtypeOfForSingleClassifierType$lambda$21$lambda$20(this.arg$0, this.arg$1, this.arg$2, this.arg$3, (kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.ForkPointContext) obj);
                }
            });
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit isSubtypeOfForSingleClassifierType$lambda$21$lambda$20(java.util.Collection collection, final kotlin.reflect.jvm.internal.impl.types.TypeCheckerState typeCheckerState, final kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext typeSystemContext, final kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarker, kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.ForkPointContext runForkingPoint) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(runForkingPoint, "$this$runForkingPoint");
        java.util.Iterator it = collection.iterator();
        while (it.hasNext()) {
            final kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarker2 = (kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker) it.next();
            runForkingPoint.fork(new kotlin.jvm.functions.Function0(typeCheckerState, typeSystemContext, rigidTypeMarker2, rigidTypeMarker) { // from class: kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker$$Lambda$1
                private final kotlin.reflect.jvm.internal.impl.types.TypeCheckerState arg$0;
                private final kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext arg$1;
                private final kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker arg$2;
                private final kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker arg$3;

                {
                    this.arg$0 = typeCheckerState;
                    this.arg$1 = typeSystemContext;
                    this.arg$2 = rigidTypeMarker2;
                    this.arg$3 = rigidTypeMarker;
                }

                @Override // kotlin.jvm.functions.Function0
                public java.lang.Object invoke() {
                    return java.lang.Boolean.valueOf(kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker.isSubtypeOfForSingleClassifierType$lambda$21$lambda$20$lambda$19(this.arg$0, this.arg$1, this.arg$2, this.arg$3));
                }
            });
        }
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isSubtypeOfForSingleClassifierType$lambda$21$lambda$20$lambda$19(kotlin.reflect.jvm.internal.impl.types.TypeCheckerState typeCheckerState, kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext typeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarker, kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarker2) {
        return INSTANCE.isSubtypeForSameConstructor(typeCheckerState, typeSystemContext.asArgumentList(rigidTypeMarker), rigidTypeMarker2);
    }

    private final boolean isTypeVariableAgainstStarProjectionForSelfType(kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext typeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker kotlinTypeMarker, kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker kotlinTypeMarker2, kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker typeConstructorMarker) {
        kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker typeParameter;
        kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarkerAsRigidType = typeSystemContext.asRigidType(kotlinTypeMarker);
        if (rigidTypeMarkerAsRigidType instanceof kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker) {
            kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker capturedTypeMarker = (kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker) rigidTypeMarkerAsRigidType;
            if (typeSystemContext.isOldCapturedType(capturedTypeMarker) || !typeSystemContext.isStarProjection(typeSystemContext.projection(typeSystemContext.typeConstructor(capturedTypeMarker))) || typeSystemContext.captureStatus(capturedTypeMarker) != kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus.FOR_SUBTYPING) {
                return false;
            }
            kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker typeConstructorMarkerTypeConstructor = typeSystemContext.typeConstructor(kotlinTypeMarker2);
            kotlin.reflect.jvm.internal.impl.types.model.TypeVariableTypeConstructorMarker typeVariableTypeConstructorMarker = typeConstructorMarkerTypeConstructor instanceof kotlin.reflect.jvm.internal.impl.types.model.TypeVariableTypeConstructorMarker ? (kotlin.reflect.jvm.internal.impl.types.model.TypeVariableTypeConstructorMarker) typeConstructorMarkerTypeConstructor : null;
            if (typeVariableTypeConstructorMarker != null && (typeParameter = typeSystemContext.getTypeParameter(typeVariableTypeConstructorMarker)) != null && typeSystemContext.hasRecursiveBounds(typeParameter, typeConstructorMarker)) {
                return true;
            }
        }
        return false;
    }

    public final boolean isSubtypeForSameConstructor(kotlin.reflect.jvm.internal.impl.types.TypeCheckerState typeCheckerState, kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentListMarker capturedSubArguments, kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker superType) {
        boolean zEqualTypes;
        kotlin.reflect.jvm.internal.impl.types.TypeCheckerState typeCheckerState2 = typeCheckerState;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeCheckerState2, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(capturedSubArguments, "capturedSubArguments");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(superType, "superType");
        kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext typeSystemContext = typeCheckerState2.getTypeSystemContext();
        kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker typeConstructorMarkerTypeConstructor = typeSystemContext.typeConstructor(superType);
        int size = typeSystemContext.size(capturedSubArguments);
        int iParametersCount = typeSystemContext.parametersCount(typeConstructorMarkerTypeConstructor);
        if (size == iParametersCount) {
            kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarker = superType;
            if (size == typeSystemContext.argumentsCount(rigidTypeMarker)) {
                for (int i = 0; i < iParametersCount; i++) {
                    kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker argument = typeSystemContext.getArgument(rigidTypeMarker, i);
                    kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker type = typeSystemContext.getType(argument);
                    if (type != null) {
                        kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker typeArgumentMarker = typeSystemContext.get(capturedSubArguments, i);
                        typeSystemContext.getVariance(typeArgumentMarker);
                        kotlin.reflect.jvm.internal.impl.types.model.TypeVariance typeVariance = kotlin.reflect.jvm.internal.impl.types.model.TypeVariance.INV;
                        kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker type2 = typeSystemContext.getType(typeArgumentMarker);
                        kotlin.jvm.internal.Intrinsics.checkNotNull(type2);
                        kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker abstractTypeChecker = INSTANCE;
                        kotlin.reflect.jvm.internal.impl.types.model.TypeVariance typeVarianceEffectiveVariance = abstractTypeChecker.effectiveVariance(typeSystemContext.getVariance(typeSystemContext.getParameter(typeConstructorMarkerTypeConstructor, i)), typeSystemContext.getVariance(argument));
                        if (typeVarianceEffectiveVariance == null) {
                            return typeCheckerState2.isErrorTypeEqualsToAnything();
                        }
                        if (typeVarianceEffectiveVariance != kotlin.reflect.jvm.internal.impl.types.model.TypeVariance.INV || (!abstractTypeChecker.isTypeVariableAgainstStarProjectionForSelfType(typeSystemContext, type2, type, typeConstructorMarkerTypeConstructor) && !abstractTypeChecker.isTypeVariableAgainstStarProjectionForSelfType(typeSystemContext, type, type2, typeConstructorMarkerTypeConstructor))) {
                            if (typeCheckerState2.argumentsDepth <= 100) {
                                typeCheckerState2.argumentsDepth++;
                                int i2 = kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker.WhenMappings.$EnumSwitchMapping$0[typeVarianceEffectiveVariance.ordinal()];
                                if (i2 == 1) {
                                    zEqualTypes = abstractTypeChecker.equalTypes(typeCheckerState2, type2, type);
                                } else if (i2 == 2) {
                                    typeCheckerState2 = typeCheckerState;
                                    zEqualTypes = isSubtypeOf$default(abstractTypeChecker, typeCheckerState2, type2, type, false, 8, null);
                                } else {
                                    if (i2 != 3) {
                                        throw new kotlin.NoWhenBranchMatchedException();
                                    }
                                    zEqualTypes = isSubtypeOf$default(abstractTypeChecker, typeCheckerState2, type, type2, false, 8, null);
                                    typeCheckerState2 = typeCheckerState;
                                }
                                typeCheckerState2.argumentsDepth--;
                                if (!zEqualTypes) {
                                    return false;
                                }
                            } else {
                                throw new java.lang.IllegalStateException(("Arguments depth is too high. Some related argument: " + type2).toString());
                            }
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }

    private final boolean isCommonDenotableType(kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext typeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker kotlinTypeMarker) {
        return (!typeSystemContext.isDenotable(typeSystemContext.typeConstructor(kotlinTypeMarker)) || typeSystemContext.isDynamic(kotlinTypeMarker) || typeSystemContext.isDefinitelyNotNullType(kotlinTypeMarker) || typeSystemContext.isNotNullTypeParameter(kotlinTypeMarker) || typeSystemContext.isFlexibleWithDifferentTypeConstructors(kotlinTypeMarker)) ? false : true;
    }

    public final kotlin.reflect.jvm.internal.impl.types.model.TypeVariance effectiveVariance(kotlin.reflect.jvm.internal.impl.types.model.TypeVariance declared, kotlin.reflect.jvm.internal.impl.types.model.TypeVariance useSite) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(declared, "declared");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(useSite, "useSite");
        if (declared == kotlin.reflect.jvm.internal.impl.types.model.TypeVariance.INV) {
            return useSite;
        }
        if (useSite == kotlin.reflect.jvm.internal.impl.types.model.TypeVariance.INV || declared == useSite) {
            return declared;
        }
        return null;
    }

    private final boolean isStubTypeSubtypeOfAnother(kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext typeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarker, kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarker2) {
        if (typeSystemContext.typeConstructor(rigidTypeMarker) != typeSystemContext.typeConstructor(rigidTypeMarker2)) {
            return false;
        }
        if (typeSystemContext.isDefinitelyNotNullType(rigidTypeMarker) || !typeSystemContext.isDefinitelyNotNullType(rigidTypeMarker2)) {
            return !typeSystemContext.isMarkedNullable(rigidTypeMarker) || typeSystemContext.isMarkedNullable(rigidTypeMarker2);
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:79:0x0130  */
    /* JADX WARN: Code duplicated, block: B:81:0x013c  */
    private final java.lang.Boolean checkSubtypeForSpecialCases(kotlin.reflect.jvm.internal.impl.types.TypeCheckerState typeCheckerState, kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarker, kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarker2) {
        kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker typeParameterForArgumentInBaseIfItEqualToTarget;
        kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext typeSystemContext = typeCheckerState.getTypeSystemContext();
        kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarker3 = rigidTypeMarker;
        boolean z = false;
        if (!typeSystemContext.isError(rigidTypeMarker3)) {
            kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarker4 = rigidTypeMarker2;
            if (!typeSystemContext.isError(rigidTypeMarker4)) {
                if (typeSystemContext.isStubTypeForBuilderInference(rigidTypeMarker) && typeSystemContext.isStubTypeForBuilderInference(rigidTypeMarker2)) {
                    return java.lang.Boolean.valueOf(INSTANCE.isStubTypeSubtypeOfAnother(typeSystemContext, rigidTypeMarker, rigidTypeMarker2) || typeCheckerState.isStubTypeEqualsToAnything());
                }
                if (typeSystemContext.isStubType(rigidTypeMarker) || typeSystemContext.isStubType(rigidTypeMarker2)) {
                    return java.lang.Boolean.valueOf(typeCheckerState.isStubTypeEqualsToAnything());
                }
                kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker capturedTypeMarkerAsCapturedTypeUnwrappingDnn = typeSystemContext.asCapturedTypeUnwrappingDnn(rigidTypeMarker2);
                kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker kotlinTypeMarkerLowerType = capturedTypeMarkerAsCapturedTypeUnwrappingDnn != null ? typeSystemContext.lowerType(capturedTypeMarkerAsCapturedTypeUnwrappingDnn) : null;
                if (capturedTypeMarkerAsCapturedTypeUnwrappingDnn != null && kotlinTypeMarkerLowerType != null) {
                    if (typeSystemContext.isMarkedNullable(rigidTypeMarker4)) {
                        kotlinTypeMarkerLowerType = typeSystemContext.withNullability(kotlinTypeMarkerLowerType, true);
                    } else if (typeSystemContext.isDefinitelyNotNullType(rigidTypeMarker2)) {
                        kotlinTypeMarkerLowerType = typeSystemContext.makeDefinitelyNotNullOrNotNull(kotlinTypeMarkerLowerType);
                    }
                    kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker kotlinTypeMarker = kotlinTypeMarkerLowerType;
                    int i = kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker.WhenMappings.$EnumSwitchMapping$1[typeCheckerState.getLowerCapturedTypePolicy(rigidTypeMarker, capturedTypeMarkerAsCapturedTypeUnwrappingDnn).ordinal()];
                    if (i == 1) {
                        return java.lang.Boolean.valueOf(isSubtypeOf$default(INSTANCE, typeCheckerState, rigidTypeMarker3, kotlinTypeMarker, false, 8, null));
                    }
                    if (i != 2) {
                        if (i != 3) {
                            throw new kotlin.NoWhenBranchMatchedException();
                        }
                    } else if (isSubtypeOf$default(INSTANCE, typeCheckerState, rigidTypeMarker3, kotlinTypeMarker, false, 8, null)) {
                        return true;
                    }
                }
                kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker typeConstructorMarkerTypeConstructor = typeSystemContext.typeConstructor(rigidTypeMarker2);
                if (typeSystemContext.isIntersection(typeConstructorMarkerTypeConstructor)) {
                    typeSystemContext.isMarkedNullable(rigidTypeMarker4);
                    java.util.Collection<kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker> collectionSupertypes = typeSystemContext.supertypes(typeConstructorMarkerTypeConstructor);
                    if ((collectionSupertypes instanceof java.util.Collection) && collectionSupertypes.isEmpty()) {
                        z = true;
                    } else {
                        java.util.Iterator<T> it = collectionSupertypes.iterator();
                        while (it.hasNext()) {
                            if (!isSubtypeOf$default(INSTANCE, typeCheckerState, rigidTypeMarker3, (kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) it.next(), false, 8, null)) {
                            }
                        }
                        z = true;
                    }
                    return java.lang.Boolean.valueOf(z);
                }
                kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker typeConstructorMarkerTypeConstructor2 = typeSystemContext.typeConstructor(rigidTypeMarker);
                if (!(rigidTypeMarker instanceof kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker)) {
                    if (typeSystemContext.isIntersection(typeConstructorMarkerTypeConstructor2)) {
                        java.util.Collection<kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker> collectionSupertypes2 = typeSystemContext.supertypes(typeConstructorMarkerTypeConstructor2);
                        if ((collectionSupertypes2 instanceof java.util.Collection) && collectionSupertypes2.isEmpty()) {
                            typeParameterForArgumentInBaseIfItEqualToTarget = INSTANCE.getTypeParameterForArgumentInBaseIfItEqualToTarget(typeCheckerState.getTypeSystemContext(), rigidTypeMarker4, rigidTypeMarker3);
                            if (typeParameterForArgumentInBaseIfItEqualToTarget == null) {
                            }
                        } else {
                            java.util.Iterator<T> it2 = collectionSupertypes2.iterator();
                            while (it2.hasNext()) {
                                if (!(((kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) it2.next()) instanceof kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker)) {
                                }
                            }
                            typeParameterForArgumentInBaseIfItEqualToTarget = INSTANCE.getTypeParameterForArgumentInBaseIfItEqualToTarget(typeCheckerState.getTypeSystemContext(), rigidTypeMarker4, rigidTypeMarker3);
                            if (typeParameterForArgumentInBaseIfItEqualToTarget == null) {
                            }
                        }
                    }
                } else {
                    typeParameterForArgumentInBaseIfItEqualToTarget = INSTANCE.getTypeParameterForArgumentInBaseIfItEqualToTarget(typeCheckerState.getTypeSystemContext(), rigidTypeMarker4, rigidTypeMarker3);
                    if (typeParameterForArgumentInBaseIfItEqualToTarget == null && typeSystemContext.hasRecursiveBounds(typeParameterForArgumentInBaseIfItEqualToTarget, typeSystemContext.typeConstructor(rigidTypeMarker2))) {
                        return true;
                    }
                }
                return null;
            }
        }
        if (typeCheckerState.isErrorTypeEqualsToAnything()) {
            return true;
        }
        if (!typeSystemContext.isMarkedNullable(rigidTypeMarker3) || typeSystemContext.isMarkedNullable(rigidTypeMarker2)) {
            return java.lang.Boolean.valueOf(kotlin.reflect.jvm.internal.impl.types.AbstractStrictEqualityTypeChecker.INSTANCE.strictEqualTypes(typeSystemContext, typeSystemContext.withNullability(rigidTypeMarker, false), typeSystemContext.withNullability(rigidTypeMarker2, false)));
        }
        return false;
    }

    private final kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker getTypeParameterForArgumentInBaseIfItEqualToTarget(kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext typeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker kotlinTypeMarker, kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker kotlinTypeMarker2) {
        kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker type;
        int iArgumentsCount = typeSystemContext.argumentsCount(kotlinTypeMarker);
        int i = 0;
        while (true) {
            if (i >= iArgumentsCount) {
                return null;
            }
            kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker argument = typeSystemContext.getArgument(kotlinTypeMarker, i);
            kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker typeArgumentMarker = typeSystemContext.isStarProjection(argument) ? null : argument;
            if (typeArgumentMarker != null && (type = typeSystemContext.getType(typeArgumentMarker)) != null) {
                boolean z = typeSystemContext.isCapturedType(typeSystemContext.lowerBoundIfFlexible(type)) && typeSystemContext.isCapturedType(typeSystemContext.lowerBoundIfFlexible(kotlinTypeMarker2));
                if (kotlin.jvm.internal.Intrinsics.areEqual(type, kotlinTypeMarker2) || (z && kotlin.jvm.internal.Intrinsics.areEqual(typeSystemContext.typeConstructor(type), typeSystemContext.typeConstructor(kotlinTypeMarker2)))) {
                    return typeSystemContext.getParameter(typeSystemContext.typeConstructor(kotlinTypeMarker), i);
                }
                kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker typeParameterForArgumentInBaseIfItEqualToTarget = getTypeParameterForArgumentInBaseIfItEqualToTarget(typeSystemContext, type, kotlinTypeMarker2);
                if (typeParameterForArgumentInBaseIfItEqualToTarget != null) {
                    return typeParameterForArgumentInBaseIfItEqualToTarget;
                }
            }
            i++;
        }
    }

    private final java.util.List<kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker> collectAllSupertypesWithGivenTypeConstructor(kotlin.reflect.jvm.internal.impl.types.TypeCheckerState typeCheckerState, kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarker, kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker typeConstructorMarker) {
        kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.SupertypesPolicy.LowerIfFlexible lowerIfFlexibleSubstitutionSupertypePolicy;
        kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext typeSystemContext = typeCheckerState.getTypeSystemContext();
        java.util.List<kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker> listFastCorrespondingSupertypes = typeSystemContext.fastCorrespondingSupertypes(rigidTypeMarker, typeConstructorMarker);
        if (listFastCorrespondingSupertypes != null) {
            return listFastCorrespondingSupertypes;
        }
        if (!typeSystemContext.isClassTypeConstructor(typeConstructorMarker) && typeSystemContext.isClassType(rigidTypeMarker)) {
            return kotlin.collections.CollectionsKt.emptyList();
        }
        if (typeSystemContext.isCommonFinalClassConstructor(typeConstructorMarker)) {
            if (typeSystemContext.areEqualTypeConstructors(typeSystemContext.typeConstructor(rigidTypeMarker), typeConstructorMarker)) {
                kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarkerCaptureFromArguments = typeSystemContext.captureFromArguments(rigidTypeMarker, kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus.FOR_SUBTYPING);
                if (rigidTypeMarkerCaptureFromArguments != null) {
                    rigidTypeMarker = rigidTypeMarkerCaptureFromArguments;
                }
                return kotlin.collections.CollectionsKt.listOf(rigidTypeMarker);
            }
            return kotlin.collections.CollectionsKt.emptyList();
        }
        kotlin.reflect.jvm.internal.impl.utils.SmartList smartList = new kotlin.reflect.jvm.internal.impl.utils.SmartList();
        typeCheckerState.initialize();
        java.util.ArrayDeque<kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker> supertypesDeque = typeCheckerState.getSupertypesDeque();
        kotlin.jvm.internal.Intrinsics.checkNotNull(supertypesDeque);
        java.util.Set<kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker> supertypesSet = typeCheckerState.getSupertypesSet();
        kotlin.jvm.internal.Intrinsics.checkNotNull(supertypesSet);
        supertypesDeque.push(rigidTypeMarker);
        while (!supertypesDeque.isEmpty()) {
            kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarkerPop = supertypesDeque.pop();
            kotlin.jvm.internal.Intrinsics.checkNotNull(rigidTypeMarkerPop);
            if (supertypesSet.add(rigidTypeMarkerPop)) {
                kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarkerCaptureFromArguments2 = typeSystemContext.captureFromArguments(rigidTypeMarkerPop, kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus.FOR_SUBTYPING);
                if (rigidTypeMarkerCaptureFromArguments2 == null) {
                    rigidTypeMarkerCaptureFromArguments2 = rigidTypeMarkerPop;
                }
                if (typeSystemContext.areEqualTypeConstructors(typeSystemContext.typeConstructor(rigidTypeMarkerCaptureFromArguments2), typeConstructorMarker)) {
                    smartList.add(rigidTypeMarkerCaptureFromArguments2);
                    lowerIfFlexibleSubstitutionSupertypePolicy = kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.SupertypesPolicy.None.INSTANCE;
                } else if (typeSystemContext.argumentsCount(rigidTypeMarkerCaptureFromArguments2) == 0) {
                    lowerIfFlexibleSubstitutionSupertypePolicy = kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.SupertypesPolicy.LowerIfFlexible.INSTANCE;
                } else {
                    lowerIfFlexibleSubstitutionSupertypePolicy = typeCheckerState.getTypeSystemContext().substitutionSupertypePolicy(rigidTypeMarkerCaptureFromArguments2);
                }
                if (kotlin.jvm.internal.Intrinsics.areEqual(lowerIfFlexibleSubstitutionSupertypePolicy, kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.SupertypesPolicy.None.INSTANCE)) {
                    lowerIfFlexibleSubstitutionSupertypePolicy = null;
                }
                if (lowerIfFlexibleSubstitutionSupertypePolicy != null) {
                    kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext typeSystemContext2 = typeCheckerState.getTypeSystemContext();
                    java.util.Iterator<kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker> it = typeSystemContext2.supertypes(typeSystemContext2.typeConstructor(rigidTypeMarkerPop)).iterator();
                    while (it.hasNext()) {
                        supertypesDeque.add(lowerIfFlexibleSubstitutionSupertypePolicy.mo1839transformType(typeCheckerState, it.next()));
                    }
                }
            }
        }
        typeCheckerState.clear();
        return smartList;
    }

    private final java.util.List<kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker> collectAndFilter(kotlin.reflect.jvm.internal.impl.types.TypeCheckerState typeCheckerState, kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarker, kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker typeConstructorMarker) {
        return selectOnlyPureKotlinSupertypes(typeCheckerState, collectAllSupertypesWithGivenTypeConstructor(typeCheckerState, rigidTypeMarker, typeConstructorMarker));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final java.util.List<kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker> selectOnlyPureKotlinSupertypes(kotlin.reflect.jvm.internal.impl.types.TypeCheckerState typeCheckerState, java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker> list) {
        kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext typeSystemContext = typeCheckerState.getTypeSystemContext();
        if (list.size() >= 2) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            for (java.lang.Object obj : list) {
                kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentListMarker typeArgumentListMarkerAsArgumentList = typeSystemContext.asArgumentList((kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker) obj);
                int size = typeSystemContext.size(typeArgumentListMarkerAsArgumentList);
                int i = 0;
                while (true) {
                    if (i < size) {
                        kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker type = typeSystemContext.getType(typeSystemContext.get(typeArgumentListMarkerAsArgumentList, i));
                        if ((type != null ? typeSystemContext.asFlexibleType(type) : null) != null) {
                            break;
                        }
                        i++;
                    } else {
                        arrayList.add(obj);
                        break;
                    }
                }
            }
            java.util.ArrayList arrayList2 = arrayList;
            if (!arrayList2.isEmpty()) {
                return arrayList2;
            }
        }
        return list;
    }

    public final java.util.List<kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker> findCorrespondingSupertypes(kotlin.reflect.jvm.internal.impl.types.TypeCheckerState state, kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker subType, kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker superConstructor) {
        kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.SupertypesPolicy.LowerIfFlexible lowerIfFlexible;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(state, "state");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(subType, "subType");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(superConstructor, "superConstructor");
        kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext typeSystemContext = state.getTypeSystemContext();
        if (typeSystemContext.isClassType(subType)) {
            return INSTANCE.collectAndFilter(state, subType, superConstructor);
        }
        if (!typeSystemContext.isClassTypeConstructor(superConstructor) && !typeSystemContext.isIntegerLiteralTypeConstructor(superConstructor)) {
            return INSTANCE.collectAllSupertypesWithGivenTypeConstructor(state, subType, superConstructor);
        }
        kotlin.reflect.jvm.internal.impl.utils.SmartList<kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker> smartList = new kotlin.reflect.jvm.internal.impl.utils.SmartList();
        state.initialize();
        java.util.ArrayDeque<kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker> supertypesDeque = state.getSupertypesDeque();
        kotlin.jvm.internal.Intrinsics.checkNotNull(supertypesDeque);
        java.util.Set<kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker> supertypesSet = state.getSupertypesSet();
        kotlin.jvm.internal.Intrinsics.checkNotNull(supertypesSet);
        supertypesDeque.push(subType);
        while (!supertypesDeque.isEmpty()) {
            kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarkerPop = supertypesDeque.pop();
            kotlin.jvm.internal.Intrinsics.checkNotNull(rigidTypeMarkerPop);
            if (supertypesSet.add(rigidTypeMarkerPop)) {
                if (typeSystemContext.isClassType(rigidTypeMarkerPop)) {
                    smartList.add(rigidTypeMarkerPop);
                    lowerIfFlexible = kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.SupertypesPolicy.None.INSTANCE;
                } else {
                    lowerIfFlexible = kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.SupertypesPolicy.LowerIfFlexible.INSTANCE;
                }
                if (kotlin.jvm.internal.Intrinsics.areEqual(lowerIfFlexible, kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.SupertypesPolicy.None.INSTANCE)) {
                    lowerIfFlexible = null;
                }
                if (lowerIfFlexible != null) {
                    kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext typeSystemContext2 = state.getTypeSystemContext();
                    java.util.Iterator<kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker> it = typeSystemContext2.supertypes(typeSystemContext2.typeConstructor(rigidTypeMarkerPop)).iterator();
                    while (it.hasNext()) {
                        supertypesDeque.add(lowerIfFlexible.mo1839transformType(state, it.next()));
                    }
                }
            }
        }
        state.clear();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarker : smartList) {
            kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker abstractTypeChecker = INSTANCE;
            kotlin.jvm.internal.Intrinsics.checkNotNull(rigidTypeMarker);
            kotlin.collections.CollectionsKt.addAll(arrayList, abstractTypeChecker.collectAndFilter(state, rigidTypeMarker, superConstructor));
        }
        return arrayList;
    }
}
