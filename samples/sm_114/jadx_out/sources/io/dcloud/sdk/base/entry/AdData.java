package io.dcloud.sdk.base.entry;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class AdData implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<io.dcloud.sdk.base.entry.AdData> CREATOR = new io.dcloud.sdk.base.entry.AdData.d();
    private int a;
    private java.lang.String action;
    private java.lang.String b;
    private java.lang.String bundle;
    private byte[] c;
    private java.lang.String d;
    private java.lang.String downloadAppName;
    private java.lang.String dplk;
    private java.lang.String e;
    private java.lang.String expires;
    private java.lang.String f;
    private java.lang.String g;
    private java.lang.String h;
    private java.util.List i;
    private java.util.List j;
    private java.util.List k;
    private android.view.MotionEvent l;
    private android.view.MotionEvent m;
    private boolean n;
    private android.graphics.RectF o;
    protected android.content.Context p;
    private java.lang.String price;
    private java.lang.String provider;
    private java.lang.String src;
    private java.lang.String tid;
    private java.lang.String ua;
    private java.lang.String url;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public static class ExtBean implements android.os.Parcelable {
        public static final android.os.Parcelable.Creator<io.dcloud.sdk.base.entry.AdData.ExtBean> CREATOR = new io.dcloud.sdk.base.entry.AdData.ExtBean.a();
        private java.lang.String a;
        private int b;

        /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
        class a implements android.os.Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public io.dcloud.sdk.base.entry.AdData.ExtBean createFromParcel(android.os.Parcel parcel) {
                return new io.dcloud.sdk.base.entry.AdData.ExtBean(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public io.dcloud.sdk.base.entry.AdData.ExtBean[] newArray(int i) {
                return new io.dcloud.sdk.base.entry.AdData.ExtBean[i];
            }
        }

        protected ExtBean(android.os.Parcel parcel) {
            this.a = parcel.readString();
            this.b = parcel.readInt();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(android.os.Parcel parcel, int i) {
            parcel.writeString(this.a);
            parcel.writeInt(this.b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class a implements java.lang.Runnable {
        final /* synthetic */ java.lang.String a;
        final /* synthetic */ io.dcloud.sdk.base.entry.AdData.e b;

        a(java.lang.String str, io.dcloud.sdk.base.entry.AdData.e eVar) {
            this.a = str;
            this.b = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            byte[] bArrA = io.dcloud.p.l3.a(io.dcloud.sdk.base.entry.AdData.this.src, (java.util.HashMap) null, true, new java.lang.String[1]);
            if (bArrA == null) {
                io.dcloud.sdk.base.entry.AdData.e eVar = this.b;
                if (eVar != null) {
                    eVar.a(60009, "图片下载失败");
                    return;
                }
                return;
            }
            io.dcloud.sdk.base.entry.AdData.this.c = bArrA;
            io.dcloud.p.m1.a(io.dcloud.sdk.base.entry.AdData.this.c, 0, this.a);
            io.dcloud.sdk.base.entry.AdData.this.b = this.a;
            io.dcloud.sdk.base.entry.AdData.e eVar2 = this.b;
            if (eVar2 != null) {
                eVar2.a();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class b implements java.lang.Runnable {
        final /* synthetic */ android.content.Context a;

        b(android.content.Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            android.content.Context context = this.a;
            if (context != null) {
                io.dcloud.p.f0.a(context, io.dcloud.sdk.base.entry.AdData.this.f, io.dcloud.sdk.base.entry.AdData.this.tid, "", 50, io.dcloud.sdk.base.entry.AdData.this.e, io.dcloud.sdk.base.entry.AdData.this.h, io.dcloud.sdk.base.entry.AdData.this.g, null);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class c implements java.lang.Runnable {
        final /* synthetic */ io.dcloud.sdk.base.entry.AdData.TrackerBean a;

        c(io.dcloud.sdk.base.entry.AdData.TrackerBean trackerBean) {
            this.a = trackerBean;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                java.lang.String strA = io.dcloud.sdk.base.entry.AdData.this.a(this.a.a);
                java.util.HashMap map = new java.util.HashMap();
                map.put(io.dcloud.common.DHInterface.IWebview.USER_AGENT, io.dcloud.p.n4.e(io.dcloud.sdk.base.entry.AdData.this.p));
                io.dcloud.p.l3.a(strA, map, true);
            } catch (java.lang.Exception unused) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class d implements android.os.Parcelable.Creator {
        d() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public io.dcloud.sdk.base.entry.AdData createFromParcel(android.os.Parcel parcel) {
            return new io.dcloud.sdk.base.entry.AdData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public io.dcloud.sdk.base.entry.AdData[] newArray(int i) {
            return new io.dcloud.sdk.base.entry.AdData[i];
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public interface e {
        void a();

        void a(int i, java.lang.String str);
    }

    public AdData() {
        this.a = com.nostra13.dcloudimageloader.core.download.BaseImageDownloader.DEFAULT_HTTP_CONNECT_TIMEOUT;
        this.e = "";
        this.i = new java.util.ArrayList();
        this.j = new java.util.ArrayList();
        this.k = new java.util.ArrayList();
        this.n = false;
        this.o = new android.graphics.RectF();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public java.lang.String h() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("expires", this.expires);
        } catch (org.json.JSONException unused) {
        }
        return jSONObject.toString();
    }

    public int i() {
        return this.a;
    }

    public java.lang.String j() {
        return this.tid;
    }

    public java.lang.String k() {
        return this.d;
    }

    public java.lang.String l() {
        return this.url;
    }

    public boolean m() {
        if (this.p == null) {
            return false;
        }
        return new java.io.File(this.p.getCacheDir().getAbsolutePath() + "/dcloud_ad/" + this.src.hashCode()).exists();
    }

    public boolean n() {
        return (android.text.TextUtils.isEmpty(this.src) || android.text.TextUtils.isEmpty(this.action) || android.text.TextUtils.isEmpty(this.url)) ? false : true;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeString(this.provider);
        parcel.writeString(this.ua);
        parcel.writeString(this.src);
        parcel.writeString(this.action);
        parcel.writeString(this.url);
        parcel.writeString(this.bundle);
        parcel.writeString(this.downloadAppName);
        parcel.writeString(this.dplk);
        parcel.writeString(this.price);
        parcel.writeString(this.tid);
        parcel.writeString(this.expires);
        parcel.writeString(this.b);
        parcel.writeByteArray(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeString(this.g);
        parcel.writeString(this.h);
        parcel.writeTypedList(this.i);
        parcel.writeTypedList(this.j);
        parcel.writeTypedList(this.k);
        parcel.writeParcelable(this.l, i);
        parcel.writeParcelable(this.m, i);
        parcel.writeByte(this.n ? (byte) 1 : (byte) 0);
        parcel.writeParcelable(this.o, i);
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public static class TrackerBean implements android.os.Parcelable {
        public static final android.os.Parcelable.Creator<io.dcloud.sdk.base.entry.AdData.TrackerBean> CREATOR = new io.dcloud.sdk.base.entry.AdData.TrackerBean.a();
        private java.lang.String a;

        /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
        class a implements android.os.Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public io.dcloud.sdk.base.entry.AdData.TrackerBean createFromParcel(android.os.Parcel parcel) {
                return new io.dcloud.sdk.base.entry.AdData.TrackerBean(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public io.dcloud.sdk.base.entry.AdData.TrackerBean[] newArray(int i) {
                return new io.dcloud.sdk.base.entry.AdData.TrackerBean[i];
            }
        }

        public TrackerBean(java.lang.String str) {
            this.a = str;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(android.os.Parcel parcel, int i) {
            parcel.writeString(this.a);
        }

        protected TrackerBean(android.os.Parcel parcel) {
            this.a = parcel.readString();
        }
    }

    void b(org.json.JSONObject jSONObject) {
        io.dcloud.p.l4.a().a(this.p, this, jSONObject.toString());
    }

    public void c(android.content.Context context) {
        this.p = context;
    }

    public java.lang.String d() {
        return this.g;
    }

    public java.lang.String e() {
        return this.f;
    }

    public java.lang.String f() {
        return this.b;
    }

    public byte[] g() {
        return this.c;
    }

    public void b(android.view.MotionEvent motionEvent) {
        this.m = motionEvent;
    }

    public java.lang.String c() {
        return this.e;
    }

    private void a(org.json.JSONObject jSONObject, io.dcloud.sdk.base.entry.AdData.e eVar) {
        org.json.JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
        if (jSONObjectOptJSONObject == null) {
            if (eVar != null) {
                eVar.a(60007, "无广告填充");
                return;
            }
            return;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(java.util.Arrays.asList(getClass().getDeclaredFields()));
        if (getClass().getSuperclass() != null) {
            java.lang.reflect.Field[] declaredFields = getClass().getSuperclass().getDeclaredFields();
            if (declaredFields.length > 0) {
                arrayList.addAll(java.util.Arrays.asList(declaredFields));
            }
        }
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            java.lang.Object obj = arrayList.get(i);
            i++;
            java.lang.reflect.Field field = (java.lang.reflect.Field) obj;
            try {
                if (field.getType() == java.lang.String.class && jSONObjectOptJSONObject.has(field.getName())) {
                    java.lang.String strOptString = jSONObjectOptJSONObject.optString(field.getName());
                    field.setAccessible(true);
                    field.set(this, strOptString);
                }
            } catch (java.lang.IllegalAccessException | java.lang.Exception unused) {
            }
        }
        if (android.text.TextUtils.isEmpty(this.src)) {
            if (eVar != null) {
                eVar.a(60008, "图片资源路径异常");
                return;
            }
            return;
        }
        java.lang.String str = this.p.getCacheDir().getAbsolutePath() + "/dcloud_ad/img/" + this.src.hashCode();
        if (new java.io.File(str).exists()) {
            this.b = str;
            if (eVar != null) {
                eVar.a();
                return;
            }
            return;
        }
        io.dcloud.p.x4.a().a(new io.dcloud.sdk.base.entry.AdData.a(str, eVar));
    }

    private void b(android.content.Context context) {
        a(this.j);
        if (!android.text.TextUtils.isEmpty(this.dplk) && io.dcloud.p.c.d(context, this.dplk)) {
            a(this.k);
            io.dcloud.p.x4.a().a(new io.dcloud.sdk.base.entry.AdData.b(context));
        }
        java.lang.String str = this.action;
        str.getClass();
        str.hashCode();
        switch (str) {
            case "url":
                try {
                    android.content.Intent intent = new android.content.Intent();
                    int i = io.dcloud.sdk.activity.WebViewActivity.o;
                    intent.setClass(context, io.dcloud.sdk.activity.WebViewActivity.class);
                    intent.putExtra("url", this.url);
                    intent.setData(android.net.Uri.parse(this.url));
                    intent.setAction("android.intent.action.VIEW");
                    intent.setFlags(268435456);
                    context.startActivity(intent);
                    break;
                } catch (java.lang.Exception unused) {
                    return;
                }
                break;
            case "browser":
                io.dcloud.p.c.c(context, this.url);
                break;
            case "download":
                android.content.Intent intent2 = new android.content.Intent();
                intent2.putExtra("url", this.url);
                intent2.putExtra("data", this);
                androidx.core.app.JobIntentService.enqueueWork(context, (java.lang.Class<?>) io.dcloud.sdk.base.service.DownloadService.class, 10010, intent2);
                break;
        }
    }

    protected AdData(android.os.Parcel parcel) {
        this.a = com.nostra13.dcloudimageloader.core.download.BaseImageDownloader.DEFAULT_HTTP_CONNECT_TIMEOUT;
        this.e = "";
        this.i = new java.util.ArrayList();
        this.j = new java.util.ArrayList();
        this.k = new java.util.ArrayList();
        this.n = false;
        this.o = new android.graphics.RectF();
        this.provider = parcel.readString();
        this.ua = parcel.readString();
        this.src = parcel.readString();
        this.action = parcel.readString();
        this.url = parcel.readString();
        this.bundle = parcel.readString();
        this.downloadAppName = parcel.readString();
        this.dplk = parcel.readString();
        this.price = parcel.readString();
        this.tid = parcel.readString();
        this.expires = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.createByteArray();
        this.d = parcel.readString();
        this.e = parcel.readString();
        this.f = parcel.readString();
        this.g = parcel.readString();
        this.h = parcel.readString();
        android.os.Parcelable.Creator<io.dcloud.sdk.base.entry.AdData.TrackerBean> creator = io.dcloud.sdk.base.entry.AdData.TrackerBean.CREATOR;
        this.i = parcel.createTypedArrayList(creator);
        this.j = parcel.createTypedArrayList(creator);
        this.k = parcel.createTypedArrayList(creator);
        this.l = (android.view.MotionEvent) parcel.readParcelable(android.view.MotionEvent.class.getClassLoader());
        this.m = (android.view.MotionEvent) parcel.readParcelable(android.view.MotionEvent.class.getClassLoader());
        this.n = parcel.readByte() != 0;
        this.o = (android.graphics.RectF) parcel.readParcelable(android.graphics.RectF.class.getClassLoader());
    }

    public java.lang.String b() {
        return this.h;
    }

    private void a(org.json.JSONObject jSONObject) {
        org.json.JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("report");
        if (jSONObjectOptJSONObject != null) {
            a(jSONObjectOptJSONObject.optJSONArray("imptracker"), this.i);
            a(jSONObjectOptJSONObject.optJSONArray("clktracker"), this.j);
            a(jSONObjectOptJSONObject.optJSONArray("dptracker"), this.k);
        }
    }

    private void a(org.json.JSONArray jSONArray, java.util.List list) {
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                org.json.JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    list.add(new io.dcloud.sdk.base.entry.AdData.TrackerBean(jSONObjectOptJSONObject.optString("url")));
                }
            }
        }
    }

    public void a(org.json.JSONObject jSONObject, io.dcloud.sdk.base.entry.AdData.e eVar, boolean z) {
        this.d = java.lang.String.valueOf(jSONObject.hashCode());
        a(jSONObject);
        a(jSONObject, eVar);
        int iOptInt = jSONObject.optInt("skip", com.nostra13.dcloudimageloader.core.download.BaseImageDownloader.DEFAULT_HTTP_CONNECT_TIMEOUT);
        this.a = iOptInt;
        if (iOptInt <= 0) {
            this.a = com.nostra13.dcloudimageloader.core.download.BaseImageDownloader.DEFAULT_HTTP_CONNECT_TIMEOUT;
        }
        this.e = jSONObject.optString("appid", "");
        this.h = jSONObject.optString("adpid", "");
        this.tid = jSONObject.optString("tid", "");
        this.g = jSONObject.optString("adid", "");
        this.f = jSONObject.optString("did", "");
        if (n() && z && !android.text.TextUtils.isEmpty(this.expires)) {
            b(jSONObject);
        }
    }

    public void a(android.view.MotionEvent motionEvent) {
        this.l = motionEvent;
    }

    public void a(android.content.Context context) {
        b(context);
    }

    java.lang.String a(java.lang.String str) {
        try {
            java.lang.String strReplace = str.replace("${User-Agent}", java.net.URLEncoder.encode(io.dcloud.p.n4.e(this.p), "utf-8")).replace("${click_id}", "");
            android.view.MotionEvent motionEvent = this.l;
            int iRound = com.dcloud.android.widget.dialog.DCloudAlertDialog.DARK_THEME;
            java.lang.String strReplace2 = strReplace.replace("${down_x}", java.lang.String.valueOf(motionEvent != null ? java.lang.Math.round(motionEvent.getX()) : com.dcloud.android.widget.dialog.DCloudAlertDialog.DARK_THEME));
            android.view.MotionEvent motionEvent2 = this.l;
            java.lang.String strReplace3 = strReplace2.replace("${down_y}", java.lang.String.valueOf(motionEvent2 != null ? java.lang.Math.round(motionEvent2.getY()) : com.dcloud.android.widget.dialog.DCloudAlertDialog.DARK_THEME));
            android.view.MotionEvent motionEvent3 = this.m;
            java.lang.String strReplace4 = strReplace3.replace("${up_x}", java.lang.String.valueOf(motionEvent3 != null ? java.lang.Math.round(motionEvent3.getX()) : com.dcloud.android.widget.dialog.DCloudAlertDialog.DARK_THEME));
            android.view.MotionEvent motionEvent4 = this.m;
            java.lang.String strReplace5 = strReplace4.replace("${up_y}", java.lang.String.valueOf(motionEvent4 != null ? java.lang.Math.round(motionEvent4.getY()) : com.dcloud.android.widget.dialog.DCloudAlertDialog.DARK_THEME));
            android.view.MotionEvent motionEvent5 = this.l;
            java.lang.String strReplace6 = strReplace5.replace("${relative_down_x}", java.lang.String.valueOf(motionEvent5 != null ? java.lang.Math.round(motionEvent5.getX() - this.o.left) : com.dcloud.android.widget.dialog.DCloudAlertDialog.DARK_THEME));
            android.view.MotionEvent motionEvent6 = this.l;
            java.lang.String strReplace7 = strReplace6.replace("${relative_down_y}", java.lang.String.valueOf(motionEvent6 != null ? java.lang.Math.round(motionEvent6.getY() - this.o.top) : com.dcloud.android.widget.dialog.DCloudAlertDialog.DARK_THEME));
            android.view.MotionEvent motionEvent7 = this.m;
            java.lang.String strReplace8 = strReplace7.replace("${relative_up_x}", java.lang.String.valueOf(motionEvent7 != null ? java.lang.Math.round(motionEvent7.getX() - this.o.left) : com.dcloud.android.widget.dialog.DCloudAlertDialog.DARK_THEME));
            android.view.MotionEvent motionEvent8 = this.m;
            if (motionEvent8 != null) {
                iRound = java.lang.Math.round(motionEvent8.getY() - this.o.top);
            }
            return strReplace8.replace("${relative_up_y}", java.lang.String.valueOf(iRound)).replace("${ts}", java.lang.String.valueOf(java.lang.System.currentTimeMillis()));
        } catch (java.io.UnsupportedEncodingException unused) {
            return str;
        }
    }

    private void a(java.util.List list) {
        java.util.Iterator it = list.iterator();
        while (it.hasNext()) {
            io.dcloud.p.x4.a().a(new io.dcloud.sdk.base.entry.AdData.c((io.dcloud.sdk.base.entry.AdData.TrackerBean) it.next()));
        }
    }

    public void a() {
        a(this.i);
    }

    public void a(android.graphics.RectF rectF) {
        this.o = rectF;
    }
}
