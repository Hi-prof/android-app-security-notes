package com.taobao.weex.utils;

/* JADX INFO: loaded from: classes.dex */
public class WXExceptionUtils {
    private static java.util.Set<java.lang.String> sGlobalExceptionRecord = new java.util.concurrent.CopyOnWriteArraySet();
    public static java.lang.String degradeUrl = "BundleUrlDefaultDegradeUrl";

    private static boolean checkNeedReportCauseRepeat(java.lang.String str, com.taobao.weex.common.WXErrorCode wXErrorCode, java.lang.String str2) {
        java.util.Set<java.lang.String> set;
        if (android.text.TextUtils.isEmpty(str2)) {
            return true;
        }
        if (wXErrorCode != null && wXErrorCode.getErrorGroup() != com.taobao.weex.common.WXErrorCode.ErrorGroup.JS) {
            return true;
        }
        if (android.text.TextUtils.isEmpty(str)) {
            str = "instanceIdNull";
        }
        if (str2.length() > 200) {
            str2 = str2.substring(0, 200);
        }
        com.taobao.weex.WXSDKInstance wXSDKInstance = com.taobao.weex.WXSDKManager.getInstance().getAllInstanceMap().get(str);
        if (wXSDKInstance == null) {
            set = sGlobalExceptionRecord;
        } else {
            set = wXSDKInstance.getApmForInstance().exceptionRecord;
        }
        if (set == null) {
            return true;
        }
        if (set.contains(str2)) {
            return false;
        }
        set.add(str2);
        return true;
    }

    public static void commitCriticalExceptionRT(java.lang.String str, com.taobao.weex.common.WXErrorCode wXErrorCode, java.lang.String str2, java.lang.String str3, java.util.Map<java.lang.String, java.lang.String> map) {
        try {
            com.taobao.weex.utils.WXLogUtils.e("weex", "commitCriticalExceptionRT :" + wXErrorCode + "exception" + str3);
            com.taobao.weex.performance.WXStateRecord.getInstance().recordException(str, str3);
            com.taobao.weex.adapter.IWXConfigAdapter wxConfigAdapter = com.taobao.weex.WXSDKManager.getInstance().getWxConfigAdapter();
            if (!(wxConfigAdapter != null ? io.dcloud.common.constant.AbsoluteConst.TRUE.equalsIgnoreCase(wxConfigAdapter.getConfig("wxapm", "check_repeat_report", io.dcloud.common.constant.AbsoluteConst.TRUE)) : true ? checkNeedReportCauseRepeat(str, wXErrorCode, str3) : true)) {
                return;
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        commitCriticalExceptionWithDefaultUrl("BundleUrlDefault", str, wXErrorCode, str2, str3, map);
    }

    public static void commitCriticalExceptionWithDefaultUrl(java.lang.String str, java.lang.String str2, com.taobao.weex.common.WXErrorCode wXErrorCode, java.lang.String str3, java.lang.String str4, java.util.Map<java.lang.String, java.lang.String> map) {
        java.lang.String str5;
        java.lang.String str6;
        java.lang.String strSubstring;
        com.taobao.weex.adapter.IWXJSExceptionAdapter iWXJSExceptionAdapter = com.taobao.weex.WXSDKManager.getInstance().getIWXJSExceptionAdapter();
        if (android.text.TextUtils.isEmpty(str)) {
            str = "BundleUrlDefault";
        }
        if (map == null) {
            map = new java.util.HashMap<>();
        }
        java.util.Map<java.lang.String, java.lang.String> map2 = map;
        map2.put("wxSdkInitStartTime", java.lang.String.valueOf(com.taobao.weex.WXEnvironment.sSDKInitStart));
        map2.put("wxSDKInitCostTime", java.lang.String.valueOf(com.taobao.weex.WXEnvironment.sSDKInitTime));
        map2.put("wxSDKCurExceptionTime", java.lang.String.valueOf(java.lang.System.currentTimeMillis()));
        map2.put("wxUseRuntimeApi", java.lang.String.valueOf(com.taobao.weex.WXEnvironment.sUseRunTimeApi));
        if (!android.text.TextUtils.isEmpty(str2)) {
            com.taobao.weex.WXSDKInstance wXSDKInstance = com.taobao.weex.WXSDKManager.getInstance().getAllInstanceMap().get(str2);
            if (wXSDKInstance != null) {
                str = wXSDKInstance.getApmForInstance().reportPageName;
                java.lang.Object obj = wXSDKInstance.getApmForInstance().extInfo.get(com.taobao.weex.performance.WXInstanceApm.VALUE_BUNDLE_LOAD_LENGTH);
                map2.put(com.taobao.weex.performance.WXInstanceApm.VALUE_BUNDLE_LOAD_LENGTH, obj instanceof java.lang.Integer ? java.lang.String.valueOf(obj) : "unknownLength");
                map2.put("templateInfo", wXSDKInstance.getTemplateInfo());
                if (android.text.TextUtils.isEmpty(str) || str.equals("default")) {
                    if (!android.text.TextUtils.equals(degradeUrl, "BundleUrlDefaultDegradeUrl")) {
                        str = degradeUrl;
                    } else {
                        str = com.taobao.weex.WXSDKInstance.requestUrl;
                    }
                }
                for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : wXSDKInstance.getContainerInfo().entrySet()) {
                    map2.put(entry.getKey(), entry.getValue());
                }
                map2.put("wxStageList", convertStageToStr(wXSDKInstance));
                java.lang.String template = wXSDKInstance.getTemplate();
                if (template == null) {
                    strSubstring = "has recycle by gc";
                } else {
                    strSubstring = template.substring(0, java.lang.Math.min(template.length(), 300));
                }
                map2.put("wxTemplateOfBundle", strSubstring);
                java.lang.Long l = wXSDKInstance.getApmForInstance().stageMap.get(com.taobao.weex.performance.WXInstanceApm.KEY_PAGE_STAGES_DOWN_BUNDLE_START);
                if (l == null) {
                    l = wXSDKInstance.getApmForInstance().stageMap.get(com.taobao.weex.performance.WXInstanceApm.KEY_PAGE_STAGES_RENDER_ORGIGIN);
                }
                if (l != null) {
                    map2.put("wxUseTime", java.lang.String.valueOf(com.taobao.weex.utils.WXUtils.getFixUnixTime() - l.longValue()));
                }
            }
            str5 = str;
            str6 = str2;
        } else {
            if (map2.size() > 0) {
                if (android.text.TextUtils.isEmpty(map2.get("weexUrl"))) {
                    str = map2.get("weexUrl");
                } else {
                    str = map2.get("bundleUrl");
                }
            }
            str5 = str;
            str6 = "InstanceIdDefalut";
        }
        java.lang.String str7 = map2.get("errorCode");
        if (str7 != null && str7.length() > 200) {
            map2.remove("errorCode");
        }
        com.taobao.weex.common.WXJSExceptionInfo wXJSExceptionInfo = new com.taobao.weex.common.WXJSExceptionInfo(str6, str5, wXErrorCode, str3, str4, map2);
        if (iWXJSExceptionAdapter != null) {
            iWXJSExceptionAdapter.onJSException(wXJSExceptionInfo);
        }
        com.taobao.weex.performance.WXAnalyzerDataTransfer.transferError(wXJSExceptionInfo, str2);
    }

    private static java.lang.String convertStageToStr(com.taobao.weex.WXSDKInstance wXSDKInstance) {
        if (wXSDKInstance == null || wXSDKInstance.getApmForInstance() == null || wXSDKInstance.getApmForInstance().stageMap.isEmpty()) {
            return "noStageRecord";
        }
        java.util.ArrayList<java.util.Map.Entry> arrayList = new java.util.ArrayList(wXSDKInstance.getApmForInstance().stageMap.entrySet());
        java.util.Collections.sort(arrayList, new java.util.Comparator<java.util.Map.Entry<java.lang.String, java.lang.Long>>() { // from class: com.taobao.weex.utils.WXExceptionUtils.1
            @Override // java.util.Comparator
            public int compare(java.util.Map.Entry<java.lang.String, java.lang.Long> entry, java.util.Map.Entry<java.lang.String, java.lang.Long> entry2) {
                return (int) (entry.getValue().longValue() - entry2.getValue().longValue());
            }
        });
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (java.util.Map.Entry entry : arrayList) {
            sb.append((java.lang.String) entry.getKey());
            sb.append(com.taobao.weex.el.parse.Operators.CONDITION_IF_MIDDLE);
            sb.append(entry.getValue());
            sb.append("->");
        }
        return sb.toString();
    }
}
