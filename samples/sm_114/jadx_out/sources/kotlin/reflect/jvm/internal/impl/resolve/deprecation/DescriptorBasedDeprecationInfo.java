package kotlin.reflect.jvm.internal.impl.resolve.deprecation;

/* JADX INFO: compiled from: DescriptorBasedDeprecationInfo.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class DescriptorBasedDeprecationInfo extends kotlin.reflect.jvm.internal.impl.resolve.deprecation.DeprecationInfo {
    public boolean getForcePropagationToOverrides() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.deprecation.DeprecationInfo
    public boolean getPropagatesToOverrides() {
        return getForcePropagationToOverrides();
    }
}
