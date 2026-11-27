package kotlin.reflect.jvm.internal.impl.util.capitalizeDecapitalize;

/* JADX INFO: compiled from: capitalizeDecapitalize.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CapitalizeDecapitalizeKt {
    public static final java.lang.String decapitalizeSmartForCompiler(java.lang.String str, boolean z) {
        java.lang.Integer next;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        java.lang.String str2 = str;
        if (str2.length() == 0 || !isUpperCaseCharAt(str, 0, z)) {
            return str;
        }
        if (str.length() == 1 || !isUpperCaseCharAt(str, 1, z)) {
            if (z) {
                return decapitalizeAsciiOnly(str);
            }
            if (str2.length() <= 0) {
                return str;
            }
            char lowerCase = java.lang.Character.toLowerCase(str.charAt(0));
            java.lang.String strSubstring = str.substring(1);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            return lowerCase + strSubstring;
        }
        java.util.Iterator<java.lang.Integer> it = kotlin.text.StringsKt.getIndices(str2).iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (isUpperCaseCharAt(str, next.intValue(), z));
        java.lang.Integer num = next;
        if (num == null) {
            return toLowerCase(str, z);
        }
        int iIntValue = num.intValue() - 1;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.lang.String strSubstring2 = str.substring(0, iIntValue);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
        sb.append(toLowerCase(strSubstring2, z));
        java.lang.String strSubstring3 = str.substring(iIntValue);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strSubstring3, "substring(...)");
        sb.append(strSubstring3);
        return sb.toString();
    }

    private static final boolean isUpperCaseCharAt(java.lang.String str, int i, boolean z) {
        char cCharAt = str.charAt(i);
        if (z) {
            return 'A' <= cCharAt && cCharAt < '[';
        }
        return java.lang.Character.isUpperCase(cCharAt);
    }

    private static final java.lang.String toLowerCase(java.lang.String str, boolean z) {
        if (z) {
            return toLowerCaseAsciiOnly(str);
        }
        java.lang.String lowerCase = str.toLowerCase(java.util.Locale.ROOT);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    public static final java.lang.String capitalizeAsciiOnly(java.lang.String str) {
        char cCharAt;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        java.lang.String str2 = str;
        if (str2.length() == 0 || 'a' > (cCharAt = str.charAt(0)) || cCharAt >= '{') {
            return str;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder(str.length());
        sb.append(java.lang.Character.toUpperCase(cCharAt));
        sb.append((java.lang.CharSequence) str2, 1, str.length());
        return sb.toString();
    }

    public static final java.lang.String decapitalizeAsciiOnly(java.lang.String str) {
        char cCharAt;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        if (str.length() == 0 || 'A' > (cCharAt = str.charAt(0)) || cCharAt >= '[') {
            return str;
        }
        char lowerCase = java.lang.Character.toLowerCase(cCharAt);
        java.lang.String strSubstring = str.substring(1);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return lowerCase + strSubstring;
    }

    public static final java.lang.String toLowerCaseAsciiOnly(java.lang.String str) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        java.lang.StringBuilder sb = new java.lang.StringBuilder(str.length());
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if ('A' <= cCharAt && cCharAt < '[') {
                cCharAt = java.lang.Character.toLowerCase(cCharAt);
            }
            sb.append(cCharAt);
        }
        java.lang.String string = sb.toString();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }
}
