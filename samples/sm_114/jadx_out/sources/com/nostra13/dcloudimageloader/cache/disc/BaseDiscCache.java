package com.nostra13.dcloudimageloader.cache.disc;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseDiscCache implements com.nostra13.dcloudimageloader.cache.disc.DiscCacheAware {
    private static final java.lang.String ERROR_ARG_NULL = "\"%s\" argument must be not null";
    protected java.io.File cacheDir;
    private com.nostra13.dcloudimageloader.cache.disc.naming.FileNameGenerator fileNameGenerator;

    public BaseDiscCache(java.io.File file) {
        this(file, com.nostra13.dcloudimageloader.core.DefaultConfigurationFactory.createFileNameGenerator());
    }

    public BaseDiscCache(java.io.File file, com.nostra13.dcloudimageloader.cache.disc.naming.FileNameGenerator fileNameGenerator) {
        if (file == null) {
            throw new java.lang.IllegalArgumentException(java.lang.String.format(ERROR_ARG_NULL, com.taobao.weex.common.WXConfig.cacheDir));
        }
        if (fileNameGenerator == null) {
            throw new java.lang.IllegalArgumentException(java.lang.String.format(ERROR_ARG_NULL, "fileNameGenerator"));
        }
        this.cacheDir = file;
        this.fileNameGenerator = fileNameGenerator;
    }

    @Override // com.nostra13.dcloudimageloader.cache.disc.DiscCacheAware
    public java.io.File get(java.lang.String str) {
        return new java.io.File(this.cacheDir, this.fileNameGenerator.generate(str));
    }

    @Override // com.nostra13.dcloudimageloader.cache.disc.DiscCacheAware
    public void clear() {
        java.io.File[] fileArrListFiles = this.cacheDir.listFiles();
        if (fileArrListFiles != null) {
            for (java.io.File file : fileArrListFiles) {
                file.delete();
            }
        }
    }
}
