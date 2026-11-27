package io.dcloud.uts.gson.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class Streams {
    private Streams() {
        throw new java.lang.UnsupportedOperationException();
    }

    public static io.dcloud.uts.gson.JsonElement parse(io.dcloud.uts.gson.stream.JsonReader jsonReader) throws io.dcloud.uts.gson.JsonParseException {
        boolean z;
        try {
            try {
                jsonReader.peek();
                z = false;
                try {
                    return io.dcloud.uts.gson.internal.bind.TypeAdapters.JSON_ELEMENT.read2(jsonReader);
                } catch (java.io.EOFException e) {
                    e = e;
                    if (z) {
                        return io.dcloud.uts.gson.JsonNull.INSTANCE;
                    }
                    throw new io.dcloud.uts.gson.JsonSyntaxException(e);
                }
            } catch (java.io.EOFException e2) {
                e = e2;
                z = true;
            }
        } catch (io.dcloud.uts.gson.stream.MalformedJsonException e3) {
            throw new io.dcloud.uts.gson.JsonSyntaxException(e3);
        } catch (java.io.IOException e4) {
            throw new io.dcloud.uts.gson.JsonIOException(e4);
        } catch (java.lang.NumberFormatException e5) {
            throw new io.dcloud.uts.gson.JsonSyntaxException(e5);
        }
    }

    public static void write(io.dcloud.uts.gson.JsonElement jsonElement, io.dcloud.uts.gson.stream.JsonWriter jsonWriter) throws java.io.IOException {
        io.dcloud.uts.gson.internal.bind.TypeAdapters.JSON_ELEMENT.write(jsonWriter, jsonElement);
    }

    public static java.io.Writer writerForAppendable(java.lang.Appendable appendable) {
        return appendable instanceof java.io.Writer ? (java.io.Writer) appendable : new io.dcloud.uts.gson.internal.Streams.AppendableWriter(appendable);
    }

    private static final class AppendableWriter extends java.io.Writer {
        private final java.lang.Appendable appendable;
        private final io.dcloud.uts.gson.internal.Streams.AppendableWriter.CurrentWrite currentWrite = new io.dcloud.uts.gson.internal.Streams.AppendableWriter.CurrentWrite();

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }

        AppendableWriter(java.lang.Appendable appendable) {
            this.appendable = appendable;
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) throws java.io.IOException {
            this.currentWrite.chars = cArr;
            this.appendable.append(this.currentWrite, i, i2 + i);
        }

        @Override // java.io.Writer
        public void write(int i) throws java.io.IOException {
            this.appendable.append((char) i);
        }

        static class CurrentWrite implements java.lang.CharSequence {
            char[] chars;

            CurrentWrite() {
            }

            @Override // java.lang.CharSequence
            public int length() {
                return this.chars.length;
            }

            @Override // java.lang.CharSequence
            public char charAt(int i) {
                return this.chars[i];
            }

            @Override // java.lang.CharSequence
            public java.lang.CharSequence subSequence(int i, int i2) {
                return new java.lang.String(this.chars, i, i2 - i);
            }
        }
    }
}
