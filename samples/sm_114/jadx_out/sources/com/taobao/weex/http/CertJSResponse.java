package com.taobao.weex.http;

/* JADX INFO: loaded from: classes.dex */
public class CertJSResponse implements io.dcloud.common.DHInterface.IReflectAble {
    public int code;
    public java.lang.String message;
    public java.lang.String type;

    public static com.taobao.weex.http.CertJSResponse obtainSuccess() {
        com.taobao.weex.http.CertJSResponse certJSResponse = new com.taobao.weex.http.CertJSResponse();
        certJSResponse.type = com.taobao.weex.ui.component.WXImage.SUCCEED;
        certJSResponse.code = 0;
        certJSResponse.message = "";
        return certJSResponse;
    }

    public static com.taobao.weex.http.CertJSResponse obtainFail(int i, java.lang.String str) {
        com.taobao.weex.http.CertJSResponse certJSResponse = new com.taobao.weex.http.CertJSResponse();
        certJSResponse.type = com.taobao.weex.common.Constants.Event.FAIL;
        certJSResponse.code = i;
        certJSResponse.message = str;
        return certJSResponse;
    }
}
