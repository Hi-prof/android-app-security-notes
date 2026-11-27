package kotlin.reflect.jvm.internal.impl.types;

/* JADX INFO: compiled from: SpecialTypes.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class LazyWrappedType extends kotlin.reflect.jvm.internal.impl.types.WrappedType {
    private final kotlin.jvm.functions.Function0<kotlin.reflect.jvm.internal.impl.types.KotlinType> computation;
    private final kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue<kotlin.reflect.jvm.internal.impl.types.KotlinType> lazyValue;
    private final kotlin.reflect.jvm.internal.impl.storage.StorageManager storageManager;

    /* JADX WARN: Multi-variable type inference failed */
    public LazyWrappedType(kotlin.reflect.jvm.internal.impl.storage.StorageManager storageManager, kotlin.jvm.functions.Function0<? extends kotlin.reflect.jvm.internal.impl.types.KotlinType> computation) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(computation, "computation");
        this.storageManager = storageManager;
        this.computation = computation;
        this.lazyValue = storageManager.createLazyValue(computation);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.WrappedType
    protected kotlin.reflect.jvm.internal.impl.types.KotlinType getDelegate() {
        return this.lazyValue.invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.WrappedType
    public boolean isComputed() {
        return this.lazyValue.isComputed();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public kotlin.reflect.jvm.internal.impl.types.LazyWrappedType refine(final kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner kotlinTypeRefiner) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return new kotlin.reflect.jvm.internal.impl.types.LazyWrappedType(this.storageManager, new kotlin.jvm.functions.Function0(kotlinTypeRefiner, this) { // from class: kotlin.reflect.jvm.internal.impl.types.LazyWrappedType$$Lambda$0
            private final kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner arg$0;
            private final kotlin.reflect.jvm.internal.impl.types.LazyWrappedType arg$1;

            {
                this.arg$0 = kotlinTypeRefiner;
                this.arg$1 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.impl.types.LazyWrappedType.refine$lambda$0(this.arg$0, this.arg$1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.types.KotlinType refine$lambda$0(kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner kotlinTypeRefiner, kotlin.reflect.jvm.internal.impl.types.LazyWrappedType lazyWrappedType) {
        return kotlinTypeRefiner.refineType((kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) lazyWrappedType.computation.invoke());
    }
}
