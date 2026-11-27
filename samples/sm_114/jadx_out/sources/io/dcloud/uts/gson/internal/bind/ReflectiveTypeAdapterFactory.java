package io.dcloud.uts.gson.internal.bind;

/* JADX INFO: loaded from: classes2.dex */
public final class ReflectiveTypeAdapterFactory implements io.dcloud.uts.gson.TypeAdapterFactory {
    private final io.dcloud.uts.gson.internal.reflect.ReflectionAccessor accessor = io.dcloud.uts.gson.internal.reflect.ReflectionAccessor.getInstance();
    private final io.dcloud.uts.gson.internal.ConstructorConstructor constructorConstructor;
    private final io.dcloud.uts.gson.internal.Excluder excluder;
    private final io.dcloud.uts.gson.FieldNamingStrategy fieldNamingPolicy;
    private final io.dcloud.uts.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory jsonAdapterFactory;

    public ReflectiveTypeAdapterFactory(io.dcloud.uts.gson.internal.ConstructorConstructor constructorConstructor, io.dcloud.uts.gson.FieldNamingStrategy fieldNamingStrategy, io.dcloud.uts.gson.internal.Excluder excluder, io.dcloud.uts.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory) {
        this.constructorConstructor = constructorConstructor;
        this.fieldNamingPolicy = fieldNamingStrategy;
        this.excluder = excluder;
        this.jsonAdapterFactory = jsonAdapterAnnotationTypeAdapterFactory;
    }

    public boolean excludeField(java.lang.reflect.Field field, boolean z) {
        return excludeField(field, z, this.excluder);
    }

    static boolean excludeField(java.lang.reflect.Field field, boolean z, io.dcloud.uts.gson.internal.Excluder excluder) {
        return (excluder.excludeClass(field.getType(), z) || excluder.excludeField(field, z)) ? false : true;
    }

    private java.util.List<java.lang.String> getFieldNames(java.lang.reflect.Field field) {
        io.dcloud.uts.gson.annotations.SerializedName serializedName = (io.dcloud.uts.gson.annotations.SerializedName) field.getAnnotation(io.dcloud.uts.gson.annotations.SerializedName.class);
        if (serializedName == null) {
            return java.util.Collections.singletonList(this.fieldNamingPolicy.translateName(field));
        }
        java.lang.String strValue = serializedName.value();
        java.lang.String[] strArrAlternate = serializedName.alternate();
        if (strArrAlternate.length == 0) {
            return java.util.Collections.singletonList(strValue);
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(strArrAlternate.length + 1);
        arrayList.add(strValue);
        for (java.lang.String str : strArrAlternate) {
            arrayList.add(str);
        }
        return arrayList;
    }

    @Override // io.dcloud.uts.gson.TypeAdapterFactory
    public <T> io.dcloud.uts.gson.TypeAdapter<T> create(io.dcloud.uts.gson.Gson gson, io.dcloud.uts.gson.reflect.TypeToken<T> typeToken) {
        java.lang.Class<? super T> rawType = typeToken.getRawType();
        if (java.lang.Object.class.isAssignableFrom(rawType)) {
            return new io.dcloud.uts.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter(this.constructorConstructor.get(typeToken), getBoundFields(gson, typeToken, rawType));
        }
        return null;
    }

    private io.dcloud.uts.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField createBoundField(final io.dcloud.uts.gson.Gson gson, final java.lang.reflect.Field field, java.lang.String str, final io.dcloud.uts.gson.reflect.TypeToken<?> typeToken, boolean z, boolean z2) {
        final boolean zIsPrimitive = io.dcloud.uts.gson.internal.Primitives.isPrimitive(typeToken.getRawType());
        io.dcloud.uts.gson.annotations.JsonAdapter jsonAdapter = (io.dcloud.uts.gson.annotations.JsonAdapter) field.getAnnotation(io.dcloud.uts.gson.annotations.JsonAdapter.class);
        io.dcloud.uts.gson.TypeAdapter<?> typeAdapter = jsonAdapter != null ? this.jsonAdapterFactory.getTypeAdapter(this.constructorConstructor, gson, typeToken, jsonAdapter) : null;
        final boolean z3 = typeAdapter != null;
        if (typeAdapter == null) {
            typeAdapter = gson.getAdapter(typeToken);
        }
        final io.dcloud.uts.gson.TypeAdapter<?> typeAdapter2 = typeAdapter;
        final io.dcloud.uts.JsonNotNull jsonNotNull = (io.dcloud.uts.JsonNotNull) field.getAnnotation(io.dcloud.uts.JsonNotNull.class);
        return new io.dcloud.uts.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField(str, z, z2) { // from class: io.dcloud.uts.gson.internal.bind.ReflectiveTypeAdapterFactory.1
            @Override // io.dcloud.uts.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField
            void write(io.dcloud.uts.gson.stream.JsonWriter jsonWriter, java.lang.Object obj) throws java.lang.IllegalAccessException, java.io.IOException {
                (z3 ? typeAdapter2 : new io.dcloud.uts.gson.internal.bind.TypeAdapterRuntimeTypeWrapper(gson, typeAdapter2, typeToken.getType())).write(jsonWriter, field.get(obj));
            }

            @Override // io.dcloud.uts.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField
            void read(io.dcloud.uts.gson.stream.JsonReader jsonReader, java.lang.Object obj) throws java.lang.IllegalAccessException, java.io.IOException {
                java.lang.Object obj2 = typeAdapter2.read2(jsonReader);
                if (obj2 == null && zIsPrimitive) {
                    return;
                }
                field.set(obj, obj2);
            }

            @Override // io.dcloud.uts.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField
            boolean isShouldNotNull() {
                return jsonNotNull != null;
            }

            @Override // io.dcloud.uts.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField
            public boolean writeField(java.lang.Object obj) throws java.lang.IllegalAccessException, java.io.IOException {
                return this.serialized && field.get(obj) != obj;
            }
        };
    }

    private java.util.Map<java.lang.String, io.dcloud.uts.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField> getBoundFields(io.dcloud.uts.gson.Gson gson, io.dcloud.uts.gson.reflect.TypeToken<?> typeToken, java.lang.Class<?> cls) {
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
        if (!cls.isInterface()) {
            typeToken.getType();
            io.dcloud.uts.gson.reflect.TypeToken<?> typeToken2 = typeToken;
            java.lang.Class<?> rawType = cls;
            while (rawType != java.lang.Object.class) {
                java.lang.reflect.Field[] declaredFields = rawType.getDeclaredFields();
                int length = declaredFields.length;
                int i = 0;
                while (i < length) {
                    java.lang.reflect.Field field = declaredFields[i];
                    boolean zExcludeField = this.excludeField(field, true);
                    boolean zExcludeField2 = this.excludeField(field, false);
                    if (zExcludeField || zExcludeField2) {
                        this.accessor.makeAccessible(field);
                        java.lang.reflect.Type typeResolve = io.dcloud.uts.gson.internal.C$Gson$Types.resolve(typeToken2.getType(), rawType, field.getGenericType());
                        java.util.List<java.lang.String> fieldNames = this.getFieldNames(field);
                        int size = fieldNames.size();
                        io.dcloud.uts.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField boundField = null;
                        int i2 = 0;
                        while (i2 < size) {
                            java.lang.String str = fieldNames.get(i2);
                            if (i2 != 0) {
                                zExcludeField = false;
                            }
                            int i3 = i2;
                            int i4 = size;
                            boolean z = zExcludeField;
                            io.dcloud.uts.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField boundFieldCreateBoundField = this.createBoundField(gson, field, str, io.dcloud.uts.gson.reflect.TypeToken.get(typeResolve), z, zExcludeField2);
                            if (!linkedHashMap.containsKey(str)) {
                                io.dcloud.uts.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField boundField2 = (io.dcloud.uts.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField) linkedHashMap.put(str, boundFieldCreateBoundField);
                                if (boundField == null) {
                                    boundField = boundField2;
                                }
                            }
                            i2 = i3 + 1;
                            this = this;
                            zExcludeField = z;
                            size = i4;
                        }
                    }
                    i++;
                    this = this;
                }
                typeToken2 = io.dcloud.uts.gson.reflect.TypeToken.get(io.dcloud.uts.gson.internal.C$Gson$Types.resolve(typeToken2.getType(), rawType, rawType.getGenericSuperclass()));
                rawType = typeToken2.getRawType();
            }
        }
        return linkedHashMap;
    }

    static abstract class BoundField {
        final boolean deserialized;
        final java.lang.String name;
        final boolean serialized;

        abstract boolean isShouldNotNull();

        abstract void read(io.dcloud.uts.gson.stream.JsonReader jsonReader, java.lang.Object obj) throws java.lang.IllegalAccessException, java.io.IOException;

        abstract void write(io.dcloud.uts.gson.stream.JsonWriter jsonWriter, java.lang.Object obj) throws java.lang.IllegalAccessException, java.io.IOException;

        abstract boolean writeField(java.lang.Object obj) throws java.lang.IllegalAccessException, java.io.IOException;

        protected BoundField(java.lang.String str, boolean z, boolean z2) {
            this.name = str;
            this.serialized = z;
            this.deserialized = z2;
        }
    }

    public static final class Adapter<T> extends io.dcloud.uts.gson.TypeAdapter<T> {
        private final java.util.Map<java.lang.String, io.dcloud.uts.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField> boundFields;
        private final io.dcloud.uts.gson.internal.ObjectConstructor<T> constructor;
        private java.util.Map<java.lang.String, io.dcloud.uts.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField> notReadFields;

        @Override // io.dcloud.uts.gson.TypeAdapter
        public void reset() {
            this.notReadFields = new java.util.HashMap(this.boundFields);
        }

        Adapter(io.dcloud.uts.gson.internal.ObjectConstructor<T> objectConstructor, java.util.Map<java.lang.String, io.dcloud.uts.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField> map) {
            this.constructor = objectConstructor;
            this.boundFields = map;
        }

        @Override // io.dcloud.uts.gson.TypeAdapter
        /* JADX INFO: renamed from: read */
        public T read2(io.dcloud.uts.gson.stream.JsonReader jsonReader) throws java.io.IOException {
            if (jsonReader.peek() == io.dcloud.uts.gson.stream.JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            T tConstruct = this.constructor.construct();
            reset();
            try {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    java.lang.String strNextName = jsonReader.nextName();
                    io.dcloud.uts.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField boundField = this.boundFields.get(strNextName);
                    if (boundField == null || !boundField.deserialized) {
                        jsonReader.skipValue();
                    } else {
                        boundField.read(jsonReader, tConstruct);
                        this.notReadFields.remove(strNextName);
                    }
                }
                jsonReader.endObject();
                if (!this.notReadFields.isEmpty()) {
                    java.util.Iterator<java.util.Map.Entry<java.lang.String, io.dcloud.uts.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField>> it = this.notReadFields.entrySet().iterator();
                    while (it.hasNext()) {
                        io.dcloud.uts.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField value = it.next().getValue();
                        if (value != null && value.isShouldNotNull()) {
                            throw new io.dcloud.uts.gson.JsonParseException("Value of non-nullable member " + value.name + " cannot be null");
                        }
                    }
                }
                return tConstruct;
            } catch (java.lang.IllegalAccessException e) {
                throw new java.lang.AssertionError(e);
            } catch (java.lang.IllegalStateException e2) {
                throw new io.dcloud.uts.gson.JsonSyntaxException(e2);
            }
        }

        @Override // io.dcloud.uts.gson.TypeAdapter
        public void write(io.dcloud.uts.gson.stream.JsonWriter jsonWriter, T t) throws java.io.IOException {
            if (t == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            try {
                for (io.dcloud.uts.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField boundField : this.boundFields.values()) {
                    if (boundField.writeField(t)) {
                        jsonWriter.name(boundField.name);
                        boundField.write(jsonWriter, t);
                    }
                }
                jsonWriter.endObject();
            } catch (java.lang.IllegalAccessException e) {
                throw new java.lang.AssertionError(e);
            }
        }
    }
}
