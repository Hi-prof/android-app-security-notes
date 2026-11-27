package kotlin.reflect.jvm.internal.impl.resolve.scopes;

/* JADX INFO: compiled from: InnerClassesScopeWrapper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class InnerClassesScopeWrapper extends kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl {
    private final kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope workerScope;

    public InnerClassesScopeWrapper(kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope workerScope) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(workerScope, "workerScope");
        this.workerScope = workerScope;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public /* bridge */ /* synthetic */ java.util.Collection getContributedDescriptors(kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter descriptorKindFilter, kotlin.jvm.functions.Function1 function1) {
        return getContributedDescriptors(descriptorKindFilter, (kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.name.Name, java.lang.Boolean>) function1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* JADX INFO: renamed from: getContributedClassifier */
    public kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor mo1837getContributedClassifier(kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation location) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(location, "location");
        kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor contributedClassifier = this.workerScope.mo1837getContributedClassifier(name, location);
        kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptor = null;
        if (contributedClassifier != null) {
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor = contributedClassifier instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor ? (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) contributedClassifier : null;
            if (classDescriptor != null) {
                classifierDescriptor = classDescriptor;
            } else {
                classifierDescriptor = (kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters) (contributedClassifier instanceof kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor ? (kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor) contributedClassifier : null);
            }
        }
        return classifierDescriptor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor> getContributedDescriptors(kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter kindFilter, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.name.Name, java.lang.Boolean> nameFilter) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kindFilter, "kindFilter");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(nameFilter, "nameFilter");
        kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter descriptorKindFilterRestrictedToKindsOrNull = kindFilter.restrictedToKindsOrNull(kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter.Companion.getCLASSIFIERS_MASK());
        if (descriptorKindFilterRestrictedToKindsOrNull == null) {
            return kotlin.collections.CollectionsKt.emptyList();
        }
        java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor> contributedDescriptors = this.workerScope.getContributedDescriptors(descriptorKindFilterRestrictedToKindsOrNull, nameFilter);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.lang.Object obj : contributedDescriptors) {
            if (obj instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> getFunctionNames() {
        return this.workerScope.getFunctionNames();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> getVariableNames() {
        return this.workerScope.getVariableNames();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> getClassifierNames() {
        return this.workerScope.getClassifierNames();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* JADX INFO: renamed from: recordLookup */
    public void mo1841recordLookup(kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation location) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(location, "location");
        this.workerScope.mo1841recordLookup(name, location);
    }

    public java.lang.String toString() {
        return "Classes from " + this.workerScope;
    }
}
