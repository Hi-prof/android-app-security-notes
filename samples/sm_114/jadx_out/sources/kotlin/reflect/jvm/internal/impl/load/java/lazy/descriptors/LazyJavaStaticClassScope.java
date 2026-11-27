package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

/* JADX INFO: compiled from: LazyJavaStaticClassScope.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class LazyJavaStaticClassScope extends kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticScope {
    private final kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass jClass;
    private final kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassDescriptor ownerDescriptor;

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* JADX INFO: renamed from: getContributedClassifier */
    public kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor mo1837getContributedClassifier(kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation location) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(location, "location");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassDescriptor getOwnerDescriptor() {
        return this.ownerDescriptor;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaStaticClassScope(kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext c, kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass jClass, kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassDescriptor ownerDescriptor) {
        super(c);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(c, "c");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(jClass, "jClass");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(ownerDescriptor, "ownerDescriptor");
        this.jClass = jClass;
        this.ownerDescriptor = ownerDescriptor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean computeMemberIndex$lambda$0(kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember it) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(it, "it");
        return it.isStatic();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.ClassDeclaredMemberIndex computeMemberIndex() {
        return new kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.ClassDeclaredMemberIndex(this.jClass, new kotlin.jvm.functions.Function1() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticClassScope$$Lambda$0
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return java.lang.Boolean.valueOf(kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticClassScope.computeMemberIndex$lambda$0((kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember) obj));
            }
        });
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> computeFunctionNames(kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter kindFilter, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.name.Name, java.lang.Boolean> function1) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kindFilter, "kindFilter");
        java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> mutableSet = kotlin.collections.CollectionsKt.toMutableSet(getDeclaredMemberIndex().invoke().getMethodNames());
        kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticClassScope parentJavaStaticClassScope = kotlin.reflect.jvm.internal.impl.load.java.descriptors.UtilKt.getParentJavaStaticClassScope(getOwnerDescriptor());
        java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> functionNames = parentJavaStaticClassScope != null ? parentJavaStaticClassScope.getFunctionNames() : null;
        if (functionNames == null) {
            functionNames = kotlin.collections.SetsKt.emptySet();
        }
        mutableSet.addAll(functionNames);
        if (this.jClass.isEnum()) {
            mutableSet.addAll(kotlin.collections.CollectionsKt.listOf((java.lang.Object[]) new kotlin.reflect.jvm.internal.impl.name.Name[]{kotlin.reflect.jvm.internal.impl.builtins.StandardNames.ENUM_VALUE_OF, kotlin.reflect.jvm.internal.impl.builtins.StandardNames.ENUM_VALUES}));
        }
        mutableSet.addAll(getC().getComponents().getSyntheticPartsProvider().getStaticFunctionNames(getOwnerDescriptor(), getC()));
        return mutableSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> computePropertyNames(kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter kindFilter, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.name.Name, java.lang.Boolean> function1) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kindFilter, "kindFilter");
        java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> mutableSet = kotlin.collections.CollectionsKt.toMutableSet(getDeclaredMemberIndex().invoke().getFieldNames());
        flatMapJavaStaticSupertypesScopes(getOwnerDescriptor(), mutableSet, new kotlin.jvm.functions.Function1() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticClassScope$$Lambda$1
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticClassScope.computePropertyNames$lambda$3$lambda$2((kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope) obj);
            }
        });
        if (this.jClass.isEnum()) {
            mutableSet.add(kotlin.reflect.jvm.internal.impl.builtins.StandardNames.ENUM_ENTRIES);
        }
        return mutableSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.util.Collection computePropertyNames$lambda$3$lambda$2(kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope it) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(it, "it");
        return it.getVariableNames();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> computeClassNames(kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter kindFilter, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.name.Name, java.lang.Boolean> function1) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kindFilter, "kindFilter");
        return kotlin.collections.SetsKt.emptySet();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected void computeNonDeclaredFunctions(java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> result, kotlin.reflect.jvm.internal.impl.name.Name name) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(result, "result");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> collectionResolveOverridesForStaticMembers = kotlin.reflect.jvm.internal.impl.load.java.components.DescriptorResolverUtils.resolveOverridesForStaticMembers(name, getStaticFunctionsFromJavaSuperClasses(name, getOwnerDescriptor()), result, getOwnerDescriptor(), getC().getComponents().getErrorReporter(), getC().getComponents().getKotlinTypeChecker().getOverridingUtil());
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(collectionResolveOverridesForStaticMembers, "resolveOverridesForStaticMembers(...)");
        result.addAll(collectionResolveOverridesForStaticMembers);
        if (this.jClass.isEnum()) {
            if (kotlin.jvm.internal.Intrinsics.areEqual(name, kotlin.reflect.jvm.internal.impl.builtins.StandardNames.ENUM_VALUE_OF)) {
                kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor simpleFunctionDescriptorCreateEnumValueOfMethod = kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory.createEnumValueOfMethod(getOwnerDescriptor());
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(simpleFunctionDescriptorCreateEnumValueOfMethod, "createEnumValueOfMethod(...)");
                result.add(simpleFunctionDescriptorCreateEnumValueOfMethod);
            } else if (kotlin.jvm.internal.Intrinsics.areEqual(name, kotlin.reflect.jvm.internal.impl.builtins.StandardNames.ENUM_VALUES)) {
                kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor simpleFunctionDescriptorCreateEnumValuesMethod = kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory.createEnumValuesMethod(getOwnerDescriptor());
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(simpleFunctionDescriptorCreateEnumValuesMethod, "createEnumValuesMethod(...)");
                result.add(simpleFunctionDescriptorCreateEnumValuesMethod);
            }
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected void computeImplicitlyDeclaredFunctions(java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> result, kotlin.reflect.jvm.internal.impl.name.Name name) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(result, "result");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        getC().getComponents().getSyntheticPartsProvider().generateStaticFunctions(getOwnerDescriptor(), name, result, getC());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticScope, kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected void computeNonDeclaredProperties(final kotlin.reflect.jvm.internal.impl.name.Name name, java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor> result) {
        kotlin.reflect.jvm.internal.impl.name.Name name2;
        java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor> collection;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(result, "result");
        java.util.Set setFlatMapJavaStaticSupertypesScopes = flatMapJavaStaticSupertypesScopes(getOwnerDescriptor(), new java.util.LinkedHashSet(), new kotlin.jvm.functions.Function1(name) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticClassScope$$Lambda$2
            private final kotlin.reflect.jvm.internal.impl.name.Name arg$0;

            {
                this.arg$0 = name;
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticClassScope.computeNonDeclaredProperties$lambda$4(this.arg$0, (kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope) obj);
            }
        });
        if (!result.isEmpty()) {
            name2 = name;
            collection = result;
            java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor> collectionResolveOverridesForStaticMembers = kotlin.reflect.jvm.internal.impl.load.java.components.DescriptorResolverUtils.resolveOverridesForStaticMembers(name2, setFlatMapJavaStaticSupertypesScopes, collection, getOwnerDescriptor(), getC().getComponents().getErrorReporter(), getC().getComponents().getKotlinTypeChecker().getOverridingUtil());
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(collectionResolveOverridesForStaticMembers, "resolveOverridesForStaticMembers(...)");
            collection.addAll(collectionResolveOverridesForStaticMembers);
        } else {
            name2 = name;
            collection = result;
            java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
            for (java.lang.Object obj : setFlatMapJavaStaticSupertypesScopes) {
                kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor realOriginal = getRealOriginal((kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor) obj);
                java.lang.Object obj2 = linkedHashMap.get(realOriginal);
                if (obj2 == null) {
                    obj2 = (java.util.List) new java.util.ArrayList();
                    linkedHashMap.put(realOriginal, obj2);
                }
                ((java.util.List) obj2).add(obj);
            }
            java.util.ArrayList arrayList = new java.util.ArrayList();
            java.util.Iterator it = linkedHashMap.entrySet().iterator();
            while (it.hasNext()) {
                java.util.Collection collectionResolveOverridesForStaticMembers2 = kotlin.reflect.jvm.internal.impl.load.java.components.DescriptorResolverUtils.resolveOverridesForStaticMembers(name2, (java.util.Collection) ((java.util.Map.Entry) it.next()).getValue(), collection, getOwnerDescriptor(), getC().getComponents().getErrorReporter(), getC().getComponents().getKotlinTypeChecker().getOverridingUtil());
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(collectionResolveOverridesForStaticMembers2, "resolveOverridesForStaticMembers(...)");
                kotlin.collections.CollectionsKt.addAll(arrayList, collectionResolveOverridesForStaticMembers2);
            }
            collection.addAll(arrayList);
        }
        if (this.jClass.isEnum() && kotlin.jvm.internal.Intrinsics.areEqual(name2, kotlin.reflect.jvm.internal.impl.builtins.StandardNames.ENUM_ENTRIES)) {
            kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(collection, kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory.createEnumEntriesProperty(getOwnerDescriptor()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.util.Collection computeNonDeclaredProperties$lambda$4(kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope it) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(it, "it");
        return it.getContributedVariables(name, kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation.WHEN_GET_SUPER_MEMBERS);
    }

    private final java.util.Set<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> getStaticFunctionsFromJavaSuperClasses(kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor) {
        kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticClassScope parentJavaStaticClassScope = kotlin.reflect.jvm.internal.impl.load.java.descriptors.UtilKt.getParentJavaStaticClassScope(classDescriptor);
        return parentJavaStaticClassScope == null ? kotlin.collections.SetsKt.emptySet() : kotlin.collections.CollectionsKt.toSet(parentJavaStaticClassScope.getContributedFunctions(name, kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation.WHEN_GET_SUPER_MEMBERS));
    }

    private final <R> java.util.Set<R> flatMapJavaStaticSupertypesScopes(final kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor, final java.util.Set<R> set, final kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, ? extends java.util.Collection<? extends R>> function1) {
        kotlin.reflect.jvm.internal.impl.utils.DFS.dfs(kotlin.collections.CollectionsKt.listOf(classDescriptor), new kotlin.reflect.jvm.internal.impl.utils.DFS.Neighbors() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticClassScope$$Lambda$3
            @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.Neighbors
            public java.lang.Iterable getNeighbors(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticClassScope.flatMapJavaStaticSupertypesScopes$lambda$8((kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) obj);
            }
        }, new kotlin.reflect.jvm.internal.impl.utils.DFS.AbstractNodeHandler<kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.Unit>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticClassScope.flatMapJavaStaticSupertypesScopes.2
            /* JADX INFO: renamed from: result, reason: collision with other method in class */
            public void m1832result() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.NodeHandler
            public /* bridge */ /* synthetic */ java.lang.Object result() {
                m1832result();
                return kotlin.Unit.INSTANCE;
            }

            /* JADX WARN: Type inference incomplete: some casts might be missing */
            @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.AbstractNodeHandler, kotlin.reflect.jvm.internal.impl.utils.DFS.NodeHandler
            public boolean beforeChildren(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor current) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(current, "current");
                if (current == classDescriptor) {
                    return true;
                }
                kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope staticScope = current.getStaticScope();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(staticScope, "getStaticScope(...)");
                if (!(staticScope instanceof kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticScope)) {
                    return true;
                }
                set.addAll((java.util.Collection<? extends R>) ((java.util.Collection) function1.invoke2(staticScope)));
                return false;
            }
        });
        return set;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.lang.Iterable flatMapJavaStaticSupertypesScopes$lambda$8(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor) {
        java.util.Collection<kotlin.reflect.jvm.internal.impl.types.KotlinType> collectionMo1836getSupertypes = classDescriptor.getTypeConstructor().mo1836getSupertypes();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(collectionMo1836getSupertypes, "getSupertypes(...)");
        return kotlin.sequences.SequencesKt.asIterable(kotlin.sequences.SequencesKt.mapNotNull(kotlin.collections.CollectionsKt.asSequence(collectionMo1836getSupertypes), new kotlin.jvm.functions.Function1() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticClassScope$$Lambda$4
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticClassScope.flatMapJavaStaticSupertypesScopes$lambda$8$lambda$7((kotlin.reflect.jvm.internal.impl.types.KotlinType) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor flatMapJavaStaticSupertypesScopes$lambda$8$lambda$7(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptorMo1835getDeclarationDescriptor = kotlinType.getConstructor().mo1835getDeclarationDescriptor();
        if (classifierDescriptorMo1835getDeclarationDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) {
            return (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) classifierDescriptorMo1835getDeclarationDescriptor;
        }
        return null;
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor getRealOriginal(kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor propertyDescriptor) {
        if (propertyDescriptor.getKind().isReal()) {
            return propertyDescriptor;
        }
        java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor> overriddenDescriptors = propertyDescriptor.getOverriddenDescriptors();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(overriddenDescriptors, "getOverriddenDescriptors(...)");
        java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor> collection = overriddenDescriptors;
        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(collection, 10));
        for (kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor propertyDescriptor2 : collection) {
            kotlin.jvm.internal.Intrinsics.checkNotNull(propertyDescriptor2);
            arrayList.add(getRealOriginal(propertyDescriptor2));
        }
        return (kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor) kotlin.collections.CollectionsKt.single(kotlin.collections.CollectionsKt.distinct(arrayList));
    }
}
