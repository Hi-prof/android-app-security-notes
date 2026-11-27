package kotlin.reflect.jvm.internal.impl.descriptors;

/* JADX INFO: compiled from: typeParameterUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
final class CapturedTypeParameterDescriptor implements kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor {
    private final kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor;
    private final int declaredTypeParametersCount;
    private final kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor originalDescriptor;

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public <R, D> R accept(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
        return (R) this.originalDescriptor.accept(declarationDescriptorVisitor, d);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations getAnnotations() {
        return this.originalDescriptor.getAnnotations();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor
    public kotlin.reflect.jvm.internal.impl.types.SimpleType getDefaultType() {
        kotlin.reflect.jvm.internal.impl.types.SimpleType defaultType = this.originalDescriptor.getDefaultType();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(defaultType, "getDefaultType(...)");
        return defaultType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.Named
    public kotlin.reflect.jvm.internal.impl.name.Name getName() {
        kotlin.reflect.jvm.internal.impl.name.Name name = this.originalDescriptor.getName();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        return name;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource
    public kotlin.reflect.jvm.internal.impl.descriptors.SourceElement getSource() {
        kotlin.reflect.jvm.internal.impl.descriptors.SourceElement source = this.originalDescriptor.getSource();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(source, "getSource(...)");
        return source;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor
    public kotlin.reflect.jvm.internal.impl.storage.StorageManager getStorageManager() {
        kotlin.reflect.jvm.internal.impl.storage.StorageManager storageManager = this.originalDescriptor.getStorageManager();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(storageManager, "getStorageManager(...)");
        return storageManager;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor
    public kotlin.reflect.jvm.internal.impl.types.TypeConstructor getTypeConstructor() {
        kotlin.reflect.jvm.internal.impl.types.TypeConstructor typeConstructor = this.originalDescriptor.getTypeConstructor();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(typeConstructor, "getTypeConstructor(...)");
        return typeConstructor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor
    public java.util.List<kotlin.reflect.jvm.internal.impl.types.KotlinType> getUpperBounds() {
        java.util.List<kotlin.reflect.jvm.internal.impl.types.KotlinType> upperBounds = this.originalDescriptor.getUpperBounds();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(upperBounds, "getUpperBounds(...)");
        return upperBounds;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor
    public kotlin.reflect.jvm.internal.impl.types.Variance getVariance() {
        kotlin.reflect.jvm.internal.impl.types.Variance variance = this.originalDescriptor.getVariance();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(variance, "getVariance(...)");
        return variance;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor
    public boolean isCapturedFromOuterDeclaration() {
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor
    public boolean isReified() {
        return this.originalDescriptor.isReified();
    }

    public CapturedTypeParameterDescriptor(kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor originalDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor, int i) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(originalDescriptor, "originalDescriptor");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(declarationDescriptor, "declarationDescriptor");
        this.originalDescriptor = originalDescriptor;
        this.declarationDescriptor = declarationDescriptor;
        this.declaredTypeParametersCount = i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor getOriginal() {
        kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor original = this.originalDescriptor.getOriginal();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(original, "getOriginal(...)");
        return original;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor getContainingDeclaration() {
        return this.declarationDescriptor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor
    public int getIndex() {
        return this.declaredTypeParametersCount + this.originalDescriptor.getIndex();
    }

    public java.lang.String toString() {
        return this.originalDescriptor + "[inner-copy]";
    }
}
