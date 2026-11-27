package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

/* JADX INFO: compiled from: BuiltInAnnotationDescriptor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class BuiltInAnnotationDescriptor implements kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor {
    private final java.util.Map<kotlin.reflect.jvm.internal.impl.name.Name, kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue<?>> allValueArguments;
    private final kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns builtIns;
    private final boolean forcePropagationDeprecationToOverrides;
    private final kotlin.reflect.jvm.internal.impl.name.FqName fqName;
    private final kotlin.Lazy type$delegate;

    /* JADX WARN: Multi-variable type inference failed */
    public BuiltInAnnotationDescriptor(kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns builtIns, kotlin.reflect.jvm.internal.impl.name.FqName fqName, java.util.Map<kotlin.reflect.jvm.internal.impl.name.Name, ? extends kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue<?>> allValueArguments, boolean z) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(builtIns, "builtIns");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fqName, "fqName");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(allValueArguments, "allValueArguments");
        this.builtIns = builtIns;
        this.fqName = fqName;
        this.allValueArguments = allValueArguments;
        this.forcePropagationDeprecationToOverrides = z;
        this.type$delegate = kotlin.LazyKt.lazy(kotlin.LazyThreadSafetyMode.PUBLICATION, new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.descriptors.annotations.BuiltInAnnotationDescriptor$$Lambda$0
            private final kotlin.reflect.jvm.internal.impl.descriptors.annotations.BuiltInAnnotationDescriptor arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.impl.descriptors.annotations.BuiltInAnnotationDescriptor.type_delegate$lambda$0(this.arg$0);
            }
        });
    }

    public /* synthetic */ BuiltInAnnotationDescriptor(kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns kotlinBuiltIns, kotlin.reflect.jvm.internal.impl.name.FqName fqName, java.util.Map map, boolean z, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(kotlinBuiltIns, fqName, map, (i & 8) != 0 ? false : z);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    public kotlin.reflect.jvm.internal.impl.name.FqName getFqName() {
        return this.fqName;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    public java.util.Map<kotlin.reflect.jvm.internal.impl.name.Name, kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue<?>> getAllValueArguments() {
        return this.allValueArguments;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    public kotlin.reflect.jvm.internal.impl.types.KotlinType getType() {
        java.lang.Object value = this.type$delegate.getValue();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (kotlin.reflect.jvm.internal.impl.types.KotlinType) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.types.SimpleType type_delegate$lambda$0(kotlin.reflect.jvm.internal.impl.descriptors.annotations.BuiltInAnnotationDescriptor builtInAnnotationDescriptor) {
        return builtInAnnotationDescriptor.builtIns.getBuiltInClassByFqName(builtInAnnotationDescriptor.getFqName()).getDefaultType();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    public kotlin.reflect.jvm.internal.impl.descriptors.SourceElement getSource() {
        kotlin.reflect.jvm.internal.impl.descriptors.SourceElement NO_SOURCE = kotlin.reflect.jvm.internal.impl.descriptors.SourceElement.NO_SOURCE;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(NO_SOURCE, "NO_SOURCE");
        return NO_SOURCE;
    }
}
