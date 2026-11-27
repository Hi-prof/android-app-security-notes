package com.dcloud.android.v4.widget;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class ScrollerCompat {
    static final com.dcloud.android.v4.widget.ScrollerCompat.ScrollerCompatImpl IMPL = new com.dcloud.android.v4.widget.ScrollerCompat.ScrollerCompatImplIcs();
    java.lang.Object mScroller;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    interface ScrollerCompatImpl {
        void abortAnimation(java.lang.Object obj);

        boolean computeScrollOffset(java.lang.Object obj);

        java.lang.Object createScroller(android.content.Context context, android.view.animation.Interpolator interpolator);

        void fling(java.lang.Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8);

        void fling(java.lang.Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10);

        float getCurrVelocity(java.lang.Object obj);

        int getCurrX(java.lang.Object obj);

        int getCurrY(java.lang.Object obj);

        int getFinalX(java.lang.Object obj);

        int getFinalY(java.lang.Object obj);

        boolean isFinished(java.lang.Object obj);

        boolean isOverScrolled(java.lang.Object obj);

        void notifyHorizontalEdgeReached(java.lang.Object obj, int i, int i2, int i3);

        void notifyVerticalEdgeReached(java.lang.Object obj, int i, int i2, int i3);

        void startScroll(java.lang.Object obj, int i, int i2, int i3, int i4);

        void startScroll(java.lang.Object obj, int i, int i2, int i3, int i4, int i5);
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static class ScrollerCompatImplBase implements com.dcloud.android.v4.widget.ScrollerCompat.ScrollerCompatImpl {
        ScrollerCompatImplBase() {
        }

        @Override // com.dcloud.android.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public void abortAnimation(java.lang.Object obj) {
            ((android.widget.Scroller) obj).abortAnimation();
        }

        @Override // com.dcloud.android.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public boolean computeScrollOffset(java.lang.Object obj) {
            return ((android.widget.Scroller) obj).computeScrollOffset();
        }

        @Override // com.dcloud.android.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public java.lang.Object createScroller(android.content.Context context, android.view.animation.Interpolator interpolator) {
            return interpolator != null ? new android.widget.Scroller(context, interpolator) : new android.widget.Scroller(context);
        }

        @Override // com.dcloud.android.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public void fling(java.lang.Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            ((android.widget.Scroller) obj).fling(i, i2, i3, i4, i5, i6, i7, i8);
        }

        @Override // com.dcloud.android.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public float getCurrVelocity(java.lang.Object obj) {
            return 0.0f;
        }

        @Override // com.dcloud.android.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public int getCurrX(java.lang.Object obj) {
            return ((android.widget.Scroller) obj).getCurrX();
        }

        @Override // com.dcloud.android.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public int getCurrY(java.lang.Object obj) {
            return ((android.widget.Scroller) obj).getCurrY();
        }

        @Override // com.dcloud.android.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public int getFinalX(java.lang.Object obj) {
            return ((android.widget.Scroller) obj).getFinalX();
        }

        @Override // com.dcloud.android.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public int getFinalY(java.lang.Object obj) {
            return ((android.widget.Scroller) obj).getFinalY();
        }

        @Override // com.dcloud.android.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public boolean isFinished(java.lang.Object obj) {
            return ((android.widget.Scroller) obj).isFinished();
        }

        @Override // com.dcloud.android.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public boolean isOverScrolled(java.lang.Object obj) {
            return false;
        }

        @Override // com.dcloud.android.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public void notifyHorizontalEdgeReached(java.lang.Object obj, int i, int i2, int i3) {
        }

        @Override // com.dcloud.android.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public void notifyVerticalEdgeReached(java.lang.Object obj, int i, int i2, int i3) {
        }

        @Override // com.dcloud.android.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public void startScroll(java.lang.Object obj, int i, int i2, int i3, int i4) {
            ((android.widget.Scroller) obj).startScroll(i, i2, i3, i4);
        }

        @Override // com.dcloud.android.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public void fling(java.lang.Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
            ((android.widget.Scroller) obj).fling(i, i2, i3, i4, i5, i6, i7, i8);
        }

        @Override // com.dcloud.android.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public void startScroll(java.lang.Object obj, int i, int i2, int i3, int i4, int i5) {
            ((android.widget.Scroller) obj).startScroll(i, i2, i3, i4, i5);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static class ScrollerCompatImplGingerbread implements com.dcloud.android.v4.widget.ScrollerCompat.ScrollerCompatImpl {
        ScrollerCompatImplGingerbread() {
        }

        @Override // com.dcloud.android.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public void abortAnimation(java.lang.Object obj) {
            com.dcloud.android.v4.widget.ScrollerCompatGingerbread.abortAnimation(obj);
        }

        @Override // com.dcloud.android.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public boolean computeScrollOffset(java.lang.Object obj) {
            return com.dcloud.android.v4.widget.ScrollerCompatGingerbread.computeScrollOffset(obj);
        }

        @Override // com.dcloud.android.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public java.lang.Object createScroller(android.content.Context context, android.view.animation.Interpolator interpolator) {
            return com.dcloud.android.v4.widget.ScrollerCompatGingerbread.createScroller(context, interpolator);
        }

        @Override // com.dcloud.android.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public void fling(java.lang.Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            com.dcloud.android.v4.widget.ScrollerCompatGingerbread.fling(obj, i, i2, i3, i4, i5, i6, i7, i8);
        }

        @Override // com.dcloud.android.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public float getCurrVelocity(java.lang.Object obj) {
            return 0.0f;
        }

        @Override // com.dcloud.android.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public int getCurrX(java.lang.Object obj) {
            return com.dcloud.android.v4.widget.ScrollerCompatGingerbread.getCurrX(obj);
        }

        @Override // com.dcloud.android.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public int getCurrY(java.lang.Object obj) {
            return com.dcloud.android.v4.widget.ScrollerCompatGingerbread.getCurrY(obj);
        }

        @Override // com.dcloud.android.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public int getFinalX(java.lang.Object obj) {
            return com.dcloud.android.v4.widget.ScrollerCompatGingerbread.getFinalX(obj);
        }

        @Override // com.dcloud.android.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public int getFinalY(java.lang.Object obj) {
            return com.dcloud.android.v4.widget.ScrollerCompatGingerbread.getFinalY(obj);
        }

        @Override // com.dcloud.android.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public boolean isFinished(java.lang.Object obj) {
            return com.dcloud.android.v4.widget.ScrollerCompatGingerbread.isFinished(obj);
        }

        @Override // com.dcloud.android.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public boolean isOverScrolled(java.lang.Object obj) {
            return com.dcloud.android.v4.widget.ScrollerCompatGingerbread.isOverScrolled(obj);
        }

        @Override // com.dcloud.android.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public void notifyHorizontalEdgeReached(java.lang.Object obj, int i, int i2, int i3) {
            com.dcloud.android.v4.widget.ScrollerCompatGingerbread.notifyHorizontalEdgeReached(obj, i, i2, i3);
        }

        @Override // com.dcloud.android.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public void notifyVerticalEdgeReached(java.lang.Object obj, int i, int i2, int i3) {
            com.dcloud.android.v4.widget.ScrollerCompatGingerbread.notifyVerticalEdgeReached(obj, i, i2, i3);
        }

        @Override // com.dcloud.android.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public void startScroll(java.lang.Object obj, int i, int i2, int i3, int i4) {
            com.dcloud.android.v4.widget.ScrollerCompatGingerbread.startScroll(obj, i, i2, i3, i4);
        }

        @Override // com.dcloud.android.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public void fling(java.lang.Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
            com.dcloud.android.v4.widget.ScrollerCompatGingerbread.fling(obj, i, i2, i3, i4, i5, i6, i7, i8, i9, i10);
        }

        @Override // com.dcloud.android.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public void startScroll(java.lang.Object obj, int i, int i2, int i3, int i4, int i5) {
            com.dcloud.android.v4.widget.ScrollerCompatGingerbread.startScroll(obj, i, i2, i3, i4, i5);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static class ScrollerCompatImplIcs extends com.dcloud.android.v4.widget.ScrollerCompat.ScrollerCompatImplGingerbread {
        ScrollerCompatImplIcs() {
        }

        @Override // com.dcloud.android.v4.widget.ScrollerCompat.ScrollerCompatImplGingerbread, com.dcloud.android.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public float getCurrVelocity(java.lang.Object obj) {
            return com.dcloud.android.v4.widget.ScrollerCompatIcs.getCurrVelocity(obj);
        }
    }

    ScrollerCompat(android.content.Context context, android.view.animation.Interpolator interpolator) {
        this.mScroller = IMPL.createScroller(context, interpolator);
    }

    public static com.dcloud.android.v4.widget.ScrollerCompat create(android.content.Context context) {
        return create(context, null);
    }

    public void abortAnimation() {
        IMPL.abortAnimation(this.mScroller);
    }

    public boolean computeScrollOffset() {
        return IMPL.computeScrollOffset(this.mScroller);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        IMPL.fling(this.mScroller, i, i2, i3, i4, i5, i6, i7, i8);
    }

    public float getCurrVelocity() {
        return IMPL.getCurrVelocity(this.mScroller);
    }

    public int getCurrX() {
        return IMPL.getCurrX(this.mScroller);
    }

    public int getCurrY() {
        return IMPL.getCurrY(this.mScroller);
    }

    public int getFinalX() {
        return IMPL.getFinalX(this.mScroller);
    }

    public int getFinalY() {
        return IMPL.getFinalY(this.mScroller);
    }

    public boolean isFinished() {
        return IMPL.isFinished(this.mScroller);
    }

    public boolean isOverScrolled() {
        return IMPL.isOverScrolled(this.mScroller);
    }

    public void notifyHorizontalEdgeReached(int i, int i2, int i3) {
        IMPL.notifyHorizontalEdgeReached(this.mScroller, i, i2, i3);
    }

    public void notifyVerticalEdgeReached(int i, int i2, int i3) {
        IMPL.notifyVerticalEdgeReached(this.mScroller, i, i2, i3);
    }

    public void startScroll(int i, int i2, int i3, int i4) {
        IMPL.startScroll(this.mScroller, i, i2, i3, i4);
    }

    public static com.dcloud.android.v4.widget.ScrollerCompat create(android.content.Context context, android.view.animation.Interpolator interpolator) {
        return new com.dcloud.android.v4.widget.ScrollerCompat(context, interpolator);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        IMPL.fling(this.mScroller, i, i2, i3, i4, i5, i6, i7, i8, i9, i10);
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        IMPL.startScroll(this.mScroller, i, i2, i3, i4, i5);
    }
}
