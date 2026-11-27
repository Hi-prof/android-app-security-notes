package kotlin.reflect.jvm.internal.impl.types;

/* JADX INFO: compiled from: AnnotationsTypeAttribute.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AnnotationsTypeAttributeKt {
    static final /* synthetic */ kotlin.reflect.KProperty<java.lang.Object>[] $$delegatedProperties = {kotlin.jvm.internal.Reflection.property1(new kotlin.jvm.internal.PropertyReference1Impl(kotlin.reflect.jvm.internal.impl.types.AnnotationsTypeAttributeKt.class, "annotationsAttribute", "getAnnotationsAttribute(Lorg/jetbrains/kotlin/types/TypeAttributes;)Lorg/jetbrains/kotlin/types/AnnotationsTypeAttribute;", 1))};
    private static final kotlin.properties.ReadOnlyProperty annotationsAttribute$delegate;

    public static final kotlin.reflect.jvm.internal.impl.types.AnnotationsTypeAttribute getAnnotationsAttribute(kotlin.reflect.jvm.internal.impl.types.TypeAttributes typeAttributes) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeAttributes, "<this>");
        return (kotlin.reflect.jvm.internal.impl.types.AnnotationsTypeAttribute) annotationsAttribute$delegate.getValue(typeAttributes, $$delegatedProperties[0]);
    }

    public static final kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations getAnnotations(kotlin.reflect.jvm.internal.impl.types.TypeAttributes typeAttributes) {
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations annotations;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeAttributes, "<this>");
        kotlin.reflect.jvm.internal.impl.types.AnnotationsTypeAttribute annotationsAttribute = getAnnotationsAttribute(typeAttributes);
        return (annotationsAttribute == null || (annotations = annotationsAttribute.getAnnotations()) == null) ? kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion.getEMPTY() : annotations;
    }

    static {
        kotlin.properties.ReadOnlyProperty readOnlyPropertyGenerateNullableAccessor = kotlin.reflect.jvm.internal.impl.types.TypeAttributes.Companion.generateNullableAccessor(kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(kotlin.reflect.jvm.internal.impl.types.AnnotationsTypeAttribute.class));
        kotlin.jvm.internal.Intrinsics.checkNotNull(readOnlyPropertyGenerateNullableAccessor, "null cannot be cast to non-null type kotlin.properties.ReadOnlyProperty<org.jetbrains.kotlin.types.TypeAttributes, T of org.jetbrains.kotlin.types.TypeAttributes.Companion.attributeAccessor?>");
        annotationsAttribute$delegate = readOnlyPropertyGenerateNullableAccessor;
    }
}
