package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

/* JADX INFO: compiled from: ReflectKotlinClass.kt */
/* JADX INFO: loaded from: classes2.dex */
final class SignatureSerializer {
    public static final kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.SignatureSerializer INSTANCE = new kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.SignatureSerializer();

    private SignatureSerializer() {
    }

    public final java.lang.String methodDesc(java.lang.reflect.Method method) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(method, "method");
        java.lang.StringBuilder sb = new java.lang.StringBuilder(com.taobao.weex.el.parse.Operators.BRACKET_START_STR);
        java.util.Iterator it = kotlin.jvm.internal.ArrayIteratorKt.iterator(method.getParameterTypes());
        while (it.hasNext()) {
            java.lang.Class cls = (java.lang.Class) it.next();
            kotlin.jvm.internal.Intrinsics.checkNotNull(cls);
            sb.append(kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt.getDesc(cls));
        }
        sb.append(com.taobao.weex.el.parse.Operators.BRACKET_END_STR);
        java.lang.Class<?> returnType = method.getReturnType();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(returnType, "getReturnType(...)");
        sb.append(kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt.getDesc(returnType));
        java.lang.String string = sb.toString();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public final java.lang.String constructorDesc(java.lang.reflect.Constructor<?> constructor) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(constructor, "constructor");
        java.lang.StringBuilder sb = new java.lang.StringBuilder(com.taobao.weex.el.parse.Operators.BRACKET_START_STR);
        java.util.Iterator it = kotlin.jvm.internal.ArrayIteratorKt.iterator(constructor.getParameterTypes());
        while (it.hasNext()) {
            java.lang.Class cls = (java.lang.Class) it.next();
            kotlin.jvm.internal.Intrinsics.checkNotNull(cls);
            sb.append(kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt.getDesc(cls));
        }
        sb.append(")V");
        java.lang.String string = sb.toString();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public final java.lang.String fieldDesc(java.lang.reflect.Field field) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(field, "field");
        java.lang.Class<?> type = field.getType();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
        return kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt.getDesc(type);
    }
}
