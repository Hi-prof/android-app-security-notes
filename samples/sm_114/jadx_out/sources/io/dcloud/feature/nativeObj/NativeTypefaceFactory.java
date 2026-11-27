package io.dcloud.feature.nativeObj;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class NativeTypefaceFactory {
    public static java.util.HashMap<java.lang.String, java.lang.ref.SoftReference<android.graphics.Typeface>> mCache = new java.util.HashMap<>();

    public static void clearCache() {
        java.util.HashMap<java.lang.String, java.lang.ref.SoftReference<android.graphics.Typeface>> map = mCache;
        if (map != null) {
            map.clear();
        }
    }

    public static android.graphics.Typeface getTypeface(io.dcloud.common.DHInterface.IApp iApp, java.lang.String str) {
        android.graphics.Typeface typefaceCreateFromFile;
        try {
            if (mCache.containsKey(str)) {
                java.lang.ref.SoftReference<android.graphics.Typeface> softReference = mCache.get(str);
                if (softReference != null && softReference.get() != null) {
                    return softReference.get();
                }
                mCache.remove(str);
            }
            java.io.File file = new java.io.File(str);
            if (iApp.obtainRunningAppMode() != 1 || file.exists()) {
                typefaceCreateFromFile = android.graphics.Typeface.createFromFile(str);
            } else {
                if (str.startsWith("/")) {
                    str = str.substring(1, str.length());
                }
                typefaceCreateFromFile = android.graphics.Typeface.createFromAsset(iApp.getActivity().getAssets(), str);
            }
            try {
                mCache.put(str, new java.lang.ref.SoftReference<>(typefaceCreateFromFile));
                return typefaceCreateFromFile;
            } catch (java.lang.Exception unused) {
                return typefaceCreateFromFile;
            }
        } catch (java.lang.Exception unused2) {
            return null;
        }
    }
}
