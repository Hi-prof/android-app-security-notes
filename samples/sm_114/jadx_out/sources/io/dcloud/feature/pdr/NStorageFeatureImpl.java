package io.dcloud.feature.pdr;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class NStorageFeatureImpl implements io.dcloud.common.DHInterface.IFeature {

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class a implements java.lang.Runnable {
        final /* synthetic */ io.dcloud.common.util.db.DCStorage a;
        final /* synthetic */ io.dcloud.common.DHInterface.IWebview b;
        final /* synthetic */ java.lang.String c;
        final /* synthetic */ java.lang.String d;

        a(io.dcloud.common.util.db.DCStorage dCStorage, io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.String str2) {
            this.a = dCStorage;
            this.b = iWebview;
            this.c = str;
            this.d = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            java.lang.Object obj;
            io.dcloud.common.util.db.DCStorage.StorageInfo storageInfoPerformGetItem = this.a.performGetItem(this.b.obtainApp().obtainAppId(), this.c);
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            int i = storageInfoPerformGetItem.code;
            if (i == 1 && (obj = storageInfoPerformGetItem.v) != null) {
                try {
                    jSONObject.put("data", java.lang.String.valueOf(obj));
                } catch (org.json.JSONException e) {
                    e.printStackTrace();
                }
                io.dcloud.common.util.JSUtil.execCallback(this.b, this.d, jSONObject, io.dcloud.common.util.JSUtil.OK, false);
                return;
            }
            try {
                jSONObject.put("code", i);
                jSONObject.put("message", storageInfoPerformGetItem.meg);
            } catch (org.json.JSONException e2) {
                e2.printStackTrace();
            }
            io.dcloud.common.util.JSUtil.execCallback(this.b, this.d, jSONObject, io.dcloud.common.util.JSUtil.ERROR, false);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class b implements java.lang.Runnable {
        final /* synthetic */ io.dcloud.common.util.db.DCStorage a;
        final /* synthetic */ io.dcloud.common.DHInterface.IWebview b;
        final /* synthetic */ java.lang.String c;
        final /* synthetic */ java.lang.String d;
        final /* synthetic */ java.lang.String e;

        b(io.dcloud.common.util.db.DCStorage dCStorage, io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.String str2, java.lang.String str3) {
            this.a = dCStorage;
            this.b = iWebview;
            this.c = str;
            this.d = str2;
            this.e = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            io.dcloud.common.util.db.DCStorage.StorageInfo storageInfoPerformSetItem = this.a.performSetItem(this.b.getActivity(), this.b.obtainApp().obtainAppId(), this.c, this.d);
            int i = io.dcloud.common.util.JSUtil.ERROR;
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            int i2 = storageInfoPerformSetItem.code;
            if (i2 == 1) {
                i = io.dcloud.common.util.JSUtil.OK;
            } else {
                try {
                    jSONObject.put("code", i2);
                    jSONObject.put("message", storageInfoPerformSetItem.meg);
                } catch (org.json.JSONException e) {
                    e.printStackTrace();
                }
            }
            io.dcloud.common.util.JSUtil.execCallback(this.b, this.e, jSONObject, i, false);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class c implements java.lang.Runnable {
        final /* synthetic */ io.dcloud.common.util.db.DCStorage a;
        final /* synthetic */ io.dcloud.common.DHInterface.IWebview b;
        final /* synthetic */ java.lang.String c;

        c(io.dcloud.common.util.db.DCStorage dCStorage, io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str) {
            this.a = dCStorage;
            this.b = iWebview;
            this.c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            io.dcloud.common.util.db.DCStorage.StorageInfo storageInfoPerformClear = this.a.performClear(this.b.getContext(), this.b.obtainApp().obtainAppId());
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            int i = storageInfoPerformClear.code;
            if (i == 1) {
                io.dcloud.common.util.JSUtil.execCallback(this.b, this.c, jSONObject, io.dcloud.common.util.JSUtil.OK, false);
                return;
            }
            try {
                jSONObject.put("code", i);
                jSONObject.put("message", storageInfoPerformClear.meg);
            } catch (org.json.JSONException e) {
                e.printStackTrace();
            }
            io.dcloud.common.util.JSUtil.execCallback(this.b, this.c, jSONObject, io.dcloud.common.util.JSUtil.ERROR, false);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class d implements java.lang.Runnable {
        final /* synthetic */ io.dcloud.common.util.db.DCStorage a;
        final /* synthetic */ io.dcloud.common.DHInterface.IWebview b;
        final /* synthetic */ java.lang.String c;
        final /* synthetic */ java.lang.String d;

        d(io.dcloud.common.util.db.DCStorage dCStorage, io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.String str2) {
            this.a = dCStorage;
            this.b = iWebview;
            this.c = str;
            this.d = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            io.dcloud.common.util.db.DCStorage.StorageInfo storageInfoPerformRemoveItem = this.a.performRemoveItem(this.b.getContext(), this.b.obtainApp().obtainAppId(), this.c);
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            int i = storageInfoPerformRemoveItem.code;
            if (i == 1) {
                io.dcloud.common.util.JSUtil.execCallback(this.b, this.d, jSONObject, io.dcloud.common.util.JSUtil.OK, false);
                return;
            }
            if (i == -3) {
                io.dcloud.common.util.JSUtil.execCallback(this.b, this.d, jSONObject, io.dcloud.common.util.JSUtil.OK, false);
                return;
            }
            try {
                jSONObject.put("code", i);
                jSONObject.put("message", storageInfoPerformRemoveItem.meg);
            } catch (org.json.JSONException e) {
                e.printStackTrace();
            }
            io.dcloud.common.util.JSUtil.execCallback(this.b, this.d, jSONObject, io.dcloud.common.util.JSUtil.ERROR, false);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class e implements java.lang.Runnable {
        final /* synthetic */ io.dcloud.common.util.db.DCStorage a;
        final /* synthetic */ io.dcloud.common.DHInterface.IWebview b;
        final /* synthetic */ java.lang.String c;

        e(io.dcloud.common.util.db.DCStorage dCStorage, io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str) {
            this.a = dCStorage;
            this.b = iWebview;
            this.c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            java.lang.Object obj;
            org.json.JSONArray jSONArray = new org.json.JSONArray();
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            io.dcloud.common.util.db.DCStorage.StorageInfo storageInfoPerformGetAllKeys = this.a.performGetAllKeys(this.b.obtainApp().obtainAppId());
            int i = storageInfoPerformGetAllKeys.code;
            if (i != 1 || (obj = storageInfoPerformGetAllKeys.v) == null) {
                try {
                    jSONObject.put("code", i);
                    jSONObject.put("message", storageInfoPerformGetAllKeys.meg);
                } catch (org.json.JSONException e) {
                    e.printStackTrace();
                }
                io.dcloud.common.util.JSUtil.execCallback(this.b, this.c, jSONObject, io.dcloud.common.util.JSUtil.ERROR, false);
                return;
            }
            java.util.List list = (java.util.List) obj;
            if (list.size() > 0) {
                java.util.Iterator it = list.iterator();
                while (it.hasNext()) {
                    jSONArray.put((java.lang.String) it.next());
                }
            }
            try {
                jSONObject.put("keys", jSONArray);
            } catch (org.json.JSONException e2) {
                e2.printStackTrace();
            }
            io.dcloud.common.util.JSUtil.execCallback(this.b, this.c, jSONObject, io.dcloud.common.util.JSUtil.OK, false);
        }
    }

    void a(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.String str2) {
        try {
            io.dcloud.common.util.db.DCStorage dCStorage = io.dcloud.common.util.db.DCStorage.getDCStorage(iWebview.getContext());
            if (dCStorage != null) {
                dCStorage.execute(new io.dcloud.feature.pdr.NStorageFeatureImpl.a(dCStorage, iWebview, str, str2));
            }
        } catch (java.lang.Exception unused) {
        }
    }

    java.lang.String b(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str) {
        io.dcloud.common.util.db.DCStorage.StorageInfo storageInfoPerformGetItem;
        java.lang.Object obj;
        try {
            io.dcloud.common.util.db.DCStorage dCStorage = io.dcloud.common.util.db.DCStorage.getDCStorage(iWebview.getContext());
            if (dCStorage == null || (storageInfoPerformGetItem = dCStorage.performGetItem(iWebview.obtainApp().obtainAppId(), str)) == null || storageInfoPerformGetItem.code != 1 || (obj = storageInfoPerformGetItem.v) == null) {
                return null;
            }
            return (java.lang.String) obj;
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    void c(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.String str2) {
        try {
            io.dcloud.common.util.db.DCStorage dCStorage = io.dcloud.common.util.db.DCStorage.getDCStorage(iWebview.getContext());
            if (dCStorage != null) {
                dCStorage.performSetItem(iWebview.getActivity(), iWebview.obtainApp().obtainAppId(), str, str2);
            }
        } catch (java.lang.Exception unused) {
        }
    }

    void d(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str) {
        try {
            io.dcloud.common.util.db.DCStorage dCStorage = io.dcloud.common.util.db.DCStorage.getDCStorage(iWebview.getContext());
            if (dCStorage != null) {
                dCStorage.performRemoveItem(iWebview.getContext(), iWebview.obtainApp().obtainAppId(), str);
            }
        } catch (java.lang.Exception unused) {
        }
    }

    @Override // io.dcloud.common.DHInterface.IFeature
    public void dispose(java.lang.String str) {
        io.dcloud.common.util.db.DCStorage dCStorage = io.dcloud.common.util.db.DCStorage.getDCStorage(null);
        if (dCStorage != null) {
            dCStorage.close();
        }
    }

    @Override // io.dcloud.common.DHInterface.IFeature
    public java.lang.String execute(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.String[] strArr) {
        str.getClass();
        str.hashCode();
        switch (str) {
            case "clearAsync":
                a(iWebview, strArr[0]);
                return null;
            case "setItemAsync":
                a(iWebview, strArr[1], strArr[2], strArr[0]);
                return null;
            case "getItem":
                java.lang.String strB = b(iWebview, strArr[0]);
                if (strB == null) {
                    return "null:";
                }
                return "string:" + strB;
            case "removeItemAsync":
                b(iWebview, strArr[1], strArr[0]);
                return null;
            case "key":
                return io.dcloud.common.util.Deprecated_JSUtil.wrapJsVar(a(iWebview, java.lang.Integer.parseInt(strArr[0])), true);
            case "clear":
                a(iWebview);
                return null;
            case "getAllKeys":
                return b(iWebview);
            case "getLength":
                return io.dcloud.common.util.JSUtil.wrapJsVar(c(iWebview));
            case "removeItem":
                d(iWebview, strArr[0]);
                return null;
            case "getAllKeysAsync":
                c(iWebview, strArr[0]);
                return null;
            case "setItem":
                c(iWebview, strArr[0], strArr[1]);
                return null;
            case "getItemAsync":
                a(iWebview, strArr[1], strArr[0]);
                return null;
            default:
                return null;
        }
    }

    @Override // io.dcloud.common.DHInterface.IFeature
    public void init(io.dcloud.common.DHInterface.AbsMgr absMgr, java.lang.String str) {
    }

    void a(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        try {
            io.dcloud.common.util.db.DCStorage dCStorage = io.dcloud.common.util.db.DCStorage.getDCStorage(iWebview.getContext());
            if (dCStorage != null) {
                dCStorage.execute(new io.dcloud.feature.pdr.NStorageFeatureImpl.b(dCStorage, iWebview, str, str2, str3));
            }
        } catch (java.lang.Exception unused) {
        }
    }

    void c(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str) {
        try {
            io.dcloud.common.util.db.DCStorage dCStorage = io.dcloud.common.util.db.DCStorage.getDCStorage(iWebview.getContext());
            if (dCStorage != null) {
                dCStorage.execute(new io.dcloud.feature.pdr.NStorageFeatureImpl.e(dCStorage, iWebview, str));
            }
        } catch (java.lang.Exception unused) {
        }
    }

    void b(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.String str2) {
        try {
            io.dcloud.common.util.db.DCStorage dCStorage = io.dcloud.common.util.db.DCStorage.getDCStorage(iWebview.getContext());
            if (dCStorage != null) {
                dCStorage.execute(new io.dcloud.feature.pdr.NStorageFeatureImpl.d(dCStorage, iWebview, str, str2));
            }
        } catch (java.lang.Exception unused) {
        }
    }

    void a(io.dcloud.common.DHInterface.IWebview iWebview) {
        try {
            io.dcloud.common.util.db.DCStorage dCStorage = io.dcloud.common.util.db.DCStorage.getDCStorage(iWebview.getContext());
            if (dCStorage != null) {
                dCStorage.performClear(iWebview.getContext(), iWebview.obtainApp().obtainAppId());
            }
        } catch (java.lang.Exception unused) {
        }
    }

    int c(io.dcloud.common.DHInterface.IWebview iWebview) {
        java.lang.Object obj;
        try {
            io.dcloud.common.util.db.DCStorage dCStorage = io.dcloud.common.util.db.DCStorage.getDCStorage(iWebview.getContext());
            if (dCStorage == null) {
                return 0;
            }
            io.dcloud.common.util.db.DCStorage.StorageInfo storageInfoPerformGetAllKeys = dCStorage.performGetAllKeys(iWebview.obtainApp().obtainAppId());
            if (storageInfoPerformGetAllKeys.code != 1 || (obj = storageInfoPerformGetAllKeys.v) == null) {
                return 0;
            }
            return ((java.util.List) obj).size();
        } catch (java.lang.Exception unused) {
            return 0;
        }
    }

    java.lang.String b(io.dcloud.common.DHInterface.IWebview iWebview) {
        java.lang.Object obj;
        try {
            io.dcloud.common.util.db.DCStorage dCStorage = io.dcloud.common.util.db.DCStorage.getDCStorage(iWebview.getContext());
            if (dCStorage != null) {
                io.dcloud.common.util.db.DCStorage.StorageInfo storageInfoPerformGetAllKeys = dCStorage.performGetAllKeys(iWebview.obtainApp().obtainAppId());
                if (storageInfoPerformGetAllKeys.code == 1 && (obj = storageInfoPerformGetAllKeys.v) != null) {
                    java.util.List list = (java.util.List) obj;
                    java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer(com.taobao.weex.el.parse.Operators.ARRAY_START_STR);
                    if (list.size() > 0) {
                        int size = list.size() - 1;
                        for (int i = 0; i < list.size(); i++) {
                            stringBuffer.append("'").append((java.lang.String) list.get(i)).append("'");
                            if (i == size) {
                                stringBuffer.append(com.taobao.weex.el.parse.Operators.ARRAY_END_STR);
                            } else {
                                stringBuffer.append(",");
                            }
                        }
                    } else {
                        stringBuffer.append(com.taobao.weex.el.parse.Operators.ARRAY_END_STR);
                    }
                    return stringBuffer.toString();
                }
                return "";
            }
            return "";
        } catch (java.lang.Exception unused) {
            return "";
        }
    }

    void a(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str) {
        try {
            io.dcloud.common.util.db.DCStorage dCStorage = io.dcloud.common.util.db.DCStorage.getDCStorage(iWebview.getContext());
            if (dCStorage != null) {
                dCStorage.execute(new io.dcloud.feature.pdr.NStorageFeatureImpl.c(dCStorage, iWebview, str));
            }
        } catch (java.lang.Exception unused) {
        }
    }

    java.lang.String a(io.dcloud.common.DHInterface.IWebview iWebview, int i) {
        io.dcloud.common.util.db.DCStorage.StorageInfo storageInfoPerformGetAllKeys;
        java.lang.Object obj;
        java.util.List list;
        try {
            io.dcloud.common.util.db.DCStorage dCStorage = io.dcloud.common.util.db.DCStorage.getDCStorage(iWebview.getContext());
            if (dCStorage != null && (obj = (storageInfoPerformGetAllKeys = dCStorage.performGetAllKeys(iWebview.obtainApp().obtainAppId())).v) != null && (obj instanceof java.util.List) && storageInfoPerformGetAllKeys.code == 1 && (list = (java.util.List) obj) != null && i < list.size()) {
                return (java.lang.String) list.get(i);
            }
            return "";
        } catch (java.lang.Exception unused) {
            return "";
        }
    }
}
