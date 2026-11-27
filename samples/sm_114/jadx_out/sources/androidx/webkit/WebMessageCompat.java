package androidx.webkit;

/* JADX INFO: loaded from: classes.dex */
public class WebMessageCompat {
    private java.lang.String mData;
    private androidx.webkit.WebMessagePortCompat[] mPorts;

    public WebMessageCompat(java.lang.String str) {
        this.mData = str;
    }

    public WebMessageCompat(java.lang.String str, androidx.webkit.WebMessagePortCompat[] webMessagePortCompatArr) {
        this.mData = str;
        this.mPorts = webMessagePortCompatArr;
    }

    public java.lang.String getData() {
        return this.mData;
    }

    public androidx.webkit.WebMessagePortCompat[] getPorts() {
        return this.mPorts;
    }
}
