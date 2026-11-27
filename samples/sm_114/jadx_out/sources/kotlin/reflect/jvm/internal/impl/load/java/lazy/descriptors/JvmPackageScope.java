package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

/* JADX INFO: compiled from: JvmPackageScope.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class JvmPackageScope implements kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope {
    static final /* synthetic */ kotlin.reflect.KProperty<java.lang.Object>[] $$delegatedProperties = {kotlin.jvm.internal.Reflection.property1(new kotlin.jvm.internal.PropertyReference1Impl(kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.JvmPackageScope.class, "kotlinScopes", "getKotlinScopes()[Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", 0))};
    private final kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext c;
    private final kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope javaScope;
    private final kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue kotlinScopes$delegate;
    private final kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment packageFragment;

    public JvmPackageScope(kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext c, kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage jPackage, kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment packageFragment) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(c, "c");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(jPackage, "jPackage");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(packageFragment, "packageFragment");
        this.c = c;
        this.packageFragment = packageFragment;
        this.javaScope = new kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope(c, jPackage, packageFragment);
        this.kotlinScopes$delegate = c.getStorageManager().createLazyValue(new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.JvmPackageScope$$Lambda$0
            private final kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.JvmPackageScope arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.JvmPackageScope.kotlinScopes_delegate$lambda$1(this.arg$0);
            }
        });
    }

    public final kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope getJavaScope$descriptors_jvm() {
        return this.javaScope;
    }

    private final kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope[] getKotlinScopes() {
        return (kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope[]) kotlin.reflect.jvm.internal.impl.storage.StorageKt.getValue(this.kotlinScopes$delegate, this, (kotlin.reflect.KProperty<?>) $$delegatedProperties[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope[] kotlinScopes_delegate$lambda$1(kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.JvmPackageScope jvmPackageScope) {
        java.util.Collection<kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass> collectionValues = jvmPackageScope.packageFragment.getBinaryClasses$descriptors_jvm().values();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator<T> it = collectionValues.iterator();
        while (it.hasNext()) {
            kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope memberScopeCreateKotlinPackagePartScope = jvmPackageScope.c.getComponents().getDeserializedDescriptorResolver().createKotlinPackagePartScope(jvmPackageScope.packageFragment, (kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass) it.next());
            if (memberScopeCreateKotlinPackagePartScope != null) {
                arrayList.add(memberScopeCreateKotlinPackagePartScope);
            }
        }
        return (kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope[]) kotlin.reflect.jvm.internal.impl.util.collectionUtils.ScopeUtilsKt.listOfNonEmptyScopes(arrayList).toArray(new kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* JADX INFO: renamed from: getContributedClassifier */
    public kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor mo1837getContributedClassifier(kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation location) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(location, "location");
        mo1841recordLookup(name, location);
        kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptorMo1837getContributedClassifier = this.javaScope.mo1837getContributedClassifier(name, location);
        if (classDescriptorMo1837getContributedClassifier != null) {
            return classDescriptorMo1837getContributedClassifier;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptor = null;
        for (kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope memberScope : getKotlinScopes()) {
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor contributedClassifier = memberScope.mo1837getContributedClassifier(name, location);
            if (contributedClassifier != null) {
                if (!(contributedClassifier instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters) || !((kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor) contributedClassifier).isExpect()) {
                    return contributedClassifier;
                }
                if (classifierDescriptor == null) {
                    classifierDescriptor = contributedClassifier;
                }
            }
        }
        return classifierDescriptor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor> getContributedVariables(kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation location) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(location, "location");
        mo1841recordLookup(name, location);
        kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope lazyJavaPackageScope = this.javaScope;
        kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope[] kotlinScopes = getKotlinScopes();
        java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor> contributedVariables = lazyJavaPackageScope.getContributedVariables(name, location);
        int length = kotlinScopes.length;
        int i = 0;
        java.util.Collection collection = contributedVariables;
        while (i < length) {
            java.util.Collection collectionConcat = kotlin.reflect.jvm.internal.impl.util.collectionUtils.ScopeUtilsKt.concat(collection, kotlinScopes[i].getContributedVariables(name, location));
            i++;
            collection = collectionConcat;
        }
        return collection == null ? kotlin.collections.SetsKt.emptySet() : collection;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> getContributedFunctions(kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation location) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(location, "location");
        mo1841recordLookup(name, location);
        kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope lazyJavaPackageScope = this.javaScope;
        kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope[] kotlinScopes = getKotlinScopes();
        java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> contributedFunctions = lazyJavaPackageScope.getContributedFunctions(name, location);
        int length = kotlinScopes.length;
        int i = 0;
        java.util.Collection collection = contributedFunctions;
        while (i < length) {
            java.util.Collection collectionConcat = kotlin.reflect.jvm.internal.impl.util.collectionUtils.ScopeUtilsKt.concat(collection, kotlinScopes[i].getContributedFunctions(name, location));
            i++;
            collection = collectionConcat;
        }
        return collection == null ? kotlin.collections.SetsKt.emptySet() : collection;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor> getContributedDescriptors(kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter kindFilter, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.name.Name, java.lang.Boolean> nameFilter) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kindFilter, "kindFilter");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(nameFilter, "nameFilter");
        kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope lazyJavaPackageScope = this.javaScope;
        kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope[] kotlinScopes = getKotlinScopes();
        java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor> contributedDescriptors = lazyJavaPackageScope.getContributedDescriptors(kindFilter, nameFilter);
        for (kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope memberScope : kotlinScopes) {
            contributedDescriptors = kotlin.reflect.jvm.internal.impl.util.collectionUtils.ScopeUtilsKt.concat(contributedDescriptors, memberScope.getContributedDescriptors(kindFilter, nameFilter));
        }
        return contributedDescriptors == null ? kotlin.collections.SetsKt.emptySet() : contributedDescriptors;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> getFunctionNames() {
        kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope[] kotlinScopes = getKotlinScopes();
        java.util.LinkedHashSet linkedHashSet = new java.util.LinkedHashSet();
        for (kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope memberScope : kotlinScopes) {
            kotlin.collections.CollectionsKt.addAll(linkedHashSet, memberScope.getFunctionNames());
        }
        java.util.LinkedHashSet linkedHashSet2 = linkedHashSet;
        linkedHashSet2.addAll(this.javaScope.getFunctionNames());
        return linkedHashSet2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> getVariableNames() {
        kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope[] kotlinScopes = getKotlinScopes();
        java.util.LinkedHashSet linkedHashSet = new java.util.LinkedHashSet();
        for (kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope memberScope : kotlinScopes) {
            kotlin.collections.CollectionsKt.addAll(linkedHashSet, memberScope.getVariableNames());
        }
        java.util.LinkedHashSet linkedHashSet2 = linkedHashSet;
        linkedHashSet2.addAll(this.javaScope.getVariableNames());
        return linkedHashSet2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> getClassifierNames() {
        java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> setFlatMapClassifierNamesOrNull = kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeKt.flatMapClassifierNamesOrNull(kotlin.collections.ArraysKt.asIterable(getKotlinScopes()));
        if (setFlatMapClassifierNamesOrNull == null) {
            return null;
        }
        setFlatMapClassifierNamesOrNull.addAll(this.javaScope.getClassifierNames());
        return setFlatMapClassifierNamesOrNull;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* JADX INFO: renamed from: recordLookup */
    public void mo1841recordLookup(kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation location) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(location, "location");
        kotlin.reflect.jvm.internal.impl.incremental.UtilsKt.record(this.c.getComponents().getLookupTracker(), location, this.packageFragment, name);
    }

    public java.lang.String toString() {
        return "scope for " + this.packageFragment;
    }
}
