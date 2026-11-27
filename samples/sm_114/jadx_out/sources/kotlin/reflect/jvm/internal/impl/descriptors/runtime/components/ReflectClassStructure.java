package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

/* JADX INFO: compiled from: ReflectKotlinClass.kt */
/* JADX INFO: loaded from: classes2.dex */
final class ReflectClassStructure {
    public static final kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectClassStructure INSTANCE = new kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectClassStructure();

    private ReflectClassStructure() {
    }

    public final void loadClassAnnotations(java.lang.Class<?> klass, kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationVisitor visitor) throws java.lang.reflect.InvocationTargetException {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(klass, "klass");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(visitor, "visitor");
        java.util.Iterator it = kotlin.jvm.internal.ArrayIteratorKt.iterator(klass.getDeclaredAnnotations());
        while (it.hasNext()) {
            java.lang.annotation.Annotation annotation = (java.lang.annotation.Annotation) it.next();
            kotlin.jvm.internal.Intrinsics.checkNotNull(annotation);
            processAnnotation(visitor, annotation);
        }
        visitor.visitEnd();
    }

    public final void visitMembers(java.lang.Class<?> klass, kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.MemberVisitor memberVisitor) throws java.lang.reflect.InvocationTargetException {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(klass, "klass");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(memberVisitor, "memberVisitor");
        loadMethodAnnotations(klass, memberVisitor);
        loadConstructorAnnotations(klass, memberVisitor);
        loadFieldAnnotations(klass, memberVisitor);
    }

    private final void loadMethodAnnotations(java.lang.Class<?> cls, kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.MemberVisitor memberVisitor) throws java.lang.reflect.InvocationTargetException {
        java.util.Iterator it = kotlin.jvm.internal.ArrayIteratorKt.iterator(cls.getDeclaredMethods());
        while (it.hasNext()) {
            java.lang.reflect.Method method = (java.lang.reflect.Method) it.next();
            kotlin.reflect.jvm.internal.impl.name.Name nameIdentifier = kotlin.reflect.jvm.internal.impl.name.Name.identifier(method.getName());
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameIdentifier, "identifier(...)");
            kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.SignatureSerializer signatureSerializer = kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.SignatureSerializer.INSTANCE;
            kotlin.jvm.internal.Intrinsics.checkNotNull(method);
            kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.MethodAnnotationVisitor methodAnnotationVisitorVisitMethod = memberVisitor.visitMethod(nameIdentifier, signatureSerializer.methodDesc(method));
            if (methodAnnotationVisitorVisitMethod != null) {
                java.util.Iterator it2 = kotlin.jvm.internal.ArrayIteratorKt.iterator(method.getDeclaredAnnotations());
                while (it2.hasNext()) {
                    java.lang.annotation.Annotation annotation = (java.lang.annotation.Annotation) it2.next();
                    kotlin.jvm.internal.Intrinsics.checkNotNull(annotation);
                    processAnnotation(methodAnnotationVisitorVisitMethod, annotation);
                }
                java.lang.annotation.Annotation[][] parameterAnnotations = method.getParameterAnnotations();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(parameterAnnotations, "getParameterAnnotations(...)");
                java.lang.annotation.Annotation[][] annotationArr = parameterAnnotations;
                int length = annotationArr.length;
                for (int i = 0; i < length; i++) {
                    java.util.Iterator it3 = kotlin.jvm.internal.ArrayIteratorKt.iterator(annotationArr[i]);
                    while (it3.hasNext()) {
                        java.lang.annotation.Annotation annotation2 = (java.lang.annotation.Annotation) it3.next();
                        java.lang.Class<?> javaClass = kotlin.jvm.JvmClassMappingKt.getJavaClass(kotlin.jvm.JvmClassMappingKt.getAnnotationClass(annotation2));
                        kotlin.reflect.jvm.internal.impl.name.ClassId classId = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt.getClassId(javaClass);
                        kotlin.jvm.internal.Intrinsics.checkNotNull(annotation2);
                        kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor annotationArgumentVisitorVisitParameterAnnotation = methodAnnotationVisitorVisitMethod.visitParameterAnnotation(i, classId, new kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectAnnotationSource(annotation2));
                        if (annotationArgumentVisitorVisitParameterAnnotation != null) {
                            INSTANCE.processAnnotationArguments(annotationArgumentVisitorVisitParameterAnnotation, annotation2, javaClass);
                        }
                    }
                }
                methodAnnotationVisitorVisitMethod.visitEnd();
            }
        }
    }

    private final void loadConstructorAnnotations(java.lang.Class<?> cls, kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.MemberVisitor memberVisitor) throws java.lang.reflect.InvocationTargetException {
        java.util.Iterator it = kotlin.jvm.internal.ArrayIteratorKt.iterator(cls.getDeclaredConstructors());
        while (it.hasNext()) {
            java.lang.reflect.Constructor<?> constructor = (java.lang.reflect.Constructor) it.next();
            kotlin.reflect.jvm.internal.impl.name.Name name = kotlin.reflect.jvm.internal.impl.name.SpecialNames.INIT;
            kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.SignatureSerializer signatureSerializer = kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.SignatureSerializer.INSTANCE;
            kotlin.jvm.internal.Intrinsics.checkNotNull(constructor);
            kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.MethodAnnotationVisitor methodAnnotationVisitorVisitMethod = memberVisitor.visitMethod(name, signatureSerializer.constructorDesc(constructor));
            if (methodAnnotationVisitorVisitMethod != null) {
                java.util.Iterator it2 = kotlin.jvm.internal.ArrayIteratorKt.iterator(constructor.getDeclaredAnnotations());
                while (it2.hasNext()) {
                    java.lang.annotation.Annotation annotation = (java.lang.annotation.Annotation) it2.next();
                    kotlin.jvm.internal.Intrinsics.checkNotNull(annotation);
                    processAnnotation(methodAnnotationVisitorVisitMethod, annotation);
                }
                java.lang.annotation.Annotation[][] parameterAnnotations = constructor.getParameterAnnotations();
                kotlin.jvm.internal.Intrinsics.checkNotNull(parameterAnnotations);
                java.lang.annotation.Annotation[][] annotationArr = parameterAnnotations;
                if (!(annotationArr.length == 0)) {
                    int length = constructor.getParameterTypes().length - annotationArr.length;
                    int length2 = annotationArr.length;
                    for (int i = 0; i < length2; i++) {
                        java.util.Iterator it3 = kotlin.jvm.internal.ArrayIteratorKt.iterator(parameterAnnotations[i]);
                        while (it3.hasNext()) {
                            java.lang.annotation.Annotation annotation2 = (java.lang.annotation.Annotation) it3.next();
                            java.lang.Class<?> javaClass = kotlin.jvm.JvmClassMappingKt.getJavaClass(kotlin.jvm.JvmClassMappingKt.getAnnotationClass(annotation2));
                            kotlin.reflect.jvm.internal.impl.name.ClassId classId = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt.getClassId(javaClass);
                            kotlin.jvm.internal.Intrinsics.checkNotNull(annotation2);
                            kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor annotationArgumentVisitorVisitParameterAnnotation = methodAnnotationVisitorVisitMethod.visitParameterAnnotation(i + length, classId, new kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectAnnotationSource(annotation2));
                            if (annotationArgumentVisitorVisitParameterAnnotation != null) {
                                INSTANCE.processAnnotationArguments(annotationArgumentVisitorVisitParameterAnnotation, annotation2, javaClass);
                            }
                        }
                    }
                }
                methodAnnotationVisitorVisitMethod.visitEnd();
            }
        }
    }

    private final void loadFieldAnnotations(java.lang.Class<?> cls, kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.MemberVisitor memberVisitor) throws java.lang.reflect.InvocationTargetException {
        java.util.Iterator it = kotlin.jvm.internal.ArrayIteratorKt.iterator(cls.getDeclaredFields());
        while (it.hasNext()) {
            java.lang.reflect.Field field = (java.lang.reflect.Field) it.next();
            kotlin.reflect.jvm.internal.impl.name.Name nameIdentifier = kotlin.reflect.jvm.internal.impl.name.Name.identifier(field.getName());
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameIdentifier, "identifier(...)");
            kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.SignatureSerializer signatureSerializer = kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.SignatureSerializer.INSTANCE;
            kotlin.jvm.internal.Intrinsics.checkNotNull(field);
            kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationVisitor annotationVisitorVisitField = memberVisitor.visitField(nameIdentifier, signatureSerializer.fieldDesc(field), null);
            if (annotationVisitorVisitField != null) {
                java.util.Iterator it2 = kotlin.jvm.internal.ArrayIteratorKt.iterator(field.getDeclaredAnnotations());
                while (it2.hasNext()) {
                    java.lang.annotation.Annotation annotation = (java.lang.annotation.Annotation) it2.next();
                    kotlin.jvm.internal.Intrinsics.checkNotNull(annotation);
                    processAnnotation(annotationVisitorVisitField, annotation);
                }
                annotationVisitorVisitField.visitEnd();
            }
        }
    }

    private final void processAnnotation(kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationVisitor annotationVisitor, java.lang.annotation.Annotation annotation) throws java.lang.reflect.InvocationTargetException {
        java.lang.Class<?> javaClass = kotlin.jvm.JvmClassMappingKt.getJavaClass(kotlin.jvm.JvmClassMappingKt.getAnnotationClass(annotation));
        kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor annotationArgumentVisitorVisitAnnotation = annotationVisitor.visitAnnotation(kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt.getClassId(javaClass), new kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectAnnotationSource(annotation));
        if (annotationArgumentVisitorVisitAnnotation != null) {
            INSTANCE.processAnnotationArguments(annotationArgumentVisitorVisitAnnotation, annotation, javaClass);
        }
    }

    private final void processAnnotationArguments(kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor annotationArgumentVisitor, java.lang.annotation.Annotation annotation, java.lang.Class<?> cls) throws java.lang.reflect.InvocationTargetException {
        java.util.Iterator it = kotlin.jvm.internal.ArrayIteratorKt.iterator(cls.getDeclaredMethods());
        while (it.hasNext()) {
            java.lang.reflect.Method method = (java.lang.reflect.Method) it.next();
            try {
                java.lang.Object objInvoke = method.invoke(annotation, null);
                kotlin.jvm.internal.Intrinsics.checkNotNull(objInvoke);
                kotlin.reflect.jvm.internal.impl.name.Name nameIdentifier = kotlin.reflect.jvm.internal.impl.name.Name.identifier(method.getName());
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameIdentifier, "identifier(...)");
                processAnnotationArgumentValue(annotationArgumentVisitor, nameIdentifier, objInvoke);
            } catch (java.lang.IllegalAccessException unused) {
            }
        }
        annotationArgumentVisitor.visitEnd();
    }

    private final kotlin.reflect.jvm.internal.impl.resolve.constants.ClassLiteralValue classLiteralValue(java.lang.Class<?> cls) {
        int i = 0;
        while (cls.isArray()) {
            i++;
            cls = cls.getComponentType();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(cls, "getComponentType(...)");
        }
        if (cls.isPrimitive()) {
            if (kotlin.jvm.internal.Intrinsics.areEqual(cls, java.lang.Void.TYPE)) {
                return new kotlin.reflect.jvm.internal.impl.resolve.constants.ClassLiteralValue(kotlin.reflect.jvm.internal.impl.name.ClassId.Companion.topLevel(kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.unit.toSafe()), i);
            }
            kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType primitiveType = kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType.get(cls.getName()).getPrimitiveType();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(primitiveType, "getPrimitiveType(...)");
            if (i > 0) {
                return new kotlin.reflect.jvm.internal.impl.resolve.constants.ClassLiteralValue(kotlin.reflect.jvm.internal.impl.name.ClassId.Companion.topLevel(primitiveType.getArrayTypeFqName()), i - 1);
            }
            return new kotlin.reflect.jvm.internal.impl.resolve.constants.ClassLiteralValue(kotlin.reflect.jvm.internal.impl.name.ClassId.Companion.topLevel(primitiveType.getTypeFqName()), i);
        }
        kotlin.reflect.jvm.internal.impl.name.ClassId classId = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt.getClassId(cls);
        kotlin.reflect.jvm.internal.impl.name.ClassId classIdMapJavaToKotlin = kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap.INSTANCE.mapJavaToKotlin(classId.asSingleFqName());
        if (classIdMapJavaToKotlin != null) {
            classId = classIdMapJavaToKotlin;
        }
        return new kotlin.reflect.jvm.internal.impl.resolve.constants.ClassLiteralValue(classId, i);
    }

    private final void processAnnotationArgumentValue(kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor annotationArgumentVisitor, kotlin.reflect.jvm.internal.impl.name.Name name, java.lang.Object obj) throws java.lang.reflect.InvocationTargetException {
        java.lang.Class<?> enclosingClass = obj.getClass();
        if (!kotlin.jvm.internal.Intrinsics.areEqual(enclosingClass, java.lang.Class.class)) {
            if (kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClassKt.TYPES_ELIGIBLE_FOR_SIMPLE_VISIT.contains(enclosingClass)) {
                annotationArgumentVisitor.visit(name, obj);
                return;
            }
            if (kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt.isEnumClassOrSpecializedEnumEntryClass(enclosingClass)) {
                if (!enclosingClass.isEnum()) {
                    enclosingClass = enclosingClass.getEnclosingClass();
                }
                kotlin.jvm.internal.Intrinsics.checkNotNull(enclosingClass);
                kotlin.reflect.jvm.internal.impl.name.ClassId classId = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt.getClassId(enclosingClass);
                kotlin.jvm.internal.Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Enum<*>");
                kotlin.reflect.jvm.internal.impl.name.Name nameIdentifier = kotlin.reflect.jvm.internal.impl.name.Name.identifier(((java.lang.Enum) obj).name());
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameIdentifier, "identifier(...)");
                annotationArgumentVisitor.visitEnum(name, classId, nameIdentifier);
                return;
            }
            if (java.lang.annotation.Annotation.class.isAssignableFrom(enclosingClass)) {
                java.lang.Class<?>[] interfaces = enclosingClass.getInterfaces();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(interfaces, "getInterfaces(...)");
                java.lang.Class<?> cls = (java.lang.Class) kotlin.collections.ArraysKt.single(interfaces);
                kotlin.jvm.internal.Intrinsics.checkNotNull(cls);
                kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor annotationArgumentVisitorVisitAnnotation = annotationArgumentVisitor.visitAnnotation(name, kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt.getClassId(cls));
                if (annotationArgumentVisitorVisitAnnotation == null) {
                    return;
                }
                kotlin.jvm.internal.Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Annotation");
                processAnnotationArguments(annotationArgumentVisitorVisitAnnotation, (java.lang.annotation.Annotation) obj, cls);
                return;
            }
            if (enclosingClass.isArray()) {
                kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor annotationArrayArgumentVisitorVisitArray = annotationArgumentVisitor.visitArray(name);
                if (annotationArrayArgumentVisitorVisitArray == null) {
                    return;
                }
                java.lang.Class<?> componentType = enclosingClass.getComponentType();
                int i = 0;
                if (componentType.isEnum()) {
                    kotlin.jvm.internal.Intrinsics.checkNotNull(componentType);
                    kotlin.reflect.jvm.internal.impl.name.ClassId classId2 = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt.getClassId(componentType);
                    kotlin.jvm.internal.Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<*>");
                    java.lang.Object[] objArr = (java.lang.Object[]) obj;
                    int length = objArr.length;
                    while (i < length) {
                        java.lang.Object obj2 = objArr[i];
                        kotlin.jvm.internal.Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Enum<*>");
                        kotlin.reflect.jvm.internal.impl.name.Name nameIdentifier2 = kotlin.reflect.jvm.internal.impl.name.Name.identifier(((java.lang.Enum) obj2).name());
                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameIdentifier2, "identifier(...)");
                        annotationArrayArgumentVisitorVisitArray.visitEnum(classId2, nameIdentifier2);
                        i++;
                    }
                } else if (kotlin.jvm.internal.Intrinsics.areEqual(componentType, java.lang.Class.class)) {
                    kotlin.jvm.internal.Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<*>");
                    java.lang.Object[] objArr2 = (java.lang.Object[]) obj;
                    int length2 = objArr2.length;
                    while (i < length2) {
                        java.lang.Object obj3 = objArr2[i];
                        kotlin.jvm.internal.Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type java.lang.Class<*>");
                        annotationArrayArgumentVisitorVisitArray.visitClassLiteral(classLiteralValue((java.lang.Class) obj3));
                        i++;
                    }
                } else if (java.lang.annotation.Annotation.class.isAssignableFrom(componentType)) {
                    kotlin.jvm.internal.Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<*>");
                    java.lang.Object[] objArr3 = (java.lang.Object[]) obj;
                    int length3 = objArr3.length;
                    while (i < length3) {
                        java.lang.Object obj4 = objArr3[i];
                        kotlin.jvm.internal.Intrinsics.checkNotNull(componentType);
                        kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor annotationArgumentVisitorVisitAnnotation2 = annotationArrayArgumentVisitorVisitArray.visitAnnotation(kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt.getClassId(componentType));
                        if (annotationArgumentVisitorVisitAnnotation2 != null) {
                            kotlin.jvm.internal.Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.Annotation");
                            processAnnotationArguments(annotationArgumentVisitorVisitAnnotation2, (java.lang.annotation.Annotation) obj4, componentType);
                        }
                        i++;
                    }
                } else {
                    kotlin.jvm.internal.Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<*>");
                    java.lang.Object[] objArr4 = (java.lang.Object[]) obj;
                    int length4 = objArr4.length;
                    while (i < length4) {
                        annotationArrayArgumentVisitorVisitArray.visit(objArr4[i]);
                        i++;
                    }
                }
                annotationArrayArgumentVisitorVisitArray.visitEnd();
                return;
            }
            throw new java.lang.UnsupportedOperationException("Unsupported annotation argument value (" + enclosingClass + "): " + obj);
        }
        kotlin.jvm.internal.Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type java.lang.Class<*>");
        annotationArgumentVisitor.visitClassLiteral(name, classLiteralValue((java.lang.Class) obj));
    }
}
