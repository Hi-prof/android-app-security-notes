package pl.droidsonroids.gif;

/* JADX INFO: loaded from: classes2.dex */
public class GifAnimationMetaData implements java.io.Serializable, android.os.Parcelable {
    public static final android.os.Parcelable.Creator<pl.droidsonroids.gif.GifAnimationMetaData> CREATOR = new android.os.Parcelable.Creator<pl.droidsonroids.gif.GifAnimationMetaData>() { // from class: pl.droidsonroids.gif.GifAnimationMetaData.1
        @Override // android.os.Parcelable.Creator
        public pl.droidsonroids.gif.GifAnimationMetaData createFromParcel(android.os.Parcel parcel) {
            return new pl.droidsonroids.gif.GifAnimationMetaData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public pl.droidsonroids.gif.GifAnimationMetaData[] newArray(int i) {
            return new pl.droidsonroids.gif.GifAnimationMetaData[i];
        }
    };
    private static final long serialVersionUID = 5692363926580237325L;
    private final int mDuration;
    private final int mHeight;
    private final int mImageCount;
    private final int mLoopCount;
    private final long mMetadataBytesCount;
    private final long mPixelsBytesCount;
    private final int mWidth;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public GifAnimationMetaData(android.content.res.Resources resources, int i) throws android.content.res.Resources.NotFoundException, java.io.IOException {
        this(resources.openRawResourceFd(i));
    }

    public GifAnimationMetaData(android.content.res.AssetManager assetManager, java.lang.String str) throws java.io.IOException {
        this(assetManager.openFd(str));
    }

    public GifAnimationMetaData(java.lang.String str) throws java.io.IOException {
        this(new pl.droidsonroids.gif.GifInfoHandle(str));
    }

    public GifAnimationMetaData(java.io.File file) throws java.io.IOException {
        this(file.getPath());
    }

    public GifAnimationMetaData(java.io.InputStream inputStream) throws java.io.IOException {
        this(new pl.droidsonroids.gif.GifInfoHandle(inputStream));
    }

    public GifAnimationMetaData(android.content.res.AssetFileDescriptor assetFileDescriptor) throws java.io.IOException {
        this(new pl.droidsonroids.gif.GifInfoHandle(assetFileDescriptor));
    }

    public GifAnimationMetaData(java.io.FileDescriptor fileDescriptor) throws java.io.IOException {
        this(new pl.droidsonroids.gif.GifInfoHandle(fileDescriptor));
    }

    public GifAnimationMetaData(byte[] bArr) throws java.io.IOException {
        this(new pl.droidsonroids.gif.GifInfoHandle(bArr));
    }

    public GifAnimationMetaData(java.nio.ByteBuffer byteBuffer) throws java.io.IOException {
        this(new pl.droidsonroids.gif.GifInfoHandle(byteBuffer));
    }

    public GifAnimationMetaData(android.content.ContentResolver contentResolver, android.net.Uri uri) throws java.io.IOException {
        this(pl.droidsonroids.gif.GifInfoHandle.openUri(contentResolver, uri));
    }

    private GifAnimationMetaData(pl.droidsonroids.gif.GifInfoHandle gifInfoHandle) {
        this.mLoopCount = gifInfoHandle.getLoopCount();
        this.mDuration = gifInfoHandle.getDuration();
        this.mWidth = gifInfoHandle.getWidth();
        this.mHeight = gifInfoHandle.getHeight();
        this.mImageCount = gifInfoHandle.getNumberOfFrames();
        this.mMetadataBytesCount = gifInfoHandle.getMetadataByteCount();
        this.mPixelsBytesCount = gifInfoHandle.getAllocationByteCount();
        gifInfoHandle.recycle();
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getNumberOfFrames() {
        return this.mImageCount;
    }

    public int getLoopCount() {
        return this.mLoopCount;
    }

    public int getDuration() {
        return this.mDuration;
    }

    public boolean isAnimated() {
        return this.mImageCount > 1 && this.mDuration > 0;
    }

    public long getAllocationByteCount() {
        return this.mPixelsBytesCount;
    }

    public long getDrawableAllocationByteCount(pl.droidsonroids.gif.GifDrawable gifDrawable, int i) {
        long allocationByteCount;
        if (i < 1 || i > 65535) {
            throw new java.lang.IllegalStateException("Sample size " + i + " out of range <1, \uffff>");
        }
        int i2 = i * i;
        if (gifDrawable != null && !gifDrawable.mBuffer.isRecycled()) {
            allocationByteCount = gifDrawable.mBuffer.getAllocationByteCount();
        } else {
            allocationByteCount = (((long) (this.mWidth * this.mHeight)) * 4) / ((long) i2);
        }
        return (this.mPixelsBytesCount / ((long) i2)) + allocationByteCount;
    }

    public long getMetadataAllocationByteCount() {
        return this.mMetadataBytesCount;
    }

    public java.lang.String toString() {
        int i = this.mLoopCount;
        java.lang.String str = java.lang.String.format(java.util.Locale.ENGLISH, "GIF: size: %dx%d, frames: %d, loops: %s, duration: %d", java.lang.Integer.valueOf(this.mWidth), java.lang.Integer.valueOf(this.mHeight), java.lang.Integer.valueOf(this.mImageCount), i == 0 ? "Infinity" : java.lang.Integer.toString(i), java.lang.Integer.valueOf(this.mDuration));
        if (!isAnimated()) {
            return str;
        }
        return "Animated " + str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeInt(this.mLoopCount);
        parcel.writeInt(this.mDuration);
        parcel.writeInt(this.mHeight);
        parcel.writeInt(this.mWidth);
        parcel.writeInt(this.mImageCount);
        parcel.writeLong(this.mMetadataBytesCount);
        parcel.writeLong(this.mPixelsBytesCount);
    }

    private GifAnimationMetaData(android.os.Parcel parcel) {
        this.mLoopCount = parcel.readInt();
        this.mDuration = parcel.readInt();
        this.mHeight = parcel.readInt();
        this.mWidth = parcel.readInt();
        this.mImageCount = parcel.readInt();
        this.mMetadataBytesCount = parcel.readLong();
        this.mPixelsBytesCount = parcel.readLong();
    }
}
