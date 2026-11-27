package io.dcloud.feature.weex_barcode;

/* JADX INFO: loaded from: classes2.dex */
public class BarcodeModule extends com.taobao.weex.common.WXModule {
    @com.taobao.weex.annotation.JSMethod
    public void scan(java.lang.String str, com.taobao.weex.bridge.JSCallback jSCallback, com.alibaba.fastjson.JSONArray jSONArray, boolean z) {
        try {
            java.lang.String path = this.mWXSDKInstance.rewriteUri(android.net.Uri.parse(str), "image").getPath();
            com.dcloud.zxing2.Result resultDecode = io.dcloud.feature.barcode2.decoding.CaptureActivityHandler.decode(android.graphics.BitmapFactory.decodeFile(path), z);
            if (resultDecode != null) {
                java.util.HashMap map = new java.util.HashMap();
                map.put("type", com.taobao.weex.ui.component.WXImage.SUCCEED);
                map.put("code", resultDecode.getBarcodeFormat().toString());
                map.put("message", io.dcloud.common.util.JSONUtil.toJSONableString(resultDecode.getText()));
                if (path == null) {
                    path = "";
                }
                map.put("file", path);
                map.put("charSet", resultDecode.textCharset);
                java.util.HashMap map2 = new java.util.HashMap();
                map2.put("detail", map);
                jSCallback.invoke(map2);
                return;
            }
            java.util.HashMap map3 = new java.util.HashMap();
            map3.put("type", com.taobao.weex.common.Constants.Event.FAIL);
            map3.put("code", 8);
            map3.put("message", "");
            map3.put("charSet", resultDecode.textCharset);
            java.util.HashMap map4 = new java.util.HashMap();
            map4.put("detail", map3);
            jSCallback.invoke(map4);
        } catch (java.lang.Exception e) {
            java.util.HashMap map5 = new java.util.HashMap();
            map5.put("type", com.taobao.weex.common.Constants.Event.FAIL);
            map5.put("code", 8);
            map5.put("message", e.getMessage());
            java.util.HashMap map6 = new java.util.HashMap();
            map6.put("detail", map5);
            jSCallback.invoke(map6);
        }
    }
}
