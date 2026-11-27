package kotlin.reflect.jvm.internal.impl.storage;

/* JADX INFO: compiled from: storage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StorageKt {
    public static final <T> T getValue(kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue<? extends T> notNullLazyValue, java.lang.Object obj, kotlin.reflect.KProperty<?> p) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(notNullLazyValue, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(p, "p");
        return notNullLazyValue.invoke();
    }

    public static final <T> T getValue(kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue<? extends T> nullableLazyValue, java.lang.Object obj, kotlin.reflect.KProperty<?> p) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(nullableLazyValue, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(p, "p");
        return nullableLazyValue.invoke();
    }
}
