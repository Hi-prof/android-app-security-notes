package kotlin.reflect.jvm.internal.impl.resolve;

/* JADX INFO: compiled from: VisibilityUtil.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class VisibilityUtilKt {
    public static final kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor findMemberWithMaxVisibility(java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor> descriptors) {
        java.lang.Integer numCompare;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(descriptors, "descriptors");
        descriptors.isEmpty();
        kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor callableMemberDescriptor = null;
        for (kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor callableMemberDescriptor2 : descriptors) {
            if (callableMemberDescriptor == null || ((numCompare = kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.compare(callableMemberDescriptor.getVisibility(), callableMemberDescriptor2.getVisibility())) != null && numCompare.intValue() < 0)) {
                callableMemberDescriptor = callableMemberDescriptor2;
            }
        }
        kotlin.jvm.internal.Intrinsics.checkNotNull(callableMemberDescriptor);
        return callableMemberDescriptor;
    }
}
