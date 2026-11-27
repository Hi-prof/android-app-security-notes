package kotlin.reflect.jvm.internal.impl.load.kotlin;

/* JADX INFO: compiled from: JavaFlexibleTypeDeserializer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class JavaFlexibleTypeDeserializer implements kotlin.reflect.jvm.internal.impl.serialization.deserialization.FlexibleTypeDeserializer {
    public static final kotlin.reflect.jvm.internal.impl.load.kotlin.JavaFlexibleTypeDeserializer INSTANCE = new kotlin.reflect.jvm.internal.impl.load.kotlin.JavaFlexibleTypeDeserializer();

    private JavaFlexibleTypeDeserializer() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.FlexibleTypeDeserializer
    public kotlin.reflect.jvm.internal.impl.types.KotlinType create(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type proto, java.lang.String flexibleId, kotlin.reflect.jvm.internal.impl.types.SimpleType lowerBound, kotlin.reflect.jvm.internal.impl.types.SimpleType upperBound) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(proto, "proto");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(flexibleId, "flexibleId");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(lowerBound, "lowerBound");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(upperBound, "upperBound");
        if (!kotlin.jvm.internal.Intrinsics.areEqual(flexibleId, "kotlin.jvm.PlatformType")) {
            return kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils.createErrorType(kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind.ERROR_FLEXIBLE_TYPE, flexibleId, lowerBound.toString(), upperBound.toString());
        }
        if (proto.hasExtension(kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.isRaw)) {
            return new kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl(lowerBound, upperBound);
        }
        return kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.flexibleType(lowerBound, upperBound);
    }
}
