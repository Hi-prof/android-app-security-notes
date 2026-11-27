package com.taobao.weex.utils;

/* JADX INFO: loaded from: classes.dex */
public class ImgURIUtil {
    public static android.graphics.drawable.Drawable getDrawableFromLoaclSrc(android.content.Context context, android.net.Uri uri) {
        android.content.res.Resources resources = context.getResources();
        java.util.List<java.lang.String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() != 1) {
            com.taobao.weex.utils.WXLogUtils.e("Local src format is invalid.");
            return null;
        }
        int identifier = resources.getIdentifier(pathSegments.get(0), "drawable", context.getPackageName());
        if (identifier == 0) {
            return null;
        }
        return androidx.core.content.res.ResourcesCompat.getDrawable(resources, identifier, null);
    }
}
