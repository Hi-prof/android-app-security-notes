package io.dcloud.common.DHInterface;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public interface INativeView {
    void attachToViewGroup(io.dcloud.common.DHInterface.IFrameView iFrameView);

    int getInnerHeight();

    java.lang.String getStyleBackgroundColor();

    int getStyleLeft();

    int getStyleWidth();

    java.lang.String getViewId();

    java.lang.String getViewType();

    java.lang.String getViewUUId();

    boolean isAnimate();

    boolean isDock();

    boolean isDockTop();

    boolean isStatusBar();

    android.view.View obtanMainView();

    void setNativeShowType(boolean z);

    void setStyleBackgroundColor(int i);

    void setStyleBackgroundColor(java.lang.String str);

    void setStyleLeft(int i);

    void setWebAnimationRuning(boolean z);

    org.json.JSONObject toJSON();
}
