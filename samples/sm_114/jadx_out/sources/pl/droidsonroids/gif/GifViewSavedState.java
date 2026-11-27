package pl.droidsonroids.gif;

/* JADX INFO: loaded from: classes2.dex */
class GifViewSavedState extends android.view.View.BaseSavedState {
    public static final android.os.Parcelable.Creator<pl.droidsonroids.gif.GifViewSavedState> CREATOR = new android.os.Parcelable.Creator<pl.droidsonroids.gif.GifViewSavedState>() { // from class: pl.droidsonroids.gif.GifViewSavedState.1
        @Override // android.os.Parcelable.Creator
        public pl.droidsonroids.gif.GifViewSavedState createFromParcel(android.os.Parcel parcel) {
            return new pl.droidsonroids.gif.GifViewSavedState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public pl.droidsonroids.gif.GifViewSavedState[] newArray(int i) {
            return new pl.droidsonroids.gif.GifViewSavedState[i];
        }
    };
    final long[][] mStates;

    GifViewSavedState(android.os.Parcelable parcelable, android.graphics.drawable.Drawable... drawableArr) {
        super(parcelable);
        this.mStates = new long[drawableArr.length][];
        for (int i = 0; i < drawableArr.length; i++) {
            android.graphics.drawable.Drawable drawable = drawableArr[i];
            if (drawable instanceof pl.droidsonroids.gif.GifDrawable) {
                this.mStates[i] = ((pl.droidsonroids.gif.GifDrawable) drawable).mNativeInfoHandle.getSavedState();
            } else {
                this.mStates[i] = null;
            }
        }
    }

    private GifViewSavedState(android.os.Parcel parcel) {
        super(parcel);
        this.mStates = new long[parcel.readInt()][];
        int i = 0;
        while (true) {
            long[][] jArr = this.mStates;
            if (i >= jArr.length) {
                return;
            }
            jArr[i] = parcel.createLongArray();
            i++;
        }
    }

    GifViewSavedState(android.os.Parcelable parcelable, long[] jArr) {
        super(parcelable);
        this.mStates = new long[][]{jArr};
    }

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.mStates.length);
        for (long[] jArr : this.mStates) {
            parcel.writeLongArray(jArr);
        }
    }

    void restoreState(android.graphics.drawable.Drawable drawable, int i) {
        if (this.mStates[i] == null || !(drawable instanceof pl.droidsonroids.gif.GifDrawable)) {
            return;
        }
        pl.droidsonroids.gif.GifDrawable gifDrawable = (pl.droidsonroids.gif.GifDrawable) drawable;
        gifDrawable.startAnimation(gifDrawable.mNativeInfoHandle.restoreSavedState(this.mStates[i], gifDrawable.mBuffer));
    }
}
