package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

/* JADX INFO: compiled from: DeserializedMemberScope.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class DeserializedMemberScope extends kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl {
    static final /* synthetic */ kotlin.reflect.KProperty<java.lang.Object>[] $$delegatedProperties = {kotlin.jvm.internal.Reflection.property1(new kotlin.jvm.internal.PropertyReference1Impl(kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.class, "classNames", "getClassNames$deserialization()Ljava/util/Set;", 0)), kotlin.jvm.internal.Reflection.property1(new kotlin.jvm.internal.PropertyReference1Impl(kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.class, "classifierNamesLazy", "getClassifierNamesLazy()Ljava/util/Set;", 0))};
    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext c;
    private final kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue classNames$delegate;
    private final kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue classifierNamesLazy$delegate;
    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation impl;

    /* JADX INFO: compiled from: DeserializedMemberScope.kt */
    private interface Implementation {
        void addFunctionsAndPropertiesTo(java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor> collection, kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter descriptorKindFilter, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.name.Name, java.lang.Boolean> function1, kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation lookupLocation);

        java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> getContributedFunctions(kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation lookupLocation);

        java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor> getContributedVariables(kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation lookupLocation);

        java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> getFunctionNames();

        kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor getTypeAliasByName(kotlin.reflect.jvm.internal.impl.name.Name name);

        java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> getTypeAliasNames();

        java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> getVariableNames();
    }

    protected abstract void addEnumEntryDescriptors(java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor> collection, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.name.Name, java.lang.Boolean> function1);

    protected void computeNonDeclaredFunctions(kotlin.reflect.jvm.internal.impl.name.Name name, java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> functions) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(functions, "functions");
    }

    protected void computeNonDeclaredProperties(kotlin.reflect.jvm.internal.impl.name.Name name, java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor> descriptors) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(descriptors, "descriptors");
    }

    protected abstract kotlin.reflect.jvm.internal.impl.name.ClassId createClassId(kotlin.reflect.jvm.internal.impl.name.Name name);

    protected abstract java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> getNonDeclaredClassifierNames();

    protected abstract java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> getNonDeclaredFunctionNames();

    protected abstract java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> getNonDeclaredVariableNames();

    protected boolean isDeclaredFunctionAvailable(kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor function) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(function, "function");
        return true;
    }

    protected final kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext getC() {
        return this.c;
    }

    protected DeserializedMemberScope(kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext c, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function> functionList, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property> propertyList, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeAlias> typeAliasList, final kotlin.jvm.functions.Function0<? extends java.util.Collection<kotlin.reflect.jvm.internal.impl.name.Name>> classNames) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(c, "c");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(functionList, "functionList");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(propertyList, "propertyList");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeAliasList, "typeAliasList");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(classNames, "classNames");
        this.c = c;
        this.impl = createImplementation(functionList, propertyList, typeAliasList);
        this.classNames$delegate = c.getStorageManager().createLazyValue(new kotlin.jvm.functions.Function0(classNames) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$$Lambda$0
            private final kotlin.jvm.functions.Function0 arg$0;

            {
                this.arg$0 = classNames;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.classNames_delegate$lambda$0(this.arg$0);
            }
        });
        this.classifierNamesLazy$delegate = c.getStorageManager().createNullableLazyValue(new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$$Lambda$1
            private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.classifierNamesLazy_delegate$lambda$1(this.arg$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.util.Set classNames_delegate$lambda$0(kotlin.jvm.functions.Function0 function0) {
        return kotlin.collections.CollectionsKt.toSet((java.lang.Iterable) function0.invoke());
    }

    public final java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> getClassNames$deserialization() {
        return (java.util.Set) kotlin.reflect.jvm.internal.impl.storage.StorageKt.getValue(this.classNames$delegate, this, (kotlin.reflect.KProperty<?>) $$delegatedProperties[0]);
    }

    private final java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> getClassifierNamesLazy() {
        return (java.util.Set) kotlin.reflect.jvm.internal.impl.storage.StorageKt.getValue(this.classifierNamesLazy$delegate, this, (kotlin.reflect.KProperty<?>) $$delegatedProperties[1]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.util.Set classifierNamesLazy_delegate$lambda$1(kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope deserializedMemberScope) {
        java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> nonDeclaredClassifierNames = deserializedMemberScope.getNonDeclaredClassifierNames();
        if (nonDeclaredClassifierNames == null) {
            return null;
        }
        return kotlin.collections.SetsKt.plus(kotlin.collections.SetsKt.plus((java.util.Set) deserializedMemberScope.getClassNames$deserialization(), (java.lang.Iterable) deserializedMemberScope.impl.getTypeAliasNames()), (java.lang.Iterable) nonDeclaredClassifierNames);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> getFunctionNames() {
        return this.impl.getFunctionNames();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> getVariableNames() {
        return this.impl.getVariableNames();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> getClassifierNames() {
        return getClassifierNamesLazy();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> getContributedFunctions(kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation location) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(location, "location");
        return this.impl.getContributedFunctions(name, location);
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor getTypeAliasByName(kotlin.reflect.jvm.internal.impl.name.Name name) {
        return this.impl.getTypeAliasByName(name);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor> getContributedVariables(kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation location) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(location, "location");
        return this.impl.getContributedVariables(name, location);
    }

    protected final java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor> computeDescriptors(kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter kindFilter, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.name.Name, java.lang.Boolean> nameFilter, kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation location) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kindFilter, "kindFilter");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(nameFilter, "nameFilter");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(location, "location");
        java.util.ArrayList arrayList = new java.util.ArrayList(0);
        if (kindFilter.acceptsKinds(kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter.Companion.getSINGLETON_CLASSIFIERS_MASK())) {
            addEnumEntryDescriptors(arrayList, nameFilter);
        }
        java.util.ArrayList arrayList2 = arrayList;
        this.impl.addFunctionsAndPropertiesTo(arrayList2, kindFilter, nameFilter, location);
        if (kindFilter.acceptsKinds(kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter.Companion.getCLASSIFIERS_MASK())) {
            for (kotlin.reflect.jvm.internal.impl.name.Name name : getClassNames$deserialization()) {
                if (nameFilter.invoke2(name).booleanValue()) {
                    kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(arrayList2, deserializeClass(name));
                }
            }
        }
        if (kindFilter.acceptsKinds(kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter.Companion.getTYPE_ALIASES_MASK())) {
            for (kotlin.reflect.jvm.internal.impl.name.Name name2 : this.impl.getTypeAliasNames()) {
                if (nameFilter.invoke2(name2).booleanValue()) {
                    kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(arrayList2, this.impl.getTypeAliasByName(name2));
                }
            }
        }
        return kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.compact(arrayList);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* JADX INFO: renamed from: getContributedClassifier */
    public kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor mo1837getContributedClassifier(kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation location) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(location, "location");
        if (hasClass(name)) {
            return deserializeClass(name);
        }
        if (this.impl.getTypeAliasNames().contains(name)) {
            return getTypeAliasByName(name);
        }
        return null;
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor deserializeClass(kotlin.reflect.jvm.internal.impl.name.Name name) {
        return this.c.getComponents().deserializeClass(createClassId(name));
    }

    protected boolean hasClass(kotlin.reflect.jvm.internal.impl.name.Name name) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        return getClassNames$deserialization().contains(name);
    }

    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation createImplementation(java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function> list, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property> list2, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeAlias> list3) {
        if (this.c.getComponents().getConfiguration().getPreserveDeclarationsOrdering()) {
            return new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.NoReorderImplementation(this, list, list2, list3);
        }
        return new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.OptimizedImplementation(this, list, list2, list3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: DeserializedMemberScope.kt */
    final class OptimizedImplementation implements kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation {
        static final /* synthetic */ kotlin.reflect.KProperty<java.lang.Object>[] $$delegatedProperties = {kotlin.jvm.internal.Reflection.property1(new kotlin.jvm.internal.PropertyReference1Impl(kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.OptimizedImplementation.class, "functionNames", "getFunctionNames()Ljava/util/Set;", 0)), kotlin.jvm.internal.Reflection.property1(new kotlin.jvm.internal.PropertyReference1Impl(kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.OptimizedImplementation.class, "variableNames", "getVariableNames()Ljava/util/Set;", 0))};
        private final kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue functionNames$delegate;
        private final java.util.Map<kotlin.reflect.jvm.internal.impl.name.Name, byte[]> functionProtosBytes;
        private final kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull<kotlin.reflect.jvm.internal.impl.name.Name, java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor>> functions;
        private final kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull<kotlin.reflect.jvm.internal.impl.name.Name, java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor>> properties;
        private final java.util.Map<kotlin.reflect.jvm.internal.impl.name.Name, byte[]> propertyProtosBytes;
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope this$0;
        private final kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable<kotlin.reflect.jvm.internal.impl.name.Name, kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor> typeAliasByName;
        private final java.util.Map<kotlin.reflect.jvm.internal.impl.name.Name, byte[]> typeAliasBytes;
        private final kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue variableNames$delegate;

        public OptimizedImplementation(kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope deserializedMemberScope, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function> functionList, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property> propertyList, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeAlias> typeAliasList) throws java.io.IOException {
            java.util.Map<kotlin.reflect.jvm.internal.impl.name.Name, byte[]> mapEmptyMap;
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(functionList, "functionList");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(propertyList, "propertyList");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeAliasList, "typeAliasList");
            this.this$0 = deserializedMemberScope;
            java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
            for (java.lang.Object obj : functionList) {
                kotlin.reflect.jvm.internal.impl.name.Name name = kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt.getName(deserializedMemberScope.getC().getNameResolver(), ((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function) ((kotlin.reflect.jvm.internal.impl.protobuf.MessageLite) obj)).getName());
                java.lang.Object obj2 = linkedHashMap.get(name);
                if (obj2 == null) {
                    obj2 = (java.util.List) new java.util.ArrayList();
                    linkedHashMap.put(name, obj2);
                }
                ((java.util.List) obj2).add(obj);
            }
            this.functionProtosBytes = packToByteArray(linkedHashMap);
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope deserializedMemberScope2 = this.this$0;
            java.util.LinkedHashMap linkedHashMap2 = new java.util.LinkedHashMap();
            for (java.lang.Object obj3 : propertyList) {
                kotlin.reflect.jvm.internal.impl.name.Name name2 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt.getName(deserializedMemberScope2.getC().getNameResolver(), ((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property) ((kotlin.reflect.jvm.internal.impl.protobuf.MessageLite) obj3)).getName());
                java.lang.Object obj4 = linkedHashMap2.get(name2);
                if (obj4 == null) {
                    obj4 = (java.util.List) new java.util.ArrayList();
                    linkedHashMap2.put(name2, obj4);
                }
                ((java.util.List) obj4).add(obj3);
            }
            this.propertyProtosBytes = packToByteArray(linkedHashMap2);
            if (!this.this$0.getC().getComponents().getConfiguration().getTypeAliasesAllowed()) {
                mapEmptyMap = kotlin.collections.MapsKt.emptyMap();
            } else {
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope deserializedMemberScope3 = this.this$0;
                java.util.LinkedHashMap linkedHashMap3 = new java.util.LinkedHashMap();
                for (java.lang.Object obj5 : typeAliasList) {
                    kotlin.reflect.jvm.internal.impl.name.Name name3 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt.getName(deserializedMemberScope3.getC().getNameResolver(), ((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeAlias) ((kotlin.reflect.jvm.internal.impl.protobuf.MessageLite) obj5)).getName());
                    java.lang.Object obj6 = linkedHashMap3.get(name3);
                    if (obj6 == null) {
                        obj6 = (java.util.List) new java.util.ArrayList();
                        linkedHashMap3.put(name3, obj6);
                    }
                    ((java.util.List) obj6).add(obj5);
                }
                mapEmptyMap = packToByteArray(linkedHashMap3);
            }
            this.typeAliasBytes = mapEmptyMap;
            this.functions = this.this$0.getC().getStorageManager().createMemoizedFunction(new kotlin.jvm.functions.Function1(this) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$OptimizedImplementation$$Lambda$0
                private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.OptimizedImplementation arg$0;

                {
                    this.arg$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                /* JADX INFO: renamed from: invoke */
                public java.lang.Object invoke2(java.lang.Object obj7) {
                    return kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.OptimizedImplementation.functions$lambda$5(this.arg$0, (kotlin.reflect.jvm.internal.impl.name.Name) obj7);
                }
            });
            this.properties = this.this$0.getC().getStorageManager().createMemoizedFunction(new kotlin.jvm.functions.Function1(this) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$OptimizedImplementation$$Lambda$1
                private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.OptimizedImplementation arg$0;

                {
                    this.arg$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                /* JADX INFO: renamed from: invoke */
                public java.lang.Object invoke2(java.lang.Object obj7) {
                    return kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.OptimizedImplementation.properties$lambda$6(this.arg$0, (kotlin.reflect.jvm.internal.impl.name.Name) obj7);
                }
            });
            this.typeAliasByName = this.this$0.getC().getStorageManager().createMemoizedFunctionWithNullableValues(new kotlin.jvm.functions.Function1(this) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$OptimizedImplementation$$Lambda$2
                private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.OptimizedImplementation arg$0;

                {
                    this.arg$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                /* JADX INFO: renamed from: invoke */
                public java.lang.Object invoke2(java.lang.Object obj7) {
                    return kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.OptimizedImplementation.typeAliasByName$lambda$7(this.arg$0, (kotlin.reflect.jvm.internal.impl.name.Name) obj7);
                }
            });
            kotlin.reflect.jvm.internal.impl.storage.StorageManager storageManager = this.this$0.getC().getStorageManager();
            final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope deserializedMemberScope4 = this.this$0;
            this.functionNames$delegate = storageManager.createLazyValue(new kotlin.jvm.functions.Function0(this, deserializedMemberScope4) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$OptimizedImplementation$$Lambda$3
                private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.OptimizedImplementation arg$0;
                private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope arg$1;

                {
                    this.arg$0 = this;
                    this.arg$1 = deserializedMemberScope4;
                }

                @Override // kotlin.jvm.functions.Function0
                public java.lang.Object invoke() {
                    return kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.OptimizedImplementation.functionNames_delegate$lambda$8(this.arg$0, this.arg$1);
                }
            });
            kotlin.reflect.jvm.internal.impl.storage.StorageManager storageManager2 = this.this$0.getC().getStorageManager();
            final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope deserializedMemberScope5 = this.this$0;
            this.variableNames$delegate = storageManager2.createLazyValue(new kotlin.jvm.functions.Function0(this, deserializedMemberScope5) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$OptimizedImplementation$$Lambda$4
                private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.OptimizedImplementation arg$0;
                private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope arg$1;

                {
                    this.arg$0 = this;
                    this.arg$1 = deserializedMemberScope5;
                }

                @Override // kotlin.jvm.functions.Function0
                public java.lang.Object invoke() {
                    return kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.OptimizedImplementation.variableNames_delegate$lambda$9(this.arg$0, this.arg$1);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final java.util.Collection functions$lambda$5(kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.OptimizedImplementation optimizedImplementation, kotlin.reflect.jvm.internal.impl.name.Name it) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(it, "it");
            return optimizedImplementation.computeFunctions(it);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final java.util.Collection properties$lambda$6(kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.OptimizedImplementation optimizedImplementation, kotlin.reflect.jvm.internal.impl.name.Name it) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(it, "it");
            return optimizedImplementation.computeProperties(it);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor typeAliasByName$lambda$7(kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.OptimizedImplementation optimizedImplementation, kotlin.reflect.jvm.internal.impl.name.Name it) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(it, "it");
            return optimizedImplementation.createTypeAlias(it);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> getFunctionNames() {
            return (java.util.Set) kotlin.reflect.jvm.internal.impl.storage.StorageKt.getValue(this.functionNames$delegate, this, (kotlin.reflect.KProperty<?>) $$delegatedProperties[0]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final java.util.Set functionNames_delegate$lambda$8(kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.OptimizedImplementation optimizedImplementation, kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope deserializedMemberScope) {
            return kotlin.collections.SetsKt.plus((java.util.Set) optimizedImplementation.functionProtosBytes.keySet(), (java.lang.Iterable) deserializedMemberScope.getNonDeclaredFunctionNames());
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> getVariableNames() {
            return (java.util.Set) kotlin.reflect.jvm.internal.impl.storage.StorageKt.getValue(this.variableNames$delegate, this, (kotlin.reflect.KProperty<?>) $$delegatedProperties[1]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final java.util.Set variableNames_delegate$lambda$9(kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.OptimizedImplementation optimizedImplementation, kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope deserializedMemberScope) {
            return kotlin.collections.SetsKt.plus((java.util.Set) optimizedImplementation.propertyProtosBytes.keySet(), (java.lang.Iterable) deserializedMemberScope.getNonDeclaredVariableNames());
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> getTypeAliasNames() {
            return this.typeAliasBytes.keySet();
        }

        /* JADX WARN: Code duplicated, block: B:7:0x002e  */
        private final java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> computeFunctions(kotlin.reflect.jvm.internal.impl.name.Name name) {
            java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function> listEmptyList;
            java.util.Map<kotlin.reflect.jvm.internal.impl.name.Name, byte[]> map = this.functionProtosBytes;
            kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function> PARSER = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function.PARSER;
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(PARSER, "PARSER");
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope deserializedMemberScope = this.this$0;
            byte[] bArr = map.get(name);
            if (bArr != null) {
                java.util.List list = kotlin.sequences.SequencesKt.toList(kotlin.sequences.SequencesKt.generateSequence(new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$OptimizedImplementation$computeDescriptors$1$1(PARSER, new java.io.ByteArrayInputStream(bArr), this.this$0)));
                if (list != null) {
                    listEmptyList = list;
                } else {
                    listEmptyList = kotlin.collections.CollectionsKt.emptyList();
                }
            } else {
                listEmptyList = kotlin.collections.CollectionsKt.emptyList();
            }
            java.util.ArrayList arrayList = new java.util.ArrayList(listEmptyList.size());
            for (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function function : listEmptyList) {
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer memberDeserializer = deserializedMemberScope.getC().getMemberDeserializer();
                kotlin.jvm.internal.Intrinsics.checkNotNull(function);
                kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor simpleFunctionDescriptorLoadFunction = memberDeserializer.loadFunction(function);
                if (!deserializedMemberScope.isDeclaredFunctionAvailable(simpleFunctionDescriptorLoadFunction)) {
                    simpleFunctionDescriptorLoadFunction = null;
                }
                if (simpleFunctionDescriptorLoadFunction != null) {
                    arrayList.add(simpleFunctionDescriptorLoadFunction);
                }
            }
            java.util.ArrayList arrayList2 = arrayList;
            deserializedMemberScope.computeNonDeclaredFunctions(name, arrayList2);
            return kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.compact(arrayList2);
        }

        /* JADX WARN: Code duplicated, block: B:7:0x002e  */
        private final java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor> computeProperties(kotlin.reflect.jvm.internal.impl.name.Name name) {
            java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property> listEmptyList;
            java.util.Map<kotlin.reflect.jvm.internal.impl.name.Name, byte[]> map = this.propertyProtosBytes;
            kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property> PARSER = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property.PARSER;
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(PARSER, "PARSER");
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope deserializedMemberScope = this.this$0;
            byte[] bArr = map.get(name);
            if (bArr != null) {
                java.util.List list = kotlin.sequences.SequencesKt.toList(kotlin.sequences.SequencesKt.generateSequence(new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$OptimizedImplementation$computeDescriptors$1$1(PARSER, new java.io.ByteArrayInputStream(bArr), this.this$0)));
                if (list != null) {
                    listEmptyList = list;
                } else {
                    listEmptyList = kotlin.collections.CollectionsKt.emptyList();
                }
            } else {
                listEmptyList = kotlin.collections.CollectionsKt.emptyList();
            }
            java.util.ArrayList arrayList = new java.util.ArrayList(listEmptyList.size());
            for (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property property : listEmptyList) {
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer memberDeserializer = deserializedMemberScope.getC().getMemberDeserializer();
                kotlin.jvm.internal.Intrinsics.checkNotNull(property);
                kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor propertyDescriptorLoadProperty$default = kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer.loadProperty$default(memberDeserializer, property, false, 2, null);
                if (propertyDescriptorLoadProperty$default != null) {
                    arrayList.add(propertyDescriptorLoadProperty$default);
                }
            }
            java.util.ArrayList arrayList2 = arrayList;
            deserializedMemberScope.computeNonDeclaredProperties(name, arrayList2);
            return kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.compact(arrayList2);
        }

        private final kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor createTypeAlias(kotlin.reflect.jvm.internal.impl.name.Name name) {
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeAlias delimitedFrom;
            byte[] bArr = this.typeAliasBytes.get(name);
            if (bArr == null || (delimitedFrom = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeAlias.parseDelimitedFrom(new java.io.ByteArrayInputStream(bArr), this.this$0.getC().getComponents().getExtensionRegistryLite())) == null) {
                return null;
            }
            return this.this$0.getC().getMemberDeserializer().loadTypeAlias(delimitedFrom);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> getContributedFunctions(kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation location) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(location, "location");
            return !getFunctionNames().contains(name) ? kotlin.collections.CollectionsKt.emptyList() : this.functions.invoke2(name);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor getTypeAliasByName(kotlin.reflect.jvm.internal.impl.name.Name name) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
            return this.typeAliasByName.invoke2(name);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor> getContributedVariables(kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation location) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(location, "location");
            return !getVariableNames().contains(name) ? kotlin.collections.CollectionsKt.emptyList() : this.properties.invoke2(name);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public void addFunctionsAndPropertiesTo(java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor> result, kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter kindFilter, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.name.Name, java.lang.Boolean> nameFilter, kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation location) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(result, "result");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kindFilter, "kindFilter");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(nameFilter, "nameFilter");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(location, "location");
            if (kindFilter.acceptsKinds(kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter.Companion.getVARIABLES_MASK())) {
                java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> variableNames = getVariableNames();
                java.util.ArrayList arrayList = new java.util.ArrayList();
                for (kotlin.reflect.jvm.internal.impl.name.Name name : variableNames) {
                    if (nameFilter.invoke2(name).booleanValue()) {
                        arrayList.addAll(getContributedVariables(name, location));
                    }
                }
                kotlin.reflect.jvm.internal.impl.resolve.MemberComparator.NameAndTypeMemberComparator INSTANCE = kotlin.reflect.jvm.internal.impl.resolve.MemberComparator.NameAndTypeMemberComparator.INSTANCE;
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(INSTANCE, "INSTANCE");
                kotlin.collections.CollectionsKt.sortWith(arrayList, INSTANCE);
                result.addAll(arrayList);
            }
            if (kindFilter.acceptsKinds(kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter.Companion.getFUNCTIONS_MASK())) {
                java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> functionNames = getFunctionNames();
                java.util.ArrayList arrayList2 = new java.util.ArrayList();
                for (kotlin.reflect.jvm.internal.impl.name.Name name2 : functionNames) {
                    if (nameFilter.invoke2(name2).booleanValue()) {
                        arrayList2.addAll(getContributedFunctions(name2, location));
                    }
                }
                kotlin.reflect.jvm.internal.impl.resolve.MemberComparator.NameAndTypeMemberComparator INSTANCE2 = kotlin.reflect.jvm.internal.impl.resolve.MemberComparator.NameAndTypeMemberComparator.INSTANCE;
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(INSTANCE2, "INSTANCE");
                kotlin.collections.CollectionsKt.sortWith(arrayList2, INSTANCE2);
                result.addAll(arrayList2);
            }
        }

        private final java.util.Map<kotlin.reflect.jvm.internal.impl.name.Name, byte[]> packToByteArray(java.util.Map<kotlin.reflect.jvm.internal.impl.name.Name, ? extends java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite>> map) throws java.io.IOException {
            java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap(kotlin.collections.MapsKt.mapCapacity(map.size()));
            java.util.Iterator<T> it = map.entrySet().iterator();
            while (it.hasNext()) {
                java.util.Map.Entry entry = (java.util.Map.Entry) it.next();
                java.lang.Object key = entry.getKey();
                java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                java.lang.Iterable iterable = (java.lang.Iterable) entry.getValue();
                java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(iterable, 10));
                java.util.Iterator it2 = iterable.iterator();
                while (it2.hasNext()) {
                    ((kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite) it2.next()).writeDelimitedTo(byteArrayOutputStream);
                    arrayList.add(kotlin.Unit.INSTANCE);
                }
                linkedHashMap.put(key, byteArrayOutputStream.toByteArray());
            }
            return linkedHashMap;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: DeserializedMemberScope.kt */
    final class NoReorderImplementation implements kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation {
        static final /* synthetic */ kotlin.reflect.KProperty<java.lang.Object>[] $$delegatedProperties = {kotlin.jvm.internal.Reflection.property1(new kotlin.jvm.internal.PropertyReference1Impl(kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.NoReorderImplementation.class, "declaredFunctions", "getDeclaredFunctions()Ljava/util/List;", 0)), kotlin.jvm.internal.Reflection.property1(new kotlin.jvm.internal.PropertyReference1Impl(kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.NoReorderImplementation.class, "declaredProperties", "getDeclaredProperties()Ljava/util/List;", 0)), kotlin.jvm.internal.Reflection.property1(new kotlin.jvm.internal.PropertyReference1Impl(kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.NoReorderImplementation.class, "allTypeAliases", "getAllTypeAliases()Ljava/util/List;", 0)), kotlin.jvm.internal.Reflection.property1(new kotlin.jvm.internal.PropertyReference1Impl(kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.NoReorderImplementation.class, "allFunctions", "getAllFunctions()Ljava/util/List;", 0)), kotlin.jvm.internal.Reflection.property1(new kotlin.jvm.internal.PropertyReference1Impl(kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.NoReorderImplementation.class, "allProperties", "getAllProperties()Ljava/util/List;", 0)), kotlin.jvm.internal.Reflection.property1(new kotlin.jvm.internal.PropertyReference1Impl(kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.NoReorderImplementation.class, "typeAliasesByName", "getTypeAliasesByName()Ljava/util/Map;", 0)), kotlin.jvm.internal.Reflection.property1(new kotlin.jvm.internal.PropertyReference1Impl(kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.NoReorderImplementation.class, "functionsByName", "getFunctionsByName()Ljava/util/Map;", 0)), kotlin.jvm.internal.Reflection.property1(new kotlin.jvm.internal.PropertyReference1Impl(kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.NoReorderImplementation.class, "propertiesByName", "getPropertiesByName()Ljava/util/Map;", 0)), kotlin.jvm.internal.Reflection.property1(new kotlin.jvm.internal.PropertyReference1Impl(kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.NoReorderImplementation.class, "functionNames", "getFunctionNames()Ljava/util/Set;", 0)), kotlin.jvm.internal.Reflection.property1(new kotlin.jvm.internal.PropertyReference1Impl(kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.NoReorderImplementation.class, "variableNames", "getVariableNames()Ljava/util/Set;", 0))};
        private final kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue allFunctions$delegate;
        private final kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue allProperties$delegate;
        private final kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue allTypeAliases$delegate;
        private final kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue declaredFunctions$delegate;
        private final kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue declaredProperties$delegate;
        private final java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function> functionList;
        private final kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue functionNames$delegate;
        private final kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue functionsByName$delegate;
        private final kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue propertiesByName$delegate;
        private final java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property> propertyList;
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope this$0;
        private final java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeAlias> typeAliasList;
        private final kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue typeAliasesByName$delegate;
        private final kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue variableNames$delegate;

        public NoReorderImplementation(final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope deserializedMemberScope, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function> functionList, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property> propertyList, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeAlias> typeAliasList) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(functionList, "functionList");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(propertyList, "propertyList");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeAliasList, "typeAliasList");
            this.this$0 = deserializedMemberScope;
            this.functionList = functionList;
            this.propertyList = propertyList;
            this.typeAliasList = deserializedMemberScope.getC().getComponents().getConfiguration().getTypeAliasesAllowed() ? typeAliasList : kotlin.collections.CollectionsKt.emptyList();
            this.declaredFunctions$delegate = deserializedMemberScope.getC().getStorageManager().createLazyValue(new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$NoReorderImplementation$$Lambda$0
                private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.NoReorderImplementation arg$0;

                {
                    this.arg$0 = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public java.lang.Object invoke() {
                    return this.arg$0.computeFunctions();
                }
            });
            this.declaredProperties$delegate = deserializedMemberScope.getC().getStorageManager().createLazyValue(new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$NoReorderImplementation$$Lambda$1
                private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.NoReorderImplementation arg$0;

                {
                    this.arg$0 = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public java.lang.Object invoke() {
                    return this.arg$0.computeProperties();
                }
            });
            this.allTypeAliases$delegate = deserializedMemberScope.getC().getStorageManager().createLazyValue(new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$NoReorderImplementation$$Lambda$2
                private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.NoReorderImplementation arg$0;

                {
                    this.arg$0 = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public java.lang.Object invoke() {
                    return this.arg$0.computeTypeAliases();
                }
            });
            this.allFunctions$delegate = deserializedMemberScope.getC().getStorageManager().createLazyValue(new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$NoReorderImplementation$$Lambda$3
                private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.NoReorderImplementation arg$0;

                {
                    this.arg$0 = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public java.lang.Object invoke() {
                    return kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.NoReorderImplementation.allFunctions_delegate$lambda$3(this.arg$0);
                }
            });
            this.allProperties$delegate = deserializedMemberScope.getC().getStorageManager().createLazyValue(new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$NoReorderImplementation$$Lambda$4
                private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.NoReorderImplementation arg$0;

                {
                    this.arg$0 = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public java.lang.Object invoke() {
                    return kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.NoReorderImplementation.allProperties_delegate$lambda$4(this.arg$0);
                }
            });
            this.typeAliasesByName$delegate = deserializedMemberScope.getC().getStorageManager().createLazyValue(new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$NoReorderImplementation$$Lambda$5
                private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.NoReorderImplementation arg$0;

                {
                    this.arg$0 = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public java.lang.Object invoke() {
                    return kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.NoReorderImplementation.typeAliasesByName_delegate$lambda$6(this.arg$0);
                }
            });
            this.functionsByName$delegate = deserializedMemberScope.getC().getStorageManager().createLazyValue(new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$NoReorderImplementation$$Lambda$6
                private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.NoReorderImplementation arg$0;

                {
                    this.arg$0 = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public java.lang.Object invoke() {
                    return kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.NoReorderImplementation.functionsByName_delegate$lambda$8(this.arg$0);
                }
            });
            this.propertiesByName$delegate = deserializedMemberScope.getC().getStorageManager().createLazyValue(new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$NoReorderImplementation$$Lambda$7
                private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.NoReorderImplementation arg$0;

                {
                    this.arg$0 = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public java.lang.Object invoke() {
                    return kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.NoReorderImplementation.propertiesByName_delegate$lambda$10(this.arg$0);
                }
            });
            this.functionNames$delegate = deserializedMemberScope.getC().getStorageManager().createLazyValue(new kotlin.jvm.functions.Function0(this, deserializedMemberScope) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$NoReorderImplementation$$Lambda$8
                private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.NoReorderImplementation arg$0;
                private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope arg$1;

                {
                    this.arg$0 = this;
                    this.arg$1 = deserializedMemberScope;
                }

                @Override // kotlin.jvm.functions.Function0
                public java.lang.Object invoke() {
                    return kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.NoReorderImplementation.functionNames_delegate$lambda$12(this.arg$0, this.arg$1);
                }
            });
            this.variableNames$delegate = deserializedMemberScope.getC().getStorageManager().createLazyValue(new kotlin.jvm.functions.Function0(this, deserializedMemberScope) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$NoReorderImplementation$$Lambda$9
                private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.NoReorderImplementation arg$0;
                private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope arg$1;

                {
                    this.arg$0 = this;
                    this.arg$1 = deserializedMemberScope;
                }

                @Override // kotlin.jvm.functions.Function0
                public java.lang.Object invoke() {
                    return kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.NoReorderImplementation.variableNames_delegate$lambda$14(this.arg$0, this.arg$1);
                }
            });
        }

        private final java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> getDeclaredFunctions() {
            return (java.util.List) kotlin.reflect.jvm.internal.impl.storage.StorageKt.getValue(this.declaredFunctions$delegate, this, (kotlin.reflect.KProperty<?>) $$delegatedProperties[0]);
        }

        private final java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor> getDeclaredProperties() {
            return (java.util.List) kotlin.reflect.jvm.internal.impl.storage.StorageKt.getValue(this.declaredProperties$delegate, this, (kotlin.reflect.KProperty<?>) $$delegatedProperties[1]);
        }

        private final java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor> getAllTypeAliases() {
            return (java.util.List) kotlin.reflect.jvm.internal.impl.storage.StorageKt.getValue(this.allTypeAliases$delegate, this, (kotlin.reflect.KProperty<?>) $$delegatedProperties[2]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final java.util.List allFunctions_delegate$lambda$3(kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.NoReorderImplementation noReorderImplementation) {
            return kotlin.collections.CollectionsKt.plus((java.util.Collection) noReorderImplementation.getDeclaredFunctions(), (java.lang.Iterable) noReorderImplementation.computeAllNonDeclaredFunctions());
        }

        private final java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> getAllFunctions() {
            return (java.util.List) kotlin.reflect.jvm.internal.impl.storage.StorageKt.getValue(this.allFunctions$delegate, this, (kotlin.reflect.KProperty<?>) $$delegatedProperties[3]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final java.util.List allProperties_delegate$lambda$4(kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.NoReorderImplementation noReorderImplementation) {
            return kotlin.collections.CollectionsKt.plus((java.util.Collection) noReorderImplementation.getDeclaredProperties(), (java.lang.Iterable) noReorderImplementation.computeAllNonDeclaredProperties());
        }

        private final java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor> getAllProperties() {
            return (java.util.List) kotlin.reflect.jvm.internal.impl.storage.StorageKt.getValue(this.allProperties$delegate, this, (kotlin.reflect.KProperty<?>) $$delegatedProperties[4]);
        }

        private final java.util.Map<kotlin.reflect.jvm.internal.impl.name.Name, kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor> getTypeAliasesByName() {
            return (java.util.Map) kotlin.reflect.jvm.internal.impl.storage.StorageKt.getValue(this.typeAliasesByName$delegate, this, (kotlin.reflect.KProperty<?>) $$delegatedProperties[5]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final java.util.Map typeAliasesByName_delegate$lambda$6(kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.NoReorderImplementation noReorderImplementation) {
            java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor> allTypeAliases = noReorderImplementation.getAllTypeAliases();
            java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap(kotlin.ranges.RangesKt.coerceAtLeast(kotlin.collections.MapsKt.mapCapacity(kotlin.collections.CollectionsKt.collectionSizeOrDefault(allTypeAliases, 10)), 16));
            for (java.lang.Object obj : allTypeAliases) {
                kotlin.reflect.jvm.internal.impl.name.Name name = ((kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor) obj).getName();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                linkedHashMap.put(name, obj);
            }
            return linkedHashMap;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final java.util.Map functionsByName_delegate$lambda$8(kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.NoReorderImplementation noReorderImplementation) {
            java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> allFunctions = noReorderImplementation.getAllFunctions();
            java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
            for (java.lang.Object obj : allFunctions) {
                kotlin.reflect.jvm.internal.impl.name.Name name = ((kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) obj).getName();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                java.lang.Object obj2 = linkedHashMap.get(name);
                if (obj2 == null) {
                    obj2 = (java.util.List) new java.util.ArrayList();
                    linkedHashMap.put(name, obj2);
                }
                ((java.util.List) obj2).add(obj);
            }
            return linkedHashMap;
        }

        private final java.util.Map<kotlin.reflect.jvm.internal.impl.name.Name, java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor>> getFunctionsByName() {
            return (java.util.Map) kotlin.reflect.jvm.internal.impl.storage.StorageKt.getValue(this.functionsByName$delegate, this, (kotlin.reflect.KProperty<?>) $$delegatedProperties[6]);
        }

        private final java.util.Map<kotlin.reflect.jvm.internal.impl.name.Name, java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor>> getPropertiesByName() {
            return (java.util.Map) kotlin.reflect.jvm.internal.impl.storage.StorageKt.getValue(this.propertiesByName$delegate, this, (kotlin.reflect.KProperty<?>) $$delegatedProperties[7]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final java.util.Map propertiesByName_delegate$lambda$10(kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.NoReorderImplementation noReorderImplementation) {
            java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor> allProperties = noReorderImplementation.getAllProperties();
            java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
            for (java.lang.Object obj : allProperties) {
                kotlin.reflect.jvm.internal.impl.name.Name name = ((kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor) obj).getName();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                java.lang.Object obj2 = linkedHashMap.get(name);
                if (obj2 == null) {
                    obj2 = (java.util.List) new java.util.ArrayList();
                    linkedHashMap.put(name, obj2);
                }
                ((java.util.List) obj2).add(obj);
            }
            return linkedHashMap;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> getFunctionNames() {
            return (java.util.Set) kotlin.reflect.jvm.internal.impl.storage.StorageKt.getValue(this.functionNames$delegate, this, (kotlin.reflect.KProperty<?>) $$delegatedProperties[8]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final java.util.Set functionNames_delegate$lambda$12(kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.NoReorderImplementation noReorderImplementation, kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope deserializedMemberScope) {
            java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function> list = noReorderImplementation.functionList;
            java.util.LinkedHashSet linkedHashSet = new java.util.LinkedHashSet();
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope deserializedMemberScope2 = noReorderImplementation.this$0;
            java.util.Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                linkedHashSet.add(kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt.getName(deserializedMemberScope2.getC().getNameResolver(), ((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function) ((kotlin.reflect.jvm.internal.impl.protobuf.MessageLite) it.next())).getName()));
            }
            return kotlin.collections.SetsKt.plus((java.util.Set) linkedHashSet, (java.lang.Iterable) deserializedMemberScope.getNonDeclaredFunctionNames());
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> getVariableNames() {
            return (java.util.Set) kotlin.reflect.jvm.internal.impl.storage.StorageKt.getValue(this.variableNames$delegate, this, (kotlin.reflect.KProperty<?>) $$delegatedProperties[9]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final java.util.Set variableNames_delegate$lambda$14(kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.NoReorderImplementation noReorderImplementation, kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope deserializedMemberScope) {
            java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property> list = noReorderImplementation.propertyList;
            java.util.LinkedHashSet linkedHashSet = new java.util.LinkedHashSet();
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope deserializedMemberScope2 = noReorderImplementation.this$0;
            java.util.Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                linkedHashSet.add(kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt.getName(deserializedMemberScope2.getC().getNameResolver(), ((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property) ((kotlin.reflect.jvm.internal.impl.protobuf.MessageLite) it.next())).getName()));
            }
            return kotlin.collections.SetsKt.plus((java.util.Set) linkedHashSet, (java.lang.Iterable) deserializedMemberScope.getNonDeclaredVariableNames());
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> getTypeAliasNames() {
            java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeAlias> list = this.typeAliasList;
            java.util.LinkedHashSet linkedHashSet = new java.util.LinkedHashSet();
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope deserializedMemberScope = this.this$0;
            java.util.Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                linkedHashSet.add(kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt.getName(deserializedMemberScope.getC().getNameResolver(), ((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeAlias) ((kotlin.reflect.jvm.internal.impl.protobuf.MessageLite) it.next())).getName()));
            }
            return linkedHashSet;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> computeFunctions() {
            java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function> list = this.functionList;
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope deserializedMemberScope = this.this$0;
            java.util.ArrayList arrayList = new java.util.ArrayList();
            java.util.Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor simpleFunctionDescriptorLoadFunction = deserializedMemberScope.getC().getMemberDeserializer().loadFunction((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function) ((kotlin.reflect.jvm.internal.impl.protobuf.MessageLite) it.next()));
                if (!deserializedMemberScope.isDeclaredFunctionAvailable(simpleFunctionDescriptorLoadFunction)) {
                    simpleFunctionDescriptorLoadFunction = null;
                }
                kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor simpleFunctionDescriptor = simpleFunctionDescriptorLoadFunction;
                if (simpleFunctionDescriptor != null) {
                    arrayList.add(simpleFunctionDescriptor);
                }
            }
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor> computeProperties() {
            java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property> list = this.propertyList;
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope deserializedMemberScope = this.this$0;
            java.util.ArrayList arrayList = new java.util.ArrayList();
            java.util.Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor propertyDescriptorLoadProperty$default = kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer.loadProperty$default(deserializedMemberScope.getC().getMemberDeserializer(), (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property) ((kotlin.reflect.jvm.internal.impl.protobuf.MessageLite) it.next()), false, 2, null);
                if (propertyDescriptorLoadProperty$default != null) {
                    arrayList.add(propertyDescriptorLoadProperty$default);
                }
            }
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor> computeTypeAliases() {
            java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeAlias> list = this.typeAliasList;
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope deserializedMemberScope = this.this$0;
            java.util.ArrayList arrayList = new java.util.ArrayList();
            java.util.Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor typeAliasDescriptorLoadTypeAlias = deserializedMemberScope.getC().getMemberDeserializer().loadTypeAlias((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeAlias) ((kotlin.reflect.jvm.internal.impl.protobuf.MessageLite) it.next()));
                if (typeAliasDescriptorLoadTypeAlias != null) {
                    arrayList.add(typeAliasDescriptorLoadTypeAlias);
                }
            }
            return arrayList;
        }

        private final java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> computeAllNonDeclaredFunctions() {
            java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> nonDeclaredFunctionNames = this.this$0.getNonDeclaredFunctionNames();
            java.util.ArrayList arrayList = new java.util.ArrayList();
            java.util.Iterator<T> it = nonDeclaredFunctionNames.iterator();
            while (it.hasNext()) {
                kotlin.collections.CollectionsKt.addAll(arrayList, computeNonDeclaredFunctionsForName((kotlin.reflect.jvm.internal.impl.name.Name) it.next()));
            }
            return arrayList;
        }

        private final java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor> computeAllNonDeclaredProperties() {
            java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> nonDeclaredVariableNames = this.this$0.getNonDeclaredVariableNames();
            java.util.ArrayList arrayList = new java.util.ArrayList();
            java.util.Iterator<T> it = nonDeclaredVariableNames.iterator();
            while (it.hasNext()) {
                kotlin.collections.CollectionsKt.addAll(arrayList, computeNonDeclaredPropertiesForName((kotlin.reflect.jvm.internal.impl.name.Name) it.next()));
            }
            return arrayList;
        }

        private final java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> computeNonDeclaredFunctionsForName(kotlin.reflect.jvm.internal.impl.name.Name name) {
            java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> declaredFunctions = getDeclaredFunctions();
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope deserializedMemberScope = this.this$0;
            java.util.ArrayList arrayList = new java.util.ArrayList();
            for (java.lang.Object obj : declaredFunctions) {
                if (kotlin.jvm.internal.Intrinsics.areEqual(((kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor) obj).getName(), name)) {
                    arrayList.add(obj);
                }
            }
            java.util.ArrayList arrayList2 = arrayList;
            int size = arrayList2.size();
            deserializedMemberScope.computeNonDeclaredFunctions(name, arrayList2);
            return arrayList2.subList(size, arrayList2.size());
        }

        private final java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor> computeNonDeclaredPropertiesForName(kotlin.reflect.jvm.internal.impl.name.Name name) {
            java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor> declaredProperties = getDeclaredProperties();
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope deserializedMemberScope = this.this$0;
            java.util.ArrayList arrayList = new java.util.ArrayList();
            for (java.lang.Object obj : declaredProperties) {
                if (kotlin.jvm.internal.Intrinsics.areEqual(((kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor) obj).getName(), name)) {
                    arrayList.add(obj);
                }
            }
            java.util.ArrayList arrayList2 = arrayList;
            int size = arrayList2.size();
            deserializedMemberScope.computeNonDeclaredProperties(name, arrayList2);
            return arrayList2.subList(size, arrayList2.size());
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> getContributedFunctions(kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation location) {
            java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> collection;
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(location, "location");
            return (getFunctionNames().contains(name) && (collection = getFunctionsByName().get(name)) != null) ? collection : kotlin.collections.CollectionsKt.emptyList();
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor getTypeAliasByName(kotlin.reflect.jvm.internal.impl.name.Name name) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
            return getTypeAliasesByName().get(name);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor> getContributedVariables(kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation location) {
            java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor> collection;
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(location, "location");
            return (getVariableNames().contains(name) && (collection = getPropertiesByName().get(name)) != null) ? collection : kotlin.collections.CollectionsKt.emptyList();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public void addFunctionsAndPropertiesTo(java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor> result, kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter kindFilter, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.name.Name, java.lang.Boolean> nameFilter, kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation location) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(result, "result");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kindFilter, "kindFilter");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(nameFilter, "nameFilter");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(location, "location");
            if (kindFilter.acceptsKinds(kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter.Companion.getVARIABLES_MASK())) {
                for (java.lang.Object obj : getAllProperties()) {
                    kotlin.reflect.jvm.internal.impl.name.Name name = ((kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor) obj).getName();
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                    if (nameFilter.invoke2(name).booleanValue()) {
                        result.add(obj);
                    }
                }
            }
            if (kindFilter.acceptsKinds(kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter.Companion.getFUNCTIONS_MASK())) {
                for (java.lang.Object obj2 : getAllFunctions()) {
                    kotlin.reflect.jvm.internal.impl.name.Name name2 = ((kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) obj2).getName();
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
                    if (nameFilter.invoke2(name2).booleanValue()) {
                        result.add(obj2);
                    }
                }
            }
        }
    }
}
