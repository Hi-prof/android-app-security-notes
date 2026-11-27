package kotlin.reflect.jvm.internal;

/* JADX INFO: compiled from: KPropertyImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0006\b \u0018\u0000 C*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0004@ABCB5\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eB+\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u0010B\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u0012J\n\u0010#\u001a\u0004\u0018\u00010$H\u0004J(\u0010%\u001a\u0004\u0018\u00010\f2\b\u0010&\u001a\u0004\u0018\u00010$2\b\u0010'\u001a\u0004\u0018\u00010\f2\b\u0010(\u001a\u0004\u0018\u00010\fH\u0004J\u0013\u0010;\u001a\u00020\u001b2\b\u0010<\u001a\u0004\u0018\u00010\fH\u0096\u0002J\b\u0010=\u001a\u00020>H\u0016J\b\u0010?\u001a\u00020\u0007H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\f8F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001cR\u0016\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010 \u001a\u0004\u0018\u00010\u001f8F¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0018\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00000*X¦\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u001c\u0010-\u001a\u0010\u0012\f\u0012\n /*\u0004\u0018\u00010\n0\n0.X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u0018\u00102\u001a\u0006\u0012\u0002\b\u0003038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b4\u00105R\u001a\u00106\u001a\b\u0012\u0002\b\u0003\u0018\u0001038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b7\u00105R\u0014\u00108\u001a\u00020\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b8\u0010\u001cR\u0014\u00109\u001a\u00020\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b9\u0010\u001cR\u0014\u0010:\u001a\u00020\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b:\u0010\u001c¨\u0006D"}, d2 = {"Lkotlin/reflect/jvm/internal/KPropertyImpl;", "V", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "Lkotlin/reflect/KProperty;", com.taobao.weex.ui.component.WXBasicComponentType.CONTAINER, "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "name", "", "signature", "descriptorInitialValue", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "rawBoundReceiver", "", "<init>", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;Ljava/lang/Object;)V", "boundReceiver", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "descriptor", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "getName", "()Ljava/lang/String;", "getSignature", "getBoundReceiver", "()Ljava/lang/Object;", "isBound", "", "()Z", "_javaField", "Lkotlin/Lazy;", "Ljava/lang/reflect/Field;", "javaField", "getJavaField", "()Ljava/lang/reflect/Field;", "computeDelegateSource", "Ljava/lang/reflect/Member;", "getDelegateImpl", "fieldOrMethod", "receiver1", "receiver2", "getter", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "getGetter", "()Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "_descriptor", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "kotlin.jvm.PlatformType", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "defaultCaller", "getDefaultCaller", "isLateinit", "isConst", "isSuspend", "equals", "other", "hashCode", "", "toString", "Accessor", "Getter", "Setter", "Companion", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class KPropertyImpl<V> extends kotlin.reflect.jvm.internal.KCallableImpl<V> implements kotlin.reflect.KProperty<V> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final kotlin.reflect.jvm.internal.KPropertyImpl.Companion INSTANCE = new kotlin.reflect.jvm.internal.KPropertyImpl.Companion(null);
    private static final java.lang.Object EXTENSION_PROPERTY_DELEGATE = new java.lang.Object();
    private final kotlin.reflect.jvm.internal.ReflectProperties.LazySoftVal<kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor> _descriptor;
    private final kotlin.Lazy<java.lang.reflect.Field> _javaField;
    private final kotlin.reflect.jvm.internal.KDeclarationContainerImpl container;
    private final java.lang.String name;
    private final java.lang.Object rawBoundReceiver;
    private final java.lang.String signature;

    public abstract kotlin.reflect.jvm.internal.KPropertyImpl.Getter<V> getGetter();

    @Override // kotlin.reflect.KCallable
    public boolean isSuspend() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    public kotlin.reflect.jvm.internal.KDeclarationContainerImpl getContainer() {
        return this.container;
    }

    @Override // kotlin.reflect.KCallable
    public java.lang.String getName() {
        return this.name;
    }

    public final java.lang.String getSignature() {
        return this.signature;
    }

    private KPropertyImpl(kotlin.reflect.jvm.internal.KDeclarationContainerImpl kDeclarationContainerImpl, java.lang.String str, java.lang.String str2, kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor propertyDescriptor, java.lang.Object obj) {
        this.container = kDeclarationContainerImpl;
        this.name = str;
        this.signature = str2;
        this.rawBoundReceiver = obj;
        this._javaField = kotlin.LazyKt.lazy(kotlin.LazyThreadSafetyMode.PUBLICATION, new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.KPropertyImpl$$Lambda$0
            private final kotlin.reflect.jvm.internal.KPropertyImpl arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.KPropertyImpl._javaField$lambda$2(this.arg$0);
            }
        });
        kotlin.reflect.jvm.internal.ReflectProperties.LazySoftVal<kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor> lazySoftValLazySoft = kotlin.reflect.jvm.internal.ReflectProperties.lazySoft(propertyDescriptor, new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.KPropertyImpl$$Lambda$1
            private final kotlin.reflect.jvm.internal.KPropertyImpl arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.KPropertyImpl._descriptor$lambda$5(this.arg$0);
            }
        });
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(lazySoftValLazySoft, "lazySoft(...)");
        this._descriptor = lazySoftValLazySoft;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public KPropertyImpl(kotlin.reflect.jvm.internal.KDeclarationContainerImpl container, java.lang.String name, java.lang.String signature, java.lang.Object obj) {
        this(container, name, signature, null, obj);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(container, "container");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(signature, "signature");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public KPropertyImpl(kotlin.reflect.jvm.internal.KDeclarationContainerImpl container, kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor descriptor) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(container, "container");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        java.lang.String strAsString = descriptor.getName().asString();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strAsString, "asString(...)");
        this(container, strAsString, kotlin.reflect.jvm.internal.RuntimeTypeMapper.INSTANCE.mapPropertySignature(descriptor).getString(), descriptor, kotlin.jvm.internal.CallableReference.NO_RECEIVER);
    }

    public final java.lang.Object getBoundReceiver() {
        return kotlin.reflect.jvm.internal.calls.ValueClassAwareCallerKt.coerceToExpectedReceiverType(this.rawBoundReceiver, getDescriptor());
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    public boolean isBound() {
        return this.rawBoundReceiver != kotlin.jvm.internal.CallableReference.NO_RECEIVER;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.lang.reflect.Field _javaField$lambda$2(kotlin.reflect.jvm.internal.KPropertyImpl kPropertyImpl) {
        java.lang.Class<?> enclosingClass;
        kotlin.reflect.jvm.internal.JvmPropertySignature jvmPropertySignatureMapPropertySignature = kotlin.reflect.jvm.internal.RuntimeTypeMapper.INSTANCE.mapPropertySignature(kPropertyImpl.getDescriptor());
        if (jvmPropertySignatureMapPropertySignature instanceof kotlin.reflect.jvm.internal.JvmPropertySignature.KotlinProperty) {
            kotlin.reflect.jvm.internal.JvmPropertySignature.KotlinProperty kotlinProperty = (kotlin.reflect.jvm.internal.JvmPropertySignature.KotlinProperty) jvmPropertySignatureMapPropertySignature;
            kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor descriptor = kotlinProperty.getDescriptor();
            kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature.Field jvmFieldSignature$default = kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil.getJvmFieldSignature$default(kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil.INSTANCE, kotlinProperty.getProto(), kotlinProperty.getNameResolver(), kotlinProperty.getTypeTable(), false, 8, null);
            if (jvmFieldSignature$default == null) {
                return null;
            }
            if (kotlin.reflect.jvm.internal.impl.load.java.DescriptorsJvmAbiUtil.isPropertyWithBackingFieldInOuterClass(descriptor) || kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil.isMovedFromInterfaceCompanion(kotlinProperty.getProto())) {
                enclosingClass = kPropertyImpl.getContainer().getJClass().getEnclosingClass();
            } else {
                kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor containingDeclaration = descriptor.getContainingDeclaration();
                enclosingClass = containingDeclaration instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor ? kotlin.reflect.jvm.internal.UtilKt.toJavaClass((kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) containingDeclaration) : kPropertyImpl.getContainer().getJClass();
            }
            if (enclosingClass == null) {
                return null;
            }
            try {
                return enclosingClass.getDeclaredField(jvmFieldSignature$default.getName());
            } catch (java.lang.NoSuchFieldException unused) {
                return null;
            }
        }
        if (jvmPropertySignatureMapPropertySignature instanceof kotlin.reflect.jvm.internal.JvmPropertySignature.JavaField) {
            return ((kotlin.reflect.jvm.internal.JvmPropertySignature.JavaField) jvmPropertySignatureMapPropertySignature).getField();
        }
        if ((jvmPropertySignatureMapPropertySignature instanceof kotlin.reflect.jvm.internal.JvmPropertySignature.JavaMethodProperty) || (jvmPropertySignatureMapPropertySignature instanceof kotlin.reflect.jvm.internal.JvmPropertySignature.MappedKotlinProperty)) {
            return null;
        }
        throw new kotlin.NoWhenBranchMatchedException();
    }

    public final java.lang.reflect.Field getJavaField() {
        return this._javaField.getValue();
    }

    protected final java.lang.reflect.Member computeDelegateSource() {
        if (!getDescriptor().isDelegated()) {
            return null;
        }
        kotlin.reflect.jvm.internal.JvmPropertySignature jvmPropertySignatureMapPropertySignature = kotlin.reflect.jvm.internal.RuntimeTypeMapper.INSTANCE.mapPropertySignature(getDescriptor());
        if (jvmPropertySignatureMapPropertySignature instanceof kotlin.reflect.jvm.internal.JvmPropertySignature.KotlinProperty) {
            kotlin.reflect.jvm.internal.JvmPropertySignature.KotlinProperty kotlinProperty = (kotlin.reflect.jvm.internal.JvmPropertySignature.KotlinProperty) jvmPropertySignatureMapPropertySignature;
            if (kotlinProperty.getSignature().hasDelegateMethod()) {
                kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmMethodSignature delegateMethod = kotlinProperty.getSignature().getDelegateMethod();
                if (!delegateMethod.hasName() || !delegateMethod.hasDesc()) {
                    return null;
                }
                return getContainer().findMethodBySignature(kotlinProperty.getNameResolver().getString(delegateMethod.getName()), kotlinProperty.getNameResolver().getString(delegateMethod.getDesc()));
            }
        }
        return getJavaField();
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected final java.lang.Object getDelegateImpl(java.lang.reflect.Member fieldOrMethod, java.lang.Object receiver1, java.lang.Object receiver2) throws kotlin.reflect.full.IllegalPropertyDelegateAccessException {
        try {
            java.lang.Object obj = EXTENSION_PROPERTY_DELEGATE;
            if ((receiver1 == obj || receiver2 == obj) && getDescriptor().getExtensionReceiverParameter() == null) {
                throw new java.lang.RuntimeException("'" + this + "' is not an extension property and thus getExtensionDelegate() is not going to work, use getDelegate() instead");
            }
            java.lang.Object boundReceiver = isBound() ? getBoundReceiver() : receiver1;
            if (boundReceiver == obj) {
                boundReceiver = null;
            }
            if (!isBound()) {
                receiver1 = receiver2;
            }
            if (receiver1 == obj) {
                receiver1 = null;
            }
            java.lang.reflect.AccessibleObject accessibleObject = fieldOrMethod instanceof java.lang.reflect.AccessibleObject ? (java.lang.reflect.AccessibleObject) fieldOrMethod : null;
            if (accessibleObject != null) {
                accessibleObject.setAccessible(kotlin.reflect.jvm.KCallablesJvm.isAccessible(this));
            }
            if (fieldOrMethod == 0) {
                return null;
            }
            if (fieldOrMethod instanceof java.lang.reflect.Field) {
                return ((java.lang.reflect.Field) fieldOrMethod).get(boundReceiver);
            }
            if (!(fieldOrMethod instanceof java.lang.reflect.Method)) {
                throw new java.lang.AssertionError("delegate field/method " + fieldOrMethod + " neither field nor method");
            }
            int length = ((java.lang.reflect.Method) fieldOrMethod).getParameterTypes().length;
            if (length == 0) {
                return ((java.lang.reflect.Method) fieldOrMethod).invoke(null, null);
            }
            if (length == 1) {
                java.lang.reflect.Method method = (java.lang.reflect.Method) fieldOrMethod;
                if (boundReceiver == null) {
                    java.lang.Class<?> cls = ((java.lang.reflect.Method) fieldOrMethod).getParameterTypes()[0];
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(cls, "get(...)");
                    boundReceiver = kotlin.reflect.jvm.internal.UtilKt.defaultPrimitiveValue(cls);
                }
                return method.invoke(null, boundReceiver);
            }
            if (length == 2) {
                java.lang.reflect.Method method2 = (java.lang.reflect.Method) fieldOrMethod;
                if (receiver1 == null) {
                    java.lang.Class<?> cls2 = ((java.lang.reflect.Method) fieldOrMethod).getParameterTypes()[1];
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(cls2, "get(...)");
                    receiver1 = kotlin.reflect.jvm.internal.UtilKt.defaultPrimitiveValue(cls2);
                }
                return method2.invoke(null, boundReceiver, receiver1);
            }
            throw new java.lang.AssertionError("delegate method " + fieldOrMethod + " should take 0, 1, or 2 parameters");
        } catch (java.lang.IllegalAccessException e) {
            throw new kotlin.reflect.full.IllegalPropertyDelegateAccessException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor _descriptor$lambda$5(kotlin.reflect.jvm.internal.KPropertyImpl kPropertyImpl) {
        return kPropertyImpl.getContainer().findPropertyDescriptor(kPropertyImpl.getName(), kPropertyImpl.signature);
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    public kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor getDescriptor() {
        kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor propertyDescriptorInvoke = this._descriptor.invoke();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(propertyDescriptorInvoke, "invoke(...)");
        return propertyDescriptorInvoke;
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    public kotlin.reflect.jvm.internal.calls.Caller<?> getCaller() {
        return getGetter().getCaller();
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    public kotlin.reflect.jvm.internal.calls.Caller<?> getDefaultCaller() {
        return getGetter().getDefaultCaller();
    }

    @Override // kotlin.reflect.KProperty
    public boolean isLateinit() {
        return getDescriptor().isLateInit();
    }

    @Override // kotlin.reflect.KProperty
    public boolean isConst() {
        return getDescriptor().isConst();
    }

    public boolean equals(java.lang.Object other) {
        kotlin.reflect.jvm.internal.KPropertyImpl<?> kPropertyImplAsKPropertyImpl = kotlin.reflect.jvm.internal.UtilKt.asKPropertyImpl(other);
        return kPropertyImplAsKPropertyImpl != null && kotlin.jvm.internal.Intrinsics.areEqual(getContainer(), kPropertyImplAsKPropertyImpl.getContainer()) && kotlin.jvm.internal.Intrinsics.areEqual(getName(), kPropertyImplAsKPropertyImpl.getName()) && kotlin.jvm.internal.Intrinsics.areEqual(this.signature, kPropertyImplAsKPropertyImpl.signature) && kotlin.jvm.internal.Intrinsics.areEqual(this.rawBoundReceiver, kPropertyImplAsKPropertyImpl.rawBoundReceiver);
    }

    public int hashCode() {
        return (((getContainer().hashCode() * 31) + getName().hashCode()) * 31) + this.signature.hashCode();
    }

    public java.lang.String toString() {
        return kotlin.reflect.jvm.internal.ReflectionObjectRenderer.INSTANCE.renderProperty(getDescriptor());
    }

    /* JADX INFO: compiled from: KPropertyImpl.kt */
    @kotlin.Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b&\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u0001*\u0006\b\u0002\u0010\u0002 \u00012\b\u0012\u0004\u0012\u0002H\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u00042\b\u0012\u0004\u0012\u0002H\u00020\u0005B\u0007¢\u0006\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001a¨\u0006 "}, d2 = {"Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "PropertyType", "ReturnType", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "Lkotlin/reflect/KProperty$Accessor;", "Lkotlin/reflect/KFunction;", "<init>", "()V", "property", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "getProperty", "()Lkotlin/reflect/jvm/internal/KPropertyImpl;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyAccessorDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyAccessorDescriptor;", com.taobao.weex.ui.component.WXBasicComponentType.CONTAINER, "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "defaultCaller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getDefaultCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "isBound", "", "()Z", "isInline", "isExternal", "isOperator", "isInfix", "isSuspend", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Accessor<PropertyType, ReturnType> extends kotlin.reflect.jvm.internal.KCallableImpl<ReturnType> implements kotlin.reflect.KFunction<ReturnType>, kotlin.reflect.KProperty.Accessor<PropertyType> {
        @Override // kotlin.reflect.jvm.internal.KCallableImpl
        public kotlin.reflect.jvm.internal.calls.Caller<?> getDefaultCaller() {
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.KCallableImpl
        public abstract kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor getDescriptor();

        public abstract kotlin.reflect.jvm.internal.KPropertyImpl<PropertyType> getProperty();

        @Override // kotlin.reflect.jvm.internal.KCallableImpl
        public kotlin.reflect.jvm.internal.KDeclarationContainerImpl getContainer() {
            return getProperty().getContainer();
        }

        @Override // kotlin.reflect.jvm.internal.KCallableImpl
        public boolean isBound() {
            return getProperty().isBound();
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
    }

    /* JADX INFO: compiled from: KPropertyImpl.kt */
    @kotlin.Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b&\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0016\u001a\u00020\u0007H\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0096\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001f\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u00118VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001d"}, d2 = {"Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "V", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "Lkotlin/reflect/KProperty$Getter;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyGetterDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyGetterDescriptor;", "descriptor$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "caller$delegate", "Lkotlin/Lazy;", "toString", "equals", "", "other", "", "hashCode", "", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Getter<V> extends kotlin.reflect.jvm.internal.KPropertyImpl.Accessor<V, V> implements kotlin.reflect.KProperty.Getter<V> {
        static final /* synthetic */ kotlin.reflect.KProperty<java.lang.Object>[] $$delegatedProperties = {kotlin.jvm.internal.Reflection.property1(new kotlin.jvm.internal.PropertyReference1Impl(kotlin.reflect.jvm.internal.KPropertyImpl.Getter.class, "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/PropertyGetterDescriptor;", 0))};

        /* JADX INFO: renamed from: descriptor$delegate, reason: from kotlin metadata */
        private final kotlin.reflect.jvm.internal.ReflectProperties.LazySoftVal descriptor = kotlin.reflect.jvm.internal.ReflectProperties.lazySoft(new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.KPropertyImpl$Getter$$Lambda$0
            private final kotlin.reflect.jvm.internal.KPropertyImpl.Getter arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.KPropertyImpl.Getter.descriptor_delegate$lambda$0(this.arg$0);
            }
        });

        /* JADX INFO: renamed from: caller$delegate, reason: from kotlin metadata */
        private final kotlin.Lazy caller = kotlin.LazyKt.lazy(kotlin.LazyThreadSafetyMode.PUBLICATION, new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.KPropertyImpl$Getter$$Lambda$1
            private final kotlin.reflect.jvm.internal.KPropertyImpl.Getter arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.KPropertyImpl.Getter.caller_delegate$lambda$1(this.arg$0);
            }
        });

        @Override // kotlin.reflect.KCallable
        public java.lang.String getName() {
            return "<get-" + getProperty().getName() + kotlin.text.Typography.greater;
        }

        @Override // kotlin.reflect.jvm.internal.KPropertyImpl.Accessor, kotlin.reflect.jvm.internal.KCallableImpl
        public kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor getDescriptor() {
            T value = this.descriptor.getValue(this, $$delegatedProperties[0]);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
            return (kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor) value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor descriptor_delegate$lambda$0(kotlin.reflect.jvm.internal.KPropertyImpl.Getter getter) {
            kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor getter2 = getter.getProperty().getDescriptor().getGetter();
            if (getter2 != null) {
                return getter2;
            }
            kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl propertyGetterDescriptorImplCreateDefaultGetter = kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory.createDefaultGetter(getter.getProperty().getDescriptor(), kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion.getEMPTY());
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(propertyGetterDescriptorImplCreateDefaultGetter, "createDefaultGetter(...)");
            return propertyGetterDescriptorImplCreateDefaultGetter;
        }

        @Override // kotlin.reflect.jvm.internal.KCallableImpl
        public kotlin.reflect.jvm.internal.calls.Caller<?> getCaller() {
            return (kotlin.reflect.jvm.internal.calls.Caller) this.caller.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final kotlin.reflect.jvm.internal.calls.Caller caller_delegate$lambda$1(kotlin.reflect.jvm.internal.KPropertyImpl.Getter getter) {
            return kotlin.reflect.jvm.internal.KPropertyImplKt.computeCallerForAccessor(getter, true);
        }

        public java.lang.String toString() {
            return "getter of " + getProperty();
        }

        public boolean equals(java.lang.Object other) {
            return (other instanceof kotlin.reflect.jvm.internal.KPropertyImpl.Getter) && kotlin.jvm.internal.Intrinsics.areEqual(getProperty(), ((kotlin.reflect.jvm.internal.KPropertyImpl.Getter) other).getProperty());
        }

        public int hashCode() {
            return getProperty().hashCode();
        }
    }

    /* JADX INFO: compiled from: KPropertyImpl.kt */
    @kotlin.Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b&\u0018\u0000*\u0004\b\u0001\u0010\u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0017\u001a\u00020\bH\u0016J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0096\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0016R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001b\u0010\u000b\u001a\u00020\f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001f\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u00128VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001e"}, d2 = {"Lkotlin/reflect/jvm/internal/KPropertyImpl$Setter;", "V", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "", "Lkotlin/reflect/KMutableProperty$Setter;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertySetterDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertySetterDescriptor;", "descriptor$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "caller$delegate", "Lkotlin/Lazy;", "toString", "equals", "", "other", "", "hashCode", "", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Setter<V> extends kotlin.reflect.jvm.internal.KPropertyImpl.Accessor<V, kotlin.Unit> implements kotlin.reflect.KMutableProperty.Setter<V> {
        static final /* synthetic */ kotlin.reflect.KProperty<java.lang.Object>[] $$delegatedProperties = {kotlin.jvm.internal.Reflection.property1(new kotlin.jvm.internal.PropertyReference1Impl(kotlin.reflect.jvm.internal.KPropertyImpl.Setter.class, "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/PropertySetterDescriptor;", 0))};

        /* JADX INFO: renamed from: descriptor$delegate, reason: from kotlin metadata */
        private final kotlin.reflect.jvm.internal.ReflectProperties.LazySoftVal descriptor = kotlin.reflect.jvm.internal.ReflectProperties.lazySoft(new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.KPropertyImpl$Setter$$Lambda$0
            private final kotlin.reflect.jvm.internal.KPropertyImpl.Setter arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.KPropertyImpl.Setter.descriptor_delegate$lambda$0(this.arg$0);
            }
        });

        /* JADX INFO: renamed from: caller$delegate, reason: from kotlin metadata */
        private final kotlin.Lazy caller = kotlin.LazyKt.lazy(kotlin.LazyThreadSafetyMode.PUBLICATION, new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.KPropertyImpl$Setter$$Lambda$1
            private final kotlin.reflect.jvm.internal.KPropertyImpl.Setter arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.KPropertyImpl.Setter.caller_delegate$lambda$1(this.arg$0);
            }
        });

        @Override // kotlin.reflect.KCallable
        public java.lang.String getName() {
            return "<set-" + getProperty().getName() + kotlin.text.Typography.greater;
        }

        @Override // kotlin.reflect.jvm.internal.KPropertyImpl.Accessor, kotlin.reflect.jvm.internal.KCallableImpl
        public kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor getDescriptor() {
            T value = this.descriptor.getValue(this, $$delegatedProperties[0]);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
            return (kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor) value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor descriptor_delegate$lambda$0(kotlin.reflect.jvm.internal.KPropertyImpl.Setter setter) {
            kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor setter2 = setter.getProperty().getDescriptor().getSetter();
            if (setter2 != null) {
                return setter2;
            }
            kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertySetterDescriptorImpl propertySetterDescriptorImplCreateDefaultSetter = kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory.createDefaultSetter(setter.getProperty().getDescriptor(), kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion.getEMPTY(), kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion.getEMPTY());
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(propertySetterDescriptorImplCreateDefaultSetter, "createDefaultSetter(...)");
            return propertySetterDescriptorImplCreateDefaultSetter;
        }

        @Override // kotlin.reflect.jvm.internal.KCallableImpl
        public kotlin.reflect.jvm.internal.calls.Caller<?> getCaller() {
            return (kotlin.reflect.jvm.internal.calls.Caller) this.caller.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final kotlin.reflect.jvm.internal.calls.Caller caller_delegate$lambda$1(kotlin.reflect.jvm.internal.KPropertyImpl.Setter setter) {
            return kotlin.reflect.jvm.internal.KPropertyImplKt.computeCallerForAccessor(setter, false);
        }

        public java.lang.String toString() {
            return "setter of " + getProperty();
        }

        public boolean equals(java.lang.Object other) {
            return (other instanceof kotlin.reflect.jvm.internal.KPropertyImpl.Setter) && kotlin.jvm.internal.Intrinsics.areEqual(getProperty(), ((kotlin.reflect.jvm.internal.KPropertyImpl.Setter) other).getProperty());
        }

        public int hashCode() {
            return getProperty().hashCode();
        }
    }

    /* JADX INFO: compiled from: KPropertyImpl.kt */
    @kotlin.Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lkotlin/reflect/jvm/internal/KPropertyImpl$Companion;", "", "<init>", "()V", "EXTENSION_PROPERTY_DELEGATE", "getEXTENSION_PROPERTY_DELEGATE", "()Ljava/lang/Object;", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final java.lang.Object getEXTENSION_PROPERTY_DELEGATE() {
            return kotlin.reflect.jvm.internal.KPropertyImpl.EXTENSION_PROPERTY_DELEGATE;
        }
    }
}
