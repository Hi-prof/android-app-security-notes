package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

/* JADX INFO: compiled from: ReflectJavaAnnotationArguments.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ReflectJavaArrayAnnotationArgument extends kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationArgument implements kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayAnnotationArgument {
    private final java.lang.Object[] values;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReflectJavaArrayAnnotationArgument(kotlin.reflect.jvm.internal.impl.name.Name name, java.lang.Object[] values) {
        super(name, null);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(values, "values");
        this.values = values;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayAnnotationArgument
    public java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationArgument> getElements() {
        java.lang.Object[] objArr = this.values;
        java.util.ArrayList arrayList = new java.util.ArrayList(objArr.length);
        for (java.lang.Object obj : objArr) {
            kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationArgument.Factory factory = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationArgument.Factory;
            kotlin.jvm.internal.Intrinsics.checkNotNull(obj);
            arrayList.add(factory.create(obj, null));
        }
        return arrayList;
    }
}
