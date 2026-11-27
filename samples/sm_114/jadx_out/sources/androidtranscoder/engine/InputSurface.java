package androidtranscoder.engine;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
class InputSurface {
    private static final int EGL_RECORDABLE_ANDROID = 12610;
    private static final java.lang.String TAG = "InputSurface";
    private android.view.Surface mSurface;
    private android.opengl.EGLDisplay mEGLDisplay = android.opengl.EGL14.EGL_NO_DISPLAY;
    private android.opengl.EGLContext mEGLContext = android.opengl.EGL14.EGL_NO_CONTEXT;
    private android.opengl.EGLSurface mEGLSurface = android.opengl.EGL14.EGL_NO_SURFACE;

    public InputSurface(android.view.Surface surface) {
        surface.getClass();
        this.mSurface = surface;
        eglSetup();
    }

    private void checkEglError(java.lang.String str) {
        int iEglGetError = android.opengl.EGL14.eglGetError();
        if (iEglGetError == 12288) {
            return;
        }
        throw new java.lang.RuntimeException(str + ": EGL error: 0x" + java.lang.Integer.toHexString(iEglGetError));
    }

    private void eglSetup() {
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
        if (!android.opengl.EGL14.eglChooseConfig(this.mEGLDisplay, new int[]{12324, 8, 12323, 8, 12322, 8, 12352, 4, EGL_RECORDABLE_ANDROID, 1, 12344}, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
            throw new java.lang.RuntimeException("unable to find RGB888+recordable ES2 EGL config");
        }
        this.mEGLContext = android.opengl.EGL14.eglCreateContext(this.mEGLDisplay, eGLConfigArr[0], android.opengl.EGL14.EGL_NO_CONTEXT, new int[]{12440, 2, 12344}, 0);
        checkEglError("eglCreateContext");
        if (this.mEGLContext == null) {
            throw new java.lang.RuntimeException("null context");
        }
        this.mEGLSurface = android.opengl.EGL14.eglCreateWindowSurface(this.mEGLDisplay, eGLConfigArr[0], this.mSurface, new int[]{12344}, 0);
        checkEglError("eglCreateWindowSurface");
        if (this.mEGLSurface == null) {
            throw new java.lang.RuntimeException("surface was null");
        }
    }

    public int getHeight() {
        int[] iArr = new int[1];
        android.opengl.EGL14.eglQuerySurface(this.mEGLDisplay, this.mEGLSurface, 12374, iArr, 0);
        return iArr[0];
    }

    public android.view.Surface getSurface() {
        return this.mSurface;
    }

    public int getWidth() {
        int[] iArr = new int[1];
        android.opengl.EGL14.eglQuerySurface(this.mEGLDisplay, this.mEGLSurface, 12375, iArr, 0);
        return iArr[0];
    }

    public void makeCurrent() {
        android.opengl.EGLDisplay eGLDisplay = this.mEGLDisplay;
        android.opengl.EGLSurface eGLSurface = this.mEGLSurface;
        if (!android.opengl.EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.mEGLContext)) {
            throw new java.lang.RuntimeException("eglMakeCurrent failed");
        }
    }

    public void makeUnCurrent() {
        android.opengl.EGLDisplay eGLDisplay = this.mEGLDisplay;
        android.opengl.EGLSurface eGLSurface = android.opengl.EGL14.EGL_NO_SURFACE;
        if (!android.opengl.EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, android.opengl.EGL14.EGL_NO_CONTEXT)) {
            throw new java.lang.RuntimeException("eglMakeCurrent failed");
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
        this.mSurface = null;
    }

    public void setPresentationTime(long j) {
        android.opengl.EGLExt.eglPresentationTimeANDROID(this.mEGLDisplay, this.mEGLSurface, j);
    }

    public boolean swapBuffers() {
        return android.opengl.EGL14.eglSwapBuffers(this.mEGLDisplay, this.mEGLSurface);
    }
}
