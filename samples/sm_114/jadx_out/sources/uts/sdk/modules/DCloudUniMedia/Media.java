package uts.sdk.modules.DCloudUniMedia;

/* JADX INFO: loaded from: classes2.dex */
public class Media implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<uts.sdk.modules.DCloudUniMedia.Media> CREATOR = new android.os.Parcelable.Creator<uts.sdk.modules.DCloudUniMedia.Media>() { // from class: uts.sdk.modules.DCloudUniMedia.Media.1
        @Override // android.os.Parcelable.Creator
        public uts.sdk.modules.DCloudUniMedia.Media createFromParcel(android.os.Parcel parcel) {
            return new uts.sdk.modules.DCloudUniMedia.Media(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public uts.sdk.modules.DCloudUniMedia.Media[] newArray(int i) {
            return new uts.sdk.modules.DCloudUniMedia.Media[i];
        }
    };
    public java.lang.String extension;
    public int id;
    public int mediaType;
    public java.lang.String name;
    public java.lang.String parentDir;
    public java.lang.String path;
    public long size;
    public long time;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Media(java.lang.String str, java.lang.String str2, long j, int i, long j2, int i2, java.lang.String str3) {
        this.path = str;
        this.name = str2;
        if (!android.text.TextUtils.isEmpty(str2) && str2.indexOf(com.taobao.weex.el.parse.Operators.DOT_STR) != -1) {
            this.extension = str2.substring(str2.lastIndexOf(com.taobao.weex.el.parse.Operators.DOT_STR), str2.length());
        } else {
            this.extension = "null";
        }
        this.time = j;
        this.mediaType = i;
        this.size = j2;
        this.id = i2;
        this.parentDir = str3;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeString(this.path);
        parcel.writeString(this.name);
        parcel.writeString(this.extension);
        parcel.writeLong(this.time);
        parcel.writeInt(this.mediaType);
        parcel.writeLong(this.size);
        parcel.writeInt(this.id);
        parcel.writeString(this.parentDir);
    }

    protected Media(android.os.Parcel parcel) {
        this.path = parcel.readString();
        this.name = parcel.readString();
        this.extension = parcel.readString();
        this.time = parcel.readLong();
        this.mediaType = parcel.readInt();
        this.size = parcel.readLong();
        this.id = parcel.readInt();
        this.parentDir = parcel.readString();
    }
}
