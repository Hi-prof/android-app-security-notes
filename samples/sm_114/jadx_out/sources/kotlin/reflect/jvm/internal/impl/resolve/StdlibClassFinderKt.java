package kotlin.reflect.jvm.internal.impl.resolve;

/* JADX INFO: compiled from: StdlibClassFinder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StdlibClassFinderKt {
    private static final kotlin.reflect.jvm.internal.impl.descriptors.ModuleCapability<kotlin.reflect.jvm.internal.impl.resolve.StdlibClassFinder> STDLIB_CLASS_FINDER_CAPABILITY = new kotlin.reflect.jvm.internal.impl.descriptors.ModuleCapability<>("StdlibClassFinder");

    public static final kotlin.reflect.jvm.internal.impl.resolve.StdlibClassFinder getStdlibClassFinder(kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor moduleDescriptor) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(moduleDescriptor, "<this>");
        kotlin.reflect.jvm.internal.impl.resolve.StdlibClassFinder stdlibClassFinder = (kotlin.reflect.jvm.internal.impl.resolve.StdlibClassFinder) moduleDescriptor.getCapability(STDLIB_CLASS_FINDER_CAPABILITY);
        return stdlibClassFinder == null ? kotlin.reflect.jvm.internal.impl.resolve.CliStdlibClassFinderImpl.INSTANCE : stdlibClassFinder;
    }
}
