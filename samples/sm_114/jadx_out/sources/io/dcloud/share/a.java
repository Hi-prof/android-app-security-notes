package io.dcloud.share;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class a {
    private io.dcloud.common.DHInterface.AbsMgr a;
    private java.util.HashMap c;
    private java.util.HashMap e;
    private java.util.HashMap b = new java.util.HashMap();
    public java.util.ArrayList d = new java.util.ArrayList();

    protected a(io.dcloud.common.DHInterface.AbsMgr absMgr, java.lang.String str) {
        this.a = absMgr;
        this.e = (java.util.HashMap) this.a.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.FeatureMgr, 4, str);
    }

    public java.lang.String a(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.String[] strArr) {
        io.dcloud.common.util.AppRuntime.checkPrivacyComplianceAndPrompt(iWebview.getContext(), "Share-" + str);
        str.getClass();
        str.hashCode();
        switch (str) {
            case "launchMiniProgram":
                java.lang.String str2 = strArr[0];
                io.dcloud.share.IFShareApi iFShareApi = (io.dcloud.share.IFShareApi) this.b.get(strArr[1]);
                if (!(iFShareApi instanceof io.dcloud.share.IWeiXinFShareApi)) {
                    io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview, str2, io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.DOMException.JSON_ERROR_INFO, -3, io.dcloud.common.constant.DOMException.MSG_NOT_SUPPORT), io.dcloud.common.util.JSUtil.ERROR, true, false);
                    break;
                } else {
                    ((io.dcloud.share.IWeiXinFShareApi) iFShareApi).launchMiniProgram(iWebview, strArr[2], str2);
                    break;
                }
                break;
            case "create":
                io.dcloud.share.ShareAuthorizeView shareAuthorizeView = new io.dcloud.share.ShareAuthorizeView(iWebview, strArr[1]);
                if (strArr[2] == null || !strArr[1].equals(io.dcloud.common.constant.AbsoluteConst.FALSE)) {
                    float scale = iWebview.getScale();
                    iWebview.addFrameItem(shareAuthorizeView, io.dcloud.common.adapter.ui.AdaFrameItem.LayoutParamsUtil.createLayoutParams((int) (java.lang.Integer.parseInt(strArr[3]) * scale), (int) (java.lang.Integer.parseInt(strArr[4]) * scale), (int) (java.lang.Integer.parseInt(strArr[5]) * scale), (int) (java.lang.Integer.parseInt(strArr[6]) * scale)));
                }
                this.c.put(strArr[0], shareAuthorizeView);
                break;
            case "forbid":
                ((io.dcloud.share.IFShareApi) this.b.get(strArr[0])).forbid(iWebview);
                break;
            case "setVisible":
                io.dcloud.share.ShareAuthorizeView shareAuthorizeView2 = (io.dcloud.share.ShareAuthorizeView) this.c.get(strArr[0]);
                if (!java.lang.Boolean.parseBoolean(strArr[1])) {
                    shareAuthorizeView2.setVisibility(8);
                    break;
                } else {
                    shareAuthorizeView2.setVisibility(0);
                    break;
                }
                break;
            case "getServices":
                io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview, strArr[0], a(iWebview), 1, true, false);
                break;
            case "load":
                ((io.dcloud.share.ShareAuthorizeView) this.c.get(strArr[0])).load(this, strArr[1]);
                break;
            case "send":
                io.dcloud.share.IFShareApi iFShareApi2 = (io.dcloud.share.IFShareApi) this.b.get(strArr[1]);
                android.app.Application application = iWebview.getActivity().getApplication();
                if (application instanceof io.dcloud.application.DCloudApplication) {
                    ((io.dcloud.application.DCloudApplication) application).stopB2FOnce();
                }
                iFShareApi2.send(iWebview, strArr[0], strArr[2]);
                break;
            case "sendWithSystem":
                a(iWebview, strArr[0], strArr[1]);
                break;
            case "openCustomerServiceChat":
                java.lang.String str3 = strArr[0];
                io.dcloud.share.IFShareApi iFShareApi3 = (io.dcloud.share.IFShareApi) this.b.get(strArr[1]);
                if (!(iFShareApi3 instanceof io.dcloud.share.IWeiXinFShareApi)) {
                    io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview, str3, io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.DOMException.JSON_ERROR_INFO, -3, io.dcloud.common.constant.DOMException.MSG_NOT_SUPPORT), io.dcloud.common.util.JSUtil.ERROR, true, false);
                    break;
                } else {
                    ((io.dcloud.share.IWeiXinFShareApi) iFShareApi3).openCustomerServiceChat(iWebview, strArr[2], str3);
                    break;
                }
                break;
            case "authorize":
                ((io.dcloud.share.IFShareApi) this.b.get(strArr[1])).authorize(iWebview, strArr[0], strArr[2]);
                break;
        }
        return null;
    }

    public java.lang.String a(java.lang.String str) {
        if (io.dcloud.common.util.PdrUtil.isEquals(str, "sinaweibo")) {
            return (java.lang.String) this.e.get("sina");
        }
        if (io.dcloud.common.util.PdrUtil.isEquals(str, "tencentweibo")) {
            return (java.lang.String) this.e.get("tencent");
        }
        return null;
    }

    private java.lang.String a(io.dcloud.common.DHInterface.IWebview iWebview) {
        java.lang.String str;
        java.lang.Exception e;
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer(com.taobao.weex.el.parse.Operators.ARRAY_START_STR);
        java.util.HashMap map = this.e;
        if (map != null && !map.isEmpty()) {
            java.lang.String str2 = null;
            int i = 0;
            for (java.lang.String str3 : this.e.keySet()) {
                try {
                    io.dcloud.share.IFShareApi iFShareApi = (io.dcloud.share.IFShareApi) this.b.get(str3);
                    if (iFShareApi == null) {
                        str = (java.lang.String) this.e.get(str3);
                        try {
                            iFShareApi = (io.dcloud.share.IFShareApi) java.lang.Class.forName(str).newInstance();
                            iFShareApi.initConfig();
                            this.b.put(iFShareApi.getId(), iFShareApi);
                            str2 = str;
                        } catch (android.content.res.Resources.NotFoundException unused) {
                            str2 = str;
                            io.dcloud.common.adapter.util.Logger.e("ShareApiManager getServices " + str2 + " is Not found!");
                        } catch (java.lang.Exception e2) {
                            e = e2;
                            io.dcloud.common.adapter.util.Logger.e("ShareApiManager getServices " + str + " Exception =" + e);
                            str2 = str;
                        }
                    }
                    stringBuffer.append(iFShareApi.getJsonObject(iWebview));
                    if (i != this.b.size()) {
                        stringBuffer.append(",");
                    }
                } catch (android.content.res.Resources.NotFoundException unused2) {
                } catch (java.lang.Exception e3) {
                    str = str2;
                    e = e3;
                }
                i++;
            }
        }
        stringBuffer.append(com.taobao.weex.el.parse.Operators.ARRAY_END_STR);
        return stringBuffer.toString();
    }

    public void a(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.String str2) {
        android.net.Uri uriFromFile;
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str2);
            java.lang.String strOptString = jSONObject.optString(com.facebook.common.util.UriUtil.LOCAL_CONTENT_SCHEME);
            java.lang.String strOptString2 = jSONObject.optString(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_TITLE);
            java.lang.String strOptString3 = jSONObject.optString("href");
            if (!android.text.TextUtils.isEmpty(strOptString3)) {
                strOptString = strOptString + "  " + strOptString3;
            }
            org.json.JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("pictures");
            android.content.Intent intent = new android.content.Intent();
            if (!io.dcloud.common.util.PdrUtil.isEmpty(jSONArrayOptJSONArray)) {
                java.util.ArrayList arrayList = new java.util.ArrayList();
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    java.lang.String strConvert2AbsFullPath = iWebview.obtainApp().convert2AbsFullPath(iWebview.obtainFullUrl(), jSONArrayOptJSONArray.optString(i));
                    if (strConvert2AbsFullPath.startsWith(io.dcloud.common.adapter.util.DeviceInfo.sPrivateDir)) {
                        java.lang.String str3 = io.dcloud.common.adapter.util.DeviceInfo.sPrivateExternalDir + strConvert2AbsFullPath.substring(io.dcloud.common.adapter.util.DeviceInfo.sPrivateDir.length());
                        if (io.dcloud.common.adapter.io.DHFile.copyFile(strConvert2AbsFullPath, str3, true, false) == 1) {
                            strConvert2AbsFullPath = str3;
                        }
                    }
                    if (android.os.Build.VERSION.SDK_INT >= 24) {
                        uriFromFile = a(iWebview.getContext(), new java.io.File(strConvert2AbsFullPath), intent);
                    } else {
                        uriFromFile = android.net.Uri.fromFile(new java.io.File(strConvert2AbsFullPath));
                    }
                    arrayList.add(uriFromFile);
                }
                a(intent, strOptString, strOptString2, arrayList);
            } else {
                a(intent, strOptString, strOptString2, null);
            }
            android.content.Intent intentCreateChooser = android.content.Intent.createChooser(intent, "");
            intentCreateChooser.addFlags(1);
            iWebview.getActivity().startActivity(intentCreateChooser);
            io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview, str, "", io.dcloud.common.util.JSUtil.OK, false, false);
        } catch (java.lang.Exception unused) {
            io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview, str, io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.DOMException.JSON_ERROR_INFO, -99, io.dcloud.common.constant.DOMException.MSG_UNKNOWN_ERROR), io.dcloud.common.util.JSUtil.ERROR, true, false);
        }
    }

    private android.content.Intent a(android.content.Intent intent, java.lang.String str, java.lang.String str2, java.util.ArrayList arrayList) {
        if (!io.dcloud.common.util.PdrUtil.isEmpty(str)) {
            intent.putExtra("android.intent.extra.TEXT", str);
        }
        if (!io.dcloud.common.util.PdrUtil.isEmpty(str2)) {
            intent.putExtra("android.intent.extra.SUBJECT", str2);
        }
        if (!io.dcloud.common.util.PdrUtil.isEmpty(arrayList) && arrayList.size() > 0) {
            intent.setType("image/*");
            if (arrayList.size() > 1) {
                intent.setAction("android.intent.action.SEND_MULTIPLE");
                intent.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList);
                return intent;
            }
            intent.setAction("android.intent.action.SEND");
            intent.putExtra("android.intent.extra.STREAM", (android.os.Parcelable) arrayList.get(0));
            return intent;
        }
        intent.setAction("android.intent.action.SEND");
        intent.setType(androidx.webkit.internal.AssetHelper.DEFAULT_MIME_TYPE);
        return intent;
    }

    public android.net.Uri a(android.content.Context context, java.io.File file, android.content.Intent intent) {
        java.lang.String absolutePath = file.getAbsolutePath();
        android.content.ContentResolver contentResolver = context.getContentResolver();
        android.net.Uri uri = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        android.database.Cursor cursorQuery = contentResolver.query(uri, new java.lang.String[]{"_id"}, "_data=? ", new java.lang.String[]{absolutePath}, null);
        android.net.Uri uriForFile = null;
        if (cursorQuery != null) {
            if (cursorQuery.moveToFirst()) {
                int i = cursorQuery.getInt(cursorQuery.getColumnIndex("_id"));
                uriForFile = android.net.Uri.withAppendedPath(android.net.Uri.parse("content://media/external/images/media"), "" + i);
            }
            cursorQuery.close();
        }
        if (uriForFile == null) {
            uriForFile = androidx.core.content.FileProvider.getUriForFile(context, context.getPackageName() + ".dc.fileprovider", file);
        }
        if (uriForFile != null) {
            return uriForFile;
        }
        android.content.ContentValues contentValues = new android.content.ContentValues();
        contentValues.put("_data", absolutePath);
        return context.getContentResolver().insert(uri, contentValues);
    }

    public void a() {
        java.util.HashMap map = this.b;
        if (map != null) {
            java.util.Iterator it = map.entrySet().iterator();
            while (it.hasNext()) {
                ((io.dcloud.share.IFShareApi) ((java.util.Map.Entry) it.next()).getValue()).dispose();
            }
        }
        java.util.HashMap map2 = this.c;
        if (map2 != null) {
            java.util.Iterator it2 = map2.entrySet().iterator();
            while (it2.hasNext()) {
                ((io.dcloud.share.ShareAuthorizeView) ((java.util.Map.Entry) it2.next()).getValue()).dispose();
            }
        }
        java.util.HashMap map3 = this.e;
        if (map3 != null) {
            map3.clear();
        }
        java.util.HashMap map4 = this.b;
        if (map4 != null) {
            map4.clear();
        }
        java.util.HashMap map5 = this.c;
        if (map5 != null) {
            map5.clear();
        }
    }
}
