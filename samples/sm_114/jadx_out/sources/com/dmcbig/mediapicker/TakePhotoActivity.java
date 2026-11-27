package com.dmcbig.mediapicker;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class TakePhotoActivity extends android.app.Activity {
    android.net.Uri NuriForFile;
    java.io.File mTmpFile = null;

    private java.io.File createImageFile() throws java.io.IOException {
        return java.io.File.createTempFile("JPEG_" + new java.text.SimpleDateFormat("yyyyMMdd_HHmmss").format(new java.util.Date()) + "_", ".jpg", getExternalFilesDir(android.os.Environment.DIRECTORY_PICTURES));
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, android.content.Intent intent) {
        super.onActivityResult(i, i2, intent);
        java.util.ArrayList<? extends android.os.Parcelable> arrayList = new java.util.ArrayList<>();
        if (i == 100 || (i == 101 && i2 == -1 && this.mTmpFile.length() > 0)) {
            arrayList.add(new com.dmcbig.mediapicker.entity.Media(this.mTmpFile.getPath(), this.mTmpFile.getName(), 0L, 1, this.mTmpFile.length(), 0, ""));
        }
        android.content.Intent intent2 = new android.content.Intent();
        intent2.putParcelableArrayListExtra(com.dmcbig.mediapicker.PickerConfig.EXTRA_RESULT, arrayList);
        setResult(com.dmcbig.mediapicker.PickerConfig.RESULT_CODE, intent2);
        finish();
    }

    @Override // android.app.Activity
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        android.content.Intent intent = new android.content.Intent("android.media.action.IMAGE_CAPTURE");
        try {
            this.mTmpFile = createImageFile();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            android.net.Uri uriForFile = androidx.core.content.FileProvider.getUriForFile(this, getPackageName() + ".dmc", this.mTmpFile);
            this.NuriForFile = uriForFile;
            intent.putExtra("output", uriForFile);
            startActivityForResult(intent, 100);
            return;
        }
        java.io.File file = this.mTmpFile;
        if (file == null || !file.exists()) {
            com.dcloud.android.widget.toast.ToastCompat.makeText((android.content.Context) this, (java.lang.CharSequence) "take error", 0).show();
            finish();
        } else {
            intent.putExtra("output", android.net.Uri.fromFile(this.mTmpFile));
            startActivityForResult(intent, 101);
        }
    }
}
