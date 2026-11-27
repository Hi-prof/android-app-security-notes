package kotlin.reflect.jvm.internal.impl.types;

/* JADX INFO: compiled from: TypeSubstitution.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class IndexedParametersSubstitution extends kotlin.reflect.jvm.internal.impl.types.TypeSubstitution {
    private final boolean approximateContravariantCapturedTypes;
    private final kotlin.reflect.jvm.internal.impl.types.TypeProjection[] arguments;
    private final kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor[] parameters;

    public /* synthetic */ IndexedParametersSubstitution(kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor[] typeParameterDescriptorArr, kotlin.reflect.jvm.internal.impl.types.TypeProjection[] typeProjectionArr, boolean z, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(typeParameterDescriptorArr, typeProjectionArr, (i & 4) != 0 ? false : z);
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor[] getParameters() {
        return this.parameters;
    }

    public final kotlin.reflect.jvm.internal.impl.types.TypeProjection[] getArguments() {
        return this.arguments;
    }

    public IndexedParametersSubstitution(kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor[] parameters, kotlin.reflect.jvm.internal.impl.types.TypeProjection[] arguments, boolean z) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(parameters, "parameters");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(arguments, "arguments");
        this.parameters = parameters;
        this.arguments = arguments;
        this.approximateContravariantCapturedTypes = z;
        int length = parameters.length;
        int length2 = arguments.length;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public IndexedParametersSubstitution(java.util.List<? extends kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> parameters, java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.TypeProjection> argumentsList) {
        this((kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor[]) parameters.toArray(new kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor[0]), (kotlin.reflect.jvm.internal.impl.types.TypeProjection[]) argumentsList.toArray(new kotlin.reflect.jvm.internal.impl.types.TypeProjection[0]), false, 4, null);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(parameters, "parameters");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(argumentsList, "argumentsList");
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    public boolean isEmpty() {
        return this.arguments.length == 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    public boolean approximateContravariantCapturedTypes() {
        return this.approximateContravariantCapturedTypes;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    /* JADX INFO: renamed from: get */
    public kotlin.reflect.jvm.internal.impl.types.TypeProjection mo1840get(kotlin.reflect.jvm.internal.impl.types.KotlinType key) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(key, "key");
        kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptorMo1835getDeclarationDescriptor = key.getConstructor().mo1835getDeclarationDescriptor();
        kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor typeParameterDescriptor = classifierDescriptorMo1835getDeclarationDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor ? (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) classifierDescriptorMo1835getDeclarationDescriptor : null;
        if (typeParameterDescriptor == null) {
            return null;
        }
        int index = typeParameterDescriptor.getIndex();
        kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor[] typeParameterDescriptorArr = this.parameters;
        if (index >= typeParameterDescriptorArr.length || !kotlin.jvm.internal.Intrinsics.areEqual(typeParameterDescriptorArr[index].getTypeConstructor(), typeParameterDescriptor.getTypeConstructor())) {
            return null;
        }
        return this.arguments[index];
    }
}
