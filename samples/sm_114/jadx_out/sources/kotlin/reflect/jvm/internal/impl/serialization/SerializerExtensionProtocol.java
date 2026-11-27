package kotlin.reflect.jvm.internal.impl.serialization;

/* JADX INFO: compiled from: SerializerExtensionProtocol.kt */
/* JADX INFO: loaded from: classes2.dex */
public class SerializerExtensionProtocol {
    private final kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation>> classAnnotation;
    private final kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value> compileTimeValue;
    private final kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Constructor, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation>> constructorAnnotation;
    private final kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.EnumEntry, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation>> enumEntryAnnotation;
    private final kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite extensionRegistry;
    private final kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation>> functionAnnotation;
    private final kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation>> functionExtensionReceiverAnnotation;
    private final kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Package, java.lang.Integer> packageFqName;
    private final kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.ValueParameter, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation>> parameterAnnotation;
    private final kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation>> propertyAnnotation;
    private final kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation>> propertyBackingFieldAnnotation;
    private final kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation>> propertyDelegatedFieldAnnotation;
    private final kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation>> propertyExtensionReceiverAnnotation;
    private final kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation>> propertyGetterAnnotation;
    private final kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation>> propertySetterAnnotation;
    private final kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation>> typeAnnotation;
    private final kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation>> typeParameterAnnotation;

    public SerializerExtensionProtocol(kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite extensionRegistry, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Package, java.lang.Integer> packageFqName, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Constructor, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation>> constructorAnnotation, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation>> classAnnotation, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation>> functionAnnotation, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation>> generatedExtension, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation>> propertyAnnotation, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation>> propertyGetterAnnotation, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation>> propertySetterAnnotation, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation>> generatedExtension2, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation>> generatedExtension3, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation>> generatedExtension4, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.EnumEntry, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation>> enumEntryAnnotation, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value> compileTimeValue, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.ValueParameter, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation>> parameterAnnotation, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation>> typeAnnotation, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation>> typeParameterAnnotation) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(extensionRegistry, "extensionRegistry");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(packageFqName, "packageFqName");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(constructorAnnotation, "constructorAnnotation");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(classAnnotation, "classAnnotation");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(functionAnnotation, "functionAnnotation");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(propertyAnnotation, "propertyAnnotation");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(propertyGetterAnnotation, "propertyGetterAnnotation");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(propertySetterAnnotation, "propertySetterAnnotation");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(enumEntryAnnotation, "enumEntryAnnotation");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(compileTimeValue, "compileTimeValue");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(parameterAnnotation, "parameterAnnotation");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeAnnotation, "typeAnnotation");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeParameterAnnotation, "typeParameterAnnotation");
        this.extensionRegistry = extensionRegistry;
        this.packageFqName = packageFqName;
        this.constructorAnnotation = constructorAnnotation;
        this.classAnnotation = classAnnotation;
        this.functionAnnotation = functionAnnotation;
        this.functionExtensionReceiverAnnotation = generatedExtension;
        this.propertyAnnotation = propertyAnnotation;
        this.propertyGetterAnnotation = propertyGetterAnnotation;
        this.propertySetterAnnotation = propertySetterAnnotation;
        this.propertyExtensionReceiverAnnotation = generatedExtension2;
        this.propertyBackingFieldAnnotation = generatedExtension3;
        this.propertyDelegatedFieldAnnotation = generatedExtension4;
        this.enumEntryAnnotation = enumEntryAnnotation;
        this.compileTimeValue = compileTimeValue;
        this.parameterAnnotation = parameterAnnotation;
        this.typeAnnotation = typeAnnotation;
        this.typeParameterAnnotation = typeParameterAnnotation;
    }

    public final kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite getExtensionRegistry() {
        return this.extensionRegistry;
    }

    public final kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Constructor, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation>> getConstructorAnnotation() {
        return this.constructorAnnotation;
    }

    public final kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation>> getClassAnnotation() {
        return this.classAnnotation;
    }

    public final kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation>> getFunctionAnnotation() {
        return this.functionAnnotation;
    }

    public final kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation>> getFunctionExtensionReceiverAnnotation() {
        return this.functionExtensionReceiverAnnotation;
    }

    public final kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation>> getPropertyAnnotation() {
        return this.propertyAnnotation;
    }

    public final kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation>> getPropertyGetterAnnotation() {
        return this.propertyGetterAnnotation;
    }

    public final kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation>> getPropertySetterAnnotation() {
        return this.propertySetterAnnotation;
    }

    public final kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation>> getPropertyExtensionReceiverAnnotation() {
        return this.propertyExtensionReceiverAnnotation;
    }

    public final kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation>> getPropertyBackingFieldAnnotation() {
        return this.propertyBackingFieldAnnotation;
    }

    public final kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation>> getPropertyDelegatedFieldAnnotation() {
        return this.propertyDelegatedFieldAnnotation;
    }

    public final kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.EnumEntry, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation>> getEnumEntryAnnotation() {
        return this.enumEntryAnnotation;
    }

    public final kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value> getCompileTimeValue() {
        return this.compileTimeValue;
    }

    public final kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.ValueParameter, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation>> getParameterAnnotation() {
        return this.parameterAnnotation;
    }

    public final kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation>> getTypeAnnotation() {
        return this.typeAnnotation;
    }

    public final kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation>> getTypeParameterAnnotation() {
        return this.typeParameterAnnotation;
    }
}
