package kotlin.reflect.jvm.internal.impl.load.kotlin;

/* JADX INFO: compiled from: JvmPackagePartSource.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class JvmPackagePartSource implements kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource {
    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerAbiStability abiStability;
    private final kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName className;
    private final kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName facadeClassName;
    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.IncompatibleVersionErrorData<kotlin.reflect.jvm.internal.impl.metadata.deserialization.MetadataVersion> incompatibility;
    private final kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass knownJvmBinaryClass;
    private final java.lang.String moduleName;
    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.PreReleaseInfo preReleaseInfo;

    public JvmPackagePartSource(kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName className, kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName jvmClassName, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Package packageProto, kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver nameResolver, kotlin.reflect.jvm.internal.impl.serialization.deserialization.IncompatibleVersionErrorData<kotlin.reflect.jvm.internal.impl.metadata.deserialization.MetadataVersion> incompatibleVersionErrorData, kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.PreReleaseInfo preReleaseInfo, kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerAbiStability abiStability, kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        java.lang.String string;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(className, "className");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(packageProto, "packageProto");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(preReleaseInfo, "preReleaseInfo");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(abiStability, "abiStability");
        this.className = className;
        this.facadeClassName = jvmClassName;
        this.incompatibility = incompatibleVersionErrorData;
        this.preReleaseInfo = preReleaseInfo;
        this.abiStability = abiStability;
        this.knownJvmBinaryClass = kotlinJvmBinaryClass;
        kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Package, java.lang.Integer> packageModuleName = kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.packageModuleName;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(packageModuleName, "packageModuleName");
        java.lang.Integer num = (java.lang.Integer) kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt.getExtensionOrNull(packageProto, packageModuleName);
        this.moduleName = (num == null || (string = nameResolver.getString(num.intValue())) == null) ? "main" : string;
    }

    public kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName getClassName() {
        return this.className;
    }

    public kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName getFacadeClassName() {
        return this.facadeClassName;
    }

    public final kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass getKnownJvmBinaryClass() {
        return this.knownJvmBinaryClass;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public JvmPackagePartSource(kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass kotlinClass, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Package packageProto, kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver nameResolver, kotlin.reflect.jvm.internal.impl.serialization.deserialization.IncompatibleVersionErrorData<kotlin.reflect.jvm.internal.impl.metadata.deserialization.MetadataVersion> incompatibleVersionErrorData, boolean z, kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerAbiStability abiStability) {
        kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName jvmClassNameByInternalName;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinClass, "kotlinClass");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(packageProto, "packageProto");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(abiStability, "abiStability");
        kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName jvmClassNameByClassId = kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName.byClassId(kotlinClass.getClassId());
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(jvmClassNameByClassId, "byClassId(...)");
        java.lang.String multifileClassName = kotlinClass.getClassHeader().getMultifileClassName();
        if (multifileClassName != null) {
            jvmClassNameByInternalName = multifileClassName.length() > 0 ? kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName.byInternalName(multifileClassName) : null;
        } else {
            jvmClassNameByInternalName = null;
        }
        this(jvmClassNameByClassId, jvmClassNameByInternalName, packageProto, nameResolver, incompatibleVersionErrorData, new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.PreReleaseInfo(z, null, 2, null), abiStability, kotlinClass);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource
    public java.lang.String getPresentableString() {
        return "Class '" + getClassId().asSingleFqName().asString() + com.taobao.weex.el.parse.Operators.SINGLE_QUOTE;
    }

    public final kotlin.reflect.jvm.internal.impl.name.Name getSimpleName() {
        java.lang.String internalName = getClassName().getInternalName();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(internalName, "getInternalName(...)");
        kotlin.reflect.jvm.internal.impl.name.Name nameIdentifier = kotlin.reflect.jvm.internal.impl.name.Name.identifier(kotlin.text.StringsKt.substringAfterLast$default(internalName, '/', (java.lang.String) null, 2, (java.lang.Object) null));
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameIdentifier, "identifier(...)");
        return nameIdentifier;
    }

    public final kotlin.reflect.jvm.internal.impl.name.ClassId getClassId() {
        kotlin.reflect.jvm.internal.impl.name.FqName packageFqName = getClassName().getPackageFqName();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(packageFqName, "getPackageFqName(...)");
        return new kotlin.reflect.jvm.internal.impl.name.ClassId(packageFqName, getSimpleName());
    }

    public java.lang.String toString() {
        return getClass().getSimpleName() + ": " + getClassName();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.SourceElement
    public kotlin.reflect.jvm.internal.impl.descriptors.SourceFile getContainingFile() {
        kotlin.reflect.jvm.internal.impl.descriptors.SourceFile NO_SOURCE_FILE = kotlin.reflect.jvm.internal.impl.descriptors.SourceFile.NO_SOURCE_FILE;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(NO_SOURCE_FILE, "NO_SOURCE_FILE");
        return NO_SOURCE_FILE;
    }
}
