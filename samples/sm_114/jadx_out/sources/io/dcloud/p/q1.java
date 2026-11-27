package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class q1 {
    private static io.dcloud.p.q1 c;
    private final java.lang.String a = "UNIAPP_HostPicker_0817";
    private final java.lang.String b = "SP_LAST_SUIT_HOST_NAME_0817";

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public static class a implements java.lang.Comparable, java.lang.Cloneable {
        java.lang.String a;
        io.dcloud.p.q1.a.EnumC0072a b;

        /* JADX INFO: renamed from: io.dcloud.p.q1$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
        public enum EnumC0072a {
            NORMAL(0),
            FIRST(1),
            BACKUP(-1);

            int a;

            EnumC0072a(int i) {
                this.a = i;
            }
        }

        public a(java.lang.String str, io.dcloud.p.q1.a.EnumC0072a enumC0072a) {
            io.dcloud.p.q1.a.EnumC0072a enumC0072a2 = io.dcloud.p.q1.a.EnumC0072a.NORMAL;
            this.a = str;
            this.b = enumC0072a;
        }

        public java.lang.String a() {
            java.lang.String str = "";
            if (android.text.TextUtils.isEmpty(this.a)) {
                return "";
            }
            try {
                str = new java.lang.String(android.util.Base64.decode(this.a.getBytes("UTF-8"), 2), "UTF-8");
            } catch (java.io.UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return io.dcloud.p.s4.d(str);
        }

        public boolean b() {
            return !android.text.TextUtils.isEmpty(this.a);
        }

        public boolean equals(java.lang.Object obj) {
            if (!(obj instanceof io.dcloud.p.q1.a)) {
                return false;
            }
            io.dcloud.p.q1.a aVar = (io.dcloud.p.q1.a) obj;
            if (android.text.TextUtils.isEmpty(aVar.a)) {
                return false;
            }
            return aVar.a.equals(this.a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public java.lang.String toString() {
            return "Host{hostUrl='" + this.a + "', priority=" + this.b + com.taobao.weex.el.parse.Operators.BLOCK_END;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
        public io.dcloud.p.q1.a m496clone() {
            return new io.dcloud.p.q1.a(this.a, this.b);
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(io.dcloud.p.q1.a aVar) {
            if (aVar == null) {
                return 1;
            }
            return aVar.b.a - this.b.a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public interface b {
        void a(io.dcloud.p.q1.a aVar);

        boolean b(io.dcloud.p.q1.a aVar);

        void onNoOnePicked();
    }

    private q1() {
    }

    private void a(android.content.Context context, java.util.List list, java.lang.String str) {
        java.lang.String str2 = "SP_LAST_SUIT_HOST_NAME_0817" + str;
        android.content.SharedPreferences sharedPreferences = context.getSharedPreferences("UNIAPP_HostPicker_0817", 0);
        java.lang.String string = sharedPreferences.getString(str2, "");
        java.util.Iterator it = list.iterator();
        while (it.hasNext()) {
            io.dcloud.p.q1.a aVar = (io.dcloud.p.q1.a) it.next();
            if (!aVar.b()) {
                throw new java.lang.RuntimeException("error format host");
            }
            if (!android.text.TextUtils.isEmpty(string)) {
                if (string.equals(aVar.a)) {
                    aVar.b = io.dcloud.p.q1.a.EnumC0072a.FIRST;
                } else {
                    aVar.b = io.dcloud.p.q1.a.EnumC0072a.NORMAL;
                }
            }
        }
        sharedPreferences.edit().remove(str2).apply();
    }

    public static io.dcloud.p.q1 a() {
        if (c == null) {
            synchronized (io.dcloud.p.q1.class) {
                if (c == null) {
                    c = new io.dcloud.p.q1();
                }
            }
        }
        return c;
    }

    public void a(android.content.Context context, java.util.List list, java.lang.String str, io.dcloud.p.q1.b bVar) {
        if (list != null && !list.isEmpty()) {
            a(context, list, str);
            java.util.Collections.sort(list);
            java.util.Iterator it = list.iterator();
            while (it.hasNext()) {
                io.dcloud.p.q1.a aVar = (io.dcloud.p.q1.a) it.next();
                if (bVar.b(aVar)) {
                    if (aVar.b != io.dcloud.p.q1.a.EnumC0072a.BACKUP) {
                        context.getSharedPreferences("UNIAPP_HostPicker_0817", 0).edit().putString("SP_LAST_SUIT_HOST_NAME_0817" + str, aVar.a).apply();
                    }
                    bVar.a(aVar);
                    return;
                }
            }
            bVar.onNoOnePicked();
            return;
        }
        throw new java.lang.RuntimeException("call initHosts first");
    }
}
