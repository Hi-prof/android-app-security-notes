package io.dcloud.common.core.ui;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class g {
    private static boolean j0 = false;
    private java.lang.String A;
    private java.lang.String C;
    private java.lang.String D;
    private io.dcloud.common.DHInterface.IFrameView J;
    private java.lang.String K;
    private java.lang.String L;
    private java.lang.String M;
    private int N;
    private boolean O;
    private float P;
    private int Q;
    private int R;
    private int W;
    private android.util.DisplayMetrics X;
    private float Z;
    private float a0;
    private float b0;
    private float c0;
    private float d0;
    private float e0;
    private android.view.VelocityTracker f;
    boolean g0;
    private int h;
    private float i;
    private java.util.regex.Pattern i0;
    private float j;
    private float k;
    private int l;
    private io.dcloud.common.core.ui.b q;
    private io.dcloud.common.core.ui.b r;
    private android.view.View t;
    private java.lang.String w;
    private java.lang.String y;
    private boolean a = false;
    private boolean b = false;
    private boolean c = false;
    private boolean d = false;
    private boolean e = false;
    private boolean g = true;
    private int m = 0;
    private int n = 0;
    private int o = 0;
    private int p = 0;
    private android.view.View s = null;
    private boolean u = false;
    private int v = Integer.MAX_VALUE;
    private int x = Integer.MAX_VALUE;
    private int z = Integer.MAX_VALUE;
    private int B = Integer.MAX_VALUE;
    private boolean E = false;
    private boolean F = true;
    private boolean G = true;
    private boolean H = true;
    private int I = -1;
    private boolean S = false;
    private boolean T = false;
    private boolean U = false;
    private int V = Integer.MAX_VALUE;
    private float Y = 20.0f;
    boolean f0 = true;
    private java.lang.String h0 = "^([1-9]|[1-9]\\d|100)$";

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class a implements android.view.ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int i;
            io.dcloud.common.core.ui.g.this.t.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            io.dcloud.common.core.ui.g gVar = io.dcloud.common.core.ui.g.this;
            boolean z = true;
            if (gVar.d(gVar.L)) {
                i = io.dcloud.common.core.ui.g.this.p;
            } else {
                io.dcloud.common.core.ui.g gVar2 = io.dcloud.common.core.ui.g.this;
                int iB = gVar2.b(gVar2.t) / 2;
                android.graphics.Rect rect = new android.graphics.Rect();
                io.dcloud.common.core.ui.g.this.t.getGlobalVisibleRect(rect);
                if (rect.right - rect.left >= iB) {
                    i = io.dcloud.common.core.ui.g.this.p;
                } else {
                    i = io.dcloud.common.core.ui.g.this.o;
                    z = false;
                }
            }
            io.dcloud.common.core.ui.g gVar3 = io.dcloud.common.core.ui.g.this;
            int iA = gVar3.a(gVar3.t);
            io.dcloud.common.core.ui.g gVar4 = io.dcloud.common.core.ui.g.this;
            io.dcloud.nineoldandroids.animation.ValueAnimator valueAnimatorA = gVar4.a(gVar4.t, iA, i, z);
            if (valueAnimatorA != null) {
                valueAnimatorA.start();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class b implements android.view.ViewTreeObserver.OnGlobalLayoutListener {
        b() {
        }

        /* JADX WARN: Code duplicated, block: B:32:0x00e0  */
        /* JADX WARN: Code duplicated, block: B:53:0x0166  */
        /* JADX WARN: Code duplicated, block: B:63:0x019c  */
        /* JADX WARN: Code duplicated, block: B:66:0x01ab  */
        /* JADX WARN: Code duplicated, block: B:67:0x01ba  */
        /* JADX WARN: Code duplicated, block: B:70:0x01d3  */
        /* JADX WARN: Code duplicated, block: B:72:? A[RETURN, SYNTHETIC] */
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int i;
            boolean z;
            boolean z2;
            boolean z3;
            io.dcloud.nineoldandroids.animation.ValueAnimator valueAnimatorA;
            android.graphics.Rect rect;
            io.dcloud.common.core.ui.g.this.s.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            io.dcloud.common.core.ui.g gVar = io.dcloud.common.core.ui.g.this;
            boolean z4 = true;
            if (!gVar.d(gVar.L)) {
                if (io.dcloud.common.core.ui.g.this.t != null) {
                    io.dcloud.common.core.ui.g gVar2 = io.dcloud.common.core.ui.g.this;
                    int iB = gVar2.b(gVar2.t) / 2;
                    android.graphics.Rect rect2 = new android.graphics.Rect();
                    io.dcloud.common.core.ui.g.this.t.getGlobalVisibleRect(rect2);
                    android.graphics.Rect rect3 = new android.graphics.Rect();
                    io.dcloud.common.core.ui.g.this.s.getGlobalVisibleRect(rect3);
                    int i2 = rect2.left;
                    if (i2 == 0) {
                        int i3 = rect3.left - i2;
                        if (!"right".equals(io.dcloud.common.core.ui.g.this.L)) {
                            if (!"left".equals(io.dcloud.common.core.ui.g.this.L)) {
                                i = 0;
                            } else if (i3 <= iB) {
                                i = io.dcloud.common.core.ui.g.this.n;
                            } else {
                                i = io.dcloud.common.core.ui.g.this.m;
                            }
                            z = false;
                        } else if (i3 >= iB) {
                            i = io.dcloud.common.core.ui.g.this.n;
                        } else {
                            i = io.dcloud.common.core.ui.g.this.m;
                            z = false;
                        }
                    } else {
                        if (rect2.right == io.dcloud.common.core.ui.g.this.Q) {
                            int i4 = rect2.right - rect3.right;
                            if ("right".equals(io.dcloud.common.core.ui.g.this.L)) {
                                if (i4 <= iB) {
                                    i = io.dcloud.common.core.ui.g.this.n;
                                } else {
                                    i = io.dcloud.common.core.ui.g.this.m;
                                }
                            } else if (!"left".equals(io.dcloud.common.core.ui.g.this.L)) {
                                i = 0;
                            } else if (i4 >= iB) {
                                i = io.dcloud.common.core.ui.g.this.n;
                            } else {
                                i = io.dcloud.common.core.ui.g.this.m;
                            }
                        } else {
                            i = 0;
                        }
                        z = false;
                    }
                } else {
                    android.graphics.Rect rect4 = new android.graphics.Rect();
                    io.dcloud.common.core.ui.g.this.s.getGlobalVisibleRect(rect4);
                    int i5 = rect4.right - rect4.left;
                    int width = io.dcloud.common.core.ui.g.this.s.getWidth() / 2;
                    if (!"right".equals(io.dcloud.common.core.ui.g.this.L) || io.dcloud.common.core.ui.g.this.m >= 0) {
                        if (!"left".equals(io.dcloud.common.core.ui.g.this.L) || io.dcloud.common.core.ui.g.this.n < 0) {
                            if (i5 <= width) {
                                i = io.dcloud.common.core.ui.g.this.n;
                            } else {
                                i = io.dcloud.common.core.ui.g.this.m;
                                z = false;
                            }
                        } else if (i5 >= width) {
                            i = io.dcloud.common.core.ui.g.this.n;
                        } else {
                            i = io.dcloud.common.core.ui.g.this.m;
                            z = false;
                        }
                    } else if (i5 >= width) {
                        i = io.dcloud.common.core.ui.g.this.n;
                    } else {
                        i = io.dcloud.common.core.ui.g.this.m;
                        z = false;
                    }
                }
                if (io.dcloud.common.core.ui.g.this.t != null) {
                    rect = new android.graphics.Rect();
                    io.dcloud.common.core.ui.g.this.t.getGlobalVisibleRect(rect);
                    if (rect.left == 0 ? rect.right != io.dcloud.common.core.ui.g.this.Q || !"right".equals(io.dcloud.common.core.ui.g.this.L) : !"left".equals(io.dcloud.common.core.ui.g.this.L)) {
                        z4 = false;
                    }
                } else {
                    z4 = false;
                }
                if ("bounce".equalsIgnoreCase(io.dcloud.common.core.ui.g.this.D)) {
                    i = io.dcloud.common.core.ui.g.this.m;
                    io.dcloud.common.core.ui.g.this.D = null;
                    z3 = false;
                    z2 = false;
                } else {
                    z2 = z4;
                    z3 = z;
                }
                int i6 = i;
                io.dcloud.common.core.ui.g gVar3 = io.dcloud.common.core.ui.g.this;
                int iA = gVar3.a(gVar3.s);
                io.dcloud.common.core.ui.g gVar4 = io.dcloud.common.core.ui.g.this;
                valueAnimatorA = gVar4.a(gVar4.s, iA, i6, z3, z2);
                if (valueAnimatorA != null) {
                    valueAnimatorA.start();
                }
            }
            i = io.dcloud.common.core.ui.g.this.n;
            z = true;
            if (io.dcloud.common.core.ui.g.this.t != null) {
                rect = new android.graphics.Rect();
                io.dcloud.common.core.ui.g.this.t.getGlobalVisibleRect(rect);
                if (rect.left == 0) {
                    z4 = false;
                } else {
                    z4 = false;
                }
            } else {
                z4 = false;
            }
            if ("bounce".equalsIgnoreCase(io.dcloud.common.core.ui.g.this.D)) {
                i = io.dcloud.common.core.ui.g.this.m;
                io.dcloud.common.core.ui.g.this.D = null;
                z3 = false;
                z2 = false;
            } else {
                z2 = z4;
                z3 = z;
            }
            int i7 = i;
            io.dcloud.common.core.ui.g gVar5 = io.dcloud.common.core.ui.g.this;
            int iA2 = gVar5.a(gVar5.s);
            io.dcloud.common.core.ui.g gVar6 = io.dcloud.common.core.ui.g.this;
            valueAnimatorA = gVar6.a(gVar6.s, iA2, i7, z3, z2);
            if (valueAnimatorA != null) {
                valueAnimatorA.start();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class c implements android.view.ViewTreeObserver.OnGlobalLayoutListener {
        c() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int i;
            int i2;
            int i3;
            int i4;
            int i5;
            io.dcloud.common.core.ui.g.this.s.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            io.dcloud.common.core.ui.g gVar = io.dcloud.common.core.ui.g.this;
            boolean z = true;
            int i6 = 0;
            if (gVar.d(gVar.L)) {
                int i7 = io.dcloud.common.core.ui.g.this.n;
                int i8 = io.dcloud.common.core.ui.g.this.p;
                if ("bounce".equalsIgnoreCase(io.dcloud.common.core.ui.g.this.D)) {
                    i4 = io.dcloud.common.core.ui.g.this.m;
                    i5 = io.dcloud.common.core.ui.g.this.o;
                    io.dcloud.common.core.ui.g.this.D = null;
                    i6 = i4;
                    i3 = i5;
                    z = false;
                } else {
                    i6 = i7;
                    i3 = i8;
                }
            } else if ("bounce".equalsIgnoreCase(io.dcloud.common.core.ui.g.this.D)) {
                i4 = io.dcloud.common.core.ui.g.this.m;
                i5 = io.dcloud.common.core.ui.g.this.o;
                io.dcloud.common.core.ui.g.this.D = null;
                i6 = i4;
                i3 = i5;
                z = false;
            } else {
                int i9 = io.dcloud.common.core.ui.g.this.Q;
                io.dcloud.common.core.ui.g gVar2 = io.dcloud.common.core.ui.g.this;
                int iA = gVar2.a(gVar2.t);
                io.dcloud.common.core.ui.g gVar3 = io.dcloud.common.core.ui.g.this;
                int iB = gVar3.b(gVar3.t) + iA;
                io.dcloud.common.core.ui.g gVar4 = io.dcloud.common.core.ui.g.this;
                gVar4.a(gVar4.s);
                io.dcloud.common.core.ui.g.this.s.getWidth();
                if (io.dcloud.common.core.ui.g.this.s.getWidth() >= io.dcloud.common.core.ui.g.this.Q) {
                    if (iA <= 0 && iB > 0) {
                        if (iB > 0) {
                            io.dcloud.common.core.ui.g gVar5 = io.dcloud.common.core.ui.g.this;
                            if (iB < gVar5.b(gVar5.t)) {
                                io.dcloud.common.core.ui.g gVar6 = io.dcloud.common.core.ui.g.this;
                                if (iB >= gVar6.b(gVar6.t) / 2) {
                                    i6 = io.dcloud.common.core.ui.g.this.n;
                                    i3 = io.dcloud.common.core.ui.g.this.p;
                                } else {
                                    i = io.dcloud.common.core.ui.g.this.m;
                                    i2 = io.dcloud.common.core.ui.g.this.o;
                                    i6 = i;
                                    i3 = i2;
                                    z = false;
                                }
                            }
                        }
                        io.dcloud.common.core.ui.g gVar7 = io.dcloud.common.core.ui.g.this;
                        if (iB == gVar7.b(gVar7.t)) {
                            io.dcloud.common.core.ui.g.this.b(true);
                            io.dcloud.common.core.ui.g gVar8 = io.dcloud.common.core.ui.g.this;
                            gVar8.a(gVar8.s, io.dcloud.common.core.ui.g.this.n);
                            io.dcloud.common.core.ui.g gVar9 = io.dcloud.common.core.ui.g.this;
                            gVar9.a(gVar9.t, io.dcloud.common.core.ui.g.this.p);
                            boolean unused = io.dcloud.common.core.ui.g.j0 = false;
                            return;
                        }
                        io.dcloud.common.core.ui.g.this.b(false);
                        io.dcloud.common.core.ui.g gVar10 = io.dcloud.common.core.ui.g.this;
                        gVar10.a(gVar10.s, io.dcloud.common.core.ui.g.this.m);
                        io.dcloud.common.core.ui.g gVar11 = io.dcloud.common.core.ui.g.this;
                        gVar11.a(gVar11.t, io.dcloud.common.core.ui.g.this.o);
                        boolean unused2 = io.dcloud.common.core.ui.g.j0 = false;
                        return;
                    }
                    if (iA >= i9 || i9 > iB) {
                        io.dcloud.common.core.ui.g.this.b(false);
                        io.dcloud.common.core.ui.g gVar12 = io.dcloud.common.core.ui.g.this;
                        gVar12.a(gVar12.s, io.dcloud.common.core.ui.g.this.m);
                        io.dcloud.common.core.ui.g gVar13 = io.dcloud.common.core.ui.g.this;
                        gVar13.a(gVar13.t, io.dcloud.common.core.ui.g.this.o);
                        boolean unused3 = io.dcloud.common.core.ui.g.j0 = false;
                        return;
                    }
                    int i10 = i9 - iA;
                    if (i10 > 0) {
                        io.dcloud.common.core.ui.g gVar14 = io.dcloud.common.core.ui.g.this;
                        if (i10 < gVar14.b(gVar14.t)) {
                            io.dcloud.common.core.ui.g gVar15 = io.dcloud.common.core.ui.g.this;
                            if (i10 >= gVar15.b(gVar15.t) / 2) {
                                i6 = io.dcloud.common.core.ui.g.this.n;
                                i3 = io.dcloud.common.core.ui.g.this.p;
                            } else {
                                i = io.dcloud.common.core.ui.g.this.m;
                                i2 = io.dcloud.common.core.ui.g.this.o;
                                i6 = i;
                                i3 = i2;
                                z = false;
                            }
                        }
                    }
                    io.dcloud.common.core.ui.g gVar16 = io.dcloud.common.core.ui.g.this;
                    if (i10 == gVar16.b(gVar16.t)) {
                        io.dcloud.common.core.ui.g.this.b(true);
                        io.dcloud.common.core.ui.g gVar17 = io.dcloud.common.core.ui.g.this;
                        gVar17.a(gVar17.s, io.dcloud.common.core.ui.g.this.n);
                        io.dcloud.common.core.ui.g gVar18 = io.dcloud.common.core.ui.g.this;
                        gVar18.a(gVar18.t, io.dcloud.common.core.ui.g.this.p);
                        boolean unused4 = io.dcloud.common.core.ui.g.j0 = false;
                        return;
                    }
                    io.dcloud.common.core.ui.g.this.b(false);
                    io.dcloud.common.core.ui.g gVar19 = io.dcloud.common.core.ui.g.this;
                    gVar19.a(gVar19.s, io.dcloud.common.core.ui.g.this.m);
                    io.dcloud.common.core.ui.g gVar20 = io.dcloud.common.core.ui.g.this;
                    gVar20.a(gVar20.t, io.dcloud.common.core.ui.g.this.o);
                    boolean unused5 = io.dcloud.common.core.ui.g.j0 = false;
                    return;
                }
                android.graphics.Rect rect = new android.graphics.Rect();
                io.dcloud.common.core.ui.g.this.s.getGlobalVisibleRect(rect);
                int i11 = rect.right - rect.left;
                int width = io.dcloud.common.core.ui.g.this.s.getWidth() / 2;
                if (rect.left == 0) {
                    if (i11 <= width) {
                        i6 = io.dcloud.common.core.ui.g.this.n;
                        i3 = io.dcloud.common.core.ui.g.this.p;
                    } else {
                        i = io.dcloud.common.core.ui.g.this.m;
                        i2 = io.dcloud.common.core.ui.g.this.o;
                        i6 = i;
                        i3 = i2;
                        z = false;
                    }
                } else if (io.dcloud.common.core.ui.g.this.Q != rect.right) {
                    i3 = 0;
                    z = false;
                } else if (i11 <= width) {
                    i6 = io.dcloud.common.core.ui.g.this.n;
                    i3 = io.dcloud.common.core.ui.g.this.p;
                } else {
                    i = io.dcloud.common.core.ui.g.this.m;
                    i2 = io.dcloud.common.core.ui.g.this.o;
                    i6 = i;
                    i3 = i2;
                    z = false;
                }
            }
            io.dcloud.common.core.ui.g gVar21 = io.dcloud.common.core.ui.g.this;
            int iA2 = gVar21.a(gVar21.s);
            io.dcloud.common.core.ui.g gVar22 = io.dcloud.common.core.ui.g.this;
            io.dcloud.nineoldandroids.animation.ValueAnimator valueAnimatorA = gVar22.a(gVar22.s, iA2, i6, z);
            if (valueAnimatorA != null) {
                valueAnimatorA.start();
            }
            io.dcloud.common.core.ui.g gVar23 = io.dcloud.common.core.ui.g.this;
            int iA3 = gVar23.a(gVar23.t);
            if (io.dcloud.common.core.ui.g.this.t != null) {
                io.dcloud.common.core.ui.g gVar24 = io.dcloud.common.core.ui.g.this;
                io.dcloud.nineoldandroids.animation.ValueAnimator valueAnimatorA2 = gVar24.a(gVar24.t, iA3, i3, z);
                if (valueAnimatorA2 != null) {
                    valueAnimatorA2.start();
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class d implements io.dcloud.nineoldandroids.animation.Animator.AnimatorListener {
        final /* synthetic */ boolean a;
        final /* synthetic */ boolean b;
        final /* synthetic */ android.view.View c;
        final /* synthetic */ int d;

        d(boolean z, boolean z2, android.view.View view, int i) {
            this.a = z;
            this.b = z2;
            this.c = view;
            this.d = i;
        }

        @Override // io.dcloud.nineoldandroids.animation.Animator.AnimatorListener
        public void onAnimationCancel(io.dcloud.nineoldandroids.animation.Animator animator) {
        }

        /* JADX WARN: Code duplicated, block: B:57:0x0137  */
        @Override // io.dcloud.nineoldandroids.animation.Animator.AnimatorListener
        public void onAnimationEnd(io.dcloud.nineoldandroids.animation.Animator animator) {
            io.dcloud.common.core.ui.b bVar;
            java.lang.String str;
            if (io.dcloud.common.core.ui.g.this.S) {
                io.dcloud.common.core.ui.g.this.S = false;
                io.dcloud.common.core.ui.g gVar = io.dcloud.common.core.ui.g.this;
                boolean z = this.a;
                gVar.a("end", z, this.b, z ? "100" : com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT);
            }
            if (this.a) {
                if (this.c == io.dcloud.common.core.ui.g.this.s && io.dcloud.common.core.ui.g.this.q != null) {
                    io.dcloud.common.core.ui.g gVar2 = io.dcloud.common.core.ui.g.this;
                    int iA = gVar2.a(gVar2.s);
                    if (iA <= (-io.dcloud.common.core.ui.g.this.s.getWidth()) || iA >= io.dcloud.common.core.ui.g.this.Q) {
                        io.dcloud.common.core.ui.g.this.q.popFromViewStack();
                    }
                }
            } else if (this.c == io.dcloud.common.core.ui.g.this.t) {
                io.dcloud.common.core.ui.g gVar3 = io.dcloud.common.core.ui.g.this;
                int iA2 = gVar3.a(gVar3.t);
                if (iA2 <= (-io.dcloud.common.core.ui.g.this.Q) || iA2 >= io.dcloud.common.core.ui.g.this.Q) {
                    if (Integer.MAX_VALUE != io.dcloud.common.core.ui.g.this.V && io.dcloud.common.core.ui.g.this.V != iA2) {
                        io.dcloud.common.core.ui.g gVar4 = io.dcloud.common.core.ui.g.this;
                        gVar4.b(gVar4.t, io.dcloud.common.core.ui.g.this.V);
                    }
                    io.dcloud.common.core.ui.g.this.V = Integer.MAX_VALUE;
                }
                if (!(this.c instanceof io.dcloud.common.DHInterface.INativeView) && io.dcloud.common.core.ui.g.this.r != null) {
                    io.dcloud.common.core.ui.g gVar5 = io.dcloud.common.core.ui.g.this;
                    int iA3 = gVar5.a(gVar5.t);
                    io.dcloud.common.core.ui.g gVar6 = io.dcloud.common.core.ui.g.this;
                    if (iA3 <= (-gVar6.b(gVar6.t)) || iA3 >= io.dcloud.common.core.ui.g.this.Q) {
                        io.dcloud.common.core.ui.g.this.r.popFromViewStack();
                    }
                }
            }
            io.dcloud.common.core.ui.g.this.a(this.c, this.d);
            android.view.View view = this.c;
            if (view != null) {
                if (this.b) {
                    bVar = null;
                    str = null;
                } else if (view == io.dcloud.common.core.ui.g.this.s) {
                    bVar = io.dcloud.common.core.ui.g.this.q;
                    str = this.a ? io.dcloud.common.core.ui.g.this.w : io.dcloud.common.core.ui.g.this.y;
                } else if (this.c == io.dcloud.common.core.ui.g.this.t) {
                    bVar = io.dcloud.common.core.ui.g.this.r;
                    str = this.a ? io.dcloud.common.core.ui.g.this.A : io.dcloud.common.core.ui.g.this.C;
                } else {
                    bVar = null;
                    str = null;
                }
                if ("hide".equalsIgnoreCase(str) || io.dcloud.common.constant.AbsoluteConst.EVENTS_CLOSE.equalsIgnoreCase(str)) {
                    android.view.KeyEvent.Callback callback = this.c;
                    if (callback instanceof io.dcloud.common.DHInterface.INativeView) {
                        java.lang.String viewId = ((io.dcloud.common.DHInterface.INativeView) callback).getViewId();
                        java.lang.String viewUUId = ((io.dcloud.common.DHInterface.INativeView) this.c).getViewUUId();
                        if (str.equalsIgnoreCase(io.dcloud.common.constant.AbsoluteConst.EVENTS_CLOSE)) {
                            str = "view_close";
                        }
                        io.dcloud.common.core.ui.g.this.q.obtainWindowMgr().processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.FeatureMgr, 1, new java.lang.Object[]{io.dcloud.common.core.ui.g.this.q.obtainWebView(), "nativeobj", str, io.dcloud.common.util.JSONUtil.createJSONArray("['" + viewId + "','" + viewUUId + "']")});
                    } else if (bVar != null) {
                        bVar.obtainWindowMgr().processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.FeatureMgr, 1, new java.lang.Object[]{bVar.obtainWebView(), io.dcloud.common.constant.AbsoluteConst.F_UI, "execMethod", io.dcloud.common.util.JSONUtil.createJSONArray("[\"NWindow\",\"" + str + "\",[\"" + bVar.obtainWebView().getWebviewUUID() + "\",[null,null,null]]]")});
                    }
                }
            }
            if (io.dcloud.common.core.ui.g.this.W <= 1) {
                boolean unused = io.dcloud.common.core.ui.g.j0 = false;
                io.dcloud.common.core.ui.g.this.t = null;
            }
            if (io.dcloud.common.core.ui.g.this.W >= 1) {
                io.dcloud.common.core.ui.g.h(io.dcloud.common.core.ui.g.this);
            }
        }

        @Override // io.dcloud.nineoldandroids.animation.Animator.AnimatorListener
        public void onAnimationRepeat(io.dcloud.nineoldandroids.animation.Animator animator) {
        }

        @Override // io.dcloud.nineoldandroids.animation.Animator.AnimatorListener
        public void onAnimationStart(io.dcloud.nineoldandroids.animation.Animator animator) {
            io.dcloud.common.core.ui.g.g(io.dcloud.common.core.ui.g.this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class e implements io.dcloud.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ android.view.View a;

        e(android.view.View view) {
            this.a = view;
        }

        @Override // io.dcloud.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(io.dcloud.nineoldandroids.animation.ValueAnimator valueAnimator) {
            android.view.ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
            android.view.View view = this.a;
            if (view instanceof io.dcloud.common.DHInterface.INativeView) {
                io.dcloud.common.core.ui.g.this.b(view, ((java.lang.Integer) valueAnimator.getAnimatedValue()).intValue());
                this.a.requestLayout();
                this.a.invalidate();
            } else {
                if (layoutParams instanceof android.widget.FrameLayout.LayoutParams) {
                    io.dcloud.nineoldandroids.view.ViewHelper.setX(view, ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue());
                    return;
                }
                if (layoutParams instanceof android.widget.AbsoluteLayout.LayoutParams) {
                    try {
                        io.dcloud.nineoldandroids.view.ViewHelper.setX(this.a, ((java.lang.Integer) valueAnimator.getAnimatedValue()).intValue());
                    } catch (java.lang.Exception unused) {
                        io.dcloud.nineoldandroids.view.ViewHelper.setX(this.a, ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                    this.a.requestLayout();
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class f implements android.view.ViewTreeObserver.OnGlobalLayoutListener {
        f() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int iB;
            int i;
            boolean z;
            int iB2;
            io.dcloud.common.core.ui.g.this.s.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            io.dcloud.common.core.ui.g gVar = io.dcloud.common.core.ui.g.this;
            int iB3 = 0;
            if (gVar.d(gVar.L)) {
                if ("right".equals(io.dcloud.common.core.ui.g.this.L)) {
                    i = io.dcloud.common.core.ui.g.this.Q;
                    iB3 = i;
                } else if ("left".equals(io.dcloud.common.core.ui.g.this.L)) {
                    io.dcloud.common.core.ui.g gVar2 = io.dcloud.common.core.ui.g.this;
                    iB2 = gVar2.b(gVar2.t);
                    i = -iB2;
                    iB3 = i;
                }
                iB = 0;
                z = true;
            } else {
                android.view.View view = (android.view.View) io.dcloud.common.core.ui.g.this.s.getParent();
                int[] iArr = new int[2];
                int[] iArr2 = new int[2];
                view.getLocationOnScreen(iArr);
                io.dcloud.common.core.ui.g.this.s.getLocationOnScreen(new int[2]);
                io.dcloud.common.core.ui.g.this.t.getLocationOnScreen(iArr2);
                int width = iArr[0] + view.getWidth();
                io.dcloud.common.core.ui.g.this.s.getWidth();
                int i2 = iArr2[0];
                io.dcloud.common.core.ui.g gVar3 = io.dcloud.common.core.ui.g.this;
                int iB4 = i2 + gVar3.b(gVar3.t);
                int i3 = iArr2[0];
                int i4 = iArr[0];
                if (i3 <= i4 && i4 < iB4) {
                    int i5 = iB4 - i4;
                    if (i5 > 0) {
                        io.dcloud.common.core.ui.g gVar4 = io.dcloud.common.core.ui.g.this;
                        if (i5 < gVar4.b(gVar4.t)) {
                            io.dcloud.common.core.ui.g gVar5 = io.dcloud.common.core.ui.g.this;
                            if (i5 <= gVar5.b(gVar5.t) / 2) {
                                io.dcloud.common.core.ui.g gVar6 = io.dcloud.common.core.ui.g.this;
                                iB2 = gVar6.b(gVar6.t);
                                i = -iB2;
                                iB3 = i;
                                iB = 0;
                                z = true;
                            } else {
                                io.dcloud.common.core.ui.g gVar7 = io.dcloud.common.core.ui.g.this;
                                iB = gVar7.b(gVar7.t);
                            }
                        }
                    }
                    io.dcloud.common.core.ui.g gVar8 = io.dcloud.common.core.ui.g.this;
                    if (i5 == gVar8.b(gVar8.t)) {
                        io.dcloud.common.core.ui.g.this.a(false, true);
                        io.dcloud.common.core.ui.g gVar9 = io.dcloud.common.core.ui.g.this;
                        android.view.View view2 = gVar9.s;
                        io.dcloud.common.core.ui.g gVar10 = io.dcloud.common.core.ui.g.this;
                        gVar9.a(view2, gVar10.b(gVar10.t));
                        io.dcloud.common.core.ui.g gVar11 = io.dcloud.common.core.ui.g.this;
                        gVar11.a(gVar11.t, 0);
                        boolean unused = io.dcloud.common.core.ui.g.j0 = false;
                        return;
                    }
                    io.dcloud.common.core.ui.g.this.a(true, true);
                    io.dcloud.common.core.ui.g gVar12 = io.dcloud.common.core.ui.g.this;
                    gVar12.a(gVar12.s, 0);
                    io.dcloud.common.core.ui.g gVar13 = io.dcloud.common.core.ui.g.this;
                    android.view.View view3 = gVar13.t;
                    io.dcloud.common.core.ui.g gVar14 = io.dcloud.common.core.ui.g.this;
                    gVar13.a(view3, -gVar14.b(gVar14.t));
                    boolean unused2 = io.dcloud.common.core.ui.g.j0 = false;
                    return;
                }
                if (i3 >= width || width > iB4) {
                    io.dcloud.common.core.ui.g.this.a(true, true);
                    io.dcloud.common.core.ui.g gVar15 = io.dcloud.common.core.ui.g.this;
                    gVar15.a(gVar15.s, 0);
                    io.dcloud.common.core.ui.g gVar16 = io.dcloud.common.core.ui.g.this;
                    gVar16.a(gVar16.t, io.dcloud.common.core.ui.g.this.Q);
                    boolean unused3 = io.dcloud.common.core.ui.g.j0 = false;
                    return;
                }
                int i6 = width - i3;
                if (i6 > 0) {
                    io.dcloud.common.core.ui.g gVar17 = io.dcloud.common.core.ui.g.this;
                    if (i6 < gVar17.b(gVar17.t)) {
                        io.dcloud.common.core.ui.g gVar18 = io.dcloud.common.core.ui.g.this;
                        if (i6 <= gVar18.b(gVar18.t) / 2) {
                            i = io.dcloud.common.core.ui.g.this.Q;
                            iB3 = i;
                            iB = 0;
                            z = true;
                        } else {
                            io.dcloud.common.core.ui.g gVar19 = io.dcloud.common.core.ui.g.this;
                            int i7 = -gVar19.b(gVar19.t);
                            int i8 = io.dcloud.common.core.ui.g.this.Q;
                            io.dcloud.common.core.ui.g gVar20 = io.dcloud.common.core.ui.g.this;
                            iB = i7;
                            iB3 = i8 - gVar20.b(gVar20.t);
                        }
                    }
                }
                io.dcloud.common.core.ui.g gVar21 = io.dcloud.common.core.ui.g.this;
                if (i6 != gVar21.b(gVar21.t)) {
                    io.dcloud.common.core.ui.g.this.a(true, true);
                    io.dcloud.common.core.ui.g gVar22 = io.dcloud.common.core.ui.g.this;
                    gVar22.a(gVar22.s, 0);
                    io.dcloud.common.core.ui.g gVar23 = io.dcloud.common.core.ui.g.this;
                    gVar23.a(gVar23.t, io.dcloud.common.core.ui.g.this.Q);
                    boolean unused4 = io.dcloud.common.core.ui.g.j0 = false;
                    return;
                }
                io.dcloud.common.core.ui.g.this.a(false, true);
                io.dcloud.common.core.ui.g gVar24 = io.dcloud.common.core.ui.g.this;
                android.view.View view4 = gVar24.s;
                io.dcloud.common.core.ui.g gVar25 = io.dcloud.common.core.ui.g.this;
                gVar24.a(view4, -gVar25.b(gVar25.t));
                io.dcloud.common.core.ui.g gVar26 = io.dcloud.common.core.ui.g.this;
                android.view.View view5 = gVar26.t;
                int i9 = io.dcloud.common.core.ui.g.this.Q;
                io.dcloud.common.core.ui.g gVar27 = io.dcloud.common.core.ui.g.this;
                gVar26.a(view5, i9 - gVar27.b(gVar27.t));
                boolean unused5 = io.dcloud.common.core.ui.g.j0 = false;
                return;
                z = false;
            }
            io.dcloud.common.core.ui.g gVar28 = io.dcloud.common.core.ui.g.this;
            int iA = gVar28.a(gVar28.s);
            if (iA != 0) {
                io.dcloud.common.core.ui.g gVar29 = io.dcloud.common.core.ui.g.this;
                io.dcloud.nineoldandroids.animation.ValueAnimator valueAnimatorA = gVar29.a(gVar29.s, iA, iB, z, true);
                if (valueAnimatorA != null) {
                    valueAnimatorA.start();
                }
            }
            io.dcloud.common.core.ui.g gVar30 = io.dcloud.common.core.ui.g.this;
            int iA2 = gVar30.a(gVar30.t);
            io.dcloud.common.core.ui.g gVar31 = io.dcloud.common.core.ui.g.this;
            io.dcloud.nineoldandroids.animation.ValueAnimator valueAnimatorA2 = gVar31.a(gVar31.t, iA2, iB3, z, true);
            if (valueAnimatorA2 != null) {
                valueAnimatorA2.start();
            }
        }
    }

    public g(io.dcloud.common.DHInterface.IFrameView iFrameView, android.content.Context context) {
        j0 = false;
        this.W = 0;
        if (iFrameView instanceof io.dcloud.common.core.ui.b) {
            this.q = (io.dcloud.common.core.ui.b) iFrameView;
            if (this.X == null) {
                android.util.DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                this.X = displayMetrics;
                int i = displayMetrics.widthPixels;
                this.Q = i;
                this.R = i;
            }
        }
        this.h = android.view.ViewConfiguration.get(context).getScaledTouchSlop();
        this.i0 = java.util.regex.Pattern.compile(this.h0);
    }

    static /* synthetic */ int g(io.dcloud.common.core.ui.g gVar) {
        int i = gVar.W;
        gVar.W = i + 1;
        return i;
    }

    static /* synthetic */ int h(io.dcloud.common.core.ui.g gVar) {
        int i = gVar.W;
        gVar.W = i - 1;
        return i;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0048 A[PHI: r2
  0x0048: PHI (r2v16 int) = (r2v15 int), (r2v19 int) binds: [B:12:0x003e, B:15:0x0046] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:30:0x0072 A[PHI: r2
  0x0072: PHI (r2v9 int) = (r2v8 int), (r2v12 int) binds: [B:26:0x0068, B:29:0x0070] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:36:0x0082 A[PHI: r0 r2
  0x0082: PHI (r0v8 float) = (r0v7 float), (r0v7 float), (r0v13 float), (r0v13 float) binds: [B:32:0x0078, B:35:0x0080, B:18:0x004e, B:21:0x0056] A[DONT_GENERATE, DONT_INLINE]
  0x0082: PHI (r2v13 int) = (r2v10 int), (r2v11 int), (r2v17 int), (r2v18 int) binds: [B:32:0x0078, B:35:0x0080, B:18:0x004e, B:21:0x0056] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x000f, code lost:
    
        if (r5 != 3) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean d(android.view.MotionEvent r5) {
        /*
            r4 = this;
            float r0 = r5.getRawX()
            int r5 = r5.getAction()
            r1 = 1
            if (r5 == r1) goto L90
            r2 = 2
            if (r5 == r2) goto L13
            r0 = 3
            if (r5 == r0) goto L90
            goto L8f
        L13:
            float r5 = r4.i
            float r5 = r0 - r5
            int r5 = (int) r5
            float r5 = (float) r5
            r4.i = r0
            float r5 = r4.a(r5)
            android.view.View r0 = r4.s
            int r0 = r4.a(r0)
            float r0 = (float) r0
            float r0 = r0 + r5
            android.view.View r2 = r4.t
            int r2 = r4.a(r2)
            float r2 = (float) r2
            float r5 = r5 + r2
            java.lang.String r2 = r4.L
            java.lang.String r3 = "right"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L59
            int r2 = r4.n
            float r3 = (float) r2
            int r3 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r3 < 0) goto L41
            goto L48
        L41:
            int r2 = r4.m
            float r3 = (float) r2
            int r3 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r3 > 0) goto L49
        L48:
            float r0 = (float) r2
        L49:
            int r2 = r4.p
            float r3 = (float) r2
            int r3 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r3 < 0) goto L51
            goto L82
        L51:
            int r2 = r4.o
            float r3 = (float) r2
            int r3 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r3 > 0) goto L83
            goto L82
        L59:
            java.lang.String r2 = r4.L
            java.lang.String r3 = "left"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L83
            int r2 = r4.m
            float r3 = (float) r2
            int r3 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r3 < 0) goto L6b
            goto L72
        L6b:
            int r2 = r4.n
            float r3 = (float) r2
            int r3 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r3 > 0) goto L73
        L72:
            float r0 = (float) r2
        L73:
            int r2 = r4.o
            float r3 = (float) r2
            int r3 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r3 < 0) goto L7b
            goto L82
        L7b:
            int r2 = r4.p
            float r3 = (float) r2
            int r3 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r3 > 0) goto L83
        L82:
            float r5 = (float) r2
        L83:
            android.view.View r2 = r4.s
            int r0 = (int) r0
            r4.b(r2, r0)
            android.view.View r0 = r4.t
            int r5 = (int) r5
            r4.b(r0, r5)
        L8f:
            return r1
        L90:
            r5 = 0
            r4.g = r5
            boolean r0 = r4.H
            if (r0 == 0) goto L9a
            r4.a()
        L9a:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.dcloud.common.core.ui.g.d(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0053 A[PHI: r4
  0x0053: PHI (r4v11 int) = (r4v9 int), (r4v10 int), (r4v13 int), (r4v14 int) binds: [B:20:0x0049, B:23:0x0051, B:12:0x002f, B:15:0x0037] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x000f, code lost:
    
        if (r4 != 3) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean f(android.view.MotionEvent r4) {
        /*
            r3 = this;
            float r0 = r4.getRawX()
            int r4 = r4.getAction()
            r1 = 1
            if (r4 == r1) goto L5b
            r2 = 2
            if (r4 == r2) goto L12
            r0 = 3
            if (r4 == r0) goto L5b
            goto L5a
        L12:
            float r4 = r3.i
            float r4 = r0 - r4
            r3.i = r0
            android.view.View r0 = r3.t
            int r0 = r3.a(r0)
            float r0 = (float) r0
            float r0 = r0 + r4
            java.lang.String r4 = r3.L
            java.lang.String r2 = "right"
            boolean r4 = r2.equals(r4)
            if (r4 == 0) goto L3a
            int r4 = r3.p
            float r2 = (float) r4
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 <= 0) goto L32
            goto L53
        L32:
            int r4 = r3.o
            float r2 = (float) r4
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 >= 0) goto L54
            goto L53
        L3a:
            java.lang.String r4 = r3.L
            java.lang.String r2 = "left"
            boolean r4 = r2.equals(r4)
            if (r4 == 0) goto L54
            int r4 = r3.o
            float r2 = (float) r4
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 <= 0) goto L4c
            goto L53
        L4c:
            int r4 = r3.p
            float r2 = (float) r4
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 >= 0) goto L54
        L53:
            float r0 = (float) r4
        L54:
            android.view.View r4 = r3.t
            int r0 = (int) r0
            r3.b(r4, r0)
        L5a:
            return r1
        L5b:
            r4 = 0
            r3.g = r4
            boolean r0 = r3.H
            if (r0 == 0) goto L65
            r3.c()
        L65:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.dcloud.common.core.ui.g.f(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0057 A[PHI: r4
  0x0057: PHI (r4v12 int) = (r4v10 int), (r4v11 int), (r4v14 int), (r4v15 int) binds: [B:20:0x004d, B:23:0x0055, B:12:0x0033, B:15:0x003b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x000f, code lost:
    
        if (r4 != 3) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean g(android.view.MotionEvent r4) {
        /*
            r3 = this;
            float r0 = r4.getRawX()
            int r4 = r4.getAction()
            r1 = 1
            if (r4 == r1) goto L5f
            r2 = 2
            if (r4 == r2) goto L12
            r0 = 3
            if (r4 == r0) goto L5f
            goto L5e
        L12:
            float r4 = r3.i
            float r4 = r0 - r4
            r3.i = r0
            float r4 = r3.a(r4)
            android.view.View r0 = r3.s
            int r0 = r3.a(r0)
            float r0 = (float) r0
            float r0 = r0 + r4
            java.lang.String r4 = r3.L
            java.lang.String r2 = "right"
            boolean r4 = r2.equals(r4)
            if (r4 == 0) goto L3e
            int r4 = r3.n
            float r2 = (float) r4
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 <= 0) goto L36
            goto L57
        L36:
            int r4 = r3.m
            float r2 = (float) r4
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 >= 0) goto L58
            goto L57
        L3e:
            java.lang.String r4 = r3.L
            java.lang.String r2 = "left"
            boolean r4 = r2.equals(r4)
            if (r4 == 0) goto L58
            int r4 = r3.m
            float r2 = (float) r4
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 <= 0) goto L50
            goto L57
        L50:
            int r4 = r3.n
            float r2 = (float) r4
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 >= 0) goto L58
        L57:
            float r0 = (float) r4
        L58:
            android.view.View r4 = r3.s
            int r0 = (int) r0
            r3.b(r4, r0)
        L5e:
            return r1
        L5f:
            r4 = 0
            r3.g = r4
            boolean r0 = r3.H
            if (r0 == 0) goto L69
            r3.d()
        L69:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.dcloud.common.core.ui.g.g(android.view.MotionEvent):boolean");
    }

    private boolean h() {
        this.m = a(this.s);
        if ("right".equals(this.L)) {
            int i = this.v;
            if (Integer.MAX_VALUE != i) {
                this.n = i;
                return this.m != i;
            }
            this.n = this.Q;
            android.view.View view = this.t;
            if (view == null) {
                if (view != null || this.m >= 0) {
                    return true;
                }
                this.n = 0;
                return true;
            }
            if ("bounce".equalsIgnoreCase(this.D)) {
                this.n = this.m + (b(this.s) / 2);
                return true;
            }
            if (b(this.t) >= this.Q) {
                return true;
            }
            int iA = a(this.s);
            int iA2 = a(this.t);
            int iA3 = a(this.t) + b(this.t);
            if (iA2 == 0 && iA3 == iA) {
                return false;
            }
            boolean z = this.G;
            if (!z && iA2 == 0) {
                this.n = b(this.t);
                return true;
            }
            if (z && iA3 == 0) {
                this.n = b(this.t);
                return true;
            }
            if (this.Q != iA3) {
                return true;
            }
            this.n = 0;
            return true;
        }
        if (!"left".equals(this.L)) {
            return true;
        }
        int i2 = this.v;
        if (Integer.MAX_VALUE != i2) {
            this.n = i2;
            return this.m != i2;
        }
        this.n = -b(this.s);
        android.view.View view2 = this.t;
        if (view2 == null) {
            if (view2 != null || this.m <= 0) {
                return true;
            }
            this.n = 0;
            return true;
        }
        if ("bounce".equalsIgnoreCase(this.D)) {
            this.n = this.m - (b(this.s) / 2);
            return true;
        }
        if (b(this.t) >= this.Q) {
            return true;
        }
        int iA4 = a(this.s) + b(this.s);
        int iA5 = a(this.t);
        int iA6 = a(this.t) + b(this.t);
        int i3 = this.Q;
        if (i3 == iA6 && iA5 == iA4) {
            return false;
        }
        boolean z2 = this.G;
        if (!z2 && i3 == iA6) {
            this.n = -b(this.t);
            return true;
        }
        if (z2 && i3 == iA5) {
            this.n = -b(this.t);
            return true;
        }
        if (iA5 != 0) {
            return true;
        }
        this.n = 0;
        return true;
    }

    private void i() {
        float f2 = this.m;
        this.Z = f2;
        float f3 = this.n;
        this.a0 = f3;
        this.c0 = f2;
        this.b0 = f2;
        float fAbs = java.lang.Math.abs(f3 - f2);
        this.d0 = fAbs;
        this.e0 = (fAbs * this.Y) / 100.0f;
        this.f0 = true;
        this.g0 = false;
    }

    private boolean j() {
        if ("right".equals(this.L)) {
            return a(this.t) != 0;
        }
        return ("left".equals(this.L) && a(this.t) + b(this.t) == this.Q) ? false : true;
    }

    private void k() {
        float fA = a(this.s);
        this.c0 = fA;
        if (this.f0) {
            float f2 = this.Z;
            if (fA == f2) {
                this.g0 = true;
                this.f0 = false;
                this.b0 = f2;
                a(com.taobao.weex.ui.view.gesture.WXGesture.MOVE, false, com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT);
                return;
            }
        }
        if (java.lang.Math.abs(fA - this.b0) >= this.e0) {
            this.f0 = true;
            this.g0 = true;
            a(com.taobao.weex.ui.view.gesture.WXGesture.MOVE, false, "" + ((int) ((java.lang.Math.abs(this.c0 - this.Z) / this.d0) * 100.0f)));
            this.b0 = this.c0;
            return;
        }
        if (this.g0) {
            float f3 = this.c0;
            float f4 = this.a0;
            if (f3 == f4) {
                this.g0 = false;
                this.f0 = true;
                this.b0 = f4;
                a(com.taobao.weex.ui.view.gesture.WXGesture.MOVE, false, "100");
            }
        }
    }

    public java.util.HashMap e() {
        io.dcloud.common.core.ui.b bVar = this.q;
        if (bVar == null || bVar.obtainFrameOptions() == null) {
            return null;
        }
        return this.q.obtainFrameOptions().dragData;
    }

    public void c(boolean z) {
        this.a = z;
    }

    public boolean c(android.view.MotionEvent motionEvent) {
        android.view.View view;
        android.view.View view2;
        if (!this.g) {
            return false;
        }
        if (motionEvent.getPointerCount() > 1) {
            return true;
        }
        if (io.dcloud.common.util.BaseInfo.sDoingAnimation) {
            if (this.U) {
                return false;
            }
            this.U = true;
            motionEvent.setAction(3);
        }
        if (this.a && !this.g) {
            return true;
        }
        if (this.f == null) {
            this.f = android.view.VelocityTracker.obtain();
        }
        if (this.I == -1 || j0) {
            return false;
        }
        if (2 == motionEvent.getAction()) {
            k();
            if ("left".equals(this.L)) {
                if (motionEvent.getRawX() < this.i) {
                    this.f.addMovement(motionEvent);
                }
            } else if ("right".equals(this.L) && motionEvent.getRawX() > this.i) {
                this.f.addMovement(motionEvent);
            }
        }
        if (1 == motionEvent.getAction() || 3 == motionEvent.getAction()) {
            this.f.addMovement(motionEvent);
        }
        if (this.T) {
            return e(motionEvent);
        }
        boolean z = this.E;
        if (z && this.F && this.G) {
            if ((!a(this.q) && !a(this.r)) || ((view2 = this.t) != null && (view2 instanceof io.dcloud.common.DHInterface.INativeView))) {
                return d(motionEvent);
            }
        } else if (z && !this.F && this.G) {
            if ((!a(this.q) && !a(this.r)) || ((view = this.t) != null && (view instanceof io.dcloud.common.DHInterface.INativeView))) {
                return f(motionEvent);
            }
        } else if (z && !this.G && this.F) {
            if (!a(this.q) && !a(this.r)) {
                return g(motionEvent);
            }
        } else if (!z && this.F && !a(this.q)) {
            return g(motionEvent);
        }
        return true;
    }

    private boolean e(java.lang.String str) {
        org.json.JSONObject jSONObject;
        org.json.JSONObject jSONObject2;
        this.s = this.q.obtainMainView();
        this.v = Integer.MAX_VALUE;
        this.x = Integer.MAX_VALUE;
        this.w = null;
        this.y = null;
        java.util.HashMap mapE = e();
        if (mapE == null || !mapE.containsKey(str)) {
            return false;
        }
        io.dcloud.common.adapter.util.DragBean dragBean = (io.dcloud.common.adapter.util.DragBean) mapE.get(str);
        if (dragBean != null) {
            this.K = dragBean.dragCbId;
            this.J = dragBean.dragCallBackWebView;
            org.json.JSONObject jSONObject3 = dragBean.dragCurrentViewOp;
            try {
                this.M = io.dcloud.common.util.JSONUtil.getString(jSONObject3, "direction");
                if (jSONObject3.has("moveMode")) {
                    java.lang.String string = io.dcloud.common.util.JSONUtil.getString(jSONObject3, "moveMode");
                    this.D = string;
                    this.F = "followFinger".equalsIgnoreCase(string) || "follow".equalsIgnoreCase(this.D) || "bounce".equalsIgnoreCase(this.D);
                }
                this.Y = 20.0f;
                if (jSONObject3.has("callbackStep")) {
                    try {
                        java.lang.String string2 = jSONObject3.getString("callbackStep");
                        if (this.i0.matcher(string2).find()) {
                            this.Y = java.lang.Integer.valueOf(string2).intValue();
                        }
                    } catch (java.lang.Exception e2) {
                        e2.printStackTrace();
                    }
                }
                if (jSONObject3.has("over") && (jSONObject2 = io.dcloud.common.util.JSONUtil.getJSONObject(jSONObject3, "over")) != null) {
                    if (jSONObject2.has("left")) {
                        this.v = io.dcloud.common.util.PdrUtil.parseInt(io.dcloud.common.util.JSONUtil.getString(jSONObject2, "left"), this.Q, Integer.MAX_VALUE);
                    }
                    if (jSONObject2.has("action")) {
                        this.w = io.dcloud.common.util.JSONUtil.getString(jSONObject2, "action");
                    }
                }
                if (jSONObject3.has(com.alibaba.android.bindingx.core.internal.BindingXConstants.STATE_CANCEL) && (jSONObject = io.dcloud.common.util.JSONUtil.getJSONObject(jSONObject3, com.alibaba.android.bindingx.core.internal.BindingXConstants.STATE_CANCEL)) != null) {
                    if (jSONObject.has("left")) {
                        this.x = io.dcloud.common.util.PdrUtil.parseInt(io.dcloud.common.util.JSONUtil.getString(jSONObject, "left"), this.Q, Integer.MAX_VALUE);
                    }
                    if (jSONObject.has("action")) {
                        this.y = io.dcloud.common.util.JSONUtil.getString(jSONObject, "action");
                    }
                }
            } catch (java.lang.Exception e3) {
                e3.printStackTrace();
                return false;
            }
        }
        return true;
    }

    public void b(android.view.MotionEvent motionEvent) {
        android.util.DisplayMetrics displayMetrics = this.X;
        if (displayMetrics != null) {
            this.Q = displayMetrics.widthPixels;
        }
        this.P = motionEvent.getRawX();
        float rawX = motionEvent.getRawX();
        this.i = rawX;
        this.k = rawX;
        this.j = motionEvent.getRawY();
        this.g = false;
        this.E = false;
        this.u = false;
        this.U = false;
        this.I = -1;
        this.q.obtainWebView().loadUrl("javascript:window.__needNotifyNative__=true;");
        this.q.obtainWebView().setWebviewProperty("needTouchEvent", io.dcloud.common.constant.AbsoluteConst.FALSE);
        this.O = false;
        this.N = this.q.obtainWebView().obtainWindowView().getScrollY();
        if (this.f == null) {
            this.f = android.view.VelocityTracker.obtain();
        }
        this.f.addMovement(motionEvent);
    }

    public boolean a(android.view.MotionEvent motionEvent) {
        android.view.View view;
        android.view.View view2;
        java.lang.String str;
        if (this.a) {
            return true;
        }
        if (e() != null && !io.dcloud.common.util.BaseInfo.sDoingAnimation && !j0) {
            int actionMasked = motionEvent.getActionMasked();
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            if (actionMasked == 0 && motionEvent.getEdgeFlags() != 0) {
                return false;
            }
            if (actionMasked == 0) {
                b(motionEvent);
            } else if (actionMasked == 1) {
                this.u = false;
                this.I = -1;
            } else if (actionMasked == 2) {
                if (this.N != this.q.obtainWebView().obtainWindowView().getScrollY()) {
                    this.O = true;
                }
                if (this.O) {
                    return false;
                }
                float f2 = rawX - this.i;
                if (java.lang.Math.abs(f2) >= java.lang.Math.abs(rawY - this.j)) {
                    if (this.h * 3 <= java.lang.Math.abs(motionEvent.getRawX() - this.P) && io.dcloud.common.constant.AbsoluteConst.FALSE.equals(this.q.obtainWebView().getWebviewProperty("needTouchEvent"))) {
                        if (f2 >= 0.0f) {
                            str = "right";
                            if (!this.u && e("right")) {
                                this.L = "right";
                                this.g = true;
                                this.u = true;
                            }
                        } else {
                            str = "left";
                            if (!this.u && e("left")) {
                                this.L = "left";
                                this.g = true;
                                this.u = true;
                            }
                        }
                        if (-1 == this.I) {
                            this.i = rawX;
                            android.view.View viewA = a(str);
                            if (viewA != null) {
                                java.util.HashMap mapE = e();
                                java.lang.String strC = c(str);
                                if (mapE != null && mapE.containsKey(strC)) {
                                    a(((io.dcloud.common.adapter.util.DragBean) mapE.get(strC)).dragBindViewOp);
                                }
                                this.L = str;
                                this.g = true;
                                this.t = viewA;
                                this.T = true;
                                this.I = 1;
                            } else {
                                b(this.L);
                            }
                        }
                    }
                }
            }
            if (this.g) {
                if (this.T) {
                    this.g = j();
                } else {
                    boolean z = this.E;
                    if (z && this.F && this.G) {
                        if ((!a(this.q) && !a(this.r)) || ((view2 = this.t) != null && (view2 instanceof io.dcloud.common.DHInterface.INativeView))) {
                            this.g = g();
                        }
                    } else if (z && !this.F && this.G) {
                        if ((!a(this.q) && !a(this.r)) || ((view = this.t) != null && (view instanceof io.dcloud.common.DHInterface.INativeView))) {
                            this.g = f();
                        }
                    } else if (!z && this.F) {
                        if (!a(this.q)) {
                            h();
                        }
                    } else if (z && !this.G && this.F) {
                        if (!a(this.q) && !a(this.r)) {
                            this.g = h();
                        }
                    } else {
                        this.g = false;
                    }
                }
            }
            if (this.g) {
                if (!a(this.q)) {
                    this.b = this.q.obtainWebView().obtainWindowView().isVerticalScrollBarEnabled();
                    this.c = this.q.obtainWebView().obtainWindowView().isHorizontalScrollBarEnabled();
                    this.q.obtainWebView().obtainWindowView().setVerticalScrollBarEnabled(false);
                    this.q.obtainWebView().obtainWindowView().setHorizontalScrollBarEnabled(false);
                }
                android.view.View view3 = this.t;
                if (view3 != null && (view3 instanceof com.dcloud.android.widget.AbsoluteLayout)) {
                    ((com.dcloud.android.widget.AbsoluteLayout) view3).getDrag().c(true);
                    if (!a(this.r)) {
                        this.d = this.r.obtainWebView().obtainWindowView().isVerticalScrollBarEnabled();
                        this.e = this.r.obtainWebView().obtainWindowView().isHorizontalScrollBarEnabled();
                        this.r.obtainWebView().obtainWindowView().setVerticalScrollBarEnabled(false);
                        this.r.obtainWebView().obtainWindowView().setHorizontalScrollBarEnabled(false);
                    }
                }
                a("start", false, com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT);
                i();
            }
            return this.g;
        }
        this.g = false;
        return false;
    }

    private int b(java.lang.String str) {
        android.view.View view;
        io.dcloud.common.adapter.util.DragBean dragBean;
        int i = this.I;
        if (i != -1) {
            return i;
        }
        this.r = null;
        this.t = null;
        java.util.HashMap mapE = e();
        if (mapE != null && mapE.containsKey(str) && (dragBean = (io.dcloud.common.adapter.util.DragBean) mapE.get(str)) != null) {
            a(dragBean.dragBindViewOp);
            io.dcloud.common.DHInterface.IFrameView iFrameView = dragBean.dragBindWebView;
            if (iFrameView != null && (iFrameView instanceof io.dcloud.common.core.ui.b)) {
                this.E = true;
                io.dcloud.common.core.ui.b bVar = (io.dcloud.common.core.ui.b) iFrameView;
                this.r = bVar;
                this.t = bVar.obtainMainView();
            } else {
                android.view.View view2 = dragBean.nativeView;
                this.t = view2;
                if (view2 != null) {
                    this.E = true;
                }
            }
        }
        if (a(this.r) && ((view = this.t) == null || !(view instanceof io.dcloud.common.DHInterface.INativeView))) {
            this.I = 0;
        } else {
            if (this.t.getVisibility() != 0) {
                this.r = null;
                this.t = null;
                return 0;
            }
            if (this.t.getParent() == null && (this.s.getParent() instanceof android.widget.FrameLayout) && !(this.t instanceof io.dcloud.common.DHInterface.INativeView)) {
                this.r.pushToViewStack();
            }
            if (!a(this.s, this.t) && !(this.t instanceof io.dcloud.common.DHInterface.INativeView)) {
                this.r = null;
                this.t = null;
                return 0;
            }
            if (!(this.t instanceof io.dcloud.common.DHInterface.INativeView) && this.G && this.s.getParent() != this.t.getParent()) {
                this.I = 0;
                return 0;
            }
            android.view.View view3 = this.t;
            if (view3 instanceof io.dcloud.common.DHInterface.INativeView) {
                view3.bringToFront();
            }
            int iA = a(this.t);
            int iA2 = a(this.s);
            if (iA2 == 0) {
                int width = this.s.getWidth();
                int i2 = this.Q;
                if (width == i2 && (iA >= i2 || iA <= (-b(this.t)))) {
                    this.V = iA;
                    boolean z = this.F;
                    if (z && this.G) {
                        if ("right".equals(str)) {
                            this.l = iA2 - b(this.t);
                        } else if ("left".equals(str)) {
                            this.l = iA2 + this.s.getWidth();
                        }
                        b(this.t, this.l);
                    } else if (!z && this.G) {
                        if ("right".equals(str)) {
                            this.l = -b(this.t);
                        } else if ("left".equals(str)) {
                            this.l = this.s.getWidth();
                        }
                        b(this.t, this.l);
                    }
                }
            }
            this.I = 1;
        }
        return this.I;
    }

    private boolean f() {
        this.o = a(this.t);
        if ("right".equals(this.L)) {
            int i = this.z;
            if (Integer.MAX_VALUE != i) {
                this.p = i;
                return this.o != i;
            }
            this.p = b(this.t);
            int i2 = this.o;
            if (i2 == 0 || i2 == this.Q) {
                return false;
            }
            if ("bounce".equalsIgnoreCase(this.D)) {
                this.p = this.o + (b(this.s) / 2);
                return true;
            }
            if (this.o >= 0) {
                return true;
            }
            this.p = 0;
            return true;
        }
        if (!"left".equals(this.L)) {
            return true;
        }
        int i3 = this.z;
        if (Integer.MAX_VALUE != i3) {
            this.p = i3;
            return this.o != i3;
        }
        int iB = b(this.t);
        this.p = -iB;
        if ("bounce".equalsIgnoreCase(this.D)) {
            this.p = this.o - (b(this.s) / 2);
            return true;
        }
        int i4 = this.Q;
        if (iB < i4) {
            int iA = a(this.t) + b(this.t);
            if (iA == this.Q || iA == 0) {
                return false;
            }
            android.graphics.Rect rect = new android.graphics.Rect();
            this.t.getGlobalVisibleRect(rect);
            int i5 = this.Q;
            if (i5 == rect.left) {
                this.p = i5 - iB;
                return true;
            }
            if (rect.right != 0) {
                return true;
            }
            this.p = 0;
            return true;
        }
        if (iB != i4 || this.o <= 0) {
            return true;
        }
        this.p = 0;
        return true;
    }

    private boolean g() {
        return h() && f();
    }

    private void d() {
        this.S = true;
        j0 = true;
        this.s.requestLayout();
        this.s.getViewTreeObserver().addOnGlobalLayoutListener(new io.dcloud.common.core.ui.g.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(java.lang.String str) {
        android.view.VelocityTracker velocityTracker = this.f;
        if (velocityTracker == null) {
            return false;
        }
        velocityTracker.computeCurrentVelocity(1000, 1000.0f);
        float xVelocity = velocityTracker.getXVelocity();
        this.f.clear();
        this.f.recycle();
        this.f = null;
        return java.lang.Math.abs(xVelocity) >= 200.0f;
    }

    /* JADX WARN: Code duplicated, block: B:32:0x006d  */
    /* JADX WARN: Code duplicated, block: B:34:0x0075  */
    /* JADX WARN: Code duplicated, block: B:37:0x007c  */
    /* JADX WARN: Code duplicated, block: B:40:0x008f  */
    /* JADX WARN: Code duplicated, block: B:42:0x0097  */
    /* JADX WARN: Code duplicated, block: B:44:0x009d  */
    /* JADX WARN: Code duplicated, block: B:45:0x009f  */
    /* JADX WARN: Code duplicated, block: B:47:0x00b1 A[PHI: r10 r12
  0x00b1: PHI (r10v12 int) = (r10v11 int), (r10v19 int) binds: [B:46:0x00af, B:38:0x008c] A[DONT_GENERATE, DONT_INLINE]
  0x00b1: PHI (r12v1 int) = (r12v0 int), (r12v3 int) binds: [B:46:0x00af, B:38:0x008c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:50:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:52:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:53:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:55:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:56:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:58:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:60:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:61:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:63:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:65:0x00ff A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:66:0x0101  */
    /* JADX WARN: Code duplicated, block: B:67:0x010c  */
    /* JADX WARN: Code duplicated, block: B:69:0x0110  */
    /* JADX WARN: Code duplicated, block: B:72:0x0123  */
    /* JADX WARN: Code duplicated, block: B:73:0x0133  */
    /* JADX WARN: Code duplicated, block: B:75:0x0137  */
    /* JADX WARN: Code duplicated, block: B:76:0x0140  */
    /* JADX WARN: Code duplicated, block: B:78:0x0144  */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0015, code lost:
    
        if (r0 != 3) goto L84;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean e(android.view.MotionEvent r15) {
        /*
            Method dump skipped, instruction units count: 354
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.dcloud.common.core.ui.g.e(android.view.MotionEvent):boolean");
    }

    private void c() {
        this.S = true;
        j0 = true;
        android.view.View view = this.t;
        if (view != null) {
            view.requestLayout();
            this.t.getViewTreeObserver().addOnGlobalLayoutListener(new io.dcloud.common.core.ui.g.a());
        }
    }

    private java.lang.String c(java.lang.String str) {
        if ("left".equals(str)) {
            return "right";
        }
        if ("right".equals(str)) {
            return "left";
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        if (this.S) {
            this.S = false;
            a("end", z, z ? "100" : com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT);
        }
    }

    private void b() {
        this.S = true;
        j0 = true;
        if (this.t != null) {
            this.s.requestLayout();
            this.s.getViewTreeObserver().addOnGlobalLayoutListener(new io.dcloud.common.core.ui.g.f());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public int b(android.view.View view) {
        if (view == 0) {
            return 0;
        }
        if (view instanceof io.dcloud.common.DHInterface.INativeView) {
            return ((io.dcloud.common.DHInterface.INativeView) view).getStyleWidth();
        }
        return view.getWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(android.view.View view, int i) {
        if (view != 0) {
            if (view instanceof io.dcloud.common.DHInterface.INativeView) {
                ((io.dcloud.common.DHInterface.INativeView) view).setStyleLeft(i);
                return;
            }
            if (view.getLayoutParams() instanceof android.widget.AbsoluteLayout.LayoutParams) {
                android.widget.AbsoluteLayout.LayoutParams layoutParams = (android.widget.AbsoluteLayout.LayoutParams) view.getLayoutParams();
                layoutParams.height = view.getHeight();
                layoutParams.width = view.getWidth();
                io.dcloud.nineoldandroids.view.ViewHelper.setX(view, i);
                view.requestLayout();
                return;
            }
            if (view.getLayoutParams() instanceof android.widget.FrameLayout.LayoutParams) {
                io.dcloud.nineoldandroids.view.ViewHelper.setX(view, i);
            }
        }
    }

    private void a(org.json.JSONObject jSONObject) {
        org.json.JSONObject jSONObject2;
        org.json.JSONObject jSONObject3;
        if (jSONObject != null) {
            this.z = Integer.MAX_VALUE;
            this.B = Integer.MAX_VALUE;
            this.A = null;
            this.C = null;
            this.G = "follow".equalsIgnoreCase(io.dcloud.common.util.JSONUtil.getString(jSONObject, "moveMode"));
            if (jSONObject.has("over") && (jSONObject3 = io.dcloud.common.util.JSONUtil.getJSONObject(jSONObject, "over")) != null) {
                if (jSONObject3.has("left")) {
                    this.z = io.dcloud.common.util.PdrUtil.parseInt(io.dcloud.common.util.JSONUtil.getString(jSONObject3, "left"), this.Q, Integer.MAX_VALUE);
                }
                if (jSONObject3.has("action")) {
                    this.A = io.dcloud.common.util.JSONUtil.getString(jSONObject3, "action");
                }
            }
            if (!jSONObject.has(com.alibaba.android.bindingx.core.internal.BindingXConstants.STATE_CANCEL) || (jSONObject2 = io.dcloud.common.util.JSONUtil.getJSONObject(jSONObject, com.alibaba.android.bindingx.core.internal.BindingXConstants.STATE_CANCEL)) == null) {
                return;
            }
            if (jSONObject2.has("left")) {
                this.B = io.dcloud.common.util.PdrUtil.parseInt(io.dcloud.common.util.JSONUtil.getString(jSONObject2, "left"), this.Q, Integer.MAX_VALUE);
            }
            if (jSONObject2.has("action")) {
                this.C = io.dcloud.common.util.JSONUtil.getString(jSONObject2, "action");
            }
        }
    }

    private boolean a(android.view.View view, android.view.View view2) {
        if (view != null && view2 != null) {
            android.view.ViewParent parent = view2.getParent();
            for (android.view.ViewParent parent2 = view.getParent(); parent2 != null && parent2 != view2; parent2 = parent2.getParent()) {
                while (parent != null) {
                    if (parent == view) {
                        return false;
                    }
                    if (parent2 == parent) {
                        return true;
                    }
                    parent = parent.getParent();
                }
                parent = view2.getParent();
            }
            return false;
        }
        return false;
    }

    private void a() {
        this.S = true;
        j0 = true;
        this.s.requestLayout();
        this.s.getViewTreeObserver().addOnGlobalLayoutListener(new io.dcloud.common.core.ui.g.c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, boolean z2) {
        if (this.S) {
            this.S = false;
            a("end", z, z2, z ? "100" : com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(android.view.View view, int i) {
        io.dcloud.common.core.ui.b bVar;
        io.dcloud.common.core.ui.b bVar2;
        if (view != null) {
            if (view == this.s && (bVar2 = this.q) != null) {
                bVar2.obtainFrameOptions().left = i;
                this.q.obtainFrameOptions().checkValueIsPercentage("left", i, this.Q, true, true);
            } else {
                if (view != this.t || (bVar = this.r) == null) {
                    return;
                }
                bVar.obtainFrameOptions().left = i;
                this.r.obtainFrameOptions().checkValueIsPercentage("left", i, this.Q, true, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public io.dcloud.nineoldandroids.animation.ValueAnimator a(android.view.View view, int i, int i2, boolean z) {
        return a(view, i, i2, z, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public io.dcloud.nineoldandroids.animation.ValueAnimator a(android.view.View view, int i, int i2, boolean z, boolean z2) {
        io.dcloud.nineoldandroids.animation.ValueAnimator valueAnimatorOfFloat = null;
        if (view == null) {
            return null;
        }
        android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if ((view instanceof io.dcloud.common.DHInterface.INativeView) || (layoutParams instanceof android.widget.AbsoluteLayout.LayoutParams)) {
            valueAnimatorOfFloat = io.dcloud.nineoldandroids.animation.ValueAnimator.ofInt(i, i2);
        } else if (layoutParams instanceof android.widget.FrameLayout.LayoutParams) {
            valueAnimatorOfFloat = io.dcloud.nineoldandroids.animation.ValueAnimator.ofFloat(i, i2);
        }
        valueAnimatorOfFloat.setDuration(java.lang.Math.min(java.lang.Math.max(new java.math.BigDecimal(450).multiply(new java.math.BigDecimal(java.lang.Math.abs(i2 - i)).divide(new java.math.BigDecimal(this.Q), 4, 4)).longValue(), 200L), 250L));
        valueAnimatorOfFloat.addListener(new io.dcloud.common.core.ui.g.d(z, z2, view, i2));
        valueAnimatorOfFloat.addUpdateListener(new io.dcloud.common.core.ui.g.e(view));
        return valueAnimatorOfFloat;
    }

    private void a(java.lang.String str, boolean z, java.lang.String str2) {
        a(str, z, false, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:32:0x009f  */
    public void a(java.lang.String str, boolean z, boolean z2, java.lang.String str2) {
        java.lang.String strObtainFrameId;
        java.lang.String str3;
        if ("end".equals(str)) {
            if (!a(this.q)) {
                this.q.obtainWebView().obtainWindowView().setVerticalScrollBarEnabled(this.b);
                this.q.obtainWebView().obtainWindowView().setHorizontalScrollBarEnabled(this.c);
            }
            android.view.View view = this.t;
            if (view != null && (view instanceof com.dcloud.android.widget.AbsoluteLayout)) {
                ((com.dcloud.android.widget.AbsoluteLayout) view).getDrag().c(false);
                if (!a(this.r)) {
                    this.r.obtainWebView().obtainWindowView().setVerticalScrollBarEnabled(this.d);
                    android.webkit.WebView webViewObtainWebview = this.r.obtainWebView().obtainWebview();
                    if (webViewObtainWebview != null) {
                        webViewObtainWebview.setHorizontalScrollbarOverlay(this.e);
                    }
                }
            }
        }
        if (this.J == null || android.text.TextUtils.isEmpty(this.K) || android.text.TextUtils.isEmpty(str)) {
            return;
        }
        android.view.KeyEvent.Callback callback = this.t;
        java.lang.String strObtainFrameId2 = null;
        if (callback == null) {
            strObtainFrameId = null;
        } else if (callback instanceof io.dcloud.common.DHInterface.INativeView) {
            strObtainFrameId = ((io.dcloud.common.DHInterface.INativeView) callback).getViewId();
        } else {
            io.dcloud.common.core.ui.b bVar = this.r;
            if (bVar == null || bVar.obtainWebView() == null) {
                strObtainFrameId = null;
            } else {
                strObtainFrameId = this.r.obtainWebView().obtainFrameId();
            }
        }
        io.dcloud.common.core.ui.b bVar2 = this.q;
        if (bVar2 != null && bVar2.obtainWebView() != null) {
            strObtainFrameId2 = this.q.obtainWebView().obtainFrameId();
        }
        java.lang.String str4 = (!z ? z2 : !z2) ? strObtainFrameId2 : strObtainFrameId;
        if (!a(this.r) && this.r.isWebviewCovered()) {
            if (!a(this.q) && !this.q.isWebviewCovered()) {
                str4 = strObtainFrameId2;
            }
        } else if (!a(this.q) && this.q.isWebviewCovered() && !a(this.r) && !this.r.isWebviewCovered()) {
            str4 = strObtainFrameId;
        }
        if (android.text.TextUtils.isEmpty(str4)) {
            str4 = com.taobao.weex.common.Constants.Name.UNDEFINED;
        }
        java.lang.String str5 = "";
        if (android.text.TextUtils.isEmpty(strObtainFrameId2)) {
            strObtainFrameId2 = "";
        }
        if (android.text.TextUtils.isEmpty(strObtainFrameId)) {
            strObtainFrameId = "";
        }
        if ("left".equals(this.L)) {
            str5 = com.taobao.weex.common.Constants.Name.RTL;
        } else if ("right".equals(this.L)) {
            str5 = "ltr";
        }
        if (this.J.obtainWebView() != null) {
            if ("end".equals(str)) {
                str3 = io.dcloud.common.util.StringUtil.format("{\"type\":\"%s\",\"result\":%b,\"id\":\"%s\",\"targetId\":\"%s\",\"otherId\":\"%s\",\"direction\":\"%s\",\"progress\":\"%s\"}", str, java.lang.Boolean.valueOf(z), str4, strObtainFrameId2, strObtainFrameId, str5, str2);
            } else {
                str3 = io.dcloud.common.util.StringUtil.format("{\"type\":\"%s\",\"id\":\"%s\",\"targetId\":\"%s\",\"otherId\":\"%s\",\"direction\":\"%s\",\"progress\":\"%s\"}", str, str4, strObtainFrameId2, strObtainFrameId, str5, str2);
            }
            io.dcloud.common.util.Deprecated_JSUtil.execCallback(this.J.obtainWebView(), this.K, str3, io.dcloud.common.util.JSUtil.OK, true, true);
        }
    }

    public android.view.View a(java.lang.String str) {
        io.dcloud.common.adapter.util.DragBean dragBean;
        io.dcloud.common.DHInterface.IFrameView iFrameView;
        android.view.View viewObtainMainView;
        java.lang.String strC = c(str);
        java.util.HashMap<java.lang.String, io.dcloud.common.adapter.util.DragBean> map = this.q.obtainFrameOptions().dragData;
        if (map == null || !map.containsKey(strC) || (dragBean = map.get(strC)) == null || (iFrameView = dragBean.dragBindWebView) == null || !"follow".equalsIgnoreCase(io.dcloud.common.util.JSONUtil.getString(dragBean.dragBindViewOp, "moveMode")) || (viewObtainMainView = iFrameView.obtainMainView()) == null || viewObtainMainView.getVisibility() != 0 || viewObtainMainView.getWidth() >= this.Q) {
            return null;
        }
        int iA = a(viewObtainMainView);
        int width = viewObtainMainView.getWidth() + iA;
        if ((iA < 0 || iA >= this.Q) && (width <= 0 || width > this.Q)) {
            return null;
        }
        return viewObtainMainView;
    }

    private float a(float f2) {
        if (!"bounce".equalsIgnoreCase(this.D) || 0.0f == f2) {
            return f2;
        }
        boolean z = f2 < 0.0f;
        float fFloatValue = new java.math.BigDecimal(f2).multiply(new java.math.BigDecimal(java.lang.Math.abs(this.n - a(this.s))).divide(new java.math.BigDecimal(this.n - this.m), 4, 4)).floatValue();
        if (z) {
            fFloatValue = -fFloatValue;
        }
        if (z) {
            return java.lang.Math.min(fFloatValue, -2.0f);
        }
        return java.lang.Math.max(fFloatValue, 2.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public int a(android.view.View view) {
        if (view == 0) {
            return 0;
        }
        if (view instanceof io.dcloud.common.DHInterface.INativeView) {
            return ((io.dcloud.common.DHInterface.INativeView) view).getStyleLeft();
        }
        if (view.getLayoutParams() instanceof android.widget.AbsoluteLayout.LayoutParams) {
            return (int) io.dcloud.nineoldandroids.view.ViewHelper.getX(view);
        }
        if (view.getLayoutParams() instanceof android.widget.FrameLayout.LayoutParams) {
            return (int) io.dcloud.nineoldandroids.view.ViewHelper.getX(view);
        }
        return 0;
    }

    private boolean a(io.dcloud.common.core.ui.b bVar) {
        if (bVar == null) {
            return true;
        }
        if (bVar != null && bVar.obtainWebView() == null) {
            return true;
        }
        if (bVar == null || bVar.obtainMainView() != null) {
            return bVar != null && bVar.obtainWebView() == null && bVar.obtainMainView() == null;
        }
        return true;
    }
}
