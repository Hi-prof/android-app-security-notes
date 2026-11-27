package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

/* JADX INFO: compiled from: AnnotationDeserializer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AnnotationDeserializer {
    private final kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor module;
    private final kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses notFoundClasses;

    /* JADX INFO: compiled from: AnnotationDeserializer.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value.Type.values().length];
            try {
                iArr[kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value.Type.BYTE.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                iArr[kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value.Type.CHAR.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                iArr[kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value.Type.SHORT.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                iArr[kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value.Type.INT.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                iArr[kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value.Type.LONG.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            try {
                iArr[kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value.Type.FLOAT.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
            try {
                iArr[kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value.Type.DOUBLE.ordinal()] = 7;
            } catch (java.lang.NoSuchFieldError unused7) {
            }
            try {
                iArr[kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value.Type.BOOLEAN.ordinal()] = 8;
            } catch (java.lang.NoSuchFieldError unused8) {
            }
            try {
                iArr[kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value.Type.STRING.ordinal()] = 9;
            } catch (java.lang.NoSuchFieldError unused9) {
            }
            try {
                iArr[kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value.Type.CLASS.ordinal()] = 10;
            } catch (java.lang.NoSuchFieldError unused10) {
            }
            try {
                iArr[kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value.Type.ENUM.ordinal()] = 11;
            } catch (java.lang.NoSuchFieldError unused11) {
            }
            try {
                iArr[kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value.Type.ANNOTATION.ordinal()] = 12;
            } catch (java.lang.NoSuchFieldError unused12) {
            }
            try {
                iArr[kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value.Type.ARRAY.ordinal()] = 13;
            } catch (java.lang.NoSuchFieldError unused13) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public AnnotationDeserializer(kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor module, kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses notFoundClasses) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(module, "module");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(notFoundClasses, "notFoundClasses");
        this.module = module;
        this.notFoundClasses = notFoundClasses;
    }

    private final kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns getBuiltIns() {
        return this.module.getBuiltIns();
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor deserializeAnnotation(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation proto, kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver nameResolver) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(proto, "proto");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptorResolveClass = resolveClass(kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt.getClassId(nameResolver, proto.getId()));
        java.util.Map mapEmptyMap = kotlin.collections.MapsKt.emptyMap();
        if (proto.getArgumentCount() != 0) {
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor = classDescriptorResolveClass;
            if (!kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils.isError(classDescriptor) && kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.isAnnotationClass(classDescriptor)) {
                java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor> constructors = classDescriptorResolveClass.getConstructors();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(constructors, "getConstructors(...)");
                kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor classConstructorDescriptor = (kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor) kotlin.collections.CollectionsKt.singleOrNull(constructors);
                if (classConstructorDescriptor != null) {
                    java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> valueParameters = classConstructorDescriptor.getValueParameters();
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(valueParameters, "getValueParameters(...)");
                    java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> list = valueParameters;
                    java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap(kotlin.ranges.RangesKt.coerceAtLeast(kotlin.collections.MapsKt.mapCapacity(kotlin.collections.CollectionsKt.collectionSizeOrDefault(list, 10)), 16));
                    for (java.lang.Object obj : list) {
                        linkedHashMap.put(((kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) obj).getName(), obj);
                    }
                    java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument> argumentList = proto.getArgumentList();
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(argumentList, "getArgumentList(...)");
                    java.util.ArrayList arrayList = new java.util.ArrayList();
                    for (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument argument : argumentList) {
                        kotlin.jvm.internal.Intrinsics.checkNotNull(argument);
                        kotlin.Pair<kotlin.reflect.jvm.internal.impl.name.Name, kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue<?>> pairResolveArgument = resolveArgument(argument, linkedHashMap, nameResolver);
                        if (pairResolveArgument != null) {
                            arrayList.add(pairResolveArgument);
                        }
                    }
                    mapEmptyMap = kotlin.collections.MapsKt.toMap(arrayList);
                }
            }
        }
        return new kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptorImpl(classDescriptorResolveClass.getDefaultType(), mapEmptyMap, kotlin.reflect.jvm.internal.impl.descriptors.SourceElement.NO_SOURCE);
    }

    private final kotlin.Pair<kotlin.reflect.jvm.internal.impl.name.Name, kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue<?>> resolveArgument(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument argument, java.util.Map<kotlin.reflect.jvm.internal.impl.name.Name, ? extends kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> map, kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver nameResolver) {
        kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor valueParameterDescriptor = map.get(kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt.getName(nameResolver, argument.getNameId()));
        if (valueParameterDescriptor == null) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.name.Name name = kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt.getName(nameResolver, argument.getNameId());
        kotlin.reflect.jvm.internal.impl.types.KotlinType type = valueParameterDescriptor.getType();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value value = argument.getValue();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return new kotlin.Pair<>(name, resolveValueAndCheckExpectedType(type, value, nameResolver));
    }

    private final kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue<?> resolveValueAndCheckExpectedType(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value value, kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver nameResolver) {
        kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue<?> constantValueResolveValue = resolveValue(kotlinType, value, nameResolver);
        if (!doesValueConformToExpectedType(constantValueResolveValue, kotlinType, value)) {
            constantValueResolveValue = null;
        }
        if (constantValueResolveValue != null) {
            return constantValueResolveValue;
        }
        return kotlin.reflect.jvm.internal.impl.resolve.constants.ErrorValue.Companion.create("Unexpected argument value: actual type " + value.getType() + " != expected type " + kotlinType);
    }

    public final kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue<?> resolveValue(kotlin.reflect.jvm.internal.impl.types.KotlinType expectedType, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value value, kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver nameResolver) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(expectedType, "expectedType");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(value, "value");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        java.lang.Boolean bool = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_UNSIGNED.get(value.getFlags());
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bool, "get(...)");
        boolean zBooleanValue = bool.booleanValue();
        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value.Type type = value.getType();
        switch (type == null ? -1 : kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationDeserializer.WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
            case 1:
                byte intValue = (byte) value.getIntValue();
                return zBooleanValue ? new kotlin.reflect.jvm.internal.impl.resolve.constants.UByteValue(intValue) : new kotlin.reflect.jvm.internal.impl.resolve.constants.ByteValue(intValue);
            case 2:
                return new kotlin.reflect.jvm.internal.impl.resolve.constants.CharValue((char) value.getIntValue());
            case 3:
                short intValue2 = (short) value.getIntValue();
                return zBooleanValue ? new kotlin.reflect.jvm.internal.impl.resolve.constants.UShortValue(intValue2) : new kotlin.reflect.jvm.internal.impl.resolve.constants.ShortValue(intValue2);
            case 4:
                int intValue3 = (int) value.getIntValue();
                return zBooleanValue ? new kotlin.reflect.jvm.internal.impl.resolve.constants.UIntValue(intValue3) : new kotlin.reflect.jvm.internal.impl.resolve.constants.IntValue(intValue3);
            case 5:
                long intValue4 = value.getIntValue();
                return zBooleanValue ? new kotlin.reflect.jvm.internal.impl.resolve.constants.ULongValue(intValue4) : new kotlin.reflect.jvm.internal.impl.resolve.constants.LongValue(intValue4);
            case 6:
                return new kotlin.reflect.jvm.internal.impl.resolve.constants.FloatValue(value.getFloatValue());
            case 7:
                return new kotlin.reflect.jvm.internal.impl.resolve.constants.DoubleValue(value.getDoubleValue());
            case 8:
                return new kotlin.reflect.jvm.internal.impl.resolve.constants.BooleanValue(value.getIntValue() != 0);
            case 9:
                return new kotlin.reflect.jvm.internal.impl.resolve.constants.StringValue(nameResolver.getString(value.getStringValue()));
            case 10:
                return new kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue(kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt.getClassId(nameResolver, value.getClassId()), value.getArrayDimensionCount());
            case 11:
                return new kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue(kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt.getClassId(nameResolver, value.getClassId()), kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt.getName(nameResolver, value.getEnumValueId()));
            case 12:
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation annotation = value.getAnnotation();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(annotation, "getAnnotation(...)");
                return new kotlin.reflect.jvm.internal.impl.resolve.constants.AnnotationValue(deserializeAnnotation(annotation, nameResolver));
            case 13:
                kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValueFactory constantValueFactory = kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValueFactory.INSTANCE;
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value> arrayElementList = value.getArrayElementList();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(arrayElementList, "getArrayElementList(...)");
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value> list = arrayElementList;
                java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(list, 10));
                for (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value value2 : list) {
                    kotlin.reflect.jvm.internal.impl.types.SimpleType anyType = getBuiltIns().getAnyType();
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(anyType, "getAnyType(...)");
                    kotlin.jvm.internal.Intrinsics.checkNotNull(value2);
                    arrayList.add(resolveValue(anyType, value2, nameResolver));
                }
                return constantValueFactory.createArrayValue(arrayList, expectedType);
            default:
                throw new java.lang.IllegalStateException(("Unsupported annotation argument type: " + value.getType() + " (expected " + expectedType + com.taobao.weex.el.parse.Operators.BRACKET_END).toString());
        }
    }

    private final boolean doesValueConformToExpectedType(kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue<?> constantValue, kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value value) {
        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value.Type type = value.getType();
        int i = type == null ? -1 : kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationDeserializer.WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        if (i == 10) {
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptorMo1835getDeclarationDescriptor = kotlinType.getConstructor().mo1835getDeclarationDescriptor();
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor = classifierDescriptorMo1835getDeclarationDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor ? (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) classifierDescriptorMo1835getDeclarationDescriptor : null;
            return classDescriptor == null || kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isKClass(classDescriptor);
        }
        if (i == 13) {
            if (!(constantValue instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue) || ((kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue) constantValue).getValue().size() != value.getArrayElementList().size()) {
                throw new java.lang.IllegalStateException(("Deserialized ArrayValue should have the same number of elements as the original array value: " + constantValue).toString());
            }
            kotlin.reflect.jvm.internal.impl.types.KotlinType arrayElementTypeOrNull = getBuiltIns().getArrayElementTypeOrNull(kotlinType);
            if (arrayElementTypeOrNull == null) {
                return false;
            }
            kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue arrayValue = (kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue) constantValue;
            java.lang.Iterable indices = kotlin.collections.CollectionsKt.getIndices(arrayValue.getValue());
            if ((indices instanceof java.util.Collection) && ((java.util.Collection) indices).isEmpty()) {
                return true;
            }
            java.util.Iterator it = indices.iterator();
            while (it.hasNext()) {
                int iNextInt = ((kotlin.collections.IntIterator) it).nextInt();
                kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue<?> constantValue2 = arrayValue.getValue().get(iNextInt);
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value arrayElement = value.getArrayElement(iNextInt);
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(arrayElement, "getArrayElement(...)");
                if (!doesValueConformToExpectedType(constantValue2, arrayElementTypeOrNull, arrayElement)) {
                    return false;
                }
            }
            return true;
        }
        return kotlin.jvm.internal.Intrinsics.areEqual(constantValue.getType(this.module), kotlinType);
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor resolveClass(kotlin.reflect.jvm.internal.impl.name.ClassId classId) {
        return kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt.findNonGenericClassAcrossDependencies(this.module, classId, this.notFoundClasses);
    }
}
