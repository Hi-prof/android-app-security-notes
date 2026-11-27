package kotlin.reflect.jvm.internal.impl.descriptors;

/* JADX INFO: compiled from: DescriptorVisibility.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class DelegatedDescriptorVisibility extends kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility {
    private final kotlin.reflect.jvm.internal.impl.descriptors.Visibility delegate;

    public DelegatedDescriptorVisibility(kotlin.reflect.jvm.internal.impl.descriptors.Visibility delegate) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility
    public kotlin.reflect.jvm.internal.impl.descriptors.Visibility getDelegate() {
        return this.delegate;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility
    public java.lang.String getInternalDisplayName() {
        return getDelegate().getInternalDisplayName();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility
    public kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility normalize() {
        kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility descriptorVisibility = kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.toDescriptorVisibility(getDelegate().normalize());
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(descriptorVisibility, "toDescriptorVisibility(...)");
        return descriptorVisibility;
    }
}
