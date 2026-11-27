package io.dcloud.uts.gson.internal.bind;

/* JADX INFO: loaded from: classes2.dex */
public final class JsonTreeWriter extends io.dcloud.uts.gson.stream.JsonWriter {
    private java.lang.String pendingName;
    private io.dcloud.uts.gson.JsonElement product;
    private final java.util.List<io.dcloud.uts.gson.JsonElement> stack;
    private static final java.io.Writer UNWRITABLE_WRITER = new java.io.Writer() { // from class: io.dcloud.uts.gson.internal.bind.JsonTreeWriter.1
        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) {
            throw new java.lang.AssertionError();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() throws java.io.IOException {
            throw new java.lang.AssertionError();
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws java.io.IOException {
            throw new java.lang.AssertionError();
        }
    };
    private static final io.dcloud.uts.gson.JsonPrimitive SENTINEL_CLOSED = new io.dcloud.uts.gson.JsonPrimitive("closed");

    @Override // io.dcloud.uts.gson.stream.JsonWriter, java.io.Flushable
    public void flush() throws java.io.IOException {
    }

    public JsonTreeWriter() {
        super(UNWRITABLE_WRITER);
        this.stack = new java.util.ArrayList();
        this.product = io.dcloud.uts.gson.JsonNull.INSTANCE;
    }

    public io.dcloud.uts.gson.JsonElement get() {
        if (!this.stack.isEmpty()) {
            throw new java.lang.IllegalStateException("Expected one JSON element but was " + this.stack);
        }
        return this.product;
    }

    private io.dcloud.uts.gson.JsonElement peek() {
        java.util.List<io.dcloud.uts.gson.JsonElement> list = this.stack;
        return list.get(list.size() - 1);
    }

    private void put(io.dcloud.uts.gson.JsonElement jsonElement) {
        if (this.pendingName != null) {
            if (!jsonElement.isJsonNull() || getSerializeNulls()) {
                ((io.dcloud.uts.gson.JsonObject) peek()).add(this.pendingName, jsonElement);
            }
            this.pendingName = null;
            return;
        }
        if (this.stack.isEmpty()) {
            this.product = jsonElement;
            return;
        }
        io.dcloud.uts.gson.JsonElement jsonElementPeek = peek();
        if (jsonElementPeek instanceof io.dcloud.uts.gson.JsonArray) {
            ((io.dcloud.uts.gson.JsonArray) jsonElementPeek).add(jsonElement);
            return;
        }
        throw new java.lang.IllegalStateException();
    }

    @Override // io.dcloud.uts.gson.stream.JsonWriter
    public io.dcloud.uts.gson.stream.JsonWriter beginArray() throws java.io.IOException {
        io.dcloud.uts.gson.JsonArray jsonArray = new io.dcloud.uts.gson.JsonArray();
        put(jsonArray);
        this.stack.add(jsonArray);
        return this;
    }

    @Override // io.dcloud.uts.gson.stream.JsonWriter
    public io.dcloud.uts.gson.stream.JsonWriter endArray() throws java.io.IOException {
        if (this.stack.isEmpty() || this.pendingName != null) {
            throw new java.lang.IllegalStateException();
        }
        if (peek() instanceof io.dcloud.uts.gson.JsonArray) {
            java.util.List<io.dcloud.uts.gson.JsonElement> list = this.stack;
            list.remove(list.size() - 1);
            return this;
        }
        throw new java.lang.IllegalStateException();
    }

    @Override // io.dcloud.uts.gson.stream.JsonWriter
    public io.dcloud.uts.gson.stream.JsonWriter beginObject() throws java.io.IOException {
        io.dcloud.uts.gson.JsonObject jsonObject = new io.dcloud.uts.gson.JsonObject();
        put(jsonObject);
        this.stack.add(jsonObject);
        return this;
    }

    @Override // io.dcloud.uts.gson.stream.JsonWriter
    public io.dcloud.uts.gson.stream.JsonWriter endObject() throws java.io.IOException {
        if (this.stack.isEmpty() || this.pendingName != null) {
            throw new java.lang.IllegalStateException();
        }
        if (peek() instanceof io.dcloud.uts.gson.JsonObject) {
            java.util.List<io.dcloud.uts.gson.JsonElement> list = this.stack;
            list.remove(list.size() - 1);
            return this;
        }
        throw new java.lang.IllegalStateException();
    }

    @Override // io.dcloud.uts.gson.stream.JsonWriter
    public io.dcloud.uts.gson.stream.JsonWriter name(java.lang.String str) throws java.io.IOException {
        if (str == null) {
            throw new java.lang.NullPointerException("name == null");
        }
        if (this.stack.isEmpty() || this.pendingName != null) {
            throw new java.lang.IllegalStateException();
        }
        if (peek() instanceof io.dcloud.uts.gson.JsonObject) {
            this.pendingName = str;
            return this;
        }
        throw new java.lang.IllegalStateException();
    }

    @Override // io.dcloud.uts.gson.stream.JsonWriter
    public io.dcloud.uts.gson.stream.JsonWriter value(java.lang.String str) throws java.io.IOException {
        if (str == null) {
            return nullValue();
        }
        put(new io.dcloud.uts.gson.JsonPrimitive(str));
        return this;
    }

    @Override // io.dcloud.uts.gson.stream.JsonWriter
    public io.dcloud.uts.gson.stream.JsonWriter nullValue() throws java.io.IOException {
        put(io.dcloud.uts.gson.JsonNull.INSTANCE);
        return this;
    }

    @Override // io.dcloud.uts.gson.stream.JsonWriter
    public io.dcloud.uts.gson.stream.JsonWriter value(boolean z) throws java.io.IOException {
        put(new io.dcloud.uts.gson.JsonPrimitive(java.lang.Boolean.valueOf(z)));
        return this;
    }

    @Override // io.dcloud.uts.gson.stream.JsonWriter
    public io.dcloud.uts.gson.stream.JsonWriter value(java.lang.Boolean bool) throws java.io.IOException {
        if (bool == null) {
            return nullValue();
        }
        put(new io.dcloud.uts.gson.JsonPrimitive(bool));
        return this;
    }

    @Override // io.dcloud.uts.gson.stream.JsonWriter
    public io.dcloud.uts.gson.stream.JsonWriter value(double d) throws java.io.IOException {
        if (!isLenient() && (java.lang.Double.isNaN(d) || java.lang.Double.isInfinite(d))) {
            throw new java.lang.IllegalArgumentException("JSON forbids NaN and infinities: " + d);
        }
        put(new io.dcloud.uts.gson.JsonPrimitive(java.lang.Double.valueOf(d)));
        return this;
    }

    @Override // io.dcloud.uts.gson.stream.JsonWriter
    public io.dcloud.uts.gson.stream.JsonWriter value(long j) throws java.io.IOException {
        put(new io.dcloud.uts.gson.JsonPrimitive(java.lang.Long.valueOf(j)));
        return this;
    }

    @Override // io.dcloud.uts.gson.stream.JsonWriter
    public io.dcloud.uts.gson.stream.JsonWriter value(java.lang.Number number) throws java.io.IOException {
        if (number == null) {
            return nullValue();
        }
        if (!isLenient()) {
            double dDoubleValue = number.doubleValue();
            if (java.lang.Double.isNaN(dDoubleValue) || java.lang.Double.isInfinite(dDoubleValue)) {
                throw new java.lang.IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        put(new io.dcloud.uts.gson.JsonPrimitive(number));
        return this;
    }

    @Override // io.dcloud.uts.gson.stream.JsonWriter, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        if (!this.stack.isEmpty()) {
            throw new java.io.IOException("Incomplete document");
        }
        this.stack.add(SENTINEL_CLOSED);
    }
}
