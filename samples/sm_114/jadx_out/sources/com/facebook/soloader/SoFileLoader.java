package com.facebook.soloader;

/* JADX INFO: loaded from: classes.dex */
public interface SoFileLoader {
    void load(java.lang.String str, int i);

    void loadBytes(java.lang.String str, com.facebook.soloader.ElfByteChannel elfByteChannel, int i);
}
