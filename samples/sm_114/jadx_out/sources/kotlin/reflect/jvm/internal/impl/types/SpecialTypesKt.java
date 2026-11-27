package kotlin.reflect.jvm.internal.impl.types;

/* JADX INFO: compiled from: SpecialTypes.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SpecialTypesKt {
    public static final kotlin.reflect.jvm.internal.impl.types.AbbreviatedType getAbbreviatedType(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        kotlin.reflect.jvm.internal.impl.types.UnwrappedType unwrappedTypeUnwrap = kotlinType.unwrap();
        if (unwrappedTypeUnwrap instanceof kotlin.reflect.jvm.internal.impl.types.AbbreviatedType) {
            return (kotlin.reflect.jvm.internal.impl.types.AbbreviatedType) unwrappedTypeUnwrap;
        }
        return null;
    }

    public static final kotlin.reflect.jvm.internal.impl.types.SimpleType getAbbreviation(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        kotlin.reflect.jvm.internal.impl.types.AbbreviatedType abbreviatedType = getAbbreviatedType(kotlinType);
        if (abbreviatedType != null) {
            return abbreviatedType.getAbbreviation();
        }
        return null;
    }

    public static final kotlin.reflect.jvm.internal.impl.types.SimpleType withAbbreviation(kotlin.reflect.jvm.internal.impl.types.SimpleType simpleType, kotlin.reflect.jvm.internal.impl.types.SimpleType abbreviatedType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(simpleType, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(abbreviatedType, "abbreviatedType");
        return kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt.isError(simpleType) ? simpleType : new kotlin.reflect.jvm.internal.impl.types.AbbreviatedType(simpleType, abbreviatedType);
    }

    public static final boolean isDefinitelyNotNullType(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        return kotlinType.unwrap() instanceof kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType;
    }

    public static /* synthetic */ kotlin.reflect.jvm.internal.impl.types.SimpleType makeSimpleTypeDefinitelyNotNullOrNotNull$default(kotlin.reflect.jvm.internal.impl.types.SimpleType simpleType, boolean z, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return makeSimpleTypeDefinitelyNotNullOrNotNull(simpleType, z);
    }

    public static final kotlin.reflect.jvm.internal.impl.types.SimpleType makeSimpleTypeDefinitelyNotNullOrNotNull(kotlin.reflect.jvm.internal.impl.types.SimpleType simpleType, boolean z) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(simpleType, "<this>");
        kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType definitelyNotNullTypeMakeDefinitelyNotNull$default = kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType.Companion.makeDefinitelyNotNull$default(kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType.Companion, simpleType, z, false, 4, null);
        if (definitelyNotNullTypeMakeDefinitelyNotNull$default != null) {
            return definitelyNotNullTypeMakeDefinitelyNotNull$default;
        }
        kotlin.reflect.jvm.internal.impl.types.SimpleType simpleTypeMakeIntersectionTypeDefinitelyNotNullOrNotNull = makeIntersectionTypeDefinitelyNotNullOrNotNull(simpleType);
        return simpleTypeMakeIntersectionTypeDefinitelyNotNullOrNotNull == null ? simpleType.makeNullableAsSpecified(false) : simpleTypeMakeIntersectionTypeDefinitelyNotNullOrNotNull;
    }

    public static final kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedType withNotNullProjection(kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedType newCapturedType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(newCapturedType, "<this>");
        return new kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedType(newCapturedType.getCaptureStatus(), newCapturedType.getConstructor(), newCapturedType.getLowerType(), newCapturedType.getAttributes(), newCapturedType.isMarkedNullable(), true);
    }

    public static /* synthetic */ kotlin.reflect.jvm.internal.impl.types.UnwrappedType makeDefinitelyNotNullOrNotNull$default(kotlin.reflect.jvm.internal.impl.types.UnwrappedType unwrappedType, boolean z, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return makeDefinitelyNotNullOrNotNull(unwrappedType, z);
    }

    public static final kotlin.reflect.jvm.internal.impl.types.UnwrappedType makeDefinitelyNotNullOrNotNull(kotlin.reflect.jvm.internal.impl.types.UnwrappedType unwrappedType, boolean z) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(unwrappedType, "<this>");
        kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType definitelyNotNullTypeMakeDefinitelyNotNull$default = kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType.Companion.makeDefinitelyNotNull$default(kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType.Companion, unwrappedType, z, false, 4, null);
        if (definitelyNotNullTypeMakeDefinitelyNotNull$default != null) {
            return definitelyNotNullTypeMakeDefinitelyNotNull$default;
        }
        kotlin.reflect.jvm.internal.impl.types.SimpleType simpleTypeMakeIntersectionTypeDefinitelyNotNullOrNotNull = makeIntersectionTypeDefinitelyNotNullOrNotNull(unwrappedType);
        if (simpleTypeMakeIntersectionTypeDefinitelyNotNullOrNotNull != null) {
            return simpleTypeMakeIntersectionTypeDefinitelyNotNullOrNotNull;
        }
        return unwrappedType.makeNullableAsSpecified(false);
    }

    private static final kotlin.reflect.jvm.internal.impl.types.SimpleType makeIntersectionTypeDefinitelyNotNullOrNotNull(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor intersectionTypeConstructorMakeDefinitelyNotNullOrNotNull;
        kotlin.reflect.jvm.internal.impl.types.TypeConstructor constructor = kotlinType.getConstructor();
        kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor intersectionTypeConstructor = constructor instanceof kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor ? (kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor) constructor : null;
        if (intersectionTypeConstructor == null || (intersectionTypeConstructorMakeDefinitelyNotNullOrNotNull = makeDefinitelyNotNullOrNotNull(intersectionTypeConstructor)) == null) {
            return null;
        }
        return intersectionTypeConstructorMakeDefinitelyNotNullOrNotNull.createType();
    }

    private static final kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor makeDefinitelyNotNullOrNotNull(kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor intersectionTypeConstructor) {
        kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType;
        java.util.Collection<kotlin.reflect.jvm.internal.impl.types.KotlinType> collectionMo1836getSupertypes = intersectionTypeConstructor.mo1836getSupertypes();
        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(collectionMo1836getSupertypes, 10));
        java.util.Iterator<T> it = collectionMo1836getSupertypes.iterator();
        boolean z = false;
        while (true) {
            kotlinType = null;
            if (!it.hasNext()) {
                break;
            }
            kotlin.reflect.jvm.internal.impl.types.UnwrappedType unwrappedTypeMakeDefinitelyNotNullOrNotNull$default = (kotlin.reflect.jvm.internal.impl.types.KotlinType) it.next();
            if (kotlin.reflect.jvm.internal.impl.types.TypeUtils.isNullableType(unwrappedTypeMakeDefinitelyNotNullOrNotNull$default)) {
                unwrappedTypeMakeDefinitelyNotNullOrNotNull$default = makeDefinitelyNotNullOrNotNull$default(unwrappedTypeMakeDefinitelyNotNullOrNotNull$default.unwrap(), false, 1, null);
                z = true;
            }
            arrayList.add(unwrappedTypeMakeDefinitelyNotNullOrNotNull$default);
        }
        java.util.ArrayList arrayList2 = arrayList;
        if (!z) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.types.UnwrappedType alternativeType = intersectionTypeConstructor.getAlternativeType();
        if (alternativeType != null) {
            if (kotlin.reflect.jvm.internal.impl.types.TypeUtils.isNullableType(alternativeType)) {
                alternativeType = makeDefinitelyNotNullOrNotNull$default(alternativeType.unwrap(), false, 1, null);
            }
            kotlinType = alternativeType;
        }
        return new kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor(arrayList2).setAlternative(kotlinType);
    }
}
