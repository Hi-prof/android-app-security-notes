package kotlin.reflect.jvm.internal.impl.resolve;

/* JADX INFO: compiled from: ResolutionAnchorProvider.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ResolutionAnchorProviderKt {
    private static final kotlin.reflect.jvm.internal.impl.descriptors.ModuleCapability<kotlin.reflect.jvm.internal.impl.resolve.ResolutionAnchorProvider> RESOLUTION_ANCHOR_PROVIDER_CAPABILITY = new kotlin.reflect.jvm.internal.impl.descriptors.ModuleCapability<>("ResolutionAnchorProvider");

    public static final kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor getResolutionAnchorIfAny(kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor moduleDescriptor) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(moduleDescriptor, "<this>");
        kotlin.reflect.jvm.internal.impl.resolve.ResolutionAnchorProvider resolutionAnchorProvider = (kotlin.reflect.jvm.internal.impl.resolve.ResolutionAnchorProvider) moduleDescriptor.getCapability(RESOLUTION_ANCHOR_PROVIDER_CAPABILITY);
        if (resolutionAnchorProvider != null) {
            return resolutionAnchorProvider.getResolutionAnchor(moduleDescriptor);
        }
        return null;
    }
}
