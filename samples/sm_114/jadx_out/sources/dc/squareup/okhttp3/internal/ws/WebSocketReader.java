package dc.squareup.okhttp3.internal.ws;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
final class WebSocketReader {
    boolean closed;
    final dc.squareup.okhttp3.internal.ws.WebSocketReader.FrameCallback frameCallback;
    long frameLength;
    final boolean isClient;
    boolean isControlFrame;
    boolean isFinalFrame;
    private final dc.squareup.okio.Buffer.UnsafeCursor maskCursor;
    private final byte[] maskKey;
    int opcode;
    final dc.squareup.okio.BufferedSource source;
    private final dc.squareup.okio.Buffer controlFrameBuffer = new dc.squareup.okio.Buffer();
    private final dc.squareup.okio.Buffer messageFrameBuffer = new dc.squareup.okio.Buffer();

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public interface FrameCallback {
        void onReadClose(int i, java.lang.String str);

        void onReadMessage(dc.squareup.okio.ByteString byteString) throws java.io.IOException;

        void onReadMessage(java.lang.String str) throws java.io.IOException;

        void onReadPing(dc.squareup.okio.ByteString byteString);

        void onReadPong(dc.squareup.okio.ByteString byteString);
    }

    WebSocketReader(boolean z, dc.squareup.okio.BufferedSource bufferedSource, dc.squareup.okhttp3.internal.ws.WebSocketReader.FrameCallback frameCallback) {
        if (bufferedSource == null) {
            throw new java.lang.NullPointerException("source == null");
        }
        if (frameCallback == null) {
            throw new java.lang.NullPointerException("frameCallback == null");
        }
        this.isClient = z;
        this.source = bufferedSource;
        this.frameCallback = frameCallback;
        this.maskKey = z ? null : new byte[4];
        this.maskCursor = z ? null : new dc.squareup.okio.Buffer.UnsafeCursor();
    }

    private void readControlFrame() throws java.io.IOException {
        short s;
        java.lang.String utf8;
        long j = this.frameLength;
        if (j > 0) {
            this.source.readFully(this.controlFrameBuffer, j);
            if (!this.isClient) {
                this.controlFrameBuffer.readAndWriteUnsafe(this.maskCursor);
                this.maskCursor.seek(0L);
                dc.squareup.okhttp3.internal.ws.WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
                this.maskCursor.close();
            }
        }
        switch (this.opcode) {
            case 8:
                long size = this.controlFrameBuffer.size();
                if (size == 1) {
                    throw new java.net.ProtocolException("Malformed close payload length of 1.");
                }
                if (size != 0) {
                    s = this.controlFrameBuffer.readShort();
                    utf8 = this.controlFrameBuffer.readUtf8();
                    java.lang.String strCloseCodeExceptionMessage = dc.squareup.okhttp3.internal.ws.WebSocketProtocol.closeCodeExceptionMessage(s);
                    if (strCloseCodeExceptionMessage != null) {
                        throw new java.net.ProtocolException(strCloseCodeExceptionMessage);
                    }
                } else {
                    s = 1005;
                    utf8 = "";
                }
                this.frameCallback.onReadClose(s, utf8);
                this.closed = true;
                return;
            case 9:
                this.frameCallback.onReadPing(this.controlFrameBuffer.readByteString());
                return;
            case 10:
                this.frameCallback.onReadPong(this.controlFrameBuffer.readByteString());
                return;
            default:
                throw new java.net.ProtocolException("Unknown control opcode: " + java.lang.Integer.toHexString(this.opcode));
        }
    }

    private void readHeader() throws java.io.IOException {
        if (this.closed) {
            throw new java.io.IOException("closed");
        }
        long jTimeoutNanos = this.source.timeout().timeoutNanos();
        this.source.timeout().clearTimeout();
        try {
            byte b = this.source.readByte();
            this.source.timeout().timeout(jTimeoutNanos, java.util.concurrent.TimeUnit.NANOSECONDS);
            this.opcode = b & 15;
            boolean z = (b & kotlin.jvm.internal.ByteCompanionObject.MIN_VALUE) != 0;
            this.isFinalFrame = z;
            boolean z2 = (b & 8) != 0;
            this.isControlFrame = z2;
            if (z2 && !z) {
                throw new java.net.ProtocolException("Control frames must be final.");
            }
            boolean z3 = (b & 64) != 0;
            boolean z4 = (b & org.mozilla.universalchardet.prober.HebrewProber.SPACE) != 0;
            boolean z5 = (b & 16) != 0;
            if (z3 || z4 || z5) {
                throw new java.net.ProtocolException("Reserved flags are unsupported.");
            }
            byte b2 = this.source.readByte();
            boolean z6 = (b2 & kotlin.jvm.internal.ByteCompanionObject.MIN_VALUE) != 0;
            if (z6 == this.isClient) {
                throw new java.net.ProtocolException(this.isClient ? "Server-sent frames must not be masked." : "Client-sent frames must be masked.");
            }
            long j = b2 & kotlin.jvm.internal.ByteCompanionObject.MAX_VALUE;
            this.frameLength = j;
            if (j == 126) {
                this.frameLength = ((long) this.source.readShort()) & 65535;
            } else if (j == 127) {
                long j2 = this.source.readLong();
                this.frameLength = j2;
                if (j2 < 0) {
                    throw new java.net.ProtocolException("Frame length 0x" + java.lang.Long.toHexString(this.frameLength) + " > 0x7FFFFFFFFFFFFFFF");
                }
            }
            if (this.isControlFrame && this.frameLength > 125) {
                throw new java.net.ProtocolException("Control frame must be less than 125B.");
            }
            if (z6) {
                this.source.readFully(this.maskKey);
            }
        } catch (java.lang.Throwable th) {
            this.source.timeout().timeout(jTimeoutNanos, java.util.concurrent.TimeUnit.NANOSECONDS);
            throw th;
        }
    }

    private void readMessage() throws java.io.IOException {
        while (!this.closed) {
            long j = this.frameLength;
            if (j > 0) {
                this.source.readFully(this.messageFrameBuffer, j);
                if (!this.isClient) {
                    this.messageFrameBuffer.readAndWriteUnsafe(this.maskCursor);
                    this.maskCursor.seek(this.messageFrameBuffer.size() - this.frameLength);
                    dc.squareup.okhttp3.internal.ws.WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
                    this.maskCursor.close();
                }
            }
            if (this.isFinalFrame) {
                return;
            }
            readUntilNonControlFrame();
            if (this.opcode != 0) {
                throw new java.net.ProtocolException("Expected continuation opcode. Got: " + java.lang.Integer.toHexString(this.opcode));
            }
        }
        throw new java.io.IOException("closed");
    }

    private void readMessageFrame() throws java.io.IOException {
        int i = this.opcode;
        if (i != 1 && i != 2) {
            throw new java.net.ProtocolException("Unknown opcode: " + java.lang.Integer.toHexString(i));
        }
        readMessage();
        if (i == 1) {
            this.frameCallback.onReadMessage(this.messageFrameBuffer.readUtf8());
        } else {
            this.frameCallback.onReadMessage(this.messageFrameBuffer.readByteString());
        }
    }

    private void readUntilNonControlFrame() throws java.io.IOException {
        while (!this.closed) {
            readHeader();
            if (!this.isControlFrame) {
                return;
            } else {
                readControlFrame();
            }
        }
    }

    void processNextFrame() throws java.io.IOException {
        readHeader();
        if (this.isControlFrame) {
            readControlFrame();
        } else {
            readMessageFrame();
        }
    }
}
