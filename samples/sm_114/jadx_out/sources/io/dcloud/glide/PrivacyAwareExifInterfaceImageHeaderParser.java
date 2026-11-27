package io.dcloud.glide;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class PrivacyAwareExifInterfaceImageHeaderParser implements com.bumptech.glide.load.ImageHeaderParser {
    @Override // com.bumptech.glide.load.ImageHeaderParser
    public int getOrientation(java.io.InputStream inputStream, com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool arrayPool) throws java.io.IOException {
        int attributeInt;
        if (io.dcloud.common.adapter.util.DeviceInfo.sApplicationContext == null || !io.dcloud.common.ui.PrivacyManager.getInstance().isAgreePrivacy(io.dcloud.common.adapter.util.DeviceInfo.sApplicationContext) || (attributeInt = new io.dcloud.common.util.ExifInterface(inputStream).getAttributeInt("Orientation", 1)) == 0) {
            return -1;
        }
        return attributeInt;
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public com.bumptech.glide.load.ImageHeaderParser.ImageType getType(java.io.InputStream inputStream) throws java.io.IOException {
        return com.bumptech.glide.load.ImageHeaderParser.ImageType.UNKNOWN;
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public com.bumptech.glide.load.ImageHeaderParser.ImageType getType(java.nio.ByteBuffer byteBuffer) throws java.io.IOException {
        return com.bumptech.glide.load.ImageHeaderParser.ImageType.UNKNOWN;
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public int getOrientation(java.nio.ByteBuffer byteBuffer, com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool arrayPool) throws java.io.IOException {
        return getOrientation(com.bumptech.glide.util.ByteBufferUtil.toStream(byteBuffer), arrayPool);
    }
}
