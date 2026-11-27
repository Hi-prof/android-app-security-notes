package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

/* JADX INFO: compiled from: LazyJavaPackageScope.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class LazyJavaPackageScope extends kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticScope {
    private final kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable<kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope.FindClassRequest, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor> classes;
    private final kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage jPackage;
    private final kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue<java.util.Set<java.lang.String>> knownClassNamesInPackage;
    private final kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment ownerDescriptor;

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected void computeNonDeclaredFunctions(java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> result, kotlin.reflect.jvm.internal.impl.name.Name name) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(result, "result");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment getOwnerDescriptor() {
        return this.ownerDescriptor;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaPackageScope(final kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext c, kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage jPackage, kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment ownerDescriptor) {
        super(c);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(c, "c");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(jPackage, "jPackage");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(ownerDescriptor, "ownerDescriptor");
        this.jPackage = jPackage;
        this.ownerDescriptor = ownerDescriptor;
        this.knownClassNamesInPackage = c.getStorageManager().createNullableLazyValue(new kotlin.jvm.functions.Function0(c, this) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope$$Lambda$0
            private final kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext arg$0;
            private final kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope arg$1;

            {
                this.arg$0 = c;
                this.arg$1 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope.knownClassNamesInPackage$lambda$0(this.arg$0, this.arg$1);
            }
        });
        this.classes = c.getStorageManager().createMemoizedFunctionWithNullableValues(new kotlin.jvm.functions.Function1(this, c) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope$$Lambda$1
            private final kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope arg$0;
            private final kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext arg$1;

            {
                this.arg$0 = this;
                this.arg$1 = c;
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope.classes$lambda$1(this.arg$0, this.arg$1, (kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope.FindClassRequest) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.util.Set knownClassNamesInPackage$lambda$0(kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext lazyJavaResolverContext, kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope lazyJavaPackageScope) {
        return lazyJavaResolverContext.getComponents().getFinder().knownClassNamesInPackage(lazyJavaPackageScope.getOwnerDescriptor().getFqName());
    }

    private final kotlin.reflect.jvm.internal.impl.metadata.deserialization.MetadataVersion getMetadataVersion() {
        return getC().getComponents().getDeserializedDescriptorResolver().getComponents().getConfiguration().getMetadataVersion();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classes$lambda$1(kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope lazyJavaPackageScope, kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext lazyJavaResolverContext, kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope.FindClassRequest request) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(request, "request");
        kotlin.reflect.jvm.internal.impl.name.ClassId classId = new kotlin.reflect.jvm.internal.impl.name.ClassId(lazyJavaPackageScope.getOwnerDescriptor().getFqName(), request.getName());
        kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder.Result resultFindKotlinClassOrContent = request.getJavaClass() != null ? lazyJavaResolverContext.getComponents().getKotlinClassFinder().findKotlinClassOrContent(request.getJavaClass(), lazyJavaPackageScope.getMetadataVersion()) : lazyJavaResolverContext.getComponents().getKotlinClassFinder().findKotlinClassOrContent(classId, lazyJavaPackageScope.getMetadataVersion());
        kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor lazyJavaClassDescriptor = null;
        kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass kotlinJvmBinaryClass = resultFindKotlinClassOrContent != null ? resultFindKotlinClassOrContent.toKotlinJvmBinaryClass() : null;
        kotlin.reflect.jvm.internal.impl.name.ClassId classId2 = kotlinJvmBinaryClass != null ? kotlinJvmBinaryClass.getClassId() : null;
        if (classId2 != null && (classId2.isNestedClass() || classId2.isLocal())) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope.KotlinClassLookupResult kotlinClassLookupResultResolveKotlinBinaryClass = lazyJavaPackageScope.resolveKotlinBinaryClass(kotlinJvmBinaryClass);
        if (kotlinClassLookupResultResolveKotlinBinaryClass instanceof kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope.KotlinClassLookupResult.Found) {
            return ((kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope.KotlinClassLookupResult.Found) kotlinClassLookupResultResolveKotlinBinaryClass).getDescriptor();
        }
        if (kotlinClassLookupResultResolveKotlinBinaryClass instanceof kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope.KotlinClassLookupResult.SyntheticClass) {
            return null;
        }
        if (!(kotlinClassLookupResultResolveKotlinBinaryClass instanceof kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope.KotlinClassLookupResult.NotFound)) {
            throw new kotlin.NoWhenBranchMatchedException();
        }
        kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass javaClass = request.getJavaClass();
        if (javaClass == null) {
            kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder finder = lazyJavaResolverContext.getComponents().getFinder();
            kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder.Result.ClassFileContent classFileContent = resultFindKotlinClassOrContent instanceof kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder.Result.ClassFileContent ? (kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder.Result.ClassFileContent) resultFindKotlinClassOrContent : null;
            javaClass = finder.findClass(new kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder.Request(classId, classFileContent != null ? classFileContent.getContent() : null, null, 4, null));
        }
        kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass javaClass2 = javaClass;
        if ((javaClass2 != null ? javaClass2.getLightClassOriginKind() : null) != kotlin.reflect.jvm.internal.impl.load.java.structure.LightClassOriginKind.BINARY) {
            kotlin.reflect.jvm.internal.impl.name.FqName fqName = javaClass2 != null ? javaClass2.getFqName() : null;
            if (fqName != null && !fqName.isRoot() && kotlin.jvm.internal.Intrinsics.areEqual(fqName.parent(), lazyJavaPackageScope.getOwnerDescriptor().getFqName())) {
                kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor lazyJavaClassDescriptor2 = new kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor(lazyJavaResolverContext, lazyJavaPackageScope.getOwnerDescriptor(), javaClass2, null, 8, null);
                lazyJavaResolverContext.getComponents().getJavaClassesTracker().reportClass(lazyJavaClassDescriptor2);
                lazyJavaClassDescriptor = lazyJavaClassDescriptor2;
            }
            return lazyJavaClassDescriptor;
        }
        throw new java.lang.IllegalStateException("Couldn't find kotlin binary class for light class created by kotlin binary file\nJavaClass: " + javaClass2 + "\nClassId: " + classId + "\nfindKotlinClass(JavaClass) = " + kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinderKt.findKotlinClass(lazyJavaResolverContext.getComponents().getKotlinClassFinder(), javaClass2, lazyJavaPackageScope.getMetadataVersion()) + "\nfindKotlinClass(ClassId) = " + kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinderKt.findKotlinClass(lazyJavaResolverContext.getComponents().getKotlinClassFinder(), classId, lazyJavaPackageScope.getMetadataVersion()) + '\n');
    }

    /* JADX INFO: compiled from: LazyJavaPackageScope.kt */
    private static abstract class KotlinClassLookupResult {
        public /* synthetic */ KotlinClassLookupResult(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: LazyJavaPackageScope.kt */
        public static final class Found extends kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope.KotlinClassLookupResult {
            private final kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor descriptor;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Found(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor descriptor) {
                super(null);
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(descriptor, "descriptor");
                this.descriptor = descriptor;
            }

            public final kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor getDescriptor() {
                return this.descriptor;
            }
        }

        private KotlinClassLookupResult() {
        }

        /* JADX INFO: compiled from: LazyJavaPackageScope.kt */
        public static final class NotFound extends kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope.KotlinClassLookupResult {
            public static final kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope.KotlinClassLookupResult.NotFound INSTANCE = new kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope.KotlinClassLookupResult.NotFound();

            private NotFound() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: LazyJavaPackageScope.kt */
        public static final class SyntheticClass extends kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope.KotlinClassLookupResult {
            public static final kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope.KotlinClassLookupResult.SyntheticClass INSTANCE = new kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope.KotlinClassLookupResult.SyntheticClass();

            private SyntheticClass() {
                super(null);
            }
        }
    }

    private final kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope.KotlinClassLookupResult resolveKotlinBinaryClass(kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        if (kotlinJvmBinaryClass == null) {
            return kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope.KotlinClassLookupResult.NotFound.INSTANCE;
        }
        if (kotlinJvmBinaryClass.getClassHeader().getKind() == kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader.Kind.CLASS) {
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptorResolveClass = getC().getComponents().getDeserializedDescriptorResolver().resolveClass(kotlinJvmBinaryClass);
            return classDescriptorResolveClass != null ? new kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope.KotlinClassLookupResult.Found(classDescriptorResolveClass) : kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope.KotlinClassLookupResult.NotFound.INSTANCE;
        }
        return kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope.KotlinClassLookupResult.SyntheticClass.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: LazyJavaPackageScope.kt */
    static final class FindClassRequest {
        private final kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass javaClass;
        private final kotlin.reflect.jvm.internal.impl.name.Name name;

        public FindClassRequest(kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass javaClass) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
            this.name = name;
            this.javaClass = javaClass;
        }

        public final kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass getJavaClass() {
            return this.javaClass;
        }

        public final kotlin.reflect.jvm.internal.impl.name.Name getName() {
            return this.name;
        }

        public boolean equals(java.lang.Object obj) {
            return (obj instanceof kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope.FindClassRequest) && kotlin.jvm.internal.Intrinsics.areEqual(this.name, ((kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope.FindClassRequest) obj).name);
        }

        public int hashCode() {
            return this.name.hashCode();
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* JADX INFO: renamed from: getContributedClassifier */
    public kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor mo1837getContributedClassifier(kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation location) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(location, "location");
        return findClassifier(name, null);
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor findClassifier(kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass javaClass) {
        if (!kotlin.reflect.jvm.internal.impl.name.SpecialNames.INSTANCE.isSafeIdentifier(name)) {
            return null;
        }
        java.util.Set<java.lang.String> setInvoke = this.knownClassNamesInPackage.invoke();
        if (javaClass != null || setInvoke == null || setInvoke.contains(name.asString())) {
            return this.classes.invoke2(new kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope.FindClassRequest(name, javaClass));
        }
        return null;
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor findClassifierByJavaClass$descriptors_jvm(kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass javaClass) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(javaClass, "javaClass");
        return findClassifier(javaClass.getName(), javaClass);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor> getContributedVariables(kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation location) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(location, "location");
        return kotlin.collections.CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex computeMemberIndex() {
        return kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex.Empty.INSTANCE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> computeClassNames(kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter kindFilter, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.name.Name, java.lang.Boolean> function1) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kindFilter, "kindFilter");
        if (!kindFilter.acceptsKinds(kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter.Companion.getNON_SINGLETON_CLASSIFIERS_MASK())) {
            return kotlin.collections.SetsKt.emptySet();
        }
        java.util.Set<java.lang.String> setInvoke = this.knownClassNamesInPackage.invoke();
        if (setInvoke == null) {
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage javaPackage = this.jPackage;
            if (function1 == null) {
                function1 = kotlin.reflect.jvm.internal.impl.utils.FunctionsKt.alwaysTrue();
            }
            java.util.Collection<kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass> classes = javaPackage.getClasses(function1);
            java.util.LinkedHashSet linkedHashSet = new java.util.LinkedHashSet();
            for (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass javaClass : classes) {
                kotlin.reflect.jvm.internal.impl.name.Name name = javaClass.getLightClassOriginKind() == kotlin.reflect.jvm.internal.impl.load.java.structure.LightClassOriginKind.SOURCE ? null : javaClass.getName();
                if (name != null) {
                    linkedHashSet.add(name);
                }
            }
            return linkedHashSet;
        }
        java.util.HashSet hashSet = new java.util.HashSet();
        java.util.Iterator<T> it = setInvoke.iterator();
        while (it.hasNext()) {
            hashSet.add(kotlin.reflect.jvm.internal.impl.name.Name.identifier((java.lang.String) it.next()));
        }
        return hashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> computeFunctionNames(kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter kindFilter, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.name.Name, java.lang.Boolean> function1) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kindFilter, "kindFilter");
        return kotlin.collections.SetsKt.emptySet();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> computePropertyNames(kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter kindFilter, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.name.Name, java.lang.Boolean> function1) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kindFilter, "kindFilter");
        return kotlin.collections.SetsKt.emptySet();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor> getContributedDescriptors(kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter kindFilter, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.name.Name, java.lang.Boolean> nameFilter) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kindFilter, "kindFilter");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(nameFilter, "nameFilter");
        if (!kindFilter.acceptsKinds(kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter.Companion.getCLASSIFIERS_MASK() | kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter.Companion.getNON_SINGLETON_CLASSIFIERS_MASK())) {
            return kotlin.collections.CollectionsKt.emptyList();
        }
        java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor> collectionInvoke = getAllDescriptors().invoke();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.lang.Object obj : collectionInvoke) {
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor = (kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor) obj;
            if (declarationDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) {
                kotlin.reflect.jvm.internal.impl.name.Name name = ((kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) declarationDescriptor).getName();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                if (nameFilter.invoke2(name).booleanValue()) {
                    arrayList.add(obj);
                }
            }
        }
        return arrayList;
    }
}
