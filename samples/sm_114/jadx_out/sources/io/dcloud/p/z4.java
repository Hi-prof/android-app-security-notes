package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class z4 implements io.dcloud.p.u1, io.dcloud.p.x.a {
    protected io.dcloud.sdk.core.module.DCBaseAOL j;
    protected int o;
    private io.dcloud.p.k q;
    protected final io.dcloud.sdk.core.entry.DCloudAOLSlot r;
    protected final android.app.Activity s;
    private boolean a = false;
    protected volatile boolean b = false;
    private final java.util.List c = new java.util.ArrayList();
    private final java.util.concurrent.atomic.AtomicInteger d = new java.util.concurrent.atomic.AtomicInteger(0);
    private final io.dcloud.p.z4.b e = new io.dcloud.p.z4.b();
    protected java.util.List f = new java.util.ArrayList();
    protected java.util.List g = new java.util.ArrayList();
    protected java.util.List h = new java.util.ArrayList();
    protected java.util.Map i = new java.util.HashMap();
    protected java.util.List k = new java.util.ArrayList();
    private final java.util.List l = new java.util.ArrayList();
    private final java.util.Map m = new java.util.HashMap();
    private final java.util.List n = new java.util.ArrayList();
    protected boolean p = false;
    protected int t = Integer.MIN_VALUE;
    private java.lang.String u = "";

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    private static class b {
        private java.lang.Integer a;
        private java.lang.Integer b;

        private b() {
            this.a = 0;
            this.b = 0;
        }

        public boolean a(java.lang.Integer num) {
            return (num.compareTo(this.a) >= 0) && (num.compareTo(this.b) <= 0);
        }

        public boolean b(java.lang.Integer num) {
            return num.compareTo(this.b) <= 0;
        }

        public void c(java.lang.Integer num) {
            if (a(num)) {
                return;
            }
            if (num.intValue() > this.b.intValue()) {
                this.b = num;
            } else if (num.intValue() < this.a.intValue()) {
                this.a = num;
            }
        }

        public java.lang.String toString() {
            return java.lang.String.format("[%s, %s]", this.a, this.b);
        }
    }

    public z4(io.dcloud.sdk.core.entry.DCloudAOLSlot dCloudAOLSlot, android.app.Activity activity) {
        this.r = dCloudAOLSlot;
        this.s = activity;
    }

    private void f(int i) {
        java.util.concurrent.atomic.AtomicInteger atomicInteger = (java.util.concurrent.atomic.AtomicInteger) this.m.get(java.lang.Integer.valueOf(i));
        if (atomicInteger == null) {
            this.m.put(java.lang.Integer.valueOf(i), new java.util.concurrent.atomic.AtomicInteger(0));
        } else {
            atomicInteger.decrementAndGet();
        }
    }

    private void i() {
        io.dcloud.p.c3.d("ordered request list");
        n();
        if (g()) {
            p();
        }
    }

    private void n() {
        if (this.p || this.b) {
            return;
        }
        if (this.c.size() <= 0) {
            p();
            return;
        }
        io.dcloud.p.v4 v4Var = (io.dcloud.p.v4) this.c.remove(0);
        io.dcloud.sdk.core.module.DCBaseAOLLoader dCBaseAOLLoaderB = b(v4Var);
        if (dCBaseAOLLoaderB == null) {
            io.dcloud.p.c3.b("load sub slot fail cfg:" + v4Var.toString());
            this.d.decrementAndGet();
            n();
            return;
        }
        dCBaseAOLLoaderB.setLoadListener(this);
        this.h.add(dCBaseAOLLoaderB);
        dCBaseAOLLoaderB.setSlotAdInfo(v4Var);
        dCBaseAOLLoaderB.setLoadId(this.u);
        dCBaseAOLLoaderB.loadAd(null);
    }

    private void o() {
        if (!b()) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            if (this.i.size() > 0) {
                if (this.l.size() <= 0) {
                    for (java.util.List list : this.i.values()) {
                        if (list != null) {
                            arrayList.addAll(list);
                        }
                        if (arrayList.size() >= this.r.getCount()) {
                            break;
                        }
                    }
                } else {
                    for (java.lang.Integer num : this.l) {
                        for (io.dcloud.sdk.core.module.DCBaseAOL dCBaseAOL : this.f) {
                            if (dCBaseAOL.getShowSort() == num.intValue()) {
                                java.util.List list2 = (java.util.List) this.i.get(dCBaseAOL);
                                if (list2 != null) {
                                    arrayList.addAll(list2);
                                }
                                if (arrayList.size() >= this.r.getCount()) {
                                    break;
                                }
                            }
                        }
                        if (a(num) > 0) {
                            break;
                        }
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                if (arrayList.size() >= this.r.getCount()) {
                    this.k.addAll(arrayList.subList(0, this.r.getCount()));
                    q();
                } else if (g()) {
                    this.k.addAll(arrayList);
                    q();
                }
            }
        }
        r();
    }

    @Override // io.dcloud.p.u1
    public void a(io.dcloud.p.v4 v4Var) {
        this.e.c(java.lang.Integer.valueOf(v4Var.c()));
        this.c.add(v4Var);
    }

    @Override // io.dcloud.p.u1
    public boolean b() {
        return false;
    }

    @Override // io.dcloud.p.u1
    public int c() {
        return this.t;
    }

    @Override // io.dcloud.p.u1
    public void d(int i) {
        this.t = i;
    }

    @Override // io.dcloud.p.u1
    public boolean e(int i) {
        return this.e.b(java.lang.Integer.valueOf(i));
    }

    @Override // io.dcloud.p.u1
    public boolean g() {
        return this.p || this.d.get() <= 0;
    }

    @Override // io.dcloud.p.u1
    public void h() {
        if (this.c.isEmpty()) {
            p();
            return;
        }
        if (this.p) {
            p();
            return;
        }
        b(com.taobao.weex.el.parse.Operators.PLUS);
        if (b()) {
            a(false);
            return;
        }
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        org.json.JSONObject jSONObject2 = new org.json.JSONObject();
        if (this.c.size() <= 1) {
            this.d.incrementAndGet();
            i();
            return;
        }
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
        for (io.dcloud.p.v4 v4Var : this.c) {
            this.d.incrementAndGet();
            if (v4Var.t()) {
                try {
                    int iQ = v4Var.q();
                    if (iQ > 0) {
                        jSONObject.put(v4Var.o(), iQ);
                    }
                    int iG = v4Var.g();
                    if (iG > 0) {
                        org.json.JSONArray jSONArray = new org.json.JSONArray();
                        jSONArray.put(v4Var.l());
                        jSONArray.put(iG);
                        jSONObject2.put(v4Var.o(), jSONArray);
                    }
                } catch (java.lang.Exception unused) {
                }
            }
            linkedHashMap.put(v4Var.o(), v4Var);
        }
        if (jSONObject.length() <= 0 && jSONObject2.length() <= 0) {
            if (this.a) {
                i();
                return;
            } else {
                a(false);
                return;
            }
        }
        java.util.List listA = io.dcloud.p.n.a(this.s, new java.util.ArrayList(linkedHashMap.keySet()), this.r.getAdpid(), jSONObject, jSONObject2);
        this.c.clear();
        java.util.Iterator it = listA.iterator();
        while (it.hasNext()) {
            io.dcloud.p.v4 v4Var2 = (io.dcloud.p.v4) linkedHashMap.get((java.lang.String) it.next());
            if (v4Var2 != null) {
                this.c.add(v4Var2);
            }
        }
        if (this.a) {
            i();
        } else {
            a(true);
        }
    }

    @Override // io.dcloud.p.u1
    public void j() {
        if (this instanceof io.dcloud.p.y) {
            return;
        }
        this.a = true;
    }

    @Override // io.dcloud.p.u1
    public void k() {
        this.p = true;
        if (this.b) {
            return;
        }
        l();
        if (this.f.isEmpty()) {
            p();
            return;
        }
        java.util.Collections.sort(this.f, new java.util.Comparator() { // from class: io.dcloud.p.z4$$ExternalSyntheticLambda0
            @Override // java.util.Comparator
            public final int compare(java.lang.Object obj, java.lang.Object obj2) {
                return io.dcloud.p.z4.a((io.dcloud.sdk.core.module.DCBaseAOL) obj, (io.dcloud.sdk.core.module.DCBaseAOL) obj2);
            }
        });
        if (!m()) {
            this.j = (io.dcloud.sdk.core.module.DCBaseAOL) this.f.get(0);
            q();
            return;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator it = this.f.iterator();
        while (it.hasNext()) {
            java.util.List list = (java.util.List) this.i.get((io.dcloud.sdk.core.module.DCBaseAOL) it.next());
            if (list != null) {
                arrayList.addAll(list);
            }
            if (arrayList.size() >= this.r.getCount()) {
                break;
            }
        }
        if (arrayList.size() <= 0) {
            p();
            return;
        }
        if (arrayList.size() > this.r.getCount()) {
            this.k.addAll(arrayList.subList(0, this.r.getCount()));
        } else {
            this.k.addAll(arrayList);
        }
        q();
    }

    protected void l() {
        if (this.h.isEmpty()) {
            return;
        }
        this.h.removeAll(this.f);
        this.h.removeAll(this.g);
        java.util.Iterator it = this.h.iterator();
        while (it.hasNext()) {
            this.n.add(((io.dcloud.sdk.core.module.DCBaseAOLLoader) it.next()).makeFillRate());
        }
        this.h.clear();
    }

    boolean m() {
        int i = this.o;
        return i == 10 || i == 4 || i == 5;
    }

    protected void p() {
        if (this.b) {
            return;
        }
        io.dcloud.p.c3.a("current level load fail.level:" + this.t);
        this.b = true;
        l();
        io.dcloud.p.k kVar = this.q;
        if (kVar != null) {
            kVar.b(this);
        }
    }

    protected void q() {
        if (this.b) {
            return;
        }
        if (m()) {
            io.dcloud.p.c3.a("current level load success.level:" + this.t + ";count:" + this.k.size());
        } else {
            io.dcloud.p.c3.a("current level load success.level:" + this.t + ";slot:" + this.j.getSlotId() + ";ss:" + this.j.getShowSort());
        }
        this.b = true;
        l();
        io.dcloud.p.k kVar = this.q;
        if (kVar != null) {
            kVar.a(this);
        }
    }

    protected void r() {
        if (g()) {
            if (this.f.isEmpty()) {
                p();
            }
        } else if (this.a) {
            i();
        }
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("print all slot cfg:level:");
        sb.append(this.t);
        sb.append(";");
        for (io.dcloud.p.v4 v4Var : this.c) {
            sb.append(v4Var.l());
            sb.append(":");
            sb.append(v4Var.o());
            sb.append(":show:");
            sb.append(v4Var.n());
            sb.append(",");
        }
        return sb.toString();
    }

    protected io.dcloud.sdk.core.module.DCBaseAOLLoader b(io.dcloud.p.v4 v4Var) {
        io.dcloud.p.k kVar;
        io.dcloud.sdk.core.adapter.IAdAdapter iAdAdapterB = io.dcloud.p.e.b().b(v4Var.l());
        io.dcloud.p.b0 b0VarA = io.dcloud.p.c0.a().a(v4Var.l());
        if (iAdAdapterB == null && !io.dcloud.p.e.b().a(v4Var.l())) {
            if (b0VarA != null && b0VarA.h()) {
                try {
                    java.lang.Object objNewInstance = java.lang.Class.forName(b0VarA.d()).newInstance();
                    if (objNewInstance instanceof io.dcloud.api.custom.UniAdCustomAdapter) {
                        io.dcloud.p.e.b().a(v4Var.l(), (io.dcloud.api.custom.UniAdCustomAdapter) objNewInstance);
                        iAdAdapterB = (io.dcloud.api.custom.UniAdCustomAdapter) objNewInstance;
                    }
                } catch (java.lang.Exception unused) {
                }
            } else if (this.o == 1 && (iAdAdapterB = io.dcloud.p.e.b().b("dcloud")) == null) {
                iAdAdapterB = new io.dcloud.p.q0();
                io.dcloud.p.e.b().a("dcloud", iAdAdapterB);
            }
        }
        if (iAdAdapterB == null || !iAdAdapterB.isSupport()) {
            return null;
        }
        if (v4Var.l().equalsIgnoreCase("dcloud") && (kVar = this.q) != null) {
            io.dcloud.sdk.core.module.DCBaseAOLLoader dCBaseAOLLoaderI = kVar.i();
            dCBaseAOLLoaderI.setPlatform(null, "dcloud");
            return dCBaseAOLLoaderI;
        }
        io.dcloud.sdk.core.module.DCBaseAOLLoader ad = iAdAdapterB.getAd(this.s, this.r);
        if (b0VarA == null || ad == null) {
            return null;
        }
        if (b0VarA.h()) {
            ad.initSDK(b0VarA.a(), iAdAdapterB, b0VarA.e());
        } else {
            ad.initSDK(b0VarA.a(), b0VarA.b());
            if (b0VarA.g() != null) {
                ad.setPlatform(b0VarA.g(), b0VarA.c());
            }
        }
        return ad;
    }

    @Override // io.dcloud.p.u1
    public void c(int i) {
        java.util.Iterator it = this.c.iterator();
        while (it.hasNext()) {
            if (((io.dcloud.p.v4) it.next()).c() <= i) {
                it.remove();
            }
        }
    }

    @Override // io.dcloud.p.u1
    public java.util.List d() {
        return this.n;
    }

    @Override // io.dcloud.p.u1
    public java.util.List e() {
        if (m()) {
            return this.k;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(this.j);
        return arrayList;
    }

    @Override // io.dcloud.p.u1
    public void a(io.dcloud.p.k kVar) {
        this.q = kVar;
    }

    private void a(boolean z) {
        java.util.concurrent.atomic.AtomicInteger atomicInteger;
        int i = 0;
        this.d.set(0);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        int i2 = 0;
        for (io.dcloud.p.v4 v4Var : this.c) {
            io.dcloud.sdk.core.module.DCBaseAOLLoader dCBaseAOLLoaderB = b(v4Var);
            if (dCBaseAOLLoaderB != null) {
                this.d.incrementAndGet();
                if (z) {
                    v4Var.a(i2);
                    i2++;
                }
                dCBaseAOLLoaderB.setSlotAdInfo(v4Var);
                dCBaseAOLLoaderB.setLoadListener(this);
                arrayList.add(dCBaseAOLLoaderB);
                if (!this.l.contains(java.lang.Integer.valueOf(v4Var.n()))) {
                    this.l.add(java.lang.Integer.valueOf(v4Var.n()));
                }
                if (this.m.containsKey(java.lang.Integer.valueOf(v4Var.n()))) {
                    atomicInteger = (java.util.concurrent.atomic.AtomicInteger) this.m.get(java.lang.Integer.valueOf(v4Var.n()));
                } else {
                    atomicInteger = new java.util.concurrent.atomic.AtomicInteger(0);
                }
                atomicInteger.incrementAndGet();
                this.m.put(java.lang.Integer.valueOf(v4Var.n()), atomicInteger);
            } else {
                io.dcloud.p.c3.b("load sub slot fail cfg:" + v4Var.toString());
            }
        }
        io.dcloud.p.c3.a("level start load.current:" + this.t + ",valid ads:" + arrayList.size());
        if (arrayList.size() > 0) {
            if (this.l.size() > 1) {
                java.util.Collections.sort(this.l);
            }
            this.h.addAll(arrayList);
            int size = arrayList.size();
            while (i < size) {
                java.lang.Object obj = arrayList.get(i);
                i++;
                io.dcloud.sdk.core.module.DCBaseAOLLoader dCBaseAOLLoader = (io.dcloud.sdk.core.module.DCBaseAOLLoader) obj;
                dCBaseAOLLoader.setLoadId(this.u);
                dCBaseAOLLoader.loadAd(null);
            }
            return;
        }
        p();
    }

    @Override // io.dcloud.p.u1
    public int a() {
        if (m()) {
            java.util.List list = this.k;
            if (list == null || list.isEmpty()) {
                return -1;
            }
            io.dcloud.p.n.a(this.k);
            java.util.List list2 = this.k;
            return ((io.dcloud.sdk.core.module.DCBaseAOL) list2.get(list2.size() - 1)).getBiddingECPM();
        }
        io.dcloud.sdk.core.module.DCBaseAOL dCBaseAOL = this.j;
        if (dCBaseAOL != null) {
            return dCBaseAOL.getBiddingECPM();
        }
        return -1;
    }

    private void b(java.lang.String str) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (int i = 0; i < 70; i++) {
            sb.append(str);
        }
        io.dcloud.p.c3.d(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int a(io.dcloud.sdk.core.module.DCBaseAOL dCBaseAOL, io.dcloud.sdk.core.module.DCBaseAOL dCBaseAOL2) {
        return java.lang.Integer.compare(dCBaseAOL.getShowSort(), dCBaseAOL2.getShowSort());
    }

    public void a(io.dcloud.sdk.core.module.DCBaseAOLLoader dCBaseAOLLoader, java.util.List list, io.dcloud.p.n1 n1Var) {
        if (!this.u.equalsIgnoreCase(dCBaseAOLLoader.getLoadId()) || this.p || this.b) {
            return;
        }
        this.d.decrementAndGet();
        this.f.add(dCBaseAOLLoader);
        this.n.add(n1Var);
        f(dCBaseAOLLoader.getShowSort());
        io.dcloud.p.c3.d("level ad load success!current sub slot:" + dCBaseAOLLoader.getSlotId() + ";ss;" + dCBaseAOLLoader.getShowSort() + ";type;" + dCBaseAOLLoader.getType());
        if (m()) {
            this.i.put(dCBaseAOLLoader, list);
        }
        if (m()) {
            if (this.a) {
                this.k.addAll(list);
                q();
                r();
            } else {
                o();
            }
        } else {
            if (!b()) {
                if (this.l.size() > 1 && !this.a) {
                    java.util.Iterator it = this.l.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            java.lang.Integer num = (java.lang.Integer) it.next();
                            if (dCBaseAOLLoader.getShowSort() > num.intValue()) {
                                io.dcloud.p.c3.a("check ss smaller than this.ss:" + num + ";unfinished ss count:" + a(num));
                                if (a(num) > 0) {
                                    break;
                                }
                            }
                        } else {
                            this.j = dCBaseAOLLoader;
                            q();
                            break;
                        }
                    }
                } else {
                    this.j = dCBaseAOLLoader;
                    q();
                    break;
                }
            }
            r();
        }
        b(com.taobao.weex.el.parse.Operators.SUB);
    }

    private int a(java.lang.Integer num) {
        java.util.concurrent.atomic.AtomicInteger atomicInteger = (java.util.concurrent.atomic.AtomicInteger) this.m.get(num);
        if (atomicInteger == null) {
            return 0;
        }
        return atomicInteger.get();
    }

    public void a(io.dcloud.sdk.core.module.DCBaseAOLLoader dCBaseAOLLoader, io.dcloud.p.n1 n1Var) {
        if (!this.u.equalsIgnoreCase(dCBaseAOLLoader.getLoadId()) || this.p || this.b) {
            return;
        }
        this.d.decrementAndGet();
        this.g.add(dCBaseAOLLoader);
        this.n.add(n1Var);
        f(dCBaseAOLLoader.getShowSort());
        io.dcloud.p.c3.b("level ad load fail.current sub slot:" + dCBaseAOLLoader.getSlotId() + ";ss:" + dCBaseAOLLoader.getShowSort() + ";type:" + dCBaseAOLLoader.getType());
        if (m()) {
            o();
        } else {
            if (this.l.size() > 1 && !this.a && !b() && this.f.size() > 0) {
                for (java.lang.Integer num : this.l) {
                    if (dCBaseAOLLoader.getShowSort() <= num.intValue()) {
                        for (io.dcloud.sdk.core.module.DCBaseAOL dCBaseAOL : this.f) {
                            if (dCBaseAOL.getShowSort() == num.intValue()) {
                                io.dcloud.p.c3.b("check ss large than this.slot:" + dCBaseAOL.getSlotId() + ";ss:" + dCBaseAOL.getShowSort());
                                this.j = dCBaseAOL;
                                q();
                                break;
                            }
                        }
                        if (a(num) > 0) {
                            break;
                        }
                    } else if (dCBaseAOLLoader.getShowSort() > num.intValue()) {
                        io.dcloud.p.c3.b("check ss smaller than this.ss:" + num + ";unfinished ss count:" + a(num));
                        if (a(num) > 0) {
                            break;
                        }
                    } else {
                        continue;
                    }
                }
            }
            r();
        }
        b(com.taobao.weex.el.parse.Operators.SUB);
    }

    @Override // io.dcloud.p.u1
    public void a(int i) {
        this.o = i;
    }

    @Override // io.dcloud.p.u1
    public void a(java.lang.String str) {
        this.u = str;
    }
}
