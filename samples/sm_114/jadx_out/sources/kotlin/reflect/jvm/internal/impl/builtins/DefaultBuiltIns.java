package kotlin.reflect.jvm.internal.impl.builtins;

/* JADX INFO: compiled from: DefaultBuiltIns.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DefaultBuiltIns extends kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns {
    public static final kotlin.reflect.jvm.internal.impl.builtins.DefaultBuiltIns.Companion Companion = new kotlin.reflect.jvm.internal.impl.builtins.DefaultBuiltIns.Companion(null);
    private static final kotlin.Lazy<kotlin.reflect.jvm.internal.impl.builtins.DefaultBuiltIns> Instance$delegate = kotlin.LazyKt.lazy(new kotlin.jvm.functions.Function0() { // from class: kotlin.reflect.jvm.internal.impl.builtins.DefaultBuiltIns$$Lambda$0
        @Override // kotlin.jvm.functions.Function0
        public java.lang.Object invoke() {
            return kotlin.reflect.jvm.internal.impl.builtins.DefaultBuiltIns.Instance_delegate$lambda$0();
        }
    });

    public DefaultBuiltIns() {
        this(false, 1, null);
    }

    public DefaultBuiltIns(boolean z) {
        super(new kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager("DefaultBuiltIns"));
        if (z) {
            createBuiltInsModule(false);
        }
    }

    public /* synthetic */ DefaultBuiltIns(boolean z, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z);
    }

    /* JADX INFO: compiled from: DefaultBuiltIns.kt */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final kotlin.reflect.jvm.internal.impl.builtins.DefaultBuiltIns getInstance() {
            return (kotlin.reflect.jvm.internal.impl.builtins.DefaultBuiltIns) kotlin.reflect.jvm.internal.impl.builtins.DefaultBuiltIns.Instance$delegate.getValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.builtins.DefaultBuiltIns Instance_delegate$lambda$0() {
        return new kotlin.reflect.jvm.internal.impl.builtins.DefaultBuiltIns(false, 1, null);
    }
}
