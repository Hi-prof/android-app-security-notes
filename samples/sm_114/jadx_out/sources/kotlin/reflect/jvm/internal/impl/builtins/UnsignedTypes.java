package kotlin.reflect.jvm.internal.impl.builtins;

/* JADX INFO: compiled from: UnsignedType.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class UnsignedTypes {
    public static final kotlin.reflect.jvm.internal.impl.builtins.UnsignedTypes INSTANCE = new kotlin.reflect.jvm.internal.impl.builtins.UnsignedTypes();
    private static final java.util.HashMap<kotlin.reflect.jvm.internal.impl.name.ClassId, kotlin.reflect.jvm.internal.impl.name.ClassId> arrayClassIdToUnsignedClassId;
    private static final java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> arrayClassesShortNames;
    private static final java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> unsignedArrayTypeNames;
    private static final java.util.HashMap<kotlin.reflect.jvm.internal.impl.builtins.UnsignedArrayType, kotlin.reflect.jvm.internal.impl.name.Name> unsignedArrayTypeToArrayCall;
    private static final java.util.HashMap<kotlin.reflect.jvm.internal.impl.name.ClassId, kotlin.reflect.jvm.internal.impl.name.ClassId> unsignedClassIdToArrayClassId;
    private static final java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> unsignedTypeNames;

    private UnsignedTypes() {
    }

    static {
        kotlin.reflect.jvm.internal.impl.builtins.UnsignedType[] unsignedTypeArrValues = kotlin.reflect.jvm.internal.impl.builtins.UnsignedType.values();
        java.util.ArrayList arrayList = new java.util.ArrayList(unsignedTypeArrValues.length);
        for (kotlin.reflect.jvm.internal.impl.builtins.UnsignedType unsignedType : unsignedTypeArrValues) {
            arrayList.add(unsignedType.getTypeName());
        }
        unsignedTypeNames = kotlin.collections.CollectionsKt.toSet(arrayList);
        kotlin.reflect.jvm.internal.impl.builtins.UnsignedArrayType[] unsignedArrayTypeArrValues = kotlin.reflect.jvm.internal.impl.builtins.UnsignedArrayType.values();
        java.util.ArrayList arrayList2 = new java.util.ArrayList(unsignedArrayTypeArrValues.length);
        for (kotlin.reflect.jvm.internal.impl.builtins.UnsignedArrayType unsignedArrayType : unsignedArrayTypeArrValues) {
            arrayList2.add(unsignedArrayType.getTypeName());
        }
        unsignedArrayTypeNames = kotlin.collections.CollectionsKt.toSet(arrayList2);
        arrayClassIdToUnsignedClassId = new java.util.HashMap<>();
        unsignedClassIdToArrayClassId = new java.util.HashMap<>();
        unsignedArrayTypeToArrayCall = kotlin.collections.MapsKt.hashMapOf(kotlin.TuplesKt.to(kotlin.reflect.jvm.internal.impl.builtins.UnsignedArrayType.UBYTEARRAY, kotlin.reflect.jvm.internal.impl.name.Name.identifier("ubyteArrayOf")), kotlin.TuplesKt.to(kotlin.reflect.jvm.internal.impl.builtins.UnsignedArrayType.USHORTARRAY, kotlin.reflect.jvm.internal.impl.name.Name.identifier("ushortArrayOf")), kotlin.TuplesKt.to(kotlin.reflect.jvm.internal.impl.builtins.UnsignedArrayType.UINTARRAY, kotlin.reflect.jvm.internal.impl.name.Name.identifier("uintArrayOf")), kotlin.TuplesKt.to(kotlin.reflect.jvm.internal.impl.builtins.UnsignedArrayType.ULONGARRAY, kotlin.reflect.jvm.internal.impl.name.Name.identifier("ulongArrayOf")));
        kotlin.reflect.jvm.internal.impl.builtins.UnsignedType[] unsignedTypeArrValues2 = kotlin.reflect.jvm.internal.impl.builtins.UnsignedType.values();
        java.util.LinkedHashSet linkedHashSet = new java.util.LinkedHashSet();
        for (kotlin.reflect.jvm.internal.impl.builtins.UnsignedType unsignedType2 : unsignedTypeArrValues2) {
            linkedHashSet.add(unsignedType2.getArrayClassId().getShortClassName());
        }
        arrayClassesShortNames = linkedHashSet;
        for (kotlin.reflect.jvm.internal.impl.builtins.UnsignedType unsignedType3 : kotlin.reflect.jvm.internal.impl.builtins.UnsignedType.values()) {
            arrayClassIdToUnsignedClassId.put(unsignedType3.getArrayClassId(), unsignedType3.getClassId());
            unsignedClassIdToArrayClassId.put(unsignedType3.getClassId(), unsignedType3.getArrayClassId());
        }
    }

    public final boolean isShortNameOfUnsignedArray(kotlin.reflect.jvm.internal.impl.name.Name name) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        return arrayClassesShortNames.contains(name);
    }

    public final kotlin.reflect.jvm.internal.impl.name.ClassId getUnsignedClassIdByArrayClassId(kotlin.reflect.jvm.internal.impl.name.ClassId arrayClassId) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(arrayClassId, "arrayClassId");
        return arrayClassIdToUnsignedClassId.get(arrayClassId);
    }

    @kotlin.jvm.JvmStatic
    public static final boolean isUnsignedType(kotlin.reflect.jvm.internal.impl.types.KotlinType type) {
        kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptorMo1835getDeclarationDescriptor;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(type, "type");
        if (kotlin.reflect.jvm.internal.impl.types.TypeUtils.noExpectedType(type) || (classifierDescriptorMo1835getDeclarationDescriptor = type.getConstructor().mo1835getDeclarationDescriptor()) == null) {
            return false;
        }
        return INSTANCE.isUnsignedClass(classifierDescriptorMo1835getDeclarationDescriptor);
    }

    public final boolean isUnsignedClass(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor descriptor) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor containingDeclaration = descriptor.getContainingDeclaration();
        return (containingDeclaration instanceof kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor) && kotlin.jvm.internal.Intrinsics.areEqual(((kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor) containingDeclaration).getFqName(), kotlin.reflect.jvm.internal.impl.builtins.StandardNames.BUILT_INS_PACKAGE_FQ_NAME) && unsignedTypeNames.contains(descriptor.getName());
    }
}
