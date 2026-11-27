package pl.droidsonroids.gif;

/* JADX INFO: loaded from: classes2.dex */
public class GifTextView extends android.widget.TextView {
    private pl.droidsonroids.gif.GifViewUtils.GifViewAttributes viewAttributes;

    public GifTextView(android.content.Context context) {
        super(context);
    }

    public GifTextView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet, 0, 0);
    }

    public GifTextView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(attributeSet, i, 0);
    }

    public GifTextView(android.content.Context context, android.util.AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init(attributeSet, i, i2);
    }

    private static void setDrawablesVisible(android.graphics.drawable.Drawable[] drawableArr, boolean z) {
        for (android.graphics.drawable.Drawable drawable : drawableArr) {
            if (drawable != null) {
                drawable.setVisible(z, false);
            }
        }
    }

    private void init(android.util.AttributeSet attributeSet, int i, int i2) {
        if (attributeSet != null) {
            android.graphics.drawable.Drawable gifOrDefaultDrawable = getGifOrDefaultDrawable(attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "drawableLeft", 0));
            android.graphics.drawable.Drawable gifOrDefaultDrawable2 = getGifOrDefaultDrawable(attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "drawableTop", 0));
            android.graphics.drawable.Drawable gifOrDefaultDrawable3 = getGifOrDefaultDrawable(attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "drawableRight", 0));
            android.graphics.drawable.Drawable gifOrDefaultDrawable4 = getGifOrDefaultDrawable(attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "drawableBottom", 0));
            android.graphics.drawable.Drawable gifOrDefaultDrawable5 = getGifOrDefaultDrawable(attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "drawableStart", 0));
            android.graphics.drawable.Drawable gifOrDefaultDrawable6 = getGifOrDefaultDrawable(attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "drawableEnd", 0));
            if (getLayoutDirection() == 0) {
                if (gifOrDefaultDrawable5 != null) {
                    gifOrDefaultDrawable = gifOrDefaultDrawable5;
                }
                if (gifOrDefaultDrawable6 == null) {
                    gifOrDefaultDrawable6 = gifOrDefaultDrawable3;
                }
            } else {
                if (gifOrDefaultDrawable5 != null) {
                    gifOrDefaultDrawable3 = gifOrDefaultDrawable5;
                }
                if (gifOrDefaultDrawable6 == null) {
                    gifOrDefaultDrawable6 = gifOrDefaultDrawable;
                }
                gifOrDefaultDrawable = gifOrDefaultDrawable3;
            }
            setCompoundDrawablesRelativeWithIntrinsicBounds(gifOrDefaultDrawable, gifOrDefaultDrawable2, gifOrDefaultDrawable6, gifOrDefaultDrawable4);
            setBackground(getGifOrDefaultDrawable(attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "background", 0)));
            this.viewAttributes = new pl.droidsonroids.gif.GifViewUtils.GifViewAttributes(this, attributeSet, i, i2);
            applyGifViewAttributes();
        }
        this.viewAttributes = new pl.droidsonroids.gif.GifViewUtils.GifViewAttributes();
    }

    private void applyGifViewAttributes() {
        if (this.viewAttributes.mLoopCount < 0) {
            return;
        }
        for (android.graphics.drawable.Drawable drawable : getCompoundDrawables()) {
            pl.droidsonroids.gif.GifViewUtils.applyLoopCount(this.viewAttributes.mLoopCount, drawable);
        }
        for (android.graphics.drawable.Drawable drawable2 : getCompoundDrawablesRelative()) {
            pl.droidsonroids.gif.GifViewUtils.applyLoopCount(this.viewAttributes.mLoopCount, drawable2);
        }
        pl.droidsonroids.gif.GifViewUtils.applyLoopCount(this.viewAttributes.mLoopCount, getBackground());
    }

    private android.graphics.drawable.Drawable getGifOrDefaultDrawable(int i) {
        if (i == 0) {
            return null;
        }
        android.content.res.Resources resources = getResources();
        java.lang.String resourceTypeName = resources.getResourceTypeName(i);
        if (!isInEditMode() && pl.droidsonroids.gif.GifViewUtils.SUPPORTED_RESOURCE_TYPE_NAMES.contains(resourceTypeName)) {
            try {
                return new pl.droidsonroids.gif.GifDrawable(resources, i);
            } catch (android.content.res.Resources.NotFoundException | java.io.IOException unused) {
            }
        }
        return resources.getDrawable(i, getContext().getTheme());
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        setCompoundDrawablesWithIntrinsicBounds(getGifOrDefaultDrawable(i), getGifOrDefaultDrawable(i2), getGifOrDefaultDrawable(i3), getGifOrDefaultDrawable(i4));
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        setCompoundDrawablesRelativeWithIntrinsicBounds(getGifOrDefaultDrawable(i), getGifOrDefaultDrawable(i2), getGifOrDefaultDrawable(i3), getGifOrDefaultDrawable(i4));
    }

    @Override // android.widget.TextView, android.view.View
    public android.os.Parcelable onSaveInstanceState() {
        android.graphics.drawable.Drawable[] drawableArr = new android.graphics.drawable.Drawable[7];
        if (this.viewAttributes.freezesAnimation) {
            android.graphics.drawable.Drawable[] compoundDrawables = getCompoundDrawables();
            java.lang.System.arraycopy(compoundDrawables, 0, drawableArr, 0, compoundDrawables.length);
            android.graphics.drawable.Drawable[] compoundDrawablesRelative = getCompoundDrawablesRelative();
            drawableArr[4] = compoundDrawablesRelative[0];
            drawableArr[5] = compoundDrawablesRelative[2];
            drawableArr[6] = getBackground();
        }
        return new pl.droidsonroids.gif.GifViewSavedState(super.onSaveInstanceState(), drawableArr);
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(android.os.Parcelable parcelable) {
        if (!(parcelable instanceof pl.droidsonroids.gif.GifViewSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        pl.droidsonroids.gif.GifViewSavedState gifViewSavedState = (pl.droidsonroids.gif.GifViewSavedState) parcelable;
        super.onRestoreInstanceState(gifViewSavedState.getSuperState());
        android.graphics.drawable.Drawable[] compoundDrawables = getCompoundDrawables();
        gifViewSavedState.restoreState(compoundDrawables[0], 0);
        gifViewSavedState.restoreState(compoundDrawables[1], 1);
        gifViewSavedState.restoreState(compoundDrawables[2], 2);
        gifViewSavedState.restoreState(compoundDrawables[3], 3);
        android.graphics.drawable.Drawable[] compoundDrawablesRelative = getCompoundDrawablesRelative();
        gifViewSavedState.restoreState(compoundDrawablesRelative[0], 4);
        gifViewSavedState.restoreState(compoundDrawablesRelative[2], 5);
        gifViewSavedState.restoreState(getBackground(), 6);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        setCompoundDrawablesVisible(true);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setCompoundDrawablesVisible(false);
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        setBackground(getGifOrDefaultDrawable(i));
    }

    private void setCompoundDrawablesVisible(boolean z) {
        setDrawablesVisible(getCompoundDrawables(), z);
        setDrawablesVisible(getCompoundDrawablesRelative(), z);
    }

    public void setFreezesAnimation(boolean z) {
        this.viewAttributes.freezesAnimation = z;
    }
}
