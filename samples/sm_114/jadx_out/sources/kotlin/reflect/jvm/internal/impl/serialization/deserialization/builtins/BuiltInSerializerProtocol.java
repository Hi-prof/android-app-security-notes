package kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins;

/* JADX INFO: compiled from: BuiltInSerializerProtocol.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class BuiltInSerializerProtocol extends kotlin.reflect.jvm.internal.impl.serialization.SerializerExtensionProtocol {
    public static final kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.BuiltInSerializerProtocol INSTANCE = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.BuiltInSerializerProtocol();

    /* JADX WARN: Illegal instructions before constructor call */
    private BuiltInSerializerProtocol() {
        kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite extensionRegistryLiteNewInstance = kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite.newInstance();
        kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsProtoBuf.registerAllExtensions(extensionRegistryLiteNewInstance);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(extensionRegistryLiteNewInstance, "apply(...)");
        kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Package, java.lang.Integer> packageFqName = kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsProtoBuf.packageFqName;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(packageFqName, "packageFqName");
        kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Constructor, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation>> constructorAnnotation = kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsProtoBuf.constructorAnnotation;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(constructorAnnotation, "constructorAnnotation");
        kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation>> classAnnotation = kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsProtoBuf.classAnnotation;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(classAnnotation, "classAnnotation");
        kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation>> functionAnnotation = kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsProtoBuf.functionAnnotation;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(functionAnnotation, "functionAnnotation");
        kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation>> propertyAnnotation = kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsProtoBuf.propertyAnnotation;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(propertyAnnotation, "propertyAnnotation");
        kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation>> propertyGetterAnnotation = kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsProtoBuf.propertyGetterAnnotation;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(propertyGetterAnnotation, "propertyGetterAnnotation");
        kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation>> propertySetterAnnotation = kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsProtoBuf.propertySetterAnnotation;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(propertySetterAnnotation, "propertySetterAnnotation");
        kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.EnumEntry, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation>> enumEntryAnnotation = kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsProtoBuf.enumEntryAnnotation;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(enumEntryAnnotation, "enumEntryAnnotation");
        kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value> compileTimeValue = kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsProtoBuf.compileTimeValue;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(compileTimeValue, "compileTimeValue");
        kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.ValueParameter, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation>> parameterAnnotation = kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsProtoBuf.parameterAnnotation;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(parameterAnnotation, "parameterAnnotation");
        kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation>> typeAnnotation = kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsProtoBuf.typeAnnotation;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(typeAnnotation, "typeAnnotation");
        kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation>> typeParameterAnnotation = kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsProtoBuf.typeParameterAnnotation;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(typeParameterAnnotation, "typeParameterAnnotation");
        super(extensionRegistryLiteNewInstance, packageFqName, constructorAnnotation, classAnnotation, functionAnnotation, null, propertyAnnotation, propertyGetterAnnotation, propertySetterAnnotation, null, null, null, enumEntryAnnotation, compileTimeValue, parameterAnnotation, typeAnnotation, typeParameterAnnotation);
    }

    public final java.lang.String getBuiltInsFilePath(kotlin.reflect.jvm.internal.impl.name.FqName fqName) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fqName, "fqName");
        return kotlin.text.StringsKt.replace$default(fqName.asString(), com.taobao.weex.el.parse.Operators.DOT, '/', false, 4, (java.lang.Object) null) + '/' + getBuiltInsFileName(fqName);
    }

    public final java.lang.String getBuiltInsFileName(kotlin.reflect.jvm.internal.impl.name.FqName fqName) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fqName, "fqName");
        return shortName(fqName) + ".kotlin_builtins";
    }

    private final java.lang.String shortName(kotlin.reflect.jvm.internal.impl.name.FqName fqName) {
        if (fqName.isRoot()) {
            return "default-package";
        }
        java.lang.String strAsString = fqName.shortName().asString();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strAsString, "asString(...)");
        return strAsString;
    }
}
