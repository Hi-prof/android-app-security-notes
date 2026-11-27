package kotlin.reflect.jvm.internal;

/* JADX INFO: compiled from: KTypeParameterImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u001d\u001a\u0006\u0012\u0002\b\u00030\u001e*\u00020\u001fH\u0002J\u0010\u0010 \u001a\u0006\u0012\u0002\b\u00030!*\u00020\"H\u0002J\u0013\u0010#\u001a\u00020\u001b2\b\u0010$\u001a\u0004\u0018\u00010%H\u0096\u0002J\b\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020\fH\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR!\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001cR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "Lkotlin/reflect/KTypeParameter;", "Lkotlin/reflect/jvm/internal/KClassifierImpl;", com.taobao.weex.ui.component.WXBasicComponentType.CONTAINER, "Lkotlin/reflect/jvm/internal/KTypeParameterOwnerImpl;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/TypeParameterDescriptor;", "<init>", "(Lkotlin/reflect/jvm/internal/KTypeParameterOwnerImpl;Lorg/jetbrains/kotlin/descriptors/TypeParameterDescriptor;)V", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/TypeParameterDescriptor;", "name", "", "getName", "()Ljava/lang/String;", "upperBounds", "", "Lkotlin/reflect/KType;", "getUpperBounds", "()Ljava/util/List;", "upperBounds$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "variance", "Lkotlin/reflect/KVariance;", "getVariance", "()Lkotlin/reflect/KVariance;", "isReified", "", "()Z", "toKClassImpl", "Lkotlin/reflect/jvm/internal/KClassImpl;", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "getContainerClass", "Ljava/lang/Class;", "Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/descriptors/DeserializedMemberDescriptor;", "equals", "other", "", "hashCode", "", "toString", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class KTypeParameterImpl implements kotlin.reflect.KTypeParameter, kotlin.reflect.jvm.internal.KClassifierImpl {
    static final /* synthetic */ kotlin.reflect.KProperty<java.lang.Object>[] $$delegatedProperties = {kotlin.jvm.internal.Reflection.property1(new kotlin.jvm.internal.PropertyReference1Impl(kotlin.reflect.jvm.internal.KTypeParameterImpl.class, "upperBounds", "getUpperBounds()Ljava/util/List;", 0))};
    private final kotlin.reflect.jvm.internal.KTypeParameterOwnerImpl container;
    private final kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor descriptor;

    /* JADX INFO: renamed from: upperBounds$delegate, reason: from kotlin metadata */
    private final kotlin.reflect.jvm.internal.ReflectProperties.LazySoftVal upperBounds;

    /* JADX INFO: compiled from: KTypeParameterImpl.kt */
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

    public KTypeParameterImpl(kotlin.reflect.jvm.internal.KTypeParameterOwnerImpl kTypeParameterOwnerImpl, kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor descriptor) {
        kotlin.reflect.jvm.internal.KClassImpl<?> kClassImpl;
        java.lang.Object objAccept;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        this.descriptor = descriptor;
        this.upperBounds = kotlin.reflect.jvm.internal.ReflectProperties.lazySoft(new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.KTypeParameterImpl$$Lambda$0
            private final kotlin.reflect.jvm.internal.KTypeParameterImpl arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.KTypeParameterImpl.upperBounds_delegate$lambda$1(this.arg$0);
            }
        });
        if (kTypeParameterOwnerImpl == null) {
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor containingDeclaration = getDescriptor().getContainingDeclaration();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(containingDeclaration, "getContainingDeclaration(...)");
            if (containingDeclaration instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) {
                objAccept = toKClassImpl((kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) containingDeclaration);
            } else if (containingDeclaration instanceof kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) {
                kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor containingDeclaration2 = ((kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) containingDeclaration).getContainingDeclaration();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(containingDeclaration2, "getContainingDeclaration(...)");
                if (containingDeclaration2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) {
                    kClassImpl = toKClassImpl((kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) containingDeclaration2);
                } else {
                    kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor deserializedMemberDescriptor = containingDeclaration instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor ? (kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor) containingDeclaration : null;
                    if (deserializedMemberDescriptor == null) {
                        throw new kotlin.reflect.jvm.internal.KotlinReflectionInternalError("Non-class callable descriptor must be deserialized: " + containingDeclaration);
                    }
                    kotlin.reflect.KClass kotlinClass = kotlin.jvm.JvmClassMappingKt.getKotlinClass(getContainerClass(deserializedMemberDescriptor));
                    kotlin.jvm.internal.Intrinsics.checkNotNull(kotlinClass, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<*>");
                    kClassImpl = (kotlin.reflect.jvm.internal.KClassImpl) kotlinClass;
                }
                objAccept = containingDeclaration.accept(new kotlin.reflect.jvm.internal.CreateKCallableVisitor(kClassImpl), kotlin.Unit.INSTANCE);
            } else {
                throw new kotlin.reflect.jvm.internal.KotlinReflectionInternalError("Unknown type parameter container: " + containingDeclaration);
            }
            kTypeParameterOwnerImpl = (kotlin.reflect.jvm.internal.KTypeParameterOwnerImpl) objAccept;
        }
        this.container = kTypeParameterOwnerImpl;
    }

    @Override // kotlin.reflect.jvm.internal.KClassifierImpl
    public kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor getDescriptor() {
        return this.descriptor;
    }

    @Override // kotlin.reflect.KTypeParameter
    public java.lang.String getName() {
        java.lang.String strAsString = getDescriptor().getName().asString();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strAsString, "asString(...)");
        return strAsString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.util.List upperBounds_delegate$lambda$1(kotlin.reflect.jvm.internal.KTypeParameterImpl kTypeParameterImpl) {
        java.util.List<kotlin.reflect.jvm.internal.impl.types.KotlinType> upperBounds = kTypeParameterImpl.getDescriptor().getUpperBounds();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(upperBounds, "getUpperBounds(...)");
        java.util.List<kotlin.reflect.jvm.internal.impl.types.KotlinType> list = upperBounds;
        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(list, 10));
        java.util.Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new kotlin.reflect.jvm.internal.KTypeImpl((kotlin.reflect.jvm.internal.impl.types.KotlinType) it.next(), null, 2, null));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.KTypeParameter
    public java.util.List<kotlin.reflect.KType> getUpperBounds() {
        T value = this.upperBounds.getValue(this, $$delegatedProperties[0]);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (java.util.List) value;
    }

    @Override // kotlin.reflect.KTypeParameter
    public kotlin.reflect.KVariance getVariance() {
        int i = kotlin.reflect.jvm.internal.KTypeParameterImpl.WhenMappings.$EnumSwitchMapping$0[getDescriptor().getVariance().ordinal()];
        if (i == 1) {
            return kotlin.reflect.KVariance.INVARIANT;
        }
        if (i == 2) {
            return kotlin.reflect.KVariance.IN;
        }
        if (i != 3) {
            throw new kotlin.NoWhenBranchMatchedException();
        }
        return kotlin.reflect.KVariance.OUT;
    }

    @Override // kotlin.reflect.KTypeParameter
    /* JADX INFO: renamed from: isReified */
    public boolean getIsReified() {
        return getDescriptor().isReified();
    }

    private final kotlin.reflect.jvm.internal.KClassImpl<?> toKClassImpl(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor) {
        java.lang.Class<?> javaClass = kotlin.reflect.jvm.internal.UtilKt.toJavaClass(classDescriptor);
        kotlin.reflect.jvm.internal.KClassImpl<?> kClassImpl = (kotlin.reflect.jvm.internal.KClassImpl) (javaClass != null ? kotlin.jvm.JvmClassMappingKt.getKotlinClass(javaClass) : null);
        if (kClassImpl != null) {
            return kClassImpl;
        }
        throw new kotlin.reflect.jvm.internal.KotlinReflectionInternalError("Type parameter container is not resolved: " + classDescriptor.getContainingDeclaration());
    }

    private final java.lang.Class<?> getContainerClass(kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor deserializedMemberDescriptor) {
        java.lang.Class<?> klass;
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource containerSource = deserializedMemberDescriptor.getContainerSource();
        kotlin.reflect.jvm.internal.impl.load.kotlin.JvmPackagePartSource jvmPackagePartSource = containerSource instanceof kotlin.reflect.jvm.internal.impl.load.kotlin.JvmPackagePartSource ? (kotlin.reflect.jvm.internal.impl.load.kotlin.JvmPackagePartSource) containerSource : null;
        kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass knownJvmBinaryClass = jvmPackagePartSource != null ? jvmPackagePartSource.getKnownJvmBinaryClass() : null;
        kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass reflectKotlinClass = knownJvmBinaryClass instanceof kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass ? (kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass) knownJvmBinaryClass : null;
        if (reflectKotlinClass != null && (klass = reflectKotlinClass.getKlass()) != null) {
            return klass;
        }
        throw new kotlin.reflect.jvm.internal.KotlinReflectionInternalError("Container of deserialized member is not resolved: " + deserializedMemberDescriptor);
    }

    public boolean equals(java.lang.Object other) {
        if (!(other instanceof kotlin.reflect.jvm.internal.KTypeParameterImpl)) {
            return false;
        }
        kotlin.reflect.jvm.internal.KTypeParameterImpl kTypeParameterImpl = (kotlin.reflect.jvm.internal.KTypeParameterImpl) other;
        return kotlin.jvm.internal.Intrinsics.areEqual(this.container, kTypeParameterImpl.container) && kotlin.jvm.internal.Intrinsics.areEqual(getName(), kTypeParameterImpl.getName());
    }

    public int hashCode() {
        return (this.container.hashCode() * 31) + getName().hashCode();
    }

    public java.lang.String toString() {
        return kotlin.jvm.internal.TypeParameterReference.INSTANCE.toString(this);
    }
}
