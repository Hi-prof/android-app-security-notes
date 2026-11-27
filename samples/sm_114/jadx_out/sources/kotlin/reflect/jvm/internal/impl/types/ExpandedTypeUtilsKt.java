package kotlin.reflect.jvm.internal.impl.types;

/* JADX INFO: compiled from: expandedTypeUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ExpandedTypeUtilsKt {
    public static final kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker computeExpandedTypeForInlineClass(kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext typeSystemCommonBackendContext, kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker inlineClassType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeSystemCommonBackendContext, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(inlineClassType, "inlineClassType");
        return computeExpandedTypeInner(typeSystemCommonBackendContext, inlineClassType, new java.util.HashSet());
    }

    private static final kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker computeExpandedTypeInner(kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext typeSystemCommonBackendContext, kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker kotlinTypeMarker, java.util.HashSet<kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker> hashSet) {
        kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker kotlinTypeMarkerComputeExpandedTypeInner;
        kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker typeConstructorMarkerTypeConstructor = typeSystemCommonBackendContext.typeConstructor(kotlinTypeMarker);
        if (!hashSet.add(typeConstructorMarkerTypeConstructor)) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker typeParameterClassifier = typeSystemCommonBackendContext.getTypeParameterClassifier(typeConstructorMarkerTypeConstructor);
        if (typeParameterClassifier != null) {
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker representativeUpperBound = typeSystemCommonBackendContext.getRepresentativeUpperBound(typeParameterClassifier);
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker kotlinTypeMarkerComputeExpandedTypeInner2 = computeExpandedTypeInner(typeSystemCommonBackendContext, representativeUpperBound, hashSet);
            if (kotlinTypeMarkerComputeExpandedTypeInner2 == null) {
                return null;
            }
            boolean z = typeSystemCommonBackendContext.isInlineClass(typeSystemCommonBackendContext.typeConstructor(representativeUpperBound)) || ((representativeUpperBound instanceof kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker) && typeSystemCommonBackendContext.isPrimitiveType((kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker) representativeUpperBound));
            if ((kotlinTypeMarkerComputeExpandedTypeInner2 instanceof kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker) && typeSystemCommonBackendContext.isPrimitiveType((kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker) kotlinTypeMarkerComputeExpandedTypeInner2) && typeSystemCommonBackendContext.isNullableType(kotlinTypeMarker) && z) {
                return typeSystemCommonBackendContext.makeNullable(representativeUpperBound);
            }
            return (typeSystemCommonBackendContext.isNullableType(kotlinTypeMarkerComputeExpandedTypeInner2) || !typeSystemCommonBackendContext.isMarkedNullable(kotlinTypeMarker)) ? kotlinTypeMarkerComputeExpandedTypeInner2 : typeSystemCommonBackendContext.makeNullable(kotlinTypeMarkerComputeExpandedTypeInner2);
        }
        if (typeSystemCommonBackendContext.isInlineClass(typeConstructorMarkerTypeConstructor)) {
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker unsubstitutedUnderlyingType = typeSystemCommonBackendContext.getUnsubstitutedUnderlyingType(kotlinTypeMarker);
            if (unsubstitutedUnderlyingType == null || (kotlinTypeMarkerComputeExpandedTypeInner = computeExpandedTypeInner(typeSystemCommonBackendContext, unsubstitutedUnderlyingType, hashSet)) == null) {
                return null;
            }
            if (!typeSystemCommonBackendContext.isNullableType(kotlinTypeMarker)) {
                return kotlinTypeMarkerComputeExpandedTypeInner;
            }
            if (!typeSystemCommonBackendContext.isNullableType(kotlinTypeMarkerComputeExpandedTypeInner) && (!(kotlinTypeMarkerComputeExpandedTypeInner instanceof kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker) || !typeSystemCommonBackendContext.isPrimitiveType((kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker) kotlinTypeMarkerComputeExpandedTypeInner))) {
                return typeSystemCommonBackendContext.makeNullable(kotlinTypeMarkerComputeExpandedTypeInner);
            }
        }
        return kotlinTypeMarker;
    }
}
