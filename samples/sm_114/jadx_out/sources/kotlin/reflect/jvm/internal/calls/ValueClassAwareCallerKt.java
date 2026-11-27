package kotlin.reflect.jvm.internal.calls;

/* JADX INFO: compiled from: ValueClassAwareCaller.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000l\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a \u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002\u001a\u0018\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a(\u0010\u000b\u001a\u00020\f*\u0006\u0012\u0002\b\u00030\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002\u001a9\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00042\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00110\u0017¢\u0006\u0002\b\u0019H\u0002\u001a\f\u0010\u001a\u001a\u00020\u0011*\u00020\u0015H\u0002\u001a6\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u001c0\r\"\n\b\u0000\u0010\u001c*\u0004\u0018\u00010\u0015*\b\u0012\u0004\u0012\u0002H\u001c0\r2\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0000\u001a\f\u0010\u001d\u001a\u00020\u0011*\u00020\tH\u0002\u001a\u0018\u0010\u001e\u001a\u00020\u0005*\u0006\u0012\u0002\b\u00030\u001f2\u0006\u0010\b\u001a\u00020\tH\u0000\u001a\u0018\u0010 \u001a\u00020\u0005*\u0006\u0012\u0002\b\u00030\u001f2\u0006\u0010\b\u001a\u00020\tH\u0002\u001a\u0012\u0010!\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001f*\u00020\u0013H\u0002\u001a\u0014\u0010!\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001f*\u0004\u0018\u00010\"H\u0000\u001a\u0018\u0010&\u001a\u0004\u0018\u00010'*\u0004\u0018\u00010'2\u0006\u0010\b\u001a\u00020\tH\u0000\"\u001a\u0010#\u001a\u0004\u0018\u00010\u0013*\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%¨\u0006("}, d2 = {"toJvmDescriptor", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassifierDescriptor;", "getValueClassUnboxMethods", "", "Ljava/lang/reflect/Method;", "type", "Lkotlin/reflect/jvm/internal/impl/types/SimpleType;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "getMfvcUnboxMethods", "checkParametersSize", "", "Lkotlin/reflect/jvm/internal/calls/Caller;", "expectedArgsSize", "", "isDefault", "", "makeKotlinParameterTypes", "Lkotlin/reflect/jvm/internal/impl/types/KotlinType;", "member", "Ljava/lang/reflect/Member;", "isSpecificClass", "Lkotlin/Function1;", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "Lkotlin/ExtensionFunctionType;", "acceptsBoxedReceiverParameter", "createValueClassAwareCallerIfNeeded", "M", "hasValueClassReceiver", "getInlineClassUnboxMethod", "Ljava/lang/Class;", "getBoxMethod", "toInlineClass", "Lkotlin/reflect/jvm/internal/impl/descriptors/DeclarationDescriptor;", "expectedReceiverType", "getExpectedReceiverType", "(Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;)Lorg/jetbrains/kotlin/types/KotlinType;", "coerceToExpectedReceiverType", "", "kotlin-reflection"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ValueClassAwareCallerKt {
    public static final java.lang.String toJvmDescriptor(kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptor) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(classifierDescriptor, "<this>");
        kotlin.reflect.jvm.internal.impl.name.ClassId classId = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getClassId(classifierDescriptor);
        kotlin.jvm.internal.Intrinsics.checkNotNull(classId);
        return kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.ClassMapperLite.mapClass(classId.asString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.util.List<java.lang.reflect.Method> getValueClassUnboxMethods(kotlin.reflect.jvm.internal.impl.types.SimpleType simpleType, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor callableMemberDescriptor) {
        java.lang.reflect.Method inlineClassUnboxMethod;
        java.util.List<java.lang.reflect.Method> mfvcUnboxMethods = getMfvcUnboxMethods(simpleType);
        if (mfvcUnboxMethods != null) {
            return mfvcUnboxMethods;
        }
        java.lang.Class<?> inlineClass = toInlineClass(simpleType);
        if (inlineClass == null || (inlineClassUnboxMethod = getInlineClassUnboxMethod(inlineClass, callableMemberDescriptor)) == null) {
            return null;
        }
        return kotlin.collections.CollectionsKt.listOf(inlineClassUnboxMethod);
    }

    private static final java.util.List<java.lang.String> getMfvcUnboxMethods$getUnboxMethodNameSuffixes(kotlin.reflect.jvm.internal.impl.types.SimpleType simpleType) {
        java.util.ArrayList arrayListListOf;
        if (!kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt.needsMfvcFlattening(simpleType)) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptorMo1835getDeclarationDescriptor = simpleType.getConstructor().mo1835getDeclarationDescriptor();
        kotlin.jvm.internal.Intrinsics.checkNotNull(classifierDescriptorMo1835getDeclarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        kotlin.reflect.jvm.internal.impl.descriptors.MultiFieldValueClassRepresentation<kotlin.reflect.jvm.internal.impl.types.SimpleType> multiFieldValueClassRepresentation = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getMultiFieldValueClassRepresentation((kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) classifierDescriptorMo1835getDeclarationDescriptor);
        kotlin.jvm.internal.Intrinsics.checkNotNull(multiFieldValueClassRepresentation);
        java.lang.Iterable<kotlin.Pair> underlyingPropertyNamesToTypes = multiFieldValueClassRepresentation.getUnderlyingPropertyNamesToTypes();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (kotlin.Pair pair : underlyingPropertyNamesToTypes) {
            kotlin.reflect.jvm.internal.impl.name.Name name = (kotlin.reflect.jvm.internal.impl.name.Name) pair.component1();
            java.util.List<java.lang.String> mfvcUnboxMethods$getUnboxMethodNameSuffixes = getMfvcUnboxMethods$getUnboxMethodNameSuffixes((kotlin.reflect.jvm.internal.impl.types.SimpleType) pair.component2());
            if (mfvcUnboxMethods$getUnboxMethodNameSuffixes == null) {
                arrayListListOf = kotlin.collections.CollectionsKt.listOf(name.getIdentifier());
            } else {
                java.util.List<java.lang.String> list = mfvcUnboxMethods$getUnboxMethodNameSuffixes;
                java.util.ArrayList arrayList2 = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(list, 10));
                java.util.Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList2.add(name.getIdentifier() + '-' + ((java.lang.String) it.next()));
                }
                arrayListListOf = arrayList2;
            }
            kotlin.collections.CollectionsKt.addAll(arrayList, arrayListListOf);
        }
        return arrayList;
    }

    public static final java.util.List<java.lang.reflect.Method> getMfvcUnboxMethods(kotlin.reflect.jvm.internal.impl.types.SimpleType type) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(type, "type");
        java.util.List<java.lang.String> mfvcUnboxMethods$getUnboxMethodNameSuffixes = getMfvcUnboxMethods$getUnboxMethodNameSuffixes(kotlin.reflect.jvm.internal.impl.types.TypeSubstitutionKt.asSimpleType(type));
        if (mfvcUnboxMethods$getUnboxMethodNameSuffixes == null) {
            return null;
        }
        java.util.List<java.lang.String> list = mfvcUnboxMethods$getUnboxMethodNameSuffixes;
        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(list, 10));
        java.util.Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add("unbox-impl-" + ((java.lang.String) it.next()));
        }
        kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptorMo1835getDeclarationDescriptor = type.getConstructor().mo1835getDeclarationDescriptor();
        kotlin.jvm.internal.Intrinsics.checkNotNull(classifierDescriptorMo1835getDeclarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        java.lang.Class<?> javaClass = kotlin.reflect.jvm.internal.UtilKt.toJavaClass((kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) classifierDescriptorMo1835getDeclarationDescriptor);
        kotlin.jvm.internal.Intrinsics.checkNotNull(javaClass);
        java.util.ArrayList arrayList2 = arrayList;
        java.util.ArrayList arrayList3 = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        java.util.Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            arrayList3.add(javaClass.getDeclaredMethod((java.lang.String) it2.next(), null));
        }
        return arrayList3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkParametersSize(kotlin.reflect.jvm.internal.calls.Caller<?> caller, int i, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor callableMemberDescriptor, boolean z) {
        if (kotlin.reflect.jvm.internal.calls.CallerKt.getArity(caller) == i) {
            return;
        }
        throw new kotlin.reflect.jvm.internal.KotlinReflectionInternalError("Inconsistent number of parameters in the descriptor and Java reflection object: " + kotlin.reflect.jvm.internal.calls.CallerKt.getArity(caller) + " != " + i + "\nCalling: " + callableMemberDescriptor + "\nParameter types: " + caller.getParameterTypes() + ")\nDefault: " + z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.util.List<kotlin.reflect.jvm.internal.impl.types.KotlinType> makeKotlinParameterTypes(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor callableMemberDescriptor, java.lang.reflect.Member member, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, java.lang.Boolean> function1) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor extensionReceiverParameter = callableMemberDescriptor.getExtensionReceiverParameter();
        kotlin.reflect.jvm.internal.impl.types.KotlinType type = extensionReceiverParameter != null ? extensionReceiverParameter.getType() : null;
        if (type != null) {
            arrayList.add(type);
        } else if (callableMemberDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor) {
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor constructedClass = ((kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor) callableMemberDescriptor).getConstructedClass();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(constructedClass, "getConstructedClass(...)");
            if (constructedClass.isInner()) {
                kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor containingDeclaration = constructedClass.getContainingDeclaration();
                kotlin.jvm.internal.Intrinsics.checkNotNull(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                arrayList.add(((kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) containingDeclaration).getDefaultType());
            }
        } else {
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor containingDeclaration2 = callableMemberDescriptor.getContainingDeclaration();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(containingDeclaration2, "getContainingDeclaration(...)");
            if ((containingDeclaration2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) && function1.invoke2(containingDeclaration2).booleanValue()) {
                if (member != null && acceptsBoxedReceiverParameter(member)) {
                    kotlin.reflect.jvm.internal.impl.types.SimpleType defaultType = ((kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) containingDeclaration2).getDefaultType();
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(defaultType, "getDefaultType(...)");
                    arrayList.add(kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.makeNullable(defaultType));
                } else {
                    arrayList.add(((kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) containingDeclaration2).getDefaultType());
                }
            }
        }
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> valueParameters = callableMemberDescriptor.getValueParameters();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(valueParameters, "getValueParameters(...)");
        java.util.Iterator<T> it = valueParameters.iterator();
        while (it.hasNext()) {
            arrayList.add(((kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) it.next()).getType());
        }
        return arrayList;
    }

    private static final boolean acceptsBoxedReceiverParameter(java.lang.reflect.Member member) {
        java.lang.Class<?> declaringClass = member.getDeclaringClass();
        if (declaringClass == null) {
            return false;
        }
        return !kotlin.jvm.JvmClassMappingKt.getKotlinClass(declaringClass).isValue();
    }

    public static /* synthetic */ kotlin.reflect.jvm.internal.calls.Caller createValueClassAwareCallerIfNeeded$default(kotlin.reflect.jvm.internal.calls.Caller caller, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor callableMemberDescriptor, boolean z, int i, java.lang.Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return createValueClassAwareCallerIfNeeded(caller, callableMemberDescriptor, z);
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0065  */
    /* JADX WARN: Code duplicated, block: B:23:0x006f  */
    /* JADX WARN: Code duplicated, block: B:28:0x0089  */
    /* JADX WARN: Code duplicated, block: B:31:0x0091  */
    /* JADX WARN: Code duplicated, block: B:38:0x0099 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:39:? A[LOOP:0: B:21:0x0069->B:39:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <M extends java.lang.reflect.Member> kotlin.reflect.jvm.internal.calls.Caller<M> createValueClassAwareCallerIfNeeded(kotlin.reflect.jvm.internal.calls.Caller<? extends M> caller, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor descriptor, boolean z) {
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> list;
        java.util.Iterator<T> it;
        kotlin.reflect.jvm.internal.impl.types.KotlinType type;
        kotlin.reflect.jvm.internal.impl.types.KotlinType returnType;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(caller, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (!kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt.isGetterOfUnderlyingPropertyOfValueClass(descriptor)) {
            java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor> contextReceiverParameters = descriptor.getContextReceiverParameters();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(contextReceiverParameters, "getContextReceiverParameters(...)");
            java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor> list2 = contextReceiverParameters;
            if ((list2 instanceof java.util.Collection) && list2.isEmpty()) {
                java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> valueParameters = descriptor.getValueParameters();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(valueParameters, "getValueParameters(...)");
                list = valueParameters;
                if (!(list instanceof java.util.Collection)) {
                    it = list.iterator();
                    while (it.hasNext()) {
                        type = ((kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) it.next()).getType();
                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
                        if (kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt.isValueClassType(type)) {
                        }
                    }
                    returnType = descriptor.getReturnType();
                    if (returnType != null) {
                    }
                }
                it = list.iterator();
                while (it.hasNext()) {
                    type = ((kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) it.next()).getType();
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
                    if (kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt.isValueClassType(type)) {
                    }
                }
                returnType = descriptor.getReturnType();
                if (returnType != null) {
                }
            }
            java.util.Iterator<T> it2 = list2.iterator();
            while (it2.hasNext()) {
                kotlin.reflect.jvm.internal.impl.types.KotlinType type2 = ((kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor) it2.next()).getType();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(type2, "getType(...)");
                if (kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt.isValueClassType(type2)) {
                }
            }
            java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> valueParameters2 = descriptor.getValueParameters();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(valueParameters2, "getValueParameters(...)");
            list = valueParameters2;
            if (!(list instanceof java.util.Collection) && list.isEmpty()) {
                returnType = descriptor.getReturnType();
                return returnType != null ? caller : caller;
            }
            it = list.iterator();
            while (it.hasNext()) {
                type = ((kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) it.next()).getType();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
                if (kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt.isValueClassType(type)) {
                }
            }
            returnType = descriptor.getReturnType();
            if ((returnType != null || !kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt.isInlineClassType(returnType)) && !hasValueClassReceiver(descriptor)) {
            }
        }
        return new kotlin.reflect.jvm.internal.calls.ValueClassAwareCaller(descriptor, caller, z);
    }

    private static final boolean hasValueClassReceiver(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor callableMemberDescriptor) {
        kotlin.reflect.jvm.internal.impl.types.KotlinType expectedReceiverType = getExpectedReceiverType(callableMemberDescriptor);
        return expectedReceiverType != null && kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt.isValueClassType(expectedReceiverType);
    }

    public static final java.lang.reflect.Method getInlineClassUnboxMethod(java.lang.Class<?> cls, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor descriptor) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(cls, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        try {
            java.lang.reflect.Method declaredMethod = cls.getDeclaredMethod("unbox-impl", null);
            kotlin.jvm.internal.Intrinsics.checkNotNull(declaredMethod);
            return declaredMethod;
        } catch (java.lang.NoSuchMethodException unused) {
            throw new kotlin.reflect.jvm.internal.KotlinReflectionInternalError("No unbox method found in inline class: " + cls + " (calling " + descriptor + com.taobao.weex.el.parse.Operators.BRACKET_END);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.lang.reflect.Method getBoxMethod(java.lang.Class<?> cls, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor callableMemberDescriptor) {
        try {
            java.lang.reflect.Method declaredMethod = cls.getDeclaredMethod("box-impl", getInlineClassUnboxMethod(cls, callableMemberDescriptor).getReturnType());
            kotlin.jvm.internal.Intrinsics.checkNotNull(declaredMethod);
            return declaredMethod;
        } catch (java.lang.NoSuchMethodException unused) {
            throw new kotlin.reflect.jvm.internal.KotlinReflectionInternalError("No box method found in inline class: " + cls + " (calling " + callableMemberDescriptor + com.taobao.weex.el.parse.Operators.BRACKET_END);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.lang.Class<?> toInlineClass(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinTypeUnsubstitutedUnderlyingType;
        java.lang.Class<?> inlineClass = toInlineClass(kotlinType.getConstructor().mo1835getDeclarationDescriptor());
        if (inlineClass == null) {
            return null;
        }
        if (kotlin.reflect.jvm.internal.impl.types.TypeUtils.isNullableType(kotlinType) && ((kotlinTypeUnsubstitutedUnderlyingType = kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt.unsubstitutedUnderlyingType(kotlinType)) == null || kotlin.reflect.jvm.internal.impl.types.TypeUtils.isNullableType(kotlinTypeUnsubstitutedUnderlyingType) || kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isPrimitiveType(kotlinTypeUnsubstitutedUnderlyingType))) {
            return null;
        }
        return inlineClass;
    }

    public static final java.lang.Class<?> toInlineClass(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor) {
        if (!(declarationDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) || !kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt.isInlineClass(declarationDescriptor)) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) declarationDescriptor;
        java.lang.Class<?> javaClass = kotlin.reflect.jvm.internal.UtilKt.toJavaClass(classDescriptor);
        if (javaClass != null) {
            return javaClass;
        }
        throw new kotlin.reflect.jvm.internal.KotlinReflectionInternalError("Class object for the class " + classDescriptor.getName() + " cannot be found (classId=" + kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getClassId((kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor) declarationDescriptor) + com.taobao.weex.el.parse.Operators.BRACKET_END);
    }

    private static final kotlin.reflect.jvm.internal.impl.types.KotlinType getExpectedReceiverType(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor callableMemberDescriptor) {
        kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor extensionReceiverParameter = callableMemberDescriptor.getExtensionReceiverParameter();
        kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor dispatchReceiverParameter = callableMemberDescriptor.getDispatchReceiverParameter();
        if (extensionReceiverParameter != null) {
            return extensionReceiverParameter.getType();
        }
        if (dispatchReceiverParameter == null) {
            return null;
        }
        if (callableMemberDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor) {
            return dispatchReceiverParameter.getType();
        }
        kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor containingDeclaration = callableMemberDescriptor.getContainingDeclaration();
        kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor = containingDeclaration instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor ? (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) containingDeclaration : null;
        return classDescriptor != null ? classDescriptor.getDefaultType() : null;
    }

    public static final java.lang.Object coerceToExpectedReceiverType(java.lang.Object obj, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor descriptor) {
        kotlin.reflect.jvm.internal.impl.types.KotlinType expectedReceiverType;
        java.lang.Class<?> inlineClass;
        java.lang.reflect.Method inlineClassUnboxMethod;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return (((descriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor) && kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt.isUnderlyingPropertyOfInlineClass((kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor) descriptor)) || (expectedReceiverType = getExpectedReceiverType(descriptor)) == null || (inlineClass = toInlineClass(expectedReceiverType)) == null || (inlineClassUnboxMethod = getInlineClassUnboxMethod(inlineClass, descriptor)) == null) ? obj : inlineClassUnboxMethod.invoke(obj, null);
    }
}
