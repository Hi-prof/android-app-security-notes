package io.dcloud.feature.nativeObj.richtext;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public interface IAssets {
    java.io.InputStream convert2InputStream(java.lang.String str);

    float convertHeight(java.lang.String str, float f);

    float convertWidth(java.lang.String str, float f);

    int getDefaultColor(boolean z);

    java.lang.String getOnClickCallBackId();

    float getScale();

    boolean isClick();

    void loadResource(io.dcloud.feature.nativeObj.richtext.dom.ImgDomElement.AsycLoader asycLoader);

    void setClick(boolean z);

    void setOnClickCallBackId(java.lang.String str);

    int stringToColor(java.lang.String str);
}
