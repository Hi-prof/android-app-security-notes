package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

/* JADX INFO: compiled from: ReflectKotlinClassFinder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ReflectKotlinClassFinder implements kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder {
    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.BuiltInsResourceLoader builtInsResourceLoader;
    private final java.lang.ClassLoader classLoader;

    public ReflectKotlinClassFinder(java.lang.ClassLoader classLoader) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(classLoader, "classLoader");
        this.classLoader = classLoader;
        this.builtInsResourceLoader = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.BuiltInsResourceLoader();
    }

    private final kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder.Result findKotlinClass(java.lang.String str) {
        kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass reflectKotlinClassCreate;
        java.lang.Class<?> clsTryLoadClass = kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectJavaClassFinderKt.tryLoadClass(this.classLoader, str);
        kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder.Result.KotlinClass kotlinClass = null;
        if (clsTryLoadClass != null && (reflectKotlinClassCreate = kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass.Factory.create(clsTryLoadClass)) != null) {
            kotlinClass = new kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder.Result.KotlinClass(reflectKotlinClassCreate, null, 2, null);
        }
        return kotlinClass;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder
    public kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder.Result findKotlinClassOrContent(kotlin.reflect.jvm.internal.impl.name.ClassId classId, kotlin.reflect.jvm.internal.impl.metadata.deserialization.MetadataVersion metadataVersion) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(classId, "classId");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(metadataVersion, "metadataVersion");
        return findKotlinClass(kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClassFinderKt.toRuntimeFqName(classId));
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder
    public kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder.Result findKotlinClassOrContent(kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass javaClass, kotlin.reflect.jvm.internal.impl.metadata.deserialization.MetadataVersion metadataVersion) {
        java.lang.String strAsString;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(javaClass, "javaClass");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(metadataVersion, "metadataVersion");
        kotlin.reflect.jvm.internal.impl.name.FqName fqName = javaClass.getFqName();
        if (fqName == null || (strAsString = fqName.asString()) == null) {
            return null;
        }
        return findKotlinClass(strAsString);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.KotlinMetadataFinder
    public java.io.InputStream findBuiltInsData(kotlin.reflect.jvm.internal.impl.name.FqName packageFqName) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(packageFqName, "packageFqName");
        if (packageFqName.startsWith(kotlin.reflect.jvm.internal.impl.builtins.StandardNames.BUILT_INS_PACKAGE_NAME)) {
            return this.builtInsResourceLoader.loadResource(kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.BuiltInSerializerProtocol.INSTANCE.getBuiltInsFilePath(packageFqName));
        }
        return null;
    }
}
