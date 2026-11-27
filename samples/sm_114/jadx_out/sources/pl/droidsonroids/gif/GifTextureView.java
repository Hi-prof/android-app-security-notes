package pl.droidsonroids.gif;

/* JADX INFO: loaded from: classes2.dex */
public class GifTextureView extends android.view.TextureView {
    private static final android.widget.ImageView.ScaleType[] sScaleTypeArray = {android.widget.ImageView.ScaleType.MATRIX, android.widget.ImageView.ScaleType.FIT_XY, android.widget.ImageView.ScaleType.FIT_START, android.widget.ImageView.ScaleType.FIT_CENTER, android.widget.ImageView.ScaleType.FIT_END, android.widget.ImageView.ScaleType.CENTER, android.widget.ImageView.ScaleType.CENTER_CROP, android.widget.ImageView.ScaleType.CENTER_INSIDE};
    private pl.droidsonroids.gif.InputSource mInputSource;
    private pl.droidsonroids.gif.GifTextureView.RenderThread mRenderThread;
    private android.widget.ImageView.ScaleType mScaleType;
    private float mSpeedFactor;
    private final android.graphics.Matrix mTransform;
    private pl.droidsonroids.gif.GifViewUtils.GifViewAttributes viewAttributes;

    public interface PlaceholderDrawListener {
        void onDrawPlaceholder(android.graphics.Canvas canvas);
    }

    @Override // android.view.TextureView
    public android.view.TextureView.SurfaceTextureListener getSurfaceTextureListener() {
        return null;
    }

    public GifTextureView(android.content.Context context) {
        super(context);
        this.mScaleType = android.widget.ImageView.ScaleType.FIT_CENTER;
        this.mTransform = new android.graphics.Matrix();
        this.mSpeedFactor = 1.0f;
        init(null, 0, 0);
    }

    public GifTextureView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mScaleType = android.widget.ImageView.ScaleType.FIT_CENTER;
        this.mTransform = new android.graphics.Matrix();
        this.mSpeedFactor = 1.0f;
        init(attributeSet, 0, 0);
    }

    public GifTextureView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mScaleType = android.widget.ImageView.ScaleType.FIT_CENTER;
        this.mTransform = new android.graphics.Matrix();
        this.mSpeedFactor = 1.0f;
        init(attributeSet, i, 0);
    }

    public GifTextureView(android.content.Context context, android.util.AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mScaleType = android.widget.ImageView.ScaleType.FIT_CENTER;
        this.mTransform = new android.graphics.Matrix();
        this.mSpeedFactor = 1.0f;
        init(attributeSet, i, i2);
    }

    private void init(android.util.AttributeSet attributeSet, int i, int i2) {
        if (attributeSet != null) {
            int attributeIntValue = attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "scaleType", -1);
            if (attributeIntValue >= 0) {
                android.widget.ImageView.ScaleType[] scaleTypeArr = sScaleTypeArray;
                if (attributeIntValue < scaleTypeArr.length) {
                    this.mScaleType = scaleTypeArr[attributeIntValue];
                }
            }
            android.content.res.TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, pl.droidsonroids.gif.R.styleable.GifTextureView, i, i2);
            this.mInputSource = findSource(typedArrayObtainStyledAttributes);
            super.setOpaque(typedArrayObtainStyledAttributes.getBoolean(pl.droidsonroids.gif.R.styleable.GifTextureView_isOpaque, false));
            typedArrayObtainStyledAttributes.recycle();
            this.viewAttributes = new pl.droidsonroids.gif.GifViewUtils.GifViewAttributes(this, attributeSet, i, i2);
        } else {
            super.setOpaque(false);
            this.viewAttributes = new pl.droidsonroids.gif.GifViewUtils.GifViewAttributes();
        }
        if (isInEditMode()) {
            return;
        }
        pl.droidsonroids.gif.GifTextureView.RenderThread renderThread = new pl.droidsonroids.gif.GifTextureView.RenderThread(this);
        this.mRenderThread = renderThread;
        if (this.mInputSource != null) {
            renderThread.start();
        }
    }

    @Override // android.view.TextureView
    public void setSurfaceTextureListener(android.view.TextureView.SurfaceTextureListener surfaceTextureListener) {
        throw new java.lang.UnsupportedOperationException("Changing SurfaceTextureListener is not supported");
    }

    @Override // android.view.TextureView
    public void setSurfaceTexture(android.graphics.SurfaceTexture surfaceTexture) {
        throw new java.lang.UnsupportedOperationException("Changing SurfaceTexture is not supported");
    }

    private static pl.droidsonroids.gif.InputSource findSource(android.content.res.TypedArray typedArray) {
        android.util.TypedValue typedValue = new android.util.TypedValue();
        if (!typedArray.getValue(pl.droidsonroids.gif.R.styleable.GifTextureView_gifSource, typedValue)) {
            return null;
        }
        if (typedValue.resourceId != 0) {
            java.lang.String resourceTypeName = typedArray.getResources().getResourceTypeName(typedValue.resourceId);
            if (pl.droidsonroids.gif.GifViewUtils.SUPPORTED_RESOURCE_TYPE_NAMES.contains(resourceTypeName)) {
                return new pl.droidsonroids.gif.InputSource.ResourcesSource(typedArray.getResources(), typedValue.resourceId);
            }
            if (!"string".equals(resourceTypeName)) {
                throw new java.lang.IllegalArgumentException("Expected string, drawable, mipmap or raw resource type. '" + resourceTypeName + "' is not supported");
            }
        }
        return new pl.droidsonroids.gif.InputSource.AssetSource(typedArray.getResources().getAssets(), typedValue.string.toString());
    }

    private static class RenderThread extends java.lang.Thread implements android.view.TextureView.SurfaceTextureListener {
        final pl.droidsonroids.gif.ConditionVariable isSurfaceValid;
        private pl.droidsonroids.gif.GifInfoHandle mGifInfoHandle;
        private final java.lang.ref.WeakReference<pl.droidsonroids.gif.GifTextureView> mGifTextureViewReference;
        private java.io.IOException mIOException;
        long[] mSavedState;

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(android.graphics.SurfaceTexture surfaceTexture, int i, int i2) {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(android.graphics.SurfaceTexture surfaceTexture) {
        }

        RenderThread(pl.droidsonroids.gif.GifTextureView gifTextureView) {
            super("GifRenderThread");
            this.isSurfaceValid = new pl.droidsonroids.gif.ConditionVariable();
            this.mGifInfoHandle = new pl.droidsonroids.gif.GifInfoHandle();
            this.mGifTextureViewReference = new java.lang.ref.WeakReference<>(gifTextureView);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                pl.droidsonroids.gif.GifTextureView gifTextureView = this.mGifTextureViewReference.get();
                if (gifTextureView == null) {
                    return;
                }
                pl.droidsonroids.gif.GifInfoHandle gifInfoHandleOpen = gifTextureView.mInputSource.open();
                this.mGifInfoHandle = gifInfoHandleOpen;
                gifInfoHandleOpen.setOptions((char) 1, gifTextureView.isOpaque());
                if (gifTextureView.viewAttributes.mLoopCount >= 0) {
                    this.mGifInfoHandle.setLoopCount(gifTextureView.viewAttributes.mLoopCount);
                }
                final pl.droidsonroids.gif.GifTextureView gifTextureView2 = this.mGifTextureViewReference.get();
                if (gifTextureView2 != null) {
                    gifTextureView2.setSuperSurfaceTextureListener(this);
                    boolean zIsAvailable = gifTextureView2.isAvailable();
                    this.isSurfaceValid.set(zIsAvailable);
                    if (zIsAvailable) {
                        gifTextureView2.post(new java.lang.Runnable() { // from class: pl.droidsonroids.gif.GifTextureView.RenderThread.1
                            @Override // java.lang.Runnable
                            public void run() {
                                gifTextureView2.updateTextureViewSize(pl.droidsonroids.gif.GifTextureView.RenderThread.this.mGifInfoHandle);
                            }
                        });
                    }
                    this.mGifInfoHandle.setSpeedFactor(gifTextureView2.mSpeedFactor);
                    while (!isInterrupted()) {
                        try {
                            this.isSurfaceValid.block();
                            pl.droidsonroids.gif.GifTextureView gifTextureView3 = this.mGifTextureViewReference.get();
                            if (gifTextureView3 == null) {
                                break;
                            }
                            android.graphics.SurfaceTexture surfaceTexture = gifTextureView3.getSurfaceTexture();
                            if (surfaceTexture != null) {
                                android.view.Surface surface = new android.view.Surface(surfaceTexture);
                                try {
                                    this.mGifInfoHandle.bindSurface(surface, this.mSavedState);
                                    surface.release();
                                } catch (java.lang.Throwable th) {
                                    surface.release();
                                    throw th;
                                }
                            }
                        } catch (java.lang.InterruptedException unused) {
                            java.lang.Thread.currentThread().interrupt();
                        }
                    }
                    this.mGifInfoHandle.recycle();
                    this.mGifInfoHandle = new pl.droidsonroids.gif.GifInfoHandle();
                    return;
                }
                this.mGifInfoHandle.recycle();
            } catch (java.io.IOException e) {
                this.mIOException = e;
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(android.graphics.SurfaceTexture surfaceTexture, int i, int i2) {
            pl.droidsonroids.gif.GifTextureView gifTextureView = this.mGifTextureViewReference.get();
            if (gifTextureView != null) {
                gifTextureView.updateTextureViewSize(this.mGifInfoHandle);
            }
            this.isSurfaceValid.open();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(android.graphics.SurfaceTexture surfaceTexture) {
            this.isSurfaceValid.close();
            this.mGifInfoHandle.postUnbindSurface();
            interrupt();
            return true;
        }

        void dispose(pl.droidsonroids.gif.GifTextureView gifTextureView, pl.droidsonroids.gif.GifTextureView.PlaceholderDrawListener placeholderDrawListener) {
            this.isSurfaceValid.close();
            gifTextureView.setSuperSurfaceTextureListener(placeholderDrawListener != null ? new pl.droidsonroids.gif.PlaceholderDrawingSurfaceTextureListener(placeholderDrawListener) : null);
            this.mGifInfoHandle.postUnbindSurface();
            interrupt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSuperSurfaceTextureListener(android.view.TextureView.SurfaceTextureListener surfaceTextureListener) {
        super.setSurfaceTextureListener(surfaceTextureListener);
    }

    @Override // android.view.TextureView
    public void setOpaque(boolean z) {
        if (z != isOpaque()) {
            super.setOpaque(z);
            setInputSource(this.mInputSource);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        this.mRenderThread.dispose(this, null);
        super.onDetachedFromWindow();
        android.graphics.SurfaceTexture surfaceTexture = getSurfaceTexture();
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
    }

    public synchronized void setInputSource(pl.droidsonroids.gif.InputSource inputSource) {
        setInputSource(inputSource, null);
    }

    public synchronized void setInputSource(pl.droidsonroids.gif.InputSource inputSource, pl.droidsonroids.gif.GifTextureView.PlaceholderDrawListener placeholderDrawListener) {
        this.mRenderThread.dispose(this, placeholderDrawListener);
        try {
            this.mRenderThread.join();
        } catch (java.lang.InterruptedException e) {
            e.printStackTrace();
        }
        this.mInputSource = inputSource;
        pl.droidsonroids.gif.GifTextureView.RenderThread renderThread = new pl.droidsonroids.gif.GifTextureView.RenderThread(this);
        this.mRenderThread = renderThread;
        if (inputSource != null) {
            renderThread.start();
        } else {
            clearSurface();
        }
    }

    private void clearSurface() {
        android.graphics.SurfaceTexture surfaceTexture = getSurfaceTexture();
        if (surfaceTexture != null) {
            android.view.Surface surface = new android.view.Surface(surfaceTexture);
            try {
                surface.unlockCanvasAndPost(surface.lockCanvas(null));
            } finally {
                surface.release();
            }
        }
    }

    public void setSpeed(float f) {
        this.mSpeedFactor = f;
        this.mRenderThread.mGifInfoHandle.setSpeedFactor(f);
    }

    public java.io.IOException getIOException() {
        return this.mRenderThread.mIOException != null ? this.mRenderThread.mIOException : pl.droidsonroids.gif.GifIOException.fromCode(this.mRenderThread.mGifInfoHandle.getNativeErrorCode());
    }

    public void setScaleType(android.widget.ImageView.ScaleType scaleType) {
        this.mScaleType = scaleType;
        updateTextureViewSize(this.mRenderThread.mGifInfoHandle);
    }

    public android.widget.ImageView.ScaleType getScaleType() {
        return this.mScaleType;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTextureViewSize(pl.droidsonroids.gif.GifInfoHandle gifInfoHandle) {
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        float width = getWidth();
        float height = getHeight();
        float width2 = gifInfoHandle.getWidth() / width;
        float height2 = gifInfoHandle.getHeight() / height;
        android.graphics.RectF rectF = new android.graphics.RectF(0.0f, 0.0f, gifInfoHandle.getWidth(), gifInfoHandle.getHeight());
        android.graphics.RectF rectF2 = new android.graphics.RectF(0.0f, 0.0f, width, height);
        switch (pl.droidsonroids.gif.GifTextureView.AnonymousClass1.$SwitchMap$android$widget$ImageView$ScaleType[this.mScaleType.ordinal()]) {
            case 1:
                matrix.setScale(width2, height2, width / 2.0f, height / 2.0f);
                break;
            case 2:
                float fMin = 1.0f / java.lang.Math.min(width2, height2);
                matrix.setScale(width2 * fMin, fMin * height2, width / 2.0f, height / 2.0f);
                break;
            case 3:
                float fMin2 = (((float) gifInfoHandle.getWidth()) > width || ((float) gifInfoHandle.getHeight()) > height) ? java.lang.Math.min(1.0f / width2, 1.0f / height2) : 1.0f;
                matrix.setScale(width2 * fMin2, fMin2 * height2, width / 2.0f, height / 2.0f);
                break;
            case 4:
                matrix.setRectToRect(rectF, rectF2, android.graphics.Matrix.ScaleToFit.CENTER);
                matrix.preScale(width2, height2);
                break;
            case 5:
                matrix.setRectToRect(rectF, rectF2, android.graphics.Matrix.ScaleToFit.END);
                matrix.preScale(width2, height2);
                break;
            case 6:
                matrix.setRectToRect(rectF, rectF2, android.graphics.Matrix.ScaleToFit.START);
                matrix.preScale(width2, height2);
                break;
            case 7:
                return;
            case 8:
                matrix.set(this.mTransform);
                matrix.preScale(width2, height2);
                break;
        }
        super.setTransform(matrix);
    }

    /* JADX INFO: renamed from: pl.droidsonroids.gif.GifTextureView$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$widget$ImageView$ScaleType;

        static {
            int[] iArr = new int[android.widget.ImageView.ScaleType.values().length];
            $SwitchMap$android$widget$ImageView$ScaleType = iArr;
            try {
                iArr[android.widget.ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[android.widget.ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[android.widget.ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[android.widget.ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[android.widget.ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[android.widget.ImageView.ScaleType.FIT_START.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[android.widget.ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (java.lang.NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[android.widget.ImageView.ScaleType.MATRIX.ordinal()] = 8;
            } catch (java.lang.NoSuchFieldError unused8) {
            }
        }
    }

    public void setImageMatrix(android.graphics.Matrix matrix) {
        setTransform(matrix);
    }

    @Override // android.view.TextureView
    public void setTransform(android.graphics.Matrix matrix) {
        this.mTransform.set(matrix);
        updateTextureViewSize(this.mRenderThread.mGifInfoHandle);
    }

    @Override // android.view.TextureView
    public android.graphics.Matrix getTransform(android.graphics.Matrix matrix) {
        if (matrix == null) {
            matrix = new android.graphics.Matrix();
        }
        matrix.set(this.mTransform);
        return matrix;
    }

    @Override // android.view.View
    public android.os.Parcelable onSaveInstanceState() {
        pl.droidsonroids.gif.GifTextureView.RenderThread renderThread = this.mRenderThread;
        renderThread.mSavedState = renderThread.mGifInfoHandle.getSavedState();
        return new pl.droidsonroids.gif.GifViewSavedState(super.onSaveInstanceState(), this.viewAttributes.freezesAnimation ? this.mRenderThread.mSavedState : null);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(android.os.Parcelable parcelable) {
        if (!(parcelable instanceof pl.droidsonroids.gif.GifViewSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        pl.droidsonroids.gif.GifViewSavedState gifViewSavedState = (pl.droidsonroids.gif.GifViewSavedState) parcelable;
        super.onRestoreInstanceState(gifViewSavedState.getSuperState());
        this.mRenderThread.mSavedState = gifViewSavedState.mStates[0];
    }

    public void setFreezesAnimation(boolean z) {
        this.viewAttributes.freezesAnimation = z;
    }
}
