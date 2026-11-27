package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

/* JADX INFO: compiled from: LazyJavaClassDescriptor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class LazyJavaClassDescriptor extends kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorBase implements kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassDescriptor {
    public static final kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor.Companion Companion = new kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor.Companion(null);
    private static final java.util.Set<java.lang.String> PUBLIC_METHOD_NAMES_IN_OBJECT = kotlin.collections.SetsKt.setOf((java.lang.Object[]) new java.lang.String[]{"equals", "hashCode", "getClass", "wait", "notify", "notifyAll", "toString"});
    private final kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor additionalSupertypeClassDescriptor;
    private final kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations annotations;
    private final kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext c;
    private final kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue<java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor>> declaredParameters;
    private final kotlin.reflect.jvm.internal.impl.resolve.scopes.InnerClassesScopeWrapper innerClassesScope;
    private final boolean isInner;
    private final kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass jClass;
    private final kotlin.reflect.jvm.internal.impl.descriptors.ClassKind kind;
    private final kotlin.reflect.jvm.internal.impl.descriptors.Modality modality;
    private final kotlin.Lazy moduleAnnotations$delegate;
    private final kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext outerContext;
    private final kotlin.reflect.jvm.internal.impl.descriptors.ScopesHolderForClass<kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope> scopeHolder;
    private final kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticClassScope staticScope;
    private final kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor.LazyJavaClassTypeConstructor typeConstructor;
    private final kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope unsubstitutedMemberScope;
    private final kotlin.reflect.jvm.internal.impl.descriptors.Visibility visibility;

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    /* JADX INFO: renamed from: getCompanionObjectDescriptor */
    public kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor mo1824getCompanionObjectDescriptor() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    /* JADX INFO: renamed from: getUnsubstitutedPrimaryConstructor */
    public kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor mo1825getUnsubstitutedPrimaryConstructor() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public kotlin.reflect.jvm.internal.impl.descriptors.ValueClassRepresentation<kotlin.reflect.jvm.internal.impl.types.SimpleType> getValueClassRepresentation() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isActual() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isCompanionObject() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isData() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExpect() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isFun() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isInline() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isValue() {
        return false;
    }

    public /* synthetic */ LazyJavaClassDescriptor(kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext lazyJavaResolverContext, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor, kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass javaClass, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(lazyJavaResolverContext, declarationDescriptor, javaClass, (i & 8) != 0 ? null : classDescriptor);
    }

    public final kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass getJClass() {
        return this.jClass;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaClassDescriptor(kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext outerContext, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor containingDeclaration, kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass jClass, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor) {
        kotlin.reflect.jvm.internal.impl.descriptors.ClassKind classKind;
        kotlin.reflect.jvm.internal.impl.descriptors.Modality modalityConvertFromFlags;
        super(outerContext.getStorageManager(), containingDeclaration, jClass.getName(), outerContext.getComponents().getSourceElementFactory().source(jClass), false);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(outerContext, "outerContext");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(containingDeclaration, "containingDeclaration");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(jClass, "jClass");
        this.outerContext = outerContext;
        this.jClass = jClass;
        this.additionalSupertypeClassDescriptor = classDescriptor;
        kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext lazyJavaResolverContextChildForClassOrPackage$default = kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt.childForClassOrPackage$default(outerContext, this, jClass, 0, 4, null);
        this.c = lazyJavaResolverContextChildForClassOrPackage$default;
        kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor lazyJavaClassDescriptor = this;
        lazyJavaResolverContextChildForClassOrPackage$default.getComponents().getJavaResolverCache().recordClass(jClass, lazyJavaClassDescriptor);
        jClass.getLightClassOriginKind();
        this.moduleAnnotations$delegate = kotlin.LazyKt.lazy(new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor$$Lambda$0
            private final kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor.moduleAnnotations_delegate$lambda$2(this.arg$0);
            }
        });
        if (jClass.isAnnotationType()) {
            classKind = kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.ANNOTATION_CLASS;
        } else if (jClass.isInterface()) {
            classKind = kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.INTERFACE;
        } else {
            classKind = jClass.isEnum() ? kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.ENUM_CLASS : kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.CLASS;
        }
        this.kind = classKind;
        if (jClass.isAnnotationType() || jClass.isEnum()) {
            modalityConvertFromFlags = kotlin.reflect.jvm.internal.impl.descriptors.Modality.FINAL;
        } else {
            modalityConvertFromFlags = kotlin.reflect.jvm.internal.impl.descriptors.Modality.Companion.convertFromFlags(jClass.isSealed(), jClass.isSealed() || jClass.isAbstract() || jClass.isInterface(), !jClass.isFinal());
        }
        this.modality = modalityConvertFromFlags;
        this.visibility = jClass.getVisibility();
        this.isInner = (jClass.getOuterClass() == null || jClass.isStatic()) ? false : true;
        this.typeConstructor = new kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor.LazyJavaClassTypeConstructor();
        kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope lazyJavaClassMemberScope = new kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope(lazyJavaResolverContextChildForClassOrPackage$default, lazyJavaClassDescriptor, jClass, classDescriptor != null, null, 16, null);
        this.unsubstitutedMemberScope = lazyJavaClassMemberScope;
        this.scopeHolder = kotlin.reflect.jvm.internal.impl.descriptors.ScopesHolderForClass.Companion.create(lazyJavaClassDescriptor, lazyJavaResolverContextChildForClassOrPackage$default.getStorageManager(), lazyJavaResolverContextChildForClassOrPackage$default.getComponents().getKotlinTypeChecker().getKotlinTypeRefiner(), new kotlin.jvm.functions.Function1(this) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor$$Lambda$1
            private final kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor.scopeHolder$lambda$3(this.arg$0, (kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner) obj);
            }
        });
        this.innerClassesScope = new kotlin.reflect.jvm.internal.impl.resolve.scopes.InnerClassesScopeWrapper(lazyJavaClassMemberScope);
        this.staticScope = new kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticClassScope(lazyJavaResolverContextChildForClassOrPackage$default, jClass, this);
        this.annotations = kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotationsKt.resolveAnnotations(lazyJavaResolverContextChildForClassOrPackage$default, jClass);
        this.declaredParameters = lazyJavaResolverContextChildForClassOrPackage$default.getStorageManager().createLazyValue(new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor$$Lambda$2
            private final kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor.declaredParameters$lambda$5(this.arg$0);
            }
        });
    }

    /* JADX INFO: compiled from: LazyJavaClassDescriptor.kt */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final java.util.List<kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation> getModuleAnnotations() {
        return (java.util.List) this.moduleAnnotations$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.util.List moduleAnnotations_delegate$lambda$2(kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor lazyJavaClassDescriptor) {
        kotlin.reflect.jvm.internal.impl.name.ClassId classId = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getClassId(lazyJavaClassDescriptor);
        if (classId != null) {
            return lazyJavaClassDescriptor.outerContext.getComponents().getJavaModuleResolver().getAnnotationsForModuleOwnerOfClass(classId);
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public kotlin.reflect.jvm.internal.impl.descriptors.ClassKind getKind() {
        return this.kind;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public kotlin.reflect.jvm.internal.impl.descriptors.Modality getModality() {
        return this.modality;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility
    public kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility getVisibility() {
        if (kotlin.jvm.internal.Intrinsics.areEqual(this.visibility, kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.PRIVATE) && this.jClass.getOuterClass() == null) {
            kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility descriptorVisibility = kotlin.reflect.jvm.internal.impl.load.java.JavaDescriptorVisibilities.PACKAGE_VISIBILITY;
            kotlin.jvm.internal.Intrinsics.checkNotNull(descriptorVisibility);
            return descriptorVisibility;
        }
        return kotlin.reflect.jvm.internal.impl.load.java.UtilsKt.toDescriptorVisibility(this.visibility);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
    public boolean isInner() {
        return this.isInner;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor
    public kotlin.reflect.jvm.internal.impl.types.TypeConstructor getTypeConstructor() {
        return this.typeConstructor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope scopeHolder$lambda$3(kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor lazyJavaClassDescriptor, kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner it) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(it, "it");
        return new kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope(lazyJavaClassDescriptor.c, lazyJavaClassDescriptor, lazyJavaClassDescriptor.jClass, lazyJavaClassDescriptor.additionalSupertypeClassDescriptor != null, lazyJavaClassDescriptor.unsubstitutedMemberScope);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleAwareClassDescriptor
    public kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope getUnsubstitutedMemberScope(kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner kotlinTypeRefiner) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return (kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope) this.scopeHolder.getScope(kotlinTypeRefiner);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope getUnsubstitutedInnerClassesScope() {
        return this.innerClassesScope;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope getStaticScope() {
        return this.staticScope;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope getUnsubstitutedMemberScope() {
        kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope unsubstitutedMemberScope = super.getUnsubstitutedMemberScope();
        kotlin.jvm.internal.Intrinsics.checkNotNull(unsubstitutedMemberScope, "null cannot be cast to non-null type org.jetbrains.kotlin.load.java.lazy.descriptors.LazyJavaClassMemberScope");
        return (kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope) unsubstitutedMemberScope;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor> getConstructors() {
        return this.unsubstitutedMemberScope.getConstructors$descriptors_jvm().invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations getAnnotations() {
        return this.annotations;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.util.List declaredParameters$lambda$5(kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor lazyJavaClassDescriptor) {
        java.util.List<kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter> typeParameters = lazyJavaClassDescriptor.jClass.getTypeParameters();
        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(typeParameters, 10));
        for (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter javaTypeParameter : typeParameters) {
            kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor typeParameterDescriptorResolveTypeParameter = lazyJavaClassDescriptor.c.getTypeParameterResolver().resolveTypeParameter(javaTypeParameter);
            if (typeParameterDescriptorResolveTypeParameter == null) {
                throw new java.lang.AssertionError("Parameter " + javaTypeParameter + " surely belongs to class " + lazyJavaClassDescriptor.jClass + ", so it must be resolved");
            }
            arrayList.add(typeParameterDescriptorResolveTypeParameter);
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
    public java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> getDeclaredTypeParameters() {
        return this.declaredParameters.invoke();
    }

    public java.lang.String toString() {
        return "Lazy Java class " + kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getFqNameUnsafe(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: LazyJavaClassDescriptor.kt */
    final class LazyJavaClassTypeConstructor extends kotlin.reflect.jvm.internal.impl.types.AbstractClassTypeConstructor {
        private final kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue<java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor>> parameters;

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public boolean isDenotable() {
            return true;
        }

        public LazyJavaClassTypeConstructor() {
            super(kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor.this.c.getStorageManager());
            this.parameters = kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor.this.c.getStorageManager().createLazyValue(new kotlin.jvm.functions.Function0(kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor.this) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor$LazyJavaClassTypeConstructor$$Lambda$0
                private final kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor arg$0;

                {
                    this.arg$0 = lazyJavaClassDescriptor;
                }

                @Override // kotlin.jvm.functions.Function0
                public java.lang.Object invoke() {
                    return kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor.LazyJavaClassTypeConstructor.parameters$lambda$0(this.arg$0);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final java.util.List parameters$lambda$0(kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor lazyJavaClassDescriptor) {
            return kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt.computeConstructorTypeParameters(lazyJavaClassDescriptor);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> getParameters() {
            return this.parameters.invoke();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
        protected java.util.Collection<kotlin.reflect.jvm.internal.impl.types.KotlinType> computeSupertypes() {
            java.util.Collection<kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType> supertypes = kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor.this.getJClass().getSupertypes();
            java.util.ArrayList arrayList = new java.util.ArrayList(supertypes.size());
            java.util.ArrayList arrayList2 = new java.util.ArrayList(0);
            kotlin.reflect.jvm.internal.impl.types.KotlinType purelyImplementedSupertype = getPurelyImplementedSupertype();
            java.util.Iterator<kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType> it = supertypes.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType next = it.next();
                kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinTypeEnhanceSuperType = kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor.this.c.getComponents().getSignatureEnhancement().enhanceSuperType(kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor.this.c.getTypeResolver().transformJavaType(next, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributesKt.toAttributes$default(kotlin.reflect.jvm.internal.impl.types.TypeUsage.SUPERTYPE, false, false, null, 7, null)), kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor.this.c);
                if (kotlinTypeEnhanceSuperType.getConstructor().mo1835getDeclarationDescriptor() instanceof kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses.MockClassDescriptor) {
                    arrayList2.add(next);
                }
                if (!kotlin.jvm.internal.Intrinsics.areEqual(kotlinTypeEnhanceSuperType.getConstructor(), purelyImplementedSupertype != null ? purelyImplementedSupertype.getConstructor() : null) && !kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isAnyOrNullableAny(kotlinTypeEnhanceSuperType)) {
                    arrayList.add(kotlinTypeEnhanceSuperType);
                }
            }
            java.util.ArrayList arrayList3 = arrayList;
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor = kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor.this.additionalSupertypeClassDescriptor;
            kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(arrayList3, classDescriptor != null ? kotlin.reflect.jvm.internal.impl.builtins.jvm.MappingUtilKt.createMappedTypeParametersSubstitution(classDescriptor, kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor.this).buildSubstitutor().substitute(classDescriptor.getDefaultType(), kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT) : null);
            kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(arrayList3, purelyImplementedSupertype);
            if (!arrayList2.isEmpty()) {
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter errorReporter = kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor.this.c.getComponents().getErrorReporter();
                kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptorMo1835getDeclarationDescriptor = mo1835getDeclarationDescriptor();
                java.util.ArrayList<kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType> arrayList4 = arrayList2;
                java.util.ArrayList arrayList5 = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(arrayList4, 10));
                for (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType javaType : arrayList4) {
                    kotlin.jvm.internal.Intrinsics.checkNotNull(javaType, "null cannot be cast to non-null type org.jetbrains.kotlin.load.java.structure.JavaClassifierType");
                    arrayList5.add(((kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType) javaType).getPresentableText());
                }
                errorReporter.reportIncompleteHierarchy(classDescriptorMo1835getDeclarationDescriptor, arrayList5);
            }
            return !arrayList3.isEmpty() ? kotlin.collections.CollectionsKt.toList(arrayList) : kotlin.collections.CollectionsKt.listOf(kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor.this.c.getModule().getBuiltIns().getAnyType());
        }

        private final kotlin.reflect.jvm.internal.impl.types.KotlinType getPurelyImplementedSupertype() {
            kotlin.reflect.jvm.internal.impl.name.FqName purelyImplementedInterface;
            java.util.ArrayList arrayList;
            kotlin.reflect.jvm.internal.impl.name.FqName purelyImplementsFqNameFromAnnotation = getPurelyImplementsFqNameFromAnnotation();
            if (purelyImplementsFqNameFromAnnotation == null || purelyImplementsFqNameFromAnnotation.isRoot() || !purelyImplementsFqNameFromAnnotation.startsWith(kotlin.reflect.jvm.internal.impl.builtins.StandardNames.BUILT_INS_PACKAGE_NAME)) {
                purelyImplementsFqNameFromAnnotation = null;
            }
            if (purelyImplementsFqNameFromAnnotation == null) {
                purelyImplementedInterface = kotlin.reflect.jvm.internal.impl.load.java.FakePureImplementationsProvider.INSTANCE.getPurelyImplementedInterface(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getFqNameSafe(kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor.this));
                if (purelyImplementedInterface == null) {
                    return null;
                }
            } else {
                purelyImplementedInterface = purelyImplementsFqNameFromAnnotation;
            }
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptorResolveTopLevelClass = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.resolveTopLevelClass(kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor.this.c.getModule(), purelyImplementedInterface, kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation.FROM_JAVA_LOADER);
            if (classDescriptorResolveTopLevelClass == null) {
                return null;
            }
            int size = classDescriptorResolveTopLevelClass.getTypeConstructor().getParameters().size();
            java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> parameters = kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor.this.getTypeConstructor().getParameters();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(parameters, "getParameters(...)");
            int size2 = parameters.size();
            if (size2 == size) {
                java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> list = parameters;
                java.util.ArrayList arrayList2 = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(list, 10));
                java.util.Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList2.add(new kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl(kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT, ((kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) it.next()).getDefaultType()));
                }
                arrayList = arrayList2;
            } else {
                if (size2 != 1 || size <= 1 || purelyImplementsFqNameFromAnnotation != null) {
                    return null;
                }
                kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl typeProjectionImpl = new kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl(kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT, ((kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) kotlin.collections.CollectionsKt.single((java.util.List) parameters)).getDefaultType());
                kotlin.ranges.IntRange intRange = new kotlin.ranges.IntRange(1, size);
                java.util.ArrayList arrayList3 = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(intRange, 10));
                java.util.Iterator<java.lang.Integer> it2 = intRange.iterator();
                while (it2.hasNext()) {
                    ((kotlin.collections.IntIterator) it2).nextInt();
                    arrayList3.add(typeProjectionImpl);
                }
                arrayList = arrayList3;
            }
            return kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.simpleNotNullType(kotlin.reflect.jvm.internal.impl.types.TypeAttributes.Companion.getEmpty(), classDescriptorResolveTopLevelClass, arrayList);
        }

        private final kotlin.reflect.jvm.internal.impl.name.FqName getPurelyImplementsFqNameFromAnnotation() {
            java.lang.String value;
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations annotations = kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor.this.getAnnotations();
            kotlin.reflect.jvm.internal.impl.name.FqName PURELY_IMPLEMENTS_ANNOTATION = kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames.PURELY_IMPLEMENTS_ANNOTATION;
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(PURELY_IMPLEMENTS_ANNOTATION, "PURELY_IMPLEMENTS_ANNOTATION");
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor annotationDescriptorMo1826findAnnotation = annotations.mo1826findAnnotation(PURELY_IMPLEMENTS_ANNOTATION);
            if (annotationDescriptorMo1826findAnnotation == null) {
                return null;
            }
            java.lang.Object objSingleOrNull = kotlin.collections.CollectionsKt.singleOrNull(annotationDescriptorMo1826findAnnotation.getAllValueArguments().values());
            kotlin.reflect.jvm.internal.impl.resolve.constants.StringValue stringValue = objSingleOrNull instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.StringValue ? (kotlin.reflect.jvm.internal.impl.resolve.constants.StringValue) objSingleOrNull : null;
            if (stringValue == null || (value = stringValue.getValue()) == null || !kotlin.reflect.jvm.internal.impl.name.FqNamesUtilKt.isValidJavaFqName(value)) {
                return null;
            }
            return new kotlin.reflect.jvm.internal.impl.name.FqName(value);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
        protected kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker getSupertypeLoopChecker() {
            return kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor.this.c.getComponents().getSupertypeLoopChecker();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractClassTypeConstructor, kotlin.reflect.jvm.internal.impl.types.ClassifierBasedTypeConstructor, kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        /* JADX INFO: renamed from: getDeclarationDescriptor */
        public kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor mo1835getDeclarationDescriptor() {
            return kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor.this;
        }

        public java.lang.String toString() {
            java.lang.String strAsString = kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor.this.getName().asString();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strAsString, "asString(...)");
            return strAsString;
        }
    }

    public final kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor copy$descriptors_jvm(kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache javaResolverCache, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(javaResolverCache, "javaResolverCache");
        kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext lazyJavaResolverContext = this.c;
        kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext lazyJavaResolverContextReplaceComponents = kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt.replaceComponents(lazyJavaResolverContext, lazyJavaResolverContext.getComponents().replace(javaResolverCache));
        kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor containingDeclaration = getContainingDeclaration();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(containingDeclaration, "getContainingDeclaration(...)");
        return new kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor(lazyJavaResolverContextReplaceComponents, containingDeclaration, this.jClass, classDescriptor);
    }
}
