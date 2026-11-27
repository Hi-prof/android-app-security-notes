package com.facebook.imageutils;

/* JADX INFO: compiled from: WebpUtil.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u001e\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u001e\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u001c\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0005H\u0002J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0013H\u0002J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010\u0019\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\f\u0010\u001a\u001a\u00020\n*\u00020\fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/facebook/imageutils/WebpUtil;", "", "<init>", "()V", "VP8_HEADER", "", "VP8L_HEADER", "VP8X_HEADER", "getSize", "Lkotlin/Pair;", "", io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_STREAM, "Ljava/io/InputStream;", "getVP8Dimension", "getVP8LDimension", "getVP8XDimension", "compare", "", "what", "", "with", "getHeader", com.taobao.weex.ui.component.WXBasicComponentType.HEADER, "getInt", "get2BytesAsInt", "read3Bytes", "getNextByteAsInt", "imagepipeline-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class WebpUtil {
    public static final com.facebook.imageutils.WebpUtil INSTANCE = new com.facebook.imageutils.WebpUtil();
    private static final java.lang.String VP8L_HEADER = "VP8L";
    private static final java.lang.String VP8X_HEADER = "VP8X";
    private static final java.lang.String VP8_HEADER = "VP8 ";

    private WebpUtil() {
    }

    @kotlin.jvm.JvmStatic
    public static final kotlin.Pair<java.lang.Integer, java.lang.Integer> getSize(java.io.InputStream stream) {
        kotlin.Pair<java.lang.Integer, java.lang.Integer> vP8Dimension;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(stream, "stream");
        byte[] bArr = new byte[4];
        try {
            try {
                stream.read(bArr);
                com.facebook.imageutils.WebpUtil webpUtil = INSTANCE;
                if (webpUtil.compare(bArr, "RIFF")) {
                    webpUtil.getInt(stream);
                    stream.read(bArr);
                    if (webpUtil.compare(bArr, "WEBP")) {
                        stream.read(bArr);
                        java.lang.String header = webpUtil.getHeader(bArr);
                        int iHashCode = header.hashCode();
                        if (iHashCode == 2640674) {
                            if (header.equals(VP8_HEADER)) {
                                vP8Dimension = webpUtil.getVP8Dimension(stream);
                                return vP8Dimension;
                            }
                            return null;
                        }
                        if (iHashCode == 2640718) {
                            if (!header.equals(VP8L_HEADER)) {
                                return null;
                            }
                            vP8Dimension = webpUtil.getVP8LDimension(stream);
                            return vP8Dimension;
                        }
                        if (iHashCode != 2640730 || !header.equals(VP8X_HEADER)) {
                            return null;
                        }
                        vP8Dimension = webpUtil.getVP8XDimension(stream);
                        try {
                            return vP8Dimension;
                        } catch (java.io.IOException e) {
                            return vP8Dimension;
                        }
                    }
                }
                try {
                    return null;
                } catch (java.io.IOException e2) {
                    return null;
                }
            } catch (java.io.IOException e3) {
                e3.printStackTrace();
            }
        } finally {
            try {
                stream.close();
            } catch (java.io.IOException e4) {
                e4.printStackTrace();
            }
        }
    }

    private final kotlin.Pair<java.lang.Integer, java.lang.Integer> getVP8Dimension(java.io.InputStream stream) throws java.io.IOException {
        stream.skip(7L);
        int nextByteAsInt = getNextByteAsInt(stream);
        int nextByteAsInt2 = getNextByteAsInt(stream);
        int nextByteAsInt3 = getNextByteAsInt(stream);
        if (nextByteAsInt == 157 && nextByteAsInt2 == 1 && nextByteAsInt3 == 42) {
            return new kotlin.Pair<>(java.lang.Integer.valueOf(get2BytesAsInt(stream)), java.lang.Integer.valueOf(get2BytesAsInt(stream)));
        }
        return null;
    }

    private final kotlin.Pair<java.lang.Integer, java.lang.Integer> getVP8LDimension(java.io.InputStream stream) throws java.io.IOException {
        getInt(stream);
        if (getNextByteAsInt(stream) != 47) {
            return null;
        }
        int i = stream.read() & 255;
        int i2 = stream.read();
        return new kotlin.Pair<>(java.lang.Integer.valueOf((i | ((i2 & 63) << 8)) + 1), java.lang.Integer.valueOf((((stream.read() & 15) << 10) | ((stream.read() & 255) << 2) | ((i2 & 192) >> 6)) + 1));
    }

    private final kotlin.Pair<java.lang.Integer, java.lang.Integer> getVP8XDimension(java.io.InputStream stream) throws java.io.IOException {
        stream.skip(8L);
        return new kotlin.Pair<>(java.lang.Integer.valueOf(read3Bytes(stream) + 1), java.lang.Integer.valueOf(read3Bytes(stream) + 1));
    }

    private final boolean compare(byte[] what, java.lang.String with) {
        if (what.length != with.length()) {
            return false;
        }
        java.lang.Iterable indices = kotlin.collections.ArraysKt.getIndices(what);
        if ((indices instanceof java.util.Collection) && ((java.util.Collection) indices).isEmpty()) {
            return true;
        }
        java.util.Iterator it = indices.iterator();
        while (it.hasNext()) {
            int iNextInt = ((kotlin.collections.IntIterator) it).nextInt();
            if (((byte) with.charAt(iNextInt)) != what[iNextInt]) {
                return false;
            }
        }
        return true;
    }

    private final java.lang.String getHeader(byte[] header) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (byte b : header) {
            sb.append((char) (kotlin.UShort.m824constructorimpl(b) & kotlin.UShort.MAX_VALUE));
        }
        java.lang.String string = sb.toString();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    private final int getInt(java.io.InputStream stream) throws java.io.IOException {
        int nextByteAsInt = getNextByteAsInt(stream);
        int nextByteAsInt2 = getNextByteAsInt(stream);
        return (getNextByteAsInt(stream) << 24) | (getNextByteAsInt(stream) << 16) | (nextByteAsInt2 << 8) | nextByteAsInt;
    }

    @kotlin.jvm.JvmStatic
    public static final int get2BytesAsInt(java.io.InputStream stream) throws java.io.IOException {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(stream, "stream");
        com.facebook.imageutils.WebpUtil webpUtil = INSTANCE;
        return (webpUtil.getNextByteAsInt(stream) << 8) | webpUtil.getNextByteAsInt(stream);
    }

    private final int read3Bytes(java.io.InputStream stream) throws java.io.IOException {
        return (getNextByteAsInt(stream) << 16) | (getNextByteAsInt(stream) << 8) | getNextByteAsInt(stream);
    }

    private final int getNextByteAsInt(java.io.InputStream inputStream) throws java.io.IOException {
        return inputStream.read() & 255;
    }
}
