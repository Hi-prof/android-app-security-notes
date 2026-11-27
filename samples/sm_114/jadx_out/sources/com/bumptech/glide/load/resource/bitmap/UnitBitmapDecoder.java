package com.bumptech.glide.load.resource.bitmap;

/* JADX INFO: loaded from: classes.dex */
public final class UnitBitmapDecoder implements com.bumptech.glide.load.ResourceDecoder<android.graphics.Bitmap, android.graphics.Bitmap> {
    @Override // com.bumptech.glide.load.ResourceDecoder
    public boolean handles(android.graphics.Bitmap bitmap, com.bumptech.glide.load.Options options) {
        return true;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public com.bumptech.glide.load.engine.Resource<android.graphics.Bitmap> decode(android.graphics.Bitmap bitmap, int i, int i2, com.bumptech.glide.load.Options options) {
        return new com.bumptech.glide.load.resource.bitmap.UnitBitmapDecoder.NonOwnedBitmapResource(bitmap);
    }

    private static final class NonOwnedBitmapResource implements com.bumptech.glide.load.engine.Resource<android.graphics.Bitmap> {
        private final android.graphics.Bitmap bitmap;

        @Override // com.bumptech.glide.load.engine.Resource
        public void recycle() {
        }

        NonOwnedBitmapResource(android.graphics.Bitmap bitmap) {
            this.bitmap = bitmap;
        }

        @Override // com.bumptech.glide.load.engine.Resource
        public java.lang.Class<android.graphics.Bitmap> getResourceClass() {
            return android.graphics.Bitmap.class;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bumptech.glide.load.engine.Resource
        public android.graphics.Bitmap get() {
            return this.bitmap;
        }

        @Override // com.bumptech.glide.load.engine.Resource
        public int getSize() {
            return com.bumptech.glide.util.Util.getBitmapByteSize(this.bitmap);
        }
    }
}
