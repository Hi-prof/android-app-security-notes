package kotlin.reflect.jvm.internal;

/* JADX INFO: compiled from: KParameterImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u00014B1\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\"\u001a\u00020#2\u0012\u0010$\u001a\n\u0012\u0006\b\u0001\u0012\u00020#0%\"\u00020#H\u0002¢\u0006\u0002\u0010&J\u0013\u0010/\u001a\u00020,2\b\u00100\u001a\u0004\u0018\u000101H\u0096\u0002J\b\u00102\u001a\u00020\u0005H\u0016J\b\u00103\u001a\u00020\u001fH\u0016R\u0015\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0013\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R!\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0017\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u001f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0014\u0010'\u001a\u00020(8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020,8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b+\u0010-R\u0014\u0010.\u001a\u00020,8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010-¨\u00065"}, d2 = {"Lkotlin/reflect/jvm/internal/KParameterImpl;", "Lkotlin/reflect/KParameter;", "callable", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "index", "", "kind", "Lkotlin/reflect/KParameter$Kind;", "computeDescriptor", "Lkotlin/Function0;", "Lkotlin/reflect/jvm/internal/impl/descriptors/ParameterDescriptor;", "<init>", "(Lkotlin/reflect/jvm/internal/KCallableImpl;ILkotlin/reflect/KParameter$Kind;Lkotlin/jvm/functions/Function0;)V", "getCallable", "()Lkotlin/reflect/jvm/internal/KCallableImpl;", "getIndex", "()I", "getKind", "()Lkotlin/reflect/KParameter$Kind;", "descriptor", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ParameterDescriptor;", "descriptor$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "annotations$delegate", "name", "", "getName", "()Ljava/lang/String;", "compoundType", "Ljava/lang/reflect/Type;", "types", "", "([Ljava/lang/reflect/Type;)Ljava/lang/reflect/Type;", "type", "Lkotlin/reflect/KType;", "getType", "()Lkotlin/reflect/KType;", "isOptional", "", "()Z", "isVararg", "equals", "other", "", "hashCode", "toString", "CompoundTypeImpl", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class KParameterImpl implements kotlin.reflect.KParameter {
    static final /* synthetic */ kotlin.reflect.KProperty<java.lang.Object>[] $$delegatedProperties = {kotlin.jvm.internal.Reflection.property1(new kotlin.jvm.internal.PropertyReference1Impl(kotlin.reflect.jvm.internal.KParameterImpl.class, "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ParameterDescriptor;", 0)), kotlin.jvm.internal.Reflection.property1(new kotlin.jvm.internal.PropertyReference1Impl(kotlin.reflect.jvm.internal.KParameterImpl.class, "annotations", "getAnnotations()Ljava/util/List;", 0))};

    /* JADX INFO: renamed from: annotations$delegate, reason: from kotlin metadata */
    private final kotlin.reflect.jvm.internal.ReflectProperties.LazySoftVal annotations;
    private final kotlin.reflect.jvm.internal.KCallableImpl<?> callable;

    /* JADX INFO: renamed from: descriptor$delegate, reason: from kotlin metadata */
    private final kotlin.reflect.jvm.internal.ReflectProperties.LazySoftVal descriptor;
    private final int index;
    private final kotlin.reflect.KParameter.Kind kind;

    public KParameterImpl(kotlin.reflect.jvm.internal.KCallableImpl<?> callable, int i, kotlin.reflect.KParameter.Kind kind, kotlin.jvm.functions.Function0<? extends kotlin.reflect.jvm.internal.impl.descriptors.ParameterDescriptor> computeDescriptor) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callable, "callable");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kind, "kind");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(computeDescriptor, "computeDescriptor");
        this.callable = callable;
        this.index = i;
        this.kind = kind;
        this.descriptor = kotlin.reflect.jvm.internal.ReflectProperties.lazySoft(computeDescriptor);
        this.annotations = kotlin.reflect.jvm.internal.ReflectProperties.lazySoft(new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.KParameterImpl$$Lambda$0
            private final kotlin.reflect.jvm.internal.KParameterImpl arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.KParameterImpl.annotations_delegate$lambda$0(this.arg$0);
            }
        });
    }

    public final kotlin.reflect.jvm.internal.KCallableImpl<?> getCallable() {
        return this.callable;
    }

    @Override // kotlin.reflect.KParameter
    public int getIndex() {
        return this.index;
    }

    @Override // kotlin.reflect.KParameter
    public kotlin.reflect.KParameter.Kind getKind() {
        return this.kind;
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.ParameterDescriptor getDescriptor() {
        T value = this.descriptor.getValue(this, $$delegatedProperties[0]);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (kotlin.reflect.jvm.internal.impl.descriptors.ParameterDescriptor) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.util.List annotations_delegate$lambda$0(kotlin.reflect.jvm.internal.KParameterImpl kParameterImpl) {
        return kotlin.reflect.jvm.internal.UtilKt.computeAnnotations(kParameterImpl.getDescriptor());
    }

    @Override // kotlin.reflect.KAnnotatedElement
    public java.util.List<java.lang.annotation.Annotation> getAnnotations() {
        T value = this.annotations.getValue(this, $$delegatedProperties[1]);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (java.util.List) value;
    }

    @Override // kotlin.reflect.KParameter
    public java.lang.String getName() {
        kotlin.reflect.jvm.internal.impl.descriptors.ParameterDescriptor descriptor = getDescriptor();
        kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor valueParameterDescriptor = descriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor ? (kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) descriptor : null;
        if (valueParameterDescriptor == null || valueParameterDescriptor.getContainingDeclaration().hasSynthesizedParameterNames()) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.name.Name name = valueParameterDescriptor.getName();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        if (name.isSpecial()) {
            return null;
        }
        return name.asString();
    }

    private final java.lang.reflect.Type compoundType(java.lang.reflect.Type... types) {
        int length = types.length;
        if (length == 0) {
            throw new kotlin.jvm.KotlinReflectionNotSupportedError("Expected at least 1 type for compound type");
        }
        if (length == 1) {
            return (java.lang.reflect.Type) kotlin.collections.ArraysKt.single(types);
        }
        return new kotlin.reflect.jvm.internal.KParameterImpl.CompoundTypeImpl(types);
    }

    /* JADX INFO: compiled from: KParameterImpl.kt */
    @kotlin.Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u0011\u001a\u00020\fH\u0016R\u001b\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lkotlin/reflect/jvm/internal/KParameterImpl$CompoundTypeImpl;", "Ljava/lang/reflect/Type;", "types", "", "<init>", "([Ljava/lang/reflect/Type;)V", "getTypes", "()[Ljava/lang/reflect/Type;", "[Ljava/lang/reflect/Type;", "hashCode", "", "getTypeName", "", "equals", "", "other", "", "toString", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class CompoundTypeImpl implements java.lang.reflect.Type {
        private final int hashCode;
        private final java.lang.reflect.Type[] types;

        public CompoundTypeImpl(java.lang.reflect.Type[] types) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(types, "types");
            this.types = types;
            this.hashCode = java.util.Arrays.hashCode(types);
        }

        @Override // java.lang.reflect.Type
        public java.lang.String getTypeName() {
            return kotlin.collections.ArraysKt.joinToString$default(this.types, ", ", com.taobao.weex.el.parse.Operators.ARRAY_START_STR, com.taobao.weex.el.parse.Operators.ARRAY_END_STR, 0, (java.lang.CharSequence) null, (kotlin.jvm.functions.Function1) null, 56, (java.lang.Object) null);
        }

        public boolean equals(java.lang.Object other) {
            return (other instanceof kotlin.reflect.jvm.internal.KParameterImpl.CompoundTypeImpl) && java.util.Arrays.equals(this.types, ((kotlin.reflect.jvm.internal.KParameterImpl.CompoundTypeImpl) other).types);
        }

        /* JADX INFO: renamed from: hashCode, reason: from getter */
        public int getHashCode() {
            return this.hashCode;
        }

        public java.lang.String toString() {
            return getTypeName();
        }
    }

    @Override // kotlin.reflect.KParameter
    public kotlin.reflect.KType getType() {
        kotlin.reflect.jvm.internal.impl.types.KotlinType type = getDescriptor().getType();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
        return new kotlin.reflect.jvm.internal.KTypeImpl(type, new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.KParameterImpl$$Lambda$1
            private final kotlin.reflect.jvm.internal.KParameterImpl arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.KParameterImpl._get_type_$lambda$1(this.arg$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.lang.reflect.Type _get_type_$lambda$1(kotlin.reflect.jvm.internal.KParameterImpl kParameterImpl) {
        java.util.List listSlice;
        kotlin.reflect.jvm.internal.impl.descriptors.ParameterDescriptor descriptor = kParameterImpl.getDescriptor();
        if ((descriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor) && kotlin.jvm.internal.Intrinsics.areEqual(kotlin.reflect.jvm.internal.UtilKt.getInstanceReceiverParameter(kParameterImpl.callable.getDescriptor()), descriptor) && kParameterImpl.callable.getDescriptor().getKind() == kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind.FAKE_OVERRIDE) {
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor containingDeclaration = kParameterImpl.callable.getDescriptor().getContainingDeclaration();
            kotlin.jvm.internal.Intrinsics.checkNotNull(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            java.lang.Class<?> javaClass = kotlin.reflect.jvm.internal.UtilKt.toJavaClass((kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) containingDeclaration);
            if (javaClass != null) {
                return javaClass;
            }
            throw new kotlin.reflect.jvm.internal.KotlinReflectionInternalError("Cannot determine receiver Java type of inherited declaration: " + descriptor);
        }
        kotlin.reflect.jvm.internal.calls.Caller<?> caller = kParameterImpl.callable.getCaller();
        if (caller instanceof kotlin.reflect.jvm.internal.calls.ValueClassAwareCaller) {
            if (kParameterImpl.callable.isBound()) {
                kotlin.reflect.jvm.internal.calls.ValueClassAwareCaller valueClassAwareCaller = (kotlin.reflect.jvm.internal.calls.ValueClassAwareCaller) caller;
                kotlin.ranges.IntRange realSlicesOfParameters = valueClassAwareCaller.getRealSlicesOfParameters(kParameterImpl.getIndex() + 1);
                int last = valueClassAwareCaller.getRealSlicesOfParameters(0).getLast() + 1;
                listSlice = kotlin.collections.CollectionsKt.slice((java.util.List) valueClassAwareCaller.getParameterTypes(), new kotlin.ranges.IntRange(realSlicesOfParameters.getFirst() - last, realSlicesOfParameters.getLast() - last));
            } else {
                kotlin.reflect.jvm.internal.calls.ValueClassAwareCaller valueClassAwareCaller2 = (kotlin.reflect.jvm.internal.calls.ValueClassAwareCaller) caller;
                listSlice = kotlin.collections.CollectionsKt.slice((java.util.List) valueClassAwareCaller2.getParameterTypes(), valueClassAwareCaller2.getRealSlicesOfParameters(kParameterImpl.getIndex()));
            }
            java.lang.reflect.Type[] typeArr = (java.lang.reflect.Type[]) listSlice.toArray(new java.lang.reflect.Type[0]);
            return kParameterImpl.compoundType((java.lang.reflect.Type[]) java.util.Arrays.copyOf(typeArr, typeArr.length));
        }
        if (caller instanceof kotlin.reflect.jvm.internal.calls.ValueClassAwareCaller.MultiFieldValueClassPrimaryConstructorCaller) {
            java.lang.Class[] clsArr = (java.lang.Class[]) ((kotlin.reflect.jvm.internal.calls.ValueClassAwareCaller.MultiFieldValueClassPrimaryConstructorCaller) caller).getOriginalParametersGroups().get(kParameterImpl.getIndex()).toArray(new java.lang.Class[0]);
            return kParameterImpl.compoundType((java.lang.reflect.Type[]) java.util.Arrays.copyOf(clsArr, clsArr.length));
        }
        return caller.getParameterTypes().get(kParameterImpl.getIndex());
    }

    @Override // kotlin.reflect.KParameter
    public boolean isOptional() {
        kotlin.reflect.jvm.internal.impl.descriptors.ParameterDescriptor descriptor = getDescriptor();
        kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor valueParameterDescriptor = descriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor ? (kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) descriptor : null;
        if (valueParameterDescriptor != null) {
            return kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.declaresOrInheritsDefaultValue(valueParameterDescriptor);
        }
        return false;
    }

    @Override // kotlin.reflect.KParameter
    public boolean isVararg() {
        kotlin.reflect.jvm.internal.impl.descriptors.ParameterDescriptor descriptor = getDescriptor();
        return (descriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) && ((kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) descriptor).getVarargElementType() != null;
    }

    public boolean equals(java.lang.Object other) {
        if (!(other instanceof kotlin.reflect.jvm.internal.KParameterImpl)) {
            return false;
        }
        kotlin.reflect.jvm.internal.KParameterImpl kParameterImpl = (kotlin.reflect.jvm.internal.KParameterImpl) other;
        return kotlin.jvm.internal.Intrinsics.areEqual(this.callable, kParameterImpl.callable) && getIndex() == kParameterImpl.getIndex();
    }

    public int hashCode() {
        return (this.callable.hashCode() * 31) + getIndex();
    }

    public java.lang.String toString() {
        return kotlin.reflect.jvm.internal.ReflectionObjectRenderer.INSTANCE.renderParameter(this);
    }
}
