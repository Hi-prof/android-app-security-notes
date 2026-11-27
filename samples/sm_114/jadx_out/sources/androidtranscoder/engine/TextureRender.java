package androidtranscoder.engine;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
class TextureRender {
    private static final int FLOAT_SIZE_BYTES = 4;
    private static final java.lang.String FRAGMENT_SHADER = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n";
    private static final java.lang.String TAG = "TextureRender";
    private static final int TRIANGLE_VERTICES_DATA_POS_OFFSET = 0;
    private static final int TRIANGLE_VERTICES_DATA_STRIDE_BYTES = 20;
    private static final int TRIANGLE_VERTICES_DATA_UV_OFFSET = 3;
    private static final java.lang.String VERTEX_SHADER = "uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n";
    private int mProgram;
    private java.nio.FloatBuffer mTriangleVertices;
    private final float[] mTriangleVerticesData;
    private int maPositionHandle;
    private int maTextureHandle;
    private int muMVPMatrixHandle;
    private int muSTMatrixHandle;
    private float[] mMVPMatrix = new float[16];
    private float[] mSTMatrix = new float[16];
    private int mTextureID = -12345;

    public TextureRender() {
        float[] fArr = {-1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
        this.mTriangleVerticesData = fArr;
        java.nio.FloatBuffer floatBufferAsFloatBuffer = java.nio.ByteBuffer.allocateDirect(80).order(java.nio.ByteOrder.nativeOrder()).asFloatBuffer();
        this.mTriangleVertices = floatBufferAsFloatBuffer;
        floatBufferAsFloatBuffer.put(fArr).position(0);
        android.opengl.Matrix.setIdentityM(this.mSTMatrix, 0);
    }

    private int createProgram(java.lang.String str, java.lang.String str2) {
        int iLoadShader;
        int iLoadShader2 = loadShader(35633, str);
        if (iLoadShader2 == 0 || (iLoadShader = loadShader(35632, str2)) == 0) {
            return 0;
        }
        int iGlCreateProgram = android.opengl.GLES20.glCreateProgram();
        checkGlError("glCreateProgram");
        if (iGlCreateProgram == 0) {
            android.util.Log.e(TAG, "Could not create program");
        }
        android.opengl.GLES20.glAttachShader(iGlCreateProgram, iLoadShader2);
        checkGlError("glAttachShader");
        android.opengl.GLES20.glAttachShader(iGlCreateProgram, iLoadShader);
        checkGlError("glAttachShader");
        android.opengl.GLES20.glLinkProgram(iGlCreateProgram);
        int[] iArr = new int[1];
        android.opengl.GLES20.glGetProgramiv(iGlCreateProgram, 35714, iArr, 0);
        if (iArr[0] == 1) {
            return iGlCreateProgram;
        }
        android.util.Log.e(TAG, "Could not link program: ");
        android.util.Log.e(TAG, android.opengl.GLES20.glGetProgramInfoLog(iGlCreateProgram));
        android.opengl.GLES20.glDeleteProgram(iGlCreateProgram);
        return 0;
    }

    private int loadShader(int i, java.lang.String str) {
        int iGlCreateShader = android.opengl.GLES20.glCreateShader(i);
        checkGlError("glCreateShader type=" + i);
        android.opengl.GLES20.glShaderSource(iGlCreateShader, str);
        android.opengl.GLES20.glCompileShader(iGlCreateShader);
        int[] iArr = new int[1];
        android.opengl.GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return iGlCreateShader;
        }
        android.util.Log.e(TAG, "Could not compile shader " + i + ":");
        java.lang.StringBuilder sb = new java.lang.StringBuilder(com.taobao.weex.el.parse.Operators.SPACE_STR);
        sb.append(android.opengl.GLES20.glGetShaderInfoLog(iGlCreateShader));
        android.util.Log.e(TAG, sb.toString());
        android.opengl.GLES20.glDeleteShader(iGlCreateShader);
        return 0;
    }

    public static void saveFrame(java.lang.String str, int i, int i2) {
        throw new java.lang.UnsupportedOperationException("Not implemented.");
    }

    public void changeFragmentShader(java.lang.String str) {
        throw new java.lang.UnsupportedOperationException("Not implemented");
    }

    public void checkGlError(java.lang.String str) {
        int iGlGetError = android.opengl.GLES20.glGetError();
        if (iGlGetError == 0) {
            return;
        }
        android.util.Log.e(TAG, str + ": glError " + iGlGetError);
        throw new java.lang.RuntimeException(str + ": glError " + iGlGetError);
    }

    public void drawFrame(android.graphics.SurfaceTexture surfaceTexture) {
        checkGlError("onDrawFrame start");
        surfaceTexture.getTransformMatrix(this.mSTMatrix);
        android.opengl.GLES20.glClearColor(0.0f, 1.0f, 0.0f, 1.0f);
        android.opengl.GLES20.glClear(16640);
        android.opengl.GLES20.glUseProgram(this.mProgram);
        checkGlError("glUseProgram");
        android.opengl.GLES20.glActiveTexture(33984);
        android.opengl.GLES20.glBindTexture(36197, this.mTextureID);
        this.mTriangleVertices.position(0);
        android.opengl.GLES20.glVertexAttribPointer(this.maPositionHandle, 3, 5126, false, 20, (java.nio.Buffer) this.mTriangleVertices);
        checkGlError("glVertexAttribPointer maPosition");
        android.opengl.GLES20.glEnableVertexAttribArray(this.maPositionHandle);
        checkGlError("glEnableVertexAttribArray maPositionHandle");
        this.mTriangleVertices.position(3);
        android.opengl.GLES20.glVertexAttribPointer(this.maTextureHandle, 2, 5126, false, 20, (java.nio.Buffer) this.mTriangleVertices);
        checkGlError("glVertexAttribPointer maTextureHandle");
        android.opengl.GLES20.glEnableVertexAttribArray(this.maTextureHandle);
        checkGlError("glEnableVertexAttribArray maTextureHandle");
        android.opengl.Matrix.setIdentityM(this.mMVPMatrix, 0);
        android.opengl.GLES20.glUniformMatrix4fv(this.muMVPMatrixHandle, 1, false, this.mMVPMatrix, 0);
        android.opengl.GLES20.glUniformMatrix4fv(this.muSTMatrixHandle, 1, false, this.mSTMatrix, 0);
        android.opengl.GLES20.glDrawArrays(5, 0, 4);
        checkGlError("glDrawArrays");
        android.opengl.GLES20.glFinish();
    }

    public int getTextureId() {
        return this.mTextureID;
    }

    public void surfaceCreated() {
        int iCreateProgram = createProgram(VERTEX_SHADER, FRAGMENT_SHADER);
        this.mProgram = iCreateProgram;
        if (iCreateProgram == 0) {
            throw new java.lang.RuntimeException("failed creating program");
        }
        this.maPositionHandle = android.opengl.GLES20.glGetAttribLocation(iCreateProgram, "aPosition");
        checkGlError("glGetAttribLocation aPosition");
        if (this.maPositionHandle == -1) {
            throw new java.lang.RuntimeException("Could not get attrib location for aPosition");
        }
        this.maTextureHandle = android.opengl.GLES20.glGetAttribLocation(this.mProgram, "aTextureCoord");
        checkGlError("glGetAttribLocation aTextureCoord");
        if (this.maTextureHandle == -1) {
            throw new java.lang.RuntimeException("Could not get attrib location for aTextureCoord");
        }
        this.muMVPMatrixHandle = android.opengl.GLES20.glGetUniformLocation(this.mProgram, "uMVPMatrix");
        checkGlError("glGetUniformLocation uMVPMatrix");
        if (this.muMVPMatrixHandle == -1) {
            throw new java.lang.RuntimeException("Could not get attrib location for uMVPMatrix");
        }
        this.muSTMatrixHandle = android.opengl.GLES20.glGetUniformLocation(this.mProgram, "uSTMatrix");
        checkGlError("glGetUniformLocation uSTMatrix");
        if (this.muSTMatrixHandle == -1) {
            throw new java.lang.RuntimeException("Could not get attrib location for uSTMatrix");
        }
        int[] iArr = new int[1];
        android.opengl.GLES20.glGenTextures(1, iArr, 0);
        int i = iArr[0];
        this.mTextureID = i;
        android.opengl.GLES20.glBindTexture(36197, i);
        checkGlError("glBindTexture mTextureID");
        android.opengl.GLES20.glTexParameterf(36197, 10241, 9729.0f);
        android.opengl.GLES20.glTexParameterf(36197, 10240, 9729.0f);
        android.opengl.GLES20.glTexParameteri(36197, 10242, 33071);
        android.opengl.GLES20.glTexParameteri(36197, 10243, 33071);
        checkGlError("glTexParameter");
    }
}
