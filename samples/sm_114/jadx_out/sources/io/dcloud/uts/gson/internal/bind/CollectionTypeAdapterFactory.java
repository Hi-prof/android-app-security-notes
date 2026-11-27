package io.dcloud.uts.gson.internal.bind;

/* JADX INFO: loaded from: classes2.dex */
public final class CollectionTypeAdapterFactory implements io.dcloud.uts.gson.TypeAdapterFactory {
    private final io.dcloud.uts.gson.internal.ConstructorConstructor constructorConstructor;

    public CollectionTypeAdapterFactory(io.dcloud.uts.gson.internal.ConstructorConstructor constructorConstructor) {
        this.constructorConstructor = constructorConstructor;
    }

    @Override // io.dcloud.uts.gson.TypeAdapterFactory
    public <T> io.dcloud.uts.gson.TypeAdapter<T> create(io.dcloud.uts.gson.Gson gson, io.dcloud.uts.gson.reflect.TypeToken<T> typeToken) {
        java.lang.reflect.Type type = typeToken.getType();
        java.lang.Class<? super T> rawType = typeToken.getRawType();
        if (!java.util.Collection.class.isAssignableFrom(rawType)) {
            return null;
        }
        java.lang.reflect.Type collectionElementType = io.dcloud.uts.gson.internal.C$Gson$Types.getCollectionElementType(type, rawType);
        return new io.dcloud.uts.gson.internal.bind.CollectionTypeAdapterFactory.Adapter(gson, collectionElementType, gson.getAdapter(io.dcloud.uts.gson.reflect.TypeToken.get(collectionElementType)), this.constructorConstructor.get(typeToken));
    }

    private static final class Adapter<E> extends io.dcloud.uts.gson.TypeAdapter<java.util.Collection<E>> {
        private final io.dcloud.uts.gson.internal.ObjectConstructor<? extends java.util.Collection<E>> constructor;
        private final io.dcloud.uts.gson.TypeAdapter<E> elementTypeAdapter;

        public Adapter(io.dcloud.uts.gson.Gson gson, java.lang.reflect.Type type, io.dcloud.uts.gson.TypeAdapter<E> typeAdapter, io.dcloud.uts.gson.internal.ObjectConstructor<? extends java.util.Collection<E>> objectConstructor) {
            this.elementTypeAdapter = new io.dcloud.uts.gson.internal.bind.TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, type);
            this.constructor = objectConstructor;
        }

        @Override // io.dcloud.uts.gson.TypeAdapter
        /* JADX INFO: renamed from: read */
        public java.util.Collection<E> read2(io.dcloud.uts.gson.stream.JsonReader jsonReader) throws java.io.IOException {
            if (jsonReader.peek() == io.dcloud.uts.gson.stream.JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            java.util.Collection<E> collectionConstruct = this.constructor.construct();
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                collectionConstruct.add(this.elementTypeAdapter.read2(jsonReader));
            }
            jsonReader.endArray();
            return collectionConstruct;
        }

        @Override // io.dcloud.uts.gson.TypeAdapter
        public void write(io.dcloud.uts.gson.stream.JsonWriter jsonWriter, java.util.Collection<E> collection) throws java.io.IOException {
            if (collection == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginArray();
            java.util.Iterator<E> it = collection.iterator();
            while (it.hasNext()) {
                this.elementTypeAdapter.write(jsonWriter, it.next());
            }
            jsonWriter.endArray();
        }
    }
}
