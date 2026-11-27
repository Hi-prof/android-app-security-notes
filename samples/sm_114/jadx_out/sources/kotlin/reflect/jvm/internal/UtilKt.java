package kotlin.reflect.jvm.internal;

/* JADX INFO: compiled from: util.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000Ú\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0005*\u00020\u0006H\u0000\u001a$\u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0005*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0000\u001a.\u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\fH\u0002\u001a\u0014\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0005*\u0006\u0012\u0002\b\u00030\u0005H\u0000\u001a\u000e\u0010\u0012\u001a\u0004\u0018\u00010\u0013*\u00020\u0014H\u0000\u001a\u0012\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016*\u00020\u0018H\u0000\u001a\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016*\b\u0012\u0004\u0012\u00020\u00170\u0016\u001a\u000e\u0010\u001a\u001a\u0004\u0018\u00010\u0017*\u00020\u001bH\u0002\u001a\u001a\u0010\u001c\u001a\u0004\u0018\u00010\u001d*\u0006\u0012\u0002\b\u00030\u001e2\u0006\u0010\r\u001a\u00020\bH\u0002\u001a\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u001d*\u00020 2\u0006\u0010\r\u001a\u00020\bH\u0002\u001a%\u0010!\u001a\u0002H\"\"\u0004\b\u0000\u0010\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u0002H\"0$H\u0080\bø\u0001\u0000¢\u0006\u0002\u0010%\u001a\u0010\u0010&\u001a\u0004\u0018\u00010'*\u0004\u0018\u00010\u001dH\u0000\u001a\u0014\u0010(\u001a\b\u0012\u0002\b\u0003\u0018\u00010)*\u0004\u0018\u00010\u001dH\u0000\u001a\u0014\u0010*\u001a\b\u0012\u0002\b\u0003\u0018\u00010+*\u0004\u0018\u00010\u001dH\u0000\u001al\u00101\u001a\u0002H2\"\b\b\u0000\u00103*\u000204\"\b\b\u0001\u00102*\u00020.2\n\u00105\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u00106\u001a\u0002H32\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<2\u001d\u0010=\u001a\u0019\u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u0002H3\u0012\u0004\u0012\u0002H20>¢\u0006\u0002\b@H\u0000¢\u0006\u0002\u0010A\u001a\u0012\u0010H\u001a\u0004\u0018\u00010\u001d2\u0006\u0010I\u001a\u00020JH\u0000\u001a;\u0010K\u001a\u0004\u0018\u00010L*\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010M\u001a\u00020\u000f2\u001a\u0010N\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00050O\"\u0006\u0012\u0002\b\u00030\u0005H\u0000¢\u0006\u0002\u0010P\u001a\u001a\u0010Q\u001a\u0004\u0018\u00010R*\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010M\u001a\u00020\u000fH\u0000\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u001a\u0010,\u001a\u0004\u0018\u00010-*\u00020.8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b/\u00100\"\u0018\u0010B\u001a\u00020C*\u00020D8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bB\u0010E\"\u0018\u0010F\u001a\u00020C*\u00020D8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bG\u0010E\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006S"}, d2 = {"JVM_STATIC", "Lkotlin/reflect/jvm/internal/impl/name/FqName;", "getJVM_STATIC", "()Lorg/jetbrains/kotlin/name/FqName;", "toJavaClass", "Ljava/lang/Class;", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "loadClass", "Ljava/lang/ClassLoader;", "kotlinClassId", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "arrayDimensions", "", "classLoader", "packageName", "", "className", "createArrayType", "toKVisibility", "Lkotlin/reflect/KVisibility;", "Lkotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibility;", "computeAnnotations", "", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/Annotated;", "unwrapRepeatableAnnotations", "toAnnotationInstance", "Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptor;", "toRuntimeValue", "", "Lkotlin/reflect/jvm/internal/impl/resolve/constants/ConstantValue;", "arrayToRuntimeValue", "Lkotlin/reflect/jvm/internal/impl/resolve/constants/ArrayValue;", "reflectionCall", "R", io.dcloud.common.constant.AbsoluteConst.JSON_VALUE_BLOCK, "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "asKFunctionImpl", "Lkotlin/reflect/jvm/internal/KFunctionImpl;", "asKPropertyImpl", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "asKCallableImpl", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "instanceReceiverParameter", "Lkotlin/reflect/jvm/internal/impl/descriptors/ReceiverParameterDescriptor;", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableDescriptor;", "getInstanceReceiverParameter", "(Lorg/jetbrains/kotlin/descriptors/CallableDescriptor;)Lorg/jetbrains/kotlin/descriptors/ReceiverParameterDescriptor;", "deserializeToDescriptor", "D", "M", "Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;", "moduleAnchor", "proto", "nameResolver", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/NameResolver;", "typeTable", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/TypeTable;", "metadataVersion", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/BinaryVersion;", "createDescriptor", "Lkotlin/Function2;", "Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/MemberDeserializer;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Class;Lorg/jetbrains/kotlin/protobuf/MessageLite;Lorg/jetbrains/kotlin/metadata/deserialization/NameResolver;Lorg/jetbrains/kotlin/metadata/deserialization/TypeTable;Lorg/jetbrains/kotlin/metadata/deserialization/BinaryVersion;Lkotlin/jvm/functions/Function2;)Lorg/jetbrains/kotlin/descriptors/CallableDescriptor;", "isInlineClassType", "", "Lkotlin/reflect/KType;", "(Lkotlin/reflect/KType;)Z", "needsMultiFieldValueClassFlattening", "getNeedsMultiFieldValueClassFlattening", "defaultPrimitiveValue", "type", "Ljava/lang/reflect/Type;", "getDeclaredMethodOrNull", "Ljava/lang/reflect/Method;", "name", "parameterTypes", "", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;", "getDeclaredFieldOrNull", "Ljava/lang/reflect/Field;", "kotlin-reflection"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class UtilKt {
    private static final kotlin.reflect.jvm.internal.impl.name.FqName JVM_STATIC = new kotlin.reflect.jvm.internal.impl.name.FqName("kotlin.jvm.JvmStatic");

    /* JADX INFO: compiled from: util.kt */
    @kotlin.Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType.values().length];
            try {
                iArr[kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType.BOOLEAN.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                iArr[kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType.CHAR.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                iArr[kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType.BYTE.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                iArr[kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType.SHORT.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                iArr[kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType.INT.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            try {
                iArr[kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType.FLOAT.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
            try {
                iArr[kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType.LONG.ordinal()] = 7;
            } catch (java.lang.NoSuchFieldError unused7) {
            }
            try {
                iArr[kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType.DOUBLE.ordinal()] = 8;
            } catch (java.lang.NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final kotlin.reflect.jvm.internal.impl.name.FqName getJVM_STATIC() {
        return JVM_STATIC;
    }

    public static final java.lang.Class<?> toJavaClass(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(classDescriptor, "<this>");
        kotlin.reflect.jvm.internal.impl.descriptors.SourceElement source = classDescriptor.getSource();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(source, "getSource(...)");
        if (source instanceof kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinarySourceElement) {
            kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass binaryClass = ((kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinarySourceElement) source).getBinaryClass();
            kotlin.jvm.internal.Intrinsics.checkNotNull(binaryClass, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.runtime.components.ReflectKotlinClass");
            return ((kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass) binaryClass).getKlass();
        }
        if (source instanceof kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeSourceElementFactory.RuntimeSourceElement) {
            kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaElement javaElement = ((kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeSourceElementFactory.RuntimeSourceElement) source).getJavaElement();
            kotlin.jvm.internal.Intrinsics.checkNotNull(javaElement, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.runtime.structure.ReflectJavaClass");
            return ((kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass) javaElement).getElement();
        }
        kotlin.reflect.jvm.internal.impl.name.ClassId classId = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getClassId(classDescriptor);
        if (classId == null) {
            return null;
        }
        return loadClass$default(kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt.getSafeClassLoader(classDescriptor.getClass()), classId, 0, 2, null);
    }

    public static /* synthetic */ java.lang.Class loadClass$default(java.lang.ClassLoader classLoader, kotlin.reflect.jvm.internal.impl.name.ClassId classId, int i, int i2, java.lang.Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return loadClass(classLoader, classId, i);
    }

    public static final java.lang.Class<?> loadClass(java.lang.ClassLoader classLoader, kotlin.reflect.jvm.internal.impl.name.ClassId kotlinClassId, int i) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(classLoader, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinClassId, "kotlinClassId");
        kotlin.reflect.jvm.internal.impl.name.ClassId classIdMapKotlinToJava = kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap.INSTANCE.mapKotlinToJava(kotlinClassId.asSingleFqName().toUnsafe());
        if (classIdMapKotlinToJava == null) {
            classIdMapKotlinToJava = kotlinClassId;
        }
        if (!kotlin.jvm.internal.Intrinsics.areEqual(classIdMapKotlinToJava, kotlinClassId)) {
            classLoader = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt.getSafeClassLoader(kotlin.Unit.class);
        }
        return loadClass(classLoader, classIdMapKotlinToJava.getPackageFqName().asString(), classIdMapKotlinToJava.getRelativeClassName().asString(), i);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static final java.lang.Class<?> loadClass(java.lang.ClassLoader classLoader, java.lang.String str, java.lang.String str2, int i) {
        if (kotlin.jvm.internal.Intrinsics.areEqual(str, "kotlin")) {
            switch (str2.hashCode()) {
                case -901856463:
                    if (str2.equals("BooleanArray")) {
                        return boolean[].class;
                    }
                    break;
                case -763279523:
                    if (str2.equals("ShortArray")) {
                        return short[].class;
                    }
                    break;
                case -755911549:
                    if (str2.equals("CharArray")) {
                        return char[].class;
                    }
                    break;
                case -74930671:
                    if (str2.equals("ByteArray")) {
                        return byte[].class;
                    }
                    break;
                case 22374632:
                    if (str2.equals("DoubleArray")) {
                        return double[].class;
                    }
                    break;
                case 63537721:
                    if (str2.equals("Array")) {
                        return java.lang.Object[].class;
                    }
                    break;
                case 601811914:
                    if (str2.equals("IntArray")) {
                        return int[].class;
                    }
                    break;
                case 948852093:
                    if (str2.equals("FloatArray")) {
                        return float[].class;
                    }
                    break;
                case 2104330525:
                    if (str2.equals("LongArray")) {
                        return long[].class;
                    }
                    break;
            }
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (i > 0) {
            for (int i2 = 0; i2 < i; i2++) {
                sb.append(com.taobao.weex.el.parse.Operators.ARRAY_START_STR);
            }
            sb.append("L");
        }
        if (str.length() > 0) {
            sb.append(str + com.taobao.weex.el.parse.Operators.DOT);
        }
        sb.append(kotlin.text.StringsKt.replace$default(str2, com.taobao.weex.el.parse.Operators.DOT, '$', false, 4, (java.lang.Object) null));
        if (i > 0) {
            sb.append(";");
        }
        return kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectJavaClassFinderKt.tryLoadClass(classLoader, sb.toString());
    }

    public static final java.lang.Class<?> createArrayType(java.lang.Class<?> cls) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(cls, "<this>");
        return java.lang.reflect.Array.newInstance(cls, 0).getClass();
    }

    public static final kotlin.reflect.KVisibility toKVisibility(kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility descriptorVisibility) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(descriptorVisibility, "<this>");
        if (kotlin.jvm.internal.Intrinsics.areEqual(descriptorVisibility, kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.PUBLIC)) {
            return kotlin.reflect.KVisibility.PUBLIC;
        }
        if (kotlin.jvm.internal.Intrinsics.areEqual(descriptorVisibility, kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.PROTECTED)) {
            return kotlin.reflect.KVisibility.PROTECTED;
        }
        if (kotlin.jvm.internal.Intrinsics.areEqual(descriptorVisibility, kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.INTERNAL)) {
            return kotlin.reflect.KVisibility.INTERNAL;
        }
        if (kotlin.jvm.internal.Intrinsics.areEqual(descriptorVisibility, kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.PRIVATE) || kotlin.jvm.internal.Intrinsics.areEqual(descriptorVisibility, kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.PRIVATE_TO_THIS)) {
            return kotlin.reflect.KVisibility.PRIVATE;
        }
        return null;
    }

    public static final java.util.List<java.lang.annotation.Annotation> computeAnnotations(kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated annotated) {
        java.lang.annotation.Annotation annotationInstance;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(annotated, "<this>");
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations annotations = annotated.getAnnotations();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor annotationDescriptor : annotations) {
            kotlin.reflect.jvm.internal.impl.descriptors.SourceElement source = annotationDescriptor.getSource();
            if (source instanceof kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectAnnotationSource) {
                annotationInstance = ((kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectAnnotationSource) source).getAnnotation();
            } else if (source instanceof kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeSourceElementFactory.RuntimeSourceElement) {
                kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaElement javaElement = ((kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeSourceElementFactory.RuntimeSourceElement) source).getJavaElement();
                kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotation reflectJavaAnnotation = javaElement instanceof kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotation ? (kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotation) javaElement : null;
                annotationInstance = reflectJavaAnnotation != null ? reflectJavaAnnotation.getAnnotation() : null;
            } else {
                annotationInstance = toAnnotationInstance(annotationDescriptor);
            }
            if (annotationInstance != null) {
                arrayList.add(annotationInstance);
            }
        }
        return unwrapRepeatableAnnotations(arrayList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final java.util.List<java.lang.annotation.Annotation> unwrapRepeatableAnnotations(java.util.List<? extends java.lang.annotation.Annotation> list) throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        java.util.List listListOf;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(list, "<this>");
        java.util.List<? extends java.lang.annotation.Annotation> list2 = list;
        if ((list2 instanceof java.util.Collection) && list2.isEmpty()) {
            return list;
        }
        java.util.Iterator it = list2.iterator();
        while (it.hasNext()) {
            if (kotlin.jvm.internal.Intrinsics.areEqual(kotlin.jvm.JvmClassMappingKt.getJavaClass(kotlin.jvm.JvmClassMappingKt.getAnnotationClass((java.lang.annotation.Annotation) it.next())).getSimpleName(), "Container")) {
                java.util.ArrayList arrayList = new java.util.ArrayList();
                for (java.lang.annotation.Annotation annotation : list2) {
                    java.lang.Class javaClass = kotlin.jvm.JvmClassMappingKt.getJavaClass(kotlin.jvm.JvmClassMappingKt.getAnnotationClass(annotation));
                    if (kotlin.jvm.internal.Intrinsics.areEqual(javaClass.getSimpleName(), "Container") && javaClass.getAnnotation(kotlin.jvm.internal.RepeatableContainer.class) != null) {
                        java.lang.Object objInvoke = javaClass.getDeclaredMethod("value", null).invoke(annotation, null);
                        kotlin.jvm.internal.Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.Array<out kotlin.Annotation>");
                        listListOf = kotlin.collections.ArraysKt.asList((java.lang.annotation.Annotation[]) objInvoke);
                    } else {
                        listListOf = kotlin.collections.CollectionsKt.listOf(annotation);
                    }
                    kotlin.collections.CollectionsKt.addAll(arrayList, listListOf);
                }
                return arrayList;
            }
        }
        return list;
    }

    private static final java.lang.annotation.Annotation toAnnotationInstance(kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor annotationDescriptor) {
        kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor annotationClass = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getAnnotationClass(annotationDescriptor);
        java.lang.Class<?> javaClass = annotationClass != null ? toJavaClass(annotationClass) : null;
        if (!(javaClass instanceof java.lang.Class)) {
            javaClass = null;
        }
        if (javaClass == null) {
            return null;
        }
        java.util.Set<java.util.Map.Entry<kotlin.reflect.jvm.internal.impl.name.Name, kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue<?>>> setEntrySet = annotationDescriptor.getAllValueArguments().entrySet();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            java.util.Map.Entry entry = (java.util.Map.Entry) it.next();
            kotlin.reflect.jvm.internal.impl.name.Name name = (kotlin.reflect.jvm.internal.impl.name.Name) entry.getKey();
            kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue constantValue = (kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue) entry.getValue();
            java.lang.ClassLoader classLoader = javaClass.getClassLoader();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(classLoader, "getClassLoader(...)");
            java.lang.Object runtimeValue = toRuntimeValue(constantValue, classLoader);
            kotlin.Pair pair = runtimeValue != null ? kotlin.TuplesKt.to(name.asString(), runtimeValue) : null;
            if (pair != null) {
                arrayList.add(pair);
            }
        }
        return (java.lang.annotation.Annotation) kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt.createAnnotationInstance$default(javaClass, kotlin.collections.MapsKt.toMap(arrayList), null, 4, null);
    }

    private static final java.lang.Object toRuntimeValue(kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue<?> constantValue, java.lang.ClassLoader classLoader) {
        if (constantValue instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.AnnotationValue) {
            return toAnnotationInstance(((kotlin.reflect.jvm.internal.impl.resolve.constants.AnnotationValue) constantValue).getValue());
        }
        if (constantValue instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue) {
            return arrayToRuntimeValue((kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue) constantValue, classLoader);
        }
        if (constantValue instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue) {
            kotlin.Pair<? extends kotlin.reflect.jvm.internal.impl.name.ClassId, ? extends kotlin.reflect.jvm.internal.impl.name.Name> value = ((kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue) constantValue).getValue();
            kotlin.reflect.jvm.internal.impl.name.ClassId classIdComponent1 = value.component1();
            kotlin.reflect.jvm.internal.impl.name.Name nameComponent2 = value.component2();
            java.lang.Class clsLoadClass$default = loadClass$default(classLoader, classIdComponent1, 0, 2, null);
            if (clsLoadClass$default != null) {
                return kotlin.reflect.jvm.internal.Util.getEnumConstantByName(clsLoadClass$default, nameComponent2.asString());
            }
            return null;
        }
        if (constantValue instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue) {
            kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue.Value value2 = ((kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue) constantValue).getValue();
            if (value2 instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue.Value.NormalClass) {
                kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue.Value.NormalClass normalClass = (kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue.Value.NormalClass) value2;
                return loadClass(classLoader, normalClass.getClassId(), normalClass.getArrayDimensions());
            }
            if (!(value2 instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue.Value.LocalClass)) {
                throw new kotlin.NoWhenBranchMatchedException();
            }
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptorMo1835getDeclarationDescriptor = ((kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue.Value.LocalClass) value2).getType().getConstructor().mo1835getDeclarationDescriptor();
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor = classifierDescriptorMo1835getDeclarationDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor ? (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) classifierDescriptorMo1835getDeclarationDescriptor : null;
            if (classDescriptor != null) {
                return toJavaClass(classDescriptor);
            }
            return null;
        }
        if ((constantValue instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.ErrorValue) || (constantValue instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.NullValue)) {
            return null;
        }
        return constantValue.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final java.lang.Object arrayToRuntimeValue(kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue arrayValue, java.lang.ClassLoader classLoader) {
        kotlin.reflect.jvm.internal.impl.types.KotlinType type;
        java.lang.Class clsLoadClass$default;
        kotlin.reflect.jvm.internal.impl.resolve.constants.TypedArrayValue typedArrayValue = arrayValue instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.TypedArrayValue ? (kotlin.reflect.jvm.internal.impl.resolve.constants.TypedArrayValue) arrayValue : null;
        if (typedArrayValue == null || (type = typedArrayValue.getType()) == null) {
            return null;
        }
        java.util.List<? extends kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue<?>> value = arrayValue.getValue();
        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(value, 10));
        java.util.Iterator<T> it = value.iterator();
        while (it.hasNext()) {
            arrayList.add(toRuntimeValue((kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue) it.next(), classLoader));
        }
        java.util.ArrayList arrayList2 = arrayList;
        kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType primitiveArrayElementType = kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.getPrimitiveArrayElementType(type);
        int i = 0;
        switch (primitiveArrayElementType == null ? -1 : kotlin.reflect.jvm.internal.UtilKt.WhenMappings.$EnumSwitchMapping$0[primitiveArrayElementType.ordinal()]) {
            case -1:
                if (!kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isArray(type)) {
                    throw new java.lang.IllegalStateException(("Not an array type: " + type).toString());
                }
                kotlin.reflect.jvm.internal.impl.types.KotlinType type2 = ((kotlin.reflect.jvm.internal.impl.types.TypeProjection) kotlin.collections.CollectionsKt.single((java.util.List) type.getArguments())).getType();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(type2, "getType(...)");
                kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptorMo1835getDeclarationDescriptor = type2.getConstructor().mo1835getDeclarationDescriptor();
                kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor = classifierDescriptorMo1835getDeclarationDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor ? (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) classifierDescriptorMo1835getDeclarationDescriptor : null;
                if (classDescriptor == null) {
                    throw new java.lang.IllegalStateException(("Not a class type: " + type2).toString());
                }
                if (kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isString(type2)) {
                    int size = arrayValue.getValue().size();
                    java.lang.String[] strArr = new java.lang.String[size];
                    while (i < size) {
                        java.lang.Object obj = arrayList2.get(i);
                        kotlin.jvm.internal.Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                        strArr[i] = obj;
                        i++;
                    }
                    return strArr;
                }
                if (kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isKClass(classDescriptor)) {
                    int size2 = arrayValue.getValue().size();
                    java.lang.Class[] clsArr = new java.lang.Class[size2];
                    while (i < size2) {
                        java.lang.Object obj2 = arrayList2.get(i);
                        kotlin.jvm.internal.Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type java.lang.Class<*>");
                        clsArr[i] = obj2;
                        i++;
                    }
                    return clsArr;
                }
                kotlin.reflect.jvm.internal.impl.name.ClassId classId = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getClassId(classDescriptor);
                if (classId == null || (clsLoadClass$default = loadClass$default(classLoader, classId, 0, 2, null)) == null) {
                    return null;
                }
                java.lang.Object objNewInstance = java.lang.reflect.Array.newInstance((java.lang.Class<?>) clsLoadClass$default, arrayValue.getValue().size());
                kotlin.jvm.internal.Intrinsics.checkNotNull(objNewInstance, "null cannot be cast to non-null type kotlin.Array<in kotlin.Any?>");
                java.lang.Object[] objArr = (java.lang.Object[]) objNewInstance;
                int size3 = arrayList2.size();
                while (i < size3) {
                    objArr[i] = arrayList2.get(i);
                    i++;
                }
                return objArr;
            case 0:
            default:
                throw new kotlin.NoWhenBranchMatchedException();
            case 1:
                int size4 = arrayValue.getValue().size();
                boolean[] zArr = new boolean[size4];
                while (i < size4) {
                    java.lang.Object obj3 = arrayList2.get(i);
                    kotlin.jvm.internal.Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Boolean");
                    zArr[i] = ((java.lang.Boolean) obj3).booleanValue();
                    i++;
                }
                return zArr;
            case 2:
                int size5 = arrayValue.getValue().size();
                char[] cArr = new char[size5];
                while (i < size5) {
                    java.lang.Object obj4 = arrayList2.get(i);
                    kotlin.jvm.internal.Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.Char");
                    cArr[i] = ((java.lang.Character) obj4).charValue();
                    i++;
                }
                return cArr;
            case 3:
                int size6 = arrayValue.getValue().size();
                byte[] bArr = new byte[size6];
                while (i < size6) {
                    java.lang.Object obj5 = arrayList2.get(i);
                    kotlin.jvm.internal.Intrinsics.checkNotNull(obj5, "null cannot be cast to non-null type kotlin.Byte");
                    bArr[i] = ((java.lang.Byte) obj5).byteValue();
                    i++;
                }
                return bArr;
            case 4:
                int size7 = arrayValue.getValue().size();
                short[] sArr = new short[size7];
                while (i < size7) {
                    java.lang.Object obj6 = arrayList2.get(i);
                    kotlin.jvm.internal.Intrinsics.checkNotNull(obj6, "null cannot be cast to non-null type kotlin.Short");
                    sArr[i] = ((java.lang.Short) obj6).shortValue();
                    i++;
                }
                return sArr;
            case 5:
                int size8 = arrayValue.getValue().size();
                int[] iArr = new int[size8];
                while (i < size8) {
                    java.lang.Object obj7 = arrayList2.get(i);
                    kotlin.jvm.internal.Intrinsics.checkNotNull(obj7, "null cannot be cast to non-null type kotlin.Int");
                    iArr[i] = ((java.lang.Integer) obj7).intValue();
                    i++;
                }
                return iArr;
            case 6:
                int size9 = arrayValue.getValue().size();
                float[] fArr = new float[size9];
                while (i < size9) {
                    java.lang.Object obj8 = arrayList2.get(i);
                    kotlin.jvm.internal.Intrinsics.checkNotNull(obj8, "null cannot be cast to non-null type kotlin.Float");
                    fArr[i] = ((java.lang.Float) obj8).floatValue();
                    i++;
                }
                return fArr;
            case 7:
                int size10 = arrayValue.getValue().size();
                long[] jArr = new long[size10];
                while (i < size10) {
                    java.lang.Object obj9 = arrayList2.get(i);
                    kotlin.jvm.internal.Intrinsics.checkNotNull(obj9, "null cannot be cast to non-null type kotlin.Long");
                    jArr[i] = ((java.lang.Long) obj9).longValue();
                    i++;
                }
                return jArr;
            case 8:
                int size11 = arrayValue.getValue().size();
                double[] dArr = new double[size11];
                while (i < size11) {
                    java.lang.Object obj10 = arrayList2.get(i);
                    kotlin.jvm.internal.Intrinsics.checkNotNull(obj10, "null cannot be cast to non-null type kotlin.Double");
                    dArr[i] = ((java.lang.Double) obj10).doubleValue();
                    i++;
                }
                return dArr;
        }
    }

    public static final kotlin.reflect.jvm.internal.KFunctionImpl asKFunctionImpl(java.lang.Object obj) {
        kotlin.reflect.jvm.internal.KFunctionImpl kFunctionImpl = obj instanceof kotlin.reflect.jvm.internal.KFunctionImpl ? (kotlin.reflect.jvm.internal.KFunctionImpl) obj : null;
        if (kFunctionImpl != null) {
            return kFunctionImpl;
        }
        kotlin.jvm.internal.FunctionReference functionReference = obj instanceof kotlin.jvm.internal.FunctionReference ? (kotlin.jvm.internal.FunctionReference) obj : null;
        kotlin.reflect.KCallable kCallableCompute = functionReference != null ? functionReference.compute() : null;
        if (kCallableCompute instanceof kotlin.reflect.jvm.internal.KFunctionImpl) {
            return (kotlin.reflect.jvm.internal.KFunctionImpl) kCallableCompute;
        }
        return null;
    }

    public static final kotlin.reflect.jvm.internal.KPropertyImpl<?> asKPropertyImpl(java.lang.Object obj) {
        kotlin.reflect.jvm.internal.KPropertyImpl<?> kPropertyImpl = obj instanceof kotlin.reflect.jvm.internal.KPropertyImpl ? (kotlin.reflect.jvm.internal.KPropertyImpl) obj : null;
        if (kPropertyImpl != null) {
            return kPropertyImpl;
        }
        kotlin.jvm.internal.PropertyReference propertyReference = obj instanceof kotlin.jvm.internal.PropertyReference ? (kotlin.jvm.internal.PropertyReference) obj : null;
        kotlin.reflect.KCallable kCallableCompute = propertyReference != null ? propertyReference.compute() : null;
        if (kCallableCompute instanceof kotlin.reflect.jvm.internal.KPropertyImpl) {
            return (kotlin.reflect.jvm.internal.KPropertyImpl) kCallableCompute;
        }
        return null;
    }

    public static final kotlin.reflect.jvm.internal.KCallableImpl<?> asKCallableImpl(java.lang.Object obj) {
        kotlin.reflect.jvm.internal.KCallableImpl<?> kCallableImpl = obj instanceof kotlin.reflect.jvm.internal.KCallableImpl ? (kotlin.reflect.jvm.internal.KCallableImpl) obj : null;
        if (kCallableImpl != null) {
            return kCallableImpl;
        }
        kotlin.reflect.jvm.internal.KFunctionImpl kFunctionImplAsKFunctionImpl = asKFunctionImpl(obj);
        return kFunctionImplAsKFunctionImpl != null ? kFunctionImplAsKFunctionImpl : asKPropertyImpl(obj);
    }

    public static final kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor getInstanceReceiverParameter(kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor callableDescriptor) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callableDescriptor, "<this>");
        if (callableDescriptor.getDispatchReceiverParameter() == null) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor containingDeclaration = callableDescriptor.getContainingDeclaration();
        kotlin.jvm.internal.Intrinsics.checkNotNull(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        return ((kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) containingDeclaration).getThisAsReceiverParameter();
    }

    public static final <M extends kotlin.reflect.jvm.internal.impl.protobuf.MessageLite, D extends kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor> D deserializeToDescriptor(java.lang.Class<?> moduleAnchor, M proto, kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver nameResolver, kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable typeTable, kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion metadataVersion, kotlin.jvm.functions.Function2<? super kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer, ? super M, ? extends D> createDescriptor) {
        java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter> typeParameterList;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(moduleAnchor, "moduleAnchor");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(proto, "proto");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(metadataVersion, "metadataVersion");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(createDescriptor, "createDescriptor");
        kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeModuleData orCreateModule = kotlin.reflect.jvm.internal.ModuleByClassLoaderKt.getOrCreateModule(moduleAnchor);
        if (proto instanceof kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function) {
            typeParameterList = ((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function) proto).getTypeParameterList();
        } else {
            if (!(proto instanceof kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property)) {
                throw new java.lang.IllegalStateException(("Unsupported message: " + proto).toString());
            }
            typeParameterList = ((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property) proto).getTypeParameterList();
        }
        java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter> list = typeParameterList;
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents deserialization = orCreateModule.getDeserialization();
        kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor module = orCreateModule.getModule();
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable empty = kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable.Companion.getEMPTY();
        kotlin.jvm.internal.Intrinsics.checkNotNull(list);
        return createDescriptor.invoke(new kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer(new kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext(deserialization, nameResolver, module, typeTable, empty, metadataVersion, null, null, list)), proto);
    }

    public static final boolean isInlineClassType(kotlin.reflect.KType kType) {
        kotlin.reflect.jvm.internal.impl.types.KotlinType type;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kType, "<this>");
        kotlin.reflect.jvm.internal.KTypeImpl kTypeImpl = kType instanceof kotlin.reflect.jvm.internal.KTypeImpl ? (kotlin.reflect.jvm.internal.KTypeImpl) kType : null;
        return (kTypeImpl == null || (type = kTypeImpl.getType()) == null || !kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt.isInlineClassType(type)) ? false : true;
    }

    public static final boolean getNeedsMultiFieldValueClassFlattening(kotlin.reflect.KType kType) {
        kotlin.reflect.jvm.internal.impl.types.KotlinType type;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kType, "<this>");
        kotlin.reflect.jvm.internal.KTypeImpl kTypeImpl = kType instanceof kotlin.reflect.jvm.internal.KTypeImpl ? (kotlin.reflect.jvm.internal.KTypeImpl) kType : null;
        return (kTypeImpl == null || (type = kTypeImpl.getType()) == null || !kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt.needsMfvcFlattening(type)) ? false : true;
    }

    public static final java.lang.Object defaultPrimitiveValue(java.lang.reflect.Type type) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(type, "type");
        if (!(type instanceof java.lang.Class)) {
            return null;
        }
        java.lang.Class cls = (java.lang.Class) type;
        if (!cls.isPrimitive()) {
            return null;
        }
        if (kotlin.jvm.internal.Intrinsics.areEqual(cls, java.lang.Boolean.TYPE)) {
            return false;
        }
        if (kotlin.jvm.internal.Intrinsics.areEqual(cls, java.lang.Character.TYPE)) {
            return (char) 0;
        }
        if (kotlin.jvm.internal.Intrinsics.areEqual(cls, java.lang.Byte.TYPE)) {
            return (byte) 0;
        }
        if (kotlin.jvm.internal.Intrinsics.areEqual(cls, java.lang.Short.TYPE)) {
            return (short) 0;
        }
        if (kotlin.jvm.internal.Intrinsics.areEqual(cls, java.lang.Integer.TYPE)) {
            return 0;
        }
        if (kotlin.jvm.internal.Intrinsics.areEqual(cls, java.lang.Float.TYPE)) {
            return java.lang.Float.valueOf(0.0f);
        }
        if (kotlin.jvm.internal.Intrinsics.areEqual(cls, java.lang.Long.TYPE)) {
            return 0L;
        }
        if (kotlin.jvm.internal.Intrinsics.areEqual(cls, java.lang.Double.TYPE)) {
            return java.lang.Double.valueOf(0.0d);
        }
        if (kotlin.jvm.internal.Intrinsics.areEqual(cls, java.lang.Void.TYPE)) {
            throw new java.lang.IllegalStateException("Parameter with void type is illegal");
        }
        throw new java.lang.UnsupportedOperationException("Unknown primitive: " + type);
    }

    public static final java.lang.reflect.Method getDeclaredMethodOrNull(java.lang.Class<?> cls, java.lang.String name, java.lang.Class<?>... parameterTypes) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(cls, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(parameterTypes, "parameterTypes");
        try {
            return cls.getDeclaredMethod(name, (java.lang.Class[]) java.util.Arrays.copyOf(parameterTypes, parameterTypes.length));
        } catch (java.lang.NoSuchMethodException unused) {
            return null;
        }
    }

    public static final java.lang.reflect.Field getDeclaredFieldOrNull(java.lang.Class<?> cls, java.lang.String name) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(cls, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        try {
            return cls.getDeclaredField(name);
        } catch (java.lang.NoSuchFieldException unused) {
            return null;
        }
    }
}
