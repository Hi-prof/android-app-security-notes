package io.dcloud.js.camera;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class CameraFeatureImpl implements io.dcloud.common.DHInterface.IFeature {
    io.dcloud.common.DHInterface.AbsMgr a = null;
    private boolean b = false;
    private final java.util.List c = new java.util.ArrayList();

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class b extends io.dcloud.common.adapter.util.PermissionUtil.StreamPermissionRequest {
        final /* synthetic */ java.lang.String[] a;
        final /* synthetic */ io.dcloud.common.DHInterface.IApp b;
        final /* synthetic */ io.dcloud.common.DHInterface.IWebview c;
        final /* synthetic */ java.lang.String d;

        /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
        class a implements io.dcloud.common.DHInterface.ISysEventListener {
            final /* synthetic */ java.lang.String a;
            final /* synthetic */ io.dcloud.js.camera.a.C0066a b;
            final /* synthetic */ java.lang.String c;

            /* JADX INFO: renamed from: io.dcloud.js.camera.CameraFeatureImpl$b$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
            class C0065a implements androidtranscoder.MediaTranscoder.Listener {
                final /* synthetic */ android.app.Dialog a;

                C0065a(android.app.Dialog dialog) {
                    this.a = dialog;
                }

                @Override // androidtranscoder.MediaTranscoder.Listener
                public void onTranscodeCanceled() {
                    this.a.dismiss();
                    io.dcloud.js.camera.CameraFeatureImpl.b.a aVar = io.dcloud.js.camera.CameraFeatureImpl.b.a.this;
                    io.dcloud.js.camera.CameraFeatureImpl.this.a(aVar.b.h, aVar.a);
                    java.lang.String json = io.dcloud.common.constant.DOMException.toJSON(-2, io.dcloud.common.constant.DOMException.MSG_USER_CANCEL);
                    io.dcloud.js.camera.CameraFeatureImpl.b bVar = io.dcloud.js.camera.CameraFeatureImpl.b.this;
                    io.dcloud.common.util.Deprecated_JSUtil.execCallback(bVar.c, bVar.d, json, io.dcloud.common.util.JSUtil.ERROR, true, false);
                }

                @Override // androidtranscoder.MediaTranscoder.Listener
                public void onTranscodeCompleted() {
                    this.a.dismiss();
                    io.dcloud.js.camera.CameraFeatureImpl.b.a aVar = io.dcloud.js.camera.CameraFeatureImpl.b.a.this;
                    io.dcloud.js.camera.CameraFeatureImpl.this.a(aVar.b.h, aVar.a);
                    io.dcloud.js.camera.CameraFeatureImpl.b.a aVar2 = io.dcloud.js.camera.CameraFeatureImpl.b.a.this;
                    java.lang.String strConvert2RelPath = io.dcloud.js.camera.CameraFeatureImpl.b.this.b.convert2RelPath(aVar2.c);
                    io.dcloud.js.camera.CameraFeatureImpl.b bVar = io.dcloud.js.camera.CameraFeatureImpl.b.this;
                    io.dcloud.common.util.Deprecated_JSUtil.execCallback(bVar.c, bVar.d, strConvert2RelPath, io.dcloud.common.util.JSUtil.OK, false, false);
                }

                @Override // androidtranscoder.MediaTranscoder.Listener
                public void onTranscodeFailed(java.lang.Exception exc) {
                    this.a.dismiss();
                    io.dcloud.js.camera.CameraFeatureImpl.b.a aVar = io.dcloud.js.camera.CameraFeatureImpl.b.a.this;
                    io.dcloud.js.camera.CameraFeatureImpl.this.a(aVar.b.h, aVar.a);
                    java.lang.String json = io.dcloud.common.constant.DOMException.toJSON(-99, exc.getMessage());
                    io.dcloud.js.camera.CameraFeatureImpl.b bVar = io.dcloud.js.camera.CameraFeatureImpl.b.this;
                    io.dcloud.common.util.Deprecated_JSUtil.execCallback(bVar.c, bVar.d, json, io.dcloud.common.util.JSUtil.ERROR, true, false);
                }

                @Override // androidtranscoder.MediaTranscoder.Listener
                public void onTranscodeProgress(double d) {
                }
            }

            a(java.lang.String str, io.dcloud.js.camera.a.C0066a c0066a, java.lang.String str2) {
                this.a = str;
                this.b = c0066a;
                this.c = str2;
            }

            @Override // io.dcloud.common.DHInterface.ISysEventListener
            public boolean onExecute(io.dcloud.common.DHInterface.ISysEventListener.SysEventType sysEventType, java.lang.Object obj) {
                java.lang.Object[] objArr = (java.lang.Object[]) obj;
                int iIntValue = ((java.lang.Integer) objArr[0]).intValue();
                int iIntValue2 = ((java.lang.Integer) objArr[1]).intValue();
                if (sysEventType == io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onActivityResult && iIntValue == io.dcloud.js.camera.a.f) {
                    if (iIntValue2 != -1) {
                        io.dcloud.js.camera.CameraFeatureImpl.b bVar = io.dcloud.js.camera.CameraFeatureImpl.b.this;
                        io.dcloud.common.util.Deprecated_JSUtil.execCallback(bVar.c, bVar.d, null, io.dcloud.common.util.JSUtil.ERROR, false, false);
                    } else {
                        if (!new java.io.File(this.a).exists() && io.dcloud.common.adapter.io.DHFile.copyFile(io.dcloud.common.adapter.util.ContentUriUtil.getImageAbsolutePath(io.dcloud.js.camera.CameraFeatureImpl.b.this.b.getActivity(), ((android.content.Intent) objArr[2]).getData()), this.a) != 1) {
                            io.dcloud.js.camera.CameraFeatureImpl.b bVar2 = io.dcloud.js.camera.CameraFeatureImpl.b.this;
                            io.dcloud.common.util.Deprecated_JSUtil.execCallback(bVar2.c, bVar2.d, null, io.dcloud.common.util.JSUtil.ERROR, false, false);
                            io.dcloud.js.camera.CameraFeatureImpl.b.this.b.unregisterSysEventListener(this, sysEventType);
                            return false;
                        }
                        android.app.Dialog dialogA = null;
                        try {
                            if (this.b.h) {
                                dialogA = io.dcloud.js.camera.b.a(io.dcloud.js.camera.CameraFeatureImpl.b.this.c.getContext());
                                dialogA.show();
                                androidtranscoder.MediaTranscoder.getInstance().transcodeVideo(this.a, this.c, androidtranscoder.format.MediaFormatStrategyPresets.createAndroid720pStrategy(2, 1.0d), new io.dcloud.js.camera.CameraFeatureImpl.b.a.C0065a(dialogA));
                            } else {
                                java.lang.String strConvert2RelPath = io.dcloud.js.camera.CameraFeatureImpl.b.this.b.convert2RelPath(this.c);
                                io.dcloud.js.camera.CameraFeatureImpl.b bVar3 = io.dcloud.js.camera.CameraFeatureImpl.b.this;
                                io.dcloud.common.util.Deprecated_JSUtil.execCallback(bVar3.c, bVar3.d, strConvert2RelPath, io.dcloud.common.util.JSUtil.OK, false, false);
                            }
                        } catch (java.io.IOException e) {
                            if (dialogA != null) {
                                dialogA.dismiss();
                            }
                            io.dcloud.js.camera.CameraFeatureImpl.this.a(this.b.h, this.a);
                            java.lang.String json = io.dcloud.common.constant.DOMException.toJSON(-99, e.getMessage());
                            io.dcloud.js.camera.CameraFeatureImpl.b bVar4 = io.dcloud.js.camera.CameraFeatureImpl.b.this;
                            io.dcloud.common.util.Deprecated_JSUtil.execCallback(bVar4.c, bVar4.d, json, io.dcloud.common.util.JSUtil.ERROR, true, false);
                        }
                    }
                    io.dcloud.js.camera.CameraFeatureImpl.b.this.b.unregisterSysEventListener(this, sysEventType);
                }
                return false;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(io.dcloud.common.DHInterface.IApp iApp, java.lang.String[] strArr, io.dcloud.common.DHInterface.IApp iApp2, io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str) {
            super(iApp);
            this.a = strArr;
            this.b = iApp2;
            this.c = iWebview;
            this.d = str;
        }

        @Override // io.dcloud.common.adapter.util.PermissionUtil.Request
        public void onDenied(java.lang.String str) {
            io.dcloud.common.util.Deprecated_JSUtil.execCallback(this.c, this.d, io.dcloud.common.constant.DOMException.toJSON(11, io.dcloud.common.constant.DOMException.MSG_NO_PERMISSION), io.dcloud.common.util.JSUtil.ERROR, true, false);
        }

        @Override // io.dcloud.common.adapter.util.PermissionUtil.Request
        public void onGranted(java.lang.String str) {
            java.lang.String str2;
            try {
                io.dcloud.js.camera.a.C0066a c0066aA = io.dcloud.js.camera.a.a(this.a[1], false);
                java.lang.String strConvert2AbsFullPath = this.b.convert2AbsFullPath(this.c.obtainFullUrl(), c0066aA.a());
                if (io.dcloud.common.util.JSUtil.checkOperateDirErrorAndCallback(this.c, this.d, strConvert2AbsFullPath)) {
                    io.dcloud.common.util.Deprecated_JSUtil.execCallback(this.c, this.d, io.dcloud.common.constant.DOMException.toJSON(-5, io.dcloud.common.constant.DOMException.MSG_IO_ERROR), io.dcloud.common.util.JSUtil.ERROR, true, false);
                    return;
                }
                if (c0066aA.h) {
                    str2 = strConvert2AbsFullPath + ".temp";
                } else {
                    str2 = strConvert2AbsFullPath;
                }
                java.io.File file = new java.io.File(str2);
                java.io.File parentFile = file.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
                this.b.registerSysEventListener(new io.dcloud.js.camera.CameraFeatureImpl.b.a(str2, c0066aA, strConvert2AbsFullPath), io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onActivityResult);
                android.content.Intent intent = new android.content.Intent("android.media.action.VIDEO_CAPTURE");
                if (c0066aA.b() != 0) {
                    intent.putExtra("android.intent.extra.durationLimit", c0066aA.b());
                }
                if (android.os.Build.VERSION.SDK_INT >= 29) {
                    intent.putExtra("output", androidx.core.content.FileProvider.getUriForFile(this.c.getContext(), this.c.getContext().getPackageName() + ".dc.fileprovider", file));
                }
                this.c.getActivity().startActivityForResult(intent, io.dcloud.js.camera.a.f);
            } catch (java.lang.Exception e) {
                io.dcloud.common.util.Deprecated_JSUtil.execCallback(this.c, this.d, io.dcloud.common.constant.DOMException.toJSON(11, e.getMessage()), io.dcloud.common.util.JSUtil.ERROR, true, false);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class c extends io.dcloud.common.adapter.util.PermissionUtil.StreamPermissionRequest {
        final /* synthetic */ io.dcloud.js.camera.a a;
        final /* synthetic */ java.lang.String[] b;
        final /* synthetic */ io.dcloud.common.DHInterface.IWebview c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(io.dcloud.common.DHInterface.IApp iApp, io.dcloud.js.camera.a aVar, java.lang.String[] strArr, io.dcloud.common.DHInterface.IWebview iWebview) {
            super(iApp);
            this.a = aVar;
            this.b = strArr;
            this.c = iWebview;
        }

        @Override // io.dcloud.common.adapter.util.PermissionUtil.Request
        public void onDenied(java.lang.String str) {
            io.dcloud.js.camera.CameraFeatureImpl.this.b = false;
            java.util.Iterator it = io.dcloud.js.camera.CameraFeatureImpl.this.c.iterator();
            while (it.hasNext()) {
                ((io.dcloud.common.adapter.util.PermissionUtil.Request) it.next()).onDenied(str);
            }
            io.dcloud.js.camera.CameraFeatureImpl.this.c.clear();
        }

        @Override // io.dcloud.common.adapter.util.PermissionUtil.Request
        public void onGranted(java.lang.String str) {
            this.a.b();
            io.dcloud.js.camera.CameraFeatureImpl.this.b = false;
            java.util.Iterator it = io.dcloud.js.camera.CameraFeatureImpl.this.c.iterator();
            while (it.hasNext()) {
                ((io.dcloud.common.adapter.util.PermissionUtil.Request) it.next()).onGranted(str);
            }
            io.dcloud.js.camera.CameraFeatureImpl.this.c.clear();
            java.lang.String[] strArr = this.b;
            if (strArr.length >= 3) {
                io.dcloud.common.util.Deprecated_JSUtil.execCallback(this.c, strArr[2], this.a.a(), io.dcloud.common.util.JSUtil.OK, true, false);
            }
        }
    }

    @Override // io.dcloud.common.DHInterface.IFeature
    public void dispose(java.lang.String str) {
    }

    @Override // io.dcloud.common.DHInterface.IFeature
    public java.lang.String execute(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.String[] strArr) {
        io.dcloud.common.DHInterface.IApp iAppObtainApp = iWebview.obtainFrameView().obtainApp();
        io.dcloud.common.util.AppRuntime.checkPrivacyComplianceAndPrompt(iWebview.getContext(), "Camera-" + str);
        java.lang.String str2 = strArr[0];
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            android.os.StrictMode.setVmPolicy(new android.os.StrictMode.VmPolicy.Builder().build());
        }
        if (str.equals("captureImage")) {
            io.dcloud.js.camera.a.C0066a c0066aA = io.dcloud.js.camera.a.a(strArr[1], true);
            java.lang.String strConvert2AbsFullPath = iAppObtainApp.convert2AbsFullPath(iWebview.obtainFullUrl(), c0066aA.a());
            if (!io.dcloud.common.util.FileUtil.checkPrivatePath(iWebview.getContext(), strConvert2AbsFullPath) && io.dcloud.common.util.FileUtil.getPathForPublicType(strConvert2AbsFullPath) == null) {
                io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview, str2, io.dcloud.common.constant.DOMException.toJSON(-5, io.dcloud.common.constant.DOMException.MSG_PATH_NOT_PRIVATE_ERROR), io.dcloud.common.util.JSUtil.ERROR, true, false);
                return null;
            }
            io.dcloud.js.camera.CameraFeatureImpl.a aVar = new io.dcloud.js.camera.CameraFeatureImpl.a(iAppObtainApp, iWebview, str2, strConvert2AbsFullPath, c0066aA, iAppObtainApp);
            if (this.b) {
                this.c.add(aVar);
                return null;
            }
            if (io.dcloud.common.adapter.util.PermissionUtil.checkSelfPermission(iAppObtainApp.getActivity(), com.hjq.permissions.Permission.CAMERA) == 0) {
                aVar.onGranted(io.dcloud.common.adapter.util.PermissionUtil.PMS_CAMERA);
                return null;
            }
            io.dcloud.common.adapter.util.PermissionUtil.usePermission(iAppObtainApp.getActivity(), "camera", io.dcloud.common.adapter.util.PermissionUtil.PMS_CAMERA, 2, aVar);
            return null;
        }
        if (str.equals("startVideoCapture")) {
            io.dcloud.js.camera.CameraFeatureImpl.b bVar = new io.dcloud.js.camera.CameraFeatureImpl.b(iAppObtainApp, strArr, iAppObtainApp, iWebview, str2);
            if (this.b) {
                this.c.add(bVar);
                return null;
            }
            if (io.dcloud.common.adapter.util.PermissionUtil.checkSelfPermission(iAppObtainApp.getActivity(), com.hjq.permissions.Permission.CAMERA) == 0) {
                bVar.onGranted(io.dcloud.common.adapter.util.PermissionUtil.PMS_CAMERA);
                return null;
            }
            io.dcloud.common.adapter.util.PermissionUtil.usePermission(iAppObtainApp.getActivity(), "camera", io.dcloud.common.adapter.util.PermissionUtil.PMS_CAMERA, 2, bVar);
            return null;
        }
        if (str.equals("getCamera")) {
            io.dcloud.js.camera.a aVar2 = new io.dcloud.js.camera.a(io.dcloud.common.util.PdrUtil.parseInt(strArr[1], 1));
            if (io.dcloud.common.adapter.util.PermissionUtil.checkSelfPermission(iAppObtainApp.getActivity(), com.hjq.permissions.Permission.CAMERA) == 0) {
                aVar2.b();
                return aVar2.a();
            }
            if (!this.b) {
                this.b = true;
                io.dcloud.common.adapter.util.PermissionUtil.usePermission(iAppObtainApp.getActivity(), "camera", io.dcloud.common.adapter.util.PermissionUtil.PMS_CAMERA, 2, new io.dcloud.js.camera.CameraFeatureImpl.c(iAppObtainApp, aVar2, strArr, iWebview));
            }
        }
        return null;
    }

    @Override // io.dcloud.common.DHInterface.IFeature
    public void init(io.dcloud.common.DHInterface.AbsMgr absMgr, java.lang.String str) {
        this.a = absMgr;
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class a extends io.dcloud.common.adapter.util.PermissionUtil.StreamPermissionRequest {
        final /* synthetic */ io.dcloud.common.DHInterface.IWebview a;
        final /* synthetic */ java.lang.String b;
        final /* synthetic */ java.lang.String c;
        final /* synthetic */ io.dcloud.js.camera.a.C0066a d;
        final /* synthetic */ io.dcloud.common.DHInterface.IApp e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(io.dcloud.common.DHInterface.IApp iApp, io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.String str2, io.dcloud.js.camera.a.C0066a c0066a, io.dcloud.common.DHInterface.IApp iApp2) {
            super(iApp);
            this.a = iWebview;
            this.b = str;
            this.c = str2;
            this.d = c0066a;
            this.e = iApp2;
        }

        @Override // io.dcloud.common.adapter.util.PermissionUtil.Request
        public void onDenied(java.lang.String str) {
            io.dcloud.common.util.Deprecated_JSUtil.execCallback(this.a, this.b, io.dcloud.common.constant.DOMException.toJSON(11, io.dcloud.common.constant.DOMException.MSG_NO_PERMISSION), io.dcloud.common.util.JSUtil.ERROR, true, false);
        }

        @Override // io.dcloud.common.adapter.util.PermissionUtil.Request
        public void onGranted(java.lang.String str) {
            try {
                if (io.dcloud.common.util.JSUtil.checkOperateDirErrorAndCallback(this.a, this.b, this.c)) {
                    io.dcloud.common.util.Deprecated_JSUtil.execCallback(this.a, this.b, io.dcloud.common.constant.DOMException.toJSON(-5, io.dcloud.common.constant.DOMException.MSG_IO_ERROR), io.dcloud.common.util.JSUtil.ERROR, true, false);
                    return;
                }
                java.io.File file = new java.io.File(this.c);
                java.io.File parentFile = file.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
                android.content.Intent intent = new android.content.Intent("android.media.action.IMAGE_CAPTURE");
                io.dcloud.common.util.DCFileUriData shareImageUri = io.dcloud.common.util.FileUtil.getShareImageUri(this.a.getContext(), file, this.d.a(), intent);
                this.e.registerSysEventListener(new io.dcloud.js.camera.CameraFeatureImpl.a.C0060a(shareImageUri), io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onActivityResult);
                intent.putExtra("output", shareImageUri.fileUri);
                this.a.getActivity().startActivityForResult(intent, io.dcloud.js.camera.a.e);
            } catch (java.lang.Exception e) {
                io.dcloud.common.util.Deprecated_JSUtil.execCallback(this.a, this.b, io.dcloud.common.constant.DOMException.toJSON(11, e.getMessage()), io.dcloud.common.util.JSUtil.ERROR, true, false);
            }
        }

        /* JADX INFO: renamed from: io.dcloud.js.camera.CameraFeatureImpl$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
        class C0060a implements io.dcloud.common.DHInterface.ISysEventListener {
            final /* synthetic */ io.dcloud.common.util.DCFileUriData a;

            C0060a(io.dcloud.common.util.DCFileUriData dCFileUriData) {
                this.a = dCFileUriData;
            }

            @Override // io.dcloud.common.DHInterface.ISysEventListener
            public boolean onExecute(io.dcloud.common.DHInterface.ISysEventListener.SysEventType sysEventType, java.lang.Object obj) {
                java.lang.Object[] objArr = (java.lang.Object[]) obj;
                int iIntValue = ((java.lang.Integer) objArr[0]).intValue();
                int iIntValue2 = ((java.lang.Integer) objArr[1]).intValue();
                if (sysEventType == io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onActivityResult && iIntValue == io.dcloud.js.camera.a.e) {
                    if (iIntValue2 == -1) {
                        io.dcloud.common.util.ThreadPool.self().addThreadTask(new io.dcloud.js.camera.CameraFeatureImpl.a.C0060a.RunnableC0061a());
                    } else {
                        java.lang.String json = io.dcloud.common.constant.DOMException.toJSON(11, "resultCode is wrong");
                        io.dcloud.js.camera.CameraFeatureImpl.a aVar = io.dcloud.js.camera.CameraFeatureImpl.a.this;
                        io.dcloud.common.util.Deprecated_JSUtil.execCallback(aVar.a, aVar.b, json, io.dcloud.common.util.JSUtil.ERROR, true, false);
                    }
                    io.dcloud.js.camera.CameraFeatureImpl.a.this.e.unregisterSysEventListener(this, sysEventType);
                }
                return false;
            }

            /* JADX INFO: renamed from: io.dcloud.js.camera.CameraFeatureImpl$a$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
            class RunnableC0061a implements java.lang.Runnable {

                /* JADX INFO: renamed from: io.dcloud.js.camera.CameraFeatureImpl$a$a$a$a, reason: collision with other inner class name */
                /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
                class RunnableC0062a implements java.lang.Runnable {
                    RunnableC0062a() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        java.lang.String json = io.dcloud.common.constant.DOMException.toJSON(-5, io.dcloud.common.constant.DOMException.MSG_IO_ERROR);
                        io.dcloud.js.camera.CameraFeatureImpl.a aVar = io.dcloud.js.camera.CameraFeatureImpl.a.this;
                        io.dcloud.common.util.Deprecated_JSUtil.execCallback(aVar.a, aVar.b, json, io.dcloud.common.util.JSUtil.ERROR, true, false);
                    }
                }

                /* JADX INFO: renamed from: io.dcloud.js.camera.CameraFeatureImpl$a$a$a$b */
                /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
                class b implements java.lang.Runnable {
                    b() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        java.lang.String json = io.dcloud.common.constant.DOMException.toJSON(-5, io.dcloud.common.constant.DOMException.MSG_IO_ERROR);
                        io.dcloud.js.camera.CameraFeatureImpl.a aVar = io.dcloud.js.camera.CameraFeatureImpl.a.this;
                        io.dcloud.common.util.Deprecated_JSUtil.execCallback(aVar.a, aVar.b, json, io.dcloud.common.util.JSUtil.ERROR, true, false);
                    }
                }

                /* JADX INFO: renamed from: io.dcloud.js.camera.CameraFeatureImpl$a$a$a$c */
                /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
                class c implements io.dcloud.common.DHInterface.ISysEventListener {
                    final /* synthetic */ java.lang.String a;

                    /* JADX INFO: renamed from: io.dcloud.js.camera.CameraFeatureImpl$a$a$a$c$a, reason: collision with other inner class name */
                    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
                    class RunnableC0063a implements java.lang.Runnable {

                        /* JADX INFO: renamed from: io.dcloud.js.camera.CameraFeatureImpl$a$a$a$c$a$a, reason: collision with other inner class name */
                        /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
                        class RunnableC0064a implements java.lang.Runnable {
                            RunnableC0064a() {
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                io.dcloud.js.camera.CameraFeatureImpl.a.C0060a.RunnableC0061a.c cVar = io.dcloud.js.camera.CameraFeatureImpl.a.C0060a.RunnableC0061a.c.this;
                                io.dcloud.js.camera.CameraFeatureImpl.a aVar = io.dcloud.js.camera.CameraFeatureImpl.a.this;
                                io.dcloud.common.util.Deprecated_JSUtil.execCallback(aVar.a, aVar.b, cVar.a, io.dcloud.common.util.JSUtil.OK, false, false);
                            }
                        }

                        RunnableC0063a() {
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            io.dcloud.js.camera.CameraFeatureImpl.a.this.e.getActivity().runOnUiThread(new io.dcloud.js.camera.CameraFeatureImpl.a.C0060a.RunnableC0061a.c.RunnableC0063a.RunnableC0064a());
                        }
                    }

                    c(java.lang.String str) {
                        this.a = str;
                    }

                    @Override // io.dcloud.common.DHInterface.ISysEventListener
                    public boolean onExecute(io.dcloud.common.DHInterface.ISysEventListener.SysEventType sysEventType, java.lang.Object obj) {
                        java.lang.Object[] objArr = (java.lang.Object[]) obj;
                        int iIntValue = ((java.lang.Integer) objArr[0]).intValue();
                        int iIntValue2 = ((java.lang.Integer) objArr[1]).intValue();
                        if (sysEventType == io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onActivityResult && iIntValue == io.dcloud.js.camera.a.g) {
                            if (iIntValue2 == -1) {
                                io.dcloud.common.util.ThreadPool.self().addThreadTask(new io.dcloud.js.camera.CameraFeatureImpl.a.C0060a.RunnableC0061a.c.RunnableC0063a());
                            } else {
                                java.lang.String json = io.dcloud.common.constant.DOMException.toJSON(11, "resultCode is wrong");
                                io.dcloud.js.camera.CameraFeatureImpl.a aVar = io.dcloud.js.camera.CameraFeatureImpl.a.this;
                                io.dcloud.common.util.Deprecated_JSUtil.execCallback(aVar.a, aVar.b, json, io.dcloud.common.util.JSUtil.ERROR, true, false);
                            }
                            io.dcloud.js.camera.CameraFeatureImpl.a.this.e.unregisterSysEventListener(this, sysEventType);
                        }
                        return false;
                    }
                }

                RunnableC0061a() {
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static /* synthetic */ void a(io.dcloud.js.camera.a.C0066a c0066a, java.lang.String str, io.dcloud.common.DHInterface.IApp iApp, final io.dcloud.common.DHInterface.IWebview iWebview, final java.lang.String str2, final java.lang.String str3) {
                    if (c0066a.h) {
                        io.dcloud.common.util.CompressUtil.compressImage(str, str, false, iApp.getActivity());
                    }
                    iApp.getActivity().runOnUiThread(new java.lang.Runnable() { // from class: io.dcloud.js.camera.CameraFeatureImpl$a$a$a$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            io.dcloud.js.camera.CameraFeatureImpl.a.C0060a.RunnableC0061a.a(iWebview, str2, str3);
                        }
                    });
                }

                @Override // java.lang.Runnable
                public void run() {
                    java.lang.String strConvert2RelPath;
                    java.lang.String strA;
                    io.dcloud.common.util.DCFileUriData dCFileUriData = io.dcloud.js.camera.CameraFeatureImpl.a.C0060a.this.a;
                    if (dCFileUriData.isReplace) {
                        if (io.dcloud.common.adapter.io.DHFile.copyFile(dCFileUriData.fileReplacePath, dCFileUriData.filePath, true, false) != 1) {
                            io.dcloud.js.camera.CameraFeatureImpl.a.this.e.getActivity().runOnUiThread(new io.dcloud.js.camera.CameraFeatureImpl.a.C0060a.RunnableC0061a.RunnableC0062a());
                            return;
                        } else {
                            try {
                                io.dcloud.common.adapter.io.DHFile.deleteFile(io.dcloud.js.camera.CameraFeatureImpl.a.C0060a.this.a.fileReplacePath);
                            } catch (java.io.IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    io.dcloud.js.camera.CameraFeatureImpl.a.C0060a c0060a = io.dcloud.js.camera.CameraFeatureImpl.a.C0060a.this;
                    io.dcloud.js.camera.CameraFeatureImpl.a aVar = io.dcloud.js.camera.CameraFeatureImpl.a.this;
                    if (aVar.d.e) {
                        strA = io.dcloud.js.camera.b.a(c0060a.a.filePath);
                        if (android.text.TextUtils.isEmpty(strA)) {
                            io.dcloud.js.camera.CameraFeatureImpl.a.this.e.getActivity().runOnUiThread(new io.dcloud.js.camera.CameraFeatureImpl.a.C0060a.RunnableC0061a.b());
                            return;
                        }
                        strConvert2RelPath = io.dcloud.js.camera.CameraFeatureImpl.a.this.e.convert2RelPath(strA);
                    } else {
                        strConvert2RelPath = aVar.e.convert2RelPath(c0060a.a.filePath);
                        strA = io.dcloud.js.camera.CameraFeatureImpl.a.C0060a.this.a.filePath;
                    }
                    final java.lang.String str = strA;
                    final java.lang.String str2 = strConvert2RelPath;
                    org.json.JSONObject jSONObject = io.dcloud.js.camera.CameraFeatureImpl.a.this.d.g;
                    if (jSONObject == null || !jSONObject.has("width") || !io.dcloud.js.camera.CameraFeatureImpl.a.this.d.g.has("height")) {
                        io.dcloud.js.camera.CameraFeatureImpl.a.C0060a.this.a.clear();
                        io.dcloud.common.util.ThreadPool threadPoolSelf = io.dcloud.common.util.ThreadPool.self();
                        io.dcloud.js.camera.CameraFeatureImpl.a aVar2 = io.dcloud.js.camera.CameraFeatureImpl.a.this;
                        final io.dcloud.js.camera.a.C0066a c0066a = aVar2.d;
                        final io.dcloud.common.DHInterface.IApp iApp = aVar2.e;
                        final io.dcloud.common.DHInterface.IWebview iWebview = aVar2.a;
                        final java.lang.String str3 = aVar2.b;
                        threadPoolSelf.addThreadTask(new java.lang.Runnable() { // from class: io.dcloud.js.camera.CameraFeatureImpl$a$a$a$$ExternalSyntheticLambda1
                            @Override // java.lang.Runnable
                            public final void run() {
                                io.dcloud.js.camera.CameraFeatureImpl.a.C0060a.RunnableC0061a.a(c0066a, str, iApp, iWebview, str3, str2);
                            }
                        });
                        return;
                    }
                    com.dmcbig.mediapicker.entity.Media media = new com.dmcbig.mediapicker.entity.Media(io.dcloud.js.camera.CameraFeatureImpl.a.C0060a.this.a.filePath, "", java.lang.System.currentTimeMillis(), 1, 1L, -1001, new java.io.File(io.dcloud.js.camera.CameraFeatureImpl.a.C0060a.this.a.filePath).getParent());
                    android.content.Intent intent = new android.content.Intent(io.dcloud.js.camera.CameraFeatureImpl.a.this.e.getActivity(), (java.lang.Class<?>) io.dcloud.feature.gallery.imageedit.IMGEditActivity.class);
                    intent.putExtra("IMAGE_URI", android.net.Uri.parse(io.dcloud.common.adapter.util.DeviceInfo.FILE_PROTOCOL + media.path));
                    intent.putExtra("IMAGE_MEDIA_ID", media.id);
                    intent.putExtra("IMAGE_INDEX", 0);
                    intent.putExtra("IMAGE_CROP", io.dcloud.js.camera.CameraFeatureImpl.a.this.d.g.toString());
                    intent.putExtra("IMAGE_SAVE_PATH", media.path);
                    io.dcloud.js.camera.CameraFeatureImpl.a.this.e.registerSysEventListener(new io.dcloud.js.camera.CameraFeatureImpl.a.C0060a.RunnableC0061a.c(str2), io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onActivityResult);
                    io.dcloud.js.camera.CameraFeatureImpl.a.C0060a.this.a.clear();
                    io.dcloud.js.camera.CameraFeatureImpl.a.this.e.getActivity().startActivityForResult(intent, io.dcloud.js.camera.a.g);
                    io.dcloud.js.camera.CameraFeatureImpl.a.this.e.getActivity().overridePendingTransition(0, 0);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static /* synthetic */ void a(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.String str2) {
                    io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview, str, str2, io.dcloud.common.util.JSUtil.OK, false, false);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, java.lang.String str) {
        if (z) {
            try {
                if (str.endsWith(".temp")) {
                    new java.io.File(str).delete();
                }
            } catch (java.lang.Exception unused) {
            }
        }
    }
}
