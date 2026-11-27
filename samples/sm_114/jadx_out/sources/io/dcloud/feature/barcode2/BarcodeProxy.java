package io.dcloud.feature.barcode2;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class BarcodeProxy implements io.dcloud.common.DHInterface.ISysEventListener {
    public static android.content.Context context = null;
    public static boolean save = false;
    public java.lang.String mId;
    io.dcloud.feature.barcode2.BarcodeFrameItem mBarcodeView = null;
    boolean mIsRegisetedSysEvent = false;

    public void appendToFrameView(io.dcloud.common.adapter.ui.AdaFrameView adaFrameView) {
        io.dcloud.feature.barcode2.BarcodeFrameItem barcodeFrameItem = this.mBarcodeView;
        if (barcodeFrameItem != null) {
            barcodeFrameItem.appendToFrameView(adaFrameView);
        }
    }

    void execute(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.String[] strArr) {
        io.dcloud.feature.barcode2.BarcodeFrameItem barcodeFrameItem;
        boolean z = false;
        if ("start".equals(str)) {
            if (!io.dcloud.common.util.PdrUtil.isEmpty(this.mBarcodeView.errorMsg)) {
                this.mBarcodeView.runJsCallBack(io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.DOMException.JSON_ERROR_INFO, 8, this.mBarcodeView.errorMsg), io.dcloud.common.util.JSUtil.ERROR, true, true);
                return;
            }
            org.json.JSONObject jSONObjectCreateJSONObject = io.dcloud.common.util.JSONUtil.createJSONObject(strArr[1]);
            if (jSONObjectCreateJSONObject != null) {
                boolean z2 = io.dcloud.common.util.PdrUtil.parseBoolean(io.dcloud.common.util.JSONUtil.getString(jSONObjectCreateJSONObject, "conserve"), false, false);
                if (z2) {
                    this.mBarcodeView.mFilename = iWebview.obtainFrameView().obtainApp().convert2AbsFullPath(iWebview.obtainFullUrl(), io.dcloud.common.util.PdrUtil.getDefaultPrivateDocPath(io.dcloud.common.util.JSONUtil.getString(jSONObjectCreateJSONObject, io.dcloud.common.constant.AbsoluteConst.JSON_KEY_FILENAME), "png"));
                    io.dcloud.common.adapter.util.Logger.d("Filename:" + this.mBarcodeView.mFilename);
                }
                this.mBarcodeView.vibrate = io.dcloud.common.util.PdrUtil.parseBoolean(io.dcloud.common.util.JSONUtil.getString(jSONObjectCreateJSONObject, "vibrate"), true, false);
                this.mBarcodeView.playBeep = !android.text.TextUtils.equals(io.dcloud.common.util.JSONUtil.getString(jSONObjectCreateJSONObject, "sound"), "none");
                z = z2;
            }
            io.dcloud.feature.barcode2.BarcodeFrameItem barcodeFrameItem2 = this.mBarcodeView;
            barcodeFrameItem2.mConserve = z;
            barcodeFrameItem2.start();
            return;
        }
        if (com.alibaba.android.bindingx.core.internal.BindingXConstants.STATE_CANCEL.equals(str)) {
            this.mBarcodeView.cancel_scan();
            return;
        }
        if ("setFlash".equals(str)) {
            this.mBarcodeView.setFlash(java.lang.Boolean.parseBoolean(strArr[1]));
            return;
        }
        android.graphics.Bitmap bitmapDecodeFile = null;
        if (io.dcloud.common.DHInterface.IFeature.F_BARCODE.equals(str)) {
            io.dcloud.common.util.AppRuntime.checkPrivacyComplianceAndPrompt(iWebview.getContext(), "Barcode-Create");
            java.lang.String str2 = strArr[0];
            if (!this.mIsRegisetedSysEvent) {
                io.dcloud.common.DHInterface.IApp iAppObtainApp = iWebview.obtainFrameView().obtainApp();
                iAppObtainApp.registerSysEventListener(this, io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onPause);
                iAppObtainApp.registerSysEventListener(this, io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onResume);
                this.mIsRegisetedSysEvent = true;
            }
            org.json.JSONArray jSONArrayCreateJSONArray = !io.dcloud.common.util.PdrUtil.isEmpty(strArr[4]) ? io.dcloud.common.util.JSONUtil.createJSONArray(strArr[4]) : null;
            org.json.JSONObject jSONObjectCreateJSONObject2 = io.dcloud.common.util.PdrUtil.isEmpty(strArr[5]) ? null : io.dcloud.common.util.JSONUtil.createJSONObject(strArr[5]);
            org.json.JSONArray jSONArrayCreateJSONArray2 = io.dcloud.common.util.JSONUtil.createJSONArray(strArr[3]);
            this.mId = strArr[2];
            io.dcloud.feature.barcode2.BarcodeFrameItem barcodeFrameItem3 = new io.dcloud.feature.barcode2.BarcodeFrameItem(this, iWebview, str2, jSONArrayCreateJSONArray2, jSONArrayCreateJSONArray, jSONObjectCreateJSONObject2);
            this.mBarcodeView = barcodeFrameItem3;
            barcodeFrameItem3.addCallBackId(strArr[1], iWebview.getWebviewUUID());
            if (strArr.length > 6) {
                this.mBarcodeView.autoDecodeCharset = java.lang.Boolean.parseBoolean(strArr[6]);
            }
            if (jSONArrayCreateJSONArray2.length() > 3) {
                this.mBarcodeView.toFrameView();
                return;
            }
            return;
        }
        if (!"scan".equals(str)) {
            if (io.dcloud.common.constant.AbsoluteConst.EVENTS_CLOSE.equals(str)) {
                this.mBarcodeView.close_scan();
                return;
            }
            if ("setStyle".equals(str)) {
                org.json.JSONObject jSONObjectCreateJSONObject3 = io.dcloud.common.util.JSONUtil.createJSONObject(strArr[1]);
                if (jSONObjectCreateJSONObject3 != null) {
                    this.mBarcodeView.upateStyles(jSONObjectCreateJSONObject3);
                    return;
                }
                return;
            }
            if (!"addCallBack".equals(str) || (barcodeFrameItem = this.mBarcodeView) == null) {
                return;
            }
            barcodeFrameItem.addCallBackId(strArr[1], iWebview.getWebviewUUID());
            return;
        }
        io.dcloud.common.util.AppRuntime.checkPrivacyComplianceAndPrompt(iWebview.getContext(), "Barcode-" + str);
        java.lang.String str3 = strArr[0];
        io.dcloud.common.DHInterface.IApp iAppObtainApp2 = iWebview.obtainFrameView().obtainApp();
        java.lang.String strConvert2AbsFullPath = iAppObtainApp2.convert2AbsFullPath(iWebview.obtainFullUrl(), strArr[1]);
        if (io.dcloud.common.util.FileUtil.needMediaStoreOpenFile(iAppObtainApp2.getActivity())) {
            java.io.InputStream fileInputStream = io.dcloud.common.util.FileUtil.getFileInputStream(iAppObtainApp2.getActivity(), strConvert2AbsFullPath);
            if (fileInputStream != null) {
                bitmapDecodeFile = android.graphics.BitmapFactory.decodeStream(fileInputStream);
            }
        } else {
            bitmapDecodeFile = android.graphics.BitmapFactory.decodeFile(strConvert2AbsFullPath);
        }
        if (bitmapDecodeFile != null) {
            com.dcloud.zxing2.Result resultDecode = io.dcloud.feature.barcode2.decoding.CaptureActivityHandler.decode(bitmapDecodeFile, strArr.length > 3 ? java.lang.Boolean.parseBoolean(strArr[3]) : false);
            if (resultDecode != null) {
                io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview, str3, io.dcloud.common.util.StringUtil.format("{type:%d,message:%s,file:'%s',charSet:'%s'}", java.lang.Integer.valueOf(io.dcloud.feature.barcode2.BarcodeFrameItem.convertTypestrToNum(resultDecode.getBarcodeFormat())), io.dcloud.common.util.JSONUtil.toJSONableString(resultDecode.getText()), strConvert2AbsFullPath, resultDecode.textCharset), io.dcloud.common.util.JSUtil.OK, true, false);
                return;
            }
        }
        io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview, str3, io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.DOMException.JSON_ERROR_INFO, 8, ""), io.dcloud.common.util.JSUtil.ERROR, true, false);
    }

    public org.json.JSONObject getJsBarcode() {
        io.dcloud.feature.barcode2.BarcodeFrameItem barcodeFrameItem = this.mBarcodeView;
        if (barcodeFrameItem != null) {
            return barcodeFrameItem.getJsBarcode();
        }
        return null;
    }

    protected void onDestroy() {
        io.dcloud.feature.barcode2.BarcodeFrameItem barcodeFrameItem = this.mBarcodeView;
        if (barcodeFrameItem != null) {
            barcodeFrameItem.onDestroy();
            this.mBarcodeView = null;
        }
        this.mIsRegisetedSysEvent = false;
    }

    @Override // io.dcloud.common.DHInterface.ISysEventListener
    public boolean onExecute(io.dcloud.common.DHInterface.ISysEventListener.SysEventType sysEventType, java.lang.Object obj) {
        if (sysEventType == io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onResume) {
            onResume();
            return false;
        }
        if (sysEventType != io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onPause) {
            return false;
        }
        onPause();
        return false;
    }

    protected void onPause() {
        io.dcloud.feature.barcode2.BarcodeFrameItem barcodeFrameItem = this.mBarcodeView;
        if (barcodeFrameItem != null) {
            barcodeFrameItem.onPause();
        }
    }

    protected void onResume() {
        io.dcloud.feature.barcode2.BarcodeFrameItem barcodeFrameItem = this.mBarcodeView;
        if (barcodeFrameItem != null) {
            barcodeFrameItem.onResume(true);
        }
    }
}
