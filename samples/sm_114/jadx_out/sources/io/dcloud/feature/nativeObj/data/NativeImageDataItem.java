package io.dcloud.feature.nativeObj.data;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class NativeImageDataItem implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<io.dcloud.feature.nativeObj.data.NativeImageDataItem> CREATOR = new android.os.Parcelable.Creator<io.dcloud.feature.nativeObj.data.NativeImageDataItem>() { // from class: io.dcloud.feature.nativeObj.data.NativeImageDataItem.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public io.dcloud.feature.nativeObj.data.NativeImageDataItem createFromParcel(android.os.Parcel parcel) {
            return new io.dcloud.feature.nativeObj.data.NativeImageDataItem(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public io.dcloud.feature.nativeObj.data.NativeImageDataItem[] newArray(int i) {
            return new io.dcloud.feature.nativeObj.data.NativeImageDataItem[i];
        }
    };
    public java.lang.String align;
    public java.lang.String height;
    java.lang.String url;
    public java.lang.String verticalAlign;
    public java.lang.String width;

    public NativeImageDataItem() {
        this.url = "";
        this.align = "center";
        this.verticalAlign = "middle";
        this.height = "auto";
        this.width = "auto";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getHeight(int i, float f) {
        if (this.height.equals("auto")) {
            return -100;
        }
        return io.dcloud.common.util.PdrUtil.convertToScreenInt(this.height, i, i, f);
    }

    public java.lang.String getUrl() {
        return this.url;
    }

    public int getWidth(int i, float f) {
        if (this.width.equals("auto")) {
            return -100;
        }
        return io.dcloud.common.util.PdrUtil.convertToScreenInt(this.width, i, i, f);
    }

    public void setUrl(java.lang.String str) {
        this.url = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeString(this.url);
        parcel.writeString(this.align);
        parcel.writeString(this.verticalAlign);
        parcel.writeString(this.height);
        parcel.writeString(this.width);
    }

    protected NativeImageDataItem(android.os.Parcel parcel) {
        this.url = "";
        this.align = "center";
        this.verticalAlign = "middle";
        this.height = "auto";
        this.width = "auto";
        this.url = parcel.readString();
        this.align = parcel.readString();
        this.verticalAlign = parcel.readString();
        this.height = parcel.readString();
        this.width = parcel.readString();
    }
}
