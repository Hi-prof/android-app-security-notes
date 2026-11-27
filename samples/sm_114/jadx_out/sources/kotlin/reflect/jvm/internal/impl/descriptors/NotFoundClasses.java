package kotlin.reflect.jvm.internal.impl.descriptors;

/* JADX INFO: compiled from: NotFoundClasses.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NotFoundClasses {
    private final kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull<kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses.ClassRequest, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor> classes;
    private final kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor module;
    private final kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull<kotlin.reflect.jvm.internal.impl.name.FqName, kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor> packageFragments;
    private final kotlin.reflect.jvm.internal.impl.storage.StorageManager storageManager;

    public NotFoundClasses(kotlin.reflect.jvm.internal.impl.storage.StorageManager storageManager, kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor module) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(module, "module");
        this.storageManager = storageManager;
        this.module = module;
        this.packageFragments = storageManager.createMemoizedFunction(new kotlin.jvm.functions.Function1(this) { // from class: kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses$$Lambda$0
            private final kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses.packageFragments$lambda$0(this.arg$0, (kotlin.reflect.jvm.internal.impl.name.FqName) obj);
            }
        });
        this.classes = storageManager.createMemoizedFunction(new kotlin.jvm.functions.Function1(this) { // from class: kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses$$Lambda$1
            private final kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses.classes$lambda$2(this.arg$0, (kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses.ClassRequest) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: NotFoundClasses.kt */
    static final class ClassRequest {
        private final kotlin.reflect.jvm.internal.impl.name.ClassId classId;
        private final java.util.List<java.lang.Integer> typeParametersCount;

        public final kotlin.reflect.jvm.internal.impl.name.ClassId component1() {
            return this.classId;
        }

        public final java.util.List<java.lang.Integer> component2() {
            return this.typeParametersCount;
        }

        public boolean equals(java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses.ClassRequest)) {
                return false;
            }
            kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses.ClassRequest classRequest = (kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses.ClassRequest) obj;
            return kotlin.jvm.internal.Intrinsics.areEqual(this.classId, classRequest.classId) && kotlin.jvm.internal.Intrinsics.areEqual(this.typeParametersCount, classRequest.typeParametersCount);
        }

        public int hashCode() {
            return (this.classId.hashCode() * 31) + this.typeParametersCount.hashCode();
        }

        public java.lang.String toString() {
            return "ClassRequest(classId=" + this.classId + ", typeParametersCount=" + this.typeParametersCount + com.taobao.weex.el.parse.Operators.BRACKET_END;
        }

        public ClassRequest(kotlin.reflect.jvm.internal.impl.name.ClassId classId, java.util.List<java.lang.Integer> typeParametersCount) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(classId, "classId");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeParametersCount, "typeParametersCount");
            this.classId = classId;
            this.typeParametersCount = typeParametersCount;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor packageFragments$lambda$0(kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses notFoundClasses, kotlin.reflect.jvm.internal.impl.name.FqName fqName) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fqName, "fqName");
        return new kotlin.reflect.jvm.internal.impl.descriptors.impl.EmptyPackageFragmentDescriptor(notFoundClasses.module, fqName);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classes$lambda$2(kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses notFoundClasses, kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses.ClassRequest classRequest) {
        kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor packageFragmentDescriptorInvoke;
        kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(classRequest, "<destruct>");
        kotlin.reflect.jvm.internal.impl.name.ClassId classIdComponent1 = classRequest.component1();
        java.util.List<java.lang.Integer> listComponent2 = classRequest.component2();
        if (classIdComponent1.isLocal()) {
            throw new java.lang.UnsupportedOperationException("Unresolved local class: " + classIdComponent1);
        }
        kotlin.reflect.jvm.internal.impl.name.ClassId outerClassId = classIdComponent1.getOuterClassId();
        if (outerClassId != null && (classDescriptor = notFoundClasses.getClass(outerClassId, kotlin.collections.CollectionsKt.drop(listComponent2, 1))) != null) {
            packageFragmentDescriptorInvoke = classDescriptor;
        } else {
            packageFragmentDescriptorInvoke = notFoundClasses.packageFragments.invoke2(classIdComponent1.getPackageFqName());
        }
        boolean zIsNestedClass = classIdComponent1.isNestedClass();
        kotlin.reflect.jvm.internal.impl.storage.StorageManager storageManager = notFoundClasses.storageManager;
        kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor = packageFragmentDescriptorInvoke;
        kotlin.reflect.jvm.internal.impl.name.Name shortClassName = classIdComponent1.getShortClassName();
        java.lang.Integer num = (java.lang.Integer) kotlin.collections.CollectionsKt.firstOrNull((java.util.List) listComponent2);
        return new kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses.MockClassDescriptor(storageManager, declarationDescriptor, shortClassName, zIsNestedClass, num != null ? num.intValue() : 0);
    }

    /* JADX INFO: compiled from: NotFoundClasses.kt */
    public static final class MockClassDescriptor extends kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorBase {
        private final java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> declaredTypeParameters;
        private final boolean isInner;
        private final kotlin.reflect.jvm.internal.impl.types.ClassTypeConstructorImpl typeConstructor;

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

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorBase, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
        public boolean isExternal() {
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

        /* JADX WARN: Illegal instructions before constructor call */
        public MockClassDescriptor(kotlin.reflect.jvm.internal.impl.storage.StorageManager storageManager, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor container, kotlin.reflect.jvm.internal.impl.name.Name name, boolean z, int i) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(storageManager, "storageManager");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(container, "container");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
            kotlin.reflect.jvm.internal.impl.storage.StorageManager storageManager2 = storageManager;
            super(storageManager2, container, name, kotlin.reflect.jvm.internal.impl.descriptors.SourceElement.NO_SOURCE, false);
            this.isInner = z;
            kotlin.ranges.IntRange intRangeUntil = kotlin.ranges.RangesKt.until(0, i);
            java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(intRangeUntil, 10));
            java.util.Iterator<java.lang.Integer> it = intRangeUntil.iterator();
            while (it.hasNext()) {
                int iNextInt = ((kotlin.collections.IntIterator) it).nextInt();
                kotlin.reflect.jvm.internal.impl.storage.StorageManager storageManager3 = storageManager2;
                storageManager2 = storageManager3;
                arrayList.add(kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeParameterDescriptorImpl.createWithDefaultBound(this, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion.getEMPTY(), false, kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT, kotlin.reflect.jvm.internal.impl.name.Name.identifier("T" + iNextInt), iNextInt, storageManager3));
            }
            this.declaredTypeParameters = arrayList;
            this.typeConstructor = new kotlin.reflect.jvm.internal.impl.types.ClassTypeConstructorImpl(this, kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt.computeConstructorTypeParameters(this), kotlin.collections.SetsKt.setOf(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getModule(this).getBuiltIns().getAnyType()), storageManager2);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
        public kotlin.reflect.jvm.internal.impl.descriptors.ClassKind getKind() {
            return kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.CLASS;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
        public kotlin.reflect.jvm.internal.impl.descriptors.Modality getModality() {
            return kotlin.reflect.jvm.internal.impl.descriptors.Modality.FINAL;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility
        public kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility getVisibility() {
            kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility PUBLIC = kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.PUBLIC;
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(PUBLIC, "PUBLIC");
            return PUBLIC;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor
        public kotlin.reflect.jvm.internal.impl.types.ClassTypeConstructorImpl getTypeConstructor() {
            return this.typeConstructor;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
        public java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> getDeclaredTypeParameters() {
            return this.declaredTypeParameters;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
        public boolean isInner() {
            return this.isInner;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
        public kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations getAnnotations() {
            return kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion.getEMPTY();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleAwareClassDescriptor
        public kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope.Empty getUnsubstitutedMemberScope(kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner kotlinTypeRefiner) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
            return kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope.Empty.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
        public kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope.Empty getStaticScope() {
            return kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope.Empty.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
        public java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor> getConstructors() {
            return kotlin.collections.SetsKt.emptySet();
        }

        public java.lang.String toString() {
            return "class " + getName() + " (not found)";
        }
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor getClass(kotlin.reflect.jvm.internal.impl.name.ClassId classId, java.util.List<java.lang.Integer> typeParametersCount) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(classId, "classId");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeParametersCount, "typeParametersCount");
        return this.classes.invoke2(new kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses.ClassRequest(classId, typeParametersCount));
    }
}
