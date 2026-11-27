package io.dcloud.uts.gson.internal.bind;

/* JADX INFO: loaded from: classes2.dex */
public final class TreeTypeAdapter<T> extends io.dcloud.uts.gson.TypeAdapter<T> {
    private final io.dcloud.uts.gson.internal.bind.TreeTypeAdapter<T>.GsonContextImpl context = new io.dcloud.uts.gson.internal.bind.TreeTypeAdapter.GsonContextImpl();
    private io.dcloud.uts.gson.TypeAdapter<T> delegate;
    private final io.dcloud.uts.gson.JsonDeserializer<T> deserializer;
    final io.dcloud.uts.gson.Gson gson;
    private final io.dcloud.uts.gson.JsonSerializer<T> serializer;
    private final io.dcloud.uts.gson.TypeAdapterFactory skipPast;
    private final io.dcloud.uts.gson.reflect.TypeToken<T> typeToken;

    public TreeTypeAdapter(io.dcloud.uts.gson.JsonSerializer<T> jsonSerializer, io.dcloud.uts.gson.JsonDeserializer<T> jsonDeserializer, io.dcloud.uts.gson.Gson gson, io.dcloud.uts.gson.reflect.TypeToken<T> typeToken, io.dcloud.uts.gson.TypeAdapterFactory typeAdapterFactory) {
        this.serializer = jsonSerializer;
        this.deserializer = jsonDeserializer;
        this.gson = gson;
        this.typeToken = typeToken;
        this.skipPast = typeAdapterFactory;
    }

    @Override // io.dcloud.uts.gson.TypeAdapter
    /* JADX INFO: renamed from: read */
    public T read2(io.dcloud.uts.gson.stream.JsonReader jsonReader) throws java.io.IOException {
        if (this.deserializer == null) {
            return delegate().read2(jsonReader);
        }
        io.dcloud.uts.gson.JsonElement jsonElement = io.dcloud.uts.gson.internal.Streams.parse(jsonReader);
        if (jsonElement.isJsonNull()) {
            return null;
        }
        return this.deserializer.deserialize(jsonElement, this.typeToken.getType(), this.context);
    }

    @Override // io.dcloud.uts.gson.TypeAdapter
    public void write(io.dcloud.uts.gson.stream.JsonWriter jsonWriter, T t) throws java.io.IOException {
        io.dcloud.uts.gson.JsonSerializer<T> jsonSerializer = this.serializer;
        if (jsonSerializer == null) {
            delegate().write(jsonWriter, t);
        } else if (t == null) {
            jsonWriter.nullValue();
        } else {
            io.dcloud.uts.gson.internal.Streams.write(jsonSerializer.serialize(t, this.typeToken.getType(), this.context), jsonWriter);
        }
    }

    private io.dcloud.uts.gson.TypeAdapter<T> delegate() {
        io.dcloud.uts.gson.TypeAdapter<T> typeAdapter = this.delegate;
        if (typeAdapter != null) {
            return typeAdapter;
        }
        io.dcloud.uts.gson.TypeAdapter<T> delegateAdapter = this.gson.getDelegateAdapter(this.skipPast, this.typeToken);
        this.delegate = delegateAdapter;
        return delegateAdapter;
    }

    public static io.dcloud.uts.gson.TypeAdapterFactory newFactory(io.dcloud.uts.gson.reflect.TypeToken<?> typeToken, java.lang.Object obj) {
        return new io.dcloud.uts.gson.internal.bind.TreeTypeAdapter.SingleTypeFactory(obj, typeToken, false, null);
    }

    public static io.dcloud.uts.gson.TypeAdapterFactory newFactoryWithMatchRawType(io.dcloud.uts.gson.reflect.TypeToken<?> typeToken, java.lang.Object obj) {
        return new io.dcloud.uts.gson.internal.bind.TreeTypeAdapter.SingleTypeFactory(obj, typeToken, typeToken.getType() == typeToken.getRawType(), null);
    }

    public static io.dcloud.uts.gson.TypeAdapterFactory newTypeHierarchyFactory(java.lang.Class<?> cls, java.lang.Object obj) {
        return new io.dcloud.uts.gson.internal.bind.TreeTypeAdapter.SingleTypeFactory(obj, null, false, cls);
    }

    private static final class SingleTypeFactory implements io.dcloud.uts.gson.TypeAdapterFactory {
        private final io.dcloud.uts.gson.JsonDeserializer<?> deserializer;
        private final io.dcloud.uts.gson.reflect.TypeToken<?> exactType;
        private final java.lang.Class<?> hierarchyType;
        private final boolean matchRawType;
        private final io.dcloud.uts.gson.JsonSerializer<?> serializer;

        SingleTypeFactory(java.lang.Object obj, io.dcloud.uts.gson.reflect.TypeToken<?> typeToken, boolean z, java.lang.Class<?> cls) {
            io.dcloud.uts.gson.JsonSerializer<?> jsonSerializer = obj instanceof io.dcloud.uts.gson.JsonSerializer ? (io.dcloud.uts.gson.JsonSerializer) obj : null;
            this.serializer = jsonSerializer;
            io.dcloud.uts.gson.JsonDeserializer<?> jsonDeserializer = obj instanceof io.dcloud.uts.gson.JsonDeserializer ? (io.dcloud.uts.gson.JsonDeserializer) obj : null;
            this.deserializer = jsonDeserializer;
            io.dcloud.uts.gson.internal.C$Gson$Preconditions.checkArgument((jsonSerializer == null && jsonDeserializer == null) ? false : true);
            this.exactType = typeToken;
            this.matchRawType = z;
            this.hierarchyType = cls;
        }

        @Override // io.dcloud.uts.gson.TypeAdapterFactory
        public <T> io.dcloud.uts.gson.TypeAdapter<T> create(io.dcloud.uts.gson.Gson gson, io.dcloud.uts.gson.reflect.TypeToken<T> typeToken) {
            boolean zIsAssignableFrom;
            io.dcloud.uts.gson.reflect.TypeToken<?> typeToken2 = this.exactType;
            if (typeToken2 != null) {
                zIsAssignableFrom = typeToken2.equals(typeToken) || (this.matchRawType && this.exactType.getType() == typeToken.getRawType());
            } else {
                zIsAssignableFrom = this.hierarchyType.isAssignableFrom(typeToken.getRawType());
            }
            if (zIsAssignableFrom) {
                return new io.dcloud.uts.gson.internal.bind.TreeTypeAdapter(this.serializer, this.deserializer, gson, typeToken, this);
            }
            return null;
        }
    }

    private final class GsonContextImpl implements io.dcloud.uts.gson.JsonSerializationContext, io.dcloud.uts.gson.JsonDeserializationContext {
        private GsonContextImpl() {
        }

        @Override // io.dcloud.uts.gson.JsonSerializationContext
        public io.dcloud.uts.gson.JsonElement serialize(java.lang.Object obj) {
            return io.dcloud.uts.gson.internal.bind.TreeTypeAdapter.this.gson.toJsonTree(obj);
        }

        @Override // io.dcloud.uts.gson.JsonSerializationContext
        public io.dcloud.uts.gson.JsonElement serialize(java.lang.Object obj, java.lang.reflect.Type type) {
            return io.dcloud.uts.gson.internal.bind.TreeTypeAdapter.this.gson.toJsonTree(obj, type);
        }

        @Override // io.dcloud.uts.gson.JsonDeserializationContext
        public <R> R deserialize(io.dcloud.uts.gson.JsonElement jsonElement, java.lang.reflect.Type type) throws io.dcloud.uts.gson.JsonParseException {
            return (R) io.dcloud.uts.gson.internal.bind.TreeTypeAdapter.this.gson.fromJson(jsonElement, type);
        }
    }
}
