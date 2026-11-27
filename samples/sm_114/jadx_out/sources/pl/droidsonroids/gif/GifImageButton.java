package pl.droidsonroids.gif;

/* JADX INFO: loaded from: classes2.dex */
public class GifImageButton extends android.widget.ImageButton {
    private boolean mFreezesAnimation;

    public GifImageButton(android.content.Context context) {
        super(context);
    }

    public GifImageButton(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        postInit(pl.droidsonroids.gif.GifViewUtils.initImageView(this, attributeSet, 0, 0));
    }

    public GifImageButton(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        postInit(pl.droidsonroids.gif.GifViewUtils.initImageView(this, attributeSet, i, 0));
    }

    public GifImageButton(android.content.Context context, android.util.AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        postInit(pl.droidsonroids.gif.GifViewUtils.initImageView(this, attributeSet, i, i2));
    }

    private void postInit(pl.droidsonroids.gif.GifViewUtils.GifImageViewAttributes gifImageViewAttributes) {
        this.mFreezesAnimation = gifImageViewAttributes.freezesAnimation;
        if (gifImageViewAttributes.mSourceResId > 0) {
            super.setImageResource(gifImageViewAttributes.mSourceResId);
        }
        if (gifImageViewAttributes.mBackgroundResId > 0) {
            super.setBackgroundResource(gifImageViewAttributes.mBackgroundResId);
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(android.net.Uri uri) {
        if (pl.droidsonroids.gif.GifViewUtils.setGifImageUri(this, uri)) {
            return;
        }
        super.setImageURI(uri);
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        if (pl.droidsonroids.gif.GifViewUtils.setResource(this, true, i)) {
            return;
        }
        super.setImageResource(i);
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        if (pl.droidsonroids.gif.GifViewUtils.setResource(this, false, i)) {
            return;
        }
        super.setBackgroundResource(i);
    }

    @Override // android.view.View
    public android.os.Parcelable onSaveInstanceState() {
        return new pl.droidsonroids.gif.GifViewSavedState(super.onSaveInstanceState(), this.mFreezesAnimation ? getDrawable() : null, this.mFreezesAnimation ? getBackground() : null);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(android.os.Parcelable parcelable) {
        if (!(parcelable instanceof pl.droidsonroids.gif.GifViewSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        pl.droidsonroids.gif.GifViewSavedState gifViewSavedState = (pl.droidsonroids.gif.GifViewSavedState) parcelable;
        super.onRestoreInstanceState(gifViewSavedState.getSuperState());
        gifViewSavedState.restoreState(getDrawable(), 0);
        gifViewSavedState.restoreState(getBackground(), 1);
    }

    public void setFreezesAnimation(boolean z) {
        this.mFreezesAnimation = z;
    }
}
