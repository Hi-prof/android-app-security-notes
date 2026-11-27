package kotlin.reflect.jvm.internal.impl.resolve.scopes;

/* JADX INFO: compiled from: MemberScopeImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class MemberScopeImpl implements kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope {
    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> getClassifierNames() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* JADX INFO: renamed from: getContributedClassifier */
    public kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor mo1837getContributedClassifier(kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation location) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(location, "location");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* JADX INFO: renamed from: recordLookup */
    public void mo1841recordLookup(kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation lookupLocation) {
        kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope.DefaultImpls.recordLookup(this, name, lookupLocation);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor> getContributedVariables(kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation location) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(location, "location");
        return kotlin.collections.CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> getContributedFunctions(kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation location) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(location, "location");
        return kotlin.collections.CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor> getContributedDescriptors(kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter kindFilter, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.name.Name, java.lang.Boolean> nameFilter) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kindFilter, "kindFilter");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(nameFilter, "nameFilter");
        return kotlin.collections.CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> getFunctionNames() {
        java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor> contributedDescriptors = getContributedDescriptors(kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter.FUNCTIONS, kotlin.reflect.jvm.internal.impl.utils.FunctionsKt.alwaysTrue());
        java.util.LinkedHashSet linkedHashSet = new java.util.LinkedHashSet();
        for (java.lang.Object obj : contributedDescriptors) {
            if (obj instanceof kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) {
                kotlin.reflect.jvm.internal.impl.name.Name name = ((kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) obj).getName();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                linkedHashSet.add(name);
            }
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> getVariableNames() {
        java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor> contributedDescriptors = getContributedDescriptors(kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter.VARIABLES, kotlin.reflect.jvm.internal.impl.utils.FunctionsKt.alwaysTrue());
        java.util.LinkedHashSet linkedHashSet = new java.util.LinkedHashSet();
        for (java.lang.Object obj : contributedDescriptors) {
            if (obj instanceof kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) {
                kotlin.reflect.jvm.internal.impl.name.Name name = ((kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) obj).getName();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                linkedHashSet.add(name);
            }
        }
        return linkedHashSet;
    }
}
