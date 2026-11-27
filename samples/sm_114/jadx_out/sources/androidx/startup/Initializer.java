package androidx.startup;

/* JADX INFO: loaded from: classes.dex */
public interface Initializer<T> {
    T create(android.content.Context context);

    java.util.List<java.lang.Class<? extends androidx.startup.Initializer<?>>> dependencies();
}
