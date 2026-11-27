package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

/* JADX INFO: compiled from: LazyJavaScope.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class LazyJavaScope extends kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl {
    static final /* synthetic */ kotlin.reflect.KProperty<java.lang.Object>[] $$delegatedProperties = {kotlin.jvm.internal.Reflection.property1(new kotlin.jvm.internal.PropertyReference1Impl(kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope.class, "functionNamesLazy", "getFunctionNamesLazy()Ljava/util/Set;", 0)), kotlin.jvm.internal.Reflection.property1(new kotlin.jvm.internal.PropertyReference1Impl(kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope.class, "propertyNamesLazy", "getPropertyNamesLazy()Ljava/util/Set;", 0)), kotlin.jvm.internal.Reflection.property1(new kotlin.jvm.internal.PropertyReference1Impl(kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope.class, "classNamesLazy", "getClassNamesLazy()Ljava/util/Set;", 0))};
    private final kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue<java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor>> allDescriptors;
    private final kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext c;
    private final kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue classNamesLazy$delegate;
    private final kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable<kotlin.reflect.jvm.internal.impl.name.Name, kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor> declaredField;
    private final kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull<kotlin.reflect.jvm.internal.impl.name.Name, java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor>> declaredFunctions;
    private final kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue<kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex> declaredMemberIndex;
    private final kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue functionNamesLazy$delegate;
    private final kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull<kotlin.reflect.jvm.internal.impl.name.Name, java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor>> functions;
    private final kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope mainScope;
    private final kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull<kotlin.reflect.jvm.internal.impl.name.Name, java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor>> properties;
    private final kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue propertyNamesLazy$delegate;

    protected abstract java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> computeClassNames(kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter descriptorKindFilter, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.name.Name, java.lang.Boolean> function1);

    protected abstract java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> computeFunctionNames(kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter descriptorKindFilter, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.name.Name, java.lang.Boolean> function1);

    protected void computeImplicitlyDeclaredFunctions(java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> result, kotlin.reflect.jvm.internal.impl.name.Name name) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(result, "result");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex computeMemberIndex();

    protected abstract void computeNonDeclaredFunctions(java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> collection, kotlin.reflect.jvm.internal.impl.name.Name name);

    protected abstract void computeNonDeclaredProperties(kotlin.reflect.jvm.internal.impl.name.Name name, java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor> collection);

    protected abstract java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> computePropertyNames(kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter descriptorKindFilter, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.name.Name, java.lang.Boolean> function1);

    protected abstract kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor getDispatchReceiverParameter();

    protected abstract kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor getOwnerDescriptor();

    protected boolean isVisibleAsFunction(kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor javaMethodDescriptor) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(javaMethodDescriptor, "<this>");
        return true;
    }

    protected abstract kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope.MethodSignatureData resolveMethodSignature(kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod javaMethod, java.util.List<? extends kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> list, kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType, java.util.List<? extends kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> list2);

    public /* synthetic */ LazyJavaScope(kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext lazyJavaResolverContext, kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope lazyJavaScope, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(lazyJavaResolverContext, (i & 2) != 0 ? null : lazyJavaScope);
    }

    protected final kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext getC() {
        return this.c;
    }

    protected final kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope getMainScope() {
        return this.mainScope;
    }

    public LazyJavaScope(kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext c, kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope lazyJavaScope) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(c, "c");
        this.c = c;
        this.mainScope = lazyJavaScope;
        this.allDescriptors = c.getStorageManager().createRecursionTolerantLazyValue(new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope$$Lambda$0
            private final kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope.allDescriptors$lambda$0(this.arg$0);
            }
        }, kotlin.collections.CollectionsKt.emptyList());
        this.declaredMemberIndex = c.getStorageManager().createLazyValue(new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope$$Lambda$1
            private final kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return this.arg$0.computeMemberIndex();
            }
        });
        this.declaredFunctions = c.getStorageManager().createMemoizedFunction(new kotlin.jvm.functions.Function1(this) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope$$Lambda$2
            private final kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope.declaredFunctions$lambda$2(this.arg$0, (kotlin.reflect.jvm.internal.impl.name.Name) obj);
            }
        });
        this.declaredField = c.getStorageManager().createMemoizedFunctionWithNullableValues(new kotlin.jvm.functions.Function1(this) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope$$Lambda$3
            private final kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope.declaredField$lambda$3(this.arg$0, (kotlin.reflect.jvm.internal.impl.name.Name) obj);
            }
        });
        this.functions = c.getStorageManager().createMemoizedFunction(new kotlin.jvm.functions.Function1(this) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope$$Lambda$4
            private final kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope.functions$lambda$4(this.arg$0, (kotlin.reflect.jvm.internal.impl.name.Name) obj);
            }
        });
        this.functionNamesLazy$delegate = c.getStorageManager().createLazyValue(new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope$$Lambda$5
            private final kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope.functionNamesLazy_delegate$lambda$10(this.arg$0);
            }
        });
        this.propertyNamesLazy$delegate = c.getStorageManager().createLazyValue(new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope$$Lambda$6
            private final kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope.propertyNamesLazy_delegate$lambda$11(this.arg$0);
            }
        });
        this.classNamesLazy$delegate = c.getStorageManager().createLazyValue(new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope$$Lambda$7
            private final kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope.classNamesLazy_delegate$lambda$12(this.arg$0);
            }
        });
        this.properties = c.getStorageManager().createMemoizedFunction(new kotlin.jvm.functions.Function1(this) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope$$Lambda$8
            private final kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope.properties$lambda$13(this.arg$0, (kotlin.reflect.jvm.internal.impl.name.Name) obj);
            }
        });
    }

    protected final kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue<java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor>> getAllDescriptors() {
        return this.allDescriptors;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.util.Collection allDescriptors$lambda$0(kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope lazyJavaScope) {
        return lazyJavaScope.computeDescriptors(kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter.ALL, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope.Companion.getALL_NAME_FILTER());
    }

    protected final kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue<kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex> getDeclaredMemberIndex() {
        return this.declaredMemberIndex;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.util.Collection declaredFunctions$lambda$2(kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope lazyJavaScope, kotlin.reflect.jvm.internal.impl.name.Name name) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope lazyJavaScope2 = lazyJavaScope.mainScope;
        if (lazyJavaScope2 != null) {
            return lazyJavaScope2.declaredFunctions.invoke2(name);
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod javaMethod : lazyJavaScope.declaredMemberIndex.invoke().findMethodsByName(name)) {
            kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor javaMethodDescriptorResolveMethodToFunctionDescriptor = lazyJavaScope.resolveMethodToFunctionDescriptor(javaMethod);
            if (lazyJavaScope.isVisibleAsFunction(javaMethodDescriptorResolveMethodToFunctionDescriptor)) {
                lazyJavaScope.c.getComponents().getJavaResolverCache().recordMethod(javaMethod, javaMethodDescriptorResolveMethodToFunctionDescriptor);
                arrayList.add(javaMethodDescriptorResolveMethodToFunctionDescriptor);
            }
        }
        java.util.ArrayList arrayList2 = arrayList;
        lazyJavaScope.computeImplicitlyDeclaredFunctions(arrayList2, name);
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor declaredField$lambda$3(kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope lazyJavaScope, kotlin.reflect.jvm.internal.impl.name.Name name) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope lazyJavaScope2 = lazyJavaScope.mainScope;
        if (lazyJavaScope2 != null) {
            return lazyJavaScope2.declaredField.invoke2(name);
        }
        kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField javaFieldFindFieldByName = lazyJavaScope.declaredMemberIndex.invoke().findFieldByName(name);
        if (javaFieldFindFieldByName == null || javaFieldFindFieldByName.isEnumEntry()) {
            return null;
        }
        return lazyJavaScope.resolveProperty(javaFieldFindFieldByName);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.util.Collection functions$lambda$4(kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope lazyJavaScope, kotlin.reflect.jvm.internal.impl.name.Name name) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        java.util.LinkedHashSet linkedHashSet = new java.util.LinkedHashSet(lazyJavaScope.declaredFunctions.invoke2(name));
        lazyJavaScope.retainMostSpecificMethods(linkedHashSet);
        java.util.LinkedHashSet linkedHashSet2 = linkedHashSet;
        lazyJavaScope.computeNonDeclaredFunctions(linkedHashSet2, name);
        return kotlin.collections.CollectionsKt.toList(lazyJavaScope.c.getComponents().getSignatureEnhancement().enhanceSignatures(lazyJavaScope.c, linkedHashSet2));
    }

    private final void retainMostSpecificMethods(java.util.Set<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> set) {
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
        for (java.lang.Object obj : set) {
            java.lang.String strComputeJvmDescriptor$default = kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt.computeJvmDescriptor$default((kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) obj, false, false, 2, null);
            java.lang.Object obj2 = linkedHashMap.get(strComputeJvmDescriptor$default);
            if (obj2 == null) {
                obj2 = (java.util.List) new java.util.ArrayList();
                linkedHashMap.put(strComputeJvmDescriptor$default, obj2);
            }
            ((java.util.List) obj2).add(obj);
        }
        for (java.util.List list : linkedHashMap.values()) {
            if (list.size() != 1) {
                java.util.List list2 = list;
                java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> collectionSelectMostSpecificInEachOverridableGroup = kotlin.reflect.jvm.internal.impl.resolve.OverridingUtilsKt.selectMostSpecificInEachOverridableGroup(list2, new kotlin.jvm.functions.Function1() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope$$Lambda$9
                    @Override // kotlin.jvm.functions.Function1
                    /* JADX INFO: renamed from: invoke */
                    public java.lang.Object invoke2(java.lang.Object obj3) {
                        return kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope.retainMostSpecificMethods$lambda$6((kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) obj3);
                    }
                });
                set.removeAll(list2);
                set.addAll(collectionSelectMostSpecificInEachOverridableGroup);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor retainMostSpecificMethods$lambda$6(kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor selectMostSpecificInEachOverridableGroup) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(selectMostSpecificInEachOverridableGroup, "$this$selectMostSpecificInEachOverridableGroup");
        return selectMostSpecificInEachOverridableGroup;
    }

    /* JADX INFO: compiled from: LazyJavaScope.kt */
    protected static final class MethodSignatureData {
        private final java.util.List<java.lang.String> errors;
        private final boolean hasStableParameterNames;
        private final kotlin.reflect.jvm.internal.impl.types.KotlinType receiverType;
        private final kotlin.reflect.jvm.internal.impl.types.KotlinType returnType;
        private final java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> typeParameters;
        private final java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> valueParameters;

        public boolean equals(java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope.MethodSignatureData)) {
                return false;
            }
            kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope.MethodSignatureData methodSignatureData = (kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope.MethodSignatureData) obj;
            return kotlin.jvm.internal.Intrinsics.areEqual(this.returnType, methodSignatureData.returnType) && kotlin.jvm.internal.Intrinsics.areEqual(this.receiverType, methodSignatureData.receiverType) && kotlin.jvm.internal.Intrinsics.areEqual(this.valueParameters, methodSignatureData.valueParameters) && kotlin.jvm.internal.Intrinsics.areEqual(this.typeParameters, methodSignatureData.typeParameters) && this.hasStableParameterNames == methodSignatureData.hasStableParameterNames && kotlin.jvm.internal.Intrinsics.areEqual(this.errors, methodSignatureData.errors);
        }

        public int hashCode() {
            int iHashCode = this.returnType.hashCode() * 31;
            kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType = this.receiverType;
            return ((((((((iHashCode + (kotlinType == null ? 0 : kotlinType.hashCode())) * 31) + this.valueParameters.hashCode()) * 31) + this.typeParameters.hashCode()) * 31) + kotlin.UByte$$ExternalSyntheticBackport0.m(this.hasStableParameterNames)) * 31) + this.errors.hashCode();
        }

        public java.lang.String toString() {
            return "MethodSignatureData(returnType=" + this.returnType + ", receiverType=" + this.receiverType + ", valueParameters=" + this.valueParameters + ", typeParameters=" + this.typeParameters + ", hasStableParameterNames=" + this.hasStableParameterNames + ", errors=" + this.errors + com.taobao.weex.el.parse.Operators.BRACKET_END;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public MethodSignatureData(kotlin.reflect.jvm.internal.impl.types.KotlinType returnType, kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType, java.util.List<? extends kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> valueParameters, java.util.List<? extends kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> typeParameters, boolean z, java.util.List<java.lang.String> errors) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(returnType, "returnType");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(valueParameters, "valueParameters");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeParameters, "typeParameters");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(errors, "errors");
            this.returnType = returnType;
            this.receiverType = kotlinType;
            this.valueParameters = valueParameters;
            this.typeParameters = typeParameters;
            this.hasStableParameterNames = z;
            this.errors = errors;
        }

        public final kotlin.reflect.jvm.internal.impl.types.KotlinType getReturnType() {
            return this.returnType;
        }

        public final kotlin.reflect.jvm.internal.impl.types.KotlinType getReceiverType() {
            return this.receiverType;
        }

        public final java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> getValueParameters() {
            return this.valueParameters;
        }

        public final java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> getTypeParameters() {
            return this.typeParameters;
        }

        public final boolean getHasStableParameterNames() {
            return this.hasStableParameterNames;
        }

        public final java.util.List<java.lang.String> getErrors() {
            return this.errors;
        }
    }

    protected final kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor resolveMethodToFunctionDescriptor(kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod method) {
        java.util.Map<? extends kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor.UserDataKey<?>, ?> mapEmptyMap;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(method, "method");
        kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor javaMethodDescriptorCreateJavaMethod = kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor.createJavaMethod(getOwnerDescriptor(), kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotationsKt.resolveAnnotations(this.c, method), method.getName(), this.c.getComponents().getSourceElementFactory().source(method), this.declaredMemberIndex.invoke().findRecordComponentByName(method.getName()) != null && method.getValueParameters().isEmpty());
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(javaMethodDescriptorCreateJavaMethod, "createJavaMethod(...)");
        kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext lazyJavaResolverContextChildForMethod$default = kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt.childForMethod$default(this.c, javaMethodDescriptorCreateJavaMethod, method, 0, 4, null);
        java.util.List<kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter> typeParameters = method.getTypeParameters();
        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(typeParameters, 10));
        java.util.Iterator<T> it = typeParameters.iterator();
        while (it.hasNext()) {
            kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor typeParameterDescriptorResolveTypeParameter = lazyJavaResolverContextChildForMethod$default.getTypeParameterResolver().resolveTypeParameter((kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter) it.next());
            kotlin.jvm.internal.Intrinsics.checkNotNull(typeParameterDescriptorResolveTypeParameter);
            arrayList.add(typeParameterDescriptorResolveTypeParameter);
        }
        kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope.ResolvedValueParameters resolvedValueParametersResolveValueParameters = resolveValueParameters(lazyJavaResolverContextChildForMethod$default, javaMethodDescriptorCreateJavaMethod, method.getValueParameters());
        kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope.MethodSignatureData methodSignatureDataResolveMethodSignature = resolveMethodSignature(method, arrayList, computeMethodReturnType(method, lazyJavaResolverContextChildForMethod$default), resolvedValueParametersResolveValueParameters.getDescriptors());
        kotlin.reflect.jvm.internal.impl.types.KotlinType receiverType = methodSignatureDataResolveMethodSignature.getReceiverType();
        kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor receiverParameterDescriptorCreateExtensionReceiverParameterForCallable = receiverType != null ? kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory.createExtensionReceiverParameterForCallable(javaMethodDescriptorCreateJavaMethod, receiverType, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion.getEMPTY()) : null;
        kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor dispatchReceiverParameter = getDispatchReceiverParameter();
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor> listEmptyList = kotlin.collections.CollectionsKt.emptyList();
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> typeParameters2 = methodSignatureDataResolveMethodSignature.getTypeParameters();
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> valueParameters = methodSignatureDataResolveMethodSignature.getValueParameters();
        kotlin.reflect.jvm.internal.impl.types.KotlinType returnType = methodSignatureDataResolveMethodSignature.getReturnType();
        kotlin.reflect.jvm.internal.impl.descriptors.Modality modalityConvertFromFlags = kotlin.reflect.jvm.internal.impl.descriptors.Modality.Companion.convertFromFlags(false, method.isAbstract(), !method.isFinal());
        kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility descriptorVisibility = kotlin.reflect.jvm.internal.impl.load.java.UtilsKt.toDescriptorVisibility(method.getVisibility());
        if (methodSignatureDataResolveMethodSignature.getReceiverType() != null) {
            mapEmptyMap = kotlin.collections.MapsKt.mapOf(kotlin.TuplesKt.to(kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor.ORIGINAL_VALUE_PARAMETER_FOR_EXTENSION_RECEIVER, kotlin.collections.CollectionsKt.first((java.util.List) resolvedValueParametersResolveValueParameters.getDescriptors())));
        } else {
            mapEmptyMap = kotlin.collections.MapsKt.emptyMap();
        }
        javaMethodDescriptorCreateJavaMethod.initialize(receiverParameterDescriptorCreateExtensionReceiverParameterForCallable, dispatchReceiverParameter, listEmptyList, typeParameters2, valueParameters, returnType, modalityConvertFromFlags, descriptorVisibility, mapEmptyMap);
        javaMethodDescriptorCreateJavaMethod.setParameterNamesStatus(methodSignatureDataResolveMethodSignature.getHasStableParameterNames(), resolvedValueParametersResolveValueParameters.getHasSynthesizedNames());
        if (!methodSignatureDataResolveMethodSignature.getErrors().isEmpty()) {
            lazyJavaResolverContextChildForMethod$default.getComponents().getSignaturePropagator().reportSignatureErrors(javaMethodDescriptorCreateJavaMethod, methodSignatureDataResolveMethodSignature.getErrors());
        }
        return javaMethodDescriptorCreateJavaMethod;
    }

    protected final kotlin.reflect.jvm.internal.impl.types.KotlinType computeMethodReturnType(kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod method, kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext c) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(method, "method");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(c, "c");
        return c.getTypeResolver().transformJavaType(method.getReturnType(), kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributesKt.toAttributes$default(kotlin.reflect.jvm.internal.impl.types.TypeUsage.COMMON, method.getContainingClass().isAnnotationType(), false, null, 6, null));
    }

    /* JADX INFO: compiled from: LazyJavaScope.kt */
    protected static final class ResolvedValueParameters {
        private final java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> descriptors;
        private final boolean hasSynthesizedNames;

        /* JADX WARN: Multi-variable type inference failed */
        public ResolvedValueParameters(java.util.List<? extends kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> descriptors, boolean z) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(descriptors, "descriptors");
            this.descriptors = descriptors;
            this.hasSynthesizedNames = z;
        }

        public final java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> getDescriptors() {
            return this.descriptors;
        }

        public final boolean getHasSynthesizedNames() {
            return this.hasSynthesizedNames;
        }
    }

    protected final kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope.ResolvedValueParameters resolveValueParameters(kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext c, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor function, java.util.List<? extends kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter> jValueParameters) {
        kotlin.Pair pair;
        kotlin.reflect.jvm.internal.impl.name.Name name;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(c, "c");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(function, "function");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(jValueParameters, "jValueParameters");
        java.lang.Iterable<kotlin.collections.IndexedValue> iterableWithIndex = kotlin.collections.CollectionsKt.withIndex(jValueParameters);
        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(iterableWithIndex, 10));
        boolean z = false;
        for (kotlin.collections.IndexedValue indexedValue : iterableWithIndex) {
            int index = indexedValue.getIndex();
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter javaValueParameter = (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter) indexedValue.component2();
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations annotationsResolveAnnotations = kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotationsKt.resolveAnnotations(c, javaValueParameter);
            kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes attributes$default = kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributesKt.toAttributes$default(kotlin.reflect.jvm.internal.impl.types.TypeUsage.COMMON, false, false, null, 7, null);
            if (javaValueParameter.isVararg()) {
                kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType type = javaValueParameter.getType();
                kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType javaArrayType = type instanceof kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType ? (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType) type : null;
                if (javaArrayType == null) {
                    throw new java.lang.AssertionError("Vararg parameter should be an array: " + javaValueParameter);
                }
                kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinTypeTransformArrayType = c.getTypeResolver().transformArrayType(javaArrayType, attributes$default, true);
                pair = kotlin.TuplesKt.to(kotlinTypeTransformArrayType, c.getModule().getBuiltIns().getArrayElementType(kotlinTypeTransformArrayType));
            } else {
                pair = kotlin.TuplesKt.to(c.getTypeResolver().transformJavaType(javaValueParameter.getType(), attributes$default), null);
            }
            kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType = (kotlin.reflect.jvm.internal.impl.types.KotlinType) pair.component1();
            kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType2 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) pair.component2();
            if (kotlin.jvm.internal.Intrinsics.areEqual(function.getName().asString(), "equals") && jValueParameters.size() == 1 && kotlin.jvm.internal.Intrinsics.areEqual(c.getModule().getBuiltIns().getNullableAnyType(), kotlinType)) {
                name = kotlin.reflect.jvm.internal.impl.name.Name.identifier("other");
            } else {
                name = javaValueParameter.getName();
                if (name == null) {
                    z = true;
                }
                if (name == null) {
                    name = kotlin.reflect.jvm.internal.impl.name.Name.identifier(com.facebook.common.callercontext.ContextChain.TAG_PRODUCT + index);
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(name, "identifier(...)");
                }
            }
            kotlin.reflect.jvm.internal.impl.name.Name name2 = name;
            kotlin.jvm.internal.Intrinsics.checkNotNull(name2);
            arrayList.add(new kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl(function, null, index, annotationsResolveAnnotations, name2, kotlinType, false, false, false, kotlinType2, c.getComponents().getSourceElementFactory().source(javaValueParameter)));
        }
        return new kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope.ResolvedValueParameters(kotlin.collections.CollectionsKt.toList(arrayList), z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.util.Set functionNamesLazy_delegate$lambda$10(kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope lazyJavaScope) {
        return lazyJavaScope.computeFunctionNames(kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter.FUNCTIONS, null);
    }

    private final java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> getFunctionNamesLazy() {
        return (java.util.Set) kotlin.reflect.jvm.internal.impl.storage.StorageKt.getValue(this.functionNamesLazy$delegate, this, (kotlin.reflect.KProperty<?>) $$delegatedProperties[0]);
    }

    private final java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> getPropertyNamesLazy() {
        return (java.util.Set) kotlin.reflect.jvm.internal.impl.storage.StorageKt.getValue(this.propertyNamesLazy$delegate, this, (kotlin.reflect.KProperty<?>) $$delegatedProperties[1]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.util.Set propertyNamesLazy_delegate$lambda$11(kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope lazyJavaScope) {
        return lazyJavaScope.computePropertyNames(kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter.VARIABLES, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.util.Set classNamesLazy_delegate$lambda$12(kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope lazyJavaScope) {
        return lazyJavaScope.computeClassNames(kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter.CLASSIFIERS, null);
    }

    private final java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> getClassNamesLazy() {
        return (java.util.Set) kotlin.reflect.jvm.internal.impl.storage.StorageKt.getValue(this.classNamesLazy$delegate, this, (kotlin.reflect.KProperty<?>) $$delegatedProperties[2]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> getFunctionNames() {
        return getFunctionNamesLazy();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> getVariableNames() {
        return getPropertyNamesLazy();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> getClassifierNames() {
        return getClassNamesLazy();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> getContributedFunctions(kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation location) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(location, "location");
        return !getFunctionNames().contains(name) ? kotlin.collections.CollectionsKt.emptyList() : this.functions.invoke2(name);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.util.List properties$lambda$13(kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope lazyJavaScope, kotlin.reflect.jvm.internal.impl.name.Name name) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.ArrayList arrayList2 = arrayList;
        kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(arrayList2, lazyJavaScope.declaredField.invoke2(name));
        lazyJavaScope.computeNonDeclaredProperties(name, arrayList2);
        if (kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.isAnnotationClass(lazyJavaScope.getOwnerDescriptor())) {
            return kotlin.collections.CollectionsKt.toList(arrayList);
        }
        return kotlin.collections.CollectionsKt.toList(lazyJavaScope.c.getComponents().getSignatureEnhancement().enhanceSignatures(lazyJavaScope.c, arrayList2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [T, kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl] */
    /* JADX WARN: Type inference failed for: r1v16, types: [T, kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl] */
    private final kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor resolveProperty(final kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField javaField) {
        final kotlin.jvm.internal.Ref.ObjectRef objectRef = new kotlin.jvm.internal.Ref.ObjectRef();
        objectRef.element = createPropertyDescriptor(javaField);
        ((kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl) objectRef.element).initialize(null, null, null, null);
        ((kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl) objectRef.element).setType(getPropertyType(javaField), kotlin.collections.CollectionsKt.emptyList(), getDispatchReceiverParameter(), null, kotlin.collections.CollectionsKt.emptyList());
        kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor ownerDescriptor = getOwnerDescriptor();
        kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor = ownerDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor ? (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) ownerDescriptor : null;
        if (classDescriptor != null) {
            objectRef.element = this.c.getComponents().getSyntheticPartsProvider().modifyField(classDescriptor, (kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl) objectRef.element, this.c);
        }
        if (kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.shouldRecordInitializerForProperty((kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor) objectRef.element, ((kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl) objectRef.element).getType())) {
            ((kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl) objectRef.element).setCompileTimeInitializerFactory(new kotlin.jvm.functions.Function0(this, javaField, objectRef) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope$$Lambda$10
                private final kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope arg$0;
                private final kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField arg$1;
                private final kotlin.jvm.internal.Ref.ObjectRef arg$2;

                {
                    this.arg$0 = this;
                    this.arg$1 = javaField;
                    this.arg$2 = objectRef;
                }

                @Override // kotlin.jvm.functions.Function0
                public java.lang.Object invoke() {
                    return kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope.resolveProperty$lambda$16(this.arg$0, this.arg$1, this.arg$2);
                }
            });
        }
        this.c.getComponents().getJavaResolverCache().recordField(javaField, (kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor) objectRef.element);
        return (kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor) objectRef.element;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue resolveProperty$lambda$16(final kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope lazyJavaScope, final kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField javaField, final kotlin.jvm.internal.Ref.ObjectRef objectRef) {
        return lazyJavaScope.c.getStorageManager().createNullableLazyValue(new kotlin.jvm.functions.Function0(lazyJavaScope, javaField, objectRef) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope$$Lambda$11
            private final kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope arg$0;
            private final kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField arg$1;
            private final kotlin.jvm.internal.Ref.ObjectRef arg$2;

            {
                this.arg$0 = lazyJavaScope;
                this.arg$1 = javaField;
                this.arg$2 = objectRef;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope.resolveProperty$lambda$16$lambda$15(this.arg$0, this.arg$1, this.arg$2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue resolveProperty$lambda$16$lambda$15(kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope lazyJavaScope, kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField javaField, kotlin.jvm.internal.Ref.ObjectRef objectRef) {
        return lazyJavaScope.c.getComponents().getJavaPropertyInitializerEvaluator().getInitializerConstant(javaField, (kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor) objectRef.element);
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl createPropertyDescriptor(kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField javaField) {
        kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaPropertyDescriptor javaPropertyDescriptorCreate = kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaPropertyDescriptor.create(getOwnerDescriptor(), kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotationsKt.resolveAnnotations(this.c, javaField), kotlin.reflect.jvm.internal.impl.descriptors.Modality.FINAL, kotlin.reflect.jvm.internal.impl.load.java.UtilsKt.toDescriptorVisibility(javaField.getVisibility()), !javaField.isFinal(), javaField.getName(), this.c.getComponents().getSourceElementFactory().source(javaField), isFinalStatic(javaField));
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(javaPropertyDescriptorCreate, "create(...)");
        return javaPropertyDescriptorCreate;
    }

    private final boolean isFinalStatic(kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField javaField) {
        return javaField.isFinal() && javaField.isStatic();
    }

    private final kotlin.reflect.jvm.internal.impl.types.KotlinType getPropertyType(kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField javaField) {
        kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinTypeTransformJavaType = this.c.getTypeResolver().transformJavaType(javaField.getType(), kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributesKt.toAttributes$default(kotlin.reflect.jvm.internal.impl.types.TypeUsage.COMMON, false, false, null, 7, null));
        if ((!kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isPrimitiveType(kotlinTypeTransformJavaType) && !kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isString(kotlinTypeTransformJavaType)) || !isFinalStatic(javaField) || !javaField.getHasConstantNotNullInitializer()) {
            return kotlinTypeTransformJavaType;
        }
        kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinTypeMakeNotNullable = kotlin.reflect.jvm.internal.impl.types.TypeUtils.makeNotNullable(kotlinTypeTransformJavaType);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(kotlinTypeMakeNotNullable, "makeNotNullable(...)");
        return kotlinTypeMakeNotNullable;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor> getContributedVariables(kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation location) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(location, "location");
        return !getVariableNames().contains(name) ? kotlin.collections.CollectionsKt.emptyList() : this.properties.invoke2(name);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor> getContributedDescriptors(kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter kindFilter, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.name.Name, java.lang.Boolean> nameFilter) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kindFilter, "kindFilter");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(nameFilter, "nameFilter");
        return this.allDescriptors.invoke();
    }

    protected final java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor> computeDescriptors(kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter kindFilter, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.name.Name, java.lang.Boolean> nameFilter) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kindFilter, "kindFilter");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(nameFilter, "nameFilter");
        kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation noLookupLocation = kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation.WHEN_GET_ALL_DESCRIPTORS;
        java.util.LinkedHashSet linkedHashSet = new java.util.LinkedHashSet();
        if (kindFilter.acceptsKinds(kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter.Companion.getCLASSIFIERS_MASK())) {
            for (kotlin.reflect.jvm.internal.impl.name.Name name : computeClassNames(kindFilter, nameFilter)) {
                if (nameFilter.invoke2(name).booleanValue()) {
                    kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(linkedHashSet, mo1837getContributedClassifier(name, noLookupLocation));
                }
            }
        }
        if (kindFilter.acceptsKinds(kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter.Companion.getFUNCTIONS_MASK()) && !kindFilter.getExcludes().contains(kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindExclude.NonExtensions.INSTANCE)) {
            for (kotlin.reflect.jvm.internal.impl.name.Name name2 : computeFunctionNames(kindFilter, nameFilter)) {
                if (nameFilter.invoke2(name2).booleanValue()) {
                    linkedHashSet.addAll(getContributedFunctions(name2, noLookupLocation));
                }
            }
        }
        if (kindFilter.acceptsKinds(kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter.Companion.getVARIABLES_MASK()) && !kindFilter.getExcludes().contains(kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindExclude.NonExtensions.INSTANCE)) {
            for (kotlin.reflect.jvm.internal.impl.name.Name name3 : computePropertyNames(kindFilter, nameFilter)) {
                if (nameFilter.invoke2(name3).booleanValue()) {
                    linkedHashSet.addAll(getContributedVariables(name3, noLookupLocation));
                }
            }
        }
        return kotlin.collections.CollectionsKt.toList(linkedHashSet);
    }

    public java.lang.String toString() {
        return "Lazy scope for " + getOwnerDescriptor();
    }
}
