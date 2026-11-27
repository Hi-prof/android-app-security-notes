package master.flame.danmaku.danmaku.parser.android;

/* JADX INFO: loaded from: classes2.dex */
public class JSONSource implements master.flame.danmaku.danmaku.parser.IDataSource<org.json.JSONArray> {
    private java.io.InputStream mInput;
    private org.json.JSONArray mJSONArray;

    public JSONSource(java.lang.String str) throws org.json.JSONException {
        init(str);
    }

    public JSONSource(java.io.InputStream inputStream) throws org.json.JSONException {
        init(inputStream);
    }

    private void init(java.io.InputStream inputStream) throws org.json.JSONException {
        if (inputStream == null) {
            throw new java.lang.NullPointerException("input stream cannot be null!");
        }
        this.mInput = inputStream;
        init(master.flame.danmaku.danmaku.util.IOUtils.getString(inputStream));
    }

    public JSONSource(java.net.URL url) throws org.json.JSONException, java.io.IOException {
        this(url.openStream());
    }

    public JSONSource(java.io.File file) throws org.json.JSONException, java.io.FileNotFoundException {
        init(new java.io.FileInputStream(file));
    }

    public JSONSource(android.net.Uri uri) throws org.json.JSONException, java.io.IOException {
        java.lang.String scheme = uri.getScheme();
        if ("http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme)) {
            init(new java.net.URL(uri.getPath()).openStream());
        } else if ("file".equalsIgnoreCase(scheme)) {
            init(new java.io.FileInputStream(uri.getPath()));
        }
    }

    private void init(java.lang.String str) throws org.json.JSONException {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        this.mJSONArray = new org.json.JSONArray(str);
    }

    @Override // master.flame.danmaku.danmaku.parser.IDataSource
    public org.json.JSONArray data() {
        return this.mJSONArray;
    }

    @Override // master.flame.danmaku.danmaku.parser.IDataSource
    public void release() {
        master.flame.danmaku.danmaku.util.IOUtils.closeQuietly(this.mInput);
        this.mInput = null;
        this.mJSONArray = null;
    }
}
