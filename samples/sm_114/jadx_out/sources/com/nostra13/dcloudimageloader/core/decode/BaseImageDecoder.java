package com.nostra13.dcloudimageloader.core.decode;

/* JADX INFO: loaded from: classes.dex */
public class BaseImageDecoder implements com.nostra13.dcloudimageloader.core.decode.ImageDecoder {
    protected static final java.lang.String ERROR_CANT_DECODE_IMAGE = "Image can't be decoded [%s]";
    protected static final java.lang.String ERROR_NO_IMAGE_STREAM = "No stream for image [%s]";
    protected static final java.lang.String LOG_FLIP_IMAGE = "Flip image horizontally [%s]";
    protected static final java.lang.String LOG_ROTATE_IMAGE = "Rotate image on %1$d° [%2$s]";
    protected static final java.lang.String LOG_SCALE_IMAGE = "Scale subsampled image (%1$s) to %2$s (scale = %3$.5f) [%4$s]";
    protected static final java.lang.String LOG_SUBSAMPLE_IMAGE = "Subsample original image (%1$s) to %2$s (scale = %3$d) [%4$s]";
    protected final boolean loggingEnabled;

    public BaseImageDecoder(boolean z) {
        this.loggingEnabled = z;
    }

    @Override // com.nostra13.dcloudimageloader.core.decode.ImageDecoder
    public android.graphics.Bitmap decode(com.nostra13.dcloudimageloader.core.decode.ImageDecodingInfo imageDecodingInfo) throws java.io.IOException {
        java.io.InputStream imageStream = getImageStream(imageDecodingInfo);
        com.nostra13.dcloudimageloader.core.decode.BaseImageDecoder.ImageFileInfo imageFileInfoDefineImageSizeAndRotation = defineImageSizeAndRotation(imageStream, imageDecodingInfo);
        android.graphics.Bitmap bitmapDecodeStream = decodeStream(resetStream(imageStream, imageDecodingInfo), prepareDecodingOptions(imageFileInfoDefineImageSizeAndRotation.imageSize, imageDecodingInfo));
        if (bitmapDecodeStream != null) {
            return considerExactScaleAndOrientaiton(bitmapDecodeStream, imageDecodingInfo, imageFileInfoDefineImageSizeAndRotation.exif.rotation, imageFileInfoDefineImageSizeAndRotation.exif.flipHorizontal);
        }
        com.nostra13.dcloudimageloader.utils.L.e(ERROR_CANT_DECODE_IMAGE, imageDecodingInfo.getImageKey());
        return bitmapDecodeStream;
    }

    protected java.io.InputStream getImageStream(com.nostra13.dcloudimageloader.core.decode.ImageDecodingInfo imageDecodingInfo) throws java.io.IOException {
        return imageDecodingInfo.getDownloader().getStream(imageDecodingInfo.getImageUri(), imageDecodingInfo.getExtraForDownloader());
    }

    protected com.nostra13.dcloudimageloader.core.decode.BaseImageDecoder.ImageFileInfo defineImageSizeAndRotation(java.io.InputStream inputStream, com.nostra13.dcloudimageloader.core.decode.ImageDecodingInfo imageDecodingInfo) throws java.io.IOException {
        com.nostra13.dcloudimageloader.core.decode.BaseImageDecoder.ExifInfo exifInfo;
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        android.graphics.BitmapFactory.decodeStream(inputStream, null, options);
        java.lang.String imageUri = imageDecodingInfo.getImageUri();
        if (imageDecodingInfo.shouldConsiderExifParams() && canDefineExifParams(imageUri, options.outMimeType)) {
            exifInfo = defineExifOrientation(imageUri);
        } else {
            exifInfo = new com.nostra13.dcloudimageloader.core.decode.BaseImageDecoder.ExifInfo();
        }
        return new com.nostra13.dcloudimageloader.core.decode.BaseImageDecoder.ImageFileInfo(new com.nostra13.dcloudimageloader.core.assist.ImageSize(options.outWidth, options.outHeight, exifInfo.rotation), exifInfo);
    }

    private boolean canDefineExifParams(java.lang.String str, java.lang.String str2) {
        return "image/jpeg".equalsIgnoreCase(str2) && com.nostra13.dcloudimageloader.core.download.ImageDownloader.Scheme.ofUri(str) == com.nostra13.dcloudimageloader.core.download.ImageDownloader.Scheme.FILE;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected com.nostra13.dcloudimageloader.core.decode.BaseImageDecoder.ExifInfo defineExifOrientation(java.lang.String str) {
        boolean z = true;
        int i = 0;
        try {
            switch (new android.media.ExifInterface(com.nostra13.dcloudimageloader.core.download.ImageDownloader.Scheme.FILE.crop(str)).getAttributeInt("Orientation", 1)) {
                case 1:
                default:
                    z = false;
                    break;
                case 2:
                    break;
                case 3:
                    z = false;
                    i = 180;
                    break;
                case 4:
                    i = 180;
                    break;
                case 5:
                    i = 270;
                    break;
                case 6:
                    z = false;
                    i = 90;
                    break;
                case 7:
                    i = 90;
                    break;
                case 8:
                    z = false;
                    i = 270;
                    break;
            }
        } catch (java.io.IOException unused) {
            com.nostra13.dcloudimageloader.utils.L.w("Can't read EXIF tags from file [%s]", str);
        }
        return new com.nostra13.dcloudimageloader.core.decode.BaseImageDecoder.ExifInfo(i, z);
    }

    protected android.graphics.BitmapFactory.Options prepareDecodingOptions(com.nostra13.dcloudimageloader.core.assist.ImageSize imageSize, com.nostra13.dcloudimageloader.core.decode.ImageDecodingInfo imageDecodingInfo) {
        com.nostra13.dcloudimageloader.core.assist.ImageScaleType imageScaleType = imageDecodingInfo.getImageScaleType();
        com.nostra13.dcloudimageloader.core.assist.ImageSize targetSize = imageDecodingInfo.getTargetSize();
        int i = 1;
        if (imageScaleType != com.nostra13.dcloudimageloader.core.assist.ImageScaleType.NONE) {
            int iComputeImageSampleSize = com.nostra13.dcloudimageloader.utils.ImageSizeUtils.computeImageSampleSize(imageSize, targetSize, imageDecodingInfo.getViewScaleType(), imageScaleType == com.nostra13.dcloudimageloader.core.assist.ImageScaleType.IN_SAMPLE_POWER_OF_2);
            if (this.loggingEnabled) {
                com.nostra13.dcloudimageloader.utils.L.d(LOG_SUBSAMPLE_IMAGE, imageSize, imageSize.scaleDown(iComputeImageSampleSize), java.lang.Integer.valueOf(iComputeImageSampleSize), imageDecodingInfo.getImageKey());
            }
            i = iComputeImageSampleSize;
        }
        android.graphics.BitmapFactory.Options decodingOptions = imageDecodingInfo.getDecodingOptions();
        decodingOptions.inSampleSize = i;
        return decodingOptions;
    }

    protected java.io.InputStream resetStream(java.io.InputStream inputStream, com.nostra13.dcloudimageloader.core.decode.ImageDecodingInfo imageDecodingInfo) throws java.io.IOException {
        try {
            inputStream.reset();
            return inputStream;
        } catch (java.io.IOException unused) {
            return getImageStream(imageDecodingInfo);
        }
    }

    protected android.graphics.Bitmap decodeStream(java.io.InputStream inputStream, android.graphics.BitmapFactory.Options options) throws java.io.IOException {
        try {
            return android.graphics.BitmapFactory.decodeStream(inputStream, null, options);
        } finally {
            com.nostra13.dcloudimageloader.utils.IoUtils.closeSilently(inputStream);
        }
    }

    protected android.graphics.Bitmap considerExactScaleAndOrientaiton(android.graphics.Bitmap bitmap, com.nostra13.dcloudimageloader.core.decode.ImageDecodingInfo imageDecodingInfo, int i, boolean z) {
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        com.nostra13.dcloudimageloader.core.assist.ImageScaleType imageScaleType = imageDecodingInfo.getImageScaleType();
        if (imageScaleType == com.nostra13.dcloudimageloader.core.assist.ImageScaleType.EXACTLY || imageScaleType == com.nostra13.dcloudimageloader.core.assist.ImageScaleType.EXACTLY_STRETCHED) {
            com.nostra13.dcloudimageloader.core.assist.ImageSize imageSize = new com.nostra13.dcloudimageloader.core.assist.ImageSize(bitmap.getWidth(), bitmap.getHeight(), i);
            float fComputeImageScale = com.nostra13.dcloudimageloader.utils.ImageSizeUtils.computeImageScale(imageSize, imageDecodingInfo.getTargetSize(), imageDecodingInfo.getViewScaleType(), imageScaleType == com.nostra13.dcloudimageloader.core.assist.ImageScaleType.EXACTLY_STRETCHED);
            if (java.lang.Float.compare(fComputeImageScale, 1.0f) != 0) {
                matrix.setScale(fComputeImageScale, fComputeImageScale);
                if (this.loggingEnabled) {
                    com.nostra13.dcloudimageloader.utils.L.d(LOG_SCALE_IMAGE, imageSize, imageSize.scale(fComputeImageScale), java.lang.Float.valueOf(fComputeImageScale), imageDecodingInfo.getImageKey());
                }
            }
        }
        if (z) {
            matrix.postScale(-1.0f, 1.0f);
            if (this.loggingEnabled) {
                com.nostra13.dcloudimageloader.utils.L.d(LOG_FLIP_IMAGE, imageDecodingInfo.getImageKey());
            }
        }
        if (i != 0) {
            matrix.postRotate(i);
            if (this.loggingEnabled) {
                com.nostra13.dcloudimageloader.utils.L.d("Rotate image on %1$d�� [%2$s]", java.lang.Integer.valueOf(i), imageDecodingInfo.getImageKey());
            }
        }
        android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        if (bitmapCreateBitmap != bitmap) {
            bitmap.recycle();
        }
        return bitmapCreateBitmap;
    }

    protected static class ImageFileInfo {
        public final com.nostra13.dcloudimageloader.core.decode.BaseImageDecoder.ExifInfo exif;
        public final com.nostra13.dcloudimageloader.core.assist.ImageSize imageSize;

        protected ImageFileInfo(com.nostra13.dcloudimageloader.core.assist.ImageSize imageSize, com.nostra13.dcloudimageloader.core.decode.BaseImageDecoder.ExifInfo exifInfo) {
            this.imageSize = imageSize;
            this.exif = exifInfo;
        }
    }

    protected static class ExifInfo {
        public final boolean flipHorizontal;
        public final int rotation;

        protected ExifInfo() {
            this.rotation = 0;
            this.flipHorizontal = false;
        }

        protected ExifInfo(int i, boolean z) {
            this.rotation = i;
            this.flipHorizontal = z;
        }
    }
}
