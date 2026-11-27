package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

/* JADX INFO: compiled from: typeEnhancementUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TypeEnhancementUtilsKt {
    private static final <T> T select(java.util.Set<? extends T> set, T t, T t2, T t3, boolean z) {
        java.util.Set<? extends T> set2;
        T t4;
        if (z) {
            if (set.contains(t)) {
                t4 = t;
            } else {
                t4 = set.contains(t2) ? t2 : null;
            }
            if (kotlin.jvm.internal.Intrinsics.areEqual(t4, t) && kotlin.jvm.internal.Intrinsics.areEqual(t3, t2)) {
                return null;
            }
            return t3 == null ? t4 : t3;
        }
        if (t3 != null && (set2 = kotlin.collections.CollectionsKt.toSet(kotlin.collections.SetsKt.plus(set, t3))) != null) {
            set = set2;
        }
        return (T) kotlin.collections.CollectionsKt.singleOrNull(set);
    }

    private static final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier select(java.util.Set<? extends kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier> set, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier nullabilityQualifier, boolean z) {
        if (nullabilityQualifier == kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.FORCE_FLEXIBILITY) {
            return kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.FORCE_FLEXIBILITY;
        }
        return (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier) select(set, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NOT_NULL, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NULLABLE, nullabilityQualifier, z);
    }

    private static final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier getNullabilityForErrors(kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers javaTypeQualifiers) {
        if (javaTypeQualifiers.isNullabilityQualifierForWarning()) {
            return null;
        }
        return javaTypeQualifiers.getNullability();
    }

    /* JADX WARN: Code duplicated, block: B:49:0x00e9  */
    public static final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers computeQualifiersForOverride(kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers javaTypeQualifiers, java.util.Collection<kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers> superQualifiers, boolean z, boolean z2, boolean z3) {
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier nullabilityQualifierSelect;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(javaTypeQualifiers, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(superQualifiers, "superQualifiers");
        java.util.Collection<kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers> collection = superQualifiers;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier nullabilityForErrors = getNullabilityForErrors((kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers) it.next());
            if (nullabilityForErrors != null) {
                arrayList.add(nullabilityForErrors);
            }
        }
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier nullabilityQualifierSelect2 = select(kotlin.collections.CollectionsKt.toSet(arrayList), getNullabilityForErrors(javaTypeQualifiers), z);
        if (nullabilityQualifierSelect2 == null) {
            java.util.ArrayList arrayList2 = new java.util.ArrayList();
            java.util.Iterator<T> it2 = collection.iterator();
            while (it2.hasNext()) {
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier nullability = ((kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers) it2.next()).getNullability();
                if (nullability != null) {
                    arrayList2.add(nullability);
                }
            }
            nullabilityQualifierSelect = select(kotlin.collections.CollectionsKt.toSet(arrayList2), javaTypeQualifiers.getNullability(), z);
        } else {
            nullabilityQualifierSelect = nullabilityQualifierSelect2;
        }
        java.util.ArrayList arrayList3 = new java.util.ArrayList();
        java.util.Iterator<T> it3 = collection.iterator();
        while (it3.hasNext()) {
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier mutability = ((kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers) it3.next()).getMutability();
            if (mutability != null) {
                arrayList3.add(mutability);
            }
        }
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier mutabilityQualifier = (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier) select(kotlin.collections.CollectionsKt.toSet(arrayList3), kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier.MUTABLE, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier.READ_ONLY, javaTypeQualifiers.getMutability(), z);
        if (nullabilityQualifierSelect == null || z3 || (z2 && nullabilityQualifierSelect == kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NULLABLE)) {
            nullabilityQualifierSelect = null;
        }
        boolean z4 = true;
        boolean z5 = nullabilityQualifierSelect != null && nullabilityQualifierSelect2 == null;
        if (nullabilityQualifierSelect != kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NOT_NULL) {
            z4 = false;
        } else if (!isDefinitelyNotNullAndSameSeverity(javaTypeQualifiers, z5)) {
            if (collection.isEmpty()) {
                z4 = false;
            } else {
                java.util.Iterator<T> it4 = collection.iterator();
                while (it4.hasNext()) {
                    if (isDefinitelyNotNullAndSameSeverity((kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers) it4.next(), z5)) {
                    }
                }
                z4 = false;
            }
        }
        return new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers(nullabilityQualifierSelect, mutabilityQualifier, z4, z5);
    }

    private static final boolean isDefinitelyNotNullAndSameSeverity(kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers javaTypeQualifiers, boolean z) {
        return javaTypeQualifiers.isNullabilityQualifierForWarning() == z && javaTypeQualifiers.getDefinitelyNotNull();
    }

    public static final boolean hasEnhancedNullability(kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext typeSystemCommonBackendContext, kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker type) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeSystemCommonBackendContext, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(type, "type");
        kotlin.reflect.jvm.internal.impl.name.FqName ENHANCED_NULLABILITY_ANNOTATION = kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames.ENHANCED_NULLABILITY_ANNOTATION;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(ENHANCED_NULLABILITY_ANNOTATION, "ENHANCED_NULLABILITY_ANNOTATION");
        return typeSystemCommonBackendContext.hasAnnotation(type, ENHANCED_NULLABILITY_ANNOTATION);
    }
}
