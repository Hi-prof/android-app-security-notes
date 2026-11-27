package kotlin.reflect.jvm.internal.impl.load.kotlin;

/* JADX INFO: compiled from: KotlinJvmBinarySourceElement.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class KotlinJvmBinarySourceElement implements kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource {
    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerAbiStability abiStability;
    private final kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass binaryClass;
    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.IncompatibleVersionErrorData<kotlin.reflect.jvm.internal.impl.metadata.deserialization.MetadataVersion> incompatibility;
    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.PreReleaseInfo preReleaseInfo;

    public KotlinJvmBinarySourceElement(kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass binaryClass, kotlin.reflect.jvm.internal.impl.serialization.deserialization.IncompatibleVersionErrorData<kotlin.reflect.jvm.internal.impl.metadata.deserialization.MetadataVersion> incompatibleVersionErrorData, kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.PreReleaseInfo preReleaseInfo, kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerAbiStability abiStability) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(binaryClass, "binaryClass");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(preReleaseInfo, "preReleaseInfo");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(abiStability, "abiStability");
        this.binaryClass = binaryClass;
        this.incompatibility = incompatibleVersionErrorData;
        this.preReleaseInfo = preReleaseInfo;
        this.abiStability = abiStability;
    }

    public final kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass getBinaryClass() {
        return this.binaryClass;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource
    public java.lang.String getPresentableString() {
        return "Class '" + this.binaryClass.getClassId().asSingleFqName().asString() + com.taobao.weex.el.parse.Operators.SINGLE_QUOTE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.SourceElement
    public kotlin.reflect.jvm.internal.impl.descriptors.SourceFile getContainingFile() {
        kotlin.reflect.jvm.internal.impl.descriptors.SourceFile NO_SOURCE_FILE = kotlin.reflect.jvm.internal.impl.descriptors.SourceFile.NO_SOURCE_FILE;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(NO_SOURCE_FILE, "NO_SOURCE_FILE");
        return NO_SOURCE_FILE;
    }

    public java.lang.String toString() {
        return getClass().getSimpleName() + ": " + this.binaryClass;
    }
}
