package io.dcloud.common.util;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class TitleNViewUtil {
    public static final java.lang.String TRANSPARENT_BUTTON_BACKGROUND_COLOR = "#7F333333";
    public static final java.lang.String TRANSPARENT_BUTTON_TEXT_COLOR = "#FFFFFF";

    public static boolean backButtonIsChanged(org.json.JSONObject jSONObject, org.json.JSONObject jSONObject2) {
        if (jSONObject != null || jSONObject2 == null) {
            if (jSONObject != null && jSONObject2 != null) {
                if (jSONObject2.has("titleColor")) {
                    return true;
                }
                if (jSONObject.has("autoBackButton") || jSONObject.has("backButton")) {
                    if (jSONObject.has("autoBackButton")) {
                        boolean zOptBoolean = jSONObject.optBoolean("autoBackButton");
                        if (jSONObject2.has("autoBackButton")) {
                            if (zOptBoolean != jSONObject2.optBoolean("autoBackButton")) {
                                return true;
                            }
                        } else if (jSONObject2.has("backButton") && ((zOptBoolean && (jSONObject2.optJSONObject("backButton") == null || com.taobao.weex.common.Constants.Name.UNDEFINED == jSONObject2.optString("backButton"))) || jSONObject2.optJSONObject("backButton") != null)) {
                            return true;
                        }
                    } else if (jSONObject.has("backButton")) {
                        boolean z = jSONObject.optJSONObject("backButton") != null;
                        if (jSONObject2.has("autoBackButton")) {
                            if (z != jSONObject2.optBoolean("autoBackButton")) {
                                return true;
                            }
                        } else if (jSONObject2.has("backButton") && ((z && (jSONObject2.optJSONObject("backButton") == null || com.taobao.weex.common.Constants.Name.UNDEFINED == jSONObject2.optString("backButton"))) || jSONObject2.optJSONObject("backButton") != null)) {
                            return true;
                        }
                    }
                } else {
                    if (jSONObject2.has("autoBackButton") && jSONObject2.optBoolean("autoBackButton")) {
                        return true;
                    }
                    if (jSONObject2.has("backButton") && jSONObject2.optJSONObject("backButton") != null) {
                        return true;
                    }
                }
            }
        } else {
            if (jSONObject2.has("autoBackButton")) {
                return true;
            }
            if ((jSONObject2.has("backButton") && (jSONObject2.optJSONObject("backButton") != null || com.taobao.weex.common.Constants.Name.UNDEFINED != jSONObject2.optString("backButton"))) || jSONObject2.has("titleColor")) {
                return true;
            }
        }
        return false;
    }

    public static boolean backgroundImageIsChanged(org.json.JSONObject jSONObject, org.json.JSONObject jSONObject2) {
        if (jSONObject2 != null && jSONObject2.has(com.taobao.weex.common.Constants.Name.BACKGROUND_IMAGE)) {
            if (jSONObject == null) {
                return jSONObject2.has(com.taobao.weex.common.Constants.Name.BACKGROUND_IMAGE);
            }
            java.lang.String strOptString = jSONObject.optString(com.taobao.weex.common.Constants.Name.BACKGROUND_IMAGE);
            java.lang.String strOptString2 = jSONObject2.optString(com.taobao.weex.common.Constants.Name.BACKGROUND_IMAGE);
            if (!jSONObject.has(com.taobao.weex.common.Constants.Name.BACKGROUND_IMAGE) && jSONObject2.has(com.taobao.weex.common.Constants.Name.BACKGROUND_IMAGE)) {
                return true;
            }
            if (jSONObject.has(com.taobao.weex.common.Constants.Name.BACKGROUND_IMAGE) && jSONObject2.has(com.taobao.weex.common.Constants.Name.BACKGROUND_IMAGE) && !strOptString.equals(strOptString2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean backgroundIsChanged(org.json.JSONObject jSONObject, org.json.JSONObject jSONObject2) {
        if (jSONObject2 != null && jSONObject2.has("backgroundColor")) {
            if (jSONObject == null) {
                if (!android.text.TextUtils.isEmpty(jSONObject2.optString("backgroundColor"))) {
                    return true;
                }
            } else if (jSONObject != null) {
                java.lang.String strOptString = jSONObject.optString("backgroundColor");
                java.lang.String strOptString2 = jSONObject2.optString("backgroundColor");
                if (android.text.TextUtils.isEmpty(strOptString) && !android.text.TextUtils.isEmpty(strOptString2)) {
                    return true;
                }
                if (!android.text.TextUtils.isEmpty(strOptString) && !android.text.TextUtils.isEmpty(strOptString2) && !strOptString.equals(strOptString2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int changeColorAlpha(int i, float f) {
        if (0.0f > f || f > 1.0f) {
            return -1;
        }
        return android.graphics.Color.argb((int) (f * 255.0f), android.graphics.Color.red(i), android.graphics.Color.green(i), android.graphics.Color.blue(i));
    }

    private static boolean checkKeyValueIsModify(java.lang.String str, org.json.JSONObject jSONObject, org.json.JSONObject jSONObject2) {
        if (!jSONObject2.has(str)) {
            return false;
        }
        if (jSONObject == null || !jSONObject.has(str)) {
            return true;
        }
        return !jSONObject.optString(str).equals(jSONObject2.optString(str));
    }

    public static java.lang.String color2Color(java.lang.String str, java.lang.String str2, float f) {
        try {
            if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2) || 0.0f > f || f > 1.0f) {
                return null;
            }
            if (!str.startsWith("#") || !str2.startsWith("#")) {
                if (!str.startsWith("rgba") || !str.contains(com.taobao.weex.el.parse.Operators.BRACKET_START_STR) || !str.contains(com.taobao.weex.el.parse.Operators.BRACKET_END_STR) || !str.contains(",") || !str2.startsWith("rgba") || !str2.contains(com.taobao.weex.el.parse.Operators.BRACKET_START_STR) || !str2.contains(com.taobao.weex.el.parse.Operators.BRACKET_END_STR) || !str2.contains(",")) {
                    return null;
                }
                java.lang.String strSubstring = str.substring(str.indexOf(com.taobao.weex.el.parse.Operators.BRACKET_START_STR) + 1, str.indexOf(com.taobao.weex.el.parse.Operators.BRACKET_END_STR));
                java.lang.String strSubstring2 = str2.substring(str2.indexOf(com.taobao.weex.el.parse.Operators.BRACKET_START_STR) + 1, str2.indexOf(com.taobao.weex.el.parse.Operators.BRACKET_END_STR));
                java.lang.String[] strArrStringSplit = io.dcloud.common.util.PdrUtil.stringSplit(strSubstring, ",");
                java.lang.String[] strArrStringSplit2 = io.dcloud.common.util.PdrUtil.stringSplit(strSubstring2, ",");
                if (strArrStringSplit == null || 4 != strArrStringSplit.length || strArrStringSplit2 == null || 4 != strArrStringSplit2.length) {
                    return null;
                }
                int iIntValue = java.lang.Integer.valueOf(strArrStringSplit[0]).intValue();
                int iIntValue2 = java.lang.Integer.valueOf(strArrStringSplit[1]).intValue();
                int iIntValue3 = java.lang.Integer.valueOf(strArrStringSplit[2]).intValue();
                int iIntValue4 = java.lang.Integer.valueOf(strArrStringSplit2[0]).intValue();
                int iIntValue5 = java.lang.Integer.valueOf(strArrStringSplit2[1]).intValue();
                int iIntValue6 = java.lang.Integer.valueOf(strArrStringSplit2[2]).intValue();
                java.lang.String str3 = strArrStringSplit[3];
                float f2 = iIntValue;
                if (iIntValue != iIntValue4) {
                    f2 = iIntValue > iIntValue4 ? f2 - ((iIntValue - iIntValue4) * f) : f2 + ((iIntValue - iIntValue4) * f);
                }
                float f3 = iIntValue2;
                if (iIntValue2 != iIntValue5) {
                    f3 = iIntValue2 > iIntValue5 ? f3 - ((iIntValue2 - iIntValue5) * f) : f3 + ((iIntValue5 - iIntValue2) * f);
                }
                float f4 = iIntValue3;
                if (iIntValue3 != iIntValue6) {
                    f4 = iIntValue3 > iIntValue6 ? f4 - ((iIntValue3 - iIntValue6) * f) : f4 + ((iIntValue6 - iIntValue3) * f);
                }
                return "rgba(" + ((int) f2) + "," + ((int) f3) + "," + ((int) f4) + "," + str3 + com.taobao.weex.el.parse.Operators.BRACKET_END_STR;
            }
            java.lang.String strSubstring3 = str.substring(1, str.length());
            java.lang.String strSubstring4 = str2.substring(1, str2.length());
            if (strSubstring3.length() == 3) {
                str = "#" + strSubstring3.charAt(0) + strSubstring3.charAt(0) + strSubstring3.charAt(1) + strSubstring3.charAt(1) + strSubstring3.charAt(2) + strSubstring3.charAt(2);
            }
            if (strSubstring4.length() == 3) {
                str2 = "#" + strSubstring4.charAt(0) + strSubstring4.charAt(0) + strSubstring4.charAt(1) + strSubstring4.charAt(1) + strSubstring4.charAt(2) + strSubstring4.charAt(2);
            }
            int color = android.graphics.Color.parseColor(str);
            int iRed = android.graphics.Color.red(color);
            int iGreen = android.graphics.Color.green(color);
            int iBlue = android.graphics.Color.blue(color);
            int color2 = android.graphics.Color.parseColor(str2);
            int iRed2 = android.graphics.Color.red(color2);
            int iGreen2 = android.graphics.Color.green(color2);
            int iBlue2 = android.graphics.Color.blue(color2);
            java.lang.String hexString = java.lang.Integer.toHexString(android.graphics.Color.alpha(color));
            if (1 == hexString.length()) {
                hexString = com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT + hexString;
            }
            float f5 = iRed;
            if (iRed != iRed2) {
                f5 = iRed > iRed2 ? f5 - ((iRed - iRed2) * f) : f5 + ((iRed - iRed2) * f);
            }
            java.lang.String hexString2 = java.lang.Integer.toHexString((int) f5);
            if (1 == hexString2.length()) {
                hexString2 = com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT + hexString2;
            }
            float f6 = iGreen;
            if (iGreen != iGreen2) {
                f6 = iGreen > iGreen2 ? f6 - ((iGreen - iGreen2) * f) : f6 + ((iGreen2 - iGreen) * f);
            }
            java.lang.String hexString3 = java.lang.Integer.toHexString((int) f6);
            if (1 == hexString3.length()) {
                hexString3 = com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT + hexString3;
            }
            float f7 = iBlue;
            if (iBlue != iBlue2) {
                f7 = iBlue > iBlue2 ? f7 - ((iBlue - iBlue2) * f) : f7 + ((iBlue2 - iBlue) * f);
            }
            java.lang.String hexString4 = java.lang.Integer.toHexString((int) f7);
            if (1 == hexString4.length()) {
                hexString4 = com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT + hexString4;
            }
            return "#" + hexString + hexString2 + hexString3 + hexString4;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean compareColor(java.lang.String str, java.lang.String str2) {
        try {
            if (!android.text.TextUtils.isEmpty(str) && !android.text.TextUtils.isEmpty(str2)) {
                if (str.startsWith("#") && str2.startsWith("#")) {
                    java.lang.String strSubstring = str.substring(1, str.length());
                    java.lang.String strSubstring2 = str2.substring(1, str2.length());
                    if (strSubstring.length() == 3) {
                        str = "#" + strSubstring.charAt(0) + strSubstring.charAt(0) + strSubstring.charAt(1) + strSubstring.charAt(1) + strSubstring.charAt(2) + strSubstring.charAt(2);
                    }
                    if (strSubstring2.length() == 3) {
                        str2 = "#" + strSubstring2.charAt(0) + strSubstring2.charAt(0) + strSubstring2.charAt(1) + strSubstring2.charAt(1) + strSubstring2.charAt(2) + strSubstring2.charAt(2);
                    }
                    int color = android.graphics.Color.parseColor(str);
                    int color2 = android.graphics.Color.parseColor(str2);
                    return android.graphics.Color.rgb(android.graphics.Color.red(color), android.graphics.Color.green(color), android.graphics.Color.blue(color)) == android.graphics.Color.rgb(android.graphics.Color.red(color2), android.graphics.Color.green(color2), android.graphics.Color.blue(color2));
                }
                if (str.startsWith("rgba") && str.contains(com.taobao.weex.el.parse.Operators.BRACKET_START_STR) && str.contains(com.taobao.weex.el.parse.Operators.BRACKET_END_STR) && str.contains(",") && str2.startsWith("rgba") && str2.contains(com.taobao.weex.el.parse.Operators.BRACKET_START_STR) && str2.contains(com.taobao.weex.el.parse.Operators.BRACKET_END_STR) && str2.contains(",")) {
                    java.lang.String strSubstring3 = str.substring(str.indexOf(com.taobao.weex.el.parse.Operators.BRACKET_START_STR) + 1, str.indexOf(com.taobao.weex.el.parse.Operators.BRACKET_END_STR));
                    java.lang.String strSubstring4 = str2.substring(str2.indexOf(com.taobao.weex.el.parse.Operators.BRACKET_START_STR) + 1, str2.indexOf(com.taobao.weex.el.parse.Operators.BRACKET_END_STR));
                    java.lang.String[] strArrStringSplit = io.dcloud.common.util.PdrUtil.stringSplit(strSubstring3, ",");
                    java.lang.String[] strArrStringSplit2 = io.dcloud.common.util.PdrUtil.stringSplit(strSubstring4, ",");
                    return strArrStringSplit != null && 4 == strArrStringSplit.length && strArrStringSplit2 != null && 4 == strArrStringSplit2.length && android.graphics.Color.rgb(java.lang.Integer.valueOf(strArrStringSplit[0]).intValue(), java.lang.Integer.valueOf(strArrStringSplit[1]).intValue(), java.lang.Integer.valueOf(strArrStringSplit[2]).intValue()) == android.graphics.Color.rgb(java.lang.Integer.valueOf(strArrStringSplit2[0]).intValue(), java.lang.Integer.valueOf(strArrStringSplit2[1]).intValue(), java.lang.Integer.valueOf(strArrStringSplit2[2]).intValue());
                }
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void drawTitle(io.dcloud.common.DHInterface.IFrameView iFrameView, final io.dcloud.common.DHInterface.ITitleNView iTitleNView, final java.lang.String str, final java.lang.String str2, final java.lang.String str3, final java.lang.String str4, final java.lang.String str5, final java.lang.String str6, final java.lang.String str7, final java.lang.String str8, final java.lang.String str9, final java.lang.String str10, final java.lang.String str11, final java.lang.String str12) {
        if (iFrameView == null || iTitleNView == null) {
            return;
        }
        if (!io.dcloud.common.util.BaseInfo.sDoingAnimation) {
            iTitleNView.setTitle(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12);
        } else if (iFrameView.obtainWebView().obtainFrameView() instanceof io.dcloud.common.adapter.ui.AdaFrameView) {
            ((io.dcloud.common.adapter.ui.AdaFrameView) iFrameView.obtainWebView().obtainFrameView()).obtainWindowMgr().processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.WindowMgr, 71, new io.dcloud.common.core.ui.l.m() { // from class: io.dcloud.common.util.TitleNViewUtil.1
                @Override // io.dcloud.common.core.ui.l.m
                public void onAnimationEnd() {
                    iTitleNView.setTitle(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12);
                }
            });
        }
    }

    private static int getColorAlpha(java.lang.String str) {
        int iStringToColor;
        try {
            iStringToColor = android.graphics.Color.parseColor(str);
        } catch (java.lang.Exception unused) {
            iStringToColor = io.dcloud.common.util.PdrUtil.stringToColor(str);
        }
        return android.graphics.Color.alpha(iStringToColor);
    }

    public static java.lang.Object getTitleNView(io.dcloud.common.DHInterface.AbsMgr absMgr, io.dcloud.common.DHInterface.IWebview iWebview, io.dcloud.common.DHInterface.IFrameView iFrameView, java.lang.String str) {
        if (absMgr == null || iWebview == null || iFrameView == null || android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        return absMgr.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.FeatureMgr, 10, new java.lang.Object[]{iWebview, "nativeobj", "getNativeView", new java.lang.Object[]{iFrameView, str}});
    }

    public static java.lang.String getTitleNViewId(io.dcloud.common.DHInterface.IFrameView iFrameView) {
        if (iFrameView == null || iFrameView.obtainWebView() == null || iFrameView.obtainWebView().obtainWindowView() == null) {
            return null;
        }
        return (2 == iFrameView.getFrameType() || 4 == iFrameView.getFrameType() || 5 == iFrameView.getFrameType()) ? java.lang.String.valueOf(iFrameView.obtainWebView().obtainWindowView().hashCode()) : iFrameView.obtainWebView().getWebviewUUID();
    }

    public static java.lang.String getTitleNViewSearchInputText(io.dcloud.common.DHInterface.ITitleNView iTitleNView) {
        return iTitleNView.getTitleNViewSearchInputText();
    }

    public static java.lang.String intColor2String(int i, boolean z) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("#");
        java.lang.String hexString = java.lang.Integer.toHexString(android.graphics.Color.alpha(i));
        java.lang.String hexString2 = java.lang.Integer.toHexString(android.graphics.Color.red(i));
        java.lang.String hexString3 = java.lang.Integer.toHexString(android.graphics.Color.green(i));
        java.lang.String hexString4 = java.lang.Integer.toHexString(android.graphics.Color.blue(i));
        if (hexString.length() == 1) {
            hexString = com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT + hexString;
        }
        if (hexString2.length() == 1) {
            hexString2 = com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT + hexString2;
        }
        if (hexString3.length() == 1) {
            hexString3 = com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT + hexString3;
        }
        if (hexString4.length() == 1) {
            hexString4 = com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT + hexString4;
        }
        if (z) {
            sb.append(hexString);
        }
        sb.append(hexString2);
        sb.append(hexString3);
        sb.append(hexString4);
        return sb.toString();
    }

    public static boolean isButtonsIsChanged(org.json.JSONObject jSONObject, org.json.JSONObject jSONObject2) {
        return jSONObject2.has("buttons");
    }

    public static boolean isSearchInputChange(org.json.JSONObject jSONObject, org.json.JSONObject jSONObject2) {
        if (jSONObject2 != null && jSONObject2.has("searchInput")) {
            org.json.JSONObject jSONObjectOptJSONObject = jSONObject != null ? jSONObject.optJSONObject("searchInput") : null;
            org.json.JSONObject jSONObjectOptJSONObject2 = jSONObject2.optJSONObject("searchInput");
            if (jSONObjectOptJSONObject == null && jSONObjectOptJSONObject2 != null) {
                return true;
            }
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject2 == null) {
                return true;
            }
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject2.length() > 0 && (!jSONObjectOptJSONObject.optString(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_ALIGN).equalsIgnoreCase(jSONObjectOptJSONObject2.optString(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_ALIGN)) || !jSONObjectOptJSONObject.optString("backgroundColor").equalsIgnoreCase(jSONObjectOptJSONObject2.optString("backgroundColor")) || !jSONObjectOptJSONObject.optString(com.taobao.weex.common.Constants.Name.BORDER_RADIUS).equalsIgnoreCase(jSONObjectOptJSONObject2.optString(com.taobao.weex.common.Constants.Name.BORDER_RADIUS)) || !jSONObjectOptJSONObject.optString(com.taobao.weex.common.Constants.Name.PLACEHOLDER).equalsIgnoreCase(jSONObjectOptJSONObject2.optString(com.taobao.weex.common.Constants.Name.PLACEHOLDER)) || !jSONObjectOptJSONObject.optString(com.taobao.weex.common.Constants.Name.PLACEHOLDER_COLOR).equalsIgnoreCase(jSONObjectOptJSONObject2.optString(com.taobao.weex.common.Constants.Name.PLACEHOLDER_COLOR)) || !jSONObjectOptJSONObject.optString("color").equalsIgnoreCase(jSONObjectOptJSONObject2.optString("color")) || jSONObjectOptJSONObject.optBoolean(com.taobao.weex.common.Constants.Name.DISABLED) == jSONObjectOptJSONObject2.optBoolean(com.taobao.weex.common.Constants.Name.DISABLED) || jSONObjectOptJSONObject.optBoolean("autoFocus") == jSONObjectOptJSONObject2.optBoolean("autoFocus"))) {
                return true;
            }
        }
        return false;
    }

    public static boolean isShadowChanged(org.json.JSONObject jSONObject, org.json.JSONObject jSONObject2) {
        org.json.JSONObject jSONObjectOptJSONObject;
        if (jSONObject2 != null && jSONObject2.has("shadow")) {
            org.json.JSONObject jSONObjectOptJSONObject2 = jSONObject2.optJSONObject("shadow");
            if (jSONObject == null && jSONObjectOptJSONObject2 != null && jSONObjectOptJSONObject2.has("color")) {
                return true;
            }
            if (jSONObject != null) {
                if (jSONObject.has("shadow")) {
                    if (jSONObject.has("shadow") && (jSONObjectOptJSONObject = jSONObject.optJSONObject("shadow")) != null && jSONObjectOptJSONObject2 != null && !jSONObjectOptJSONObject2.optString("color").equals(jSONObjectOptJSONObject.optString("color"))) {
                        return true;
                    }
                } else if (jSONObjectOptJSONObject2 != null) {
                    return !android.text.TextUtils.isEmpty(jSONObjectOptJSONObject2.optString("color"));
                }
            }
        }
        return false;
    }

    public static boolean isTitleTypeForDef(org.json.JSONObject jSONObject) {
        if (jSONObject != null) {
            return !jSONObject.has("type") || "default".equals(jSONObject.opt("type"));
        }
        return false;
    }

    private void jsonCompare(org.json.JSONObject jSONObject, org.json.JSONObject jSONObject2) {
        jSONObject.keys();
    }

    public static boolean paddingIsChanged(org.json.JSONObject jSONObject, org.json.JSONObject jSONObject2) {
        if (jSONObject2.has("padding")) {
            return checkKeyValueIsModify("padding", jSONObject, jSONObject2);
        }
        if (jSONObject2.has(com.taobao.weex.common.Constants.Name.PADDING_RIGHT)) {
            return checkKeyValueIsModify(com.taobao.weex.common.Constants.Name.PADDING_RIGHT, jSONObject, jSONObject2);
        }
        if (jSONObject2.has(com.taobao.weex.common.Constants.Name.PADDING_LEFT)) {
            return checkKeyValueIsModify(com.taobao.weex.common.Constants.Name.PADDING_LEFT, jSONObject, jSONObject2);
        }
        if (jSONObject2.has(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_PADDING_LEFT)) {
            return checkKeyValueIsModify(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_PADDING_LEFT, jSONObject, jSONObject2);
        }
        if (jSONObject2.has(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_PADDING_RIGHT)) {
            return checkKeyValueIsModify(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_PADDING_RIGHT, jSONObject, jSONObject2);
        }
        return false;
    }

    public static boolean progressIsChanged(org.json.JSONObject jSONObject, org.json.JSONObject jSONObject2) {
        if (jSONObject2 != null && jSONObject2.has("progress") && jSONObject != null) {
            if (jSONObject.has("progress") || !jSONObject2.has("progress")) {
                if (jSONObject.has("progress") && jSONObject2.has("progress")) {
                    if ((jSONObject.optJSONObject("progress") == null || com.taobao.weex.common.Constants.Name.UNDEFINED.equals(jSONObject.optString("progress"))) && jSONObject2.optJSONObject("progress") != null && !com.taobao.weex.common.Constants.Name.UNDEFINED.equals(jSONObject2.optString("progress"))) {
                        return true;
                    }
                    if (jSONObject.optJSONObject("progress") != null && !com.taobao.weex.common.Constants.Name.UNDEFINED.equals(jSONObject.optString("progress")) && (jSONObject2.optJSONObject("progress") == null || com.taobao.weex.common.Constants.Name.UNDEFINED.equals(jSONObject2.optString("progress")))) {
                        return true;
                    }
                    if (jSONObject.optJSONObject("progress") != null && !com.taobao.weex.common.Constants.Name.UNDEFINED.equals(jSONObject.optString("progress"))) {
                        if ((!com.taobao.weex.common.Constants.Name.UNDEFINED.equals(jSONObject2.optString("progress"))) & (jSONObject2.optJSONObject("progress") != null)) {
                            java.lang.String strOptString = jSONObject.optString("height");
                            java.lang.String strOptString2 = jSONObject.optString("color");
                            java.lang.String strOptString3 = jSONObject2.optString("height");
                            java.lang.String strOptString4 = jSONObject2.optString("color");
                            if (!strOptString.equals(strOptString3) || !strOptString2.equals(strOptString4)) {
                                return true;
                            }
                        }
                    }
                }
            } else if (jSONObject2.optJSONObject("progress") != null && com.taobao.weex.common.Constants.Name.UNDEFINED.equals(jSONObject2.optString("progress"))) {
                return true;
            }
        }
        return false;
    }

    public static boolean redDotChange(org.json.JSONObject jSONObject, org.json.JSONObject jSONObject2) {
        if (jSONObject2 != null && jSONObject2.has("redDotColor")) {
            if (jSONObject == null) {
                if (!android.text.TextUtils.isEmpty(jSONObject2.optString("redDotColor"))) {
                    return true;
                }
            } else if (jSONObject != null) {
                java.lang.String strOptString = jSONObject.optString("redDotColor");
                java.lang.String strOptString2 = jSONObject2.optString("redDotColor");
                if (android.text.TextUtils.isEmpty(strOptString) && !android.text.TextUtils.isEmpty(strOptString2)) {
                    return true;
                }
                if (!android.text.TextUtils.isEmpty(strOptString) && !android.text.TextUtils.isEmpty(strOptString2) && !strOptString.equals(strOptString2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void setBackButton(io.dcloud.common.DHInterface.ITitleNView iTitleNView, org.json.JSONObject jSONObject, int i) {
        if (iTitleNView != null) {
            if (!jSONObject.has("autoBackButton")) {
                iTitleNView.removeBackButton();
                return;
            }
            if (!jSONObject.optBoolean("autoBackButton")) {
                iTitleNView.removeBackButton();
                return;
            }
            org.json.JSONObject jSONObjectOptJSONObject = (!jSONObject.has("backButton") || jSONObject.optJSONObject("backButton") == null || com.taobao.weex.common.Constants.Name.UNDEFINED.equalsIgnoreCase(jSONObject.optString("backButton"))) ? null : jSONObject.optJSONObject("backButton");
            java.lang.String strOptString = jSONObject.optString("titlecolor");
            if (jSONObjectOptJSONObject == null || !jSONObjectOptJSONObject.has("color")) {
                if (android.text.TextUtils.isEmpty(strOptString)) {
                    strOptString = jSONObject.optString("titleColor");
                }
                if (!android.text.TextUtils.isEmpty(strOptString) && strOptString.startsWith("#") && strOptString.length() == 9) {
                    strOptString = "#" + strOptString.substring(3, strOptString.length());
                }
            } else {
                strOptString = jSONObjectOptJSONObject.optString("color");
            }
            if (!android.text.TextUtils.isEmpty(strOptString) || strOptString.startsWith("#")) {
                iTitleNView.addBackButton(strOptString, (jSONObjectOptJSONObject == null || !jSONObjectOptJSONObject.has("colorPressed")) ? changeColorAlpha(strOptString, 0.3f) : jSONObjectOptJSONObject.optString("colorPressed"), jSONObject.optString("type"), jSONObjectOptJSONObject);
            }
        }
    }

    public static void setBackgroundImage(io.dcloud.common.DHInterface.ITitleNView iTitleNView, org.json.JSONObject jSONObject) {
        if (jSONObject != null) {
            iTitleNView.setBackgroundImage(jSONObject.optString(com.taobao.weex.common.Constants.Name.BACKGROUND_IMAGE));
        }
    }

    /* JADX WARN: Code duplicated, block: B:37:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:39:0x0104  */
    /* JADX WARN: Code duplicated, block: B:40:0x0109  */
    /* JADX WARN: Code duplicated, block: B:42:0x0123  */
    /* JADX WARN: Code duplicated, block: B:44:0x0146  */
    /* JADX WARN: Code duplicated, block: B:45:0x014d  */
    public static void setButtons(io.dcloud.common.DHInterface.ITitleNView iTitleNView, org.json.JSONObject jSONObject, io.dcloud.common.DHInterface.IWebview iWebview) {
        java.lang.String str;
        java.lang.String strOptString;
        java.lang.String str2;
        java.lang.String str3;
        java.lang.String strOptString2;
        java.lang.String strOptString3;
        if (iTitleNView != null && jSONObject.has("buttons")) {
            java.lang.String strOptString4 = jSONObject.optString("titleColor");
            if (android.text.TextUtils.isEmpty(strOptString4)) {
                strOptString4 = jSONObject.optString("titlecolor");
            }
            java.lang.String strChangeColorAlpha = changeColorAlpha(strOptString4, 1.0f);
            org.json.JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("buttons");
            java.lang.String str4 = "type";
            java.lang.String strOptString5 = jSONObject.optString("type");
            if (jSONArrayOptJSONArray != null) {
                int i = 0;
                while (i < jSONArrayOptJSONArray.length()) {
                    org.json.JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                    java.lang.String strOptString6 = jSONObjectOptJSONObject.optString(str4, "none");
                    java.lang.String strOptString7 = jSONObjectOptJSONObject.optString("color");
                    java.lang.String strOptString8 = jSONObjectOptJSONObject.optString("colorPressed");
                    java.lang.String strOptString9 = jSONObjectOptJSONObject.optString("width");
                    java.lang.String strOptString10 = jSONObjectOptJSONObject.optString("background", TRANSPARENT_BUTTON_BACKGROUND_COLOR);
                    if ("transparent".equals(strOptString5)) {
                        strOptString7 = TRANSPARENT_BUTTON_TEXT_COLOR;
                        strOptString8 = changeColorAlpha(TRANSPARENT_BUTTON_TEXT_COLOR, 0.3f);
                    } else if (android.text.TextUtils.isEmpty(strOptString7)) {
                        strOptString8 = changeColorAlpha(strChangeColorAlpha, 0.3f);
                        strOptString7 = strChangeColorAlpha;
                    } else if (android.text.TextUtils.isEmpty(strOptString8)) {
                        strOptString8 = changeColorAlpha(strOptString7, 0.3f);
                    }
                    if (jSONObjectOptJSONObject.has("__cb__")) {
                        org.json.JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("__cb__");
                        strOptString = jSONObjectOptJSONObject2.optString("id");
                        jSONObjectOptJSONObject2.optString("htmlId");
                    } else if (jSONObjectOptJSONObject.has("onClick")) {
                        strOptString = jSONObjectOptJSONObject.optString("onClick");
                    } else {
                        if (jSONObjectOptJSONObject.has("onclick")) {
                            strOptString = jSONObjectOptJSONObject.optString("onclick");
                        } else {
                            str = null;
                        }
                        str2 = strOptString5;
                        org.json.JSONArray jSONArray = jSONArrayOptJSONArray;
                        java.lang.String str5 = strChangeColorAlpha;
                        java.lang.String str6 = str4;
                        int i2 = i;
                        if ("left".equals(jSONObjectOptJSONObject.optString("float"))) {
                            java.lang.String strOptString11 = jSONObjectOptJSONObject.optString("text");
                            java.lang.String strOptString12 = jSONObjectOptJSONObject.optString(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_TITLE);
                            java.lang.String strOptString13 = jSONObjectOptJSONObject.optString(com.taobao.weex.common.Constants.Name.FONT_WEIGHT);
                            java.lang.String strOptString14 = jSONObjectOptJSONObject.optString(com.taobao.weex.common.Constants.Name.FONT_SIZE);
                            java.lang.String strOptString15 = jSONObjectOptJSONObject.optString("fontSrc");
                            str3 = str2;
                            boolean zOptBoolean = jSONObjectOptJSONObject.optBoolean("redDot");
                            if (jSONObjectOptJSONObject.has("badgeText")) {
                                strOptString3 = jSONObjectOptJSONObject.optString("badgeText");
                            } else {
                                strOptString3 = null;
                            }
                            iTitleNView.addLeftButton(strOptString11, strOptString12, strOptString7, strOptString8, strOptString13, strOptString14, strOptString15, strOptString6, strOptString9, str, iWebview, str3, strOptString10, zOptBoolean, strOptString3, jSONObjectOptJSONObject.optBoolean("select", false), jSONObjectOptJSONObject.optString(com.taobao.weex.common.Constants.Name.MAX_WIDTH));
                        } else {
                            str3 = str2;
                            java.lang.String strOptString16 = jSONObjectOptJSONObject.optString("text");
                            java.lang.String strOptString17 = jSONObjectOptJSONObject.optString(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_TITLE);
                            java.lang.String strOptString18 = jSONObjectOptJSONObject.optString(com.taobao.weex.common.Constants.Name.FONT_WEIGHT);
                            java.lang.String strOptString19 = jSONObjectOptJSONObject.optString(com.taobao.weex.common.Constants.Name.FONT_SIZE);
                            java.lang.String strOptString20 = jSONObjectOptJSONObject.optString("fontSrc");
                            boolean zOptBoolean2 = jSONObjectOptJSONObject.optBoolean("redDot");
                            if (jSONObjectOptJSONObject.has("badgeText")) {
                                strOptString2 = jSONObjectOptJSONObject.optString("badgeText");
                            } else {
                                strOptString2 = null;
                            }
                            iTitleNView.addRightButton(strOptString16, strOptString17, strOptString7, strOptString8, strOptString18, strOptString19, strOptString20, strOptString6, strOptString9, str, iWebview, str3, strOptString10, zOptBoolean2, strOptString2, jSONObjectOptJSONObject.optBoolean("select", false), jSONObjectOptJSONObject.optString(com.taobao.weex.common.Constants.Name.MAX_WIDTH));
                        }
                        i = i2 + 1;
                        strOptString5 = str3;
                        jSONArrayOptJSONArray = jSONArray;
                        strChangeColorAlpha = str5;
                        str4 = str6;
                    }
                    str = strOptString;
                    str2 = strOptString5;
                    org.json.JSONArray jSONArray2 = jSONArrayOptJSONArray;
                    java.lang.String str7 = strChangeColorAlpha;
                    java.lang.String str8 = str4;
                    int i3 = i;
                    if ("left".equals(jSONObjectOptJSONObject.optString("float"))) {
                        java.lang.String strOptString110 = jSONObjectOptJSONObject.optString("text");
                        java.lang.String strOptString111 = jSONObjectOptJSONObject.optString(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_TITLE);
                        java.lang.String strOptString112 = jSONObjectOptJSONObject.optString(com.taobao.weex.common.Constants.Name.FONT_WEIGHT);
                        java.lang.String strOptString113 = jSONObjectOptJSONObject.optString(com.taobao.weex.common.Constants.Name.FONT_SIZE);
                        java.lang.String strOptString114 = jSONObjectOptJSONObject.optString("fontSrc");
                        str3 = str2;
                        boolean zOptBoolean3 = jSONObjectOptJSONObject.optBoolean("redDot");
                        if (jSONObjectOptJSONObject.has("badgeText")) {
                            strOptString3 = jSONObjectOptJSONObject.optString("badgeText");
                        } else {
                            strOptString3 = null;
                        }
                        iTitleNView.addLeftButton(strOptString110, strOptString111, strOptString7, strOptString8, strOptString112, strOptString113, strOptString114, strOptString6, strOptString9, str, iWebview, str3, strOptString10, zOptBoolean3, strOptString3, jSONObjectOptJSONObject.optBoolean("select", false), jSONObjectOptJSONObject.optString(com.taobao.weex.common.Constants.Name.MAX_WIDTH));
                    } else {
                        str3 = str2;
                        java.lang.String strOptString115 = jSONObjectOptJSONObject.optString("text");
                        java.lang.String strOptString116 = jSONObjectOptJSONObject.optString(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_TITLE);
                        java.lang.String strOptString117 = jSONObjectOptJSONObject.optString(com.taobao.weex.common.Constants.Name.FONT_WEIGHT);
                        java.lang.String strOptString118 = jSONObjectOptJSONObject.optString(com.taobao.weex.common.Constants.Name.FONT_SIZE);
                        java.lang.String strOptString21 = jSONObjectOptJSONObject.optString("fontSrc");
                        boolean zOptBoolean4 = jSONObjectOptJSONObject.optBoolean("redDot");
                        if (jSONObjectOptJSONObject.has("badgeText")) {
                            strOptString2 = jSONObjectOptJSONObject.optString("badgeText");
                        } else {
                            strOptString2 = null;
                        }
                        iTitleNView.addRightButton(strOptString115, strOptString116, strOptString7, strOptString8, strOptString117, strOptString118, strOptString21, strOptString6, strOptString9, str, iWebview, str3, strOptString10, zOptBoolean4, strOptString2, jSONObjectOptJSONObject.optBoolean("select", false), jSONObjectOptJSONObject.optString(com.taobao.weex.common.Constants.Name.MAX_WIDTH));
                    }
                    i = i3 + 1;
                    strOptString5 = str3;
                    jSONArrayOptJSONArray = jSONArray2;
                    strChangeColorAlpha = str7;
                    str4 = str8;
                }
            }
        }
    }

    public static void setCapsuleButtonStyle(io.dcloud.common.DHInterface.ITitleNView iTitleNView, org.json.JSONObject jSONObject) {
        if (iTitleNView == null || jSONObject == null || !jSONObject.has("capsuleButtonStyle")) {
            return;
        }
        iTitleNView.setCapsuleButtonStyle(jSONObject.optJSONObject("capsuleButtonStyle"));
    }

    public static void setHomeButton(io.dcloud.common.DHInterface.ITitleNView iTitleNView, org.json.JSONObject jSONObject, int i) {
        if (iTitleNView != null) {
            if (!((jSONObject.has("homeButton") && jSONObject.optBoolean("homeButton")) ? true : i == 5)) {
                iTitleNView.removeHomeButton();
                return;
            }
            java.lang.String strOptString = jSONObject.optString("titlecolor");
            if (android.text.TextUtils.isEmpty(strOptString)) {
                strOptString = jSONObject.optString("titleColor");
            }
            if (!android.text.TextUtils.isEmpty(strOptString) && strOptString.startsWith("#") && strOptString.length() == 9) {
                strOptString = "#" + strOptString.substring(3, strOptString.length());
            }
            if (!android.text.TextUtils.isEmpty(strOptString) || strOptString.startsWith("#")) {
                iTitleNView.addHomeButton(strOptString, changeColorAlpha(strOptString, 0.3f), jSONObject.optString("type"));
            }
        }
    }

    public static void setProgress(io.dcloud.common.DHInterface.ITitleNView iTitleNView, org.json.JSONObject jSONObject) {
        if (iTitleNView != null && jSONObject.has("progress")) {
            if (jSONObject.optJSONObject("progress") == null || com.taobao.weex.common.Constants.Name.UNDEFINED.equalsIgnoreCase(jSONObject.optString("progress"))) {
                iTitleNView.setProgress("", "");
                return;
            }
            org.json.JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("progress");
            java.lang.String strOptString = jSONObjectOptJSONObject.optString("height");
            if (!jSONObjectOptJSONObject.has("height") || "".equals(strOptString)) {
                strOptString = "2px";
            }
            java.lang.String strOptString2 = jSONObjectOptJSONObject.optString("color");
            if (!jSONObjectOptJSONObject.has("color") || "".equals(strOptString2)) {
                strOptString2 = "#00FF00";
            }
            iTitleNView.setProgress(strOptString, strOptString2);
        }
    }

    public static void setRedDotColor(io.dcloud.common.DHInterface.ITitleNView iTitleNView, org.json.JSONObject jSONObject) {
        if (jSONObject != null) {
            iTitleNView.setRedDotColor(io.dcloud.common.util.PdrUtil.stringToColor(jSONObject.optString("redDotColor")));
        }
    }

    public static void setSearchInput(io.dcloud.common.DHInterface.ITitleNView iTitleNView, org.json.JSONObject jSONObject, io.dcloud.common.DHInterface.IWebview iWebview) {
        if (iTitleNView == null) {
            return;
        }
        if (!jSONObject.has("searchInput")) {
            iTitleNView.clearSearchInput();
        } else {
            org.json.JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("searchInput");
            iTitleNView.addSearchInput(jSONObjectOptJSONObject.optString(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_ALIGN), jSONObjectOptJSONObject.optString("backgroundColor"), jSONObjectOptJSONObject.optString(com.taobao.weex.common.Constants.Name.BORDER_RADIUS, "0px"), jSONObjectOptJSONObject.optString(com.taobao.weex.common.Constants.Name.PLACEHOLDER), jSONObjectOptJSONObject.optString(com.taobao.weex.common.Constants.Name.PLACEHOLDER_COLOR, "#CCCCCC"), jSONObjectOptJSONObject.optString("color", "#000000"), jSONObjectOptJSONObject.optBoolean(com.taobao.weex.common.Constants.Name.DISABLED, false), jSONObjectOptJSONObject.optBoolean("autoFocus", false), iWebview);
        }
    }

    public static void setShadow(io.dcloud.common.DHInterface.ITitleNView iTitleNView, org.json.JSONObject jSONObject) {
        if (iTitleNView == null) {
            return;
        }
        org.json.JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("shadow");
        if (jSONObjectOptJSONObject != null) {
            iTitleNView.setShadow(jSONObjectOptJSONObject);
        } else {
            iTitleNView.setShadow(new org.json.JSONObject());
        }
    }

    public static void setSplitLine(io.dcloud.common.DHInterface.ITitleNView iTitleNView, io.dcloud.common.DHInterface.IWebview iWebview, org.json.JSONObject jSONObject, org.json.JSONObject jSONObject2, boolean z, java.lang.String str) {
        if (iTitleNView != null) {
            if (jSONObject2 == null) {
                if (jSONObject != null) {
                    iTitleNView.removeSplitLine();
                    return;
                }
                return;
            }
            org.json.JSONObject jSONObjectCombinJSONObject = io.dcloud.common.util.JSONUtil.combinJSONObject(jSONObject, jSONObject2);
            java.lang.String strOptString = jSONObjectCombinJSONObject.optString("color");
            if ((jSONObjectCombinJSONObject.has("color") && "".equals(strOptString)) || !jSONObjectCombinJSONObject.has("color")) {
                strOptString = "#CCCCCC";
            }
            if (z && "transparent".equals(str)) {
                strOptString = changeColorAlpha(strOptString, 0.0f);
            }
            try {
                if ("transparent".equals(str) && iWebview.obtainWindowView().getScrollY() == 0) {
                    strOptString = changeColorAlpha(strOptString, 0.0f);
                }
            } catch (java.lang.Exception unused) {
            }
            java.lang.String strOptString2 = jSONObjectCombinJSONObject.optString("height");
            if (android.text.TextUtils.isEmpty(strOptString)) {
                return;
            }
            if (android.text.TextUtils.isEmpty(strOptString2)) {
                strOptString2 = "1px";
            }
            iTitleNView.setSplitLine(strOptString2, strOptString);
        }
    }

    public static void setSubTitleIcon(io.dcloud.common.DHInterface.ITitleNView iTitleNView, org.json.JSONObject jSONObject) {
        if (jSONObject != null) {
            java.lang.String strOptString = jSONObject.optString("titleColor");
            if (android.text.TextUtils.isEmpty(strOptString)) {
                strOptString = jSONObject.optString("titlecolor");
            }
            iTitleNView.setIconSubTitleStyle(jSONObject.optString("titleIcon"), jSONObject.optString("titleIconRadius"), jSONObject.optString("subtitleText"), jSONObject.optString("subtitleColor"), jSONObject.optString("subtitleSize"), jSONObject.optString("subtitleOverflow"), strOptString, jSONObject.optString("titleAlign"), jSONObject.optString("titleIconWidth"));
        }
    }

    public static void setTitleAlign(io.dcloud.common.DHInterface.ITitleNView iTitleNView, org.json.JSONObject jSONObject) {
        if (jSONObject != null) {
            iTitleNView.setTitleAlign(jSONObject.optString("titleAlign"));
        }
    }

    /* JADX WARN: Code duplicated, block: B:33:0x00d2  */
    /* JADX WARN: Multi-variable type inference failed */
    public static void setTitleNViewButtonStyle(io.dcloud.common.DHInterface.ITitleNView iTitleNView, java.lang.String str, org.json.JSONObject jSONObject, io.dcloud.common.DHInterface.IFrameView iFrameView) {
        int i;
        java.lang.String str2;
        java.lang.String strOptString;
        org.json.JSONObject jSONObject2;
        org.json.JSONArray jSONArrayOptJSONArray;
        java.lang.String str3;
        java.lang.String strOptString2;
        java.lang.String strOptString3;
        java.lang.String strOptString4;
        java.lang.String strOptString5;
        java.lang.String strOptString6;
        java.lang.String strOptString7;
        io.dcloud.common.DHInterface.IWebview iWebviewObtainWebView;
        java.lang.String strOptString8;
        org.json.JSONObject jSONObjectOptJSONObject;
        try {
            i = java.lang.Integer.parseInt(str);
        } catch (java.lang.Exception unused) {
            i = -1;
        }
        if (jSONObject != null) {
            java.lang.String strOptString9 = "";
            java.lang.String strOptString10 = jSONObject.optString("type", "");
            java.lang.String strOptString11 = jSONObject.optString("color");
            java.lang.String strOptString12 = jSONObject.optString("colorPressed");
            java.lang.String strOptString13 = jSONObject.optString("width");
            java.lang.String strOptString14 = jSONObject.optString("background");
            if (!io.dcloud.common.util.PdrUtil.isEmpty(strOptString11) && io.dcloud.common.util.PdrUtil.isEmpty(strOptString12)) {
                strOptString12 = changeColorAlpha(strOptString11, 0.3f);
            }
            java.lang.String str4 = strOptString12;
            if (jSONObject.has("__cb__")) {
                org.json.JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("__cb__");
                strOptString = jSONObjectOptJSONObject2.optString("id");
                jSONObjectOptJSONObject2.optString("htmlId");
            } else {
                if (!jSONObject.has("onClick")) {
                    if (jSONObject.has("onclick")) {
                        strOptString = jSONObject.optString("onclick");
                    } else {
                        str2 = null;
                    }
                    io.dcloud.common.adapter.ui.AdaFrameItem adaFrameItem = (io.dcloud.common.adapter.ui.AdaFrameItem) iFrameView;
                    jSONObject2 = adaFrameItem.obtainFrameOptions().titleNView;
                    jSONArrayOptJSONArray = jSONObject2.optJSONArray("buttons");
                    if (jSONArrayOptJSONArray != null && i < jSONArrayOptJSONArray.length() && i >= 0 && (jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i)) != null) {
                        strOptString9 = jSONObjectOptJSONObject.optString("width");
                    }
                    str3 = strOptString9;
                    strOptString2 = jSONObject.optString("text");
                    strOptString3 = jSONObject.optString(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_TITLE);
                    strOptString4 = jSONObject.optString(com.taobao.weex.common.Constants.Name.FONT_WEIGHT);
                    strOptString5 = jSONObject.optString(com.taobao.weex.common.Constants.Name.FONT_SIZE);
                    strOptString6 = jSONObject.optString("fontSrc");
                    strOptString7 = null;
                    iWebviewObtainWebView = iFrameView.obtainWebView();
                    strOptString8 = jSONObject.optString("redDot");
                    if (jSONObject.has("badgeText")) {
                        strOptString7 = jSONObject.optString("badgeText");
                    }
                    if (iTitleNView.setTitleNViewButtonStyle(i, strOptString2, strOptString3, strOptString11, str4, strOptString4, strOptString5, strOptString6, strOptString10, str2, iWebviewObtainWebView, strOptString14, strOptString8, strOptString7, jSONObject.optString("select"), strOptString13, jSONObject2.optString("type"), jSONObject.optString(com.taobao.weex.common.Constants.Name.MAX_WIDTH), str3) || jSONArrayOptJSONArray == null || i >= jSONArrayOptJSONArray.length() || i < 0) {
                        return;
                    }
                    io.dcloud.common.util.JSONUtil.combinJSONObject(jSONArrayOptJSONArray.optJSONObject(i), jSONObject);
                    adaFrameItem.obtainFrameOptions().setTitleNView(jSONObject2, iFrameView.obtainWebView());
                    return;
                }
                strOptString = jSONObject.optString("onClick");
            }
            str2 = strOptString;
            io.dcloud.common.adapter.ui.AdaFrameItem adaFrameItem2 = (io.dcloud.common.adapter.ui.AdaFrameItem) iFrameView;
            jSONObject2 = adaFrameItem2.obtainFrameOptions().titleNView;
            jSONArrayOptJSONArray = jSONObject2.optJSONArray("buttons");
            if (jSONArrayOptJSONArray != null) {
                strOptString9 = jSONObjectOptJSONObject.optString("width");
            }
            str3 = strOptString9;
            strOptString2 = jSONObject.optString("text");
            strOptString3 = jSONObject.optString(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_TITLE);
            strOptString4 = jSONObject.optString(com.taobao.weex.common.Constants.Name.FONT_WEIGHT);
            strOptString5 = jSONObject.optString(com.taobao.weex.common.Constants.Name.FONT_SIZE);
            strOptString6 = jSONObject.optString("fontSrc");
            strOptString7 = null;
            iWebviewObtainWebView = iFrameView.obtainWebView();
            strOptString8 = jSONObject.optString("redDot");
            if (jSONObject.has("badgeText")) {
                strOptString7 = jSONObject.optString("badgeText");
            }
            if (iTitleNView.setTitleNViewButtonStyle(i, strOptString2, strOptString3, strOptString11, str4, strOptString4, strOptString5, strOptString6, strOptString10, str2, iWebviewObtainWebView, strOptString14, strOptString8, strOptString7, jSONObject.optString("select"), strOptString13, jSONObject2.optString("type"), jSONObject.optString(com.taobao.weex.common.Constants.Name.MAX_WIDTH), str3)) {
            }
        }
    }

    public static void setTitleNViewPadding(io.dcloud.common.DHInterface.ITitleNView iTitleNView, io.dcloud.common.DHInterface.IWebview iWebview, org.json.JSONObject jSONObject) {
        int iConvertToScreenInt;
        int iConvertToScreenInt2;
        if (jSONObject.has("padding")) {
            iConvertToScreenInt2 = io.dcloud.common.util.PdrUtil.convertToScreenInt(jSONObject.optString("padding"), 0, 0, iWebview.getScale());
            iConvertToScreenInt = io.dcloud.common.util.PdrUtil.convertToScreenInt(jSONObject.optString("padding"), 0, 0, iWebview.getScale());
        } else {
            iConvertToScreenInt = 0;
            iConvertToScreenInt2 = 0;
        }
        if (jSONObject.has(com.taobao.weex.common.Constants.Name.PADDING_LEFT)) {
            iConvertToScreenInt2 = io.dcloud.common.util.PdrUtil.convertToScreenInt(jSONObject.optString(com.taobao.weex.common.Constants.Name.PADDING_LEFT), 0, 0, iWebview.getScale());
        } else if (jSONObject.has(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_PADDING_LEFT)) {
            iConvertToScreenInt2 = io.dcloud.common.util.PdrUtil.convertToScreenInt(jSONObject.optString(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_PADDING_LEFT), 0, 0, iWebview.getScale());
        }
        if (jSONObject.has(com.taobao.weex.common.Constants.Name.PADDING_RIGHT)) {
            iConvertToScreenInt = io.dcloud.common.util.PdrUtil.convertToScreenInt(jSONObject.optString(com.taobao.weex.common.Constants.Name.PADDING_RIGHT), 0, 0, iWebview.getScale());
        } else if (jSONObject.has(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_PADDING_RIGHT)) {
            iConvertToScreenInt = io.dcloud.common.util.PdrUtil.convertToScreenInt(jSONObject.optString(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_PADDING_RIGHT), 0, 0, iWebview.getScale());
        }
        iTitleNView.setTitleNViewPadding(iConvertToScreenInt2, 0, iConvertToScreenInt, 0);
    }

    public static void setTitleNViewSearchInputFocus(io.dcloud.common.DHInterface.ITitleNView iTitleNView, java.lang.String str) {
        iTitleNView.setSearchInputFocus(java.lang.Boolean.parseBoolean(str));
    }

    public static void setTitleNViewSearchInputText(io.dcloud.common.DHInterface.ITitleNView iTitleNView, java.lang.String str) {
        iTitleNView.setTitleNViewSearchInputText(str);
    }

    public static boolean splitLineIsChanged(org.json.JSONObject jSONObject, org.json.JSONObject jSONObject2) {
        if (jSONObject2 != null && jSONObject2.has("splitLine")) {
            org.json.JSONObject jSONObjectOptJSONObject = jSONObject != null ? jSONObject.optJSONObject("splitLine") : null;
            org.json.JSONObject jSONObjectOptJSONObject2 = jSONObject2.optJSONObject("splitLine");
            if (jSONObjectOptJSONObject == null && jSONObjectOptJSONObject2 != null) {
                return true;
            }
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject2 == null) {
                return true;
            }
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject2 != null) {
                java.lang.String strOptString = jSONObjectOptJSONObject.optString("color");
                java.lang.String strOptString2 = jSONObjectOptJSONObject2.optString("color");
                if (strOptString == null && strOptString2 != null) {
                    return true;
                }
                if (strOptString != null && strOptString2 != null && !strOptString.equals(strOptString2)) {
                    return true;
                }
                java.lang.String strOptString3 = jSONObjectOptJSONObject.optString("height");
                java.lang.String strOptString4 = jSONObjectOptJSONObject2.optString("height");
                if (strOptString3 == null && strOptString4 != null) {
                    return true;
                }
                if (strOptString3 != null && strOptString4 != null && !strOptString3.equals(strOptString4)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void startProcess(io.dcloud.common.DHInterface.ITitleNView iTitleNView) {
        if (iTitleNView == null) {
            return;
        }
        iTitleNView.startProgress();
    }

    public static void stopProcess(io.dcloud.common.DHInterface.ITitleNView iTitleNView) {
        if (iTitleNView == null) {
            return;
        }
        iTitleNView.stopProgress();
    }

    public static boolean subTitleIconChanged(org.json.JSONObject jSONObject, org.json.JSONObject jSONObject2) {
        if (jSONObject2 == null) {
            return false;
        }
        if (jSONObject == null) {
            jSONObject = new org.json.JSONObject();
        }
        return (jSONObject2.optString("titleIcon").equals(jSONObject.optString("titleIcon")) && jSONObject2.optString("titleIconRadius").equals(jSONObject.optString("titleIconRadius")) && jSONObject2.optString("subtitleText").equals(jSONObject.optString("subtitleText")) && jSONObject2.optString("subtitleColor").equals(jSONObject.optString("subtitleColor")) && jSONObject2.optString("subtitleSize").equals(jSONObject.optString("subtitleSize")) && jSONObject2.optString("subtitleOverflow").equals(jSONObject.optString("subtitleOverflow"))) ? false : true;
    }

    public static boolean titleAlignIsChanged(org.json.JSONObject jSONObject, org.json.JSONObject jSONObject2) {
        if (jSONObject2 != null && jSONObject2.has("titleAlign")) {
            if (jSONObject == null) {
                return !android.text.TextUtils.isEmpty(jSONObject2.optString("titleAlign"));
            }
            java.lang.String strOptString = jSONObject.optString("titleAlign");
            java.lang.String strOptString2 = jSONObject2.optString("titleAlign");
            if (android.text.TextUtils.isEmpty(strOptString) && !android.text.TextUtils.isEmpty(strOptString2)) {
                return true;
            }
            if (!android.text.TextUtils.isEmpty(strOptString) && !android.text.TextUtils.isEmpty(strOptString2) && !strOptString.equals(strOptString2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean titleColorIsChanged(org.json.JSONObject jSONObject, org.json.JSONObject jSONObject2) {
        if (jSONObject2 != null && (jSONObject2.has("titleColor") || jSONObject2.has("titlecolor"))) {
            if (jSONObject == null && ((jSONObject2.has("titleColor") && !android.text.TextUtils.isEmpty(jSONObject2.optString("titleColor"))) || (jSONObject2.has("titlecolor") && !android.text.TextUtils.isEmpty(jSONObject2.optString("titlecolor"))))) {
                return true;
            }
            if (jSONObject != null) {
                if (jSONObject.has("titleColor")) {
                    java.lang.String strOptString = jSONObject.optString("titleColor");
                    if (jSONObject2.has("titleColor")) {
                        java.lang.String strOptString2 = jSONObject2.optString("titleColor");
                        if (android.text.TextUtils.isEmpty(strOptString) && !android.text.TextUtils.isEmpty(strOptString2)) {
                            return true;
                        }
                        if (!android.text.TextUtils.isEmpty(strOptString) && !android.text.TextUtils.isEmpty(strOptString2) && !strOptString.equals(strOptString2)) {
                            return true;
                        }
                    } else if (jSONObject2.has("titlecolor")) {
                        java.lang.String strOptString3 = jSONObject2.optString("titlecolor");
                        if (android.text.TextUtils.isEmpty(strOptString) && !android.text.TextUtils.isEmpty(strOptString3)) {
                            return true;
                        }
                        if (!android.text.TextUtils.isEmpty(strOptString) && !android.text.TextUtils.isEmpty(strOptString3) && !strOptString.equals(strOptString3)) {
                            return true;
                        }
                    }
                } else if (jSONObject.has("titlecolor")) {
                    java.lang.String strOptString4 = jSONObject.optString("titlecolor");
                    if (jSONObject2.has("titleColor")) {
                        java.lang.String strOptString5 = jSONObject2.optString("titleColor");
                        if (android.text.TextUtils.isEmpty(strOptString4) && !android.text.TextUtils.isEmpty(strOptString5)) {
                            return true;
                        }
                        if (!android.text.TextUtils.isEmpty(strOptString4) && !android.text.TextUtils.isEmpty(strOptString5) && !strOptString4.equals(strOptString5)) {
                            return true;
                        }
                    } else if (jSONObject2.has("titlecolor")) {
                        java.lang.String strOptString6 = jSONObject2.optString("titlecolor");
                        if (android.text.TextUtils.isEmpty(strOptString4) && !android.text.TextUtils.isEmpty(strOptString6)) {
                            return true;
                        }
                        if (!android.text.TextUtils.isEmpty(strOptString4) && !android.text.TextUtils.isEmpty(strOptString6) && !strOptString4.equals(strOptString6)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static boolean titleIsChanged(org.json.JSONObject jSONObject, org.json.JSONObject jSONObject2) {
        if (jSONObject2 != null && (jSONObject2.has("titleText") || jSONObject2.has("titletext"))) {
            if (jSONObject == null && ((jSONObject2.has("titleText") && !android.text.TextUtils.isEmpty(jSONObject2.optString("titleText"))) || (jSONObject2.has("titletext") && !android.text.TextUtils.isEmpty(jSONObject2.optString("titletext"))))) {
                return true;
            }
            if (jSONObject != null) {
                if (jSONObject.has("titleText")) {
                    java.lang.String strOptString = jSONObject.optString("titleText");
                    if (jSONObject2.has("titleText")) {
                        java.lang.String strOptString2 = jSONObject2.optString("titleText");
                        if ((!android.text.TextUtils.isEmpty(strOptString) || android.text.TextUtils.isEmpty(strOptString2)) && !android.text.TextUtils.isEmpty(strOptString) && !android.text.TextUtils.isEmpty(strOptString2)) {
                            strOptString.equals(strOptString2);
                            return true;
                        }
                    } else if (jSONObject2.has("titletext")) {
                        java.lang.String strOptString3 = jSONObject2.optString("titletext");
                        if ((!android.text.TextUtils.isEmpty(strOptString) || android.text.TextUtils.isEmpty(strOptString3)) && !android.text.TextUtils.isEmpty(strOptString) && !android.text.TextUtils.isEmpty(strOptString3)) {
                            strOptString.equals(strOptString3);
                            return true;
                        }
                    }
                } else if (jSONObject.has("titletext")) {
                    java.lang.String strOptString4 = jSONObject.optString("titletext");
                    if (jSONObject2.has("titleText")) {
                        java.lang.String strOptString5 = jSONObject2.optString("titleText");
                        if ((!android.text.TextUtils.isEmpty(strOptString4) || android.text.TextUtils.isEmpty(strOptString5)) && !android.text.TextUtils.isEmpty(strOptString4) && !android.text.TextUtils.isEmpty(strOptString5)) {
                            strOptString4.equals(strOptString5);
                            return true;
                        }
                    } else if (jSONObject2.has("titletext")) {
                        java.lang.String strOptString6 = jSONObject2.optString("titletext");
                        if ((!android.text.TextUtils.isEmpty(strOptString4) || android.text.TextUtils.isEmpty(strOptString6)) && !android.text.TextUtils.isEmpty(strOptString4) && !android.text.TextUtils.isEmpty(strOptString6)) {
                            strOptString4.equals(strOptString6);
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static void titleNViewButtonBadge(io.dcloud.common.DHInterface.ITitleNView iTitleNView, org.json.JSONObject jSONObject, boolean z) {
        iTitleNView.setBadgeText(jSONObject, z);
    }

    public static void titleNViewButtonRedDot(io.dcloud.common.DHInterface.ITitleNView iTitleNView, org.json.JSONObject jSONObject, boolean z) {
        iTitleNView.setRedDot(jSONObject, z);
    }

    public static boolean titleNViewStyleNoTitle(org.json.JSONObject jSONObject) {
        if (jSONObject == null) {
            return true;
        }
        if (!jSONObject.has("titleText") && !jSONObject.has("titletext")) {
            return true;
        }
        if (jSONObject.has("titleText")) {
            return android.text.TextUtils.isEmpty(jSONObject.optString("titleText"));
        }
        return jSONObject.has("titletext") && android.text.TextUtils.isEmpty(jSONObject.optString("titletext"));
    }

    public static boolean titleOverflowIsChanged(org.json.JSONObject jSONObject, org.json.JSONObject jSONObject2) {
        if (jSONObject2 != null && jSONObject2.has("titleOverflow")) {
            if (jSONObject == null && jSONObject2.has("titleOverflow") && !android.text.TextUtils.isEmpty(jSONObject2.optString("titleOverflow"))) {
                return true;
            }
            if (jSONObject != null) {
                if (jSONObject.has("titleOverflow")) {
                    if (jSONObject.has("titleOverflow")) {
                        java.lang.String strOptString = jSONObject.optString("titleOverflow");
                        if (jSONObject2.has("titleOverflow")) {
                            java.lang.String strOptString2 = jSONObject2.optString("titleOverflow");
                            if (android.text.TextUtils.isEmpty(strOptString) && !android.text.TextUtils.isEmpty(strOptString2)) {
                                return true;
                            }
                            if (!android.text.TextUtils.isEmpty(strOptString) && !android.text.TextUtils.isEmpty(strOptString2) && !strOptString.equals(strOptString2)) {
                                return true;
                            }
                        }
                    }
                } else if (jSONObject2.has("titleOverflow") && !android.text.TextUtils.isEmpty(jSONObject2.optString("titleOverflow"))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean titleSizeIsChanged(org.json.JSONObject jSONObject, org.json.JSONObject jSONObject2) {
        if (jSONObject2 != null && (jSONObject2.has("titleSize") || jSONObject2.has("titlesize"))) {
            if (jSONObject == null && ((jSONObject2.has("titleSize") && !android.text.TextUtils.isEmpty(jSONObject2.optString("titleSize"))) || (jSONObject2.has("titlesize") && !android.text.TextUtils.isEmpty(jSONObject2.optString("titlesize"))))) {
                return true;
            }
            if (jSONObject != null) {
                if (jSONObject.has("titleSize")) {
                    java.lang.String strOptString = jSONObject.optString("titleSize");
                    if (jSONObject2.has("titleSize")) {
                        java.lang.String strOptString2 = jSONObject2.optString("titleSize");
                        if (android.text.TextUtils.isEmpty(strOptString) && !android.text.TextUtils.isEmpty(strOptString2)) {
                            return true;
                        }
                        if (!android.text.TextUtils.isEmpty(strOptString) && !android.text.TextUtils.isEmpty(strOptString2) && !strOptString.equals(strOptString2)) {
                            return true;
                        }
                    } else if (jSONObject2.has("titlesize")) {
                        java.lang.String strOptString3 = jSONObject2.optString("titlesize");
                        if (android.text.TextUtils.isEmpty(strOptString) && !android.text.TextUtils.isEmpty(strOptString3)) {
                            return true;
                        }
                        if (!android.text.TextUtils.isEmpty(strOptString) && !android.text.TextUtils.isEmpty(strOptString3) && !strOptString.equals(strOptString3)) {
                            return true;
                        }
                    }
                } else if (jSONObject.has("titlesize")) {
                    java.lang.String strOptString4 = jSONObject.optString("titlesize");
                    if (jSONObject2.has("titleSize")) {
                        java.lang.String strOptString5 = jSONObject2.optString("titleSize");
                        if (android.text.TextUtils.isEmpty(strOptString4) && !android.text.TextUtils.isEmpty(strOptString5)) {
                            return true;
                        }
                        if (!android.text.TextUtils.isEmpty(strOptString4) && !android.text.TextUtils.isEmpty(strOptString5) && !strOptString4.equals(strOptString5)) {
                            return true;
                        }
                    } else if (jSONObject2.has("titlesize")) {
                        java.lang.String strOptString6 = jSONObject2.optString("titlesize");
                        if (android.text.TextUtils.isEmpty(strOptString4) && !android.text.TextUtils.isEmpty(strOptString6)) {
                            return true;
                        }
                        if (!android.text.TextUtils.isEmpty(strOptString4) && !android.text.TextUtils.isEmpty(strOptString6) && !strOptString4.equals(strOptString6)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:102:0x01e0 A[Catch: Exception -> 0x02d4, TryCatch #1 {Exception -> 0x02d4, blocks: (B:4:0x000e, B:6:0x0031, B:11:0x0042, B:13:0x0050, B:15:0x0058, B:17:0x0062, B:21:0x006e, B:26:0x007c, B:41:0x00d0, B:42:0x00d3, B:44:0x00d8, B:51:0x00e8, B:50:0x00e5, B:53:0x00f4, B:56:0x0106, B:58:0x010c, B:60:0x0112, B:62:0x0118, B:65:0x0137, B:67:0x013d, B:69:0x0143, B:74:0x015f, B:76:0x016d, B:78:0x0173, B:80:0x0179, B:82:0x0187, B:83:0x018c, B:85:0x0192, B:87:0x0199, B:90:0x01b0, B:92:0x01b6, B:94:0x01bc, B:96:0x01ca, B:100:0x01da, B:97:0x01d0, B:99:0x01d6, B:101:0x01dd, B:102:0x01e0, B:104:0x01f2, B:106:0x01f8, B:108:0x01fe, B:110:0x0204, B:112:0x0212, B:116:0x0222, B:118:0x0229, B:120:0x023c, B:122:0x0247, B:124:0x0256, B:126:0x026f, B:129:0x0276, B:131:0x027c, B:133:0x0282, B:135:0x0290, B:139:0x02a6, B:143:0x02b7, B:145:0x02c2, B:146:0x02ca, B:142:0x02b3, B:136:0x0299, B:138:0x02a2, B:125:0x0265, B:121:0x0244, B:113:0x0218, B:115:0x021e, B:27:0x008e, B:29:0x0094, B:31:0x00a2, B:33:0x00af, B:35:0x00b5, B:39:0x00c6, B:38:0x00c2, B:8:0x0037, B:10:0x003d, B:47:0x00e0, B:140:0x02ae), top: B:154:0x000e, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:104:0x01f2 A[Catch: Exception -> 0x02d4, TryCatch #1 {Exception -> 0x02d4, blocks: (B:4:0x000e, B:6:0x0031, B:11:0x0042, B:13:0x0050, B:15:0x0058, B:17:0x0062, B:21:0x006e, B:26:0x007c, B:41:0x00d0, B:42:0x00d3, B:44:0x00d8, B:51:0x00e8, B:50:0x00e5, B:53:0x00f4, B:56:0x0106, B:58:0x010c, B:60:0x0112, B:62:0x0118, B:65:0x0137, B:67:0x013d, B:69:0x0143, B:74:0x015f, B:76:0x016d, B:78:0x0173, B:80:0x0179, B:82:0x0187, B:83:0x018c, B:85:0x0192, B:87:0x0199, B:90:0x01b0, B:92:0x01b6, B:94:0x01bc, B:96:0x01ca, B:100:0x01da, B:97:0x01d0, B:99:0x01d6, B:101:0x01dd, B:102:0x01e0, B:104:0x01f2, B:106:0x01f8, B:108:0x01fe, B:110:0x0204, B:112:0x0212, B:116:0x0222, B:118:0x0229, B:120:0x023c, B:122:0x0247, B:124:0x0256, B:126:0x026f, B:129:0x0276, B:131:0x027c, B:133:0x0282, B:135:0x0290, B:139:0x02a6, B:143:0x02b7, B:145:0x02c2, B:146:0x02ca, B:142:0x02b3, B:136:0x0299, B:138:0x02a2, B:125:0x0265, B:121:0x0244, B:113:0x0218, B:115:0x021e, B:27:0x008e, B:29:0x0094, B:31:0x00a2, B:33:0x00af, B:35:0x00b5, B:39:0x00c6, B:38:0x00c2, B:8:0x0037, B:10:0x003d, B:47:0x00e0, B:140:0x02ae), top: B:154:0x000e, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:107:0x01fd  */
    /* JADX WARN: Code duplicated, block: B:110:0x0204 A[Catch: Exception -> 0x02d4, TryCatch #1 {Exception -> 0x02d4, blocks: (B:4:0x000e, B:6:0x0031, B:11:0x0042, B:13:0x0050, B:15:0x0058, B:17:0x0062, B:21:0x006e, B:26:0x007c, B:41:0x00d0, B:42:0x00d3, B:44:0x00d8, B:51:0x00e8, B:50:0x00e5, B:53:0x00f4, B:56:0x0106, B:58:0x010c, B:60:0x0112, B:62:0x0118, B:65:0x0137, B:67:0x013d, B:69:0x0143, B:74:0x015f, B:76:0x016d, B:78:0x0173, B:80:0x0179, B:82:0x0187, B:83:0x018c, B:85:0x0192, B:87:0x0199, B:90:0x01b0, B:92:0x01b6, B:94:0x01bc, B:96:0x01ca, B:100:0x01da, B:97:0x01d0, B:99:0x01d6, B:101:0x01dd, B:102:0x01e0, B:104:0x01f2, B:106:0x01f8, B:108:0x01fe, B:110:0x0204, B:112:0x0212, B:116:0x0222, B:118:0x0229, B:120:0x023c, B:122:0x0247, B:124:0x0256, B:126:0x026f, B:129:0x0276, B:131:0x027c, B:133:0x0282, B:135:0x0290, B:139:0x02a6, B:143:0x02b7, B:145:0x02c2, B:146:0x02ca, B:142:0x02b3, B:136:0x0299, B:138:0x02a2, B:125:0x0265, B:121:0x0244, B:113:0x0218, B:115:0x021e, B:27:0x008e, B:29:0x0094, B:31:0x00a2, B:33:0x00af, B:35:0x00b5, B:39:0x00c6, B:38:0x00c2, B:8:0x0037, B:10:0x003d, B:47:0x00e0, B:140:0x02ae), top: B:154:0x000e, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:112:0x0212 A[Catch: Exception -> 0x02d4, TryCatch #1 {Exception -> 0x02d4, blocks: (B:4:0x000e, B:6:0x0031, B:11:0x0042, B:13:0x0050, B:15:0x0058, B:17:0x0062, B:21:0x006e, B:26:0x007c, B:41:0x00d0, B:42:0x00d3, B:44:0x00d8, B:51:0x00e8, B:50:0x00e5, B:53:0x00f4, B:56:0x0106, B:58:0x010c, B:60:0x0112, B:62:0x0118, B:65:0x0137, B:67:0x013d, B:69:0x0143, B:74:0x015f, B:76:0x016d, B:78:0x0173, B:80:0x0179, B:82:0x0187, B:83:0x018c, B:85:0x0192, B:87:0x0199, B:90:0x01b0, B:92:0x01b6, B:94:0x01bc, B:96:0x01ca, B:100:0x01da, B:97:0x01d0, B:99:0x01d6, B:101:0x01dd, B:102:0x01e0, B:104:0x01f2, B:106:0x01f8, B:108:0x01fe, B:110:0x0204, B:112:0x0212, B:116:0x0222, B:118:0x0229, B:120:0x023c, B:122:0x0247, B:124:0x0256, B:126:0x026f, B:129:0x0276, B:131:0x027c, B:133:0x0282, B:135:0x0290, B:139:0x02a6, B:143:0x02b7, B:145:0x02c2, B:146:0x02ca, B:142:0x02b3, B:136:0x0299, B:138:0x02a2, B:125:0x0265, B:121:0x0244, B:113:0x0218, B:115:0x021e, B:27:0x008e, B:29:0x0094, B:31:0x00a2, B:33:0x00af, B:35:0x00b5, B:39:0x00c6, B:38:0x00c2, B:8:0x0037, B:10:0x003d, B:47:0x00e0, B:140:0x02ae), top: B:154:0x000e, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:113:0x0218 A[Catch: Exception -> 0x02d4, TryCatch #1 {Exception -> 0x02d4, blocks: (B:4:0x000e, B:6:0x0031, B:11:0x0042, B:13:0x0050, B:15:0x0058, B:17:0x0062, B:21:0x006e, B:26:0x007c, B:41:0x00d0, B:42:0x00d3, B:44:0x00d8, B:51:0x00e8, B:50:0x00e5, B:53:0x00f4, B:56:0x0106, B:58:0x010c, B:60:0x0112, B:62:0x0118, B:65:0x0137, B:67:0x013d, B:69:0x0143, B:74:0x015f, B:76:0x016d, B:78:0x0173, B:80:0x0179, B:82:0x0187, B:83:0x018c, B:85:0x0192, B:87:0x0199, B:90:0x01b0, B:92:0x01b6, B:94:0x01bc, B:96:0x01ca, B:100:0x01da, B:97:0x01d0, B:99:0x01d6, B:101:0x01dd, B:102:0x01e0, B:104:0x01f2, B:106:0x01f8, B:108:0x01fe, B:110:0x0204, B:112:0x0212, B:116:0x0222, B:118:0x0229, B:120:0x023c, B:122:0x0247, B:124:0x0256, B:126:0x026f, B:129:0x0276, B:131:0x027c, B:133:0x0282, B:135:0x0290, B:139:0x02a6, B:143:0x02b7, B:145:0x02c2, B:146:0x02ca, B:142:0x02b3, B:136:0x0299, B:138:0x02a2, B:125:0x0265, B:121:0x0244, B:113:0x0218, B:115:0x021e, B:27:0x008e, B:29:0x0094, B:31:0x00a2, B:33:0x00af, B:35:0x00b5, B:39:0x00c6, B:38:0x00c2, B:8:0x0037, B:10:0x003d, B:47:0x00e0, B:140:0x02ae), top: B:154:0x000e, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:115:0x021e A[Catch: Exception -> 0x02d4, TryCatch #1 {Exception -> 0x02d4, blocks: (B:4:0x000e, B:6:0x0031, B:11:0x0042, B:13:0x0050, B:15:0x0058, B:17:0x0062, B:21:0x006e, B:26:0x007c, B:41:0x00d0, B:42:0x00d3, B:44:0x00d8, B:51:0x00e8, B:50:0x00e5, B:53:0x00f4, B:56:0x0106, B:58:0x010c, B:60:0x0112, B:62:0x0118, B:65:0x0137, B:67:0x013d, B:69:0x0143, B:74:0x015f, B:76:0x016d, B:78:0x0173, B:80:0x0179, B:82:0x0187, B:83:0x018c, B:85:0x0192, B:87:0x0199, B:90:0x01b0, B:92:0x01b6, B:94:0x01bc, B:96:0x01ca, B:100:0x01da, B:97:0x01d0, B:99:0x01d6, B:101:0x01dd, B:102:0x01e0, B:104:0x01f2, B:106:0x01f8, B:108:0x01fe, B:110:0x0204, B:112:0x0212, B:116:0x0222, B:118:0x0229, B:120:0x023c, B:122:0x0247, B:124:0x0256, B:126:0x026f, B:129:0x0276, B:131:0x027c, B:133:0x0282, B:135:0x0290, B:139:0x02a6, B:143:0x02b7, B:145:0x02c2, B:146:0x02ca, B:142:0x02b3, B:136:0x0299, B:138:0x02a2, B:125:0x0265, B:121:0x0244, B:113:0x0218, B:115:0x021e, B:27:0x008e, B:29:0x0094, B:31:0x00a2, B:33:0x00af, B:35:0x00b5, B:39:0x00c6, B:38:0x00c2, B:8:0x0037, B:10:0x003d, B:47:0x00e0, B:140:0x02ae), top: B:154:0x000e, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:117:0x0227  */
    /* JADX WARN: Code duplicated, block: B:120:0x023c A[Catch: Exception -> 0x02d4, TryCatch #1 {Exception -> 0x02d4, blocks: (B:4:0x000e, B:6:0x0031, B:11:0x0042, B:13:0x0050, B:15:0x0058, B:17:0x0062, B:21:0x006e, B:26:0x007c, B:41:0x00d0, B:42:0x00d3, B:44:0x00d8, B:51:0x00e8, B:50:0x00e5, B:53:0x00f4, B:56:0x0106, B:58:0x010c, B:60:0x0112, B:62:0x0118, B:65:0x0137, B:67:0x013d, B:69:0x0143, B:74:0x015f, B:76:0x016d, B:78:0x0173, B:80:0x0179, B:82:0x0187, B:83:0x018c, B:85:0x0192, B:87:0x0199, B:90:0x01b0, B:92:0x01b6, B:94:0x01bc, B:96:0x01ca, B:100:0x01da, B:97:0x01d0, B:99:0x01d6, B:101:0x01dd, B:102:0x01e0, B:104:0x01f2, B:106:0x01f8, B:108:0x01fe, B:110:0x0204, B:112:0x0212, B:116:0x0222, B:118:0x0229, B:120:0x023c, B:122:0x0247, B:124:0x0256, B:126:0x026f, B:129:0x0276, B:131:0x027c, B:133:0x0282, B:135:0x0290, B:139:0x02a6, B:143:0x02b7, B:145:0x02c2, B:146:0x02ca, B:142:0x02b3, B:136:0x0299, B:138:0x02a2, B:125:0x0265, B:121:0x0244, B:113:0x0218, B:115:0x021e, B:27:0x008e, B:29:0x0094, B:31:0x00a2, B:33:0x00af, B:35:0x00b5, B:39:0x00c6, B:38:0x00c2, B:8:0x0037, B:10:0x003d, B:47:0x00e0, B:140:0x02ae), top: B:154:0x000e, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:121:0x0244 A[Catch: Exception -> 0x02d4, TryCatch #1 {Exception -> 0x02d4, blocks: (B:4:0x000e, B:6:0x0031, B:11:0x0042, B:13:0x0050, B:15:0x0058, B:17:0x0062, B:21:0x006e, B:26:0x007c, B:41:0x00d0, B:42:0x00d3, B:44:0x00d8, B:51:0x00e8, B:50:0x00e5, B:53:0x00f4, B:56:0x0106, B:58:0x010c, B:60:0x0112, B:62:0x0118, B:65:0x0137, B:67:0x013d, B:69:0x0143, B:74:0x015f, B:76:0x016d, B:78:0x0173, B:80:0x0179, B:82:0x0187, B:83:0x018c, B:85:0x0192, B:87:0x0199, B:90:0x01b0, B:92:0x01b6, B:94:0x01bc, B:96:0x01ca, B:100:0x01da, B:97:0x01d0, B:99:0x01d6, B:101:0x01dd, B:102:0x01e0, B:104:0x01f2, B:106:0x01f8, B:108:0x01fe, B:110:0x0204, B:112:0x0212, B:116:0x0222, B:118:0x0229, B:120:0x023c, B:122:0x0247, B:124:0x0256, B:126:0x026f, B:129:0x0276, B:131:0x027c, B:133:0x0282, B:135:0x0290, B:139:0x02a6, B:143:0x02b7, B:145:0x02c2, B:146:0x02ca, B:142:0x02b3, B:136:0x0299, B:138:0x02a2, B:125:0x0265, B:121:0x0244, B:113:0x0218, B:115:0x021e, B:27:0x008e, B:29:0x0094, B:31:0x00a2, B:33:0x00af, B:35:0x00b5, B:39:0x00c6, B:38:0x00c2, B:8:0x0037, B:10:0x003d, B:47:0x00e0, B:140:0x02ae), top: B:154:0x000e, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:124:0x0256 A[Catch: Exception -> 0x02d4, TryCatch #1 {Exception -> 0x02d4, blocks: (B:4:0x000e, B:6:0x0031, B:11:0x0042, B:13:0x0050, B:15:0x0058, B:17:0x0062, B:21:0x006e, B:26:0x007c, B:41:0x00d0, B:42:0x00d3, B:44:0x00d8, B:51:0x00e8, B:50:0x00e5, B:53:0x00f4, B:56:0x0106, B:58:0x010c, B:60:0x0112, B:62:0x0118, B:65:0x0137, B:67:0x013d, B:69:0x0143, B:74:0x015f, B:76:0x016d, B:78:0x0173, B:80:0x0179, B:82:0x0187, B:83:0x018c, B:85:0x0192, B:87:0x0199, B:90:0x01b0, B:92:0x01b6, B:94:0x01bc, B:96:0x01ca, B:100:0x01da, B:97:0x01d0, B:99:0x01d6, B:101:0x01dd, B:102:0x01e0, B:104:0x01f2, B:106:0x01f8, B:108:0x01fe, B:110:0x0204, B:112:0x0212, B:116:0x0222, B:118:0x0229, B:120:0x023c, B:122:0x0247, B:124:0x0256, B:126:0x026f, B:129:0x0276, B:131:0x027c, B:133:0x0282, B:135:0x0290, B:139:0x02a6, B:143:0x02b7, B:145:0x02c2, B:146:0x02ca, B:142:0x02b3, B:136:0x0299, B:138:0x02a2, B:125:0x0265, B:121:0x0244, B:113:0x0218, B:115:0x021e, B:27:0x008e, B:29:0x0094, B:31:0x00a2, B:33:0x00af, B:35:0x00b5, B:39:0x00c6, B:38:0x00c2, B:8:0x0037, B:10:0x003d, B:47:0x00e0, B:140:0x02ae), top: B:154:0x000e, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:125:0x0265 A[Catch: Exception -> 0x02d4, TryCatch #1 {Exception -> 0x02d4, blocks: (B:4:0x000e, B:6:0x0031, B:11:0x0042, B:13:0x0050, B:15:0x0058, B:17:0x0062, B:21:0x006e, B:26:0x007c, B:41:0x00d0, B:42:0x00d3, B:44:0x00d8, B:51:0x00e8, B:50:0x00e5, B:53:0x00f4, B:56:0x0106, B:58:0x010c, B:60:0x0112, B:62:0x0118, B:65:0x0137, B:67:0x013d, B:69:0x0143, B:74:0x015f, B:76:0x016d, B:78:0x0173, B:80:0x0179, B:82:0x0187, B:83:0x018c, B:85:0x0192, B:87:0x0199, B:90:0x01b0, B:92:0x01b6, B:94:0x01bc, B:96:0x01ca, B:100:0x01da, B:97:0x01d0, B:99:0x01d6, B:101:0x01dd, B:102:0x01e0, B:104:0x01f2, B:106:0x01f8, B:108:0x01fe, B:110:0x0204, B:112:0x0212, B:116:0x0222, B:118:0x0229, B:120:0x023c, B:122:0x0247, B:124:0x0256, B:126:0x026f, B:129:0x0276, B:131:0x027c, B:133:0x0282, B:135:0x0290, B:139:0x02a6, B:143:0x02b7, B:145:0x02c2, B:146:0x02ca, B:142:0x02b3, B:136:0x0299, B:138:0x02a2, B:125:0x0265, B:121:0x0244, B:113:0x0218, B:115:0x021e, B:27:0x008e, B:29:0x0094, B:31:0x00a2, B:33:0x00af, B:35:0x00b5, B:39:0x00c6, B:38:0x00c2, B:8:0x0037, B:10:0x003d, B:47:0x00e0, B:140:0x02ae), top: B:154:0x000e, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:128:0x0275  */
    /* JADX WARN: Code duplicated, block: B:131:0x027c A[Catch: Exception -> 0x02d4, TryCatch #1 {Exception -> 0x02d4, blocks: (B:4:0x000e, B:6:0x0031, B:11:0x0042, B:13:0x0050, B:15:0x0058, B:17:0x0062, B:21:0x006e, B:26:0x007c, B:41:0x00d0, B:42:0x00d3, B:44:0x00d8, B:51:0x00e8, B:50:0x00e5, B:53:0x00f4, B:56:0x0106, B:58:0x010c, B:60:0x0112, B:62:0x0118, B:65:0x0137, B:67:0x013d, B:69:0x0143, B:74:0x015f, B:76:0x016d, B:78:0x0173, B:80:0x0179, B:82:0x0187, B:83:0x018c, B:85:0x0192, B:87:0x0199, B:90:0x01b0, B:92:0x01b6, B:94:0x01bc, B:96:0x01ca, B:100:0x01da, B:97:0x01d0, B:99:0x01d6, B:101:0x01dd, B:102:0x01e0, B:104:0x01f2, B:106:0x01f8, B:108:0x01fe, B:110:0x0204, B:112:0x0212, B:116:0x0222, B:118:0x0229, B:120:0x023c, B:122:0x0247, B:124:0x0256, B:126:0x026f, B:129:0x0276, B:131:0x027c, B:133:0x0282, B:135:0x0290, B:139:0x02a6, B:143:0x02b7, B:145:0x02c2, B:146:0x02ca, B:142:0x02b3, B:136:0x0299, B:138:0x02a2, B:125:0x0265, B:121:0x0244, B:113:0x0218, B:115:0x021e, B:27:0x008e, B:29:0x0094, B:31:0x00a2, B:33:0x00af, B:35:0x00b5, B:39:0x00c6, B:38:0x00c2, B:8:0x0037, B:10:0x003d, B:47:0x00e0, B:140:0x02ae), top: B:154:0x000e, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:133:0x0282 A[Catch: Exception -> 0x02d4, TryCatch #1 {Exception -> 0x02d4, blocks: (B:4:0x000e, B:6:0x0031, B:11:0x0042, B:13:0x0050, B:15:0x0058, B:17:0x0062, B:21:0x006e, B:26:0x007c, B:41:0x00d0, B:42:0x00d3, B:44:0x00d8, B:51:0x00e8, B:50:0x00e5, B:53:0x00f4, B:56:0x0106, B:58:0x010c, B:60:0x0112, B:62:0x0118, B:65:0x0137, B:67:0x013d, B:69:0x0143, B:74:0x015f, B:76:0x016d, B:78:0x0173, B:80:0x0179, B:82:0x0187, B:83:0x018c, B:85:0x0192, B:87:0x0199, B:90:0x01b0, B:92:0x01b6, B:94:0x01bc, B:96:0x01ca, B:100:0x01da, B:97:0x01d0, B:99:0x01d6, B:101:0x01dd, B:102:0x01e0, B:104:0x01f2, B:106:0x01f8, B:108:0x01fe, B:110:0x0204, B:112:0x0212, B:116:0x0222, B:118:0x0229, B:120:0x023c, B:122:0x0247, B:124:0x0256, B:126:0x026f, B:129:0x0276, B:131:0x027c, B:133:0x0282, B:135:0x0290, B:139:0x02a6, B:143:0x02b7, B:145:0x02c2, B:146:0x02ca, B:142:0x02b3, B:136:0x0299, B:138:0x02a2, B:125:0x0265, B:121:0x0244, B:113:0x0218, B:115:0x021e, B:27:0x008e, B:29:0x0094, B:31:0x00a2, B:33:0x00af, B:35:0x00b5, B:39:0x00c6, B:38:0x00c2, B:8:0x0037, B:10:0x003d, B:47:0x00e0, B:140:0x02ae), top: B:154:0x000e, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:135:0x0290 A[Catch: Exception -> 0x02d4, TryCatch #1 {Exception -> 0x02d4, blocks: (B:4:0x000e, B:6:0x0031, B:11:0x0042, B:13:0x0050, B:15:0x0058, B:17:0x0062, B:21:0x006e, B:26:0x007c, B:41:0x00d0, B:42:0x00d3, B:44:0x00d8, B:51:0x00e8, B:50:0x00e5, B:53:0x00f4, B:56:0x0106, B:58:0x010c, B:60:0x0112, B:62:0x0118, B:65:0x0137, B:67:0x013d, B:69:0x0143, B:74:0x015f, B:76:0x016d, B:78:0x0173, B:80:0x0179, B:82:0x0187, B:83:0x018c, B:85:0x0192, B:87:0x0199, B:90:0x01b0, B:92:0x01b6, B:94:0x01bc, B:96:0x01ca, B:100:0x01da, B:97:0x01d0, B:99:0x01d6, B:101:0x01dd, B:102:0x01e0, B:104:0x01f2, B:106:0x01f8, B:108:0x01fe, B:110:0x0204, B:112:0x0212, B:116:0x0222, B:118:0x0229, B:120:0x023c, B:122:0x0247, B:124:0x0256, B:126:0x026f, B:129:0x0276, B:131:0x027c, B:133:0x0282, B:135:0x0290, B:139:0x02a6, B:143:0x02b7, B:145:0x02c2, B:146:0x02ca, B:142:0x02b3, B:136:0x0299, B:138:0x02a2, B:125:0x0265, B:121:0x0244, B:113:0x0218, B:115:0x021e, B:27:0x008e, B:29:0x0094, B:31:0x00a2, B:33:0x00af, B:35:0x00b5, B:39:0x00c6, B:38:0x00c2, B:8:0x0037, B:10:0x003d, B:47:0x00e0, B:140:0x02ae), top: B:154:0x000e, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:136:0x0299 A[Catch: Exception -> 0x02d4, TryCatch #1 {Exception -> 0x02d4, blocks: (B:4:0x000e, B:6:0x0031, B:11:0x0042, B:13:0x0050, B:15:0x0058, B:17:0x0062, B:21:0x006e, B:26:0x007c, B:41:0x00d0, B:42:0x00d3, B:44:0x00d8, B:51:0x00e8, B:50:0x00e5, B:53:0x00f4, B:56:0x0106, B:58:0x010c, B:60:0x0112, B:62:0x0118, B:65:0x0137, B:67:0x013d, B:69:0x0143, B:74:0x015f, B:76:0x016d, B:78:0x0173, B:80:0x0179, B:82:0x0187, B:83:0x018c, B:85:0x0192, B:87:0x0199, B:90:0x01b0, B:92:0x01b6, B:94:0x01bc, B:96:0x01ca, B:100:0x01da, B:97:0x01d0, B:99:0x01d6, B:101:0x01dd, B:102:0x01e0, B:104:0x01f2, B:106:0x01f8, B:108:0x01fe, B:110:0x0204, B:112:0x0212, B:116:0x0222, B:118:0x0229, B:120:0x023c, B:122:0x0247, B:124:0x0256, B:126:0x026f, B:129:0x0276, B:131:0x027c, B:133:0x0282, B:135:0x0290, B:139:0x02a6, B:143:0x02b7, B:145:0x02c2, B:146:0x02ca, B:142:0x02b3, B:136:0x0299, B:138:0x02a2, B:125:0x0265, B:121:0x0244, B:113:0x0218, B:115:0x021e, B:27:0x008e, B:29:0x0094, B:31:0x00a2, B:33:0x00af, B:35:0x00b5, B:39:0x00c6, B:38:0x00c2, B:8:0x0037, B:10:0x003d, B:47:0x00e0, B:140:0x02ae), top: B:154:0x000e, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:138:0x02a2 A[Catch: Exception -> 0x02d4, TryCatch #1 {Exception -> 0x02d4, blocks: (B:4:0x000e, B:6:0x0031, B:11:0x0042, B:13:0x0050, B:15:0x0058, B:17:0x0062, B:21:0x006e, B:26:0x007c, B:41:0x00d0, B:42:0x00d3, B:44:0x00d8, B:51:0x00e8, B:50:0x00e5, B:53:0x00f4, B:56:0x0106, B:58:0x010c, B:60:0x0112, B:62:0x0118, B:65:0x0137, B:67:0x013d, B:69:0x0143, B:74:0x015f, B:76:0x016d, B:78:0x0173, B:80:0x0179, B:82:0x0187, B:83:0x018c, B:85:0x0192, B:87:0x0199, B:90:0x01b0, B:92:0x01b6, B:94:0x01bc, B:96:0x01ca, B:100:0x01da, B:97:0x01d0, B:99:0x01d6, B:101:0x01dd, B:102:0x01e0, B:104:0x01f2, B:106:0x01f8, B:108:0x01fe, B:110:0x0204, B:112:0x0212, B:116:0x0222, B:118:0x0229, B:120:0x023c, B:122:0x0247, B:124:0x0256, B:126:0x026f, B:129:0x0276, B:131:0x027c, B:133:0x0282, B:135:0x0290, B:139:0x02a6, B:143:0x02b7, B:145:0x02c2, B:146:0x02ca, B:142:0x02b3, B:136:0x0299, B:138:0x02a2, B:125:0x0265, B:121:0x0244, B:113:0x0218, B:115:0x021e, B:27:0x008e, B:29:0x0094, B:31:0x00a2, B:33:0x00af, B:35:0x00b5, B:39:0x00c6, B:38:0x00c2, B:8:0x0037, B:10:0x003d, B:47:0x00e0, B:140:0x02ae), top: B:154:0x000e, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:145:0x02c2 A[Catch: Exception -> 0x02d4, TryCatch #1 {Exception -> 0x02d4, blocks: (B:4:0x000e, B:6:0x0031, B:11:0x0042, B:13:0x0050, B:15:0x0058, B:17:0x0062, B:21:0x006e, B:26:0x007c, B:41:0x00d0, B:42:0x00d3, B:44:0x00d8, B:51:0x00e8, B:50:0x00e5, B:53:0x00f4, B:56:0x0106, B:58:0x010c, B:60:0x0112, B:62:0x0118, B:65:0x0137, B:67:0x013d, B:69:0x0143, B:74:0x015f, B:76:0x016d, B:78:0x0173, B:80:0x0179, B:82:0x0187, B:83:0x018c, B:85:0x0192, B:87:0x0199, B:90:0x01b0, B:92:0x01b6, B:94:0x01bc, B:96:0x01ca, B:100:0x01da, B:97:0x01d0, B:99:0x01d6, B:101:0x01dd, B:102:0x01e0, B:104:0x01f2, B:106:0x01f8, B:108:0x01fe, B:110:0x0204, B:112:0x0212, B:116:0x0222, B:118:0x0229, B:120:0x023c, B:122:0x0247, B:124:0x0256, B:126:0x026f, B:129:0x0276, B:131:0x027c, B:133:0x0282, B:135:0x0290, B:139:0x02a6, B:143:0x02b7, B:145:0x02c2, B:146:0x02ca, B:142:0x02b3, B:136:0x0299, B:138:0x02a2, B:125:0x0265, B:121:0x0244, B:113:0x0218, B:115:0x021e, B:27:0x008e, B:29:0x0094, B:31:0x00a2, B:33:0x00af, B:35:0x00b5, B:39:0x00c6, B:38:0x00c2, B:8:0x0037, B:10:0x003d, B:47:0x00e0, B:140:0x02ae), top: B:154:0x000e, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:146:0x02ca A[Catch: Exception -> 0x02d4, TRY_LEAVE, TryCatch #1 {Exception -> 0x02d4, blocks: (B:4:0x000e, B:6:0x0031, B:11:0x0042, B:13:0x0050, B:15:0x0058, B:17:0x0062, B:21:0x006e, B:26:0x007c, B:41:0x00d0, B:42:0x00d3, B:44:0x00d8, B:51:0x00e8, B:50:0x00e5, B:53:0x00f4, B:56:0x0106, B:58:0x010c, B:60:0x0112, B:62:0x0118, B:65:0x0137, B:67:0x013d, B:69:0x0143, B:74:0x015f, B:76:0x016d, B:78:0x0173, B:80:0x0179, B:82:0x0187, B:83:0x018c, B:85:0x0192, B:87:0x0199, B:90:0x01b0, B:92:0x01b6, B:94:0x01bc, B:96:0x01ca, B:100:0x01da, B:97:0x01d0, B:99:0x01d6, B:101:0x01dd, B:102:0x01e0, B:104:0x01f2, B:106:0x01f8, B:108:0x01fe, B:110:0x0204, B:112:0x0212, B:116:0x0222, B:118:0x0229, B:120:0x023c, B:122:0x0247, B:124:0x0256, B:126:0x026f, B:129:0x0276, B:131:0x027c, B:133:0x0282, B:135:0x0290, B:139:0x02a6, B:143:0x02b7, B:145:0x02c2, B:146:0x02ca, B:142:0x02b3, B:136:0x0299, B:138:0x02a2, B:125:0x0265, B:121:0x0244, B:113:0x0218, B:115:0x021e, B:27:0x008e, B:29:0x0094, B:31:0x00a2, B:33:0x00af, B:35:0x00b5, B:39:0x00c6, B:38:0x00c2, B:8:0x0037, B:10:0x003d, B:47:0x00e0, B:140:0x02ae), top: B:154:0x000e, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:148:0x02ce  */
    /* JADX WARN: Code duplicated, block: B:152:0x00e0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:159:0x0154 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:162:0x01dd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:167:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:168:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:169:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:20:0x006d  */
    /* JADX WARN: Code duplicated, block: B:23:0x0074  */
    /* JADX WARN: Code duplicated, block: B:26:0x007c A[Catch: Exception -> 0x02d4, TryCatch #1 {Exception -> 0x02d4, blocks: (B:4:0x000e, B:6:0x0031, B:11:0x0042, B:13:0x0050, B:15:0x0058, B:17:0x0062, B:21:0x006e, B:26:0x007c, B:41:0x00d0, B:42:0x00d3, B:44:0x00d8, B:51:0x00e8, B:50:0x00e5, B:53:0x00f4, B:56:0x0106, B:58:0x010c, B:60:0x0112, B:62:0x0118, B:65:0x0137, B:67:0x013d, B:69:0x0143, B:74:0x015f, B:76:0x016d, B:78:0x0173, B:80:0x0179, B:82:0x0187, B:83:0x018c, B:85:0x0192, B:87:0x0199, B:90:0x01b0, B:92:0x01b6, B:94:0x01bc, B:96:0x01ca, B:100:0x01da, B:97:0x01d0, B:99:0x01d6, B:101:0x01dd, B:102:0x01e0, B:104:0x01f2, B:106:0x01f8, B:108:0x01fe, B:110:0x0204, B:112:0x0212, B:116:0x0222, B:118:0x0229, B:120:0x023c, B:122:0x0247, B:124:0x0256, B:126:0x026f, B:129:0x0276, B:131:0x027c, B:133:0x0282, B:135:0x0290, B:139:0x02a6, B:143:0x02b7, B:145:0x02c2, B:146:0x02ca, B:142:0x02b3, B:136:0x0299, B:138:0x02a2, B:125:0x0265, B:121:0x0244, B:113:0x0218, B:115:0x021e, B:27:0x008e, B:29:0x0094, B:31:0x00a2, B:33:0x00af, B:35:0x00b5, B:39:0x00c6, B:38:0x00c2, B:8:0x0037, B:10:0x003d, B:47:0x00e0, B:140:0x02ae), top: B:154:0x000e, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:27:0x008e A[Catch: Exception -> 0x02d4, TryCatch #1 {Exception -> 0x02d4, blocks: (B:4:0x000e, B:6:0x0031, B:11:0x0042, B:13:0x0050, B:15:0x0058, B:17:0x0062, B:21:0x006e, B:26:0x007c, B:41:0x00d0, B:42:0x00d3, B:44:0x00d8, B:51:0x00e8, B:50:0x00e5, B:53:0x00f4, B:56:0x0106, B:58:0x010c, B:60:0x0112, B:62:0x0118, B:65:0x0137, B:67:0x013d, B:69:0x0143, B:74:0x015f, B:76:0x016d, B:78:0x0173, B:80:0x0179, B:82:0x0187, B:83:0x018c, B:85:0x0192, B:87:0x0199, B:90:0x01b0, B:92:0x01b6, B:94:0x01bc, B:96:0x01ca, B:100:0x01da, B:97:0x01d0, B:99:0x01d6, B:101:0x01dd, B:102:0x01e0, B:104:0x01f2, B:106:0x01f8, B:108:0x01fe, B:110:0x0204, B:112:0x0212, B:116:0x0222, B:118:0x0229, B:120:0x023c, B:122:0x0247, B:124:0x0256, B:126:0x026f, B:129:0x0276, B:131:0x027c, B:133:0x0282, B:135:0x0290, B:139:0x02a6, B:143:0x02b7, B:145:0x02c2, B:146:0x02ca, B:142:0x02b3, B:136:0x0299, B:138:0x02a2, B:125:0x0265, B:121:0x0244, B:113:0x0218, B:115:0x021e, B:27:0x008e, B:29:0x0094, B:31:0x00a2, B:33:0x00af, B:35:0x00b5, B:39:0x00c6, B:38:0x00c2, B:8:0x0037, B:10:0x003d, B:47:0x00e0, B:140:0x02ae), top: B:154:0x000e, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x0094 A[Catch: Exception -> 0x02d4, TryCatch #1 {Exception -> 0x02d4, blocks: (B:4:0x000e, B:6:0x0031, B:11:0x0042, B:13:0x0050, B:15:0x0058, B:17:0x0062, B:21:0x006e, B:26:0x007c, B:41:0x00d0, B:42:0x00d3, B:44:0x00d8, B:51:0x00e8, B:50:0x00e5, B:53:0x00f4, B:56:0x0106, B:58:0x010c, B:60:0x0112, B:62:0x0118, B:65:0x0137, B:67:0x013d, B:69:0x0143, B:74:0x015f, B:76:0x016d, B:78:0x0173, B:80:0x0179, B:82:0x0187, B:83:0x018c, B:85:0x0192, B:87:0x0199, B:90:0x01b0, B:92:0x01b6, B:94:0x01bc, B:96:0x01ca, B:100:0x01da, B:97:0x01d0, B:99:0x01d6, B:101:0x01dd, B:102:0x01e0, B:104:0x01f2, B:106:0x01f8, B:108:0x01fe, B:110:0x0204, B:112:0x0212, B:116:0x0222, B:118:0x0229, B:120:0x023c, B:122:0x0247, B:124:0x0256, B:126:0x026f, B:129:0x0276, B:131:0x027c, B:133:0x0282, B:135:0x0290, B:139:0x02a6, B:143:0x02b7, B:145:0x02c2, B:146:0x02ca, B:142:0x02b3, B:136:0x0299, B:138:0x02a2, B:125:0x0265, B:121:0x0244, B:113:0x0218, B:115:0x021e, B:27:0x008e, B:29:0x0094, B:31:0x00a2, B:33:0x00af, B:35:0x00b5, B:39:0x00c6, B:38:0x00c2, B:8:0x0037, B:10:0x003d, B:47:0x00e0, B:140:0x02ae), top: B:154:0x000e, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:31:0x00a2 A[Catch: Exception -> 0x02d4, TryCatch #1 {Exception -> 0x02d4, blocks: (B:4:0x000e, B:6:0x0031, B:11:0x0042, B:13:0x0050, B:15:0x0058, B:17:0x0062, B:21:0x006e, B:26:0x007c, B:41:0x00d0, B:42:0x00d3, B:44:0x00d8, B:51:0x00e8, B:50:0x00e5, B:53:0x00f4, B:56:0x0106, B:58:0x010c, B:60:0x0112, B:62:0x0118, B:65:0x0137, B:67:0x013d, B:69:0x0143, B:74:0x015f, B:76:0x016d, B:78:0x0173, B:80:0x0179, B:82:0x0187, B:83:0x018c, B:85:0x0192, B:87:0x0199, B:90:0x01b0, B:92:0x01b6, B:94:0x01bc, B:96:0x01ca, B:100:0x01da, B:97:0x01d0, B:99:0x01d6, B:101:0x01dd, B:102:0x01e0, B:104:0x01f2, B:106:0x01f8, B:108:0x01fe, B:110:0x0204, B:112:0x0212, B:116:0x0222, B:118:0x0229, B:120:0x023c, B:122:0x0247, B:124:0x0256, B:126:0x026f, B:129:0x0276, B:131:0x027c, B:133:0x0282, B:135:0x0290, B:139:0x02a6, B:143:0x02b7, B:145:0x02c2, B:146:0x02ca, B:142:0x02b3, B:136:0x0299, B:138:0x02a2, B:125:0x0265, B:121:0x0244, B:113:0x0218, B:115:0x021e, B:27:0x008e, B:29:0x0094, B:31:0x00a2, B:33:0x00af, B:35:0x00b5, B:39:0x00c6, B:38:0x00c2, B:8:0x0037, B:10:0x003d, B:47:0x00e0, B:140:0x02ae), top: B:154:0x000e, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:33:0x00af A[Catch: Exception -> 0x02d4, TryCatch #1 {Exception -> 0x02d4, blocks: (B:4:0x000e, B:6:0x0031, B:11:0x0042, B:13:0x0050, B:15:0x0058, B:17:0x0062, B:21:0x006e, B:26:0x007c, B:41:0x00d0, B:42:0x00d3, B:44:0x00d8, B:51:0x00e8, B:50:0x00e5, B:53:0x00f4, B:56:0x0106, B:58:0x010c, B:60:0x0112, B:62:0x0118, B:65:0x0137, B:67:0x013d, B:69:0x0143, B:74:0x015f, B:76:0x016d, B:78:0x0173, B:80:0x0179, B:82:0x0187, B:83:0x018c, B:85:0x0192, B:87:0x0199, B:90:0x01b0, B:92:0x01b6, B:94:0x01bc, B:96:0x01ca, B:100:0x01da, B:97:0x01d0, B:99:0x01d6, B:101:0x01dd, B:102:0x01e0, B:104:0x01f2, B:106:0x01f8, B:108:0x01fe, B:110:0x0204, B:112:0x0212, B:116:0x0222, B:118:0x0229, B:120:0x023c, B:122:0x0247, B:124:0x0256, B:126:0x026f, B:129:0x0276, B:131:0x027c, B:133:0x0282, B:135:0x0290, B:139:0x02a6, B:143:0x02b7, B:145:0x02c2, B:146:0x02ca, B:142:0x02b3, B:136:0x0299, B:138:0x02a2, B:125:0x0265, B:121:0x0244, B:113:0x0218, B:115:0x021e, B:27:0x008e, B:29:0x0094, B:31:0x00a2, B:33:0x00af, B:35:0x00b5, B:39:0x00c6, B:38:0x00c2, B:8:0x0037, B:10:0x003d, B:47:0x00e0, B:140:0x02ae), top: B:154:0x000e, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:38:0x00c2 A[Catch: Exception -> 0x02d4, TryCatch #1 {Exception -> 0x02d4, blocks: (B:4:0x000e, B:6:0x0031, B:11:0x0042, B:13:0x0050, B:15:0x0058, B:17:0x0062, B:21:0x006e, B:26:0x007c, B:41:0x00d0, B:42:0x00d3, B:44:0x00d8, B:51:0x00e8, B:50:0x00e5, B:53:0x00f4, B:56:0x0106, B:58:0x010c, B:60:0x0112, B:62:0x0118, B:65:0x0137, B:67:0x013d, B:69:0x0143, B:74:0x015f, B:76:0x016d, B:78:0x0173, B:80:0x0179, B:82:0x0187, B:83:0x018c, B:85:0x0192, B:87:0x0199, B:90:0x01b0, B:92:0x01b6, B:94:0x01bc, B:96:0x01ca, B:100:0x01da, B:97:0x01d0, B:99:0x01d6, B:101:0x01dd, B:102:0x01e0, B:104:0x01f2, B:106:0x01f8, B:108:0x01fe, B:110:0x0204, B:112:0x0212, B:116:0x0222, B:118:0x0229, B:120:0x023c, B:122:0x0247, B:124:0x0256, B:126:0x026f, B:129:0x0276, B:131:0x027c, B:133:0x0282, B:135:0x0290, B:139:0x02a6, B:143:0x02b7, B:145:0x02c2, B:146:0x02ca, B:142:0x02b3, B:136:0x0299, B:138:0x02a2, B:125:0x0265, B:121:0x0244, B:113:0x0218, B:115:0x021e, B:27:0x008e, B:29:0x0094, B:31:0x00a2, B:33:0x00af, B:35:0x00b5, B:39:0x00c6, B:38:0x00c2, B:8:0x0037, B:10:0x003d, B:47:0x00e0, B:140:0x02ae), top: B:154:0x000e, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x00d0 A[Catch: Exception -> 0x02d4, TryCatch #1 {Exception -> 0x02d4, blocks: (B:4:0x000e, B:6:0x0031, B:11:0x0042, B:13:0x0050, B:15:0x0058, B:17:0x0062, B:21:0x006e, B:26:0x007c, B:41:0x00d0, B:42:0x00d3, B:44:0x00d8, B:51:0x00e8, B:50:0x00e5, B:53:0x00f4, B:56:0x0106, B:58:0x010c, B:60:0x0112, B:62:0x0118, B:65:0x0137, B:67:0x013d, B:69:0x0143, B:74:0x015f, B:76:0x016d, B:78:0x0173, B:80:0x0179, B:82:0x0187, B:83:0x018c, B:85:0x0192, B:87:0x0199, B:90:0x01b0, B:92:0x01b6, B:94:0x01bc, B:96:0x01ca, B:100:0x01da, B:97:0x01d0, B:99:0x01d6, B:101:0x01dd, B:102:0x01e0, B:104:0x01f2, B:106:0x01f8, B:108:0x01fe, B:110:0x0204, B:112:0x0212, B:116:0x0222, B:118:0x0229, B:120:0x023c, B:122:0x0247, B:124:0x0256, B:126:0x026f, B:129:0x0276, B:131:0x027c, B:133:0x0282, B:135:0x0290, B:139:0x02a6, B:143:0x02b7, B:145:0x02c2, B:146:0x02ca, B:142:0x02b3, B:136:0x0299, B:138:0x02a2, B:125:0x0265, B:121:0x0244, B:113:0x0218, B:115:0x021e, B:27:0x008e, B:29:0x0094, B:31:0x00a2, B:33:0x00af, B:35:0x00b5, B:39:0x00c6, B:38:0x00c2, B:8:0x0037, B:10:0x003d, B:47:0x00e0, B:140:0x02ae), top: B:154:0x000e, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x00d8 A[Catch: Exception -> 0x02d4, TRY_LEAVE, TryCatch #1 {Exception -> 0x02d4, blocks: (B:4:0x000e, B:6:0x0031, B:11:0x0042, B:13:0x0050, B:15:0x0058, B:17:0x0062, B:21:0x006e, B:26:0x007c, B:41:0x00d0, B:42:0x00d3, B:44:0x00d8, B:51:0x00e8, B:50:0x00e5, B:53:0x00f4, B:56:0x0106, B:58:0x010c, B:60:0x0112, B:62:0x0118, B:65:0x0137, B:67:0x013d, B:69:0x0143, B:74:0x015f, B:76:0x016d, B:78:0x0173, B:80:0x0179, B:82:0x0187, B:83:0x018c, B:85:0x0192, B:87:0x0199, B:90:0x01b0, B:92:0x01b6, B:94:0x01bc, B:96:0x01ca, B:100:0x01da, B:97:0x01d0, B:99:0x01d6, B:101:0x01dd, B:102:0x01e0, B:104:0x01f2, B:106:0x01f8, B:108:0x01fe, B:110:0x0204, B:112:0x0212, B:116:0x0222, B:118:0x0229, B:120:0x023c, B:122:0x0247, B:124:0x0256, B:126:0x026f, B:129:0x0276, B:131:0x027c, B:133:0x0282, B:135:0x0290, B:139:0x02a6, B:143:0x02b7, B:145:0x02c2, B:146:0x02ca, B:142:0x02b3, B:136:0x0299, B:138:0x02a2, B:125:0x0265, B:121:0x0244, B:113:0x0218, B:115:0x021e, B:27:0x008e, B:29:0x0094, B:31:0x00a2, B:33:0x00af, B:35:0x00b5, B:39:0x00c6, B:38:0x00c2, B:8:0x0037, B:10:0x003d, B:47:0x00e0, B:140:0x02ae), top: B:154:0x000e, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:53:0x00f4 A[Catch: Exception -> 0x02d4, TRY_LEAVE, TryCatch #1 {Exception -> 0x02d4, blocks: (B:4:0x000e, B:6:0x0031, B:11:0x0042, B:13:0x0050, B:15:0x0058, B:17:0x0062, B:21:0x006e, B:26:0x007c, B:41:0x00d0, B:42:0x00d3, B:44:0x00d8, B:51:0x00e8, B:50:0x00e5, B:53:0x00f4, B:56:0x0106, B:58:0x010c, B:60:0x0112, B:62:0x0118, B:65:0x0137, B:67:0x013d, B:69:0x0143, B:74:0x015f, B:76:0x016d, B:78:0x0173, B:80:0x0179, B:82:0x0187, B:83:0x018c, B:85:0x0192, B:87:0x0199, B:90:0x01b0, B:92:0x01b6, B:94:0x01bc, B:96:0x01ca, B:100:0x01da, B:97:0x01d0, B:99:0x01d6, B:101:0x01dd, B:102:0x01e0, B:104:0x01f2, B:106:0x01f8, B:108:0x01fe, B:110:0x0204, B:112:0x0212, B:116:0x0222, B:118:0x0229, B:120:0x023c, B:122:0x0247, B:124:0x0256, B:126:0x026f, B:129:0x0276, B:131:0x027c, B:133:0x0282, B:135:0x0290, B:139:0x02a6, B:143:0x02b7, B:145:0x02c2, B:146:0x02ca, B:142:0x02b3, B:136:0x0299, B:138:0x02a2, B:125:0x0265, B:121:0x0244, B:113:0x0218, B:115:0x021e, B:27:0x008e, B:29:0x0094, B:31:0x00a2, B:33:0x00af, B:35:0x00b5, B:39:0x00c6, B:38:0x00c2, B:8:0x0037, B:10:0x003d, B:47:0x00e0, B:140:0x02ae), top: B:154:0x000e, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:56:0x0106 A[Catch: Exception -> 0x02d4, TRY_ENTER, TryCatch #1 {Exception -> 0x02d4, blocks: (B:4:0x000e, B:6:0x0031, B:11:0x0042, B:13:0x0050, B:15:0x0058, B:17:0x0062, B:21:0x006e, B:26:0x007c, B:41:0x00d0, B:42:0x00d3, B:44:0x00d8, B:51:0x00e8, B:50:0x00e5, B:53:0x00f4, B:56:0x0106, B:58:0x010c, B:60:0x0112, B:62:0x0118, B:65:0x0137, B:67:0x013d, B:69:0x0143, B:74:0x015f, B:76:0x016d, B:78:0x0173, B:80:0x0179, B:82:0x0187, B:83:0x018c, B:85:0x0192, B:87:0x0199, B:90:0x01b0, B:92:0x01b6, B:94:0x01bc, B:96:0x01ca, B:100:0x01da, B:97:0x01d0, B:99:0x01d6, B:101:0x01dd, B:102:0x01e0, B:104:0x01f2, B:106:0x01f8, B:108:0x01fe, B:110:0x0204, B:112:0x0212, B:116:0x0222, B:118:0x0229, B:120:0x023c, B:122:0x0247, B:124:0x0256, B:126:0x026f, B:129:0x0276, B:131:0x027c, B:133:0x0282, B:135:0x0290, B:139:0x02a6, B:143:0x02b7, B:145:0x02c2, B:146:0x02ca, B:142:0x02b3, B:136:0x0299, B:138:0x02a2, B:125:0x0265, B:121:0x0244, B:113:0x0218, B:115:0x021e, B:27:0x008e, B:29:0x0094, B:31:0x00a2, B:33:0x00af, B:35:0x00b5, B:39:0x00c6, B:38:0x00c2, B:8:0x0037, B:10:0x003d, B:47:0x00e0, B:140:0x02ae), top: B:154:0x000e, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:58:0x010c A[Catch: Exception -> 0x02d4, TryCatch #1 {Exception -> 0x02d4, blocks: (B:4:0x000e, B:6:0x0031, B:11:0x0042, B:13:0x0050, B:15:0x0058, B:17:0x0062, B:21:0x006e, B:26:0x007c, B:41:0x00d0, B:42:0x00d3, B:44:0x00d8, B:51:0x00e8, B:50:0x00e5, B:53:0x00f4, B:56:0x0106, B:58:0x010c, B:60:0x0112, B:62:0x0118, B:65:0x0137, B:67:0x013d, B:69:0x0143, B:74:0x015f, B:76:0x016d, B:78:0x0173, B:80:0x0179, B:82:0x0187, B:83:0x018c, B:85:0x0192, B:87:0x0199, B:90:0x01b0, B:92:0x01b6, B:94:0x01bc, B:96:0x01ca, B:100:0x01da, B:97:0x01d0, B:99:0x01d6, B:101:0x01dd, B:102:0x01e0, B:104:0x01f2, B:106:0x01f8, B:108:0x01fe, B:110:0x0204, B:112:0x0212, B:116:0x0222, B:118:0x0229, B:120:0x023c, B:122:0x0247, B:124:0x0256, B:126:0x026f, B:129:0x0276, B:131:0x027c, B:133:0x0282, B:135:0x0290, B:139:0x02a6, B:143:0x02b7, B:145:0x02c2, B:146:0x02ca, B:142:0x02b3, B:136:0x0299, B:138:0x02a2, B:125:0x0265, B:121:0x0244, B:113:0x0218, B:115:0x021e, B:27:0x008e, B:29:0x0094, B:31:0x00a2, B:33:0x00af, B:35:0x00b5, B:39:0x00c6, B:38:0x00c2, B:8:0x0037, B:10:0x003d, B:47:0x00e0, B:140:0x02ae), top: B:154:0x000e, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:61:0x0117  */
    /* JADX WARN: Code duplicated, block: B:64:0x0136  */
    /* JADX WARN: Code duplicated, block: B:67:0x013d A[Catch: Exception -> 0x02d4, TryCatch #1 {Exception -> 0x02d4, blocks: (B:4:0x000e, B:6:0x0031, B:11:0x0042, B:13:0x0050, B:15:0x0058, B:17:0x0062, B:21:0x006e, B:26:0x007c, B:41:0x00d0, B:42:0x00d3, B:44:0x00d8, B:51:0x00e8, B:50:0x00e5, B:53:0x00f4, B:56:0x0106, B:58:0x010c, B:60:0x0112, B:62:0x0118, B:65:0x0137, B:67:0x013d, B:69:0x0143, B:74:0x015f, B:76:0x016d, B:78:0x0173, B:80:0x0179, B:82:0x0187, B:83:0x018c, B:85:0x0192, B:87:0x0199, B:90:0x01b0, B:92:0x01b6, B:94:0x01bc, B:96:0x01ca, B:100:0x01da, B:97:0x01d0, B:99:0x01d6, B:101:0x01dd, B:102:0x01e0, B:104:0x01f2, B:106:0x01f8, B:108:0x01fe, B:110:0x0204, B:112:0x0212, B:116:0x0222, B:118:0x0229, B:120:0x023c, B:122:0x0247, B:124:0x0256, B:126:0x026f, B:129:0x0276, B:131:0x027c, B:133:0x0282, B:135:0x0290, B:139:0x02a6, B:143:0x02b7, B:145:0x02c2, B:146:0x02ca, B:142:0x02b3, B:136:0x0299, B:138:0x02a2, B:125:0x0265, B:121:0x0244, B:113:0x0218, B:115:0x021e, B:27:0x008e, B:29:0x0094, B:31:0x00a2, B:33:0x00af, B:35:0x00b5, B:39:0x00c6, B:38:0x00c2, B:8:0x0037, B:10:0x003d, B:47:0x00e0, B:140:0x02ae), top: B:154:0x000e, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:69:0x0143 A[Catch: Exception -> 0x02d4, TRY_LEAVE, TryCatch #1 {Exception -> 0x02d4, blocks: (B:4:0x000e, B:6:0x0031, B:11:0x0042, B:13:0x0050, B:15:0x0058, B:17:0x0062, B:21:0x006e, B:26:0x007c, B:41:0x00d0, B:42:0x00d3, B:44:0x00d8, B:51:0x00e8, B:50:0x00e5, B:53:0x00f4, B:56:0x0106, B:58:0x010c, B:60:0x0112, B:62:0x0118, B:65:0x0137, B:67:0x013d, B:69:0x0143, B:74:0x015f, B:76:0x016d, B:78:0x0173, B:80:0x0179, B:82:0x0187, B:83:0x018c, B:85:0x0192, B:87:0x0199, B:90:0x01b0, B:92:0x01b6, B:94:0x01bc, B:96:0x01ca, B:100:0x01da, B:97:0x01d0, B:99:0x01d6, B:101:0x01dd, B:102:0x01e0, B:104:0x01f2, B:106:0x01f8, B:108:0x01fe, B:110:0x0204, B:112:0x0212, B:116:0x0222, B:118:0x0229, B:120:0x023c, B:122:0x0247, B:124:0x0256, B:126:0x026f, B:129:0x0276, B:131:0x027c, B:133:0x0282, B:135:0x0290, B:139:0x02a6, B:143:0x02b7, B:145:0x02c2, B:146:0x02ca, B:142:0x02b3, B:136:0x0299, B:138:0x02a2, B:125:0x0265, B:121:0x0244, B:113:0x0218, B:115:0x021e, B:27:0x008e, B:29:0x0094, B:31:0x00a2, B:33:0x00af, B:35:0x00b5, B:39:0x00c6, B:38:0x00c2, B:8:0x0037, B:10:0x003d, B:47:0x00e0, B:140:0x02ae), top: B:154:0x000e, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:71:0x0157  */
    /* JADX WARN: Code duplicated, block: B:73:0x015d  */
    /* JADX WARN: Code duplicated, block: B:76:0x016d A[Catch: Exception -> 0x02d4, TryCatch #1 {Exception -> 0x02d4, blocks: (B:4:0x000e, B:6:0x0031, B:11:0x0042, B:13:0x0050, B:15:0x0058, B:17:0x0062, B:21:0x006e, B:26:0x007c, B:41:0x00d0, B:42:0x00d3, B:44:0x00d8, B:51:0x00e8, B:50:0x00e5, B:53:0x00f4, B:56:0x0106, B:58:0x010c, B:60:0x0112, B:62:0x0118, B:65:0x0137, B:67:0x013d, B:69:0x0143, B:74:0x015f, B:76:0x016d, B:78:0x0173, B:80:0x0179, B:82:0x0187, B:83:0x018c, B:85:0x0192, B:87:0x0199, B:90:0x01b0, B:92:0x01b6, B:94:0x01bc, B:96:0x01ca, B:100:0x01da, B:97:0x01d0, B:99:0x01d6, B:101:0x01dd, B:102:0x01e0, B:104:0x01f2, B:106:0x01f8, B:108:0x01fe, B:110:0x0204, B:112:0x0212, B:116:0x0222, B:118:0x0229, B:120:0x023c, B:122:0x0247, B:124:0x0256, B:126:0x026f, B:129:0x0276, B:131:0x027c, B:133:0x0282, B:135:0x0290, B:139:0x02a6, B:143:0x02b7, B:145:0x02c2, B:146:0x02ca, B:142:0x02b3, B:136:0x0299, B:138:0x02a2, B:125:0x0265, B:121:0x0244, B:113:0x0218, B:115:0x021e, B:27:0x008e, B:29:0x0094, B:31:0x00a2, B:33:0x00af, B:35:0x00b5, B:39:0x00c6, B:38:0x00c2, B:8:0x0037, B:10:0x003d, B:47:0x00e0, B:140:0x02ae), top: B:154:0x000e, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:86:0x0197 A[PHI: r5
  0x0197: PHI (r5v7 java.lang.String) = (r5v6 java.lang.String), (r5v15 java.lang.String), (r5v6 java.lang.String) binds: [B:75:0x016b, B:82:0x0187, B:79:0x0177] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:89:0x01af  */
    /* JADX WARN: Code duplicated, block: B:92:0x01b6 A[Catch: Exception -> 0x02d4, TryCatch #1 {Exception -> 0x02d4, blocks: (B:4:0x000e, B:6:0x0031, B:11:0x0042, B:13:0x0050, B:15:0x0058, B:17:0x0062, B:21:0x006e, B:26:0x007c, B:41:0x00d0, B:42:0x00d3, B:44:0x00d8, B:51:0x00e8, B:50:0x00e5, B:53:0x00f4, B:56:0x0106, B:58:0x010c, B:60:0x0112, B:62:0x0118, B:65:0x0137, B:67:0x013d, B:69:0x0143, B:74:0x015f, B:76:0x016d, B:78:0x0173, B:80:0x0179, B:82:0x0187, B:83:0x018c, B:85:0x0192, B:87:0x0199, B:90:0x01b0, B:92:0x01b6, B:94:0x01bc, B:96:0x01ca, B:100:0x01da, B:97:0x01d0, B:99:0x01d6, B:101:0x01dd, B:102:0x01e0, B:104:0x01f2, B:106:0x01f8, B:108:0x01fe, B:110:0x0204, B:112:0x0212, B:116:0x0222, B:118:0x0229, B:120:0x023c, B:122:0x0247, B:124:0x0256, B:126:0x026f, B:129:0x0276, B:131:0x027c, B:133:0x0282, B:135:0x0290, B:139:0x02a6, B:143:0x02b7, B:145:0x02c2, B:146:0x02ca, B:142:0x02b3, B:136:0x0299, B:138:0x02a2, B:125:0x0265, B:121:0x0244, B:113:0x0218, B:115:0x021e, B:27:0x008e, B:29:0x0094, B:31:0x00a2, B:33:0x00af, B:35:0x00b5, B:39:0x00c6, B:38:0x00c2, B:8:0x0037, B:10:0x003d, B:47:0x00e0, B:140:0x02ae), top: B:154:0x000e, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:94:0x01bc A[Catch: Exception -> 0x02d4, TryCatch #1 {Exception -> 0x02d4, blocks: (B:4:0x000e, B:6:0x0031, B:11:0x0042, B:13:0x0050, B:15:0x0058, B:17:0x0062, B:21:0x006e, B:26:0x007c, B:41:0x00d0, B:42:0x00d3, B:44:0x00d8, B:51:0x00e8, B:50:0x00e5, B:53:0x00f4, B:56:0x0106, B:58:0x010c, B:60:0x0112, B:62:0x0118, B:65:0x0137, B:67:0x013d, B:69:0x0143, B:74:0x015f, B:76:0x016d, B:78:0x0173, B:80:0x0179, B:82:0x0187, B:83:0x018c, B:85:0x0192, B:87:0x0199, B:90:0x01b0, B:92:0x01b6, B:94:0x01bc, B:96:0x01ca, B:100:0x01da, B:97:0x01d0, B:99:0x01d6, B:101:0x01dd, B:102:0x01e0, B:104:0x01f2, B:106:0x01f8, B:108:0x01fe, B:110:0x0204, B:112:0x0212, B:116:0x0222, B:118:0x0229, B:120:0x023c, B:122:0x0247, B:124:0x0256, B:126:0x026f, B:129:0x0276, B:131:0x027c, B:133:0x0282, B:135:0x0290, B:139:0x02a6, B:143:0x02b7, B:145:0x02c2, B:146:0x02ca, B:142:0x02b3, B:136:0x0299, B:138:0x02a2, B:125:0x0265, B:121:0x0244, B:113:0x0218, B:115:0x021e, B:27:0x008e, B:29:0x0094, B:31:0x00a2, B:33:0x00af, B:35:0x00b5, B:39:0x00c6, B:38:0x00c2, B:8:0x0037, B:10:0x003d, B:47:0x00e0, B:140:0x02ae), top: B:154:0x000e, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:96:0x01ca A[Catch: Exception -> 0x02d4, TryCatch #1 {Exception -> 0x02d4, blocks: (B:4:0x000e, B:6:0x0031, B:11:0x0042, B:13:0x0050, B:15:0x0058, B:17:0x0062, B:21:0x006e, B:26:0x007c, B:41:0x00d0, B:42:0x00d3, B:44:0x00d8, B:51:0x00e8, B:50:0x00e5, B:53:0x00f4, B:56:0x0106, B:58:0x010c, B:60:0x0112, B:62:0x0118, B:65:0x0137, B:67:0x013d, B:69:0x0143, B:74:0x015f, B:76:0x016d, B:78:0x0173, B:80:0x0179, B:82:0x0187, B:83:0x018c, B:85:0x0192, B:87:0x0199, B:90:0x01b0, B:92:0x01b6, B:94:0x01bc, B:96:0x01ca, B:100:0x01da, B:97:0x01d0, B:99:0x01d6, B:101:0x01dd, B:102:0x01e0, B:104:0x01f2, B:106:0x01f8, B:108:0x01fe, B:110:0x0204, B:112:0x0212, B:116:0x0222, B:118:0x0229, B:120:0x023c, B:122:0x0247, B:124:0x0256, B:126:0x026f, B:129:0x0276, B:131:0x027c, B:133:0x0282, B:135:0x0290, B:139:0x02a6, B:143:0x02b7, B:145:0x02c2, B:146:0x02ca, B:142:0x02b3, B:136:0x0299, B:138:0x02a2, B:125:0x0265, B:121:0x0244, B:113:0x0218, B:115:0x021e, B:27:0x008e, B:29:0x0094, B:31:0x00a2, B:33:0x00af, B:35:0x00b5, B:39:0x00c6, B:38:0x00c2, B:8:0x0037, B:10:0x003d, B:47:0x00e0, B:140:0x02ae), top: B:154:0x000e, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:97:0x01d0 A[Catch: Exception -> 0x02d4, TryCatch #1 {Exception -> 0x02d4, blocks: (B:4:0x000e, B:6:0x0031, B:11:0x0042, B:13:0x0050, B:15:0x0058, B:17:0x0062, B:21:0x006e, B:26:0x007c, B:41:0x00d0, B:42:0x00d3, B:44:0x00d8, B:51:0x00e8, B:50:0x00e5, B:53:0x00f4, B:56:0x0106, B:58:0x010c, B:60:0x0112, B:62:0x0118, B:65:0x0137, B:67:0x013d, B:69:0x0143, B:74:0x015f, B:76:0x016d, B:78:0x0173, B:80:0x0179, B:82:0x0187, B:83:0x018c, B:85:0x0192, B:87:0x0199, B:90:0x01b0, B:92:0x01b6, B:94:0x01bc, B:96:0x01ca, B:100:0x01da, B:97:0x01d0, B:99:0x01d6, B:101:0x01dd, B:102:0x01e0, B:104:0x01f2, B:106:0x01f8, B:108:0x01fe, B:110:0x0204, B:112:0x0212, B:116:0x0222, B:118:0x0229, B:120:0x023c, B:122:0x0247, B:124:0x0256, B:126:0x026f, B:129:0x0276, B:131:0x027c, B:133:0x0282, B:135:0x0290, B:139:0x02a6, B:143:0x02b7, B:145:0x02c2, B:146:0x02ca, B:142:0x02b3, B:136:0x0299, B:138:0x02a2, B:125:0x0265, B:121:0x0244, B:113:0x0218, B:115:0x021e, B:27:0x008e, B:29:0x0094, B:31:0x00a2, B:33:0x00af, B:35:0x00b5, B:39:0x00c6, B:38:0x00c2, B:8:0x0037, B:10:0x003d, B:47:0x00e0, B:140:0x02ae), top: B:154:0x000e, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:99:0x01d6 A[Catch: Exception -> 0x02d4, TryCatch #1 {Exception -> 0x02d4, blocks: (B:4:0x000e, B:6:0x0031, B:11:0x0042, B:13:0x0050, B:15:0x0058, B:17:0x0062, B:21:0x006e, B:26:0x007c, B:41:0x00d0, B:42:0x00d3, B:44:0x00d8, B:51:0x00e8, B:50:0x00e5, B:53:0x00f4, B:56:0x0106, B:58:0x010c, B:60:0x0112, B:62:0x0118, B:65:0x0137, B:67:0x013d, B:69:0x0143, B:74:0x015f, B:76:0x016d, B:78:0x0173, B:80:0x0179, B:82:0x0187, B:83:0x018c, B:85:0x0192, B:87:0x0199, B:90:0x01b0, B:92:0x01b6, B:94:0x01bc, B:96:0x01ca, B:100:0x01da, B:97:0x01d0, B:99:0x01d6, B:101:0x01dd, B:102:0x01e0, B:104:0x01f2, B:106:0x01f8, B:108:0x01fe, B:110:0x0204, B:112:0x0212, B:116:0x0222, B:118:0x0229, B:120:0x023c, B:122:0x0247, B:124:0x0256, B:126:0x026f, B:129:0x0276, B:131:0x027c, B:133:0x0282, B:135:0x0290, B:139:0x02a6, B:143:0x02b7, B:145:0x02c2, B:146:0x02ca, B:142:0x02b3, B:136:0x0299, B:138:0x02a2, B:125:0x0265, B:121:0x0244, B:113:0x0218, B:115:0x021e, B:27:0x008e, B:29:0x0094, B:31:0x00a2, B:33:0x00af, B:35:0x00b5, B:39:0x00c6, B:38:0x00c2, B:8:0x0037, B:10:0x003d, B:47:0x00e0, B:140:0x02ae), top: B:154:0x000e, inners: #0, #2 }] */
    public static void updateTitleNViewStatus(io.dcloud.common.DHInterface.ITitleNView iTitleNView, io.dcloud.common.DHInterface.IWebview iWebview, float f, org.json.JSONObject jSONObject, float f2) {
        java.lang.String strOptString;
        java.lang.String str;
        int titleColor;
        org.json.JSONObject jSONObjectOptJSONObject;
        java.lang.String strOptString2;
        java.lang.String str2;
        float f3;
        float f4;
        java.lang.String strChangeColorAlpha;
        int iChangeColorAlpha;
        java.lang.String strChangeColorAlpha2;
        int iChangeColorAlpha2;
        float f5;
        java.lang.String strChangeColorAlpha3;
        java.lang.String strColor2Color;
        org.json.JSONObject jSONObjectOptJSONObject2;
        java.lang.String strOptString3;
        java.lang.String strChangeColorAlpha4;
        java.lang.String strOptString4;
        java.lang.String strColor2Color2;
        float f6;
        org.json.JSONArray jSONArrayOptJSONArray;
        int i;
        org.json.JSONObject jSONObjectOptJSONObject3;
        java.lang.String strOptString5;
        java.lang.String strOptString6;
        java.lang.String strColor2Color3;
        java.lang.String strOptString7;
        int iStringToColor;
        java.lang.String strOptString8;
        java.lang.String strChangeColorAlpha5;
        org.json.JSONObject jSONObjectOptJSONObject4;
        java.lang.String strChangeColorAlpha6;
        java.lang.String strOptString9;
        java.lang.String strOptString10;
        org.json.JSONArray jSONArrayOptJSONArray2;
        int i2;
        org.json.JSONObject jSONObjectOptJSONObject5;
        java.lang.String strOptString11;
        java.lang.String strOptString12;
        org.json.JSONObject jSONObjectOptJSONObject6;
        java.lang.String strOptString13;
        org.json.JSONArray jSONArrayOptJSONArray3;
        int i3;
        org.json.JSONObject jSONObjectOptJSONObject7;
        if (iTitleNView != null) {
            try {
                java.lang.String strOptString14 = jSONObject.optString("backgroundColor");
                org.json.JSONObject jSONObject2 = new org.json.JSONObject(iTitleNView.getStatusBarColor());
                int iOptInt = jSONObject2.optInt("color");
                boolean zOptBoolean = jSONObject2.optBoolean("alpha");
                java.lang.String strOptString15 = jSONObject.optString("titleColor");
                if (!jSONObject.has("titleColor")) {
                    if (!jSONObject.has("titlecolor")) {
                        str = strOptString15;
                        titleColor = iTitleNView.getTitleColor();
                        jSONObjectOptJSONObject = jSONObject.optJSONObject("splitLine");
                        if (jSONObjectOptJSONObject != null || com.taobao.weex.common.Constants.Name.UNDEFINED.equals(jSONObjectOptJSONObject)) {
                            strOptString2 = null;
                        } else {
                            strOptString2 = jSONObjectOptJSONObject.optString("color");
                            if (!jSONObjectOptJSONObject.has("color") || "".equals(strOptString2)) {
                                strOptString2 = "#CCCCCC";
                            }
                        }
                        str2 = android.text.TextUtils.isEmpty(strOptString2) ? null : strOptString2;
                        if (f == 0.0f) {
                            f3 = f / f2;
                            if (f3 >= 1.0f) {
                                iChangeColorAlpha2 = changeColorAlpha(titleColor, 1.0f);
                                strChangeColorAlpha2 = changeColorAlpha(strOptString2, 1.0f);
                                strChangeColorAlpha = strOptString14;
                            } else {
                                f4 = 255.0f;
                                if (getColorAlpha(strOptString14) / 255.0f > f3) {
                                    strChangeColorAlpha = changeColorAlpha(strOptString14, f3);
                                } else {
                                    strChangeColorAlpha = strOptString14;
                                }
                                if (android.graphics.Color.alpha(iOptInt) / 255.0f <= f3 || zOptBoolean) {
                                    iOptInt = changeColorAlpha(iOptInt, f3);
                                }
                                iChangeColorAlpha = changeColorAlpha(titleColor, f3);
                                strChangeColorAlpha2 = changeColorAlpha(strOptString2, f3);
                            }
                            if (titleColor != iChangeColorAlpha) {
                                iTitleNView.setTitleColor(iChangeColorAlpha);
                            }
                            iTitleNView.setStatusBarColor(iOptInt);
                            if (str2 != null && !str2.equalsIgnoreCase(strChangeColorAlpha2)) {
                                if (jSONObjectOptJSONObject != null) {
                                    try {
                                        jSONObjectOptJSONObject.put("color", strChangeColorAlpha2);
                                    } catch (java.lang.Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                                setSplitLine(iTitleNView, iWebview, jSONObjectOptJSONObject, jSONObjectOptJSONObject, false, "");
                            }
                            if (strOptString14 != null) {
                                iTitleNView.setBackgroundColor(strChangeColorAlpha);
                            }
                            if (f == 0.0f) {
                                jSONObjectOptJSONObject6 = jSONObject.optJSONObject("backButton");
                                if (jSONObjectOptJSONObject6 == null && jSONObjectOptJSONObject6.has("background")) {
                                    strOptString13 = jSONObjectOptJSONObject6.optString("background");
                                } else {
                                    strOptString13 = TRANSPARENT_BUTTON_BACKGROUND_COLOR;
                                }
                                iTitleNView.setBackButtonColor(strOptString13, changeColorAlpha(TRANSPARENT_BUTTON_TEXT_COLOR, 1.0f), changeColorAlpha(TRANSPARENT_BUTTON_TEXT_COLOR, 0.3f));
                                iTitleNView.setHomeButtonColor(TRANSPARENT_BUTTON_BACKGROUND_COLOR, changeColorAlpha(TRANSPARENT_BUTTON_TEXT_COLOR, 1.0f), changeColorAlpha(TRANSPARENT_BUTTON_TEXT_COLOR, 0.3f));
                                jSONArrayOptJSONArray3 = jSONObject.optJSONArray("buttons");
                                if (jSONArrayOptJSONArray3 != null) {
                                    for (i3 = 0; i3 < jSONArrayOptJSONArray3.length(); i3++) {
                                        jSONObjectOptJSONObject7 = jSONArrayOptJSONArray3.optJSONObject(i3);
                                        if (jSONObjectOptJSONObject7 != null) {
                                            iTitleNView.setButtonColorByIndex(i3, jSONObjectOptJSONObject7.optString("background", TRANSPARENT_BUTTON_BACKGROUND_COLOR), changeColorAlpha(TRANSPARENT_BUTTON_TEXT_COLOR, 1.0f), changeColorAlpha(TRANSPARENT_BUTTON_TEXT_COLOR, 0.3f));
                                        }
                                    }
                                    return;
                                }
                                return;
                            }
                            if (f2 <= f) {
                                strChangeColorAlpha5 = changeColorAlpha(str, 1.0f);
                                jSONObjectOptJSONObject4 = jSONObject.optJSONObject("backButton");
                                strChangeColorAlpha6 = changeColorAlpha(strChangeColorAlpha5, 0.3f);
                                if (jSONObjectOptJSONObject4 == null && (jSONObjectOptJSONObject4.has("color") || jSONObjectOptJSONObject4.has("colorPressed"))) {
                                    strOptString10 = jSONObjectOptJSONObject4.optString("color");
                                    strOptString9 = jSONObjectOptJSONObject4.optString("colorPressed");
                                    if (android.text.TextUtils.isEmpty(strOptString10)) {
                                        strChangeColorAlpha6 = changeColorAlpha(strChangeColorAlpha5, 0.3f);
                                        strOptString9 = strChangeColorAlpha6;
                                        strOptString10 = strChangeColorAlpha5;
                                    } else if (android.text.TextUtils.isEmpty(strOptString9)) {
                                        strOptString9 = changeColorAlpha(strOptString10, 0.3f);
                                    }
                                } else {
                                    strOptString9 = strChangeColorAlpha6;
                                    strOptString10 = strChangeColorAlpha5;
                                }
                                iTitleNView.setBackButtonColor("#00333333", strOptString10, strOptString9);
                                iTitleNView.setHomeButtonColor("#00333333", changeColorAlpha(strChangeColorAlpha5, 1.0f), changeColorAlpha(strChangeColorAlpha5, 0.3f));
                                jSONArrayOptJSONArray2 = jSONObject.optJSONArray("buttons");
                                if (jSONArrayOptJSONArray2 != null) {
                                    for (i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                                        jSONObjectOptJSONObject5 = jSONArrayOptJSONArray2.optJSONObject(i2);
                                        if (jSONObjectOptJSONObject5 != null) {
                                            strOptString11 = jSONObjectOptJSONObject5.optString("color");
                                            strOptString12 = jSONObjectOptJSONObject5.optString("colorPressed");
                                            if (android.text.TextUtils.isEmpty(strOptString11)) {
                                                strOptString12 = changeColorAlpha(strChangeColorAlpha5, 0.3f);
                                                strOptString11 = strChangeColorAlpha5;
                                            } else if (android.text.TextUtils.isEmpty(strOptString12)) {
                                                strOptString12 = changeColorAlpha(strOptString11, 0.3f);
                                            }
                                            iTitleNView.setButtonColorByIndex(i2, "#00333333", strOptString11, strOptString12);
                                        }
                                    }
                                    return;
                                }
                                return;
                            }
                            f5 = f / f2;
                            strChangeColorAlpha3 = changeColorAlpha(str, 1.0f);
                            strColor2Color = color2Color(TRANSPARENT_BUTTON_TEXT_COLOR, strChangeColorAlpha3, f5);
                            jSONObjectOptJSONObject2 = jSONObject.optJSONObject("backButton");
                            if (jSONObjectOptJSONObject2 == null && jSONObjectOptJSONObject2.has("background")) {
                                strOptString3 = jSONObjectOptJSONObject2.optString("background");
                            } else {
                                strOptString3 = TRANSPARENT_BUTTON_BACKGROUND_COLOR;
                            }
                            strChangeColorAlpha4 = changeColorAlpha(strColor2Color, 0.3f);
                            if (jSONObjectOptJSONObject2 != null) {
                                strOptString8 = jSONObjectOptJSONObject2.optString("color");
                                strOptString4 = jSONObjectOptJSONObject2.optString("colorPressed");
                                if (android.text.TextUtils.isEmpty(strOptString8)) {
                                    strOptString4 = changeColorAlpha(strChangeColorAlpha3, 0.3f);
                                    strOptString8 = strChangeColorAlpha3;
                                } else if (android.text.TextUtils.isEmpty(strOptString4)) {
                                    strOptString4 = changeColorAlpha(strOptString8, 0.3f);
                                }
                                strColor2Color2 = color2Color(TRANSPARENT_BUTTON_TEXT_COLOR, strOptString8, f5);
                            } else {
                                strOptString4 = strChangeColorAlpha4;
                                strColor2Color2 = strColor2Color;
                            }
                            f6 = 1.0f - f5;
                            if (f6 < android.graphics.Color.alpha(android.graphics.Color.parseColor(strOptString3)) / f4) {
                                iTitleNView.setBackButtonColor(changeColorAlpha(strOptString3, f6), strColor2Color2, strOptString4);
                            } else {
                                iTitleNView.setBackButtonColor(strOptString3, strColor2Color2, strOptString4);
                            }
                            if (f6 < android.graphics.Color.alpha(android.graphics.Color.parseColor(TRANSPARENT_BUTTON_BACKGROUND_COLOR)) / f4) {
                                iTitleNView.setHomeButtonColor(changeColorAlpha(TRANSPARENT_BUTTON_BACKGROUND_COLOR, f6), strColor2Color, changeColorAlpha(strColor2Color, 0.3f));
                            } else {
                                iTitleNView.setHomeButtonColor(TRANSPARENT_BUTTON_BACKGROUND_COLOR, strColor2Color, changeColorAlpha(strColor2Color, 0.3f));
                            }
                            jSONArrayOptJSONArray = jSONObject.optJSONArray("buttons");
                            if (jSONArrayOptJSONArray != null) {
                                for (i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                                    jSONObjectOptJSONObject3 = jSONArrayOptJSONArray.optJSONObject(i);
                                    if (jSONObjectOptJSONObject3 != null) {
                                        strOptString5 = jSONObjectOptJSONObject3.optString("color");
                                        strOptString6 = jSONObjectOptJSONObject3.optString("colorPressed");
                                        if (android.text.TextUtils.isEmpty(strOptString5)) {
                                            strOptString6 = changeColorAlpha(strChangeColorAlpha3, 0.3f);
                                            strOptString5 = strChangeColorAlpha3;
                                        } else if (android.text.TextUtils.isEmpty(strOptString6)) {
                                            strOptString6 = changeColorAlpha(strOptString5, 0.3f);
                                        }
                                        strColor2Color3 = color2Color(TRANSPARENT_BUTTON_TEXT_COLOR, strOptString5, f5);
                                        strOptString7 = jSONObjectOptJSONObject3.optString("background", TRANSPARENT_BUTTON_BACKGROUND_COLOR);
                                        try {
                                            iStringToColor = android.graphics.Color.parseColor(strOptString7);
                                        } catch (java.lang.Exception unused) {
                                            iStringToColor = io.dcloud.common.util.PdrUtil.stringToColor(strOptString7);
                                        }
                                        if (f6 < android.graphics.Color.alpha(iStringToColor) / f4) {
                                            iTitleNView.setButtonColorByIndex(i, changeColorAlpha(strOptString7, f6), strColor2Color3, strOptString6);
                                        } else {
                                            iTitleNView.setButtonColorByIndex(i, strOptString7, strColor2Color3, strOptString6);
                                        }
                                    }
                                }
                            }
                        }
                        java.lang.String strChangeColorAlpha7 = changeColorAlpha(strOptString14, 0.0f);
                        iOptInt = changeColorAlpha(iOptInt, 0.0f);
                        iChangeColorAlpha2 = changeColorAlpha(titleColor, 0.0f);
                        strChangeColorAlpha2 = changeColorAlpha(strOptString2, 0.0f);
                        strChangeColorAlpha = strChangeColorAlpha7;
                        iChangeColorAlpha = iChangeColorAlpha2;
                        f4 = 255.0f;
                        if (titleColor != iChangeColorAlpha) {
                            iTitleNView.setTitleColor(iChangeColorAlpha);
                        }
                        iTitleNView.setStatusBarColor(iOptInt);
                        if (str2 != null) {
                            if (jSONObjectOptJSONObject != null) {
                                jSONObjectOptJSONObject.put("color", strChangeColorAlpha2);
                            }
                            setSplitLine(iTitleNView, iWebview, jSONObjectOptJSONObject, jSONObjectOptJSONObject, false, "");
                        }
                        if (strOptString14 != null) {
                            iTitleNView.setBackgroundColor(strChangeColorAlpha);
                        }
                        if (f == 0.0f) {
                            jSONObjectOptJSONObject6 = jSONObject.optJSONObject("backButton");
                            if (jSONObjectOptJSONObject6 == null) {
                                strOptString13 = TRANSPARENT_BUTTON_BACKGROUND_COLOR;
                            } else {
                                strOptString13 = TRANSPARENT_BUTTON_BACKGROUND_COLOR;
                            }
                            iTitleNView.setBackButtonColor(strOptString13, changeColorAlpha(TRANSPARENT_BUTTON_TEXT_COLOR, 1.0f), changeColorAlpha(TRANSPARENT_BUTTON_TEXT_COLOR, 0.3f));
                            iTitleNView.setHomeButtonColor(TRANSPARENT_BUTTON_BACKGROUND_COLOR, changeColorAlpha(TRANSPARENT_BUTTON_TEXT_COLOR, 1.0f), changeColorAlpha(TRANSPARENT_BUTTON_TEXT_COLOR, 0.3f));
                            jSONArrayOptJSONArray3 = jSONObject.optJSONArray("buttons");
                            if (jSONArrayOptJSONArray3 != null) {
                                while (i3 < jSONArrayOptJSONArray3.length()) {
                                    jSONObjectOptJSONObject7 = jSONArrayOptJSONArray3.optJSONObject(i3);
                                    if (jSONObjectOptJSONObject7 != null) {
                                        iTitleNView.setButtonColorByIndex(i3, jSONObjectOptJSONObject7.optString("background", TRANSPARENT_BUTTON_BACKGROUND_COLOR), changeColorAlpha(TRANSPARENT_BUTTON_TEXT_COLOR, 1.0f), changeColorAlpha(TRANSPARENT_BUTTON_TEXT_COLOR, 0.3f));
                                    }
                                }
                                return;
                            }
                            return;
                        }
                        if (f2 <= f) {
                            strChangeColorAlpha5 = changeColorAlpha(str, 1.0f);
                            jSONObjectOptJSONObject4 = jSONObject.optJSONObject("backButton");
                            strChangeColorAlpha6 = changeColorAlpha(strChangeColorAlpha5, 0.3f);
                            if (jSONObjectOptJSONObject4 == null) {
                                strOptString9 = strChangeColorAlpha6;
                                strOptString10 = strChangeColorAlpha5;
                            } else {
                                strOptString9 = strChangeColorAlpha6;
                                strOptString10 = strChangeColorAlpha5;
                            }
                            iTitleNView.setBackButtonColor("#00333333", strOptString10, strOptString9);
                            iTitleNView.setHomeButtonColor("#00333333", changeColorAlpha(strChangeColorAlpha5, 1.0f), changeColorAlpha(strChangeColorAlpha5, 0.3f));
                            jSONArrayOptJSONArray2 = jSONObject.optJSONArray("buttons");
                            if (jSONArrayOptJSONArray2 != null) {
                                while (i2 < jSONArrayOptJSONArray2.length()) {
                                    jSONObjectOptJSONObject5 = jSONArrayOptJSONArray2.optJSONObject(i2);
                                    if (jSONObjectOptJSONObject5 != null) {
                                        strOptString11 = jSONObjectOptJSONObject5.optString("color");
                                        strOptString12 = jSONObjectOptJSONObject5.optString("colorPressed");
                                        if (android.text.TextUtils.isEmpty(strOptString11)) {
                                            strOptString12 = changeColorAlpha(strChangeColorAlpha5, 0.3f);
                                            strOptString11 = strChangeColorAlpha5;
                                        } else if (android.text.TextUtils.isEmpty(strOptString12)) {
                                            strOptString12 = changeColorAlpha(strOptString11, 0.3f);
                                        }
                                        iTitleNView.setButtonColorByIndex(i2, "#00333333", strOptString11, strOptString12);
                                    }
                                }
                                return;
                            }
                            return;
                        }
                        f5 = f / f2;
                        strChangeColorAlpha3 = changeColorAlpha(str, 1.0f);
                        strColor2Color = color2Color(TRANSPARENT_BUTTON_TEXT_COLOR, strChangeColorAlpha3, f5);
                        jSONObjectOptJSONObject2 = jSONObject.optJSONObject("backButton");
                        if (jSONObjectOptJSONObject2 == null) {
                            strOptString3 = TRANSPARENT_BUTTON_BACKGROUND_COLOR;
                        } else {
                            strOptString3 = TRANSPARENT_BUTTON_BACKGROUND_COLOR;
                        }
                        strChangeColorAlpha4 = changeColorAlpha(strColor2Color, 0.3f);
                        if (jSONObjectOptJSONObject2 != null) {
                            strOptString8 = jSONObjectOptJSONObject2.optString("color");
                            strOptString4 = jSONObjectOptJSONObject2.optString("colorPressed");
                            if (android.text.TextUtils.isEmpty(strOptString8)) {
                                strOptString4 = changeColorAlpha(strChangeColorAlpha3, 0.3f);
                                strOptString8 = strChangeColorAlpha3;
                            } else if (android.text.TextUtils.isEmpty(strOptString4)) {
                                strOptString4 = changeColorAlpha(strOptString8, 0.3f);
                            }
                            strColor2Color2 = color2Color(TRANSPARENT_BUTTON_TEXT_COLOR, strOptString8, f5);
                        } else {
                            strOptString4 = strChangeColorAlpha4;
                            strColor2Color2 = strColor2Color;
                        }
                        f6 = 1.0f - f5;
                        if (f6 < android.graphics.Color.alpha(android.graphics.Color.parseColor(strOptString3)) / f4) {
                            iTitleNView.setBackButtonColor(changeColorAlpha(strOptString3, f6), strColor2Color2, strOptString4);
                        } else {
                            iTitleNView.setBackButtonColor(strOptString3, strColor2Color2, strOptString4);
                        }
                        if (f6 < android.graphics.Color.alpha(android.graphics.Color.parseColor(TRANSPARENT_BUTTON_BACKGROUND_COLOR)) / f4) {
                            iTitleNView.setHomeButtonColor(changeColorAlpha(TRANSPARENT_BUTTON_BACKGROUND_COLOR, f6), strColor2Color, changeColorAlpha(strColor2Color, 0.3f));
                        } else {
                            iTitleNView.setHomeButtonColor(TRANSPARENT_BUTTON_BACKGROUND_COLOR, strColor2Color, changeColorAlpha(strColor2Color, 0.3f));
                        }
                        jSONArrayOptJSONArray = jSONObject.optJSONArray("buttons");
                        if (jSONArrayOptJSONArray != null) {
                            while (i < jSONArrayOptJSONArray.length()) {
                                jSONObjectOptJSONObject3 = jSONArrayOptJSONArray.optJSONObject(i);
                                if (jSONObjectOptJSONObject3 != null) {
                                    strOptString5 = jSONObjectOptJSONObject3.optString("color");
                                    strOptString6 = jSONObjectOptJSONObject3.optString("colorPressed");
                                    if (android.text.TextUtils.isEmpty(strOptString5)) {
                                        strOptString6 = changeColorAlpha(strChangeColorAlpha3, 0.3f);
                                        strOptString5 = strChangeColorAlpha3;
                                    } else if (android.text.TextUtils.isEmpty(strOptString6)) {
                                        strOptString6 = changeColorAlpha(strOptString5, 0.3f);
                                    }
                                    strColor2Color3 = color2Color(TRANSPARENT_BUTTON_TEXT_COLOR, strOptString5, f5);
                                    strOptString7 = jSONObjectOptJSONObject3.optString("background", TRANSPARENT_BUTTON_BACKGROUND_COLOR);
                                    iStringToColor = android.graphics.Color.parseColor(strOptString7);
                                    if (f6 < android.graphics.Color.alpha(iStringToColor) / f4) {
                                        iTitleNView.setButtonColorByIndex(i, changeColorAlpha(strOptString7, f6), strColor2Color3, strOptString6);
                                    } else {
                                        iTitleNView.setButtonColorByIndex(i, strOptString7, strColor2Color3, strOptString6);
                                    }
                                }
                            }
                        }
                    }
                    strOptString = jSONObject.optString("titlecolor");
                }
                strOptString = jSONObject.optString("titleColor");
                strOptString15 = strOptString;
                str = strOptString15;
                titleColor = iTitleNView.getTitleColor();
                jSONObjectOptJSONObject = jSONObject.optJSONObject("splitLine");
                if (jSONObjectOptJSONObject != null) {
                    strOptString2 = null;
                } else {
                    strOptString2 = null;
                }
                if (android.text.TextUtils.isEmpty(strOptString2)) {
                }
                if (f == 0.0f) {
                    f3 = f / f2;
                    if (f3 >= 1.0f) {
                        iChangeColorAlpha2 = changeColorAlpha(titleColor, 1.0f);
                        strChangeColorAlpha2 = changeColorAlpha(strOptString2, 1.0f);
                        strChangeColorAlpha = strOptString14;
                    } else {
                        f4 = 255.0f;
                        if (getColorAlpha(strOptString14) / 255.0f > f3) {
                            strChangeColorAlpha = changeColorAlpha(strOptString14, f3);
                        } else {
                            strChangeColorAlpha = strOptString14;
                        }
                        if (android.graphics.Color.alpha(iOptInt) / 255.0f <= f3) {
                            iOptInt = changeColorAlpha(iOptInt, f3);
                        } else {
                            iOptInt = changeColorAlpha(iOptInt, f3);
                        }
                        iChangeColorAlpha = changeColorAlpha(titleColor, f3);
                        strChangeColorAlpha2 = changeColorAlpha(strOptString2, f3);
                    }
                    if (titleColor != iChangeColorAlpha) {
                        iTitleNView.setTitleColor(iChangeColorAlpha);
                    }
                    iTitleNView.setStatusBarColor(iOptInt);
                    if (str2 != null) {
                        if (jSONObjectOptJSONObject != null) {
                            jSONObjectOptJSONObject.put("color", strChangeColorAlpha2);
                        }
                        setSplitLine(iTitleNView, iWebview, jSONObjectOptJSONObject, jSONObjectOptJSONObject, false, "");
                    }
                    if (strOptString14 != null) {
                        iTitleNView.setBackgroundColor(strChangeColorAlpha);
                    }
                    if (f == 0.0f) {
                        jSONObjectOptJSONObject6 = jSONObject.optJSONObject("backButton");
                        if (jSONObjectOptJSONObject6 == null) {
                            strOptString13 = TRANSPARENT_BUTTON_BACKGROUND_COLOR;
                        } else {
                            strOptString13 = TRANSPARENT_BUTTON_BACKGROUND_COLOR;
                        }
                        iTitleNView.setBackButtonColor(strOptString13, changeColorAlpha(TRANSPARENT_BUTTON_TEXT_COLOR, 1.0f), changeColorAlpha(TRANSPARENT_BUTTON_TEXT_COLOR, 0.3f));
                        iTitleNView.setHomeButtonColor(TRANSPARENT_BUTTON_BACKGROUND_COLOR, changeColorAlpha(TRANSPARENT_BUTTON_TEXT_COLOR, 1.0f), changeColorAlpha(TRANSPARENT_BUTTON_TEXT_COLOR, 0.3f));
                        jSONArrayOptJSONArray3 = jSONObject.optJSONArray("buttons");
                        if (jSONArrayOptJSONArray3 != null) {
                            while (i3 < jSONArrayOptJSONArray3.length()) {
                                jSONObjectOptJSONObject7 = jSONArrayOptJSONArray3.optJSONObject(i3);
                                if (jSONObjectOptJSONObject7 != null) {
                                    iTitleNView.setButtonColorByIndex(i3, jSONObjectOptJSONObject7.optString("background", TRANSPARENT_BUTTON_BACKGROUND_COLOR), changeColorAlpha(TRANSPARENT_BUTTON_TEXT_COLOR, 1.0f), changeColorAlpha(TRANSPARENT_BUTTON_TEXT_COLOR, 0.3f));
                                }
                            }
                            return;
                        }
                        return;
                    }
                    if (f2 <= f) {
                        strChangeColorAlpha5 = changeColorAlpha(str, 1.0f);
                        jSONObjectOptJSONObject4 = jSONObject.optJSONObject("backButton");
                        strChangeColorAlpha6 = changeColorAlpha(strChangeColorAlpha5, 0.3f);
                        if (jSONObjectOptJSONObject4 == null) {
                            strOptString9 = strChangeColorAlpha6;
                            strOptString10 = strChangeColorAlpha5;
                        } else {
                            strOptString9 = strChangeColorAlpha6;
                            strOptString10 = strChangeColorAlpha5;
                        }
                        iTitleNView.setBackButtonColor("#00333333", strOptString10, strOptString9);
                        iTitleNView.setHomeButtonColor("#00333333", changeColorAlpha(strChangeColorAlpha5, 1.0f), changeColorAlpha(strChangeColorAlpha5, 0.3f));
                        jSONArrayOptJSONArray2 = jSONObject.optJSONArray("buttons");
                        if (jSONArrayOptJSONArray2 != null) {
                            while (i2 < jSONArrayOptJSONArray2.length()) {
                                jSONObjectOptJSONObject5 = jSONArrayOptJSONArray2.optJSONObject(i2);
                                if (jSONObjectOptJSONObject5 != null) {
                                    strOptString11 = jSONObjectOptJSONObject5.optString("color");
                                    strOptString12 = jSONObjectOptJSONObject5.optString("colorPressed");
                                    if (android.text.TextUtils.isEmpty(strOptString11)) {
                                        strOptString12 = changeColorAlpha(strChangeColorAlpha5, 0.3f);
                                        strOptString11 = strChangeColorAlpha5;
                                    } else if (android.text.TextUtils.isEmpty(strOptString12)) {
                                        strOptString12 = changeColorAlpha(strOptString11, 0.3f);
                                    }
                                    iTitleNView.setButtonColorByIndex(i2, "#00333333", strOptString11, strOptString12);
                                }
                            }
                            return;
                        }
                        return;
                    }
                    f5 = f / f2;
                    strChangeColorAlpha3 = changeColorAlpha(str, 1.0f);
                    strColor2Color = color2Color(TRANSPARENT_BUTTON_TEXT_COLOR, strChangeColorAlpha3, f5);
                    jSONObjectOptJSONObject2 = jSONObject.optJSONObject("backButton");
                    if (jSONObjectOptJSONObject2 == null) {
                        strOptString3 = TRANSPARENT_BUTTON_BACKGROUND_COLOR;
                    } else {
                        strOptString3 = TRANSPARENT_BUTTON_BACKGROUND_COLOR;
                    }
                    strChangeColorAlpha4 = changeColorAlpha(strColor2Color, 0.3f);
                    if (jSONObjectOptJSONObject2 != null) {
                        strOptString8 = jSONObjectOptJSONObject2.optString("color");
                        strOptString4 = jSONObjectOptJSONObject2.optString("colorPressed");
                        if (android.text.TextUtils.isEmpty(strOptString8)) {
                            strOptString4 = changeColorAlpha(strChangeColorAlpha3, 0.3f);
                            strOptString8 = strChangeColorAlpha3;
                        } else if (android.text.TextUtils.isEmpty(strOptString4)) {
                            strOptString4 = changeColorAlpha(strOptString8, 0.3f);
                        }
                        strColor2Color2 = color2Color(TRANSPARENT_BUTTON_TEXT_COLOR, strOptString8, f5);
                    } else {
                        strOptString4 = strChangeColorAlpha4;
                        strColor2Color2 = strColor2Color;
                    }
                    f6 = 1.0f - f5;
                    if (f6 < android.graphics.Color.alpha(android.graphics.Color.parseColor(strOptString3)) / f4) {
                        iTitleNView.setBackButtonColor(changeColorAlpha(strOptString3, f6), strColor2Color2, strOptString4);
                    } else {
                        iTitleNView.setBackButtonColor(strOptString3, strColor2Color2, strOptString4);
                    }
                    if (f6 < android.graphics.Color.alpha(android.graphics.Color.parseColor(TRANSPARENT_BUTTON_BACKGROUND_COLOR)) / f4) {
                        iTitleNView.setHomeButtonColor(changeColorAlpha(TRANSPARENT_BUTTON_BACKGROUND_COLOR, f6), strColor2Color, changeColorAlpha(strColor2Color, 0.3f));
                    } else {
                        iTitleNView.setHomeButtonColor(TRANSPARENT_BUTTON_BACKGROUND_COLOR, strColor2Color, changeColorAlpha(strColor2Color, 0.3f));
                    }
                    jSONArrayOptJSONArray = jSONObject.optJSONArray("buttons");
                    if (jSONArrayOptJSONArray != null) {
                        while (i < jSONArrayOptJSONArray.length()) {
                            jSONObjectOptJSONObject3 = jSONArrayOptJSONArray.optJSONObject(i);
                            if (jSONObjectOptJSONObject3 != null) {
                                strOptString5 = jSONObjectOptJSONObject3.optString("color");
                                strOptString6 = jSONObjectOptJSONObject3.optString("colorPressed");
                                if (android.text.TextUtils.isEmpty(strOptString5)) {
                                    strOptString6 = changeColorAlpha(strChangeColorAlpha3, 0.3f);
                                    strOptString5 = strChangeColorAlpha3;
                                } else if (android.text.TextUtils.isEmpty(strOptString6)) {
                                    strOptString6 = changeColorAlpha(strOptString5, 0.3f);
                                }
                                strColor2Color3 = color2Color(TRANSPARENT_BUTTON_TEXT_COLOR, strOptString5, f5);
                                strOptString7 = jSONObjectOptJSONObject3.optString("background", TRANSPARENT_BUTTON_BACKGROUND_COLOR);
                                iStringToColor = android.graphics.Color.parseColor(strOptString7);
                                if (f6 < android.graphics.Color.alpha(iStringToColor) / f4) {
                                    iTitleNView.setButtonColorByIndex(i, changeColorAlpha(strOptString7, f6), strColor2Color3, strOptString6);
                                } else {
                                    iTitleNView.setButtonColorByIndex(i, strOptString7, strColor2Color3, strOptString6);
                                }
                            }
                        }
                    }
                }
                java.lang.String strChangeColorAlpha8 = changeColorAlpha(strOptString14, 0.0f);
                iOptInt = changeColorAlpha(iOptInt, 0.0f);
                iChangeColorAlpha2 = changeColorAlpha(titleColor, 0.0f);
                strChangeColorAlpha2 = changeColorAlpha(strOptString2, 0.0f);
                strChangeColorAlpha = strChangeColorAlpha8;
                iChangeColorAlpha = iChangeColorAlpha2;
                f4 = 255.0f;
                if (titleColor != iChangeColorAlpha) {
                    iTitleNView.setTitleColor(iChangeColorAlpha);
                }
                iTitleNView.setStatusBarColor(iOptInt);
                if (str2 != null) {
                    if (jSONObjectOptJSONObject != null) {
                        jSONObjectOptJSONObject.put("color", strChangeColorAlpha2);
                    }
                    setSplitLine(iTitleNView, iWebview, jSONObjectOptJSONObject, jSONObjectOptJSONObject, false, "");
                }
                if (strOptString14 != null) {
                    iTitleNView.setBackgroundColor(strChangeColorAlpha);
                }
                if (f == 0.0f) {
                    jSONObjectOptJSONObject6 = jSONObject.optJSONObject("backButton");
                    if (jSONObjectOptJSONObject6 == null) {
                        strOptString13 = TRANSPARENT_BUTTON_BACKGROUND_COLOR;
                    } else {
                        strOptString13 = TRANSPARENT_BUTTON_BACKGROUND_COLOR;
                    }
                    iTitleNView.setBackButtonColor(strOptString13, changeColorAlpha(TRANSPARENT_BUTTON_TEXT_COLOR, 1.0f), changeColorAlpha(TRANSPARENT_BUTTON_TEXT_COLOR, 0.3f));
                    iTitleNView.setHomeButtonColor(TRANSPARENT_BUTTON_BACKGROUND_COLOR, changeColorAlpha(TRANSPARENT_BUTTON_TEXT_COLOR, 1.0f), changeColorAlpha(TRANSPARENT_BUTTON_TEXT_COLOR, 0.3f));
                    jSONArrayOptJSONArray3 = jSONObject.optJSONArray("buttons");
                    if (jSONArrayOptJSONArray3 != null) {
                        while (i3 < jSONArrayOptJSONArray3.length()) {
                            jSONObjectOptJSONObject7 = jSONArrayOptJSONArray3.optJSONObject(i3);
                            if (jSONObjectOptJSONObject7 != null) {
                                iTitleNView.setButtonColorByIndex(i3, jSONObjectOptJSONObject7.optString("background", TRANSPARENT_BUTTON_BACKGROUND_COLOR), changeColorAlpha(TRANSPARENT_BUTTON_TEXT_COLOR, 1.0f), changeColorAlpha(TRANSPARENT_BUTTON_TEXT_COLOR, 0.3f));
                            }
                        }
                        return;
                    }
                    return;
                }
                if (f2 <= f) {
                    strChangeColorAlpha5 = changeColorAlpha(str, 1.0f);
                    jSONObjectOptJSONObject4 = jSONObject.optJSONObject("backButton");
                    strChangeColorAlpha6 = changeColorAlpha(strChangeColorAlpha5, 0.3f);
                    if (jSONObjectOptJSONObject4 == null) {
                        strOptString9 = strChangeColorAlpha6;
                        strOptString10 = strChangeColorAlpha5;
                    } else {
                        strOptString9 = strChangeColorAlpha6;
                        strOptString10 = strChangeColorAlpha5;
                    }
                    iTitleNView.setBackButtonColor("#00333333", strOptString10, strOptString9);
                    iTitleNView.setHomeButtonColor("#00333333", changeColorAlpha(strChangeColorAlpha5, 1.0f), changeColorAlpha(strChangeColorAlpha5, 0.3f));
                    jSONArrayOptJSONArray2 = jSONObject.optJSONArray("buttons");
                    if (jSONArrayOptJSONArray2 != null) {
                        while (i2 < jSONArrayOptJSONArray2.length()) {
                            jSONObjectOptJSONObject5 = jSONArrayOptJSONArray2.optJSONObject(i2);
                            if (jSONObjectOptJSONObject5 != null) {
                                strOptString11 = jSONObjectOptJSONObject5.optString("color");
                                strOptString12 = jSONObjectOptJSONObject5.optString("colorPressed");
                                if (android.text.TextUtils.isEmpty(strOptString11)) {
                                    strOptString12 = changeColorAlpha(strChangeColorAlpha5, 0.3f);
                                    strOptString11 = strChangeColorAlpha5;
                                } else if (android.text.TextUtils.isEmpty(strOptString12)) {
                                    strOptString12 = changeColorAlpha(strOptString11, 0.3f);
                                }
                                iTitleNView.setButtonColorByIndex(i2, "#00333333", strOptString11, strOptString12);
                            }
                        }
                        return;
                    }
                    return;
                }
                f5 = f / f2;
                strChangeColorAlpha3 = changeColorAlpha(str, 1.0f);
                strColor2Color = color2Color(TRANSPARENT_BUTTON_TEXT_COLOR, strChangeColorAlpha3, f5);
                jSONObjectOptJSONObject2 = jSONObject.optJSONObject("backButton");
                if (jSONObjectOptJSONObject2 == null) {
                    strOptString3 = TRANSPARENT_BUTTON_BACKGROUND_COLOR;
                } else {
                    strOptString3 = TRANSPARENT_BUTTON_BACKGROUND_COLOR;
                }
                strChangeColorAlpha4 = changeColorAlpha(strColor2Color, 0.3f);
                if (jSONObjectOptJSONObject2 != null) {
                    strOptString8 = jSONObjectOptJSONObject2.optString("color");
                    strOptString4 = jSONObjectOptJSONObject2.optString("colorPressed");
                    if (android.text.TextUtils.isEmpty(strOptString8)) {
                        strOptString4 = changeColorAlpha(strChangeColorAlpha3, 0.3f);
                        strOptString8 = strChangeColorAlpha3;
                    } else if (android.text.TextUtils.isEmpty(strOptString4)) {
                        strOptString4 = changeColorAlpha(strOptString8, 0.3f);
                    }
                    strColor2Color2 = color2Color(TRANSPARENT_BUTTON_TEXT_COLOR, strOptString8, f5);
                } else {
                    strOptString4 = strChangeColorAlpha4;
                    strColor2Color2 = strColor2Color;
                }
                f6 = 1.0f - f5;
                if (f6 < android.graphics.Color.alpha(android.graphics.Color.parseColor(strOptString3)) / f4) {
                    iTitleNView.setBackButtonColor(changeColorAlpha(strOptString3, f6), strColor2Color2, strOptString4);
                } else {
                    iTitleNView.setBackButtonColor(strOptString3, strColor2Color2, strOptString4);
                }
                if (f6 < android.graphics.Color.alpha(android.graphics.Color.parseColor(TRANSPARENT_BUTTON_BACKGROUND_COLOR)) / f4) {
                    iTitleNView.setHomeButtonColor(changeColorAlpha(TRANSPARENT_BUTTON_BACKGROUND_COLOR, f6), strColor2Color, changeColorAlpha(strColor2Color, 0.3f));
                } else {
                    iTitleNView.setHomeButtonColor(TRANSPARENT_BUTTON_BACKGROUND_COLOR, strColor2Color, changeColorAlpha(strColor2Color, 0.3f));
                }
                jSONArrayOptJSONArray = jSONObject.optJSONArray("buttons");
                if (jSONArrayOptJSONArray != null) {
                    while (i < jSONArrayOptJSONArray.length()) {
                        jSONObjectOptJSONObject3 = jSONArrayOptJSONArray.optJSONObject(i);
                        if (jSONObjectOptJSONObject3 != null) {
                            strOptString5 = jSONObjectOptJSONObject3.optString("color");
                            strOptString6 = jSONObjectOptJSONObject3.optString("colorPressed");
                            if (android.text.TextUtils.isEmpty(strOptString5)) {
                                strOptString6 = changeColorAlpha(strChangeColorAlpha3, 0.3f);
                                strOptString5 = strChangeColorAlpha3;
                            } else if (android.text.TextUtils.isEmpty(strOptString6)) {
                                strOptString6 = changeColorAlpha(strOptString5, 0.3f);
                            }
                            strColor2Color3 = color2Color(TRANSPARENT_BUTTON_TEXT_COLOR, strOptString5, f5);
                            strOptString7 = jSONObjectOptJSONObject3.optString("background", TRANSPARENT_BUTTON_BACKGROUND_COLOR);
                            iStringToColor = android.graphics.Color.parseColor(strOptString7);
                            if (f6 < android.graphics.Color.alpha(iStringToColor) / f4) {
                                iTitleNView.setButtonColorByIndex(i, changeColorAlpha(strOptString7, f6), strColor2Color3, strOptString6);
                            } else {
                                iTitleNView.setButtonColorByIndex(i, strOptString7, strColor2Color3, strOptString6);
                            }
                        }
                    }
                }
            } catch (java.lang.Exception unused2) {
            }
        }
    }

    public static java.lang.String changeColorAlpha(java.lang.String str, float f) {
        java.lang.String[] strArrStringSplit;
        try {
            if (android.text.TextUtils.isEmpty(str) || 0.0f > f || f > 1.0f) {
                return null;
            }
            if (!str.startsWith("#")) {
                if (!str.startsWith("rgba") || !str.contains(com.taobao.weex.el.parse.Operators.BRACKET_START_STR) || !str.contains(com.taobao.weex.el.parse.Operators.BRACKET_END_STR) || !str.contains(",") || (strArrStringSplit = io.dcloud.common.util.PdrUtil.stringSplit(str.substring(str.indexOf(com.taobao.weex.el.parse.Operators.BRACKET_START_STR) + 1, str.indexOf(com.taobao.weex.el.parse.Operators.BRACKET_END_STR)), ",")) == null || 4 != strArrStringSplit.length) {
                    return null;
                }
                return "rgba(" + strArrStringSplit[0] + "," + strArrStringSplit[1] + "," + strArrStringSplit[2] + "," + f + com.taobao.weex.el.parse.Operators.BRACKET_END_STR;
            }
            java.lang.String strSubstring = str.substring(1, str.length());
            if (strSubstring.length() == 3) {
                str = "#" + strSubstring.charAt(0) + strSubstring.charAt(0) + strSubstring.charAt(1) + strSubstring.charAt(1) + strSubstring.charAt(2) + strSubstring.charAt(2);
            }
            int color = android.graphics.Color.parseColor(str);
            java.lang.String hexString = java.lang.Integer.toHexString((int) (f * 255.0f));
            if (1 == hexString.length()) {
                hexString = com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT + hexString;
            }
            java.lang.String hexString2 = java.lang.Integer.toHexString(android.graphics.Color.red(color));
            if (1 == hexString2.length()) {
                hexString2 = com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT + hexString2;
            }
            java.lang.String hexString3 = java.lang.Integer.toHexString(android.graphics.Color.green(color));
            if (1 == hexString3.length()) {
                hexString3 = com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT + hexString3;
            }
            java.lang.String hexString4 = java.lang.Integer.toHexString(android.graphics.Color.blue(color));
            if (1 == hexString4.length()) {
                hexString4 = com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT + hexString4;
            }
            return "#" + hexString + hexString2 + hexString3 + hexString4;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
