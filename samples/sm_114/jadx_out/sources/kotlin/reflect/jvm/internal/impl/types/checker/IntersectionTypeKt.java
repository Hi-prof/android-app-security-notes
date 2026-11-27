package kotlin.reflect.jvm.internal.impl.types.checker;

/* JADX INFO: compiled from: IntersectionType.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class IntersectionTypeKt {
    public static final kotlin.reflect.jvm.internal.impl.types.UnwrappedType intersectTypes(java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.types.UnwrappedType> types) {
        kotlin.reflect.jvm.internal.impl.types.SimpleType lowerBound;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(types, "types");
        int size = types.size();
        if (size == 0) {
            throw new java.lang.IllegalStateException("Expected some types".toString());
        }
        if (size == 1) {
            return (kotlin.reflect.jvm.internal.impl.types.UnwrappedType) kotlin.collections.CollectionsKt.single(types);
        }
        java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.types.UnwrappedType> collection = types;
        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(collection, 10));
        boolean z = false;
        boolean z2 = false;
        for (kotlin.reflect.jvm.internal.impl.types.UnwrappedType unwrappedType : collection) {
            z = z || kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt.isError(unwrappedType);
            if (unwrappedType instanceof kotlin.reflect.jvm.internal.impl.types.SimpleType) {
                lowerBound = (kotlin.reflect.jvm.internal.impl.types.SimpleType) unwrappedType;
            } else {
                if (!(unwrappedType instanceof kotlin.reflect.jvm.internal.impl.types.FlexibleType)) {
                    throw new kotlin.NoWhenBranchMatchedException();
                }
                if (kotlin.reflect.jvm.internal.impl.types.DynamicTypesKt.isDynamic(unwrappedType)) {
                    return unwrappedType;
                }
                lowerBound = ((kotlin.reflect.jvm.internal.impl.types.FlexibleType) unwrappedType).getLowerBound();
                z2 = true;
            }
            arrayList.add(lowerBound);
        }
        java.util.ArrayList arrayList2 = arrayList;
        if (z) {
            return kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils.createErrorType(kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind.INTERSECTION_OF_ERROR_TYPES, types.toString());
        }
        if (!z2) {
            return kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.INSTANCE.intersectTypes$descriptors(arrayList2);
        }
        java.util.ArrayList arrayList3 = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(collection, 10));
        java.util.Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            arrayList3.add(kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt.upperIfFlexible((kotlin.reflect.jvm.internal.impl.types.UnwrappedType) it.next()));
        }
        return kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.flexibleType(kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.INSTANCE.intersectTypes$descriptors(arrayList2), kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.INSTANCE.intersectTypes$descriptors(arrayList3));
    }
}
