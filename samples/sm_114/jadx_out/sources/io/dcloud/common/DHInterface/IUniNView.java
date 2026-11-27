package io.dcloud.common.DHInterface;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public interface IUniNView {
    void beginPullRefresh();

    void endPullToRefresh();

    java.lang.String evalJs(java.lang.String str, int i);

    boolean fireGlobalEvent(java.lang.String str, java.util.Map<java.lang.String, java.lang.Object> map);

    java.lang.String getType();

    void initRefresh(org.json.JSONObject jSONObject);

    void loadTemplate(org.json.JSONObject jSONObject);

    android.view.ViewGroup obtainMainView();

    void onDestroy();

    void reload();

    void titleNViewRefresh();
}
