package kotlin.reflect.jvm.internal.impl.load.java;

/* JADX INFO: compiled from: FakePureImplementationsProvider.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FakePureImplementationsProvider {
    public static final kotlin.reflect.jvm.internal.impl.load.java.FakePureImplementationsProvider INSTANCE;
    private static final java.util.Map<kotlin.reflect.jvm.internal.impl.name.ClassId, kotlin.reflect.jvm.internal.impl.name.ClassId> pureImplementationsClassIds;
    private static final java.util.Map<kotlin.reflect.jvm.internal.impl.name.FqName, kotlin.reflect.jvm.internal.impl.name.FqName> pureImplementationsFqNames;

    private FakePureImplementationsProvider() {
    }

    public final kotlin.reflect.jvm.internal.impl.name.FqName getPurelyImplementedInterface(kotlin.reflect.jvm.internal.impl.name.FqName classFqName) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(classFqName, "classFqName");
        return pureImplementationsFqNames.get(classFqName);
    }

    static {
        kotlin.reflect.jvm.internal.impl.load.java.FakePureImplementationsProvider fakePureImplementationsProvider = new kotlin.reflect.jvm.internal.impl.load.java.FakePureImplementationsProvider();
        INSTANCE = fakePureImplementationsProvider;
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
        pureImplementationsClassIds = linkedHashMap;
        fakePureImplementationsProvider.implementedWith(kotlin.reflect.jvm.internal.impl.name.StandardClassIds.INSTANCE.getMutableList(), fakePureImplementationsProvider.fqNameListOf("java.util.ArrayList", "java.util.LinkedList"));
        fakePureImplementationsProvider.implementedWith(kotlin.reflect.jvm.internal.impl.name.StandardClassIds.INSTANCE.getMutableSet(), fakePureImplementationsProvider.fqNameListOf("java.util.HashSet", "java.util.TreeSet", "java.util.LinkedHashSet"));
        fakePureImplementationsProvider.implementedWith(kotlin.reflect.jvm.internal.impl.name.StandardClassIds.INSTANCE.getMutableMap(), fakePureImplementationsProvider.fqNameListOf("java.util.HashMap", "java.util.TreeMap", "java.util.LinkedHashMap", "java.util.concurrent.ConcurrentHashMap", "java.util.concurrent.ConcurrentSkipListMap"));
        fakePureImplementationsProvider.implementedWith(kotlin.reflect.jvm.internal.impl.name.ClassId.Companion.topLevel(new kotlin.reflect.jvm.internal.impl.name.FqName("java.util.function.Function")), fakePureImplementationsProvider.fqNameListOf("java.util.function.UnaryOperator"));
        fakePureImplementationsProvider.implementedWith(kotlin.reflect.jvm.internal.impl.name.ClassId.Companion.topLevel(new kotlin.reflect.jvm.internal.impl.name.FqName("java.util.function.BiFunction")), fakePureImplementationsProvider.fqNameListOf("java.util.function.BinaryOperator"));
        java.util.ArrayList arrayList = new java.util.ArrayList(linkedHashMap.size());
        for (java.util.Map.Entry entry : linkedHashMap.entrySet()) {
            arrayList.add(kotlin.TuplesKt.to(((kotlin.reflect.jvm.internal.impl.name.ClassId) entry.getKey()).asSingleFqName(), ((kotlin.reflect.jvm.internal.impl.name.ClassId) entry.getValue()).asSingleFqName()));
        }
        pureImplementationsFqNames = kotlin.collections.MapsKt.toMap(arrayList);
    }

    private final void implementedWith(kotlin.reflect.jvm.internal.impl.name.ClassId classId, java.util.List<kotlin.reflect.jvm.internal.impl.name.ClassId> list) {
        java.util.Map<kotlin.reflect.jvm.internal.impl.name.ClassId, kotlin.reflect.jvm.internal.impl.name.ClassId> map = pureImplementationsClassIds;
        for (java.lang.Object obj : list) {
            map.put((kotlin.reflect.jvm.internal.impl.name.ClassId) obj, classId);
        }
    }

    private final java.util.List<kotlin.reflect.jvm.internal.impl.name.ClassId> fqNameListOf(java.lang.String... strArr) {
        java.util.ArrayList arrayList = new java.util.ArrayList(strArr.length);
        for (java.lang.String str : strArr) {
            arrayList.add(kotlin.reflect.jvm.internal.impl.name.ClassId.Companion.topLevel(new kotlin.reflect.jvm.internal.impl.name.FqName(str)));
        }
        return arrayList;
    }
}
