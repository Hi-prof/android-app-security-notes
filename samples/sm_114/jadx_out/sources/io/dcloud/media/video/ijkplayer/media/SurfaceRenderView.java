package io.dcloud.media.video.ijkplayer.media;

/* JADX INFO: loaded from: classes2.dex */
public class SurfaceRenderView extends android.view.SurfaceView implements io.dcloud.media.video.ijkplayer.media.IRenderView {
    private io.dcloud.media.video.ijkplayer.media.MeasureHelper mMeasureHelper;
    private io.dcloud.media.video.ijkplayer.media.SurfaceRenderView.SurfaceCallback mSurfaceCallback;

    @Override // io.dcloud.media.video.ijkplayer.media.IRenderView
    public android.graphics.Matrix getTransform() {
        return null;
    }

    @Override // io.dcloud.media.video.ijkplayer.media.IRenderView
    public android.graphics.Bitmap getVideoScreenshot() {
        return null;
    }

    @Override // io.dcloud.media.video.ijkplayer.media.IRenderView
    public android.view.View getView() {
        return this;
    }

    @Override // io.dcloud.media.video.ijkplayer.media.IRenderView
    public void setTransform(android.graphics.Matrix matrix) {
    }

    @Override // io.dcloud.media.video.ijkplayer.media.IRenderView
    public boolean shouldWaitForResize() {
        return true;
    }

    public SurfaceRenderView(android.content.Context context) {
        super(context);
        initView(context);
    }

    public SurfaceRenderView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        initView(context);
    }

    public SurfaceRenderView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView(context);
    }

    public SurfaceRenderView(android.content.Context context, android.util.AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        initView(context);
    }

    private void initView(android.content.Context context) {
        this.mMeasureHelper = new io.dcloud.media.video.ijkplayer.media.MeasureHelper(this);
        this.mSurfaceCallback = new io.dcloud.media.video.ijkplayer.media.SurfaceRenderView.SurfaceCallback(this);
        getHolder().addCallback(this.mSurfaceCallback);
        getHolder().setType(0);
    }

    @Override // io.dcloud.media.video.ijkplayer.media.IRenderView
    public void setVideoSize(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        this.mMeasureHelper.setVideoSize(i, i2);
        getHolder().setFixedSize(i, i2);
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
        android.util.Log.e("", "SurfaceView doesn't support rotation (" + i + ")!\n");
    }

    @Override // io.dcloud.media.video.ijkplayer.media.IRenderView
    public void setAspectRatio(int i) {
        this.mMeasureHelper.setAspectRatio(i);
        requestLayout();
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onMeasure(int i, int i2) {
        this.mMeasureHelper.doMeasure(i, i2);
        setMeasuredDimension(this.mMeasureHelper.getMeasuredWidth(), this.mMeasureHelper.getMeasuredHeight());
    }

    private static final class InternalSurfaceHolder implements io.dcloud.media.video.ijkplayer.media.IRenderView.ISurfaceHolder {
        private android.view.SurfaceHolder mSurfaceHolder;
        private io.dcloud.media.video.ijkplayer.media.SurfaceRenderView mSurfaceView;

        @Override // io.dcloud.media.video.ijkplayer.media.IRenderView.ISurfaceHolder
        public android.graphics.SurfaceTexture getSurfaceTexture() {
            return null;
        }

        public InternalSurfaceHolder(io.dcloud.media.video.ijkplayer.media.SurfaceRenderView surfaceRenderView, android.view.SurfaceHolder surfaceHolder) {
            this.mSurfaceView = surfaceRenderView;
            this.mSurfaceHolder = surfaceHolder;
        }

        @Override // io.dcloud.media.video.ijkplayer.media.IRenderView.ISurfaceHolder
        public void bindToMediaPlayer(tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer) {
            if (iMediaPlayer != null) {
                if (iMediaPlayer instanceof tv.danmaku.ijk.media.player.ISurfaceTextureHolder) {
                    ((tv.danmaku.ijk.media.player.ISurfaceTextureHolder) iMediaPlayer).setSurfaceTexture(null);
                }
                iMediaPlayer.setDisplay(this.mSurfaceHolder);
            }
        }

        @Override // io.dcloud.media.video.ijkplayer.media.IRenderView.ISurfaceHolder
        public io.dcloud.media.video.ijkplayer.media.IRenderView getRenderView() {
            return this.mSurfaceView;
        }

        @Override // io.dcloud.media.video.ijkplayer.media.IRenderView.ISurfaceHolder
        public android.view.SurfaceHolder getSurfaceHolder() {
            return this.mSurfaceHolder;
        }

        @Override // io.dcloud.media.video.ijkplayer.media.IRenderView.ISurfaceHolder
        public android.view.Surface openSurface() {
            android.view.SurfaceHolder surfaceHolder = this.mSurfaceHolder;
            if (surfaceHolder == null) {
                return null;
            }
            return surfaceHolder.getSurface();
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

    private static final class SurfaceCallback implements android.view.SurfaceHolder.Callback {
        private int mFormat;
        private int mHeight;
        private boolean mIsFormatChanged;
        private java.util.Map<io.dcloud.media.video.ijkplayer.media.IRenderView.IRenderCallback, java.lang.Object> mRenderCallbackMap = new java.util.concurrent.ConcurrentHashMap();
        private android.view.SurfaceHolder mSurfaceHolder;
        private java.lang.ref.WeakReference<io.dcloud.media.video.ijkplayer.media.SurfaceRenderView> mWeakSurfaceView;
        private int mWidth;

        public SurfaceCallback(io.dcloud.media.video.ijkplayer.media.SurfaceRenderView surfaceRenderView) {
            this.mWeakSurfaceView = new java.lang.ref.WeakReference<>(surfaceRenderView);
        }

        public void addRenderCallback(io.dcloud.media.video.ijkplayer.media.IRenderView.IRenderCallback iRenderCallback) {
            io.dcloud.media.video.ijkplayer.media.SurfaceRenderView.InternalSurfaceHolder internalSurfaceHolder;
            this.mRenderCallbackMap.put(iRenderCallback, iRenderCallback);
            if (this.mSurfaceHolder != null) {
                internalSurfaceHolder = new io.dcloud.media.video.ijkplayer.media.SurfaceRenderView.InternalSurfaceHolder(this.mWeakSurfaceView.get(), this.mSurfaceHolder);
                iRenderCallback.onSurfaceCreated(internalSurfaceHolder, this.mWidth, this.mHeight);
            } else {
                internalSurfaceHolder = null;
            }
            if (this.mIsFormatChanged) {
                if (internalSurfaceHolder == null) {
                    internalSurfaceHolder = new io.dcloud.media.video.ijkplayer.media.SurfaceRenderView.InternalSurfaceHolder(this.mWeakSurfaceView.get(), this.mSurfaceHolder);
                }
                iRenderCallback.onSurfaceChanged(internalSurfaceHolder, this.mFormat, this.mWidth, this.mHeight);
            }
        }

        public void removeRenderCallback(io.dcloud.media.video.ijkplayer.media.IRenderView.IRenderCallback iRenderCallback) {
            this.mRenderCallbackMap.remove(iRenderCallback);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(android.view.SurfaceHolder surfaceHolder) {
            this.mSurfaceHolder = surfaceHolder;
            this.mIsFormatChanged = false;
            this.mFormat = 0;
            this.mWidth = 0;
            this.mHeight = 0;
            io.dcloud.media.video.ijkplayer.media.SurfaceRenderView.InternalSurfaceHolder internalSurfaceHolder = new io.dcloud.media.video.ijkplayer.media.SurfaceRenderView.InternalSurfaceHolder(this.mWeakSurfaceView.get(), this.mSurfaceHolder);
            java.util.Iterator<io.dcloud.media.video.ijkplayer.media.IRenderView.IRenderCallback> it = this.mRenderCallbackMap.keySet().iterator();
            while (it.hasNext()) {
                it.next().onSurfaceCreated(internalSurfaceHolder, 0, 0);
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(android.view.SurfaceHolder surfaceHolder) {
            this.mSurfaceHolder = null;
            this.mIsFormatChanged = false;
            this.mFormat = 0;
            this.mWidth = 0;
            this.mHeight = 0;
            io.dcloud.media.video.ijkplayer.media.SurfaceRenderView.InternalSurfaceHolder internalSurfaceHolder = new io.dcloud.media.video.ijkplayer.media.SurfaceRenderView.InternalSurfaceHolder(this.mWeakSurfaceView.get(), this.mSurfaceHolder);
            java.util.Iterator<io.dcloud.media.video.ijkplayer.media.IRenderView.IRenderCallback> it = this.mRenderCallbackMap.keySet().iterator();
            while (it.hasNext()) {
                it.next().onSurfaceDestroyed(internalSurfaceHolder);
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(android.view.SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            this.mSurfaceHolder = surfaceHolder;
            this.mIsFormatChanged = true;
            this.mFormat = i;
            this.mWidth = i2;
            this.mHeight = i3;
            io.dcloud.media.video.ijkplayer.media.SurfaceRenderView.InternalSurfaceHolder internalSurfaceHolder = new io.dcloud.media.video.ijkplayer.media.SurfaceRenderView.InternalSurfaceHolder(this.mWeakSurfaceView.get(), this.mSurfaceHolder);
            java.util.Iterator<io.dcloud.media.video.ijkplayer.media.IRenderView.IRenderCallback> it = this.mRenderCallbackMap.keySet().iterator();
            while (it.hasNext()) {
                it.next().onSurfaceChanged(internalSurfaceHolder, i, i2, i3);
            }
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(android.view.accessibility.AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(io.dcloud.media.video.ijkplayer.media.SurfaceRenderView.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(io.dcloud.media.video.ijkplayer.media.SurfaceRenderView.class.getName());
    }
}
