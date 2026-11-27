package com.bumptech.glide.load.resource.drawable;

/* JADX INFO: loaded from: classes.dex */
public final class DrawableDecoderCompat {
    private static volatile boolean shouldCallAppCompatResources = true;

    private DrawableDecoderCompat() {
    }

    public static android.graphics.drawable.Drawable getDrawable(android.content.Context context, android.content.Context context2, int i) {
        return getDrawable(context, context2, i, null);
    }

    public static android.graphics.drawable.Drawable getDrawable(android.content.Context context, int i, android.content.res.Resources.Theme theme) {
        return getDrawable(context, context, i, theme);
    }

    private static android.graphics.drawable.Drawable getDrawable(android.content.Context context, android.content.Context context2, int i, android.content.res.Resources.Theme theme) {
        try {
            if (shouldCallAppCompatResources) {
                return loadDrawableV7(context2, i, theme);
            }
        } catch (android.content.res.Resources.NotFoundException unused) {
        } catch (java.lang.IllegalStateException e) {
            if (context.getPackageName().equals(context2.getPackageName())) {
                throw e;
            }
            return androidx.core.content.ContextCompat.getDrawable(context2, i);
        } catch (java.lang.NoClassDefFoundError unused2) {
            shouldCallAppCompatResources = false;
        }
        if (theme == null) {
            theme = context2.getTheme();
        }
        return loadDrawableV4(context2, i, theme);
    }

    private static android.graphics.drawable.Drawable loadDrawableV7(android.content.Context context, int i, android.content.res.Resources.Theme theme) {
        if (theme != null) {
            androidx.appcompat.view.ContextThemeWrapper contextThemeWrapper = new androidx.appcompat.view.ContextThemeWrapper(context, theme);
            contextThemeWrapper.applyOverrideConfiguration(theme.getResources().getConfiguration());
            context = contextThemeWrapper;
        }
        return androidx.appcompat.content.res.AppCompatResources.getDrawable(context, i);
    }

    private static android.graphics.drawable.Drawable loadDrawableV4(android.content.Context context, int i, android.content.res.Resources.Theme theme) {
        return androidx.core.content.res.ResourcesCompat.getDrawable(context.getResources(), i, theme);
    }
}
