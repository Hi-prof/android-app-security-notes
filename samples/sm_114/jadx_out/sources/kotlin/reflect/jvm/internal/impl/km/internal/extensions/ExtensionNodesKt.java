package kotlin.reflect.jvm.internal.impl.km.internal.extensions;

/* JADX INFO: compiled from: ExtensionNodes.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ExtensionNodesKt {
    public static final kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmClassExtension getExtension(kotlin.reflect.jvm.internal.impl.km.KmClass kmClass, kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmExtensionType type) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kmClass, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(type, "type");
        return (kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmClassExtension) singleOfType(kmClass.getExtensions$kotlin_metadata(), type);
    }

    public static final kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmPackageExtension getExtension(kotlin.reflect.jvm.internal.impl.km.KmPackage kmPackage, kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmExtensionType type) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kmPackage, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(type, "type");
        return (kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmPackageExtension) singleOfType(kmPackage.getExtensions$kotlin_metadata(), type);
    }

    public static final kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmFunctionExtension getExtension(kotlin.reflect.jvm.internal.impl.km.KmFunction kmFunction, kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmExtensionType type) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kmFunction, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(type, "type");
        return (kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmFunctionExtension) singleOfType(kmFunction.getExtensions$kotlin_metadata(), type);
    }

    public static final kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmPropertyExtension getExtension(kotlin.reflect.jvm.internal.impl.km.KmProperty kmProperty, kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmExtensionType type) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kmProperty, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(type, "type");
        return (kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmPropertyExtension) singleOfType(kmProperty.getExtensions$kotlin_metadata(), type);
    }

    public static final kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmConstructorExtension getExtension(kotlin.reflect.jvm.internal.impl.km.KmConstructor kmConstructor, kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmExtensionType type) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kmConstructor, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(type, "type");
        return (kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmConstructorExtension) singleOfType(kmConstructor.getExtensions$kotlin_metadata(), type);
    }

    public static final kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmTypeParameterExtension getExtension(kotlin.reflect.jvm.internal.impl.km.KmTypeParameter kmTypeParameter, kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmExtensionType type) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kmTypeParameter, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(type, "type");
        return (kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmTypeParameterExtension) singleOfType(kmTypeParameter.getExtensions$kotlin_metadata(), type);
    }

    public static final kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmTypeExtension getExtension(kotlin.reflect.jvm.internal.impl.km.KmType kmType, kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmExtensionType type) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kmType, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(type, "type");
        return (kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmTypeExtension) singleOfType(kmType.getExtensions$kotlin_metadata(), type);
    }

    private static final <N extends kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmExtension> N singleOfType(java.util.Collection<? extends N> collection, kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmExtensionType kmExtensionType) {
        N n = null;
        for (N n2 : collection) {
            if (kotlin.jvm.internal.Intrinsics.areEqual(n2.getType(), kmExtensionType)) {
                if (n != null) {
                    throw new java.lang.IllegalStateException("Multiple extensions handle the same extension type: " + kmExtensionType);
                }
                n = n2;
            }
        }
        if (n != null) {
            return n;
        }
        throw new java.lang.IllegalStateException("No extensions handle the extension type: " + kmExtensionType);
    }
}
