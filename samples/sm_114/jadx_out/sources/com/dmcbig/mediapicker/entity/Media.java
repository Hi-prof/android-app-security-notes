package com.dmcbig.mediapicker.entity;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class Media implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.dmcbig.mediapicker.entity.Media> CREATOR = new android.os.Parcelable.Creator<com.dmcbig.mediapicker.entity.Media>() { // from class: com.dmcbig.mediapicker.entity.Media.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.dmcbig.mediapicker.entity.Media createFromParcel(android.os.Parcel parcel) {
            return new com.dmcbig.mediapicker.entity.Media(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.dmcbig.mediapicker.entity.Media[] newArray(int i) {
            return new com.dmcbig.mediapicker.entity.Media[i];
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

    public Media(java.lang.String str, java.lang.String str2, long j, int i, long j2, int i2, java.lang.String str3) {
        this.path = str;
        this.name = str2;
        if (android.text.TextUtils.isEmpty(str2) || str2.indexOf(com.taobao.weex.el.parse.Operators.DOT_STR) == -1) {
            this.extension = "null";
        } else {
            this.extension = str2.substring(str2.lastIndexOf(com.taobao.weex.el.parse.Operators.DOT_STR), str2.length());
        }
        this.time = j;
        this.mediaType = i;
        this.size = j2;
        this.id = i2;
        this.parentDir = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
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
