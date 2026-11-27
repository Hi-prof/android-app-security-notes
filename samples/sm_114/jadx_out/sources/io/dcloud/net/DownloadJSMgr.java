package io.dcloud.net;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class DownloadJSMgr {
    static final int DELETE = 2;
    static final int SAVE = 1;
    private static io.dcloud.net.DownloadJSMgr mDownloadJSMgr;
    public java.util.HashMap<java.lang.String, io.dcloud.net.DownloadJSMgr.AppDownloadInfo> mAppsDownloadTasks;
    io.dcloud.net.DownloadJSMgr.AppDownloadInfo curAppSharePref = null;
    android.os.Handler mHander = new android.os.Handler(android.os.Looper.getMainLooper()) { // from class: io.dcloud.net.DownloadJSMgr.1
        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            int i = message.what;
            if (i == 1) {
                java.lang.String[] strArr = (java.lang.String[]) message.obj;
                java.lang.String str = strArr[0];
                java.lang.String str2 = strArr[1];
                java.lang.String str3 = strArr[2];
                android.content.SharedPreferences.Editor editorEdit = io.dcloud.net.DownloadJSMgr.this.getAppTaskList(str).sharePref.edit();
                editorEdit.putString(str2, str3);
                editorEdit.commit();
                return;
            }
            if (i == 2) {
                java.lang.String[] strArr2 = (java.lang.String[]) message.obj;
                java.lang.String str4 = strArr2[0];
                java.lang.String str5 = strArr2[1];
                android.content.SharedPreferences sharedPreferences = io.dcloud.net.DownloadJSMgr.this.getAppTaskList(str4).sharePref;
                if (android.text.TextUtils.isEmpty(sharedPreferences.getString(str5, ""))) {
                    return;
                }
                sharedPreferences.edit().remove(str5).commit();
            }
        }
    };

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class AppDownloadInfo {
        java.lang.String appid;
        java.util.ArrayList<io.dcloud.net.JsDownload> mList;
        android.content.SharedPreferences sharePref;

        AppDownloadInfo(android.content.Context context, io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str) {
            this.mList = null;
            this.appid = str;
            this.sharePref = context.getSharedPreferences(str + io.dcloud.net.JsDownload.DOWNLOAD_NAME, 0);
            this.mList = new java.util.ArrayList<>();
            java.util.Map<java.lang.String, ?> all = this.sharePref.getAll();
            if (all != null) {
                java.util.Iterator<java.lang.String> it = all.keySet().iterator();
                java.util.ArrayList<io.dcloud.net.JsDownload> arrayList = this.mList;
                while (it.hasNext()) {
                    try {
                        arrayList.add(new io.dcloud.net.JsDownload(io.dcloud.net.DownloadJSMgr.this, iWebview, new org.json.JSONObject((java.lang.String) all.get(it.next()))));
                    } catch (org.json.JSONException unused) {
                    }
                }
                this.mList = arrayList;
            }
        }
    }

    private DownloadJSMgr() {
        this.mAppsDownloadTasks = null;
        if (this.mAppsDownloadTasks == null) {
            this.mAppsDownloadTasks = new java.util.HashMap<>();
        }
    }

    private io.dcloud.net.JsDownload createDownloadTask(io.dcloud.common.DHInterface.IWebview iWebview, org.json.JSONObject jSONObject) {
        return new io.dcloud.net.JsDownload(this, iWebview, jSONObject);
    }

    private void enumerate(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        java.lang.String strEnumerateArr;
        io.dcloud.net.DownloadJSMgr.AppDownloadInfo appTaskList = getAppTaskList(str3);
        try {
            int i = java.lang.Integer.parseInt(str2);
            if (i == 0 || i == 1 || i == 2 || i == 3 || i == 4 || i == 5) {
                java.util.ArrayList<io.dcloud.net.JsDownload> arrayList = new java.util.ArrayList<>();
                if (appTaskList != null && !appTaskList.mList.isEmpty()) {
                    int size = appTaskList.mList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        io.dcloud.net.JsDownload jsDownload = appTaskList.mList.get(i2);
                        if (jsDownload.mWebview.obtainApp() == null) {
                            jsDownload.mWebview = iWebview;
                        }
                        if (i == jsDownload.mState) {
                            arrayList.add(jsDownload);
                        }
                    }
                }
                strEnumerateArr = enumerateArr(iWebview, arrayList);
            } else {
                strEnumerateArr = enumerateArr(iWebview, appTaskList.mList);
            }
        } catch (java.lang.Exception unused) {
            java.util.ArrayList<io.dcloud.net.JsDownload> arrayList2 = new java.util.ArrayList<>();
            if (appTaskList != null && !appTaskList.mList.isEmpty()) {
                int size2 = appTaskList.mList.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    io.dcloud.net.JsDownload jsDownload2 = appTaskList.mList.get(i3);
                    jsDownload2.mWebview = iWebview;
                    if (jsDownload2.mState != 4) {
                        arrayList2.add(jsDownload2);
                    }
                }
            }
            strEnumerateArr = enumerateArr(iWebview, arrayList2);
        }
        io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview, str, strEnumerateArr, io.dcloud.common.util.JSUtil.OK, true, false);
    }

    private java.lang.String enumerateArr(io.dcloud.common.DHInterface.IWebview iWebview, java.util.ArrayList<io.dcloud.net.JsDownload> arrayList) {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer(com.taobao.weex.el.parse.Operators.ARRAY_START_STR);
        if (arrayList != null && !arrayList.isEmpty()) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                io.dcloud.net.JsDownload jsDownload = arrayList.get(i);
                stringBuffer.append(jsDownload.toSaveJSON());
                jsDownload.addRelWebview(iWebview);
                if (i != size - 1) {
                    stringBuffer.append(",");
                }
            }
        }
        stringBuffer.append(com.taobao.weex.el.parse.Operators.ARRAY_END_STR);
        return stringBuffer.toString();
    }

    private io.dcloud.net.JsDownload findDownloadTask(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.String str2) {
        io.dcloud.net.DownloadJSMgr.AppDownloadInfo appTaskList = getAppTaskList(str);
        if (appTaskList == null) {
            return null;
        }
        int size = appTaskList.mList.size();
        for (int i = 0; i < size; i++) {
            io.dcloud.net.JsDownload jsDownload = appTaskList.mList.get(i);
            if (str2.equals(jsDownload.mUUID)) {
                if (jsDownload.mWebview.obtainApp() == null) {
                    jsDownload.mWebview = iWebview;
                }
                return jsDownload;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public io.dcloud.net.DownloadJSMgr.AppDownloadInfo getAppTaskList(java.lang.String str) {
        return this.mAppsDownloadTasks.get(str);
    }

    protected static io.dcloud.net.DownloadJSMgr getInstance() {
        if (mDownloadJSMgr == null) {
            mDownloadJSMgr = new io.dcloud.net.DownloadJSMgr();
        }
        return mDownloadJSMgr;
    }

    private void initAppDownloadList(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str) {
        if (this.mAppsDownloadTasks.containsKey(str)) {
            return;
        }
        this.mAppsDownloadTasks.put(str, new io.dcloud.net.DownloadJSMgr.AppDownloadInfo(iWebview.getContext(), iWebview, str));
    }

    private void pushDownloadTask(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, io.dcloud.net.JsDownload jsDownload) {
        io.dcloud.net.DownloadJSMgr.AppDownloadInfo appDownloadInfo = this.mAppsDownloadTasks.get(str);
        if (appDownloadInfo == null) {
            appDownloadInfo = new io.dcloud.net.DownloadJSMgr.AppDownloadInfo(iWebview.getContext(), iWebview, str);
            this.mAppsDownloadTasks.put(str, appDownloadInfo);
        }
        appDownloadInfo.mList.add(jsDownload);
    }

    void deleteDownloadTaskInfo(java.lang.String str, java.lang.String str2) {
        android.os.Message messageObtain = android.os.Message.obtain();
        messageObtain.what = 2;
        messageObtain.obj = new java.lang.String[]{str, str2};
        this.mHander.sendMessage(messageObtain);
    }

    public void dispose() {
        java.util.Iterator<java.lang.String> it = this.mAppsDownloadTasks.keySet().iterator();
        while (it.hasNext()) {
            java.util.ArrayList<io.dcloud.net.JsDownload> arrayList = getAppTaskList(it.next()).mList;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                io.dcloud.net.JsDownload jsDownload = arrayList.get(i);
                i++;
                jsDownload.saveInDatabase();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:50:0x00f8 A[Catch: Exception -> 0x0132, TryCatch #0 {Exception -> 0x0132, blocks: (B:3:0x0001, B:4:0x0016, B:6:0x001b, B:8:0x0023, B:10:0x002b, B:12:0x0033, B:13:0x0041, B:15:0x0049, B:17:0x0051, B:48:0x00e7, B:50:0x00f8, B:52:0x0103, B:53:0x0107, B:55:0x010d, B:20:0x005b, B:22:0x0063, B:24:0x0075, B:26:0x007d, B:28:0x0089, B:30:0x0092, B:32:0x009d, B:39:0x00b0, B:38:0x00a8, B:40:0x00b3, B:42:0x00bb, B:44:0x00c7, B:46:0x00df, B:56:0x011b, B:58:0x0123), top: B:63:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:52:0x0103 A[Catch: Exception -> 0x0132, TryCatch #0 {Exception -> 0x0132, blocks: (B:3:0x0001, B:4:0x0016, B:6:0x001b, B:8:0x0023, B:10:0x002b, B:12:0x0033, B:13:0x0041, B:15:0x0049, B:17:0x0051, B:48:0x00e7, B:50:0x00f8, B:52:0x0103, B:53:0x0107, B:55:0x010d, B:20:0x005b, B:22:0x0063, B:24:0x0075, B:26:0x007d, B:28:0x0089, B:30:0x0092, B:32:0x009d, B:39:0x00b0, B:38:0x00a8, B:40:0x00b3, B:42:0x00bb, B:44:0x00c7, B:46:0x00df, B:56:0x011b, B:58:0x0123), top: B:63:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:55:0x010d A[Catch: Exception -> 0x0132, LOOP:1: B:53:0x0107->B:55:0x010d, LOOP_END, TryCatch #0 {Exception -> 0x0132, blocks: (B:3:0x0001, B:4:0x0016, B:6:0x001b, B:8:0x0023, B:10:0x002b, B:12:0x0033, B:13:0x0041, B:15:0x0049, B:17:0x0051, B:48:0x00e7, B:50:0x00f8, B:52:0x0103, B:53:0x0107, B:55:0x010d, B:20:0x005b, B:22:0x0063, B:24:0x0075, B:26:0x007d, B:28:0x0089, B:30:0x0092, B:32:0x009d, B:39:0x00b0, B:38:0x00a8, B:40:0x00b3, B:42:0x00bb, B:44:0x00c7, B:46:0x00df, B:56:0x011b, B:58:0x0123), top: B:63:0x0001 }] */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public java.lang.String execute(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.String[] strArr) {
        int i;
        io.dcloud.net.JsDownload jsDownloadFindDownloadTask;
        java.lang.String str2;
        org.json.JSONObject jSONObject;
        java.util.Iterator<java.lang.String> itKeys;
        try {
            java.lang.String strObtainAppId = iWebview.obtainFrameView().obtainApp().obtainAppId();
            initAppDownloadList(iWebview, strObtainAppId);
            switch (str.hashCode()) {
                case -1944579676:
                    if (str.equals("createDownload")) {
                        pushDownloadTask(iWebview, strObtainAppId, createDownloadTask(iWebview, new org.json.JSONObject(strArr[0])));
                    }
                    break;
                case -934426579:
                    if (str.equals(io.dcloud.common.constant.AbsoluteConst.EVENTS_RESUME)) {
                        jsDownloadFindDownloadTask = findDownloadTask(iWebview, strObtainAppId, strArr[0]);
                        jsDownloadFindDownloadTask.start();
                        str2 = strArr[1];
                        if (!android.text.TextUtils.isEmpty(str2)) {
                            jSONObject = new org.json.JSONObject(str2);
                            if (jSONObject.length() > 0) {
                                itKeys = jSONObject.keys();
                                while (itKeys.hasNext()) {
                                    java.lang.String next = itKeys.next();
                                    jsDownloadFindDownloadTask.setRequestHeader(next, jSONObject.getString(next));
                                }
                            }
                        }
                    }
                    break;
                case 92611376:
                    if (str.equals("abort")) {
                        io.dcloud.net.JsDownload jsDownloadFindDownloadTask2 = findDownloadTask(iWebview, strObtainAppId, strArr[0]);
                        if (!io.dcloud.common.util.PdrUtil.isEmpty(jsDownloadFindDownloadTask2)) {
                            getAppTaskList(strObtainAppId).mList.remove(jsDownloadFindDownloadTask2);
                            jsDownloadFindDownloadTask2.mPause = true;
                            io.dcloud.common.util.net.DownloadMgr.getDownloadMgr().removeTask(jsDownloadFindDownloadTask2.mDownloadNetWork);
                            jsDownloadFindDownloadTask2.abort();
                        }
                    }
                    break;
                case 94746189:
                    if (str.equals("clear")) {
                        io.dcloud.net.DownloadJSMgr.AppDownloadInfo appTaskList = getAppTaskList(strObtainAppId);
                        int i2 = java.lang.Integer.parseInt(strArr[0]);
                        if (appTaskList != null) {
                            for (int size = appTaskList.mList.size() - 1; size >= 0; size--) {
                                io.dcloud.net.JsDownload jsDownload = appTaskList.mList.get(size);
                                if (i2 == -1 || i2 == (i = jsDownload.mState) || (i2 == -10000 && i != 4)) {
                                    jsDownload.abort();
                                    appTaskList.mList.remove(size);
                                }
                            }
                        }
                    }
                    break;
                case 106440182:
                    if (str.equals("pause")) {
                        io.dcloud.net.JsDownload jsDownloadFindDownloadTask3 = findDownloadTask(iWebview, strObtainAppId, strArr[0]);
                        jsDownloadFindDownloadTask3.mPause = true;
                        io.dcloud.common.util.net.DownloadMgr.getDownloadMgr().removeTask(jsDownloadFindDownloadTask3.mDownloadNetWork);
                    }
                    break;
                case 109757538:
                    if (str.equals("start")) {
                        jsDownloadFindDownloadTask = findDownloadTask(iWebview, strObtainAppId, strArr[0]);
                        jsDownloadFindDownloadTask.start();
                        str2 = strArr[1];
                        if (!android.text.TextUtils.isEmpty(str2)) {
                            jSONObject = new org.json.JSONObject(str2);
                            if (jSONObject.length() > 0) {
                                itKeys = jSONObject.keys();
                                while (itKeys.hasNext()) {
                                    java.lang.String next2 = itKeys.next();
                                    jsDownloadFindDownloadTask.setRequestHeader(next2, jSONObject.getString(next2));
                                }
                            }
                        }
                    }
                    break;
                case 247395940:
                    if (str.equals("enumerate")) {
                        enumerate(iWebview, strArr[0], strArr[1], strObtainAppId);
                    }
                    break;
                case 1316768223:
                    if (str.equals("startAll")) {
                        io.dcloud.net.DownloadJSMgr.AppDownloadInfo appTaskList2 = getAppTaskList(strObtainAppId);
                        if (appTaskList2.mList != null) {
                            for (int i3 = 0; i3 < appTaskList2.mList.size(); i3++) {
                                appTaskList2.mList.get(i3).start();
                            }
                        }
                    }
                    break;
                default:
                    break;
            }
            return null;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    void saveDownloadTaskInfo(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        android.os.Message messageObtain = android.os.Message.obtain();
        messageObtain.what = 1;
        messageObtain.obj = new java.lang.String[]{str, str2, str3};
        this.mHander.sendMessage(messageObtain);
    }
}
