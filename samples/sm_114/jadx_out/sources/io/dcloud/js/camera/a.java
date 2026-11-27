package io.dcloud.js.camera;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
class a {
    protected static int e = 501;
    protected static int f = 502;
    protected static int g = 5011;
    java.util.List a = null;
    java.util.List b = null;
    java.util.List c = null;
    int d;

    /* JADX INFO: renamed from: io.dcloud.js.camera.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static class C0066a {
        java.lang.String a;
        java.lang.String b;
        java.lang.String c;
        int d;
        boolean e = true;
        int f = 0;
        org.json.JSONObject g = null;
        boolean h = false;

        C0066a() {
        }

        public java.lang.String a() {
            return this.a;
        }

        public int b() {
            return this.f;
        }
    }

    a(int i) {
        this.d = i;
    }

    private java.lang.String[] d() {
        java.util.List list = this.b;
        java.lang.String[] strArrA = list != null ? a(list) : null;
        return strArrA == null ? new java.lang.String[]{"['jpg']", "['mp4']"} : strArrA;
    }

    protected java.lang.String a() {
        java.lang.String[] strArrD = d();
        return io.dcloud.common.util.StringUtil.format("(function(){return{supportedImageResolutions : %s,supportedVideoResolutions : %s,supportedImageFormats : %s,supportedVideoFormats : %s};})();", c(), e(), strArrD[0], strArrD[1]);
    }

    public void b() {
        android.hardware.Camera cameraOpen;
        try {
            if (this.d == 2 && io.dcloud.common.adapter.util.DeviceInfo.sDeviceSdkVer >= 9) {
                int i = 0;
                while (true) {
                    if (i >= android.hardware.Camera.getNumberOfCameras()) {
                        cameraOpen = null;
                        break;
                    }
                    android.hardware.Camera.CameraInfo cameraInfo = new android.hardware.Camera.CameraInfo();
                    android.hardware.Camera.getCameraInfo(i, cameraInfo);
                    if (cameraInfo.facing == 1) {
                        cameraOpen = android.hardware.Camera.open(i);
                        break;
                    }
                    i++;
                }
            } else {
                cameraOpen = null;
                break;
            }
            if (cameraOpen == null) {
                cameraOpen = android.hardware.Camera.open();
            }
            if (io.dcloud.common.adapter.util.DeviceInfo.sDeviceSdkVer >= 11) {
                this.a = cameraOpen.getParameters().getSupportedVideoSizes();
            }
            this.c = cameraOpen.getParameters().getSupportedPictureSizes();
            if (io.dcloud.common.adapter.util.DeviceInfo.sDeviceSdkVer >= 8) {
                this.b = cameraOpen.getParameters().getSupportedPictureFormats();
            }
            cameraOpen.release();
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
    }

    private java.lang.String c() {
        java.util.List list = this.c;
        return list != null ? b(list) : "[]";
    }

    private java.lang.String e() {
        java.util.List list = this.a;
        return (list == null || io.dcloud.common.adapter.util.DeviceInfo.sDeviceSdkVer < 11) ? "[]" : b(list);
    }

    private java.lang.String[] a(java.util.List list) {
        return new java.lang.String[]{"['jpg']", "['mp4']"};
    }

    static io.dcloud.js.camera.a.C0066a a(java.lang.String str, boolean z) {
        org.json.JSONObject jSONObject;
        io.dcloud.js.camera.a.C0066a c0066a = new io.dcloud.js.camera.a.C0066a();
        if (str != null) {
            try {
                jSONObject = new org.json.JSONObject(str);
            } catch (org.json.JSONException unused) {
                jSONObject = null;
            }
            c0066a.b = io.dcloud.common.util.JSONUtil.getString(jSONObject, "resolution");
            java.lang.String string = io.dcloud.common.util.JSONUtil.getString(jSONObject, io.dcloud.common.constant.AbsoluteConst.JSON_KEY_FILENAME);
            io.dcloud.common.util.JSONUtil.getString(jSONObject, "format");
            java.lang.String str2 = z ? "jpg" : "mp4";
            c0066a.c = str2;
            c0066a.a = io.dcloud.common.util.PdrUtil.getDefaultPrivateDocPath(string, str2);
            c0066a.d = io.dcloud.common.util.JSONUtil.getInt(jSONObject, "index");
            if (jSONObject != null && jSONObject.has("optimize")) {
                c0066a.e = io.dcloud.common.util.JSONUtil.getBoolean(jSONObject, "optimize");
            }
            if (jSONObject != null && jSONObject.has("videoMaximumDuration")) {
                c0066a.f = io.dcloud.common.util.JSONUtil.getInt(jSONObject, "videoMaximumDuration");
            }
            if (jSONObject != null && jSONObject.has("crop")) {
                c0066a.g = jSONObject.optJSONObject("crop");
            }
            if (!z) {
                if (jSONObject != null && jSONObject.has("videoCompress")) {
                    c0066a.h = jSONObject.optBoolean("videoCompress", false);
                }
            } else if (jSONObject != null && jSONObject.has("sizeType")) {
                java.lang.String strOptString = jSONObject.optString("sizeType");
                if (strOptString.contains(com.taobao.weex.common.Constants.Value.ORIGINAL) && strOptString.contains("compressed")) {
                    c0066a.h = true;
                } else {
                    c0066a.h = !strOptString.contains(com.taobao.weex.common.Constants.Value.ORIGINAL);
                }
            }
        }
        return c0066a;
    }

    private java.lang.String b(java.util.List list) {
        int size = list.size();
        if (size <= 1) {
            return "[]";
        }
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer(com.taobao.weex.el.parse.Operators.ARRAY_START_STR);
        for (int i = 0; i < size; i++) {
            stringBuffer.append("'" + ((android.hardware.Camera.Size) list.get(i)).width + "*" + ((android.hardware.Camera.Size) list.get(i)).height + "'");
            if (i != size - 1) {
                stringBuffer.append(",");
            }
        }
        stringBuffer.append(com.taobao.weex.el.parse.Operators.ARRAY_END_STR);
        return stringBuffer.toString();
    }
}
