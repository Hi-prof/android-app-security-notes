package kotlin.reflect.jvm.internal;

/* JADX INFO: compiled from: KProperty1Impl.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0004:\u0001\u001cB+\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rB\u0019\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\f\u0010\u0010J\u001d\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001bR \u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001d"}, d2 = {"Lkotlin/reflect/jvm/internal/KMutableProperty1Impl;", "T", "V", "Lkotlin/reflect/jvm/internal/KProperty1Impl;", "Lkotlin/reflect/KMutableProperty1;", com.taobao.weex.ui.component.WXBasicComponentType.CONTAINER, "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "name", "", "signature", "boundReceiver", "", "<init>", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "_setter", "Lkotlin/Lazy;", "Lkotlin/reflect/jvm/internal/KMutableProperty1Impl$Setter;", "setter", "getSetter", "()Lkotlin/reflect/jvm/internal/KMutableProperty1Impl$Setter;", "set", "", "receiver", "value", "(Ljava/lang/Object;Ljava/lang/Object;)V", "Setter", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class KMutableProperty1Impl<T, V> extends kotlin.reflect.jvm.internal.KProperty1Impl<T, V> implements kotlin.reflect.KMutableProperty1<T, V> {
    private final kotlin.Lazy<kotlin.reflect.jvm.internal.KMutableProperty1Impl.Setter<T, V>> _setter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KMutableProperty1Impl(kotlin.reflect.jvm.internal.KDeclarationContainerImpl container, java.lang.String name, java.lang.String signature, java.lang.Object obj) {
        super(container, name, signature, obj);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(container, "container");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(signature, "signature");
        this._setter = kotlin.LazyKt.lazy(kotlin.LazyThreadSafetyMode.PUBLICATION, new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.KMutableProperty1Impl$$Lambda$0
            private final kotlin.reflect.jvm.internal.KMutableProperty1Impl arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.KMutableProperty1Impl._setter$lambda$0(this.arg$0);
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KMutableProperty1Impl(kotlin.reflect.jvm.internal.KDeclarationContainerImpl container, kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor descriptor) {
        super(container, descriptor);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(container, "container");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        this._setter = kotlin.LazyKt.lazy(kotlin.LazyThreadSafetyMode.PUBLICATION, new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.KMutableProperty1Impl$$Lambda$0
            private final kotlin.reflect.jvm.internal.KMutableProperty1Impl arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.KMutableProperty1Impl._setter$lambda$0(this.arg$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.KMutableProperty1Impl.Setter _setter$lambda$0(kotlin.reflect.jvm.internal.KMutableProperty1Impl kMutableProperty1Impl) {
        return new kotlin.reflect.jvm.internal.KMutableProperty1Impl.Setter(kMutableProperty1Impl);
    }

    @Override // kotlin.reflect.KMutableProperty1, kotlin.reflect.KMutableProperty
    public kotlin.reflect.jvm.internal.KMutableProperty1Impl.Setter<T, V> getSetter() {
        return this._setter.getValue();
    }

    @Override // kotlin.reflect.KMutableProperty1
    public void set(T receiver, V value) {
        getSetter().call(receiver, value);
    }

    /* JADX INFO: compiled from: KProperty1Impl.kt */
    @kotlin.Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\b\u0012\u0004\u0012\u0002H\u00020\u00032\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0004B\u001b\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00028\u00022\u0006\u0010\u000e\u001a\u00028\u0003H\u0096\u0002¢\u0006\u0002\u0010\u000fR \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0010"}, d2 = {"Lkotlin/reflect/jvm/internal/KMutableProperty1Impl$Setter;", "T", "V", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Setter;", "Lkotlin/reflect/KMutableProperty1$Setter;", "property", "Lkotlin/reflect/jvm/internal/KMutableProperty1Impl;", "<init>", "(Lkotlin/reflect/jvm/internal/KMutableProperty1Impl;)V", "getProperty", "()Lkotlin/reflect/jvm/internal/KMutableProperty1Impl;", "invoke", "", "receiver", "value", "(Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Setter<T, V> extends kotlin.reflect.jvm.internal.KPropertyImpl.Setter<V> implements kotlin.reflect.KMutableProperty1.Setter<T, V> {
        private final kotlin.reflect.jvm.internal.KMutableProperty1Impl<T, V> property;

        public Setter(kotlin.reflect.jvm.internal.KMutableProperty1Impl<T, V> property) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(property, "property");
            this.property = property;
        }

        @Override // kotlin.reflect.jvm.internal.KPropertyImpl.Accessor, kotlin.reflect.KProperty.Accessor
        public kotlin.reflect.jvm.internal.KMutableProperty1Impl<T, V> getProperty() {
            return this.property;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ kotlin.Unit invoke(java.lang.Object obj, java.lang.Object obj2) {
            invoke2(obj, obj2);
            return kotlin.Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public void invoke2(T receiver, V value) {
            getProperty().set(receiver, value);
        }
    }
}
