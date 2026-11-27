package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public abstract class e2 {
    private android.net.Uri a;

    public e2(android.net.Uri uri) {
        this.a = uri;
    }

    public abstract android.graphics.Bitmap a(android.graphics.BitmapFactory.Options options);

    public android.net.Uri a() {
        return this.a;
    }
}
