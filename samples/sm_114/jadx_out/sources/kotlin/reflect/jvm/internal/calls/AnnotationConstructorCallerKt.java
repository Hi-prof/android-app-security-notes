package kotlin.reflect.jvm.internal.calls;

/* JADX INFO: compiled from: AnnotationConstructorCaller.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001c\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0002\u001a$\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0002\u001aI\u0010\u000b\u001a\u0002H\f\"\b\b\u0000\u0010\f*\u00020\u00012\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\f0\u00032\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u000f2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0000¢\u0006\u0002\u0010\u0013¨\u0006\u0014²\u0006\n\u0010\u0015\u001a\u00020\u0007X\u008a\u0084\u0002²\u0006\n\u0010\u0016\u001a\u00020\tX\u008a\u0084\u0002"}, d2 = {"transformKotlinToJvm", "", "expectedType", "Ljava/lang/Class;", "throwIllegalArgumentType", "", "index", "", "name", "", "expectedJvmType", "createAnnotationInstance", "T", "annotationClass", "values", "", "methods", "", "Ljava/lang/reflect/Method;", "(Ljava/lang/Class;Ljava/util/Map;Ljava/util/List;)Ljava/lang/Object;", "kotlin-reflection", "hashCode", "toString"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class AnnotationConstructorCallerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final java.lang.Object transformKotlinToJvm(java.lang.Object obj, java.lang.Class<?> cls) {
        if (obj instanceof java.lang.Class) {
            return null;
        }
        if (obj instanceof kotlin.reflect.KClass) {
            obj = kotlin.jvm.JvmClassMappingKt.getJavaClass((kotlin.reflect.KClass) obj);
        } else if (obj instanceof java.lang.Object[]) {
            java.lang.Object[] objArr = (java.lang.Object[]) obj;
            if (objArr instanceof java.lang.Class[]) {
                return null;
            }
            if (objArr instanceof kotlin.reflect.KClass[]) {
                kotlin.jvm.internal.Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.reflect.KClass<*>>");
                kotlin.reflect.KClass[] kClassArr = (kotlin.reflect.KClass[]) obj;
                java.util.ArrayList arrayList = new java.util.ArrayList(kClassArr.length);
                for (kotlin.reflect.KClass kClass : kClassArr) {
                    arrayList.add(kotlin.jvm.JvmClassMappingKt.getJavaClass(kClass));
                }
                obj = arrayList.toArray(new java.lang.Class[0]);
            } else {
                obj = objArr;
            }
        }
        if (cls.isInstance(obj)) {
            return obj;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.lang.Void throwIllegalArgumentType(int i, java.lang.String str, java.lang.Class<?> cls) {
        kotlin.reflect.KClass orCreateKotlinClass;
        java.lang.String qualifiedName;
        if (kotlin.jvm.internal.Intrinsics.areEqual(cls, java.lang.Class.class)) {
            orCreateKotlinClass = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(kotlin.reflect.KClass.class);
        } else {
            orCreateKotlinClass = (cls.isArray() && kotlin.jvm.internal.Intrinsics.areEqual(cls.getComponentType(), java.lang.Class.class)) ? kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(kotlin.reflect.KClass[].class) : kotlin.jvm.JvmClassMappingKt.getKotlinClass(cls);
        }
        if (kotlin.jvm.internal.Intrinsics.areEqual(orCreateKotlinClass.getQualifiedName(), kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(java.lang.Object[].class).getQualifiedName())) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(orCreateKotlinClass.getQualifiedName());
            sb.append(kotlin.text.Typography.less);
            java.lang.Class<?> componentType = kotlin.jvm.JvmClassMappingKt.getJavaClass(orCreateKotlinClass).getComponentType();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(componentType, "getComponentType(...)");
            sb.append(kotlin.jvm.JvmClassMappingKt.getKotlinClass(componentType).getQualifiedName());
            sb.append(kotlin.text.Typography.greater);
            qualifiedName = sb.toString();
        } else {
            qualifiedName = orCreateKotlinClass.getQualifiedName();
        }
        throw new java.lang.IllegalArgumentException("Argument #" + i + ' ' + str + " is not of the required type " + qualifiedName);
    }

    public static /* synthetic */ java.lang.Object createAnnotationInstance$default(java.lang.Class cls, java.util.Map map, java.util.List list, int i, java.lang.Object obj) {
        if ((i & 4) != 0) {
            java.util.Set setKeySet = map.keySet();
            java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(setKeySet, 10));
            java.util.Iterator it = setKeySet.iterator();
            while (it.hasNext()) {
                arrayList.add(cls.getDeclaredMethod((java.lang.String) it.next(), null));
            }
            list = arrayList;
        }
        return createAnnotationInstance(cls, map, list);
    }

    private static final <T> boolean createAnnotationInstance$equals(java.lang.Class<T> cls, java.util.List<java.lang.reflect.Method> list, java.util.Map<java.lang.String, ? extends java.lang.Object> map, java.lang.Object obj) throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        boolean zAreEqual;
        kotlin.reflect.KClass annotationClass;
        java.lang.annotation.Annotation annotation = obj instanceof java.lang.annotation.Annotation ? (java.lang.annotation.Annotation) obj : null;
        if (!kotlin.jvm.internal.Intrinsics.areEqual((annotation == null || (annotationClass = kotlin.jvm.JvmClassMappingKt.getAnnotationClass(annotation)) == null) ? null : kotlin.jvm.JvmClassMappingKt.getJavaClass(annotationClass), cls)) {
            return false;
        }
        java.util.List<java.lang.reflect.Method> list2 = list;
        if ((list2 instanceof java.util.Collection) && list2.isEmpty()) {
            return true;
        }
        for (java.lang.reflect.Method method : list2) {
            java.lang.Object obj2 = map.get(method.getName());
            java.lang.Object objInvoke = method.invoke(obj, null);
            if (obj2 instanceof boolean[]) {
                kotlin.jvm.internal.Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.BooleanArray");
                zAreEqual = java.util.Arrays.equals((boolean[]) obj2, (boolean[]) objInvoke);
            } else if (obj2 instanceof char[]) {
                kotlin.jvm.internal.Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.CharArray");
                zAreEqual = java.util.Arrays.equals((char[]) obj2, (char[]) objInvoke);
            } else if (obj2 instanceof byte[]) {
                kotlin.jvm.internal.Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.ByteArray");
                zAreEqual = java.util.Arrays.equals((byte[]) obj2, (byte[]) objInvoke);
            } else if (obj2 instanceof short[]) {
                kotlin.jvm.internal.Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.ShortArray");
                zAreEqual = java.util.Arrays.equals((short[]) obj2, (short[]) objInvoke);
            } else if (obj2 instanceof int[]) {
                kotlin.jvm.internal.Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.IntArray");
                zAreEqual = java.util.Arrays.equals((int[]) obj2, (int[]) objInvoke);
            } else if (obj2 instanceof float[]) {
                kotlin.jvm.internal.Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.FloatArray");
                zAreEqual = java.util.Arrays.equals((float[]) obj2, (float[]) objInvoke);
            } else if (obj2 instanceof long[]) {
                kotlin.jvm.internal.Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.LongArray");
                zAreEqual = java.util.Arrays.equals((long[]) obj2, (long[]) objInvoke);
            } else if (obj2 instanceof double[]) {
                kotlin.jvm.internal.Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.DoubleArray");
                zAreEqual = java.util.Arrays.equals((double[]) obj2, (double[]) objInvoke);
            } else if (obj2 instanceof java.lang.Object[]) {
                kotlin.jvm.internal.Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.Array<*>");
                zAreEqual = java.util.Arrays.equals((java.lang.Object[]) obj2, (java.lang.Object[]) objInvoke);
            } else {
                zAreEqual = kotlin.jvm.internal.Intrinsics.areEqual(obj2, objInvoke);
            }
            if (!zAreEqual) {
                return false;
            }
        }
        return true;
    }

    public static final <T> T createAnnotationInstance(final java.lang.Class<T> annotationClass, final java.util.Map<java.lang.String, ? extends java.lang.Object> values, final java.util.List<java.lang.reflect.Method> methods) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(annotationClass, "annotationClass");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(values, "values");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(methods, "methods");
        final kotlin.Lazy lazy = kotlin.LazyKt.lazy(new kotlin.jvm.functions.Function0(values) { // from class: kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt$$Lambda$0
            private final java.util.Map arg$0;

            {
                this.arg$0 = values;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return java.lang.Integer.valueOf(kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt.createAnnotationInstance$lambda$3(this.arg$0));
            }
        });
        final kotlin.Lazy lazy2 = kotlin.LazyKt.lazy(new kotlin.jvm.functions.Function0(annotationClass, values) { // from class: kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt$$Lambda$1
            private final java.lang.Class arg$0;
            private final java.util.Map arg$1;

            {
                this.arg$0 = annotationClass;
                this.arg$1 = values;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt.createAnnotationInstance$lambda$7(this.arg$0, this.arg$1);
            }
        });
        T t = (T) java.lang.reflect.Proxy.newProxyInstance(annotationClass.getClassLoader(), new java.lang.Class[]{annotationClass}, new java.lang.reflect.InvocationHandler(annotationClass, values, lazy2, lazy, methods) { // from class: kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt$$Lambda$2
            private final java.lang.Class arg$0;
            private final java.util.Map arg$1;
            private final kotlin.Lazy arg$2;
            private final kotlin.Lazy arg$3;
            private final java.util.List arg$4;

            {
                this.arg$0 = annotationClass;
                this.arg$1 = values;
                this.arg$2 = lazy2;
                this.arg$3 = lazy;
                this.arg$4 = methods;
            }

            @Override // java.lang.reflect.InvocationHandler
            public java.lang.Object invoke(java.lang.Object obj, java.lang.reflect.Method method, java.lang.Object[] objArr) {
                return kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt.createAnnotationInstance$lambda$9(this.arg$0, this.arg$1, this.arg$2, this.arg$3, this.arg$4, obj, method, objArr);
            }
        });
        kotlin.jvm.internal.Intrinsics.checkNotNull(t, "null cannot be cast to non-null type T of kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt.createAnnotationInstance");
        return t;
    }

    private static final int createAnnotationInstance$lambda$4(kotlin.Lazy<java.lang.Integer> lazy) {
        return lazy.getValue().intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int createAnnotationInstance$lambda$3(java.util.Map map) {
        int iHashCode;
        int iHashCode2 = 0;
        for (java.util.Map.Entry entry : map.entrySet()) {
            java.lang.String str = (java.lang.String) entry.getKey();
            java.lang.Object value = entry.getValue();
            if (value instanceof boolean[]) {
                iHashCode = java.util.Arrays.hashCode((boolean[]) value);
            } else if (value instanceof char[]) {
                iHashCode = java.util.Arrays.hashCode((char[]) value);
            } else if (value instanceof byte[]) {
                iHashCode = java.util.Arrays.hashCode((byte[]) value);
            } else if (value instanceof short[]) {
                iHashCode = java.util.Arrays.hashCode((short[]) value);
            } else if (value instanceof int[]) {
                iHashCode = java.util.Arrays.hashCode((int[]) value);
            } else if (value instanceof float[]) {
                iHashCode = java.util.Arrays.hashCode((float[]) value);
            } else if (value instanceof long[]) {
                iHashCode = java.util.Arrays.hashCode((long[]) value);
            } else if (value instanceof double[]) {
                iHashCode = java.util.Arrays.hashCode((double[]) value);
            } else {
                iHashCode = value instanceof java.lang.Object[] ? java.util.Arrays.hashCode((java.lang.Object[]) value) : value.hashCode();
            }
            iHashCode2 += iHashCode ^ (str.hashCode() * kotlinx.coroutines.scheduling.WorkQueueKt.MASK);
        }
        return iHashCode2;
    }

    private static final java.lang.String createAnnotationInstance$lambda$8(kotlin.Lazy<java.lang.String> lazy) {
        return lazy.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.lang.String createAnnotationInstance$lambda$7(java.lang.Class cls, java.util.Map map) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(com.taobao.weex.ui.component.list.template.TemplateDom.SEPARATOR);
        sb.append(cls.getCanonicalName());
        kotlin.collections.CollectionsKt.joinTo(map.entrySet(), sb, (112 & 2) != 0 ? ", " : ", ", (112 & 4) != 0 ? "" : com.taobao.weex.el.parse.Operators.BRACKET_START_STR, (112 & 8) != 0 ? "" : com.taobao.weex.el.parse.Operators.BRACKET_END_STR, (112 & 16) != 0 ? -1 : 0, (112 & 32) != 0 ? "..." : null, (112 & 64) != 0 ? null : new kotlin.jvm.functions.Function1() { // from class: kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt$$Lambda$3
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt.createAnnotationInstance$lambda$7$lambda$6$lambda$5((java.util.Map.Entry) obj);
            }
        });
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.lang.CharSequence createAnnotationInstance$lambda$7$lambda$6$lambda$5(java.util.Map.Entry entry) {
        java.lang.String string;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(entry, "entry");
        java.lang.String str = (java.lang.String) entry.getKey();
        java.lang.Object value = entry.getValue();
        if (value instanceof boolean[]) {
            string = java.util.Arrays.toString((boolean[]) value);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        } else if (value instanceof char[]) {
            string = java.util.Arrays.toString((char[]) value);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        } else if (value instanceof byte[]) {
            string = java.util.Arrays.toString((byte[]) value);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        } else if (value instanceof short[]) {
            string = java.util.Arrays.toString((short[]) value);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        } else if (value instanceof int[]) {
            string = java.util.Arrays.toString((int[]) value);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        } else if (value instanceof float[]) {
            string = java.util.Arrays.toString((float[]) value);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        } else if (value instanceof long[]) {
            string = java.util.Arrays.toString((long[]) value);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        } else if (value instanceof double[]) {
            string = java.util.Arrays.toString((double[]) value);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        } else if (value instanceof java.lang.Object[]) {
            string = java.util.Arrays.toString((java.lang.Object[]) value);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        } else {
            string = value.toString();
        }
        return str + '=' + string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.lang.Object createAnnotationInstance$lambda$9(java.lang.Class cls, java.util.Map map, kotlin.Lazy lazy, kotlin.Lazy lazy2, java.util.List list, java.lang.Object obj, java.lang.reflect.Method method, java.lang.Object[] objArr) {
        java.lang.String name = method.getName();
        if (name != null) {
            int iHashCode = name.hashCode();
            if (iHashCode != -1776922004) {
                if (iHashCode != 147696667) {
                    if (iHashCode == 1444986633 && name.equals("annotationType")) {
                        return cls;
                    }
                } else if (name.equals("hashCode")) {
                    return java.lang.Integer.valueOf(createAnnotationInstance$lambda$4(lazy2));
                }
            } else if (name.equals("toString")) {
                return createAnnotationInstance$lambda$8(lazy);
            }
        }
        if (kotlin.jvm.internal.Intrinsics.areEqual(name, "equals") && objArr != null && objArr.length == 1) {
            return java.lang.Boolean.valueOf(createAnnotationInstance$equals(cls, list, map, kotlin.collections.ArraysKt.single(objArr)));
        }
        if (map.containsKey(name)) {
            return map.get(name);
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder("Method is not supported: ");
        sb.append(method);
        sb.append(" (args: ");
        if (objArr == null) {
            objArr = new java.lang.Object[0];
        }
        sb.append(kotlin.collections.ArraysKt.toList(objArr));
        sb.append(com.taobao.weex.el.parse.Operators.BRACKET_END);
        throw new kotlin.reflect.jvm.internal.KotlinReflectionInternalError(sb.toString());
    }
}
