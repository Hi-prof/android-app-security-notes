package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

/* JADX INFO: compiled from: RuntimeErrorReporter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RuntimeErrorReporter implements kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter {
    public static final kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeErrorReporter INSTANCE = new kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeErrorReporter();

    private RuntimeErrorReporter() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter
    public void reportIncompleteHierarchy(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor descriptor, java.util.List<java.lang.String> unresolvedSuperClasses) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(unresolvedSuperClasses, "unresolvedSuperClasses");
        throw new java.lang.IllegalStateException("Incomplete hierarchy for class " + descriptor.getName() + ", unresolved classes " + unresolvedSuperClasses);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter
    public void reportCannotInferVisibility(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor descriptor) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        throw new java.lang.IllegalStateException("Cannot infer visibility for " + descriptor);
    }
}
