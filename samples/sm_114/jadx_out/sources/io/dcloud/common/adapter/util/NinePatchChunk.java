package io.dcloud.common.adapter.util;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class NinePatchChunk {
    public static final int NO_COLOR = 1;
    public static final int TRANSPARENT_COLOR = 0;
    public int[] mColor;
    public int[] mDivX;
    public int[] mDivY;
    public android.graphics.Rect mPaddings = new android.graphics.Rect();

    private static void checkDivCount(int i) {
        if (i == 0 || (i & 1) != 0) {
            throw new java.lang.RuntimeException("invalid nine-patch: " + i);
        }
    }

    public static io.dcloud.common.adapter.util.NinePatchChunk deserialize(byte[] bArr) {
        java.nio.ByteBuffer byteBufferOrder = java.nio.ByteBuffer.wrap(bArr).order(java.nio.ByteOrder.nativeOrder());
        if (byteBufferOrder.get() == 0) {
            return null;
        }
        io.dcloud.common.adapter.util.NinePatchChunk ninePatchChunk = new io.dcloud.common.adapter.util.NinePatchChunk();
        ninePatchChunk.mDivX = new int[byteBufferOrder.get()];
        ninePatchChunk.mDivY = new int[byteBufferOrder.get()];
        ninePatchChunk.mColor = new int[byteBufferOrder.get()];
        checkDivCount(ninePatchChunk.mDivX.length);
        checkDivCount(ninePatchChunk.mDivY.length);
        byteBufferOrder.getInt();
        byteBufferOrder.getInt();
        ninePatchChunk.mPaddings.left = byteBufferOrder.getInt();
        ninePatchChunk.mPaddings.right = byteBufferOrder.getInt();
        ninePatchChunk.mPaddings.top = byteBufferOrder.getInt();
        ninePatchChunk.mPaddings.bottom = byteBufferOrder.getInt();
        byteBufferOrder.getInt();
        readIntArray(ninePatchChunk.mDivX, byteBufferOrder);
        readIntArray(ninePatchChunk.mDivY, byteBufferOrder);
        readIntArray(ninePatchChunk.mColor, byteBufferOrder);
        return ninePatchChunk;
    }

    private static void readIntArray(int[] iArr, java.nio.ByteBuffer byteBuffer) {
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            iArr[i] = byteBuffer.getInt();
        }
    }
}
