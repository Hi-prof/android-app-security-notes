package com.taobao.weex.ui.action;

/* JADX INFO: loaded from: classes.dex */
public class ActionAddRule implements com.taobao.weex.ui.action.IExecutable {
    private final com.alibaba.fastjson.JSONObject mData;
    private final java.lang.String mPageId;
    private final java.lang.String mType;

    public ActionAddRule(java.lang.String str, java.lang.String str2, com.alibaba.fastjson.JSONObject jSONObject) {
        this.mPageId = str;
        this.mType = str2;
        this.mData = jSONObject;
    }

    @Override // com.taobao.weex.ui.action.IExecutable
    public void executeAction() {
        com.taobao.weex.utils.FontDO fontDO;
        com.taobao.weex.WXSDKInstance wXSDKInstance = com.taobao.weex.WXSDKManager.getInstance().getWXRenderManager().getWXSDKInstance(this.mPageId);
        if (wXSDKInstance == null || wXSDKInstance.isDestroy() || !com.taobao.weex.common.Constants.Name.FONT_FACE.equals(this.mType) || (fontDO = parseFontDO(this.mData, wXSDKInstance)) == null || android.text.TextUtils.isEmpty(fontDO.getFontFamilyName())) {
            return;
        }
        notifyAddFontRule(wXSDKInstance, fontDO);
        com.taobao.weex.utils.FontDO fontDO2 = com.taobao.weex.utils.TypefaceUtil.getFontDO(fontDO.getFontFamilyName());
        if (fontDO2 == null || !android.text.TextUtils.equals(fontDO2.getUrl(), fontDO.getUrl())) {
            com.taobao.weex.utils.TypefaceUtil.putFontDO(fontDO);
            com.taobao.weex.utils.TypefaceUtil.loadTypeface(fontDO, true);
        } else {
            com.taobao.weex.utils.TypefaceUtil.loadTypeface(fontDO2, true);
        }
    }

    private com.taobao.weex.utils.FontDO parseFontDO(com.alibaba.fastjson.JSONObject jSONObject, com.taobao.weex.WXSDKInstance wXSDKInstance) {
        if (jSONObject == null) {
            return null;
        }
        return new com.taobao.weex.utils.FontDO(jSONObject.getString(com.taobao.weex.common.Constants.Name.FONT_FAMILY), jSONObject.getString("src"), wXSDKInstance);
    }

    private void notifyAddFontRule(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.utils.FontDO fontDO) {
        com.taobao.weex.font.FontAdapter fontAdapter = com.taobao.weex.WXSDKManager.getInstance().getFontAdapter();
        if (fontAdapter != null) {
            fontAdapter.onAddFontRule(wXSDKInstance.getInstanceId(), fontDO.getFontFamilyName(), fontDO.getUrl());
        }
    }
}
