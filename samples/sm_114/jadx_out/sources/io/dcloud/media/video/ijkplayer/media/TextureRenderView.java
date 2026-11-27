package io.dcloud.media.video.ijkplayer.media;

/* JADX INFO: loaded from: classes2.dex */
public class TextureRenderView extends android.view.TextureView implements io.dcloud.media.video.ijkplayer.media.IRenderView {
    private static final java.lang.String TAG = "TextureRenderView";
    private io.dcloud.media.video.ijkplayer.media.MeasureHelper mMeasureHelper;
    private io.dcloud.media.video.ijkplayer.media.TextureRenderView.SurfaceCallback mSurfaceCallback;

    @Override // io.dcloud.media.video.ijkplayer.media.IRenderView
    public android.view.View getView() {
        return this;
    }

    @Override // io.dcloud.media.video.ijkplayer.media.IRenderView
    public boolean shouldWaitForResize() {
        return false;
    }

    public TextureRenderView(android.content.Context context) {
        super(context);
        initView(context);
    }

    public TextureRenderView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        initView(context);
    }

    public TextureRenderView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView(context);
    }

    public TextureRenderView(android.content.Context context, android.util.AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        initView(context);
    }

    private void initView(android.content.Context context) {
        this.mMeasureHelper = new io.dcloud.media.video.ijkplayer.media.MeasureHelper(this);
        io.dcloud.media.video.ijkplayer.media.TextureRenderView.SurfaceCallback surfaceCallback = new io.dcloud.media.video.ijkplayer.media.TextureRenderView.SurfaceCallback(this);
        this.mSurfaceCallback = surfaceCallback;
        setSurfaceTextureListener(surfaceCallback);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        this.mSurfaceCallback.willDetachFromWindow();
        super.onDetachedFromWindow();
        this.mSurfaceCallback.didDetachFromWindow();
    }

    @Override // io.dcloud.media.video.ijkplayer.media.IRenderView
    public void setVideoSize(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        this.mMeasureHelper.setVideoSize(i, i2);
        requestLayout();
    }

    @Override // io.dcloud.media.video.ijkplayer.media.IRenderView
    public void setVideoSampleAspectRatio(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        this.mMeasureHelper.setVideoSampleAspectRatio(i, i2);
        requestLayout();
    }

    @Override // io.dcloud.media.video.ijkplayer.media.IRenderView
    public void setVideoRotation(int i) {
        this.mMeasureHelper.setVideoRotation(i);
        setRotation(i);
    }

    @Override // io.dcloud.media.video.ijkplayer.media.IRenderView
    public void setAspectRatio(int i) {
        this.mMeasureHelper.setAspectRatio(i);
        requestLayout();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.mMeasureHelper.doMeasure(i, i2);
        setMeasuredDimension(this.mMeasureHelper.getMeasuredWidth(), this.mMeasureHelper.getMeasuredHeight());
    }

    public io.dcloud.media.video.ijkplayer.media.IRenderView.ISurfaceHolder getSurfaceHolder() {
        return new io.dcloud.media.video.ijkplayer.media.TextureRenderView.InternalSurfaceHolder(this, this.mSurfaceCallback.mSurfaceTexture, this.mSurfaceCallback);
    }

    private static final class InternalSurfaceHolder implements io.dcloud.media.video.ijkplayer.media.IRenderView.ISurfaceHolder {
        private android.graphics.SurfaceTexture mSurfaceTexture;
        private tv.danmaku.ijk.media.player.ISurfaceTextureHost mSurfaceTextureHost;
        private io.dcloud.media.video.ijkplayer.media.TextureRenderView mTextureView;

        @Override // io.dcloud.media.video.ijkplayer.media.IRenderView.ISurfaceHolder
        public android.view.SurfaceHolder getSurfaceHolder() {
            return null;
        }

        public InternalSurfaceHolder(io.dcloud.media.video.ijkplayer.media.TextureRenderView textureRenderView, android.graphics.SurfaceTexture surfaceTexture, tv.danmaku.ijk.media.player.ISurfaceTextureHost iSurfaceTextureHost) {
            this.mTextureView = textureRenderView;
            this.mSurfaceTexture = surfaceTexture;
            this.mSurfaceTextureHost = iSurfaceTextureHost;
        }

        @Override // io.dcloud.media.video.ijkplayer.media.IRenderView.ISurfaceHolder
        public void bindToMediaPlayer(tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer) {
            if (iMediaPlayer == null) {
                return;
            }
            if (iMediaPlayer instanceof tv.danmaku.ijk.media.player.ISurfaceTextureHolder) {
                tv.danmaku.ijk.media.player.ISurfaceTextureHolder iSurfaceTextureHolder = (tv.danmaku.ijk.media.player.ISurfaceTextureHolder) iMediaPlayer;
                this.mTextureView.mSurfaceCallback.setOwnSurfaceTexture(false);
                android.graphics.SurfaceTexture surfaceTexture = iSurfaceTextureHolder.getSurfaceTexture();
                if (android.os.Build.VERSION.SDK_INT < 26 ? surfaceTexture != null : !(surfaceTexture == null || surfaceTexture.isReleased())) {
                    this.mTextureView.setSurfaceTexture(surfaceTexture);
                    return;
                } else {
                    iSurfaceTextureHolder.setSurfaceTexture(this.mSurfaceTexture);
                    iSurfaceTextureHolder.setSurfaceTextureHost(this.mTextureView.mSurfaceCallback);
                    return;
                }
            }
            iMediaPlayer.setSurface(openSurface());
        }

        @Override // io.dcloud.media.video.ijkplayer.media.IRenderView.ISurfaceHolder
        public io.dcloud.media.video.ijkplayer.media.IRenderView getRenderView() {
            return this.mTextureView;
        }

        @Override // io.dcloud.media.video.ijkplayer.media.IRenderView.ISurfaceHolder
        public android.graphics.SurfaceTexture getSurfaceTexture() {
            return this.mSurfaceTexture;
        }

        @Override // io.dcloud.media.video.ijkplayer.media.IRenderView.ISurfaceHolder
        public android.view.Surface openSurface() {
            if (this.mSurfaceTexture == null) {
                return null;
            }
            return new android.view.Surface(this.mSurfaceTexture);
        }
    }

    @Override // io.dcloud.media.video.ijkplayer.media.IRenderView
    public void addRenderCallback(io.dcloud.media.video.ijkplayer.media.IRenderView.IRenderCallback iRenderCallback) {
        this.mSurfaceCallback.addRenderCallback(iRenderCallback);
    }

    @Override // io.dcloud.media.video.ijkplayer.media.IRenderView
    public void removeRenderCallback(io.dcloud.media.video.ijkplayer.media.IRenderView.IRenderCallback iRenderCallback) {
        this.mSurfaceCallback.removeRenderCallback(iRenderCallback);
    }

    @Override // io.dcloud.media.video.ijkplayer.media.IRenderView
    public android.graphics.Matrix getTransform() {
        return getTransform(null);
    }

    @Override // io.dcloud.media.video.ijkplayer.media.IRenderView
    public android.graphics.Bitmap getVideoScreenshot() {
        return getBitmap();
    }

    private static final class SurfaceCallback implements android.view.TextureView.SurfaceTextureListener, tv.danmaku.ijk.media.player.ISurfaceTextureHost {
        private int mHeight;
        private boolean mIsFormatChanged;
        private android.graphics.SurfaceTexture mSurfaceTexture;
        private java.lang.ref.WeakReference<io.dcloud.media.video.ijkplayer.media.TextureRenderView> mWeakRenderView;
        private int mWidth;
        private boolean mOwnSurfaceTexture = true;
        private boolean mWillDetachFromWindow = false;
        private boolean mDidDetachFromWindow = false;
        private java.util.Map<io.dcloud.media.video.ijkplayer.media.IRenderView.IRenderCallback, java.lang.Object> mRenderCallbackMap = new java.util.concurrent.ConcurrentHashMap();

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(android.graphics.SurfaceTexture surfaceTexture) {
        }

        public SurfaceCallback(io.dcloud.media.video.ijkplayer.media.TextureRenderView textureRenderView) {
            this.mWeakRenderView = new java.lang.ref.WeakReference<>(textureRenderView);
        }

        public void setOwnSurfaceTexture(boolean z) {
            this.mOwnSurfaceTexture = z;
        }

        public void addRenderCallback(io.dcloud.media.video.ijkplayer.media.IRenderView.IRenderCallback iRenderCallback) {
            io.dcloud.media.video.ijkplayer.media.TextureRenderView.InternalSurfaceHolder internalSurfaceHolder;
            this.mRenderCallbackMap.put(iRenderCallback, iRenderCallback);
            android.graphics.SurfaceTexture surfaceTexture = this.mSurfaceTexture;
            if (surfaceTexture == null || surfaceTexture.isReleased()) {
                internalSurfaceHolder = null;
            } else {
                internalSurfaceHolder = new io.dcloud.media.video.ijkplayer.media.TextureRenderView.InternalSurfaceHolder(this.mWeakRenderView.get(), this.mSurfaceTexture, this);
                iRenderCallback.onSurfaceCreated(internalSurfaceHolder, this.mWidth, this.mHeight);
            }
            if (this.mIsFormatChanged) {
                if (internalSurfaceHolder == null) {
                    internalSurfaceHolder = new io.dcloud.media.video.ijkplayer.media.TextureRenderView.InternalSurfaceHolder(this.mWeakRenderView.get(), this.mSurfaceTexture, this);
                }
                iRenderCallback.onSurfaceChanged(internalSurfaceHolder, 0, this.mWidth, this.mHeight);
            }
        }

        public void removeRenderCallback(io.dcloud.media.video.ijkplayer.media.IRenderView.IRenderCallback iRenderCallback) {
            this.mRenderCallbackMap.remove(iRenderCallback);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(android.graphics.SurfaceTexture surfaceTexture, int i, int i2) {
            this.mSurfaceTexture = surfaceTexture;
            this.mIsFormatChanged = false;
            this.mWidth = 0;
            this.mHeight = 0;
            io.dcloud.media.video.ijkplayer.media.TextureRenderView.InternalSurfaceHolder internalSurfaceHolder = new io.dcloud.media.video.ijkplayer.media.TextureRenderView.InternalSurfaceHolder(this.mWeakRenderView.get(), surfaceTexture, this);
            java.util.Iterator<io.dcloud.media.video.ijkplayer.media.IRenderView.IRenderCallback> it = this.mRenderCallbackMap.keySet().iterator();
            while (it.hasNext()) {
                it.next().onSurfaceCreated(internalSurfaceHolder, 0, 0);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(android.graphics.SurfaceTexture surfaceTexture, int i, int i2) {
            this.mSurfaceTexture = surfaceTexture;
            this.mIsFormatChanged = true;
            this.mWidth = i;
            this.mHeight = i2;
            io.dcloud.media.video.ijkplayer.media.TextureRenderView.InternalSurfaceHolder internalSurfaceHolder = new io.dcloud.media.video.ijkplayer.media.TextureRenderView.InternalSurfaceHolder(this.mWeakRenderView.get(), surfaceTexture, this);
            java.util.Iterator<io.dcloud.media.video.ijkplayer.media.IRenderView.IRenderCallback> it = this.mRenderCallbackMap.keySet().iterator();
            while (it.hasNext()) {
                it.next().onSurfaceChanged(internalSurfaceHolder, 0, i, i2);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(android.graphics.SurfaceTexture surfaceTexture) {
            this.mSurfaceTexture = surfaceTexture;
            this.mIsFormatChanged = false;
            this.mWidth = 0;
            this.mHeight = 0;
            io.dcloud.media.video.ijkplayer.media.TextureRenderView.InternalSurfaceHolder internalSurfaceHolder = new io.dcloud.media.video.ijkplayer.media.TextureRenderView.InternalSurfaceHolder(this.mWeakRenderView.get(), surfaceTexture, this);
            java.util.Iterator<io.dcloud.media.video.ijkplayer.media.IRenderView.IRenderCallback> it = this.mRenderCallbackMap.keySet().iterator();
            while (it.hasNext()) {
                it.next().onSurfaceDestroyed(internalSurfaceHolder);
            }
            android.util.Log.d(io.dcloud.media.video.ijkplayer.media.TextureRenderView.TAG, "onSurfaceTextureDestroyed: onDestroy: " + this.mOwnSurfaceTexture);
            return this.mOwnSurfaceTexture;
        }

        @Override // tv.danmaku.ijk.media.player.ISurfaceTextureHost
        public void releaseSurfaceTexture(android.graphics.SurfaceTexture surfaceTexture) {
            if (surfaceTexture == null) {
                android.util.Log.d(io.dcloud.media.video.ijkplayer.media.TextureRenderView.TAG, "releaseSurfaceTexture: null");
                return;
            }
            if (this.mDidDetachFromWindow) {
                if (surfaceTexture != this.mSurfaceTexture) {
                    android.util.Log.d(io.dcloud.media.video.ijkplayer.media.TextureRenderView.TAG, "releaseSurfaceTexture: didDetachFromWindow(): release different SurfaceTexture");
                    surfaceTexture.release();
                    return;
                } else if (!this.mOwnSurfaceTexture) {
                    android.util.Log.d(io.dcloud.media.video.ijkplayer.media.TextureRenderView.TAG, "releaseSurfaceTexture: didDetachFromWindow(): release detached SurfaceTexture");
                    surfaceTexture.release();
                    return;
                } else {
                    android.util.Log.d(io.dcloud.media.video.ijkplayer.media.TextureRenderView.TAG, "releaseSurfaceTexture: didDetachFromWindow(): already released by TextureView");
                    return;
                }
            }
            if (this.mWillDetachFromWindow) {
                if (surfaceTexture != this.mSurfaceTexture) {
                    android.util.Log.d(io.dcloud.media.video.ijkplayer.media.TextureRenderView.TAG, "releaseSurfaceTexture: willDetachFromWindow(): release different SurfaceTexture");
                    surfaceTexture.release();
                    return;
                } else if (!this.mOwnSurfaceTexture) {
                    android.util.Log.d(io.dcloud.media.video.ijkplayer.media.TextureRenderView.TAG, "releaseSurfaceTexture: willDetachFromWindow(): re-attach SurfaceTexture to TextureView");
                    setOwnSurfaceTexture(true);
                    return;
                } else {
                    android.util.Log.d(io.dcloud.media.video.ijkplayer.media.TextureRenderView.TAG, "releaseSurfaceTexture: willDetachFromWindow(): will released by TextureView");
                    return;
                }
            }
            if (surfaceTexture != this.mSurfaceTexture) {
                android.util.Log.d(io.dcloud.media.video.ijkplayer.media.TextureRenderView.TAG, "releaseSurfaceTexture: alive: release different SurfaceTexture");
                surfaceTexture.release();
            } else if (!this.mOwnSurfaceTexture) {
                android.util.Log.d(io.dcloud.media.video.ijkplayer.media.TextureRenderView.TAG, "releaseSurfaceTexture: alive: re-attach SurfaceTexture to TextureView");
                setOwnSurfaceTexture(true);
            } else {
                android.util.Log.d(io.dcloud.media.video.ijkplayer.media.TextureRenderView.TAG, "releaseSurfaceTexture: alive: will released by TextureView");
            }
        }

        public void willDetachFromWindow() {
            android.util.Log.d(io.dcloud.media.video.ijkplayer.media.TextureRenderView.TAG, "willDetachFromWindow()");
            this.mWillDetachFromWindow = true;
        }

        public void didDetachFromWindow() {
            android.util.Log.d(io.dcloud.media.video.ijkplayer.media.TextureRenderView.TAG, "didDetachFromWindow()");
            this.mDidDetachFromWindow = true;
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(android.view.accessibility.AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(io.dcloud.media.video.ijkplayer.media.TextureRenderView.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(io.dcloud.media.video.ijkplayer.media.TextureRenderView.class.getName());
    }
}
