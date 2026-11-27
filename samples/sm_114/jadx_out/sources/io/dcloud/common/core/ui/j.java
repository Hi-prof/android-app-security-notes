package io.dcloud.common.core.ui;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class j {
    private static final android.view.animation.Interpolator A = new io.dcloud.common.core.ui.j.a();
    private int a;
    private int b;
    private int c;
    private float[] d;
    private float[] e;
    private float[] f;
    private float[] g;
    private int[] h;
    private int[] i;
    private int[] j;
    private int k;
    private android.view.VelocityTracker l;
    private float m;
    private float n;
    private int o;
    private int p;
    private com.dcloud.android.v4.widget.ScrollerCompat q;
    private final io.dcloud.common.core.ui.j.c r;
    private android.view.View s;
    private boolean t;
    private final android.view.ViewGroup u;
    private int v;
    private io.dcloud.common.core.ui.b w;
    private io.dcloud.common.core.ui.a x;
    private final java.lang.Runnable y;
    private int z;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class a implements android.view.animation.Interpolator {
        a() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class b implements java.lang.Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            io.dcloud.common.core.ui.j.this.d(0);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public static abstract class c {
        public int a(int i) {
            return i;
        }

        public abstract int a(android.view.View view);

        public abstract int a(android.view.View view, int i, int i2);

        public void a(int i, int i2) {
        }

        public abstract void a(android.view.View view, float f, float f2);

        public void a(android.view.View view, int i) {
        }

        public void a(android.view.View view, int i, int i2, int i3, int i4) {
        }

        public abstract boolean a(io.dcloud.common.core.ui.b bVar);

        public abstract int b(android.view.View view);

        public void b(int i, int i2) {
        }

        public boolean b(int i) {
            return false;
        }

        public abstract boolean b(android.view.View view, int i);

        public void c(int i) {
        }
    }

    public j(android.view.ViewGroup viewGroup, io.dcloud.common.core.ui.j.c cVar, io.dcloud.common.core.ui.a aVar) {
        this(viewGroup.getContext(), viewGroup, cVar, aVar);
    }

    public void a(android.view.View view, int i) {
        if (view.getParent() != this.u) {
            throw new java.lang.IllegalArgumentException("captureChildView: parameter must be a descendant of the SwipeBackHelper's tracked parent view (" + this.u + com.taobao.weex.el.parse.Operators.BRACKET_END_STR);
        }
        this.s = view;
        this.c = i;
        this.r.a(view, i);
        d(1);
    }

    public void b(float f) {
        this.n = f;
    }

    public int c() {
        return this.a;
    }

    void d(int i) {
        if (this.a != i) {
            this.a = i;
            this.r.c(i);
            if (i == 0) {
                this.s = null;
            }
        }
    }

    public void e(int i) {
        this.o = i;
    }

    public void f(int i) {
        this.p = i;
    }

    public j(android.content.Context context, android.view.ViewGroup viewGroup, io.dcloud.common.core.ui.j.c cVar, io.dcloud.common.core.ui.a aVar) {
        this.c = -1;
        this.v = 170;
        this.x = null;
        this.y = new io.dcloud.common.core.ui.j.b();
        this.z = 0;
        if (viewGroup == null) {
            throw new java.lang.IllegalArgumentException("Parent view may not be null");
        }
        if (cVar == null) {
            throw new java.lang.IllegalArgumentException("Callback may not be null");
        }
        this.x = aVar;
        this.u = viewGroup;
        this.r = cVar;
        android.view.ViewConfiguration viewConfiguration = android.view.ViewConfiguration.get(context);
        this.o = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
        this.b = viewConfiguration.getScaledTouchSlop();
        this.m = viewConfiguration.getScaledMaximumFlingVelocity();
        this.n = viewConfiguration.getScaledMinimumFlingVelocity();
        this.q = com.dcloud.android.v4.widget.ScrollerCompat.create(context, A);
    }

    private boolean b(int i, int i2, int i3, int i4) {
        int left = this.s.getLeft();
        int top = this.s.getTop();
        int i5 = i - left;
        int i6 = i2 - top;
        if (i5 == 0 && i6 == 0) {
            this.q.abortAnimation();
            d(0);
            return false;
        }
        this.q.startScroll(left, top, i5, i6, a(this.s, i5, i6, i3, i4));
        d(2);
        return true;
    }

    public boolean c(int i) {
        return ((1 << i) & this.k) != 0;
    }

    public boolean e(int i, int i2) {
        if (this.t) {
            return b(i, i2, (int) androidx.core.view.VelocityTrackerCompat.getXVelocity(this.l, this.c), (int) androidx.core.view.VelocityTrackerCompat.getYVelocity(this.l, this.c));
        }
        throw new java.lang.IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARN: Code duplicated, block: B:63:0x00f1  */
    public boolean c(android.view.MotionEvent motionEvent) {
        io.dcloud.common.core.ui.b bVar;
        android.view.View viewA;
        android.view.View viewA2;
        int actionMasked = com.dcloud.android.v4.view.MotionEventCompat.getActionMasked(motionEvent);
        int actionIndex = com.dcloud.android.v4.view.MotionEventCompat.getActionIndex(motionEvent);
        if (actionMasked == 0) {
            a();
        }
        if (this.l == null) {
            this.l = android.view.VelocityTracker.obtain();
        }
        this.l.addMovement(motionEvent);
        if (actionMasked == 0) {
            this.z = 0;
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int pointerId = com.dcloud.android.v4.view.MotionEventCompat.getPointerId(motionEvent, 0);
            b(x, y, pointerId);
            android.view.View viewA3 = a((int) x, (int) y);
            if (viewA3 == this.s && this.a == 2) {
                b(viewA3, pointerId);
            }
            int i = this.h[pointerId] & this.p;
            if (i != 0) {
                this.r.b(i, pointerId);
            }
        } else if (actionMasked == 1) {
            this.z = 1;
            a();
        } else if (actionMasked == 2) {
            if (motionEvent.getX() > this.v || (bVar = this.w) == null || bVar.obtainMainView() == null) {
                return false;
            }
            int i2 = this.z;
            if ((i2 == 0 || i2 == 6) && !this.r.a(this.w)) {
                return false;
            }
            this.z = 2;
            int pointerCount = com.dcloud.android.v4.view.MotionEventCompat.getPointerCount(motionEvent);
            for (int i3 = 0; i3 < pointerCount; i3++) {
                int pointerId2 = com.dcloud.android.v4.view.MotionEventCompat.getPointerId(motionEvent, i3);
                float x2 = com.dcloud.android.v4.view.MotionEventCompat.getX(motionEvent, i3);
                float y2 = com.dcloud.android.v4.view.MotionEventCompat.getY(motionEvent, i3);
                float f = x2 - this.d[pointerId2];
                float f2 = y2 - this.e[pointerId2];
                if (java.lang.Math.abs(f) < java.lang.Math.abs(f2) || f < 0.0f) {
                    return false;
                }
                a(f, f2, pointerId2);
                if (this.a == 1 || ((viewA = a((int) x2, (int) y2)) != null && a(viewA, f, f2) && b(viewA, pointerId2))) {
                    break;
                }
            }
            b(motionEvent);
        } else if (actionMasked == 3) {
            this.z = 1;
            a();
        } else if (actionMasked == 5) {
            this.z = 0;
            int pointerId3 = com.dcloud.android.v4.view.MotionEventCompat.getPointerId(motionEvent, actionIndex);
            float x3 = com.dcloud.android.v4.view.MotionEventCompat.getX(motionEvent, actionIndex);
            float y3 = com.dcloud.android.v4.view.MotionEventCompat.getY(motionEvent, actionIndex);
            b(x3, y3, pointerId3);
            int i4 = this.a;
            if (i4 == 0) {
                int i5 = this.h[pointerId3] & this.p;
                if (i5 != 0) {
                    this.r.b(i5, pointerId3);
                }
            } else if (i4 == 2 && (viewA2 = a((int) x3, (int) y3)) == this.s) {
                b(viewA2, pointerId3);
            }
        } else if (actionMasked == 6) {
            this.z = 6;
            a(com.dcloud.android.v4.view.MotionEventCompat.getPointerId(motionEvent, actionIndex));
        }
        return this.a == 1;
    }

    public boolean d(int i, int i2) {
        return c(i2) && (i & this.h[i2]) != 0;
    }

    private void d() {
        this.l.computeCurrentVelocity(1000, this.m);
        a(a(androidx.core.view.VelocityTrackerCompat.getXVelocity(this.l, this.c), this.n, this.m), a(androidx.core.view.VelocityTrackerCompat.getYVelocity(this.l, this.c), this.n, this.m));
    }

    public void a() {
        this.c = -1;
        b();
        android.view.VelocityTracker velocityTracker = this.l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.l = null;
        }
    }

    private int a(android.view.View view, int i, int i2, int i3, int i4) {
        float f;
        float f2;
        float f3;
        float f4;
        int iA = a(i3, (int) this.n, (int) this.m);
        int iA2 = a(i4, (int) this.n, (int) this.m);
        int iAbs = java.lang.Math.abs(i);
        int iAbs2 = java.lang.Math.abs(i2);
        int iAbs3 = java.lang.Math.abs(iA);
        int iAbs4 = java.lang.Math.abs(iA2);
        int i5 = iAbs3 + iAbs4;
        int i6 = iAbs + iAbs2;
        if (iA != 0) {
            f = iAbs3;
            f2 = i5;
        } else {
            f = iAbs;
            f2 = i6;
        }
        float f5 = f / f2;
        if (iA2 != 0) {
            f3 = iAbs4;
            f4 = i5;
        } else {
            f3 = iAbs2;
            f4 = i6;
        }
        return (int) ((b(i, iA, this.r.a(view)) * f5) + (b(i2, iA2, this.r.b(view)) * (f3 / f4)));
    }

    private int b(int i, int i2, int i3) {
        int iAbs;
        if (i == 0) {
            return 0;
        }
        int width = this.u.getWidth();
        float f = width / 2;
        float fA = f + (a(java.lang.Math.min(1.0f, java.lang.Math.abs(i) / width)) * f);
        int iAbs2 = java.lang.Math.abs(i2);
        if (iAbs2 > 0) {
            iAbs = java.lang.Math.round(java.lang.Math.abs(fA / iAbs2) * 1000.0f) * 4;
        } else {
            iAbs = (int) (((java.lang.Math.abs(i) / i3) + 1.0f) * 256.0f);
        }
        return java.lang.Math.min(iAbs, tv.danmaku.ijk.media.player.IjkMediaCodecInfo.RANK_LAST_CHANCE);
    }

    private int a(int i, int i2, int i3) {
        int iAbs = java.lang.Math.abs(i);
        if (iAbs < i2) {
            return 0;
        }
        if (iAbs > i3) {
            return i > 0 ? i3 : -i3;
        }
        return i;
    }

    private float a(float f, float f2, float f3) {
        float fAbs = java.lang.Math.abs(f);
        if (fAbs < f2) {
            return 0.0f;
        }
        if (fAbs > f3) {
            return f > 0.0f ? f3 : -f3;
        }
        return f;
    }

    private void b() {
        float[] fArr = this.d;
        if (fArr == null) {
            return;
        }
        java.util.Arrays.fill(fArr, 0.0f);
        java.util.Arrays.fill(this.e, 0.0f);
        java.util.Arrays.fill(this.f, 0.0f);
        java.util.Arrays.fill(this.g, 0.0f);
        java.util.Arrays.fill(this.h, 0);
        java.util.Arrays.fill(this.i, 0);
        java.util.Arrays.fill(this.j, 0);
        this.k = 0;
    }

    private float a(float f) {
        return (float) java.lang.Math.sin((float) (((double) (f - 0.5f)) * 0.4712389167638204d));
    }

    public boolean a(boolean z) {
        if (this.a == 2) {
            boolean zComputeScrollOffset = this.q.computeScrollOffset();
            int currX = this.q.getCurrX();
            int currY = this.q.getCurrY();
            int left = currX - this.s.getLeft();
            int top = currY - this.s.getTop();
            if (left != 0) {
                this.s.offsetLeftAndRight(left);
            }
            if (left != 0 || top != 0) {
                this.r.a(this.s, currX, currY, left, top);
            }
            if (zComputeScrollOffset && currX == this.q.getFinalX() && currY == this.q.getFinalY()) {
                this.q.abortAnimation();
                zComputeScrollOffset = this.q.isFinished();
            }
            if (!zComputeScrollOffset) {
                if (z) {
                    this.u.post(this.y);
                } else {
                    d(0);
                }
            }
        }
        return this.a == 2;
    }

    private void b(int i) {
        float[] fArr = this.d;
        if (fArr == null || fArr.length <= i) {
            int i2 = i + 1;
            float[] fArr2 = new float[i2];
            float[] fArr3 = new float[i2];
            float[] fArr4 = new float[i2];
            float[] fArr5 = new float[i2];
            int[] iArr = new int[i2];
            int[] iArr2 = new int[i2];
            int[] iArr3 = new int[i2];
            if (fArr != null) {
                java.lang.System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.e;
                java.lang.System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.f;
                java.lang.System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.g;
                java.lang.System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.h;
                java.lang.System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.i;
                java.lang.System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.j;
                java.lang.System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.d = fArr2;
            this.e = fArr3;
            this.f = fArr4;
            this.g = fArr5;
            this.h = iArr;
            this.i = iArr2;
            this.j = iArr3;
        }
    }

    private void a(float f, float f2) {
        this.t = true;
        this.r.a(this.s, f, f2);
        this.t = false;
        if (this.a == 1) {
            d(0);
        }
    }

    private void b(float f, float f2, int i) {
        b(i);
        float[] fArr = this.d;
        this.f[i] = f;
        fArr[i] = f;
        float[] fArr2 = this.e;
        this.g[i] = f2;
        fArr2[i] = f2;
        this.h[i] = b((int) f, (int) f2);
        this.k |= 1 << i;
        this.w = this.x.h();
    }

    private void a(int i) {
        float[] fArr = this.d;
        if (fArr == null) {
            return;
        }
        fArr[i] = 0.0f;
        this.e[i] = 0.0f;
        this.f[i] = 0.0f;
        this.g[i] = 0.0f;
        this.h[i] = 0;
        this.i[i] = 0;
        this.j[i] = 0;
        this.k = (~(1 << i)) & this.k;
    }

    private void b(android.view.MotionEvent motionEvent) {
        int pointerCount = com.dcloud.android.v4.view.MotionEventCompat.getPointerCount(motionEvent);
        for (int i = 0; i < pointerCount; i++) {
            int pointerId = com.dcloud.android.v4.view.MotionEventCompat.getPointerId(motionEvent, i);
            float x = com.dcloud.android.v4.view.MotionEventCompat.getX(motionEvent, i);
            float y = com.dcloud.android.v4.view.MotionEventCompat.getY(motionEvent, i);
            this.f[pointerId] = x;
            this.g[pointerId] = y;
        }
    }

    boolean b(android.view.View view, int i) {
        if (view == this.s && this.c == i) {
            return true;
        }
        if (view == null || !this.r.b(view, i)) {
            return false;
        }
        this.c = i;
        a(view, i);
        return true;
    }

    public void a(android.view.MotionEvent motionEvent) {
        int i;
        int actionMasked = com.dcloud.android.v4.view.MotionEventCompat.getActionMasked(motionEvent);
        int actionIndex = com.dcloud.android.v4.view.MotionEventCompat.getActionIndex(motionEvent);
        if (actionMasked == 0) {
            a();
        }
        if (this.l == null) {
            this.l = android.view.VelocityTracker.obtain();
        }
        this.l.addMovement(motionEvent);
        int i2 = 0;
        if (actionMasked == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int pointerId = com.dcloud.android.v4.view.MotionEventCompat.getPointerId(motionEvent, 0);
            android.view.View viewA = a((int) x, (int) y);
            b(x, y, pointerId);
            b(viewA, pointerId);
            int i3 = this.h[pointerId] & this.p;
            if (i3 != 0) {
                this.r.b(i3, pointerId);
                return;
            }
            return;
        }
        if (actionMasked == 1) {
            if (this.a == 1) {
                d();
            }
            a();
            return;
        }
        if (actionMasked == 2) {
            io.dcloud.common.core.ui.b bVar = this.w;
            if (bVar == null || bVar.obtainMainView() == null) {
                return;
            }
            if (this.a == 1) {
                int iFindPointerIndex = com.dcloud.android.v4.view.MotionEventCompat.findPointerIndex(motionEvent, this.c);
                float x2 = com.dcloud.android.v4.view.MotionEventCompat.getX(motionEvent, iFindPointerIndex);
                float y2 = com.dcloud.android.v4.view.MotionEventCompat.getY(motionEvent, iFindPointerIndex);
                float[] fArr = this.f;
                int i4 = this.c;
                int i5 = (int) (x2 - fArr[i4]);
                int i6 = (int) (y2 - this.g[i4]);
                a(this.s.getLeft() + i5, this.s.getTop() + i6, i5, i6);
                b(motionEvent);
                return;
            }
            int pointerCount = com.dcloud.android.v4.view.MotionEventCompat.getPointerCount(motionEvent);
            while (i2 < pointerCount) {
                int pointerId2 = com.dcloud.android.v4.view.MotionEventCompat.getPointerId(motionEvent, i2);
                float x3 = com.dcloud.android.v4.view.MotionEventCompat.getX(motionEvent, i2);
                float y3 = com.dcloud.android.v4.view.MotionEventCompat.getY(motionEvent, i2);
                float f = x3 - this.d[pointerId2];
                float f2 = y3 - this.e[pointerId2];
                a(f, f2, pointerId2);
                if (this.a != 1) {
                    android.view.View viewA2 = a((int) x3, (int) y3);
                    if (a(viewA2, f, f2) && b(viewA2, pointerId2)) {
                        break;
                    } else {
                        i2++;
                    }
                } else {
                    break;
                }
            }
            b(motionEvent);
            return;
        }
        if (actionMasked == 3) {
            if (this.a == 1) {
                a(0.0f, 0.0f);
            }
            a();
            return;
        }
        if (actionMasked == 5) {
            int pointerId3 = com.dcloud.android.v4.view.MotionEventCompat.getPointerId(motionEvent, actionIndex);
            float x4 = com.dcloud.android.v4.view.MotionEventCompat.getX(motionEvent, actionIndex);
            float y4 = com.dcloud.android.v4.view.MotionEventCompat.getY(motionEvent, actionIndex);
            b(x4, y4, pointerId3);
            if (this.a == 0) {
                b(a((int) x4, (int) y4), pointerId3);
                int i7 = this.h[pointerId3] & this.p;
                if (i7 != 0) {
                    this.r.b(i7, pointerId3);
                    return;
                }
                return;
            }
            if (c((int) x4, (int) y4)) {
                b(this.s, pointerId3);
                return;
            }
            return;
        }
        if (actionMasked != 6) {
            return;
        }
        int pointerId4 = com.dcloud.android.v4.view.MotionEventCompat.getPointerId(motionEvent, actionIndex);
        if (this.a == 1 && pointerId4 == this.c) {
            int pointerCount2 = com.dcloud.android.v4.view.MotionEventCompat.getPointerCount(motionEvent);
            while (true) {
                if (i2 >= pointerCount2) {
                    i = -1;
                    break;
                }
                int pointerId5 = com.dcloud.android.v4.view.MotionEventCompat.getPointerId(motionEvent, i2);
                if (pointerId5 != this.c) {
                    android.view.View viewA3 = a((int) com.dcloud.android.v4.view.MotionEventCompat.getX(motionEvent, i2), (int) com.dcloud.android.v4.view.MotionEventCompat.getY(motionEvent, i2));
                    android.view.View view = this.s;
                    if (viewA3 == view && b(view, pointerId5)) {
                        i = this.c;
                        break;
                    }
                }
                i2++;
            }
            if (i == -1) {
                d();
            }
        }
        a(pointerId4);
    }

    private int b(int i, int i2) {
        int i3 = i < this.u.getLeft() + this.o ? 1 : 0;
        if (i2 < this.u.getTop() + this.o) {
            i3 |= 4;
        }
        if (i > this.u.getRight() - this.o) {
            i3 |= 2;
        }
        return i2 > this.u.getBottom() - this.o ? i3 | 8 : i3;
    }

    public boolean c(int i, int i2) {
        return a(this.s, i, i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3, types: [io.dcloud.common.core.ui.j$c] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void a(float f, float f2, int i) {
        int i2;
        boolean zA = a(f, f2, i, 1);
        ?? r0 = zA;
        if (a(f2, f, i, 4)) {
            r0 = (zA ? 1 : 0) | 4;
        }
        ?? r1 = r0;
        if (a(f, f2, i, 2)) {
            r1 = (r0 == true ? 1 : 0) | 2;
        }
        ?? r2 = r1;
        if (a(f2, f, i, 8)) {
            i2 = (r1 == true ? 1 : 0) | 8;
        }
        if (r2 == 0) {
            r2 = i2;
            return;
        }
        r2 = i2;
        int[] iArr = this.i;
        iArr[i] = (iArr[i] | r2) == true ? 1 : 0;
        this.r.a(r2, i);
    }

    private boolean a(float f, float f2, int i, int i2) {
        float fAbs = java.lang.Math.abs(f);
        float fAbs2 = java.lang.Math.abs(f2);
        if ((this.h[i] & i2) == i2 && (this.p & i2) != 0 && (this.j[i] & i2) != i2 && (this.i[i] & i2) != i2) {
            float f3 = this.b;
            if (fAbs > f3 || fAbs2 > f3) {
                if (fAbs < fAbs2 * 0.5f && this.r.b(i2)) {
                    int[] iArr = this.j;
                    iArr[i] = iArr[i] | i2;
                    return false;
                }
                if ((this.i[i] & i2) == 0 && fAbs > this.b) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean a(android.view.View view, float f, float f2) {
        if (view == null) {
            return false;
        }
        boolean z = this.r.a(view) > 0;
        boolean z2 = this.r.b(view) > 0;
        if (z && z2) {
            float f3 = (f * f) + (f2 * f2);
            int i = this.b;
            return f3 > ((float) (i * i));
        }
        if (z) {
            return java.lang.Math.abs(f) > ((float) this.b);
        }
        return z2 && java.lang.Math.abs(f2) > ((float) this.b);
    }

    private void a(int i, int i2, int i3, int i4) {
        int left = this.s.getLeft();
        int top = this.s.getTop();
        if (i3 != 0) {
            i = this.r.a(this.s, i, i3);
            this.s.offsetLeftAndRight(i - left);
        }
        int i5 = i;
        if (i3 == 0 && i4 == 0) {
            return;
        }
        this.r.a(this.s, i5, i2, i5 - left, i2 - top);
    }

    public boolean a(android.view.View view, int i, int i2) {
        return view != null && i >= view.getLeft() && i < view.getRight() && i2 >= view.getTop() && i2 < view.getBottom();
    }

    public android.view.View a(int i, int i2) {
        io.dcloud.common.core.ui.b bVar = this.w;
        if (bVar != null && bVar.obtainMainView() != null) {
            return this.w.obtainMainView();
        }
        for (int childCount = this.u.getChildCount() - 1; childCount >= 0; childCount--) {
            android.view.View childAt = this.u.getChildAt(this.r.a(childCount));
            if ((childAt instanceof com.dcloud.android.widget.AbsoluteLayout) && i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }
}
