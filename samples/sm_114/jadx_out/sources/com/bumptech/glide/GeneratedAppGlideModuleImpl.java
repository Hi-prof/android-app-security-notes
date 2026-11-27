package com.bumptech.glide;

/* JADX INFO: loaded from: classes.dex */
final class GeneratedAppGlideModuleImpl extends com.bumptech.glide.GeneratedAppGlideModule {
    private final io.dcloud.glide.DCloudGlideModule appGlideModule = new io.dcloud.glide.DCloudGlideModule();

    public GeneratedAppGlideModuleImpl(android.content.Context context) {
        if (android.util.Log.isLoggable("Glide", 3)) {
            android.util.Log.d("Glide", "Discovered AppGlideModule from annotation: io.dcloud.glide.DCloudGlideModule");
        }
    }

    @Override // com.bumptech.glide.module.AppGlideModule, com.bumptech.glide.module.AppliesOptions
    public void applyOptions(android.content.Context context, com.bumptech.glide.GlideBuilder glideBuilder) {
        this.appGlideModule.applyOptions(context, glideBuilder);
    }

    @Override // com.bumptech.glide.module.LibraryGlideModule, com.bumptech.glide.module.RegistersComponents
    public void registerComponents(android.content.Context context, com.bumptech.glide.Glide glide, com.bumptech.glide.Registry registry) {
        this.appGlideModule.registerComponents(context, glide, registry);
    }

    @Override // com.bumptech.glide.module.AppGlideModule
    public boolean isManifestParsingEnabled() {
        return this.appGlideModule.isManifestParsingEnabled();
    }

    @Override // com.bumptech.glide.GeneratedAppGlideModule
    public java.util.Set<java.lang.Class<?>> getExcludedModuleClasses() {
        return java.util.Collections.EMPTY_SET;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bumptech.glide.GeneratedAppGlideModule
    public com.bumptech.glide.GeneratedRequestManagerFactory getRequestManagerFactory() {
        return new com.bumptech.glide.GeneratedRequestManagerFactory();
    }
}
