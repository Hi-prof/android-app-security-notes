package com.bumptech.glide.load;

/* JADX INFO: loaded from: classes.dex */
public final class ImageHeaderParserUtils {
    private static final int MARK_READ_LIMIT = 5242880;

    private interface OrientationReader {
        int getOrientationAndRewind(com.bumptech.glide.load.ImageHeaderParser imageHeaderParser) throws java.io.IOException;
    }

    private interface TypeReader {
        com.bumptech.glide.load.ImageHeaderParser.ImageType getTypeAndRewind(com.bumptech.glide.load.ImageHeaderParser imageHeaderParser) throws java.io.IOException;
    }

    private ImageHeaderParserUtils() {
    }

    public static com.bumptech.glide.load.ImageHeaderParser.ImageType getType(java.util.List<com.bumptech.glide.load.ImageHeaderParser> list, final java.io.InputStream inputStream, com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool arrayPool) throws java.io.IOException {
        if (inputStream == null) {
            return com.bumptech.glide.load.ImageHeaderParser.ImageType.UNKNOWN;
        }
        if (!inputStream.markSupported()) {
            inputStream = new com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream(inputStream, arrayPool);
        }
        inputStream.mark(MARK_READ_LIMIT);
        return getTypeInternal(list, new com.bumptech.glide.load.ImageHeaderParserUtils.TypeReader() { // from class: com.bumptech.glide.load.ImageHeaderParserUtils.1
            @Override // com.bumptech.glide.load.ImageHeaderParserUtils.TypeReader
            public com.bumptech.glide.load.ImageHeaderParser.ImageType getTypeAndRewind(com.bumptech.glide.load.ImageHeaderParser imageHeaderParser) throws java.io.IOException {
                try {
                    return imageHeaderParser.getType(inputStream);
                } finally {
                    inputStream.reset();
                }
            }
        });
    }

    public static com.bumptech.glide.load.ImageHeaderParser.ImageType getType(java.util.List<com.bumptech.glide.load.ImageHeaderParser> list, final java.nio.ByteBuffer byteBuffer) throws java.io.IOException {
        if (byteBuffer == null) {
            return com.bumptech.glide.load.ImageHeaderParser.ImageType.UNKNOWN;
        }
        return getTypeInternal(list, new com.bumptech.glide.load.ImageHeaderParserUtils.TypeReader() { // from class: com.bumptech.glide.load.ImageHeaderParserUtils.2
            @Override // com.bumptech.glide.load.ImageHeaderParserUtils.TypeReader
            public com.bumptech.glide.load.ImageHeaderParser.ImageType getTypeAndRewind(com.bumptech.glide.load.ImageHeaderParser imageHeaderParser) throws java.io.IOException {
                try {
                    return imageHeaderParser.getType(byteBuffer);
                } finally {
                    com.bumptech.glide.util.ByteBufferUtil.rewind(byteBuffer);
                }
            }
        });
    }

    public static com.bumptech.glide.load.ImageHeaderParser.ImageType getType(java.util.List<com.bumptech.glide.load.ImageHeaderParser> list, final com.bumptech.glide.load.data.ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, final com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool arrayPool) throws java.io.IOException {
        return getTypeInternal(list, new com.bumptech.glide.load.ImageHeaderParserUtils.TypeReader() { // from class: com.bumptech.glide.load.ImageHeaderParserUtils.3
            @Override // com.bumptech.glide.load.ImageHeaderParserUtils.TypeReader
            public com.bumptech.glide.load.ImageHeaderParser.ImageType getTypeAndRewind(com.bumptech.glide.load.ImageHeaderParser imageHeaderParser) throws java.lang.Throwable {
                com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream recyclableBufferedInputStream = null;
                try {
                    com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream recyclableBufferedInputStream2 = new com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream(new java.io.FileInputStream(parcelFileDescriptorRewinder.rewindAndGet().getFileDescriptor()), arrayPool);
                    try {
                        com.bumptech.glide.load.ImageHeaderParser.ImageType type = imageHeaderParser.getType(recyclableBufferedInputStream2);
                        recyclableBufferedInputStream2.release();
                        parcelFileDescriptorRewinder.rewindAndGet();
                        return type;
                    } catch (java.lang.Throwable th) {
                        th = th;
                        recyclableBufferedInputStream = recyclableBufferedInputStream2;
                        if (recyclableBufferedInputStream != null) {
                            recyclableBufferedInputStream.release();
                        }
                        parcelFileDescriptorRewinder.rewindAndGet();
                        throw th;
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                }
            }
        });
    }

    private static com.bumptech.glide.load.ImageHeaderParser.ImageType getTypeInternal(java.util.List<com.bumptech.glide.load.ImageHeaderParser> list, com.bumptech.glide.load.ImageHeaderParserUtils.TypeReader typeReader) throws java.io.IOException {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            com.bumptech.glide.load.ImageHeaderParser.ImageType typeAndRewind = typeReader.getTypeAndRewind(list.get(i));
            if (typeAndRewind != com.bumptech.glide.load.ImageHeaderParser.ImageType.UNKNOWN) {
                return typeAndRewind;
            }
        }
        return com.bumptech.glide.load.ImageHeaderParser.ImageType.UNKNOWN;
    }

    public static int getOrientation(java.util.List<com.bumptech.glide.load.ImageHeaderParser> list, final java.nio.ByteBuffer byteBuffer, final com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool arrayPool) throws java.io.IOException {
        if (byteBuffer == null) {
            return -1;
        }
        return getOrientationInternal(list, new com.bumptech.glide.load.ImageHeaderParserUtils.OrientationReader() { // from class: com.bumptech.glide.load.ImageHeaderParserUtils.4
            @Override // com.bumptech.glide.load.ImageHeaderParserUtils.OrientationReader
            public int getOrientationAndRewind(com.bumptech.glide.load.ImageHeaderParser imageHeaderParser) throws java.io.IOException {
                try {
                    return imageHeaderParser.getOrientation(byteBuffer, arrayPool);
                } finally {
                    com.bumptech.glide.util.ByteBufferUtil.rewind(byteBuffer);
                }
            }
        });
    }

    public static int getOrientation(java.util.List<com.bumptech.glide.load.ImageHeaderParser> list, final java.io.InputStream inputStream, final com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool arrayPool) throws java.io.IOException {
        if (inputStream == null) {
            return -1;
        }
        if (!inputStream.markSupported()) {
            inputStream = new com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream(inputStream, arrayPool);
        }
        inputStream.mark(MARK_READ_LIMIT);
        return getOrientationInternal(list, new com.bumptech.glide.load.ImageHeaderParserUtils.OrientationReader() { // from class: com.bumptech.glide.load.ImageHeaderParserUtils.5
            @Override // com.bumptech.glide.load.ImageHeaderParserUtils.OrientationReader
            public int getOrientationAndRewind(com.bumptech.glide.load.ImageHeaderParser imageHeaderParser) throws java.io.IOException {
                try {
                    return imageHeaderParser.getOrientation(inputStream, arrayPool);
                } finally {
                    inputStream.reset();
                }
            }
        });
    }

    public static int getOrientation(java.util.List<com.bumptech.glide.load.ImageHeaderParser> list, final com.bumptech.glide.load.data.ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, final com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool arrayPool) throws java.io.IOException {
        return getOrientationInternal(list, new com.bumptech.glide.load.ImageHeaderParserUtils.OrientationReader() { // from class: com.bumptech.glide.load.ImageHeaderParserUtils.6
            @Override // com.bumptech.glide.load.ImageHeaderParserUtils.OrientationReader
            public int getOrientationAndRewind(com.bumptech.glide.load.ImageHeaderParser imageHeaderParser) throws java.lang.Throwable {
                com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream recyclableBufferedInputStream = null;
                try {
                    com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream recyclableBufferedInputStream2 = new com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream(new java.io.FileInputStream(parcelFileDescriptorRewinder.rewindAndGet().getFileDescriptor()), arrayPool);
                    try {
                        int orientation = imageHeaderParser.getOrientation(recyclableBufferedInputStream2, arrayPool);
                        recyclableBufferedInputStream2.release();
                        parcelFileDescriptorRewinder.rewindAndGet();
                        return orientation;
                    } catch (java.lang.Throwable th) {
                        th = th;
                        recyclableBufferedInputStream = recyclableBufferedInputStream2;
                        if (recyclableBufferedInputStream != null) {
                            recyclableBufferedInputStream.release();
                        }
                        parcelFileDescriptorRewinder.rewindAndGet();
                        throw th;
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                }
            }
        });
    }

    private static int getOrientationInternal(java.util.List<com.bumptech.glide.load.ImageHeaderParser> list, com.bumptech.glide.load.ImageHeaderParserUtils.OrientationReader orientationReader) throws java.io.IOException {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            int orientationAndRewind = orientationReader.getOrientationAndRewind(list.get(i));
            if (orientationAndRewind != -1) {
                return orientationAndRewind;
            }
        }
        return -1;
    }
}
