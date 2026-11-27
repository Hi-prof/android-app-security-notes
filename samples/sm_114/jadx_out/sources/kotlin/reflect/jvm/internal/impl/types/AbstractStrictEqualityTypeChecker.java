package kotlin.reflect.jvm.internal.impl.types;

/* JADX INFO: compiled from: AbstractStrictEqualityTypeChecker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AbstractStrictEqualityTypeChecker {
    public static final kotlin.reflect.jvm.internal.impl.types.AbstractStrictEqualityTypeChecker INSTANCE = new kotlin.reflect.jvm.internal.impl.types.AbstractStrictEqualityTypeChecker();

    private AbstractStrictEqualityTypeChecker() {
    }

    public final boolean strictEqualTypes(kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext context, kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker a, kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker b) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(a, "a");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(b, "b");
        return strictEqualTypesInternal(context, a, b);
    }

    private final boolean strictEqualTypesInternal(kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext typeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker kotlinTypeMarker, kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker kotlinTypeMarker2) {
        if (kotlinTypeMarker == kotlinTypeMarker2) {
            return true;
        }
        kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarkerAsRigidType = typeSystemContext.asRigidType(kotlinTypeMarker);
        kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarkerAsRigidType2 = typeSystemContext.asRigidType(kotlinTypeMarker2);
        if (rigidTypeMarkerAsRigidType != null && rigidTypeMarkerAsRigidType2 != null) {
            return strictEqualRigidTypes(typeSystemContext, rigidTypeMarkerAsRigidType, rigidTypeMarkerAsRigidType2);
        }
        kotlin.reflect.jvm.internal.impl.types.model.FlexibleTypeMarker flexibleTypeMarkerAsFlexibleType = typeSystemContext.asFlexibleType(kotlinTypeMarker);
        kotlin.reflect.jvm.internal.impl.types.model.FlexibleTypeMarker flexibleTypeMarkerAsFlexibleType2 = typeSystemContext.asFlexibleType(kotlinTypeMarker2);
        return flexibleTypeMarkerAsFlexibleType != null && flexibleTypeMarkerAsFlexibleType2 != null && strictEqualRigidTypes(typeSystemContext, typeSystemContext.lowerBound(flexibleTypeMarkerAsFlexibleType), typeSystemContext.lowerBound(flexibleTypeMarkerAsFlexibleType2)) && strictEqualRigidTypes(typeSystemContext, typeSystemContext.upperBound(flexibleTypeMarkerAsFlexibleType), typeSystemContext.upperBound(flexibleTypeMarkerAsFlexibleType2));
    }

    private final boolean strictEqualRigidTypes(kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext typeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarker, kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarker2) {
        kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarker3 = rigidTypeMarker;
        kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarker4 = rigidTypeMarker2;
        if (typeSystemContext.argumentsCount(rigidTypeMarker3) != typeSystemContext.argumentsCount(rigidTypeMarker4) || typeSystemContext.isMarkedNullable(rigidTypeMarker3) != typeSystemContext.isMarkedNullable(rigidTypeMarker4) || typeSystemContext.isDefinitelyNotNullType(rigidTypeMarker) != typeSystemContext.isDefinitelyNotNullType(rigidTypeMarker2) || !typeSystemContext.areEqualTypeConstructors(typeSystemContext.typeConstructor(rigidTypeMarker), typeSystemContext.typeConstructor(rigidTypeMarker2))) {
            return false;
        }
        if (typeSystemContext.identicalArguments(rigidTypeMarker, rigidTypeMarker2)) {
            return true;
        }
        int iArgumentsCount = typeSystemContext.argumentsCount(rigidTypeMarker3);
        for (int i = 0; i < iArgumentsCount; i++) {
            kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker argument = typeSystemContext.getArgument(rigidTypeMarker3, i);
            kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker argument2 = typeSystemContext.getArgument(rigidTypeMarker4, i);
            if (typeSystemContext.isStarProjection(argument) != typeSystemContext.isStarProjection(argument2)) {
                return false;
            }
            if (!typeSystemContext.isStarProjection(argument)) {
                if (typeSystemContext.getVariance(argument) != typeSystemContext.getVariance(argument2)) {
                    return false;
                }
                kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker type = typeSystemContext.getType(argument);
                kotlin.jvm.internal.Intrinsics.checkNotNull(type);
                kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker type2 = typeSystemContext.getType(argument2);
                kotlin.jvm.internal.Intrinsics.checkNotNull(type2);
                if (!strictEqualTypesInternal(typeSystemContext, type, type2)) {
                    return false;
                }
            }
        }
        return true;
    }
}
