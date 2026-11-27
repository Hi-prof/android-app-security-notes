package io.dcloud.feature.uniapp.adapter;

/* JADX INFO: loaded from: classes2.dex */
public interface AbsURIAdapter {
    public static final java.lang.String BUNDLE = "bundle";
    public static final java.lang.String FILE = "file";
    public static final java.lang.String FONT = "font";
    public static final java.lang.String IMAGE = "image";
    public static final java.lang.String LINK = "link";
    public static final java.lang.String OTHERS = "others";
    public static final java.lang.String REQUEST = "request";
    public static final java.lang.String VIDEO = "video";
    public static final java.lang.String WEB = "web";

    android.net.Uri rewrite(com.taobao.weex.WXSDKInstance wXSDKInstance, java.lang.String str, android.net.Uri uri);

    android.net.Uri rewrite(java.lang.String str, java.lang.String str2, android.net.Uri uri);
}
