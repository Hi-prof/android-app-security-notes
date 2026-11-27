package master.flame.danmaku.danmaku.parser.android;

/* JADX INFO: loaded from: classes2.dex */
public class AndroidFileSource implements master.flame.danmaku.danmaku.parser.IDataSource<java.io.InputStream> {
    private java.io.InputStream inStream;

    public AndroidFileSource(java.lang.String str) {
        fillStreamFromFile(new java.io.File(str));
    }

    public AndroidFileSource(android.net.Uri uri) {
        fillStreamFromUri(uri);
    }

    public AndroidFileSource(java.io.File file) {
        fillStreamFromFile(file);
    }

    public AndroidFileSource(java.io.InputStream inputStream) {
        this.inStream = inputStream;
    }

    public void fillStreamFromFile(java.io.File file) {
        try {
            this.inStream = new java.io.BufferedInputStream(new java.io.FileInputStream(file));
        } catch (java.io.FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void fillStreamFromUri(android.net.Uri uri) {
        java.lang.String scheme = uri.getScheme();
        if ("http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme)) {
            fillStreamFromHttpFile(uri);
        } else if ("file".equalsIgnoreCase(scheme)) {
            fillStreamFromFile(new java.io.File(uri.getPath()));
        }
    }

    public void fillStreamFromHttpFile(android.net.Uri uri) {
        try {
            java.net.URL url = new java.net.URL(uri.getPath());
            url.openConnection();
            this.inStream = new java.io.BufferedInputStream(url.openStream());
        } catch (java.net.MalformedURLException e) {
            e.printStackTrace();
        } catch (java.io.IOException e2) {
            e2.printStackTrace();
        }
    }

    @Override // master.flame.danmaku.danmaku.parser.IDataSource
    public void release() {
        master.flame.danmaku.danmaku.util.IOUtils.closeQuietly(this.inStream);
        this.inStream = null;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // master.flame.danmaku.danmaku.parser.IDataSource
    public java.io.InputStream data() {
        return this.inStream;
    }
}
