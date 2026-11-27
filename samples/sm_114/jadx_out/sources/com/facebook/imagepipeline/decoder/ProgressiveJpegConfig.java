package com.facebook.imagepipeline.decoder;

/* JADX INFO: loaded from: classes.dex */
public interface ProgressiveJpegConfig {
    boolean decodeProgressively();

    int getNextScanNumberToDecode(int i);

    com.facebook.imagepipeline.image.QualityInfo getQualityInfo(int i);
}
