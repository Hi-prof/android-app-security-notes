package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class p0 extends org.json.JSONObject {
    public p0() {
    }

    public org.json.JSONObject a(java.lang.String str) {
        java.lang.Object objOpt = super.opt(str);
        if (objOpt instanceof org.json.JSONObject) {
            return (org.json.JSONObject) objOpt;
        }
        return null;
    }

    public org.json.JSONObject b(java.lang.String str) {
        return a(io.dcloud.p.s4.b(str));
    }

    @Override // org.json.JSONObject
    public java.lang.Object get(java.lang.String str) {
        return super.get(io.dcloud.p.s4.b(str));
    }

    @Override // org.json.JSONObject
    public boolean getBoolean(java.lang.String str) {
        return super.getBoolean(str);
    }

    @Override // org.json.JSONObject
    public double getDouble(java.lang.String str) {
        return super.getDouble(str);
    }

    @Override // org.json.JSONObject
    public int getInt(java.lang.String str) {
        return super.getInt(str);
    }

    @Override // org.json.JSONObject
    public org.json.JSONArray getJSONArray(java.lang.String str) {
        return super.getJSONArray(str);
    }

    @Override // org.json.JSONObject
    public org.json.JSONObject getJSONObject(java.lang.String str) throws org.json.JSONException {
        java.lang.Object obj = get(str);
        if (obj instanceof org.json.JSONObject) {
            return (org.json.JSONObject) obj;
        }
        throw a(str, obj, "JSONObject");
    }

    @Override // org.json.JSONObject
    public long getLong(java.lang.String str) {
        return super.getLong(str);
    }

    @Override // org.json.JSONObject
    public java.lang.String getString(java.lang.String str) {
        return super.getString(str);
    }

    @Override // org.json.JSONObject
    public boolean has(java.lang.String str) {
        return super.has(io.dcloud.p.s4.b(str));
    }

    @Override // org.json.JSONObject
    public boolean isNull(java.lang.String str) {
        return super.isNull(io.dcloud.p.s4.b(str));
    }

    @Override // org.json.JSONObject
    public java.lang.Object opt(java.lang.String str) {
        return super.opt(io.dcloud.p.s4.b(str));
    }

    @Override // org.json.JSONObject
    public boolean optBoolean(java.lang.String str) {
        return super.optBoolean(str);
    }

    @Override // org.json.JSONObject
    public double optDouble(java.lang.String str) {
        return super.optDouble(str);
    }

    @Override // org.json.JSONObject
    public int optInt(java.lang.String str) {
        return super.optInt(str);
    }

    @Override // org.json.JSONObject
    public org.json.JSONArray optJSONArray(java.lang.String str) {
        return super.optJSONArray(str);
    }

    @Override // org.json.JSONObject
    public long optLong(java.lang.String str) {
        return super.optLong(str);
    }

    @Override // org.json.JSONObject
    public java.lang.String optString(java.lang.String str) {
        return super.optString(str);
    }

    @Override // org.json.JSONObject
    public org.json.JSONObject put(java.lang.String str, boolean z) {
        return super.put(io.dcloud.p.s4.b(str), z);
    }

    @Override // org.json.JSONObject
    public java.lang.Object remove(java.lang.String str) {
        return super.remove(io.dcloud.p.s4.b(str));
    }

    @Override // org.json.JSONObject
    public org.json.JSONArray toJSONArray(org.json.JSONArray jSONArray) {
        return super.toJSONArray(jSONArray);
    }

    public p0(java.util.Map map) {
        super(map);
    }

    @Override // org.json.JSONObject
    public boolean optBoolean(java.lang.String str, boolean z) {
        return super.optBoolean(str, z);
    }

    @Override // org.json.JSONObject
    public double optDouble(java.lang.String str, double d) {
        return super.optDouble(str, d);
    }

    @Override // org.json.JSONObject
    public int optInt(java.lang.String str, int i) {
        return super.optInt(str, i);
    }

    @Override // org.json.JSONObject
    public io.dcloud.p.p0 optJSONObject(java.lang.String str) {
        java.lang.Object objOpt = opt(str);
        if (objOpt == null) {
            return null;
        }
        try {
            return new io.dcloud.p.p0(objOpt.toString());
        } catch (org.json.JSONException unused) {
            return null;
        }
    }

    @Override // org.json.JSONObject
    public long optLong(java.lang.String str, long j) {
        return super.optLong(str, j);
    }

    @Override // org.json.JSONObject
    public java.lang.String optString(java.lang.String str, java.lang.String str2) {
        return super.optString(str, str2);
    }

    @Override // org.json.JSONObject
    public org.json.JSONObject put(java.lang.String str, double d) {
        return super.put(io.dcloud.p.s4.b(str), d);
    }

    public p0(java.lang.String str) {
        super(str);
    }

    public static org.json.JSONException a(java.lang.Object obj, java.lang.Object obj2, java.lang.String str) throws org.json.JSONException {
        if (obj2 == null) {
            throw new org.json.JSONException("Value at " + obj + " is null.");
        }
        throw new org.json.JSONException("Value " + obj2 + " at " + obj + " of type " + obj2.getClass().getName() + " cannot be converted to " + str);
    }

    @Override // org.json.JSONObject
    public org.json.JSONObject put(java.lang.String str, int i) {
        return super.put(io.dcloud.p.s4.b(str), i);
    }

    public p0(org.json.JSONObject jSONObject, java.lang.String[] strArr) {
        super(jSONObject, strArr);
    }

    @Override // org.json.JSONObject
    public org.json.JSONObject put(java.lang.String str, long j) {
        return super.put(io.dcloud.p.s4.b(str), j);
    }

    @Override // org.json.JSONObject
    public org.json.JSONObject put(java.lang.String str, java.lang.Object obj) {
        return super.put(io.dcloud.p.s4.b(str), obj);
    }
}
