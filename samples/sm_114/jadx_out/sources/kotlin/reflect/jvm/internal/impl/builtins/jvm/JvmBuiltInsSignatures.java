package kotlin.reflect.jvm.internal.impl.builtins.jvm;

/* JADX INFO: compiled from: JvmBuiltInsSignatures.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class JvmBuiltInsSignatures {
    private static final java.util.Set<java.lang.String> DEPRECATED_LIST_METHODS;
    private static final java.util.Set<java.lang.String> DROP_LIST_METHOD_SIGNATURES;
    private static final java.util.Set<java.lang.String> HIDDEN_CONSTRUCTOR_SIGNATURES;
    private static final java.util.Set<java.lang.String> HIDDEN_METHOD_SIGNATURES;
    public static final kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsSignatures INSTANCE;
    private static final java.util.Set<java.lang.String> MUTABLE_METHOD_SIGNATURES;
    private static final java.util.Set<java.lang.String> VISIBLE_CONSTRUCTOR_SIGNATURES;
    private static final java.util.Set<java.lang.String> VISIBLE_METHOD_SIGNATURES;

    private JvmBuiltInsSignatures() {
    }

    public final java.util.Set<java.lang.String> getDROP_LIST_METHOD_SIGNATURES() {
        return DROP_LIST_METHOD_SIGNATURES;
    }

    static {
        kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsSignatures jvmBuiltInsSignatures = new kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsSignatures();
        INSTANCE = jvmBuiltInsSignatures;
        DROP_LIST_METHOD_SIGNATURES = kotlin.collections.SetsKt.plus(kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents.INSTANCE.inJavaUtil("Collection", "toArray()[Ljava/lang/Object;", "toArray([Ljava/lang/Object;)[Ljava/lang/Object;"), "java/lang/annotation/Annotation.annotationType()Ljava/lang/Class;");
        kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents signatureBuildingComponents = kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents.INSTANCE;
        HIDDEN_METHOD_SIGNATURES = kotlin.collections.SetsKt.plus(kotlin.collections.SetsKt.plus(kotlin.collections.SetsKt.plus(kotlin.collections.SetsKt.plus(kotlin.collections.SetsKt.plus(kotlin.collections.SetsKt.plus((java.util.Set) jvmBuiltInsSignatures.buildPrimitiveValueMethodsSet(), (java.lang.Iterable) signatureBuildingComponents.inJavaUtil("List", "sort(Ljava/util/Comparator;)V", "reversed()Ljava/util/List;")), (java.lang.Iterable) signatureBuildingComponents.inJavaLang("String", "codePointAt(I)I", "codePointBefore(I)I", "codePointCount(II)I", "compareToIgnoreCase(Ljava/lang/String;)I", "concat(Ljava/lang/String;)Ljava/lang/String;", "contains(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/StringBuffer;)Z", "endsWith(Ljava/lang/String;)Z", "equalsIgnoreCase(Ljava/lang/String;)Z", "getBytes()[B", "getBytes(II[BI)V", "getBytes(Ljava/lang/String;)[B", "getBytes(Ljava/nio/charset/Charset;)[B", "getChars(II[CI)V", "indexOf(I)I", "indexOf(II)I", "indexOf(Ljava/lang/String;)I", "indexOf(Ljava/lang/String;I)I", "intern()Ljava/lang/String;", "isEmpty()Z", "lastIndexOf(I)I", "lastIndexOf(II)I", "lastIndexOf(Ljava/lang/String;)I", "lastIndexOf(Ljava/lang/String;I)I", "matches(Ljava/lang/String;)Z", "offsetByCodePoints(II)I", "regionMatches(ILjava/lang/String;II)Z", "regionMatches(ZILjava/lang/String;II)Z", "replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(CC)Ljava/lang/String;", "replaceFirst(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;", "split(Ljava/lang/String;I)[Ljava/lang/String;", "split(Ljava/lang/String;)[Ljava/lang/String;", "startsWith(Ljava/lang/String;I)Z", "startsWith(Ljava/lang/String;)Z", "substring(II)Ljava/lang/String;", "substring(I)Ljava/lang/String;", "toCharArray()[C", "toLowerCase()Ljava/lang/String;", "toLowerCase(Ljava/util/Locale;)Ljava/lang/String;", "toUpperCase()Ljava/lang/String;", "toUpperCase(Ljava/util/Locale;)Ljava/lang/String;", "trim()Ljava/lang/String;", "isBlank()Z", "lines()Ljava/util/stream/Stream;", "repeat(I)Ljava/lang/String;")), (java.lang.Iterable) signatureBuildingComponents.inJavaLang("Double", "isInfinite()Z", "isNaN()Z")), (java.lang.Iterable) signatureBuildingComponents.inJavaLang("Float", "isInfinite()Z", "isNaN()Z")), (java.lang.Iterable) signatureBuildingComponents.inJavaLang("Enum", "getDeclaringClass()Ljava/lang/Class;", "finalize()V")), (java.lang.Iterable) signatureBuildingComponents.inJavaLang("CharSequence", "isEmpty()Z"));
        DEPRECATED_LIST_METHODS = kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents.INSTANCE.inJavaUtil("List", "getFirst()Ljava/lang/Object;", "getLast()Ljava/lang/Object;");
        kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents signatureBuildingComponents2 = kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents.INSTANCE;
        VISIBLE_METHOD_SIGNATURES = kotlin.collections.SetsKt.plus(kotlin.collections.SetsKt.plus(kotlin.collections.SetsKt.plus(kotlin.collections.SetsKt.plus(kotlin.collections.SetsKt.plus(kotlin.collections.SetsKt.plus((java.util.Set) signatureBuildingComponents2.inJavaLang("CharSequence", "codePoints()Ljava/util/stream/IntStream;", "chars()Ljava/util/stream/IntStream;"), (java.lang.Iterable) signatureBuildingComponents2.inJavaUtil("Iterator", "forEachRemaining(Ljava/util/function/Consumer;)V")), (java.lang.Iterable) signatureBuildingComponents2.inJavaLang("Iterable", "forEach(Ljava/util/function/Consumer;)V", "spliterator()Ljava/util/Spliterator;")), (java.lang.Iterable) signatureBuildingComponents2.inJavaLang("Throwable", "setStackTrace([Ljava/lang/StackTraceElement;)V", "fillInStackTrace()Ljava/lang/Throwable;", "getLocalizedMessage()Ljava/lang/String;", "printStackTrace()V", "printStackTrace(Ljava/io/PrintStream;)V", "printStackTrace(Ljava/io/PrintWriter;)V", "getStackTrace()[Ljava/lang/StackTraceElement;", "initCause(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "getSuppressed()[Ljava/lang/Throwable;", "addSuppressed(Ljava/lang/Throwable;)V")), (java.lang.Iterable) signatureBuildingComponents2.inJavaUtil("Collection", "spliterator()Ljava/util/Spliterator;", "parallelStream()Ljava/util/stream/Stream;", "stream()Ljava/util/stream/Stream;", "removeIf(Ljava/util/function/Predicate;)Z")), (java.lang.Iterable) signatureBuildingComponents2.inJavaUtil("List", "replaceAll(Ljava/util/function/UnaryOperator;)V", "addFirst(Ljava/lang/Object;)V", "addLast(Ljava/lang/Object;)V", "removeFirst()Ljava/lang/Object;", "removeLast()Ljava/lang/Object;")), (java.lang.Iterable) signatureBuildingComponents2.inJavaUtil("Map", "getOrDefault(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "forEach(Ljava/util/function/BiConsumer;)V", "replaceAll(Ljava/util/function/BiFunction;)V", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;"));
        kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents signatureBuildingComponents3 = kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents.INSTANCE;
        MUTABLE_METHOD_SIGNATURES = kotlin.collections.SetsKt.plus(kotlin.collections.SetsKt.plus((java.util.Set) signatureBuildingComponents3.inJavaUtil("Collection", "removeIf(Ljava/util/function/Predicate;)Z"), (java.lang.Iterable) signatureBuildingComponents3.inJavaUtil("List", "replaceAll(Ljava/util/function/UnaryOperator;)V", "sort(Ljava/util/Comparator;)V", "addFirst(Ljava/lang/Object;)V", "addLast(Ljava/lang/Object;)V", "removeFirst()Ljava/lang/Object;", "removeLast()Ljava/lang/Object;")), (java.lang.Iterable) signatureBuildingComponents3.inJavaUtil("Map", "computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "remove(Ljava/lang/Object;Ljava/lang/Object;)Z", "replaceAll(Ljava/util/function/BiFunction;)V", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z"));
        kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents signatureBuildingComponents4 = kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents.INSTANCE;
        java.util.Set<java.lang.String> setBuildPrimitiveStringConstructorsSet = jvmBuiltInsSignatures.buildPrimitiveStringConstructorsSet();
        java.lang.String[] strArrConstructors = signatureBuildingComponents4.constructors("D");
        java.util.Set setPlus = kotlin.collections.SetsKt.plus((java.util.Set) setBuildPrimitiveStringConstructorsSet, (java.lang.Iterable) signatureBuildingComponents4.inJavaLang("Float", (java.lang.String[]) java.util.Arrays.copyOf(strArrConstructors, strArrConstructors.length)));
        java.lang.String[] strArrConstructors2 = signatureBuildingComponents4.constructors("[C", "[CII", "[III", "[BIILjava/lang/String;", "[BIILjava/nio/charset/Charset;", "[BLjava/lang/String;", "[BLjava/nio/charset/Charset;", "[BII", "[B", "Ljava/lang/StringBuffer;", "Ljava/lang/StringBuilder;");
        HIDDEN_CONSTRUCTOR_SIGNATURES = kotlin.collections.SetsKt.plus(setPlus, (java.lang.Iterable) signatureBuildingComponents4.inJavaLang("String", (java.lang.String[]) java.util.Arrays.copyOf(strArrConstructors2, strArrConstructors2.length)));
        kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents signatureBuildingComponents5 = kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents.INSTANCE;
        java.lang.String[] strArrConstructors3 = signatureBuildingComponents5.constructors("Ljava/lang/String;Ljava/lang/Throwable;ZZ");
        VISIBLE_CONSTRUCTOR_SIGNATURES = signatureBuildingComponents5.inJavaLang("Throwable", (java.lang.String[]) java.util.Arrays.copyOf(strArrConstructors3, strArrConstructors3.length));
    }

    public final java.util.Set<java.lang.String> getHIDDEN_METHOD_SIGNATURES() {
        return HIDDEN_METHOD_SIGNATURES;
    }

    public final java.util.Set<java.lang.String> getDEPRECATED_LIST_METHODS() {
        return DEPRECATED_LIST_METHODS;
    }

    public final java.util.Set<java.lang.String> getVISIBLE_METHOD_SIGNATURES() {
        return VISIBLE_METHOD_SIGNATURES;
    }

    public final java.util.Set<java.lang.String> getMUTABLE_METHOD_SIGNATURES() {
        return MUTABLE_METHOD_SIGNATURES;
    }

    public final java.util.Set<java.lang.String> getHIDDEN_CONSTRUCTOR_SIGNATURES() {
        return HIDDEN_CONSTRUCTOR_SIGNATURES;
    }

    public final java.util.Set<java.lang.String> getVISIBLE_CONSTRUCTOR_SIGNATURES() {
        return VISIBLE_CONSTRUCTOR_SIGNATURES;
    }

    public final boolean isSerializableInJava(kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe fqName) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fqName, "fqName");
        if (isArrayOrPrimitiveArray(fqName)) {
            return true;
        }
        kotlin.reflect.jvm.internal.impl.name.ClassId classIdMapKotlinToJava = kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap.INSTANCE.mapKotlinToJava(fqName);
        if (classIdMapKotlinToJava == null) {
            return false;
        }
        try {
            return java.io.Serializable.class.isAssignableFrom(java.lang.Class.forName(classIdMapKotlinToJava.asSingleFqName().asString()));
        } catch (java.lang.ClassNotFoundException unused) {
            return false;
        }
    }

    public final boolean isArrayOrPrimitiveArray(kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe fqName) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fqName, "fqName");
        return kotlin.jvm.internal.Intrinsics.areEqual(fqName, kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.array) || kotlin.reflect.jvm.internal.impl.builtins.StandardNames.isPrimitiveArray(fqName);
    }

    private final java.util.Set<java.lang.String> buildPrimitiveValueMethodsSet() {
        kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents signatureBuildingComponents = kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents.INSTANCE;
        java.util.List<kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType> listListOf = kotlin.collections.CollectionsKt.listOf((java.lang.Object[]) new kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType[]{kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType.BOOLEAN, kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType.CHAR});
        java.util.LinkedHashSet linkedHashSet = new java.util.LinkedHashSet();
        for (kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType jvmPrimitiveType : listListOf) {
            java.lang.String strAsString = jvmPrimitiveType.getWrapperFqName().shortName().asString();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strAsString, "asString(...)");
            kotlin.collections.CollectionsKt.addAll(linkedHashSet, signatureBuildingComponents.inJavaLang(strAsString, jvmPrimitiveType.getJavaKeywordName() + "Value()" + jvmPrimitiveType.getDesc()));
        }
        return linkedHashSet;
    }

    private final java.util.Set<java.lang.String> buildPrimitiveStringConstructorsSet() {
        kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents signatureBuildingComponents = kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents.INSTANCE;
        java.util.List listListOf = kotlin.collections.CollectionsKt.listOf((java.lang.Object[]) new kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType[]{kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType.BOOLEAN, kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType.BYTE, kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType.DOUBLE, kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType.FLOAT, kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType.BYTE, kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType.INT, kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType.LONG, kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType.SHORT});
        java.util.LinkedHashSet linkedHashSet = new java.util.LinkedHashSet();
        java.util.Iterator it = listListOf.iterator();
        while (it.hasNext()) {
            java.lang.String strAsString = ((kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType) it.next()).getWrapperFqName().shortName().asString();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strAsString, "asString(...)");
            java.lang.String[] strArrConstructors = signatureBuildingComponents.constructors("Ljava/lang/String;");
            kotlin.collections.CollectionsKt.addAll(linkedHashSet, signatureBuildingComponents.inJavaLang(strAsString, (java.lang.String[]) java.util.Arrays.copyOf(strArrConstructors, strArrConstructors.length)));
        }
        return linkedHashSet;
    }
}
