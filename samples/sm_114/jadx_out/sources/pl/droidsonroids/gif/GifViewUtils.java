package pl.droidsonroids.gif;

/* JADX INFO: loaded from: classes2.dex */
final class GifViewUtils {
    static final java.lang.String ANDROID_NS = "http://schemas.android.com/apk/res/android";
    static final java.util.List<java.lang.String> SUPPORTED_RESOURCE_TYPE_NAMES = java.util.Arrays.asList("raw", "drawable", "mipmap");

    private GifViewUtils() {
    }

    static pl.droidsonroids.gif.GifViewUtils.GifImageViewAttributes initImageView(android.widget.ImageView imageView, android.util.AttributeSet attributeSet, int i, int i2) {
        if (attributeSet != null && !imageView.isInEditMode()) {
            pl.droidsonroids.gif.GifViewUtils.GifImageViewAttributes gifImageViewAttributes = new pl.droidsonroids.gif.GifViewUtils.GifImageViewAttributes(imageView, attributeSet, i, i2);
            int i3 = gifImageViewAttributes.mLoopCount;
            if (i3 >= 0) {
                applyLoopCount(i3, imageView.getDrawable());
                applyLoopCount(i3, imageView.getBackground());
            }
            return gifImageViewAttributes;
        }
        return new pl.droidsonroids.gif.GifViewUtils.GifImageViewAttributes();
    }

    static void applyLoopCount(int i, android.graphics.drawable.Drawable drawable) {
        if (drawable instanceof pl.droidsonroids.gif.GifDrawable) {
            ((pl.droidsonroids.gif.GifDrawable) drawable).setLoopCount(i);
        }
    }

    static boolean setResource(android.widget.ImageView imageView, boolean z, int i) {
        android.content.res.Resources resources = imageView.getResources();
        if (resources != null) {
            try {
                if (!SUPPORTED_RESOURCE_TYPE_NAMES.contains(resources.getResourceTypeName(i))) {
                    return false;
                }
                pl.droidsonroids.gif.GifDrawable gifDrawable = new pl.droidsonroids.gif.GifDrawable(resources, i);
                if (z) {
                    imageView.setImageDrawable(gifDrawable);
                    return true;
                }
                imageView.setBackground(gifDrawable);
                return true;
            } catch (android.content.res.Resources.NotFoundException | java.io.IOException unused) {
            }
        }
        return false;
    }

    static boolean setGifImageUri(android.widget.ImageView imageView, android.net.Uri uri) {
        if (uri == null) {
            return false;
        }
        try {
            imageView.setImageDrawable(new pl.droidsonroids.gif.GifDrawable(imageView.getContext().getContentResolver(), uri));
            return true;
        } catch (java.io.IOException unused) {
            return false;
        }
    }

    static float getDensityScale(android.content.res.Resources resources, int i) {
        android.util.TypedValue typedValue = new android.util.TypedValue();
        resources.getValue(i, typedValue, true);
        int i2 = typedValue.density;
        if (i2 == 0) {
            i2 = com.alibaba.fastjson.asm.Opcodes.IF_ICMPNE;
        } else if (i2 == 65535) {
            i2 = 0;
        }
        int i3 = resources.getDisplayMetrics().densityDpi;
        if (i2 <= 0 || i3 <= 0) {
            return 1.0f;
        }
        return i3 / i2;
    }

    static class GifViewAttributes {
        boolean freezesAnimation;
        final int mLoopCount;

        GifViewAttributes(android.view.View view, android.util.AttributeSet attributeSet, int i, int i2) {
            android.content.res.TypedArray typedArrayObtainStyledAttributes = view.getContext().obtainStyledAttributes(attributeSet, pl.droidsonroids.gif.R.styleable.GifView, i, i2);
            this.freezesAnimation = typedArrayObtainStyledAttributes.getBoolean(pl.droidsonroids.gif.R.styleable.GifView_freezesAnimation, false);
            this.mLoopCount = typedArrayObtainStyledAttributes.getInt(pl.droidsonroids.gif.R.styleable.GifView_loopCount, -1);
            typedArrayObtainStyledAttributes.recycle();
        }

        GifViewAttributes() {
            this.freezesAnimation = false;
            this.mLoopCount = -1;
        }
    }

    static class GifImageViewAttributes extends pl.droidsonroids.gif.GifViewUtils.GifViewAttributes {
        final int mBackgroundResId;
        final int mSourceResId;

        GifImageViewAttributes(android.widget.ImageView imageView, android.util.AttributeSet attributeSet, int i, int i2) {
            super(imageView, attributeSet, i, i2);
            this.mSourceResId = getResourceId(imageView, attributeSet, true);
            this.mBackgroundResId = getResourceId(imageView, attributeSet, false);
        }

        GifImageViewAttributes() {
            this.mSourceResId = 0;
            this.mBackgroundResId = 0;
        }

        private static int getResourceId(android.widget.ImageView imageView, android.util.AttributeSet attributeSet, boolean z) {
            int attributeResourceValue = attributeSet.getAttributeResourceValue(pl.droidsonroids.gif.GifViewUtils.ANDROID_NS, z ? "src" : "background", 0);
            if (attributeResourceValue > 0) {
                if (pl.droidsonroids.gif.GifViewUtils.SUPPORTED_RESOURCE_TYPE_NAMES.contains(imageView.getResources().getResourceTypeName(attributeResourceValue)) && !pl.droidsonroids.gif.GifViewUtils.setResource(imageView, z, attributeResourceValue)) {
                    return attributeResourceValue;
                }
            }
            return 0;
        }
    }
}
