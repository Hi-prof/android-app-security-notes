package io.dcloud.js.gallery;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class GalleryFeatureImpl implements io.dcloud.common.DHInterface.IFeature {
    private static java.lang.String d = android.os.Environment.getExternalStoragePublicDirectory(android.os.Environment.DIRECTORY_DCIM).getAbsolutePath() + "/Camera/";
    private static int e = 1001;
    private static int f = 1002;
    private static int g = 1003;
    private static int h = 1004;
    private static io.dcloud.common.DHInterface.IWebview i;
    private java.util.ArrayList b;
    io.dcloud.common.DHInterface.AbsMgr a = null;
    private boolean c = false;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class a extends io.dcloud.common.adapter.util.PermissionUtil.Request {
        final /* synthetic */ java.lang.String[] a;
        final /* synthetic */ io.dcloud.common.DHInterface.IWebview b;
        final /* synthetic */ java.lang.String c;

        a(java.lang.String[] strArr, io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str) {
            this.a = strArr;
            this.b = iWebview;
            this.c = str;
        }

        @Override // io.dcloud.common.adapter.util.PermissionUtil.Request
        public void onDenied(java.lang.String str) {
            if (com.hjq.permissions.Permission.READ_MEDIA_VIDEO.equals(str)) {
                return;
            }
            if (androidx.core.app.ActivityCompat.checkSelfPermission(this.b.getContext(), com.hjq.permissions.Permission.READ_MEDIA_VISUAL_USER_SELECTED) != -1) {
                onGranted(com.hjq.permissions.Permission.READ_MEDIA_IMAGES);
                return;
            }
            java.lang.String json = io.dcloud.common.constant.DOMException.toJSON(12, io.dcloud.common.constant.DOMException.MSG_NO_PERMISSION);
            io.dcloud.common.util.Deprecated_JSUtil.execCallback(this.b, this.a[0], json, io.dcloud.common.util.JSUtil.ERROR, true, false);
        }

        @Override // io.dcloud.common.adapter.util.PermissionUtil.Request
        public void onGranted(java.lang.String str) {
            java.lang.String[] strArr = this.a;
            boolean zOptBoolean = false;
            if (strArr.length >= 2) {
                java.lang.String str2 = strArr[1];
                if (!io.dcloud.common.util.PdrUtil.isEmpty(str2)) {
                    try {
                        zOptBoolean = new org.json.JSONObject(str2).optBoolean("multiple", false);
                    } catch (org.json.JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
            if (io.dcloud.js.gallery.GalleryFeatureImpl.this.c) {
                return;
            }
            if (zOptBoolean) {
                io.dcloud.js.gallery.GalleryFeatureImpl.this.a(this.b, this.c, this.a);
            } else {
                io.dcloud.js.gallery.GalleryFeatureImpl.this.b(this.b, this.c, this.a);
            }
            io.dcloud.js.gallery.GalleryFeatureImpl.this.c = true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class b extends io.dcloud.common.adapter.util.PermissionUtil.StreamPermissionRequest {
        final /* synthetic */ java.lang.String a;
        final /* synthetic */ io.dcloud.common.DHInterface.IApp b;
        final /* synthetic */ io.dcloud.common.DHInterface.IWebview c;
        final /* synthetic */ java.lang.String d;
        final /* synthetic */ java.lang.String[] e;

        /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
        class a extends com.bumptech.glide.request.target.CustomTarget {
            a() {
            }

            @Override // com.bumptech.glide.request.target.Target
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onResourceReady(byte[] bArr, com.bumptech.glide.request.transition.Transition transition) throws java.lang.Throwable {
                java.lang.String downloadFilename = io.dcloud.common.util.PdrUtil.getDownloadFilename(null, "image/*", io.dcloud.js.gallery.GalleryFeatureImpl.b.this.a);
                if (!downloadFilename.contains(com.taobao.weex.el.parse.Operators.DOT_STR) || io.dcloud.common.util.FileUtil.getFileTypeForSuffix(downloadFilename.substring(downloadFilename.lastIndexOf(com.taobao.weex.el.parse.Operators.DOT_STR) + 1)) == null) {
                    android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    android.graphics.BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                    java.lang.String str = options.outMimeType;
                    if (!io.dcloud.common.util.PdrUtil.isEmpty(str)) {
                        java.lang.String[] strArrSplit = str.split("/");
                        if (strArrSplit.length > 1 && !io.dcloud.common.util.PdrUtil.isEmpty(strArrSplit[1]) && !strArrSplit[1].contains("*")) {
                            downloadFilename = downloadFilename + "_" + java.lang.System.currentTimeMillis() + com.taobao.weex.el.parse.Operators.DOT_STR + strArrSplit[1];
                        }
                    }
                }
                java.lang.String pathFromUri = io.dcloud.js.gallery.GalleryFeatureImpl.d + downloadFilename;
                java.io.ByteArrayInputStream byteArrayInputStream = new java.io.ByteArrayInputStream(bArr);
                if (io.dcloud.common.util.FileUtil.needMediaStoreOpenFile(io.dcloud.js.gallery.GalleryFeatureImpl.b.this.b.getActivity())) {
                    android.net.Uri uriCopyMediaFileToDCIM = io.dcloud.common.util.FileUtil.copyMediaFileToDCIM(io.dcloud.js.gallery.GalleryFeatureImpl.b.this.c.getContext(), byteArrayInputStream, downloadFilename);
                    if (uriCopyMediaFileToDCIM != null) {
                        pathFromUri = io.dcloud.common.util.FileUtil.getPathFromUri(io.dcloud.js.gallery.GalleryFeatureImpl.b.this.c.getContext(), uriCopyMediaFileToDCIM);
                    } else {
                        java.lang.String json = io.dcloud.common.constant.DOMException.toJSON(12, "SAVE ERROR");
                        io.dcloud.js.gallery.GalleryFeatureImpl.b bVar = io.dcloud.js.gallery.GalleryFeatureImpl.b.this;
                        io.dcloud.common.util.Deprecated_JSUtil.execCallback(bVar.c, bVar.d, json, io.dcloud.common.util.JSUtil.ERROR, true, false);
                    }
                } else {
                    io.dcloud.common.util.FileUtil.writeStream2File(byteArrayInputStream, new java.io.File(pathFromUri));
                }
                java.lang.String strConvert2WebviewFullPath = io.dcloud.js.gallery.GalleryFeatureImpl.b.this.b.convert2WebviewFullPath(null, pathFromUri);
                try {
                    org.json.JSONObject jSONObject = new org.json.JSONObject();
                    jSONObject.put("file", strConvert2WebviewFullPath);
                    jSONObject.put(io.dcloud.common.constant.AbsoluteConst.XML_PATH, strConvert2WebviewFullPath);
                    io.dcloud.js.gallery.GalleryFeatureImpl.b bVar2 = io.dcloud.js.gallery.GalleryFeatureImpl.b.this;
                    io.dcloud.common.util.JSUtil.execCallback(bVar2.c, bVar2.d, jSONObject, io.dcloud.common.util.JSUtil.OK, false);
                    io.dcloud.js.gallery.GalleryFeatureImpl.b.this.c.getContext().sendBroadcast(new android.content.Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", android.net.Uri.parse(io.dcloud.common.adapter.util.DeviceInfo.FILE_PROTOCOL + pathFromUri)));
                } catch (org.json.JSONException unused) {
                }
            }

            @Override // com.bumptech.glide.request.target.Target
            public void onLoadCleared(android.graphics.drawable.Drawable drawable) {
            }

            @Override // com.bumptech.glide.request.target.CustomTarget, com.bumptech.glide.request.target.Target
            public void onLoadFailed(android.graphics.drawable.Drawable drawable) {
                java.lang.String json = io.dcloud.common.constant.DOMException.toJSON(12, "UNKOWN ERROR");
                io.dcloud.js.gallery.GalleryFeatureImpl.b bVar = io.dcloud.js.gallery.GalleryFeatureImpl.b.this;
                io.dcloud.common.util.Deprecated_JSUtil.execCallback(bVar.c, bVar.d, json, io.dcloud.common.util.JSUtil.ERROR, true, false);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(io.dcloud.common.DHInterface.IApp iApp, java.lang.String str, io.dcloud.common.DHInterface.IApp iApp2, io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str2, java.lang.String[] strArr) {
            super(iApp);
            this.a = str;
            this.b = iApp2;
            this.c = iWebview;
            this.d = str2;
            this.e = strArr;
        }

        @Override // io.dcloud.common.adapter.util.PermissionUtil.Request
        public void onDenied(java.lang.String str) {
            io.dcloud.common.util.Deprecated_JSUtil.execCallback(this.c, this.d, io.dcloud.common.constant.DOMException.toJSON(12, io.dcloud.common.constant.DOMException.MSG_NO_PERMISSION), io.dcloud.common.util.JSUtil.ERROR, true, false);
        }

        /* JADX WARN: Code duplicated, block: B:28:0x00be  */
        @Override // io.dcloud.common.adapter.util.PermissionUtil.Request
        public void onGranted(java.lang.String str) {
            try {
                java.lang.String str2 = this.a;
                if (str2 == null) {
                    throw new java.io.IOException();
                }
                if (io.dcloud.common.util.PdrUtil.isNetPath(str2)) {
                    com.bumptech.glide.Glide.with(this.b.getActivity()).as(byte[].class).load(this.a).into(new io.dcloud.js.gallery.GalleryFeatureImpl.b.a());
                    return;
                }
                java.lang.String strConvert2AbsFullPath = this.b.convert2AbsFullPath(this.c.obtainFullUrl(), this.e[0]);
                if (!io.dcloud.common.util.FileUtil.checkPrivatePath(this.b.getActivity(), strConvert2AbsFullPath) && !io.dcloud.common.util.FileUtil.isFilePathForPublic(this.b.getActivity(), strConvert2AbsFullPath)) {
                    io.dcloud.common.util.Deprecated_JSUtil.execCallback(this.c, this.d, io.dcloud.common.constant.DOMException.toJSON(12, io.dcloud.common.constant.DOMException.MSG_PATH_NOT_PRIVATE_ERROR), io.dcloud.common.util.JSUtil.ERROR, true, false);
                    return;
                }
                boolean z = true;
                java.lang.String pathFromUri = io.dcloud.js.gallery.GalleryFeatureImpl.d + strConvert2AbsFullPath.substring(strConvert2AbsFullPath.lastIndexOf("/") + 1);
                if (android.os.Build.VERSION.SDK_INT >= 29) {
                    if (io.dcloud.common.util.FileUtil.needMediaStoreOpenFile(this.b.getActivity())) {
                        android.net.Uri uriCopyMediaFileToDCIM = io.dcloud.common.util.FileUtil.copyMediaFileToDCIM(this.c.getContext(), strConvert2AbsFullPath);
                        if (uriCopyMediaFileToDCIM != null) {
                            pathFromUri = io.dcloud.common.util.FileUtil.getPathFromUri(this.c.getContext(), uriCopyMediaFileToDCIM);
                        } else {
                            z = false;
                        }
                    } else if (1 != io.dcloud.common.adapter.io.DHFile.copyFile(strConvert2AbsFullPath, pathFromUri)) {
                        z = false;
                    }
                } else if (1 != io.dcloud.common.adapter.io.DHFile.copyFile(strConvert2AbsFullPath, pathFromUri)) {
                    z = false;
                }
                if (!z) {
                    io.dcloud.common.util.Deprecated_JSUtil.execCallback(this.c, this.d, io.dcloud.common.constant.DOMException.toJSON(12, "UNKOWN ERROR3"), io.dcloud.common.util.JSUtil.ERROR, true, false);
                    return;
                }
                java.lang.String strConvert2WebviewFullPath = this.b.convert2WebviewFullPath(null, pathFromUri);
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                jSONObject.put("file", strConvert2WebviewFullPath);
                jSONObject.put(io.dcloud.common.constant.AbsoluteConst.XML_PATH, strConvert2WebviewFullPath);
                io.dcloud.common.util.JSUtil.execCallback(this.c, this.d, jSONObject, io.dcloud.common.util.JSUtil.OK, false);
                this.c.getContext().sendBroadcast(new android.content.Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", android.net.Uri.parse(io.dcloud.common.adapter.util.DeviceInfo.FILE_PROTOCOL + pathFromUri)));
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                io.dcloud.common.util.Deprecated_JSUtil.execCallback(this.c, this.d, io.dcloud.common.constant.DOMException.toJSON(12, "UNKOWN ERROR4"), io.dcloud.common.util.JSUtil.ERROR, true, false);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class c implements io.dcloud.common.DHInterface.ISysEventListener {
        final /* synthetic */ io.dcloud.common.DHInterface.IApp a;
        final /* synthetic */ io.dcloud.common.DHInterface.IWebview b;
        final /* synthetic */ java.lang.String c;

        c(io.dcloud.common.DHInterface.IApp iApp, io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str) {
            this.a = iApp;
            this.b = iWebview;
            this.c = str;
        }

        /* JADX WARN: Code duplicated, block: B:35:0x00b4  */
        /* JADX WARN: Code duplicated, block: B:36:0x00b6  */
        @Override // io.dcloud.common.DHInterface.ISysEventListener
        public boolean onExecute(io.dcloud.common.DHInterface.ISysEventListener.SysEventType sysEventType, java.lang.Object obj) {
            java.lang.String[] strArr;
            java.lang.String[] strArr2;
            java.lang.String[] strArrMediasToJSONArray;
            java.lang.Object[] objArr = (java.lang.Object[]) obj;
            int iIntValue = ((java.lang.Integer) objArr[0]).intValue();
            ((java.lang.Integer) objArr[1]).getClass();
            android.content.Intent intent = (android.content.Intent) objArr[2];
            io.dcloud.common.DHInterface.ISysEventListener.SysEventType sysEventType2 = io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onActivityResult;
            if (sysEventType == sysEventType2) {
                this.a.unregisterSysEventListener(this, sysEventType2);
                try {
                    if (iIntValue == io.dcloud.js.gallery.GalleryFeatureImpl.f) {
                        strArrMediasToJSONArray = intent.getStringArrayExtra("all_path");
                    } else {
                        if (iIntValue == io.dcloud.js.gallery.GalleryFeatureImpl.g) {
                            if (intent != null) {
                                android.content.ClipData clipData = intent.getClipData();
                                if (clipData != null) {
                                    int itemCount = clipData.getItemCount();
                                    strArr = new java.lang.String[itemCount];
                                    for (int i = 0; i < itemCount; i++) {
                                        try {
                                            strArr[i] = io.dcloud.common.adapter.util.ContentUriUtil.getImageAbsolutePath(this.b.getActivity(), clipData.getItemAt(i).getUri());
                                        } catch (java.lang.Exception unused) {
                                        }
                                    }
                                } else if (intent.getData() != null) {
                                    java.lang.String path = io.dcloud.common.util.PdrUtil.isDeviceRootDir(intent.getData().getPath()) ? intent.getData().getPath() : io.dcloud.common.adapter.util.ContentUriUtil.getImageAbsolutePath(this.b.getActivity(), intent.getData());
                                    if (path != null) {
                                        strArr = new java.lang.String[]{path};
                                    }
                                }
                            }
                            io.dcloud.js.gallery.GalleryFeatureImpl galleryFeatureImpl = io.dcloud.js.gallery.GalleryFeatureImpl.this;
                            io.dcloud.common.DHInterface.IApp iApp = this.a;
                            io.dcloud.common.DHInterface.IWebview iWebview = this.b;
                            java.lang.String str = this.c;
                            if (intent != null) {
                                strArr2 = strArr;
                            } else {
                                strArr2 = null;
                            }
                            galleryFeatureImpl.a(iApp, iWebview, str, strArr2, true);
                        } else {
                            if (iIntValue == io.dcloud.js.gallery.GalleryFeatureImpl.h) {
                                strArrMediasToJSONArray = io.dcloud.js.gallery.GalleryFeatureImpl.this.mediasToJSONArray(intent.getParcelableArrayListExtra(com.dmcbig.mediapicker.PickerConfig.EXTRA_RESULT));
                            }
                            io.dcloud.js.gallery.GalleryFeatureImpl galleryFeatureImpl2 = io.dcloud.js.gallery.GalleryFeatureImpl.this;
                            io.dcloud.common.DHInterface.IApp iApp2 = this.a;
                            io.dcloud.common.DHInterface.IWebview iWebview2 = this.b;
                            java.lang.String str2 = this.c;
                            if (intent != null) {
                                strArr2 = strArr;
                            } else {
                                strArr2 = null;
                            }
                            galleryFeatureImpl2.a(iApp2, iWebview2, str2, strArr2, true);
                        }
                        strArr = null;
                        io.dcloud.js.gallery.GalleryFeatureImpl galleryFeatureImpl3 = io.dcloud.js.gallery.GalleryFeatureImpl.this;
                        io.dcloud.common.DHInterface.IApp iApp3 = this.a;
                        io.dcloud.common.DHInterface.IWebview iWebview3 = this.b;
                        java.lang.String str3 = this.c;
                        if (intent != null) {
                            strArr2 = strArr;
                        } else {
                            strArr2 = null;
                        }
                        galleryFeatureImpl3.a(iApp3, iWebview3, str3, strArr2, true);
                    }
                    strArr = strArrMediasToJSONArray;
                } catch (java.lang.Exception unused2) {
                }
                io.dcloud.js.gallery.GalleryFeatureImpl galleryFeatureImpl4 = io.dcloud.js.gallery.GalleryFeatureImpl.this;
                io.dcloud.common.DHInterface.IApp iApp4 = this.a;
                io.dcloud.common.DHInterface.IWebview iWebview4 = this.b;
                java.lang.String str4 = this.c;
                if (intent != null) {
                    strArr2 = strArr;
                } else {
                    strArr2 = null;
                }
                galleryFeatureImpl4.a(iApp4, iWebview4, str4, strArr2, true);
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class d extends android.content.BroadcastReceiver {
        final /* synthetic */ android.app.Activity a;

        d(android.app.Activity activity) {
            this.a = activity;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(android.content.Context context, android.content.Intent intent) {
            java.lang.String stringExtra = intent.getStringExtra("_onMaxedId");
            if (!android.text.TextUtils.isEmpty(stringExtra)) {
                io.dcloud.js.gallery.GalleryFeatureImpl.onMaxed(this.a, stringExtra);
                return;
            }
            if (io.dcloud.js.gallery.GalleryFeatureImpl.this.b != null) {
                io.dcloud.js.gallery.GalleryFeatureImpl.this.b.remove(this);
            }
            androidx.localbroadcastmanager.content.LocalBroadcastManager.getInstance(this.a).unregisterReceiver(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class e implements io.dcloud.common.DHInterface.ISysEventListener {
        final /* synthetic */ io.dcloud.common.DHInterface.IApp a;
        final /* synthetic */ io.dcloud.common.DHInterface.IWebview b;
        final /* synthetic */ java.lang.String c;

        e(io.dcloud.common.DHInterface.IApp iApp, io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str) {
            this.a = iApp;
            this.b = iWebview;
            this.c = str;
        }

        @Override // io.dcloud.common.DHInterface.ISysEventListener
        public boolean onExecute(io.dcloud.common.DHInterface.ISysEventListener.SysEventType sysEventType, java.lang.Object obj) {
            java.lang.String[] strArrMediasToJSONArray;
            java.lang.String path;
            android.net.Uri data;
            java.lang.Object[] objArr = (java.lang.Object[]) obj;
            int iIntValue = ((java.lang.Integer) objArr[0]).intValue();
            ((java.lang.Integer) objArr[1]).getClass();
            android.content.Intent intent = (android.content.Intent) objArr[2];
            io.dcloud.common.DHInterface.ISysEventListener.SysEventType sysEventType2 = io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onActivityResult;
            if (sysEventType == sysEventType2) {
                this.a.unregisterSysEventListener(this, sysEventType2);
                if (iIntValue == io.dcloud.js.gallery.GalleryFeatureImpl.e) {
                    if (intent == null || (data = intent.getData()) == null) {
                        path = null;
                    } else {
                        path = io.dcloud.common.util.PdrUtil.isDeviceRootDir(data.getPath()) ? data.getPath() : data.toString();
                    }
                    io.dcloud.js.gallery.GalleryFeatureImpl.this.a(this.a, this.b, this.c, path != null ? new java.lang.String[]{path} : null, false);
                } else if (iIntValue == io.dcloud.js.gallery.GalleryFeatureImpl.h) {
                    java.lang.String str = (intent == null || (strArrMediasToJSONArray = io.dcloud.js.gallery.GalleryFeatureImpl.this.mediasToJSONArray(intent.getParcelableArrayListExtra(com.dmcbig.mediapicker.PickerConfig.EXTRA_RESULT))) == null || strArrMediasToJSONArray.length <= 0) ? null : strArrMediasToJSONArray[0];
                    io.dcloud.js.gallery.GalleryFeatureImpl.this.a(this.a, this.b, this.c, str != null ? new java.lang.String[]{str} : null, false);
                }
            }
            return false;
        }
    }

    public static void onMaxed(android.content.Context context, java.lang.String str) {
        io.dcloud.common.DHInterface.IWebview iWebview = i;
        if (iWebview != null) {
            io.dcloud.common.util.JSUtil.execCallback(iWebview, str, "", io.dcloud.common.util.JSUtil.OK, true);
            return;
        }
        android.content.Intent intent = new android.content.Intent("io.dcloud.streamapp.Gallery.onMax." + str);
        intent.putExtra("_onMaxedId", str);
        androidx.localbroadcastmanager.content.LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }

    public java.util.ArrayList<com.dmcbig.mediapicker.entity.Media> JSONArrayToMedias(int i2, org.json.JSONArray jSONArray) {
        java.util.ArrayList<com.dmcbig.mediapicker.entity.Media> arrayList = null;
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            try {
                if (arrayList == null) {
                    arrayList = new java.util.ArrayList<>();
                }
                java.io.File file = new java.io.File(java.net.URI.create(jSONArray.getString(i3)));
                if (file.exists()) {
                    arrayList.add(new com.dmcbig.mediapicker.entity.Media(file.getPath(), file.getName(), 0L, i2 == 102 ? 3 : 1, file.length(), 0, ""));
                }
            } catch (java.lang.Exception e2) {
                e2.printStackTrace();
                return arrayList;
            }
        }
        return arrayList;
    }

    @Override // io.dcloud.common.DHInterface.IFeature
    public void dispose(java.lang.String str) {
        java.util.ArrayList arrayList = this.b;
        if (arrayList != null && i != null) {
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                java.lang.Object obj = arrayList.get(i2);
                i2++;
                androidx.localbroadcastmanager.content.LocalBroadcastManager.getInstance(i.getActivity()).unregisterReceiver((android.content.BroadcastReceiver) obj);
            }
            this.b.clear();
        }
        i = null;
    }

    @Override // io.dcloud.common.DHInterface.IFeature
    public java.lang.String execute(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.String[] strArr) {
        i = iWebview;
        io.dcloud.common.util.AppRuntime.checkPrivacyComplianceAndPrompt(iWebview.getContext(), "Gallery-" + str);
        if (!"pick".equals(str)) {
            if (!"save".equals(str)) {
                return null;
            }
            io.dcloud.common.DHInterface.IApp iAppObtainApp = iWebview.obtainFrameView().obtainApp();
            io.dcloud.common.adapter.util.PermissionUtil.usePermission(iAppObtainApp.getActivity(), "gallery", io.dcloud.common.adapter.util.PermissionUtil.PMS_STORAGE, 2, new io.dcloud.js.gallery.GalleryFeatureImpl.b(iAppObtainApp, strArr[0], iAppObtainApp, iWebview, strArr[1], strArr));
            return null;
        }
        this.c = false;
        io.dcloud.js.gallery.GalleryFeatureImpl.a aVar = new io.dcloud.js.gallery.GalleryFeatureImpl.a(strArr, iWebview, str);
        if (android.os.Build.VERSION.SDK_INT < 34) {
            io.dcloud.common.adapter.util.PermissionUtil.usePermission(iWebview.obtainApp().getActivity(), "gallery", io.dcloud.common.adapter.util.PermissionUtil.PMS_STORAGE_IMAGE, 2, aVar);
            return null;
        }
        if (androidx.core.app.ActivityCompat.checkSelfPermission(iWebview.getContext(), com.hjq.permissions.Permission.READ_MEDIA_VISUAL_USER_SELECTED) == -1) {
            io.dcloud.common.adapter.util.PermissionUtil.usePermission(iWebview.obtainApp().getActivity(), "gallery", io.dcloud.common.adapter.util.PermissionUtil.PMS_STORAGE_IMAGE, 2, aVar);
            return null;
        }
        aVar.onGranted(com.hjq.permissions.Permission.READ_MEDIA_IMAGES);
        return null;
    }

    public android.content.Intent getMediaPickerIntent(android.content.Context context, java.lang.String str, int i2, org.json.JSONArray jSONArray, java.lang.String str2, boolean z, java.lang.String str3, org.json.JSONObject jSONObject, java.lang.String str4, java.lang.String str5, boolean z2) {
        int i3;
        android.content.Intent intent = new android.content.Intent();
        if (str.contains("video") && str.contains("image")) {
            i3 = 101;
        } else {
            i3 = str.contains("video") ? 102 : 100;
        }
        boolean zContains = str.contains("__Single__");
        intent.setClassName(context, "com.dmcbig.mediapicker.PickerActivity");
        intent.putExtra("select_mode", i3);
        intent.putExtra(com.dmcbig.mediapicker.PickerConfig.SINGLE_SELECT, zContains);
        intent.putExtra(com.dmcbig.mediapicker.PickerConfig.COMPRESSED, z2);
        if (i2 > 0) {
            intent.putExtra("max_select_count", i2);
        }
        if (jSONArray != null) {
            intent.putExtra(com.dmcbig.mediapicker.PickerConfig.DEFAULT_SELECTED_LIST, JSONArrayToMedias(i3, jSONArray));
        }
        if (!android.text.TextUtils.isEmpty(str3)) {
            intent.putExtra(com.dmcbig.mediapicker.PickerConfig.SELECTED_MAX_CALLBACK_ID, str3);
        }
        if (!android.text.TextUtils.isEmpty(str2)) {
            intent.putExtra(com.dmcbig.mediapicker.PickerConfig.DONE_BUTTON_TEXT, str2);
        }
        if (!android.text.TextUtils.isEmpty(str4)) {
            intent.putExtra(com.dmcbig.mediapicker.PickerConfig.SIZE_TYPE, str4);
        }
        if (!android.text.TextUtils.isEmpty(str5)) {
            intent.putExtra("doc_path", str5);
        }
        if (jSONObject != null && jSONObject.has("width") && jSONObject.has("height")) {
            java.util.regex.Pattern patternCompile = java.util.regex.Pattern.compile("[^0-9]");
            try {
                int i4 = java.lang.Integer.parseInt(patternCompile.matcher(jSONObject.optString("width")).replaceAll(""));
                int i5 = java.lang.Integer.parseInt(patternCompile.matcher(jSONObject.optString("height")).replaceAll(""));
                if (i4 > 0 && i5 > 0) {
                    jSONObject.put("width", i4);
                    jSONObject.put("height", i5);
                    intent.putExtra(com.dmcbig.mediapicker.PickerConfig.IMAGE_CROP, jSONObject.toString());
                    intent.putExtra("max_select_count", 1);
                }
            } catch (java.lang.Exception unused) {
            }
        }
        intent.putExtra(com.dmcbig.mediapicker.PickerConfig.IMAGE_EDITABLE, z);
        return intent;
    }

    @Override // io.dcloud.common.DHInterface.IFeature
    public void init(io.dcloud.common.DHInterface.AbsMgr absMgr, java.lang.String str) {
        this.a = absMgr;
    }

    public java.lang.String[] mediasToJSONArray(java.util.ArrayList<android.os.Parcelable> arrayList) {
        java.lang.String[] strArr = null;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            com.dmcbig.mediapicker.entity.Media media = (com.dmcbig.mediapicker.entity.Media) arrayList.get(i2);
            if (strArr == null) {
                strArr = new java.lang.String[arrayList.size()];
            }
            strArr[i2] = media.path;
        }
        return strArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.String[] strArr) {
        io.dcloud.common.DHInterface.IWebview iWebview2;
        java.lang.String str2;
        java.lang.String str3;
        org.json.JSONObject jSONObjectOptJSONObject;
        java.lang.String strOptString;
        boolean z;
        boolean zOptBoolean;
        java.lang.String str4;
        try {
            java.lang.String str5 = strArr[0];
            try {
                io.dcloud.common.DHInterface.IApp iAppObtainApp = iWebview.obtainFrameView().obtainApp();
                iWebview2 = iWebview;
                try {
                    iAppObtainApp.registerSysEventListener(new io.dcloud.js.gallery.GalleryFeatureImpl.e(iAppObtainApp, iWebview2, str5), io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onActivityResult);
                    java.lang.String str6 = "image/*";
                    if (io.dcloud.common.util.PdrUtil.isEmpty(strArr[1])) {
                        str3 = null;
                        jSONObjectOptJSONObject = null;
                        strOptString = null;
                        z = true;
                        zOptBoolean = false;
                    } else {
                        org.json.JSONObject jSONObjectCreateJSONObject = io.dcloud.common.util.JSONUtil.createJSONObject(strArr[1]);
                        java.lang.String string = io.dcloud.common.util.JSONUtil.getString(jSONObjectCreateJSONObject, com.taobao.weex.common.Constants.Name.FILTER);
                        if ("video".equals(string)) {
                            str6 = "video/*";
                        } else if ("none".equals(string)) {
                            str6 = "image/*|video/*";
                        }
                        java.lang.String strOptString2 = jSONObjectCreateJSONObject.optString("confirmText");
                        boolean zOptBoolean2 = jSONObjectCreateJSONObject.optBoolean("editable", true);
                        jSONObjectOptJSONObject = jSONObjectCreateJSONObject.optJSONObject("crop");
                        strOptString = jSONObjectCreateJSONObject.optString("sizeType");
                        zOptBoolean = jSONObjectCreateJSONObject.optBoolean("videoCompress", false);
                        z = zOptBoolean2;
                        str3 = strOptString2;
                    }
                    new android.content.Intent("android.intent.action.PICK");
                    java.lang.String strConcat = str6.concat("__Single__");
                    if (strArr.length > 2) {
                        java.lang.String str7 = strArr[2];
                        a(iWebview2.getActivity(), str7);
                        str4 = str7;
                    } else {
                        str4 = null;
                    }
                    iWebview2.getActivity().startActivityForResult(getMediaPickerIntent(iWebview2.getContext(), strConcat, 1, null, str3, z, str4, jSONObjectOptJSONObject, strOptString, iWebview2.obtainApp().convert2LocalFullPath(null, io.dcloud.common.util.BaseInfo.REL_PRIVATE_DOC_DIR), zOptBoolean), h);
                } catch (java.lang.Exception e2) {
                    e = e2;
                    str2 = str5;
                    e.printStackTrace();
                    io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview2, str2, io.dcloud.common.constant.DOMException.toJSON(12, e.getMessage()), io.dcloud.common.util.JSUtil.ERROR, true, false);
                }
            } catch (java.lang.Exception e3) {
                e = e3;
                iWebview2 = iWebview;
            }
        } catch (java.lang.Exception e4) {
            e = e4;
            iWebview2 = iWebview;
            str2 = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.String[] strArr) {
        io.dcloud.common.DHInterface.IWebview iWebview2;
        java.lang.String str2;
        java.lang.String str3;
        int i2;
        java.lang.String str4;
        boolean z;
        org.json.JSONArray jSONArrayOptJSONArray;
        org.json.JSONObject jSONObject;
        java.lang.String str5;
        boolean z2;
        java.lang.String str6;
        try {
            java.lang.String str7 = strArr[0];
            try {
                io.dcloud.common.DHInterface.IApp iAppObtainApp = iWebview.obtainFrameView().obtainApp();
                iWebview2 = iWebview;
                try {
                    iAppObtainApp.registerSysEventListener(new io.dcloud.js.gallery.GalleryFeatureImpl.c(iAppObtainApp, iWebview2, str7), io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onActivityResult);
                    android.content.Intent intent = new android.content.Intent();
                    java.lang.String str8 = "image/*";
                    if (io.dcloud.common.util.PdrUtil.isEmpty(strArr[1])) {
                        str3 = "image/*";
                        i2 = -1;
                        str4 = null;
                        z = true;
                        jSONArrayOptJSONArray = null;
                        jSONObject = null;
                        str5 = null;
                        z2 = false;
                    } else {
                        org.json.JSONObject jSONObjectCreateJSONObject = io.dcloud.common.util.JSONUtil.createJSONObject(strArr[1]);
                        java.lang.String string = io.dcloud.common.util.JSONUtil.getString(jSONObjectCreateJSONObject, com.taobao.weex.common.Constants.Name.FILTER);
                        if ("video".equals(string)) {
                            str8 = "video/*";
                        } else if ("none".equals(string)) {
                            str8 = "image/*|video/*";
                        }
                        int iOptInt = jSONObjectCreateJSONObject.optInt("maximum", -1);
                        jSONArrayOptJSONArray = jSONObjectCreateJSONObject.optJSONArray("selected");
                        java.lang.String strOptString = jSONObjectCreateJSONObject.optString("confirmText");
                        boolean zOptBoolean = jSONObjectCreateJSONObject.optBoolean("editable", true);
                        org.json.JSONObject jSONObjectOptJSONObject = jSONObjectCreateJSONObject.optJSONObject("crop");
                        java.lang.String strOptString2 = jSONObjectCreateJSONObject.optString("sizeType");
                        boolean zOptBoolean2 = jSONObjectCreateJSONObject.optBoolean("videoCompress", false);
                        str3 = str8;
                        i2 = iOptInt;
                        str4 = strOptString;
                        z = zOptBoolean;
                        jSONObject = jSONObjectOptJSONObject;
                        str5 = strOptString2;
                        z2 = zOptBoolean2;
                    }
                    intent.setType(str3);
                    intent.setAction("android.intent.action.OPEN_DOCUMENT");
                    intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
                    intent.addCategory("android.intent.category.OPENABLE");
                    int i3 = g;
                    try {
                        if (strArr.length > 2) {
                            str6 = strArr[2];
                            a(iWebview2.getActivity(), str6);
                        } else {
                            str6 = null;
                        }
                        intent = getMediaPickerIntent(iWebview2.getContext(), str3, i2, jSONArrayOptJSONArray, str4, z, str6, jSONObject, str5, iWebview2.obtainApp().convert2LocalFullPath(null, io.dcloud.common.util.BaseInfo.REL_PRIVATE_DOC_DIR), z2);
                        i3 = h;
                    } catch (java.lang.Exception e2) {
                        e2.printStackTrace();
                    }
                    iWebview2.getActivity().startActivityForResult(intent, i3);
                } catch (java.lang.Exception e3) {
                    e = e3;
                    str2 = str7;
                    e.printStackTrace();
                    io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview2, str2, io.dcloud.common.constant.DOMException.toJSON(12, e.getMessage()), io.dcloud.common.util.JSUtil.ERROR, true, false);
                }
            } catch (java.lang.Exception e4) {
                e = e4;
                iWebview2 = iWebview;
            }
        } catch (java.lang.Exception e5) {
            e = e5;
            iWebview2 = iWebview;
            str2 = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void a(android.app.Activity activity, java.lang.String str) {
        if ((activity instanceof io.dcloud.common.DHInterface.IActivityHandler) && ((io.dcloud.common.DHInterface.IActivityHandler) activity).isMultiProcessMode()) {
            android.content.IntentFilter intentFilter = new android.content.IntentFilter();
            intentFilter.addAction("io.dcloud.streamapp.Gallery.onMax." + str);
            io.dcloud.js.gallery.GalleryFeatureImpl.d dVar = new io.dcloud.js.gallery.GalleryFeatureImpl.d(activity);
            if (this.b == null) {
                this.b = new java.util.ArrayList();
            }
            this.b.add(dVar);
            androidx.localbroadcastmanager.content.LocalBroadcastManager.getInstance(activity).registerReceiver(dVar, intentFilter);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(io.dcloud.common.DHInterface.IApp iApp, io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.String[] strArr, boolean z) {
        java.lang.String str2;
        boolean z2;
        java.lang.String strConvert2WebviewFullPath;
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("multiple", z);
        } catch (org.json.JSONException e2) {
            e2.printStackTrace();
        }
        org.json.JSONArray jSONArray = new org.json.JSONArray();
        if (strArr == null || strArr.length <= 0) {
            str2 = "User cancelled";
            z2 = false;
        } else {
            for (java.lang.String str3 : strArr) {
                if (str3.startsWith("content://")) {
                    strConvert2WebviewFullPath = io.dcloud.common.util.FileUtil.getPathFromUri(iApp.getActivity(), android.net.Uri.parse(str3));
                    if (!android.text.TextUtils.isEmpty(strConvert2WebviewFullPath) && !strConvert2WebviewFullPath.startsWith(io.dcloud.common.adapter.util.DeviceInfo.FILE_PROTOCOL)) {
                        strConvert2WebviewFullPath = io.dcloud.common.adapter.util.DeviceInfo.FILE_PROTOCOL + strConvert2WebviewFullPath;
                    }
                } else {
                    strConvert2WebviewFullPath = iApp.convert2WebviewFullPath(null, str3);
                }
                jSONArray.put(strConvert2WebviewFullPath);
            }
            try {
                jSONObject.put("files", jSONArray);
            } catch (org.json.JSONException e3) {
                e3.printStackTrace();
            }
            z2 = true;
            str2 = "pickImage path wrong";
        }
        if (!z2) {
            io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview, str, io.dcloud.common.constant.DOMException.toJSON(12, str2), io.dcloud.common.util.JSUtil.ERROR, true, false);
        } else {
            io.dcloud.common.util.JSUtil.execCallback(iWebview, str, jSONObject, io.dcloud.common.util.JSUtil.OK, false);
        }
    }
}
