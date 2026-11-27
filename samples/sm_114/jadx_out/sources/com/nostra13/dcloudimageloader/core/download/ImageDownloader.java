package com.nostra13.dcloudimageloader.core.download;

/* JADX INFO: loaded from: classes.dex */
public interface ImageDownloader {
    java.io.InputStream getStream(java.lang.String str, java.lang.Object obj) throws java.io.IOException;

    public enum Scheme {
        HTTP("http"),
        HTTPS("https"),
        FILE("file"),
        CONTENT(com.facebook.common.util.UriUtil.LOCAL_CONTENT_SCHEME),
        ASSETS("assets"),
        DRAWABLE("drawable"),
        UNKNOWN("");

        private java.lang.String scheme;
        private java.lang.String uriPrefix;

        Scheme(java.lang.String str) {
            this.scheme = str;
            this.uriPrefix = str + "://";
        }

        public static com.nostra13.dcloudimageloader.core.download.ImageDownloader.Scheme ofUri(java.lang.String str) {
            if (str != null) {
                for (com.nostra13.dcloudimageloader.core.download.ImageDownloader.Scheme scheme : values()) {
                    if (scheme.belongsTo(str)) {
                        return scheme;
                    }
                }
            }
            return UNKNOWN;
        }

        private boolean belongsTo(java.lang.String str) {
            return str.toLowerCase(java.util.Locale.US).startsWith(this.uriPrefix);
        }

        public java.lang.String wrap(java.lang.String str) {
            return this.uriPrefix + str;
        }

        public java.lang.String crop(java.lang.String str) {
            if (!belongsTo(str)) {
                throw new java.lang.IllegalArgumentException(java.lang.String.format("URI [%1$s] doesn't have expected scheme [%2$s]", str, this.scheme));
            }
            return str.substring(this.uriPrefix.length());
        }
    }
}
