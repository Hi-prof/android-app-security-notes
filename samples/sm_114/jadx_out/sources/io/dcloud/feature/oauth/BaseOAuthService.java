package io.dcloud.feature.oauth;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseOAuthService extends io.dcloud.common.DHInterface.BaseFeature.BaseModule implements io.dcloud.common.DHInterface.IReflectAble {
    protected static final java.lang.String KEY_ACCESS_TOKEN = "access_token";
    protected static final java.lang.String KEY_APPID = "appid";
    protected static final java.lang.String KEY_APPKEY = "appkey";
    protected static final java.lang.String KEY_APSECRET = "appsecret";
    protected static final java.lang.String KEY_AUTHRESULT = "authResult";
    protected static final java.lang.String KEY_EMAIL = "email";
    protected static final java.lang.String KEY_EXPIRES_IN = "expires_in";
    protected static final java.lang.String KEY_HEADIMGURL = "headimgurl";
    protected static final java.lang.String KEY_NICKNAME = "nickname";
    protected static final java.lang.String KEY_OPENID = "openid";
    protected static final java.lang.String KEY_REDIRECT_URI = "redirect_uri";
    protected static final java.lang.String KEY_REFRESH_TOKEN = "refresh_token";
    protected static final java.lang.String KEY_SCOPE = "scope";
    protected static final java.lang.String KEY_STATE = "state";
    protected static final java.lang.String KEY_UNIONID = "unionid";
    protected static final java.lang.String KEY_UNIVERIFYINFO = "univerifyInfo";
    protected static final java.lang.String KEY_USERINFO = "userInfo";
    protected static final java.lang.String NULL = "null";
    protected org.json.JSONObject authResult;
    protected org.json.JSONObject univerifyInfo;
    protected org.json.JSONObject userInfo;
    protected io.dcloud.common.DHInterface.IWebview mLoginWebViewImpl = null;
    protected java.lang.String mLoginCallbackId = null;
    protected org.json.JSONObject mLoginOptions = null;
    protected boolean nativeClient = false;
    protected io.dcloud.common.DHInterface.IWebview mAuthWebview = null;
    protected java.lang.String mAuthCallbackId = null;
    protected org.json.JSONObject mAuthOptions = null;
    protected io.dcloud.common.DHInterface.IWebview mLogoutWebViewImpl = null;
    protected java.lang.String mLogoutCallbackId = null;
    protected io.dcloud.common.DHInterface.IWebview mPreLoginWebViewImpl = null;
    protected java.lang.String mPreLoginCallbackId = null;
    protected io.dcloud.common.DHInterface.IWebview mOtherClickWebViewImpl = null;
    protected java.lang.String mOtherClickCallbackId = null;
    protected io.dcloud.common.DHInterface.IWebview mGetUserInfoWebViewImpl = null;
    protected java.lang.String mGetUserInfoCallbackId = null;
    protected io.dcloud.common.DHInterface.IWebview mAddPhoneNumberWebViewImpl = null;
    protected java.lang.String mAddPhoneNumberCallbackId = null;

    public void addPhoneNumber(io.dcloud.common.DHInterface.IWebview iWebview, org.json.JSONArray jSONArray) {
        this.mAddPhoneNumberWebViewImpl = iWebview;
        try {
            this.mAddPhoneNumberCallbackId = jSONArray.getString(1);
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
    }

    public void authorize(io.dcloud.common.DHInterface.IWebview iWebview, org.json.JSONArray jSONArray) {
        initMetaData();
        this.mAuthWebview = iWebview;
        this.mAuthCallbackId = jSONArray.optString(1, "");
        org.json.JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(2);
        this.mAuthOptions = jSONObjectOptJSONObject;
        initAuthOptions(jSONObjectOptJSONObject);
    }

    protected java.lang.String checkToken(java.lang.String str) {
        return new java.lang.String(io.dcloud.common.util.NetTool.httpGet(str));
    }

    public void closeAuthView(io.dcloud.common.DHInterface.IWebview iWebview, org.json.JSONArray jSONArray) {
    }

    public java.lang.String decrypt(java.lang.String str) throws java.lang.Exception {
        return io.dcloud.common.util.Base64.decodeString(str, true, 5);
    }

    public java.lang.String encrypt(java.lang.String str) throws java.lang.Exception {
        return io.dcloud.common.util.Base64.encodeString(str, true, 5);
    }

    public boolean getCheckBoxState() {
        return false;
    }

    public org.json.JSONObject getErrorJsonbject(int i, java.lang.String str) {
        try {
            return new org.json.JSONObject(io.dcloud.common.constant.DOMException.toJSON(i, str));
        } catch (org.json.JSONException e) {
            e.printStackTrace();
            return new org.json.JSONObject();
        }
    }

    protected java.lang.String getToken(java.lang.String str) {
        byte[] bArrHttpGet = io.dcloud.common.util.NetTool.httpGet(str);
        if (bArrHttpGet != null) {
            return new java.lang.String(bArrHttpGet);
        }
        return null;
    }

    public void getUserInfo(io.dcloud.common.DHInterface.IWebview iWebview, org.json.JSONArray jSONArray) {
        this.mGetUserInfoWebViewImpl = iWebview;
        try {
            this.mGetUserInfoCallbackId = jSONArray.getString(1);
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
    }

    protected java.lang.String getValue(java.lang.String str) {
        try {
            java.lang.String strEncrypt = encrypt(str);
            java.lang.String bundleData = io.dcloud.common.adapter.util.SP.getBundleData(this.mApplicationContext, "oauth_" + this.id, strEncrypt);
            return bundleData == null ? "{}" : decrypt(bundleData);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return "{}";
        }
    }

    public boolean hasFullConfigData() {
        return false;
    }

    public boolean hasGeneralError(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str) {
        if (hasFullConfigData()) {
            return false;
        }
        io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview, str, io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.DOMException.JSON_ERROR_INFO, -7, io.dcloud.common.constant.DOMException.toString(io.dcloud.common.constant.DOMException.MSG_BUSINESS_PARAMETER_HAS_NOT)), io.dcloud.common.util.JSUtil.ERROR, true, false);
        return true;
    }

    public void initAuthOptions(org.json.JSONObject jSONObject) {
    }

    public void initMetaData() {
    }

    public void login(io.dcloud.common.DHInterface.IWebview iWebview, org.json.JSONArray jSONArray) {
        initMetaData();
        this.mLoginWebViewImpl = iWebview;
        try {
            this.mLoginCallbackId = jSONArray.getString(1);
            org.json.JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(2);
            this.mLoginOptions = jSONObjectOptJSONObject;
            initAuthOptions(jSONObjectOptJSONObject);
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
    }

    public void logout(io.dcloud.common.DHInterface.IWebview iWebview, org.json.JSONArray jSONArray) {
        this.mLogoutWebViewImpl = iWebview;
        try {
            this.mLogoutCallbackId = jSONArray.getString(1);
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
    }

    public org.json.JSONObject makeResultJSONObject() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put(KEY_AUTHRESULT, this.authResult);
            jSONObject.put(KEY_USERINFO, this.userInfo);
            jSONObject.put(KEY_UNIVERIFYINFO, this.univerifyInfo);
            return jSONObject;
        } catch (org.json.JSONException e) {
            e.printStackTrace();
            return jSONObject;
        }
    }

    public org.json.JSONObject makeResultJson() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put(KEY_AUTHRESULT, this.authResult);
            jSONObject.put(KEY_USERINFO, this.userInfo);
            jSONObject.put(KEY_UNIVERIFYINFO, this.univerifyInfo);
            return jSONObject;
        } catch (org.json.JSONException e) {
            e.printStackTrace();
            return jSONObject;
        }
    }

    protected void onAddPhoneNumberFinished(org.json.JSONObject jSONObject, boolean z) {
        io.dcloud.common.util.JSUtil.execCallback(this.mAddPhoneNumberWebViewImpl, this.mAddPhoneNumberCallbackId, jSONObject, z ? io.dcloud.common.util.JSUtil.OK : io.dcloud.common.util.JSUtil.ERROR, false);
    }

    protected void onGetUserInfoFinished(org.json.JSONObject jSONObject, boolean z) {
        io.dcloud.common.util.JSUtil.execCallback(this.mGetUserInfoWebViewImpl, this.mGetUserInfoCallbackId, jSONObject, z ? io.dcloud.common.util.JSUtil.OK : io.dcloud.common.util.JSUtil.ERROR, false);
    }

    protected void onLoginFinished(org.json.JSONObject jSONObject, boolean z) {
        io.dcloud.common.util.JSUtil.execCallback(this.mLoginWebViewImpl, this.mLoginCallbackId, jSONObject, z ? io.dcloud.common.util.JSUtil.OK : io.dcloud.common.util.JSUtil.ERROR, false);
        this.mLoginWebViewImpl = null;
        this.mLoginCallbackId = null;
    }

    protected void onLogoutFinished(org.json.JSONObject jSONObject, boolean z) {
        io.dcloud.common.util.JSUtil.execCallback(this.mLogoutWebViewImpl, this.mLogoutCallbackId, jSONObject, z ? io.dcloud.common.util.JSUtil.OK : io.dcloud.common.util.JSUtil.ERROR, false);
    }

    protected void onPreLoginFinished(org.json.JSONObject jSONObject, boolean z) {
        io.dcloud.common.util.JSUtil.execCallback(this.mPreLoginWebViewImpl, this.mPreLoginCallbackId, jSONObject, z ? io.dcloud.common.util.JSUtil.OK : io.dcloud.common.util.JSUtil.ERROR, false);
    }

    public void otherLoginButtonClick(io.dcloud.common.DHInterface.IWebview iWebview, org.json.JSONArray jSONArray) {
        this.mOtherClickWebViewImpl = iWebview;
        try {
            this.mOtherClickCallbackId = jSONArray.getString(1);
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
    }

    public void preLogin(io.dcloud.common.DHInterface.IWebview iWebview, org.json.JSONArray jSONArray) {
        initMetaData();
        this.mPreLoginWebViewImpl = iWebview;
        try {
            this.mPreLoginCallbackId = jSONArray.getString(1);
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
    }

    protected java.lang.String refreshToken(java.lang.String str) {
        byte[] bArrHttpGet = io.dcloud.common.util.NetTool.httpGet(str);
        if (bArrHttpGet != null) {
            return new java.lang.String(bArrHttpGet);
        }
        return null;
    }

    protected void removeToken() {
        io.dcloud.common.adapter.util.SP.clearBundle(this.mApplicationContext, "oauth_" + this.id);
    }

    protected void removeValue(java.lang.String str) {
        try {
            java.lang.String strEncrypt = encrypt(str);
            io.dcloud.common.adapter.util.SP.removeBundleData(this.mApplicationContext, "oauth_" + this.id, strEncrypt);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    protected void saveValue(java.lang.String str, java.lang.String str2) {
        try {
            java.lang.String strEncrypt = encrypt(str);
            java.lang.String strEncrypt2 = encrypt(str2);
            io.dcloud.common.adapter.util.SP.setBundleData(this.mApplicationContext, "oauth_" + this.id, strEncrypt, strEncrypt2);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Override // io.dcloud.common.DHInterface.BaseFeature.BaseModule
    public org.json.JSONObject toJSONObject() throws org.json.JSONException {
        java.lang.String str = this.id;
        java.lang.String str2 = this.description;
        java.lang.Boolean boolValueOf = java.lang.Boolean.valueOf(this.nativeClient);
        java.lang.Object obj = this.authResult;
        java.lang.Object obj2 = NULL;
        if (obj == null) {
            obj = NULL;
        }
        org.json.JSONObject jSONObject = this.userInfo;
        if (jSONObject != null) {
            obj2 = jSONObject;
        }
        return new org.json.JSONObject(io.dcloud.common.util.StringUtil.format("{id:'%s',description:'%s', nativeClient:%b, authResult:%s,userInfo:%s}", str, str2, boolValueOf, obj, obj2));
    }

    protected java.lang.String getUserInfo(java.lang.String str) {
        byte[] bArrHttpGet = io.dcloud.common.util.NetTool.httpGet(str);
        if (io.dcloud.common.util.PdrUtil.isEmpty(bArrHttpGet)) {
            return null;
        }
        return new java.lang.String(bArrHttpGet);
    }

    public org.json.JSONObject getErrorJsonbject(java.lang.String str, java.lang.String str2) {
        try {
            return new org.json.JSONObject(io.dcloud.common.constant.DOMException.toJSON(str, str2));
        } catch (org.json.JSONException e) {
            e.printStackTrace();
            return new org.json.JSONObject();
        }
    }

    public org.json.JSONObject getErrorJsonbject(int i, java.lang.String str, int i2) {
        try {
            return new org.json.JSONObject(io.dcloud.common.constant.DOMException.toJSON(i, i + ":" + str, i2));
        } catch (org.json.JSONException e) {
            e.printStackTrace();
            return new org.json.JSONObject();
        }
    }
}
