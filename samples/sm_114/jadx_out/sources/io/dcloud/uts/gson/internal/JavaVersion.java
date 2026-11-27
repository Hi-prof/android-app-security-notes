package io.dcloud.uts.gson.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class JavaVersion {
    private static final int majorJavaVersion = determineMajorJavaVersion();

    private static int determineMajorJavaVersion() {
        return getMajorJavaVersion(java.lang.System.getProperty("java.version"));
    }

    static int getMajorJavaVersion(java.lang.String str) {
        int dotted = parseDotted(str);
        if (dotted == -1) {
            dotted = extractBeginningInt(str);
        }
        if (dotted == -1) {
            return 6;
        }
        return dotted;
    }

    private static int parseDotted(java.lang.String str) {
        try {
            java.lang.String[] strArrSplit = str.split("[._]");
            int i = java.lang.Integer.parseInt(strArrSplit[0]);
            return (i != 1 || strArrSplit.length <= 1) ? i : java.lang.Integer.parseInt(strArrSplit[1]);
        } catch (java.lang.NumberFormatException unused) {
            return -1;
        }
    }

    private static int extractBeginningInt(java.lang.String str) {
        try {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                char cCharAt = str.charAt(i);
                if (!java.lang.Character.isDigit(cCharAt)) {
                    break;
                }
                sb.append(cCharAt);
            }
            return java.lang.Integer.parseInt(sb.toString());
        } catch (java.lang.NumberFormatException unused) {
            return -1;
        }
    }

    public static int getMajorJavaVersion() {
        return majorJavaVersion;
    }

    public static boolean isJava9OrLater() {
        return majorJavaVersion >= 9;
    }

    private JavaVersion() {
    }
}
