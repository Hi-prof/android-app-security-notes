package kotlin.reflect.jvm;

/* JADX INFO: compiled from: ReflectJvmMapping.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000Z\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a\u000e\u0010 \u001a\u0004\u0018\u00010!*\u00020\"H\u0002\u001a$\u0010&\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000e*\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030(0'2\u0006\u0010)\u001a\u00020\u0006H\u0002\u001a$\u0010*\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002*\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030(0'2\u0006\u0010+\u001a\u00020\u0001H\u0002\"\u001b\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0006\u0012\u0002\b\u00030\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u0006\u0012\u0002\b\u00030\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"\u001b\u0010\t\u001a\u0004\u0018\u00010\u0006*\u0006\u0012\u0002\b\u00030\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\"\u001b\u0010\r\u001a\u0004\u0018\u00010\u0006*\u0006\u0012\u0002\b\u00030\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\"/\u0010\u0011\u001a\n\u0012\u0004\u0012\u0002H\u0013\u0018\u00010\u0012\"\u0004\b\u0000\u0010\u0013*\b\u0012\u0004\u0012\u0002H\u00130\u000e8F¢\u0006\f\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0015\u0010\u0018\u001a\u00020\u0019*\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\"\u001b\u0010\u001d\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f\"\u001b\u0010#\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000e*\u00020\u00068F¢\u0006\u0006\u001a\u0004\b$\u0010%\"-\u0010#\u001a\n\u0012\u0004\u0012\u0002H\u0013\u0018\u00010\u000e\"\b\b\u0000\u0010\u0013*\u00020,*\b\u0012\u0004\u0012\u0002H\u00130\u00128F¢\u0006\u0006\u001a\u0004\b$\u0010-¨\u0006."}, d2 = {"javaField", "Ljava/lang/reflect/Field;", "Lkotlin/reflect/KProperty;", "getJavaField", "(Lkotlin/reflect/KProperty;)Ljava/lang/reflect/Field;", "javaGetter", "Ljava/lang/reflect/Method;", "getJavaGetter", "(Lkotlin/reflect/KProperty;)Ljava/lang/reflect/Method;", "javaSetter", "Lkotlin/reflect/KMutableProperty;", "getJavaSetter", "(Lkotlin/reflect/KMutableProperty;)Ljava/lang/reflect/Method;", "javaMethod", "Lkotlin/reflect/KFunction;", "getJavaMethod", "(Lkotlin/reflect/KFunction;)Ljava/lang/reflect/Method;", "javaConstructor", "Ljava/lang/reflect/Constructor;", "T", "getJavaConstructor$annotations", "(Lkotlin/reflect/KFunction;)V", "getJavaConstructor", "(Lkotlin/reflect/KFunction;)Ljava/lang/reflect/Constructor;", "javaType", "Ljava/lang/reflect/Type;", "Lkotlin/reflect/KType;", "getJavaType", "(Lkotlin/reflect/KType;)Ljava/lang/reflect/Type;", "kotlinProperty", "getKotlinProperty", "(Ljava/lang/reflect/Field;)Lkotlin/reflect/KProperty;", "getKPackage", "Lkotlin/reflect/KDeclarationContainer;", "Ljava/lang/reflect/Member;", "kotlinFunction", "getKotlinFunction", "(Ljava/lang/reflect/Method;)Lkotlin/reflect/KFunction;", "findKFunction", "", "Lkotlin/reflect/KCallable;", "method", "findKProperty", "field", "", "(Ljava/lang/reflect/Constructor;)Lkotlin/reflect/KFunction;", "kotlin-reflection"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ReflectJvmMapping {

    /* JADX INFO: compiled from: ReflectJvmMapping.kt */
    @kotlin.Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader.Kind.values().length];
            try {
                iArr[kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader.Kind.FILE_FACADE.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                iArr[kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader.Kind.MULTIFILE_CLASS.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                iArr[kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader.Kind.MULTIFILE_CLASS_PART.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static /* synthetic */ void getJavaConstructor$annotations(kotlin.reflect.KFunction kFunction) {
    }

    public static final java.lang.reflect.Field getJavaField(kotlin.reflect.KProperty<?> kProperty) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kProperty, "<this>");
        kotlin.reflect.jvm.internal.KPropertyImpl<?> kPropertyImplAsKPropertyImpl = kotlin.reflect.jvm.internal.UtilKt.asKPropertyImpl(kProperty);
        if (kPropertyImplAsKPropertyImpl != null) {
            return kPropertyImplAsKPropertyImpl.getJavaField();
        }
        return null;
    }

    public static final java.lang.reflect.Method getJavaGetter(kotlin.reflect.KProperty<?> kProperty) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kProperty, "<this>");
        return getJavaMethod(kProperty.getGetter());
    }

    public static final java.lang.reflect.Method getJavaSetter(kotlin.reflect.KMutableProperty<?> kMutableProperty) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kMutableProperty, "<this>");
        return getJavaMethod(kMutableProperty.getSetter());
    }

    public static final java.lang.reflect.Method getJavaMethod(kotlin.reflect.KFunction<?> kFunction) {
        kotlin.reflect.jvm.internal.calls.Caller<?> caller;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kFunction, "<this>");
        kotlin.reflect.jvm.internal.KCallableImpl<?> kCallableImplAsKCallableImpl = kotlin.reflect.jvm.internal.UtilKt.asKCallableImpl(kFunction);
        java.lang.reflect.Member memberMo1823getMember = (kCallableImplAsKCallableImpl == null || (caller = kCallableImplAsKCallableImpl.getCaller()) == null) ? null : caller.mo1823getMember();
        if (memberMo1823getMember instanceof java.lang.reflect.Method) {
            return (java.lang.reflect.Method) memberMo1823getMember;
        }
        return null;
    }

    public static final <T> java.lang.reflect.Constructor<T> getJavaConstructor(kotlin.reflect.KFunction<? extends T> kFunction) {
        kotlin.reflect.jvm.internal.calls.Caller<?> caller;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kFunction, "<this>");
        kotlin.reflect.jvm.internal.KCallableImpl<?> kCallableImplAsKCallableImpl = kotlin.reflect.jvm.internal.UtilKt.asKCallableImpl(kFunction);
        java.lang.reflect.Member memberMo1823getMember = (kCallableImplAsKCallableImpl == null || (caller = kCallableImplAsKCallableImpl.getCaller()) == null) ? null : caller.mo1823getMember();
        if (memberMo1823getMember instanceof java.lang.reflect.Constructor) {
            return (java.lang.reflect.Constructor) memberMo1823getMember;
        }
        return null;
    }

    public static final java.lang.reflect.Type getJavaType(kotlin.reflect.KType kType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kType, "<this>");
        java.lang.reflect.Type javaType = ((kotlin.reflect.jvm.internal.KTypeImpl) kType).getJavaType();
        return javaType == null ? kotlin.reflect.TypesJVMKt.getJavaType(kType) : javaType;
    }

    public static final kotlin.reflect.KProperty<?> getKotlinProperty(java.lang.reflect.Field field) {
        kotlin.reflect.KProperty<?> kPropertyFindKProperty;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(field, "<this>");
        if (field.isSynthetic()) {
            return null;
        }
        if (java.lang.reflect.Modifier.isStatic(field.getModifiers())) {
            kotlin.reflect.KDeclarationContainer kPackage = getKPackage(field);
            if (kPackage != null) {
                return findKProperty(kPackage.getMembers(), field);
            }
            java.lang.Class<?> declaringClass = field.getDeclaringClass();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(declaringClass, "getDeclaringClass(...)");
            kotlin.reflect.KClass<?> companionObject = kotlin.reflect.full.KClasses.getCompanionObject(kotlin.jvm.JvmClassMappingKt.getKotlinClass(declaringClass));
            if (companionObject != null) {
                java.lang.Class<?> declaringClass2 = field.getDeclaringClass();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(declaringClass2, "getDeclaringClass(...)");
                java.lang.String name = field.getName();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                java.lang.reflect.Field declaredFieldOrNull = kotlin.reflect.jvm.internal.UtilKt.getDeclaredFieldOrNull(declaringClass2, name);
                if (declaredFieldOrNull != null && (kPropertyFindKProperty = findKProperty(kotlin.reflect.full.KClasses.getMemberProperties(companionObject), declaredFieldOrNull)) != null) {
                    return kPropertyFindKProperty;
                }
            }
        }
        java.lang.Class<?> declaringClass3 = field.getDeclaringClass();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(declaringClass3, "getDeclaringClass(...)");
        return findKProperty(kotlin.reflect.full.KClasses.getMemberProperties(kotlin.jvm.JvmClassMappingKt.getKotlinClass(declaringClass3)), field);
    }

    private static final kotlin.reflect.KDeclarationContainer getKPackage(java.lang.reflect.Member member) {
        kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader classHeader;
        kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass.Factory factory = kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass.Factory;
        java.lang.Class<?> declaringClass = member.getDeclaringClass();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(declaringClass, "getDeclaringClass(...)");
        kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass reflectKotlinClassCreate = factory.create(declaringClass);
        kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader.Kind kind = (reflectKotlinClassCreate == null || (classHeader = reflectKotlinClassCreate.getClassHeader()) == null) ? null : classHeader.getKind();
        int i = kind == null ? -1 : kotlin.reflect.jvm.ReflectJvmMapping.WhenMappings.$EnumSwitchMapping$0[kind.ordinal()];
        if (i != 1 && i != 2 && i != 3) {
            return null;
        }
        java.lang.Class<?> declaringClass2 = member.getDeclaringClass();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(declaringClass2, "getDeclaringClass(...)");
        return new kotlin.reflect.jvm.internal.KPackageImpl(declaringClass2);
    }

    public static final kotlin.reflect.KFunction<?> getKotlinFunction(java.lang.reflect.Method method) {
        kotlin.reflect.KFunction<?> kFunctionFindKFunction;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(method, "<this>");
        if (java.lang.reflect.Modifier.isStatic(method.getModifiers())) {
            kotlin.reflect.KDeclarationContainer kPackage = getKPackage(method);
            if (kPackage != null) {
                return findKFunction(kPackage.getMembers(), method);
            }
            java.lang.Class<?> declaringClass = method.getDeclaringClass();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(declaringClass, "getDeclaringClass(...)");
            kotlin.reflect.KClass<?> companionObject = kotlin.reflect.full.KClasses.getCompanionObject(kotlin.jvm.JvmClassMappingKt.getKotlinClass(declaringClass));
            if (companionObject != null) {
                java.lang.Class javaClass = kotlin.jvm.JvmClassMappingKt.getJavaClass((kotlin.reflect.KClass) companionObject);
                java.lang.String name = method.getName();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                java.lang.Class<?>[] parameterTypes = method.getParameterTypes();
                java.lang.reflect.Method declaredMethodOrNull = kotlin.reflect.jvm.internal.UtilKt.getDeclaredMethodOrNull(javaClass, name, (java.lang.Class[]) java.util.Arrays.copyOf(parameterTypes, parameterTypes.length));
                if (declaredMethodOrNull != null && (kFunctionFindKFunction = findKFunction(kotlin.reflect.full.KClasses.getFunctions(companionObject), declaredMethodOrNull)) != null) {
                    return kFunctionFindKFunction;
                }
            }
        }
        java.lang.Class<?> declaringClass2 = method.getDeclaringClass();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(declaringClass2, "getDeclaringClass(...)");
        return findKFunction(kotlin.reflect.full.KClasses.getFunctions(kotlin.jvm.JvmClassMappingKt.getKotlinClass(declaringClass2)), method);
    }

    private static final kotlin.reflect.KFunction<?> findKFunction(java.util.Collection<? extends kotlin.reflect.KCallable<?>> collection, java.lang.reflect.Method method) {
        for (kotlin.reflect.KCallable<?> kCallable : collection) {
            if (kCallable instanceof kotlin.reflect.KFunction) {
                kotlin.reflect.KFunction<?> kFunction = (kotlin.reflect.KFunction) kCallable;
                if (kotlin.jvm.internal.Intrinsics.areEqual(kFunction.getName(), method.getName()) && kotlin.jvm.internal.Intrinsics.areEqual(getJavaMethod(kFunction), method)) {
                    return kFunction;
                }
            }
        }
        for (kotlin.reflect.KCallable<?> kCallable2 : collection) {
            if (kCallable2 instanceof kotlin.reflect.KFunction) {
                kotlin.reflect.KFunction<?> kFunction2 = (kotlin.reflect.KFunction) kCallable2;
                if (!kotlin.jvm.internal.Intrinsics.areEqual(kFunction2.getName(), method.getName()) && kotlin.jvm.internal.Intrinsics.areEqual(getJavaMethod(kFunction2), method)) {
                    return kFunction2;
                }
            }
        }
        return null;
    }

    private static final kotlin.reflect.KProperty<?> findKProperty(java.util.Collection<? extends kotlin.reflect.KCallable<?>> collection, java.lang.reflect.Field field) {
        for (kotlin.reflect.KCallable<?> kCallable : collection) {
            if (kCallable instanceof kotlin.reflect.KProperty) {
                kotlin.reflect.KProperty<?> kProperty = (kotlin.reflect.KProperty) kCallable;
                if (kotlin.jvm.internal.Intrinsics.areEqual(kProperty.getName(), field.getName()) && kotlin.jvm.internal.Intrinsics.areEqual(getJavaField(kProperty), field)) {
                    return kProperty;
                }
            }
        }
        for (kotlin.reflect.KCallable<?> kCallable2 : collection) {
            if (kCallable2 instanceof kotlin.reflect.KProperty) {
                kotlin.reflect.KProperty<?> kProperty2 = (kotlin.reflect.KProperty) kCallable2;
                if (!kotlin.jvm.internal.Intrinsics.areEqual(kProperty2.getName(), field.getName()) && kotlin.jvm.internal.Intrinsics.areEqual(getJavaField(kProperty2), field)) {
                    return kProperty2;
                }
            }
        }
        return null;
    }

    public static final <T> kotlin.reflect.KFunction<T> getKotlinFunction(java.lang.reflect.Constructor<T> constructor) {
        T next;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(constructor, "<this>");
        java.lang.Class<T> declaringClass = constructor.getDeclaringClass();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(declaringClass, "getDeclaringClass(...)");
        java.util.Iterator<T> it = kotlin.jvm.JvmClassMappingKt.getKotlinClass(declaringClass).getConstructors().iterator();
        while (it.hasNext()) {
            next = it.next();
            if (kotlin.jvm.internal.Intrinsics.areEqual(getJavaConstructor((kotlin.reflect.KFunction) next), constructor)) {
                return (kotlin.reflect.KFunction) next;
            }
        }
        next = null;
        return (kotlin.reflect.KFunction) next;
    }
}
