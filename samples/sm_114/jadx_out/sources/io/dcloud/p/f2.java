package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class f2 extends io.dcloud.p.e2 {
    public f2(android.net.Uri uri) {
        super(uri);
    }

    @Override // io.dcloud.p.e2
    public android.graphics.Bitmap a(android.graphics.BitmapFactory.Options options) {
        android.net.Uri uriA = a();
        if (uriA == null) {
            return null;
        }
        java.lang.String path = uriA.getPath();
        if (android.text.TextUtils.isEmpty(path)) {
            return null;
        }
        java.io.File file = new java.io.File(path);
        if (file.exists()) {
            return options.inJustDecodeBounds ? android.graphics.BitmapFactory.decodeFile(path, options) : io.dcloud.p.a0.a(file, options);
        }
        return null;
    }
}
