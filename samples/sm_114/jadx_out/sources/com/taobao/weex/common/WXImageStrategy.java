package com.taobao.weex.common;

/* JADX INFO: loaded from: classes.dex */
public class WXImageStrategy {
    public int blurRadius;
    com.taobao.weex.common.WXImageStrategy.ImageListener imageListener;
    public java.lang.String instanceId;
    boolean isAutoCompression = true;

    @java.lang.Deprecated
    public boolean isClipping;
    public boolean isSharpen;
    public java.lang.String placeHolder;

    public interface ImageListener {
        void onImageFinish(java.lang.String str, android.widget.ImageView imageView, boolean z, java.util.Map map);
    }

    public WXImageStrategy() {
    }

    public WXImageStrategy(java.lang.String str) {
        this.instanceId = str;
    }

    public com.taobao.weex.common.WXImageStrategy.ImageListener getImageListener() {
        return this.imageListener;
    }

    public void setImageListener(com.taobao.weex.common.WXImageStrategy.ImageListener imageListener) {
        this.imageListener = imageListener;
    }

    public boolean isAutoCompression() {
        return this.isAutoCompression;
    }

    public void setAutoCompression(boolean z) {
        this.isAutoCompression = z;
    }
}
