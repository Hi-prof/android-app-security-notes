package com.nostra13.dcloudimageloader.cache.disc.naming;

/* JADX INFO: loaded from: classes.dex */
public class HashCodeFileNameGenerator implements com.nostra13.dcloudimageloader.cache.disc.naming.FileNameGenerator {
    @Override // com.nostra13.dcloudimageloader.cache.disc.naming.FileNameGenerator
    public java.lang.String generate(java.lang.String str) {
        return java.lang.String.valueOf(str.hashCode());
    }
}
