package kotlin.reflect.jvm.internal.impl.load.kotlin;

/* JADX INFO: compiled from: methodSignatureBuildingUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MethodSignatureBuildingUtilsKt {
    public static final java.lang.String signature(kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents signatureBuildingComponents, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor, java.lang.String jvmDescriptor) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(signatureBuildingComponents, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(classDescriptor, "classDescriptor");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(jvmDescriptor, "jvmDescriptor");
        return signatureBuildingComponents.signature(kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt.getInternalName(classDescriptor), jvmDescriptor);
    }
}
