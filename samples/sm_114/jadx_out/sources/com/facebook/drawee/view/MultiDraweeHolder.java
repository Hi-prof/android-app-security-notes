package com.facebook.drawee.view;

/* JADX INFO: loaded from: classes.dex */
@java.lang.Deprecated
public class MultiDraweeHolder<DH extends com.facebook.drawee.interfaces.DraweeHierarchy> {
    boolean mIsAttached = false;
    java.util.ArrayList<com.facebook.drawee.view.DraweeHolder<DH>> mHolders = new java.util.ArrayList<>();

    public void onAttach() {
        if (this.mIsAttached) {
            return;
        }
        this.mIsAttached = true;
        for (int i = 0; i < this.mHolders.size(); i++) {
            this.mHolders.get(i).onAttach();
        }
    }

    public void onDetach() {
        if (this.mIsAttached) {
            this.mIsAttached = false;
            for (int i = 0; i < this.mHolders.size(); i++) {
                this.mHolders.get(i).onDetach();
            }
        }
    }

    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        for (int i = 0; i < this.mHolders.size(); i++) {
            if (this.mHolders.get(i).onTouchEvent(motionEvent)) {
                return true;
            }
        }
        return false;
    }

    public void clear() {
        if (this.mIsAttached) {
            for (int i = 0; i < this.mHolders.size(); i++) {
                this.mHolders.get(i).onDetach();
            }
        }
        this.mHolders.clear();
    }

    public void add(com.facebook.drawee.view.DraweeHolder<DH> draweeHolder) {
        add(this.mHolders.size(), draweeHolder);
    }

    public void add(int i, com.facebook.drawee.view.DraweeHolder<DH> draweeHolder) {
        com.facebook.common.internal.Preconditions.checkNotNull(draweeHolder);
        com.facebook.common.internal.Preconditions.checkElementIndex(i, this.mHolders.size() + 1);
        this.mHolders.add(i, draweeHolder);
        if (this.mIsAttached) {
            draweeHolder.onAttach();
        }
    }

    public void remove(int i) {
        com.facebook.drawee.view.DraweeHolder<DH> draweeHolder = this.mHolders.get(i);
        if (this.mIsAttached) {
            draweeHolder.onDetach();
        }
        this.mHolders.remove(i);
    }

    public com.facebook.drawee.view.DraweeHolder<DH> get(int i) {
        return this.mHolders.get(i);
    }

    public int size() {
        return this.mHolders.size();
    }

    public void draw(android.graphics.Canvas canvas) {
        for (int i = 0; i < this.mHolders.size(); i++) {
            android.graphics.drawable.Drawable topLevelDrawable = get(i).getTopLevelDrawable();
            if (topLevelDrawable != null) {
                topLevelDrawable.draw(canvas);
            }
        }
    }

    public boolean verifyDrawable(android.graphics.drawable.Drawable drawable) {
        for (int i = 0; i < this.mHolders.size(); i++) {
            if (drawable == get(i).getTopLevelDrawable()) {
                return true;
            }
        }
        return false;
    }
}
