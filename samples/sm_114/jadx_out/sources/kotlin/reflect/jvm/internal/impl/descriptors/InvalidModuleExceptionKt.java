package kotlin.reflect.jvm.internal.impl.descriptors;

/* JADX INFO: compiled from: InvalidModuleException.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class InvalidModuleExceptionKt {
    private static final kotlin.reflect.jvm.internal.impl.descriptors.ModuleCapability<kotlin.reflect.jvm.internal.impl.descriptors.InvalidModuleNotifier> INVALID_MODULE_NOTIFIER_CAPABILITY = new kotlin.reflect.jvm.internal.impl.descriptors.ModuleCapability<>("InvalidModuleNotifier");

    public static final void moduleInvalidated(kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor moduleDescriptor) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(moduleDescriptor, "<this>");
        kotlin.reflect.jvm.internal.impl.descriptors.InvalidModuleNotifier invalidModuleNotifier = (kotlin.reflect.jvm.internal.impl.descriptors.InvalidModuleNotifier) moduleDescriptor.getCapability(INVALID_MODULE_NOTIFIER_CAPABILITY);
        if (invalidModuleNotifier != null) {
            invalidModuleNotifier.notifyModuleInvalidated(moduleDescriptor);
        } else {
            throw new kotlin.reflect.jvm.internal.impl.descriptors.InvalidModuleException("Accessing invalid module descriptor " + moduleDescriptor);
        }
    }
}
