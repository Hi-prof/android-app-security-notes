package io.dcloud.common.DHInterface;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public interface ITitleNView {
    void addBackButton(java.lang.String str, java.lang.String str2, java.lang.String str3, org.json.JSONObject jSONObject);

    void addHomeButton(java.lang.String str, java.lang.String str2, java.lang.String str3);

    void addLeftButton(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.lang.String str7, java.lang.String str8, java.lang.String str9, java.lang.String str10, io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str11, java.lang.String str12, boolean z, java.lang.String str13, boolean z2, java.lang.String str14);

    void addRightButton(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.lang.String str7, java.lang.String str8, java.lang.String str9, java.lang.String str10, io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str11, java.lang.String str12, boolean z, java.lang.String str13, boolean z2, java.lang.String str14);

    void addSearchInput(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, boolean z, boolean z2, io.dcloud.common.DHInterface.IWebview iWebview);

    void clearButtons();

    void clearSearchInput();

    java.lang.String getBackgroundColor();

    java.lang.String getStatusBarColor();

    int getTitleColor();

    java.lang.String getTitleNViewSearchInputText();

    void reMeasure();

    void removeBackButton();

    void removeHomeButton();

    void removeSplitLine();

    void setBackButtonColor(java.lang.String str, java.lang.String str2, java.lang.String str3);

    void setBackgroundColor(java.lang.String str);

    void setBackgroundImage(java.lang.String str);

    void setBackgroundRepeat(java.lang.String str);

    void setBadgeText(org.json.JSONObject jSONObject, boolean z);

    void setButtonColorByIndex(int i, java.lang.String str, java.lang.String str2, java.lang.String str3);

    void setButtonsColor(java.lang.String str, java.lang.String str2, java.lang.String str3);

    void setCapsuleButtonStyle(org.json.JSONObject jSONObject);

    void setHomeButtonColor(java.lang.String str, java.lang.String str2, java.lang.String str3);

    void setIconSubTitleStyle(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.lang.String str7, java.lang.String str8, java.lang.String str9);

    void setProgress(java.lang.String str, java.lang.String str2);

    void setRedDot(org.json.JSONObject jSONObject, boolean z);

    void setRedDotColor(int i);

    void setSearchInputColor(java.lang.String str);

    void setSearchInputFocus(boolean z);

    void setShadow(org.json.JSONObject jSONObject);

    void setSplitLine(java.lang.String str, java.lang.String str2);

    void setStatusBarColor(int i);

    void setTitle(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.lang.String str7, java.lang.String str8, java.lang.String str9, java.lang.String str10, java.lang.String str11, java.lang.String str12);

    void setTitleAlign(java.lang.String str);

    void setTitleColor(int i);

    void setTitleColor(java.lang.String str);

    boolean setTitleNViewButtonStyle(int i, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.lang.String str7, java.lang.String str8, java.lang.String str9, io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str10, java.lang.String str11, java.lang.String str12, java.lang.String str13, java.lang.String str14, java.lang.String str15, java.lang.String str16, java.lang.String str17);

    void setTitleNViewFocusable(boolean z);

    void setTitleNViewPadding(int i, int i2, int i3, int i4);

    void setTitleNViewSearchInputText(java.lang.String str);

    void setTitleOverflow(java.lang.String str);

    void setTitleSize(java.lang.String str);

    void setTitleText(java.lang.String str);

    void startProgress();

    void stopProgress();
}
