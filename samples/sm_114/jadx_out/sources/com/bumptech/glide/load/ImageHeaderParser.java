package com.bumptech.glide.load;

/* JADX INFO: loaded from: classes.dex */
public interface ImageHeaderParser {
    public static final int UNKNOWN_ORIENTATION = -1;

    int getOrientation(java.io.InputStream inputStream, com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool arrayPool) throws java.io.IOException;

    int getOrientation(java.nio.ByteBuffer byteBuffer, com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool arrayPool) throws java.io.IOException;

    com.bumptech.glide.load.ImageHeaderParser.ImageType getType(java.io.InputStream inputStream) throws java.io.IOException;

    com.bumptech.glide.load.ImageHeaderParser.ImageType getType(java.nio.ByteBuffer byteBuffer) throws java.io.IOException;

    public enum ImageType {
        GIF(true),
        JPEG(false),
        RAW(false),
        PNG_A(true),
        PNG(false),
        WEBP_A(true),
        WEBP(false),
        ANIMATED_WEBP(true),
        AVIF(true),
        ANIMATED_AVIF(true),
        UNKNOWN(false);

        private final boolean hasAlpha;

        ImageType(boolean z) {
            this.hasAlpha = z;
        }

        public boolean hasAlpha() {
            return this.hasAlpha;
        }

        public boolean isWebp() {
            int i = com.bumptech.glide.load.ImageHeaderParser.AnonymousClass1.$SwitchMap$com$bumptech$glide$load$ImageHeaderParser$ImageType[ordinal()];
            return i == 1 || i == 2 || i == 3;
        }
    }

    /* JADX INFO: renamed from: com.bumptech.glide.load.ImageHeaderParser$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bumptech$glide$load$ImageHeaderParser$ImageType;

        static {
            int[] iArr = new int[com.bumptech.glide.load.ImageHeaderParser.ImageType.values().length];
            $SwitchMap$com$bumptech$glide$load$ImageHeaderParser$ImageType = iArr;
            try {
                iArr[com.bumptech.glide.load.ImageHeaderParser.ImageType.WEBP.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$bumptech$glide$load$ImageHeaderParser$ImageType[com.bumptech.glide.load.ImageHeaderParser.ImageType.WEBP_A.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$bumptech$glide$load$ImageHeaderParser$ImageType[com.bumptech.glide.load.ImageHeaderParser.ImageType.ANIMATED_WEBP.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
        }
    }
}
