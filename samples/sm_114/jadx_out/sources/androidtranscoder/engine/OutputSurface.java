package androidtranscoder.engine;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
class OutputSurface implements android.graphics.SurfaceTexture.OnFrameAvailableListener {
    private static final java.lang.String TAG = "OutputSurface";
    private static final boolean VERBOSE = false;
    private boolean mFrameAvailable;
    private android.view.Surface mSurface;
    private android.graphics.SurfaceTexture mSurfaceTexture;
    private androidtranscoder.engine.TextureRender mTextureRender;
    private android.opengl.EGLDisplay mEGLDisplay = android.opengl.EGL14.EGL_NO_DISPLAY;
    private android.opengl.EGLContext mEGLContext = android.opengl.EGL14.EGL_NO_CONTEXT;
    private android.opengl.EGLSurface mEGLSurface = android.opengl.EGL14.EGL_NO_SURFACE;
    private java.lang.Object mFrameSyncObject = new java.lang.Object();

    public OutputSurface(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            throw new java.lang.IllegalArgumentException();
        }
        eglSetup(i, i2);
        makeCurrent();
        setup();
    }

    private void checkEglError(java.lang.String str) {
        int iEglGetError = android.opengl.EGL14.eglGetError();
        if (iEglGetError == 12288) {
            return;
        }
        throw new java.lang.RuntimeException(str + ": EGL error: 0x" + java.lang.Integer.toHexString(iEglGetError));
    }

    private void eglSetup(int i, int i2) {
        android.opengl.EGLDisplay eGLDisplayEglGetDisplay = android.opengl.EGL14.eglGetDisplay(0);
        this.mEGLDisplay = eGLDisplayEglGetDisplay;
        if (eGLDisplayEglGetDisplay == android.opengl.EGL14.EGL_NO_DISPLAY) {
            throw new java.lang.RuntimeException("unable to get EGL14 display");
        }
        int[] iArr = new int[2];
        if (!android.opengl.EGL14.eglInitialize(eGLDisplayEglGetDisplay, iArr, 0, iArr, 1)) {
            this.mEGLDisplay = null;
            throw new java.lang.RuntimeException("unable to initialize EGL14");
        }
        android.opengl.EGLConfig[] eGLConfigArr = new android.opengl.EGLConfig[1];
        if (!android.opengl.EGL14.eglChooseConfig(this.mEGLDisplay, new int[]{12324, 8, 12323, 8, 12322, 8, 12352, 4, 12339, 1, 12344}, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
            throw new java.lang.RuntimeException("unable to find RGB888+recordable ES2 EGL config");
        }
        this.mEGLContext = android.opengl.EGL14.eglCreateContext(this.mEGLDisplay, eGLConfigArr[0], android.opengl.EGL14.EGL_NO_CONTEXT, new int[]{12440, 2, 12344}, 0);
        checkEglError("eglCreateContext");
        if (this.mEGLContext == null) {
            throw new java.lang.RuntimeException("null context");
        }
        this.mEGLSurface = android.opengl.EGL14.eglCreatePbufferSurface(this.mEGLDisplay, eGLConfigArr[0], new int[]{12375, i, 12374, i2, 12344}, 0);
        checkEglError("eglCreatePbufferSurface");
        if (this.mEGLSurface == null) {
            throw new java.lang.RuntimeException("surface was null");
        }
    }

    private void setup() {
        androidtranscoder.engine.TextureRender textureRender = new androidtranscoder.engine.TextureRender();
        this.mTextureRender = textureRender;
        textureRender.surfaceCreated();
        android.graphics.SurfaceTexture surfaceTexture = new android.graphics.SurfaceTexture(this.mTextureRender.getTextureId());
        this.mSurfaceTexture = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(this);
        this.mSurface = new android.view.Surface(this.mSurfaceTexture);
    }

    public void awaitNewImage() {
        synchronized (this.mFrameSyncObject) {
            while (!this.mFrameAvailable) {
                try {
                    this.mFrameSyncObject.wait(10000L);
                    if (!this.mFrameAvailable) {
                        throw new java.lang.RuntimeException("Surface frame wait timed out");
                    }
                } catch (java.lang.InterruptedException e) {
                    throw new java.lang.RuntimeException(e);
                }
            }
            this.mFrameAvailable = false;
        }
        this.mTextureRender.checkGlError("before updateTexImage");
        this.mSurfaceTexture.updateTexImage();
    }

    public void changeFragmentShader(java.lang.String str) {
        this.mTextureRender.changeFragmentShader(str);
    }

    public boolean checkForNewImage(int i) {
        synchronized (this.mFrameSyncObject) {
            while (!this.mFrameAvailable) {
                try {
                    this.mFrameSyncObject.wait(i);
                    if (!this.mFrameAvailable) {
                        return false;
                    }
                } catch (java.lang.InterruptedException e) {
                    throw new java.lang.RuntimeException(e);
                }
            }
            this.mFrameAvailable = false;
            this.mTextureRender.checkGlError("before updateTexImage");
            this.mSurfaceTexture.updateTexImage();
            return true;
        }
    }

    public void drawImage() {
        this.mTextureRender.drawFrame(this.mSurfaceTexture);
    }

    public android.view.Surface getSurface() {
        return this.mSurface;
    }

    public void makeCurrent() {
        android.opengl.EGLDisplay eGLDisplay = this.mEGLDisplay;
        android.opengl.EGLSurface eGLSurface = this.mEGLSurface;
        if (!android.opengl.EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.mEGLContext)) {
            throw new java.lang.RuntimeException("eglMakeCurrent failed");
        }
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(android.graphics.SurfaceTexture surfaceTexture) {
        synchronized (this.mFrameSyncObject) {
            if (this.mFrameAvailable) {
                throw new java.lang.RuntimeException("mFrameAvailable already set, frame could be dropped");
            }
            this.mFrameAvailable = true;
            this.mFrameSyncObject.notifyAll();
        }
    }

    public void release() {
        android.opengl.EGLDisplay eGLDisplay = this.mEGLDisplay;
        if (eGLDisplay != android.opengl.EGL14.EGL_NO_DISPLAY) {
            android.opengl.EGL14.eglDestroySurface(eGLDisplay, this.mEGLSurface);
            android.opengl.EGL14.eglDestroyContext(this.mEGLDisplay, this.mEGLContext);
            android.opengl.EGL14.eglReleaseThread();
            android.opengl.EGL14.eglTerminate(this.mEGLDisplay);
        }
        this.mSurface.release();
        this.mEGLDisplay = android.opengl.EGL14.EGL_NO_DISPLAY;
        this.mEGLContext = android.opengl.EGL14.EGL_NO_CONTEXT;
        this.mEGLSurface = android.opengl.EGL14.EGL_NO_SURFACE;
        this.mTextureRender = null;
        this.mSurface = null;
        this.mSurfaceTexture = null;
    }

    public OutputSurface() {
        setup();
    }
}
