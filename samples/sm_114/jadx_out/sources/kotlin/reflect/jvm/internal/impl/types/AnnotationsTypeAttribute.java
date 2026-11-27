package kotlin.reflect.jvm.internal.impl.types;

/* JADX INFO: compiled from: AnnotationsTypeAttribute.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AnnotationsTypeAttribute extends kotlin.reflect.jvm.internal.impl.types.TypeAttribute<kotlin.reflect.jvm.internal.impl.types.AnnotationsTypeAttribute> {
    private final kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations annotations;

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeAttribute
    public kotlin.reflect.KClass<? extends kotlin.reflect.jvm.internal.impl.types.AnnotationsTypeAttribute> getKey() {
        return kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(kotlin.reflect.jvm.internal.impl.types.AnnotationsTypeAttribute.class);
    }

    public AnnotationsTypeAttribute(kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations annotations) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(annotations, "annotations");
        this.annotations = annotations;
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations getAnnotations() {
        return this.annotations;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeAttribute
    public kotlin.reflect.jvm.internal.impl.types.AnnotationsTypeAttribute intersect(kotlin.reflect.jvm.internal.impl.types.AnnotationsTypeAttribute annotationsTypeAttribute) {
        if (kotlin.jvm.internal.Intrinsics.areEqual(annotationsTypeAttribute, this)) {
            return this;
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeAttribute
    public kotlin.reflect.jvm.internal.impl.types.AnnotationsTypeAttribute add(kotlin.reflect.jvm.internal.impl.types.AnnotationsTypeAttribute annotationsTypeAttribute) {
        return annotationsTypeAttribute == null ? this : new kotlin.reflect.jvm.internal.impl.types.AnnotationsTypeAttribute(kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationsKt.composeAnnotations(this.annotations, annotationsTypeAttribute.annotations));
    }

    public boolean equals(java.lang.Object obj) {
        if (obj instanceof kotlin.reflect.jvm.internal.impl.types.AnnotationsTypeAttribute) {
            return kotlin.jvm.internal.Intrinsics.areEqual(((kotlin.reflect.jvm.internal.impl.types.AnnotationsTypeAttribute) obj).annotations, this.annotations);
        }
        return false;
    }

    public int hashCode() {
        return this.annotations.hashCode();
    }
}
