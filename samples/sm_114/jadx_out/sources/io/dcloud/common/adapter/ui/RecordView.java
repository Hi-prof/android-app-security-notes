package io.dcloud.common.adapter.ui;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class RecordView implements android.view.View.OnClickListener, android.os.Handler.Callback {
    private static final int ASSIST_ARROW_LONG_CLICK_INTERVAL_TIMES = 100;
    private static final int ASSIST_ARROW_LONG_CLICK_TIMER_DELAYED = 500;
    private static final int HANDLER_WHAT_LONG_CLICK = 1;
    private static final int HANDLER_WHAT_LONG_CLICK_TIMER = 0;
    public static final int TYPE_ADDRESS = 4;
    public static final int TYPE_COMPANY = 5;
    public static final int TYPE_EMAIL = 2;
    public static final int TYPE_ID = 7;
    public static final int TYPE_NICK = 3;
    public static final int TYPE_PHONE = 1;
    public static final int TYPE_TAX = 6;
    public static final int TYPE_UNKNOW = -1;
    private static final int XORNUMBER = 5;
    int Height;
    int mAnchorY;
    java.lang.String mAppid;
    private android.os.Handler mHandler;
    android.view.ViewGroup mMainView;
    io.dcloud.common.adapter.ui.RecordView.RecordData mRecordData;
    boolean mShowed = false;
    private boolean isLongClick = false;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class RecordData {
        io.dcloud.common.adapter.ui.RecordView.RecordItem[] mRecordItems = new io.dcloud.common.adapter.ui.RecordView.RecordItem[2];
        int mRecordType;

        RecordData() {
        }

        void checkType(int i) {
            if (i == 4) {
                return;
            }
            if ((i != this.mRecordType || this.mRecordItems[1] == null || hasChanged(i)) && i != -1) {
                this.mRecordType = i;
                this.mRecordItems = new io.dcloud.common.adapter.ui.RecordView.RecordItem[2];
                java.lang.String recordDatas = io.dcloud.common.adapter.ui.RecordView.getRecordDatas(io.dcloud.common.adapter.util.DeviceInfo.sApplicationContext, (java.lang.String) null, i);
                if (android.text.TextUtils.isEmpty(recordDatas)) {
                    return;
                }
                io.dcloud.common.adapter.ui.RecordView.this.log("AssistantInput", "RecordView checkType load recordType=" + i + ";value=" + recordDatas);
                java.lang.String[] strArrSplit = recordDatas.split("&");
                for (int i2 = 0; i2 < strArrSplit.length; i2++) {
                    java.lang.String[] strArrSplit2 = strArrSplit[i2].split(com.taobao.weex.el.parse.Operators.SUB);
                    if (!android.text.TextUtils.isEmpty(strArrSplit2[0])) {
                        try {
                            this.mRecordItems[i2] = io.dcloud.common.adapter.ui.RecordView.this.new RecordItem(java.net.URLDecoder.decode(strArrSplit2[0], "utf-8"), java.lang.System.currentTimeMillis());
                        } catch (java.io.UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

        boolean hasChanged(int i) {
            return io.dcloud.common.adapter.util.SP.hasChanged(io.dcloud.common.adapter.util.DeviceInfo.sApplicationContext, "assis_input", true);
        }

        void record(java.lang.String str, int i) {
            if (i != 4 && io.dcloud.common.adapter.ui.RecordView.Utils.needRecord(i)) {
                io.dcloud.common.adapter.ui.RecordView.RecordItem recordItem = io.dcloud.common.adapter.ui.RecordView.this.new RecordItem(str, java.lang.System.currentTimeMillis());
                checkType(i);
                java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
                if (i == 7 || i == 5 || i == 6) {
                    this.mRecordItems[0] = recordItem;
                    try {
                        stringBuffer.append(java.net.URLEncoder.encode(recordItem.mContent, "utf-8"));
                    } catch (java.io.UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                } else {
                    io.dcloud.common.adapter.ui.RecordView.RecordItem recordItem2 = this.mRecordItems[0];
                    if (recordItem2 != null && !android.text.TextUtils.equals(str, recordItem2.mContent)) {
                        io.dcloud.common.adapter.ui.RecordView.RecordItem[] recordItemArr = this.mRecordItems;
                        recordItemArr[1] = recordItemArr[0];
                    }
                    this.mRecordItems[0] = recordItem;
                    if (!android.text.TextUtils.isEmpty(recordItem.mContent)) {
                        try {
                            stringBuffer.append(java.net.URLEncoder.encode(this.mRecordItems[0].mContent, "utf-8"));
                            io.dcloud.common.adapter.ui.RecordView.RecordItem recordItem3 = this.mRecordItems[1];
                            if (recordItem3 != null && !android.text.TextUtils.isEmpty(recordItem3.mContent)) {
                                stringBuffer.append("&");
                                stringBuffer.append(java.net.URLEncoder.encode(this.mRecordItems[1].mContent, "utf-8"));
                            }
                        } catch (java.io.UnsupportedEncodingException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
                io.dcloud.common.adapter.ui.RecordView.setRcordDatas(io.dcloud.common.adapter.util.DeviceInfo.sApplicationContext, (java.lang.String) null, i, stringBuffer.toString());
                io.dcloud.common.adapter.ui.RecordView.this.log("AssistantInput", "RecordView record recordType=" + i + ";value=" + stringBuffer.toString());
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class RecordItem {
        java.lang.String mContent;
        long mTime;

        RecordItem(java.lang.String str, long j) {
            this.mContent = str;
            this.mTime = j;
        }

        public java.lang.String toString() {
            return this.mContent + com.taobao.weex.el.parse.Operators.SUB + this.mTime;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static class Utils {
        Utils() {
        }

        static int convertInt(java.lang.String str) {
            if (android.text.TextUtils.equals(str, "nick")) {
                return 3;
            }
            if (android.text.TextUtils.equals(str, "address")) {
                return 4;
            }
            if (android.text.TextUtils.equals(str, com.taobao.weex.common.Constants.Value.TEL)) {
                return 1;
            }
            if (android.text.TextUtils.equals(str, "email")) {
                return 2;
            }
            if (android.text.TextUtils.equals(str, "none")) {
                return -1;
            }
            if ("company".equals(str)) {
                return 5;
            }
            if ("tax".equals(str)) {
                return 6;
            }
            return "id".equals(str) ? 7 : -1;
        }

        static boolean needRecord(int i) {
            if (i == 1) {
                if (io.dcloud.common.util.AssistInputUtil.useAssistSettingPhone()) {
                    return false;
                }
            } else if (i == 5) {
                if (io.dcloud.common.util.AssistInputUtil.useAssistSettingCompany()) {
                    return false;
                }
            } else if (i == 6) {
                if (io.dcloud.common.util.AssistInputUtil.useAssistSettingTax()) {
                    return false;
                }
            } else if (i == 7) {
                if (io.dcloud.common.util.AssistInputUtil.useAssistSettingId()) {
                    return false;
                }
            } else if (i == 3) {
                if (io.dcloud.common.util.AssistInputUtil.useAssistSettingName()) {
                    return false;
                }
            } else if (i == 2 && io.dcloud.common.util.AssistInputUtil.useAssistSettingEmail()) {
                return false;
            }
            return true;
        }
    }

    RecordView(android.content.Context context, android.view.ViewGroup viewGroup, java.lang.String str) {
        this.mMainView = null;
        this.mHandler = null;
        this.mRecordData = null;
        this.mHandler = new android.os.Handler(this);
        this.mAppid = str;
        this.Height = dp2px(context, 46.0f);
        this.mRecordData = new io.dcloud.common.adapter.ui.RecordView.RecordData();
        android.widget.FrameLayout frameLayout = new android.widget.FrameLayout(context);
        this.mMainView = frameLayout;
        frameLayout.addView(initView2(context, frameLayout));
        frameLayout.addView(initView1(context, frameLayout));
        viewGroup.addView(frameLayout, new android.widget.FrameLayout.LayoutParams(-1, this.Height));
    }

    private boolean checkLocationPermission(android.app.Activity activity) {
        return io.dcloud.common.adapter.util.PermissionUtil.checkLocationPermission(activity);
    }

    private boolean checkLocationService(android.app.Activity activity) {
        return io.dcloud.common.adapter.util.PermissionUtil.checkLocationService(activity);
    }

    static int dp2px(android.content.Context context, float f) {
        return (int) android.util.TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }

    public static java.lang.String getAssisBundleData(java.lang.String str) {
        return getAssisBundleData(io.dcloud.common.adapter.util.DeviceInfo.sApplicationContext, str);
    }

    public static java.lang.String getRecordDatas(java.lang.String str, java.lang.String str2) {
        return getRecordDatas0(io.dcloud.common.adapter.util.DeviceInfo.sApplicationContext, str, str2);
    }

    private static java.lang.String getRecordDatas0(android.content.Context context, java.lang.String str, java.lang.String str2) {
        if ("address_home".equals(str2)) {
            return io.dcloud.common.util.AssistInputUtil.getHomeAddress(io.dcloud.common.adapter.ui.AdaWebview.sCustomeizedInputConnection.mWebview.getContext());
        }
        return "address_work".equals(str2) ? io.dcloud.common.util.AssistInputUtil.getWorkAddress(io.dcloud.common.adapter.ui.AdaWebview.sCustomeizedInputConnection.mWebview.getContext()) : getRecordDatas(context, str, io.dcloud.common.adapter.ui.RecordView.Utils.convertInt(str2));
    }

    private android.widget.TextView getTextView(android.view.View view, java.lang.String str) {
        android.view.View view2 = getView(view, str);
        if (view2 instanceof android.widget.TextView) {
            return (android.widget.TextView) view2;
        }
        return null;
    }

    private android.view.View getView(android.view.View view, java.lang.String str) {
        return view.findViewById(io.dcloud.PdrR.getInt(view.getContext(), "id", str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleAssistInputPreviousOrNextButtOnTouch(android.view.MotionEvent motionEvent, int i) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.isLongClick = false;
            android.os.Message messageObtain = android.os.Message.obtain();
            messageObtain.what = 0;
            messageObtain.obj = java.lang.Integer.valueOf(i);
            this.mHandler.sendMessageDelayed(messageObtain, 500L);
            return;
        }
        if (action != 1) {
            return;
        }
        this.mHandler.removeMessages(0);
        this.mHandler.removeMessages(1);
        if (!this.isLongClick) {
            io.dcloud.common.adapter.ui.AdaWebview.sCustomeizedInputConnection.update(i);
        }
        this.isLongClick = false;
    }

    private void initArrowView(android.view.View view) {
        if (view == null) {
            return;
        }
        android.view.View view2 = getView(view, "dcloud_record_arrow_left_layout");
        if (view2 != null) {
            view2.setClickable(true);
            view2.setLongClickable(true);
            view2.setOnTouchListener(new android.view.View.OnTouchListener() { // from class: io.dcloud.common.adapter.ui.RecordView.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(android.view.View view3, android.view.MotionEvent motionEvent) {
                    io.dcloud.common.adapter.ui.RecordView.this.handleAssistInputPreviousOrNextButtOnTouch(motionEvent, -1);
                    return true;
                }
            });
        }
        android.view.View view3 = getView(view, "dcloud_record_arrow_right_layout");
        if (view3 != null) {
            view3.setClickable(true);
            view3.setLongClickable(true);
            view3.setOnTouchListener(new android.view.View.OnTouchListener() { // from class: io.dcloud.common.adapter.ui.RecordView.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(android.view.View view4, android.view.MotionEvent motionEvent) {
                    io.dcloud.common.adapter.ui.RecordView.this.handleAssistInputPreviousOrNextButtOnTouch(motionEvent, 1);
                    return true;
                }
            });
        }
    }

    private android.view.ViewGroup initView1(android.content.Context context, android.view.ViewGroup viewGroup) {
        android.widget.RelativeLayout relativeLayout = (android.widget.RelativeLayout) android.view.LayoutInflater.from(context).inflate(io.dcloud.PdrR.getInt(context, com.taobao.weex.common.Constants.Name.LAYOUT, "dcloud_record_default"), (android.view.ViewGroup) null);
        getView(relativeLayout, "dcloud_record_scroll_view").setHorizontalScrollBarEnabled(false);
        getView(relativeLayout, "dcloud_record_view_1").setOnClickListener(this);
        getView(relativeLayout, "dcloud_record_view_2").setOnClickListener(this);
        initArrowView(relativeLayout);
        return relativeLayout;
    }

    private android.view.ViewGroup initView2(android.content.Context context, android.view.ViewGroup viewGroup) {
        android.widget.RelativeLayout relativeLayout = (android.widget.RelativeLayout) android.view.LayoutInflater.from(context).inflate(io.dcloud.PdrR.getInt(context, com.taobao.weex.common.Constants.Name.LAYOUT, "dcloud_record_address"), (android.view.ViewGroup) null);
        getView(relativeLayout, "dcloud_record_scroll_view").setHorizontalScrollBarEnabled(false);
        getView(relativeLayout, "dcloud_record_address_view_1").setOnClickListener(this);
        getView(relativeLayout, "dcloud_record_address_view_2").setOnClickListener(this);
        getView(relativeLayout, "dcloud_record_address_view_3").setOnClickListener(this);
        initArrowView(relativeLayout);
        return relativeLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void log(java.lang.String str, java.lang.String str2) {
        io.dcloud.common.adapter.util.Logger.e(str, str2 + ";this=" + this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestCurrentLocation(final android.widget.TextView textView) {
        final android.app.Activity activity = io.dcloud.common.adapter.ui.AdaWebview.sCustomeizedInputConnection.mWebview.getActivity();
        if (!checkLocationPermission(activity)) {
            showConfrim(activity, activity.getString(io.dcloud.base.R.string.dcloud_geo_open_permissions), new java.lang.String[]{activity.getString(io.dcloud.base.R.string.dcloud_common_set_up), activity.getString(io.dcloud.base.R.string.dcloud_common_cancel)}, new android.content.DialogInterface.OnClickListener() { // from class: io.dcloud.common.adapter.ui.RecordView.5
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(android.content.DialogInterface dialogInterface, int i) {
                    if (i == -2) {
                        io.dcloud.common.adapter.ui.AdaWebview.sCustomeizedInputConnection.mWebview.obtainApp().registerSysEventListener(new io.dcloud.common.DHInterface.ISysEventListener() { // from class: io.dcloud.common.adapter.ui.RecordView.5.1
                            @Override // io.dcloud.common.DHInterface.ISysEventListener
                            public boolean onExecute(io.dcloud.common.DHInterface.ISysEventListener.SysEventType sysEventType, java.lang.Object obj) {
                                io.dcloud.common.DHInterface.IApp iAppObtainApp = io.dcloud.common.adapter.ui.AdaWebview.sCustomeizedInputConnection.mWebview.obtainApp();
                                io.dcloud.common.DHInterface.ISysEventListener.SysEventType sysEventType2 = io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onResume;
                                iAppObtainApp.unregisterSysEventListener(this, sysEventType2);
                                if (sysEventType != sysEventType2) {
                                    return false;
                                }
                                io.dcloud.common.adapter.ui.RecordView.AnonymousClass5 anonymousClass5 = io.dcloud.common.adapter.ui.RecordView.AnonymousClass5.this;
                                io.dcloud.common.adapter.ui.RecordView.this.requestCurrentLocation(textView);
                                return false;
                            }
                        }, io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onResume);
                        try {
                            io.dcloud.common.adapter.util.PermissionUtil.goSafeCenter(activity);
                        } catch (android.content.ActivityNotFoundException e) {
                            io.dcloud.common.adapter.util.Logger.e("AssistantInput", "checkLocationService ActivityNotFoundException =" + e);
                            e.printStackTrace();
                        } catch (java.lang.Exception e2) {
                            io.dcloud.common.adapter.util.Logger.e("AssistantInput", "Exception =" + e2);
                        }
                    }
                }
            });
        } else if (checkLocationService(activity)) {
            requestCurrentLocation0(textView);
        } else {
            showConfrim(activity, activity.getString(io.dcloud.base.R.string.dcloud_geo_open_service), new java.lang.String[]{activity.getString(io.dcloud.base.R.string.dcloud_common_set_up), activity.getString(io.dcloud.base.R.string.dcloud_common_cancel)}, new android.content.DialogInterface.OnClickListener() { // from class: io.dcloud.common.adapter.ui.RecordView.4
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(android.content.DialogInterface dialogInterface, int i) {
                    if (i == -2) {
                        io.dcloud.common.adapter.ui.AdaWebview.sCustomeizedInputConnection.mWebview.obtainApp().registerSysEventListener(new io.dcloud.common.DHInterface.ISysEventListener() { // from class: io.dcloud.common.adapter.ui.RecordView.4.1
                            @Override // io.dcloud.common.DHInterface.ISysEventListener
                            public boolean onExecute(io.dcloud.common.DHInterface.ISysEventListener.SysEventType sysEventType, java.lang.Object obj) {
                                io.dcloud.common.DHInterface.IApp iAppObtainApp = io.dcloud.common.adapter.ui.AdaWebview.sCustomeizedInputConnection.mWebview.obtainApp();
                                io.dcloud.common.DHInterface.ISysEventListener.SysEventType sysEventType2 = io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onResume;
                                iAppObtainApp.unregisterSysEventListener(this, sysEventType2);
                                if (sysEventType != sysEventType2) {
                                    return false;
                                }
                                io.dcloud.common.adapter.ui.RecordView.AnonymousClass4 anonymousClass4 = io.dcloud.common.adapter.ui.RecordView.AnonymousClass4.this;
                                io.dcloud.common.adapter.ui.RecordView.this.requestCurrentLocation(textView);
                                return false;
                            }
                        }, io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onResume);
                        android.content.Intent intent = new android.content.Intent("android.settings.LOCATION_SOURCE_SETTINGS");
                        try {
                            activity.startActivity(intent);
                            io.dcloud.common.adapter.ui.RecordView.this.log("AssistantInput", "checkLocationService successful " + android.os.Build.MODEL + "intent=" + intent);
                        } catch (android.content.ActivityNotFoundException e) {
                            io.dcloud.common.adapter.util.Logger.e("AssistantInput", "checkLocationService ActivityNotFoundException =" + e);
                            e.printStackTrace();
                        } catch (java.lang.Exception e2) {
                            io.dcloud.common.adapter.util.Logger.e("Permission", "Exception =" + e2);
                        }
                    }
                }
            });
        }
    }

    private void requestCurrentLocation0(final android.widget.TextView textView) {
        textView.setText(io.dcloud.base.R.string.dcloud_geo_loading);
        io.dcloud.common.DHInterface.FeatureMessageDispatcher.StrongMessageListener strongMessageListener = new io.dcloud.common.DHInterface.FeatureMessageDispatcher.StrongMessageListener("record_address") { // from class: io.dcloud.common.adapter.ui.RecordView.6
            @Override // io.dcloud.common.DHInterface.FeatureMessageDispatcher.StrongMessageListener, io.dcloud.common.DHInterface.FeatureMessageDispatcher.MessageListener
            public void onReceiver(java.lang.Object obj) {
                if (!(obj instanceof java.lang.String)) {
                    textView.setText(io.dcloud.base.R.string.dcloud_geo_current_address);
                } else {
                    io.dcloud.common.adapter.ui.AdaWebview.sCustomeizedInputConnection.setText((java.lang.String) obj);
                    textView.setText(io.dcloud.base.R.string.dcloud_geo_current_address);
                }
            }
        };
        io.dcloud.common.DHInterface.FeatureMessageDispatcher.registerListener(strongMessageListener);
        io.dcloud.common.DHInterface.IWebview iWebview = io.dcloud.common.adapter.ui.AdaWebview.sCustomeizedInputConnection.mWebview;
        io.dcloud.common.DHInterface.AbsMgr absMgrObtainWindowMgr = iWebview.obtainFrameView().obtainWindowMgr();
        org.json.JSONArray jSONArray = new org.json.JSONArray();
        jSONArray.put(io.dcloud.common.adapter.ui.RecordView.AnonymousClass6.class.getName() + "_" + strongMessageListener.hashCode());
        jSONArray.put(strongMessageListener.hashCode());
        jSONArray.put(true);
        jSONArray.put("null");
        jSONArray.put("");
        jSONArray.put("null");
        jSONArray.put("null");
        jSONArray.put("null");
        absMgrObtainWindowMgr.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.FeatureMgr, 1, new java.lang.Object[]{iWebview, io.dcloud.common.DHInterface.IFeature.F_GEOLOCATION, "getCurrentPosition", jSONArray});
    }

    public static void setAssisBundleData(android.content.Context context, java.lang.String str, java.lang.String str2) {
        io.dcloud.common.adapter.util.SP.setBundleData(context, "assis_input", str, str2, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setRcordDatas(android.content.Context context, java.lang.String str, int i, java.lang.String str2) {
        if (i != -1) {
            java.lang.String strEncodeString = io.dcloud.common.util.Base64.encodeString(str2, true, 5);
            if (io.dcloud.common.util.PdrUtil.isEmpty(strEncodeString)) {
                strEncodeString = "";
            }
            setAssisBundleData(context, "_input_text" + i, strEncodeString);
        }
    }

    private static void setRcordDatas0(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        setRcordDatas(context, str, io.dcloud.common.adapter.ui.RecordView.Utils.convertInt(str2), str3);
    }

    private void showConfrim(android.app.Activity activity, java.lang.String str, java.lang.String[] strArr, android.content.DialogInterface.OnClickListener onClickListener) {
        com.dcloud.android.widget.dialog.DCloudAlertDialog dCloudAlertDialogInitDialogTheme = io.dcloud.common.util.DialogUtil.initDialogTheme(activity, true);
        dCloudAlertDialogInitDialogTheme.setCanceledOnTouchOutside(false);
        dCloudAlertDialogInitDialogTheme.setMessage(str);
        dCloudAlertDialogInitDialogTheme.setButton(-2, strArr[0], onClickListener);
        dCloudAlertDialogInitDialogTheme.setButton(-1, strArr[1], onClickListener);
        dCloudAlertDialogInitDialogTheme.show();
    }

    void conceal() {
    }

    void display() {
    }

    public synchronized void dispose() {
        this.isLongClick = false;
        android.os.Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.mHandler = null;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(android.os.Message message) {
        int i = message.what;
        if (i == 0) {
            this.isLongClick = true;
            android.os.Message messageObtain = android.os.Message.obtain();
            messageObtain.what = 1;
            messageObtain.obj = message.obj;
            this.mHandler.sendMessageDelayed(messageObtain, 100L);
            return false;
        }
        if (i != 1 || !this.isLongClick) {
            return false;
        }
        java.lang.Object obj = message.obj;
        if (obj instanceof java.lang.Integer) {
            io.dcloud.common.adapter.ui.AdaWebview.sCustomeizedInputConnection.update(((java.lang.Integer) obj).intValue());
        }
        android.os.Message messageObtain2 = android.os.Message.obtain();
        messageObtain2.what = 1;
        messageObtain2.obj = message.obj;
        this.mHandler.sendMessageDelayed(messageObtain2, 100L);
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(android.view.View view) {
        int id = view.getId();
        android.content.Context context = view.getContext();
        if (id == io.dcloud.PdrR.getInt(context, "id", "dcloud_record_address_view_1")) {
            requestCurrentLocation((android.widget.TextView) view);
            return;
        }
        if (id == io.dcloud.PdrR.getInt(context, "id", "dcloud_record_address_view_2")) {
            io.dcloud.common.adapter.ui.AdaWebview.sCustomeizedInputConnection.setText(getRecordDatas(this.mMainView.getContext(), this.mAppid, "address_home"));
        } else if (id != io.dcloud.PdrR.getInt(context, "id", "dcloud_record_address_view_3")) {
            io.dcloud.common.adapter.ui.AdaWebview.sCustomeizedInputConnection.setText(((android.widget.TextView) view).getText().toString());
        } else {
            io.dcloud.common.adapter.ui.AdaWebview.sCustomeizedInputConnection.setText(getRecordDatas(this.mMainView.getContext(), this.mAppid, "address_work"));
        }
    }

    void record(java.lang.String str, int i) {
        if (i != -1) {
            this.mRecordData.record(str, i);
        }
    }

    void update(final int i, final int i2) {
        this.mMainView.post(new java.lang.Runnable() { // from class: io.dcloud.common.adapter.ui.RecordView.3
            @Override // java.lang.Runnable
            public void run() {
                io.dcloud.common.adapter.ui.RecordView.this.update0(i, i2);
            }
        });
    }

    void update0(int i, int i2) {
        boolean z;
        android.widget.FrameLayout.LayoutParams layoutParams = (android.widget.FrameLayout.LayoutParams) this.mMainView.getLayoutParams();
        layoutParams.topMargin = i - this.Height;
        layoutParams.bottomMargin = i;
        this.mMainView.setLayoutParams(layoutParams);
        this.mAnchorY = i;
        boolean z2 = true;
        boolean z3 = i2 != -1;
        this.mMainView.setVisibility(z3 ? 0 : 8);
        this.mMainView.bringToFront();
        this.mRecordData.checkType(i2);
        android.view.View childAt = this.mMainView.getChildAt(0);
        android.view.View childAt2 = this.mMainView.getChildAt(1);
        if (i2 == 4) {
            childAt.setVisibility(0);
            childAt2.setVisibility(8);
            getView(childAt, "dcloud_record_address_view_1").setVisibility(0);
            getTextView(childAt, "dcloud_record_address_view_1").setText(io.dcloud.base.R.string.dcloud_current_address);
            java.lang.String recordDatas = getRecordDatas(this.mMainView.getContext(), this.mAppid, "address_home");
            getView(childAt, "dcloud_record_line_1").setVisibility(android.text.TextUtils.isEmpty(recordDatas) ? 8 : 0);
            getView(childAt, "dcloud_record_address_view_2").setVisibility(android.text.TextUtils.isEmpty(recordDatas) ? 8 : 0);
            java.lang.String recordDatas2 = getRecordDatas(this.mMainView.getContext(), this.mAppid, "address_work");
            getView(childAt, "dcloud_record_line_2").setVisibility(android.text.TextUtils.isEmpty(recordDatas2) ? 8 : 0);
            getView(childAt, "dcloud_record_address_view_3").setVisibility(android.text.TextUtils.isEmpty(recordDatas2) ? 8 : 0);
        } else {
            childAt2.setVisibility(0);
            childAt.setVisibility(8);
            if (this.mRecordData.mRecordItems[0] != null) {
                getView(childAt2, "dcloud_record_view_1").setVisibility(z3 ? 0 : 8);
                getTextView(childAt2, "dcloud_record_view_1").setText(this.mRecordData.mRecordItems[0].mContent);
                z = true;
            } else {
                this.mMainView.setVisibility(8);
                z = false;
            }
            if (this.mRecordData.mRecordItems[1] != null) {
                getView(childAt2, "dcloud_record_line_1").setVisibility(z3 ? 0 : 8);
                getView(childAt2, "dcloud_record_view_2").setVisibility(z3 ? 0 : 8);
                getTextView(childAt2, "dcloud_record_view_2").setText(this.mRecordData.mRecordItems[1].mContent);
            } else {
                getView(childAt2, "dcloud_record_line_1").setVisibility(8);
                getView(childAt2, "dcloud_record_view_2").setVisibility(8);
            }
            z2 = z;
        }
        if (z3 && z2) {
            display();
        } else {
            conceal();
        }
    }

    public static java.lang.String getAssisBundleData(android.content.Context context, java.lang.String str) {
        return io.dcloud.common.adapter.util.SP.getBundleData(context, "assis_input", str, true);
    }

    public static java.lang.String getRecordDatas(android.content.Context context, java.lang.String str, java.lang.String str2) {
        return getRecordDatas0(context, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.lang.String getRecordDatas(android.content.Context context, java.lang.String str, int i) {
        if (i == -1) {
            return null;
        }
        return io.dcloud.common.util.Base64.decodeString(getAssisBundleData(context, "_input_text" + i), true, 5);
    }

    public static void setRcordDatas(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        setRcordDatas0(context, str, str2, str3);
    }
}
