package com.facebook.drawee.view;

/* JADX INFO: loaded from: classes.dex */
public class DraweeHolder<DH extends com.facebook.drawee.interfaces.DraweeHierarchy> implements com.facebook.drawee.drawable.VisibilityCallback {

    @javax.annotation.Nullable
    private DH mHierarchy;
    private boolean mIsControllerAttached = false;
    private boolean mIsHolderAttached = false;
    private boolean mIsVisible = true;

    @javax.annotation.Nullable
    private com.facebook.drawee.interfaces.DraweeController mController = null;
    private final com.facebook.drawee.components.DraweeEventTracker mEventTracker = com.facebook.drawee.components.DraweeEventTracker.newInstance();

    public void registerWithContext(android.content.Context context) {
    }

    public static <DH extends com.facebook.drawee.interfaces.DraweeHierarchy> com.facebook.drawee.view.DraweeHolder<DH> create(@javax.annotation.Nullable DH dh, android.content.Context context) {
        com.facebook.drawee.view.DraweeHolder<DH> draweeHolder = new com.facebook.drawee.view.DraweeHolder<>(dh);
        draweeHolder.registerWithContext(context);
        return draweeHolder;
    }

    public DraweeHolder(@javax.annotation.Nullable DH dh) {
        if (dh != null) {
            setHierarchy(dh);
        }
    }

    public void onAttach() {
        this.mEventTracker.recordEvent(com.facebook.drawee.components.DraweeEventTracker.Event.ON_HOLDER_ATTACH);
        this.mIsHolderAttached = true;
        attachOrDetachController();
    }

    public boolean isAttached() {
        return this.mIsHolderAttached;
    }

    public void onDetach() {
        this.mEventTracker.recordEvent(com.facebook.drawee.components.DraweeEventTracker.Event.ON_HOLDER_DETACH);
        this.mIsHolderAttached = false;
        attachOrDetachController();
    }

    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        if (isControllerValid()) {
            return this.mController.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // com.facebook.drawee.drawable.VisibilityCallback
    public void onVisibilityChange(boolean z) {
        if (this.mIsVisible == z) {
            return;
        }
        this.mEventTracker.recordEvent(z ? com.facebook.drawee.components.DraweeEventTracker.Event.ON_DRAWABLE_SHOW : com.facebook.drawee.components.DraweeEventTracker.Event.ON_DRAWABLE_HIDE);
        this.mIsVisible = z;
        attachOrDetachController();
    }

    @Override // com.facebook.drawee.drawable.VisibilityCallback
    public void onDraw() {
        if (this.mIsControllerAttached) {
            return;
        }
        com.facebook.common.logging.FLog.w((java.lang.Class<?>) com.facebook.drawee.components.DraweeEventTracker.class, "%x: Draw requested for a non-attached controller %x. %s", java.lang.Integer.valueOf(java.lang.System.identityHashCode(this)), java.lang.Integer.valueOf(java.lang.System.identityHashCode(this.mController)), toString());
        this.mIsHolderAttached = true;
        this.mIsVisible = true;
        attachOrDetachController();
    }

    private void setVisibilityCallback(@javax.annotation.Nullable com.facebook.drawee.drawable.VisibilityCallback visibilityCallback) {
        java.lang.Object topLevelDrawable = getTopLevelDrawable();
        if (topLevelDrawable instanceof com.facebook.drawee.drawable.VisibilityAwareDrawable) {
            ((com.facebook.drawee.drawable.VisibilityAwareDrawable) topLevelDrawable).setVisibilityCallback(visibilityCallback);
        }
    }

    public void setController(@javax.annotation.Nullable com.facebook.drawee.interfaces.DraweeController draweeController) {
        boolean z = this.mIsControllerAttached;
        if (z) {
            detachController();
        }
        if (isControllerValid()) {
            this.mEventTracker.recordEvent(com.facebook.drawee.components.DraweeEventTracker.Event.ON_CLEAR_OLD_CONTROLLER);
            this.mController.setHierarchy(null);
        }
        this.mController = draweeController;
        if (draweeController != null) {
            this.mEventTracker.recordEvent(com.facebook.drawee.components.DraweeEventTracker.Event.ON_SET_CONTROLLER);
            this.mController.setHierarchy(this.mHierarchy);
        } else {
            this.mEventTracker.recordEvent(com.facebook.drawee.components.DraweeEventTracker.Event.ON_CLEAR_CONTROLLER);
        }
        if (z) {
            attachController();
        }
    }

    public void resetActualImage() {
        setController(null);
    }

    @javax.annotation.Nullable
    public com.facebook.drawee.interfaces.DraweeController getController() {
        return this.mController;
    }

    public void setHierarchy(DH dh) {
        this.mEventTracker.recordEvent(com.facebook.drawee.components.DraweeEventTracker.Event.ON_SET_HIERARCHY);
        boolean zIsControllerValid = isControllerValid();
        setVisibilityCallback(null);
        DH dh2 = (DH) com.facebook.common.internal.Preconditions.checkNotNull(dh);
        this.mHierarchy = dh2;
        android.graphics.drawable.Drawable topLevelDrawable = dh2.getTopLevelDrawable();
        onVisibilityChange(topLevelDrawable == null || topLevelDrawable.isVisible());
        setVisibilityCallback(this);
        if (zIsControllerValid) {
            this.mController.setHierarchy(dh);
        }
    }

    public DH getHierarchy() {
        return (DH) com.facebook.common.internal.Preconditions.checkNotNull(this.mHierarchy);
    }

    public boolean hasHierarchy() {
        return this.mHierarchy != null;
    }

    @javax.annotation.Nullable
    public android.graphics.drawable.Drawable getTopLevelDrawable() {
        DH dh = this.mHierarchy;
        if (dh == null) {
            return null;
        }
        return dh.getTopLevelDrawable();
    }

    public boolean isControllerValid() {
        com.facebook.drawee.interfaces.DraweeController draweeController = this.mController;
        return draweeController != null && draweeController.getHierarchy() == this.mHierarchy;
    }

    protected com.facebook.drawee.components.DraweeEventTracker getDraweeEventTracker() {
        return this.mEventTracker;
    }

    private void attachController() {
        if (this.mIsControllerAttached) {
            return;
        }
        this.mEventTracker.recordEvent(com.facebook.drawee.components.DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
        this.mIsControllerAttached = true;
        com.facebook.drawee.interfaces.DraweeController draweeController = this.mController;
        if (draweeController == null || draweeController.getHierarchy() == null) {
            return;
        }
        this.mController.onAttach();
    }

    private void detachController() {
        if (this.mIsControllerAttached) {
            this.mEventTracker.recordEvent(com.facebook.drawee.components.DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
            this.mIsControllerAttached = false;
            if (isControllerValid()) {
                this.mController.onDetach();
            }
        }
    }

    private void attachOrDetachController() {
        if (this.mIsHolderAttached && this.mIsVisible) {
            attachController();
        } else {
            detachController();
        }
    }

    public java.lang.String toString() {
        return com.facebook.common.internal.Objects.toStringHelper(this).add("controllerAttached", this.mIsControllerAttached).add("holderAttached", this.mIsHolderAttached).add("drawableVisible", this.mIsVisible).add("events", this.mEventTracker.toString()).toString();
    }
}
