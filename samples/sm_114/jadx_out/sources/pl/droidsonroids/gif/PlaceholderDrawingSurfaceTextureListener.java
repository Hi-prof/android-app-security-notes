package pl.droidsonroids.gif;

/* JADX INFO: loaded from: classes2.dex */
class PlaceholderDrawingSurfaceTextureListener implements android.view.TextureView.SurfaceTextureListener {
    private final pl.droidsonroids.gif.GifTextureView.PlaceholderDrawListener mDrawer;

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(android.graphics.SurfaceTexture surfaceTexture) {
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(android.graphics.SurfaceTexture surfaceTexture, int i, int i2) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(android.graphics.SurfaceTexture surfaceTexture) {
    }

    PlaceholderDrawingSurfaceTextureListener(pl.droidsonroids.gif.GifTextureView.PlaceholderDrawListener placeholderDrawListener) {
        this.mDrawer = placeholderDrawListener;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(android.graphics.SurfaceTexture surfaceTexture, int i, int i2) {
        android.view.Surface surface = new android.view.Surface(surfaceTexture);
        android.graphics.Canvas canvasLockCanvas = surface.lockCanvas(null);
        this.mDrawer.onDrawPlaceholder(canvasLockCanvas);
        surface.unlockCanvasAndPost(canvasLockCanvas);
        surface.release();
    }
}
