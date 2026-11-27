package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class b2 extends io.dcloud.p.e2 {
    private android.content.Context b;

    public b2(android.content.Context context, android.net.Uri uri) {
        super(uri);
        this.b = context;
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
        try {
            java.io.InputStream inputStreamOpen = this.b.getAssets().open(path.substring(1));
            return options.inJustDecodeBounds ? android.graphics.BitmapFactory.decodeStream(inputStreamOpen, null, options) : io.dcloud.p.a0.a(inputStreamOpen, options);
        } catch (java.io.IOException unused) {
            return null;
        }
    }
}
