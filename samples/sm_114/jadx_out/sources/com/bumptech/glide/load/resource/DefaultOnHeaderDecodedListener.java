package com.bumptech.glide.load.resource;

/* JADX INFO: loaded from: classes.dex */
public final class DefaultOnHeaderDecodedListener implements android.graphics.ImageDecoder.OnHeaderDecodedListener {
    private static final java.lang.String TAG = "ImageDecoder";
    private final com.bumptech.glide.load.DecodeFormat decodeFormat;
    private final com.bumptech.glide.load.resource.bitmap.HardwareConfigState hardwareConfigState = com.bumptech.glide.load.resource.bitmap.HardwareConfigState.getInstance();
    private final boolean isHardwareConfigAllowed;
    private final com.bumptech.glide.load.PreferredColorSpace preferredColorSpace;
    private final int requestedHeight;
    private final int requestedWidth;
    private final com.bumptech.glide.load.resource.bitmap.DownsampleStrategy strategy;

    public DefaultOnHeaderDecodedListener(int i, int i2, com.bumptech.glide.load.Options options) {
        this.requestedWidth = i;
        this.requestedHeight = i2;
        this.decodeFormat = (com.bumptech.glide.load.DecodeFormat) options.get(com.bumptech.glide.load.resource.bitmap.Downsampler.DECODE_FORMAT);
        this.strategy = (com.bumptech.glide.load.resource.bitmap.DownsampleStrategy) options.get(com.bumptech.glide.load.resource.bitmap.DownsampleStrategy.OPTION);
        this.isHardwareConfigAllowed = options.get(com.bumptech.glide.load.resource.bitmap.Downsampler.ALLOW_HARDWARE_CONFIG) != null && ((java.lang.Boolean) options.get(com.bumptech.glide.load.resource.bitmap.Downsampler.ALLOW_HARDWARE_CONFIG)).booleanValue();
        this.preferredColorSpace = (com.bumptech.glide.load.PreferredColorSpace) options.get(com.bumptech.glide.load.resource.bitmap.Downsampler.PREFERRED_COLOR_SPACE);
    }

    @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
    public void onHeaderDecoded(android.graphics.ImageDecoder imageDecoder, android.graphics.ImageDecoder.ImageInfo imageInfo, android.graphics.ImageDecoder.Source source) {
        if (this.hardwareConfigState.isHardwareConfigAllowed(this.requestedWidth, this.requestedHeight, this.isHardwareConfigAllowed, false)) {
            imageDecoder.setAllocator(3);
        } else {
            imageDecoder.setAllocator(1);
        }
        if (this.decodeFormat == com.bumptech.glide.load.DecodeFormat.PREFER_RGB_565) {
            imageDecoder.setMemorySizePolicy(0);
        }
        imageDecoder.setOnPartialImageListener(new android.graphics.ImageDecoder.OnPartialImageListener() { // from class: com.bumptech.glide.load.resource.DefaultOnHeaderDecodedListener.1
            @Override // android.graphics.ImageDecoder.OnPartialImageListener
            public boolean onPartialImage(android.graphics.ImageDecoder.DecodeException decodeException) {
                return false;
            }
        });
        android.util.Size size = imageInfo.getSize();
        int width = this.requestedWidth;
        if (width == Integer.MIN_VALUE) {
            width = size.getWidth();
        }
        int height = this.requestedHeight;
        if (height == Integer.MIN_VALUE) {
            height = size.getHeight();
        }
        float scaleFactor = this.strategy.getScaleFactor(size.getWidth(), size.getHeight(), width, height);
        int iRound = java.lang.Math.round(size.getWidth() * scaleFactor);
        int iRound2 = java.lang.Math.round(size.getHeight() * scaleFactor);
        if (android.util.Log.isLoggable(TAG, 2)) {
            android.util.Log.v(TAG, "Resizing from [" + size.getWidth() + com.taobao.weex.common.Constants.Name.X + size.getHeight() + "] to [" + iRound + com.taobao.weex.common.Constants.Name.X + iRound2 + "] scaleFactor: " + scaleFactor);
        }
        imageDecoder.setTargetSize(iRound, iRound2);
        if (this.preferredColorSpace != null) {
            if (android.os.Build.VERSION.SDK_INT >= 28) {
                imageDecoder.setTargetColorSpace(android.graphics.ColorSpace.get((this.preferredColorSpace == com.bumptech.glide.load.PreferredColorSpace.DISPLAY_P3 && imageInfo.getColorSpace() != null && imageInfo.getColorSpace().isWideGamut()) ? android.graphics.ColorSpace.Named.DISPLAY_P3 : android.graphics.ColorSpace.Named.SRGB));
            } else if (android.os.Build.VERSION.SDK_INT >= 26) {
                imageDecoder.setTargetColorSpace(android.graphics.ColorSpace.get(android.graphics.ColorSpace.Named.SRGB));
            }
        }
    }
}
