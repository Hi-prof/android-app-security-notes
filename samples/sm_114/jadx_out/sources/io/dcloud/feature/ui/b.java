package io.dcloud.feature.ui;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public abstract class b {
    public static byte n = io.dcloud.common.adapter.util.ViewRect.POSITION_STATIC;
    public static byte o = io.dcloud.common.adapter.util.ViewRect.POSITION_ABSOLUTE;
    public static byte p = io.dcloud.common.adapter.util.ViewRect.POSITION_DOCK;
    public static byte q = io.dcloud.common.adapter.util.ViewRect.DOCK_LEFT;
    public static byte r = io.dcloud.common.adapter.util.ViewRect.DOCK_RIGHT;
    public static byte s = io.dcloud.common.adapter.util.ViewRect.DOCK_TOP;
    public static byte t = io.dcloud.common.adapter.util.ViewRect.DOCK_BOTTOM;
    protected java.util.HashMap b;
    protected java.lang.String d;
    private android.content.Context l;
    protected io.dcloud.feature.ui.c a = null;
    protected io.dcloud.feature.ui.a c = null;
    protected java.lang.String e = null;
    protected java.lang.String f = null;
    protected java.lang.String g = null;
    protected org.json.JSONObject h = null;
    protected io.dcloud.common.DHInterface.IWebview i = null;
    private byte j = o;
    private byte k = s;
    protected java.util.HashMap m = null;

    public b(java.lang.String str) {
        this.b = null;
        this.d = str;
        this.b = new java.util.HashMap();
    }

    public abstract java.lang.String a(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, org.json.JSONArray jSONArray);

    public abstract void a(int i, int i2, int i3, int i4, int i5, int i6);

    protected void a(android.content.Context context, io.dcloud.feature.ui.a aVar, io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, org.json.JSONObject jSONObject) {
        this.c = aVar;
        this.l = context;
        this.i = iWebview;
        this.e = str;
        if (jSONObject == null) {
            jSONObject = io.dcloud.common.util.JSONUtil.createJSONObject("{}");
        }
        this.h = jSONObject;
        f();
    }

    public final byte b() {
        return this.k;
    }

    public final byte c() {
        return this.j;
    }

    public abstract io.dcloud.common.adapter.ui.AdaFrameItem d();

    protected abstract void e();

    protected void f() {
        org.json.JSONObject jSONObject = this.h;
        if (!io.dcloud.common.util.JSONUtil.isNull(jSONObject, "id") && io.dcloud.common.util.PdrUtil.isEmpty(this.f)) {
            this.f = io.dcloud.common.util.JSONUtil.getString(jSONObject, "id");
        }
        this.g = jSONObject.optString("tid");
        java.lang.String string = io.dcloud.common.util.JSONUtil.getString(jSONObject, "position");
        if (!io.dcloud.common.util.PdrUtil.isEmpty(string)) {
            if (io.dcloud.common.constant.AbsoluteConst.JSON_VALUE_POSITION_ABSOLUTE.equals(string)) {
                this.j = o;
            } else if ("dock".equals(string)) {
                this.j = p;
            } else if ("static".equals(string)) {
                this.j = n;
            }
        }
        java.lang.String string2 = io.dcloud.common.util.JSONUtil.getString(jSONObject, "dock");
        if (io.dcloud.common.util.PdrUtil.isEmpty(string2)) {
            return;
        }
        if ("bottom".equals(string2)) {
            this.k = t;
            return;
        }
        if ("top".equals(string2)) {
            this.k = s;
        } else if ("left".equals(string2)) {
            this.k = q;
        } else if ("right".equals(string2)) {
            this.k = r;
        }
    }

    protected void g() {
        java.util.Iterator it = this.c.c.iterator();
        while (it.hasNext()) {
            a(this, ((io.dcloud.feature.ui.c) it.next()).m);
        }
    }

    public java.lang.String h() {
        return io.dcloud.common.util.StringUtil.format("(function(){return {uuid:'%s',identity:'%s',option:%s}})()", this.e, this.d, this.h);
    }

    protected void b(java.lang.String str, java.lang.String str2) {
        java.util.ArrayList arrayList;
        java.util.HashMap map = this.m;
        if (map == null || (arrayList = (java.util.ArrayList) map.get(str2)) == null) {
            return;
        }
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            java.lang.Object obj = arrayList.get(i);
            i++;
            java.lang.String[] strArr = (java.lang.String[]) obj;
            if (strArr[0].equals(str)) {
                arrayList.remove(strArr);
            }
        }
        if (arrayList.size() == 0) {
            this.m.remove(str2);
        }
    }

    public final android.content.Context a() {
        return this.l;
    }

    protected void a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (this.m == null) {
            this.m = new java.util.HashMap(2);
        }
        java.util.ArrayList arrayList = (java.util.ArrayList) this.m.get(str2);
        if (arrayList == null) {
            arrayList = new java.util.ArrayList(2);
            this.m.put(str2, arrayList);
        }
        arrayList.add(new java.lang.String[]{str, str3});
    }

    private static void a(io.dcloud.feature.ui.b bVar, java.util.HashMap map) {
        if (map != null) {
            for (java.util.ArrayList arrayList : map.values()) {
                if (arrayList != null) {
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        java.lang.String str = ((java.lang.String[]) arrayList.get(size))[0];
                        if (bVar.c.a(str, str, (java.lang.String) null) == bVar) {
                            arrayList.remove(size);
                        }
                    }
                }
            }
        }
    }

    protected boolean a(java.lang.String str) {
        java.util.ArrayList arrayList;
        java.util.HashMap map = this.m;
        if (map == null || (arrayList = (java.util.ArrayList) map.get(str)) == null) {
            return false;
        }
        return !arrayList.isEmpty();
    }

    public final boolean a(java.lang.String str, java.lang.String str2) {
        return a(str, str2, true);
    }

    public boolean a(java.lang.String str, java.lang.String str2, boolean z) {
        java.util.ArrayList arrayList;
        io.dcloud.common.DHInterface.IWebview iWebviewObtainWebView;
        io.dcloud.common.adapter.util.Logger.d("execCallback pEventType=" + str + ";");
        java.util.HashMap map = this.m;
        if (map == null || (arrayList = (java.util.ArrayList) map.get(str)) == null) {
            return false;
        }
        int size = arrayList.size();
        java.lang.String strEventListener_format = io.dcloud.common.util.JsEventUtil.eventListener_format(str, str2, z);
        boolean z2 = false;
        for (int i = size - 1; i >= 0; i--) {
            java.lang.String[] strArr = (java.lang.String[]) arrayList.get(i);
            java.lang.String str3 = strArr[0];
            java.lang.String str4 = strArr[1];
            io.dcloud.feature.ui.c cVarA = this.c.a(str3, str3, (java.lang.String) null);
            if (cVarA != null && !cVarA.J && (iWebviewObtainWebView = cVarA.y.obtainWebView()) != null) {
                io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebviewObtainWebView, str4, strEventListener_format, io.dcloud.common.util.JSUtil.OK, true, true);
                z2 = true;
            }
        }
        return z2;
    }
}
