package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

/* JADX INFO: compiled from: signatureEnhancement.kt */
/* JADX INFO: loaded from: classes2.dex */
final class SignatureParts extends kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts<kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor> {
    private final kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType containerApplicabilityType;
    private final kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext containerContext;
    private final boolean isCovariant;
    private final boolean skipRawTypeArguments;
    private final kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated typeContainer;

    public /* synthetic */ SignatureParts(kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated annotated, boolean z, kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext lazyJavaResolverContext, kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType, boolean z2, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(annotated, z, lazyJavaResolverContext, annotationQualifierApplicabilityType, (i & 16) != 0 ? false : z2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public boolean isCovariant() {
        return this.isCovariant;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType getContainerApplicabilityType() {
        return this.containerApplicabilityType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public boolean getSkipRawTypeArguments() {
        return this.skipRawTypeArguments;
    }

    public SignatureParts(kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated annotated, boolean z, kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext containerContext, kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType containerApplicabilityType, boolean z2) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(containerContext, "containerContext");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(containerApplicabilityType, "containerApplicabilityType");
        this.typeContainer = annotated;
        this.isCovariant = z;
        this.containerContext = containerContext;
        this.containerApplicabilityType = containerApplicabilityType;
        this.skipRawTypeArguments = z2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public kotlin.reflect.jvm.internal.impl.load.java.AbstractAnnotationTypeQualifierResolver<kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor> getAnnotationTypeQualifierResolver() {
        return this.containerContext.getComponents().getAnnotationTypeQualifierResolver();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public boolean getEnableImprovementsInStrictMode() {
        return this.containerContext.getComponents().getSettings().getTypeEnhancementImprovementsInStrictMode();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public java.lang.Iterable<kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor> getContainerAnnotations() {
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations annotations;
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated annotated = this.typeContainer;
        return (annotated == null || (annotations = annotated.getAnnotations()) == null) ? kotlin.collections.CollectionsKt.emptyList() : annotations;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public kotlin.reflect.jvm.internal.impl.load.java.JavaTypeQualifiersByElementType getContainerDefaultTypeQualifiers() {
        return this.containerContext.getDefaultTypeQualifiers();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public boolean getContainerIsVarargParameter() {
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated annotated = this.typeContainer;
        return (annotated instanceof kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) && ((kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) annotated).getVarargElementType() != null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public kotlin.reflect.jvm.internal.impl.types.model.TypeSystemInferenceExtensionContext getTypeSystem() {
        return kotlin.reflect.jvm.internal.impl.types.checker.SimpleClassicTypeSystemContext.INSTANCE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public boolean forceWarning(kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor annotationDescriptor, kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker kotlinTypeMarker) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(annotationDescriptor, "<this>");
        if ((annotationDescriptor instanceof kotlin.reflect.jvm.internal.impl.load.java.descriptors.PossiblyExternalAnnotationDescriptor) && ((kotlin.reflect.jvm.internal.impl.load.java.descriptors.PossiblyExternalAnnotationDescriptor) annotationDescriptor).isIdeExternalAnnotation()) {
            return true;
        }
        if ((annotationDescriptor instanceof kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaAnnotationDescriptor) && !getEnableImprovementsInStrictMode() && (((kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaAnnotationDescriptor) annotationDescriptor).isFreshlySupportedTypeUseAnnotation() || getContainerApplicabilityType() == kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS)) {
            return true;
        }
        return kotlinTypeMarker != null && kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isPrimitiveArray((kotlin.reflect.jvm.internal.impl.types.KotlinType) kotlinTypeMarker) && getAnnotationTypeQualifierResolver().isTypeUseAnnotation(annotationDescriptor) && !this.containerContext.getComponents().getSettings().getEnhancePrimitiveArrays();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public java.lang.Iterable<kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor> getAnnotations(kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker kotlinTypeMarker) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinTypeMarker, "<this>");
        return ((kotlin.reflect.jvm.internal.impl.types.KotlinType) kotlinTypeMarker).getAnnotations();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public kotlin.reflect.jvm.internal.impl.types.KotlinType getEnhancedForWarnings(kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker kotlinTypeMarker) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinTypeMarker, "<this>");
        return kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt.getEnhancement((kotlin.reflect.jvm.internal.impl.types.KotlinType) kotlinTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe getFqNameUnsafe(kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker kotlinTypeMarker) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinTypeMarker, "<this>");
        kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor = kotlin.reflect.jvm.internal.impl.types.TypeUtils.getClassDescriptor((kotlin.reflect.jvm.internal.impl.types.KotlinType) kotlinTypeMarker);
        if (classDescriptor != null) {
            return kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.getFqName(classDescriptor);
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public boolean isNotNullTypeParameterCompat(kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker kotlinTypeMarker) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinTypeMarker, "<this>");
        return ((kotlin.reflect.jvm.internal.impl.types.KotlinType) kotlinTypeMarker).unwrap() instanceof kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NotNullTypeParameterImpl;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public boolean isEqual(kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker kotlinTypeMarker, kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker other) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinTypeMarker, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(other, "other");
        return this.containerContext.getComponents().getKotlinTypeChecker().equalTypes((kotlin.reflect.jvm.internal.impl.types.KotlinType) kotlinTypeMarker, (kotlin.reflect.jvm.internal.impl.types.KotlinType) other);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public boolean isArrayOrPrimitiveArray(kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker kotlinTypeMarker) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinTypeMarker, "<this>");
        return kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isArrayOrPrimitiveArray((kotlin.reflect.jvm.internal.impl.types.KotlinType) kotlinTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public boolean isFromJava(kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker typeParameterMarker) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeParameterMarker, "<this>");
        return typeParameterMarker instanceof kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaTypeParameterDescriptor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    protected kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus getDefaultNullability(kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus, kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers javaDefaultQualifiers) {
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatusCopy$default;
        if (nullabilityQualifierWithMigrationStatus != null && (nullabilityQualifierWithMigrationStatusCopy$default = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus.copy$default(nullabilityQualifierWithMigrationStatus, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NOT_NULL, false, 2, null)) != null) {
            return nullabilityQualifierWithMigrationStatusCopy$default;
        }
        if (javaDefaultQualifiers != null) {
            return javaDefaultQualifiers.getNullabilityQualifier();
        }
        return null;
    }
}
