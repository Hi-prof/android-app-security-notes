package io.dcloud.feature.oauth;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class OAuthFeatureImpl extends io.dcloud.common.DHInterface.StandardFeature {
    public void addPhoneNumber(io.dcloud.common.DHInterface.IWebview iWebview, org.json.JSONArray jSONArray) throws java.lang.Exception {
        io.dcloud.common.util.AppRuntime.checkPrivacyComplianceAndPrompt(iWebview.getContext(), "Oauth-addPhoneNumber");
        io.dcloud.feature.oauth.BaseOAuthService baseOAuthService = (io.dcloud.feature.oauth.BaseOAuthService) getBaseModuleById(jSONArray.getString(0));
        if (baseOAuthService != null) {
            baseOAuthService.addPhoneNumber(iWebview, jSONArray);
        } else {
            io.dcloud.common.util.JSUtil.execCallback(iWebview, jSONArray.getString(1), io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.DOMException.JSON_ERROR_INFO, 19, io.dcloud.common.constant.DOMException.MSG_OAUTH_LOGIN), io.dcloud.common.util.JSUtil.ERROR, false);
        }
    }

    public void authorize(io.dcloud.common.DHInterface.IWebview iWebview, org.json.JSONArray jSONArray) throws java.lang.Exception {
        io.dcloud.common.util.AppRuntime.checkPrivacyComplianceAndPrompt(iWebview.getContext(), "Oauth-authorize");
        io.dcloud.feature.oauth.BaseOAuthService baseOAuthService = (io.dcloud.feature.oauth.BaseOAuthService) getBaseModuleById(jSONArray.getString(0));
        if (baseOAuthService == null) {
            io.dcloud.common.util.JSUtil.execCallback(iWebview, jSONArray.getString(1), io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.DOMException.JSON_ERROR_INFO, 19, io.dcloud.common.constant.DOMException.MSG_OAUTH_LOGIN), io.dcloud.common.util.JSUtil.ERROR, false);
            return;
        }
        android.app.Application application = iWebview.getActivity().getApplication();
        if (application instanceof io.dcloud.application.DCloudApplication) {
            ((io.dcloud.application.DCloudApplication) application).stopB2FOnce();
        }
        baseOAuthService.authorize(iWebview, jSONArray);
    }

    public void closeAuthView(io.dcloud.common.DHInterface.IWebview iWebview, org.json.JSONArray jSONArray) throws java.lang.Exception {
        io.dcloud.common.util.AppRuntime.checkPrivacyComplianceAndPrompt(iWebview.getContext(), "Oauth-closeAuthView");
        io.dcloud.feature.oauth.BaseOAuthService baseOAuthService = (io.dcloud.feature.oauth.BaseOAuthService) getBaseModuleById(jSONArray.getString(0));
        if (baseOAuthService != null) {
            baseOAuthService.closeAuthView(iWebview, jSONArray);
        }
    }

    public boolean getCheckBoxState(io.dcloud.common.DHInterface.IWebview iWebview, org.json.JSONArray jSONArray) throws java.lang.Exception {
        io.dcloud.common.util.AppRuntime.checkPrivacyComplianceAndPrompt(iWebview.getContext(), "Oauth-getCheckBoxState");
        io.dcloud.feature.oauth.BaseOAuthService baseOAuthService = (io.dcloud.feature.oauth.BaseOAuthService) getBaseModuleById(jSONArray.getString(0));
        if (baseOAuthService != null) {
            return baseOAuthService.getCheckBoxState();
        }
        return false;
    }

    public void getServices(io.dcloud.common.DHInterface.IWebview iWebview, org.json.JSONArray jSONArray) throws java.lang.Exception {
        io.dcloud.common.util.AppRuntime.checkPrivacyComplianceAndPrompt(iWebview.getContext(), "Oauth-getServices");
        loadModules();
        io.dcloud.common.util.JSUtil.execCallback(iWebview, jSONArray.getString(0), toModuleJSONArray(), io.dcloud.common.util.JSUtil.OK, false);
    }

    public void getUserInfo(io.dcloud.common.DHInterface.IWebview iWebview, org.json.JSONArray jSONArray) throws java.lang.Exception {
        io.dcloud.common.util.AppRuntime.checkPrivacyComplianceAndPrompt(iWebview.getContext(), "Oauth-getUserInfo");
        io.dcloud.feature.oauth.BaseOAuthService baseOAuthService = (io.dcloud.feature.oauth.BaseOAuthService) getBaseModuleById(jSONArray.getString(0));
        if (baseOAuthService != null) {
            baseOAuthService.getUserInfo(iWebview, jSONArray);
        } else {
            io.dcloud.common.util.JSUtil.execCallback(iWebview, jSONArray.getString(1), io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.DOMException.JSON_ERROR_INFO, 21, io.dcloud.common.constant.DOMException.MSG_OAUTH_GET_USERINFO), io.dcloud.common.util.JSUtil.ERROR, false);
        }
    }

    public void login(io.dcloud.common.DHInterface.IWebview iWebview, org.json.JSONArray jSONArray) throws java.lang.Exception {
        io.dcloud.common.util.AppRuntime.checkPrivacyComplianceAndPrompt(iWebview.getContext(), "Oauth-login");
        io.dcloud.feature.oauth.BaseOAuthService baseOAuthService = (io.dcloud.feature.oauth.BaseOAuthService) getBaseModuleById(jSONArray.getString(0));
        if (baseOAuthService == null) {
            io.dcloud.common.util.JSUtil.execCallback(iWebview, jSONArray.getString(1), io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.DOMException.JSON_ERROR_INFO, 19, io.dcloud.common.constant.DOMException.MSG_OAUTH_LOGIN), io.dcloud.common.util.JSUtil.ERROR, false);
            return;
        }
        android.app.Application application = iWebview.getActivity().getApplication();
        if (application instanceof io.dcloud.application.DCloudApplication) {
            ((io.dcloud.application.DCloudApplication) application).stopB2FOnce();
        }
        baseOAuthService.login(iWebview, jSONArray);
    }

    public void logout(io.dcloud.common.DHInterface.IWebview iWebview, org.json.JSONArray jSONArray) throws java.lang.Exception {
        io.dcloud.common.util.AppRuntime.checkPrivacyComplianceAndPrompt(iWebview.getContext(), "Oauth-logout");
        io.dcloud.feature.oauth.BaseOAuthService baseOAuthService = (io.dcloud.feature.oauth.BaseOAuthService) getBaseModuleById(jSONArray.getString(0));
        if (baseOAuthService != null) {
            baseOAuthService.logout(iWebview, jSONArray);
        } else {
            io.dcloud.common.util.JSUtil.execCallback(iWebview, jSONArray.getString(1), io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.DOMException.JSON_ERROR_INFO, 20, io.dcloud.common.constant.DOMException.MSG_OAUTH_LOGOUT), io.dcloud.common.util.JSUtil.ERROR, false);
        }
    }

    public void otherLoginButtonClick(io.dcloud.common.DHInterface.IWebview iWebview, org.json.JSONArray jSONArray) throws java.lang.Exception {
        io.dcloud.common.util.AppRuntime.checkPrivacyComplianceAndPrompt(iWebview.getContext(), "Oauth-otherLoginButtonClick");
        io.dcloud.feature.oauth.BaseOAuthService baseOAuthService = (io.dcloud.feature.oauth.BaseOAuthService) getBaseModuleById(jSONArray.getString(0));
        if (baseOAuthService != null) {
            baseOAuthService.otherLoginButtonClick(iWebview, jSONArray);
        }
    }

    public void preLogin(io.dcloud.common.DHInterface.IWebview iWebview, org.json.JSONArray jSONArray) throws java.lang.Exception {
        io.dcloud.common.util.AppRuntime.checkPrivacyComplianceAndPrompt(iWebview.getContext(), "Oauth-preLogin");
        io.dcloud.feature.oauth.BaseOAuthService baseOAuthService = (io.dcloud.feature.oauth.BaseOAuthService) getBaseModuleById(jSONArray.getString(0));
        if (baseOAuthService != null) {
            baseOAuthService.preLogin(iWebview, jSONArray);
        } else {
            io.dcloud.common.util.JSUtil.execCallback(iWebview, jSONArray.getString(1), io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.DOMException.JSON_ERROR_INFO, -3, io.dcloud.common.constant.DOMException.MSG_OAUTH_LOGOUT), io.dcloud.common.util.JSUtil.ERROR, false);
        }
    }
}
