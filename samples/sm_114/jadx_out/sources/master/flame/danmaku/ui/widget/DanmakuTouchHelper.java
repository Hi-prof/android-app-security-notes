package master.flame.danmaku.ui.widget;

/* JADX INFO: loaded from: classes2.dex */
public class DanmakuTouchHelper {
    private master.flame.danmaku.controller.IDanmakuView danmakuView;
    private android.graphics.RectF mDanmakuBounds;
    private final android.view.GestureDetector.OnGestureListener mOnGestureListener;
    private final android.view.GestureDetector mTouchDelegate;

    /* JADX WARN: Multi-variable type inference failed */
    private DanmakuTouchHelper(master.flame.danmaku.controller.IDanmakuView iDanmakuView) {
        android.view.GestureDetector.SimpleOnGestureListener simpleOnGestureListener = new android.view.GestureDetector.SimpleOnGestureListener() { // from class: master.flame.danmaku.ui.widget.DanmakuTouchHelper.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(android.view.MotionEvent motionEvent) {
                return (master.flame.danmaku.ui.widget.DanmakuTouchHelper.this.danmakuView == null || master.flame.danmaku.ui.widget.DanmakuTouchHelper.this.danmakuView.getOnDanmakuClickListener() == null) ? false : true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(android.view.MotionEvent motionEvent) {
                master.flame.danmaku.danmaku.model.IDanmakus iDanmakus = master.flame.danmaku.ui.widget.DanmakuTouchHelper.this.touchHitDanmaku(motionEvent.getX(), motionEvent.getY());
                boolean zPerformDanmakuClick = (iDanmakus == null || iDanmakus.isEmpty()) ? false : master.flame.danmaku.ui.widget.DanmakuTouchHelper.this.performDanmakuClick(iDanmakus);
                return !zPerformDanmakuClick ? master.flame.danmaku.ui.widget.DanmakuTouchHelper.this.performViewClick() : zPerformDanmakuClick;
            }
        };
        this.mOnGestureListener = simpleOnGestureListener;
        this.danmakuView = iDanmakuView;
        this.mDanmakuBounds = new android.graphics.RectF();
        this.mTouchDelegate = new android.view.GestureDetector(((android.view.View) iDanmakuView).getContext(), simpleOnGestureListener);
    }

    public static synchronized master.flame.danmaku.ui.widget.DanmakuTouchHelper instance(master.flame.danmaku.controller.IDanmakuView iDanmakuView) {
        return new master.flame.danmaku.ui.widget.DanmakuTouchHelper(iDanmakuView);
    }

    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        return this.mTouchDelegate.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean performDanmakuClick(master.flame.danmaku.danmaku.model.IDanmakus iDanmakus) {
        master.flame.danmaku.controller.IDanmakuView.OnDanmakuClickListener onDanmakuClickListener = this.danmakuView.getOnDanmakuClickListener();
        if (onDanmakuClickListener != null) {
            return onDanmakuClickListener.onDanmakuClick(iDanmakus);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean performViewClick() {
        master.flame.danmaku.controller.IDanmakuView.OnDanmakuClickListener onDanmakuClickListener = this.danmakuView.getOnDanmakuClickListener();
        if (onDanmakuClickListener != null) {
            return onDanmakuClickListener.onViewClick(this.danmakuView);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public master.flame.danmaku.danmaku.model.IDanmakus touchHitDanmaku(float f, float f2) {
        master.flame.danmaku.danmaku.model.android.Danmakus danmakus = new master.flame.danmaku.danmaku.model.android.Danmakus();
        this.mDanmakuBounds.setEmpty();
        master.flame.danmaku.danmaku.model.IDanmakus currentVisibleDanmakus = this.danmakuView.getCurrentVisibleDanmakus();
        if (currentVisibleDanmakus != null && !currentVisibleDanmakus.isEmpty()) {
            master.flame.danmaku.danmaku.model.IDanmakuIterator it = currentVisibleDanmakus.iterator();
            while (it.hasNext()) {
                master.flame.danmaku.danmaku.model.BaseDanmaku next = it.next();
                if (next != null) {
                    this.mDanmakuBounds.set(next.getLeft(), next.getTop(), next.getRight(), next.getBottom());
                    if (this.mDanmakuBounds.contains(f, f2)) {
                        danmakus.addItem(next);
                    }
                }
            }
        }
        return danmakus;
    }
}
