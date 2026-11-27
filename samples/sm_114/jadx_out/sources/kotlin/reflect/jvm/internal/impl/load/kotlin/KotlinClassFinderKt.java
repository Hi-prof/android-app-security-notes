package kotlin.reflect.jvm.internal.impl.load.kotlin;

/* JADX INFO: compiled from: KotlinClassFinder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class KotlinClassFinderKt {
    public static final kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass findKotlinClass(kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder kotlinClassFinder, kotlin.reflect.jvm.internal.impl.name.ClassId classId, kotlin.reflect.jvm.internal.impl.metadata.deserialization.MetadataVersion metadataVersion) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinClassFinder, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(classId, "classId");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(metadataVersion, "metadataVersion");
        kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder.Result resultFindKotlinClassOrContent = kotlinClassFinder.findKotlinClassOrContent(classId, metadataVersion);
        if (resultFindKotlinClassOrContent != null) {
            return resultFindKotlinClassOrContent.toKotlinJvmBinaryClass();
        }
        return null;
    }

    public static final kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass findKotlinClass(kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder kotlinClassFinder, kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass javaClass, kotlin.reflect.jvm.internal.impl.metadata.deserialization.MetadataVersion metadataVersion) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinClassFinder, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(javaClass, "javaClass");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(metadataVersion, "metadataVersion");
        kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder.Result resultFindKotlinClassOrContent = kotlinClassFinder.findKotlinClassOrContent(javaClass, metadataVersion);
        if (resultFindKotlinClassOrContent != null) {
            return resultFindKotlinClassOrContent.toKotlinJvmBinaryClass();
        }
        return null;
    }
}
