package io.dcloud.glide;

/* JADX INFO: loaded from: classes2.dex */
public final class GlideApp {
    private GlideApp() {
    }

    public static java.io.File getPhotoCacheDir(android.content.Context context) {
        return com.bumptech.glide.Glide.getPhotoCacheDir(context);
    }

    public static java.io.File getPhotoCacheDir(android.content.Context context, java.lang.String str) {
        return com.bumptech.glide.Glide.getPhotoCacheDir(context, str);
    }

    public static com.bumptech.glide.Glide get(android.content.Context context) {
        return com.bumptech.glide.Glide.get(context);
    }

    @java.lang.Deprecated
    public static void init(com.bumptech.glide.Glide glide) {
        com.bumptech.glide.Glide.init(glide);
    }

    public static void init(android.content.Context context, com.bumptech.glide.GlideBuilder glideBuilder) {
        com.bumptech.glide.Glide.init(context, glideBuilder);
    }

    public static void isInitialized() {
        com.bumptech.glide.Glide.isInitialized();
    }

    public static void enableHardwareBitmaps() {
        com.bumptech.glide.Glide.enableHardwareBitmaps();
    }

    public static void tearDown() {
        com.bumptech.glide.Glide.tearDown();
    }

    public static io.dcloud.glide.GlideRequests with(android.content.Context context) {
        return (io.dcloud.glide.GlideRequests) com.bumptech.glide.Glide.with(context);
    }

    @java.lang.Deprecated
    public static io.dcloud.glide.GlideRequests with(android.app.Activity activity) {
        return (io.dcloud.glide.GlideRequests) com.bumptech.glide.Glide.with(activity);
    }

    public static io.dcloud.glide.GlideRequests with(androidx.fragment.app.FragmentActivity fragmentActivity) {
        return (io.dcloud.glide.GlideRequests) com.bumptech.glide.Glide.with(fragmentActivity);
    }

    public static io.dcloud.glide.GlideRequests with(androidx.fragment.app.Fragment fragment) {
        return (io.dcloud.glide.GlideRequests) com.bumptech.glide.Glide.with(fragment);
    }

    @java.lang.Deprecated
    public static io.dcloud.glide.GlideRequests with(android.app.Fragment fragment) {
        return (io.dcloud.glide.GlideRequests) com.bumptech.glide.Glide.with(fragment);
    }

    public static io.dcloud.glide.GlideRequests with(android.view.View view) {
        return (io.dcloud.glide.GlideRequests) com.bumptech.glide.Glide.with(view);
    }
}
