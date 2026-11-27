package com.taobao.weex.common;

/* JADX INFO: loaded from: classes.dex */
public enum WXErrorCode {
    WX_ERR_LOAD_SO("-2001", "load so error", com.taobao.weex.common.WXErrorCode.ErrorType.NATIVE_ERROR, com.taobao.weex.common.WXErrorCode.ErrorGroup.NATIVE),
    WX_ERR_LOAD_JSLIB("-2002", "unzip JSLib error!", com.taobao.weex.common.WXErrorCode.ErrorType.NATIVE_ERROR, com.taobao.weex.common.WXErrorCode.ErrorGroup.NATIVE),
    WX_ERR_BAD_SO("-2003", "so size error, to reload apk so", com.taobao.weex.common.WXErrorCode.ErrorType.NATIVE_ERROR, com.taobao.weex.common.WXErrorCode.ErrorGroup.NATIVE),
    WX_ERR_COPY_FROM_APK("-2007", "system load so error，copy from APK also error!", com.taobao.weex.common.WXErrorCode.ErrorType.NATIVE_ERROR, com.taobao.weex.common.WXErrorCode.ErrorGroup.NATIVE),
    WX_ERR_JSFUNC_PARAM("-2009", "JS params error!", com.taobao.weex.common.WXErrorCode.ErrorType.NATIVE_ERROR, com.taobao.weex.common.WXErrorCode.ErrorGroup.NATIVE),
    WX_ERR_JSON_OBJECT("-2008", "transform JSON->OBJ  error!", com.taobao.weex.common.WXErrorCode.ErrorType.NATIVE_ERROR, com.taobao.weex.common.WXErrorCode.ErrorGroup.NATIVE),
    WX_ERR_INVOKE_NATIVE("-2012", "Native-> Call ->JS  error!", com.taobao.weex.common.WXErrorCode.ErrorType.NATIVE_ERROR, com.taobao.weex.common.WXErrorCode.ErrorGroup.NATIVE),
    WX_ERR_JS_EXECUTE("-2013", "JavaScript execute error!", com.taobao.weex.common.WXErrorCode.ErrorType.JS_ERROR, com.taobao.weex.common.WXErrorCode.ErrorGroup.JS),
    WX_SUCCESS(com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT, "successful", com.taobao.weex.common.WXErrorCode.ErrorType.NATIVE_ERROR, com.taobao.weex.common.WXErrorCode.ErrorGroup.NATIVE),
    WX_ERR_DOM_CREATEBODY("-2100", "createBody error", com.taobao.weex.common.WXErrorCode.ErrorType.NATIVE_ERROR, com.taobao.weex.common.WXErrorCode.ErrorGroup.NATIVE),
    WX_ERR_DOM_UPDATEATTRS("-2101", "updateAttrs error", com.taobao.weex.common.WXErrorCode.ErrorType.NATIVE_ERROR, com.taobao.weex.common.WXErrorCode.ErrorGroup.NATIVE),
    WX_ERR_DOM_UPDATESTYLE("-2102", "updateStyle error", com.taobao.weex.common.WXErrorCode.ErrorType.NATIVE_ERROR, com.taobao.weex.common.WXErrorCode.ErrorGroup.NATIVE),
    WX_ERR_DOM_ADDELEMENT("-2103", "addElement error", com.taobao.weex.common.WXErrorCode.ErrorType.NATIVE_ERROR, com.taobao.weex.common.WXErrorCode.ErrorGroup.NATIVE),
    WX_ERR_DOM_REMOVEELEMENT("-2104", "removeElement error", com.taobao.weex.common.WXErrorCode.ErrorType.NATIVE_ERROR, com.taobao.weex.common.WXErrorCode.ErrorGroup.NATIVE),
    WX_ERR_DOM_MOVEELEMENT("-2105", "moveElement error", com.taobao.weex.common.WXErrorCode.ErrorType.NATIVE_ERROR, com.taobao.weex.common.WXErrorCode.ErrorGroup.NATIVE),
    WX_ERR_DOM_ADDEVENT("-2106", "addEvent error", com.taobao.weex.common.WXErrorCode.ErrorType.NATIVE_ERROR, com.taobao.weex.common.WXErrorCode.ErrorGroup.NATIVE),
    WX_ERR_DOM_REMOVEEVENT("-2107", "removeEvent error", com.taobao.weex.common.WXErrorCode.ErrorType.NATIVE_ERROR, com.taobao.weex.common.WXErrorCode.ErrorGroup.NATIVE),
    WX_ERROR_DOM_CREATEFINISH("-2108", "createFinish error", com.taobao.weex.common.WXErrorCode.ErrorType.NATIVE_ERROR, com.taobao.weex.common.WXErrorCode.ErrorGroup.NATIVE),
    WX_ERROR_DOM_REFRESHFINISH("-2109", "refreshFinish error", com.taobao.weex.common.WXErrorCode.ErrorType.NATIVE_ERROR, com.taobao.weex.common.WXErrorCode.ErrorGroup.NATIVE),
    WX_ERR_DOM_SCROLLTO("-2110", com.taobao.weex.ui.module.WXDomModule.SCROLL_TO_ELEMENT, com.taobao.weex.common.WXErrorCode.ErrorType.NATIVE_ERROR, com.taobao.weex.common.WXErrorCode.ErrorGroup.NATIVE),
    WX_ERR_RELOAD_PAGE("-2111", "reloadPage", com.taobao.weex.common.WXErrorCode.ErrorType.NATIVE_ERROR, com.taobao.weex.common.WXErrorCode.ErrorGroup.NATIVE),
    WX_ERR_RELOAD_PAGE_EXCEED_LIMIT("-2114", "RELOAD_PAGE_EXCEED_LIMIT", com.taobao.weex.common.WXErrorCode.ErrorType.NATIVE_ERROR, com.taobao.weex.common.WXErrorCode.ErrorGroup.NATIVE),
    WX_ERROR_WHITE_SCREEN("-2116", "WHITE_SCREEN", com.taobao.weex.common.WXErrorCode.ErrorType.RENDER_ERROR, com.taobao.weex.common.WXErrorCode.ErrorGroup.JS),
    WHITE_SCREEN_RESPONSE_TIMEOUT("-2117", "WHITE_SCREEN_RESPONSE_TIMEOUT", com.taobao.weex.common.WXErrorCode.ErrorType.RENDER_ERROR, com.taobao.weex.common.WXErrorCode.ErrorGroup.JS),
    WX_ERR_JSC_CRASH("-2112", "weexjscCrash", com.taobao.weex.common.WXErrorCode.ErrorType.NATIVE_ERROR, com.taobao.weex.common.WXErrorCode.ErrorGroup.NATIVE),
    WX_ERR_FIRST_DOM_ACTION_EXCEPTION("-2113", "dom action is invalid ", com.taobao.weex.common.WXErrorCode.ErrorType.NATIVE_ERROR, com.taobao.weex.common.WXErrorCode.ErrorGroup.NATIVE),
    WX_ERR_JSDOWNLOAD_START("-2201", "js bundle download start", com.taobao.weex.common.WXErrorCode.ErrorType.NATIVE_ERROR, com.taobao.weex.common.WXErrorCode.ErrorGroup.NATIVE),
    WX_ERR_JSBUNDLE_DOWNLOAD("-2299", "js bundle download err", com.taobao.weex.common.WXErrorCode.ErrorType.NATIVE_ERROR, com.taobao.weex.common.WXErrorCode.ErrorGroup.NATIVE),
    WX_ERR_JSBUNDLE_EMPTY("-2203", "js bundle empty", com.taobao.weex.common.WXErrorCode.ErrorType.NATIVE_ERROR, com.taobao.weex.common.WXErrorCode.ErrorGroup.NATIVE),
    WX_ERR_JSDOWNLOAD_END("-2299", "js bundle download end", com.taobao.weex.common.WXErrorCode.ErrorType.NATIVE_ERROR, com.taobao.weex.common.WXErrorCode.ErrorGroup.NATIVE),
    WX_JS_FRAMEWORK_INIT_SUCCESS("-1000", "js framework success", com.taobao.weex.common.WXErrorCode.ErrorType.NATIVE_ERROR, com.taobao.weex.common.WXErrorCode.ErrorGroup.NATIVE),
    WX_JS_FRAMEWORK_REINIT_SUCCESS("-1001", "js framework reinit success", com.taobao.weex.common.WXErrorCode.ErrorType.NATIVE_ERROR, com.taobao.weex.common.WXErrorCode.ErrorGroup.NATIVE),
    WX_ERR_JS_FRAMEWORK("-1002", "js framework error", com.taobao.weex.common.WXErrorCode.ErrorType.NATIVE_ERROR, com.taobao.weex.common.WXErrorCode.ErrorGroup.NATIVE),
    WX_ERR_JS_REINIT_FRAMEWORK("-1003", "js reinit framework error", com.taobao.weex.common.WXErrorCode.ErrorType.NATIVE_ERROR, com.taobao.weex.common.WXErrorCode.ErrorGroup.NATIVE),
    WX_ERR_SINGLE_PROCESS_DLOPEN_FILE_NOT_EXIST("-1004", "so file does not exist", com.taobao.weex.common.WXErrorCode.ErrorType.NATIVE_ERROR, com.taobao.weex.common.WXErrorCode.ErrorGroup.NATIVE),
    WX_ERR_SINGLE_PROCESS_DLOPEN_FLAIED("-1005", "dlopen so file failed", com.taobao.weex.common.WXErrorCode.ErrorType.NATIVE_ERROR, com.taobao.weex.common.WXErrorCode.ErrorGroup.NATIVE),
    WX_ERR_SINGLE_PROCESS_DLSYM_FAILED("-1006", "find function from so file failed", com.taobao.weex.common.WXErrorCode.ErrorType.NATIVE_ERROR, com.taobao.weex.common.WXErrorCode.ErrorGroup.NATIVE),
    WX_ERR_SINGLE_PROCESS_JS_FRAMEWORK("-1007", "js framework  init singleProcess failed", com.taobao.weex.common.WXErrorCode.ErrorType.NATIVE_ERROR, com.taobao.weex.common.WXErrorCode.ErrorGroup.NATIVE),
    WX_JS_FRAMEWORK_INIT_MULPROCESS_FAILED("-1008", "js framework init multiProcess failed", com.taobao.weex.common.WXErrorCode.ErrorType.NATIVE_ERROR, com.taobao.weex.common.WXErrorCode.ErrorGroup.NATIVE),
    WX_JS_FRAMEWORK_REINIT_MULPROCESS_FAILED("-1009", "js framework reinit multiProcess failed", com.taobao.weex.common.WXErrorCode.ErrorType.NATIVE_ERROR, com.taobao.weex.common.WXErrorCode.ErrorGroup.NATIVE),
    WX_JS_FRAMEWORK_INIT_FAILED("-1010", "js framework init failed", com.taobao.weex.common.WXErrorCode.ErrorType.NATIVE_ERROR, com.taobao.weex.common.WXErrorCode.ErrorGroup.NATIVE),
    WX_JS_FRAMEWORK_INIT_SINGLE_PROCESS_SUCCESS("-1011", "js framework init success in single process", com.taobao.weex.common.WXErrorCode.ErrorType.NATIVE_ERROR, com.taobao.weex.common.WXErrorCode.ErrorGroup.NATIVE),
    WX_JS_FRAMEWORK_INIT_FAILED_PARAMS_NULL("-1012", "js framework init failed due to params null", com.taobao.weex.common.WXErrorCode.ErrorType.NATIVE_ERROR, com.taobao.weex.common.WXErrorCode.ErrorGroup.NATIVE),
    WX_JS_FRAMEWORK_INIT_FAILED_FIND_ICU_TIMEOUT("-1013", "find icu failed", com.taobao.weex.common.WXErrorCode.ErrorType.NATIVE_ERROR, com.taobao.weex.common.WXErrorCode.ErrorGroup.NATIVE),
    WX_KEY_EXCEPTION_SDK_INIT("-9000", "[WX_KEY_EXCEPTION_SDK_INIT]", com.taobao.weex.common.WXErrorCode.ErrorType.NATIVE_ERROR, com.taobao.weex.common.WXErrorCode.ErrorGroup.NATIVE),
    WX_KEY_EXCEPTION_SDK_INIT_CPU_NOT_SUPPORT("-9001", "[WX_KEY_EXCEPTION_SDK_INIT_CPU_NOT_SUPPORT] for android cpu is x86", com.taobao.weex.common.WXErrorCode.ErrorType.NATIVE_ERROR, com.taobao.weex.common.WXErrorCode.ErrorGroup.NATIVE),
    WX_KEY_EXCEPTION_SDK_INIT_TABLE_NOT_SUPPORT("-9002", "[WX_KEY_EXCEPTION_SDK_INIT_TABLE_NOT_SUPPORT] for device isTabletDevice", com.taobao.weex.common.WXErrorCode.ErrorType.NATIVE_ERROR, com.taobao.weex.common.WXErrorCode.ErrorGroup.NATIVE),
    WX_KEY_EXCEPTION_SDK_INIT_JSFM_INIT_FAILED("-9003", "[WX_KEY_EXCEPTION_SDK_INIT_JSFM_INIT_FAILED] for jsfm init failed|detail error is:", com.taobao.weex.common.WXErrorCode.ErrorType.NATIVE_ERROR, com.taobao.weex.common.WXErrorCode.ErrorGroup.NATIVE),
    WX_KEY_EXCEPTION_INVOKE_BRIDGE("-9100", "[WX_KEY_EXCEPTION_INVOKE_BRIDGE]", com.taobao.weex.common.WXErrorCode.ErrorType.NATIVE_ERROR, com.taobao.weex.common.WXErrorCode.ErrorGroup.NATIVE),
    WX_KEY_EXCEPTION_INVOKE_REGISTER_CONTENT_FAILED("-9101", "[WX_KEY_EXCEPTION_INVOKE_REGISTER_CONTENT_FAILED] details", com.taobao.weex.common.WXErrorCode.ErrorType.NATIVE_ERROR, com.taobao.weex.common.WXErrorCode.ErrorGroup.NATIVE),
    WX_KEY_EXCEPTION_INVOKE_JSSERVICE_EXECUTE("-9102", "[WX_KEY_EXCEPTION_INVOKE_JSSERVICE_EXECUTE] details", com.taobao.weex.common.WXErrorCode.ErrorType.NATIVE_ERROR, com.taobao.weex.common.WXErrorCode.ErrorGroup.NATIVE),
    WX_KEY_EXCEPTION_INVOKE_REGISTER_MODULES("-9103", "[WX_KEY_EXCEPTION_INVOKE_REGISTER_MODULES] details", com.taobao.weex.common.WXErrorCode.ErrorType.NATIVE_ERROR, com.taobao.weex.common.WXErrorCode.ErrorGroup.NATIVE),
    WX_KEY_EXCEPTION_INVOKE_REGISTER_COMPONENT("-9104", "[WX_KEY_EXCEPTION_INVOKE_REGISTER_COMPONENT] details", com.taobao.weex.common.WXErrorCode.ErrorType.NATIVE_ERROR, com.taobao.weex.common.WXErrorCode.ErrorGroup.NATIVE),
    WX_KEY_EXCEPTION_JS_DOWNLOAD("-9200", "[WX_KEY_EXCEPTION_JS_DOWNLOAD]|", com.taobao.weex.common.WXErrorCode.ErrorType.DOWN_LOAD_ERROR, com.taobao.weex.common.WXErrorCode.ErrorGroup.NATIVE),
    WX_KEY_EXCEPTION_JS_DOWNLOAD_FAILED("-9201", "[WX_KEY_EXCEPTION_JS_DOWNLOAD_FAILED] | details", com.taobao.weex.common.WXErrorCode.ErrorType.DOWN_LOAD_ERROR, com.taobao.weex.common.WXErrorCode.ErrorGroup.NATIVE),
    WX_KEY_EXCEPTION_WXBRIDGE("-9400", "[js excute runtime error] detail js stack -> ", com.taobao.weex.common.WXErrorCode.ErrorType.JS_ERROR, com.taobao.weex.common.WXErrorCode.ErrorGroup.JS),
    WX_KEY_EXCEPTION_WXBRIDGE_EXCEPTION("-9401", "[js excute runtime error] detail js stack -> ", com.taobao.weex.common.WXErrorCode.ErrorType.JS_ERROR, com.taobao.weex.common.WXErrorCode.ErrorGroup.JS),
    WX_RENDER_ERR_JS_CREATE_INSTANCE("-9600", "white screen cause create instance failed,check js stack ->", com.taobao.weex.common.WXErrorCode.ErrorType.RENDER_ERROR, com.taobao.weex.common.WXErrorCode.ErrorGroup.JS),
    WX_RENDER_ERR_JS_CREATE_INSTANCE_CONTEXT("-9700", "white screen cause create instanceContext failed,check js stack ->", com.taobao.weex.common.WXErrorCode.ErrorType.RENDER_ERROR, com.taobao.weex.common.WXErrorCode.ErrorGroup.JS),
    WX_RENDER_ERR_LAYER_OVERFLOW("-9602", "WX_RENDER_ERR_LAYER_OVERFLOW", com.taobao.weex.common.WXErrorCode.ErrorType.NATIVE_ERROR, com.taobao.weex.common.WXErrorCode.ErrorGroup.NATIVE),
    WX_RENDER_ERR_NULL_KEY("-9603", "WX_RENDER_ERR_NULL_KEY", com.taobao.weex.common.WXErrorCode.ErrorType.NATIVE_ERROR, com.taobao.weex.common.WXErrorCode.ErrorGroup.NATIVE),
    WX_RENDER_ERR_NATIVE_RUNTIME("-9604", "WX_RENDER_ERR for js error", com.taobao.weex.common.WXErrorCode.ErrorType.RENDER_ERROR, com.taobao.weex.common.WXErrorCode.ErrorGroup.NATIVE),
    WX_RENDER_ERR_COMPONENT_NOT_REGISTER("-9605", "WX_RENDER_ERR_COMPONENT_NOT_REGISTER", com.taobao.weex.common.WXErrorCode.ErrorType.NATIVE_ERROR, com.taobao.weex.common.WXErrorCode.ErrorGroup.NATIVE),
    WX_RENDER_ERR_COMPONENT_ATTR_KEY("-9606", "The key passed to Component.updateAttr() is not string", com.taobao.weex.common.WXErrorCode.ErrorType.NATIVE_ERROR, com.taobao.weex.common.WXErrorCode.ErrorGroup.JS),
    WX_RENDER_ERR_BRIDGE_ARG_NULL("-9610", "WX_RENDER_ERR_BRIDGE_ARG_NULL", com.taobao.weex.common.WXErrorCode.ErrorType.NATIVE_ERROR, com.taobao.weex.common.WXErrorCode.ErrorGroup.NATIVE),
    WX_RENDER_ERR_CONTAINER_TYPE("-9611", "WX_RENDER_ERR_CONTAINER_TYPE", com.taobao.weex.common.WXErrorCode.ErrorType.JS_ERROR, com.taobao.weex.common.WXErrorCode.ErrorGroup.JS),
    WX_RENDER_ERR_TRANSITION("-9616", "WX_RENDER_ERR_TRANSITION", com.taobao.weex.common.WXErrorCode.ErrorType.JS_ERROR, com.taobao.weex.common.WXErrorCode.ErrorGroup.JS),
    WX_RENDER_ERR_INSTANCE_ID_NULL("-9618", "WX_RENDER_ERR_INSTANCE_ID_NULL", com.taobao.weex.common.WXErrorCode.ErrorType.NATIVE_ERROR, com.taobao.weex.common.WXErrorCode.ErrorGroup.NATIVE),
    WX_RENDER_ERR_LIST_INVALID_COLUMN_COUNT("-9619", "WX_RENDER_ERR_LIST_INVALID_COLUMNJ_CONUNT", com.taobao.weex.common.WXErrorCode.ErrorType.JS_ERROR, com.taobao.weex.common.WXErrorCode.ErrorGroup.JS),
    WX_RENDER_ERR_TEXTURE_SETBACKGROUND("-9620", "WX_RENDER_ERR_TEXTURE_SETBACKGROUND", com.taobao.weex.common.WXErrorCode.ErrorType.NATIVE_ERROR, com.taobao.weex.common.WXErrorCode.ErrorGroup.NATIVE),
    WX_RENDER_WAR_GPU_LIMIT_LAYOUT("-9621", "WX_RENDER_WAR_GPU_LIMIT_LAYOUT", com.taobao.weex.common.WXErrorCode.ErrorType.JS_ERROR, com.taobao.weex.common.WXErrorCode.ErrorGroup.JS),
    WX_KEY_EXCEPTION_HERON("Heron_-9900", "Error of Heron engine: ", com.taobao.weex.common.WXErrorCode.ErrorType.NATIVE_ERROR, com.taobao.weex.common.WXErrorCode.ErrorGroup.NATIVE),
    WX_KEY_EXCEPTION_HERON_RENDER("Heron_-9901", "Render error of Heron engine: ", com.taobao.weex.common.WXErrorCode.ErrorType.RENDER_ERROR, com.taobao.weex.common.WXErrorCode.ErrorGroup.NATIVE),
    WX_KEY_EXCEPTION_NO_BUNDLE_TYPE("-9801", "Fatal Error : No bundle type in js bundle head, cause white screen or memory leak!!", com.taobao.weex.common.WXErrorCode.ErrorType.JS_ERROR, com.taobao.weex.common.WXErrorCode.ErrorGroup.JS),
    WX_KEY_EXCEPTION_VALIDAPPKEY("-11001", "", com.taobao.weex.common.WXErrorCode.ErrorType.NATIVE_ERROR, com.taobao.weex.common.WXErrorCode.ErrorGroup.NATIVE),
    WX_DEGRAD_ERR("-1000", "degradeToH5|Weex DegradPassivity ->", com.taobao.weex.common.WXErrorCode.ErrorType.DEGRAD_ERROR, com.taobao.weex.common.WXErrorCode.ErrorGroup.JS),
    WX_DEGRAD_ERR_INSTANCE_CREATE_FAILED("-1001", "degradeToH5|createInstance fail|wx_create_instance_error", com.taobao.weex.common.WXErrorCode.ErrorType.DEGRAD_ERROR, com.taobao.weex.common.WXErrorCode.ErrorGroup.NATIVE),
    WX_DEGRAD_ERR_NETWORK_BUNDLE_DOWNLOAD_FAILED("-1002", "|wx_network_error|js bundle download failed", com.taobao.weex.common.WXErrorCode.ErrorType.DOWN_LOAD_ERROR, com.taobao.weex.common.WXErrorCode.ErrorGroup.NATIVE),
    WX_DEGRAD_ERR_NETWORK_CHECK_CONTENT_LENGTH_FAILED("-1003", "degradeToH5|wx_network_error|js bundle content-length check failed", com.taobao.weex.common.WXErrorCode.ErrorType.DEGRAD_ERROR, com.taobao.weex.common.WXErrorCode.ErrorGroup.NATIVE),
    WX_DEGRAD_ERR_BUNDLE_CONTENTTYPE_ERROR("-1004", "degradeToH5|wx_user_intercept_error |Content-Type is not application/javascript, Weex render template must be javascript, please check your request!", com.taobao.weex.common.WXErrorCode.ErrorType.DEGRAD_ERROR, com.taobao.weex.common.WXErrorCode.ErrorGroup.NATIVE),
    WX_DEGRAD_ERR_OTHER_CAUSE_DEGRADTOH5("-1005", "degradeToH5|for other reason|", com.taobao.weex.common.WXErrorCode.ErrorType.DEGRAD_ERROR, com.taobao.weex.common.WXErrorCode.ErrorGroup.NATIVE),
    WX_DEGRAD_ERR_INSTANCE_CREATE_FAILED_JS("-1006", "degradeToH5|createInstance fail|wx_create_instance_error", com.taobao.weex.common.WXErrorCode.ErrorType.DEGRAD_ERROR, com.taobao.weex.common.WXErrorCode.ErrorGroup.JS),
    WX_DEGRAD_EAGLE_RENDER_ERROR("Eagle_-1007", "degradeToH5|eagleRenderErr", com.taobao.weex.common.WXErrorCode.ErrorType.DEGRAD_ERROR, com.taobao.weex.common.WXErrorCode.ErrorGroup.NATIVE),
    WX_ERR_HASH_MAP_TMP("-10010", "WX_ERR_HASH_MAP_TMP", com.taobao.weex.common.WXErrorCode.ErrorType.NATIVE_ERROR, com.taobao.weex.common.WXErrorCode.ErrorGroup.NATIVE),
    WX_ERROR_MOVE_RENDER_OBJECT_OUT_OF_BOUNDS("-2120", "Index out of bounds when move element", com.taobao.weex.common.WXErrorCode.ErrorType.NATIVE_ERROR, com.taobao.weex.common.WXErrorCode.ErrorGroup.JS),
    WX_ERR_TEST("test", "test", com.taobao.weex.common.WXErrorCode.ErrorType.NATIVE_ERROR, com.taobao.weex.common.WXErrorCode.ErrorGroup.NATIVE);

    private java.lang.String appendMsg = "";
    private java.lang.String args;
    private java.lang.String errorCode;
    private java.lang.String errorMsg;
    private com.taobao.weex.common.WXErrorCode.ErrorGroup mErrorGroup;
    private com.taobao.weex.common.WXErrorCode.ErrorType mErrorType;

    public enum ErrorGroup {
        JS,
        NATIVE
    }

    public enum ErrorType {
        JS_ERROR,
        NATIVE_ERROR,
        RENDER_ERROR,
        DEGRAD_ERROR,
        DOWN_LOAD_ERROR
    }

    WXErrorCode(java.lang.String str, java.lang.String str2, com.taobao.weex.common.WXErrorCode.ErrorType errorType, com.taobao.weex.common.WXErrorCode.ErrorGroup errorGroup) {
        this.errorCode = str;
        this.errorMsg = str2;
        this.mErrorType = errorType;
        this.mErrorGroup = errorGroup;
    }

    public void appendErrMsg(java.lang.String str) {
        this.appendMsg = str;
    }

    public java.lang.String getErrorCode() {
        return this.errorCode;
    }

    public java.lang.String getErrorMsg() {
        return this.errorMsg + this.appendMsg;
    }

    public com.taobao.weex.common.WXErrorCode.ErrorType getErrorType() {
        return this.mErrorType;
    }

    public com.taobao.weex.common.WXErrorCode.ErrorGroup getErrorGroup() {
        return this.mErrorGroup;
    }

    public java.lang.String getArgs() {
        return this.args;
    }

    public void setArgs(java.lang.String str) {
        this.args = str;
    }
}
