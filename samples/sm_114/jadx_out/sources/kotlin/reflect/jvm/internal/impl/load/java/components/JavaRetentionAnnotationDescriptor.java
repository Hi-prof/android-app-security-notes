package kotlin.reflect.jvm.internal.impl.load.java.components;

/* JADX INFO: compiled from: JavaAnnotationMapper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class JavaRetentionAnnotationDescriptor extends kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationDescriptor {
    static final /* synthetic */ kotlin.reflect.KProperty<java.lang.Object>[] $$delegatedProperties = {kotlin.jvm.internal.Reflection.property1(new kotlin.jvm.internal.PropertyReference1Impl(kotlin.reflect.jvm.internal.impl.load.java.components.JavaRetentionAnnotationDescriptor.class, "allValueArguments", "getAllValueArguments()Ljava/util/Map;", 0))};
    private final kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue allValueArguments$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JavaRetentionAnnotationDescriptor(kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation annotation, kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext c) {
        super(c, annotation, kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.retention);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(annotation, "annotation");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(c, "c");
        this.allValueArguments$delegate = c.getStorageManager().createLazyValue(new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.load.java.components.JavaRetentionAnnotationDescriptor$$Lambda$0
            private final kotlin.reflect.jvm.internal.impl.load.java.components.JavaRetentionAnnotationDescriptor arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.impl.load.java.components.JavaRetentionAnnotationDescriptor.allValueArguments_delegate$lambda$1(this.arg$0);
            }
        });
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    public java.util.Map<kotlin.reflect.jvm.internal.impl.name.Name, kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue<?>> getAllValueArguments() {
        return (java.util.Map) kotlin.reflect.jvm.internal.impl.storage.StorageKt.getValue(this.allValueArguments$delegate, this, (kotlin.reflect.KProperty<?>) $$delegatedProperties[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.util.Map allValueArguments_delegate$lambda$1(kotlin.reflect.jvm.internal.impl.load.java.components.JavaRetentionAnnotationDescriptor javaRetentionAnnotationDescriptor) {
        kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue<?> constantValueMapJavaRetentionArgument$descriptors_jvm = kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationTargetMapper.INSTANCE.mapJavaRetentionArgument$descriptors_jvm(javaRetentionAnnotationDescriptor.getFirstArgument());
        java.util.Map mapMapOf = constantValueMapJavaRetentionArgument$descriptors_jvm != null ? kotlin.collections.MapsKt.mapOf(kotlin.TuplesKt.to(kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationMapper.INSTANCE.getRETENTION_ANNOTATION_VALUE$descriptors_jvm(), constantValueMapJavaRetentionArgument$descriptors_jvm)) : null;
        return mapMapOf == null ? kotlin.collections.MapsKt.emptyMap() : mapMapOf;
    }
}
