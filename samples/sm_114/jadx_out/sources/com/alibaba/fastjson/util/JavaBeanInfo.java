package com.alibaba.fastjson.util;

/* JADX INFO: loaded from: classes.dex */
public class JavaBeanInfo {
    public final java.lang.reflect.Method buildMethod;
    public final java.lang.Class<?> builderClass;
    public final java.lang.Class<?> clazz;
    public final java.lang.reflect.Constructor<?> creatorConstructor;
    public java.lang.reflect.Type[] creatorConstructorParameterTypes;
    public java.lang.String[] creatorConstructorParameters;
    public final java.lang.reflect.Constructor<?> defaultConstructor;
    public final int defaultConstructorParameterSize;
    public final java.lang.reflect.Method factoryMethod;
    public final com.alibaba.fastjson.util.FieldInfo[] fields;
    public final com.alibaba.fastjson.annotation.JSONType jsonType;

    /* JADX INFO: renamed from: kotlin, reason: collision with root package name */
    public boolean f5kotlin;
    public java.lang.reflect.Constructor<?> kotlinDefaultConstructor;
    public java.lang.String[] orders;
    public final int parserFeatures;
    public final com.alibaba.fastjson.util.FieldInfo[] sortedFields;
    public final java.lang.String typeKey;
    public final java.lang.String typeName;

    public JavaBeanInfo(java.lang.Class<?> cls, java.lang.Class<?> cls2, java.lang.reflect.Constructor<?> constructor, java.lang.reflect.Constructor<?> constructor2, java.lang.reflect.Method method, java.lang.reflect.Method method2, com.alibaba.fastjson.annotation.JSONType jSONType, java.util.List<com.alibaba.fastjson.util.FieldInfo> list) {
        com.alibaba.fastjson.annotation.JSONField jSONField;
        this.clazz = cls;
        this.builderClass = cls2;
        this.defaultConstructor = constructor;
        this.creatorConstructor = constructor2;
        this.factoryMethod = method;
        this.parserFeatures = com.alibaba.fastjson.util.TypeUtils.getParserFeatures(cls);
        this.buildMethod = method2;
        this.jsonType = jSONType;
        if (jSONType != null) {
            java.lang.String strTypeName = jSONType.typeName();
            java.lang.String strTypeKey = jSONType.typeKey();
            this.typeKey = strTypeKey.length() <= 0 ? null : strTypeKey;
            if (strTypeName.length() != 0) {
                this.typeName = strTypeName;
            } else {
                this.typeName = cls.getName();
            }
            java.lang.String[] strArrOrders = jSONType.orders();
            this.orders = strArrOrders.length == 0 ? null : strArrOrders;
        } else {
            this.typeName = cls.getName();
            this.typeKey = null;
            this.orders = null;
        }
        com.alibaba.fastjson.util.FieldInfo[] fieldInfoArr = new com.alibaba.fastjson.util.FieldInfo[list.size()];
        this.fields = fieldInfoArr;
        list.toArray(fieldInfoArr);
        com.alibaba.fastjson.util.FieldInfo[] fieldInfoArr2 = new com.alibaba.fastjson.util.FieldInfo[fieldInfoArr.length];
        int i = 0;
        if (this.orders != null) {
            java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap(list.size());
            for (com.alibaba.fastjson.util.FieldInfo fieldInfo : fieldInfoArr) {
                linkedHashMap.put(fieldInfo.name, fieldInfo);
            }
            int i2 = 0;
            for (java.lang.String str : this.orders) {
                com.alibaba.fastjson.util.FieldInfo fieldInfo2 = (com.alibaba.fastjson.util.FieldInfo) linkedHashMap.get(str);
                if (fieldInfo2 != null) {
                    fieldInfoArr2[i2] = fieldInfo2;
                    linkedHashMap.remove(str);
                    i2++;
                }
            }
            java.util.Iterator it = linkedHashMap.values().iterator();
            while (it.hasNext()) {
                fieldInfoArr2[i2] = (com.alibaba.fastjson.util.FieldInfo) it.next();
                i2++;
            }
        } else {
            java.lang.System.arraycopy(fieldInfoArr, 0, fieldInfoArr2, 0, fieldInfoArr.length);
            java.util.Arrays.sort(fieldInfoArr2);
        }
        this.sortedFields = java.util.Arrays.equals(this.fields, fieldInfoArr2) ? this.fields : fieldInfoArr2;
        if (constructor != null) {
            this.defaultConstructorParameterSize = constructor.getParameterTypes().length;
        } else if (method != null) {
            this.defaultConstructorParameterSize = method.getParameterTypes().length;
        } else {
            this.defaultConstructorParameterSize = 0;
        }
        if (constructor2 != null) {
            this.creatorConstructorParameterTypes = constructor2.getParameterTypes();
            boolean zIsKotlin = com.alibaba.fastjson.util.TypeUtils.isKotlin(cls);
            this.f5kotlin = zIsKotlin;
            if (zIsKotlin) {
                this.creatorConstructorParameters = com.alibaba.fastjson.util.TypeUtils.getKoltinConstructorParameters(cls);
                try {
                    this.kotlinDefaultConstructor = cls.getConstructor(null);
                } catch (java.lang.Throwable unused) {
                }
                java.lang.annotation.Annotation[][] parameterAnnotations = com.alibaba.fastjson.util.TypeUtils.getParameterAnnotations(constructor2);
                for (int i3 = 0; i3 < this.creatorConstructorParameters.length && i3 < parameterAnnotations.length; i3++) {
                    java.lang.annotation.Annotation[] annotationArr = parameterAnnotations[i3];
                    int length = annotationArr.length;
                    int i4 = 0;
                    while (true) {
                        if (i4 >= length) {
                            jSONField = null;
                            break;
                        }
                        java.lang.annotation.Annotation annotation = annotationArr[i4];
                        if (annotation instanceof com.alibaba.fastjson.annotation.JSONField) {
                            jSONField = (com.alibaba.fastjson.annotation.JSONField) annotation;
                            break;
                        }
                        i4++;
                    }
                    if (jSONField != null) {
                        java.lang.String strName = jSONField.name();
                        if (strName.length() > 0) {
                            this.creatorConstructorParameters[i3] = strName;
                        }
                    }
                }
                return;
            }
            if (this.creatorConstructorParameterTypes.length == this.fields.length) {
                while (true) {
                    java.lang.reflect.Type[] typeArr = this.creatorConstructorParameterTypes;
                    if (i >= typeArr.length) {
                        return;
                    }
                    if (typeArr[i] == this.fields[i].fieldClass) {
                        i++;
                    }
                }
            }
            this.creatorConstructorParameters = com.alibaba.fastjson.util.ASMUtils.lookupParameterNames(constructor2);
        }
    }

    private static com.alibaba.fastjson.util.FieldInfo getField(java.util.List<com.alibaba.fastjson.util.FieldInfo> list, java.lang.String str) {
        java.lang.reflect.Field field;
        for (com.alibaba.fastjson.util.FieldInfo fieldInfo : list) {
            if (fieldInfo.name.equals(str) || ((field = fieldInfo.field) != null && fieldInfo.getAnnotation() != null && field.getName().equals(str))) {
                return fieldInfo;
            }
        }
        return null;
    }

    static boolean add(java.util.List<com.alibaba.fastjson.util.FieldInfo> list, com.alibaba.fastjson.util.FieldInfo fieldInfo) {
        for (int size = list.size() - 1; size >= 0; size--) {
            com.alibaba.fastjson.util.FieldInfo fieldInfo2 = list.get(size);
            if (fieldInfo2.name.equals(fieldInfo.name) && (!fieldInfo2.getOnly || fieldInfo.getOnly)) {
                if (fieldInfo2.fieldClass.isAssignableFrom(fieldInfo.fieldClass)) {
                    list.set(size, fieldInfo);
                    return true;
                }
                if (fieldInfo2.compareTo(fieldInfo) >= 0) {
                    return false;
                }
                list.set(size, fieldInfo);
                return true;
            }
        }
        list.add(fieldInfo);
        return true;
    }

    public static com.alibaba.fastjson.util.JavaBeanInfo build(java.lang.Class<?> cls, java.lang.reflect.Type type, com.alibaba.fastjson.PropertyNamingStrategy propertyNamingStrategy) {
        return build(cls, type, propertyNamingStrategy, false, com.alibaba.fastjson.util.TypeUtils.compatibleWithJavaBean, false);
    }

    private static java.util.Map<java.lang.reflect.TypeVariable, java.lang.reflect.Type> buildGenericInfo(java.lang.Class<?> cls) {
        java.lang.Class<? super java.lang.Object> superclass = cls.getSuperclass();
        java.util.HashMap map = null;
        if (superclass == null) {
            return null;
        }
        while (true) {
            java.lang.Class<? super java.lang.Object> cls2 = superclass;
            java.lang.Class<?> cls3 = cls;
            cls = cls2;
            if (cls == null || cls == java.lang.Object.class) {
                break;
            }
            if (cls3.getGenericSuperclass() instanceof java.lang.reflect.ParameterizedType) {
                java.lang.reflect.Type[] actualTypeArguments = ((java.lang.reflect.ParameterizedType) cls3.getGenericSuperclass()).getActualTypeArguments();
                java.lang.reflect.TypeVariable<java.lang.Class<?>>[] typeParameters = cls.getTypeParameters();
                for (int i = 0; i < actualTypeArguments.length; i++) {
                    if (map == null) {
                        map = new java.util.HashMap();
                    }
                    if (map.containsKey(actualTypeArguments[i])) {
                        map.put(typeParameters[i], map.get(actualTypeArguments[i]));
                    } else {
                        map.put(typeParameters[i], actualTypeArguments[i]);
                    }
                }
            }
            superclass = cls.getSuperclass();
        }
        return map;
    }

    public static com.alibaba.fastjson.util.JavaBeanInfo build(java.lang.Class<?> cls, java.lang.reflect.Type type, com.alibaba.fastjson.PropertyNamingStrategy propertyNamingStrategy, boolean z, boolean z2) {
        return build(cls, type, propertyNamingStrategy, z, z2, false);
    }

    /* JADX WARN: Code duplicated, block: B:237:0x043e  */
    /* JADX WARN: Code duplicated, block: B:304:0x05dd  */
    /* JADX WARN: Code duplicated, block: B:306:0x05ee  */
    /* JADX WARN: Code duplicated, block: B:307:0x060a  */
    /* JADX WARN: Code duplicated, block: B:317:0x0631  */
    /* JADX WARN: Code duplicated, block: B:345:0x06ed A[PHI: r6 r7 r8
  0x06ed: PHI (r6v16 int) = (r6v15 int), (r6v21 int) binds: [B:338:0x06b3, B:343:0x06d8] A[DONT_GENERATE, DONT_INLINE]
  0x06ed: PHI (r7v7 int) = (r7v6 int), (r7v12 int) binds: [B:338:0x06b3, B:343:0x06d8] A[DONT_GENERATE, DONT_INLINE]
  0x06ed: PHI (r8v20 int) = (r8v19 int), (r8v25 int) binds: [B:338:0x06b3, B:343:0x06d8] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:353:0x0703  */
    /* JADX WARN: Code duplicated, block: B:356:0x0710  */
    /* JADX WARN: Code duplicated, block: B:358:0x071c  */
    /* JADX WARN: Code duplicated, block: B:360:0x0728  */
    /* JADX WARN: Code duplicated, block: B:363:0x0738  */
    /* JADX WARN: Code duplicated, block: B:393:0x07d9  */
    /* JADX WARN: Code duplicated, block: B:395:0x07dd  */
    /* JADX WARN: Code duplicated, block: B:397:0x07f5  */
    /* JADX WARN: Code duplicated, block: B:399:0x07f9  */
    /* JADX WARN: Code duplicated, block: B:400:0x0803  */
    /* JADX WARN: Code duplicated, block: B:402:0x080a  */
    /* JADX WARN: Code duplicated, block: B:404:0x0810  */
    /* JADX WARN: Code duplicated, block: B:407:0x0838  */
    /* JADX WARN: Code duplicated, block: B:409:0x083c  */
    /* JADX WARN: Code duplicated, block: B:411:0x0846  */
    /* JADX WARN: Code duplicated, block: B:413:0x084c  */
    /* JADX WARN: Code duplicated, block: B:414:0x085b  */
    /* JADX WARN: Code duplicated, block: B:416:0x0879  */
    /* JADX WARN: Code duplicated, block: B:418:0x08a8  */
    /* JADX WARN: Code duplicated, block: B:420:0x08b3  */
    /* JADX WARN: Code duplicated, block: B:425:0x0902  */
    /* JADX WARN: Code duplicated, block: B:427:0x0911  */
    /* JADX WARN: Code duplicated, block: B:458:0x0996  */
    /* JADX WARN: Code duplicated, block: B:460:0x09a0  */
    /* JADX WARN: Code duplicated, block: B:462:0x09aa  */
    /* JADX WARN: Code duplicated, block: B:467:0x09be  */
    /* JADX WARN: Code duplicated, block: B:470:0x09cb A[PHI: r3
  0x09cb: PHI (r3v13 java.lang.String) = (r3v8 java.lang.String), (r3v8 java.lang.String), (r3v14 java.lang.String) binds: [B:459:0x099e, B:468:0x09c8, B:457:0x0991] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:472:0x09cf  */
    /* JADX WARN: Code duplicated, block: B:476:0x09db  */
    /* JADX WARN: Code duplicated, block: B:480:0x0a0a  */
    /* JADX WARN: Code duplicated, block: B:483:0x0a11  */
    /* JADX WARN: Code duplicated, block: B:485:0x0a15  */
    /* JADX WARN: Code duplicated, block: B:487:0x0a18 A[LOOP:7: B:486:0x0a16->B:487:0x0a18, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:509:0x08e3 A[EDGE_INSN: B:509:0x08e3->B:423:0x08e3 BREAK  A[LOOP:4: B:302:0x05d8->B:422:0x08cd], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:518:0x0725 A[SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:395:0x07dd, please report this as an issue */
    public static com.alibaba.fastjson.util.JavaBeanInfo build(java.lang.Class<?> cls, java.lang.reflect.Type type, com.alibaba.fastjson.PropertyNamingStrategy propertyNamingStrategy, boolean z, boolean z2, boolean z3) {
        java.lang.reflect.Constructor<?> defaultConstructor;
        java.lang.Class<?> cls2;
        com.alibaba.fastjson.PropertyNamingStrategy propertyNamingStrategy2;
        java.lang.reflect.Constructor<?> constructor;
        java.lang.Class<?> cls3;
        java.lang.reflect.Field[] fieldArr;
        java.lang.reflect.Method[] methodArr;
        char c;
        java.lang.String str;
        java.util.ArrayList arrayList;
        java.lang.reflect.Field field;
        java.lang.reflect.Method[] methodArr2;
        int length;
        int i;
        java.lang.String str2;
        java.lang.reflect.Type type2;
        java.lang.reflect.Field field2;
        com.alibaba.fastjson.PropertyNamingStrategy propertyNamingStrategy3;
        java.lang.reflect.Field[] fieldArr2;
        java.lang.reflect.Method[] methods;
        int length2;
        int i2;
        java.lang.reflect.Type type3;
        java.lang.Class<?> superclass;
        java.lang.reflect.Method method;
        java.lang.String name;
        com.alibaba.fastjson.annotation.JSONField jSONField;
        java.lang.String propertyNameByMethodName;
        java.lang.reflect.Field field3;
        com.alibaba.fastjson.annotation.JSONField jSONField2;
        java.lang.reflect.Method[] methodArr3;
        java.lang.reflect.Type type4;
        java.lang.reflect.Method[] methodArr4;
        java.lang.reflect.Method method2;
        java.lang.Class<?> returnType;
        java.lang.Class<?>[] parameterTypes;
        int i3;
        int i4;
        java.lang.reflect.Method[] methodArr5;
        java.lang.reflect.Field field4;
        java.lang.Class<?> cls4;
        com.alibaba.fastjson.annotation.JSONField jSONField3;
        char cCharAt;
        java.lang.reflect.Method[] methodArr6;
        java.util.ArrayList arrayList2;
        java.lang.reflect.Field[] fieldArr3;
        java.lang.String propertyNameByMethodName2;
        java.lang.reflect.Field field5;
        com.alibaba.fastjson.annotation.JSONField jSONField4;
        com.alibaba.fastjson.annotation.JSONField jSONField5;
        java.lang.reflect.Field[] fieldArr4;
        java.lang.String strSubstring;
        java.lang.String strDecapitalize;
        java.lang.String strSubstring2;
        int i5;
        java.lang.reflect.Method method3;
        java.lang.String str3;
        int iOrdinal;
        int i6;
        int i7;
        int i8;
        java.lang.String str4;
        java.lang.StringBuilder sb;
        java.lang.StringBuilder sb2;
        java.lang.String str5;
        char cCharAt2;
        java.lang.reflect.Constructor<?> creatorConstructor;
        java.lang.reflect.Method method4;
        java.lang.String[] strArr;
        java.lang.String[] strArrLookupParameterNames;
        java.lang.String[] strArrLookupParameterNames2;
        java.lang.Class<?>[] clsArr;
        com.alibaba.fastjson.annotation.JSONField jSONField6;
        int iOrdinal2;
        int iOf;
        int iOf2;
        com.alibaba.fastjson.annotation.JSONField jSONField7;
        java.lang.String strName;
        int i9;
        int iOf3;
        int iOf4;
        com.alibaba.fastjson.annotation.JSONField jSONField8;
        java.lang.String strName2;
        java.lang.reflect.Field field6;
        int iOrdinal3;
        int iOf5;
        int iOf6;
        java.lang.annotation.Annotation[][] annotationArr;
        java.lang.reflect.Constructor<?> creatorConstructor2;
        com.alibaba.fastjson.PropertyNamingStrategy propertyNamingStrategyNaming;
        java.lang.Class<?> cls5 = cls;
        com.alibaba.fastjson.annotation.JSONType jSONType = (com.alibaba.fastjson.annotation.JSONType) com.alibaba.fastjson.util.TypeUtils.getAnnotation(cls5, com.alibaba.fastjson.annotation.JSONType.class);
        com.alibaba.fastjson.PropertyNamingStrategy propertyNamingStrategy4 = (jSONType == null || (propertyNamingStrategyNaming = jSONType.naming()) == null || propertyNamingStrategyNaming == com.alibaba.fastjson.PropertyNamingStrategy.CamelCase) ? propertyNamingStrategy : propertyNamingStrategyNaming;
        java.lang.Class<?> builderClass = getBuilderClass(cls5, jSONType);
        java.lang.reflect.Field[] declaredFields = cls5.getDeclaredFields();
        java.lang.reflect.Method[] methods2 = cls5.getMethods();
        java.util.Map<java.lang.reflect.TypeVariable, java.lang.reflect.Type> mapBuildGenericInfo = buildGenericInfo(cls5);
        boolean zIsKotlin = com.alibaba.fastjson.util.TypeUtils.isKotlin(cls5);
        java.lang.reflect.Constructor<?>[] declaredConstructors = cls5.getDeclaredConstructors();
        if (zIsKotlin && declaredConstructors.length != 1) {
            defaultConstructor = null;
        } else if (builderClass == null) {
            defaultConstructor = getDefaultConstructor(cls5, declaredConstructors);
        } else {
            defaultConstructor = getDefaultConstructor(builderClass, builderClass.getDeclaredConstructors());
        }
        java.util.ArrayList arrayList3 = new java.util.ArrayList();
        if (z) {
            for (java.lang.Class<?> superclass2 = cls5; superclass2 != null; superclass2 = superclass2.getSuperclass()) {
                computeFields(cls5, type, propertyNamingStrategy4, arrayList3, superclass2.getDeclaredFields());
            }
            if (defaultConstructor != null) {
                com.alibaba.fastjson.util.TypeUtils.setAccessible(defaultConstructor);
            }
            return new com.alibaba.fastjson.util.JavaBeanInfo(cls, builderClass, defaultConstructor, null, null, null, jSONType, arrayList3);
        }
        java.lang.Class<?> cls6 = builderClass;
        java.lang.reflect.Constructor<?> constructor2 = defaultConstructor;
        java.lang.reflect.Method method5 = null;
        java.lang.reflect.Method method6 = null;
        boolean z4 = cls5.isInterface() || java.lang.reflect.Modifier.isAbstract(cls5.getModifiers());
        if ((constructor2 == null && cls6 == null) || z4) {
            java.lang.reflect.Type mixInAnnotations = com.alibaba.fastjson.JSON.getMixInAnnotations(cls5);
            if (!(mixInAnnotations instanceof java.lang.Class) || (creatorConstructor2 = getCreatorConstructor(((java.lang.Class) mixInAnnotations).getConstructors())) == null) {
                creatorConstructor = null;
            } else {
                try {
                    creatorConstructor = cls5.getConstructor(creatorConstructor2.getParameterTypes());
                } catch (java.lang.NoSuchMethodException unused) {
                    creatorConstructor = null;
                }
            }
            if (creatorConstructor == null) {
                creatorConstructor = getCreatorConstructor(declaredConstructors);
            }
            constructor = creatorConstructor;
            if (constructor != null && !z4) {
                com.alibaba.fastjson.util.TypeUtils.setAccessible(constructor);
                java.lang.Class<?>[] parameterTypes2 = constructor.getParameterTypes();
                if (parameterTypes2.length > 0) {
                    java.lang.annotation.Annotation[][] parameterAnnotations = com.alibaba.fastjson.util.TypeUtils.getParameterAnnotations(constructor);
                    int i10 = 0;
                    java.lang.String[] strArrLookupParameterNames3 = null;
                    while (i10 < parameterTypes2.length && i10 < parameterAnnotations.length) {
                        java.lang.annotation.Annotation[] annotationArr2 = parameterAnnotations[i10];
                        int length3 = annotationArr2.length;
                        int i11 = 0;
                        while (true) {
                            if (i11 >= length3) {
                                jSONField8 = null;
                                break;
                            }
                            java.lang.annotation.Annotation annotation = annotationArr2[i11];
                            if (annotation instanceof com.alibaba.fastjson.annotation.JSONField) {
                                jSONField8 = (com.alibaba.fastjson.annotation.JSONField) annotation;
                                break;
                            }
                            i11++;
                        }
                        java.lang.Class<?> cls7 = parameterTypes2[i10];
                        java.lang.reflect.Type type5 = constructor.getGenericParameterTypes()[i10];
                        if (jSONField8 != null) {
                            field6 = com.alibaba.fastjson.util.TypeUtils.getField(cls5, jSONField8.name(), declaredFields);
                            iOrdinal3 = jSONField8.ordinal();
                            iOf5 = com.alibaba.fastjson.serializer.SerializerFeature.of(jSONField8.serialzeFeatures());
                            iOf6 = com.alibaba.fastjson.parser.Feature.of(jSONField8.parseFeatures());
                            strName2 = jSONField8.name();
                        } else {
                            strName2 = null;
                            field6 = null;
                            iOrdinal3 = 0;
                            iOf5 = 0;
                            iOf6 = 0;
                        }
                        if (strName2 == null || strName2.length() == 0) {
                            if (strArrLookupParameterNames3 == null) {
                                strArrLookupParameterNames3 = com.alibaba.fastjson.util.ASMUtils.lookupParameterNames(constructor);
                            }
                            strName2 = strArrLookupParameterNames3[i10];
                        }
                        if (field6 == null) {
                            if (strArrLookupParameterNames3 == null) {
                                if (zIsKotlin) {
                                    strArrLookupParameterNames3 = com.alibaba.fastjson.util.TypeUtils.getKoltinConstructorParameters(cls5);
                                } else {
                                    strArrLookupParameterNames3 = com.alibaba.fastjson.util.ASMUtils.lookupParameterNames(constructor);
                                }
                            }
                            annotationArr = parameterAnnotations;
                            if (strArrLookupParameterNames3.length > i10) {
                                field6 = com.alibaba.fastjson.util.TypeUtils.getField(cls5, strArrLookupParameterNames3[i10], declaredFields);
                            }
                        } else {
                            annotationArr = parameterAnnotations;
                        }
                        java.lang.String[] strArr2 = strArrLookupParameterNames3;
                        java.lang.Class<?> cls8 = cls5;
                        java.util.ArrayList arrayList4 = arrayList3;
                        cls5 = cls8;
                        add(arrayList4, new com.alibaba.fastjson.util.FieldInfo(strName2, cls8, cls7, type5, field6, iOrdinal3, iOf5, iOf6));
                        i10++;
                        arrayList3 = arrayList4;
                        parameterAnnotations = annotationArr;
                        propertyNamingStrategy4 = propertyNamingStrategy4;
                        strArrLookupParameterNames3 = strArr2;
                    }
                }
                propertyNamingStrategy2 = propertyNamingStrategy4;
                cls2 = cls5;
                arrayList3 = arrayList3;
                cls6 = cls6;
            } else {
                arrayList3 = arrayList3;
                propertyNamingStrategy2 = propertyNamingStrategy4;
                char c2 = 1;
                int i12 = 2;
                java.lang.reflect.Method factoryMethod = getFactoryMethod(cls5, methods2, z3);
                if (factoryMethod != null) {
                    com.alibaba.fastjson.util.TypeUtils.setAccessible(factoryMethod);
                    java.lang.Class<?>[] parameterTypes3 = factoryMethod.getParameterTypes();
                    if (parameterTypes3.length > 0) {
                        java.lang.annotation.Annotation[][] parameterAnnotations2 = com.alibaba.fastjson.util.TypeUtils.getParameterAnnotations(factoryMethod);
                        java.lang.String[] strArrLookupParameterNames4 = null;
                        int i13 = 0;
                        while (i13 < parameterTypes3.length) {
                            java.lang.annotation.Annotation[] annotationArr3 = parameterAnnotations2[i13];
                            int length4 = annotationArr3.length;
                            int i14 = 0;
                            while (true) {
                                if (i14 >= length4) {
                                    jSONField7 = null;
                                    break;
                                }
                                java.lang.annotation.Annotation annotation2 = annotationArr3[i14];
                                if (annotation2 instanceof com.alibaba.fastjson.annotation.JSONField) {
                                    jSONField7 = (com.alibaba.fastjson.annotation.JSONField) annotation2;
                                    break;
                                }
                                i14++;
                            }
                            if (jSONField7 == null && (!z3 || !com.alibaba.fastjson.util.TypeUtils.isJacksonCreator(factoryMethod))) {
                                throw new com.alibaba.fastjson.JSONException("illegal json creator");
                            }
                            if (jSONField7 != null) {
                                strName = jSONField7.name();
                                int iOrdinal4 = jSONField7.ordinal();
                                iOf3 = com.alibaba.fastjson.serializer.SerializerFeature.of(jSONField7.serialzeFeatures());
                                iOf4 = com.alibaba.fastjson.parser.Feature.of(jSONField7.parseFeatures());
                                i9 = iOrdinal4;
                            } else {
                                strName = null;
                                i9 = 0;
                                iOf3 = 0;
                                iOf4 = 0;
                            }
                            if (strName == null || strName.length() == 0) {
                                if (strArrLookupParameterNames4 == null) {
                                    strArrLookupParameterNames4 = com.alibaba.fastjson.util.ASMUtils.lookupParameterNames(factoryMethod);
                                }
                                strName = strArrLookupParameterNames4[i13];
                            }
                            java.lang.String[] strArr3 = strArrLookupParameterNames4;
                            java.lang.String str6 = strName;
                            add(arrayList3, new com.alibaba.fastjson.util.FieldInfo(str6, cls5, parameterTypes3[i13], factoryMethod.getGenericParameterTypes()[i13], com.alibaba.fastjson.util.TypeUtils.getField(cls5, str6, declaredFields), i9, iOf3, iOf4));
                            i13++;
                            cls5 = cls;
                            strArrLookupParameterNames4 = strArr3;
                            parameterTypes3 = parameterTypes3;
                        }
                        return new com.alibaba.fastjson.util.JavaBeanInfo(cls, cls6, null, null, factoryMethod, null, jSONType, arrayList3);
                    }
                    method4 = factoryMethod;
                } else {
                    method4 = factoryMethod;
                    if (!z4) {
                        java.lang.String name2 = cls5.getName();
                        if (zIsKotlin && declaredConstructors.length > 0) {
                            java.lang.String[] koltinConstructorParameters = com.alibaba.fastjson.util.TypeUtils.getKoltinConstructorParameters(cls5);
                            java.lang.reflect.Constructor<?> kotlinConstructor = com.alibaba.fastjson.util.TypeUtils.getKotlinConstructor(declaredConstructors, koltinConstructorParameters);
                            com.alibaba.fastjson.util.TypeUtils.setAccessible(kotlinConstructor);
                            constructor = kotlinConstructor;
                            strArr = koltinConstructorParameters;
                        } else {
                            int length5 = declaredConstructors.length;
                            java.lang.String[] strArr4 = null;
                            int i15 = 0;
                            while (true) {
                                if (i15 >= length5) {
                                    strArr = strArr4;
                                    break;
                                }
                                java.lang.reflect.Constructor<?> constructor3 = declaredConstructors[i15];
                                java.lang.Class<?>[] parameterTypes4 = constructor3.getParameterTypes();
                                if (name2.equals("org.springframework.security.web.authentication.WebAuthenticationDetails")) {
                                    if (parameterTypes4.length == i12 && parameterTypes4[0] == java.lang.String.class && parameterTypes4[c2] == java.lang.String.class) {
                                        constructor3.setAccessible(true);
                                        strArrLookupParameterNames2 = com.alibaba.fastjson.util.ASMUtils.lookupParameterNames(constructor3);
                                        strArr = strArrLookupParameterNames2;
                                        constructor = constructor3;
                                        break;
                                    }
                                    i15++;
                                    c2 = 1;
                                    i12 = 2;
                                } else if (name2.equals("org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken")) {
                                    if (parameterTypes4.length == 3 && parameterTypes4[0] == java.lang.Object.class && parameterTypes4[1] == java.lang.Object.class && parameterTypes4[2] == java.util.Collection.class) {
                                        constructor3.setAccessible(true);
                                        strArrLookupParameterNames2 = new java.lang.String[]{"principal", "credentials", "authorities"};
                                        strArr = strArrLookupParameterNames2;
                                        constructor = constructor3;
                                        break;
                                    }
                                    i15++;
                                    c2 = 1;
                                    i12 = 2;
                                } else {
                                    if (name2.equals("org.springframework.security.core.authority.SimpleGrantedAuthority")) {
                                        if (parameterTypes4.length == 1 && parameterTypes4[0] == java.lang.String.class) {
                                            strArrLookupParameterNames2 = new java.lang.String[]{io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_AUTHORITY};
                                            strArr = strArrLookupParameterNames2;
                                            constructor = constructor3;
                                            break;
                                        }
                                    } else if (((constructor3.getModifiers() & 1) != 0) && (strArrLookupParameterNames = com.alibaba.fastjson.util.ASMUtils.lookupParameterNames(constructor3)) != null && strArrLookupParameterNames.length != 0 && (constructor == null || strArr4 == null || strArrLookupParameterNames.length > strArr4.length)) {
                                        constructor = constructor3;
                                        strArr4 = strArrLookupParameterNames;
                                    }
                                    i15++;
                                    c2 = 1;
                                    i12 = 2;
                                }
                            }
                        }
                        java.lang.Class<?>[] parameterTypes5 = strArr != null ? constructor.getParameterTypes() : null;
                        if (strArr != null && parameterTypes5.length == strArr.length) {
                            java.lang.annotation.Annotation[][] parameterAnnotations3 = com.alibaba.fastjson.util.TypeUtils.getParameterAnnotations(constructor);
                            int i16 = 0;
                            while (i16 < parameterTypes5.length) {
                                java.lang.annotation.Annotation[] annotationArr4 = parameterAnnotations3[i16];
                                java.lang.String str7 = strArr[i16];
                                int length6 = annotationArr4.length;
                                int i17 = 0;
                                while (true) {
                                    if (i17 >= length6) {
                                        clsArr = parameterTypes5;
                                        jSONField6 = null;
                                        break;
                                    }
                                    java.lang.annotation.Annotation annotation3 = annotationArr4[i17];
                                    clsArr = parameterTypes5;
                                    if (annotation3 instanceof com.alibaba.fastjson.annotation.JSONField) {
                                        jSONField6 = (com.alibaba.fastjson.annotation.JSONField) annotation3;
                                        break;
                                    }
                                    i17++;
                                    parameterTypes5 = clsArr;
                                }
                                java.lang.Class<?> cls9 = clsArr[i16];
                                java.lang.reflect.Type type6 = constructor.getGenericParameterTypes()[i16];
                                java.lang.reflect.Field field7 = com.alibaba.fastjson.util.TypeUtils.getField(cls5, str7, declaredFields);
                                if (field7 != null && jSONField6 == null) {
                                    jSONField6 = (com.alibaba.fastjson.annotation.JSONField) com.alibaba.fastjson.util.TypeUtils.getAnnotation(field7, com.alibaba.fastjson.annotation.JSONField.class);
                                }
                                if (jSONField6 == null) {
                                    if ("org.springframework.security.core.userdetails.User".equals(name2) && com.taobao.weex.common.Constants.Value.PASSWORD.equals(str7)) {
                                        iOf2 = com.alibaba.fastjson.parser.Feature.InitStringFieldAsEmpty.mask;
                                        iOrdinal2 = 0;
                                    } else {
                                        iOrdinal2 = 0;
                                        iOf2 = 0;
                                    }
                                    iOf = 0;
                                } else {
                                    java.lang.String strName3 = jSONField6.name();
                                    if (strName3.length() != 0) {
                                        str7 = strName3;
                                    }
                                    iOrdinal2 = jSONField6.ordinal();
                                    iOf = com.alibaba.fastjson.serializer.SerializerFeature.of(jSONField6.serialzeFeatures());
                                    iOf2 = com.alibaba.fastjson.parser.Feature.of(jSONField6.parseFeatures());
                                    type6 = type6;
                                }
                                add(arrayList3, new com.alibaba.fastjson.util.FieldInfo(str7, cls, cls9, type6, field7, iOrdinal2, iOf, iOf2));
                                i16++;
                                cls5 = cls;
                                name2 = name2;
                                parameterTypes5 = clsArr;
                            }
                            if (!zIsKotlin && !cls.getName().equals("javax.servlet.http.Cookie")) {
                                return new com.alibaba.fastjson.util.JavaBeanInfo(cls, cls6, null, constructor, null, null, jSONType, arrayList3);
                            }
                            cls2 = cls;
                            constructor = constructor;
                        } else {
                            throw new com.alibaba.fastjson.JSONException("default constructor not found. " + cls5);
                        }
                    }
                    method5 = method4;
                }
                cls2 = cls5;
                method5 = method4;
            }
        } else {
            cls2 = cls5;
            propertyNamingStrategy2 = propertyNamingStrategy4;
            cls6 = cls6;
            constructor = null;
        }
        if (constructor2 != null) {
            com.alibaba.fastjson.util.TypeUtils.setAccessible(constructor2);
        }
        java.lang.String str8 = "set";
        if (cls6 == null) {
            cls3 = cls6;
            fieldArr = declaredFields;
            methodArr = methods2;
            c = 0;
            str = "set";
            arrayList = arrayList3;
        } else {
            com.alibaba.fastjson.annotation.JSONPOJOBuilder jSONPOJOBuilder = (com.alibaba.fastjson.annotation.JSONPOJOBuilder) com.alibaba.fastjson.util.TypeUtils.getAnnotation(cls6, com.alibaba.fastjson.annotation.JSONPOJOBuilder.class);
            java.lang.String strWithPrefix = jSONPOJOBuilder != null ? jSONPOJOBuilder.withPrefix() : null;
            if (strWithPrefix == null) {
                strWithPrefix = "with";
            }
            java.lang.reflect.Method[] methods3 = cls6.getMethods();
            int length7 = methods3.length;
            int i18 = 0;
            while (i18 < length7) {
                java.lang.String str9 = strWithPrefix;
                java.lang.reflect.Method method7 = methods3[i18];
                if (!java.lang.reflect.Modifier.isStatic(method7.getModifiers()) && method7.getReturnType().equals(cls6)) {
                    com.alibaba.fastjson.annotation.JSONField superMethodAnnotation = (com.alibaba.fastjson.annotation.JSONField) com.alibaba.fastjson.util.TypeUtils.getAnnotation(method7, com.alibaba.fastjson.annotation.JSONField.class);
                    if (superMethodAnnotation == null) {
                        superMethodAnnotation = com.alibaba.fastjson.util.TypeUtils.getSuperMethodAnnotation(cls2, method7);
                    }
                    if (superMethodAnnotation == null) {
                        str3 = str9;
                        iOrdinal = 0;
                        i6 = 0;
                        i7 = 0;
                        i8 = 0;
                    } else if (superMethodAnnotation.deserialize()) {
                        iOrdinal = superMethodAnnotation.ordinal();
                        int iOf7 = com.alibaba.fastjson.serializer.SerializerFeature.of(superMethodAnnotation.serialzeFeatures());
                        int iOf8 = com.alibaba.fastjson.parser.Feature.of(superMethodAnnotation.parseFeatures());
                        if (superMethodAnnotation.name().length() != 0) {
                            str5 = str9;
                            methods3 = methods3;
                            cls6 = cls6;
                            declaredFields = declaredFields;
                            methods2 = methods2;
                            str8 = str8;
                            i18 = i18;
                            arrayList3 = arrayList3;
                            length7 = length7;
                            add(arrayList3, new com.alibaba.fastjson.util.FieldInfo(superMethodAnnotation.name(), method7, null, cls, type, iOrdinal, iOf7, iOf8, superMethodAnnotation, null, null, mapBuildGenericInfo));
                        } else {
                            str3 = str9;
                            i6 = iOf7;
                            i7 = iOf8;
                            i8 = 0;
                        }
                    } else {
                        methods3 = methods3;
                        length7 = length7;
                        i18 = i18;
                        str5 = str9;
                        cls6 = cls6;
                        declaredFields = declaredFields;
                        methods2 = methods2;
                        str8 = str8;
                        arrayList3 = arrayList3;
                    }
                    java.lang.String name3 = method7.getName();
                    if (name3.startsWith(str8) && name3.length() > 3) {
                        sb2 = new java.lang.StringBuilder(name3.substring(3));
                    } else {
                        if (str3.length() == 0) {
                            sb2 = new java.lang.StringBuilder(name3);
                        } else {
                            str4 = str3;
                            if (name3.startsWith(str4) && name3.length() > str4.length()) {
                                sb = new java.lang.StringBuilder(name3.substring(str4.length()));
                                cCharAt2 = sb.charAt(i8);
                                if (str4.length() != 0 || java.lang.Character.isUpperCase(cCharAt2)) {
                                    sb.setCharAt(i8, java.lang.Character.toLowerCase(cCharAt2));
                                    str5 = str4;
                                    add(arrayList3, new com.alibaba.fastjson.util.FieldInfo(sb.toString(), method7, null, cls, type, iOrdinal, i6, i7, superMethodAnnotation, null, null, mapBuildGenericInfo));
                                }
                            }
                        }
                        str5 = str4;
                    }
                    sb = sb2;
                    str4 = str3;
                    cCharAt2 = sb.charAt(i8);
                    if (str4.length() != 0) {
                    }
                    sb.setCharAt(i8, java.lang.Character.toLowerCase(cCharAt2));
                    str5 = str4;
                    add(arrayList3, new com.alibaba.fastjson.util.FieldInfo(sb.toString(), method7, null, cls, type, iOrdinal, i6, i7, superMethodAnnotation, null, null, mapBuildGenericInfo));
                } else {
                    methods3 = methods3;
                    length7 = length7;
                    i18 = i18;
                    str5 = str9;
                    cls6 = cls6;
                    declaredFields = declaredFields;
                    methods2 = methods2;
                    str8 = str8;
                    arrayList3 = arrayList3;
                }
                i18++;
                cls2 = cls;
                cls6 = cls6;
                arrayList3 = arrayList3;
                str8 = str8;
                length7 = length7;
                strWithPrefix = str5;
                methods3 = methods3;
                declaredFields = declaredFields;
                methods2 = methods2;
            }
            java.lang.Class<?> cls10 = cls6;
            fieldArr = declaredFields;
            methodArr = methods2;
            c = 0;
            str = str8;
            arrayList = arrayList3;
            if (cls10 != null) {
                cls3 = cls10;
                com.alibaba.fastjson.annotation.JSONPOJOBuilder jSONPOJOBuilder2 = (com.alibaba.fastjson.annotation.JSONPOJOBuilder) com.alibaba.fastjson.util.TypeUtils.getAnnotation(cls3, com.alibaba.fastjson.annotation.JSONPOJOBuilder.class);
                java.lang.String strBuildMethod = jSONPOJOBuilder2 != null ? jSONPOJOBuilder2.buildMethod() : null;
                if (strBuildMethod == null || strBuildMethod.length() == 0) {
                    strBuildMethod = "build";
                }
                field = null;
                try {
                    method3 = cls3.getMethod(strBuildMethod, null);
                } catch (java.lang.NoSuchMethodException | java.lang.SecurityException unused2) {
                    method3 = null;
                }
                if (method3 == null) {
                    try {
                        method3 = cls3.getMethod("create", null);
                    } catch (java.lang.NoSuchMethodException | java.lang.SecurityException unused3) {
                    }
                }
                if (method3 == null) {
                    throw new com.alibaba.fastjson.JSONException("buildMethod not found.");
                }
                com.alibaba.fastjson.util.TypeUtils.setAccessible(method3);
                method6 = method3;
            } else {
                cls3 = cls10;
            }
            methodArr2 = methodArr;
            length = methodArr2.length;
            i = 0;
            while (true) {
                str2 = "get";
                if (i < length) {
                    break;
                }
                methodArr4 = methodArr2;
                method2 = methodArr4[i];
                java.lang.String name4 = method2.getName();
                if (java.lang.reflect.Modifier.isStatic(method2.getModifiers())) {
                    field4 = field;
                    cls4 = cls3;
                    i3 = length;
                    i4 = i;
                    methodArr6 = methodArr4;
                    fieldArr3 = fieldArr;
                } else {
                    returnType = method2.getReturnType();
                    if ((!returnType.equals(java.lang.Void.TYPE) || returnType.equals(method2.getDeclaringClass())) && method2.getDeclaringClass() != java.lang.Object.class) {
                        parameterTypes = method2.getParameterTypes();
                        if (parameterTypes.length != 0 || parameterTypes.length > 2) {
                            field4 = field;
                            cls4 = cls3;
                            i3 = length;
                            i4 = i;
                            methodArr6 = methodArr4;
                            fieldArr3 = fieldArr;
                        } else {
                            com.alibaba.fastjson.annotation.JSONField superMethodAnnotation2 = (com.alibaba.fastjson.annotation.JSONField) com.alibaba.fastjson.util.TypeUtils.getAnnotation(method2, com.alibaba.fastjson.annotation.JSONField.class);
                            int iOf9 = 0;
                            if (superMethodAnnotation2 != null && parameterTypes.length == 2 && parameterTypes[c] == java.lang.String.class && parameterTypes[1] == java.lang.Object.class) {
                                i4 = i;
                                i3 = length;
                                methodArr5 = methodArr4;
                                field4 = null;
                                cls4 = cls3;
                                add(arrayList, new com.alibaba.fastjson.util.FieldInfo("", method2, null, cls, type, 0, 0, 0, superMethodAnnotation2, null, null, mapBuildGenericInfo));
                            } else {
                                i3 = length;
                                i4 = i;
                                methodArr5 = methodArr4;
                                int iOrdinal5 = 0;
                                int iOf10 = 0;
                                field4 = null;
                                cls4 = cls3;
                                if (parameterTypes.length == 1) {
                                    if (superMethodAnnotation2 == null) {
                                        superMethodAnnotation2 = com.alibaba.fastjson.util.TypeUtils.getSuperMethodAnnotation(cls, method2);
                                    }
                                    if (superMethodAnnotation2 != null || name4.length() >= 4) {
                                        if (superMethodAnnotation2 != null) {
                                            if (superMethodAnnotation2.deserialize()) {
                                                iOrdinal5 = superMethodAnnotation2.ordinal();
                                                iOf10 = com.alibaba.fastjson.serializer.SerializerFeature.of(superMethodAnnotation2.serialzeFeatures());
                                                iOf9 = com.alibaba.fastjson.parser.Feature.of(superMethodAnnotation2.parseFeatures());
                                                if (superMethodAnnotation2.name().length() != 0) {
                                                    add(arrayList, new com.alibaba.fastjson.util.FieldInfo(superMethodAnnotation2.name(), method2, null, cls, type, iOrdinal5, iOf10, iOf9, superMethodAnnotation2, null, null, mapBuildGenericInfo));
                                                } else {
                                                    jSONField3 = superMethodAnnotation2;
                                                    if (jSONField3 == null) {
                                                        cCharAt = name4.charAt(3);
                                                        if (zIsKotlin) {
                                                            arrayList2 = new java.util.ArrayList();
                                                            methodArr6 = methodArr5;
                                                            for (i5 = 0; i5 < methodArr6.length; i5++) {
                                                                if (methodArr6[i5].getName().startsWith("get")) {
                                                                    arrayList2.add(methodArr6[i5].getName());
                                                                }
                                                            }
                                                        } else {
                                                            methodArr6 = methodArr5;
                                                            arrayList2 = null;
                                                        }
                                                        if (java.lang.Character.isUpperCase(cCharAt)) {
                                                            fieldArr3 = fieldArr;
                                                            if (zIsKotlin) {
                                                                propertyNameByMethodName2 = com.alibaba.fastjson.util.TypeUtils.getPropertyNameByMethodName("g" + name4.substring(1));
                                                            } else if (com.alibaba.fastjson.util.TypeUtils.compatibleWithJavaBean) {
                                                                propertyNameByMethodName2 = com.alibaba.fastjson.util.TypeUtils.decapitalize(name4.substring(3));
                                                            } else {
                                                                propertyNameByMethodName2 = com.alibaba.fastjson.util.TypeUtils.getPropertyNameByMethodName(name4);
                                                            }
                                                            field5 = null;
                                                            if (field5 == null) {
                                                                field5 = com.alibaba.fastjson.util.TypeUtils.getField(cls, propertyNameByMethodName2, fieldArr3);
                                                            }
                                                            if (field5 != null) {
                                                            }
                                                            if (field5 != null) {
                                                                jSONField5 = (com.alibaba.fastjson.annotation.JSONField) com.alibaba.fastjson.util.TypeUtils.getAnnotation(field5, com.alibaba.fastjson.annotation.JSONField.class);
                                                                if (jSONField5 != null) {
                                                                    if (jSONField5.deserialize()) {
                                                                        iOrdinal5 = jSONField5.ordinal();
                                                                        iOf10 = com.alibaba.fastjson.serializer.SerializerFeature.of(jSONField5.serialzeFeatures());
                                                                        iOf9 = com.alibaba.fastjson.parser.Feature.of(jSONField5.parseFeatures());
                                                                        if (jSONField5.name().length() != 0) {
                                                                            methodArr6 = methodArr6;
                                                                            fieldArr3 = fieldArr3;
                                                                            add(arrayList, new com.alibaba.fastjson.util.FieldInfo(jSONField5.name(), method2, field5, cls, type, iOrdinal5, iOf10, iOf9, jSONField3, jSONField5, null, mapBuildGenericInfo));
                                                                        }
                                                                    } else {
                                                                        methodArr6 = methodArr6;
                                                                        fieldArr3 = fieldArr3;
                                                                    }
                                                                }
                                                                jSONField4 = jSONField5;
                                                            } else {
                                                                jSONField4 = null;
                                                            }
                                                            if (propertyNamingStrategy2 != null) {
                                                                propertyNameByMethodName2 = propertyNamingStrategy2.translate(propertyNameByMethodName2);
                                                            }
                                                            add(arrayList, new com.alibaba.fastjson.util.FieldInfo(propertyNameByMethodName2, method2, field5, cls, type, iOrdinal5, iOf10, iOf9, jSONField3, jSONField4, null, mapBuildGenericInfo));
                                                        } else {
                                                            fieldArr3 = fieldArr;
                                                            if (zIsKotlin) {
                                                                propertyNameByMethodName2 = com.alibaba.fastjson.util.TypeUtils.getPropertyNameByMethodName("g" + name4.substring(1));
                                                            } else if (com.alibaba.fastjson.util.TypeUtils.compatibleWithJavaBean) {
                                                                propertyNameByMethodName2 = com.alibaba.fastjson.util.TypeUtils.decapitalize(name4.substring(3));
                                                            } else {
                                                                propertyNameByMethodName2 = com.alibaba.fastjson.util.TypeUtils.getPropertyNameByMethodName(name4);
                                                            }
                                                            field5 = null;
                                                            if (field5 == null) {
                                                                field5 = com.alibaba.fastjson.util.TypeUtils.getField(cls, propertyNameByMethodName2, fieldArr3);
                                                            }
                                                            if (field5 != null) {
                                                            }
                                                            if (field5 != null) {
                                                                jSONField5 = (com.alibaba.fastjson.annotation.JSONField) com.alibaba.fastjson.util.TypeUtils.getAnnotation(field5, com.alibaba.fastjson.annotation.JSONField.class);
                                                                if (jSONField5 != null) {
                                                                    if (jSONField5.deserialize()) {
                                                                        methodArr6 = methodArr6;
                                                                        fieldArr3 = fieldArr3;
                                                                    } else {
                                                                        iOrdinal5 = jSONField5.ordinal();
                                                                        iOf10 = com.alibaba.fastjson.serializer.SerializerFeature.of(jSONField5.serialzeFeatures());
                                                                        iOf9 = com.alibaba.fastjson.parser.Feature.of(jSONField5.parseFeatures());
                                                                        if (jSONField5.name().length() != 0) {
                                                                            methodArr6 = methodArr6;
                                                                            fieldArr3 = fieldArr3;
                                                                            add(arrayList, new com.alibaba.fastjson.util.FieldInfo(jSONField5.name(), method2, field5, cls, type, iOrdinal5, iOf10, iOf9, jSONField3, jSONField5, null, mapBuildGenericInfo));
                                                                        }
                                                                    }
                                                                }
                                                                jSONField4 = jSONField5;
                                                            } else {
                                                                jSONField4 = null;
                                                            }
                                                            if (propertyNamingStrategy2 != null) {
                                                                propertyNameByMethodName2 = propertyNamingStrategy2.translate(propertyNameByMethodName2);
                                                            }
                                                            add(arrayList, new com.alibaba.fastjson.util.FieldInfo(propertyNameByMethodName2, method2, field5, cls, type, iOrdinal5, iOf10, iOf9, jSONField3, jSONField4, null, mapBuildGenericInfo));
                                                        }
                                                    } else {
                                                        cCharAt = name4.charAt(3);
                                                        if (zIsKotlin) {
                                                            arrayList2 = new java.util.ArrayList();
                                                            methodArr6 = methodArr5;
                                                            while (i5 < methodArr6.length) {
                                                                if (methodArr6[i5].getName().startsWith("get")) {
                                                                    arrayList2.add(methodArr6[i5].getName());
                                                                }
                                                            }
                                                        } else {
                                                            methodArr6 = methodArr5;
                                                            arrayList2 = null;
                                                        }
                                                        if (java.lang.Character.isUpperCase(cCharAt)) {
                                                            fieldArr3 = fieldArr;
                                                            if (zIsKotlin) {
                                                                propertyNameByMethodName2 = com.alibaba.fastjson.util.TypeUtils.getPropertyNameByMethodName("g" + name4.substring(1));
                                                            } else if (com.alibaba.fastjson.util.TypeUtils.compatibleWithJavaBean) {
                                                                propertyNameByMethodName2 = com.alibaba.fastjson.util.TypeUtils.decapitalize(name4.substring(3));
                                                            } else {
                                                                propertyNameByMethodName2 = com.alibaba.fastjson.util.TypeUtils.getPropertyNameByMethodName(name4);
                                                            }
                                                            field5 = null;
                                                            if (field5 == null) {
                                                                field5 = com.alibaba.fastjson.util.TypeUtils.getField(cls, propertyNameByMethodName2, fieldArr3);
                                                            }
                                                            if (field5 != null) {
                                                            }
                                                            if (field5 != null) {
                                                                jSONField5 = (com.alibaba.fastjson.annotation.JSONField) com.alibaba.fastjson.util.TypeUtils.getAnnotation(field5, com.alibaba.fastjson.annotation.JSONField.class);
                                                                if (jSONField5 != null) {
                                                                    if (jSONField5.deserialize()) {
                                                                        methodArr6 = methodArr6;
                                                                        fieldArr3 = fieldArr3;
                                                                    } else {
                                                                        iOrdinal5 = jSONField5.ordinal();
                                                                        iOf10 = com.alibaba.fastjson.serializer.SerializerFeature.of(jSONField5.serialzeFeatures());
                                                                        iOf9 = com.alibaba.fastjson.parser.Feature.of(jSONField5.parseFeatures());
                                                                        if (jSONField5.name().length() != 0) {
                                                                            methodArr6 = methodArr6;
                                                                            fieldArr3 = fieldArr3;
                                                                            add(arrayList, new com.alibaba.fastjson.util.FieldInfo(jSONField5.name(), method2, field5, cls, type, iOrdinal5, iOf10, iOf9, jSONField3, jSONField5, null, mapBuildGenericInfo));
                                                                        }
                                                                    }
                                                                }
                                                                jSONField4 = jSONField5;
                                                            } else {
                                                                jSONField4 = null;
                                                            }
                                                            if (propertyNamingStrategy2 != null) {
                                                                propertyNameByMethodName2 = propertyNamingStrategy2.translate(propertyNameByMethodName2);
                                                            }
                                                            add(arrayList, new com.alibaba.fastjson.util.FieldInfo(propertyNameByMethodName2, method2, field5, cls, type, iOrdinal5, iOf10, iOf9, jSONField3, jSONField4, null, mapBuildGenericInfo));
                                                        } else {
                                                            fieldArr3 = fieldArr;
                                                            if (zIsKotlin) {
                                                                propertyNameByMethodName2 = com.alibaba.fastjson.util.TypeUtils.getPropertyNameByMethodName("g" + name4.substring(1));
                                                            } else if (com.alibaba.fastjson.util.TypeUtils.compatibleWithJavaBean) {
                                                                propertyNameByMethodName2 = com.alibaba.fastjson.util.TypeUtils.decapitalize(name4.substring(3));
                                                            } else {
                                                                propertyNameByMethodName2 = com.alibaba.fastjson.util.TypeUtils.getPropertyNameByMethodName(name4);
                                                            }
                                                            field5 = null;
                                                            if (field5 == null) {
                                                                field5 = com.alibaba.fastjson.util.TypeUtils.getField(cls, propertyNameByMethodName2, fieldArr3);
                                                            }
                                                            if (field5 != null) {
                                                            }
                                                            if (field5 != null) {
                                                                jSONField5 = (com.alibaba.fastjson.annotation.JSONField) com.alibaba.fastjson.util.TypeUtils.getAnnotation(field5, com.alibaba.fastjson.annotation.JSONField.class);
                                                                if (jSONField5 != null) {
                                                                    if (jSONField5.deserialize()) {
                                                                        methodArr6 = methodArr6;
                                                                        fieldArr3 = fieldArr3;
                                                                    } else {
                                                                        iOrdinal5 = jSONField5.ordinal();
                                                                        iOf10 = com.alibaba.fastjson.serializer.SerializerFeature.of(jSONField5.serialzeFeatures());
                                                                        iOf9 = com.alibaba.fastjson.parser.Feature.of(jSONField5.parseFeatures());
                                                                        if (jSONField5.name().length() != 0) {
                                                                            methodArr6 = methodArr6;
                                                                            fieldArr3 = fieldArr3;
                                                                            add(arrayList, new com.alibaba.fastjson.util.FieldInfo(jSONField5.name(), method2, field5, cls, type, iOrdinal5, iOf10, iOf9, jSONField3, jSONField5, null, mapBuildGenericInfo));
                                                                        }
                                                                    }
                                                                }
                                                                jSONField4 = jSONField5;
                                                            } else {
                                                                jSONField4 = null;
                                                            }
                                                            if (propertyNamingStrategy2 != null) {
                                                                propertyNameByMethodName2 = propertyNamingStrategy2.translate(propertyNameByMethodName2);
                                                            }
                                                            add(arrayList, new com.alibaba.fastjson.util.FieldInfo(propertyNameByMethodName2, method2, field5, cls, type, iOrdinal5, iOf10, iOf9, jSONField3, jSONField4, null, mapBuildGenericInfo));
                                                        }
                                                    }
                                                }
                                            }
                                        } else {
                                            jSONField3 = superMethodAnnotation2;
                                            if ((jSONField3 == null || name4.startsWith(str)) && cls4 == null) {
                                                cCharAt = name4.charAt(3);
                                                if (zIsKotlin) {
                                                    arrayList2 = new java.util.ArrayList();
                                                    methodArr6 = methodArr5;
                                                    while (i5 < methodArr6.length) {
                                                        if (methodArr6[i5].getName().startsWith("get")) {
                                                            arrayList2.add(methodArr6[i5].getName());
                                                        }
                                                    }
                                                } else {
                                                    methodArr6 = methodArr5;
                                                    arrayList2 = null;
                                                }
                                                if (!java.lang.Character.isUpperCase(cCharAt) || cCharAt > 512) {
                                                    fieldArr3 = fieldArr;
                                                    if (zIsKotlin) {
                                                        propertyNameByMethodName2 = com.alibaba.fastjson.util.TypeUtils.getPropertyNameByMethodName("g" + name4.substring(1));
                                                    } else if (com.alibaba.fastjson.util.TypeUtils.compatibleWithJavaBean) {
                                                        propertyNameByMethodName2 = com.alibaba.fastjson.util.TypeUtils.decapitalize(name4.substring(3));
                                                    } else {
                                                        propertyNameByMethodName2 = com.alibaba.fastjson.util.TypeUtils.getPropertyNameByMethodName(name4);
                                                    }
                                                } else {
                                                    if (cCharAt != '_') {
                                                        fieldArr4 = fieldArr;
                                                        if (cCharAt == 'f') {
                                                            strDecapitalize = name4.substring(3);
                                                        } else if (name4.length() >= 5 && java.lang.Character.isUpperCase(name4.charAt(4))) {
                                                            strDecapitalize = com.alibaba.fastjson.util.TypeUtils.decapitalize(name4.substring(3));
                                                        } else {
                                                            strSubstring = name4.substring(3);
                                                            field5 = com.alibaba.fastjson.util.TypeUtils.getField(cls, strSubstring, fieldArr4);
                                                            if (field5 == null) {
                                                                methodArr6 = methodArr6;
                                                                fieldArr3 = fieldArr4;
                                                            }
                                                        }
                                                        propertyNameByMethodName2 = strDecapitalize;
                                                        fieldArr3 = fieldArr4;
                                                    } else if (zIsKotlin) {
                                                        strSubstring = arrayList2.contains("g" + name4.substring(1)) ? name4.substring(3) : "is" + name4.substring(3);
                                                        fieldArr4 = fieldArr;
                                                        field5 = com.alibaba.fastjson.util.TypeUtils.getField(cls, strSubstring, fieldArr4);
                                                    } else {
                                                        fieldArr4 = fieldArr;
                                                        strSubstring = name4.substring(4);
                                                        field5 = com.alibaba.fastjson.util.TypeUtils.getField(cls, strSubstring, fieldArr4);
                                                        if (field5 == null && (field5 = com.alibaba.fastjson.util.TypeUtils.getField(cls, (strSubstring2 = name4.substring(3)), fieldArr4)) != null) {
                                                            strSubstring = strSubstring2;
                                                        }
                                                    }
                                                    propertyNameByMethodName2 = strSubstring;
                                                    fieldArr3 = fieldArr4;
                                                    if (field5 == null) {
                                                        field5 = com.alibaba.fastjson.util.TypeUtils.getField(cls, propertyNameByMethodName2, fieldArr3);
                                                    }
                                                    if (field5 != null && parameterTypes[0] == java.lang.Boolean.TYPE) {
                                                        field5 = com.alibaba.fastjson.util.TypeUtils.getField(cls, "is" + java.lang.Character.toUpperCase(propertyNameByMethodName2.charAt(0)) + propertyNameByMethodName2.substring(1), fieldArr3);
                                                    }
                                                    if (field5 != null) {
                                                        jSONField5 = (com.alibaba.fastjson.annotation.JSONField) com.alibaba.fastjson.util.TypeUtils.getAnnotation(field5, com.alibaba.fastjson.annotation.JSONField.class);
                                                        if (jSONField5 != null) {
                                                            if (jSONField5.deserialize()) {
                                                                methodArr6 = methodArr6;
                                                                fieldArr3 = fieldArr3;
                                                            } else {
                                                                iOrdinal5 = jSONField5.ordinal();
                                                                iOf10 = com.alibaba.fastjson.serializer.SerializerFeature.of(jSONField5.serialzeFeatures());
                                                                iOf9 = com.alibaba.fastjson.parser.Feature.of(jSONField5.parseFeatures());
                                                                if (jSONField5.name().length() != 0) {
                                                                    methodArr6 = methodArr6;
                                                                    fieldArr3 = fieldArr3;
                                                                    add(arrayList, new com.alibaba.fastjson.util.FieldInfo(jSONField5.name(), method2, field5, cls, type, iOrdinal5, iOf10, iOf9, jSONField3, jSONField5, null, mapBuildGenericInfo));
                                                                }
                                                            }
                                                        }
                                                        jSONField4 = jSONField5;
                                                    } else {
                                                        jSONField4 = null;
                                                    }
                                                    if (propertyNamingStrategy2 != null) {
                                                        propertyNameByMethodName2 = propertyNamingStrategy2.translate(propertyNameByMethodName2);
                                                    }
                                                    add(arrayList, new com.alibaba.fastjson.util.FieldInfo(propertyNameByMethodName2, method2, field5, cls, type, iOrdinal5, iOf10, iOf9, jSONField3, jSONField4, null, mapBuildGenericInfo));
                                                }
                                                field5 = null;
                                                if (field5 == null) {
                                                    field5 = com.alibaba.fastjson.util.TypeUtils.getField(cls, propertyNameByMethodName2, fieldArr3);
                                                }
                                                if (field5 != null) {
                                                }
                                                if (field5 != null) {
                                                    jSONField5 = (com.alibaba.fastjson.annotation.JSONField) com.alibaba.fastjson.util.TypeUtils.getAnnotation(field5, com.alibaba.fastjson.annotation.JSONField.class);
                                                    if (jSONField5 != null) {
                                                        if (jSONField5.deserialize()) {
                                                            methodArr6 = methodArr6;
                                                            fieldArr3 = fieldArr3;
                                                        } else {
                                                            iOrdinal5 = jSONField5.ordinal();
                                                            iOf10 = com.alibaba.fastjson.serializer.SerializerFeature.of(jSONField5.serialzeFeatures());
                                                            iOf9 = com.alibaba.fastjson.parser.Feature.of(jSONField5.parseFeatures());
                                                            if (jSONField5.name().length() != 0) {
                                                                methodArr6 = methodArr6;
                                                                fieldArr3 = fieldArr3;
                                                                add(arrayList, new com.alibaba.fastjson.util.FieldInfo(jSONField5.name(), method2, field5, cls, type, iOrdinal5, iOf10, iOf9, jSONField3, jSONField5, null, mapBuildGenericInfo));
                                                            }
                                                        }
                                                    }
                                                    jSONField4 = jSONField5;
                                                } else {
                                                    jSONField4 = null;
                                                }
                                                if (propertyNamingStrategy2 != null) {
                                                    propertyNameByMethodName2 = propertyNamingStrategy2.translate(propertyNameByMethodName2);
                                                }
                                                add(arrayList, new com.alibaba.fastjson.util.FieldInfo(propertyNameByMethodName2, method2, field5, cls, type, iOrdinal5, iOf10, iOf9, jSONField3, jSONField4, null, mapBuildGenericInfo));
                                            }
                                        }
                                    }
                                }
                            }
                            methodArr6 = methodArr5;
                            fieldArr3 = fieldArr;
                        }
                    } else {
                        field4 = field;
                        cls4 = cls3;
                        i3 = length;
                        i4 = i;
                        methodArr6 = methodArr4;
                        fieldArr3 = fieldArr;
                    }
                }
                methodArr2 = methodArr6;
                i = i4 + 1;
                fieldArr = fieldArr3;
                propertyNamingStrategy2 = propertyNamingStrategy2;
                cls3 = cls4;
                length = i3;
                field = field4;
                c = 0;
                str = str;
            }
            type2 = type;
            field2 = field;
            java.lang.Class<?> cls11 = cls3;
            propertyNamingStrategy3 = propertyNamingStrategy2;
            fieldArr2 = fieldArr;
            computeFields(cls, type2, propertyNamingStrategy3, arrayList, cls.getFields());
            methods = cls.getMethods();
            length2 = methods.length;
            i2 = 0;
            while (i2 < length2) {
                int i19 = i2;
                method = methods[i19];
                name = method.getName();
                if (name.length() < 4 && !java.lang.reflect.Modifier.isStatic(method.getModifiers()) && cls11 == null && name.startsWith(str2) && java.lang.Character.isUpperCase(name.charAt(3)) && method.getParameterTypes().length == 0 && ((java.util.Collection.class.isAssignableFrom(method.getReturnType()) || java.util.Map.class.isAssignableFrom(method.getReturnType()) || java.util.concurrent.atomic.AtomicBoolean.class == method.getReturnType() || java.util.concurrent.atomic.AtomicInteger.class == method.getReturnType() || java.util.concurrent.atomic.AtomicLong.class == method.getReturnType()) && ((jSONField = (com.alibaba.fastjson.annotation.JSONField) com.alibaba.fastjson.util.TypeUtils.getAnnotation(method, com.alibaba.fastjson.annotation.JSONField.class)) == null || !jSONField.deserialize()))) {
                    if (jSONField == null && jSONField.name().length() > 0) {
                        propertyNameByMethodName = jSONField.name();
                    } else {
                        propertyNameByMethodName = com.alibaba.fastjson.util.TypeUtils.getPropertyNameByMethodName(name);
                        field3 = com.alibaba.fastjson.util.TypeUtils.getField(cls, propertyNameByMethodName, fieldArr2);
                        if (field3 != null) {
                            jSONField2 = (com.alibaba.fastjson.annotation.JSONField) com.alibaba.fastjson.util.TypeUtils.getAnnotation(field3, com.alibaba.fastjson.annotation.JSONField.class);
                            if (jSONField2 != null || jSONField2.deserialize()) {
                                if (!java.util.Collection.class.isAssignableFrom(method.getReturnType()) && !java.util.Map.class.isAssignableFrom(method.getReturnType())) {
                                }
                                if (propertyNamingStrategy3 != null) {
                                    propertyNameByMethodName = propertyNamingStrategy3.translate(propertyNameByMethodName);
                                }
                                if (getField(arrayList, propertyNameByMethodName) == null) {
                                    methodArr3 = methods;
                                    type4 = type;
                                    add(arrayList, new com.alibaba.fastjson.util.FieldInfo(propertyNameByMethodName, method, field3, cls, type4, 0, 0, 0, jSONField, null, null, mapBuildGenericInfo));
                                }
                            }
                        }
                        methodArr3 = methods;
                        type4 = type2;
                    }
                    field3 = field2;
                    if (propertyNamingStrategy3 != null) {
                        propertyNameByMethodName = propertyNamingStrategy3.translate(propertyNameByMethodName);
                    }
                    if (getField(arrayList, propertyNameByMethodName) == null) {
                        methodArr3 = methods;
                        type4 = type2;
                    } else {
                        methodArr3 = methods;
                        type4 = type;
                        add(arrayList, new com.alibaba.fastjson.util.FieldInfo(propertyNameByMethodName, method, field3, cls, type4, 0, 0, 0, jSONField, null, null, mapBuildGenericInfo));
                    }
                } else {
                    methodArr3 = methods;
                    type4 = type2;
                }
                i2 = i19 + 1;
                type2 = type4;
                length2 = length2;
                methods = methodArr3;
                str2 = str2;
            }
            type3 = type2;
            if (arrayList.size() == 0) {
                if (com.alibaba.fastjson.util.TypeUtils.isXmlField(cls) ? true : z) {
                    for (superclass = cls; superclass != null; superclass = superclass.getSuperclass()) {
                        computeFields(cls, type3, propertyNamingStrategy3, arrayList, fieldArr2);
                    }
                }
            }
            return new com.alibaba.fastjson.util.JavaBeanInfo(cls, cls11, constructor2, constructor, method5, method6, jSONType, arrayList);
        }
        field = null;
        methodArr2 = methodArr;
        length = methodArr2.length;
        i = 0;
        while (true) {
            str2 = "get";
            if (i < length) {
                break;
                break;
            }
            methodArr4 = methodArr2;
            method2 = methodArr4[i];
            java.lang.String name5 = method2.getName();
            if (java.lang.reflect.Modifier.isStatic(method2.getModifiers())) {
                field4 = field;
                cls4 = cls3;
                i3 = length;
                i4 = i;
                methodArr6 = methodArr4;
                fieldArr3 = fieldArr;
            } else {
                returnType = method2.getReturnType();
                if (returnType.equals(java.lang.Void.TYPE)) {
                    parameterTypes = method2.getParameterTypes();
                    if (parameterTypes.length != 0) {
                        field4 = field;
                        cls4 = cls3;
                        i3 = length;
                        i4 = i;
                        methodArr6 = methodArr4;
                        fieldArr3 = fieldArr;
                    } else {
                        field4 = field;
                        cls4 = cls3;
                        i3 = length;
                        i4 = i;
                        methodArr6 = methodArr4;
                        fieldArr3 = fieldArr;
                    }
                } else {
                    parameterTypes = method2.getParameterTypes();
                    if (parameterTypes.length != 0) {
                        field4 = field;
                        cls4 = cls3;
                        i3 = length;
                        i4 = i;
                        methodArr6 = methodArr4;
                        fieldArr3 = fieldArr;
                    } else {
                        field4 = field;
                        cls4 = cls3;
                        i3 = length;
                        i4 = i;
                        methodArr6 = methodArr4;
                        fieldArr3 = fieldArr;
                    }
                }
            }
            methodArr2 = methodArr6;
            i = i4 + 1;
            fieldArr = fieldArr3;
            propertyNamingStrategy2 = propertyNamingStrategy2;
            cls3 = cls4;
            length = i3;
            field = field4;
            c = 0;
            str = str;
        }
        type2 = type;
        field2 = field;
        java.lang.Class<?> cls12 = cls3;
        propertyNamingStrategy3 = propertyNamingStrategy2;
        fieldArr2 = fieldArr;
        computeFields(cls, type2, propertyNamingStrategy3, arrayList, cls.getFields());
        methods = cls.getMethods();
        length2 = methods.length;
        i2 = 0;
        while (i2 < length2) {
            int i110 = i2;
            method = methods[i110];
            name = method.getName();
            if (name.length() < 4) {
                methodArr3 = methods;
                type4 = type2;
            } else {
                if (jSONField == null) {
                    propertyNameByMethodName = com.alibaba.fastjson.util.TypeUtils.getPropertyNameByMethodName(name);
                    field3 = com.alibaba.fastjson.util.TypeUtils.getField(cls, propertyNameByMethodName, fieldArr2);
                    if (field3 != null) {
                        jSONField2 = (com.alibaba.fastjson.annotation.JSONField) com.alibaba.fastjson.util.TypeUtils.getAnnotation(field3, com.alibaba.fastjson.annotation.JSONField.class);
                        if (jSONField2 != null) {
                        }
                        if (!java.util.Collection.class.isAssignableFrom(method.getReturnType())) {
                            field3 = field2;
                        }
                        if (propertyNamingStrategy3 != null) {
                            propertyNameByMethodName = propertyNamingStrategy3.translate(propertyNameByMethodName);
                        }
                        if (getField(arrayList, propertyNameByMethodName) == null) {
                            methodArr3 = methods;
                            type4 = type;
                            add(arrayList, new com.alibaba.fastjson.util.FieldInfo(propertyNameByMethodName, method, field3, cls, type4, 0, 0, 0, jSONField, null, null, mapBuildGenericInfo));
                        }
                    } else {
                        field3 = field2;
                        if (propertyNamingStrategy3 != null) {
                            propertyNameByMethodName = propertyNamingStrategy3.translate(propertyNameByMethodName);
                        }
                        if (getField(arrayList, propertyNameByMethodName) == null) {
                            methodArr3 = methods;
                            type4 = type;
                            add(arrayList, new com.alibaba.fastjson.util.FieldInfo(propertyNameByMethodName, method, field3, cls, type4, 0, 0, 0, jSONField, null, null, mapBuildGenericInfo));
                        }
                    }
                } else {
                    propertyNameByMethodName = com.alibaba.fastjson.util.TypeUtils.getPropertyNameByMethodName(name);
                    field3 = com.alibaba.fastjson.util.TypeUtils.getField(cls, propertyNameByMethodName, fieldArr2);
                    if (field3 != null) {
                        jSONField2 = (com.alibaba.fastjson.annotation.JSONField) com.alibaba.fastjson.util.TypeUtils.getAnnotation(field3, com.alibaba.fastjson.annotation.JSONField.class);
                        if (jSONField2 != null) {
                        }
                        if (!java.util.Collection.class.isAssignableFrom(method.getReturnType())) {
                            field3 = field2;
                        }
                        if (propertyNamingStrategy3 != null) {
                            propertyNameByMethodName = propertyNamingStrategy3.translate(propertyNameByMethodName);
                        }
                        if (getField(arrayList, propertyNameByMethodName) == null) {
                            methodArr3 = methods;
                            type4 = type;
                            add(arrayList, new com.alibaba.fastjson.util.FieldInfo(propertyNameByMethodName, method, field3, cls, type4, 0, 0, 0, jSONField, null, null, mapBuildGenericInfo));
                        }
                    } else {
                        field3 = field2;
                        if (propertyNamingStrategy3 != null) {
                            propertyNameByMethodName = propertyNamingStrategy3.translate(propertyNameByMethodName);
                        }
                        if (getField(arrayList, propertyNameByMethodName) == null) {
                            methodArr3 = methods;
                            type4 = type;
                            add(arrayList, new com.alibaba.fastjson.util.FieldInfo(propertyNameByMethodName, method, field3, cls, type4, 0, 0, 0, jSONField, null, null, mapBuildGenericInfo));
                        }
                    }
                }
                methodArr3 = methods;
                type4 = type2;
            }
            i2 = i110 + 1;
            type2 = type4;
            length2 = length2;
            methods = methodArr3;
            str2 = str2;
        }
        type3 = type2;
        if (arrayList.size() == 0) {
            if (com.alibaba.fastjson.util.TypeUtils.isXmlField(cls) ? true : z) {
                while (superclass != null) {
                    computeFields(cls, type3, propertyNamingStrategy3, arrayList, fieldArr2);
                }
            }
        }
        return new com.alibaba.fastjson.util.JavaBeanInfo(cls, cls12, constructor2, constructor, method5, method6, jSONType, arrayList);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x004e  */
    /* JADX WARN: Code duplicated, block: B:22:0x0058  */
    /* JADX WARN: Code duplicated, block: B:27:0x007a  */
    /* JADX WARN: Code duplicated, block: B:30:0x0081  */
    /* JADX WARN: Code duplicated, block: B:32:0x009f  */
    /* JADX WARN: Code duplicated, block: B:34:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:36:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:43:0x006b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:44:0x0018 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:45:? A[LOOP:1: B:20:0x0052->B:45:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:6:0x0018  */
    private static void computeFields(java.lang.Class<?> cls, java.lang.reflect.Type type, com.alibaba.fastjson.PropertyNamingStrategy propertyNamingStrategy, java.util.List<com.alibaba.fastjson.util.FieldInfo> list, java.lang.reflect.Field[] fieldArr) {
        java.util.Iterator<com.alibaba.fastjson.util.FieldInfo> it;
        java.lang.String name;
        com.alibaba.fastjson.annotation.JSONField jSONField;
        int i;
        int i2;
        int i3;
        int i4;
        java.util.Map<java.lang.reflect.TypeVariable, java.lang.reflect.Type> mapBuildGenericInfo = buildGenericInfo(cls);
        int length = fieldArr.length;
        int i5 = 0;
        while (i5 < length) {
            java.lang.reflect.Field field = fieldArr[i5];
            int modifiers = field.getModifiers();
            if ((modifiers & 8) != 0) {
                i4 = i5;
                break;
                break;
            }
            if ((modifiers & 16) != 0) {
                java.lang.Class<?> type2 = field.getType();
                if (!java.util.Map.class.isAssignableFrom(type2) && !java.util.Collection.class.isAssignableFrom(type2) && !java.util.concurrent.atomic.AtomicLong.class.equals(type2) && !java.util.concurrent.atomic.AtomicInteger.class.equals(type2) && !java.util.concurrent.atomic.AtomicBoolean.class.equals(type2)) {
                    i4 = i5;
                    break;
                    break;
                }
                it = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it.next().name.equals(field.getName())) {
                        }
                    } else {
                        name = field.getName();
                        jSONField = (com.alibaba.fastjson.annotation.JSONField) com.alibaba.fastjson.util.TypeUtils.getAnnotation(field, com.alibaba.fastjson.annotation.JSONField.class);
                        if (jSONField != null) {
                            i = 0;
                            i2 = 0;
                            i3 = 0;
                        } else if (!jSONField.deserialize()) {
                            int iOrdinal = jSONField.ordinal();
                            int iOf = com.alibaba.fastjson.serializer.SerializerFeature.of(jSONField.serialzeFeatures());
                            int iOf2 = com.alibaba.fastjson.parser.Feature.of(jSONField.parseFeatures());
                            if (jSONField.name().length() != 0) {
                                name = jSONField.name();
                            }
                            i = iOrdinal;
                            i2 = iOf;
                            i3 = iOf2;
                        }
                        if (propertyNamingStrategy != null) {
                            name = propertyNamingStrategy.translate(name);
                        }
                        i4 = i5;
                        add(list, new com.alibaba.fastjson.util.FieldInfo(name, null, field, cls, type, i, i2, i3, null, jSONField, null, mapBuildGenericInfo));
                        break;
                    }
                    i4 = i5;
                    break;
                }
            }
            it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().name.equals(field.getName())) {
                    }
                } else {
                    name = field.getName();
                    jSONField = (com.alibaba.fastjson.annotation.JSONField) com.alibaba.fastjson.util.TypeUtils.getAnnotation(field, com.alibaba.fastjson.annotation.JSONField.class);
                    if (jSONField != null) {
                        i = 0;
                        i2 = 0;
                        i3 = 0;
                    } else if (!jSONField.deserialize()) {
                        int iOrdinal2 = jSONField.ordinal();
                        int iOf3 = com.alibaba.fastjson.serializer.SerializerFeature.of(jSONField.serialzeFeatures());
                        int iOf4 = com.alibaba.fastjson.parser.Feature.of(jSONField.parseFeatures());
                        if (jSONField.name().length() != 0) {
                            name = jSONField.name();
                        }
                        i = iOrdinal2;
                        i2 = iOf3;
                        i3 = iOf4;
                    }
                    if (propertyNamingStrategy != null) {
                        name = propertyNamingStrategy.translate(name);
                    }
                    i4 = i5;
                    add(list, new com.alibaba.fastjson.util.FieldInfo(name, null, field, cls, type, i, i2, i3, null, jSONField, null, mapBuildGenericInfo));
                    break;
                    break;
                }
                i4 = i5;
                break;
                break;
            }
            i5 = i4 + 1;
        }
    }

    static java.lang.reflect.Constructor<?> getDefaultConstructor(java.lang.Class<?> cls, java.lang.reflect.Constructor<?>[] constructorArr) {
        java.lang.reflect.Constructor<?> constructor = null;
        if (java.lang.reflect.Modifier.isAbstract(cls.getModifiers())) {
            return null;
        }
        for (java.lang.reflect.Constructor<?> constructor2 : constructorArr) {
            if (constructor2.getParameterTypes().length == 0) {
                constructor = constructor2;
                break;
            }
        }
        if (constructor == null && cls.isMemberClass() && !java.lang.reflect.Modifier.isStatic(cls.getModifiers())) {
            for (java.lang.reflect.Constructor<?> constructor3 : constructorArr) {
                java.lang.Class<?>[] parameterTypes = constructor3.getParameterTypes();
                if (parameterTypes.length == 1 && parameterTypes[0].equals(cls.getDeclaringClass())) {
                    return constructor3;
                }
            }
        }
        return constructor;
    }

    public static java.lang.reflect.Constructor<?> getCreatorConstructor(java.lang.reflect.Constructor[] constructorArr) {
        java.lang.reflect.Constructor constructor = null;
        for (java.lang.reflect.Constructor constructor2 : constructorArr) {
            if (((com.alibaba.fastjson.annotation.JSONCreator) constructor2.getAnnotation(com.alibaba.fastjson.annotation.JSONCreator.class)) != null) {
                if (constructor != null) {
                    throw new com.alibaba.fastjson.JSONException("multi-JSONCreator");
                }
                constructor = constructor2;
            }
        }
        if (constructor != null) {
            return constructor;
        }
        for (java.lang.reflect.Constructor constructor3 : constructorArr) {
            java.lang.annotation.Annotation[][] parameterAnnotations = com.alibaba.fastjson.util.TypeUtils.getParameterAnnotations(constructor3);
            if (parameterAnnotations.length != 0) {
                int length = parameterAnnotations.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        if (constructor != null) {
                            throw new com.alibaba.fastjson.JSONException("multi-JSONCreator");
                        }
                        constructor = constructor3;
                        break;
                    }
                    java.lang.annotation.Annotation[] annotationArr = parameterAnnotations[i];
                    int length2 = annotationArr.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length2) {
                            break;
                        }
                        if (annotationArr[i2] instanceof com.alibaba.fastjson.annotation.JSONField) {
                            break;
                        }
                        i2++;
                    }
                    i++;
                }
            }
        }
        return constructor;
    }

    private static java.lang.reflect.Method getFactoryMethod(java.lang.Class<?> cls, java.lang.reflect.Method[] methodArr, boolean z) {
        java.lang.reflect.Method method = null;
        for (java.lang.reflect.Method method2 : methodArr) {
            if (java.lang.reflect.Modifier.isStatic(method2.getModifiers()) && cls.isAssignableFrom(method2.getReturnType()) && ((com.alibaba.fastjson.annotation.JSONCreator) com.alibaba.fastjson.util.TypeUtils.getAnnotation(method2, com.alibaba.fastjson.annotation.JSONCreator.class)) != null) {
                if (method != null) {
                    throw new com.alibaba.fastjson.JSONException("multi-JSONCreator");
                }
                method = method2;
            }
        }
        if (method == null && z) {
            for (java.lang.reflect.Method method3 : methodArr) {
                if (com.alibaba.fastjson.util.TypeUtils.isJacksonCreator(method3)) {
                    return method3;
                }
            }
        }
        return method;
    }

    public static java.lang.Class<?> getBuilderClass(com.alibaba.fastjson.annotation.JSONType jSONType) {
        return getBuilderClass(null, jSONType);
    }

    public static java.lang.Class<?> getBuilderClass(java.lang.Class<?> cls, com.alibaba.fastjson.annotation.JSONType jSONType) {
        java.lang.Class<?> clsBuilder;
        if (cls != null && cls.getName().equals("org.springframework.security.web.savedrequest.DefaultSavedRequest")) {
            return com.alibaba.fastjson.util.TypeUtils.loadClass("org.springframework.security.web.savedrequest.DefaultSavedRequest$Builder");
        }
        if (jSONType == null || (clsBuilder = jSONType.builder()) == java.lang.Void.class) {
            return null;
        }
        return clsBuilder;
    }
}
