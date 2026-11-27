package io.dcloud.uts.gson.internal;

/* JADX INFO: renamed from: io.dcloud.uts.gson.internal.$Gson$Types, reason: invalid class name */
/* JADX INFO: loaded from: classes2.dex */
public final class C$Gson$Types {
    static final java.lang.reflect.Type[] EMPTY_TYPE_ARRAY = new java.lang.reflect.Type[0];

    private C$Gson$Types() {
        throw new java.lang.UnsupportedOperationException();
    }

    public static java.lang.reflect.ParameterizedType newParameterizedTypeWithOwner(java.lang.reflect.Type type, java.lang.reflect.Type type2, java.lang.reflect.Type... typeArr) {
        return new io.dcloud.uts.gson.internal.C$Gson$Types.ParameterizedTypeImpl(type, type2, typeArr);
    }

    public static java.lang.reflect.GenericArrayType arrayOf(java.lang.reflect.Type type) {
        return new io.dcloud.uts.gson.internal.C$Gson$Types.GenericArrayTypeImpl(type);
    }

    public static java.lang.reflect.WildcardType subtypeOf(java.lang.reflect.Type type) {
        java.lang.reflect.Type[] upperBounds;
        if (type instanceof java.lang.reflect.WildcardType) {
            upperBounds = ((java.lang.reflect.WildcardType) type).getUpperBounds();
        } else {
            upperBounds = new java.lang.reflect.Type[]{type};
        }
        return new io.dcloud.uts.gson.internal.C$Gson$Types.WildcardTypeImpl(upperBounds, EMPTY_TYPE_ARRAY);
    }

    public static java.lang.reflect.WildcardType supertypeOf(java.lang.reflect.Type type) {
        java.lang.reflect.Type[] lowerBounds;
        if (type instanceof java.lang.reflect.WildcardType) {
            lowerBounds = ((java.lang.reflect.WildcardType) type).getLowerBounds();
        } else {
            lowerBounds = new java.lang.reflect.Type[]{type};
        }
        return new io.dcloud.uts.gson.internal.C$Gson$Types.WildcardTypeImpl(new java.lang.reflect.Type[]{java.lang.Object.class}, lowerBounds);
    }

    public static java.lang.reflect.Type canonicalize(java.lang.reflect.Type type) {
        if (type instanceof java.lang.Class) {
            java.lang.Class cls = (java.lang.Class) type;
            return cls.isArray() ? new io.dcloud.uts.gson.internal.C$Gson$Types.GenericArrayTypeImpl(canonicalize(cls.getComponentType())) : cls;
        }
        if (type instanceof java.lang.reflect.ParameterizedType) {
            java.lang.reflect.ParameterizedType parameterizedType = (java.lang.reflect.ParameterizedType) type;
            return new io.dcloud.uts.gson.internal.C$Gson$Types.ParameterizedTypeImpl(parameterizedType.getOwnerType(), parameterizedType.getRawType(), parameterizedType.getActualTypeArguments());
        }
        if (type instanceof java.lang.reflect.GenericArrayType) {
            return new io.dcloud.uts.gson.internal.C$Gson$Types.GenericArrayTypeImpl(((java.lang.reflect.GenericArrayType) type).getGenericComponentType());
        }
        if (!(type instanceof java.lang.reflect.WildcardType)) {
            return type;
        }
        java.lang.reflect.WildcardType wildcardType = (java.lang.reflect.WildcardType) type;
        return new io.dcloud.uts.gson.internal.C$Gson$Types.WildcardTypeImpl(wildcardType.getUpperBounds(), wildcardType.getLowerBounds());
    }

    public static java.lang.Class<?> getRawType(java.lang.reflect.Type type) {
        if (type instanceof java.lang.Class) {
            return (java.lang.Class) type;
        }
        if (type instanceof java.lang.reflect.ParameterizedType) {
            java.lang.reflect.Type rawType = ((java.lang.reflect.ParameterizedType) type).getRawType();
            io.dcloud.uts.gson.internal.C$Gson$Preconditions.checkArgument(rawType instanceof java.lang.Class);
            return (java.lang.Class) rawType;
        }
        if (type instanceof java.lang.reflect.GenericArrayType) {
            return java.lang.reflect.Array.newInstance(getRawType(((java.lang.reflect.GenericArrayType) type).getGenericComponentType()), 0).getClass();
        }
        if (type instanceof java.lang.reflect.TypeVariable) {
            return java.lang.Object.class;
        }
        if (type instanceof java.lang.reflect.WildcardType) {
            return getRawType(((java.lang.reflect.WildcardType) type).getUpperBounds()[0]);
        }
        throw new java.lang.IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + (type == null ? "null" : type.getClass().getName()));
    }

    static boolean equal(java.lang.Object obj, java.lang.Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static boolean equals(java.lang.reflect.Type type, java.lang.reflect.Type type2) {
        if (type == type2) {
            return true;
        }
        if (type instanceof java.lang.Class) {
            return type.equals(type2);
        }
        if (type instanceof java.lang.reflect.ParameterizedType) {
            if (!(type2 instanceof java.lang.reflect.ParameterizedType)) {
                return false;
            }
            java.lang.reflect.ParameterizedType parameterizedType = (java.lang.reflect.ParameterizedType) type;
            java.lang.reflect.ParameterizedType parameterizedType2 = (java.lang.reflect.ParameterizedType) type2;
            return equal(parameterizedType.getOwnerType(), parameterizedType2.getOwnerType()) && parameterizedType.getRawType().equals(parameterizedType2.getRawType()) && java.util.Arrays.equals(parameterizedType.getActualTypeArguments(), parameterizedType2.getActualTypeArguments());
        }
        if (type instanceof java.lang.reflect.GenericArrayType) {
            if (type2 instanceof java.lang.reflect.GenericArrayType) {
                return equals(((java.lang.reflect.GenericArrayType) type).getGenericComponentType(), ((java.lang.reflect.GenericArrayType) type2).getGenericComponentType());
            }
            return false;
        }
        if (type instanceof java.lang.reflect.WildcardType) {
            if (!(type2 instanceof java.lang.reflect.WildcardType)) {
                return false;
            }
            java.lang.reflect.WildcardType wildcardType = (java.lang.reflect.WildcardType) type;
            java.lang.reflect.WildcardType wildcardType2 = (java.lang.reflect.WildcardType) type2;
            return java.util.Arrays.equals(wildcardType.getUpperBounds(), wildcardType2.getUpperBounds()) && java.util.Arrays.equals(wildcardType.getLowerBounds(), wildcardType2.getLowerBounds());
        }
        if (!(type instanceof java.lang.reflect.TypeVariable) || !(type2 instanceof java.lang.reflect.TypeVariable)) {
            return false;
        }
        java.lang.reflect.TypeVariable typeVariable = (java.lang.reflect.TypeVariable) type;
        java.lang.reflect.TypeVariable typeVariable2 = (java.lang.reflect.TypeVariable) type2;
        return typeVariable.getGenericDeclaration() == typeVariable2.getGenericDeclaration() && typeVariable.getName().equals(typeVariable2.getName());
    }

    static int hashCodeOrZero(java.lang.Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public static java.lang.String typeToString(java.lang.reflect.Type type) {
        return type instanceof java.lang.Class ? ((java.lang.Class) type).getName() : type.toString();
    }

    static java.lang.reflect.Type getGenericSupertype(java.lang.reflect.Type type, java.lang.Class<?> cls, java.lang.Class<?> cls2) {
        if (cls2 == cls) {
            return type;
        }
        if (cls2.isInterface()) {
            java.lang.Class<?>[] interfaces = cls.getInterfaces();
            int length = interfaces.length;
            for (int i = 0; i < length; i++) {
                java.lang.Class<?> cls3 = interfaces[i];
                if (cls3 == cls2) {
                    return cls.getGenericInterfaces()[i];
                }
                if (cls2.isAssignableFrom(cls3)) {
                    return getGenericSupertype(cls.getGenericInterfaces()[i], interfaces[i], cls2);
                }
            }
        }
        if (!cls.isInterface()) {
            while (cls != java.lang.Object.class) {
                java.lang.Class<? super java.lang.Object> superclass = cls.getSuperclass();
                if (superclass == cls2) {
                    return cls.getGenericSuperclass();
                }
                if (cls2.isAssignableFrom(superclass)) {
                    return getGenericSupertype(cls.getGenericSuperclass(), superclass, cls2);
                }
                cls = superclass;
            }
        }
        return cls2;
    }

    static java.lang.reflect.Type getSupertype(java.lang.reflect.Type type, java.lang.Class<?> cls, java.lang.Class<?> cls2) {
        if (type instanceof java.lang.reflect.WildcardType) {
            type = ((java.lang.reflect.WildcardType) type).getUpperBounds()[0];
        }
        io.dcloud.uts.gson.internal.C$Gson$Preconditions.checkArgument(cls2.isAssignableFrom(cls));
        return resolve(type, cls, getGenericSupertype(type, cls, cls2));
    }

    public static java.lang.reflect.Type getArrayComponentType(java.lang.reflect.Type type) {
        if (type instanceof java.lang.reflect.GenericArrayType) {
            return ((java.lang.reflect.GenericArrayType) type).getGenericComponentType();
        }
        return ((java.lang.Class) type).getComponentType();
    }

    public static java.lang.reflect.Type getCollectionElementType(java.lang.reflect.Type type, java.lang.Class<?> cls) {
        java.lang.reflect.Type supertype = getSupertype(type, cls, java.util.Collection.class);
        if (supertype instanceof java.lang.reflect.WildcardType) {
            supertype = ((java.lang.reflect.WildcardType) supertype).getUpperBounds()[0];
        }
        if (supertype instanceof java.lang.reflect.ParameterizedType) {
            return ((java.lang.reflect.ParameterizedType) supertype).getActualTypeArguments()[0];
        }
        return java.lang.Object.class;
    }

    public static java.lang.reflect.Type[] getMapKeyAndValueTypes(java.lang.reflect.Type type, java.lang.Class<?> cls) {
        if (type == java.util.Properties.class) {
            return new java.lang.reflect.Type[]{java.lang.String.class, java.lang.String.class};
        }
        java.lang.reflect.Type supertype = getSupertype(type, cls, java.util.Map.class);
        if (supertype instanceof java.lang.reflect.ParameterizedType) {
            return ((java.lang.reflect.ParameterizedType) supertype).getActualTypeArguments();
        }
        return new java.lang.reflect.Type[]{java.lang.Object.class, java.lang.Object.class};
    }

    public static java.lang.reflect.Type resolve(java.lang.reflect.Type type, java.lang.Class<?> cls, java.lang.reflect.Type type2) {
        return resolve(type, cls, type2, new java.util.HashMap());
    }

    /* JADX WARN: Code duplicated, block: B:26:0x004b  */
    /* JADX WARN: Code duplicated, block: B:28:0x004f  */
    /* JADX WARN: Code duplicated, block: B:31:0x0061  */
    /* JADX WARN: Code duplicated, block: B:32:0x0066  */
    /* JADX WARN: Code duplicated, block: B:34:0x006c  */
    /* JADX WARN: Code duplicated, block: B:36:0x0082  */
    /* JADX WARN: Code duplicated, block: B:40:0x0090 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:41:0x0092  */
    /* JADX WARN: Code duplicated, block: B:47:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:48:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:50:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:52:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:54:0x00c7 A[EDGE_INSN: B:54:0x00c7->B:60:0x00dd BREAK  A[LOOP:0: B:3:0x0001->B:68:?]] */
    /* JADX WARN: Code duplicated, block: B:55:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:71:0x009c A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r11v10, types: [java.lang.Object, java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r11v12, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r11v2, types: [java.lang.reflect.WildcardType] */
    /* JADX WARN: Type inference failed for: r11v3, types: [java.lang.reflect.WildcardType] */
    /* JADX WARN: Type inference failed for: r11v4, types: [java.lang.reflect.WildcardType] */
    /* JADX WARN: Type inference failed for: r11v5, types: [java.lang.reflect.ParameterizedType] */
    /* JADX WARN: Type inference failed for: r11v6, types: [java.lang.reflect.GenericArrayType] */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r12v0, types: [java.util.Map, java.util.Map<java.lang.reflect.TypeVariable<?>, java.lang.reflect.Type>] */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v19 */
    private static java.lang.reflect.Type resolve(java.lang.reflect.Type type, java.lang.Class<?> cls, java.lang.reflect.Type type2, java.util.Map<java.lang.reflect.TypeVariable<?>, java.lang.reflect.Type> map) {
        int i;
        java.lang.reflect.Type[] lowerBounds;
        java.lang.reflect.Type[] upperBounds;
        java.lang.reflect.Type typeResolve;
        java.lang.reflect.Type typeResolve2;
        java.lang.reflect.Type typeResolve3;
        boolean z;
        java.lang.reflect.Type[] actualTypeArguments;
        int length;
        java.lang.reflect.Type typeNewParameterizedTypeWithOwner;
        java.lang.reflect.Type typeResolve4;
        java.lang.reflect.Type genericComponentType;
        java.lang.reflect.Type typeResolve5;
        java.lang.reflect.TypeVariable typeVariable;
        java.lang.reflect.TypeVariable typeVariable2 = null;
        do {
            if (type2 instanceof java.lang.reflect.TypeVariable) {
                typeVariable = (java.lang.reflect.TypeVariable) type2;
                java.lang.reflect.Type type3 = (java.lang.reflect.Type) map.get(typeVariable);
                if (type3 != null) {
                    return type3 == java.lang.Void.TYPE ? type2 : type3;
                }
                map.put(typeVariable, java.lang.Void.TYPE);
                if (typeVariable2 == null) {
                    typeVariable2 = typeVariable;
                }
                type2 = resolveTypeVariable(type, cls, typeVariable);
            } else {
                if (!(type2 instanceof java.lang.Class)) {
                    if (type2 instanceof java.lang.reflect.GenericArrayType) {
                        type2 = (java.lang.reflect.GenericArrayType) type2;
                        genericComponentType = type2.getGenericComponentType();
                        typeResolve5 = resolve(type, cls, genericComponentType, map);
                        if (equal(genericComponentType, typeResolve5)) {
                            typeNewParameterizedTypeWithOwner = arrayOf(typeResolve5);
                            type2 = typeNewParameterizedTypeWithOwner;
                            break;
                        }
                        break;
                    }
                    if (type2 instanceof java.lang.reflect.ParameterizedType) {
                        type2 = (java.lang.reflect.ParameterizedType) type2;
                        java.lang.reflect.Type ownerType = type2.getOwnerType();
                        typeResolve3 = resolve(type, cls, ownerType, map);
                        z = !equal(typeResolve3, ownerType);
                        actualTypeArguments = type2.getActualTypeArguments();
                        length = actualTypeArguments.length;
                        for (i = 0; i < length; i++) {
                            typeResolve4 = resolve(type, cls, actualTypeArguments[i], map);
                            if (equal(typeResolve4, actualTypeArguments[i])) {
                                if (!z) {
                                    actualTypeArguments = (java.lang.reflect.Type[]) actualTypeArguments.clone();
                                    z = true;
                                }
                                actualTypeArguments[i] = typeResolve4;
                            }
                        }
                        if (z) {
                            break;
                        }
                        typeNewParameterizedTypeWithOwner = newParameterizedTypeWithOwner(typeResolve3, type2.getRawType(), actualTypeArguments);
                        type2 = typeNewParameterizedTypeWithOwner;
                        break;
                    }
                    if (type2 instanceof java.lang.reflect.WildcardType) {
                        break;
                    }
                    type2 = (java.lang.reflect.WildcardType) type2;
                    lowerBounds = type2.getLowerBounds();
                    upperBounds = type2.getUpperBounds();
                    if (lowerBounds.length == 1) {
                        typeResolve2 = resolve(type, cls, lowerBounds[0], map);
                        if (typeResolve2 != lowerBounds[0]) {
                            break;
                        }
                        type2 = supertypeOf(typeResolve2);
                        break;
                    }
                    if (upperBounds.length != 1) {
                        break;
                    }
                    type2 = subtypeOf(typeResolve);
                    break;
                }
                java.lang.Class cls2 = (java.lang.Class) type2;
                if (cls2.isArray()) {
                    java.lang.Class<?> componentType = cls2.getComponentType();
                    java.lang.reflect.Type typeResolve6 = resolve(type, cls, componentType, map);
                    if (!equal(componentType, typeResolve6)) {
                        typeNewParameterizedTypeWithOwner = arrayOf(typeResolve6);
                        type2 = typeNewParameterizedTypeWithOwner;
                        break;
                    }
                    type2 = cls2;
                    break;
                }
                if (type2 instanceof java.lang.reflect.GenericArrayType) {
                    type2 = (java.lang.reflect.GenericArrayType) type2;
                    genericComponentType = type2.getGenericComponentType();
                    typeResolve5 = resolve(type, cls, genericComponentType, map);
                    if (equal(genericComponentType, typeResolve5)) {
                        break;
                    }
                    typeNewParameterizedTypeWithOwner = arrayOf(typeResolve5);
                    type2 = typeNewParameterizedTypeWithOwner;
                    break;
                }
                if (type2 instanceof java.lang.reflect.ParameterizedType) {
                    type2 = (java.lang.reflect.ParameterizedType) type2;
                    java.lang.reflect.Type ownerType2 = type2.getOwnerType();
                    typeResolve3 = resolve(type, cls, ownerType2, map);
                    z = !equal(typeResolve3, ownerType2);
                    actualTypeArguments = type2.getActualTypeArguments();
                    length = actualTypeArguments.length;
                    while (i < length) {
                        typeResolve4 = resolve(type, cls, actualTypeArguments[i], map);
                        if (equal(typeResolve4, actualTypeArguments[i])) {
                            if (!z) {
                                actualTypeArguments = (java.lang.reflect.Type[]) actualTypeArguments.clone();
                                z = true;
                            }
                            actualTypeArguments[i] = typeResolve4;
                        }
                    }
                    if (z) {
                        break;
                    }
                    typeNewParameterizedTypeWithOwner = newParameterizedTypeWithOwner(typeResolve3, type2.getRawType(), actualTypeArguments);
                    type2 = typeNewParameterizedTypeWithOwner;
                    break;
                }
                if (type2 instanceof java.lang.reflect.WildcardType) {
                    break;
                }
                type2 = (java.lang.reflect.WildcardType) type2;
                lowerBounds = type2.getLowerBounds();
                upperBounds = type2.getUpperBounds();
                if (lowerBounds.length == 1) {
                    typeResolve2 = resolve(type, cls, lowerBounds[0], map);
                    if (typeResolve2 != lowerBounds[0]) {
                        break;
                    }
                    type2 = supertypeOf(typeResolve2);
                    break;
                }
                if (upperBounds.length != 1 && (typeResolve = resolve(type, cls, upperBounds[0], map)) != upperBounds[0]) {
                    type2 = subtypeOf(typeResolve);
                    break;
                }
                break;
                break;
            }
        } while (type2 != typeVariable);
        if (typeVariable2 != null) {
            map.put(typeVariable2, type2);
        }
        return type2;
    }

    static java.lang.reflect.Type resolveTypeVariable(java.lang.reflect.Type type, java.lang.Class<?> cls, java.lang.reflect.TypeVariable<?> typeVariable) {
        java.lang.Class<?> clsDeclaringClassOf = declaringClassOf(typeVariable);
        if (clsDeclaringClassOf != null) {
            java.lang.reflect.Type genericSupertype = getGenericSupertype(type, cls, clsDeclaringClassOf);
            if (genericSupertype instanceof java.lang.reflect.ParameterizedType) {
                return ((java.lang.reflect.ParameterizedType) genericSupertype).getActualTypeArguments()[indexOf(clsDeclaringClassOf.getTypeParameters(), typeVariable)];
            }
        }
        return typeVariable;
    }

    private static int indexOf(java.lang.Object[] objArr, java.lang.Object obj) {
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            if (obj.equals(objArr[i])) {
                return i;
            }
        }
        throw new java.util.NoSuchElementException();
    }

    private static java.lang.Class<?> declaringClassOf(java.lang.reflect.TypeVariable<?> typeVariable) {
        java.lang.reflect.GenericDeclaration genericDeclaration = typeVariable.getGenericDeclaration();
        if (genericDeclaration instanceof java.lang.Class) {
            return (java.lang.Class) genericDeclaration;
        }
        return null;
    }

    static void checkNotPrimitive(java.lang.reflect.Type type) {
        io.dcloud.uts.gson.internal.C$Gson$Preconditions.checkArgument(((type instanceof java.lang.Class) && ((java.lang.Class) type).isPrimitive()) ? false : true);
    }

    /* JADX INFO: renamed from: io.dcloud.uts.gson.internal.$Gson$Types$ParameterizedTypeImpl */
    /* JADX INFO: compiled from: $Gson$Types.java */
    private static final class ParameterizedTypeImpl implements java.lang.reflect.ParameterizedType, java.io.Serializable {
        private static final long serialVersionUID = 0;
        private final java.lang.reflect.Type ownerType;
        private final java.lang.reflect.Type rawType;
        private final java.lang.reflect.Type[] typeArguments;

        public ParameterizedTypeImpl(java.lang.reflect.Type type, java.lang.reflect.Type type2, java.lang.reflect.Type... typeArr) {
            if (type2 instanceof java.lang.Class) {
                java.lang.Class cls = (java.lang.Class) type2;
                boolean z = true;
                boolean z2 = java.lang.reflect.Modifier.isStatic(cls.getModifiers()) || cls.getEnclosingClass() == null;
                if (type == null && !z2) {
                    z = false;
                }
                io.dcloud.uts.gson.internal.C$Gson$Preconditions.checkArgument(z);
            }
            this.ownerType = type == null ? null : io.dcloud.uts.gson.internal.C$Gson$Types.canonicalize(type);
            this.rawType = io.dcloud.uts.gson.internal.C$Gson$Types.canonicalize(type2);
            java.lang.reflect.Type[] typeArr2 = (java.lang.reflect.Type[]) typeArr.clone();
            this.typeArguments = typeArr2;
            int length = typeArr2.length;
            for (int i = 0; i < length; i++) {
                io.dcloud.uts.gson.internal.C$Gson$Preconditions.checkNotNull(this.typeArguments[i]);
                io.dcloud.uts.gson.internal.C$Gson$Types.checkNotPrimitive(this.typeArguments[i]);
                java.lang.reflect.Type[] typeArr3 = this.typeArguments;
                typeArr3[i] = io.dcloud.uts.gson.internal.C$Gson$Types.canonicalize(typeArr3[i]);
            }
        }

        @Override // java.lang.reflect.ParameterizedType
        public java.lang.reflect.Type[] getActualTypeArguments() {
            return (java.lang.reflect.Type[]) this.typeArguments.clone();
        }

        @Override // java.lang.reflect.ParameterizedType
        public java.lang.reflect.Type getRawType() {
            return this.rawType;
        }

        @Override // java.lang.reflect.ParameterizedType
        public java.lang.reflect.Type getOwnerType() {
            return this.ownerType;
        }

        public boolean equals(java.lang.Object obj) {
            return (obj instanceof java.lang.reflect.ParameterizedType) && io.dcloud.uts.gson.internal.C$Gson$Types.equals(this, (java.lang.reflect.ParameterizedType) obj);
        }

        public int hashCode() {
            return (java.util.Arrays.hashCode(this.typeArguments) ^ this.rawType.hashCode()) ^ io.dcloud.uts.gson.internal.C$Gson$Types.hashCodeOrZero(this.ownerType);
        }

        public java.lang.String toString() {
            int length = this.typeArguments.length;
            if (length == 0) {
                return io.dcloud.uts.gson.internal.C$Gson$Types.typeToString(this.rawType);
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder((length + 1) * 30);
            sb.append(io.dcloud.uts.gson.internal.C$Gson$Types.typeToString(this.rawType));
            sb.append(com.taobao.weex.el.parse.Operators.L);
            sb.append(io.dcloud.uts.gson.internal.C$Gson$Types.typeToString(this.typeArguments[0]));
            for (int i = 1; i < length; i++) {
                sb.append(", ");
                sb.append(io.dcloud.uts.gson.internal.C$Gson$Types.typeToString(this.typeArguments[i]));
            }
            sb.append(com.taobao.weex.el.parse.Operators.G);
            return sb.toString();
        }
    }

    /* JADX INFO: renamed from: io.dcloud.uts.gson.internal.$Gson$Types$GenericArrayTypeImpl */
    /* JADX INFO: compiled from: $Gson$Types.java */
    private static final class GenericArrayTypeImpl implements java.lang.reflect.GenericArrayType, java.io.Serializable {
        private static final long serialVersionUID = 0;
        private final java.lang.reflect.Type componentType;

        public GenericArrayTypeImpl(java.lang.reflect.Type type) {
            this.componentType = io.dcloud.uts.gson.internal.C$Gson$Types.canonicalize(type);
        }

        @Override // java.lang.reflect.GenericArrayType
        public java.lang.reflect.Type getGenericComponentType() {
            return this.componentType;
        }

        public boolean equals(java.lang.Object obj) {
            return (obj instanceof java.lang.reflect.GenericArrayType) && io.dcloud.uts.gson.internal.C$Gson$Types.equals(this, (java.lang.reflect.GenericArrayType) obj);
        }

        public int hashCode() {
            return this.componentType.hashCode();
        }

        public java.lang.String toString() {
            return io.dcloud.uts.gson.internal.C$Gson$Types.typeToString(this.componentType) + "[]";
        }
    }

    /* JADX INFO: renamed from: io.dcloud.uts.gson.internal.$Gson$Types$WildcardTypeImpl */
    /* JADX INFO: compiled from: $Gson$Types.java */
    private static final class WildcardTypeImpl implements java.lang.reflect.WildcardType, java.io.Serializable {
        private static final long serialVersionUID = 0;
        private final java.lang.reflect.Type lowerBound;
        private final java.lang.reflect.Type upperBound;

        public WildcardTypeImpl(java.lang.reflect.Type[] typeArr, java.lang.reflect.Type[] typeArr2) {
            io.dcloud.uts.gson.internal.C$Gson$Preconditions.checkArgument(typeArr2.length <= 1);
            io.dcloud.uts.gson.internal.C$Gson$Preconditions.checkArgument(typeArr.length == 1);
            if (typeArr2.length == 1) {
                io.dcloud.uts.gson.internal.C$Gson$Preconditions.checkNotNull(typeArr2[0]);
                io.dcloud.uts.gson.internal.C$Gson$Types.checkNotPrimitive(typeArr2[0]);
                io.dcloud.uts.gson.internal.C$Gson$Preconditions.checkArgument(typeArr[0] == java.lang.Object.class);
                this.lowerBound = io.dcloud.uts.gson.internal.C$Gson$Types.canonicalize(typeArr2[0]);
                this.upperBound = java.lang.Object.class;
                return;
            }
            io.dcloud.uts.gson.internal.C$Gson$Preconditions.checkNotNull(typeArr[0]);
            io.dcloud.uts.gson.internal.C$Gson$Types.checkNotPrimitive(typeArr[0]);
            this.lowerBound = null;
            this.upperBound = io.dcloud.uts.gson.internal.C$Gson$Types.canonicalize(typeArr[0]);
        }

        @Override // java.lang.reflect.WildcardType
        public java.lang.reflect.Type[] getUpperBounds() {
            return new java.lang.reflect.Type[]{this.upperBound};
        }

        @Override // java.lang.reflect.WildcardType
        public java.lang.reflect.Type[] getLowerBounds() {
            java.lang.reflect.Type type = this.lowerBound;
            return type != null ? new java.lang.reflect.Type[]{type} : io.dcloud.uts.gson.internal.C$Gson$Types.EMPTY_TYPE_ARRAY;
        }

        public boolean equals(java.lang.Object obj) {
            return (obj instanceof java.lang.reflect.WildcardType) && io.dcloud.uts.gson.internal.C$Gson$Types.equals(this, (java.lang.reflect.WildcardType) obj);
        }

        public int hashCode() {
            java.lang.reflect.Type type = this.lowerBound;
            return (type != null ? type.hashCode() + 31 : 1) ^ (this.upperBound.hashCode() + 31);
        }

        public java.lang.String toString() {
            if (this.lowerBound != null) {
                return "? super " + io.dcloud.uts.gson.internal.C$Gson$Types.typeToString(this.lowerBound);
            }
            if (this.upperBound == java.lang.Object.class) {
                return com.taobao.weex.el.parse.Operators.CONDITION_IF_STRING;
            }
            return "? extends " + io.dcloud.uts.gson.internal.C$Gson$Types.typeToString(this.upperBound);
        }
    }
}
