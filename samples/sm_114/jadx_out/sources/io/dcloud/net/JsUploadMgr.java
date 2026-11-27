package io.dcloud.net;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class JsUploadMgr {
    public java.util.HashMap<java.lang.String, java.util.ArrayList<io.dcloud.net.JsUpload>> mAppsUploadTasks;
    private io.dcloud.common.util.net.UploadMgr mUploadMgr = io.dcloud.common.util.net.UploadMgr.getUploadMgr();

    JsUploadMgr() {
        this.mAppsUploadTasks = null;
        this.mAppsUploadTasks = new java.util.HashMap<>();
    }

    private io.dcloud.net.JsUpload createUploadTask(io.dcloud.common.DHInterface.IWebview iWebview, org.json.JSONObject jSONObject) {
        return new io.dcloud.net.JsUpload(iWebview, jSONObject);
    }

    private org.json.JSONArray enumerate(java.lang.String str, java.util.ArrayList<io.dcloud.net.JsUpload> arrayList) {
        org.json.JSONArray jSONArray = new org.json.JSONArray();
        if (arrayList != null && !arrayList.isEmpty()) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                try {
                    jSONArray.put(new org.json.JSONObject(arrayList.get(i).toJsonUpload()));
                } catch (org.json.JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return jSONArray;
    }

    private io.dcloud.net.JsUpload findUploadTask(java.lang.String str, java.lang.String str2) {
        java.util.ArrayList<io.dcloud.net.JsUpload> arrayList = this.mAppsUploadTasks.get(str);
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            io.dcloud.net.JsUpload jsUpload = arrayList.get(i);
            if (str2.equals(jsUpload.mUUID)) {
                return jsUpload;
            }
        }
        return null;
    }

    private void pushUploadTask(java.lang.String str, io.dcloud.net.JsUpload jsUpload) {
        java.util.ArrayList<io.dcloud.net.JsUpload> arrayList = this.mAppsUploadTasks.get(str);
        if (arrayList == null) {
            arrayList = new java.util.ArrayList<>();
            this.mAppsUploadTasks.put(str, arrayList);
        }
        arrayList.add(jsUpload);
    }

    public java.lang.String execute(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.String[] strArr) {
        java.lang.String strObtainAppId = iWebview.obtainFrameView().obtainApp().obtainAppId();
        if ("start".equals(str) || io.dcloud.common.constant.AbsoluteConst.EVENTS_RESUME.equals(str)) {
            io.dcloud.net.JsUpload jsUploadFindUploadTask = findUploadTask(strObtainAppId, strArr[0]);
            if (jsUploadFindUploadTask != null && !jsUploadFindUploadTask.isStart) {
                this.mUploadMgr.start(jsUploadFindUploadTask.mUploadNetWork);
                jsUploadFindUploadTask.isStart = true;
            }
            java.lang.String str2 = strArr[1];
            if (!android.text.TextUtils.isEmpty(str2)) {
                try {
                    org.json.JSONObject jSONObject = new org.json.JSONObject(str2);
                    java.util.Iterator<java.lang.String> itKeys = jSONObject.keys();
                    while (itKeys.hasNext()) {
                        java.lang.String next = itKeys.next();
                        jsUploadFindUploadTask.setRequestHeader(next, jSONObject.getString(next));
                    }
                } catch (org.json.JSONException e) {
                    e.printStackTrace();
                }
            }
        } else if ("pause".equals(str)) {
            io.dcloud.net.JsUpload jsUploadFindUploadTask2 = findUploadTask(strObtainAppId, strArr[0]);
            if (jsUploadFindUploadTask2 != null && jsUploadFindUploadTask2.isStart) {
                this.mUploadMgr.abort(jsUploadFindUploadTask2.mUploadNetWork);
                jsUploadFindUploadTask2.isStart = false;
                return null;
            }
        } else if ("abort".equals(str)) {
            io.dcloud.net.JsUpload jsUploadFindUploadTask3 = findUploadTask(strObtainAppId, strArr[0]);
            if (jsUploadFindUploadTask3 != null) {
                this.mUploadMgr.abort(jsUploadFindUploadTask3.mUploadNetWork);
                this.mAppsUploadTasks.get(strObtainAppId).remove(jsUploadFindUploadTask3);
                return null;
            }
        } else if ("createUpload".equals(str)) {
            try {
                pushUploadTask(strObtainAppId, createUploadTask(iWebview, new org.json.JSONObject(strArr[0])));
                return null;
            } catch (org.json.JSONException e2) {
                e2.printStackTrace();
            }
        } else {
            if ("enumerate".equals(str)) {
                io.dcloud.common.util.JSUtil.execCallback(iWebview, strArr[0], enumerate(strArr[0], this.mAppsUploadTasks.get(strObtainAppId)), io.dcloud.common.util.JSUtil.OK, false);
                return null;
            }
            if ("clear".equals(str)) {
                java.util.ArrayList<io.dcloud.net.JsUpload> arrayList = this.mAppsUploadTasks.get(strObtainAppId);
                int i = java.lang.Integer.parseInt(strArr[0]);
                if (arrayList != null) {
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        io.dcloud.net.JsUpload jsUpload = arrayList.get(size);
                        if (jsUpload != null && i == jsUpload.mState) {
                            io.dcloud.common.util.net.UploadMgr.getUploadMgr().abort(jsUpload.mUploadNetWork);
                            arrayList.remove(size);
                        }
                    }
                }
            } else if ("startAll".equals(str)) {
                java.util.ArrayList<io.dcloud.net.JsUpload> arrayList2 = this.mAppsUploadTasks.get(strObtainAppId);
                if (arrayList2 != null) {
                    for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                        this.mUploadMgr.start(arrayList2.get(i2).mUploadNetWork);
                    }
                }
            } else if ("addFile".equals(str)) {
                try {
                    findUploadTask(strObtainAppId, strArr[0]).addFile(iWebview, iWebview.obtainFrameView().obtainApp().convert2AbsFullPath(iWebview.obtainFullUrl(), strArr[1]), new org.json.JSONObject(strArr[2]));
                    return null;
                } catch (org.json.JSONException e3) {
                    e3.printStackTrace();
                }
            } else if ("addData".equals(str)) {
                findUploadTask(strObtainAppId, strArr[0]).addData(strArr[1], strArr[2]);
                return null;
            }
        }
        return null;
    }
}
