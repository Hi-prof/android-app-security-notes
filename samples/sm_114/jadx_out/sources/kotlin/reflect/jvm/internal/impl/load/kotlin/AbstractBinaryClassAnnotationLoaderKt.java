package kotlin.reflect.jvm.internal.impl.load.kotlin;

/* JADX INFO: compiled from: AbstractBinaryClassAnnotationLoader.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AbstractBinaryClassAnnotationLoaderKt {
    public static /* synthetic */ kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature getPropertySignature$default(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property property, kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver nameResolver, kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable typeTable, boolean z, boolean z2, boolean z3, int i, java.lang.Object obj) {
        if ((i & 8) != 0) {
            z = false;
        }
        if ((i & 16) != 0) {
            z2 = false;
        }
        if ((i & 32) != 0) {
            z3 = true;
        }
        return getPropertySignature(property, nameResolver, typeTable, z, z2, z3);
    }

    public static final kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature getPropertySignature(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property proto, kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver nameResolver, kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable typeTable, boolean z, boolean z2, boolean z3) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(proto, "proto");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property, kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmPropertySignature> propertySignature = kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.propertySignature;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(propertySignature, "propertySignature");
        kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmPropertySignature jvmPropertySignature = (kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmPropertySignature) kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt.getExtensionOrNull(proto, propertySignature);
        if (jvmPropertySignature == null) {
            return null;
        }
        if (z) {
            kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature.Field jvmFieldSignature = kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil.INSTANCE.getJvmFieldSignature(proto, nameResolver, typeTable, z3);
            if (jvmFieldSignature == null) {
                return null;
            }
            return kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature.Companion.fromJvmMemberSignature(jvmFieldSignature);
        }
        if (!z2 || !jvmPropertySignature.hasSyntheticMethod()) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature.Companion companion = kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature.Companion;
        kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmMethodSignature syntheticMethod = jvmPropertySignature.getSyntheticMethod();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(syntheticMethod, "getSyntheticMethod(...)");
        return companion.fromMethod(nameResolver, syntheticMethod);
    }
}
