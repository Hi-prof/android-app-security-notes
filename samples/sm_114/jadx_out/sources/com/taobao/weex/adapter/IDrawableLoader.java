package com.taobao.weex.adapter;

/* JADX INFO: loaded from: classes.dex */
public interface IDrawableLoader {

    public interface AnimatedTarget extends com.taobao.weex.adapter.IDrawableLoader.DrawableTarget {
        void setAnimatedDrawable(android.graphics.drawable.Drawable drawable);
    }

    public interface DrawableTarget {
        void setDrawable(android.graphics.drawable.Drawable drawable, boolean z);
    }

    public interface StaticTarget extends com.taobao.weex.adapter.IDrawableLoader.DrawableTarget {
        @Override // com.taobao.weex.adapter.IDrawableLoader.DrawableTarget
        void setDrawable(android.graphics.drawable.Drawable drawable, boolean z);
    }

    void setDrawable(java.lang.String str, com.taobao.weex.adapter.IDrawableLoader.DrawableTarget drawableTarget, com.taobao.weex.adapter.DrawableStrategy drawableStrategy);
}
