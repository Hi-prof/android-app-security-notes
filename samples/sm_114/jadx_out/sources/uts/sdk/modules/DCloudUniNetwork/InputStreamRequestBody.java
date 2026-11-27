package uts.sdk.modules.DCloudUniNetwork;

/* JADX INFO: compiled from: index.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\u0003H\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Luts/sdk/modules/DCloudUniNetwork/InputStreamRequestBody;", "Lokhttp3/RequestBody;", "mediaType", "Lokhttp3/MediaType;", "length", "", "inputStream", "Ljava/io/InputStream;", "<init>", "(Lokhttp3/MediaType;JLjava/io/InputStream;)V", "contentLength", "contentType", "writeTo", "", "sink", "Lokio/BufferedSink;", "uni-network_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class InputStreamRequestBody extends okhttp3.RequestBody {
    private java.io.InputStream inputStream;
    private long length;
    private okhttp3.MediaType mediaType;

    public InputStreamRequestBody(okhttp3.MediaType mediaType, long j, java.io.InputStream inputStream) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(mediaType, "mediaType");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        this.mediaType = mediaType;
        this.length = j;
        this.inputStream = inputStream;
    }

    @Override // okhttp3.RequestBody
    /* JADX INFO: renamed from: contentLength, reason: from getter */
    public long getLength() {
        return this.length;
    }

    @Override // okhttp3.RequestBody
    public okhttp3.MediaType contentType() {
        okhttp3.MediaType mediaType = this.mediaType;
        if (mediaType != null) {
            return mediaType;
        }
        okhttp3.MediaType mediaType2 = okhttp3.MediaType.parse("application/octet-stream");
        kotlin.jvm.internal.Intrinsics.checkNotNull(mediaType2);
        return mediaType2;
    }

    @Override // okhttp3.RequestBody
    public void writeTo(okio.BufferedSink sink) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(sink, "sink");
        okio.Source source = null;
        try {
            source = okio.Okio.source(this.inputStream);
            sink.writeAll(source);
        } catch (java.lang.Throwable unused) {
        }
        okhttp3.internal.Util.closeQuietly(source);
    }
}
