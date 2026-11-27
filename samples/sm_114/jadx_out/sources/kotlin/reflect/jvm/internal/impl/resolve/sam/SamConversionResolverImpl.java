package kotlin.reflect.jvm.internal.impl.resolve.sam;

/* JADX INFO: compiled from: SamConversionResolverImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SamConversionResolverImpl implements kotlin.reflect.jvm.internal.impl.resolve.sam.SamConversionResolver {
    private final kotlin.reflect.jvm.internal.impl.storage.CacheWithNullableValues<kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.types.SimpleType> functionTypesForSamInterfaces;
    private final java.lang.Iterable<java.lang.Object> samWithReceiverResolvers;

    public SamConversionResolverImpl(kotlin.reflect.jvm.internal.impl.storage.StorageManager storageManager, java.lang.Iterable<? extends java.lang.Object> samWithReceiverResolvers) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(samWithReceiverResolvers, "samWithReceiverResolvers");
        this.samWithReceiverResolvers = samWithReceiverResolvers;
        this.functionTypesForSamInterfaces = storageManager.createCacheWithNullableValues();
    }
}
