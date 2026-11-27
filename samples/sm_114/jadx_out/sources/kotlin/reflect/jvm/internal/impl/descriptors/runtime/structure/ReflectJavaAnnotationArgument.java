package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

/* JADX INFO: compiled from: ReflectJavaAnnotationArguments.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class ReflectJavaAnnotationArgument implements kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument {
    public static final kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationArgument.Factory Factory = new kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationArgument.Factory(null);
    private final kotlin.reflect.jvm.internal.impl.name.Name name;

    public /* synthetic */ ReflectJavaAnnotationArgument(kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(name);
    }

    private ReflectJavaAnnotationArgument(kotlin.reflect.jvm.internal.impl.name.Name name) {
        this.name = name;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument
    public kotlin.reflect.jvm.internal.impl.name.Name getName() {
        return this.name;
    }

    /* JADX INFO: compiled from: ReflectJavaAnnotationArguments.kt */
    public static final class Factory {
        public /* synthetic */ Factory(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Factory() {
        }

        public final kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationArgument create(java.lang.Object value, kotlin.reflect.jvm.internal.impl.name.Name name) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(value, "value");
            if (kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt.isEnumClassOrSpecializedEnumEntryClass(value.getClass())) {
                return new kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaEnumValueAnnotationArgument(name, (java.lang.Enum) value);
            }
            if (value instanceof java.lang.annotation.Annotation) {
                return new kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationAsAnnotationArgument(name, (java.lang.annotation.Annotation) value);
            }
            if (value instanceof java.lang.Object[]) {
                return new kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaArrayAnnotationArgument(name, (java.lang.Object[]) value);
            }
            return value instanceof java.lang.Class ? new kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClassObjectAnnotationArgument(name, (java.lang.Class) value) : new kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaLiteralAnnotationArgument(name, value);
        }
    }
}
