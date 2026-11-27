package com.nostra13.dcloudimageloader.core.assist;

/* JADX INFO: loaded from: classes.dex */
public class PauseOnScrollListener implements android.widget.AbsListView.OnScrollListener {
    private final android.widget.AbsListView.OnScrollListener externalListener;
    private com.nostra13.dcloudimageloader.core.ImageLoader imageLoader;
    private final boolean pauseOnFling;
    private final boolean pauseOnScroll;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PauseOnScrollListener(com.nostra13.dcloudimageloader.core.ImageLoader imageLoader, boolean z, boolean z2) {
        this(imageLoader, z, z2, null);
    }

    public PauseOnScrollListener(com.nostra13.dcloudimageloader.core.ImageLoader imageLoader, boolean z, boolean z2, android.widget.AbsListView.OnScrollListener onScrollListener) {
        this.imageLoader = imageLoader;
        this.pauseOnScroll = z;
        this.pauseOnFling = z2;
        this.externalListener = onScrollListener;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(android.widget.AbsListView absListView, int i) {
        if (i == 0) {
            this.imageLoader.resume();
        } else if (i == 1) {
            if (this.pauseOnScroll) {
                this.imageLoader.pause();
            }
        } else if (i == 2 && this.pauseOnFling) {
            this.imageLoader.pause();
        }
        android.widget.AbsListView.OnScrollListener onScrollListener = this.externalListener;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChanged(absListView, i);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(android.widget.AbsListView absListView, int i, int i2, int i3) {
        android.widget.AbsListView.OnScrollListener onScrollListener = this.externalListener;
        if (onScrollListener != null) {
            onScrollListener.onScroll(absListView, i, i2, i3);
        }
    }
}
