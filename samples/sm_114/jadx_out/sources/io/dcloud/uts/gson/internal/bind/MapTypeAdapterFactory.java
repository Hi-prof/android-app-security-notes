package io.dcloud.uts.gson.internal.bind;

/* JADX INFO: loaded from: classes2.dex */
public final class MapTypeAdapterFactory implements io.dcloud.uts.gson.TypeAdapterFactory {
    final boolean complexMapKeySerialization;
    private final io.dcloud.uts.gson.internal.ConstructorConstructor constructorConstructor;

    public MapTypeAdapterFactory(io.dcloud.uts.gson.internal.ConstructorConstructor constructorConstructor, boolean z) {
        this.constructorConstructor = constructorConstructor;
        this.complexMapKeySerialization = z;
    }

    @Override // io.dcloud.uts.gson.TypeAdapterFactory
    public <T> io.dcloud.uts.gson.TypeAdapter<T> create(io.dcloud.uts.gson.Gson gson, io.dcloud.uts.gson.reflect.TypeToken<T> typeToken) {
        java.lang.reflect.Type type = typeToken.getType();
        if (!java.util.Map.class.isAssignableFrom(typeToken.getRawType())) {
            return null;
        }
        java.lang.reflect.Type[] mapKeyAndValueTypes = io.dcloud.uts.gson.internal.C$Gson$Types.getMapKeyAndValueTypes(type, io.dcloud.uts.gson.internal.C$Gson$Types.getRawType(type));
        return new io.dcloud.uts.gson.internal.bind.MapTypeAdapterFactory.Adapter(gson, mapKeyAndValueTypes[0], getKeyAdapter(gson, mapKeyAndValueTypes[0]), mapKeyAndValueTypes[1], gson.getAdapter(io.dcloud.uts.gson.reflect.TypeToken.get(mapKeyAndValueTypes[1])), this.constructorConstructor.get(typeToken));
    }

    private io.dcloud.uts.gson.TypeAdapter<?> getKeyAdapter(io.dcloud.uts.gson.Gson gson, java.lang.reflect.Type type) {
        if (type == java.lang.Boolean.TYPE || type == java.lang.Boolean.class) {
            return io.dcloud.uts.gson.internal.bind.TypeAdapters.BOOLEAN_AS_STRING;
        }
        return gson.getAdapter(io.dcloud.uts.gson.reflect.TypeToken.get(type));
    }

    private final class Adapter<K, V> extends io.dcloud.uts.gson.TypeAdapter<java.util.Map<K, V>> {
        private final io.dcloud.uts.gson.internal.ObjectConstructor<? extends java.util.Map<K, V>> constructor;
        private final io.dcloud.uts.gson.TypeAdapter<K> keyTypeAdapter;
        private final io.dcloud.uts.gson.TypeAdapter<V> valueTypeAdapter;

        public Adapter(io.dcloud.uts.gson.Gson gson, java.lang.reflect.Type type, io.dcloud.uts.gson.TypeAdapter<K> typeAdapter, java.lang.reflect.Type type2, io.dcloud.uts.gson.TypeAdapter<V> typeAdapter2, io.dcloud.uts.gson.internal.ObjectConstructor<? extends java.util.Map<K, V>> objectConstructor) {
            this.keyTypeAdapter = new io.dcloud.uts.gson.internal.bind.TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, type);
            this.valueTypeAdapter = new io.dcloud.uts.gson.internal.bind.TypeAdapterRuntimeTypeWrapper(gson, typeAdapter2, type2);
            this.constructor = objectConstructor;
        }

        @Override // io.dcloud.uts.gson.TypeAdapter
        /* JADX INFO: renamed from: read */
        public java.util.Map<K, V> read2(io.dcloud.uts.gson.stream.JsonReader jsonReader) throws java.io.IOException {
            io.dcloud.uts.gson.stream.JsonToken jsonTokenPeek = jsonReader.peek();
            if (jsonTokenPeek == io.dcloud.uts.gson.stream.JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            java.util.Map<K, V> mapConstruct = this.constructor.construct();
            if (jsonTokenPeek == io.dcloud.uts.gson.stream.JsonToken.BEGIN_ARRAY) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    jsonReader.beginArray();
                    K k = this.keyTypeAdapter.read2(jsonReader);
                    if (mapConstruct.put(k, this.valueTypeAdapter.read2(jsonReader)) != null) {
                        throw new io.dcloud.uts.gson.JsonSyntaxException("duplicate key: " + k);
                    }
                    jsonReader.endArray();
                }
                jsonReader.endArray();
                return mapConstruct;
            }
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                io.dcloud.uts.gson.internal.JsonReaderInternalAccess.INSTANCE.promoteNameToValue(jsonReader);
                K k2 = this.keyTypeAdapter.read2(jsonReader);
                if (mapConstruct.put(k2, this.valueTypeAdapter.read2(jsonReader)) != null) {
                    throw new io.dcloud.uts.gson.JsonSyntaxException("duplicate key: " + k2);
                }
            }
            jsonReader.endObject();
            return mapConstruct;
        }

        @Override // io.dcloud.uts.gson.TypeAdapter
        public void write(io.dcloud.uts.gson.stream.JsonWriter jsonWriter, java.util.Map<K, V> map) throws java.io.IOException {
            if (map == null) {
                jsonWriter.nullValue();
                return;
            }
            if (!io.dcloud.uts.gson.internal.bind.MapTypeAdapterFactory.this.complexMapKeySerialization) {
                jsonWriter.beginObject();
                for (java.util.Map.Entry<K, V> entry : map.entrySet()) {
                    jsonWriter.name(java.lang.String.valueOf(entry.getKey()));
                    this.valueTypeAdapter.write(jsonWriter, entry.getValue());
                }
                jsonWriter.endObject();
                return;
            }
            java.util.ArrayList arrayList = new java.util.ArrayList(map.size());
            java.util.ArrayList arrayList2 = new java.util.ArrayList(map.size());
            int i = 0;
            boolean z = false;
            for (java.util.Map.Entry<K, V> entry2 : map.entrySet()) {
                io.dcloud.uts.gson.JsonElement jsonTree = this.keyTypeAdapter.toJsonTree(entry2.getKey());
                arrayList.add(jsonTree);
                arrayList2.add(entry2.getValue());
                z |= jsonTree.isJsonArray() || jsonTree.isJsonObject();
            }
            if (z) {
                jsonWriter.beginArray();
                int size = arrayList.size();
                while (i < size) {
                    jsonWriter.beginArray();
                    io.dcloud.uts.gson.internal.Streams.write((io.dcloud.uts.gson.JsonElement) arrayList.get(i), jsonWriter);
                    this.valueTypeAdapter.write(jsonWriter, (V) arrayList2.get(i));
                    jsonWriter.endArray();
                    i++;
                }
                jsonWriter.endArray();
                return;
            }
            jsonWriter.beginObject();
            int size2 = arrayList.size();
            while (i < size2) {
                jsonWriter.name(keyToString((io.dcloud.uts.gson.JsonElement) arrayList.get(i)));
                this.valueTypeAdapter.write(jsonWriter, (V) arrayList2.get(i));
                i++;
            }
            jsonWriter.endObject();
        }

        private java.lang.String keyToString(io.dcloud.uts.gson.JsonElement jsonElement) {
            if (jsonElement.isJsonPrimitive()) {
                io.dcloud.uts.gson.JsonPrimitive asJsonPrimitive = jsonElement.getAsJsonPrimitive();
                if (asJsonPrimitive.isNumber()) {
                    return java.lang.String.valueOf(asJsonPrimitive.getAsNumber());
                }
                if (asJsonPrimitive.isBoolean()) {
                    return java.lang.Boolean.toString(asJsonPrimitive.getAsBoolean());
                }
                if (asJsonPrimitive.isString()) {
                    return asJsonPrimitive.getAsString();
                }
                throw new java.lang.AssertionError();
            }
            if (jsonElement.isJsonNull()) {
                return "null";
            }
            throw new java.lang.AssertionError();
        }
    }
}
