package kotlin.reflect.jvm.internal.impl.builtins.jvm;

/* JADX INFO: compiled from: JvmBuiltInsCustomizer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class JvmBuiltInsCustomizer implements kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider, kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter {
    static final /* synthetic */ kotlin.reflect.KProperty<java.lang.Object>[] $$delegatedProperties = {kotlin.jvm.internal.Reflection.property1(new kotlin.jvm.internal.PropertyReference1Impl(kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer.class, "settings", "getSettings()Lorg/jetbrains/kotlin/builtins/jvm/JvmBuiltIns$Settings;", 0)), kotlin.jvm.internal.Reflection.property1(new kotlin.jvm.internal.PropertyReference1Impl(kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer.class, "cloneableType", "getCloneableType()Lorg/jetbrains/kotlin/types/SimpleType;", 0)), kotlin.jvm.internal.Reflection.property1(new kotlin.jvm.internal.PropertyReference1Impl(kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer.class, "notConsideredDeprecation", "getNotConsideredDeprecation()Lorg/jetbrains/kotlin/descriptors/annotations/Annotations;", 0))};
    private final kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue cloneableType$delegate;
    private final kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull<kotlin.Pair<java.lang.String, java.lang.String>, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations> deprecationForSomeOfTheListMethods;
    private final kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMapper j2kClassMapper;
    private final kotlin.reflect.jvm.internal.impl.storage.CacheWithNotNullValues<kotlin.reflect.jvm.internal.impl.name.FqName, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor> javaAnalogueClassesWithCustomSupertypeCache;
    private final kotlin.reflect.jvm.internal.impl.types.KotlinType mockSerializableType;
    private final kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor moduleDescriptor;
    private final kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue notConsideredDeprecation$delegate;
    private final kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue settings$delegate;

    /* JADX INFO: compiled from: JvmBuiltInsCustomizer.kt */
    private enum JDKMemberStatus {
        HIDDEN,
        VISIBLE,
        DEPRECATED_LIST_METHODS,
        NOT_CONSIDERED,
        DROP;

        private static final /* synthetic */ kotlin.enums.EnumEntries $ENTRIES = kotlin.enums.EnumEntriesKt.enumEntries(values());
    }

    /* JADX INFO: compiled from: JvmBuiltInsCustomizer.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer.JDKMemberStatus.values().length];
            try {
                iArr[kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer.JDKMemberStatus.HIDDEN.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                iArr[kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer.JDKMemberStatus.DEPRECATED_LIST_METHODS.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                iArr[kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer.JDKMemberStatus.NOT_CONSIDERED.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                iArr[kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer.JDKMemberStatus.DROP.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                iArr[kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer.JDKMemberStatus.VISIBLE.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public JvmBuiltInsCustomizer(kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor moduleDescriptor, final kotlin.reflect.jvm.internal.impl.storage.StorageManager storageManager, kotlin.jvm.functions.Function0<kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns.Settings> settingsComputation) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(moduleDescriptor, "moduleDescriptor");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(settingsComputation, "settingsComputation");
        this.moduleDescriptor = moduleDescriptor;
        this.j2kClassMapper = kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMapper.INSTANCE;
        this.settings$delegate = storageManager.createLazyValue(settingsComputation);
        this.mockSerializableType = createMockJavaIoSerializableType(storageManager);
        this.cloneableType$delegate = storageManager.createLazyValue(new kotlin.jvm.functions.Function0(this, storageManager) { // from class: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$$Lambda$0
            private final kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer arg$0;
            private final kotlin.reflect.jvm.internal.impl.storage.StorageManager arg$1;

            {
                this.arg$0 = this;
                this.arg$1 = storageManager;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer.cloneableType_delegate$lambda$0(this.arg$0, this.arg$1);
            }
        });
        this.javaAnalogueClassesWithCustomSupertypeCache = storageManager.createCacheWithNotNullValues();
        this.notConsideredDeprecation$delegate = storageManager.createLazyValue(new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$$Lambda$1
            private final kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer.notConsideredDeprecation_delegate$lambda$1(this.arg$0);
            }
        });
        this.deprecationForSomeOfTheListMethods = storageManager.createMemoizedFunction(new kotlin.jvm.functions.Function1(this) { // from class: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$$Lambda$2
            private final kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer.deprecationForSomeOfTheListMethods$lambda$2(this.arg$0, (kotlin.Pair) obj);
            }
        });
    }

    private final kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns.Settings getSettings() {
        return (kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns.Settings) kotlin.reflect.jvm.internal.impl.storage.StorageKt.getValue(this.settings$delegate, this, (kotlin.reflect.KProperty<?>) $$delegatedProperties[0]);
    }

    private final kotlin.reflect.jvm.internal.impl.types.SimpleType getCloneableType() {
        return (kotlin.reflect.jvm.internal.impl.types.SimpleType) kotlin.reflect.jvm.internal.impl.storage.StorageKt.getValue(this.cloneableType$delegate, this, (kotlin.reflect.KProperty<?>) $$delegatedProperties[1]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.types.SimpleType cloneableType_delegate$lambda$0(kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer jvmBuiltInsCustomizer, kotlin.reflect.jvm.internal.impl.storage.StorageManager storageManager) {
        return kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt.findNonGenericClassAcrossDependencies(jvmBuiltInsCustomizer.getSettings().getOwnerModuleDescriptor(), kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInClassDescriptorFactory.Companion.getCLONEABLE_CLASS_ID(), new kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses(storageManager, jvmBuiltInsCustomizer.getSettings().getOwnerModuleDescriptor())).getDefaultType();
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations getNotConsideredDeprecation() {
        return (kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations) kotlin.reflect.jvm.internal.impl.storage.StorageKt.getValue(this.notConsideredDeprecation$delegate, this, (kotlin.reflect.KProperty<?>) $$delegatedProperties[2]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations notConsideredDeprecation_delegate$lambda$1(kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer jvmBuiltInsCustomizer) {
        return kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion.create(kotlin.collections.CollectionsKt.listOf(kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUtilKt.createDeprecatedAnnotation$default(jvmBuiltInsCustomizer.moduleDescriptor.getBuiltIns(), "This member is not fully supported by Kotlin compiler, so it may be absent or have different signature in next major version", null, null, true, 6, null)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations deprecationForSomeOfTheListMethods$lambda$2(kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer jvmBuiltInsCustomizer, kotlin.Pair pair) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(pair, "<destruct>");
        java.lang.String str = (java.lang.String) pair.component1();
        java.lang.String str2 = (java.lang.String) pair.component2();
        return kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion.create(kotlin.collections.CollectionsKt.listOf(kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUtilKt.createDeprecatedAnnotation(jvmBuiltInsCustomizer.moduleDescriptor.getBuiltIns(), "'" + str + "()' member of List is redundant in Kotlin and might be removed soon. Please use '" + str2 + "()' stdlib extension instead", str2 + "()", "HIDDEN", false)));
    }

    private final kotlin.reflect.jvm.internal.impl.types.KotlinType createMockJavaIoSerializableType(kotlin.reflect.jvm.internal.impl.storage.StorageManager storageManager) {
        final kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor moduleDescriptor = this.moduleDescriptor;
        final kotlin.reflect.jvm.internal.impl.name.FqName fqName = new kotlin.reflect.jvm.internal.impl.name.FqName("java.io");
        kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorImpl classDescriptorImpl = new kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorImpl(new kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageFragmentDescriptorImpl(moduleDescriptor, fqName) { // from class: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$createMockJavaIoSerializableType$mockJavaIoPackageFragment$1
            @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor
            public kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope.Empty getMemberScope() {
                return kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope.Empty.INSTANCE;
            }
        }, kotlin.reflect.jvm.internal.impl.name.Name.identifier("Serializable"), kotlin.reflect.jvm.internal.impl.descriptors.Modality.ABSTRACT, kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.INTERFACE, kotlin.collections.CollectionsKt.listOf(new kotlin.reflect.jvm.internal.impl.types.LazyWrappedType(storageManager, new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$$Lambda$3
            private final kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer.createMockJavaIoSerializableType$lambda$3(this.arg$0);
            }
        })), kotlin.reflect.jvm.internal.impl.descriptors.SourceElement.NO_SOURCE, false, storageManager);
        classDescriptorImpl.initialize(kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope.Empty.INSTANCE, kotlin.collections.SetsKt.emptySet(), null);
        kotlin.reflect.jvm.internal.impl.types.SimpleType defaultType = classDescriptorImpl.getDefaultType();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(defaultType, "getDefaultType(...)");
        return defaultType;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.types.KotlinType createMockJavaIoSerializableType$lambda$3(kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer jvmBuiltInsCustomizer) {
        kotlin.reflect.jvm.internal.impl.types.SimpleType anyType = jvmBuiltInsCustomizer.moduleDescriptor.getBuiltIns().getAnyType();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(anyType, "getAnyType(...)");
        return anyType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider
    public java.util.Collection<kotlin.reflect.jvm.internal.impl.types.KotlinType> getSupertypes(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(classDescriptor, "classDescriptor");
        kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe fqNameUnsafe = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getFqNameUnsafe(classDescriptor);
        if (kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsSignatures.INSTANCE.isArrayOrPrimitiveArray(fqNameUnsafe)) {
            return kotlin.collections.CollectionsKt.listOf((java.lang.Object[]) new kotlin.reflect.jvm.internal.impl.types.KotlinType[]{getCloneableType(), this.mockSerializableType});
        }
        return kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsSignatures.INSTANCE.isSerializableInJava(fqNameUnsafe) ? kotlin.collections.CollectionsKt.listOf(this.mockSerializableType) : kotlin.collections.CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider
    public java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> getFunctions(final kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor) {
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations annotationsInvoke;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(classDescriptor, "classDescriptor");
        if (kotlin.jvm.internal.Intrinsics.areEqual(name, kotlin.reflect.jvm.internal.impl.builtins.jvm.CloneableClassScope.Companion.getCLONE_NAME()) && (classDescriptor instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor) && kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isArrayOrPrimitiveArray(classDescriptor)) {
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor deserializedClassDescriptor = (kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor) classDescriptor;
            java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function> functionList = deserializedClassDescriptor.getClassProto().getFunctionList();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(functionList, "getFunctionList(...)");
            java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function> list = functionList;
            if (!(list instanceof java.util.Collection) || !list.isEmpty()) {
                java.util.Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    if (kotlin.jvm.internal.Intrinsics.areEqual(kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt.getName(deserializedClassDescriptor.getC().getNameResolver(), ((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function) it.next()).getName()), kotlin.reflect.jvm.internal.impl.builtins.jvm.CloneableClassScope.Companion.getCLONE_NAME())) {
                        return kotlin.collections.CollectionsKt.emptyList();
                    }
                }
            }
            return kotlin.collections.CollectionsKt.listOf(createCloneForArray(deserializedClassDescriptor, (kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) kotlin.collections.CollectionsKt.single(getCloneableType().getMemberScope().getContributedFunctions(name, kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation.FROM_BUILTINS))));
        }
        if (!getSettings().isAdditionalBuiltInsFeatureSupported()) {
            return kotlin.collections.CollectionsKt.emptyList();
        }
        java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> additionalFunctions = getAdditionalFunctions(classDescriptor, new kotlin.jvm.functions.Function1(name) { // from class: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$$Lambda$4
            private final kotlin.reflect.jvm.internal.impl.name.Name arg$0;

            {
                this.arg$0 = name;
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer.getFunctions$lambda$5(this.arg$0, (kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope) obj);
            }
        });
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor simpleFunctionDescriptor : additionalFunctions) {
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor containingDeclaration = simpleFunctionDescriptor.getContainingDeclaration();
            kotlin.jvm.internal.Intrinsics.checkNotNull(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor functionDescriptorSubstitute = simpleFunctionDescriptor.substitute(kotlin.reflect.jvm.internal.impl.builtins.jvm.MappingUtilKt.createMappedTypeParametersSubstitution((kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) containingDeclaration, classDescriptor).buildSubstitutor());
            kotlin.jvm.internal.Intrinsics.checkNotNull(functionDescriptorSubstitute, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.SimpleFunctionDescriptor");
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder<? extends kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> copyBuilderNewCopyBuilder = ((kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) functionDescriptorSubstitute).newCopyBuilder();
            copyBuilderNewCopyBuilder.setOwner(classDescriptor);
            copyBuilderNewCopyBuilder.setDispatchReceiverParameter(classDescriptor.getThisAsReceiverParameter());
            copyBuilderNewCopyBuilder.setPreserveSourceElement();
            int i = kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer.WhenMappings.$EnumSwitchMapping$0[getJdkMethodStatus(simpleFunctionDescriptor).ordinal()];
            kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor simpleFunctionDescriptor2 = null;
            if (i == 1) {
                if (!kotlin.reflect.jvm.internal.impl.descriptors.ModalityUtilsKt.isFinalClass(classDescriptor)) {
                    copyBuilderNewCopyBuilder.setHiddenForResolutionEverywhereBesideSupercalls();
                    kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor functionDescriptorBuild = copyBuilderNewCopyBuilder.build();
                    kotlin.jvm.internal.Intrinsics.checkNotNull(functionDescriptorBuild);
                    simpleFunctionDescriptor2 = (kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) functionDescriptorBuild;
                }
            } else {
                if (i == 2) {
                    kotlin.reflect.jvm.internal.impl.name.Name name2 = simpleFunctionDescriptor.getName();
                    if (kotlin.jvm.internal.Intrinsics.areEqual(name2, kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizerKt.GET_FIRST_LIST_NAME)) {
                        annotationsInvoke = this.deprecationForSomeOfTheListMethods.invoke2(kotlin.TuplesKt.to(simpleFunctionDescriptor.getName().asString(), "first"));
                    } else {
                        if (!kotlin.jvm.internal.Intrinsics.areEqual(name2, kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizerKt.GET_LAST_LIST_NAME)) {
                            throw new java.lang.IllegalStateException(("Unexpected name: " + simpleFunctionDescriptor.getName()).toString());
                        }
                        annotationsInvoke = this.deprecationForSomeOfTheListMethods.invoke2(kotlin.TuplesKt.to(simpleFunctionDescriptor.getName().asString(), "last"));
                    }
                    copyBuilderNewCopyBuilder.setAdditionalAnnotations(annotationsInvoke);
                } else if (i == 3) {
                    copyBuilderNewCopyBuilder.setAdditionalAnnotations(getNotConsideredDeprecation());
                } else if (i != 4) {
                    if (i != 5) {
                        throw new kotlin.NoWhenBranchMatchedException();
                    }
                    kotlin.Unit unit = kotlin.Unit.INSTANCE;
                }
                kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor functionDescriptorBuild2 = copyBuilderNewCopyBuilder.build();
                kotlin.jvm.internal.Intrinsics.checkNotNull(functionDescriptorBuild2);
                simpleFunctionDescriptor2 = (kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) functionDescriptorBuild2;
            }
            if (simpleFunctionDescriptor2 != null) {
                arrayList.add(simpleFunctionDescriptor2);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.util.Collection getFunctions$lambda$5(kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope it) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(it, "it");
        return it.getContributedFunctions(name, kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation.FROM_BUILTINS);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider
    public java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> getFunctionsNames(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor) {
        kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope unsubstitutedMemberScope;
        java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> functionNames;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(classDescriptor, "classDescriptor");
        if (!getSettings().isAdditionalBuiltInsFeatureSupported()) {
            return kotlin.collections.SetsKt.emptySet();
        }
        kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor javaAnalogue = getJavaAnalogue(classDescriptor);
        return (javaAnalogue == null || (unsubstitutedMemberScope = javaAnalogue.getUnsubstitutedMemberScope()) == null || (functionNames = unsubstitutedMemberScope.getFunctionNames()) == null) ? kotlin.collections.SetsKt.emptySet() : functionNames;
    }

    private final java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> getAdditionalFunctions(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, ? extends java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor>> function1) {
        final kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor javaAnalogue = getJavaAnalogue(classDescriptor);
        if (javaAnalogue == null) {
            return kotlin.collections.CollectionsKt.emptyList();
        }
        kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor lazyJavaClassDescriptor = javaAnalogue;
        java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor> collectionMapPlatformClass = this.j2kClassMapper.mapPlatformClass(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getFqNameSafe(lazyJavaClassDescriptor), kotlin.reflect.jvm.internal.impl.builtins.jvm.FallbackBuiltIns.Companion.getInstance());
        final kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor2 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) kotlin.collections.CollectionsKt.lastOrNull(collectionMapPlatformClass);
        if (classDescriptor2 == null) {
            return kotlin.collections.CollectionsKt.emptyList();
        }
        kotlin.reflect.jvm.internal.impl.utils.SmartSet.Companion companion = kotlin.reflect.jvm.internal.impl.utils.SmartSet.Companion;
        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(collectionMapPlatformClass, 10));
        java.util.Iterator<T> it = collectionMapPlatformClass.iterator();
        while (it.hasNext()) {
            arrayList.add(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getFqNameSafe((kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) it.next()));
        }
        kotlin.reflect.jvm.internal.impl.utils.SmartSet smartSetCreate = companion.create(arrayList);
        boolean zIsMutable = this.j2kClassMapper.isMutable(classDescriptor);
        kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope unsubstitutedMemberScope = this.javaAnalogueClassesWithCustomSupertypeCache.computeIfAbsent(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getFqNameSafe(lazyJavaClassDescriptor), new kotlin.jvm.functions.Function0(javaAnalogue, classDescriptor2) { // from class: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$$Lambda$5
            private final kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor arg$0;
            private final kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor arg$1;

            {
                this.arg$0 = javaAnalogue;
                this.arg$1 = classDescriptor2;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer.getAdditionalFunctions$lambda$9(this.arg$0, this.arg$1);
            }
        }).getUnsubstitutedMemberScope();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(unsubstitutedMemberScope, "getUnsubstitutedMemberScope(...)");
        java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> collectionInvoke2 = function1.invoke2(unsubstitutedMemberScope);
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        for (java.lang.Object obj : collectionInvoke2) {
            kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor simpleFunctionDescriptor = (kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) obj;
            if (simpleFunctionDescriptor.getKind() == kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind.DECLARATION && simpleFunctionDescriptor.getVisibility().isPublicAPI() && !kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isDeprecated(simpleFunctionDescriptor)) {
                java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor> overriddenDescriptors = simpleFunctionDescriptor.getOverriddenDescriptors();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(overriddenDescriptors, "getOverriddenDescriptors(...)");
                java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor> collection = overriddenDescriptors;
                if (!(collection instanceof java.util.Collection) || !collection.isEmpty()) {
                    java.util.Iterator<T> it2 = collection.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor containingDeclaration = ((kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) it2.next()).getContainingDeclaration();
                            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(containingDeclaration, "getContainingDeclaration(...)");
                            if (smartSetCreate.contains(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getFqNameSafe(containingDeclaration))) {
                            }
                        }
                    }
                }
                if (!isMutabilityViolation(simpleFunctionDescriptor, zIsMutable)) {
                    arrayList2.add(obj);
                }
            }
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor getAdditionalFunctions$lambda$9(kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor lazyJavaClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor) {
        kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache EMPTY = kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache.EMPTY;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(EMPTY, "EMPTY");
        return lazyJavaClassDescriptor.copy$descriptors_jvm(EMPTY, classDescriptor);
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor createCloneForArray(kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor deserializedClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor simpleFunctionDescriptor) {
        kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder<? extends kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> copyBuilderNewCopyBuilder = simpleFunctionDescriptor.newCopyBuilder();
        copyBuilderNewCopyBuilder.setOwner(deserializedClassDescriptor);
        copyBuilderNewCopyBuilder.setVisibility(kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.PUBLIC);
        copyBuilderNewCopyBuilder.setReturnType(deserializedClassDescriptor.getDefaultType());
        copyBuilderNewCopyBuilder.setDispatchReceiverParameter(deserializedClassDescriptor.getThisAsReceiverParameter());
        kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor functionDescriptorBuild = copyBuilderNewCopyBuilder.build();
        kotlin.jvm.internal.Intrinsics.checkNotNull(functionDescriptorBuild);
        return (kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) functionDescriptorBuild;
    }

    private final boolean isMutabilityViolation(kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor simpleFunctionDescriptor, boolean z) {
        kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor containingDeclaration = simpleFunctionDescriptor.getContainingDeclaration();
        kotlin.jvm.internal.Intrinsics.checkNotNull(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        java.lang.String strComputeJvmDescriptor$default = kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt.computeJvmDescriptor$default(simpleFunctionDescriptor, false, false, 3, null);
        if (z ^ kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsSignatures.INSTANCE.getMUTABLE_METHOD_SIGNATURES().contains(kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureBuildingUtilsKt.signature(kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents.INSTANCE, (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) containingDeclaration, strComputeJvmDescriptor$default))) {
            return true;
        }
        java.lang.Boolean boolIfAny = kotlin.reflect.jvm.internal.impl.utils.DFS.ifAny(kotlin.collections.CollectionsKt.listOf(simpleFunctionDescriptor), new kotlin.reflect.jvm.internal.impl.utils.DFS.Neighbors() { // from class: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$$Lambda$6
            @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.Neighbors
            public java.lang.Iterable getNeighbors(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer.isMutabilityViolation$lambda$13((kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) obj);
            }
        }, new kotlin.jvm.functions.Function1(this) { // from class: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$$Lambda$7
            private final kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer.isMutabilityViolation$lambda$14(this.arg$0, (kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) obj);
            }
        });
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(boolIfAny, "ifAny(...)");
        return boolIfAny.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.lang.Iterable isMutabilityViolation$lambda$13(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor callableMemberDescriptor) {
        return callableMemberDescriptor.getOriginal().getOverriddenDescriptors();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x001d  */
    public static final java.lang.Boolean isMutabilityViolation$lambda$14(kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer jvmBuiltInsCustomizer, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor callableMemberDescriptor) {
        boolean z;
        if (callableMemberDescriptor.getKind() == kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind.DECLARATION) {
            kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMapper javaToKotlinClassMapper = jvmBuiltInsCustomizer.j2kClassMapper;
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor containingDeclaration = callableMemberDescriptor.getContainingDeclaration();
            kotlin.jvm.internal.Intrinsics.checkNotNull(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            if (javaToKotlinClassMapper.isMutable((kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) containingDeclaration)) {
                z = true;
            } else {
                z = false;
            }
        } else {
            z = false;
        }
        return java.lang.Boolean.valueOf(z);
    }

    private final kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer.JDKMemberStatus getJdkMethodStatus(kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor functionDescriptor) {
        kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor containingDeclaration = functionDescriptor.getContainingDeclaration();
        kotlin.jvm.internal.Intrinsics.checkNotNull(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        final java.lang.String strComputeJvmDescriptor$default = kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt.computeJvmDescriptor$default(functionDescriptor, false, false, 3, null);
        final kotlin.jvm.internal.Ref.ObjectRef objectRef = new kotlin.jvm.internal.Ref.ObjectRef();
        java.lang.Object objDfs = kotlin.reflect.jvm.internal.impl.utils.DFS.dfs(kotlin.collections.CollectionsKt.listOf((kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) containingDeclaration), new kotlin.reflect.jvm.internal.impl.utils.DFS.Neighbors(this) { // from class: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$$Lambda$8
            private final kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.Neighbors
            public java.lang.Iterable getNeighbors(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer.getJdkMethodStatus$lambda$16(this.arg$0, (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) obj);
            }
        }, new kotlin.reflect.jvm.internal.impl.utils.DFS.AbstractNodeHandler<kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer.JDKMemberStatus>() { // from class: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer.getJdkMethodStatus.2
            /* JADX WARN: Type inference failed for: r0v13, types: [T, kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$JDKMemberStatus] */
            /* JADX WARN: Type inference failed for: r0v14, types: [T, kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$JDKMemberStatus] */
            /* JADX WARN: Type inference failed for: r0v15, types: [T, kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$JDKMemberStatus] */
            /* JADX WARN: Type inference failed for: r0v16, types: [T, kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$JDKMemberStatus] */
            @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.AbstractNodeHandler, kotlin.reflect.jvm.internal.impl.utils.DFS.NodeHandler
            public boolean beforeChildren(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor javaClassDescriptor) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(javaClassDescriptor, "javaClassDescriptor");
                java.lang.String strSignature = kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureBuildingUtilsKt.signature(kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents.INSTANCE, javaClassDescriptor, strComputeJvmDescriptor$default);
                if (kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsSignatures.INSTANCE.getHIDDEN_METHOD_SIGNATURES().contains(strSignature)) {
                    objectRef.element = kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer.JDKMemberStatus.HIDDEN;
                } else if (kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsSignatures.INSTANCE.getVISIBLE_METHOD_SIGNATURES().contains(strSignature)) {
                    objectRef.element = kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer.JDKMemberStatus.VISIBLE;
                } else if (kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsSignatures.INSTANCE.getDEPRECATED_LIST_METHODS().contains(strSignature)) {
                    objectRef.element = kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer.JDKMemberStatus.DEPRECATED_LIST_METHODS;
                } else if (kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsSignatures.INSTANCE.getDROP_LIST_METHOD_SIGNATURES().contains(strSignature)) {
                    objectRef.element = kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer.JDKMemberStatus.DROP;
                }
                return objectRef.element == null;
            }

            @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.NodeHandler
            public kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer.JDKMemberStatus result() {
                kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer.JDKMemberStatus jDKMemberStatus = objectRef.element;
                return jDKMemberStatus == null ? kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer.JDKMemberStatus.NOT_CONSIDERED : jDKMemberStatus;
            }
        });
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(objDfs, "dfs(...)");
        return (kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer.JDKMemberStatus) objDfs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.lang.Iterable getJdkMethodStatus$lambda$16(kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer jvmBuiltInsCustomizer, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor) {
        java.util.Collection<kotlin.reflect.jvm.internal.impl.types.KotlinType> collectionMo1836getSupertypes = classDescriptor.getTypeConstructor().mo1836getSupertypes();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(collectionMo1836getSupertypes, "getSupertypes(...)");
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator<T> it = collectionMo1836getSupertypes.iterator();
        while (it.hasNext()) {
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptorMo1835getDeclarationDescriptor = ((kotlin.reflect.jvm.internal.impl.types.KotlinType) it.next()).getConstructor().mo1835getDeclarationDescriptor();
            kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor lazyJavaClassDescriptor = null;
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor original = classifierDescriptorMo1835getDeclarationDescriptor != null ? classifierDescriptorMo1835getDeclarationDescriptor.getOriginal() : null;
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor2 = original instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor ? (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) original : null;
            if (classDescriptor2 != null) {
                kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor javaAnalogue = jvmBuiltInsCustomizer.getJavaAnalogue(classDescriptor2);
                lazyJavaClassDescriptor = javaAnalogue != null ? javaAnalogue : classDescriptor2;
            }
            if (lazyJavaClassDescriptor != null) {
                arrayList.add(lazyJavaClassDescriptor);
            }
        }
        return arrayList;
    }

    private final kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor getJavaAnalogue(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor) {
        kotlin.reflect.jvm.internal.impl.name.ClassId classIdMapKotlinToJava;
        kotlin.reflect.jvm.internal.impl.name.FqName fqNameAsSingleFqName;
        if (kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isAny(classDescriptor)) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor2 = classDescriptor;
        if (!kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isUnderKotlinPackage(classDescriptor2)) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe fqNameUnsafe = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getFqNameUnsafe(classDescriptor2);
        if (fqNameUnsafe.isSafe() && (classIdMapKotlinToJava = kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap.INSTANCE.mapKotlinToJava(fqNameUnsafe)) != null && (fqNameAsSingleFqName = classIdMapKotlinToJava.asSingleFqName()) != null) {
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptorResolveClassByFqName = kotlin.reflect.jvm.internal.impl.descriptors.DescriptorUtilKt.resolveClassByFqName(getSettings().getOwnerModuleDescriptor(), fqNameAsSingleFqName, kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation.FROM_BUILTINS);
            if (classDescriptorResolveClassByFqName instanceof kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor) {
                return (kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor) classDescriptorResolveClassByFqName;
            }
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider
    public java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor> getConstructors(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor) {
        kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptorMapJavaToKotlin$default;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(classDescriptor, "classDescriptor");
        if (classDescriptor.getKind() != kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.CLASS || !getSettings().isAdditionalBuiltInsFeatureSupported()) {
            return kotlin.collections.CollectionsKt.emptyList();
        }
        kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor javaAnalogue = getJavaAnalogue(classDescriptor);
        if (javaAnalogue != null && (classDescriptorMapJavaToKotlin$default = kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMapper.mapJavaToKotlin$default(this.j2kClassMapper, kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getFqNameSafe(javaAnalogue), kotlin.reflect.jvm.internal.impl.builtins.jvm.FallbackBuiltIns.Companion.getInstance(), null, 4, null)) != null) {
            kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor lazyJavaClassDescriptor = javaAnalogue;
            kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor typeSubstitutorBuildSubstitutor = kotlin.reflect.jvm.internal.impl.builtins.jvm.MappingUtilKt.createMappedTypeParametersSubstitution(classDescriptorMapJavaToKotlin$default, lazyJavaClassDescriptor).buildSubstitutor();
            java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor> constructors = javaAnalogue.getConstructors();
            java.util.ArrayList arrayList = new java.util.ArrayList();
            for (java.lang.Object obj : constructors) {
                kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor classConstructorDescriptor = (kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor) obj;
                if (classConstructorDescriptor.getVisibility().isPublicAPI()) {
                    java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor> constructors2 = classDescriptorMapJavaToKotlin$default.getConstructors();
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(constructors2, "getConstructors(...)");
                    java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor> collection = constructors2;
                    if (!(collection instanceof java.util.Collection) || !collection.isEmpty()) {
                        java.util.Iterator<T> it = collection.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor classConstructorDescriptor2 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor) it.next();
                                kotlin.jvm.internal.Intrinsics.checkNotNull(classConstructorDescriptor2);
                                if (getConstructors$isEffectivelyTheSameAs(classConstructorDescriptor2, typeSubstitutorBuildSubstitutor, classConstructorDescriptor)) {
                                }
                            }
                        }
                    }
                    if (!isTrivialCopyConstructorFor(classConstructorDescriptor, classDescriptor) && !kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isDeprecated(classConstructorDescriptor) && !kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsSignatures.INSTANCE.getHIDDEN_CONSTRUCTOR_SIGNATURES().contains(kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureBuildingUtilsKt.signature(kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents.INSTANCE, lazyJavaClassDescriptor, kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt.computeJvmDescriptor$default(classConstructorDescriptor, false, false, 3, null)))) {
                        arrayList.add(obj);
                    }
                }
            }
            java.util.ArrayList<kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor> arrayList2 = arrayList;
            java.util.ArrayList arrayList3 = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
            for (kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor classConstructorDescriptor3 : arrayList2) {
                kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder<? extends kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor> copyBuilderNewCopyBuilder = classConstructorDescriptor3.newCopyBuilder();
                copyBuilderNewCopyBuilder.setOwner(classDescriptor);
                copyBuilderNewCopyBuilder.setReturnType(classDescriptor.getDefaultType());
                copyBuilderNewCopyBuilder.setPreserveSourceElement();
                copyBuilderNewCopyBuilder.setSubstitution(typeSubstitutorBuildSubstitutor.getSubstitution());
                if (!kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsSignatures.INSTANCE.getVISIBLE_CONSTRUCTOR_SIGNATURES().contains(kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureBuildingUtilsKt.signature(kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents.INSTANCE, lazyJavaClassDescriptor, kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt.computeJvmDescriptor$default(classConstructorDescriptor3, false, false, 3, null)))) {
                    copyBuilderNewCopyBuilder.setAdditionalAnnotations(getNotConsideredDeprecation());
                }
                kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor functionDescriptorBuild = copyBuilderNewCopyBuilder.build();
                kotlin.jvm.internal.Intrinsics.checkNotNull(functionDescriptorBuild, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassConstructorDescriptor");
                arrayList3.add((kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor) functionDescriptorBuild);
            }
            return arrayList3;
        }
        return kotlin.collections.CollectionsKt.emptyList();
    }

    private static final boolean getConstructors$isEffectivelyTheSameAs(kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor constructorDescriptor, kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor typeSubstitutor, kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor constructorDescriptor2) {
        return kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.getBothWaysOverridability(constructorDescriptor, constructorDescriptor2.substitute(typeSubstitutor)) == kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter
    public boolean isFunctionAvailable(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor functionDescriptor) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(classDescriptor, "classDescriptor");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(functionDescriptor, "functionDescriptor");
        kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor javaAnalogue = getJavaAnalogue(classDescriptor);
        if (javaAnalogue == null || !functionDescriptor.getAnnotations().hasAnnotation(kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilterKt.getPLATFORM_DEPENDENT_ANNOTATION_FQ_NAME())) {
            return true;
        }
        if (!getSettings().isAdditionalBuiltInsFeatureSupported()) {
            return false;
        }
        java.lang.String strComputeJvmDescriptor$default = kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt.computeJvmDescriptor$default(functionDescriptor, false, false, 3, null);
        kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope unsubstitutedMemberScope = javaAnalogue.getUnsubstitutedMemberScope();
        kotlin.reflect.jvm.internal.impl.name.Name name = functionDescriptor.getName();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> contributedFunctions = unsubstitutedMemberScope.getContributedFunctions(name, kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation.FROM_BUILTINS);
        if ((contributedFunctions instanceof java.util.Collection) && contributedFunctions.isEmpty()) {
            return false;
        }
        java.util.Iterator<T> it = contributedFunctions.iterator();
        while (it.hasNext()) {
            if (kotlin.jvm.internal.Intrinsics.areEqual(kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt.computeJvmDescriptor$default((kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) it.next(), false, false, 3, null), strComputeJvmDescriptor$default)) {
                return true;
            }
        }
        return false;
    }

    private final boolean isTrivialCopyConstructorFor(kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor constructorDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor) {
        if (constructorDescriptor.getValueParameters().size() != 1) {
            return false;
        }
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> valueParameters = constructorDescriptor.getValueParameters();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(valueParameters, "getValueParameters(...)");
        kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptorMo1835getDeclarationDescriptor = ((kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) kotlin.collections.CollectionsKt.single((java.util.List) valueParameters)).getType().getConstructor().mo1835getDeclarationDescriptor();
        return kotlin.jvm.internal.Intrinsics.areEqual(classifierDescriptorMo1835getDeclarationDescriptor != null ? kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getFqNameUnsafe(classifierDescriptorMo1835getDeclarationDescriptor) : null, kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getFqNameUnsafe(classDescriptor));
    }
}
