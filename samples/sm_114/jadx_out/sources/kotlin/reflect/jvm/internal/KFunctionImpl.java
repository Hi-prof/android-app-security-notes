package kotlin.reflect.jvm.internal;

/* JADX INFO: compiled from: KFunctionImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0000\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00032\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00042\u00020\u0005B7\b\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000e\u0010\u000fB+\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000e\u0010\u0011B\u0019\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0012\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u0013J\u0012\u0010(\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0012\u001a\u00020\fH\u0002J\u0010\u0010+\u001a\u00020\u00172\u0006\u0010,\u001a\u00020-H\u0002J\u001c\u0010.\u001a\u0006\u0012\u0002\b\u00030 2\u0006\u0010,\u001a\u00020-2\u0006\u0010/\u001a\u00020\u0017H\u0002J\u0010\u00100\u001a\u0002012\u0006\u0010,\u001a\u00020-H\u0002J\u0010\u00102\u001a\u0002012\u0006\u0010,\u001a\u00020-H\u0002J.\u00103\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u000305042\n\u0010,\u001a\u0006\u0012\u0002\b\u0003052\u0006\u0010\u0012\u001a\u00020\f2\u0006\u00106\u001a\u00020\u0017H\u0002J\u0013\u0010@\u001a\u00020\u00172\b\u0010A\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010B\u001a\u000208H\u0016J\b\u0010C\u001a\u00020\tH\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0018R\u001b\u0010\u0012\u001a\u00020\f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u001f\u0010\u001f\u001a\u0006\u0012\u0002\b\u00030 8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b!\u0010\"R!\u0010%\u001a\b\u0012\u0002\b\u0003\u0018\u00010 8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b'\u0010$\u001a\u0004\b&\u0010\"R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0014\u00107\u001a\u0002088VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b9\u0010:R\u0014\u0010;\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b;\u0010\u0018R\u0014\u0010<\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b<\u0010\u0018R\u0014\u0010=\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b=\u0010\u0018R\u0014\u0010>\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b>\u0010\u0018R\u0014\u0010?\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b?\u0010\u0018¨\u0006D"}, d2 = {"Lkotlin/reflect/jvm/internal/KFunctionImpl;", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "", "Lkotlin/reflect/KFunction;", "Lkotlin/jvm/internal/FunctionBase;", "Lkotlin/reflect/jvm/internal/FunctionWithAllInvokes;", com.taobao.weex.ui.component.WXBasicComponentType.CONTAINER, "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "name", "", "signature", "descriptorInitialValue", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "rawBoundReceiver", "<init>", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;Ljava/lang/Object;)V", "boundReceiver", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "descriptor", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;)V", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "isBound", "", "()Z", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;", "descriptor$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "getName", "()Ljava/lang/String;", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "caller$delegate", "Lkotlin/Lazy;", "defaultCaller", "getDefaultCaller", "defaultCaller$delegate", "getFunctionWithDefaultParametersForValueClassOverride", "getBoundReceiver", "()Ljava/lang/Object;", "useBoxedBoundReceiver", "member", "Ljava/lang/reflect/Method;", "createStaticMethodCaller", "isCallByToValueClassMangledMethod", "createJvmStaticInObjectCaller", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "createInstanceMethodCaller", "createConstructorCaller", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Constructor;", "isDefault", "arity", "", "getArity", "()I", "isInline", "isExternal", "isOperator", "isInfix", "isSuspend", "equals", "other", "hashCode", "toString", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class KFunctionImpl extends kotlin.reflect.jvm.internal.KCallableImpl<java.lang.Object> implements kotlin.jvm.internal.FunctionBase<java.lang.Object>, kotlin.reflect.KFunction<java.lang.Object>, kotlin.reflect.jvm.internal.FunctionWithAllInvokes {
    static final /* synthetic */ kotlin.reflect.KProperty<java.lang.Object>[] $$delegatedProperties = {kotlin.jvm.internal.Reflection.property1(new kotlin.jvm.internal.PropertyReference1Impl(kotlin.reflect.jvm.internal.KFunctionImpl.class, "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;", 0))};

    /* JADX INFO: renamed from: caller$delegate, reason: from kotlin metadata */
    private final kotlin.Lazy caller;
    private final kotlin.reflect.jvm.internal.KDeclarationContainerImpl container;

    /* JADX INFO: renamed from: defaultCaller$delegate, reason: from kotlin metadata */
    private final kotlin.Lazy defaultCaller;

    /* JADX INFO: renamed from: descriptor$delegate, reason: from kotlin metadata */
    private final kotlin.reflect.jvm.internal.ReflectProperties.LazySoftVal descriptor;
    private final java.lang.Object rawBoundReceiver;
    private final java.lang.String signature;

    @Override // kotlin.jvm.functions.Function0
    public java.lang.Object invoke() {
        return default$invoke();
    }

    @Override // kotlin.jvm.functions.Function1
    /* JADX INFO: renamed from: invoke */
    public java.lang.Object invoke2(java.lang.Object obj) {
        return default$invoke(obj);
    }

    @Override // kotlin.jvm.functions.Function2
    public java.lang.Object invoke(java.lang.Object obj, java.lang.Object obj2) {
        return default$invoke(obj, obj2);
    }

    @Override // kotlin.jvm.functions.Function3
    public java.lang.Object invoke(java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3) {
        return default$invoke(obj, obj2, obj3);
    }

    @Override // kotlin.jvm.functions.Function4
    public java.lang.Object invoke(java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3, java.lang.Object obj4) {
        return default$invoke(obj, obj2, obj3, obj4);
    }

    @Override // kotlin.jvm.functions.Function5
    public java.lang.Object invoke(java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3, java.lang.Object obj4, java.lang.Object obj5) {
        return default$invoke(obj, obj2, obj3, obj4, obj5);
    }

    @Override // kotlin.jvm.functions.Function6
    public java.lang.Object invoke(java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3, java.lang.Object obj4, java.lang.Object obj5, java.lang.Object obj6) {
        return default$invoke(obj, obj2, obj3, obj4, obj5, obj6);
    }

    @Override // kotlin.jvm.functions.Function7
    public java.lang.Object invoke(java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3, java.lang.Object obj4, java.lang.Object obj5, java.lang.Object obj6, java.lang.Object obj7) {
        return default$invoke(obj, obj2, obj3, obj4, obj5, obj6, obj7);
    }

    @Override // kotlin.jvm.functions.Function8
    public java.lang.Object invoke(java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3, java.lang.Object obj4, java.lang.Object obj5, java.lang.Object obj6, java.lang.Object obj7, java.lang.Object obj8) {
        return default$invoke(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8);
    }

    @Override // kotlin.jvm.functions.Function9
    public java.lang.Object invoke(java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3, java.lang.Object obj4, java.lang.Object obj5, java.lang.Object obj6, java.lang.Object obj7, java.lang.Object obj8, java.lang.Object obj9) {
        return default$invoke(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9);
    }

    @Override // kotlin.jvm.functions.Function10
    public java.lang.Object invoke(java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3, java.lang.Object obj4, java.lang.Object obj5, java.lang.Object obj6, java.lang.Object obj7, java.lang.Object obj8, java.lang.Object obj9, java.lang.Object obj10) {
        return default$invoke(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10);
    }

    @Override // kotlin.jvm.functions.Function11
    public java.lang.Object invoke(java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3, java.lang.Object obj4, java.lang.Object obj5, java.lang.Object obj6, java.lang.Object obj7, java.lang.Object obj8, java.lang.Object obj9, java.lang.Object obj10, java.lang.Object obj11) {
        return default$invoke(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11);
    }

    @Override // kotlin.jvm.functions.Function12
    public java.lang.Object invoke(java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3, java.lang.Object obj4, java.lang.Object obj5, java.lang.Object obj6, java.lang.Object obj7, java.lang.Object obj8, java.lang.Object obj9, java.lang.Object obj10, java.lang.Object obj11, java.lang.Object obj12) {
        return default$invoke(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12);
    }

    @Override // kotlin.jvm.functions.Function13
    public java.lang.Object invoke(java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3, java.lang.Object obj4, java.lang.Object obj5, java.lang.Object obj6, java.lang.Object obj7, java.lang.Object obj8, java.lang.Object obj9, java.lang.Object obj10, java.lang.Object obj11, java.lang.Object obj12, java.lang.Object obj13) {
        return default$invoke(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13);
    }

    @Override // kotlin.jvm.functions.Function14
    public java.lang.Object invoke(java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3, java.lang.Object obj4, java.lang.Object obj5, java.lang.Object obj6, java.lang.Object obj7, java.lang.Object obj8, java.lang.Object obj9, java.lang.Object obj10, java.lang.Object obj11, java.lang.Object obj12, java.lang.Object obj13, java.lang.Object obj14) {
        return default$invoke(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14);
    }

    @Override // kotlin.jvm.functions.Function15
    public java.lang.Object invoke(java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3, java.lang.Object obj4, java.lang.Object obj5, java.lang.Object obj6, java.lang.Object obj7, java.lang.Object obj8, java.lang.Object obj9, java.lang.Object obj10, java.lang.Object obj11, java.lang.Object obj12, java.lang.Object obj13, java.lang.Object obj14, java.lang.Object obj15) {
        return default$invoke(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15);
    }

    @Override // kotlin.jvm.functions.Function16
    public java.lang.Object invoke(java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3, java.lang.Object obj4, java.lang.Object obj5, java.lang.Object obj6, java.lang.Object obj7, java.lang.Object obj8, java.lang.Object obj9, java.lang.Object obj10, java.lang.Object obj11, java.lang.Object obj12, java.lang.Object obj13, java.lang.Object obj14, java.lang.Object obj15, java.lang.Object obj16) {
        return default$invoke(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16);
    }

    @Override // kotlin.jvm.functions.Function17
    public java.lang.Object invoke(java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3, java.lang.Object obj4, java.lang.Object obj5, java.lang.Object obj6, java.lang.Object obj7, java.lang.Object obj8, java.lang.Object obj9, java.lang.Object obj10, java.lang.Object obj11, java.lang.Object obj12, java.lang.Object obj13, java.lang.Object obj14, java.lang.Object obj15, java.lang.Object obj16, java.lang.Object obj17) {
        return default$invoke(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17);
    }

    @Override // kotlin.jvm.functions.Function18
    public java.lang.Object invoke(java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3, java.lang.Object obj4, java.lang.Object obj5, java.lang.Object obj6, java.lang.Object obj7, java.lang.Object obj8, java.lang.Object obj9, java.lang.Object obj10, java.lang.Object obj11, java.lang.Object obj12, java.lang.Object obj13, java.lang.Object obj14, java.lang.Object obj15, java.lang.Object obj16, java.lang.Object obj17, java.lang.Object obj18) {
        return default$invoke(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18);
    }

    @Override // kotlin.jvm.functions.Function19
    public java.lang.Object invoke(java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3, java.lang.Object obj4, java.lang.Object obj5, java.lang.Object obj6, java.lang.Object obj7, java.lang.Object obj8, java.lang.Object obj9, java.lang.Object obj10, java.lang.Object obj11, java.lang.Object obj12, java.lang.Object obj13, java.lang.Object obj14, java.lang.Object obj15, java.lang.Object obj16, java.lang.Object obj17, java.lang.Object obj18, java.lang.Object obj19) {
        return default$invoke(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18, obj19);
    }

    @Override // kotlin.jvm.functions.Function20
    public java.lang.Object invoke(java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3, java.lang.Object obj4, java.lang.Object obj5, java.lang.Object obj6, java.lang.Object obj7, java.lang.Object obj8, java.lang.Object obj9, java.lang.Object obj10, java.lang.Object obj11, java.lang.Object obj12, java.lang.Object obj13, java.lang.Object obj14, java.lang.Object obj15, java.lang.Object obj16, java.lang.Object obj17, java.lang.Object obj18, java.lang.Object obj19, java.lang.Object obj20) {
        return default$invoke(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18, obj19, obj20);
    }

    @Override // kotlin.jvm.functions.Function21
    public java.lang.Object invoke(java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3, java.lang.Object obj4, java.lang.Object obj5, java.lang.Object obj6, java.lang.Object obj7, java.lang.Object obj8, java.lang.Object obj9, java.lang.Object obj10, java.lang.Object obj11, java.lang.Object obj12, java.lang.Object obj13, java.lang.Object obj14, java.lang.Object obj15, java.lang.Object obj16, java.lang.Object obj17, java.lang.Object obj18, java.lang.Object obj19, java.lang.Object obj20, java.lang.Object obj21) {
        return default$invoke(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18, obj19, obj20, obj21);
    }

    @Override // kotlin.jvm.functions.Function22
    public java.lang.Object invoke(java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3, java.lang.Object obj4, java.lang.Object obj5, java.lang.Object obj6, java.lang.Object obj7, java.lang.Object obj8, java.lang.Object obj9, java.lang.Object obj10, java.lang.Object obj11, java.lang.Object obj12, java.lang.Object obj13, java.lang.Object obj14, java.lang.Object obj15, java.lang.Object obj16, java.lang.Object obj17, java.lang.Object obj18, java.lang.Object obj19, java.lang.Object obj20, java.lang.Object obj21, java.lang.Object obj22) {
        return default$invoke(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18, obj19, obj20, obj21, obj22);
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    public kotlin.reflect.jvm.internal.KDeclarationContainerImpl getContainer() {
        return this.container;
    }

    /* synthetic */ KFunctionImpl(kotlin.reflect.jvm.internal.KDeclarationContainerImpl kDeclarationContainerImpl, java.lang.String str, java.lang.String str2, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor functionDescriptor, java.lang.Object obj, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(kDeclarationContainerImpl, str, str2, functionDescriptor, (i & 16) != 0 ? kotlin.jvm.internal.CallableReference.NO_RECEIVER : obj);
    }

    private KFunctionImpl(kotlin.reflect.jvm.internal.KDeclarationContainerImpl kDeclarationContainerImpl, final java.lang.String str, java.lang.String str2, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor functionDescriptor, java.lang.Object obj) {
        this.container = kDeclarationContainerImpl;
        this.signature = str2;
        this.rawBoundReceiver = obj;
        this.descriptor = kotlin.reflect.jvm.internal.ReflectProperties.lazySoft(functionDescriptor, new kotlin.jvm.functions.Function0(this, str) { // from class: kotlin.reflect.jvm.internal.KFunctionImpl$$Lambda$0
            private final kotlin.reflect.jvm.internal.KFunctionImpl arg$0;
            private final java.lang.String arg$1;

            {
                this.arg$0 = this;
                this.arg$1 = str;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.KFunctionImpl.descriptor_delegate$lambda$0(this.arg$0, this.arg$1);
            }
        });
        this.caller = kotlin.LazyKt.lazy(kotlin.LazyThreadSafetyMode.PUBLICATION, new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.KFunctionImpl$$Lambda$1
            private final kotlin.reflect.jvm.internal.KFunctionImpl arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.KFunctionImpl.caller_delegate$lambda$4(this.arg$0);
            }
        });
        this.defaultCaller = kotlin.LazyKt.lazy(kotlin.LazyThreadSafetyMode.PUBLICATION, new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.KFunctionImpl$$Lambda$2
            private final kotlin.reflect.jvm.internal.KFunctionImpl arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.KFunctionImpl.defaultCaller_delegate$lambda$10(this.arg$0);
            }
        });
    }

    public java.lang.Object default$invoke() {
        return call(new java.lang.Object[0]);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public KFunctionImpl(kotlin.reflect.jvm.internal.KDeclarationContainerImpl container, java.lang.String name, java.lang.String signature, java.lang.Object obj) {
        this(container, name, signature, null, obj);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(container, "container");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(signature, "signature");
    }

    public java.lang.Object default$invoke(java.lang.Object obj) {
        return call(obj);
    }

    public java.lang.Object default$invoke(java.lang.Object obj, java.lang.Object obj2) {
        return call(obj, obj2);
    }

    public java.lang.Object default$invoke(java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3) {
        return call(obj, obj2, obj3);
    }

    public java.lang.Object default$invoke(java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3, java.lang.Object obj4) {
        return call(obj, obj2, obj3, obj4);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public KFunctionImpl(kotlin.reflect.jvm.internal.KDeclarationContainerImpl container, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor descriptor) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(container, "container");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        java.lang.String strAsString = descriptor.getName().asString();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strAsString, "asString(...)");
        this(container, strAsString, kotlin.reflect.jvm.internal.RuntimeTypeMapper.INSTANCE.mapSignature(descriptor).get_signature(), descriptor, null, 16, null);
    }

    public java.lang.Object default$invoke(java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3, java.lang.Object obj4, java.lang.Object obj5) {
        return call(obj, obj2, obj3, obj4, obj5);
    }

    public java.lang.Object default$invoke(java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3, java.lang.Object obj4, java.lang.Object obj5, java.lang.Object obj6) {
        return call(obj, obj2, obj3, obj4, obj5, obj6);
    }

    public java.lang.Object default$invoke(java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3, java.lang.Object obj4, java.lang.Object obj5, java.lang.Object obj6, java.lang.Object obj7) {
        return call(obj, obj2, obj3, obj4, obj5, obj6, obj7);
    }

    public java.lang.Object default$invoke(java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3, java.lang.Object obj4, java.lang.Object obj5, java.lang.Object obj6, java.lang.Object obj7, java.lang.Object obj8) {
        return call(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8);
    }

    public java.lang.Object default$invoke(java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3, java.lang.Object obj4, java.lang.Object obj5, java.lang.Object obj6, java.lang.Object obj7, java.lang.Object obj8, java.lang.Object obj9) {
        return call(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9);
    }

    public java.lang.Object default$invoke(java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3, java.lang.Object obj4, java.lang.Object obj5, java.lang.Object obj6, java.lang.Object obj7, java.lang.Object obj8, java.lang.Object obj9, java.lang.Object obj10) {
        return call(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10);
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    public boolean isBound() {
        return this.rawBoundReceiver != kotlin.jvm.internal.CallableReference.NO_RECEIVER;
    }

    public java.lang.Object default$invoke(java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3, java.lang.Object obj4, java.lang.Object obj5, java.lang.Object obj6, java.lang.Object obj7, java.lang.Object obj8, java.lang.Object obj9, java.lang.Object obj10, java.lang.Object obj11) {
        return call(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11);
    }

    public java.lang.Object default$invoke(java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3, java.lang.Object obj4, java.lang.Object obj5, java.lang.Object obj6, java.lang.Object obj7, java.lang.Object obj8, java.lang.Object obj9, java.lang.Object obj10, java.lang.Object obj11, java.lang.Object obj12) {
        return call(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12);
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    public kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor getDescriptor() {
        T value = this.descriptor.getValue(this, $$delegatedProperties[0]);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor descriptor_delegate$lambda$0(kotlin.reflect.jvm.internal.KFunctionImpl kFunctionImpl, java.lang.String str) {
        return kFunctionImpl.getContainer().findFunctionDescriptor(str, kFunctionImpl.signature);
    }

    public java.lang.Object default$invoke(java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3, java.lang.Object obj4, java.lang.Object obj5, java.lang.Object obj6, java.lang.Object obj7, java.lang.Object obj8, java.lang.Object obj9, java.lang.Object obj10, java.lang.Object obj11, java.lang.Object obj12, java.lang.Object obj13) {
        return call(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13);
    }

    public java.lang.Object default$invoke(java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3, java.lang.Object obj4, java.lang.Object obj5, java.lang.Object obj6, java.lang.Object obj7, java.lang.Object obj8, java.lang.Object obj9, java.lang.Object obj10, java.lang.Object obj11, java.lang.Object obj12, java.lang.Object obj13, java.lang.Object obj14) {
        return call(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14);
    }

    public java.lang.Object default$invoke(java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3, java.lang.Object obj4, java.lang.Object obj5, java.lang.Object obj6, java.lang.Object obj7, java.lang.Object obj8, java.lang.Object obj9, java.lang.Object obj10, java.lang.Object obj11, java.lang.Object obj12, java.lang.Object obj13, java.lang.Object obj14, java.lang.Object obj15) {
        return call(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15);
    }

    public java.lang.Object default$invoke(java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3, java.lang.Object obj4, java.lang.Object obj5, java.lang.Object obj6, java.lang.Object obj7, java.lang.Object obj8, java.lang.Object obj9, java.lang.Object obj10, java.lang.Object obj11, java.lang.Object obj12, java.lang.Object obj13, java.lang.Object obj14, java.lang.Object obj15, java.lang.Object obj16) {
        return call(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16);
    }

    @Override // kotlin.reflect.KCallable
    public java.lang.String getName() {
        java.lang.String strAsString = getDescriptor().getName().asString();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strAsString, "asString(...)");
        return strAsString;
    }

    public java.lang.Object default$invoke(java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3, java.lang.Object obj4, java.lang.Object obj5, java.lang.Object obj6, java.lang.Object obj7, java.lang.Object obj8, java.lang.Object obj9, java.lang.Object obj10, java.lang.Object obj11, java.lang.Object obj12, java.lang.Object obj13, java.lang.Object obj14, java.lang.Object obj15, java.lang.Object obj16, java.lang.Object obj17) {
        return call(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17);
    }

    public java.lang.Object default$invoke(java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3, java.lang.Object obj4, java.lang.Object obj5, java.lang.Object obj6, java.lang.Object obj7, java.lang.Object obj8, java.lang.Object obj9, java.lang.Object obj10, java.lang.Object obj11, java.lang.Object obj12, java.lang.Object obj13, java.lang.Object obj14, java.lang.Object obj15, java.lang.Object obj16, java.lang.Object obj17, java.lang.Object obj18) {
        return call(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18);
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    public kotlin.reflect.jvm.internal.calls.Caller<?> getCaller() {
        return (kotlin.reflect.jvm.internal.calls.Caller) this.caller.getValue();
    }

    public java.lang.Object default$invoke(java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3, java.lang.Object obj4, java.lang.Object obj5, java.lang.Object obj6, java.lang.Object obj7, java.lang.Object obj8, java.lang.Object obj9, java.lang.Object obj10, java.lang.Object obj11, java.lang.Object obj12, java.lang.Object obj13, java.lang.Object obj14, java.lang.Object obj15, java.lang.Object obj16, java.lang.Object obj17, java.lang.Object obj18, java.lang.Object obj19) {
        return call(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18, obj19);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.calls.Caller caller_delegate$lambda$4(kotlin.reflect.jvm.internal.KFunctionImpl kFunctionImpl) {
        java.lang.reflect.Constructor<?> constructorFindMethodBySignature;
        kotlin.reflect.jvm.internal.calls.CallerImpl.Method methodCreateStaticMethodCaller;
        kotlin.reflect.jvm.internal.JvmFunctionSignature jvmFunctionSignatureMapSignature = kotlin.reflect.jvm.internal.RuntimeTypeMapper.INSTANCE.mapSignature(kFunctionImpl.getDescriptor());
        if (jvmFunctionSignatureMapSignature instanceof kotlin.reflect.jvm.internal.JvmFunctionSignature.KotlinConstructor) {
            if (kFunctionImpl.isAnnotationConstructor()) {
                java.lang.Class<?> jClass = kFunctionImpl.getContainer().getJClass();
                java.util.List<kotlin.reflect.KParameter> parameters = kFunctionImpl.getParameters();
                java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(parameters, 10));
                java.util.Iterator<T> it = parameters.iterator();
                while (it.hasNext()) {
                    java.lang.String name = ((kotlin.reflect.KParameter) it.next()).getName();
                    kotlin.jvm.internal.Intrinsics.checkNotNull(name);
                    arrayList.add(name);
                }
                return new kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller(jClass, arrayList, kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller.CallMode.POSITIONAL_CALL, kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller.Origin.KOTLIN, null, 16, null);
            }
            constructorFindMethodBySignature = kFunctionImpl.getContainer().findConstructorBySignature(((kotlin.reflect.jvm.internal.JvmFunctionSignature.KotlinConstructor) jvmFunctionSignatureMapSignature).getConstructorDesc());
        } else if (jvmFunctionSignatureMapSignature instanceof kotlin.reflect.jvm.internal.JvmFunctionSignature.KotlinFunction) {
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor descriptor = kFunctionImpl.getDescriptor();
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor containingDeclaration = descriptor.getContainingDeclaration();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(containingDeclaration, "getContainingDeclaration(...)");
            if (kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt.isMultiFieldValueClass(containingDeclaration) && (descriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor) && ((kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor) descriptor).isPrimary()) {
                kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor descriptor2 = kFunctionImpl.getDescriptor();
                kotlin.reflect.jvm.internal.KDeclarationContainerImpl container = kFunctionImpl.getContainer();
                java.lang.String methodDesc = ((kotlin.reflect.jvm.internal.JvmFunctionSignature.KotlinFunction) jvmFunctionSignatureMapSignature).getMethodDesc();
                java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> valueParameters = kFunctionImpl.getDescriptor().getValueParameters();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(valueParameters, "getValueParameters(...)");
                return new kotlin.reflect.jvm.internal.calls.ValueClassAwareCaller.MultiFieldValueClassPrimaryConstructorCaller(descriptor2, container, methodDesc, valueParameters);
            }
            kotlin.reflect.jvm.internal.JvmFunctionSignature.KotlinFunction kotlinFunction = (kotlin.reflect.jvm.internal.JvmFunctionSignature.KotlinFunction) jvmFunctionSignatureMapSignature;
            constructorFindMethodBySignature = kFunctionImpl.getContainer().findMethodBySignature(kotlinFunction.getMethodName(), kotlinFunction.getMethodDesc());
        } else if (jvmFunctionSignatureMapSignature instanceof kotlin.reflect.jvm.internal.JvmFunctionSignature.JavaMethod) {
            java.lang.reflect.Method method = ((kotlin.reflect.jvm.internal.JvmFunctionSignature.JavaMethod) jvmFunctionSignatureMapSignature).getMethod();
            kotlin.jvm.internal.Intrinsics.checkNotNull(method, "null cannot be cast to non-null type java.lang.reflect.Member");
            constructorFindMethodBySignature = method;
        } else {
            if (!(jvmFunctionSignatureMapSignature instanceof kotlin.reflect.jvm.internal.JvmFunctionSignature.JavaConstructor)) {
                if (!(jvmFunctionSignatureMapSignature instanceof kotlin.reflect.jvm.internal.JvmFunctionSignature.FakeJavaAnnotationConstructor)) {
                    throw new kotlin.NoWhenBranchMatchedException();
                }
                java.util.List<java.lang.reflect.Method> methods = ((kotlin.reflect.jvm.internal.JvmFunctionSignature.FakeJavaAnnotationConstructor) jvmFunctionSignatureMapSignature).getMethods();
                java.lang.Class<?> jClass2 = kFunctionImpl.getContainer().getJClass();
                java.util.List<java.lang.reflect.Method> list = methods;
                java.util.ArrayList arrayList2 = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(list, 10));
                java.util.Iterator<T> it2 = list.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(((java.lang.reflect.Method) it2.next()).getName());
                }
                return new kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller(jClass2, arrayList2, kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller.CallMode.POSITIONAL_CALL, kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller.Origin.JAVA, methods);
            }
            java.lang.reflect.Constructor<?> constructor = ((kotlin.reflect.jvm.internal.JvmFunctionSignature.JavaConstructor) jvmFunctionSignatureMapSignature).getConstructor();
            kotlin.jvm.internal.Intrinsics.checkNotNull(constructor, "null cannot be cast to non-null type java.lang.reflect.Member");
            constructorFindMethodBySignature = constructor;
        }
        if (constructorFindMethodBySignature instanceof java.lang.reflect.Constructor) {
            methodCreateStaticMethodCaller = kFunctionImpl.createConstructorCaller((java.lang.reflect.Constructor) constructorFindMethodBySignature, kFunctionImpl.getDescriptor(), false);
        } else if (constructorFindMethodBySignature instanceof java.lang.reflect.Method) {
            java.lang.reflect.Method method2 = (java.lang.reflect.Method) constructorFindMethodBySignature;
            if (!java.lang.reflect.Modifier.isStatic(method2.getModifiers())) {
                methodCreateStaticMethodCaller = kFunctionImpl.createInstanceMethodCaller(method2);
            } else if (kFunctionImpl.getDescriptor().getAnnotations().mo1826findAnnotation(kotlin.reflect.jvm.internal.UtilKt.getJVM_STATIC()) != null) {
                methodCreateStaticMethodCaller = kFunctionImpl.createJvmStaticInObjectCaller(method2);
            } else {
                methodCreateStaticMethodCaller = kFunctionImpl.createStaticMethodCaller(method2, false);
            }
        } else {
            throw new kotlin.reflect.jvm.internal.KotlinReflectionInternalError("Could not compute caller for function: " + kFunctionImpl.getDescriptor() + " (member = " + constructorFindMethodBySignature + com.taobao.weex.el.parse.Operators.BRACKET_END);
        }
        return kotlin.reflect.jvm.internal.calls.ValueClassAwareCallerKt.createValueClassAwareCallerIfNeeded$default(methodCreateStaticMethodCaller, kFunctionImpl.getDescriptor(), false, 2, null);
    }

    public java.lang.Object default$invoke(java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3, java.lang.Object obj4, java.lang.Object obj5, java.lang.Object obj6, java.lang.Object obj7, java.lang.Object obj8, java.lang.Object obj9, java.lang.Object obj10, java.lang.Object obj11, java.lang.Object obj12, java.lang.Object obj13, java.lang.Object obj14, java.lang.Object obj15, java.lang.Object obj16, java.lang.Object obj17, java.lang.Object obj18, java.lang.Object obj19, java.lang.Object obj20) {
        return call(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18, obj19, obj20);
    }

    public java.lang.Object default$invoke(java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3, java.lang.Object obj4, java.lang.Object obj5, java.lang.Object obj6, java.lang.Object obj7, java.lang.Object obj8, java.lang.Object obj9, java.lang.Object obj10, java.lang.Object obj11, java.lang.Object obj12, java.lang.Object obj13, java.lang.Object obj14, java.lang.Object obj15, java.lang.Object obj16, java.lang.Object obj17, java.lang.Object obj18, java.lang.Object obj19, java.lang.Object obj20, java.lang.Object obj21) {
        return call(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18, obj19, obj20, obj21);
    }

    public java.lang.Object default$invoke(java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3, java.lang.Object obj4, java.lang.Object obj5, java.lang.Object obj6, java.lang.Object obj7, java.lang.Object obj8, java.lang.Object obj9, java.lang.Object obj10, java.lang.Object obj11, java.lang.Object obj12, java.lang.Object obj13, java.lang.Object obj14, java.lang.Object obj15, java.lang.Object obj16, java.lang.Object obj17, java.lang.Object obj18, java.lang.Object obj19, java.lang.Object obj20, java.lang.Object obj21, java.lang.Object obj22) {
        return call(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18, obj19, obj20, obj21, obj22);
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    public kotlin.reflect.jvm.internal.calls.Caller<?> getDefaultCaller() {
        return (kotlin.reflect.jvm.internal.calls.Caller) this.defaultCaller.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:47:0x0195  */
    public static final kotlin.reflect.jvm.internal.calls.Caller defaultCaller_delegate$lambda$10(kotlin.reflect.jvm.internal.KFunctionImpl kFunctionImpl) {
        java.lang.reflect.Constructor<?> constructorFindDefaultConstructor;
        kotlin.reflect.jvm.internal.calls.CallerImpl.Method methodCreateStaticMethodCaller;
        kotlin.reflect.jvm.internal.JvmFunctionSignature jvmFunctionSignatureMapSignature = kotlin.reflect.jvm.internal.RuntimeTypeMapper.INSTANCE.mapSignature(kFunctionImpl.getDescriptor());
        if (jvmFunctionSignatureMapSignature instanceof kotlin.reflect.jvm.internal.JvmFunctionSignature.KotlinFunction) {
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor descriptor = kFunctionImpl.getDescriptor();
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor containingDeclaration = descriptor.getContainingDeclaration();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(containingDeclaration, "getContainingDeclaration(...)");
            if (kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt.isMultiFieldValueClass(containingDeclaration) && (descriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor) && ((kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor) descriptor).isPrimary()) {
                throw new kotlin.reflect.jvm.internal.KotlinReflectionInternalError(kFunctionImpl.getDescriptor().getContainingDeclaration() + " cannot have default arguments");
            }
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor functionWithDefaultParametersForValueClassOverride = kFunctionImpl.getFunctionWithDefaultParametersForValueClassOverride(kFunctionImpl.getDescriptor());
            if (functionWithDefaultParametersForValueClassOverride != null) {
                kotlin.reflect.jvm.internal.JvmFunctionSignature jvmFunctionSignatureMapSignature2 = kotlin.reflect.jvm.internal.RuntimeTypeMapper.INSTANCE.mapSignature(functionWithDefaultParametersForValueClassOverride);
                kotlin.jvm.internal.Intrinsics.checkNotNull(jvmFunctionSignatureMapSignature2, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.JvmFunctionSignature.KotlinFunction");
                kotlin.reflect.jvm.internal.JvmFunctionSignature.KotlinFunction kotlinFunction = (kotlin.reflect.jvm.internal.JvmFunctionSignature.KotlinFunction) jvmFunctionSignatureMapSignature2;
                constructorFindDefaultConstructor = kFunctionImpl.getContainer().findDefaultMethod(kotlinFunction.getMethodName(), kotlinFunction.getMethodDesc(), true);
            } else {
                kotlin.reflect.jvm.internal.KDeclarationContainerImpl container = kFunctionImpl.getContainer();
                kotlin.reflect.jvm.internal.JvmFunctionSignature.KotlinFunction kotlinFunction2 = (kotlin.reflect.jvm.internal.JvmFunctionSignature.KotlinFunction) jvmFunctionSignatureMapSignature;
                java.lang.String methodName = kotlinFunction2.getMethodName();
                java.lang.String methodDesc = kotlinFunction2.getMethodDesc();
                java.lang.reflect.Member memberMo1823getMember = kFunctionImpl.getCaller().mo1823getMember();
                kotlin.jvm.internal.Intrinsics.checkNotNull(memberMo1823getMember);
                constructorFindDefaultConstructor = container.findDefaultMethod(methodName, methodDesc, !java.lang.reflect.Modifier.isStatic(memberMo1823getMember.getModifiers()));
            }
        } else if (jvmFunctionSignatureMapSignature instanceof kotlin.reflect.jvm.internal.JvmFunctionSignature.KotlinConstructor) {
            if (kFunctionImpl.isAnnotationConstructor()) {
                java.lang.Class<?> jClass = kFunctionImpl.getContainer().getJClass();
                java.util.List<kotlin.reflect.KParameter> parameters = kFunctionImpl.getParameters();
                java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(parameters, 10));
                java.util.Iterator<T> it = parameters.iterator();
                while (it.hasNext()) {
                    java.lang.String name = ((kotlin.reflect.KParameter) it.next()).getName();
                    kotlin.jvm.internal.Intrinsics.checkNotNull(name);
                    arrayList.add(name);
                }
                return new kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller(jClass, arrayList, kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller.CallMode.CALL_BY_NAME, kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller.Origin.KOTLIN, null, 16, null);
            }
            constructorFindDefaultConstructor = kFunctionImpl.getContainer().findDefaultConstructor(((kotlin.reflect.jvm.internal.JvmFunctionSignature.KotlinConstructor) jvmFunctionSignatureMapSignature).getConstructorDesc());
        } else {
            if (jvmFunctionSignatureMapSignature instanceof kotlin.reflect.jvm.internal.JvmFunctionSignature.FakeJavaAnnotationConstructor) {
                java.util.List<java.lang.reflect.Method> methods = ((kotlin.reflect.jvm.internal.JvmFunctionSignature.FakeJavaAnnotationConstructor) jvmFunctionSignatureMapSignature).getMethods();
                java.lang.Class<?> jClass2 = kFunctionImpl.getContainer().getJClass();
                java.util.List<java.lang.reflect.Method> list = methods;
                java.util.ArrayList arrayList2 = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(list, 10));
                java.util.Iterator<T> it2 = list.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(((java.lang.reflect.Method) it2.next()).getName());
                }
                return new kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller(jClass2, arrayList2, kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller.CallMode.CALL_BY_NAME, kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller.Origin.JAVA, methods);
            }
            constructorFindDefaultConstructor = null;
        }
        if (constructorFindDefaultConstructor instanceof java.lang.reflect.Constructor) {
            methodCreateStaticMethodCaller = kFunctionImpl.createConstructorCaller((java.lang.reflect.Constructor) constructorFindDefaultConstructor, kFunctionImpl.getDescriptor(), true);
        } else if (!(constructorFindDefaultConstructor instanceof java.lang.reflect.Method)) {
            methodCreateStaticMethodCaller = null;
        } else if (kFunctionImpl.getDescriptor().getAnnotations().mo1826findAnnotation(kotlin.reflect.jvm.internal.UtilKt.getJVM_STATIC()) != null) {
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor containingDeclaration2 = kFunctionImpl.getDescriptor().getContainingDeclaration();
            kotlin.jvm.internal.Intrinsics.checkNotNull(containingDeclaration2, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            if (!((kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) containingDeclaration2).isCompanionObject()) {
                methodCreateStaticMethodCaller = kFunctionImpl.createJvmStaticInObjectCaller((java.lang.reflect.Method) constructorFindDefaultConstructor);
            } else {
                methodCreateStaticMethodCaller = kFunctionImpl.createStaticMethodCaller((java.lang.reflect.Method) constructorFindDefaultConstructor, kFunctionImpl.getCaller().isBoundInstanceCallWithValueClasses());
            }
        } else {
            methodCreateStaticMethodCaller = kFunctionImpl.createStaticMethodCaller((java.lang.reflect.Method) constructorFindDefaultConstructor, kFunctionImpl.getCaller().isBoundInstanceCallWithValueClasses());
        }
        if (methodCreateStaticMethodCaller != null) {
            return kotlin.reflect.jvm.internal.calls.ValueClassAwareCallerKt.createValueClassAwareCallerIfNeeded(methodCreateStaticMethodCaller, kFunctionImpl.getDescriptor(), true);
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0041  */
    /* JADX WARN: Code duplicated, block: B:17:0x0056  */
    /* JADX WARN: Code duplicated, block: B:20:0x0067  */
    /* JADX WARN: Code duplicated, block: B:28:0x008f  */
    /* JADX WARN: Code duplicated, block: B:34:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:37:0x009c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:40:0x009d A[EDGE_INSN: B:40:0x009d->B:32:0x009d BREAK  A[LOOP:0: B:18:0x0061->B:41:0x0061, LOOP_LABEL: LOOP:0: B:18:0x0061->B:41:0x0061], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:44:? A[LOOP:1: B:26:0x0089->B:44:?, LOOP_END, SYNTHETIC] */
    private final kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor getFunctionWithDefaultParametersForValueClassOverride(kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor descriptor) {
        kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor containingDeclaration;
        java.lang.reflect.Member memberMo1823getMember;
        java.util.Iterator<kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor> it;
        kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor next;
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> list;
        java.util.Iterator<T> it2;
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> valueParameters = descriptor.getValueParameters();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(valueParameters, "getValueParameters(...)");
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> list2 = valueParameters;
        if ((list2 instanceof java.util.Collection) && list2.isEmpty()) {
            containingDeclaration = descriptor.getContainingDeclaration();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(containingDeclaration, "getContainingDeclaration(...)");
            if (kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt.isValueClass(containingDeclaration)) {
                memberMo1823getMember = getCaller().mo1823getMember();
                kotlin.jvm.internal.Intrinsics.checkNotNull(memberMo1823getMember);
                if (java.lang.reflect.Modifier.isStatic(memberMo1823getMember.getModifiers())) {
                    it = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.overriddenTreeAsSequence(descriptor, false).iterator();
                    loop0: while (true) {
                        if (it.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it.next();
                        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> valueParameters2 = next.getValueParameters();
                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(valueParameters2, "getValueParameters(...)");
                        list = valueParameters2;
                        if (list instanceof java.util.Collection) {
                        }
                        it2 = list.iterator();
                        while (it2.hasNext()) {
                            if (((kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) it2.next()).declaresDefaultValue()) {
                                break loop0;
                                break loop0;
                            }
                        }
                    }
                    if (next instanceof kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) {
                        return (kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) next;
                    }
                }
            }
        } else {
            java.util.Iterator<T> it3 = list2.iterator();
            while (it3.hasNext()) {
                if (((kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) it3.next()).declaresDefaultValue()) {
                }
            }
            containingDeclaration = descriptor.getContainingDeclaration();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(containingDeclaration, "getContainingDeclaration(...)");
            if (kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt.isValueClass(containingDeclaration)) {
                memberMo1823getMember = getCaller().mo1823getMember();
                kotlin.jvm.internal.Intrinsics.checkNotNull(memberMo1823getMember);
                if (java.lang.reflect.Modifier.isStatic(memberMo1823getMember.getModifiers())) {
                    it = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.overriddenTreeAsSequence(descriptor, false).iterator();
                    loop0: while (true) {
                        if (it.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it.next();
                        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> valueParameters3 = next.getValueParameters();
                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(valueParameters3, "getValueParameters(...)");
                        list = valueParameters3;
                        if ((list instanceof java.util.Collection) || !list.isEmpty()) {
                            it2 = list.iterator();
                            while (it2.hasNext()) {
                                if (((kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) it2.next()).declaresDefaultValue()) {
                                    break loop0;
                                }
                            }
                        }
                    }
                    if (next instanceof kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) {
                        return (kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) next;
                    }
                }
            }
        }
        return null;
    }

    private final java.lang.Object getBoundReceiver() {
        return kotlin.reflect.jvm.internal.calls.ValueClassAwareCallerKt.coerceToExpectedReceiverType(this.rawBoundReceiver, getDescriptor());
    }

    private final boolean useBoxedBoundReceiver(java.lang.reflect.Method member) {
        kotlin.reflect.jvm.internal.impl.types.KotlinType type;
        kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor dispatchReceiverParameter = getDescriptor().getDispatchReceiverParameter();
        if (dispatchReceiverParameter == null || (type = dispatchReceiverParameter.getType()) == null || !kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt.isInlineClassType(type)) {
            return false;
        }
        java.lang.Class<?>[] parameterTypes = member.getParameterTypes();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(parameterTypes, "getParameterTypes(...)");
        java.lang.Class cls = (java.lang.Class) kotlin.collections.ArraysKt.firstOrNull(parameterTypes);
        return cls != null && cls.isInterface();
    }

    private final kotlin.reflect.jvm.internal.calls.Caller<?> createStaticMethodCaller(java.lang.reflect.Method member, boolean isCallByToValueClassMangledMethod) {
        if (isBound()) {
            return new kotlin.reflect.jvm.internal.calls.CallerImpl.Method.BoundStatic(member, isCallByToValueClassMangledMethod, useBoxedBoundReceiver(member) ? this.rawBoundReceiver : getBoundReceiver());
        }
        return new kotlin.reflect.jvm.internal.calls.CallerImpl.Method.Static(member);
    }

    private final kotlin.reflect.jvm.internal.calls.CallerImpl.Method createJvmStaticInObjectCaller(java.lang.reflect.Method member) {
        return isBound() ? new kotlin.reflect.jvm.internal.calls.CallerImpl.Method.BoundJvmStaticInObject(member) : new kotlin.reflect.jvm.internal.calls.CallerImpl.Method.JvmStaticInObject(member);
    }

    private final kotlin.reflect.jvm.internal.calls.CallerImpl.Method createInstanceMethodCaller(java.lang.reflect.Method member) {
        return isBound() ? new kotlin.reflect.jvm.internal.calls.CallerImpl.Method.BoundInstance(member, getBoundReceiver()) : new kotlin.reflect.jvm.internal.calls.CallerImpl.Method.Instance(member);
    }

    private final kotlin.reflect.jvm.internal.calls.CallerImpl<java.lang.reflect.Constructor<?>> createConstructorCaller(java.lang.reflect.Constructor<?> member, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor descriptor, boolean isDefault) {
        if (!isDefault && kotlin.reflect.jvm.internal.impl.resolve.jvm.InlineClassManglingRulesKt.shouldHideConstructorDueToValueClassTypeValueParameters(descriptor)) {
            if (isBound()) {
                return new kotlin.reflect.jvm.internal.calls.CallerImpl.AccessorForHiddenBoundConstructor(member, getBoundReceiver());
            }
            return new kotlin.reflect.jvm.internal.calls.CallerImpl.AccessorForHiddenConstructor(member);
        }
        if (isBound()) {
            return new kotlin.reflect.jvm.internal.calls.CallerImpl.BoundConstructor(member, getBoundReceiver());
        }
        return new kotlin.reflect.jvm.internal.calls.CallerImpl.Constructor(member);
    }

    @Override // kotlin.jvm.internal.FunctionBase
    public int getArity() {
        return kotlin.reflect.jvm.internal.calls.CallerKt.getArity(getCaller());
    }

    @Override // kotlin.reflect.KFunction
    public boolean isInline() {
        return getDescriptor().isInline();
    }

    @Override // kotlin.reflect.KFunction
    public boolean isExternal() {
        return getDescriptor().isExternal();
    }

    @Override // kotlin.reflect.KFunction
    public boolean isOperator() {
        return getDescriptor().isOperator();
    }

    @Override // kotlin.reflect.KFunction
    public boolean isInfix() {
        return getDescriptor().isInfix();
    }

    @Override // kotlin.reflect.KCallable
    public boolean isSuspend() {
        return getDescriptor().isSuspend();
    }

    public boolean equals(java.lang.Object other) {
        kotlin.reflect.jvm.internal.KFunctionImpl kFunctionImplAsKFunctionImpl = kotlin.reflect.jvm.internal.UtilKt.asKFunctionImpl(other);
        return kFunctionImplAsKFunctionImpl != null && kotlin.jvm.internal.Intrinsics.areEqual(getContainer(), kFunctionImplAsKFunctionImpl.getContainer()) && kotlin.jvm.internal.Intrinsics.areEqual(getName(), kFunctionImplAsKFunctionImpl.getName()) && kotlin.jvm.internal.Intrinsics.areEqual(this.signature, kFunctionImplAsKFunctionImpl.signature) && kotlin.jvm.internal.Intrinsics.areEqual(this.rawBoundReceiver, kFunctionImplAsKFunctionImpl.rawBoundReceiver);
    }

    public int hashCode() {
        return (((getContainer().hashCode() * 31) + getName().hashCode()) * 31) + this.signature.hashCode();
    }

    public java.lang.String toString() {
        return kotlin.reflect.jvm.internal.ReflectionObjectRenderer.INSTANCE.renderFunction(getDescriptor());
    }
}
