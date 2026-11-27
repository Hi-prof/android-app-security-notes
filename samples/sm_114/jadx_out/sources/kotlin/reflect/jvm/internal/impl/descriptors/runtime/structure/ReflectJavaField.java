package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

/* JADX INFO: compiled from: ReflectJavaField.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ReflectJavaField extends kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaMember implements kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField {
    private final java.lang.reflect.Field member;

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField
    public boolean getHasConstantNotNullInitializer() {
        return false;
    }

    public ReflectJavaField(java.lang.reflect.Field member) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(member, "member");
        this.member = member;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaMember
    public java.lang.reflect.Field getMember() {
        return this.member;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField
    public boolean isEnumEntry() {
        return getMember().isEnumConstant();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField
    public kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType getType() {
        kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType.Factory factory = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType.Factory;
        java.lang.reflect.Type genericType = getMember().getGenericType();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(genericType, "getGenericType(...)");
        return factory.create(genericType);
    }
}
