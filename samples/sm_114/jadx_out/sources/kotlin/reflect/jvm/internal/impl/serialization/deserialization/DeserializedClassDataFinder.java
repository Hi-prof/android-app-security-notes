package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

/* JADX INFO: compiled from: DeserializedClassDataFinder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DeserializedClassDataFinder implements kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDataFinder {
    private final kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider packageFragmentProvider;

    public DeserializedClassDataFinder(kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider packageFragmentProvider) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(packageFragmentProvider, "packageFragmentProvider");
        this.packageFragmentProvider = packageFragmentProvider;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDataFinder
    public kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassData findClassData(kotlin.reflect.jvm.internal.impl.name.ClassId classId) {
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassData classDataFindClassData;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(classId, "classId");
        for (kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor packageFragmentDescriptor : kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderKt.packageFragments(this.packageFragmentProvider, classId.getPackageFqName())) {
            if ((packageFragmentDescriptor instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedPackageFragment) && (classDataFindClassData = ((kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedPackageFragment) packageFragmentDescriptor).getClassDataFinder().findClassData(classId)) != null) {
                return classDataFindClassData;
            }
        }
        return null;
    }
}
