package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

/* JADX INFO: compiled from: DeserializedMemberDescriptor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DeserializedClassConstructorDescriptor extends kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl implements kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedCallableMemberDescriptor {
    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource containerSource;
    private final kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver nameResolver;
    private final kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Constructor proto;
    private final kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable typeTable;
    private final kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable versionRequirementTable;

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExternal() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isInline() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isSuspend() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isTailrec() {
        return false;
    }

    public /* synthetic */ DeserializedClassConstructorDescriptor(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor constructorDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations annotations, boolean z, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind kind, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Constructor constructor, kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver nameResolver, kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable typeTable, kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable versionRequirementTable, kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource deserializedContainerSource, kotlin.reflect.jvm.internal.impl.descriptors.SourceElement sourceElement, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(classDescriptor, constructorDescriptor, annotations, z, kind, constructor, nameResolver, typeTable, versionRequirementTable, deserializedContainerSource, (i & 1024) != 0 ? null : sourceElement);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Constructor getProto() {
        return this.proto;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    public kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver getNameResolver() {
        return this.nameResolver;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    public kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable getTypeTable() {
        return this.typeTable;
    }

    public kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable getVersionRequirementTable() {
        return this.versionRequirementTable;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    public kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource getContainerSource() {
        return this.containerSource;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeserializedClassConstructorDescriptor(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor containingDeclaration, kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor constructorDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations annotations, boolean z, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind kind, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Constructor proto, kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver nameResolver, kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable typeTable, kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable versionRequirementTable, kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource deserializedContainerSource, kotlin.reflect.jvm.internal.impl.descriptors.SourceElement sourceElement) {
        super(containingDeclaration, constructorDescriptor, annotations, z, kind, sourceElement == null ? kotlin.reflect.jvm.internal.impl.descriptors.SourceElement.NO_SOURCE : sourceElement);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(containingDeclaration, "containingDeclaration");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(annotations, "annotations");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kind, "kind");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(proto, "proto");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(versionRequirementTable, "versionRequirementTable");
        this.proto = proto;
        this.nameResolver = nameResolver;
        this.typeTable = typeTable;
        this.versionRequirementTable = versionRequirementTable;
        this.containerSource = deserializedContainerSource;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl
    public kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassConstructorDescriptor createSubstitutedCopy(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor newOwner, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor functionDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind kind, kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations annotations, kotlin.reflect.jvm.internal.impl.descriptors.SourceElement source) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(newOwner, "newOwner");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kind, "kind");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(annotations, "annotations");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(source, "source");
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassConstructorDescriptor deserializedClassConstructorDescriptor = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassConstructorDescriptor((kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) newOwner, (kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor) functionDescriptor, annotations, this.isPrimary, kind, getProto(), getNameResolver(), getTypeTable(), getVersionRequirementTable(), getContainerSource(), source);
        deserializedClassConstructorDescriptor.setHasStableParameterNames(hasStableParameterNames());
        return deserializedClassConstructorDescriptor;
    }
}
