package androidx.core.app;

/* JADX INFO: loaded from: classes.dex */
@java.lang.Deprecated
public final class BundleCompat {
    private BundleCompat() {
    }

    public static android.os.IBinder getBinder(android.os.Bundle bundle, java.lang.String str) {
        return bundle.getBinder(str);
    }

    public static void putBinder(android.os.Bundle bundle, java.lang.String str, android.os.IBinder iBinder) {
        bundle.putBinder(str, iBinder);
    }
}
