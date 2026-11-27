package com.bumptech.glide.load.resource.bitmap;

/* JADX INFO: loaded from: classes.dex */
interface ImageReader {
    android.graphics.Bitmap decodeBitmap(android.graphics.BitmapFactory.Options options) throws java.io.IOException;

    int getImageOrientation() throws java.io.IOException;

    com.bumptech.glide.load.ImageHeaderParser.ImageType getImageType() throws java.io.IOException;

    void stopGrowingBuffers();

    public static final class ByteArrayReader implements com.bumptech.glide.load.resource.bitmap.ImageReader {
        private final com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool byteArrayPool;
        private final byte[] bytes;
        private final java.util.List<com.bumptech.glide.load.ImageHeaderParser> parsers;

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public void stopGrowingBuffers() {
        }

        ByteArrayReader(byte[] bArr, java.util.List<com.bumptech.glide.load.ImageHeaderParser> list, com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool arrayPool) {
            this.bytes = bArr;
            this.parsers = list;
            this.byteArrayPool = arrayPool;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public android.graphics.Bitmap decodeBitmap(android.graphics.BitmapFactory.Options options) {
            byte[] bArr = this.bytes;
            return android.graphics.BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public com.bumptech.glide.load.ImageHeaderParser.ImageType getImageType() throws java.io.IOException {
            return com.bumptech.glide.load.ImageHeaderParserUtils.getType(this.parsers, java.nio.ByteBuffer.wrap(this.bytes));
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public int getImageOrientation() throws java.io.IOException {
            return com.bumptech.glide.load.ImageHeaderParserUtils.getOrientation(this.parsers, java.nio.ByteBuffer.wrap(this.bytes), this.byteArrayPool);
        }
    }

    public static final class FileReader implements com.bumptech.glide.load.resource.bitmap.ImageReader {
        private final com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool byteArrayPool;
        private final java.io.File file;
        private final java.util.List<com.bumptech.glide.load.ImageHeaderParser> parsers;

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public void stopGrowingBuffers() {
        }

        FileReader(java.io.File file, java.util.List<com.bumptech.glide.load.ImageHeaderParser> list, com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool arrayPool) {
            this.file = file;
            this.parsers = list;
            this.byteArrayPool = arrayPool;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public android.graphics.Bitmap decodeBitmap(android.graphics.BitmapFactory.Options options) throws java.lang.Throwable {
            com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream recyclableBufferedInputStream = null;
            try {
                com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream recyclableBufferedInputStream2 = new com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream(new java.io.FileInputStream(this.file), this.byteArrayPool);
                try {
                    android.graphics.Bitmap bitmapDecodeStream = android.graphics.BitmapFactory.decodeStream(recyclableBufferedInputStream2, null, options);
                    try {
                        recyclableBufferedInputStream2.close();
                    } catch (java.io.IOException unused) {
                    }
                    return bitmapDecodeStream;
                } catch (java.lang.Throwable th) {
                    th = th;
                    recyclableBufferedInputStream = recyclableBufferedInputStream2;
                    if (recyclableBufferedInputStream != null) {
                        try {
                            recyclableBufferedInputStream.close();
                        } catch (java.io.IOException unused2) {
                        }
                    }
                    throw th;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public com.bumptech.glide.load.ImageHeaderParser.ImageType getImageType() throws java.lang.Throwable {
            com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream recyclableBufferedInputStream;
            java.lang.Throwable th;
            try {
                recyclableBufferedInputStream = new com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream(new java.io.FileInputStream(this.file), this.byteArrayPool);
                try {
                    com.bumptech.glide.load.ImageHeaderParser.ImageType type = com.bumptech.glide.load.ImageHeaderParserUtils.getType(this.parsers, recyclableBufferedInputStream, this.byteArrayPool);
                    try {
                        recyclableBufferedInputStream.close();
                    } catch (java.io.IOException unused) {
                    }
                    return type;
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    if (recyclableBufferedInputStream != null) {
                        try {
                            recyclableBufferedInputStream.close();
                        } catch (java.io.IOException unused2) {
                        }
                    }
                    throw th;
                }
            } catch (java.lang.Throwable th3) {
                recyclableBufferedInputStream = null;
                th = th3;
            }
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public int getImageOrientation() throws java.lang.Throwable {
            com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream recyclableBufferedInputStream;
            java.lang.Throwable th;
            try {
                recyclableBufferedInputStream = new com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream(new java.io.FileInputStream(this.file), this.byteArrayPool);
                try {
                    int orientation = com.bumptech.glide.load.ImageHeaderParserUtils.getOrientation(this.parsers, recyclableBufferedInputStream, this.byteArrayPool);
                    try {
                        recyclableBufferedInputStream.close();
                    } catch (java.io.IOException unused) {
                    }
                    return orientation;
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    if (recyclableBufferedInputStream != null) {
                        try {
                            recyclableBufferedInputStream.close();
                        } catch (java.io.IOException unused2) {
                        }
                    }
                    throw th;
                }
            } catch (java.lang.Throwable th3) {
                recyclableBufferedInputStream = null;
                th = th3;
            }
        }
    }

    public static final class ByteBufferReader implements com.bumptech.glide.load.resource.bitmap.ImageReader {
        private final java.nio.ByteBuffer buffer;
        private final com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool byteArrayPool;
        private final java.util.List<com.bumptech.glide.load.ImageHeaderParser> parsers;

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public void stopGrowingBuffers() {
        }

        ByteBufferReader(java.nio.ByteBuffer byteBuffer, java.util.List<com.bumptech.glide.load.ImageHeaderParser> list, com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool arrayPool) {
            this.buffer = byteBuffer;
            this.parsers = list;
            this.byteArrayPool = arrayPool;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public android.graphics.Bitmap decodeBitmap(android.graphics.BitmapFactory.Options options) {
            return android.graphics.BitmapFactory.decodeStream(stream(), null, options);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public com.bumptech.glide.load.ImageHeaderParser.ImageType getImageType() throws java.io.IOException {
            return com.bumptech.glide.load.ImageHeaderParserUtils.getType(this.parsers, com.bumptech.glide.util.ByteBufferUtil.rewind(this.buffer));
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public int getImageOrientation() throws java.io.IOException {
            return com.bumptech.glide.load.ImageHeaderParserUtils.getOrientation(this.parsers, com.bumptech.glide.util.ByteBufferUtil.rewind(this.buffer), this.byteArrayPool);
        }

        private java.io.InputStream stream() {
            return com.bumptech.glide.util.ByteBufferUtil.toStream(com.bumptech.glide.util.ByteBufferUtil.rewind(this.buffer));
        }
    }

    public static final class InputStreamImageReader implements com.bumptech.glide.load.resource.bitmap.ImageReader {
        private final com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool byteArrayPool;
        private final com.bumptech.glide.load.data.InputStreamRewinder dataRewinder;
        private final java.util.List<com.bumptech.glide.load.ImageHeaderParser> parsers;

        InputStreamImageReader(java.io.InputStream inputStream, java.util.List<com.bumptech.glide.load.ImageHeaderParser> list, com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool arrayPool) {
            this.byteArrayPool = (com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool) com.bumptech.glide.util.Preconditions.checkNotNull(arrayPool);
            this.parsers = (java.util.List) com.bumptech.glide.util.Preconditions.checkNotNull(list);
            this.dataRewinder = new com.bumptech.glide.load.data.InputStreamRewinder(inputStream, arrayPool);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public android.graphics.Bitmap decodeBitmap(android.graphics.BitmapFactory.Options options) throws java.io.IOException {
            return android.graphics.BitmapFactory.decodeStream(this.dataRewinder.rewindAndGet(), null, options);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public com.bumptech.glide.load.ImageHeaderParser.ImageType getImageType() throws java.io.IOException {
            return com.bumptech.glide.load.ImageHeaderParserUtils.getType(this.parsers, this.dataRewinder.rewindAndGet(), this.byteArrayPool);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public int getImageOrientation() throws java.io.IOException {
            return com.bumptech.glide.load.ImageHeaderParserUtils.getOrientation(this.parsers, this.dataRewinder.rewindAndGet(), this.byteArrayPool);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public void stopGrowingBuffers() {
            this.dataRewinder.fixMarkLimits();
        }
    }

    public static final class ParcelFileDescriptorImageReader implements com.bumptech.glide.load.resource.bitmap.ImageReader {
        private final com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool byteArrayPool;
        private final com.bumptech.glide.load.data.ParcelFileDescriptorRewinder dataRewinder;
        private final java.util.List<com.bumptech.glide.load.ImageHeaderParser> parsers;

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public void stopGrowingBuffers() {
        }

        ParcelFileDescriptorImageReader(android.os.ParcelFileDescriptor parcelFileDescriptor, java.util.List<com.bumptech.glide.load.ImageHeaderParser> list, com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool arrayPool) {
            this.byteArrayPool = (com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool) com.bumptech.glide.util.Preconditions.checkNotNull(arrayPool);
            this.parsers = (java.util.List) com.bumptech.glide.util.Preconditions.checkNotNull(list);
            this.dataRewinder = new com.bumptech.glide.load.data.ParcelFileDescriptorRewinder(parcelFileDescriptor);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public android.graphics.Bitmap decodeBitmap(android.graphics.BitmapFactory.Options options) throws java.io.IOException {
            return android.graphics.BitmapFactory.decodeFileDescriptor(this.dataRewinder.rewindAndGet().getFileDescriptor(), null, options);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public com.bumptech.glide.load.ImageHeaderParser.ImageType getImageType() throws java.io.IOException {
            return com.bumptech.glide.load.ImageHeaderParserUtils.getType(this.parsers, this.dataRewinder, this.byteArrayPool);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public int getImageOrientation() throws java.io.IOException {
            return com.bumptech.glide.load.ImageHeaderParserUtils.getOrientation(this.parsers, this.dataRewinder, this.byteArrayPool);
        }
    }
}
