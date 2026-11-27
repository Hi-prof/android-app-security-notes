package kotlin.reflect.jvm.internal.impl.types;

/* JADX INFO: compiled from: TypeAliasExpansion.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TypeAliasExpansion {
    public static final kotlin.reflect.jvm.internal.impl.types.TypeAliasExpansion.Companion Companion = new kotlin.reflect.jvm.internal.impl.types.TypeAliasExpansion.Companion(null);
    private final java.util.List<kotlin.reflect.jvm.internal.impl.types.TypeProjection> arguments;
    private final kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor descriptor;
    private final java.util.Map<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor, kotlin.reflect.jvm.internal.impl.types.TypeProjection> mapping;
    private final kotlin.reflect.jvm.internal.impl.types.TypeAliasExpansion parent;

    public /* synthetic */ TypeAliasExpansion(kotlin.reflect.jvm.internal.impl.types.TypeAliasExpansion typeAliasExpansion, kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor typeAliasDescriptor, java.util.List list, java.util.Map map, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(typeAliasExpansion, typeAliasDescriptor, list, map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private TypeAliasExpansion(kotlin.reflect.jvm.internal.impl.types.TypeAliasExpansion typeAliasExpansion, kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor typeAliasDescriptor, java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.TypeProjection> list, java.util.Map<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor, ? extends kotlin.reflect.jvm.internal.impl.types.TypeProjection> map) {
        this.parent = typeAliasExpansion;
        this.descriptor = typeAliasDescriptor;
        this.arguments = list;
        this.mapping = map;
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor getDescriptor() {
        return this.descriptor;
    }

    public final java.util.List<kotlin.reflect.jvm.internal.impl.types.TypeProjection> getArguments() {
        return this.arguments;
    }

    public final kotlin.reflect.jvm.internal.impl.types.TypeProjection getReplacement(kotlin.reflect.jvm.internal.impl.types.TypeConstructor constructor) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(constructor, "constructor");
        kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptorMo1835getDeclarationDescriptor = constructor.mo1835getDeclarationDescriptor();
        if (classifierDescriptorMo1835getDeclarationDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) {
            return this.mapping.get(classifierDescriptorMo1835getDeclarationDescriptor);
        }
        return null;
    }

    public final boolean isRecursion(kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor descriptor) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (kotlin.jvm.internal.Intrinsics.areEqual(this.descriptor, descriptor)) {
            return true;
        }
        kotlin.reflect.jvm.internal.impl.types.TypeAliasExpansion typeAliasExpansion = this.parent;
        return typeAliasExpansion != null ? typeAliasExpansion.isRecursion(descriptor) : false;
    }

    /* JADX INFO: compiled from: TypeAliasExpansion.kt */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final kotlin.reflect.jvm.internal.impl.types.TypeAliasExpansion create(kotlin.reflect.jvm.internal.impl.types.TypeAliasExpansion typeAliasExpansion, kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor typeAliasDescriptor, java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.TypeProjection> arguments) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeAliasDescriptor, "typeAliasDescriptor");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(arguments, "arguments");
            java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> parameters = typeAliasDescriptor.getTypeConstructor().getParameters();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(parameters, "getParameters(...)");
            java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> list = parameters;
            java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(list, 10));
            java.util.Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) it.next()).getOriginal());
            }
            return new kotlin.reflect.jvm.internal.impl.types.TypeAliasExpansion(typeAliasExpansion, typeAliasDescriptor, arguments, kotlin.collections.MapsKt.toMap(kotlin.collections.CollectionsKt.zip(arrayList, arguments)), null);
        }
    }
}
