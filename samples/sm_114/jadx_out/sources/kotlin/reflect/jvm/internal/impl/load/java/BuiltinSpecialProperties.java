package kotlin.reflect.jvm.internal.impl.load.java;

/* JADX INFO: compiled from: BuiltinSpecialProperties.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class BuiltinSpecialProperties {
    private static final java.util.Set<kotlin.reflect.jvm.internal.impl.name.FqName> GETTER_FQ_NAMES;
    private static final java.util.Map<kotlin.reflect.jvm.internal.impl.name.Name, java.util.List<kotlin.reflect.jvm.internal.impl.name.Name>> GETTER_JVM_NAME_TO_PROPERTIES_SHORT_NAME_MAP;
    public static final kotlin.reflect.jvm.internal.impl.load.java.BuiltinSpecialProperties INSTANCE = new kotlin.reflect.jvm.internal.impl.load.java.BuiltinSpecialProperties();
    private static final java.util.Map<kotlin.reflect.jvm.internal.impl.name.FqName, kotlin.reflect.jvm.internal.impl.name.Name> PROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP;
    private static final java.util.Set<kotlin.reflect.jvm.internal.impl.name.FqName> SPECIAL_FQ_NAMES;
    private static final java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> SPECIAL_SHORT_NAMES;

    private BuiltinSpecialProperties() {
    }

    public final java.util.Map<kotlin.reflect.jvm.internal.impl.name.FqName, kotlin.reflect.jvm.internal.impl.name.Name> getPROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP() {
        return PROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP;
    }

    static {
        java.util.Map<kotlin.reflect.jvm.internal.impl.name.FqName, kotlin.reflect.jvm.internal.impl.name.Name> mapMapOf = kotlin.collections.MapsKt.mapOf(kotlin.TuplesKt.to(kotlin.reflect.jvm.internal.impl.load.java.BuiltinSpecialPropertiesKt.childSafe(kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames._enum, "name"), kotlin.reflect.jvm.internal.impl.builtins.StandardNames.NAME), kotlin.TuplesKt.to(kotlin.reflect.jvm.internal.impl.load.java.BuiltinSpecialPropertiesKt.childSafe(kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames._enum, "ordinal"), kotlin.reflect.jvm.internal.impl.name.Name.identifier("ordinal")), kotlin.TuplesKt.to(kotlin.reflect.jvm.internal.impl.load.java.BuiltinSpecialPropertiesKt.child(kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.collection, io.dcloud.common.constant.AbsoluteConst.JSON_KEY_SIZE), kotlin.reflect.jvm.internal.impl.name.Name.identifier(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_SIZE)), kotlin.TuplesKt.to(kotlin.reflect.jvm.internal.impl.load.java.BuiltinSpecialPropertiesKt.child(kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.map, io.dcloud.common.constant.AbsoluteConst.JSON_KEY_SIZE), kotlin.reflect.jvm.internal.impl.name.Name.identifier(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_SIZE)), kotlin.TuplesKt.to(kotlin.reflect.jvm.internal.impl.load.java.BuiltinSpecialPropertiesKt.childSafe(kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.charSequence, "length"), kotlin.reflect.jvm.internal.impl.name.Name.identifier("length")), kotlin.TuplesKt.to(kotlin.reflect.jvm.internal.impl.load.java.BuiltinSpecialPropertiesKt.child(kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.map, "keys"), kotlin.reflect.jvm.internal.impl.name.Name.identifier("keySet")), kotlin.TuplesKt.to(kotlin.reflect.jvm.internal.impl.load.java.BuiltinSpecialPropertiesKt.child(kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.map, "values"), kotlin.reflect.jvm.internal.impl.name.Name.identifier("values")), kotlin.TuplesKt.to(kotlin.reflect.jvm.internal.impl.load.java.BuiltinSpecialPropertiesKt.child(kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.map, "entries"), kotlin.reflect.jvm.internal.impl.name.Name.identifier("entrySet")), kotlin.TuplesKt.to(kotlin.reflect.jvm.internal.impl.load.java.BuiltinSpecialPropertiesKt.child(kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.atomicIntArray, io.dcloud.common.constant.AbsoluteConst.JSON_KEY_SIZE), kotlin.reflect.jvm.internal.impl.name.Name.identifier("length")), kotlin.TuplesKt.to(kotlin.reflect.jvm.internal.impl.load.java.BuiltinSpecialPropertiesKt.child(kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.atomicLongArray, io.dcloud.common.constant.AbsoluteConst.JSON_KEY_SIZE), kotlin.reflect.jvm.internal.impl.name.Name.identifier("length")), kotlin.TuplesKt.to(kotlin.reflect.jvm.internal.impl.load.java.BuiltinSpecialPropertiesKt.child(kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.atomicArray, io.dcloud.common.constant.AbsoluteConst.JSON_KEY_SIZE), kotlin.reflect.jvm.internal.impl.name.Name.identifier("length")));
        PROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP = mapMapOf;
        java.util.Set<java.util.Map.Entry<kotlin.reflect.jvm.internal.impl.name.FqName, kotlin.reflect.jvm.internal.impl.name.Name>> setEntrySet = mapMapOf.entrySet();
        java.util.ArrayList<kotlin.Pair> arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(setEntrySet, 10));
        java.util.Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            java.util.Map.Entry entry = (java.util.Map.Entry) it.next();
            arrayList.add(new kotlin.Pair(((kotlin.reflect.jvm.internal.impl.name.FqName) entry.getKey()).shortName(), entry.getValue()));
        }
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
        for (kotlin.Pair pair : arrayList) {
            kotlin.reflect.jvm.internal.impl.name.Name name = (kotlin.reflect.jvm.internal.impl.name.Name) pair.getSecond();
            java.lang.Object obj = linkedHashMap.get(name);
            if (obj == null) {
                obj = (java.util.List) new java.util.ArrayList();
                linkedHashMap.put(name, obj);
            }
            ((java.util.List) obj).add((kotlin.reflect.jvm.internal.impl.name.Name) pair.getFirst());
        }
        java.util.LinkedHashMap linkedHashMap2 = new java.util.LinkedHashMap(kotlin.collections.MapsKt.mapCapacity(linkedHashMap.size()));
        for (java.util.Map.Entry entry2 : linkedHashMap.entrySet()) {
            linkedHashMap2.put(entry2.getKey(), kotlin.collections.CollectionsKt.distinct((java.lang.Iterable) entry2.getValue()));
        }
        GETTER_JVM_NAME_TO_PROPERTIES_SHORT_NAME_MAP = linkedHashMap2;
        java.util.Map<kotlin.reflect.jvm.internal.impl.name.FqName, kotlin.reflect.jvm.internal.impl.name.Name> map = PROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP;
        java.util.LinkedHashSet linkedHashSet = new java.util.LinkedHashSet();
        for (java.util.Map.Entry<kotlin.reflect.jvm.internal.impl.name.FqName, kotlin.reflect.jvm.internal.impl.name.Name> entry3 : map.entrySet()) {
            kotlin.reflect.jvm.internal.impl.name.ClassId classIdMapKotlinToJava = kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap.INSTANCE.mapKotlinToJava(entry3.getKey().parent().toUnsafe());
            kotlin.jvm.internal.Intrinsics.checkNotNull(classIdMapKotlinToJava);
            linkedHashSet.add(classIdMapKotlinToJava.asSingleFqName().child(entry3.getValue()));
        }
        GETTER_FQ_NAMES = linkedHashSet;
        java.util.Set<kotlin.reflect.jvm.internal.impl.name.FqName> setKeySet = PROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP.keySet();
        SPECIAL_FQ_NAMES = setKeySet;
        java.util.Set<kotlin.reflect.jvm.internal.impl.name.FqName> set = setKeySet;
        java.util.ArrayList arrayList2 = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(set, 10));
        java.util.Iterator<T> it2 = set.iterator();
        while (it2.hasNext()) {
            arrayList2.add(((kotlin.reflect.jvm.internal.impl.name.FqName) it2.next()).shortName());
        }
        SPECIAL_SHORT_NAMES = kotlin.collections.CollectionsKt.toSet(arrayList2);
    }

    public final java.util.Set<kotlin.reflect.jvm.internal.impl.name.FqName> getSPECIAL_FQ_NAMES() {
        return SPECIAL_FQ_NAMES;
    }

    public final java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> getSPECIAL_SHORT_NAMES() {
        return SPECIAL_SHORT_NAMES;
    }

    public final java.util.List<kotlin.reflect.jvm.internal.impl.name.Name> getPropertyNameCandidatesBySpecialGetterName(kotlin.reflect.jvm.internal.impl.name.Name name1) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name1, "name1");
        java.util.List<kotlin.reflect.jvm.internal.impl.name.Name> list = GETTER_JVM_NAME_TO_PROPERTIES_SHORT_NAME_MAP.get(name1);
        return list == null ? kotlin.collections.CollectionsKt.emptyList() : list;
    }
}
