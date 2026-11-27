package io.dcloud.feature.nativeObj.richtext.span;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public interface ClickSpanAble {
    java.lang.String getHref();

    java.lang.String getOnClickEvent();

    boolean hasClickEvent();

    void onClick(android.view.View view, io.dcloud.common.DHInterface.IWebview iWebview);
}
