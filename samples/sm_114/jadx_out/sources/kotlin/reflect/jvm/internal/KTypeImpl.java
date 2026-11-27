package kotlin.reflect.jvm.internal;

/* JADX INFO: compiled from: KTypeImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u001b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0015\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\u001dH\u0000¢\u0006\u0002\b$J\u0013\u0010%\u001a\u00020\u001d2\b\u0010&\u001a\u0004\u0018\u00010'H\u0096\u0002J\b\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020+H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\u0004\u0018\u00010\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u000f\u001a\u0004\u0018\u00010\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R!\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0014\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001eR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u001a¨\u0006,²\u0006\u0010\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00060\u0017X\u008a\u0084\u0002"}, d2 = {"Lkotlin/reflect/jvm/internal/KTypeImpl;", "Lkotlin/jvm/internal/KTypeBase;", "type", "Lkotlin/reflect/jvm/internal/impl/types/KotlinType;", "computeJavaType", "Lkotlin/Function0;", "Ljava/lang/reflect/Type;", "<init>", "(Lorg/jetbrains/kotlin/types/KotlinType;Lkotlin/jvm/functions/Function0;)V", "getType", "()Lorg/jetbrains/kotlin/types/KotlinType;", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "javaType", "getJavaType", "()Ljava/lang/reflect/Type;", "classifier", "Lkotlin/reflect/KClassifier;", "getClassifier", "()Lkotlin/reflect/KClassifier;", "classifier$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "convert", "arguments", "", "Lkotlin/reflect/KTypeProjection;", "getArguments", "()Ljava/util/List;", "arguments$delegate", "isMarkedNullable", "", "()Z", "annotations", "", "getAnnotations", "makeNullableAsSpecified", "nullable", "makeNullableAsSpecified$kotlin_reflection", "equals", "other", "", "hashCode", "", "toString", "", "kotlin-reflection", "parameterizedTypeArguments"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class KTypeImpl implements kotlin.jvm.internal.KTypeBase {
    static final /* synthetic */ kotlin.reflect.KProperty<java.lang.Object>[] $$delegatedProperties = {kotlin.jvm.internal.Reflection.property1(new kotlin.jvm.internal.PropertyReference1Impl(kotlin.reflect.jvm.internal.KTypeImpl.class, "classifier", "getClassifier()Lkotlin/reflect/KClassifier;", 0)), kotlin.jvm.internal.Reflection.property1(new kotlin.jvm.internal.PropertyReference1Impl(kotlin.reflect.jvm.internal.KTypeImpl.class, "arguments", "getArguments()Ljava/util/List;", 0))};

    /* JADX INFO: renamed from: arguments$delegate, reason: from kotlin metadata */
    private final kotlin.reflect.jvm.internal.ReflectProperties.LazySoftVal arguments;

    /* JADX INFO: renamed from: classifier$delegate, reason: from kotlin metadata */
    private final kotlin.reflect.jvm.internal.ReflectProperties.LazySoftVal classifier;
    private final kotlin.reflect.jvm.internal.ReflectProperties.LazySoftVal<java.lang.reflect.Type> computeJavaType;
    private final kotlin.reflect.jvm.internal.impl.types.KotlinType type;

    /* JADX INFO: compiled from: KTypeImpl.kt */
    @kotlin.Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[kotlin.reflect.jvm.internal.impl.types.Variance.values().length];
            try {
                iArr[kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                iArr[kotlin.reflect.jvm.internal.impl.types.Variance.IN_VARIANCE.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                iArr[kotlin.reflect.jvm.internal.impl.types.Variance.OUT_VARIANCE.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public KTypeImpl(kotlin.reflect.jvm.internal.impl.types.KotlinType type, final kotlin.jvm.functions.Function0<? extends java.lang.reflect.Type> function0) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
        kotlin.reflect.jvm.internal.ReflectProperties.LazySoftVal<java.lang.reflect.Type> lazySoftValLazySoft = null;
        kotlin.reflect.jvm.internal.ReflectProperties.LazySoftVal<java.lang.reflect.Type> lazySoftVal = function0 instanceof kotlin.reflect.jvm.internal.ReflectProperties.LazySoftVal ? (kotlin.reflect.jvm.internal.ReflectProperties.LazySoftVal) function0 : null;
        if (lazySoftVal != null) {
            lazySoftValLazySoft = lazySoftVal;
        } else if (function0 != null) {
            lazySoftValLazySoft = kotlin.reflect.jvm.internal.ReflectProperties.lazySoft(function0);
        }
        this.computeJavaType = lazySoftValLazySoft;
        this.classifier = kotlin.reflect.jvm.internal.ReflectProperties.lazySoft(new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.KTypeImpl$$Lambda$0
            private final kotlin.reflect.jvm.internal.KTypeImpl arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.KTypeImpl.classifier_delegate$lambda$0(this.arg$0);
            }
        });
        this.arguments = kotlin.reflect.jvm.internal.ReflectProperties.lazySoft(new kotlin.jvm.functions.Function0(this, function0) { // from class: kotlin.reflect.jvm.internal.KTypeImpl$$Lambda$1
            private final kotlin.reflect.jvm.internal.KTypeImpl arg$0;
            private final kotlin.jvm.functions.Function0 arg$1;

            {
                this.arg$0 = this;
                this.arg$1 = function0;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.KTypeImpl.arguments_delegate$lambda$5(this.arg$0, this.arg$1);
            }
        });
    }

    public /* synthetic */ KTypeImpl(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType, kotlin.jvm.functions.Function0 function0, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(kotlinType, (i & 2) != 0 ? null : function0);
    }

    public final kotlin.reflect.jvm.internal.impl.types.KotlinType getType() {
        return this.type;
    }

    @Override // kotlin.jvm.internal.KTypeBase
    public java.lang.reflect.Type getJavaType() {
        kotlin.reflect.jvm.internal.ReflectProperties.LazySoftVal<java.lang.reflect.Type> lazySoftVal = this.computeJavaType;
        if (lazySoftVal != null) {
            return lazySoftVal.invoke();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.KClassifier classifier_delegate$lambda$0(kotlin.reflect.jvm.internal.KTypeImpl kTypeImpl) {
        return kTypeImpl.convert(kTypeImpl.type);
    }

    @Override // kotlin.reflect.KType
    public kotlin.reflect.KClassifier getClassifier() {
        return (kotlin.reflect.KClassifier) this.classifier.getValue(this, $$delegatedProperties[0]);
    }

    private final kotlin.reflect.KClassifier convert(kotlin.reflect.jvm.internal.impl.types.KotlinType type) {
        kotlin.reflect.jvm.internal.impl.types.KotlinType type2;
        kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptorMo1835getDeclarationDescriptor = type.getConstructor().mo1835getDeclarationDescriptor();
        if (classifierDescriptorMo1835getDeclarationDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) {
            java.lang.Class<?> javaClass = kotlin.reflect.jvm.internal.UtilKt.toJavaClass((kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) classifierDescriptorMo1835getDeclarationDescriptor);
            if (javaClass == null) {
                return null;
            }
            if (javaClass.isArray()) {
                kotlin.reflect.jvm.internal.impl.types.TypeProjection typeProjection = (kotlin.reflect.jvm.internal.impl.types.TypeProjection) kotlin.collections.CollectionsKt.singleOrNull((java.util.List) type.getArguments());
                if (typeProjection == null || (type2 = typeProjection.getType()) == null) {
                    return new kotlin.reflect.jvm.internal.KClassImpl(javaClass);
                }
                kotlin.reflect.KClassifier kClassifierConvert = convert(type2);
                if (kClassifierConvert == null) {
                    throw new kotlin.reflect.jvm.internal.KotlinReflectionInternalError("Cannot determine classifier for array element type: " + this);
                }
                return new kotlin.reflect.jvm.internal.KClassImpl(kotlin.reflect.jvm.internal.UtilKt.createArrayType(kotlin.jvm.JvmClassMappingKt.getJavaClass((kotlin.reflect.KClass) kotlin.reflect.jvm.KTypesJvm.getJvmErasure(kClassifierConvert))));
            }
            if (!kotlin.reflect.jvm.internal.impl.types.TypeUtils.isNullableType(type)) {
                java.lang.Class<?> primitiveByWrapper = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt.getPrimitiveByWrapper(javaClass);
                if (primitiveByWrapper != null) {
                    javaClass = primitiveByWrapper;
                }
                return new kotlin.reflect.jvm.internal.KClassImpl(javaClass);
            }
            return new kotlin.reflect.jvm.internal.KClassImpl(javaClass);
        }
        if (classifierDescriptorMo1835getDeclarationDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) {
            return new kotlin.reflect.jvm.internal.KTypeParameterImpl(null, (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) classifierDescriptorMo1835getDeclarationDescriptor);
        }
        if (classifierDescriptorMo1835getDeclarationDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor) {
            throw new kotlin.NotImplementedError("An operation is not implemented: Type alias classifiers are not yet supported");
        }
        return null;
    }

    @Override // kotlin.reflect.KType
    public java.util.List<kotlin.reflect.KTypeProjection> getArguments() {
        T value = this.arguments.getValue(this, $$delegatedProperties[1]);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (java.util.List) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.util.List arguments_delegate$lambda$5(final kotlin.reflect.jvm.internal.KTypeImpl kTypeImpl, kotlin.jvm.functions.Function0 function0) {
        kotlin.reflect.KTypeProjection kTypeProjectionInvariant;
        java.util.List<kotlin.reflect.jvm.internal.impl.types.TypeProjection> arguments = kTypeImpl.type.getArguments();
        if (arguments.isEmpty()) {
            return kotlin.collections.CollectionsKt.emptyList();
        }
        final kotlin.Lazy lazy = kotlin.LazyKt.lazy(kotlin.LazyThreadSafetyMode.PUBLICATION, new kotlin.jvm.functions.Function0(kTypeImpl) { // from class: kotlin.reflect.jvm.internal.KTypeImpl$$Lambda$2
            private final kotlin.reflect.jvm.internal.KTypeImpl arg$0;

            {
                this.arg$0 = kTypeImpl;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.KTypeImpl.arguments_delegate$lambda$5$lambda$1(this.arg$0);
            }
        });
        java.util.List<kotlin.reflect.jvm.internal.impl.types.TypeProjection> list = arguments;
        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(list, 10));
        final int i = 0;
        for (java.lang.Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                kotlin.collections.CollectionsKt.throwIndexOverflow();
            }
            kotlin.reflect.jvm.internal.impl.types.TypeProjection typeProjection = (kotlin.reflect.jvm.internal.impl.types.TypeProjection) obj;
            if (typeProjection.isStarProjection()) {
                kTypeProjectionInvariant = kotlin.reflect.KTypeProjection.INSTANCE.getSTAR();
            } else {
                kotlin.reflect.jvm.internal.impl.types.KotlinType type = typeProjection.getType();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
                kotlin.reflect.jvm.internal.KTypeImpl kTypeImpl2 = new kotlin.reflect.jvm.internal.KTypeImpl(type, function0 == null ? null : new kotlin.jvm.functions.Function0(kTypeImpl, i, lazy) { // from class: kotlin.reflect.jvm.internal.KTypeImpl$$Lambda$3
                    private final kotlin.reflect.jvm.internal.KTypeImpl arg$0;
                    private final int arg$1;
                    private final kotlin.Lazy arg$2;

                    {
                        this.arg$0 = kTypeImpl;
                        this.arg$1 = i;
                        this.arg$2 = lazy;
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public java.lang.Object invoke() {
                        return kotlin.reflect.jvm.internal.KTypeImpl.arguments_delegate$lambda$5$lambda$4$lambda$3(this.arg$0, this.arg$1, this.arg$2);
                    }
                });
                int i3 = kotlin.reflect.jvm.internal.KTypeImpl.WhenMappings.$EnumSwitchMapping$0[typeProjection.getProjectionKind().ordinal()];
                if (i3 == 1) {
                    kTypeProjectionInvariant = kotlin.reflect.KTypeProjection.INSTANCE.invariant(kTypeImpl2);
                } else if (i3 == 2) {
                    kTypeProjectionInvariant = kotlin.reflect.KTypeProjection.INSTANCE.contravariant(kTypeImpl2);
                } else {
                    if (i3 != 3) {
                        throw new kotlin.NoWhenBranchMatchedException();
                    }
                    kTypeProjectionInvariant = kotlin.reflect.KTypeProjection.INSTANCE.covariant(kTypeImpl2);
                }
            }
            arrayList.add(kTypeProjectionInvariant);
            i = i2;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.util.List arguments_delegate$lambda$5$lambda$1(kotlin.reflect.jvm.internal.KTypeImpl kTypeImpl) {
        java.lang.reflect.Type javaType = kTypeImpl.getJavaType();
        kotlin.jvm.internal.Intrinsics.checkNotNull(javaType);
        return kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt.getParameterizedTypeArguments(javaType);
    }

    private static final java.util.List<java.lang.reflect.Type> arguments_delegate$lambda$5$lambda$2(kotlin.Lazy<? extends java.util.List<? extends java.lang.reflect.Type>> lazy) {
        return (java.util.List) lazy.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.lang.reflect.Type arguments_delegate$lambda$5$lambda$4$lambda$3(kotlin.reflect.jvm.internal.KTypeImpl kTypeImpl, int i, kotlin.Lazy<? extends java.util.List<? extends java.lang.reflect.Type>> lazy) {
        java.lang.reflect.Type javaType = kTypeImpl.getJavaType();
        if (javaType instanceof java.lang.Class) {
            java.lang.Class cls = (java.lang.Class) javaType;
            java.lang.Class<?> componentType = cls.isArray() ? cls.getComponentType() : java.lang.Object.class;
            kotlin.jvm.internal.Intrinsics.checkNotNull(componentType);
            return componentType;
        }
        if (javaType instanceof java.lang.reflect.GenericArrayType) {
            if (i != 0) {
                throw new kotlin.reflect.jvm.internal.KotlinReflectionInternalError("Array type has been queried for a non-0th argument: " + kTypeImpl);
            }
            java.lang.reflect.Type genericComponentType = ((java.lang.reflect.GenericArrayType) javaType).getGenericComponentType();
            kotlin.jvm.internal.Intrinsics.checkNotNull(genericComponentType);
            return genericComponentType;
        }
        if (javaType instanceof java.lang.reflect.ParameterizedType) {
            java.lang.reflect.Type type = arguments_delegate$lambda$5$lambda$2(lazy).get(i);
            if (!(type instanceof java.lang.reflect.WildcardType)) {
                return type;
            }
            java.lang.reflect.WildcardType wildcardType = (java.lang.reflect.WildcardType) type;
            java.lang.reflect.Type[] lowerBounds = wildcardType.getLowerBounds();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(lowerBounds, "getLowerBounds(...)");
            java.lang.reflect.Type type2 = (java.lang.reflect.Type) kotlin.collections.ArraysKt.firstOrNull(lowerBounds);
            if (type2 == null) {
                java.lang.reflect.Type[] upperBounds = wildcardType.getUpperBounds();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(upperBounds, "getUpperBounds(...)");
                type2 = (java.lang.reflect.Type) kotlin.collections.ArraysKt.first(upperBounds);
            }
            kotlin.jvm.internal.Intrinsics.checkNotNull(type2);
            return type2;
        }
        throw new kotlin.reflect.jvm.internal.KotlinReflectionInternalError("Non-generic type has been queried for arguments: " + kTypeImpl);
    }

    @Override // kotlin.reflect.KType
    public boolean isMarkedNullable() {
        return this.type.isMarkedNullable();
    }

    @Override // kotlin.reflect.KAnnotatedElement
    public java.util.List<java.lang.annotation.Annotation> getAnnotations() {
        return kotlin.reflect.jvm.internal.UtilKt.computeAnnotations(this.type);
    }

    public final kotlin.reflect.jvm.internal.KTypeImpl makeNullableAsSpecified$kotlin_reflection(boolean nullable) {
        if (!kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt.isFlexible(this.type) && isMarkedNullable() == nullable) {
            return this;
        }
        kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinTypeMakeNullableAsSpecified = kotlin.reflect.jvm.internal.impl.types.TypeUtils.makeNullableAsSpecified(this.type, nullable);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(kotlinTypeMakeNullableAsSpecified, "makeNullableAsSpecified(...)");
        return new kotlin.reflect.jvm.internal.KTypeImpl(kotlinTypeMakeNullableAsSpecified, this.computeJavaType);
    }

    public boolean equals(java.lang.Object other) {
        if (!(other instanceof kotlin.reflect.jvm.internal.KTypeImpl)) {
            return false;
        }
        kotlin.reflect.jvm.internal.KTypeImpl kTypeImpl = (kotlin.reflect.jvm.internal.KTypeImpl) other;
        return kotlin.jvm.internal.Intrinsics.areEqual(this.type, kTypeImpl.type) && kotlin.jvm.internal.Intrinsics.areEqual(getClassifier(), kTypeImpl.getClassifier()) && kotlin.jvm.internal.Intrinsics.areEqual(getArguments(), kTypeImpl.getArguments());
    }

    public int hashCode() {
        int iHashCode = this.type.hashCode() * 31;
        kotlin.reflect.KClassifier classifier = getClassifier();
        return ((iHashCode + (classifier != null ? classifier.hashCode() : 0)) * 31) + getArguments().hashCode();
    }

    public java.lang.String toString() {
        return kotlin.reflect.jvm.internal.ReflectionObjectRenderer.INSTANCE.renderType(this.type);
    }
}
