package io.dcloud.common.util;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class ImageLoaderUtil {
    private static java.util.ArrayList<java.lang.String> downloadUrls = new java.util.ArrayList<>();

    public static void addNetIconDownloadUrl(java.lang.String str) {
        if (!io.dcloud.common.util.PdrUtil.isNetPath(str) || downloadUrls.contains(str)) {
            return;
        }
        downloadUrls.add(str);
    }

    public static void clearCache() {
        downloadUrls.clear();
        com.nostra13.dcloudimageloader.core.ImageLoaderL.getInstance().clearMemoryCache();
        com.nostra13.dcloudimageloader.core.ImageLoader.getInstance().clearMemoryCache();
    }

    public static com.nostra13.dcloudimageloader.core.DisplayImageOptions getIconDisplayOptions(android.content.Context context) {
        return new com.nostra13.dcloudimageloader.core.DisplayImageOptions.Builder().cacheOnDisc(true).cacheInMemory(true).imageScaleType(com.nostra13.dcloudimageloader.core.assist.ImageScaleType.IN_SAMPLE_INT).bitmapConfig(android.graphics.Bitmap.Config.RGB_565).showImageOnLoading(new android.graphics.drawable.ColorDrawable(0)).build();
    }

    public static java.lang.String getIconLoaclfolder() {
        return io.dcloud.common.adapter.util.DeviceInfo.sBaseFsRootPath + "icons/";
    }

    public static java.lang.String getOtherImageLoaclfolder() {
        return io.dcloud.common.adapter.util.DeviceInfo.sBaseFsRootPath + "images/";
    }

    public static com.nostra13.dcloudimageloader.core.DisplayImageOptions getStreamIconDisplayOptions(android.content.Context context) {
        return new com.nostra13.dcloudimageloader.core.DisplayImageOptions.Builder().cacheOnDisc(true).cacheInMemory(true).imageScaleType(com.nostra13.dcloudimageloader.core.assist.ImageScaleType.IN_SAMPLE_INT).bitmapConfig(android.graphics.Bitmap.Config.RGB_565).showImageOnLoading(io.src.dcloud.adapter.DCloudAdapterUtil.getImageOnLoadingId(context)).build();
    }

    public static void initImageLoader(android.content.Context context) {
        if (com.nostra13.dcloudimageloader.core.ImageLoader.getInstance().isInited()) {
            return;
        }
        java.io.File file = new java.io.File(getIconLoaclfolder());
        if (!file.exists()) {
            file.mkdirs();
        }
        com.nostra13.dcloudimageloader.core.ImageLoader.getInstance().init(new com.nostra13.dcloudimageloader.core.ImageLoaderConfiguration.Builder(context).memoryCacheExtraOptions(com.facebook.common.statfs.StatFsHelper.DEFAULT_DISK_YELLOW_LEVEL_IN_MB, com.facebook.common.statfs.StatFsHelper.DEFAULT_DISK_YELLOW_LEVEL_IN_MB).tasksProcessingOrder(com.nostra13.dcloudimageloader.core.assist.QueueProcessingType.FIFO).denyCacheImageMultipleSizesInMemory().memoryCache(new com.nostra13.dcloudimageloader.cache.memory.impl.LruMemoryCache(2097152)).memoryCacheSize(2097152).threadPriority(3).threadPoolSize(3).denyCacheImageMultipleSizesInMemory().defaultDisplayImageOptions(getIconDisplayOptions(context)).discCache(new com.nostra13.dcloudimageloader.cache.disc.impl.UnlimitedDiscCache(file)).imageDownloader(new com.nostra13.dcloudimageloader.core.download.BaseImageDownloader(context)).imageDecoder(new com.nostra13.dcloudimageloader.core.decode.BaseImageDecoder(false)).build());
    }

    public static void initImageLoaderL(android.content.Context context) {
        if (com.nostra13.dcloudimageloader.core.ImageLoaderL.getInstance().isInited()) {
            return;
        }
        java.io.File file = new java.io.File(getOtherImageLoaclfolder());
        if (!file.exists()) {
            file.mkdirs();
        }
        com.nostra13.dcloudimageloader.core.ImageLoaderL.getInstance().init(new com.nostra13.dcloudimageloader.core.ImageLoaderConfiguration.Builder(context).memoryCacheExtraOptions(com.facebook.common.statfs.StatFsHelper.DEFAULT_DISK_YELLOW_LEVEL_IN_MB, com.facebook.common.statfs.StatFsHelper.DEFAULT_DISK_YELLOW_LEVEL_IN_MB).tasksProcessingOrder(com.nostra13.dcloudimageloader.core.assist.QueueProcessingType.LIFO).denyCacheImageMultipleSizesInMemory().memoryCache(new com.nostra13.dcloudimageloader.cache.memory.impl.LruMemoryCache(2097152)).memoryCacheSize(2097152).threadPriority(3).threadPoolSize(3).discCacheFileCount(100).denyCacheImageMultipleSizesInMemory().defaultDisplayImageOptions(getIconDisplayOptions(context)).discCache(new com.nostra13.dcloudimageloader.cache.disc.impl.UnlimitedDiscCache(file)).imageDownloader(new com.nostra13.dcloudimageloader.core.download.BaseImageDownloader(context)).imageDecoder(new com.nostra13.dcloudimageloader.core.decode.BaseImageDecoder(false)).build());
    }

    public static boolean isDownload(java.lang.String str) {
        return downloadUrls.contains(str);
    }

    public static void updateIcon(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        java.io.File file = com.nostra13.dcloudimageloader.core.ImageLoader.getInstance().getDiscCache().get(str);
        if (file.exists()) {
            file.delete();
        }
        com.nostra13.dcloudimageloader.core.ImageLoader.getInstance().loadImage(str, null);
    }
}
