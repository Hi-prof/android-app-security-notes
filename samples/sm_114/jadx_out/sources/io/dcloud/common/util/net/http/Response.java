package io.dcloud.common.util.net.http;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class Response implements java.lang.Runnable {
    io.dcloud.common.DHInterface.AbsMgr mNetMgr;
    java.net.Socket mSocket;
    private static final byte CR = 13;
    private static final byte LF = 10;
    private static final byte[] CRLF = {CR, LF};
    java.lang.String mUrl = null;
    final int BUFFER_SIZE = 10240;

    public Response(java.net.Socket socket, io.dcloud.common.DHInterface.AbsMgr absMgr) {
        this.mSocket = socket;
        this.mNetMgr = absMgr;
        new java.lang.Thread(this).start();
    }

    private void addResponseHead(long j, java.io.OutputStream outputStream) throws java.io.IOException {
        writeHeader(outputStream, "HTTP/1.1 200 OK");
        writeHeader(outputStream, "Content-Type: " + io.dcloud.common.util.PdrUtil.getMimeType(this.mUrl));
        writeHeader(outputStream, "Access-Control-Allow-Origin: *");
        writeHeader(outputStream, "Access-Control-Allow-Headers: *");
        writeHeader(outputStream, "Content-Length: " + j);
        outputStream.write(CRLF);
        outputStream.flush();
    }

    private void write(java.io.OutputStream outputStream, java.lang.String str) throws java.io.IOException {
        outputStream.write(str.getBytes());
    }

    private void writeRequest(java.io.OutputStream outputStream, java.lang.String str) throws java.io.IOException {
        outputStream.write("GET /index.html HTTP/1.1".getBytes());
        byte[] bArr = CRLF;
        outputStream.write(bArr);
        outputStream.write(("Host: " + str).getBytes());
        outputStream.write(bArr);
        outputStream.write(bArr);
        outputStream.flush();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v9 */
    @Override // java.lang.Runnable
    public void run() throws java.lang.Throwable {
        java.io.InputStream inputStream;
        java.io.InputStream inputStream2;
        java.io.OutputStream outputStream;
        java.io.InputStream resInputStream;
        java.io.InputStream inputStream3;
        ?? r2 = 0;
        java.io.OutputStream outputStream2 = null;
        java.io.InputStream inputStream4 = null;
        r2 = 0;
        r2 = 0;
        r2 = 0;
        try {
            inputStream2 = this.mSocket.getInputStream();
            try {
                io.dcloud.common.util.net.http.Request request = new io.dcloud.common.util.net.http.Request(inputStream2);
                request.parse();
                java.lang.String data = request.getData();
                if (data.startsWith(io.dcloud.common.constant.AbsoluteConst.SOCKET_NATIVE_COMMAND)) {
                    this.mNetMgr.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.AppMgr, 7, data);
                    inputStream3 = null;
                } else {
                    try {
                        if (data.startsWith(io.dcloud.common.constant.AbsoluteConst.SOCKET_CONNECTION)) {
                            java.lang.String strSubstring = data.substring(6);
                            outputStream = this.mSocket.getOutputStream();
                            java.lang.String str = io.dcloud.common.util.PdrUtil.isEquals(strSubstring, io.dcloud.common.constant.AbsoluteConst.SOCKET_CONN_REQUEST_ROOT_PATH) ? io.dcloud.common.adapter.util.DeviceInfo.sDeviceRootDir : "";
                            io.dcloud.common.adapter.util.Logger.d("miniserver", strSubstring, str);
                            outputStream.write(str.getBytes());
                        } else {
                            java.lang.String uri = request.getUri();
                            this.mUrl = uri;
                            if (uri == null) {
                                try {
                                    io.dcloud.common.util.IOUtil.close(inputStream2);
                                    io.dcloud.common.util.IOUtil.close((java.io.InputStream) null);
                                    io.dcloud.common.util.IOUtil.close((java.io.OutputStream) null);
                                    this.mSocket.close();
                                    return;
                                } catch (java.lang.Exception e) {
                                    e.printStackTrace();
                                    return;
                                }
                            }
                            outputStream = this.mSocket.getOutputStream();
                            byte[] bArr = new byte[10240];
                            if (this.mUrl.startsWith(io.dcloud.common.constant.AbsoluteConst.MINI_SERVER_BASE_RES)) {
                                resInputStream = io.dcloud.common.adapter.util.PlatformUtil.getResInputStream("res/" + this.mUrl.substring(5));
                            } else {
                                resInputStream = (java.io.InputStream) this.mNetMgr.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.AppMgr, 2, this.mUrl);
                            }
                            inputStream4 = resInputStream;
                            if (inputStream4 != null) {
                                java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                                while (true) {
                                    int i = inputStream4.read(bArr);
                                    if (i <= 0) {
                                        break;
                                    } else {
                                        byteArrayOutputStream.write(bArr, 0, i);
                                    }
                                }
                                byte[] byteArray = byteArrayOutputStream.toByteArray();
                                addResponseHead(byteArray.length, outputStream);
                                outputStream.write(byteArray);
                            } else {
                                io.dcloud.common.adapter.util.Logger.i("miniserver", "error url=" + this.mUrl);
                                outputStream.write("HTTP/1.1 404 File Not Found\r\nContent-Type: text/html\r\nContent-Length: 23\r\n\r\n<h1>File Not Found</h1>".getBytes());
                            }
                        }
                        inputStream3 = inputStream4;
                        outputStream2 = outputStream;
                    } catch (java.io.IOException e2) {
                        e = e2;
                        inputStream = null;
                        r2 = request;
                        try {
                            e.printStackTrace();
                            try {
                                io.dcloud.common.util.IOUtil.close(inputStream2);
                                io.dcloud.common.util.IOUtil.close(inputStream);
                                io.dcloud.common.util.IOUtil.close((java.io.OutputStream) r2);
                                this.mSocket.close();
                                return;
                            } catch (java.lang.Exception e3) {
                                e3.printStackTrace();
                                return;
                            }
                        } catch (java.lang.Throwable th) {
                            th = th;
                            try {
                                io.dcloud.common.util.IOUtil.close(inputStream2);
                                io.dcloud.common.util.IOUtil.close(inputStream);
                                io.dcloud.common.util.IOUtil.close((java.io.OutputStream) r2);
                                this.mSocket.close();
                            } catch (java.lang.Exception e4) {
                                e4.printStackTrace();
                            }
                            throw th;
                        }
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                        inputStream = null;
                        r2 = request;
                        io.dcloud.common.util.IOUtil.close(inputStream2);
                        io.dcloud.common.util.IOUtil.close(inputStream);
                        io.dcloud.common.util.IOUtil.close((java.io.OutputStream) r2);
                        this.mSocket.close();
                        throw th;
                    }
                }
                try {
                    io.dcloud.common.util.IOUtil.close(inputStream2);
                    io.dcloud.common.util.IOUtil.close(inputStream3);
                    io.dcloud.common.util.IOUtil.close(outputStream2);
                    this.mSocket.close();
                } catch (java.lang.Exception e5) {
                    e5.printStackTrace();
                }
            } catch (java.io.IOException e6) {
                e = e6;
                inputStream = null;
            } catch (java.lang.Throwable th3) {
                th = th3;
                inputStream = null;
            }
        } catch (java.io.IOException e7) {
            e = e7;
            inputStream = null;
            inputStream2 = null;
        } catch (java.lang.Throwable th4) {
            th = th4;
            inputStream = null;
            inputStream2 = null;
        }
    }

    void writeHeader(java.io.OutputStream outputStream, java.lang.String str) throws java.io.IOException {
        write(outputStream, str);
        outputStream.write(CRLF);
    }
}
