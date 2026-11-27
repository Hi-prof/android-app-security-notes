package kotlin.reflect.jvm.internal;

/* JADX INFO: compiled from: KCallableImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b \u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J%\u00108\u001a\u00028\u00002\u0016\u00109\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010;0:\"\u0004\u0018\u00010;H\u0016¢\u0006\u0002\u0010<J#\u0010=\u001a\u00028\u00002\u0014\u00109\u001a\u0010\u0012\u0004\u0012\u00020!\u0012\u0006\u0012\u0004\u0018\u00010;0>H\u0016¢\u0006\u0002\u0010?J\u0015\u0010A\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010;0:H\u0002¢\u0006\u0002\u0010BJ3\u0010C\u001a\u00028\u00002\u0014\u00109\u001a\u0010\u0012\u0004\u0012\u00020!\u0012\u0006\u0012\u0004\u0018\u00010;0>2\f\u0010D\u001a\b\u0012\u0002\b\u0003\u0018\u00010EH\u0000¢\u0006\u0004\bF\u0010GJ\u0010\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020!H\u0002J#\u0010M\u001a\u00028\u00002\u0014\u00109\u001a\u0010\u0012\u0004\u0012\u00020!\u0012\u0006\u0012\u0004\u0018\u00010;0>H\u0002¢\u0006\u0002\u0010?J\u0010\u0010N\u001a\u00020;2\u0006\u0010O\u001a\u00020(H\u0002J\n\u0010P\u001a\u0004\u0018\u00010QH\u0002R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0012\u0010\u0010\u001a\u00020\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0012\u0010\u0014\u001a\u00020\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0016R(\u0010\u0017\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u001a \u001b*\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00190\u00190\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR>\u0010\u001f\u001a2\u0012.\u0012,\u0012\u0004\u0012\u00020! \u001b*\u0016\u0012\u0004\u0012\u00020!\u0018\u00010 j\n\u0012\u0004\u0012\u00020!\u0018\u0001`\"0 j\b\u0012\u0004\u0012\u00020!`\"0\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020!0\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\u001eR\u001c\u0010%\u001a\u0010\u0012\f\u0012\n \u001b*\u0004\u0018\u00010&0&0\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010'\u001a\u00020(8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R(\u0010+\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020, \u001b*\n\u0012\u0004\u0012\u00020,\u0018\u00010\u00190\u00190\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020.0\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b/\u0010\u001eR\u0016\u00100\u001a\u0004\u0018\u0001018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b2\u00103R\u0014\u00104\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b4\u0010\u0016R\u0014\u00105\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b5\u0010\u0016R\u0014\u00106\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b6\u0010\u0016R\u0014\u00107\u001a\u00020\u00158DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b7\u0010\u0016R,\u0010@\u001a \u0012\u001c\u0012\u001a\u0012\u0006\u0012\u0004\u0018\u00010; \u001b*\f\u0012\u0006\u0012\u0004\u0018\u00010;\u0018\u00010:0:0\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00150IX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006R"}, d2 = {"Lkotlin/reflect/jvm/internal/KCallableImpl;", "R", "Lkotlin/reflect/KCallable;", "Lkotlin/reflect/jvm/internal/KTypeParameterOwnerImpl;", "<init>", "()V", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "defaultCaller", "getDefaultCaller", com.taobao.weex.ui.component.WXBasicComponentType.CONTAINER, "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "isBound", "", "()Z", "_annotations", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "", "", "kotlin.jvm.PlatformType", "annotations", "getAnnotations", "()Ljava/util/List;", "_parameters", "Ljava/util/ArrayList;", "Lkotlin/reflect/KParameter;", "Lkotlin/collections/ArrayList;", "parameters", "getParameters", "_returnType", "Lkotlin/reflect/jvm/internal/KTypeImpl;", "returnType", "Lkotlin/reflect/KType;", "getReturnType", "()Lkotlin/reflect/KType;", "_typeParameters", "Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", com.taobao.weex.common.Constants.Name.VISIBILITY, "Lkotlin/reflect/KVisibility;", "getVisibility", "()Lkotlin/reflect/KVisibility;", "isFinal", "isOpen", "isAbstract", "isAnnotationConstructor", androidx.core.app.NotificationCompat.CATEGORY_CALL, "args", "", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "callBy", "", "(Ljava/util/Map;)Ljava/lang/Object;", "_absentArguments", "getAbsentArguments", "()[Ljava/lang/Object;", "callDefaultMethod", "continuationArgument", "Lkotlin/coroutines/Continuation;", "callDefaultMethod$kotlin_reflection", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "parametersNeedMFVCFlattening", "Lkotlin/Lazy;", "getParameterTypeSize", "", "parameter", "callAnnotationConstructor", "defaultEmptyArray", "type", "extractContinuationArgument", "Ljava/lang/reflect/Type;", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class KCallableImpl<R> implements kotlin.reflect.KCallable<R>, kotlin.reflect.jvm.internal.KTypeParameterOwnerImpl {
    private final kotlin.reflect.jvm.internal.ReflectProperties.LazySoftVal<java.lang.Object[]> _absentArguments;
    private final kotlin.reflect.jvm.internal.ReflectProperties.LazySoftVal<java.util.List<java.lang.annotation.Annotation>> _annotations;
    private final kotlin.reflect.jvm.internal.ReflectProperties.LazySoftVal<java.util.ArrayList<kotlin.reflect.KParameter>> _parameters;
    private final kotlin.reflect.jvm.internal.ReflectProperties.LazySoftVal<kotlin.reflect.jvm.internal.KTypeImpl> _returnType;
    private final kotlin.reflect.jvm.internal.ReflectProperties.LazySoftVal<java.util.List<kotlin.reflect.jvm.internal.KTypeParameterImpl>> _typeParameters;
    private final kotlin.Lazy<java.lang.Boolean> parametersNeedMFVCFlattening;

    public abstract kotlin.reflect.jvm.internal.calls.Caller<?> getCaller();

    public abstract kotlin.reflect.jvm.internal.KDeclarationContainerImpl getContainer();

    public abstract kotlin.reflect.jvm.internal.calls.Caller<?> getDefaultCaller();

    public abstract kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor getDescriptor();

    public abstract boolean isBound();

    public KCallableImpl() {
        kotlin.reflect.jvm.internal.ReflectProperties.LazySoftVal<java.util.List<java.lang.annotation.Annotation>> lazySoftValLazySoft = kotlin.reflect.jvm.internal.ReflectProperties.lazySoft(new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.KCallableImpl$$Lambda$0
            private final kotlin.reflect.jvm.internal.KCallableImpl arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.KCallableImpl._annotations$lambda$0(this.arg$0);
            }
        });
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(lazySoftValLazySoft, "lazySoft(...)");
        this._annotations = lazySoftValLazySoft;
        kotlin.reflect.jvm.internal.ReflectProperties.LazySoftVal<java.util.ArrayList<kotlin.reflect.KParameter>> lazySoftValLazySoft2 = kotlin.reflect.jvm.internal.ReflectProperties.lazySoft(new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.KCallableImpl$$Lambda$1
            private final kotlin.reflect.jvm.internal.KCallableImpl arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.KCallableImpl._parameters$lambda$5(this.arg$0);
            }
        });
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(lazySoftValLazySoft2, "lazySoft(...)");
        this._parameters = lazySoftValLazySoft2;
        kotlin.reflect.jvm.internal.ReflectProperties.LazySoftVal<kotlin.reflect.jvm.internal.KTypeImpl> lazySoftValLazySoft3 = kotlin.reflect.jvm.internal.ReflectProperties.lazySoft(new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.KCallableImpl$$Lambda$2
            private final kotlin.reflect.jvm.internal.KCallableImpl arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.KCallableImpl._returnType$lambda$7(this.arg$0);
            }
        });
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(lazySoftValLazySoft3, "lazySoft(...)");
        this._returnType = lazySoftValLazySoft3;
        kotlin.reflect.jvm.internal.ReflectProperties.LazySoftVal<java.util.List<kotlin.reflect.jvm.internal.KTypeParameterImpl>> lazySoftValLazySoft4 = kotlin.reflect.jvm.internal.ReflectProperties.lazySoft(new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.KCallableImpl$$Lambda$3
            private final kotlin.reflect.jvm.internal.KCallableImpl arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.KCallableImpl._typeParameters$lambda$9(this.arg$0);
            }
        });
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(lazySoftValLazySoft4, "lazySoft(...)");
        this._typeParameters = lazySoftValLazySoft4;
        kotlin.reflect.jvm.internal.ReflectProperties.LazySoftVal<java.lang.Object[]> lazySoftValLazySoft5 = kotlin.reflect.jvm.internal.ReflectProperties.lazySoft(new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.KCallableImpl$$Lambda$4
            private final kotlin.reflect.jvm.internal.KCallableImpl arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.KCallableImpl._absentArguments$lambda$14(this.arg$0);
            }
        });
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(lazySoftValLazySoft5, "lazySoft(...)");
        this._absentArguments = lazySoftValLazySoft5;
        this.parametersNeedMFVCFlattening = kotlin.LazyKt.lazy(kotlin.LazyThreadSafetyMode.PUBLICATION, new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.KCallableImpl$$Lambda$5
            private final kotlin.reflect.jvm.internal.KCallableImpl arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return java.lang.Boolean.valueOf(kotlin.reflect.jvm.internal.KCallableImpl.parametersNeedMFVCFlattening$lambda$20(this.arg$0));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.util.List _annotations$lambda$0(kotlin.reflect.jvm.internal.KCallableImpl kCallableImpl) {
        return kotlin.reflect.jvm.internal.UtilKt.computeAnnotations(kCallableImpl.getDescriptor());
    }

    @Override // kotlin.reflect.KAnnotatedElement
    public java.util.List<java.lang.annotation.Annotation> getAnnotations() {
        java.util.List<java.lang.annotation.Annotation> listInvoke = this._annotations.invoke();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(listInvoke, "invoke(...)");
        return listInvoke;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.util.ArrayList _parameters$lambda$5(kotlin.reflect.jvm.internal.KCallableImpl kCallableImpl) {
        int i;
        final kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor descriptor = kCallableImpl.getDescriptor();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        final int i2 = 0;
        if (kCallableImpl.isBound()) {
            i = 0;
        } else {
            final kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor instanceReceiverParameter = kotlin.reflect.jvm.internal.UtilKt.getInstanceReceiverParameter(descriptor);
            if (instanceReceiverParameter != null) {
                arrayList.add(new kotlin.reflect.jvm.internal.KParameterImpl(kCallableImpl, 0, kotlin.reflect.KParameter.Kind.INSTANCE, new kotlin.jvm.functions.Function0(instanceReceiverParameter) { // from class: kotlin.reflect.jvm.internal.KCallableImpl$$Lambda$6
                    private final kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor arg$0;

                    {
                        this.arg$0 = instanceReceiverParameter;
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public java.lang.Object invoke() {
                        return kotlin.reflect.jvm.internal.KCallableImpl._parameters$lambda$5$lambda$1(this.arg$0);
                    }
                }));
                i = 1;
            } else {
                i = 0;
            }
            final kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor extensionReceiverParameter = descriptor.getExtensionReceiverParameter();
            if (extensionReceiverParameter != null) {
                arrayList.add(new kotlin.reflect.jvm.internal.KParameterImpl(kCallableImpl, i, kotlin.reflect.KParameter.Kind.EXTENSION_RECEIVER, new kotlin.jvm.functions.Function0(extensionReceiverParameter) { // from class: kotlin.reflect.jvm.internal.KCallableImpl$$Lambda$7
                    private final kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor arg$0;

                    {
                        this.arg$0 = extensionReceiverParameter;
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public java.lang.Object invoke() {
                        return kotlin.reflect.jvm.internal.KCallableImpl._parameters$lambda$5$lambda$2(this.arg$0);
                    }
                }));
                i++;
            }
        }
        int size = descriptor.getValueParameters().size();
        while (i2 < size) {
            arrayList.add(new kotlin.reflect.jvm.internal.KParameterImpl(kCallableImpl, i, kotlin.reflect.KParameter.Kind.VALUE, new kotlin.jvm.functions.Function0(descriptor, i2) { // from class: kotlin.reflect.jvm.internal.KCallableImpl$$Lambda$8
                private final kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor arg$0;
                private final int arg$1;

                {
                    this.arg$0 = descriptor;
                    this.arg$1 = i2;
                }

                @Override // kotlin.jvm.functions.Function0
                public java.lang.Object invoke() {
                    return kotlin.reflect.jvm.internal.KCallableImpl._parameters$lambda$5$lambda$3(this.arg$0, this.arg$1);
                }
            }));
            i2++;
            i++;
        }
        if (kCallableImpl.isAnnotationConstructor() && (descriptor instanceof kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor)) {
            java.util.ArrayList arrayList2 = arrayList;
            if (arrayList2.size() > 1) {
                kotlin.collections.CollectionsKt.sortWith(arrayList2, new java.util.Comparator() { // from class: kotlin.reflect.jvm.internal.KCallableImpl$_parameters$lambda$5$$inlined$sortBy$1
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return kotlin.comparisons.ComparisonsKt.compareValues(((kotlin.reflect.KParameter) t).getName(), ((kotlin.reflect.KParameter) t2).getName());
                    }
                });
            }
        }
        arrayList.trimToSize();
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.descriptors.ParameterDescriptor _parameters$lambda$5$lambda$1(kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor receiverParameterDescriptor) {
        return receiverParameterDescriptor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.descriptors.ParameterDescriptor _parameters$lambda$5$lambda$2(kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor receiverParameterDescriptor) {
        return receiverParameterDescriptor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.descriptors.ParameterDescriptor _parameters$lambda$5$lambda$3(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor callableMemberDescriptor, int i) {
        kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor valueParameterDescriptor = callableMemberDescriptor.getValueParameters().get(i);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(valueParameterDescriptor, "get(...)");
        return valueParameterDescriptor;
    }

    @Override // kotlin.reflect.KCallable
    public java.util.List<kotlin.reflect.KParameter> getParameters() {
        java.util.ArrayList<kotlin.reflect.KParameter> arrayListInvoke = this._parameters.invoke();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(arrayListInvoke, "invoke(...)");
        return arrayListInvoke;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.KTypeImpl _returnType$lambda$7(final kotlin.reflect.jvm.internal.KCallableImpl kCallableImpl) {
        kotlin.reflect.jvm.internal.impl.types.KotlinType returnType = kCallableImpl.getDescriptor().getReturnType();
        kotlin.jvm.internal.Intrinsics.checkNotNull(returnType);
        return new kotlin.reflect.jvm.internal.KTypeImpl(returnType, new kotlin.jvm.functions.Function0(kCallableImpl) { // from class: kotlin.reflect.jvm.internal.KCallableImpl$$Lambda$9
            private final kotlin.reflect.jvm.internal.KCallableImpl arg$0;

            {
                this.arg$0 = kCallableImpl;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.KCallableImpl._returnType$lambda$7$lambda$6(this.arg$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.lang.reflect.Type _returnType$lambda$7$lambda$6(kotlin.reflect.jvm.internal.KCallableImpl kCallableImpl) {
        java.lang.reflect.Type typeExtractContinuationArgument = kCallableImpl.extractContinuationArgument();
        return typeExtractContinuationArgument == null ? kCallableImpl.getCaller().getReturnType() : typeExtractContinuationArgument;
    }

    @Override // kotlin.reflect.KCallable
    public kotlin.reflect.KType getReturnType() {
        kotlin.reflect.jvm.internal.KTypeImpl kTypeImplInvoke = this._returnType.invoke();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(kTypeImplInvoke, "invoke(...)");
        return kTypeImplInvoke;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.util.List _typeParameters$lambda$9(kotlin.reflect.jvm.internal.KCallableImpl kCallableImpl) {
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> typeParameters = kCallableImpl.getDescriptor().getTypeParameters();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(typeParameters, "getTypeParameters(...)");
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> list = typeParameters;
        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(list, 10));
        for (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor typeParameterDescriptor : list) {
            kotlin.jvm.internal.Intrinsics.checkNotNull(typeParameterDescriptor);
            arrayList.add(new kotlin.reflect.jvm.internal.KTypeParameterImpl(kCallableImpl, typeParameterDescriptor));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.KCallable
    public java.util.List<kotlin.reflect.KTypeParameter> getTypeParameters() {
        java.util.List<kotlin.reflect.jvm.internal.KTypeParameterImpl> listInvoke = this._typeParameters.invoke();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(listInvoke, "invoke(...)");
        return listInvoke;
    }

    @Override // kotlin.reflect.KCallable
    public kotlin.reflect.KVisibility getVisibility() {
        kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility visibility = getDescriptor().getVisibility();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(visibility, "getVisibility(...)");
        return kotlin.reflect.jvm.internal.UtilKt.toKVisibility(visibility);
    }

    @Override // kotlin.reflect.KCallable
    public boolean isFinal() {
        return getDescriptor().getModality() == kotlin.reflect.jvm.internal.impl.descriptors.Modality.FINAL;
    }

    @Override // kotlin.reflect.KCallable
    public boolean isOpen() {
        return getDescriptor().getModality() == kotlin.reflect.jvm.internal.impl.descriptors.Modality.OPEN;
    }

    @Override // kotlin.reflect.KCallable
    public boolean isAbstract() {
        return getDescriptor().getModality() == kotlin.reflect.jvm.internal.impl.descriptors.Modality.ABSTRACT;
    }

    protected final boolean isAnnotationConstructor() {
        return kotlin.jvm.internal.Intrinsics.areEqual(getName(), "<init>") && getContainer().getJClass().isAnnotation();
    }

    @Override // kotlin.reflect.KCallable
    public R call(java.lang.Object... args) throws kotlin.reflect.full.IllegalCallableAccessException {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(args, "args");
        try {
            return (R) getCaller().call(args);
        } catch (java.lang.IllegalAccessException e) {
            throw new kotlin.reflect.full.IllegalCallableAccessException(e);
        }
    }

    @Override // kotlin.reflect.KCallable
    public R callBy(java.util.Map<kotlin.reflect.KParameter, ? extends java.lang.Object> args) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(args, "args");
        return isAnnotationConstructor() ? callAnnotationConstructor(args) : callDefaultMethod$kotlin_reflection(args, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.lang.Object[] _absentArguments$lambda$14(kotlin.reflect.jvm.internal.KCallableImpl kCallableImpl) {
        int parameterTypeSize;
        java.util.List<kotlin.reflect.KParameter> parameters = kCallableImpl.getParameters();
        int size = parameters.size() + (kCallableImpl.isSuspend() ? 1 : 0);
        if (kCallableImpl.parametersNeedMFVCFlattening.getValue().booleanValue()) {
            parameterTypeSize = 0;
            for (kotlin.reflect.KParameter kParameter : parameters) {
                parameterTypeSize += kParameter.getKind() == kotlin.reflect.KParameter.Kind.VALUE ? kCallableImpl.getParameterTypeSize(kParameter) : 0;
            }
        } else {
            java.util.List<kotlin.reflect.KParameter> list = parameters;
            if ((list instanceof java.util.Collection) && list.isEmpty()) {
                parameterTypeSize = 0;
            } else {
                java.util.Iterator<T> it = list.iterator();
                parameterTypeSize = 0;
                while (it.hasNext()) {
                    if (((kotlin.reflect.KParameter) it.next()).getKind() == kotlin.reflect.KParameter.Kind.VALUE && (parameterTypeSize = parameterTypeSize + 1) < 0) {
                        kotlin.collections.CollectionsKt.throwCountOverflow();
                    }
                }
            }
        }
        int i = (parameterTypeSize + 31) / 32;
        java.lang.Object[] objArr = new java.lang.Object[size + i + 1];
        for (kotlin.reflect.KParameter kParameter2 : parameters) {
            if (kParameter2.isOptional() && !kotlin.reflect.jvm.internal.UtilKt.isInlineClassType(kParameter2.getType())) {
                objArr[kParameter2.getIndex()] = kotlin.reflect.jvm.internal.UtilKt.defaultPrimitiveValue(kotlin.reflect.jvm.ReflectJvmMapping.getJavaType(kParameter2.getType()));
            } else if (kParameter2.isVararg()) {
                objArr[kParameter2.getIndex()] = kCallableImpl.defaultEmptyArray(kParameter2.getType());
            }
        }
        for (int i2 = 0; i2 < i; i2++) {
            objArr[size + i2] = 0;
        }
        return objArr;
    }

    private final java.lang.Object[] getAbsentArguments() {
        return (java.lang.Object[]) this._absentArguments.invoke().clone();
    }

    public final R callDefaultMethod$kotlin_reflection(java.util.Map<kotlin.reflect.KParameter, ? extends java.lang.Object> args, kotlin.coroutines.Continuation<?> continuationArgument) throws kotlin.reflect.full.IllegalCallableAccessException {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(args, "args");
        java.util.List<kotlin.reflect.KParameter> parameters = getParameters();
        boolean z = false;
        if (!parameters.isEmpty()) {
            int size = parameters.size() + (isSuspend() ? 1 : 0);
            java.lang.Object[] absentArguments = getAbsentArguments();
            if (isSuspend()) {
                absentArguments[parameters.size()] = continuationArgument;
            }
            boolean zBooleanValue = this.parametersNeedMFVCFlattening.getValue().booleanValue();
            int i = 0;
            for (kotlin.reflect.KParameter kParameter : parameters) {
                int parameterTypeSize = zBooleanValue ? getParameterTypeSize(kParameter) : 1;
                if (args.containsKey(kParameter)) {
                    absentArguments[kParameter.getIndex()] = args.get(kParameter);
                } else if (kParameter.isOptional()) {
                    if (zBooleanValue) {
                        int i2 = i + parameterTypeSize;
                        for (int i3 = i; i3 < i2; i3++) {
                            int i4 = (i3 / 32) + size;
                            java.lang.Object obj = absentArguments[i4];
                            kotlin.jvm.internal.Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                            absentArguments[i4] = java.lang.Integer.valueOf(((java.lang.Integer) obj).intValue() | (1 << (i3 % 32)));
                        }
                    } else {
                        int i5 = (i / 32) + size;
                        java.lang.Object obj2 = absentArguments[i5];
                        kotlin.jvm.internal.Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Int");
                        absentArguments[i5] = java.lang.Integer.valueOf(((java.lang.Integer) obj2).intValue() | (1 << (i % 32)));
                    }
                    z = true;
                } else if (!kParameter.isVararg()) {
                    throw new java.lang.IllegalArgumentException("No argument provided for a required parameter: " + kParameter);
                }
                if (kParameter.getKind() == kotlin.reflect.KParameter.Kind.VALUE) {
                    i += parameterTypeSize;
                }
            }
            if (!z) {
                try {
                    kotlin.reflect.jvm.internal.calls.Caller<?> caller = getCaller();
                    java.lang.Object[] objArrCopyOf = java.util.Arrays.copyOf(absentArguments, size);
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(...)");
                    return (R) caller.call(objArrCopyOf);
                } catch (java.lang.IllegalAccessException e) {
                    throw new kotlin.reflect.full.IllegalCallableAccessException(e);
                }
            }
            kotlin.reflect.jvm.internal.calls.Caller<?> defaultCaller = getDefaultCaller();
            if (defaultCaller == null) {
                throw new kotlin.reflect.jvm.internal.KotlinReflectionInternalError("This callable does not support a default call: " + getDescriptor());
            }
            try {
                return (R) defaultCaller.call(absentArguments);
            } catch (java.lang.IllegalAccessException e2) {
                throw new kotlin.reflect.full.IllegalCallableAccessException(e2);
            }
        }
        try {
            return (R) getCaller().call(isSuspend() ? new kotlin.coroutines.Continuation[]{continuationArgument} : new kotlin.coroutines.Continuation[0]);
        } catch (java.lang.IllegalAccessException e3) {
            throw new kotlin.reflect.full.IllegalCallableAccessException(e3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean parametersNeedMFVCFlattening$lambda$20(kotlin.reflect.jvm.internal.KCallableImpl kCallableImpl) {
        java.util.List<kotlin.reflect.KParameter> parameters = kCallableImpl.getParameters();
        if ((parameters instanceof java.util.Collection) && parameters.isEmpty()) {
            return false;
        }
        java.util.Iterator<T> it = parameters.iterator();
        while (it.hasNext()) {
            if (kotlin.reflect.jvm.internal.UtilKt.getNeedsMultiFieldValueClassFlattening(((kotlin.reflect.KParameter) it.next()).getType())) {
                return true;
            }
        }
        return false;
    }

    private final int getParameterTypeSize(kotlin.reflect.KParameter parameter) {
        if (!this.parametersNeedMFVCFlattening.getValue().booleanValue()) {
            throw new java.lang.IllegalArgumentException("Check if parametersNeedMFVCFlattening is true before".toString());
        }
        if (!kotlin.reflect.jvm.internal.UtilKt.getNeedsMultiFieldValueClassFlattening(parameter.getType())) {
            return 1;
        }
        kotlin.reflect.KType type = parameter.getType();
        kotlin.jvm.internal.Intrinsics.checkNotNull(type, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KTypeImpl");
        java.util.List<java.lang.reflect.Method> mfvcUnboxMethods = kotlin.reflect.jvm.internal.calls.ValueClassAwareCallerKt.getMfvcUnboxMethods(kotlin.reflect.jvm.internal.impl.types.TypeSubstitutionKt.asSimpleType(((kotlin.reflect.jvm.internal.KTypeImpl) type).getType()));
        kotlin.jvm.internal.Intrinsics.checkNotNull(mfvcUnboxMethods);
        return mfvcUnboxMethods.size();
    }

    private final R callAnnotationConstructor(java.util.Map<kotlin.reflect.KParameter, ? extends java.lang.Object> args) throws kotlin.reflect.full.IllegalCallableAccessException {
        java.lang.Object objDefaultEmptyArray;
        java.util.List<kotlin.reflect.KParameter> parameters = getParameters();
        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(parameters, 10));
        for (kotlin.reflect.KParameter kParameter : parameters) {
            if (args.containsKey(kParameter)) {
                objDefaultEmptyArray = args.get(kParameter);
                if (objDefaultEmptyArray == null) {
                    throw new java.lang.IllegalArgumentException("Annotation argument value cannot be null (" + kParameter + com.taobao.weex.el.parse.Operators.BRACKET_END);
                }
            } else if (kParameter.isOptional()) {
                objDefaultEmptyArray = null;
            } else {
                if (!kParameter.isVararg()) {
                    throw new java.lang.IllegalArgumentException("No argument provided for a required parameter: " + kParameter);
                }
                objDefaultEmptyArray = defaultEmptyArray(kParameter.getType());
            }
            arrayList.add(objDefaultEmptyArray);
        }
        java.util.ArrayList arrayList2 = arrayList;
        kotlin.reflect.jvm.internal.calls.Caller<?> defaultCaller = getDefaultCaller();
        if (defaultCaller == null) {
            throw new kotlin.reflect.jvm.internal.KotlinReflectionInternalError("This callable does not support a default call: " + getDescriptor());
        }
        try {
            return (R) defaultCaller.call(arrayList2.toArray(new java.lang.Object[0]));
        } catch (java.lang.IllegalAccessException e) {
            throw new kotlin.reflect.full.IllegalCallableAccessException(e);
        }
    }

    private final java.lang.Object defaultEmptyArray(kotlin.reflect.KType type) {
        java.lang.Class javaClass = kotlin.jvm.JvmClassMappingKt.getJavaClass((kotlin.reflect.KClass) kotlin.reflect.jvm.KTypesJvm.getJvmErasure(type));
        if (javaClass.isArray()) {
            java.lang.Object objNewInstance = java.lang.reflect.Array.newInstance(javaClass.getComponentType(), 0);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(objNewInstance, "run(...)");
            return objNewInstance;
        }
        throw new kotlin.reflect.jvm.internal.KotlinReflectionInternalError("Cannot instantiate the default empty array of type " + javaClass.getSimpleName() + ", because it is not an array type");
    }

    private final java.lang.reflect.Type extractContinuationArgument() {
        java.lang.reflect.Type[] lowerBounds;
        if (isSuspend()) {
            java.lang.Object objLastOrNull = kotlin.collections.CollectionsKt.lastOrNull((java.util.List<? extends java.lang.Object>) getCaller().getParameterTypes());
            java.lang.reflect.ParameterizedType parameterizedType = objLastOrNull instanceof java.lang.reflect.ParameterizedType ? (java.lang.reflect.ParameterizedType) objLastOrNull : null;
            if (kotlin.jvm.internal.Intrinsics.areEqual(parameterizedType != null ? parameterizedType.getRawType() : null, kotlin.coroutines.Continuation.class)) {
                java.lang.reflect.Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(actualTypeArguments, "getActualTypeArguments(...)");
                java.lang.Object objSingle = kotlin.collections.ArraysKt.single(actualTypeArguments);
                java.lang.reflect.WildcardType wildcardType = objSingle instanceof java.lang.reflect.WildcardType ? (java.lang.reflect.WildcardType) objSingle : null;
                if (wildcardType != null && (lowerBounds = wildcardType.getLowerBounds()) != null) {
                    return (java.lang.reflect.Type) kotlin.collections.ArraysKt.first(lowerBounds);
                }
            }
        }
        return null;
    }
}
