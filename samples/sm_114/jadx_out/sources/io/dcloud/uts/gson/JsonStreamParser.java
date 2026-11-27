package io.dcloud.uts.gson;

/* JADX INFO: loaded from: classes2.dex */
public final class JsonStreamParser implements java.util.Iterator<io.dcloud.uts.gson.JsonElement> {
    private final java.lang.Object lock;
    private final io.dcloud.uts.gson.stream.JsonReader parser;

    public JsonStreamParser(java.lang.String str) {
        this(new java.io.StringReader(str));
    }

    public JsonStreamParser(java.io.Reader reader) {
        io.dcloud.uts.gson.stream.JsonReader jsonReader = new io.dcloud.uts.gson.stream.JsonReader(reader);
        this.parser = jsonReader;
        jsonReader.setLenient(true);
        this.lock = new java.lang.Object();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    public io.dcloud.uts.gson.JsonElement next() throws io.dcloud.uts.gson.JsonParseException {
        if (!hasNext()) {
            throw new java.util.NoSuchElementException();
        }
        try {
            return io.dcloud.uts.gson.internal.Streams.parse(this.parser);
        } catch (io.dcloud.uts.gson.JsonParseException e) {
            if (e.getCause() instanceof java.io.EOFException) {
                throw new java.util.NoSuchElementException();
            }
            throw e;
        } catch (java.lang.OutOfMemoryError e2) {
            throw new io.dcloud.uts.gson.JsonParseException("Failed parsing JSON source to Json", e2);
        } catch (java.lang.StackOverflowError e3) {
            throw new io.dcloud.uts.gson.JsonParseException("Failed parsing JSON source to Json", e3);
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        boolean z;
        synchronized (this.lock) {
            try {
                try {
                    try {
                        z = this.parser.peek() != io.dcloud.uts.gson.stream.JsonToken.END_DOCUMENT;
                    } catch (java.io.IOException e) {
                        throw new io.dcloud.uts.gson.JsonIOException(e);
                    }
                } catch (io.dcloud.uts.gson.stream.MalformedJsonException e2) {
                    throw new io.dcloud.uts.gson.JsonSyntaxException(e2);
                }
            } catch (java.lang.Throwable th) {
                throw th;
            }
        }
        return z;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new java.lang.UnsupportedOperationException();
    }
}
