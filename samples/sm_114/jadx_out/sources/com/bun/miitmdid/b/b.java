package com.bun.miitmdid.b;

/* JADX INFO: loaded from: classes.dex */
public class b {
    private static boolean h;
    private java.lang.String a = null;
    private com.bun.miitmdid.b.b.InterfaceC0010b b = null;
    private java.lang.Object c = null;
    private java.util.Map<java.lang.String, java.lang.String> d = new java.util.HashMap();
    private java.util.Map<java.lang.String, java.lang.String> e = new java.util.HashMap();
    private java.util.Map<java.lang.String, java.lang.String> f = new java.util.HashMap();
    private java.lang.String g = "GET";

    class a extends android.os.AsyncTask<java.lang.Void, java.lang.Void, com.bun.miitmdid.b.b.c> {
        com.bun.miitmdid.b.b a;

        a() {
            this.a = com.bun.miitmdid.b.b.this;
        }

        protected native com.bun.miitmdid.b.b.c a(java.lang.Void... voidArr);

        protected native void a(com.bun.miitmdid.b.b.c cVar);

        @Override // android.os.AsyncTask
        protected native /* bridge */ /* synthetic */ com.bun.miitmdid.b.b.c doInBackground(java.lang.Void[] voidArr);

        @Override // android.os.AsyncTask
        protected native /* bridge */ /* synthetic */ void onPostExecute(com.bun.miitmdid.b.b.c cVar);
    }

    /* JADX INFO: renamed from: com.bun.miitmdid.b.b$b, reason: collision with other inner class name */
    public interface InterfaceC0010b {
        void a(java.lang.Exception exc, int i, java.lang.String str);
    }

    private class c {
        private java.lang.String a;
        private int b;
        private java.lang.Exception c;

        public c(com.bun.miitmdid.b.b bVar, java.lang.String str, java.lang.Exception exc, int i) {
            this.a = str;
            this.c = exc;
            this.b = i;
        }

        static native /* synthetic */ java.lang.Exception a(com.bun.miitmdid.b.b.c cVar);

        static native /* synthetic */ int b(com.bun.miitmdid.b.b.c cVar);

        static native /* synthetic */ java.lang.String c(com.bun.miitmdid.b.b.c cVar);
    }

    private b(android.content.Context context) {
    }

    public static native com.bun.miitmdid.b.b a(android.content.Context context);

    static native /* synthetic */ java.lang.String a(com.bun.miitmdid.b.b bVar);

    private native void a(java.net.HttpURLConnection httpURLConnection);

    private native com.bun.miitmdid.b.b.c b();

    static native /* synthetic */ com.bun.miitmdid.b.b.c b(com.bun.miitmdid.b.b bVar);

    private static native void b(java.lang.String str);

    private native com.bun.miitmdid.b.b.c c();

    static native /* synthetic */ com.bun.miitmdid.b.b.c c(com.bun.miitmdid.b.b bVar);

    static native /* synthetic */ com.bun.miitmdid.b.b.InterfaceC0010b d(com.bun.miitmdid.b.b bVar);

    private native java.lang.String d();

    public native com.bun.miitmdid.b.b a();

    public native com.bun.miitmdid.b.b a(com.bun.miitmdid.b.b.InterfaceC0010b interfaceC0010b);

    public native com.bun.miitmdid.b.b a(java.lang.Object obj);

    public native com.bun.miitmdid.b.b a(java.lang.String str);

    public native com.bun.miitmdid.b.b a(java.lang.String str, java.lang.String str2);

    public native com.bun.miitmdid.b.b a(java.util.Map<java.lang.String, java.lang.String> map);
}
