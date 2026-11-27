package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

/* JADX INFO: compiled from: ClassMapperLite.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ClassMapperLite {
    public static final kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.ClassMapperLite INSTANCE = new kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.ClassMapperLite();

    /* JADX INFO: renamed from: kotlin, reason: collision with root package name */
    private static final java.lang.String f8kotlin = kotlin.collections.CollectionsKt.joinToString$default(kotlin.collections.CollectionsKt.listOf((java.lang.Object[]) new java.lang.Character[]{'k', 'o', 't', 'l', 'i', 'n'}), "", null, null, 0, null, null, 62, null);
    private static final java.util.Map<java.lang.String, java.lang.String> map;

    private ClassMapperLite() {
    }

    static {
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
        java.util.List listListOf = kotlin.collections.CollectionsKt.listOf((java.lang.Object[]) new java.lang.String[]{"Boolean", "Z", "Char", "C", "Byte", "B", "Short", "S", "Int", "I", "Float", "F", "Long", "J", "Double", "D"});
        int progressionLastElement = kotlin.internal.ProgressionUtilKt.getProgressionLastElement(0, listListOf.size() - 1, 2);
        if (progressionLastElement >= 0) {
            int i = 0;
            while (true) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                java.lang.String str = f8kotlin;
                sb.append(str);
                sb.append('/');
                sb.append((java.lang.String) listListOf.get(i));
                int i2 = i + 1;
                linkedHashMap.put(sb.toString(), listListOf.get(i2));
                linkedHashMap.put(str + '/' + ((java.lang.String) listListOf.get(i)) + "Array", com.taobao.weex.el.parse.Operators.ARRAY_START_STR + ((java.lang.String) listListOf.get(i2)));
                if (i == progressionLastElement) {
                    break;
                } else {
                    i += 2;
                }
            }
        }
        linkedHashMap.put(f8kotlin + "/Unit", "V");
        map$lambda$0$add(linkedHashMap, "Any", "java/lang/Object");
        map$lambda$0$add(linkedHashMap, "Nothing", "java/lang/Void");
        map$lambda$0$add(linkedHashMap, "Annotation", "java/lang/annotation/Annotation");
        for (java.lang.String str2 : kotlin.collections.CollectionsKt.listOf((java.lang.Object[]) new java.lang.String[]{"String", "CharSequence", "Throwable", "Cloneable", "Number", "Comparable", "Enum"})) {
            map$lambda$0$add(linkedHashMap, str2, "java/lang/" + str2);
        }
        for (java.lang.String str3 : kotlin.collections.CollectionsKt.listOf((java.lang.Object[]) new java.lang.String[]{"Iterator", "Collection", "List", "Set", "Map", "ListIterator"})) {
            map$lambda$0$add(linkedHashMap, "collections/" + str3, "java/util/" + str3);
            map$lambda$0$add(linkedHashMap, "collections/Mutable" + str3, "java/util/" + str3);
        }
        map$lambda$0$add(linkedHashMap, "collections/Iterable", "java/lang/Iterable");
        map$lambda$0$add(linkedHashMap, "collections/MutableIterable", "java/lang/Iterable");
        map$lambda$0$add(linkedHashMap, "collections/Map.Entry", "java/util/Map$Entry");
        map$lambda$0$add(linkedHashMap, "collections/MutableMap.MutableEntry", "java/util/Map$Entry");
        for (int i3 = 0; i3 < 23; i3++) {
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            java.lang.String str4 = f8kotlin;
            sb2.append(str4);
            sb2.append("/jvm/functions/Function");
            sb2.append(i3);
            map$lambda$0$add(linkedHashMap, "Function" + i3, sb2.toString());
            map$lambda$0$add(linkedHashMap, "reflect/KFunction" + i3, str4 + "/reflect/KFunction");
        }
        for (java.lang.String str5 : kotlin.collections.CollectionsKt.listOf((java.lang.Object[]) new java.lang.String[]{"Char", "Byte", "Short", "Int", "Float", "Long", "Double", "String", "Enum"})) {
            map$lambda$0$add(linkedHashMap, str5 + ".Companion", f8kotlin + "/jvm/internal/" + str5 + "CompanionObject");
        }
        map = linkedHashMap;
    }

    private static final void map$lambda$0$add(java.util.Map<java.lang.String, java.lang.String> map2, java.lang.String str, java.lang.String str2) {
        map2.put(f8kotlin + '/' + str, "L" + str2 + ';');
    }

    @kotlin.jvm.JvmStatic
    public static final java.lang.String mapClass(java.lang.String classId) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(classId, "classId");
        java.lang.String str = map.get(classId);
        if (str != null) {
            return str;
        }
        return "L" + kotlin.text.StringsKt.replace$default(classId, com.taobao.weex.el.parse.Operators.DOT, '$', false, 4, (java.lang.Object) null) + ';';
    }
}
