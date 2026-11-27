package kotlin.reflect.jvm.internal;

/* JADX INFO: compiled from: RuntimeTypeMapper.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0004\u0006\u0007\b\tB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&\u0082\u0001\u0004\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "", "<init>", "()V", "asString", "", "KotlinProperty", "JavaMethodProperty", "JavaField", "MappedKotlinProperty", "Lkotlin/reflect/jvm/internal/JvmPropertySignature$JavaField;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature$JavaMethodProperty;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature$KotlinProperty;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature$MappedKotlinProperty;", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class JvmPropertySignature {
    public /* synthetic */ JvmPropertySignature(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: renamed from: asString */
    public abstract java.lang.String getString();

    private JvmPropertySignature() {
    }

    /* JADX INFO: compiled from: RuntimeTypeMapper.kt */
    @kotlin.Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u001a\u001a\u00020\u0019H\u0002J\b\u0010\u001b\u001a\u00020\u0019H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lkotlin/reflect/jvm/internal/JvmPropertySignature$KotlinProperty;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "proto", "Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property;", "signature", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmPropertySignature;", "nameResolver", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/NameResolver;", "typeTable", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/TypeTable;", "<init>", "(Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;Lorg/jetbrains/kotlin/metadata/ProtoBuf$Property;Lorg/jetbrains/kotlin/metadata/jvm/JvmProtoBuf$JvmPropertySignature;Lorg/jetbrains/kotlin/metadata/deserialization/NameResolver;Lorg/jetbrains/kotlin/metadata/deserialization/TypeTable;)V", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;", "getProto", "()Lorg/jetbrains/kotlin/metadata/ProtoBuf$Property;", "getSignature", "()Lorg/jetbrains/kotlin/metadata/jvm/JvmProtoBuf$JvmPropertySignature;", "getNameResolver", "()Lorg/jetbrains/kotlin/metadata/deserialization/NameResolver;", "getTypeTable", "()Lorg/jetbrains/kotlin/metadata/deserialization/TypeTable;", "string", "", "getManglingSuffix", "asString", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class KotlinProperty extends kotlin.reflect.jvm.internal.JvmPropertySignature {
        private final kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor descriptor;
        private final kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver nameResolver;
        private final kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property proto;
        private final kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmPropertySignature signature;
        private final java.lang.String string;
        private final kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable typeTable;

        public final kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor getDescriptor() {
            return this.descriptor;
        }

        public final kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property getProto() {
            return this.proto;
        }

        public final kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmPropertySignature getSignature() {
            return this.signature;
        }

        public final kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver getNameResolver() {
            return this.nameResolver;
        }

        public final kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable getTypeTable() {
            return this.typeTable;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public KotlinProperty(kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor descriptor, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property proto, kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmPropertySignature signature, kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver nameResolver, kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable typeTable) {
            java.lang.String str;
            super(null);
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(descriptor, "descriptor");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(proto, "proto");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(signature, "signature");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeTable, "typeTable");
            this.descriptor = descriptor;
            this.proto = proto;
            this.signature = signature;
            this.nameResolver = nameResolver;
            this.typeTable = typeTable;
            if (signature.hasGetter()) {
                str = nameResolver.getString(signature.getGetter().getName()) + nameResolver.getString(signature.getGetter().getDesc());
            } else {
                kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature.Field jvmFieldSignature$default = kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil.getJvmFieldSignature$default(kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil.INSTANCE, proto, nameResolver, typeTable, false, 8, null);
                if (jvmFieldSignature$default != null) {
                    java.lang.String strComponent1 = jvmFieldSignature$default.component1();
                    str = kotlin.reflect.jvm.internal.impl.load.java.JvmAbi.getterName(strComponent1) + getManglingSuffix() + "()" + jvmFieldSignature$default.component2();
                } else {
                    throw new kotlin.reflect.jvm.internal.KotlinReflectionInternalError("No field signature for property: " + descriptor);
                }
            }
            this.string = str;
        }

        private final java.lang.String getManglingSuffix() {
            java.lang.String string;
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor containingDeclaration = this.descriptor.getContainingDeclaration();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(containingDeclaration, "getContainingDeclaration(...)");
            if (kotlin.jvm.internal.Intrinsics.areEqual(this.descriptor.getVisibility(), kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.INTERNAL) && (containingDeclaration instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor)) {
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class classProto = ((kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor) containingDeclaration).getClassProto();
                kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class, java.lang.Integer> classModuleName = kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.classModuleName;
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(classModuleName, "classModuleName");
                java.lang.Integer num = (java.lang.Integer) kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt.getExtensionOrNull(classProto, classModuleName);
                if (num == null || (string = this.nameResolver.getString(num.intValue())) == null) {
                    string = "main";
                }
                return com.taobao.weex.el.parse.Operators.DOLLAR_STR + kotlin.reflect.jvm.internal.impl.name.NameUtils.sanitizeAsJavaIdentifier(string);
            }
            if (kotlin.jvm.internal.Intrinsics.areEqual(this.descriptor.getVisibility(), kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.PRIVATE) && (containingDeclaration instanceof kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor)) {
                kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor propertyDescriptor = this.descriptor;
                kotlin.jvm.internal.Intrinsics.checkNotNull(propertyDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.serialization.deserialization.descriptors.DeserializedPropertyDescriptor");
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource containerSource = ((kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor) propertyDescriptor).getContainerSource();
                if (!(containerSource instanceof kotlin.reflect.jvm.internal.impl.load.kotlin.JvmPackagePartSource)) {
                    return "";
                }
                kotlin.reflect.jvm.internal.impl.load.kotlin.JvmPackagePartSource jvmPackagePartSource = (kotlin.reflect.jvm.internal.impl.load.kotlin.JvmPackagePartSource) containerSource;
                if (jvmPackagePartSource.getFacadeClassName() != null) {
                    return com.taobao.weex.el.parse.Operators.DOLLAR_STR + jvmPackagePartSource.getSimpleName().asString();
                }
                return "";
            }
            return "";
        }

        @Override // kotlin.reflect.jvm.internal.JvmPropertySignature
        /* JADX INFO: renamed from: asString, reason: from getter */
        public java.lang.String getString() {
            return this.string;
        }
    }

    /* JADX INFO: compiled from: RuntimeTypeMapper.kt */
    @kotlin.Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\f"}, d2 = {"Lkotlin/reflect/jvm/internal/JvmPropertySignature$JavaMethodProperty;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "getterMethod", "Ljava/lang/reflect/Method;", "setterMethod", "<init>", "(Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "getGetterMethod", "()Ljava/lang/reflect/Method;", "getSetterMethod", "asString", "", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class JavaMethodProperty extends kotlin.reflect.jvm.internal.JvmPropertySignature {
        private final java.lang.reflect.Method getterMethod;
        private final java.lang.reflect.Method setterMethod;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public JavaMethodProperty(java.lang.reflect.Method getterMethod, java.lang.reflect.Method method) {
            super(null);
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(getterMethod, "getterMethod");
            this.getterMethod = getterMethod;
            this.setterMethod = method;
        }

        public final java.lang.reflect.Method getGetterMethod() {
            return this.getterMethod;
        }

        public final java.lang.reflect.Method getSetterMethod() {
            return this.setterMethod;
        }

        @Override // kotlin.reflect.jvm.internal.JvmPropertySignature
        /* JADX INFO: renamed from: asString */
        public java.lang.String getString() {
            return kotlin.reflect.jvm.internal.RuntimeTypeMapperKt.getSignature(this.getterMethod);
        }
    }

    /* JADX INFO: compiled from: RuntimeTypeMapper.kt */
    @kotlin.Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lkotlin/reflect/jvm/internal/JvmPropertySignature$JavaField;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "field", "Ljava/lang/reflect/Field;", "<init>", "(Ljava/lang/reflect/Field;)V", "getField", "()Ljava/lang/reflect/Field;", "asString", "", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class JavaField extends kotlin.reflect.jvm.internal.JvmPropertySignature {
        private final java.lang.reflect.Field field;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public JavaField(java.lang.reflect.Field field) {
            super(null);
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(field, "field");
            this.field = field;
        }

        public final java.lang.reflect.Field getField() {
            return this.field;
        }

        @Override // kotlin.reflect.jvm.internal.JvmPropertySignature
        /* JADX INFO: renamed from: asString */
        public java.lang.String getString() {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            java.lang.String name = this.field.getName();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            sb.append(kotlin.reflect.jvm.internal.impl.load.java.JvmAbi.getterName(name));
            sb.append("()");
            java.lang.Class<?> type = this.field.getType();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
            sb.append(kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt.getDesc(type));
            return sb.toString();
        }
    }

    /* JADX INFO: compiled from: RuntimeTypeMapper.kt */
    @kotlin.Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\f"}, d2 = {"Lkotlin/reflect/jvm/internal/JvmPropertySignature$MappedKotlinProperty;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "getterSignature", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;", "setterSignature", "<init>", "(Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;)V", "getGetterSignature", "()Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;", "getSetterSignature", "asString", "", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class MappedKotlinProperty extends kotlin.reflect.jvm.internal.JvmPropertySignature {
        private final kotlin.reflect.jvm.internal.JvmFunctionSignature.KotlinFunction getterSignature;
        private final kotlin.reflect.jvm.internal.JvmFunctionSignature.KotlinFunction setterSignature;

        public final kotlin.reflect.jvm.internal.JvmFunctionSignature.KotlinFunction getGetterSignature() {
            return this.getterSignature;
        }

        public final kotlin.reflect.jvm.internal.JvmFunctionSignature.KotlinFunction getSetterSignature() {
            return this.setterSignature;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MappedKotlinProperty(kotlin.reflect.jvm.internal.JvmFunctionSignature.KotlinFunction getterSignature, kotlin.reflect.jvm.internal.JvmFunctionSignature.KotlinFunction kotlinFunction) {
            super(null);
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(getterSignature, "getterSignature");
            this.getterSignature = getterSignature;
            this.setterSignature = kotlinFunction;
        }

        @Override // kotlin.reflect.jvm.internal.JvmPropertySignature
        /* JADX INFO: renamed from: asString */
        public java.lang.String getString() {
            return this.getterSignature.get_signature();
        }
    }
}
