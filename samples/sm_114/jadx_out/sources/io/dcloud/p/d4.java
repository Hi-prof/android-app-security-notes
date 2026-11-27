package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
class d4 {
    io.dcloud.common.DHInterface.AbsMgr a;
    java.util.concurrent.ConcurrentHashMap b = new java.util.concurrent.ConcurrentHashMap();
    java.util.ArrayList c = new java.util.ArrayList();

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class a implements io.dcloud.common.adapter.util.MessageHandler.IMessages {
        final /* synthetic */ io.dcloud.p.d4.c a;

        /* JADX INFO: renamed from: io.dcloud.p.d4$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
        class C0070a implements io.dcloud.common.DHInterface.ICallBack {
            C0070a() {
            }

            @Override // io.dcloud.common.DHInterface.ICallBack
            public java.lang.Object onCallBack(int i, java.lang.Object obj) {
                if (i == -1) {
                    android.util.Log.i("console", "nativeApp pull fail");
                } else if (i == 1) {
                    android.util.Log.i("console", "nativeApp pull success");
                }
                io.dcloud.p.d4.this.b.clear();
                io.dcloud.p.d4.this.a();
                return null;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
        class b implements java.lang.Runnable {
            final /* synthetic */ java.lang.String a;

            b(java.lang.String str) {
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (io.dcloud.common.adapter.io.DHFile.delete(this.a)) {
                    android.util.Log.i("console", "rm file success");
                } else {
                    android.util.Log.i("console", "rm file fail");
                }
                io.dcloud.p.d4.this.b.clear();
                io.dcloud.p.d4.this.a();
            }
        }

        a(io.dcloud.p.d4.c cVar) {
            this.a = cVar;
        }

        @Override // io.dcloud.common.adapter.util.MessageHandler.IMessages
        public void execute(java.lang.Object obj) throws java.lang.Throwable {
            java.lang.String str = this.a.a;
            str.getClass();
            str.hashCode();
            switch (str) {
                case "delete":
                    java.lang.String str2 = this.a.b;
                    if (!new java.io.File(str2).exists()) {
                        android.util.Log.i("console", "rm file fail");
                        io.dcloud.p.d4.this.b.clear();
                        io.dcloud.p.d4.this.a();
                        break;
                    } else {
                        io.dcloud.common.util.ThreadPool.self().addSingleThreadTask(new io.dcloud.p.d4.a.b(str2));
                        break;
                    }
                    break;
                case "script":
                    java.lang.String str3 = this.a.b;
                    if ("restart".equals(str3)) {
                        io.dcloud.p.d4.this.a.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.AppMgr, 3, "snc:CID");
                    } else if (io.dcloud.common.constant.AbsoluteConst.JSON_KEY_DEBUG_REFRESH.equals(str3)) {
                        io.dcloud.p.d4.this.a.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.AppMgr, 27, null);
                    } else if ("restartAndRun".equals(str3)) {
                        io.dcloud.p.d4.this.a.getContext().startActivity(android.content.Intent.makeRestartActivityTask(io.dcloud.p.d4.this.a.getContext().getPackageManager().getLaunchIntentForPackage(io.dcloud.p.d4.this.a.getContext().getPackageName()).getComponent()));
                        java.lang.Runtime.getRuntime().exit(0);
                    }
                    io.dcloud.p.d4.this.b.clear();
                    io.dcloud.p.d4.this.a();
                    break;
                case "update":
                    java.lang.String str4 = this.a.b;
                    if ("all".equals(str4)) {
                        io.dcloud.p.d4.this.a.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.WindowMgr, 13, null);
                    } else if ("current".equals(str4)) {
                        io.dcloud.p.d4.this.a.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.WindowMgr, 12, null);
                    } else {
                        io.dcloud.p.d4.this.a.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.WindowMgr, 14, str4);
                    }
                    io.dcloud.p.d4.this.b.clear();
                    io.dcloud.p.d4.this.a();
                    break;
                case "pull":
                    java.lang.String str5 = this.a.b;
                    if (!android.text.TextUtils.isEmpty(str5)) {
                        io.dcloud.p.d4.this.a(str5, new io.dcloud.p.d4.a.C0070a());
                        break;
                    }
                    break;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class b implements java.lang.Runnable {
        final /* synthetic */ java.lang.String a;
        final /* synthetic */ java.lang.String b;
        final /* synthetic */ java.io.File c;
        final /* synthetic */ io.dcloud.common.DHInterface.ICallBack d;

        b(java.lang.String str, java.lang.String str2, java.io.File file, io.dcloud.common.DHInterface.ICallBack iCallBack) {
            this.a = str;
            this.b = str2;
            this.c = file;
            this.d = iCallBack;
        }

        @Override // java.lang.Runnable
        public void run() {
            int iCopyFile = io.dcloud.common.adapter.io.DHFile.copyFile(this.a, this.b);
            io.dcloud.common.adapter.io.DHFile.delete(this.c.getParent());
            if (iCopyFile == 1) {
                io.dcloud.common.DHInterface.ICallBack iCallBack = this.d;
                if (iCallBack != null) {
                    iCallBack.onCallBack(1, null);
                    return;
                }
                return;
            }
            io.dcloud.common.DHInterface.ICallBack iCallBack2 = this.d;
            if (iCallBack2 != null) {
                iCallBack2.onCallBack(-1, null);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class c {
        java.lang.String a;
        java.lang.String b;

        c() {
        }
    }

    d4(io.dcloud.common.DHInterface.AbsMgr absMgr) {
        this.a = null;
        this.a = absMgr;
    }

    private java.util.ArrayList b(java.lang.String str) {
        java.util.ArrayList arrayList = new java.util.ArrayList(1);
        if (str.startsWith(io.dcloud.common.constant.AbsoluteConst.SOCKET_NATIVE_COMMAND)) {
            str = str.substring(4);
        }
        java.lang.String strTrim = str.trim();
        int length = strTrim.length();
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            char cCharAt = strTrim.charAt(i2);
            i2++;
            if (i2 == length || ((b(cCharAt) && arrayList2.size() % 2 == 0) || a(cCharAt))) {
                java.lang.String strTrim2 = strTrim.substring(i3, i2).trim();
                if (!"".equals(strTrim2)) {
                    arrayList2.add(strTrim2);
                    i3 = i2;
                }
            }
        }
        int size = arrayList2.size();
        while (i < size) {
            io.dcloud.p.d4.c cVar = new io.dcloud.p.d4.c();
            cVar.a = (java.lang.String) arrayList2.get(i);
            cVar.b = (java.lang.String) arrayList2.get(i + 1);
            i += 2;
            arrayList.add(cVar);
        }
        return arrayList;
    }

    synchronized void a(java.lang.String str) {
        java.util.ArrayList arrayListB = b(str);
        if (arrayListB != null && !arrayListB.isEmpty()) {
            this.c.addAll(arrayListB);
        }
        a();
    }

    boolean a(char c2) {
        return c2 == '\r' || c2 == '\n';
    }

    boolean b(char c2) {
        return c2 == '\t' || c2 == 11 || c2 == '\f' || c2 == ' ' || c2 == 160 || c2 == 12288;
    }

    public synchronized void a() {
        java.util.ArrayList arrayList;
        io.dcloud.p.d4.c cVar;
        if (!this.b.isEmpty() || (arrayList = this.c) == null || arrayList.isEmpty() || (cVar = (io.dcloud.p.d4.c) this.c.remove(0)) == null) {
            return;
        }
        this.b.put("runing", cVar);
        a(cVar);
    }

    public void a(io.dcloud.p.d4.c cVar) {
        io.dcloud.common.adapter.util.MessageHandler.sendMessage(new io.dcloud.p.d4.a(cVar), null);
    }

    public synchronized void a(java.lang.String str, io.dcloud.common.DHInterface.ICallBack iCallBack) throws java.lang.Throwable {
        java.lang.Throwable th;
        org.json.JSONObject jSONObject;
        try {
            try {
                if (!io.dcloud.common.util.PdrUtil.isEmpty(str)) {
                    try {
                        try {
                            jSONObject = new org.json.JSONObject(str);
                        } catch (org.json.JSONException e) {
                            e.printStackTrace();
                            jSONObject = null;
                        }
                        if (jSONObject == null) {
                            android.util.Log.i("console", "nativeApp pull fail");
                            if (iCallBack != null) {
                                iCallBack.onCallBack(-1, null);
                            }
                        } else {
                            java.lang.String strOptString = jSONObject.optString("appid");
                            java.lang.String strOptString2 = jSONObject.optString("filePath");
                            if (!android.text.TextUtils.isEmpty(strOptString) && !android.text.TextUtils.isEmpty(strOptString2)) {
                                java.lang.String str2 = io.dcloud.common.util.BaseInfo.sBaseFsAppsPath + strOptString + "/www";
                                java.io.File file = new java.io.File(strOptString2);
                                if (file.exists()) {
                                    io.dcloud.common.util.ThreadPool.self().addSingleThreadTask(new io.dcloud.p.d4.b(strOptString2, str2, file, iCallBack));
                                } else {
                                    android.util.Log.i("console", "nativeApp pull fail");
                                    if (iCallBack != null) {
                                        iCallBack.onCallBack(-1, null);
                                    }
                                }
                            } else {
                                android.util.Log.i("console", "nativeApp pull fail");
                                if (iCallBack != null) {
                                    iCallBack.onCallBack(-1, null);
                                }
                            }
                        }
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                        throw th;
                    }
                }
            } catch (java.lang.Throwable th3) {
                th = th3;
                th = th;
                throw th;
            }
        } catch (java.lang.Throwable th4) {
            th = th4;
        }
    }
}
