package io.dcloud.common.util;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class JSONUtil {
    public static org.json.JSONObject combinJSONObject(org.json.JSONObject jSONObject, org.json.JSONObject jSONObject2) {
        java.util.Iterator<java.lang.String> itKeys;
        if (jSONObject == null) {
            return jSONObject2;
        }
        if (jSONObject != jSONObject2 && jSONObject2 != null && (itKeys = jSONObject2.keys()) != null) {
            while (itKeys.hasNext()) {
                try {
                    java.lang.String strValueOf = java.lang.String.valueOf(itKeys.next());
                    java.lang.Object objOpt = jSONObject.opt(strValueOf);
                    java.lang.Object objOpt2 = jSONObject2.opt(strValueOf);
                    if (objOpt2 != null) {
                        if (objOpt == null) {
                            jSONObject.putOpt(strValueOf, objOpt2);
                        } else if (!(objOpt2 instanceof org.json.JSONObject)) {
                            jSONObject.putOpt(strValueOf, objOpt2);
                        } else if (objOpt instanceof org.json.JSONObject) {
                            combinJSONObject((org.json.JSONObject) objOpt, (org.json.JSONObject) objOpt2);
                        } else {
                            jSONObject.putOpt(strValueOf, objOpt2);
                        }
                    }
                } catch (org.json.JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return jSONObject;
    }

    public static org.json.JSONObject combinSitemapHtmlJSONObject(org.json.JSONObject jSONObject, org.json.JSONObject jSONObject2) {
        java.util.Iterator<java.lang.String> itKeys;
        if (jSONObject == null) {
            return jSONObject2;
        }
        if (jSONObject != jSONObject2 && (itKeys = jSONObject2.keys()) != null) {
            while (itKeys.hasNext()) {
                try {
                    java.lang.String strValueOf = java.lang.String.valueOf(itKeys.next());
                    java.lang.Object objOpt = jSONObject.opt(strValueOf);
                    java.lang.Object objOpt2 = jSONObject2.opt(strValueOf);
                    if (objOpt2 != null) {
                        if (objOpt == null) {
                            jSONObject.putOpt(strValueOf, objOpt2);
                        } else if (objOpt2 instanceof org.json.JSONObject) {
                            if (objOpt instanceof org.json.JSONObject) {
                                combinSitemapHtmlJSONObject((org.json.JSONObject) objOpt, (org.json.JSONObject) objOpt2);
                            } else {
                                jSONObject.putOpt(strValueOf, objOpt2);
                            }
                        } else if ((objOpt instanceof org.json.JSONObject) && (objOpt2 instanceof java.lang.Boolean)) {
                            jSONObject.remove(strValueOf);
                        } else {
                            jSONObject.putOpt(strValueOf, objOpt2);
                        }
                    }
                } catch (org.json.JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return jSONObject;
    }

    public static org.json.JSONArray createJSONArray(java.lang.String str) {
        if (!str.startsWith(com.taobao.weex.el.parse.Operators.ARRAY_START_STR)) {
            str = com.taobao.weex.el.parse.Operators.ARRAY_START_STR + str;
        }
        if (!str.endsWith(com.taobao.weex.el.parse.Operators.ARRAY_END_STR)) {
            str = str + com.taobao.weex.el.parse.Operators.ARRAY_END_STR;
        }
        try {
            return new org.json.JSONArray(str);
        } catch (org.json.JSONException unused) {
            return null;
        }
    }

    public static org.json.JSONObject createJSONObject(java.lang.String str) {
        if (str == null) {
            return null;
        }
        try {
            return new org.json.JSONObject(str);
        } catch (java.lang.Exception unused) {
            io.dcloud.common.adapter.util.Logger.d("jsonutil", "JSONException pJson=" + str);
            return null;
        }
    }

    public static boolean getBoolean(org.json.JSONObject jSONObject, java.lang.String str) {
        if (jSONObject != null) {
            try {
                if (jSONObject.has(str)) {
                    return jSONObject.getBoolean(str);
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static int getInt(org.json.JSONObject jSONObject, java.lang.String str) {
        try {
            int i = jSONObject.getInt(str);
            java.lang.Integer.valueOf(i).getClass();
            return i;
        } catch (java.lang.Exception unused) {
            return 0;
        }
    }

    public static org.json.JSONArray getJSONArray(org.json.JSONArray jSONArray, int i) {
        try {
            java.lang.Object obj = jSONArray.get(i);
            if (obj instanceof org.json.JSONArray) {
                return (org.json.JSONArray) obj;
            }
            return null;
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public static org.json.JSONObject getJSONObject(org.json.JSONObject jSONObject, java.lang.String str) {
        try {
            java.lang.Object objOpt = jSONObject.opt(str);
            if (objOpt instanceof org.json.JSONObject) {
                return (org.json.JSONObject) objOpt;
            }
            return null;
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public static long getLong(org.json.JSONObject jSONObject, java.lang.String str) {
        if (jSONObject != null) {
            try {
                if (jSONObject.has(str)) {
                    return jSONObject.getLong(str);
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
        return 0L;
    }

    public static java.lang.String getString(org.json.JSONObject jSONObject, java.lang.String str) {
        if (jSONObject == null) {
            return null;
        }
        try {
            return jSONObject.getString(str);
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public static boolean isNull(org.json.JSONObject jSONObject, java.lang.String str) {
        if (jSONObject == null) {
            return true;
        }
        try {
            return jSONObject.isNull(str);
        } catch (java.lang.Exception unused) {
            return true;
        }
    }

    public static java.lang.String toJSONableString(java.lang.String str) {
        return str != null ? org.json.JSONObject.quote(str) : "''";
    }

    public static java.util.HashMap<java.lang.String, java.lang.String> toMap(org.json.JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        java.util.Iterator<java.lang.String> itKeys = jSONObject.keys();
        java.util.HashMap<java.lang.String, java.lang.String> map = new java.util.HashMap<>(jSONObject.length());
        while (itKeys.hasNext()) {
            java.lang.String next = itKeys.next();
            map.put(next, jSONObject.optString(next));
        }
        return map;
    }

    public static java.lang.String getString(org.json.JSONArray jSONArray, int i) {
        try {
            java.lang.Object obj = jSONArray.get(i);
            if (io.dcloud.common.util.PdrUtil.isEmpty(obj)) {
                return null;
            }
            return java.lang.String.valueOf(obj);
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public static org.json.JSONArray getJSONArray(org.json.JSONObject jSONObject, java.lang.String str) {
        try {
            java.lang.Object obj = jSONObject.get(str);
            if (obj instanceof org.json.JSONArray) {
                return (org.json.JSONArray) obj;
            }
            return null;
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public static org.json.JSONObject getJSONObject(org.json.JSONArray jSONArray, int i) {
        try {
            java.lang.Object obj = jSONArray.get(i);
            if (obj instanceof org.json.JSONObject) {
                return (org.json.JSONObject) obj;
            }
            return null;
        } catch (java.lang.Exception unused) {
            return null;
        }
    }
}
