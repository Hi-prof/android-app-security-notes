package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

/* JADX INFO: compiled from: ReflectJavaAnnotationArguments.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ReflectJavaEnumValueAnnotationArgument extends kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationArgument implements kotlin.reflect.jvm.internal.impl.load.java.structure.JavaEnumValueAnnotationArgument {
    private final java.lang.Enum<?> value;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReflectJavaEnumValueAnnotationArgument(kotlin.reflect.jvm.internal.impl.name.Name name, java.lang.Enum<?> value) {
        super(name, null);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(value, "value");
        this.value = value;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaEnumValueAnnotationArgument
    public kotlin.reflect.jvm.internal.impl.name.ClassId getEnumClassId() {
        java.lang.Class<?> enclosingClass = this.value.getClass();
        if (!enclosingClass.isEnum()) {
            enclosingClass = enclosingClass.getEnclosingClass();
        }
        kotlin.jvm.internal.Intrinsics.checkNotNull(enclosingClass);
        return kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt.getClassId(enclosingClass);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaEnumValueAnnotationArgument
    public kotlin.reflect.jvm.internal.impl.name.Name getEntryName() {
        return kotlin.reflect.jvm.internal.impl.name.Name.identifier(this.value.name());
    }
}
