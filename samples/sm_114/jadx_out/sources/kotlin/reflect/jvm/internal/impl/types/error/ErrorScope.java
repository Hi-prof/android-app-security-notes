package kotlin.reflect.jvm.internal.impl.types.error;

/* JADX INFO: compiled from: ErrorScope.kt */
/* JADX INFO: loaded from: classes2.dex */
public class ErrorScope implements kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope {
    private final java.lang.String debugMessage;
    private final kotlin.reflect.jvm.internal.impl.types.error.ErrorScopeKind kind;

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* JADX INFO: renamed from: recordLookup */
    public void mo1841recordLookup(kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation location) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(location, "location");
    }

    public ErrorScope(kotlin.reflect.jvm.internal.impl.types.error.ErrorScopeKind kind, java.lang.String... formatParams) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kind, "kind");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(formatParams, "formatParams");
        this.kind = kind;
        java.lang.String debugMessage = kind.getDebugMessage();
        java.lang.Object[] objArrCopyOf = java.util.Arrays.copyOf(formatParams, formatParams.length);
        java.lang.String str = java.lang.String.format(debugMessage, java.util.Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        this.debugMessage = str;
    }

    protected final java.lang.String getDebugMessage() {
        return this.debugMessage;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* JADX INFO: renamed from: getContributedClassifier */
    public kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor mo1837getContributedClassifier(kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation location) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(location, "location");
        java.lang.String str = java.lang.String.format(kotlin.reflect.jvm.internal.impl.types.error.ErrorEntity.ERROR_CLASS.getDebugText(), java.util.Arrays.copyOf(new java.lang.Object[]{name}, 1));
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        kotlin.reflect.jvm.internal.impl.name.Name nameSpecial = kotlin.reflect.jvm.internal.impl.name.Name.special(str);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameSpecial, "special(...)");
        return new kotlin.reflect.jvm.internal.impl.types.error.ErrorClassDescriptor(nameSpecial);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public java.util.Set<kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor> getContributedVariables(kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation location) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(location, "location");
        return kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils.INSTANCE.getErrorPropertyGroup();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public java.util.Set<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> getContributedFunctions(kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation location) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(location, "location");
        return kotlin.collections.SetsKt.setOf(new kotlin.reflect.jvm.internal.impl.types.error.ErrorFunctionDescriptor(kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils.INSTANCE.getErrorClass()));
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor> getContributedDescriptors(kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter kindFilter, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.name.Name, java.lang.Boolean> nameFilter) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kindFilter, "kindFilter");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(nameFilter, "nameFilter");
        return kotlin.collections.CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> getFunctionNames() {
        return kotlin.collections.SetsKt.emptySet();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> getVariableNames() {
        return kotlin.collections.SetsKt.emptySet();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> getClassifierNames() {
        return kotlin.collections.SetsKt.emptySet();
    }

    public java.lang.String toString() {
        return "ErrorScope{" + this.debugMessage + com.taobao.weex.el.parse.Operators.BLOCK_END;
    }
}
