package kotlin.collections;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: CollectionsJVM.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000\\\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u001e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\u001a\u001f\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002¢\u0006\u0002\u0010\u0004\u001a0\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0006j\b\u0012\u0004\u0012\u0002H\u0002`\u0007\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\bH\u0081\b¢\u0006\u0002\u0010\t\u001a7\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0001\"\u0004\b\u0000\u0010\u000b2\u001d\u0010\f\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0002\b\u0010H\u0081\bø\u0001\u0000\u001a?\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0001\"\u0004\b\u0000\u0010\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\u001d\u0010\f\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0002\b\u0010H\u0081\bø\u0001\u0000\u001a\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u000e\"\u0004\b\u0000\u0010\u000bH\u0001\u001a\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u000e\"\u0004\b\u0000\u0010\u000b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0001\u001a\"\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0001\"\u0004\b\u0000\u0010\u000b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u000eH\u0001\u001a\u001f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0017H\u0087\b\u001a\u001e\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0019H\u0007\u001a&\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0007\u001a\"\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\b2\n\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u001fH\u0081\b¢\u0006\u0002\u0010 \u001a4\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u00020\b\"\u0004\b\u0000\u0010\u00022\n\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u001f2\f\u0010!\u001a\b\u0012\u0004\u0012\u0002H\u00020\bH\u0081\b¢\u0006\u0002\u0010\"\u001a/\u0010#\u001a\b\u0012\u0004\u0012\u0002H\u00020\b\"\u0004\b\u0000\u0010\u00022\u0006\u0010$\u001a\u00020\u00122\f\u0010!\u001a\b\u0012\u0004\u0012\u0002H\u00020\bH\u0000¢\u0006\u0002\u0010%\u001a1\u0010&\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u001d0\b\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\b2\u0006\u0010'\u001a\u00020(H\u0000¢\u0006\u0002\u0010)\u001a\u0011\u0010*\u001a\u00020\u00122\u0006\u0010+\u001a\u00020\u0012H\u0081\b\u001a\u0011\u0010,\u001a\u00020\u00122\u0006\u0010-\u001a\u00020\u0012H\u0081\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006."}, d2 = {"listOf", "", "T", com.alibaba.android.bindingx.core.internal.BindingXConstants.KEY_ELEMENT, "(Ljava/lang/Object;)Ljava/util/List;", "asArrayList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "", "([Ljava/lang/Object;)Ljava/util/ArrayList;", "buildListInternal", "E", "builderAction", "Lkotlin/Function1;", "", "", "Lkotlin/ExtensionFunctionType;", "capacity", "", "createListBuilder", "build", "builder", "toList", "Ljava/util/Enumeration;", "shuffled", "", "random", "Ljava/util/Random;", "collectionToArray", "", "collection", "", "(Ljava/util/Collection;)[Ljava/lang/Object;", "array", "(Ljava/util/Collection;[Ljava/lang/Object;)[Ljava/lang/Object;", "terminateCollectionToArray", "collectionSize", "(I[Ljava/lang/Object;)[Ljava/lang/Object;", "copyToArrayOfAny", "isVarargs", "", "([Ljava/lang/Object;Z)[Ljava/lang/Object;", "checkIndexOverflow", "index", "checkCountOverflow", "count", "kotlin-stdlib"}, k = 5, mv = {2, 2, 0}, xi = 49, xs = "kotlin/collections/CollectionsKt")
public class CollectionsKt__CollectionsJVMKt {
    public static final <T> java.util.List<T> listOf(T t) {
        java.util.List<T> listSingletonList = java.util.Collections.singletonList(t);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(listSingletonList, "singletonList(...)");
        return listSingletonList;
    }

    private static final <T> java.util.ArrayList<T> asArrayList(T[] tArr) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(tArr, "<this>");
        return new java.util.ArrayList<>(kotlin.collections.CollectionsKt.asCollection(tArr, true));
    }

    private static final <E> java.util.List<E> buildListInternal(kotlin.jvm.functions.Function1<? super java.util.List<E>, kotlin.Unit> builderAction) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        java.util.List listCreateListBuilder = kotlin.collections.CollectionsKt.createListBuilder();
        builderAction.invoke(listCreateListBuilder);
        return kotlin.collections.CollectionsKt.build(listCreateListBuilder);
    }

    private static final <E> java.util.List<E> buildListInternal(int i, kotlin.jvm.functions.Function1<? super java.util.List<E>, kotlin.Unit> builderAction) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        java.util.List listCreateListBuilder = kotlin.collections.CollectionsKt.createListBuilder(i);
        builderAction.invoke(listCreateListBuilder);
        return kotlin.collections.CollectionsKt.build(listCreateListBuilder);
    }

    public static final <E> java.util.List<E> createListBuilder() {
        return new kotlin.collections.builders.ListBuilder(0, 1, null);
    }

    public static final <E> java.util.List<E> createListBuilder(int i) {
        return new kotlin.collections.builders.ListBuilder(i);
    }

    public static final <E> java.util.List<E> build(java.util.List<E> builder) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(builder, "builder");
        return ((kotlin.collections.builders.ListBuilder) builder).build();
    }

    private static final <T> java.util.List<T> toList(java.util.Enumeration<T> enumeration) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(enumeration, "<this>");
        java.util.ArrayList list = java.util.Collections.list(enumeration);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(list, "list(...)");
        return list;
    }

    public static final <T> java.util.List<T> shuffled(java.lang.Iterable<? extends T> iterable) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(iterable, "<this>");
        java.util.List<T> mutableList = kotlin.collections.CollectionsKt.toMutableList(iterable);
        java.util.Collections.shuffle(mutableList);
        return mutableList;
    }

    public static final <T> java.util.List<T> shuffled(java.lang.Iterable<? extends T> iterable, java.util.Random random) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(iterable, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(random, "random");
        java.util.List<T> mutableList = kotlin.collections.CollectionsKt.toMutableList(iterable);
        java.util.Collections.shuffle(mutableList, random);
        return mutableList;
    }

    private static final java.lang.Object[] collectionToArray(java.util.Collection<?> collection) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(collection, "collection");
        return kotlin.jvm.internal.CollectionToArray.toArray(collection);
    }

    private static final <T> T[] collectionToArray(java.util.Collection<?> collection, T[] array) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(collection, "collection");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(array, "array");
        return (T[]) kotlin.jvm.internal.CollectionToArray.toArray(collection, array);
    }

    public static final <T> T[] terminateCollectionToArray(int i, T[] array) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(array, "array");
        if (i < array.length) {
            array[i] = null;
        }
        return array;
    }

    public static final <T> java.lang.Object[] copyToArrayOfAny(T[] tArr, boolean z) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (z && kotlin.jvm.internal.Intrinsics.areEqual(tArr.getClass(), java.lang.Object[].class)) {
            return tArr;
        }
        java.lang.Object[] objArrCopyOf = java.util.Arrays.copyOf(tArr, tArr.length, java.lang.Object[].class);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(...)");
        return objArrCopyOf;
    }

    private static final int checkIndexOverflow(int i) {
        if (i < 0) {
            kotlin.collections.CollectionsKt.throwIndexOverflow();
        }
        return i;
    }

    private static final int checkCountOverflow(int i) {
        if (i < 0) {
            kotlin.collections.CollectionsKt.throwCountOverflow();
        }
        return i;
    }
}
