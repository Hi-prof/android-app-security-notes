package io.dcloud.feature.device;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class DeviceFeatureImpl implements io.dcloud.common.DHInterface.IFeature, io.dcloud.common.DHInterface.ISysEventListener {
    static int e = 255;
    private android.content.Context c;
    private android.os.PowerManager.WakeLock a = null;
    private boolean b = false;
    int d = -1;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class a extends io.dcloud.common.adapter.util.PermissionUtil.StreamPermissionRequest {
        final /* synthetic */ io.dcloud.common.DHInterface.IWebview a;
        final /* synthetic */ java.lang.String[] b;
        final /* synthetic */ boolean c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(io.dcloud.common.DHInterface.IApp iApp, io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String[] strArr, boolean z) {
            super(iApp);
            this.a = iWebview;
            this.b = strArr;
            this.c = z;
        }

        @Override // io.dcloud.common.adapter.util.PermissionUtil.Request
        public void onDenied(java.lang.String str) {
        }

        @Override // io.dcloud.common.adapter.util.PermissionUtil.Request
        public void onGranted(java.lang.String str) {
            io.dcloud.feature.device.DeviceFeatureImpl.this.a(this.a, this.b[0], this.c);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class b extends io.dcloud.common.adapter.util.PermissionUtil.Request {
        final /* synthetic */ io.dcloud.common.DHInterface.IWebview a;
        final /* synthetic */ java.lang.String b;

        b(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str) {
            this.a = iWebview;
            this.b = str;
        }

        @Override // io.dcloud.common.adapter.util.PermissionUtil.Request
        public void onDenied(java.lang.String str) {
            io.dcloud.common.util.Deprecated_JSUtil.execCallback(this.a, this.b, "{'imei':'','imsi':[],'uuid':'" + io.dcloud.common.util.TelephonyUtil.getIMEI(this.a.getContext(), false) + "'}", io.dcloud.common.util.JSUtil.ERROR, true, false);
        }

        @Override // io.dcloud.common.adapter.util.PermissionUtil.Request
        public void onGranted(java.lang.String str) {
            io.dcloud.common.adapter.util.DeviceInfo.updateIMEI();
            io.dcloud.common.adapter.util.DeviceInfo.getUpdateIMSI();
            io.dcloud.common.util.Deprecated_JSUtil.execCallback(this.a, this.b, io.dcloud.common.util.StringUtil.format("{'imei':'%s','imsi':['%s'],'uuid':'%s'}", io.dcloud.common.adapter.util.DeviceInfo.sIMEI, io.dcloud.common.adapter.util.DeviceInfo.sIMSI, io.dcloud.common.util.TelephonyUtil.getIMEI(this.a.getContext(), false)), io.dcloud.common.util.JSUtil.OK, true, false);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class c implements io.dcloud.p.f3.b {
        final /* synthetic */ io.dcloud.common.DHInterface.IWebview a;
        final /* synthetic */ java.lang.String b;
        final /* synthetic */ java.lang.String c;

        c(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.String str2) {
            this.a = iWebview;
            this.b = str;
            this.c = str2;
        }

        @Override // io.dcloud.p.f3.b
        public void a(java.lang.String str, boolean z) {
            if (z) {
                io.dcloud.feature.device.DeviceFeatureImpl.this.a(this.a, this.b, this.c, str);
            } else {
                io.dcloud.common.util.Deprecated_JSUtil.execCallback(this.a, this.c, io.dcloud.common.constant.DOMException.toJSON(401, "not support"), io.dcloud.common.util.JSUtil.ERROR, true, false);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class d implements java.lang.Runnable {
        final /* synthetic */ io.dcloud.common.DHInterface.IWebview a;
        final /* synthetic */ float b;

        d(io.dcloud.common.DHInterface.IWebview iWebview, float f) {
            this.a = iWebview;
            this.b = f;
        }

        @Override // java.lang.Runnable
        public void run() {
            io.dcloud.feature.device.DeviceFeatureImpl.this.a(this.a, this.b);
        }
    }

    static {
        try {
            android.content.res.Resources system = android.content.res.Resources.getSystem();
            int identifier = system.getIdentifier("config_screenBrightnessSettingMaximum", "integer", com.taobao.weex.WXEnvironment.OS);
            if (identifier != 0) {
                e = system.getInteger(identifier);
            }
        } catch (java.lang.Exception unused) {
            e = 255;
        }
    }

    private void b(io.dcloud.common.DHInterface.IWebview iWebview, float f) {
        iWebview.obtainWindowView().post(new io.dcloud.feature.device.DeviceFeatureImpl.d(iWebview, f));
    }

    @Override // io.dcloud.common.DHInterface.IFeature
    public void dispose(java.lang.String str) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // io.dcloud.common.DHInterface.IFeature
    public java.lang.String execute(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.String[] strArr) {
        long j;
        str.getClass();
        str.hashCode();
        int i = 1;
        switch (str) {
            case "setWakelock":
                if (io.dcloud.common.util.PdrUtil.parseBoolean(strArr[0], false, false)) {
                    this.a.acquire();
                } else {
                    this.a.release();
                }
                return null;
            case "d.resolutionWidth":
                return io.dcloud.common.util.Deprecated_JSUtil.wrapJsVar(java.lang.String.valueOf(iWebview.obtainApp().getInt(0) / iWebview.getScale()), false);
            case "getDCloudID":
            case "getDeviceId":
                io.dcloud.common.util.AppRuntime.checkPrivacyComplianceAndPrompt(iWebview.getContext(), "Device-" + str);
                return io.dcloud.common.util.JSUtil.wrapJsVar(io.dcloud.common.util.AppRuntime.getDCloudDeviceID(iWebview.getContext()));
            case "s.resolutionHeight":
                return io.dcloud.common.util.Deprecated_JSUtil.wrapJsVar(java.lang.String.valueOf(iWebview.obtainApp().getInt(2) / iWebview.getScale()), false);
            case "getCurrentAPN":
                java.lang.String currentAPN = io.dcloud.common.adapter.util.DeviceInfo.getCurrentAPN();
                if (android.text.TextUtils.isEmpty(currentAPN)) {
                    return null;
                }
                try {
                    return io.dcloud.common.util.JSUtil.wrapJsVar(new org.json.JSONObject("{name:" + currentAPN + com.taobao.weex.el.parse.Operators.BLOCK_END_STR));
                } catch (org.json.JSONException e2) {
                    e2.printStackTrace();
                    return null;
                }
            case "isWakelock":
                return io.dcloud.common.util.Deprecated_JSUtil.wrapJsVar(java.lang.String.valueOf(this.a.isHeld()), false);
            case "getAAID":
            case "getOAID":
            case "getVAID":
                io.dcloud.common.util.AppRuntime.checkPrivacyComplianceAndPrompt(iWebview.getContext(), "Device-" + str);
                java.lang.String str2 = strArr[0];
                if (!io.dcloud.feature.internal.sdk.SDK.isUniMPSDK() || android.text.TextUtils.isEmpty(io.dcloud.feature.internal.sdk.SDK.customOAID)) {
                    java.lang.String str3 = io.dcloud.common.adapter.util.DeviceInfo.oaids;
                    if (str3 == null || str3.equalsIgnoreCase(com.taobao.weex.el.parse.Operators.OR)) {
                        try {
                            java.lang.reflect.Method declaredMethod = java.lang.Class.forName("com.bun.miitmdid.core.JLibrary").getDeclaredMethod("InitEntry", android.content.Context.class);
                            if (declaredMethod != null) {
                                declaredMethod.setAccessible(true);
                                declaredMethod.invoke(null, iWebview.getContext());
                            }
                            break;
                        } catch (java.lang.Exception unused) {
                        }
                        if (!new io.dcloud.p.f3(new io.dcloud.feature.device.DeviceFeatureImpl.c(iWebview, str, str2)).b(iWebview.getActivity())) {
                            io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview, str2, io.dcloud.common.constant.DOMException.toJSON(401, "not support"), io.dcloud.common.util.JSUtil.ERROR, true, false);
                        }
                    } else {
                        a(iWebview, str, str2, io.dcloud.common.adapter.util.DeviceInfo.oaids);
                    }
                } else {
                    io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview, str2, io.dcloud.common.constant.DOMException.toJSON(401, "not support"), io.dcloud.common.util.JSUtil.ERROR, true, false);
                }
                return null;
            case "getInfo":
                java.lang.String str4 = strArr[0];
                io.dcloud.common.util.AppRuntime.checkPrivacyComplianceAndPrompt(iWebview.getContext(), "Device-" + str);
                io.dcloud.common.adapter.util.PermissionUtil.usePermission(iWebview.getActivity(), io.dcloud.common.DHInterface.IFeature.F_DEVICE, com.hjq.permissions.Permission.READ_PHONE_STATE, 2, new io.dcloud.feature.device.DeviceFeatureImpl.b(iWebview, str4));
                return null;
            case "getCurrentSize":
                return io.dcloud.common.util.Deprecated_JSUtil.wrapJsVar(a(iWebview.obtainApp(), iWebview.getScale()), false);
            case "getCurrentType":
                return io.dcloud.common.adapter.util.DeviceInfo.getNetWorkType(iWebview.getContext());
            case "beep":
                android.media.ToneGenerator toneGenerator = new android.media.ToneGenerator(5, 100);
                try {
                    int i2 = java.lang.Integer.parseInt(strArr[0]);
                    if (i2 > 0) {
                        i = i2;
                    }
                } catch (java.lang.NumberFormatException e3) {
                    e3.printStackTrace();
                }
                for (int i3 = 0; i3 < i; i3++) {
                    toneGenerator.startTone(88);
                    try {
                        java.lang.Thread.sleep(500L);
                    } catch (java.lang.InterruptedException e4) {
                        e4.printStackTrace();
                    }
                }
                return null;
            case "dial":
                io.dcloud.common.util.AppRuntime.checkPrivacyComplianceAndPrompt(iWebview.getContext(), "Device-" + str);
                io.dcloud.common.adapter.util.PermissionUtil.usePermission(iWebview.getActivity(), io.dcloud.common.DHInterface.IFeature.F_DEVICE, io.dcloud.common.adapter.util.PermissionUtil.PMS_PHONE, 2, new io.dcloud.feature.device.DeviceFeatureImpl.a(iWebview.obtainApp(), iWebview, strArr, io.dcloud.common.util.PdrUtil.parseBoolean(strArr[1], true, false)));
                return null;
            case "getBrightness":
                return io.dcloud.common.util.Deprecated_JSUtil.wrapJsVar(java.lang.String.valueOf(a(iWebview.getActivity()) / e), false);
            case "__isWakelockNative__":
                return this.a.isHeld() + "";
            case "vibrate":
                try {
                    j = java.lang.Long.parseLong(strArr[0]);
                    if (j <= 0) {
                        j = 500;
                    }
                } catch (java.lang.NumberFormatException e5) {
                    e5.printStackTrace();
                }
                ((android.os.Vibrator) this.c.getSystemService("vibrator")).vibrate(j);
                return null;
            case "d.resolutionHeight":
                return io.dcloud.common.util.Deprecated_JSUtil.wrapJsVar(java.lang.String.valueOf(iWebview.obtainApp().getInt(1) / iWebview.getScale()), false);
            case "unlockOrientation":
                iWebview.obtainApp().setRequestedOrientation((java.lang.String) null);
                return null;
            case "isSetProxy":
                return io.dcloud.common.util.JSUtil.wrapJsVar(io.dcloud.common.util.NetworkTypeUtil.isWifiProxy(iWebview.getContext()));
            case "setVolume":
                float f = java.lang.Float.parseFloat(strArr[0]);
                android.media.AudioManager audioManager = (android.media.AudioManager) iWebview.getContext().getSystemService("audio");
                int iA = a(f);
                audioManager.setStreamVolume(4, iA, 8);
                audioManager.setStreamVolume(8, iA, 8);
                audioManager.setStreamVolume(3, iA, 8);
                audioManager.setStreamVolume(5, iA, 8);
                audioManager.setStreamVolume(2, iA, 8);
                audioManager.setStreamVolume(1, iA, 8);
                audioManager.setStreamVolume(0, iA, 8);
                return null;
            case "getVolume":
                return io.dcloud.common.util.Deprecated_JSUtil.wrapJsVar(java.lang.String.valueOf(((android.media.AudioManager) iWebview.getContext().getSystemService("audio")).getStreamVolume(3) / this.d), false);
            case "setBrightness":
                b(iWebview, java.lang.Float.parseFloat(strArr[0]));
                return null;
            case "s.resolutionWidth":
                return io.dcloud.common.util.Deprecated_JSUtil.wrapJsVar(java.lang.String.valueOf(iWebview.obtainApp().getInt(0) / iWebview.getScale()), false);
            case "lockOrientation":
                iWebview.obtainApp().setRequestedOrientation(strArr[0]);
                return null;
            default:
                return null;
        }
    }

    @Override // io.dcloud.common.DHInterface.IFeature
    public void init(io.dcloud.common.DHInterface.AbsMgr absMgr, java.lang.String str) {
        android.content.Context context = absMgr.getContext();
        this.c = context;
        android.os.PowerManager.WakeLock wakeLockNewWakeLock = ((android.os.PowerManager) context.getSystemService("power")).newWakeLock(10, "My Lock");
        this.a = wakeLockNewWakeLock;
        wakeLockNewWakeLock.setReferenceCounted(false);
        this.d = ((android.media.AudioManager) absMgr.getContext().getSystemService("audio")).getStreamMaxVolume(3);
    }

    @Override // io.dcloud.common.DHInterface.ISysEventListener
    public boolean onExecute(io.dcloud.common.DHInterface.ISysEventListener.SysEventType sysEventType, java.lang.Object obj) {
        return false;
    }

    private java.lang.String a(io.dcloud.common.DHInterface.IApp iApp, float f) {
        int i = iApp.getInt(0);
        int i2 = iApp.getInt(2);
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("width", i);
            jSONObject.put("height", i2);
            jSONObject.put("resolutionWidth", i / f);
            jSONObject.put("resolutionHeight", i2 / f);
        } catch (org.json.JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        java.lang.String[] strArrSplit = str3.split("\\|");
        try {
            int iHashCode = str.hashCode();
            if (iHashCode == -75727471) {
                if (str.equals("getAAID")) {
                    io.dcloud.common.util.JSUtil.execCallback(iWebview, str2, new org.json.JSONObject("{'aaid':'" + (strArrSplit.length > 2 ? strArrSplit[2] : "") + "'}"), io.dcloud.common.util.JSUtil.OK, false);
                    return;
                }
                return;
            }
            if (iHashCode == -75310397) {
                if (str.equals("getOAID")) {
                    io.dcloud.common.util.JSUtil.execCallback(iWebview, str2, new org.json.JSONObject("{'oaid':'" + (strArrSplit.length > 0 ? strArrSplit[0] : "") + "'}"), io.dcloud.common.util.JSUtil.OK, false);
                    return;
                }
                return;
            }
            if (iHashCode == -75101860 && str.equals("getVAID")) {
                io.dcloud.common.util.JSUtil.execCallback(iWebview, str2, new org.json.JSONObject("{'vaid':'" + (strArrSplit.length > 1 ? strArrSplit[1] : "") + "'}"), io.dcloud.common.util.JSUtil.OK, false);
            }
        } catch (java.lang.Exception e2) {
            io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview, str2, io.dcloud.common.constant.DOMException.toJSON(401, e2.getMessage()), io.dcloud.common.util.JSUtil.ERROR, true, false);
        }
    }

    private int a(android.app.Activity activity) {
        int i;
        float f = activity.getWindow().getAttributes().screenBrightness;
        if (f < 0.0f) {
            android.content.ContentResolver contentResolver = activity.getContentResolver();
            try {
                int integer = activity.getResources().getInteger(activity.getResources().getIdentifier("config_screenBrightnessSettingMaximum", "integer", com.taobao.weex.WXEnvironment.OS));
                int i2 = android.provider.Settings.System.getInt(contentResolver, "screen_brightness", 125);
                if (integer > 255) {
                    f = i2 / integer;
                    if (f > 0.0f) {
                        i = e;
                    }
                } else if (i2 >= 0) {
                    return i2;
                }
            } catch (java.lang.Exception e2) {
                e2.printStackTrace();
            }
            return 125;
        }
        i = e;
        return (int) (f * i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(io.dcloud.common.DHInterface.IWebview iWebview, float f) {
        android.view.Window window = iWebview.getActivity().getWindow();
        android.view.WindowManager.LayoutParams attributes = window.getAttributes();
        if (f <= 1.0f && f > 0.0f) {
            attributes.screenBrightness = f;
        } else {
            attributes.screenBrightness = -1.0f;
        }
        if (f == -1.0f) {
            attributes.screenBrightness = -1.0f;
            window.setAttributes(attributes);
        } else {
            if (f > 1.0f || f <= 0.0f) {
                return;
            }
            attributes.screenBrightness = f;
            window.setAttributes(attributes);
        }
    }

    private int a(float f) {
        if (f > 1.0f || f < 0.0f) {
            return 0;
        }
        return (int) (f * this.d);
    }

    protected void a(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, boolean z) {
        java.lang.String str2;
        android.net.Uri uri = android.net.Uri.parse("tel:" + str);
        if (z) {
            str2 = "android.intent.action.DIAL";
        } else {
            str2 = "android.intent.action.CALL";
        }
        iWebview.getActivity().startActivity(new android.content.Intent(str2, uri));
    }
}
