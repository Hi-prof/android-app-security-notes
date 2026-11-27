package com.dcloud.android.v4.widget;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public interface IRefreshAble {

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public interface OnRefreshListener {
        public static final int STATE_REFRESHING = 3;

        void onRefresh(int i);
    }

    void beginRefresh();

    void endRefresh();

    boolean hasRefreshOperator();

    boolean isRefreshEnable();

    boolean isRefreshing();

    void onInit(android.view.ViewGroup viewGroup, android.view.View view, com.dcloud.android.v4.widget.IRefreshAble.OnRefreshListener onRefreshListener);

    void onResize(int i, int i2, float f);

    void onSelfDraw(android.graphics.Canvas canvas);

    boolean onSelfTouchEvent(android.view.MotionEvent motionEvent);

    void parseData(org.json.JSONObject jSONObject, int i, int i2, float f);

    void setRefreshEnable(boolean z);
}
