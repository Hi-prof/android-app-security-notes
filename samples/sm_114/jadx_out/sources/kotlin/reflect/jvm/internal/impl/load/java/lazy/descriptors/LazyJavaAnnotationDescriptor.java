package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

/* JADX INFO: compiled from: LazyJavaAnnotationDescriptor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class LazyJavaAnnotationDescriptor implements kotlin.reflect.jvm.internal.impl.load.java.descriptors.PossiblyExternalAnnotationDescriptor {
    static final /* synthetic */ kotlin.reflect.KProperty<java.lang.Object>[] $$delegatedProperties = {kotlin.jvm.internal.Reflection.property1(new kotlin.jvm.internal.PropertyReference1Impl(kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaAnnotationDescriptor.class, "fqName", "getFqName()Lorg/jetbrains/kotlin/name/FqName;", 0)), kotlin.jvm.internal.Reflection.property1(new kotlin.jvm.internal.PropertyReference1Impl(kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaAnnotationDescriptor.class, "type", "getType()Lorg/jetbrains/kotlin/types/SimpleType;", 0)), kotlin.jvm.internal.Reflection.property1(new kotlin.jvm.internal.PropertyReference1Impl(kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaAnnotationDescriptor.class, "allValueArguments", "getAllValueArguments()Ljava/util/Map;", 0))};
    private final kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue allValueArguments$delegate;
    private final kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext c;
    private final kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue fqName$delegate;
    private final boolean isFreshlySupportedTypeUseAnnotation;
    private final boolean isIdeExternalAnnotation;
    private final kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation javaAnnotation;
    private final kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement source;
    private final kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue type$delegate;

    public LazyJavaAnnotationDescriptor(kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext c, kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation javaAnnotation, boolean z) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(c, "c");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(javaAnnotation, "javaAnnotation");
        this.c = c;
        this.javaAnnotation = javaAnnotation;
        this.fqName$delegate = c.getStorageManager().createNullableLazyValue(new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaAnnotationDescriptor$$Lambda$0
            private final kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaAnnotationDescriptor arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaAnnotationDescriptor.fqName_delegate$lambda$0(this.arg$0);
            }
        });
        this.type$delegate = c.getStorageManager().createLazyValue(new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaAnnotationDescriptor$$Lambda$1
            private final kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaAnnotationDescriptor arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaAnnotationDescriptor.type_delegate$lambda$2(this.arg$0);
            }
        });
        this.source = c.getComponents().getSourceElementFactory().source(javaAnnotation);
        this.allValueArguments$delegate = c.getStorageManager().createLazyValue(new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaAnnotationDescriptor$$Lambda$2
            private final kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaAnnotationDescriptor arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaAnnotationDescriptor.allValueArguments_delegate$lambda$5(this.arg$0);
            }
        });
        this.isIdeExternalAnnotation = javaAnnotation.isIdeExternalAnnotation();
        this.isFreshlySupportedTypeUseAnnotation = javaAnnotation.isFreshlySupportedTypeUseAnnotation() || z;
    }

    public /* synthetic */ LazyJavaAnnotationDescriptor(kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext lazyJavaResolverContext, kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation javaAnnotation, boolean z, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(lazyJavaResolverContext, javaAnnotation, (i & 4) != 0 ? false : z);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    public kotlin.reflect.jvm.internal.impl.name.FqName getFqName() {
        return (kotlin.reflect.jvm.internal.impl.name.FqName) kotlin.reflect.jvm.internal.impl.storage.StorageKt.getValue(this.fqName$delegate, this, (kotlin.reflect.KProperty<?>) $$delegatedProperties[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.name.FqName fqName_delegate$lambda$0(kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaAnnotationDescriptor lazyJavaAnnotationDescriptor) {
        kotlin.reflect.jvm.internal.impl.name.ClassId classId = lazyJavaAnnotationDescriptor.javaAnnotation.getClassId();
        if (classId != null) {
            return classId.asSingleFqName();
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    public kotlin.reflect.jvm.internal.impl.types.SimpleType getType() {
        return (kotlin.reflect.jvm.internal.impl.types.SimpleType) kotlin.reflect.jvm.internal.impl.storage.StorageKt.getValue(this.type$delegate, this, (kotlin.reflect.KProperty<?>) $$delegatedProperties[1]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.types.SimpleType type_delegate$lambda$2(kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaAnnotationDescriptor lazyJavaAnnotationDescriptor) {
        kotlin.reflect.jvm.internal.impl.name.FqName fqName = lazyJavaAnnotationDescriptor.getFqName();
        if (fqName == null) {
            return kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils.createErrorType(kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind.NOT_FOUND_FQNAME_FOR_JAVA_ANNOTATION, lazyJavaAnnotationDescriptor.javaAnnotation.toString());
        }
        kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptorMapJavaToKotlin$default = kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMapper.mapJavaToKotlin$default(kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMapper.INSTANCE, fqName, lazyJavaAnnotationDescriptor.c.getModule().getBuiltIns(), null, 4, null);
        if (classDescriptorMapJavaToKotlin$default == null) {
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass javaClassResolve = lazyJavaAnnotationDescriptor.javaAnnotation.resolve();
            classDescriptorMapJavaToKotlin$default = javaClassResolve != null ? lazyJavaAnnotationDescriptor.c.getComponents().getModuleClassResolver().resolveClass(javaClassResolve) : null;
            if (classDescriptorMapJavaToKotlin$default == null) {
                classDescriptorMapJavaToKotlin$default = lazyJavaAnnotationDescriptor.createTypeForMissingDependencies(fqName);
            }
        }
        return classDescriptorMapJavaToKotlin$default.getDefaultType();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    public kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement getSource() {
        return this.source;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    public java.util.Map<kotlin.reflect.jvm.internal.impl.name.Name, kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue<?>> getAllValueArguments() {
        return (java.util.Map) kotlin.reflect.jvm.internal.impl.storage.StorageKt.getValue(this.allValueArguments$delegate, this, (kotlin.reflect.KProperty<?>) $$delegatedProperties[2]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.util.Map allValueArguments_delegate$lambda$5(kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaAnnotationDescriptor lazyJavaAnnotationDescriptor) {
        java.util.Collection<kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument> arguments = lazyJavaAnnotationDescriptor.javaAnnotation.getArguments();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument javaAnnotationArgument : arguments) {
            kotlin.reflect.jvm.internal.impl.name.Name name = javaAnnotationArgument.getName();
            if (name == null) {
                name = kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames.DEFAULT_ANNOTATION_MEMBER_NAME;
            }
            kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue<?> constantValueResolveAnnotationArgument = lazyJavaAnnotationDescriptor.resolveAnnotationArgument(javaAnnotationArgument);
            kotlin.Pair pair = constantValueResolveAnnotationArgument != null ? kotlin.TuplesKt.to(name, constantValueResolveAnnotationArgument) : null;
            if (pair != null) {
                arrayList.add(pair);
            }
        }
        return kotlin.collections.MapsKt.toMap(arrayList);
    }

    private final kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue<?> resolveAnnotationArgument(kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument javaAnnotationArgument) {
        if (javaAnnotationArgument instanceof kotlin.reflect.jvm.internal.impl.load.java.structure.JavaLiteralAnnotationArgument) {
            return kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValueFactory.createConstantValue$default(kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValueFactory.INSTANCE, ((kotlin.reflect.jvm.internal.impl.load.java.structure.JavaLiteralAnnotationArgument) javaAnnotationArgument).getValue(), null, 2, null);
        }
        if (javaAnnotationArgument instanceof kotlin.reflect.jvm.internal.impl.load.java.structure.JavaEnumValueAnnotationArgument) {
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaEnumValueAnnotationArgument javaEnumValueAnnotationArgument = (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaEnumValueAnnotationArgument) javaAnnotationArgument;
            return resolveFromEnumValue(javaEnumValueAnnotationArgument.getEnumClassId(), javaEnumValueAnnotationArgument.getEntryName());
        }
        if (!(javaAnnotationArgument instanceof kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayAnnotationArgument)) {
            if (javaAnnotationArgument instanceof kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationAsAnnotationArgument) {
                return resolveFromAnnotation(((kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationAsAnnotationArgument) javaAnnotationArgument).getAnnotation());
            }
            if (javaAnnotationArgument instanceof kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassObjectAnnotationArgument) {
                return resolveFromJavaClassObjectType(((kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassObjectAnnotationArgument) javaAnnotationArgument).getReferencedType());
            }
            return null;
        }
        kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayAnnotationArgument javaArrayAnnotationArgument = (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayAnnotationArgument) javaAnnotationArgument;
        kotlin.reflect.jvm.internal.impl.name.Name name = javaArrayAnnotationArgument.getName();
        if (name == null) {
            name = kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames.DEFAULT_ANNOTATION_MEMBER_NAME;
        }
        kotlin.jvm.internal.Intrinsics.checkNotNull(name);
        return resolveFromArray(name, javaArrayAnnotationArgument.getElements());
    }

    private final kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue<?> resolveFromAnnotation(kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation javaAnnotation) {
        return new kotlin.reflect.jvm.internal.impl.resolve.constants.AnnotationValue(new kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaAnnotationDescriptor(this.c, javaAnnotation, false, 4, null));
    }

    private final kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue<?> resolveFromArray(kotlin.reflect.jvm.internal.impl.name.Name name, java.util.List<? extends kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument> list) {
        kotlin.reflect.jvm.internal.impl.types.SimpleType type;
        if (kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt.isError(getType())) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor annotationClass = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getAnnotationClass(this);
        kotlin.jvm.internal.Intrinsics.checkNotNull(annotationClass);
        kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor annotationParameterByName = kotlin.reflect.jvm.internal.impl.load.java.components.DescriptorResolverUtils.getAnnotationParameterByName(name, annotationClass);
        if (annotationParameterByName == null || (type = annotationParameterByName.getType()) == null) {
            kotlin.reflect.jvm.internal.impl.types.SimpleType arrayType = this.c.getComponents().getModule().getBuiltIns().getArrayType(kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT, kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils.createErrorType(kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind.UNKNOWN_ARRAY_ELEMENT_TYPE_OF_ANNOTATION_ARGUMENT, new java.lang.String[0]));
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(arrayType, "getArrayType(...)");
            type = arrayType;
        }
        java.util.List<? extends kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument> list2 = list;
        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(list2, 10));
        java.util.Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            kotlin.reflect.jvm.internal.impl.resolve.constants.NullValue nullValueResolveAnnotationArgument = resolveAnnotationArgument((kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument) it.next());
            if (nullValueResolveAnnotationArgument == null) {
                nullValueResolveAnnotationArgument = new kotlin.reflect.jvm.internal.impl.resolve.constants.NullValue();
            }
            arrayList.add(nullValueResolveAnnotationArgument);
        }
        return kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValueFactory.INSTANCE.createArrayValue(arrayList, type);
    }

    private final kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue<?> resolveFromEnumValue(kotlin.reflect.jvm.internal.impl.name.ClassId classId, kotlin.reflect.jvm.internal.impl.name.Name name) {
        if (classId == null || name == null) {
            return null;
        }
        return new kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue(classId, name);
    }

    private final kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue<?> resolveFromJavaClassObjectType(kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType javaType) {
        return kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue.Companion.create(this.c.getTypeResolver().transformJavaType(javaType, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributesKt.toAttributes$default(kotlin.reflect.jvm.internal.impl.types.TypeUsage.COMMON, false, false, null, 7, null)));
    }

    public java.lang.String toString() {
        return kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.renderAnnotation$default(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.FQ_NAMES_IN_TYPES, this, null, 2, null);
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor createTypeForMissingDependencies(kotlin.reflect.jvm.internal.impl.name.FqName fqName) {
        return kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt.findNonGenericClassAcrossDependencies(this.c.getModule(), kotlin.reflect.jvm.internal.impl.name.ClassId.Companion.topLevel(fqName), this.c.getComponents().getDeserializedDescriptorResolver().getComponents().getNotFoundClasses());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.descriptors.PossiblyExternalAnnotationDescriptor
    public boolean isIdeExternalAnnotation() {
        return this.isIdeExternalAnnotation;
    }

    public final boolean isFreshlySupportedTypeUseAnnotation() {
        return this.isFreshlySupportedTypeUseAnnotation;
    }
}
