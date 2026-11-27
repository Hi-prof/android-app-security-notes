package com.dcloud.android.v4.view;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public interface TintableBackgroundView {
    android.content.res.ColorStateList getSupportBackgroundTintList();

    android.graphics.PorterDuff.Mode getSupportBackgroundTintMode();

    void setSupportBackgroundTintList(android.content.res.ColorStateList colorStateList);

    void setSupportBackgroundTintMode(android.graphics.PorterDuff.Mode mode);
}
