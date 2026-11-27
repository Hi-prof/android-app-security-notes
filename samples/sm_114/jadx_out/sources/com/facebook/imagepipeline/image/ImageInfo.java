package com.facebook.imagepipeline.image;

/* JADX INFO: loaded from: classes.dex */
public interface ImageInfo extends com.facebook.imagepipeline.image.HasImageMetadata {

    /* JADX INFO: renamed from: com.facebook.imagepipeline.image.ImageInfo$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static int $default$getSizeInBytes(com.facebook.imagepipeline.image.ImageInfo _this) {
            return 0;
        }
    }

    int getHeight();

    com.facebook.imagepipeline.image.QualityInfo getQualityInfo();

    int getSizeInBytes();

    int getWidth();
}
