package com.taobao.weex;

/* JADX INFO: loaded from: classes.dex */
@java.lang.Deprecated
public interface IWXActivityStateListener {
    boolean onActivityBack();

    void onActivityCreate();

    void onActivityDestroy();

    void onActivityPause();

    void onActivityResume();

    void onActivityStart();

    void onActivityStop();
}
