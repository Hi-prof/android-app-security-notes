package com.bumptech.glide.module;

/* JADX INFO: loaded from: classes.dex */
@java.lang.Deprecated
public final class ManifestParser {
    private static final java.lang.String GLIDE_MODULE_VALUE = "GlideModule";
    private static final java.lang.String TAG = "ManifestParser";
    private final android.content.Context context;

    public ManifestParser(android.content.Context context) {
        this.context = context;
    }

    private android.content.pm.ApplicationInfo getOurApplicationInfo() throws android.content.pm.PackageManager.NameNotFoundException {
        return this.context.getPackageManager().getApplicationInfo(this.context.getPackageName(), 128);
    }

    public java.util.List<com.bumptech.glide.module.GlideModule> parse() {
        if (android.util.Log.isLoggable(TAG, 3)) {
            android.util.Log.d(TAG, "Loading Glide modules");
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        try {
            android.content.pm.ApplicationInfo ourApplicationInfo = getOurApplicationInfo();
            if (ourApplicationInfo == null || ourApplicationInfo.metaData == null) {
                if (android.util.Log.isLoggable(TAG, 3)) {
                    android.util.Log.d(TAG, "Got null app info metadata");
                    return arrayList;
                }
            } else {
                if (android.util.Log.isLoggable(TAG, 2)) {
                    android.util.Log.v(TAG, "Got app info metadata: " + ourApplicationInfo.metaData);
                }
                for (java.lang.String str : ourApplicationInfo.metaData.keySet()) {
                    if (GLIDE_MODULE_VALUE.equals(ourApplicationInfo.metaData.get(str))) {
                        arrayList.add(parseModule(str));
                        if (android.util.Log.isLoggable(TAG, 3)) {
                            android.util.Log.d(TAG, "Loaded Glide module: " + str);
                        }
                    }
                }
                if (android.util.Log.isLoggable(TAG, 3)) {
                    android.util.Log.d(TAG, "Finished loading Glide modules");
                    return arrayList;
                }
            }
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
            if (android.util.Log.isLoggable(TAG, 6)) {
                android.util.Log.e(TAG, "Failed to parse glide modules", e);
            }
        }
        return arrayList;
    }

    private static com.bumptech.glide.module.GlideModule parseModule(java.lang.String str) {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName(str);
            java.lang.Object objNewInstance = null;
            try {
                objNewInstance = cls.getDeclaredConstructor(null).newInstance(null);
            } catch (java.lang.IllegalAccessException e) {
                throwInstantiateGlideModuleException(cls, e);
            } catch (java.lang.InstantiationException e2) {
                throwInstantiateGlideModuleException(cls, e2);
            } catch (java.lang.NoSuchMethodException e3) {
                throwInstantiateGlideModuleException(cls, e3);
            } catch (java.lang.reflect.InvocationTargetException e4) {
                throwInstantiateGlideModuleException(cls, e4);
            }
            if (!(objNewInstance instanceof com.bumptech.glide.module.GlideModule)) {
                throw new java.lang.RuntimeException("Expected instanceof GlideModule, but found: " + objNewInstance);
            }
            return (com.bumptech.glide.module.GlideModule) objNewInstance;
        } catch (java.lang.ClassNotFoundException e5) {
            throw new java.lang.IllegalArgumentException("Unable to find GlideModule implementation", e5);
        }
    }

    private static void throwInstantiateGlideModuleException(java.lang.Class<?> cls, java.lang.Exception exc) {
        throw new java.lang.RuntimeException("Unable to instantiate GlideModule implementation for " + cls, exc);
    }
}
