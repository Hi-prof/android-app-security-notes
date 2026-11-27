package kotlin.reflect.jvm.internal.impl.builtins;

/* JADX INFO: compiled from: CompanionObjectMappingUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CompanionObjectMappingUtilsKt {
    public static final boolean isMappedIntrinsicCompanionObject(kotlin.reflect.jvm.internal.impl.builtins.CompanionObjectMapping companionObjectMapping, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(companionObjectMapping, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(classDescriptor, "classDescriptor");
        if (!kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.isCompanionObject(classDescriptor)) {
            return false;
        }
        java.util.Set<kotlin.reflect.jvm.internal.impl.name.ClassId> classIds = companionObjectMapping.getClassIds();
        kotlin.reflect.jvm.internal.impl.name.ClassId classId = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getClassId(classDescriptor);
        return kotlin.collections.CollectionsKt.contains(classIds, classId != null ? classId.getOuterClassId() : null);
    }
}
