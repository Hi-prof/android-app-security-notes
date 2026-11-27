package io.dcloud.uts.gson.internal.bind;

/* JADX INFO: loaded from: classes2.dex */
final class TypeAdapterRuntimeTypeWrapper<T> extends io.dcloud.uts.gson.TypeAdapter<T> {
    private final io.dcloud.uts.gson.Gson context;
    private final io.dcloud.uts.gson.TypeAdapter<T> delegate;
    private final java.lang.reflect.Type type;

    TypeAdapterRuntimeTypeWrapper(io.dcloud.uts.gson.Gson gson, io.dcloud.uts.gson.TypeAdapter<T> typeAdapter, java.lang.reflect.Type type) {
        this.context = gson;
        this.delegate = typeAdapter;
        this.type = type;
    }

    @Override // io.dcloud.uts.gson.TypeAdapter
    /* JADX INFO: renamed from: read */
    public T read2(io.dcloud.uts.gson.stream.JsonReader jsonReader) throws java.io.IOException {
        return this.delegate.read2(jsonReader);
    }

    @Override // io.dcloud.uts.gson.TypeAdapter
    public void write(io.dcloud.uts.gson.stream.JsonWriter jsonWriter, T t) throws java.io.IOException {
        io.dcloud.uts.gson.TypeAdapter<T> adapter = this.delegate;
        java.lang.reflect.Type runtimeTypeIfMoreSpecific = getRuntimeTypeIfMoreSpecific(this.type, t);
        if (runtimeTypeIfMoreSpecific != this.type) {
            adapter = this.context.getAdapter(io.dcloud.uts.gson.reflect.TypeToken.get(runtimeTypeIfMoreSpecific));
            if (adapter instanceof io.dcloud.uts.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter) {
                io.dcloud.uts.gson.TypeAdapter<T> typeAdapter = this.delegate;
                if (!(typeAdapter instanceof io.dcloud.uts.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter)) {
                    adapter = typeAdapter;
                }
            }
        }
        adapter.write(jsonWriter, t);
    }

    private java.lang.reflect.Type getRuntimeTypeIfMoreSpecific(java.lang.reflect.Type type, java.lang.Object obj) {
        if (obj != null) {
            return (type == java.lang.Object.class || (type instanceof java.lang.reflect.TypeVariable) || (type instanceof java.lang.Class)) ? obj.getClass() : type;
        }
        return type;
    }
}
