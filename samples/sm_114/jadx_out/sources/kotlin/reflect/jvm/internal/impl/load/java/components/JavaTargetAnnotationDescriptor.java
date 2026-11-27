package kotlin.reflect.jvm.internal.impl.load.java.components;

/* JADX INFO: compiled from: JavaAnnotationMapper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class JavaTargetAnnotationDescriptor extends kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationDescriptor {
    static final /* synthetic */ kotlin.reflect.KProperty<java.lang.Object>[] $$delegatedProperties = {kotlin.jvm.internal.Reflection.property1(new kotlin.jvm.internal.PropertyReference1Impl(kotlin.reflect.jvm.internal.impl.load.java.components.JavaTargetAnnotationDescriptor.class, "allValueArguments", "getAllValueArguments()Ljava/util/Map;", 0))};
    private final kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue allValueArguments$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JavaTargetAnnotationDescriptor(kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation annotation, kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext c) {
        super(c, annotation, kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.target);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(annotation, "annotation");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(c, "c");
        this.allValueArguments$delegate = c.getStorageManager().createLazyValue(new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.load.java.components.JavaTargetAnnotationDescriptor$$Lambda$0
            private final kotlin.reflect.jvm.internal.impl.load.java.components.JavaTargetAnnotationDescriptor arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.impl.load.java.components.JavaTargetAnnotationDescriptor.allValueArguments_delegate$lambda$1(this.arg$0);
            }
        });
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    public java.util.Map<kotlin.reflect.jvm.internal.impl.name.Name, kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue<java.lang.Object>> getAllValueArguments() {
        return (java.util.Map) kotlin.reflect.jvm.internal.impl.storage.StorageKt.getValue(this.allValueArguments$delegate, this, (kotlin.reflect.KProperty<?>) $$delegatedProperties[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.util.Map allValueArguments_delegate$lambda$1(kotlin.reflect.jvm.internal.impl.load.java.components.JavaTargetAnnotationDescriptor javaTargetAnnotationDescriptor) {
        kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue<?> constantValueMapJavaTargetArguments$descriptors_jvm;
        kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument firstArgument = javaTargetAnnotationDescriptor.getFirstArgument();
        if (firstArgument instanceof kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayAnnotationArgument) {
            constantValueMapJavaTargetArguments$descriptors_jvm = kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationTargetMapper.INSTANCE.mapJavaTargetArguments$descriptors_jvm(((kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayAnnotationArgument) javaTargetAnnotationDescriptor.getFirstArgument()).getElements());
        } else {
            constantValueMapJavaTargetArguments$descriptors_jvm = firstArgument instanceof kotlin.reflect.jvm.internal.impl.load.java.structure.JavaEnumValueAnnotationArgument ? kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationTargetMapper.INSTANCE.mapJavaTargetArguments$descriptors_jvm(kotlin.collections.CollectionsKt.listOf(javaTargetAnnotationDescriptor.getFirstArgument())) : null;
        }
        java.util.Map mapMapOf = constantValueMapJavaTargetArguments$descriptors_jvm != null ? kotlin.collections.MapsKt.mapOf(kotlin.TuplesKt.to(kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationMapper.INSTANCE.getTARGET_ANNOTATION_ALLOWED_TARGETS$descriptors_jvm(), constantValueMapJavaTargetArguments$descriptors_jvm)) : null;
        return mapMapOf == null ? kotlin.collections.MapsKt.emptyMap() : mapMapOf;
    }
}
