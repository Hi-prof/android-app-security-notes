package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

/* JADX INFO: compiled from: context.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DeserializationContext {
    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents components;
    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource containerSource;
    private final kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor containingDeclaration;
    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer memberDeserializer;
    private final kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion metadataVersion;
    private final kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver nameResolver;
    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer typeDeserializer;
    private final kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable typeTable;
    private final kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable versionRequirementTable;

    public DeserializationContext(kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents components, kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver nameResolver, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor containingDeclaration, kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable typeTable, kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable versionRequirementTable, kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion metadataVersion, kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource deserializedContainerSource, kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer typeDeserializer, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter> typeParameters) {
        java.lang.String presentableString;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(components, "components");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(containingDeclaration, "containingDeclaration");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(versionRequirementTable, "versionRequirementTable");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(metadataVersion, "metadataVersion");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeParameters, "typeParameters");
        this.components = components;
        this.nameResolver = nameResolver;
        this.containingDeclaration = containingDeclaration;
        this.typeTable = typeTable;
        this.versionRequirementTable = versionRequirementTable;
        this.metadataVersion = metadataVersion;
        this.containerSource = deserializedContainerSource;
        this.typeDeserializer = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer(this, typeDeserializer, typeParameters, "Deserializer for \"" + containingDeclaration.getName() + '\"', (deserializedContainerSource == null || (presentableString = deserializedContainerSource.getPresentableString()) == null) ? "[container not found]" : presentableString);
        this.memberDeserializer = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer(this);
    }

    public final kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents getComponents() {
        return this.components;
    }

    public final kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver getNameResolver() {
        return this.nameResolver;
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor getContainingDeclaration() {
        return this.containingDeclaration;
    }

    public final kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable getTypeTable() {
        return this.typeTable;
    }

    public final kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable getVersionRequirementTable() {
        return this.versionRequirementTable;
    }

    public final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource getContainerSource() {
        return this.containerSource;
    }

    public final kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer getTypeDeserializer() {
        return this.typeDeserializer;
    }

    public final kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer getMemberDeserializer() {
        return this.memberDeserializer;
    }

    public final kotlin.reflect.jvm.internal.impl.storage.StorageManager getStorageManager() {
        return this.components.getStorageManager();
    }

    public static /* synthetic */ kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext childContext$default(kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext deserializationContext, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor, java.util.List list, kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver nameResolver, kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable typeTable, kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable versionRequirementTable, kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion binaryVersion, int i, java.lang.Object obj) {
        if ((i & 4) != 0) {
            nameResolver = deserializationContext.nameResolver;
        }
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver nameResolver2 = nameResolver;
        if ((i & 8) != 0) {
            typeTable = deserializationContext.typeTable;
        }
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable typeTable2 = typeTable;
        if ((i & 16) != 0) {
            versionRequirementTable = deserializationContext.versionRequirementTable;
        }
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable versionRequirementTable2 = versionRequirementTable;
        if ((i & 32) != 0) {
            binaryVersion = deserializationContext.metadataVersion;
        }
        return deserializationContext.childContext(declarationDescriptor, list, nameResolver2, typeTable2, versionRequirementTable2, binaryVersion);
    }

    public final kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext childContext(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor descriptor, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter> typeParameterProtos, kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver nameResolver, kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable typeTable, kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable versionRequirementTable, kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion metadataVersion) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeParameterProtos, "typeParameterProtos");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(versionRequirementTable, "versionRequirementTable");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(metadataVersion, "metadataVersion");
        return new kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext(this.components, nameResolver, descriptor, typeTable, kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionSpecificBehaviorKt.isVersionRequirementTableWrittenCorrectly(metadataVersion) ? versionRequirementTable : this.versionRequirementTable, metadataVersion, this.containerSource, this.typeDeserializer, typeParameterProtos);
    }
}
