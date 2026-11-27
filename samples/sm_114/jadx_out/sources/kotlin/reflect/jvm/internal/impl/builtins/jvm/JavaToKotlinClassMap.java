package kotlin.reflect.jvm.internal.impl.builtins.jvm;

/* JADX INFO: compiled from: JavaToKotlinClassMap.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class JavaToKotlinClassMap {
    private static final kotlin.reflect.jvm.internal.impl.name.ClassId CLASS_CLASS_ID;
    private static final kotlin.reflect.jvm.internal.impl.name.ClassId FUNCTION_N_CLASS_ID;
    private static final kotlin.reflect.jvm.internal.impl.name.FqName FUNCTION_N_FQ_NAME;
    public static final kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap INSTANCE;
    private static final kotlin.reflect.jvm.internal.impl.name.ClassId K_CLASS_CLASS_ID;
    private static final kotlin.reflect.jvm.internal.impl.name.ClassId K_FUNCTION_CLASS_ID;
    private static final java.lang.String NUMBERED_FUNCTION_PREFIX;
    private static final java.lang.String NUMBERED_K_FUNCTION_PREFIX;
    private static final java.lang.String NUMBERED_K_SUSPEND_FUNCTION_PREFIX;
    private static final java.lang.String NUMBERED_SUSPEND_FUNCTION_PREFIX;
    private static final java.util.HashMap<kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe, kotlin.reflect.jvm.internal.impl.name.ClassId> javaToKotlin;
    private static final java.util.HashMap<kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe, kotlin.reflect.jvm.internal.impl.name.ClassId> kotlinToJava;
    private static final java.util.List<kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap.PlatformMutabilityMapping> mutabilityMappings;
    private static final java.util.HashMap<kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe, kotlin.reflect.jvm.internal.impl.name.FqName> mutableToReadOnly;
    private static final java.util.HashMap<kotlin.reflect.jvm.internal.impl.name.ClassId, kotlin.reflect.jvm.internal.impl.name.ClassId> mutableToReadOnlyClassId;
    private static final java.util.HashMap<kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe, kotlin.reflect.jvm.internal.impl.name.FqName> readOnlyToMutable;
    private static final java.util.HashMap<kotlin.reflect.jvm.internal.impl.name.ClassId, kotlin.reflect.jvm.internal.impl.name.ClassId> readOnlyToMutableClassId;

    private JavaToKotlinClassMap() {
    }

    static {
        kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap javaToKotlinClassMap = new kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap();
        INSTANCE = javaToKotlinClassMap;
        NUMBERED_FUNCTION_PREFIX = kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKind.Function.INSTANCE.getPackageFqName() + com.taobao.weex.el.parse.Operators.DOT + kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKind.Function.INSTANCE.getClassNamePrefix();
        NUMBERED_K_FUNCTION_PREFIX = kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKind.KFunction.INSTANCE.getPackageFqName() + com.taobao.weex.el.parse.Operators.DOT + kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKind.KFunction.INSTANCE.getClassNamePrefix();
        NUMBERED_SUSPEND_FUNCTION_PREFIX = kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKind.SuspendFunction.INSTANCE.getPackageFqName() + com.taobao.weex.el.parse.Operators.DOT + kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKind.SuspendFunction.INSTANCE.getClassNamePrefix();
        NUMBERED_K_SUSPEND_FUNCTION_PREFIX = kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKind.KSuspendFunction.INSTANCE.getPackageFqName() + com.taobao.weex.el.parse.Operators.DOT + kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKind.KSuspendFunction.INSTANCE.getClassNamePrefix();
        kotlin.reflect.jvm.internal.impl.name.ClassId classId = kotlin.reflect.jvm.internal.impl.name.ClassId.Companion.topLevel(new kotlin.reflect.jvm.internal.impl.name.FqName("kotlin.jvm.functions.FunctionN"));
        FUNCTION_N_CLASS_ID = classId;
        FUNCTION_N_FQ_NAME = classId.asSingleFqName();
        K_FUNCTION_CLASS_ID = kotlin.reflect.jvm.internal.impl.name.StandardClassIds.INSTANCE.getKFunction();
        K_CLASS_CLASS_ID = kotlin.reflect.jvm.internal.impl.name.StandardClassIds.INSTANCE.getKClass();
        CLASS_CLASS_ID = javaToKotlinClassMap.classId(java.lang.Class.class);
        javaToKotlin = new java.util.HashMap<>();
        kotlinToJava = new java.util.HashMap<>();
        mutableToReadOnly = new java.util.HashMap<>();
        readOnlyToMutable = new java.util.HashMap<>();
        mutableToReadOnlyClassId = new java.util.HashMap<>();
        readOnlyToMutableClassId = new java.util.HashMap<>();
        kotlin.reflect.jvm.internal.impl.name.ClassId classId2 = kotlin.reflect.jvm.internal.impl.name.ClassId.Companion.topLevel(kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.iterable);
        kotlin.reflect.jvm.internal.impl.name.ClassId classId3 = new kotlin.reflect.jvm.internal.impl.name.ClassId(classId2.getPackageFqName(), kotlin.reflect.jvm.internal.impl.name.FqNamesUtilKt.tail(kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.mutableIterable, classId2.getPackageFqName()), false);
        kotlin.reflect.jvm.internal.impl.name.ClassId classId4 = kotlin.reflect.jvm.internal.impl.name.ClassId.Companion.topLevel(kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.iterator);
        kotlin.reflect.jvm.internal.impl.name.ClassId classId5 = new kotlin.reflect.jvm.internal.impl.name.ClassId(classId4.getPackageFqName(), kotlin.reflect.jvm.internal.impl.name.FqNamesUtilKt.tail(kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.mutableIterator, classId4.getPackageFqName()), false);
        kotlin.reflect.jvm.internal.impl.name.ClassId classId6 = kotlin.reflect.jvm.internal.impl.name.ClassId.Companion.topLevel(kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.collection);
        kotlin.reflect.jvm.internal.impl.name.ClassId classId7 = new kotlin.reflect.jvm.internal.impl.name.ClassId(classId6.getPackageFqName(), kotlin.reflect.jvm.internal.impl.name.FqNamesUtilKt.tail(kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.mutableCollection, classId6.getPackageFqName()), false);
        kotlin.reflect.jvm.internal.impl.name.ClassId classId8 = kotlin.reflect.jvm.internal.impl.name.ClassId.Companion.topLevel(kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.list);
        kotlin.reflect.jvm.internal.impl.name.ClassId classId9 = new kotlin.reflect.jvm.internal.impl.name.ClassId(classId8.getPackageFqName(), kotlin.reflect.jvm.internal.impl.name.FqNamesUtilKt.tail(kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.mutableList, classId8.getPackageFqName()), false);
        kotlin.reflect.jvm.internal.impl.name.ClassId classId10 = kotlin.reflect.jvm.internal.impl.name.ClassId.Companion.topLevel(kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.set);
        kotlin.reflect.jvm.internal.impl.name.ClassId classId11 = new kotlin.reflect.jvm.internal.impl.name.ClassId(classId10.getPackageFqName(), kotlin.reflect.jvm.internal.impl.name.FqNamesUtilKt.tail(kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.mutableSet, classId10.getPackageFqName()), false);
        kotlin.reflect.jvm.internal.impl.name.ClassId classId12 = kotlin.reflect.jvm.internal.impl.name.ClassId.Companion.topLevel(kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.listIterator);
        kotlin.reflect.jvm.internal.impl.name.ClassId classId13 = new kotlin.reflect.jvm.internal.impl.name.ClassId(classId12.getPackageFqName(), kotlin.reflect.jvm.internal.impl.name.FqNamesUtilKt.tail(kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.mutableListIterator, classId12.getPackageFqName()), false);
        kotlin.reflect.jvm.internal.impl.name.ClassId classId14 = kotlin.reflect.jvm.internal.impl.name.ClassId.Companion.topLevel(kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.map);
        kotlin.reflect.jvm.internal.impl.name.ClassId classId15 = new kotlin.reflect.jvm.internal.impl.name.ClassId(classId14.getPackageFqName(), kotlin.reflect.jvm.internal.impl.name.FqNamesUtilKt.tail(kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.mutableMap, classId14.getPackageFqName()), false);
        kotlin.reflect.jvm.internal.impl.name.ClassId classIdCreateNestedClassId = kotlin.reflect.jvm.internal.impl.name.ClassId.Companion.topLevel(kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.map).createNestedClassId(kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.mapEntry.shortName());
        java.util.List<kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap.PlatformMutabilityMapping> listListOf = kotlin.collections.CollectionsKt.listOf((java.lang.Object[]) new kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap.PlatformMutabilityMapping[]{new kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap.PlatformMutabilityMapping(javaToKotlinClassMap.classId(java.lang.Iterable.class), classId2, classId3), new kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap.PlatformMutabilityMapping(javaToKotlinClassMap.classId(java.util.Iterator.class), classId4, classId5), new kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap.PlatformMutabilityMapping(javaToKotlinClassMap.classId(java.util.Collection.class), classId6, classId7), new kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap.PlatformMutabilityMapping(javaToKotlinClassMap.classId(java.util.List.class), classId8, classId9), new kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap.PlatformMutabilityMapping(javaToKotlinClassMap.classId(java.util.Set.class), classId10, classId11), new kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap.PlatformMutabilityMapping(javaToKotlinClassMap.classId(java.util.ListIterator.class), classId12, classId13), new kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap.PlatformMutabilityMapping(javaToKotlinClassMap.classId(java.util.Map.class), classId14, classId15), new kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap.PlatformMutabilityMapping(javaToKotlinClassMap.classId(java.util.Map.Entry.class), classIdCreateNestedClassId, new kotlin.reflect.jvm.internal.impl.name.ClassId(classIdCreateNestedClassId.getPackageFqName(), kotlin.reflect.jvm.internal.impl.name.FqNamesUtilKt.tail(kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.mutableMapEntry, classIdCreateNestedClassId.getPackageFqName()), false))});
        mutabilityMappings = listListOf;
        javaToKotlinClassMap.addTopLevel(java.lang.Object.class, kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.any);
        javaToKotlinClassMap.addTopLevel(java.lang.String.class, kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.string);
        javaToKotlinClassMap.addTopLevel(java.lang.CharSequence.class, kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.charSequence);
        javaToKotlinClassMap.addTopLevel(java.lang.Throwable.class, kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.throwable);
        javaToKotlinClassMap.addTopLevel(java.lang.Cloneable.class, kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.cloneable);
        javaToKotlinClassMap.addTopLevel(java.lang.Number.class, kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.number);
        javaToKotlinClassMap.addTopLevel(java.lang.Comparable.class, kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.comparable);
        javaToKotlinClassMap.addTopLevel(java.lang.Enum.class, kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames._enum);
        javaToKotlinClassMap.addTopLevel(java.lang.annotation.Annotation.class, kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.annotation);
        java.util.Iterator<kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap.PlatformMutabilityMapping> it = listListOf.iterator();
        while (it.hasNext()) {
            INSTANCE.addMapping(it.next());
        }
        for (kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType jvmPrimitiveType : kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType.values()) {
            kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap javaToKotlinClassMap2 = INSTANCE;
            kotlin.reflect.jvm.internal.impl.name.ClassId.Companion companion = kotlin.reflect.jvm.internal.impl.name.ClassId.Companion;
            kotlin.reflect.jvm.internal.impl.name.FqName wrapperFqName = jvmPrimitiveType.getWrapperFqName();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(wrapperFqName, "getWrapperFqName(...)");
            kotlin.reflect.jvm.internal.impl.name.ClassId classId16 = companion.topLevel(wrapperFqName);
            kotlin.reflect.jvm.internal.impl.name.ClassId.Companion companion2 = kotlin.reflect.jvm.internal.impl.name.ClassId.Companion;
            kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType primitiveType = jvmPrimitiveType.getPrimitiveType();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(primitiveType, "getPrimitiveType(...)");
            javaToKotlinClassMap2.add(classId16, companion2.topLevel(kotlin.reflect.jvm.internal.impl.builtins.StandardNames.getPrimitiveFqName(primitiveType)));
        }
        for (kotlin.reflect.jvm.internal.impl.name.ClassId classId17 : kotlin.reflect.jvm.internal.impl.builtins.CompanionObjectMapping.INSTANCE.allClassesWithIntrinsicCompanions()) {
            INSTANCE.add(kotlin.reflect.jvm.internal.impl.name.ClassId.Companion.topLevel(new kotlin.reflect.jvm.internal.impl.name.FqName("kotlin.jvm.internal." + classId17.getShortClassName().asString() + "CompanionObject")), classId17.createNestedClassId(kotlin.reflect.jvm.internal.impl.name.SpecialNames.DEFAULT_NAME_FOR_COMPANION_OBJECT));
        }
        for (int i = 0; i < 23; i++) {
            kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap javaToKotlinClassMap3 = INSTANCE;
            javaToKotlinClassMap3.add(kotlin.reflect.jvm.internal.impl.name.ClassId.Companion.topLevel(new kotlin.reflect.jvm.internal.impl.name.FqName("kotlin.jvm.functions.Function" + i)), kotlin.reflect.jvm.internal.impl.builtins.StandardNames.getFunctionClassId(i));
            javaToKotlinClassMap3.addKotlinToJava(new kotlin.reflect.jvm.internal.impl.name.FqName(NUMBERED_K_FUNCTION_PREFIX + i), K_FUNCTION_CLASS_ID);
        }
        for (int i2 = 0; i2 < 22; i2++) {
            kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKind.KSuspendFunction kSuspendFunction = kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKind.KSuspendFunction.INSTANCE;
            INSTANCE.addKotlinToJava(new kotlin.reflect.jvm.internal.impl.name.FqName((kSuspendFunction.getPackageFqName() + com.taobao.weex.el.parse.Operators.DOT + kSuspendFunction.getClassNamePrefix()) + i2), K_FUNCTION_CLASS_ID);
        }
        kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap javaToKotlinClassMap4 = INSTANCE;
        javaToKotlinClassMap4.addKotlinToJava(new kotlin.reflect.jvm.internal.impl.name.FqName("kotlin.concurrent.atomics.AtomicInt"), javaToKotlinClassMap4.classId(java.util.concurrent.atomic.AtomicInteger.class));
        javaToKotlinClassMap4.addKotlinToJava(new kotlin.reflect.jvm.internal.impl.name.FqName("kotlin.concurrent.atomics.AtomicLong"), javaToKotlinClassMap4.classId(java.util.concurrent.atomic.AtomicLong.class));
        javaToKotlinClassMap4.addKotlinToJava(new kotlin.reflect.jvm.internal.impl.name.FqName("kotlin.concurrent.atomics.AtomicBoolean"), javaToKotlinClassMap4.classId(java.util.concurrent.atomic.AtomicBoolean.class));
        javaToKotlinClassMap4.addKotlinToJava(new kotlin.reflect.jvm.internal.impl.name.FqName("kotlin.concurrent.atomics.AtomicReference"), javaToKotlinClassMap4.classId(java.util.concurrent.atomic.AtomicReference.class));
        javaToKotlinClassMap4.addKotlinToJava(new kotlin.reflect.jvm.internal.impl.name.FqName("kotlin.concurrent.atomics.AtomicIntArray"), javaToKotlinClassMap4.classId(java.util.concurrent.atomic.AtomicIntegerArray.class));
        javaToKotlinClassMap4.addKotlinToJava(new kotlin.reflect.jvm.internal.impl.name.FqName("kotlin.concurrent.atomics.AtomicLongArray"), javaToKotlinClassMap4.classId(java.util.concurrent.atomic.AtomicLongArray.class));
        javaToKotlinClassMap4.addKotlinToJava(new kotlin.reflect.jvm.internal.impl.name.FqName("kotlin.concurrent.atomics.AtomicArray"), javaToKotlinClassMap4.classId(java.util.concurrent.atomic.AtomicReferenceArray.class));
        javaToKotlinClassMap4.addKotlinToJava(kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.nothing.toSafe(), javaToKotlinClassMap4.classId(java.lang.Void.class));
    }

    public final kotlin.reflect.jvm.internal.impl.name.FqName getFUNCTION_N_FQ_NAME() {
        return FUNCTION_N_FQ_NAME;
    }

    /* JADX INFO: compiled from: JavaToKotlinClassMap.kt */
    public static final class PlatformMutabilityMapping {
        private final kotlin.reflect.jvm.internal.impl.name.ClassId javaClass;
        private final kotlin.reflect.jvm.internal.impl.name.ClassId kotlinMutable;
        private final kotlin.reflect.jvm.internal.impl.name.ClassId kotlinReadOnly;

        public final kotlin.reflect.jvm.internal.impl.name.ClassId component1() {
            return this.javaClass;
        }

        public final kotlin.reflect.jvm.internal.impl.name.ClassId component2() {
            return this.kotlinReadOnly;
        }

        public final kotlin.reflect.jvm.internal.impl.name.ClassId component3() {
            return this.kotlinMutable;
        }

        public boolean equals(java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap.PlatformMutabilityMapping)) {
                return false;
            }
            kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap.PlatformMutabilityMapping platformMutabilityMapping = (kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap.PlatformMutabilityMapping) obj;
            return kotlin.jvm.internal.Intrinsics.areEqual(this.javaClass, platformMutabilityMapping.javaClass) && kotlin.jvm.internal.Intrinsics.areEqual(this.kotlinReadOnly, platformMutabilityMapping.kotlinReadOnly) && kotlin.jvm.internal.Intrinsics.areEqual(this.kotlinMutable, platformMutabilityMapping.kotlinMutable);
        }

        public int hashCode() {
            return (((this.javaClass.hashCode() * 31) + this.kotlinReadOnly.hashCode()) * 31) + this.kotlinMutable.hashCode();
        }

        public java.lang.String toString() {
            return "PlatformMutabilityMapping(javaClass=" + this.javaClass + ", kotlinReadOnly=" + this.kotlinReadOnly + ", kotlinMutable=" + this.kotlinMutable + com.taobao.weex.el.parse.Operators.BRACKET_END;
        }

        public PlatformMutabilityMapping(kotlin.reflect.jvm.internal.impl.name.ClassId javaClass, kotlin.reflect.jvm.internal.impl.name.ClassId kotlinReadOnly, kotlin.reflect.jvm.internal.impl.name.ClassId kotlinMutable) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(javaClass, "javaClass");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinReadOnly, "kotlinReadOnly");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinMutable, "kotlinMutable");
            this.javaClass = javaClass;
            this.kotlinReadOnly = kotlinReadOnly;
            this.kotlinMutable = kotlinMutable;
        }

        public final kotlin.reflect.jvm.internal.impl.name.ClassId getJavaClass() {
            return this.javaClass;
        }
    }

    public final java.util.List<kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap.PlatformMutabilityMapping> getMutabilityMappings() {
        return mutabilityMappings;
    }

    public final kotlin.reflect.jvm.internal.impl.name.ClassId mapJavaToKotlin(kotlin.reflect.jvm.internal.impl.name.FqName fqName) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fqName, "fqName");
        return javaToKotlin.get(fqName.toUnsafe());
    }

    public final kotlin.reflect.jvm.internal.impl.name.ClassId mapKotlinToJava(kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe kotlinFqName) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinFqName, "kotlinFqName");
        if (!isKotlinFunctionWithBigArity(kotlinFqName, NUMBERED_FUNCTION_PREFIX) && !isKotlinFunctionWithBigArity(kotlinFqName, NUMBERED_SUSPEND_FUNCTION_PREFIX)) {
            if (!isKotlinFunctionWithBigArity(kotlinFqName, NUMBERED_K_FUNCTION_PREFIX) && !isKotlinFunctionWithBigArity(kotlinFqName, NUMBERED_K_SUSPEND_FUNCTION_PREFIX)) {
                return kotlinToJava.get(kotlinFqName);
            }
            return K_FUNCTION_CLASS_ID;
        }
        return FUNCTION_N_CLASS_ID;
    }

    private final boolean isKotlinFunctionWithBigArity(kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe fqNameUnsafe, java.lang.String str) {
        java.lang.Integer intOrNull;
        java.lang.String strAsString = fqNameUnsafe.asString();
        if (!kotlin.text.StringsKt.startsWith$default(strAsString, str, false, 2, (java.lang.Object) null)) {
            return false;
        }
        java.lang.String strSubstring = strAsString.substring(str.length());
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return (kotlin.text.StringsKt.startsWith$default((java.lang.CharSequence) strSubstring, '0', false, 2, (java.lang.Object) null) || (intOrNull = kotlin.text.StringsKt.toIntOrNull(strSubstring)) == null || intOrNull.intValue() < 23) ? false : true;
    }

    private final void addMapping(kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap.PlatformMutabilityMapping platformMutabilityMapping) {
        kotlin.reflect.jvm.internal.impl.name.ClassId classIdComponent1 = platformMutabilityMapping.component1();
        kotlin.reflect.jvm.internal.impl.name.ClassId classIdComponent2 = platformMutabilityMapping.component2();
        kotlin.reflect.jvm.internal.impl.name.ClassId classIdComponent3 = platformMutabilityMapping.component3();
        add(classIdComponent1, classIdComponent2);
        addKotlinToJava(classIdComponent3.asSingleFqName(), classIdComponent1);
        mutableToReadOnlyClassId.put(classIdComponent3, classIdComponent2);
        readOnlyToMutableClassId.put(classIdComponent2, classIdComponent3);
        kotlin.reflect.jvm.internal.impl.name.FqName fqNameAsSingleFqName = classIdComponent2.asSingleFqName();
        kotlin.reflect.jvm.internal.impl.name.FqName fqNameAsSingleFqName2 = classIdComponent3.asSingleFqName();
        mutableToReadOnly.put(classIdComponent3.asSingleFqName().toUnsafe(), fqNameAsSingleFqName);
        readOnlyToMutable.put(fqNameAsSingleFqName.toUnsafe(), fqNameAsSingleFqName2);
    }

    private final void add(kotlin.reflect.jvm.internal.impl.name.ClassId classId, kotlin.reflect.jvm.internal.impl.name.ClassId classId2) {
        addJavaToKotlin(classId, classId2);
        addKotlinToJava(classId2.asSingleFqName(), classId);
    }

    private final void addTopLevel(java.lang.Class<?> cls, kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe fqNameUnsafe) {
        addTopLevel(cls, fqNameUnsafe.toSafe());
    }

    private final void addTopLevel(java.lang.Class<?> cls, kotlin.reflect.jvm.internal.impl.name.FqName fqName) {
        add(classId(cls), kotlin.reflect.jvm.internal.impl.name.ClassId.Companion.topLevel(fqName));
    }

    private final void addJavaToKotlin(kotlin.reflect.jvm.internal.impl.name.ClassId classId, kotlin.reflect.jvm.internal.impl.name.ClassId classId2) {
        javaToKotlin.put(classId.asSingleFqName().toUnsafe(), classId2);
    }

    private final void addKotlinToJava(kotlin.reflect.jvm.internal.impl.name.FqName fqName, kotlin.reflect.jvm.internal.impl.name.ClassId classId) {
        kotlinToJava.put(fqName.toUnsafe(), classId);
    }

    public final kotlin.reflect.jvm.internal.impl.name.FqName mutableToReadOnly(kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe fqNameUnsafe) {
        return mutableToReadOnly.get(fqNameUnsafe);
    }

    public final kotlin.reflect.jvm.internal.impl.name.FqName readOnlyToMutable(kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe fqNameUnsafe) {
        return readOnlyToMutable.get(fqNameUnsafe);
    }

    public final boolean isMutable(kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe fqNameUnsafe) {
        return mutableToReadOnly.containsKey(fqNameUnsafe);
    }

    public final boolean isReadOnly(kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe fqNameUnsafe) {
        return readOnlyToMutable.containsKey(fqNameUnsafe);
    }

    private final kotlin.reflect.jvm.internal.impl.name.ClassId classId(java.lang.Class<?> cls) {
        if (!cls.isPrimitive()) {
            cls.isArray();
        }
        java.lang.Class<?> declaringClass = cls.getDeclaringClass();
        if (declaringClass == null) {
            kotlin.reflect.jvm.internal.impl.name.ClassId.Companion companion = kotlin.reflect.jvm.internal.impl.name.ClassId.Companion;
            java.lang.String canonicalName = cls.getCanonicalName();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(canonicalName, "getCanonicalName(...)");
            return companion.topLevel(new kotlin.reflect.jvm.internal.impl.name.FqName(canonicalName));
        }
        kotlin.reflect.jvm.internal.impl.name.ClassId classId = classId(declaringClass);
        kotlin.reflect.jvm.internal.impl.name.Name nameIdentifier = kotlin.reflect.jvm.internal.impl.name.Name.identifier(cls.getSimpleName());
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameIdentifier, "identifier(...)");
        return classId.createNestedClassId(nameIdentifier);
    }
}
