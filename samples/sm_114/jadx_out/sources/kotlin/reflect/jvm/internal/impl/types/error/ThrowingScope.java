package kotlin.reflect.jvm.internal.impl.types.error;

/* JADX INFO: compiled from: ThrowingScope.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ThrowingScope extends kotlin.reflect.jvm.internal.impl.types.error.ErrorScope {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThrowingScope(kotlin.reflect.jvm.internal.impl.types.error.ErrorScopeKind kind, java.lang.String... formatParams) {
        super(kind, (java.lang.String[]) java.util.Arrays.copyOf(formatParams, formatParams.length));
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kind, "kind");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(formatParams, "formatParams");
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.error.ErrorScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* JADX INFO: renamed from: getContributedClassifier */
    public kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor mo1837getContributedClassifier(kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation location) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(location, "location");
        throw new java.lang.IllegalStateException(getDebugMessage() + ", required name: " + name);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.error.ErrorScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public java.util.Set<kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor> getContributedVariables(kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation location) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(location, "location");
        throw new java.lang.IllegalStateException(getDebugMessage() + ", required name: " + name);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.error.ErrorScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public java.util.Set<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> getContributedFunctions(kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation location) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(location, "location");
        throw new java.lang.IllegalStateException(getDebugMessage() + ", required name: " + name);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.error.ErrorScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor> getContributedDescriptors(kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter kindFilter, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.name.Name, java.lang.Boolean> nameFilter) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kindFilter, "kindFilter");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(nameFilter, "nameFilter");
        throw new java.lang.IllegalStateException(getDebugMessage());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.error.ErrorScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> getFunctionNames() {
        throw new java.lang.IllegalStateException();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.error.ErrorScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> getVariableNames() {
        throw new java.lang.IllegalStateException();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.error.ErrorScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> getClassifierNames() {
        throw new java.lang.IllegalStateException();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.error.ErrorScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* JADX INFO: renamed from: recordLookup, reason: merged with bridge method [inline-methods] */
    public java.lang.Void mo1841recordLookup(kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation location) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(location, "location");
        throw new java.lang.IllegalStateException();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.error.ErrorScope
    public java.lang.String toString() {
        return "ThrowingScope{" + getDebugMessage() + com.taobao.weex.el.parse.Operators.BLOCK_END;
    }
}
