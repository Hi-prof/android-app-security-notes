package kotlin.reflect.jvm.internal.impl.resolve.scopes;

/* JADX INFO: compiled from: ChainedMemberScope.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChainedMemberScope implements kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope {
    public static final kotlin.reflect.jvm.internal.impl.resolve.scopes.ChainedMemberScope.Companion Companion = new kotlin.reflect.jvm.internal.impl.resolve.scopes.ChainedMemberScope.Companion(null);
    private final java.lang.String debugName;
    private final kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope[] scopes;

    public /* synthetic */ ChainedMemberScope(java.lang.String str, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope[] memberScopeArr, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(str, memberScopeArr);
    }

    private ChainedMemberScope(java.lang.String str, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope[] memberScopeArr) {
        this.debugName = str;
        this.scopes = memberScopeArr;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* JADX INFO: renamed from: getContributedClassifier */
    public kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor mo1837getContributedClassifier(kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation location) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(location, "location");
        kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptor = null;
        for (kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope memberScope : this.scopes) {
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptorMo1837getContributedClassifier = memberScope.mo1837getContributedClassifier(name, location);
            if (classifierDescriptorMo1837getContributedClassifier != null) {
                if (!(classifierDescriptorMo1837getContributedClassifier instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters) || !((kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor) classifierDescriptorMo1837getContributedClassifier).isExpect()) {
                    return classifierDescriptorMo1837getContributedClassifier;
                }
                if (classifierDescriptor == null) {
                    classifierDescriptor = classifierDescriptorMo1837getContributedClassifier;
                }
            }
        }
        return classifierDescriptor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor> getContributedVariables(kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation location) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(location, "location");
        kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope[] memberScopeArr = this.scopes;
        int length = memberScopeArr.length;
        if (length == 0) {
            return kotlin.collections.CollectionsKt.emptyList();
        }
        if (length == 1) {
            return memberScopeArr[0].getContributedVariables(name, location);
        }
        java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor> collectionConcat = null;
        for (kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope memberScope : memberScopeArr) {
            collectionConcat = kotlin.reflect.jvm.internal.impl.util.collectionUtils.ScopeUtilsKt.concat(collectionConcat, memberScope.getContributedVariables(name, location));
        }
        return collectionConcat == null ? kotlin.collections.SetsKt.emptySet() : collectionConcat;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> getContributedFunctions(kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation location) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(location, "location");
        kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope[] memberScopeArr = this.scopes;
        int length = memberScopeArr.length;
        if (length == 0) {
            return kotlin.collections.CollectionsKt.emptyList();
        }
        if (length == 1) {
            return memberScopeArr[0].getContributedFunctions(name, location);
        }
        java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> collectionConcat = null;
        for (kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope memberScope : memberScopeArr) {
            collectionConcat = kotlin.reflect.jvm.internal.impl.util.collectionUtils.ScopeUtilsKt.concat(collectionConcat, memberScope.getContributedFunctions(name, location));
        }
        return collectionConcat == null ? kotlin.collections.SetsKt.emptySet() : collectionConcat;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor> getContributedDescriptors(kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter kindFilter, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.name.Name, java.lang.Boolean> nameFilter) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kindFilter, "kindFilter");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(nameFilter, "nameFilter");
        kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope[] memberScopeArr = this.scopes;
        int length = memberScopeArr.length;
        if (length == 0) {
            return kotlin.collections.CollectionsKt.emptyList();
        }
        if (length == 1) {
            return memberScopeArr[0].getContributedDescriptors(kindFilter, nameFilter);
        }
        java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor> collectionConcat = null;
        for (kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope memberScope : memberScopeArr) {
            collectionConcat = kotlin.reflect.jvm.internal.impl.util.collectionUtils.ScopeUtilsKt.concat(collectionConcat, memberScope.getContributedDescriptors(kindFilter, nameFilter));
        }
        return collectionConcat == null ? kotlin.collections.SetsKt.emptySet() : collectionConcat;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> getFunctionNames() {
        kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope[] memberScopeArr = this.scopes;
        java.util.LinkedHashSet linkedHashSet = new java.util.LinkedHashSet();
        for (kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope memberScope : memberScopeArr) {
            kotlin.collections.CollectionsKt.addAll(linkedHashSet, memberScope.getFunctionNames());
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> getVariableNames() {
        kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope[] memberScopeArr = this.scopes;
        java.util.LinkedHashSet linkedHashSet = new java.util.LinkedHashSet();
        for (kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope memberScope : memberScopeArr) {
            kotlin.collections.CollectionsKt.addAll(linkedHashSet, memberScope.getVariableNames());
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> getClassifierNames() {
        return kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeKt.flatMapClassifierNamesOrNull(kotlin.collections.ArraysKt.asIterable(this.scopes));
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* JADX INFO: renamed from: recordLookup */
    public void mo1841recordLookup(kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation location) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(location, "location");
        for (kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope memberScope : this.scopes) {
            memberScope.mo1841recordLookup(name, location);
        }
    }

    public java.lang.String toString() {
        return this.debugName;
    }

    /* JADX INFO: compiled from: ChainedMemberScope.kt */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope create(java.lang.String debugName, java.lang.Iterable<? extends kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope> scopes) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(debugName, "debugName");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(scopes, "scopes");
            kotlin.reflect.jvm.internal.impl.utils.SmartList smartList = new kotlin.reflect.jvm.internal.impl.utils.SmartList();
            for (kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope memberScope : scopes) {
                if (memberScope != kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope.Empty.INSTANCE) {
                    if (memberScope instanceof kotlin.reflect.jvm.internal.impl.resolve.scopes.ChainedMemberScope) {
                        kotlin.collections.CollectionsKt.addAll(smartList, ((kotlin.reflect.jvm.internal.impl.resolve.scopes.ChainedMemberScope) memberScope).scopes);
                    } else {
                        smartList.add(memberScope);
                    }
                }
            }
            return createOrSingle$descriptors(debugName, smartList);
        }

        public final kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope createOrSingle$descriptors(java.lang.String debugName, java.util.List<? extends kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope> scopes) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(debugName, "debugName");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(scopes, "scopes");
            int size = scopes.size();
            if (size == 0) {
                return kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope.Empty.INSTANCE;
            }
            if (size == 1) {
                return scopes.get(0);
            }
            return new kotlin.reflect.jvm.internal.impl.resolve.scopes.ChainedMemberScope(debugName, (kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope[]) scopes.toArray(new kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope[0]), null);
        }
    }
}
