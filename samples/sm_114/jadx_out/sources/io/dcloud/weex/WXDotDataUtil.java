package io.dcloud.weex;

/* JADX INFO: loaded from: classes2.dex */
public class WXDotDataUtil {
    private static com.alibaba.fastjson.JSONObject DEVICEINFO = new com.alibaba.fastjson.JSONObject();

    public static void setValue(java.lang.String str, java.lang.Object obj) {
        if (io.dcloud.common.util.BaseInfo.SyncDebug) {
            DEVICEINFO.put(str, obj);
        }
    }

    public static com.alibaba.fastjson.JSONObject getDeviceInfo() {
        return DEVICEINFO;
    }
}
