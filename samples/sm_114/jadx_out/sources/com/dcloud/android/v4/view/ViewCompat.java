package com.dcloud.android.v4.view;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class ViewCompat {
    public static final int ACCESSIBILITY_LIVE_REGION_ASSERTIVE = 2;
    public static final int ACCESSIBILITY_LIVE_REGION_NONE = 0;
    public static final int ACCESSIBILITY_LIVE_REGION_POLITE = 1;
    private static final long FAKE_FRAME_TIME = 10;
    static final com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl IMPL = new com.dcloud.android.v4.view.ViewCompat.LollipopViewCompatImpl();
    public static final int IMPORTANT_FOR_ACCESSIBILITY_AUTO = 0;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_NO = 2;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_NO_HIDE_DESCENDANTS = 4;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_YES = 1;
    public static final int LAYER_TYPE_HARDWARE = 2;
    public static final int LAYER_TYPE_NONE = 0;
    public static final int LAYER_TYPE_SOFTWARE = 1;
    public static final int LAYOUT_DIRECTION_INHERIT = 2;
    public static final int LAYOUT_DIRECTION_LOCALE = 3;
    public static final int LAYOUT_DIRECTION_LTR = 0;
    public static final int LAYOUT_DIRECTION_RTL = 1;
    public static final int MEASURED_HEIGHT_STATE_SHIFT = 16;
    public static final int MEASURED_SIZE_MASK = 16777215;
    public static final int MEASURED_STATE_MASK = -16777216;
    public static final int MEASURED_STATE_TOO_SMALL = 16777216;
    public static final int OVER_SCROLL_ALWAYS = 0;
    public static final int OVER_SCROLL_IF_CONTENT_SCROLLS = 1;
    public static final int OVER_SCROLL_NEVER = 2;
    public static final int SCROLL_AXIS_HORIZONTAL = 1;
    public static final int SCROLL_AXIS_NONE = 0;
    public static final int SCROLL_AXIS_VERTICAL = 2;
    private static final java.lang.String TAG = "ViewCompat";

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    private @interface AccessibilityLiveRegion {
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static class BaseViewCompatImpl implements com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl {
        private java.lang.reflect.Method mDispatchFinishTemporaryDetach;
        private java.lang.reflect.Method mDispatchStartTemporaryDetach;
        private boolean mTempDetachBound;
        java.util.WeakHashMap<android.view.View, com.dcloud.android.v4.view.ViewPropertyAnimatorCompat> mViewPropertyAnimatorCompatMap = null;

        BaseViewCompatImpl() {
        }

        private void bindTempDetach() {
            try {
                this.mDispatchStartTemporaryDetach = android.view.View.class.getDeclaredMethod("dispatchStartTemporaryDetach", null);
                this.mDispatchFinishTemporaryDetach = android.view.View.class.getDeclaredMethod("dispatchFinishTemporaryDetach", null);
            } catch (java.lang.NoSuchMethodException e) {
                android.util.Log.e("ViewCompat", "Couldn't find method", e);
            }
            this.mTempDetachBound = true;
        }

        private boolean canScrollingViewScrollHorizontally(com.dcloud.android.v4.view.ScrollingView scrollingView, int i) {
            int iComputeHorizontalScrollOffset = scrollingView.computeHorizontalScrollOffset();
            int iComputeHorizontalScrollRange = scrollingView.computeHorizontalScrollRange() - scrollingView.computeHorizontalScrollExtent();
            if (iComputeHorizontalScrollRange == 0) {
                return false;
            }
            if (i < 0) {
                return iComputeHorizontalScrollOffset > 0;
            }
            return iComputeHorizontalScrollOffset < iComputeHorizontalScrollRange - 1;
        }

        private boolean canScrollingViewScrollVertically(com.dcloud.android.v4.view.ScrollingView scrollingView, int i) {
            int iComputeVerticalScrollOffset = scrollingView.computeVerticalScrollOffset();
            int iComputeVerticalScrollRange = scrollingView.computeVerticalScrollRange() - scrollingView.computeVerticalScrollExtent();
            if (iComputeVerticalScrollRange == 0) {
                return false;
            }
            if (i < 0) {
                return iComputeVerticalScrollOffset > 0;
            }
            return iComputeVerticalScrollOffset < iComputeVerticalScrollRange - 1;
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public com.dcloud.android.v4.view.ViewPropertyAnimatorCompat animate(android.view.View view) {
            return new com.dcloud.android.v4.view.ViewPropertyAnimatorCompat(view);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public boolean canScrollHorizontally(android.view.View view, int i) {
            return (view instanceof com.dcloud.android.v4.view.ScrollingView) && canScrollingViewScrollHorizontally((com.dcloud.android.v4.view.ScrollingView) view, i);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public boolean canScrollVertically(android.view.View view, int i) {
            return (view instanceof com.dcloud.android.v4.view.ScrollingView) && canScrollingViewScrollVertically((com.dcloud.android.v4.view.ScrollingView) view, i);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public int combineMeasuredStates(int i, int i2) {
            return i | i2;
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public com.dcloud.android.v4.view.WindowInsetsCompat dispatchApplyWindowInsets(android.view.View view, com.dcloud.android.v4.view.WindowInsetsCompat windowInsetsCompat) {
            return windowInsetsCompat;
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void dispatchFinishTemporaryDetach(android.view.View view) {
            if (!this.mTempDetachBound) {
                bindTempDetach();
            }
            java.lang.reflect.Method method = this.mDispatchFinishTemporaryDetach;
            if (method == null) {
                view.onFinishTemporaryDetach();
                return;
            }
            try {
                method.invoke(view, null);
            } catch (java.lang.Exception e) {
                android.util.Log.d("ViewCompat", "Error calling dispatchFinishTemporaryDetach", e);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public boolean dispatchNestedFling(android.view.View view, float f, float f2, boolean z) {
            if (view instanceof com.dcloud.android.v4.view.NestedScrollingChild) {
                return ((com.dcloud.android.v4.view.NestedScrollingChild) view).dispatchNestedFling(f, f2, z);
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public boolean dispatchNestedPreFling(android.view.View view, float f, float f2) {
            if (view instanceof com.dcloud.android.v4.view.NestedScrollingChild) {
                return ((com.dcloud.android.v4.view.NestedScrollingChild) view).dispatchNestedPreFling(f, f2);
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public boolean dispatchNestedPreScroll(android.view.View view, int i, int i2, int[] iArr, int[] iArr2) {
            if (view instanceof com.dcloud.android.v4.view.NestedScrollingChild) {
                return ((com.dcloud.android.v4.view.NestedScrollingChild) view).dispatchNestedPreScroll(i, i2, iArr, iArr2);
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public boolean dispatchNestedScroll(android.view.View view, int i, int i2, int i3, int i4, int[] iArr) {
            if (view instanceof com.dcloud.android.v4.view.NestedScrollingChild) {
                return ((com.dcloud.android.v4.view.NestedScrollingChild) view).dispatchNestedScroll(i, i2, i3, i4, iArr);
            }
            return false;
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void dispatchStartTemporaryDetach(android.view.View view) {
            if (!this.mTempDetachBound) {
                bindTempDetach();
            }
            java.lang.reflect.Method method = this.mDispatchStartTemporaryDetach;
            if (method == null) {
                view.onStartTemporaryDetach();
                return;
            }
            try {
                method.invoke(view, null);
            } catch (java.lang.Exception e) {
                android.util.Log.d("ViewCompat", "Error calling dispatchStartTemporaryDetach", e);
            }
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public int getAccessibilityLiveRegion(android.view.View view) {
            return 0;
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public com.dcloud.android.v4.view.accessibility.AccessibilityNodeProviderCompat getAccessibilityNodeProvider(android.view.View view) {
            return null;
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public float getAlpha(android.view.View view) {
            return 1.0f;
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public android.content.res.ColorStateList getBackgroundTintList(android.view.View view) {
            return com.dcloud.android.v4.view.ViewCompatBase.getBackgroundTintList(view);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public android.graphics.PorterDuff.Mode getBackgroundTintMode(android.view.View view) {
            return com.dcloud.android.v4.view.ViewCompatBase.getBackgroundTintMode(view);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public android.graphics.Rect getClipBounds(android.view.View view) {
            return null;
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public float getElevation(android.view.View view) {
            return 0.0f;
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public boolean getFitsSystemWindows(android.view.View view) {
            return false;
        }

        long getFrameTime() {
            return com.dcloud.android.v4.view.ViewCompat.FAKE_FRAME_TIME;
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public int getImportantForAccessibility(android.view.View view) {
            return 0;
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public int getLabelFor(android.view.View view) {
            return 0;
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public int getLayerType(android.view.View view) {
            return 0;
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public int getLayoutDirection(android.view.View view) {
            return 0;
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public int getMeasuredHeightAndState(android.view.View view) {
            return view.getMeasuredHeight();
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public int getMeasuredState(android.view.View view) {
            return 0;
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public int getMeasuredWidthAndState(android.view.View view) {
            return view.getMeasuredWidth();
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public int getMinimumHeight(android.view.View view) {
            return com.dcloud.android.v4.view.ViewCompatBase.getMinimumHeight(view);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public int getMinimumWidth(android.view.View view) {
            return com.dcloud.android.v4.view.ViewCompatBase.getMinimumWidth(view);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public int getOverScrollMode(android.view.View view) {
            return 2;
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public int getPaddingEnd(android.view.View view) {
            return view.getPaddingRight();
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public int getPaddingStart(android.view.View view) {
            return view.getPaddingLeft();
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public android.view.ViewParent getParentForAccessibility(android.view.View view) {
            return view.getParent();
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public float getPivotX(android.view.View view) {
            return 0.0f;
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public float getPivotY(android.view.View view) {
            return 0.0f;
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public float getRotation(android.view.View view) {
            return 0.0f;
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public float getRotationX(android.view.View view) {
            return 0.0f;
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public float getRotationY(android.view.View view) {
            return 0.0f;
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public float getScaleX(android.view.View view) {
            return 0.0f;
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public float getScaleY(android.view.View view) {
            return 0.0f;
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public java.lang.String getTransitionName(android.view.View view) {
            return null;
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public float getTranslationX(android.view.View view) {
            return 0.0f;
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public float getTranslationY(android.view.View view) {
            return 0.0f;
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public float getTranslationZ(android.view.View view) {
            return 0.0f;
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public int getWindowSystemUiVisibility(android.view.View view) {
            return 0;
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public float getX(android.view.View view) {
            return 0.0f;
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public float getY(android.view.View view) {
            return 0.0f;
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public float getZ(android.view.View view) {
            return getTranslationZ(view) + getElevation(view);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public boolean hasAccessibilityDelegate(android.view.View view) {
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public boolean hasNestedScrollingParent(android.view.View view) {
            if (view instanceof com.dcloud.android.v4.view.NestedScrollingChild) {
                return ((com.dcloud.android.v4.view.NestedScrollingChild) view).hasNestedScrollingParent();
            }
            return false;
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public boolean hasOverlappingRendering(android.view.View view) {
            return true;
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public boolean hasTransientState(android.view.View view) {
            return false;
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public boolean isAttachedToWindow(android.view.View view) {
            return com.dcloud.android.v4.view.ViewCompatBase.isAttachedToWindow(view);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public boolean isImportantForAccessibility(android.view.View view) {
            return true;
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public boolean isLaidOut(android.view.View view) {
            return com.dcloud.android.v4.view.ViewCompatBase.isLaidOut(view);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public boolean isNestedScrollingEnabled(android.view.View view) {
            if (view instanceof com.dcloud.android.v4.view.NestedScrollingChild) {
                return ((com.dcloud.android.v4.view.NestedScrollingChild) view).isNestedScrollingEnabled();
            }
            return false;
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public boolean isOpaque(android.view.View view) {
            android.graphics.drawable.Drawable background = view.getBackground();
            return background != null && background.getOpacity() == -1;
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public boolean isPaddingRelative(android.view.View view) {
            return false;
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void jumpDrawablesToCurrentState(android.view.View view) {
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public com.dcloud.android.v4.view.WindowInsetsCompat onApplyWindowInsets(android.view.View view, com.dcloud.android.v4.view.WindowInsetsCompat windowInsetsCompat) {
            return windowInsetsCompat;
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void onInitializeAccessibilityEvent(android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void onInitializeAccessibilityNodeInfo(android.view.View view, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void onPopulateAccessibilityEvent(android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public boolean performAccessibilityAction(android.view.View view, int i, android.os.Bundle bundle) {
            return false;
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void postInvalidateOnAnimation(android.view.View view) {
            view.invalidate();
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void postOnAnimation(android.view.View view, java.lang.Runnable runnable) {
            view.postDelayed(runnable, getFrameTime());
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void postOnAnimationDelayed(android.view.View view, java.lang.Runnable runnable, long j) {
            view.postDelayed(runnable, getFrameTime() + j);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void requestApplyInsets(android.view.View view) {
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public int resolveSizeAndState(int i, int i2, int i3) {
            return android.view.View.resolveSize(i, i2);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void setAccessibilityDelegate(android.view.View view, com.dcloud.android.v4.view.AccessibilityDelegateCompat accessibilityDelegateCompat) {
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void setAccessibilityLiveRegion(android.view.View view, int i) {
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void setActivated(android.view.View view, boolean z) {
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void setAlpha(android.view.View view, float f) {
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void setBackgroundTintList(android.view.View view, android.content.res.ColorStateList colorStateList) {
            com.dcloud.android.v4.view.ViewCompatBase.setBackgroundTintList(view, colorStateList);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void setBackgroundTintMode(android.view.View view, android.graphics.PorterDuff.Mode mode) {
            com.dcloud.android.v4.view.ViewCompatBase.setBackgroundTintMode(view, mode);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void setChildrenDrawingOrderEnabled(android.view.ViewGroup viewGroup, boolean z) {
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void setClipBounds(android.view.View view, android.graphics.Rect rect) {
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void setElevation(android.view.View view, float f) {
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void setFitsSystemWindows(android.view.View view, boolean z) {
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void setHasTransientState(android.view.View view, boolean z) {
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void setImportantForAccessibility(android.view.View view, int i) {
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void setLabelFor(android.view.View view, int i) {
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void setLayerPaint(android.view.View view, android.graphics.Paint paint) {
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void setLayerType(android.view.View view, int i, android.graphics.Paint paint) {
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void setLayoutDirection(android.view.View view, int i) {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void setNestedScrollingEnabled(android.view.View view, boolean z) {
            if (view instanceof com.dcloud.android.v4.view.NestedScrollingChild) {
                ((com.dcloud.android.v4.view.NestedScrollingChild) view).setNestedScrollingEnabled(z);
            }
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void setOnApplyWindowInsetsListener(android.view.View view, com.dcloud.android.v4.view.OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void setOverScrollMode(android.view.View view, int i) {
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void setPaddingRelative(android.view.View view, int i, int i2, int i3, int i4) {
            view.setPadding(i, i2, i3, i4);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void setPivotX(android.view.View view, float f) {
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void setPivotY(android.view.View view, float f) {
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void setRotation(android.view.View view, float f) {
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void setRotationX(android.view.View view, float f) {
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void setRotationY(android.view.View view, float f) {
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void setSaveFromParentEnabled(android.view.View view, boolean z) {
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void setScaleX(android.view.View view, float f) {
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void setScaleY(android.view.View view, float f) {
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void setTransitionName(android.view.View view, java.lang.String str) {
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void setTranslationX(android.view.View view, float f) {
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void setTranslationY(android.view.View view, float f) {
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void setTranslationZ(android.view.View view, float f) {
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void setX(android.view.View view, float f) {
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void setY(android.view.View view, float f) {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public boolean startNestedScroll(android.view.View view, int i) {
            if (view instanceof com.dcloud.android.v4.view.NestedScrollingChild) {
                return ((com.dcloud.android.v4.view.NestedScrollingChild) view).startNestedScroll(i);
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void stopNestedScroll(android.view.View view) {
            if (view instanceof com.dcloud.android.v4.view.NestedScrollingChild) {
                ((com.dcloud.android.v4.view.NestedScrollingChild) view).stopNestedScroll();
            }
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void postInvalidateOnAnimation(android.view.View view, int i, int i2, int i3, int i4) {
            view.invalidate(i, i2, i3, i4);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static class EclairMr1ViewCompatImpl extends com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl {
        EclairMr1ViewCompatImpl() {
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public boolean isOpaque(android.view.View view) {
            return com.dcloud.android.v4.view.ViewCompatEclairMr1.isOpaque(view);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void setChildrenDrawingOrderEnabled(android.view.ViewGroup viewGroup, boolean z) {
            com.dcloud.android.v4.view.ViewCompatEclairMr1.setChildrenDrawingOrderEnabled(viewGroup, z);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static class GBViewCompatImpl extends com.dcloud.android.v4.view.ViewCompat.EclairMr1ViewCompatImpl {
        GBViewCompatImpl() {
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public int getOverScrollMode(android.view.View view) {
            return com.dcloud.android.v4.view.ViewCompatGingerbread.getOverScrollMode(view);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void setOverScrollMode(android.view.View view, int i) {
            com.dcloud.android.v4.view.ViewCompatGingerbread.setOverScrollMode(view, i);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static class HCViewCompatImpl extends com.dcloud.android.v4.view.ViewCompat.GBViewCompatImpl {
        HCViewCompatImpl() {
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public int combineMeasuredStates(int i, int i2) {
            return com.dcloud.android.v4.view.ViewCompatHC.combineMeasuredStates(i, i2);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public float getAlpha(android.view.View view) {
            return com.dcloud.android.v4.view.ViewCompatHC.getAlpha(view);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl
        long getFrameTime() {
            return com.dcloud.android.v4.view.ViewCompatHC.getFrameTime();
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public int getLayerType(android.view.View view) {
            return com.dcloud.android.v4.view.ViewCompatHC.getLayerType(view);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public int getMeasuredHeightAndState(android.view.View view) {
            return com.dcloud.android.v4.view.ViewCompatHC.getMeasuredHeightAndState(view);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public int getMeasuredState(android.view.View view) {
            return com.dcloud.android.v4.view.ViewCompatHC.getMeasuredState(view);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public int getMeasuredWidthAndState(android.view.View view) {
            return com.dcloud.android.v4.view.ViewCompatHC.getMeasuredWidthAndState(view);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public float getPivotX(android.view.View view) {
            return com.dcloud.android.v4.view.ViewCompatHC.getPivotX(view);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public float getPivotY(android.view.View view) {
            return com.dcloud.android.v4.view.ViewCompatHC.getPivotY(view);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public float getRotation(android.view.View view) {
            return com.dcloud.android.v4.view.ViewCompatHC.getRotation(view);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public float getRotationX(android.view.View view) {
            return com.dcloud.android.v4.view.ViewCompatHC.getRotationX(view);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public float getRotationY(android.view.View view) {
            return com.dcloud.android.v4.view.ViewCompatHC.getRotationY(view);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public float getScaleX(android.view.View view) {
            return com.dcloud.android.v4.view.ViewCompatHC.getScaleX(view);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public float getScaleY(android.view.View view) {
            return com.dcloud.android.v4.view.ViewCompatHC.getScaleY(view);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public float getTranslationX(android.view.View view) {
            return com.dcloud.android.v4.view.ViewCompatHC.getTranslationX(view);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public float getTranslationY(android.view.View view) {
            return com.dcloud.android.v4.view.ViewCompatHC.getTranslationY(view);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public float getX(android.view.View view) {
            return com.dcloud.android.v4.view.ViewCompatHC.getX(view);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public float getY(android.view.View view) {
            return com.dcloud.android.v4.view.ViewCompatHC.getY(view);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void jumpDrawablesToCurrentState(android.view.View view) {
            com.dcloud.android.v4.view.ViewCompatHC.jumpDrawablesToCurrentState(view);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public int resolveSizeAndState(int i, int i2, int i3) {
            return com.dcloud.android.v4.view.ViewCompatHC.resolveSizeAndState(i, i2, i3);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void setActivated(android.view.View view, boolean z) {
            com.dcloud.android.v4.view.ViewCompatHC.setActivated(view, z);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void setAlpha(android.view.View view, float f) {
            com.dcloud.android.v4.view.ViewCompatHC.setAlpha(view, f);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void setLayerPaint(android.view.View view, android.graphics.Paint paint) {
            setLayerType(view, getLayerType(view), paint);
            view.invalidate();
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void setLayerType(android.view.View view, int i, android.graphics.Paint paint) {
            com.dcloud.android.v4.view.ViewCompatHC.setLayerType(view, i, paint);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void setPivotX(android.view.View view, float f) {
            com.dcloud.android.v4.view.ViewCompatHC.setPivotX(view, f);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void setPivotY(android.view.View view, float f) {
            com.dcloud.android.v4.view.ViewCompatHC.setPivotY(view, f);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void setRotation(android.view.View view, float f) {
            com.dcloud.android.v4.view.ViewCompatHC.setRotation(view, f);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void setRotationX(android.view.View view, float f) {
            com.dcloud.android.v4.view.ViewCompatHC.setRotationX(view, f);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void setRotationY(android.view.View view, float f) {
            com.dcloud.android.v4.view.ViewCompatHC.setRotationY(view, f);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void setSaveFromParentEnabled(android.view.View view, boolean z) {
            com.dcloud.android.v4.view.ViewCompatHC.setSaveFromParentEnabled(view, z);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void setScaleX(android.view.View view, float f) {
            com.dcloud.android.v4.view.ViewCompatHC.setScaleX(view, f);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void setScaleY(android.view.View view, float f) {
            com.dcloud.android.v4.view.ViewCompatHC.setScaleY(view, f);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void setTranslationX(android.view.View view, float f) {
            com.dcloud.android.v4.view.ViewCompatHC.setTranslationX(view, f);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void setTranslationY(android.view.View view, float f) {
            com.dcloud.android.v4.view.ViewCompatHC.setTranslationY(view, f);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void setX(android.view.View view, float f) {
            com.dcloud.android.v4.view.ViewCompatHC.setX(view, f);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void setY(android.view.View view, float f) {
            com.dcloud.android.v4.view.ViewCompatHC.setY(view, f);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static class ICSViewCompatImpl extends com.dcloud.android.v4.view.ViewCompat.HCViewCompatImpl {
        static boolean accessibilityDelegateCheckFailed = false;
        static java.lang.reflect.Field mAccessibilityDelegateField;

        ICSViewCompatImpl() {
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public com.dcloud.android.v4.view.ViewPropertyAnimatorCompat animate(android.view.View view) {
            if (this.mViewPropertyAnimatorCompatMap == null) {
                this.mViewPropertyAnimatorCompatMap = new java.util.WeakHashMap<>();
            }
            com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.mViewPropertyAnimatorCompatMap.get(view);
            if (viewPropertyAnimatorCompat != null) {
                return viewPropertyAnimatorCompat;
            }
            com.dcloud.android.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = new com.dcloud.android.v4.view.ViewPropertyAnimatorCompat(view);
            this.mViewPropertyAnimatorCompatMap.put(view, viewPropertyAnimatorCompat2);
            return viewPropertyAnimatorCompat2;
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public boolean canScrollHorizontally(android.view.View view, int i) {
            return com.dcloud.android.v4.view.ViewCompatICS.canScrollHorizontally(view, i);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public boolean canScrollVertically(android.view.View view, int i) {
            return com.dcloud.android.v4.view.ViewCompatICS.canScrollVertically(view, i);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public boolean hasAccessibilityDelegate(android.view.View view) {
            if (accessibilityDelegateCheckFailed) {
                return false;
            }
            if (mAccessibilityDelegateField == null) {
                try {
                    java.lang.reflect.Field declaredField = android.view.View.class.getDeclaredField("mAccessibilityDelegate");
                    mAccessibilityDelegateField = declaredField;
                    declaredField.setAccessible(true);
                } catch (java.lang.Throwable unused) {
                    accessibilityDelegateCheckFailed = true;
                    return false;
                }
            }
            try {
                return mAccessibilityDelegateField.get(view) != null;
            } catch (java.lang.Throwable unused2) {
                accessibilityDelegateCheckFailed = true;
                return false;
            }
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void onInitializeAccessibilityEvent(android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
            com.dcloud.android.v4.view.ViewCompatICS.onInitializeAccessibilityEvent(view, accessibilityEvent);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void onInitializeAccessibilityNodeInfo(android.view.View view, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            com.dcloud.android.v4.view.ViewCompatICS.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat.getInfo());
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void onPopulateAccessibilityEvent(android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
            com.dcloud.android.v4.view.ViewCompatICS.onPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void setAccessibilityDelegate(android.view.View view, com.dcloud.android.v4.view.AccessibilityDelegateCompat accessibilityDelegateCompat) {
            com.dcloud.android.v4.view.ViewCompatICS.setAccessibilityDelegate(view, accessibilityDelegateCompat == null ? null : accessibilityDelegateCompat.getBridge());
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void setFitsSystemWindows(android.view.View view, boolean z) {
            com.dcloud.android.v4.view.ViewCompatICS.setFitsSystemWindows(view, z);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    private @interface ImportantForAccessibility {
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static class JBViewCompatImpl extends com.dcloud.android.v4.view.ViewCompat.ICSViewCompatImpl {
        JBViewCompatImpl() {
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public com.dcloud.android.v4.view.accessibility.AccessibilityNodeProviderCompat getAccessibilityNodeProvider(android.view.View view) {
            java.lang.Object accessibilityNodeProvider = com.dcloud.android.v4.view.ViewCompatJB.getAccessibilityNodeProvider(view);
            if (accessibilityNodeProvider != null) {
                return new com.dcloud.android.v4.view.accessibility.AccessibilityNodeProviderCompat(accessibilityNodeProvider);
            }
            return null;
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public boolean getFitsSystemWindows(android.view.View view) {
            return com.dcloud.android.v4.view.ViewCompatJB.getFitsSystemWindows(view);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public int getImportantForAccessibility(android.view.View view) {
            return com.dcloud.android.v4.view.ViewCompatJB.getImportantForAccessibility(view);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public int getMinimumHeight(android.view.View view) {
            return com.dcloud.android.v4.view.ViewCompatJB.getMinimumHeight(view);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public int getMinimumWidth(android.view.View view) {
            return com.dcloud.android.v4.view.ViewCompatJB.getMinimumWidth(view);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public android.view.ViewParent getParentForAccessibility(android.view.View view) {
            return com.dcloud.android.v4.view.ViewCompatJB.getParentForAccessibility(view);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public boolean hasOverlappingRendering(android.view.View view) {
            return com.dcloud.android.v4.view.ViewCompatJB.hasOverlappingRendering(view);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public boolean hasTransientState(android.view.View view) {
            return com.dcloud.android.v4.view.ViewCompatJB.hasTransientState(view);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public boolean performAccessibilityAction(android.view.View view, int i, android.os.Bundle bundle) {
            return com.dcloud.android.v4.view.ViewCompatJB.performAccessibilityAction(view, i, bundle);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void postInvalidateOnAnimation(android.view.View view) {
            com.dcloud.android.v4.view.ViewCompatJB.postInvalidateOnAnimation(view);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void postOnAnimation(android.view.View view, java.lang.Runnable runnable) {
            com.dcloud.android.v4.view.ViewCompatJB.postOnAnimation(view, runnable);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void postOnAnimationDelayed(android.view.View view, java.lang.Runnable runnable, long j) {
            com.dcloud.android.v4.view.ViewCompatJB.postOnAnimationDelayed(view, runnable, j);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void requestApplyInsets(android.view.View view) {
            com.dcloud.android.v4.view.ViewCompatJB.requestApplyInsets(view);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void setHasTransientState(android.view.View view, boolean z) {
            com.dcloud.android.v4.view.ViewCompatJB.setHasTransientState(view, z);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void setImportantForAccessibility(android.view.View view, int i) {
            if (i == 4) {
                i = 2;
            }
            com.dcloud.android.v4.view.ViewCompatJB.setImportantForAccessibility(view, i);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void postInvalidateOnAnimation(android.view.View view, int i, int i2, int i3, int i4) {
            com.dcloud.android.v4.view.ViewCompatJB.postInvalidateOnAnimation(view, i, i2, i3, i4);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static class JbMr1ViewCompatImpl extends com.dcloud.android.v4.view.ViewCompat.JBViewCompatImpl {
        JbMr1ViewCompatImpl() {
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public int getLabelFor(android.view.View view) {
            return com.dcloud.android.v4.view.ViewCompatJellybeanMr1.getLabelFor(view);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public int getLayoutDirection(android.view.View view) {
            return com.dcloud.android.v4.view.ViewCompatJellybeanMr1.getLayoutDirection(view);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public int getPaddingEnd(android.view.View view) {
            return com.dcloud.android.v4.view.ViewCompatJellybeanMr1.getPaddingEnd(view);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public int getPaddingStart(android.view.View view) {
            return com.dcloud.android.v4.view.ViewCompatJellybeanMr1.getPaddingStart(view);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public int getWindowSystemUiVisibility(android.view.View view) {
            return com.dcloud.android.v4.view.ViewCompatJellybeanMr1.getWindowSystemUiVisibility(view);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public boolean isPaddingRelative(android.view.View view) {
            return com.dcloud.android.v4.view.ViewCompatJellybeanMr1.isPaddingRelative(view);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void setLabelFor(android.view.View view, int i) {
            com.dcloud.android.v4.view.ViewCompatJellybeanMr1.setLabelFor(view, i);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.HCViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void setLayerPaint(android.view.View view, android.graphics.Paint paint) {
            com.dcloud.android.v4.view.ViewCompatJellybeanMr1.setLayerPaint(view, paint);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void setLayoutDirection(android.view.View view, int i) {
            com.dcloud.android.v4.view.ViewCompatJellybeanMr1.setLayoutDirection(view, i);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void setPaddingRelative(android.view.View view, int i, int i2, int i3, int i4) {
            com.dcloud.android.v4.view.ViewCompatJellybeanMr1.setPaddingRelative(view, i, i2, i3, i4);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static class JbMr2ViewCompatImpl extends com.dcloud.android.v4.view.ViewCompat.JbMr1ViewCompatImpl {
        JbMr2ViewCompatImpl() {
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public android.graphics.Rect getClipBounds(android.view.View view) {
            return com.dcloud.android.v4.view.ViewCompatJellybeanMr2.getClipBounds(view);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void setClipBounds(android.view.View view, android.graphics.Rect rect) {
            com.dcloud.android.v4.view.ViewCompatJellybeanMr2.setClipBounds(view, rect);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static class KitKatViewCompatImpl extends com.dcloud.android.v4.view.ViewCompat.JbMr2ViewCompatImpl {
        KitKatViewCompatImpl() {
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public int getAccessibilityLiveRegion(android.view.View view) {
            return com.dcloud.android.v4.view.ViewCompatKitKat.getAccessibilityLiveRegion(view);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public boolean isAttachedToWindow(android.view.View view) {
            return com.dcloud.android.v4.view.ViewCompatKitKat.isAttachedToWindow(view);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public boolean isLaidOut(android.view.View view) {
            return com.dcloud.android.v4.view.ViewCompatKitKat.isLaidOut(view);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void setAccessibilityLiveRegion(android.view.View view, int i) {
            com.dcloud.android.v4.view.ViewCompatKitKat.setAccessibilityLiveRegion(view, i);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.JBViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void setImportantForAccessibility(android.view.View view, int i) {
            com.dcloud.android.v4.view.ViewCompatJB.setImportantForAccessibility(view, i);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    private @interface LayerType {
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    private @interface LayoutDirectionMode {
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static class LollipopViewCompatImpl extends com.dcloud.android.v4.view.ViewCompat.KitKatViewCompatImpl {
        LollipopViewCompatImpl() {
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public com.dcloud.android.v4.view.WindowInsetsCompat dispatchApplyWindowInsets(android.view.View view, com.dcloud.android.v4.view.WindowInsetsCompat windowInsetsCompat) {
            return com.dcloud.android.v4.view.ViewCompatLollipop.dispatchApplyWindowInsets(view, windowInsetsCompat);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public boolean dispatchNestedFling(android.view.View view, float f, float f2, boolean z) {
            return com.dcloud.android.v4.view.ViewCompatLollipop.dispatchNestedFling(view, f, f2, z);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public boolean dispatchNestedPreFling(android.view.View view, float f, float f2) {
            return com.dcloud.android.v4.view.ViewCompatLollipop.dispatchNestedPreFling(view, f, f2);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public boolean dispatchNestedPreScroll(android.view.View view, int i, int i2, int[] iArr, int[] iArr2) {
            return com.dcloud.android.v4.view.ViewCompatLollipop.dispatchNestedPreScroll(view, i, i2, iArr, iArr2);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public boolean dispatchNestedScroll(android.view.View view, int i, int i2, int i3, int i4, int[] iArr) {
            return com.dcloud.android.v4.view.ViewCompatLollipop.dispatchNestedScroll(view, i, i2, i3, i4, iArr);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public android.content.res.ColorStateList getBackgroundTintList(android.view.View view) {
            return com.dcloud.android.v4.view.ViewCompatLollipop.getBackgroundTintList(view);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public android.graphics.PorterDuff.Mode getBackgroundTintMode(android.view.View view) {
            return com.dcloud.android.v4.view.ViewCompatLollipop.getBackgroundTintMode(view);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public float getElevation(android.view.View view) {
            return com.dcloud.android.v4.view.ViewCompatLollipop.getElevation(view);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public java.lang.String getTransitionName(android.view.View view) {
            return com.dcloud.android.v4.view.ViewCompatLollipop.getTransitionName(view);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public float getTranslationZ(android.view.View view) {
            return com.dcloud.android.v4.view.ViewCompatLollipop.getTranslationZ(view);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public float getZ(android.view.View view) {
            return com.dcloud.android.v4.view.ViewCompatLollipop.getZ(view);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public boolean hasNestedScrollingParent(android.view.View view) {
            return com.dcloud.android.v4.view.ViewCompatLollipop.hasNestedScrollingParent(view);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public boolean isImportantForAccessibility(android.view.View view) {
            return com.dcloud.android.v4.view.ViewCompatLollipop.isImportantForAccessibility(view);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public boolean isNestedScrollingEnabled(android.view.View view) {
            return com.dcloud.android.v4.view.ViewCompatLollipop.isNestedScrollingEnabled(view);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public com.dcloud.android.v4.view.WindowInsetsCompat onApplyWindowInsets(android.view.View view, com.dcloud.android.v4.view.WindowInsetsCompat windowInsetsCompat) {
            return com.dcloud.android.v4.view.ViewCompatLollipop.onApplyWindowInsets(view, windowInsetsCompat);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.JBViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void requestApplyInsets(android.view.View view) {
            com.dcloud.android.v4.view.ViewCompatLollipop.requestApplyInsets(view);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void setBackgroundTintList(android.view.View view, android.content.res.ColorStateList colorStateList) {
            com.dcloud.android.v4.view.ViewCompatLollipop.setBackgroundTintList(view, colorStateList);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void setBackgroundTintMode(android.view.View view, android.graphics.PorterDuff.Mode mode) {
            com.dcloud.android.v4.view.ViewCompatLollipop.setBackgroundTintMode(view, mode);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void setElevation(android.view.View view, float f) {
            com.dcloud.android.v4.view.ViewCompatLollipop.setElevation(view, f);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void setNestedScrollingEnabled(android.view.View view, boolean z) {
            com.dcloud.android.v4.view.ViewCompatLollipop.setNestedScrollingEnabled(view, z);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void setOnApplyWindowInsetsListener(android.view.View view, com.dcloud.android.v4.view.OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
            com.dcloud.android.v4.view.ViewCompatLollipop.setOnApplyWindowInsetsListener(view, onApplyWindowInsetsListener);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void setTransitionName(android.view.View view, java.lang.String str) {
            com.dcloud.android.v4.view.ViewCompatLollipop.setTransitionName(view, str);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void setTranslationZ(android.view.View view, float f) {
            com.dcloud.android.v4.view.ViewCompatLollipop.setTranslationZ(view, f);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public boolean startNestedScroll(android.view.View view, int i) {
            return com.dcloud.android.v4.view.ViewCompatLollipop.startNestedScroll(view, i);
        }

        @Override // com.dcloud.android.v4.view.ViewCompat.BaseViewCompatImpl, com.dcloud.android.v4.view.ViewCompat.ViewCompatImpl
        public void stopNestedScroll(android.view.View view) {
            com.dcloud.android.v4.view.ViewCompatLollipop.stopNestedScroll(view);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    private @interface OverScroll {
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    private @interface ResolvedLayoutDirectionMode {
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    interface ViewCompatImpl {
        com.dcloud.android.v4.view.ViewPropertyAnimatorCompat animate(android.view.View view);

        boolean canScrollHorizontally(android.view.View view, int i);

        boolean canScrollVertically(android.view.View view, int i);

        int combineMeasuredStates(int i, int i2);

        com.dcloud.android.v4.view.WindowInsetsCompat dispatchApplyWindowInsets(android.view.View view, com.dcloud.android.v4.view.WindowInsetsCompat windowInsetsCompat);

        void dispatchFinishTemporaryDetach(android.view.View view);

        boolean dispatchNestedFling(android.view.View view, float f, float f2, boolean z);

        boolean dispatchNestedPreFling(android.view.View view, float f, float f2);

        boolean dispatchNestedPreScroll(android.view.View view, int i, int i2, int[] iArr, int[] iArr2);

        boolean dispatchNestedScroll(android.view.View view, int i, int i2, int i3, int i4, int[] iArr);

        void dispatchStartTemporaryDetach(android.view.View view);

        int getAccessibilityLiveRegion(android.view.View view);

        com.dcloud.android.v4.view.accessibility.AccessibilityNodeProviderCompat getAccessibilityNodeProvider(android.view.View view);

        float getAlpha(android.view.View view);

        android.content.res.ColorStateList getBackgroundTintList(android.view.View view);

        android.graphics.PorterDuff.Mode getBackgroundTintMode(android.view.View view);

        android.graphics.Rect getClipBounds(android.view.View view);

        float getElevation(android.view.View view);

        boolean getFitsSystemWindows(android.view.View view);

        int getImportantForAccessibility(android.view.View view);

        int getLabelFor(android.view.View view);

        int getLayerType(android.view.View view);

        int getLayoutDirection(android.view.View view);

        int getMeasuredHeightAndState(android.view.View view);

        int getMeasuredState(android.view.View view);

        int getMeasuredWidthAndState(android.view.View view);

        int getMinimumHeight(android.view.View view);

        int getMinimumWidth(android.view.View view);

        int getOverScrollMode(android.view.View view);

        int getPaddingEnd(android.view.View view);

        int getPaddingStart(android.view.View view);

        android.view.ViewParent getParentForAccessibility(android.view.View view);

        float getPivotX(android.view.View view);

        float getPivotY(android.view.View view);

        float getRotation(android.view.View view);

        float getRotationX(android.view.View view);

        float getRotationY(android.view.View view);

        float getScaleX(android.view.View view);

        float getScaleY(android.view.View view);

        java.lang.String getTransitionName(android.view.View view);

        float getTranslationX(android.view.View view);

        float getTranslationY(android.view.View view);

        float getTranslationZ(android.view.View view);

        int getWindowSystemUiVisibility(android.view.View view);

        float getX(android.view.View view);

        float getY(android.view.View view);

        float getZ(android.view.View view);

        boolean hasAccessibilityDelegate(android.view.View view);

        boolean hasNestedScrollingParent(android.view.View view);

        boolean hasOverlappingRendering(android.view.View view);

        boolean hasTransientState(android.view.View view);

        boolean isAttachedToWindow(android.view.View view);

        boolean isImportantForAccessibility(android.view.View view);

        boolean isLaidOut(android.view.View view);

        boolean isNestedScrollingEnabled(android.view.View view);

        boolean isOpaque(android.view.View view);

        boolean isPaddingRelative(android.view.View view);

        void jumpDrawablesToCurrentState(android.view.View view);

        com.dcloud.android.v4.view.WindowInsetsCompat onApplyWindowInsets(android.view.View view, com.dcloud.android.v4.view.WindowInsetsCompat windowInsetsCompat);

        void onInitializeAccessibilityEvent(android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent);

        void onInitializeAccessibilityNodeInfo(android.view.View view, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat accessibilityNodeInfoCompat);

        void onPopulateAccessibilityEvent(android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent);

        boolean performAccessibilityAction(android.view.View view, int i, android.os.Bundle bundle);

        void postInvalidateOnAnimation(android.view.View view);

        void postInvalidateOnAnimation(android.view.View view, int i, int i2, int i3, int i4);

        void postOnAnimation(android.view.View view, java.lang.Runnable runnable);

        void postOnAnimationDelayed(android.view.View view, java.lang.Runnable runnable, long j);

        void requestApplyInsets(android.view.View view);

        int resolveSizeAndState(int i, int i2, int i3);

        void setAccessibilityDelegate(android.view.View view, com.dcloud.android.v4.view.AccessibilityDelegateCompat accessibilityDelegateCompat);

        void setAccessibilityLiveRegion(android.view.View view, int i);

        void setActivated(android.view.View view, boolean z);

        void setAlpha(android.view.View view, float f);

        void setBackgroundTintList(android.view.View view, android.content.res.ColorStateList colorStateList);

        void setBackgroundTintMode(android.view.View view, android.graphics.PorterDuff.Mode mode);

        void setChildrenDrawingOrderEnabled(android.view.ViewGroup viewGroup, boolean z);

        void setClipBounds(android.view.View view, android.graphics.Rect rect);

        void setElevation(android.view.View view, float f);

        void setFitsSystemWindows(android.view.View view, boolean z);

        void setHasTransientState(android.view.View view, boolean z);

        void setImportantForAccessibility(android.view.View view, int i);

        void setLabelFor(android.view.View view, int i);

        void setLayerPaint(android.view.View view, android.graphics.Paint paint);

        void setLayerType(android.view.View view, int i, android.graphics.Paint paint);

        void setLayoutDirection(android.view.View view, int i);

        void setNestedScrollingEnabled(android.view.View view, boolean z);

        void setOnApplyWindowInsetsListener(android.view.View view, com.dcloud.android.v4.view.OnApplyWindowInsetsListener onApplyWindowInsetsListener);

        void setOverScrollMode(android.view.View view, int i);

        void setPaddingRelative(android.view.View view, int i, int i2, int i3, int i4);

        void setPivotX(android.view.View view, float f);

        void setPivotY(android.view.View view, float f);

        void setRotation(android.view.View view, float f);

        void setRotationX(android.view.View view, float f);

        void setRotationY(android.view.View view, float f);

        void setSaveFromParentEnabled(android.view.View view, boolean z);

        void setScaleX(android.view.View view, float f);

        void setScaleY(android.view.View view, float f);

        void setTransitionName(android.view.View view, java.lang.String str);

        void setTranslationX(android.view.View view, float f);

        void setTranslationY(android.view.View view, float f);

        void setTranslationZ(android.view.View view, float f);

        void setX(android.view.View view, float f);

        void setY(android.view.View view, float f);

        boolean startNestedScroll(android.view.View view, int i);

        void stopNestedScroll(android.view.View view);
    }

    public static com.dcloud.android.v4.view.ViewPropertyAnimatorCompat animate(android.view.View view) {
        return IMPL.animate(view);
    }

    public static boolean canScrollHorizontally(android.view.View view, int i) {
        return IMPL.canScrollHorizontally(view, i);
    }

    public static boolean canScrollVertically(android.view.View view, int i) {
        return IMPL.canScrollVertically(view, i);
    }

    public static int combineMeasuredStates(int i, int i2) {
        return IMPL.combineMeasuredStates(i, i2);
    }

    public static com.dcloud.android.v4.view.WindowInsetsCompat dispatchApplyWindowInsets(android.view.View view, com.dcloud.android.v4.view.WindowInsetsCompat windowInsetsCompat) {
        return IMPL.dispatchApplyWindowInsets(view, windowInsetsCompat);
    }

    public static void dispatchFinishTemporaryDetach(android.view.View view) {
        IMPL.dispatchFinishTemporaryDetach(view);
    }

    public static boolean dispatchNestedFling(android.view.View view, float f, float f2, boolean z) {
        return IMPL.dispatchNestedFling(view, f, f2, z);
    }

    public static boolean dispatchNestedPreFling(android.view.View view, float f, float f2) {
        return IMPL.dispatchNestedPreFling(view, f, f2);
    }

    public static boolean dispatchNestedPreScroll(android.view.View view, int i, int i2, int[] iArr, int[] iArr2) {
        return IMPL.dispatchNestedPreScroll(view, i, i2, iArr, iArr2);
    }

    public static boolean dispatchNestedScroll(android.view.View view, int i, int i2, int i3, int i4, int[] iArr) {
        return IMPL.dispatchNestedScroll(view, i, i2, i3, i4, iArr);
    }

    public static void dispatchStartTemporaryDetach(android.view.View view) {
        IMPL.dispatchStartTemporaryDetach(view);
    }

    public static int getAccessibilityLiveRegion(android.view.View view) {
        return IMPL.getAccessibilityLiveRegion(view);
    }

    public static com.dcloud.android.v4.view.accessibility.AccessibilityNodeProviderCompat getAccessibilityNodeProvider(android.view.View view) {
        return IMPL.getAccessibilityNodeProvider(view);
    }

    public static float getAlpha(android.view.View view) {
        return IMPL.getAlpha(view);
    }

    public static android.content.res.ColorStateList getBackgroundTintList(android.view.View view) {
        return IMPL.getBackgroundTintList(view);
    }

    public static android.graphics.PorterDuff.Mode getBackgroundTintMode(android.view.View view) {
        return IMPL.getBackgroundTintMode(view);
    }

    public static android.graphics.Rect getClipBounds(android.view.View view) {
        return IMPL.getClipBounds(view);
    }

    public static float getElevation(android.view.View view) {
        return IMPL.getElevation(view);
    }

    public static boolean getFitsSystemWindows(android.view.View view) {
        return IMPL.getFitsSystemWindows(view);
    }

    public static int getImportantForAccessibility(android.view.View view) {
        return IMPL.getImportantForAccessibility(view);
    }

    public static int getLabelFor(android.view.View view) {
        return IMPL.getLabelFor(view);
    }

    public static int getLayerType(android.view.View view) {
        return IMPL.getLayerType(view);
    }

    public static int getLayoutDirection(android.view.View view) {
        return IMPL.getLayoutDirection(view);
    }

    public static int getMeasuredHeightAndState(android.view.View view) {
        return IMPL.getMeasuredHeightAndState(view);
    }

    public static int getMeasuredState(android.view.View view) {
        return IMPL.getMeasuredState(view);
    }

    public static int getMeasuredWidthAndState(android.view.View view) {
        return IMPL.getMeasuredWidthAndState(view);
    }

    public static int getMinimumHeight(android.view.View view) {
        return IMPL.getMinimumHeight(view);
    }

    public static int getMinimumWidth(android.view.View view) {
        return IMPL.getMinimumWidth(view);
    }

    public static int getOverScrollMode(android.view.View view) {
        return IMPL.getOverScrollMode(view);
    }

    public static int getPaddingEnd(android.view.View view) {
        return IMPL.getPaddingEnd(view);
    }

    public static int getPaddingStart(android.view.View view) {
        return IMPL.getPaddingStart(view);
    }

    public static android.view.ViewParent getParentForAccessibility(android.view.View view) {
        return IMPL.getParentForAccessibility(view);
    }

    public static float getPivotX(android.view.View view) {
        return IMPL.getPivotX(view);
    }

    public static float getPivotY(android.view.View view) {
        return IMPL.getPivotY(view);
    }

    public static float getRotation(android.view.View view) {
        return IMPL.getRotation(view);
    }

    public static float getRotationX(android.view.View view) {
        return IMPL.getRotationX(view);
    }

    public static float getRotationY(android.view.View view) {
        return IMPL.getRotationY(view);
    }

    public static float getScaleX(android.view.View view) {
        return IMPL.getScaleX(view);
    }

    public static float getScaleY(android.view.View view) {
        return IMPL.getScaleY(view);
    }

    public static java.lang.String getTransitionName(android.view.View view) {
        return IMPL.getTransitionName(view);
    }

    public static float getTranslationX(android.view.View view) {
        return IMPL.getTranslationX(view);
    }

    public static float getTranslationY(android.view.View view) {
        return IMPL.getTranslationY(view);
    }

    public static float getTranslationZ(android.view.View view) {
        return IMPL.getTranslationZ(view);
    }

    public static int getWindowSystemUiVisibility(android.view.View view) {
        return IMPL.getWindowSystemUiVisibility(view);
    }

    public static float getX(android.view.View view) {
        return IMPL.getX(view);
    }

    public static float getY(android.view.View view) {
        return IMPL.getY(view);
    }

    public static float getZ(android.view.View view) {
        return IMPL.getZ(view);
    }

    public static boolean hasAccessibilityDelegate(android.view.View view) {
        return IMPL.hasAccessibilityDelegate(view);
    }

    public static boolean hasNestedScrollingParent(android.view.View view) {
        return IMPL.hasNestedScrollingParent(view);
    }

    public static boolean hasOverlappingRendering(android.view.View view) {
        return IMPL.hasOverlappingRendering(view);
    }

    public static boolean hasTransientState(android.view.View view) {
        return IMPL.hasTransientState(view);
    }

    public static boolean isAttachedToWindow(android.view.View view) {
        return IMPL.isAttachedToWindow(view);
    }

    public static boolean isLaidOut(android.view.View view) {
        return IMPL.isLaidOut(view);
    }

    public static boolean isNestedScrollingEnabled(android.view.View view) {
        return IMPL.isNestedScrollingEnabled(view);
    }

    public static boolean isOpaque(android.view.View view) {
        return IMPL.isOpaque(view);
    }

    public static boolean isPaddingRelative(android.view.View view) {
        return IMPL.isPaddingRelative(view);
    }

    public static void jumpDrawablesToCurrentState(android.view.View view) {
        IMPL.jumpDrawablesToCurrentState(view);
    }

    public static void offsetLeftAndRight(android.view.View view, int i) {
        view.offsetLeftAndRight(i);
    }

    public static void offsetTopAndBottom(android.view.View view, int i) {
        view.offsetTopAndBottom(i);
    }

    public static com.dcloud.android.v4.view.WindowInsetsCompat onApplyWindowInsets(android.view.View view, com.dcloud.android.v4.view.WindowInsetsCompat windowInsetsCompat) {
        return IMPL.onApplyWindowInsets(view, windowInsetsCompat);
    }

    public static void onInitializeAccessibilityEvent(android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
        IMPL.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public static void onInitializeAccessibilityNodeInfo(android.view.View view, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        IMPL.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
    }

    public static void onPopulateAccessibilityEvent(android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
        IMPL.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public static boolean performAccessibilityAction(android.view.View view, int i, android.os.Bundle bundle) {
        return IMPL.performAccessibilityAction(view, i, bundle);
    }

    public static void postInvalidateOnAnimation(android.view.View view) {
        IMPL.postInvalidateOnAnimation(view);
    }

    public static void postOnAnimation(android.view.View view, java.lang.Runnable runnable) {
        IMPL.postOnAnimation(view, runnable);
    }

    public static void postOnAnimationDelayed(android.view.View view, java.lang.Runnable runnable, long j) {
        IMPL.postOnAnimationDelayed(view, runnable, j);
    }

    public static void requestApplyInsets(android.view.View view) {
        IMPL.requestApplyInsets(view);
    }

    public static int resolveSizeAndState(int i, int i2, int i3) {
        return IMPL.resolveSizeAndState(i, i2, i3);
    }

    public static void setAccessibilityDelegate(android.view.View view, com.dcloud.android.v4.view.AccessibilityDelegateCompat accessibilityDelegateCompat) {
        IMPL.setAccessibilityDelegate(view, accessibilityDelegateCompat);
    }

    public static void setAccessibilityLiveRegion(android.view.View view, int i) {
        IMPL.setAccessibilityLiveRegion(view, i);
    }

    public static void setActivated(android.view.View view, boolean z) {
        IMPL.setActivated(view, z);
    }

    public static void setAlpha(android.view.View view, float f) {
        IMPL.setAlpha(view, f);
    }

    public static void setBackgroundTintList(android.view.View view, android.content.res.ColorStateList colorStateList) {
        IMPL.setBackgroundTintList(view, colorStateList);
    }

    public static void setBackgroundTintMode(android.view.View view, android.graphics.PorterDuff.Mode mode) {
        IMPL.setBackgroundTintMode(view, mode);
    }

    public static void setChildrenDrawingOrderEnabled(android.view.ViewGroup viewGroup, boolean z) {
        IMPL.setChildrenDrawingOrderEnabled(viewGroup, z);
    }

    public static void setClipBounds(android.view.View view, android.graphics.Rect rect) {
        IMPL.setClipBounds(view, rect);
    }

    public static void setElevation(android.view.View view, float f) {
        IMPL.setElevation(view, f);
    }

    public static void setFitsSystemWindows(android.view.View view, boolean z) {
        IMPL.setFitsSystemWindows(view, z);
    }

    public static void setHasTransientState(android.view.View view, boolean z) {
        IMPL.setHasTransientState(view, z);
    }

    public static void setImportantForAccessibility(android.view.View view, int i) {
        IMPL.setImportantForAccessibility(view, i);
    }

    public static void setLabelFor(android.view.View view, int i) {
        IMPL.setLabelFor(view, i);
    }

    public static void setLayerPaint(android.view.View view, android.graphics.Paint paint) {
        IMPL.setLayerPaint(view, paint);
    }

    public static void setLayerType(android.view.View view, int i, android.graphics.Paint paint) {
        IMPL.setLayerType(view, i, paint);
    }

    public static void setLayoutDirection(android.view.View view, int i) {
        IMPL.setLayoutDirection(view, i);
    }

    public static void setNestedScrollingEnabled(android.view.View view, boolean z) {
        IMPL.setNestedScrollingEnabled(view, z);
    }

    public static void setOnApplyWindowInsetsListener(android.view.View view, com.dcloud.android.v4.view.OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        IMPL.setOnApplyWindowInsetsListener(view, onApplyWindowInsetsListener);
    }

    public static void setOverScrollMode(android.view.View view, int i) {
        IMPL.setOverScrollMode(view, i);
    }

    public static void setPaddingRelative(android.view.View view, int i, int i2, int i3, int i4) {
        IMPL.setPaddingRelative(view, i, i2, i3, i4);
    }

    public static void setPivotX(android.view.View view, float f) {
        IMPL.setPivotX(view, f);
    }

    public static void setPivotY(android.view.View view, float f) {
        IMPL.setPivotX(view, f);
    }

    public static void setRotation(android.view.View view, float f) {
        IMPL.setRotation(view, f);
    }

    public static void setRotationX(android.view.View view, float f) {
        IMPL.setRotationX(view, f);
    }

    public static void setRotationY(android.view.View view, float f) {
        IMPL.setRotationY(view, f);
    }

    public static void setSaveFromParentEnabled(android.view.View view, boolean z) {
        IMPL.setSaveFromParentEnabled(view, z);
    }

    public static void setScaleX(android.view.View view, float f) {
        IMPL.setScaleX(view, f);
    }

    public static void setScaleY(android.view.View view, float f) {
        IMPL.setScaleY(view, f);
    }

    public static void setTransitionName(android.view.View view, java.lang.String str) {
        IMPL.setTransitionName(view, str);
    }

    public static void setTranslationX(android.view.View view, float f) {
        IMPL.setTranslationX(view, f);
    }

    public static void setTranslationY(android.view.View view, float f) {
        IMPL.setTranslationY(view, f);
    }

    public static void setTranslationZ(android.view.View view, float f) {
        IMPL.setTranslationZ(view, f);
    }

    public static void setX(android.view.View view, float f) {
        IMPL.setX(view, f);
    }

    public static void setY(android.view.View view, float f) {
        IMPL.setY(view, f);
    }

    public static boolean startNestedScroll(android.view.View view, int i) {
        return IMPL.startNestedScroll(view, i);
    }

    public static void stopNestedScroll(android.view.View view) {
        IMPL.stopNestedScroll(view);
    }

    public static void postInvalidateOnAnimation(android.view.View view, int i, int i2, int i3, int i4) {
        IMPL.postInvalidateOnAnimation(view, i, i2, i3, i4);
    }
}
