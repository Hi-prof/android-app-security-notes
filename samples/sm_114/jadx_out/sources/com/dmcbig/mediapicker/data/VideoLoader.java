package com.dmcbig.mediapicker.data;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class VideoLoader extends com.dmcbig.mediapicker.data.LoaderM implements android.app.LoaderManager.LoaderCallbacks {
    java.lang.String[] MEDIA_PROJECTION = {"_data", "_display_name", "date_added", "media_type", "_size", "_id", "parent"};
    android.content.Context mContext;
    com.dmcbig.mediapicker.data.DataCallback mLoader;

    public VideoLoader(android.content.Context context, com.dmcbig.mediapicker.data.DataCallback dataCallback) {
        this.mContext = context;
        this.mLoader = dataCallback;
    }

    @Override // android.app.LoaderManager.LoaderCallbacks
    public android.content.Loader onCreateLoader(int i, android.os.Bundle bundle) {
        return new android.content.CursorLoader(this.mContext, android.provider.MediaStore.Files.getContentUri("external"), this.MEDIA_PROJECTION, "media_type=3", null, "date_added DESC");
    }

    @Override // android.app.LoaderManager.LoaderCallbacks
    public void onLoadFinished(android.content.Loader loader, java.lang.Object obj) {
        java.util.ArrayList<com.dmcbig.mediapicker.entity.Folder> arrayList = new java.util.ArrayList<>();
        com.dmcbig.mediapicker.entity.Folder folder = new com.dmcbig.mediapicker.entity.Folder(this.mContext.getResources().getString(com.dmcbig.mediapicker.MediaPickerR.MP_STRING_ALL_VIDEO));
        arrayList.add(folder);
        android.database.Cursor cursor = (android.database.Cursor) obj;
        while (cursor.moveToNext()) {
            java.lang.String string = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
            java.lang.String string2 = cursor.getString(cursor.getColumnIndexOrThrow("_display_name"));
            long j = cursor.getLong(cursor.getColumnIndexOrThrow("date_added"));
            int i = cursor.getInt(cursor.getColumnIndexOrThrow("media_type"));
            long j2 = cursor.getLong(cursor.getColumnIndexOrThrow("_size"));
            int i2 = cursor.getInt(cursor.getColumnIndexOrThrow("_id"));
            if (j2 >= 1) {
                java.lang.String parent = getParent(string);
                com.dmcbig.mediapicker.entity.Media media = new com.dmcbig.mediapicker.entity.Media(string, string2, j, i, j2, i2, parent);
                folder.addMedias(media);
                int iHasDir = hasDir(arrayList, parent);
                if (iHasDir != -1) {
                    arrayList.get(iHasDir).addMedias(media);
                } else {
                    com.dmcbig.mediapicker.entity.Folder folder2 = new com.dmcbig.mediapicker.entity.Folder(parent);
                    folder2.addMedias(media);
                    arrayList.add(folder2);
                }
            }
        }
        this.mLoader.onData(arrayList);
        cursor.close();
    }

    @Override // android.app.LoaderManager.LoaderCallbacks
    public void onLoaderReset(android.content.Loader loader) {
    }
}
