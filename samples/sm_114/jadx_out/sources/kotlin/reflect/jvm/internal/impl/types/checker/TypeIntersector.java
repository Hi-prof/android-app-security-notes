package kotlin.reflect.jvm.internal.impl.types.checker;

/* JADX INFO: compiled from: IntersectionType.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TypeIntersector {
    public static final kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector INSTANCE = new kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector();

    private TypeIntersector() {
    }

    public final kotlin.reflect.jvm.internal.impl.types.SimpleType intersectTypes$descriptors(java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.SimpleType> types) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(types, "types");
        types.size();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (kotlin.reflect.jvm.internal.impl.types.SimpleType simpleType : types) {
            if (simpleType.getConstructor() instanceof kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor) {
                java.util.Collection<kotlin.reflect.jvm.internal.impl.types.KotlinType> collectionMo1836getSupertypes = simpleType.getConstructor().mo1836getSupertypes();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(collectionMo1836getSupertypes, "getSupertypes(...)");
                java.util.Collection<kotlin.reflect.jvm.internal.impl.types.KotlinType> collection = collectionMo1836getSupertypes;
                java.util.ArrayList arrayList2 = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(collection, 10));
                for (kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType : collection) {
                    kotlin.jvm.internal.Intrinsics.checkNotNull(kotlinType);
                    kotlin.reflect.jvm.internal.impl.types.SimpleType simpleTypeUpperIfFlexible = kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt.upperIfFlexible(kotlinType);
                    if (simpleType.isMarkedNullable()) {
                        simpleTypeUpperIfFlexible = simpleTypeUpperIfFlexible.makeNullableAsSpecified(true);
                    }
                    arrayList2.add(simpleTypeUpperIfFlexible);
                }
                arrayList.addAll(arrayList2);
            } else {
                arrayList.add(simpleType);
            }
        }
        java.util.ArrayList<kotlin.reflect.jvm.internal.impl.types.SimpleType> arrayList3 = arrayList;
        kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.ResultNullability resultNullabilityCombine = kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.ResultNullability.START;
        java.util.Iterator it = arrayList3.iterator();
        while (it.hasNext()) {
            resultNullabilityCombine = resultNullabilityCombine.combine((kotlin.reflect.jvm.internal.impl.types.UnwrappedType) it.next());
        }
        java.util.LinkedHashSet linkedHashSet = new java.util.LinkedHashSet();
        for (kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedType newCapturedTypeMakeSimpleTypeDefinitelyNotNullOrNotNull$default : arrayList3) {
            if (resultNullabilityCombine == kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.ResultNullability.NOT_NULL) {
                if (newCapturedTypeMakeSimpleTypeDefinitelyNotNullOrNotNull$default instanceof kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedType) {
                    newCapturedTypeMakeSimpleTypeDefinitelyNotNullOrNotNull$default = kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt.withNotNullProjection((kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedType) newCapturedTypeMakeSimpleTypeDefinitelyNotNullOrNotNull$default);
                }
                newCapturedTypeMakeSimpleTypeDefinitelyNotNullOrNotNull$default = kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt.makeSimpleTypeDefinitelyNotNullOrNotNull$default(newCapturedTypeMakeSimpleTypeDefinitelyNotNullOrNotNull$default, false, 1, null);
            }
            linkedHashSet.add(newCapturedTypeMakeSimpleTypeDefinitelyNotNullOrNotNull$default);
        }
        java.util.LinkedHashSet linkedHashSet2 = linkedHashSet;
        java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.SimpleType> list = types;
        java.util.ArrayList arrayList4 = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(list, 10));
        java.util.Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList4.add(((kotlin.reflect.jvm.internal.impl.types.SimpleType) it2.next()).getAttributes());
        }
        java.util.Iterator it3 = arrayList4.iterator();
        if (!it3.hasNext()) {
            throw new java.lang.UnsupportedOperationException("Empty collection can't be reduced.");
        }
        java.lang.Object next = it3.next();
        while (it3.hasNext()) {
            next = ((kotlin.reflect.jvm.internal.impl.types.TypeAttributes) next).intersect((kotlin.reflect.jvm.internal.impl.types.TypeAttributes) it3.next());
        }
        return intersectTypesWithoutIntersectionType(linkedHashSet2).replaceAttributes((kotlin.reflect.jvm.internal.impl.types.TypeAttributes) next);
    }

    private final kotlin.reflect.jvm.internal.impl.types.SimpleType intersectTypesWithoutIntersectionType(final java.util.Set<? extends kotlin.reflect.jvm.internal.impl.types.SimpleType> set) {
        if (set.size() == 1) {
            return (kotlin.reflect.jvm.internal.impl.types.SimpleType) kotlin.collections.CollectionsKt.single(set);
        }
        new kotlin.jvm.functions.Function0(set) { // from class: kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector$$Lambda$0
            private final java.util.Set arg$0;

            {
                this.arg$0 = set;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.intersectTypesWithoutIntersectionType$lambda$6(this.arg$0);
            }
        };
        java.util.Set<? extends kotlin.reflect.jvm.internal.impl.types.SimpleType> set2 = set;
        java.util.Collection<kotlin.reflect.jvm.internal.impl.types.SimpleType> collectionFilterTypes = filterTypes(set2, new kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector$intersectTypesWithoutIntersectionType$filteredEqualTypes$1(this));
        collectionFilterTypes.isEmpty();
        kotlin.reflect.jvm.internal.impl.types.SimpleType simpleTypeFindIntersectionType = kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor.Companion.findIntersectionType(collectionFilterTypes);
        if (simpleTypeFindIntersectionType != null) {
            return simpleTypeFindIntersectionType;
        }
        java.util.Collection<kotlin.reflect.jvm.internal.impl.types.SimpleType> collectionFilterTypes2 = filterTypes(collectionFilterTypes, new kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector$intersectTypesWithoutIntersectionType$filteredSuperAndEqualTypes$1(kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker.Companion.getDefault()));
        collectionFilterTypes2.isEmpty();
        return collectionFilterTypes2.size() < 2 ? (kotlin.reflect.jvm.internal.impl.types.SimpleType) kotlin.collections.CollectionsKt.single(collectionFilterTypes2) : new kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor(set2).createType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.lang.String intersectTypesWithoutIntersectionType$lambda$6(java.util.Set set) {
        return "This collections cannot be empty! input types: " + kotlin.collections.CollectionsKt.joinToString$default(set, null, null, null, 0, null, null, 63, null);
    }

    private final java.util.Collection<kotlin.reflect.jvm.internal.impl.types.SimpleType> filterTypes(java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.types.SimpleType> collection, kotlin.jvm.functions.Function2<? super kotlin.reflect.jvm.internal.impl.types.SimpleType, ? super kotlin.reflect.jvm.internal.impl.types.SimpleType, java.lang.Boolean> function2) {
        java.util.ArrayList arrayList = new java.util.ArrayList(collection);
        java.util.Iterator it = arrayList.iterator();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            kotlin.reflect.jvm.internal.impl.types.SimpleType simpleType = (kotlin.reflect.jvm.internal.impl.types.SimpleType) it.next();
            java.util.ArrayList<kotlin.reflect.jvm.internal.impl.types.SimpleType> arrayList2 = arrayList;
            if (!(arrayList2 instanceof java.util.Collection) || !arrayList2.isEmpty()) {
                for (kotlin.reflect.jvm.internal.impl.types.SimpleType simpleType2 : arrayList2) {
                    if (simpleType2 != simpleType) {
                        kotlin.jvm.internal.Intrinsics.checkNotNull(simpleType2);
                        kotlin.jvm.internal.Intrinsics.checkNotNull(simpleType);
                        if (function2.invoke(simpleType2, simpleType).booleanValue()) {
                            it.remove();
                            break;
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isStrictSupertype(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType, kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType2) {
        kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeCheckerImpl newKotlinTypeCheckerImpl = kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker.Companion.getDefault();
        return newKotlinTypeCheckerImpl.isSubtypeOf(kotlinType, kotlinType2) && !newKotlinTypeCheckerImpl.isSubtypeOf(kotlinType2, kotlinType);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: IntersectionType.kt */
    private static final class ResultNullability {
        private static final /* synthetic */ kotlin.enums.EnumEntries $ENTRIES;
        private static final /* synthetic */ kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.ResultNullability[] $VALUES;
        public static final kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.ResultNullability START = new kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.ResultNullability.START("START", 0);
        public static final kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.ResultNullability ACCEPT_NULL = new kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.ResultNullability.ACCEPT_NULL("ACCEPT_NULL", 1);
        public static final kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.ResultNullability UNKNOWN = new kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.ResultNullability.UNKNOWN("UNKNOWN", 2);
        public static final kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.ResultNullability NOT_NULL = new kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.ResultNullability.NOT_NULL("NOT_NULL", 3);

        private static final /* synthetic */ kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.ResultNullability[] $values() {
            return new kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.ResultNullability[]{START, ACCEPT_NULL, UNKNOWN, NOT_NULL};
        }

        public /* synthetic */ ResultNullability(java.lang.String str, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i);
        }

        public static kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.ResultNullability valueOf(java.lang.String str) {
            return (kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.ResultNullability) java.lang.Enum.valueOf(kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.ResultNullability.class, str);
        }

        public static kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.ResultNullability[] values() {
            return (kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.ResultNullability[]) $VALUES.clone();
        }

        public abstract kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.ResultNullability combine(kotlin.reflect.jvm.internal.impl.types.UnwrappedType unwrappedType);

        /* JADX INFO: compiled from: IntersectionType.kt */
        static final class START extends kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.ResultNullability {
            START(java.lang.String str, int i) {
                super(str, i, null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.ResultNullability
            public kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.ResultNullability combine(kotlin.reflect.jvm.internal.impl.types.UnwrappedType nextType) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(nextType, "nextType");
                return getResultNullability(nextType);
            }
        }

        private ResultNullability(java.lang.String str, int i) {
            super(str, i);
        }

        static {
            kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.ResultNullability[] resultNullabilityArr$values = $values();
            $VALUES = resultNullabilityArr$values;
            $ENTRIES = kotlin.enums.EnumEntriesKt.enumEntries(resultNullabilityArr$values);
        }

        /* JADX INFO: compiled from: IntersectionType.kt */
        static final class ACCEPT_NULL extends kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.ResultNullability {
            ACCEPT_NULL(java.lang.String str, int i) {
                super(str, i, null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.ResultNullability
            public kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.ResultNullability combine(kotlin.reflect.jvm.internal.impl.types.UnwrappedType nextType) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(nextType, "nextType");
                return getResultNullability(nextType);
            }
        }

        /* JADX INFO: compiled from: IntersectionType.kt */
        static final class UNKNOWN extends kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.ResultNullability {
            UNKNOWN(java.lang.String str, int i) {
                super(str, i, null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.ResultNullability
            public kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.ResultNullability combine(kotlin.reflect.jvm.internal.impl.types.UnwrappedType nextType) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(nextType, "nextType");
                kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.ResultNullability resultNullability = getResultNullability(nextType);
                return resultNullability == kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.ResultNullability.ACCEPT_NULL ? this : resultNullability;
            }
        }

        /* JADX INFO: compiled from: IntersectionType.kt */
        static final class NOT_NULL extends kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.ResultNullability {
            @Override // kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.ResultNullability
            public kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.ResultNullability.NOT_NULL combine(kotlin.reflect.jvm.internal.impl.types.UnwrappedType nextType) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(nextType, "nextType");
                return this;
            }

            NOT_NULL(java.lang.String str, int i) {
                super(str, i, null);
            }
        }

        protected final kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.ResultNullability getResultNullability(kotlin.reflect.jvm.internal.impl.types.UnwrappedType unwrappedType) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(unwrappedType, "<this>");
            if (unwrappedType.isMarkedNullable()) {
                return ACCEPT_NULL;
            }
            if ((unwrappedType instanceof kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType) && (((kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType) unwrappedType).getOriginal() instanceof kotlin.reflect.jvm.internal.impl.types.StubTypeForBuilderInference)) {
                return NOT_NULL;
            }
            if (unwrappedType instanceof kotlin.reflect.jvm.internal.impl.types.StubTypeForBuilderInference) {
                return UNKNOWN;
            }
            return kotlin.reflect.jvm.internal.impl.types.checker.NullabilityChecker.INSTANCE.isSubtypeOfAny(unwrappedType) ? NOT_NULL : UNKNOWN;
        }
    }
}
