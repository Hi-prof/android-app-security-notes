package io.dcloud.weex;

/* JADX INFO: loaded from: classes2.dex */
public class ViewHover {
    public static final java.lang.String VIEW_HOVER_EVENT = "view_hover_event";
    private com.taobao.weex.ui.component.WXComponent component;
    private android.os.Handler handler;
    private com.alibaba.fastjson.JSONObject hoverClass;
    private int hoverStartTime;
    private int hoverStayTime;
    private boolean hoverStopPropagation;
    private boolean isHover;
    private boolean isReceiveTouch;
    private java.util.Map<java.lang.String, java.lang.Object> originalStyles;
    public java.lang.Runnable touchEndRunnable;
    public java.lang.Runnable touchStartRunnable;

    public ViewHover(com.taobao.weex.ui.component.WXComponent wXComponent) {
        this(wXComponent, null);
    }

    public ViewHover(com.taobao.weex.ui.component.WXComponent wXComponent, com.alibaba.fastjson.JSONObject jSONObject) {
        this.hoverStopPropagation = false;
        this.hoverClass = null;
        this.hoverStartTime = 50;
        this.hoverStayTime = com.facebook.common.statfs.StatFsHelper.DEFAULT_DISK_YELLOW_LEVEL_IN_MB;
        this.isHover = false;
        this.isReceiveTouch = true;
        this.handler = new android.os.Handler();
        this.touchStartRunnable = new java.lang.Runnable() { // from class: io.dcloud.weex.ViewHover.1
            @Override // java.lang.Runnable
            public void run() {
                if (io.dcloud.weex.ViewHover.this.isHover || io.dcloud.weex.ViewHover.this.component == null || io.dcloud.weex.ViewHover.this.component.getInstance() == null) {
                    return;
                }
                io.dcloud.weex.ViewHover viewHover = io.dcloud.weex.ViewHover.this;
                viewHover.originalStyles = viewHover.component.getStyles().mo401clone();
                io.dcloud.weex.ViewHover.this.component.setHoverClassStatus(true);
            }
        };
        this.touchEndRunnable = new java.lang.Runnable() { // from class: io.dcloud.weex.ViewHover.2
            @Override // java.lang.Runnable
            public void run() {
                if (io.dcloud.weex.ViewHover.this.component == null || io.dcloud.weex.ViewHover.this.component.getInstance() == null) {
                    return;
                }
                io.dcloud.weex.ViewHover.this.component.setHoverClassStatus(false);
                io.dcloud.weex.ViewHover.this.isHover = false;
            }
        };
        update(jSONObject);
        this.component = wXComponent;
    }

    public void update(com.alibaba.fastjson.JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        com.alibaba.fastjson.JSONObject jSONObject2 = this.hoverClass;
        if (jSONObject2 == null) {
            this.hoverClass = jSONObject;
        } else {
            jSONObject2.putAll(jSONObject);
        }
    }

    public boolean isHoverStopPropagation() {
        return this.hoverStopPropagation;
    }

    public void setHoverStopPropagation(boolean z) {
        this.hoverStopPropagation = z;
    }

    public int getHoverStartTime() {
        return this.hoverStartTime;
    }

    public void setHoverStartTime(int i) {
        this.hoverStartTime = i;
    }

    public int getHoverStayTime() {
        return this.hoverStayTime;
    }

    public void setHoverStayTime(int i) {
        this.hoverStayTime = i;
    }

    public void handleMotionEvent(com.taobao.weex.ui.view.gesture.WXGestureType wXGestureType, android.view.MotionEvent motionEvent) {
        if (this.hoverClass == null || !this.isReceiveTouch) {
            return;
        }
        java.lang.String string = wXGestureType.toString();
        string.hashCode();
        switch (string) {
            case "touchstart":
                this.handler.removeCallbacks(this.touchEndRunnable);
                this.handler.removeCallbacks(this.touchStartRunnable);
                this.handler.postDelayed(this.touchStartRunnable, this.hoverStartTime);
                break;
            case "touchend":
                this.isHover = true;
                this.handler.removeCallbacks(this.touchEndRunnable);
                this.handler.postDelayed(this.touchEndRunnable, this.hoverStayTime);
                break;
            case "touchcancel":
                this.isHover = true;
                this.handler.removeCallbacks(this.touchEndRunnable);
                this.handler.postDelayed(this.touchEndRunnable, this.hoverStayTime);
                break;
        }
    }

    public java.util.Map<java.lang.String, java.lang.Object> updateStatusAndGetUpdateStyles(boolean z) {
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        if (z) {
            return this.hoverClass;
        }
        if (this.originalStyles != null) {
            java.util.Set<java.lang.String> setKeySet = this.hoverClass.keySet();
            jSONObject = new com.alibaba.fastjson.JSONObject();
            for (java.lang.String str : setKeySet) {
                if (this.originalStyles.containsKey(str)) {
                    jSONObject.put(str, this.originalStyles.get(str));
                } else {
                    jSONObject.put(str, "");
                }
            }
        }
        return jSONObject;
    }

    public void setReceiveTouch(boolean z) {
        this.isReceiveTouch = z;
    }

    public void destroy() {
        this.component = null;
        this.originalStyles = null;
    }
}
