package com.facebook.soloader;

/* JADX INFO: loaded from: classes.dex */
public class SoLoaderULErrorFactory {
    public static com.facebook.soloader.SoLoaderULError create(java.lang.String str, java.lang.UnsatisfiedLinkError unsatisfiedLinkError) {
        com.facebook.soloader.SoLoaderULError soLoaderULError;
        if (unsatisfiedLinkError.getMessage() != null && unsatisfiedLinkError.getMessage().contains("ELF")) {
            com.facebook.soloader.LogUtil.d(com.facebook.soloader.SoLoader.TAG, "Corrupted lib file detected");
            soLoaderULError = new com.facebook.soloader.SoLoaderCorruptedLibFileError(str, unsatisfiedLinkError.toString());
        } else if (corruptedLibName(str)) {
            com.facebook.soloader.LogUtil.d(com.facebook.soloader.SoLoader.TAG, "Corrupted lib name detected");
            soLoaderULError = new com.facebook.soloader.SoLoaderCorruptedLibNameError(str, "corrupted lib name: " + unsatisfiedLinkError.toString());
        } else {
            soLoaderULError = new com.facebook.soloader.SoLoaderULError(str, unsatisfiedLinkError.toString());
        }
        soLoaderULError.initCause(unsatisfiedLinkError);
        return soLoaderULError;
    }

    private static boolean corruptedLibName(java.lang.String str) {
        java.util.regex.Matcher matcher = java.util.regex.Pattern.compile("\\P{ASCII}+").matcher(str);
        if (!matcher.find()) {
            return false;
        }
        com.facebook.soloader.LogUtil.w(com.facebook.soloader.SoLoader.TAG, "Library name is corrupted, contains non-ASCII characters " + matcher.group());
        return true;
    }
}
