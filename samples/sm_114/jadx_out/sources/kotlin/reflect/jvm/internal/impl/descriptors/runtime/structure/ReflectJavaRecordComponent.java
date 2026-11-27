package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

/* JADX INFO: compiled from: ReflectJavaRecordComponent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ReflectJavaRecordComponent extends kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaMember implements kotlin.reflect.jvm.internal.impl.load.java.structure.JavaRecordComponent {
    private final java.lang.Object recordComponent;

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaRecordComponent
    public boolean isVararg() {
        return false;
    }

    public ReflectJavaRecordComponent(java.lang.Object recordComponent) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(recordComponent, "recordComponent");
        this.recordComponent = recordComponent;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaRecordComponent
    public kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType getType() throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        java.lang.Class<?> clsLoadGetType = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.Java16RecordComponentsLoader.INSTANCE.loadGetType(this.recordComponent);
        if (clsLoadGetType != null) {
            return new kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClassifierType(clsLoadGetType);
        }
        throw new java.lang.NoSuchMethodError("Can't find `getType` method");
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaMember
    public java.lang.reflect.Member getMember() throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        java.lang.reflect.Method methodLoadGetAccessor = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.Java16RecordComponentsLoader.INSTANCE.loadGetAccessor(this.recordComponent);
        if (methodLoadGetAccessor != null) {
            return methodLoadGetAccessor;
        }
        throw new java.lang.NoSuchMethodError("Can't find `getAccessor` method");
    }
}
