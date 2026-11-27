package kotlin.reflect.jvm.internal;

/* JADX INFO: compiled from: RuntimeTypeMapper.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\tH\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\tH\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u0015H\u0002J\u0012\u0010\u0016\u001a\u00020\u00052\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u0018R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u001a*\u0006\u0012\u0002\b\u00030\u00188BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lkotlin/reflect/jvm/internal/RuntimeTypeMapper;", "", "<init>", "()V", "JAVA_LANG_VOID", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "mapSignature", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "possiblySubstitutedFunction", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "mapPropertySignature", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "possiblyOverriddenProperty", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "isKnownBuiltInFunction", "", "descriptor", "mapJvmFunctionSignature", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;", "mapName", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "mapJvmClassToKotlinClassId", "klass", "Ljava/lang/Class;", "primitiveType", "Lkotlin/reflect/jvm/internal/impl/builtins/PrimitiveType;", "getPrimitiveType", "(Ljava/lang/Class;)Lorg/jetbrains/kotlin/builtins/PrimitiveType;", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RuntimeTypeMapper {
    public static final kotlin.reflect.jvm.internal.RuntimeTypeMapper INSTANCE = new kotlin.reflect.jvm.internal.RuntimeTypeMapper();
    private static final kotlin.reflect.jvm.internal.impl.name.ClassId JAVA_LANG_VOID = kotlin.reflect.jvm.internal.impl.name.ClassId.Companion.topLevel(new kotlin.reflect.jvm.internal.impl.name.FqName("java.lang.Void"));

    private RuntimeTypeMapper() {
    }

    public final kotlin.reflect.jvm.internal.JvmFunctionSignature mapSignature(kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor possiblySubstitutedFunction) {
        java.lang.reflect.Method member;
        kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature.Method jvmConstructorSignature;
        kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature.Method jvmMethodSignature;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(possiblySubstitutedFunction, "possiblySubstitutedFunction");
        kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor original = ((kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.unwrapFakeOverride(possiblySubstitutedFunction)).getOriginal();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(original, "getOriginal(...)");
        if (original instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedCallableMemberDescriptor) {
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor deserializedMemberDescriptor = (kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor) original;
            kotlin.reflect.jvm.internal.impl.protobuf.MessageLite proto = deserializedMemberDescriptor.getProto();
            if ((proto instanceof kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function) && (jvmMethodSignature = kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil.INSTANCE.getJvmMethodSignature((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function) proto, deserializedMemberDescriptor.getNameResolver(), deserializedMemberDescriptor.getTypeTable())) != null) {
                return new kotlin.reflect.jvm.internal.JvmFunctionSignature.KotlinFunction(jvmMethodSignature);
            }
            if ((proto instanceof kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Constructor) && (jvmConstructorSignature = kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil.INSTANCE.getJvmConstructorSignature((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Constructor) proto, deserializedMemberDescriptor.getNameResolver(), deserializedMemberDescriptor.getTypeTable())) != null) {
                kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor containingDeclaration = possiblySubstitutedFunction.getContainingDeclaration();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(containingDeclaration, "getContainingDeclaration(...)");
                if (kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt.isInlineClass(containingDeclaration)) {
                    return new kotlin.reflect.jvm.internal.JvmFunctionSignature.KotlinFunction(jvmConstructorSignature);
                }
                kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor containingDeclaration2 = possiblySubstitutedFunction.getContainingDeclaration();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(containingDeclaration2, "getContainingDeclaration(...)");
                if (kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt.isMultiFieldValueClass(containingDeclaration2)) {
                    kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor constructorDescriptor = (kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor) possiblySubstitutedFunction;
                    if (constructorDescriptor.isPrimary()) {
                        if (!kotlin.jvm.internal.Intrinsics.areEqual(jvmConstructorSignature.getName(), "constructor-impl") || !kotlin.text.StringsKt.endsWith$default(jvmConstructorSignature.getDesc(), ")V", false, 2, (java.lang.Object) null)) {
                            throw new java.lang.IllegalArgumentException(("Invalid signature: " + jvmConstructorSignature).toString());
                        }
                    } else {
                        if (!kotlin.jvm.internal.Intrinsics.areEqual(jvmConstructorSignature.getName(), "constructor-impl")) {
                            throw new java.lang.IllegalArgumentException(("Invalid signature: " + jvmConstructorSignature).toString());
                        }
                        kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor constructedClass = constructorDescriptor.getConstructedClass();
                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(constructedClass, "getConstructedClass(...)");
                        java.lang.String jvmDescriptor = kotlin.reflect.jvm.internal.calls.ValueClassAwareCallerKt.toJvmDescriptor(constructedClass);
                        if (kotlin.text.StringsKt.endsWith$default(jvmConstructorSignature.getDesc(), ")V", false, 2, (java.lang.Object) null)) {
                            jvmConstructorSignature = kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature.Method.copy$default(jvmConstructorSignature, null, kotlin.text.StringsKt.removeSuffix(jvmConstructorSignature.getDesc(), (java.lang.CharSequence) "V") + jvmDescriptor, 1, null);
                        } else if (!kotlin.text.StringsKt.endsWith$default(jvmConstructorSignature.getDesc(), jvmDescriptor, false, 2, (java.lang.Object) null)) {
                            throw new java.lang.IllegalArgumentException(("Invalid signature: " + jvmConstructorSignature).toString());
                        }
                    }
                    return new kotlin.reflect.jvm.internal.JvmFunctionSignature.KotlinFunction(jvmConstructorSignature);
                }
                return new kotlin.reflect.jvm.internal.JvmFunctionSignature.KotlinConstructor(jvmConstructorSignature);
            }
            return mapJvmFunctionSignature(original);
        }
        if (original instanceof kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor) {
            kotlin.reflect.jvm.internal.impl.descriptors.SourceElement source = ((kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor) original).getSource();
            kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement javaSourceElement = source instanceof kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement ? (kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement) source : null;
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaElement javaElement = javaSourceElement != null ? javaSourceElement.getJavaElement() : null;
            kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaMethod reflectJavaMethod = javaElement instanceof kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaMethod ? (kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaMethod) javaElement : null;
            if (reflectJavaMethod == null || (member = reflectJavaMethod.getMember()) == null) {
                throw new kotlin.reflect.jvm.internal.KotlinReflectionInternalError("Incorrect resolution sequence for Java method " + original);
            }
            return new kotlin.reflect.jvm.internal.JvmFunctionSignature.JavaMethod(member);
        }
        if (original instanceof kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassConstructorDescriptor) {
            kotlin.reflect.jvm.internal.impl.descriptors.SourceElement source2 = ((kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassConstructorDescriptor) original).getSource();
            kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement javaSourceElement2 = source2 instanceof kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement ? (kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement) source2 : null;
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaElement javaElement2 = javaSourceElement2 != null ? javaSourceElement2.getJavaElement() : null;
            if (javaElement2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaConstructor) {
                return new kotlin.reflect.jvm.internal.JvmFunctionSignature.JavaConstructor(((kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaConstructor) javaElement2).getMember());
            }
            if (javaElement2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass) {
                kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass reflectJavaClass = (kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass) javaElement2;
                if (reflectJavaClass.isAnnotationType()) {
                    return new kotlin.reflect.jvm.internal.JvmFunctionSignature.FakeJavaAnnotationConstructor(reflectJavaClass.getElement());
                }
            }
            throw new kotlin.reflect.jvm.internal.KotlinReflectionInternalError("Incorrect resolution sequence for Java constructor " + original + " (" + javaElement2 + com.taobao.weex.el.parse.Operators.BRACKET_END);
        }
        if (isKnownBuiltInFunction(original)) {
            return mapJvmFunctionSignature(original);
        }
        throw new kotlin.reflect.jvm.internal.KotlinReflectionInternalError("Unknown origin of " + original + " (" + original.getClass() + com.taobao.weex.el.parse.Operators.BRACKET_END);
    }

    public final kotlin.reflect.jvm.internal.JvmPropertySignature mapPropertySignature(kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor possiblyOverriddenProperty) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(possiblyOverriddenProperty, "possiblyOverriddenProperty");
        kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor original = ((kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor) kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.unwrapFakeOverride(possiblyOverriddenProperty)).getOriginal();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(original, "getOriginal(...)");
        if (original instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor) {
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor deserializedPropertyDescriptor = (kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor) original;
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property proto = deserializedPropertyDescriptor.getProto();
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property, kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmPropertySignature> propertySignature = kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.propertySignature;
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(propertySignature, "propertySignature");
            kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmPropertySignature jvmPropertySignature = (kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmPropertySignature) kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt.getExtensionOrNull(proto, propertySignature);
            if (jvmPropertySignature != null) {
                return new kotlin.reflect.jvm.internal.JvmPropertySignature.KotlinProperty(original, proto, jvmPropertySignature, deserializedPropertyDescriptor.getNameResolver(), deserializedPropertyDescriptor.getTypeTable());
            }
        } else if (original instanceof kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaPropertyDescriptor) {
            kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaPropertyDescriptor javaPropertyDescriptor = (kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaPropertyDescriptor) original;
            kotlin.reflect.jvm.internal.impl.descriptors.SourceElement source = javaPropertyDescriptor.getSource();
            kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement javaSourceElement = source instanceof kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement ? (kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement) source : null;
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaElement javaElement = javaSourceElement != null ? javaSourceElement.getJavaElement() : null;
            if (javaElement instanceof kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaField) {
                return new kotlin.reflect.jvm.internal.JvmPropertySignature.JavaField(((kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaField) javaElement).getMember());
            }
            if (javaElement instanceof kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaMethod) {
                java.lang.reflect.Method member = ((kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaMethod) javaElement).getMember();
                kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor setter = javaPropertyDescriptor.getSetter();
                kotlin.reflect.jvm.internal.impl.descriptors.SourceElement source2 = setter != null ? setter.getSource() : null;
                kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement javaSourceElement2 = source2 instanceof kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement ? (kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement) source2 : null;
                kotlin.reflect.jvm.internal.impl.load.java.structure.JavaElement javaElement2 = javaSourceElement2 != null ? javaSourceElement2.getJavaElement() : null;
                kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaMethod reflectJavaMethod = javaElement2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaMethod ? (kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaMethod) javaElement2 : null;
                return new kotlin.reflect.jvm.internal.JvmPropertySignature.JavaMethodProperty(member, reflectJavaMethod != null ? reflectJavaMethod.getMember() : null);
            }
            throw new kotlin.reflect.jvm.internal.KotlinReflectionInternalError("Incorrect resolution sequence for Java field " + original + " (source = " + javaElement + com.taobao.weex.el.parse.Operators.BRACKET_END);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor getter = original.getGetter();
        kotlin.jvm.internal.Intrinsics.checkNotNull(getter);
        kotlin.reflect.jvm.internal.JvmFunctionSignature.KotlinFunction kotlinFunctionMapJvmFunctionSignature = mapJvmFunctionSignature(getter);
        kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor setter2 = original.getSetter();
        return new kotlin.reflect.jvm.internal.JvmPropertySignature.MappedKotlinProperty(kotlinFunctionMapJvmFunctionSignature, setter2 != null ? mapJvmFunctionSignature(setter2) : null);
    }

    private final boolean isKnownBuiltInFunction(kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor descriptor) {
        if (kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory.isEnumValueOfMethod(descriptor) || kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory.isEnumValuesMethod(descriptor)) {
            return true;
        }
        return kotlin.jvm.internal.Intrinsics.areEqual(descriptor.getName(), kotlin.reflect.jvm.internal.impl.builtins.jvm.CloneableClassScope.Companion.getCLONE_NAME()) && descriptor.getValueParameters().isEmpty();
    }

    private final kotlin.reflect.jvm.internal.JvmFunctionSignature.KotlinFunction mapJvmFunctionSignature(kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor descriptor) {
        return new kotlin.reflect.jvm.internal.JvmFunctionSignature.KotlinFunction(new kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature.Method(mapName(descriptor), kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt.computeJvmDescriptor$default(descriptor, false, false, 1, null)));
    }

    private final java.lang.String mapName(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor descriptor) {
        java.lang.String jvmMethodNameIfSpecial = kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers.getJvmMethodNameIfSpecial(descriptor);
        if (jvmMethodNameIfSpecial != null) {
            return jvmMethodNameIfSpecial;
        }
        if (descriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor) {
            java.lang.String strAsString = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getPropertyIfAccessor(descriptor).getName().asString();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strAsString, "asString(...)");
            return kotlin.reflect.jvm.internal.impl.load.java.JvmAbi.getterName(strAsString);
        }
        if (descriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor) {
            java.lang.String strAsString2 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getPropertyIfAccessor(descriptor).getName().asString();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strAsString2, "asString(...)");
            return kotlin.reflect.jvm.internal.impl.load.java.JvmAbi.setterName(strAsString2);
        }
        java.lang.String strAsString3 = descriptor.getName().asString();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strAsString3, "asString(...)");
        return strAsString3;
    }

    public final kotlin.reflect.jvm.internal.impl.name.ClassId mapJvmClassToKotlinClassId(java.lang.Class<?> klass) {
        kotlin.reflect.jvm.internal.impl.name.ClassId classIdMapJavaToKotlin;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(klass, "klass");
        if (klass.isArray()) {
            java.lang.Class<?> componentType = klass.getComponentType();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(componentType, "getComponentType(...)");
            kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType primitiveType = getPrimitiveType(componentType);
            if (primitiveType != null) {
                return new kotlin.reflect.jvm.internal.impl.name.ClassId(kotlin.reflect.jvm.internal.impl.builtins.StandardNames.BUILT_INS_PACKAGE_FQ_NAME, primitiveType.getArrayTypeName());
            }
            return kotlin.reflect.jvm.internal.impl.name.ClassId.Companion.topLevel(kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.array.toSafe());
        }
        if (kotlin.jvm.internal.Intrinsics.areEqual(klass, java.lang.Void.TYPE)) {
            return JAVA_LANG_VOID;
        }
        kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType primitiveType2 = getPrimitiveType(klass);
        if (primitiveType2 != null) {
            return new kotlin.reflect.jvm.internal.impl.name.ClassId(kotlin.reflect.jvm.internal.impl.builtins.StandardNames.BUILT_INS_PACKAGE_FQ_NAME, primitiveType2.getTypeName());
        }
        kotlin.reflect.jvm.internal.impl.name.ClassId classId = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt.getClassId(klass);
        return (classId.isLocal() || (classIdMapJavaToKotlin = kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap.INSTANCE.mapJavaToKotlin(classId.asSingleFqName())) == null) ? classId : classIdMapJavaToKotlin;
    }

    private final kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType getPrimitiveType(java.lang.Class<?> cls) {
        if (cls.isPrimitive()) {
            return kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType.get(cls.getSimpleName()).getPrimitiveType();
        }
        return null;
    }
}
