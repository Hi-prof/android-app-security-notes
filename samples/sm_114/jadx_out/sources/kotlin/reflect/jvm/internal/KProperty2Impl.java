package kotlin.reflect.jvm.internal;

/* JADX INFO: compiled from: KProperty2Impl.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0006\b\u0002\u0010\u0003 \u00012\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\b\u0012\u0004\u0012\u0002H\u00030\u0005:\u0001\u001fB!\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fB\u0019\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000b\u0010\u000fJ\u001d\u0010\u0016\u001a\u00028\u00022\u0006\u0010\u0017\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0019J\u001f\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0017\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0019J\u001e\u0010\u001e\u001a\u00028\u00022\u0006\u0010\u0017\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0002\u0010\u0019R&\u0010\u0010\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lkotlin/reflect/jvm/internal/KProperty2Impl;", "D", "E", "V", "Lkotlin/reflect/KProperty2;", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", com.taobao.weex.ui.component.WXBasicComponentType.CONTAINER, "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "name", "", "signature", "<init>", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;)V", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "_getter", "Lkotlin/Lazy;", "Lkotlin/reflect/jvm/internal/KProperty2Impl$Getter;", "getter", "getGetter", "()Lkotlin/reflect/jvm/internal/KProperty2Impl$Getter;", "get", "receiver1", "receiver2", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "delegateSource", "Ljava/lang/reflect/Member;", "getDelegate", "", "invoke", "Getter", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class KProperty2Impl<D, E, V> extends kotlin.reflect.jvm.internal.KPropertyImpl<V> implements kotlin.reflect.KProperty2<D, E, V> {
    private final kotlin.Lazy<kotlin.reflect.jvm.internal.KProperty2Impl.Getter<D, E, V>> _getter;
    private final kotlin.Lazy<java.lang.reflect.Member> delegateSource;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KProperty2Impl(kotlin.reflect.jvm.internal.KDeclarationContainerImpl container, java.lang.String name, java.lang.String signature) {
        super(container, name, signature, kotlin.jvm.internal.CallableReference.NO_RECEIVER);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(container, "container");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(signature, "signature");
        this._getter = kotlin.LazyKt.lazy(kotlin.LazyThreadSafetyMode.PUBLICATION, new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.KProperty2Impl$$Lambda$0
            private final kotlin.reflect.jvm.internal.KProperty2Impl arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.KProperty2Impl._getter$lambda$0(this.arg$0);
            }
        });
        this.delegateSource = kotlin.LazyKt.lazy(kotlin.LazyThreadSafetyMode.PUBLICATION, new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.KProperty2Impl$$Lambda$1
            private final kotlin.reflect.jvm.internal.KProperty2Impl arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return this.arg$0.computeDelegateSource();
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KProperty2Impl(kotlin.reflect.jvm.internal.KDeclarationContainerImpl container, kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor descriptor) {
        super(container, descriptor);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(container, "container");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        this._getter = kotlin.LazyKt.lazy(kotlin.LazyThreadSafetyMode.PUBLICATION, new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.KProperty2Impl$$Lambda$0
            private final kotlin.reflect.jvm.internal.KProperty2Impl arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.KProperty2Impl._getter$lambda$0(this.arg$0);
            }
        });
        this.delegateSource = kotlin.LazyKt.lazy(kotlin.LazyThreadSafetyMode.PUBLICATION, new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.KProperty2Impl$$Lambda$1
            private final kotlin.reflect.jvm.internal.KProperty2Impl arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return this.arg$0.computeDelegateSource();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.KProperty2Impl.Getter _getter$lambda$0(kotlin.reflect.jvm.internal.KProperty2Impl kProperty2Impl) {
        return new kotlin.reflect.jvm.internal.KProperty2Impl.Getter(kProperty2Impl);
    }

    @Override // kotlin.reflect.jvm.internal.KPropertyImpl, kotlin.reflect.KProperty
    public kotlin.reflect.jvm.internal.KProperty2Impl.Getter<D, E, V> getGetter() {
        return this._getter.getValue();
    }

    @Override // kotlin.reflect.KProperty2
    public V get(D receiver1, E receiver2) {
        return getGetter().call(receiver1, receiver2);
    }

    @Override // kotlin.reflect.KProperty2
    public java.lang.Object getDelegate(D receiver1, E receiver2) {
        return getDelegateImpl(this.delegateSource.getValue(), receiver1, receiver2);
    }

    @Override // kotlin.jvm.functions.Function2
    public V invoke(D receiver1, E receiver2) {
        return get(receiver1, receiver2);
    }

    /* JADX INFO: compiled from: KProperty2Impl.kt */
    @kotlin.Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000*\u0004\b\u0003\u0010\u0001*\u0004\b\u0004\u0010\u0002*\u0006\b\u0005\u0010\u0003 \u00012\b\u0012\u0004\u0012\u0002H\u00030\u00042\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0005B!\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u0007¢\u0006\u0004\b\b\u0010\tJ\u001e\u0010\f\u001a\u00028\u00052\u0006\u0010\r\u001a\u00028\u00032\u0006\u0010\u000e\u001a\u00028\u0004H\u0096\u0002¢\u0006\u0002\u0010\u000fR&\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lkotlin/reflect/jvm/internal/KProperty2Impl$Getter;", "D", "E", "V", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "Lkotlin/reflect/KProperty2$Getter;", "property", "Lkotlin/reflect/jvm/internal/KProperty2Impl;", "<init>", "(Lkotlin/reflect/jvm/internal/KProperty2Impl;)V", "getProperty", "()Lkotlin/reflect/jvm/internal/KProperty2Impl;", "invoke", "receiver1", "receiver2", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Getter<D, E, V> extends kotlin.reflect.jvm.internal.KPropertyImpl.Getter<V> implements kotlin.reflect.KProperty2.Getter<D, E, V> {
        private final kotlin.reflect.jvm.internal.KProperty2Impl<D, E, V> property;

        /* JADX WARN: Multi-variable type inference failed */
        public Getter(kotlin.reflect.jvm.internal.KProperty2Impl<D, E, ? extends V> property) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(property, "property");
            this.property = property;
        }

        @Override // kotlin.reflect.jvm.internal.KPropertyImpl.Accessor, kotlin.reflect.KProperty.Accessor
        public kotlin.reflect.jvm.internal.KProperty2Impl<D, E, V> getProperty() {
            return this.property;
        }

        @Override // kotlin.jvm.functions.Function2
        public V invoke(D receiver1, E receiver2) {
            return getProperty().get(receiver1, receiver2);
        }
    }
}
