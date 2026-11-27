package com.taobao.weex.adapter;

/* JADX INFO: loaded from: classes.dex */
public class DefaultUriAdapter implements com.taobao.weex.adapter.URIAdapter {
    @Override // io.dcloud.feature.uniapp.adapter.AbsURIAdapter
    public android.net.Uri rewrite(com.taobao.weex.WXSDKInstance wXSDKInstance, java.lang.String str, android.net.Uri uri) {
        return rewrite(wXSDKInstance.getBundleUrl(), str, uri);
    }

    @Override // io.dcloud.feature.uniapp.adapter.AbsURIAdapter
    public android.net.Uri rewrite(java.lang.String str, java.lang.String str2, android.net.Uri uri) {
        if (!android.text.TextUtils.isEmpty(str)) {
            android.net.Uri uri2 = android.net.Uri.parse(str);
            android.net.Uri.Builder builderBuildUpon = uri.buildUpon();
            if (uri.isRelative()) {
                if (uri.getEncodedPath().length() == 0) {
                    if (!"image".equals(str2) || !android.text.TextUtils.isEmpty(uri.toString())) {
                        return uri2;
                    }
                } else {
                    return buildRelativeURI(builderBuildUpon, uri2, uri).build();
                }
            }
        }
        return uri;
    }

    private android.net.Uri.Builder buildRelativeURI(android.net.Uri.Builder builder, android.net.Uri uri, android.net.Uri uri2) {
        if (uri2.getAuthority() != null) {
            return builder.scheme(uri.getScheme());
        }
        builder.encodedAuthority(uri.getEncodedAuthority()).scheme(uri.getScheme()).path(null);
        if (uri2.getPath().startsWith("/")) {
            builder.appendEncodedPath(uri2.getEncodedPath().substring(1));
            return builder;
        }
        java.util.List<java.lang.String> pathSegments = uri.getPathSegments();
        int size = pathSegments.size() - (!uri.getPath().endsWith("/") ? 1 : 0);
        for (int i = 0; i < size; i++) {
            builder.appendEncodedPath(pathSegments.get(i));
        }
        builder.appendEncodedPath(uri2.getEncodedPath());
        return builder;
    }
}
