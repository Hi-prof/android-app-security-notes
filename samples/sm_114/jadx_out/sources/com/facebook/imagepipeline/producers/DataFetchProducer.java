package com.facebook.imagepipeline.producers;

/* JADX INFO: loaded from: classes.dex */
public class DataFetchProducer extends com.facebook.imagepipeline.producers.LocalFetchProducer {
    public static final java.lang.String PRODUCER_NAME = "DataFetchProducer";

    public DataFetchProducer(com.facebook.common.memory.PooledByteBufferFactory pooledByteBufferFactory) {
        super(com.facebook.common.executors.CallerThreadExecutor.getInstance(), pooledByteBufferFactory);
    }

    @Override // com.facebook.imagepipeline.producers.LocalFetchProducer
    protected com.facebook.imagepipeline.image.EncodedImage getEncodedImage(com.facebook.imagepipeline.request.ImageRequest imageRequest) throws java.io.IOException {
        byte[] data = getData(imageRequest.getSourceUri().toString());
        return getByteBufferBackedEncodedImage(new java.io.ByteArrayInputStream(data), data.length);
    }

    @Override // com.facebook.imagepipeline.producers.LocalFetchProducer
    protected java.lang.String getProducerName() {
        return PRODUCER_NAME;
    }

    static byte[] getData(java.lang.String str) {
        com.facebook.common.internal.Preconditions.checkArgument(java.lang.Boolean.valueOf(str.substring(0, 5).equals("data:")));
        int iIndexOf = str.indexOf(44);
        java.lang.String strSubstring = str.substring(iIndexOf + 1, str.length());
        if (isBase64(str.substring(0, iIndexOf))) {
            return android.util.Base64.decode(strSubstring, 0);
        }
        java.lang.String strDecode = android.net.Uri.decode(strSubstring);
        com.facebook.common.internal.Preconditions.checkNotNull(strDecode);
        return strDecode.getBytes();
    }

    static boolean isBase64(java.lang.String str) {
        if (!str.contains(";")) {
            return false;
        }
        java.lang.String[] strArrSplit = str.split(";");
        return strArrSplit[strArrSplit.length - 1].equals("base64");
    }
}
