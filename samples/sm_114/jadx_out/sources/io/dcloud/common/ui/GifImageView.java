package io.dcloud.common.ui;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class GifImageView extends android.view.View implements io.dcloud.common.DHInterface.IReflectAble {
    private float a;
    private float b;
    private float c;
    private android.graphics.Movie d;
    private long e;
    private long f;
    private long g;
    float h;
    private int i;
    private volatile boolean j;
    private volatile boolean k;
    private volatile boolean l;
    private boolean m;
    private io.dcloud.common.ui.GifImageView.a n;
    private int o;
    private int p;
    private int q;
    private float r;
    private float s;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public interface a {
        void a();

        void a(float f);

        void a(boolean z);

        void onPlayEnd();

        void onPlayStart();
    }

    public GifImageView(android.content.Context context) {
        this(context, null);
    }

    private void a(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, io.dcloud.PdrR.STYLE_GIFVIEW, i, 0);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(io.dcloud.PdrR.STYLE_GIFVIEW_gifSrc, 0);
        boolean z = typedArrayObtainStyledAttributes.getBoolean(io.dcloud.PdrR.STYLE_GIFVIEW_authPlay, true);
        this.i = typedArrayObtainStyledAttributes.getInt(io.dcloud.PdrR.STYLE_GIFVIEW_playCount, -1);
        if (resourceId > 0) {
            setGifResource(resourceId, (io.dcloud.common.ui.GifImageView.a) null);
            if (z) {
                play(this.i);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        setLayerType(1, null);
    }

    private void b() {
        this.j = false;
        this.e = android.os.SystemClock.uptimeMillis();
        this.k = false;
        this.l = true;
        this.f = 0L;
        this.g = 0L;
    }

    private int getCurrentFrameTime() {
        if (this.o == 0) {
            return 0;
        }
        long jUptimeMillis = android.os.SystemClock.uptimeMillis() - this.g;
        int i = (int) ((jUptimeMillis - this.e) / ((long) this.o));
        int i2 = this.i;
        if (i2 != -1 && i >= i2) {
            this.l = false;
            io.dcloud.common.ui.GifImageView.a aVar = this.n;
            if (aVar != null) {
                aVar.onPlayEnd();
            }
        }
        long j = jUptimeMillis - this.e;
        int i3 = this.o;
        float f = j % ((long) i3);
        this.h = f / i3;
        if (this.n != null && this.l) {
            double dDoubleValue = new java.math.BigDecimal(this.h).setScale(2, 4).doubleValue();
            if (dDoubleValue == 0.99d) {
                dDoubleValue = 1.0d;
            }
            this.n.a((float) dDoubleValue);
        }
        return (int) f;
    }

    public int getDuration() {
        android.graphics.Movie movie = this.d;
        if (movie != null) {
            return movie.duration();
        }
        return 0;
    }

    public boolean isPaused() {
        return this.k;
    }

    public boolean isPlaying() {
        return !this.k && this.l;
    }

    @Override // android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        if (this.d != null) {
            if (this.k || !this.l) {
                a(canvas);
                return;
            }
            if (this.j) {
                this.d.setTime(this.o - getCurrentFrameTime());
            } else {
                this.d.setTime(getCurrentFrameTime());
            }
            a(canvas);
            a();
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.r = (getWidth() - this.p) / 2.0f;
        this.s = (getHeight() - this.q) / 2.0f;
        this.m = getVisibility() == 0;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        android.graphics.Movie movie = this.d;
        if (movie == null) {
            setMeasuredDimension(getSuggestedMinimumWidth(), getSuggestedMinimumHeight());
            return;
        }
        int iWidth = movie.width();
        int iHeight = this.d.height();
        int size = android.view.View.MeasureSpec.getSize(i);
        float f = 1.0f / (iWidth / size);
        this.c = f;
        this.p = size;
        int i3 = (int) (iHeight * f);
        this.q = i3;
        setMeasuredDimension(size, i3);
    }

    @Override // android.view.View
    public void onScreenStateChanged(int i) {
        super.onScreenStateChanged(i);
        this.m = i == 1;
        a();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(android.view.View view, int i) {
        super.onVisibilityChanged(view, i);
        this.m = i == 0;
        a();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.m = i == 0;
        a();
    }

    public void pause() {
        if (this.d == null || this.k || !this.l) {
            io.dcloud.common.ui.GifImageView.a aVar = this.n;
            if (aVar != null) {
                aVar.a(false);
                return;
            }
            return;
        }
        this.k = true;
        invalidate();
        this.f = android.os.SystemClock.uptimeMillis();
        io.dcloud.common.ui.GifImageView.a aVar2 = this.n;
        if (aVar2 != null) {
            aVar2.a(true);
        }
    }

    public void play(int i) {
        this.i = i;
        b();
        io.dcloud.common.ui.GifImageView.a aVar = this.n;
        if (aVar != null) {
            aVar.onPlayStart();
        }
        invalidate();
    }

    public void playOver() {
        if (this.d != null) {
            play(-1);
        }
    }

    public void playReverse() {
        if (this.d != null) {
            b();
            this.j = true;
            io.dcloud.common.ui.GifImageView.a aVar = this.n;
            if (aVar != null) {
                aVar.onPlayStart();
            }
            invalidate();
        }
    }

    public void setGifResource(int i, io.dcloud.common.ui.GifImageView.a aVar) {
        if (aVar != null) {
            this.n = aVar;
        }
        b();
        android.graphics.Movie movieDecodeStream = android.graphics.Movie.decodeStream(getResources().openRawResource(i));
        this.d = movieDecodeStream;
        this.o = movieDecodeStream.duration() == 0 ? 1000 : this.d.duration();
        requestLayout();
    }

    public void setOnPlayListener(io.dcloud.common.ui.GifImageView.a aVar) {
        this.n = aVar;
    }

    public void setPercent(float f) {
        int i;
        android.graphics.Movie movie = this.d;
        if (movie == null || (i = this.o) <= 0) {
            return;
        }
        this.h = f;
        movie.setTime((int) (i * f));
        a();
        io.dcloud.common.ui.GifImageView.a aVar = this.n;
        if (aVar != null) {
            aVar.a(f);
        }
    }

    public GifImageView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public GifImageView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 1.0f;
        this.b = 1.0f;
        this.c = 1.0f;
        this.i = -1;
        this.j = false;
        this.m = true;
        a(context, attributeSet, i);
    }

    public void play() {
        if (this.d == null) {
            return;
        }
        if (this.l) {
            if (!this.k || this.f <= 0) {
                return;
            }
            this.k = false;
            this.g = (this.g + android.os.SystemClock.uptimeMillis()) - this.f;
            invalidate();
            io.dcloud.common.ui.GifImageView.a aVar = this.n;
            if (aVar != null) {
                aVar.a();
                return;
            }
            return;
        }
        play(this.i);
    }

    public void setGifResource(int i) {
        setGifResource(i, (io.dcloud.common.ui.GifImageView.a) null);
    }

    public void setGifResource(java.lang.String str, io.dcloud.common.ui.GifImageView.a aVar) {
        this.d = android.graphics.Movie.decodeFile(str);
        this.n = aVar;
        b();
        this.o = this.d.duration() == 0 ? 1000 : this.d.duration();
        requestLayout();
        io.dcloud.common.ui.GifImageView.a aVar2 = this.n;
        if (aVar2 != null) {
            aVar2.onPlayStart();
        }
    }

    private void a(android.graphics.Canvas canvas) {
        canvas.save();
        float f = this.c;
        canvas.scale(f, f);
        android.graphics.Movie movie = this.d;
        float f2 = this.r;
        float f3 = this.c;
        movie.draw(canvas, f2 / f3, this.s / f3);
        canvas.restore();
    }

    private void a() {
        if (this.m) {
            postInvalidateOnAnimation();
        }
    }
}
