package com.bumptech.glide.request.transition;

/* JADX INFO: loaded from: classes.dex */
public interface Transition<R> {

    public interface ViewAdapter {
        android.graphics.drawable.Drawable getCurrentDrawable();

        android.view.View getView();

        void setDrawable(android.graphics.drawable.Drawable drawable);
    }

    boolean transition(R r, com.bumptech.glide.request.transition.Transition.ViewAdapter viewAdapter);
}
