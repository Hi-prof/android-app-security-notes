package kotlin.reflect.jvm.internal.impl.load.java.components;

/* JADX INFO: compiled from: JavaAnnotationMapper.kt */
/* JADX INFO: loaded from: classes2.dex */
public class JavaAnnotationDescriptor implements kotlin.reflect.jvm.internal.impl.load.java.descriptors.PossiblyExternalAnnotationDescriptor {
    static final /* synthetic */ kotlin.reflect.KProperty<java.lang.Object>[] $$delegatedProperties = {kotlin.jvm.internal.Reflection.property1(new kotlin.jvm.internal.PropertyReference1Impl(kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationDescriptor.class, "type", "getType()Lorg/jetbrains/kotlin/types/SimpleType;", 0))};
    private final kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument firstArgument;
    private final kotlin.reflect.jvm.internal.impl.name.FqName fqName;
    private final boolean isIdeExternalAnnotation;
    private final kotlin.reflect.jvm.internal.impl.descriptors.SourceElement source;
    private final kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue type$delegate;

    public JavaAnnotationDescriptor(final kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext c, kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation javaAnnotation, kotlin.reflect.jvm.internal.impl.name.FqName fqName) {
        kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement NO_SOURCE;
        java.util.Collection<kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument> arguments;
        kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement javaSourceElementSource;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(c, "c");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fqName, "fqName");
        this.fqName = fqName;
        if (javaAnnotation == null || (javaSourceElementSource = c.getComponents().getSourceElementFactory().source(javaAnnotation)) == null) {
            NO_SOURCE = kotlin.reflect.jvm.internal.impl.descriptors.SourceElement.NO_SOURCE;
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(NO_SOURCE, "NO_SOURCE");
        } else {
            NO_SOURCE = javaSourceElementSource;
        }
        this.source = NO_SOURCE;
        this.type$delegate = c.getStorageManager().createLazyValue(new kotlin.jvm.functions.Function0(c, this) { // from class: kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationDescriptor$$Lambda$0
            private final kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext arg$0;
            private final kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationDescriptor arg$1;

            {
                this.arg$0 = c;
                this.arg$1 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationDescriptor.type_delegate$lambda$1(this.arg$0, this.arg$1);
            }
        });
        this.firstArgument = (javaAnnotation == null || (arguments = javaAnnotation.getArguments()) == null) ? null : (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument) kotlin.collections.CollectionsKt.firstOrNull(arguments);
        boolean z = false;
        if (javaAnnotation != null && javaAnnotation.isIdeExternalAnnotation()) {
            z = true;
        }
        this.isIdeExternalAnnotation = z;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    public kotlin.reflect.jvm.internal.impl.name.FqName getFqName() {
        return this.fqName;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    public kotlin.reflect.jvm.internal.impl.descriptors.SourceElement getSource() {
        return this.source;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.types.SimpleType type_delegate$lambda$1(kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext lazyJavaResolverContext, kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationDescriptor javaAnnotationDescriptor) {
        kotlin.reflect.jvm.internal.impl.types.SimpleType defaultType = lazyJavaResolverContext.getModule().getBuiltIns().getBuiltInClassByFqName(javaAnnotationDescriptor.getFqName()).getDefaultType();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(defaultType, "getDefaultType(...)");
        return defaultType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    public kotlin.reflect.jvm.internal.impl.types.SimpleType getType() {
        return (kotlin.reflect.jvm.internal.impl.types.SimpleType) kotlin.reflect.jvm.internal.impl.storage.StorageKt.getValue(this.type$delegate, this, (kotlin.reflect.KProperty<?>) $$delegatedProperties[0]);
    }

    protected final kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument getFirstArgument() {
        return this.firstArgument;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    public java.util.Map<kotlin.reflect.jvm.internal.impl.name.Name, kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue<?>> getAllValueArguments() {
        return kotlin.collections.MapsKt.emptyMap();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.descriptors.PossiblyExternalAnnotationDescriptor
    public boolean isIdeExternalAnnotation() {
        return this.isIdeExternalAnnotation;
    }
}
