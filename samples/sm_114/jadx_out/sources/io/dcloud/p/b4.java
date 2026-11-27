package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
class b4 {
    io.dcloud.p.s a;
    private java.util.ArrayList b = new java.util.ArrayList();
    private java.util.ArrayList c;

    b4(io.dcloud.p.s sVar) {
        this.a = null;
        java.util.ArrayList<java.lang.String> arrayList = new java.util.ArrayList<>();
        io.dcloud.common.util.BaseInfo.sRunningApp = arrayList;
        this.c = arrayList;
        this.a = sVar;
    }

    boolean a(io.dcloud.p.d5 d5Var, io.dcloud.common.DHInterface.ISysEventListener.SysEventType sysEventType, java.lang.Object obj) {
        boolean z = d5Var == null;
        int size = this.b.size();
        io.dcloud.p.d5 d5Var2 = null;
        boolean zOnExecute = false;
        for (int i = size - 1; i >= 0; i--) {
            io.dcloud.p.d5 d5Var3 = (io.dcloud.p.d5) this.b.get(i);
            if (z ? z : d5Var3 == d5Var) {
                zOnExecute |= d5Var3.onExecute(sysEventType, obj);
                if (zOnExecute && !io.dcloud.p.d5.a(sysEventType)) {
                    d5Var2 = d5Var3;
                    break;
                }
                d5Var2 = d5Var3;
            }
        }
        if (zOnExecute || !sysEventType.equals(io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onKeyUp) || size <= 1 || d5Var2 == null || ((java.lang.Integer) ((java.lang.Object[]) obj)[0]).intValue() != 4) {
            return zOnExecute;
        }
        this.a.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.WindowMgr, 20, d5Var2);
        return true;
    }

    io.dcloud.p.d5 b(java.lang.String str) {
        io.dcloud.p.d5 d5Var;
        java.util.ArrayList arrayList = this.b;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            java.lang.Object obj = arrayList.get(i);
            i++;
            d5Var = (io.dcloud.p.d5) obj;
            if (android.text.TextUtils.equals(d5Var.obtainAppId(), str)) {
                io.dcloud.common.adapter.util.Logger.d("AppCache", "removeWebApp " + d5Var + ";mAppIdList=" + this.c);
                this.b.remove(d5Var);
                this.c.remove(str);
                return d5Var;
            }
        }
        d5Var = null;
        io.dcloud.common.adapter.util.Logger.d("AppCache", "removeWebApp " + d5Var + ";mAppIdList=" + this.c);
        this.b.remove(d5Var);
        this.c.remove(str);
        return d5Var;
    }

    public io.dcloud.p.d5 c() {
        java.util.ArrayList arrayList = this.b;
        if (arrayList != null && arrayList.size() == 1) {
            return (io.dcloud.p.d5) this.b.get(0);
        }
        java.util.ArrayList arrayList2 = this.b;
        if (arrayList2 == null || arrayList2.size() < 1) {
            return null;
        }
        io.dcloud.p.d5 d5Var = (io.dcloud.p.d5) this.b.get(0);
        long j = d5Var.h1;
        for (int i = 1; i < this.b.size(); i++) {
            io.dcloud.p.d5 d5Var2 = (io.dcloud.p.d5) this.b.get(i);
            long j2 = d5Var2.h1;
            if (j < j2) {
                d5Var = d5Var2;
                j = j2;
            }
        }
        return d5Var;
    }

    public io.dcloud.p.d5 d() {
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        io.dcloud.p.d5 d5Var = null;
        for (int i = 0; i < this.b.size(); i++) {
            io.dcloud.p.d5 d5Var2 = (io.dcloud.p.d5) this.b.get(i);
            long j = d5Var2.h1;
            if (j < jCurrentTimeMillis) {
                d5Var = d5Var2;
                jCurrentTimeMillis = j;
            }
        }
        return d5Var;
    }

    protected int e() {
        return this.b.size();
    }

    protected io.dcloud.p.d5 b() {
        long j = 0;
        io.dcloud.p.d5 d5Var = null;
        for (int size = this.b.size() - 1; size >= 0; size--) {
            io.dcloud.p.d5 d5Var2 = (io.dcloud.p.d5) this.b.get(size);
            if (d5Var2.u == 3) {
                long j2 = d5Var2.h1;
                if (j2 > j) {
                    d5Var = d5Var2;
                    j = j2;
                }
            }
        }
        return d5Var;
    }

    protected io.dcloud.p.d5 a(java.lang.String str) {
        int iIndexOf = this.c.indexOf(str);
        if (iIndexOf >= 0) {
            return (io.dcloud.p.d5) this.b.get(iIndexOf);
        }
        return null;
    }

    void a(java.lang.String str, io.dcloud.p.d5 d5Var) {
        this.c.add(str);
        this.b.add(d5Var);
    }

    protected io.dcloud.p.d5 a(android.app.Activity activity, io.dcloud.p.d5 d5Var) {
        if (this.b.contains(d5Var)) {
            return null;
        }
        java.lang.System.currentTimeMillis();
        if (this.b.size() >= io.dcloud.common.util.BaseInfo.s_Runing_App_Count_Max) {
            return d();
        }
        return null;
    }

    void a() {
        this.b.clear();
        this.c.clear();
    }
}
