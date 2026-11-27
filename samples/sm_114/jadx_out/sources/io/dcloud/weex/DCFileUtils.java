package io.dcloud.weex;

/* JADX INFO: loaded from: classes2.dex */
public class DCFileUtils {
    public static java.io.InputStream loadWeexAsset(java.lang.String str, android.content.Context context) {
        java.io.InputStream inputStreamOpen;
        java.io.InputStream inputStreamLoadWeexAsset = io.dcloud.common.util.AppRuntime.loadWeexAsset(str, context);
        if (inputStreamLoadWeexAsset != null || !str.startsWith("uni-jsframework") || !str.endsWith(".js")) {
            return inputStreamLoadWeexAsset;
        }
        try {
            try {
                inputStreamOpen = context.getAssets().open(str);
            } catch (java.io.FileNotFoundException unused) {
                io.dcloud.feature.weex.WeexInstanceMgr.self().setJSFKFileNotFound(true);
                inputStreamOpen = null;
            }
            if (inputStreamOpen != null) {
                io.dcloud.feature.weex.WeexInstanceMgr.self().setJSFKFileNotFound(false);
                java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(inputStreamOpen));
                org.json.JSONObject jSONObject = new org.json.JSONObject(bufferedReader.readLine().substring(2));
                io.dcloud.common.util.BaseInfo.setUniVersionV3(jSONObject.optString("version"), context);
                java.lang.String strOptString = jSONObject.optString("encode");
                if (android.text.TextUtils.isEmpty(strOptString) || !strOptString.equals("base64")) {
                    return inputStreamLoadWeexAsset;
                }
                java.lang.String line = bufferedReader.readLine();
                while (true) {
                    java.lang.String line2 = bufferedReader.readLine();
                    if (line2 != null) {
                        line = line + line2;
                    } else {
                        return new java.io.ByteArrayInputStream(android.util.Base64.decode(line, 0));
                    }
                }
            } else {
                io.dcloud.feature.weex.WeexInstanceMgr.self().setJSFKFileNotFound(true);
                return inputStreamLoadWeexAsset;
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return inputStreamLoadWeexAsset;
        }
    }

    public static java.lang.String getAssetPath(java.lang.String str) {
        java.lang.String str2;
        java.lang.String str3;
        if (android.text.TextUtils.isEmpty(str) || !str.equals("weex-main-jsfm.js")) {
            return str;
        }
        if (io.dcloud.feature.weex.WeexInstanceMgr.self().getVueVersion() != 3) {
            str2 = "uni-jsframework";
        } else {
            str2 = "uni-jsframework-vue3";
        }
        if (io.dcloud.common.util.BaseInfo.SyncDebug) {
            str3 = str2 + "-dev.js";
        } else {
            str3 = str2 + ".js";
        }
        if (io.dcloud.common.adapter.util.PlatformUtil.getResInputStream(str3) == null && io.dcloud.common.util.BaseInfo.SyncDebug) {
            str3 = str2 + ".js";
        }
        io.dcloud.common.adapter.util.Logger.i("DCFileUtils", "getAssetPath---------" + str3);
        return str3;
    }
}
