package io.dcloud.glide;

/* JADX INFO: loaded from: classes2.dex */
public class DCloudGlideModule extends com.bumptech.glide.module.AppGlideModule {
    @Override // com.bumptech.glide.module.LibraryGlideModule, com.bumptech.glide.module.RegistersComponents
    public void registerComponents(android.content.Context context, com.bumptech.glide.Glide glide, com.bumptech.glide.Registry registry) {
        java.util.Iterator<com.bumptech.glide.load.ImageHeaderParser> it = registry.getImageHeaderParsers().iterator();
        while (it.hasNext()) {
            if (it.next() instanceof com.bumptech.glide.load.resource.bitmap.ExifInterfaceImageHeaderParser) {
                it.remove();
            }
        }
        registry.register(new io.dcloud.glide.PrivacyAwareExifInterfaceImageHeaderParser());
    }
}
