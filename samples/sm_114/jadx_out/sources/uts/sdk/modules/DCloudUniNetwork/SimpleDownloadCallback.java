package uts.sdk.modules.DCloudUniNetwork;

/* JADX INFO: compiled from: index.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0005H\u0016J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0005H\u0016J\u0018\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0013H\u0016J+\u0010\u001c\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0002\u0010 R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Luts/sdk/modules/DCloudUniNetwork/SimpleDownloadCallback;", "Lokhttp3/Callback;", "listener", "Luts/sdk/modules/DCloudUniNetwork/NetworkDownloadFileListener;", "specifyPath", "", "<init>", "(Luts/sdk/modules/DCloudUniNetwork/NetworkDownloadFileListener;Ljava/lang/String;)V", "downloadFilePath", "onFailure", "", androidx.core.app.NotificationCompat.CATEGORY_CALL, "Lokhttp3/Call;", "exception", "Ljava/io/IOException;", "onResponse", "response", "Lokhttp3/Response;", "getTempFile", "Ljava/io/File;", "getRealPath", "getFile", "isAbsolute", "", io.dcloud.common.constant.AbsoluteConst.XML_PATH, "isDescendant", "parent", "child", "stringSplit", "", "str", "delim", "(Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;", "uni-network_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class SimpleDownloadCallback implements okhttp3.Callback {
    private java.lang.String downloadFilePath;
    private uts.sdk.modules.DCloudUniNetwork.NetworkDownloadFileListener listener;
    private java.lang.String specifyPath;

    public SimpleDownloadCallback(uts.sdk.modules.DCloudUniNetwork.NetworkDownloadFileListener listener, java.lang.String specifyPath) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(listener, "listener");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(specifyPath, "specifyPath");
        this.downloadFilePath = "/uni-download/";
        this.specifyPath = "";
        this.listener = listener;
        if (kotlin.text.StringsKt.startsWith$default(specifyPath, "unifile://", false, 2, (java.lang.Object) null)) {
            this.specifyPath = io.dcloud.uts.UTSAndroid.INSTANCE.convert2AbsFullPath(specifyPath);
        } else {
            this.specifyPath = specifyPath;
        }
    }

    @Override // okhttp3.Callback
    public void onFailure(okhttp3.Call call, java.io.IOException exception) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(call, "call");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(exception, "exception");
        io.dcloud.uts.UTSJSONObject uTSJSONObject_uO = io.dcloud.uts.UTSJSONObjectKt._uO(new kotlin.Pair[0]);
        uTSJSONObject_uO.set("statusCode", "-1");
        uTSJSONObject_uO.set("errorCode", "-1");
        uTSJSONObject_uO.set("errorMsg", exception.getMessage());
        uTSJSONObject_uO.set("cause", new io.dcloud.uniapp.SourceError(io.dcloud.uts.NumberKt.toString_number_nullable$default(exception.getCause(), (java.lang.Number) null, 1, (java.lang.Object) null)));
        uts.sdk.modules.DCloudUniNetwork.NetworkDownloadFileListener networkDownloadFileListener = this.listener;
        if (networkDownloadFileListener != null) {
            networkDownloadFileListener.onComplete(uTSJSONObject_uO);
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x006d  */
    /* JADX WARN: Code duplicated, block: B:71:0x014e  */
    /* JADX WARN: Code duplicated, block: B:72:0x014f  */
    /* JADX WARN: Code duplicated, block: B:75:0x015a A[Catch: all -> 0x0173, TRY_LEAVE, TryCatch #2 {all -> 0x0173, blocks: (B:69:0x0135, B:73:0x0150, B:75:0x015a), top: B:104:0x0135 }] */
    /* JADX WARN: Code duplicated, block: B:77:0x0161  */
    /* JADX WARN: Code duplicated, block: B:79:0x0166  */
    /* JADX WARN: Code duplicated, block: B:81:0x016b  */
    /* JADX WARN: Code duplicated, block: B:85:0x0176  */
    /* JADX WARN: Code duplicated, block: B:87:0x017b  */
    /* JADX WARN: Code duplicated, block: B:89:0x0180  */
    @Override // okhttp3.Callback
    public void onResponse(okhttp3.Call call, okhttp3.Response response) throws java.lang.Throwable {
        okio.BufferedSource bufferedSource;
        okio.BufferedSource bufferedSourceBuffer;
        okio.BufferedSink bufferedSink;
        okio.BufferedSink bufferedSinkBuffer;
        io.dcloud.uts.UTSJSONObject uTSJSONObject_uO;
        java.lang.String message;
        uts.sdk.modules.DCloudUniNetwork.NetworkDownloadFileListener networkDownloadFileListener;
        okhttp3.Response response2 = response;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(call, "call");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(response2, "response");
        java.lang.String str = "";
        if (!response2.isSuccessful()) {
            io.dcloud.uts.UTSJSONObject uTSJSONObject_uO2 = io.dcloud.uts.UTSJSONObjectKt._uO(new kotlin.Pair[0]);
            java.lang.String strPlus = io.dcloud.uts.NumberKt.plus(java.lang.Integer.valueOf(response.code()), "");
            okhttp3.ResponseBody responseBodyBody = response.body();
            java.lang.String strString = responseBodyBody != null ? responseBodyBody.string() : null;
            uTSJSONObject_uO2.set("statusCode", strPlus);
            uTSJSONObject_uO2.set("errorCode", strPlus);
            uTSJSONObject_uO2.set("errorMsg", strString);
            io.dcloud.uniapp.SourceError sourceError = new io.dcloud.uniapp.SourceError(strString != null ? strString : "");
            sourceError.setCode(java.lang.Integer.valueOf(response.code()));
            uTSJSONObject_uO2.set("cause", sourceError);
            uts.sdk.modules.DCloudUniNetwork.NetworkDownloadFileListener networkDownloadFileListener2 = this.listener;
            if (networkDownloadFileListener2 != null) {
                networkDownloadFileListener2.onComplete(uTSJSONObject_uO2);
                return;
            }
            return;
        }
        okhttp3.ResponseBody responseBodyBody2 = response2.body();
        okio.BufferedSource bufferedSourceSource = responseBodyBody2 != null ? responseBodyBody2.source() : null;
        if (bufferedSourceSource != null) {
            java.io.File tempFile = getTempFile();
            try {
                okio.BufferedSink bufferedSinkBuffer2 = okio.Okio.buffer(okio.Okio.sink(tempFile));
                try {
                    okhttp3.ResponseBody responseBodyBody3 = response2.body();
                    kotlin.jvm.internal.Intrinsics.checkNotNull(responseBodyBody3);
                    kotlin.jvm.internal.Intrinsics.checkNotNull(responseBodyBody3);
                    long jContentLength = responseBodyBody3.contentLength();
                    byte[] bArr = new byte[8192];
                    long j = 0;
                    try {
                        while (true) {
                            int i = bufferedSourceSource.read(bArr);
                            if (i == -1) {
                                break;
                            }
                            bufferedSinkBuffer2.write(bArr, 0, i);
                            long j2 = ((long) i) + j;
                            bufferedSource = bufferedSourceSource;
                            try {
                                uts.sdk.modules.DCloudUniNetwork.OnProgressDownloadResult onProgressDownloadResult = new uts.sdk.modules.DCloudUniNetwork.OnProgressDownloadResult(java.lang.Float.valueOf((j2 / jContentLength) * 100), java.lang.Long.valueOf(j2), java.lang.Long.valueOf(jContentLength));
                                uts.sdk.modules.DCloudUniNetwork.NetworkDownloadFileListener networkDownloadFileListener3 = this.listener;
                                if (networkDownloadFileListener3 != null) {
                                    networkDownloadFileListener3.onProgress(onProgressDownloadResult);
                                }
                                response2 = response;
                                bufferedSourceSource = bufferedSource;
                                j = j2;
                            } catch (java.lang.Exception e) {
                                e = e;
                            } catch (java.lang.Throwable th) {
                                th = th;
                                bufferedSink = bufferedSinkBuffer2;
                                bufferedSourceBuffer = null;
                                bufferedSinkBuffer = null;
                                if (bufferedSink != null) {
                                    bufferedSink.close();
                                }
                                if (bufferedSinkBuffer != null) {
                                    bufferedSinkBuffer.close();
                                }
                                if (bufferedSourceBuffer != null) {
                                    bufferedSourceBuffer.close();
                                }
                                bufferedSource.close();
                                tempFile.delete();
                                throw th;
                            }
                            bufferedSink = bufferedSinkBuffer2;
                            bufferedSourceBuffer = null;
                            bufferedSinkBuffer = null;
                            try {
                                uTSJSONObject_uO = io.dcloud.uts.UTSJSONObjectKt._uO(new kotlin.Pair[0]);
                                message = e.getMessage();
                                uTSJSONObject_uO.set("statusCode", "-1");
                                uTSJSONObject_uO.set("errorCode", "-1");
                                uTSJSONObject_uO.set("errorMsg", message);
                                if (message == null) {
                                    str = message;
                                }
                                uTSJSONObject_uO.set("cause", new io.dcloud.uniapp.SourceError(str));
                                networkDownloadFileListener = this.listener;
                                if (networkDownloadFileListener != null) {
                                    networkDownloadFileListener.onComplete(uTSJSONObject_uO);
                                    kotlin.Unit unit = kotlin.Unit.INSTANCE;
                                }
                                if (bufferedSink != null) {
                                    bufferedSink.close();
                                }
                                if (bufferedSinkBuffer != null) {
                                    bufferedSinkBuffer.close();
                                }
                                if (bufferedSourceBuffer != null) {
                                    bufferedSourceBuffer.close();
                                }
                                bufferedSource.close();
                                tempFile.delete();
                            } catch (java.lang.Throwable th2) {
                                th = th2;
                                if (bufferedSink != null) {
                                    bufferedSink.close();
                                }
                                if (bufferedSinkBuffer != null) {
                                    bufferedSinkBuffer.close();
                                }
                                if (bufferedSourceBuffer != null) {
                                    bufferedSourceBuffer.close();
                                }
                                bufferedSource.close();
                                tempFile.delete();
                                throw th;
                            }
                        }
                        java.io.File file = getFile(response2);
                        if (file == null) {
                            if (bufferedSinkBuffer2 != null) {
                                bufferedSinkBuffer2.close();
                            }
                            if (bufferedSourceBuffer != null) {
                                bufferedSourceBuffer.close();
                            }
                        } else {
                            bufferedSinkBuffer = okio.Okio.buffer(okio.Okio.sink(file));
                            try {
                                bufferedSinkBuffer.writeAll(bufferedSourceBuffer);
                                bufferedSinkBuffer.flush();
                                io.dcloud.uts.UTSJSONObject uTSJSONObject_uO3 = io.dcloud.uts.UTSJSONObjectKt._uO(new kotlin.Pair[0]);
                                uTSJSONObject_uO3.set("statusCode", io.dcloud.uts.NumberKt.plus(java.lang.Integer.valueOf(response2.code()), ""));
                                if (file.exists()) {
                                    uTSJSONObject_uO3.set("tempFilePath", file.getPath());
                                }
                                uts.sdk.modules.DCloudUniNetwork.NetworkDownloadFileListener networkDownloadFileListener4 = this.listener;
                                if (networkDownloadFileListener4 != null) {
                                    networkDownloadFileListener4.onComplete(uTSJSONObject_uO3);
                                    kotlin.Unit unit2 = kotlin.Unit.INSTANCE;
                                }
                                if (bufferedSinkBuffer2 != null) {
                                    bufferedSinkBuffer2.close();
                                }
                                if (bufferedSinkBuffer != null) {
                                    bufferedSinkBuffer.close();
                                }
                                if (bufferedSourceBuffer != null) {
                                    bufferedSourceBuffer.close();
                                }
                            } catch (java.lang.Exception e2) {
                                e = e2;
                                bufferedSource = bufferedSourceSource;
                                bufferedSink = bufferedSinkBuffer2;
                                uTSJSONObject_uO = io.dcloud.uts.UTSJSONObjectKt._uO(new kotlin.Pair[0]);
                                message = e.getMessage();
                                uTSJSONObject_uO.set("statusCode", "-1");
                                uTSJSONObject_uO.set("errorCode", "-1");
                                uTSJSONObject_uO.set("errorMsg", message);
                                if (message == null) {
                                    str = message;
                                }
                                uTSJSONObject_uO.set("cause", new io.dcloud.uniapp.SourceError(str));
                                networkDownloadFileListener = this.listener;
                                if (networkDownloadFileListener != null) {
                                    networkDownloadFileListener.onComplete(uTSJSONObject_uO);
                                    kotlin.Unit unit3 = kotlin.Unit.INSTANCE;
                                }
                                if (bufferedSink != null) {
                                    bufferedSink.close();
                                }
                                if (bufferedSinkBuffer != null) {
                                    bufferedSinkBuffer.close();
                                }
                                if (bufferedSourceBuffer != null) {
                                    bufferedSourceBuffer.close();
                                }
                                bufferedSource.close();
                            } catch (java.lang.Throwable th3) {
                                th = th3;
                                bufferedSource = bufferedSourceSource;
                                bufferedSink = bufferedSinkBuffer2;
                                if (bufferedSink != null) {
                                    bufferedSink.close();
                                }
                                if (bufferedSinkBuffer != null) {
                                    bufferedSinkBuffer.close();
                                }
                                if (bufferedSourceBuffer != null) {
                                    bufferedSourceBuffer.close();
                                }
                                bufferedSource.close();
                                tempFile.delete();
                                throw th;
                            }
                        }
                        bufferedSourceSource.close();
                    } catch (java.lang.Exception e3) {
                        e = e3;
                        bufferedSource = bufferedSourceSource;
                        bufferedSink = bufferedSinkBuffer2;
                        bufferedSinkBuffer = null;
                    } catch (java.lang.Throwable th4) {
                        th = th4;
                        bufferedSource = bufferedSourceSource;
                        bufferedSink = bufferedSinkBuffer2;
                        bufferedSinkBuffer = null;
                        if (bufferedSink != null) {
                            bufferedSink.close();
                        }
                        if (bufferedSinkBuffer != null) {
                            bufferedSinkBuffer.close();
                        }
                        if (bufferedSourceBuffer != null) {
                            bufferedSourceBuffer.close();
                        }
                        bufferedSource.close();
                        tempFile.delete();
                        throw th;
                    }
                    bufferedSinkBuffer2.flush();
                    bufferedSourceBuffer = okio.Okio.buffer(okio.Okio.source(tempFile));
                } catch (java.lang.Exception e4) {
                    e = e4;
                    bufferedSource = bufferedSourceSource;
                } catch (java.lang.Throwable th5) {
                    th = th5;
                    bufferedSource = bufferedSourceSource;
                }
            } catch (java.lang.Exception e5) {
                e = e5;
                bufferedSource = bufferedSourceSource;
                bufferedSourceBuffer = null;
                bufferedSink = null;
            } catch (java.lang.Throwable th6) {
                th = th6;
                bufferedSource = bufferedSourceSource;
                bufferedSourceBuffer = null;
                bufferedSink = null;
            }
            tempFile.delete();
        }
    }

    public java.io.File getTempFile() {
        android.content.Context appContext = io.dcloud.uts.UTSAndroid.INSTANCE.getAppContext();
        kotlin.jvm.internal.Intrinsics.checkNotNull(appContext);
        return new java.io.File(appContext.getExternalCacheDir(), "temp_" + java.lang.System.currentTimeMillis());
    }

    public java.lang.String getRealPath() {
        java.lang.String appTempPath = io.dcloud.uts.UTSAndroid.INSTANCE.getAppTempPath();
        if (appTempPath == null) {
            appTempPath = "";
        }
        return appTempPath + this.downloadFilePath;
    }

    public java.io.File getFile(okhttp3.Response response) throws java.io.UnsupportedEncodingException {
        java.lang.String realPath;
        java.lang.Integer num;
        java.lang.String str;
        java.lang.String str2;
        java.lang.String str3;
        java.lang.String strValueOf;
        java.lang.String strSubstring;
        java.lang.String[] strArrStringSplit;
        java.lang.Integer num2;
        java.lang.String[] strArr;
        java.lang.String str4;
        java.lang.String str5;
        int i;
        java.lang.String[] strArrStringSplit2;
        java.lang.String string;
        java.lang.String strSubstring$default;
        java.lang.String strSubstring2;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(response, "response");
        java.lang.String str6 = "";
        java.lang.Integer num3 = 10;
        java.lang.String str7 = "cause";
        java.lang.String str8 = "errorMsg";
        if (!kotlin.jvm.internal.Intrinsics.areEqual(this.specifyPath, "")) {
            if (isDescendant(new java.io.File(io.dcloud.uts.UTSAndroid.INSTANCE.convert2AbsFullPath("/")), new java.io.File(this.specifyPath))) {
                io.dcloud.uts.UTSJSONObject uTSJSONObject_uO = io.dcloud.uts.UTSJSONObjectKt._uO(new kotlin.Pair[0]);
                uTSJSONObject_uO.set("statusCode", "-1");
                uTSJSONObject_uO.set("errorCode", "602001");
                uTSJSONObject_uO.set("errorMsg", "This path is not supported");
                uTSJSONObject_uO.set("cause", null);
                uts.sdk.modules.DCloudUniNetwork.NetworkDownloadFileListener networkDownloadFileListener = this.listener;
                if (networkDownloadFileListener != null) {
                    networkDownloadFileListener.onComplete(uTSJSONObject_uO);
                }
                return null;
            }
            if (io.dcloud.uts.NumberKt.numberEquals(io.dcloud.uts.StringKt.lastIndexOf$default(this.specifyPath, "/", null, 2, null), java.lang.Integer.valueOf(this.specifyPath.length() - 1))) {
                if (isAbsolute(this.specifyPath)) {
                    realPath = this.specifyPath;
                } else {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    java.lang.String appTempPath = io.dcloud.uts.UTSAndroid.INSTANCE.getAppTempPath();
                    kotlin.jvm.internal.Intrinsics.checkNotNull(appTempPath);
                    kotlin.jvm.internal.Intrinsics.checkNotNull(appTempPath);
                    sb.append(appTempPath);
                    sb.append('/');
                    sb.append(this.specifyPath);
                    realPath = sb.toString();
                }
            } else {
                if (isAbsolute(this.specifyPath)) {
                    string = this.specifyPath;
                } else {
                    java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                    java.lang.String appTempPath2 = io.dcloud.uts.UTSAndroid.INSTANCE.getAppTempPath();
                    kotlin.jvm.internal.Intrinsics.checkNotNull(appTempPath2);
                    kotlin.jvm.internal.Intrinsics.checkNotNull(appTempPath2);
                    sb2.append(appTempPath2);
                    sb2.append('/');
                    sb2.append(this.specifyPath);
                    string = sb2.toString();
                }
                java.io.File file = new java.io.File(string);
                java.io.File parentFile = file.getParentFile();
                if (parentFile != null && !parentFile.exists()) {
                    parentFile.mkdirs();
                }
                if (file.exists() && file.isDirectory()) {
                    io.dcloud.uts.UTSJSONObject uTSJSONObject_uO2 = io.dcloud.uts.UTSJSONObjectKt._uO(new kotlin.Pair[0]);
                    uTSJSONObject_uO2.set("statusCode", "-1");
                    uTSJSONObject_uO2.set("errorCode", "602001");
                    uTSJSONObject_uO2.set("errorMsg", "The target file path is already a directory file, and file creation failed.");
                    uTSJSONObject_uO2.set("cause", null);
                    uts.sdk.modules.DCloudUniNetwork.NetworkDownloadFileListener networkDownloadFileListener2 = this.listener;
                    if (networkDownloadFileListener2 != null) {
                        networkDownloadFileListener2.onComplete(uTSJSONObject_uO2);
                    }
                    return null;
                }
                if (file.exists()) {
                    java.lang.Number numberLastIndexOf$default = io.dcloud.uts.StringKt.lastIndexOf$default(string, com.taobao.weex.el.parse.Operators.DOT_STR, null, 2, null);
                    if (io.dcloud.uts.NumberKt.compareTo(numberLastIndexOf$default, (java.lang.Number) 0) >= 0) {
                        strSubstring2 = io.dcloud.uts.StringKt.substring(string, (java.lang.Number) 0, numberLastIndexOf$default);
                        strSubstring$default = io.dcloud.uts.StringKt.substring$default(string, numberLastIndexOf$default, null, 2, null);
                    } else {
                        strSubstring$default = "";
                        strSubstring2 = string;
                    }
                    java.lang.Number numberInc = (java.lang.Number) 1;
                    while (new java.io.File(string).exists()) {
                        string = strSubstring2 + com.taobao.weex.el.parse.Operators.BRACKET_START + io.dcloud.uts.NumberKt.toString(numberInc, (java.lang.Number) num3) + com.taobao.weex.el.parse.Operators.BRACKET_END + strSubstring$default;
                        numberInc = io.dcloud.uts.NumberKt.inc(numberInc);
                    }
                    file = new java.io.File(string);
                }
                if (file.exists()) {
                    return file;
                }
                try {
                    file.createNewFile();
                    return file;
                } catch (java.lang.Exception e) {
                    io.dcloud.uts.UTSJSONObject uTSJSONObject_uO3 = io.dcloud.uts.UTSJSONObjectKt._uO(new kotlin.Pair[0]);
                    uTSJSONObject_uO3.set("statusCode", "-1");
                    uTSJSONObject_uO3.set("errorCode", "602001");
                    uTSJSONObject_uO3.set("errorMsg", e.getMessage());
                    uTSJSONObject_uO3.set("cause", new io.dcloud.uniapp.SourceError(io.dcloud.uts.NumberKt.toString_number_nullable$default(e.getCause(), (java.lang.Number) null, 1, (java.lang.Object) null)));
                    uts.sdk.modules.DCloudUniNetwork.NetworkDownloadFileListener networkDownloadFileListener3 = this.listener;
                    if (networkDownloadFileListener3 != null) {
                        networkDownloadFileListener3.onComplete(uTSJSONObject_uO3);
                    }
                    return null;
                }
            }
        } else {
            realPath = getRealPath();
        }
        java.lang.String strHeader = response.header("content-disposition");
        if (android.text.TextUtils.isEmpty(strHeader) || (strArrStringSplit = stringSplit(strHeader, ";")) == null) {
            num = num3;
            str = "cause";
            str2 = "errorMsg";
            str3 = "";
        } else {
            str3 = "";
            int i2 = 0;
            while (i2 < strArrStringSplit.length) {
                java.lang.String str9 = strArrStringSplit[i2];
                if (str9 != null) {
                    java.lang.String str10 = str9;
                    num2 = num3;
                    strArr = strArrStringSplit;
                    str4 = str7;
                    str5 = str8;
                    i = i2;
                    if (kotlin.text.StringsKt.contains$default((java.lang.CharSequence) str10, (java.lang.CharSequence) io.dcloud.common.constant.AbsoluteConst.JSON_KEY_FILENAME, false, 2, (java.lang.Object) null) && (strArrStringSplit2 = stringSplit(kotlin.text.StringsKt.trim((java.lang.CharSequence) str10).toString(), "=")) != null && strArrStringSplit2.length > 1) {
                        java.lang.String strReplace = strArrStringSplit2[0];
                        java.lang.String strReplace2 = strArrStringSplit2[1];
                        io.dcloud.uts.UTSRegExp uTSRegExp = new io.dcloud.uts.UTSRegExp("^\"|\"$", "g");
                        if (strReplace != null) {
                            strReplace = io.dcloud.uts.StringKt.replace(strReplace, uTSRegExp, "");
                        }
                        if (strReplace2 != null) {
                            strReplace2 = io.dcloud.uts.StringKt.replace(strReplace2, uTSRegExp, "");
                        }
                        if (!android.text.TextUtils.isEmpty(strReplace) && !android.text.TextUtils.isEmpty(strReplace2)) {
                            kotlin.jvm.internal.Intrinsics.checkNotNull(strReplace);
                            if (kotlin.text.StringsKt.equals(strReplace, io.dcloud.common.constant.AbsoluteConst.JSON_KEY_FILENAME, true) && strReplace2 != null) {
                                str3 = strReplace2;
                            }
                        }
                    }
                } else {
                    num2 = num3;
                    strArr = strArrStringSplit;
                    str4 = str7;
                    str5 = str8;
                    i = i2;
                }
                i2 = i + 1;
                num3 = num2;
                strArrStringSplit = strArr;
                str7 = str4;
                str8 = str5;
            }
            num = num3;
            str = str7;
            str2 = str8;
        }
        if (android.text.TextUtils.isEmpty(str3)) {
            java.lang.String strEncodedPath = response.request().url().encodedPath();
            kotlin.jvm.internal.Intrinsics.checkNotNull(strEncodedPath);
            java.lang.Number numberLastIndexOf$default2 = io.dcloud.uts.StringKt.lastIndexOf$default(strEncodedPath, "/", null, 2, null);
            if (io.dcloud.uts.NumberKt.compareTo(numberLastIndexOf$default2, (java.lang.Number) 0) >= 0) {
                kotlin.jvm.internal.Intrinsics.checkNotNull(strEncodedPath);
                java.lang.String strSubstring$default2 = io.dcloud.uts.StringKt.substring$default(strEncodedPath, io.dcloud.uts.NumberKt.plus(numberLastIndexOf$default2, (java.lang.Number) 1), null, 2, null);
                if (io.dcloud.uts.NumberKt.compareTo(io.dcloud.uts.StringKt.indexOf$default(strSubstring$default2, com.taobao.weex.el.parse.Operators.DOT_STR, null, 2, null), (java.lang.Number) 0) >= 0 || strSubstring$default2.length() > 0) {
                    if (kotlin.text.StringsKt.contains$default((java.lang.CharSequence) strSubstring$default2, (java.lang.CharSequence) com.taobao.weex.el.parse.Operators.CONDITION_IF_STRING, false, 2, (java.lang.Object) null)) {
                        strSubstring$default2 = io.dcloud.uts.StringKt.substring(strSubstring$default2, (java.lang.Number) 0, io.dcloud.uts.StringKt.indexOf$default(strSubstring$default2, com.taobao.weex.el.parse.Operators.CONDITION_IF_STRING, null, 2, null));
                    }
                    str3 = strSubstring$default2;
                }
            }
        }
        if (android.text.TextUtils.isEmpty(str3)) {
            strValueOf = java.lang.String.valueOf(java.lang.System.currentTimeMillis());
            java.lang.String extensionFromMimeType = android.webkit.MimeTypeMap.getSingleton().getExtensionFromMimeType(response.header("content-type"));
            if (extensionFromMimeType != null) {
                str3 = strValueOf + com.taobao.weex.el.parse.Operators.DOT + extensionFromMimeType;
                strValueOf = str3;
            }
        } else {
            strValueOf = str3;
        }
        java.lang.String strDecode = java.net.URLDecoder.decode(strValueOf, "UTF-8");
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strDecode, "decode(...)");
        java.lang.String separator = java.io.File.separator;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(separator, "separator");
        java.lang.String strReplace3 = new kotlin.text.Regex(separator).replace(strDecode, "");
        java.lang.String str11 = strReplace3;
        if (kotlin.text.StringsKt.contains$default((java.lang.CharSequence) str11, (java.lang.CharSequence) com.taobao.weex.el.parse.Operators.CONDITION_IF_STRING, false, 2, (java.lang.Object) null)) {
            strReplace3 = new kotlin.text.Regex("\\?").replace(str11, com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT);
        }
        if (strReplace3.length() > 80) {
            strReplace3 = io.dcloud.uts.StringKt.substring(strReplace3, (java.lang.Number) 0, (java.lang.Number) 80) + java.lang.System.currentTimeMillis();
        }
        if (new java.io.File(realPath + strReplace3).exists()) {
            java.lang.Number numberLastIndexOf$default3 = io.dcloud.uts.StringKt.lastIndexOf$default(strReplace3, com.taobao.weex.el.parse.Operators.DOT_STR, null, 2, null);
            if (io.dcloud.uts.NumberKt.compareTo(numberLastIndexOf$default3, (java.lang.Number) 0) >= 0) {
                strSubstring = io.dcloud.uts.StringKt.substring(strReplace3, (java.lang.Number) 0, numberLastIndexOf$default3);
                java.lang.String strSubstring$default3 = io.dcloud.uts.StringKt.substring$default(strReplace3, numberLastIndexOf$default3, null, 2, null);
                if (kotlin.jvm.internal.Intrinsics.areEqual(strSubstring, "")) {
                    strSubstring = strSubstring$default3;
                } else {
                    str6 = strSubstring$default3;
                }
            } else {
                strSubstring = strReplace3;
            }
            java.lang.Number numberInc2 = (java.lang.Number) 1;
            while (true) {
                if (!new java.io.File(realPath + strReplace3).exists()) {
                    break;
                }
                strReplace3 = strSubstring + com.taobao.weex.el.parse.Operators.BRACKET_START + io.dcloud.uts.NumberKt.toString(numberInc2, (java.lang.Number) num) + com.taobao.weex.el.parse.Operators.BRACKET_END + str6;
                numberInc2 = io.dcloud.uts.NumberKt.inc(numberInc2);
            }
        }
        java.io.File file2 = new java.io.File(realPath + strReplace3);
        java.io.File parentFile2 = file2.getParentFile();
        if (parentFile2 != null && !parentFile2.exists()) {
            parentFile2.mkdirs();
        }
        if (file2.exists()) {
            return file2;
        }
        try {
            file2.createNewFile();
            return file2;
        } catch (java.lang.Exception e2) {
            io.dcloud.uts.UTSJSONObject uTSJSONObject_uO4 = io.dcloud.uts.UTSJSONObjectKt._uO(new kotlin.Pair[0]);
            uTSJSONObject_uO4.set("statusCode", "-1");
            uTSJSONObject_uO4.set("errorCode", "602001");
            uTSJSONObject_uO4.set(str2, e2.getMessage());
            uTSJSONObject_uO4.set(str, new io.dcloud.uniapp.SourceError(io.dcloud.uts.NumberKt.toString_number_nullable$default(e2.getCause(), (java.lang.Number) null, 1, (java.lang.Object) null)));
            uts.sdk.modules.DCloudUniNetwork.NetworkDownloadFileListener networkDownloadFileListener4 = this.listener;
            if (networkDownloadFileListener4 != null) {
                networkDownloadFileListener4.onComplete(uTSJSONObject_uO4);
            }
            return null;
        }
    }

    public boolean isAbsolute(java.lang.String path) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(path, "path");
        android.content.Context appContext = io.dcloud.uts.UTSAndroid.INSTANCE.getAppContext();
        kotlin.jvm.internal.Intrinsics.checkNotNull(appContext);
        kotlin.jvm.internal.Intrinsics.checkNotNull(appContext);
        java.io.File file = new java.io.File(path);
        if (!file.isAbsolute()) {
            return false;
        }
        java.io.File parentFile = appContext.getFilesDir().getParentFile();
        if (parentFile != null && isDescendant(parentFile, file)) {
            return true;
        }
        java.io.File externalFilesDir = appContext.getExternalFilesDir(null);
        java.io.File parentFile2 = externalFilesDir != null ? externalFilesDir.getParentFile() : null;
        return parentFile2 != null && isDescendant(parentFile2, file);
    }

    public boolean isDescendant(java.io.File parent, java.io.File child) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(parent, "parent");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(child, "child");
        if (kotlin.jvm.internal.Intrinsics.areEqual(child.getCanonicalPath(), parent.getCanonicalPath())) {
            return true;
        }
        java.io.File parentFile = child.getParentFile();
        if (parentFile == null) {
            return false;
        }
        return isDescendant(parent, parentFile);
    }

    public java.lang.String[] stringSplit(java.lang.String str, java.lang.String delim) {
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(delim)) {
            return null;
        }
        int i = 0;
        java.util.StringTokenizer stringTokenizer = new java.util.StringTokenizer(str, delim, false);
        java.lang.String[] strArr = new java.lang.String[stringTokenizer.countTokens()];
        while (stringTokenizer.hasMoreElements()) {
            java.lang.String strNextToken = stringTokenizer.nextToken();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strNextToken, "nextToken(...)");
            strArr[i] = kotlin.text.StringsKt.trim((java.lang.CharSequence) strNextToken).toString();
            i++;
        }
        return strArr;
    }
}
