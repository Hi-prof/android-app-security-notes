package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

/* JADX INFO: compiled from: DeserializedMemberDescriptor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DeserializedTypeAliasDescriptor extends kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeAliasDescriptor implements kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor {
    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource containerSource;
    private kotlin.reflect.jvm.internal.impl.types.SimpleType defaultTypeImpl;
    private kotlin.reflect.jvm.internal.impl.types.SimpleType expandedType;
    private final kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver nameResolver;
    private final kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeAlias proto;
    private java.util.List<? extends kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> typeConstructorParameters;
    private final kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable typeTable;
    private kotlin.reflect.jvm.internal.impl.types.SimpleType underlyingType;
    private final kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable versionRequirementTable;

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeAlias getProto() {
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

    /* JADX WARN: Illegal instructions before constructor call */
    public DeserializedTypeAliasDescriptor(kotlin.reflect.jvm.internal.impl.storage.StorageManager storageManager, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor containingDeclaration, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations annotations, kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility visibility, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeAlias proto, kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver nameResolver, kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable typeTable, kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable versionRequirementTable, kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource deserializedContainerSource) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(containingDeclaration, "containingDeclaration");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(annotations, "annotations");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(visibility, "visibility");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(proto, "proto");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(versionRequirementTable, "versionRequirementTable");
        kotlin.reflect.jvm.internal.impl.descriptors.SourceElement NO_SOURCE = kotlin.reflect.jvm.internal.impl.descriptors.SourceElement.NO_SOURCE;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(NO_SOURCE, "NO_SOURCE");
        super(storageManager, containingDeclaration, annotations, name, NO_SOURCE, visibility);
        this.proto = proto;
        this.nameResolver = nameResolver;
        this.typeTable = typeTable;
        this.versionRequirementTable = versionRequirementTable;
        this.containerSource = deserializedContainerSource;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor
    public kotlin.reflect.jvm.internal.impl.types.SimpleType getUnderlyingType() {
        kotlin.reflect.jvm.internal.impl.types.SimpleType simpleType = this.underlyingType;
        if (simpleType != null) {
            return simpleType;
        }
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("underlyingType");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor
    public kotlin.reflect.jvm.internal.impl.types.SimpleType getExpandedType() {
        kotlin.reflect.jvm.internal.impl.types.SimpleType simpleType = this.expandedType;
        if (simpleType != null) {
            return simpleType;
        }
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("expandedType");
        return null;
    }

    public final void initialize(java.util.List<? extends kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> declaredTypeParameters, kotlin.reflect.jvm.internal.impl.types.SimpleType underlyingType, kotlin.reflect.jvm.internal.impl.types.SimpleType expandedType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(declaredTypeParameters, "declaredTypeParameters");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(underlyingType, "underlyingType");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(expandedType, "expandedType");
        initialize(declaredTypeParameters);
        this.underlyingType = underlyingType;
        this.expandedType = expandedType;
        this.typeConstructorParameters = kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt.computeConstructorTypeParameters(this);
        this.defaultTypeImpl = computeDefaultType();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor
    public kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor getClassDescriptor() {
        if (kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt.isError(getExpandedType())) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptorMo1835getDeclarationDescriptor = getExpandedType().getConstructor().mo1835getDeclarationDescriptor();
        if (classifierDescriptorMo1835getDeclarationDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) {
            return (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) classifierDescriptorMo1835getDeclarationDescriptor;
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor
    public kotlin.reflect.jvm.internal.impl.types.SimpleType getDefaultType() {
        kotlin.reflect.jvm.internal.impl.types.SimpleType simpleType = this.defaultTypeImpl;
        if (simpleType != null) {
            return simpleType;
        }
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("defaultTypeImpl");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor substitute(kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor substitutor) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(substitutor, "substitutor");
        if (substitutor.isEmpty()) {
            return this;
        }
        kotlin.reflect.jvm.internal.impl.storage.StorageManager storageManager = getStorageManager();
        kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor containingDeclaration = getContainingDeclaration();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(containingDeclaration, "getContainingDeclaration(...)");
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations annotations = getAnnotations();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(annotations, "<get-annotations>(...)");
        kotlin.reflect.jvm.internal.impl.name.Name name = getName();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedTypeAliasDescriptor deserializedTypeAliasDescriptor = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedTypeAliasDescriptor(storageManager, containingDeclaration, annotations, name, getVisibility(), getProto(), getNameResolver(), getTypeTable(), getVersionRequirementTable(), getContainerSource());
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> declaredTypeParameters = getDeclaredTypeParameters();
        kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinTypeSafeSubstitute = substitutor.safeSubstitute(getUnderlyingType(), kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(kotlinTypeSafeSubstitute, "safeSubstitute(...)");
        kotlin.reflect.jvm.internal.impl.types.SimpleType simpleTypeAsSimpleType = kotlin.reflect.jvm.internal.impl.types.TypeSubstitutionKt.asSimpleType(kotlinTypeSafeSubstitute);
        kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinTypeSafeSubstitute2 = substitutor.safeSubstitute(getExpandedType(), kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(kotlinTypeSafeSubstitute2, "safeSubstitute(...)");
        deserializedTypeAliasDescriptor.initialize(declaredTypeParameters, simpleTypeAsSimpleType, kotlin.reflect.jvm.internal.impl.types.TypeSubstitutionKt.asSimpleType(kotlinTypeSafeSubstitute2));
        return deserializedTypeAliasDescriptor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeAliasDescriptor
    protected java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> getTypeConstructorTypeParameters() {
        java.util.List list = this.typeConstructorParameters;
        if (list != null) {
            return list;
        }
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("typeConstructorParameters");
        return null;
    }
}
