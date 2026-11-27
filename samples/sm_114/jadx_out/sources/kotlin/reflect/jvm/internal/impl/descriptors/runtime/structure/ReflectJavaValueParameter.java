package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

/* JADX INFO: compiled from: ReflectJavaValueParameter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ReflectJavaValueParameter extends kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaElement implements kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter {
    private final boolean isVararg;
    private final java.lang.annotation.Annotation[] reflectAnnotations;
    private final java.lang.String reflectName;
    private final kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType type;

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public boolean isDeprecatedInJavaDoc() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter
    public kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType getType() {
        return this.type;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter
    public boolean isVararg() {
        return this.isVararg;
    }

    public ReflectJavaValueParameter(kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType type, java.lang.annotation.Annotation[] reflectAnnotations, java.lang.String str, boolean z) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(type, "type");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(reflectAnnotations, "reflectAnnotations");
        this.type = type;
        this.reflectAnnotations = reflectAnnotations;
        this.reflectName = str;
        this.isVararg = z;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotation> getAnnotations() {
        return kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationOwnerKt.getAnnotations(this.reflectAnnotations);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotation findAnnotation(kotlin.reflect.jvm.internal.impl.name.FqName fqName) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fqName, "fqName");
        return kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationOwnerKt.findAnnotation(this.reflectAnnotations, fqName);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter
    public kotlin.reflect.jvm.internal.impl.name.Name getName() {
        java.lang.String str = this.reflectName;
        if (str != null) {
            return kotlin.reflect.jvm.internal.impl.name.Name.guessByFirstCharacter(str);
        }
        return null;
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(getClass().getName());
        sb.append(": ");
        sb.append(isVararg() ? "vararg " : "");
        sb.append(getName());
        sb.append(": ");
        sb.append(getType());
        return sb.toString();
    }
}
