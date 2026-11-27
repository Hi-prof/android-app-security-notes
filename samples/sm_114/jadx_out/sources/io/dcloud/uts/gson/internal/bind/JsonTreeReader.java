package io.dcloud.uts.gson.internal.bind;

/* JADX INFO: loaded from: classes2.dex */
public final class JsonTreeReader extends io.dcloud.uts.gson.stream.JsonReader {
    private int[] pathIndices;
    private java.lang.String[] pathNames;
    private java.lang.Object[] stack;
    private int stackSize;
    private static final java.io.Reader UNREADABLE_READER = new java.io.Reader() { // from class: io.dcloud.uts.gson.internal.bind.JsonTreeReader.1
        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws java.io.IOException {
            throw new java.lang.AssertionError();
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws java.io.IOException {
            throw new java.lang.AssertionError();
        }
    };
    private static final java.lang.Object SENTINEL_CLOSED = new java.lang.Object();

    public JsonTreeReader(io.dcloud.uts.gson.JsonElement jsonElement) {
        super(UNREADABLE_READER);
        this.stack = new java.lang.Object[32];
        this.stackSize = 0;
        this.pathNames = new java.lang.String[32];
        this.pathIndices = new int[32];
        push(jsonElement);
    }

    @Override // io.dcloud.uts.gson.stream.JsonReader
    public void beginArray() throws java.io.IOException {
        expect(io.dcloud.uts.gson.stream.JsonToken.BEGIN_ARRAY);
        push(((io.dcloud.uts.gson.JsonArray) peekStack()).iterator());
        this.pathIndices[this.stackSize - 1] = 0;
    }

    @Override // io.dcloud.uts.gson.stream.JsonReader
    public void endArray() throws java.io.IOException {
        expect(io.dcloud.uts.gson.stream.JsonToken.END_ARRAY);
        popStack();
        popStack();
        int i = this.stackSize;
        if (i > 0) {
            int[] iArr = this.pathIndices;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
    }

    @Override // io.dcloud.uts.gson.stream.JsonReader
    public void beginObject() throws java.io.IOException {
        expect(io.dcloud.uts.gson.stream.JsonToken.BEGIN_OBJECT);
        push(((io.dcloud.uts.gson.JsonObject) peekStack()).entrySet().iterator());
    }

    @Override // io.dcloud.uts.gson.stream.JsonReader
    public void endObject() throws java.io.IOException {
        expect(io.dcloud.uts.gson.stream.JsonToken.END_OBJECT);
        popStack();
        popStack();
        int i = this.stackSize;
        if (i > 0) {
            int[] iArr = this.pathIndices;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
    }

    @Override // io.dcloud.uts.gson.stream.JsonReader
    public boolean hasNext() throws java.io.IOException {
        io.dcloud.uts.gson.stream.JsonToken jsonTokenPeek = peek();
        return (jsonTokenPeek == io.dcloud.uts.gson.stream.JsonToken.END_OBJECT || jsonTokenPeek == io.dcloud.uts.gson.stream.JsonToken.END_ARRAY) ? false : true;
    }

    @Override // io.dcloud.uts.gson.stream.JsonReader
    public io.dcloud.uts.gson.stream.JsonToken peek() throws java.io.IOException {
        if (this.stackSize == 0) {
            return io.dcloud.uts.gson.stream.JsonToken.END_DOCUMENT;
        }
        java.lang.Object objPeekStack = peekStack();
        if (objPeekStack instanceof java.util.Iterator) {
            boolean z = this.stack[this.stackSize - 2] instanceof io.dcloud.uts.gson.JsonObject;
            java.util.Iterator it = (java.util.Iterator) objPeekStack;
            if (!it.hasNext()) {
                return z ? io.dcloud.uts.gson.stream.JsonToken.END_OBJECT : io.dcloud.uts.gson.stream.JsonToken.END_ARRAY;
            }
            if (z) {
                return io.dcloud.uts.gson.stream.JsonToken.NAME;
            }
            push(it.next());
            return peek();
        }
        if (objPeekStack instanceof io.dcloud.uts.gson.JsonObject) {
            return io.dcloud.uts.gson.stream.JsonToken.BEGIN_OBJECT;
        }
        if (objPeekStack instanceof io.dcloud.uts.gson.JsonArray) {
            return io.dcloud.uts.gson.stream.JsonToken.BEGIN_ARRAY;
        }
        if (objPeekStack instanceof io.dcloud.uts.gson.JsonPrimitive) {
            io.dcloud.uts.gson.JsonPrimitive jsonPrimitive = (io.dcloud.uts.gson.JsonPrimitive) objPeekStack;
            if (jsonPrimitive.isString()) {
                return io.dcloud.uts.gson.stream.JsonToken.STRING;
            }
            if (jsonPrimitive.isBoolean()) {
                return io.dcloud.uts.gson.stream.JsonToken.BOOLEAN;
            }
            if (jsonPrimitive.isNumber()) {
                return io.dcloud.uts.gson.stream.JsonToken.NUMBER;
            }
            throw new java.lang.AssertionError();
        }
        if (objPeekStack instanceof io.dcloud.uts.gson.JsonNull) {
            return io.dcloud.uts.gson.stream.JsonToken.NULL;
        }
        if (objPeekStack == SENTINEL_CLOSED) {
            throw new java.lang.IllegalStateException("JsonReader is closed");
        }
        throw new java.lang.AssertionError();
    }

    private java.lang.Object peekStack() {
        return this.stack[this.stackSize - 1];
    }

    private java.lang.Object popStack() {
        java.lang.Object[] objArr = this.stack;
        int i = this.stackSize - 1;
        this.stackSize = i;
        java.lang.Object obj = objArr[i];
        objArr[i] = null;
        return obj;
    }

    private void expect(io.dcloud.uts.gson.stream.JsonToken jsonToken) throws java.io.IOException {
        if (peek() == jsonToken) {
            return;
        }
        throw new java.lang.IllegalStateException("Expected " + jsonToken + " but was " + peek() + locationString());
    }

    @Override // io.dcloud.uts.gson.stream.JsonReader
    public java.lang.String nextName() throws java.io.IOException {
        expect(io.dcloud.uts.gson.stream.JsonToken.NAME);
        java.util.Map.Entry entry = (java.util.Map.Entry) ((java.util.Iterator) peekStack()).next();
        java.lang.String str = (java.lang.String) entry.getKey();
        this.pathNames[this.stackSize - 1] = str;
        push(entry.getValue());
        return str;
    }

    @Override // io.dcloud.uts.gson.stream.JsonReader
    public java.lang.String nextString() throws java.io.IOException {
        io.dcloud.uts.gson.stream.JsonToken jsonTokenPeek = peek();
        if (jsonTokenPeek != io.dcloud.uts.gson.stream.JsonToken.STRING && jsonTokenPeek != io.dcloud.uts.gson.stream.JsonToken.NUMBER) {
            throw new java.lang.IllegalStateException("Expected " + io.dcloud.uts.gson.stream.JsonToken.STRING + " but was " + jsonTokenPeek + locationString());
        }
        java.lang.String asString = ((io.dcloud.uts.gson.JsonPrimitive) popStack()).getAsString();
        int i = this.stackSize;
        if (i > 0) {
            int[] iArr = this.pathIndices;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return asString;
    }

    @Override // io.dcloud.uts.gson.stream.JsonReader
    public boolean nextBoolean() throws java.io.IOException {
        expect(io.dcloud.uts.gson.stream.JsonToken.BOOLEAN);
        boolean asBoolean = ((io.dcloud.uts.gson.JsonPrimitive) popStack()).getAsBoolean();
        int i = this.stackSize;
        if (i > 0) {
            int[] iArr = this.pathIndices;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return asBoolean;
    }

    @Override // io.dcloud.uts.gson.stream.JsonReader
    public void nextNull() throws java.io.IOException {
        expect(io.dcloud.uts.gson.stream.JsonToken.NULL);
        popStack();
        int i = this.stackSize;
        if (i > 0) {
            int[] iArr = this.pathIndices;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
    }

    @Override // io.dcloud.uts.gson.stream.JsonReader
    public double nextDouble() throws java.io.IOException {
        io.dcloud.uts.gson.stream.JsonToken jsonTokenPeek = peek();
        if (jsonTokenPeek != io.dcloud.uts.gson.stream.JsonToken.NUMBER && jsonTokenPeek != io.dcloud.uts.gson.stream.JsonToken.STRING) {
            throw new java.lang.IllegalStateException("Expected " + io.dcloud.uts.gson.stream.JsonToken.NUMBER + " but was " + jsonTokenPeek + locationString());
        }
        double asDouble = ((io.dcloud.uts.gson.JsonPrimitive) peekStack()).getAsDouble();
        if (!isLenient() && (java.lang.Double.isNaN(asDouble) || java.lang.Double.isInfinite(asDouble))) {
            throw new java.lang.NumberFormatException("JSON forbids NaN and infinities: " + asDouble);
        }
        popStack();
        int i = this.stackSize;
        if (i > 0) {
            int[] iArr = this.pathIndices;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return asDouble;
    }

    @Override // io.dcloud.uts.gson.stream.JsonReader
    public long nextLong() throws java.io.IOException {
        io.dcloud.uts.gson.stream.JsonToken jsonTokenPeek = peek();
        if (jsonTokenPeek != io.dcloud.uts.gson.stream.JsonToken.NUMBER && jsonTokenPeek != io.dcloud.uts.gson.stream.JsonToken.STRING) {
            throw new java.lang.IllegalStateException("Expected " + io.dcloud.uts.gson.stream.JsonToken.NUMBER + " but was " + jsonTokenPeek + locationString());
        }
        long asLong = ((io.dcloud.uts.gson.JsonPrimitive) peekStack()).getAsLong();
        popStack();
        int i = this.stackSize;
        if (i > 0) {
            int[] iArr = this.pathIndices;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return asLong;
    }

    @Override // io.dcloud.uts.gson.stream.JsonReader
    public int nextInt() throws java.io.IOException {
        io.dcloud.uts.gson.stream.JsonToken jsonTokenPeek = peek();
        if (jsonTokenPeek != io.dcloud.uts.gson.stream.JsonToken.NUMBER && jsonTokenPeek != io.dcloud.uts.gson.stream.JsonToken.STRING) {
            throw new java.lang.IllegalStateException("Expected " + io.dcloud.uts.gson.stream.JsonToken.NUMBER + " but was " + jsonTokenPeek + locationString());
        }
        int asInt = ((io.dcloud.uts.gson.JsonPrimitive) peekStack()).getAsInt();
        popStack();
        int i = this.stackSize;
        if (i > 0) {
            int[] iArr = this.pathIndices;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return asInt;
    }

    io.dcloud.uts.gson.JsonElement nextJsonElement() throws java.io.IOException {
        io.dcloud.uts.gson.stream.JsonToken jsonTokenPeek = peek();
        if (jsonTokenPeek == io.dcloud.uts.gson.stream.JsonToken.NAME || jsonTokenPeek == io.dcloud.uts.gson.stream.JsonToken.END_ARRAY || jsonTokenPeek == io.dcloud.uts.gson.stream.JsonToken.END_OBJECT || jsonTokenPeek == io.dcloud.uts.gson.stream.JsonToken.END_DOCUMENT) {
            throw new java.lang.IllegalStateException("Unexpected " + jsonTokenPeek + " when reading a JsonElement.");
        }
        io.dcloud.uts.gson.JsonElement jsonElement = (io.dcloud.uts.gson.JsonElement) peekStack();
        skipValue();
        return jsonElement;
    }

    @Override // io.dcloud.uts.gson.stream.JsonReader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        this.stack = new java.lang.Object[]{SENTINEL_CLOSED};
        this.stackSize = 1;
    }

    @Override // io.dcloud.uts.gson.stream.JsonReader
    public void skipValue() throws java.io.IOException {
        if (peek() == io.dcloud.uts.gson.stream.JsonToken.NAME) {
            nextName();
            this.pathNames[this.stackSize - 2] = "null";
        } else {
            popStack();
            int i = this.stackSize;
            if (i > 0) {
                this.pathNames[i - 1] = "null";
            }
        }
        int i2 = this.stackSize;
        if (i2 > 0) {
            int[] iArr = this.pathIndices;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
    }

    @Override // io.dcloud.uts.gson.stream.JsonReader
    public java.lang.String toString() {
        return getClass().getSimpleName() + locationString();
    }

    public void promoteNameToValue() throws java.io.IOException {
        expect(io.dcloud.uts.gson.stream.JsonToken.NAME);
        java.util.Map.Entry entry = (java.util.Map.Entry) ((java.util.Iterator) peekStack()).next();
        push(entry.getValue());
        push(new io.dcloud.uts.gson.JsonPrimitive((java.lang.String) entry.getKey()));
    }

    private void push(java.lang.Object obj) {
        int i = this.stackSize;
        java.lang.Object[] objArr = this.stack;
        if (i == objArr.length) {
            int i2 = i * 2;
            this.stack = java.util.Arrays.copyOf(objArr, i2);
            this.pathIndices = java.util.Arrays.copyOf(this.pathIndices, i2);
            this.pathNames = (java.lang.String[]) java.util.Arrays.copyOf(this.pathNames, i2);
        }
        java.lang.Object[] objArr2 = this.stack;
        int i3 = this.stackSize;
        this.stackSize = i3 + 1;
        objArr2[i3] = obj;
    }

    @Override // io.dcloud.uts.gson.stream.JsonReader
    public java.lang.String getPath() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(com.taobao.weex.el.parse.Operators.DOLLAR_STR);
        int i = 0;
        while (true) {
            int i2 = this.stackSize;
            if (i < i2) {
                java.lang.Object[] objArr = this.stack;
                java.lang.Object obj = objArr[i];
                if (obj instanceof io.dcloud.uts.gson.JsonArray) {
                    i++;
                    if (i < i2 && (objArr[i] instanceof java.util.Iterator)) {
                        sb.append(com.taobao.weex.el.parse.Operators.ARRAY_START);
                        sb.append(this.pathIndices[i]);
                        sb.append(com.taobao.weex.el.parse.Operators.ARRAY_END);
                    }
                } else if ((obj instanceof io.dcloud.uts.gson.JsonObject) && (i = i + 1) < i2 && (objArr[i] instanceof java.util.Iterator)) {
                    sb.append(com.taobao.weex.el.parse.Operators.DOT);
                    java.lang.String str = this.pathNames[i];
                    if (str != null) {
                        sb.append(str);
                    }
                }
                i++;
            } else {
                return sb.toString();
            }
        }
    }

    private java.lang.String locationString() {
        return " at path " + getPath();
    }
}
