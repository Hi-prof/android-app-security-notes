package kotlin.reflect.jvm.internal.impl.types;

/* JADX INFO: compiled from: AbstractTypeChecker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AbstractNullabilityChecker {
    public static final kotlin.reflect.jvm.internal.impl.types.AbstractNullabilityChecker INSTANCE = new kotlin.reflect.jvm.internal.impl.types.AbstractNullabilityChecker();

    private AbstractNullabilityChecker() {
    }

    public final boolean isPossibleSubtype(kotlin.reflect.jvm.internal.impl.types.TypeCheckerState state, kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker subType, kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker superType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(state, "state");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(subType, "subType");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(superType, "superType");
        return runIsPossibleSubtype(state, subType, superType);
    }

    private final boolean runIsPossibleSubtype(kotlin.reflect.jvm.internal.impl.types.TypeCheckerState typeCheckerState, kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarker, kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarker2) {
        kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext typeSystemContext = typeCheckerState.getTypeSystemContext();
        if (kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker.RUN_SLOW_ASSERTIONS) {
            if (!typeSystemContext.isSingleClassifierType(rigidTypeMarker) && !typeSystemContext.isIntersection(typeSystemContext.typeConstructor(rigidTypeMarker))) {
                typeCheckerState.isAllowedTypeVariable(rigidTypeMarker);
            }
            if (!typeSystemContext.isSingleClassifierType(rigidTypeMarker2)) {
                typeCheckerState.isAllowedTypeVariable(rigidTypeMarker2);
            }
        }
        if (typeSystemContext.isMarkedNullable(rigidTypeMarker2) || typeSystemContext.isDefinitelyNotNullType(rigidTypeMarker) || typeSystemContext.isNotNullTypeParameter(rigidTypeMarker)) {
            return true;
        }
        if ((rigidTypeMarker instanceof kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker) && typeSystemContext.isProjectionNotNull((kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker) rigidTypeMarker)) {
            return true;
        }
        kotlin.reflect.jvm.internal.impl.types.AbstractNullabilityChecker abstractNullabilityChecker = INSTANCE;
        if (abstractNullabilityChecker.hasNotNullSupertype(typeCheckerState, rigidTypeMarker, kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.SupertypesPolicy.LowerIfFlexible.INSTANCE)) {
            return true;
        }
        if (typeSystemContext.isDefinitelyNotNullType(rigidTypeMarker2) || abstractNullabilityChecker.hasNotNullSupertype(typeCheckerState, rigidTypeMarker2, kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.SupertypesPolicy.UpperIfFlexible.INSTANCE) || typeSystemContext.isClassType(rigidTypeMarker)) {
            return false;
        }
        return abstractNullabilityChecker.hasPathByNotMarkedNullableNodes(typeCheckerState, rigidTypeMarker, typeSystemContext.typeConstructor(rigidTypeMarker2));
    }

    public final boolean hasNotNullSupertype(kotlin.reflect.jvm.internal.impl.types.TypeCheckerState typeCheckerState, kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker type, kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.SupertypesPolicy supertypesPolicy) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeCheckerState, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(type, "type");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(supertypesPolicy, "supertypesPolicy");
        kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext typeSystemContext = typeCheckerState.getTypeSystemContext();
        if ((typeSystemContext.isClassType(type) && !typeSystemContext.isMarkedNullable(type)) || typeSystemContext.isDefinitelyNotNullType(type)) {
            return true;
        }
        typeCheckerState.initialize();
        java.util.ArrayDeque<kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker> supertypesDeque = typeCheckerState.getSupertypesDeque();
        kotlin.jvm.internal.Intrinsics.checkNotNull(supertypesDeque);
        java.util.Set<kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker> supertypesSet = typeCheckerState.getSupertypesSet();
        kotlin.jvm.internal.Intrinsics.checkNotNull(supertypesSet);
        supertypesDeque.push(type);
        while (!supertypesDeque.isEmpty()) {
            kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarkerPop = supertypesDeque.pop();
            kotlin.jvm.internal.Intrinsics.checkNotNull(rigidTypeMarkerPop);
            if (supertypesSet.add(rigidTypeMarkerPop)) {
                kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.SupertypesPolicy.None none = typeSystemContext.isMarkedNullable(rigidTypeMarkerPop) ? kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.SupertypesPolicy.None.INSTANCE : supertypesPolicy;
                if (kotlin.jvm.internal.Intrinsics.areEqual(none, kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.SupertypesPolicy.None.INSTANCE)) {
                    none = null;
                }
                if (none == null) {
                    continue;
                } else {
                    kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext typeSystemContext2 = typeCheckerState.getTypeSystemContext();
                    java.util.Iterator<kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker> it = typeSystemContext2.supertypes(typeSystemContext2.typeConstructor(rigidTypeMarkerPop)).iterator();
                    while (it.hasNext()) {
                        kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarkerMo1839transformType = none.mo1839transformType(typeCheckerState, it.next());
                        if ((typeSystemContext.isClassType(rigidTypeMarkerMo1839transformType) && !typeSystemContext.isMarkedNullable(rigidTypeMarkerMo1839transformType)) || typeSystemContext.isDefinitelyNotNullType(rigidTypeMarkerMo1839transformType)) {
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

    public final boolean hasPathByNotMarkedNullableNodes(kotlin.reflect.jvm.internal.impl.types.TypeCheckerState state, kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker start, kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker end) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(state, "state");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(start, "start");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(end, "end");
        kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext typeSystemContext = state.getTypeSystemContext();
        if (INSTANCE.isApplicableAsEndNode(state, start, end)) {
            return true;
        }
        state.initialize();
        java.util.ArrayDeque<kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker> supertypesDeque = state.getSupertypesDeque();
        kotlin.jvm.internal.Intrinsics.checkNotNull(supertypesDeque);
        java.util.Set<kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker> supertypesSet = state.getSupertypesSet();
        kotlin.jvm.internal.Intrinsics.checkNotNull(supertypesSet);
        supertypesDeque.push(start);
        while (!supertypesDeque.isEmpty()) {
            kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarkerPop = supertypesDeque.pop();
            kotlin.jvm.internal.Intrinsics.checkNotNull(rigidTypeMarkerPop);
            if (supertypesSet.add(rigidTypeMarkerPop)) {
                kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.SupertypesPolicy supertypesPolicy = typeSystemContext.isMarkedNullable(rigidTypeMarkerPop) ? kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.SupertypesPolicy.None.INSTANCE : kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.SupertypesPolicy.LowerIfFlexible.INSTANCE;
                if (kotlin.jvm.internal.Intrinsics.areEqual(supertypesPolicy, kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.SupertypesPolicy.None.INSTANCE)) {
                    supertypesPolicy = null;
                }
                if (supertypesPolicy == null) {
                    continue;
                } else {
                    kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext typeSystemContext2 = state.getTypeSystemContext();
                    java.util.Iterator<kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker> it = typeSystemContext2.supertypes(typeSystemContext2.typeConstructor(rigidTypeMarkerPop)).iterator();
                    while (it.hasNext()) {
                        kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarkerMo1839transformType = supertypesPolicy.mo1839transformType(state, it.next());
                        if (INSTANCE.isApplicableAsEndNode(state, rigidTypeMarkerMo1839transformType, end)) {
                            state.clear();
                            return true;
                        }
                        supertypesDeque.add(rigidTypeMarkerMo1839transformType);
                    }
                }
            }
        }
        state.clear();
        return false;
    }

    private final boolean isApplicableAsEndNode(kotlin.reflect.jvm.internal.impl.types.TypeCheckerState typeCheckerState, kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarker, kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker typeConstructorMarker) {
        kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext typeSystemContext = typeCheckerState.getTypeSystemContext();
        kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarker2 = rigidTypeMarker;
        if (typeSystemContext.isNothing(rigidTypeMarker2)) {
            return true;
        }
        if (typeSystemContext.isMarkedNullable(rigidTypeMarker2)) {
            return false;
        }
        if (typeCheckerState.isStubTypeEqualsToAnything() && typeSystemContext.isStubType(rigidTypeMarker)) {
            return true;
        }
        return typeSystemContext.areEqualTypeConstructors(typeSystemContext.typeConstructor(rigidTypeMarker), typeConstructorMarker);
    }
}
