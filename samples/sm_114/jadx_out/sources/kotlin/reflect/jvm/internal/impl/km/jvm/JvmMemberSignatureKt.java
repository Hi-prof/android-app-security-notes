package kotlin.reflect.jvm.internal.impl.km.jvm;

/* JADX INFO: compiled from: JvmMemberSignature.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class JvmMemberSignatureKt {
    public static final kotlin.reflect.jvm.internal.impl.km.jvm.JvmMethodSignature wrapAsPublic(kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature.Method method) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(method, "<this>");
        return new kotlin.reflect.jvm.internal.impl.km.jvm.JvmMethodSignature(method.getName(), method.getDesc());
    }

    public static final kotlin.reflect.jvm.internal.impl.km.jvm.JvmFieldSignature wrapAsPublic(kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature.Field field) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(field, "<this>");
        return new kotlin.reflect.jvm.internal.impl.km.jvm.JvmFieldSignature(field.getName(), field.getDesc());
    }
}
