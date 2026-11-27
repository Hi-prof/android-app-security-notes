package kotlin.reflect.jvm.internal.impl.types.error;

/* JADX INFO: compiled from: ErrorClassDescriptor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ErrorClassDescriptor extends kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorImpl {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ErrorClassDescriptor(kotlin.reflect.jvm.internal.impl.name.Name name) {
        super(kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils.INSTANCE.getErrorModule(), name, kotlin.reflect.jvm.internal.impl.descriptors.Modality.OPEN, kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.CLASS, kotlin.collections.CollectionsKt.emptyList(), kotlin.reflect.jvm.internal.impl.descriptors.SourceElement.NO_SOURCE, false, kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.NO_LOCKS);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl classConstructorDescriptorImplCreate = kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl.create(this, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion.getEMPTY(), true, kotlin.reflect.jvm.internal.impl.descriptors.SourceElement.NO_SOURCE);
        classConstructorDescriptorImplCreate.initialize(kotlin.collections.CollectionsKt.emptyList(), kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.INTERNAL);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(classConstructorDescriptorImplCreate, "apply(...)");
        kotlin.reflect.jvm.internal.impl.types.error.ErrorScope errorScopeCreateErrorScope = kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils.createErrorScope(kotlin.reflect.jvm.internal.impl.types.error.ErrorScopeKind.SCOPE_FOR_ERROR_CLASS, classConstructorDescriptorImplCreate.getName().toString(), "");
        kotlin.reflect.jvm.internal.impl.types.error.ErrorScope errorScope = errorScopeCreateErrorScope;
        classConstructorDescriptorImplCreate.setReturnType(new kotlin.reflect.jvm.internal.impl.types.error.ErrorType(kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils.INSTANCE.createErrorTypeConstructor(kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind.ERROR_CLASS, new java.lang.String[0]), errorScope, kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind.ERROR_CLASS, null, false, new java.lang.String[0], 24, null));
        initialize(errorScope, kotlin.collections.SetsKt.setOf(classConstructorDescriptorImplCreate), classConstructorDescriptorImplCreate);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor substitute(kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor substitutor) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(substitutor, "substitutor");
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleAwareClassDescriptor
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope getMemberScope(kotlin.reflect.jvm.internal.impl.types.TypeSubstitution typeSubstitution, kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner kotlinTypeRefiner) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeSubstitution, "typeSubstitution");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils.createErrorScope(kotlin.reflect.jvm.internal.impl.types.error.ErrorScopeKind.SCOPE_FOR_ERROR_CLASS, getName().toString(), typeSubstitution.toString());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorImpl
    public java.lang.String toString() {
        java.lang.String strAsString = getName().asString();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strAsString, "asString(...)");
        return strAsString;
    }
}
