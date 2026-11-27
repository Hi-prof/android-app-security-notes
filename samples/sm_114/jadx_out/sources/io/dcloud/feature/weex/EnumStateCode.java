package io.dcloud.feature.weex;

/* JADX INFO: loaded from: classes2.dex */
public enum EnumStateCode {
    SUCCESS_NO_BODY(com.taobao.weex.ui.component.WXImage.SUCCEED, 0, ""),
    FAIL_BY_INVALID_PARAMETER(com.taobao.weex.common.Constants.Event.FAIL, -1, "invalid parameter."),
    FAIL_BY_NO_PERMISSION(com.taobao.weex.common.Constants.Event.FAIL, -2, "no permission."),
    FAIL_BY_NO_MESSAGE_LISTENER_RECEIVED(com.taobao.weex.common.Constants.Event.FAIL, -3, "no message listener received."),
    FAIL_BY_NO_INIT(com.taobao.weex.common.Constants.Event.FAIL, -4, "not initialized."),
    FAIL_BY_RELEASE_WGT_ERROR(com.taobao.weex.common.Constants.Event.FAIL, -5, "wgt release error."),
    FAIL_BY_UNKNOWN_ERROR(com.taobao.weex.common.Constants.Event.FAIL, com.dcloud.android.widget.dialog.DCloudAlertDialog.DARK_THEME, "unknown error."),
    FAIL_BY_NO_RESOURCE_EXIST(com.taobao.weex.common.Constants.Event.FAIL, -1001, "mp resource do not exist."),
    FAIL_BY_NO_WGT_EXIST(com.taobao.weex.common.Constants.Event.FAIL, tv.danmaku.ijk.media.player.IMediaPlayer.MEDIA_ERROR_IO, "wgt do not exist."),
    FAIL_BY_MP_IS_NOT_RUNNING(com.taobao.weex.common.Constants.Event.FAIL, -3001, "target mp is not running.");

    private int mCode;
    private java.lang.String mDesc;
    private java.lang.String mResult;

    public java.lang.String getResult() {
        return this.mResult;
    }

    public int getCode() {
        return this.mCode;
    }

    public java.lang.String getDesc() {
        return this.mDesc;
    }

    EnumStateCode(java.lang.String str, int i, java.lang.String str2) {
        this.mCode = i;
        this.mDesc = str2;
        this.mResult = str;
    }

    public static java.util.Map<java.lang.String, java.lang.Object> obtainMap(io.dcloud.feature.weex.EnumStateCode enumStateCode) {
        java.util.HashMap map = new java.util.HashMap();
        map.put("type", enumStateCode.mResult);
        map.put("code", java.lang.Integer.valueOf(enumStateCode.mCode));
        if (!android.text.TextUtils.isEmpty(enumStateCode.mDesc)) {
            map.put("message", enumStateCode.mDesc);
        }
        return map;
    }

    public static java.util.Map<java.lang.String, java.lang.Object> obtainMap(io.dcloud.feature.weex.EnumStateCode enumStateCode, java.lang.String str, java.lang.Object obj) {
        java.util.HashMap map = new java.util.HashMap();
        map.put("type", enumStateCode.mResult);
        map.put("code", java.lang.Integer.valueOf(enumStateCode.mCode));
        if (!android.text.TextUtils.isEmpty(str)) {
            map.put(str, obj);
        }
        return map;
    }
}
