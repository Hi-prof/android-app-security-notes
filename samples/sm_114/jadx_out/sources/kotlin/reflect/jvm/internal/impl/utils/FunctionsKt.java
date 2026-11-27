package kotlin.reflect.jvm.internal.impl.utils;

/* JADX INFO: compiled from: functions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FunctionsKt {
    private static final kotlin.jvm.functions.Function1<java.lang.Object, java.lang.Object> IDENTITY = new kotlin.jvm.functions.Function1() { // from class: kotlin.reflect.jvm.internal.impl.utils.FunctionsKt$$Lambda$3
        @Override // kotlin.jvm.functions.Function1
        public java.lang.Object invoke(java.lang.Object obj) {
            return kotlin.reflect.jvm.internal.impl.utils.FunctionsKt.IDENTITY$lambda$0(obj);
        }
    };
    private static final kotlin.jvm.functions.Function1<java.lang.Object, java.lang.Boolean> ALWAYS_TRUE = new kotlin.jvm.functions.Function1() { // from class: kotlin.reflect.jvm.internal.impl.utils.FunctionsKt$$Lambda$4
        @Override // kotlin.jvm.functions.Function1
        public java.lang.Object invoke(java.lang.Object obj) {
            return java.lang.Boolean.valueOf(kotlin.reflect.jvm.internal.impl.utils.FunctionsKt.ALWAYS_TRUE$lambda$1(obj));
        }
    };
    private static final kotlin.jvm.functions.Function1<java.lang.Object, java.lang.Object> ALWAYS_NULL = new kotlin.jvm.functions.Function1() { // from class: kotlin.reflect.jvm.internal.impl.utils.FunctionsKt$ALWAYS_NULL$1
        @Override // kotlin.jvm.functions.Function1
        public final java.lang.Void invoke(java.lang.Object obj) {
            return null;
        }
    };
    private static final kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> DO_NOTHING = new kotlin.jvm.functions.Function1() { // from class: kotlin.reflect.jvm.internal.impl.utils.FunctionsKt$$Lambda$5
        @Override // kotlin.jvm.functions.Function1
        public java.lang.Object invoke(java.lang.Object obj) {
            return kotlin.reflect.jvm.internal.impl.utils.FunctionsKt.DO_NOTHING$lambda$2(obj);
        }
    };
    private static final kotlin.jvm.functions.Function2<java.lang.Object, java.lang.Object, kotlin.Unit> DO_NOTHING_2 = new kotlin.jvm.functions.Function2() { // from class: kotlin.reflect.jvm.internal.impl.utils.FunctionsKt$$Lambda$6
        @Override // kotlin.jvm.functions.Function2
        public java.lang.Object invoke(java.lang.Object obj, java.lang.Object obj2) {
            return kotlin.reflect.jvm.internal.impl.utils.FunctionsKt.DO_NOTHING_2$lambda$3(obj, obj2);
        }
    };
    private static final kotlin.jvm.functions.Function3<java.lang.Object, java.lang.Object, java.lang.Object, kotlin.Unit> DO_NOTHING_3 = new kotlin.jvm.functions.Function3() { // from class: kotlin.reflect.jvm.internal.impl.utils.FunctionsKt$$Lambda$7
        @Override // kotlin.jvm.functions.Function3
        public java.lang.Object invoke(java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3) {
            return kotlin.reflect.jvm.internal.impl.utils.FunctionsKt.DO_NOTHING_3$lambda$4(obj, obj2, obj3);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ALWAYS_TRUE$lambda$1(java.lang.Object obj) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.lang.Object IDENTITY$lambda$0(java.lang.Object obj) {
        return obj;
    }

    public static final <T> kotlin.jvm.functions.Function1<T, java.lang.Boolean> alwaysTrue() {
        return (kotlin.jvm.functions.Function1<T, java.lang.Boolean>) ALWAYS_TRUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit DO_NOTHING$lambda$2(java.lang.Object obj) {
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit DO_NOTHING_2$lambda$3(java.lang.Object obj, java.lang.Object obj2) {
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit DO_NOTHING_3$lambda$4(java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3) {
        return kotlin.Unit.INSTANCE;
    }

    public static final kotlin.jvm.functions.Function3<java.lang.Object, java.lang.Object, java.lang.Object, kotlin.Unit> getDO_NOTHING_3() {
        return DO_NOTHING_3;
    }
}
