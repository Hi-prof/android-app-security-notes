package kotlin.reflect.jvm.internal.impl.builtins;

/* JADX INFO: compiled from: StandardNames.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StandardNames {
    public static final kotlin.reflect.jvm.internal.impl.name.FqName ANNOTATION_PACKAGE_FQ_NAME;
    public static final kotlin.reflect.jvm.internal.impl.name.Name BACKING_FIELD;
    public static final kotlin.reflect.jvm.internal.impl.name.FqName BUILT_INS_PACKAGE_FQ_NAME;
    public static final java.util.Set<kotlin.reflect.jvm.internal.impl.name.FqName> BUILT_INS_PACKAGE_FQ_NAMES;
    public static final kotlin.reflect.jvm.internal.impl.name.Name BUILT_INS_PACKAGE_NAME;
    public static final kotlin.reflect.jvm.internal.impl.name.Name CHAR_CODE;
    public static final kotlin.reflect.jvm.internal.impl.name.FqName COLLECTIONS_PACKAGE_FQ_NAME;
    public static final kotlin.reflect.jvm.internal.impl.name.FqName CONCURRENT_ATOMICS_PACKAGE_FQ_NAME;
    public static final kotlin.reflect.jvm.internal.impl.name.FqName CONCURRENT_PACKAGE_FQ_NAME;
    public static final kotlin.reflect.jvm.internal.impl.name.Name CONTEXT_FUNCTION_TYPE_PARAMETER_COUNT_NAME;
    public static final kotlin.reflect.jvm.internal.impl.name.FqName CONTINUATION_INTERFACE_FQ_NAME;
    public static final kotlin.reflect.jvm.internal.impl.name.FqName COROUTINES_INTRINSICS_PACKAGE_FQ_NAME;
    public static final kotlin.reflect.jvm.internal.impl.name.FqName COROUTINES_JVM_INTERNAL_PACKAGE_FQ_NAME;
    public static final kotlin.reflect.jvm.internal.impl.name.FqName COROUTINES_PACKAGE_FQ_NAME;
    public static final kotlin.reflect.jvm.internal.impl.name.Name COROUTINE_SUSPENDED_NAME;
    public static final java.lang.String DATA_CLASS_COMPONENT_PREFIX;
    public static final kotlin.reflect.jvm.internal.impl.name.Name DATA_CLASS_COPY;
    public static final kotlin.reflect.jvm.internal.impl.name.Name DEFAULT_VALUE_PARAMETER;
    public static final kotlin.reflect.jvm.internal.impl.name.FqName DYNAMIC_FQ_NAME;
    public static final kotlin.reflect.jvm.internal.impl.name.Name ENUM_ENTRIES;
    public static final kotlin.reflect.jvm.internal.impl.name.Name ENUM_VALUES;
    public static final kotlin.reflect.jvm.internal.impl.name.Name ENUM_VALUE_OF;
    public static final kotlin.reflect.jvm.internal.impl.name.Name EQUALS_NAME;
    public static final kotlin.reflect.jvm.internal.impl.name.Name HASHCODE_NAME;
    public static final kotlin.reflect.jvm.internal.impl.name.Name IMPLICIT_LAMBDA_PARAMETER_NAME;
    public static final kotlin.reflect.jvm.internal.impl.builtins.StandardNames INSTANCE = new kotlin.reflect.jvm.internal.impl.builtins.StandardNames();
    public static final kotlin.reflect.jvm.internal.impl.name.FqName KOTLIN_INTERNAL_FQ_NAME;
    public static final kotlin.reflect.jvm.internal.impl.name.FqName KOTLIN_REFLECT_FQ_NAME;
    public static final kotlin.reflect.jvm.internal.impl.name.Name MAIN;
    public static final kotlin.reflect.jvm.internal.impl.name.Name NAME;
    public static final kotlin.reflect.jvm.internal.impl.name.Name NEXT_CHAR;
    private static final kotlin.reflect.jvm.internal.impl.name.FqName NON_EXISTENT_CLASS;
    public static final java.util.List<java.lang.String> PREFIXES;
    public static final kotlin.reflect.jvm.internal.impl.name.FqName RANGES_PACKAGE_FQ_NAME;
    public static final kotlin.reflect.jvm.internal.impl.name.FqName RESULT_FQ_NAME;
    public static final kotlin.reflect.jvm.internal.impl.name.FqName TEXT_PACKAGE_FQ_NAME;
    public static final kotlin.reflect.jvm.internal.impl.name.Name TO_STRING_NAME;

    private StandardNames() {
    }

    static {
        kotlin.reflect.jvm.internal.impl.name.Name nameIdentifier = kotlin.reflect.jvm.internal.impl.name.Name.identifier("field");
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameIdentifier, "identifier(...)");
        BACKING_FIELD = nameIdentifier;
        kotlin.reflect.jvm.internal.impl.name.Name nameIdentifier2 = kotlin.reflect.jvm.internal.impl.name.Name.identifier("value");
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameIdentifier2, "identifier(...)");
        DEFAULT_VALUE_PARAMETER = nameIdentifier2;
        kotlin.reflect.jvm.internal.impl.name.Name nameIdentifier3 = kotlin.reflect.jvm.internal.impl.name.Name.identifier("values");
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameIdentifier3, "identifier(...)");
        ENUM_VALUES = nameIdentifier3;
        kotlin.reflect.jvm.internal.impl.name.Name nameIdentifier4 = kotlin.reflect.jvm.internal.impl.name.Name.identifier("entries");
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameIdentifier4, "identifier(...)");
        ENUM_ENTRIES = nameIdentifier4;
        kotlin.reflect.jvm.internal.impl.name.Name nameIdentifier5 = kotlin.reflect.jvm.internal.impl.name.Name.identifier("valueOf");
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameIdentifier5, "identifier(...)");
        ENUM_VALUE_OF = nameIdentifier5;
        kotlin.reflect.jvm.internal.impl.name.Name nameIdentifier6 = kotlin.reflect.jvm.internal.impl.name.Name.identifier("copy");
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameIdentifier6, "identifier(...)");
        DATA_CLASS_COPY = nameIdentifier6;
        DATA_CLASS_COMPONENT_PREFIX = com.taobao.weex.bridge.WXBridgeManager.COMPONENT;
        kotlin.reflect.jvm.internal.impl.name.Name nameIdentifier7 = kotlin.reflect.jvm.internal.impl.name.Name.identifier("hashCode");
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameIdentifier7, "identifier(...)");
        HASHCODE_NAME = nameIdentifier7;
        kotlin.reflect.jvm.internal.impl.name.Name nameIdentifier8 = kotlin.reflect.jvm.internal.impl.name.Name.identifier("toString");
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameIdentifier8, "identifier(...)");
        TO_STRING_NAME = nameIdentifier8;
        kotlin.reflect.jvm.internal.impl.name.Name nameIdentifier9 = kotlin.reflect.jvm.internal.impl.name.Name.identifier("equals");
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameIdentifier9, "identifier(...)");
        EQUALS_NAME = nameIdentifier9;
        kotlin.reflect.jvm.internal.impl.name.Name nameIdentifier10 = kotlin.reflect.jvm.internal.impl.name.Name.identifier("code");
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameIdentifier10, "identifier(...)");
        CHAR_CODE = nameIdentifier10;
        kotlin.reflect.jvm.internal.impl.name.Name nameIdentifier11 = kotlin.reflect.jvm.internal.impl.name.Name.identifier("name");
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameIdentifier11, "identifier(...)");
        NAME = nameIdentifier11;
        kotlin.reflect.jvm.internal.impl.name.Name nameIdentifier12 = kotlin.reflect.jvm.internal.impl.name.Name.identifier("main");
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameIdentifier12, "identifier(...)");
        MAIN = nameIdentifier12;
        kotlin.reflect.jvm.internal.impl.name.Name nameIdentifier13 = kotlin.reflect.jvm.internal.impl.name.Name.identifier("nextChar");
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameIdentifier13, "identifier(...)");
        NEXT_CHAR = nameIdentifier13;
        kotlin.reflect.jvm.internal.impl.name.Name nameIdentifier14 = kotlin.reflect.jvm.internal.impl.name.Name.identifier("it");
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameIdentifier14, "identifier(...)");
        IMPLICIT_LAMBDA_PARAMETER_NAME = nameIdentifier14;
        kotlin.reflect.jvm.internal.impl.name.Name nameIdentifier15 = kotlin.reflect.jvm.internal.impl.name.Name.identifier("count");
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameIdentifier15, "identifier(...)");
        CONTEXT_FUNCTION_TYPE_PARAMETER_COUNT_NAME = nameIdentifier15;
        DYNAMIC_FQ_NAME = new kotlin.reflect.jvm.internal.impl.name.FqName("<dynamic>");
        kotlin.reflect.jvm.internal.impl.name.FqName fqName = new kotlin.reflect.jvm.internal.impl.name.FqName("kotlin.coroutines");
        COROUTINES_PACKAGE_FQ_NAME = fqName;
        COROUTINES_JVM_INTERNAL_PACKAGE_FQ_NAME = new kotlin.reflect.jvm.internal.impl.name.FqName("kotlin.coroutines.jvm.internal");
        COROUTINES_INTRINSICS_PACKAGE_FQ_NAME = new kotlin.reflect.jvm.internal.impl.name.FqName("kotlin.coroutines.intrinsics");
        kotlin.reflect.jvm.internal.impl.name.Name nameIdentifier16 = kotlin.reflect.jvm.internal.impl.name.Name.identifier("COROUTINE_SUSPENDED");
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameIdentifier16, "identifier(...)");
        COROUTINE_SUSPENDED_NAME = nameIdentifier16;
        kotlin.reflect.jvm.internal.impl.name.Name nameIdentifier17 = kotlin.reflect.jvm.internal.impl.name.Name.identifier("Continuation");
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameIdentifier17, "identifier(...)");
        CONTINUATION_INTERFACE_FQ_NAME = fqName.child(nameIdentifier17);
        RESULT_FQ_NAME = new kotlin.reflect.jvm.internal.impl.name.FqName("kotlin.Result");
        kotlin.reflect.jvm.internal.impl.name.FqName fqName2 = new kotlin.reflect.jvm.internal.impl.name.FqName("kotlin.reflect");
        KOTLIN_REFLECT_FQ_NAME = fqName2;
        PREFIXES = kotlin.collections.CollectionsKt.listOf((java.lang.Object[]) new java.lang.String[]{"KProperty", "KMutableProperty", "KFunction", "KSuspendFunction"});
        kotlin.reflect.jvm.internal.impl.name.Name nameIdentifier18 = kotlin.reflect.jvm.internal.impl.name.Name.identifier("kotlin");
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameIdentifier18, "identifier(...)");
        BUILT_INS_PACKAGE_NAME = nameIdentifier18;
        kotlin.reflect.jvm.internal.impl.name.FqName fqName3 = kotlin.reflect.jvm.internal.impl.name.FqName.Companion.topLevel(nameIdentifier18);
        BUILT_INS_PACKAGE_FQ_NAME = fqName3;
        kotlin.reflect.jvm.internal.impl.name.Name nameIdentifier19 = kotlin.reflect.jvm.internal.impl.name.Name.identifier("annotation");
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameIdentifier19, "identifier(...)");
        kotlin.reflect.jvm.internal.impl.name.FqName fqNameChild = fqName3.child(nameIdentifier19);
        ANNOTATION_PACKAGE_FQ_NAME = fqNameChild;
        kotlin.reflect.jvm.internal.impl.name.Name nameIdentifier20 = kotlin.reflect.jvm.internal.impl.name.Name.identifier("collections");
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameIdentifier20, "identifier(...)");
        kotlin.reflect.jvm.internal.impl.name.FqName fqNameChild2 = fqName3.child(nameIdentifier20);
        COLLECTIONS_PACKAGE_FQ_NAME = fqNameChild2;
        kotlin.reflect.jvm.internal.impl.name.Name nameIdentifier21 = kotlin.reflect.jvm.internal.impl.name.Name.identifier("ranges");
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameIdentifier21, "identifier(...)");
        kotlin.reflect.jvm.internal.impl.name.FqName fqNameChild3 = fqName3.child(nameIdentifier21);
        RANGES_PACKAGE_FQ_NAME = fqNameChild3;
        kotlin.reflect.jvm.internal.impl.name.Name nameIdentifier22 = kotlin.reflect.jvm.internal.impl.name.Name.identifier("text");
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameIdentifier22, "identifier(...)");
        TEXT_PACKAGE_FQ_NAME = fqName3.child(nameIdentifier22);
        kotlin.reflect.jvm.internal.impl.name.Name nameIdentifier23 = kotlin.reflect.jvm.internal.impl.name.Name.identifier("internal");
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameIdentifier23, "identifier(...)");
        kotlin.reflect.jvm.internal.impl.name.FqName fqNameChild4 = fqName3.child(nameIdentifier23);
        KOTLIN_INTERNAL_FQ_NAME = fqNameChild4;
        kotlin.reflect.jvm.internal.impl.name.Name nameIdentifier24 = kotlin.reflect.jvm.internal.impl.name.Name.identifier("concurrent");
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameIdentifier24, "identifier(...)");
        kotlin.reflect.jvm.internal.impl.name.FqName fqNameChild5 = fqName3.child(nameIdentifier24);
        CONCURRENT_PACKAGE_FQ_NAME = fqNameChild5;
        kotlin.reflect.jvm.internal.impl.name.Name nameIdentifier25 = kotlin.reflect.jvm.internal.impl.name.Name.identifier("atomics");
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameIdentifier25, "identifier(...)");
        kotlin.reflect.jvm.internal.impl.name.FqName fqNameChild6 = fqNameChild5.child(nameIdentifier25);
        CONCURRENT_ATOMICS_PACKAGE_FQ_NAME = fqNameChild6;
        NON_EXISTENT_CLASS = new kotlin.reflect.jvm.internal.impl.name.FqName("error.NonExistentClass");
        BUILT_INS_PACKAGE_FQ_NAMES = kotlin.collections.SetsKt.setOf((java.lang.Object[]) new kotlin.reflect.jvm.internal.impl.name.FqName[]{fqName3, fqNameChild2, fqNameChild3, fqNameChild, fqName2, fqNameChild4, fqName, fqNameChild6});
    }

    /* JADX INFO: compiled from: StandardNames.kt */
    public static final class FqNames {
        public static final kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames INSTANCE;
        public static final kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe _boolean;
        public static final kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe _byte;
        public static final kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe _char;
        public static final kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe _double;
        public static final kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe _enum;
        public static final kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe _float;
        public static final kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe _int;
        public static final kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe _long;
        public static final kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe _short;
        public static final kotlin.reflect.jvm.internal.impl.name.FqName accessibleLateinitPropertyLiteral;
        public static final kotlin.reflect.jvm.internal.impl.name.FqName annotation;
        public static final kotlin.reflect.jvm.internal.impl.name.FqName annotationRetention;
        public static final kotlin.reflect.jvm.internal.impl.name.FqName annotationTarget;
        public static final kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe any;
        public static final kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe array;
        public static final java.util.Map<kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe, kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType> arrayClassFqNameToPrimitiveType;
        public static final kotlin.reflect.jvm.internal.impl.name.FqName atomicArray;
        public static final kotlin.reflect.jvm.internal.impl.name.FqName atomicBoolean;
        public static final kotlin.reflect.jvm.internal.impl.name.FqName atomicInt;
        public static final kotlin.reflect.jvm.internal.impl.name.FqName atomicIntArray;
        public static final kotlin.reflect.jvm.internal.impl.name.FqName atomicLong;
        public static final kotlin.reflect.jvm.internal.impl.name.FqName atomicLongArray;
        public static final kotlin.reflect.jvm.internal.impl.name.FqName atomicReference;
        public static final kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe charSequence;
        public static final kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe cloneable;
        public static final kotlin.reflect.jvm.internal.impl.name.FqName collection;
        public static final kotlin.reflect.jvm.internal.impl.name.FqName comparable;
        public static final kotlin.reflect.jvm.internal.impl.name.FqName contextFunctionTypeParams;
        public static final kotlin.reflect.jvm.internal.impl.name.FqName deprecated;
        public static final kotlin.reflect.jvm.internal.impl.name.FqName deprecatedSinceKotlin;
        public static final kotlin.reflect.jvm.internal.impl.name.FqName deprecationLevel;
        public static final kotlin.reflect.jvm.internal.impl.name.FqName extensionFunctionType;
        public static final kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe findAssociatedObject;
        public static final java.util.Map<kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe, kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType> fqNameToPrimitiveType;
        public static final kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe functionSupertype;
        public static final kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe intRange;
        public static final kotlin.reflect.jvm.internal.impl.name.FqName iterable;
        public static final kotlin.reflect.jvm.internal.impl.name.FqName iterator;
        public static final kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe kCallable;
        public static final kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe kClass;
        public static final kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe kDeclarationContainer;
        public static final kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe kMutableProperty0;
        public static final kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe kMutableProperty1;
        public static final kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe kMutableProperty2;
        public static final kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe kMutablePropertyFqName;
        public static final kotlin.reflect.jvm.internal.impl.name.ClassId kProperty;
        public static final kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe kProperty0;
        public static final kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe kProperty1;
        public static final kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe kProperty2;
        public static final kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe kPropertyFqName;
        public static final kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe kType;
        public static final kotlin.reflect.jvm.internal.impl.name.FqName list;
        public static final kotlin.reflect.jvm.internal.impl.name.FqName listIterator;
        public static final kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe longRange;
        public static final kotlin.reflect.jvm.internal.impl.name.FqName map;
        public static final kotlin.reflect.jvm.internal.impl.name.FqName mapEntry;
        public static final kotlin.reflect.jvm.internal.impl.name.FqName mustBeDocumented;
        public static final kotlin.reflect.jvm.internal.impl.name.FqName mutableCollection;
        public static final kotlin.reflect.jvm.internal.impl.name.FqName mutableIterable;
        public static final kotlin.reflect.jvm.internal.impl.name.FqName mutableIterator;
        public static final kotlin.reflect.jvm.internal.impl.name.FqName mutableList;
        public static final kotlin.reflect.jvm.internal.impl.name.FqName mutableListIterator;
        public static final kotlin.reflect.jvm.internal.impl.name.FqName mutableMap;
        public static final kotlin.reflect.jvm.internal.impl.name.FqName mutableMapEntry;
        public static final kotlin.reflect.jvm.internal.impl.name.FqName mutableSet;
        public static final kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe nothing;
        public static final kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe number;
        public static final kotlin.reflect.jvm.internal.impl.name.FqName parameterName;
        public static final kotlin.reflect.jvm.internal.impl.name.ClassId parameterNameClassId;
        public static final kotlin.reflect.jvm.internal.impl.name.FqName platformDependent;
        public static final kotlin.reflect.jvm.internal.impl.name.ClassId platformDependentClassId;
        public static final java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> primitiveArrayTypeShortNames;
        public static final java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> primitiveTypeShortNames;
        public static final kotlin.reflect.jvm.internal.impl.name.FqName publishedApi;
        public static final kotlin.reflect.jvm.internal.impl.name.FqName repeatable;
        public static final kotlin.reflect.jvm.internal.impl.name.ClassId repeatableClassId;
        public static final kotlin.reflect.jvm.internal.impl.name.FqName replaceWith;
        public static final kotlin.reflect.jvm.internal.impl.name.FqName retention;
        public static final kotlin.reflect.jvm.internal.impl.name.ClassId retentionClassId;
        public static final kotlin.reflect.jvm.internal.impl.name.FqName set;
        public static final kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe string;
        public static final kotlin.reflect.jvm.internal.impl.name.FqName suppress;
        public static final kotlin.reflect.jvm.internal.impl.name.FqName target;
        public static final kotlin.reflect.jvm.internal.impl.name.ClassId targetClassId;
        public static final kotlin.reflect.jvm.internal.impl.name.FqName throwable;
        public static final kotlin.reflect.jvm.internal.impl.name.ClassId uByte;
        public static final kotlin.reflect.jvm.internal.impl.name.FqName uByteArrayFqName;
        public static final kotlin.reflect.jvm.internal.impl.name.FqName uByteFqName;
        public static final kotlin.reflect.jvm.internal.impl.name.ClassId uInt;
        public static final kotlin.reflect.jvm.internal.impl.name.FqName uIntArrayFqName;
        public static final kotlin.reflect.jvm.internal.impl.name.FqName uIntFqName;
        public static final kotlin.reflect.jvm.internal.impl.name.ClassId uLong;
        public static final kotlin.reflect.jvm.internal.impl.name.FqName uLongArrayFqName;
        public static final kotlin.reflect.jvm.internal.impl.name.FqName uLongFqName;
        public static final kotlin.reflect.jvm.internal.impl.name.ClassId uShort;
        public static final kotlin.reflect.jvm.internal.impl.name.FqName uShortArrayFqName;
        public static final kotlin.reflect.jvm.internal.impl.name.FqName uShortFqName;
        public static final kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe unit;
        public static final kotlin.reflect.jvm.internal.impl.name.FqName unsafeVariance;

        private FqNames() {
        }

        static {
            kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames fqNames = new kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames();
            INSTANCE = fqNames;
            any = fqNames.fqNameUnsafe("Any");
            nothing = fqNames.fqNameUnsafe("Nothing");
            cloneable = fqNames.fqNameUnsafe("Cloneable");
            suppress = fqNames.fqName("Suppress");
            unit = fqNames.fqNameUnsafe("Unit");
            charSequence = fqNames.fqNameUnsafe("CharSequence");
            string = fqNames.fqNameUnsafe("String");
            array = fqNames.fqNameUnsafe("Array");
            _boolean = fqNames.fqNameUnsafe("Boolean");
            _char = fqNames.fqNameUnsafe("Char");
            _byte = fqNames.fqNameUnsafe("Byte");
            _short = fqNames.fqNameUnsafe("Short");
            _int = fqNames.fqNameUnsafe("Int");
            _long = fqNames.fqNameUnsafe("Long");
            _float = fqNames.fqNameUnsafe("Float");
            _double = fqNames.fqNameUnsafe("Double");
            number = fqNames.fqNameUnsafe("Number");
            _enum = fqNames.fqNameUnsafe("Enum");
            functionSupertype = fqNames.fqNameUnsafe("Function");
            throwable = fqNames.fqName("Throwable");
            comparable = fqNames.fqName("Comparable");
            intRange = fqNames.rangesFqName("IntRange");
            longRange = fqNames.rangesFqName("LongRange");
            deprecated = fqNames.fqName("Deprecated");
            deprecatedSinceKotlin = fqNames.fqName("DeprecatedSinceKotlin");
            deprecationLevel = fqNames.fqName("DeprecationLevel");
            replaceWith = fqNames.fqName("ReplaceWith");
            extensionFunctionType = fqNames.fqName("ExtensionFunctionType");
            contextFunctionTypeParams = fqNames.fqName("ContextFunctionTypeParams");
            kotlin.reflect.jvm.internal.impl.name.FqName fqName = fqNames.fqName("ParameterName");
            parameterName = fqName;
            parameterNameClassId = kotlin.reflect.jvm.internal.impl.name.ClassId.Companion.topLevel(fqName);
            annotation = fqNames.fqName("Annotation");
            kotlin.reflect.jvm.internal.impl.name.FqName fqNameAnnotationName = fqNames.annotationName("Target");
            target = fqNameAnnotationName;
            targetClassId = kotlin.reflect.jvm.internal.impl.name.ClassId.Companion.topLevel(fqNameAnnotationName);
            annotationTarget = fqNames.annotationName("AnnotationTarget");
            annotationRetention = fqNames.annotationName("AnnotationRetention");
            kotlin.reflect.jvm.internal.impl.name.FqName fqNameAnnotationName2 = fqNames.annotationName("Retention");
            retention = fqNameAnnotationName2;
            retentionClassId = kotlin.reflect.jvm.internal.impl.name.ClassId.Companion.topLevel(fqNameAnnotationName2);
            kotlin.reflect.jvm.internal.impl.name.FqName fqNameAnnotationName3 = fqNames.annotationName("Repeatable");
            repeatable = fqNameAnnotationName3;
            repeatableClassId = kotlin.reflect.jvm.internal.impl.name.ClassId.Companion.topLevel(fqNameAnnotationName3);
            mustBeDocumented = fqNames.annotationName("MustBeDocumented");
            unsafeVariance = fqNames.fqName("UnsafeVariance");
            publishedApi = fqNames.fqName("PublishedApi");
            accessibleLateinitPropertyLiteral = fqNames.internalName("AccessibleLateinitPropertyLiteral");
            kotlin.reflect.jvm.internal.impl.name.FqName fqName2 = new kotlin.reflect.jvm.internal.impl.name.FqName("kotlin.internal.PlatformDependent");
            platformDependent = fqName2;
            platformDependentClassId = kotlin.reflect.jvm.internal.impl.name.ClassId.Companion.topLevel(fqName2);
            iterator = fqNames.collectionsFqName("Iterator");
            iterable = fqNames.collectionsFqName("Iterable");
            collection = fqNames.collectionsFqName("Collection");
            list = fqNames.collectionsFqName("List");
            listIterator = fqNames.collectionsFqName("ListIterator");
            set = fqNames.collectionsFqName("Set");
            kotlin.reflect.jvm.internal.impl.name.FqName fqNameCollectionsFqName = fqNames.collectionsFqName("Map");
            map = fqNameCollectionsFqName;
            kotlin.reflect.jvm.internal.impl.name.Name nameIdentifier = kotlin.reflect.jvm.internal.impl.name.Name.identifier("Entry");
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameIdentifier, "identifier(...)");
            mapEntry = fqNameCollectionsFqName.child(nameIdentifier);
            mutableIterator = fqNames.collectionsFqName("MutableIterator");
            mutableIterable = fqNames.collectionsFqName("MutableIterable");
            mutableCollection = fqNames.collectionsFqName("MutableCollection");
            mutableList = fqNames.collectionsFqName("MutableList");
            mutableListIterator = fqNames.collectionsFqName("MutableListIterator");
            mutableSet = fqNames.collectionsFqName("MutableSet");
            kotlin.reflect.jvm.internal.impl.name.FqName fqNameCollectionsFqName2 = fqNames.collectionsFqName("MutableMap");
            mutableMap = fqNameCollectionsFqName2;
            kotlin.reflect.jvm.internal.impl.name.Name nameIdentifier2 = kotlin.reflect.jvm.internal.impl.name.Name.identifier("MutableEntry");
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameIdentifier2, "identifier(...)");
            mutableMapEntry = fqNameCollectionsFqName2.child(nameIdentifier2);
            kClass = reflect("KClass");
            kType = reflect("KType");
            kCallable = reflect("KCallable");
            kProperty0 = reflect("KProperty0");
            kProperty1 = reflect("KProperty1");
            kProperty2 = reflect("KProperty2");
            kMutableProperty0 = reflect("KMutableProperty0");
            kMutableProperty1 = reflect("KMutableProperty1");
            kMutableProperty2 = reflect("KMutableProperty2");
            kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe fqNameUnsafeReflect = reflect("KProperty");
            kPropertyFqName = fqNameUnsafeReflect;
            kMutablePropertyFqName = reflect("KMutableProperty");
            kProperty = kotlin.reflect.jvm.internal.impl.name.ClassId.Companion.topLevel(fqNameUnsafeReflect.toSafe());
            kDeclarationContainer = reflect("KDeclarationContainer");
            findAssociatedObject = reflect("findAssociatedObject");
            kotlin.reflect.jvm.internal.impl.name.FqName fqName3 = fqNames.fqName("UByte");
            uByteFqName = fqName3;
            kotlin.reflect.jvm.internal.impl.name.FqName fqName4 = fqNames.fqName("UShort");
            uShortFqName = fqName4;
            kotlin.reflect.jvm.internal.impl.name.FqName fqName5 = fqNames.fqName("UInt");
            uIntFqName = fqName5;
            kotlin.reflect.jvm.internal.impl.name.FqName fqName6 = fqNames.fqName("ULong");
            uLongFqName = fqName6;
            uByte = kotlin.reflect.jvm.internal.impl.name.ClassId.Companion.topLevel(fqName3);
            uShort = kotlin.reflect.jvm.internal.impl.name.ClassId.Companion.topLevel(fqName4);
            uInt = kotlin.reflect.jvm.internal.impl.name.ClassId.Companion.topLevel(fqName5);
            uLong = kotlin.reflect.jvm.internal.impl.name.ClassId.Companion.topLevel(fqName6);
            uByteArrayFqName = fqNames.fqName("UByteArray");
            uShortArrayFqName = fqNames.fqName("UShortArray");
            uIntArrayFqName = fqNames.fqName("UIntArray");
            uLongArrayFqName = fqNames.fqName("ULongArray");
            atomicInt = fqNames.concurrentAtomics("AtomicInt");
            atomicLong = fqNames.concurrentAtomics("AtomicLong");
            atomicBoolean = fqNames.concurrentAtomics("AtomicBoolean");
            atomicReference = fqNames.concurrentAtomics("AtomicReference");
            atomicIntArray = fqNames.concurrentAtomics("AtomicIntArray");
            atomicLongArray = fqNames.concurrentAtomics("AtomicLongArray");
            atomicArray = fqNames.concurrentAtomics("AtomicArray");
            java.util.HashSet hashSetNewHashSetWithExpectedSize = kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.newHashSetWithExpectedSize(kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType.values().length);
            for (kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType primitiveType : kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType.values()) {
                hashSetNewHashSetWithExpectedSize.add(primitiveType.getTypeName());
            }
            primitiveTypeShortNames = hashSetNewHashSetWithExpectedSize;
            java.util.HashSet hashSetNewHashSetWithExpectedSize2 = kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.newHashSetWithExpectedSize(kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType.values().length);
            for (kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType primitiveType2 : kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType.values()) {
                hashSetNewHashSetWithExpectedSize2.add(primitiveType2.getArrayTypeName());
            }
            primitiveArrayTypeShortNames = hashSetNewHashSetWithExpectedSize2;
            java.util.HashMap mapNewHashMapWithExpectedSize = kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.newHashMapWithExpectedSize(kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType.values().length);
            for (kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType primitiveType3 : kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType.values()) {
                kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames fqNames2 = INSTANCE;
                java.lang.String strAsString = primitiveType3.getTypeName().asString();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strAsString, "asString(...)");
                mapNewHashMapWithExpectedSize.put(fqNames2.fqNameUnsafe(strAsString), primitiveType3);
            }
            fqNameToPrimitiveType = mapNewHashMapWithExpectedSize;
            java.util.HashMap mapNewHashMapWithExpectedSize2 = kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.newHashMapWithExpectedSize(kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType.values().length);
            for (kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType primitiveType4 : kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType.values()) {
                kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames fqNames3 = INSTANCE;
                java.lang.String strAsString2 = primitiveType4.getArrayTypeName().asString();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strAsString2, "asString(...)");
                mapNewHashMapWithExpectedSize2.put(fqNames3.fqNameUnsafe(strAsString2), primitiveType4);
            }
            arrayClassFqNameToPrimitiveType = mapNewHashMapWithExpectedSize2;
        }

        private final kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe fqNameUnsafe(java.lang.String str) {
            return fqName(str).toUnsafe();
        }

        private final kotlin.reflect.jvm.internal.impl.name.FqName fqName(java.lang.String str) {
            kotlin.reflect.jvm.internal.impl.name.FqName fqName = kotlin.reflect.jvm.internal.impl.builtins.StandardNames.BUILT_INS_PACKAGE_FQ_NAME;
            kotlin.reflect.jvm.internal.impl.name.Name nameIdentifier = kotlin.reflect.jvm.internal.impl.name.Name.identifier(str);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameIdentifier, "identifier(...)");
            return fqName.child(nameIdentifier);
        }

        private final kotlin.reflect.jvm.internal.impl.name.FqName collectionsFqName(java.lang.String str) {
            kotlin.reflect.jvm.internal.impl.name.FqName fqName = kotlin.reflect.jvm.internal.impl.builtins.StandardNames.COLLECTIONS_PACKAGE_FQ_NAME;
            kotlin.reflect.jvm.internal.impl.name.Name nameIdentifier = kotlin.reflect.jvm.internal.impl.name.Name.identifier(str);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameIdentifier, "identifier(...)");
            return fqName.child(nameIdentifier);
        }

        private final kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe rangesFqName(java.lang.String str) {
            kotlin.reflect.jvm.internal.impl.name.FqName fqName = kotlin.reflect.jvm.internal.impl.builtins.StandardNames.RANGES_PACKAGE_FQ_NAME;
            kotlin.reflect.jvm.internal.impl.name.Name nameIdentifier = kotlin.reflect.jvm.internal.impl.name.Name.identifier(str);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameIdentifier, "identifier(...)");
            return fqName.child(nameIdentifier).toUnsafe();
        }

        @kotlin.jvm.JvmStatic
        public static final kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe reflect(java.lang.String simpleName) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(simpleName, "simpleName");
            kotlin.reflect.jvm.internal.impl.name.FqName fqName = kotlin.reflect.jvm.internal.impl.builtins.StandardNames.KOTLIN_REFLECT_FQ_NAME;
            kotlin.reflect.jvm.internal.impl.name.Name nameIdentifier = kotlin.reflect.jvm.internal.impl.name.Name.identifier(simpleName);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameIdentifier, "identifier(...)");
            return fqName.child(nameIdentifier).toUnsafe();
        }

        private final kotlin.reflect.jvm.internal.impl.name.FqName annotationName(java.lang.String str) {
            kotlin.reflect.jvm.internal.impl.name.FqName fqName = kotlin.reflect.jvm.internal.impl.builtins.StandardNames.ANNOTATION_PACKAGE_FQ_NAME;
            kotlin.reflect.jvm.internal.impl.name.Name nameIdentifier = kotlin.reflect.jvm.internal.impl.name.Name.identifier(str);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameIdentifier, "identifier(...)");
            return fqName.child(nameIdentifier);
        }

        private final kotlin.reflect.jvm.internal.impl.name.FqName internalName(java.lang.String str) {
            kotlin.reflect.jvm.internal.impl.name.FqName fqName = kotlin.reflect.jvm.internal.impl.builtins.StandardNames.KOTLIN_INTERNAL_FQ_NAME;
            kotlin.reflect.jvm.internal.impl.name.Name nameIdentifier = kotlin.reflect.jvm.internal.impl.name.Name.identifier(str);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameIdentifier, "identifier(...)");
            return fqName.child(nameIdentifier);
        }

        private final kotlin.reflect.jvm.internal.impl.name.FqName concurrentAtomics(java.lang.String str) {
            kotlin.reflect.jvm.internal.impl.name.FqName fqName = kotlin.reflect.jvm.internal.impl.builtins.StandardNames.CONCURRENT_ATOMICS_PACKAGE_FQ_NAME;
            kotlin.reflect.jvm.internal.impl.name.Name nameIdentifier = kotlin.reflect.jvm.internal.impl.name.Name.identifier(str);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameIdentifier, "identifier(...)");
            return fqName.child(nameIdentifier);
        }
    }

    @kotlin.jvm.JvmStatic
    public static final java.lang.String getFunctionName(int i) {
        return "Function" + i;
    }

    @kotlin.jvm.JvmStatic
    public static final kotlin.reflect.jvm.internal.impl.name.ClassId getFunctionClassId(int i) {
        kotlin.reflect.jvm.internal.impl.name.FqName fqName = BUILT_INS_PACKAGE_FQ_NAME;
        kotlin.reflect.jvm.internal.impl.name.Name nameIdentifier = kotlin.reflect.jvm.internal.impl.name.Name.identifier(getFunctionName(i));
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameIdentifier, "identifier(...)");
        return new kotlin.reflect.jvm.internal.impl.name.ClassId(fqName, nameIdentifier);
    }

    @kotlin.jvm.JvmStatic
    public static final java.lang.String getSuspendFunctionName(int i) {
        return kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKind.SuspendFunction.INSTANCE.getClassNamePrefix() + i;
    }

    @kotlin.jvm.JvmStatic
    public static final boolean isPrimitiveArray(kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe arrayFqName) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(arrayFqName, "arrayFqName");
        return kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.arrayClassFqNameToPrimitiveType.get(arrayFqName) != null;
    }

    @kotlin.jvm.JvmStatic
    public static final kotlin.reflect.jvm.internal.impl.name.FqName getPrimitiveFqName(kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType primitiveType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(primitiveType, "primitiveType");
        return BUILT_INS_PACKAGE_FQ_NAME.child(primitiveType.getTypeName());
    }
}
