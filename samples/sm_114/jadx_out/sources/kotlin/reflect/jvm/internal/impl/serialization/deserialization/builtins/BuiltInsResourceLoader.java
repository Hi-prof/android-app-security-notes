package kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins;

/* JADX INFO: compiled from: BuiltInsResourceLoader.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class BuiltInsResourceLoader {
    public final java.io.InputStream loadResource(java.lang.String path) throws java.io.IOException {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(path, "path");
        java.lang.ClassLoader classLoader = getClass().getClassLoader();
        if (classLoader == null) {
            return java.lang.ClassLoader.getSystemResourceAsStream(path);
        }
        java.net.URL resource = classLoader.getResource(path);
        if (resource == null) {
            return null;
        }
        java.net.URLConnection uRLConnectionOpenConnection = resource.openConnection();
        uRLConnectionOpenConnection.setUseCaches(false);
        return uRLConnectionOpenConnection.getInputStream();
    }
}
