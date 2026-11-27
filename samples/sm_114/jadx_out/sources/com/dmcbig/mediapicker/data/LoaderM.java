package com.dmcbig.mediapicker.data;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class LoaderM {
    public java.lang.String getParent(java.lang.String str) {
        java.lang.String[] strArrSplit = str.split("/");
        return strArrSplit[strArrSplit.length - 2];
    }

    public int hasDir(java.util.ArrayList<com.dmcbig.mediapicker.entity.Folder> arrayList, java.lang.String str) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).name.equals(str)) {
                return i;
            }
        }
        return -1;
    }
}
