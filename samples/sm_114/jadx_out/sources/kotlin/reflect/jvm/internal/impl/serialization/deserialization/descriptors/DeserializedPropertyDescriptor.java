package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

/* JADX INFO: compiled from: DeserializedMemberDescriptor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DeserializedPropertyDescriptor extends kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl implements kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedCallableMemberDescriptor {
    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource containerSource;
    private final kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver nameResolver;
    private final kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property proto;
    private final kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable typeTable;
    private final kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable versionRequirementTable;

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property getProto() {
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
    public DeserializedPropertyDescriptor(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor containingDeclaration, kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor propertyDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations annotations, kotlin.reflect.jvm.internal.impl.descriptors.Modality modality, kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility visibility, boolean z, kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind kind, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property proto, kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver nameResolver, kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable typeTable, kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable versionRequirementTable, kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource deserializedContainerSource) {
        super(containingDeclaration, propertyDescriptor, annotations, modality, visibility, z, name, kind, kotlin.reflect.jvm.internal.impl.descriptors.SourceElement.NO_SOURCE, z2, z3, z6, false, z4, z5);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(containingDeclaration, "containingDeclaration");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(annotations, "annotations");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(modality, "modality");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(visibility, "visibility");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
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

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl
    protected kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl createSubstitutedCopy(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor newOwner, kotlin.reflect.jvm.internal.impl.descriptors.Modality newModality, kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility newVisibility, kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor propertyDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind kind, kotlin.reflect.jvm.internal.impl.name.Name newName, kotlin.reflect.jvm.internal.impl.descriptors.SourceElement source) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(newOwner, "newOwner");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(newModality, "newModality");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(newVisibility, "newVisibility");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kind, "kind");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(newName, "newName");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(source, "source");
        return new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor(newOwner, propertyDescriptor, getAnnotations(), newModality, newVisibility, isVar(), newName, kind, isLateInit(), isConst(), isExternal(), isDelegated(), isExpect(), getProto(), getNameResolver(), getTypeTable(), getVersionRequirementTable(), getContainerSource());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExternal() {
        java.lang.Boolean bool = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_EXTERNAL_PROPERTY.get(getProto().getFlags());
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bool, "get(...)");
        return bool.booleanValue();
    }
}
