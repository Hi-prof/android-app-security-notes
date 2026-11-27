package com.dcloud.android.v4.view;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
class WindowInsetsCompatApi21 extends com.dcloud.android.v4.view.WindowInsetsCompat {
    private final android.view.WindowInsets mSource;

    WindowInsetsCompatApi21(android.view.WindowInsets windowInsets) {
        this.mSource = windowInsets;
    }

    @Override // com.dcloud.android.v4.view.WindowInsetsCompat
    public com.dcloud.android.v4.view.WindowInsetsCompat consumeStableInsets() {
        return new com.dcloud.android.v4.view.WindowInsetsCompatApi21(this.mSource.consumeStableInsets());
    }

    @Override // com.dcloud.android.v4.view.WindowInsetsCompat
    public com.dcloud.android.v4.view.WindowInsetsCompat consumeSystemWindowInsets() {
        return new com.dcloud.android.v4.view.WindowInsetsCompatApi21(this.mSource.consumeSystemWindowInsets());
    }

    @Override // com.dcloud.android.v4.view.WindowInsetsCompat
    public int getStableInsetBottom() {
        return this.mSource.getStableInsetBottom();
    }

    @Override // com.dcloud.android.v4.view.WindowInsetsCompat
    public int getStableInsetLeft() {
        return this.mSource.getStableInsetLeft();
    }

    @Override // com.dcloud.android.v4.view.WindowInsetsCompat
    public int getStableInsetRight() {
        return this.mSource.getStableInsetRight();
    }

    @Override // com.dcloud.android.v4.view.WindowInsetsCompat
    public int getStableInsetTop() {
        return this.mSource.getStableInsetTop();
    }

    @Override // com.dcloud.android.v4.view.WindowInsetsCompat
    public int getSystemWindowInsetBottom() {
        return this.mSource.getSystemWindowInsetBottom();
    }

    @Override // com.dcloud.android.v4.view.WindowInsetsCompat
    public int getSystemWindowInsetLeft() {
        return this.mSource.getSystemWindowInsetLeft();
    }

    @Override // com.dcloud.android.v4.view.WindowInsetsCompat
    public int getSystemWindowInsetRight() {
        return this.mSource.getSystemWindowInsetRight();
    }

    @Override // com.dcloud.android.v4.view.WindowInsetsCompat
    public int getSystemWindowInsetTop() {
        return this.mSource.getSystemWindowInsetTop();
    }

    @Override // com.dcloud.android.v4.view.WindowInsetsCompat
    public boolean hasInsets() {
        return this.mSource.hasInsets();
    }

    @Override // com.dcloud.android.v4.view.WindowInsetsCompat
    public boolean hasStableInsets() {
        return this.mSource.hasStableInsets();
    }

    @Override // com.dcloud.android.v4.view.WindowInsetsCompat
    public boolean hasSystemWindowInsets() {
        return this.mSource.hasSystemWindowInsets();
    }

    @Override // com.dcloud.android.v4.view.WindowInsetsCompat
    public boolean isConsumed() {
        return this.mSource.isConsumed();
    }

    @Override // com.dcloud.android.v4.view.WindowInsetsCompat
    public boolean isRound() {
        return this.mSource.isRound();
    }

    @Override // com.dcloud.android.v4.view.WindowInsetsCompat
    public com.dcloud.android.v4.view.WindowInsetsCompat replaceSystemWindowInsets(int i, int i2, int i3, int i4) {
        return new com.dcloud.android.v4.view.WindowInsetsCompatApi21(this.mSource.replaceSystemWindowInsets(i, i2, i3, i4));
    }

    android.view.WindowInsets unwrap() {
        return this.mSource;
    }

    @Override // com.dcloud.android.v4.view.WindowInsetsCompat
    public com.dcloud.android.v4.view.WindowInsetsCompat replaceSystemWindowInsets(android.graphics.Rect rect) {
        return new com.dcloud.android.v4.view.WindowInsetsCompatApi21(this.mSource.replaceSystemWindowInsets(rect));
    }
}
