package io.dcloud.js.file;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class FileFeatureImpl implements io.dcloud.common.DHInterface.IFeature {
    private static java.lang.String a;
    private static java.lang.String b;
    private static java.lang.String c;
    private static java.lang.String d;
    private static java.lang.String e;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class a implements io.dcloud.common.adapter.util.AsyncTaskHandler.IAsyncTaskListener {
        final /* synthetic */ java.lang.String a;
        final /* synthetic */ int b;
        final /* synthetic */ int c;
        final /* synthetic */ java.lang.String d;
        final /* synthetic */ io.dcloud.common.DHInterface.IWebview e;
        final /* synthetic */ java.lang.String f;

        a(java.lang.String str, int i, int i2, java.lang.String str2, io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str3) {
            this.a = str;
            this.b = i;
            this.c = i2;
            this.d = str2;
            this.e = iWebview;
            this.f = str3;
        }

        @Override // io.dcloud.common.adapter.util.AsyncTaskHandler.IAsyncTaskListener
        public void onCancel() {
        }

        @Override // io.dcloud.common.adapter.util.AsyncTaskHandler.IAsyncTaskListener
        public void onExecuteBegin() {
        }

        @Override // io.dcloud.common.adapter.util.AsyncTaskHandler.IAsyncTaskListener
        public void onExecuteEnd(java.lang.Object obj) {
            if (obj != null) {
                io.dcloud.common.util.Deprecated_JSUtil.execCallback(this.e, this.f, java.lang.String.valueOf(obj), io.dcloud.common.util.JSUtil.OK, true, false);
            } else {
                io.dcloud.js.file.FileFeatureImpl.this.a(10, this.e, this.f);
            }
        }

        /* JADX WARN: Code duplicated, block: B:46:0x0096 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:47:0x0098 A[Catch: IOException -> 0x0094, TRY_LEAVE, TryCatch #6 {IOException -> 0x0094, blocks: (B:43:0x0090, B:47:0x0098), top: B:71:0x0090 }] */
        /* JADX WARN: Code duplicated, block: B:58:0x00ac A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:59:0x00ae A[Catch: IOException -> 0x00aa, TRY_LEAVE, TryCatch #2 {IOException -> 0x00aa, blocks: (B:55:0x00a6, B:59:0x00ae), top: B:67:0x00a6 }] */
        /* JADX WARN: Code duplicated, block: B:67:0x00a6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:71:0x0090 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // io.dcloud.common.adapter.util.AsyncTaskHandler.IAsyncTaskListener
        public java.lang.Object onExecuting() throws java.lang.Throwable {
            java.io.ByteArrayOutputStream byteArrayOutputStream;
            java.lang.Exception e;
            java.io.InputStream inputStream;
            java.lang.Object obj;
            java.lang.Throwable th;
            java.io.InputStream inputStream2 = null;
            try {
                inputStream = io.dcloud.common.adapter.io.DHFile.getInputStream(io.dcloud.common.adapter.io.DHFile.createFileHandler(this.a));
                try {
                    try {
                        int iAvailable = inputStream.available();
                        try {
                            inputStream = new io.dcloud.common.adapter.io.UnicodeInputStream(inputStream, java.nio.charset.Charset.defaultCharset().name());
                        } catch (java.lang.Exception e2) {
                            e2.printStackTrace();
                        }
                        byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                        try {
                            int i = this.b;
                            if (i > 0) {
                                if (i >= iAvailable) {
                                    i = iAvailable - 1;
                                }
                                int i2 = this.c;
                                int i3 = (i - i2) + 1;
                                byte[] bArr = new byte[i3];
                                inputStream.skip(i2);
                                inputStream.read(bArr, 0, i3);
                                byteArrayOutputStream.write(bArr, 0, i3);
                            } else {
                                while (true) {
                                    byte[] bArr2 = new byte[io.dcloud.common.adapter.io.DHFile.BUF_SIZE];
                                    int i4 = inputStream.read(bArr2);
                                    if (i4 == -1) {
                                        break;
                                    }
                                    byteArrayOutputStream.write(bArr2, 0, i4);
                                }
                            }
                            java.lang.String jSONableString = io.dcloud.common.util.JSONUtil.toJSONableString(io.dcloud.common.util.PdrUtil.isEmpty(this.d) ? byteArrayOutputStream.toString() : byteArrayOutputStream.toString(this.d));
                            try {
                                inputStream.close();
                                byteArrayOutputStream.close();
                                return jSONableString;
                            } catch (java.io.IOException e3) {
                                e3.printStackTrace();
                                return jSONableString;
                            }
                        } catch (java.lang.Exception e4) {
                            e = e4;
                            java.io.InputStream inputStream3 = inputStream;
                            obj = null;
                            inputStream2 = inputStream3;
                            try {
                                e.printStackTrace();
                                if (inputStream2 != null) {
                                    try {
                                        inputStream2.close();
                                        if (byteArrayOutputStream != null) {
                                            byteArrayOutputStream.close();
                                        }
                                    } catch (java.io.IOException e5) {
                                        e5.printStackTrace();
                                        return obj;
                                    }
                                } else if (byteArrayOutputStream != null) {
                                    byteArrayOutputStream.close();
                                }
                                return obj;
                            } catch (java.lang.Throwable th2) {
                                th = th2;
                                inputStream = inputStream2;
                                th = th;
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                        if (byteArrayOutputStream != null) {
                                            byteArrayOutputStream.close();
                                        }
                                    } catch (java.io.IOException e6) {
                                        e6.printStackTrace();
                                        throw th;
                                    }
                                } else if (byteArrayOutputStream != null) {
                                    byteArrayOutputStream.close();
                                }
                                throw th;
                            }
                        } catch (java.lang.Throwable th3) {
                            th = th3;
                            if (inputStream != null) {
                                inputStream.close();
                                if (byteArrayOutputStream != null) {
                                    byteArrayOutputStream.close();
                                }
                            } else if (byteArrayOutputStream != null) {
                                byteArrayOutputStream.close();
                            }
                            throw th;
                        }
                    } catch (java.lang.Exception e7) {
                        e = e7;
                        byteArrayOutputStream = null;
                        inputStream2 = inputStream;
                        obj = null;
                        e.printStackTrace();
                        if (inputStream2 != null) {
                            inputStream2.close();
                            if (byteArrayOutputStream != null) {
                                byteArrayOutputStream.close();
                            }
                        } else if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        return obj;
                    }
                } catch (java.lang.Throwable th4) {
                    th = th4;
                    byteArrayOutputStream = null;
                    inputStream2 = inputStream;
                    inputStream = inputStream2;
                    th = th;
                    if (inputStream != null) {
                        inputStream.close();
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                    } else if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    throw th;
                }
            } catch (java.lang.Exception e8) {
                e = e8;
                inputStream = null;
            } catch (java.lang.Throwable th5) {
                th = th5;
                byteArrayOutputStream = null;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class b implements io.dcloud.common.adapter.util.AsyncTaskHandler.IAsyncTaskListener {
        final /* synthetic */ java.lang.String a;
        final /* synthetic */ int b;
        final /* synthetic */ int c;
        final /* synthetic */ io.dcloud.common.DHInterface.IWebview d;
        final /* synthetic */ java.lang.String e;

        b(java.lang.String str, int i, int i2, io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str2) {
            this.a = str;
            this.b = i;
            this.c = i2;
            this.d = iWebview;
            this.e = str2;
        }

        @Override // io.dcloud.common.adapter.util.AsyncTaskHandler.IAsyncTaskListener
        public void onCancel() {
        }

        @Override // io.dcloud.common.adapter.util.AsyncTaskHandler.IAsyncTaskListener
        public void onExecuteBegin() {
        }

        @Override // io.dcloud.common.adapter.util.AsyncTaskHandler.IAsyncTaskListener
        public void onExecuteEnd(java.lang.Object obj) {
            if (obj != null) {
                io.dcloud.common.util.Deprecated_JSUtil.execCallback(this.d, this.e, java.lang.String.valueOf(obj), io.dcloud.common.util.JSUtil.OK, true, false);
            } else {
                io.dcloud.js.file.FileFeatureImpl.this.a(10, this.d, this.e);
            }
        }

        /* JADX WARN: Code duplicated, block: B:51:0x009c A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:52:0x009e A[Catch: IOException -> 0x009a, TRY_LEAVE, TryCatch #0 {IOException -> 0x009a, blocks: (B:48:0x0096, B:52:0x009e), top: B:67:0x0096 }] */
        /* JADX WARN: Code duplicated, block: B:62:0x00b0 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:63:0x00b2 A[Catch: IOException -> 0x00ae, TRY_LEAVE, TryCatch #8 {IOException -> 0x00ae, blocks: (B:59:0x00aa, B:63:0x00b2), top: B:78:0x00aa }] */
        /* JADX WARN: Code duplicated, block: B:67:0x0096 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:78:0x00aa A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // io.dcloud.common.adapter.util.AsyncTaskHandler.IAsyncTaskListener
        public java.lang.Object onExecuting() throws java.lang.Throwable {
            java.io.ByteArrayOutputStream byteArrayOutputStream;
            java.lang.String str;
            java.lang.String strEncodeToString;
            java.lang.String mimeType = io.dcloud.common.util.PdrUtil.getMimeType(this.a);
            java.io.InputStream inputStream = null;
            java.lang.String str2 = null;
            java.io.InputStream inputStream2 = null;
            try {
                java.io.InputStream inputStream3 = io.dcloud.common.adapter.io.DHFile.getInputStream(io.dcloud.common.adapter.io.DHFile.createFileHandler(this.a));
                try {
                    int iAvailable = inputStream3.available();
                    int i = this.b;
                    if (i > 0) {
                        if (i >= iAvailable) {
                            i = iAvailable - 1;
                        }
                        int i2 = this.c;
                        int i3 = (i - i2) + 1;
                        byte[] bArr = new byte[i3];
                        inputStream3.skip(i2);
                        inputStream3.read(bArr, 0, i3);
                        strEncodeToString = android.util.Base64.encodeToString(bArr, 2);
                        byteArrayOutputStream = null;
                    } else {
                        byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                        while (true) {
                            try {
                                try {
                                    byte[] bArr2 = new byte[io.dcloud.common.adapter.io.DHFile.BUF_SIZE];
                                    int i4 = inputStream3.read(bArr2);
                                    if (i4 == -1) {
                                        break;
                                    }
                                    byteArrayOutputStream.write(bArr2, 0, i4);
                                } catch (java.lang.Throwable th) {
                                    th = th;
                                    if (inputStream3 != null) {
                                        try {
                                            inputStream3.close();
                                            if (byteArrayOutputStream != null) {
                                                byteArrayOutputStream.close();
                                            }
                                        } catch (java.io.IOException e) {
                                            e.printStackTrace();
                                            throw th;
                                        }
                                    } else if (byteArrayOutputStream != null) {
                                        byteArrayOutputStream.close();
                                    }
                                    throw th;
                                }
                            } catch (java.lang.Exception e2) {
                                e = e2;
                                e.printStackTrace();
                                if (inputStream3 != null) {
                                    try {
                                        inputStream3.close();
                                        if (byteArrayOutputStream != null) {
                                            byteArrayOutputStream.close();
                                        }
                                    } catch (java.io.IOException e3) {
                                        e3.printStackTrace();
                                        return str2;
                                    }
                                } else if (byteArrayOutputStream != null) {
                                    byteArrayOutputStream.close();
                                }
                                return str2;
                            }
                        }
                        strEncodeToString = android.util.Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
                    }
                    try {
                        try {
                            java.lang.String str3 = io.dcloud.common.util.StringUtil.format("data:%s;base64,%s", mimeType, strEncodeToString);
                            try {
                                java.lang.String jSONableString = io.dcloud.common.util.JSONUtil.toJSONableString(str3);
                                try {
                                    inputStream3.close();
                                    if (byteArrayOutputStream == null) {
                                        return jSONableString;
                                    }
                                    byteArrayOutputStream.close();
                                    return jSONableString;
                                } catch (java.io.IOException e4) {
                                    e4.printStackTrace();
                                    return jSONableString;
                                }
                            } catch (java.lang.Exception e5) {
                                str = str3;
                                e = e5;
                                inputStream2 = inputStream3;
                                java.lang.String str4 = str;
                                inputStream3 = inputStream2;
                                str2 = str4;
                                e.printStackTrace();
                                if (inputStream3 != null) {
                                    inputStream3.close();
                                    if (byteArrayOutputStream != null) {
                                        byteArrayOutputStream.close();
                                    }
                                } else if (byteArrayOutputStream != null) {
                                    byteArrayOutputStream.close();
                                }
                                return str2;
                            }
                        } catch (java.lang.Exception e6) {
                            e = e6;
                            str = null;
                        }
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                        inputStream = inputStream3;
                        inputStream3 = inputStream;
                        if (inputStream3 != null) {
                            inputStream3.close();
                            if (byteArrayOutputStream != null) {
                                byteArrayOutputStream.close();
                            }
                        } else if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        throw th;
                    }
                } catch (java.lang.Exception e7) {
                    e = e7;
                    byteArrayOutputStream = null;
                    inputStream2 = inputStream3;
                    str = null;
                } catch (java.lang.Throwable th3) {
                    th = th3;
                    byteArrayOutputStream = null;
                }
            } catch (java.lang.Exception e8) {
                e = e8;
                str = null;
                byteArrayOutputStream = null;
            } catch (java.lang.Throwable th4) {
                th = th4;
                byteArrayOutputStream = null;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class c extends com.bumptech.glide.request.target.CustomTarget {
        final /* synthetic */ java.lang.String a;
        final /* synthetic */ io.dcloud.common.DHInterface.IWebview b;
        final /* synthetic */ java.lang.String c;

        c(java.lang.String str, io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str2) {
            this.a = str;
            this.b = iWebview;
            this.c = str2;
        }

        @Override // com.bumptech.glide.request.target.Target
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResourceReady(java.io.File file, com.bumptech.glide.request.transition.Transition transition) {
            if (io.dcloud.common.util.PdrUtil.isEmpty(this.a)) {
                io.dcloud.js.file.FileFeatureImpl.this.a(file.getAbsolutePath(), this.b, this.c);
            } else if (io.dcloud.common.adapter.io.DHFile.copyFile(file.getPath(), this.a) != 1) {
                io.dcloud.common.util.Deprecated_JSUtil.execCallback(this.b, this.c, io.dcloud.common.constant.DOMException.toJSON(13, "Failed to load resource"), io.dcloud.common.util.JSUtil.ERROR, true, false);
            } else {
                io.dcloud.js.file.FileFeatureImpl.this.a(this.a, this.b, this.c);
            }
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadCleared(android.graphics.drawable.Drawable drawable) {
        }

        @Override // com.bumptech.glide.request.target.CustomTarget, com.bumptech.glide.request.target.Target
        public void onLoadFailed(android.graphics.drawable.Drawable drawable) {
            io.dcloud.common.util.Deprecated_JSUtil.execCallback(this.b, this.c, io.dcloud.common.constant.DOMException.toJSON(13, "Failed to load resource"), io.dcloud.common.util.JSUtil.ERROR, true, false);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class d implements java.lang.Runnable {
        final /* synthetic */ java.io.File a;
        final /* synthetic */ java.lang.String b;
        final /* synthetic */ io.dcloud.common.DHInterface.IWebview c;
        final /* synthetic */ java.lang.String d;

        d(java.io.File file, java.lang.String str, io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str2) {
            this.a = file;
            this.b = str;
            this.c = iWebview;
            this.d = str2;
        }

        @Override // java.lang.Runnable
        public void run() throws java.lang.Throwable {
            java.lang.String strMd5 = io.dcloud.common.util.Md5Utils.md5(this.a, this.b);
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            try {
                jSONObject.put(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_SIZE, this.a.length());
                if (strMd5 != null) {
                    jSONObject.put(com.taobao.weex.common.Constants.CodeCache.BANNER_DIGEST, strMd5.toUpperCase(java.util.Locale.US));
                }
            } catch (org.json.JSONException unused) {
            }
            io.dcloud.common.util.Deprecated_JSUtil.execCallback(this.c, this.d, jSONObject.toString(), io.dcloud.common.util.JSUtil.OK, true, false);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class e implements io.dcloud.common.DHInterface.ISysEventListener {
        final /* synthetic */ int a;
        final /* synthetic */ io.dcloud.common.DHInterface.IApp b;
        final /* synthetic */ io.dcloud.common.DHInterface.IWebview c;
        final /* synthetic */ java.lang.String d;

        e(int i, io.dcloud.common.DHInterface.IApp iApp, io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str) {
            this.a = i;
            this.b = iApp;
            this.c = iWebview;
            this.d = str;
        }

        @Override // io.dcloud.common.DHInterface.ISysEventListener
        public boolean onExecute(io.dcloud.common.DHInterface.ISysEventListener.SysEventType sysEventType, java.lang.Object obj) {
            java.lang.Object[] objArr = (java.lang.Object[]) obj;
            int iIntValue = ((java.lang.Integer) objArr[0]).intValue();
            android.content.Intent intent = (android.content.Intent) objArr[2];
            io.dcloud.common.DHInterface.ISysEventListener.SysEventType sysEventType2 = io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onActivityResult;
            if (sysEventType == sysEventType2 && iIntValue == this.a) {
                this.b.unregisterSysEventListener(this, sysEventType2);
                if (intent == null || (intent.getData() == null && intent.getClipData() == null)) {
                    io.dcloud.common.util.Deprecated_JSUtil.execCallback(this.c, this.d, io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.DOMException.JSON_ERROR_INFO, -2, io.dcloud.common.constant.DOMException.MSG_USER_CANCEL), io.dcloud.common.util.JSUtil.ERROR, true, false);
                } else {
                    org.json.JSONArray jSONArray = new org.json.JSONArray();
                    android.content.ClipData clipData = intent.getClipData();
                    if (clipData != null) {
                        int itemCount = clipData.getItemCount();
                        for (int i = 0; i < itemCount; i++) {
                            jSONArray.put(io.dcloud.common.util.FileUtil.getPathFromUri(this.b.getActivity(), clipData.getItemAt(i).getUri()));
                        }
                    } else {
                        android.net.Uri data = intent.getData();
                        java.lang.String pathFromUri = io.dcloud.common.util.FileUtil.getPathFromUri(this.b.getActivity(), data);
                        if (io.dcloud.common.util.PdrUtil.isEmpty(pathFromUri)) {
                            pathFromUri = data.toString();
                        }
                        jSONArray.put(pathFromUri);
                    }
                    org.json.JSONObject jSONObject = new org.json.JSONObject();
                    try {
                        jSONObject.put("files", jSONArray);
                    } catch (org.json.JSONException e) {
                        e.printStackTrace();
                    }
                    io.dcloud.common.util.Deprecated_JSUtil.execCallback(this.c, this.d, jSONObject.toString(), io.dcloud.common.util.JSUtil.OK, true, false);
                }
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class f implements io.dcloud.common.adapter.util.AsyncTaskHandler.IAsyncTaskListener {
        final /* synthetic */ java.lang.String[] a;
        final /* synthetic */ io.dcloud.common.DHInterface.IWebview b;
        final /* synthetic */ java.lang.String c;
        final /* synthetic */ int d;
        final /* synthetic */ java.lang.String e;

        f(java.lang.String[] strArr, io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, int i, java.lang.String str2) {
            this.a = strArr;
            this.b = iWebview;
            this.c = str;
            this.d = i;
            this.e = str2;
        }

        @Override // io.dcloud.common.adapter.util.AsyncTaskHandler.IAsyncTaskListener
        public void onCancel() {
        }

        @Override // io.dcloud.common.adapter.util.AsyncTaskHandler.IAsyncTaskListener
        public void onExecuteBegin() {
        }

        @Override // io.dcloud.common.adapter.util.AsyncTaskHandler.IAsyncTaskListener
        public void onExecuteEnd(java.lang.Object obj) {
        }

        @Override // io.dcloud.common.adapter.util.AsyncTaskHandler.IAsyncTaskListener
        public java.lang.Object onExecuting() {
            byte[] bArrDecode2bytes = io.dcloud.common.util.Base64.decode2bytes(this.a[1]);
            if (bArrDecode2bytes == null) {
                io.dcloud.common.util.Deprecated_JSUtil.execCallback(this.b, this.c, io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.DOMException.JSON_ERROR_INFO, 16, this.b.getContext().getString(io.dcloud.base.R.string.dcloud_io_write_non_base64)).toString(), io.dcloud.common.util.JSUtil.ERROR, true, false);
                return null;
            }
            io.dcloud.common.adapter.io.DHFile.writeFile(bArrDecode2bytes, this.d, this.e);
            io.dcloud.common.util.JSUtil.execCallback(this.b, this.c, bArrDecode2bytes.length, io.dcloud.common.util.JSUtil.OK, false);
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class g implements io.dcloud.common.adapter.util.AsyncTaskHandler.IAsyncTaskListener {
        final /* synthetic */ java.lang.String a;
        final /* synthetic */ int b;
        final /* synthetic */ int c;
        final /* synthetic */ io.dcloud.common.DHInterface.IWebview d;
        final /* synthetic */ java.lang.String e;

        g(java.lang.String str, int i, int i2, io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str2) {
            this.a = str;
            this.b = i;
            this.c = i2;
            this.d = iWebview;
            this.e = str2;
        }

        @Override // io.dcloud.common.adapter.util.AsyncTaskHandler.IAsyncTaskListener
        public void onCancel() {
        }

        @Override // io.dcloud.common.adapter.util.AsyncTaskHandler.IAsyncTaskListener
        public void onExecuteBegin() {
        }

        @Override // io.dcloud.common.adapter.util.AsyncTaskHandler.IAsyncTaskListener
        public void onExecuteEnd(java.lang.Object obj) {
            if (obj != null) {
                io.dcloud.common.util.Deprecated_JSUtil.execCallback(this.d, this.e, java.lang.String.valueOf(obj), io.dcloud.common.util.JSUtil.OK, true, false);
            } else {
                io.dcloud.js.file.FileFeatureImpl.this.a(10, this.d, this.e);
            }
        }

        /* JADX WARN: Code duplicated, block: B:41:0x0097 A[Catch: IOException -> 0x0093, TRY_LEAVE, TryCatch #3 {IOException -> 0x0093, blocks: (B:37:0x008f, B:41:0x0097), top: B:62:0x008f }] */
        /* JADX WARN: Code duplicated, block: B:54:0x00ad A[Catch: IOException -> 0x00a9, TRY_LEAVE, TryCatch #0 {IOException -> 0x00a9, blocks: (B:50:0x00a5, B:54:0x00ad), top: B:58:0x00a5 }] */
        /* JADX WARN: Code duplicated, block: B:58:0x00a5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:73:? A[SYNTHETIC] */
        @Override // io.dcloud.common.adapter.util.AsyncTaskHandler.IAsyncTaskListener
        public java.lang.Object onExecuting() throws java.lang.Throwable {
            java.io.ByteArrayOutputStream byteArrayOutputStream;
            java.io.InputStream inputStream;
            java.lang.Throwable th;
            java.lang.String strEncodeToString;
            java.io.InputStream inputStream2 = null;
            jSONableString = null;
            jSONableString = null;
            java.lang.String jSONableString = null;
            try {
                inputStream = io.dcloud.common.adapter.io.DHFile.getInputStream(io.dcloud.common.adapter.io.DHFile.createFileHandler(this.a));
                try {
                    int iAvailable = inputStream.available();
                    int i = this.b;
                    if (i > 0) {
                        if (i >= iAvailable) {
                            i = iAvailable - 1;
                        }
                        int i2 = this.c;
                        int i3 = (i - i2) + 1;
                        byte[] bArr = new byte[i3];
                        inputStream.skip(i2);
                        inputStream.read(bArr, 0, i3);
                        strEncodeToString = android.util.Base64.encodeToString(bArr, 2);
                        byteArrayOutputStream = null;
                    } else {
                        byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                        while (true) {
                            try {
                                try {
                                    byte[] bArr2 = new byte[io.dcloud.common.adapter.io.DHFile.BUF_SIZE];
                                    int i4 = inputStream.read(bArr2);
                                    if (i4 == -1) {
                                        break;
                                    }
                                    byteArrayOutputStream.write(bArr2, 0, i4);
                                } catch (java.lang.Exception e) {
                                    e = e;
                                    io.dcloud.common.util.Deprecated_JSUtil.execCallback(this.d, this.e, io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.DOMException.JSON_ERROR_INFO, 13, e.getMessage()), io.dcloud.common.util.JSUtil.ERROR, true, false);
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                            if (byteArrayOutputStream != null) {
                                                byteArrayOutputStream.close();
                                            }
                                        } catch (java.io.IOException e2) {
                                            e2.printStackTrace();
                                        }
                                    } else if (byteArrayOutputStream != null) {
                                        byteArrayOutputStream.close();
                                    }
                                }
                            } catch (java.lang.Throwable th2) {
                                th = th2;
                                th = th;
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (java.io.IOException e3) {
                                        e3.printStackTrace();
                                        throw th;
                                    }
                                }
                                if (byteArrayOutputStream != null) {
                                    throw th;
                                }
                                byteArrayOutputStream.close();
                                throw th;
                            }
                        }
                        strEncodeToString = android.util.Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
                    }
                    try {
                        jSONableString = io.dcloud.common.util.JSONUtil.toJSONableString(strEncodeToString);
                        try {
                            inputStream.close();
                            if (byteArrayOutputStream != null) {
                                byteArrayOutputStream.close();
                            }
                        } catch (java.io.IOException e4) {
                            e4.printStackTrace();
                        }
                    } catch (java.lang.Throwable th3) {
                        th = th3;
                        inputStream2 = inputStream;
                        inputStream = inputStream2;
                        th = th;
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (byteArrayOutputStream != null) {
                            throw th;
                        }
                        byteArrayOutputStream.close();
                        throw th;
                    }
                } catch (java.lang.Exception e5) {
                    e = e5;
                    byteArrayOutputStream = null;
                } catch (java.lang.Throwable th4) {
                    th = th4;
                    byteArrayOutputStream = null;
                    inputStream2 = inputStream;
                    inputStream = inputStream2;
                    th = th;
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (byteArrayOutputStream != null) {
                        throw th;
                    }
                    byteArrayOutputStream.close();
                    throw th;
                }
            } catch (java.lang.Exception e6) {
                e = e6;
                inputStream = null;
                byteArrayOutputStream = null;
            } catch (java.lang.Throwable th5) {
                th = th5;
                byteArrayOutputStream = null;
                inputStream = inputStream2;
                th = th;
                if (inputStream != null) {
                    inputStream.close();
                }
                if (byteArrayOutputStream != null) {
                    throw th;
                }
                byteArrayOutputStream.close();
                throw th;
            }
            return jSONableString;
        }
    }

    private void b(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String[] strArr, java.lang.String str) {
        try {
            java.lang.String str2 = strArr[0];
            if (!io.dcloud.common.util.FileUtil.checkPathAccord(iWebview.getContext(), str2)) {
                a(15, iWebview, str);
                return;
            }
            boolean zCheckPrivateDir = iWebview.obtainApp().checkPrivateDir(str2);
            int iIntValue = java.lang.Integer.valueOf(strArr[2]).intValue();
            try {
                if (strArr[1] != null && !zCheckPrivateDir) {
                    io.dcloud.common.adapter.util.AsyncTaskHandler.executeThreadTask(new io.dcloud.js.file.FileFeatureImpl.f(strArr, iWebview, str, iIntValue, str2));
                    return;
                }
                a(4, iWebview, str);
            } catch (java.lang.Exception unused) {
                a(10, iWebview, str);
            }
        } catch (java.lang.Exception unused2) {
        }
    }

    private java.lang.String c(java.lang.String str) {
        if (str.startsWith(a)) {
            return io.dcloud.common.constant.AbsoluteConst.MINI_SERVER_APP_WWW + str.substring(a.length(), str.length());
        }
        if (str.startsWith(c)) {
            return io.dcloud.common.constant.AbsoluteConst.MINI_SERVER_APP_DOC + str.substring(c.length(), str.length());
        }
        if (str.startsWith(d)) {
            return "_documents/" + str.substring(d.length(), str.length());
        }
        if (!str.startsWith(e)) {
            return null;
        }
        return "_downloads/" + str.substring(e.length(), str.length());
    }

    private java.lang.String d(java.lang.String str) {
        boolean z;
        java.lang.String strB = b(str);
        if (io.dcloud.common.util.PdrUtil.isEmpty(strB)) {
            strB = java.lang.String.valueOf(-1);
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (str.startsWith(a)) {
                return java.lang.String.valueOf(1);
            }
            if (str.startsWith(c)) {
                return java.lang.String.valueOf(2);
            }
            if (str.startsWith(d)) {
                return java.lang.String.valueOf(3);
            }
            if (str.startsWith(e)) {
                return java.lang.String.valueOf(4);
            }
        }
        return strB;
    }

    private boolean e(java.lang.String str) {
        return str.endsWith(io.dcloud.common.util.BaseInfo.REL_PRIVATE_WWW_DIR) || str.endsWith(io.dcloud.common.util.BaseInfo.REL_PUBLIC_DOCUMENTS_DIR) || str.endsWith(io.dcloud.common.util.BaseInfo.REL_PUBLIC_DOWNLOADS_DIR) || str.endsWith(io.dcloud.common.util.BaseInfo.REL_PRIVATE_DOC_DIR) || str.endsWith(io.dcloud.common.constant.AbsoluteConst.MINI_SERVER_APP_WWW) || str.endsWith("_documents/") || str.endsWith("_downloads/") || str.endsWith(io.dcloud.common.constant.AbsoluteConst.MINI_SERVER_APP_DOC);
    }

    @Override // io.dcloud.common.DHInterface.IFeature
    public void dispose(java.lang.String str) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:4:0x005b  */
    @Override // io.dcloud.common.DHInterface.IFeature
    public java.lang.String execute(final io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.String[] strArr) throws java.lang.Throwable {
        byte b2;
        org.json.JSONObject jSONObjectA;
        boolean zRenameTo;
        java.lang.String str2;
        java.lang.String str3;
        org.json.JSONObject jSONObjectA2;
        boolean z;
        java.lang.String name;
        boolean z2;
        java.lang.String strOptString;
        java.lang.Throwable th;
        org.json.JSONObject jSONObjectA3;
        java.lang.String str4;
        java.io.FileOutputStream fileOutputStream;
        java.lang.String str5;
        io.dcloud.common.DHInterface.IWebview iWebview2;
        java.io.FileInputStream fileInputStream;
        char c2;
        org.json.JSONArray jSONArrayB;
        boolean zOptBoolean;
        java.lang.String strOptString2 = io.dcloud.common.util.Md5Utils.ALGORITHM;
        final java.lang.String str6 = strArr[0];
        io.dcloud.common.DHInterface.IApp iAppObtainApp = iWebview.obtainFrameView().obtainApp();
        io.dcloud.common.util.AppRuntime.checkPrivacyComplianceAndPrompt(iWebview.getContext(), "Io-" + str);
        boolean zIsOnAppRunningMode = iAppObtainApp.isOnAppRunningMode();
        a = iAppObtainApp.getPathByType((byte) 0);
        b = iAppObtainApp.getPathByType((byte) -1);
        boolean z3 = true;
        c = iAppObtainApp.getPathByType((byte) 1);
        d = iAppObtainApp.getPathByType((byte) 2);
        e = iAppObtainApp.getPathByType((byte) 3);
        str.getClass();
        str.hashCode();
        switch (str) {
            case "copyTo":
                b2 = 0;
                break;
            case "requestFileSystem":
                b2 = 1;
                break;
            case "moveTo":
                b2 = 2;
                break;
            case "readAsText":
                b2 = 3;
                break;
            case "getDirectory":
                b2 = 4;
                break;
            case "convertLocalFileSystemURL":
                b2 = 5;
                break;
            case "remove":
                b2 = 6;
                break;
            case "getImageInfo":
                b2 = 7;
                break;
            case "getFileMetadata":
                b2 = 8;
                break;
            case "getFile":
                b2 = 9;
                break;
            case "write":
                b2 = 10;
                break;
            case "getAudioInfo":
                b2 = 11;
                break;
            case "convertAbsoluteFileSystem":
                b2 = 12;
                break;
            case "readAsDataURL":
                b2 = 13;
                break;
            case "writeAsBinary":
                b2 = 14;
                break;
            case "getParent":
                b2 = 15;
                break;
            case "readAsBase64":
                b2 = 16;
                break;
            case "getVideoInfo":
                b2 = 17;
                break;
            case "getFileInfo":
                b2 = 18;
                break;
            case "removeRecursively":
                b2 = 19;
                break;
            case "resolveLocalFileSystemURL":
                b2 = 20;
                break;
            case "getMetadata":
                b2 = 21;
                break;
            case "truncate":
                b2 = 22;
                break;
            case "readEntries":
                b2 = 23;
                break;
            case "chooseFile":
                b2 = 24;
                break;
            default:
                b2 = -1;
                break;
        }
        java.lang.String strOptString3 = "";
        java.io.InputStream inputStream = null;
        java.io.FileOutputStream fileOutputStream2 = null;
        java.io.FileInputStream fileInputStream2 = null;
        switch (b2) {
            case 0:
                java.lang.String[] strArrA = a(iWebview, strArr, str6);
                if (strArrA != null) {
                    java.lang.String string = strArrA[1];
                    if (string != null) {
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        sb.append(strArrA[1]);
                        java.lang.String str7 = strArrA[1];
                        java.lang.String str8 = java.io.File.separator;
                        sb.append(str7.endsWith(str8) ? "" : str8);
                        string = sb.toString();
                    }
                    java.lang.String str9 = string + strArrA[2];
                    java.lang.String str10 = strArrA[0];
                    if (!io.dcloud.common.util.FileUtil.checkPathAccord(iWebview.getContext(), str9, str10) && !io.dcloud.common.util.FileUtil.isFilePathForPublic(iWebview.getContext(), str10)) {
                        a(15, iWebview, str6);
                    } else if (iAppObtainApp.checkPrivateDir(str9)) {
                        a(10, iWebview, str6);
                    } else {
                        try {
                            if (io.dcloud.common.adapter.io.DHFile.isExist(str9) || (!io.dcloud.common.adapter.io.DHFile.isExist(str10) ? !io.dcloud.common.adapter.io.DHFile.copyAssetsFile(str10, str9) : io.dcloud.common.adapter.io.DHFile.copyFile(str10, str9) != 1)) {
                                a(10, iWebview, str6);
                            } else {
                                io.dcloud.common.util.JSUtil.execCallback(iWebview, str6, io.dcloud.js.file.a.a(strArrA[2], str9, iAppObtainApp.convert2RelPath(str9), new java.io.File(str9).isDirectory()), io.dcloud.common.util.JSUtil.OK, false);
                            }
                        } catch (java.io.IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
                return null;
            case 1:
                try {
                    java.lang.String[] strArrA2 = a(iWebview, strArr, str6);
                    if (strArrA2 != null) {
                        int i = java.lang.Integer.parseInt(strArrA2[0]);
                        if (i == 1) {
                            jSONObjectA = io.dcloud.js.file.a.a("PRIVATE_WWW", 1, io.dcloud.common.util.BaseInfo.REAL_PRIVATE_WWW_DIR, a, io.dcloud.common.util.BaseInfo.REL_PRIVATE_WWW_DIR);
                        } else if (i == 2) {
                            jSONObjectA = io.dcloud.js.file.a.a("PRIVATE_DOCUMENTS", 2, io.dcloud.common.util.BaseInfo.REAL_PRIVATE_DOC_DIR, c, io.dcloud.common.util.BaseInfo.REL_PRIVATE_DOC_DIR);
                        } else if (i == 3) {
                            jSONObjectA = io.dcloud.js.file.a.a("PUBLIC_DOCUMENTS", 3, io.dcloud.common.util.BaseInfo.REAL_PUBLIC_DOCUMENTS_DIR, d, io.dcloud.common.util.BaseInfo.REL_PUBLIC_DOCUMENTS_DIR);
                        } else if (i != 4) {
                            java.lang.String str11 = io.dcloud.common.adapter.util.DeviceInfo.sDeviceRootDir;
                            jSONObjectA = io.dcloud.js.file.a.a("PUBLIC_DEVICE_ROOT", 5, str11, str11, str11);
                        } else {
                            jSONObjectA = io.dcloud.js.file.a.a("PUBLIC_DOWNLOADS", 4, io.dcloud.common.util.BaseInfo.REAL_PUBLIC_DOWNLOADS_DIR, e, io.dcloud.common.util.BaseInfo.REL_PUBLIC_DOWNLOADS_DIR);
                        }
                        io.dcloud.common.util.JSUtil.execCallback(iWebview, str6, jSONObjectA, io.dcloud.common.util.JSUtil.OK, false);
                        break;
                    }
                } catch (java.lang.Exception e3) {
                    e3.printStackTrace();
                    a(10, iWebview, str6);
                }
                return null;
            case 2:
                java.lang.String[] strArrA3 = a(iWebview, strArr, str6);
                if (strArrA3 != null) {
                    java.lang.String strConvert2AbsFullPath = iAppObtainApp.convert2AbsFullPath(iWebview.obtainFullUrl(), strArrA3[1] + strArrA3[2]);
                    if (iAppObtainApp.checkPrivateDir(strArrA3[0]) || iAppObtainApp.checkPrivateDir(strConvert2AbsFullPath)) {
                        a(10, iWebview, str6);
                    } else {
                        java.lang.String strConvert2AbsFullPath2 = iAppObtainApp.convert2AbsFullPath(iWebview.obtainFullUrl(), strArrA3[0]);
                        if (io.dcloud.common.util.FileUtil.checkPathAccord(iWebview.getContext(), strConvert2AbsFullPath, strConvert2AbsFullPath2)) {
                            java.io.File file = new java.io.File(strConvert2AbsFullPath2);
                            boolean zIsDirectory = file.isDirectory();
                            java.io.File file2 = new java.io.File(strConvert2AbsFullPath);
                            if (file2.exists()) {
                                zRenameTo = false;
                            } else {
                                java.io.File parentFile = file2.getParentFile();
                                if (!parentFile.exists()) {
                                    parentFile.mkdirs();
                                }
                                zRenameTo = file.renameTo(file2);
                            }
                            if (zRenameTo) {
                                io.dcloud.common.util.JSUtil.execCallback(iWebview, str6, io.dcloud.js.file.a.a(strArrA3[2], strConvert2AbsFullPath, iAppObtainApp.convert2RelPath(strConvert2AbsFullPath), zIsDirectory), io.dcloud.common.util.JSUtil.OK, false);
                            } else {
                                a(10, iWebview, str6);
                            }
                        } else {
                            a(15, iWebview, str6);
                        }
                    }
                }
                return null;
            case 3:
                java.lang.String[] strArrA4 = a(iWebview, strArr, str6);
                if (strArrA4 != null) {
                    java.lang.String str12 = strArrA4[0];
                    if (io.dcloud.common.util.FileUtil.checkPathAccord(iWebview.getContext(), str12)) {
                        boolean zCheckPrivateDir = iAppObtainApp.checkPrivateDir(str12);
                        java.lang.String str13 = strArrA4[1];
                        int i2 = io.dcloud.common.util.PdrUtil.parseInt(strArrA4[2], 0);
                        int i3 = io.dcloud.common.util.PdrUtil.parseInt(strArrA4[3], -1);
                        if (zCheckPrivateDir && zIsOnAppRunningMode) {
                            a(10, iWebview, str6);
                        } else {
                            io.dcloud.common.adapter.util.AsyncTaskHandler.executeThreadTask(new io.dcloud.js.file.FileFeatureImpl.a(str12, i3, i2, str13, iWebview, str6));
                        }
                    } else {
                        a(15, iWebview, str6);
                    }
                }
                return null;
            case 4:
                java.lang.String[] strArrA5 = a(iWebview, strArr, str6);
                if (strArrA5 != null) {
                    java.lang.String str14 = strArrA5[0];
                    if (str14 != null && !str14.endsWith("/")) {
                        strArrA5[0] = strArrA5[0] + "/";
                    }
                    java.lang.String strConvert2AbsFullPath3 = iAppObtainApp.convert2AbsFullPath(strArrA5[0], strArrA5[1]);
                    if (!io.dcloud.common.util.FileUtil.checkPathAccord(iWebview.getContext(), strConvert2AbsFullPath3)) {
                        a(15, iWebview, str6);
                    } else {
                        if (strArrA5[0] != null && (str2 = strArrA5[1]) != null && str2.indexOf("../") != -1 && e(strArrA5[0])) {
                            a(4, iWebview, str6);
                            return null;
                        }
                        if (!strConvert2AbsFullPath3.endsWith("/")) {
                            strConvert2AbsFullPath3 = strConvert2AbsFullPath3 + "/";
                        }
                        java.io.File file3 = new java.io.File(strConvert2AbsFullPath3);
                        try {
                            org.json.JSONObject jSONObject = new org.json.JSONObject(strArrA5[2]);
                            boolean zOptBoolean2 = jSONObject.optBoolean("create");
                            boolean zOptBoolean3 = jSONObject.optBoolean("exclusive");
                            if (!file3.exists()) {
                                if (!zOptBoolean2) {
                                    a(14, iWebview, str6);
                                    return null;
                                }
                                byte bCreateNewFile = io.dcloud.common.adapter.io.DHFile.createNewFile(strConvert2AbsFullPath3);
                                if (bCreateNewFile == -1 || (bCreateNewFile == -2 && zOptBoolean3)) {
                                    throw new java.lang.RuntimeException();
                                }
                            } else if (zOptBoolean3 && zOptBoolean3) {
                                a(12, iWebview, str6);
                            }
                            io.dcloud.common.util.JSUtil.execCallback(iWebview, str6, io.dcloud.js.file.a.a(strArrA5[1], strConvert2AbsFullPath3, iAppObtainApp.convert2RelPath(strConvert2AbsFullPath3), true), io.dcloud.common.util.JSUtil.OK, false);
                        } catch (java.lang.Exception unused) {
                            io.dcloud.common.adapter.util.Logger.d("Not Found " + strConvert2AbsFullPath3);
                            a(10, iWebview, str6);
                        }
                    }
                }
                return null;
            case 5:
                return io.dcloud.common.util.Deprecated_JSUtil.wrapJsVar(iAppObtainApp.convert2AbsFullPath(iWebview.obtainFullUrl(), strArr[0]), true);
            case 6:
                java.lang.String[] strArrA6 = a(iWebview, strArr, str6);
                if (strArrA6 != null) {
                    java.lang.String str15 = strArrA6[0];
                    if (!io.dcloud.common.util.FileUtil.checkPathAccord(iWebview.getContext(), str15)) {
                        a(15, iWebview, str6);
                    } else {
                        if (iAppObtainApp.checkPrivateDir(str15)) {
                            a(4, iWebview, str6);
                            return null;
                        }
                        if (new java.io.File(str15).delete()) {
                            io.dcloud.common.util.JSUtil.execCallback(iWebview, str6, "", io.dcloud.common.util.JSUtil.OK, false);
                        } else {
                            a(10, iWebview, str6);
                        }
                    }
                }
                return null;
            case 7:
                java.lang.String str16 = strArr[0];
                java.lang.String str17 = strArr[1];
                if (!io.dcloud.common.util.PdrUtil.isEmpty(str17)) {
                    if (io.dcloud.common.util.PdrUtil.isNetPath(str17)) {
                        try {
                            if (strArr.length <= 2 || io.dcloud.common.util.PdrUtil.isEmpty(strArr[2])) {
                                str3 = null;
                            } else {
                                java.lang.String str18 = strArr[2];
                                if (!str18.endsWith("/")) {
                                    str18 = str18 + "/";
                                }
                                java.lang.String downloadFilename = io.dcloud.common.util.PdrUtil.getDownloadFilename(str17, "image/*", str17);
                                if (android.text.TextUtils.isEmpty(downloadFilename)) {
                                    downloadFilename = java.lang.System.currentTimeMillis() + "_" + java.lang.Math.abs(str17.hashCode());
                                }
                                str3 = iWebview.obtainApp().convert2AbsFullPath(iWebview.obtainFullUrl(), str18) + downloadFilename;
                            }
                            com.bumptech.glide.Glide.with(iWebview.getContext()).asFile().load(str17).into(new io.dcloud.js.file.FileFeatureImpl.c(str3, iWebview, str16));
                        } catch (java.lang.Exception unused2) {
                            io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview, str16, io.dcloud.common.constant.DOMException.toJSON(13, "Failed to load resource"), io.dcloud.common.util.JSUtil.ERROR, true, false);
                        }
                        break;
                    } else {
                        java.lang.String strConvert2AbsFullPath4 = iAppObtainApp.convert2AbsFullPath(iWebview.obtainFullUrl(), str17);
                        if (io.dcloud.common.util.FileUtil.checkPathAccord(iWebview.getContext(), strConvert2AbsFullPath4) || io.dcloud.common.util.FileUtil.isFilePathForPublic(iWebview.getContext(), strConvert2AbsFullPath4)) {
                            if (strConvert2AbsFullPath4.startsWith("apps/")) {
                                strConvert2AbsFullPath4 = "/" + strConvert2AbsFullPath4;
                            }
                            if (strConvert2AbsFullPath4.startsWith("/android_asset/")) {
                                strConvert2AbsFullPath4 = strConvert2AbsFullPath4.replace("/android_asset", "");
                            } else if (strConvert2AbsFullPath4.startsWith("android_asset/")) {
                                strConvert2AbsFullPath4 = strConvert2AbsFullPath4.replace("android_asset", "");
                            }
                            java.lang.String strCheckPrivateDirAndCopy2Temp = iAppObtainApp.checkPrivateDirAndCopy2Temp(strConvert2AbsFullPath4);
                            if (new java.io.File(strCheckPrivateDirAndCopy2Temp).exists()) {
                                a(strCheckPrivateDirAndCopy2Temp, iWebview, str16);
                            } else {
                                a(14, iWebview, str6);
                            }
                        } else {
                            a(15, iWebview, str6);
                        }
                    }
                }
                return null;
            case 8:
                java.lang.String[] strArrA7 = a(iWebview, strArr, str6);
                if (strArrA7 != null) {
                    java.lang.String str19 = strArrA7[0];
                    if (io.dcloud.common.util.FileUtil.checkPathAccord(iWebview.getContext(), str19) || io.dcloud.common.util.FileUtil.isFilePathForPublic(iWebview.getContext(), str19)) {
                        if (iAppObtainApp.checkPrivateDir(str19) && zIsOnAppRunningMode) {
                            jSONObjectA2 = null;
                            z = false;
                        } else {
                            try {
                                jSONObjectA2 = io.dcloud.js.file.a.a(str19, d(str19));
                                z = true;
                            } catch (java.lang.Exception e4) {
                                e4.printStackTrace();
                                jSONObjectA2 = null;
                                z = false;
                            }
                        }
                        if (z) {
                            io.dcloud.common.util.JSUtil.execCallback(iWebview, str6, jSONObjectA2, io.dcloud.common.util.JSUtil.OK, false);
                        } else {
                            a(10, iWebview, str6);
                        }
                    } else {
                        a(15, iWebview, str6);
                    }
                }
                return null;
            case 9:
                java.lang.String[] strArrA8 = a(iWebview, strArr, str6);
                if (strArrA8 != null) {
                    java.lang.String strConvert2AbsFullPath5 = iAppObtainApp.convert2AbsFullPath(strArrA8[0], strArrA8[1]);
                    if (io.dcloud.common.util.FileUtil.checkPathAccord(iWebview.getContext(), strConvert2AbsFullPath5)) {
                        java.io.File file4 = new java.io.File(strConvert2AbsFullPath5);
                        try {
                            org.json.JSONObject jSONObject2 = new org.json.JSONObject(strArrA8[2]);
                            java.lang.String str20 = strArrA8[1];
                            boolean zOptBoolean4 = jSONObject2.optBoolean("create");
                            boolean zOptBoolean5 = jSONObject2.optBoolean("exclusive");
                            if (file4.exists()) {
                                if (zOptBoolean4 && zOptBoolean5) {
                                    a(12, iWebview, str6);
                                    return null;
                                }
                                name = file4.getName();
                            } else {
                                if (!zOptBoolean4) {
                                    a(14, iWebview, str6);
                                    return null;
                                }
                                byte bCreateNewFile2 = io.dcloud.common.adapter.io.DHFile.createNewFile(file4);
                                name = file4.getName();
                                if (bCreateNewFile2 == -1 || (bCreateNewFile2 == -2 && zOptBoolean5)) {
                                    throw new java.lang.RuntimeException();
                                }
                            }
                            io.dcloud.common.util.JSUtil.execCallback(iWebview, str6, io.dcloud.js.file.a.a(name, strConvert2AbsFullPath5, iAppObtainApp.convert2RelPath(strConvert2AbsFullPath5), false), io.dcloud.common.util.JSUtil.OK, false);
                        } catch (java.lang.Exception unused3) {
                            a(10, iWebview, str6);
                        }
                    } else {
                        a(15, iWebview, str6);
                    }
                }
                return null;
            case 10:
                io.dcloud.common.DHInterface.IWebview iWebview3 = iWebview;
                try {
                    java.lang.String[] strArrA9 = a(iWebview3, strArr, str6);
                    if (strArrA9 != null) {
                        java.lang.String str21 = strArrA9[0];
                        if (io.dcloud.common.util.FileUtil.checkPathAccord(iWebview3.getContext(), str21)) {
                            boolean zCheckPrivateDir2 = iAppObtainApp.checkPrivateDir(str21);
                            int iIntValue = java.lang.Integer.valueOf(strArrA9[2]).intValue();
                            java.lang.String str22 = strArrA9[1];
                            if (str22 != null && !zCheckPrivateDir2) {
                                byte[] bytes = str22.getBytes();
                                io.dcloud.common.adapter.io.DHFile.writeFile(bytes, iIntValue, str21);
                                try {
                                    io.dcloud.common.util.JSUtil.execCallback(iWebview3, str6, bytes.length, io.dcloud.common.util.JSUtil.OK, false);
                                } catch (java.lang.Exception unused4) {
                                    str6 = str6;
                                    iWebview3 = iWebview3;
                                    a(10, iWebview3, str6);
                                }
                                break;
                            }
                            a(4, iWebview3, str6);
                            return null;
                        }
                        a(15, iWebview3, str6);
                    }
                } catch (java.lang.Exception unused5) {
                }
                return null;
            case 11:
            case 17:
                java.lang.String str23 = strArr[0];
                try {
                    strOptString3 = new org.json.JSONObject(strArr[1]).optString("filePath");
                    break;
                } catch (org.json.JSONException unused6) {
                }
                a(strOptString3, str23, iWebview, str);
                return null;
            case 12:
                return io.dcloud.common.util.Deprecated_JSUtil.wrapJsVar(iAppObtainApp.convert2RelPath(strArr[0]), true);
            case 13:
                java.lang.String[] strArrA10 = a(iWebview, strArr, str6);
                if (strArrA10 != null) {
                    java.lang.String str24 = strArrA10[0];
                    if (io.dcloud.common.util.FileUtil.checkPathAccord(iWebview.getContext(), str24)) {
                        boolean zCheckPrivateDir3 = iAppObtainApp.checkPrivateDir(str24);
                        int i4 = io.dcloud.common.util.PdrUtil.parseInt(strArrA10[1], 0);
                        int i5 = io.dcloud.common.util.PdrUtil.parseInt(strArrA10[2], -1);
                        if (zCheckPrivateDir3 && zIsOnAppRunningMode) {
                            a(10, iWebview, str6);
                        } else {
                            io.dcloud.common.adapter.util.AsyncTaskHandler.executeThreadTask(new io.dcloud.js.file.FileFeatureImpl.b(str24, i5, i4, iWebview, str6));
                        }
                    } else {
                        a(15, iWebview, str6);
                    }
                }
                return null;
            case 14:
                java.lang.String[] strArrA11 = a(iWebview, strArr, str6);
                if (strArrA11 != null) {
                    b(iWebview, strArrA11, str6);
                }
                return null;
            case 15:
                java.lang.String[] strArrA12 = a(iWebview, strArr, str6);
                if (strArrA12 != null) {
                    java.lang.String str25 = strArrA12[0];
                    if (io.dcloud.common.util.FileUtil.checkPathAccord(iWebview.getContext(), str25) || io.dcloud.common.util.FileUtil.isFilePathForPublic(iWebview.getContext(), str25)) {
                        if (str25 != null && e(str25)) {
                            a(4, iWebview, str6);
                            return null;
                        }
                        java.io.File file5 = new java.io.File(str25);
                        if (file5.exists()) {
                            java.lang.String parent = file5.getParent();
                            io.dcloud.common.util.JSUtil.execCallback(iWebview, str6, io.dcloud.js.file.a.a(file5.getParentFile().getName(), parent, iAppObtainApp.convert2RelPath(parent), true), io.dcloud.common.util.JSUtil.OK, false);
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (!z2) {
                            a(10, iWebview, str6);
                        }
                    } else {
                        a(15, iWebview, str6);
                    }
                }
                return null;
            case 16:
                java.lang.String[] strArrA13 = a(iWebview, strArr, str6);
                if (strArrA13 != null) {
                    a(iWebview, iAppObtainApp, strArrA13, str6);
                }
                return null;
            case 18:
                final java.lang.String str26 = strArr[0];
                try {
                    org.json.JSONObject jSONObject3 = new org.json.JSONObject(strArr[1]);
                    strOptString = jSONObject3.optString("filePath");
                    try {
                        strOptString2 = jSONObject3.optString("digestAlgorithm", io.dcloud.common.util.Md5Utils.ALGORITHM);
                        break;
                    } catch (org.json.JSONException unused7) {
                    }
                } catch (org.json.JSONException unused8) {
                    strOptString = "";
                }
                if (!io.dcloud.common.util.PdrUtil.isEmpty(strOptString) && !io.dcloud.common.util.PdrUtil.isNetPath(strOptString)) {
                    final java.lang.String strConvert2AbsFullPath6 = iWebview.obtainApp().convert2AbsFullPath(iWebview.obtainFullUrl(), strOptString);
                    try {
                        if (strConvert2AbsFullPath6.startsWith("content://")) {
                            try {
                                java.io.InputStream inputStreamOpenInputStream = iWebview.getActivity().getContentResolver().openInputStream(android.net.Uri.parse(strConvert2AbsFullPath6));
                                try {
                                    try {
                                        try {
                                            if (inputStreamOpenInputStream == null) {
                                                a(14, iWebview, str6);
                                                if (inputStreamOpenInputStream != null) {
                                                    inputStreamOpenInputStream.close();
                                                }
                                                break;
                                            } else {
                                                final int iAvailable = inputStreamOpenInputStream.available();
                                                try {
                                                    inputStreamOpenInputStream.close();
                                                    break;
                                                } catch (java.lang.Exception unused9) {
                                                }
                                                final java.lang.String str27 = strOptString2;
                                                try {
                                                    io.dcloud.common.util.ThreadPool.self().addThreadTask(new java.lang.Runnable() { // from class: io.dcloud.js.file.FileFeatureImpl$$ExternalSyntheticLambda2
                                                        @Override // java.lang.Runnable
                                                        public final void run() {
                                                            this.f$0.a(iWebview, strConvert2AbsFullPath6, str27, iAvailable, str26, str6);
                                                        }
                                                    });
                                                    inputStreamOpenInputStream.close();
                                                } catch (java.io.IOException e5) {
                                                    e = e5;
                                                    throw new java.lang.RuntimeException(e);
                                                } catch (java.lang.Throwable th2) {
                                                    th = th2;
                                                    th = th;
                                                    inputStream = inputStreamOpenInputStream;
                                                    if (inputStream == null) {
                                                        throw th;
                                                    }
                                                    try {
                                                        inputStream.close();
                                                        throw th;
                                                    } catch (java.io.IOException e6) {
                                                        e6.printStackTrace();
                                                        throw th;
                                                    }
                                                }
                                            }
                                        } catch (java.lang.Throwable th3) {
                                            th = th3;
                                        }
                                    } catch (java.io.IOException e7) {
                                        e7.printStackTrace();
                                    }
                                } catch (java.io.IOException e8) {
                                    e = e8;
                                }
                            } catch (java.io.IOException e9) {
                                e = e9;
                            }
                            break;
                        } else {
                            java.lang.String str28 = strOptString2;
                            if (io.dcloud.common.util.FileUtil.checkPathAccord(iWebview.getContext(), strOptString) || io.dcloud.common.util.FileUtil.isFilePathForPublic(iWebview.getContext(), strOptString)) {
                                if (strConvert2AbsFullPath6.startsWith("apps/")) {
                                    strConvert2AbsFullPath6 = "/" + strConvert2AbsFullPath6;
                                }
                                if (strConvert2AbsFullPath6.startsWith("/android_asset/")) {
                                    strConvert2AbsFullPath6 = strConvert2AbsFullPath6.replace("/android_asset", "");
                                } else if (strConvert2AbsFullPath6.startsWith("android_asset/")) {
                                    strConvert2AbsFullPath6 = strConvert2AbsFullPath6.replace("android_asset", "");
                                }
                                java.io.File file6 = new java.io.File(iAppObtainApp.checkPrivateDirAndCopy2Temp(strConvert2AbsFullPath6));
                                if (file6.exists()) {
                                    io.dcloud.common.util.ThreadPool.self().addThreadTask(new io.dcloud.js.file.FileFeatureImpl.d(file6, str28, iWebview, str26));
                                } else {
                                    io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview, str26, io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.DOMException.JSON_ERROR_INFO, -4, io.dcloud.common.constant.DOMException.MSG_FILE_NOT_EXIST), io.dcloud.common.util.JSUtil.ERROR, true, false);
                                }
                            } else {
                                a(15, iWebview, str6);
                            }
                        }
                    } catch (java.lang.Throwable th4) {
                        th = th4;
                    }
                }
                return null;
            case 19:
                java.lang.String[] strArrA14 = a(iWebview, strArr, str6);
                if (strArrA14 == null || io.dcloud.common.util.JSUtil.checkOperateDirErrorAndCallback(iWebview, str6, strArrA14[0])) {
                    return null;
                }
                java.lang.String str29 = strArrA14[0];
                if (io.dcloud.common.util.FileUtil.checkPathAccord(iWebview.getContext(), str29)) {
                    java.io.File file7 = new java.io.File(str29);
                    if (file7.isDirectory()) {
                        try {
                            java.lang.String strValueOf = java.lang.String.valueOf(java.lang.System.currentTimeMillis());
                            io.dcloud.common.adapter.io.DHFile.rename(file7.getAbsolutePath() + "/", strValueOf);
                            file7 = new java.io.File(file7.getParent() + "/" + strValueOf);
                        } catch (java.io.IOException e10) {
                            e10.printStackTrace();
                        }
                    }
                    if (io.dcloud.common.adapter.io.DHFile.delete(file7)) {
                        io.dcloud.common.util.JSUtil.execCallback(iWebview, str6, "", io.dcloud.common.util.JSUtil.OK, false);
                    } else {
                        a(10, iWebview, str6);
                    }
                } else {
                    a(15, iWebview, str6);
                }
                return null;
            case 20:
                try {
                    java.lang.String[] strArrA15 = a(iWebview, strArr, str6);
                    if (strArrA15 != null) {
                        boolean zE = e(strArrA15[0]);
                        boolean z4 = zE && iAppObtainApp.isOnAppRunningMode() && iAppObtainApp.checkPrivateDir(strArrA15[0]);
                        java.lang.String strConvert2AbsFullPath7 = iAppObtainApp.convert2AbsFullPath(iWebview.obtainFullUrl(), strArrA15[0]);
                        if (z4) {
                            org.json.JSONObject jSONObjectA4 = a(strConvert2AbsFullPath7);
                            io.dcloud.common.util.JSUtil.execCallback(iWebview, str6, io.dcloud.js.file.a.a(io.dcloud.common.util.BaseInfo.REL_PRIVATE_WWW_DIR, strConvert2AbsFullPath7, true, io.dcloud.common.util.BaseInfo.REL_PRIVATE_WWW_DIR, jSONObjectA4.optString("fsName"), jSONObjectA4.optInt("type"), jSONObjectA4.optJSONObject("fsRoot")), io.dcloud.common.util.JSUtil.OK, false);
                        } else {
                            java.io.File file8 = new java.io.File(strConvert2AbsFullPath7);
                            boolean zExists = file8.exists();
                            if (!zExists && zE) {
                                try {
                                    java.io.File parentFile2 = file8.getParentFile();
                                    if (!parentFile2.exists()) {
                                        parentFile2.mkdirs();
                                    }
                                    zExists = 1 == io.dcloud.common.adapter.io.DHFile.createNewFile(io.dcloud.common.adapter.io.DHFile.createFileHandler(strConvert2AbsFullPath7));
                                } catch (java.lang.Exception e11) {
                                    e11.printStackTrace();
                                }
                            }
                            if (zExists) {
                                org.json.JSONObject jSONObjectA5 = a(strConvert2AbsFullPath7);
                                io.dcloud.common.util.JSUtil.execCallback(iWebview, str6, io.dcloud.js.file.a.a(file8.getName(), strConvert2AbsFullPath7, file8.isDirectory(), strArrA15[0], jSONObjectA5.optString("fsName"), jSONObjectA5.optInt("type"), jSONObjectA5.optJSONObject("fsRoot")), io.dcloud.common.util.JSUtil.OK, false);
                            } else {
                                a(14, iWebview, str6);
                            }
                        }
                    }
                } catch (org.json.JSONException unused10) {
                    a(10, iWebview, str6);
                }
                return null;
            case 21:
                boolean z5 = true;
                java.lang.String[] strArrA16 = a(iWebview, strArr, str6);
                if (strArrA16 != null) {
                    java.lang.String str30 = strArrA16[0];
                    if (io.dcloud.common.util.FileUtil.checkPathAccord(iWebview.getContext(), str30) || io.dcloud.common.util.FileUtil.isFilePathForPublic(iWebview.getContext(), str30)) {
                        if (iAppObtainApp.checkPrivateDir(str30) && zIsOnAppRunningMode) {
                            jSONObjectA3 = null;
                            z5 = false;
                        } else {
                            try {
                                jSONObjectA3 = io.dcloud.js.file.a.a(str30, (strArrA16.length == 2 && (str4 = strArrA16[1]) != null && str4.equalsIgnoreCase(io.dcloud.common.constant.AbsoluteConst.TRUE)) ? java.lang.Boolean.parseBoolean(strArrA16[1]) : false);
                            } catch (java.lang.Exception e12) {
                                e12.printStackTrace();
                                jSONObjectA3 = null;
                                z5 = false;
                            }
                        }
                        if (z5) {
                            io.dcloud.common.util.JSUtil.execCallback(iWebview, str6, jSONObjectA3, io.dcloud.common.util.JSUtil.OK, false);
                        } else {
                            a(10, iWebview, str6);
                        }
                    } else {
                        a(15, iWebview, str6);
                    }
                    break;
                }
                return null;
            case 22:
                java.lang.String[] strArrA17 = a(iWebview, strArr, str6);
                if (strArrA17 != null) {
                    try {
                        java.lang.String str31 = strArrA17[0];
                        if (io.dcloud.common.util.FileUtil.checkPathAccord(iWebview.getContext(), str31)) {
                            java.io.File file9 = new java.io.File(str31);
                            fileInputStream = new java.io.FileInputStream(file9);
                            try {
                                java.io.File file10 = new java.io.File(file9.getParent() + "/" + (java.lang.System.currentTimeMillis() + file9.getName()));
                                fileOutputStream = new java.io.FileOutputStream(file10);
                                try {
                                    try {
                                        int i6 = java.lang.Integer.parseInt(strArrA17[1]);
                                        int i7 = java.lang.Integer.parseInt(strArrA17[2]);
                                        byte[] bArr = new byte[java.lang.Math.min(i7 + i6, 10240)];
                                        int i8 = 0;
                                        while (true) {
                                            int i9 = fileInputStream.read(bArr);
                                            if (i9 != -1) {
                                                c2 = 1;
                                                int iMin = java.lang.Math.min(i6 - i8, i9 - i7);
                                                if (iMin > 0) {
                                                    fileOutputStream.write(bArr, i7, iMin);
                                                    i8 += iMin;
                                                }
                                                if (i8 < i6) {
                                                    i7 = i7 > 0 ? i7 - i9 : 0;
                                                }
                                            } else {
                                                c2 = 1;
                                            }
                                        }
                                        file9.delete();
                                        file10.renameTo(file9);
                                        try {
                                            io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview, str6, strArrA17[c2], io.dcloud.common.util.JSUtil.OK, true, false);
                                        } catch (java.lang.Exception e13) {
                                            e = e13;
                                            iWebview2 = iWebview;
                                            str5 = str6;
                                            try {
                                                e.printStackTrace();
                                                a(10, iWebview2, str5);
                                            } catch (java.lang.Throwable th5) {
                                                th = th5;
                                                fileInputStream2 = fileInputStream;
                                                fileInputStream = fileInputStream2;
                                                fileOutputStream2 = fileOutputStream;
                                                io.dcloud.common.util.IOUtil.close(fileInputStream);
                                                io.dcloud.common.util.IOUtil.close(fileOutputStream2);
                                                throw th;
                                            }
                                        }
                                    } catch (java.lang.Throwable th6) {
                                        th = th6;
                                        fileOutputStream2 = fileOutputStream;
                                        io.dcloud.common.util.IOUtil.close(fileInputStream);
                                        io.dcloud.common.util.IOUtil.close(fileOutputStream2);
                                        throw th;
                                    }
                                } catch (java.lang.Exception e14) {
                                    e = e14;
                                    str5 = str6;
                                    iWebview2 = iWebview;
                                }
                            } catch (java.lang.Exception e15) {
                                e = e15;
                                str5 = str6;
                                iWebview2 = iWebview;
                                fileOutputStream = null;
                            } catch (java.lang.Throwable th7) {
                                th = th7;
                                io.dcloud.common.util.IOUtil.close(fileInputStream);
                                io.dcloud.common.util.IOUtil.close(fileOutputStream2);
                                throw th;
                            }
                            io.dcloud.common.util.IOUtil.close(fileInputStream);
                            io.dcloud.common.util.IOUtil.close(fileOutputStream);
                        } else {
                            a(15, iWebview, str6);
                            io.dcloud.common.util.IOUtil.close((java.io.InputStream) null);
                            io.dcloud.common.util.IOUtil.close((java.io.OutputStream) null);
                        }
                    } catch (java.lang.Exception e16) {
                        e = e16;
                        str5 = str6;
                        iWebview2 = iWebview;
                        fileInputStream = null;
                        fileOutputStream = null;
                    } catch (java.lang.Throwable th8) {
                        th = th8;
                        fileOutputStream = null;
                        fileInputStream = fileInputStream2;
                        fileOutputStream2 = fileOutputStream;
                        io.dcloud.common.util.IOUtil.close(fileInputStream);
                        io.dcloud.common.util.IOUtil.close(fileOutputStream2);
                        throw th;
                    }
                    break;
                }
                return null;
            case 23:
                java.lang.String[] strArrA18 = a(iWebview, strArr, str6);
                if (strArrA18 != null) {
                    java.lang.String str32 = strArrA18[0];
                    if (io.dcloud.common.util.FileUtil.checkPathAccord(iWebview.getContext(), str32) || io.dcloud.common.util.FileUtil.getPathForPublicType(str32) != null) {
                        if (iAppObtainApp.checkPrivateDir(str32) && zIsOnAppRunningMode) {
                            jSONArrayB = null;
                            z3 = false;
                        } else {
                            try {
                                jSONArrayB = io.dcloud.js.file.a.b(str32, iAppObtainApp.convert2RelPath(str32));
                            } catch (java.lang.Exception e17) {
                                e17.printStackTrace();
                                jSONArrayB = null;
                                z3 = false;
                            }
                        }
                        if (z3) {
                            io.dcloud.common.util.JSUtil.execCallback(iWebview, str6, jSONArrayB, io.dcloud.common.util.JSUtil.OK, false);
                        } else {
                            a(10, iWebview, str6);
                        }
                    } else {
                        a(15, iWebview, str6);
                    }
                    break;
                }
                return null;
            case 24:
                java.lang.String str33 = strArr[0];
                if (strArr.length <= 1 || !io.dcloud.common.util.PdrUtil.isEmpty(strArr[1])) {
                    zOptBoolean = false;
                } else {
                    try {
                        zOptBoolean = new org.json.JSONObject(strArr[1]).optBoolean("multiple", false);
                    } catch (java.lang.Exception e18) {
                        e18.printStackTrace();
                        zOptBoolean = false;
                    }
                }
                int requestCode = io.dcloud.common.adapter.util.PermissionUtil.getRequestCode();
                iAppObtainApp.registerSysEventListener(new io.dcloud.js.file.FileFeatureImpl.e(requestCode, iAppObtainApp, iWebview, str33), io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onActivityResult);
                android.content.Intent intent = new android.content.Intent("android.intent.action.GET_CONTENT");
                if (zOptBoolean) {
                    intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
                } else {
                    intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", false);
                }
                intent.setType("*/*");
                intent.addCategory("android.intent.category.OPENABLE");
                iWebview.getActivity().startActivityForResult(intent, requestCode);
                return null;
            default:
                return null;
        }
    }

    @Override // io.dcloud.common.DHInterface.IFeature
    public void init(io.dcloud.common.DHInterface.AbsMgr absMgr, java.lang.String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.String str2, int i, java.lang.String str3, java.lang.String str4) {
        io.dcloud.common.DHInterface.IWebview iWebview2;
        java.io.InputStream inputStreamOpenInputStream = null;
        try {
            try {
                inputStreamOpenInputStream = iWebview.getActivity().getContentResolver().openInputStream(android.net.Uri.parse(str));
                java.lang.String strMd5 = io.dcloud.common.util.Md5Utils.md5(inputStreamOpenInputStream, str2);
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                try {
                    jSONObject.put(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_SIZE, i);
                    if (strMd5 != null) {
                        jSONObject.put(com.taobao.weex.common.Constants.CodeCache.BANNER_DIGEST, strMd5.toUpperCase(java.util.Locale.US));
                    }
                } catch (org.json.JSONException unused) {
                }
                iWebview2 = iWebview;
                try {
                    io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview2, str3, jSONObject.toString(), io.dcloud.common.util.JSUtil.OK, true, false);
                } catch (java.io.FileNotFoundException unused2) {
                    a(15, iWebview2, str4);
                }
            } catch (java.io.FileNotFoundException unused3) {
                iWebview2 = iWebview;
            }
        } finally {
            if (inputStreamOpenInputStream != null) {
                try {
                    inputStreamOpenInputStream.close();
                } catch (java.io.IOException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    private void a(io.dcloud.common.DHInterface.IWebview iWebview, io.dcloud.common.DHInterface.IApp iApp, java.lang.String[] strArr, java.lang.String str) {
        java.lang.String str2 = strArr[0];
        if (!io.dcloud.common.util.FileUtil.checkPathAccord(iWebview.getContext(), str2)) {
            a(15, iWebview, str);
            return;
        }
        boolean zCheckPrivateDir = iApp.checkPrivateDir(str2);
        int i = io.dcloud.common.util.PdrUtil.parseInt(strArr[1], 0);
        int i2 = io.dcloud.common.util.PdrUtil.parseInt(strArr[2], -1);
        if (zCheckPrivateDir && iApp.isOnAppRunningMode()) {
            a(10, iWebview, str);
        } else {
            io.dcloud.common.adapter.util.AsyncTaskHandler.executeThreadTask(new io.dcloud.js.file.FileFeatureImpl.g(str2, i2, i, iWebview, str));
        }
    }

    /* JADX WARN: Code duplicated, block: B:107:0x0248  */
    /* JADX WARN: Code duplicated, block: B:54:0x015b A[Catch: Exception -> 0x0165, TRY_LEAVE, TryCatch #7 {Exception -> 0x0165, blocks: (B:52:0x014f, B:54:0x015b), top: B:146:0x014f }] */
    private void a(java.lang.String str, java.lang.String str2, io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str3) {
        float f2;
        int i;
        java.lang.String str4;
        if (io.dcloud.common.util.PdrUtil.isEmpty(str) || io.dcloud.common.util.PdrUtil.isNetPath(str)) {
            return;
        }
        java.lang.String strConvert2AbsFullPath = iWebview.obtainApp().convert2AbsFullPath(iWebview.obtainFullUrl(), str);
        if (strConvert2AbsFullPath.startsWith("apps/")) {
            strConvert2AbsFullPath = "/" + strConvert2AbsFullPath;
        }
        if (strConvert2AbsFullPath.startsWith("/android_asset/")) {
            strConvert2AbsFullPath = strConvert2AbsFullPath.replace("/android_asset", "");
        } else if (strConvert2AbsFullPath.startsWith("android_asset/")) {
            strConvert2AbsFullPath = strConvert2AbsFullPath.replace("android_asset", "");
        }
        java.lang.String strCheckPrivateDirAndCopy2Temp = iWebview.obtainApp().checkPrivateDirAndCopy2Temp(strConvert2AbsFullPath);
        if (!strCheckPrivateDirAndCopy2Temp.startsWith("content://")) {
            if (!io.dcloud.common.util.FileUtil.checkPathAccord(iWebview.getContext(), strCheckPrivateDirAndCopy2Temp) && !io.dcloud.common.util.FileUtil.isFilePathForPublic(iWebview.getContext(), strCheckPrivateDirAndCopy2Temp)) {
                a(15, iWebview, str2);
                return;
            } else if (!new java.io.File(strCheckPrivateDirAndCopy2Temp).exists()) {
                io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview, str2, io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.DOMException.JSON_ERROR_INFO, -4, io.dcloud.common.constant.DOMException.MSG_FILE_NOT_EXIST), io.dcloud.common.util.JSUtil.ERROR, true, false);
                return;
            }
        }
        try {
            android.media.MediaMetadataRetriever mediaMetadataRetriever = new android.media.MediaMetadataRetriever();
            if (io.dcloud.common.util.FileUtil.checkPrivatePath(iWebview.getContext(), strCheckPrivateDirAndCopy2Temp)) {
                mediaMetadataRetriever.setDataSource(strCheckPrivateDirAndCopy2Temp);
            } else if (strCheckPrivateDirAndCopy2Temp.startsWith("content://")) {
                mediaMetadataRetriever.setDataSource(iWebview.getContext(), android.net.Uri.parse(strCheckPrivateDirAndCopy2Temp));
            } else {
                android.net.Uri videoFileUri = io.dcloud.common.util.FileUtil.getVideoFileUri(iWebview.getContext(), strCheckPrivateDirAndCopy2Temp);
                if (videoFileUri != null) {
                    mediaMetadataRetriever.setDataSource(iWebview.getContext(), videoFileUri);
                }
            }
            java.lang.String strExtractMetadata = mediaMetadataRetriever.extractMetadata(9);
            java.lang.String strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(18);
            java.lang.String strExtractMetadata3 = mediaMetadataRetriever.extractMetadata(19);
            java.lang.String strExtractMetadata4 = mediaMetadataRetriever.extractMetadata(24);
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            if (str3.equals("getVideoInfo")) {
                if ("90".equals(strExtractMetadata4) || "270".equals(strExtractMetadata4)) {
                    strExtractMetadata3 = strExtractMetadata2;
                    strExtractMetadata2 = strExtractMetadata3;
                }
                if (strExtractMetadata2 == null || strExtractMetadata3 == null) {
                    f2 = 1000.0f;
                } else {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append(strExtractMetadata2);
                    f2 = 1000.0f;
                    sb.append("*");
                    sb.append(strExtractMetadata3);
                    jSONObject.put("resolution", sb.toString());
                }
                if (strExtractMetadata2 != null) {
                    try {
                        jSONObject.put("width", java.lang.Float.parseFloat(strExtractMetadata2));
                        if (strExtractMetadata3 != null) {
                            jSONObject.put("height", java.lang.Float.parseFloat(strExtractMetadata3));
                        }
                    } catch (java.lang.Exception unused) {
                    }
                } else if (strExtractMetadata3 != null) {
                    jSONObject.put("height", java.lang.Float.parseFloat(strExtractMetadata3));
                }
                if (strCheckPrivateDirAndCopy2Temp.startsWith("content://")) {
                    java.io.InputStream inputStreamOpenInputStream = iWebview.getContext().getContentResolver().openInputStream(android.net.Uri.parse(strCheckPrivateDirAndCopy2Temp));
                    if (inputStreamOpenInputStream != null) {
                        try {
                            try {
                                jSONObject.put(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_SIZE, inputStreamOpenInputStream.available());
                            } catch (java.io.IOException unused2) {
                                jSONObject.put(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_SIZE, 0);
                            }
                            try {
                                inputStreamOpenInputStream.close();
                            } catch (java.io.IOException unused3) {
                            }
                            i = 0;
                        } catch (java.lang.Throwable th) {
                            try {
                                inputStreamOpenInputStream.close();
                            } catch (java.io.IOException unused4) {
                            }
                            throw th;
                        }
                    } else {
                        i = 0;
                        jSONObject.put(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_SIZE, 0);
                    }
                } else {
                    i = 0;
                    jSONObject.put(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_SIZE, new java.io.File(strCheckPrivateDirAndCopy2Temp).length());
                }
                java.lang.String strExtractMetadata5 = mediaMetadataRetriever.extractMetadata(32);
                if (android.text.TextUtils.isEmpty(strExtractMetadata5)) {
                    android.media.MediaExtractor mediaExtractor = new android.media.MediaExtractor();
                    if (io.dcloud.common.util.FileUtil.checkPrivatePath(iWebview.getContext(), strCheckPrivateDirAndCopy2Temp)) {
                        mediaExtractor.setDataSource(strCheckPrivateDirAndCopy2Temp);
                    } else {
                        android.net.Uri videoFileUri2 = io.dcloud.common.util.FileUtil.getVideoFileUri(iWebview.getContext(), strCheckPrivateDirAndCopy2Temp);
                        if (videoFileUri2 != null) {
                            mediaExtractor.setDataSource(iWebview.getContext(), videoFileUri2, (java.util.Map<java.lang.String, java.lang.String>) null);
                        }
                    }
                    int trackCount = mediaExtractor.getTrackCount();
                    while (i < trackCount) {
                        android.media.MediaFormat trackFormat = mediaExtractor.getTrackFormat(i);
                        try {
                            java.lang.String string = trackFormat.getString(tv.danmaku.ijk.media.player.misc.IMediaFormat.KEY_MIME);
                            if (!android.text.TextUtils.isEmpty(string) && string.startsWith("video/")) {
                                jSONObject.put("fps", trackFormat.getInteger("frame-rate"));
                            }
                        } catch (java.lang.Exception unused5) {
                        }
                        i++;
                    }
                } else {
                    try {
                        jSONObject.put("fps", java.lang.Math.ceil((java.lang.Float.parseFloat(strExtractMetadata5) / java.lang.Float.parseFloat(strExtractMetadata)) * f2));
                    } catch (java.lang.Exception unused6) {
                    }
                }
                int iHashCode = strExtractMetadata4.hashCode();
                if (iHashCode != 1815) {
                    if (iHashCode != 48873) {
                        if (iHashCode == 49803 && strExtractMetadata4.equals("270")) {
                            str4 = "left";
                        } else {
                            str4 = "up";
                        }
                    } else if (strExtractMetadata4.equals("180")) {
                        str4 = "down";
                    } else {
                        str4 = "up";
                    }
                } else if (strExtractMetadata4.equals("90")) {
                    str4 = "right";
                } else {
                    str4 = "up";
                }
                jSONObject.put("orientation", str4);
                java.lang.String strExtractMetadata6 = mediaMetadataRetriever.extractMetadata(12);
                if (!android.text.TextUtils.isEmpty(strExtractMetadata6)) {
                    jSONObject.put("type", strExtractMetadata6);
                }
                java.lang.String strExtractMetadata7 = mediaMetadataRetriever.extractMetadata(20);
                if (!android.text.TextUtils.isEmpty(strExtractMetadata7)) {
                    try {
                        jSONObject.put(tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_BITRATE, java.lang.Integer.valueOf(java.lang.Integer.parseInt(strExtractMetadata7) / 1000));
                    } catch (java.lang.Exception unused7) {
                    }
                }
            } else {
                f2 = 1000.0f;
            }
            try {
                jSONObject.put("duration", java.math.BigDecimal.valueOf(java.lang.Float.parseFloat(strExtractMetadata) / f2).setScale(2, 4));
            } catch (java.lang.Exception unused8) {
            }
            io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview, str2, jSONObject.toString(), io.dcloud.common.util.JSUtil.OK, true, false);
        } catch (java.lang.Exception e2) {
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            try {
                jSONObject2.put("code", 13);
                jSONObject2.put("message", e2.getMessage());
            } catch (org.json.JSONException unused9) {
            }
            io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview, str2, jSONObject2.toString(), io.dcloud.common.util.JSUtil.ERROR, true, false);
        }
    }

    public static java.lang.String b(java.lang.String str) {
        java.lang.String fileExtensionFromUrl = android.webkit.MimeTypeMap.getFileExtensionFromUrl(str);
        if (fileExtensionFromUrl != null) {
            return android.webkit.MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl);
        }
        return null;
    }

    private org.json.JSONObject a(java.lang.String str) throws org.json.JSONException {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        if (str.startsWith(a)) {
            jSONObject.put("type", 1);
            jSONObject.put("fsName", "PRIVATE_WWW");
            jSONObject.put("fsRoot", io.dcloud.js.file.a.a("PRIVATE_WWW", a, c(str), true));
            return jSONObject;
        }
        if (str.startsWith(c)) {
            jSONObject.put("type", 2);
            jSONObject.put("fsName", "PRIVATE_DOCUMENTS");
            jSONObject.put("fsRoot", io.dcloud.js.file.a.a("PRIVATE_DOCUMENTS", c, c(str), true));
            return jSONObject;
        }
        if (str.startsWith(d)) {
            jSONObject.put("type", 3);
            jSONObject.put("fsName", "PUBLIC_DOCUMENTS");
            jSONObject.put("fsRoot", io.dcloud.js.file.a.a("PUBLIC_DOCUMENTS", d, c(str), true));
            return jSONObject;
        }
        if (str.startsWith(e)) {
            jSONObject.put("type", 4);
            jSONObject.put("fsName", "PUBLIC_DOWNLOADS");
            jSONObject.put("fsRoot", io.dcloud.js.file.a.a("PUBLIC_DOWNLOADS", e, c(str), true));
            return jSONObject;
        }
        if (str.startsWith(b)) {
            jSONObject.put("type", 1);
            jSONObject.put("fsName", "PRIVATE_WWW");
            jSONObject.put("fsRoot", io.dcloud.js.file.a.a("PRIVATE_WWW", b, c(str), true));
            return jSONObject;
        }
        if (io.dcloud.common.util.PdrUtil.isDeviceRootDir(str)) {
            jSONObject.put("type", 5);
            jSONObject.put("fsName", "PUBLIC_DEVICE_ROOT");
            jSONObject.put("fsRoot", io.dcloud.js.file.a.a("PUBLIC_DEVICE_ROOT", io.dcloud.common.adapter.util.DeviceInfo.sDeviceRootDir, c(str), true));
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str) {
        io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview, str, a(iWebview.getContext(), i), io.dcloud.common.util.JSUtil.ERROR, true, false);
    }

    private java.lang.String a(android.content.Context context, int i) {
        switch (i) {
            case 1:
                return io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.DOMException.JSON_ERROR_INFO, java.lang.Integer.valueOf(i), context.getString(io.dcloud.base.R.string.dcloud_io_file_not_found));
            case 2:
                return io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.DOMException.JSON_ERROR_INFO, java.lang.Integer.valueOf(i), context.getString(io.dcloud.base.R.string.dcloud_io_without_authorization));
            case 3:
                return io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.DOMException.JSON_ERROR_INFO, java.lang.Integer.valueOf(i), context.getString(io.dcloud.base.R.string.dcloud_common_cancel));
            case 4:
                return io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.DOMException.JSON_ERROR_INFO, java.lang.Integer.valueOf(i), context.getString(io.dcloud.base.R.string.dcloud_io_file_not_read));
            case 5:
                return io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.DOMException.JSON_ERROR_INFO, java.lang.Integer.valueOf(i), context.getString(io.dcloud.base.R.string.dcloud_io_coding_error));
            case 6:
                return io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.DOMException.JSON_ERROR_INFO, java.lang.Integer.valueOf(i), context.getString(io.dcloud.base.R.string.dcloud_io_no_modification_allowed));
            case 7:
                return io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.DOMException.JSON_ERROR_INFO, java.lang.Integer.valueOf(i), context.getString(io.dcloud.base.R.string.dcloud_io_invalid_state));
            case 8:
                return io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.DOMException.JSON_ERROR_INFO, java.lang.Integer.valueOf(i), context.getString(io.dcloud.base.R.string.dcloud_io_grammar_mistakes));
            case 9:
                return io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.DOMException.JSON_ERROR_INFO, java.lang.Integer.valueOf(i), context.getString(io.dcloud.base.R.string.dcloud_io_invalid_modification));
            case 10:
                return io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.DOMException.JSON_ERROR_INFO, java.lang.Integer.valueOf(i), context.getString(io.dcloud.base.R.string.dcloud_io_perform_error));
            case 11:
                return io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.DOMException.JSON_ERROR_INFO, java.lang.Integer.valueOf(i), context.getString(io.dcloud.base.R.string.dcloud_io_type_mismatch));
            case 12:
                return io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.DOMException.JSON_ERROR_INFO, java.lang.Integer.valueOf(i), context.getString(io.dcloud.base.R.string.dcloud_io_path_exists));
            case 13:
            default:
                return io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.DOMException.JSON_ERROR_INFO, java.lang.Integer.valueOf(i), context.getString(io.dcloud.base.R.string.dcloud_io_unknown_error));
            case 14:
                return io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.DOMException.JSON_ERROR_INFO, java.lang.Integer.valueOf(i), context.getString(io.dcloud.base.R.string.dcloud_io_path_not_exist));
            case 15:
                return io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.DOMException.JSON_ERROR_INFO, java.lang.Integer.valueOf(i), io.dcloud.common.constant.DOMException.MSG_PATH_NOT_PRIVATE_ERROR);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:16:0x0049 A[Catch: IOException -> 0x0116, JSONException -> 0x011a, TRY_ENTER, TryCatch #3 {IOException -> 0x0116, blocks: (B:4:0x000d, B:17:0x0055, B:22:0x006f, B:53:0x00d5, B:57:0x0109, B:56:0x0103, B:16:0x0049), top: B:76:0x000d }] */
    /* JADX WARN: Code duplicated, block: B:51:0x00d2  */
    public void a(java.lang.String str, io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str2) {
        java.lang.String str3;
        org.json.JSONException jSONException;
        java.lang.String attribute;
        java.lang.String str4;
        java.lang.String str5;
        try {
            try {
                try {
                    android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    java.lang.String str6 = null;
                    if (!io.dcloud.common.util.FileUtil.checkPrivatePath(iWebview.getContext(), str)) {
                        try {
                            if (android.os.Build.VERSION.SDK_INT >= 24) {
                                java.io.InputStream fileInputStream = io.dcloud.common.util.FileUtil.getFileInputStream(iWebview.getContext(), str);
                                if (fileInputStream != null) {
                                    android.graphics.BitmapFactory.decodeStream(fileInputStream, null, options);
                                    io.dcloud.p.g4$$ExternalSyntheticApiModelOutline0.m$4();
                                    attribute = io.dcloud.p.g4$$ExternalSyntheticApiModelOutline0.m(fileInputStream).getAttribute("Orientation");
                                    fileInputStream.close();
                                } else {
                                    attribute = null;
                                }
                            } else {
                                attribute = new android.media.ExifInterface(str).getAttribute("Orientation");
                                android.graphics.BitmapFactory.decodeFile(str, options);
                            }
                        } catch (org.json.JSONException e2) {
                            jSONException = e2;
                            str3 = str2;
                            io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview, str3, io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.DOMException.JSON_ERROR_INFO, 13, jSONException.getMessage()), io.dcloud.common.util.JSUtil.ERROR, true, false);
                        }
                    } else {
                        attribute = new android.media.ExifInterface(str).getAttribute("Orientation");
                        android.graphics.BitmapFactory.decodeFile(str, options);
                    }
                    int i = options.outWidth;
                    int i2 = options.outHeight;
                    java.lang.String lowerCase = options.outMimeType;
                    if (!io.dcloud.common.util.PdrUtil.isEmpty(lowerCase) && lowerCase.contains("/")) {
                        java.lang.String[] strArrSplit = lowerCase.split("/");
                        lowerCase = strArrSplit[strArrSplit.length - 1];
                    }
                    if (!android.text.TextUtils.isEmpty(attribute)) {
                        switch (attribute.hashCode()) {
                            case 48:
                                str4 = com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT;
                                attribute.equals(str4);
                                str5 = "up";
                                break;
                            case 49:
                                str4 = "1";
                                attribute.equals(str4);
                                str5 = "up";
                                break;
                            case 50:
                                if (attribute.equals("2")) {
                                    str5 = "up-mirrored";
                                } else {
                                    str5 = "up";
                                }
                                break;
                            case 51:
                                if (attribute.equals("3")) {
                                    str5 = "down";
                                } else {
                                    str5 = "up";
                                }
                                break;
                            case 52:
                                if (attribute.equals("4")) {
                                    str5 = "down-mirrored";
                                } else {
                                    str5 = "up";
                                }
                                break;
                            case 53:
                                if (attribute.equals("5")) {
                                    str5 = "left-mirrored";
                                } else {
                                    str5 = "up";
                                }
                                break;
                            case 54:
                                if (attribute.equals("6")) {
                                    str5 = "right";
                                } else {
                                    str5 = "up";
                                }
                                break;
                            case com.alibaba.fastjson.asm.Opcodes.LSTORE /* 55 */:
                                if (attribute.equals("7")) {
                                    str5 = "right-mirrored";
                                } else {
                                    str5 = "up";
                                }
                                break;
                            case 56:
                                if (attribute.equals("8")) {
                                    str5 = "left";
                                } else {
                                    str5 = "up";
                                }
                                break;
                            default:
                                str5 = "up";
                                break;
                        }
                        str6 = str5;
                    }
                    org.json.JSONObject jSONObject = new org.json.JSONObject();
                    jSONObject.put(io.dcloud.common.constant.AbsoluteConst.XML_PATH, io.dcloud.common.adapter.util.DeviceInfo.FILE_PROTOCOL + str);
                    jSONObject.put("width", i);
                    jSONObject.put("height", i2);
                    jSONObject.put("orientation", str6);
                    if (!io.dcloud.common.util.PdrUtil.isEmpty(lowerCase)) {
                        lowerCase = lowerCase.toLowerCase(java.util.Locale.ENGLISH);
                    }
                    jSONObject.put("type", lowerCase);
                    str3 = str2;
                    try {
                        io.dcloud.common.util.JSUtil.execCallback(iWebview, str3, jSONObject, io.dcloud.common.util.JSUtil.OK, false);
                    } catch (org.json.JSONException e3) {
                        e = e3;
                        jSONException = e;
                        io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview, str3, io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.DOMException.JSON_ERROR_INFO, 13, jSONException.getMessage()), io.dcloud.common.util.JSUtil.ERROR, true, false);
                    }
                } catch (java.io.IOException e4) {
                    e = e4;
                    io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview, str2, io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.DOMException.JSON_ERROR_INFO, 13, e.getMessage()), io.dcloud.common.util.JSUtil.ERROR, true, false);
                }
            } catch (java.io.IOException e5) {
                e = e5;
            }
        } catch (org.json.JSONException e6) {
            e = e6;
            str3 = str2;
        }
    }

    private java.lang.String[] a(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String[] strArr, java.lang.String str) {
        if (strArr.length > 1 && !io.dcloud.common.util.PdrUtil.isEmpty(strArr[1])) {
            try {
                return io.dcloud.common.util.JSUtil.jsonArrayToStringArr(new org.json.JSONArray(strArr[1]));
            } catch (org.json.JSONException e2) {
                e2.printStackTrace();
                a(8, iWebview, str);
            }
        }
        return null;
    }
}
