package kotlin.reflect.jvm.internal.impl.types.checker;

/* JADX INFO: compiled from: NewKotlinTypeChecker.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface NewKotlinTypeChecker extends kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker {
    public static final kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker.Companion Companion = kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker.Companion.$$INSTANCE;

    kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner getKotlinTypeRefiner();

    kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil getOverridingUtil();

    /* JADX INFO: compiled from: NewKotlinTypeChecker.kt */
    public static final class Companion {
        static final /* synthetic */ kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker.Companion $$INSTANCE = new kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker.Companion();
        private static final kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeCheckerImpl Default = new kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeCheckerImpl(kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner.Default.INSTANCE, null, 2, 0 == true ? 1 : 0);

        private Companion() {
        }

        public final kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeCheckerImpl getDefault() {
            return Default;
        }
    }
}
