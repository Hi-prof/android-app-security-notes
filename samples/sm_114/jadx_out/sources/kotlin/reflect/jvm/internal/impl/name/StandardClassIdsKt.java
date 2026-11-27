package kotlin.reflect.jvm.internal.impl.name;

/* JADX INFO: compiled from: StandardClassIds.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StandardClassIdsKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.name.ClassId baseId(java.lang.String str) {
        kotlin.reflect.jvm.internal.impl.name.FqName base_kotlin_package = kotlin.reflect.jvm.internal.impl.name.StandardClassIds.INSTANCE.getBASE_KOTLIN_PACKAGE();
        kotlin.reflect.jvm.internal.impl.name.Name nameIdentifier = kotlin.reflect.jvm.internal.impl.name.Name.identifier(str);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameIdentifier, "identifier(...)");
        return new kotlin.reflect.jvm.internal.impl.name.ClassId(base_kotlin_package, nameIdentifier);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.name.ClassId unsignedId(kotlin.reflect.jvm.internal.impl.name.ClassId classId) {
        kotlin.reflect.jvm.internal.impl.name.FqName base_kotlin_package = kotlin.reflect.jvm.internal.impl.name.StandardClassIds.INSTANCE.getBASE_KOTLIN_PACKAGE();
        kotlin.reflect.jvm.internal.impl.name.Name nameIdentifier = kotlin.reflect.jvm.internal.impl.name.Name.identifier("U" + classId.getShortClassName().getIdentifier());
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameIdentifier, "identifier(...)");
        return new kotlin.reflect.jvm.internal.impl.name.ClassId(base_kotlin_package, nameIdentifier);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.name.ClassId reflectId(java.lang.String str) {
        kotlin.reflect.jvm.internal.impl.name.FqName base_reflect_package = kotlin.reflect.jvm.internal.impl.name.StandardClassIds.INSTANCE.getBASE_REFLECT_PACKAGE();
        kotlin.reflect.jvm.internal.impl.name.Name nameIdentifier = kotlin.reflect.jvm.internal.impl.name.Name.identifier(str);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameIdentifier, "identifier(...)");
        return new kotlin.reflect.jvm.internal.impl.name.ClassId(base_reflect_package, nameIdentifier);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.name.ClassId primitiveArrayId(kotlin.reflect.jvm.internal.impl.name.Name name) {
        kotlin.reflect.jvm.internal.impl.name.FqName packageFqName = kotlin.reflect.jvm.internal.impl.name.StandardClassIds.INSTANCE.getArray().getPackageFqName();
        kotlin.reflect.jvm.internal.impl.name.Name nameIdentifier = kotlin.reflect.jvm.internal.impl.name.Name.identifier(name.getIdentifier() + kotlin.reflect.jvm.internal.impl.name.StandardClassIds.INSTANCE.getArray().getShortClassName().getIdentifier());
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameIdentifier, "identifier(...)");
        return new kotlin.reflect.jvm.internal.impl.name.ClassId(packageFqName, nameIdentifier);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.name.ClassId collectionsId(java.lang.String str) {
        kotlin.reflect.jvm.internal.impl.name.FqName base_collections_package = kotlin.reflect.jvm.internal.impl.name.StandardClassIds.INSTANCE.getBASE_COLLECTIONS_PACKAGE();
        kotlin.reflect.jvm.internal.impl.name.Name nameIdentifier = kotlin.reflect.jvm.internal.impl.name.Name.identifier(str);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameIdentifier, "identifier(...)");
        return new kotlin.reflect.jvm.internal.impl.name.ClassId(base_collections_package, nameIdentifier);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.name.ClassId rangesId(java.lang.String str) {
        kotlin.reflect.jvm.internal.impl.name.FqName base_ranges_package = kotlin.reflect.jvm.internal.impl.name.StandardClassIds.INSTANCE.getBASE_RANGES_PACKAGE();
        kotlin.reflect.jvm.internal.impl.name.Name nameIdentifier = kotlin.reflect.jvm.internal.impl.name.Name.identifier(str);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameIdentifier, "identifier(...)");
        return new kotlin.reflect.jvm.internal.impl.name.ClassId(base_ranges_package, nameIdentifier);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.name.ClassId annotationId(java.lang.String str) {
        kotlin.reflect.jvm.internal.impl.name.FqName base_annotation_package = kotlin.reflect.jvm.internal.impl.name.StandardClassIds.INSTANCE.getBASE_ANNOTATION_PACKAGE();
        kotlin.reflect.jvm.internal.impl.name.Name nameIdentifier = kotlin.reflect.jvm.internal.impl.name.Name.identifier(str);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameIdentifier, "identifier(...)");
        return new kotlin.reflect.jvm.internal.impl.name.ClassId(base_annotation_package, nameIdentifier);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.name.ClassId coroutinesId(java.lang.String str) {
        kotlin.reflect.jvm.internal.impl.name.FqName base_coroutines_package = kotlin.reflect.jvm.internal.impl.name.StandardClassIds.INSTANCE.getBASE_COROUTINES_PACKAGE();
        kotlin.reflect.jvm.internal.impl.name.Name nameIdentifier = kotlin.reflect.jvm.internal.impl.name.Name.identifier(str);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameIdentifier, "identifier(...)");
        return new kotlin.reflect.jvm.internal.impl.name.ClassId(base_coroutines_package, nameIdentifier);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.name.ClassId enumsId(java.lang.String str) {
        kotlin.reflect.jvm.internal.impl.name.FqName base_enums_package = kotlin.reflect.jvm.internal.impl.name.StandardClassIds.INSTANCE.getBASE_ENUMS_PACKAGE();
        kotlin.reflect.jvm.internal.impl.name.Name nameIdentifier = kotlin.reflect.jvm.internal.impl.name.Name.identifier(str);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameIdentifier, "identifier(...)");
        return new kotlin.reflect.jvm.internal.impl.name.ClassId(base_enums_package, nameIdentifier);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.name.ClassId atomicsId(java.lang.String str) {
        kotlin.reflect.jvm.internal.impl.name.FqName base_concurrent_atomics_package = kotlin.reflect.jvm.internal.impl.name.StandardClassIds.INSTANCE.getBASE_CONCURRENT_ATOMICS_PACKAGE();
        kotlin.reflect.jvm.internal.impl.name.Name nameIdentifier = kotlin.reflect.jvm.internal.impl.name.Name.identifier(str);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameIdentifier, "identifier(...)");
        return new kotlin.reflect.jvm.internal.impl.name.ClassId(base_concurrent_atomics_package, nameIdentifier);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> java.util.Map<V, K> inverseMap(java.util.Map<K, ? extends V> map) {
        java.util.Set<java.util.Map.Entry<K, ? extends V>> setEntrySet = map.entrySet();
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap(kotlin.ranges.RangesKt.coerceAtLeast(kotlin.collections.MapsKt.mapCapacity(kotlin.collections.CollectionsKt.collectionSizeOrDefault(setEntrySet, 10)), 16));
        java.util.Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            java.util.Map.Entry entry = (java.util.Map.Entry) it.next();
            kotlin.Pair pair = kotlin.TuplesKt.to(entry.getValue(), entry.getKey());
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return linkedHashMap;
    }
}
