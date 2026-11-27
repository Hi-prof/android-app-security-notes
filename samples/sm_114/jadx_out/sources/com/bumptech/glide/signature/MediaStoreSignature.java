package com.bumptech.glide.signature;

/* JADX INFO: loaded from: classes.dex */
public class MediaStoreSignature implements com.bumptech.glide.load.Key {
    private final long dateModified;
    private final java.lang.String mimeType;
    private final int orientation;

    public MediaStoreSignature(java.lang.String str, long j, int i) {
        this.mimeType = str == null ? "" : str;
        this.dateModified = j;
        this.orientation = i;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        com.bumptech.glide.signature.MediaStoreSignature mediaStoreSignature = (com.bumptech.glide.signature.MediaStoreSignature) obj;
        return this.dateModified == mediaStoreSignature.dateModified && this.orientation == mediaStoreSignature.orientation && this.mimeType.equals(mediaStoreSignature.mimeType);
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        int iHashCode = this.mimeType.hashCode() * 31;
        long j = this.dateModified;
        return ((iHashCode + ((int) (j ^ (j >>> 32)))) * 31) + this.orientation;
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(java.security.MessageDigest messageDigest) {
        messageDigest.update(java.nio.ByteBuffer.allocate(12).putLong(this.dateModified).putInt(this.orientation).array());
        messageDigest.update(this.mimeType.getBytes(CHARSET));
    }
}
