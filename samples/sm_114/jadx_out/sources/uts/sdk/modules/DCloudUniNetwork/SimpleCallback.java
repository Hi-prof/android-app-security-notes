package uts.sdk.modules.DCloudUniNetwork;

/* JADX INFO: compiled from: index.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B-\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J\u0018\u0010#\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010$\u001a\u00020%H\u0016J\u001e\u0010&\u001a\u0004\u0018\u00010'2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0002J\u001e\u0010*\u001a\u0004\u0018\u00010+2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0002J&\u0010,\u001a\u0004\u0018\u00010'2\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010-\u001a\u0004\u0018\u00010)2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0002J&\u0010.\u001a\u0004\u0018\u00010'2\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010-\u001a\u0004\u0018\u00010)2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0002J\u0018\u0010/\u001a\u00020\u00072\u0006\u00100\u001a\u00020'2\u0006\u00101\u001a\u00020'H\u0002J\u0010\u00102\u001a\u0002032\u0006\u00104\u001a\u00020'H\u0002J\u0010\u00105\u001a\u00020\u00072\u0006\u00104\u001a\u00020'H\u0002J\u0010\u00106\u001a\u00020\u00072\u0006\u00104\u001a\u00020'H\u0002J\u0010\u00107\u001a\u00020\u00072\u0006\u00104\u001a\u00020'H\u0002J\u0018\u00108\u001a\u00020\u001e2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u00109\u001a\u00020'H\u0002J \u0010:\u001a\u00020\u001e2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010;\u001a\u00020'2\u0006\u0010<\u001a\u00020'H\u0002J\u001e\u0010=\u001a\u00020\u001e2\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010>\u001a\b\u0012\u0004\u0012\u00020'0?H\u0002J\u001e\u0010@\u001a\u00020\u001e2\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010>\u001a\b\u0012\u0004\u0012\u00020'0?H\u0002R+\u0010\u0002\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00038B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R+\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00058B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R+\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00078B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u001c\u0010\u0012\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006A"}, d2 = {"Luts/sdk/modules/DCloudUniNetwork/SimpleCallback;", "Lokhttp3/Callback;", "listener", "Luts/sdk/modules/DCloudUniNetwork/NetworkRequestListener;", "requestTask", "Luts/sdk/modules/DCloudUniNetwork/NetworkRequestTaskImpl;", "enableChunked", "", "looper", "Landroid/os/Looper;", "<init>", "(Luts/sdk/modules/DCloudUniNetwork/NetworkRequestListener;Luts/sdk/modules/DCloudUniNetwork/NetworkRequestTaskImpl;ZLandroid/os/Looper;)V", "<set-?>", "getListener", "()Luts/sdk/modules/DCloudUniNetwork/NetworkRequestListener;", "setListener", "(Luts/sdk/modules/DCloudUniNetwork/NetworkRequestListener;)V", "listener$delegate", "Lkotlin/properties/ReadWriteProperty;", "getRequestTask", "()Luts/sdk/modules/DCloudUniNetwork/NetworkRequestTaskImpl;", "setRequestTask", "(Luts/sdk/modules/DCloudUniNetwork/NetworkRequestTaskImpl;)V", "requestTask$delegate", "getEnableChunked", "()Z", "setEnableChunked", "(Z)V", "enableChunked$delegate", "onResponse", "", androidx.core.app.NotificationCompat.CATEGORY_CALL, "Lokhttp3/Call;", "response", "Lokhttp3/Response;", "onFailure", "e", "Ljava/io/IOException;", "readInputStreamAsBytes", "", "inputSteam", "Ljava/io/InputStream;", "readInputStream", "", "processStreamWithOkio", "inputStream", "processChunkedResponse", "isValidChunk", "sizeLine", "dataLine", "parseHexSize", "", "lineData", "isHexadecimalLine", "isZeroChunk", "isEmptyLine", "sendData", "data", "sendCombinedData", "data1", "data2", "processPendingLines", "pendingLines", "Lio/dcloud/uts/UTSArray;", "processLinePair", "uni-network_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class SimpleCallback implements okhttp3.Callback {
    static final /* synthetic */ kotlin.reflect.KProperty<java.lang.Object>[] $$delegatedProperties = {kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(uts.sdk.modules.DCloudUniNetwork.SimpleCallback.class, "listener", "getListener()Luts/sdk/modules/DCloudUniNetwork/NetworkRequestListener;", 0)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(uts.sdk.modules.DCloudUniNetwork.SimpleCallback.class, "requestTask", "getRequestTask()Luts/sdk/modules/DCloudUniNetwork/NetworkRequestTaskImpl;", 0)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(uts.sdk.modules.DCloudUniNetwork.SimpleCallback.class, "enableChunked", "getEnableChunked()Z", 0))};

    /* JADX INFO: renamed from: enableChunked$delegate, reason: from kotlin metadata */
    private final kotlin.properties.ReadWriteProperty enableChunked;

    /* JADX INFO: renamed from: listener$delegate, reason: from kotlin metadata */
    private final kotlin.properties.ReadWriteProperty listener;
    private android.os.Looper looper;

    /* JADX INFO: renamed from: requestTask$delegate, reason: from kotlin metadata */
    private final kotlin.properties.ReadWriteProperty requestTask;

    private final uts.sdk.modules.DCloudUniNetwork.NetworkRequestListener getListener() {
        return (uts.sdk.modules.DCloudUniNetwork.NetworkRequestListener) this.listener.getValue(this, $$delegatedProperties[0]);
    }

    private final void setListener(uts.sdk.modules.DCloudUniNetwork.NetworkRequestListener networkRequestListener) {
        this.listener.setValue(this, $$delegatedProperties[0], networkRequestListener);
    }

    private final uts.sdk.modules.DCloudUniNetwork.NetworkRequestTaskImpl getRequestTask() {
        return (uts.sdk.modules.DCloudUniNetwork.NetworkRequestTaskImpl) this.requestTask.getValue(this, $$delegatedProperties[1]);
    }

    private final void setRequestTask(uts.sdk.modules.DCloudUniNetwork.NetworkRequestTaskImpl networkRequestTaskImpl) {
        this.requestTask.setValue(this, $$delegatedProperties[1], networkRequestTaskImpl);
    }

    private final boolean getEnableChunked() {
        return ((java.lang.Boolean) this.enableChunked.getValue(this, $$delegatedProperties[2])).booleanValue();
    }

    private final void setEnableChunked(boolean z) {
        this.enableChunked.setValue(this, $$delegatedProperties[2], java.lang.Boolean.valueOf(z));
    }

    public SimpleCallback(uts.sdk.modules.DCloudUniNetwork.NetworkRequestListener listener, uts.sdk.modules.DCloudUniNetwork.NetworkRequestTaskImpl requestTask, boolean z, android.os.Looper looper) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(listener, "listener");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(requestTask, "requestTask");
        this.listener = kotlin.properties.Delegates.INSTANCE.notNull();
        this.requestTask = kotlin.properties.Delegates.INSTANCE.notNull();
        this.enableChunked = kotlin.properties.Delegates.INSTANCE.notNull();
        setListener(listener);
        setRequestTask(requestTask);
        setEnableChunked(z);
        this.looper = looper;
    }

    public /* synthetic */ SimpleCallback(uts.sdk.modules.DCloudUniNetwork.NetworkRequestListener networkRequestListener, uts.sdk.modules.DCloudUniNetwork.NetworkRequestTaskImpl networkRequestTaskImpl, boolean z, android.os.Looper looper, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(networkRequestListener, networkRequestTaskImpl, z, (i & 8) != 0 ? null : looper);
    }

    @Override // okhttp3.Callback
    public void onResponse(okhttp3.Call call, okhttp3.Response response) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(call, "call");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(response, "response");
        okhttp3.Headers headers = response.headers();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(headers, "headers(...)");
        java.util.Map<java.lang.String, java.util.List<java.lang.String>> multimap = headers.toMultimap();
        final kotlin.jvm.internal.Ref.IntRef intRef = new kotlin.jvm.internal.Ref.IntRef();
        intRef.element = response.code();
        boolean z = false;
        io.dcloud.uts.UTSJSONObject uTSJSONObject_uO = io.dcloud.uts.UTSJSONObjectKt._uO(new kotlin.Pair[0]);
        uTSJSONObject_uO.set("statusCode", io.dcloud.uts.NumberKt.plus(java.lang.Integer.valueOf(intRef.element), ""));
        uts.sdk.modules.DCloudUniNetwork.NetworkRequestListener listener = getListener();
        if (listener != null) {
            java.lang.Integer numValueOf = java.lang.Integer.valueOf(intRef.element);
            kotlin.jvm.internal.Intrinsics.checkNotNull(multimap);
            listener.onHeadersReceived(numValueOf, multimap);
        }
        io.dcloud.uts.Map<java.lang.Number, kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniNetwork.RequestTaskOnHeadersReceivedListenerResult, kotlin.Unit>> headersReceivedListeners = getRequestTask().getHeadersReceivedListeners();
        if (headersReceivedListeners.size() > 0) {
            uts.sdk.modules.DCloudUniNetwork.NetworkUtil.Companion companion = uts.sdk.modules.DCloudUniNetwork.NetworkUtil.INSTANCE;
            kotlin.jvm.internal.Intrinsics.checkNotNull(multimap);
            final io.dcloud.uts.UTSJSONObject uTSJSONObjectConvertHeaders = companion.convertHeaders(multimap);
            headersReceivedListeners.forEach(new kotlin.jvm.functions.Function2() { // from class: uts.sdk.modules.DCloudUniNetwork.SimpleCallback$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final java.lang.Object invoke(java.lang.Object obj, java.lang.Object obj2) {
                    return uts.sdk.modules.DCloudUniNetwork.SimpleCallback.onResponse$lambda$0(uTSJSONObjectConvertHeaders, intRef, (kotlin.jvm.functions.Function1) obj, (java.lang.Number) obj2);
                }
            });
        }
        okhttp3.ResponseBody responseBodyBody = response.body();
        kotlin.jvm.internal.Intrinsics.checkNotNull(responseBodyBody);
        java.io.InputStream inputStreamByteStream = responseBodyBody.byteStream();
        kotlin.jvm.internal.Intrinsics.checkNotNull(inputStreamByteStream);
        if (getEnableChunked() && kotlin.jvm.internal.Intrinsics.areEqual(response.header("Transfer-Encoding"), "chunked")) {
            z = true;
        }
        try {
            if (!response.isSuccessful()) {
                uTSJSONObject_uO.set("errorMsg", readInputStream(inputStreamByteStream, getListener()));
            } else if (z) {
                uTSJSONObject_uO.set("originalData", processStreamWithOkio(getRequestTask(), inputStreamByteStream, getListener()));
            } else {
                uTSJSONObject_uO.set("originalData", readInputStreamAsBytes(inputStreamByteStream, getListener()));
            }
            if (listener != null) {
                listener.onComplete(uTSJSONObject_uO);
            }
        } finally {
            try {
                inputStreamByteStream.close();
            } catch (java.lang.Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit onResponse$lambda$0(io.dcloud.uts.UTSJSONObject uTSJSONObject, kotlin.jvm.internal.Ref.IntRef intRef, kotlin.jvm.functions.Function1<? super uts.sdk.modules.DCloudUniNetwork.RequestTaskOnHeadersReceivedListenerResult, kotlin.Unit> function1, java.lang.Number number) {
        function1.invoke2(new uts.sdk.modules.DCloudUniNetwork.RequestTaskOnHeadersReceivedListenerResult(uts.sdk.modules.DCloudUniNetwork.NetworkUtil.INSTANCE.parseCookie(uTSJSONObject), uTSJSONObject, java.lang.Integer.valueOf(intRef.element)));
        return kotlin.Unit.INSTANCE;
    }

    @Override // okhttp3.Callback
    public void onFailure(okhttp3.Call call, java.io.IOException e) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(call, "call");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(e, "e");
        uts.sdk.modules.DCloudUniNetwork.NetworkRequestListener listener = getListener();
        io.dcloud.uts.UTSJSONObject uTSJSONObject_uO = io.dcloud.uts.UTSJSONObjectKt._uO(new kotlin.Pair[0]);
        uTSJSONObject_uO.set("statusCode", "-1");
        uTSJSONObject_uO.set("errorCode", "602001");
        uTSJSONObject_uO.set("errorMsg", e.getMessage());
        uTSJSONObject_uO.set("cause", e);
        if (listener != null) {
            listener.onComplete(uTSJSONObject_uO);
        }
    }

    private final byte[] readInputStreamAsBytes(java.io.InputStream inputSteam, uts.sdk.modules.DCloudUniNetwork.NetworkRequestListener listener) throws java.io.IOException {
        if (inputSteam == null) {
            return null;
        }
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        java.lang.Number numberPlus = (java.lang.Number) 0;
        byte[] bArr = new byte[2048];
        while (true) {
            int i = inputSteam.read(bArr, 0, 2048);
            if (i != -1) {
                byteArrayOutputStream.write(bArr, 0, i);
                numberPlus = io.dcloud.uts.NumberKt.plus(numberPlus, java.lang.Integer.valueOf(i));
                if (listener != null) {
                    listener.onProgress(numberPlus);
                }
            } else {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    private final java.lang.String readInputStream(java.io.InputStream inputSteam, uts.sdk.modules.DCloudUniNetwork.NetworkRequestListener listener) throws java.io.IOException {
        if (inputSteam == null) {
            return null;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(inputSteam));
        char[] cArr = new char[2048];
        while (true) {
            int i = bufferedReader.read(cArr);
            if (i != -1) {
                sb.append(cArr, 0, i);
                if (listener != null) {
                    listener.onProgress(java.lang.Integer.valueOf(sb.length()));
                }
            } else {
                bufferedReader.close();
                return sb.toString();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [T, uts.sdk.modules.DCloudUniNetwork.SharedStreamBuffer] */
    /* JADX WARN: Type inference failed for: r4v0, types: [T, java.util.concurrent.locks.ReentrantLock] */
    /* JADX WARN: Type inference failed for: r7v7, types: [T, io.dcloud.uts.ArrayBuffer] */
    private final byte[] processStreamWithOkio(final uts.sdk.modules.DCloudUniNetwork.NetworkRequestTaskImpl requestTask, final java.io.InputStream inputStream, uts.sdk.modules.DCloudUniNetwork.NetworkRequestListener listener) throws java.lang.Throwable {
        java.lang.Thread thread;
        java.lang.Number totalBytesRead;
        byte[] byteArray;
        boolean z;
        java.lang.Thread thread2 = null;
        if (inputStream == null) {
            return null;
        }
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        final kotlin.jvm.internal.Ref.ObjectRef objectRef = new kotlin.jvm.internal.Ref.ObjectRef();
        objectRef.element = new uts.sdk.modules.DCloudUniNetwork.SharedStreamBuffer();
        final kotlin.jvm.internal.Ref.ObjectRef objectRef2 = new kotlin.jvm.internal.Ref.ObjectRef();
        objectRef2.element = new java.util.concurrent.locks.ReentrantLock();
        try {
            thread = new java.lang.Thread(new java.lang.Runnable() { // from class: uts.sdk.modules.DCloudUniNetwork.SimpleCallback$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    uts.sdk.modules.DCloudUniNetwork.SimpleCallback.processStreamWithOkio$lambda$1(inputStream, objectRef2, objectRef);
                }
            });
            try {
                thread.start();
                do {
                    java.lang.Thread.sleep(100L);
                    java.lang.Integer num = (java.lang.Number) 0;
                    ((java.util.concurrent.locks.ReentrantLock) objectRef2.element).lock();
                    try {
                        if (((uts.sdk.modules.DCloudUniNetwork.SharedStreamBuffer) objectRef.element).getHasNewData()) {
                            byteArray = ((uts.sdk.modules.DCloudUniNetwork.SharedStreamBuffer) objectRef.element).getBuffer().toByteArray();
                            totalBytesRead = ((uts.sdk.modules.DCloudUniNetwork.SharedStreamBuffer) objectRef.element).getTotalBytesRead();
                            ((uts.sdk.modules.DCloudUniNetwork.SharedStreamBuffer) objectRef.element).getBuffer().reset();
                            ((uts.sdk.modules.DCloudUniNetwork.SharedStreamBuffer) objectRef.element).setHasNewData(false);
                        } else {
                            totalBytesRead = num;
                            byteArray = null;
                        }
                        z = ((uts.sdk.modules.DCloudUniNetwork.SharedStreamBuffer) objectRef.element).getIsStreamEnded() && !((uts.sdk.modules.DCloudUniNetwork.SharedStreamBuffer) objectRef.element).getHasNewData();
                        ((java.util.concurrent.locks.ReentrantLock) objectRef2.element).unlock();
                        if (byteArray != null && byteArray.length > 0) {
                            byteArrayOutputStream.write(byteArray, 0, byteArray.length);
                            if (requestTask.getChunkReceivedListeners().size() > 0) {
                                final kotlin.jvm.internal.Ref.ObjectRef objectRef3 = new kotlin.jvm.internal.Ref.ObjectRef();
                                io.dcloud.uts.ArrayBuffer.Companion companion = io.dcloud.uts.ArrayBuffer.INSTANCE;
                                java.nio.ByteBuffer byteBufferWrap = java.nio.ByteBuffer.wrap(byteArray);
                                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(byteBufferWrap, "wrap(...)");
                                objectRef3.element = companion.fromByteBuffer(byteBufferWrap);
                                new uts.sdk.modules.DCloudUniNetwork.RunnableTask(this.looper, new kotlin.jvm.functions.Function0() { // from class: uts.sdk.modules.DCloudUniNetwork.SimpleCallback$$ExternalSyntheticLambda4
                                    @Override // kotlin.jvm.functions.Function0
                                    public final java.lang.Object invoke() {
                                        return uts.sdk.modules.DCloudUniNetwork.SimpleCallback.processStreamWithOkio$lambda$3(requestTask, objectRef3);
                                    }
                                }).execute();
                            }
                            if (listener != null) {
                                listener.onProgress(totalBytesRead);
                            }
                        }
                    } catch (java.lang.Throwable th) {
                        ((java.util.concurrent.locks.ReentrantLock) objectRef2.element).unlock();
                        throw th;
                    }
                } while (!z);
                byteArrayOutputStream.flush();
                byte[] byteArray2 = byteArrayOutputStream.toByteArray();
                thread.interrupt();
                try {
                    thread.join(1000L);
                } catch (java.lang.InterruptedException unused) {
                }
                try {
                    if (objectRef.element != 0 && ((uts.sdk.modules.DCloudUniNetwork.SharedStreamBuffer) objectRef.element).getBuffer() != null) {
                        ((uts.sdk.modules.DCloudUniNetwork.SharedStreamBuffer) objectRef.element).getBuffer().close();
                    }
                    byteArrayOutputStream.close();
                } catch (java.lang.Exception unused2) {
                }
                return byteArray2;
            } catch (java.lang.Exception unused3) {
                if (thread != null) {
                    thread.interrupt();
                    try {
                        thread.join(1000L);
                    } catch (java.lang.InterruptedException unused4) {
                    }
                }
                try {
                    if (objectRef.element != 0 && ((uts.sdk.modules.DCloudUniNetwork.SharedStreamBuffer) objectRef.element).getBuffer() != null) {
                        ((uts.sdk.modules.DCloudUniNetwork.SharedStreamBuffer) objectRef.element).getBuffer().close();
                    }
                    byteArrayOutputStream.close();
                } catch (java.lang.Exception unused5) {
                }
                return null;
            } catch (java.lang.Throwable th2) {
                th = th2;
                thread2 = thread;
                if (thread2 != null) {
                    thread2.interrupt();
                    try {
                        thread2.join(1000L);
                    } catch (java.lang.InterruptedException unused6) {
                    }
                }
                try {
                    if (objectRef.element != 0 && ((uts.sdk.modules.DCloudUniNetwork.SharedStreamBuffer) objectRef.element).getBuffer() != null) {
                        ((uts.sdk.modules.DCloudUniNetwork.SharedStreamBuffer) objectRef.element).getBuffer().close();
                    }
                    byteArrayOutputStream.close();
                    throw th;
                } catch (java.lang.Exception unused7) {
                    throw th;
                }
            }
        } catch (java.lang.Exception unused8) {
            thread = null;
        } catch (java.lang.Throwable th3) {
            th = th3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void processStreamWithOkio$lambda$1(java.io.InputStream inputStream, kotlin.jvm.internal.Ref.ObjectRef<java.util.concurrent.locks.ReentrantLock> objectRef, kotlin.jvm.internal.Ref.ObjectRef<uts.sdk.modules.DCloudUniNetwork.SharedStreamBuffer> objectRef2) {
        try {
            okio.BufferedSource bufferedSourceBuffer = okio.Okio.buffer(okio.Okio.source(inputStream));
            while (!java.lang.Thread.interrupted()) {
                if (bufferedSourceBuffer.exhausted()) {
                    objectRef.element.lock();
                    try {
                        objectRef2.element.setStreamEnded(true);
                        return;
                    } finally {
                        objectRef.element.unlock();
                    }
                }
                byte[] bArr = new byte[8192];
                int i = bufferedSourceBuffer.read(bArr);
                if (i <= 0) {
                    objectRef.element.lock();
                    try {
                        objectRef2.element.setStreamEnded(true);
                        return;
                    } finally {
                        objectRef.element.unlock();
                    }
                }
                objectRef.element.lock();
                try {
                    objectRef2.element.getBuffer().write(bArr, 0, i);
                    uts.sdk.modules.DCloudUniNetwork.SharedStreamBuffer sharedStreamBuffer = objectRef2.element;
                    sharedStreamBuffer.setTotalBytesRead(io.dcloud.uts.NumberKt.plus(sharedStreamBuffer.getTotalBytesRead(), java.lang.Integer.valueOf(i)));
                    objectRef2.element.setHasNewData(true);
                    objectRef.element.unlock();
                } catch (java.lang.Throwable th) {
                    objectRef.element.unlock();
                    throw th;
                }
                objectRef.element.lock();
                try {
                    objectRef2.element.setStreamEnded(true);
                } finally {
                    objectRef.element.unlock();
                }
            }
        } catch (java.lang.Exception unused) {
            objectRef.element.lock();
            objectRef2.element.setStreamEnded(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit processStreamWithOkio$lambda$3(uts.sdk.modules.DCloudUniNetwork.NetworkRequestTaskImpl networkRequestTaskImpl, final kotlin.jvm.internal.Ref.ObjectRef<io.dcloud.uts.ArrayBuffer> objectRef) {
        networkRequestTaskImpl.getChunkReceivedListeners().forEach(new kotlin.jvm.functions.Function2() { // from class: uts.sdk.modules.DCloudUniNetwork.SimpleCallback$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function2
            public final java.lang.Object invoke(java.lang.Object obj, java.lang.Object obj2) {
                return uts.sdk.modules.DCloudUniNetwork.SimpleCallback.processStreamWithOkio$lambda$3$lambda$2(objectRef, (kotlin.jvm.functions.Function1) obj, (java.lang.Number) obj2);
            }
        });
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit processStreamWithOkio$lambda$3$lambda$2(kotlin.jvm.internal.Ref.ObjectRef<io.dcloud.uts.ArrayBuffer> objectRef, kotlin.jvm.functions.Function1<? super uts.sdk.modules.DCloudUniNetwork.RequestTaskOnChunkReceivedListenerResult, kotlin.Unit> function1, java.lang.Number number) {
        function1.invoke2(new uts.sdk.modules.DCloudUniNetwork.RequestTaskOnChunkReceivedListenerResult(objectRef.element));
        return kotlin.Unit.INSTANCE;
    }

    private final byte[] processChunkedResponse(uts.sdk.modules.DCloudUniNetwork.NetworkRequestTaskImpl requestTask, java.io.InputStream inputStream, uts.sdk.modules.DCloudUniNetwork.NetworkRequestListener listener) {
        byte[] bArr;
        java.io.InputStream inputStream2 = inputStream;
        byte[] bArr2 = null;
        if (inputStream2 == null) {
            return null;
        }
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        java.io.ByteArrayOutputStream byteArrayOutputStream2 = new java.io.ByteArrayOutputStream();
        byte[] bArr3 = new byte[10];
        int i = 0;
        java.lang.Number numberPlus = (java.lang.Number) 0;
        io.dcloud.uts.UTSArray<byte[]> uTSArray = new io.dcloud.uts.UTSArray<>();
        java.lang.Integer.valueOf(0);
        byte[] bArr4 = null;
        boolean z = false;
        int i2 = -1;
        while (true) {
            try {
                try {
                    bArr = bArr2;
                    try {
                        java.lang.Integer numValueOf = java.lang.Integer.valueOf(inputStream2.read(bArr3));
                        if (io.dcloud.uts.NumberKt.numberEquals(numValueOf, -1)) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr3, i, numValueOf.intValue());
                        numberPlus = io.dcloud.uts.NumberKt.plus(numberPlus, numValueOf);
                        if (listener != 0) {
                            listener.onProgress(numberPlus);
                        }
                        if (requestTask.getChunkReceivedListeners().size() > 0) {
                            uts.sdk.modules.DCloudUniNetwork.SimpleCallback simpleCallback = this;
                            java.lang.Integer numValueOf2 = java.lang.Integer.valueOf(i);
                            while (io.dcloud.uts.NumberKt.compareTo(numValueOf2, numValueOf) < 0) {
                                int iIntValue = io.dcloud.uts.NumberKt.and(java.lang.Byte.valueOf(bArr3[numValueOf2.intValue()]), (java.lang.Number) 255).intValue();
                                byteArrayOutputStream2.write(iIntValue);
                                if (i2 == 13 && iIntValue == 10) {
                                    byte[] byteArray = byteArrayOutputStream2.toByteArray();
                                    kotlin.jvm.internal.Intrinsics.checkNotNull(byteArray);
                                    if (isZeroChunk(byteArray) && !z) {
                                        bArr4 = new byte[byteArray.length];
                                        java.lang.System.arraycopy(byteArray, 0, bArr4, 0, byteArray.length);
                                        z = true;
                                    } else if (z) {
                                        processPendingLines(requestTask, uTSArray);
                                        uTSArray = new io.dcloud.uts.UTSArray<>();
                                        kotlin.jvm.internal.Intrinsics.checkNotNull(byteArray);
                                        if (isEmptyLine(byteArray)) {
                                            kotlin.jvm.internal.Intrinsics.checkNotNull(bArr4);
                                            kotlin.jvm.internal.Intrinsics.checkNotNull(byteArray);
                                            sendCombinedData(requestTask, bArr4, byteArray);
                                        } else {
                                            byte[] bArr5 = new byte[byteArray.length];
                                            java.lang.System.arraycopy(byteArray, 0, bArr5, 0, byteArray.length);
                                            kotlin.jvm.internal.Intrinsics.checkNotNull(bArr4);
                                            processLinePair(requestTask, io.dcloud.uts.UTSArrayKt._uA(bArr4, bArr5));
                                        }
                                        bArr4 = bArr;
                                        z = false;
                                    } else {
                                        byte[] bArr6 = new byte[byteArray.length];
                                        java.lang.System.arraycopy(byteArray, 0, bArr6, 0, byteArray.length);
                                        uTSArray.push(bArr6);
                                        if (io.dcloud.uts.NumberKt.numberEquals(uTSArray.getLength(), 2)) {
                                            processLinePair(requestTask, uTSArray);
                                            uTSArray = new io.dcloud.uts.UTSArray<>();
                                        }
                                    }
                                    byteArrayOutputStream2.reset();
                                }
                                numValueOf2 = io.dcloud.uts.NumberKt.inc(numValueOf2);
                                i2 = iIntValue;
                            }
                        }
                        if (io.dcloud.uts.NumberKt.numberEquals(numValueOf, -1)) {
                            break;
                        }
                        inputStream2 = inputStream;
                        bArr2 = bArr;
                        i = 0;
                    } catch (java.lang.Exception unused) {
                        try {
                            byteArrayOutputStream.close();
                            byteArrayOutputStream2.close();
                        } catch (java.lang.Exception unused2) {
                        }
                        return bArr;
                    }
                } catch (java.lang.Throwable th) {
                    try {
                        byteArrayOutputStream.close();
                        byteArrayOutputStream2.close();
                    } catch (java.lang.Exception unused3) {
                    }
                    throw th;
                }
            } catch (java.lang.Exception unused4) {
                bArr = bArr2;
            }
        }
        processPendingLines(requestTask, uTSArray);
        if (z && bArr4 != null) {
            sendData(requestTask, bArr4);
        }
        if (requestTask.getChunkReceivedListeners().size() > 0 && byteArrayOutputStream2.size() > 0) {
            byte[] byteArray2 = byteArrayOutputStream2.toByteArray();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(byteArray2, "toByteArray(...)");
            sendData(requestTask, byteArray2);
        }
        byteArrayOutputStream.flush();
        byte[] byteArray3 = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
            byteArrayOutputStream2.close();
        } catch (java.lang.Exception unused5) {
        }
        return byteArray3;
    }

    private final boolean isValidChunk(byte[] sizeLine, byte[] dataLine) {
        int hexSize;
        return isHexadecimalLine(sizeLine) && (hexSize = parseHexSize(sizeLine)) >= 0 && io.dcloud.uts.NumberKt.compareTo(io.dcloud.uts.Math.abs(java.lang.Integer.valueOf((dataLine.length - 2) - hexSize)), (java.lang.Number) 2) <= 0;
    }

    private final int parseHexSize(byte[] lineData) {
        if (lineData.length <= 2) {
            return -1;
        }
        int length = lineData.length - 2;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (int i = 0; i < length && lineData[i] != 59; i++) {
            sb.append(io.dcloud.uts.StringKt.fromCharCode(kotlin.jvm.internal.StringCompanionObject.INSTANCE, java.lang.Integer.valueOf(lineData[i])));
        }
        if (sb.length() == 0) {
            return -1;
        }
        try {
            java.lang.String string = sb.toString();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return java.lang.Integer.parseInt(kotlin.text.StringsKt.trim((java.lang.CharSequence) string).toString(), 16);
        } catch (java.lang.Exception unused) {
            return -1;
        }
    }

    private final boolean isHexadecimalLine(byte[] lineData) {
        int length;
        if (lineData.length <= 2 || (length = lineData.length - 2) <= 0) {
            return false;
        }
        int i = 0;
        boolean z = false;
        while (i < length) {
            byte b = lineData[i];
            if (b == 32 || b == 59) {
                break;
            }
            if ((b < 48 || b > 57) && ((b < 65 || b > 70) && (b < 97 || b > 102))) {
                return false;
            }
            i++;
            z = true;
        }
        return z;
    }

    private final boolean isZeroChunk(byte[] lineData) {
        if (lineData.length < 3 || lineData[0] != 48) {
            return false;
        }
        byte b = lineData[1];
        if (b != 59 && b != 13) {
            return false;
        }
        if (b == 13 && lineData.length >= 3) {
            return lineData[2] == 10;
        }
        if (b == 59) {
            for (int i = 2; i < lineData.length - 1; i++) {
                if (lineData[i] == 13 && lineData[i + 1] == 10) {
                    return true;
                }
            }
        }
        return false;
    }

    private final boolean isEmptyLine(byte[] lineData) {
        return lineData.length == 2 && lineData[0] == 13 && lineData[1] == 10;
    }

    /* JADX WARN: Type inference failed for: r5v2, types: [T, io.dcloud.uts.ArrayBuffer] */
    private final void sendData(uts.sdk.modules.DCloudUniNetwork.NetworkRequestTaskImpl requestTask, byte[] data) {
        final kotlin.jvm.internal.Ref.ObjectRef objectRef = new kotlin.jvm.internal.Ref.ObjectRef();
        io.dcloud.uts.ArrayBuffer.Companion companion = io.dcloud.uts.ArrayBuffer.INSTANCE;
        java.nio.ByteBuffer byteBufferWrap = java.nio.ByteBuffer.wrap(data);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(byteBufferWrap, "wrap(...)");
        objectRef.element = companion.fromByteBuffer(byteBufferWrap);
        requestTask.getChunkReceivedListeners().forEach(new kotlin.jvm.functions.Function2() { // from class: uts.sdk.modules.DCloudUniNetwork.SimpleCallback$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function2
            public final java.lang.Object invoke(java.lang.Object obj, java.lang.Object obj2) {
                return uts.sdk.modules.DCloudUniNetwork.SimpleCallback.sendData$lambda$8(objectRef, (kotlin.jvm.functions.Function1) obj, (java.lang.Number) obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit sendData$lambda$8(kotlin.jvm.internal.Ref.ObjectRef<io.dcloud.uts.ArrayBuffer> objectRef, kotlin.jvm.functions.Function1<? super uts.sdk.modules.DCloudUniNetwork.RequestTaskOnChunkReceivedListenerResult, kotlin.Unit> function1, java.lang.Number number) {
        function1.invoke2(new uts.sdk.modules.DCloudUniNetwork.RequestTaskOnChunkReceivedListenerResult(objectRef.element));
        return kotlin.Unit.INSTANCE;
    }

    private final void sendCombinedData(uts.sdk.modules.DCloudUniNetwork.NetworkRequestTaskImpl requestTask, byte[] data1, byte[] data2) {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(data1, 0, data1.length);
            byteArrayOutputStream.write(data2, 0, data2.length);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            kotlin.jvm.internal.Intrinsics.checkNotNull(byteArray);
            sendData(requestTask, byteArray);
        } finally {
            try {
                byteArrayOutputStream.close();
            } catch (java.lang.Exception unused) {
            }
        }
    }

    private final void processPendingLines(uts.sdk.modules.DCloudUniNetwork.NetworkRequestTaskImpl requestTask, io.dcloud.uts.UTSArray<byte[]> pendingLines) {
        if (io.dcloud.uts.NumberKt.numberEquals(pendingLines.getLength(), 0)) {
            return;
        }
        for (java.lang.Number numberInc = (java.lang.Number) 0; io.dcloud.uts.NumberKt.compareTo(numberInc, pendingLines.getLength()) < 0; numberInc = io.dcloud.uts.NumberKt.inc(numberInc)) {
            sendData(requestTask, pendingLines.get(numberInc));
        }
    }

    private final void processLinePair(uts.sdk.modules.DCloudUniNetwork.NetworkRequestTaskImpl requestTask, io.dcloud.uts.UTSArray<byte[]> pendingLines) {
        if (io.dcloud.uts.NumberKt.numberEquals(pendingLines.getLength(), 2)) {
            byte[] bArr = pendingLines.get(0);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bArr, "get(...)");
            byte[] bArr2 = pendingLines.get(1);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bArr2, "get(...)");
            if (isValidChunk(bArr, bArr2)) {
                byte[] bArr3 = pendingLines.get(0);
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bArr3, "get(...)");
                byte[] bArr4 = pendingLines.get(1);
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bArr4, "get(...)");
                sendCombinedData(requestTask, bArr3, bArr4);
                return;
            }
            processPendingLines(requestTask, pendingLines);
        }
    }
}
