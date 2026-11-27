package kotlin.reflect.jvm.internal.impl.load.java.components;

/* JADX INFO: compiled from: JavaAnnotationMapper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class JavaDeprecatedAnnotationDescriptor extends kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationDescriptor {
    static final /* synthetic */ kotlin.reflect.KProperty<java.lang.Object>[] $$delegatedProperties = {kotlin.jvm.internal.Reflection.property1(new kotlin.jvm.internal.PropertyReference1Impl(kotlin.reflect.jvm.internal.impl.load.java.components.JavaDeprecatedAnnotationDescriptor.class, "allValueArguments", "getAllValueArguments()Ljava/util/Map;", 0))};
    private final kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue allValueArguments$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JavaDeprecatedAnnotationDescriptor(kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation javaAnnotation, kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext c) {
        super(c, javaAnnotation, kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.deprecated);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(c, "c");
        this.allValueArguments$delegate = c.getStorageManager().createLazyValue(new kotlin.jvm.functions.Function0() { // from class: kotlin.reflect.jvm.internal.impl.load.java.components.JavaDeprecatedAnnotationDescriptor$$Lambda$0
            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.impl.load.java.components.JavaDeprecatedAnnotationDescriptor.allValueArguments_delegate$lambda$0();
            }
        });
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    public java.util.Map<kotlin.reflect.jvm.internal.impl.name.Name, kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue<?>> getAllValueArguments() {
        return (java.util.Map) kotlin.reflect.jvm.internal.impl.storage.StorageKt.getValue(this.allValueArguments$delegate, this, (kotlin.reflect.KProperty<?>) $$delegatedProperties[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.util.Map allValueArguments_delegate$lambda$0() {
        return kotlin.collections.MapsKt.mapOf(kotlin.TuplesKt.to(kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationMapper.INSTANCE.getDEPRECATED_ANNOTATION_MESSAGE$descriptors_jvm(), new kotlin.reflect.jvm.internal.impl.resolve.constants.StringValue("Deprecated in Java")));
    }
}
