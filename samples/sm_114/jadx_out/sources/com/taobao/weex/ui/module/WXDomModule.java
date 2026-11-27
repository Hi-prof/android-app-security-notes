package com.taobao.weex.ui.module;

/* JADX INFO: loaded from: classes.dex */
public final class WXDomModule extends com.taobao.weex.common.WXModule {
    public static final java.lang.String UPDATE_COMPONENT_DATA = "updateComponentData";
    public static final java.lang.String WXDOM = "dom";
    public static final java.lang.String SCROLL_TO_ELEMENT = "scrollToElement";
    public static final java.lang.String ADD_RULE = "addRule";
    public static final java.lang.String GET_COMPONENT_RECT = "getComponentRect";
    public static final java.lang.String INVOKE_METHOD = "invokeMethod";
    public static final java.lang.String GET_COMPONENT_DIRECTION = "getLayoutDirection";
    public static final java.lang.String BATCH_BEGIN = "beginBatchMark";
    public static final java.lang.String BATCH_END = "endBatchMark";
    public static final java.lang.String[] METHODS = {SCROLL_TO_ELEMENT, ADD_RULE, GET_COMPONENT_RECT, INVOKE_METHOD, GET_COMPONENT_DIRECTION, BATCH_BEGIN, BATCH_END};

    public WXDomModule(com.taobao.weex.WXSDKInstance wXSDKInstance) {
        this.mWXSDKInstance = wXSDKInstance;
        this.mUniSDKInstance = wXSDKInstance;
    }

    public void callDomMethod(com.alibaba.fastjson.JSONObject jSONObject, long... jArr) {
        if (jSONObject == null) {
            return;
        }
        callDomMethod((java.lang.String) jSONObject.get("method"), (com.alibaba.fastjson.JSONArray) jSONObject.get("args"), jArr);
    }

    /* JADX WARN: Code duplicated, block: B:65:0x0137 A[Catch: ClassCastException -> 0x013d, IndexOutOfBoundsException -> 0x0143, TRY_LEAVE, TryCatch #2 {ClassCastException -> 0x013d, IndexOutOfBoundsException -> 0x0143, blocks: (B:5:0x0004, B:6:0x000b, B:65:0x0137, B:8:0x0010, B:12:0x001b, B:13:0x002f, B:16:0x003a, B:19:0x0042, B:21:0x005f, B:25:0x006a, B:26:0x007e, B:30:0x0089, B:32:0x008f, B:34:0x0095, B:35:0x00a1, B:39:0x00ac, B:40:0x00c8, B:44:0x00d3, B:46:0x00d9, B:48:0x00df, B:50:0x00e5, B:52:0x00eb, B:53:0x00f6, B:57:0x0101, B:58:0x0118, B:60:0x0120, B:62:0x0126, B:64:0x012c), top: B:71:0x0004 }] */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public java.lang.Object callDomMethod(java.lang.String str, com.alibaba.fastjson.JSONArray jSONArray, long... jArr) {
        if (str == null) {
            return null;
        }
        try {
            switch (str.hashCode()) {
                case -1390247284:
                    if (!str.equals(BATCH_END)) {
                        com.taobao.weex.utils.WXLogUtils.e("Unknown dom action.");
                    } else {
                        new com.taobao.weex.ui.action.GraphicActionBatchEnd(this.mWXSDKInstance, jSONArray.size() >= 1 ? jSONArray.getString(0) : null).executeActionOnRender();
                    }
                    break;
                case -1148630211:
                    if (!str.equals(ADD_RULE)) {
                        com.taobao.weex.utils.WXLogUtils.e("Unknown dom action.");
                        break;
                    } else if (jSONArray != null) {
                        new com.taobao.weex.ui.action.ActionAddRule(this.mWXSDKInstance.getInstanceId(), jSONArray.getString(0), jSONArray.getJSONObject(1)).executeAction();
                        break;
                    }
                    break;
                case -748746828:
                    if (!str.equals(SCROLL_TO_ELEMENT)) {
                        com.taobao.weex.utils.WXLogUtils.e("Unknown dom action.");
                        break;
                    } else if (jSONArray != null) {
                        new com.taobao.weex.ui.action.GraphicActionScrollToElement(this.mWXSDKInstance, jSONArray.size() >= 1 ? jSONArray.getString(0) : null, jSONArray.size() >= 2 ? jSONArray.getJSONObject(1) : null).executeActionOnRender();
                        break;
                    }
                    break;
                case -658126983:
                    if (!str.equals(INVOKE_METHOD)) {
                        com.taobao.weex.utils.WXLogUtils.e("Unknown dom action.");
                        break;
                    } else if (jSONArray != null) {
                        new com.taobao.weex.ui.action.ActionInvokeMethod(this.mWXSDKInstance.getInstanceId(), jSONArray.getString(0), jSONArray.getString(1), jSONArray.getJSONArray(2)).executeAction();
                        break;
                    }
                    break;
                case -276465026:
                    if (!str.equals(BATCH_BEGIN)) {
                        com.taobao.weex.utils.WXLogUtils.e("Unknown dom action.");
                        break;
                    } else if (jSONArray != null) {
                        new com.taobao.weex.ui.action.GraphicActionBatchBegin(this.mWXSDKInstance, jSONArray.size() >= 1 ? jSONArray.getString(0) : null).executeActionOnRender();
                        break;
                    }
                    break;
                case 588570827:
                    if (!str.equals(GET_COMPONENT_RECT)) {
                        com.taobao.weex.utils.WXLogUtils.e("Unknown dom action.");
                        break;
                    } else if (jSONArray != null) {
                        new com.taobao.weex.ui.action.ActionGetComponentRect(this.mWXSDKInstance, jSONArray.getString(0), jSONArray.getString(1)).executeActionOnRender();
                        break;
                    }
                    break;
                case 1653342206:
                    if (!str.equals(UPDATE_COMPONENT_DATA)) {
                        com.taobao.weex.utils.WXLogUtils.e("Unknown dom action.");
                    } else if (jSONArray != null && jSONArray.size() >= 3) {
                        new com.taobao.weex.ui.action.UpdateComponentDataAction(this.mWXSDKInstance, jSONArray.getString(0), com.taobao.weex.dom.binding.JSONUtils.toJSON(jSONArray.get(1)), jSONArray.getString(2)).executeAction();
                    }
                    break;
                case 1875897663:
                    if (!str.equals(GET_COMPONENT_DIRECTION)) {
                        com.taobao.weex.utils.WXLogUtils.e("Unknown dom action.");
                        break;
                    } else if (jSONArray != null) {
                        new com.taobao.weex.ui.action.ActionGetLayoutDirection(this.mWXSDKInstance, jSONArray.getString(0), jSONArray.getString(1)).executeActionOnRender();
                        break;
                    }
                    break;
                default:
                    com.taobao.weex.utils.WXLogUtils.e("Unknown dom action.");
                    break;
            }
        } catch (java.lang.ClassCastException unused) {
            com.taobao.weex.utils.WXLogUtils.e("Dom module call arguments format error!!");
        } catch (java.lang.IndexOutOfBoundsException e) {
            e.printStackTrace();
            com.taobao.weex.utils.WXLogUtils.e("Dom module call miss arguments.");
        }
        return null;
        return null;
    }

    public void invokeMethod(java.lang.String str, java.lang.String str2, com.alibaba.fastjson.JSONArray jSONArray) {
        if (str == null || str2 == null) {
            return;
        }
        new com.taobao.weex.ui.action.ActionInvokeMethod(this.mWXSDKInstance.getInstanceId(), str, str2, jSONArray).executeAction();
    }
}
