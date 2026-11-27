package pl.droidsonroids.gif;

/* JADX INFO: loaded from: classes2.dex */
public class MultiCallback implements android.graphics.drawable.Drawable.Callback {
    private final java.util.concurrent.CopyOnWriteArrayList<pl.droidsonroids.gif.MultiCallback.CallbackWeakReference> mCallbacks;
    private final boolean mUseViewInvalidate;

    public MultiCallback() {
        this(false);
    }

    public MultiCallback(boolean z) {
        this.mCallbacks = new java.util.concurrent.CopyOnWriteArrayList<>();
        this.mUseViewInvalidate = z;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(android.graphics.drawable.Drawable drawable) {
        for (int i = 0; i < this.mCallbacks.size(); i++) {
            pl.droidsonroids.gif.MultiCallback.CallbackWeakReference callbackWeakReference = this.mCallbacks.get(i);
            android.graphics.drawable.Drawable.Callback callback = (android.graphics.drawable.Drawable.Callback) callbackWeakReference.get();
            if (callback != null) {
                if (this.mUseViewInvalidate && (callback instanceof android.view.View)) {
                    ((android.view.View) callback).invalidate();
                } else {
                    callback.invalidateDrawable(drawable);
                }
            } else {
                this.mCallbacks.remove(callbackWeakReference);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(android.graphics.drawable.Drawable drawable, java.lang.Runnable runnable, long j) {
        for (int i = 0; i < this.mCallbacks.size(); i++) {
            pl.droidsonroids.gif.MultiCallback.CallbackWeakReference callbackWeakReference = this.mCallbacks.get(i);
            android.graphics.drawable.Drawable.Callback callback = (android.graphics.drawable.Drawable.Callback) callbackWeakReference.get();
            if (callback != null) {
                callback.scheduleDrawable(drawable, runnable, j);
            } else {
                this.mCallbacks.remove(callbackWeakReference);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(android.graphics.drawable.Drawable drawable, java.lang.Runnable runnable) {
        for (int i = 0; i < this.mCallbacks.size(); i++) {
            pl.droidsonroids.gif.MultiCallback.CallbackWeakReference callbackWeakReference = this.mCallbacks.get(i);
            android.graphics.drawable.Drawable.Callback callback = (android.graphics.drawable.Drawable.Callback) callbackWeakReference.get();
            if (callback != null) {
                callback.unscheduleDrawable(drawable, runnable);
            } else {
                this.mCallbacks.remove(callbackWeakReference);
            }
        }
    }

    public void addView(android.graphics.drawable.Drawable.Callback callback) {
        for (int i = 0; i < this.mCallbacks.size(); i++) {
            pl.droidsonroids.gif.MultiCallback.CallbackWeakReference callbackWeakReference = this.mCallbacks.get(i);
            if (((android.graphics.drawable.Drawable.Callback) callbackWeakReference.get()) == null) {
                this.mCallbacks.remove(callbackWeakReference);
            }
        }
        this.mCallbacks.addIfAbsent(new pl.droidsonroids.gif.MultiCallback.CallbackWeakReference(callback));
    }

    public void removeView(android.graphics.drawable.Drawable.Callback callback) {
        for (int i = 0; i < this.mCallbacks.size(); i++) {
            pl.droidsonroids.gif.MultiCallback.CallbackWeakReference callbackWeakReference = this.mCallbacks.get(i);
            android.graphics.drawable.Drawable.Callback callback2 = (android.graphics.drawable.Drawable.Callback) callbackWeakReference.get();
            if (callback2 == null || callback2 == callback) {
                this.mCallbacks.remove(callbackWeakReference);
            }
        }
    }

    static final class CallbackWeakReference extends java.lang.ref.WeakReference<android.graphics.drawable.Drawable.Callback> {
        CallbackWeakReference(android.graphics.drawable.Drawable.Callback callback) {
            super(callback);
        }

        public boolean equals(java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && get() == ((pl.droidsonroids.gif.MultiCallback.CallbackWeakReference) obj).get();
        }

        public int hashCode() {
            android.graphics.drawable.Drawable.Callback callback = (android.graphics.drawable.Drawable.Callback) get();
            if (callback != null) {
                return callback.hashCode();
            }
            return 0;
        }
    }
}
