package io.dcloud.uts.gson;

/* JADX INFO: loaded from: classes2.dex */
public abstract class TypeAdapter<T> {
    /* JADX INFO: renamed from: read */
    public abstract T read2(io.dcloud.uts.gson.stream.JsonReader jsonReader) throws java.io.IOException;

    public void reset() {
    }

    public abstract void write(io.dcloud.uts.gson.stream.JsonWriter jsonWriter, T t) throws java.io.IOException;

    public final void toJson(java.io.Writer writer, T t) throws java.io.IOException {
        write(new io.dcloud.uts.gson.stream.JsonWriter(writer), t);
    }

    public final io.dcloud.uts.gson.TypeAdapter<T> nullSafe() {
        return new io.dcloud.uts.gson.TypeAdapter<T>() { // from class: io.dcloud.uts.gson.TypeAdapter.1
            @Override // io.dcloud.uts.gson.TypeAdapter
            public void write(io.dcloud.uts.gson.stream.JsonWriter jsonWriter, T t) throws java.io.IOException {
                if (t == null) {
                    jsonWriter.nullValue();
                } else {
                    io.dcloud.uts.gson.TypeAdapter.this.write(jsonWriter, t);
                }
            }

            @Override // io.dcloud.uts.gson.TypeAdapter
            /* JADX INFO: renamed from: read */
            public T read2(io.dcloud.uts.gson.stream.JsonReader jsonReader) throws java.io.IOException {
                if (jsonReader.peek() == io.dcloud.uts.gson.stream.JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                return (T) io.dcloud.uts.gson.TypeAdapter.this.read2(jsonReader);
            }
        };
    }

    public final java.lang.String toJson(T t) {
        java.io.StringWriter stringWriter = new java.io.StringWriter();
        try {
            toJson(stringWriter, t);
            return stringWriter.toString();
        } catch (java.io.IOException e) {
            throw new java.lang.AssertionError(e);
        }
    }

    public final io.dcloud.uts.gson.JsonElement toJsonTree(T t) {
        try {
            io.dcloud.uts.gson.internal.bind.JsonTreeWriter jsonTreeWriter = new io.dcloud.uts.gson.internal.bind.JsonTreeWriter();
            write(jsonTreeWriter, t);
            return jsonTreeWriter.get();
        } catch (java.io.IOException e) {
            throw new io.dcloud.uts.gson.JsonIOException(e);
        }
    }

    public final T fromJson(java.io.Reader reader) throws java.io.IOException {
        return read2(new io.dcloud.uts.gson.stream.JsonReader(reader));
    }

    public final T fromJson(java.lang.String str) throws java.io.IOException {
        return fromJson(new java.io.StringReader(str));
    }

    public final T fromJsonTree(io.dcloud.uts.gson.JsonElement jsonElement) {
        try {
            return read2(new io.dcloud.uts.gson.internal.bind.JsonTreeReader(jsonElement));
        } catch (java.io.IOException e) {
            throw new io.dcloud.uts.gson.JsonIOException(e);
        }
    }
}
