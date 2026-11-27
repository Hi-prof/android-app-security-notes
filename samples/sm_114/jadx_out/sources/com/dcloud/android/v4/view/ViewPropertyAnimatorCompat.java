package com.dcloud.android.v4.view;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class ViewPropertyAnimatorCompat {
    static final com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl IMPL = new com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.LollipopViewPropertyAnimatorCompatImpl();
    static final int LISTENER_TAG_ID = 2113929216;
    private static final java.lang.String TAG = "ViewAnimatorCompat";
    private java.lang.ref.WeakReference<android.view.View> mView;
    private java.lang.Runnable mStartAction = null;
    private java.lang.Runnable mEndAction = null;
    private int mOldLayerType = -1;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static class BaseViewPropertyAnimatorCompatImpl implements com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl {
        java.util.WeakHashMap<android.view.View, java.lang.Runnable> mStarterMap = null;

        /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
        class Starter implements java.lang.Runnable {
            java.lang.ref.WeakReference<android.view.View> mViewRef;
            com.dcloud.android.v4.view.ViewPropertyAnimatorCompat mVpa;

            @Override // java.lang.Runnable
            public void run() {
                android.view.View view = this.mViewRef.get();
                if (view != null) {
                    com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl.this.startAnimation(this.mVpa, view);
                }
            }

            private Starter(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view) {
                this.mViewRef = new java.lang.ref.WeakReference<>(view);
                this.mVpa = viewPropertyAnimatorCompat;
            }
        }

        BaseViewPropertyAnimatorCompatImpl() {
        }

        private void postStartMessage(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view) {
            java.util.WeakHashMap<android.view.View, java.lang.Runnable> weakHashMap = this.mStarterMap;
            java.lang.Runnable starter = weakHashMap != null ? weakHashMap.get(view) : null;
            if (starter == null) {
                starter = new com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl.Starter(viewPropertyAnimatorCompat, view);
                if (this.mStarterMap == null) {
                    this.mStarterMap = new java.util.WeakHashMap<>();
                }
                this.mStarterMap.put(view, starter);
            }
            view.removeCallbacks(starter);
            view.post(starter);
        }

        private void removeStartMessage(android.view.View view) {
            java.lang.Runnable runnable;
            java.util.WeakHashMap<android.view.View, java.lang.Runnable> weakHashMap = this.mStarterMap;
            if (weakHashMap == null || (runnable = weakHashMap.get(view)) == null) {
                return;
            }
            view.removeCallbacks(runnable);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void startAnimation(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view) {
            java.lang.Object tag = view.getTag(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.LISTENER_TAG_ID);
            com.dcloud.android.v4.view.ViewPropertyAnimatorListener viewPropertyAnimatorListener = tag instanceof com.dcloud.android.v4.view.ViewPropertyAnimatorListener ? (com.dcloud.android.v4.view.ViewPropertyAnimatorListener) tag : null;
            java.lang.Runnable runnable = viewPropertyAnimatorCompat.mStartAction;
            java.lang.Runnable runnable2 = viewPropertyAnimatorCompat.mEndAction;
            if (runnable != null) {
                runnable.run();
            }
            if (viewPropertyAnimatorListener != null) {
                viewPropertyAnimatorListener.onAnimationStart(view);
                viewPropertyAnimatorListener.onAnimationEnd(view);
            }
            if (runnable2 != null) {
                runnable2.run();
            }
            java.util.WeakHashMap<android.view.View, java.lang.Runnable> weakHashMap = this.mStarterMap;
            if (weakHashMap != null) {
                weakHashMap.remove(view);
            }
        }

        @Override // com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void alpha(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, float f) {
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        @Override // com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void alphaBy(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, float f) {
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        @Override // com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void cancel(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view) {
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        @Override // com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public long getDuration(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view) {
            return 0L;
        }

        @Override // com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public android.view.animation.Interpolator getInterpolator(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view) {
            return null;
        }

        @Override // com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public long getStartDelay(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view) {
            return 0L;
        }

        @Override // com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void rotation(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, float f) {
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        @Override // com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void rotationBy(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, float f) {
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        @Override // com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void rotationX(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, float f) {
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        @Override // com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void rotationXBy(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, float f) {
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        @Override // com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void rotationY(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, float f) {
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        @Override // com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void rotationYBy(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, float f) {
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        @Override // com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void scaleX(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, float f) {
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        @Override // com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void scaleXBy(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, float f) {
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        @Override // com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void scaleY(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, float f) {
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        @Override // com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void scaleYBy(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, float f) {
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        @Override // com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void setDuration(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, long j) {
        }

        @Override // com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void setInterpolator(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, android.view.animation.Interpolator interpolator) {
        }

        @Override // com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void setListener(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, com.dcloud.android.v4.view.ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
            view.setTag(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.LISTENER_TAG_ID, viewPropertyAnimatorListener);
        }

        @Override // com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void setStartDelay(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, long j) {
        }

        @Override // com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void setUpdateListener(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, com.dcloud.android.v4.view.ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener) {
        }

        @Override // com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void start(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view) {
            removeStartMessage(view);
            startAnimation(viewPropertyAnimatorCompat, view);
        }

        @Override // com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void translationX(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, float f) {
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        @Override // com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void translationXBy(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, float f) {
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        @Override // com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void translationY(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, float f) {
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        @Override // com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void translationYBy(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, float f) {
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        @Override // com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void translationZ(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, float f) {
        }

        @Override // com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void translationZBy(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, float f) {
        }

        @Override // com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void withEndAction(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, java.lang.Runnable runnable) {
            viewPropertyAnimatorCompat.mEndAction = runnable;
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        @Override // com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void withLayer(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view) {
        }

        @Override // com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void withStartAction(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, java.lang.Runnable runnable) {
            viewPropertyAnimatorCompat.mStartAction = runnable;
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        @Override // com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void x(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, float f) {
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        @Override // com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void xBy(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, float f) {
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        @Override // com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void y(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, float f) {
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        @Override // com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void yBy(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, float f) {
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        @Override // com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void z(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, float f) {
        }

        @Override // com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void zBy(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, float f) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static class ICSViewPropertyAnimatorCompatImpl extends com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl {
        java.util.WeakHashMap<android.view.View, java.lang.Integer> mLayerMap = null;

        /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
        static class MyVpaListener implements com.dcloud.android.v4.view.ViewPropertyAnimatorListener {
            com.dcloud.android.v4.view.ViewPropertyAnimatorCompat mVpa;

            MyVpaListener(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat) {
                this.mVpa = viewPropertyAnimatorCompat;
            }

            @Override // com.dcloud.android.v4.view.ViewPropertyAnimatorListener
            public void onAnimationCancel(android.view.View view) {
                java.lang.Object tag = view.getTag(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.LISTENER_TAG_ID);
                com.dcloud.android.v4.view.ViewPropertyAnimatorListener viewPropertyAnimatorListener = tag instanceof com.dcloud.android.v4.view.ViewPropertyAnimatorListener ? (com.dcloud.android.v4.view.ViewPropertyAnimatorListener) tag : null;
                if (viewPropertyAnimatorListener != null) {
                    viewPropertyAnimatorListener.onAnimationCancel(view);
                }
            }

            @Override // com.dcloud.android.v4.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(android.view.View view) {
                if (this.mVpa.mOldLayerType >= 0) {
                    com.dcloud.android.v4.view.ViewCompat.setLayerType(view, this.mVpa.mOldLayerType, null);
                    this.mVpa.mOldLayerType = -1;
                }
                if (this.mVpa.mEndAction != null) {
                    this.mVpa.mEndAction.run();
                }
                java.lang.Object tag = view.getTag(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.LISTENER_TAG_ID);
                com.dcloud.android.v4.view.ViewPropertyAnimatorListener viewPropertyAnimatorListener = tag instanceof com.dcloud.android.v4.view.ViewPropertyAnimatorListener ? (com.dcloud.android.v4.view.ViewPropertyAnimatorListener) tag : null;
                if (viewPropertyAnimatorListener != null) {
                    viewPropertyAnimatorListener.onAnimationEnd(view);
                }
            }

            @Override // com.dcloud.android.v4.view.ViewPropertyAnimatorListener
            public void onAnimationStart(android.view.View view) {
                if (this.mVpa.mOldLayerType >= 0) {
                    com.dcloud.android.v4.view.ViewCompat.setLayerType(view, 2, null);
                }
                if (this.mVpa.mStartAction != null) {
                    this.mVpa.mStartAction.run();
                }
                java.lang.Object tag = view.getTag(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.LISTENER_TAG_ID);
                com.dcloud.android.v4.view.ViewPropertyAnimatorListener viewPropertyAnimatorListener = tag instanceof com.dcloud.android.v4.view.ViewPropertyAnimatorListener ? (com.dcloud.android.v4.view.ViewPropertyAnimatorListener) tag : null;
                if (viewPropertyAnimatorListener != null) {
                    viewPropertyAnimatorListener.onAnimationStart(view);
                }
            }
        }

        ICSViewPropertyAnimatorCompatImpl() {
        }

        @Override // com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void alpha(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, float f) {
            com.dcloud.android.v4.view.ViewPropertyAnimatorCompatICS.alpha(view, f);
        }

        @Override // com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void alphaBy(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, float f) {
            com.dcloud.android.v4.view.ViewPropertyAnimatorCompatICS.alphaBy(view, f);
        }

        @Override // com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void cancel(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view) {
            com.dcloud.android.v4.view.ViewPropertyAnimatorCompatICS.cancel(view);
        }

        @Override // com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public long getDuration(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view) {
            return com.dcloud.android.v4.view.ViewPropertyAnimatorCompatICS.getDuration(view);
        }

        @Override // com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public long getStartDelay(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view) {
            return com.dcloud.android.v4.view.ViewPropertyAnimatorCompatICS.getStartDelay(view);
        }

        @Override // com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void rotation(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, float f) {
            com.dcloud.android.v4.view.ViewPropertyAnimatorCompatICS.rotation(view, f);
        }

        @Override // com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void rotationBy(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, float f) {
            com.dcloud.android.v4.view.ViewPropertyAnimatorCompatICS.rotationBy(view, f);
        }

        @Override // com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void rotationX(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, float f) {
            com.dcloud.android.v4.view.ViewPropertyAnimatorCompatICS.rotationX(view, f);
        }

        @Override // com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void rotationXBy(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, float f) {
            com.dcloud.android.v4.view.ViewPropertyAnimatorCompatICS.rotationXBy(view, f);
        }

        @Override // com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void rotationY(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, float f) {
            com.dcloud.android.v4.view.ViewPropertyAnimatorCompatICS.rotationY(view, f);
        }

        @Override // com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void rotationYBy(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, float f) {
            com.dcloud.android.v4.view.ViewPropertyAnimatorCompatICS.rotationYBy(view, f);
        }

        @Override // com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void scaleX(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, float f) {
            com.dcloud.android.v4.view.ViewPropertyAnimatorCompatICS.scaleX(view, f);
        }

        @Override // com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void scaleXBy(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, float f) {
            com.dcloud.android.v4.view.ViewPropertyAnimatorCompatICS.scaleXBy(view, f);
        }

        @Override // com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void scaleY(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, float f) {
            com.dcloud.android.v4.view.ViewPropertyAnimatorCompatICS.scaleY(view, f);
        }

        @Override // com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void scaleYBy(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, float f) {
            com.dcloud.android.v4.view.ViewPropertyAnimatorCompatICS.scaleYBy(view, f);
        }

        @Override // com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void setDuration(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, long j) {
            com.dcloud.android.v4.view.ViewPropertyAnimatorCompatICS.setDuration(view, j);
        }

        @Override // com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void setInterpolator(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, android.view.animation.Interpolator interpolator) {
            com.dcloud.android.v4.view.ViewPropertyAnimatorCompatICS.setInterpolator(view, interpolator);
        }

        @Override // com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void setListener(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, com.dcloud.android.v4.view.ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
            view.setTag(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.LISTENER_TAG_ID, viewPropertyAnimatorListener);
            com.dcloud.android.v4.view.ViewPropertyAnimatorCompatICS.setListener(view, new com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.ICSViewPropertyAnimatorCompatImpl.MyVpaListener(viewPropertyAnimatorCompat));
        }

        @Override // com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void setStartDelay(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, long j) {
            com.dcloud.android.v4.view.ViewPropertyAnimatorCompatICS.setStartDelay(view, j);
        }

        @Override // com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void start(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view) {
            com.dcloud.android.v4.view.ViewPropertyAnimatorCompatICS.start(view);
        }

        @Override // com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void translationX(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, float f) {
            com.dcloud.android.v4.view.ViewPropertyAnimatorCompatICS.translationX(view, f);
        }

        @Override // com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void translationXBy(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, float f) {
            com.dcloud.android.v4.view.ViewPropertyAnimatorCompatICS.translationXBy(view, f);
        }

        @Override // com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void translationY(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, float f) {
            com.dcloud.android.v4.view.ViewPropertyAnimatorCompatICS.translationY(view, f);
        }

        @Override // com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void translationYBy(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, float f) {
            com.dcloud.android.v4.view.ViewPropertyAnimatorCompatICS.translationYBy(view, f);
        }

        @Override // com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void withEndAction(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, java.lang.Runnable runnable) {
            com.dcloud.android.v4.view.ViewPropertyAnimatorCompatICS.setListener(view, new com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.ICSViewPropertyAnimatorCompatImpl.MyVpaListener(viewPropertyAnimatorCompat));
            viewPropertyAnimatorCompat.mEndAction = runnable;
        }

        @Override // com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void withLayer(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view) {
            viewPropertyAnimatorCompat.mOldLayerType = com.dcloud.android.v4.view.ViewCompat.getLayerType(view);
            com.dcloud.android.v4.view.ViewPropertyAnimatorCompatICS.setListener(view, new com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.ICSViewPropertyAnimatorCompatImpl.MyVpaListener(viewPropertyAnimatorCompat));
        }

        @Override // com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void withStartAction(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, java.lang.Runnable runnable) {
            com.dcloud.android.v4.view.ViewPropertyAnimatorCompatICS.setListener(view, new com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.ICSViewPropertyAnimatorCompatImpl.MyVpaListener(viewPropertyAnimatorCompat));
            viewPropertyAnimatorCompat.mStartAction = runnable;
        }

        @Override // com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void x(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, float f) {
            com.dcloud.android.v4.view.ViewPropertyAnimatorCompatICS.x(view, f);
        }

        @Override // com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void xBy(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, float f) {
            com.dcloud.android.v4.view.ViewPropertyAnimatorCompatICS.xBy(view, f);
        }

        @Override // com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void y(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, float f) {
            com.dcloud.android.v4.view.ViewPropertyAnimatorCompatICS.y(view, f);
        }

        @Override // com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void yBy(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, float f) {
            com.dcloud.android.v4.view.ViewPropertyAnimatorCompatICS.yBy(view, f);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static class JBMr2ViewPropertyAnimatorCompatImpl extends com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.JBViewPropertyAnimatorCompatImpl {
        JBMr2ViewPropertyAnimatorCompatImpl() {
        }

        @Override // com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public android.view.animation.Interpolator getInterpolator(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view) {
            return com.dcloud.android.v4.view.ViewPropertyAnimatorCompatJellybeanMr2.getInterpolator(view);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static class JBViewPropertyAnimatorCompatImpl extends com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.ICSViewPropertyAnimatorCompatImpl {
        JBViewPropertyAnimatorCompatImpl() {
        }

        @Override // com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.ICSViewPropertyAnimatorCompatImpl, com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void setListener(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, com.dcloud.android.v4.view.ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
            com.dcloud.android.v4.view.ViewPropertyAnimatorCompatJB.setListener(view, viewPropertyAnimatorListener);
        }

        @Override // com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.ICSViewPropertyAnimatorCompatImpl, com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void withEndAction(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, java.lang.Runnable runnable) {
            com.dcloud.android.v4.view.ViewPropertyAnimatorCompatJB.withEndAction(view, runnable);
        }

        @Override // com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.ICSViewPropertyAnimatorCompatImpl, com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void withLayer(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view) {
            com.dcloud.android.v4.view.ViewPropertyAnimatorCompatJB.withLayer(view);
        }

        @Override // com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.ICSViewPropertyAnimatorCompatImpl, com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void withStartAction(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, java.lang.Runnable runnable) {
            com.dcloud.android.v4.view.ViewPropertyAnimatorCompatJB.withStartAction(view, runnable);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static class KitKatViewPropertyAnimatorCompatImpl extends com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.JBMr2ViewPropertyAnimatorCompatImpl {
        KitKatViewPropertyAnimatorCompatImpl() {
        }

        @Override // com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void setUpdateListener(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, com.dcloud.android.v4.view.ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener) {
            com.dcloud.android.v4.view.ViewPropertyAnimatorCompatKK.setUpdateListener(view, viewPropertyAnimatorUpdateListener);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static class LollipopViewPropertyAnimatorCompatImpl extends com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.KitKatViewPropertyAnimatorCompatImpl {
        LollipopViewPropertyAnimatorCompatImpl() {
        }

        @Override // com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void translationZ(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, float f) {
            com.dcloud.android.v4.view.ViewPropertyAnimatorCompatLollipop.translationZ(view, f);
        }

        @Override // com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void translationZBy(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, float f) {
            com.dcloud.android.v4.view.ViewPropertyAnimatorCompatLollipop.translationZBy(view, f);
        }

        @Override // com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void z(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, float f) {
            com.dcloud.android.v4.view.ViewPropertyAnimatorCompatLollipop.z(view, f);
        }

        @Override // com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, com.dcloud.android.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void zBy(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, float f) {
            com.dcloud.android.v4.view.ViewPropertyAnimatorCompatLollipop.zBy(view, f);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    interface ViewPropertyAnimatorCompatImpl {
        void alpha(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, float f);

        void alphaBy(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, float f);

        void cancel(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view);

        long getDuration(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view);

        android.view.animation.Interpolator getInterpolator(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view);

        long getStartDelay(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view);

        void rotation(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, float f);

        void rotationBy(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, float f);

        void rotationX(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, float f);

        void rotationXBy(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, float f);

        void rotationY(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, float f);

        void rotationYBy(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, float f);

        void scaleX(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, float f);

        void scaleXBy(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, float f);

        void scaleY(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, float f);

        void scaleYBy(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, float f);

        void setDuration(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, long j);

        void setInterpolator(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, android.view.animation.Interpolator interpolator);

        void setListener(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, com.dcloud.android.v4.view.ViewPropertyAnimatorListener viewPropertyAnimatorListener);

        void setStartDelay(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, long j);

        void setUpdateListener(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, com.dcloud.android.v4.view.ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener);

        void start(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view);

        void translationX(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, float f);

        void translationXBy(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, float f);

        void translationY(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, float f);

        void translationYBy(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, float f);

        void translationZ(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, float f);

        void translationZBy(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, float f);

        void withEndAction(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, java.lang.Runnable runnable);

        void withLayer(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view);

        void withStartAction(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, java.lang.Runnable runnable);

        void x(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, float f);

        void xBy(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, float f);

        void y(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, float f);

        void yBy(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, float f);

        void z(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, float f);

        void zBy(com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.view.View view, float f);
    }

    ViewPropertyAnimatorCompat(android.view.View view) {
        this.mView = new java.lang.ref.WeakReference<>(view);
    }

    public com.dcloud.android.v4.view.ViewPropertyAnimatorCompat alpha(float f) {
        android.view.View view = this.mView.get();
        if (view != null) {
            IMPL.alpha(this, view, f);
        }
        return this;
    }

    public com.dcloud.android.v4.view.ViewPropertyAnimatorCompat alphaBy(float f) {
        android.view.View view = this.mView.get();
        if (view != null) {
            IMPL.alphaBy(this, view, f);
        }
        return this;
    }

    public void cancel() {
        android.view.View view = this.mView.get();
        if (view != null) {
            IMPL.cancel(this, view);
        }
    }

    public long getDuration() {
        android.view.View view = this.mView.get();
        if (view != null) {
            return IMPL.getDuration(this, view);
        }
        return 0L;
    }

    public android.view.animation.Interpolator getInterpolator() {
        android.view.View view = this.mView.get();
        if (view != null) {
            return IMPL.getInterpolator(this, view);
        }
        return null;
    }

    public long getStartDelay() {
        android.view.View view = this.mView.get();
        if (view != null) {
            return IMPL.getStartDelay(this, view);
        }
        return 0L;
    }

    public com.dcloud.android.v4.view.ViewPropertyAnimatorCompat rotation(float f) {
        android.view.View view = this.mView.get();
        if (view != null) {
            IMPL.rotation(this, view, f);
        }
        return this;
    }

    public com.dcloud.android.v4.view.ViewPropertyAnimatorCompat rotationBy(float f) {
        android.view.View view = this.mView.get();
        if (view != null) {
            IMPL.rotationBy(this, view, f);
        }
        return this;
    }

    public com.dcloud.android.v4.view.ViewPropertyAnimatorCompat rotationX(float f) {
        android.view.View view = this.mView.get();
        if (view != null) {
            IMPL.rotationX(this, view, f);
        }
        return this;
    }

    public com.dcloud.android.v4.view.ViewPropertyAnimatorCompat rotationXBy(float f) {
        android.view.View view = this.mView.get();
        if (view != null) {
            IMPL.rotationXBy(this, view, f);
        }
        return this;
    }

    public com.dcloud.android.v4.view.ViewPropertyAnimatorCompat rotationY(float f) {
        android.view.View view = this.mView.get();
        if (view != null) {
            IMPL.rotationY(this, view, f);
        }
        return this;
    }

    public com.dcloud.android.v4.view.ViewPropertyAnimatorCompat rotationYBy(float f) {
        android.view.View view = this.mView.get();
        if (view != null) {
            IMPL.rotationYBy(this, view, f);
        }
        return this;
    }

    public com.dcloud.android.v4.view.ViewPropertyAnimatorCompat scaleX(float f) {
        android.view.View view = this.mView.get();
        if (view != null) {
            IMPL.scaleX(this, view, f);
        }
        return this;
    }

    public com.dcloud.android.v4.view.ViewPropertyAnimatorCompat scaleXBy(float f) {
        android.view.View view = this.mView.get();
        if (view != null) {
            IMPL.scaleXBy(this, view, f);
        }
        return this;
    }

    public com.dcloud.android.v4.view.ViewPropertyAnimatorCompat scaleY(float f) {
        android.view.View view = this.mView.get();
        if (view != null) {
            IMPL.scaleY(this, view, f);
        }
        return this;
    }

    public com.dcloud.android.v4.view.ViewPropertyAnimatorCompat scaleYBy(float f) {
        android.view.View view = this.mView.get();
        if (view != null) {
            IMPL.scaleYBy(this, view, f);
        }
        return this;
    }

    public com.dcloud.android.v4.view.ViewPropertyAnimatorCompat setDuration(long j) {
        android.view.View view = this.mView.get();
        if (view != null) {
            IMPL.setDuration(this, view, j);
        }
        return this;
    }

    public com.dcloud.android.v4.view.ViewPropertyAnimatorCompat setInterpolator(android.view.animation.Interpolator interpolator) {
        android.view.View view = this.mView.get();
        if (view != null) {
            IMPL.setInterpolator(this, view, interpolator);
        }
        return this;
    }

    public com.dcloud.android.v4.view.ViewPropertyAnimatorCompat setListener(com.dcloud.android.v4.view.ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        android.view.View view = this.mView.get();
        if (view != null) {
            IMPL.setListener(this, view, viewPropertyAnimatorListener);
        }
        return this;
    }

    public com.dcloud.android.v4.view.ViewPropertyAnimatorCompat setStartDelay(long j) {
        android.view.View view = this.mView.get();
        if (view != null) {
            IMPL.setStartDelay(this, view, j);
        }
        return this;
    }

    public com.dcloud.android.v4.view.ViewPropertyAnimatorCompat setUpdateListener(com.dcloud.android.v4.view.ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener) {
        android.view.View view = this.mView.get();
        if (view != null) {
            IMPL.setUpdateListener(this, view, viewPropertyAnimatorUpdateListener);
        }
        return this;
    }

    public void start() {
        android.view.View view = this.mView.get();
        if (view != null) {
            IMPL.start(this, view);
        }
    }

    public com.dcloud.android.v4.view.ViewPropertyAnimatorCompat translationX(float f) {
        android.view.View view = this.mView.get();
        if (view != null) {
            IMPL.translationX(this, view, f);
        }
        return this;
    }

    public com.dcloud.android.v4.view.ViewPropertyAnimatorCompat translationXBy(float f) {
        android.view.View view = this.mView.get();
        if (view != null) {
            IMPL.translationXBy(this, view, f);
        }
        return this;
    }

    public com.dcloud.android.v4.view.ViewPropertyAnimatorCompat translationY(float f) {
        android.view.View view = this.mView.get();
        if (view != null) {
            IMPL.translationY(this, view, f);
        }
        return this;
    }

    public com.dcloud.android.v4.view.ViewPropertyAnimatorCompat translationYBy(float f) {
        android.view.View view = this.mView.get();
        if (view != null) {
            IMPL.translationYBy(this, view, f);
        }
        return this;
    }

    public com.dcloud.android.v4.view.ViewPropertyAnimatorCompat translationZ(float f) {
        android.view.View view = this.mView.get();
        if (view != null) {
            IMPL.translationZ(this, view, f);
        }
        return this;
    }

    public com.dcloud.android.v4.view.ViewPropertyAnimatorCompat translationZBy(float f) {
        android.view.View view = this.mView.get();
        if (view != null) {
            IMPL.translationZBy(this, view, f);
        }
        return this;
    }

    public com.dcloud.android.v4.view.ViewPropertyAnimatorCompat withEndAction(java.lang.Runnable runnable) {
        android.view.View view = this.mView.get();
        if (view != null) {
            IMPL.withEndAction(this, view, runnable);
        }
        return this;
    }

    public com.dcloud.android.v4.view.ViewPropertyAnimatorCompat withLayer() {
        android.view.View view = this.mView.get();
        if (view != null) {
            IMPL.withLayer(this, view);
        }
        return this;
    }

    public com.dcloud.android.v4.view.ViewPropertyAnimatorCompat withStartAction(java.lang.Runnable runnable) {
        android.view.View view = this.mView.get();
        if (view != null) {
            IMPL.withStartAction(this, view, runnable);
        }
        return this;
    }

    public com.dcloud.android.v4.view.ViewPropertyAnimatorCompat x(float f) {
        android.view.View view = this.mView.get();
        if (view != null) {
            IMPL.x(this, view, f);
        }
        return this;
    }

    public com.dcloud.android.v4.view.ViewPropertyAnimatorCompat xBy(float f) {
        android.view.View view = this.mView.get();
        if (view != null) {
            IMPL.xBy(this, view, f);
        }
        return this;
    }

    public com.dcloud.android.v4.view.ViewPropertyAnimatorCompat y(float f) {
        android.view.View view = this.mView.get();
        if (view != null) {
            IMPL.y(this, view, f);
        }
        return this;
    }

    public com.dcloud.android.v4.view.ViewPropertyAnimatorCompat yBy(float f) {
        android.view.View view = this.mView.get();
        if (view != null) {
            IMPL.yBy(this, view, f);
        }
        return this;
    }

    public com.dcloud.android.v4.view.ViewPropertyAnimatorCompat z(float f) {
        android.view.View view = this.mView.get();
        if (view != null) {
            IMPL.z(this, view, f);
        }
        return this;
    }

    public com.dcloud.android.v4.view.ViewPropertyAnimatorCompat zBy(float f) {
        android.view.View view = this.mView.get();
        if (view != null) {
            IMPL.zBy(this, view, f);
        }
        return this;
    }
}
