package io.dcloud.feature.weex.extend;

/* JADX INFO: loaded from: classes2.dex */
public class DCTabBarModule extends com.taobao.weex.common.WXModule {
    @com.taobao.weex.annotation.JSMethod
    public void append(com.alibaba.fastjson.JSONObject jSONObject, final com.taobao.weex.bridge.JSCallback jSCallback) {
        io.dcloud.common.core.ui.TabBarWebview launchTabBar = io.dcloud.common.core.ui.TabBarWebviewMgr.getInstance().getLaunchTabBar();
        if (launchTabBar != null) {
            launchTabBar.append(jSONObject.getString("id"), new io.dcloud.common.DHInterface.ICallBack() { // from class: io.dcloud.feature.weex.extend.DCTabBarModule.1
                @Override // io.dcloud.common.DHInterface.ICallBack
                public java.lang.Object onCallBack(int i, java.lang.Object obj) {
                    java.util.HashMap map = new java.util.HashMap();
                    map.put("code", java.lang.Integer.valueOf(i));
                    jSCallback.invoke(map);
                    return null;
                }
            });
        }
    }

    @com.taobao.weex.annotation.JSMethod(uiThread = false)
    public boolean isValid() {
        return io.dcloud.common.core.ui.TabBarWebviewMgr.getInstance().getLaunchTabBar() != null;
    }

    @com.taobao.weex.annotation.JSMethod
    public void hideTabBar(com.alibaba.fastjson.JSONObject jSONObject) {
        io.dcloud.common.core.ui.TabBarWebview launchTabBar = io.dcloud.common.core.ui.TabBarWebviewMgr.getInstance().getLaunchTabBar();
        if (launchTabBar != null) {
            launchTabBar.hideTabBar(jSONObject);
        }
    }

    @com.taobao.weex.annotation.JSMethod
    public void showTabBar(com.alibaba.fastjson.JSONObject jSONObject) {
        io.dcloud.common.core.ui.TabBarWebview launchTabBar = io.dcloud.common.core.ui.TabBarWebviewMgr.getInstance().getLaunchTabBar();
        if (launchTabBar != null) {
            launchTabBar.showTabBar(jSONObject);
        }
    }

    @com.taobao.weex.annotation.JSMethod
    public void setTabBarStyle(com.alibaba.fastjson.JSONObject jSONObject) {
        io.dcloud.common.core.ui.TabBarWebview launchTabBar = io.dcloud.common.core.ui.TabBarWebviewMgr.getInstance().getLaunchTabBar();
        if (launchTabBar != null) {
            launchTabBar.setStyle(jSONObject);
        }
    }

    @com.taobao.weex.annotation.JSMethod
    public void setTabBarItem(com.alibaba.fastjson.JSONObject jSONObject) {
        io.dcloud.common.core.ui.TabBarWebview launchTabBar = io.dcloud.common.core.ui.TabBarWebviewMgr.getInstance().getLaunchTabBar();
        if (launchTabBar != null) {
            launchTabBar.setItem(jSONObject);
            launchTabBar.updateMidButton(null);
        }
    }

    @com.taobao.weex.annotation.JSMethod
    public void setTabBarBadge(com.alibaba.fastjson.JSONObject jSONObject) {
        io.dcloud.common.core.ui.TabBarWebview launchTabBar = io.dcloud.common.core.ui.TabBarWebviewMgr.getInstance().getLaunchTabBar();
        if (launchTabBar != null) {
            launchTabBar.setTabBarBadge(jSONObject);
        }
    }

    @com.taobao.weex.annotation.JSMethod
    public void removeTabBarBadge(com.alibaba.fastjson.JSONObject jSONObject) {
        io.dcloud.common.core.ui.TabBarWebview launchTabBar = io.dcloud.common.core.ui.TabBarWebviewMgr.getInstance().getLaunchTabBar();
        if (launchTabBar == null || !launchTabBar.isVisible()) {
            return;
        }
        launchTabBar.removeTabBarBadge(jSONObject);
    }

    @com.taobao.weex.annotation.JSMethod
    public void showTabBarRedDot(com.alibaba.fastjson.JSONObject jSONObject) {
        io.dcloud.common.core.ui.TabBarWebview launchTabBar = io.dcloud.common.core.ui.TabBarWebviewMgr.getInstance().getLaunchTabBar();
        if (launchTabBar == null || !launchTabBar.isVisible()) {
            return;
        }
        launchTabBar.showTabBarRedDot(jSONObject);
    }

    @com.taobao.weex.annotation.JSMethod
    public void hideTabBarRedDot(com.alibaba.fastjson.JSONObject jSONObject) {
        io.dcloud.common.core.ui.TabBarWebview launchTabBar = io.dcloud.common.core.ui.TabBarWebviewMgr.getInstance().getLaunchTabBar();
        if (launchTabBar == null || !launchTabBar.isVisible()) {
            return;
        }
        launchTabBar.hideTabBarRedDot(jSONObject);
    }

    @com.taobao.weex.annotation.JSMethod
    public void setMask(com.alibaba.fastjson.JSONObject jSONObject) {
        io.dcloud.common.core.ui.TabBarWebview launchTabBar = io.dcloud.common.core.ui.TabBarWebviewMgr.getInstance().getLaunchTabBar();
        if (launchTabBar != null) {
            launchTabBar.setMask(jSONObject);
        }
    }

    @com.taobao.weex.annotation.JSMethod(uiThread = false)
    public boolean isTabBarVisible() {
        io.dcloud.common.core.ui.TabBarWebview launchTabBar = io.dcloud.common.core.ui.TabBarWebviewMgr.getInstance().getLaunchTabBar();
        return launchTabBar != null && launchTabBar.isVisible();
    }

    @com.taobao.weex.annotation.JSMethod(uiThread = false)
    public java.lang.String getTabBarHeight() {
        return io.dcloud.common.core.ui.TabBarWebviewMgr.getInstance().getLaunchTabBar().getTabBarHeight();
    }

    @com.taobao.weex.annotation.JSMethod
    public void switchSelect(com.alibaba.fastjson.JSONObject jSONObject) {
        io.dcloud.common.core.ui.TabBarWebview launchTabBar = io.dcloud.common.core.ui.TabBarWebviewMgr.getInstance().getLaunchTabBar();
        if (launchTabBar != null) {
            launchTabBar.switchSelect(jSONObject.getIntValue("index"));
        }
    }

    @com.taobao.weex.annotation.JSMethod
    public void setTabBarItems(com.alibaba.fastjson.JSONObject jSONObject) {
        com.alibaba.fastjson.JSONObject jSONObject2;
        com.alibaba.fastjson.JSONArray jSONArray;
        io.dcloud.common.core.ui.TabBarWebview launchTabBar = io.dcloud.common.core.ui.TabBarWebviewMgr.getInstance().getLaunchTabBar();
        if (launchTabBar != null) {
            if (jSONObject.containsKey(com.taobao.weex.ui.component.WXBasicComponentType.LIST) && (jSONArray = jSONObject.getJSONArray(com.taobao.weex.ui.component.WXBasicComponentType.LIST)) != null) {
                int size = jSONArray.size();
                for (int i = 0; i < size; i++) {
                    com.alibaba.fastjson.JSONObject jSONObject3 = (com.alibaba.fastjson.JSONObject) jSONArray.get(i);
                    if (jSONObject3 != null) {
                        jSONObject3.put("index", (java.lang.Object) java.lang.Integer.valueOf(i));
                        launchTabBar.setItem(jSONObject3);
                    }
                }
            }
            if (jSONObject.containsKey("midButton") && (jSONObject2 = jSONObject.getJSONObject("midButton")) != null) {
                launchTabBar.updateMidButton(jSONObject2);
            } else {
                launchTabBar.updateMidButton(null);
            }
        }
    }

    @com.taobao.weex.annotation.JSMethod
    public void onClick(final com.taobao.weex.bridge.JSCallback jSCallback) {
        io.dcloud.common.core.ui.TabBarWebview launchTabBar = io.dcloud.common.core.ui.TabBarWebviewMgr.getInstance().getLaunchTabBar();
        if (launchTabBar != null) {
            launchTabBar.setClickCallBack(new io.dcloud.common.DHInterface.ICallBack() { // from class: io.dcloud.feature.weex.extend.DCTabBarModule.2
                @Override // io.dcloud.common.DHInterface.ICallBack
                public java.lang.Object onCallBack(int i, java.lang.Object obj) {
                    com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
                    jSONObject.put("index", (java.lang.Object) java.lang.Integer.valueOf(i));
                    jSCallback.invokeAndKeepAlive(jSONObject);
                    return null;
                }
            });
        }
    }

    @com.taobao.weex.annotation.JSMethod
    public void onDoubleClick(final com.taobao.weex.bridge.JSCallback jSCallback) {
        io.dcloud.common.core.ui.TabBarWebview launchTabBar = io.dcloud.common.core.ui.TabBarWebviewMgr.getInstance().getLaunchTabBar();
        if (launchTabBar != null) {
            launchTabBar.setDoubleClickCallBack(new io.dcloud.common.DHInterface.ICallBack() { // from class: io.dcloud.feature.weex.extend.DCTabBarModule.3
                @Override // io.dcloud.common.DHInterface.ICallBack
                public java.lang.Object onCallBack(int i, java.lang.Object obj) {
                    com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
                    jSONObject.put("index", (java.lang.Object) java.lang.Integer.valueOf(i));
                    jSCallback.invokeAndKeepAlive(jSONObject);
                    return null;
                }
            });
        }
    }

    @com.taobao.weex.annotation.JSMethod
    public void onMidButtonClick(final com.taobao.weex.bridge.JSCallback jSCallback) {
        io.dcloud.common.core.ui.TabBarWebview launchTabBar = io.dcloud.common.core.ui.TabBarWebviewMgr.getInstance().getLaunchTabBar();
        if (launchTabBar != null) {
            launchTabBar.setMidButtonClickCallBack(new io.dcloud.common.DHInterface.ICallBack() { // from class: io.dcloud.feature.weex.extend.DCTabBarModule.4
                @Override // io.dcloud.common.DHInterface.ICallBack
                public java.lang.Object onCallBack(int i, java.lang.Object obj) {
                    com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
                    jSONObject.put("index", (java.lang.Object) java.lang.Integer.valueOf(i));
                    jSCallback.invokeAndKeepAlive(jSONObject);
                    return null;
                }
            });
        }
    }

    @com.taobao.weex.annotation.JSMethod
    public void onMaskClick(final com.taobao.weex.bridge.JSCallback jSCallback) {
        io.dcloud.common.core.ui.TabBarWebview launchTabBar = io.dcloud.common.core.ui.TabBarWebviewMgr.getInstance().getLaunchTabBar();
        if (launchTabBar != null) {
            launchTabBar.setMaskButtonClickCallBack(new io.dcloud.common.DHInterface.ICallBack() { // from class: io.dcloud.feature.weex.extend.DCTabBarModule.5
                @Override // io.dcloud.common.DHInterface.ICallBack
                public java.lang.Object onCallBack(int i, java.lang.Object obj) {
                    jSCallback.invokeAndKeepAlive(new com.alibaba.fastjson.JSONObject());
                    return null;
                }
            });
        }
    }
}
