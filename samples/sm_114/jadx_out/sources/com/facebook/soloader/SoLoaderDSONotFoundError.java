package com.facebook.soloader;

/* JADX INFO: loaded from: classes.dex */
public class SoLoaderDSONotFoundError extends com.facebook.soloader.SoLoaderULError {
    public SoLoaderDSONotFoundError(java.lang.String str) {
        super(str);
    }

    public SoLoaderDSONotFoundError(java.lang.String str, java.lang.String str2) {
        super(str, str2);
    }

    public static com.facebook.soloader.SoLoaderDSONotFoundError create(java.lang.String str, android.content.Context context, com.facebook.soloader.SoSource[] soSourceArr) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("couldn't find DSO to load: ");
        sb.append(str);
        sb.append("\n\texisting SO sources: ");
        for (int i = 0; i < soSourceArr.length; i++) {
            sb.append("\n\t\tSoSource ");
            sb.append(i);
            sb.append(": ");
            sb.append(soSourceArr[i].toString());
        }
        if (context != null) {
            sb.append("\n\tNative lib dir: ");
            sb.append(context.getApplicationInfo().nativeLibraryDir);
            sb.append("\n");
        }
        return new com.facebook.soloader.SoLoaderDSONotFoundError(str, sb.toString());
    }
}
