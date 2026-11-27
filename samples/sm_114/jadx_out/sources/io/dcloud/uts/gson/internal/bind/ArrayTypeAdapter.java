package io.dcloud.uts.gson.internal.bind;

/* JADX INFO: loaded from: classes2.dex */
public final class ArrayTypeAdapter<E> extends io.dcloud.uts.gson.TypeAdapter<java.lang.Object> {
    public static final io.dcloud.uts.gson.TypeAdapterFactory FACTORY = new io.dcloud.uts.gson.TypeAdapterFactory() { // from class: io.dcloud.uts.gson.internal.bind.ArrayTypeAdapter.1
        @Override // io.dcloud.uts.gson.TypeAdapterFactory
        public <T> io.dcloud.uts.gson.TypeAdapter<T> create(io.dcloud.uts.gson.Gson gson, io.dcloud.uts.gson.reflect.TypeToken<T> typeToken) {
            java.lang.reflect.Type type = typeToken.getType();
            if (!(type instanceof java.lang.reflect.GenericArrayType) && (!(type instanceof java.lang.Class) || !((java.lang.Class) type).isArray())) {
                return null;
            }
            java.lang.reflect.Type arrayComponentType = io.dcloud.uts.gson.internal.C$Gson$Types.getArrayComponentType(type);
            return new io.dcloud.uts.gson.internal.bind.ArrayTypeAdapter(gson, gson.getAdapter(io.dcloud.uts.gson.reflect.TypeToken.get(arrayComponentType)), io.dcloud.uts.gson.internal.C$Gson$Types.getRawType(arrayComponentType));
        }
    };
    private final java.lang.Class<E> componentType;
    private final io.dcloud.uts.gson.TypeAdapter<E> componentTypeAdapter;

    public ArrayTypeAdapter(io.dcloud.uts.gson.Gson gson, io.dcloud.uts.gson.TypeAdapter<E> typeAdapter, java.lang.Class<E> cls) {
        this.componentTypeAdapter = new io.dcloud.uts.gson.internal.bind.TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, cls);
        this.componentType = cls;
    }

    @Override // io.dcloud.uts.gson.TypeAdapter
    /* JADX INFO: renamed from: read */
    public java.lang.Object read2(io.dcloud.uts.gson.stream.JsonReader jsonReader) throws java.io.IOException {
        if (jsonReader.peek() == io.dcloud.uts.gson.stream.JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            arrayList.add(this.componentTypeAdapter.read2(jsonReader));
        }
        jsonReader.endArray();
        int size = arrayList.size();
        java.lang.Object objNewInstance = java.lang.reflect.Array.newInstance((java.lang.Class<?>) this.componentType, size);
        for (int i = 0; i < size; i++) {
            java.lang.reflect.Array.set(objNewInstance, i, arrayList.get(i));
        }
        return objNewInstance;
    }

    @Override // io.dcloud.uts.gson.TypeAdapter
    public void write(io.dcloud.uts.gson.stream.JsonWriter jsonWriter, java.lang.Object obj) throws java.io.IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        jsonWriter.beginArray();
        int length = java.lang.reflect.Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            this.componentTypeAdapter.write(jsonWriter, (E) java.lang.reflect.Array.get(obj, i));
        }
        jsonWriter.endArray();
    }
}
