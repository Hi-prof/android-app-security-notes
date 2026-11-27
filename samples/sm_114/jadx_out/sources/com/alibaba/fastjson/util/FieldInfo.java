package com.alibaba.fastjson.util;

/* JADX INFO: loaded from: classes.dex */
public class FieldInfo implements java.lang.Comparable<com.alibaba.fastjson.util.FieldInfo> {
    public final java.lang.String[] alternateNames;
    public final java.lang.Class<?> declaringClass;
    public final java.lang.reflect.Field field;
    public final boolean fieldAccess;
    private final com.alibaba.fastjson.annotation.JSONField fieldAnnotation;
    public final java.lang.Class<?> fieldClass;
    public final boolean fieldTransient;
    public final java.lang.reflect.Type fieldType;
    public final java.lang.String format;
    public final boolean getOnly;
    public final boolean isEnum;
    public final boolean jsonDirect;
    public final java.lang.String label;
    public final java.lang.reflect.Method method;
    private final com.alibaba.fastjson.annotation.JSONField methodAnnotation;
    public final java.lang.String name;
    public final long nameHashCode;
    public final char[] name_chars;
    private int ordinal;
    public final int parserFeatures;
    public final int serialzeFeatures;
    public final boolean unwrapped;

    public FieldInfo(java.lang.String str, java.lang.Class<?> cls, java.lang.Class<?> cls2, java.lang.reflect.Type type, java.lang.reflect.Field field, int i, int i2, int i3) {
        this.ordinal = 0;
        i = i < 0 ? 0 : i;
        this.name = str;
        this.declaringClass = cls;
        this.fieldClass = cls2;
        this.fieldType = type;
        this.method = null;
        this.field = field;
        this.ordinal = i;
        this.serialzeFeatures = i2;
        this.parserFeatures = i3;
        this.isEnum = cls2.isEnum();
        if (field != null) {
            int modifiers = field.getModifiers();
            this.fieldAccess = true;
            this.fieldTransient = java.lang.reflect.Modifier.isTransient(modifiers);
        } else {
            this.fieldTransient = false;
            this.fieldAccess = false;
        }
        this.name_chars = genFieldNameChars();
        if (field != null) {
            com.alibaba.fastjson.util.TypeUtils.setAccessible(field);
        }
        this.label = "";
        com.alibaba.fastjson.annotation.JSONField jSONField = field == null ? null : (com.alibaba.fastjson.annotation.JSONField) com.alibaba.fastjson.util.TypeUtils.getAnnotation(field, com.alibaba.fastjson.annotation.JSONField.class);
        this.fieldAnnotation = jSONField;
        this.methodAnnotation = null;
        this.getOnly = false;
        this.jsonDirect = false;
        this.unwrapped = false;
        this.format = null;
        this.alternateNames = new java.lang.String[0];
        this.nameHashCode = nameHashCode64(str, jSONField);
    }

    public FieldInfo(java.lang.String str, java.lang.reflect.Method method, java.lang.reflect.Field field, java.lang.Class<?> cls, java.lang.reflect.Type type, int i, int i2, int i3, com.alibaba.fastjson.annotation.JSONField jSONField, com.alibaba.fastjson.annotation.JSONField jSONField2, java.lang.String str2) {
        this(str, method, field, cls, type, i, i2, i3, jSONField, jSONField2, str2, null);
    }

    public FieldInfo(java.lang.String str, java.lang.reflect.Method method, java.lang.reflect.Field field, java.lang.Class<?> cls, java.lang.reflect.Type type, int i, int i2, int i3, com.alibaba.fastjson.annotation.JSONField jSONField, com.alibaba.fastjson.annotation.JSONField jSONField2, java.lang.String str2, java.util.Map<java.lang.reflect.TypeVariable, java.lang.reflect.Type> map) {
        boolean zJsonDirect;
        boolean zIsFinal;
        java.lang.reflect.Type type2;
        java.lang.Class<?> cls2;
        java.lang.reflect.Type inheritGenericType;
        java.lang.Class<?> cls3;
        java.lang.Class<?> cls4;
        java.lang.reflect.Type genericReturnType;
        java.lang.Class<?> returnType;
        java.lang.reflect.Type type3;
        boolean z = false;
        this.ordinal = 0;
        if (field != null) {
            java.lang.String name = field.getName();
            if (name.equals(str)) {
                str = name;
            }
        }
        i = i < 0 ? 0 : i;
        this.name = str;
        this.method = method;
        this.field = field;
        this.ordinal = i;
        this.serialzeFeatures = i2;
        this.parserFeatures = i3;
        this.fieldAnnotation = jSONField;
        this.methodAnnotation = jSONField2;
        if (field != null) {
            int modifiers = field.getModifiers();
            this.fieldAccess = (modifiers & 1) != 0 || method == null;
            this.fieldTransient = java.lang.reflect.Modifier.isTransient(modifiers) || com.alibaba.fastjson.util.TypeUtils.isTransient(method);
        } else {
            this.fieldAccess = false;
            this.fieldTransient = com.alibaba.fastjson.util.TypeUtils.isTransient(method);
        }
        if (str2 != null && str2.length() > 0) {
            this.label = str2;
        } else {
            this.label = "";
        }
        com.alibaba.fastjson.annotation.JSONField annotation = getAnnotation();
        this.nameHashCode = nameHashCode64(str, annotation);
        java.lang.String str3 = null;
        if (annotation != null) {
            java.lang.String str4 = annotation.format();
            str3 = str4.trim().length() != 0 ? str4 : null;
            zJsonDirect = annotation.jsonDirect();
            this.unwrapped = annotation.unwrapped();
            this.alternateNames = annotation.alternateNames();
        } else {
            this.unwrapped = false;
            this.alternateNames = new java.lang.String[0];
            zJsonDirect = false;
        }
        this.format = str3;
        this.name_chars = genFieldNameChars();
        if (method != null) {
            com.alibaba.fastjson.util.TypeUtils.setAccessible(method);
        }
        if (field != null) {
            com.alibaba.fastjson.util.TypeUtils.setAccessible(field);
        }
        if (method != null) {
            java.lang.Class<?>[] parameterTypes = method.getParameterTypes();
            if (parameterTypes.length == 1) {
                cls4 = parameterTypes[0];
                type3 = method.getGenericParameterTypes()[0];
            } else {
                if (parameterTypes.length == 2 && (cls3 = parameterTypes[0]) == java.lang.String.class && parameterTypes[1] == java.lang.Object.class) {
                    cls4 = cls3;
                    type3 = cls3;
                } else {
                    zIsFinal = true;
                    returnType = method.getReturnType();
                    genericReturnType = method.getGenericReturnType();
                }
                this.declaringClass = method.getDeclaringClass();
                cls2 = returnType;
                type2 = genericReturnType;
            }
            zIsFinal = false;
            returnType = cls4;
            genericReturnType = type3;
            this.declaringClass = method.getDeclaringClass();
            cls2 = returnType;
            type2 = genericReturnType;
        } else {
            java.lang.Class<?> type4 = field.getType();
            java.lang.reflect.Type genericType = field.getGenericType();
            this.declaringClass = field.getDeclaringClass();
            zIsFinal = java.lang.reflect.Modifier.isFinal(field.getModifiers());
            type2 = genericType;
            cls2 = type4;
        }
        this.getOnly = zIsFinal;
        if (zJsonDirect && cls2 == java.lang.String.class) {
            z = true;
        }
        this.jsonDirect = z;
        if (cls != null && cls2 == java.lang.Object.class && (type2 instanceof java.lang.reflect.TypeVariable) && (inheritGenericType = getInheritGenericType(cls, type, (java.lang.reflect.TypeVariable) type2)) != null) {
            this.fieldClass = com.alibaba.fastjson.util.TypeUtils.getClass(inheritGenericType);
            this.fieldType = inheritGenericType;
            this.isEnum = cls2.isEnum();
            return;
        }
        boolean z2 = type2 instanceof java.lang.Class;
        java.lang.Class<?> cls5 = cls2;
        java.lang.reflect.Type type5 = type2;
        if (!z2) {
            java.lang.reflect.Type fieldType = getFieldType(cls, type == null ? cls : type, type2, map);
            java.lang.Class<?> cls6 = cls2;
            if (fieldType != type2) {
                if (fieldType instanceof java.lang.reflect.ParameterizedType) {
                    cls6 = com.alibaba.fastjson.util.TypeUtils.getClass(fieldType);
                } else if (fieldType instanceof java.lang.Class) {
                    cls6 = cls2;
                    cls6 = com.alibaba.fastjson.util.TypeUtils.getClass(fieldType);
                }
            }
            cls6 = cls2;
            type5 = fieldType;
            cls5 = cls6;
        }
        this.fieldType = type5;
        this.fieldClass = cls5;
        this.isEnum = cls5.isEnum();
    }

    private long nameHashCode64(java.lang.String str, com.alibaba.fastjson.annotation.JSONField jSONField) {
        if (jSONField != null && jSONField.name().length() != 0) {
            return com.alibaba.fastjson.util.TypeUtils.fnv1a_64_lower(str);
        }
        return com.alibaba.fastjson.util.TypeUtils.fnv1a_64_extract(str);
    }

    protected char[] genFieldNameChars() {
        int length = this.name.length();
        char[] cArr = new char[length + 3];
        java.lang.String str = this.name;
        str.getChars(0, str.length(), cArr, 1);
        cArr[0] = '\"';
        cArr[length + 1] = '\"';
        cArr[length + 2] = com.taobao.weex.el.parse.Operators.CONDITION_IF_MIDDLE;
        return cArr;
    }

    public <T extends java.lang.annotation.Annotation> T getAnnation(java.lang.Class<T> cls) {
        java.lang.reflect.Field field;
        if (cls == com.alibaba.fastjson.annotation.JSONField.class) {
            return getAnnotation();
        }
        java.lang.reflect.Method method = this.method;
        T t = method != null ? (T) com.alibaba.fastjson.util.TypeUtils.getAnnotation(method, cls) : null;
        return (t != null || (field = this.field) == null) ? t : (T) com.alibaba.fastjson.util.TypeUtils.getAnnotation(field, cls);
    }

    public static java.lang.reflect.Type getFieldType(java.lang.Class<?> cls, java.lang.reflect.Type type, java.lang.reflect.Type type2) {
        return getFieldType(cls, type, type2, null);
    }

    public static java.lang.reflect.Type getFieldType(java.lang.Class<?> cls, java.lang.reflect.Type type, java.lang.reflect.Type type2, java.util.Map<java.lang.reflect.TypeVariable, java.lang.reflect.Type> map) {
        java.lang.reflect.TypeVariable<java.lang.Class<?>>[] typeParameters;
        java.lang.reflect.ParameterizedType parameterizedType;
        if (cls != null && type != null) {
            if (type2 instanceof java.lang.reflect.GenericArrayType) {
                java.lang.reflect.Type genericComponentType = ((java.lang.reflect.GenericArrayType) type2).getGenericComponentType();
                java.lang.reflect.Type fieldType = getFieldType(cls, type, genericComponentType, map);
                if (genericComponentType != fieldType) {
                    return java.lang.reflect.Array.newInstance(com.alibaba.fastjson.util.TypeUtils.getClass(fieldType), 0).getClass();
                }
            } else if (com.alibaba.fastjson.util.TypeUtils.isGenericParamType(type)) {
                if (type2 instanceof java.lang.reflect.TypeVariable) {
                    java.lang.reflect.ParameterizedType parameterizedType2 = (java.lang.reflect.ParameterizedType) com.alibaba.fastjson.util.TypeUtils.getGenericParamType(type);
                    java.lang.reflect.TypeVariable typeVariable = (java.lang.reflect.TypeVariable) type2;
                    java.lang.reflect.TypeVariable<java.lang.Class<?>>[] typeParameters2 = com.alibaba.fastjson.util.TypeUtils.getClass(parameterizedType2).getTypeParameters();
                    for (int i = 0; i < typeParameters2.length; i++) {
                        if (typeParameters2[i].getName().equals(typeVariable.getName())) {
                            return parameterizedType2.getActualTypeArguments()[i];
                        }
                    }
                }
                if (type2 instanceof java.lang.reflect.ParameterizedType) {
                    java.lang.reflect.ParameterizedType parameterizedType3 = (java.lang.reflect.ParameterizedType) type2;
                    java.lang.reflect.Type[] actualTypeArguments = parameterizedType3.getActualTypeArguments();
                    boolean argument = getArgument(actualTypeArguments, map);
                    if (!argument) {
                        if (type instanceof java.lang.reflect.ParameterizedType) {
                            parameterizedType = (java.lang.reflect.ParameterizedType) type;
                            typeParameters = cls.getTypeParameters();
                        } else if (cls.getGenericSuperclass() instanceof java.lang.reflect.ParameterizedType) {
                            parameterizedType = (java.lang.reflect.ParameterizedType) cls.getGenericSuperclass();
                            typeParameters = cls.getSuperclass().getTypeParameters();
                        } else {
                            typeParameters = type.getClass().getTypeParameters();
                            parameterizedType = parameterizedType3;
                        }
                        argument = getArgument(actualTypeArguments, typeParameters, parameterizedType.getActualTypeArguments());
                    }
                    if (argument) {
                        return com.alibaba.fastjson.TypeReference.intern(new com.alibaba.fastjson.util.ParameterizedTypeImpl(actualTypeArguments, parameterizedType3.getOwnerType(), parameterizedType3.getRawType()));
                    }
                }
            }
        }
        return type2;
    }

    private static boolean getArgument(java.lang.reflect.Type[] typeArr, java.util.Map<java.lang.reflect.TypeVariable, java.lang.reflect.Type> map) {
        if (map == null || map.size() == 0) {
            return false;
        }
        boolean z = false;
        for (int i = 0; i < typeArr.length; i++) {
            java.lang.reflect.Type type = typeArr[i];
            if (type instanceof java.lang.reflect.ParameterizedType) {
                java.lang.reflect.ParameterizedType parameterizedType = (java.lang.reflect.ParameterizedType) type;
                java.lang.reflect.Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                if (getArgument(actualTypeArguments, map)) {
                    typeArr[i] = com.alibaba.fastjson.TypeReference.intern(new com.alibaba.fastjson.util.ParameterizedTypeImpl(actualTypeArguments, parameterizedType.getOwnerType(), parameterizedType.getRawType()));
                    z = true;
                }
            } else if ((type instanceof java.lang.reflect.TypeVariable) && map.containsKey(type)) {
                typeArr[i] = map.get(type);
                z = true;
            }
        }
        return z;
    }

    private static boolean getArgument(java.lang.reflect.Type[] typeArr, java.lang.reflect.TypeVariable[] typeVariableArr, java.lang.reflect.Type[] typeArr2) {
        if (typeArr2 == null || typeVariableArr.length == 0) {
            return false;
        }
        boolean z = false;
        for (int i = 0; i < typeArr.length; i++) {
            java.lang.reflect.Type type = typeArr[i];
            if (type instanceof java.lang.reflect.ParameterizedType) {
                java.lang.reflect.ParameterizedType parameterizedType = (java.lang.reflect.ParameterizedType) type;
                java.lang.reflect.Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                if (getArgument(actualTypeArguments, typeVariableArr, typeArr2)) {
                    typeArr[i] = com.alibaba.fastjson.TypeReference.intern(new com.alibaba.fastjson.util.ParameterizedTypeImpl(actualTypeArguments, parameterizedType.getOwnerType(), parameterizedType.getRawType()));
                    z = true;
                }
            } else if (type instanceof java.lang.reflect.TypeVariable) {
                for (int i2 = 0; i2 < typeVariableArr.length; i2++) {
                    if (type.equals(typeVariableArr[i2])) {
                        typeArr[i] = typeArr2[i2];
                        z = true;
                    }
                }
            }
        }
        return z;
    }

    private static java.lang.reflect.Type getInheritGenericType(java.lang.Class<?> cls, java.lang.reflect.Type type, java.lang.reflect.TypeVariable<?> typeVariable) {
        java.lang.reflect.Type[] actualTypeArguments;
        java.lang.Class<?> cls2 = typeVariable.getGenericDeclaration() instanceof java.lang.Class ? (java.lang.Class) typeVariable.getGenericDeclaration() : null;
        if (cls2 == cls) {
            actualTypeArguments = type instanceof java.lang.reflect.ParameterizedType ? ((java.lang.reflect.ParameterizedType) type).getActualTypeArguments() : null;
        } else {
            java.lang.reflect.Type[] typeArr = null;
            while (cls != null && cls != java.lang.Object.class && cls != cls2) {
                java.lang.reflect.Type genericSuperclass = cls.getGenericSuperclass();
                if (genericSuperclass instanceof java.lang.reflect.ParameterizedType) {
                    java.lang.reflect.Type[] actualTypeArguments2 = ((java.lang.reflect.ParameterizedType) genericSuperclass).getActualTypeArguments();
                    getArgument(actualTypeArguments2, cls.getTypeParameters(), typeArr);
                    typeArr = actualTypeArguments2;
                }
                cls = cls.getSuperclass();
            }
            actualTypeArguments = typeArr;
        }
        if (actualTypeArguments != null && cls2 != null) {
            java.lang.reflect.TypeVariable<java.lang.Class<?>>[] typeParameters = cls2.getTypeParameters();
            for (int i = 0; i < typeParameters.length; i++) {
                if (typeVariable.equals(typeParameters[i])) {
                    return actualTypeArguments[i];
                }
            }
        }
        return null;
    }

    public java.lang.String toString() {
        return this.name;
    }

    public java.lang.reflect.Member getMember() {
        java.lang.reflect.Method method = this.method;
        return method != null ? method : this.field;
    }

    protected java.lang.Class<?> getDeclaredClass() {
        java.lang.reflect.Method method = this.method;
        if (method != null) {
            return method.getDeclaringClass();
        }
        java.lang.reflect.Field field = this.field;
        if (field != null) {
            return field.getDeclaringClass();
        }
        return null;
    }

    @Override // java.lang.Comparable
    public int compareTo(com.alibaba.fastjson.util.FieldInfo fieldInfo) {
        java.lang.reflect.Method method = fieldInfo.method;
        if (method != null && this.method != null && method.isBridge() && !this.method.isBridge() && fieldInfo.method.getName().equals(this.method.getName())) {
            return 1;
        }
        int i = this.ordinal;
        int i2 = fieldInfo.ordinal;
        if (i < i2) {
            return -1;
        }
        if (i > i2) {
            return 1;
        }
        int iCompareTo = this.name.compareTo(fieldInfo.name);
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        java.lang.Class<?> declaredClass = getDeclaredClass();
        java.lang.Class<?> declaredClass2 = fieldInfo.getDeclaredClass();
        if (declaredClass != null && declaredClass2 != null && declaredClass != declaredClass2) {
            if (declaredClass.isAssignableFrom(declaredClass2)) {
                return -1;
            }
            if (declaredClass2.isAssignableFrom(declaredClass)) {
                return 1;
            }
        }
        java.lang.reflect.Field field = this.field;
        boolean z = false;
        boolean z2 = field != null && field.getType() == this.fieldClass;
        java.lang.reflect.Field field2 = fieldInfo.field;
        if (field2 != null && field2.getType() == fieldInfo.fieldClass) {
            z = true;
        }
        if (z2 && !z) {
            return 1;
        }
        if (z && !z2) {
            return -1;
        }
        if (fieldInfo.fieldClass.isPrimitive() && !this.fieldClass.isPrimitive()) {
            return 1;
        }
        if (this.fieldClass.isPrimitive() && !fieldInfo.fieldClass.isPrimitive()) {
            return -1;
        }
        if (fieldInfo.fieldClass.getName().startsWith("java.") && !this.fieldClass.getName().startsWith("java.")) {
            return 1;
        }
        if (!this.fieldClass.getName().startsWith("java.") || fieldInfo.fieldClass.getName().startsWith("java.")) {
            return this.fieldClass.getName().compareTo(fieldInfo.fieldClass.getName());
        }
        return -1;
    }

    public com.alibaba.fastjson.annotation.JSONField getAnnotation() {
        com.alibaba.fastjson.annotation.JSONField jSONField = this.fieldAnnotation;
        return jSONField != null ? jSONField : this.methodAnnotation;
    }

    public java.lang.String getFormat() {
        return this.format;
    }

    public java.lang.Object get(java.lang.Object obj) throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        java.lang.reflect.Method method = this.method;
        if (method != null) {
            return method.invoke(obj, null);
        }
        return this.field.get(obj);
    }

    public void set(java.lang.Object obj, java.lang.Object obj2) throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        java.lang.reflect.Method method = this.method;
        if (method != null) {
            method.invoke(obj, obj2);
        } else {
            this.field.set(obj, obj2);
        }
    }

    public void setAccessible() throws java.lang.SecurityException {
        java.lang.reflect.Method method = this.method;
        if (method != null) {
            com.alibaba.fastjson.util.TypeUtils.setAccessible(method);
        } else {
            com.alibaba.fastjson.util.TypeUtils.setAccessible(this.field);
        }
    }
}
