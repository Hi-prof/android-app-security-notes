package kotlin.reflect.jvm.internal.impl.types;

/* JADX INFO: compiled from: IntersectionTypeConstructor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class IntersectionTypeConstructor implements kotlin.reflect.jvm.internal.impl.types.TypeConstructor, kotlin.reflect.jvm.internal.impl.types.model.IntersectionTypeConstructorMarker {
    private kotlin.reflect.jvm.internal.impl.types.KotlinType alternative;
    private final int hashCode;
    private final java.util.LinkedHashSet<kotlin.reflect.jvm.internal.impl.types.KotlinType> intersectedTypes;

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    /* JADX INFO: renamed from: getDeclarationDescriptor */
    public kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor mo1835getDeclarationDescriptor() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public boolean isDenotable() {
        return false;
    }

    public IntersectionTypeConstructor(java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.types.KotlinType> typesToIntersect) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typesToIntersect, "typesToIntersect");
        typesToIntersect.isEmpty();
        java.util.LinkedHashSet<kotlin.reflect.jvm.internal.impl.types.KotlinType> linkedHashSet = new java.util.LinkedHashSet<>(typesToIntersect);
        this.intersectedTypes = linkedHashSet;
        this.hashCode = linkedHashSet.hashCode();
    }

    private IntersectionTypeConstructor(java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.types.KotlinType> collection, kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        this(collection);
        this.alternative = kotlinType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> getParameters() {
        return kotlin.collections.CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    /* JADX INFO: renamed from: getSupertypes */
    public java.util.Collection<kotlin.reflect.jvm.internal.impl.types.KotlinType> mo1836getSupertypes() {
        return this.intersectedTypes;
    }

    public final kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope createScopeForKotlinType() {
        return kotlin.reflect.jvm.internal.impl.resolve.scopes.TypeIntersectionScope.Companion.create("member scope for intersection type", this.intersectedTypes);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns getBuiltIns() {
        kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns builtIns = this.intersectedTypes.iterator().next().getConstructor().getBuiltIns();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(builtIns, "getBuiltIns(...)");
        return builtIns;
    }

    public java.lang.String toString() {
        return makeDebugNameForIntersectionType$default(this, null, 1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ java.lang.String makeDebugNameForIntersectionType$default(kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor intersectionTypeConstructor, kotlin.jvm.functions.Function1 function1, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            function1 = new kotlin.jvm.functions.Function1() { // from class: kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor$$Lambda$1
                @Override // kotlin.jvm.functions.Function1
                /* JADX INFO: renamed from: invoke */
                public java.lang.Object invoke2(java.lang.Object obj2) {
                    return kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor.makeDebugNameForIntersectionType$lambda$1((kotlin.reflect.jvm.internal.impl.types.KotlinType) obj2);
                }
            };
        }
        return intersectionTypeConstructor.makeDebugNameForIntersectionType(function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.lang.String makeDebugNameForIntersectionType$lambda$1(kotlin.reflect.jvm.internal.impl.types.KotlinType it) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(it, "it");
        return it.toString();
    }

    public final java.lang.String makeDebugNameForIntersectionType(final kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.types.KotlinType, ? extends java.lang.Object> getProperTypeRelatedToStringify) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(getProperTypeRelatedToStringify, "getProperTypeRelatedToStringify");
        return kotlin.collections.CollectionsKt.joinToString$default(kotlin.collections.CollectionsKt.sortedWith(this.intersectedTypes, new java.util.Comparator() { // from class: kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor$makeDebugNameForIntersectionType$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType = (kotlin.reflect.jvm.internal.impl.types.KotlinType) t;
                kotlin.jvm.functions.Function1 function1 = getProperTypeRelatedToStringify;
                kotlin.jvm.internal.Intrinsics.checkNotNull(kotlinType);
                java.lang.String string = function1.invoke2(kotlinType).toString();
                kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType2 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) t2;
                kotlin.jvm.functions.Function1 function2 = getProperTypeRelatedToStringify;
                kotlin.jvm.internal.Intrinsics.checkNotNull(kotlinType2);
                return kotlin.comparisons.ComparisonsKt.compareValues(string, function2.invoke2(kotlinType2).toString());
            }
        }), " & ", com.taobao.weex.el.parse.Operators.BLOCK_START_STR, com.taobao.weex.el.parse.Operators.BLOCK_END_STR, 0, null, new kotlin.jvm.functions.Function1(getProperTypeRelatedToStringify) { // from class: kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor$$Lambda$0
            private final kotlin.jvm.functions.Function1 arg$0;

            {
                this.arg$0 = getProperTypeRelatedToStringify;
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor.makeDebugNameForIntersectionType$lambda$3(this.arg$0, (kotlin.reflect.jvm.internal.impl.types.KotlinType) obj);
            }
        }, 24, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.lang.CharSequence makeDebugNameForIntersectionType$lambda$3(kotlin.jvm.functions.Function1 function1, kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        kotlin.jvm.internal.Intrinsics.checkNotNull(kotlinType);
        return function1.invoke2(kotlinType).toString();
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor) {
            return kotlin.jvm.internal.Intrinsics.areEqual(this.intersectedTypes, ((kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor) obj).intersectedTypes);
        }
        return false;
    }

    public final kotlin.reflect.jvm.internal.impl.types.SimpleType createType() {
        return kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(kotlin.reflect.jvm.internal.impl.types.TypeAttributes.Companion.getEmpty(), this, kotlin.collections.CollectionsKt.emptyList(), false, createScopeForKotlinType(), new kotlin.jvm.functions.Function1(this) { // from class: kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor$$Lambda$2
            private final kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor.createType$lambda$4(this.arg$0, (kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.types.SimpleType createType$lambda$4(kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor intersectionTypeConstructor, kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner kotlinTypeRefiner) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return intersectionTypeConstructor.refine(kotlinTypeRefiner).createType();
    }

    public int hashCode() {
        return this.hashCode;
    }

    public final kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor setAlternative(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        return new kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor(this.intersectedTypes, kotlinType);
    }

    public final kotlin.reflect.jvm.internal.impl.types.KotlinType getAlternativeType() {
        return this.alternative;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor refine(kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner kotlinTypeRefiner) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        java.util.Collection<kotlin.reflect.jvm.internal.impl.types.KotlinType> collectionMo1836getSupertypes = mo1836getSupertypes();
        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(collectionMo1836getSupertypes, 10));
        java.util.Iterator<T> it = collectionMo1836getSupertypes.iterator();
        boolean z = false;
        while (it.hasNext()) {
            arrayList.add(((kotlin.reflect.jvm.internal.impl.types.KotlinType) it.next()).refine(kotlinTypeRefiner));
            z = true;
        }
        java.util.ArrayList arrayList2 = arrayList;
        kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor alternative = null;
        if (z) {
            kotlin.reflect.jvm.internal.impl.types.KotlinType alternativeType = getAlternativeType();
            alternative = new kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor(arrayList2).setAlternative(alternativeType != null ? alternativeType.refine(kotlinTypeRefiner) : null);
        }
        return alternative == null ? this : alternative;
    }
}
