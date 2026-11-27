package io.dcloud.uts.gson.internal.bind;

/* JADX INFO: loaded from: classes2.dex */
public final class JsonAdapterAnnotationTypeAdapterFactory implements io.dcloud.uts.gson.TypeAdapterFactory {
    private final io.dcloud.uts.gson.internal.ConstructorConstructor constructorConstructor;

    public JsonAdapterAnnotationTypeAdapterFactory(io.dcloud.uts.gson.internal.ConstructorConstructor constructorConstructor) {
        this.constructorConstructor = constructorConstructor;
    }

    @Override // io.dcloud.uts.gson.TypeAdapterFactory
    public <T> io.dcloud.uts.gson.TypeAdapter<T> create(io.dcloud.uts.gson.Gson gson, io.dcloud.uts.gson.reflect.TypeToken<T> typeToken) {
        io.dcloud.uts.gson.annotations.JsonAdapter jsonAdapter = (io.dcloud.uts.gson.annotations.JsonAdapter) typeToken.getRawType().getAnnotation(io.dcloud.uts.gson.annotations.JsonAdapter.class);
        if (jsonAdapter == null) {
            return null;
        }
        return (io.dcloud.uts.gson.TypeAdapter<T>) getTypeAdapter(this.constructorConstructor, gson, typeToken, jsonAdapter);
    }

    io.dcloud.uts.gson.TypeAdapter<?> getTypeAdapter(io.dcloud.uts.gson.internal.ConstructorConstructor constructorConstructor, io.dcloud.uts.gson.Gson gson, io.dcloud.uts.gson.reflect.TypeToken<?> typeToken, io.dcloud.uts.gson.annotations.JsonAdapter jsonAdapter) {
        io.dcloud.uts.gson.TypeAdapter<?> treeTypeAdapter;
        java.lang.Object objConstruct = constructorConstructor.get(io.dcloud.uts.gson.reflect.TypeToken.get((java.lang.Class) jsonAdapter.value())).construct();
        if (objConstruct instanceof io.dcloud.uts.gson.TypeAdapter) {
            treeTypeAdapter = (io.dcloud.uts.gson.TypeAdapter) objConstruct;
        } else if (objConstruct instanceof io.dcloud.uts.gson.TypeAdapterFactory) {
            treeTypeAdapter = ((io.dcloud.uts.gson.TypeAdapterFactory) objConstruct).create(gson, typeToken);
        } else {
            boolean z = objConstruct instanceof io.dcloud.uts.gson.JsonSerializer;
            if (z || (objConstruct instanceof io.dcloud.uts.gson.JsonDeserializer)) {
                treeTypeAdapter = new io.dcloud.uts.gson.internal.bind.TreeTypeAdapter(z ? (io.dcloud.uts.gson.JsonSerializer) objConstruct : null, objConstruct instanceof io.dcloud.uts.gson.JsonDeserializer ? (io.dcloud.uts.gson.JsonDeserializer) objConstruct : null, gson, typeToken, null);
            } else {
                throw new java.lang.IllegalArgumentException("Invalid attempt to bind an instance of " + objConstruct.getClass().getName() + " as a @JsonAdapter for " + typeToken.toString() + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
            }
        }
        return (treeTypeAdapter == null || !jsonAdapter.nullSafe()) ? treeTypeAdapter : treeTypeAdapter.nullSafe();
    }
}
