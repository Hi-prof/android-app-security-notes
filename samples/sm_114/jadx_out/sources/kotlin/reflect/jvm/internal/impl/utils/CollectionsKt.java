package kotlin.reflect.jvm.internal.impl.utils;

/* JADX INFO: compiled from: collections.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CollectionsKt {
    public static final <K> java.util.Map<K, java.lang.Integer> mapToIndex(java.lang.Iterable<? extends K> iterable) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(iterable, "<this>");
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
        java.util.Iterator<? extends K> it = iterable.iterator();
        int i = 0;
        while (it.hasNext()) {
            linkedHashMap.put(it.next(), java.lang.Integer.valueOf(i));
            i++;
        }
        return linkedHashMap;
    }

    public static final <T> void addIfNotNull(java.util.Collection<T> collection, T t) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(collection, "<this>");
        if (t != null) {
            collection.add(t);
        }
    }

    public static final <K, V> java.util.HashMap<K, V> newHashMapWithExpectedSize(int i) {
        return new java.util.HashMap<>(capacity(i));
    }

    public static final <E> java.util.HashSet<E> newHashSetWithExpectedSize(int i) {
        return new java.util.HashSet<>(capacity(i));
    }

    public static final <E> java.util.LinkedHashSet<E> newLinkedHashSetWithExpectedSize(int i) {
        return new java.util.LinkedHashSet<>(capacity(i));
    }

    private static final int capacity(int i) {
        if (i < 3) {
            return 3;
        }
        return i + (i / 3) + 1;
    }

    public static final <T> java.util.List<T> compact(java.util.ArrayList<T> arrayList) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(arrayList, "<this>");
        int size = arrayList.size();
        if (size == 0) {
            return kotlin.collections.CollectionsKt.emptyList();
        }
        if (size == 1) {
            return kotlin.collections.CollectionsKt.listOf(kotlin.collections.CollectionsKt.first((java.util.List) arrayList));
        }
        arrayList.trimToSize();
        return arrayList;
    }
}
