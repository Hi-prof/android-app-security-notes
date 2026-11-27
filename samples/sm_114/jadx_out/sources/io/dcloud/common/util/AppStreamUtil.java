package io.dcloud.common.util;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class AppStreamUtil {
    public static java.util.ArrayList<java.lang.String> AppStreamSchemeWhiteDefaultList;

    static {
        java.util.ArrayList<java.lang.String> arrayList = new java.util.ArrayList<>();
        AppStreamSchemeWhiteDefaultList = arrayList;
        arrayList.add("sms");
        AppStreamSchemeWhiteDefaultList.add(com.taobao.weex.common.Constants.Value.TEL);
        AppStreamSchemeWhiteDefaultList.add("mailto");
        AppStreamSchemeWhiteDefaultList.add("callto");
        AppStreamSchemeWhiteDefaultList.add("weixin");
        AppStreamSchemeWhiteDefaultList.add("alipay");
        AppStreamSchemeWhiteDefaultList.add("alipays");
        AppStreamSchemeWhiteDefaultList.add("alipayqr");
        AppStreamSchemeWhiteDefaultList.add("weibo");
        AppStreamSchemeWhiteDefaultList.add("mqq");
        AppStreamSchemeWhiteDefaultList.add("mqqapi");
        AppStreamSchemeWhiteDefaultList.add("qqmap");
        AppStreamSchemeWhiteDefaultList.add("baidumap");
        AppStreamSchemeWhiteDefaultList.add("amap");
        AppStreamSchemeWhiteDefaultList.add("iosamap");
        AppStreamSchemeWhiteDefaultList.add(io.dcloud.common.constant.AbsoluteConst.XML_STREAMAPP);
    }
}
