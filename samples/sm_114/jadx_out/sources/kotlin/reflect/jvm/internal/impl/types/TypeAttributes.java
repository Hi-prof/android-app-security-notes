package kotlin.reflect.jvm.internal.impl.types;

/* JADX INFO: compiled from: TypeAttributes.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TypeAttributes extends kotlin.reflect.jvm.internal.impl.util.AttributeArrayOwner<kotlin.reflect.jvm.internal.impl.types.TypeAttribute<?>, kotlin.reflect.jvm.internal.impl.types.TypeAttribute<?>> implements java.lang.Iterable<kotlin.reflect.jvm.internal.impl.types.TypeAttribute<?>>, kotlin.jvm.internal.markers.KMappedMarker {
    public static final kotlin.reflect.jvm.internal.impl.types.TypeAttributes.Companion Companion = new kotlin.reflect.jvm.internal.impl.types.TypeAttributes.Companion(null);
    private static final kotlin.reflect.jvm.internal.impl.types.TypeAttributes Empty = new kotlin.reflect.jvm.internal.impl.types.TypeAttributes((java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.TypeAttribute<?>>) kotlin.collections.CollectionsKt.emptyList());

    public /* synthetic */ TypeAttributes(java.util.List list, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this((java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.TypeAttribute<?>>) list);
    }

    private TypeAttributes(java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.TypeAttribute<?>> list) {
        for (kotlin.reflect.jvm.internal.impl.types.TypeAttribute<?> typeAttribute : list) {
            registerComponent((kotlin.reflect.KClass) typeAttribute.getKey(), typeAttribute);
        }
    }

    /* JADX INFO: compiled from: TypeAttributes.kt */
    public static final class Companion extends kotlin.reflect.jvm.internal.impl.util.TypeRegistry<kotlin.reflect.jvm.internal.impl.types.TypeAttribute<?>, kotlin.reflect.jvm.internal.impl.types.TypeAttribute<?>> {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.util.TypeRegistry
        public int customComputeIfAbsent(java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Integer> concurrentHashMap, java.lang.String key, kotlin.jvm.functions.Function1<? super java.lang.String, java.lang.Integer> compute) {
            int iIntValue;
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(concurrentHashMap, "<this>");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(key, "key");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(compute, "compute");
            java.lang.Integer num = concurrentHashMap.get(key);
            if (num != null) {
                return num.intValue();
            }
            synchronized (concurrentHashMap) {
                java.lang.Integer num2 = concurrentHashMap.get(key);
                if (num2 != null) {
                    iIntValue = num2.intValue();
                } else {
                    java.lang.Integer numInvoke = compute.invoke(key);
                    concurrentHashMap.putIfAbsent(key, java.lang.Integer.valueOf(numInvoke.intValue()));
                    iIntValue = numInvoke.intValue();
                }
            }
            return iIntValue;
        }

        public final kotlin.reflect.jvm.internal.impl.types.TypeAttributes getEmpty() {
            return kotlin.reflect.jvm.internal.impl.types.TypeAttributes.Empty;
        }

        public final kotlin.reflect.jvm.internal.impl.types.TypeAttributes create(java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.TypeAttribute<?>> attributes) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(attributes, "attributes");
            if (attributes.isEmpty()) {
                return getEmpty();
            }
            return new kotlin.reflect.jvm.internal.impl.types.TypeAttributes(attributes, null);
        }
    }

    private TypeAttributes(kotlin.reflect.jvm.internal.impl.types.TypeAttribute<?> typeAttribute) {
        this((java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.TypeAttribute<?>>) kotlin.collections.CollectionsKt.listOf(typeAttribute));
    }

    public final boolean contains(kotlin.reflect.jvm.internal.impl.types.TypeAttribute<?> attribute) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(attribute, "attribute");
        return getArrayMap().get(Companion.getId((kotlin.reflect.KClass) attribute.getKey())) != null;
    }

    public final kotlin.reflect.jvm.internal.impl.types.TypeAttributes plus(kotlin.reflect.jvm.internal.impl.types.TypeAttribute<?> attribute) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(attribute, "attribute");
        if (contains(attribute)) {
            return this;
        }
        if (isEmpty()) {
            return new kotlin.reflect.jvm.internal.impl.types.TypeAttributes(attribute);
        }
        return Companion.create(kotlin.collections.CollectionsKt.plus((java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.types.TypeAttribute<?>>) kotlin.collections.CollectionsKt.toList(this), attribute));
    }

    public final kotlin.reflect.jvm.internal.impl.types.TypeAttributes remove(kotlin.reflect.jvm.internal.impl.types.TypeAttribute<?> attribute) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(attribute, "attribute");
        if (!isEmpty()) {
            kotlin.reflect.jvm.internal.impl.util.ArrayMap<kotlin.reflect.jvm.internal.impl.types.TypeAttribute<?>> arrayMap = getArrayMap();
            java.util.ArrayList arrayList = new java.util.ArrayList();
            for (kotlin.reflect.jvm.internal.impl.types.TypeAttribute<?> typeAttribute : arrayMap) {
                if (!kotlin.jvm.internal.Intrinsics.areEqual(typeAttribute, attribute)) {
                    arrayList.add(typeAttribute);
                }
            }
            java.util.ArrayList arrayList2 = arrayList;
            if (arrayList2.size() != getArrayMap().getSize()) {
                return Companion.create(arrayList2);
            }
        }
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.AbstractArrayMapOwner
    protected kotlin.reflect.jvm.internal.impl.util.TypeRegistry<kotlin.reflect.jvm.internal.impl.types.TypeAttribute<?>, kotlin.reflect.jvm.internal.impl.types.TypeAttribute<?>> getTypeRegistry() {
        return Companion;
    }

    public final kotlin.reflect.jvm.internal.impl.types.TypeAttributes intersect(kotlin.reflect.jvm.internal.impl.types.TypeAttributes other) {
        kotlin.reflect.jvm.internal.impl.types.TypeAttribute typeAttributeIntersect;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(other, "other");
        if (isEmpty() && other.isEmpty()) {
            return this;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator it = Companion.getIndices().iterator();
        while (it.hasNext()) {
            int iIntValue = ((java.lang.Number) it.next()).intValue();
            kotlin.reflect.jvm.internal.impl.types.TypeAttribute<?> typeAttribute = getArrayMap().get(iIntValue);
            kotlin.reflect.jvm.internal.impl.types.TypeAttribute<?> typeAttribute2 = other.getArrayMap().get(iIntValue);
            if (typeAttribute == null) {
                typeAttributeIntersect = typeAttribute2 != null ? typeAttribute2.intersect(typeAttribute) : null;
            } else {
                typeAttributeIntersect = typeAttribute.intersect(typeAttribute2);
            }
            kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(arrayList, typeAttributeIntersect);
        }
        return Companion.create(arrayList);
    }

    public final kotlin.reflect.jvm.internal.impl.types.TypeAttributes add(kotlin.reflect.jvm.internal.impl.types.TypeAttributes other) {
        kotlin.reflect.jvm.internal.impl.types.TypeAttribute typeAttributeAdd;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(other, "other");
        if (isEmpty() && other.isEmpty()) {
            return this;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator it = Companion.getIndices().iterator();
        while (it.hasNext()) {
            int iIntValue = ((java.lang.Number) it.next()).intValue();
            kotlin.reflect.jvm.internal.impl.types.TypeAttribute<?> typeAttribute = getArrayMap().get(iIntValue);
            kotlin.reflect.jvm.internal.impl.types.TypeAttribute<?> typeAttribute2 = other.getArrayMap().get(iIntValue);
            if (typeAttribute == null) {
                typeAttributeAdd = typeAttribute2 != null ? typeAttribute2.add(typeAttribute) : null;
            } else {
                typeAttributeAdd = typeAttribute.add(typeAttribute2);
            }
            kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(arrayList, typeAttributeAdd);
        }
        return Companion.create(arrayList);
    }
}
