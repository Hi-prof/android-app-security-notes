package kotlin.reflect.jvm.internal.impl.load.kotlin;

/* JADX INFO: compiled from: BinaryClassAnnotationAndConstantLoaderImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class BinaryClassAnnotationAndConstantLoaderImplKt {
    public static final kotlin.reflect.jvm.internal.impl.load.kotlin.BinaryClassAnnotationAndConstantLoaderImpl createBinaryClassAnnotationAndConstantLoader(kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor module, kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses notFoundClasses, kotlin.reflect.jvm.internal.impl.storage.StorageManager storageManager, kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder kotlinClassFinder, kotlin.reflect.jvm.internal.impl.metadata.deserialization.MetadataVersion metadataVersion) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(module, "module");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(notFoundClasses, "notFoundClasses");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinClassFinder, "kotlinClassFinder");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(metadataVersion, "metadataVersion");
        kotlin.reflect.jvm.internal.impl.load.kotlin.BinaryClassAnnotationAndConstantLoaderImpl binaryClassAnnotationAndConstantLoaderImpl = new kotlin.reflect.jvm.internal.impl.load.kotlin.BinaryClassAnnotationAndConstantLoaderImpl(module, notFoundClasses, storageManager, kotlinClassFinder);
        binaryClassAnnotationAndConstantLoaderImpl.setMetadataVersion(metadataVersion);
        return binaryClassAnnotationAndConstantLoaderImpl;
    }
}
