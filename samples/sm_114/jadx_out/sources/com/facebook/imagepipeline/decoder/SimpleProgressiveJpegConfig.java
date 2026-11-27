package com.facebook.imagepipeline.decoder;

/* JADX INFO: loaded from: classes.dex */
public class SimpleProgressiveJpegConfig implements com.facebook.imagepipeline.decoder.ProgressiveJpegConfig {
    private final com.facebook.imagepipeline.decoder.SimpleProgressiveJpegConfig.DynamicValueConfig mDynamicValueConfig;

    public interface DynamicValueConfig {
        int getGoodEnoughScanNumber();

        java.util.List<java.lang.Integer> getScansToDecode();
    }

    @Override // com.facebook.imagepipeline.decoder.ProgressiveJpegConfig
    public boolean decodeProgressively() {
        return true;
    }

    private static class DefaultDynamicValueConfig implements com.facebook.imagepipeline.decoder.SimpleProgressiveJpegConfig.DynamicValueConfig {
        @Override // com.facebook.imagepipeline.decoder.SimpleProgressiveJpegConfig.DynamicValueConfig
        public int getGoodEnoughScanNumber() {
            return 0;
        }

        private DefaultDynamicValueConfig() {
        }

        @Override // com.facebook.imagepipeline.decoder.SimpleProgressiveJpegConfig.DynamicValueConfig
        public java.util.List<java.lang.Integer> getScansToDecode() {
            return java.util.Collections.EMPTY_LIST;
        }
    }

    public SimpleProgressiveJpegConfig() {
        this(new com.facebook.imagepipeline.decoder.SimpleProgressiveJpegConfig.DefaultDynamicValueConfig());
    }

    public SimpleProgressiveJpegConfig(com.facebook.imagepipeline.decoder.SimpleProgressiveJpegConfig.DynamicValueConfig dynamicValueConfig) {
        this.mDynamicValueConfig = (com.facebook.imagepipeline.decoder.SimpleProgressiveJpegConfig.DynamicValueConfig) com.facebook.common.internal.Preconditions.checkNotNull(dynamicValueConfig);
    }

    @Override // com.facebook.imagepipeline.decoder.ProgressiveJpegConfig
    public int getNextScanNumberToDecode(int i) {
        java.util.List<java.lang.Integer> scansToDecode = this.mDynamicValueConfig.getScansToDecode();
        if (scansToDecode == null || scansToDecode.isEmpty()) {
            return i + 1;
        }
        for (int i2 = 0; i2 < scansToDecode.size(); i2++) {
            if (scansToDecode.get(i2).intValue() > i) {
                return scansToDecode.get(i2).intValue();
            }
        }
        return Integer.MAX_VALUE;
    }

    @Override // com.facebook.imagepipeline.decoder.ProgressiveJpegConfig
    public com.facebook.imagepipeline.image.QualityInfo getQualityInfo(int i) {
        return com.facebook.imagepipeline.image.ImmutableQualityInfo.of(i, i >= this.mDynamicValueConfig.getGoodEnoughScanNumber(), false);
    }
}
