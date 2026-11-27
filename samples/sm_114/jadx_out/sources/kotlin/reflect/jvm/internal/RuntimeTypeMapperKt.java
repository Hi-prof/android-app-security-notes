package kotlin.reflect.jvm.internal;

/* JADX INFO: compiled from: RuntimeTypeMapper.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"signature", "", "Ljava/lang/reflect/Method;", "getSignature", "(Ljava/lang/reflect/Method;)Ljava/lang/String;", "kotlin-reflection"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class RuntimeTypeMapperKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final java.lang.String getSignature(java.lang.reflect.Method method) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(method.getName());
        java.lang.Class<?>[] parameterTypes = method.getParameterTypes();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(parameterTypes, "getParameterTypes(...)");
        sb.append(kotlin.collections.ArraysKt.joinToString$default(parameterTypes, "", com.taobao.weex.el.parse.Operators.BRACKET_START_STR, com.taobao.weex.el.parse.Operators.BRACKET_END_STR, 0, (java.lang.CharSequence) null, new kotlin.jvm.functions.Function1() { // from class: kotlin.reflect.jvm.internal.RuntimeTypeMapperKt$$Lambda$0
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.RuntimeTypeMapperKt._get_signature_$lambda$0((java.lang.Class) obj);
            }
        }, 24, (java.lang.Object) null));
        java.lang.Class<?> returnType = method.getReturnType();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(returnType, "getReturnType(...)");
        sb.append(kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt.getDesc(returnType));
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.lang.CharSequence _get_signature_$lambda$0(java.lang.Class cls) {
        kotlin.jvm.internal.Intrinsics.checkNotNull(cls);
        return kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt.getDesc(cls);
    }
}
