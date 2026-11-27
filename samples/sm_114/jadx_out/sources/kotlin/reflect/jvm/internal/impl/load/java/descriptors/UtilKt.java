package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

/* JADX INFO: compiled from: util.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class UtilKt {
    public static final java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> copyValueParameters(java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.types.KotlinType> newValueParameterTypes, java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> oldValueParameters, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor newOwner) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(newValueParameterTypes, "newValueParameterTypes");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(oldValueParameters, "oldValueParameters");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(newOwner, "newOwner");
        newValueParameterTypes.size();
        oldValueParameters.size();
        java.util.List<kotlin.Pair> listZip = kotlin.collections.CollectionsKt.zip(newValueParameterTypes, oldValueParameters);
        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(listZip, 10));
        for (kotlin.Pair pair : listZip) {
            kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType = (kotlin.reflect.jvm.internal.impl.types.KotlinType) pair.component1();
            kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor valueParameterDescriptor = (kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) pair.component2();
            int index = valueParameterDescriptor.getIndex();
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations annotations = valueParameterDescriptor.getAnnotations();
            kotlin.reflect.jvm.internal.impl.name.Name name = valueParameterDescriptor.getName();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            boolean zDeclaresDefaultValue = valueParameterDescriptor.declaresDefaultValue();
            boolean zIsCrossinline = valueParameterDescriptor.isCrossinline();
            boolean zIsNoinline = valueParameterDescriptor.isNoinline();
            kotlin.reflect.jvm.internal.impl.types.KotlinType arrayElementType = valueParameterDescriptor.getVarargElementType() != null ? kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getModule(newOwner).getBuiltIns().getArrayElementType(kotlinType) : null;
            kotlin.reflect.jvm.internal.impl.descriptors.SourceElement source = valueParameterDescriptor.getSource();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(source, "getSource(...)");
            arrayList.add(new kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl(newOwner, null, index, annotations, name, kotlinType, zDeclaresDefaultValue, zIsCrossinline, zIsNoinline, arrayElementType, source));
        }
        return arrayList;
    }

    public static final kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticClassScope getParentJavaStaticClassScope(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(classDescriptor, "<this>");
        kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor superClassNotAny = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getSuperClassNotAny(classDescriptor);
        if (superClassNotAny == null) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope staticScope = superClassNotAny.getStaticScope();
        kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticClassScope lazyJavaStaticClassScope = staticScope instanceof kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticClassScope ? (kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticClassScope) staticScope : null;
        return lazyJavaStaticClassScope == null ? getParentJavaStaticClassScope(superClassNotAny) : lazyJavaStaticClassScope;
    }
}
