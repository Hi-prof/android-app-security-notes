package pl.droidsonroids.gif;

/* JADX INFO: loaded from: classes2.dex */
public class LibraryLoader {
    private static final java.lang.String BASE_LIBRARY_NAME = "pl_droidsonroids_gif";
    private static android.content.Context sAppContext;

    private LibraryLoader() {
    }

    public static void initialize(android.content.Context context) {
        sAppContext = context.getApplicationContext();
    }

    private static android.content.Context getContext() {
        if (sAppContext == null) {
            try {
                sAppContext = (android.content.Context) java.lang.Class.forName("android.app.ActivityThread").getDeclaredMethod("currentApplication", null).invoke(null, null);
            } catch (java.lang.Exception e) {
                throw new java.lang.IllegalStateException("LibraryLoader not initialized. Call LibraryLoader.initialize() before using library classes.", e);
            }
        }
        return sAppContext;
    }

    static void loadLibrary() {
        try {
            java.lang.System.loadLibrary(BASE_LIBRARY_NAME);
        } catch (java.lang.UnsatisfiedLinkError unused) {
            com.getkeepsafe.relinker.ReLinker.loadLibrary(getContext(), BASE_LIBRARY_NAME);
        }
    }
}
