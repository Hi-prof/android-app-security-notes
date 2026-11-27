package master.flame.danmaku.danmaku.model.android;

/* JADX INFO: loaded from: classes2.dex */
public class DrawingCacheHolder {
    public android.graphics.Bitmap bitmap;
    public android.graphics.Bitmap[][] bitmapArray;
    public android.graphics.Canvas canvas;
    public boolean drawn;
    public java.lang.Object extra;
    public int height;
    private int mDensity;
    public int width;

    public DrawingCacheHolder() {
    }

    public DrawingCacheHolder(int i, int i2) {
        buildCache(i, i2, 0, true);
    }

    public DrawingCacheHolder(int i, int i2, int i3) {
        this.mDensity = i3;
        buildCache(i, i2, i3, true);
    }

    public void buildCache(int i, int i2, int i3, boolean z) {
        if (!z ? !(i > this.width || i2 > this.height) : !(i != this.width || i2 != this.height)) {
            android.graphics.Bitmap bitmap = this.bitmap;
            if (bitmap != null) {
                bitmap.eraseColor(0);
                this.canvas.setBitmap(this.bitmap);
                recycleBitmapArray();
                return;
            }
        }
        if (this.bitmap != null) {
            recycle();
        }
        this.width = i;
        this.height = i2;
        android.graphics.Bitmap bitmapCreateBitmap = tv.cjump.jni.NativeBitmapFactory.createBitmap(i, i2, android.graphics.Bitmap.Config.ARGB_8888);
        this.bitmap = bitmapCreateBitmap;
        if (i3 > 0) {
            this.mDensity = i3;
            bitmapCreateBitmap.setDensity(i3);
        }
        android.graphics.Canvas canvas = this.canvas;
        if (canvas == null) {
            android.graphics.Canvas canvas2 = new android.graphics.Canvas(this.bitmap);
            this.canvas = canvas2;
            canvas2.setDensity(i3);
            return;
        }
        canvas.setBitmap(this.bitmap);
    }

    public void erase() {
        eraseBitmap(this.bitmap);
        eraseBitmapArray();
    }

    public synchronized void recycle() {
        android.graphics.Bitmap bitmap = this.bitmap;
        this.bitmap = null;
        this.height = 0;
        this.width = 0;
        if (bitmap != null) {
            bitmap.recycle();
        }
        recycleBitmapArray();
        this.extra = null;
    }

    public void splitWith(int i, int i2, int i3, int i4) {
        int i5;
        recycleBitmapArray();
        int i6 = this.width;
        if (i6 <= 0 || (i5 = this.height) <= 0 || this.bitmap == null) {
            return;
        }
        if (i6 > i3 || i5 > i4) {
            int iMin = java.lang.Math.min(i3, i);
            int iMin2 = java.lang.Math.min(i4, i2);
            int i7 = this.width;
            int i8 = (i7 / iMin) + (i7 % iMin == 0 ? 0 : 1);
            int i9 = this.height;
            int i10 = (i9 / iMin2) + (i9 % iMin2 == 0 ? 0 : 1);
            int i11 = i7 / i8;
            int i12 = i9 / i10;
            android.graphics.Bitmap[][] bitmapArr = (android.graphics.Bitmap[][]) java.lang.reflect.Array.newInstance((java.lang.Class<?>) android.graphics.Bitmap.class, i10, i8);
            if (this.canvas == null) {
                android.graphics.Canvas canvas = new android.graphics.Canvas();
                this.canvas = canvas;
                int i13 = this.mDensity;
                if (i13 > 0) {
                    canvas.setDensity(i13);
                }
            }
            android.graphics.Rect rect = new android.graphics.Rect();
            android.graphics.Rect rect2 = new android.graphics.Rect();
            for (int i14 = 0; i14 < i10; i14++) {
                for (int i15 = 0; i15 < i8; i15++) {
                    android.graphics.Bitmap[] bitmapArr2 = bitmapArr[i14];
                    android.graphics.Bitmap bitmapCreateBitmap = tv.cjump.jni.NativeBitmapFactory.createBitmap(i11, i12, android.graphics.Bitmap.Config.ARGB_8888);
                    bitmapArr2[i15] = bitmapCreateBitmap;
                    int i16 = this.mDensity;
                    if (i16 > 0) {
                        bitmapCreateBitmap.setDensity(i16);
                    }
                    this.canvas.setBitmap(bitmapCreateBitmap);
                    int i17 = i15 * i11;
                    int i18 = i14 * i12;
                    rect.set(i17, i18, i17 + i11, i18 + i12);
                    rect2.set(0, 0, bitmapCreateBitmap.getWidth(), bitmapCreateBitmap.getHeight());
                    this.canvas.drawBitmap(this.bitmap, rect, rect2, (android.graphics.Paint) null);
                }
            }
            this.canvas.setBitmap(this.bitmap);
            this.bitmapArray = bitmapArr;
        }
    }

    private void eraseBitmap(android.graphics.Bitmap bitmap) {
        if (bitmap != null) {
            bitmap.eraseColor(0);
        }
    }

    private void eraseBitmapArray() {
        if (this.bitmapArray != null) {
            for (int i = 0; i < this.bitmapArray.length; i++) {
                int i2 = 0;
                while (true) {
                    android.graphics.Bitmap[] bitmapArr = this.bitmapArray[i];
                    if (i2 < bitmapArr.length) {
                        eraseBitmap(bitmapArr[i2]);
                        i2++;
                    }
                }
            }
        }
    }

    private void recycleBitmapArray() {
        android.graphics.Bitmap[][] bitmapArr = this.bitmapArray;
        this.bitmapArray = null;
        if (bitmapArr != null) {
            for (int i = 0; i < bitmapArr.length; i++) {
                int i2 = 0;
                while (true) {
                    android.graphics.Bitmap[] bitmapArr2 = bitmapArr[i];
                    if (i2 < bitmapArr2.length) {
                        android.graphics.Bitmap bitmap = bitmapArr2[i2];
                        if (bitmap != null) {
                            bitmap.recycle();
                            bitmapArr[i][i2] = null;
                        }
                        i2++;
                    }
                }
            }
        }
    }

    public final synchronized boolean draw(android.graphics.Canvas canvas, float f, float f2, android.graphics.Paint paint) {
        if (this.bitmapArray != null) {
            for (int i = 0; i < this.bitmapArray.length; i++) {
                int i2 = 0;
                while (true) {
                    android.graphics.Bitmap[] bitmapArr = this.bitmapArray[i];
                    if (i2 < bitmapArr.length) {
                        android.graphics.Bitmap bitmap = bitmapArr[i2];
                        if (bitmap != null) {
                            float width = (bitmap.getWidth() * i2) + f;
                            if (width <= canvas.getWidth() && bitmap.getWidth() + width >= 0.0f) {
                                float height = (bitmap.getHeight() * i) + f2;
                                if (height <= canvas.getHeight() && bitmap.getHeight() + height >= 0.0f) {
                                    canvas.drawBitmap(bitmap, width, height, paint);
                                }
                            }
                        }
                        i2++;
                    }
                }
            }
            return true;
        }
        android.graphics.Bitmap bitmap2 = this.bitmap;
        if (bitmap2 == null) {
            return false;
        }
        canvas.drawBitmap(bitmap2, f, f2, paint);
        return true;
    }
}
