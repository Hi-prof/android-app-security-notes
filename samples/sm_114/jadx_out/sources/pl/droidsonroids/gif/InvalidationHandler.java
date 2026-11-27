package pl.droidsonroids.gif;

/* JADX INFO: loaded from: classes2.dex */
class InvalidationHandler extends android.os.Handler {
    static final int MSG_TYPE_INVALIDATION = -1;
    private final java.lang.ref.WeakReference<pl.droidsonroids.gif.GifDrawable> mDrawableRef;

    InvalidationHandler(pl.droidsonroids.gif.GifDrawable gifDrawable) {
        super(android.os.Looper.getMainLooper());
        this.mDrawableRef = new java.lang.ref.WeakReference<>(gifDrawable);
    }

    @Override // android.os.Handler
    public void handleMessage(android.os.Message message) {
        pl.droidsonroids.gif.GifDrawable gifDrawable = this.mDrawableRef.get();
        if (gifDrawable == null) {
            return;
        }
        if (message.what == -1) {
            gifDrawable.invalidateSelf();
            return;
        }
        java.util.Iterator<pl.droidsonroids.gif.AnimationListener> it = gifDrawable.mListeners.iterator();
        while (it.hasNext()) {
            it.next().onAnimationCompleted(message.what);
        }
    }
}
