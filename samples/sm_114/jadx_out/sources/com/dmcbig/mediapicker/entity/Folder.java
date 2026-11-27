package com.dmcbig.mediapicker.entity;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class Folder implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.dmcbig.mediapicker.entity.Folder> CREATOR = new android.os.Parcelable.Creator<com.dmcbig.mediapicker.entity.Folder>() { // from class: com.dmcbig.mediapicker.entity.Folder.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.dmcbig.mediapicker.entity.Folder createFromParcel(android.os.Parcel parcel) {
            return new com.dmcbig.mediapicker.entity.Folder(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.dmcbig.mediapicker.entity.Folder[] newArray(int i) {
            return new com.dmcbig.mediapicker.entity.Folder[i];
        }
    };
    public int count;
    java.util.ArrayList<com.dmcbig.mediapicker.entity.Media> medias;
    public java.lang.String name;

    public Folder(java.lang.String str) {
        this.medias = new java.util.ArrayList<>();
        this.name = str;
    }

    public void addMedias(com.dmcbig.mediapicker.entity.Media media) {
        this.medias.add(media);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public java.util.ArrayList<com.dmcbig.mediapicker.entity.Media> getMedias() {
        return this.medias;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeInt(this.count);
        parcel.writeTypedList(this.medias);
    }

    protected Folder(android.os.Parcel parcel) {
        this.medias = new java.util.ArrayList<>();
        this.name = parcel.readString();
        this.count = parcel.readInt();
        this.medias = parcel.createTypedArrayList(com.dmcbig.mediapicker.entity.Media.CREATOR);
    }
}
