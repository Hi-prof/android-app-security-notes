package kotlin.reflect.jvm.internal.impl.load.java;

/* JADX INFO: compiled from: utils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DeprecationCausedByFunctionNInfo extends kotlin.reflect.jvm.internal.impl.resolve.deprecation.DescriptorBasedDeprecationInfo {
    private final kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor target;

    public DeprecationCausedByFunctionNInfo(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor target) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(target, "target");
        this.target = target;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.deprecation.DeprecationInfo
    public kotlin.reflect.jvm.internal.impl.resolve.deprecation.DeprecationLevelValue getDeprecationLevel() {
        return kotlin.reflect.jvm.internal.impl.resolve.deprecation.DeprecationLevelValue.ERROR;
    }
}
