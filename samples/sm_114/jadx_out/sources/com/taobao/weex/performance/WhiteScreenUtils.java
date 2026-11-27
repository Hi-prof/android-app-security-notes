package com.taobao.weex.performance;

/* JADX INFO: loaded from: classes.dex */
public class WhiteScreenUtils {
    public static boolean doWhiteScreenCheck() {
        com.taobao.weex.adapter.IWXConfigAdapter wxConfigAdapter = com.taobao.weex.WXSDKManager.getInstance().getWxConfigAdapter();
        if (wxConfigAdapter == null) {
            return false;
        }
        double dDoubleValue = 100.0d;
        double dRandom = java.lang.Math.random() * 100.0d;
        try {
            dDoubleValue = java.lang.Double.valueOf(wxConfigAdapter.getConfig("wxapm", "new_ws_sampling", "100")).doubleValue();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return dRandom < dDoubleValue;
    }

    public static boolean isWhiteScreen(com.taobao.weex.WXSDKInstance wXSDKInstance) {
        if (wXSDKInstance == null) {
            return false;
        }
        android.view.View containerView = wXSDKInstance.getContainerView();
        if ((containerView instanceof android.view.ViewGroup) && !isInWhiteList(wXSDKInstance)) {
            return !hasLeafViewOrSizeIgnore(containerView, 3);
        }
        return false;
    }

    private static boolean isInWhiteList(com.taobao.weex.WXSDKInstance wXSDKInstance) {
        com.taobao.weex.adapter.IWXConfigAdapter wxConfigAdapter = com.taobao.weex.WXSDKManager.getInstance().getWxConfigAdapter();
        if (wxConfigAdapter == null) {
            return false;
        }
        java.lang.String config = wxConfigAdapter.getConfig("wxapm", "ws_white_list", null);
        if (android.text.TextUtils.isEmpty(config)) {
            return false;
        }
        try {
            for (java.lang.String str : config.split(";")) {
                if (wXSDKInstance.getBundleUrl() != null && wXSDKInstance.getBundleUrl().contains(str)) {
                    return true;
                }
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private static boolean hasLeafViewOrSizeIgnore(android.view.View view, int i) {
        if (!(view instanceof android.view.ViewGroup)) {
            return true;
        }
        if (i > 0) {
            if (view.getHeight() < 10 || view.getWidth() < 10) {
                return true;
            }
            i--;
        }
        android.view.ViewGroup viewGroup = (android.view.ViewGroup) view;
        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
            if (hasLeafViewOrSizeIgnore(viewGroup.getChildAt(i2), i)) {
                return true;
            }
        }
        return false;
    }

    public static java.lang.String takeViewTreeSnapShot(com.taobao.weex.WXSDKInstance wXSDKInstance) {
        if (wXSDKInstance == null) {
            return "nullInstance";
        }
        org.json.JSONObject jSONObjectGeViewDetailTreeMsg = geViewDetailTreeMsg(wXSDKInstance.getContainerView());
        if (jSONObjectGeViewDetailTreeMsg != null) {
            return jSONObjectGeViewDetailTreeMsg.toString();
        }
        return "";
    }

    private static org.json.JSONObject geViewDetailTreeMsg(android.view.View view) {
        if (view == null) {
            return null;
        }
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("width", view.getWidth());
            jSONObject.put("height", view.getHeight());
            int[] iArr = {-1, -1};
            view.getLocationOnScreen(iArr);
            jSONObject.put(com.taobao.weex.common.Constants.Name.X, iArr[0]);
            jSONObject.put(com.taobao.weex.common.Constants.Name.Y, iArr[1]);
            if (view instanceof android.view.ViewGroup) {
                jSONObject.put("type", view.getClass().getSimpleName());
                android.view.ViewGroup viewGroup = (android.view.ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    jSONObject.put("child_" + i, geViewDetailTreeMsg(viewGroup.getChildAt(i)));
                }
                return jSONObject;
            }
            jSONObject.put("type", view.getClass().getSimpleName());
            return jSONObject;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return jSONObject;
        }
    }
}
