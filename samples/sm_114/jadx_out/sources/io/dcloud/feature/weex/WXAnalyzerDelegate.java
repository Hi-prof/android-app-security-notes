package io.dcloud.feature.weex;

/* JADX INFO: loaded from: classes2.dex */
public final class WXAnalyzerDelegate {
    private static boolean ENABLE = false;
    private java.lang.Object mWXAnalyzer;

    public WXAnalyzerDelegate(android.content.Context context) {
        if (ENABLE && context != null) {
            try {
                this.mWXAnalyzer = java.lang.Class.forName("com.taobao.weex.analyzer.WeexDevOptions").getDeclaredConstructor(android.content.Context.class).newInstance(context);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void onCreate() {
        java.lang.Object obj = this.mWXAnalyzer;
        if (obj == null) {
            return;
        }
        try {
            obj.getClass().getDeclaredMethod("onCreate", null).invoke(this.mWXAnalyzer, null);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public void onStart() {
        java.lang.Object obj = this.mWXAnalyzer;
        if (obj == null) {
            return;
        }
        try {
            obj.getClass().getDeclaredMethod("onStart", null).invoke(this.mWXAnalyzer, null);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public void onResume() {
        java.lang.Object obj = this.mWXAnalyzer;
        if (obj == null) {
            return;
        }
        try {
            obj.getClass().getDeclaredMethod("onResume", null).invoke(this.mWXAnalyzer, null);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public void onPause() {
        java.lang.Object obj = this.mWXAnalyzer;
        if (obj == null) {
            return;
        }
        try {
            obj.getClass().getDeclaredMethod("onPause", null).invoke(this.mWXAnalyzer, null);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public void onStop() {
        java.lang.Object obj = this.mWXAnalyzer;
        if (obj == null) {
            return;
        }
        try {
            obj.getClass().getDeclaredMethod("onStop", null).invoke(this.mWXAnalyzer, null);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public void onDestroy() {
        java.lang.Object obj = this.mWXAnalyzer;
        if (obj == null) {
            return;
        }
        try {
            obj.getClass().getDeclaredMethod("onDestroy", null).invoke(this.mWXAnalyzer, null);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public void onWeexRenderSuccess(com.taobao.weex.WXSDKInstance wXSDKInstance) {
        java.lang.Object obj = this.mWXAnalyzer;
        if (obj == null || wXSDKInstance == null) {
            return;
        }
        try {
            obj.getClass().getDeclaredMethod("onWeexRenderSuccess", com.taobao.weex.WXSDKInstance.class).invoke(this.mWXAnalyzer, wXSDKInstance);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public boolean onKeyUp(int i, android.view.KeyEvent keyEvent) {
        java.lang.Object obj = this.mWXAnalyzer;
        if (obj == null) {
            return false;
        }
        try {
            return ((java.lang.Boolean) obj.getClass().getDeclaredMethod("onKeyUp", java.lang.Integer.TYPE, android.view.KeyEvent.class).invoke(this.mWXAnalyzer, java.lang.Integer.valueOf(i), keyEvent)).booleanValue();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void onException(com.taobao.weex.WXSDKInstance wXSDKInstance, java.lang.String str, java.lang.String str2) {
        if (this.mWXAnalyzer == null) {
            return;
        }
        if (android.text.TextUtils.isEmpty(str) && android.text.TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            this.mWXAnalyzer.getClass().getDeclaredMethod("onException", com.taobao.weex.WXSDKInstance.class, java.lang.String.class, java.lang.String.class).invoke(this.mWXAnalyzer, wXSDKInstance, str, str2);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public android.view.View onWeexViewCreated(com.taobao.weex.WXSDKInstance wXSDKInstance, android.view.View view) {
        java.lang.Object obj = this.mWXAnalyzer;
        if (obj == null || wXSDKInstance == null || view == null) {
            return null;
        }
        try {
            return (android.view.View) obj.getClass().getDeclaredMethod("onWeexViewCreated", com.taobao.weex.WXSDKInstance.class, android.view.View.class).invoke(this.mWXAnalyzer, wXSDKInstance, view);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return view;
        }
    }
}
