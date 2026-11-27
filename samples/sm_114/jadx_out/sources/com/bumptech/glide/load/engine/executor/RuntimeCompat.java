package com.bumptech.glide.load.engine.executor;

/* JADX INFO: loaded from: classes.dex */
final class RuntimeCompat {
    private static final java.lang.String CPU_LOCATION = "/sys/devices/system/cpu/";
    private static final java.lang.String CPU_NAME_REGEX = "cpu[0-9]+";
    private static final java.lang.String TAG = "GlideRuntimeCompat";

    private RuntimeCompat() {
    }

    static int availableProcessors() {
        return java.lang.Runtime.getRuntime().availableProcessors();
    }

    private static int getCoreCountPre17() {
        java.io.File[] fileArrListFiles;
        android.os.StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = android.os.StrictMode.allowThreadDiskReads();
        try {
            java.io.File file = new java.io.File(CPU_LOCATION);
            final java.util.regex.Pattern patternCompile = java.util.regex.Pattern.compile(CPU_NAME_REGEX);
            fileArrListFiles = file.listFiles(new java.io.FilenameFilter() { // from class: com.bumptech.glide.load.engine.executor.RuntimeCompat.1
                @Override // java.io.FilenameFilter
                public boolean accept(java.io.File file2, java.lang.String str) {
                    return patternCompile.matcher(str).matches();
                }
            });
            android.os.StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
        } catch (java.lang.Throwable th) {
            try {
                if (android.util.Log.isLoggable(TAG, 6)) {
                    android.util.Log.e(TAG, "Failed to calculate accurate cpu count", th);
                }
                android.os.StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                fileArrListFiles = null;
            } catch (java.lang.Throwable th2) {
                android.os.StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                throw th2;
            }
        }
        return java.lang.Math.max(1, fileArrListFiles != null ? fileArrListFiles.length : 0);
    }
}
