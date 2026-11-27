package io.dcloud.net;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class XMLHttpRequestMgr {
    private io.dcloud.common.util.net.NetWorkLoop mNetWorkLoop = new io.dcloud.common.util.net.NetWorkLoop();
    public java.util.HashMap<java.lang.String, java.util.ArrayList<io.dcloud.net.XMLHttpRequest>> mXMLHttpRequests;

    public XMLHttpRequestMgr() {
        this.mXMLHttpRequests = null;
        this.mXMLHttpRequests = new java.util.HashMap<>();
        this.mNetWorkLoop.startThreadPool();
    }

    private io.dcloud.net.XMLHttpRequest findXMLHttpRequest(java.lang.String str, java.lang.String str2) {
        java.util.ArrayList<io.dcloud.net.XMLHttpRequest> arrayList = this.mXMLHttpRequests.get(str);
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            io.dcloud.net.XMLHttpRequest xMLHttpRequest = arrayList.get(i);
            if (str2.equals(xMLHttpRequest.mUUID)) {
                return xMLHttpRequest;
            }
        }
        return null;
    }

    private void pushXMLHttpRequest(java.lang.String str, io.dcloud.net.XMLHttpRequest xMLHttpRequest) {
        java.util.ArrayList<io.dcloud.net.XMLHttpRequest> arrayList = this.mXMLHttpRequests.get(str);
        if (arrayList == null) {
            arrayList = new java.util.ArrayList<>();
            this.mXMLHttpRequests.put(str, arrayList);
        }
        arrayList.add(xMLHttpRequest);
    }

    public java.lang.String execute(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.String[] strArr) {
        java.lang.String strObtainAppId = iWebview.obtainFrameView().obtainApp().obtainAppId();
        if ("send".equals(str)) {
            io.dcloud.net.XMLHttpRequest xMLHttpRequestFindXMLHttpRequest = findXMLHttpRequest(strObtainAppId, strArr[0]);
            xMLHttpRequestFindXMLHttpRequest.setCallbackId(strArr[1]);
            java.lang.String str2 = strArr[2];
            io.dcloud.common.util.net.RequestData requestData = xMLHttpRequestFindXMLHttpRequest.getRequestData();
            if (!requestData.getReqmethod().equalsIgnoreCase("get")) {
                requestData.addBody(str2);
            }
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject(strArr[3]);
                org.json.JSONArray jSONArrayNames = jSONObject.names();
                if (jSONArrayNames != null && jSONArrayNames.length() > 0) {
                    for (int i = 0; i < jSONArrayNames.length(); i++) {
                        java.lang.String strOptString = jSONArrayNames.optString(i);
                        requestData.addHeader(strOptString, jSONObject.optString(strOptString));
                    }
                }
            } catch (org.json.JSONException e) {
                e.printStackTrace();
            }
            this.mNetWorkLoop.addNetWork(xMLHttpRequestFindXMLHttpRequest.getNetWork());
            return null;
        }
        if ("open".equals(str)) {
            java.lang.String str3 = strArr[0];
            java.lang.String str4 = strArr[1];
            java.lang.String str5 = strArr[2];
            java.lang.String str6 = strArr[3];
            java.lang.String str7 = strArr[4];
            io.dcloud.net.XMLHttpRequest xMLHttpRequest = new io.dcloud.net.XMLHttpRequest(str3, str5, str4, iWebview);
            io.dcloud.common.util.net.RequestData requestData2 = xMLHttpRequest.getRequestData();
            requestData2.mTimeout = io.dcloud.common.util.PdrUtil.parseInt(strArr[5], requestData2.mTimeout);
            requestData2.addHeader(str6, str7);
            pushXMLHttpRequest(strObtainAppId, xMLHttpRequest);
            return null;
        }
        if (!"overrideMimeType".equals(str)) {
            if (!"abort".equals(str)) {
                return null;
            }
            this.mNetWorkLoop.removeNetWork(findXMLHttpRequest(strObtainAppId, strArr[0]).getNetWork());
            return null;
        }
        io.dcloud.net.XMLHttpRequest xMLHttpRequestFindXMLHttpRequest2 = findXMLHttpRequest(strObtainAppId, strArr[0]);
        if (xMLHttpRequestFindXMLHttpRequest2 == null) {
            return null;
        }
        xMLHttpRequestFindXMLHttpRequest2.getRequestData().mOverrideMimeType = strArr[1];
        return null;
    }
}
