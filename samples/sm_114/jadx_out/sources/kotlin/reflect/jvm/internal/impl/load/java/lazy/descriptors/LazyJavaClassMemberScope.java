package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

/* JADX INFO: compiled from: LazyJavaClassMemberScope.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class LazyJavaClassMemberScope extends kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope {
    private final kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue<java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor>> constructors;
    private final kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue<java.util.Map<kotlin.reflect.jvm.internal.impl.name.Name, kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField>> enumEntryIndex;
    private final kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue<java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name>> generatedNestedClassNames;
    private final kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass jClass;
    private final kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue<java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name>> nestedClassIndex;
    private final kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable<kotlin.reflect.jvm.internal.impl.name.Name, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor> nestedClasses;
    private final kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor ownerDescriptor;
    private final boolean skipRefinement;

    public /* synthetic */ LazyJavaClassMemberScope(kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext lazyJavaResolverContext, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor, kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass javaClass, boolean z, kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope lazyJavaClassMemberScope, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(lazyJavaResolverContext, classDescriptor, javaClass, z, (i & 16) != 0 ? null : lazyJavaClassMemberScope);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public /* bridge */ /* synthetic */ java.util.Set computeFunctionNames(kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter descriptorKindFilter, kotlin.jvm.functions.Function1 function1) {
        return computeFunctionNames(descriptorKindFilter, (kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.name.Name, java.lang.Boolean>) function1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor getOwnerDescriptor() {
        return this.ownerDescriptor;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaClassMemberScope(final kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext c, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor ownerDescriptor, kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass jClass, boolean z, kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope lazyJavaClassMemberScope) {
        super(c, lazyJavaClassMemberScope);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(c, "c");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(ownerDescriptor, "ownerDescriptor");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(jClass, "jClass");
        this.ownerDescriptor = ownerDescriptor;
        this.jClass = jClass;
        this.skipRefinement = z;
        this.constructors = c.getStorageManager().createLazyValue(new kotlin.jvm.functions.Function0(this, c) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$$Lambda$0
            private final kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope arg$0;
            private final kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext arg$1;

            {
                this.arg$0 = this;
                this.arg$1 = c;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope.constructors$lambda$5(this.arg$0, this.arg$1);
            }
        });
        this.nestedClassIndex = c.getStorageManager().createLazyValue(new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$$Lambda$1
            private final kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope.nestedClassIndex$lambda$49(this.arg$0);
            }
        });
        this.generatedNestedClassNames = c.getStorageManager().createLazyValue(new kotlin.jvm.functions.Function0(c, this) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$$Lambda$2
            private final kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext arg$0;
            private final kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope arg$1;

            {
                this.arg$0 = c;
                this.arg$1 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope.generatedNestedClassNames$lambda$50(this.arg$0, this.arg$1);
            }
        });
        this.enumEntryIndex = c.getStorageManager().createLazyValue(new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$$Lambda$3
            private final kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope.enumEntryIndex$lambda$53(this.arg$0);
            }
        });
        this.nestedClasses = c.getStorageManager().createMemoizedFunctionWithNullableValues(new kotlin.jvm.functions.Function1(this, c) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$$Lambda$4
            private final kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope arg$0;
            private final kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext arg$1;

            {
                this.arg$0 = this;
                this.arg$1 = c;
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope.nestedClasses$lambda$59(this.arg$0, this.arg$1, (kotlin.reflect.jvm.internal.impl.name.Name) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean computeMemberIndex$lambda$0(kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember it) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(it, "it");
        return !it.isStatic();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.ClassDeclaredMemberIndex computeMemberIndex() {
        return new kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.ClassDeclaredMemberIndex(this.jClass, new kotlin.jvm.functions.Function1() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$$Lambda$5
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return java.lang.Boolean.valueOf(kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope.computeMemberIndex$lambda$0((kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember) obj));
            }
        });
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected java.util.LinkedHashSet<kotlin.reflect.jvm.internal.impl.name.Name> computeFunctionNames(kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter kindFilter, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.name.Name, java.lang.Boolean> function1) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kindFilter, "kindFilter");
        java.util.Collection<kotlin.reflect.jvm.internal.impl.types.KotlinType> collectionMo1836getSupertypes = getOwnerDescriptor().getTypeConstructor().mo1836getSupertypes();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(collectionMo1836getSupertypes, "getSupertypes(...)");
        java.util.LinkedHashSet<kotlin.reflect.jvm.internal.impl.name.Name> linkedHashSet = new java.util.LinkedHashSet<>();
        java.util.Iterator<T> it = collectionMo1836getSupertypes.iterator();
        while (it.hasNext()) {
            kotlin.collections.CollectionsKt.addAll(linkedHashSet, ((kotlin.reflect.jvm.internal.impl.types.KotlinType) it.next()).getMemberScope().getFunctionNames());
        }
        java.util.LinkedHashSet<kotlin.reflect.jvm.internal.impl.name.Name> linkedHashSet2 = linkedHashSet;
        linkedHashSet2.addAll(getDeclaredMemberIndex().invoke().getMethodNames());
        linkedHashSet2.addAll(getDeclaredMemberIndex().invoke().getRecordComponentNames());
        linkedHashSet2.addAll(computeClassNames(kindFilter, function1));
        linkedHashSet2.addAll(getC().getComponents().getSyntheticPartsProvider().getMethodNames(getOwnerDescriptor(), getC()));
        return linkedHashSet2;
    }

    public final kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue<java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor>> getConstructors$descriptors_jvm() {
        return this.constructors;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.util.List constructors$lambda$5(kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope lazyJavaClassMemberScope, kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext lazyJavaResolverContext) {
        java.util.Collection<kotlin.reflect.jvm.internal.impl.load.java.structure.JavaConstructor> constructors = lazyJavaClassMemberScope.jClass.getConstructors();
        java.util.ArrayList arrayList = new java.util.ArrayList(constructors.size());
        java.util.Iterator<kotlin.reflect.jvm.internal.impl.load.java.structure.JavaConstructor> it = constructors.iterator();
        while (it.hasNext()) {
            arrayList.add(lazyJavaClassMemberScope.resolveConstructor(it.next()));
        }
        if (lazyJavaClassMemberScope.jClass.isRecord()) {
            kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor classConstructorDescriptorCreateDefaultRecordConstructor = lazyJavaClassMemberScope.createDefaultRecordConstructor();
            java.lang.String strComputeJvmDescriptor$default = kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt.computeJvmDescriptor$default(classConstructorDescriptorCreateDefaultRecordConstructor, false, false, 2, null);
            java.util.ArrayList arrayList2 = arrayList;
            if ((arrayList2 instanceof java.util.Collection) && arrayList2.isEmpty()) {
                arrayList.add(classConstructorDescriptorCreateDefaultRecordConstructor);
                lazyJavaResolverContext.getComponents().getJavaResolverCache().recordConstructor(lazyJavaClassMemberScope.jClass, classConstructorDescriptorCreateDefaultRecordConstructor);
                break;
            }
            java.util.Iterator it2 = arrayList2.iterator();
            do {
                if (!it2.hasNext()) {
                    arrayList.add(classConstructorDescriptorCreateDefaultRecordConstructor);
                    lazyJavaResolverContext.getComponents().getJavaResolverCache().recordConstructor(lazyJavaClassMemberScope.jClass, classConstructorDescriptorCreateDefaultRecordConstructor);
                    break;
                }
            } while (!kotlin.jvm.internal.Intrinsics.areEqual(kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt.computeJvmDescriptor$default((kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor) it2.next(), false, false, 2, null), strComputeJvmDescriptor$default));
        }
        lazyJavaResolverContext.getComponents().getSyntheticPartsProvider().generateConstructors(lazyJavaClassMemberScope.getOwnerDescriptor(), arrayList, lazyJavaResolverContext);
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement signatureEnhancement = lazyJavaResolverContext.getComponents().getSignatureEnhancement();
        java.util.List listListOfNotNull = arrayList;
        if (listListOfNotNull.isEmpty()) {
            listListOfNotNull = kotlin.collections.CollectionsKt.listOfNotNull(lazyJavaClassMemberScope.createDefaultConstructor());
        }
        return kotlin.collections.CollectionsKt.toList(signatureEnhancement.enhanceSignatures(lazyJavaResolverContext, listListOfNotNull));
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor createDefaultRecordConstructor() {
        kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor ownerDescriptor = getOwnerDescriptor();
        kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassConstructorDescriptor javaClassConstructorDescriptorCreateJavaConstructor = kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassConstructorDescriptor.createJavaConstructor(ownerDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion.getEMPTY(), true, getC().getComponents().getSourceElementFactory().source(this.jClass));
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(javaClassConstructorDescriptorCreateJavaConstructor, "createJavaConstructor(...)");
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> listCreateRecordConstructorParameters = createRecordConstructorParameters(javaClassConstructorDescriptorCreateJavaConstructor);
        javaClassConstructorDescriptorCreateJavaConstructor.setHasSynthesizedParameterNames(false);
        javaClassConstructorDescriptorCreateJavaConstructor.initialize(listCreateRecordConstructorParameters, getConstructorVisibility(ownerDescriptor));
        javaClassConstructorDescriptorCreateJavaConstructor.setHasStableParameterNames(false);
        javaClassConstructorDescriptorCreateJavaConstructor.setReturnType(ownerDescriptor.getDefaultType());
        return javaClassConstructorDescriptorCreateJavaConstructor;
    }

    private final java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> createRecordConstructorParameters(kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl classConstructorDescriptorImpl) {
        java.util.Collection<kotlin.reflect.jvm.internal.impl.load.java.structure.JavaRecordComponent> recordComponents = this.jClass.getRecordComponents();
        java.util.ArrayList arrayList = new java.util.ArrayList(recordComponents.size());
        kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes attributes$default = kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributesKt.toAttributes$default(kotlin.reflect.jvm.internal.impl.types.TypeUsage.COMMON, false, false, null, 6, null);
        int i = 0;
        for (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaRecordComponent javaRecordComponent : recordComponents) {
            int i2 = i + 1;
            kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinTypeTransformJavaType = getC().getTypeResolver().transformJavaType(javaRecordComponent.getType(), attributes$default);
            arrayList.add(new kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl(classConstructorDescriptorImpl, null, i, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion.getEMPTY(), javaRecordComponent.getName(), kotlinTypeTransformJavaType, false, false, false, javaRecordComponent.isVararg() ? getC().getComponents().getModule().getBuiltIns().getArrayElementType(kotlinTypeTransformJavaType) : null, getC().getComponents().getSourceElementFactory().source(javaRecordComponent)));
            i = i2;
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected boolean isVisibleAsFunction(kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor javaMethodDescriptor) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(javaMethodDescriptor, "<this>");
        if (this.jClass.isAnnotationType()) {
            return false;
        }
        return isVisibleAsFunctionInCurrentClass(javaMethodDescriptor);
    }

    private final boolean isVisibleAsFunctionInCurrentClass(final kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor simpleFunctionDescriptor) {
        kotlin.reflect.jvm.internal.impl.name.Name name = simpleFunctionDescriptor.getName();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        java.util.List<kotlin.reflect.jvm.internal.impl.name.Name> propertyNamesCandidatesByAccessorName = kotlin.reflect.jvm.internal.impl.load.java.PropertiesConventionUtilKt.getPropertyNamesCandidatesByAccessorName(name);
        if (!(propertyNamesCandidatesByAccessorName instanceof java.util.Collection) || !propertyNamesCandidatesByAccessorName.isEmpty()) {
            java.util.Iterator<T> it = propertyNamesCandidatesByAccessorName.iterator();
            while (it.hasNext()) {
                java.util.Set<kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor> propertiesFromSupertypes = getPropertiesFromSupertypes((kotlin.reflect.jvm.internal.impl.name.Name) it.next());
                if (!(propertiesFromSupertypes instanceof java.util.Collection) || !propertiesFromSupertypes.isEmpty()) {
                    for (kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor propertyDescriptor : propertiesFromSupertypes) {
                        if (doesClassOverridesProperty(propertyDescriptor, new kotlin.jvm.functions.Function1(simpleFunctionDescriptor, this) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$$Lambda$6
                            private final kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor arg$0;
                            private final kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope arg$1;

                            {
                                this.arg$0 = simpleFunctionDescriptor;
                                this.arg$1 = this;
                            }

                            @Override // kotlin.jvm.functions.Function1
                            /* JADX INFO: renamed from: invoke */
                            public java.lang.Object invoke2(java.lang.Object obj) {
                                return kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope.isVisibleAsFunctionInCurrentClass$lambda$8$lambda$7$lambda$6(this.arg$0, this.arg$1, (kotlin.reflect.jvm.internal.impl.name.Name) obj);
                            }
                        })) {
                            if (!propertyDescriptor.isVar()) {
                                java.lang.String strAsString = simpleFunctionDescriptor.getName().asString();
                                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strAsString, "asString(...)");
                                if (!kotlin.reflect.jvm.internal.impl.load.java.JvmAbi.isSetterName(strAsString)) {
                                }
                            }
                            return false;
                        }
                    }
                }
            }
        }
        return (doesOverrideRenamedBuiltins(simpleFunctionDescriptor) || shouldBeVisibleAsOverrideOfBuiltInWithErasedValueParameters(simpleFunctionDescriptor) || doesOverrideSuspendFunction(simpleFunctionDescriptor)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.util.Collection isVisibleAsFunctionInCurrentClass$lambda$8$lambda$7$lambda$6(kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor simpleFunctionDescriptor, kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope lazyJavaClassMemberScope, kotlin.reflect.jvm.internal.impl.name.Name accessorName) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(accessorName, "accessorName");
        if (kotlin.jvm.internal.Intrinsics.areEqual(simpleFunctionDescriptor.getName(), accessorName)) {
            return kotlin.collections.CollectionsKt.listOf(simpleFunctionDescriptor);
        }
        return kotlin.collections.CollectionsKt.plus((java.util.Collection) lazyJavaClassMemberScope.searchMethodsByNameWithoutBuiltinMagic(accessorName), (java.lang.Iterable) lazyJavaClassMemberScope.searchMethodsInSupertypesWithoutBuiltinMagic(accessorName));
    }

    private final boolean shouldBeVisibleAsOverrideOfBuiltInWithErasedValueParameters(kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor simpleFunctionDescriptor) {
        kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature builtinMethodsWithSpecialGenericSignature = kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature.INSTANCE;
        kotlin.reflect.jvm.internal.impl.name.Name name = simpleFunctionDescriptor.getName();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        if (!builtinMethodsWithSpecialGenericSignature.getSameAsBuiltinMethodWithErasedValueParameters(name)) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.name.Name name2 = simpleFunctionDescriptor.getName();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
        java.util.Set<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> functionsFromSupertypes = getFunctionsFromSupertypes(name2);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator<T> it = functionsFromSupertypes.iterator();
        while (it.hasNext()) {
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor overriddenBuiltinFunctionWithErasedValueParametersInJava = kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature.getOverriddenBuiltinFunctionWithErasedValueParametersInJava((kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) it.next());
            if (overriddenBuiltinFunctionWithErasedValueParametersInJava != null) {
                arrayList.add(overriddenBuiltinFunctionWithErasedValueParametersInJava);
            }
        }
        java.util.ArrayList arrayList2 = arrayList;
        if ((arrayList2 instanceof java.util.Collection) && arrayList2.isEmpty()) {
            return false;
        }
        java.util.Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            if (hasSameJvmDescriptorButDoesNotOverride(simpleFunctionDescriptor, (kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) it2.next())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> searchMethodsByNameWithoutBuiltinMagic(kotlin.reflect.jvm.internal.impl.name.Name name) {
        java.util.Collection<kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod> collectionFindMethodsByName = getDeclaredMemberIndex().invoke().findMethodsByName(name);
        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(collectionFindMethodsByName, 10));
        java.util.Iterator<T> it = collectionFindMethodsByName.iterator();
        while (it.hasNext()) {
            arrayList.add(resolveMethodToFunctionDescriptor((kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod) it.next()));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> searchMethodsInSupertypesWithoutBuiltinMagic(kotlin.reflect.jvm.internal.impl.name.Name name) {
        java.util.Set<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> functionsFromSupertypes = getFunctionsFromSupertypes(name);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.lang.Object obj : functionsFromSupertypes) {
            kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor simpleFunctionDescriptor = (kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) obj;
            if (!kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers.doesOverrideBuiltinWithDifferentJvmName(simpleFunctionDescriptor) && kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature.getOverriddenBuiltinFunctionWithErasedValueParametersInJava(simpleFunctionDescriptor) == null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    private final boolean doesOverrideRenamedBuiltins(kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor simpleFunctionDescriptor) {
        kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.Companion companion = kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.Companion;
        kotlin.reflect.jvm.internal.impl.name.Name name = simpleFunctionDescriptor.getName();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        kotlin.reflect.jvm.internal.impl.name.Name builtinFunctionNamesByJvmName = companion.getBuiltinFunctionNamesByJvmName(name);
        if (builtinFunctionNamesByJvmName == null) {
            return false;
        }
        java.util.Set<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> functionsFromSupertypes = getFunctionsFromSupertypes(builtinFunctionNamesByJvmName);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.lang.Object obj : functionsFromSupertypes) {
            if (kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers.doesOverrideBuiltinWithDifferentJvmName((kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) obj)) {
                arrayList.add(obj);
            }
        }
        java.util.ArrayList arrayList2 = arrayList;
        if (arrayList2.isEmpty()) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor simpleFunctionDescriptorCreateRenamedCopy = createRenamedCopy(simpleFunctionDescriptor, builtinFunctionNamesByJvmName);
        java.util.ArrayList arrayList3 = arrayList2;
        if ((arrayList3 instanceof java.util.Collection) && arrayList3.isEmpty()) {
            return false;
        }
        java.util.Iterator it = arrayList3.iterator();
        while (it.hasNext()) {
            if (doesOverrideRenamedDescriptor((kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) it.next(), simpleFunctionDescriptorCreateRenamedCopy)) {
                return true;
            }
        }
        return false;
    }

    private final boolean doesOverrideSuspendFunction(kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor simpleFunctionDescriptor) {
        kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor simpleFunctionDescriptorCreateSuspendView = createSuspendView(simpleFunctionDescriptor);
        if (simpleFunctionDescriptorCreateSuspendView == null) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.name.Name name = simpleFunctionDescriptor.getName();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        java.util.Set<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> functionsFromSupertypes = getFunctionsFromSupertypes(name);
        if ((functionsFromSupertypes instanceof java.util.Collection) && functionsFromSupertypes.isEmpty()) {
            return false;
        }
        for (kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor simpleFunctionDescriptor2 : functionsFromSupertypes) {
            if (simpleFunctionDescriptor2.isSuspend() && doesOverride(simpleFunctionDescriptorCreateSuspendView, simpleFunctionDescriptor2)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0037  */
    private final kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor createSuspendView(kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor simpleFunctionDescriptor) {
        kotlin.reflect.jvm.internal.impl.name.FqName safe;
        kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe fqNameUnsafe;
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> valueParameters = simpleFunctionDescriptor.getValueParameters();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(valueParameters, "getValueParameters(...)");
        kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor valueParameterDescriptor = (kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) kotlin.collections.CollectionsKt.lastOrNull((java.util.List) valueParameters);
        if (valueParameterDescriptor != null) {
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptorMo1835getDeclarationDescriptor = valueParameterDescriptor.getType().getConstructor().mo1835getDeclarationDescriptor();
            if (classifierDescriptorMo1835getDeclarationDescriptor == null || (fqNameUnsafe = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getFqNameUnsafe(classifierDescriptorMo1835getDeclarationDescriptor)) == null) {
                safe = null;
            } else {
                if (!fqNameUnsafe.isSafe()) {
                    fqNameUnsafe = null;
                }
                if (fqNameUnsafe != null) {
                    safe = fqNameUnsafe.toSafe();
                } else {
                    safe = null;
                }
            }
            if (!kotlin.jvm.internal.Intrinsics.areEqual(safe, kotlin.reflect.jvm.internal.impl.builtins.StandardNames.CONTINUATION_INTERFACE_FQ_NAME)) {
                valueParameterDescriptor = null;
            }
            if (valueParameterDescriptor != null) {
                kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder<? extends kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> copyBuilderNewCopyBuilder = simpleFunctionDescriptor.newCopyBuilder();
                java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> valueParameters2 = simpleFunctionDescriptor.getValueParameters();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(valueParameters2, "getValueParameters(...)");
                kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor simpleFunctionDescriptor2 = (kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) copyBuilderNewCopyBuilder.setValueParameters(kotlin.collections.CollectionsKt.dropLast(valueParameters2, 1)).setReturnType(valueParameterDescriptor.getType().getArguments().get(0).getType()).build();
                kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl simpleFunctionDescriptorImpl = (kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl) simpleFunctionDescriptor2;
                if (simpleFunctionDescriptorImpl != null) {
                    simpleFunctionDescriptorImpl.setSuspend(true);
                }
                return simpleFunctionDescriptor2;
            }
        }
        return null;
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor createRenamedCopy(kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor simpleFunctionDescriptor, kotlin.reflect.jvm.internal.impl.name.Name name) {
        kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder<? extends kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> copyBuilderNewCopyBuilder = simpleFunctionDescriptor.newCopyBuilder();
        copyBuilderNewCopyBuilder.setName(name);
        copyBuilderNewCopyBuilder.setSignatureChange();
        copyBuilderNewCopyBuilder.setPreserveSourceElement();
        kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor functionDescriptorBuild = copyBuilderNewCopyBuilder.build();
        kotlin.jvm.internal.Intrinsics.checkNotNull(functionDescriptorBuild);
        return (kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) functionDescriptorBuild;
    }

    private final boolean doesOverrideRenamedDescriptor(kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor simpleFunctionDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor functionDescriptor) {
        if (kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithDifferentJvmName.INSTANCE.isRemoveAtByIndex(simpleFunctionDescriptor)) {
            functionDescriptor = functionDescriptor.getOriginal();
        }
        kotlin.jvm.internal.Intrinsics.checkNotNull(functionDescriptor);
        return doesOverride(functionDescriptor, simpleFunctionDescriptor);
    }

    private final boolean doesOverride(kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor callableDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor callableDescriptor2) {
        kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo.Result result = kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.DEFAULT.isOverridableByWithoutExternalConditions(callableDescriptor2, callableDescriptor, true).getResult();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(result, "getResult(...)");
        return result == kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE && !kotlin.reflect.jvm.internal.impl.load.java.JavaIncompatibilityRulesOverridabilityCondition.Companion.doesJavaOverrideHaveIncompatibleValueParameterKinds(callableDescriptor2, callableDescriptor);
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor findGetterOverride(kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor propertyDescriptor, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.name.Name, ? extends java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor>> function1) {
        kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor getter = propertyDescriptor.getGetter();
        kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor propertyGetterDescriptor = getter != null ? (kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor) kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers.getOverriddenBuiltinWithDifferentJvmName(getter) : null;
        java.lang.String builtinSpecialPropertyGetterName = propertyGetterDescriptor != null ? kotlin.reflect.jvm.internal.impl.load.java.ClassicBuiltinSpecialProperties.INSTANCE.getBuiltinSpecialPropertyGetterName(propertyGetterDescriptor) : null;
        if (builtinSpecialPropertyGetterName != null && !kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers.hasRealKotlinSuperClassWithOverrideOf(getOwnerDescriptor(), propertyGetterDescriptor)) {
            return findGetterByName(propertyDescriptor, builtinSpecialPropertyGetterName, function1);
        }
        java.lang.String strAsString = propertyDescriptor.getName().asString();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strAsString, "asString(...)");
        return findGetterByName(propertyDescriptor, kotlin.reflect.jvm.internal.impl.load.java.JvmAbi.getterName(strAsString), function1);
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor findGetterByName(kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor propertyDescriptor, java.lang.String str, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.name.Name, ? extends java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor>> function1) {
        kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor simpleFunctionDescriptor;
        kotlin.reflect.jvm.internal.impl.name.Name nameIdentifier = kotlin.reflect.jvm.internal.impl.name.Name.identifier(str);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameIdentifier, "identifier(...)");
        java.util.Iterator<T> it = function1.invoke2(nameIdentifier).iterator();
        do {
            simpleFunctionDescriptor = null;
            if (!it.hasNext()) {
                break;
            }
            kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor simpleFunctionDescriptor2 = (kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) it.next();
            if (simpleFunctionDescriptor2.getValueParameters().size() == 0) {
                kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker kotlinTypeChecker = kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker.DEFAULT;
                kotlin.reflect.jvm.internal.impl.types.KotlinType returnType = simpleFunctionDescriptor2.getReturnType();
                if (returnType == null ? false : kotlinTypeChecker.isSubtypeOf(returnType, propertyDescriptor.getType())) {
                    simpleFunctionDescriptor = simpleFunctionDescriptor2;
                }
            }
        } while (simpleFunctionDescriptor == null);
        return simpleFunctionDescriptor;
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor findSetterOverride(kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor propertyDescriptor, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.name.Name, ? extends java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor>> function1) {
        kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor simpleFunctionDescriptor;
        kotlin.reflect.jvm.internal.impl.types.KotlinType returnType;
        java.lang.String strAsString = propertyDescriptor.getName().asString();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strAsString, "asString(...)");
        kotlin.reflect.jvm.internal.impl.name.Name nameIdentifier = kotlin.reflect.jvm.internal.impl.name.Name.identifier(kotlin.reflect.jvm.internal.impl.load.java.JvmAbi.setterName(strAsString));
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameIdentifier, "identifier(...)");
        java.util.Iterator<T> it = function1.invoke2(nameIdentifier).iterator();
        do {
            simpleFunctionDescriptor = null;
            if (!it.hasNext()) {
                break;
            }
            kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor simpleFunctionDescriptor2 = (kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) it.next();
            if (simpleFunctionDescriptor2.getValueParameters().size() == 1 && (returnType = simpleFunctionDescriptor2.getReturnType()) != null && kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isUnit(returnType)) {
                kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker kotlinTypeChecker = kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker.DEFAULT;
                java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> valueParameters = simpleFunctionDescriptor2.getValueParameters();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(valueParameters, "getValueParameters(...)");
                if (kotlinTypeChecker.equalTypes(((kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) kotlin.collections.CollectionsKt.single((java.util.List) valueParameters)).getType(), propertyDescriptor.getType())) {
                    simpleFunctionDescriptor = simpleFunctionDescriptor2;
                }
            }
        } while (simpleFunctionDescriptor == null);
        return simpleFunctionDescriptor;
    }

    private final boolean doesClassOverridesProperty(kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor propertyDescriptor, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.name.Name, ? extends java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor>> function1) {
        if (kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.JavaDescriptorUtilKt.isJavaField(propertyDescriptor)) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor simpleFunctionDescriptorFindGetterOverride = findGetterOverride(propertyDescriptor, function1);
        kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor simpleFunctionDescriptorFindSetterOverride = findSetterOverride(propertyDescriptor, function1);
        if (simpleFunctionDescriptorFindGetterOverride == null) {
            return false;
        }
        if (propertyDescriptor.isVar()) {
            return simpleFunctionDescriptorFindSetterOverride != null && simpleFunctionDescriptorFindSetterOverride.getModality() == simpleFunctionDescriptorFindGetterOverride.getModality();
        }
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected void computeNonDeclaredFunctions(java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> result, kotlin.reflect.jvm.internal.impl.name.Name name) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(result, "result");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        java.util.Set<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> functionsFromSupertypes = getFunctionsFromSupertypes(name);
        if (!kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.Companion.getSameAsRenamedInJvmBuiltin(name) && !kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature.INSTANCE.getSameAsBuiltinMethodWithErasedValueParameters(name)) {
            java.util.Set<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> set = functionsFromSupertypes;
            if (!(set instanceof java.util.Collection) || !set.isEmpty()) {
                java.util.Iterator<T> it = set.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (((kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) it.next()).isSuspend()) {
                        }
                    }
                }
            }
            java.util.ArrayList arrayList = new java.util.ArrayList();
            for (java.lang.Object obj : set) {
                if (isVisibleAsFunctionInCurrentClass((kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) obj)) {
                    arrayList.add(obj);
                }
            }
            addFunctionFromSupertypes(result, name, arrayList, false);
            return;
        }
        kotlin.reflect.jvm.internal.impl.utils.SmartSet smartSetCreate = kotlin.reflect.jvm.internal.impl.utils.SmartSet.Companion.create();
        java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> collectionResolveOverridesForNonStaticMembers = kotlin.reflect.jvm.internal.impl.load.java.components.DescriptorResolverUtils.resolveOverridesForNonStaticMembers(name, functionsFromSupertypes, kotlin.collections.CollectionsKt.emptyList(), getOwnerDescriptor(), kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter.DO_NOTHING, getC().getComponents().getKotlinTypeChecker().getOverridingUtil());
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(collectionResolveOverridesForNonStaticMembers, "resolveOverridesForNonStaticMembers(...)");
        addOverriddenSpecialMethods(name, result, collectionResolveOverridesForNonStaticMembers, result, new kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope.AnonymousClass3(this));
        addOverriddenSpecialMethods(name, result, collectionResolveOverridesForNonStaticMembers, smartSetCreate, new kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope.AnonymousClass4(this));
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        for (java.lang.Object obj2 : functionsFromSupertypes) {
            if (isVisibleAsFunctionInCurrentClass((kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) obj2)) {
                arrayList2.add(obj2);
            }
        }
        addFunctionFromSupertypes(result, name, kotlin.collections.CollectionsKt.plus((java.util.Collection) arrayList2, (java.lang.Iterable) smartSetCreate), true);
    }

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$computeNonDeclaredFunctions$3, reason: invalid class name */
    /* JADX INFO: compiled from: LazyJavaClassMemberScope.kt */
    static final /* synthetic */ class AnonymousClass3 extends kotlin.jvm.internal.FunctionReferenceImpl implements kotlin.jvm.functions.Function1<kotlin.reflect.jvm.internal.impl.name.Name, java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor>> {
        AnonymousClass3(java.lang.Object obj) {
            super(1, obj, kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope.class, "searchMethodsByNameWithoutBuiltinMagic", "searchMethodsByNameWithoutBuiltinMagic(Lorg/jetbrains/kotlin/name/Name;)Ljava/util/Collection;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> invoke2(kotlin.reflect.jvm.internal.impl.name.Name p0) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(p0, "p0");
            return ((kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope) this.receiver).searchMethodsByNameWithoutBuiltinMagic(p0);
        }
    }

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$computeNonDeclaredFunctions$4, reason: invalid class name */
    /* JADX INFO: compiled from: LazyJavaClassMemberScope.kt */
    static final /* synthetic */ class AnonymousClass4 extends kotlin.jvm.internal.FunctionReferenceImpl implements kotlin.jvm.functions.Function1<kotlin.reflect.jvm.internal.impl.name.Name, java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor>> {
        AnonymousClass4(java.lang.Object obj) {
            super(1, obj, kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope.class, "searchMethodsInSupertypesWithoutBuiltinMagic", "searchMethodsInSupertypesWithoutBuiltinMagic(Lorg/jetbrains/kotlin/name/Name;)Ljava/util/Collection;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> invoke2(kotlin.reflect.jvm.internal.impl.name.Name p0) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(p0, "p0");
            return ((kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope) this.receiver).searchMethodsInSupertypesWithoutBuiltinMagic(p0);
        }
    }

    private final void addFunctionFromSupertypes(java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> collection, kotlin.reflect.jvm.internal.impl.name.Name name, java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> collection2, boolean z) {
        java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> collectionResolveOverridesForNonStaticMembers = kotlin.reflect.jvm.internal.impl.load.java.components.DescriptorResolverUtils.resolveOverridesForNonStaticMembers(name, collection2, collection, getOwnerDescriptor(), getC().getComponents().getErrorReporter(), getC().getComponents().getKotlinTypeChecker().getOverridingUtil());
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(collectionResolveOverridesForNonStaticMembers, "resolveOverridesForNonStaticMembers(...)");
        if (!z) {
            collection.addAll(collectionResolveOverridesForNonStaticMembers);
            return;
        }
        java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> collection3 = collectionResolveOverridesForNonStaticMembers;
        java.util.List listPlus = kotlin.collections.CollectionsKt.plus((java.util.Collection) collection, (java.lang.Iterable) collection3);
        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(collection3, 10));
        for (kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor simpleFunctionDescriptorCreateHiddenCopyIfBuiltinAlreadyAccidentallyOverridden : collection3) {
            kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor simpleFunctionDescriptor = (kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers.getOverriddenSpecialBuiltin(simpleFunctionDescriptorCreateHiddenCopyIfBuiltinAlreadyAccidentallyOverridden);
            if (simpleFunctionDescriptor == null) {
                kotlin.jvm.internal.Intrinsics.checkNotNull(simpleFunctionDescriptorCreateHiddenCopyIfBuiltinAlreadyAccidentallyOverridden);
            } else {
                kotlin.jvm.internal.Intrinsics.checkNotNull(simpleFunctionDescriptorCreateHiddenCopyIfBuiltinAlreadyAccidentallyOverridden);
                simpleFunctionDescriptorCreateHiddenCopyIfBuiltinAlreadyAccidentallyOverridden = createHiddenCopyIfBuiltinAlreadyAccidentallyOverridden(simpleFunctionDescriptorCreateHiddenCopyIfBuiltinAlreadyAccidentallyOverridden, simpleFunctionDescriptor, listPlus);
            }
            arrayList.add(simpleFunctionDescriptorCreateHiddenCopyIfBuiltinAlreadyAccidentallyOverridden);
        }
        collection.addAll(arrayList);
    }

    private final void addOverriddenSpecialMethods(kotlin.reflect.jvm.internal.impl.name.Name name, java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> collection, java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> collection2, java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> collection3, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.name.Name, ? extends java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor>> function1) {
        for (kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor simpleFunctionDescriptor : collection2) {
            kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(collection3, obtainOverrideForBuiltinWithDifferentJvmName(simpleFunctionDescriptor, function1, name, collection));
            kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(collection3, obtainOverrideForBuiltInWithErasedValueParametersInJava(simpleFunctionDescriptor, function1, collection));
            kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(collection3, obtainOverrideForSuspend(simpleFunctionDescriptor, function1));
        }
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor obtainOverrideForBuiltInWithErasedValueParametersInJava(kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor simpleFunctionDescriptor, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.name.Name, ? extends java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor>> function1, java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> collection) {
        kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor simpleFunctionDescriptorCreateOverrideForBuiltinFunctionWithErasedParameterIfNeeded;
        kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor overriddenBuiltinFunctionWithErasedValueParametersInJava = kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature.getOverriddenBuiltinFunctionWithErasedValueParametersInJava(simpleFunctionDescriptor);
        if (overriddenBuiltinFunctionWithErasedValueParametersInJava != null && (simpleFunctionDescriptorCreateOverrideForBuiltinFunctionWithErasedParameterIfNeeded = createOverrideForBuiltinFunctionWithErasedParameterIfNeeded(overriddenBuiltinFunctionWithErasedValueParametersInJava, function1)) != null) {
            if (!isVisibleAsFunctionInCurrentClass(simpleFunctionDescriptorCreateOverrideForBuiltinFunctionWithErasedParameterIfNeeded)) {
                simpleFunctionDescriptorCreateOverrideForBuiltinFunctionWithErasedParameterIfNeeded = null;
            }
            if (simpleFunctionDescriptorCreateOverrideForBuiltinFunctionWithErasedParameterIfNeeded != null) {
                return createHiddenCopyIfBuiltinAlreadyAccidentallyOverridden(simpleFunctionDescriptorCreateOverrideForBuiltinFunctionWithErasedParameterIfNeeded, overriddenBuiltinFunctionWithErasedValueParametersInJava, collection);
            }
        }
        return null;
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor obtainOverrideForBuiltinWithDifferentJvmName(kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor simpleFunctionDescriptor, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.name.Name, ? extends java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor>> function1, kotlin.reflect.jvm.internal.impl.name.Name name, java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> collection) {
        kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor simpleFunctionDescriptor2 = (kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers.getOverriddenBuiltinWithDifferentJvmName(simpleFunctionDescriptor);
        if (simpleFunctionDescriptor2 == null) {
            return null;
        }
        java.lang.String jvmMethodNameIfSpecial = kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers.getJvmMethodNameIfSpecial(simpleFunctionDescriptor2);
        kotlin.jvm.internal.Intrinsics.checkNotNull(jvmMethodNameIfSpecial);
        kotlin.reflect.jvm.internal.impl.name.Name nameIdentifier = kotlin.reflect.jvm.internal.impl.name.Name.identifier(jvmMethodNameIfSpecial);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameIdentifier, "identifier(...)");
        java.util.Iterator<? extends kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> it = function1.invoke2(nameIdentifier).iterator();
        while (it.hasNext()) {
            kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor simpleFunctionDescriptorCreateRenamedCopy = createRenamedCopy(it.next(), name);
            if (doesOverrideRenamedDescriptor(simpleFunctionDescriptor2, simpleFunctionDescriptorCreateRenamedCopy)) {
                return createHiddenCopyIfBuiltinAlreadyAccidentallyOverridden(simpleFunctionDescriptorCreateRenamedCopy, simpleFunctionDescriptor2, collection);
            }
        }
        return null;
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor obtainOverrideForSuspend(kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor simpleFunctionDescriptor, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.name.Name, ? extends java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor>> function1) {
        if (!simpleFunctionDescriptor.isSuspend()) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.name.Name name = simpleFunctionDescriptor.getName();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        java.util.Iterator<T> it = function1.invoke2(name).iterator();
        while (it.hasNext()) {
            kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor simpleFunctionDescriptorCreateSuspendView = createSuspendView((kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) it.next());
            if (simpleFunctionDescriptorCreateSuspendView == null || !doesOverride(simpleFunctionDescriptorCreateSuspendView, simpleFunctionDescriptor)) {
                simpleFunctionDescriptorCreateSuspendView = null;
            }
            if (simpleFunctionDescriptorCreateSuspendView != null) {
                return simpleFunctionDescriptorCreateSuspendView;
            }
        }
        return null;
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor createHiddenCopyIfBuiltinAlreadyAccidentallyOverridden(kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor simpleFunctionDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor callableDescriptor, java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> collection) {
        java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> collection2 = collection;
        if ((collection2 instanceof java.util.Collection) && collection2.isEmpty()) {
            return simpleFunctionDescriptor;
        }
        for (kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor simpleFunctionDescriptor2 : collection2) {
            if (!kotlin.jvm.internal.Intrinsics.areEqual(simpleFunctionDescriptor, simpleFunctionDescriptor2) && simpleFunctionDescriptor2.getInitialSignatureDescriptor() == null && doesOverride(simpleFunctionDescriptor2, callableDescriptor)) {
                kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor functionDescriptorBuild = simpleFunctionDescriptor.newCopyBuilder().setHiddenToOvercomeSignatureClash().build();
                kotlin.jvm.internal.Intrinsics.checkNotNull(functionDescriptorBuild);
                return (kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) functionDescriptorBuild;
            }
        }
        return simpleFunctionDescriptor;
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor createOverrideForBuiltinFunctionWithErasedParameterIfNeeded(kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor functionDescriptor, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.name.Name, ? extends java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor>> function1) {
        java.lang.Object next;
        kotlin.reflect.jvm.internal.impl.name.Name name = functionDescriptor.getName();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        java.util.Iterator<T> it = function1.invoke2(name).iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!hasSameJvmDescriptorButDoesNotOverride((kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) next, functionDescriptor));
        kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor simpleFunctionDescriptor = (kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) next;
        if (simpleFunctionDescriptor == null) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder<? extends kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> copyBuilderNewCopyBuilder = simpleFunctionDescriptor.newCopyBuilder();
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> valueParameters = functionDescriptor.getValueParameters();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(valueParameters, "getValueParameters(...)");
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> list = valueParameters;
        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(list, 10));
        java.util.Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList.add(((kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) it2.next()).getType());
        }
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> valueParameters2 = simpleFunctionDescriptor.getValueParameters();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(valueParameters2, "getValueParameters(...)");
        copyBuilderNewCopyBuilder.setValueParameters(kotlin.reflect.jvm.internal.impl.load.java.descriptors.UtilKt.copyValueParameters(arrayList, valueParameters2, functionDescriptor));
        copyBuilderNewCopyBuilder.setSignatureChange();
        copyBuilderNewCopyBuilder.setPreserveSourceElement();
        copyBuilderNewCopyBuilder.putUserData(kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor.HAS_ERASED_VALUE_PARAMETERS, true);
        return (kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) copyBuilderNewCopyBuilder.build();
    }

    private final java.util.Set<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> getFunctionsFromSupertypes(kotlin.reflect.jvm.internal.impl.name.Name name) {
        java.util.Collection<kotlin.reflect.jvm.internal.impl.types.KotlinType> collectionComputeSupertypes = computeSupertypes();
        java.util.LinkedHashSet linkedHashSet = new java.util.LinkedHashSet();
        java.util.Iterator<T> it = collectionComputeSupertypes.iterator();
        while (it.hasNext()) {
            kotlin.collections.CollectionsKt.addAll(linkedHashSet, ((kotlin.reflect.jvm.internal.impl.types.KotlinType) it.next()).getMemberScope().getContributedFunctions(name, kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation.WHEN_GET_SUPER_MEMBERS));
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected void computeImplicitlyDeclaredFunctions(java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> result, kotlin.reflect.jvm.internal.impl.name.Name name) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(result, "result");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        if (this.jClass.isRecord() && getDeclaredMemberIndex().invoke().findRecordComponentByName(name) != null) {
            java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> collection = result;
            if (collection.isEmpty()) {
                kotlin.reflect.jvm.internal.impl.load.java.structure.JavaRecordComponent javaRecordComponentFindRecordComponentByName = getDeclaredMemberIndex().invoke().findRecordComponentByName(name);
                kotlin.jvm.internal.Intrinsics.checkNotNull(javaRecordComponentFindRecordComponentByName);
                result.add(resolveRecordComponentToFunctionDescriptor(javaRecordComponentFindRecordComponentByName));
            } else {
                java.util.Iterator<T> it = collection.iterator();
                while (it.hasNext()) {
                    if (((kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) it.next()).getValueParameters().isEmpty()) {
                    }
                }
                kotlin.reflect.jvm.internal.impl.load.java.structure.JavaRecordComponent javaRecordComponentFindRecordComponentByName2 = getDeclaredMemberIndex().invoke().findRecordComponentByName(name);
                kotlin.jvm.internal.Intrinsics.checkNotNull(javaRecordComponentFindRecordComponentByName2);
                result.add(resolveRecordComponentToFunctionDescriptor(javaRecordComponentFindRecordComponentByName2));
            }
        }
        getC().getComponents().getSyntheticPartsProvider().generateMethods(getOwnerDescriptor(), name, result, getC());
    }

    private final kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor resolveRecordComponentToFunctionDescriptor(kotlin.reflect.jvm.internal.impl.load.java.structure.JavaRecordComponent javaRecordComponent) {
        kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor javaMethodDescriptorCreateJavaMethod = kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor.createJavaMethod(getOwnerDescriptor(), kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotationsKt.resolveAnnotations(getC(), javaRecordComponent), javaRecordComponent.getName(), getC().getComponents().getSourceElementFactory().source(javaRecordComponent), true);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(javaMethodDescriptorCreateJavaMethod, "createJavaMethod(...)");
        javaMethodDescriptorCreateJavaMethod.initialize(null, getDispatchReceiverParameter(), kotlin.collections.CollectionsKt.emptyList(), kotlin.collections.CollectionsKt.emptyList(), kotlin.collections.CollectionsKt.emptyList(), getC().getTypeResolver().transformJavaType(javaRecordComponent.getType(), kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributesKt.toAttributes$default(kotlin.reflect.jvm.internal.impl.types.TypeUsage.COMMON, false, false, null, 6, null)), kotlin.reflect.jvm.internal.impl.descriptors.Modality.Companion.convertFromFlags(false, false, true), kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.PUBLIC, null);
        javaMethodDescriptorCreateJavaMethod.setParameterNamesStatus(false, false);
        getC().getComponents().getJavaResolverCache().recordMethod(javaRecordComponent, javaMethodDescriptorCreateJavaMethod);
        return javaMethodDescriptorCreateJavaMethod;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected void computeNonDeclaredProperties(kotlin.reflect.jvm.internal.impl.name.Name name, java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor> result) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(result, "result");
        if (this.jClass.isAnnotationType()) {
            computeAnnotationProperties(name, result);
        }
        java.util.Set<kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor> propertiesFromSupertypes = getPropertiesFromSupertypes(name);
        if (propertiesFromSupertypes.isEmpty()) {
            return;
        }
        kotlin.reflect.jvm.internal.impl.utils.SmartSet smartSetCreate = kotlin.reflect.jvm.internal.impl.utils.SmartSet.Companion.create();
        kotlin.reflect.jvm.internal.impl.utils.SmartSet smartSetCreate2 = kotlin.reflect.jvm.internal.impl.utils.SmartSet.Companion.create();
        addPropertyOverrideByMethod(propertiesFromSupertypes, result, smartSetCreate, new kotlin.jvm.functions.Function1(this) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$$Lambda$7
            private final kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope.computeNonDeclaredProperties$lambda$36(this.arg$0, (kotlin.reflect.jvm.internal.impl.name.Name) obj);
            }
        });
        addPropertyOverrideByMethod(kotlin.collections.SetsKt.minus((java.util.Set) propertiesFromSupertypes, (java.lang.Iterable) smartSetCreate), smartSetCreate2, null, new kotlin.jvm.functions.Function1(this) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$$Lambda$8
            private final kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope.computeNonDeclaredProperties$lambda$37(this.arg$0, (kotlin.reflect.jvm.internal.impl.name.Name) obj);
            }
        });
        java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor> collectionResolveOverridesForNonStaticMembers = kotlin.reflect.jvm.internal.impl.load.java.components.DescriptorResolverUtils.resolveOverridesForNonStaticMembers(name, kotlin.collections.SetsKt.plus((java.util.Set) propertiesFromSupertypes, (java.lang.Iterable) smartSetCreate2), result, getOwnerDescriptor(), getC().getComponents().getErrorReporter(), getC().getComponents().getKotlinTypeChecker().getOverridingUtil());
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(collectionResolveOverridesForNonStaticMembers, "resolveOverridesForNonStaticMembers(...)");
        result.addAll(collectionResolveOverridesForNonStaticMembers);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.util.Collection computeNonDeclaredProperties$lambda$36(kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope lazyJavaClassMemberScope, kotlin.reflect.jvm.internal.impl.name.Name it) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(it, "it");
        return lazyJavaClassMemberScope.searchMethodsByNameWithoutBuiltinMagic(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.util.Collection computeNonDeclaredProperties$lambda$37(kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope lazyJavaClassMemberScope, kotlin.reflect.jvm.internal.impl.name.Name it) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(it, "it");
        return lazyJavaClassMemberScope.searchMethodsInSupertypesWithoutBuiltinMagic(it);
    }

    private final void addPropertyOverrideByMethod(java.util.Set<? extends kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor> set, java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor> collection, java.util.Set<kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor> set2, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.name.Name, ? extends java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor>> function1) {
        for (kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor propertyDescriptor : set) {
            kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaPropertyDescriptor javaPropertyDescriptorCreatePropertyDescriptorByMethods = createPropertyDescriptorByMethods(propertyDescriptor, function1);
            if (javaPropertyDescriptorCreatePropertyDescriptorByMethods != null) {
                collection.add(javaPropertyDescriptorCreatePropertyDescriptorByMethods);
                if (set2 != null) {
                    set2.add(propertyDescriptor);
                    return;
                }
                return;
            }
        }
    }

    private final void computeAnnotationProperties(kotlin.reflect.jvm.internal.impl.name.Name name, java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor> collection) {
        kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod javaMethod = (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod) kotlin.collections.CollectionsKt.singleOrNull(getDeclaredMemberIndex().invoke().findMethodsByName(name));
        if (javaMethod == null) {
            return;
        }
        collection.add(createPropertyDescriptorWithDefaultGetter$default(this, javaMethod, null, kotlin.reflect.jvm.internal.impl.descriptors.Modality.FINAL, 2, null));
    }

    static /* synthetic */ kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaPropertyDescriptor createPropertyDescriptorWithDefaultGetter$default(kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope lazyJavaClassMemberScope, kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod javaMethod, kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType, kotlin.reflect.jvm.internal.impl.descriptors.Modality modality, int i, java.lang.Object obj) {
        if ((i & 2) != 0) {
            kotlinType = null;
        }
        return lazyJavaClassMemberScope.createPropertyDescriptorWithDefaultGetter(javaMethod, kotlinType, modality);
    }

    private final kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaPropertyDescriptor createPropertyDescriptorWithDefaultGetter(kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod javaMethod, kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType, kotlin.reflect.jvm.internal.impl.descriptors.Modality modality) {
        kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope lazyJavaClassMemberScope;
        kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinTypeComputeMethodReturnType;
        kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaPropertyDescriptor javaPropertyDescriptorCreate = kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaPropertyDescriptor.create(getOwnerDescriptor(), kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotationsKt.resolveAnnotations(getC(), javaMethod), modality, kotlin.reflect.jvm.internal.impl.load.java.UtilsKt.toDescriptorVisibility(javaMethod.getVisibility()), false, javaMethod.getName(), getC().getComponents().getSourceElementFactory().source(javaMethod), false);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(javaPropertyDescriptorCreate, "create(...)");
        kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl propertyGetterDescriptorImplCreateDefaultGetter = kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory.createDefaultGetter(javaPropertyDescriptorCreate, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion.getEMPTY());
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(propertyGetterDescriptorImplCreateDefaultGetter, "createDefaultGetter(...)");
        javaPropertyDescriptorCreate.initialize(propertyGetterDescriptorImplCreateDefaultGetter, null);
        if (kotlinType == null) {
            lazyJavaClassMemberScope = this;
            kotlinTypeComputeMethodReturnType = lazyJavaClassMemberScope.computeMethodReturnType(javaMethod, kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt.childForMethod$default(getC(), javaPropertyDescriptorCreate, javaMethod, 0, 4, null));
        } else {
            lazyJavaClassMemberScope = this;
            kotlinTypeComputeMethodReturnType = kotlinType;
        }
        javaPropertyDescriptorCreate.setType(kotlinTypeComputeMethodReturnType, kotlin.collections.CollectionsKt.emptyList(), lazyJavaClassMemberScope.getDispatchReceiverParameter(), null, kotlin.collections.CollectionsKt.emptyList());
        propertyGetterDescriptorImplCreateDefaultGetter.initialize(kotlinTypeComputeMethodReturnType);
        return javaPropertyDescriptorCreate;
    }

    private final kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaPropertyDescriptor createPropertyDescriptorByMethods(kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor propertyDescriptor, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.name.Name, ? extends java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor>> function1) {
        kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor simpleFunctionDescriptorFindSetterOverride;
        kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertySetterDescriptorImpl propertySetterDescriptorImplCreateSetter = null;
        if (!doesClassOverridesProperty(propertyDescriptor, function1)) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor simpleFunctionDescriptorFindGetterOverride = findGetterOverride(propertyDescriptor, function1);
        kotlin.jvm.internal.Intrinsics.checkNotNull(simpleFunctionDescriptorFindGetterOverride);
        if (propertyDescriptor.isVar()) {
            simpleFunctionDescriptorFindSetterOverride = findSetterOverride(propertyDescriptor, function1);
            kotlin.jvm.internal.Intrinsics.checkNotNull(simpleFunctionDescriptorFindSetterOverride);
        } else {
            simpleFunctionDescriptorFindSetterOverride = null;
        }
        if (simpleFunctionDescriptorFindSetterOverride != null) {
            simpleFunctionDescriptorFindSetterOverride.getModality();
            simpleFunctionDescriptorFindGetterOverride.getModality();
        }
        kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaForKotlinOverridePropertyDescriptor javaForKotlinOverridePropertyDescriptor = new kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaForKotlinOverridePropertyDescriptor(getOwnerDescriptor(), simpleFunctionDescriptorFindGetterOverride, simpleFunctionDescriptorFindSetterOverride, propertyDescriptor);
        kotlin.reflect.jvm.internal.impl.types.KotlinType returnType = simpleFunctionDescriptorFindGetterOverride.getReturnType();
        kotlin.jvm.internal.Intrinsics.checkNotNull(returnType);
        javaForKotlinOverridePropertyDescriptor.setType(returnType, kotlin.collections.CollectionsKt.emptyList(), getDispatchReceiverParameter(), null, kotlin.collections.CollectionsKt.emptyList());
        kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaForKotlinOverridePropertyDescriptor javaForKotlinOverridePropertyDescriptor2 = javaForKotlinOverridePropertyDescriptor;
        kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl propertyGetterDescriptorImplCreateGetter = kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory.createGetter(javaForKotlinOverridePropertyDescriptor2, simpleFunctionDescriptorFindGetterOverride.getAnnotations(), false, false, false, simpleFunctionDescriptorFindGetterOverride.getSource());
        propertyGetterDescriptorImplCreateGetter.setInitialSignatureDescriptor(simpleFunctionDescriptorFindGetterOverride);
        propertyGetterDescriptorImplCreateGetter.initialize(javaForKotlinOverridePropertyDescriptor.getType());
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(propertyGetterDescriptorImplCreateGetter, "apply(...)");
        if (simpleFunctionDescriptorFindSetterOverride != null) {
            java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> valueParameters = simpleFunctionDescriptorFindSetterOverride.getValueParameters();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(valueParameters, "getValueParameters(...)");
            kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor valueParameterDescriptor = (kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) kotlin.collections.CollectionsKt.firstOrNull((java.util.List) valueParameters);
            if (valueParameterDescriptor == null) {
                throw new java.lang.AssertionError("No parameter found for " + simpleFunctionDescriptorFindSetterOverride);
            }
            propertySetterDescriptorImplCreateSetter = kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory.createSetter(javaForKotlinOverridePropertyDescriptor2, simpleFunctionDescriptorFindSetterOverride.getAnnotations(), valueParameterDescriptor.getAnnotations(), false, false, false, simpleFunctionDescriptorFindSetterOverride.getVisibility(), simpleFunctionDescriptorFindSetterOverride.getSource());
            propertySetterDescriptorImplCreateSetter.setInitialSignatureDescriptor(simpleFunctionDescriptorFindSetterOverride);
        }
        javaForKotlinOverridePropertyDescriptor.initialize(propertyGetterDescriptorImplCreateGetter, propertySetterDescriptorImplCreateSetter);
        return javaForKotlinOverridePropertyDescriptor;
    }

    private final java.util.Set<kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor> getPropertiesFromSupertypes(kotlin.reflect.jvm.internal.impl.name.Name name) {
        java.util.Collection<kotlin.reflect.jvm.internal.impl.types.KotlinType> collectionComputeSupertypes = computeSupertypes();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator<T> it = collectionComputeSupertypes.iterator();
        while (it.hasNext()) {
            java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor> contributedVariables = ((kotlin.reflect.jvm.internal.impl.types.KotlinType) it.next()).getMemberScope().getContributedVariables(name, kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation.WHEN_GET_SUPER_MEMBERS);
            java.util.ArrayList arrayList2 = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(contributedVariables, 10));
            java.util.Iterator<T> it2 = contributedVariables.iterator();
            while (it2.hasNext()) {
                arrayList2.add((kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor) it2.next());
            }
            kotlin.collections.CollectionsKt.addAll(arrayList, arrayList2);
        }
        return kotlin.collections.CollectionsKt.toSet(arrayList);
    }

    private final java.util.Collection<kotlin.reflect.jvm.internal.impl.types.KotlinType> computeSupertypes() {
        if (!this.skipRefinement) {
            return getC().getComponents().getKotlinTypeChecker().getKotlinTypeRefiner().refineSupertypes(getOwnerDescriptor());
        }
        java.util.Collection<kotlin.reflect.jvm.internal.impl.types.KotlinType> collectionMo1836getSupertypes = getOwnerDescriptor().getTypeConstructor().mo1836getSupertypes();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(collectionMo1836getSupertypes, "getSupertypes(...)");
        return collectionMo1836getSupertypes;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope.MethodSignatureData resolveMethodSignature(kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod method, java.util.List<? extends kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> methodTypeParameters, kotlin.reflect.jvm.internal.impl.types.KotlinType returnType, java.util.List<? extends kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> valueParameters) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(method, "method");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(methodTypeParameters, "methodTypeParameters");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(returnType, "returnType");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(valueParameters, "valueParameters");
        kotlin.reflect.jvm.internal.impl.load.java.components.SignaturePropagator.PropagatedSignature propagatedSignatureResolvePropagatedSignature = getC().getComponents().getSignaturePropagator().resolvePropagatedSignature(method, getOwnerDescriptor(), returnType, null, valueParameters, methodTypeParameters);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(propagatedSignatureResolvePropagatedSignature, "resolvePropagatedSignature(...)");
        kotlin.reflect.jvm.internal.impl.types.KotlinType returnType2 = propagatedSignatureResolvePropagatedSignature.getReturnType();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(returnType2, "getReturnType(...)");
        kotlin.reflect.jvm.internal.impl.types.KotlinType receiverType = propagatedSignatureResolvePropagatedSignature.getReceiverType();
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> valueParameters2 = propagatedSignatureResolvePropagatedSignature.getValueParameters();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(valueParameters2, "getValueParameters(...)");
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> typeParameters = propagatedSignatureResolvePropagatedSignature.getTypeParameters();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(typeParameters, "getTypeParameters(...)");
        boolean zHasStableParameterNames = propagatedSignatureResolvePropagatedSignature.hasStableParameterNames();
        java.util.List<java.lang.String> errors = propagatedSignatureResolvePropagatedSignature.getErrors();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(errors, "getErrors(...)");
        return new kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope.MethodSignatureData(returnType2, receiverType, valueParameters2, typeParameters, zHasStableParameterNames, errors);
    }

    private final boolean hasSameJvmDescriptorButDoesNotOverride(kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor simpleFunctionDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor functionDescriptor) {
        java.lang.String strComputeJvmDescriptor$default = kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt.computeJvmDescriptor$default(simpleFunctionDescriptor, false, false, 2, null);
        kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor original = functionDescriptor.getOriginal();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(original, "getOriginal(...)");
        return kotlin.jvm.internal.Intrinsics.areEqual(strComputeJvmDescriptor$default, kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt.computeJvmDescriptor$default(original, false, false, 2, null)) && !doesOverride(simpleFunctionDescriptor, functionDescriptor);
    }

    private final kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassConstructorDescriptor resolveConstructor(kotlin.reflect.jvm.internal.impl.load.java.structure.JavaConstructor javaConstructor) {
        kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor ownerDescriptor = getOwnerDescriptor();
        kotlin.reflect.jvm.internal.impl.load.java.structure.JavaConstructor javaConstructor2 = javaConstructor;
        kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassConstructorDescriptor javaClassConstructorDescriptorCreateJavaConstructor = kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassConstructorDescriptor.createJavaConstructor(ownerDescriptor, kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotationsKt.resolveAnnotations(getC(), javaConstructor), false, getC().getComponents().getSourceElementFactory().source(javaConstructor2));
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(javaClassConstructorDescriptorCreateJavaConstructor, "createJavaConstructor(...)");
        kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext lazyJavaResolverContextChildForMethod = kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt.childForMethod(getC(), javaClassConstructorDescriptorCreateJavaConstructor, javaConstructor, ownerDescriptor.getDeclaredTypeParameters().size());
        kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope.ResolvedValueParameters resolvedValueParametersResolveValueParameters = resolveValueParameters(lazyJavaResolverContextChildForMethod, javaClassConstructorDescriptorCreateJavaConstructor, javaConstructor.getValueParameters());
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> declaredTypeParameters = ownerDescriptor.getDeclaredTypeParameters();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(declaredTypeParameters, "getDeclaredTypeParameters(...)");
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> list = declaredTypeParameters;
        java.util.List<kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter> typeParameters = javaConstructor.getTypeParameters();
        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(typeParameters, 10));
        java.util.Iterator<T> it = typeParameters.iterator();
        while (it.hasNext()) {
            kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor typeParameterDescriptorResolveTypeParameter = lazyJavaResolverContextChildForMethod.getTypeParameterResolver().resolveTypeParameter((kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter) it.next());
            kotlin.jvm.internal.Intrinsics.checkNotNull(typeParameterDescriptorResolveTypeParameter);
            arrayList.add(typeParameterDescriptorResolveTypeParameter);
        }
        javaClassConstructorDescriptorCreateJavaConstructor.initialize(resolvedValueParametersResolveValueParameters.getDescriptors(), kotlin.reflect.jvm.internal.impl.load.java.UtilsKt.toDescriptorVisibility(javaConstructor.getVisibility()), kotlin.collections.CollectionsKt.plus((java.util.Collection) list, (java.lang.Iterable) arrayList));
        javaClassConstructorDescriptorCreateJavaConstructor.setHasStableParameterNames(false);
        javaClassConstructorDescriptorCreateJavaConstructor.setHasSynthesizedParameterNames(resolvedValueParametersResolveValueParameters.getHasSynthesizedNames());
        javaClassConstructorDescriptorCreateJavaConstructor.setReturnType(ownerDescriptor.getDefaultType());
        lazyJavaResolverContextChildForMethod.getComponents().getJavaResolverCache().recordConstructor(javaConstructor2, javaClassConstructorDescriptorCreateJavaConstructor);
        return javaClassConstructorDescriptorCreateJavaConstructor;
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor createDefaultConstructor() {
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> listCreateAnnotationConstructorParameters;
        boolean zIsAnnotationType = this.jClass.isAnnotationType();
        if ((this.jClass.isInterface() || !this.jClass.hasDefaultConstructor()) && !zIsAnnotationType) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor ownerDescriptor = getOwnerDescriptor();
        kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassConstructorDescriptor javaClassConstructorDescriptorCreateJavaConstructor = kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassConstructorDescriptor.createJavaConstructor(ownerDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion.getEMPTY(), true, getC().getComponents().getSourceElementFactory().source(this.jClass));
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(javaClassConstructorDescriptorCreateJavaConstructor, "createJavaConstructor(...)");
        if (zIsAnnotationType) {
            listCreateAnnotationConstructorParameters = createAnnotationConstructorParameters(javaClassConstructorDescriptorCreateJavaConstructor);
        } else {
            listCreateAnnotationConstructorParameters = java.util.Collections.EMPTY_LIST;
        }
        javaClassConstructorDescriptorCreateJavaConstructor.setHasSynthesizedParameterNames(false);
        javaClassConstructorDescriptorCreateJavaConstructor.initialize(listCreateAnnotationConstructorParameters, getConstructorVisibility(ownerDescriptor));
        javaClassConstructorDescriptorCreateJavaConstructor.setHasStableParameterNames(true);
        javaClassConstructorDescriptorCreateJavaConstructor.setReturnType(ownerDescriptor.getDefaultType());
        getC().getComponents().getJavaResolverCache().recordConstructor(this.jClass, javaClassConstructorDescriptorCreateJavaConstructor);
        return javaClassConstructorDescriptorCreateJavaConstructor;
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility getConstructorVisibility(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor) {
        kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility visibility = classDescriptor.getVisibility();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(visibility, "getVisibility(...)");
        if (!kotlin.jvm.internal.Intrinsics.areEqual(visibility, kotlin.reflect.jvm.internal.impl.load.java.JavaDescriptorVisibilities.PROTECTED_STATIC_VISIBILITY)) {
            return visibility;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility PROTECTED_AND_PACKAGE = kotlin.reflect.jvm.internal.impl.load.java.JavaDescriptorVisibilities.PROTECTED_AND_PACKAGE;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(PROTECTED_AND_PACKAGE, "PROTECTED_AND_PACKAGE");
        return PROTECTED_AND_PACKAGE;
    }

    private final java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> createAnnotationConstructorParameters(kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl classConstructorDescriptorImpl) {
        kotlin.Pair pair;
        java.util.Collection<kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod> methods = this.jClass.getMethods();
        java.util.ArrayList arrayList = new java.util.ArrayList(methods.size());
        kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes attributes$default = kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributesKt.toAttributes$default(kotlin.reflect.jvm.internal.impl.types.TypeUsage.COMMON, true, false, null, 6, null);
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        java.util.ArrayList arrayList3 = new java.util.ArrayList();
        for (java.lang.Object obj : methods) {
            if (kotlin.jvm.internal.Intrinsics.areEqual(((kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod) obj).getName(), kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames.DEFAULT_ANNOTATION_MEMBER_NAME)) {
                arrayList2.add(obj);
            } else {
                arrayList3.add(obj);
            }
        }
        kotlin.Pair pair2 = new kotlin.Pair(arrayList2, arrayList3);
        java.util.List list = (java.util.List) pair2.component1();
        java.util.List<kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod> list2 = (java.util.List) pair2.component2();
        list.size();
        kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod javaMethod = (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod) kotlin.collections.CollectionsKt.firstOrNull(list);
        if (javaMethod != null) {
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType returnType = javaMethod.getReturnType();
            if (returnType instanceof kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType) {
                kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType javaArrayType = (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType) returnType;
                pair = new kotlin.Pair(getC().getTypeResolver().transformArrayType(javaArrayType, attributes$default, true), getC().getTypeResolver().transformJavaType(javaArrayType.getComponentType(), attributes$default));
            } else {
                pair = new kotlin.Pair(getC().getTypeResolver().transformJavaType(returnType, attributes$default), null);
            }
            addAnnotationValueParameter(arrayList, classConstructorDescriptorImpl, 0, javaMethod, (kotlin.reflect.jvm.internal.impl.types.KotlinType) pair.component1(), (kotlin.reflect.jvm.internal.impl.types.KotlinType) pair.component2());
        }
        int i = 0;
        int i2 = javaMethod == null ? 0 : 1;
        for (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod javaMethod2 : list2) {
            addAnnotationValueParameter(arrayList, classConstructorDescriptorImpl, i + i2, javaMethod2, getC().getTypeResolver().transformJavaType(javaMethod2.getReturnType(), attributes$default), null);
            i++;
        }
        return arrayList;
    }

    private final void addAnnotationValueParameter(java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> list, kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor constructorDescriptor, int i, kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod javaMethod, kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType, kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType2) {
        kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor constructorDescriptor2 = constructorDescriptor;
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations empty = kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion.getEMPTY();
        kotlin.reflect.jvm.internal.impl.name.Name name = javaMethod.getName();
        kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinTypeMakeNotNullable = kotlin.reflect.jvm.internal.impl.types.TypeUtils.makeNotNullable(kotlinType);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(kotlinTypeMakeNotNullable, "makeNotNullable(...)");
        list.add(new kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl(constructorDescriptor2, null, i, empty, name, kotlinTypeMakeNotNullable, javaMethod.getHasAnnotationParameterDefaultValue(), false, false, kotlinType2 != null ? kotlin.reflect.jvm.internal.impl.types.TypeUtils.makeNotNullable(kotlinType2) : null, getC().getComponents().getSourceElementFactory().source(javaMethod)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.util.Set nestedClassIndex$lambda$49(kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope lazyJavaClassMemberScope) {
        return kotlin.collections.CollectionsKt.toSet(lazyJavaClassMemberScope.jClass.getInnerClassNames());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.util.Set generatedNestedClassNames$lambda$50(kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext lazyJavaResolverContext, kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope lazyJavaClassMemberScope) {
        return kotlin.collections.CollectionsKt.toSet(lazyJavaResolverContext.getComponents().getSyntheticPartsProvider().getNestedClassNames(lazyJavaClassMemberScope.getOwnerDescriptor(), lazyJavaResolverContext));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.util.Map enumEntryIndex$lambda$53(kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope lazyJavaClassMemberScope) {
        java.util.Collection<kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField> fields = lazyJavaClassMemberScope.jClass.getFields();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.lang.Object obj : fields) {
            if (((kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField) obj).isEnumEntry()) {
                arrayList.add(obj);
            }
        }
        java.util.ArrayList arrayList2 = arrayList;
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap(kotlin.ranges.RangesKt.coerceAtLeast(kotlin.collections.MapsKt.mapCapacity(kotlin.collections.CollectionsKt.collectionSizeOrDefault(arrayList2, 10)), 16));
        for (java.lang.Object obj2 : arrayList2) {
            linkedHashMap.put(((kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField) obj2).getName(), obj2);
        }
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor nestedClasses$lambda$59(final kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope lazyJavaClassMemberScope, kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext lazyJavaResolverContext, kotlin.reflect.jvm.internal.impl.name.Name name) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptorCreate = null;
        if (lazyJavaClassMemberScope.nestedClassIndex.invoke().contains(name)) {
            kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder finder = lazyJavaResolverContext.getComponents().getFinder();
            kotlin.reflect.jvm.internal.impl.name.ClassId classId = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getClassId(lazyJavaClassMemberScope.getOwnerDescriptor());
            kotlin.jvm.internal.Intrinsics.checkNotNull(classId);
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass javaClassFindClass = finder.findClass(new kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder.Request(classId.createNestedClassId(name), null, lazyJavaClassMemberScope.jClass, 2, null));
            if (javaClassFindClass != null) {
                kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor lazyJavaClassDescriptor = new kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor(lazyJavaResolverContext, lazyJavaClassMemberScope.getOwnerDescriptor(), javaClassFindClass, null, 8, null);
                lazyJavaResolverContext.getComponents().getJavaClassesTracker().reportClass(lazyJavaClassDescriptor);
                classDescriptorCreate = lazyJavaClassDescriptor;
            }
            return classDescriptorCreate;
        }
        if (lazyJavaClassMemberScope.generatedNestedClassNames.invoke().contains(name)) {
            java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor> listCreateListBuilder = kotlin.collections.CollectionsKt.createListBuilder();
            lazyJavaResolverContext.getComponents().getSyntheticPartsProvider().generateNestedClass(lazyJavaClassMemberScope.getOwnerDescriptor(), name, listCreateListBuilder, lazyJavaResolverContext);
            java.util.List listBuild = kotlin.collections.CollectionsKt.build(listCreateListBuilder);
            int size = listBuild.size();
            if (size == 0) {
                return null;
            }
            if (size == 1) {
                return (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) kotlin.collections.CollectionsKt.single(listBuild);
            }
            throw new java.lang.IllegalStateException(("Multiple classes with same name are generated: " + listBuild).toString());
        }
        kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField javaField = lazyJavaClassMemberScope.enumEntryIndex.invoke().get(name);
        if (javaField != null) {
            classDescriptorCreate = kotlin.reflect.jvm.internal.impl.descriptors.impl.EnumEntrySyntheticClassDescriptor.create(lazyJavaResolverContext.getStorageManager(), lazyJavaClassMemberScope.getOwnerDescriptor(), name, lazyJavaResolverContext.getStorageManager().createLazyValue(new kotlin.jvm.functions.Function0(lazyJavaClassMemberScope) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$$Lambda$9
                private final kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope arg$0;

                {
                    this.arg$0 = lazyJavaClassMemberScope;
                }

                @Override // kotlin.jvm.functions.Function0
                public java.lang.Object invoke() {
                    return kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope.nestedClasses$lambda$59$lambda$58(this.arg$0);
                }
            }), kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotationsKt.resolveAnnotations(lazyJavaResolverContext, javaField), lazyJavaResolverContext.getComponents().getSourceElementFactory().source(javaField));
        }
        return classDescriptorCreate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.util.Set nestedClasses$lambda$59$lambda$58(kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope lazyJavaClassMemberScope) {
        return kotlin.collections.SetsKt.plus((java.util.Set) lazyJavaClassMemberScope.getFunctionNames(), (java.lang.Iterable) lazyJavaClassMemberScope.getVariableNames());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor getDispatchReceiverParameter() {
        return kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.getDispatchReceiverParameterIfNeeded(getOwnerDescriptor());
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* JADX INFO: renamed from: getContributedClassifier */
    public kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor mo1837getContributedClassifier(kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation location) {
        kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable<kotlin.reflect.jvm.internal.impl.name.Name, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor> memoizedFunctionToNullable;
        kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptorInvoke;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(location, "location");
        mo1841recordLookup(name, location);
        kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope lazyJavaClassMemberScope = (kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope) getMainScope();
        return (lazyJavaClassMemberScope == null || (memoizedFunctionToNullable = lazyJavaClassMemberScope.nestedClasses) == null || (classDescriptorInvoke = memoizedFunctionToNullable.invoke2(name)) == null) ? this.nestedClasses.invoke2(name) : classDescriptorInvoke;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> getContributedFunctions(kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation location) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(location, "location");
        mo1841recordLookup(name, location);
        return super.getContributedFunctions(name, location);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor> getContributedVariables(kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation location) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(location, "location");
        mo1841recordLookup(name, location);
        return super.getContributedVariables(name, location);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> computeClassNames(kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter kindFilter, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.name.Name, java.lang.Boolean> function1) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kindFilter, "kindFilter");
        return kotlin.collections.SetsKt.plus((java.util.Set) this.nestedClassIndex.invoke(), (java.lang.Iterable) this.enumEntryIndex.invoke().keySet());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> computePropertyNames(kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter kindFilter, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.name.Name, java.lang.Boolean> function1) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kindFilter, "kindFilter");
        if (this.jClass.isAnnotationType()) {
            return getFunctionNames();
        }
        java.util.LinkedHashSet linkedHashSet = new java.util.LinkedHashSet(getDeclaredMemberIndex().invoke().getFieldNames());
        java.util.Collection<kotlin.reflect.jvm.internal.impl.types.KotlinType> collectionMo1836getSupertypes = getOwnerDescriptor().getTypeConstructor().mo1836getSupertypes();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(collectionMo1836getSupertypes, "getSupertypes(...)");
        java.util.Iterator<T> it = collectionMo1836getSupertypes.iterator();
        while (it.hasNext()) {
            kotlin.collections.CollectionsKt.addAll(linkedHashSet, ((kotlin.reflect.jvm.internal.impl.types.KotlinType) it.next()).getMemberScope().getVariableNames());
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* JADX INFO: renamed from: recordLookup */
    public void mo1841recordLookup(kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation location) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(location, "location");
        kotlin.reflect.jvm.internal.impl.incremental.UtilsKt.record(getC().getComponents().getLookupTracker(), location, getOwnerDescriptor(), name);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public java.lang.String toString() {
        return "Lazy Java member scope for " + this.jClass.getFqName();
    }
}
