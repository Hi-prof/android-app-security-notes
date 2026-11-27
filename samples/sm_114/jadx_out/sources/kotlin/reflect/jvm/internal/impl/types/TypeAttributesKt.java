package kotlin.reflect.jvm.internal.impl.types;

/* JADX INFO: compiled from: TypeAttributes.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TypeAttributesKt {
    public static final kotlin.reflect.jvm.internal.impl.types.TypeAttributes toDefaultAttributes(kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations annotations) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(annotations, "<this>");
        return kotlin.reflect.jvm.internal.impl.types.TypeAttributeTranslator.DefaultImpls.toAttributes$default(kotlin.reflect.jvm.internal.impl.types.DefaultTypeAttributeTranslator.INSTANCE, annotations, null, null, 6, null);
    }

    public static final kotlin.reflect.jvm.internal.impl.types.TypeAttributes replaceAnnotations(kotlin.reflect.jvm.internal.impl.types.TypeAttributes typeAttributes, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations newAnnotations) {
        kotlin.reflect.jvm.internal.impl.types.TypeAttributes typeAttributesRemove;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeAttributes, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(newAnnotations, "newAnnotations");
        if (kotlin.reflect.jvm.internal.impl.types.AnnotationsTypeAttributeKt.getAnnotations(typeAttributes) == newAnnotations) {
            return typeAttributes;
        }
        kotlin.reflect.jvm.internal.impl.types.AnnotationsTypeAttribute annotationsAttribute = kotlin.reflect.jvm.internal.impl.types.AnnotationsTypeAttributeKt.getAnnotationsAttribute(typeAttributes);
        if (annotationsAttribute != null && (typeAttributesRemove = typeAttributes.remove(annotationsAttribute)) != null) {
            typeAttributes = typeAttributesRemove;
        }
        return (newAnnotations.iterator().hasNext() || !newAnnotations.isEmpty()) ? typeAttributes.plus(new kotlin.reflect.jvm.internal.impl.types.AnnotationsTypeAttribute(newAnnotations)) : typeAttributes;
    }
}
