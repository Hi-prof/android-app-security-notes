package io.dcloud.feature.ui.nativeui;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class NativeUIFeatureImpl implements io.dcloud.common.DHInterface.IFeature {
    int d;
    int e;
    int f;
    int h;
    int i;
    io.dcloud.common.DHInterface.AbsMgr m;
    java.util.HashMap a = null;
    java.util.HashMap b = null;
    android.app.DatePickerDialog c = null;
    android.app.TimePickerDialog g = null;
    final byte j = 0;
    final byte k = 1;
    final byte l = 2;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class a implements android.content.DialogInterface.OnClickListener {
        final /* synthetic */ byte a;
        final /* synthetic */ android.widget.EditText b;
        final /* synthetic */ io.dcloud.common.DHInterface.IWebview c;
        final /* synthetic */ java.lang.String d;
        final /* synthetic */ int e;
        final /* synthetic */ android.app.AlertDialog f;

        a(byte b, android.widget.EditText editText, io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, int i, android.app.AlertDialog alertDialog) {
            this.a = b;
            this.b = editText;
            this.c = iWebview;
            this.d = str;
            this.e = i;
            this.f = alertDialog;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(android.content.DialogInterface dialogInterface, int i) {
            if (this.a == 2) {
                java.lang.String jSONableString = io.dcloud.common.util.JSONUtil.toJSONableString(this.b.getText().toString());
                io.dcloud.common.util.Deprecated_JSUtil.execCallback(this.c, this.d, "{index:" + this.e + ",message:" + jSONableString + com.taobao.weex.el.parse.Operators.BLOCK_END_STR, io.dcloud.common.util.JSUtil.OK, true, false);
            }
            if (this.a == 1) {
                io.dcloud.common.util.Deprecated_JSUtil.execCallback(this.c, this.d, java.lang.String.valueOf(this.e), io.dcloud.common.util.JSUtil.OK, true, false);
            }
            this.f.dismiss();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class b implements android.content.DialogInterface.OnKeyListener {
        final /* synthetic */ byte a;
        final /* synthetic */ android.widget.EditText b;
        final /* synthetic */ io.dcloud.common.DHInterface.IWebview c;
        final /* synthetic */ java.lang.String d;
        final /* synthetic */ android.app.AlertDialog e;

        b(byte b, android.widget.EditText editText, io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, android.app.AlertDialog alertDialog) {
            this.a = b;
            this.b = editText;
            this.c = iWebview;
            this.d = str;
            this.e = alertDialog;
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(android.content.DialogInterface dialogInterface, int i, android.view.KeyEvent keyEvent) {
            if (keyEvent.getAction() != 1 || i != 4) {
                return false;
            }
            if (this.a == 2) {
                java.lang.String jSONableString = io.dcloud.common.util.JSONUtil.toJSONableString(this.b.getText().toString());
                io.dcloud.common.util.Deprecated_JSUtil.execCallback(this.c, this.d, "{index:-1,message:" + jSONableString + com.taobao.weex.el.parse.Operators.BLOCK_END_STR, io.dcloud.common.util.JSUtil.OK, true, false);
            }
            if (this.a == 1) {
                io.dcloud.common.util.Deprecated_JSUtil.execCallback(this.c, this.d, java.lang.String.valueOf(-1), io.dcloud.common.util.JSUtil.OK, true, false);
            }
            this.e.dismiss();
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class c extends io.dcloud.feature.nativeObj.photoview.LongClickEventManager.OnLongClickListener {
        c(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str) {
            super(iWebview, str);
        }

        @Override // io.dcloud.feature.nativeObj.photoview.LongClickEventManager.OnLongClickListener
        public void onLongClickListener(org.json.JSONObject jSONObject) {
            io.dcloud.common.util.Deprecated_JSUtil.execCallback(getPwebview(), getCallbackIds(), jSONObject.toString(), io.dcloud.common.util.JSUtil.OK, true, true);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class d implements io.dcloud.feature.ui.nativeui.a.b {
        final /* synthetic */ io.dcloud.common.DHInterface.IWebview a;
        final /* synthetic */ java.lang.String b;
        final /* synthetic */ java.lang.String c;

        d(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.String str2) {
            this.a = iWebview;
            this.b = str;
            this.c = str2;
        }

        @Override // io.dcloud.feature.ui.nativeui.a.b
        public void initCancelText(android.widget.TextView textView) {
        }

        @Override // io.dcloud.feature.ui.nativeui.a.b
        public void initTextItem(int i, android.widget.TextView textView, java.lang.String str) {
        }

        @Override // io.dcloud.feature.ui.nativeui.a.b
        public boolean onDismiss(int i) {
            java.util.HashMap map = io.dcloud.feature.ui.nativeui.NativeUIFeatureImpl.this.b;
            if (map == null || !map.containsKey(this.c)) {
                return false;
            }
            io.dcloud.feature.ui.nativeui.NativeUIFeatureImpl.this.b.remove(this.c);
            return false;
        }

        @Override // io.dcloud.feature.ui.nativeui.a.b
        public void onItemClick(int i) {
            io.dcloud.common.util.Deprecated_JSUtil.execCallback(this.a, this.b, "" + i, io.dcloud.common.util.JSUtil.OK, true, false);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class e implements android.app.DatePickerDialog.OnDateSetListener {
        e() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(android.widget.DatePicker datePicker, int i, int i2, int i3) {
            io.dcloud.feature.ui.nativeui.NativeUIFeatureImpl nativeUIFeatureImpl = io.dcloud.feature.ui.nativeui.NativeUIFeatureImpl.this;
            nativeUIFeatureImpl.d = i;
            nativeUIFeatureImpl.e = i2;
            nativeUIFeatureImpl.f = i3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class f extends android.app.DatePickerDialog {
        int a;
        int b;
        int c;
        final /* synthetic */ int d;
        final /* synthetic */ int e;
        final /* synthetic */ int f;
        final /* synthetic */ boolean g;
        final /* synthetic */ io.dcloud.common.DHInterface.IWebview h;
        final /* synthetic */ java.lang.String i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(android.content.Context context, int i, android.app.DatePickerDialog.OnDateSetListener onDateSetListener, int i2, int i3, int i4, int i5, int i6, int i7, boolean z, io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str) {
            super(context, i, onDateSetListener, i2, i3, i4);
            this.d = i5;
            this.e = i6;
            this.f = i7;
            this.g = z;
            this.h = iWebview;
            this.i = str;
            this.a = i5;
            this.b = i6;
            this.c = i7;
        }

        @Override // android.app.DatePickerDialog, android.content.DialogInterface.OnClickListener
        public void onClick(android.content.DialogInterface dialogInterface, int i) {
            super.onClick(dialogInterface, i);
            if (i == -2) {
                io.dcloud.common.util.Deprecated_JSUtil.execCallback(this.h, this.i, io.dcloud.common.constant.DOMException.toJSON(-2, io.dcloud.common.constant.DOMException.MSG_USER_CANCEL), io.dcloud.common.util.JSUtil.ERROR, true, false);
            } else if (i == -1) {
                java.util.GregorianCalendar gregorianCalendar = new java.util.GregorianCalendar(java.util.TimeZone.getTimeZone("GMT"));
                if (io.dcloud.common.adapter.util.DeviceInfo.sDeviceSdkVer >= 21) {
                    io.dcloud.feature.ui.nativeui.NativeUIFeatureImpl nativeUIFeatureImpl = io.dcloud.feature.ui.nativeui.NativeUIFeatureImpl.this;
                    gregorianCalendar.set(nativeUIFeatureImpl.d, nativeUIFeatureImpl.e, nativeUIFeatureImpl.f, 0, 0, 0);
                } else {
                    gregorianCalendar.set(this.a, this.b, this.c, 0, 0, 0);
                }
                io.dcloud.common.util.Deprecated_JSUtil.execCallback(this.h, this.i, java.lang.String.valueOf(gregorianCalendar.getTime().getTime()), io.dcloud.common.util.JSUtil.OK, true, false);
            }
            io.dcloud.feature.ui.nativeui.NativeUIFeatureImpl.this.a();
        }

        @Override // android.app.AlertDialog, android.app.Dialog
        protected void onCreate(android.os.Bundle bundle) {
            super.onCreate(bundle);
            getWindow().setSoftInputMode(2);
        }

        @Override // android.app.DatePickerDialog, android.widget.DatePicker.OnDateChangedListener
        public void onDateChanged(android.widget.DatePicker datePicker, int i, int i2, int i3) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            if (this.g || io.dcloud.common.adapter.util.DeviceInfo.sVersion_release.equals("4.0.3") || io.dcloud.common.adapter.util.DeviceInfo.sVersion_release.equals("4.0.4")) {
                return;
            }
            super.onDateChanged(datePicker, i, i2, i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class g implements android.content.DialogInterface.OnDismissListener {
        final /* synthetic */ io.dcloud.common.DHInterface.IWebview a;
        final /* synthetic */ java.lang.String b;

        g(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str) {
            this.a = iWebview;
            this.b = str;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(android.content.DialogInterface dialogInterface) {
            if (io.dcloud.feature.ui.nativeui.NativeUIFeatureImpl.this.c != null) {
                io.dcloud.common.util.Deprecated_JSUtil.execCallback(this.a, this.b, io.dcloud.common.constant.DOMException.toJSON(-2, io.dcloud.common.constant.DOMException.MSG_USER_CANCEL), io.dcloud.common.util.JSUtil.ERROR, true, false);
                io.dcloud.feature.ui.nativeui.NativeUIFeatureImpl.this.a();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class h implements android.app.TimePickerDialog.OnTimeSetListener {
        h() {
        }

        @Override // android.app.TimePickerDialog.OnTimeSetListener
        public void onTimeSet(android.widget.TimePicker timePicker, int i, int i2) {
            io.dcloud.feature.ui.nativeui.NativeUIFeatureImpl nativeUIFeatureImpl = io.dcloud.feature.ui.nativeui.NativeUIFeatureImpl.this;
            nativeUIFeatureImpl.h = i;
            nativeUIFeatureImpl.i = i2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class i extends android.app.TimePickerDialog {
        int a;
        int b;
        final /* synthetic */ int c;
        final /* synthetic */ int d;
        final /* synthetic */ boolean e;
        final /* synthetic */ io.dcloud.common.DHInterface.IWebview f;
        final /* synthetic */ java.lang.String g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(android.content.Context context, int i, android.app.TimePickerDialog.OnTimeSetListener onTimeSetListener, int i2, int i3, boolean z, int i4, int i5, boolean z2, io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str) {
            super(context, i, onTimeSetListener, i2, i3, z);
            this.c = i4;
            this.d = i5;
            this.e = z2;
            this.f = iWebview;
            this.g = str;
            this.a = i4;
            this.b = i5;
        }

        @Override // android.app.TimePickerDialog, android.content.DialogInterface.OnClickListener
        public void onClick(android.content.DialogInterface dialogInterface, int i) {
            super.onClick(dialogInterface, i);
            if (i == -2) {
                io.dcloud.common.util.Deprecated_JSUtil.execCallback(this.f, this.g, io.dcloud.common.constant.DOMException.toJSON(-2, io.dcloud.common.constant.DOMException.MSG_USER_CANCEL), io.dcloud.common.util.JSUtil.ERROR, true, false);
            } else if (i == -1) {
                java.util.Date date = new java.util.Date();
                if (io.dcloud.common.adapter.util.DeviceInfo.sDeviceSdkVer >= 21) {
                    date.setHours(io.dcloud.feature.ui.nativeui.NativeUIFeatureImpl.this.h);
                    date.setMinutes(io.dcloud.feature.ui.nativeui.NativeUIFeatureImpl.this.i);
                } else {
                    date.setHours(this.a);
                    date.setMinutes(this.b);
                }
                io.dcloud.common.util.Deprecated_JSUtil.execCallback(this.f, this.g, java.lang.String.valueOf(date.getTime()), io.dcloud.common.util.JSUtil.OK, true, false);
            }
            io.dcloud.feature.ui.nativeui.NativeUIFeatureImpl.this.b();
        }

        @Override // android.app.AlertDialog, android.app.Dialog
        protected void onCreate(android.os.Bundle bundle) {
            super.onCreate(bundle);
            getWindow().setSoftInputMode(2);
        }

        @Override // android.app.TimePickerDialog, android.widget.TimePicker.OnTimeChangedListener
        public void onTimeChanged(android.widget.TimePicker timePicker, int i, int i2) {
            this.a = i;
            this.b = i2;
            if (this.e) {
                return;
            }
            setTitle(i + ":" + i2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class j implements android.content.DialogInterface.OnDismissListener {
        final /* synthetic */ io.dcloud.common.DHInterface.IWebview a;
        final /* synthetic */ java.lang.String b;

        j(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str) {
            this.a = iWebview;
            this.b = str;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(android.content.DialogInterface dialogInterface) {
            if (io.dcloud.feature.ui.nativeui.NativeUIFeatureImpl.this.g != null) {
                io.dcloud.common.util.Deprecated_JSUtil.execCallback(this.a, this.b, io.dcloud.common.constant.DOMException.toJSON(-2, io.dcloud.common.constant.DOMException.MSG_USER_CANCEL), io.dcloud.common.util.JSUtil.ERROR, true, false);
                io.dcloud.feature.ui.nativeui.NativeUIFeatureImpl.this.b();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class k implements android.content.DialogInterface.OnClickListener {
        final /* synthetic */ android.app.AlertDialog a;
        final /* synthetic */ io.dcloud.common.DHInterface.IWebview b;
        final /* synthetic */ java.lang.String c;

        k(android.app.AlertDialog alertDialog, io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str) {
            this.a = alertDialog;
            this.b = iWebview;
            this.c = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(android.content.DialogInterface dialogInterface, int i) {
            this.a.dismiss();
            io.dcloud.common.util.Deprecated_JSUtil.execCallback(this.b, this.c, "{index:0}", io.dcloud.common.util.JSUtil.OK, true, false);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class l implements android.content.DialogInterface.OnKeyListener {
        final /* synthetic */ android.app.AlertDialog a;
        final /* synthetic */ io.dcloud.common.DHInterface.IWebview b;
        final /* synthetic */ java.lang.String c;

        l(android.app.AlertDialog alertDialog, io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str) {
            this.a = alertDialog;
            this.b = iWebview;
            this.c = str;
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(android.content.DialogInterface dialogInterface, int i, android.view.KeyEvent keyEvent) {
            if (keyEvent.getAction() != 1 || i != 4) {
                return false;
            }
            this.a.dismiss();
            io.dcloud.common.util.Deprecated_JSUtil.execCallback(this.b, this.c, "{index:-1}", io.dcloud.common.util.JSUtil.OK, true, false);
            return true;
        }
    }

    @Override // io.dcloud.common.DHInterface.IFeature
    public void dispose(java.lang.String str) {
        if (io.dcloud.common.util.PdrUtil.isEmpty(str)) {
            this.m = null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:12:0x003a  */
    @Override // io.dcloud.common.DHInterface.IFeature
    public java.lang.String execute(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.String[] strArr) throws java.lang.Throwable {
        byte b2;
        io.dcloud.common.DHInterface.IActivityHandler iActivityHandler;
        java.lang.String strOptString;
        io.dcloud.feature.ui.nativeui.b bVar;
        java.lang.String[] strArr2;
        io.dcloud.common.DHInterface.IActivityHandler iActivityHandler2;
        io.dcloud.feature.ui.nativeui.NativeUIFeatureImpl nativeUIFeatureImpl;
        boolean z;
        io.dcloud.feature.ui.nativeui.a aVar;
        io.dcloud.feature.ui.nativeui.NativeUIFeatureImpl nativeUIFeatureImpl2;
        java.lang.String[] strArr3;
        io.dcloud.feature.ui.nativeui.b bVar2;
        io.dcloud.common.DHInterface.IApp iAppObtainApp = iWebview.obtainApp();
        int i2 = 0;
        java.lang.String str2 = strArr.length >= 1 ? strArr[0] : null;
        org.json.JSONArray jSONArrayCreateJSONArray = strArr.length >= 2 ? io.dcloud.common.util.JSONUtil.createJSONArray(strArr[1]) : null;
        str.getClass();
        str.hashCode();
        switch (str) {
            case "closeToast":
                b2 = 0;
                break;
            case "hideMenu":
                b2 = 1;
                break;
            case "setUiStyle":
                b2 = 2;
                break;
            case "closePreviewImage":
                b2 = 3;
                break;
            case "previewImage":
                b2 = 4;
                break;
            case "WaitingView_setTitle":
                b2 = 5;
                break;
            case "prompt":
                b2 = 6;
                break;
            case "pickDate":
                b2 = 7;
                break;
            case "pickTime":
                b2 = 8;
                break;
            case "showMenu":
                b2 = 9;
                break;
            case "closeWaiting":
                b2 = 10;
                break;
            case "getTitlebarHeight":
                b2 = 11;
                break;
            case "setTitlebarVisible":
                b2 = 12;
                break;
            case "_NativeObj_close":
                b2 = 13;
                break;
            case "alert":
                b2 = 14;
                break;
            case "toast":
                b2 = 15;
                break;
            case "isTitlebarVisible":
                b2 = 16;
                break;
            case "confirm":
                b2 = 17;
                break;
            case "WaitingView_close":
                b2 = 18;
                break;
            case "actionSheet":
                b2 = 19;
                break;
            case "WaitingView":
                b2 = 20;
                break;
            default:
                b2 = -1;
                break;
        }
        java.lang.String str3 = null;
        switch (b2) {
            case 0:
                io.dcloud.p.g0.a(iAppObtainApp.obtainAppId());
                return null;
            case 1:
                io.dcloud.common.adapter.util.PlatformUtil.invokeMethod("io.dcloud.appstream.actionbar.StreamAppActionBarUtil", "hideMenu", null, new java.lang.Class[]{android.app.Activity.class, java.lang.String.class}, new java.lang.Object[]{iWebview.getActivity(), iWebview.obtainApp().obtainAppId()});
                if (iWebview.getActivity() == null || (iActivityHandler = io.src.dcloud.adapter.DCloudAdapterUtil.getIActivityHandler(iWebview.getActivity())) == null) {
                    return null;
                }
                iActivityHandler.sideBarHideMenu();
                return null;
            case 2:
                io.dcloud.common.util.AppRuntime.setAppDarkMode(iWebview.getActivity(), iWebview, strArr[0]);
                return null;
            case 3:
                android.app.Activity activity = io.dcloud.common.util.RuningAcitvityUtil.getActivity("io.dcloud.feature.nativeObj.photoview.PhotoActivity");
                if (activity != null) {
                    activity.onBackPressed();
                    return null;
                }
                str3 = null;
                return str3;
            case 4:
                org.json.JSONArray jSONArray = io.dcloud.common.util.JSONUtil.getJSONArray(jSONArrayCreateJSONArray, 0);
                org.json.JSONObject jSONObject = io.dcloud.common.util.JSONUtil.getJSONObject(jSONArrayCreateJSONArray, 1);
                if (jSONArray != null) {
                    java.util.ArrayList arrayList = new java.util.ArrayList();
                    java.util.ArrayList arrayList2 = new java.util.ArrayList();
                    for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                        try {
                            java.lang.String string = jSONArray.getString(i3);
                            arrayList.add((io.dcloud.common.util.PdrUtil.isNetPath(string) || io.dcloud.common.util.PdrUtil.isBase64ImagePath(string)) ? string : iWebview.obtainApp().convert2AbsFullPath(iWebview.obtainFullUrl(), string));
                            arrayList2.add(string);
                        } catch (org.json.JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                    android.content.Intent intent = new android.content.Intent();
                    intent.setClassName(iAppObtainApp.getActivity().getPackageName(), "io.dcloud.feature.nativeObj.photoview.PhotoActivity");
                    intent.putExtra("image_urlList", arrayList);
                    intent.putExtra("original_image_urlArray", arrayList2);
                    if (jSONObject != null) {
                        intent.putExtra("image_current_index", jSONObject.optInt("current", 0));
                        if (jSONObject.has("background")) {
                            intent.putExtra("image_backgroud_color", io.dcloud.common.util.PdrUtil.stringToColor(jSONObject.optString("background")));
                        }
                        if (jSONObject.has("loop")) {
                            intent.putExtra("image_loop", jSONObject.optBoolean("loop"));
                        }
                        if (jSONObject.has(com.taobao.weex.ui.component.WXBasicComponentType.INDICATOR)) {
                            intent.putExtra("image_indicator", jSONObject.optString(com.taobao.weex.ui.component.WXBasicComponentType.INDICATOR));
                        }
                    }
                    intent.putExtra("image_photo", true);
                    if (jSONArrayCreateJSONArray != null && jSONArrayCreateJSONArray.length() > 2 && (strOptString = jSONArrayCreateJSONArray.optString(2)) != null) {
                        intent.putExtra("preview_callback", strOptString);
                        io.dcloud.feature.nativeObj.photoview.LongClickEventManager.getInstance().addOnlongClickListener(strOptString, new io.dcloud.feature.ui.nativeui.NativeUIFeatureImpl.c(iWebview, strOptString));
                    }
                    intent.putExtra("screen_orientation", iAppObtainApp.getRequestedOrientation());
                    iAppObtainApp.getActivity().startActivity(intent);
                    iAppObtainApp.getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                }
                return null;
            case 5:
                java.util.HashMap map = this.a;
                if (map != null && (bVar = (io.dcloud.feature.ui.nativeui.b) map.get(str2)) != null) {
                    bVar.b(io.dcloud.common.util.JSONUtil.getString(jSONArrayCreateJSONArray, 0));
                    return null;
                }
                return null;
            case 6:
                java.lang.String string2 = io.dcloud.common.util.JSONUtil.getString(jSONArrayCreateJSONArray, 0);
                java.lang.String string3 = io.dcloud.common.util.JSONUtil.getString(jSONArrayCreateJSONArray, 1);
                java.lang.String string4 = io.dcloud.common.util.JSONUtil.getString(jSONArrayCreateJSONArray, 2);
                java.lang.String string5 = io.dcloud.common.util.JSONUtil.getString(jSONArrayCreateJSONArray, 3);
                org.json.JSONArray jSONArray2 = io.dcloud.common.util.JSONUtil.getJSONArray(jSONArrayCreateJSONArray, 4);
                if (jSONArray2 != null) {
                    int length = jSONArray2.length();
                    strArr2 = new java.lang.String[length];
                    while (i2 < length) {
                        strArr2[i2] = io.dcloud.common.util.JSONUtil.getString(jSONArray2, i2);
                        i2++;
                    }
                } else {
                    strArr2 = null;
                }
                a((byte) 2, string4, null, string2, strArr2, string5, iWebview, string3);
                return null;
            case 7:
                a(iWebview, io.dcloud.common.util.JSONUtil.getString(jSONArrayCreateJSONArray, 0), io.dcloud.common.util.JSONUtil.getJSONObject(jSONArrayCreateJSONArray, 1));
                return null;
            case 8:
                b(iWebview, io.dcloud.common.util.JSONUtil.getString(jSONArrayCreateJSONArray, 0), io.dcloud.common.util.JSONUtil.getJSONObject(jSONArrayCreateJSONArray, 1));
                return null;
            case 9:
                io.dcloud.common.adapter.util.PlatformUtil.invokeMethod("io.dcloud.appstream.actionbar.StreamAppActionBarUtil", "showMenu", null, new java.lang.Class[]{android.app.Activity.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, io.dcloud.common.DHInterface.IWebview.class, java.lang.String.class}, new java.lang.Object[]{iWebview.getActivity(), iWebview.obtainApp().obtainAppId(), io.dcloud.common.util.JSONUtil.getString(jSONArrayCreateJSONArray, 0), io.dcloud.common.util.JSONUtil.getString(jSONArrayCreateJSONArray, 1), iWebview, io.dcloud.common.util.JSONUtil.getString(jSONArrayCreateJSONArray, 2)});
                if (iWebview.getActivity() == null || (iActivityHandler2 = io.src.dcloud.adapter.DCloudAdapterUtil.getIActivityHandler(iWebview.getActivity())) == null) {
                    return null;
                }
                iActivityHandler2.sideBarShowMenu(io.dcloud.common.util.JSONUtil.getString(jSONArrayCreateJSONArray, 0), io.dcloud.common.util.JSONUtil.getString(jSONArrayCreateJSONArray, 1), iWebview, io.dcloud.common.util.JSONUtil.getString(jSONArrayCreateJSONArray, 2));
                return null;
            case 10:
                nativeUIFeatureImpl = this;
                java.util.HashMap map2 = nativeUIFeatureImpl.a;
                if (map2 != null) {
                    java.util.Iterator it = map2.values().iterator();
                    while (it.hasNext()) {
                        ((io.dcloud.feature.ui.nativeui.b) it.next()).a();
                    }
                    nativeUIFeatureImpl.a.clear();
                    return null;
                }
                return null;
            case 11:
                java.lang.Object objInvokeMethod = io.dcloud.common.adapter.util.PlatformUtil.invokeMethod("io.dcloud.appstream.actionbar.StreamAppActionBarUtil", "getTitlebarHeight", null, new java.lang.Class[]{android.app.Activity.class}, new java.lang.Object[]{iWebview.getActivity()});
                return io.dcloud.common.util.Deprecated_JSUtil.wrapJsVar(java.lang.String.valueOf(objInvokeMethod instanceof java.lang.Integer ? java.lang.Integer.valueOf(objInvokeMethod.toString()).intValue() : 0), false);
            case 12:
                try {
                    z = jSONArrayCreateJSONArray.getBoolean(0);
                    break;
                } catch (java.lang.Exception e3) {
                    e3.printStackTrace();
                    z = true;
                }
                io.dcloud.common.adapter.util.PlatformUtil.invokeMethod("io.dcloud.appstream.actionbar.StreamAppActionBarUtil", "setTitlebarVisible", null, new java.lang.Class[]{android.app.Activity.class, java.lang.String.class, java.lang.Boolean.TYPE}, new java.lang.Object[]{iWebview.getActivity(), iWebview.obtainApp().obtainAppId(), java.lang.Boolean.valueOf(z)});
                return null;
            case 13:
                nativeUIFeatureImpl = this;
                java.util.HashMap map3 = nativeUIFeatureImpl.b;
                if (map3 != null && (aVar = (io.dcloud.feature.ui.nativeui.a) map3.remove(str2)) != null) {
                    aVar.a(-1);
                    aVar.b.onItemClick(-1);
                    return null;
                }
                return null;
            case 14:
                a((byte) 0, io.dcloud.common.util.JSONUtil.getString(jSONArrayCreateJSONArray, 2), null, io.dcloud.common.util.JSONUtil.getString(jSONArrayCreateJSONArray, 0), new java.lang.String[]{io.dcloud.common.util.JSONUtil.getString(jSONArrayCreateJSONArray, 3)}, null, iWebview, io.dcloud.common.util.JSONUtil.getString(jSONArrayCreateJSONArray, 1));
                return null;
            case 15:
                a(iAppObtainApp, iWebview, io.dcloud.common.util.JSONUtil.getString(jSONArrayCreateJSONArray, 0), io.dcloud.common.util.JSONUtil.getJSONObject(jSONArrayCreateJSONArray, 1));
                return null;
            case 16:
                java.lang.Object objInvokeMethod2 = io.dcloud.common.adapter.util.PlatformUtil.invokeMethod("io.dcloud.appstream.actionbar.StreamAppActionBarUtil", "isTitlebarVisible", null, new java.lang.Class[]{android.app.Activity.class, java.lang.String.class}, new java.lang.Object[]{iWebview.getActivity(), iWebview.obtainApp().obtainAppId()});
                return io.dcloud.common.util.Deprecated_JSUtil.wrapJsVar(java.lang.String.valueOf(objInvokeMethod2 instanceof java.lang.Boolean ? java.lang.Boolean.valueOf(objInvokeMethod2.toString()).booleanValue() : false), false);
            case 17:
                nativeUIFeatureImpl2 = this;
                try {
                    java.lang.String string6 = io.dcloud.common.util.JSONUtil.getString(jSONArrayCreateJSONArray, 0);
                    java.lang.String string7 = io.dcloud.common.util.JSONUtil.getString(jSONArrayCreateJSONArray, 1);
                    java.lang.Object obj = jSONArrayCreateJSONArray.get(2);
                    try {
                        if (obj instanceof org.json.JSONObject) {
                            nativeUIFeatureImpl2.a((byte) 1, string6, (org.json.JSONObject) obj, iWebview, string7);
                            return null;
                        }
                        if (!(obj instanceof java.lang.String)) {
                            nativeUIFeatureImpl2 = this;
                            nativeUIFeatureImpl2.a((byte) 1, null, null, string6, null, null, iWebview, string7);
                            return null;
                        }
                        java.lang.String str4 = (java.lang.String) obj;
                        org.json.JSONArray jSONArray3 = io.dcloud.common.util.JSONUtil.getJSONArray(jSONArrayCreateJSONArray, 3);
                        if (jSONArray3 != null) {
                            int length2 = jSONArray3.length();
                            java.lang.String[] strArr4 = new java.lang.String[length2];
                            while (i2 < length2) {
                                strArr4[i2] = io.dcloud.common.util.JSONUtil.getString(jSONArray3, i2);
                                i2++;
                            }
                            strArr3 = strArr4;
                        } else {
                            strArr3 = null;
                        }
                        a((byte) 1, str4, null, string6, strArr3, null, iWebview, string7);
                        return null;
                    } catch (org.json.JSONException e4) {
                        e = e4;
                        nativeUIFeatureImpl2 = this;
                    }
                } catch (org.json.JSONException e5) {
                    e = e5;
                }
                e.printStackTrace();
                return str3;
            case 18:
                nativeUIFeatureImpl2 = this;
                java.util.HashMap map4 = nativeUIFeatureImpl2.a;
                if (map4 != null && (bVar2 = (io.dcloud.feature.ui.nativeui.b) map4.remove(str2)) != null) {
                    bVar2.a();
                    return null;
                }
                return str3;
            case 19:
                nativeUIFeatureImpl2 = this;
                java.lang.String string8 = io.dcloud.common.util.JSONUtil.getString(jSONArrayCreateJSONArray, 2);
                io.dcloud.feature.ui.nativeui.a aVarA = nativeUIFeatureImpl2.a(string8, io.dcloud.common.util.JSONUtil.getJSONObject(jSONArrayCreateJSONArray, 0), io.dcloud.common.util.JSONUtil.getString(jSONArrayCreateJSONArray, 1), iWebview);
                if (!io.dcloud.common.util.PdrUtil.isEmpty(string8) && !io.dcloud.common.util.PdrUtil.isEmpty(aVarA)) {
                    if (nativeUIFeatureImpl2.b == null) {
                        nativeUIFeatureImpl2.b = new java.util.HashMap();
                    }
                    nativeUIFeatureImpl2.b.put(string8, aVarA);
                    return null;
                }
                return str3;
            case 20:
                java.lang.String string9 = io.dcloud.common.util.JSONUtil.getString(jSONArrayCreateJSONArray, 0);
                org.json.JSONObject jSONObject2 = io.dcloud.common.util.JSONUtil.getJSONObject(jSONArrayCreateJSONArray, 1);
                java.lang.String string10 = io.dcloud.common.util.JSONUtil.getString(jSONArrayCreateJSONArray, 2);
                android.app.Activity topRuningActivity = io.dcloud.common.util.RuningAcitvityUtil.getTopRuningActivity(iWebview.getActivity());
                if (!topRuningActivity.isDestroyed()) {
                    io.dcloud.feature.ui.nativeui.b bVar3 = new io.dcloud.feature.ui.nativeui.b(this, iWebview, string9, jSONObject2, string10, topRuningActivity);
                    if (this.a == null) {
                        this.a = new java.util.HashMap();
                    }
                    bVar3.f = str2;
                    this.a.put(str2, bVar3);
                    return null;
                }
            default:
                return str3;
        }
    }

    @Override // io.dcloud.common.DHInterface.IFeature
    public void init(io.dcloud.common.DHInterface.AbsMgr absMgr, java.lang.String str) {
        this.m = absMgr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        this.g = null;
        this.h = 0;
        this.i = 0;
    }

    void a(java.lang.String str) {
        this.a.remove(str);
    }

    private void b(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, org.json.JSONObject jSONObject) {
        int i2;
        int i3;
        if (this.g != null) {
            io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview, str, io.dcloud.common.constant.DOMException.toJSON(5, ""), io.dcloud.common.util.JSUtil.ERROR, true, false);
            return;
        }
        android.app.Activity topRuningActivity = io.dcloud.common.util.RuningAcitvityUtil.getTopRuningActivity(iWebview.getActivity());
        boolean z = (jSONObject == null || jSONObject.isNull(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_TITLE)) ? false : true;
        boolean z2 = io.dcloud.common.util.PdrUtil.parseBoolean(io.dcloud.common.util.JSONUtil.getString(jSONObject, io.dcloud.common.constant.AbsoluteConst.JSON_KEY_IS24HOUR), true, false);
        java.lang.String string = io.dcloud.common.util.JSONUtil.getString(jSONObject, com.taobao.weex.common.Constants.Value.TIME);
        java.lang.String string2 = io.dcloud.common.util.JSONUtil.getString(jSONObject, "__minutes");
        java.lang.String string3 = io.dcloud.common.util.JSONUtil.getString(jSONObject, "__hours");
        if (io.dcloud.common.util.PdrUtil.isEmpty(string3)) {
            java.util.GregorianCalendar gregorianCalendar = new java.util.GregorianCalendar();
            io.dcloud.common.util.PdrUtil.isEmpty(string);
            if (z2) {
                i2 = gregorianCalendar.get(11);
            } else {
                i2 = gregorianCalendar.get(10);
            }
            i3 = gregorianCalendar.get(12);
        } else {
            i2 = java.lang.Integer.parseInt(string3);
            i3 = java.lang.Integer.parseInt(string2);
        }
        int i4 = i2;
        int i5 = i3;
        io.dcloud.feature.ui.nativeui.NativeUIFeatureImpl.i iVar = new io.dcloud.feature.ui.nativeui.NativeUIFeatureImpl.i(topRuningActivity, io.dcloud.common.util.AppRuntime.getAppDarkMode(iWebview.getContext()) ? 4 : 0, new io.dcloud.feature.ui.nativeui.NativeUIFeatureImpl.h(), i4, i5, z2, i4, i5, z, iWebview, str);
        if (z) {
            iVar.setTitle(io.dcloud.common.util.JSONUtil.getString(jSONObject, io.dcloud.common.constant.AbsoluteConst.JSON_KEY_TITLE));
        }
        iVar.setOnDismissListener(new io.dcloud.feature.ui.nativeui.NativeUIFeatureImpl.j(iWebview, str));
        iVar.show();
        this.g = iVar;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0290  */
    /* JADX WARN: Code duplicated, block: B:102:0x0297  */
    /* JADX WARN: Code duplicated, block: B:28:0x009d  */
    /* JADX WARN: Code duplicated, block: B:57:0x011b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:58:0x011d  */
    /* JADX WARN: Code duplicated, block: B:59:0x0129  */
    /* JADX WARN: Code duplicated, block: B:62:0x0159  */
    /* JADX WARN: Code duplicated, block: B:64:0x015e  */
    /* JADX WARN: Code duplicated, block: B:65:0x0173  */
    /* JADX WARN: Code duplicated, block: B:67:0x0185  */
    /* JADX WARN: Code duplicated, block: B:70:0x0198  */
    /* JADX WARN: Code duplicated, block: B:71:0x019c  */
    /* JADX WARN: Code duplicated, block: B:73:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:74:0x01af  */
    /* JADX WARN: Code duplicated, block: B:78:0x01ba  */
    /* JADX WARN: Code duplicated, block: B:80:0x01de  */
    /* JADX WARN: Code duplicated, block: B:83:0x01ee  */
    /* JADX WARN: Code duplicated, block: B:86:0x01f7  */
    /* JADX WARN: Code duplicated, block: B:91:0x020f  */
    /* JADX WARN: Code duplicated, block: B:92:0x0216  */
    /* JADX WARN: Code duplicated, block: B:94:0x022d  */
    /* JADX WARN: Code duplicated, block: B:97:0x023d  */
    /* JADX WARN: Code duplicated, block: B:98:0x0274  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void a(io.dcloud.common.DHInterface.IApp iApp, io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, org.json.JSONObject jSONObject) throws java.lang.Throwable {
        io.dcloud.common.DHInterface.IApp iApp2;
        boolean zEquals;
        int i2;
        int i3;
        int iStringToColor;
        android.app.Activity topRuningActivity;
        char c2;
        android.widget.Toast toastCompat;
        android.widget.LinearLayout linearLayout;
        int iDip2px;
        android.graphics.drawable.GradientDrawable gradientDrawable;
        android.widget.TextView textView;
        android.widget.Toast toast;
        android.widget.LinearLayout.LayoutParams layoutParams;
        java.lang.String string;
        java.lang.String string2;
        int i4;
        int iDip2px2;
        java.lang.String systemProperty;
        float scale = iWebview.getScale();
        int i5 = 80;
        java.lang.String str2 = io.dcloud.common.constant.AbsoluteConst.JSON_VALUE_BLOCK;
        android.graphics.Bitmap bitmapDecodeStream = null;
        if (jSONObject != null) {
            zEquals = android.text.TextUtils.equals(com.taobao.weex.ui.component.WXBasicComponentType.RICHTEXT, jSONObject.optString("type"));
            if (!jSONObject.isNull("style") && !io.dcloud.common.constant.AbsoluteConst.JSON_VALUE_BLOCK.equals(io.dcloud.common.util.JSONUtil.getString(jSONObject, "style").toLowerCase(java.util.Locale.ENGLISH))) {
                str2 = io.dcloud.common.constant.AbsoluteConst.JSON_VALUE_INLINE;
            }
            if (jSONObject.isNull(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_ICON)) {
                iApp2 = iApp;
            } else {
                iApp2 = iApp;
                java.lang.String strConvert2AbsFullPath = iApp2.convert2AbsFullPath(iWebview.obtainFullUrl(), io.dcloud.common.util.JSONUtil.getString(jSONObject, io.dcloud.common.constant.AbsoluteConst.JSON_KEY_ICON));
                android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
                options.inScaled = false;
                bitmapDecodeStream = android.graphics.BitmapFactory.decodeStream(io.dcloud.common.adapter.util.PlatformUtil.getInputStream(strConvert2AbsFullPath), null, options);
            }
            i2 = (jSONObject.isNull("duration") || !"long".equals(io.dcloud.common.util.JSONUtil.getString(jSONObject, "duration").toLowerCase(java.util.Locale.ENGLISH))) ? 0 : 1;
            if (jSONObject.isNull(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_ALIGN)) {
                i3 = 1;
            } else {
                java.lang.String string3 = io.dcloud.common.util.JSONUtil.getString(jSONObject, io.dcloud.common.constant.AbsoluteConst.JSON_KEY_ALIGN);
                if ("left".equals(string3)) {
                    i3 = 3;
                } else if ("right".equals(string3)) {
                    i3 = 5;
                } else {
                    i3 = 1;
                }
            }
            if (!jSONObject.isNull(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_VERTICAL_ALIGN)) {
                java.lang.String string4 = io.dcloud.common.util.JSONUtil.getString(jSONObject, io.dcloud.common.constant.AbsoluteConst.JSON_KEY_VERTICAL_ALIGN);
                if ("top".equals(string4)) {
                    i5 = 48;
                } else if (!"bottom".equals(string4)) {
                    i5 = 16;
                }
            }
            if (!jSONObject.isNull("background")) {
                java.lang.String string5 = io.dcloud.common.util.JSONUtil.getString(jSONObject, "background");
                iStringToColor = io.dcloud.common.util.PdrUtil.isEmpty(string5) ? 1 : io.dcloud.common.util.PdrUtil.stringToColor(string5);
            }
            topRuningActivity = io.dcloud.common.util.RuningAcitvityUtil.getTopRuningActivity(iWebview.getActivity());
            if (topRuningActivity == null && topRuningActivity.isFinishing()) {
                return;
            }
            if (bitmapDecodeStream != null && !zEquals) {
                android.widget.Toast toastMakeText = com.dcloud.android.widget.toast.ToastCompat.makeText(topRuningActivity.getApplicationContext(), (java.lang.CharSequence) str, i2);
                toastMakeText.setGravity(i3 | i5, toastMakeText.getXOffset(), toastMakeText.getYOffset());
                if (iStringToColor <= 0) {
                    toastMakeText.getView().getBackground().setColorFilter(iStringToColor, android.graphics.PorterDuff.Mode.SRC);
                }
                toast = toastMakeText;
            } else {
                if (zEquals) {
                    c2 = 3;
                    toastCompat = new io.dcloud.p.g0(topRuningActivity, iApp2.obtainAppId());
                } else {
                    c2 = 3;
                    toastCompat = new com.dcloud.android.widget.toast.ToastCompat(topRuningActivity.getApplicationContext());
                }
                linearLayout = new android.widget.LinearLayout(topRuningActivity);
                int iDip2px3 = io.dcloud.common.adapter.util.CanvasHelper.dip2px(topRuningActivity, 10.0f);
                iDip2px = io.dcloud.common.adapter.util.CanvasHelper.dip2px(topRuningActivity, 8.0f);
                linearLayout.setPadding(iDip2px3, iDip2px, iDip2px3, iDip2px);
                linearLayout.setGravity(17);
                int i6 = i5;
                if (!android.os.Build.BRAND.equalsIgnoreCase("xiaomi")) {
                    gradientDrawable = new android.graphics.drawable.GradientDrawable();
                    gradientDrawable.setCornerRadius(iDip2px);
                    gradientDrawable.setShape(0);
                    if (iStringToColor <= 0) {
                        gradientDrawable.setColor(iStringToColor);
                    } else {
                        gradientDrawable.setColor(-1308622848);
                    }
                    linearLayout.setBackground(gradientDrawable);
                } else if (iStringToColor <= 0) {
                    android.graphics.drawable.Drawable drawable = iWebview.getContext().getResources().getDrawable(android.R.drawable.toast_frame);
                    drawable.setColorFilter(iStringToColor, android.graphics.PorterDuff.Mode.SRC);
                    linearLayout.setBackground(drawable);
                } else {
                    systemProperty = io.dcloud.common.constant.DataInterface.getSystemProperty();
                    java.lang.String[] strArr = {"v11", "v12"};
                    if (io.dcloud.common.util.PdrUtil.isEmpty(systemProperty) && java.util.Arrays.binarySearch(strArr, systemProperty.toLowerCase(java.util.Locale.ENGLISH)) != -1) {
                        linearLayout.setBackgroundResource(io.dcloud.base.R.drawable.toast_bg);
                    } else {
                        linearLayout.setBackgroundResource(android.R.drawable.toast_frame);
                    }
                }
                if (bitmapDecodeStream != null) {
                    android.widget.ImageView imageView = new android.widget.ImageView(topRuningActivity);
                    layoutParams = new android.widget.LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 17;
                    string = io.dcloud.common.util.JSONUtil.getString(jSONObject, io.dcloud.common.constant.AbsoluteConst.JSON_KEY_ICON_WIDTH);
                    string2 = io.dcloud.common.util.JSONUtil.getString(jSONObject, io.dcloud.common.constant.AbsoluteConst.JSON_KEY_ICON_HEIGHT);
                    if (android.text.TextUtils.isEmpty(string) && string.endsWith("px")) {
                        i4 = 0;
                        layoutParams.width = io.dcloud.common.util.PdrUtil.convertToScreenInt(string, 0, 0, scale);
                    } else {
                        i4 = 0;
                    }
                    if (!android.text.TextUtils.isEmpty(string2) && string2.endsWith("px")) {
                        layoutParams.height = io.dcloud.common.util.PdrUtil.convertToScreenInt(string2, i4, i4, scale);
                    }
                    iDip2px2 = io.dcloud.common.adapter.util.CanvasHelper.dip2px(topRuningActivity, 7.0f);
                    if (str2.equals(io.dcloud.common.constant.AbsoluteConst.JSON_VALUE_INLINE)) {
                        linearLayout.setOrientation(i4);
                        layoutParams.setMargins(iDip2px2, iDip2px2, iDip2px2, iDip2px2);
                    } else {
                        int iDip2px4 = io.dcloud.common.adapter.util.CanvasHelper.dip2px(topRuningActivity, 1.0f);
                        linearLayout.setOrientation(1);
                        layoutParams.setMargins(iDip2px2, iDip2px2, iDip2px2, iDip2px4);
                    }
                    imageView.setLayoutParams(layoutParams);
                    imageView.setImageBitmap(bitmapDecodeStream);
                    linearLayout.addView(imageView);
                } else {
                    i3 = i3;
                }
                android.widget.LinearLayout.LayoutParams layoutParams2 = new android.widget.LinearLayout.LayoutParams(-2, -2);
                layoutParams2.gravity = 17;
                if (zEquals != 0) {
                    io.dcloud.common.DHInterface.AbsMgr absMgr = this.m;
                    io.dcloud.common.DHInterface.IMgr.MgrType mgrType = io.dcloud.common.DHInterface.IMgr.MgrType.FeatureMgr;
                    java.lang.Object objObtainFrameView = iWebview.obtainFrameView();
                    java.lang.Object objOptJSONObject = jSONObject.optJSONObject("richTextStyle");
                    java.lang.Object[] objArr = new java.lang.Object[4];
                    objArr[0] = objObtainFrameView;
                    objArr[1] = str;
                    objArr[2] = objOptJSONObject;
                    objArr[c2] = toastCompat;
                    java.lang.Object[] objArr2 = new java.lang.Object[4];
                    objArr2[0] = iWebview;
                    objArr2[1] = "nativeobj";
                    objArr2[2] = "makeRichText";
                    objArr2[c2] = objArr;
                    textView = (android.widget.TextView) absMgr.processEvent(mgrType, 10, objArr2);
                } else {
                    android.widget.TextView textView2 = new android.widget.TextView(topRuningActivity);
                    textView2.setText(str);
                    textView = textView2;
                }
                textView.setTextColor(android.graphics.Color.parseColor("#ffffffff"));
                textView.setLayoutParams(layoutParams2);
                linearLayout.addView(textView);
                if (zEquals) {
                    ((io.dcloud.p.g0) toastCompat).a(linearLayout, textView);
                } else {
                    toastCompat.setView(linearLayout);
                }
                toastCompat.setGravity(i3 | i6, toastCompat.getXOffset(), toastCompat.getYOffset());
                toastCompat.setDuration(i2);
                toast = toastCompat;
            }
            toast.show();
        }
        iApp2 = iApp;
        zEquals = false;
        i2 = 0;
        i3 = 1;
        topRuningActivity = io.dcloud.common.util.RuningAcitvityUtil.getTopRuningActivity(iWebview.getActivity());
        if (topRuningActivity == null) {
        }
        if (bitmapDecodeStream != null) {
            if (zEquals) {
                c2 = 3;
                toastCompat = new io.dcloud.p.g0(topRuningActivity, iApp2.obtainAppId());
            } else {
                c2 = 3;
                toastCompat = new com.dcloud.android.widget.toast.ToastCompat(topRuningActivity.getApplicationContext());
            }
            linearLayout = new android.widget.LinearLayout(topRuningActivity);
            int iDip2px5 = io.dcloud.common.adapter.util.CanvasHelper.dip2px(topRuningActivity, 10.0f);
            iDip2px = io.dcloud.common.adapter.util.CanvasHelper.dip2px(topRuningActivity, 8.0f);
            linearLayout.setPadding(iDip2px5, iDip2px, iDip2px5, iDip2px);
            linearLayout.setGravity(17);
            int i7 = i5;
            if (!android.os.Build.BRAND.equalsIgnoreCase("xiaomi")) {
                gradientDrawable = new android.graphics.drawable.GradientDrawable();
                gradientDrawable.setCornerRadius(iDip2px);
                gradientDrawable.setShape(0);
                if (iStringToColor <= 0) {
                    gradientDrawable.setColor(iStringToColor);
                } else {
                    gradientDrawable.setColor(-1308622848);
                }
                linearLayout.setBackground(gradientDrawable);
            } else if (iStringToColor <= 0) {
                android.graphics.drawable.Drawable drawable2 = iWebview.getContext().getResources().getDrawable(android.R.drawable.toast_frame);
                drawable2.setColorFilter(iStringToColor, android.graphics.PorterDuff.Mode.SRC);
                linearLayout.setBackground(drawable2);
            } else {
                systemProperty = io.dcloud.common.constant.DataInterface.getSystemProperty();
                java.lang.String[] strArr2 = {"v11", "v12"};
                if (io.dcloud.common.util.PdrUtil.isEmpty(systemProperty)) {
                    linearLayout.setBackgroundResource(android.R.drawable.toast_frame);
                } else {
                    linearLayout.setBackgroundResource(android.R.drawable.toast_frame);
                }
            }
            if (bitmapDecodeStream != null) {
                android.widget.ImageView imageView2 = new android.widget.ImageView(topRuningActivity);
                layoutParams = new android.widget.LinearLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 17;
                string = io.dcloud.common.util.JSONUtil.getString(jSONObject, io.dcloud.common.constant.AbsoluteConst.JSON_KEY_ICON_WIDTH);
                string2 = io.dcloud.common.util.JSONUtil.getString(jSONObject, io.dcloud.common.constant.AbsoluteConst.JSON_KEY_ICON_HEIGHT);
                if (android.text.TextUtils.isEmpty(string)) {
                    i4 = 0;
                } else {
                    i4 = 0;
                }
                if (!android.text.TextUtils.isEmpty(string2)) {
                    layoutParams.height = io.dcloud.common.util.PdrUtil.convertToScreenInt(string2, i4, i4, scale);
                }
                iDip2px2 = io.dcloud.common.adapter.util.CanvasHelper.dip2px(topRuningActivity, 7.0f);
                if (str2.equals(io.dcloud.common.constant.AbsoluteConst.JSON_VALUE_INLINE)) {
                    linearLayout.setOrientation(i4);
                    layoutParams.setMargins(iDip2px2, iDip2px2, iDip2px2, iDip2px2);
                } else {
                    int iDip2px6 = io.dcloud.common.adapter.util.CanvasHelper.dip2px(topRuningActivity, 1.0f);
                    linearLayout.setOrientation(1);
                    layoutParams.setMargins(iDip2px2, iDip2px2, iDip2px2, iDip2px6);
                }
                imageView2.setLayoutParams(layoutParams);
                imageView2.setImageBitmap(bitmapDecodeStream);
                linearLayout.addView(imageView2);
            } else {
                i3 = i3;
            }
            android.widget.LinearLayout.LayoutParams layoutParams3 = new android.widget.LinearLayout.LayoutParams(-2, -2);
            layoutParams3.gravity = 17;
            if (zEquals != 0) {
                io.dcloud.common.DHInterface.AbsMgr absMgr2 = this.m;
                io.dcloud.common.DHInterface.IMgr.MgrType mgrType2 = io.dcloud.common.DHInterface.IMgr.MgrType.FeatureMgr;
                java.lang.Object objObtainFrameView2 = iWebview.obtainFrameView();
                java.lang.Object objOptJSONObject2 = jSONObject.optJSONObject("richTextStyle");
                java.lang.Object[] objArr3 = new java.lang.Object[4];
                objArr3[0] = objObtainFrameView2;
                objArr3[1] = str;
                objArr3[2] = objOptJSONObject2;
                objArr3[c2] = toastCompat;
                java.lang.Object[] objArr4 = new java.lang.Object[4];
                objArr4[0] = iWebview;
                objArr4[1] = "nativeobj";
                objArr4[2] = "makeRichText";
                objArr4[c2] = objArr3;
                textView = (android.widget.TextView) absMgr2.processEvent(mgrType2, 10, objArr4);
            } else {
                android.widget.TextView textView3 = new android.widget.TextView(topRuningActivity);
                textView3.setText(str);
                textView = textView3;
            }
            textView.setTextColor(android.graphics.Color.parseColor("#ffffffff"));
            textView.setLayoutParams(layoutParams3);
            linearLayout.addView(textView);
            if (zEquals) {
                ((io.dcloud.p.g0) toastCompat).a(linearLayout, textView);
            } else {
                toastCompat.setView(linearLayout);
            }
            toastCompat.setGravity(i3 | i7, toastCompat.getXOffset(), toastCompat.getYOffset());
            toastCompat.setDuration(i2);
            toast = toastCompat;
        } else {
            if (zEquals) {
                c2 = 3;
                toastCompat = new io.dcloud.p.g0(topRuningActivity, iApp2.obtainAppId());
            } else {
                c2 = 3;
                toastCompat = new com.dcloud.android.widget.toast.ToastCompat(topRuningActivity.getApplicationContext());
            }
            linearLayout = new android.widget.LinearLayout(topRuningActivity);
            int iDip2px7 = io.dcloud.common.adapter.util.CanvasHelper.dip2px(topRuningActivity, 10.0f);
            iDip2px = io.dcloud.common.adapter.util.CanvasHelper.dip2px(topRuningActivity, 8.0f);
            linearLayout.setPadding(iDip2px7, iDip2px, iDip2px7, iDip2px);
            linearLayout.setGravity(17);
            int i8 = i5;
            if (!android.os.Build.BRAND.equalsIgnoreCase("xiaomi")) {
                gradientDrawable = new android.graphics.drawable.GradientDrawable();
                gradientDrawable.setCornerRadius(iDip2px);
                gradientDrawable.setShape(0);
                if (iStringToColor <= 0) {
                    gradientDrawable.setColor(iStringToColor);
                } else {
                    gradientDrawable.setColor(-1308622848);
                }
                linearLayout.setBackground(gradientDrawable);
            } else if (iStringToColor <= 0) {
                android.graphics.drawable.Drawable drawable3 = iWebview.getContext().getResources().getDrawable(android.R.drawable.toast_frame);
                drawable3.setColorFilter(iStringToColor, android.graphics.PorterDuff.Mode.SRC);
                linearLayout.setBackground(drawable3);
            } else {
                systemProperty = io.dcloud.common.constant.DataInterface.getSystemProperty();
                java.lang.String[] strArr3 = {"v11", "v12"};
                if (io.dcloud.common.util.PdrUtil.isEmpty(systemProperty)) {
                    linearLayout.setBackgroundResource(android.R.drawable.toast_frame);
                } else {
                    linearLayout.setBackgroundResource(android.R.drawable.toast_frame);
                }
            }
            if (bitmapDecodeStream != null) {
                android.widget.ImageView imageView3 = new android.widget.ImageView(topRuningActivity);
                layoutParams = new android.widget.LinearLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 17;
                string = io.dcloud.common.util.JSONUtil.getString(jSONObject, io.dcloud.common.constant.AbsoluteConst.JSON_KEY_ICON_WIDTH);
                string2 = io.dcloud.common.util.JSONUtil.getString(jSONObject, io.dcloud.common.constant.AbsoluteConst.JSON_KEY_ICON_HEIGHT);
                if (android.text.TextUtils.isEmpty(string)) {
                    i4 = 0;
                } else {
                    i4 = 0;
                }
                if (!android.text.TextUtils.isEmpty(string2)) {
                    layoutParams.height = io.dcloud.common.util.PdrUtil.convertToScreenInt(string2, i4, i4, scale);
                }
                iDip2px2 = io.dcloud.common.adapter.util.CanvasHelper.dip2px(topRuningActivity, 7.0f);
                if (str2.equals(io.dcloud.common.constant.AbsoluteConst.JSON_VALUE_INLINE)) {
                    linearLayout.setOrientation(i4);
                    layoutParams.setMargins(iDip2px2, iDip2px2, iDip2px2, iDip2px2);
                } else {
                    int iDip2px8 = io.dcloud.common.adapter.util.CanvasHelper.dip2px(topRuningActivity, 1.0f);
                    linearLayout.setOrientation(1);
                    layoutParams.setMargins(iDip2px2, iDip2px2, iDip2px2, iDip2px8);
                }
                imageView3.setLayoutParams(layoutParams);
                imageView3.setImageBitmap(bitmapDecodeStream);
                linearLayout.addView(imageView3);
            } else {
                i3 = i3;
            }
            android.widget.LinearLayout.LayoutParams layoutParams4 = new android.widget.LinearLayout.LayoutParams(-2, -2);
            layoutParams4.gravity = 17;
            if (zEquals != 0) {
                io.dcloud.common.DHInterface.AbsMgr absMgr3 = this.m;
                io.dcloud.common.DHInterface.IMgr.MgrType mgrType3 = io.dcloud.common.DHInterface.IMgr.MgrType.FeatureMgr;
                java.lang.Object objObtainFrameView3 = iWebview.obtainFrameView();
                java.lang.Object objOptJSONObject3 = jSONObject.optJSONObject("richTextStyle");
                java.lang.Object[] objArr5 = new java.lang.Object[4];
                objArr5[0] = objObtainFrameView3;
                objArr5[1] = str;
                objArr5[2] = objOptJSONObject3;
                objArr5[c2] = toastCompat;
                java.lang.Object[] objArr6 = new java.lang.Object[4];
                objArr6[0] = iWebview;
                objArr6[1] = "nativeobj";
                objArr6[2] = "makeRichText";
                objArr6[c2] = objArr5;
                textView = (android.widget.TextView) absMgr3.processEvent(mgrType3, 10, objArr6);
            } else {
                android.widget.TextView textView4 = new android.widget.TextView(topRuningActivity);
                textView4.setText(str);
                textView = textView4;
            }
            textView.setTextColor(android.graphics.Color.parseColor("#ffffffff"));
            textView.setLayoutParams(layoutParams4);
            linearLayout.addView(textView);
            if (zEquals) {
                ((io.dcloud.p.g0) toastCompat).a(linearLayout, textView);
            } else {
                toastCompat.setView(linearLayout);
            }
            toastCompat.setGravity(i3 | i8, toastCompat.getXOffset(), toastCompat.getYOffset());
            toastCompat.setDuration(i2);
            toast = toastCompat;
        }
        toast.show();
    }

    private void a(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, org.json.JSONObject jSONObject) {
        int i2;
        int i3;
        if (this.c != null) {
            io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview, str, io.dcloud.common.constant.DOMException.toJSON(5, ""), io.dcloud.common.util.JSUtil.ERROR, true, false);
            return;
        }
        android.app.Activity topRuningActivity = io.dcloud.common.util.RuningAcitvityUtil.getTopRuningActivity(iWebview.getActivity());
        int i4 = io.dcloud.common.util.JSONUtil.getInt(jSONObject, io.dcloud.common.constant.AbsoluteConst.JSON_KEY_STARTYEAR);
        int i5 = io.dcloud.common.util.JSONUtil.getInt(jSONObject, "startMonth");
        int i6 = io.dcloud.common.util.JSONUtil.getInt(jSONObject, "startDay");
        int i7 = io.dcloud.common.util.JSONUtil.getInt(jSONObject, io.dcloud.common.constant.AbsoluteConst.JSON_KEY_ENDYEAR);
        int i8 = io.dcloud.common.util.JSONUtil.getInt(jSONObject, "endMonth");
        int i9 = io.dcloud.common.util.JSONUtil.getInt(jSONObject, "endDay");
        int i10 = io.dcloud.common.util.JSONUtil.getInt(jSONObject, "setYear");
        int i11 = io.dcloud.common.util.JSONUtil.getInt(jSONObject, "setMonth");
        int i12 = io.dcloud.common.util.JSONUtil.getInt(jSONObject, "setDay");
        if (i10 == 0) {
            java.util.GregorianCalendar gregorianCalendar = new java.util.GregorianCalendar();
            gregorianCalendar.setTime(new java.util.Date());
            int i13 = gregorianCalendar.get(1);
            int i14 = gregorianCalendar.get(2);
            i12 = gregorianCalendar.get(5);
            i10 = i13;
            i11 = i14;
        }
        boolean z = (jSONObject == null || jSONObject.isNull(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_TITLE)) ? false : true;
        java.util.GregorianCalendar gregorianCalendar2 = new java.util.GregorianCalendar();
        io.dcloud.feature.ui.nativeui.NativeUIFeatureImpl.f fVar = new io.dcloud.feature.ui.nativeui.NativeUIFeatureImpl.f(topRuningActivity, io.dcloud.common.util.AppRuntime.getAppDarkMode(iWebview.getContext()) ? 4 : 0, new io.dcloud.feature.ui.nativeui.NativeUIFeatureImpl.e(), i10, i11, i12, i10, i11, i12, z, iWebview, str);
        if (io.dcloud.common.adapter.util.DeviceInfo.sDeviceSdkVer >= 11) {
            if (i4 > 1900) {
                gregorianCalendar2.set(1, i4);
                i2 = 2;
                gregorianCalendar2.set(2, i5);
                i3 = 5;
                gregorianCalendar2.set(5, i6);
                fVar.getDatePicker().setMinDate(gregorianCalendar2.getTimeInMillis());
            } else {
                i2 = 2;
                i3 = 5;
            }
            if (i7 > 1900 && i7 >= i4) {
                gregorianCalendar2.set(1, i7);
                gregorianCalendar2.set(i2, i8);
                gregorianCalendar2.set(i3, i9);
                fVar.getDatePicker().setMaxDate(gregorianCalendar2.getTimeInMillis());
            }
        }
        fVar.setOnDismissListener(new io.dcloud.feature.ui.nativeui.NativeUIFeatureImpl.g(iWebview, str));
        if (z) {
            fVar.setTitle(io.dcloud.common.util.JSONUtil.getString(jSONObject, io.dcloud.common.constant.AbsoluteConst.JSON_KEY_TITLE));
        }
        fVar.show();
        this.c = fVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        this.c = null;
        this.d = 0;
        this.e = 0;
        this.f = 0;
    }

    private io.dcloud.feature.ui.nativeui.a a(java.lang.String str, org.json.JSONObject jSONObject, java.lang.String str2, io.dcloud.common.DHInterface.IWebview iWebview) {
        java.lang.String strOptString = jSONObject.has(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_TITLE) ? jSONObject.optString(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_TITLE) : null;
        java.lang.String strOptString2 = jSONObject.has(com.alibaba.android.bindingx.core.internal.BindingXConstants.STATE_CANCEL) ? jSONObject.optString(com.alibaba.android.bindingx.core.internal.BindingXConstants.STATE_CANCEL) : null;
        org.json.JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("buttons");
        if (jSONArrayOptJSONArray == null || a(jSONArrayOptJSONArray, iWebview.obtainApp(), str2, iWebview)) {
            return null;
        }
        io.dcloud.feature.ui.nativeui.NativeUIFeatureImpl.d dVar = new io.dcloud.feature.ui.nativeui.NativeUIFeatureImpl.d(iWebview, str2, str);
        android.app.Activity topRuningActivity = io.dcloud.common.util.RuningAcitvityUtil.getTopRuningActivity(iWebview.getActivity());
        topRuningActivity.setTheme(io.dcloud.feature.ui.nativeui.NativeUIR.ACTS_STYLE_ActionSheetStyleIOS7);
        iWebview.obtainApp().isFullScreen();
        io.dcloud.feature.ui.nativeui.a aVar = new io.dcloud.feature.ui.nativeui.a(topRuningActivity);
        aVar.b(strOptString2);
        aVar.a(strOptString);
        aVar.a(jSONArrayOptJSONArray);
        aVar.a(dVar);
        aVar.a(true);
        aVar.j();
        return aVar;
    }

    private void a(byte b2, java.lang.String str, org.json.JSONObject jSONObject, io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str2) {
        java.lang.String[] strArr;
        java.lang.String strOptString = jSONObject.optString(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_VERTICAL_ALIGN, "center");
        org.json.JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("buttons");
        if (jSONArrayOptJSONArray != null) {
            int length = jSONArrayOptJSONArray.length();
            strArr = new java.lang.String[length];
            for (int i2 = 0; i2 < length; i2++) {
                strArr[i2] = io.dcloud.common.util.JSONUtil.getString(jSONArrayOptJSONArray, i2);
            }
        } else {
            strArr = null;
        }
        java.lang.String[] strArr2 = strArr;
        if (android.text.TextUtils.equals(strOptString, "center")) {
            a(b2, jSONObject.optString(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_TITLE), null, str, strArr2, null, iWebview, str2, 17);
        } else if (android.text.TextUtils.equals(strOptString, "top")) {
            a(b2, jSONObject.optString(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_TITLE), null, str, strArr2, null, iWebview, str2, 49);
        } else if (android.text.TextUtils.equals(strOptString, "bottom")) {
            a(b2, jSONObject.optString(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_TITLE), null, str, strArr2, null, iWebview, str2, 81);
        }
    }

    private void a(byte b2, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String[] strArr, java.lang.String str4, io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str5) {
        a(b2, str, str2, str3, strArr, str4, iWebview, str5, 17);
    }

    private void a(byte b2, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String[] strArr, java.lang.String str4, io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str5, int i2) {
        android.widget.EditText editText;
        android.app.Activity topRuningActivity = io.dcloud.common.util.RuningAcitvityUtil.getTopRuningActivity(iWebview.getActivity());
        if (b2 == 0) {
            if (a(str3, iWebview.obtainApp(), iWebview, str5)) {
                return;
            }
            com.dcloud.android.widget.dialog.DCloudAlertDialog dCloudAlertDialogInitDialogTheme = io.dcloud.common.util.DialogUtil.initDialogTheme(topRuningActivity, true);
            if (strArr != null && io.dcloud.common.util.PdrUtil.isEmpty(strArr[0])) {
                strArr[0] = io.dcloud.common.adapter.util.AndroidResources.getString(android.R.string.ok);
            }
            if (!io.dcloud.common.util.PdrUtil.isEmpty(str)) {
                dCloudAlertDialogInitDialogTheme.setTitle(str);
            }
            dCloudAlertDialogInitDialogTheme.setCanceledOnTouchOutside(false);
            dCloudAlertDialogInitDialogTheme.setMessage(str3);
            dCloudAlertDialogInitDialogTheme.setButton(-1, strArr[0], new io.dcloud.feature.ui.nativeui.NativeUIFeatureImpl.k(dCloudAlertDialogInitDialogTheme, iWebview, str5));
            dCloudAlertDialogInitDialogTheme.setOnKeyListener(new io.dcloud.feature.ui.nativeui.NativeUIFeatureImpl.l(dCloudAlertDialogInitDialogTheme, iWebview, str5));
            dCloudAlertDialogInitDialogTheme.show();
            return;
        }
        com.dcloud.android.widget.dialog.DCloudAlertDialog dCloudAlertDialogInitDialogTheme2 = io.dcloud.common.util.DialogUtil.initDialogTheme(topRuningActivity, true);
        dCloudAlertDialogInitDialogTheme2.setMessage(str3);
        if (b2 == 2) {
            editText = new android.widget.EditText(topRuningActivity);
            if (str4 != null) {
                editText.setHint(str4);
            }
            dCloudAlertDialogInitDialogTheme2.setView(editText);
            android.text.Editable text = editText.getText();
            if (text instanceof android.text.Spannable) {
                android.text.Selection.setSelection(text, text.length());
            }
        } else {
            editText = null;
        }
        if (b2 == 1) {
            android.view.Window window = dCloudAlertDialogInitDialogTheme2.getWindow();
            android.view.WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = i2;
            window.setAttributes(attributes);
        }
        if (!io.dcloud.common.util.PdrUtil.isEmpty(str)) {
            dCloudAlertDialogInitDialogTheme2.setTitle(str);
        }
        dCloudAlertDialogInitDialogTheme2.setCanceledOnTouchOutside(false);
        dCloudAlertDialogInitDialogTheme2.setMessage(str3);
        java.lang.String[] strArr2 = strArr == null ? new java.lang.String[]{io.dcloud.common.adapter.util.AndroidResources.getString(android.R.string.ok), io.dcloud.common.adapter.util.AndroidResources.getString(android.R.string.cancel)} : strArr;
        if (a(b2, str3, strArr2, iWebview.obtainApp(), iWebview, str5)) {
            return;
        }
        int i3 = 0;
        while (i3 < strArr2.length && i3 < 3) {
            com.dcloud.android.widget.dialog.DCloudAlertDialog dCloudAlertDialog = dCloudAlertDialogInitDialogTheme2;
            android.widget.EditText editText2 = editText;
            io.dcloud.feature.ui.nativeui.NativeUIFeatureImpl.a aVar = new io.dcloud.feature.ui.nativeui.NativeUIFeatureImpl.a(b2, editText2, iWebview, str5, i3, dCloudAlertDialog);
            int i4 = i3;
            if (i4 == 0) {
                dCloudAlertDialog.setButton(-1, strArr2[i4], aVar);
            } else if (i4 == 1) {
                dCloudAlertDialog.setButton(-2, strArr2[i4], aVar);
            } else if (i4 == 2) {
                dCloudAlertDialog.setButton(-3, strArr2[i4], aVar);
            }
            editText = editText2;
            dCloudAlertDialogInitDialogTheme2 = dCloudAlertDialog;
            i3 = i4 + 1;
        }
        com.dcloud.android.widget.dialog.DCloudAlertDialog dCloudAlertDialog2 = dCloudAlertDialogInitDialogTheme2;
        android.widget.EditText editText3 = editText;
        dCloudAlertDialog2.setOnKeyListener(new io.dcloud.feature.ui.nativeui.NativeUIFeatureImpl.b(b2, editText3, iWebview, str5, dCloudAlertDialog2));
        dCloudAlertDialog2.show();
        if (b2 != 2 || android.os.Build.FINGERPRINT.toLowerCase(java.util.Locale.ENGLISH).contains("flyme")) {
            return;
        }
        io.dcloud.common.adapter.util.DeviceInfo.showIME(editText3);
    }

    private boolean a(java.lang.String str, io.dcloud.common.DHInterface.IApp iApp, io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str) || !io.dcloud.common.util.BaseInfo.ISAMU) {
            return false;
        }
        if (!str.contains("更新") && !str.contains("升级") && !str.contains("版本")) {
            return false;
        }
        try {
            io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview, str2, "{index:0}", io.dcloud.common.util.JSUtil.OK, true, false);
            a(iApp);
            return true;
        } catch (org.json.JSONException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    private boolean a(byte b2, java.lang.String str, java.lang.String[] strArr, io.dcloud.common.DHInterface.IApp iApp, io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str2) {
        if (!android.text.TextUtils.isEmpty(str) && strArr != null && io.dcloud.common.util.BaseInfo.ISAMU) {
            for (int i2 = 0; i2 < strArr.length && i2 < 3; i2++) {
                java.lang.String str3 = strArr[i2];
                if (str3.contains("更新") || str3.contains("升级") || ((str.contains("更新") || str.contains("升级") || str.contains("版本")) && (str3.equals(com.taobao.weex.ui.module.WXModalUIModule.OK) || str3.equals("是") || str3.equals("确定")))) {
                    try {
                        if (b2 == 2) {
                            io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview, str2, "{index:" + i2 + ",message:" + io.dcloud.common.util.JSONUtil.toJSONableString("") + com.taobao.weex.el.parse.Operators.BLOCK_END_STR, io.dcloud.common.util.JSUtil.OK, true, false);
                            a(iApp);
                            return true;
                        }
                        if (b2 == 1) {
                            io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview, str2, java.lang.String.valueOf(i2), io.dcloud.common.util.JSUtil.OK, true, false);
                            a(iApp);
                            return true;
                        }
                    } catch (org.json.JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
        return false;
    }

    private boolean a(org.json.JSONArray jSONArray, io.dcloud.common.DHInterface.IApp iApp, java.lang.String str, io.dcloud.common.DHInterface.IWebview iWebview) {
        java.lang.String str2;
        io.dcloud.common.DHInterface.IWebview iWebview2;
        if (jSONArray != null && io.dcloud.common.util.BaseInfo.ISAMU) {
            int i2 = 0;
            while (i2 < jSONArray.length()) {
                try {
                    java.lang.String string = jSONArray.getJSONObject(i2).getString(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_TITLE);
                    if (!string.contains("更新") && !string.contains("升级") && !string.contains("版本")) {
                        str2 = str;
                        iWebview2 = iWebview;
                        i2++;
                        iWebview = iWebview2;
                        str = str2;
                    }
                    str2 = str;
                    iWebview2 = iWebview;
                    try {
                        io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview2, str2, "" + (i2 + 1), io.dcloud.common.util.JSUtil.OK, true, false);
                        a(iApp);
                        return true;
                    } catch (org.json.JSONException e2) {
                        e = e2;
                        e.printStackTrace();
                        i2++;
                        iWebview = iWebview2;
                        str = str2;
                    }
                } catch (org.json.JSONException e3) {
                    e = e3;
                    str2 = str;
                    iWebview2 = iWebview;
                }
            }
        }
        return false;
    }

    private void a(io.dcloud.common.DHInterface.IApp iApp) throws org.json.JSONException {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        jSONObject.put("type", "notify");
        jSONObject.put("appid", iApp.obtainOriginalAppId());
        jSONObject.put("version", iApp.obtainAppVersionName());
        android.util.Log.i(io.dcloud.common.constant.AbsoluteConst.HBUILDER_TAG, jSONObject.toString());
    }
}
