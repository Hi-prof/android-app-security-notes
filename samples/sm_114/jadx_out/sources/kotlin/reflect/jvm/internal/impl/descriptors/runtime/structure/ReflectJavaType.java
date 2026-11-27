package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

/* JADX INFO: compiled from: ReflectJavaType.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class ReflectJavaType implements kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType {
    public static final kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType.Factory Factory = new kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType.Factory(null);

    protected abstract java.lang.reflect.Type getReflectType();

    /* JADX INFO: compiled from: ReflectJavaType.kt */
    public static final class Factory {
        public /* synthetic */ Factory(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Factory() {
        }

        public final kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType create(java.lang.reflect.Type type) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(type, "type");
            boolean z = type instanceof java.lang.Class;
            if (z) {
                java.lang.Class cls = (java.lang.Class) type;
                if (cls.isPrimitive()) {
                    return new kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaPrimitiveType(cls);
                }
            }
            if ((type instanceof java.lang.reflect.GenericArrayType) || (z && ((java.lang.Class) type).isArray())) {
                return new kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaArrayType(type);
            }
            return type instanceof java.lang.reflect.WildcardType ? new kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaWildcardType((java.lang.reflect.WildcardType) type) : new kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClassifierType(type);
        }
    }

    public boolean equals(java.lang.Object obj) {
        return (obj instanceof kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType) && kotlin.jvm.internal.Intrinsics.areEqual(getReflectType(), ((kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType) obj).getReflectType());
    }

    public int hashCode() {
        return getReflectType().hashCode();
    }

    public java.lang.String toString() {
        return getClass().getName() + ": " + getReflectType();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation findAnnotation(kotlin.reflect.jvm.internal.impl.name.FqName fqName) {
        java.lang.Object obj;
        java.lang.Object next;
        kotlin.reflect.jvm.internal.impl.name.ClassId classId;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fqName, "fqName");
        java.util.Iterator<T> it = getAnnotations().iterator();
        do {
            obj = null;
            if (it.hasNext()) {
                next = it.next();
                classId = ((kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation) next).getClassId();
            }
            return (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation) obj;
        } while (!kotlin.jvm.internal.Intrinsics.areEqual(classId != null ? classId.asSingleFqName() : null, fqName));
        obj = next;
        return (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation) obj;
    }
}
