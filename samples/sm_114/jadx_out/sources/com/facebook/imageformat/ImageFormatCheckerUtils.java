package com.facebook.imageformat;

/* JADX INFO: compiled from: ImageFormatCheckerUtils.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0007J \u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0007J(\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u000eH\u0007¨\u0006\u0012"}, d2 = {"Lcom/facebook/imageformat/ImageFormatCheckerUtils;", "", "<init>", "()V", "asciiBytes", "", "value", "", "startsWithPattern", "", "byteArray", "pattern", "hasPatternAt", "offset", "", "indexOfPattern", "byteArrayLen", "patternLen", "imagepipeline-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ImageFormatCheckerUtils {
    public static final com.facebook.imageformat.ImageFormatCheckerUtils INSTANCE = new com.facebook.imageformat.ImageFormatCheckerUtils();

    private ImageFormatCheckerUtils() {
    }

    @kotlin.jvm.JvmStatic
    public static final byte[] asciiBytes(java.lang.String value) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(value, "value");
        try {
            java.nio.charset.Charset charsetForName = java.nio.charset.Charset.forName("ASCII");
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(...)");
            byte[] bytes = value.getBytes(charsetForName);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            return bytes;
        } catch (java.io.UnsupportedEncodingException e) {
            throw new java.lang.RuntimeException("ASCII not found!", e);
        }
    }

    @kotlin.jvm.JvmStatic
    public static final boolean startsWithPattern(byte[] byteArray, byte[] pattern) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(pattern, "pattern");
        return hasPatternAt(byteArray, pattern, 0);
    }

    @kotlin.jvm.JvmStatic
    public static final boolean hasPatternAt(byte[] byteArray, byte[] pattern, int offset) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(pattern, "pattern");
        if (pattern.length + offset > byteArray.length) {
            return false;
        }
        java.lang.Iterable indices = kotlin.collections.ArraysKt.getIndices(pattern);
        if ((indices instanceof java.util.Collection) && ((java.util.Collection) indices).isEmpty()) {
            return true;
        }
        java.util.Iterator it = indices.iterator();
        while (it.hasNext()) {
            int iNextInt = ((kotlin.collections.IntIterator) it).nextInt();
            if (byteArray[offset + iNextInt] != pattern[iNextInt]) {
                return false;
            }
        }
        return true;
    }

    @kotlin.jvm.JvmStatic
    public static final int indexOfPattern(byte[] byteArray, int byteArrayLen, byte[] pattern, int patternLen) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(pattern, "pattern");
        if (patternLen > byteArrayLen) {
            return -1;
        }
        int i = 0;
        byte b = pattern[0];
        int i2 = byteArrayLen - patternLen;
        while (i <= i2) {
            if (byteArray[i] != b) {
                do {
                    i++;
                    if (i > i2) {
                        break;
                    }
                } while (byteArray[i] != b);
            }
            if (i <= i2) {
                int i3 = i + 1;
                int i4 = (i3 + patternLen) - 1;
                for (int i5 = 1; i3 < i4 && byteArray[i3] == pattern[i5]; i5++) {
                    i3++;
                }
                if (i3 == i4) {
                    return i;
                }
            }
            i++;
        }
        return -1;
    }
}
