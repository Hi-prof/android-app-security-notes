package io.dcloud.common.adapter.util;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class ViewRect {
    public static final int DEFAULT_MARGIN = 0;
    public static byte DOCK_BOTTOM = 6;
    public static byte DOCK_LEFT = 3;
    public static byte DOCK_RIGHT = 4;
    public static byte DOCK_TOP = 5;
    public static byte POSITION_ABSOLUTE = 1;
    public static byte POSITION_DOCK = 2;
    public static byte POSITION_STATIC;
    public int anim_left;
    public int anim_top;
    public int bottom;
    public int height;
    public int left;
    public java.lang.String mStatusbarColor;
    public int right;
    public int top;
    public int width;
    private io.dcloud.common.adapter.util.ViewRect mParentViewRect = null;
    private io.dcloud.common.adapter.util.ViewRect mFrameParentViewRect = null;
    private java.util.ArrayList<io.dcloud.common.adapter.util.ViewRect> mRelViewRectDockSet = null;
    public float mWebviewScale = 1.0f;
    public java.lang.String margin = java.lang.String.valueOf(0);
    public boolean isStatusbar = false;
    private byte mPosition = POSITION_STATIC;
    private byte mDock = DOCK_TOP;
    public org.json.JSONObject mJsonViewOption = io.dcloud.common.util.JSONUtil.createJSONObject("{}");
    public boolean isStatusbarDodifyHeight = false;
    public boolean isNotHeightFullScreen = false;
    private boolean doUpdate = false;
    public boolean allowUpdate = true;

    public static void layoutDockViewRect(io.dcloud.common.adapter.util.ViewRect viewRect, io.dcloud.common.adapter.util.ViewRect viewRect2, boolean z) {
        io.dcloud.common.adapter.util.ViewRect viewRect3 = viewRect2.mParentViewRect;
        org.json.JSONObject jSONObject = viewRect2.mJsonViewOption;
        java.lang.String string = io.dcloud.common.util.JSONUtil.getString(jSONObject, "position");
        if (io.dcloud.common.util.PdrUtil.isEmpty(string)) {
            return;
        }
        if (io.dcloud.common.constant.AbsoluteConst.JSON_VALUE_POSITION_ABSOLUTE.equals(string)) {
            viewRect2.mPosition = POSITION_ABSOLUTE;
            return;
        }
        if (!"dock".equals(string)) {
            if ("static".equals(string)) {
                viewRect2.mPosition = POSITION_STATIC;
                return;
            }
            return;
        }
        viewRect2.mPosition = POSITION_DOCK;
        java.lang.String string2 = io.dcloud.common.util.JSONUtil.getString(jSONObject, "dock");
        if (!io.dcloud.common.util.PdrUtil.isEmpty(string2)) {
            if ("bottom".equals(string2)) {
                viewRect2.mDock = DOCK_BOTTOM;
            } else if ("top".equals(string2)) {
                viewRect2.mDock = DOCK_TOP;
            } else if ("left".equals(string2)) {
                viewRect2.mDock = DOCK_LEFT;
            } else if ("right".equals(string2)) {
                viewRect2.mDock = DOCK_RIGHT;
            }
        }
        java.lang.String string3 = io.dcloud.common.util.JSONUtil.getString(jSONObject, "left");
        java.lang.String string4 = io.dcloud.common.util.JSONUtil.getString(jSONObject, "top");
        java.lang.String string5 = io.dcloud.common.util.JSONUtil.getString(jSONObject, "width");
        java.lang.String string6 = io.dcloud.common.util.JSONUtil.getString(jSONObject, "height");
        boolean zIsEmpty = io.dcloud.common.util.PdrUtil.isEmpty(string3);
        boolean zIsEmpty2 = io.dcloud.common.util.PdrUtil.isEmpty(string4);
        boolean zIsEmpty3 = io.dcloud.common.util.PdrUtil.isEmpty(string5);
        boolean zIsEmpty4 = io.dcloud.common.util.PdrUtil.isEmpty(string6);
        viewRect2.width = io.dcloud.common.util.PdrUtil.convertToScreenInt(string5, viewRect3.width, viewRect.width, viewRect3.mWebviewScale);
        int iConvertToScreenInt = io.dcloud.common.util.PdrUtil.convertToScreenInt(string6, viewRect3.height, viewRect.height, viewRect3.mWebviewScale);
        viewRect2.height = iConvertToScreenInt;
        int i = viewRect2.width;
        if (i < 0) {
            i = viewRect2.mParentViewRect.width;
        }
        viewRect2.width = i;
        if (iConvertToScreenInt < 0) {
            iConvertToScreenInt = viewRect2.mParentViewRect.height;
        }
        viewRect2.height = iConvertToScreenInt;
        int i2 = viewRect.top;
        int i3 = viewRect.left;
        int i4 = viewRect.width;
        int i5 = viewRect.height;
        int iConvertToScreenInt2 = io.dcloud.common.util.PdrUtil.convertToScreenInt(string3, viewRect3.width, i3, viewRect3.mWebviewScale);
        int iConvertToScreenInt3 = io.dcloud.common.util.PdrUtil.convertToScreenInt(string4, viewRect3.height, viewRect.top, viewRect3.mWebviewScale);
        byte b = viewRect2.mDock;
        if (b == DOCK_BOTTOM) {
            if (zIsEmpty2 || !zIsEmpty4) {
                int i6 = viewRect.height - viewRect2.height;
                viewRect.height = i6;
                iConvertToScreenInt3 = i6 + viewRect.top;
            } else {
                viewRect.height = iConvertToScreenInt3 - viewRect.top;
                viewRect2.height -= iConvertToScreenInt3;
            }
        } else if (b == DOCK_RIGHT) {
            if (zIsEmpty || !zIsEmpty3) {
                int i7 = viewRect.width - viewRect2.width;
                viewRect.width = i7;
                iConvertToScreenInt2 = i7 + viewRect.left;
            } else {
                viewRect.width = iConvertToScreenInt2 - viewRect.left;
                viewRect2.width -= iConvertToScreenInt2;
            }
        } else if (b == DOCK_LEFT) {
            int i8 = viewRect2.width;
            viewRect.left = i8;
            viewRect.width -= i8;
            iConvertToScreenInt2 = 0;
        } else if (b == DOCK_TOP) {
            int i9 = viewRect2.height;
            viewRect.top = i9;
            viewRect.height -= i9;
            iConvertToScreenInt3 = 0;
        }
        if (!z) {
            viewRect.left = i3;
            viewRect.top = i2;
            viewRect.width = i4;
            viewRect.height = i5;
        }
        viewRect2.left = iConvertToScreenInt2;
        viewRect2.top = iConvertToScreenInt3;
    }

    private void layoutWithRelViewRect() {
        java.util.ArrayList<io.dcloud.common.adapter.util.ViewRect> arrayList = this.mRelViewRectDockSet;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            io.dcloud.common.adapter.util.ViewRect viewRect = arrayList.get(i);
            i++;
            layoutDockViewRect(this, viewRect);
        }
    }

    public void checkValueIsPercentage(java.lang.String str, int i, int i2, boolean z, boolean z2) {
        try {
            if (!this.mJsonViewOption.isNull(str) || z) {
                if ((this.mJsonViewOption.isNull(str) || this.mJsonViewOption.getString(str).indexOf("%") < 0) && !z2) {
                    this.mJsonViewOption.put(str, i / this.mWebviewScale);
                    return;
                }
                if (i2 > 0) {
                    this.mJsonViewOption.put(str, ((i * 100) / i2) + "%");
                }
            }
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
    }

    public void commitUpdate2JSONObject(boolean z, boolean z2) {
        io.dcloud.common.adapter.util.ViewRect viewRect = this.mFrameParentViewRect;
        int i = viewRect != null ? viewRect.width : this.mParentViewRect.width;
        if (viewRect == null) {
            viewRect = this.mParentViewRect;
        }
        int i2 = viewRect.height;
        checkValueIsPercentage("left", this.left, i, z, z2);
        checkValueIsPercentage("top", this.top, i2, z, z2);
        checkValueIsPercentage("width", this.width, i, z, z2);
        checkValueIsPercentage("height", this.height, i2, z, z2);
        checkValueIsPercentage("right", this.right, i, z, z2);
        checkValueIsPercentage("bottom", this.bottom, i2, z, z2);
    }

    public void delRelViewRect(io.dcloud.common.adapter.util.ViewRect viewRect) {
        java.util.ArrayList<io.dcloud.common.adapter.util.ViewRect> arrayList = this.mRelViewRectDockSet;
        if (arrayList != null) {
            arrayList.remove(viewRect);
        }
    }

    public io.dcloud.common.adapter.util.ViewRect getParentViewRect() {
        return this.mParentViewRect;
    }

    public boolean hasHeightAbsolutevalue() {
        org.json.JSONObject jSONObject = this.mJsonViewOption;
        if (jSONObject == null || !jSONObject.has("height") || this.mJsonViewOption.isNull("height")) {
            return this.mJsonViewOption.has("bottom") && this.mJsonViewOption.has("top");
        }
        return !io.dcloud.common.util.JSONUtil.getString(this.mJsonViewOption, "height").endsWith("%");
    }

    public boolean hasRectChanged(io.dcloud.common.adapter.util.ViewRect viewRect, io.dcloud.common.adapter.util.ViewRect viewRect2) {
        return (viewRect.left == viewRect2.left && viewRect.top == viewRect2.top && viewRect.height == viewRect2.height && viewRect.width == viewRect2.width) ? false : true;
    }

    public boolean isBottomAbsolute() {
        org.json.JSONObject jSONObject = this.mJsonViewOption;
        return jSONObject != null && jSONObject.has("bottom");
    }

    public boolean isHeightAbsolute() {
        org.json.JSONObject jSONObject = this.mJsonViewOption;
        if (jSONObject == null) {
            return true;
        }
        if (jSONObject.has("height") && !this.mJsonViewOption.isNull("height")) {
            return !io.dcloud.common.util.JSONUtil.getString(this.mJsonViewOption, "height").equals("100%");
        }
        if (this.mJsonViewOption.has("bottom") && this.mJsonViewOption.has("top")) {
            return true;
        }
        if (!this.mJsonViewOption.has("height")) {
            this.mJsonViewOption.isNull("height");
        }
        return false;
    }

    public void onScreenChanged(int i, int i2) {
        updateViewData(this.mJsonViewOption, i, i2);
    }

    public void putRelViewRect(io.dcloud.common.adapter.util.ViewRect viewRect) {
        if (this.mRelViewRectDockSet == null) {
            this.mRelViewRectDockSet = new java.util.ArrayList<>();
        }
        this.mRelViewRectDockSet.add(viewRect);
    }

    public void setFrameParentViewRect(io.dcloud.common.adapter.util.ViewRect viewRect) {
        this.mFrameParentViewRect = null;
    }

    public void setParentViewRect(io.dcloud.common.adapter.util.ViewRect viewRect) {
        this.mParentViewRect = viewRect;
    }

    public void setUpdateAction(boolean z) {
        this.doUpdate = z;
    }

    public boolean updateViewData(org.json.JSONObject jSONObject, int i, int i2) {
        return updateViewData(jSONObject, i, i2, this.mWebviewScale);
    }

    public void onScreenChanged() {
        updateViewData(this.mJsonViewOption);
    }

    public boolean updateViewData(org.json.JSONObject jSONObject, int i, int i2, float f) {
        boolean z;
        boolean zIsEquals;
        org.json.JSONObject jSONObject2 = jSONObject;
        org.json.JSONObject jSONObject3 = this.mJsonViewOption;
        if (jSONObject3 == null) {
            return false;
        }
        if (jSONObject3 != null) {
            io.dcloud.common.util.JSONUtil.combinJSONObject(jSONObject3, jSONObject2);
            jSONObject2 = this.mJsonViewOption;
        } else {
            this.mJsonViewOption = jSONObject2;
        }
        int i3 = i2 < 0 ? this.height + this.bottom + this.top : i2;
        int i4 = i < 0 ? this.width : i;
        int i5 = this.left;
        int i6 = this.top;
        int i7 = this.width;
        int i8 = this.height;
        if (jSONObject2.has(io.dcloud.common.constant.AbsoluteConst.JSONKEY_STATUSBAR) && io.dcloud.common.util.BaseInfo.isImmersive) {
            this.isStatusbar = true;
            org.json.JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject(io.dcloud.common.constant.AbsoluteConst.JSONKEY_STATUSBAR);
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.has("background")) {
                this.mStatusbarColor = jSONObjectOptJSONObject.optString("background", this.mStatusbarColor);
            }
        }
        boolean z2 = this.doUpdate || !jSONObject2.isNull("left");
        boolean z3 = this.doUpdate || !jSONObject2.isNull("right");
        boolean z4 = this.doUpdate || !jSONObject2.isNull("top");
        boolean z5 = this.doUpdate || !jSONObject2.isNull("width");
        boolean z6 = z2;
        boolean z7 = this.doUpdate || !jSONObject2.isNull("height");
        boolean z8 = z3;
        boolean z9 = this.doUpdate || !jSONObject2.isNull("bottom");
        boolean z10 = z4;
        this.left = io.dcloud.common.util.PdrUtil.convertToScreenInt(io.dcloud.common.util.JSONUtil.getString(jSONObject2, "left"), i4, 0, f);
        this.top = io.dcloud.common.util.PdrUtil.convertToScreenInt(io.dcloud.common.util.JSONUtil.getString(jSONObject2, "top"), i3, 0, f);
        this.width = io.dcloud.common.util.PdrUtil.convertToScreenInt(io.dcloud.common.util.JSONUtil.getString(jSONObject2, "width"), i4, z5 ? this.width : i4, f);
        int iConvertToScreenInt = io.dcloud.common.util.PdrUtil.convertToScreenInt(io.dcloud.common.util.JSONUtil.getString(jSONObject2, "height"), i3, z7 ? this.height : i3, f);
        this.height = iConvertToScreenInt;
        if (!z7 || iConvertToScreenInt >= i3) {
            z = true;
        } else {
            z = true;
            this.isNotHeightFullScreen = true;
            if (this.isStatusbar) {
                this.isStatusbarDodifyHeight = true;
            }
        }
        this.right = io.dcloud.common.util.PdrUtil.convertToScreenInt(io.dcloud.common.util.JSONUtil.getString(jSONObject2, "right"), i4, this.right, f);
        this.bottom = io.dcloud.common.util.PdrUtil.convertToScreenInt(io.dcloud.common.util.JSONUtil.getString(jSONObject2, "bottom"), i3, this.bottom, f);
        if (jSONObject2.isNull("margin")) {
            zIsEquals = false;
        } else {
            java.lang.String string = io.dcloud.common.util.JSONUtil.getString(jSONObject2, "margin");
            this.margin = string;
            zIsEquals = io.dcloud.common.util.PdrUtil.isEquals("auto", string);
        }
        if (z6) {
            if (!z5 && z8) {
                this.width = (i4 - this.left) - this.right;
            }
        } else if (!z5 && z8) {
            this.left = -this.right;
        } else if (z5 && !z8 && zIsEquals) {
            this.left = (i4 - this.width) / 2;
        } else if (z5 && z8) {
            this.left = (i4 - this.width) - this.right;
        }
        if (z10) {
            if (!z7 && z9) {
                this.height = (i3 - this.top) - this.bottom;
            }
        } else if (!z7 && z9) {
            this.top = -this.bottom;
        } else if (z7 && !z9 && zIsEquals) {
            this.top = (i3 - this.height) / 2;
        } else if (z7 && z9) {
            this.top = (i3 - this.height) - this.bottom;
        }
        layoutWithRelViewRect();
        layoutDockViewRect(this.mParentViewRect, this, false);
        int i9 = this.left;
        if (i5 == i9 && i6 == this.top && i8 == this.height && i7 == this.width) {
            z = false;
        }
        this.anim_left = i9;
        this.anim_top = this.top;
        return z;
    }

    public void commitUpdate2JSONObject() {
        commitUpdate2JSONObject(false, false);
    }

    public void updateViewData(io.dcloud.common.adapter.util.ViewRect viewRect) {
        this.mWebviewScale = viewRect.mWebviewScale;
        this.left = viewRect.left;
        this.top = viewRect.top;
        this.width = viewRect.width;
        this.height = viewRect.height;
        this.right = viewRect.right;
        this.bottom = viewRect.bottom;
        updateViewData(viewRect.mJsonViewOption);
    }

    public static void layoutDockViewRect(io.dcloud.common.adapter.util.ViewRect viewRect, io.dcloud.common.adapter.util.ViewRect viewRect2) {
        layoutDockViewRect(viewRect, viewRect2, true);
    }

    public boolean updateViewData(org.json.JSONObject jSONObject) {
        io.dcloud.common.adapter.util.ViewRect viewRect = this.mParentViewRect;
        if (viewRect == null) {
            return false;
        }
        return updateViewData(jSONObject, viewRect.width, viewRect.height);
    }
}
